package com.huawei.hms.ads;

import android.content.Context;
import android.location.Location;
import android.text.TextUtils;
import com.huawei.hms.ads.RequestOptions;
import com.huawei.hms.ads.data.SearchInfo;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/i.class */
public class i implements p {
    private static final String Code = "AdRequestMediator";
    private String B;
    private String C;
    private String D;
    private String F;
    private int I;
    private App L;
    private boolean S;
    private final HashSet<String> V = new HashSet<>();
    private Location Z;

    /* renamed from: a  reason: collision with root package name */
    private RequestOptions.Builder f8886a;
    private List<Integer> b;

    /* renamed from: c  reason: collision with root package name */
    private String f8887c;
    private SearchInfo d;
    private boolean e;

    @Override // com.huawei.hms.ads.p
    public Location B() {
        return this.Z;
    }

    @Override // com.huawei.hms.ads.p
    public void B(Integer num) {
        if (num == null || num.intValue() == -1 || num.intValue() == 0 || num.intValue() == 1) {
            if (this.f8886a == null) {
                this.f8886a = new RequestOptions.Builder();
            }
            this.f8886a.setTagForUnderAgeOfPromise(num);
            return;
        }
        ge.V(Code, "Invalid value setTagForUnderAgeOfPromise: " + num);
    }

    @Override // com.huawei.hms.ads.p
    public void B(String str) {
        if (TextUtils.isEmpty(str)) {
            ge.V(Code, "Invalid value passed to setAppLang");
            return;
        }
        if (this.f8886a == null) {
            this.f8886a = new RequestOptions.Builder();
        }
        this.f8886a.setAppLang(str);
    }

    @Override // com.huawei.hms.ads.p
    public RequestOptions C() {
        RequestOptions.Builder builder = this.f8886a;
        if (builder != null) {
            return builder.build();
        }
        return null;
    }

    @Override // com.huawei.hms.ads.p
    public void C(Integer num) {
        boolean z = true;
        if (num != null && num.intValue() != 0 && 1 != num.intValue()) {
            ge.Z(Code, "Invalid value passed to setSupportFa: " + num);
            return;
        }
        if (this.f8886a == null) {
            this.f8886a = new RequestOptions.Builder();
        }
        if (num == null) {
            this.f8886a.setSupportFa(null);
            return;
        }
        RequestOptions.Builder builder = this.f8886a;
        if (num.intValue() != 1) {
            z = false;
        }
        builder.setSupportFa(Boolean.valueOf(z));
    }

    @Override // com.huawei.hms.ads.p
    public void C(String str) {
        if (TextUtils.isEmpty(str)) {
            ge.V(Code, "Invalid value passed to setAppCountry");
            return;
        }
        if (this.f8886a == null) {
            this.f8886a = new RequestOptions.Builder();
        }
        this.f8886a.setAppCountry(str);
    }

    @Override // com.huawei.hms.ads.p
    public String Code() {
        return this.B;
    }

    @Override // com.huawei.hms.ads.p
    public void Code(int i) {
        this.I = i;
    }

    @Override // com.huawei.hms.ads.p
    public void Code(Location location) {
        this.Z = location;
    }

    @Override // com.huawei.hms.ads.p
    public void Code(App app) {
        if (app == null) {
            ge.V(Code, "Invalid appInfo");
            return;
        }
        if (this.f8886a == null) {
            this.f8886a = new RequestOptions.Builder();
        }
        this.f8886a.setApp(app);
    }

    @Override // com.huawei.hms.ads.p
    public void Code(SearchInfo searchInfo) {
        if (this.f8886a == null) {
            this.f8886a = new RequestOptions.Builder();
        }
        this.f8886a.setSearchInfo(searchInfo);
    }

    @Override // com.huawei.hms.ads.p
    public void Code(Integer num) {
        if (num == null || num.intValue() == -1 || num.intValue() == 0 || num.intValue() == 1) {
            if (this.f8886a == null) {
                this.f8886a = new RequestOptions.Builder();
            }
            this.f8886a.setTagForChildProtection(num);
            return;
        }
        ge.V(Code, "Invalid value setTagForChildProtection: " + num);
    }

    @Override // com.huawei.hms.ads.p
    public void Code(String str) {
        this.V.add(str);
    }

    @Override // com.huawei.hms.ads.p
    public void Code(List<Integer> list) {
        this.b = list;
    }

