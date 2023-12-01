package com.qiniu.pili.droid.streaming;

import a.a.a.a.a.e.e;
import a.a.a.a.a.g.b;
import a.a.a.a.a.l.a;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Surface;
import com.baidu.mobads.sdk.internal.bw;
import com.qiniu.pili.droid.streaming.StreamingProfile;
import java.nio.ByteBuffer;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/streaming/ScreenStreamingManager.class */
public class ScreenStreamingManager implements b.a, a.c, StreamingStateChangedListener {

    /* renamed from: a  reason: collision with root package name */
    public Context f27823a;
    public b b;

    /* renamed from: c  reason: collision with root package name */
    public StreamingManager f27824c;
    public a.a.a.a.a.a.j.h.b d;
    public StreamingStateChangedListener e;
    public StreamingSessionListener f;
    public StreamStatusCallback g;
    public AudioSourceCallback h;
    public ScreenSetting i;
    public StreamingProfile j;
    public boolean k = false;
    public boolean l = false;

    public final MicrophoneStreamingSetting a() {
        MicrophoneStreamingSetting microphoneStreamingSetting = new MicrophoneStreamingSetting();
        microphoneStreamingSetting.setBluetoothSCOEnabled(false);
        return microphoneStreamingSetting;
    }

    @Override // a.a.a.a.a.g.b.a
    public void a(ByteBuffer byteBuffer, int i, long j, boolean z) {
        AudioSourceCallback audioSourceCallback = this.h;
        if (audioSourceCallback != null) {
            audioSourceCallback.onAudioSourceAvailable(byteBuffer, i, j * 1000, z);
        }
        this.f27824c.inputAudioFrame(byteBuffer, i, j, z);
    }

    @Override // a.a.a.a.a.l.a.c
    public void a(boolean z) {
        if (this.l) {
            this.f27824c.frameAvailable(z);
        } else {
            e.f1361c.b("ScreenStreamingManager", "onFrameCaptured audio frame not available");
        }
    }

    public final boolean a(Surface surface) {
        b bVar;
        e.f1361c.c("ScreenStreamingManager", "startDataCollection");
        this.l = false;
        a.a().a(this);
        boolean a2 = a.a().a(this.f27823a, this.i.getWidth(), this.i.getHeight(), this.i.getDpi(), surface);
        if (a2 && (bVar = this.b) != null) {
            bVar.a(this.f27823a);
            return true;
        }
        e eVar = e.f1361c;
        StringBuilder sb = new StringBuilder();
        sb.append("screenCaptureOk ");
        sb.append(a2 ? "true" : "false");
        sb.append(", audioManager is ");
        sb.append(this.b != null ? "exist" : com.igexin.push.core.b.l);
        eVar.d("ScreenStreamingManager", sb.toString());
        e.f1361c.e("ScreenStreamingManager", "startDataCollection failed");
        return false;
    }

    public final ScreenSetting b() {
        DisplayMetrics displayMetrics = this.f27823a.getResources().getDisplayMetrics();
        ScreenSetting screenSetting = new ScreenSetting();
        screenSetting.setSize(displayMetrics.widthPixels, displayMetrics.heightPixels);
        screenSetting.setDpi(displayMetrics.densityDpi);
        return screenSetting;
    }

    @Override // a.a.a.a.a.g.b.a
    public void b(int i) {
        this.f27824c.B();
    }

    @Override // a.a.a.a.a.l.a.c
    public void b(boolean z) {
        e eVar = e.f1361c;
        eVar.c("ScreenStreamingManager", "onRequestResult " + z);
        if (!z) {
            this.e.onStateChanged(StreamingState.REQUEST_SCREEN_CAPTURING_FAIL, null);
            return;
        }
        this.k = true;
        this.e.onStateChanged(StreamingState.READY, null);
    }

    public final StreamingProfile c() {
        StreamingProfile streamingProfile = new StreamingProfile();
        streamingProfile.setEncodingSizeLevel(1).setAudioQuality(20).setSendingBufferProfile(new StreamingProfile.SendingBufferProfile(0.2f, 0.8f, 3.0f, 20000L)).setVideoQuality(10);
        return streamingProfile;
    }

