package com.anythink.expressad.video.bt.module;

import android.content.Context;
import android.content.res.Configuration;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Base64;
import android.view.View;
import android.webkit.WebView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.anythink.core.common.b.n;
import com.anythink.expressad.atsignalcommon.windvane.j;
import com.anythink.expressad.foundation.f.b;
import com.anythink.expressad.foundation.h.i;
import com.anythink.expressad.foundation.h.o;
import com.anythink.expressad.foundation.h.t;
import com.anythink.expressad.foundation.h.w;
import com.anythink.expressad.playercommon.DefaultVideoPlayerStatusListener;
import com.anythink.expressad.playercommon.PlayerErrorConstant;
import com.anythink.expressad.playercommon.PlayerView;
import com.anythink.expressad.video.widget.SoundImageView;
import com.anythink.expressad.videocommon.b.c;
import com.anythink.expressad.videocommon.b.e;
import com.anythink.expressad.widget.FeedBackButton;
import com.bytedance.applog.tracker.Tracker;
import java.io.File;
import org.json.JSONObject;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/video/bt/module/AnythinkBTVideoView.class */
public class AnythinkBTVideoView extends BTBaseView {
    private static boolean H = false;
    private static final String N = "2";
    private static final String p = "anythink_reward_videoview_item";
    private a A;
    private int B;
    private int C;
    private boolean D;
    private int E;
    private int F;
    private String G;
    private boolean I;
    private boolean J;
    private boolean K;
    private RelativeLayout L;
    private ProgressBar M;
    private PlayerView q;
    private SoundImageView r;
    private TextView s;
    private View t;
    private FeedBackButton u;
    private WebView v;
    private c w;
    private int x;
    private int y;
    private int z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/video/bt/module/AnythinkBTVideoView$a.class */
    public static final class a extends DefaultVideoPlayerStatusListener {

        /* renamed from: a  reason: collision with root package name */
        private AnythinkBTVideoView f8330a;
        private WebView b;

        /* renamed from: c  reason: collision with root package name */
        private String f8331c;
        private String d;
        private int e;
        private int f;
        private boolean g;
        private int k;
        private int l;
        private boolean h = false;
        private boolean i = false;
        private boolean j = false;
        private boolean m = false;

        public a(AnythinkBTVideoView anythinkBTVideoView, WebView webView) {
            this.f8330a = anythinkBTVideoView;
            this.b = webView;
            this.f8331c = anythinkBTVideoView.d;
            this.d = anythinkBTVideoView.f8336c;
        }

        private int a() {
            return this.e;
        }

        private void b() {
            this.f8330a = null;
            this.b = null;
            boolean unused = AnythinkBTVideoView.H = false;
        }

        public final void a(int i, int i2) {
            this.k = i;
            this.l = i2;
        }

