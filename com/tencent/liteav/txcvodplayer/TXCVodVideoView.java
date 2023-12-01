package com.tencent.liteav.txcvodplayer;

import android.content.Context;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.View;
import android.widget.FrameLayout;
import com.android.internal.telephony.PhoneConstants;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.tencent.liteav.base.system.LiteavSystemInfo;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.txcplayer.ITXVCubePlayer;
import com.tencent.liteav.txcplayer.d;
import com.tencent.liteav.txcplayer.d.b;
import com.tencent.liteav.txcplayer.e;
import com.tencent.liteav.txcplayer.ext.service.RenderProcessService;
import com.tencent.liteav.txcplayer.f;
import com.tencent.liteav.txcvodplayer.renderer.SurfaceRenderView;
import com.tencent.liteav.txcvodplayer.renderer.TextureRenderView;
import com.tencent.liteav.txcvodplayer.renderer.a;
import com.tencent.rtmp.TXVodConstants;
import com.tencent.thumbplayer.api.TPPlayerMsg;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/txcvodplayer/TXCVodVideoView.class */
public class TXCVodVideoView extends FrameLayout {
    private String A;
    private float B;
    private long C;
    private volatile boolean D;
    private int E;
    private int F;
    private boolean G;
    private int H;
    private int I;
    private boolean J;
    private ITXVCubePlayer.c K;
    private ITXVCubePlayer.g L;
    private int M;
    private ITXVCubePlayer.d N;
    private ITXVCubePlayer.f O;
    private ITXVCubePlayer.k P;
    private ITXVCubePlayer.i Q;
    private ITXVCubePlayer.j R;
    private ITXVCubePlayer.e S;
    private int T;
    private d U;
    private Handler V;
    private boolean W;

    /* renamed from: a  reason: collision with root package name */
    public int f36490a;
    public int b;

    /* renamed from: c  reason: collision with root package name */
    public ITXVCubePlayer f36491c;
    protected boolean d;
    protected final int e;
    public Object f;
    ITXVCubePlayer.l g;
    ITXVCubePlayer.h h;
    a.InterfaceC0935a i;
    private a.b j;
    private int k;
    private int l;
    private int m;
    private int n;
    private int o;
    private int p;
    private long q;
    private long r;
    private int s;
    private boolean t;
    private Context u;
    private e v;
    private Map<String, Object> w;
    private com.tencent.liteav.txcvodplayer.renderer.a x;
    private int y;
    private int z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/txcvodplayer/TXCVodVideoView$a.class */
    public static final class a extends Handler {

        /* renamed from: a  reason: collision with root package name */
        private final WeakReference<TXCVodVideoView> f36505a;
        private final int b;

        /* renamed from: c  reason: collision with root package name */
        private final String f36506c;

