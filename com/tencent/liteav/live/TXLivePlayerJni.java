package com.tencent.liteav.live;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.view.Surface;
import com.tencent.liteav.base.ContextUtils;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.videobase.frame.PixelFrame;
import com.tencent.liteav.videobase.videobase.DisplayTarget;
import com.tencent.rtmp.ITXLivePlayListener;
import com.tencent.rtmp.TXLivePlayConfig;
import com.tencent.rtmp.TXLivePlayer;
import com.tencent.rtmp.ui.TXCloudVideoView;
import com.tencent.ugc.TXRecordCommon;
import java.io.File;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

@JNINamespace("liteav")
/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/live/TXLivePlayerJni.class */
public class TXLivePlayerJni implements com.tencent.rtmp.a, TXCloudVideoView.b {
    private static final String TAG = "TXLivePlayerJni";
    private String mAESIV;
    private String mAESKey;
    private Integer mAESMode;
    private String mAESURL;
    private TXLivePlayer.ITXAudioRawDataListener mAudioRawDataListener;
    private Integer mAudioRoute;
    private TXLivePlayer.ITXAudioVolumeEvaluationListener mAudioVolumeEvaluationListener;
    private TXLivePlayConfig mConfig;
    private DisplayTarget mDisplayTarget;
    private Boolean mEnableHardwareDecoder;
    private Boolean mIsAudioMuted;
    private ITXLivePlayListener mListener;
    private Long mNativeAudioJitterBufferControllerFactory;
    private Integer mRenderMode;
    private Integer mRenderRotate;
    private Boolean mShowDebugView;
    private TXLivePlayer.ITXSnapshotListener mSnapshotListener;
    private Surface mSurface;
    private TXLivePlayer.ITXVideoRawDataListener mVideoRawDataListener;
    private TXRecordCommon.ITXVideoRecordListener mVideoRecordListener;
    private TXLivePlayer.ITXLivePlayVideoRenderListener mVideoRenderListener;
    private Integer mVolume;
    private Integer mVolumeIntervalMs;
    protected long mNativeTXLivePlayerJni = 0;
    private int mSurfaceWidth = -1;
    private int mSurfaceHeight = -1;
    private Object mGLContext = null;

    public TXLivePlayerJni(Context context) {
        ContextUtils.initApplicationContext(context.getApplicationContext());
        ContextUtils.setDataDirectorySuffix("liteav");
    }

    private static String genFilePath(Context context, String str) {
        if (context == null) {
            return null;
        }
        try {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
            String format = simpleDateFormat.format(new Date(Long.valueOf(String.valueOf(currentTimeMillis) + "000").longValue()));
            String diskFileDir = getDiskFileDir(context);
            if (TextUtils.isEmpty(diskFileDir)) {
                return null;
            }
            return new File(diskFileDir, String.format("TXUGC_%s".concat(String.valueOf(str)), format)).getAbsolutePath();
        } catch (Exception e) {
            LiteavLog.e(TAG, "create file path failed.", e);
            return null;
        }
    }

