package com.tencent.liteav.live;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.tencent.liteav.base.ContextUtils;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.videobase.videobase.DisplayTarget;
import com.tencent.rtmp.ITXLivePlayListener;
import com.tencent.rtmp.TXLivePlayer;
import com.tencent.rtmp.TXVodConstants;
import com.tencent.rtmp.TXVodPlayConfig;
import java.util.concurrent.CountDownLatch;

@JNINamespace("liteav::live")
/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/live/VodPlayerAndroid.class */
public class VodPlayerAndroid implements ITXLivePlayListener, TXLivePlayer.ITXSnapshotListener {
    private com.tencent.liteav.a mImpl;
    private b mMainHandler;
    private long mNativeVodPlayerAndroid;
    private a mState = a.kNone;
    private boolean mHasNotifiedRendingFirstVideoFrame = false;

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/live/VodPlayerAndroid$a.class */
    enum a {
        kNone(0),
        kConnecting(1),
        kConnected(2),
        kReconnecting(3),
        kConnectDisconnected(4);
        
        int nativeValue;

        a(int i) {
            this.nativeValue = i;
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/live/VodPlayerAndroid$b.class */
    static final class b extends Handler {
        public b(Looper looper) {
            super(looper);
        }

        public final void a(final Runnable runnable) {
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            if (post(new Runnable() { // from class: com.tencent.liteav.live.VodPlayerAndroid.b.1
                @Override // java.lang.Runnable
                public final void run() {
                    runnable.run();
                    countDownLatch.countDown();
                }
            })) {
                try {
                    countDownLatch.await();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    VodPlayerAndroid(final long j) {
        b bVar = new b(Looper.getMainLooper());
        this.mMainHandler = bVar;
        bVar.a(new Runnable() { // from class: com.tencent.liteav.live.VodPlayerAndroid.1
            @Override // java.lang.Runnable
            public final void run() {
                if (VodPlayerAndroid.this.mImpl == null) {
                    VodPlayerAndroid.this.mNativeVodPlayerAndroid = j;
                    VodPlayerAndroid.this.mImpl = new com.tencent.liteav.a(ContextUtils.getApplicationContext());
                    TXVodPlayConfig tXVodPlayConfig = new TXVodPlayConfig();
                    tXVodPlayConfig.setMediaType(2);
                    VodPlayerAndroid.this.mImpl.a(tXVodPlayConfig);
                    VodPlayerAndroid.this.mImpl.f36212a = VodPlayerAndroid.this;
                }
            }
        });
    }

    private static native void nativeHandleDecoderCodecTypeChanged(long j, int i, int i2);

    private static native void nativeHandleError(long j, int i);

    private static native void nativeHandlePlayingFirstAudioFrame(long j);

    private static native void nativeHandleRendingFirstVideoFrame(long j, int i, int i2);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeHandleState(long j, int i);

    private static native void nativeHandleStutteringBegin(long j);

    private static native void nativeHandleStutteringEnd(long j);

    private static native void nativeHandleVideoResolutionChanged(long j, int i, int i2);

    private static native void nativeOnNetStatus(long j, String str, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8);

    private static native void nativeOnSnapshot(long j, Bitmap bitmap);

    public void destroy() {
        this.mMainHandler.a(new Runnable() { // from class: com.tencent.liteav.live.VodPlayerAndroid.4
            @Override // java.lang.Runnable
            public final void run() {
                VodPlayerAndroid.this.mImpl.f36212a = null;
                VodPlayerAndroid.this.mImpl = null;
                VodPlayerAndroid.this.mNativeVodPlayerAndroid = -1L;
            }
        });
        this.mMainHandler = null;
    }

    void enableHardwareDecoder(final boolean z) {
        this.mMainHandler.post(new Runnable() { // from class: com.tencent.liteav.live.VodPlayerAndroid.10
            @Override // java.lang.Runnable
            public final void run() {
                VodPlayerAndroid.this.mImpl.a(z);
            }
        });
    }

    boolean isPlaying() {
        return this.mState == a.kConnected || this.mState == a.kConnecting || this.mState == a.kReconnecting;
    }

    void muteAudio(final boolean z) {
        this.mMainHandler.post(new Runnable() { // from class: com.tencent.liteav.live.VodPlayerAndroid.11
            @Override // java.lang.Runnable
            public final void run() {
                VodPlayerAndroid.this.mImpl.c(z);
            }
        });
    }

    @Override // com.tencent.rtmp.ITXLivePlayListener
    public void onNetStatus(Bundle bundle) {
        int i;
        int parseInt;
        int parseInt2;
        if (this.mNativeVodPlayerAndroid == -1 || this.mState == a.kNone) {
            return;
        }
        String string = bundle.getString("SERVER_IP");
        String str = string;
        if (string == null) {
            str = "";
        }
        String string2 = bundle.getString("CPU_USAGE");
        if (string2 != null) {
            try {
                String substring = string2.substring(0, string2.length() - 1);
                parseInt = Integer.parseInt(substring.split(BridgeUtil.SPLIT_MARK)[0]);
                try {
                    parseInt2 = Integer.parseInt(substring.split(BridgeUtil.SPLIT_MARK)[1]);
                } catch (Exception e) {
                    e = e;
                    i = parseInt;
                    e.printStackTrace();
                    parseInt2 = 0;
                    parseInt = i;
                    nativeOnNetStatus(this.mNativeVodPlayerAndroid, str, bundle.getInt("VIDEO_DPS"), bundle.getInt("VIDEO_FPS"), bundle.getInt("VIDEO_CACHE"), bundle.getInt("VIDEO_WIDTH"), bundle.getInt("VIDEO_HEIGHT"), bundle.getInt("NET_SPEED"), parseInt, parseInt2);
                }
            } catch (Exception e2) {
                e = e2;
                i = 0;
            }
            nativeOnNetStatus(this.mNativeVodPlayerAndroid, str, bundle.getInt("VIDEO_DPS"), bundle.getInt("VIDEO_FPS"), bundle.getInt("VIDEO_CACHE"), bundle.getInt("VIDEO_WIDTH"), bundle.getInt("VIDEO_HEIGHT"), bundle.getInt("NET_SPEED"), parseInt, parseInt2);
        }
        i = 0;
        parseInt2 = 0;
        parseInt = i;
        nativeOnNetStatus(this.mNativeVodPlayerAndroid, str, bundle.getInt("VIDEO_DPS"), bundle.getInt("VIDEO_FPS"), bundle.getInt("VIDEO_CACHE"), bundle.getInt("VIDEO_WIDTH"), bundle.getInt("VIDEO_HEIGHT"), bundle.getInt("NET_SPEED"), parseInt, parseInt2);
    }

    @Override // com.tencent.rtmp.ITXLivePlayListener
    public void onPlayEvent(int i, Bundle bundle) {
        if (this.mNativeVodPlayerAndroid == -1 || this.mState == a.kNone) {
            return;
        }
        if (i == -2304) {
            nativeHandleError(this.mNativeVodPlayerAndroid, -2304);
        } else if (i == -2301) {
            a aVar = a.kConnectDisconnected;
            this.mState = aVar;
            nativeHandleState(this.mNativeVodPlayerAndroid, aVar.nativeValue);
        } else {
            if (i != 2004) {
                if (i == 2026) {
                    nativeHandlePlayingFirstAudioFrame(this.mNativeVodPlayerAndroid);
                    return;
                } else if (i == 2103) {
                    a aVar2 = a.kReconnecting;
                    this.mState = aVar2;
                    nativeHandleState(this.mNativeVodPlayerAndroid, aVar2.nativeValue);
                    return;
                } else if (i == 2013) {
                    if (this.mState == a.kConnecting || this.mState == a.kReconnecting) {
                        a aVar3 = a.kConnected;
                        this.mState = aVar3;
                        nativeHandleState(this.mNativeVodPlayerAndroid, aVar3.nativeValue);
                        return;
                    }
                    return;
                } else if (i != 2014) {
                    switch (i) {
                        case 2007:
                            nativeHandleStutteringBegin(this.mNativeVodPlayerAndroid);
                            return;
                        case 2008:
                            nativeHandleDecoderCodecTypeChanged(this.mNativeVodPlayerAndroid, bundle.getInt("EVT_PARAM1"), bundle.getInt(TXVodConstants.EVT_CODEC_TYPE));
                            return;
                        case 2009:
                            int i2 = bundle.getInt("EVT_PARAM1");
                            int i3 = bundle.getInt("EVT_PARAM2");
                            if (!this.mHasNotifiedRendingFirstVideoFrame) {
                                nativeHandleRendingFirstVideoFrame(this.mNativeVodPlayerAndroid, i2, i3);
                                this.mHasNotifiedRendingFirstVideoFrame = true;
                            }
                            nativeHandleVideoResolutionChanged(this.mNativeVodPlayerAndroid, i2, i3);
                            return;
                        default:
                            LiteavLog.i("VodPlayerAndroid onPlayEvent:", i + " " + bundle.toString());
                            return;
                    }
                }
            }
            nativeHandleStutteringEnd(this.mNativeVodPlayerAndroid);
        }
    }

    @Override // com.tencent.rtmp.TXLivePlayer.ITXSnapshotListener
    public void onSnapshot(Bitmap bitmap) {
        if (this.mNativeVodPlayerAndroid == -1 || this.mState == a.kNone) {
            return;
        }
        nativeOnSnapshot(this.mNativeVodPlayerAndroid, bitmap);
    }

    void setRenderMode(final int i) {
        this.mMainHandler.post(new Runnable() { // from class: com.tencent.liteav.live.VodPlayerAndroid.8
            @Override // java.lang.Runnable
            public final void run() {
                VodPlayerAndroid.this.mImpl.b(i);
            }
        });
    }

    void setRenderRotation(final int i) {
        this.mMainHandler.post(new Runnable() { // from class: com.tencent.liteav.live.VodPlayerAndroid.9
            @Override // java.lang.Runnable
            public final void run() {
                VodPlayerAndroid.this.mImpl.c(i);
            }
        });
    }

    void setView(final DisplayTarget displayTarget) {
        if (displayTarget == null) {
            return;
        }
        this.mMainHandler.post(new Runnable() { // from class: com.tencent.liteav.live.VodPlayerAndroid.5
            @Override // java.lang.Runnable
            public final void run() {
                VodPlayerAndroid.this.mImpl.a(displayTarget.getTXCloudVideoView());
            }
        });
    }

    void setVolume(final int i) {
        this.mMainHandler.post(new Runnable() { // from class: com.tencent.liteav.live.VodPlayerAndroid.2
            @Override // java.lang.Runnable
            public final void run() {
                VodPlayerAndroid.this.mImpl.a(i);
            }
        });
    }

    void snapshot() {
        this.mMainHandler.post(new Runnable() { // from class: com.tencent.liteav.live.VodPlayerAndroid.3
            @Override // java.lang.Runnable
            public final void run() {
                VodPlayerAndroid.this.mImpl.a(VodPlayerAndroid.this);
            }
        });
    }

    int start(final String str) {
        a aVar = a.kConnecting;
        this.mState = aVar;
        nativeHandleState(this.mNativeVodPlayerAndroid, aVar.nativeValue);
        this.mMainHandler.post(new Runnable() { // from class: com.tencent.liteav.live.VodPlayerAndroid.6
            @Override // java.lang.Runnable
            public final void run() {
                if (VodPlayerAndroid.this.mImpl.a(str) != 0) {
                    VodPlayerAndroid.this.mState = a.kConnectDisconnected;
                    VodPlayerAndroid.nativeHandleState(VodPlayerAndroid.this.mNativeVodPlayerAndroid, VodPlayerAndroid.this.mState.nativeValue);
                }
                VodPlayerAndroid.this.mHasNotifiedRendingFirstVideoFrame = false;
            }
        });
        return 0;
    }

    void stop(final boolean z) {
        this.mState = a.kNone;
        this.mMainHandler.post(new Runnable() { // from class: com.tencent.liteav.live.VodPlayerAndroid.7
            @Override // java.lang.Runnable
            public final void run() {
                VodPlayerAndroid.this.mImpl.b(z);
            }
        });
    }
}
