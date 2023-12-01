package com.blued.android.module.shortvideo.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.blued.android.module.shortvideo.R;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/shortvideo/view/FocusIndicator.class */
public class FocusIndicator extends View {
    private int a;
    private Runnable b;
    private Runnable c;

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/shortvideo/view/FocusIndicator$Disappear.class */
    class Disappear implements Runnable {
        private Disappear() {
        }

        @Override // java.lang.Runnable
        public void run() {
            FocusIndicator.this.setBackgroundDrawable(null);
            FocusIndicator.this.a = 0;
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
        this.c = new EndAction();
    }

    public FocusIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = new Disappear();
        this.c = new EndAction();
    }

    public FocusIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = new Disappear();
        this.c = new EndAction();
    }

    public void a() {
        if (this.a == 0) {
            setBackgroundResource(R.drawable.ic_focus_focusing);
            animate().withLayer().setDuration(800L).scaleX(1.5f).scaleY(1.5f);
            this.a = 1;
        }
    }

    public void b() {
        if (this.a == 1) {
            setBackgroundResource(R.drawable.ic_focus_focused);
            animate().withLayer().setDuration(200L).scaleX(1.0f).scaleY(1.0f).withEndAction(this.c);
            this.a = 2;
        }
    }

    public void c() {
        if (this.a == 1) {
            setBackgroundResource(R.drawable.ic_focus_failed);
            animate().withLayer().setDuration(200L).scaleX(1.0f).scaleY(1.0f).withEndAction(this.c);
            this.a = 2;
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
