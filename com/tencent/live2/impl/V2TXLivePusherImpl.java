package com.tencent.live2.impl;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.Display;
import android.view.OrientationEventListener;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.WindowManager;
import com.tencent.liteav.audio.TXAudioEffectManager;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.o;
import com.tencent.liteav.beauty.TXBeautyManager;
import com.tencent.liteav.device.TXDeviceManager;
import com.tencent.liteav.live.V2TXLivePusherJni;
import com.tencent.live2.V2TXLiveDef;
import com.tencent.live2.V2TXLivePusher;
import com.tencent.live2.V2TXLivePusherObserver;
import com.tencent.rtmp.ui.TXCloudVideoView;
import java.lang.ref.WeakReference;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/live2/impl/V2TXLivePusherImpl.class */
public class V2TXLivePusherImpl extends V2TXLivePusher {
    private static final String TAG = "V2TXLivePusherImpl";
    private DisplayOrientationListener mDisplayOrientationListener;
    private V2TXLivePusherJni mImpl;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/live2/impl/V2TXLivePusherImpl$DisplayOrientationListener.class */
    static class DisplayOrientationListener extends OrientationEventListener {
        private Display mDisplay;
        private Orientation mOrientation;
        private WeakReference<V2TXLivePusherImpl> mWeakPusher;

