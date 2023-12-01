package com.blued.android.module.live_china.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import com.blued.android.module.live_china.same.Logger;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/BadgeView.class */
public class BadgeView extends AppCompatTextView {

    /* renamed from: a  reason: collision with root package name */
    private boolean f14213a;

    public BadgeView(Context context) {
        this(context, null);
    }

    public BadgeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842884);
    }

    public BadgeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f14213a = true;
        b();
    }

    private int a(float f) {
        return (int) ((f * getContext().getResources().getDisplayMetrics().density) + 0.5f);
    }

    private void b() {
        if (!(getLayoutParams() instanceof FrameLayout.LayoutParams)) {
            setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 53));
        }
        setPadding(a(5.0f), a(0.0f), a(5.0f), a(1.0f));
        a(9, Color.parseColor("#f66161"));
        setGravity(17);
        setHideOnNull(true);
        setBadgeCount(0);
    }

    public void a(int i, int i2) {
        float a2 = a(i);
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(new float[]{a2, a2, a2, a2, a2, a2, a2, a2}, null, null));
        shapeDrawable.getPaint().setColor(i2);
        setBackgroundDrawable(shapeDrawable);
    }

    public void a(int i, int i2, int i3, int i4) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) getLayoutParams();
        layoutParams.leftMargin = a(i);
        layoutParams.topMargin = a(i2);
        layoutParams.rightMargin = a(i3);
        layoutParams.bottomMargin = a(i4);
        setLayoutParams(layoutParams);
    }

    public boolean a() {
        return this.f14213a;
    }

    public Integer getBadgeCount() {
        if (getText() == null) {
            return null;
        }
        try {
            return Integer.valueOf(Integer.parseInt(getText().toString()));
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public int getBadgeGravity() {
        return ((FrameLayout.LayoutParams) getLayoutParams()).gravity;
    }

    public int[] getBadgeMargin() {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) getLayoutParams();
        return new int[]{layoutParams.leftMargin, layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin};
    }

    public void setBadgeCount(int i) {
        setText(String.valueOf(i));
    }

    public void setBadgeCount(String str) {
        setText(str);
    }

    public void setBadgeGravity(int i) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) getLayoutParams();
        layoutParams.gravity = i;
        setLayoutParams(layoutParams);
    }

    public void setBadgeMargin(int i) {
        a(i, i, i, i);
    }

    public void setHideOnNull(boolean z) {
        this.f14213a = z;
        setText(getText());
    }

    public void setTargetView(View view) {
        if (getParent() != null) {
            ((ViewGroup) getParent()).removeView(this);
        }
        if (view == null) {
            return;
        }
        if (view.getParent() instanceof FrameLayout) {
            ((FrameLayout) view.getParent()).addView(this);
        } else if (!(view.getParent() instanceof ViewGroup)) {
            if (view.getParent() == null) {
                Logger.d(getClass().getSimpleName(), "ParentView is needed");
            }
        } else {
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            int indexOfChild = viewGroup.indexOfChild(view);
            viewGroup.removeView(view);
            FrameLayout frameLayout = new FrameLayout(getContext());
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            frameLayout.setLayoutParams(layoutParams);
            view.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            viewGroup.addView(frameLayout, indexOfChild, layoutParams);
            frameLayout.addView(view);
            frameLayout.addView(this);
        }
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        if (a() && (charSequence == null || charSequence.toString().equalsIgnoreCase("0"))) {
            setVisibility(8);
        } else {
            setVisibility(0);
        }
        super.setText(charSequence, bufferType);
    }
}
