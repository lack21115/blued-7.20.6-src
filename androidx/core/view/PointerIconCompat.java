package androidx.core.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Build;
import android.view.PointerIcon;

/* loaded from: source-8756600-dex2jar.jar:androidx/core/view/PointerIconCompat.class */
public final class PointerIconCompat {
    public static final int TYPE_ALIAS = 1010;
    public static final int TYPE_ALL_SCROLL = 1013;
    public static final int TYPE_ARROW = 1000;
    public static final int TYPE_CELL = 1006;
    public static final int TYPE_CONTEXT_MENU = 1001;
    public static final int TYPE_COPY = 1011;
    public static final int TYPE_CROSSHAIR = 1007;
    public static final int TYPE_DEFAULT = 1000;
    public static final int TYPE_GRAB = 1020;
    public static final int TYPE_GRABBING = 1021;
    public static final int TYPE_HAND = 1002;
    public static final int TYPE_HELP = 1003;
    public static final int TYPE_HORIZONTAL_DOUBLE_ARROW = 1014;
    public static final int TYPE_NO_DROP = 1012;
    public static final int TYPE_NULL = 0;
    public static final int TYPE_TEXT = 1008;
    public static final int TYPE_TOP_LEFT_DIAGONAL_DOUBLE_ARROW = 1017;
    public static final int TYPE_TOP_RIGHT_DIAGONAL_DOUBLE_ARROW = 1016;
    public static final int TYPE_VERTICAL_DOUBLE_ARROW = 1015;
    public static final int TYPE_VERTICAL_TEXT = 1009;
    public static final int TYPE_WAIT = 1004;
    public static final int TYPE_ZOOM_IN = 1018;
    public static final int TYPE_ZOOM_OUT = 1019;

    /* renamed from: a  reason: collision with root package name */
    private Object f2654a;

    private PointerIconCompat(Object obj) {
        this.f2654a = obj;
    }

    public static PointerIconCompat create(Bitmap bitmap, float f, float f2) {
        return Build.VERSION.SDK_INT >= 24 ? new PointerIconCompat(PointerIcon.create(bitmap, f, f2)) : new PointerIconCompat(null);
    }

    public static PointerIconCompat getSystemIcon(Context context, int i) {
        return Build.VERSION.SDK_INT >= 24 ? new PointerIconCompat(PointerIcon.getSystemIcon(context, i)) : new PointerIconCompat(null);
    }

    public static PointerIconCompat load(Resources resources, int i) {
        return Build.VERSION.SDK_INT >= 24 ? new PointerIconCompat(PointerIcon.load(resources, i)) : new PointerIconCompat(null);
    }

    public Object getPointerIcon() {
        return this.f2654a;
    }
}
