#include <string.h>
#include "com_nqy_mycode_jni_Person.h"
#include "jni.h"
/*
 * Class:     drm_hellojni_HelloJNIActivity
 * Method:    helloJni
 * Signature: ()Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_com_nqy_mycode_jni_Person_getName
  (JNIEnv *env, jobject obj)
{
    
    return (*env)->NewStringUTF(env, "Hello jni !!!");
}
