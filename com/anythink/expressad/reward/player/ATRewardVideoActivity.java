package com.anythink.expressad.reward.player;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.provider.BrowserContract;
import android.text.TextUtils;
import android.widget.FrameLayout;
import com.anythink.core.common.a.j;
import com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView;
import com.anythink.expressad.foundation.h.i;
import com.anythink.expressad.foundation.h.o;
import com.anythink.expressad.foundation.h.t;
import com.anythink.expressad.video.bt.module.ATTempContainer;
import com.anythink.expressad.video.bt.module.AnythinkBTContainer;
import com.anythink.expressad.video.bt.module.b.h;
import com.anythink.expressad.video.dynview.h.b;
import com.anythink.expressad.video.signal.activity.AbstractJSActivity;
import com.anythink.expressad.videocommon.a;
import com.anythink.expressad.videocommon.b.c;
import com.anythink.expressad.videocommon.b.e;
import com.anythink.expressad.videocommon.b.n;
import com.anythink.expressad.videocommon.e.d;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import java.util.List;
import java.util.Map;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/reward/player/ATRewardVideoActivity.class */
public class ATRewardVideoActivity extends AbstractJSActivity {

    /* renamed from: a  reason: collision with root package name */
    public static String f8166a = "unitId";
    public static String b = "userId";

    /* renamed from: c  reason: collision with root package name */
    public static String f8167c = "reward";
    public static String d = "mute";
    public static String e = "isIV";
    public static String f = "isBid";
    public static String g = "isBigOffer";
    public static String h = "hasRelease";
    public static String i = "ivRewardMode";
    public static String j = "ivRewardValueType";
    public static String k = "ivRewardValue";
    public static String l = "extraData";
    public static String m = "baserequestInfo";
    private static final String p = "ATRewardVideoActivity";
    private h C;
    private d D;
    private c G;
    private com.anythink.expressad.foundation.d.c H;
    private List<c> I;
    private List<com.anythink.expressad.foundation.d.c> J;
    private ATTempContainer K;
    private AnythinkBTContainer L;
    private WindVaneWebView M;
    private com.anythink.expressad.video.bt.module.a.a N;
    private String O;
    private String P;
    private boolean Q;
    private String q;
    private String r;
    private String s;
    private com.anythink.expressad.videocommon.c.c t;
    private int x;
    private int y;
    private int z;
    private int u = 2;
    private boolean v = false;
    private boolean w = false;
    private boolean A = false;
    private boolean B = false;
    private boolean E = false;
    private boolean F = false;
    private int R = 1;
    private int S = 0;
    private int T = 0;
    private int U = 0;
    private int V = 0;
    private int W = 0;
    private int X = 0;
    private com.anythink.expressad.video.dynview.f.a Y = new com.anythink.expressad.video.dynview.f.a() { // from class: com.anythink.expressad.reward.player.ATRewardVideoActivity.1
        @Override // com.anythink.expressad.video.dynview.f.a
        public final void a(Map<String, Object> map) {
            if (map.containsKey("mute")) {
                ATRewardVideoActivity.this.u = ((Integer) map.get("mute")).intValue();
            }
            if (map.containsKey(BrowserContract.Bookmarks.POSITION)) {
                int intValue = ((Integer) map.get(BrowserContract.Bookmarks.POSITION)).intValue();
                if (ATRewardVideoActivity.this.J == null || ATRewardVideoActivity.this.J.size() <= 0 || intValue <= 0) {
                    return;
                }
                ATRewardVideoActivity aTRewardVideoActivity = ATRewardVideoActivity.this;
                aTRewardVideoActivity.H = (com.anythink.expressad.foundation.d.c) aTRewardVideoActivity.J.get(intValue);
                ATRewardVideoActivity.b(ATRewardVideoActivity.this);
                int i2 = intValue - 1;
                if (ATRewardVideoActivity.this.J.get(i2) != null) {
                    ATRewardVideoActivity aTRewardVideoActivity2 = ATRewardVideoActivity.this;
                    ATRewardVideoActivity.b(aTRewardVideoActivity2, ((com.anythink.expressad.foundation.d.c) aTRewardVideoActivity2.J.get(i2)).bi());
                }
                ATRewardVideoActivity aTRewardVideoActivity3 = ATRewardVideoActivity.this;
                ATRewardVideoActivity.this.H.b(aTRewardVideoActivity3.a(aTRewardVideoActivity3.H.i(), ATRewardVideoActivity.this.R));
                ATRewardVideoActivity aTRewardVideoActivity4 = ATRewardVideoActivity.this;
                aTRewardVideoActivity4.b(aTRewardVideoActivity4.H);
            }
        }
    };
    private com.anythink.expressad.video.dynview.f.d Z = new com.anythink.expressad.video.dynview.f.d() { // from class: com.anythink.expressad.reward.player.ATRewardVideoActivity.2
        @Override // com.anythink.expressad.video.dynview.f.d
        public final void a() {
            if (ATRewardVideoActivity.this.L != null) {
                new b().d(ATRewardVideoActivity.this.L);
            }
            ATRewardVideoActivity.f(ATRewardVideoActivity.this);
            ATRewardVideoActivity.this.b();
            if (ATRewardVideoActivity.this.K != null) {
                ATRewardVideoActivity.this.K.setNotchPadding(ATRewardVideoActivity.this.X, ATRewardVideoActivity.this.T, ATRewardVideoActivity.this.V, ATRewardVideoActivity.this.U, ATRewardVideoActivity.this.W);
            }
        }

        @Override // com.anythink.expressad.video.dynview.f.d
        public final void a(com.anythink.expressad.foundation.d.c cVar) {
            if (cVar == null) {
                ATRewardVideoActivity.this.b("campaign is null");
                return;
            }
            if (ATRewardVideoActivity.this.L != null) {
                new b().d(ATRewardVideoActivity.this.L);
            }
            ATRewardVideoActivity.this.H = cVar;
            ATRewardVideoActivity aTRewardVideoActivity = ATRewardVideoActivity.this;
            aTRewardVideoActivity.b(aTRewardVideoActivity.H);
        }
    };

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/reward/player/ATRewardVideoActivity$a.class */
    static final class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final List<c> f8172a;
        private final String b;

