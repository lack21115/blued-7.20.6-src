package com.blued.android.framework.view.shape;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.blued.android.core.utils.Log;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.core.utils.skin.listener.BluedSkinSupportable;
import com.blued.android.framework.R;
import com.blued.android.framework.view.shape.ShapeHelper;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/view/shape/ShapeConstraintLayout.class */
public class ShapeConstraintLayout extends ConstraintLayout implements BluedSkinSupportable, ShapeHelper.ShapeView {

    /* renamed from: a  reason: collision with root package name */
    private ShapeModel f10289a;

    public ShapeConstraintLayout(Context context) {
        super(context);
    }

    public ShapeConstraintLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet);
    }

    public ShapeConstraintLayout(Context context, AttributeSet attributeSet, int i) {
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
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ShapeConstraintLayout);
        ShapeModel shapeModel = new ShapeModel();
        this.f10289a = shapeModel;
        shapeModel.f10292a = obtainStyledAttributes.getBoolean(R.styleable.ShapeConstraintLayout_bg_default_touch, false);
        this.f10289a.h = obtainStyledAttributes.getDrawable(R.styleable.ShapeConstraintLayout_bg_drawable);
        this.f10289a.i = obtainStyledAttributes.getDrawable(R.styleable.ShapeConstraintLayout_bg_touch_drawable);
        this.f10289a.j = obtainStyledAttributes.getDrawable(R.styleable.ShapeConstraintLayout_bg_unable_drawable);
        if (obtainStyledAttributes.hasValue(R.styleable.ShapeConstraintLayout_solid_color)) {
            int resourceId = obtainStyledAttributes.getResourceId(R.styleable.ShapeConstraintLayout_solid_color, 0);
            this.f10289a.U = resourceId;
            Log.e("skin", "solid color resid = " + resourceId);
            this.f10289a.k = a(context, resourceId);
        } else {
            this.f10289a.k = obtainStyledAttributes.getColor(R.styleable.ShapeConstraintLayout_solid_color, 0);
            this.f10289a.U = 17170445;
        }
        if (obtainStyledAttributes.hasValue(R.styleable.ShapeConstraintLayout_solid_touch_color)) {
            int resourceId2 = obtainStyledAttributes.getResourceId(R.styleable.ShapeConstraintLayout_solid_touch_color, 0);
            this.f10289a.V = resourceId2;
            Log.e("skin", "solid touch color resid = " + resourceId2);
            this.f10289a.l = a(context, resourceId2);
        } else {
            this.f10289a.l = obtainStyledAttributes.getColor(R.styleable.ShapeConstraintLayout_solid_touch_color, 0);
            this.f10289a.V = 17170445;
        }
        if (obtainStyledAttributes.hasValue(R.styleable.ShapeConstraintLayout_solid_unable_color)) {
            int resourceId3 = obtainStyledAttributes.getResourceId(R.styleable.ShapeConstraintLayout_solid_unable_color, 0);
            this.f10289a.W = resourceId3;
            Log.e("skin", "solid unable color resid = " + resourceId3);
            this.f10289a.m = a(context, resourceId3);
        } else {
            this.f10289a.m = obtainStyledAttributes.getColor(R.styleable.ShapeConstraintLayout_solid_unable_color, 0);
            this.f10289a.W = 17170445;
        }
        if (obtainStyledAttributes.hasValue(R.styleable.ShapeConstraintLayout_stroke_color)) {
            int resourceId4 = obtainStyledAttributes.getResourceId(R.styleable.ShapeConstraintLayout_stroke_color, 0);
            this.f10289a.X = resourceId4;
            Log.e("skin", "solid unable color resid = " + resourceId4);
            this.f10289a.n = a(context, resourceId4);
        } else {
            this.f10289a.n = obtainStyledAttributes.getColor(R.styleable.ShapeConstraintLayout_stroke_color, 0);
            this.f10289a.X = 17170445;
        }
        if (obtainStyledAttributes.hasValue(R.styleable.ShapeConstraintLayout_stroke_touch_color)) {
            int resourceId5 = obtainStyledAttributes.getResourceId(R.styleable.ShapeConstraintLayout_stroke_touch_color, 0);
            this.f10289a.Y = resourceId5;
            Log.e("skin", "solid unable color resid = " + resourceId5);
            this.f10289a.o = a(context, resourceId5);
        } else {
            this.f10289a.o = obtainStyledAttributes.getColor(R.styleable.ShapeConstraintLayout_stroke_touch_color, 0);
            this.f10289a.Y = 17170445;
        }
        if (obtainStyledAttributes.hasValue(R.styleable.ShapeConstraintLayout_stroke_unable_color)) {
            int resourceId6 = obtainStyledAttributes.getResourceId(R.styleable.ShapeConstraintLayout_stroke_unable_color, 0);
            this.f10289a.Z = resourceId6;
            Log.e("skin", "solid unable color resid = " + resourceId6);
            this.f10289a.p = a(context, resourceId6);
        } else {
            this.f10289a.p = obtainStyledAttributes.getColor(R.styleable.ShapeConstraintLayout_stroke_unable_color, 0);
            this.f10289a.Z = 17170445;
        }
        if (obtainStyledAttributes.hasValue(R.styleable.ShapeConstraintLayout_gradient_start_color)) {
            int resourceId7 = obtainStyledAttributes.getResourceId(R.styleable.ShapeConstraintLayout_gradient_start_color, 0);
            this.f10289a.aa = resourceId7;
            Log.e("skin", "start color resid = " + resourceId7);
            this.f10289a.t = a(context, resourceId7);
        } else {
            this.f10289a.t = obtainStyledAttributes.getColor(R.styleable.ShapeConstraintLayout_gradient_start_color, 0);
            this.f10289a.aa = 17170445;
        }
        if (obtainStyledAttributes.hasValue(R.styleable.ShapeConstraintLayout_gradient_center_color)) {
            int resourceId8 = obtainStyledAttributes.getResourceId(R.styleable.ShapeConstraintLayout_gradient_center_color, 0);
            this.f10289a.ab = resourceId8;
            Log.e("skin", "center color resid = " + resourceId8);
            this.f10289a.u = a(context, resourceId8);
        } else {
            this.f10289a.u = obtainStyledAttributes.getColor(R.styleable.ShapeConstraintLayout_gradient_center_color, 0);
            this.f10289a.ab = 17170445;
        }
        if (obtainStyledAttributes.hasValue(R.styleable.ShapeConstraintLayout_gradient_end_color)) {
            int resourceId9 = obtainStyledAttributes.getResourceId(R.styleable.ShapeConstraintLayout_gradient_end_color, 0);
            this.f10289a.ac = resourceId9;
            Log.e("skin", "end color resid = " + resourceId9);
            this.f10289a.v = a(context, resourceId9);
        } else {
            this.f10289a.v = obtainStyledAttributes.getColor(R.styleable.ShapeConstraintLayout_gradient_end_color, 0);
            this.f10289a.ac = 17170445;
        }
        if (obtainStyledAttributes.hasValue(R.styleable.ShapeConstraintLayout_gradient_start_touch_color)) {
            int resourceId10 = obtainStyledAttributes.getResourceId(R.styleable.ShapeConstraintLayout_gradient_start_touch_color, 0);
            this.f10289a.ad = resourceId10;
            Log.e("skin", "start touch color resid = " + resourceId10);
            this.f10289a.w = a(context, resourceId10);
        } else {
            this.f10289a.w = obtainStyledAttributes.getColor(R.styleable.ShapeConstraintLayout_gradient_start_touch_color, 0);
            this.f10289a.ad = 17170445;
        }
        if (obtainStyledAttributes.hasValue(R.styleable.ShapeConstraintLayout_gradient_center_touch_color)) {
            int resourceId11 = obtainStyledAttributes.getResourceId(R.styleable.ShapeConstraintLayout_gradient_center_touch_color, 0);
            this.f10289a.ae = resourceId11;
            Log.e("skin", "start touch color resid = " + resourceId11);
            this.f10289a.x = a(context, resourceId11);
        } else {
            this.f10289a.x = obtainStyledAttributes.getColor(R.styleable.ShapeConstraintLayout_gradient_center_touch_color, 0);
            this.f10289a.ae = 17170445;
        }
        if (obtainStyledAttributes.hasValue(R.styleable.ShapeConstraintLayout_gradient_end_touch_color)) {
            int resourceId12 = obtainStyledAttributes.getResourceId(R.styleable.ShapeConstraintLayout_gradient_end_touch_color, 0);
            this.f10289a.af = resourceId12;
            Log.e("skin", "end touch color resid = " + resourceId12);
            this.f10289a.y = a(context, resourceId12);
        } else {
            this.f10289a.y = obtainStyledAttributes.getColor(R.styleable.ShapeConstraintLayout_gradient_end_touch_color, 0);
            this.f10289a.af = 17170445;
        }
        if (obtainStyledAttributes.hasValue(R.styleable.ShapeConstraintLayout_gradient_start_unable_color)) {
            int resourceId13 = obtainStyledAttributes.getResourceId(R.styleable.ShapeConstraintLayout_gradient_start_unable_color, 0);
            this.f10289a.ag = resourceId13;
            Log.e("skin", "start unable color resid = " + resourceId13);
            this.f10289a.z = a(context, resourceId13);
        } else {
            this.f10289a.z = obtainStyledAttributes.getColor(R.styleable.ShapeConstraintLayout_gradient_start_unable_color, 0);
            this.f10289a.ag = 17170445;
        }
        if (obtainStyledAttributes.hasValue(R.styleable.ShapeConstraintLayout_gradient_center_unable_color)) {
            int resourceId14 = obtainStyledAttributes.getResourceId(R.styleable.ShapeConstraintLayout_gradient_center_unable_color, 0);
            this.f10289a.ah = resourceId14;
            Log.e("skin", "center unable color resid = " + resourceId14);
            this.f10289a.A = a(context, resourceId14);
        } else {
            this.f10289a.A = obtainStyledAttributes.getColor(R.styleable.ShapeConstraintLayout_gradient_center_unable_color, 0);
            this.f10289a.ah = 17170445;
        }
        if (obtainStyledAttributes.hasValue(R.styleable.ShapeConstraintLayout_gradient_end_unable_color)) {
            int resourceId15 = obtainStyledAttributes.getResourceId(R.styleable.ShapeConstraintLayout_gradient_end_unable_color, 0);
            this.f10289a.ai = resourceId15;
            Log.e("skin", "end unable color resid = " + resourceId15);
            this.f10289a.B = a(context, resourceId15);
        } else {
            this.f10289a.B = obtainStyledAttributes.getColor(R.styleable.ShapeConstraintLayout_gradient_end_unable_color, 0);
            this.f10289a.ai = 17170445;
        }
        this.f10289a.q = obtainStyledAttributes.getDimension(R.styleable.ShapeConstraintLayout_stroke_width, 0.0f);
        this.f10289a.r = obtainStyledAttributes.getDimension(R.styleable.ShapeConstraintLayout_stroke_dash_width, 0.0f);
        this.f10289a.s = obtainStyledAttributes.getDimension(R.styleable.ShapeConstraintLayout_stroke_dash_gap, 0.0f);
        this.f10289a.H = obtainStyledAttributes.getDimension(R.styleable.ShapeConstraintLayout_corner_radius, 0.0f);
        this.f10289a.I = obtainStyledAttributes.getDimension(R.styleable.ShapeConstraintLayout_top_left_radius, 0.0f);
        this.f10289a.J = obtainStyledAttributes.getDimension(R.styleable.ShapeConstraintLayout_top_right_radius, 0.0f);
        this.f10289a.K = obtainStyledAttributes.getDimension(R.styleable.ShapeConstraintLayout_bottom_left_radius, 0.0f);
        this.f10289a.L = obtainStyledAttributes.getDimension(R.styleable.ShapeConstraintLayout_bottom_right_radius, 0.0f);
        this.f10289a.C = obtainStyledAttributes.getInt(R.styleable.ShapeConstraintLayout_gradient_angle, 0);
        this.f10289a.D = obtainStyledAttributes.getInt(R.styleable.ShapeConstraintLayout_gradient_type, 0);
        this.f10289a.E = obtainStyledAttributes.getDimension(R.styleable.ShapeConstraintLayout_gradient_radius, 0.0f);
        this.f10289a.F = obtainStyledAttributes.getFloat(R.styleable.ShapeConstraintLayout_gradient_center_x, 0.5f);
        this.f10289a.G = obtainStyledAttributes.getFloat(R.styleable.ShapeConstraintLayout_gradient_center_y, 0.5f);
        this.f10289a.M = obtainStyledAttributes.getInt(R.styleable.ShapeConstraintLayout_bg_model, 0);
        this.f10289a.N = obtainStyledAttributes.getInt(R.styleable.ShapeConstraintLayout_shape_type, 0);
        this.f10289a.O = obtainStyledAttributes.getFloat(R.styleable.ShapeConstraintLayout_wh_ratio, 0.0f);
        this.f10289a.aj = obtainStyledAttributes.getBoolean(R.styleable.ShapeConstraintLayout_supportsRtl, true);
        obtainStyledAttributes.recycle();
        a();
    }

    @Override // skin.support.widget.SkinCompatSupportable
    public void applySkin() {
        Log.e("skin", "ShapeConstraintLayout apply skin solidColor = " + this.f10289a.U);
        try {
            this.f10289a.k = BluedSkinUtils.a(getContext(), this.f10289a.U);
            this.f10289a.l = BluedSkinUtils.a(getContext(), this.f10289a.V);
            this.f10289a.m = BluedSkinUtils.a(getContext(), this.f10289a.W);
            this.f10289a.t = BluedSkinUtils.a(getContext(), this.f10289a.aa);
            this.f10289a.u = BluedSkinUtils.a(getContext(), this.f10289a.ab);
            this.f10289a.v = BluedSkinUtils.a(getContext(), this.f10289a.ac);
            this.f10289a.z = BluedSkinUtils.a(getContext(), this.f10289a.ag);
            this.f10289a.A = BluedSkinUtils.a(getContext(), this.f10289a.ah);
            this.f10289a.B = BluedSkinUtils.a(getContext(), this.f10289a.ai);
            this.f10289a.w = BluedSkinUtils.a(getContext(), this.f10289a.ad);
            this.f10289a.x = BluedSkinUtils.a(getContext(), this.f10289a.ae);
            this.f10289a.y = BluedSkinUtils.a(getContext(), this.f10289a.af);
            this.f10289a.n = BluedSkinUtils.a(getContext(), this.f10289a.X);
            this.f10289a.o = BluedSkinUtils.a(getContext(), this.f10289a.Y);
            this.f10289a.p = BluedSkinUtils.a(getContext(), this.f10289a.Z);
            a();
        } catch (Exception e) {
        }
    }

    @Override // com.blued.android.framework.view.shape.ShapeHelper.ShapeView
    public ShapeModel getShapeModel() {
        if (this.f10289a == null) {
            this.f10289a = new ShapeModel();
        }
        return this.f10289a;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    public void onMeasure(int i, int i2) {
        ShapeModel shapeModel = this.f10289a;
        int i3 = i;
        int i4 = i2;
        if (shapeModel != null) {
            i3 = i;
            i4 = i2;
            if (shapeModel.O != 0.0f) {
                setMeasuredDimension(getDefaultSize(0, i), getDefaultSize(0, i2));
                int measuredWidth = getMeasuredWidth();
                i3 = View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824);
                i4 = View.MeasureSpec.makeMeasureSpec((int) (measuredWidth / this.f10289a.O), 1073741824);
            }
        }
        super.onMeasure(i3, i4);
    }

    @Override // com.blued.android.framework.view.shape.ShapeHelper.ShapeView
    public void setShapeModel(ShapeModel shapeModel) {
        this.f10289a = shapeModel;
        a();
    }
}
