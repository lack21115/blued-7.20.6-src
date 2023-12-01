package com.zego.zegoliveroom;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.Log;
import com.zego.zegoavkit2.ZegoStreamExtraPlayInfo;
import com.zego.zegoavkit2.entities.ZegoStreamRelayCDNInfo;
import com.zego.zegoavkit2.mixstream.ZegoMixStreamInfo;
import com.zego.zegoliveroom.entity.ZegoAudioAuxDataConfig;
import com.zego.zegoliveroom.entity.ZegoAudioFrame;
import com.zego.zegoliveroom.entity.ZegoBigRoomMessage;
import com.zego.zegoliveroom.entity.ZegoExtPrepSet;
import com.zego.zegoliveroom.entity.ZegoPlayStats;
import com.zego.zegoliveroom.entity.ZegoPlayStreamQuality;
import com.zego.zegoliveroom.entity.ZegoPublishStreamQuality;
import com.zego.zegoliveroom.entity.ZegoRoomInfo;
import com.zego.zegoliveroom.entity.ZegoRoomMessage;
import com.zego.zegoliveroom.entity.ZegoStreamInfo;
import com.zego.zegoliveroom.entity.ZegoUser;
import com.zego.zegoliveroom.entity.ZegoUserState;
import com.zego.zegoliveroom.utils.SoLoadUtil;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/zego/zegoliveroom/ZegoLiveRoomJNI.class */
public final class ZegoLiveRoomJNI {
    private static volatile boolean hasInitSuccess;
    private static volatile IJniZegoIMCallback sJNIZegoIMCallback;
    private static volatile IJniZegoLiveRoomCallback sJNIZegoLiveRoomCallback;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/zego/zegoliveroom/ZegoLiveRoomJNI$IJniZegoIMCallback.class */
    public interface IJniZegoIMCallback {
        void onRecvBigRoomMessage(String str, ZegoBigRoomMessage[] zegoBigRoomMessageArr);

        void onRecvRoomMessage(String str, ZegoRoomMessage[] zegoRoomMessageArr);

        void onSendBigRoomMessage(int i, String str, int i2, String str2);

        void onSendRoomMessage(int i, String str, int i2, long j);

        void onUpdateOnlineCount(String str, int i);

