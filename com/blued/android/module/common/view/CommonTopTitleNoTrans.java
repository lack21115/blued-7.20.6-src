package com.blued.android.module.common.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.R;
import com.bytedance.applog.tracker.Tracker;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/view/CommonTopTitleNoTrans.class */
public class CommonTopTitleNoTrans extends LinearLayout implements View.OnClickListener {
    private View a;
    private Context b;
    private LinearLayout c;
    private ShapeTextView d;
    private ShapeTextView e;
    private ShapeTextView f;
    private ImageView g;
    private ImageView h;
    private ImageView i;
    private ImageView j;
    private View.OnClickListener k;
    private View.OnClickListener l;
    private View.OnClickListener m;
    private TextView n;
    private TextView o;
    private TextView p;
    private RelativeLayout q;

    public CommonTopTitleNoTrans(Context context) {
        super(context);
        this.b = context;
        a((AttributeSet) null);
    }

    public CommonTopTitleNoTrans(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = context;
        a(attributeSet);
    }

    public CommonTopTitleNoTrans(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = context;
        a(attributeSet);
    }

    private void a(ImageView imageView, TextView textView, int i) {
        if (imageView != null) {
            imageView.setVisibility(0);
            imageView.setImageResource(i);
        }
        if (textView != null) {
            textView.setVisibility(8);
        }
    }

    private void a(TextView textView, ImageView imageView, String str) {
        if (textView != null) {
            textView.setVisibility(0);
            textView.setText(str);
        }
        if (imageView != null) {
            imageView.setVisibility(8);
        }
    }

    public void a() {
        this.f.setVisibility(8);
        this.h.setVisibility(8);
    }

    public void a(int i) {
        this.j.setVisibility(i);
    }

    public void a(int i, View.OnClickListener onClickListener) {
        ImageView imageView = this.i;
        if (imageView != null) {
            imageView.setVisibility(0);
            this.i.setImageResource(i);
            this.i.setOnClickListener(onClickListener);
        }
    }

