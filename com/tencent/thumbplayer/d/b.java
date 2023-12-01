package com.tencent.thumbplayer.d;

import android.os.SystemClock;
import com.tencent.thumbplayer.api.TPDrmInfo;
import com.tencent.thumbplayer.api.TPTrackInfo;
import com.tencent.thumbplayer.core.player.TPDynamicStatisticParams;
import com.tencent.thumbplayer.core.player.TPGeneralPlayFlowParams;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/d/b.class */
public class b {

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/d/b$a.class */
    public static class a {
        private long b = SystemClock.elapsedRealtime();

        /* renamed from: c  reason: collision with root package name */
        private long f25591c = System.currentTimeMillis();

        /* renamed from: a  reason: collision with root package name */
        private int f25590a = -1;

        public int a() {
            return this.f25590a;
        }

        protected void a(int i) {
            this.f25590a = i;
        }

        public long b() {
            return this.b;
        }

        public long c() {
            return this.f25591c;
        }
    }

    /* renamed from: com.tencent.thumbplayer.d.b$b  reason: collision with other inner class name */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/d/b$b.class */
    public static class C0848b extends a {
        public C0848b() {
            a(112);
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/d/b$c.class */
    public static class c extends a {
        public c() {
            a(111);
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/d/b$d.class */
    public static class d extends a {

        /* renamed from: a  reason: collision with root package name */
        private String f25592a;
        private String b;

        public d() {
            a(202);
        }

        public void a(String str) {
            this.f25592a = str;
        }

        public void b(String str) {
            this.b = str;
        }

        public String d() {
            return this.f25592a;
        }

        public String e() {
            return this.b;
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/d/b$e.class */
    public static class e extends a {

        /* renamed from: a  reason: collision with root package name */
        private int f25593a;

        public e() {
            a(201);
        }

        public void b(int i) {
            this.f25593a = i;
        }

        public int d() {
            return this.f25593a;
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/d/b$f.class */
    public static class f extends a {

        /* renamed from: a  reason: collision with root package name */
        private String f25594a;
        private String b;

        public f() {
            a(203);
        }

        public void a(String str) {
            this.f25594a = str;
        }

        public void b(String str) {
            this.b = str;
        }

        public String d() {
            return this.f25594a;
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/d/b$g.class */
    public static class g extends a {
        public g() {
            a(204);
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/d/b$h.class */
    public static class h extends a {

        /* renamed from: a  reason: collision with root package name */
        private TPDrmInfo f25595a;

        public h() {
            a(116);
        }

        public void a(TPDrmInfo tPDrmInfo) {
            this.f25595a = tPDrmInfo;
        }

        public TPDrmInfo d() {
            return this.f25595a;
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/d/b$i.class */
    public static class i extends a {

        /* renamed from: a  reason: collision with root package name */
        private int f25596a;
        private int b;

        /* renamed from: c  reason: collision with root package name */
        private TPGeneralPlayFlowParams f25597c;
        private TPDynamicStatisticParams d;

        public i() {
            a(106);
        }

        public void a(TPDynamicStatisticParams tPDynamicStatisticParams) {
            this.d = tPDynamicStatisticParams;
        }

        public void a(TPGeneralPlayFlowParams tPGeneralPlayFlowParams) {
            this.f25597c = tPGeneralPlayFlowParams;
        }

        public void b(int i) {
            this.f25596a = i;
        }

        public void c(int i) {
            this.b = i;
        }

        public int d() {
            return this.f25596a;
        }

        public int e() {
            return this.b;
        }

        public TPGeneralPlayFlowParams f() {
            return this.f25597c;
        }

        public TPDynamicStatisticParams g() {
            return this.d;
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/d/b$j.class */
    public static class j extends a {
        public j() {
            a(104);
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/d/b$k.class */
    public static class k extends a {
        public k() {
            a(108);
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/d/b$l.class */
    public static class l extends a {

        /* renamed from: a  reason: collision with root package name */
        private TPGeneralPlayFlowParams f25598a;
        private TPDynamicStatisticParams b;

        public l() {
            a(107);
        }

        public void a(TPDynamicStatisticParams tPDynamicStatisticParams) {
            this.b = tPDynamicStatisticParams;
        }

        public void a(TPGeneralPlayFlowParams tPGeneralPlayFlowParams) {
            this.f25598a = tPGeneralPlayFlowParams;
        }

        public TPGeneralPlayFlowParams d() {
            return this.f25598a;
        }

        public TPDynamicStatisticParams e() {
            return this.b;
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/d/b$m.class */
    public static class m extends a {
        public m() {
            a(103);
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/d/b$n.class */
    public static class n extends a {

        /* renamed from: a  reason: collision with root package name */
        private TPGeneralPlayFlowParams f25599a;
        private TPDynamicStatisticParams b;

        public n() {
            a(105);
        }

        public void a(TPDynamicStatisticParams tPDynamicStatisticParams) {
            this.b = tPDynamicStatisticParams;
        }

        public void a(TPGeneralPlayFlowParams tPGeneralPlayFlowParams) {
            this.f25599a = tPGeneralPlayFlowParams;
        }

        public TPGeneralPlayFlowParams d() {
            return this.f25599a;
        }

        public TPDynamicStatisticParams e() {
            return this.b;
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/d/b$o.class */
    public static class o extends a {

        /* renamed from: a  reason: collision with root package name */
        private long f25600a;
        private int b;

        public o() {
            a(102);
        }

        public void a(long j) {
            this.f25600a = j;
        }

        public void b(int i) {
            this.b = i;
        }

        public long d() {
            return this.f25600a;
        }

        public int e() {
            return this.b;
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/d/b$p.class */
    public static class p extends a {

        /* renamed from: a  reason: collision with root package name */
        private String f25601a = "";

        public p() {
            a(101);
        }

        public void a(String str) {
            this.f25601a = str;
        }

        public String d() {
            return this.f25601a;
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/d/b$q.class */
    public static class q extends a {
        public q() {
            a(110);
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/d/b$r.class */
    public static class r extends a {
        public r() {
            a(109);
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/d/b$s.class */
    public static class s extends a {

        /* renamed from: a  reason: collision with root package name */
        private int f25602a;
        private long b;

        public s() {
            a(115);
        }

        public void a(long j) {
            this.b = j;
        }

        public void b(int i) {
            this.f25602a = i;
        }

        public int d() {
            return this.f25602a;
        }

        public long e() {
            return this.b;
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/d/b$t.class */
    public static class t extends a {

        /* renamed from: a  reason: collision with root package name */
        private int f25603a;
        private long b;

        /* renamed from: c  reason: collision with root package name */
        private TPTrackInfo f25604c;

        public t() {
            a(114);
        }

        public void a(long j) {
            this.b = j;
        }

        public void a(TPTrackInfo tPTrackInfo) {
            this.f25604c = tPTrackInfo;
        }

        public void b(int i) {
            this.f25603a = i;
        }

        public int d() {
            return this.f25603a;
        }

        public long e() {
            return this.b;
        }

        public TPTrackInfo f() {
            return this.f25604c;
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/d/b$u.class */
    public static class u extends a {

        /* renamed from: a  reason: collision with root package name */
        private String f25605a;
        private boolean b;

        /* renamed from: c  reason: collision with root package name */
        private int f25606c;

        public u() {
            a(117);
        }

        public void a(String str) {
            this.f25605a = str;
        }

        public void a(boolean z) {
            this.b = z;
        }

        public void b(int i) {
            this.f25606c = i;
        }

        public String d() {
            return this.f25605a;
        }

        public boolean e() {
            return this.b;
        }

        public int f() {
            return this.f25606c;
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/d/b$v.class */
    public static class v extends a {

        /* renamed from: a  reason: collision with root package name */
        private float f25607a;

        public v() {
            a(113);
        }

        public void a(float f) {
            this.f25607a = f;
        }

        public float d() {
            return this.f25607a;
        }
    }
}
