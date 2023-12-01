package com.blued.android.module.common.utils;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.TextView;
import com.blued.android.core.AppMethods;
import com.blued.android.core.BlueAppLocal;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.module.common.R;
import com.blued.android.module.common.login.model.UserBasicModel;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Locale;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/utils/DistanceUtils.class */
public class DistanceUtils {

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/utils/DistanceUtils$HIDE_DISTANCE_DRAW_ICON_OPT.class */
    interface HIDE_DISTANCE_DRAW_ICON_OPT {
    }

    public static double a(double d, double d2, double d3, double d4) {
        if (d * d2 * d3 * d4 == 0.0d) {
            return 0.0d;
        }
        double radians = Math.toRadians(d - d3);
        double radians2 = Math.toRadians(d2 - d4);
        double d5 = radians / 2.0d;
        double d6 = radians2 / 2.0d;
        double sin = (Math.sin(d5) * Math.sin(d5)) + (Math.cos(Math.toRadians(d)) * Math.cos(Math.toRadians(d3)) * Math.sin(d6) * Math.sin(d6));
        return Math.atan2(Math.sqrt(sin), Math.sqrt(1.0d - sin)) * 2.0d * 6371.0d;
    }

    public static String a(Context context, Long l) {
        if (BlueAppLocal.d()) {
            if (l.longValue() < 100000 || l.longValue() >= 100000000) {
                if (l.longValue() < 100000000) {
                    return d(l + "");
                }
                return d(Math.round(((float) l.longValue()) / 1.0E7f) + "") + context.getResources().getString(R.string.count_second_lvl_unit);
            } else if (Math.round(((float) l.longValue()) / 1.0E7f) * 10000000 >= 100000000) {
                return d(Math.round(((float) l.longValue()) / 1.0E7f) + "") + context.getResources().getString(R.string.count_second_lvl_unit);
            } else {
                return d(Math.round(((float) l.longValue()) / 10000.0f) + "") + context.getResources().getString(R.string.count_first_lvl_unit);
            }
        } else if (l.longValue() < 100000 || l.longValue() >= 1000000) {
            if (l.longValue() < 1000000) {
                return d(l + "");
            }
            return d(Math.round(((float) l.longValue()) / 1000000.0f) + "") + context.getResources().getString(R.string.count_second_lvl_unit);
        } else if (Math.round(((float) l.longValue()) / 1000.0f) * 1000 >= 1000000) {
            return d(Math.round(((float) l.longValue()) / 1000000.0f) + "") + context.getResources().getString(R.string.count_second_lvl_unit);
        } else {
            return d(Math.round(((float) l.longValue()) / 1000.0f) + "") + context.getResources().getString(R.string.count_first_lvl_unit);
        }
    }

    public static String a(Context context, String str) {
        try {
            return a(context, Long.valueOf(Long.parseLong(str)));
        } catch (Exception e) {
            return "0";
        }
    }

