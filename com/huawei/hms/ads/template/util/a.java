package com.huawei.hms.ads.template.util;

import android.app.backup.FullBackup;
import android.content.Context;
import android.graphics.Color;
import android.provider.CalendarContract;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Pair;
import android.util.TypedValue;
import android.view.ViewGroup;
import com.alipay.sdk.util.i;
import com.huawei.hms.ads.ge;
import com.huawei.hms.ads.jsb.constant.Constant;
import com.kuaishou.weapon.p0.t;
import java.util.Locale;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/template/util/a.class */
public abstract class a {
    private static final String Code = a.class.getSimpleName();

    public static int Code(int i) {
        if (i == Integer.MIN_VALUE) {
            return Integer.MAX_VALUE;
        }
        return i > 0 ? i : -i;
    }

    public static int Code(String str) {
        boolean z;
        String lowerCase = str.toLowerCase(Locale.US);
        int hashCode = lowerCase.hashCode();
        int i = 0;
        if (hashCode == -1901805651) {
            if (lowerCase.equals("invisible")) {
                z = true;
            }
            z = true;
        } else if (hashCode != 3178655) {
            if (hashCode == 466743410 && lowerCase.equals(CalendarContract.CalendarColumns.VISIBLE)) {
                z = false;
            }
            z = true;
        } else {
            if (lowerCase.equals("gone")) {
                z = true;
            }
            z = true;
        }
        if (z) {
            if (!z) {
                return !z ? 0 : 8;
            }
            i = 4;
        }
        return i;
    }

    public static int Code(String str, int i) {
        if (str.startsWith("#")) {
            try {
                return Color.parseColor(str);
            } catch (IllegalArgumentException e) {
                String str2 = Code;
                ge.I(str2, "parseColorFromString - " + e.getClass().getSimpleName());
            }
        }
        return i;
    }

