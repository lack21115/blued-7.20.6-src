package com.blued.android.module.shortvideo.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.blued.android.module.shortvideo.contract.ICoverSlideListener;
import com.blued.android.module.shortvideo.utils.StvLogUtils;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/shortvideo/widget/CoverSlideView.class */
public class CoverSlideView extends FrameLayout {
    private static final String i = CoverSlideView.class.getSimpleName();
    protected int a;
    int b;
    int c;
    int d;
    int e;
    int f;
    int g;
    int h;
    private ICoverSlideListener j;

    public CoverSlideView(Context context) {
        this(context, null);
    }

    public CoverSlideView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CoverSlideView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        post(new Runnable() { // from class: com.blued.android.module.shortvideo.widget.CoverSlideView.1
            @Override // java.lang.Runnable
            public void run() {
                CoverSlideView coverSlideView = CoverSlideView.this;
                coverSlideView.h = coverSlideView.getMeasuredWidth();
                CoverSlideView coverSlideView2 = CoverSlideView.this;
                coverSlideView2.f = coverSlideView2.getTop();
                CoverSlideView coverSlideView3 = CoverSlideView.this;
                coverSlideView3.g = coverSlideView3.getBottom();
            }
        });
    }

    public void a() {
    }

    public void a(int i2, ICoverSlideListener iCoverSlideListener) {
        this.a = i2;
        this.j = iCoverSlideListener;
    }

    public void b() {
    }

    public void c() {
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int rawX = (int) motionEvent.getRawX();
        int action = motionEvent.getAction();
        if (action == 0) {
            if (rawX <= this.a) {
                this.b = rawX;
                this.c = (int) motionEvent.getX();
                StvLogUtils.a(i + " cover slidev down rawx:" + rawX + " | x:" + this.c, new Object[0]);
                return true;
            }
            return false;
        } else if (action == 1) {
            ICoverSlideListener iCoverSlideListener = this.j;
            if (iCoverSlideListener != null && iCoverSlideListener.getPresenter() != null) {
                StvLogUtils.a(i + "cover action_up left:" + this.d + " | currentCoverTime:" + this.j.getPresenter().v(), new Object[0]);
            }
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) getLayoutParams();
            layoutParams.leftMargin = getLeft();
            setLayoutParams(layoutParams);
            return true;
        } else if (action != 2) {
            return true;
        } else {
            if (this.h == 0) {
                this.h = getMeasuredWidth();
            }
            if (this.f == 0) {
                this.f = getTop();
            }
            if (this.g == 0) {
                this.g = getBottom();
            }
            int i2 = rawX - this.c;
            this.d = i2;
            if (i2 < 0) {
                this.d = 0;
            }
            int i3 = this.d;
            int i4 = this.h;
            int i5 = i3 + i4;
            this.e = i5;
            int i6 = this.a;
            if (i5 >= i6) {
                this.e = i6;
                this.d = i6 - i4;
            }
            ICoverSlideListener iCoverSlideListener2 = this.j;
            if (iCoverSlideListener2 != null && iCoverSlideListener2.getPresenter() != null) {
                this.j.getPresenter().c(this.d + (this.h / 2));
                this.j.getPresenter().g(this.d);
                ICoverSlideListener iCoverSlideListener3 = this.j;
                if (iCoverSlideListener3 != null) {
                    iCoverSlideListener3.b((int) iCoverSlideListener3.getPresenter().v());
                }
            }
            layout(this.d, this.f, this.e, this.g);
            return true;
        }
    }
}
