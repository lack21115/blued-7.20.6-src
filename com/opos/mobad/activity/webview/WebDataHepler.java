package com.opos.mobad.activity.webview;

import android.os.Parcel;
import android.os.Parcelable;
import com.opos.mobad.ad.privacy.ComplianceInfo;
import com.opos.mobad.model.data.AdItemData;
import com.opos.mobad.service.event.EventDescription;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/activity/webview/WebDataHepler.class */
public class WebDataHepler implements Parcelable {
    public static final Parcelable.Creator<WebDataHepler> CREATOR = new Parcelable.Creator<WebDataHepler>() { // from class: com.opos.mobad.activity.webview.WebDataHepler.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public WebDataHepler createFromParcel(Parcel parcel) {
            return new WebDataHepler(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public WebDataHepler[] newArray(int i) {
            return new WebDataHepler[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private AdItemData f25630a;
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private String f25631c;
    private String d;
    private String e;
    private EventDescription f;
    private int g;
    private boolean h;
    private boolean i;
    private ComplianceInfo j;

    public WebDataHepler(Parcel parcel) {
        this.f25630a = (AdItemData) parcel.readParcelable(AdItemData.class.getClassLoader());
        this.b = parcel.readString();
        this.f25631c = parcel.readString();
        this.d = parcel.readString();
        this.f = (EventDescription) parcel.readParcelable(EventDescription.class.getClassLoader());
        this.e = parcel.readString();
        this.g = parcel.readInt();
        this.h = parcel.readInt() == 1;
        this.i = parcel.readInt() == 1;
        this.j = (ComplianceInfo) parcel.readParcelable(ComplianceInfo.class.getClassLoader());
    }

    public WebDataHepler(ComplianceInfo complianceInfo, EventDescription eventDescription, int i) {
        this.j = complianceInfo;
        this.f = eventDescription;
        this.g = i;
    }

    public WebDataHepler(AdItemData adItemData, String str, String str2, String str3, String str4, EventDescription eventDescription, int i) {
        this(adItemData, str, str2, str3, str4, eventDescription, i, true, true);
    }

    public WebDataHepler(AdItemData adItemData, String str, String str2, String str3, String str4, EventDescription eventDescription, int i, boolean z, boolean z2) {
        this.f25630a = adItemData;
        this.b = str;
        this.f25631c = str2;
        this.d = str3;
        this.e = str4;
        this.f = eventDescription;
        this.g = i;
        this.h = z;
        this.i = z2;
    }

    public AdItemData a() {
        return this.f25630a;
    }

    public String b() {
        return this.b;
    }

    public String c() {
        return this.f25631c;
    }

    public String d() {
        return this.d;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String e() {
        return this.e;
    }

    public EventDescription f() {
        return this.f;
    }

    public int g() {
        return this.g;
    }

    public ComplianceInfo h() {
        return this.j;
    }

    public boolean i() {
        return this.h;
    }

    public boolean j() {
        return this.i;
    }

    public String toString() {
        return "WebDataHepler{mAdItemData=" + this.f25630a + ", mPosId='" + this.b + "', mJsSign='" + this.f25631c + "', mWebUrl='" + this.d + "', mVideoUrl='" + this.e + "', mLandingPageId='" + this.f + "', mActionType=" + this.g + ", mShowTitleBar=" + this.h + ", mFitsSystemWindows=" + this.i + '}';
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
}
