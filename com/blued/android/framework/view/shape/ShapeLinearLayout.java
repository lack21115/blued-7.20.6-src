package com.blued.android.framework.view.shape;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.blued.android.core.utils.Log;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.core.utils.skin.listener.BluedSkinSupportable;
import com.blued.android.framework.R;
import com.blued.android.framework.view.shape.ShapeHelper;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/view/shape/ShapeLinearLayout.class */
public class ShapeLinearLayout extends LinearLayout implements BluedSkinSupportable, ShapeHelper.ShapeView {

    /* renamed from: a  reason: collision with root package name */
    private ShapeModel f10291a;

    public ShapeLinearLayout(Context context) {
        super(context);
    }

    public ShapeLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet);
    }

    public ShapeLinearLayout(Context context, AttributeSet attributeSet, int i) {
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
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ShapeLinearLayout);
        ShapeModel shapeModel = new ShapeModel();
        this.f10291a = shapeModel;
        shapeModel.f10292a = obtainStyledAttributes.getBoolean(R.styleable.ShapeLinearLayout_bg_default_touch, false);
        this.f10291a.h = obtainStyledAttributes.getDrawable(R.styleable.ShapeLinearLayout_bg_drawable);
        this.f10291a.i = obtainStyledAttributes.getDrawable(R.styleable.ShapeLinearLayout_bg_touch_drawable);
        this.f10291a.j = obtainStyledAttributes.getDrawable(R.styleable.ShapeLinearLayout_bg_unable_drawable);
        if (obtainStyledAttributes.hasValue(R.styleable.ShapeLinearLayout_solid_color)) {
            int resourceId = obtainStyledAttributes.getResourceId(R.styleable.ShapeLinearLayout_solid_color, 0);
            this.f10291a.U = resourceId;
            Log.e("skin", "solid color resid = " + resourceId);
            this.f10291a.k = a(context, resourceId);
        } else {
            this.f10291a.k = obtainStyledAttributes.getColor(R.styleable.ShapeLinearLayout_solid_color, 0);
            this.f10291a.U = 17170445;
        }
        if (obtainStyledAttributes.hasValue(R.styleable.ShapeLinearLayout_solid_touch_color)) {
            int resourceId2 = obtainStyledAttributes.getResourceId(R.styleable.ShapeLinearLayout_solid_touch_color, 0);
            this.f10291a.V = resourceId2;
            Log.e("skin", "solid touch color resid = " + resourceId2);
            this.f10291a.l = a(context, resourceId2);
        } else {
            this.f10291a.l = obtainStyledAttributes.getColor(R.styleable.ShapeLinearLayout_solid_touch_color, 0);
            this.f10291a.V = 17170445;
        }
        if (obtainStyledAttributes.hasValue(R.styleable.ShapeLinearLayout_solid_unable_color)) {
            int resourceId3 = obtainStyledAttributes.getResourceId(R.styleable.ShapeLinearLayout_solid_unable_color, 0);
            this.f10291a.W = resourceId3;
            Log.e("skin", "solid unable color resid = " + resourceId3);
            this.f10291a.m = a(context, resourceId3);
        } else {
            this.f10291a.m = obtainStyledAttributes.getColor(R.styleable.ShapeLinearLayout_solid_unable_color, 0);
            this.f10291a.W = 17170445;
        }
        if (obtainStyledAttributes.hasValue(R.styleable.ShapeLinearLayout_stroke_color)) {
            int resourceId4 = obtainStyledAttributes.getResourceId(R.styleable.ShapeLinearLayout_stroke_color, 0);
            this.f10291a.X = resourceId4;
            Log.e("skin", "solid unable color resid = " + resourceId4);
            this.f10291a.n = a(context, resourceId4);
        } else {
            this.f10291a.n = obtainStyledAttributes.getColor(R.styleable.ShapeLinearLayout_stroke_color, 0);
            this.f10291a.X = 17170445;
        }
        if (obtainStyledAttributes.hasValue(R.styleable.ShapeLinearLayout_stroke_touch_color)) {
            int resourceId5 = obtainStyledAttributes.getResourceId(R.styleable.ShapeLinearLayout_stroke_touch_color, 0);
            this.f10291a.Y = resourceId5;
            Log.e("skin", "solid unable color resid = " + resourceId5);
            this.f10291a.o = a(context, resourceId5);
        } else {
            this.f10291a.o = obtainStyledAttributes.getColor(R.styleable.ShapeLinearLayout_stroke_touch_color, 0);
            this.f10291a.Y = 17170445;
        }
        if (obtainStyledAttributes.hasValue(R.styleable.ShapeLinearLayout_stroke_unable_color)) {
            int resourceId6 = obtainStyledAttributes.getResourceId(R.styleable.ShapeLinearLayout_stroke_unable_color, 0);
            this.f10291a.Z = resourceId6;
            Log.e("skin", "solid unable color resid = " + resourceId6);
            this.f10291a.p = a(context, resourceId6);
        } else {
            this.f10291a.p = obtainStyledAttributes.getColor(R.styleable.ShapeLinearLayout_stroke_unable_color, 0);
            this.f10291a.Z = 17170445;
        }
        if (obtainStyledAttributes.hasValue(R.styleable.ShapeLinearLayout_gradient_start_color)) {
            int resourceId7 = obtainStyledAttributes.getResourceId(R.styleable.ShapeLinearLayout_gradient_start_color, 0);
            this.f10291a.aa = resourceId7;
            Log.e("skin", "start color resid = " + resourceId7);
            this.f10291a.t = a(context, resourceId7);
        } else {
            this.f10291a.t = obtainStyledAttributes.getColor(R.styleable.ShapeLinearLayout_gradient_start_color, 0);
            this.f10291a.aa = 17170445;
        }
        if (obtainStyledAttributes.hasValue(R.styleable.ShapeLinearLayout_gradient_center_color)) {
            int resourceId8 = obtainStyledAttributes.getResourceId(R.styleable.ShapeLinearLayout_gradient_center_color, 0);
            this.f10291a.ab = resourceId8;
            Log.e("skin", "center color resid = " + resourceId8);
            this.f10291a.u = a(context, resourceId8);
        } else {
            this.f10291a.u = obtainStyledAttributes.getColor(R.styleable.ShapeLinearLayout_gradient_center_color, 0);
            this.f10291a.ab = 17170445;
        }
        if (obtainStyledAttributes.hasValue(R.styleable.ShapeLinearLayout_gradient_end_color)) {
            int resourceId9 = obtainStyledAttributes.getResourceId(R.styleable.ShapeLinearLayout_gradient_end_color, 0);
            this.f10291a.ac = resourceId9;
            Log.e("skin", "end color resid = " + resourceId9);
            this.f10291a.v = a(context, resourceId9);
        } else {
            this.f10291a.v = obtainStyledAttributes.getColor(R.styleable.ShapeLinearLayout_gradient_end_color, 0);
            this.f10291a.ac = 17170445;
        }
        if (obtainStyledAttributes.hasValue(R.styleable.ShapeLinearLayout_gradient_start_touch_color)) {
            int resourceId10 = obtainStyledAttributes.getResourceId(R.styleable.ShapeLinearLayout_gradient_start_touch_color, 0);
            this.f10291a.ad = resourceId10;
            Log.e("skin", "start touch color resid = " + resourceId10);
            this.f10291a.w = a(context, resourceId10);
        } else {
            this.f10291a.w = obtainStyledAttributes.getColor(R.styleable.ShapeLinearLayout_gradient_start_touch_color, 0);
            this.f10291a.ad = 17170445;
        }
        if (obtainStyledAttributes.hasValue(R.styleable.ShapeLinearLayout_gradient_center_touch_color)) {
            int resourceId11 = obtainStyledAttributes.getResourceId(R.styleable.ShapeLinearLayout_gradient_center_touch_color, 0);
            this.f10291a.ae = resourceId11;
            Log.e("skin", "start touch color resid = " + resourceId11);
            this.f10291a.x = a(context, resourceId11);
        } else {
            this.f10291a.x = obtainStyledAttributes.getColor(R.styleable.ShapeLinearLayout_gradient_center_touch_color, 0);
            this.f10291a.ae = 17170445;
        }
        if (obtainStyledAttributes.hasValue(R.styleable.ShapeLinearLayout_gradient_end_touch_color)) {
            int resourceId12 = obtainStyledAttributes.getResourceId(R.styleable.ShapeLinearLayout_gradient_end_touch_color, 0);
            this.f10291a.af = resourceId12;
            Log.e("skin", "end touch color resid = " + resourceId12);
            this.f10291a.y = a(context, resourceId12);
        } else {
            this.f10291a.y = obtainStyledAttributes.getColor(R.styleable.ShapeLinearLayout_gradient_end_touch_color, 0);
            this.f10291a.af = 17170445;
        }
        if (obtainStyledAttributes.hasValue(R.styleable.ShapeLinearLayout_gradient_start_unable_color)) {
            int resourceId13 = obtainStyledAttributes.getResourceId(R.styleable.ShapeLinearLayout_gradient_start_unable_color, 0);
            this.f10291a.ag = resourceId13;
            Log.e("skin", "start unable color resid = " + resourceId13);
            this.f10291a.z = a(context, resourceId13);
        } else {
            this.f10291a.z = obtainStyledAttributes.getColor(R.styleable.ShapeLinearLayout_gradient_start_unable_color, 0);
            this.f10291a.ag = 17170445;
        }
        if (obtainStyledAttributes.hasValue(R.styleable.ShapeLinearLayout_gradient_center_unable_color)) {
            int resourceId14 = obtainStyledAttributes.getResourceId(R.styleable.ShapeLinearLayout_gradient_center_unable_color, 0);
            this.f10291a.ah = resourceId14;
            Log.e("skin", "center unable color resid = " + resourceId14);
            this.f10291a.A = a(context, resourceId14);
        } else {
            this.f10291a.A = obtainStyledAttributes.getColor(R.styleable.ShapeLinearLayout_gradient_center_unable_color, 0);
            this.f10291a.ah = 17170445;
        }
        if (obtainStyledAttributes.hasValue(R.styleable.ShapeLinearLayout_gradient_end_unable_color)) {
            int resourceId15 = obtainStyledAttributes.getResourceId(R.styleable.ShapeLinearLayout_gradient_end_unable_color, 0);
            this.f10291a.ai = resourceId15;
            Log.e("skin", "end unable color resid = " + resourceId15);
            this.f10291a.B = a(context, resourceId15);
        } else {
            this.f10291a.B = obtainStyledAttributes.getColor(R.styleable.ShapeLinearLayout_gradient_end_unable_color, 0);
            this.f10291a.ai = 17170445;
        }
        this.f10291a.q = obtainStyledAttributes.getDimension(R.styleable.ShapeLinearLayout_stroke_width, 0.0f);
        this.f10291a.r = obtainStyledAttributes.getDimension(R.styleable.ShapeLinearLayout_stroke_dash_width, 0.0f);
        this.f10291a.s = obtainStyledAttributes.getDimension(R.styleable.ShapeLinearLayout_stroke_dash_gap, 0.0f);
        this.f10291a.H = obtainStyledAttributes.getDimension(R.styleable.ShapeLinearLayout_corner_radius, 0.0f);
        this.f10291a.I = obtainStyledAttributes.getDimension(R.styleable.ShapeLinearLayout_top_left_radius, 0.0f);
        this.f10291a.J = obtainStyledAttributes.getDimension(R.styleable.ShapeLinearLayout_top_right_radius, 0.0f);
        this.f10291a.K = obtainStyledAttributes.getDimension(R.styleable.ShapeLinearLayout_bottom_left_radius, 0.0f);
        this.f10291a.L = obtainStyledAttributes.getDimension(R.styleable.ShapeLinearLayout_bottom_right_radius, 0.0f);
        this.f10291a.C = obtainStyledAttributes.getInt(R.styleable.ShapeLinearLayout_gradient_angle, 0);
        this.f10291a.D = obtainStyledAttributes.getInt(R.styleable.ShapeLinearLayout_gradient_type, 0);
        this.f10291a.E = obtainStyledAttributes.getDimension(R.styleable.ShapeLinearLayout_gradient_radius, 0.0f);
        this.f10291a.F = obtainStyledAttributes.getFloat(R.styleable.ShapeLinearLayout_gradient_center_x, 0.5f);
        this.f10291a.G = obtainStyledAttributes.getFloat(R.styleable.ShapeLinearLayout_gradient_center_y, 0.5f);
        this.f10291a.M = obtainStyledAttributes.getInt(R.styleable.ShapeLinearLayout_bg_model, 0);
        this.f10291a.N = obtainStyledAttributes.getInt(R.styleable.ShapeLinearLayout_shape_type, 0);
        this.f10291a.O = obtainStyledAttributes.getFloat(R.styleable.ShapeLinearLayout_wh_ratio, 0.0f);
        this.f10291a.aj = obtainStyledAttributes.getBoolean(R.styleable.ShapeLinearLayout_supportsRtl, true);
        obtainStyledAttributes.recycle();
        a();
    }

    @Override // skin.support.widget.SkinCompatSupportable
    public void applySkin() {
        Log.e("skin", "ShapeLinearLayout apply skin solidColor = " + this.f10291a.U);
        try {
            this.f10291a.k = BluedSkinUtils.a(getContext(), this.f10291a.U);
            this.f10291a.l = BluedSkinUtils.a(getContext(), this.f10291a.V);
            this.f10291a.m = BluedSkinUtils.a(getContext(), this.f10291a.W);
            this.f10291a.t = BluedSkinUtils.a(getContext(), this.f10291a.aa);
            this.f10291a.u = BluedSkinUtils.a(getContext(), this.f10291a.ab);
            this.f10291a.v = BluedSkinUtils.a(getContext(), this.f10291a.ac);
            this.f10291a.z = BluedSkinUtils.a(getContext(), this.f10291a.ag);
            this.f10291a.A = BluedSkinUtils.a(getContext(), this.f10291a.ah);
            this.f10291a.B = BluedSkinUtils.a(getContext(), this.f10291a.ai);
            this.f10291a.w = BluedSkinUtils.a(getContext(), this.f10291a.ad);
            this.f10291a.x = BluedSkinUtils.a(getContext(), this.f10291a.ae);
            this.f10291a.y = BluedSkinUtils.a(getContext(), this.f10291a.af);
            this.f10291a.n = BluedSkinUtils.a(getContext(), this.f10291a.X);
            this.f10291a.o = BluedSkinUtils.a(getContext(), this.f10291a.Y);
            this.f10291a.p = BluedSkinUtils.a(getContext(), this.f10291a.Z);
            a();
        } catch (Exception e) {
        }
    }

    @Override // com.blued.android.framework.view.shape.ShapeHelper.ShapeView
    public ShapeModel getShapeModel() {
        if (this.f10291a == null) {
            this.f10291a = new ShapeModel();
        }
        return this.f10291a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i, int i2) {
        ShapeModel shapeModel = this.f10291a;
        int i3 = i;
        int i4 = i2;
        if (shapeModel != null) {
            i3 = i;
            i4 = i2;
            if (shapeModel.O != 0.0f) {
                setMeasuredDimension(getDefaultSize(0, i), getDefaultSize(0, i2));
                int measuredWidth = getMeasuredWidth();
                i3 = View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824);
                i4 = View.MeasureSpec.makeMeasureSpec((int) (measuredWidth / this.f10291a.O), 1073741824);
            }
        }
        super.onMeasure(i3, i4);
    }

    @Override // com.blued.android.framework.view.shape.ShapeHelper.ShapeView
    public void setShapeModel(ShapeModel shapeModel) {
        this.f10291a = shapeModel;
        a();
    }
}
