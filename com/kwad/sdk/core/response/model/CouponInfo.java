package com.kwad.sdk.core.response.model;

import android.text.TextUtils;
import java.io.Serializable;
import java.text.DecimalFormat;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/response/model/CouponInfo.class */
public class CouponInfo extends com.kwad.sdk.core.response.kwai.a implements com.kwad.sdk.core.b, Serializable {
    private static final float COUPON_DISCOUNT_THRESHOLD = 20.0f;
    public static final String JINNIIU_DISCOUNT = "2";
    public static final String JINNIIU_PRICE_BREAK_DISCOUNT = "1";
    private static final long serialVersionUID = -9143537899646897962L;
    public String displayActionWords;
    public String displayBase;
    public String displayDiscount;
    public String displayName;
    public String displayTitle;
    public String displayType;
    public String displayValue;

    public static String jinniuFormatCoupon(CouponInfo couponInfo) {
        String str;
        StringBuilder sb;
        if (couponInfo == null) {
            return null;
        }
        String displayType = couponInfo.getDisplayType();
        String rinToYuan = rinToYuan(couponInfo.getDisplayValue());
        boolean z = true;
        int hashCode = displayType.hashCode();
        if (hashCode != 49) {
            if (hashCode == 50 && displayType.equals("2")) {
                z = true;
            }
        } else if (displayType.equals("1")) {
            z = false;
        }
        if (!z) {
            String rinToYuan2 = rinToYuan(couponInfo.getDisplayBase());
            str = null;
            if (!TextUtils.isEmpty(rinToYuan2)) {
                str = null;
                if (!TextUtils.isEmpty(rinToYuan)) {
                    if (couponInfo.isNoPreRequirement()) {
                        sb = new StringBuilder("¥");
                    } else {
                        sb = new StringBuilder();
                        sb.append(rinToYuan2);
                        sb.append("减");
                    }
                    sb.append(rinToYuan);
                    str = sb.toString();
                }
            }
        } else if (!z) {
            return null;
        } else {
            str = null;
            if (!TextUtils.isEmpty(rinToYuan)) {
                try {
                    if (Float.parseFloat(rinToYuan) >= 20.0f) {
                        return "¥" + rinToYuan;
                    }
                    return couponInfo.getFormattedDisplayDiscount() + "折";
                } catch (Exception e) {
                    return null;
                }
            }
        }
        return str;
    }

    public static String rinToYuan(String str) {
        if (str == null) {
            return null;
        }
        try {
            return new DecimalFormat("#.#").format(Float.parseFloat(str) / 1000.0f);
        } catch (Exception e) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(e);
            return null;
        }
    }

    public String getDisplayActionWords() {
        return this.displayActionWords;
    }

    public String getDisplayBase() {
        return this.displayBase;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public String getDisplayTitle() {
        return this.displayTitle;
    }

    public String getDisplayType() {
        return this.displayType;
    }

    public String getDisplayValue() {
        return this.displayValue;
    }

    public String getFormattedDisplayDiscount() {
        try {
            return new DecimalFormat("#.#").format(Float.valueOf(this.displayDiscount).floatValue() / 10.0f);
        } catch (Exception e) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(e);
            return null;
        }
    }

    public String getFormattedJinniuPrefix() {
        String displayType = getDisplayType();
        if (isNoPreRequirement()) {
            return "券";
        }
        if ("1".equals(displayType)) {
            return "满";
        }
        if ("2".equals(displayType)) {
            return "券";
        }
        return null;
    }

    public boolean isNoPreRequirement() {
        String str = this.displayBase;
        boolean z = false;
        if (str == null) {
            return false;
        }
        try {
            if (Float.parseFloat(str) <= 0.0f) {
                z = true;
            }
            return z;
        } catch (Exception e) {
            return false;
        }
    }

    public void setDisplayDiscount(String str) {
        this.displayDiscount = str;
    }
}
