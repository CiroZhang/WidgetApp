//#include <jni.h>
//#include <string>
//#include <vector>
//#include <iostream>
//
//using namespace std;
//
//
//extern "C" {
//JNIEXPORT jobject JNICALL Java_com_example_widgetapp_MainActivity_GetData
//    (JNIEnv *, jclass, jstring);
//}
//
//
//extern "C" JNIEXPORT jobject JNICALL Java_com_example_widgetapp_MainActivity_GetData
//    (JNIEnv *env , jclass, jstring str) {
//
//    // Find Class for Vector
//    jclass clsVec = env->FindClass("java/util/Vector");
//
//    // Get its constructor method
//    jmethodID constructor = env->GetMethodID(clsVec, "<init>", "()V");
//
//    // Create new Vector object
//    jobject objVec = env->NewObject(clsVec, constructor);
//
//    // Get addElement method
//    jmethodID vecAdd = env->GetMethodID(clsVec, "addElement", "(Ljava/lang/Object;)V");
//
//    // Add new string (created locally)
//    jstring retStr = env->NewStringUTF("Whatever");
//    env->CallVoidMethod(objVec, vecAdd, retStr);
//
//    // Add string from parameter
//    env->CallVoidMethod(objVec, vecAdd, str);
//
//    // Always release local references.
//    env->DeleteLocalRef(clsVec);
//
//    return objVec;
//}
//