    @Override // com.huawei.hms.ads.p
    public void Code(boolean z) {
        this.S = z;
    }

    @Override // com.huawei.hms.ads.p
    public boolean Code(Context context) {
        return false;
    }

    @Override // com.huawei.hms.ads.p
    public String D() {
        return this.D;
    }

    @Override // com.huawei.hms.ads.p
    public void D(String str) {
        if (this.f8886a == null) {
            this.f8886a = new RequestOptions.Builder();
        }
        this.f8886a.setSearchTerm(str);
    }

    @Override // com.huawei.hms.ads.p
    public String F() {
        return this.F;
    }

    @Override // com.huawei.hms.ads.p
    public void F(String str) {
        this.F = str;
    }

    @Override // com.huawei.hms.ads.p
    public int I() {
        return this.I;
    }

    @Override // com.huawei.hms.ads.p
    public void I(Integer num) {
        if (num == null || 1 == num.intValue() || num.intValue() == 0) {
            if (this.f8886a == null) {
                this.f8886a = new RequestOptions.Builder();
            }
            this.f8886a.setHwNonPersonalizedAd(num);
            return;
        }
        ge.Z(Code, "Invalid value passed to setHwNonPersonalizedAd: " + num);
    }

    @Override // com.huawei.hms.ads.p
    public void I(String str) {
        this.B = str;
    }

    @Override // com.huawei.hms.ads.p
    public void I(boolean z) {
        this.e = z;
    }

    @Override // com.huawei.hms.ads.p
    public List<Integer> L() {
        return this.b;
    }

    @Override // com.huawei.hms.ads.p
    public void L(String str) {
        if (this.f8886a == null) {
            this.f8886a = new RequestOptions.Builder();
        }
        this.f8886a.setConsent(str);
    }

    @Override // com.huawei.hms.ads.p
    public void S(String str) {
        if (str == null || "".equals(str)) {
            return;
        }
        if ("W".equals(str) || ContentClassification.AD_CONTENT_CLASSIFICATION_PI.equals(str) || ContentClassification.AD_CONTENT_CLASSIFICATION_J.equals(str) || "A".equals(str)) {
            if (this.f8886a == null) {
                this.f8886a = new RequestOptions.Builder();
            }
            this.f8886a.setAdContentClassification(str);
            return;
        }
        ge.V(Code, "Invalid value  setAdContentClassification: " + str);
    }

    @Override // com.huawei.hms.ads.p
    public boolean S() {
        return this.S;
    }

    @Override // com.huawei.hms.ads.p
    public String V() {
        return this.C;
    }

    @Override // com.huawei.hms.ads.p
    public void V(Integer num) {
        if (num == null || 1 == num.intValue() || num.intValue() == 0) {
            if (this.f8886a == null) {
                this.f8886a = new RequestOptions.Builder();
            }
            this.f8886a.setNonPersonalizedAd(num);
            return;
        }
        ge.Z(Code, "Invalid value passed to setNonPersonalizedAd: " + num);
    }

    @Override // com.huawei.hms.ads.p
    public void V(String str) {
        this.D = str;
    }

    @Override // com.huawei.hms.ads.p
    public void V(boolean z) {
        if (this.f8886a == null) {
            this.f8886a = new RequestOptions.Builder();
        }
        this.f8886a.setRequestLocation(Boolean.valueOf(z));
    }

    @Override // com.huawei.hms.ads.p
    public Set<String> Z() {
        return this.V;
    }

    @Override // com.huawei.hms.ads.p
    public void Z(Integer num) {
        if (num == null || 1 == num.intValue() || num.intValue() == 0) {
            if (this.f8886a == null) {
                this.f8886a = new RequestOptions.Builder();
            }
            this.f8886a.setThirdNonPersonalizedAd(num);
            return;
        }
        ge.Z(Code, "Invalid value passed to setThirdNonPersonalizedAd: " + num);
    }

    @Override // com.huawei.hms.ads.p
    public void Z(String str) {
        this.C = str;
    }

    @Override // com.huawei.hms.ads.p
    public String a() {
        return this.f8887c;
    }

    @Override // com.huawei.hms.ads.p
    public void a(String str) {
        this.f8887c = str;
    }

    @Override // com.huawei.hms.ads.p
    public boolean b() {
        return this.e;
    }
}