    @Override // a.a.a.a.a.g.b.a
    public void c(boolean z) {
        if (!z) {
            this.l = true;
            return;
        }
        e eVar = e.f1361c;
        eVar.c("ScreenStreamingManager", "notifyFirstAudioFrame MicrophoneOpenFailed:" + z);
    }

    public final void d(boolean z) {
        e.d.c("ScreenStreamingManager", "stopPictureStreaming +");
        this.f27824c.H();
        this.d.b(z);
        e.d.c("ScreenStreamingManager", "stopPictureStreaming -");
    }

    public final boolean d() {
        if (this.f27824c == null) {
            e.d.d("ScreenStreamingManager", "toggle picture streaming failed cause not is streaming.");
            return false;
        } else if (this.d == null) {
            String pictureStreamingFilePath = this.j.getPictureStreamingFilePath();
            int pictureStreamingResourceId = this.j.getPictureStreamingResourceId();
            if (pictureStreamingFilePath == null && pictureStreamingResourceId < 0) {
                e.d.d("ScreenStreamingManager", "toggle picture streaming failed cause no file set.");
                return false;
            }
            a.a.a.a.a.a.j.h.b bVar = new a.a.a.a.a.a.j.h.b(this.f27823a, null, this.f27824c.f(), this.f27824c.g());
            this.d = bVar;
            if (pictureStreamingFilePath != null) {
                bVar.a(pictureStreamingFilePath);
                return true;
            }
            bVar.a(pictureStreamingResourceId);
            return true;
        } else {
            return true;
        }
    }

    public void destroy() {
        e.d.c("ScreenStreamingManager", "destroy +");
        h();
        StreamingManager streamingManager = this.f27824c;
        if (streamingManager != null) {
            streamingManager.pause();
            this.f27824c.destroy();
        }
        this.f27823a = null;
        e.d.c("ScreenStreamingManager", "destroy -");
    }

    public final boolean e() {
        a.a.a.a.a.a.j.h.b bVar = this.d;
        return bVar != null && bVar.c();
    }

    public final void f() {
        e.d.c("ScreenStreamingManager", "startPictureStreaming +");
        this.f27824c.D();
        this.d.a(this.j.getPictureStreamingFps());
        this.d.e();
        e.d.c("ScreenStreamingManager", "startPictureStreaming -");
    }

    public final void g() {
        StreamingManager streamingManager = this.f27824c;
        if (streamingManager == null || this.i == null) {
            e.f1361c.d("ScreenStreamingManager", "something is null !!!");
            return;
        }
        streamingManager.F();
        Surface inputSurface = this.f27824c.getInputSurface(this.i.getWidth(), this.i.getHeight());
        a.a().a(this);
        a.a().a(this.f27823a, this.i.getWidth(), this.i.getHeight(), this.i.getDpi(), inputSurface);
    }

    public final void h() {
        e.f1361c.c("ScreenStreamingManager", "stopDataCollection");
        a.a().b();
        b bVar = this.b;
        if (bVar != null) {
            bVar.b(this.f27823a);
        } else {
            e.f1361c.d("ScreenStreamingManager", "AudioManager is null !!!");
        }
    }

    public final void i() {
        if (this.f27824c == null) {
            e.f1361c.d("ScreenStreamingManager", "no streaming.");
            return;
        }
        a.a().b();
        this.f27824c.a(true);
    }

    public void mute(boolean z) {
        e eVar = e.d;
        eVar.c("ScreenStreamingManager", "mute " + z);
        b bVar = this.b;
        if (bVar != null) {
            bVar.a(z);
        } else {
            e.d.e("ScreenStreamingManager", "mute opreation only can be used after prepare");
        }
    }

