package com.blued.android.module.common.widget.pop;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.widget.PopupWindow;
import androidx.core.widget.PopupWindowCompat;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/widget/pop/BluedPopupWindow.class */
public class BluedPopupWindow extends PopupWindow {
    private int a;
    private int b;
    private float c;
    private Context d;
    private View e;
    private boolean f;
    private int g;
    private boolean h;
    private View i;
    private int j;
    private int k;
    private int l;
    private int m;
    private final ViewTreeObserver.OnGlobalLayoutListener n;

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/widget/pop/BluedPopupWindow$Builder.class */
    public static class Builder {
        private BluedPopupWindow a;

        private Builder(Activity activity, View view) {
            BluedPopupWindow bluedPopupWindow = new BluedPopupWindow(activity);
            this.a = bluedPopupWindow;
            bluedPopupWindow.d = activity;
            this.a.e = view;
        }

        public static Builder a(Activity activity, View view) {
            return new Builder(activity, view);
        }

        public Builder a(float f) {
            this.a.c = f;
            return this;
        }

        public Builder a(int i, int i2) {
            this.a.a = i;
            this.a.b = i2;
            return this;
        }

        public Builder a(boolean z) {
            this.a.f = z;
            return this;
        }

        public BluedPopupWindow a() {
            this.a.a();
            return this.a;
        }
    }

    public BluedPopupWindow(Context context) {
        this(context, null);
    }

    public BluedPopupWindow(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BluedPopupWindow(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = -2;
        this.b = -2;
        this.c = 1.0f;
        this.f = true;
        this.g = -1;
        this.h = true;
        this.j = 2;
        this.k = 1;
        this.n = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.blued.android.module.common.widget.pop.BluedPopupWindow.3
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                BluedPopupWindow bluedPopupWindow = BluedPopupWindow.this;
                bluedPopupWindow.a = bluedPopupWindow.getContentView().getWidth();
                BluedPopupWindow bluedPopupWindow2 = BluedPopupWindow.this;
                bluedPopupWindow2.b = bluedPopupWindow2.getContentView().getHeight();
                if (BluedPopupWindow.this.h) {
                    BluedPopupWindow.this.b();
                    return;
                }
                BluedPopupWindow bluedPopupWindow3 = BluedPopupWindow.this;
                bluedPopupWindow3.a(bluedPopupWindow3.a, BluedPopupWindow.this.b, BluedPopupWindow.this.i, BluedPopupWindow.this.j, BluedPopupWindow.this.k, BluedPopupWindow.this.l, BluedPopupWindow.this.m);
                BluedPopupWindow.this.b();
            }
        };
        this.d = context;
    }

    private static int a(int i) {
        return View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i), b(i));
    }

    private int a(View view, int i, int i2, int i3) {
        int height;
        if (i != 0) {
            if (i == 1) {
                i2 += view.getHeight();
            } else if (i == 3) {
                height = view.getHeight();
            } else if (i != 4) {
                return i3;
            }
            return i3 - i2;
        }
        height = (view.getHeight() / 2) + (i2 / 2);
        return i3 - height;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(float f) {
        Context context = this.d;
        if (context != null && (context instanceof Activity)) {
            Window window = ((Activity) context).getWindow();
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.alpha = f;
            window.setAttributes(attributes);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2, View view, int i3, int i4, int i5, int i6) {
        update(view, b(view, i4, i, i5), a(view, i3, i2, i6), i, i2);
    }

    private void a(View view) {
        view.getViewTreeObserver().addOnGlobalLayoutListener(this.n);
    }

    private void a(boolean z) {
        if (z) {
            setOutsideTouchable(true);
            setBackgroundDrawable(null);
            return;
        }
        setFocusable(true);
        setOutsideTouchable(false);
        setBackgroundDrawable(null);
        getContentView().setFocusable(true);
        getContentView().setFocusableInTouchMode(true);
        getContentView().setOnKeyListener(new View.OnKeyListener() { // from class: com.blued.android.module.common.widget.pop.BluedPopupWindow.1
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (i == 4) {
                    BluedPopupWindow.this.dismiss();
                    return true;
                }
                return false;
            }
        });
        setTouchInterceptor(new View.OnTouchListener() { // from class: com.blued.android.module.common.widget.pop.BluedPopupWindow.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                return (motionEvent.getAction() == 0 && (x < 0 || x >= BluedPopupWindow.this.a || y < 0 || y >= BluedPopupWindow.this.b)) || motionEvent.getAction() == 4;
            }
        });
    }

    private static int b(int i) {
        return i != -2 ? 1073741824 : 0;
    }

    private int b(View view, int i, int i2, int i3) {
        int width;
        if (i != 0) {
            int i4 = i2;
            if (i != 1) {
                if (i == 2) {
                    width = view.getWidth();
                } else if (i != 4) {
                    return i3;
                } else {
                    i4 = i2 - view.getWidth();
                }
            }
            return i3 - i4;
        }
        width = (view.getWidth() / 2) - (i2 / 2);
        return i3 + width;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (getContentView() != null) {
            if (Build.VERSION.SDK_INT >= 16) {
                getContentView().getViewTreeObserver().removeOnGlobalLayoutListener(this.n);
            } else {
                getContentView().getViewTreeObserver().removeGlobalOnLayoutListener(this.n);
            }
        }
    }

    private void c() {
        float f = this.c;
        if (f >= 1.0f) {
            return;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, f);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.blued.android.module.common.widget.pop.BluedPopupWindow.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                BluedPopupWindow.this.a(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        ofFloat.setDuration(360L);
        ofFloat.start();
    }

    private void d() {
        float f = this.c;
        if (f >= 1.0f) {
            return;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(f, 1.0f);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.blued.android.module.common.widget.pop.BluedPopupWindow.5
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                BluedPopupWindow.this.a(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        ofFloat.setDuration(360L);
        ofFloat.start();
    }

    public void a() {
        setContentView(this.e);
        setHeight(this.b);
        setWidth(this.a);
        a(this.f);
        int i = this.g;
        if (i != -1) {
            setAnimationStyle(i);
        }
    }

    public void a(View view, int i, int i2, int i3, int i4) {
        a(view, i, i2, i3, i4, true);
    }

    public void a(View view, int i, int i2, int i3, int i4, boolean z) {
        this.h = false;
        this.i = view;
        this.l = i3;
        this.m = i4;
        this.j = i;
        this.k = i2;
        View contentView = getContentView();
        if (contentView == null) {
            return;
        }
        c();
        a(contentView);
        setClippingEnabled(z);
        try {
            contentView.measure(a(getWidth()), a(getHeight()));
            int measuredWidth = contentView.getMeasuredWidth();
            int measuredHeight = contentView.getMeasuredHeight();
            int i5 = i3;
            int i6 = i4;
            if (!z) {
                int[] iArr = new int[2];
                view.getLocationInWindow(iArr);
                i5 = i3 + iArr[0];
                i6 = i4 + iArr[1] + view.getHeight();
            }
            int a = a(view, i, measuredHeight, i6);
            int b = b(view, i2, measuredWidth, i5);
            if (z) {
                PopupWindowCompat.showAsDropDown(this, view, b, a, 0);
            } else {
                showAtLocation(view, 0, b, a);
            }
        } catch (Exception e) {
        }
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        super.dismiss();
        d();
        b();
    }

    @Override // android.widget.PopupWindow
    public void showAtLocation(View view, int i, int i2, int i3) {
        this.h = true;
        this.i = view;
        this.l = i2;
        this.m = i3;
        a(getContentView());
        super.showAtLocation(view, i, i2, i3);
    }
}
