package com.opos.mobad.model.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import com.opos.cmn.an.a.b;
import com.opos.mobad.b.a.b;
import com.opos.mobad.b.a.e;
import com.opos.mobad.b.a.h;
import com.opos.mobad.b.a.t;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/model/data/AdItemData.class */
public class AdItemData extends a implements Parcelable {
    private boolean A;
    private boolean B;
    private int C;
    private ActivatingData D;
    private int E;
    private boolean F;
    private String G;
    private String H;
    private int I;
    private volatile boolean J;
    private volatile boolean K;
    private long L;
    private AppPrivacyData M;
    private CustomInfoData N;
    private int O;
    private String P;
    private int Q;
    private int R;
    private String S;
    private String T;
    List<MaterialData> d;
    private String e;
    private String f;
    private String g;
    private String h;
    private String i;
    private String j;
    private String k;
    private boolean l;
    private int m;
    private MaterialFileData n;
    private int o;
    private String p;
    private long q;
    private boolean r;
    private int s;
    private int t;
    private int u;
    private int v;
    private long w;
    private boolean x;
    private int y;
    private String z;

    /* renamed from: a  reason: collision with root package name */
    public static final String f12772a = b.a("b3Bwb19hZHg=");
    public static final String b = b.a("b3Bwb19mZWVk");

