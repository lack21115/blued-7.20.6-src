package com.huawei.openalliance.ad.utils;

import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.huawei.hms.ads.dt;
import com.huawei.hms.ads.ge;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Locale;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/utils/j.class */
public class j {
    private static final String B = "ro.product.locale.region";
    private static final String C = "ro.product.locale";
    public static final String Code = "ro.hw.country";
    private static final String D = "la";
    private static final String F = "eu";
    public static final String I = "CN";
    private static final String L = "uk";
    private static final String S = "UNKNOWN";
    public static final String V = "msc.sys.country";
    private static final String Z = "CountryCodeBean";

    /* renamed from: a  reason: collision with root package name */
    private static final String f9388a = "gb";
    private static final String b = "cn";

    /* renamed from: c  reason: collision with root package name */
    private static final int f9389c = 2;
    private String d;

    public j(Context context) {
        this.d = "UNKNOWN";
        Code(context);
        this.d = this.d.toUpperCase(Locale.ENGLISH);
    }

    private void B(Context context) {
        int lastIndexOf;
        String Code2 = ay.Code(B);
        this.d = Code2;
        if (TextUtils.isEmpty(Code2)) {
            String Code3 = ay.Code(C);
            if (!TextUtils.isEmpty(Code3) && (lastIndexOf = Code3.lastIndexOf(Constants.ACCEPT_TIME_SEPARATOR_SERVER)) != -1) {
                this.d = Code3.substring(lastIndexOf + 1);
            }
        }
        if ("cn".equalsIgnoreCase(this.d)) {
            return;
        }
        this.d = "UNKNOWN";
    }

    private void Code(Context context) {
        if (context == null) {
            return;
        }
        try {
            V(context);
            if (V()) {
                ge.V(Z, "get issue_country code from VENDOR_COUNTRY");
                return;
            }
            I(context);
            if (V()) {
                ge.V(Z, "get issue_country code from SIM_COUNTRY");
            } else if (l.B(context)) {
                ge.V(Z, "pad skip locale get issue_country code from grs ip");
            } else {
                Z(context);
                if (V()) {
                    ge.V(Z, "get issue_country code from LOCALE_INFO");
                }
            }
        } catch (Throwable th) {
            ge.I(Z, "get CountryCode error");
        }
    }

    private void Code(Context context, boolean z) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getApplicationContext().getSystemService("phone");
        if (telephonyManager != null) {
            this.d = (!z || telephonyManager.getPhoneType() == 2) ? telephonyManager.getSimCountryIso() : telephonyManager.getNetworkCountryIso();
        }
        I();
    }

    private void I() {
        String str = this.d;
        if (str == null || str.length() != 2) {
            this.d = "UNKNOWN";
        }
    }

    private void I(Context context) {
        Code(context, false);
    }

    private void V(Context context) {
        String str;
        this.d = ay.Code(dt.Z(context) ? V : Code);
        if (F.equalsIgnoreCase(this.d) || D.equalsIgnoreCase(this.d)) {
            str = "UNKNOWN";
        } else if (!L.equalsIgnoreCase(this.d)) {
            I();
            return;
        } else {
            str = "gb";
        }
        this.d = str;
    }

    private boolean V() {
        return !"UNKNOWN".equals(this.d);
    }

    private void Z() {
        String country = Locale.getDefault().getCountry();
        this.d = country;
        if (TextUtils.isEmpty(country)) {
            this.d = "UNKNOWN";
        }
    }

    private void Z(Context context) {
        if (Build.VERSION.SDK_INT >= 28) {
            Z();
        } else {
            B(context);
        }
    }

    public String Code() {
        if (ge.Code()) {
            ge.Code(Z, "countryCode: %s", this.d);
        }
        return this.d;
    }
}
