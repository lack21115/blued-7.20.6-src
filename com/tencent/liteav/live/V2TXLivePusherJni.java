package com.tencent.liteav.live;

import android.content.Context;
import android.graphics.Bitmap;
import android.nfc.cardemulation.CardEmulation;
import android.os.BatteryManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceView;
import android.view.TextureView;
import com.tencent.liteav.audio.TXAudioEffectManager;
import com.tencent.liteav.audio.TXAudioEffectManagerImpl;
import com.tencent.liteav.base.ContextUtils;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.beauty.TXBeautyManager;
import com.tencent.liteav.beauty.TXBeautyManagerImpl;
import com.tencent.liteav.device.TXDeviceManager;
import com.tencent.liteav.device.TXDeviceManagerImpl;
import com.tencent.liteav.videobase.base.GLConstants;
import com.tencent.liteav.videobase.frame.PixelFrame;
import com.tencent.liteav.videobase.utils.Rotation;
import com.tencent.liteav.videobase.videobase.DisplayTarget;
import com.tencent.live2.V2TXLiveDef;
import com.tencent.live2.V2TXLivePusher;
import com.tencent.live2.V2TXLivePusherObserver;
import com.tencent.live2.impl.V2TXLiveDefInner;
import com.tencent.live2.impl.V2TXLiveProperty;
import com.tencent.live2.impl.a.b;
import com.tencent.rtmp.ui.TXCloudVideoView;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLContext;
import org.json.JSONObject;

@JNINamespace("liteav")
/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/live/V2TXLivePusherJni.class */
public class V2TXLivePusherJni extends V2TXLivePusher {
    private static final String TAG = "V2TXLivePusherJni";
    private TXAudioEffectManager mAudioEffectManager;
    private TXBeautyManager mBeautyManager;
    private TXDeviceManager mDeviceManager;
    private long mNativeV2TXLivePusherJni;
    private V2TXLivePusherObserver mObserver;
    private Surface mSurface;
    private V2TXLiveDefInner.SurfaceSize mSurfaceSize;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.tencent.liteav.live.V2TXLivePusherJni$1  reason: invalid class name */
    /* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/live/V2TXLivePusherJni$1.class */
    public static final /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f22710a;
        static final /* synthetic */ int[] b;