        void onUserUpdate(ZegoUserState[] zegoUserStateArr, int i, String str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/zego/zegoliveroom/ZegoLiveRoomJNI$IJniZegoLiveRoomCallback.class */
    public interface IJniZegoLiveRoomCallback {
        void onAVEngineStart();

        void onAVEngineStop();

        void onAlignedAudioAuxDataCallback(ZegoAudioFrame zegoAudioFrame, int i);

        ZegoAudioFrame onAudioPostp(ZegoAudioFrame zegoAudioFrame, String str);

        ZegoAudioFrame onAudioPrep(ZegoAudioFrame zegoAudioFrame);

        void onAudioPrepVADStateUpdate(int i);

        ZegoAudioFrame onAudioProc(ZegoAudioFrame zegoAudioFrame);

        void onAudioRecordCallback(byte[] bArr, int i, int i2, int i3, int i4);

        void onAudioRouteChange(int i);

        void onCaptureAudioFirstFrame();

        void onCaptureVideoFirstFrame();

        void onCaptureVideoFirstFrame(int i);

        void onCaptureVideoSizeChanged(int i, int i2);

        void onCaptureVideoSizeChanged(int i, int i2, int i3);

        void onCapturedAudioVADStateUpdate(int i);

        void onCustomCommand(int i, int i2, String str);

        void onDeviceError(String str, int i);

        void onDisconnect(int i, String str);

        void onEndJoinLive(int i, int i2, String str);

        void onExperimentalAPICallback(String str);

        void onInitSDK(int i);

        void onInviteJoinLiveRequest(int i, String str, String str2, String str3);

        void onInviteJoinLiveResponse(int i, String str, String str2, int i2);

        void onJoinLiveRequest(int i, String str, String str2, String str3);

        void onJoinLiveResponse(int i, String str, String str2, int i2);

        void onKickOut(int i, String str, String str2);

        void onLiveEvent(int i, HashMap<String, String> hashMap);

        void onLogHook(String str);

        void onLogUploadResult(int i);

        void onLogWillOverwrite();

        void onLoginRoom(int i, String str, ZegoStreamInfo[] zegoStreamInfoArr);

        void onNetTypeChange(int i);

        void onNetworkQuality(String str, int i, int i2);

        void onPlayQualityUpdate(String str, ZegoPlayStreamQuality zegoPlayStreamQuality);

        void onPlayStateUpdate(int i, String str);

        void onPlayStatsUpdate(ZegoPlayStats zegoPlayStats);

        void onPlayVideoSuperResolutionUpdate(String str, int i, int i2);

        void onPreviewSnapshot(int i, Bitmap bitmap);

        void onPreviewSnapshot(Bitmap bitmap);

        void onPreviewVideoFirstFrame(int i);

        void onPublishQulityUpdate(String str, ZegoPublishStreamQuality zegoPublishStreamQuality);

        void onPublishStateUpdate(int i, String str, HashMap<String, Object> hashMap);

        void onReconnect(int i, String str);

        void onRecvCustomCommand(String str, String str2, String str3, String str4);

        void onRecvEndJoinLiveCommand(String str, String str2, String str3);

        void onRecvRealtimeSequentialData(ByteBuffer byteBuffer, String str);

        void onRecvRemoteAudioFirstFrame(String str);

        void onRecvRemoteVideoFirstFrame(String str);

        void onRelayCDNStateUpdate(ZegoStreamRelayCDNInfo[] zegoStreamRelayCDNInfoArr, String str);

        void onRemoteCameraStatusUpdate(String str, int i, int i2);

        void onRemoteMicStatusUpdate(String str, int i, int i2);

        void onRemoteSpeakerStatusUpdate(String str, int i, int i2);

        void onRenderRemoteVideoFirstFrame(String str);

        void onRoomInfoUpdated(ZegoRoomInfo zegoRoomInfo, String str);

        void onRunLoopObserveCallback(long j, int i, int i2, int i3, int i4);

        void onSendLocalAudioFirstFrame(int i);

        void onSendLocalVideoFirstFrame(int i);

        void onSendRealtimeSequentialData(int i, int i2);

        void onSnapshot(Bitmap bitmap, String str);

        void onStreamEvent(int i, String str, HashMap<String, String> hashMap);

        void onStreamExtraInfoUpdated(ZegoStreamInfo[] zegoStreamInfoArr, String str);

        void onStreamUpdated(int i, ZegoStreamInfo[] zegoStreamInfoArr, String str);

        void onTempBroken(int i, String str);

        void onTokenWillExpired(String str, int i);

        void onUpdatePublishTargetState(int i, String str, int i2);

        void onVideoDecoderError(int i, int i2, String str);

        void onVideoEncoderChanged(int i, int i2, int i3);

        void onVideoEncoderError(int i, int i2, int i3);

        void onVideoSizeChanged(String str, int i, int i2);
    }

    static {
        try {
            System.loadLibrary(ZegoSdkInfo.LIBRARY_NAME);
            hasInitSuccess = true;
        } catch (UnsatisfiedLinkError e) {
            Log.e("Java_ZegoLiveRoom", "load ZegoLiveRoom native library failed", e);
            hasInitSuccess = false;
        }
    }

    ZegoLiveRoomJNI() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native int activateAllAudioPlayStream(boolean z);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native int activateAllVideoPlayStream(boolean z);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native int activateAudioPlayStream(String str, boolean z);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native int activateVideoPlayStream(String str, boolean z, int i);

    public static native int addPublishTarget(String str, String str2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native int callExperimentalAPI(String str);

    public static native int deletePublishTarget(String str, String str2);

    public static native void enableAEC(boolean z);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native void enableAECWhenHeadsetDetected(boolean z);

    public static native void enableAGC(boolean z);

    public static native void enableAlignedAudioAuxData(boolean z, ZegoAudioAuxDataConfig zegoAudioAuxDataConfig);

    public static native void enableAudioPostp(boolean z, String str);

    public static native void enableAudioPrepVADStableStateMonitor(boolean z, int i);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native void enableAudioRouteCallback(boolean z);

    public static native void enableAudioVADStableStateCallback(boolean z);

    public static native boolean enableAux(boolean z);

    public static native boolean enableBeautifying(int i, int i2);

    public static native boolean enableCamera(boolean z, int i);

    public static native boolean enableCaptureMirror(boolean z, int i);

    public static native void enableCapturedAudioVADStableStateMonitor(boolean z, int i);

    public static native void enableCheckPoc(boolean z);

    public static native void enableDTX(boolean z);

    public static native boolean enableH265EncodeFallback(boolean z);

    public static native boolean enableLoopback(boolean z);

    public static native boolean enableMic(boolean z);

    public static native boolean enableMicDevice(boolean z);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native void enableNetTypeCallback(boolean z);

    public static native boolean enableNoiseSuppress(boolean z);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native boolean enablePlayVirtualStereo(boolean z, int i, String str);

    public static native boolean enablePreviewMirror(boolean z, int i);

    public static native boolean enableRateControl(boolean z, int i);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native void enableRealtimeSequentialDataCallback(boolean z);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native void enableRunLoopObserveCallback(boolean z);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native void enableScreenCaptureEncodeOptimization(boolean z, int i);

    public static native boolean enableSelectedAudioRecord(int i, int i2, int i3);

    public static native boolean enableSpeaker(boolean z);

    public static native boolean enableTorch(boolean z, int i);

    public static native void enableTrafficControl(int i, boolean z, int i2);

    public static native boolean enableTransientNoiseSuppress(boolean z);

    public static native void enableVAD(boolean z);

    public static native void enableVideoSuperResolution(String str, boolean z);

    public static native boolean enableViewMirror(boolean z, String str);

    public static native int endJoinLive(String str, String str2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int ensureSoLoaded(Context context, String str) {
        int i;
        if (hasInitSuccess || TextUtils.isEmpty(str)) {
            i = 0;
        } else {
            hasInitSuccess = SoLoadUtil.loadSpecialLibrary(str, context);
            i = hasInitSuccess ? 1 : -1;
        }
        if (!hasInitSuccess) {
            hasInitSuccess = SoLoadUtil.loadSoFile("libZegoLiveRoom.so", context);
            if (hasInitSuccess) {
                return 2;
            }
            i = -2;
        }
        return i;
    }

    public static native int getAudioRouteType();

    public static native float getCaptureSoundLevel();

    public static native int getMaxPlayChannelCount();

    public static native int getMaxPublishChannelCount();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native String getServiceUrl(String str);

    public static native float getSoundLevelOfStream(String str);

    public static native ZegoUser getUserByStreamID(String str);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native String getVideoCodecCapabilityList();

    public static native boolean initSDK(int i, byte[] bArr, Context context, ClassLoader classLoader);

    public static native void initVideoSuperResolution();

    public static native int inviteJoinLive(String str, String str2);

    public static native int isVideoDecoderSupported(int i, int i2);

    public static native int isVideoEncoderSupported(int i, int i2);

    public static native void logPrint(String str);

    public static native void logPrintVerbose(String str);

    public static native boolean loginRoom(String str, String str2, int i);

    public static native boolean logoutRoom(String str);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native int muteAudioPublish(boolean z, int i);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native int muteVideoPublish(boolean z, int i);

    public static void onAVEngineStart() {
        IJniZegoLiveRoomCallback iJniZegoLiveRoomCallback = sJNIZegoLiveRoomCallback;
        if (iJniZegoLiveRoomCallback != null) {
            iJniZegoLiveRoomCallback.onAVEngineStart();
        }
    }

    public static void onAVEngineStop() {
        IJniZegoLiveRoomCallback iJniZegoLiveRoomCallback = sJNIZegoLiveRoomCallback;
        if (iJniZegoLiveRoomCallback != null) {
            iJniZegoLiveRoomCallback.onAVEngineStop();
        }
    }

    public static void onAlignedAudioAuxDataCallback(ZegoAudioFrame zegoAudioFrame, int i) {
        IJniZegoLiveRoomCallback iJniZegoLiveRoomCallback = sJNIZegoLiveRoomCallback;
        if (iJniZegoLiveRoomCallback != null) {
            iJniZegoLiveRoomCallback.onAlignedAudioAuxDataCallback(zegoAudioFrame, i);
        }
    }

    public static ZegoAudioFrame onAudioPostp(ZegoAudioFrame zegoAudioFrame, String str) {
        IJniZegoLiveRoomCallback iJniZegoLiveRoomCallback = sJNIZegoLiveRoomCallback;
        ZegoAudioFrame zegoAudioFrame2 = zegoAudioFrame;
        if (iJniZegoLiveRoomCallback != null) {
            zegoAudioFrame2 = iJniZegoLiveRoomCallback.onAudioPostp(zegoAudioFrame, str);
        }
        return zegoAudioFrame2;
    }

    public static ZegoAudioFrame onAudioPrepNew(ZegoAudioFrame zegoAudioFrame) {
        IJniZegoLiveRoomCallback iJniZegoLiveRoomCallback = sJNIZegoLiveRoomCallback;
        ZegoAudioFrame zegoAudioFrame2 = zegoAudioFrame;
        if (iJniZegoLiveRoomCallback != null) {
            zegoAudioFrame2 = iJniZegoLiveRoomCallback.onAudioPrep(zegoAudioFrame);
        }
        return zegoAudioFrame2;
    }

    public static void onAudioPrepVADStateUpdate(int i) {
        IJniZegoLiveRoomCallback iJniZegoLiveRoomCallback = sJNIZegoLiveRoomCallback;
        if (iJniZegoLiveRoomCallback != null) {
            iJniZegoLiveRoomCallback.onAudioPrepVADStateUpdate(i);
        }
    }

    public static ZegoAudioFrame onAudioProc(ZegoAudioFrame zegoAudioFrame) {
        IJniZegoLiveRoomCallback iJniZegoLiveRoomCallback = sJNIZegoLiveRoomCallback;
        ZegoAudioFrame zegoAudioFrame2 = zegoAudioFrame;
        if (iJniZegoLiveRoomCallback != null) {
            zegoAudioFrame2 = iJniZegoLiveRoomCallback.onAudioProc(zegoAudioFrame);
        }
        return zegoAudioFrame2;
    }

    public static void onAudioRecordCallback(byte[] bArr, int i, int i2, int i3, int i4) {
        IJniZegoLiveRoomCallback iJniZegoLiveRoomCallback = sJNIZegoLiveRoomCallback;
        if (iJniZegoLiveRoomCallback != null) {
            iJniZegoLiveRoomCallback.onAudioRecordCallback(bArr, i, i2, i3, i4);
        }
    }

    public static void onAudioRouteChange(int i) {
        IJniZegoLiveRoomCallback iJniZegoLiveRoomCallback = sJNIZegoLiveRoomCallback;
        if (iJniZegoLiveRoomCallback != null) {
            iJniZegoLiveRoomCallback.onAudioRouteChange(i);
        }
    }

    public static void onCaptureAudioFirstFrame() {
        IJniZegoLiveRoomCallback iJniZegoLiveRoomCallback = sJNIZegoLiveRoomCallback;
        if (iJniZegoLiveRoomCallback != null) {
            iJniZegoLiveRoomCallback.onCaptureAudioFirstFrame();
        }
    }

    public static void onCaptureVideoFirstFrame() {
        IJniZegoLiveRoomCallback iJniZegoLiveRoomCallback = sJNIZegoLiveRoomCallback;
        if (iJniZegoLiveRoomCallback != null) {
            iJniZegoLiveRoomCallback.onCaptureVideoFirstFrame();
        }
    }

    public static void onCaptureVideoFirstFrame(int i) {
        IJniZegoLiveRoomCallback iJniZegoLiveRoomCallback = sJNIZegoLiveRoomCallback;
        if (iJniZegoLiveRoomCallback != null) {
            iJniZegoLiveRoomCallback.onCaptureVideoFirstFrame(i);
        }
    }

    public static void onCaptureVideoSizeChanged(int i, int i2) {
        IJniZegoLiveRoomCallback iJniZegoLiveRoomCallback = sJNIZegoLiveRoomCallback;
        if (iJniZegoLiveRoomCallback != null) {
            iJniZegoLiveRoomCallback.onCaptureVideoSizeChanged(i, i2);
        }
    }

    public static void onCaptureVideoSizeChanged(int i, int i2, int i3) {
        IJniZegoLiveRoomCallback iJniZegoLiveRoomCallback = sJNIZegoLiveRoomCallback;
        if (iJniZegoLiveRoomCallback != null) {
            iJniZegoLiveRoomCallback.onCaptureVideoSizeChanged(i, i2, i3);
        }
    }

    public static void onCapturedAudioVADStateUpdate(int i) {
        IJniZegoLiveRoomCallback iJniZegoLiveRoomCallback = sJNIZegoLiveRoomCallback;
        if (iJniZegoLiveRoomCallback != null) {
            iJniZegoLiveRoomCallback.onCapturedAudioVADStateUpdate(i);
        }
    }

    public static void onCustomCommand(int i, int i2, String str) {
        IJniZegoLiveRoomCallback iJniZegoLiveRoomCallback = sJNIZegoLiveRoomCallback;
        if (iJniZegoLiveRoomCallback != null) {
            iJniZegoLiveRoomCallback.onCustomCommand(i, i2, str);
        }
    }

    public static void onDeviceError(String str, int i) {
        IJniZegoLiveRoomCallback iJniZegoLiveRoomCallback = sJNIZegoLiveRoomCallback;
        if (iJniZegoLiveRoomCallback != null) {
            iJniZegoLiveRoomCallback.onDeviceError(str, i);
        }
    }

    public static void onDisconnect(int i, String str) {
        IJniZegoLiveRoomCallback iJniZegoLiveRoomCallback = sJNIZegoLiveRoomCallback;
        if (iJniZegoLiveRoomCallback != null) {
            iJniZegoLiveRoomCallback.onDisconnect(i, str);
        }
    }

    public static void onEndJoinLive(int i, int i2, String str) {
        IJniZegoLiveRoomCallback iJniZegoLiveRoomCallback = sJNIZegoLiveRoomCallback;
        if (iJniZegoLiveRoomCallback != null) {
            iJniZegoLiveRoomCallback.onEndJoinLive(i, i2, str);
        }
    }

    public static void onExperimentalAPICallback(String str) {
        IJniZegoLiveRoomCallback iJniZegoLiveRoomCallback = sJNIZegoLiveRoomCallback;
        if (iJniZegoLiveRoomCallback != null) {
            iJniZegoLiveRoomCallback.onExperimentalAPICallback(str);
        }
    }

    public static void onInitSDK(int i) {
        IJniZegoLiveRoomCallback iJniZegoLiveRoomCallback = sJNIZegoLiveRoomCallback;
        if (iJniZegoLiveRoomCallback != null) {
            iJniZegoLiveRoomCallback.onInitSDK(i);
        }
    }

    public static void onInviteJoinLiveRequest(int i, String str, String str2, String str3) {
        IJniZegoLiveRoomCallback iJniZegoLiveRoomCallback = sJNIZegoLiveRoomCallback;
        if (iJniZegoLiveRoomCallback != null) {
            iJniZegoLiveRoomCallback.onInviteJoinLiveRequest(i, str, str2, str3);
        }
    }

    public static void onInviteJoinLiveResponse(int i, String str, String str2, int i2) {
        IJniZegoLiveRoomCallback iJniZegoLiveRoomCallback = sJNIZegoLiveRoomCallback;
        if (iJniZegoLiveRoomCallback != null) {
            iJniZegoLiveRoomCallback.onInviteJoinLiveResponse(i, str, str2, i2);
        }
    }

    public static void onJoinLiveRequest(int i, String str, String str2, String str3) {
        IJniZegoLiveRoomCallback iJniZegoLiveRoomCallback = sJNIZegoLiveRoomCallback;
        if (iJniZegoLiveRoomCallback != null) {
            iJniZegoLiveRoomCallback.onJoinLiveRequest(i, str, str2, str3);
        }
    }

    public static void onJoinLiveResponse(int i, String str, String str2, int i2) {
        IJniZegoLiveRoomCallback iJniZegoLiveRoomCallback = sJNIZegoLiveRoomCallback;
        if (iJniZegoLiveRoomCallback != null) {
            iJniZegoLiveRoomCallback.onJoinLiveResponse(i, str, str2, i2);
        }
    }

    public static void onKickOut(int i, String str, String str2) {
        IJniZegoLiveRoomCallback iJniZegoLiveRoomCallback = sJNIZegoLiveRoomCallback;
        if (iJniZegoLiveRoomCallback != null) {
            iJniZegoLiveRoomCallback.onKickOut(i, str, str2);
        }
    }

    public static void onLiveEvent(int i, String[] strArr, String[] strArr2) {
        IJniZegoLiveRoomCallback iJniZegoLiveRoomCallback = sJNIZegoLiveRoomCallback;
        if (iJniZegoLiveRoomCallback == null) {
            return;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        int length = strArr.length <= strArr2.length ? strArr.length : strArr2.length;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= length) {
                iJniZegoLiveRoomCallback.onLiveEvent(i, hashMap);
                return;
            } else {
                hashMap.put(strArr[i3], strArr2[i3]);
                i2 = i3 + 1;
            }
        }
    }

    public static void onLogHook(String str) {
        IJniZegoLiveRoomCallback iJniZegoLiveRoomCallback = sJNIZegoLiveRoomCallback;
        if (iJniZegoLiveRoomCallback != null) {
            iJniZegoLiveRoomCallback.onLogHook(str);
        }
    }

    public static void onLogUploadResult(int i) {
        IJniZegoLiveRoomCallback iJniZegoLiveRoomCallback = sJNIZegoLiveRoomCallback;
        if (iJniZegoLiveRoomCallback != null) {
            iJniZegoLiveRoomCallback.onLogUploadResult(i);
        }
    }

    public static void onLogWillOverwrite() {
        IJniZegoLiveRoomCallback iJniZegoLiveRoomCallback = sJNIZegoLiveRoomCallback;
        if (iJniZegoLiveRoomCallback != null) {
            iJniZegoLiveRoomCallback.onLogWillOverwrite();
        }
    }

    public static void onLoginRoom(int i, String str, ZegoStreamInfo[] zegoStreamInfoArr, long j) {
        IJniZegoLiveRoomCallback iJniZegoLiveRoomCallback = sJNIZegoLiveRoomCallback;
        if (iJniZegoLiveRoomCallback != null) {
            iJniZegoLiveRoomCallback.onLoginRoom(i, str, zegoStreamInfoArr);
        }
    }

    public static void onNetTypeChange(int i) {
        IJniZegoLiveRoomCallback iJniZegoLiveRoomCallback = sJNIZegoLiveRoomCallback;
        if (iJniZegoLiveRoomCallback != null) {
            iJniZegoLiveRoomCallback.onNetTypeChange(i);
        }
    }

    public static void onNetworkQuality(String str, int i, int i2) {
        IJniZegoLiveRoomCallback iJniZegoLiveRoomCallback = sJNIZegoLiveRoomCallback;
        if (iJniZegoLiveRoomCallback != null) {
            iJniZegoLiveRoomCallback.onNetworkQuality(str, i, i2);
        }
    }

    public static void onPlayQualityUpdate(String str, ZegoPlayStreamQuality zegoPlayStreamQuality) {
        IJniZegoLiveRoomCallback iJniZegoLiveRoomCallback = sJNIZegoLiveRoomCallback;
        if (iJniZegoLiveRoomCallback != null) {
            iJniZegoLiveRoomCallback.onPlayQualityUpdate(str, zegoPlayStreamQuality);
        }
    }

    public static void onPlayStateUpdate(int i, String str) {
        IJniZegoLiveRoomCallback iJniZegoLiveRoomCallback = sJNIZegoLiveRoomCallback;
        if (iJniZegoLiveRoomCallback != null) {
            iJniZegoLiveRoomCallback.onPlayStateUpdate(i, str);
        }
    }

    public static void onPlayStatsUpdate(ZegoPlayStats zegoPlayStats) {
        IJniZegoLiveRoomCallback iJniZegoLiveRoomCallback = sJNIZegoLiveRoomCallback;
        if (iJniZegoLiveRoomCallback != null) {
            iJniZegoLiveRoomCallback.onPlayStatsUpdate(zegoPlayStats);
        }
    }

    public static void onPlayVideoSuperResolutionUpdate(String str, int i, int i2) {
        IJniZegoLiveRoomCallback iJniZegoLiveRoomCallback = sJNIZegoLiveRoomCallback;
        if (iJniZegoLiveRoomCallback != null) {
            iJniZegoLiveRoomCallback.onPlayVideoSuperResolutionUpdate(str, i, i2);
        }
    }

    public static void onPreviewSnapshot(int i, Bitmap bitmap) {
        IJniZegoLiveRoomCallback iJniZegoLiveRoomCallback = sJNIZegoLiveRoomCallback;
        if (iJniZegoLiveRoomCallback != null) {
            iJniZegoLiveRoomCallback.onPreviewSnapshot(i, bitmap);
        }
    }

    public static void onPreviewSnapshot(Bitmap bitmap) {
        IJniZegoLiveRoomCallback iJniZegoLiveRoomCallback = sJNIZegoLiveRoomCallback;
        if (iJniZegoLiveRoomCallback != null) {
            iJniZegoLiveRoomCallback.onPreviewSnapshot(bitmap);
        }
    }

    public static void onPreviewVideoFirstFrame(int i) {
        IJniZegoLiveRoomCallback iJniZegoLiveRoomCallback = sJNIZegoLiveRoomCallback;
        if (iJniZegoLiveRoomCallback != null) {
            iJniZegoLiveRoomCallback.onPreviewVideoFirstFrame(i);
        }
    }

    public static void onPublishQulityUpdate(String str, ZegoPublishStreamQuality zegoPublishStreamQuality) {
        IJniZegoLiveRoomCallback iJniZegoLiveRoomCallback = sJNIZegoLiveRoomCallback;
        if (iJniZegoLiveRoomCallback != null) {
            iJniZegoLiveRoomCallback.onPublishQulityUpdate(str, zegoPublishStreamQuality);
        }
    }

    public static void onPublishStateUpdate(int i, String str, String[] strArr, String[] strArr2, String[] strArr3) {
        IJniZegoLiveRoomCallback iJniZegoLiveRoomCallback = sJNIZegoLiveRoomCallback;
        if (iJniZegoLiveRoomCallback != null) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("streamID", str);
            hashMap.put("rtmpList", strArr);
            hashMap.put("flvList", strArr2);
            hashMap.put("hlsList", strArr3);
            iJniZegoLiveRoomCallback.onPublishStateUpdate(i, str, hashMap);
        }
    }

    public static void onReconnect(int i, String str) {
        IJniZegoLiveRoomCallback iJniZegoLiveRoomCallback = sJNIZegoLiveRoomCallback;
        if (iJniZegoLiveRoomCallback != null) {
            iJniZegoLiveRoomCallback.onReconnect(i, str);
        }
    }

    public static void onRecvBigRoomMessage(String str, ZegoBigRoomMessage[] zegoBigRoomMessageArr) {
        IJniZegoIMCallback iJniZegoIMCallback = sJNIZegoIMCallback;
        if (iJniZegoIMCallback != null) {
            iJniZegoIMCallback.onRecvBigRoomMessage(str, zegoBigRoomMessageArr);
        }
    }

    public static void onRecvCustomCommand(String str, String str2, String str3, String str4) {
        IJniZegoLiveRoomCallback iJniZegoLiveRoomCallback = sJNIZegoLiveRoomCallback;
        if (iJniZegoLiveRoomCallback != null) {
            iJniZegoLiveRoomCallback.onRecvCustomCommand(str, str2, str3, str4);
        }
    }

    public static void onRecvEndJoinLiveCommand(String str, String str2, String str3) {
        IJniZegoLiveRoomCallback iJniZegoLiveRoomCallback = sJNIZegoLiveRoomCallback;
        if (iJniZegoLiveRoomCallback != null) {
            iJniZegoLiveRoomCallback.onRecvEndJoinLiveCommand(str, str2, str3);
        }
    }

    public static void onRecvRealtimeSequentialData(ByteBuffer byteBuffer, String str) {
        IJniZegoLiveRoomCallback iJniZegoLiveRoomCallback = sJNIZegoLiveRoomCallback;
        if (iJniZegoLiveRoomCallback != null) {
            iJniZegoLiveRoomCallback.onRecvRealtimeSequentialData(byteBuffer, str);
        }
    }

    public static void onRecvRemoteAudioFirstFrame(String str) {
        IJniZegoLiveRoomCallback iJniZegoLiveRoomCallback = sJNIZegoLiveRoomCallback;
        if (iJniZegoLiveRoomCallback != null) {
            iJniZegoLiveRoomCallback.onRecvRemoteAudioFirstFrame(str);
        }
    }

    public static void onRecvRemoteVideoFirstFrame(String str) {
        IJniZegoLiveRoomCallback iJniZegoLiveRoomCallback = sJNIZegoLiveRoomCallback;
        if (iJniZegoLiveRoomCallback != null) {
            iJniZegoLiveRoomCallback.onRecvRemoteVideoFirstFrame(str);
        }
    }

    public static void onRecvRoomMessage(String str, ZegoRoomMessage[] zegoRoomMessageArr) {
        IJniZegoIMCallback iJniZegoIMCallback = sJNIZegoIMCallback;
        if (iJniZegoIMCallback != null) {
            iJniZegoIMCallback.onRecvRoomMessage(str, zegoRoomMessageArr);
        }
    }

    public static void onRelayCDNStateUpdate(ZegoStreamRelayCDNInfo[] zegoStreamRelayCDNInfoArr, String str) {
        IJniZegoLiveRoomCallback iJniZegoLiveRoomCallback = sJNIZegoLiveRoomCallback;
        if (iJniZegoLiveRoomCallback != null) {
            iJniZegoLiveRoomCallback.onRelayCDNStateUpdate(zegoStreamRelayCDNInfoArr, str);
        }
    }

    public static void onRemoteCameraStatusUpdate(String str, int i, int i2) {
        IJniZegoLiveRoomCallback iJniZegoLiveRoomCallback = sJNIZegoLiveRoomCallback;
        if (iJniZegoLiveRoomCallback != null) {
            iJniZegoLiveRoomCallback.onRemoteCameraStatusUpdate(str, i, i2);
        }
    }

    public static void onRemoteMicStatusUpdate(String str, int i, int i2) {
        IJniZegoLiveRoomCallback iJniZegoLiveRoomCallback = sJNIZegoLiveRoomCallback;
        if (iJniZegoLiveRoomCallback != null) {
            iJniZegoLiveRoomCallback.onRemoteMicStatusUpdate(str, i, i2);
        }
    }

    public static void onRemoteSpeakerStatusUpdate(String str, int i, int i2) {
        IJniZegoLiveRoomCallback iJniZegoLiveRoomCallback = sJNIZegoLiveRoomCallback;
        if (iJniZegoLiveRoomCallback != null) {
            iJniZegoLiveRoomCallback.onRemoteSpeakerStatusUpdate(str, i, i2);
        }
    }

    public static void onRenderRemoteVideoFirstFrame(String str) {
        IJniZegoLiveRoomCallback iJniZegoLiveRoomCallback = sJNIZegoLiveRoomCallback;
        if (iJniZegoLiveRoomCallback != null) {
            iJniZegoLiveRoomCallback.onRenderRemoteVideoFirstFrame(str);
        }
    }

    public static void onRoomInfoUpdated(ZegoRoomInfo zegoRoomInfo, String str) {
        IJniZegoLiveRoomCallback iJniZegoLiveRoomCallback = sJNIZegoLiveRoomCallback;
        if (iJniZegoLiveRoomCallback != null) {
            iJniZegoLiveRoomCallback.onRoomInfoUpdated(zegoRoomInfo, str);
        }
    }

    public static void onRunLoopObserveCallback(long j, int i, int i2, int i3, int i4) {
        IJniZegoLiveRoomCallback iJniZegoLiveRoomCallback = sJNIZegoLiveRoomCallback;
        if (iJniZegoLiveRoomCallback != null) {
            iJniZegoLiveRoomCallback.onRunLoopObserveCallback(j, i, i2, i3, i4);
        }
    }

    public static void onSendBigRoomMessage(int i, String str, int i2, String str2) {
        IJniZegoIMCallback iJniZegoIMCallback = sJNIZegoIMCallback;
        if (iJniZegoIMCallback != null) {
            iJniZegoIMCallback.onSendBigRoomMessage(i, str, i2, str2);
        }
    }

    public static void onSendLocalAudioFirstFrame(int i) {
        IJniZegoLiveRoomCallback iJniZegoLiveRoomCallback = sJNIZegoLiveRoomCallback;
        if (iJniZegoLiveRoomCallback != null) {
            iJniZegoLiveRoomCallback.onSendLocalAudioFirstFrame(i);
        }
    }

    public static void onSendLocalVideoFirstFrame(int i) {
        IJniZegoLiveRoomCallback iJniZegoLiveRoomCallback = sJNIZegoLiveRoomCallback;
        if (iJniZegoLiveRoomCallback != null) {
            iJniZegoLiveRoomCallback.onSendLocalVideoFirstFrame(i);
        }
    }

    public static void onSendRealtimeSequentialData(int i, int i2) {
        IJniZegoLiveRoomCallback iJniZegoLiveRoomCallback = sJNIZegoLiveRoomCallback;
        if (iJniZegoLiveRoomCallback != null) {
            iJniZegoLiveRoomCallback.onSendRealtimeSequentialData(i, i2);
        }
    }

    public static void onSendRoomMessage(int i, String str, int i2, long j) {
        IJniZegoIMCallback iJniZegoIMCallback = sJNIZegoIMCallback;
        if (iJniZegoIMCallback != null) {
            iJniZegoIMCallback.onSendRoomMessage(i, str, i2, j);
        }
    }

    public static void onSnapshot(Bitmap bitmap, String str) {
        IJniZegoLiveRoomCallback iJniZegoLiveRoomCallback = sJNIZegoLiveRoomCallback;
        if (iJniZegoLiveRoomCallback != null) {
            iJniZegoLiveRoomCallback.onSnapshot(bitmap, str);
        }
    }

    public static void onStreamEvent(int i, String str, String[] strArr, String[] strArr2) {
        IJniZegoLiveRoomCallback iJniZegoLiveRoomCallback = sJNIZegoLiveRoomCallback;
        if (iJniZegoLiveRoomCallback == null) {
            return;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        int length = strArr.length <= strArr2.length ? strArr.length : strArr2.length;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= length) {
                iJniZegoLiveRoomCallback.onStreamEvent(i, str, hashMap);
                return;
            } else {
                hashMap.put(strArr[i3], strArr2[i3]);
                i2 = i3 + 1;
            }
        }
    }

