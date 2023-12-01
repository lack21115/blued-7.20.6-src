package com.tencent.liteav.live;

import android.content.Context;
import android.graphics.Bitmap;
import android.nfc.cardemulation.CardEmulation;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Surface;
import android.view.SurfaceView;
import android.view.TextureView;
import com.tencent.liteav.base.ContextUtils;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.videobase.base.GLConstants;
import com.tencent.liteav.videobase.frame.PixelFrame;
import com.tencent.liteav.videobase.utils.Rotation;
import com.tencent.liteav.videobase.videobase.DisplayTarget;
import com.tencent.live2.V2TXLiveDef;
import com.tencent.live2.V2TXLivePlayer;
import com.tencent.live2.V2TXLivePlayerObserver;
import com.tencent.live2.impl.V2TXLiveDefInner;
import com.tencent.live2.impl.V2TXLivePlayerImpl;
import com.tencent.live2.impl.V2TXLiveProperty;
import com.tencent.rtmp.ui.TXCloudVideoView;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javax.microedition.khronos.egl.EGLContext;
import org.json.JSONObject;

@JNINamespace("liteav")
/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/live/V2TXLivePlayerJni.class */
public class V2TXLivePlayerJni extends V2TXLivePlayer {
    private static final String TAG = "V2TXLivePlayerJni";
    private Integer mAudioRoute;
    private GLConstants.PixelBufferType mBufferType;
    private Integer mComponent;
    private DisplayTarget mDisplayTarget;
    private Boolean mEnableCustomRendering;
    private Boolean mEnableExtensionCallback;
    private Boolean mEnableHardwareDecode;
    private Boolean mEnableRTMPAcc;
    private Integer mFramework;
    private Boolean mIsPauseAudio;
    private Boolean mIsPauseVideo;
    private Float mMax;
    private Float mMin;
    private V2TXLivePlayerObserver mObserver;
    private GLConstants.PixelFormatType mPixelFormatType;
    private V2TXLivePlayerImpl mProxy;
    private Integer mRetryInterval;
    private Integer mRetryLimits;
    private Rotation mRotation;
    private GLConstants.GLScaleType mScaleType;
    private Boolean mShowDebugView;
    private Surface mSurface;
    private V2TXLiveDefInner.SurfaceSize mSurfaceSize;
    private Integer mVolume;
    private Integer mVolumeIntervalMs;
    protected long mNativeV2TXLivePlayerJni = 0;
    private Set<Integer> mSEIPayloadSet = new HashSet();
    private String mLEBEnv = "";
    private HashMap<String, Object> mPropertyMap = new HashMap<>();

    /* renamed from: com.tencent.liteav.live.V2TXLivePlayerJni$1  reason: invalid class name */
    /* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/live/V2TXLivePlayerJni$1.class */
    static final /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f22708a;
        static final /* synthetic */ int[] b;

