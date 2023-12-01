package com.blued.android.framework.view.shape;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.blued.android.core.utils.Log;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.core.utils.skin.listener.BluedSkinSupportable;
import com.blued.android.framework.R;
import com.blued.android.framework.view.shape.ShapeHelper;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/view/shape/ShapeFrameLayout.class */
public class ShapeFrameLayout extends FrameLayout implements BluedSkinSupportable, ShapeHelper.ShapeView {

    /* renamed from: a  reason: collision with root package name */
    private ShapeModel f10290a;

    public ShapeFrameLayout(Context context) {
        super(context);
    }

    public ShapeFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet);
    }

    public ShapeFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context, attributeSet);
    }

    private int a(Context context, int i) {
        return isInEditMode() ? getResources().getColor(i) : BluedSkinUtils.a(context, i);
    }

    private void a() {
        ShapeHelper.a(this);
    }

    private void a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ShapeFrameLayout);
        ShapeModel shapeModel = new ShapeModel();
        this.f10290a = shapeModel;
        shapeModel.f10292a = obtainStyledAttributes.getBoolean(R.styleable.ShapeFrameLayout_bg_default_touch, false);
        this.f10290a.h = obtainStyledAttributes.getDrawable(R.styleable.ShapeFrameLayout_bg_drawable);
        this.f10290a.i = obtainStyledAttributes.getDrawable(R.styleable.ShapeFrameLayout_bg_touch_drawable);
        this.f10290a.j = obtainStyledAttributes.getDrawable(R.styleable.ShapeFrameLayout_bg_unable_drawable);
        if (obtainStyledAttributes.hasValue(R.styleable.ShapeFrameLayout_solid_color)) {
            int resourceId = obtainStyledAttributes.getResourceId(R.styleable.ShapeFrameLayout_solid_color, 0);
            this.f10290a.U = resourceId;
            Log.e("skin", "solid color resid = " + resourceId);
            this.f10290a.k = a(context, resourceId);
        } else {
            this.f10290a.k = obtainStyledAttributes.getColor(R.styleable.ShapeFrameLayout_solid_color, 0);
            this.f10290a.U = 17170445;
        }
        if (obtainStyledAttributes.hasValue(R.styleable.ShapeFrameLayout_solid_touch_color)) {
            int resourceId2 = obtainStyledAttributes.getResourceId(R.styleable.ShapeFrameLayout_solid_touch_color, 0);
            this.f10290a.V = resourceId2;
            Log.e("skin", "solid touch color resid = " + resourceId2);
            this.f10290a.l = a(context, resourceId2);
        } else {
            this.f10290a.l = obtainStyledAttributes.getColor(R.styleable.ShapeFrameLayout_solid_touch_color, 0);
            this.f10290a.V = 17170445;
        }
        if (obtainStyledAttributes.hasValue(R.styleable.ShapeFrameLayout_solid_unable_color)) {
            int resourceId3 = obtainStyledAttributes.getResourceId(R.styleable.ShapeFrameLayout_solid_unable_color, 0);
            this.f10290a.W = resourceId3;
            Log.e("skin", "solid unable color resid = " + resourceId3);
            this.f10290a.m = a(context, resourceId3);
        } else {
            this.f10290a.m = obtainStyledAttributes.getColor(R.styleable.ShapeFrameLayout_solid_unable_color, 0);
            this.f10290a.W = 17170445;
        }
        if (obtainStyledAttributes.hasValue(R.styleable.ShapeFrameLayout_stroke_color)) {
            int resourceId4 = obtainStyledAttributes.getResourceId(R.styleable.ShapeFrameLayout_stroke_color, 0);
            this.f10290a.X = resourceId4;
            Log.e("skin", "solid unable color resid = " + resourceId4);
            this.f10290a.n = a(context, resourceId4);
        } else {
            this.f10290a.n = obtainStyledAttributes.getColor(R.styleable.ShapeFrameLayout_stroke_color, 0);
            this.f10290a.X = 17170445;
        }
        if (obtainStyledAttributes.hasValue(R.styleable.ShapeFrameLayout_stroke_touch_color)) {
            int resourceId5 = obtainStyledAttributes.getResourceId(R.styleable.ShapeFrameLayout_stroke_touch_color, 0);
            this.f10290a.Y = resourceId5;
            Log.e("skin", "solid unable color resid = " + resourceId5);
            this.f10290a.o = a(context, resourceId5);
        } else {
            this.f10290a.o = obtainStyledAttributes.getColor(R.styleable.ShapeFrameLayout_stroke_touch_color, 0);
            this.f10290a.Y = 17170445;
        }
        if (obtainStyledAttributes.hasValue(R.styleable.ShapeFrameLayout_stroke_unable_color)) {
            int resourceId6 = obtainStyledAttributes.getResourceId(R.styleable.ShapeFrameLayout_stroke_unable_color, 0);
            this.f10290a.Z = resourceId6;
            Log.e("skin", "solid unable color resid = " + resourceId6);
            this.f10290a.p = a(context, resourceId6);
        } else {
            this.f10290a.p = obtainStyledAttributes.getColor(R.styleable.ShapeFrameLayout_stroke_unable_color, 0);
            this.f10290a.Z = 17170445;
        }
        if (obtainStyledAttributes.hasValue(R.styleable.ShapeFrameLayout_gradient_start_color)) {
            int resourceId7 = obtainStyledAttributes.getResourceId(R.styleable.ShapeFrameLayout_gradient_start_color, 0);
            this.f10290a.aa = resourceId7;
            Log.e("skin", "start color resid = " + resourceId7);
            this.f10290a.t = a(context, resourceId7);
        } else {
            this.f10290a.t = obtainStyledAttributes.getColor(R.styleable.ShapeFrameLayout_gradient_start_color, 0);
            this.f10290a.aa = 17170445;
        }
        if (obtainStyledAttributes.hasValue(R.styleable.ShapeFrameLayout_gradient_center_color)) {
            int resourceId8 = obtainStyledAttributes.getResourceId(R.styleable.ShapeFrameLayout_gradient_center_color, 0);
            this.f10290a.ab = resourceId8;
            Log.e("skin", "center color resid = " + resourceId8);
            this.f10290a.u = a(context, resourceId8);
        } else {
            this.f10290a.u = obtainStyledAttributes.getColor(R.styleable.ShapeFrameLayout_gradient_center_color, 0);
            this.f10290a.ab = 17170445;
        }
        if (obtainStyledAttributes.hasValue(R.styleable.ShapeFrameLayout_gradient_end_color)) {
            int resourceId9 = obtainStyledAttributes.getResourceId(R.styleable.ShapeFrameLayout_gradient_end_color, 0);
            this.f10290a.ac = resourceId9;
            Log.e("skin", "end color resid = " + resourceId9);
            this.f10290a.v = a(context, resourceId9);
        } else {
            this.f10290a.v = obtainStyledAttributes.getColor(R.styleable.ShapeFrameLayout_gradient_end_color, 0);
            this.f10290a.ac = 17170445;
        }
        if (obtainStyledAttributes.hasValue(R.styleable.ShapeFrameLayout_gradient_start_touch_color)) {
            int resourceId10 = obtainStyledAttributes.getResourceId(R.styleable.ShapeFrameLayout_gradient_start_touch_color, 0);
            this.f10290a.ad = resourceId10;
            Log.e("skin", "start touch color resid = " + resourceId10);
            this.f10290a.w = a(context, resourceId10);
        } else {
            this.f10290a.w = obtainStyledAttributes.getColor(R.styleable.ShapeFrameLayout_gradient_start_touch_color, 0);
            this.f10290a.ad = 17170445;
        }
        if (obtainStyledAttributes.hasValue(R.styleable.ShapeFrameLayout_gradient_center_touch_color)) {
            int resourceId11 = obtainStyledAttributes.getResourceId(R.styleable.ShapeFrameLayout_gradient_center_touch_color, 0);
            this.f10290a.ae = resourceId11;
            Log.e("skin", "start touch color resid = " + resourceId11);
            this.f10290a.x = a(context, resourceId11);
        } else {
            this.f10290a.x = obtainStyledAttributes.getColor(R.styleable.ShapeFrameLayout_gradient_center_touch_color, 0);
            this.f10290a.ae = 17170445;
        }
        if (obtainStyledAttributes.hasValue(R.styleable.ShapeFrameLayout_gradient_end_touch_color)) {
            int resourceId12 = obtainStyledAttributes.getResourceId(R.styleable.ShapeFrameLayout_gradient_end_touch_color, 0);
            this.f10290a.af = resourceId12;
            Log.e("skin", "end touch color resid = " + resourceId12);
            this.f10290a.y = a(context, resourceId12);
        } else {
            this.f10290a.y = obtainStyledAttributes.getColor(R.styleable.ShapeFrameLayout_gradient_end_touch_color, 0);
            this.f10290a.af = 17170445;
        }
        if (obtainStyledAttributes.hasValue(R.styleable.ShapeFrameLayout_gradient_start_unable_color)) {
            int resourceId13 = obtainStyledAttributes.getResourceId(R.styleable.ShapeFrameLayout_gradient_start_unable_color, 0);
            this.f10290a.ag = resourceId13;
            Log.e("skin", "start unable color resid = " + resourceId13);
            this.f10290a.z = a(context, resourceId13);
        } else {
            this.f10290a.z = obtainStyledAttributes.getColor(R.styleable.ShapeFrameLayout_gradient_start_unable_color, 0);
            this.f10290a.ag = 17170445;
        }
        if (obtainStyledAttributes.hasValue(R.styleable.ShapeFrameLayout_gradient_center_unable_color)) {
            int resourceId14 = obtainStyledAttributes.getResourceId(R.styleable.ShapeFrameLayout_gradient_center_unable_color, 0);
            this.f10290a.ah = resourceId14;
            Log.e("skin", "center unable color resid = " + resourceId14);
            this.f10290a.A = a(context, resourceId14);
        } else {
            this.f10290a.A = obtainStyledAttributes.getColor(R.styleable.ShapeFrameLayout_gradient_center_unable_color, 0);
            this.f10290a.ah = 17170445;
        }
        if (obtainStyledAttributes.hasValue(R.styleable.ShapeFrameLayout_gradient_end_unable_color)) {
            int resourceId15 = obtainStyledAttributes.getResourceId(R.styleable.ShapeFrameLayout_gradient_end_unable_color, 0);
            this.f10290a.ai = resourceId15;
            Log.e("skin", "end unable color resid = " + resourceId15);
            this.f10290a.B = a(context, resourceId15);
        } else {
            this.f10290a.B = obtainStyledAttributes.getColor(R.styleable.ShapeFrameLayout_gradient_end_unable_color, 0);
            this.f10290a.ai = 17170445;
        }
        this.f10290a.q = obtainStyledAttributes.getDimension(R.styleable.ShapeFrameLayout_stroke_width, 0.0f);
        this.f10290a.r = obtainStyledAttributes.getDimension(R.styleable.ShapeFrameLayout_stroke_dash_width, 0.0f);
        this.f10290a.s = obtainStyledAttributes.getDimension(R.styleable.ShapeFrameLayout_stroke_dash_gap, 0.0f);
        this.f10290a.H = obtainStyledAttributes.getDimension(R.styleable.ShapeFrameLayout_corner_radius, 0.0f);
        this.f10290a.I = obtainStyledAttributes.getDimension(R.styleable.ShapeFrameLayout_top_left_radius, 0.0f);
        this.f10290a.J = obtainStyledAttributes.getDimension(R.styleable.ShapeFrameLayout_top_right_radius, 0.0f);
        this.f10290a.K = obtainStyledAttributes.getDimension(R.styleable.ShapeFrameLayout_bottom_left_radius, 0.0f);
        this.f10290a.L = obtainStyledAttributes.getDimension(R.styleable.ShapeFrameLayout_bottom_right_radius, 0.0f);
        this.f10290a.C = obtainStyledAttributes.getInt(R.styleable.ShapeFrameLayout_gradient_angle, 0);
        this.f10290a.D = obtainStyledAttributes.getInt(R.styleable.ShapeFrameLayout_gradient_type, 0);
        this.f10290a.E = obtainStyledAttributes.getDimension(R.styleable.ShapeFrameLayout_gradient_radius, 0.0f);
        this.f10290a.F = obtainStyledAttributes.getFloat(R.styleable.ShapeFrameLayout_gradient_center_x, 0.5f);
        this.f10290a.G = obtainStyledAttributes.getFloat(R.styleable.ShapeFrameLayout_gradient_center_y, 0.5f);
        this.f10290a.M = obtainStyledAttributes.getInt(R.styleable.ShapeFrameLayout_bg_model, 0);
        this.f10290a.N = obtainStyledAttributes.getInt(R.styleable.ShapeFrameLayout_shape_type, 0);
        this.f10290a.O = obtainStyledAttributes.getFloat(R.styleable.ShapeFrameLayout_wh_ratio, 0.0f);
        this.f10290a.aj = obtainStyledAttributes.getBoolean(R.styleable.ShapeFrameLayout_supportsRtl, true);
        obtainStyledAttributes.recycle();
        a();
    }

    @Override // skin.support.widget.SkinCompatSupportable
    public void applySkin() {
        Log.e("skin", "ShapeFrameLayout apply skin solidColor = " + this.f10290a.U);
        try {
            this.f10290a.k = BluedSkinUtils.a(getContext(), this.f10290a.U);
            this.f10290a.l = BluedSkinUtils.a(getContext(), this.f10290a.V);
            this.f10290a.m = BluedSkinUtils.a(getContext(), this.f10290a.W);
            this.f10290a.t = BluedSkinUtils.a(getContext(), this.f10290a.aa);
            this.f10290a.u = BluedSkinUtils.a(getContext(), this.f10290a.ab);
            this.f10290a.v = BluedSkinUtils.a(getContext(), this.f10290a.ac);
            this.f10290a.z = BluedSkinUtils.a(getContext(), this.f10290a.ag);
            this.f10290a.A = BluedSkinUtils.a(getContext(), this.f10290a.ah);
            this.f10290a.B = BluedSkinUtils.a(getContext(), this.f10290a.ai);
            this.f10290a.w = BluedSkinUtils.a(getContext(), this.f10290a.ad);
            this.f10290a.x = BluedSkinUtils.a(getContext(), this.f10290a.ae);
            this.f10290a.y = BluedSkinUtils.a(getContext(), this.f10290a.af);
            this.f10290a.n = BluedSkinUtils.a(getContext(), this.f10290a.X);
            this.f10290a.o = BluedSkinUtils.a(getContext(), this.f10290a.Y);
            this.f10290a.p = BluedSkinUtils.a(getContext(), this.f10290a.Z);
            a();
        } catch (Exception e) {
        }
    }

    @Override // com.blued.android.framework.view.shape.ShapeHelper.ShapeView
    public ShapeModel getShapeModel() {
        if (this.f10290a == null) {
            this.f10290a = new ShapeModel();
        }
        return this.f10290a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        ShapeModel shapeModel = this.f10290a;
        int i3 = i;
        int i4 = i2;
        if (shapeModel != null) {
            i3 = i;
            i4 = i2;
            if (shapeModel.O != 0.0f) {
                setMeasuredDimension(getDefaultSize(0, i), getDefaultSize(0, i2));
                int measuredWidth = getMeasuredWidth();
                i3 = View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824);
                i4 = View.MeasureSpec.makeMeasureSpec((int) (measuredWidth / this.f10290a.O), 1073741824);
            }
        }
        super.onMeasure(i3, i4);
    }

    @Override // com.blued.android.framework.view.shape.ShapeHelper.ShapeView
    public void setShapeModel(ShapeModel shapeModel) {
        this.f10290a = shapeModel;
        a();
    }
}