    public static void onStreamExtraInfoUpdated(ZegoStreamInfo[] zegoStreamInfoArr, long j, String str) {
        IJniZegoLiveRoomCallback iJniZegoLiveRoomCallback = sJNIZegoLiveRoomCallback;
        if (iJniZegoLiveRoomCallback != null) {
            iJniZegoLiveRoomCallback.onStreamExtraInfoUpdated(zegoStreamInfoArr, str);
        }
    }

    public static void onStreamUpdated(int i, ZegoStreamInfo[] zegoStreamInfoArr, long j, String str) {
        IJniZegoLiveRoomCallback iJniZegoLiveRoomCallback = sJNIZegoLiveRoomCallback;
        if (iJniZegoLiveRoomCallback != null) {
            iJniZegoLiveRoomCallback.onStreamUpdated(i, zegoStreamInfoArr, str);
        }
    }

    public static void onTempBroken(int i, String str) {
        IJniZegoLiveRoomCallback iJniZegoLiveRoomCallback = sJNIZegoLiveRoomCallback;
        if (iJniZegoLiveRoomCallback != null) {
            iJniZegoLiveRoomCallback.onTempBroken(i, str);
        }
    }

    public static void onTokenWillExpired(String str, int i) {
        IJniZegoLiveRoomCallback iJniZegoLiveRoomCallback = sJNIZegoLiveRoomCallback;
        if (iJniZegoLiveRoomCallback != null) {
            iJniZegoLiveRoomCallback.onTokenWillExpired(str, i);
        }
    }

