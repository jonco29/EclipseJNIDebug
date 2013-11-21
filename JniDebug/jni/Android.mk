################################################################################
# JNI make file
# see MainActivity.java, or the top of jni_debug_test.c for instructions on
# generating the function prototypes
################################################################################
LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)
LOCAL_MODULE_TAGS := optional
LOCAL_MODULE    := libjniDebug
LOCAL_SRC_FILES := jni_debug_test.c 
#LOCAL_CFLAGS    := -g
LOCAL_C_INCLUDES := ../bin/classes

LOCAL_LDLIBS := -L$(SYSROOT)/usr/lib -llog 
APP_OPTIM=debug


include $(BUILD_SHARED_LIBRARY)