    public void a(AttributeSet attributeSet) {
        View inflate = LayoutInflater.from(this.b).inflate(R.layout.view_top_title_notrans, this);
        this.a = inflate;
        this.c = (LinearLayout) inflate.findViewById(R.id.ll_background);
        ShapeTextView shapeTextView = (ShapeTextView) this.a.findViewById(R.id.ctt_left);
        this.d = shapeTextView;
        shapeTextView.setOnClickListener(this);
        ShapeTextView shapeTextView2 = (ShapeTextView) this.a.findViewById(R.id.ctt_center);
        this.e = shapeTextView2;
        shapeTextView2.setOnClickListener(this);
        this.p = (TextView) this.a.findViewById(R.id.ctt_center_below);
        ShapeTextView shapeTextView3 = (ShapeTextView) this.a.findViewById(R.id.ctt_right);
        this.f = shapeTextView3;
        shapeTextView3.setOnClickListener(this);
        ImageView imageView = (ImageView) this.a.findViewById(R.id.ctt_left_img);
        this.g = imageView;
        imageView.setOnClickListener(this);
        ImageView imageView2 = (ImageView) this.a.findViewById(R.id.ctt_right_img);
        this.h = imageView2;
        imageView2.setOnClickListener(this);
        this.i = (ImageView) this.a.findViewById(R.id.ctt_right_img_doubule);
        this.j = (ImageView) this.a.findViewById(R.id.iv_ctt_right_img_dou_red);
        this.n = (TextView) this.a.findViewById(R.id.tv_title_divider);
        this.o = (TextView) this.a.findViewById(R.id.tv_others_dot);
        this.q = (RelativeLayout) this.a.findViewById(R.id.rl_content);
        if (attributeSet != null) {
            TypedArray obtainAttributes = getResources().obtainAttributes(attributeSet, R.styleable.CommonTopTitleNoTrans);
            int resourceId = obtainAttributes.getResourceId(R.styleable.CommonTopTitleNoTrans_left_text, -1);
            if (resourceId > 0) {
                this.d.setText(resourceId);
                this.d.setVisibility(0);
            }
            int dimensionPixelSize = obtainAttributes.getDimensionPixelSize(R.styleable.CommonTopTitleNoTrans_left_text_size, -1);
            if (dimensionPixelSize != -1) {
                this.d.setTextSize(DensityUtils.c(this.b, dimensionPixelSize));
            }
            int resourceId2 = obtainAttributes.getResourceId(R.styleable.CommonTopTitleNoTrans_right_text, -1);
            if (resourceId2 > 0) {
                this.f.setText(resourceId2);
                this.f.setVisibility(0);
            }
            int dimensionPixelSize2 = obtainAttributes.getDimensionPixelSize(R.styleable.CommonTopTitleNoTrans_right_text_size, -1);
            if (dimensionPixelSize2 != -1) {
                this.f.setTextSize(DensityUtils.c(this.b, dimensionPixelSize2));
            }
            int resourceId3 = obtainAttributes.getResourceId(R.styleable.CommonTopTitleNoTrans_right_text_color, -1);
            if (resourceId3 > 0) {
                this.f.setTextColor(BluedSkinUtils.a(getContext(), resourceId3));
            }
            int resourceId4 = obtainAttributes.getResourceId(R.styleable.CommonTopTitleNoTrans_center_text, -1);
            if (resourceId4 > 0) {
                this.e.setText(resourceId4);
                this.e.setVisibility(0);
            }
            int dimensionPixelSize3 = obtainAttributes.getDimensionPixelSize(R.styleable.CommonTopTitleNoTrans_center_text_size, -1);
            if (dimensionPixelSize3 != -1) {
                this.e.setTextSize(DensityUtils.c(this.b, dimensionPixelSize3));
            }
            int resourceId5 = obtainAttributes.getResourceId(R.styleable.CommonTopTitleNoTrans_left_image, -1);
            if (resourceId5 > 0) {
                this.d.setVisibility(8);
                this.g.setVisibility(0);
                this.g.setImageResource(resourceId5);
            }
            int resourceId6 = obtainAttributes.getResourceId(R.styleable.CommonTopTitleNoTrans_right_image, -1);
            if (resourceId6 > 0) {
                this.f.setVisibility(8);
                this.h.setVisibility(0);
                this.h.setImageResource(resourceId6);
            }
            boolean z = obtainAttributes.getBoolean(R.styleable.CommonTopTitleNoTrans_hide_left, false);
            boolean z2 = obtainAttributes.getBoolean(R.styleable.CommonTopTitleNoTrans_hide_right, false);
            boolean z3 = obtainAttributes.getBoolean(R.styleable.CommonTopTitleNoTrans_hide_center, false);
            boolean z4 = obtainAttributes.getBoolean(R.styleable.CommonTopTitleNoTrans_hide_btm_line, false);
            boolean z5 = obtainAttributes.getBoolean(R.styleable.CommonTopTitleNoTrans_bg_transparent, false);
            obtainAttributes.recycle();
            if (z) {
                this.d.setVisibility(8);
                this.g.setVisibility(8);
            }
            if (z2) {
                this.f.setVisibility(8);
                this.h.setVisibility(8);
            }
            if (z3) {
                this.e.setVisibility(8);
            }
            if (z4) {
                this.n.setVisibility(8);
            } else {
                this.n.setVisibility(0);
            }
            if (z5) {
                this.c.setBackgroundColor(getResources().getColor(R.color.transparent));
            }
        }
        this.e.setTextColor(BluedSkinUtils.a(this.b, R.color.syc_h));
    }

    public void b() {
        this.f.setVisibility(0);
        this.h.setVisibility(8);
    }

    public void c() {
        this.f.setVisibility(8);
        this.h.setVisibility(0);
    }

    public void d() {
        this.d.setVisibility(8);
        this.g.setVisibility(8);
    }

