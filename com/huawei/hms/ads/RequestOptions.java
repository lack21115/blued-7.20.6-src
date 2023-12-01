package com.huawei.hms.ads;

import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.ads.data.SearchInfo;
import com.huawei.openalliance.ad.annotations.c;
import com.huawei.openalliance.ad.beans.metadata.ImpEX;
import com.huawei.openalliance.ad.beans.metadata.ImpEXs;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/RequestOptions.class */
public class RequestOptions {
    private static final String TAG = RequestOptions.class.getSimpleName();
    @c(Code = "gACString")
    private String acString;
    private String adContentClassification;
    private App app;
    private String appCountry;
    private String appLang;
    private String consent;
    @com.huawei.openalliance.ad.annotations.d
    private Map<String, Bundle> extras;
    private String hwACString;
    private Integer hwNonPersonalizedAd;
    private Map<String, ImpEXs> impEXs;
    private Integer nonPersonalizedAd;
    private Boolean requestLocation;
    private SearchInfo searchInfo;
    private String searchTerm;
    private Boolean supportFa;
    private Integer tagForChildProtection;
    private Integer tagForUnderAgeOfPromise;
    private Integer thirdNonPersonalizedAd;

    /* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/RequestOptions$Builder.class */
    public static class Builder {
        private Integer Code;
        private App D;
        private String F;
        private String I;
        private Boolean L;
        private String S;
        private Integer V;

        /* renamed from: a  reason: collision with root package name */
        private String f8825a;
        private Map<String, Bundle> b;

        /* renamed from: c  reason: collision with root package name */
        private String f8826c;
        private SearchInfo d;
        private String e;
        private String f;
        private Boolean g;
        private Integer Z = null;
        private Integer B = null;
        private Integer C = null;

        public Builder Code(String str) {
            this.e = str;
            return this;
        }

        public Builder V(String str) {
            this.f = str;
            return this;
        }

        public RequestOptions build() {
            return new RequestOptions(this);
        }

        public Builder setAdContentClassification(String str) {
            String str2;
            if (str == null || "".equals(str)) {
                str2 = null;
            } else {
                str2 = str;
                if (!"W".equals(str)) {
                    str2 = str;
                    if (!ContentClassification.AD_CONTENT_CLASSIFICATION_PI.equals(str)) {
                        str2 = str;
                        if (!ContentClassification.AD_CONTENT_CLASSIFICATION_J.equals(str)) {
                            str2 = str;
                            if (!"A".equals(str)) {
                                ge.Code(RequestOptions.TAG, "Invalid value for setAdContentClassification: %s", str);
                                return this;
                            }
                        }
                    }
                }
            }
            this.I = str2;
            return this;
        }

        public Builder setApp(App app) {
            if (app == null) {
                ge.V(RequestOptions.TAG, "Invalid appInfo");
                return this;
            }
            this.D = app;
            return this;
        }

        public Builder setAppCountry(String str) {
            if (TextUtils.isEmpty(str)) {
                ge.V(RequestOptions.TAG, "Invalid value passed to setAppCountry");
                return this;
            }
            this.F = str;
            return this;
        }

        public Builder setAppLang(String str) {
            if (TextUtils.isEmpty(str)) {
                ge.V(RequestOptions.TAG, "Invalid value passed to setAppLang");
                return this;
            }
            this.S = str;
            return this;
        }

        public Builder setConsent(String str) {
            this.f8826c = str;
            return this;
        }

        public Builder setExtras(Map<String, Bundle> map) {
            this.b = map;
            return this;
        }

        public Builder setHwNonPersonalizedAd(Integer num) {
            if (num == null || 1 == num.intValue() || num.intValue() == 0) {
                this.B = num;
                return this;
            }
            String str = RequestOptions.TAG;
            ge.Z(str, "Invalid value passed to setHwNonPersonalizedAd: " + num);
            return this;
        }

        public Builder setNonPersonalizedAd(Integer num) {
            if (num == null || 1 == num.intValue() || num.intValue() == 0) {
                this.Z = num;
                return this;
            }
            String str = RequestOptions.TAG;
            ge.Z(str, "Invalid value passed to setNonPersonalizedAd: " + num);
            return this;
        }

        public Builder setRequestLocation(Boolean bool) {
            this.L = bool;
            return this;
        }

        public Builder setSearchInfo(SearchInfo searchInfo) {
            this.d = searchInfo;
            return this;
        }

        public Builder setSearchTerm(String str) {
            if (TextUtils.isEmpty(str)) {
                ge.V(RequestOptions.TAG, "Invalid value setSearchTerm");
                return this;
            }
            this.f8825a = str;
            return this;
        }

        public Builder setSupportFa(Boolean bool) {
            this.g = bool;
            return this;
        }

        public Builder setTagForChildProtection(Integer num) {
            if (num == null || num.intValue() == -1 || num.intValue() == 0 || num.intValue() == 1) {
                this.Code = num;
                return this;
            }
            ge.Code(RequestOptions.TAG, "Invalid value passed to setTagForChildProtection: %s", num);
            return this;
        }

