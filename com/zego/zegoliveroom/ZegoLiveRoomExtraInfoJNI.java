package com.zego.zegoliveroom;

import com.zego.zegoliveroom.entity.ZegoRoomExtraInfo;

/* loaded from: source-8829756-dex2jar.jar:com/zego/zegoliveroom/ZegoLiveRoomExtraInfoJNI.class */
final class ZegoLiveRoomExtraInfoJNI {
    private static volatile IJniZegoRoomExtraInfoCallback sJNIZegoRoomExtraInfoCallback;

    /* loaded from: source-8829756-dex2jar.jar:com/zego/zegoliveroom/ZegoLiveRoomExtraInfoJNI$IJniZegoRoomExtraInfoCallback.class */
    interface IJniZegoRoomExtraInfoCallback {
        void onRoomExtraInfoUpdated(String str, ZegoRoomExtraInfo[] zegoRoomExtraInfoArr);

        void onSetRoomExtraInfo(int i, String str, int i2, String str2);
    }

    ZegoLiveRoomExtraInfoJNI() {
    }

    public static native void enableRoomExtraInfoCallback(boolean z);

    public static native void logPrint(String str);

    public static void onRoomExtraInfoUpdated(String str, ZegoRoomExtraInfo[] zegoRoomExtraInfoArr) {
        IJniZegoRoomExtraInfoCallback iJniZegoRoomExtraInfoCallback = sJNIZegoRoomExtraInfoCallback;
        if (iJniZegoRoomExtraInfoCallback != null) {
            iJniZegoRoomExtraInfoCallback.onRoomExtraInfoUpdated(str, zegoRoomExtraInfoArr);
        }
    }

    public static void onSetRoomExtraInfo(int i, String str, int i2, String str2) {
        IJniZegoRoomExtraInfoCallback iJniZegoRoomExtraInfoCallback = sJNIZegoRoomExtraInfoCallback;
        if (iJniZegoRoomExtraInfoCallback != null) {
            iJniZegoRoomExtraInfoCallback.onSetRoomExtraInfo(i, str, i2, str2);
        }
    }

    public static native int setRoomExtraInfo(String str, String str2, String str3);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setRoomExtraInfoJNICallback(IJniZegoRoomExtraInfoCallback iJniZegoRoomExtraInfoCallback) {
        sJNIZegoRoomExtraInfoCallback = iJniZegoRoomExtraInfoCallback;
        enableRoomExtraInfoCallback(iJniZegoRoomExtraInfoCallback != null);
    }
}
