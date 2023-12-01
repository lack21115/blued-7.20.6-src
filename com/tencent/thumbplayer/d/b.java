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
        private long f39282c = System.currentTimeMillis();

        /* renamed from: a  reason: collision with root package name */
        private int f39281a = -1;

        public int a() {
            return this.f39281a;
        }

        protected void a(int i) {
            this.f39281a = i;
        }

        public long b() {
            return this.b;
        }

        public long c() {
            return this.f39282c;
        }
    }

    /* renamed from: com.tencent.thumbplayer.d.b$b  reason: collision with other inner class name */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/d/b$b.class */
    public static class C1018b extends a {
        public C1018b() {
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
        private String f39283a;
        private String b;

        public d() {
            a(202);
        }

        public void a(String str) {
            this.f39283a = str;
        }

        public void b(String str) {
            this.b = str;
        }

        public String d() {
            return this.f39283a;
        }

        public String e() {
            return this.b;
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/d/b$e.class */
    public static class e extends a {

        /* renamed from: a  reason: collision with root package name */
        private int f39284a;

        public e() {
            a(201);
        }

        public void b(int i) {
            this.f39284a = i;
        }

        public int d() {
            return this.f39284a;
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/d/b$f.class */
    public static class f extends a {

        /* renamed from: a  reason: collision with root package name */
        private String f39285a;
        private String b;

        public f() {
            a(203);
        }

        public void a(String str) {
            this.f39285a = str;
        }

        public void b(String str) {
            this.b = str;
        }

        public String d() {
            return this.f39285a;
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
        private TPDrmInfo f39286a;

        public h() {
            a(116);
        }

        public void a(TPDrmInfo tPDrmInfo) {
            this.f39286a = tPDrmInfo;
        }

        public TPDrmInfo d() {
            return this.f39286a;
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/d/b$i.class */
    public static class i extends a {

        /* renamed from: a  reason: collision with root package name */
        private int f39287a;
        private int b;

        /* renamed from: c  reason: collision with root package name */
        private TPGeneralPlayFlowParams f39288c;
        private TPDynamicStatisticParams d;

        public i() {
            a(106);
        }

        public void a(TPDynamicStatisticParams tPDynamicStatisticParams) {
            this.d = tPDynamicStatisticParams;
        }

        public void a(TPGeneralPlayFlowParams tPGeneralPlayFlowParams) {
            this.f39288c = tPGeneralPlayFlowParams;
        }

        public void b(int i) {
            this.f39287a = i;
        }

        public void c(int i) {
            this.b = i;
        }

        public int d() {
            return this.f39287a;
        }

        public int e() {
            return this.b;
        }

        public TPGeneralPlayFlowParams f() {
            return this.f39288c;
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
        private TPGeneralPlayFlowParams f39289a;
        private TPDynamicStatisticParams b;

        public l() {
            a(107);
        }

        public void a(TPDynamicStatisticParams tPDynamicStatisticParams) {
            this.b = tPDynamicStatisticParams;
        }

        public void a(TPGeneralPlayFlowParams tPGeneralPlayFlowParams) {
            this.f39289a = tPGeneralPlayFlowParams;
        }

        public TPGeneralPlayFlowParams d() {
            return this.f39289a;
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
        private TPGeneralPlayFlowParams f39290a;
        private TPDynamicStatisticParams b;

        public n() {
            a(105);
        }

        public void a(TPDynamicStatisticParams tPDynamicStatisticParams) {
            this.b = tPDynamicStatisticParams;
        }

        public void a(TPGeneralPlayFlowParams tPGeneralPlayFlowParams) {
            this.f39290a = tPGeneralPlayFlowParams;
        }

        public TPGeneralPlayFlowParams d() {
            return this.f39290a;
        }

        public TPDynamicStatisticParams e() {
            return this.b;
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/d/b$o.class */
    public static class o extends a {

        /* renamed from: a  reason: collision with root package name */
        private long f39291a;
        private int b;

        public o() {
            a(102);
        }

        public void a(long j) {
            this.f39291a = j;
        }

        public void b(int i) {
            this.b = i;
        }

        public long d() {
            return this.f39291a;
        }

        public int e() {
            return this.b;
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/d/b$p.class */
    public static class p extends a {

        /* renamed from: a  reason: collision with root package name */
        private String f39292a = "";

        public p() {
            a(101);
        }

        public void a(String str) {
            this.f39292a = str;
        }

        public String d() {
            return this.f39292a;
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
        private int f39293a;
        private long b;

        public s() {
            a(115);
        }

        public void a(long j) {
            this.b = j;
        }

        public void b(int i) {
            this.f39293a = i;
        }

        public int d() {
            return this.f39293a;
        }

        public long e() {
            return this.b;
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/d/b$t.class */
    public static class t extends a {

        /* renamed from: a  reason: collision with root package name */
        private int f39294a;
        private long b;

        /* renamed from: c  reason: collision with root package name */
        private TPTrackInfo f39295c;

        public t() {
            a(114);
        }

        public void a(long j) {
            this.b = j;
        }

        public void a(TPTrackInfo tPTrackInfo) {
            this.f39295c = tPTrackInfo;
        }

        public void b(int i) {
            this.f39294a = i;
        }

        public int d() {
            return this.f39294a;
        }

        public long e() {
            return this.b;
        }

        public TPTrackInfo f() {
            return this.f39295c;
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/d/b$u.class */
    public static class u extends a {

        /* renamed from: a  reason: collision with root package name */
        private String f39296a;
        private boolean b;

        /* renamed from: c  reason: collision with root package name */
        private int f39297c;

        public u() {
            a(117);
        }

        public void a(String str) {
            this.f39296a = str;
        }

        public void a(boolean z) {
            this.b = z;
        }

        public void b(int i) {
            this.f39297c = i;
        }

        public String d() {
            return this.f39296a;
        }

        public boolean e() {
            return this.b;
        }

        public int f() {
            return this.f39297c;
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/d/b$v.class */
    public static class v extends a {

        /* renamed from: a  reason: collision with root package name */
        private float f39298a;

        public v() {
            a(113);
        }

        public void a(float f) {
            this.f39298a = f;
        }

        public float d() {
            return this.f39298a;
        }
    }
}
