#include <jni.h>
#include <string>

extern "C"
JNIEXPORT jstring JNICALL
Java_com_test_eltivo_testndk_MainActivity_stringFromJNI(
        JNIEnv *env,
        jobject /* this */) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}

extern "C"
JNIEXPORT jint JNICALL
Java_com_test_eltivo_testndk_MainActivity_addNum(
        JNIEnv *env,
        jobject jobj,
        jint a, jint b) {
    jclass jclazz = env->GetObjectClass(jobj);
    jfieldID fid = env->GetFieldID(jclazz, "num", "I");
    jint num = env->GetIntField(jobj, fid);
    num = num + a + b;
    return num;
}

extern "C"
JNIEXPORT void JNICALL
Java_com_test_eltivo_testndk_MainActivity_accessPublicMethod(
        JNIEnv *env,
        jobject jobj) {
    jclass jclazz = env->GetObjectClass(jobj);
    jmethodID mid = env->GetMethodID(jclazz, "setSex", "(Ljava/lang/String;)V");
    char sex[10] = "male";
    jstring jsex = env->NewStringUTF(sex);
    env->CallVoidMethod(jobj, mid, jsex);
}
