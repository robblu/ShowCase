#include <jni.h>

JNIEXPORT jstring JNICALL

Java_com_robb_jni_JniInfoMsg_getMsgFromJni(JNIEnv *env, jobject instance) {
    // TODO
    return (*env)->NewStringUTF(env, "你好这是JNI");
}