        @Override // com.anythink.expressad.playercommon.DefaultVideoPlayerStatusListener, com.anythink.expressad.playercommon.VideoPlayerStatusListener
        public final void onBufferingEnd() {
            try {
                super.onBufferingEnd();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // com.anythink.expressad.playercommon.DefaultVideoPlayerStatusListener, com.anythink.expressad.playercommon.VideoPlayerStatusListener
        public final void onBufferingStart(String str) {
            try {
                super.onBufferingStart(str);
                if ((str.equals(PlayerErrorConstant.PREPARE_TIMEOUT) || str.equals("play buffering tiemout")) && this.b != null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("code", BTBaseView.n);
                        jSONObject.put("id", this.f8331c);
                        jSONObject.put("data", new JSONObject());
                        j.a();
                        j.a(this.b, "onPlayerTimeout", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                    } catch (Exception e) {
                        com.anythink.expressad.video.bt.a.c.a();
                        com.anythink.expressad.video.bt.a.c.a(this.b, e.getMessage());
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        @Override // com.anythink.expressad.playercommon.DefaultVideoPlayerStatusListener, com.anythink.expressad.playercommon.VideoPlayerStatusListener
        public final void onPlayCompleted() {
            super.onPlayCompleted();
            if (this.f8330a.b == null) {
                this.f8330a.s.setText("0");
            } else if (this.f8330a.b.i() > 0) {
                this.f8330a.s.setText(i.a(n.a().g(), "anythink_reward_video_view_reward_time_complete", "string"));
            } else {
                this.f8330a.s.setText("0");
            }
            this.f8330a.q.setClickable(false);
            WebView webView = this.b;
            if (webView != null) {
                BTBaseView.a(webView, "onPlayerFinish", this.f8331c);
            }
            this.e = this.f;
            boolean unused = AnythinkBTVideoView.H = true;
            this.f8330a.stop();
        }

        @Override // com.anythink.expressad.playercommon.DefaultVideoPlayerStatusListener, com.anythink.expressad.playercommon.VideoPlayerStatusListener
        public final void onPlayError(String str) {
            super.onPlayError(str);
            if (this.b != null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("code", BTBaseView.o);
                    jSONObject.put("id", this.f8331c);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("error", str);
                    jSONObject2.put("id", this.f8331c);
                    jSONObject.put("data", jSONObject2);
                    j.a();
                    j.a(this.b, "onPlayerFailed", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                } catch (Exception e) {
                    com.anythink.expressad.video.bt.a.c.a();
                    com.anythink.expressad.video.bt.a.c.a(this.b, e.getMessage());
                }
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:52:0x02a3 A[Catch: Exception -> 0x02d5, TRY_ENTER, TryCatch #1 {Exception -> 0x02d5, blocks: (B:30:0x01bd, B:32:0x01c6, B:34:0x01cd, B:37:0x01d5, B:39:0x01dc, B:42:0x01eb, B:44:0x01fa, B:47:0x020d, B:49:0x0290, B:49:0x0290, B:50:0x0293, B:52:0x02a3, B:48:0x0250), top: B:59:0x01bd }] */
        /* JADX WARN: Removed duplicated region for block: B:65:? A[RETURN, SYNTHETIC] */
        @Override // com.anythink.expressad.playercommon.DefaultVideoPlayerStatusListener, com.anythink.expressad.playercommon.VideoPlayerStatusListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void onPlayProgress(int r7, int r8) {
            /*
                Method dump skipped, instructions count: 739
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.video.bt.module.AnythinkBTVideoView.a.onPlayProgress(int, int):void");
        }

        @Override // com.anythink.expressad.playercommon.DefaultVideoPlayerStatusListener, com.anythink.expressad.playercommon.VideoPlayerStatusListener
        public final void onPlaySetDataSourceError(String str) {
            super.onPlaySetDataSourceError(str);
        }

        @Override // com.anythink.expressad.playercommon.DefaultVideoPlayerStatusListener, com.anythink.expressad.playercommon.VideoPlayerStatusListener
        public final void onPlayStarted(int i) {
            super.onPlayStarted(i);
            if (!this.g) {
                this.f8330a.M.setMax(i);
                WebView webView = this.b;
                if (webView != null) {
                    BTBaseView.a(webView, "onPlayerPlay", this.f8331c);
                }
                this.g = true;
            }
            boolean unused = AnythinkBTVideoView.H = false;
        }

        @Override // com.anythink.expressad.playercommon.DefaultVideoPlayerStatusListener, com.anythink.expressad.playercommon.VideoPlayerStatusListener
        public final void onVideoDownloadResume() {
            String str;
            if (this.f8330a.b.w() == 94 || this.f8330a.b.w() == 287) {
                str = this.f8330a.b.Z() + this.f8330a.b.aZ() + this.f8330a.b.S();
            } else {
                str = this.f8330a.b.aZ() + this.f8330a.b.S() + this.f8330a.b.B();
            }
            c a2 = e.a().a(this.d, str);
            if (a2 != null) {
                a2.i();
                this.m = true;
                o.d("DefaultVideoPlayerStatusListener", "onVideoDownloadResume :  and start download !");
            }
        }
    }

    public AnythinkBTVideoView(Context context) {
        super(context);
        this.x = 0;
        this.y = 0;
        this.z = 0;
        this.B = 2;
        this.D = false;
        this.E = 2;
        this.F = 1;
        this.I = false;
        this.J = false;
        this.K = false;
    }

    public AnythinkBTVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.x = 0;
        this.y = 0;
        this.z = 0;
        this.B = 2;
        this.D = false;
        this.E = 2;
        this.F = 1;
        this.I = false;
        this.J = false;
        this.K = false;
    }

    private int a(com.anythink.expressad.foundation.d.c cVar) {
        if (cVar != null && cVar.ao() != -1) {
            return cVar.ao();
        }
        return com.anythink.expressad.videocommon.e.c.a().a(com.anythink.expressad.foundation.b.a.b().e(), this.f8336c, false).v();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String b(int i, int i2) {
        if (i2 != 0) {
            double d = i / i2;
            try {
                StringBuilder sb = new StringBuilder();
                sb.append(t.a(Double.valueOf(d)));
                return sb.toString();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return String.valueOf(i2);
    }

    private boolean b() {
        try {
            this.q = (PlayerView) findViewById(findID("anythink_vfpv"));
            this.r = (SoundImageView) findViewById(findID("anythink_sound_switch"));
            this.s = (TextView) findViewById(findID("anythink_tv_count"));
            this.t = findViewById(findID("anythink_rl_playing_close"));
            this.L = (RelativeLayout) findViewById(findID("anythink_top_control"));
            this.M = (ProgressBar) findViewById(findID("anythink_video_progress_bar"));
            this.q.setIsBTVideo(true);
            this.u = (FeedBackButton) findViewById(findID("anythink_native_endcard_feed_btn"));
            return isNotNULL(this.q, this.r, this.s, this.t);
        } catch (Throwable th) {
            o.b(BTBaseView.TAG, th.getMessage(), th);
            return false;
        }
    }

    private void c() {
        String str;
        if (this.b.w() == 94 || this.b.w() == 287) {
            str = this.b.Z() + this.b.aZ() + this.b.S();
        } else {
            str = this.b.aZ() + this.b.S() + this.b.B();
        }
        c a2 = e.a().a(this.f8336c, str);
        if (a2 != null) {
            this.w = a2;
        }
    }

    private String d() {
        String str;
        String str2 = "";
        try {
            String S = this.b.S();
            str = S;
            if (this.w != null) {
                str = S;
                if (this.w.k() == 5) {
                    String e = this.w.e();
                    str = S;
                    if (!w.a(e)) {
                        str2 = S;
                        str = S;
                        if (new File(e).exists()) {
                            return e;
                        }
                    }
                }
            }
        } catch (Throwable th) {
            o.b(BTBaseView.TAG, th.getMessage(), th);
            str = str2;
        }
        return str;
    }

    private static int e() {
        int i = 5;
        try {
            com.anythink.expressad.videocommon.e.a b = com.anythink.expressad.videocommon.e.c.a().b();
            if (b == null) {
                com.anythink.expressad.videocommon.e.c.a();
                com.anythink.expressad.videocommon.e.c.c();
            }
            int i2 = 5;
            if (b != null) {
                i2 = (int) b.g();
            }
            i = i2;
            o.b(BTBaseView.TAG, "AnythinkBaseView buffetTimeout:".concat(String.valueOf(i2)));
            return i2;
        } catch (Throwable th) {
            th.printStackTrace();
            return i;
        }
    }

    private int f() {
        return com.anythink.expressad.videocommon.e.c.a().a(com.anythink.expressad.foundation.b.a.b().e(), this.f8336c, false).x();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.anythink.expressad.video.bt.module.BTBaseView
    public final void a() {
        super.a();
        if (this.h) {
            this.r.setOnClickListener(new View.OnClickListener() { // from class: com.anythink.expressad.video.bt.module.AnythinkBTVideoView.1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    Tracker.onClick(view);
                    boolean isSilent = AnythinkBTVideoView.this.q.isSilent();
                    if (AnythinkBTVideoView.this.v != null) {
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("code", BTBaseView.n);
                            jSONObject.put("id", AnythinkBTVideoView.this.d);
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("mute", AnythinkBTVideoView.this.B);
                            jSONObject.put("data", jSONObject2);
                            j.a();
                            j.a(AnythinkBTVideoView.this.v, "onPlayerMuteBtnClicked", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                            o.a("OperateViews", "onPlayerMuteBtnClicked isMute = " + isSilent + " mute = " + AnythinkBTVideoView.this.B);
                        } catch (Exception e) {
                            com.anythink.expressad.video.bt.a.c.a();
                            com.anythink.expressad.video.bt.a.c.a(AnythinkBTVideoView.this.v, e.getMessage());
                        }
                    }
                }
            });
            this.t.setOnClickListener(new View.OnClickListener() { // from class: com.anythink.expressad.video.bt.module.AnythinkBTVideoView.2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    Tracker.onClick(view);
                    if (AnythinkBTVideoView.this.v != null) {
                        BTBaseView.a(AnythinkBTVideoView.this.v, "onPlayerCloseBtnClicked", AnythinkBTVideoView.this.d);
                    }
                }
            });
            setOnClickListener(new View.OnClickListener() { // from class: com.anythink.expressad.video.bt.module.AnythinkBTVideoView.3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    Tracker.onClick(view);
                    if (AnythinkBTVideoView.this.v != null) {
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("code", BTBaseView.n);
                            jSONObject.put("id", AnythinkBTVideoView.this.d);
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("x", String.valueOf(view.getX()));
                            jSONObject2.put("y", String.valueOf(view.getY()));
                            jSONObject.put("data", jSONObject2);
                            j.a();
                            j.a(AnythinkBTVideoView.this.v, "onClicked", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                        } catch (Exception e) {
                            com.anythink.expressad.video.bt.a.c.a();
                            com.anythink.expressad.video.bt.a.c.a(AnythinkBTVideoView.this.v, "onClicked", AnythinkBTVideoView.this.d);
                        }
                    }
                }
            });
        }
    }

    public int getMute() {
        return this.B;
    }

    @Override // com.anythink.expressad.video.bt.module.BTBaseView
    public void init(Context context) {
        int findLayout = findLayout(p);
        if (findLayout > 0) {
            this.f.inflate(findLayout, this);
            this.h = b();
            if (!this.h) {
                o.d(BTBaseView.TAG, "AnythinkVideoView init fail");
            }
            a();
        }
        H = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!this.K) {
            com.anythink.expressad.video.bt.a.c.a();
            this.E = com.anythink.expressad.video.bt.a.c.e(this.f8336c);
        }
        View view = this.t;
        if (view != null) {
            view.setVisibility(this.y == 0 ? 8 : 0);
        }
        SoundImageView soundImageView = this.r;
        if (soundImageView != null) {
            soundImageView.setVisibility(this.z == 0 ? 8 : 0);
        }
        TextView textView = this.s;
        if (textView != null) {
            textView.setVisibility(this.x == 0 ? 8 : 0);
            if (this.s.getVisibility() == 0 && b.a().b()) {
                this.b.l(this.f8336c);
                b a2 = b.a();
                a2.a(this.f8336c + "_1", this.b);
                b a3 = b.a();
                a3.a(this.f8336c + "_1", this.u);
            }
        }
    }

    @Override // com.anythink.expressad.video.bt.module.BTBaseView, android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override // com.anythink.expressad.video.bt.module.BTBaseView
    public void onDestory() {
        try {
            if (this.q != null) {
                this.q.setOnClickListener(null);
                this.q.release();
                this.q = null;
            }
            if (this.r != null) {
                this.r.setOnClickListener(null);
            }
            if (this.t != null) {
                this.t.setOnClickListener(null);
            }
            if (this.v != null) {
                this.v = null;
            }
            setOnClickListener(null);
        } catch (Throwable th) {
            o.a(BTBaseView.TAG, th.getMessage());
        }
    }

    public void onPause() {
        PlayerView playerView = this.q;
        if (playerView != null) {
            boolean isPlayIng = playerView.isPlayIng();
            this.J = isPlayIng;
            this.q.setIsBTVideoPlaying(isPlayIng);
            this.q.onPause();
        }
    }

    public void onResume() {
        PlayerView playerView = this.q;
        if (playerView != null) {
            playerView.setDesk(true);
            this.q.setIsCovered(false);
            if (this.J) {
                this.q.onResume();
            }
        }
    }

    public void onStop() {
        PlayerView playerView = this.q;
        if (playerView != null) {
            playerView.setIsCovered(true);
        }
    }

    public void pause() {
        try {
            if (this.q != null) {
                this.q.pause();
                if (this.v != null) {
                    a(this.v, "onPlayerPause", this.d);
                }
            }
        } catch (Exception e) {
            o.b(BTBaseView.TAG, e.getMessage(), e);
        }
    }

    public void play() {
        try {
            if (this.K) {
                if (this.D) {
                    this.q.playVideo(0);
                    this.D = false;
                } else {
                    this.q.start(false);
                }
                if (this.v != null) {
                    a(this.v, "onPlayerPlay", this.d);
                    return;
                }
                return;
            }
            if (this.E == 1) {
                playMute();
            } else {
                playUnMute();
            }
            if (!this.q.playVideo()) {
                o.d("MediaPlayer", "播放失败");
                if (this.A != null) {
                    this.A.onPlayError("play video failed");
                }
            }
            this.K = true;
            if (this.v != null) {
                a(this.v, "onPlayerPlay", this.d);
            }
        } catch (Exception e) {
            o.b(BTBaseView.TAG, e.getMessage(), e);
        }
    }

    public boolean playMute() {
        try {
            if (this.q == null || this.v == null) {
                return false;
            }
            this.q.closeSound();
            this.r.setSoundStatus(false);
            this.B = 1;
            a(this.v, "onPlayerMute", this.d);
            return true;
        } catch (Exception e) {
            o.d(BTBaseView.TAG, e.getMessage());
            return false;
        }
    }

    public boolean playUnMute() {
        try {
            if (this.q == null || this.v == null) {
                return false;
            }
            this.q.openSound();
            this.r.setSoundStatus(true);
            this.B = 2;
            a(this.v, "onUnmute", this.d);
            return true;
        } catch (Exception e) {
            o.d(BTBaseView.TAG, e.getMessage());
            return false;
        }
    }

    public void preLoadData() {
        String str;
        if (this.b.w() == 94 || this.b.w() == 287) {
            str = this.b.Z() + this.b.aZ() + this.b.S();
        } else {
            str = this.b.aZ() + this.b.S() + this.b.B();
        }
        c a2 = e.a().a(this.f8336c, str);
        if (a2 != null) {
            this.w = a2;
        }
        this.C = e();
        this.G = d();
        if (this.h && !TextUtils.isEmpty(this.G) && this.b != null) {
            a aVar = new a(this, this.v);
            this.A = aVar;
            com.anythink.expressad.foundation.d.c cVar = this.b;
            aVar.a(cVar != null ? cVar.ao() != -1 ? cVar.ao() : com.anythink.expressad.videocommon.e.c.a().a(com.anythink.expressad.foundation.b.a.b().e(), this.f8336c, false).v() : com.anythink.expressad.videocommon.e.c.a().a(com.anythink.expressad.foundation.b.a.b().e(), this.f8336c, false).v(), com.anythink.expressad.videocommon.e.c.a().a(com.anythink.expressad.foundation.b.a.b().e(), this.f8336c, false).x());
            this.q.setDesk(false);
            this.q.initBufferIngParam(this.C);
            this.q.initVFPData(this.G, this.b.S(), this.b.ao(), this.A);
            soundOperate(this.B, -1, null);
        }
        H = false;
    }

    public void resume() {
        try {
            if (this.q != null) {
                if (this.D) {
                    this.q.playVideo(0);
                    this.D = false;
                } else {
                    this.q.onResume();
                }
                if (this.v != null) {
                    a(this.v, "onPlayerResume", this.d);
                }
            }
        } catch (Exception e) {
            o.d(BTBaseView.TAG, e.getMessage());
        }
    }

    @Override // com.anythink.expressad.video.bt.module.BTBaseView
    public void setCampaign(com.anythink.expressad.foundation.d.c cVar) {
        super.setCampaign(cVar);
        if (cVar == null || cVar.i() <= 0) {
            this.s.setBackgroundResource(i.a(n.a().g(), "anythink_reward_shape_progress", i.f7952c));
            this.s.setWidth(t.b(n.a().g(), 30.0f));
            return;
        }
        this.s.setBackgroundResource(i.a(n.a().g(), "anythink_reward_video_time_count_num_bg", i.f7952c));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, t.b(n.a().g(), 30.0f));
        int b = t.b(n.a().g(), 5.0f);
        layoutParams.setMargins(b, 0, 0, 0);
        this.s.setPadding(b, 0, b, 0);
        this.s.setLayoutParams(layoutParams);
    }

    public void setCloseViewVisable(int i) {
        this.t.setVisibility(i == 0 ? 4 : 0);
    }

    public void setCountDownTextViewVisable(int i) {
        this.s.setVisibility(i == 0 ? 4 : 0);
    }

    public void setCreateWebView(WebView webView) {
        this.v = webView;
    }

    public void setNotchPadding(int i, int i2, int i3, int i4) {
        int i5 = i;
        if (i <= 0) {
            i5 = this.L.getPaddingLeft();
        }
        int i6 = i2;
        if (i2 <= 0) {
            i6 = this.L.getPaddingRight();
        }
        int i7 = i3;
        if (i3 <= 0) {
            i7 = this.L.getPaddingTop();
        }
        int i8 = i4;
        if (i4 <= 0) {
            i8 = this.L.getPaddingBottom();
        }
        o.d(BTBaseView.TAG, "NOTCH BTVideoView " + String.format("%1s-%2s-%3s-%4s", Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8)));
        this.L.setPadding(i5, i7, i6, i8);
    }

    public void setOrientation(int i) {
        this.F = i;
    }

    public void setPlaybackParams(float f) {
        PlayerView playerView = this.q;
        if (playerView != null) {
            playerView.setPlaybackParams(f);
        }
    }

    public void setProgressBarState(int i) {
        ProgressBar progressBar = this.M;
        if (progressBar != null) {
            progressBar.setVisibility(i == 0 ? 8 : 0);
        }
    }

    public void setShowClose(int i) {
        this.y = i;
    }

    public void setShowMute(int i) {
        this.z = i;
    }

    public void setShowTime(int i) {
        this.x = i;
    }

    public void setSoundImageViewVisble(int i) {
        this.r.setVisibility(i == 0 ? 4 : 0);
    }

    public void setVolume(float f, float f2) {
        PlayerView playerView = this.q;
        if (playerView != null) {
            playerView.setVolume(f, f2);
        }
    }

    public void soundOperate(int i, int i2, String str) {
        if (this.h) {
            this.B = i;
            if (i == 1) {
                this.r.setSoundStatus(false);
                this.q.closeSound();
            } else if (i == 2) {
                this.r.setSoundStatus(true);
                this.q.openSound();
            }
            if (i2 == 1) {
                this.r.setVisibility(8);
            } else if (i2 == 2) {
                this.r.setVisibility(0);
            }
        }
    }

    public void stop() {
        try {
            if (this.q != null) {
                this.q.pause();
                this.q.stop();
                try {
                    this.q.prepare();
                    this.q.justSeekTo(0);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (this.v != null) {
                    a(this.v, "onPlayerStop", this.d);
                }
            }
        } catch (Exception e2) {
            o.b(BTBaseView.TAG, e2.getMessage(), e2);
        }
    }
}
