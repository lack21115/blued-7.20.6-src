package com.soft.blued.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.soft.blued.R;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/customview/LabeledTextView.class */
public class LabeledTextView extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    private ImageView f28437a;
    private ImageView b;

    /* renamed from: c  reason: collision with root package name */
    private ImageView f28438c;
    private View d;
    private TextView e;
    private View f;
    private View g;
    private String h;
    private int i;
    private int j;
    private int k;
    private int l;
    private int m;
    private int n;
    private boolean o;
    private boolean p;
    private boolean q;
    private boolean r;

    public LabeledTextView(Context context) {
        super(context);
        this.o = true;
        a(context, null);
    }

    public LabeledTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.o = true;
        a(context, attributeSet);
    }

    public LabeledTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.o = true;
        a(context, attributeSet);
    }

    private void a() {
        int i = this.i;
        if (i != 0) {
            a(i, this.k, this.l);
        } else {
            setLeftIconShow(false);
        }
        int i2 = this.j;
        if (i2 != 0) {
            b(i2, this.m, this.n);
        } else {
            setTvRightImgShow(false);
        }
        setRightIconShow(this.o);
        setTopLineShow(this.q);
        setBottomLineShow(this.r);
    }

    protected View a(Context context) {
        return View.inflate(context, R.layout.labeled_text_item, this);
    }

    public void a(int i, int i2, int i3) {
        this.f28437a.setImageResource(i);
        setLeftIconShow(true);
        if (i2 <= 0 || i3 <= 0) {
            return;
        }
        this.f28437a.setLayoutParams(new LinearLayout.LayoutParams(i2, i3));
    }

    public void a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CommonLabeledTextView);
        this.h = obtainStyledAttributes.getString(5);
        this.i = obtainStyledAttributes.getResourceId(1, 0);
        this.k = obtainStyledAttributes.getResourceId(3, 0);
        this.l = obtainStyledAttributes.getResourceId(2, 0);
        this.j = obtainStyledAttributes.getResourceId(7, 0);
        this.p = obtainStyledAttributes.getBoolean(6, false);
        this.m = obtainStyledAttributes.getResourceId(9, 0);
        this.n = obtainStyledAttributes.getResourceId(8, 0);
        this.o = obtainStyledAttributes.getBoolean(4, true);
        this.q = obtainStyledAttributes.getBoolean(10, false);
        this.r = obtainStyledAttributes.getBoolean(0, false);
        obtainStyledAttributes.recycle();
        View a2 = a(context);
        this.f28437a = (ImageView) a2.findViewById(R.id.icon_left);
        this.d = a2.findViewById(2131365270);
        this.b = (ImageView) a2.findViewById(R.id.tv_right_img);
        this.f28438c = (ImageView) a2.findViewById(R.id.icon_right);
        this.e = (TextView) a2.findViewById(R.id.tv_label);
        setTextTitle(this.h);
        this.f = a2.findViewById(2131370746);
        this.g = a2.findViewById(2131362488);
        a(Boolean.valueOf(this.p));
        a();
    }

    public void a(Boolean bool) {
        View view = this.d;
        if (view != null) {
            view.setVisibility(bool.booleanValue() ? 0 : 8);
        }
    }

    public void b(int i, int i2, int i3) {
        this.b.setImageResource(i);
        setTvRightImgShow(true);
        if (i2 <= 0 || i3 <= 0) {
            return;
        }
        this.b.setLayoutParams(new LinearLayout.LayoutParams(i2, i3));
    }

    public void setBottomLineShow(boolean z) {
        this.g.setVisibility(z ? 0 : 8);
    }

    public void setLeftIcon(int i) {
        a(i, 0, 0);
    }

    public void setLeftIconShow(boolean z) {
        this.f28437a.setVisibility(z ? 0 : 8);
    }

    public void setRightIconShow(boolean z) {
        this.f28438c.setVisibility(z ? 0 : 8);
    }

    public void setTextTitle(String str) {
        this.e.setText(str);
    }

    public void setTopLineShow(boolean z) {
        this.f.setVisibility(z ? 0 : 8);
    }

    public void setTvRightImg(int i) {
        b(i, 0, 0);
    }

    public void setTvRightImgShow(boolean z) {
        this.b.setVisibility(z ? 0 : 8);
    }
}
