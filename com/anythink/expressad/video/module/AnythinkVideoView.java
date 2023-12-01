package com.anythink.expressad.video.module;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Handler;
import android.provider.BrowserContract;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.anythink.core.common.b.n;
import com.anythink.expressad.foundation.d.c;
import com.anythink.expressad.foundation.h.i;
import com.anythink.expressad.foundation.h.o;
import com.anythink.expressad.foundation.h.t;
import com.anythink.expressad.foundation.h.w;
import com.anythink.expressad.foundation.h.x;
import com.anythink.expressad.playercommon.DefaultVideoPlayerStatusListener;
import com.anythink.expressad.playercommon.PlayerView;
import com.anythink.expressad.video.dynview.f.h;
import com.anythink.expressad.video.dynview.widget.AnyThinkSegmentsProgressBar;
import com.anythink.expressad.video.dynview.widget.AnythinkBaitClickView;
import com.anythink.expressad.video.module.a.a.m;
import com.anythink.expressad.video.signal.f;
import com.anythink.expressad.video.signal.j;
import com.anythink.expressad.video.widget.SoundImageView;
import com.anythink.expressad.videocommon.b.e;
import com.anythink.expressad.videocommon.e.d;
import com.anythink.expressad.widget.FeedBackButton;
import com.bytedance.applog.tracker.Tracker;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/video/module/AnythinkVideoView.class */
public class AnythinkVideoView extends AnythinkBaseView implements f, j {
    private static int A = 0;
    private static int B = 0;
    private static final String C = "2";
    public static final String TAG = "AnythinkVideoView";
    private static boolean av = false;
    private static final String s = "anythink_reward_videoview_item";
    private static final int t = 1;
    private static final float u = 1280.0f;
    private static final float v = 720.0f;
    private static final float w = 0.1f;
    private static int x;
    private static int y;
    private static int z;
    private PlayerView D;
    private SoundImageView E;
    private TextView F;
    private View G;
    private RelativeLayout H;
    private ImageView I;
    private ProgressBar J;
    private FeedBackButton K;
    private boolean L;
    private AnyThinkSegmentsProgressBar M;
    private com.anythink.expressad.video.dynview.f.a N;
    private int O;
    private FrameLayout P;
    private AnythinkClickCTAView Q;
    private com.anythink.expressad.video.signal.factory.b R;
    private int S;
    private RelativeLayout T;
    private com.anythink.expressad.video.module.a.a U;
    private boolean V;
    private boolean W;
    private int aA;
    private boolean aB;
    private boolean aC;
    private boolean aD;
    private boolean aE;
    private boolean aF;
    private boolean aG;
    private boolean aH;
    private boolean aI;
    private AlphaAnimation aJ;
    private AnythinkBaitClickView aK;
    private b aL;
    private boolean aM;
    private Runnable aN;
    private String aa;
    private int ab;
    private int ac;
    private int ad;
    private int ae;
    private com.anythink.expressad.widget.a.a af;
    private com.anythink.expressad.widget.a.b ag;
    private String ah;
    private double ai;
    private double aj;
    private boolean ak;
    private boolean al;
    private boolean am;
    private boolean an;
    private boolean ao;
    private boolean ap;
    private boolean aq;

    /* renamed from: ar  reason: collision with root package name */
    private boolean f5644ar;
    private boolean as;
    private int at;
    private boolean au;
    private int aw;
    private String ax;
    private int ay;
    private int az;
    public List<c> mCampOrderViewData;
    public int mCampaignSize;
    public int mCurrPlayNum;
    public int mCurrentPlayProgressTime;
    public int mMuteSwitch;

    /* renamed from: com.anythink.expressad.video.module.AnythinkVideoView$1  reason: invalid class name */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/video/module/AnythinkVideoView$1.class */
    final class AnonymousClass1 implements h {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ViewGroup f5645a;
        final /* synthetic */ com.anythink.expressad.video.dynview.c b;

        AnonymousClass1(ViewGroup viewGroup, com.anythink.expressad.video.dynview.c cVar) {
            this.f5645a = viewGroup;
            this.b = cVar;
        }

        @Override // com.anythink.expressad.video.dynview.f.h
        public final void a(com.anythink.expressad.video.dynview.a aVar) {
            if (this.f5645a != null && aVar.a() != null) {
                aVar.a().setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
                this.f5645a.addView(aVar.a());
            }
            if (aVar.b() != null) {
                for (View view : aVar.b()) {
                    view.setOnClickListener(new com.anythink.expressad.widget.a() { // from class: com.anythink.expressad.video.module.AnythinkVideoView.1.1
                        @Override // com.anythink.expressad.widget.a
                        public final void a(View view2) {
                            JSONObject jSONObject;
                            if (AnythinkVideoView.this.U != null) {
                                try {
                                    jSONObject = new JSONObject();
                                } catch (JSONException e) {
                                    e = e;
                                    jSONObject = null;
                                }
                                try {
                                    jSONObject.put(com.anythink.expressad.foundation.g.a.ce, AnythinkVideoView.this.a(0));
                                } catch (JSONException e2) {
                                    e = e2;
                                    e.printStackTrace();
                                    AnythinkVideoView.this.U.a(105, jSONObject);
                                    n.a().g();
                                }
                                AnythinkVideoView.this.U.a(105, jSONObject);
                                n.a().g();
                            }
                        }
                    });
                }
            }
            AnythinkVideoView.this.aI = aVar.c();
            AnythinkVideoView.this.b();
            boolean unused = AnythinkVideoView.av = false;
            AnythinkVideoView.this.S = this.b.j();
        }

