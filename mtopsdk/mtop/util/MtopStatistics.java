package mtopsdk.mtop.util;

import mtopsdk.a.b.a;
import mtopsdk.common.util.MtopUtils;
import mtopsdk.common.util.StringUtils;

/* loaded from: source-3503164-dex2jar.jar:mtopsdk/mtop/util/MtopStatistics.class */
public class MtopStatistics implements Cloneable {
    public long b;
    public long c;
    public long d;
    public int e;
    public String f;
    public String g;
    protected long h;
    protected long i;
    protected long j;
    protected long k;
    protected long l;
    protected long m;
    protected a o;
    private RbStatisticData r;
    public boolean a = true;
    protected String n = "";
    public String p = "";
    public int q = MtopUtils.a();
    private String s = "MTOP" + this.q;

    /* loaded from: source-3503164-dex2jar.jar:mtopsdk/mtop/util/MtopStatistics$RbStatisticData.class */
    public class RbStatisticData implements Cloneable {
        public long a;
        public long b;
        public long c;
        public long d;
        public long e;
        public long f;
        public long g;
        public int h;

        private RbStatisticData() {
            this.h = 0;
        }

        public Object clone() {
            return super.clone();
        }

        public String toString() {
            return "rbReqTime=" + this.d + ",mtopReqTime=" + this.a + ",mtopJsonParseTime=" + this.e + ",toMainThTime=" + this.g + ",isCache=" + this.h + ",beforeReqTime=" + this.b + ",afterReqTime=" + this.c + ",parseTime=" + this.f;
        }
    }

    private long j() {
        return System.nanoTime() / 1000000;
    }

    public void a() {
        this.h = j();
    }

    public void a(a aVar) {
        this.o = aVar;
    }

    public void a(boolean z) {
        this.a = z;
    }

    public void b() {
        this.i = j();
    }

    public void c() {
        this.l = j();
    }

    public Object clone() {
        return super.clone();
    }

    public void d() {
        this.m = j();
    }

    public void e() {
        this.j = j();
    }

    public void f() {
        this.k = j();
    }

    public String g() {
        return this.s;
    }

    public void h() {
        this.b = this.i - this.h;
        this.c = this.k - this.j;
        this.d = this.m - this.l;
        StringBuilder sb = new StringBuilder("");
        sb.append("mtopOneWayTime=");
        sb.append(this.b);
        sb.append(",oneWayTime=");
        sb.append(this.c);
        sb.append(",mtopResponseParseTime=");
        sb.append(this.d);
        sb.append(",httpResponseStatus=");
        sb.append(this.e);
        sb.append(",ret=");
        sb.append(this.f);
        if (this.o != null) {
            sb.append(",");
            sb.append(StringUtils.b(this.o.a) ? this.o.a() : this.o.a);
        }
        this.n = sb.toString();
    }

    public RbStatisticData i() {
        RbStatisticData rbStatisticData;
        synchronized (this) {
            if (this.r == null) {
                this.r = new RbStatisticData();
            }
            rbStatisticData = this.r;
        }
        return rbStatisticData;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("MtopStatistics [Detail]:");
        sb.append("startTime=" + this.h);
        sb.append(",mtopResponseParseStartTime=" + this.l);
        sb.append(",mtopResponseParseEndTime=" + this.m);
        sb.append(",endTime=" + this.i);
        sb.append("\nMtopStatistics[sumstat(ms)]:" + this.n);
        if (this.r != null) {
            sb.append("\nrbStatData=" + this.r);
        }
        return sb.toString();
    }
}
