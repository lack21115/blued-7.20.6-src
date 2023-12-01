package com.zego.zegoavkit2.mediarecorder;

import com.zego.zegoavkit2.entities.ZegoPublishStreamQuality;

/* loaded from: source-8829756-dex2jar.jar:com/zego/zegoavkit2/mediarecorder/ZegoMediaRecordJNI.class */
final class ZegoMediaRecordJNI {
    private static volatile IZegoMediaRecordCallback2 sCallback;

    ZegoMediaRecordJNI() {
    }

    static void onMediaRecord(int i, int i2, String str) {
        IZegoMediaRecordCallback2 iZegoMediaRecordCallback2 = sCallback;
        if (iZegoMediaRecordCallback2 != null) {
            iZegoMediaRecordCallback2.onMediaRecord(i, ZegoMediaRecordChannelIndex.values()[i2], str);
        }
    }

    static void onRecordStatusUpdate(int i, String str, long j, long j2, ZegoPublishStreamQuality zegoPublishStreamQuality) {
        IZegoMediaRecordCallback2 iZegoMediaRecordCallback2 = sCallback;
        if (iZegoMediaRecordCallback2 != null) {
            iZegoMediaRecordCallback2.onRecordStatusUpdate(ZegoMediaRecordChannelIndex.values()[i], str, j, j2, zegoPublishStreamQuality);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setCallback(IZegoMediaRecordCallback2 iZegoMediaRecordCallback2) {
        sCallback = iZegoMediaRecordCallback2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native void setMediaRecordCallback(boolean z);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native boolean startRecord(int i, int i2, String str);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native boolean startRecordEx(int i, int i2, String str, boolean z, int i3, int i4, boolean z2, String str2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native void stopRecord(int i);
}