        public DisplayOrientationListener(Context context, WeakReference<V2TXLivePusherImpl> weakReference) {
            super(context);
            this.mWeakPusher = weakReference;
            try {
                Display defaultDisplay = ((WindowManager) context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
                this.mDisplay = defaultDisplay;
                this.mOrientation = convert(defaultDisplay.getRotation());
            } catch (Exception e) {
                e.printStackTrace();
                LiteavLog.e(V2TXLivePusherImpl.TAG, e.getMessage());
            }
        }

        private Orientation convert(int i) {
            return i != 1 ? i != 2 ? i != 3 ? Orientation.kUp : Orientation.kLeft : Orientation.kDown : Orientation.kRight;
        }

        public Orientation getOrientation() {
            return this.mOrientation;
        }

        @Override // android.view.OrientationEventListener
        public void onOrientationChanged(int i) {
            Orientation convert;
            Display display = this.mDisplay;
            if (display == null || (convert = convert(display.getRotation())) == this.mOrientation) {
                return;
            }
            this.mOrientation = convert;
            WeakReference<V2TXLivePusherImpl> weakReference = this.mWeakPusher;
            V2TXLivePusherImpl v2TXLivePusherImpl = weakReference != null ? weakReference.get() : null;
            if (v2TXLivePusherImpl != null) {
                v2TXLivePusherImpl.setDisplayOrientation(convert);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/live2/impl/V2TXLivePusherImpl$Orientation.class */
    public enum Orientation {
        kUp(0),
        kRight(1),
        kDown(2),
        kLeft(3);
        
        private int index;

        Orientation(int i) {
            this.index = i;
        }

        final int getIndex() {
            return this.index;
        }
    }

    static {
        o.a();
    }

    private V2TXLivePusherImpl(Context context, int i) {
        this.mImpl = new V2TXLivePusherJni(context, i);
        LiteavLog.i(TAG, "Create instance:" + this.mImpl.toString());
        DisplayOrientationListener displayOrientationListener = new DisplayOrientationListener(context.getApplicationContext(), new WeakReference(this));
        this.mDisplayOrientationListener = displayOrientationListener;
        displayOrientationListener.enable();
        setDisplayOrientation(this.mDisplayOrientationListener.getOrientation());
    }

    public V2TXLivePusherImpl(Context context, V2TXLiveDef.V2TXLiveMode v2TXLiveMode) {
        this(context, v2TXLiveMode.ordinal());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDisplayOrientation(Orientation orientation) {
        synchronized (this) {
            if (this.mImpl == null) {
                return;
            }
            this.mImpl.setDisplayOrientation(orientation.getIndex());
        }
    }

    @Override // com.tencent.live2.V2TXLivePusher
    public int enableCustomAudioCapture(boolean z) {
        synchronized (this) {
            if (this.mImpl == null) {
                return -3;
            }
            return this.mImpl.enableCustomAudioCapture(z);
        }
    }

    @Override // com.tencent.live2.V2TXLivePusher
    public int enableCustomVideoCapture(boolean z) {
        synchronized (this) {
            if (this.mImpl == null) {
                return -3;
            }
            return this.mImpl.enableCustomVideoCapture(z);
        }
    }

    @Override // com.tencent.live2.V2TXLivePusher
    public int enableCustomVideoProcess(boolean z, V2TXLiveDef.V2TXLivePixelFormat v2TXLivePixelFormat, V2TXLiveDef.V2TXLiveBufferType v2TXLiveBufferType) {
        int enableCustomVideoProcess;
        synchronized (this) {
            enableCustomVideoProcess = this.mImpl.enableCustomVideoProcess(z, v2TXLivePixelFormat, v2TXLiveBufferType);
        }
        return enableCustomVideoProcess;
    }

    @Override // com.tencent.live2.V2TXLivePusher
    public int enableVolumeEvaluation(int i) {
        synchronized (this) {
            if (this.mImpl == null) {
                return -3;
            }
            return this.mImpl.enableVolumeEvaluation(i);
        }
    }

    @Override // com.tencent.live2.V2TXLivePusher
    public TXAudioEffectManager getAudioEffectManager() {
        synchronized (this) {
            if (this.mImpl == null) {
                return null;
            }
            return this.mImpl.getAudioEffectManager();
        }
    }

    @Override // com.tencent.live2.V2TXLivePusher
    public TXBeautyManager getBeautyManager() {
        synchronized (this) {
            if (this.mImpl == null) {
                return null;
            }
            return this.mImpl.getBeautyManager();
        }
    }

    @Override // com.tencent.live2.V2TXLivePusher
    public TXDeviceManager getDeviceManager() {
        synchronized (this) {
            if (this.mImpl == null) {
                return null;
            }
            return this.mImpl.getDeviceManager();
        }
    }

    @Override // com.tencent.live2.V2TXLivePusher
    public int isPushing() {
        synchronized (this) {
            if (this.mImpl == null) {
                return -3;
            }
            return this.mImpl.isPushing();
        }
    }

    @Override // com.tencent.live2.V2TXLivePusher
    public int pauseAudio() {
        synchronized (this) {
            if (this.mImpl == null) {
                return -3;
            }
            return this.mImpl.pauseAudio();
        }
    }

    @Override // com.tencent.live2.V2TXLivePusher
    public int pauseVideo() {
        synchronized (this) {
            if (this.mImpl == null) {
                return -3;
            }
            return this.mImpl.pauseVideo();
        }
    }

    @Override // com.tencent.live2.V2TXLivePusher
    public void release() {
        synchronized (this) {
            if (this.mImpl == null) {
                return;
            }
            this.mDisplayOrientationListener.disable();
            this.mImpl.release();
            LiteavLog.i(TAG, "Release instance:" + this.mImpl.toString());
            this.mImpl = null;
        }
    }

    @Override // com.tencent.live2.V2TXLivePusher
    public int resumeAudio() {
        synchronized (this) {
            if (this.mImpl == null) {
                return -3;
            }
            return this.mImpl.resumeAudio();
        }
    }

    @Override // com.tencent.live2.V2TXLivePusher
    public int resumeVideo() {
        synchronized (this) {
            if (this.mImpl == null) {
                return -3;
            }
            return this.mImpl.resumeVideo();
        }
    }

    @Override // com.tencent.live2.V2TXLivePusher
    public int sendCustomAudioFrame(V2TXLiveDef.V2TXLiveAudioFrame v2TXLiveAudioFrame) {
        synchronized (this) {
            if (this.mImpl == null) {
                return -3;
            }
            return this.mImpl.sendCustomAudioFrame(v2TXLiveAudioFrame);
        }
    }

    @Override // com.tencent.live2.V2TXLivePusher
    public int sendCustomVideoFrame(V2TXLiveDef.V2TXLiveVideoFrame v2TXLiveVideoFrame) {
        synchronized (this) {
            if (this.mImpl == null) {
                return -3;
            }
            return this.mImpl.sendCustomVideoFrame(v2TXLiveVideoFrame);
        }
    }

    @Override // com.tencent.live2.V2TXLivePusher
    public int sendSeiMessage(int i, byte[] bArr) {
        synchronized (this) {
            if (this.mImpl == null) {
                return -3;
            }
            return this.mImpl.sendSeiMessage(i, bArr);
        }
    }

    @Override // com.tencent.live2.V2TXLivePusher
    public int setAudioQuality(V2TXLiveDef.V2TXLiveAudioQuality v2TXLiveAudioQuality) {
        synchronized (this) {
            if (this.mImpl == null) {
                return -3;
            }
            return this.mImpl.setAudioQuality(v2TXLiveAudioQuality);
        }
    }

    @Override // com.tencent.live2.V2TXLivePusher
    public int setEncoderMirror(boolean z) {
        synchronized (this) {
            if (this.mImpl == null) {
                return -3;
            }
            return this.mImpl.setEncoderMirror(z);
        }
    }

    @Override // com.tencent.live2.V2TXLivePusher
    public int setMixTranscodingConfig(V2TXLiveDef.V2TXLiveTranscodingConfig v2TXLiveTranscodingConfig) {
        synchronized (this) {
            if (this.mImpl == null) {
                return -3;
            }
            return this.mImpl.setMixTranscodingConfig(v2TXLiveTranscodingConfig);
        }
    }

    @Override // com.tencent.live2.V2TXLivePusher
    public void setObserver(V2TXLivePusherObserver v2TXLivePusherObserver) {
        synchronized (this) {
            if (this.mImpl == null) {
                return;
            }
            this.mImpl.setObserver(v2TXLivePusherObserver);
        }
    }

    @Override // com.tencent.live2.V2TXLivePusher
    public int setProperty(String str, Object obj) {
        synchronized (this) {
            if (this.mImpl == null) {
                return -3;
            }
            return this.mImpl.setProperty(str, obj);
        }
    }

    @Override // com.tencent.live2.V2TXLivePusher
    public int setRenderMirror(V2TXLiveDef.V2TXLiveMirrorType v2TXLiveMirrorType) {
        synchronized (this) {
            if (this.mImpl == null) {
                return -3;
            }
            return this.mImpl.setRenderMirror(v2TXLiveMirrorType);
        }
    }

    @Override // com.tencent.live2.V2TXLivePusher
    public int setRenderRotation(V2TXLiveDef.V2TXLiveRotation v2TXLiveRotation) {
        synchronized (this) {
            if (this.mImpl == null) {
                return -3;
            }
            return this.mImpl.setRenderRotation(v2TXLiveRotation);
        }
    }

    @Override // com.tencent.live2.V2TXLivePusher
    public int setRenderView(SurfaceView surfaceView) {
        synchronized (this) {
            if (this.mImpl == null) {
                return -3;
            }
            return this.mImpl.setRenderView(surfaceView);
        }
    }

    @Override // com.tencent.live2.V2TXLivePusher
    public int setRenderView(TextureView textureView) {
        synchronized (this) {
            if (this.mImpl == null) {
                return -3;
            }
            return this.mImpl.setRenderView(textureView);
        }
    }

    @Override // com.tencent.live2.V2TXLivePusher
    public int setRenderView(TXCloudVideoView tXCloudVideoView) {
        synchronized (this) {
            if (this.mImpl == null) {
                return -3;
            }
            return this.mImpl.setRenderView(tXCloudVideoView);
        }
    }

    @Override // com.tencent.live2.V2TXLivePusher
    public int setVideoQuality(V2TXLiveDef.V2TXLiveVideoEncoderParam v2TXLiveVideoEncoderParam) {
        synchronized (this) {
            if (this.mImpl == null) {
                return -3;
            }
            return this.mImpl.setVideoQuality(v2TXLiveVideoEncoderParam);
        }
    }

    @Override // com.tencent.live2.V2TXLivePusher
    public int setWatermark(Bitmap bitmap, float f, float f2, float f3) {
        synchronized (this) {
            if (this.mImpl == null) {
                return -3;
            }
            return this.mImpl.setWatermark(bitmap, f, f2, f3);
        }
    }

    @Override // com.tencent.live2.V2TXLivePusher
    public void showDebugView(boolean z) {
        synchronized (this) {
            if (this.mImpl == null) {
                return;
            }
            this.mImpl.showDebugView(z);
        }
    }

    @Override // com.tencent.live2.V2TXLivePusher
    public int snapshot() {
        synchronized (this) {
            if (this.mImpl == null) {
                return -3;
            }
            return this.mImpl.snapshot();
        }
    }

    @Override // com.tencent.live2.V2TXLivePusher
    public int startCamera(boolean z) {
        synchronized (this) {
            if (this.mImpl == null) {
                return -3;
            }
            return this.mImpl.startCamera(z);
        }
    }

    @Override // com.tencent.live2.V2TXLivePusher
    public int startMicrophone() {
        synchronized (this) {
            if (this.mImpl == null) {
                return -3;
            }
            return this.mImpl.startMicrophone();
        }
    }

    @Override // com.tencent.live2.V2TXLivePusher
    public int startPush(String str) {
        synchronized (this) {
            if (this.mImpl == null) {
                return -3;
            }
            return this.mImpl.startPush(str);
        }
    }

    @Override // com.tencent.live2.V2TXLivePusher
    public int startScreenCapture() {
        synchronized (this) {
            if (this.mImpl == null) {
                return -3;
            }
            return this.mImpl.startScreenCapture();
        }
    }

    @Override // com.tencent.live2.V2TXLivePusher
    public int startVirtualCamera(Bitmap bitmap) {
        synchronized (this) {
            if (this.mImpl == null) {
                return -3;
            }
            return this.mImpl.startVirtualCamera(bitmap);
        }
    }

    @Override // com.tencent.live2.V2TXLivePusher
    public int stopCamera() {
        synchronized (this) {
            if (this.mImpl == null) {
                return -3;
            }
            return this.mImpl.stopCamera();
        }
    }

    @Override // com.tencent.live2.V2TXLivePusher
    public int stopMicrophone() {
        synchronized (this) {
            if (this.mImpl == null) {
                return -3;
            }
            return this.mImpl.stopMicrophone();
        }
    }

    @Override // com.tencent.live2.V2TXLivePusher
    public int stopPush() {
        synchronized (this) {
            if (this.mImpl == null) {
                return -3;
            }
            return this.mImpl.stopPush();
        }
    }

    @Override // com.tencent.live2.V2TXLivePusher
    public int stopScreenCapture() {
        synchronized (this) {
            if (this.mImpl == null) {
                return -3;
            }
            return this.mImpl.stopScreenCapture();
        }
    }

    @Override // com.tencent.live2.V2TXLivePusher
    public int stopVirtualCamera() {
        synchronized (this) {
            if (this.mImpl == null) {
                return -3;
            }
            return this.mImpl.stopVirtualCamera();
        }
    }
}