        /* renamed from: c  reason: collision with root package name */
        private final String f8173c;

        public a(List<c> list, String str, String str2) {
            this.f8172a = list;
            this.b = str;
            this.f8173c = str2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                if (this.f8172a == null || this.f8172a.size() <= 0) {
                    return;
                }
                for (c cVar : this.f8172a) {
                    if (cVar != null && cVar.n() != null) {
                        com.anythink.expressad.foundation.d.c n = cVar.n();
                        String str = n.Z() + n.aZ() + n.S();
                        n c2 = e.a().c(this.b);
                        if (c2 != null) {
                            try {
                                c2.b(str);
                            } catch (Exception e) {
                            }
                        }
                        if (n != null && n.M() != null) {
                            if (!TextUtils.isEmpty(n.M().e())) {
                                com.anythink.expressad.videocommon.a.b(this.b + BridgeUtil.UNDERLINE_STR + n.aZ() + BridgeUtil.UNDERLINE_STR + this.f8173c + BridgeUtil.UNDERLINE_STR + n.M().e());
                                com.anythink.expressad.videocommon.a.b(n.w(), n);
                            }
                            if (!TextUtils.isEmpty(n.ar())) {
                                com.anythink.expressad.videocommon.a.b(this.b + BridgeUtil.UNDERLINE_STR + this.f8173c + BridgeUtil.UNDERLINE_STR + n.ar());
                            }
                        }
                    }
                }
            } catch (Exception e2) {
                o.a(ATRewardVideoActivity.p, e2.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(int i2, int i3) {
        int i4;
        int i5;
        int i6;
        List<com.anythink.expressad.foundation.d.c> list = this.J;
        if (list != null && list.size() != 0) {
            int i7 = 0;
            int i8 = 0;
            int i9 = 0;
            while (true) {
                i4 = i9;
                if (i7 >= this.J.size()) {
                    break;
                }
                int i10 = i8;
                int i11 = i4;
                if (this.J.get(0) != null) {
                    if (i7 == 0) {
                        i4 = this.J.get(0).i();
                    }
                    i10 = i8 + this.J.get(i7).bi();
                    i11 = i4;
                }
                i7++;
                i8 = i10;
                i9 = i11;
            }
            if (i3 == 1) {
                if (i2 == 0) {
                    if (i8 >= 45) {
                        return 45;
                    }
                } else if (i8 > i2) {
                    i6 = i2;
                    if (i2 > 45) {
                        return 45;
                    }
                }
                return i8;
            }
            int i12 = 0;
            int i13 = 0;
            while (true) {
                i5 = i13;
                if (i12 >= i3 - 1) {
                    break;
                }
                int i14 = i5;
                if (this.J.get(i12) != null) {
                    i14 = i5 + this.J.get(i12).bi();
                }
                i12++;
                i13 = i14;
            }
            if (i4 > i5) {
                return i4 - i5;
            }
            i6 = 0;
            return i6;
        }
        return i2;
    }

    private static WindVaneWebView a(String str) {
        a.C0164a a2 = com.anythink.expressad.videocommon.a.a(str);
        if (a2 != null) {
            return a2.a();
        }
        return null;
    }

    private void a(int i2) {
        try {
            if (this.H == null || this.H.f() != 2) {
                return;
            }
            getWindow().getDecorView().setBackgroundDrawable(new ColorDrawable(0));
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.K.getLayoutParams();
            int b2 = t.b(this, 58.0f);
            int b3 = t.b(this, 104.0f);
            if (this.H.M().c() == 0) {
                if (i2 == 2) {
                    layoutParams.setMargins(b3, b2, b3, b2);
                } else {
                    layoutParams.setMargins(b2, b3, b2, b3);
                }
            } else if (this.H.M().c() == 2) {
                layoutParams.setMargins(b3, b2, b3, b2);
            } else {
                layoutParams.setMargins(b2, b3, b2, b3);
            }
            this.K.setLayoutParams(layoutParams);
        } catch (Throwable th) {
            o.d(p, th.getMessage());
        }
    }

    private void a(com.anythink.expressad.foundation.d.c cVar) {
        if (cVar == null) {
            b("campaign is less");
            return;
        }
        int a2 = a(cVar.i(), this.R);
        this.H = cVar;
        cVar.m();
        this.R = 1;
        this.H.b(a2);
        b(this.H);
    }

    private void a(List<com.anythink.expressad.foundation.d.c> list) {
        if (list == null) {
            b("no available campaign");
        } else if (list.size() == 0) {
            b("no available campaign");
        } else {
            if ((list.get(0) != null ? list.get(0).k() : 0) != 5) {
                c();
                return;
            }
            for (com.anythink.expressad.foundation.d.c cVar : list) {
                if (cVar != null) {
                    this.S += cVar.bi();
                }
            }
            com.anythink.expressad.foundation.d.c cVar2 = list.get(0);
            if (cVar2 == null) {
                b("campaign is less");
                return;
            }
            int a2 = a(cVar2.i(), this.R);
            this.H = cVar2;
            cVar2.m();
            this.R = 1;
            this.H.b(a2);
            b(this.H);
        }
    }

    static /* synthetic */ int b(ATRewardVideoActivity aTRewardVideoActivity) {
        int i2 = aTRewardVideoActivity.R;
        aTRewardVideoActivity.R = i2 + 1;
        return i2;
    }

    static /* synthetic */ int b(ATRewardVideoActivity aTRewardVideoActivity, int i2) {
        int i3 = aTRewardVideoActivity.S - i2;
        aTRewardVideoActivity.S = i3;
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0174, code lost:
        if (r0 == null) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x01a8, code lost:
        if (r7 != null) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x01b2, code lost:
        if (android.text.TextUtils.isEmpty(r7.b()) != false) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x01b9, code lost:
        if (r7.a() <= 0) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x01bc, code lost:
        r0 = new com.anythink.expressad.videocommon.c.c(r7.b(), r7.a());
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x01d0, code lost:
        if (r0.b() >= 0) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x01d3, code lost:
        r0.a(1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x01d8, code lost:
        r5.t = r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void b() {
        /*
            Method dump skipped, instructions count: 548
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.reward.player.ATRewardVideoActivity.b():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.anythink.expressad.foundation.d.c cVar) {
        com.anythink.expressad.foundation.d.c n;
        try {
            if (this.I != null && this.I.size() > 0) {
                for (c cVar2 : this.I) {
                    if (cVar2 != null && (n = cVar2.n()) != null && TextUtils.equals(n.aZ(), cVar.aZ()) && TextUtils.equals(n.Z(), cVar.Z())) {
                        this.G = cVar2;
                    }
                }
            }
            this.A = true;
            b();
            if (this.K != null) {
                this.K.setNotchPadding(this.X, this.T, this.V, this.U, this.W);
            }
        } catch (Exception e2) {
            o.d(p, e2.getMessage());
            b("more offer to one offer exception");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        o.d(p, str);
        h hVar = this.C;
        if (hVar != null) {
            hVar.a(str);
        }
        finish();
    }

    private int c(String str) {
        return i.a(getApplicationContext(), str, "id");
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x00c2, code lost:
        if (r0 == null) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x00e4, code lost:
        if (r7 != null) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x00ee, code lost:
        if (android.text.TextUtils.isEmpty(r7.b()) != false) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x00f5, code lost:
        if (r7.a() <= 0) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x00f8, code lost:
        r0 = new com.anythink.expressad.videocommon.c.c(r7.b(), r7.a());
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x010c, code lost:
        if (r0.b() >= 0) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x010f, code lost:
        r0.a(1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0114, code lost:
        r5.t = r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void c() {
        /*
            Method dump skipped, instructions count: 363
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.reward.player.ATRewardVideoActivity.c():void");
    }

    private static void c(com.anythink.expressad.foundation.d.c cVar) {
        if (cVar != null) {
            if (!TextUtils.isEmpty(cVar.be())) {
                com.anythink.expressad.foundation.g.d.b.a(com.anythink.core.common.b.n.a().g()).c(cVar.be());
            }
            if (TextUtils.isEmpty(cVar.bd())) {
                return;
            }
            com.anythink.expressad.foundation.g.d.b.a(com.anythink.core.common.b.n.a().g()).c(cVar.bd());
        }
    }

    private int d(String str) {
        return i.a(getApplicationContext(), str, "layout");
    }

    private com.anythink.expressad.video.bt.module.a.a d() {
        if (this.N == null) {
            this.N = new com.anythink.expressad.video.bt.module.a.a() { // from class: com.anythink.expressad.reward.player.ATRewardVideoActivity.3
                @Override // com.anythink.expressad.video.bt.module.a.a
                public final void a() {
                    if (ATRewardVideoActivity.this.C != null) {
                        ATRewardVideoActivity.this.C.a();
                    }
                }

                @Override // com.anythink.expressad.video.bt.module.a.a
                public final void a(com.anythink.expressad.foundation.d.c cVar) {
                    if (ATRewardVideoActivity.this.C != null) {
                        ATRewardVideoActivity.this.C.a(cVar);
                    }
                }

                @Override // com.anythink.expressad.video.bt.module.a.a
                public final void a(String str) {
                    if (ATRewardVideoActivity.this.C != null) {
                        ATRewardVideoActivity.this.C.a(str);
                    }
                }

                @Override // com.anythink.expressad.video.bt.module.a.a
                public final void a(boolean z, int i2) {
                    if (ATRewardVideoActivity.this.C != null) {
                        ATRewardVideoActivity.this.C.a(z, i2);
                    }
                }

                @Override // com.anythink.expressad.video.bt.module.a.a
                public final void a(boolean z, com.anythink.expressad.videocommon.c.c cVar) {
                    if (ATRewardVideoActivity.this.C != null) {
                        ATRewardVideoActivity.this.C.a(z, cVar);
                    }
                }

                @Override // com.anythink.expressad.video.bt.module.a.a
                public final void b() {
                    if (ATRewardVideoActivity.this.C != null) {
                        ATRewardVideoActivity.this.C.b();
                    }
                }

                @Override // com.anythink.expressad.video.bt.module.a.a
                public final void c() {
                    if (ATRewardVideoActivity.this.C != null) {
                        ATRewardVideoActivity.this.C.c();
                    }
                }
            };
        }
        return this.N;
    }

    private void e() {
        try {
            if (this.J != null && this.J.size() > 0) {
                for (com.anythink.expressad.foundation.d.c cVar : this.J) {
                    c(cVar);
                }
            }
            if (this.H != null) {
                c(this.H);
            }
        } catch (Throwable th) {
            o.d(p, th.getMessage());
        }
    }

    static /* synthetic */ boolean f(ATRewardVideoActivity aTRewardVideoActivity) {
        aTRewardVideoActivity.A = true;
        return true;
    }

    @Override // com.anythink.expressad.activity.ATBaseActivity
    public final void a(int i2, int i3, int i4, int i5, int i6) {
        this.T = i3;
        this.V = i4;
        this.U = i5;
        this.W = i6;
        this.X = i2;
        ATTempContainer aTTempContainer = this.K;
        if (aTTempContainer != null) {
            aTTempContainer.setNotchPadding(i2, i3, i4, i5, i6);
        }
        AnythinkBTContainer anythinkBTContainer = this.L;
        if (anythinkBTContainer != null) {
            anythinkBTContainer.setNotchPadding(i2, i3, i4, i5, i6);
        }
        com.anythink.expressad.video.dynview.a.b.e = i2;
        com.anythink.expressad.video.dynview.a.b.f8349a = i3;
        com.anythink.expressad.video.dynview.a.b.b = i4;
        com.anythink.expressad.video.dynview.a.b.f8350c = i5;
        com.anythink.expressad.video.dynview.a.b.d = i6;
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        int a2 = i.a(this, "anythink_reward_activity_close", i.f);
        int a3 = i.a(this, "anythink_reward_activity_stay", i.f);
        if (a2 > 1 && a3 > 1) {
            overridePendingTransition(a3, a2);
        }
        ATTempContainer aTTempContainer = this.K;
        if (aTTempContainer != null) {
            aTTempContainer.onDestroy();
            this.K = null;
        }
        AnythinkBTContainer anythinkBTContainer = this.L;
        if (anythinkBTContainer != null) {
            anythinkBTContainer.onDestroy();
            this.L = null;
        }
        com.anythink.expressad.foundation.f.b a4 = com.anythink.expressad.foundation.f.b.a();
        a4.c(this.q + "_1");
        com.anythink.expressad.foundation.f.b a5 = com.anythink.expressad.foundation.f.b.a();
        a5.c(this.q + "_2");
    }

    @Override // com.anythink.expressad.video.signal.activity.AbstractJSActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        ATTempContainer aTTempContainer = this.K;
        if (aTTempContainer != null) {
            aTTempContainer.onBackPressed();
        }
        AnythinkBTContainer anythinkBTContainer = this.L;
        if (anythinkBTContainer != null) {
            anythinkBTContainer.onBackPressed();
        }
    }

    @Override // com.anythink.expressad.video.signal.activity.AbstractJSActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.K != null) {
            a(configuration.orientation);
            this.K.onConfigurationChanged(configuration);
        }
        AnythinkBTContainer anythinkBTContainer = this.L;
        if (anythinkBTContainer != null) {
            anythinkBTContainer.onConfigurationChanged(configuration);
        }
    }

    @Override // com.anythink.expressad.activity.ATBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.anythink.expressad.a.x = true;
        com.anythink.expressad.foundation.b.a.b().b(this);
        try {
            Intent intent = getIntent();
            this.q = intent.getStringExtra(f8166a);
            int a2 = i.a(getApplicationContext(), "anythink_more_offer_activity", "layout");
            if (a2 < 0) {
                b("no anythink_more_offer_activity layout");
                return;
            }
            setContentView(a2);
            if (TextUtils.isEmpty(this.q)) {
                b("data empty error");
                return;
            }
            this.C = com.anythink.expressad.reward.b.a.f8156c.get(this.q);
            this.r = intent.getStringExtra(com.anythink.expressad.a.y);
            this.t = com.anythink.expressad.videocommon.c.c.b(intent.getStringExtra(f8167c));
            this.s = intent.getStringExtra(b);
            this.u = intent.getIntExtra(d, 2);
            this.v = intent.getBooleanExtra(e, false);
            this.w = intent.getBooleanExtra(f, false);
            this.P = intent.getStringExtra(l);
            if (this.v) {
                this.x = intent.getIntExtra(i, 0);
                this.y = intent.getIntExtra(j, 0);
                this.z = intent.getIntExtra(k, 0);
            }
            this.o = new com.anythink.expressad.video.signal.factory.b(this);
            a(this.o);
            if (this.C == null) {
                b("showRewardListener is null");
                return;
            }
            d a3 = com.anythink.expressad.reward.a.e.a().a(this.r, this.q);
            this.D = a3;
            if (a3 == null) {
                d a4 = com.anythink.expressad.videocommon.e.c.a().a(com.anythink.expressad.foundation.b.a.b().e(), this.q);
                this.D = a4;
                if (a4 == null) {
                    this.D = com.anythink.expressad.videocommon.e.c.a().a(com.anythink.expressad.foundation.b.a.b().e(), this.q, this.v);
                }
            }
            if (this.D != null) {
                this.t.a(this.D.m());
                this.t.a(this.D.n());
            }
            if (this.t != null && this.t.b() <= 0) {
                this.t.a(1);
            }
            int a5 = i.a(this, "anythink_reward_activity_open", i.f);
            int a6 = i.a(this, "anythink_reward_activity_stay", i.f);
            if (a5 > 1 && a6 > 1) {
                overridePendingTransition(a5, a6);
            }
            if (bundle != null) {
                try {
                    this.F = bundle.getBoolean(h);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            this.I = e.a().b(this.q);
            boolean booleanExtra = intent.getBooleanExtra(g, false);
            this.A = booleanExtra;
            if (!booleanExtra) {
                if (this.I != null && this.I.size() > 0) {
                    this.G = this.I.get(0);
                }
                if (this.G != null) {
                    this.H = this.G.n();
                    this.G.a(true);
                    this.G.b(false);
                }
                if (this.G == null || this.H == null || this.t == null) {
                    b("data empty error");
                }
                b();
                return;
            }
            List<com.anythink.expressad.foundation.d.c> a7 = e.a().a(this.q);
            this.J = a7;
            this.O = "";
            String str = "";
            if (a7 != null) {
                str = "";
                if (a7.size() > 0) {
                    com.anythink.expressad.foundation.d.c cVar = this.J.get(0);
                    str = cVar.ar();
                    this.O = cVar.Z();
                }
            }
            a.C0164a a8 = com.anythink.expressad.videocommon.a.a(this.q + BridgeUtil.UNDERLINE_STR + this.O + BridgeUtil.UNDERLINE_STR + str);
            WindVaneWebView a9 = a8 != null ? a8.a() : null;
            this.M = a9;
            if (a9 != null) {
                c();
                return;
            }
            if (this.G == null && this.I != null && this.I.size() > 0) {
                this.G = this.I.get(0);
            }
            if (this.G == null) {
                e a10 = e.a();
                int i2 = this.v ? 287 : 94;
                String str2 = this.q;
                boolean z = this.w;
                n c2 = a10.c(str2);
                c cVar2 = null;
                if (c2 != null) {
                    cVar2 = c2.b(i2, z);
                }
                this.G = cVar2;
            }
            if (this.G != null) {
                this.H = this.G.n();
                this.G.a(true);
                this.G.b(false);
            }
            if (this.G == null || this.H == null || this.t == null) {
                b("data empty error");
            }
            this.A = false;
            com.anythink.expressad.videocommon.a.a.a();
            List<com.anythink.expressad.foundation.d.c> a11 = com.anythink.expressad.videocommon.a.a.a(this.J);
            if (a11 == null) {
                b("no available campaign");
                return;
            }
            int size = a11.size();
            if (size == 0) {
                b("no available campaign");
            } else if (a11.get(0) == null || !a11.get(0).j()) {
                b();
            } else if (size != 1) {
                a(a11);
            } else {
                com.anythink.expressad.foundation.d.c cVar3 = a11.get(0);
                this.H = cVar3;
                if (cVar3 != null) {
                    cVar3.m();
                }
                b(this.H);
            }
        } catch (Throwable th) {
            b("onCreate error".concat(String.valueOf(th)));
        }
    }

    @Override // com.anythink.expressad.video.signal.activity.AbstractJSActivity, com.anythink.expressad.activity.ATBaseActivity, android.app.Activity
    public void onDestroy() {
        try {
            super.onDestroy();
        } catch (Throwable th) {
        }
        try {
            if (this.J != null && this.J.size() > 0) {
                for (com.anythink.expressad.foundation.d.c cVar : this.J) {
                    c(cVar);
                }
            }
            if (this.H != null) {
                c(this.H);
            }
        } catch (Throwable th2) {
            o.d(p, th2.getMessage());
        }
        com.anythink.expressad.video.module.b.a.a(this.q);
        ATTempContainer aTTempContainer = this.K;
        if (aTTempContainer != null) {
            aTTempContainer.onDestroy();
            this.K = null;
        }
        AnythinkBTContainer anythinkBTContainer = this.L;
        if (anythinkBTContainer != null) {
            anythinkBTContainer.onDestroy();
            this.L = null;
        }
        this.Y = null;
        this.Z = null;
        com.anythink.expressad.foundation.g.h.a.a().execute(new a(this.I, this.q, this.O));
        List<com.anythink.expressad.foundation.d.c> list = this.J;
        com.anythink.expressad.foundation.d.c cVar2 = null;
        if (list != null) {
            cVar2 = null;
            if (list.size() > 0) {
                cVar2 = this.J.get(0);
            }
        }
        com.anythink.expressad.foundation.d.c cVar3 = cVar2;
        if (cVar2 == null) {
            cVar3 = this.H;
        }
        if (cVar3 == null || TextUtils.isEmpty(cVar3.S())) {
            return;
        }
        j.a().b();
    }

    @Override // com.anythink.expressad.video.signal.activity.AbstractJSActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        ATTempContainer aTTempContainer = this.K;
        if (aTTempContainer != null) {
            aTTempContainer.onPause();
        }
        AnythinkBTContainer anythinkBTContainer = this.L;
        if (anythinkBTContainer != null) {
            anythinkBTContainer.onPause();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onRestart() {
        super.onRestart();
        ATTempContainer aTTempContainer = this.K;
        if (aTTempContainer != null) {
            aTTempContainer.onRestart();
        }
        AnythinkBTContainer anythinkBTContainer = this.L;
        if (anythinkBTContainer != null) {
            anythinkBTContainer.onRestart();
        }
    }

    @Override // com.anythink.expressad.video.signal.activity.AbstractJSActivity, com.anythink.expressad.activity.ATBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (com.anythink.expressad.foundation.f.b.f7818c) {
            return;
        }
        com.anythink.expressad.foundation.b.a.b().b(this);
        ATTempContainer aTTempContainer = this.K;
        if (aTTempContainer != null) {
            aTTempContainer.onResume();
        }
        AnythinkBTContainer anythinkBTContainer = this.L;
        if (anythinkBTContainer != null) {
            anythinkBTContainer.onResume();
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putBoolean(h, this.F);
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onStart() {
        super.onStart();
        new com.anythink.expressad.foundation.f.a() { // from class: com.anythink.expressad.reward.player.ATRewardVideoActivity.4
            @Override // com.anythink.expressad.foundation.f.a
            public final void a() {
                ATRewardVideoActivity.this.onPause();
            }

            @Override // com.anythink.expressad.foundation.f.a
            public final void b() {
                ATRewardVideoActivity.this.onResume();
            }

            @Override // com.anythink.expressad.foundation.f.a
            public final void c() {
                ATRewardVideoActivity.this.onResume();
            }
        };
        if (com.anythink.expressad.foundation.f.b.f7818c) {
            return;
        }
        ATTempContainer aTTempContainer = this.K;
        if (aTTempContainer != null) {
            aTTempContainer.onStart();
            this.H.l(this.q);
            com.anythink.expressad.foundation.f.b a2 = com.anythink.expressad.foundation.f.b.a();
            a2.a(this.q + "_1", this.H);
        }
        AnythinkBTContainer anythinkBTContainer = this.L;
        if (anythinkBTContainer != null) {
            anythinkBTContainer.onStart();
            List<com.anythink.expressad.foundation.d.c> list = this.J;
            if (list != null && list.size() > 0) {
                com.anythink.expressad.foundation.d.c cVar = this.J.get(0);
                cVar.l(this.q);
                com.anythink.expressad.foundation.f.b a3 = com.anythink.expressad.foundation.f.b.a();
                a3.a(this.q + "_1", cVar);
            }
        }
        if (this.Q) {
            return;
        }
        com.anythink.expressad.foundation.f.b a4 = com.anythink.expressad.foundation.f.b.a();
        a4.b(this.q + "_1", 1);
        com.anythink.expressad.foundation.f.b a5 = com.anythink.expressad.foundation.f.b.a();
        a5.c(this.q + "_2");
        this.Q = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onStop() {
        com.anythink.expressad.a.x = false;
        try {
            super.onStop();
        } catch (Throwable th) {
        }
        ATTempContainer aTTempContainer = this.K;
        if (aTTempContainer != null) {
            aTTempContainer.onStop();
        }
        AnythinkBTContainer anythinkBTContainer = this.L;
        if (anythinkBTContainer != null) {
            anythinkBTContainer.onStop();
        }
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public void setTheme(int i2) {
        super.setTheme(i.a(this, "anythink_transparent_theme", "style"));
    }
}