    public static String a(Long l) {
        if (l.longValue() <= 10000) {
            return l.toString();
        }
        BigDecimal divide = new BigDecimal(l.longValue()).divide(new BigDecimal(10000), 2, RoundingMode.HALF_UP);
        BigDecimal bigDecimal = divide;
        if (divide.scale() > 0) {
            bigDecimal = divide.setScale(2, RoundingMode.HALF_UP);
        }
        return bigDecimal.stripTrailingZeros().toPlainString() + "w";
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str) || !str.endsWith("km")) {
            try {
                double doubleValue = Double.valueOf(str).doubleValue();
                if (doubleValue >= 100.0d) {
                    int floor = (int) Math.floor(doubleValue);
                    return floor + "";
                }
                return new DecimalFormat("#0.00").format(doubleValue);
            } catch (Exception e) {
                e.printStackTrace();
                return "0";
            }
        }
        return str.substring(0, str.length() - 2);
    }

    public static String a(String str, Locale locale, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        int c = CommonPreferences.c();
        if (c == 1) {
            StringBuilder sb = new StringBuilder();
            sb.append(a(str));
            sb.append(z ? " km" : "km");
            return sb.toString();
        } else if (c != 2) {
            return "";
        } else {
            double a = StringUtils.a(str, 0.0d) * 0.62d;
            if (a >= 1000.0d) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append((int) Math.round(a));
                sb2.append(z ? " mi" : "mi");
                return sb2.toString();
            }
            DecimalFormat decimalFormat = new DecimalFormat("#0.00");
            StringBuilder sb3 = new StringBuilder();
            sb3.append(decimalFormat.format(a));
            sb3.append(z ? " mi" : "mi");
            return sb3.toString();
        }
    }

    public static void a(Context context, int i, TextView textView, int i2) {
        if (textView != null) {
            textView.setText(context.getResources().getString(R.string.secret));
            if (i > 0) {
                Drawable drawable = context.getResources().getDrawable(i);
                if (i2 == 0) {
                    drawable.setBounds(0, 0, AppMethods.a(11), AppMethods.a(11));
                } else {
                    drawable.setBounds(0, 0, AppMethods.a(i2), AppMethods.a(i2));
                }
                textView.setCompoundDrawables(drawable, null, null, null);
                textView.setCompoundDrawablePadding(DensityUtils.a(context, 3.0f));
            }
        }
    }

    public static void a(Context context, TextView textView, int i, int i2) {
        UserBasicModel userBasicModel = new UserBasicModel();
        userBasicModel.is_hide_distance = i;
        a(context, textView, userBasicModel, i2, 0, true);
    }

    public static void a(Context context, TextView textView, int i, int i2, int i3) {
        if (i != 1) {
            textView.setCompoundDrawables(null, null, null, null);
            return;
        }
        int i4 = -1;
        if (i2 == 1) {
            i4 = R.drawable.icon_city_secret;
        }
        a(context, i4, textView, i3);
    }

    public static void a(Context context, TextView textView, int i, int i2, boolean z) {
        UserBasicModel userBasicModel = new UserBasicModel();
        userBasicModel.is_hide_distance = i;
        a(context, textView, userBasicModel, i2, 0, z);
    }

    public static void a(Context context, TextView textView, UserBasicModel userBasicModel, int i) {
        a(context, textView, userBasicModel, i, 0, true);
    }

    public static void a(Context context, TextView textView, UserBasicModel userBasicModel, int i, int i2, boolean z) {
        int i3;
        if (userBasicModel.is_hide_distance != 1) {
            textView.setCompoundDrawables(null, null, null, null);
            return;
        }
        if (i == 1) {
            i3 = R.drawable.icon_distance_secret;
        } else {
            i3 = -1;
            if (i == 2) {
                i3 = -1;
                if (textView != null) {
                    if (z) {
                        textView.setText(context.getResources().getString(R.string.distance_secret));
                        return;
                    } else {
                        textView.setVisibility(8);
                        return;
                    }
                }
            }
        }
        if (textView != null) {
            textView.setText(context.getResources().getString(R.string.secret));
            if (i3 > 0) {
                Drawable drawable = context.getResources().getDrawable(i3);
                if (i2 == 0) {
                    drawable.setBounds(0, 0, AppMethods.a(11), AppMethods.a(11));
                } else {
                    drawable.setBounds(0, 0, AppMethods.a(i2), AppMethods.a(i2));
                }
                textView.setCompoundDrawables(drawable, null, null, null);
                textView.setCompoundDrawablePadding(DensityUtils.a(context, 3.0f));
            }
        }
        textView.setVisibility(0);
    }

    public static String b(String str) {
        if (TextUtils.isEmpty(str) || !str.endsWith("km")) {
            try {
                double doubleValue = Double.valueOf(str).doubleValue();
                return doubleValue >= 100.0d ? new DecimalFormat("#0.00").format(doubleValue) : new DecimalFormat("#0.00").format(doubleValue);
            } catch (Exception e) {
                e.printStackTrace();
                return "0";
            }
        }
        return str.substring(0, str.length() - 2);
    }

    public static String b(String str, Locale locale, boolean z) {
        if (StringUtils.b(str)) {
            return "";
        }
        int c = CommonPreferences.c();
        if (c == 1) {
            StringBuilder sb = new StringBuilder();
            sb.append(b(str));
            sb.append(z ? " km" : "km");
            return sb.toString();
        } else if (c != 2) {
            return "";
        } else {
            double a = StringUtils.a(str, 0.0d) * 0.62d;
            if (a >= 1000.0d) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append((int) Math.round(a));
                sb2.append(z ? " mi" : "mi");
                return sb2.toString();
            }
            DecimalFormat decimalFormat = new DecimalFormat("#0.00");
            StringBuilder sb3 = new StringBuilder();
            sb3.append(decimalFormat.format(a));
            sb3.append(z ? " mi" : "mi");
            return sb3.toString();
        }
    }

    public static void b(Context context, TextView textView, int i, int i2) {
        a(context, textView, i, i2, 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean c(java.lang.String r3) {
        /*
            r0 = r3
            boolean r0 = com.blued.android.framework.utils.StringUtils.b(r0)
            r6 = r0
            r0 = 0
            r5 = r0
            r0 = r6
            if (r0 != 0) goto L2b
            r0 = r3
            java.lang.String r1 = "."
            boolean r0 = r0.contains(r1)     // Catch: java.lang.Exception -> L26
            if (r0 == 0) goto L1e
            r0 = r3
            float r0 = java.lang.Float.parseFloat(r0)     // Catch: java.lang.Exception -> L26
            int r0 = (int) r0     // Catch: java.lang.Exception -> L26
            r4 = r0
            goto L2d
        L1e:
            r0 = r3
            int r0 = java.lang.Integer.parseInt(r0)     // Catch: java.lang.Exception -> L26
            r4 = r0
            goto L2d
        L26:
            r3 = move-exception
            r0 = r3
            r0.printStackTrace()
        L2b:
            r0 = 0
            r4 = r0
        L2d:
            r0 = r4
            r1 = 99999(0x1869f, float:1.40128E-40)
            if (r0 != r1) goto L36
            r0 = 1
            r5 = r0
        L36:
            r0 = r5
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.common.utils.DistanceUtils.c(java.lang.String):boolean");
    }

    public static String d(String str) {
        double d;
        if (TextUtils.isEmpty(str)) {
            return "0";
        }
        DecimalFormat decimalFormat = str.indexOf(".") > 0 ? (str.length() - str.indexOf(".")) - 1 == 0 ? new DecimalFormat("###,##0") : (str.length() - str.indexOf(".")) - 1 == 1 ? new DecimalFormat("###,##0.0") : new DecimalFormat("###,##0.00") : new DecimalFormat("###,##0");
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
}
