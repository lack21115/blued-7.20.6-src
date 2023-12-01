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

    /* renamed from: a  reason: collision with root package name */
    private ShapeModel f10294a;

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
        this.f10294a = shapeModel;
        shapeModel.f10292a = obtainStyledAttributes.getBoolean(R.styleable.ShapeRelativeLayout_bg_default_touch, false);
        this.f10294a.h = obtainStyledAttributes.getDrawable(R.styleable.ShapeRelativeLayout_bg_drawable);
        this.f10294a.i = obtainStyledAttributes.getDrawable(R.styleable.ShapeRelativeLayout_bg_touch_drawable);
        this.f10294a.j = obtainStyledAttributes.getDrawable(R.styleable.ShapeRelativeLayout_bg_unable_drawable);
        if (obtainStyledAttributes.hasValue(R.styleable.ShapeRelativeLayout_solid_color)) {
            int resourceId = obtainStyledAttributes.getResourceId(R.styleable.ShapeRelativeLayout_solid_color, 0);
            this.f10294a.U = resourceId;
            Log.e("skin", "solid color resid = " + resourceId);
            this.f10294a.k = a(context, resourceId);
        } else {
            this.f10294a.k = obtainStyledAttributes.getColor(R.styleable.ShapeRelativeLayout_solid_color, 0);
            this.f10294a.U = 17170445;
        }
        if (obtainStyledAttributes.hasValue(R.styleable.ShapeRelativeLayout_solid_touch_color)) {
            int resourceId2 = obtainStyledAttributes.getResourceId(R.styleable.ShapeRelativeLayout_solid_touch_color, 0);
            this.f10294a.V = resourceId2;
            Log.e("skin", "solid touch color resid = " + resourceId2);
            this.f10294a.l = a(context, resourceId2);
        } else {
            this.f10294a.l = obtainStyledAttributes.getColor(R.styleable.ShapeRelativeLayout_solid_touch_color, 0);
            this.f10294a.V = 17170445;
        }
        if (obtainStyledAttributes.hasValue(R.styleable.ShapeRelativeLayout_solid_unable_color)) {
            int resourceId3 = obtainStyledAttributes.getResourceId(R.styleable.ShapeRelativeLayout_solid_unable_color, 0);
            this.f10294a.W = resourceId3;
            Log.e("skin", "solid unable color resid = " + resourceId3);
            this.f10294a.m = a(context, resourceId3);
        } else {
            this.f10294a.m = obtainStyledAttributes.getColor(R.styleable.ShapeRelativeLayout_solid_unable_color, 0);
            this.f10294a.W = 17170445;
        }
        if (obtainStyledAttributes.hasValue(R.styleable.ShapeRelativeLayout_stroke_color)) {
            int resourceId4 = obtainStyledAttributes.getResourceId(R.styleable.ShapeRelativeLayout_stroke_color, 0);
            this.f10294a.X = resourceId4;
            Log.e("skin", "solid unable color resid = " + resourceId4);
            this.f10294a.n = a(context, resourceId4);
        } else {
            this.f10294a.n = obtainStyledAttributes.getColor(R.styleable.ShapeRelativeLayout_stroke_color, 0);
            this.f10294a.X = 17170445;
        }
        if (obtainStyledAttributes.hasValue(R.styleable.ShapeRelativeLayout_stroke_touch_color)) {
            int resourceId5 = obtainStyledAttributes.getResourceId(R.styleable.ShapeRelativeLayout_stroke_touch_color, 0);
            this.f10294a.Y = resourceId5;
            Log.e("skin", "solid unable color resid = " + resourceId5);
            this.f10294a.o = a(context, resourceId5);
        } else {
            this.f10294a.o = obtainStyledAttributes.getColor(R.styleable.ShapeRelativeLayout_stroke_touch_color, 0);
            this.f10294a.Y = 17170445;
        }
        if (obtainStyledAttributes.hasValue(R.styleable.ShapeRelativeLayout_stroke_unable_color)) {
            int resourceId6 = obtainStyledAttributes.getResourceId(R.styleable.ShapeRelativeLayout_stroke_unable_color, 0);
            this.f10294a.Z = resourceId6;
            Log.e("skin", "solid unable color resid = " + resourceId6);
            this.f10294a.p = a(context, resourceId6);
        } else {
            this.f10294a.p = obtainStyledAttributes.getColor(R.styleable.ShapeRelativeLayout_stroke_unable_color, 0);
            this.f10294a.Z = 17170445;
        }
        if (obtainStyledAttributes.hasValue(R.styleable.ShapeRelativeLayout_gradient_start_color)) {
            int resourceId7 = obtainStyledAttributes.getResourceId(R.styleable.ShapeRelativeLayout_gradient_start_color, 0);
            this.f10294a.aa = resourceId7;
            Log.e("skin", "start color resid = " + resourceId7);
            this.f10294a.t = a(context, resourceId7);
        } else {
            this.f10294a.t = obtainStyledAttributes.getColor(R.styleable.ShapeRelativeLayout_gradient_start_color, 0);
            this.f10294a.aa = 17170445;
        }
        if (obtainStyledAttributes.hasValue(R.styleable.ShapeRelativeLayout_gradient_center_color)) {
            int resourceId8 = obtainStyledAttributes.getResourceId(R.styleable.ShapeRelativeLayout_gradient_center_color, 0);
            this.f10294a.ab = resourceId8;
            Log.e("skin", "center color resid = " + resourceId8);
            this.f10294a.u = a(context, resourceId8);
        } else {
            this.f10294a.u = obtainStyledAttributes.getColor(R.styleable.ShapeRelativeLayout_gradient_center_color, 0);
            this.f10294a.ab = 17170445;
        }
        if (obtainStyledAttributes.hasValue(R.styleable.ShapeRelativeLayout_gradient_end_color)) {
            int resourceId9 = obtainStyledAttributes.getResourceId(R.styleable.ShapeRelativeLayout_gradient_end_color, 0);
            this.f10294a.ac = resourceId9;
            Log.e("skin", "end color resid = " + resourceId9);
            this.f10294a.v = a(context, resourceId9);
        } else {
            this.f10294a.v = obtainStyledAttributes.getColor(R.styleable.ShapeRelativeLayout_gradient_end_color, 0);
            this.f10294a.ac = 17170445;
        }
        if (obtainStyledAttributes.hasValue(R.styleable.ShapeRelativeLayout_gradient_start_touch_color)) {
            int resourceId10 = obtainStyledAttributes.getResourceId(R.styleable.ShapeRelativeLayout_gradient_start_touch_color, 0);
            this.f10294a.ad = resourceId10;
            Log.e("skin", "start touch color resid = " + resourceId10);
            this.f10294a.w = a(context, resourceId10);
        } else {
            this.f10294a.w = obtainStyledAttributes.getColor(R.styleable.ShapeRelativeLayout_gradient_start_touch_color, 0);
            this.f10294a.ad = 17170445;
        }
        if (obtainStyledAttributes.hasValue(R.styleable.ShapeRelativeLayout_gradient_center_touch_color)) {
            int resourceId11 = obtainStyledAttributes.getResourceId(R.styleable.ShapeRelativeLayout_gradient_center_touch_color, 0);
            this.f10294a.ae = resourceId11;
            Log.e("skin", "start touch color resid = " + resourceId11);
            this.f10294a.x = a(context, resourceId11);
        } else {
            this.f10294a.x = obtainStyledAttributes.getColor(R.styleable.ShapeRelativeLayout_gradient_center_touch_color, 0);
            this.f10294a.ae = 17170445;
        }
        if (obtainStyledAttributes.hasValue(R.styleable.ShapeRelativeLayout_gradient_end_touch_color)) {
            int resourceId12 = obtainStyledAttributes.getResourceId(R.styleable.ShapeRelativeLayout_gradient_end_touch_color, 0);
            this.f10294a.af = resourceId12;
            Log.e("skin", "end touch color resid = " + resourceId12);
            this.f10294a.y = a(context, resourceId12);
        } else {
            this.f10294a.y = obtainStyledAttributes.getColor(R.styleable.ShapeRelativeLayout_gradient_end_touch_color, 0);
            this.f10294a.af = 17170445;
        }
        if (obtainStyledAttributes.hasValue(R.styleable.ShapeRelativeLayout_gradient_start_unable_color)) {
            int resourceId13 = obtainStyledAttributes.getResourceId(R.styleable.ShapeRelativeLayout_gradient_start_unable_color, 0);
            this.f10294a.ag = resourceId13;
            Log.e("skin", "start unable color resid = " + resourceId13);
            this.f10294a.z = a(context, resourceId13);
        } else {
            this.f10294a.z = obtainStyledAttributes.getColor(R.styleable.ShapeRelativeLayout_gradient_start_unable_color, 0);
            this.f10294a.ag = 17170445;
        }
        if (obtainStyledAttributes.hasValue(R.styleable.ShapeRelativeLayout_gradient_center_unable_color)) {
            int resourceId14 = obtainStyledAttributes.getResourceId(R.styleable.ShapeRelativeLayout_gradient_center_unable_color, 0);
            this.f10294a.ah = resourceId14;
            Log.e("skin", "center unable color resid = " + resourceId14);
            this.f10294a.A = a(context, resourceId14);
        } else {
            this.f10294a.A = obtainStyledAttributes.getColor(R.styleable.ShapeRelativeLayout_gradient_center_unable_color, 0);
            this.f10294a.ah = 17170445;
        }
        if (obtainStyledAttributes.hasValue(R.styleable.ShapeRelativeLayout_gradient_end_unable_color)) {
            int resourceId15 = obtainStyledAttributes.getResourceId(R.styleable.ShapeRelativeLayout_gradient_end_unable_color, 0);
            this.f10294a.ai = resourceId15;
            Log.e("skin", "end unable color resid = " + resourceId15);
            this.f10294a.B = a(context, resourceId15);
        } else {
            this.f10294a.B = obtainStyledAttributes.getColor(R.styleable.ShapeRelativeLayout_gradient_end_unable_color, 0);
            this.f10294a.ai = 17170445;
        }
        this.f10294a.q = obtainStyledAttributes.getDimension(R.styleable.ShapeRelativeLayout_stroke_width, 0.0f);
        this.f10294a.r = obtainStyledAttributes.getDimension(R.styleable.ShapeRelativeLayout_stroke_dash_width, 0.0f);
        this.f10294a.s = obtainStyledAttributes.getDimension(R.styleable.ShapeRelativeLayout_stroke_dash_gap, 0.0f);
        this.f10294a.H = obtainStyledAttributes.getDimension(R.styleable.ShapeRelativeLayout_corner_radius, 0.0f);
        this.f10294a.I = obtainStyledAttributes.getDimension(R.styleable.ShapeRelativeLayout_top_left_radius, 0.0f);
        this.f10294a.J = obtainStyledAttributes.getDimension(R.styleable.ShapeRelativeLayout_top_right_radius, 0.0f);
        this.f10294a.K = obtainStyledAttributes.getDimension(R.styleable.ShapeRelativeLayout_bottom_left_radius, 0.0f);
        this.f10294a.L = obtainStyledAttributes.getDimension(R.styleable.ShapeRelativeLayout_bottom_right_radius, 0.0f);
        this.f10294a.C = obtainStyledAttributes.getInt(R.styleable.ShapeRelativeLayout_gradient_angle, 0);
        this.f10294a.D = obtainStyledAttributes.getInt(R.styleable.ShapeRelativeLayout_gradient_type, 0);
        this.f10294a.E = obtainStyledAttributes.getDimension(R.styleable.ShapeRelativeLayout_gradient_radius, 0.0f);
        this.f10294a.F = obtainStyledAttributes.getFloat(R.styleable.ShapeRelativeLayout_gradient_center_x, 0.5f);
        this.f10294a.G = obtainStyledAttributes.getFloat(R.styleable.ShapeRelativeLayout_gradient_center_y, 0.5f);
        this.f10294a.M = obtainStyledAttributes.getInt(R.styleable.ShapeRelativeLayout_bg_model, 0);
        this.f10294a.N = obtainStyledAttributes.getInt(R.styleable.ShapeRelativeLayout_shape_type, 0);
        this.f10294a.O = obtainStyledAttributes.getFloat(R.styleable.ShapeRelativeLayout_wh_ratio, 0.0f);
        this.f10294a.aj = obtainStyledAttributes.getBoolean(R.styleable.ShapeRelativeLayout_supportsRtl, true);
        obtainStyledAttributes.recycle();
        a();
    }

    @Override // skin.support.widget.SkinCompatSupportable
    public void applySkin() {
        Log.e("skin", "ShapeRelativeLayout apply skin solidColor = " + this.f10294a.U);
        try {
            this.f10294a.k = BluedSkinUtils.a(getContext(), this.f10294a.U);
            this.f10294a.l = BluedSkinUtils.a(getContext(), this.f10294a.V);
            this.f10294a.m = BluedSkinUtils.a(getContext(), this.f10294a.W);
            this.f10294a.t = BluedSkinUtils.a(getContext(), this.f10294a.aa);
            this.f10294a.u = BluedSkinUtils.a(getContext(), this.f10294a.ab);
            this.f10294a.v = BluedSkinUtils.a(getContext(), this.f10294a.ac);
            this.f10294a.z = BluedSkinUtils.a(getContext(), this.f10294a.ag);
            this.f10294a.A = BluedSkinUtils.a(getContext(), this.f10294a.ah);
            this.f10294a.B = BluedSkinUtils.a(getContext(), this.f10294a.ai);
            this.f10294a.w = BluedSkinUtils.a(getContext(), this.f10294a.ad);
            this.f10294a.x = BluedSkinUtils.a(getContext(), this.f10294a.ae);
            this.f10294a.y = BluedSkinUtils.a(getContext(), this.f10294a.af);
            this.f10294a.n = BluedSkinUtils.a(getContext(), this.f10294a.X);
            this.f10294a.o = BluedSkinUtils.a(getContext(), this.f10294a.Y);
            this.f10294a.p = BluedSkinUtils.a(getContext(), this.f10294a.Z);
            a();
        } catch (Exception e) {
        }
    }

    @Override // com.blued.android.framework.view.shape.ShapeHelper.ShapeView
    public ShapeModel getShapeModel() {
        if (this.f10294a == null) {
            this.f10294a = new ShapeModel();
        }
        return this.f10294a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i, int i2) {
        ShapeModel shapeModel = this.f10294a;
        int i3 = i;
        int i4 = i2;
        if (shapeModel != null) {
            i3 = i;
            i4 = i2;
            if (shapeModel.O != 0.0f) {
                setMeasuredDimension(getDefaultSize(0, i), getDefaultSize(0, i2));
                int measuredWidth = getMeasuredWidth();
                i3 = View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824);
                i4 = View.MeasureSpec.makeMeasureSpec((int) (measuredWidth / this.f10294a.O), 1073741824);
            }
        }
        super.onMeasure(i3, i4);
    }

    @Override // com.blued.android.framework.view.shape.ShapeHelper.ShapeView
    public void setShapeModel(ShapeModel shapeModel) {
        this.f10294a = shapeModel;
        a();
    }
}