        public a(TXCVodVideoView tXCVodVideoView, Looper looper) {
            super(looper);
            this.b = 500;
            this.f36506c = "TXCVodeVideoView_Eventhandler";
            this.f36505a = new WeakReference<>(tXCVodVideoView);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            TXCVodVideoView tXCVodVideoView = this.f36505a.get();
            if (tXCVodVideoView == null || tXCVodVideoView.U == null) {
                return;
            }
            switch (message.what) {
                case 100:
                    float f = 0.0f;
                    if (tXCVodVideoView.f36491c == null) {
                        return;
                    }
                    try {
                        float propertyLong = (float) tXCVodVideoView.f36491c.getPropertyLong(206);
                        long currentPosition = tXCVodVideoView.f36491c.getCurrentPosition();
                        long propertyLong2 = tXCVodVideoView.f36491c.getPropertyLong(208);
                        if (currentPosition > 0) {
                            f = (float) ((propertyLong2 * 1000) / currentPosition);
                        }
                        long propertyLong3 = tXCVodVideoView.f36491c.getPropertyLong(302);
                        long propertyLong4 = tXCVodVideoView.f36491c.getPropertyLong(301);
                        long propertyLong5 = tXCVodVideoView.f36491c.getPropertyLong(303);
                        Bundle bundle = new Bundle();
                        bundle.putFloat("fps", propertyLong);
                        bundle.putFloat("dps", f);
                        bundle.putLong("cachedBytes", propertyLong3);
                        bundle.putLong("bitRate", propertyLong4);
                        bundle.putLong("tcpSpeed", propertyLong5);
                        tXCVodVideoView.U.a(bundle);
                        removeMessages(100);
                        sendEmptyMessageDelayed(100, 500L);
                        return;
                    } catch (Exception e) {
                        LiteavLog.e("TXCVodeVideoView_Eventhandler", "MSG_UPDATE_NET_STATUS exception : " + e.getMessage());
                        return;
                    }
                case 101:
                    int i = message.arg1;
                    if (i == 2013) {
                        LiteavLog.i("TXCVodeVideoView_Eventhandler", "TXCVodVideoView handleMessage:MSG_PLAY_EVENT:EVT_VOD_PLAY_PREPARED");
                    }
                    tXCVodVideoView.U.a(i, message.getData());
                    return;
                case 102:
                    tXCVodVideoView.c(true);
                    tXCVodVideoView.a(2103, "VOD network reconnected", "reconnect");
                    return;
                case 103:
                    long currentPosition2 = tXCVodVideoView.getCurrentPosition();
                    Bundle bundle2 = new Bundle();
                    long bufferDuration = tXCVodVideoView.getBufferDuration();
                    long duration = tXCVodVideoView.getDuration();
                    bundle2.putInt("EVT_PLAY_PROGRESS", (int) (currentPosition2 / 1000));
                    bundle2.putInt("EVT_PLAY_DURATION", (int) (duration / 1000));
                    bundle2.putInt(TXVodConstants.EVT_PLAYABLE_DURATION, (int) (bufferDuration / 1000));
                    bundle2.putInt("EVT_PLAY_PROGRESS_MS", (int) currentPosition2);
                    bundle2.putInt("EVT_PLAY_DURATION_MS", (int) duration);
                    bundle2.putInt("EVT_PLAYABLE_DURATION_MS", (int) bufferDuration);
                    if (tXCVodVideoView.f36491c != null) {
                        bundle2.putFloat("EVT_PLAYABLE_RATE", tXCVodVideoView.f36491c.getRate());
                    }
                    tXCVodVideoView.U.a(2005, bundle2);
                    if (tXCVodVideoView.f36491c != null) {
                        if (tXCVodVideoView.v.l <= 0) {
                            tXCVodVideoView.v.l = 500;
                        }
                        removeMessages(103);
                        sendEmptyMessageDelayed(103, tXCVodVideoView.v.l);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public TXCVodVideoView(Context context) {
        super(context);
        this.f36490a = 0;
        this.b = 0;
        this.j = null;
        this.f36491c = null;
        this.t = false;
        this.B = 1.0f;
        this.d = true;
        this.e = 2;
        this.D = false;
        this.E = -1;
        this.F = 100;
        this.G = false;
        this.H = -1000;
        this.I = -1;
        this.f = null;
        this.g = new ITXVCubePlayer.l() { // from class: com.tencent.liteav.txcvodplayer.TXCVodVideoView.7
            @Override // com.tencent.liteav.txcplayer.ITXVCubePlayer.l
            public final void a(ITXVCubePlayer iTXVCubePlayer, int i, int i2, String str) {
                boolean z = (TXCVodVideoView.this.l != i2 && Math.abs(TXCVodVideoView.this.l - i2) > 16) || (TXCVodVideoView.this.k != i && Math.abs(TXCVodVideoView.this.k - i) > 16);
                TXCVodVideoView.this.k = iTXVCubePlayer.getVideoWidth();
                TXCVodVideoView.this.l = iTXVCubePlayer.getVideoHeight();
                TXCVodVideoView.this.y = iTXVCubePlayer.getVideoSarNum();
                TXCVodVideoView.this.z = iTXVCubePlayer.getVideoSarDen();
                LiteavLog.i("TXCVodVideoView", "OnVideoSizeChangedListener width:" + TXCVodVideoView.this.k + ":height:" + TXCVodVideoView.this.l + ":SarNum:" + TXCVodVideoView.this.y + ":SarDen:" + TXCVodVideoView.this.z);
                if (TXCVodVideoView.this.k != 0 && TXCVodVideoView.this.l != 0) {
                    if (TXCVodVideoView.this.x != null) {
                        TXCVodVideoView.this.x.a(TXCVodVideoView.this.k, TXCVodVideoView.this.l);
                        TXCVodVideoView.this.x.b(TXCVodVideoView.this.y, TXCVodVideoView.this.z);
                    }
                    TXCVodVideoView.this.requestLayout();
                }
                if (!z) {
                    if (TXCVodVideoView.this.t || str == null) {
                        return;
                    }
                    Message message = new Message();
                    message.what = 101;
                    message.arg1 = 2009;
                    Bundle bundle = new Bundle();
                    String str2 = i + "," + i2 + "," + str;
                    bundle.putString("description", "Resolution change:" + TXCVodVideoView.this.k + PhoneConstants.APN_TYPE_ALL + TXCVodVideoView.this.l + " Crop(width,height,crop_left,crop_top,crop_right,crop_bottom):(" + str2 + ")");
                    bundle.putInt("EVT_PARAM1", TXCVodVideoView.this.k);
                    bundle.putInt("EVT_PARAM2", TXCVodVideoView.this.l);
                    bundle.putString("EVT_PARAM3", str2);
                    message.setData(bundle);
                    if (TXCVodVideoView.this.V != null) {
                        TXCVodVideoView.this.V.sendMessage(message);
                        return;
                    }
                    return;
                }
                Message message2 = new Message();
                message2.what = 101;
                message2.arg1 = 2009;
                Bundle bundle2 = new Bundle();
                bundle2.putInt("EVT_PARAM1", TXCVodVideoView.this.k);
                bundle2.putInt("EVT_PARAM2", TXCVodVideoView.this.l);
                if (TXCVodVideoView.this.t || str == null) {
                    bundle2.putString("description", "Resolution change:" + TXCVodVideoView.this.k + PhoneConstants.APN_TYPE_ALL + TXCVodVideoView.this.l);
                } else if (str != null) {
                    String str3 = i + "," + i2 + "," + str;
                    bundle2.putString("description", "Resolution change:" + TXCVodVideoView.this.k + PhoneConstants.APN_TYPE_ALL + TXCVodVideoView.this.l + " Crop(width,height,crop_left,crop_top,crop_right,crop_bottom):(" + str3 + ")");
                    bundle2.putString("EVT_PARAM3", str3);
                }
                message2.setData(bundle2);
                if (TXCVodVideoView.this.V != null) {
                    TXCVodVideoView.this.V.sendMessage(message2);
                }
            }
        };
        this.h = new ITXVCubePlayer.h() { // from class: com.tencent.liteav.txcvodplayer.TXCVodVideoView.8
            @Override // com.tencent.liteav.txcplayer.ITXVCubePlayer.h
            public final void a(ITXVCubePlayer iTXVCubePlayer) {
                if (RenderProcessService.getInstance().setSurfaceBufferSize(iTXVCubePlayer)) {
                    LiteavLog.i("TXCVodVideoView", "setSurfaceBufferSize succeed");
                }
                if (TXCVodVideoView.this.f36490a == 1) {
                    TXCVodVideoView.this.a(2013, "VOD ready", "prepared");
                    if (!TXCVodVideoView.this.v.p) {
                        TXCVodVideoView.this.b = 4;
                    } else if (TXCVodVideoView.this.b != 4) {
                        TXCVodVideoView.this.b = 3;
                    }
                    TXCVodVideoView.this.f36490a = 2;
                }
                TXCVodVideoView.k(TXCVodVideoView.this);
                if (TXCVodVideoView.this.f36490a == -1) {
                    TXCVodVideoView.this.f36490a = 3;
                    TXCVodVideoView.this.b = 3;
                }
                if (TXCVodVideoView.this.V != null) {
                    TXCVodVideoView.this.V.sendEmptyMessage(100);
                    TXCVodVideoView.this.V.sendEmptyMessage(103);
                }
                TXCVodVideoView.this.k = iTXVCubePlayer.getVideoWidth();
                TXCVodVideoView.this.l = iTXVCubePlayer.getVideoHeight();
                if (TXCVodVideoView.this.k != 0 && TXCVodVideoView.this.l != 0 && TXCVodVideoView.this.x != null) {
                    TXCVodVideoView.this.x.a(TXCVodVideoView.this.k, TXCVodVideoView.this.l);
                    TXCVodVideoView.this.x.b(TXCVodVideoView.this.y, TXCVodVideoView.this.z);
                }
                if (TXCVodVideoView.this.b == 3) {
                    TXCVodVideoView.this.a();
                }
            }
        };
        this.K = new ITXVCubePlayer.c() { // from class: com.tencent.liteav.txcvodplayer.TXCVodVideoView.9
            @Override // com.tencent.liteav.txcplayer.ITXVCubePlayer.c
            public final void a() {
                TXCVodVideoView.this.f36490a = 5;
                TXCVodVideoView.this.b = 5;
                TXCVodVideoView.this.a(2006, "Playback completed", "play end");
            }
        };
        this.L = new ITXVCubePlayer.g() { // from class: com.tencent.liteav.txcvodplayer.TXCVodVideoView.10
            @Override // com.tencent.liteav.txcplayer.ITXVCubePlayer.g
            public final boolean a(int i, int i2, int i3, Object obj) {
                if (i == 1006) {
                    if (TextUtils.isEmpty(TXCVodVideoView.this.A) && obj != null && (obj instanceof TPPlayerMsg.TPDownLoadProgressInfo)) {
                        try {
                            TXCVodVideoView.this.A = new JSONObject(((TPPlayerMsg.TPDownLoadProgressInfo) obj).extraInfo).optString("cdnip");
                            return true;
                        } catch (Exception e) {
                            e.printStackTrace();
                            return true;
                        }
                    }
                    return true;
                } else if (i == 2003) {
                    LiteavLog.i("TXCVodVideoView", "EVT_RENDER_FIRST_I_FRAME");
                    TXCVodVideoView.this.a(i, "VOD displayed the first frame", "render start");
                    TXCVodVideoView tXCVodVideoView = TXCVodVideoView.this;
                    tXCVodVideoView.setRate(tXCVodVideoView.B);
                    TXCVodVideoView.m(TXCVodVideoView.this);
                    return true;
                } else if (i == 2007) {
                    LiteavLog.i("TXCVodVideoView", "EVT_VIDEO_PLAY_LOADING");
                    TXCVodVideoView.this.a(i, "Buffer started", "loading start");
                    return true;
                } else if (i == 2011) {
                    LiteavLog.i("TXCVodVideoView", "EVT_VIDEO_CHANGE_ROTATION: ".concat(String.valueOf(i2)));
                    TXCVodVideoView.this.p = i2;
                    if (TXCVodVideoView.this.v.y && TXCVodVideoView.this.p > 0) {
                        TXCVodVideoView tXCVodVideoView2 = TXCVodVideoView.this;
                        tXCVodVideoView2.o = tXCVodVideoView2.p;
                        if (TXCVodVideoView.this.x != null) {
                            TXCVodVideoView.this.x.setVideoRotation(TXCVodVideoView.this.o);
                        }
                    }
                    TXCVodVideoView.this.a(2011, "Video angle " + TXCVodVideoView.this.p, "rotation " + TXCVodVideoView.this.p);
                    return true;
                } else if (i == 2014) {
                    LiteavLog.i("TXCVodVideoView", "EVT_VOD_PLAY_LOADING_END: eof ".concat(String.valueOf(i2)));
                    TXCVodVideoView.this.a(i, "Buffer ended", "loading end");
                    if (i2 != 0) {
                        String str = TXCVodVideoView.this.v.q;
                        if (TextUtils.isEmpty(str) && str.endsWith("m3u8")) {
                            return true;
                        }
                    }
                    if (TXCVodVideoView.this.b == 3) {
                        TXCVodVideoView.this.a(2004, "Playback started", "playing");
                        TXCVodVideoView.this.f36490a = 3;
                        TXCVodVideoView.this.V.sendEmptyMessage(100);
                        TXCVodVideoView.this.V.sendEmptyMessage(103);
                        return true;
                    }
                    return true;
                } else if (i == 2026) {
                    LiteavLog.i("TXCVodVideoView", "EVT_AUDIO_JITTER_STATE_FIRST_PLAY");
                    TXCVodVideoView.this.a(i, "Audio first play", "audio start");
                    return true;
                } else {
                    switch (i) {
                        case 2016:
                            if (obj != null && (obj instanceof String)) {
                                TXCVodVideoView.this.A = (String) obj;
                            }
                            String str2 = "TCP Connect ServerIp:" + TXCVodVideoView.this.A + ",port:" + i2 + ",error:" + i3;
                            LiteavLog.i("TXCVodVideoView", str2);
                            if (i3 == 0) {
                                TXCVodVideoView.this.a(i, str2, "tcp open");
                                return true;
                            }
                            return true;
                        case 2017:
                            TXCVodVideoView.this.a(i, "Video data received", "first video packet");
                            return true;
                        case 2018:
                            String str3 = null;
                            if (obj != null) {
                                str3 = null;
                                if (obj instanceof String) {
                                    str3 = (String) obj;
                                }
                            }
                            String str4 = "dns resolved url:" + str3 + ",error:" + i2;
                            LiteavLog.i("TXCVodVideoView", str4);
                            if (i2 == 0) {
                                TXCVodVideoView.this.a(i, str4, "dns resolved");
                                return true;
                            }
                            return true;
                        default:
                            return true;
                    }
                }
            }
        };
        this.N = new ITXVCubePlayer.d() { // from class: com.tencent.liteav.txcvodplayer.TXCVodVideoView.11
            @Override // com.tencent.liteav.txcplayer.ITXVCubePlayer.d
            public final boolean a(int i, int i2) {
                LiteavLog.e("TXCVodVideoView", "onError: " + i + "," + i2);
                TXCVodVideoView.this.f36490a = -1;
                TXCVodVideoView.this.b = -1;
                if (i == -1010 || i == -1007 || i == -1004 || i == 200) {
                    if (i2 == -2303) {
                        TXCVodVideoView.this.a(i2, "The file does not exist", "file not exist");
                    } else {
                        TXCVodVideoView.this.a(-2301, "Disconnected from the network. Playback error", "disconnect");
                    }
                    TXCVodVideoView.this.b();
                    return true;
                }
                if (TXCVodVideoView.this.C != TXCVodVideoView.this.getCurrentPosition()) {
                    TXCVodVideoView.r(TXCVodVideoView.this);
                }
                TXCVodVideoView tXCVodVideoView = TXCVodVideoView.this;
                tXCVodVideoView.C = tXCVodVideoView.getCurrentPosition();
                if (TXCVodVideoView.s(TXCVodVideoView.this) >= TXCVodVideoView.this.v.f36487a) {
                    TXCVodVideoView.this.a(-2301, "Disconnected from the network. Playback error", "disconnect");
                    TXCVodVideoView.this.b();
                    return true;
                } else if (TXCVodVideoView.this.V != null) {
                    TXCVodVideoView.this.V.sendEmptyMessageDelayed(102, TXCVodVideoView.this.v.b * 1000.0f);
                    return true;
                } else {
                    return true;
                }
            }
        };
        this.O = new ITXVCubePlayer.f() { // from class: com.tencent.liteav.txcvodplayer.TXCVodVideoView.12
            @Override // com.tencent.liteav.txcplayer.ITXVCubePlayer.f
            public final void a() {
                LiteavLog.d("TXCVodVideoView", "onHevcVideoDecoderError");
                TXCVodVideoView.this.a(-2304, "Vod H265 decoding failed", "hevc decode fail");
            }
        };
        this.P = new ITXVCubePlayer.k() { // from class: com.tencent.liteav.txcvodplayer.TXCVodVideoView.13
            @Override // com.tencent.liteav.txcplayer.ITXVCubePlayer.k
            public final void a() {
                LiteavLog.d("TXCVodVideoView", "onVideoDecoderError");
                if (TXCVodVideoView.this.f36490a != 4) {
                    TXCVodVideoView.this.a(2106, "VOD decoding failed", "decode fail");
                }
                if (TXCVodVideoView.this.J || !TXCVodVideoView.this.v.d || Math.min(TXCVodVideoView.this.l, TXCVodVideoView.this.k) >= 1080 || !TXCVodVideoView.this.v.d) {
                    return;
                }
                TXCVodVideoView.this.v.d = false;
                TXCVodVideoView.this.c(false);
            }
        };
        this.Q = new ITXVCubePlayer.i() { // from class: com.tencent.liteav.txcvodplayer.TXCVodVideoView.2
            @Override // com.tencent.liteav.txcplayer.ITXVCubePlayer.i
            public final void a() {
                LiteavLog.v("TXCVodVideoView", "seek complete");
                TXCVodVideoView.v(TXCVodVideoView.this);
                TXCVodVideoView.this.a(2019, "seek complete", null);
            }
        };
        this.R = new ITXVCubePlayer.j() { // from class: com.tencent.liteav.txcvodplayer.TXCVodVideoView.3
        };
        this.S = new ITXVCubePlayer.e() { // from class: com.tencent.liteav.txcvodplayer.TXCVodVideoView.4
            @Override // com.tencent.liteav.txcplayer.ITXVCubePlayer.e
            public final void a() {
                LiteavLog.e("TXCVodVideoView", "onHLSKeyError");
                TXCVodVideoView.this.a(-2305, "HLS decypt key get failed", "hls key error");
                if (TXCVodVideoView.this.f36491c != null) {
                    try {
                        TXCVodVideoView.this.f36491c.stop();
                    } catch (Exception e) {
                        LiteavLog.e("TXCVodVideoView", "onHLSKeyError stop Exception: " + e.getMessage());
                    }
                    TXCVodVideoView.this.f36491c.release();
                    TXCVodVideoView.x(TXCVodVideoView.this);
                }
                TXCVodVideoView.this.f36490a = -1;
                TXCVodVideoView.this.b = -1;
            }
        };
        this.i = new a.InterfaceC0935a() { // from class: com.tencent.liteav.txcvodplayer.TXCVodVideoView.5
            @Override // com.tencent.liteav.txcvodplayer.renderer.a.InterfaceC0935a
            public final void a(a.b bVar) {
                if (bVar.a() != TXCVodVideoView.this.x) {
                    LiteavLog.e("TXCVodVideoView", "onSurfaceCreated: unmatched render callback\n");
                    return;
                }
                LiteavLog.i("TXCVodVideoView", "onSurfaceCreated");
                TXCVodVideoView.this.t = true;
                TXCVodVideoView.this.j = bVar;
                if (TXCVodVideoView.this.f36491c != null) {
                    TXCVodVideoView.b(TXCVodVideoView.this.f36491c, bVar);
                } else {
                    TXCVodVideoView.this.e();
                }
            }

            @Override // com.tencent.liteav.txcvodplayer.renderer.a.InterfaceC0935a
            public final void a(a.b bVar, int i, int i2) {
                if (bVar.a() != TXCVodVideoView.this.x) {
                    LiteavLog.e("TXCVodVideoView", "onSurfaceChanged: unmatched render callback\n");
                    return;
                }
                LiteavLog.i("TXCVodVideoView", "onSurfaceChanged");
                TXCVodVideoView.this.m = i;
                TXCVodVideoView.this.n = i2;
                boolean z = TXCVodVideoView.this.b == 3;
                boolean z2 = true;
                if (TXCVodVideoView.this.x.a()) {
                    z2 = TXCVodVideoView.this.k == i && TXCVodVideoView.this.l == i2;
                }
                if (TXCVodVideoView.this.f36491c != null && z && z2 && TXCVodVideoView.this.b == 3) {
                    TXCVodVideoView.this.a();
                }
            }

            @Override // com.tencent.liteav.txcvodplayer.renderer.a.InterfaceC0935a
            public final void b(a.b bVar) {
                if (bVar.a() != TXCVodVideoView.this.x) {
                    LiteavLog.e("TXCVodVideoView", "onSurfaceDestroyed: unmatched render callback\n");
                    return;
                }
                LiteavLog.i("TXCVodVideoView", "onSurfaceDestroyed");
                TXCVodVideoView.this.t = false;
                TXCVodVideoView.this.j = null;
                if (TXCVodVideoView.this.f36491c != null) {
                    TXCVodVideoView.this.f36491c.setSurface(null);
                }
                TXCVodVideoView tXCVodVideoView = TXCVodVideoView.this;
                if (tXCVodVideoView.f36491c != null) {
                    tXCVodVideoView.f36491c.setDisplay(null);
                }
            }
        };
        this.T = 0;
        this.W = false;
        a(context);
    }

    public TXCVodVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f36490a = 0;
        this.b = 0;
        this.j = null;
        this.f36491c = null;
        this.t = false;
        this.B = 1.0f;
        this.d = true;
        this.e = 2;
        this.D = false;
        this.E = -1;
        this.F = 100;
        this.G = false;
        this.H = -1000;
        this.I = -1;
        this.f = null;
        this.g = new ITXVCubePlayer.l() { // from class: com.tencent.liteav.txcvodplayer.TXCVodVideoView.7
            @Override // com.tencent.liteav.txcplayer.ITXVCubePlayer.l
            public final void a(ITXVCubePlayer iTXVCubePlayer, int i, int i2, String str) {
                boolean z = (TXCVodVideoView.this.l != i2 && Math.abs(TXCVodVideoView.this.l - i2) > 16) || (TXCVodVideoView.this.k != i && Math.abs(TXCVodVideoView.this.k - i) > 16);
                TXCVodVideoView.this.k = iTXVCubePlayer.getVideoWidth();
                TXCVodVideoView.this.l = iTXVCubePlayer.getVideoHeight();
                TXCVodVideoView.this.y = iTXVCubePlayer.getVideoSarNum();
                TXCVodVideoView.this.z = iTXVCubePlayer.getVideoSarDen();
                LiteavLog.i("TXCVodVideoView", "OnVideoSizeChangedListener width:" + TXCVodVideoView.this.k + ":height:" + TXCVodVideoView.this.l + ":SarNum:" + TXCVodVideoView.this.y + ":SarDen:" + TXCVodVideoView.this.z);
                if (TXCVodVideoView.this.k != 0 && TXCVodVideoView.this.l != 0) {
                    if (TXCVodVideoView.this.x != null) {
                        TXCVodVideoView.this.x.a(TXCVodVideoView.this.k, TXCVodVideoView.this.l);
                        TXCVodVideoView.this.x.b(TXCVodVideoView.this.y, TXCVodVideoView.this.z);
                    }
                    TXCVodVideoView.this.requestLayout();
                }
                if (!z) {
                    if (TXCVodVideoView.this.t || str == null) {
                        return;
                    }
                    Message message = new Message();
                    message.what = 101;
                    message.arg1 = 2009;
                    Bundle bundle = new Bundle();
                    String str2 = i + "," + i2 + "," + str;
                    bundle.putString("description", "Resolution change:" + TXCVodVideoView.this.k + PhoneConstants.APN_TYPE_ALL + TXCVodVideoView.this.l + " Crop(width,height,crop_left,crop_top,crop_right,crop_bottom):(" + str2 + ")");
                    bundle.putInt("EVT_PARAM1", TXCVodVideoView.this.k);
                    bundle.putInt("EVT_PARAM2", TXCVodVideoView.this.l);
                    bundle.putString("EVT_PARAM3", str2);
                    message.setData(bundle);
                    if (TXCVodVideoView.this.V != null) {
                        TXCVodVideoView.this.V.sendMessage(message);
                        return;
                    }
                    return;
                }
                Message message2 = new Message();
                message2.what = 101;
                message2.arg1 = 2009;
                Bundle bundle2 = new Bundle();
                bundle2.putInt("EVT_PARAM1", TXCVodVideoView.this.k);
                bundle2.putInt("EVT_PARAM2", TXCVodVideoView.this.l);
                if (TXCVodVideoView.this.t || str == null) {
                    bundle2.putString("description", "Resolution change:" + TXCVodVideoView.this.k + PhoneConstants.APN_TYPE_ALL + TXCVodVideoView.this.l);
                } else if (str != null) {
                    String str3 = i + "," + i2 + "," + str;
                    bundle2.putString("description", "Resolution change:" + TXCVodVideoView.this.k + PhoneConstants.APN_TYPE_ALL + TXCVodVideoView.this.l + " Crop(width,height,crop_left,crop_top,crop_right,crop_bottom):(" + str3 + ")");
                    bundle2.putString("EVT_PARAM3", str3);
                }
                message2.setData(bundle2);
                if (TXCVodVideoView.this.V != null) {
                    TXCVodVideoView.this.V.sendMessage(message2);
                }
            }
        };
        this.h = new ITXVCubePlayer.h() { // from class: com.tencent.liteav.txcvodplayer.TXCVodVideoView.8
            @Override // com.tencent.liteav.txcplayer.ITXVCubePlayer.h
            public final void a(ITXVCubePlayer iTXVCubePlayer) {
                if (RenderProcessService.getInstance().setSurfaceBufferSize(iTXVCubePlayer)) {
                    LiteavLog.i("TXCVodVideoView", "setSurfaceBufferSize succeed");
                }
                if (TXCVodVideoView.this.f36490a == 1) {
                    TXCVodVideoView.this.a(2013, "VOD ready", "prepared");
                    if (!TXCVodVideoView.this.v.p) {
                        TXCVodVideoView.this.b = 4;
                    } else if (TXCVodVideoView.this.b != 4) {
                        TXCVodVideoView.this.b = 3;
                    }
                    TXCVodVideoView.this.f36490a = 2;
                }
                TXCVodVideoView.k(TXCVodVideoView.this);
                if (TXCVodVideoView.this.f36490a == -1) {
                    TXCVodVideoView.this.f36490a = 3;
                    TXCVodVideoView.this.b = 3;
                }
                if (TXCVodVideoView.this.V != null) {
                    TXCVodVideoView.this.V.sendEmptyMessage(100);
                    TXCVodVideoView.this.V.sendEmptyMessage(103);
                }
                TXCVodVideoView.this.k = iTXVCubePlayer.getVideoWidth();
                TXCVodVideoView.this.l = iTXVCubePlayer.getVideoHeight();
                if (TXCVodVideoView.this.k != 0 && TXCVodVideoView.this.l != 0 && TXCVodVideoView.this.x != null) {
                    TXCVodVideoView.this.x.a(TXCVodVideoView.this.k, TXCVodVideoView.this.l);
                    TXCVodVideoView.this.x.b(TXCVodVideoView.this.y, TXCVodVideoView.this.z);
                }
                if (TXCVodVideoView.this.b == 3) {
                    TXCVodVideoView.this.a();
                }
            }
        };
        this.K = new ITXVCubePlayer.c() { // from class: com.tencent.liteav.txcvodplayer.TXCVodVideoView.9
            @Override // com.tencent.liteav.txcplayer.ITXVCubePlayer.c
            public final void a() {
                TXCVodVideoView.this.f36490a = 5;
                TXCVodVideoView.this.b = 5;
                TXCVodVideoView.this.a(2006, "Playback completed", "play end");
            }
        };
        this.L = new ITXVCubePlayer.g() { // from class: com.tencent.liteav.txcvodplayer.TXCVodVideoView.10
            @Override // com.tencent.liteav.txcplayer.ITXVCubePlayer.g
            public final boolean a(int i, int i2, int i3, Object obj) {
                if (i == 1006) {
                    if (TextUtils.isEmpty(TXCVodVideoView.this.A) && obj != null && (obj instanceof TPPlayerMsg.TPDownLoadProgressInfo)) {
                        try {
                            TXCVodVideoView.this.A = new JSONObject(((TPPlayerMsg.TPDownLoadProgressInfo) obj).extraInfo).optString("cdnip");
                            return true;
                        } catch (Exception e) {
                            e.printStackTrace();
                            return true;
                        }
                    }
                    return true;
                } else if (i == 2003) {
                    LiteavLog.i("TXCVodVideoView", "EVT_RENDER_FIRST_I_FRAME");
                    TXCVodVideoView.this.a(i, "VOD displayed the first frame", "render start");
                    TXCVodVideoView tXCVodVideoView = TXCVodVideoView.this;
                    tXCVodVideoView.setRate(tXCVodVideoView.B);
                    TXCVodVideoView.m(TXCVodVideoView.this);
                    return true;
                } else if (i == 2007) {
                    LiteavLog.i("TXCVodVideoView", "EVT_VIDEO_PLAY_LOADING");
                    TXCVodVideoView.this.a(i, "Buffer started", "loading start");
                    return true;
                } else if (i == 2011) {
                    LiteavLog.i("TXCVodVideoView", "EVT_VIDEO_CHANGE_ROTATION: ".concat(String.valueOf(i2)));
                    TXCVodVideoView.this.p = i2;
                    if (TXCVodVideoView.this.v.y && TXCVodVideoView.this.p > 0) {
                        TXCVodVideoView tXCVodVideoView2 = TXCVodVideoView.this;
                        tXCVodVideoView2.o = tXCVodVideoView2.p;
                        if (TXCVodVideoView.this.x != null) {
                            TXCVodVideoView.this.x.setVideoRotation(TXCVodVideoView.this.o);
                        }
                    }
                    TXCVodVideoView.this.a(2011, "Video angle " + TXCVodVideoView.this.p, "rotation " + TXCVodVideoView.this.p);
                    return true;
                } else if (i == 2014) {
                    LiteavLog.i("TXCVodVideoView", "EVT_VOD_PLAY_LOADING_END: eof ".concat(String.valueOf(i2)));
                    TXCVodVideoView.this.a(i, "Buffer ended", "loading end");
                    if (i2 != 0) {
                        String str = TXCVodVideoView.this.v.q;
                        if (TextUtils.isEmpty(str) && str.endsWith("m3u8")) {
                            return true;
                        }
                    }
                    if (TXCVodVideoView.this.b == 3) {
                        TXCVodVideoView.this.a(2004, "Playback started", "playing");
                        TXCVodVideoView.this.f36490a = 3;
                        TXCVodVideoView.this.V.sendEmptyMessage(100);
                        TXCVodVideoView.this.V.sendEmptyMessage(103);
                        return true;
                    }
                    return true;
                } else if (i == 2026) {
                    LiteavLog.i("TXCVodVideoView", "EVT_AUDIO_JITTER_STATE_FIRST_PLAY");
                    TXCVodVideoView.this.a(i, "Audio first play", "audio start");
                    return true;
                } else {
                    switch (i) {
                        case 2016:
                            if (obj != null && (obj instanceof String)) {
                                TXCVodVideoView.this.A = (String) obj;
                            }
                            String str2 = "TCP Connect ServerIp:" + TXCVodVideoView.this.A + ",port:" + i2 + ",error:" + i3;
                            LiteavLog.i("TXCVodVideoView", str2);
                            if (i3 == 0) {
                                TXCVodVideoView.this.a(i, str2, "tcp open");
                                return true;
                            }
                            return true;
                        case 2017:
                            TXCVodVideoView.this.a(i, "Video data received", "first video packet");
                            return true;
                        case 2018:
                            String str3 = null;
                            if (obj != null) {
                                str3 = null;
                                if (obj instanceof String) {
                                    str3 = (String) obj;
                                }
                            }
                            String str4 = "dns resolved url:" + str3 + ",error:" + i2;
                            LiteavLog.i("TXCVodVideoView", str4);
                            if (i2 == 0) {
                                TXCVodVideoView.this.a(i, str4, "dns resolved");
                                return true;
                            }
                            return true;
                        default:
                            return true;
                    }
                }
            }
        };
        this.N = new ITXVCubePlayer.d() { // from class: com.tencent.liteav.txcvodplayer.TXCVodVideoView.11
            @Override // com.tencent.liteav.txcplayer.ITXVCubePlayer.d
            public final boolean a(int i, int i2) {
                LiteavLog.e("TXCVodVideoView", "onError: " + i + "," + i2);
                TXCVodVideoView.this.f36490a = -1;
                TXCVodVideoView.this.b = -1;
                if (i == -1010 || i == -1007 || i == -1004 || i == 200) {
                    if (i2 == -2303) {
                        TXCVodVideoView.this.a(i2, "The file does not exist", "file not exist");
                    } else {
                        TXCVodVideoView.this.a(-2301, "Disconnected from the network. Playback error", "disconnect");
                    }
                    TXCVodVideoView.this.b();
                    return true;
                }
                if (TXCVodVideoView.this.C != TXCVodVideoView.this.getCurrentPosition()) {
                    TXCVodVideoView.r(TXCVodVideoView.this);
                }
                TXCVodVideoView tXCVodVideoView = TXCVodVideoView.this;
                tXCVodVideoView.C = tXCVodVideoView.getCurrentPosition();
                if (TXCVodVideoView.s(TXCVodVideoView.this) >= TXCVodVideoView.this.v.f36487a) {
                    TXCVodVideoView.this.a(-2301, "Disconnected from the network. Playback error", "disconnect");
                    TXCVodVideoView.this.b();
                    return true;
                } else if (TXCVodVideoView.this.V != null) {
                    TXCVodVideoView.this.V.sendEmptyMessageDelayed(102, TXCVodVideoView.this.v.b * 1000.0f);
                    return true;
                } else {
                    return true;
                }
            }
        };
        this.O = new ITXVCubePlayer.f() { // from class: com.tencent.liteav.txcvodplayer.TXCVodVideoView.12
            @Override // com.tencent.liteav.txcplayer.ITXVCubePlayer.f
            public final void a() {
                LiteavLog.d("TXCVodVideoView", "onHevcVideoDecoderError");
                TXCVodVideoView.this.a(-2304, "Vod H265 decoding failed", "hevc decode fail");
            }
        };
        this.P = new ITXVCubePlayer.k() { // from class: com.tencent.liteav.txcvodplayer.TXCVodVideoView.13
            @Override // com.tencent.liteav.txcplayer.ITXVCubePlayer.k
            public final void a() {
                LiteavLog.d("TXCVodVideoView", "onVideoDecoderError");
                if (TXCVodVideoView.this.f36490a != 4) {
                    TXCVodVideoView.this.a(2106, "VOD decoding failed", "decode fail");
                }
                if (TXCVodVideoView.this.J || !TXCVodVideoView.this.v.d || Math.min(TXCVodVideoView.this.l, TXCVodVideoView.this.k) >= 1080 || !TXCVodVideoView.this.v.d) {
                    return;
                }
                TXCVodVideoView.this.v.d = false;
                TXCVodVideoView.this.c(false);
            }
        };
        this.Q = new ITXVCubePlayer.i() { // from class: com.tencent.liteav.txcvodplayer.TXCVodVideoView.2
            @Override // com.tencent.liteav.txcplayer.ITXVCubePlayer.i
            public final void a() {
                LiteavLog.v("TXCVodVideoView", "seek complete");
                TXCVodVideoView.v(TXCVodVideoView.this);
                TXCVodVideoView.this.a(2019, "seek complete", null);
            }
        };
        this.R = new ITXVCubePlayer.j() { // from class: com.tencent.liteav.txcvodplayer.TXCVodVideoView.3
        };
        this.S = new ITXVCubePlayer.e() { // from class: com.tencent.liteav.txcvodplayer.TXCVodVideoView.4
            @Override // com.tencent.liteav.txcplayer.ITXVCubePlayer.e
            public final void a() {
                LiteavLog.e("TXCVodVideoView", "onHLSKeyError");
                TXCVodVideoView.this.a(-2305, "HLS decypt key get failed", "hls key error");
                if (TXCVodVideoView.this.f36491c != null) {
                    try {
                        TXCVodVideoView.this.f36491c.stop();
                    } catch (Exception e) {
                        LiteavLog.e("TXCVodVideoView", "onHLSKeyError stop Exception: " + e.getMessage());
                    }
                    TXCVodVideoView.this.f36491c.release();
                    TXCVodVideoView.x(TXCVodVideoView.this);
                }
                TXCVodVideoView.this.f36490a = -1;
                TXCVodVideoView.this.b = -1;
            }
        };
        this.i = new a.InterfaceC0935a() { // from class: com.tencent.liteav.txcvodplayer.TXCVodVideoView.5
            @Override // com.tencent.liteav.txcvodplayer.renderer.a.InterfaceC0935a
            public final void a(a.b bVar) {
                if (bVar.a() != TXCVodVideoView.this.x) {
                    LiteavLog.e("TXCVodVideoView", "onSurfaceCreated: unmatched render callback\n");
                    return;
                }
                LiteavLog.i("TXCVodVideoView", "onSurfaceCreated");
                TXCVodVideoView.this.t = true;
                TXCVodVideoView.this.j = bVar;
                if (TXCVodVideoView.this.f36491c != null) {
                    TXCVodVideoView.b(TXCVodVideoView.this.f36491c, bVar);
                } else {
                    TXCVodVideoView.this.e();
                }
            }

            @Override // com.tencent.liteav.txcvodplayer.renderer.a.InterfaceC0935a
            public final void a(a.b bVar, int i, int i2) {
                if (bVar.a() != TXCVodVideoView.this.x) {
                    LiteavLog.e("TXCVodVideoView", "onSurfaceChanged: unmatched render callback\n");
                    return;
                }
                LiteavLog.i("TXCVodVideoView", "onSurfaceChanged");
                TXCVodVideoView.this.m = i;
                TXCVodVideoView.this.n = i2;
                boolean z = TXCVodVideoView.this.b == 3;
                boolean z2 = true;
                if (TXCVodVideoView.this.x.a()) {
                    z2 = TXCVodVideoView.this.k == i && TXCVodVideoView.this.l == i2;
                }
                if (TXCVodVideoView.this.f36491c != null && z && z2 && TXCVodVideoView.this.b == 3) {
                    TXCVodVideoView.this.a();
                }
            }

            @Override // com.tencent.liteav.txcvodplayer.renderer.a.InterfaceC0935a
            public final void b(a.b bVar) {
                if (bVar.a() != TXCVodVideoView.this.x) {
                    LiteavLog.e("TXCVodVideoView", "onSurfaceDestroyed: unmatched render callback\n");
                    return;
                }
                LiteavLog.i("TXCVodVideoView", "onSurfaceDestroyed");
                TXCVodVideoView.this.t = false;
                TXCVodVideoView.this.j = null;
                if (TXCVodVideoView.this.f36491c != null) {
                    TXCVodVideoView.this.f36491c.setSurface(null);
                }
                TXCVodVideoView tXCVodVideoView = TXCVodVideoView.this;
                if (tXCVodVideoView.f36491c != null) {
                    tXCVodVideoView.f36491c.setDisplay(null);
                }
            }
        };
        this.T = 0;
        this.W = false;
        a(context);
    }

    public TXCVodVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f36490a = 0;
        this.b = 0;
        this.j = null;
        this.f36491c = null;
        this.t = false;
        this.B = 1.0f;
        this.d = true;
        this.e = 2;
        this.D = false;
        this.E = -1;
        this.F = 100;
        this.G = false;
        this.H = -1000;
        this.I = -1;
        this.f = null;
        this.g = new ITXVCubePlayer.l() { // from class: com.tencent.liteav.txcvodplayer.TXCVodVideoView.7
            @Override // com.tencent.liteav.txcplayer.ITXVCubePlayer.l
            public final void a(ITXVCubePlayer iTXVCubePlayer, int i2, int i22, String str) {
                boolean z = (TXCVodVideoView.this.l != i22 && Math.abs(TXCVodVideoView.this.l - i22) > 16) || (TXCVodVideoView.this.k != i2 && Math.abs(TXCVodVideoView.this.k - i2) > 16);
                TXCVodVideoView.this.k = iTXVCubePlayer.getVideoWidth();
                TXCVodVideoView.this.l = iTXVCubePlayer.getVideoHeight();
                TXCVodVideoView.this.y = iTXVCubePlayer.getVideoSarNum();
                TXCVodVideoView.this.z = iTXVCubePlayer.getVideoSarDen();
                LiteavLog.i("TXCVodVideoView", "OnVideoSizeChangedListener width:" + TXCVodVideoView.this.k + ":height:" + TXCVodVideoView.this.l + ":SarNum:" + TXCVodVideoView.this.y + ":SarDen:" + TXCVodVideoView.this.z);
                if (TXCVodVideoView.this.k != 0 && TXCVodVideoView.this.l != 0) {
                    if (TXCVodVideoView.this.x != null) {
                        TXCVodVideoView.this.x.a(TXCVodVideoView.this.k, TXCVodVideoView.this.l);
                        TXCVodVideoView.this.x.b(TXCVodVideoView.this.y, TXCVodVideoView.this.z);
                    }
                    TXCVodVideoView.this.requestLayout();
                }
                if (!z) {
                    if (TXCVodVideoView.this.t || str == null) {
                        return;
                    }
                    Message message = new Message();
                    message.what = 101;
                    message.arg1 = 2009;
                    Bundle bundle = new Bundle();
                    String str2 = i2 + "," + i22 + "," + str;
                    bundle.putString("description", "Resolution change:" + TXCVodVideoView.this.k + PhoneConstants.APN_TYPE_ALL + TXCVodVideoView.this.l + " Crop(width,height,crop_left,crop_top,crop_right,crop_bottom):(" + str2 + ")");
                    bundle.putInt("EVT_PARAM1", TXCVodVideoView.this.k);
                    bundle.putInt("EVT_PARAM2", TXCVodVideoView.this.l);
                    bundle.putString("EVT_PARAM3", str2);
                    message.setData(bundle);
                    if (TXCVodVideoView.this.V != null) {
                        TXCVodVideoView.this.V.sendMessage(message);
                        return;
                    }
                    return;
                }
                Message message2 = new Message();
                message2.what = 101;
                message2.arg1 = 2009;
                Bundle bundle2 = new Bundle();
                bundle2.putInt("EVT_PARAM1", TXCVodVideoView.this.k);
                bundle2.putInt("EVT_PARAM2", TXCVodVideoView.this.l);
                if (TXCVodVideoView.this.t || str == null) {
                    bundle2.putString("description", "Resolution change:" + TXCVodVideoView.this.k + PhoneConstants.APN_TYPE_ALL + TXCVodVideoView.this.l);
                } else if (str != null) {
                    String str3 = i2 + "," + i22 + "," + str;
                    bundle2.putString("description", "Resolution change:" + TXCVodVideoView.this.k + PhoneConstants.APN_TYPE_ALL + TXCVodVideoView.this.l + " Crop(width,height,crop_left,crop_top,crop_right,crop_bottom):(" + str3 + ")");
                    bundle2.putString("EVT_PARAM3", str3);
                }
                message2.setData(bundle2);
                if (TXCVodVideoView.this.V != null) {
                    TXCVodVideoView.this.V.sendMessage(message2);
                }
            }
        };
        this.h = new ITXVCubePlayer.h() { // from class: com.tencent.liteav.txcvodplayer.TXCVodVideoView.8
            @Override // com.tencent.liteav.txcplayer.ITXVCubePlayer.h
            public final void a(ITXVCubePlayer iTXVCubePlayer) {
                if (RenderProcessService.getInstance().setSurfaceBufferSize(iTXVCubePlayer)) {
                    LiteavLog.i("TXCVodVideoView", "setSurfaceBufferSize succeed");
                }
                if (TXCVodVideoView.this.f36490a == 1) {
                    TXCVodVideoView.this.a(2013, "VOD ready", "prepared");
                    if (!TXCVodVideoView.this.v.p) {
                        TXCVodVideoView.this.b = 4;
                    } else if (TXCVodVideoView.this.b != 4) {
                        TXCVodVideoView.this.b = 3;
                    }
                    TXCVodVideoView.this.f36490a = 2;
                }
                TXCVodVideoView.k(TXCVodVideoView.this);
                if (TXCVodVideoView.this.f36490a == -1) {
                    TXCVodVideoView.this.f36490a = 3;
                    TXCVodVideoView.this.b = 3;
                }
                if (TXCVodVideoView.this.V != null) {
                    TXCVodVideoView.this.V.sendEmptyMessage(100);
                    TXCVodVideoView.this.V.sendEmptyMessage(103);
                }
                TXCVodVideoView.this.k = iTXVCubePlayer.getVideoWidth();
                TXCVodVideoView.this.l = iTXVCubePlayer.getVideoHeight();
                if (TXCVodVideoView.this.k != 0 && TXCVodVideoView.this.l != 0 && TXCVodVideoView.this.x != null) {
                    TXCVodVideoView.this.x.a(TXCVodVideoView.this.k, TXCVodVideoView.this.l);
                    TXCVodVideoView.this.x.b(TXCVodVideoView.this.y, TXCVodVideoView.this.z);
                }
                if (TXCVodVideoView.this.b == 3) {
                    TXCVodVideoView.this.a();
                }
            }
        };
        this.K = new ITXVCubePlayer.c() { // from class: com.tencent.liteav.txcvodplayer.TXCVodVideoView.9
            @Override // com.tencent.liteav.txcplayer.ITXVCubePlayer.c
            public final void a() {
                TXCVodVideoView.this.f36490a = 5;
                TXCVodVideoView.this.b = 5;
                TXCVodVideoView.this.a(2006, "Playback completed", "play end");
            }
        };
        this.L = new ITXVCubePlayer.g() { // from class: com.tencent.liteav.txcvodplayer.TXCVodVideoView.10
            @Override // com.tencent.liteav.txcplayer.ITXVCubePlayer.g
            public final boolean a(int i2, int i22, int i3, Object obj) {
                if (i2 == 1006) {
                    if (TextUtils.isEmpty(TXCVodVideoView.this.A) && obj != null && (obj instanceof TPPlayerMsg.TPDownLoadProgressInfo)) {
                        try {
                            TXCVodVideoView.this.A = new JSONObject(((TPPlayerMsg.TPDownLoadProgressInfo) obj).extraInfo).optString("cdnip");
                            return true;
                        } catch (Exception e) {
                            e.printStackTrace();
                            return true;
                        }
                    }
                    return true;
                } else if (i2 == 2003) {
                    LiteavLog.i("TXCVodVideoView", "EVT_RENDER_FIRST_I_FRAME");
                    TXCVodVideoView.this.a(i2, "VOD displayed the first frame", "render start");
                    TXCVodVideoView tXCVodVideoView = TXCVodVideoView.this;
                    tXCVodVideoView.setRate(tXCVodVideoView.B);
                    TXCVodVideoView.m(TXCVodVideoView.this);
                    return true;
                } else if (i2 == 2007) {
                    LiteavLog.i("TXCVodVideoView", "EVT_VIDEO_PLAY_LOADING");
                    TXCVodVideoView.this.a(i2, "Buffer started", "loading start");
                    return true;
                } else if (i2 == 2011) {
                    LiteavLog.i("TXCVodVideoView", "EVT_VIDEO_CHANGE_ROTATION: ".concat(String.valueOf(i22)));
                    TXCVodVideoView.this.p = i22;
                    if (TXCVodVideoView.this.v.y && TXCVodVideoView.this.p > 0) {
                        TXCVodVideoView tXCVodVideoView2 = TXCVodVideoView.this;
                        tXCVodVideoView2.o = tXCVodVideoView2.p;
                        if (TXCVodVideoView.this.x != null) {
                            TXCVodVideoView.this.x.setVideoRotation(TXCVodVideoView.this.o);
                        }
                    }
                    TXCVodVideoView.this.a(2011, "Video angle " + TXCVodVideoView.this.p, "rotation " + TXCVodVideoView.this.p);
                    return true;
                } else if (i2 == 2014) {
                    LiteavLog.i("TXCVodVideoView", "EVT_VOD_PLAY_LOADING_END: eof ".concat(String.valueOf(i22)));
                    TXCVodVideoView.this.a(i2, "Buffer ended", "loading end");
                    if (i22 != 0) {
                        String str = TXCVodVideoView.this.v.q;
                        if (TextUtils.isEmpty(str) && str.endsWith("m3u8")) {
                            return true;
                        }
                    }
                    if (TXCVodVideoView.this.b == 3) {
                        TXCVodVideoView.this.a(2004, "Playback started", "playing");
                        TXCVodVideoView.this.f36490a = 3;
                        TXCVodVideoView.this.V.sendEmptyMessage(100);
                        TXCVodVideoView.this.V.sendEmptyMessage(103);
                        return true;
                    }
                    return true;
                } else if (i2 == 2026) {
                    LiteavLog.i("TXCVodVideoView", "EVT_AUDIO_JITTER_STATE_FIRST_PLAY");
                    TXCVodVideoView.this.a(i2, "Audio first play", "audio start");
                    return true;
                } else {
                    switch (i2) {
                        case 2016:
                            if (obj != null && (obj instanceof String)) {
                                TXCVodVideoView.this.A = (String) obj;
                            }
                            String str2 = "TCP Connect ServerIp:" + TXCVodVideoView.this.A + ",port:" + i22 + ",error:" + i3;
                            LiteavLog.i("TXCVodVideoView", str2);
                            if (i3 == 0) {
                                TXCVodVideoView.this.a(i2, str2, "tcp open");
                                return true;
                            }
                            return true;
                        case 2017:
                            TXCVodVideoView.this.a(i2, "Video data received", "first video packet");
                            return true;
                        case 2018:
                            String str3 = null;
                            if (obj != null) {
                                str3 = null;
                                if (obj instanceof String) {
                                    str3 = (String) obj;
                                }
                            }
                            String str4 = "dns resolved url:" + str3 + ",error:" + i22;
                            LiteavLog.i("TXCVodVideoView", str4);
                            if (i22 == 0) {
                                TXCVodVideoView.this.a(i2, str4, "dns resolved");
                                return true;
                            }
                            return true;
                        default:
                            return true;
                    }
                }
            }
        };
        this.N = new ITXVCubePlayer.d() { // from class: com.tencent.liteav.txcvodplayer.TXCVodVideoView.11
            @Override // com.tencent.liteav.txcplayer.ITXVCubePlayer.d
            public final boolean a(int i2, int i22) {
                LiteavLog.e("TXCVodVideoView", "onError: " + i2 + "," + i22);
                TXCVodVideoView.this.f36490a = -1;
                TXCVodVideoView.this.b = -1;
                if (i2 == -1010 || i2 == -1007 || i2 == -1004 || i2 == 200) {
                    if (i22 == -2303) {
                        TXCVodVideoView.this.a(i22, "The file does not exist", "file not exist");
                    } else {
                        TXCVodVideoView.this.a(-2301, "Disconnected from the network. Playback error", "disconnect");
                    }
                    TXCVodVideoView.this.b();
                    return true;
                }
                if (TXCVodVideoView.this.C != TXCVodVideoView.this.getCurrentPosition()) {
                    TXCVodVideoView.r(TXCVodVideoView.this);
                }
                TXCVodVideoView tXCVodVideoView = TXCVodVideoView.this;
                tXCVodVideoView.C = tXCVodVideoView.getCurrentPosition();
                if (TXCVodVideoView.s(TXCVodVideoView.this) >= TXCVodVideoView.this.v.f36487a) {
                    TXCVodVideoView.this.a(-2301, "Disconnected from the network. Playback error", "disconnect");
                    TXCVodVideoView.this.b();
                    return true;
                } else if (TXCVodVideoView.this.V != null) {
                    TXCVodVideoView.this.V.sendEmptyMessageDelayed(102, TXCVodVideoView.this.v.b * 1000.0f);
                    return true;
                } else {
                    return true;
                }
            }
        };
        this.O = new ITXVCubePlayer.f() { // from class: com.tencent.liteav.txcvodplayer.TXCVodVideoView.12
            @Override // com.tencent.liteav.txcplayer.ITXVCubePlayer.f
            public final void a() {
                LiteavLog.d("TXCVodVideoView", "onHevcVideoDecoderError");
                TXCVodVideoView.this.a(-2304, "Vod H265 decoding failed", "hevc decode fail");
            }
        };
        this.P = new ITXVCubePlayer.k() { // from class: com.tencent.liteav.txcvodplayer.TXCVodVideoView.13
            @Override // com.tencent.liteav.txcplayer.ITXVCubePlayer.k
            public final void a() {
                LiteavLog.d("TXCVodVideoView", "onVideoDecoderError");
                if (TXCVodVideoView.this.f36490a != 4) {
                    TXCVodVideoView.this.a(2106, "VOD decoding failed", "decode fail");
                }
                if (TXCVodVideoView.this.J || !TXCVodVideoView.this.v.d || Math.min(TXCVodVideoView.this.l, TXCVodVideoView.this.k) >= 1080 || !TXCVodVideoView.this.v.d) {
                    return;
                }
                TXCVodVideoView.this.v.d = false;
                TXCVodVideoView.this.c(false);
            }
        };
        this.Q = new ITXVCubePlayer.i() { // from class: com.tencent.liteav.txcvodplayer.TXCVodVideoView.2
            @Override // com.tencent.liteav.txcplayer.ITXVCubePlayer.i
            public final void a() {
                LiteavLog.v("TXCVodVideoView", "seek complete");
                TXCVodVideoView.v(TXCVodVideoView.this);
                TXCVodVideoView.this.a(2019, "seek complete", null);
            }
        };
        this.R = new ITXVCubePlayer.j() { // from class: com.tencent.liteav.txcvodplayer.TXCVodVideoView.3
        };
        this.S = new ITXVCubePlayer.e() { // from class: com.tencent.liteav.txcvodplayer.TXCVodVideoView.4
            @Override // com.tencent.liteav.txcplayer.ITXVCubePlayer.e
            public final void a() {
                LiteavLog.e("TXCVodVideoView", "onHLSKeyError");
                TXCVodVideoView.this.a(-2305, "HLS decypt key get failed", "hls key error");
                if (TXCVodVideoView.this.f36491c != null) {
                    try {
                        TXCVodVideoView.this.f36491c.stop();
                    } catch (Exception e) {
                        LiteavLog.e("TXCVodVideoView", "onHLSKeyError stop Exception: " + e.getMessage());
                    }
                    TXCVodVideoView.this.f36491c.release();
                    TXCVodVideoView.x(TXCVodVideoView.this);
                }
                TXCVodVideoView.this.f36490a = -1;
                TXCVodVideoView.this.b = -1;
            }
        };
        this.i = new a.InterfaceC0935a() { // from class: com.tencent.liteav.txcvodplayer.TXCVodVideoView.5
            @Override // com.tencent.liteav.txcvodplayer.renderer.a.InterfaceC0935a
            public final void a(a.b bVar) {
                if (bVar.a() != TXCVodVideoView.this.x) {
                    LiteavLog.e("TXCVodVideoView", "onSurfaceCreated: unmatched render callback\n");
                    return;
                }
                LiteavLog.i("TXCVodVideoView", "onSurfaceCreated");
                TXCVodVideoView.this.t = true;
                TXCVodVideoView.this.j = bVar;
                if (TXCVodVideoView.this.f36491c != null) {
                    TXCVodVideoView.b(TXCVodVideoView.this.f36491c, bVar);
                } else {
                    TXCVodVideoView.this.e();
                }
            }

            @Override // com.tencent.liteav.txcvodplayer.renderer.a.InterfaceC0935a
            public final void a(a.b bVar, int i2, int i22) {
                if (bVar.a() != TXCVodVideoView.this.x) {
                    LiteavLog.e("TXCVodVideoView", "onSurfaceChanged: unmatched render callback\n");
                    return;
                }
                LiteavLog.i("TXCVodVideoView", "onSurfaceChanged");
                TXCVodVideoView.this.m = i2;
                TXCVodVideoView.this.n = i22;
                boolean z = TXCVodVideoView.this.b == 3;
                boolean z2 = true;
                if (TXCVodVideoView.this.x.a()) {
                    z2 = TXCVodVideoView.this.k == i2 && TXCVodVideoView.this.l == i22;
                }
                if (TXCVodVideoView.this.f36491c != null && z && z2 && TXCVodVideoView.this.b == 3) {
                    TXCVodVideoView.this.a();
                }
            }

            @Override // com.tencent.liteav.txcvodplayer.renderer.a.InterfaceC0935a
            public final void b(a.b bVar) {
                if (bVar.a() != TXCVodVideoView.this.x) {
                    LiteavLog.e("TXCVodVideoView", "onSurfaceDestroyed: unmatched render callback\n");
                    return;
                }
                LiteavLog.i("TXCVodVideoView", "onSurfaceDestroyed");
                TXCVodVideoView.this.t = false;
                TXCVodVideoView.this.j = null;
                if (TXCVodVideoView.this.f36491c != null) {
                    TXCVodVideoView.this.f36491c.setSurface(null);
                }
                TXCVodVideoView tXCVodVideoView = TXCVodVideoView.this;
                if (tXCVodVideoView.f36491c != null) {
                    tXCVodVideoView.f36491c.setDisplay(null);
                }
            }
        };
        this.T = 0;
        this.W = false;
        a(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str, String str2) {
        if ((i == -2304 || i == 2106) && this.W) {
            return;
        }
        Message message = new Message();
        message.what = 101;
        Bundle bundle = new Bundle();
        message.arg1 = i;
        bundle.putString("description", str);
        message.setData(bundle);
        Handler handler = this.V;
        if (handler != null) {
            handler.sendMessage(message);
        }
        if (i != 2018 && i != 2016) {
            LiteavLog.i("TXCVodVideoView", "sendSimpleEvent " + i + " " + str2 + " vod=" + hashCode());
        }
        this.W = i == -2304 || i == 2106;
    }

    private void a(Context context) {
        this.u = context.getApplicationContext();
        this.v = new e();
        setRender(0);
        this.k = 0;
        this.l = 0;
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
        this.f36490a = 0;
        this.b = 0;
        Looper mainLooper = Looper.getMainLooper();
        if (mainLooper != null) {
            this.V = new a(this, mainLooper);
        } else {
            this.V = null;
        }
    }

    private static void a(ITXVCubePlayer iTXVCubePlayer) {
        if (iTXVCubePlayer != null) {
            RenderProcessService.getInstance().stopRenderProcess(iTXVCubePlayer);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(ITXVCubePlayer iTXVCubePlayer, a.b bVar) {
        if (iTXVCubePlayer == null) {
            return;
        }
        if (bVar == null) {
            iTXVCubePlayer.setDisplay(null);
            return;
        }
        LiteavLog.i("TXCVodVideoView", "bindSurfaceHolder");
        Surface c2 = bVar.c();
        Surface surface = c2;
        if (c2 == null) {
            surface = bVar.b();
        }
        if (RenderProcessService.getInstance().connectPlayer(iTXVCubePlayer, surface)) {
            return;
        }
        bVar.a(iTXVCubePlayer);
    }

    private void b(boolean z) {
        if (this.f36491c != null) {
            LiteavLog.i("TXCVodVideoView", "release player " + this.f36491c);
            a(this.f36491c);
            this.f36491c.release();
            f();
            this.f36491c = null;
            this.f36490a = 0;
            this.D = false;
            this.E = -1;
            if (z) {
                this.b = 0;
                this.k = 0;
                this.l = 0;
                this.B = 1.0f;
                this.J = false;
                this.H = -1000;
            }
            if (this.d && LiteavSystemInfo.getSystemOSVersionInt() >= 8) {
                ((AudioManager) this.u.getSystemService("audio")).abandonAudioFocus(null);
            }
            this.D = false;
            this.E = -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:18:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void c(boolean r6) {
        /*
            r5 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r0
            java.lang.String r2 = "replay, isFromErrorState = "
            r1.<init>(r2)
            r10 = r0
            r0 = r10
            r1 = r6
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r10
            java.lang.String r1 = " vod="
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r10
            r1 = r5
            int r1 = r1.hashCode()
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = "TXCVodVideoView"
            r1 = r10
            java.lang.String r1 = r1.toString()
            com.tencent.liteav.base.util.LiteavLog.i(r0, r1)
            r0 = r6
            if (r0 == 0) goto L47
            r0 = r5
            long r0 = r0.q
            r8 = r0
            r0 = r8
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 <= 0) goto L47
            r0 = r5
            r1 = r8
            r0.r = r1
            goto L83
        L47:
            r0 = r5
            long r0 = r0.r
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 != 0) goto L83
            r0 = r5
            com.tencent.liteav.txcplayer.ITXVCubePlayer r0 = r0.f36491c
            r10 = r0
            r0 = r10
            if (r0 == 0) goto L83
            r0 = r5
            int r0 = r0.s
            if (r0 <= 0) goto L83
            r0 = r10
            long r0 = r0.getCurrentPosition()
            int r0 = (int) r0
            long r0 = (long) r0
            r8 = r0
            r0 = r5
            r1 = r8
            r0.r = r1
            r0 = r5
            int r0 = r0.E
            r7 = r0
            r0 = r8
            r1 = r7
            long r1 = (long) r1
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 >= 0) goto L83
            r0 = r5
            r1 = r7
            long r1 = (long) r1
            r0.r = r1
        L83:
            r0 = r5
            boolean r0 = r0.e()
            if (r0 != 0) goto L8f
            r0 = r5
            r1 = 0
            r0.b(r1)
        L8f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.txcvodplayer.TXCVodVideoView.c(boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean e() {
        LiteavLog.i("TXCVodVideoView", "openVideo vod=" + hashCode());
        if (TextUtils.isEmpty(this.v.q)) {
            return false;
        }
        b(false);
        if (this.d) {
            ((AudioManager) this.u.getSystemService("audio")).requestAudioFocus(null, 3, 2);
        }
        try {
            ITXVCubePlayer a2 = f.a(this.u);
            this.f36491c = a2;
            if (this.f != null && a2 != null) {
                a2.attachTRTC(this.f);
            }
            String str = this.v.q;
            if (str.startsWith(BridgeUtil.SPLIT_MARK)) {
                if (!new File(str.contains(".hls") ? str.substring(0, str.indexOf(".hls") + 4) : str).exists()) {
                    throw new FileNotFoundException();
                }
            }
            this.v.o = this.r;
            if (this.I >= 0) {
                this.v.r = this.I;
            }
            if (this.H == -1) {
                this.v.w = true;
            } else {
                this.v.w = false;
            }
            if (this.H == -1) {
                this.f36491c.enableAdaptiveBitrate();
            } else if (this.H != -1000) {
                this.f36491c.setBitrateIndex(this.H);
            }
            this.f36491c.setConfig(this.v);
            this.f36491c.setPrivateConfig(this.w);
            if (this.v.h != null) {
                this.f36491c.setDataSource(this.u, Uri.parse(str), this.v.h);
            } else {
                this.f36491c.setDataSource(str);
            }
            this.f36491c.setOnPreparedListener(this.h);
            this.f36491c.setOnVideoSizeChangedListener(this.g);
            this.f36491c.setOnCompletionListener(this.K);
            this.f36491c.setOnErrorListener(this.N);
            this.f36491c.setOnInfoListener(this.L);
            this.f36491c.setOnSeekCompleteListener(this.Q);
            this.f36491c.setOnTimedTextListener(this.R);
            this.f36491c.setOnHLSKeyErrorListener(this.S);
            this.f36491c.setOnHevcVideoDecoderErrorListener(this.O);
            this.f36491c.setOnVideoDecoderErrorListener(this.P);
            this.f36491c.setOnGetTXCVodVideoViewTargetState(new ITXVCubePlayer.a() { // from class: com.tencent.liteav.txcvodplayer.TXCVodVideoView.6
                @Override // com.tencent.liteav.txcplayer.ITXVCubePlayer.a
                public final int a() {
                    return TXCVodVideoView.this.b;
                }
            });
            b(this.f36491c, this.j);
            this.f36491c.setAudioStreamType(3);
            this.f36491c.setScreenOnWhilePlaying(true);
            this.f36491c.prepareAsync();
            this.f36491c.setAudioVolume(this.F);
            setMute(this.G);
            this.f36490a = 1;
            return true;
        } catch (FileNotFoundException e) {
            this.f36490a = -1;
            this.b = -1;
            this.N.a(-1004, -2303);
            return true;
        } catch (Exception e2) {
            LiteavLog.w("TXCVodVideoView", e2.toString());
            this.f36490a = -1;
            this.b = -1;
            this.N.a(1, 0);
            return true;
        }
    }

    private void f() {
        ITXVCubePlayer iTXVCubePlayer = this.f36491c;
        if (iTXVCubePlayer != null) {
            iTXVCubePlayer.setOnPreparedListener(null);
            this.f36491c.setOnVideoSizeChangedListener(null);
            this.f36491c.setOnCompletionListener(null);
            this.f36491c.setOnErrorListener(null);
            this.f36491c.setOnInfoListener(null);
            this.f36491c.setOnBufferingUpdateListener(null);
            this.f36491c.setOnSeekCompleteListener(null);
            this.f36491c.setOnTimedTextListener(null);
            this.f36491c.setOnHLSKeyErrorListener(null);
            this.f36491c.setOnHevcVideoDecoderErrorListener(null);
            this.f36491c.setOnVideoDecoderErrorListener(null);
            this.f36491c.setOnGetTXCVodVideoViewTargetState(null);
        }
    }

    static /* synthetic */ long k(TXCVodVideoView tXCVodVideoView) {
        tXCVodVideoView.r = 0L;
        return 0L;
    }

    static /* synthetic */ boolean m(TXCVodVideoView tXCVodVideoView) {
        tXCVodVideoView.J = true;
        return true;
    }

    static /* synthetic */ int r(TXCVodVideoView tXCVodVideoView) {
        tXCVodVideoView.M = 0;
        return 0;
    }

    static /* synthetic */ int s(TXCVodVideoView tXCVodVideoView) {
        int i = tXCVodVideoView.M;
        tXCVodVideoView.M = i + 1;
        return i;
    }

    static /* synthetic */ boolean v(TXCVodVideoView tXCVodVideoView) {
        tXCVodVideoView.D = false;
        return false;
    }

    static /* synthetic */ ITXVCubePlayer x(TXCVodVideoView tXCVodVideoView) {
        tXCVodVideoView.f36491c = null;
        return null;
    }

    public final void a() {
        LiteavLog.i("TXCVodVideoView", "start vod=" + hashCode());
        if (c()) {
            try {
                if (this.f36490a != 3 && !this.D) {
                    this.f36490a = 3;
                    a(2004, "Playback started", "playing");
                    if (this.V != null) {
                        this.V.sendEmptyMessage(100);
                        this.V.sendEmptyMessage(103);
                    }
                }
                this.f36491c.start();
            } catch (Exception e) {
                LiteavLog.e("TXCVodVideoView", "start exception: " + e.getMessage());
            }
        }
        this.b = 3;
    }

    public final void a(int i) {
        LiteavLog.i("TXCVodVideoView", "seek to " + i + "vod=" + hashCode());
        int i2 = i;
        if (getUrlPathExtention().equals("m3u8")) {
            i2 = Math.min(i, getDuration() - 1000);
        }
        if (i2 >= 0 && c()) {
            int i3 = i2;
            if (i2 > getDuration()) {
                i3 = getDuration();
            }
            if (this.D) {
                return;
            }
            try {
                this.E = i3;
                this.f36491c.seekTo(i3);
                this.D = true;
                if (this.f36490a == 5) {
                    this.b = 3;
                }
            } catch (Exception e) {
                LiteavLog.e("TXCVodVideoView", "seekTo Exception : " + e.getMessage());
            }
        }
    }

    public final boolean a(boolean z) {
        if (this.f36490a == 0) {
            this.d = z;
            return true;
        }
        return false;
    }

    public final void b() {
        Handler handler = this.V;
        if (handler != null) {
            handler.removeMessages(102);
            this.V.removeMessages(100);
            this.V.removeMessages(103);
        }
        ITXVCubePlayer iTXVCubePlayer = this.f36491c;
        if (iTXVCubePlayer != null) {
            try {
                iTXVCubePlayer.stop();
                b(true);
            } catch (Exception e) {
                LiteavLog.e("TXCVodVideoView", "stop exception: " + e.getMessage());
            }
        }
        LiteavLog.i("TXCVodVideoView", "stop vod=" + hashCode());
    }

    public final boolean c() {
        int i;
        return (this.f36491c == null || (i = this.f36490a) == -1 || i == 0 || i == 1) ? false : true;
    }

    public final void d() {
        ITXVCubePlayer iTXVCubePlayer = this.f36491c;
        if (iTXVCubePlayer != null) {
            iTXVCubePlayer.publishAudioToNetwork();
        }
    }

    public int getBitrateIndex() {
        int i = this.H;
        if (i == -1) {
            return i;
        }
        ITXVCubePlayer iTXVCubePlayer = this.f36491c;
        if (iTXVCubePlayer != null) {
            this.H = iTXVCubePlayer.getBitrateIndex();
        }
        return this.H;
    }

    public long getBufferDuration() {
        long j;
        ITXVCubePlayer iTXVCubePlayer = this.f36491c;
        if (iTXVCubePlayer != null) {
            long playableDurationMs = iTXVCubePlayer.getPlayableDurationMs();
            long currentPosition = getCurrentPosition();
            if (this.f36490a == 3) {
                this.q = currentPosition;
            }
            long j2 = playableDurationMs;
            if (playableDurationMs < currentPosition) {
                j2 = currentPosition;
            }
            j = j2;
            if (Math.abs(getDuration() - j2) < 1000) {
                return getDuration();
            }
        } else {
            j = 0;
        }
        return j;
    }

    public long getCurrentPosition() {
        if (this.D && this.E >= 0) {
            LiteavLog.i("TXCVodVideoView", "getCurrentPosition IsSeeking: " + this.E);
            return this.E;
        }
        long j = this.r;
        if (j <= 0) {
            ITXVCubePlayer iTXVCubePlayer = this.f36491c;
            j = iTXVCubePlayer != null ? iTXVCubePlayer.getCurrentPosition() : 0L;
        }
        long j2 = j;
        if (!this.v.i) {
            int i = this.E;
            j2 = j;
            if (j < i) {
                j2 = i;
            }
        }
        return j2;
    }

    public int getDuration() {
        ITXVCubePlayer iTXVCubePlayer = this.f36491c;
        if (iTXVCubePlayer != null && this.s <= 0) {
            this.s = (int) iTXVCubePlayer.getDuration();
        }
        return this.s;
    }

    public b getMediaInfo() {
        try {
            if (this.f36491c == null) {
                return null;
            }
            return this.f36491c.getMediaInfo();
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public int getMetaRotationDegree() {
        return this.p;
    }

    public int getPlayerType() {
        return 2;
    }

    public String getServerIp() {
        return this.A;
    }

    public ArrayList<com.tencent.liteav.txcplayer.d.a> getSupportedBitrates() {
        try {
            return this.f36491c != null ? this.f36491c.getSupportedBitrates() : new ArrayList<>();
        } catch (Throwable th) {
            th.printStackTrace();
            return new ArrayList<>();
        }
    }

    String getUrlPathExtention() {
        String str = this.v.q;
        return !TextUtils.isEmpty(str) ? str.substring(str.lastIndexOf(".") + 1, str.length()) : "";
    }

    public int getVideoHeight() {
        return this.l;
    }

    public int getVideoRotationDegree() {
        return this.o;
    }

    public int getVideoWidth() {
        return this.k;
    }

    public void setAudioPlayoutVolume(int i) {
        if (i > 0) {
            this.F = i;
        }
        ITXVCubePlayer iTXVCubePlayer = this.f36491c;
        if (iTXVCubePlayer != null) {
            iTXVCubePlayer.setAudioVolume(i);
        }
    }

    public void setAutoPlay(boolean z) {
        this.v.p = z;
    }

    public void setBitrateIndex(int i) {
        LiteavLog.i("TXCVodVideoView", "setBitrateIndex " + i + " vod=" + hashCode());
        if (getBitrateIndex() == i || i == -1000) {
            return;
        }
        this.H = i;
        if (this.f36490a == 5) {
            return;
        }
        try {
            ArrayList<com.tencent.liteav.txcplayer.d.a> supportedBitrates = getSupportedBitrates();
            if (supportedBitrates != null && supportedBitrates.size() > 0 && i != -1) {
                Iterator<com.tencent.liteav.txcplayer.d.a> it = supportedBitrates.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    com.tencent.liteav.txcplayer.d.a next = it.next();
                    if (next != null && next.f36478a == i) {
                        this.I = next.d;
                        break;
                    }
                }
            }
            if (this.f36491c != null) {
                if (!this.v.j || i == -1 || this.f36491c.getBitrateIndex() == -1) {
                    c(false);
                } else {
                    this.f36491c.setBitrateIndex(i);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setConfig(e eVar) {
        if (eVar != null) {
            this.v = eVar;
        }
    }

    public void setListener(d dVar) {
        this.U = dVar;
    }

    public void setMute(boolean z) {
        this.G = z;
        ITXVCubePlayer iTXVCubePlayer = this.f36491c;
        if (iTXVCubePlayer == null) {
            return;
        }
        if (z) {
            iTXVCubePlayer.setAudioVolume(0);
        } else {
            iTXVCubePlayer.setAudioVolume(this.F);
        }
    }

    public void setPlayerType(int i) {
    }

    public void setPrivateConfig(Map<String, Object> map) {
        this.w = map;
        ITXVCubePlayer iTXVCubePlayer = this.f36491c;
        if (iTXVCubePlayer != null) {
            iTXVCubePlayer.setPrivateConfig(map);
        }
    }

    public void setRate(float f) {
        LiteavLog.i("TXCVodVideoView", "setRate ".concat(String.valueOf(f)));
        ITXVCubePlayer iTXVCubePlayer = this.f36491c;
        if (iTXVCubePlayer != null) {
            iTXVCubePlayer.setRate(f);
        }
        this.B = f;
    }

    public void setRender(int i) {
        if (i == 0) {
            setRenderView(null);
        } else if (i == 1) {
            setRenderView(new SurfaceRenderView(this.u));
        } else if (i != 2) {
            LiteavLog.e("TXCVodVideoView", String.format(Locale.getDefault(), "invalid render %d\n", Integer.valueOf(i)));
        } else {
            TextureRenderView textureRenderView = new TextureRenderView(this.u);
            if (this.f36491c != null) {
                textureRenderView.getSurfaceHolder().a(this.f36491c);
                textureRenderView.a(this.f36491c.getVideoWidth(), this.f36491c.getVideoHeight());
                textureRenderView.b(this.f36491c.getVideoSarNum(), this.f36491c.getVideoSarDen());
                textureRenderView.setAspectRatio(this.T);
            }
            setRenderView(textureRenderView);
        }
    }

    public void setRenderMode(int i) {
        this.T = i;
        com.tencent.liteav.txcvodplayer.renderer.a aVar = this.x;
        if (aVar != null) {
            aVar.setAspectRatio(i);
        }
        com.tencent.liteav.txcvodplayer.renderer.a aVar2 = this.x;
        if (aVar2 != null) {
            aVar2.setVideoRotation(this.o);
        }
    }

    public void setRenderSurface(final Surface surface) {
        a.b bVar = new a.b() { // from class: com.tencent.liteav.txcvodplayer.TXCVodVideoView.1
            @Override // com.tencent.liteav.txcvodplayer.renderer.a.b
            public final com.tencent.liteav.txcvodplayer.renderer.a a() {
                return TXCVodVideoView.this.x;
            }

            @Override // com.tencent.liteav.txcvodplayer.renderer.a.b
            public final void a(ITXVCubePlayer iTXVCubePlayer) {
                iTXVCubePlayer.setSurface(surface);
            }

            @Override // com.tencent.liteav.txcvodplayer.renderer.a.b
            public final Surface b() {
                return null;
            }

            @Override // com.tencent.liteav.txcvodplayer.renderer.a.b
            public final Surface c() {
                return surface;
            }
        };
        this.j = bVar;
        ITXVCubePlayer iTXVCubePlayer = this.f36491c;
        if (iTXVCubePlayer != null) {
            b(iTXVCubePlayer, bVar);
        }
    }

    public void setRenderView(com.tencent.liteav.txcvodplayer.renderer.a aVar) {
        int i;
        int i2;
        LiteavLog.i("TXCVodVideoView", "setRenderView ".concat(String.valueOf(aVar)));
        if (this.x != null) {
            ITXVCubePlayer iTXVCubePlayer = this.f36491c;
            if (iTXVCubePlayer != null) {
                iTXVCubePlayer.setDisplay(null);
            }
            View view = this.x.getView();
            this.x.b(this.i);
            this.x = null;
            if (view.getParent() == this) {
                removeView(view);
            }
        }
        if (aVar == null) {
            return;
        }
        this.x = aVar;
        aVar.setAspectRatio(this.T);
        int i3 = this.k;
        if (i3 > 0 && (i2 = this.l) > 0) {
            aVar.a(i3, i2);
        }
        int i4 = this.y;
        if (i4 > 0 && (i = this.z) > 0) {
            aVar.b(i4, i);
        }
        View view2 = this.x.getView();
        view2.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
        if (view2.getParent() == null) {
            addView(view2);
        }
        this.x.a(this.i);
        this.x.setVideoRotation(this.o);
    }

    public void setStartTime(float f) {
        this.r = f * 1000.0f;
    }

    public void setTextureRenderView(TextureRenderView textureRenderView) {
        LiteavLog.i("TXCVodVideoView", "setTextureRenderView ".concat(String.valueOf(textureRenderView)));
        if (this.f36491c != null) {
            textureRenderView.getSurfaceHolder().a(this.f36491c);
            textureRenderView.a(this.f36491c.getVideoWidth(), this.f36491c.getVideoHeight());
            textureRenderView.b(this.f36491c.getVideoSarNum(), this.f36491c.getVideoSarDen());
            textureRenderView.setAspectRatio(this.T);
        }
        setRenderView(textureRenderView);
    }

    public void setVideoPath(String str) {
        setVideoURI(Uri.parse(str));
    }

    public void setVideoRotationDegree(int i) {
        int i2 = i;
        if (i != 0) {
            i2 = i;
            if (i != 90) {
                i2 = i;
                if (i != 180) {
                    i2 = i;
                    if (i != 270) {
                        if (i != 360) {
                            LiteavLog.e("TXCVodVideoView", "not support degree ".concat(String.valueOf(i)));
                            return;
                        }
                        i2 = 0;
                    }
                }
            }
        }
        this.o = i2;
        com.tencent.liteav.txcvodplayer.renderer.a aVar = this.x;
        if (aVar != null) {
            aVar.setVideoRotation(i2);
        }
        com.tencent.liteav.txcvodplayer.renderer.a aVar2 = this.x;
        if (aVar2 != null) {
            aVar2.setAspectRatio(this.T);
        }
    }

    public void setVideoURI(Uri uri) {
        if (uri != null) {
            this.v.q = uri.toString();
        }
        this.s = 0;
        this.E = -1;
        this.M = 0;
        this.A = null;
        LiteavLog.i("TXCVodVideoView", "setVideoURI ".concat(String.valueOf(uri)));
        e();
        requestLayout();
        invalidate();
    }
}