        /* renamed from: c  reason: collision with root package name */
        static final /* synthetic */ int[] f22711c;
        static final /* synthetic */ int[] d;
        static final /* synthetic */ int[] e;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x00bd -> B:83:0x0014). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:35:0x00c1 -> B:79:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x00c5 -> B:8:0x002a). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:39:0x00c9 -> B:61:0x003e). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:41:0x00cd -> B:13:0x0049). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:43:0x00d1 -> B:67:0x005d). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:45:0x00d5 -> B:75:0x0068). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:47:0x00d9 -> B:20:0x0073). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:49:0x00dd -> B:81:0x0087). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:51:0x00e1 -> B:25:0x0092). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:53:0x00e5 -> B:63:0x00a6). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:55:0x00e9 -> B:59:0x00b1). Please submit an issue!!! */
        static {
            int[] iArr = new int[GLConstants.PixelBufferType.values().length];
            e = iArr;
            try {
                iArr[GLConstants.PixelBufferType.TEXTURE_2D.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                e[GLConstants.PixelBufferType.BYTE_ARRAY.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
            try {
                e[GLConstants.PixelBufferType.BYTE_BUFFER.ordinal()] = 3;
            } catch (NoSuchFieldError e4) {
            }
            int[] iArr2 = new int[GLConstants.PixelFormatType.values().length];
            d = iArr2;
            try {
                iArr2[GLConstants.PixelFormatType.I420.ordinal()] = 1;
            } catch (NoSuchFieldError e5) {
            }
            try {
                d[GLConstants.PixelFormatType.RGBA.ordinal()] = 2;
            } catch (NoSuchFieldError e6) {
            }
            int[] iArr3 = new int[V2TXLiveDef.V2TXLiveBufferType.values().length];
            f22711c = iArr3;
            try {
                iArr3[V2TXLiveDef.V2TXLiveBufferType.V2TXLiveBufferTypeTexture.ordinal()] = 1;
            } catch (NoSuchFieldError e7) {
            }
            try {
                f22711c[V2TXLiveDef.V2TXLiveBufferType.V2TXLiveBufferTypeByteArray.ordinal()] = 2;
            } catch (NoSuchFieldError e8) {
            }
            try {
                f22711c[V2TXLiveDef.V2TXLiveBufferType.V2TXLiveBufferTypeByteBuffer.ordinal()] = 3;
            } catch (NoSuchFieldError e9) {
            }
            int[] iArr4 = new int[V2TXLiveDef.V2TXLivePixelFormat.values().length];
            b = iArr4;
            try {
                iArr4[V2TXLiveDef.V2TXLivePixelFormat.V2TXLivePixelFormatI420.ordinal()] = 1;
            } catch (NoSuchFieldError e10) {
            }
            try {
                b[V2TXLiveDef.V2TXLivePixelFormat.V2TXLivePixelFormatTexture2D.ordinal()] = 2;
            } catch (NoSuchFieldError e11) {
            }
            int[] iArr5 = new int[V2TXLiveDef.V2TXLiveRotation.values().length];
            f22710a = iArr5;
            try {
                iArr5[V2TXLiveDef.V2TXLiveRotation.V2TXLiveRotation90.ordinal()] = 1;
            } catch (NoSuchFieldError e12) {
            }
            try {
                f22710a[V2TXLiveDef.V2TXLiveRotation.V2TXLiveRotation180.ordinal()] = 2;
            } catch (NoSuchFieldError e13) {
            }
            try {
                f22710a[V2TXLiveDef.V2TXLiveRotation.V2TXLiveRotation270.ordinal()] = 3;
            } catch (NoSuchFieldError e14) {
            }
        }
    }

    public V2TXLivePusherJni(Context context, int i) {
        ContextUtils.initApplicationContext(context.getApplicationContext());
        ContextUtils.setDataDirectorySuffix("liteav");
        long nativeCreate = nativeCreate(new WeakReference(this), i);
        this.mNativeV2TXLivePusherJni = nativeCreate;
        this.mAudioEffectManager = new TXAudioEffectManagerImpl(nativeCreateAudioEffectManager(nativeCreate));
        this.mBeautyManager = new TXBeautyManagerImpl(nativeCreateBeautyManager(this.mNativeV2TXLivePusherJni));
        this.mDeviceManager = new TXDeviceManagerImpl(nativeCreateDeviceManager(this.mNativeV2TXLivePusherJni));
    }

    private int enable3A(String str, Object obj) {
        if (!(obj instanceof String)) {
            LiteavLog.e(TAG, "setProperty error, key:" + str + ", value:" + obj);
            return -2;
        }
        try {
            JSONObject jSONObject = new JSONObject((String) obj);
            boolean z = jSONObject.getBoolean("enable");
            int i = jSONObject.getInt(BatteryManager.EXTRA_LEVEL);
            if (i < 0 || i > 100) {
                Log.e(TAG, "setProperty error, key:" + str + ", value:" + obj);
                return -2;
            } else if (str.equals(V2TXLiveDefInner.TXLivePropertyKey.kV2EnableAGC)) {
                nativeEnableAGC(this.mNativeV2TXLivePusherJni, z, i);
                return 0;
            } else if (str.equals(V2TXLiveDefInner.TXLivePropertyKey.kV2EnableANS)) {
                nativeEnableANS(this.mNativeV2TXLivePusherJni, z, i);
                return 0;
            } else {
                return 0;
            }
        } catch (Exception e) {
            Log.e(TAG, "setProperty error, key:" + str + ", value:" + obj);
            return -2;
        }
    }

    private static native long nativeCreate(WeakReference<V2TXLivePusherJni> weakReference, int i);

    private static native long nativeCreateAudioEffectManager(long j);

    private static native long nativeCreateBeautyManager(long j);

    private static native long nativeCreateDeviceManager(long j);

    private static native void nativeDestroy(long j);

    private static native void nativeEnableAGC(long j, boolean z, int i);

    private static native void nativeEnableANS(long j, boolean z, int i);

    private static native int nativeEnableCustomAudioCapture(long j, boolean z);

    private static native int nativeEnableCustomVideoCapture(long j, boolean z);

    private static native int nativeEnableCustomVideoProcess(long j, boolean z, int i, int i2);

    private static native void nativeEnableExtensionCallback(long j, boolean z);

    private static native void nativeEnableRealtimeMode(long j, boolean z);

    private static native int nativeEnableVolumeEvaluation(long j, int i);

    private static native int nativeIsPushing(long j);

    private static native int nativePauseAudio(long j);

    private static native int nativePauseVideo(long j);

    private static native int nativeResumeAudio(long j);

    private static native int nativeResumeVideo(long j);

    private static native int nativeSendCustomAudioFrame(long j, byte[] bArr, int i, int i2);

    private static native int nativeSendCustomVideoFrame(long j, PixelFrame pixelFrame);

    private static native int nativeSendSeiMessage(long j, int i, byte[] bArr);

    private static native int nativeSetAudioQuality(long j, int i);

    private static native void nativeSetDisplayOrientation(long j, int i);

    private static native int nativeSetEncoderMirror(long j, boolean z);

    private static native void nativeSetFramework(long j, int i, int i2);

    private static native void nativeSetMetaData(long j, HashMap<String, String> hashMap);

    private static native int nativeSetMixTranscodingConfig(long j, String str);

    private static native int nativeSetRenderMirror(long j, int i);

    private static native int nativeSetRenderRotation(long j, int i);

    private static native int nativeSetRenderView(long j, DisplayTarget displayTarget);

    private static native int nativeSetVideoQuality(long j, int i, int i2, int i3, int i4, int i5);

    private static native int nativeSetVideoQualityEx(long j, int i, int i2, int i3, int i4, int i5, int i6);

    private static native int nativeSetWatermark(long j, Bitmap bitmap, float f, float f2, float f3);

    private static native void nativeShowDebugView(long j, boolean z);

    private static native int nativeSnapshot(long j);

    private static native int nativeStartCamera(long j, boolean z);

    private static native int nativeStartMicrophone(long j);

    private static native int nativeStartPush(long j, String str);

    private static native int nativeStartScreenCapture(long j);

    private static native int nativeStartVirtualCamera(long j, Bitmap bitmap);

    private static native int nativeStopCamera(long j);

    private static native int nativeStopMicrophone(long j);

    private static native int nativeStopPush(long j);

    private static native int nativeStopScreenCapture(long j);

    private static native int nativeStopVirtualCamera(long j);

    private static boolean pixelFrameToV2VideoFrame(PixelFrame pixelFrame, V2TXLiveDef.V2TXLiveVideoFrame v2TXLiveVideoFrame) {
        int i = AnonymousClass1.d[pixelFrame.getPixelFormatType().ordinal()];
        if (i == 1) {
            v2TXLiveVideoFrame.pixelFormat = V2TXLiveDef.V2TXLivePixelFormat.V2TXLivePixelFormatI420;
        } else if (i != 2) {
            return false;
        } else {
            v2TXLiveVideoFrame.pixelFormat = V2TXLiveDef.V2TXLivePixelFormat.V2TXLivePixelFormatTexture2D;
        }
        int i2 = AnonymousClass1.e[pixelFrame.getPixelBufferType().ordinal()];
        if (i2 == 1) {
            v2TXLiveVideoFrame.bufferType = V2TXLiveDef.V2TXLiveBufferType.V2TXLiveBufferTypeTexture;
            v2TXLiveVideoFrame.texture = new V2TXLiveDef.V2TXLiveTexture();
            v2TXLiveVideoFrame.texture.textureId = pixelFrame.getTextureId();
            if (pixelFrame.getGLContext() instanceof EGLContext) {
                v2TXLiveVideoFrame.texture.eglContext10 = (EGLContext) pixelFrame.getGLContext();
            } else if (Build.VERSION.SDK_INT >= 17 && (pixelFrame.getGLContext() instanceof android.opengl.EGLContext)) {
                v2TXLiveVideoFrame.texture.eglContext14 = (android.opengl.EGLContext) pixelFrame.getGLContext();
            }
        } else if (i2 == 2) {
            v2TXLiveVideoFrame.bufferType = V2TXLiveDef.V2TXLiveBufferType.V2TXLiveBufferTypeByteArray;
            v2TXLiveVideoFrame.data = pixelFrame.getData();
        } else if (i2 != 3) {
            return false;
        } else {
            v2TXLiveVideoFrame.bufferType = V2TXLiveDef.V2TXLiveBufferType.V2TXLiveBufferTypeByteBuffer;
            v2TXLiveVideoFrame.buffer = pixelFrame.getBuffer();
        }
        v2TXLiveVideoFrame.width = pixelFrame.getWidth();
        v2TXLiveVideoFrame.height = pixelFrame.getHeight();
        v2TXLiveVideoFrame.rotation = pixelFrame.getRotation().mValue;
        return true;
    }

    private static boolean v2VideoFrameToPixelFrame(V2TXLiveDef.V2TXLiveVideoFrame v2TXLiveVideoFrame, PixelFrame pixelFrame) {
        int i = AnonymousClass1.b[v2TXLiveVideoFrame.pixelFormat.ordinal()];
        if (i == 1) {
            pixelFrame.setPixelFormatType(GLConstants.PixelFormatType.I420);
        } else if (i != 2) {
            return false;
        } else {
            pixelFrame.setPixelFormatType(GLConstants.PixelFormatType.RGBA);
        }
        int i2 = AnonymousClass1.f22711c[v2TXLiveVideoFrame.bufferType.ordinal()];
        if (i2 == 1) {
            pixelFrame.setPixelBufferType(GLConstants.PixelBufferType.TEXTURE_2D);
            if (v2TXLiveVideoFrame.texture == null) {
                return false;
            }
            pixelFrame.setTextureId(v2TXLiveVideoFrame.texture.textureId);
            if (v2TXLiveVideoFrame.texture.eglContext10 != null) {
                pixelFrame.setGLContext(v2TXLiveVideoFrame.texture.eglContext10);
            }
            if (v2TXLiveVideoFrame.texture.eglContext14 != null) {
                pixelFrame.setGLContext(v2TXLiveVideoFrame.texture.eglContext14);
            }
            if (pixelFrame.getGLContext() == null) {
                EGL10 egl10 = (EGL10) EGLContext.getEGL();
                if (egl10 == null) {
                    return false;
                }
                pixelFrame.setGLContext(egl10.eglGetCurrentContext());
            }
        } else if (i2 == 2) {
            pixelFrame.setPixelBufferType(GLConstants.PixelBufferType.BYTE_ARRAY);
            pixelFrame.setData(v2TXLiveVideoFrame.data);
        } else if (i2 != 3) {
            return false;
        } else {
            pixelFrame.setPixelBufferType(GLConstants.PixelBufferType.BYTE_BUFFER);
            pixelFrame.setBuffer(v2TXLiveVideoFrame.buffer);
        }
        pixelFrame.setWidth(v2TXLiveVideoFrame.width);
        pixelFrame.setHeight(v2TXLiveVideoFrame.height);
        pixelFrame.setRotation(Rotation.a(v2TXLiveVideoFrame.rotation));
        return true;
    }

    public static V2TXLivePusherJni weakToStrongReference(WeakReference<V2TXLivePusherJni> weakReference) {
        return weakReference.get();
    }

    @Override // com.tencent.live2.V2TXLivePusher
    public int enableCustomAudioCapture(boolean z) {
        return nativeEnableCustomAudioCapture(this.mNativeV2TXLivePusherJni, z);
    }

    @Override // com.tencent.live2.V2TXLivePusher
    public int enableCustomVideoCapture(boolean z) {
        return nativeEnableCustomVideoCapture(this.mNativeV2TXLivePusherJni, z);
    }

    @Override // com.tencent.live2.V2TXLivePusher
    public int enableCustomVideoProcess(boolean z, V2TXLiveDef.V2TXLivePixelFormat v2TXLivePixelFormat, V2TXLiveDef.V2TXLiveBufferType v2TXLiveBufferType) {
        return nativeEnableCustomVideoProcess(this.mNativeV2TXLivePusherJni, z, v2TXLivePixelFormat.ordinal(), v2TXLiveBufferType.ordinal());
    }

    @Override // com.tencent.live2.V2TXLivePusher
    public int enableVolumeEvaluation(int i) {
        return nativeEnableVolumeEvaluation(this.mNativeV2TXLivePusherJni, i);
    }

    protected void finalize() throws Throwable {
        super.finalize();
        release();
    }

    @Override // com.tencent.live2.V2TXLivePusher
    public TXAudioEffectManager getAudioEffectManager() {
        return this.mAudioEffectManager;
    }

    @Override // com.tencent.live2.V2TXLivePusher
    public TXBeautyManager getBeautyManager() {
        return this.mBeautyManager;
    }

    @Override // com.tencent.live2.V2TXLivePusher
    public TXDeviceManager getDeviceManager() {
        return this.mDeviceManager;
    }

    @Override // com.tencent.live2.V2TXLivePusher
    public int isPushing() {
        return nativeIsPushing(this.mNativeV2TXLivePusherJni);
    }

    public void onCaptureFirstAudioFrame() {
        V2TXLivePusherObserver v2TXLivePusherObserver = this.mObserver;
        if (v2TXLivePusherObserver != null) {
            v2TXLivePusherObserver.onCaptureFirstAudioFrame();
        }
    }

    public void onCaptureFirstVideoFrame() {
        V2TXLivePusherObserver v2TXLivePusherObserver = this.mObserver;
        if (v2TXLivePusherObserver != null) {
            v2TXLivePusherObserver.onCaptureFirstVideoFrame();
        }
    }

    public int onCustomPreprocessFrame(PixelFrame pixelFrame, PixelFrame pixelFrame2) {
        V2TXLivePusherObserver v2TXLivePusherObserver;
        V2TXLiveDef.V2TXLiveVideoFrame v2TXLiveVideoFrame = new V2TXLiveDef.V2TXLiveVideoFrame();
        if (pixelFrameToV2VideoFrame(pixelFrame, v2TXLiveVideoFrame)) {
            V2TXLiveDef.V2TXLiveVideoFrame v2TXLiveVideoFrame2 = new V2TXLiveDef.V2TXLiveVideoFrame();
            if (pixelFrameToV2VideoFrame(pixelFrame2, v2TXLiveVideoFrame2) && (v2TXLivePusherObserver = this.mObserver) != null) {
                int onProcessVideoFrame = v2TXLivePusherObserver.onProcessVideoFrame(v2TXLiveVideoFrame, v2TXLiveVideoFrame2);
                if (v2VideoFrameToPixelFrame(v2TXLiveVideoFrame2, pixelFrame2)) {
                    return onProcessVideoFrame;
                }
                return -1;
            }
            return -1;
        }
        return -1;
    }

    public void onEnterRoom(int i, String str) {
    }

    public void onError(int i, String str, Bundle bundle) {
        V2TXLivePusherObserver v2TXLivePusherObserver = this.mObserver;
        if (v2TXLivePusherObserver != null) {
            v2TXLivePusherObserver.onError(i, str, bundle);
        }
    }

    public void onExitRoom(int i, String str) {
    }

    public void onGLContextCreated() {
        V2TXLivePusherObserver v2TXLivePusherObserver = this.mObserver;
        if (v2TXLivePusherObserver != null) {
            v2TXLivePusherObserver.onGLContextCreated();
        }
    }

    public void onGLContextDestroyed() {
        V2TXLivePusherObserver v2TXLivePusherObserver = this.mObserver;
        if (v2TXLivePusherObserver != null) {
            v2TXLivePusherObserver.onGLContextDestroyed();
        }
    }

    public void onMicrophoneVolumeUpdate(int i) {
        V2TXLivePusherObserver v2TXLivePusherObserver = this.mObserver;
        if (v2TXLivePusherObserver != null) {
            v2TXLivePusherObserver.onMicrophoneVolumeUpdate(i);
        }
    }

    public void onNetworkQuality(int i) {
    }

    public void onPushEvent(int i, Bundle bundle) {
    }

    public void onPushNetStatus(Bundle bundle) {
    }

    public void onPushStatusUpdate(int i, String str, Bundle bundle) {
        V2TXLivePusherObserver v2TXLivePusherObserver = this.mObserver;
        V2TXLiveDef.V2TXLivePushStatus v2TXLivePushStatus = V2TXLiveDef.V2TXLivePushStatus.V2TXLivePushStatusDisconnected;
        if (i == 0) {
            v2TXLivePushStatus = V2TXLiveDef.V2TXLivePushStatus.V2TXLivePushStatusConnecting;
            str = "connecting to the server.";
        } else if (i == 1) {
            v2TXLivePushStatus = V2TXLiveDef.V2TXLivePushStatus.V2TXLivePushStatusConnectSuccess;
            str = "connected to the server successfully.";
        } else if (i == 2) {
            v2TXLivePushStatus = V2TXLiveDef.V2TXLivePushStatus.V2TXLivePushStatusReconnecting;
            str = "reconnecting to the server.";
        } else if (i == 3) {
            v2TXLivePushStatus = V2TXLiveDef.V2TXLivePushStatus.V2TXLivePushStatusDisconnected;
            str = "disconnected from the server.";
        }
        if (v2TXLivePusherObserver != null) {
            v2TXLivePusherObserver.onPushStatusUpdate(v2TXLivePushStatus, str, bundle);
        }
    }

    public void onSetMixTranscodingConfig(int i, String str) {
        V2TXLivePusherObserver v2TXLivePusherObserver = this.mObserver;
        if (v2TXLivePusherObserver != null) {
            v2TXLivePusherObserver.onSetMixTranscodingConfig(i, str);
        }
    }

    public void onSnapshotComplete(Bitmap bitmap) {
        V2TXLivePusherObserver v2TXLivePusherObserver = this.mObserver;
        if (v2TXLivePusherObserver != null) {
            v2TXLivePusherObserver.onSnapshotComplete(bitmap);
        }
    }

    public void onStatisticsUpdate(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        V2TXLivePusherObserver v2TXLivePusherObserver = this.mObserver;
        if (v2TXLivePusherObserver != null) {
            V2TXLiveDef.V2TXLivePusherStatistics v2TXLivePusherStatistics = new V2TXLiveDef.V2TXLivePusherStatistics();
            v2TXLivePusherStatistics.appCpu = i;
            v2TXLivePusherStatistics.systemCpu = i2;
            v2TXLivePusherStatistics.width = i3;
            v2TXLivePusherStatistics.height = i4;
            v2TXLivePusherStatistics.fps = i5;
            v2TXLivePusherStatistics.videoBitrate = i6;
            v2TXLivePusherStatistics.audioBitrate = i7;
            v2TXLivePusherObserver.onStatisticsUpdate(v2TXLivePusherStatistics);
        }
    }

    public void onUserAudioAvailable(String str, boolean z) {
    }

    public void onUserOffline(String str) {
    }

    public void onUserOnline(String str) {
    }

    public void onUserVideoAvailable(String str, int i, boolean z) {
    }

    public void onWarning(int i, String str, Bundle bundle) {
        V2TXLivePusherObserver v2TXLivePusherObserver = this.mObserver;
        if (v2TXLivePusherObserver != null) {
            v2TXLivePusherObserver.onWarning(i, str, bundle);
        }
    }

    @Override // com.tencent.live2.V2TXLivePusher
    public int pauseAudio() {
        return nativePauseAudio(this.mNativeV2TXLivePusherJni);
    }

    @Override // com.tencent.live2.V2TXLivePusher
    public int pauseVideo() {
        return nativePauseVideo(this.mNativeV2TXLivePusherJni);
    }

    @Override // com.tencent.live2.V2TXLivePusher
    public void release() {
        long j = this.mNativeV2TXLivePusherJni;
        if (j != 0) {
            nativeDestroy(j);
            this.mNativeV2TXLivePusherJni = 0L;
        }
    }

    @Override // com.tencent.live2.V2TXLivePusher
    public int resumeAudio() {
        return nativeResumeAudio(this.mNativeV2TXLivePusherJni);
    }

    @Override // com.tencent.live2.V2TXLivePusher
    public int resumeVideo() {
        return nativeResumeVideo(this.mNativeV2TXLivePusherJni);
    }

    @Override // com.tencent.live2.V2TXLivePusher
    public int sendCustomAudioFrame(V2TXLiveDef.V2TXLiveAudioFrame v2TXLiveAudioFrame) {
        return nativeSendCustomAudioFrame(this.mNativeV2TXLivePusherJni, v2TXLiveAudioFrame.data, v2TXLiveAudioFrame.sampleRate, v2TXLiveAudioFrame.channel);
    }

    @Override // com.tencent.live2.V2TXLivePusher
    public int sendCustomVideoFrame(V2TXLiveDef.V2TXLiveVideoFrame v2TXLiveVideoFrame) {
        PixelFrame pixelFrame = new PixelFrame();
        if (v2VideoFrameToPixelFrame(v2TXLiveVideoFrame, pixelFrame)) {
            return nativeSendCustomVideoFrame(this.mNativeV2TXLivePusherJni, pixelFrame);
        }
        return -1;
    }

    @Override // com.tencent.live2.V2TXLivePusher
    public int sendSeiMessage(int i, byte[] bArr) {
        return nativeSendSeiMessage(this.mNativeV2TXLivePusherJni, i, bArr);
    }

    @Override // com.tencent.live2.V2TXLivePusher
    public int setAudioQuality(V2TXLiveDef.V2TXLiveAudioQuality v2TXLiveAudioQuality) {
        return nativeSetAudioQuality(this.mNativeV2TXLivePusherJni, v2TXLiveAudioQuality.ordinal());
    }

    public void setDisplayOrientation(int i) {
        nativeSetDisplayOrientation(this.mNativeV2TXLivePusherJni, i);
    }

    @Override // com.tencent.live2.V2TXLivePusher
    public int setEncoderMirror(boolean z) {
        return nativeSetEncoderMirror(this.mNativeV2TXLivePusherJni, z);
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x01cb  */
    @Override // com.tencent.live2.V2TXLivePusher
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int setMixTranscodingConfig(com.tencent.live2.V2TXLiveDef.V2TXLiveTranscodingConfig r5) {
        /*
            Method dump skipped, instructions count: 473
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.live.V2TXLivePusherJni.setMixTranscodingConfig(com.tencent.live2.V2TXLiveDef$V2TXLiveTranscodingConfig):int");
    }

    @Override // com.tencent.live2.V2TXLivePusher
    public void setObserver(V2TXLivePusherObserver v2TXLivePusherObserver) {
        this.mObserver = v2TXLivePusherObserver;
        if (v2TXLivePusherObserver == null || !(v2TXLivePusherObserver instanceof b)) {
            return;
        }
        nativeEnableExtensionCallback(this.mNativeV2TXLivePusherJni, true);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.live2.V2TXLivePusher
    public int setProperty(String str, Object obj) {
        boolean z;
        switch (str.hashCode()) {
            case -631683974:
                if (str.equals(V2TXLiveDefInner.TXLivePropertyKey.kV2EnableAGC)) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case -631683741:
                if (str.equals(V2TXLiveDefInner.TXLivePropertyKey.kV2EnableANS)) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 480042124:
                if (str.equals(V2TXLiveDefInner.TXLivePropertyKey.kV2SetSurfaceSize)) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 1120433643:
                if (str.equals(V2TXLiveDefInner.TXLivePropertyKey.kV2SetSurface)) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 1309735633:
                if (str.equals(V2TXLiveDefInner.TXLivePropertyKey.kV2EnableRealtimeMode)) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 1538362833:
                if (str.equals(V2TXLiveDefInner.TXLivePropertyKey.kV2SetMetaData)) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 2085561276:
                if (str.equals(V2TXLiveDefInner.TXLivePropertyKey.kV2SetFramework)) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 2132058329:
                if (str.equals(V2TXLiveProperty.kV2SetVideoQualityEx)) {
                    z = false;
                    break;
                }
                z = true;
                break;
            default:
                z = true;
                break;
        }
        switch (z) {
            case false:
                if (!(obj instanceof String)) {
                    LiteavLog.e(TAG, "setProperty error, key:" + str + ", value:" + obj);
                    return -2;
                }
                try {
                    JSONObject jSONObject = new JSONObject((String) obj);
                    nativeSetVideoQualityEx(this.mNativeV2TXLivePusherJni, jSONObject.optInt("videoWidth"), jSONObject.optInt("videoHeight"), jSONObject.optInt("videoFps"), jSONObject.optInt("videoBitrate"), jSONObject.optInt("minVideoBitrate"), jSONObject.optInt("videoGop"));
                    return 0;
                } catch (Exception e) {
                    Log.e(TAG, "setProperty error, key:" + str + ", value:" + obj);
                    return -2;
                }
            case true:
            case true:
                return enable3A(str, obj);
            case true:
                if (obj instanceof HashMap) {
                    nativeSetMetaData(this.mNativeV2TXLivePusherJni, (HashMap) obj);
                    return 0;
                }
                LiteavLog.e(TAG, "setProperty error, key:" + str + ", value:" + obj);
                return -2;
            case true:
                if (!(obj instanceof String)) {
                    LiteavLog.e(TAG, "setProperty error, key:" + str + ", value:" + obj);
                    return -2;
                }
                try {
                    JSONObject jSONObject2 = new JSONObject((String) obj);
                    nativeSetFramework(this.mNativeV2TXLivePusherJni, jSONObject2.optInt("framework", 0), jSONObject2.optInt(CardEmulation.EXTRA_SERVICE_COMPONENT, 0));
                    return 0;
                } catch (Exception e2) {
                    LiteavLog.e(TAG, "setProperty error, key:" + str + ", value:" + obj, e2);
                    return -2;
                }
            case true:
                if (obj == null) {
                    this.mSurface = null;
                    nativeSetRenderView(this.mNativeV2TXLivePusherJni, null);
                    return 0;
                } else if (!(obj instanceof Surface)) {
                    LiteavLog.e(TAG, "setProperty error, key:" + str + ", value:" + obj);
                    return -2;
                } else {
                    Surface surface = (Surface) obj;
                    this.mSurface = surface;
                    V2TXLiveDefInner.SurfaceSize surfaceSize = this.mSurfaceSize;
                    if (surfaceSize != null) {
                        nativeSetRenderView(this.mNativeV2TXLivePusherJni, new DisplayTarget(surface, surfaceSize.width, this.mSurfaceSize.height));
                        return 0;
                    }
                    return 0;
                }
            case true:
                if (obj == null) {
                    this.mSurfaceSize = null;
                    return 0;
                } else if (!(obj instanceof V2TXLiveDefInner.SurfaceSize)) {
                    LiteavLog.e(TAG, "setProperty error, key:" + str + ", value:" + obj);
                    return -2;
                } else {
                    V2TXLiveDefInner.SurfaceSize surfaceSize2 = (V2TXLiveDefInner.SurfaceSize) obj;
                    this.mSurfaceSize = surfaceSize2;
                    Surface surface2 = this.mSurface;
                    if (surface2 != null) {
                        nativeSetRenderView(this.mNativeV2TXLivePusherJni, new DisplayTarget(surface2, surfaceSize2.width, this.mSurfaceSize.height));
                        return 0;
                    }
                    return 0;
                }
            case true:
                if (obj instanceof Boolean) {
                    nativeEnableRealtimeMode(this.mNativeV2TXLivePusherJni, ((Boolean) obj).booleanValue());
                    return 0;
                }
                return -2;
            default:
                LiteavLog.e(TAG, "setProperty error, key:" + str + ", value:" + obj);
                return -2;
        }
    }

    @Override // com.tencent.live2.V2TXLivePusher
    public int setRenderMirror(V2TXLiveDef.V2TXLiveMirrorType v2TXLiveMirrorType) {
        return nativeSetRenderMirror(this.mNativeV2TXLivePusherJni, v2TXLiveMirrorType.ordinal());
    }

    @Override // com.tencent.live2.V2TXLivePusher
    public int setRenderRotation(V2TXLiveDef.V2TXLiveRotation v2TXLiveRotation) {
        int i = AnonymousClass1.f22710a[v2TXLiveRotation.ordinal()];
        return nativeSetRenderRotation(this.mNativeV2TXLivePusherJni, (i != 1 ? i != 2 ? i != 3 ? Rotation.NORMAL : Rotation.ROTATION_270 : Rotation.ROTATION_180 : Rotation.ROTATION_90).mValue);
    }

    @Override // com.tencent.live2.V2TXLivePusher
    public int setRenderView(SurfaceView surfaceView) {
        return nativeSetRenderView(this.mNativeV2TXLivePusherJni, new DisplayTarget(surfaceView));
    }

    @Override // com.tencent.live2.V2TXLivePusher
    public int setRenderView(TextureView textureView) {
        return nativeSetRenderView(this.mNativeV2TXLivePusherJni, new DisplayTarget(textureView));
    }

    @Override // com.tencent.live2.V2TXLivePusher
    public int setRenderView(TXCloudVideoView tXCloudVideoView) {
        return nativeSetRenderView(this.mNativeV2TXLivePusherJni, new DisplayTarget(tXCloudVideoView));
    }

    @Override // com.tencent.live2.V2TXLivePusher
    public int setVideoQuality(V2TXLiveDef.V2TXLiveVideoEncoderParam v2TXLiveVideoEncoderParam) {
        return nativeSetVideoQuality(this.mNativeV2TXLivePusherJni, v2TXLiveVideoEncoderParam.videoResolution.ordinal(), v2TXLiveVideoEncoderParam.videoResolutionMode.ordinal(), v2TXLiveVideoEncoderParam.videoFps, v2TXLiveVideoEncoderParam.videoBitrate, v2TXLiveVideoEncoderParam.minVideoBitrate);
    }

    @Override // com.tencent.live2.V2TXLivePusher
    public int setWatermark(Bitmap bitmap, float f, float f2, float f3) {
        return nativeSetWatermark(this.mNativeV2TXLivePusherJni, bitmap, f, f2, f3);
    }

    @Override // com.tencent.live2.V2TXLivePusher
    public void showDebugView(boolean z) {
        nativeShowDebugView(this.mNativeV2TXLivePusherJni, z);
    }

    @Override // com.tencent.live2.V2TXLivePusher
    public int snapshot() {
        return nativeSnapshot(this.mNativeV2TXLivePusherJni);
    }

    @Override // com.tencent.live2.V2TXLivePusher
    public int startCamera(boolean z) {
        return nativeStartCamera(this.mNativeV2TXLivePusherJni, z);
    }

    @Override // com.tencent.live2.V2TXLivePusher
    public int startMicrophone() {
        return nativeStartMicrophone(this.mNativeV2TXLivePusherJni);
    }

    @Override // com.tencent.live2.V2TXLivePusher
    public int startPush(String str) {
        return nativeStartPush(this.mNativeV2TXLivePusherJni, str);
    }

    @Override // com.tencent.live2.V2TXLivePusher
    public int startScreenCapture() {
        return nativeStartScreenCapture(this.mNativeV2TXLivePusherJni);
    }

    @Override // com.tencent.live2.V2TXLivePusher
    public int startVirtualCamera(Bitmap bitmap) {
        return nativeStartVirtualCamera(this.mNativeV2TXLivePusherJni, bitmap);
    }

    @Override // com.tencent.live2.V2TXLivePusher
    public int stopCamera() {
        return nativeStopCamera(this.mNativeV2TXLivePusherJni);
    }

    @Override // com.tencent.live2.V2TXLivePusher
    public int stopMicrophone() {
        return nativeStopMicrophone(this.mNativeV2TXLivePusherJni);
    }

    @Override // com.tencent.live2.V2TXLivePusher
    public int stopPush() {
        return nativeStopPush(this.mNativeV2TXLivePusherJni);
    }

    @Override // com.tencent.live2.V2TXLivePusher
    public int stopScreenCapture() {
        return nativeStopScreenCapture(this.mNativeV2TXLivePusherJni);
    }

    @Override // com.tencent.live2.V2TXLivePusher
    public int stopVirtualCamera() {
        return nativeStopVirtualCamera(this.mNativeV2TXLivePusherJni);
    }
}
