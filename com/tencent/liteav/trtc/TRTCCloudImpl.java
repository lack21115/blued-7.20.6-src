package com.tencent.liteav.trtc;

import android.content.Context;
import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.os.Handler;
import com.tencent.liteav.audio.TXAudioEffectManager;
import com.tencent.liteav.audio.TXAudioEffectManagerImpl;
import com.tencent.liteav.base.ContextUtils;
import com.tencent.liteav.base.Log;
import com.tencent.liteav.base.system.LiteavSystemInfo;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.TimeUtil;
import com.tencent.liteav.base.util.g;
import com.tencent.liteav.beauty.TXBeautyManager;
import com.tencent.liteav.beauty.TXBeautyManagerImpl;
import com.tencent.liteav.device.TXDeviceManager;
import com.tencent.liteav.device.TXDeviceManagerImpl;
import com.tencent.rtmp.ui.TXCloudVideoView;
import com.tencent.trtc.TRTCCloud;
import com.tencent.trtc.TRTCCloudDef;
import com.tencent.trtc.TRTCCloudListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/trtc/TRTCCloudImpl.class */
public class TRTCCloudImpl extends TRTCCloud implements TXAudioEffectManager.TXMusicPlayObserver {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f22750a = false;
    private static TRTCCloudImpl b;

    /* renamed from: c  reason: collision with root package name */
    private Context f22751c;
    private TRTCCloudListener d;
    private TrtcCloudJni e;
    private TRTCCloud.BGMNotify f;
    private TXAudioEffectManagerImpl g;
    private TXDeviceManagerImpl h;
    private TXBeautyManager i;
    private int j;
    private ArrayList<TRTCCloudImpl> k = new ArrayList<>();

    private TRTCCloudImpl(Context context) {
        b(context);
        this.f22751c = context;
        a(context, 0L);
    }

    private TRTCCloudImpl(Context context, long j) {
        b(context);
        this.f22751c = context;
        a(context, j);
    }

    public static TRTCCloud a(Context context) {
        TRTCCloudImpl tRTCCloudImpl;
        synchronized (TRTCCloudImpl.class) {
            try {
                if (b == null) {
                    b = new TRTCCloudImpl(context);
                }
                tRTCCloudImpl = b;
            } catch (Throwable th) {
                throw th;
            }
        }
        return tRTCCloudImpl;
    }

    public static void a() {
        synchronized (TRTCCloudImpl.class) {
            try {
                if (b != null) {
                    LiteavLog.i("TRTCCloudImpl", "destructor destroySharedInstance");
                    Iterator<TRTCCloudImpl> it = b.k.iterator();
                    while (it.hasNext()) {
                        it.next().e.destroy();
                    }
                    b.e.destroy();
                    b = null;
                }
            } finally {
            }
        }
    }

    public static void a(int i) {
        TrtcCloudJni.setLogLevel(i);
    }

    private void a(Context context, long j) {
        this.f22751c = context.getApplicationContext();
        if (j == 0) {
            this.e = new TrtcCloudJni();
        } else {
            this.e = new TrtcCloudJni(j);
        }
        this.h = new TXDeviceManagerImpl(this.e.createDeviceManager());
        this.g = new TXAudioEffectManagerImpl(this.e.createAudioEffectManager());
        this.i = new TXBeautyManagerImpl(this.e.createBeautyManager());
    }

    public static void a(String str) {
        TrtcCloudJni.setLogDirPath(str);
    }

    public static void a(boolean z) {
        TrtcCloudJni.setConsoleEnabled(z);
    }

    private static int b(int i) {
        if (i < 0) {
            return 0;
        }
        int i2 = i;
        if (i > 3) {
            i2 = (i / 90) % 4;
        }
        return i2;
    }

    private String b() {
        return this.f22751c.getCacheDir() + File.separator + "liteav_effect";
    }