    /* renamed from: c  reason: collision with root package name */
    public static final String f12773c = b.a("b3Bwb19jcGQ=");
    public static final Parcelable.Creator<AdItemData> CREATOR = new Parcelable.Creator<AdItemData>() { // from class: com.opos.mobad.model.data.AdItemData.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public AdItemData createFromParcel(Parcel parcel) {
            if (parcel != null) {
                AdItemData adItemData = new AdItemData();
                adItemData.a(parcel.readString());
                adItemData.b(parcel.readString());
                adItemData.c(parcel.readString());
                adItemData.d(parcel.readString());
                adItemData.e(parcel.readString());
                adItemData.f(parcel.readString());
                adItemData.g(parcel.readString());
                adItemData.a(parcel.createTypedArrayList(MaterialData.CREATOR));
                adItemData.a(parcel.readByte() != 0);
                adItemData.a(parcel.readInt());
                adItemData.a((MaterialFileData) parcel.readParcelable(MaterialFileData.class.getClassLoader()));
                adItemData.b(parcel.readInt());
                adItemData.h(parcel.readString());
                adItemData.a(parcel.readLong());
                adItemData.b(parcel.readByte() != 0);
                adItemData.c(parcel.readInt());
                adItemData.d(parcel.readInt());
                adItemData.e(parcel.readInt());
                adItemData.f(parcel.readInt());
                adItemData.b(parcel.readLong());
                adItemData.c(parcel.readByte() != 0);
                adItemData.g(parcel.readInt());
                adItemData.i(parcel.readString());
                adItemData.e(parcel.readByte() != 0);
                adItemData.h(parcel.readInt());
                adItemData.i(parcel.readInt());
                adItemData.a((ActivatingData) parcel.readParcelable(ActivatingData.class.getClassLoader()));
                adItemData.j(parcel.readString());
                adItemData.H = parcel.readString();
                adItemData.I = parcel.readInt();
                adItemData.f(parcel.readByte() != 0);
                boolean z = false;
                if (parcel.readByte() != 0) {
                    z = true;
                }
                adItemData.g(z);
                adItemData.L = parcel.readLong();
                adItemData.a((AppPrivacyData) parcel.readParcelable(AppPrivacyData.class.getClassLoader()));
                adItemData.N = (CustomInfoData) parcel.readParcelable(CustomInfoData.class.getClassLoader());
                adItemData.O = parcel.readInt();
                adItemData.P = parcel.readString();
                adItemData.Q = parcel.readInt();
                adItemData.S = parcel.readString();
                adItemData.R = parcel.readInt();
                adItemData.T = parcel.readString();
                return adItemData;
            }
            return null;
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public AdItemData[] newArray(int i) {
            return new AdItemData[i];
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.opos.mobad.model.data.AdItemData$2  reason: invalid class name */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/model/data/AdItemData$2.class */
    public static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f12774a;
        static final /* synthetic */ int[] b;

        /* renamed from: c  reason: collision with root package name */
        static final /* synthetic */ int[] f12775c;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0074 -> B:43:0x0014). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x0078 -> B:6:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x007c -> B:51:0x0033). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x0080 -> B:45:0x003e). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x0084 -> B:13:0x0049). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x0088 -> B:37:0x005d). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x008c -> B:49:0x0068). Please submit an issue!!! */
        static {
            int[] iArr = new int[b.c.values().length];
            f12775c = iArr;
            try {
                iArr[b.c.PLAY_CACHE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f12775c[b.c.PLAY_STREAM.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            int[] iArr2 = new int[b.f.values().length];
            b = iArr2;
            try {
                iArr2[b.f.TOP_RIGHT_CORNER.ordinal()] = 1;
            } catch (NoSuchFieldError e3) {
            }
            try {
                b[b.f.MIDDLE_RIGHT_CORNER.ordinal()] = 2;
            } catch (NoSuchFieldError e4) {
            }
            try {
                b[b.f.BOTTOM_RIGHT_CORNER.ordinal()] = 3;
            } catch (NoSuchFieldError e5) {
            }
            int[] iArr3 = new int[b.EnumC0504b.values().length];
            f12774a = iArr3;
            try {
                iArr3[b.EnumC0504b.SENSOR.ordinal()] = 1;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f12774a[b.EnumC0504b.HORIZONTAL.ordinal()] = 2;
            } catch (NoSuchFieldError e7) {
            }
            try {
                f12774a[b.EnumC0504b.VERTICAL.ordinal()] = 3;
            } catch (NoSuchFieldError e8) {
            }
        }
    }

    public AdItemData() {
        this.z = "广告";
        this.A = false;
        this.B = false;
        this.F = false;
        this.J = false;
        this.K = false;
    }

    public AdItemData(com.opos.mobad.b.a.b bVar, List<MaterialData> list, MaterialFileData materialFileData, t tVar, long j, String str, String str2, CustomInfoData customInfoData, int i, String str3, String str4) {
        this.z = "广告";
        this.A = false;
        this.B = false;
        this.F = false;
        this.J = false;
        this.K = false;
        this.i = bVar.x != null ? bVar.x : "";
        this.j = bVar.y != null ? bVar.y : "";
        this.k = bVar.z != null ? bVar.z : "";
        this.p = bVar.F != null ? bVar.F : "";
        this.e = bVar.R != null ? bVar.R : "";
        this.d = list;
        this.m = (bVar.C != null ? bVar.C : com.opos.mobad.b.a.b.e).intValue();
        this.n = materialFileData;
        this.l = (bVar.B != null ? bVar.B : com.opos.mobad.b.a.b.d).booleanValue();
        this.o = (bVar.E != null ? bVar.E : com.opos.mobad.b.a.b.f).intValue();
        this.q = (bVar.G != null ? bVar.G : com.opos.mobad.b.a.b.g).longValue();
        this.r = (bVar.H != null ? bVar.H : com.opos.mobad.b.a.b.h).booleanValue();
        this.s = (bVar.I != null ? bVar.I : com.opos.mobad.b.a.b.i).intValue();
        this.t = (bVar.J != null ? bVar.J : com.opos.mobad.b.a.b.j).intValue();
        this.u = (bVar.L != null ? bVar.L : com.opos.mobad.b.a.b.l).intValue();
        this.v = a(bVar.M != null ? bVar.M : com.opos.mobad.b.a.b.m);
        this.x = (bVar.N != null ? bVar.N : com.opos.mobad.b.a.b.n).booleanValue();
        this.y = (bVar.Z != null ? bVar.Z : com.opos.mobad.b.a.b.u).intValue();
        if (bVar.P != null) {
            this.z = bVar.P;
        }
        this.B = (bVar.S != null ? bVar.S : com.opos.mobad.b.a.b.q).booleanValue();
        this.C = a(bVar.T != null ? bVar.T : com.opos.mobad.b.a.b.r);
        this.E = a(bVar.V);
        if (tVar != null) {
            this.g = tVar.d;
            this.h = tVar.e;
        }
        this.w = j;
        this.f = str == null ? "" : str;
        this.G = bVar.W != null ? bVar.W : "";
        this.H = str2;
        this.I = (bVar.X != null ? bVar.X : com.opos.mobad.b.a.b.t).intValue();
        a(bVar.U);
        this.L = SystemClock.elapsedRealtime();
        this.M = a(bVar);
        this.N = customInfoData;
        this.O = i;
        this.P = str3;
        this.Q = (bVar.aa != null ? bVar.aa : com.opos.mobad.b.a.b.v).intValue();
        this.R = (bVar.ab != null ? bVar.ab : com.opos.mobad.b.a.b.w).intValue();
        this.S = str4;
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0016, code lost:
        if (r0 != 3) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int a(com.opos.mobad.b.a.b.EnumC0504b r3) {
        /*
            r0 = 2
            r4 = r0
            r0 = r3
            if (r0 == 0) goto L1e
            int[] r0 = com.opos.mobad.model.data.AdItemData.AnonymousClass2.f12774a
            r1 = r3
            int r1 = r1.ordinal()
            r0 = r0[r1]
            r5 = r0
            r0 = r5
            r1 = 2
            if (r0 == r1) goto L1c
            r0 = r5
            r1 = 3
            if (r0 == r1) goto L20
            goto L1e
        L1c:
            r0 = 1
            return r0
        L1e:
            r0 = 0
            r4 = r0
        L20:
            r0 = r4
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.mobad.model.data.AdItemData.a(com.opos.mobad.b.a.b$b):int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0016, code lost:
        if (r0 != 2) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int a(com.opos.mobad.b.a.b.c r3) {
        /*
            r0 = 2
            r4 = r0
            r0 = r3
            if (r0 == 0) goto L1e
            int[] r0 = com.opos.mobad.model.data.AdItemData.AnonymousClass2.f12775c
            r1 = r3
            int r1 = r1.ordinal()
            r0 = r0[r1]
            r5 = r0
            r0 = r5
            r1 = 1
            if (r0 == r1) goto L1c
            r0 = r5
            r1 = 2
            if (r0 == r1) goto L20
            goto L1e
        L1c:
            r0 = 1
            return r0
        L1e:
            r0 = 0
            r4 = r0
        L20:
            r0 = r4
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.mobad.model.data.AdItemData.a(com.opos.mobad.b.a.b$c):int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0016, code lost:
        if (r0 != 3) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int a(com.opos.mobad.b.a.b.f r3) {
        /*
            r0 = 2
            r4 = r0
            r0 = r3
            if (r0 == 0) goto L1e
            int[] r0 = com.opos.mobad.model.data.AdItemData.AnonymousClass2.b
            r1 = r3
            int r1 = r1.ordinal()
            r0 = r0[r1]
            r5 = r0
            r0 = r5
            r1 = 2
            if (r0 == r1) goto L1c
            r0 = r5
            r1 = 3
            if (r0 == r1) goto L20
            goto L1e
        L1c:
            r0 = 1
            return r0
        L1e:
            r0 = 0
            r4 = r0
        L20:
            r0 = r4
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.mobad.model.data.AdItemData.a(com.opos.mobad.b.a.b$f):int");
    }

    private AppPrivacyData a(com.opos.mobad.b.a.b bVar) {
        h hVar = bVar.Y;
        if (hVar == null || TextUtils.isEmpty(hVar.e) || TextUtils.isEmpty(hVar.d) || TextUtils.isEmpty(hVar.g) || TextUtils.isEmpty(hVar.f)) {
            return null;
        }
        return new AppPrivacyData(hVar.d, hVar.e, hVar.g, hVar.f);
    }

    private void a(com.opos.mobad.b.a.a aVar) {
        ArrayList arrayList;
        if (aVar == null) {
            return;
        }
        if (aVar.g != null) {
            ArrayList arrayList2 = new ArrayList();
            Iterator<e> it = aVar.g.iterator();
            while (true) {
                arrayList = arrayList2;
                if (!it.hasNext()) {
                    break;
                }
                e next = it.next();
                arrayList2.add(new ApkSignerData(next.d, next.e, next.f));
            }
        } else {
            arrayList = null;
        }
        this.D = new ActivatingData(aVar.e, aVar.f, arrayList, aVar.h.intValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AppPrivacyData appPrivacyData) {
        this.M = appPrivacyData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(long j) {
        this.w = j;
    }

    public boolean A() {
        return this.y == 0;
    }

    public String B() {
        return this.z;
    }

    public boolean C() {
        return this.A;
    }

    public boolean D() {
        return this.B;
    }

    public int E() {
        return this.C;
    }

    public int F() {
        return this.E;
    }

    public ActivatingData G() {
        return this.D;
    }

    public void H() {
        this.F = true;
    }

    public boolean I() {
        return this.F;
    }

    public String J() {
        return this.G;
    }

    public int K() {
        return this.I;
    }

    public boolean L() {
        return this.J;
    }

    public boolean M() {
        return this.K;
    }

    public long N() {
        return this.L;
    }

    public AppPrivacyData O() {
        return this.M;
    }

    public int P() {
        CustomInfoData customInfoData = this.N;
        if (customInfoData != null) {
            return customInfoData.c();
        }
        return 2;
    }

    public boolean Q() {
        CustomInfoData customInfoData = this.N;
        if (customInfoData != null) {
            return customInfoData.a();
        }
        return false;
    }

    public int R() {
        CustomInfoData customInfoData = this.N;
        if (customInfoData != null) {
            return customInfoData.d();
        }
        return 0;
    }

    public int S() {
        CustomInfoData customInfoData = this.N;
        if (customInfoData != null) {
            return customInfoData.e();
        }
        return 0;
    }

    public int T() {
        CustomInfoData customInfoData = this.N;
        if (customInfoData != null) {
            return customInfoData.f();
        }
        return 3000;
    }

    public int U() {
        CustomInfoData customInfoData = this.N;
        if (customInfoData != null) {
            return customInfoData.g();
        }
        return 2000;
    }

    public int V() {
        return this.O;
    }

    public String W() {
        return this.P;
    }

    public int X() {
        return this.Q;
    }

    public int Y() {
        return this.R;
    }

    public String Z() {
        return this.S;
    }

    public String a() {
        return this.H;
    }

    public void a(int i) {
        this.m = i;
    }

    public void a(long j) {
        this.q = j;
    }

    public void a(ActivatingData activatingData) {
        this.D = activatingData;
    }

    public void a(MaterialFileData materialFileData) {
        this.n = materialFileData;
    }

    public void a(String str) {
        this.e = str;
    }

    public void a(List<MaterialData> list) {
        this.d = list;
    }

    public void a(boolean z) {
        this.l = z;
    }

    public String aa() {
        return this.T;
    }

    public String b() {
        return this.e;
    }

    public void b(int i) {
        this.o = i;
    }

    public void b(String str) {
        this.f = str;
    }

    public void b(boolean z) {
        this.r = z;
    }

    public String c() {
        return this.f;
    }

    public void c(int i) {
        this.s = i;
    }

    public void c(String str) {
        this.g = str;
    }

    public void c(boolean z) {
        this.x = z;
    }

    public String d() {
        return this.g;
    }

    public void d(int i) {
        this.t = i;
    }

    public void d(String str) {
        this.h = str;
    }

    public void d(boolean z) {
        this.A = z;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String e() {
        return this.h;
    }

    public void e(int i) {
        this.u = i;
    }

    public void e(String str) {
        this.i = str;
    }

    public void e(boolean z) {
        this.B = z;
    }

    public String f() {
        return this.i;
    }

    public void f(int i) {
        this.v = i;
    }

    public void f(String str) {
        this.j = str;
    }

    public void f(boolean z) {
        this.J = z;
    }

    public String g() {
        return this.j;
    }

    public void g(int i) {
        this.y = i;
    }

    public void g(String str) {
        this.k = str;
    }

    public void g(boolean z) {
        this.K = z;
    }

    public String h() {
        return this.k;
    }

    public void h(int i) {
        this.C = i;
    }

    public void h(String str) {
        this.p = str;
    }

    public List<MaterialData> i() {
        return this.d;
    }

    public void i(int i) {
        this.E = i;
    }

    public void i(String str) {
        if (com.opos.cmn.an.c.a.a(str)) {
            return;
        }
        this.z = str;
    }

    public void j(String str) {
        this.G = str;
    }

    public boolean j() {
        return this.l;
    }

    public int k() {
        return this.m;
    }

    public void k(String str) {
        this.T = str;
    }

    public MaterialFileData l() {
        return this.n;
    }

    public int m() {
        return this.o;
    }

    public String n() {
        return this.p;
    }

    public long o() {
        return this.q;
    }

    public int p() {
        return this.s;
    }

    public int q() {
        return this.t;
    }

    public int r() {
        return this.v;
    }

    public long s() {
        return this.w;
    }

    public boolean t() {
        return this.x;
    }

    public String toString() {
        return "AdItemData{adSource='" + this.e + "', respId='" + this.f + "', adId='" + this.i + "', posId='" + this.j + "', planId='" + this.k + "', materialDataList=" + this.d + ", showLogo=" + this.l + ", closeBnStyle=" + this.m + ", logoFile=" + this.n + ", refreshTime=" + this.o + ", ext='" + this.p + "', countdown=" + this.q + ", showSkipBn=" + this.r + ", showInterval=" + this.s + ", clickInterval=" + this.t + ", reqInterval=" + this.u + ", playMode=" + this.v + ", expTime=" + this.w + ", playRemindAtCellular=" + this.x + ", rewardScene=" + this.y + ", logoText='" + this.z + "', hasReward='" + this.A + "', playVideoInSilence='" + this.B + "', splashSkipBtPosition='" + this.C + "', videoOrientation='" + this.E + "', activatingData='" + this.D + "', isDownloaderStartReport=" + this.J + ", isDownloaderCompleteReport=" + this.K + ", appPrivacyData=" + this.M + ", customInfo= " + this.N + ", posType= " + this.O + ", ageGrading= " + this.P + ", mKeyWords= " + this.T + '}';
    }

    public int u() {
        return this.y;
    }

    public boolean v() {
        return (this.y & 1) == 1;
    }

    public boolean w() {
        return (this.y & 2) == 2;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.e);
        parcel.writeString(this.f);
        parcel.writeString(this.g);
        parcel.writeString(this.h);
        parcel.writeString(this.i);
        parcel.writeString(this.j);
        parcel.writeString(this.k);
        parcel.writeTypedList(this.d);
        parcel.writeByte(this.l ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.m);
        parcel.writeParcelable(this.n, i);
        parcel.writeInt(this.o);
        parcel.writeString(this.p);
        parcel.writeLong(this.q);
        parcel.writeByte(this.r ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.s);
        parcel.writeInt(this.t);
        parcel.writeInt(this.u);
        parcel.writeInt(this.v);
        parcel.writeLong(this.w);
        parcel.writeByte(this.x ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.y);
        parcel.writeString(this.z);
        parcel.writeByte(this.B ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.C);
        parcel.writeInt(this.E);
        parcel.writeParcelable(this.D, i);
        parcel.writeString(this.G);
        parcel.writeString(this.H);
        parcel.writeInt(this.I);
        parcel.writeByte(this.J ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.K ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.L);
        parcel.writeParcelable(this.M, i);
        parcel.writeParcelable(this.N, i);
        parcel.writeInt(this.O);
        parcel.writeString(this.P);
        parcel.writeInt(this.Q);
        parcel.writeString(this.S);
        parcel.writeInt(this.R);
        parcel.writeString(this.T);
    }

    public boolean x() {
        return (this.y & 4) == 4;
    }

    public boolean y() {
        return (this.y & 8) == 8;
    }

    public boolean z() {
        return (this.y & 16) == 16;
    }
}
