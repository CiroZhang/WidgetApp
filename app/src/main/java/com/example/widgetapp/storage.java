package com.example.widgetapp;

import android.annotation.SuppressLint;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class storage {
    private static String fileName;
    private static JSONObject data;

    public storage() throws JSONException {
        fileName = "datas.json";
        data = readDataFile();
        System.out.println(data);
    }

    public static void setSomething(String item, String content) throws JSONException {
        data.remove(item);
        data.put(item, content);
    }

    public static JSONObject getDefault() throws JSONException {
        JSONObject data = new JSONObject();
        data.put("Name","");
        data.put("App Name","");
        data.put("Type String","");

        return data;
    }

    public static JSONObject readDataFile() throws JSONException {

        String ret = "";

        try {
            File file = new File("/data/data/com.example.widgetapp/datas.json");
            InputStream inputStream = new FileInputStream(file);

            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String receiveString = "";
            StringBuilder stringBuilder = new StringBuilder();

            while ( (receiveString = bufferedReader.readLine()) != null ) {
                stringBuilder.append(receiveString);
            }

            inputStream.close();
            ret = stringBuilder.toString();
        }
        catch (FileNotFoundException e) {
            Log.e("login activity", "File not found: " + e.toString());
            return getDefault();
        } catch (IOException e) {
            Log.e("login activity", "Can not read file: " + e.toString());
        }

        return new JSONObject(ret.toString());
    }

    public static void saveData() {
        @SuppressLint("SdCardPath") File path = new File("/data/user/0/com.example.widgetapp");
        try {
            FileOutputStream writer = new FileOutputStream(new File(path, fileName));
            writer.write(data.toString().getBytes());
            writer.flush();
            writer.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }




}
