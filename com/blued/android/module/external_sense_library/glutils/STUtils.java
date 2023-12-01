package com.blued.android.module.external_sense_library.glutils;

import android.graphics.Rect;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/external_sense_library/glutils/STUtils.class */
public class STUtils {
    public static Rect a(Rect rect, int i, int i2, int i3, int i4) {
        Rect rect2 = new Rect();
        float f = i2;
        float f2 = i;
        float f3 = f / f2;
        float f4 = i4;
        float f5 = i3;
        if (f3 < f4 / f5) {
            float f6 = f2 / f5;
            int i5 = ((int) (f4 - (f / f6))) / 2;
            if (rect.top <= 0) {
                rect2.top = i5;
                rect2.bottom = ((int) (rect.height() / f6)) + i5;
            } else {
                float f7 = i5;
                if (rect.bottom >= f + (f7 * f6)) {
                    rect2.bottom = i4 - 1;
                    rect2.top = (int) (rect2.bottom - (rect.height() / f6));
                } else {
                    rect2.top = (int) ((rect.top / f6) + f7);
                    rect2.bottom = (int) ((rect.bottom / f6) + f7);
                }
            }
            if (rect.left <= 0) {
                rect2.left = 0;
                rect2.right = (int) (rect.width() / f6);
                return rect2;
            } else if (rect.right + (i5 * f6) >= f2) {
                rect2.right = i3 - 1;
                rect2.left = (int) (rect2.right - (rect.width() / f6));
                return rect2;
            } else {
                rect2.left = (int) (rect.left / f6);
                rect2.right = (int) (rect.right / f6);
                return rect2;
            }
        }
        float f8 = f / f4;
        int i6 = ((int) (f5 - (f2 / f8))) / 2;
        if (rect.left <= 0) {
            rect2.left = i6;
            rect2.right = ((int) (rect.width() / f8)) + i6;
        } else {
            float f9 = i6;
            if (rect.right >= f2 + (f9 * f8)) {
                int i7 = i3 - i6;
                rect2.left = (int) (i7 - (rect.width() / f8));
                rect2.right = i7 - 1;
            } else {
                rect2.left = (int) ((rect.left / f8) + f9);
                rect2.right = (int) ((rect.right / f8) + f9);
            }
        }
        if (rect.top <= 0) {
            rect2.top = 0;
            rect2.bottom = (int) (rect.height() / f8);
            return rect2;
        } else if (rect.bottom >= i2) {
            rect2.bottom = i4 - 1;
            rect2.top = (int) (rect2.bottom - (rect.height() / f8));
            return rect2;
        } else {
            rect2.top = (int) (rect.top / f8);
            rect2.bottom = (int) (rect.bottom / f8);
            return rect2;
        }
    }

    public static Rect a(Rect rect, int i, int i2, boolean z) {
        int i3 = rect.left;
        rect.left = rect.top;
        rect.top = i2 - rect.right;
        rect.right = rect.bottom;
        rect.bottom = i2 - i3;
        if (z) {
            Rect rect2 = new Rect();
            rect2.left = i - rect.right;
            rect2.right = i - rect.left;
            rect2.top = rect.top;
            rect2.bottom = rect.bottom;
            return rect2;
        }
        return rect;
    }

    public static Rect b(Rect rect, int i, int i2, int i3, int i4) {
        float f = i2;
        float f2 = i;
        float f3 = f / f2;
        float f4 = i4;
        float f5 = i3;
        if (f3 >= f4 / f5) {
            float f6 = f / f4;
            float f7 = (int) (((f5 - (f2 / f6)) * f6) / 2.0f);
            rect.left = (int) ((rect.left * f6) - f7);
            rect.top = (int) (rect.top * f6);
            rect.right = (int) ((rect.right * f6) - f7);
            rect.bottom = (int) (rect.bottom * f6);
            return rect;
        }
        float f8 = f2 / f5;
        rect.left = (int) (rect.left * f8);
        float f9 = (int) (((f4 - (f / f8)) * f8) / 2.0f);
        rect.top = (int) ((rect.top * f8) - f9);
        rect.right = (int) (rect.right * f8);
        rect.bottom = (int) ((rect.bottom * f8) - f9);
        return rect;
    }

    public static Rect b(Rect rect, int i, int i2, boolean z) {
        int i3 = rect.left;
        rect.left = i2 - rect.bottom;
        rect.bottom = rect.right;
        rect.right = i2 - rect.top;
        rect.top = i3;
        if (z) {
            Rect rect2 = new Rect();
            rect2.left = rect.left;
            rect2.right = rect.right;
            rect2.top = i - rect.bottom;
            rect2.bottom = i - rect.top;
            return rect2;
        }
        return rect;
    }

    public static Rect c(Rect rect, int i, int i2, int i3, int i4) {
        if (rect == null) {
            return null;
        }
        if (i3 == 1 || i3 == 0) {
            if (i4 == 90 || i4 == 270) {
                if (i3 == 1 && i4 == 90) {
                    return a(rect, i2, i, true);
                }
                if (i3 == 1 && i4 == 270) {
                    return b(rect, i, i2, true);
                }
                if (i3 == 0 && i4 == 270) {
                    return b(rect, i, i2, false);
                }
                Rect rect2 = rect;
                if (i3 == 0) {
                    rect2 = rect;
                    if (i4 == 90) {
                        rect2 = a(rect, i2, i, false);
                    }
                }
                return rect2;
            }
            return rect;
        }
        return rect;
    }

    public static Rect d(Rect rect, int i, int i2, int i3, int i4) {
        if (rect == null) {
            return null;
        }
        if (i3 == 1 || i3 == 0) {
            if (i4 == 90 || i4 == 270) {
                if (i3 == 1 && i4 == 90) {
                    return b(rect, i2, i, true);
                }
                if (i3 == 1 && i4 == 270) {
                    return a(rect, i, i2, true);
                }
                if (i3 == 0 && i4 == 270) {
                    return a(rect, i, i2, false);
                }
                Rect rect2 = rect;
                if (i3 == 0) {
                    rect2 = rect;
                    if (i4 == 90) {
                        rect2 = b(rect, i2, i, false);
                    }
                }
                return rect2;
            }
            return rect;
        }
        return rect;
    }
}