    @Override // com.qiniu.pili.droid.streaming.StreamingStateChangedListener
    public void onStateChanged(StreamingState streamingState, Object obj) {
        if (streamingState == StreamingState.READY) {
            return;
        }
        if (streamingState == StreamingState.DISCONNECTED || streamingState == StreamingState.UNAUTHORIZED_STREAMING_URL) {
            h();
        }
        StreamingStateChangedListener streamingStateChangedListener = this.e;
        if (streamingStateChangedListener != null) {
            streamingStateChangedListener.onStateChanged(streamingState, obj);
            e eVar = e.f;
            eVar.b("ScreenStreamingManager", "onStateChanged state=" + streamingState + ", extra=" + obj);
        }
    }

    public boolean prepare(Context context, ScreenSetting screenSetting, MicrophoneStreamingSetting microphoneStreamingSetting, StreamingProfile streamingProfile) {
        e eVar = e.d;
        eVar.c("ScreenStreamingManager", "prepare, screenSetting = " + screenSetting + ", microphoneSetting = " + microphoneStreamingSetting + ", profile = " + streamingProfile);
        StreamingEnv.a();
        if (this.k) {
            return false;
        }
        if (context == null) {
            e.d.e("ScreenStreamingManager", "context cannot be null.");
        }
        this.f27823a = context.getApplicationContext();
        if (screenSetting == null) {
            this.i = b();
        } else {
            this.i = screenSetting;
        }
        StreamingProfile streamingProfile2 = streamingProfile;
        if (streamingProfile == null) {
            streamingProfile2 = c();
        }
        MicrophoneStreamingSetting microphoneStreamingSetting2 = microphoneStreamingSetting;
        if (microphoneStreamingSetting == null) {
            microphoneStreamingSetting2 = a();
        }
        StreamingManager streamingManager = new StreamingManager(this.f27823a, AVCodecType.HW_VIDEO_SURFACE_AS_INPUT_WITH_SW_AUDIO_CODEC);
        this.f27824c = streamingManager;
        streamingManager.prepare(streamingProfile2);
        this.f27824c.setStreamingStateListener(this);
        StreamingSessionListener streamingSessionListener = this.f;
        if (streamingSessionListener != null) {
            this.f27824c.setStreamingSessionListener(streamingSessionListener);
        }
        StreamStatusCallback streamStatusCallback = this.g;
        if (streamStatusCallback != null) {
            this.f27824c.setStreamStatusCallback(streamStatusCallback);
        }
        this.b = new b(microphoneStreamingSetting2, this);
        this.j = streamingProfile2;
        a.a().a(this.f27823a, this);
        return true;
    }

    public final void setAudioSourceCallback(AudioSourceCallback audioSourceCallback) {
        e eVar = e.d;
        StringBuilder sb = new StringBuilder();
        sb.append("setAudioSourceCallback ");
        sb.append(audioSourceCallback != null);
        eVar.c("ScreenStreamingManager", sb.toString());
        this.h = audioSourceCallback;
    }

    public void setNativeLoggingEnabled(boolean z) {
        e.a(z);
    }

    public void setPictureStreamingFilePath(String str) {
        StreamingProfile streamingProfile = this.j;
        if (streamingProfile == null) {
            e.d.d("ScreenStreamingManager", "StreamingProfile is null !!!");
            return;
        }
        streamingProfile.setPictureStreamingFilePath(str);
        if (e()) {
            this.d.a(str);
        }
    }

    public void setPictureStreamingResourceId(int i) {
        StreamingProfile streamingProfile = this.j;
        if (streamingProfile == null) {
            e.d.d("ScreenStreamingManager", "StreamingProfile is null !!!");
            return;
        }
        streamingProfile.setPictureStreamingResourceId(i);
        if (e()) {
            this.d.a(i);
        }
    }

    public final void setScreenCaptureSessionListener(ScreenCaptureSessionListener screenCaptureSessionListener) {
        a.a().a(screenCaptureSessionListener);
    }

    public final void setStreamStatusCallback(StreamStatusCallback streamStatusCallback) {
        e eVar = e.d;
        StringBuilder sb = new StringBuilder();
        sb.append("setStreamStatusCallback ");
        sb.append(streamStatusCallback != null);
        eVar.c("ScreenStreamingManager", sb.toString());
        if (streamStatusCallback == null) {
            throw new IllegalArgumentException("StreamStatusCallback is null");
        }
        this.g = streamStatusCallback;
    }