        @Override // com.anythink.expressad.video.dynview.f.h
        public final void a(com.anythink.expressad.video.dynview.c.b bVar) {
            o.d(AnythinkVideoView.TAG, "errorMsg：" + bVar.b());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.anythink.expressad.video.module.AnythinkVideoView$11  reason: invalid class name */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/video/module/AnythinkVideoView$11.class */
    public final class AnonymousClass11 implements Runnable {
        AnonymousClass11() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            AnythinkVideoView.p(AnythinkVideoView.this);
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/video/module/AnythinkVideoView$a.class */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public int f5660a;
        public int b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f5661c;

        public final String toString() {
            return "ProgressData{curPlayPosition=" + this.f5660a + ", allDuration=" + this.b + '}';
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/video/module/AnythinkVideoView$b.class */
    public static final class b extends DefaultVideoPlayerStatusListener {

        /* renamed from: a  reason: collision with root package name */
        private AnythinkVideoView f5662a;
        private int b;

        /* renamed from: c  reason: collision with root package name */
        private int f5663c;
        private boolean d;
        private boolean i;
        private String j;
        private c k;
        private int l;
        private int m;
        private a e = new a();
        private boolean f = false;
        private boolean g = false;
        private boolean h = false;
        private boolean n = false;

        public b(AnythinkVideoView anythinkVideoView) {
            this.f5662a = anythinkVideoView;
        }

        private void a(int i) {
            if (i <= 0) {
                this.f5662a.F.setBackgroundResource(i.a(n.a().g(), "anythink_reward_shape_progress", i.f5112c));
                return;
            }
            this.f5662a.F.setBackgroundResource(i.a(n.a().g(), "anythink_reward_video_time_count_num_bg", i.f5112c));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, t.b(n.a().g(), 30.0f));
            int b = t.b(n.a().g(), 5.0f);
            layoutParams.addRule(1, i.a(n.a().g(), "anythink_native_endcard_feed_btn", "id"));
            layoutParams.setMargins(b, 0, 0, 0);
            this.f5662a.F.setPadding(b, 0, b, 0);
            this.f5662a.F.setLayoutParams(layoutParams);
        }

        private void a(int i, int i2, int i3) {
            AnythinkVideoView anythinkVideoView = this.f5662a;
            if (anythinkVideoView == null) {
                return;
            }
            String str = (String) anythinkVideoView.getContext().getResources().getText(i.a(n.a().g(), "anythink_reward_video_view_reward_time_complete", "string"));
            String str2 = (String) this.f5662a.getContext().getResources().getText(i.a(n.a().g(), "anythink_reward_video_view_reward_time_left", "string"));
            if (i >= 0) {
                int i4 = i - i3;
                if (i4 > 0) {
                    str = i4 + str2;
                }
            } else {
                int i5 = i2 - i3;
                if (i5 <= 0) {
                    if (i <= 0) {
                        str = "0";
                    }
                } else if (i <= 0) {
                    str = String.valueOf(i5);
                } else {
                    str = i5 + str2;
                }
            }
            this.e.f5660a = i3;
            this.f5662a.F.setText(str);
            if (this.f5662a.J == null || this.f5662a.J.getVisibility() != 0) {
                return;
            }
            this.f5662a.J.setProgress(i3);
        }

        private void b(int i) {
            AnythinkVideoView anythinkVideoView = this.f5662a;
            if (anythinkVideoView == null || anythinkVideoView.F == null) {
                return;
            }
            String str = "anythink_reward_video_time_count_num_bg";
            if (this.k.k() == 5 && this.f5662a.mCurrPlayNum > 1 && i <= 0) {
                this.f5662a.F.setBackgroundResource(i.a(n.a().g(), "anythink_reward_video_time_count_num_bg", i.f5112c));
                d();
                return;
            }
            if (i > 0) {
                d();
            } else {
                str = "anythink_reward_shape_progress";
            }
            this.f5662a.F.setBackgroundResource(i.a(n.a().g(), str, i.f5112c));
        }

        private void b(int i, int i2, int i3) {
            String str;
            if (this.f5662a == null) {
                return;
            }
            int i4 = i;
            if (i > i2) {
                i4 = i2;
            }
            int i5 = i4 <= 0 ? i2 - i3 : i4 - i3;
            if (i5 <= 0) {
                str = i4 <= 0 ? "0" : (String) this.f5662a.getContext().getResources().getText(i.a(n.a().g(), "anythink_reward_video_view_reward_time_complete", "string"));
            } else if (i4 <= 0) {
                str = String.valueOf(i5);
            } else {
                str = i5 + ((String) this.f5662a.getContext().getResources().getText(i.a(n.a().g(), "anythink_reward_video_view_reward_time_left", "string")));
            }
            this.f5662a.F.setText(str);
            if (this.f5662a.J == null || this.f5662a.J.getVisibility() != 0) {
                return;
            }
            this.f5662a.J.setProgress(i3);
        }

        private c c() {
            return this.k;
        }

        private void d() {
            AnythinkVideoView anythinkVideoView = this.f5662a;
            if (anythinkVideoView == null) {
                return;
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) anythinkVideoView.F.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.width = -2;
                layoutParams.height = t.b(n.a().g(), 25.0f);
                this.f5662a.F.setLayoutParams(layoutParams);
            }
            int b = t.b(n.a().g(), 5.0f);
            this.f5662a.F.setPadding(b, 0, b, 0);
        }

        public final int a() {
            return this.b;
        }

        public final void a(int i, int i2) {
            this.l = i;
            this.m = i2;
        }

        public final void a(c cVar) {
            this.k = cVar;
        }

        public final void a(String str) {
            this.j = str;
        }

        public final void a(boolean z) {
            this.i = z;
        }

        public final void b() {
            this.f5662a = null;
            boolean unused = AnythinkVideoView.av = false;
        }

        @Override // com.anythink.expressad.playercommon.DefaultVideoPlayerStatusListener, com.anythink.expressad.playercommon.VideoPlayerStatusListener
        public final void onBufferingEnd() {
            try {
                super.onBufferingEnd();
                this.f5662a.e.a(14, "");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // com.anythink.expressad.playercommon.DefaultVideoPlayerStatusListener, com.anythink.expressad.playercommon.VideoPlayerStatusListener
        public final void onBufferingStart(String str) {
            try {
                super.onBufferingStart(str);
                this.f5662a.e.a(13, "");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // com.anythink.expressad.playercommon.DefaultVideoPlayerStatusListener, com.anythink.expressad.playercommon.VideoPlayerStatusListener
        public final void onPlayCompleted() {
            AnythinkVideoView anythinkVideoView;
            super.onPlayCompleted();
            AnythinkVideoView.w(this.f5662a);
            c cVar = this.k;
            if (cVar != null) {
                if (cVar.i() > 0) {
                    this.f5662a.F.setText(i.a(n.a().g(), "anythink_reward_video_view_reward_time_complete", "string"));
                } else {
                    this.f5662a.F.setText("0");
                }
                this.k.n(100);
                if (this.k.f() == 2) {
                    this.f5662a.G.setVisibility(4);
                    if (this.f5662a.K != null) {
                        this.f5662a.K.setClickable(false);
                    }
                    if (this.f5662a.E != null) {
                        this.f5662a.E.setClickable(false);
                    }
                }
            } else {
                this.f5662a.F.setText("0");
            }
            this.f5662a.D.setClickable(false);
            String b = this.f5662a.b(true);
            c cVar2 = this.k;
            if (cVar2 != null && cVar2.k() == 5 && (anythinkVideoView = this.f5662a) != null && anythinkVideoView.N != null && this.f5662a.mCampaignSize > this.f5662a.mCurrPlayNum) {
                HashMap hashMap = new HashMap();
                hashMap.put(BrowserContract.Bookmarks.POSITION, Integer.valueOf(this.f5662a.mCurrPlayNum));
                if (this.f5662a.mMuteSwitch != 0) {
                    hashMap.put("mute", Integer.valueOf(this.f5662a.mMuteSwitch));
                }
                this.f5662a.N.a(hashMap);
                return;
            }
            this.f5662a.e.a(121, "");
            this.f5662a.e.a(11, b);
            int i = this.f5663c;
            this.b = i;
            this.f5662a.mCurrentPlayProgressTime = i;
            boolean unused = AnythinkVideoView.av = true;
        }

        @Override // com.anythink.expressad.playercommon.DefaultVideoPlayerStatusListener, com.anythink.expressad.playercommon.VideoPlayerStatusListener
        public final void onPlayError(String str) {
            o.d("DefaultVideoPlayerStatusListener", "errorStr".concat(String.valueOf(str)));
            super.onPlayError(str);
            AnythinkVideoView anythinkVideoView = this.f5662a;
            if (anythinkVideoView != null) {
                anythinkVideoView.e.a(12, str);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:109:0x043d, code lost:
            if (r9 <= 0) goto L19;
         */
        @Override // com.anythink.expressad.playercommon.DefaultVideoPlayerStatusListener, com.anythink.expressad.playercommon.VideoPlayerStatusListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void onPlayProgress(int r7, int r8) {
            /*
                Method dump skipped, instructions count: 1098
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.video.module.AnythinkVideoView.b.onPlayProgress(int, int):void");
        }

        @Override // com.anythink.expressad.playercommon.DefaultVideoPlayerStatusListener, com.anythink.expressad.playercommon.VideoPlayerStatusListener
        public final void onPlaySetDataSourceError(String str) {
            super.onPlaySetDataSourceError(str);
        }

        @Override // com.anythink.expressad.playercommon.DefaultVideoPlayerStatusListener, com.anythink.expressad.playercommon.VideoPlayerStatusListener
        public final void onPlayStarted(int i) {
            super.onPlayStarted(i);
            if (!this.d) {
                AnythinkVideoView anythinkVideoView = this.f5662a;
                if (anythinkVideoView != null) {
                    AnythinkVideoView.q(anythinkVideoView);
                }
                this.f5662a.e.a(10, this.e);
                this.d = true;
            }
            c cVar = this.k;
            if (cVar != null) {
                int i2 = cVar.i();
                String str = "anythink_reward_shape_progress";
                if (this.k.j()) {
                    AnythinkVideoView anythinkVideoView2 = this.f5662a;
                    if (anythinkVideoView2 != null && anythinkVideoView2.F != null) {
                        if (this.k.k() != 5 || this.f5662a.mCurrPlayNum <= 1 || i2 > 0) {
                            if (i2 > 0) {
                                d();
                                str = "anythink_reward_video_time_count_num_bg";
                            }
                            this.f5662a.F.setBackgroundResource(i.a(n.a().g(), str, i.f5112c));
                        } else {
                            this.f5662a.F.setBackgroundResource(i.a(n.a().g(), "anythink_reward_video_time_count_num_bg", i.f5112c));
                            d();
                        }
                    }
                } else if (i2 > 0) {
                    this.f5662a.F.setBackgroundResource(i.a(n.a().g(), "anythink_reward_video_time_count_num_bg", i.f5112c));
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, t.b(n.a().g(), 30.0f));
                    int b = t.b(n.a().g(), 5.0f);
                    layoutParams.addRule(1, i.a(n.a().g(), "anythink_native_endcard_feed_btn", "id"));
                    layoutParams.setMargins(b, 0, 0, 0);
                    this.f5662a.F.setPadding(b, 0, b, 0);
                    this.f5662a.F.setLayoutParams(layoutParams);
                } else {
                    this.f5662a.F.setBackgroundResource(i.a(n.a().g(), "anythink_reward_shape_progress", i.f5112c));
                }
            }
            if (this.f5662a.J != null) {
                this.f5662a.J.setMax(i);
            }
            c cVar2 = this.k;
            if (cVar2 != null && cVar2.f() == 2) {
                this.f5662a.H.setVisibility(0);
            }
            if (this.f5662a.F.getVisibility() == 0) {
                this.f5662a.n();
            }
            boolean unused = AnythinkVideoView.av = false;
            if (this.f5662a.S == 0) {
                this.f5662a.setCTALayoutVisibleOrGone();
            }
            this.f5662a.showMoreOfferInPlayTemplate();
            this.f5662a.showBaitClickView();
        }

        @Override // com.anythink.expressad.playercommon.DefaultVideoPlayerStatusListener, com.anythink.expressad.playercommon.VideoPlayerStatusListener
        public final void onVideoDownloadResume() {
            String str;
            if (this.k.w() == 94 || this.k.w() == 287) {
                str = this.k.Z() + this.k.aZ() + this.k.S();
            } else {
                str = this.k.aZ() + this.k.S() + this.k.B();
            }
            com.anythink.expressad.videocommon.b.c a2 = e.a().a(this.j, str);
            if (a2 != null) {
                a2.i();
                this.n = true;
                o.d("DefaultVideoPlayerStatusListener", "onVideoDownloadResume is : and start download !");
            }
        }
    }

    public AnythinkVideoView(Context context) {
        super(context);
        this.mMuteSwitch = 0;
        this.O = 0;
        this.mCampaignSize = 1;
        this.mCurrPlayNum = 1;
        this.mCurrentPlayProgressTime = 0;
        this.V = false;
        this.W = false;
        this.ah = "";
        this.ak = false;
        this.al = false;
        this.am = false;
        this.an = false;
        this.ao = false;
        this.ap = false;
        this.aq = false;
        this.f5644ar = false;
        this.as = false;
        this.au = false;
        this.aw = 2;
        this.aB = false;
        this.aC = false;
        this.aD = false;
        this.aE = true;
        this.aF = false;
        this.aG = false;
        this.aH = false;
        this.aI = false;
        this.aL = new b(this);
        this.aM = false;
        this.aN = new Runnable() { // from class: com.anythink.expressad.video.module.AnythinkVideoView.3
            @Override // java.lang.Runnable
            public final void run() {
                if (AnythinkVideoView.this.P != null) {
                    AnythinkVideoView.this.P.setVisibility(8);
                }
            }
        };
    }

    public AnythinkVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMuteSwitch = 0;
        this.O = 0;
        this.mCampaignSize = 1;
        this.mCurrPlayNum = 1;
        this.mCurrentPlayProgressTime = 0;
        this.V = false;
        this.W = false;
        this.ah = "";
        this.ak = false;
        this.al = false;
        this.am = false;
        this.an = false;
        this.ao = false;
        this.ap = false;
        this.aq = false;
        this.f5644ar = false;
        this.as = false;
        this.au = false;
        this.aw = 2;
        this.aB = false;
        this.aC = false;
        this.aD = false;
        this.aE = true;
        this.aF = false;
        this.aG = false;
        this.aH = false;
        this.aI = false;
        this.aL = new b(this);
        this.aM = false;
        this.aN = new Runnable() { // from class: com.anythink.expressad.video.module.AnythinkVideoView.3
            @Override // java.lang.Runnable
            public final void run() {
                if (AnythinkVideoView.this.P != null) {
                    AnythinkVideoView.this.P.setVisibility(8);
                }
            }
        };
    }

    private int a(c cVar) {
        if (cVar != null && cVar.ao() != -1) {
            return cVar.ao();
        }
        return com.anythink.expressad.videocommon.e.c.a().a(com.anythink.expressad.foundation.b.a.b().e(), this.ah, false).v();
    }

    private static String a(int i, int i2) {
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

    private void a() {
        int findLayout = findLayout(s);
        if (findLayout > 0) {
            this.f5601c.inflate(findLayout, this);
            b();
        }
        av = false;
    }

    private void a(ViewGroup viewGroup, c cVar) {
        new com.anythink.expressad.video.dynview.j.c();
        com.anythink.expressad.video.dynview.c a2 = com.anythink.expressad.video.dynview.j.c.a(viewGroup, cVar);
        com.anythink.expressad.video.dynview.b.a();
        com.anythink.expressad.video.dynview.b.a(a2, new AnonymousClass1(viewGroup, a2));
    }

    private void a(String str) {
        com.anythink.expressad.foundation.g.d.b.a(n.a().g()).a(str, new com.anythink.expressad.foundation.g.d.c() { // from class: com.anythink.expressad.video.module.AnythinkVideoView.2
            @Override // com.anythink.expressad.foundation.g.d.c
            public final void a(Bitmap bitmap, String str2) {
                if (bitmap != null) {
                    try {
                        if (bitmap.isRecycled() || AnythinkVideoView.this.I == null) {
                            return;
                        }
                        AnythinkVideoView.this.I.setVisibility(0);
                        ImageView imageView = AnythinkVideoView.this.I;
                        com.anythink.expressad.video.dynview.i.b.a();
                        imageView.setImageBitmap(com.anythink.expressad.video.dynview.i.b.a(bitmap, 20));
                    } catch (Throwable th) {
                        o.d(AnythinkVideoView.TAG, th.getMessage());
                    }
                }
            }

            @Override // com.anythink.expressad.foundation.g.d.c
            public final void a(String str2, String str3) {
                o.d(AnythinkVideoView.TAG, str2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String b(boolean z2) {
        if (this.au) {
            try {
                JSONObject jSONObject = new JSONObject();
                if (!this.aB) {
                    jSONObject.put("Alert_window_status", com.anythink.expressad.foundation.g.a.cv);
                }
                if (this.aD) {
                    jSONObject.put("Alert_window_status", com.anythink.expressad.foundation.g.a.cx);
                }
                if (this.aC) {
                    jSONObject.put("Alert_window_status", com.anythink.expressad.foundation.g.a.cw);
                }
                jSONObject.put("complete_info", z2 ? 1 : 2);
                return jSONObject.toString();
            } catch (Exception e) {
                o.d(TAG, "getIVRewardStatusString ERROR");
                return "";
            }
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        this.f = f();
        if (!this.f) {
            o.d(TAG, "AnythinkVideoView init fail");
        }
        c();
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 100.0f);
        this.aJ = alphaAnimation;
        alphaAnimation.setDuration(200L);
    }

    private void b(int i) {
        if (i > 0) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setCornerRadius(t.b(getContext(), i));
            gradientDrawable.setColor(-1);
            gradientDrawable.setStroke(1, 0);
            if (Build.VERSION.SDK_INT >= 16) {
                setBackground(gradientDrawable);
                this.D.setBackground(gradientDrawable);
            } else {
                setBackgroundDrawable(gradientDrawable);
                this.D.setBackgroundDrawable(gradientDrawable);
            }
            if (Build.VERSION.SDK_INT >= 21) {
                setClipToOutline(true);
                this.D.setClipToOutline(true);
            }
        }
    }

    private boolean b(int i, int i2) {
        return i > 0 && i2 > 0 && t.f(this.f5600a) >= i && t.e(this.f5600a) >= i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x0258, code lost:
        if (r0 == 0) goto L100;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x01d9, code lost:
        if (r0 < r0) goto L100;
     */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0212 A[Catch: Exception -> 0x0233, TryCatch #0 {Exception -> 0x0233, blocks: (B:2:0x0000, B:4:0x000b, B:6:0x0015, B:9:0x0020, B:11:0x0026, B:13:0x0030, B:15:0x0037, B:17:0x004a, B:19:0x0054, B:21:0x005b, B:23:0x0062, B:25:0x0075, B:27:0x007c, B:29:0x0092, B:32:0x00a6, B:34:0x00ba, B:36:0x00c8, B:38:0x00d0, B:40:0x00d7, B:42:0x00ea, B:44:0x00f4, B:46:0x00fc, B:48:0x0103, B:50:0x0116, B:52:0x011d, B:54:0x012b, B:56:0x0134, B:58:0x013e, B:60:0x0146, B:62:0x0151, B:64:0x015f, B:66:0x0169, B:68:0x0171, B:70:0x017c, B:30:0x009d, B:72:0x018a, B:74:0x0191, B:76:0x019c, B:79:0x01c0, B:91:0x01e3, B:93:0x01eb, B:95:0x01f2, B:97:0x01fd, B:99:0x020b, B:101:0x0212, B:103:0x021f, B:105:0x0226), top: B:125:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:132:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void e() {
        /*
            Method dump skipped, instructions count: 607
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.video.module.AnythinkVideoView.e():void");
    }

    static /* synthetic */ boolean e(AnythinkVideoView anythinkVideoView) {
        anythinkVideoView.aH = true;
        return true;
    }

    private boolean f() {
        try {
            this.D = (PlayerView) findViewById(filterFindViewId(this.aI, "anythink_vfpv"));
            this.E = (SoundImageView) findViewById(filterFindViewId(this.aI, "anythink_sound_switch"));
            this.F = (TextView) findViewById(filterFindViewId(this.aI, "anythink_tv_count"));
            View findViewById = findViewById(filterFindViewId(this.aI, "anythink_rl_playing_close"));
            this.G = findViewById;
            findViewById.setVisibility(4);
            this.H = (RelativeLayout) findViewById(filterFindViewId(this.aI, "anythink_top_control"));
            this.I = (ImageView) findViewById(filterFindViewId(this.aI, "anythink_videoview_bg"));
            this.J = (ProgressBar) findViewById(filterFindViewId(this.aI, "anythink_video_progress_bar"));
            this.K = (FeedBackButton) findViewById(filterFindViewId(this.aI, "anythink_native_endcard_feed_btn"));
            this.M = (AnyThinkSegmentsProgressBar) findViewById(filterFindViewId(this.aI, "anythink_reward_segment_progressbar"));
            this.P = (FrameLayout) findViewById(filterFindViewId(this.aI, "anythink_reward_cta_layout"));
            this.aK = (AnythinkBaitClickView) findViewById(filterFindViewId(this.aI, "anythink_animation_click_view"));
            this.T = (RelativeLayout) findViewById(filterFindViewId(this.aI, "anythink_reward_moreoffer_layout"));
            try {
                String aE = this.b.aE();
                String str = aE;
                if (TextUtils.isEmpty(aE)) {
                    str = com.anythink.expressad.a.ab;
                }
                if (!TextUtils.isEmpty(str)) {
                    com.anythink.expressad.foundation.g.d.b.a(this.f5600a).a(str, new com.anythink.expressad.foundation.g.d.c() { // from class: com.anythink.expressad.video.module.AnythinkVideoView.10
                        @Override // com.anythink.expressad.foundation.g.d.c
                        public final void a(Bitmap bitmap, String str2) {
                            float width = (bitmap.getWidth() * 1.0f) / bitmap.getHeight();
                            int b2 = t.b(AnythinkVideoView.this.f5600a, 12.0f);
                            int i = (int) (b2 * width);
                            ImageView imageView = new ImageView(AnythinkVideoView.this.f5600a);
                            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                            imageView.setImageBitmap(bitmap);
                            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i, b2);
                            layoutParams.addRule(11);
                            layoutParams.addRule(12);
                            layoutParams.bottomMargin = t.b(AnythinkVideoView.this.f5600a, 5.0f);
                            layoutParams.rightMargin = t.b(AnythinkVideoView.this.f5600a, 12.0f);
                            AnythinkVideoView.this.addView(imageView, layoutParams);
                        }

                        @Override // com.anythink.expressad.foundation.g.d.c
                        public final void a(String str2, String str3) {
                        }
                    });
                }
            } catch (Exception e) {
                if (com.anythink.expressad.a.f4103a) {
                    o.d(TAG, e.getLocalizedMessage());
                }
            }
            return isNotNULL(this.D, this.E, this.F, this.G);
        } catch (Throwable th) {
            o.b(TAG, th.getMessage(), th);
            return false;
        }
    }

    private void g() {
        if (this.b == null || !w.b(this.b.U())) {
            return;
        }
        String U = this.b.U();
        o.b(TAG, "AnythinkBaseView videoResolution:".concat(String.valueOf(U)));
        String[] split = U.split("x");
        if (split.length == 2) {
            if (t.b(split[0]) > 0.0d) {
                this.ai = t.b(split[0]);
            }
            if (t.b(split[1]) > 0.0d) {
                this.aj = t.b(split[1]);
            }
            o.b(TAG, "AnythinkBaseView mVideoW:" + this.ai + "  mVideoH:" + this.aj);
        }
        if (this.ai <= 0.0d) {
            this.ai = 1280.0d;
        }
        if (this.aj <= 0.0d) {
            this.aj = 720.0d;
        }
    }

    private void h() {
        boolean z2;
        try {
            if (this.D != null) {
                PlayerView playerView = this.D;
                if (!this.W && !this.V) {
                    z2 = false;
                    playerView.setIsCovered(z2);
                    this.D.onPause();
                    if (this.b != null || this.b.L() == null || this.b.aw()) {
                        return;
                    }
                    this.b.ax();
                    com.anythink.expressad.a.a.a(n.a().g(), this.b, this.ah, this.b.L().m(), false);
                    return;
                }
                z2 = true;
                playerView.setIsCovered(z2);
                this.D.onPause();
                if (this.b != null) {
                }
            }
        } catch (Throwable th) {
            o.b(TAG, th.getMessage(), th);
        }
    }

    static /* synthetic */ boolean h(AnythinkVideoView anythinkVideoView) {
        anythinkVideoView.V = false;
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        try {
            if (this.al) {
                if (this.W || this.V) {
                    return;
                }
                this.D.setIsCovered(false);
                this.D.onResume();
                return;
            }
            boolean playVideo = this.D.playVideo();
            if (this.b != null && this.b.J() != 2 && !playVideo) {
                o.d("MediaPlayer", "播放失败");
                if (this.aL != null) {
                    this.aL.onPlayError("play video failed");
                }
            }
            this.al = true;
        } catch (Exception e) {
            o.b(TAG, e.getMessage(), e);
        }
    }

    private void j() {
        if (!this.f || this.G.getVisibility() == 0) {
            return;
        }
        if (!this.i || this.L) {
            this.G.setVisibility(0);
        }
        this.ao = true;
    }

    private void k() {
        if (this.aM || this.f5644ar || this.ap) {
            return;
        }
        this.aM = true;
        int i = this.ab;
        if (i >= 0) {
            if (i == 0) {
                this.f5644ar = true;
            } else {
                new Handler().postDelayed(new AnonymousClass11(), this.ab * 1000);
            }
        }
    }

    static /* synthetic */ boolean k(AnythinkVideoView anythinkVideoView) {
        anythinkVideoView.aC = true;
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0059, code lost:
        if (r0 > r0) goto L7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void l() {
        /*
            Method dump skipped, instructions count: 881
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.video.module.AnythinkVideoView.l():void");
    }

    static /* synthetic */ boolean l(AnythinkVideoView anythinkVideoView) {
        anythinkVideoView.aG = true;
        return true;
    }

    private void m() {
        try {
            setLayoutParam(0, 0, -1, -1);
            if (isLandscape() || !this.f) {
                return;
            }
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.D.getLayoutParams();
            int f = t.f(this.f5600a);
            layoutParams.width = -1;
            layoutParams.height = (f * 9) / 16;
            layoutParams.gravity = 17;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        if (!com.anythink.expressad.foundation.f.b.a().b()) {
            FeedBackButton feedBackButton = this.K;
            if (feedBackButton != null) {
                feedBackButton.setVisibility(8);
                return;
            }
            return;
        }
        this.b.l(this.ah);
        com.anythink.expressad.foundation.f.b a2 = com.anythink.expressad.foundation.f.b.a();
        a2.a(this.ah + "_1", this.b);
        com.anythink.expressad.foundation.f.b a3 = com.anythink.expressad.foundation.f.b.a();
        a3.a(this.ah + "_1", this.K);
    }

    static /* synthetic */ boolean n(AnythinkVideoView anythinkVideoView) {
        anythinkVideoView.aD = true;
        return true;
    }

    private int o() {
        return com.anythink.expressad.videocommon.e.c.a().a(com.anythink.expressad.foundation.b.a.b().e(), this.ah, false).x();
    }

    private void p() {
        if (this.P == null) {
            return;
        }
        if (this.Q == null) {
            AnythinkClickCTAView anythinkClickCTAView = new AnythinkClickCTAView(getContext());
            this.Q = anythinkClickCTAView;
            anythinkClickCTAView.setCampaign(this.b);
            this.Q.setUnitId(this.ah);
            com.anythink.expressad.video.module.a.a aVar = this.U;
            if (aVar != null) {
                this.Q.setNotifyListener(new com.anythink.expressad.video.module.a.a.i(aVar));
            }
            this.Q.preLoadData(this.R);
        }
        this.P.addView(this.Q);
    }

    static /* synthetic */ boolean p(AnythinkVideoView anythinkVideoView) {
        anythinkVideoView.f5644ar = true;
        return true;
    }

    static /* synthetic */ boolean q(AnythinkVideoView anythinkVideoView) {
        anythinkVideoView.L = true;
        return true;
    }

    static /* synthetic */ boolean w(AnythinkVideoView anythinkVideoView) {
        anythinkVideoView.aF = true;
        return true;
    }

    @Override // com.anythink.expressad.video.signal.j
    public void alertWebViewShowed() {
        this.V = true;
        setShowingAlertViewCover(true);
    }

    @Override // com.anythink.expressad.video.module.AnythinkBaseView
    protected final void c() {
        super.c();
        if (this.f) {
            if (!this.i) {
                this.D.setOnClickListener(new View.OnClickListener() { // from class: com.anythink.expressad.video.module.AnythinkVideoView.6
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        Tracker.onClick(view);
                        if (AnythinkVideoView.this.e != null) {
                            AnythinkVideoView.this.e.a(1, "");
                        }
                    }
                });
            } else if (com.anythink.expressad.video.dynview.i.c.a(this.b) == -1 || com.anythink.expressad.video.dynview.i.c.a(this.b) == 100) {
                this.D.setOnClickListener(new View.OnClickListener() { // from class: com.anythink.expressad.video.module.AnythinkVideoView.5
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        Tracker.onClick(view);
                        if (AnythinkVideoView.this.e != null) {
                            AnythinkVideoView.this.e.a(1, "");
                        }
                        AnythinkVideoView.this.setCTALayoutVisibleOrGone();
                    }
                });
            }
            SoundImageView soundImageView = this.E;
            if (soundImageView != null) {
                soundImageView.setOnClickListener(new View.OnClickListener() { // from class: com.anythink.expressad.video.module.AnythinkVideoView.7
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        Tracker.onClick(view);
                        Integer num = 2;
                        if (AnythinkVideoView.this.D != null) {
                            num = 2;
                            if (AnythinkVideoView.this.D.isSilent()) {
                                num = 1;
                            }
                        }
                        if (num.intValue() == 1) {
                            AnythinkVideoView.this.mMuteSwitch = 2;
                        } else {
                            AnythinkVideoView.this.mMuteSwitch = 1;
                        }
                        if (AnythinkVideoView.this.e != null) {
                            AnythinkVideoView.this.e.a(5, num);
                        }
                    }
                });
            }
            this.G.setOnClickListener(new View.OnClickListener() { // from class: com.anythink.expressad.video.module.AnythinkVideoView.8
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    Tracker.onClick(view);
                    if (!AnythinkVideoView.this.au) {
                        AnythinkVideoView.this.e();
                        return;
                    }
                    AnythinkVideoView.e(AnythinkVideoView.this);
                    if (AnythinkVideoView.this.aE) {
                        AnythinkVideoView.this.e();
                    } else if (AnythinkVideoView.this.e != null) {
                        AnythinkVideoView.this.e.a(123, "");
                    }
                }
            });
        }
    }

    @Override // com.anythink.expressad.video.signal.j
    public void closeVideoOperate(int i, int i2) {
        if (i == 1) {
            this.aH = true;
            if (getVisibility() == 0) {
                e();
            }
        }
        if (i2 == 1) {
            gonePlayingCloseView();
        } else if (i2 == 2) {
            if ((this.aG && getVisibility() == 0) || !this.f || this.G.getVisibility() == 0) {
                return;
            }
            if (!this.i || this.L) {
                this.G.setVisibility(0);
            }
            this.ao = true;
        }
    }

    @Override // com.anythink.expressad.video.module.AnythinkBaseView
    public void defaultShow() {
        super.defaultShow();
        this.ak = true;
        showVideoLocation(0, 0, t.f(this.f5600a), t.e(this.f5600a), 0, 0, 0, 0, 0);
        videoOperate(1);
        if (this.ab == 0) {
            closeVideoOperate(-1, 2);
        }
    }

    @Override // com.anythink.expressad.video.signal.j
    public void dismissAllAlert() {
        com.anythink.expressad.widget.a.a aVar = this.af;
        if (aVar != null) {
            aVar.dismiss();
        }
        if (this.e != null) {
            this.e.a(125, "");
        }
    }

    @Override // com.anythink.expressad.video.signal.j
    public int getBorderViewHeight() {
        return B;
    }

    @Override // com.anythink.expressad.video.signal.j
    public int getBorderViewLeft() {
        return z;
    }

    @Override // com.anythink.expressad.video.signal.j
    public int getBorderViewRadius() {
        return x;
    }

    @Override // com.anythink.expressad.video.signal.j
    public int getBorderViewTop() {
        return y;
    }

    @Override // com.anythink.expressad.video.signal.j
    public int getBorderViewWidth() {
        return A;
    }

    public int getCloseAlert() {
        return this.ad;
    }

    @Override // com.anythink.expressad.video.signal.j
    public String getCurrentProgress() {
        try {
            int a2 = this.aL.a();
            int i = 0;
            if (this.b != null) {
                i = this.b.bi();
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("progress", a(a2, i));
            jSONObject.put("time", a2);
            jSONObject.put("duration", String.valueOf(i));
            return jSONObject.toString();
        } catch (Throwable th) {
            o.b(TAG, th.getMessage(), th);
            return "{}";
        }
    }

    public int getMute() {
        return this.aw;
    }

    public String getUnitId() {
        return this.ah;
    }

    public int getVideoSkipTime() {
        return this.ab;
    }

    public void gonePlayingCloseView() {
        if (this.f && this.G.getVisibility() != 8) {
            this.G.setVisibility(8);
            this.ao = false;
        }
        if (this.aM || this.f5644ar || this.ap) {
            return;
        }
        this.aM = true;
        int i = this.ab;
        if (i >= 0) {
            if (i == 0) {
                this.f5644ar = true;
            } else {
                new Handler().postDelayed(new AnonymousClass11(), this.ab * 1000);
            }
        }
    }

    @Override // com.anythink.expressad.video.signal.j
    public void hideAlertView(int i) {
        if (this.V) {
            this.V = false;
            this.aB = true;
            setShowingAlertViewCover(false);
            com.anythink.expressad.videocommon.e.c.a().a(com.anythink.expressad.foundation.b.a.b().e(), this.ah, false);
            if (i == 0) {
                i();
                if (this.au) {
                    if (this.ay == com.anythink.expressad.foundation.g.a.cs || this.ay == com.anythink.expressad.foundation.g.a.cr) {
                        this.aC = true;
                        if (this.e != null) {
                            this.e.a(124, "");
                        }
                        this.aG = true;
                        gonePlayingCloseView();
                        return;
                    }
                    return;
                }
                return;
            }
            this.aD = true;
            if (this.au && this.ay == com.anythink.expressad.foundation.g.a.cs) {
                i();
            } else if (this.au && this.ay == com.anythink.expressad.foundation.g.a.cr) {
                if (this.e != null) {
                    this.e.a(2, b(this.aF));
                }
            } else if (this.e != null) {
                this.e.a(2, "");
            }
        }
    }

    @Override // com.anythink.expressad.video.module.AnythinkBaseView
    public void init(Context context) {
    }

    @Override // com.anythink.expressad.video.signal.j
    public boolean isH5Canvas() {
        return getLayoutParams().height < t.e(this.f5600a.getApplicationContext());
    }

    public boolean isInstallDialogShowing() {
        return this.W;
    }

    public boolean isMiniCardShowing() {
        return this.an;
    }

    public boolean isShowingAlertView() {
        return this.V;
    }

    public boolean isShowingTransparent() {
        return this.as;
    }

    public boolean isfront() {
        ViewGroup viewGroup = (ViewGroup) getParent();
        boolean z2 = false;
        if (viewGroup != null) {
            int indexOfChild = viewGroup.indexOfChild(this);
            int childCount = viewGroup.getChildCount();
            int i = indexOfChild + 1;
            boolean z3 = false;
            while (true) {
                z2 = z3;
                if (i > childCount - 1) {
                    break;
                } else if (viewGroup.getChildAt(i).getVisibility() == 0 && this.an) {
                    return false;
                } else {
                    i++;
                    z3 = true;
                }
            }
        }
        return z2;
    }

    @Override // com.anythink.expressad.video.signal.j
    public void notifyCloseBtn(int i) {
        if (i == 0) {
            this.ap = true;
            this.f5644ar = false;
        } else if (i == 1) {
            this.aq = true;
        }
    }

    public void notifyVideoClose() {
        this.e.a(2, "");
    }

    public void onBackPress() {
        if (this.an || this.V || this.aC) {
            return;
        }
        if (this.ao) {
            e();
        } else if (this.ap && this.aq) {
            e();
        } else if (this.ap || !this.f5644ar) {
        } else {
            e();
        }
    }

    @Override // com.anythink.expressad.video.module.AnythinkBaseView, android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if ((this.b == null || !this.b.j()) && this.f && this.ak) {
            l();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            if (this.aN != null) {
                getHandler().removeCallbacks(this.aN);
            }
        } catch (Throwable th) {
            o.d(TAG, th.getMessage());
        }
    }

    @Override // com.anythink.expressad.video.signal.f
    public void preLoadData(com.anythink.expressad.video.signal.factory.b bVar) {
        this.R = bVar;
        if (this.f) {
            if (!TextUtils.isEmpty(this.aa) && this.b != null) {
                if (this.b != null && w.b(this.b.U())) {
                    String U = this.b.U();
                    o.b(TAG, "AnythinkBaseView videoResolution:".concat(String.valueOf(U)));
                    String[] split = U.split("x");
                    if (split.length == 2) {
                        if (t.b(split[0]) > 0.0d) {
                            this.ai = t.b(split[0]);
                        }
                        if (t.b(split[1]) > 0.0d) {
                            this.aj = t.b(split[1]);
                        }
                        o.b(TAG, "AnythinkBaseView mVideoW:" + this.ai + "  mVideoH:" + this.aj);
                    }
                    if (this.ai <= 0.0d) {
                        this.ai = 1280.0d;
                    }
                    if (this.aj <= 0.0d) {
                        this.aj = 720.0d;
                    }
                }
                this.D.initBufferIngParam(this.ac);
                this.D.initVFPData(this.aa, this.b.S(), this.b.ao(), this.aL);
                soundOperate(this.aw, -1, null);
            }
        } else if (this.e != null) {
            this.e.a(12, "AnyThinkVideoView initSuccess false");
        }
        av = false;
    }

    @Override // com.anythink.expressad.video.signal.j
    public void progressBarOperate(int i) {
        ProgressBar progressBar;
        if (this.f) {
            if (i == 1) {
                ProgressBar progressBar2 = this.J;
                if (progressBar2 != null) {
                    progressBar2.setVisibility(8);
                }
            } else if (i != 2 || (progressBar = this.J) == null) {
            } else {
                progressBar.setVisibility(0);
            }
        }
    }

    @Override // com.anythink.expressad.video.signal.j
    public void progressOperate(int i, int i2) {
        if (this.f) {
            o.b(TAG, "progressOperate progress:".concat(String.valueOf(i)));
            int bi = this.b != null ? this.b.bi() : 0;
            if (i > 0 && i <= bi && this.D != null) {
                o.b(TAG, "progressOperate progress:".concat(String.valueOf(i)));
                this.D.seekTo(i * 1000);
            }
            if (i2 == 1) {
                this.F.setVisibility(8);
            } else if (i2 == 2) {
                this.F.setVisibility(0);
            }
            if (this.F.getVisibility() == 0) {
                n();
            }
        }
    }

    public void releasePlayer() {
        try {
            if (this.D != null && !this.am) {
                this.D.release();
            }
            if (this.aL != null) {
                this.aL.b();
            }
            if (this.U != null) {
                this.U = null;
            }
        } catch (Exception e) {
            o.d(TAG, e.getMessage());
        }
    }

    public void setBufferTimeout(int i) {
        this.ac = i;
    }

    public void setCTALayoutVisibleOrGone() {
        FrameLayout frameLayout;
        if (this.b != null && this.b.j() && (frameLayout = this.P) != null && this.S >= -1) {
            AnythinkClickCTAView anythinkClickCTAView = this.Q;
            if (anythinkClickCTAView == null && frameLayout != null) {
                if (anythinkClickCTAView == null) {
                    AnythinkClickCTAView anythinkClickCTAView2 = new AnythinkClickCTAView(getContext());
                    this.Q = anythinkClickCTAView2;
                    anythinkClickCTAView2.setCampaign(this.b);
                    this.Q.setUnitId(this.ah);
                    com.anythink.expressad.video.module.a.a aVar = this.U;
                    if (aVar != null) {
                        this.Q.setNotifyListener(new com.anythink.expressad.video.module.a.a.i(aVar));
                    }
                    this.Q.preLoadData(this.R);
                }
                this.P.addView(this.Q);
            }
            int i = this.S;
            if (i >= 0) {
                this.P.setVisibility(0);
            } else if (i == -1) {
                if (this.P.getVisibility() != 0) {
                    this.P.setVisibility(0);
                    postDelayed(this.aN, m.ag);
                    return;
                }
                this.P.setVisibility(8);
                getHandler().removeCallbacks(this.aN);
            }
        }
    }

    public void setCamPlayOrderCallback(com.anythink.expressad.video.dynview.f.a aVar, List<c> list, int i, int i2) {
        AnyThinkSegmentsProgressBar anyThinkSegmentsProgressBar;
        this.N = aVar;
        this.mCampaignSize = list.size();
        this.mCurrPlayNum = i;
        this.O = i2;
        this.mCampOrderViewData = list;
        if (this.b == null || this.b.k() != 5 || (anyThinkSegmentsProgressBar = this.M) == null || this.mCampOrderViewData == null) {
            return;
        }
        if (this.mCampaignSize <= 1) {
            anyThinkSegmentsProgressBar.setVisibility(8);
            return;
        }
        anyThinkSegmentsProgressBar.setVisibility(0);
        this.M.init(this.mCampaignSize, 2);
        for (int i3 = 0; i3 < this.mCampOrderViewData.size(); i3++) {
            int aF = this.mCampOrderViewData.get(i3).aF();
            if (aF > 0) {
                this.M.setProgress(aF, i3);
            }
        }
    }

    @Override // com.anythink.expressad.video.module.AnythinkBaseView
    public void setCampaign(c cVar) {
        super.setCampaign(cVar);
        b bVar = this.aL;
        if (bVar != null) {
            bVar.a(cVar);
            this.aL.a(cVar != null ? cVar.ao() != -1 ? cVar.ao() : com.anythink.expressad.videocommon.e.c.a().a(com.anythink.expressad.foundation.b.a.b().e(), this.ah, false).v() : com.anythink.expressad.videocommon.e.c.a().a(com.anythink.expressad.foundation.b.a.b().e(), this.ah, false).v(), com.anythink.expressad.videocommon.e.c.a().a(com.anythink.expressad.foundation.b.a.b().e(), this.ah, false).x());
        }
    }

    public void setCloseAlert(int i) {
        this.ad = i;
    }

    public void setContainerViewOnNotifyListener(com.anythink.expressad.video.module.a.a aVar) {
        this.U = aVar;
    }

    @Override // com.anythink.expressad.video.signal.j
    public void setCover(boolean z2) {
        if (this.f) {
            this.D.setIsCovered(z2);
        }
    }

    public void setDialogRole(int i) {
        boolean z2 = true;
        if (i != 1) {
            z2 = false;
        }
        this.aE = z2;
        o.d(TAG, i + " " + this.aE);
    }

    public void setIVRewardEnable(int i, int i2, int i3) {
        this.ay = i;
        this.az = i2;
        this.aA = i3;
    }

    @Override // com.anythink.expressad.video.signal.j
    public void setInstallDialogState(boolean z2) {
        this.W = z2;
        this.D.setIsCovered(z2);
    }

    public void setIsIV(boolean z2) {
        this.au = z2;
        b bVar = this.aL;
        if (bVar != null) {
            bVar.a(z2);
        }
    }

    @Override // com.anythink.expressad.video.signal.j
    public void setMiniEndCardState(boolean z2) {
        this.an = z2;
    }

    public void setNotchPadding(final int i, final int i2, final int i3, final int i4) {
        try {
            StringBuilder sb = new StringBuilder("NOTCH VideoView ");
            boolean z2 = false;
            sb.append(String.format("%1s-%2s-%3s-%4s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)));
            o.d(TAG, sb.toString());
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getLayoutParams();
            if (Math.max(Math.max(layoutParams.leftMargin, layoutParams.rightMargin), Math.max(layoutParams.topMargin, layoutParams.bottomMargin)) > Math.max(Math.max(i, i2), Math.max(i3, i4))) {
                z2 = true;
            }
            if (!z2 && this.H != null) {
                this.H.postDelayed(new Runnable() { // from class: com.anythink.expressad.video.module.AnythinkVideoView.12
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (AnythinkVideoView.this.H == null) {
                            return;
                        }
                        AnythinkVideoView.this.H.setVisibility(0);
                        if (AnythinkVideoView.this.b != null && !AnythinkVideoView.this.b.j() && AnythinkVideoView.this.b.f() != 2) {
                            AnythinkVideoView.this.H.setPadding(i, i3, i2, i4);
                            AnythinkVideoView.this.H.startAnimation(AnythinkVideoView.this.aJ);
                        }
                        AnythinkVideoView.this.H.setVisibility(0);
                    }
                }, 200L);
            }
            if (this.F.getVisibility() == 0) {
                n();
            }
        } catch (Exception e) {
            o.d(TAG, e.getMessage());
        }
    }

    public void setPlayURL(String str) {
        this.aa = str;
    }

    @Override // com.anythink.expressad.video.signal.j
    public void setScaleFitXY(int i) {
        this.at = i;
    }

    public void setShowingAlertViewCover(boolean z2) {
        this.D.setIsCovered(z2);
    }

    public void setShowingTransparent(boolean z2) {
        this.as = z2;
    }

    public void setSoundState(int i) {
        this.aw = i;
    }

    public void setUnitId(String str) {
        this.ah = str;
        b bVar = this.aL;
        if (bVar != null) {
            bVar.a(str);
        }
    }

    public void setVideoLayout(c cVar) {
        if (cVar != null) {
            this.b = cVar;
            this.i = cVar.j();
        }
        if (this.i) {
            new com.anythink.expressad.video.dynview.j.c();
            com.anythink.expressad.video.dynview.c a2 = com.anythink.expressad.video.dynview.j.c.a(this, cVar);
            com.anythink.expressad.video.dynview.b.a();
            com.anythink.expressad.video.dynview.b.a(a2, new AnonymousClass1(this, a2));
            return;
        }
        int findLayout = findLayout(s);
        if (findLayout > 0) {
            this.f5601c.inflate(findLayout, this);
            b();
        }
        av = false;
    }

    public void setVideoSkipTime(int i) {
        this.ab = i;
    }

    @Override // com.anythink.expressad.video.signal.j
    public void setVisible(int i) {
        setVisibility(i);
    }

    @Override // com.anythink.expressad.video.signal.j
    public void showAlertView() {
        if (this.an) {
            return;
        }
        if (this.ag == null) {
            this.ag = new com.anythink.expressad.widget.a.b() { // from class: com.anythink.expressad.video.module.AnythinkVideoView.9
                @Override // com.anythink.expressad.widget.a.b
                public final void a() {
                    AnythinkVideoView.h(AnythinkVideoView.this);
                    AnythinkVideoView anythinkVideoView = AnythinkVideoView.this;
                    anythinkVideoView.setShowingAlertViewCover(anythinkVideoView.V);
                    if (AnythinkVideoView.this.au && (AnythinkVideoView.this.ay == com.anythink.expressad.foundation.g.a.cs || AnythinkVideoView.this.ay == com.anythink.expressad.foundation.g.a.cr)) {
                        AnythinkVideoView.k(AnythinkVideoView.this);
                        if (AnythinkVideoView.this.e != null) {
                            AnythinkVideoView.this.e.a(124, "");
                        }
                        AnythinkVideoView.l(AnythinkVideoView.this);
                        AnythinkVideoView.this.gonePlayingCloseView();
                    }
                    AnythinkVideoView.this.i();
                }

                @Override // com.anythink.expressad.widget.a.b
                public final void b() {
                    AnythinkVideoView.h(AnythinkVideoView.this);
                    AnythinkVideoView.n(AnythinkVideoView.this);
                    AnythinkVideoView anythinkVideoView = AnythinkVideoView.this;
                    anythinkVideoView.setShowingAlertViewCover(anythinkVideoView.V);
                    if (AnythinkVideoView.this.au && AnythinkVideoView.this.ay == com.anythink.expressad.foundation.g.a.cr) {
                        if (AnythinkVideoView.this.e != null) {
                            com.anythink.expressad.video.module.a.a aVar = AnythinkVideoView.this.e;
                            AnythinkVideoView anythinkVideoView2 = AnythinkVideoView.this;
                            aVar.a(2, anythinkVideoView2.b(anythinkVideoView2.aF));
                        }
                    } else if (AnythinkVideoView.this.au && AnythinkVideoView.this.ay == com.anythink.expressad.foundation.g.a.cs) {
                        AnythinkVideoView.this.i();
                    } else if (AnythinkVideoView.this.e != null) {
                        AnythinkVideoView.this.e.a(2, "");
                    }
                }

                @Override // com.anythink.expressad.widget.a.b
                public final void c() {
                    a();
                }
            };
        }
        if (this.af == null) {
            this.af = new com.anythink.expressad.widget.a.a(getContext(), this.ag);
        }
        if (this.au) {
            this.af.a(this.ay, this.ah);
        } else {
            this.af.b();
        }
        PlayerView playerView = this.D;
        if (playerView == null || playerView.isComplete()) {
            return;
        }
        this.af.show();
        this.aB = true;
        this.V = true;
        setShowingAlertViewCover(true);
        com.anythink.expressad.videocommon.e.c.a().a(com.anythink.expressad.foundation.b.a.b().e(), this.ah, false);
        this.ax = d.J();
    }

    public void showBaitClickView() {
        int parseInt;
        if (this.b == null || !this.b.j() || this.b.M() == null) {
            return;
        }
        String e = this.b.M().e();
        if (TextUtils.isEmpty(e)) {
            return;
        }
        try {
            String a2 = x.a(e, "bait_click");
            if (TextUtils.isEmpty(a2) || (parseInt = Integer.parseInt(a2)) == 0 || this.aK == null) {
                return;
            }
            this.aK.setVisibility(0);
            this.aK.init(parseInt);
            this.aK.startAnimation();
            this.aK.setOnClickListener(new View.OnClickListener() { // from class: com.anythink.expressad.video.module.AnythinkVideoView.4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    Tracker.onClick(view);
                    if (AnythinkVideoView.this.e != null) {
                        AnythinkVideoView.this.e.a(1, "");
                    }
                }
            });
        } catch (Exception e2) {
            o.d(TAG, e2.getMessage());
        }
    }

    @Override // com.anythink.expressad.video.signal.j
    public void showIVRewardAlertView(String str) {
        this.e.a(8, "");
    }

    public void showMoreOfferInPlayTemplate() {
        if (this.b == null || this.T == null || !this.b.j() || this.b.M() == null || TextUtils.isEmpty(this.b.M().e())) {
        }
    }

    @Override // com.anythink.expressad.video.signal.j
    public void showVideoLocation(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        o.b(TAG, "showVideoLocation marginTop:" + i + " marginLeft:" + i2 + " width:" + i3 + "  height:" + i4 + " radius:" + i5 + " borderTop:" + i6 + " borderLeft:" + i7 + " borderWidth:" + i8 + " borderHeight:" + i9);
        if (this.f) {
            this.H.setPadding(0, 0, 0, 0);
            setVisibility(0);
            if (this.H.getVisibility() != 0) {
                this.H.setVisibility(0);
            }
            if (this.F.getVisibility() == 0) {
                n();
            }
            if (!(i3 > 0 && i4 > 0 && t.f(this.f5600a) >= i3 && t.e(this.f5600a) >= i4) || this.ak) {
                l();
                return;
            }
            y = i6;
            z = i7;
            A = i8 + 4;
            B = i9 + 4;
            float f = i3 / i4;
            float f2 = 0.0f;
            try {
                f2 = (float) (this.ai / this.aj);
            } catch (Throwable th) {
                o.b(TAG, th.getMessage(), th);
            }
            if (i5 > 0) {
                x = i5;
                if (i5 > 0) {
                    GradientDrawable gradientDrawable = new GradientDrawable();
                    gradientDrawable.setCornerRadius(t.b(getContext(), i5));
                    gradientDrawable.setColor(-1);
                    gradientDrawable.setStroke(1, 0);
                    if (Build.VERSION.SDK_INT >= 16) {
                        setBackground(gradientDrawable);
                        this.D.setBackground(gradientDrawable);
                    } else {
                        setBackgroundDrawable(gradientDrawable);
                        this.D.setBackgroundDrawable(gradientDrawable);
                    }
                    if (Build.VERSION.SDK_INT >= 21) {
                        setClipToOutline(true);
                        this.D.setClipToOutline(true);
                    }
                }
            }
            if (Math.abs(f - f2) > 0.1f && this.at != 1) {
                l();
                videoOperate(1);
                return;
            }
            l();
            if (!this.as) {
                setLayoutParam(i2, i, i3, i4);
                return;
            }
            setLayoutCenter(i3, i4);
            if (av) {
                this.e.a(114, "");
            } else {
                this.e.a(116, "");
            }
        }
    }

    @Override // com.anythink.expressad.video.signal.j
    public void soundOperate(int i, int i2) {
        soundOperate(i, i2, "2");
    }

    @Override // com.anythink.expressad.video.signal.j
    public void soundOperate(int i, int i2, String str) {
        SoundImageView soundImageView;
        if (this.f) {
            this.aw = i;
            if (i == 1) {
                SoundImageView soundImageView2 = this.E;
                if (soundImageView2 != null) {
                    soundImageView2.setSoundStatus(false);
                }
                this.D.closeSound();
            } else if (i == 2) {
                SoundImageView soundImageView3 = this.E;
                if (soundImageView3 != null) {
                    soundImageView3.setSoundStatus(true);
                }
                this.D.openSound();
            }
            if (this.b != null && this.b.j()) {
                SoundImageView soundImageView4 = this.E;
                if (soundImageView4 != null) {
                    soundImageView4.setVisibility(0);
                }
            } else if (i2 == 1) {
                SoundImageView soundImageView5 = this.E;
                if (soundImageView5 != null) {
                    soundImageView5.setVisibility(8);
                }
            } else if (i2 == 2 && (soundImageView = this.E) != null) {
                soundImageView.setVisibility(0);
            }
        }
        if (str == null || !str.equals("2") || this.e == null) {
            return;
        }
        this.e.a(7, Integer.valueOf(i));
    }

    @Override // com.anythink.expressad.video.signal.j
    public void videoOperate(int i) {
        o.a(TAG, "VideoView videoOperate:".concat(String.valueOf(i)));
        if (this.f) {
            if (i == 1) {
                if (getVisibility() == 0 && isfront()) {
                    o.a(TAG, "VideoView videoOperate:play");
                    if (this.V || this.an || this.W || com.anythink.expressad.foundation.f.b.f4978c) {
                        return;
                    }
                    i();
                }
            } else if (i == 2) {
                if (getVisibility() == 0) {
                    o.a(TAG, "VideoView videoOperate:pause");
                    h();
                }
            } else if (i == 3) {
                if (this.am) {
                    return;
                }
                this.D.release();
                this.am = true;
            } else if (i == 5) {
                this.W = true;
                if (this.am) {
                    return;
                }
                h();
            } else if (i == 4) {
                this.W = false;
                if (this.am || isMiniCardShowing()) {
                    return;
                }
                i();
            }
        }
    }
}
