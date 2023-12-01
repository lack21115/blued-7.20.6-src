package android.view;

import android.graphics.Rect;

/* loaded from: source-9557208-dex2jar.jar:android/view/Gravity.class */
public class Gravity {
    public static final int AXIS_CLIP = 8;
    public static final int AXIS_PULL_AFTER = 4;
    public static final int AXIS_PULL_BEFORE = 2;
    public static final int AXIS_SPECIFIED = 1;
    public static final int AXIS_X_SHIFT = 0;
    public static final int AXIS_Y_SHIFT = 4;
    public static final int BOTTOM = 80;
    public static final int CENTER = 17;
    public static final int CENTER_HORIZONTAL = 1;
    public static final int CENTER_VERTICAL = 16;
    public static final int CLIP_HORIZONTAL = 8;
    public static final int CLIP_VERTICAL = 128;
    public static final int DISPLAY_CLIP_HORIZONTAL = 16777216;
    public static final int DISPLAY_CLIP_VERTICAL = 268435456;
    public static final int END = 8388613;
    public static final int FILL = 119;
    public static final int FILL_HORIZONTAL = 7;
    public static final int FILL_VERTICAL = 112;
    public static final int HORIZONTAL_GRAVITY_MASK = 7;
    public static final int LEFT = 3;
    public static final int NO_GRAVITY = 0;
    public static final int RELATIVE_HORIZONTAL_GRAVITY_MASK = 8388615;
    public static final int RELATIVE_LAYOUT_DIRECTION = 8388608;
    public static final int RIGHT = 5;
    public static final int START = 8388611;
    public static final int TOP = 48;
    public static final int VERTICAL_GRAVITY_MASK = 112;

    public static void apply(int i, int i2, int i3, Rect rect, int i4, int i5, Rect rect2) {
        switch (i & 6) {
            case 0:
                rect2.left = rect.left + (((rect.right - rect.left) - i2) / 2) + i4;
                rect2.right = rect2.left + i2;
                if ((i & 8) == 8) {
                    if (rect2.left < rect.left) {
                        rect2.left = rect.left;
                    }
                    if (rect2.right > rect.right) {
                        rect2.right = rect.right;
                        break;
                    }
                }
                break;
            case 1:
            case 3:
            default:
                rect2.left = rect.left + i4;
                rect2.right = rect.right + i4;
                break;
            case 2:
                rect2.left = rect.left + i4;
                rect2.right = rect2.left + i2;
                if ((i & 8) == 8 && rect2.right > rect.right) {
                    rect2.right = rect.right;
                    break;
                }
                break;
            case 4:
                rect2.right = rect.right - i4;
                rect2.left = rect2.right - i2;
                if ((i & 8) == 8 && rect2.left < rect.left) {
                    rect2.left = rect.left;
                    break;
                }
                break;
        }
        switch (i & 96) {
            case 0:
                rect2.top = rect.top + (((rect.bottom - rect.top) - i3) / 2) + i5;
                rect2.bottom = rect2.top + i3;
                if ((i & 128) == 128) {
                    if (rect2.top < rect.top) {
                        rect2.top = rect.top;
                    }
                    if (rect2.bottom > rect.bottom) {
                        rect2.bottom = rect.bottom;
                        return;
                    }
                    return;
                }
                return;
            case 32:
                rect2.top = rect.top + i5;
                rect2.bottom = rect2.top + i3;
                if ((i & 128) != 128 || rect2.bottom <= rect.bottom) {
                    return;
                }
                rect2.bottom = rect.bottom;
                return;
            case 64:
                rect2.bottom = rect.bottom - i5;
                rect2.top = rect2.bottom - i3;
                if ((i & 128) != 128 || rect2.top >= rect.top) {
                    return;
                }
                rect2.top = rect.top;
                return;
            default:
                rect2.top = rect.top + i5;
                rect2.bottom = rect.bottom + i5;
                return;
        }
    }

    public static void apply(int i, int i2, int i3, Rect rect, int i4, int i5, Rect rect2, int i6) {
        apply(getAbsoluteGravity(i, i6), i2, i3, rect, i4, i5, rect2);
    }

    public static void apply(int i, int i2, int i3, Rect rect, Rect rect2) {
        apply(i, i2, i3, rect, 0, 0, rect2);
    }

    public static void apply(int i, int i2, int i3, Rect rect, Rect rect2, int i4) {
        apply(getAbsoluteGravity(i, i4), i2, i3, rect, 0, 0, rect2);
    }

    public static void applyDisplay(int i, Rect rect, Rect rect2) {
        if ((268435456 & i) != 0) {
            if (rect2.top < rect.top) {
                rect2.top = rect.top;
            }
            if (rect2.bottom > rect.bottom) {
                rect2.bottom = rect.bottom;
            }
        } else {
            int i2 = 0;
            if (rect2.top < rect.top) {
                i2 = rect.top - rect2.top;
            } else if (rect2.bottom > rect.bottom) {
                i2 = rect.bottom - rect2.bottom;
            }
            if (i2 != 0) {
                if (rect2.height() > rect.bottom - rect.top) {
                    rect2.top = rect.top;
                    rect2.bottom = rect.bottom;
                } else {
                    rect2.top += i2;
                    rect2.bottom += i2;
                }
            }
        }
        if ((16777216 & i) != 0) {
            if (rect2.left < rect.left) {
                rect2.left = rect.left;
            }
            if (rect2.right > rect.right) {
                rect2.right = rect.right;
                return;
            }
            return;
        }
        int i3 = 0;
        if (rect2.left < rect.left) {
            i3 = rect.left - rect2.left;
        } else if (rect2.right > rect.right) {
            i3 = rect.right - rect2.right;
        }
        if (i3 != 0) {
            if (rect2.width() > rect.right - rect.left) {
                rect2.left = rect.left;
                rect2.right = rect.right;
                return;
            }
            rect2.left += i3;
            rect2.right += i3;
        }
    }

    public static void applyDisplay(int i, Rect rect, Rect rect2, int i2) {
        applyDisplay(getAbsoluteGravity(i, i2), rect, rect2);
    }

    public static int getAbsoluteGravity(int i, int i2) {
        int i3;
        int i4 = i;
        if ((8388608 & i) > 0) {
            if ((i & 8388611) == 8388611) {
                int i5 = i & (-8388612);
                i3 = i2 == 1 ? i5 | 5 : i5 | 3;
            } else {
                i3 = i;
                if ((i & 8388613) == 8388613) {
                    int i6 = i & (-8388614);
                    i3 = i2 == 1 ? i6 | 3 : i6 | 5;
                }
            }
            i4 = i3 & (-8388609);
        }
        return i4;
    }

    public static boolean isHorizontal(int i) {
        return i > 0 && (8388615 & i) != 0;
    }

    public static boolean isVertical(int i) {
        return i > 0 && (i & 112) != 0;
    }
}
