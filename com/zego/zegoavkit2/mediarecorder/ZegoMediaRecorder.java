package com.zego.zegoavkit2.mediarecorder;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import com.zego.zegoavkit2.entities.ZegoPublishStreamQuality;

/* loaded from: source-8829756-dex2jar.jar:com/zego/zegoavkit2/mediarecorder/ZegoMediaRecorder.class */
public class ZegoMediaRecorder implements IZegoMediaRecordCallback2 {
    private volatile IZegoMediaRecordCallbackBase mZegoMediaRecordCallback = null;
    private Handler mHandler = new Handler(Looper.getMainLooper());

    private void setZegoMediaRecordCallbackBase(IZegoMediaRecordCallbackBase iZegoMediaRecordCallbackBase) {
        this.mZegoMediaRecordCallback = iZegoMediaRecordCallbackBase;
        if (iZegoMediaRecordCallbackBase != null) {
            ZegoMediaRecordJNI.setCallback(this);
            ZegoMediaRecordJNI.setMediaRecordCallback(true);
            return;
        }
        ZegoMediaRecordJNI.setCallback(null);
        ZegoMediaRecordJNI.setMediaRecordCallback(false);
    }

    @Override // com.zego.zegoavkit2.mediarecorder.IZegoMediaRecordCallbackBase
    public void onMediaRecord(final int i, final ZegoMediaRecordChannelIndex zegoMediaRecordChannelIndex, final String str) {
        final IZegoMediaRecordCallbackBase iZegoMediaRecordCallbackBase = this.mZegoMediaRecordCallback;
        if (iZegoMediaRecordCallbackBase != null) {
            this.mHandler.post(new Runnable() { // from class: com.zego.zegoavkit2.mediarecorder.ZegoMediaRecorder.1
                @Override // java.lang.Runnable
                public void run() {
                    iZegoMediaRecordCallbackBase.onMediaRecord(i, zegoMediaRecordChannelIndex, str);
                }
            });
        }
    }

    @Override // com.zego.zegoavkit2.mediarecorder.IZegoMediaRecordCallback2
    public void onRecordStatusUpdate(final ZegoMediaRecordChannelIndex zegoMediaRecordChannelIndex, final String str, final long j, final long j2, final ZegoPublishStreamQuality zegoPublishStreamQuality) {
        final IZegoMediaRecordCallbackBase iZegoMediaRecordCallbackBase = this.mZegoMediaRecordCallback;
        if (iZegoMediaRecordCallbackBase != null) {
            this.mHandler.post(new Runnable() { // from class: com.zego.zegoavkit2.mediarecorder.ZegoMediaRecorder.2
                @Override // java.lang.Runnable
                public void run() {
                    IZegoMediaRecordCallbackBase iZegoMediaRecordCallbackBase2 = iZegoMediaRecordCallbackBase;
                    if (iZegoMediaRecordCallbackBase2 instanceof IZegoMediaRecordCallback) {
                        ((IZegoMediaRecordCallback) iZegoMediaRecordCallbackBase2).onRecordStatusUpdate(zegoMediaRecordChannelIndex, str, j, j2);
                    } else if (iZegoMediaRecordCallbackBase2 instanceof IZegoMediaRecordCallback2) {
                        ((IZegoMediaRecordCallback2) iZegoMediaRecordCallbackBase2).onRecordStatusUpdate(zegoMediaRecordChannelIndex, str, j, j2, zegoPublishStreamQuality);
                    }
                }
            });
        }
    }

    public void setZegoMediaRecordCallback(IZegoMediaRecordCallback2 iZegoMediaRecordCallback2) {
        setZegoMediaRecordCallbackBase(iZegoMediaRecordCallback2);
    }

    public void setZegoMediaRecordCallback(IZegoMediaRecordCallback iZegoMediaRecordCallback) {
        setZegoMediaRecordCallbackBase(iZegoMediaRecordCallback);
    }

    public boolean startRecord(ZegoMediaRecordChannelIndex zegoMediaRecordChannelIndex, ZegoMediaRecordType zegoMediaRecordType, Uri uri, boolean z, int i) {
        if (uri == null) {
            return false;
        }
        return startRecord(zegoMediaRecordChannelIndex, zegoMediaRecordType, uri.toString(), z, i);
    }

