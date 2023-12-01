package com.blued.android.framework.view.shape;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import com.blued.android.core.utils.Log;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.core.utils.skin.listener.BluedSkinSupportable;
import com.blued.android.framework.R;
import com.blued.android.framework.utils.AppUtils;
import com.blued.android.framework.view.shape.ShapeHelper;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/view/shape/ShapeTextView.class */
public class ShapeTextView extends AppCompatTextView implements BluedSkinSupportable, ShapeHelper.ShapeView {

    /* renamed from: a  reason: collision with root package name */
    private ShapeModel f10295a;

    public ShapeTextView(Context context) {
        super(context);
    }

    public ShapeTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet);
    }

    public ShapeTextView(Context context, AttributeSet attributeSet, int i) {
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
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ShapeTextView);
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, R.styleable.ShapeTextAppearance);
        this.f10295a = new ShapeModel();
        if (obtainStyledAttributes2.hasValue(R.styleable.ShapeTextAppearance_android_textColor)) {
            this.f10295a.P = obtainStyledAttributes2.getResourceId(R.styleable.ShapeTextAppearance_android_textColor, this.f10295a.P);
            ShapeModel shapeModel = this.f10295a;
            shapeModel.b = a(context, shapeModel.P);
        } else {
            this.f10295a.P = 17170445;
            this.f10295a.b = 0;
        }
        if (obtainStyledAttributes.hasValue(R.styleable.ShapeTextView_text_touch_color)) {
            this.f10295a.Q = obtainStyledAttributes.getResourceId(R.styleable.ShapeTextView_text_touch_color, this.f10295a.P);
            ShapeModel shapeModel2 = this.f10295a;
            shapeModel2.f10293c = a(context, shapeModel2.Q);
        } else {
            ShapeModel shapeModel3 = this.f10295a;
            shapeModel3.f10293c = shapeModel3.b;
            ShapeModel shapeModel4 = this.f10295a;
            shapeModel4.Q = shapeModel4.P;
        }
        if (obtainStyledAttributes.hasValue(R.styleable.ShapeTextView_text_unable_color)) {
            this.f10295a.R = obtainStyledAttributes.getResourceId(R.styleable.ShapeTextView_text_unable_color, this.f10295a.P);
            ShapeModel shapeModel5 = this.f10295a;
            shapeModel5.d = a(context, shapeModel5.R);
        } else {
            ShapeModel shapeModel6 = this.f10295a;
            shapeModel6.R = shapeModel6.P;
            ShapeModel shapeModel7 = this.f10295a;
            shapeModel7.d = shapeModel7.b;
        }
        if (obtainStyledAttributes.hasValue(R.styleable.ShapeTextView_text_start_color)) {
            this.f10295a.S = obtainStyledAttributes.getResourceId(R.styleable.ShapeTextView_text_start_color, 17170445);
            ShapeModel shapeModel8 = this.f10295a;
            shapeModel8.e = a(context, shapeModel8.S);
        } else {
            this.f10295a.S = 17170445;
            this.f10295a.e = obtainStyledAttributes.getColor(R.styleable.ShapeTextView_text_start_color, 0);
        }
        if (obtainStyledAttributes.hasValue(R.styleable.ShapeTextView_text_end_color)) {
            this.f10295a.T = obtainStyledAttributes.getResourceId(R.styleable.ShapeTextView_text_end_color, 17170445);
            ShapeModel shapeModel9 = this.f10295a;
            shapeModel9.f = a(context, shapeModel9.T);
        } else {
            this.f10295a.T = 17170445;
            this.f10295a.f = obtainStyledAttributes.getColor(R.styleable.ShapeTextView_text_end_color, 0);
        }
        this.f10295a.g = obtainStyledAttributes.getInt(R.styleable.ShapeTextView_text_color_angle, 0);
        this.f10295a.f10292a = obtainStyledAttributes.getBoolean(R.styleable.ShapeTextView_bg_default_touch, true);
        this.f10295a.h = obtainStyledAttributes.getDrawable(R.styleable.ShapeTextView_bg_drawable);
        this.f10295a.i = obtainStyledAttributes.getDrawable(R.styleable.ShapeTextView_bg_touch_drawable);
        this.f10295a.j = obtainStyledAttributes.getDrawable(R.styleable.ShapeTextView_bg_unable_drawable);
        if (obtainStyledAttributes.hasValue(R.styleable.ShapeTextView_solid_color)) {
            int resourceId = obtainStyledAttributes.getResourceId(R.styleable.ShapeTextView_solid_color, 0);
            this.f10295a.U = resourceId;
            Log.e("skin", "solid color resid = " + resourceId);
            this.f10295a.k = a(context, resourceId);
        } else {
            this.f10295a.k = obtainStyledAttributes.getColor(R.styleable.ShapeTextView_solid_color, 0);
            this.f10295a.U = 17170445;
        }
        if (obtainStyledAttributes.hasValue(R.styleable.ShapeTextView_solid_touch_color)) {
            int resourceId2 = obtainStyledAttributes.getResourceId(R.styleable.ShapeTextView_solid_touch_color, 0);
            this.f10295a.V = resourceId2;
            Log.e("skin", "solid touch color resid = " + resourceId2);
            this.f10295a.l = a(context, resourceId2);
        } else {
            this.f10295a.l = obtainStyledAttributes.getColor(R.styleable.ShapeTextView_solid_touch_color, 0);
            this.f10295a.V = 17170445;
        }
        if (obtainStyledAttributes.hasValue(R.styleable.ShapeTextView_solid_unable_color)) {
            int resourceId3 = obtainStyledAttributes.getResourceId(R.styleable.ShapeTextView_solid_unable_color, 0);
            this.f10295a.W = resourceId3;
            Log.e("skin", "solid unable color resid = " + resourceId3);
            this.f10295a.m = a(context, resourceId3);
        } else {
            this.f10295a.m = obtainStyledAttributes.getColor(R.styleable.ShapeTextView_solid_unable_color, 0);
            this.f10295a.W = 17170445;
        }
        if (obtainStyledAttributes.hasValue(R.styleable.ShapeTextView_stroke_color)) {
            int resourceId4 = obtainStyledAttributes.getResourceId(R.styleable.ShapeTextView_stroke_color, 0);
            this.f10295a.X = resourceId4;
            Log.e("skin", "solid unable color resid = " + resourceId4);
            this.f10295a.n = a(context, resourceId4);
        } else {
            this.f10295a.n = obtainStyledAttributes.getColor(R.styleable.ShapeTextView_stroke_color, 0);
            this.f10295a.X = 17170445;
        }
        if (obtainStyledAttributes.hasValue(R.styleable.ShapeTextView_stroke_touch_color)) {
            int resourceId5 = obtainStyledAttributes.getResourceId(R.styleable.ShapeTextView_stroke_touch_color, 0);
            this.f10295a.Y = resourceId5;
            Log.e("skin", "solid unable color resid = " + resourceId5);
            this.f10295a.o = a(context, resourceId5);
        } else {
            this.f10295a.o = obtainStyledAttributes.getColor(R.styleable.ShapeTextView_stroke_touch_color, 0);
            this.f10295a.Y = 17170445;
        }
        if (obtainStyledAttributes.hasValue(R.styleable.ShapeTextView_stroke_unable_color)) {
            int resourceId6 = obtainStyledAttributes.getResourceId(R.styleable.ShapeTextView_stroke_unable_color, 0);
            this.f10295a.Z = resourceId6;
            Log.e("skin", "solid unable color resid = " + resourceId6);
            this.f10295a.p = a(context, resourceId6);
        } else {
            this.f10295a.p = obtainStyledAttributes.getColor(R.styleable.ShapeTextView_stroke_unable_color, 0);
            this.f10295a.Z = 17170445;
        }
        if (obtainStyledAttributes.hasValue(R.styleable.ShapeTextView_gradient_start_color)) {
            int resourceId7 = obtainStyledAttributes.getResourceId(R.styleable.ShapeTextView_gradient_start_color, 0);
            this.f10295a.aa = resourceId7;
            Log.e("skin", "start color resid = " + resourceId7);
            this.f10295a.t = a(context, resourceId7);
        } else {
            this.f10295a.t = obtainStyledAttributes.getColor(R.styleable.ShapeTextView_gradient_start_color, 0);
            this.f10295a.aa = 17170445;
        }
        if (obtainStyledAttributes.hasValue(R.styleable.ShapeTextView_gradient_center_color)) {
            int resourceId8 = obtainStyledAttributes.getResourceId(R.styleable.ShapeTextView_gradient_center_color, 0);
            this.f10295a.ab = resourceId8;
            Log.e("skin", "center color resid = " + resourceId8);
            this.f10295a.u = a(context, resourceId8);
        } else {
            this.f10295a.u = obtainStyledAttributes.getColor(R.styleable.ShapeTextView_gradient_center_color, 0);
            this.f10295a.ab = 17170445;
        }
        if (obtainStyledAttributes.hasValue(R.styleable.ShapeTextView_gradient_end_color)) {
            int resourceId9 = obtainStyledAttributes.getResourceId(R.styleable.ShapeTextView_gradient_end_color, 0);
            this.f10295a.ac = resourceId9;
            Log.e("skin", "end color resid = " + resourceId9);
            this.f10295a.v = a(context, resourceId9);
        } else {
            this.f10295a.v = obtainStyledAttributes.getColor(R.styleable.ShapeTextView_gradient_end_color, 0);
            this.f10295a.ac = 17170445;
        }
        if (obtainStyledAttributes.hasValue(R.styleable.ShapeTextView_gradient_start_touch_color)) {
            int resourceId10 = obtainStyledAttributes.getResourceId(R.styleable.ShapeTextView_gradient_start_touch_color, 0);
            this.f10295a.ad = resourceId10;
            Log.e("skin", "start touch color resid = " + resourceId10);
            this.f10295a.w = a(context, resourceId10);
        } else {
            this.f10295a.w = obtainStyledAttributes.getColor(R.styleable.ShapeTextView_gradient_start_touch_color, 0);
            this.f10295a.ad = 17170445;
        }
        if (obtainStyledAttributes.hasValue(R.styleable.ShapeTextView_gradient_center_touch_color)) {
            int resourceId11 = obtainStyledAttributes.getResourceId(R.styleable.ShapeTextView_gradient_center_touch_color, 0);
            this.f10295a.ae = resourceId11;
            Log.e("skin", "start touch color resid = " + resourceId11);
            this.f10295a.x = a(context, resourceId11);
        } else {
            this.f10295a.x = obtainStyledAttributes.getColor(R.styleable.ShapeTextView_gradient_center_touch_color, 0);
            this.f10295a.ae = 17170445;
        }
        if (obtainStyledAttributes.hasValue(R.styleable.ShapeTextView_gradient_end_touch_color)) {
            int resourceId12 = obtainStyledAttributes.getResourceId(R.styleable.ShapeTextView_gradient_end_touch_color, 0);
            this.f10295a.af = resourceId12;
            Log.e("skin", "end touch color resid = " + resourceId12);
            this.f10295a.y = a(context, resourceId12);
        } else {
            this.f10295a.y = obtainStyledAttributes.getColor(R.styleable.ShapeTextView_gradient_end_touch_color, 0);
            this.f10295a.af = 17170445;
        }
        if (obtainStyledAttributes.hasValue(R.styleable.ShapeTextView_gradient_start_unable_color)) {
            int resourceId13 = obtainStyledAttributes.getResourceId(R.styleable.ShapeTextView_gradient_start_unable_color, 0);
            this.f10295a.ag = resourceId13;
            Log.e("skin", "start unable color resid = " + resourceId13);
            this.f10295a.z = a(context, resourceId13);
        } else {
            this.f10295a.z = obtainStyledAttributes.getColor(R.styleable.ShapeTextView_gradient_start_unable_color, 0);
            this.f10295a.ag = 17170445;
        }
        if (obtainStyledAttributes.hasValue(R.styleable.ShapeTextView_gradient_center_unable_color)) {
            int resourceId14 = obtainStyledAttributes.getResourceId(R.styleable.ShapeTextView_gradient_center_unable_color, 0);
            this.f10295a.ah = resourceId14;
            Log.e("skin", "center unable color resid = " + resourceId14);
            this.f10295a.A = a(context, resourceId14);
        } else {
            this.f10295a.A = obtainStyledAttributes.getColor(R.styleable.ShapeTextView_gradient_center_unable_color, 0);
            this.f10295a.ah = 17170445;
        }
        if (obtainStyledAttributes.hasValue(R.styleable.ShapeTextView_gradient_end_unable_color)) {
            int resourceId15 = obtainStyledAttributes.getResourceId(R.styleable.ShapeTextView_gradient_end_unable_color, 0);
            this.f10295a.ai = resourceId15;
            Log.e("skin", "end unable color resid = " + resourceId15);
            this.f10295a.B = a(context, resourceId15);
        } else {
            this.f10295a.B = obtainStyledAttributes.getColor(R.styleable.ShapeTextView_gradient_end_unable_color, 0);
            this.f10295a.ai = 17170445;
        }
        this.f10295a.q = obtainStyledAttributes.getDimension(R.styleable.ShapeTextView_stroke_width, 0.0f);
        this.f10295a.r = obtainStyledAttributes.getDimension(R.styleable.ShapeTextView_stroke_dash_width, 0.0f);
        this.f10295a.s = obtainStyledAttributes.getDimension(R.styleable.ShapeTextView_stroke_dash_gap, 0.0f);
        this.f10295a.H = obtainStyledAttributes.getDimension(R.styleable.ShapeTextView_corner_radius, 0.0f);
        this.f10295a.I = obtainStyledAttributes.getDimension(R.styleable.ShapeTextView_top_left_radius, 0.0f);
        this.f10295a.J = obtainStyledAttributes.getDimension(R.styleable.ShapeTextView_top_right_radius, 0.0f);
        this.f10295a.K = obtainStyledAttributes.getDimension(R.styleable.ShapeTextView_bottom_left_radius, 0.0f);
        this.f10295a.L = obtainStyledAttributes.getDimension(R.styleable.ShapeTextView_bottom_right_radius, 0.0f);
        this.f10295a.C = obtainStyledAttributes.getInt(R.styleable.ShapeTextView_gradient_angle, 0);
        this.f10295a.D = obtainStyledAttributes.getInt(R.styleable.ShapeTextView_gradient_type, 0);
        this.f10295a.E = obtainStyledAttributes.getDimension(R.styleable.ShapeTextView_gradient_radius, 0.0f);
        this.f10295a.F = obtainStyledAttributes.getFloat(R.styleable.ShapeTextView_gradient_center_x, 0.5f);
        this.f10295a.G = obtainStyledAttributes.getFloat(R.styleable.ShapeTextView_gradient_center_y, 0.5f);
        this.f10295a.M = obtainStyledAttributes.getInt(R.styleable.ShapeTextView_bg_model, 0);
        this.f10295a.N = obtainStyledAttributes.getInt(R.styleable.ShapeTextView_shape_type, 0);
        this.f10295a.O = obtainStyledAttributes.getFloat(R.styleable.ShapeTextView_wh_ratio, 0.0f);
        this.f10295a.aj = obtainStyledAttributes.getBoolean(R.styleable.ShapeTextView_supportsRtl, true);
        obtainStyledAttributes.recycle();
        a();
    }

    @Override // skin.support.widget.SkinCompatSupportable
    public void applySkin() {
        Log.e("skin", "ShapeLinearLayout apply skin solidColor = " + this.f10295a.U);
        try {
            this.f10295a.b = BluedSkinUtils.a(getContext(), this.f10295a.P);
            this.f10295a.f10293c = BluedSkinUtils.a(getContext(), this.f10295a.Q);
            this.f10295a.d = BluedSkinUtils.a(getContext(), this.f10295a.R);
            this.f10295a.e = BluedSkinUtils.a(getContext(), this.f10295a.S);
            this.f10295a.f = BluedSkinUtils.a(getContext(), this.f10295a.T);
            this.f10295a.k = BluedSkinUtils.a(getContext(), this.f10295a.U);
            this.f10295a.l = BluedSkinUtils.a(getContext(), this.f10295a.V);
            this.f10295a.m = BluedSkinUtils.a(getContext(), this.f10295a.W);
            this.f10295a.t = BluedSkinUtils.a(getContext(), this.f10295a.aa);
            this.f10295a.u = BluedSkinUtils.a(getContext(), this.f10295a.ab);
            this.f10295a.v = BluedSkinUtils.a(getContext(), this.f10295a.ac);
            this.f10295a.z = BluedSkinUtils.a(getContext(), this.f10295a.ag);
            this.f10295a.A = BluedSkinUtils.a(getContext(), this.f10295a.ah);
            this.f10295a.B = BluedSkinUtils.a(getContext(), this.f10295a.ai);
            this.f10295a.w = BluedSkinUtils.a(getContext(), this.f10295a.ad);
            this.f10295a.x = BluedSkinUtils.a(getContext(), this.f10295a.ae);
            this.f10295a.y = BluedSkinUtils.a(getContext(), this.f10295a.af);
            this.f10295a.n = BluedSkinUtils.a(getContext(), this.f10295a.X);
            this.f10295a.o = BluedSkinUtils.a(getContext(), this.f10295a.Y);
            this.f10295a.p = BluedSkinUtils.a(getContext(), this.f10295a.Z);
            a();
        } catch (Exception e) {
        }
    }

    @Override // com.blued.android.framework.view.shape.ShapeHelper.ShapeView
    public ShapeModel getShapeModel() {
        if (this.f10295a == null) {
            this.f10295a = new ShapeModel();
        }
        return this.f10295a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        ShapeModel shapeModel = this.f10295a;
        if (shapeModel != null && shapeModel.e != 0 && this.f10295a.f != 0) {
            int i = this.f10295a.g;
            getPaint().setShader(i != 90 ? i != 180 ? i != 270 ? (AppUtils.c() && this.f10295a.aj) ? new LinearGradient(getMeasuredWidth(), 0.0f, 0.0f, 0.0f, this.f10295a.e, this.f10295a.f, Shader.TileMode.REPEAT) : new LinearGradient(0.0f, 0.0f, getMeasuredWidth(), 0.0f, this.f10295a.e, this.f10295a.f, Shader.TileMode.REPEAT) : new LinearGradient(0.0f, getMeasuredHeight(), 0.0f, 0.0f, this.f10295a.e, this.f10295a.f, Shader.TileMode.REPEAT) : (AppUtils.c() && this.f10295a.aj) ? new LinearGradient(0.0f, 0.0f, getMeasuredWidth(), 0.0f, this.f10295a.e, this.f10295a.f, Shader.TileMode.REPEAT) : new LinearGradient(getMeasuredWidth(), 0.0f, 0.0f, 0.0f, this.f10295a.e, this.f10295a.f, Shader.TileMode.REPEAT) : new LinearGradient(0.0f, 0.0f, 0.0f, getMeasuredHeight(), this.f10295a.e, this.f10295a.f, Shader.TileMode.REPEAT));
        }
        super.onDraw(canvas);
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public void onMeasure(int i, int i2) {
        ShapeModel shapeModel = this.f10295a;
        int i3 = i;
        int i4 = i2;
        if (shapeModel != null) {
            i3 = i;
            i4 = i2;
            if (shapeModel.O != 0.0f) {
                setMeasuredDimension(getDefaultSize(0, i), getDefaultSize(0, i2));
                int measuredWidth = getMeasuredWidth();
                i3 = View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824);
                i4 = View.MeasureSpec.makeMeasureSpec((int) (measuredWidth / this.f10295a.O), 1073741824);
            }
        }
        super.onMeasure(i3, i4);
    }

    @Override // com.blued.android.framework.view.shape.ShapeHelper.ShapeView
    public void setShapeModel(ShapeModel shapeModel) {
        this.f10295a = shapeModel;
        a();
    }
}