    /* JADX WARN: Not initialized variable reg: 11, insn: 0x0266: MOVE  (r0 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r11 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), block:B:124:0x0246 */
    /* JADX WARN: Removed duplicated region for block: B:115:0x022c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String b(java.lang.String r6) {
        /*
            Method dump skipped, instructions count: 629
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.trtc.TRTCCloudImpl.b(java.lang.String):java.lang.String");
    }

    private static void b(Context context) {
        synchronized (TRTCCloudImpl.class) {
            try {
                if (!f22750a) {
                    ContextUtils.initApplicationContext(context.getApplicationContext());
                    ContextUtils.setDataDirectorySuffix("liteav");
                    TrtcCloudJni.init(0);
                    f22750a = true;
                }
            } finally {
            }
        }
    }

    public static void b(boolean z) {
        TrtcCloudJni.setLogCompressEnabled(z);
    }

    public static TRTCCloud createInstance(Context context) {
        return new TRTCCloudImpl(context);
    }

    public static void destroyInstance(TRTCCloud tRTCCloud) {
        if (tRTCCloud instanceof TRTCCloudImpl) {
            ((TRTCCloudImpl) tRTCCloud).e.destroy();
        } else {
            LiteavLog.w("TRTCCloudImpl", "destroyInstance trtcCloud=".concat(String.valueOf(tRTCCloud)));
        }
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void ConnectOtherRoom(String str) {
        this.e.connectOtherRoom(str);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void DisconnectOtherRoom() {
        this.e.disconnectOtherRoom();
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void callExperimentalAPI(String str) {
        this.e.callExperimentalAPI(str);
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public int checkAudioCapabilitySupport(int i) {
        return (i == 2 && this.h.isLowLatencyEarMonitorSupported()) ? 1 : 0;
    }

    @Override // com.tencent.trtc.TRTCCloud
    public TRTCCloud createSubCloud() {
        TRTCCloudImpl tRTCCloudImpl;
        synchronized (TRTCCloudImpl.class) {
            try {
                tRTCCloudImpl = new TRTCCloudImpl(ContextUtils.getApplicationContext(), this.e.getTrtcCloudJni());
                this.k.add(tRTCCloudImpl);
            } catch (Throwable th) {
                throw th;
            }
        }
        return tRTCCloudImpl;
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void destroySubCloud(TRTCCloud tRTCCloud) {
        synchronized (TRTCCloudImpl.class) {
            try {
                if (tRTCCloud instanceof TRTCCloudImpl) {
                    LiteavLog.i("TRTCCloudImpl", "destructor destroySubCloud");
                    ((TRTCCloudImpl) tRTCCloud).e.destroy();
                    this.k.remove(tRTCCloud);
                }
            } finally {
            }
        }
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void enable3DSpatialAudioEffect(boolean z) {
        this.e.enable3DSpatialAudioEffect(z);
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public void enableAudioEarMonitoring(boolean z) {
        this.g.enableVoiceEarMonitor(z);
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public void enableAudioVolumeEvaluation(int i) {
        enableAudioVolumeEvaluation(i, false);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void enableAudioVolumeEvaluation(int i, boolean z) {
        this.e.enableAudioVolumeEvaluation(i, z);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void enableCustomAudioCapture(boolean z) {
        this.e.enableCustomAudioCapture(z);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void enableCustomAudioRendering(boolean z) {
        this.e.enableCustomAudioRendering(z);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void enableCustomVideoCapture(int i, boolean z) {
        this.e.enableCustomVideoCapture(i, z);
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public void enableCustomVideoCapture(boolean z) {
        enableCustomVideoCapture(0, z);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public int enableEncSmallVideoStream(boolean z, TRTCCloudDef.TRTCVideoEncParam tRTCVideoEncParam) {
        return this.e.enableEncSmallVideoStream(z, tRTCVideoEncParam);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void enableMixExternalAudioFrame(boolean z, boolean z2) {
        this.e.enableMixExternalAudioFrame(z, z2);
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public boolean enableTorch(boolean z) {
        return this.h.enableCameraTorch(z);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void enterRoom(TRTCCloudDef.TRTCParams tRTCParams, int i) {
        this.e.enterRoom(tRTCParams, i);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void exitRoom() {
        this.e.exitRoom();
        try {
            File file = new File(b());
            if (!file.exists() || !file.isDirectory() || g.a(file, 5) <= 52428800) {
                return;
            }
            File[] listFiles = file.listFiles();
            int length = listFiles.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    return;
                }
                listFiles[i2].delete();
                i = i2 + 1;
            }
        } catch (Exception e) {
            LiteavLog.w("TRTCCloudImpl", "clearCache error " + e.toString());
        }
    }

    @Override // com.tencent.trtc.TRTCCloud
    public long generateCustomPTS() {
        return TimeUtil.c();
    }

    @Override // com.tencent.trtc.TRTCCloud
    public int getAudioCaptureVolume() {
        return this.e.getAudioCaptureVolume();
    }

    @Override // com.tencent.trtc.TRTCCloud
    public TXAudioEffectManager getAudioEffectManager() {
        return this.g;
    }

    @Override // com.tencent.trtc.TRTCCloud
    public int getAudioPlayoutVolume() {
        return this.e.getAudioPlayoutVolume();
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public int getBGMDuration(String str) {
        return (int) this.g.getMusicDurationInMS(str);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public TXBeautyManager getBeautyManager() {
        return this.i;
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void getCustomAudioRenderingFrame(TRTCCloudDef.TRTCAudioFrame tRTCAudioFrame) {
        this.e.getCustomAudioRenderingFrame(tRTCAudioFrame);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public TXDeviceManager getDeviceManager() {
        return this.h;
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public boolean isCameraAutoFocusFaceModeSupported() {
        return this.h.isCameraAutoFocusFaceModeSupported();
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public boolean isCameraFocusPositionInPreviewSupported() {
        return this.h.isCameraFocusPositionInPreviewSupported();
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public boolean isCameraTorchSupported() {
        return this.h.isCameraTorchSupported();
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public boolean isCameraZoomSupported() {
        return this.h.isCameraZoomSupported();
    }

    @Override // com.tencent.trtc.TRTCCloud
    public int mixExternalAudioFrame(TRTCCloudDef.TRTCAudioFrame tRTCAudioFrame) {
        return this.e.mixExternalAudioFrame(tRTCAudioFrame);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void muteAllRemoteAudio(boolean z) {
        this.e.muteAllRemoteAudio(z);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void muteAllRemoteVideoStreams(boolean z) {
        this.e.muteAllRemoteVideoStreams(z);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void muteLocalAudio(boolean z) {
        this.e.muteLocalAudio(z);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void muteLocalVideo(int i, boolean z) {
        this.e.muteLocalVideo(i, z);
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public void muteLocalVideo(boolean z) {
        this.e.muteLocalVideo(0, z);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void muteRemoteAudio(String str, boolean z) {
        this.e.muteRemoteAudio(str, z);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void muteRemoteVideoStream(String str, int i, boolean z) {
        this.e.muteRemoteVideoStream(str, i, z);
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public void muteRemoteVideoStream(String str, boolean z) {
        muteRemoteVideoStream(str, 0, z);
    }

    @Override // com.tencent.liteav.audio.TXAudioEffectManager.TXMusicPlayObserver
    public void onComplete(int i, int i2) {
        TRTCCloud.BGMNotify bGMNotify = this.f;
        if (bGMNotify != null) {
            bGMNotify.onBGMComplete(i2);
        }
    }

    @Override // com.tencent.liteav.audio.TXAudioEffectManager.TXMusicPlayObserver
    public void onPlayProgress(int i, long j, long j2) {
        TRTCCloud.BGMNotify bGMNotify = this.f;
        if (bGMNotify != null) {
            bGMNotify.onBGMProgress(j, j2);
        }
    }

    @Override // com.tencent.liteav.audio.TXAudioEffectManager.TXMusicPlayObserver
    public void onStart(int i, int i2) {
        TRTCCloud.BGMNotify bGMNotify = this.f;
        if (bGMNotify != null) {
            bGMNotify.onBGMStart(i2);
        }
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public void pauseAudioEffect(int i) {
        this.g.pauseAudioEffect(i);
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public void pauseBGM() {
        this.g.pausePlayMusic(Integer.MAX_VALUE);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void pauseScreenCapture() {
        this.e.pauseScreenCapture(this.j);
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public void playAudioEffect(TRTCCloudDef.TRTCAudioEffectParam tRTCAudioEffectParam) {
        if (tRTCAudioEffectParam == null) {
            return;
        }
        final int i = tRTCAudioEffectParam.effectId;
        TXAudioEffectManager.AudioMusicParam audioMusicParam = new TXAudioEffectManager.AudioMusicParam(i, b(tRTCAudioEffectParam.path));
        audioMusicParam.publish = tRTCAudioEffectParam.publish;
        audioMusicParam.loopCount = tRTCAudioEffectParam.loopCount;
        audioMusicParam.isShortFile = true;
        this.g.playAudioEffect(audioMusicParam);
        this.g.setEffectObserver(i, new TXAudioEffectManager.TXMusicPlayObserver() { // from class: com.tencent.liteav.trtc.TRTCCloudImpl.1
            @Override // com.tencent.liteav.audio.TXAudioEffectManager.TXMusicPlayObserver
            public final void onComplete(int i2, int i3) {
                TRTCCloudListener tRTCCloudListener = TRTCCloudImpl.this.d;
                if (tRTCCloudListener != null) {
                    tRTCCloudListener.onAudioEffectFinished(i, i3);
                }
            }

            @Override // com.tencent.liteav.audio.TXAudioEffectManager.TXMusicPlayObserver
            public final void onPlayProgress(int i2, long j, long j2) {
            }

            @Override // com.tencent.liteav.audio.TXAudioEffectManager.TXMusicPlayObserver
            public final void onStart(int i2, int i3) {
                TRTCCloudListener tRTCCloudListener = TRTCCloudImpl.this.d;
                if (tRTCCloudListener == null || i3 >= 0) {
                    return;
                }
                tRTCCloudListener.onAudioEffectFinished(i, i3);
            }
        });
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public void playBGM(String str, TRTCCloud.BGMNotify bGMNotify) {
        this.f = bGMNotify;
        TXAudioEffectManager.AudioMusicParam audioMusicParam = new TXAudioEffectManager.AudioMusicParam(Integer.MAX_VALUE, str);
        audioMusicParam.publish = true;
        audioMusicParam.loopCount = 0;
        this.g.setMusicObserver(Integer.MAX_VALUE, this);
        this.g.startPlayMusic(audioMusicParam);
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public void resumeAudioEffect(int i) {
        this.g.resumeAudioEffect(i);
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public void resumeBGM() {
        this.g.resumePlayMusic(Integer.MAX_VALUE);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void resumeScreenCapture() {
        this.e.resumeScreenCapture(this.j);
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public void selectMotionTmpl(String str) {
        this.i.setMotionTmpl(str);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void sendCustomAudioData(TRTCCloudDef.TRTCAudioFrame tRTCAudioFrame) {
        this.e.sendCustomAudioData(tRTCAudioFrame);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public boolean sendCustomCmdMsg(int i, byte[] bArr, boolean z, boolean z2) {
        if (bArr == null) {
            LiteavLog.w("TRTCCloudImpl", "custom msg data is null.");
            return false;
        }
        return this.e.sendCustomCmdMsg(i, bArr, z, z2);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void sendCustomVideoData(int i, TRTCCloudDef.TRTCVideoFrame tRTCVideoFrame) {
        if (tRTCVideoFrame == null) {
            LiteavLog.w("TRTCCloudImpl", "sendCustomVideoData frame is null");
            return;
        }
        if (tRTCVideoFrame.bufferType == 2) {
            GLES20.glFinish();
        }
        this.e.sendCustomVideoData(i, tRTCVideoFrame);
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public void sendCustomVideoData(TRTCCloudDef.TRTCVideoFrame tRTCVideoFrame) {
        sendCustomVideoData(0, tRTCVideoFrame);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public boolean sendSEIMsg(byte[] bArr, int i) {
        if (bArr == null || i == 0) {
            LiteavLog.w("TRTCCloudImpl", "sei msg data is null or repeatCount is zero.");
            return false;
        }
        return this.e.sendSEIMsg(bArr, i);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void set3DSpatialReceivingRange(String str, int i) {
        this.e.set3DSpatialReceivingRange(str, i);
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public void setAllAudioEffectsVolume(int i) {
        this.g.setAllAudioEffectsVolume(i);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void setAudioCaptureVolume(int i) {
        this.e.setAudioCaptureVolume(i);
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public void setAudioEffectVolume(int i, int i2) {
        this.g.setAudioEffectVolume(i, i2);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void setAudioFrameListener(TRTCCloudListener.TRTCAudioFrameListener tRTCAudioFrameListener) {
        this.e.setAudioFrameListener(tRTCAudioFrameListener);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void setAudioPlayoutVolume(int i) {
        this.e.setAudioPlayoutVolume(i);
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public void setAudioQuality(int i) {
        this.e.setAudioQuality(i);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void setAudioRoute(int i) {
        this.h.setAudioRoute(TXDeviceManagerImpl.audioRouteFromInt(i));
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public void setBGMPlayoutVolume(int i) {
        this.g.setMusicPlayoutVolume(Integer.MAX_VALUE, i);
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public int setBGMPosition(int i) {
        this.g.seekMusicToPosInMS(Integer.MAX_VALUE, i);
        return 0;
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public void setBGMPublishVolume(int i) {
        this.g.setMusicPublishVolume(Integer.MAX_VALUE, i);
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public void setBGMVolume(int i) {
        this.g.setMusicPlayoutVolume(Integer.MAX_VALUE, i);
        this.g.setMusicPublishVolume(Integer.MAX_VALUE, i);
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public void setBeautyStyle(int i, int i2, int i3, int i4) {
        this.i.setBeautyStyle(i);
        this.i.setBeautyLevel(i2);
        this.i.setWhitenessLevel(i3);
        this.i.setRuddyLevel(i4);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public int setCapturedRawAudioFrameCallbackFormat(TRTCCloudDef.TRTCAudioFrameCallbackFormat tRTCAudioFrameCallbackFormat) {
        return this.e.setCapturedRawAudioFrameCallbackFormat(tRTCAudioFrameCallbackFormat.sampleRate, tRTCAudioFrameCallbackFormat.channel, tRTCAudioFrameCallbackFormat.samplesPerCall, tRTCAudioFrameCallbackFormat.mode);
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public void setChinLevel(int i) {
        this.i.setChinLevel(i);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void setDebugViewMargin(String str, TRTCCloud.TRTCViewMargin tRTCViewMargin) {
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void setDefaultStreamRecvMode(boolean z, boolean z2) {
        this.e.setDefaultStreamRecvMode(z, z2);
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public void setEyeScaleLevel(int i) {
        this.i.setEyeScaleLevel(i);
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public void setFaceShortLevel(int i) {
        this.i.setFaceShortLevel(i);
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public void setFaceSlimLevel(int i) {
        this.i.setFaceSlimLevel(i);
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public void setFaceVLevel(int i) {
        this.i.setFaceVLevel(i);
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public void setFilter(Bitmap bitmap) {
        this.i.setFilter(bitmap);
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public void setFilterConcentration(float f) {
        this.i.setFilterStrength(f);
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public void setFocusPosition(int i, int i2) {
        this.h.setCameraFocusPosition(i, i2);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void setGSensorMode(int i) {
        this.e.setGSensorMode(0, i);
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public boolean setGreenScreenFile(String str) {
        return false;
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void setListener(TRTCCloudListener tRTCCloudListener) {
        Log.d("TRTCCloudImpl", "setListener ".concat(String.valueOf(tRTCCloudListener)), new Object[0]);
        this.d = tRTCCloudListener;
        this.e.setListener(tRTCCloudListener);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void setListenerHandler(Handler handler) {
        this.e.setListenerHandler(handler);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public int setLocalProcessedAudioFrameCallbackFormat(TRTCCloudDef.TRTCAudioFrameCallbackFormat tRTCAudioFrameCallbackFormat) {
        return this.e.setLocalProcessedAudioFrameCallbackFormat(tRTCAudioFrameCallbackFormat.sampleRate, tRTCAudioFrameCallbackFormat.channel, tRTCAudioFrameCallbackFormat.samplesPerCall, tRTCAudioFrameCallbackFormat.mode);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void setLocalRenderParams(TRTCCloudDef.TRTCRenderParams tRTCRenderParams) {
        setLocalViewFillMode(tRTCRenderParams.fillMode);
        setLocalViewRotation(tRTCRenderParams.rotation);
        setLocalViewMirror(tRTCRenderParams.mirrorType);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public int setLocalVideoProcessListener(int i, int i2, TRTCCloudListener.TRTCVideoFrameListener tRTCVideoFrameListener) {
        return this.e.setLocalVideoProcessListener(0, i, i2, tRTCVideoFrameListener);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public int setLocalVideoRenderListener(int i, int i2, TRTCCloudListener.TRTCVideoRenderListener tRTCVideoRenderListener) {
        return this.e.setLocalVideoRenderListener(i, i2, tRTCVideoRenderListener);
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public void setLocalViewFillMode(int i) {
        this.e.setLocalViewFillMode(i);
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public void setLocalViewMirror(int i) {
        this.e.setLocalViewMirror(i);
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public void setLocalViewRotation(int i) {
        this.e.setLocalViewRotation(b(i));
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public void setMicVolumeOnMixing(int i) {
        this.g.setVoiceCaptureVolume(i);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void setMixExternalAudioVolume(int i, int i2) {
        this.e.setMixExternalAudioVolume(i, i2);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void setMixTranscodingConfig(TRTCCloudDef.TRTCTranscodingConfig tRTCTranscodingConfig) {
        this.e.setMixTranscodingConfig(tRTCTranscodingConfig);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public int setMixedPlayAudioFrameCallbackFormat(TRTCCloudDef.TRTCAudioFrameCallbackFormat tRTCAudioFrameCallbackFormat) {
        return this.e.setMixedPlayAudioFrameCallbackFormat(tRTCAudioFrameCallbackFormat.sampleRate, tRTCAudioFrameCallbackFormat.channel, tRTCAudioFrameCallbackFormat.samplesPerCall, tRTCAudioFrameCallbackFormat.mode);
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public void setMotionMute(boolean z) {
        this.i.setMotionMute(z);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void setNetworkQosParam(TRTCCloudDef.TRTCNetworkQosParam tRTCNetworkQosParam) {
        this.e.setNetworkQosParam(tRTCNetworkQosParam);
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public void setNoseSlimLevel(int i) {
        this.i.setNoseSlimLevel(i);
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public int setPriorRemoteVideoStreamType(int i) {
        return this.e.setPriorRemoteVideoStreamType(i);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void setRemoteAudioParallelParams(TRTCCloudDef.TRTCAudioParallelParams tRTCAudioParallelParams) {
        this.e.setRemoteAudioParallelParams(tRTCAudioParallelParams);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void setRemoteAudioVolume(String str, int i) {
        this.e.setRemoteAudioVolume(str, i);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void setRemoteRenderParams(String str, int i, TRTCCloudDef.TRTCRenderParams tRTCRenderParams) {
        this.e.setRemoteViewFillMode(str, i, tRTCRenderParams.fillMode);
        this.e.setRemoteViewRotation(str, i, b(tRTCRenderParams.rotation));
        this.e.setRemoteViewMirror(str, i, tRTCRenderParams.mirrorType);
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public void setRemoteSubStreamViewFillMode(String str, int i) {
        this.e.setRemoteViewFillMode(str, 2, i);
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public void setRemoteSubStreamViewRotation(String str, int i) {
        this.e.setRemoteViewRotation(str, 2, b(i));
    }

    @Override // com.tencent.trtc.TRTCCloud
    public int setRemoteVideoRenderListener(String str, int i, int i2, TRTCCloudListener.TRTCVideoRenderListener tRTCVideoRenderListener) {
        return this.e.setRemoteVideoRenderListener(str, i, i2, tRTCVideoRenderListener);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public int setRemoteVideoStreamType(String str, int i) {
        return this.e.setRemoteVideoStreamType(str, i);
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public void setRemoteViewFillMode(String str, int i) {
        this.e.setRemoteViewFillMode(str, 0, i);
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public void setRemoteViewRotation(String str, int i) {
        this.e.setRemoteViewRotation(str, 0, b(i));
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public void setReverbType(int i) {
        this.g.setVoiceReverbType(TXAudioEffectManagerImpl.voiceReverbTypeFromInt(i));
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void setSubStreamEncoderParam(TRTCCloudDef.TRTCVideoEncParam tRTCVideoEncParam) {
        this.e.setVideoEncoderParams(2, tRTCVideoEncParam);
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public void setSystemVolumeType(int i) {
        this.h.setSystemVolumeType(TXDeviceManagerImpl.systemVolumeTypefromInt(i));
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void setVideoEncoderMirror(boolean z) {
        this.e.setVideoEncoderMirror(z);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void setVideoEncoderParam(TRTCCloudDef.TRTCVideoEncParam tRTCVideoEncParam) {
        this.e.setVideoEncoderParams(0, tRTCVideoEncParam);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void setVideoEncoderRotation(int i) {
        this.e.setVideoEncoderRotation(b(i));
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void setVideoMuteImage(Bitmap bitmap, int i) {
        this.e.setVideoMuteImage(0, bitmap, i);
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public boolean setVoiceChangerType(int i) {
        this.g.setVoiceChangerType(TXAudioEffectManagerImpl.voiceChangerTypeFromInt(i));
        return true;
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void setWatermark(Bitmap bitmap, int i, float f, float f2, float f3) {
        this.e.setWatermark(bitmap, i, f, f2, f3);
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public void setZoom(int i) {
        this.h.setCameraZoomRatio(i);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void showDebugView(int i) {
        this.e.showDashboardManager(i);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void snapshotVideo(String str, int i, TRTCCloudListener.TRTCSnapshotListener tRTCSnapshotListener) {
        this.e.snapshotVideo(str, i, tRTCSnapshotListener);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public int startAudioRecording(TRTCCloudDef.TRTCAudioRecordingParams tRTCAudioRecordingParams) {
        return this.e.startAudioRecording(tRTCAudioRecordingParams);
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public void startLocalAudio() {
        this.e.startLocalAudio();
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void startLocalAudio(int i) {
        this.e.startLocalAudio(i);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void startLocalPreview(boolean z, TXCloudVideoView tXCloudVideoView) {
        this.e.startLocalPreview(z, tXCloudVideoView);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void startLocalRecording(TRTCCloudDef.TRTCLocalRecordingParams tRTCLocalRecordingParams) {
        this.e.startLocalRecording(tRTCLocalRecordingParams);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void startPublishCDNStream(TRTCCloudDef.TRTCPublishCDNParam tRTCPublishCDNParam) {
        this.e.startPublishCDNStream(tRTCPublishCDNParam);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void startPublishMediaStream(TRTCCloudDef.TRTCPublishTarget tRTCPublishTarget, TRTCCloudDef.TRTCStreamEncoderParam tRTCStreamEncoderParam, TRTCCloudDef.TRTCStreamMixingConfig tRTCStreamMixingConfig) {
        this.e.startPublishMediaStream(tRTCPublishTarget, tRTCStreamEncoderParam, tRTCStreamMixingConfig);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void startPublishing(String str, int i) {
        this.e.startPublishing(str, i);
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public void startRemoteSubStreamView(String str, TXCloudVideoView tXCloudVideoView) {
        startRemoteView(str, 2, tXCloudVideoView);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void startRemoteView(String str, int i, TXCloudVideoView tXCloudVideoView) {
        this.e.startRemoteView(str, i, tXCloudVideoView);
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public void startRemoteView(String str, TXCloudVideoView tXCloudVideoView) {
        this.e.startRemoteView(str, tXCloudVideoView);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void startScreenCapture(int i, TRTCCloudDef.TRTCVideoEncParam tRTCVideoEncParam, TRTCCloudDef.TRTCScreenShareParams tRTCScreenShareParams) {
        this.j = i;
        this.e.startScreenCapture(i, tRTCVideoEncParam, tRTCScreenShareParams);
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public void startScreenCapture(TRTCCloudDef.TRTCVideoEncParam tRTCVideoEncParam, TRTCCloudDef.TRTCScreenShareParams tRTCScreenShareParams) {
        this.j = 0;
        startScreenCapture(0, tRTCVideoEncParam, tRTCScreenShareParams);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public int startSpeedTest(TRTCCloudDef.TRTCSpeedTestParams tRTCSpeedTestParams) {
        this.e.startSpeedTest(true, tRTCSpeedTestParams);
        return 0;
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public void startSpeedTest(int i, String str, String str2) {
        TRTCCloudDef.TRTCSpeedTestParams tRTCSpeedTestParams = new TRTCCloudDef.TRTCSpeedTestParams();
        tRTCSpeedTestParams.sdkAppId = i;
        tRTCSpeedTestParams.userId = str;
        tRTCSpeedTestParams.userSig = str2;
        this.e.startSpeedTest(false, tRTCSpeedTestParams);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void startSystemAudioLoopback() {
        if (LiteavSystemInfo.getSystemOSVersionInt() < 29) {
            LiteavLog.e("TRTCCloudImpl", "current system don't support system audio loopback");
        } else {
            this.e.startSystemAudioLoopback();
        }
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public void stopAllAudioEffects() {
        this.g.stopAllAudioEffects();
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void stopAllRemoteView() {
        this.e.stopAllRemoteView();
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public void stopAudioEffect(int i) {
        this.g.stopAudioEffect(i);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void stopAudioRecording() {
        this.e.stopAudioRecording();
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public void stopBGM() {
        this.g.stopPlayMusic(Integer.MAX_VALUE);
        this.g.setMusicObserver(Integer.MAX_VALUE, null);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void stopLocalAudio() {
        this.e.stopLocalAudio();
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void stopLocalPreview() {
        this.e.stopLocalPreview();
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void stopLocalRecording() {
        this.e.stopLocalRecording();
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void stopPublishCDNStream() {
        this.e.stopPublishCDNStream();
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void stopPublishMediaStream(String str) {
        this.e.stopPublishMediaStream(str);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void stopPublishing() {
        this.e.stopPublishing();
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public void stopRemoteSubStreamView(String str) {
        stopRemoteView(str, 2);
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public void stopRemoteView(String str) {
        this.e.stopRemoteView(str);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void stopRemoteView(String str, int i) {
        this.e.stopRemoteView(str, i);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void stopScreenCapture() {
        this.e.stopScreenCapture(this.j);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void stopSpeedTest() {
        this.e.stopSpeedTest();
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void stopSystemAudioLoopback() {
        this.e.stopSystemAudioLoopback();
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public void switchCamera() {
        this.h.switchCamera(!this.h.isFrontCamera());
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void switchRole(int i) {
        this.e.switchRole(i);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void switchRole(int i, String str) {
        this.e.switchRole(i, str);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void switchRoom(TRTCCloudDef.TRTCSwitchRoomConfig tRTCSwitchRoomConfig) {
        this.e.switchRoom(tRTCSwitchRoomConfig);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void updateLocalView(TXCloudVideoView tXCloudVideoView) {
        this.e.updateLocalView(tXCloudVideoView);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void updatePublishMediaStream(String str, TRTCCloudDef.TRTCPublishTarget tRTCPublishTarget, TRTCCloudDef.TRTCStreamEncoderParam tRTCStreamEncoderParam, TRTCCloudDef.TRTCStreamMixingConfig tRTCStreamMixingConfig) {
        this.e.updatePublishMediaStream(str, tRTCPublishTarget, tRTCStreamEncoderParam, tRTCStreamMixingConfig);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void updateRemote3DSpatialPosition(String str, int[] iArr) {
        this.e.updateRemote3DSpatialPosition(str, iArr);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void updateRemoteView(String str, int i, TXCloudVideoView tXCloudVideoView) {
        this.e.updateRemoteView(str, i, tXCloudVideoView);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void updateSelf3DSpatialPosition(int[] iArr, float[] fArr, float[] fArr2, float[] fArr3) {
        this.e.updateSelf3DSpatialPosition(iArr, fArr, fArr2, fArr3);
    }
}