    public void setStreamingProfile(StreamingProfile streamingProfile) {
        e eVar = e.d;
        eVar.c("ScreenStreamingManager", "setStreamingProfile " + streamingProfile);
        if (streamingProfile != null) {
            this.f27824c.setStreamingProfile(streamingProfile);
            return;
        }
        throw new IllegalArgumentException("Illegal profile:" + streamingProfile);
    }

    public final void setStreamingSessionListener(StreamingSessionListener streamingSessionListener) {
        e eVar = e.d;
        StringBuilder sb = new StringBuilder();
        sb.append("setStreamingSessionListener ");
        sb.append(streamingSessionListener != null);
        eVar.c("ScreenStreamingManager", sb.toString());
        if (streamingSessionListener == null) {
            throw new IllegalArgumentException("Error!!! listener cannot be null");
        }
        this.f = streamingSessionListener;
    }

    public final void setStreamingStateListener(StreamingStateChangedListener streamingStateChangedListener) {
        e eVar = e.d;
        StringBuilder sb = new StringBuilder();
        sb.append("setStreamingStateListener ");
        sb.append(streamingStateChangedListener != null);
        eVar.c("ScreenStreamingManager", sb.toString());
        if (streamingStateChangedListener == null) {
            throw new IllegalArgumentException("Error!!! listener cannot be null");
        }
        this.e = streamingStateChangedListener;
    }

    public boolean startStreaming() {
        String sb;
        e.d.c("ScreenStreamingManager", "startStreaming +");
        boolean z = false;
        if (!a.a.a.a.a.n.b.a().b()) {
            e.d.e("ScreenStreamingManager", "Authentication failed!!!");
            StreamingStateChangedListener streamingStateChangedListener = this.e;
            if (streamingStateChangedListener != null) {
                streamingStateChangedListener.onStateChanged(StreamingState.UNAUTHORIZED_PACKAGE, null);
                return false;
            }
            return false;
        }
        if (this.f27824c.startStreaming()) {
            Surface inputSurface = this.f27824c.getInputSurface(this.i.getWidth(), this.i.getHeight());
            if (inputSurface == null || !a(inputSurface)) {
                e eVar = e.d;
                if (("inputSurface " + inputSurface) == null) {
                    sb = "is null";
                } else {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("exist, startDataCollection ");
                    sb2.append(a(inputSurface) ? bw.o : com.alipay.sdk.util.e.f4661a);
                    sb = sb2.toString();
                }
                eVar.d("ScreenStreamingManager", sb);
                this.f27824c.stopStreaming();
            } else {
                e.d.c("ScreenStreamingManager", "startStreaming success");
                z = true;
            }
        } else {
            e.d.e("ScreenStreamingManager", "startStreaming failed");
        }
        e.d.c("ScreenStreamingManager", "startStreaming -");
        return z;
    }

    public boolean stopStreaming() {
        e.d.c("ScreenStreamingManager", "stopStreaming +");
        h();
        if (e()) {
            d(false);
        }
        StreamingManager streamingManager = this.f27824c;
        if (streamingManager != null) {
            return streamingManager.stopStreaming();
        }
        e.d.c("ScreenStreamingManager", "stopStreaming -");
        return false;
    }

    public boolean togglePictureStreaming() {
        synchronized (this) {
            if (this.f27824c == null) {
                e.d.d("ScreenStreamingManager", "no streaming.");
                return false;
            } else if (d()) {
                if (!this.k || !this.f27824c.h()) {
                    e.d.d("ScreenStreamingManager", "toggle picture streaming failed cause in invalid state");
                    return false;
                }
                if (this.d.c()) {
                    d(false);
                    g();
                } else {
                    i();
                    f();
                    a.a.a.a.a.d.b.n();
                }
                return true;
            } else {
                return false;
            }
        }
    }
}
