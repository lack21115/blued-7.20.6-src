package com.blued.android.framework.view.shape;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.utils.AppUtils;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/view/shape/ShapeHelper.class */
public class ShapeHelper {

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/view/shape/ShapeHelper$BG_MODEL.class */
    public interface BG_MODEL {
    }

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/view/shape/ShapeHelper$BG_STATE.class */
    public interface BG_STATE {
    }

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/view/shape/ShapeHelper$ShapeView.class */
    public interface ShapeView {
        ShapeModel getShapeModel();

        void setShapeModel(ShapeModel shapeModel);
    }

    private static GradientDrawable a(int i, ShapeModel shapeModel) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        GradientDrawable gradientDrawable = new GradientDrawable();
        if (i == 1) {
            i2 = shapeModel.l;
            i3 = shapeModel.o;
            i4 = shapeModel.w;
            i5 = shapeModel.x;
            i6 = shapeModel.y;
        } else if (i != 2) {
            i2 = shapeModel.k;
            i3 = shapeModel.n;
            i4 = shapeModel.t;
            i5 = shapeModel.u;
            i6 = shapeModel.v;
        } else {
            i2 = shapeModel.m;
            i3 = shapeModel.p;
            i4 = shapeModel.z;
            i5 = shapeModel.A;
            i6 = shapeModel.B;
        }
        int i7 = shapeModel.M;
        if (i7 == 0) {
            gradientDrawable.setStroke((int) shapeModel.q, i3, shapeModel.r, shapeModel.s);
            gradientDrawable.setColor(i2);
            a(gradientDrawable, shapeModel, i4, i5, i6);
        } else if (i7 == 1) {
            gradientDrawable.setStroke((int) shapeModel.q, i3, shapeModel.r, shapeModel.s);
            gradientDrawable.setColor(0);
        } else if (i7 == 2) {
            gradientDrawable.setStroke(0, 0, 0.0f, 0.0f);
            gradientDrawable.setColor(i2);
        } else if (i7 == 3) {
            gradientDrawable.setStroke(0, 0, 0.0f, 0.0f);
            a(gradientDrawable, shapeModel, i4, i5, i6);
        }
        if (shapeModel.N != 0) {
            gradientDrawable.setShape(shapeModel.N);
        }
        if (shapeModel.N != 1) {
            if (shapeModel.H != 0.0f) {
                gradientDrawable.setCornerRadius(shapeModel.H);
                return gradientDrawable;
            } else if (AppUtils.c() && shapeModel.aj) {
                gradientDrawable.setCornerRadii(new float[]{shapeModel.J, shapeModel.J, shapeModel.I, shapeModel.I, shapeModel.K, shapeModel.K, shapeModel.L, shapeModel.L});
                return gradientDrawable;
            } else {
                gradientDrawable.setCornerRadii(new float[]{shapeModel.I, shapeModel.I, shapeModel.J, shapeModel.J, shapeModel.L, shapeModel.L, shapeModel.K, shapeModel.K});
            }
        }
        return gradientDrawable;
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x00c5, code lost:
        if (r6.z != 0) goto L42;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.graphics.drawable.StateListDrawable a(com.blued.android.framework.view.shape.ShapeModel r6) {
        /*
            Method dump skipped, instructions count: 281
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.framework.view.shape.ShapeHelper.a(com.blued.android.framework.view.shape.ShapeModel):android.graphics.drawable.StateListDrawable");
    }

    private static void a(GradientDrawable gradientDrawable, ShapeModel shapeModel, int i, int i2, int i3) {
        GradientDrawable.Orientation orientation;
        if (i == 0 && i3 == 0) {
            return;
        }
        if (Build.VERSION.SDK_INT <= 15) {
            gradientDrawable.setColor(i);
            return;
        }
        if (i2 != 0) {
            gradientDrawable.setColors(new int[]{i, i2, i3});
        } else {
            gradientDrawable.setColors(new int[]{i, i3});
        }
        if (AppUtils.c() && shapeModel.aj) {
            int i4 = shapeModel.C;
            orientation = i4 != 45 ? i4 != 90 ? i4 != 135 ? i4 != 180 ? i4 != 225 ? i4 != 270 ? i4 != 315 ? GradientDrawable.Orientation.RIGHT_LEFT : GradientDrawable.Orientation.TR_BL : GradientDrawable.Orientation.TOP_BOTTOM : GradientDrawable.Orientation.TL_BR : GradientDrawable.Orientation.LEFT_RIGHT : GradientDrawable.Orientation.BL_TR : GradientDrawable.Orientation.BOTTOM_TOP : GradientDrawable.Orientation.BR_TL;
        } else {
            int i5 = shapeModel.C;
            orientation = i5 != 45 ? i5 != 90 ? i5 != 135 ? i5 != 180 ? i5 != 225 ? i5 != 270 ? i5 != 315 ? GradientDrawable.Orientation.LEFT_RIGHT : GradientDrawable.Orientation.TL_BR : GradientDrawable.Orientation.TOP_BOTTOM : GradientDrawable.Orientation.TR_BL : GradientDrawable.Orientation.RIGHT_LEFT : GradientDrawable.Orientation.BR_TL : GradientDrawable.Orientation.BOTTOM_TOP : GradientDrawable.Orientation.BL_TR;
        }
        gradientDrawable.setOrientation(orientation);
        gradientDrawable.setGradientType(shapeModel.D);
        if (shapeModel.D == 1) {
            gradientDrawable.setGradientRadius(shapeModel.E);
        }
        gradientDrawable.setGradientCenter(shapeModel.F, shapeModel.G);
    }

    public static void a(ShapeView shapeView) {
        ShapeModel shapeModel = shapeView.getShapeModel();
        ((View) shapeView).setBackgroundDrawable(a(shapeModel));
        if ((shapeView instanceof AppCompatTextView) || (shapeView instanceof TextView)) {
            if (shapeModel.e != 0) {
                ((TextView) shapeView).setTextColor(shapeModel.e);
            } else {
                ((TextView) shapeView).setTextColor(b(shapeModel));
            }
        }
    }

    public static void a(ShapeView shapeView, float f) {
        ShapeModel b = b(shapeView);
        b.H = f;
        b.I = 0.0f;
        b.J = 0.0f;
        b.K = 0.0f;
        b.L = 0.0f;
        a(shapeView, b);
    }

    public static void a(ShapeView shapeView, float f, float f2, float f3) {
        ShapeModel b = b(shapeView);
        b.q = f;
        b.r = f2;
        b.s = f3;
        a(shapeView, b);
    }

    public static void a(ShapeView shapeView, float f, float f2, float f3, float f4) {
        ShapeModel b = b(shapeView);
        b.H = 0.0f;
        b.I = f;
        b.J = f2;
        b.K = f3;
        b.L = f4;
        a(shapeView, b);
    }

    public static void a(ShapeView shapeView, int i) {
        a(shapeView, i, i, i);
    }

    public static void a(ShapeView shapeView, int i, int i2) {
        d(shapeView, i, 17170445, i2);
    }

    public static void a(ShapeView shapeView, int i, int i2, int i3) {
        ShapeModel b = b(shapeView);
        b.P = i;
        b.Q = i2;
        b.R = i3;
        b.b = BluedSkinUtils.a(AppInfo.d(), i);
        b.f10293c = BluedSkinUtils.a(AppInfo.d(), i2);
        b.d = BluedSkinUtils.a(AppInfo.d(), i3);
        b.e = 0;
        b.f = 0;
        a(shapeView, b);
    }

    public static void a(ShapeView shapeView, Drawable drawable) {
        a(shapeView, drawable, (Drawable) null, (Drawable) null);
    }

    public static void a(ShapeView shapeView, Drawable drawable, Drawable drawable2, Drawable drawable3) {
        ShapeModel b = b(shapeView);
        b.h = drawable;
        b.i = drawable2;
        b.j = drawable3;
        a(shapeView, b);
    }

    public static void a(ShapeView shapeView, ShapeModel shapeModel) {
        shapeView.setShapeModel(shapeModel);
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [int[], int[][]] */
    public static ColorStateList b(ShapeModel shapeModel) {
        return new ColorStateList(new int[]{new int[]{16842908, 16842919}, new int[]{-16842908, 16842919}, new int[]{-16842910}, new int[0]}, new int[]{shapeModel.f10293c, shapeModel.f10293c, shapeModel.d, shapeModel.b});
    }

    public static ShapeModel b(ShapeView shapeView) {
        return shapeView.getShapeModel();
    }

    public static void b(ShapeView shapeView, int i) {
        b(shapeView, i, i, i);
    }

    public static void b(ShapeView shapeView, int i, int i2, int i3) {
        ShapeModel b = b(shapeView);
        b.U = i;
        b.V = i2;
        b.W = i3;
        b.k = BluedSkinUtils.a(AppInfo.d(), i);
        b.l = BluedSkinUtils.a(AppInfo.d(), i2);
        b.m = BluedSkinUtils.a(AppInfo.d(), i3);
        a(shapeView, b);
    }

    public static void c(ShapeView shapeView, int i) {
        ShapeModel b = b(shapeView);
        b(shapeView, b.U, i, b.W);
    }

    public static void c(ShapeView shapeView, int i, int i2, int i3) {
        ShapeModel b = b(shapeView);
        b.X = i;
        b.Y = i2;
        b.Z = i3;
        b.n = BluedSkinUtils.a(AppInfo.d(), i);
        b.o = BluedSkinUtils.a(AppInfo.d(), i2);
        b.p = BluedSkinUtils.a(AppInfo.d(), i3);
        a(shapeView, b);
    }

    public static void d(ShapeView shapeView, int i) {
        c(shapeView, i, i, i);
    }

    public static void d(ShapeView shapeView, int i, int i2, int i3) {
        ShapeModel b = b(shapeView);
        b.aa = i;
        b.ad = i;
        b.ag = i;
        b.ab = i2;
        b.ae = i2;
        b.ah = i2;
        b.ac = i3;
        b.af = i3;
        b.ai = i3;
        b.t = BluedSkinUtils.a(AppInfo.d(), i);
        b.w = BluedSkinUtils.a(AppInfo.d(), i);
        b.z = BluedSkinUtils.a(AppInfo.d(), i);
        b.u = BluedSkinUtils.a(AppInfo.d(), i2);
        b.x = BluedSkinUtils.a(AppInfo.d(), i2);
        b.A = BluedSkinUtils.a(AppInfo.d(), i2);
        b.v = BluedSkinUtils.a(AppInfo.d(), i3);
        b.y = BluedSkinUtils.a(AppInfo.d(), i3);
        b.B = BluedSkinUtils.a(AppInfo.d(), i3);
        a(shapeView, b);
    }
}
