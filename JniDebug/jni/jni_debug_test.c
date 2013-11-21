#include <string.h>
#include <jni.h>
#include <android/log.h>
#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>

// when adding a JNI, i do the following steps:
// 1. add  the native call
// 2. add the load library
// 3. build clean -- don't run... you don't have a JNI yet
// 4. create the header file for JNI:
//		cd bin/classes
//		javah -jni com.example.jnidebug.MainActivity
// 		mv com_example_jnidebug_MainActivity.h ../../jni/
// 		implement JNI
#include "com_example_jnidebug_MainActivity.h"

JNIEXPORT jstring JNICALL Java_com_example_jnidebug_MainActivity_getButtonString
  (JNIEnv *env, jobject obj, jint val)
{
    int mVal = val % 3;
    char* str = NULL;
    jstring result = NULL;

    switch (mVal) {
        case 0: 
            str = "ZERO -- pressed once";
            break;
        case 1: 
            str = "ONE -- pressed a second time";
            break;
        case 2:
            str = "TWO -- pressed a third time, i dare you to do it again...";
            break;
        default:
            str = "DEFAULT";
            break;
    }
    result = (*env)->NewStringUTF(env, str);
    return result;
}



