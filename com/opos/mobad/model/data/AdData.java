package com.opos.mobad.model.data;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/model/data/AdData.class */
public class AdData extends a implements Parcelable {
    public static final Parcelable.Creator<AdData> CREATOR = new Parcelable.Creator<AdData>() { // from class: com.opos.mobad.model.data.AdData.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public AdData createFromParcel(Parcel parcel) {
            if (parcel != null) {
                AdData adData = new AdData();
                adData.b(parcel.readInt());
                adData.a(parcel.readString());
                adData.a(parcel.createTypedArrayList(AdItemData.CREATOR));
                adData.a(parcel.readLong());
                adData.c(parcel.readInt());
                adData.e(parcel.readInt());
                adData.e = parcel.readInt();
                adData.d(parcel.readInt());
                boolean z = true;
                if (parcel.readInt() != 1) {
                    z = false;
                }
                adData.a(z);
                return adData;
            }
            return null;
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public AdData[] newArray(int i) {
            return new AdData[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private int f12770a;
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private List<AdItemData> f12771c;
    private long d;
    private int e;
    private int f;
    private int g;
    private int h;
    private boolean i;
    private int j;

    public AdData() {
        this.g = 0;
        this.h = 0;
        this.i = false;
        this.j = 0;
    }

    public AdData(int i, String str) {
        this.g = 0;
        this.h = 0;
        this.i = false;
        this.j = 0;
        this.f12770a = i;
        this.b = str;
    }

    public AdData(int i, String str, int i2, int i3) {
        this.g = 0;
        this.h = 0;
        this.i = false;
        this.j = 0;
        this.f12770a = i;
        this.b = str;
        this.f = i2;
        this.g = i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(int i) {
        this.g = i;
    }

    public int a() {
        return this.j;
    }

    public void a(int i) {
        this.j = i;
    }

    public void a(long j) {
        this.d = j;
    }

    public void a(String str) {
        this.b = str;
    }

    public void a(List<AdItemData> list) {
        this.f12771c = list;
    }

    public void a(boolean z) {
        this.i = z;
    }

    public void b(int i) {
        this.f12770a = i;
    }

    public boolean b() {
        return this.i;
    }

    public int c() {
        return this.g;
    }

    public void c(int i) {
        this.f = i;
    }

    public int d() {
        return this.f12770a;
    }

    public void d(int i) {
        this.h = i;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String e() {
        return this.b;
    }

    public List<AdItemData> f() {
        return this.f12771c;
    }

    public int g() {
        return this.f;
    }

    public long h() {
        return this.d;
    }

    public String toString() {
        return "AdData{code=" + this.f12770a + ", msg='" + this.b + "', adItemDataList=" + this.f12771c + ", expTime=" + this.d + ", requestInterval=" + this.f + ", dispatchMode=" + this.g + ", gameBoxType=" + this.h + ", customSkip=" + this.i + '}';
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
}
