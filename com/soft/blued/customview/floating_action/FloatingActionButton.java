package com.soft.blued.customview.floating_action;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import com.soft.blued.R;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/customview/floating_action/FloatingActionButton.class */
public class FloatingActionButton extends AppCompatImageView implements View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    private Context f28580a;
    int b;

    /* renamed from: c  reason: collision with root package name */
    int f28581c;
    int d;
    String e;
    String f;
    boolean g;
    private Animation h;
    private int i;

    public FloatingActionButton(Context context) {
        this(context, null);
    }

    public FloatingActionButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet);
    }

    public FloatingActionButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context, attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a(int i) {
        return getResources().getColor(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Context context, AttributeSet attributeSet) {
        this.f28580a = context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.FloatingActionButton, 0, 0);
        this.b = obtainStyledAttributes.getColor(9, a(17170451));
        this.f28581c = obtainStyledAttributes.getColor(10, a(17170450));
        this.d = obtainStyledAttributes.getColor(8, a(17170432));
        this.i = obtainStyledAttributes.getResourceId(11, 0);
        this.e = obtainStyledAttributes.getString(14);
        this.g = obtainStyledAttributes.getBoolean(13, true);
        obtainStyledAttributes.recycle();
        setOnTouchListener(this);
    }

    public String getColor() {
        return this.f;
    }

    TextView getLabelView() {
        return (TextView) getTag(R.id.fab_label);
    }

    public String getTitle() {
        return this.e;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.f28580a, R.anim.button_scale_down);
            this.h = loadAnimation;
            startAnimation(loadAnimation);
        }
        if (motionEvent.getAction() == 1) {
            Animation loadAnimation2 = AnimationUtils.loadAnimation(this.f28580a, R.anim.button_scale_up);
            this.h = loadAnimation2;
            startAnimation(loadAnimation2);
            return false;
        }
        return false;
    }

    public void setIcon(int i) {
        if (this.i != i) {
            this.i = i;
        }
    }

    public void setLabelColor(String str) {
        this.f = str;
        TextView labelView = getLabelView();
        if (labelView != null) {
            labelView.setTextColor(Color.parseColor(str));
        }
    }

    public void setTitle(String str) {
        this.e = str;
        TextView labelView = getLabelView();
        if (labelView != null) {
            labelView.setText(str);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void setVisibility(int i) {
        TextView labelView = getLabelView();
        if (labelView != null) {
            labelView.setVisibility(i);
        }
        super.setVisibility(i);
    }
}