    public static void onUpdateOnlineCount(String str, int i) {
        IJniZegoIMCallback iJniZegoIMCallback = sJNIZegoIMCallback;
        if (iJniZegoIMCallback != null) {
            iJniZegoIMCallback.onUpdateOnlineCount(str, i);
        }
    }

    public static void onUpdatePublishTargetState(int i, String str, int i2) {
        IJniZegoLiveRoomCallback iJniZegoLiveRoomCallback = sJNIZegoLiveRoomCallback;
        if (iJniZegoLiveRoomCallback != null) {
            iJniZegoLiveRoomCallback.onUpdatePublishTargetState(i, str, i2);
        }
    }

    public static void onUserUpdate(ZegoUserState[] zegoUserStateArr, int i, String str) {
        IJniZegoIMCallback iJniZegoIMCallback = sJNIZegoIMCallback;
        if (iJniZegoIMCallback != null) {
            iJniZegoIMCallback.onUserUpdate(zegoUserStateArr, i, str);
        }
    }

    public static void onVideoDecoderError(int i, int i2, String str) {
        IJniZegoLiveRoomCallback iJniZegoLiveRoomCallback = sJNIZegoLiveRoomCallback;
        if (iJniZegoLiveRoomCallback != null) {
            iJniZegoLiveRoomCallback.onVideoDecoderError(i, i2, str);
        }
    }

