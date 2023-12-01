package com.amap.api.col.p0003sl;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.amap.api.col.p0003sl.bo;
import com.amap.api.col.p0003sl.bx;
import com.amap.api.maps.offlinemap.OfflineMapCity;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import java.io.File;

/* renamed from: com.amap.api.col.3sl.aw  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/aw.class */
public final class aw extends OfflineMapCity implements bf, bw {
    public static final Parcelable.Creator<aw> CREATOR = new Parcelable.Creator<aw>() { // from class: com.amap.api.col.3sl.aw.2
        private static aw a(Parcel parcel) {
            return new aw(parcel);
        }

        private static aw[] a(int i) {
            return new aw[i];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ aw createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ aw[] newArray(int i) {
            return a(i);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public final ca f4756a;
    public final ca b;

    /* renamed from: c  reason: collision with root package name */
    public final ca f4757c;
    public final ca d;
    public final ca e;
    public final ca f;
    public final ca g;
    public final ca h;
    public final ca i;
    public final ca j;
    public final ca k;
    ca l;
    Context m;
    boolean n;
    private String o;
    private String p;
    private long q;

    /* renamed from: com.amap.api.col.3sl.aw$3  reason: invalid class name */
    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/aw$3.class */
    static final /* synthetic */ class AnonymousClass3 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f4760a;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x002f -> B:19:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:9:0x002b -> B:15:0x0014). Please submit an issue!!! */
        static {
            int[] iArr = new int[bx.a.values().length];
            f4760a = iArr;
            try {
                iArr[bx.a.amap_exception.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f4760a[bx.a.file_io_exception.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f4760a[bx.a.network_exception.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    private aw(Context context, int i) {
        this.f4756a = new cc(this);
        this.b = new cj(this);
        this.f4757c = new cf(this);
        this.d = new ch(this);
        this.e = new ci(this);
        this.f = new cb(this);
        this.g = new cg(this);
        this.h = new cd(-1, this);
        this.i = new cd(101, this);
        this.j = new cd(102, this);
        this.k = new cd(103, this);
        this.o = null;
        this.p = "";
        this.n = false;
        this.q = 0L;
        this.m = context;
        a(i);
    }

    public aw(Context context, OfflineMapCity offlineMapCity) {
        this(context, offlineMapCity.getState());
        setCity(offlineMapCity.getCity());
        setUrl(offlineMapCity.getUrl());
        setState(offlineMapCity.getState());
        setCompleteCode(offlineMapCity.getcompleteCode());
        setAdcode(offlineMapCity.getAdcode());
        setVersion(offlineMapCity.getVersion());
        setSize(offlineMapCity.getSize());
        setCode(offlineMapCity.getCode());
        setJianpin(offlineMapCity.getJianpin());
        setPinyin(offlineMapCity.getPinyin());
        s();
    }

    public aw(Parcel parcel) {
        super(parcel);
        this.f4756a = new cc(this);
        this.b = new cj(this);
        this.f4757c = new cf(this);
        this.d = new ch(this);
        this.e = new ci(this);
        this.f = new cb(this);
        this.g = new cg(this);
        this.h = new cd(-1, this);
        this.i = new cd(101, this);
        this.j = new cd(102, this);
        this.k = new cd(103, this);
        this.o = null;
        this.p = "";
        this.n = false;
        this.q = 0L;
        this.p = parcel.readString();
    }

    private String A() {
        if (TextUtils.isEmpty(this.o)) {
            return null;
        }
        String str = this.o;
        return str.substring(0, str.lastIndexOf("."));
    }

    private String B() {
        if (TextUtils.isEmpty(this.o)) {
            return null;
        }
        String A = A();
        return A.substring(0, A.lastIndexOf(46));
    }

    private boolean C() {
        if (bu.a() < (getSize() * 2.5d) - (getcompleteCode() * getSize())) {
        }
        return false;
    }

    private void a(final File file, File file2, final String str) {
        new bo().a(file, file2, -1L, bu.a(file), new bo.a() { // from class: com.amap.api.col.3sl.aw.1
            @Override // com.amap.api.col.p0003sl.bo.a
            public final void a() {
                try {
                    if (new File(str).delete()) {
                        bu.b(file);
                        aw.this.setCompleteCode(100);
                        aw.this.l.g();
                    }
                } catch (Exception e) {
                    aw.this.l.a(aw.this.k.b());
                }
            }

            @Override // com.amap.api.col.p0003sl.bo.a
            public final void a(float f) {
                int i = (int) ((f * 0.39d) + 60.0d);
                if (i - aw.this.getcompleteCode() <= 0 || System.currentTimeMillis() - aw.this.q <= 1000) {
                    return;
                }
                aw.this.setCompleteCode(i);
                aw.this.q = System.currentTimeMillis();
            }

            @Override // com.amap.api.col.p0003sl.bo.a
            public final void b() {
                aw.this.l.a(aw.this.k.b());
            }
        });
    }

    private void z() {
        ax a2 = ax.a(this.m);
        if (a2 != null) {
            a2.a(this);
        }
    }

    public final String a() {
        return this.p;
    }

    public final void a(int i) {
        if (i == -1) {
            this.l = this.h;
        } else if (i == 0) {
            this.l = this.f4757c;
        } else if (i == 1) {
            this.l = this.e;
        } else if (i == 2) {
            this.l = this.b;
        } else if (i == 3) {
            this.l = this.d;
        } else if (i == 4) {
            this.l = this.f;
        } else if (i == 6) {
            this.l = this.f4756a;
        } else if (i != 7) {
            switch (i) {
                case 101:
                    this.l = this.i;
                    break;
                case 102:
                    this.l = this.j;
                    break;
                case 103:
                    this.l = this.k;
                    break;
                default:
                    if (i < 0) {
                        this.l = this.h;
                        break;
                    }
                    break;
            }
        } else {
            this.l = this.g;
        }
        setState(i);
    }

    @Override // com.amap.api.col.p0003sl.bp
    public final void a(long j) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.q > 500) {
            int i = (int) j;
            if (i > getcompleteCode()) {
                setCompleteCode(i);
                d();
            }
            this.q = currentTimeMillis;
        }
    }

    @Override // com.amap.api.col.p0003sl.bx
    public final void a(long j, long j2) {
        int i = (int) ((j2 * 100) / j);
        if (i != getcompleteCode()) {
            setCompleteCode(i);
            d();
        }
    }

    @Override // com.amap.api.col.p0003sl.bx
    public final void a(bx.a aVar) {
        int i = AnonymousClass3.f4760a[aVar.ordinal()];
        int b = i != 1 ? i != 2 ? i != 3 ? 6 : this.i.b() : this.k.b() : this.j.b();
        if (this.l.equals(this.f4757c) || this.l.equals(this.b)) {
            this.l.a(b);
        }
    }

    public final void a(ca caVar) {
        this.l = caVar;
        setState(caVar.b());
    }

    public final void a(String str) {
        this.p = str;
    }

    public final ca b(int i) {
        switch (i) {
            case 101:
                return this.i;
            case 102:
                return this.j;
            case 103:
                return this.k;
            default:
                return this.h;
        }
    }

    @Override // com.amap.api.col.p0003sl.bf
    public final String b() {
        return getUrl();
    }

    @Override // com.amap.api.col.p0003sl.bp
    public final void b(String str) {
        this.l.equals(this.e);
        this.p = str;
        String A = A();
        String B = B();
        if (TextUtils.isEmpty(A) || TextUtils.isEmpty(B)) {
            q();
            return;
        }
        File file = new File(B + BridgeUtil.SPLIT_MARK);
        File file2 = new File(dw.a(this.m) + File.separator + "map/");
        File file3 = new File(dw.a(this.m));
        if (file3.exists() || file3.mkdir()) {
            if (file2.exists() || file2.mkdir()) {
                a(file, file2, A);
            }
        }
    }

    public final ca c() {
        return this.l;
    }

    public final void d() {
        ax a2 = ax.a(this.m);
        if (a2 != null) {
            a2.c(this);
        }
    }

    @Override // com.amap.api.maps.offlinemap.OfflineMapCity, com.amap.api.maps.offlinemap.City, android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final void e() {
        ax a2 = ax.a(this.m);
        if (a2 != null) {
            a2.e(this);
            d();
        }
    }

    public final void f() {
        new StringBuilder("CityOperation current State==>").append(c().b());
        if (this.l.equals(this.d)) {
            this.l.d();
        } else if (this.l.equals(this.f4757c)) {
            this.l.e();
        } else if (this.l.equals(this.g) || this.l.equals(this.h)) {
            z();
            this.n = true;
        } else if (this.l.equals(this.j) || this.l.equals(this.i) || this.l.a(this.k)) {
            this.l.c();
        } else {
            c().h();
        }
    }

    public final void g() {
        this.l.e();
    }

    public final void h() {
        this.l.a(this.k.b());
    }

    public final void i() {
        this.l.a();
        if (this.n) {
            this.l.h();
        }
        this.n = false;
    }

    public final void j() {
        this.l.equals(this.f);
        this.l.f();
    }

    public final void k() {
        ax a2 = ax.a(this.m);
        if (a2 != null) {
            a2.b(this);
        }
    }

    public final void l() {
        ax a2 = ax.a(this.m);
        if (a2 != null) {
            a2.d(this);
        }
    }

    @Override // com.amap.api.col.p0003sl.bx
    public final void m() {
        this.q = 0L;
        this.l.equals(this.b);
        this.l.c();
    }

    @Override // com.amap.api.col.p0003sl.bx
    public final void n() {
        this.l.equals(this.f4757c);
        this.l.g();
    }

    @Override // com.amap.api.col.p0003sl.bx
    public final void o() {
        e();
    }

    @Override // com.amap.api.col.p0003sl.bp
    public final void p() {
        this.q = 0L;
        setCompleteCode(0);
        this.l.equals(this.e);
        this.l.c();
    }

    @Override // com.amap.api.col.p0003sl.bp
    public final void q() {
        this.l.equals(this.e);
        this.l.a(this.h.b());
    }

    @Override // com.amap.api.col.p0003sl.bp
    public final void r() {
        e();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void s() {
        String str = ax.f4761a;
        String b = bu.b(getUrl());
        if (b != null) {
            this.o = str + b + ".zip.tmp";
            return;
        }
        this.o = str + getPinyin() + ".zip.tmp";
    }

    public final bh t() {
        setState(this.l.b());
        bh bhVar = new bh(this, this.m);
        bhVar.a(a());
        new StringBuilder("vMapFileNames: ").append(a());
        return bhVar;
    }

    @Override // com.amap.api.col.p0003sl.bw
    public final boolean u() {
        return C();
    }

    @Override // com.amap.api.col.p0003sl.bw
    public final String v() {
        StringBuffer stringBuffer = new StringBuffer();
        String b = bu.b(getUrl());
        if (b != null) {
            stringBuffer.append(b);
        } else {
            stringBuffer.append(getPinyin());
        }
        stringBuffer.append(".zip");
        return stringBuffer.toString();
    }

    @Override // com.amap.api.col.p0003sl.bw
    public final String w() {
        return getAdcode();
    }

    @Override // com.amap.api.maps.offlinemap.OfflineMapCity, com.amap.api.maps.offlinemap.City, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.p);
    }

    @Override // com.amap.api.col.p0003sl.bq
    public final String x() {
        return A();
    }

    @Override // com.amap.api.col.p0003sl.bq
    public final String y() {
        return B();
    }
}
