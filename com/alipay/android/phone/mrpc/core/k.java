package com.alipay.android.phone.mrpc.core;

import android.text.format.Time;
import com.amap.api.services.core.AMapException;
import com.android.internal.R;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: source-6737240-dex2jar.jar:com/alipay/android/phone/mrpc/core/k.class */
public final class k {
    private static final Pattern a = Pattern.compile("([0-9]{1,2})[- ]([A-Za-z]{3,9})[- ]([0-9]{2,4})[ ]([0-9]{1,2}:[0-9][0-9]:[0-9][0-9])");
    private static final Pattern b = Pattern.compile("[ ]([A-Za-z]{3,9})[ ]+([0-9]{1,2})[ ]([0-9]{1,2}:[0-9][0-9]:[0-9][0-9])[ ]([0-9]{2,4})");

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-6737240-dex2jar.jar:com/alipay/android/phone/mrpc/core/k$a.class */
    public static final class a {
        int a;
        int b;
        int c;

        a(int i, int i2, int i3) {
            this.a = i;
            this.b = i2;
            this.c = i3;
        }
    }

    public static long a(String str) {
        int c;
        int b2;
        a e;
        int d;
        Matcher matcher = a.matcher(str);
        if (matcher.find()) {
            b2 = b(matcher.group(1));
            c = c(matcher.group(2));
            d = d(matcher.group(3));
            e = e(matcher.group(4));
        } else {
            Matcher matcher2 = b.matcher(str);
            if (!matcher2.find()) {
                throw new IllegalArgumentException();
            }
            c = c(matcher2.group(1));
            b2 = b(matcher2.group(2));
            e = e(matcher2.group(3));
            d = d(matcher2.group(4));
        }
        if (d >= 2038) {
            b2 = 1;
            c = 0;
            d = 2038;
        }
        Time time = new Time("UTC");
        time.set(e.c, e.b, e.a, b2, c, d);
        return time.toMillis(false);
    }

    private static int b(String str) {
        return str.length() == 2 ? ((str.charAt(0) - '0') * 10) + (str.charAt(1) - '0') : str.charAt(0) - '0';
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private static int c(String str) {
        int lowerCase = ((Character.toLowerCase(str.charAt(0)) + Character.toLowerCase(str.charAt(1))) + Character.toLowerCase(str.charAt(2))) - R.styleable.Theme_preferencePanelStyle;
        int i = 9;
        if (lowerCase != 9) {
            if (lowerCase != 10) {
                if (lowerCase != 22) {
                    if (lowerCase != 26) {
                        if (lowerCase != 29) {
                            if (lowerCase != 32) {
                                if (lowerCase != 40) {
                                    if (lowerCase != 42) {
                                        if (lowerCase != 48) {
                                            switch (lowerCase) {
                                                case 35:
                                                    break;
                                                case 36:
                                                    i = 4;
                                                    break;
                                                case 37:
                                                    return 8;
                                                default:
                                                    throw new IllegalArgumentException();
                                            }
                                            return i;
                                        }
                                        return 10;
                                    }
                                    return 5;
                                }
                                return 6;
                            }
                            return 3;
                        }
                        return 2;
                    }
                    return 7;
                }
                return 0;
            }
            return 1;
        }
        return 11;
    }

    private static int d(String str) {
        if (str.length() == 2) {
            int charAt = ((str.charAt(0) - '0') * 10) + (str.charAt(1) - '0');
            return charAt >= 70 ? charAt + AMapException.CODE_AMAP_CLIENT_UNKNOWN_ERROR : charAt + 2000;
        } else if (str.length() == 3) {
            return ((str.charAt(0) - '0') * 100) + ((str.charAt(1) - '0') * 10) + (str.charAt(2) - '0') + AMapException.CODE_AMAP_CLIENT_UNKNOWN_ERROR;
        } else {
            if (str.length() == 4) {
                return ((str.charAt(0) - '0') * 1000) + ((str.charAt(1) - '0') * 100) + ((str.charAt(2) - '0') * 10) + (str.charAt(3) - '0');
            }
            return 1970;
        }
    }

    private static a e(String str) {
        int i;
        int charAt = str.charAt(0) - '0';
        if (str.charAt(1) != ':') {
            i = 2;
            charAt = (charAt * 10) + (str.charAt(1) - '0');
        } else {
            i = 1;
        }
        int i2 = i + 1;
        int i3 = i2 + 1;
        char charAt2 = str.charAt(i2);
        char charAt3 = str.charAt(i3);
        int i4 = i3 + 1 + 1;
        return new a(charAt, ((charAt2 - '0') * 10) + (charAt3 - '0'), ((str.charAt(i4) - '0') * 10) + (str.charAt(i4 + 1) - '0'));
    }
}