    public static int Code(String str, Context context) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        if (str.endsWith(t.q)) {
            return V(str, context, 0);
        }
        if (str.endsWith(FullBackup.SHAREDPREFS_TREE_TOKEN)) {
            return Code(str, context, 0);
        }
        if (str.endsWith("px")) {
            return V(str, 0);
        }
        return 0;
    }

    private static int Code(String str, Context context, int i) {
        if (str.indexOf(FullBackup.SHAREDPREFS_TREE_TOKEN) > 0) {
            String substring = str.substring(0, str.length() - 2);
            try {
                return (int) TypedValue.applyDimension(2, substring.contains(".") ? Float.parseFloat(substring) : Integer.parseInt(substring), context.getResources().getDisplayMetrics());
            } catch (NumberFormatException e) {
                ge.I(Code, "processSpSize - error in parse int");
            }
        }
        return i;
    }

    public static Pair<Integer, Integer> Code(AttributeSet attributeSet, Context context) {
        String attributeValue = attributeSet.getAttributeValue(null, "layout_width");
        String attributeValue2 = attributeSet.getAttributeValue(null, "layout_height");
        ge.Code(Code, "generateLayoutParams layoutWidth: %s layoutHeight: %s", attributeValue, attributeValue2);
        return new Pair<>(Integer.valueOf(V(attributeValue, context)), Integer.valueOf(V(attributeValue2, context)));
    }

    public static void Code(Context context, ViewGroup.MarginLayoutParams marginLayoutParams, AttributeSet attributeSet) {
        if (attributeSet == null || marginLayoutParams == null) {
            return;
        }
        String attributeValue = attributeSet.getAttributeValue(null, "layout_margin");
        if (!TextUtils.isEmpty(attributeValue)) {
            int Code2 = Code(attributeValue, context);
            marginLayoutParams.setMargins(Code2, Code2, Code2, Code2);
        }
        String attributeValue2 = attributeSet.getAttributeValue(null, "layout_marginStart");
        if (!TextUtils.isEmpty(attributeValue2)) {
            marginLayoutParams.setMarginStart(Code(attributeValue2, context));
        }
        String attributeValue3 = attributeSet.getAttributeValue(null, "layout_marginEnd");
        if (!TextUtils.isEmpty(attributeValue3)) {
            marginLayoutParams.setMarginEnd(Code(attributeValue3, context));
        }
        int i = marginLayoutParams.leftMargin;
        int i2 = marginLayoutParams.rightMargin;
        int i3 = marginLayoutParams.topMargin;
        int i4 = marginLayoutParams.bottomMargin;
        String attributeValue4 = attributeSet.getAttributeValue(null, "layout_marginLeft");
        if (!TextUtils.isEmpty(attributeValue4)) {
            i = Code(attributeValue4, context);
        }
        String attributeValue5 = attributeSet.getAttributeValue(null, "layout_marginRight");
        if (!TextUtils.isEmpty(attributeValue5)) {
            i2 = Code(attributeValue5, context);
        }
        String attributeValue6 = attributeSet.getAttributeValue(null, "layout_marginTop");
        if (!TextUtils.isEmpty(attributeValue6)) {
            i3 = Code(attributeValue6, context);
        }
        String attributeValue7 = attributeSet.getAttributeValue(null, "layout_marginBottom");
        if (!TextUtils.isEmpty(attributeValue7)) {
            i4 = Code(attributeValue7, context);
        }
        marginLayoutParams.setMargins(i, i3, i2, i4);
    }

    public static String I(String str) {
        if (TextUtils.isEmpty(str) || str.length() <= 3 || !str.startsWith("#{") || !str.endsWith(i.d)) {
            return null;
        }
        return str.substring(2, str.length() - 1);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static int V(String str) {
        boolean z;
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        switch (str.hashCode()) {
            case -1383228885:
                if (str.equals("bottom")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case -1364013995:
                if (str.equals("center")) {
                    z = false;
                    break;
                }
                z = true;
                break;
            case -348726240:
                if (str.equals("center_vertical")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 100571:
                if (str.equals("end")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 115029:
                if (str.equals(Constant.MAP_KEY_TOP)) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 3317767:
                if (str.equals("left")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 108511772:
                if (str.equals("right")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 109757538:
                if (str.equals("start")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 1063616078:
                if (str.equals("center_horizontal")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            default:
                z = true;
                break;
        }
        switch (z) {
            case false:
                return 17;
            case true:
                return 3;
            case true:
                return 5;
            case true:
                return 48;
            case true:
                return 80;
            case true:
                return 1;
            case true:
                return 16;
            case true:
                return 8388611;
            case true:
                return 8388613;
            default:
                return -1;
        }
    }

    private static int V(String str, int i) {
        if (str.indexOf("px") > 0) {
            String substring = str.substring(0, str.length() - 2);
            try {
                return (int) (substring.contains(".") ? Float.parseFloat(substring) : Integer.parseInt(substring));
            } catch (NumberFormatException e) {
                ge.I(Code, "processSpSize - error in parse int");
            }
        }
        return i;
    }

    private static int V(String str, Context context) {
        if (TextUtils.isEmpty(str) || TextUtils.equals(str, "match_parent")) {
            return -1;
        }
        if (TextUtils.equals(str, "wrap_content")) {
            return -2;
        }
        if (str.endsWith(t.q)) {
            return V(str, context, -2);
        }
        if (str.endsWith(FullBackup.SHAREDPREFS_TREE_TOKEN)) {
            return Code(str, context, -2);
        }
        if (str.endsWith("px")) {
            return V(str, -2);
        }
        return -2;
    }

    private static int V(String str, Context context, int i) {
        if (str.indexOf(t.q) > 0) {
            String substring = str.substring(0, str.length() - 2);
            try {
                return (int) TypedValue.applyDimension(1, substring.contains(".") ? Float.parseFloat(substring) : Integer.parseInt(substring), context.getResources().getDisplayMetrics());
            } catch (NumberFormatException e) {
                ge.I(Code, "processDpSize - error in parse int");
            }
        }
        return i;
    }
}
