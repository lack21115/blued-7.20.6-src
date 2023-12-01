package com.blued.android.module.common.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.blued.android.core.AppInfo;
import com.blued.android.module.common.R;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/view/TranslationAnimHintView.class */
public class TranslationAnimHintView extends FrameLayout {
    private List<HintInfo> a;
    private int b;

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/view/TranslationAnimHintView$HintInfo.class */
    public static class HintInfo {
        public int a = 11;
        public String b;
        public View.OnClickListener c;
        public View.OnClickListener d;
        public View e;
        public boolean f;
        public int g;
        public Runnable h;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.a == ((HintInfo) obj).a;
        }

        public int hashCode() {
            return this.a;
        }

        public void update(HintInfo hintInfo) {
            int i;
            this.f = hintInfo.f;
            this.b = hintInfo.b;
            View.OnClickListener onClickListener = hintInfo.c;
            if (onClickListener != null) {
                this.c = onClickListener;
            }
            View.OnClickListener onClickListener2 = hintInfo.d;
            if (onClickListener2 != null) {
                this.d = onClickListener2;
            }
            if (!this.f || (i = hintInfo.g) == 0) {
                return;
            }
            this.g = i;
        }
    }

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/view/TranslationAnimHintView$TYPE_COMMON.class */
    public static class TYPE_COMMON {
    }

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/view/TranslationAnimHintView$TYPE_GROUP_MSG.class */
    public static class TYPE_GROUP_MSG {
    }

    public TranslationAnimHintView(Context context) {
        this(context, null);
    }

    public TranslationAnimHintView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TranslationAnimHintView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = new ArrayList();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.TranslationAnimHintView);
        if (obtainStyledAttributes != null) {
            this.b = obtainStyledAttributes.getColor(R.styleable.TranslationAnimHintView_direct, 0);
            obtainStyledAttributes.recycle();
        }
    }

    private void a(final View view) {
        View view2 = null;
        try {
            if (getChildCount() - 2 >= 0) {
                view2 = getChildAt(getChildCount() - 2);
            }
        } catch (Throwable th) {
            view2 = null;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        view.setAlpha(0.0f);
        ValueAnimator ofInt = ValueAnimator.ofInt(-view.getMeasuredHeight(), 0);
        ofInt.setInterpolator(new CubicInterpolator(0.66f, 0.0f, 0.34f, 1.0f));
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.blued.android.module.common.view.TranslationAnimHintView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                if (TranslationAnimHintView.this.b == 0) {
                    marginLayoutParams.topMargin = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                } else {
                    marginLayoutParams.bottomMargin = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                }
                view.setLayoutParams(marginLayoutParams);
            }
        });
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        if (this.b == 0) {
            ofFloat.setInterpolator(new CubicInterpolator(0.33f, 0.0f, 0.67f, 1.0f));
        } else {
            ofFloat.setInterpolator(new CubicInterpolator(0.66f, 0.0f, 0.34f, 1.0f));
        }
        if (view2 != null) {
            view2.setAlpha(1.0f);
        }
        final View view3 = view2;
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.blued.android.module.common.view.TranslationAnimHintView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                view.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                View view4 = view3;
                if (view4 != null) {
                    view4.setAlpha(1.0f - ((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        animatorSet.playTogether(ofInt, ofFloat);
        animatorSet.setDuration(287L);
        animatorSet.start();
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(android.view.View r4, com.blued.android.module.common.view.TranslationAnimHintView.HintInfo r5) {
        /*
            r3 = this;
            r0 = r5
            int r0 = r0.a
            r6 = r0
            r0 = r6
            r1 = 11
            if (r0 == r1) goto L4d
            r0 = r6
            r1 = 12
            if (r0 == r1) goto L3e
            r0 = r6
            switch(r0) {
                case 1: goto L4d;
                case 2: goto L4d;
                case 3: goto L4d;
                case 4: goto L3e;
                case 5: goto L3e;
                case 6: goto L4d;
                default: goto L38;
            }
        L38:
            r0 = 0
            r7 = r0
            goto L59
        L3e:
            r0 = r4
            int r1 = com.blued.android.module.common.R.id.tv_center
            android.view.View r0 = r0.findViewById(r1)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r7 = r0
            goto L59
        L4d:
            r0 = r4
            int r1 = com.blued.android.module.common.R.id.tv_hint
            android.view.View r0 = r0.findViewById(r1)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r7 = r0
        L59:
            r0 = r7
            if (r0 == 0) goto L67
            r0 = r7
            r1 = r5
            java.lang.String r1 = r1.b
            r0.setText(r1)
        L67:
            r0 = r5
            android.view.View$OnClickListener r0 = r0.c
            if (r0 == 0) goto L7c
            r0 = r4
            int r1 = com.blued.android.module.common.R.id.iv_close
            android.view.View r0 = r0.findViewById(r1)
            r1 = r5
            android.view.View$OnClickListener r1 = r1.c
            r0.setOnClickListener(r1)
        L7c:
            r0 = r5
            android.view.View$OnClickListener r0 = r0.d
            if (r0 == 0) goto L8b
            r0 = r4
            r1 = r5
            android.view.View$OnClickListener r1 = r1.d
            r0.setOnClickListener(r1)
        L8b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.common.view.TranslationAnimHintView.a(android.view.View, com.blued.android.module.common.view.TranslationAnimHintView$HintInfo):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x01af  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private android.view.View b(int r6) {
        /*
            Method dump skipped, instructions count: 459
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.common.view.TranslationAnimHintView.b(int):android.view.View");
    }

    private void b(final View view) {
        View view2 = null;
        try {
            if (getChildCount() - 2 >= 0) {
                view2 = getChildAt(getChildCount() - 2);
            }
        } catch (Throwable th) {
            view2 = null;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        ValueAnimator ofInt = ValueAnimator.ofInt(0, -view.getMeasuredHeight());
        if (this.b == 0) {
            ofInt.setInterpolator(new CubicInterpolator(0.76f, 0.0f, 0.24f, 1.0f));
        } else {
            ofInt.setInterpolator(new CubicInterpolator(0.66f, 0.0f, 0.34f, 1.0f));
        }
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.blued.android.module.common.view.TranslationAnimHintView.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                if (TranslationAnimHintView.this.b == 0) {
                    marginLayoutParams.topMargin = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                } else {
                    marginLayoutParams.bottomMargin = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                }
                view.setLayoutParams(marginLayoutParams);
            }
        });
        ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
        if (this.b == 0) {
            ofFloat.setInterpolator(new CubicInterpolator(0.33f, 0.0f, 0.67f, 1.0f));
        } else {
            ofFloat.setInterpolator(new CubicInterpolator(0.66f, 0.0f, 0.34f, 1.0f));
        }
        if (view2 != null) {
            view2.setAlpha(0.0f);
        }
        final View view3 = view2;
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.blued.android.module.common.view.TranslationAnimHintView.5
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                View view4 = view3;
                if (view4 != null) {
                    view4.setAlpha(1.0f - ((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.blued.android.module.common.view.TranslationAnimHintView.6
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                TranslationAnimHintView.this.removeView(view);
            }
        });
        animatorSet.playTogether(ofInt, ofFloat);
        animatorSet.setDuration(287L);
        animatorSet.start();
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0086  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean b(com.blued.android.module.common.view.TranslationAnimHintView.HintInfo r6) {
        /*
            r5 = this;
            r0 = r5
            java.util.List<com.blued.android.module.common.view.TranslationAnimHintView$HintInfo> r0 = r0.a
            int r0 = r0.size()
            if (r0 <= 0) goto L3c
            r0 = 0
            r7 = r0
        Le:
            r0 = r7
            r1 = r5
            java.util.List<com.blued.android.module.common.view.TranslationAnimHintView$HintInfo> r1 = r1.a
            int r1 = r1.size()
            if (r0 >= r1) goto L3c
            r0 = r5
            java.util.List<com.blued.android.module.common.view.TranslationAnimHintView$HintInfo> r0 = r0.a
            r1 = r7
            java.lang.Object r0 = r0.get(r1)
            com.blued.android.module.common.view.TranslationAnimHintView$HintInfo r0 = (com.blued.android.module.common.view.TranslationAnimHintView.HintInfo) r0
            int r0 = r0.a
            r1 = r6
            int r1 = r1.a
            if (r0 <= r1) goto L35
            goto L3e
        L35:
            r0 = r7
            r1 = 1
            int r0 = r0 + r1
            r7 = r0
            goto Le
        L3c:
            r0 = -1
            r7 = r0
        L3e:
            android.widget.FrameLayout$LayoutParams r0 = new android.widget.FrameLayout$LayoutParams
            r1 = r0
            r2 = -1
            r3 = -2
            r1.<init>(r2, r3)
            r8 = r0
            r0 = r5
            int r0 = r0.b
            if (r0 != 0) goto L5f
            r0 = r8
            r1 = r6
            android.view.View r1 = r1.e
            int r1 = r1.getMeasuredHeight()
            int r1 = -r1
            r0.topMargin = r1
            goto L6b
        L5f:
            r0 = r8
            r1 = r6
            android.view.View r1 = r1.e
            int r1 = r1.getMeasuredHeight()
            int r1 = -r1
            r0.bottomMargin = r1
        L6b:
            r0 = r7
            r1 = -1
            if (r0 != r1) goto L86
            r0 = r5
            java.util.List<com.blued.android.module.common.view.TranslationAnimHintView$HintInfo> r0 = r0.a
            r1 = r6
            boolean r0 = r0.add(r1)
            r0 = r5
            r1 = r6
            android.view.View r1 = r1.e
            r2 = r8
            r0.addView(r1, r2)
            r0 = 1
            return r0
        L86:
            r0 = r5
            java.util.List<com.blued.android.module.common.view.TranslationAnimHintView$HintInfo> r0 = r0.a
            r1 = r7
            r2 = r6
            r0.add(r1, r2)
            r0 = r5
            r1 = r6
            android.view.View r1 = r1.e
            r2 = r7
            r3 = r8
            r0.addView(r1, r2, r3)
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.common.view.TranslationAnimHintView.b(com.blued.android.module.common.view.TranslationAnimHintView$HintInfo):boolean");
    }

    public void a(int i) {
        int i2 = -1;
        for (int i3 = 0; i3 < this.a.size(); i3++) {
            if (this.a.get(i3).a == i) {
                i2 = i3;
            }
        }
        if (i2 != -1) {
            boolean z = i2 == this.a.size() - 1;
            HintInfo remove = this.a.remove(i2);
            if (z) {
                b(remove.e);
            } else {
                removeView(remove.e);
            }
        }
    }

    public void a(int i, String str) {
        HintInfo hintInfo = new HintInfo();
        hintInfo.a = i;
        hintInfo.b = str;
        try {
            a(hintInfo);
        } catch (Throwable th) {
        }
    }

    public void a(final HintInfo hintInfo) {
        if (hintInfo == null) {
            return;
        }
        if (this.a.contains(hintInfo)) {
            HintInfo hintInfo2 = this.a.get(this.a.indexOf(hintInfo));
            hintInfo2.update(hintInfo);
            a(hintInfo2.e, hintInfo2);
            if (!hintInfo.f || hintInfo.h == null) {
                return;
            }
            AppInfo.n().removeCallbacks(hintInfo.h);
            AppInfo.n().postDelayed(hintInfo.h, hintInfo.g);
            return;
        }
        hintInfo.e = b(hintInfo.a);
        a(hintInfo.e, hintInfo);
        if (b(hintInfo)) {
            a(hintInfo.e);
        }
        if (hintInfo.f) {
            if (hintInfo.g == 0) {
                hintInfo.g = 2385;
            }
            hintInfo.h = new Runnable() { // from class: com.blued.android.module.common.view.TranslationAnimHintView.1
                @Override // java.lang.Runnable
                public void run() {
                    TranslationAnimHintView.this.a(hintInfo.a);
                }
            };
            AppInfo.n().postDelayed(hintInfo.h, hintInfo.g);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.a.clear();
        removeAllViews();
    }
}