    public void e() {
        this.d.setVisibility(8);
        this.g.setVisibility(0);
    }

    public void f() {
        this.n.setVisibility(8);
    }

    @Override // android.view.View
    public Drawable getBackground() {
        return this.c.getBackground();
    }

    public TextView getCenterBelowTextView() {
        return this.p;
    }

    public TextView getCenterTextView() {
        return this.e;
    }

    public RelativeLayout getContent() {
        return this.q;
    }

    public View getDivider() {
        return this.n;
    }

    public ImageView getLeftImg() {
        return this.g;
    }

    public ShapeTextView getLeftTextView() {
        return this.d;
    }

    public ImageView getRightImg() {
        return this.h;
    }

    public ShapeTextView getRightTextView() {
        return this.f;
    }

    public LinearLayout getTitleBackground() {
        return this.c;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        int id = view.getId();
        if (id == R.id.ctt_left) {
            View.OnClickListener onClickListener = this.k;
            if (onClickListener != null) {
                onClickListener.onClick(this.d);
            }
        } else if (id == R.id.ctt_left_img) {
            onClick(this.d);
        } else if (id == R.id.ctt_center) {
            View.OnClickListener onClickListener2 = this.m;
            if (onClickListener2 != null) {
                onClickListener2.onClick(this.e);
            }
        } else if (id != R.id.ctt_right) {
            if (id == R.id.ctt_right_img) {
                onClick(this.f);
            }
        } else {
            View.OnClickListener onClickListener3 = this.l;
            if (onClickListener3 != null) {
                onClickListener3.onClick(this.f);
            }
        }
    }

    public void setCenterClickListener(View.OnClickListener onClickListener) {
        this.m = onClickListener;
    }

    public void setCenterText(int i) {
        a((TextView) this.e, (ImageView) null, this.b.getString(i));
    }

    public void setCenterText(CharSequence charSequence) {
        this.e.setText(charSequence);
    }

    public void setCenterText(String str) {
        a((TextView) this.e, (ImageView) null, str);
    }

    public void setCenterTextColor(int i) {
        ShapeHelper.a((ShapeHelper.ShapeView) this.e, i);
    }

    public void setLeftClickListener(View.OnClickListener onClickListener) {
        this.k = onClickListener;
    }

    public void setLeftImg(int i) {
        a(this.g, (TextView) this.d, i);
    }

    public void setLeftImgDrawable(Drawable drawable) {
        this.g.setImageDrawable(drawable);
    }

    public void setLeftText(int i) {
        a((TextView) this.d, this.g, this.b.getString(i));
    }

    public void setLeftText(String str) {
        a((TextView) this.d, this.g, str);
    }

    public void setLeftTextColor(int i) {
        ShapeHelper.a((ShapeHelper.ShapeView) this.d, i);
    }

    public void setRightBtnEnable(boolean z) {
        this.h.setEnabled(z);
        this.f.setEnabled(z);
        if (z) {
            this.h.setAlpha(1.0f);
            this.f.setAlpha(1.0f);
            return;
        }
        this.h.setAlpha(0.3f);
        this.f.setAlpha(0.3f);
    }

    public void setRightClickListener(View.OnClickListener onClickListener) {
        this.l = onClickListener;
    }

    public void setRightImg(int i) {
        a(this.h, (TextView) this.f, i);
    }

    public void setRightImgDrawable(Drawable drawable) {
        this.h.setImageDrawable(drawable);
    }

    public void setRightText(int i) {
        a((TextView) this.f, this.h, this.b.getString(i));
    }

    public void setRightText(String str) {
        a((TextView) this.f, this.h, str);
    }

    public void setRightTextColor(int i) {
        ShapeHelper.a((ShapeHelper.ShapeView) this.f, i);
    }

    public void setRightTextSize(int i) {
        this.f.setTextSize(i);
    }

    public void setTitleBackgroundDrawable(int i) {
        this.c.setBackgroundColor(BluedSkinUtils.a(getContext(), i));
    }
}
