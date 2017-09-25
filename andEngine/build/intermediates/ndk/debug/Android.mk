LOCAL_PATH := $(call my-dir)
include $(CLEAR_VARS)

LOCAL_MODULE := andengine_shared
LOCAL_LDFLAGS := -Wl,--build-id
LOCAL_SRC_FILES := \
	F:\Projiect\learn_project\liveDataDome\andEngine\src\main\jni\Android.mk \
	F:\Projiect\learn_project\liveDataDome\andEngine\src\main\jni\Application.mk \
	F:\Projiect\learn_project\liveDataDome\andEngine\src\main\jni\build.sh \
	F:\Projiect\learn_project\liveDataDome\andEngine\src\main\jni\src\BufferUtils.cpp \
	F:\Projiect\learn_project\liveDataDome\andEngine\src\main\jni\src\GLES20Fix.c \

LOCAL_C_INCLUDES += F:\Projiect\learn_project\liveDataDome\andEngine\src\main\jni
LOCAL_C_INCLUDES += F:\Projiect\learn_project\liveDataDome\andEngine\src\debug\jni

include $(BUILD_SHARED_LIBRARY)
