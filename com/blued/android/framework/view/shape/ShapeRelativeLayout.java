package com.blued.android.framework.view.shape;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.blued.android.core.utils.Log;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.core.utils.skin.listener.BluedSkinSupportable;
import com.blued.android.framework.R;
import com.blued.android.framework.view.shape.ShapeHelper;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/view/shape/ShapeRelativeLayout.class */
public class ShapeRelativeLayout extends RelativeLayout implements BluedSkinSupportable, ShapeHelper.ShapeView {
    private ShapeModel a;

    public ShapeRelativeLayout(Context context) {
        super(context);
    }

    public ShapeRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet);
    }

    public ShapeRelativeLayout(Context context, AttributeSet attributeSet, int i) {
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
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ShapeRelativeLayout);
        ShapeModel shapeModel = new ShapeModel();
        this.a = shapeModel;
        shapeModel.a = obtainStyledAttributes.getBoolean(R.styleable.ShapeRelativeLayout_bg_default_touch, false);
        this.a.h = obtainStyledAttributes.getDrawable(R.styleable.ShapeRelativeLayout_bg_drawable);
        this.a.i = obtainStyledAttributes.getDrawable(R.styleable.ShapeRelativeLayout_bg_touch_drawable);
        this.a.j = obtainStyledAttributes.getDrawable(R.styleable.ShapeRelativeLayout_bg_unable_drawable);
        if (obtainStyledAttributes.hasValue(R.styleable.ShapeRelativeLayout_solid_color)) {
            int resourceId = obtainStyledAttributes.getResourceId(R.styleable.ShapeRelativeLayout_solid_color, 0);
            this.a.U = resourceId;
            Log.e("skin", "solid color resid = " + resourceId);
            this.a.k = a(context, resourceId);
        } else {
            this.a.k = obtainStyledAttributes.getColor(R.styleable.ShapeRelativeLayout_solid_color, 0);
            this.a.U = com.android.internal.R.color.transparent;
        }
        if (obtainStyledAttributes.hasValue(R.styleable.ShapeRelativeLayout_solid_touch_color)) {
            int resourceId2 = obtainStyledAttributes.getResourceId(R.styleable.ShapeRelativeLayout_solid_touch_color, 0);
            this.a.V = resourceId2;
            Log.e("skin", "solid touch color resid = " + resourceId2);
            this.a.l = a(context, resourceId2);
        } else {
            this.a.l = obtainStyledAttributes.getColor(R.styleable.ShapeRelativeLayout_solid_touch_color, 0);
            this.a.V = com.android.internal.R.color.transparent;
        }
        if (obtainStyledAttributes.hasValue(R.styleable.ShapeRelativeLayout_solid_unable_color)) {
            int resourceId3 = obtainStyledAttributes.getResourceId(R.styleable.ShapeRelativeLayout_solid_unable_color, 0);
            this.a.W = resourceId3;
            Log.e("skin", "solid unable color resid = " + resourceId3);
            this.a.m = a(context, resourceId3);
        } else {
            this.a.m = obtainStyledAttributes.getColor(R.styleable.ShapeRelativeLayout_solid_unable_color, 0);
            this.a.W = com.android.internal.R.color.transparent;
        }
        if (obtainStyledAttributes.hasValue(R.styleable.ShapeRelativeLayout_stroke_color)) {
            int resourceId4 = obtainStyledAttributes.getResourceId(R.styleable.ShapeRelativeLayout_stroke_color, 0);
            this.a.X = resourceId4;
            Log.e("skin", "solid unable color resid = " + resourceId4);
            this.a.n = a(context, resourceId4);
        } else {
            this.a.n = obtainStyledAttributes.getColor(R.styleable.ShapeRelativeLayout_stroke_color, 0);
            this.a.X = com.android.internal.R.color.transparent;
        }
        if (obtainStyledAttributes.hasValue(R.styleable.ShapeRelativeLayout_stroke_touch_color)) {
            int resourceId5 = obtainStyledAttributes.getResourceId(R.styleable.ShapeRelativeLayout_stroke_touch_color, 0);
            this.a.Y = resourceId5;
            Log.e("skin", "solid unable color resid = " + resourceId5);
            this.a.o = a(context, resourceId5);
        } else {
            this.a.o = obtainStyledAttributes.getColor(R.styleable.ShapeRelativeLayout_stroke_touch_color, 0);
            this.a.Y = com.android.internal.R.color.transparent;
        }
        if (obtainStyledAttributes.hasValue(R.styleable.ShapeRelativeLayout_stroke_unable_color)) {
            int resourceId6 = obtainStyledAttributes.getResourceId(R.styleable.ShapeRelativeLayout_stroke_unable_color, 0);
            this.a.Z = resourceId6;
            Log.e("skin", "solid unable color resid = " + resourceId6);
            this.a.p = a(context, resourceId6);
        } else {
            this.a.p = obtainStyledAttributes.getColor(R.styleable.ShapeRelativeLayout_stroke_unable_color, 0);
            this.a.Z = com.android.internal.R.color.transparent;
        }
        if (obtainStyledAttributes.hasValue(R.styleable.ShapeRelativeLayout_gradient_start_color)) {
            int resourceId7 = obtainStyledAttributes.getResourceId(R.styleable.ShapeRelativeLayout_gradient_start_color, 0);
            this.a.aa = resourceId7;
            Log.e("skin", "start color resid = " + resourceId7);
            this.a.t = a(context, resourceId7);
        } else {
            this.a.t = obtainStyledAttributes.getColor(R.styleable.ShapeRelativeLayout_gradient_start_color, 0);
            this.a.aa = com.android.internal.R.color.transparent;
        }
        if (obtainStyledAttributes.hasValue(R.styleable.ShapeRelativeLayout_gradient_center_color)) {
            int resourceId8 = obtainStyledAttributes.getResourceId(R.styleable.ShapeRelativeLayout_gradient_center_color, 0);
            this.a.ab = resourceId8;
            Log.e("skin", "center color resid = " + resourceId8);
            this.a.u = a(context, resourceId8);
        } else {
            this.a.u = obtainStyledAttributes.getColor(R.styleable.ShapeRelativeLayout_gradient_center_color, 0);
            this.a.ab = com.android.internal.R.color.transparent;
        }
        if (obtainStyledAttributes.hasValue(R.styleable.ShapeRelativeLayout_gradient_end_color)) {
            int resourceId9 = obtainStyledAttributes.getResourceId(R.styleable.ShapeRelativeLayout_gradient_end_color, 0);
            this.a.ac = resourceId9;
            Log.e("skin", "end color resid = " + resourceId9);
            this.a.v = a(context, resourceId9);
        } else {
            this.a.v = obtainStyledAttributes.getColor(R.styleable.ShapeRelativeLayout_gradient_end_color, 0);
            this.a.ac = com.android.internal.R.color.transparent;
        }
        if (obtainStyledAttributes.hasValue(R.styleable.ShapeRelativeLayout_gradient_start_touch_color)) {
            int resourceId10 = obtainStyledAttributes.getResourceId(R.styleable.ShapeRelativeLayout_gradient_start_touch_color, 0);
            this.a.ad = resourceId10;
            Log.e("skin", "start touch color resid = " + resourceId10);
            this.a.w = a(context, resourceId10);
        } else {
            this.a.w = obtainStyledAttributes.getColor(R.styleable.ShapeRelativeLayout_gradient_start_touch_color, 0);
            this.a.ad = com.android.internal.R.color.transparent;
        }
        if (obtainStyledAttributes.hasValue(R.styleable.ShapeRelativeLayout_gradient_center_touch_color)) {
            int resourceId11 = obtainStyledAttributes.getResourceId(R.styleable.ShapeRelativeLayout_gradient_center_touch_color, 0);
            this.a.ae = resourceId11;
            Log.e("skin", "start touch color resid = " + resourceId11);
            this.a.x = a(context, resourceId11);
        } else {
            this.a.x = obtainStyledAttributes.getColor(R.styleable.ShapeRelativeLayout_gradient_center_touch_color, 0);
            this.a.ae = com.android.internal.R.color.transparent;
        }
        if (obtainStyledAttributes.hasValue(R.styleable.ShapeRelativeLayout_gradient_end_touch_color)) {
            int resourceId12 = obtainStyledAttributes.getResourceId(R.styleable.ShapeRelativeLayout_gradient_end_touch_color, 0);
            this.a.af = resourceId12;
            Log.e("skin", "end touch color resid = " + resourceId12);
            this.a.y = a(context, resourceId12);
        } else {
            this.a.y = obtainStyledAttributes.getColor(R.styleable.ShapeRelativeLayout_gradient_end_touch_color, 0);
            this.a.af = com.android.internal.R.color.transparent;
        }
        if (obtainStyledAttributes.hasValue(R.styleable.ShapeRelativeLayout_gradient_start_unable_color)) {
            int resourceId13 = obtainStyledAttributes.getResourceId(R.styleable.ShapeRelativeLayout_gradient_start_unable_color, 0);
            this.a.ag = resourceId13;
            Log.e("skin", "start unable color resid = " + resourceId13);
            this.a.z = a(context, resourceId13);
        } else {
            this.a.z = obtainStyledAttributes.getColor(R.styleable.ShapeRelativeLayout_gradient_start_unable_color, 0);
            this.a.ag = com.android.internal.R.color.transparent;
        }
        if (obtainStyledAttributes.hasValue(R.styleable.ShapeRelativeLayout_gradient_center_unable_color)) {
            int resourceId14 = obtainStyledAttributes.getResourceId(R.styleable.ShapeRelativeLayout_gradient_center_unable_color, 0);
            this.a.ah = resourceId14;
            Log.e("skin", "center unable color resid = " + resourceId14);
            this.a.A = a(context, resourceId14);
        } else {
            this.a.A = obtainStyledAttributes.getColor(R.styleable.ShapeRelativeLayout_gradient_center_unable_color, 0);
            this.a.ah = com.android.internal.R.color.transparent;
        }
        if (obtainStyledAttributes.hasValue(R.styleable.ShapeRelativeLayout_gradient_end_unable_color)) {
            int resourceId15 = obtainStyledAttributes.getResourceId(R.styleable.ShapeRelativeLayout_gradient_end_unable_color, 0);
            this.a.ai = resourceId15;
            Log.e("skin", "end unable color resid = " + resourceId15);
            this.a.B = a(context, resourceId15);
        } else {
            this.a.B = obtainStyledAttributes.getColor(R.styleable.ShapeRelativeLayout_gradient_end_unable_color, 0);
            this.a.ai = com.android.internal.R.color.transparent;
        }
        this.a.q = obtainStyledAttributes.getDimension(R.styleable.ShapeRelativeLayout_stroke_width, 0.0f);
        this.a.r = obtainStyledAttributes.getDimension(R.styleable.ShapeRelativeLayout_stroke_dash_width, 0.0f);
        this.a.s = obtainStyledAttributes.getDimension(R.styleable.ShapeRelativeLayout_stroke_dash_gap, 0.0f);
        this.a.H = obtainStyledAttributes.getDimension(R.styleable.ShapeRelativeLayout_corner_radius, 0.0f);
        this.a.I = obtainStyledAttributes.getDimension(R.styleable.ShapeRelativeLayout_top_left_radius, 0.0f);
        this.a.J = obtainStyledAttributes.getDimension(R.styleable.ShapeRelativeLayout_top_right_radius, 0.0f);
        this.a.K = obtainStyledAttributes.getDimension(R.styleable.ShapeRelativeLayout_bottom_left_radius, 0.0f);
        this.a.L = obtainStyledAttributes.getDimension(R.styleable.ShapeRelativeLayout_bottom_right_radius, 0.0f);
        this.a.C = obtainStyledAttributes.getInt(R.styleable.ShapeRelativeLayout_gradient_angle, 0);
        this.a.D = obtainStyledAttributes.getInt(R.styleable.ShapeRelativeLayout_gradient_type, 0);
        this.a.E = obtainStyledAttributes.getDimension(R.styleable.ShapeRelativeLayout_gradient_radius, 0.0f);
        this.a.F = obtainStyledAttributes.getFloat(R.styleable.ShapeRelativeLayout_gradient_center_x, 0.5f);
        this.a.G = obtainStyledAttributes.getFloat(R.styleable.ShapeRelativeLayout_gradient_center_y, 0.5f);
        this.a.M = obtainStyledAttributes.getInt(R.styleable.ShapeRelativeLayout_bg_model, 0);
        this.a.N = obtainStyledAttributes.getInt(R.styleable.ShapeRelativeLayout_shape_type, 0);
        this.a.O = obtainStyledAttributes.getFloat(R.styleable.ShapeRelativeLayout_wh_ratio, 0.0f);
        this.a.aj = obtainStyledAttributes.getBoolean(R.styleable.ShapeRelativeLayout_supportsRtl, true);
        obtainStyledAttributes.recycle();
        a();
    }

    @Override // skin.support.widget.SkinCompatSupportable
    public void applySkin() {
        Log.e("skin", "ShapeRelativeLayout apply skin solidColor = " + this.a.U);
        try {
            this.a.k = BluedSkinUtils.a(getContext(), this.a.U);
            this.a.l = BluedSkinUtils.a(getContext(), this.a.V);
            this.a.m = BluedSkinUtils.a(getContext(), this.a.W);
            this.a.t = BluedSkinUtils.a(getContext(), this.a.aa);
            this.a.u = BluedSkinUtils.a(getContext(), this.a.ab);
            this.a.v = BluedSkinUtils.a(getContext(), this.a.ac);
            this.a.z = BluedSkinUtils.a(getContext(), this.a.ag);
            this.a.A = BluedSkinUtils.a(getContext(), this.a.ah);
            this.a.B = BluedSkinUtils.a(getContext(), this.a.ai);
            this.a.w = BluedSkinUtils.a(getContext(), this.a.ad);
            this.a.x = BluedSkinUtils.a(getContext(), this.a.ae);
            this.a.y = BluedSkinUtils.a(getContext(), this.a.af);
            this.a.n = BluedSkinUtils.a(getContext(), this.a.X);
            this.a.o = BluedSkinUtils.a(getContext(), this.a.Y);
            this.a.p = BluedSkinUtils.a(getContext(), this.a.Z);
            a();
        } catch (Exception e) {
        }
    }

    @Override // com.blued.android.framework.view.shape.ShapeHelper.ShapeView
    public ShapeModel getShapeModel() {
        if (this.a == null) {
            this.a = new ShapeModel();
        }
        return this.a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i, int i2) {
        ShapeModel shapeModel = this.a;
        int i3 = i;
        int i4 = i2;
        if (shapeModel != null) {
            i3 = i;
            i4 = i2;
            if (shapeModel.O != 0.0f) {
                setMeasuredDimension(getDefaultSize(0, i), getDefaultSize(0, i2));
                int measuredWidth = getMeasuredWidth();
                i3 = View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824);
                i4 = View.MeasureSpec.makeMeasureSpec((int) (measuredWidth / this.a.O), 1073741824);
            }
        }
        super.onMeasure(i3, i4);
    }

    @Override // com.blued.android.framework.view.shape.ShapeHelper.ShapeView
    public void setShapeModel(ShapeModel shapeModel) {
        this.a = shapeModel;
        a();
    }
}