    public static void onVideoEncoderChanged(int i, int i2, int i3) {
        IJniZegoLiveRoomCallback iJniZegoLiveRoomCallback = sJNIZegoLiveRoomCallback;
        if (iJniZegoLiveRoomCallback != null) {
            iJniZegoLiveRoomCallback.onVideoEncoderChanged(i, i2, i3);
        }
    }

    public static void onVideoEncoderError(int i, int i2, int i3) {
        IJniZegoLiveRoomCallback iJniZegoLiveRoomCallback = sJNIZegoLiveRoomCallback;
        if (iJniZegoLiveRoomCallback != null) {
            iJniZegoLiveRoomCallback.onVideoEncoderError(i, i2, i3);
        }
    }

    public static void onVideoSizeChanged(String str, int i, int i2) {
        IJniZegoLiveRoomCallback iJniZegoLiveRoomCallback = sJNIZegoLiveRoomCallback;
        if (iJniZegoLiveRoomCallback != null) {
            iJniZegoLiveRoomCallback.onVideoSizeChanged(str, i, i2);
        }
    }

    public static native void pauseModule(int i);

    public static native int requestJoinLive(String str);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native boolean requireHardwareDecoder(boolean z, String str);

    public static native boolean requireHardwareEncoder(boolean z);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native boolean requireHardwareEncoderByChannel(boolean z, int i);

