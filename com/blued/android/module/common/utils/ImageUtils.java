package com.blued.android.module.common.utils;

import android.graphics.BitmapFactory;
import android.media.ExifInterface;
import android.text.TextUtils;
import android.util.Size;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.utils.Logger;
import com.blued.android.framework.view.badgeview.DisplayUtil;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/utils/ImageUtils.class */
public class ImageUtils {
    public static int[] a(int i, int i2) {
        int i3;
        int i4;
        if (i == 0 || i2 == 0) {
            i3 = 0;
            i4 = 0;
        } else if (i > i2) {
            int i5 = AppInfo.l;
            i4 = (AppInfo.l * i) / i2;
            i3 = i5;
        } else {
            int i6 = AppInfo.l;
            i3 = (AppInfo.l * i2) / i;
            i4 = i6;
        }
        return new int[]{i4, i3};
    }

    public static int[] a(int i, int i2, int i3) {
        int i4;
        if (i > i2) {
            i4 = (i * i3) / i2;
        } else {
            int i5 = (i2 * i3) / i;
            i4 = i3;
            i3 = i5;
        }
        return new int[]{i4, i3};
    }

    public static int[] a(int i, int i2, int i3, int i4, int i5, int i6) {
        int[] iArr = new int[2];
        if (i == 0 || i2 == 0) {
            iArr[0] = i5;
            iArr[1] = i6;
            return iArr;
        } else if (i == i2) {
            iArr[0] = i5;
            iArr[1] = i5;
            return iArr;
        } else {
            float f = i / i2;
            if (i > i2) {
                float f2 = i3 / f;
                float f3 = i4;
                float f4 = f2;
                if (f2 > f3) {
                    f4 = f3;
                }
                float f5 = i6;
                float f6 = f4;
                if (f4 < f5) {
                    f6 = f5;
                }
                iArr[0] = i3;
                iArr[1] = (int) f6;
                return iArr;
            }
            float f7 = i4 * f;
            float f8 = i3;
            float f9 = f7;
            if (f7 > f8) {
                i4 = (int) (f8 / f);
                f9 = f8;
            }
            float f10 = i5;
            float f11 = f9;
            if (f9 < f10) {
                f11 = f10;
            }
            iArr[0] = (int) f11;
            iArr[1] = i4;
            return iArr;
        }
    }

    public static String[] a(String str) {
        if (str == null) {
            return new String[]{"0", "0"};
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        String[] strArr = {String.valueOf(options.outWidth), String.valueOf(options.outHeight)};
        Logger.a("ddrb", "outWidth = ", strArr[0]);
        Logger.a("ddrb", "outHeight = ", strArr[1]);
        return strArr;
    }

    public static Size b(int i, int i2) {
        int i3;
        int i4;
        float f = (i * 1.0f) / i2;
        int a = DisplayUtil.a(AppInfo.d(), 200.0f);
        int a2 = DisplayUtil.a(AppInfo.d(), 135.0f);
        int a3 = DisplayUtil.a(AppInfo.d(), 120.0f);
        if (f > 1.4814814f) {
            i3 = a2;
        } else if (f <= 0.6f) {
            i3 = a;
            a = a3;
        } else if (f > 1.0f) {
            if (i < a3) {
                i4 = a3;
            } else {
                i4 = i;
                if (i > a) {
                    i4 = a;
                }
            }
            i3 = (int) (i4 / f);
            a = i4;
        } else {
            if (i2 < a2) {
                i3 = a2;
            } else {
                i3 = i2;
                if (i2 > a) {
                    i3 = a;
                }
            }
            a = (int) (i3 * f);
        }
        return new Size(a, i3);
    }

    public static int[] b(int i, int i2, int i3, int i4, int i5, int i6) {
        int[] iArr = new int[2];
        if (i == 0 || i2 == 0) {
            iArr[0] = i5;
            iArr[1] = i6;
            return iArr;
        } else if (i == i2) {
            iArr[0] = i5;
            iArr[1] = i6;
            return iArr;
        } else {
            float f = i / i2;
            if (i > i2) {
                iArr[0] = i3;
                iArr[1] = (int) (i3 / f);
                return iArr;
            }
            iArr[0] = (int) (f * i4);
            iArr[1] = i4;
            return iArr;
        }
    }

    public static int[] b(String str) {
        if (str == null) {
            return new int[]{0, 0};
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inInputShareable = true;
        options.inPurgeable = true;
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        int[] iArr = {DensityUtils.b(AppInfo.d(), options.outWidth), DensityUtils.b(AppInfo.d(), options.outHeight)};
        Logger.a("ddrb", "outWidth = ", Integer.valueOf(iArr[0]));
        Logger.a("ddrb", "outHeight = ", Integer.valueOf(iArr[1]));
        return iArr;
    }

    public static int c(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return 0;
            }
            int attributeInt = new ExifInterface(str).getAttributeInt("Orientation", 1);
            if (attributeInt != 3) {
                if (attributeInt != 6) {
                    return attributeInt != 8 ? 0 : 270;
                }
                return 90;
            }
            return 180;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}
