package com.blued.android.framework.view.badgeview;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import com.blued.android.framework.R;
import com.blued.android.framework.view.badgeview.Badge;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/view/badgeview/QBadgeContainer.class */
public class QBadgeContainer extends RelativeLayout implements Badge {
    public QBadgeView a;
    private Context b;
    private int c;
    private float d;
    private float e;
    private float f;
    private int g;
    private int h;
    private boolean i;
    private float j;
    private int k;

    public QBadgeContainer(Context context) {
        this(context, null);
    }

    public QBadgeContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QBadgeContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.c = 0;
        this.b = context;
        a();
        Resources resources = getResources();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Badge);
        this.c = obtainStyledAttributes.getInt(R.styleable.Badge_badge_num, 0);
        this.g = obtainStyledAttributes.getColor(R.styleable.Badge_badge_backgroundColor, -65536);
        this.h = obtainStyledAttributes.getColor(R.styleable.Badge_badge_textColor, -1);
        float dimension = resources.getDimension(R.dimen.default_off_x);
        float dimension2 = resources.getDimension(R.dimen.default_off_y);
        this.d = obtainStyledAttributes.getDimension(R.styleable.Badge_badge_offx, dimension);
        this.e = obtainStyledAttributes.getDimension(R.styleable.Badge_badge_offy, dimension2);
        this.f = obtainStyledAttributes.getDimension(R.styleable.Badge_badge_padding, resources.getDimension(R.dimen.default_padding));
        this.i = obtainStyledAttributes.getBoolean(R.styleable.Badge_badge_ext, false);
        this.j = obtainStyledAttributes.getDimension(R.styleable.Badge_badge_textSize, resources.getDimension(R.dimen.default_text_size));
        this.k = obtainStyledAttributes.getInt(R.styleable.Badge_badge_gravity, 1);
    }

    private void a() {
        this.a = new QBadgeView(getContext());
    }

    private void b() {
        b(this.g);
        c(this.h);
        a(this.d, this.e, false);
        b(this.f, false);
        a(this.i);
        a(this.j, false);
        int i = this.k;
        if (i == 0) {
            d(8388659);
        } else if (2 == i) {
            d(8388691);
        } else if (3 == i) {
            d(8388693);
        } else if (4 == i) {
            d(49);
        } else if (5 == i) {
            d(81);
        } else if (6 == i) {
            d(8388627);
        } else if (7 == i) {
            d(8388629);
        } else {
            d(8388661);
        }
    }

    public Badge a(float f, float f2, boolean z) {
        return this.a.a(f, f2, z);
    }

    public Badge a(float f, boolean z) {
        return this.a.a(f, z);
    }

    public Badge a(int i) {
        return this.a.a(i);
    }

    public Badge a(int i, float f, boolean z) {
        return this.a.a(i, f, z);
    }

    public Badge a(Badge.OnDragStateChangedListener onDragStateChangedListener) {
        return this.a.a(onDragStateChangedListener);
    }

    public Badge a(String str) {
        return this.a.a(str);
    }

    public Badge a(boolean z) {
        return this.a.c(z);
    }

    public void a(View view) {
        this.a.a(view);
        b();
    }

    public Badge b(float f, boolean z) {
        return this.a.b(f, z);
    }

    public Badge b(int i) {
        return this.a.b(i);
    }

    public void b(boolean z) {
        this.a.b(z);
    }

    public Badge c(int i) {
        return this.a.c(i);
    }

    public Badge d(int i) {
        return this.a.d(i);
    }

    public Drawable getBadgeBackground() {
        return this.a.getBadgeBackground();
    }

    public int getBadgeBackgroundColor() {
        return this.a.getBadgeBackgroundColor();
    }

    public int getBadgeGravity() {
        return this.a.getBadgeGravity();
    }

    public int getBadgeNumber() {
        return this.a.getBadgeNumber();
    }

    public String getBadgeText() {
        return this.a.getBadgeText();
    }

    public int getBadgeTextColor() {
        return this.a.getBadgeTextColor();
    }

    public View getBadgeView() {
        return this.a;
    }

    public int getBageVisible() {
        return this.a.getVisibility();
    }

    public PointF getDragCenter() {
        return this.a.getDragCenter();
    }

    public View getTargetView() {
        return this.a.getTargetView();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public void setBageVisible(int i) {
        this.a.setVisibility(i);
    }
}
