package com.blued.android.module.common.utils;

import android.text.Editable;
import android.text.TextUtils;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.internal.ci;
import com.blued.android.framework.utils.EncryptTool;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.regex.Pattern;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/utils/CommonStringUtils.class */
public class CommonStringUtils {

    /* renamed from: a  reason: collision with root package name */
    private static final Pattern f10877a = Pattern.compile("\\s*|\t|\r|\n");

    public static double a(String str, double d) {
        if (TextUtils.isEmpty(str)) {
            return d;
        }
        try {
            return Double.valueOf(str).doubleValue();
        } catch (Exception e) {
            e.printStackTrace();
            return d;
        }
    }

    public static int a(Editable editable) {
        int i;
        int i2;
        int i3 = 0;
        for (int i4 = 0; i4 < editable.length(); i4++) {
            if (editable.charAt(i4) < 128) {
                i = i3;
                i2 = 1;
            } else {
                i = i3;
                i2 = 2;
            }
            i3 = i + i2;
        }
        return i3;
    }

    public static int a(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            return Integer.parseInt(str);
        } catch (Exception e) {
            return 0;
        }
    }

    public static int a(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return i;
        }
        try {
            return Integer.parseInt(str);
        } catch (Exception e) {
            e.printStackTrace();
            return i;
        }
    }

    public static String a(double d) {
        return d(String.valueOf(d));
    }

    public static String a(float f) {
        DecimalFormat decimalFormat = new DecimalFormat(ci.d);
        if (f > 1.0E8f) {
            return decimalFormat.format(f / 1.0E8f) + "y";
        } else if (f > 99999.0f) {
            return decimalFormat.format(f / 10000.0f) + IAdInterListener.AdReqParam.WIDTH;
        } else {
            return ((int) f) + "";
        }
    }

    public static String a(long j) {
        return d(String.valueOf(j));
    }

    public static String a(String str, String str2) {
        return TextUtils.isEmpty(str2) ? String.format("@%s", str) : String.format("@(name:%s,id:%s)", str, EncryptTool.b(str2));
    }

    public static float b(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0.0f;
        }
        try {
            return Float.parseFloat(str);
        } catch (Exception e) {
            e.printStackTrace();
            return 0.0f;
        }
    }

    public static String b(double d) {
        if (d <= 0.0d) {
            return "0";
        }
        if (d < 10000.0d) {
            return ((int) d) + "";
        } else if (d < 1.0E8d) {
            BigDecimal bigDecimal = new BigDecimal(d / 10000.0d);
            return bigDecimal.setScale(2, 4).doubleValue() + "万";
        } else {
            BigDecimal bigDecimal2 = new BigDecimal(d / 1.0E8d);
            return bigDecimal2.setScale(2, 4).doubleValue() + "亿";
        }
    }

    public static String b(float f) {
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        if (f > 1.0E8f) {
            return decimalFormat.format(f / 1.0E8f) + "y";
        } else if (f > 9999.0f) {
            return decimalFormat.format(f / 10000.0f) + IAdInterListener.AdReqParam.WIDTH;
        } else if (f > 999.0f) {
            return decimalFormat.format(f / 1000.0f) + "k";
        } else {
            return ((int) f) + "";
        }
    }

    public static String b(long j) {
        if (j >= 100000000) {
            int i = (int) ((j / 10000) / 10000);
            return i + "." + (((j - ((i * 10000) * 10000)) / 1000) / 10000) + "亿";
        } else if (j >= 10000) {
            int i2 = (int) (j / 10000);
            return i2 + "." + ((j - (i2 * 10000)) / 1000) + "万";
        } else {
            return String.valueOf(j);
        }
    }

    public static long c(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0L;
        }
        try {
            return Long.parseLong(str);
        } catch (Exception e) {
            e.printStackTrace();
            return 0L;
        }
    }

    public static String c(double d) {
        if (d <= 0.0d) {
            return "0";
        }
        if (d < 10000.0d) {
            return ((int) d) + "";
        }
        DecimalFormat decimalFormat = new DecimalFormat();
        decimalFormat.setMaximumFractionDigits(2);
        decimalFormat.setGroupingSize(0);
        decimalFormat.setRoundingMode(RoundingMode.FLOOR);
        return h(decimalFormat.format(d / 10000.0d)) + IAdInterListener.AdReqParam.WIDTH;
    }

    public static String d(double d) {
        if (d <= 0.0d) {
            return "0";
        }
        if (d < 10000.0d) {
            return ((int) d) + "";
        }
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        return h(decimalFormat.format(d / 10000.0d)) + IAdInterListener.AdReqParam.WIDTH;
    }

    public static String d(String str) {
        DecimalFormat decimalFormat;
        double d;
        if (TextUtils.isEmpty(str)) {
            return "0";
        }
        if (str.indexOf(".") > 0) {
            int length = (str.length() - str.indexOf(".")) - 1;
            decimalFormat = length == 0 ? new DecimalFormat("###,##0") : length == 1 ? new DecimalFormat("###,##0.0") : new DecimalFormat("###,##0.00");
        } else {
            decimalFormat = new DecimalFormat("###,##0");
        }
        try {
            d = Double.parseDouble(str);
        } catch (Exception e) {
            d = 0.0d;
        }
        String format = decimalFormat.format(d);
        String str2 = format;
        if (format.indexOf(".") > 0) {
            str2 = format.replaceAll("0+?$", "").replaceAll("[.]$", "");
        }
        return str2;
    }

    public static int e(String str) {
        int i;
        int i2;
        int i3 = 0;
        for (int i4 = 0; i4 < str.length(); i4++) {
            if (str.charAt(i4) < 128) {
                i = i3;
                i2 = 1;
            } else {
                i = i3;
                i2 = 2;
            }
            i3 = i + i2;
        }
        return i3;
    }

    public static String f(String str) {
        return str != null ? f10877a.matcher(str).replaceAll("") : "";
    }

    public static String g(String str) {
        return b(a(str, 0.0d));
    }

    private static String h(String str) {
        return new BigDecimal(str).stripTrailingZeros().toPlainString();
    }
}