    public static native boolean respondInviteJoinLiveReq(int i, int i2, String str);

    public static native boolean respondJoinLiveReq(int i, int i2, String str);

    public static native void resumeModule(int i);

    public static native int sendBigRoomMessage(int i, int i2, String str, String str2);

    public static native int sendCustomCommand(ZegoUser[] zegoUserArr, long j, String str, String str2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native int sendRealtimeSequentialData(ByteBuffer byteBuffer, int i, int i2);

    public static native int sendRoomMessageEx(int i, int i2, String str, String str2);

    public static native void setAECMode(int i);

    public static native void setAlignedAudioAuxDataCallback(boolean z);

    public static native void setAlphaEnv(boolean z);

    public static native boolean setAppOrientation(int i, int i2);

    public static native boolean setAppOrientationMode(int i);

    public static native boolean setAudioBitrate(int i, int i2);

    public static native void setAudioCaptureShiftOnMix(int i);

    public static native void setAudioChannelCount(int i);

    public static native void setAudioChannelCountByChannel(int i, int i2);

    public static native boolean setAudioDevice(int i, String str);

    public static native void setAudioDeviceMode(int i);

    public static boolean setAudioMixMode(int i, List<String> list) {
        return setAudioMixModeInner(i, list == null ? new String[0] : (String[]) list.toArray(new String[list.size()]));
    }

    static native boolean setAudioMixModeInner(int i, String[] strArr);

    public static native void setAudioPostpCallback(boolean z, ZegoExtPrepSet zegoExtPrepSet);

    public static native void setAudioPrepAfterLoopbackCallback(boolean z, ZegoExtPrepSet zegoExtPrepSet);

    public static native void setAudioPrepCallback(boolean z, ZegoExtPrepSet zegoExtPrepSet);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native boolean setAudioSource(int i, int i2);

    public static native boolean setBuiltInSpeakerOn(boolean z);

    public static native void setBusinessType(int i);

    public static native void setCDNPublishTarget(String str, int i);

    public static native boolean setCaptureFrameRotation(int i, int i2);

    public static native void setCapturePipelineScaleMode(int i);

    public static native void setCaptureVolume(int i);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native void setChannelExtraParam(String str, int i);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native void setConfig(String str);

    public static native boolean setCustomCDNPublishTarget(String str, int[] iArr, String[] strArr, int i);

    public static native boolean setCustomToken(String str);

    public static native void setDummyCaptureImagePath(String str, int i);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native void setExperimentalAPICallback(boolean z);

    public static native boolean setFilter(int i, int i2);

    public static native boolean setFrontCam(boolean z, int i);

    public static native void setLatencyMode(int i);

    public static native void setLatencyModeByChannel(int i, int i2);

    public static native void setLogHook();

    public static native boolean setLogPathAndSize(String str, long j, String str2, Context context);

    public static native void setLoopbackVolume(int i);

    public static native boolean setLowlightEnhancement(int i, int i2);

    public static native void setMinVideoBitrateForTrafficControl(int i, int i2, int i3);

    public static native void setMinVideoFpsForTrafficControl(int i, int i2);

    public static native void setMinVideoResolutionForTrafficControl(int i, int i2, int i3);

    public static native boolean setMixStreamConfig(String str, int i, int i2);

    public static native boolean setNoiseSuppressMode(int i);

    public static native boolean setPlayQualityMonitorCycle(long j);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native boolean setPlayStreamFocus(String str);

    public static native int setPlayStreamsAlignmentProperty(int i);

    public static native boolean setPlayVolume(int i);

    public static native boolean setPlayVolume2(int i, String str);

    public static native boolean setPolishFactor(float f, int i);

    public static native boolean setPolishStep(float f, int i);

    public static native void setPreviewCropRect(int i, int i2, int i3, int i4, int i5, int i6, int i7);

    public static native boolean setPreviewRotation(int i, int i2);

    public static native boolean setPreviewView(Object obj, int i);

    public static native boolean setPreviewViewBackgroundColor(int i, int i2);

    public static native boolean setPreviewViewMode(int i, int i2);

    public static native void setPreviewWaterMarkRect(int i, int i2, int i3, int i4, int i5);

    public static native void setPublishConfig(String str, int i);

    public static native void setPublishEncryptKey(byte[] bArr, int i);

    public static native boolean setPublishQualityMonitorCycle(long j);

    public static native void setPublishWaterMarkRect(int i, int i2, int i3, int i4, int i5);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native boolean setRecvBufferLevelLimit(int i, int i2, String str);

    public static native boolean setRoomConfig(boolean z, boolean z2, String str);

    public static native boolean setRoomMaxUserCount(int i, String str);

    public static native boolean setRoomMode(int i);

    public static native boolean setSharpenFactor(float f, int i);

    public static native int setStreamAlignmentProperty(int i, int i2);

    public static native void setTestEnv(boolean z);

    public static native boolean setToken(String str, String str2);

    public static native void setTrafficControlFocusOn(int i, int i2);

    public static native boolean setUser(String str, String str2);

    public static native void setVerbose(boolean z);

    public static native boolean setVideoBitrate(int i, int i2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native boolean setVideoCaptureDeviceId(String str, int i);

    public static native boolean setVideoCaptureResolution(int i, int i2, int i3);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native boolean setVideoCodecId(int i, int i2);

    public static native boolean setVideoEncodeResolution(int i, int i2, int i3);

    public static native void setVideoEncoderRateControlConfig(int i, int i2, int i3);

    public static native boolean setVideoFPS(int i, int i2);

    public static native boolean setVideoKeyFrameInterval(int i, int i2);

    public static native boolean setVideoMirrorMode(int i, int i2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native boolean setVideoSource(int i, int i2, int i3);

    public static native boolean setViewBackgroundColor(int i, String str);

    public static native void setViewCropRect(int i, int i2, int i3, int i4, int i5, int i6, String str);

    public static native boolean setViewMode(int i, String str);

    public static native boolean setViewRotation(int i, String str);

    public static native void setWaterMarkImagePath(String str, int i);

    public static native boolean setWhitenFactor(float f, int i);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setZegoIMCallback(IJniZegoIMCallback iJniZegoIMCallback) {
        sJNIZegoIMCallback = iJniZegoIMCallback;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setZegoLiveRoomCallback(IJniZegoLiveRoomCallback iJniZegoLiveRoomCallback) {
        sJNIZegoLiveRoomCallback = iJniZegoLiveRoomCallback;
    }

    public static native boolean startPlayingStream(String str, Object obj, ZegoStreamExtraPlayInfo zegoStreamExtraPlayInfo);

    public static native boolean startPlayingStreamWithParams(String str, Object obj, ZegoStreamExtraPlayInfo zegoStreamExtraPlayInfo, String str2);

    public static native boolean startPreview(int i);

    public static native boolean startPublishing(String str, String str2, int i);

    public static native boolean startPublishing2(String str, String str2, int i, int i2, String str3);

    public static native boolean startPublishing3(String str, String str2, int i, int i2, int i3, int i4, String str3, String str4);

    public static native boolean stopPlayingStream(String str);

    public static native boolean stopPreview(int i);

    public static native boolean stopPublishing(int i);

    public static native boolean switchRoom(String str, String str2, int i);

    public static native boolean takePreviewSnapshot(int i);

    public static native boolean takeSnapshot(String str);

    public static native boolean unInitSDK();

    public static native void uninitVideoSuperResolution();

    public static native boolean updateMixInputStreams(ZegoMixStreamInfo[] zegoMixStreamInfoArr);

    public static native void updatePlayDecryptKey(String str, byte[] bArr);

    public static native boolean updatePlayToken(String str, byte[] bArr);

    public static native boolean updatePlayView(String str, Object obj);

    public static native boolean updateStreamExtraInfo(String str, int i);

    public static native void uploadLog();

    public static native String version();

    public static native String version2();
}