    private static String getDiskFileDir(Context context) {
        if (context == null) {
            return null;
        }
        if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState()) || !Environment.isExternalStorageRemovable()) {
            File externalFilesDir = context.getExternalFilesDir(Environment.DIRECTORY_MOVIES);
            String str = null;
            if (externalFilesDir != null) {
                str = externalFilesDir.getPath();
            }
            return str;
        }
        return context.getFilesDir().getPath();
    }

    public static String[] getMapKeys(Map<String, String> map) {
        String[] strArr = new String[map.size()];
        Iterator<String> it = map.keySet().iterator();
        int i = 0;
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return strArr;
            }
            strArr[i2] = it.next();
            i = i2 + 1;
        }
    }

    public static String[] getMapValues(Map<String, String> map, String[] strArr) {
        String[] strArr2 = new String[map.size()];
        int length = strArr.length;
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i >= length) {
                return strArr2;
            }
            strArr2[i3] = map.get(strArr[i]);
            i++;
            i2 = i3 + 1;
        }
    }

    private boolean isNativeValid() {
        return this.mNativeTXLivePlayerJni != 0;
    }

    private static native long nativeCreate(WeakReference<TXLivePlayerJni> weakReference);

    private static native void nativeDestroy(long j);

    private static native void nativeEnableAudioVolumeEvaluation(long j, int i);

    private static native void nativeEnableCustomAudioProcess(long j, boolean z);

    private static native void nativeEnableCustomRenderI420(long j, boolean z);

    private static native void nativeEnableCustomRenderTexture(long j, boolean z, Object obj);

    private static native void nativeEnableHardwareDecode(long j, boolean z);

    private static native long nativeGetCurrentRenderPts(long j);

    private static native boolean nativeIsPlaying(long j);

    private static native void nativePause(long j);

    private static native void nativeResume(long j);

    private static native void nativeSetAESCodecParams(long j, String str, int i, String str2, String str3);

    private static native void nativeSetAudioJitterBufferControllerFactory(long j, long j2);

    private static native void nativeSetAudioRoute(long j, int i);

    private static native void nativeSetConfig(long j, float f, float f2, float f3, int i, int i2, int i3, boolean z, boolean z2, boolean z3, String str, Map map);

    private static native void nativeSetMute(long j, boolean z);

    private static native void nativeSetPlayerView(long j, DisplayTarget displayTarget);

    private static native void nativeSetRenderMode(long j, int i);

    private static native void nativeSetRenderRotation(long j, int i);

    private static native void nativeSetVolume(long j, int i);

    private static native void nativeShowDebugView(long j, boolean z);

    private static native void nativeSnapshot(long j);

    private static native int nativeStartPlay(long j, String str, int i);

    private static native void nativeStartRecord(long j, int i, String str);

    private static native void nativeStopPlay(long j);

    private static native void nativeStopRecord(long j);

    private static native int nativeSwitchStream(long j, String str);

    private void setAudioJitterBufferFactory(JSONObject jSONObject) {
        if (jSONObject == null || !jSONObject.has("controllerFactory")) {
            LiteavLog.e(TAG, "set audio jitter buffer controller factory params failed. invalid params:".concat(String.valueOf(jSONObject)));
            return;
        }
        synchronized (this) {
            try {
                this.mNativeAudioJitterBufferControllerFactory = new Long(jSONObject.getLong("controllerFactory"));
            } catch (JSONException e) {
                e.printStackTrace();
                LiteavLog.e(TAG, "set audio jitter buffer factory params failed. parse json failed.");
            }
        }
    }

    private void setEncryptionParams(JSONObject jSONObject) {
        if (jSONObject == null || !jSONObject.has("url") || !jSONObject.has("encMode") || !jSONObject.has("encKey") || !jSONObject.has("encIV")) {
            LiteavLog.e(TAG, "set encryption params failed. invalid params:".concat(String.valueOf(jSONObject)));
            return;
        }
        synchronized (this) {
            try {
                int i = jSONObject.getInt("encMode");
                String string = jSONObject.getString("url");
                String string2 = jSONObject.getString("encKey");
                String string3 = jSONObject.getString("encIV");
                this.mAESMode = Integer.valueOf(i);
                this.mAESKey = string2;
                this.mAESURL = string;
                this.mAESIV = string3;
                if (isNativeValid()) {
                    nativeSetAESCodecParams(this.mNativeTXLivePlayerJni, this.mAESURL, this.mAESMode.intValue(), this.mAESKey, this.mAESIV);
                }
            } catch (JSONException e) {
                e.printStackTrace();
                LiteavLog.e(TAG, "set encryption params failed. parse json failed.");
            }
        }
    }

    public static TXLivePlayerJni weakToStrongReference(WeakReference<TXLivePlayerJni> weakReference) {
        return weakReference.get();
    }

    @Override // com.tencent.rtmp.a
    public boolean addVideoRawData(byte[] bArr) {
        return false;
    }

    @Override // com.tencent.rtmp.a
    public void callExperimentalAPI(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has("api")) {
                LiteavLog.e(TAG, "call experimental api failed. json: ".concat(String.valueOf(str)));
                return;
            }
            String string = jSONObject.getString("api");
            JSONObject jSONObject2 = null;
            if (jSONObject.has("params")) {
                jSONObject2 = jSONObject.getJSONObject("params");
            }
            boolean z = true;
            int hashCode = string.hashCode();
            if (hashCode != -679410198) {
                if (hashCode == 298124139 && string.equals("setEncryptionParams")) {
                    z = false;
                }
            } else if (string.equals("setAudioJitterBufferFactory")) {
                z = true;
            }
            if (!z) {
                setEncryptionParams(jSONObject2);
            } else if (!z) {
                return;
            }
            setAudioJitterBufferFactory(jSONObject2);
        } catch (Exception e) {
            e.printStackTrace();
            LiteavLog.e(TAG, "call experimental api failed. json:".concat(String.valueOf(str)));
        }
    }

    @Override // com.tencent.rtmp.a
    public void enableAudioVolumeEvaluation(int i) {
        synchronized (this) {
            this.mVolumeIntervalMs = Integer.valueOf(i);
            if (isNativeValid()) {
                nativeEnableAudioVolumeEvaluation(this.mNativeTXLivePlayerJni, i);
            }
        }
    }

    @Override // com.tencent.rtmp.a
    public boolean enableHardwareDecode(boolean z) {
        synchronized (this) {
            this.mEnableHardwareDecoder = Boolean.valueOf(z);
            if (isNativeValid()) {
                nativeEnableHardwareDecode(this.mNativeTXLivePlayerJni, z);
            }
        }
        return true;
    }

    @Override // com.tencent.rtmp.a
    public long getCurrentRenderPts() {
        synchronized (this) {
            if (isNativeValid()) {
                return nativeGetCurrentRenderPts(this.mNativeTXLivePlayerJni);
            }
            return 0L;
        }
    }

    @Override // com.tencent.rtmp.a
    public boolean isPlaying() {
        synchronized (this) {
            if (isNativeValid()) {
                return nativeIsPlaying(this.mNativeTXLivePlayerJni);
            }
            return false;
        }
    }

    public void onAudioInfoChanged(int i, int i2, int i3) {
        TXLivePlayer.ITXAudioRawDataListener iTXAudioRawDataListener = this.mAudioRawDataListener;
        if (iTXAudioRawDataListener != null) {
            iTXAudioRawDataListener.onAudioInfoChanged(i, i2, i3);
        }
    }

    public void onAudioVolumeEvaluationNotify(int i) {
        TXLivePlayer.ITXAudioVolumeEvaluationListener iTXAudioVolumeEvaluationListener = this.mAudioVolumeEvaluationListener;
        if (iTXAudioVolumeEvaluationListener != null) {
            iTXAudioVolumeEvaluationListener.onAudioVolumeEvaluationNotify(i);
        }
    }

    public void onNetStatus(Bundle bundle) {
        ITXLivePlayListener iTXLivePlayListener = this.mListener;
        if (iTXLivePlayListener != null) {
            iTXLivePlayListener.onNetStatus(bundle);
        }
    }

    public void onPcmDataAvailable(byte[] bArr, long j) {
        TXLivePlayer.ITXAudioRawDataListener iTXAudioRawDataListener = this.mAudioRawDataListener;
        if (iTXAudioRawDataListener != null) {
            iTXAudioRawDataListener.onPcmDataAvailable(bArr, j);
        }
    }

    public void onPlayEvent(int i, Bundle bundle) {
        ITXLivePlayListener iTXLivePlayListener = this.mListener;
        if (iTXLivePlayListener != null) {
            iTXLivePlayListener.onPlayEvent(i, bundle);
        }
    }

    public void onRecordComplete(int i, String str, String str2, String str3) {
        TXRecordCommon.ITXVideoRecordListener iTXVideoRecordListener = this.mVideoRecordListener;
        if (iTXVideoRecordListener != null) {
            TXRecordCommon.TXRecordResult tXRecordResult = new TXRecordCommon.TXRecordResult();
            if (i == 0) {
                tXRecordResult.retCode = 0;
            } else {
                tXRecordResult.retCode = -1;
            }
            tXRecordResult.descMsg = str;
            tXRecordResult.videoPath = str2;
            tXRecordResult.coverPath = str3;
            iTXVideoRecordListener.onRecordComplete(tXRecordResult);
        }
    }

    public void onRecordEvent(int i, Bundle bundle) {
        TXRecordCommon.ITXVideoRecordListener iTXVideoRecordListener = this.mVideoRecordListener;
        if (iTXVideoRecordListener != null) {
            iTXVideoRecordListener.onRecordEvent(i, bundle);
        }
    }

    public void onRecordProgress(long j) {
        TXRecordCommon.ITXVideoRecordListener iTXVideoRecordListener = this.mVideoRecordListener;
        if (iTXVideoRecordListener != null) {
            iTXVideoRecordListener.onRecordProgress(j);
        }
    }

    public void onRenderVideoFrame(PixelFrame pixelFrame) {
        TXLivePlayer.ITXLivePlayVideoRenderListener iTXLivePlayVideoRenderListener = this.mVideoRenderListener;
        if (iTXLivePlayVideoRenderListener != null) {
            TXLivePlayer.TXLiteAVTexture tXLiteAVTexture = new TXLivePlayer.TXLiteAVTexture();
            tXLiteAVTexture.textureId = pixelFrame.getTextureId();
            tXLiteAVTexture.width = pixelFrame.getWidth();
            tXLiteAVTexture.height = pixelFrame.getHeight();
            tXLiteAVTexture.eglContext = pixelFrame.getGLContext();
            iTXLivePlayVideoRenderListener.onRenderVideoFrame(tXLiteAVTexture);
        }
        TXLivePlayer.ITXVideoRawDataListener iTXVideoRawDataListener = this.mVideoRawDataListener;
        if (iTXVideoRawDataListener != null) {
            iTXVideoRawDataListener.onVideoRawDataAvailable(pixelFrame.getData(), pixelFrame.getWidth(), pixelFrame.getHeight(), (int) pixelFrame.getTimestamp());
        }
    }

    @Override // com.tencent.rtmp.ui.TXCloudVideoView.b
    public void onShowLog(boolean z) {
        showDebugView(z);
    }

    public void onSnapshot(Bitmap bitmap) {
        TXLivePlayer.ITXSnapshotListener iTXSnapshotListener = this.mSnapshotListener;
        if (iTXSnapshotListener != null) {
            iTXSnapshotListener.onSnapshot(bitmap);
        }
    }

    @Override // com.tencent.rtmp.a
    public void pause() {
        synchronized (this) {
            if (isNativeValid()) {
                nativePause(this.mNativeTXLivePlayerJni);
            }
        }
    }

    @Override // com.tencent.rtmp.a
    public int prepareLiveSeek(String str, int i) {
        return 0;
    }

    @Override // com.tencent.rtmp.a
    public void resume() {
        synchronized (this) {
            if (isNativeValid()) {
                nativeResume(this.mNativeTXLivePlayerJni);
            }
        }
    }

    @Override // com.tencent.rtmp.a
    public int resumeLive() {
        return 0;
    }

    @Override // com.tencent.rtmp.a
    public void seek(int i) {
    }

    @Override // com.tencent.rtmp.a
    public void setAudioRawDataListener(TXLivePlayer.ITXAudioRawDataListener iTXAudioRawDataListener) {
        synchronized (this) {
            this.mAudioRawDataListener = iTXAudioRawDataListener;
            if (isNativeValid()) {
                nativeEnableCustomAudioProcess(this.mNativeTXLivePlayerJni, iTXAudioRawDataListener != null);
            }
        }
    }

    @Override // com.tencent.rtmp.a
    public void setAudioRoute(int i) {
        synchronized (this) {
            this.mAudioRoute = Integer.valueOf(i);
            if (isNativeValid()) {
                nativeSetAudioRoute(this.mNativeTXLivePlayerJni, i);
            }
        }
    }

    @Override // com.tencent.rtmp.a
    public void setAudioVolumeEvaluationListener(TXLivePlayer.ITXAudioVolumeEvaluationListener iTXAudioVolumeEvaluationListener) {
        this.mAudioVolumeEvaluationListener = iTXAudioVolumeEvaluationListener;
    }

    @Override // com.tencent.rtmp.a
    public void setAutoPlay(boolean z) {
    }

    @Override // com.tencent.rtmp.a
    public void setConfig(TXLivePlayConfig tXLivePlayConfig) {
        synchronized (this) {
            if (tXLivePlayConfig == null) {
                return;
            }
            this.mConfig = tXLivePlayConfig;
            if (isNativeValid()) {
                nativeSetConfig(this.mNativeTXLivePlayerJni, this.mConfig.getCacheTime(), this.mConfig.getMaxAutoAdjustCacheTime(), this.mConfig.getMinAutoAdjustCacheTime(), this.mConfig.getVideoBlockThreshold(), this.mConfig.getConnectRetryCount(), this.mConfig.getConnectRetryInterval(), this.mConfig.isAutoAdjustCacheTime(), this.mConfig.isEnableMessage(), this.mConfig.isEnableMetaData(), this.mConfig.getFlvSessionKey(), this.mConfig.getHeaders());
            }
        }
    }

    @Override // com.tencent.rtmp.a
    public void setMute(boolean z) {
        synchronized (this) {
            this.mIsAudioMuted = Boolean.valueOf(z);
            if (isNativeValid()) {
                nativeSetMute(this.mNativeTXLivePlayerJni, z);
            }
        }
    }

    @Override // com.tencent.rtmp.a
    public void setPlayListener(ITXLivePlayListener iTXLivePlayListener) {
        this.mListener = iTXLivePlayListener;
    }

    @Override // com.tencent.rtmp.a
    public void setPlayerView(TXCloudVideoView tXCloudVideoView) {
        if (tXCloudVideoView != null) {
            a.a(tXCloudVideoView, new WeakReference(this));
            showDebugView(a.a(tXCloudVideoView));
        }
        synchronized (this) {
            if (tXCloudVideoView != null) {
                this.mDisplayTarget = new DisplayTarget(tXCloudVideoView);
            } else {
                this.mDisplayTarget = null;
            }
            if (isNativeValid()) {
                nativeSetPlayerView(this.mNativeTXLivePlayerJni, this.mDisplayTarget);
            }
        }
    }

    @Override // com.tencent.rtmp.a
    public void setRate(float f) {
    }

    @Override // com.tencent.rtmp.a
    public void setRenderMode(int i) {
        synchronized (this) {
            this.mRenderMode = Integer.valueOf(i);
            if (isNativeValid()) {
                nativeSetRenderMode(this.mNativeTXLivePlayerJni, i);
            }
        }
    }

    @Override // com.tencent.rtmp.a
    public void setRenderRotation(int i) {
        synchronized (this) {
            this.mRenderRotate = Integer.valueOf(i);
            if (isNativeValid()) {
                nativeSetRenderRotation(this.mNativeTXLivePlayerJni, i);
            }
        }
    }

    @Override // com.tencent.rtmp.a
    public void setSurface(Surface surface) {
        synchronized (this) {
            this.mSurface = surface;
            if (surface != null) {
                this.mDisplayTarget = new DisplayTarget(surface, this.mSurfaceWidth, this.mSurfaceHeight);
            } else {
                this.mDisplayTarget = null;
            }
            if (isNativeValid()) {
                nativeSetPlayerView(this.mNativeTXLivePlayerJni, this.mDisplayTarget);
            }
        }
    }

    @Override // com.tencent.rtmp.a
    public void setSurfaceSize(int i, int i2) {
        synchronized (this) {
            if (i < 0 || i2 < 0) {
                return;
            }
            this.mSurfaceWidth = i;
            this.mSurfaceHeight = i2;
            if (this.mSurface != null) {
                this.mDisplayTarget = new DisplayTarget(this.mSurface, i, i2);
            } else {
                this.mDisplayTarget = null;
            }
            if (isNativeValid() && this.mDisplayTarget != null) {
                nativeSetPlayerView(this.mNativeTXLivePlayerJni, this.mDisplayTarget);
            }
        }
    }

    @Override // com.tencent.rtmp.a
    public void setVideoRawDataListener(TXLivePlayer.ITXVideoRawDataListener iTXVideoRawDataListener) {
        synchronized (this) {
            boolean z = false;
            if (this.mVideoRenderListener != null) {
                this.mVideoRenderListener = null;
                this.mGLContext = null;
                if (isNativeValid()) {
                    nativeEnableCustomRenderTexture(this.mNativeTXLivePlayerJni, false, null);
                }
            }
            this.mVideoRawDataListener = iTXVideoRawDataListener;
            if (isNativeValid()) {
                long j = this.mNativeTXLivePlayerJni;
                if (iTXVideoRawDataListener != null) {
                    z = true;
                }
                nativeEnableCustomRenderI420(j, z);
            }
        }
    }

    @Override // com.tencent.rtmp.a
    public void setVideoRecordListener(TXRecordCommon.ITXVideoRecordListener iTXVideoRecordListener) {
        this.mVideoRecordListener = iTXVideoRecordListener;
    }

    @Override // com.tencent.rtmp.a
    public int setVideoRenderListener(TXLivePlayer.ITXLivePlayVideoRenderListener iTXLivePlayVideoRenderListener, Object obj) {
        synchronized (this) {
            if (this.mVideoRawDataListener != null) {
                this.mVideoRawDataListener = null;
                if (isNativeValid()) {
                    nativeEnableCustomRenderI420(this.mNativeTXLivePlayerJni, false);
                }
            }
            this.mVideoRenderListener = iTXLivePlayVideoRenderListener;
            if (iTXLivePlayVideoRenderListener == null) {
                obj = null;
            }
            this.mGLContext = obj;
            if (isNativeValid()) {
                nativeEnableCustomRenderTexture(this.mNativeTXLivePlayerJni, iTXLivePlayVideoRenderListener != null, this.mGLContext);
            }
        }
        return 0;
    }

    @Override // com.tencent.rtmp.a
    public void setVolume(int i) {
        synchronized (this) {
            this.mVolume = Integer.valueOf(i);
            if (isNativeValid()) {
                nativeSetVolume(this.mNativeTXLivePlayerJni, i);
            }
        }
    }

    @Override // com.tencent.rtmp.a
    public void showDebugView(boolean z) {
        synchronized (this) {
            this.mShowDebugView = Boolean.valueOf(z);
            if (isNativeValid()) {
                nativeShowDebugView(this.mNativeTXLivePlayerJni, z);
            }
        }
    }

    @Override // com.tencent.rtmp.a
    public void snapshot(TXLivePlayer.ITXSnapshotListener iTXSnapshotListener) {
        synchronized (this) {
            this.mSnapshotListener = iTXSnapshotListener;
            if (isNativeValid()) {
                nativeSnapshot(this.mNativeTXLivePlayerJni);
            }
        }
    }

    @Override // com.tencent.rtmp.a
    public int startPlay(String str, int i) {
        int nativeStartPlay;
        synchronized (this) {
            if (!isNativeValid()) {
                long nativeCreate = nativeCreate(new WeakReference(this));
                this.mNativeTXLivePlayerJni = nativeCreate;
                nativeSetPlayerView(nativeCreate, this.mDisplayTarget);
                if (this.mConfig != null) {
                    nativeSetConfig(this.mNativeTXLivePlayerJni, this.mConfig.getCacheTime(), this.mConfig.getMaxAutoAdjustCacheTime(), this.mConfig.getMinAutoAdjustCacheTime(), this.mConfig.getVideoBlockThreshold(), this.mConfig.getConnectRetryCount(), this.mConfig.getConnectRetryInterval(), this.mConfig.isAutoAdjustCacheTime(), this.mConfig.isEnableMessage(), this.mConfig.isEnableMetaData(), this.mConfig.getFlvSessionKey(), this.mConfig.getHeaders());
                }
                boolean z = true;
                if (this.mVideoRenderListener != null) {
                    nativeEnableCustomRenderI420(this.mNativeTXLivePlayerJni, false);
                    nativeEnableCustomRenderTexture(this.mNativeTXLivePlayerJni, true, this.mGLContext);
                } else if (this.mVideoRawDataListener != null) {
                    nativeEnableCustomRenderTexture(this.mNativeTXLivePlayerJni, false, this.mGLContext);
                    nativeEnableCustomRenderI420(this.mNativeTXLivePlayerJni, true);
                } else {
                    nativeEnableCustomRenderTexture(this.mNativeTXLivePlayerJni, false, this.mGLContext);
                    nativeEnableCustomRenderI420(this.mNativeTXLivePlayerJni, false);
                }
                long j = this.mNativeTXLivePlayerJni;
                if (this.mAudioRawDataListener == null) {
                    z = false;
                }
                nativeEnableCustomAudioProcess(j, z);
                if (this.mRenderMode != null) {
                    nativeSetRenderMode(this.mNativeTXLivePlayerJni, this.mRenderMode.intValue());
                }
                if (this.mRenderRotate != null) {
                    nativeSetRenderRotation(this.mNativeTXLivePlayerJni, this.mRenderRotate.intValue());
                }
                if (this.mEnableHardwareDecoder != null) {
                    nativeEnableHardwareDecode(this.mNativeTXLivePlayerJni, this.mEnableHardwareDecoder.booleanValue());
                }
                if (this.mVolume != null) {
                    nativeSetVolume(this.mNativeTXLivePlayerJni, this.mVolume.intValue());
                }
                if (this.mAudioRoute != null) {
                    nativeSetAudioRoute(this.mNativeTXLivePlayerJni, this.mAudioRoute.intValue());
                }
                if (this.mVolumeIntervalMs != null) {
                    nativeEnableAudioVolumeEvaluation(this.mNativeTXLivePlayerJni, this.mVolumeIntervalMs.intValue());
                }
                if (this.mIsAudioMuted != null) {
                    nativeSetMute(this.mNativeTXLivePlayerJni, this.mIsAudioMuted.booleanValue());
                }
                if (this.mShowDebugView != null) {
                    nativeShowDebugView(this.mNativeTXLivePlayerJni, this.mShowDebugView.booleanValue());
                }
                if (this.mAESKey != null && this.mAESURL != null && this.mAESMode != null && this.mAESIV != null) {
                    nativeSetAESCodecParams(this.mNativeTXLivePlayerJni, this.mAESURL, this.mAESMode.intValue(), this.mAESKey, this.mAESIV);
                }
                if (this.mNativeAudioJitterBufferControllerFactory != null) {
                    nativeSetAudioJitterBufferControllerFactory(this.mNativeTXLivePlayerJni, this.mNativeAudioJitterBufferControllerFactory.longValue());
                }
            }
            nativeStartPlay = nativeStartPlay(this.mNativeTXLivePlayerJni, str, i);
        }
        return nativeStartPlay;
    }

    @Override // com.tencent.rtmp.a
    public int startRecord(int i) {
        synchronized (this) {
            if (isNativeValid()) {
                String genFilePath = genFilePath(ContextUtils.getApplicationContext(), ".mp4");
                if (TextUtils.isEmpty(genFilePath)) {
                    return -1;
                }
                nativeStartRecord(this.mNativeTXLivePlayerJni, i, genFilePath);
            }
            return 0;
        }
    }

    @Override // com.tencent.rtmp.a
    public int stopPlay(boolean z) {
        synchronized (this) {
            DisplayTarget displayTarget = this.mDisplayTarget;
            if (displayTarget != null && z) {
                displayTarget.hideAll();
            }
            if (isNativeValid()) {
                nativeStopPlay(this.mNativeTXLivePlayerJni);
                nativeDestroy(this.mNativeTXLivePlayerJni);
                this.mNativeTXLivePlayerJni = 0L;
            }
        }
        return 0;
    }

    @Override // com.tencent.rtmp.a
    public int stopRecord() {
        synchronized (this) {
            if (isNativeValid()) {
                nativeStopRecord(this.mNativeTXLivePlayerJni);
            }
        }
        return 0;
    }

    @Override // com.tencent.rtmp.a
    public int switchStream(String str) {
        synchronized (this) {
            if (TextUtils.isEmpty(str)) {
                LiteavLog.e(TAG, "Invalid params.");
                return -1;
            } else if (isNativeValid()) {
                return nativeSwitchStream(this.mNativeTXLivePlayerJni, str);
            } else {
                return -1;
            }
        }
    }
}