        /* renamed from: c  reason: collision with root package name */
        static final /* synthetic */ int[] f22709c;
        static final /* synthetic */ int[] d;
        static final /* synthetic */ int[] e;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:35:0x00c8 -> B:65:0x0014). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x00cc -> B:77:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:39:0x00d0 -> B:73:0x002a). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:41:0x00d4 -> B:10:0x0035). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:43:0x00d8 -> B:81:0x0049). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:45:0x00dc -> B:89:0x0054). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:47:0x00e0 -> B:17:0x005f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:49:0x00e4 -> B:67:0x0073). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:51:0x00e8 -> B:22:0x007e). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:53:0x00ec -> B:75:0x0092). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:55:0x00f0 -> B:27:0x009d). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:57:0x00f4 -> B:83:0x00b1). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:59:0x00f8 -> B:79:0x00bc). Please submit an issue!!! */
        static {
            int[] iArr = new int[Rotation.values().length];
            e = iArr;
            try {
                iArr[Rotation.NORMAL.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                e[Rotation.ROTATION_90.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
            try {
                e[Rotation.ROTATION_180.ordinal()] = 3;
            } catch (NoSuchFieldError e4) {
            }
            try {
                e[Rotation.ROTATION_270.ordinal()] = 4;
            } catch (NoSuchFieldError e5) {
            }
            int[] iArr2 = new int[GLConstants.PixelBufferType.values().length];
            d = iArr2;
            try {
                iArr2[GLConstants.PixelBufferType.BYTE_BUFFER.ordinal()] = 1;
            } catch (NoSuchFieldError e6) {
            }
            try {
                d[GLConstants.PixelBufferType.BYTE_ARRAY.ordinal()] = 2;
            } catch (NoSuchFieldError e7) {
            }
            try {
                d[GLConstants.PixelBufferType.TEXTURE_2D.ordinal()] = 3;
            } catch (NoSuchFieldError e8) {
            }
            int[] iArr3 = new int[GLConstants.PixelFormatType.values().length];
            f22709c = iArr3;
            try {
                iArr3[GLConstants.PixelFormatType.I420.ordinal()] = 1;
            } catch (NoSuchFieldError e9) {
            }
            try {
                f22709c[GLConstants.PixelFormatType.RGBA.ordinal()] = 2;
            } catch (NoSuchFieldError e10) {
            }
            int[] iArr4 = new int[V2TXLiveDef.V2TXLiveFillMode.values().length];
            b = iArr4;
            try {
                iArr4[V2TXLiveDef.V2TXLiveFillMode.V2TXLiveFillModeFill.ordinal()] = 1;
            } catch (NoSuchFieldError e11) {
            }
            try {
                b[V2TXLiveDef.V2TXLiveFillMode.V2TXLiveFillModeScaleFill.ordinal()] = 2;
            } catch (NoSuchFieldError e12) {
            }
            int[] iArr5 = new int[V2TXLiveDef.V2TXLiveRotation.values().length];
            f22708a = iArr5;
            try {
                iArr5[V2TXLiveDef.V2TXLiveRotation.V2TXLiveRotation90.ordinal()] = 1;
            } catch (NoSuchFieldError e13) {
            }
            try {
                f22708a[V2TXLiveDef.V2TXLiveRotation.V2TXLiveRotation180.ordinal()] = 2;
            } catch (NoSuchFieldError e14) {
            }
            try {
                f22708a[V2TXLiveDef.V2TXLiveRotation.V2TXLiveRotation270.ordinal()] = 3;
            } catch (NoSuchFieldError e15) {
            }
        }
    }

    public V2TXLivePlayerJni(Context context, V2TXLivePlayerImpl v2TXLivePlayerImpl) {
        this.mProxy = v2TXLivePlayerImpl;
        ContextUtils.initApplicationContext(context.getApplicationContext());
        ContextUtils.setDataDirectorySuffix("liteav");
    }

    private void enableExtensionCallback(boolean z) {
        synchronized (this) {
            this.mEnableExtensionCallback = Boolean.valueOf(z);
            if (isNativeValid()) {
                nativeEnableExtensionCallback(this.mNativeV2TXLivePlayerJni, z);
            }
        }
    }

    public static V2TXLiveDef.V2TXLivePlayerStatistics getJavaV2TXLivePlayerStatistics(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        V2TXLiveDef.V2TXLivePlayerStatistics v2TXLivePlayerStatistics = new V2TXLiveDef.V2TXLivePlayerStatistics();
        v2TXLivePlayerStatistics.appCpu = i;
        v2TXLivePlayerStatistics.systemCpu = i2;
        v2TXLivePlayerStatistics.width = i3;
        v2TXLivePlayerStatistics.height = i4;
        v2TXLivePlayerStatistics.fps = i5;
        v2TXLivePlayerStatistics.videoBitrate = i6;
        v2TXLivePlayerStatistics.audioBitrate = i7;
        return v2TXLivePlayerStatistics;
    }

    private boolean isNativeValid() {
        return this.mNativeV2TXLivePlayerJni != 0;
    }

    private static native long nativeCreate(WeakReference<V2TXLivePlayerJni> weakReference);

    private static native void nativeDestroy(long j);

    private static native int nativeEnableCustomRendering(long j, boolean z, int i, int i2);

    private static native void nativeEnableExtensionCallback(long j, boolean z);

    private static native void nativeEnableHardwareDecode(long j, boolean z);

    private static native void nativeEnableRTMPAcc(long j, boolean z);

    private static native int nativeEnableReceiveSeiMessage(long j, boolean z, int i);

    private static native int nativeEnableVolumeEvaluation(long j, int i);

    private static native int nativeIsPlaying(long j);

    private static native int nativePauseAudio(long j);

    private static native int nativePauseVideo(long j);

    private static native int nativeResumeAudio(long j);

    private static native int nativeResumeVideo(long j);

    private static native void nativeSetAudioRoute(long j, int i);

    private static native int nativeSetCacheParams(long j, float f, float f2);

    private static native void nativeSetFramework(long j, int i, int i2);

    private static native void nativeSetLEBEnv(long j, String str);

    private static native int nativeSetPlayoutVolume(long j, int i);

    private static native int nativeSetProperty(long j, String str, Object obj);

    private static native int nativeSetRenderFillMode(long j, int i);

    private static native int nativeSetRenderRotation(long j, int i);

    private static native int nativeSetRenderView(long j, DisplayTarget displayTarget);

    private static native void nativeSetRetryInterval(long j, int i);

    private static native void nativeSetRetryLimits(long j, int i);

    private static native void nativeShowDebugView(long j, boolean z);

    private static native int nativeSnapshot(long j);

    private static native int nativeStartPlay(long j, String str);

    private static native int nativeStopPlay(long j);

    private static native int nativeSwitchStream(long j, String str);

    public static V2TXLivePlayerJni weakToStrongReference(WeakReference<V2TXLivePlayerJni> weakReference) {
        return weakReference.get();
    }

    @Override // com.tencent.live2.V2TXLivePlayer
    public int enableObserveVideoFrame(boolean z, V2TXLiveDef.V2TXLivePixelFormat v2TXLivePixelFormat, V2TXLiveDef.V2TXLiveBufferType v2TXLiveBufferType) {
        synchronized (this) {
            if (v2TXLivePixelFormat == V2TXLiveDef.V2TXLivePixelFormat.V2TXLivePixelFormatI420 && v2TXLiveBufferType == V2TXLiveDef.V2TXLiveBufferType.V2TXLiveBufferTypeByteArray) {
                this.mPixelFormatType = GLConstants.PixelFormatType.I420;
                this.mBufferType = GLConstants.PixelBufferType.BYTE_ARRAY;
            } else if (v2TXLivePixelFormat == V2TXLiveDef.V2TXLivePixelFormat.V2TXLivePixelFormatTexture2D && v2TXLiveBufferType == V2TXLiveDef.V2TXLiveBufferType.V2TXLiveBufferTypeTexture) {
                this.mPixelFormatType = GLConstants.PixelFormatType.RGBA;
                this.mBufferType = GLConstants.PixelBufferType.TEXTURE_2D;
            } else if (v2TXLivePixelFormat != V2TXLiveDef.V2TXLivePixelFormat.V2TXLivePixelFormatI420 || v2TXLiveBufferType != V2TXLiveDef.V2TXLiveBufferType.V2TXLiveBufferTypeByteBuffer) {
                LiteavLog.e(TAG, "Enable custom render failed, invalid params. format:" + v2TXLivePixelFormat + " type:" + v2TXLiveBufferType);
                return -4;
            } else {
                this.mPixelFormatType = GLConstants.PixelFormatType.I420;
                this.mBufferType = GLConstants.PixelBufferType.BYTE_BUFFER;
            }
            this.mEnableCustomRendering = Boolean.valueOf(z);
            if (isNativeValid()) {
                return nativeEnableCustomRendering(this.mNativeV2TXLivePlayerJni, z, this.mPixelFormatType.getValue(), this.mBufferType.ordinal());
            }
            return 0;
        }
    }

    @Override // com.tencent.live2.V2TXLivePlayer
    public int enableReceiveSeiMessage(boolean z, int i) {
        synchronized (this) {
            if (z) {
                this.mSEIPayloadSet.add(Integer.valueOf(i));
            } else {
                this.mSEIPayloadSet.remove(Integer.valueOf(i));
            }
            if (isNativeValid()) {
                return nativeEnableReceiveSeiMessage(this.mNativeV2TXLivePlayerJni, z, i);
            }
            return 0;
        }
    }

    @Override // com.tencent.live2.V2TXLivePlayer
    public int enableVolumeEvaluation(int i) {
        synchronized (this) {
            this.mVolumeIntervalMs = Integer.valueOf(i);
            if (isNativeValid()) {
                return nativeEnableVolumeEvaluation(this.mNativeV2TXLivePlayerJni, i);
            }
            return 0;
        }
    }

    @Override // com.tencent.live2.V2TXLivePlayer
    public int isPlaying() {
        synchronized (this) {
            if (isNativeValid()) {
                return nativeIsPlaying(this.mNativeV2TXLivePlayerJni);
            }
            return 0;
        }
    }

    public void onAudioLoading(Bundle bundle) {
        V2TXLivePlayerObserver v2TXLivePlayerObserver = this.mObserver;
        if (v2TXLivePlayerObserver != null) {
            v2TXLivePlayerObserver.onAudioLoading(this.mProxy, bundle);
        }
    }

    public void onAudioPlaying(boolean z, Bundle bundle) {
        V2TXLivePlayerObserver v2TXLivePlayerObserver = this.mObserver;
        if (v2TXLivePlayerObserver != null) {
            v2TXLivePlayerObserver.onAudioPlaying(this.mProxy, z, bundle);
        }
    }

    public void onConnected(Bundle bundle) {
        V2TXLivePlayerObserver v2TXLivePlayerObserver = this.mObserver;
        if (v2TXLivePlayerObserver != null) {
            v2TXLivePlayerObserver.onConnected(this.mProxy, bundle);
        }
    }

    public void onError(int i, String str, Bundle bundle) {
        V2TXLivePlayerObserver v2TXLivePlayerObserver = this.mObserver;
        if (v2TXLivePlayerObserver != null) {
            v2TXLivePlayerObserver.onError(this.mProxy, i, str, bundle);
        }
    }

    public void onNetworkQuality(int i) {
    }

    public void onPlayEvent(int i, Bundle bundle) {
    }

    public void onPlayNetStatus(Bundle bundle) {
    }

    public void onPlayoutVolumeUpdate(int i) {
        V2TXLivePlayerObserver v2TXLivePlayerObserver = this.mObserver;
        if (v2TXLivePlayerObserver != null) {
            v2TXLivePlayerObserver.onPlayoutVolumeUpdate(this.mProxy, i);
        }
    }

    public void onReceiveSeiMessage(int i, byte[] bArr) {
        V2TXLivePlayerObserver v2TXLivePlayerObserver = this.mObserver;
        if (v2TXLivePlayerObserver != null) {
            v2TXLivePlayerObserver.onReceiveSeiMessage(this.mProxy, i, bArr);
        }
    }

    public void onRenderVideoFrame(PixelFrame pixelFrame) {
        V2TXLiveDef.V2TXLiveVideoFrame v2TXLiveVideoFrame = new V2TXLiveDef.V2TXLiveVideoFrame();
        int i = AnonymousClass1.f22709c[pixelFrame.getPixelFormatType().ordinal()];
        if (i == 1) {
            v2TXLiveVideoFrame.pixelFormat = V2TXLiveDef.V2TXLivePixelFormat.V2TXLivePixelFormatI420;
        } else if (i != 2) {
            LiteavLog.e(TAG, "Invalid pixelFormat. pixelFormat:" + pixelFrame.getPixelFormatType() + ".");
        } else {
            v2TXLiveVideoFrame.pixelFormat = V2TXLiveDef.V2TXLivePixelFormat.V2TXLivePixelFormatTexture2D;
        }
        int i2 = AnonymousClass1.d[pixelFrame.getPixelBufferType().ordinal()];
        if (i2 == 1) {
            v2TXLiveVideoFrame.bufferType = V2TXLiveDef.V2TXLiveBufferType.V2TXLiveBufferTypeByteBuffer;
        } else if (i2 == 2) {
            v2TXLiveVideoFrame.bufferType = V2TXLiveDef.V2TXLiveBufferType.V2TXLiveBufferTypeByteArray;
        } else if (i2 != 3) {
            LiteavLog.e(TAG, "Invalid bufferType. bufferType:" + pixelFrame.getPixelBufferType() + ".");
        } else {
            v2TXLiveVideoFrame.bufferType = V2TXLiveDef.V2TXLiveBufferType.V2TXLiveBufferTypeTexture;
        }
        V2TXLiveDef.V2TXLiveTexture v2TXLiveTexture = new V2TXLiveDef.V2TXLiveTexture();
        v2TXLiveTexture.textureId = pixelFrame.getTextureId();
        if (pixelFrame.getGLContext() instanceof EGLContext) {
            v2TXLiveTexture.eglContext10 = (EGLContext) pixelFrame.getGLContext();
        } else if (Build.VERSION.SDK_INT >= 17 && (pixelFrame.getGLContext() instanceof android.opengl.EGLContext)) {
            v2TXLiveTexture.eglContext14 = (android.opengl.EGLContext) pixelFrame.getGLContext();
        }
        v2TXLiveVideoFrame.texture = v2TXLiveTexture;
        v2TXLiveVideoFrame.data = pixelFrame.getData();
        v2TXLiveVideoFrame.buffer = pixelFrame.getBuffer();
        v2TXLiveVideoFrame.width = pixelFrame.getWidth();
        v2TXLiveVideoFrame.height = pixelFrame.getHeight();
        int i3 = AnonymousClass1.e[pixelFrame.getRotation().ordinal()];
        if (i3 == 1) {
            v2TXLiveVideoFrame.rotation = 0;
        } else if (i3 == 2) {
            v2TXLiveVideoFrame.rotation = 90;
        } else if (i3 == 3) {
            v2TXLiveVideoFrame.rotation = 180;
        } else if (i3 != 4) {
            v2TXLiveVideoFrame.rotation = 0;
        } else {
            v2TXLiveVideoFrame.rotation = 270;
        }
        V2TXLivePlayerObserver v2TXLivePlayerObserver = this.mObserver;
        if (v2TXLivePlayerObserver != null) {
            v2TXLivePlayerObserver.onRenderVideoFrame(this.mProxy, v2TXLiveVideoFrame);
        }
    }

    public void onSnapshotComplete(Bitmap bitmap) {
        V2TXLivePlayerObserver v2TXLivePlayerObserver = this.mObserver;
        if (v2TXLivePlayerObserver != null) {
            v2TXLivePlayerObserver.onSnapshotComplete(this.mProxy, bitmap);
        }
    }

    public void onStatisticsUpdate(V2TXLiveDef.V2TXLivePlayerStatistics v2TXLivePlayerStatistics) {
        V2TXLivePlayerObserver v2TXLivePlayerObserver = this.mObserver;
        if (v2TXLivePlayerObserver != null) {
            v2TXLivePlayerObserver.onStatisticsUpdate(this.mProxy, v2TXLivePlayerStatistics);
        }
    }

    public void onVideoLoading(Bundle bundle) {
        V2TXLivePlayerObserver v2TXLivePlayerObserver = this.mObserver;
        if (v2TXLivePlayerObserver != null) {
            v2TXLivePlayerObserver.onVideoLoading(this.mProxy, bundle);
        }
    }

    public void onVideoPlaying(boolean z, Bundle bundle) {
        V2TXLivePlayerObserver v2TXLivePlayerObserver = this.mObserver;
        if (v2TXLivePlayerObserver != null) {
            v2TXLivePlayerObserver.onVideoPlaying(this.mProxy, z, bundle);
        }
    }

    public void onVideoResolutionChanged(int i, int i2) {
        V2TXLivePlayerObserver v2TXLivePlayerObserver = this.mObserver;
        if (v2TXLivePlayerObserver != null) {
            v2TXLivePlayerObserver.onVideoResolutionChanged(this.mProxy, i, i2);
        }
    }

    public void onWarning(int i, String str, Bundle bundle) {
        V2TXLivePlayerObserver v2TXLivePlayerObserver = this.mObserver;
        if (v2TXLivePlayerObserver != null) {
            v2TXLivePlayerObserver.onWarning(this.mProxy, i, str, bundle);
        }
    }

    @Override // com.tencent.live2.V2TXLivePlayer
    public int pauseAudio() {
        synchronized (this) {
            this.mIsPauseAudio = Boolean.TRUE;
            if (isNativeValid()) {
                return nativePauseAudio(this.mNativeV2TXLivePlayerJni);
            }
            return 0;
        }
    }

    @Override // com.tencent.live2.V2TXLivePlayer
    public int pauseVideo() {
        synchronized (this) {
            this.mIsPauseVideo = Boolean.TRUE;
            if (isNativeValid()) {
                return nativePauseVideo(this.mNativeV2TXLivePlayerJni);
            }
            return 0;
        }
    }

    @Override // com.tencent.live2.V2TXLivePlayer
    public int resumeAudio() {
        synchronized (this) {
            this.mIsPauseAudio = Boolean.FALSE;
            if (isNativeValid()) {
                return nativeResumeAudio(this.mNativeV2TXLivePlayerJni);
            }
            return 0;
        }
    }

    @Override // com.tencent.live2.V2TXLivePlayer
    public int resumeVideo() {
        synchronized (this) {
            this.mIsPauseVideo = Boolean.FALSE;
            if (isNativeValid()) {
                return nativeResumeVideo(this.mNativeV2TXLivePlayerJni);
            }
            return 0;
        }
    }

    @Override // com.tencent.live2.V2TXLivePlayer
    public int setCacheParams(float f, float f2) {
        synchronized (this) {
            if (f < 0.0f || f2 < 0.0f) {
                return -2;
            }
            this.mMin = Float.valueOf(f);
            this.mMax = Float.valueOf(f2);
            if (isNativeValid()) {
                return nativeSetCacheParams(this.mNativeV2TXLivePlayerJni, f, f2);
            }
            return 0;
        }
    }

    @Override // com.tencent.live2.V2TXLivePlayer
    public void setObserver(V2TXLivePlayerObserver v2TXLivePlayerObserver) {
        this.mObserver = v2TXLivePlayerObserver;
        if (v2TXLivePlayerObserver == null || !(v2TXLivePlayerObserver instanceof com.tencent.live2.impl.a.a)) {
            return;
        }
        enableExtensionCallback(true);
    }

    @Override // com.tencent.live2.V2TXLivePlayer
    public int setPlayoutVolume(int i) {
        synchronized (this) {
            this.mVolume = Integer.valueOf(i);
            if (isNativeValid()) {
                return nativeSetPlayoutVolume(this.mNativeV2TXLivePlayerJni, i);
            }
            return 0;
        }
    }

    @Override // com.tencent.live2.V2TXLivePlayer
    public int setProperty(String str, Object obj) {
        synchronized (this) {
            boolean z = true;
            switch (str.hashCode()) {
                case -1551400628:
                    if (str.equals(V2TXLiveDefInner.TXLivePropertyKey.kV2SetLEBEnvironment)) {
                        z = true;
                        break;
                    }
                    break;
                case -780243797:
                    if (str.equals(V2TXLiveProperty.kV2EnableHardwareAcceleration)) {
                        z = false;
                        break;
                    }
                    break;
                case -525993788:
                    if (str.equals(V2TXLiveProperty.kV2SetHeaders)) {
                        z = true;
                        break;
                    }
                    break;
                case 480042124:
                    if (str.equals(V2TXLiveDefInner.TXLivePropertyKey.kV2SetSurfaceSize)) {
                        z = true;
                        break;
                    }
                    break;
                case 1120433643:
                    if (str.equals(V2TXLiveDefInner.TXLivePropertyKey.kV2SetSurface)) {
                        z = true;
                        break;
                    }
                    break;
                case 1637676021:
                    if (str.equals(V2TXLiveProperty.kV2MaxNumberOfReconnection)) {
                        z = true;
                        break;
                    }
                    break;
                case 1694085113:
                    if (str.equals(V2TXLiveDefInner.TXLivePropertyKey.kV2EnableRTMPAcc)) {
                        z = true;
                        break;
                    }
                    break;
                case 1899639930:
                    if (str.equals(V2TXLiveProperty.kV2SecondsBetweenReconnection)) {
                        z = true;
                        break;
                    }
                    break;
                case 2013602325:
                    if (str.equals(V2TXLiveDefInner.TXLivePropertyKey.kV2SetAudioRoute)) {
                        z = true;
                        break;
                    }
                    break;
                case 2085561276:
                    if (str.equals(V2TXLiveDefInner.TXLivePropertyKey.kV2SetFramework)) {
                        z = true;
                        break;
                    }
                    break;
            }
            switch (z) {
                case false:
                    if (obj instanceof Boolean) {
                        synchronized (this) {
                            this.mEnableHardwareDecode = (Boolean) obj;
                            if (isNativeValid()) {
                                nativeEnableHardwareDecode(this.mNativeV2TXLivePlayerJni, this.mEnableHardwareDecode.booleanValue());
                            }
                            break;
                        }
                        return 0;
                    }
                    LiteavLog.e(TAG, "setProperty error, key:" + str + ", value:" + obj);
                    return -2;
                case true:
                    if (!(obj instanceof Integer)) {
                        LiteavLog.e(TAG, "setProperty error, key:" + str + ", value:" + obj);
                        return -2;
                    }
                    synchronized (this) {
                        this.mRetryLimits = (Integer) obj;
                        if (isNativeValid()) {
                            nativeSetRetryLimits(this.mNativeV2TXLivePlayerJni, this.mRetryLimits.intValue());
                        }
                        break;
                    }
                case true:
                    if (!(obj instanceof Integer)) {
                        LiteavLog.e(TAG, "setProperty error, key:" + str + ", value:" + obj);
                        return -2;
                    }
                    synchronized (this) {
                        this.mRetryInterval = (Integer) obj;
                        if (isNativeValid()) {
                            nativeSetRetryInterval(this.mNativeV2TXLivePlayerJni, this.mRetryInterval.intValue());
                        }
                        break;
                    }
                case true:
                    synchronized (this) {
                        this.mPropertyMap.put(str, obj);
                        if (isNativeValid()) {
                            nativeSetProperty(this.mNativeV2TXLivePlayerJni, str, obj);
                        }
                        break;
                    }
                case true:
                    if (obj instanceof String) {
                        String str2 = (String) obj;
                        if (!TextUtils.isEmpty(str2)) {
                            synchronized (this) {
                                this.mLEBEnv = str2;
                                if (isNativeValid()) {
                                    nativeSetLEBEnv(this.mNativeV2TXLivePlayerJni, this.mLEBEnv);
                                }
                                break;
                            }
                        } else {
                            return -2;
                        }
                    } else {
                        return -2;
                    }
                case true:
                    if (!(obj instanceof String)) {
                        LiteavLog.e(TAG, "setProperty error, key:" + str + ", value:" + obj);
                        return -2;
                    }
                    try {
                        JSONObject jSONObject = new JSONObject((String) obj);
                        synchronized (this) {
                            this.mFramework = Integer.valueOf(jSONObject.optInt("framework", 0));
                            this.mComponent = Integer.valueOf(jSONObject.optInt(CardEmulation.EXTRA_SERVICE_COMPONENT, 0));
                            if (isNativeValid()) {
                                nativeSetFramework(this.mNativeV2TXLivePlayerJni, this.mFramework.intValue(), this.mComponent.intValue());
                            }
                            break;
                        }
                    } catch (Exception e) {
                        LiteavLog.e(TAG, "setProperty error, key:" + str + ", value:" + obj, e);
                        return -2;
                    }
                case true:
                    if (obj != null) {
                        if (!(obj instanceof Surface)) {
                            LiteavLog.e(TAG, "setProperty error, key:" + str + ", value:" + obj);
                            return -2;
                        }
                        synchronized (this) {
                            Surface surface = (Surface) obj;
                            this.mSurface = surface;
                            if (this.mSurfaceSize != null) {
                                this.mDisplayTarget = new DisplayTarget(surface, this.mSurfaceSize.width, this.mSurfaceSize.height);
                                if (isNativeValid()) {
                                    nativeSetRenderView(this.mNativeV2TXLivePlayerJni, this.mDisplayTarget);
                                }
                            }
                            break;
                        }
                    } else {
                        synchronized (this) {
                            this.mSurface = null;
                            this.mDisplayTarget = null;
                            if (isNativeValid()) {
                                nativeSetRenderView(this.mNativeV2TXLivePlayerJni, null);
                            }
                        }
                        return 0;
                    }
                case true:
                    if (obj != null) {
                        if (!(obj instanceof V2TXLiveDefInner.SurfaceSize)) {
                            LiteavLog.e(TAG, "setProperty error, key:" + str + ", value:" + obj);
                            return -2;
                        }
                        synchronized (this) {
                            V2TXLiveDefInner.SurfaceSize surfaceSize = (V2TXLiveDefInner.SurfaceSize) obj;
                            this.mSurfaceSize = surfaceSize;
                            if (this.mSurface != null) {
                                this.mDisplayTarget = new DisplayTarget(this.mSurface, surfaceSize.width, this.mSurfaceSize.height);
                                if (isNativeValid()) {
                                    nativeSetRenderView(this.mNativeV2TXLivePlayerJni, this.mDisplayTarget);
                                }
                            }
                            break;
                        }
                    } else {
                        this.mSurfaceSize = null;
                        return 0;
                    }
                case true:
                    if (!(obj instanceof Boolean)) {
                        LiteavLog.e(TAG, "setProperty error, key:" + str + ", value:" + obj);
                        return -2;
                    }
                    synchronized (this) {
                        this.mEnableRTMPAcc = (Boolean) obj;
                        if (isNativeValid()) {
                            nativeEnableRTMPAcc(this.mNativeV2TXLivePlayerJni, this.mEnableRTMPAcc.booleanValue());
                        }
                        break;
                    }
                case true:
                    if (!(obj instanceof Integer)) {
                        LiteavLog.e(TAG, "setProperty error, key:" + str + ", value:" + obj);
                        return -2;
                    }
                    synchronized (this) {
                        this.mAudioRoute = (Integer) obj;
                        if (isNativeValid()) {
                            nativeSetAudioRoute(this.mNativeV2TXLivePlayerJni, this.mAudioRoute.intValue());
                        }
                        break;
                    }
                default:
                    LiteavLog.e(TAG, "setProperty error, key:" + str + ", value:" + obj);
                    return -4;
            }
            return 0;
        }
    }

    @Override // com.tencent.live2.V2TXLivePlayer
    public int setRenderFillMode(V2TXLiveDef.V2TXLiveFillMode v2TXLiveFillMode) {
        synchronized (this) {
            int i = AnonymousClass1.b[v2TXLiveFillMode.ordinal()];
            if (i == 1) {
                this.mScaleType = GLConstants.GLScaleType.CENTER_CROP;
            } else if (i != 2) {
                this.mScaleType = GLConstants.GLScaleType.FIT_CENTER;
            } else {
                this.mScaleType = GLConstants.GLScaleType.FILL;
            }
            if (isNativeValid()) {
                return nativeSetRenderFillMode(this.mNativeV2TXLivePlayerJni, this.mScaleType.mValue);
            }
            return 0;
        }
    }

    @Override // com.tencent.live2.V2TXLivePlayer
    public int setRenderRotation(V2TXLiveDef.V2TXLiveRotation v2TXLiveRotation) {
        synchronized (this) {
            int i = AnonymousClass1.f22708a[v2TXLiveRotation.ordinal()];
            if (i == 1) {
                this.mRotation = Rotation.ROTATION_90;
            } else if (i == 2) {
                this.mRotation = Rotation.ROTATION_180;
            } else if (i != 3) {
                this.mRotation = Rotation.NORMAL;
            } else {
                this.mRotation = Rotation.ROTATION_270;
            }
            if (isNativeValid()) {
                return nativeSetRenderRotation(this.mNativeV2TXLivePlayerJni, this.mRotation.mValue);
            }
            return 0;
        }
    }

    @Override // com.tencent.live2.V2TXLivePlayer
    public int setRenderView(SurfaceView surfaceView) {
        synchronized (this) {
            if (surfaceView != null) {
                this.mDisplayTarget = new DisplayTarget(surfaceView);
            } else {
                this.mDisplayTarget = null;
            }
            if (isNativeValid()) {
                return nativeSetRenderView(this.mNativeV2TXLivePlayerJni, this.mDisplayTarget);
            }
            return 0;
        }
    }

    @Override // com.tencent.live2.V2TXLivePlayer
    public int setRenderView(TextureView textureView) {
        synchronized (this) {
            if (textureView != null) {
                this.mDisplayTarget = new DisplayTarget(textureView);
            } else {
                this.mDisplayTarget = null;
            }
            if (isNativeValid()) {
                return nativeSetRenderView(this.mNativeV2TXLivePlayerJni, this.mDisplayTarget);
            }
            return 0;
        }
    }

    @Override // com.tencent.live2.V2TXLivePlayer
    public int setRenderView(TXCloudVideoView tXCloudVideoView) {
        synchronized (this) {
            if (tXCloudVideoView != null) {
                this.mDisplayTarget = new DisplayTarget(tXCloudVideoView);
            } else {
                this.mDisplayTarget = null;
            }
            if (isNativeValid()) {
                return nativeSetRenderView(this.mNativeV2TXLivePlayerJni, this.mDisplayTarget);
            }
            return 0;
        }
    }

    @Override // com.tencent.live2.V2TXLivePlayer
    public void showDebugView(boolean z) {
        synchronized (this) {
            this.mShowDebugView = Boolean.valueOf(z);
            if (isNativeValid()) {
                nativeShowDebugView(this.mNativeV2TXLivePlayerJni, z);
            }
        }
    }

    @Override // com.tencent.live2.V2TXLivePlayer
    public int snapshot() {
        synchronized (this) {
            if (isNativeValid()) {
                return nativeSnapshot(this.mNativeV2TXLivePlayerJni);
            }
            return -3;
        }
    }

    @Override // com.tencent.live2.V2TXLivePlayer
    public int startPlay(String str) {
        int nativeStartPlay;
        synchronized (this) {
            if (!isNativeValid()) {
                long nativeCreate = nativeCreate(new WeakReference(this));
                this.mNativeV2TXLivePlayerJni = nativeCreate;
                if (this.mShowDebugView != null) {
                    nativeShowDebugView(nativeCreate, this.mShowDebugView.booleanValue());
                }
                if (this.mEnableExtensionCallback != null) {
                    nativeEnableExtensionCallback(this.mNativeV2TXLivePlayerJni, this.mEnableExtensionCallback.booleanValue());
                }
                nativeSetRenderView(this.mNativeV2TXLivePlayerJni, this.mDisplayTarget);
                if (this.mRotation != null) {
                    nativeSetRenderRotation(this.mNativeV2TXLivePlayerJni, this.mRotation.mValue);
                }
                if (this.mScaleType != null) {
                    nativeSetRenderFillMode(this.mNativeV2TXLivePlayerJni, this.mScaleType.mValue);
                }
                if (this.mIsPauseAudio != null) {
                    if (this.mIsPauseAudio.booleanValue()) {
                        nativePauseAudio(this.mNativeV2TXLivePlayerJni);
                    } else {
                        nativeResumeAudio(this.mNativeV2TXLivePlayerJni);
                    }
                }
                if (this.mIsPauseVideo != null) {
                    if (this.mIsPauseVideo.booleanValue()) {
                        nativePauseVideo(this.mNativeV2TXLivePlayerJni);
                    } else {
                        nativeResumeVideo(this.mNativeV2TXLivePlayerJni);
                    }
                }
                if (this.mVolume != null) {
                    nativeSetPlayoutVolume(this.mNativeV2TXLivePlayerJni, this.mVolume.intValue());
                }
                if (this.mMin != null && this.mMax != null) {
                    nativeSetCacheParams(this.mNativeV2TXLivePlayerJni, this.mMin.floatValue(), this.mMax.floatValue());
                }
                if (this.mVolumeIntervalMs != null) {
                    nativeEnableVolumeEvaluation(this.mNativeV2TXLivePlayerJni, this.mVolumeIntervalMs.intValue());
                }
                if (this.mEnableCustomRendering != null && this.mPixelFormatType != null && this.mBufferType != null) {
                    nativeEnableCustomRendering(this.mNativeV2TXLivePlayerJni, this.mEnableCustomRendering.booleanValue(), this.mPixelFormatType.getValue(), this.mBufferType.ordinal());
                }
                if (this.mSEIPayloadSet.size() > 0) {
                    for (Integer num : this.mSEIPayloadSet) {
                        nativeEnableReceiveSeiMessage(this.mNativeV2TXLivePlayerJni, true, num.intValue());
                    }
                }
                if (!TextUtils.isEmpty(this.mLEBEnv)) {
                    nativeSetLEBEnv(this.mNativeV2TXLivePlayerJni, this.mLEBEnv);
                }
                if (this.mEnableHardwareDecode != null) {
                    nativeEnableHardwareDecode(this.mNativeV2TXLivePlayerJni, this.mEnableHardwareDecode.booleanValue());
                }
                if (this.mRetryLimits != null) {
                    nativeSetRetryLimits(this.mNativeV2TXLivePlayerJni, this.mRetryLimits.intValue());
                }
                if (this.mRetryInterval != null) {
                    nativeSetRetryInterval(this.mNativeV2TXLivePlayerJni, this.mRetryInterval.intValue());
                }
                if (this.mFramework != null && this.mComponent != null) {
                    nativeSetFramework(this.mNativeV2TXLivePlayerJni, this.mFramework.intValue(), this.mComponent.intValue());
                }
                if (this.mEnableRTMPAcc != null) {
                    nativeEnableRTMPAcc(this.mNativeV2TXLivePlayerJni, this.mEnableRTMPAcc.booleanValue());
                }
                if (this.mAudioRoute != null) {
                    nativeSetAudioRoute(this.mNativeV2TXLivePlayerJni, this.mAudioRoute.intValue());
                }
                for (Map.Entry<String, Object> entry : this.mPropertyMap.entrySet()) {
                    nativeSetProperty(this.mNativeV2TXLivePlayerJni, entry.getKey(), entry.getValue());
                }
            }
            nativeStartPlay = nativeStartPlay(this.mNativeV2TXLivePlayerJni, str);
        }
        return nativeStartPlay;
    }

    @Override // com.tencent.live2.V2TXLivePlayer
    public int stopPlay() {
        synchronized (this) {
            DisplayTarget displayTarget = this.mDisplayTarget;
            if (displayTarget != null) {
                displayTarget.hideAll();
            }
            if (isNativeValid()) {
                nativeStopPlay(this.mNativeV2TXLivePlayerJni);
                nativeDestroy(this.mNativeV2TXLivePlayerJni);
                this.mNativeV2TXLivePlayerJni = 0L;
            }
        }
        return 0;
    }

    @Override // com.tencent.live2.V2TXLivePlayer
    public int switchStream(String str) {
        synchronized (this) {
            if (TextUtils.isEmpty(str)) {
                LiteavLog.e(TAG, "Invalid params.");
                return -2;
            } else if (isNativeValid()) {
                return nativeSwitchStream(this.mNativeV2TXLivePlayerJni, str);
            } else {
                return 0;
            }
        }
    }
}
