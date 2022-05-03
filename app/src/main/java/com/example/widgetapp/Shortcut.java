package com.example.widgetapp;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Shortcut {
    public enum Type{
        Email, Message,Call,OpenWeb,OpenApp,
        OpenFacebook, SearchFacebook,SendFacebook,ShareFacebook,
        OpenTwitter, SearchTwitter, ShareTwitter,
        OpenWhatsapp, ShareWhatsapp,
        SearchGoogleMap;
    }

    private String name = "Shortcut Name";
    private String typeString;
    private Intent action;
    private ArrayList<String> info = new ArrayList<>();
    private ArrayList<Action> shortcutActions = new ArrayList<>();

    public Shortcut(){}

    public Shortcut(String name, String typeString, ArrayList<Action> actions) {
        this.name = name;
        this.typeString = typeString;
        this.shortcutActions = actions;


//        action = sendFacebook("100003863535616");
//        action = email(new String[]{"oscarboom214@gmail.com"},"hello","hello ocsar");
//        action = shareTwitter(view,"Hello","","@Ciro","cool");

    }

    public void run(View view){
        Type type = Type.valueOf(typeString);
        if (info.isEmpty()){
            System.out.println("Info not set");
        }
        else {
            switch (type) {
                case Email:
                    action = email(info.get(0).split(","), info.get(1), info.get(2));
                    break;
                case Message:
                    action = message(info.get(0));
                    break;
                case Call:
                    action = call(info.get(0));
                    break;
                case OpenWeb:
                    action = openWebsite(info.get(0));
                    break;
                case OpenApp:
                    action = openApp(view, info.get(0));
                    break;

                case OpenFacebook:
                    action = openFacebook(view);
                    break;
                case SearchFacebook:
                    action = searchFacebook(info.get(0));
                    break;
                case SendFacebook:
                    action = sendFacebook(info.get(0));
                    break;
                case ShareFacebook:
                    action = shareFacebook(view, info.get(0));
                    break;

                case OpenTwitter:
                    action = openTwitter(view);

                case SearchTwitter:
                    action = searchTwitter(info.get(0));

                case ShareTwitter:
                    action = shareTwitter(view, info.get(0), "", info.get(1), info.get(2));
                    break;

                case OpenWhatsapp:
                    action = openWhatsapp(view);
                    break;

                case ShareWhatsapp:
                    action = shareWhatsapp(view, info.get(0), info.get(1));
                    break;

                case SearchGoogleMap:
                    action = searchGoogleMaps(info.get(0));
                    break;


                default:
                    break;
            }
            view.getContext().startActivity(action);
        }
    }

    public String getName() {
        return name;
    }
    public Intent getAction(){
        return action;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setInfo(ArrayList<String> info){
        this.info = info;
    }
    public ArrayList<Action> getShortcutActions() {
        return this.shortcutActions;
    }

    //General Android
    public Intent email(String[] addresses, String subject, String text) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_EMAIL, addresses);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, text);
        return Intent.createChooser(intent, "Send Email");

    }
    public Intent message(String number){
        return new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms", number, null));
    }
    public Intent call(String number){
        return new Intent(Intent.ACTION_DIAL,Uri.parse("tel:" + number));
    }
    public Intent openWebsite(String link){
        return new Intent(Intent.ACTION_VIEW,Uri.parse(link));
    }
    public Intent openApp(View view, String app){
        Intent intent = view.getContext().getPackageManager().getLaunchIntentForPackage(app);
        if (intent != null) {
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        }
        else {
            intent = new Intent(Intent.ACTION_VIEW);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.setData(Uri.parse("market://details?id=" + app));
        }
        return intent;
    }

    //Facebook
    public Intent openFacebook(View view){
        return openApp(view,"com.facebook.katana");
    }
    public Intent searchFacebook(String search){
        return new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.facebook.com/search/top?q="+search));
    }
    public Intent sendFacebook(String user){
        Uri uri = Uri.parse("fb-messenger://user/" + user);
        Intent toMessenger= new Intent(Intent.ACTION_VIEW, uri);
        return toMessenger;
    }
    public Intent shareFacebook(View view, String url) {
        boolean facebookAppFound = false;
        Intent shareIntent = new Intent(android.content.Intent.ACTION_SEND);
        shareIntent.setType("text/plain");
        shareIntent.putExtra(Intent.EXTRA_TEXT, url);
        shareIntent.putExtra(Intent.EXTRA_STREAM, Uri.parse(url));

        PackageManager pm = view.getContext().getPackageManager();
        List<ResolveInfo> activityList = pm.queryIntentActivities(shareIntent, 0);
        for (final ResolveInfo app : activityList) {
            if ((app.activityInfo.packageName).contains("com.facebook.katana")) {
                final ActivityInfo activityInfo = app.activityInfo;
                final ComponentName name = new ComponentName(activityInfo.applicationInfo.packageName, activityInfo.name);
                shareIntent.addCategory(Intent.CATEGORY_LAUNCHER);
                shareIntent.setComponent(name);
                facebookAppFound = true;
                break;
            }
        }
        if (!facebookAppFound) {
            String sharerUrl = "https://www.facebook.com/sharer/sharer.php?u=" + url;
            shareIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(sharerUrl));
        }
        return shareIntent;
    }

    //Twitter
    public Intent openTwitter(View view){
        return openApp(view,"com.twitter.android");
    }
    public Intent searchTwitter(String search){
        return new Intent(Intent.ACTION_VIEW,Uri.parse("https://twitter.com/search?q="+search));
    }
    public Intent shareTwitter(View view, String text, String url, String via, String hashtags) {
        StringBuilder tweetUrl = new StringBuilder("https://twitter.com/intent/tweet?text=");
        tweetUrl.append(TextUtils.isEmpty(text) ? urlEncode(" ") : urlEncode(text));
        if (!TextUtils.isEmpty(url)) {
            tweetUrl.append("&url=");
            tweetUrl.append(urlEncode(url));
        }
        if (!TextUtils.isEmpty(hashtags)) {
            tweetUrl.append("&hashtags=");
            tweetUrl.append(urlEncode(hashtags));
        }
        if (!TextUtils.isEmpty(via)) {
            tweetUrl.append("&via=");
            tweetUrl.append(urlEncode(via));
        }
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(tweetUrl.toString()));
        List<ResolveInfo> matches = view.getContext().getPackageManager().queryIntentActivities(intent, 0);
        for (ResolveInfo info : matches) {
            if (info.activityInfo.packageName.toLowerCase().startsWith("com.twitter")) {
                intent.setPackage(info.activityInfo.packageName);
            }
        }
        System.out.println(tweetUrl.toString());
        return intent;
    }

    //Whatsapp
    public Intent openWhatsapp(View view){
        return openApp(view,"com.whatsapp");
    }
    public Intent shareWhatsapp(View view, String text, String url) {
        PackageManager pm = view.getContext().getPackageManager();
        try {

            Intent waIntent = new Intent(Intent.ACTION_SEND);
            waIntent.setType("text/plain");

            PackageInfo info = pm.getPackageInfo("com.whatsapp", PackageManager.GET_META_DATA);

            waIntent.setPackage("com.whatsapp");

            waIntent.putExtra(Intent.EXTRA_TEXT, text + " " + url);
            return Intent.createChooser(waIntent, view.getContext().getString(R.string.share_intent_title));



        } catch (PackageManager.NameNotFoundException e) {
            Toast.makeText(view.getContext(), view.getContext().getString(R.string.share_whatsapp_not_instaled),
                    Toast.LENGTH_SHORT).show();
            return null;
        }
    }

    //Zoom
    public Intent openZoom(View view){
        return openApp(view,"us.zoom.videomeetings");
    }
    public Intent scheduleZoom(){
        return new Intent(Intent.ACTION_VIEW,Uri.parse("https://us05web.zoom.us/meeting/schedule"));
    }
    public Intent joinZoom(String number){
        return new Intent(Intent.ACTION_VIEW,Uri.parse("https://zoom.us/j/"+number));
    }

    //Slice
    public Intent openSlice(View view){
        return openApp(view,"com.example.billsplit_app");
    }

    //Google
    public Intent searchGoogle(String search){
        return new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.google.com/search?q="+search));
    }
    public Intent searchGoogleMaps(String search){
        return new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.google.com/maps/search/"+search));
    }
    public Intent searchYoutube(String search){
        return new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.youtube.com/results?search_query="+search));
    }
    public Intent openGmail(){
        return new Intent(Intent.ACTION_VIEW,Uri.parse(" https://mail.google.com/mail/u/0/"));
    };

    //Wechat

    





    public static String urlEncode(String s) {
        try {
            return URLEncoder.encode(s, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            Log.wtf("wtf", "UTF-8 should always be supported", e);
            throw new RuntimeException("URLEncoder.encode() failed for " + s);
        }
    }



}