        public Builder setTagForUnderAgeOfPromise(Integer num) {
            if (num == null || num.intValue() == -1 || num.intValue() == 0 || num.intValue() == 1) {
                this.V = num;
                return this;
            }
            ge.Code(RequestOptions.TAG, "Invalid value passed to setTagForUnderAgeOfPromise: %s", num);
            return this;
        }

        public Builder setThirdNonPersonalizedAd(Integer num) {
            if (num == null || 1 == num.intValue() || num.intValue() == 0) {
                this.C = num;
                return this;
            }
            String str = RequestOptions.TAG;
            ge.Z(str, "Invalid value passed to setThirdNonPersonalizedAd: " + num);
            return this;
        }
    }

    public RequestOptions() {
        this.nonPersonalizedAd = null;
        this.hwNonPersonalizedAd = null;
        this.thirdNonPersonalizedAd = null;
    }

    private RequestOptions(Builder builder) {
        this.nonPersonalizedAd = null;
        this.hwNonPersonalizedAd = null;
        this.thirdNonPersonalizedAd = null;
        this.tagForChildProtection = builder.Code;
        this.tagForUnderAgeOfPromise = builder.V;
        this.adContentClassification = builder.I;
        this.nonPersonalizedAd = builder.Z;
        this.hwNonPersonalizedAd = builder.B;
        this.thirdNonPersonalizedAd = builder.C;
        this.appLang = builder.S;
        this.appCountry = builder.F;
        this.app = builder.D;
        this.requestLocation = builder.L;
        this.searchTerm = builder.f8825a;
        Map<String, Bundle> map = builder.b;
        this.extras = map;
        this.impEXs = Code(map);
        this.consent = builder.f8826c;
        this.searchInfo = builder.d;
        this.acString = builder.e;
        this.hwACString = builder.f;
        this.supportFa = builder.g;
    }

    private Map<String, ImpEXs> Code(Map<String, Bundle> map) {
        if (map == null || map.isEmpty()) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, Bundle> entry : map.entrySet()) {
            String key = entry.getKey();
            Bundle value = entry.getValue();
            if (value != null) {
                ArrayList arrayList = new ArrayList();
                for (String str : value.keySet()) {
                    arrayList.add(new ImpEX(str, com.huawei.openalliance.ad.utils.au.S(value.getString(str))));
                }
                hashMap.put(key, new ImpEXs(arrayList));
            }
        }
        return hashMap;
    }

    public String B() {
        return this.searchTerm;
    }

    public SearchInfo C() {
        return this.searchInfo;
    }

    public Integer Code() {
        return this.hwNonPersonalizedAd;
    }

    public void Code(Boolean bool) {
        this.supportFa = bool;
    }

    public void Code(String str) {
        this.consent = str;
    }

    public Boolean D() {
        return this.supportFa;
    }

    public String F() {
        return this.hwACString;
    }

    public Boolean I() {
        return this.requestLocation;
    }

    public void I(String str) {
        this.hwACString = str;
    }

    public String S() {
        return this.acString;
    }

    public Integer V() {
        return this.thirdNonPersonalizedAd;
    }

    public void V(String str) {
        this.acString = str;
    }

    public String Z() {
        return this.adContentClassification;
    }

    public String getAdContentClassification() {
        String str = this.adContentClassification;
        String str2 = str;
        if (str == null) {
            str2 = "";
        }
        return str2;
    }

    public App getApp() {
        return this.app;
    }

    public String getAppCountry() {
        return this.appCountry;
    }

    public String getAppLang() {
        return this.appLang;
    }

    public String getConsent() {
        return this.consent;
    }

    public Map<String, Bundle> getExtras() {
        return this.extras;
    }

    public Integer getNonPersonalizedAd() {
        return this.nonPersonalizedAd;
    }

    public Integer getTagForChildProtection() {
        return this.tagForChildProtection;
    }

    public Integer getTagForUnderAgeOfPromise() {
        return this.tagForUnderAgeOfPromise;
    }

    public boolean isRequestLocation() {
        Boolean bool = this.requestLocation;
        if (bool == null) {
            return true;
        }
        return bool.booleanValue();
    }

    public Builder toBuilder() {
        return new Builder().setTagForChildProtection(this.tagForChildProtection).setTagForUnderAgeOfPromise(this.tagForUnderAgeOfPromise).setAdContentClassification(this.adContentClassification).setNonPersonalizedAd(this.nonPersonalizedAd).setHwNonPersonalizedAd(this.hwNonPersonalizedAd).setThirdNonPersonalizedAd(this.thirdNonPersonalizedAd).setAppLang(this.appLang).setApp(this.app).setAppCountry(this.appCountry).setRequestLocation(this.requestLocation).setSearchTerm(this.searchTerm).setExtras(this.extras).setConsent(this.consent).setSearchInfo(this.searchInfo).Code(this.acString).V(this.hwACString).setSupportFa(this.supportFa);
    }
}
