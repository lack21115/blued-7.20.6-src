package com.blued.android.module.shortvideo.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.blued.android.module.shortvideo.R;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/shortvideo/view/FocusIndicator.class */
public class FocusIndicator extends View {

    /* renamed from: a  reason: collision with root package name */
    private int f15897a;
    private Runnable b;

    /* renamed from: c  reason: collision with root package name */
    private Runnable f15898c;

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/shortvideo/view/FocusIndicator$Disappear.class */
    class Disappear implements Runnable {
        private Disappear() {
        }

        @Override // java.lang.Runnable
        public void run() {
            FocusIndicator.this.setBackgroundDrawable(null);
            FocusIndicator.this.f15897a = 0;
        }
    }

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/shortvideo/view/FocusIndicator$EndAction.class */
    class EndAction implements Runnable {
        private EndAction() {
        }

        @Override // java.lang.Runnable
        public void run() {
            FocusIndicator focusIndicator = FocusIndicator.this;
            focusIndicator.postDelayed(focusIndicator.b, 200L);
        }
    }

    public FocusIndicator(Context context) {
        super(context);
        this.b = new Disappear();
        this.f15898c = new EndAction();
    }

    public FocusIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = new Disappear();
        this.f15898c = new EndAction();
    }

    public FocusIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = new Disappear();
        this.f15898c = new EndAction();
    }

    public void a() {
        if (this.f15897a == 0) {
            setBackgroundResource(R.drawable.ic_focus_focusing);
            animate().withLayer().setDuration(800L).scaleX(1.5f).scaleY(1.5f);
            this.f15897a = 1;
        }
    }

    public void b() {
        if (this.f15897a == 1) {
            setBackgroundResource(R.drawable.ic_focus_focused);
            animate().withLayer().setDuration(200L).scaleX(1.0f).scaleY(1.0f).withEndAction(this.f15898c);
            this.f15897a = 2;
        }
    }

    public void c() {
        if (this.f15897a == 1) {
            setBackgroundResource(R.drawable.ic_focus_failed);
            animate().withLayer().setDuration(200L).scaleX(1.0f).scaleY(1.0f).withEndAction(this.f15898c);
            this.f15897a = 2;
        }
    }

    public void d() {
        animate().cancel();
        removeCallbacks(this.b);
        this.b.run();
        setScaleX(1.0f);
        setScaleY(1.0f);
    }
}