    public boolean startRecord(ZegoMediaRecordChannelIndex zegoMediaRecordChannelIndex, ZegoMediaRecordType zegoMediaRecordType, Uri uri, boolean z, int i, ZegoMediaRecordFormat zegoMediaRecordFormat) {
        if (uri == null) {
            return false;
        }
        return startRecord(zegoMediaRecordChannelIndex, zegoMediaRecordType, uri.toString(), z, i, zegoMediaRecordFormat);
    }

    public boolean startRecord(ZegoMediaRecordChannelIndex zegoMediaRecordChannelIndex, ZegoMediaRecordType zegoMediaRecordType, Uri uri, boolean z, int i, ZegoMediaRecordFormat zegoMediaRecordFormat, boolean z2) {
        if (uri == null) {
            return false;
        }
        return startRecord(zegoMediaRecordChannelIndex, zegoMediaRecordType, uri.toString(), z, i, zegoMediaRecordFormat, z2);
    }

    public boolean startRecord(ZegoMediaRecordChannelIndex zegoMediaRecordChannelIndex, ZegoMediaRecordType zegoMediaRecordType, String str) {
        if (zegoMediaRecordChannelIndex == null || str == null) {
            return false;
        }
        return ZegoMediaRecordJNI.startRecord(zegoMediaRecordChannelIndex.value(), zegoMediaRecordType.value(), str);
    }

    public boolean startRecord(ZegoMediaRecordChannelIndex zegoMediaRecordChannelIndex, ZegoMediaRecordType zegoMediaRecordType, String str, boolean z, int i) {
        if (zegoMediaRecordChannelIndex == null || str == null) {
            return false;
        }
        return ZegoMediaRecordJNI.startRecordEx(zegoMediaRecordChannelIndex.value(), zegoMediaRecordType.value(), str, z, i, ZegoMediaRecordFormat.FLV.value(), false, "");
    }

    public boolean startRecord(ZegoMediaRecordChannelIndex zegoMediaRecordChannelIndex, ZegoMediaRecordType zegoMediaRecordType, String str, boolean z, int i, ZegoMediaRecordFormat zegoMediaRecordFormat) {
        if (zegoMediaRecordChannelIndex == null || str == null) {
            return false;
        }
        return ZegoMediaRecordJNI.startRecordEx(zegoMediaRecordChannelIndex.value(), zegoMediaRecordType.value(), str, z, i, zegoMediaRecordFormat.value(), false, "");
    }

    public boolean startRecord(ZegoMediaRecordChannelIndex zegoMediaRecordChannelIndex, ZegoMediaRecordType zegoMediaRecordType, String str, boolean z, int i, ZegoMediaRecordFormat zegoMediaRecordFormat, boolean z2) {
        if (zegoMediaRecordChannelIndex == null || str == null) {
            return false;
        }
        return ZegoMediaRecordJNI.startRecordEx(zegoMediaRecordChannelIndex.value(), zegoMediaRecordType.value(), str, z, i, zegoMediaRecordFormat.value(), z2, "");
    }

    public boolean startRecord(ZegoMediaRecordConfig zegoMediaRecordConfig) {
        if (zegoMediaRecordConfig.storageUri == null) {
            return false;
        }
        return ZegoMediaRecordJNI.startRecordEx(zegoMediaRecordConfig.channelIndex.value(), zegoMediaRecordConfig.recordType.value(), zegoMediaRecordConfig.storageUri.toString(), zegoMediaRecordConfig.enableStatusCallback, zegoMediaRecordConfig.interval, zegoMediaRecordConfig.recordFormat.value(), zegoMediaRecordConfig.isFragment, zegoMediaRecordConfig.config);
    }

    public boolean stopRecord(ZegoMediaRecordChannelIndex zegoMediaRecordChannelIndex) {
        if (zegoMediaRecordChannelIndex == null) {
            return false;
        }
        ZegoMediaRecordJNI.stopRecord(zegoMediaRecordChannelIndex.value());
        return true;
    }
}
