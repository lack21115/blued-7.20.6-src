package com.soft.blued.customview.floating_action;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/customview/floating_action/FloatingActionsMenu.class */
public class FloatingActionsMenu extends ViewGroup {
    private static Interpolator r = new OvershootInterpolator();
    private static Interpolator s = new DecelerateInterpolator(3.0f);
    private static Interpolator t = new DecelerateInterpolator();

    /* renamed from: a  reason: collision with root package name */
    public FloatingActionButton f14892a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private int f14893c;
    private int d;
    private boolean e;
    private AnimatorSet f;
    private AnimatorSet g;
    private int h;
    private int i;
    private int j;
    private int k;
    private int l;
    private int m;
    private int n;
    private boolean o;
    private TouchDelegateGroup p;
    private OnFloatingActionsMenuUpdateListener q;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/customview/floating_action/FloatingActionsMenu$LayoutParams.class */
    public class LayoutParams extends ViewGroup.LayoutParams {
        private ObjectAnimator b;

        /* renamed from: c  reason: collision with root package name */
        private ObjectAnimator f14896c;
        private ObjectAnimator d;
        private ObjectAnimator e;
        private boolean f;

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.b = new ObjectAnimator();
            this.f14896c = new ObjectAnimator();
            this.d = new ObjectAnimator();
            this.e = new ObjectAnimator();
            this.b.setInterpolator(FloatingActionsMenu.r);
            this.f14896c.setInterpolator(FloatingActionsMenu.t);
            this.d.setInterpolator(FloatingActionsMenu.s);
            this.e.setInterpolator(FloatingActionsMenu.s);
            this.e.setProperty(View.ALPHA);
            this.e.setFloatValues(1.0f, 0.0f);
            this.f14896c.setProperty(View.ALPHA);
            this.f14896c.setFloatValues(0.0f, 1.0f);
            int i = FloatingActionsMenu.this.b;
            if (i == 0 || i == 1) {
                this.d.setProperty(View.TRANSLATION_Y);
                this.b.setProperty(View.TRANSLATION_Y);
            } else if (i == 2 || i == 3) {
                this.d.setProperty(View.TRANSLATION_X);
                this.b.setProperty(View.TRANSLATION_X);
            }
        }

        private void a(Animator animator, View view) {
            animator.addListener(new AnimatorListenerAdapter() { // from class: com.soft.blued.customview.floating_action.FloatingActionsMenu.LayoutParams.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator2) {
                    FloatingActionsMenu.this.o = true;
                    if (FloatingActionsMenu.this.e) {
                        if (FloatingActionsMenu.this.q != null) {
                            FloatingActionsMenu.this.q.a();
                        }
                    } else if (FloatingActionsMenu.this.q != null) {
                        FloatingActionsMenu.this.q.b();
                    }
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator2) {
                    if (FloatingActionsMenu.this.e) {
                        if (FloatingActionsMenu.this.q != null) {
                            FloatingActionsMenu.this.q.c();
                        }
                    } else if (FloatingActionsMenu.this.q != null) {
                        FloatingActionsMenu.this.q.d();
                    }
                }
            });
        }

        public void a(View view) {
            this.e.setTarget(view);
            this.d.setTarget(view);
            this.f14896c.setTarget(view);
            this.b.setTarget(view);
            if (this.f) {
                return;
            }
            a(this.b, view);
            a(this.d, view);
            FloatingActionsMenu.this.g.play(this.e);
            FloatingActionsMenu.this.g.play(this.d);
            FloatingActionsMenu.this.f.play(this.f14896c);
            FloatingActionsMenu.this.f.play(this.b);
            this.f = true;
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/customview/floating_action/FloatingActionsMenu$OnFloatingActionsMenuUpdateListener.class */
    public interface OnFloatingActionsMenuUpdateListener {
        void a();

        void b();

        void c();

        void d();
    }

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/customview/floating_action/FloatingActionsMenu$SavedState.class */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.soft.blued.customview.floating_action.FloatingActionsMenu.SavedState.1
            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };

        /* renamed from: a  reason: collision with root package name */
        public boolean f14898a;

        private SavedState(Parcel parcel) {
            super(parcel);
            this.f14898a = parcel.readInt() != 1 ? false : true;
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
        }
    }

    public FloatingActionsMenu(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f = new AnimatorSet().setDuration(300L);
        this.g = new AnimatorSet().setDuration(300L);
        a(context, attributeSet);
    }

    public FloatingActionsMenu(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f = new AnimatorSet().setDuration(300L);
        this.g = new AnimatorSet().setDuration(300L);
        a(context, attributeSet);
    }

    private int a(int i) {
        return (i * 12) / 10;
    }

    private void a(Context context) {
        FloatingActionButton floatingActionButton = new FloatingActionButton(context);
        this.f14892a = floatingActionButton;
        floatingActionButton.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.f14892a.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.customview.floating_action.FloatingActionsMenu.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                FloatingActionsMenu.this.b();
            }
        });
        addView(this.f14892a, generateLayoutParams(new ViewGroup.LayoutParams(this.m, this.n)));
        this.l++;
        if (this.j != 0) {
            h();
        }
    }

    private void a(Context context, AttributeSet attributeSet) {
        this.f14893c = (int) getResources().getDimension(2131166124);
        this.d = getResources().getDimensionPixelSize(2131166125);
        TouchDelegateGroup touchDelegateGroup = new TouchDelegateGroup(this);
        this.p = touchDelegateGroup;
        setTouchDelegate(touchDelegateGroup);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.FloatingActionsMenu, 0, 0);
        this.b = obtainStyledAttributes.getInt(7, 0);
        this.j = obtainStyledAttributes.getResourceId(8, 0);
        this.k = obtainStyledAttributes.getInt(9, 0);
        this.m = obtainStyledAttributes.getLayoutDimension(6, "fab_button_width");
        this.n = obtainStyledAttributes.getLayoutDimension(5, "fab_button_height");
        obtainStyledAttributes.recycle();
        if (this.j != 0 && g()) {
            throw new IllegalStateException("Action labels in horizontal expand orientation is not supported.");
        }
        a(context);
    }

    private void a(boolean z) {
        if (this.e) {
            this.e = false;
            this.p.a(false);
            this.g.setDuration(z ? 0L : 300L);
            this.g.start();
            this.f.cancel();
        }
    }

    private boolean g() {
        int i = this.b;
        return i == 2 || i == 3;
    }

    private void h() {
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(getContext(), this.j);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.l) {
                return;
            }
            FloatingActionButton floatingActionButton = (FloatingActionButton) getChildAt(i2);
            String title = floatingActionButton.getTitle();
            String color = floatingActionButton.getColor();
            if (title != null && floatingActionButton.getTag(R.id.fab_label) == null) {
                TextView textView = new TextView(contextThemeWrapper);
                textView.setTextAppearance(getContext(), this.j);
                textView.setText(floatingActionButton.getTitle());
                if (!TextUtils.isEmpty(color)) {
                    textView.setTextColor(Color.parseColor(color));
                }
                addView(textView);
                floatingActionButton.setTag(R.id.fab_label, textView);
            }
            i = i2 + 1;
        }
    }

    public void a() {
        a(false);
    }

    public void b() {
        if (this.e) {
            a();
        } else {
            c();
        }
    }

    public void c() {
        if (this.e) {
            return;
        }
        this.e = true;
        this.p.a(true);
        this.g.cancel();
        this.f.start();
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(super.generateDefaultLayoutParams());
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(super.generateLayoutParams(attributeSet));
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(super.generateLayoutParams(layoutParams));
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        bringChildToFront(this.f14892a);
        this.l = getChildCount();
        if (this.j != 0) {
            h();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        View view;
        int i5 = this.b;
        if (i5 != 0 && i5 != 1) {
            if (i5 == 2 || i5 == 3) {
                boolean z2 = this.b == 2;
                int measuredWidth = z2 ? (i3 - i) - this.f14892a.getMeasuredWidth() : 0;
                int i6 = this.i;
                int measuredHeight = ((i4 - i2) - i6) + ((i6 - this.f14892a.getMeasuredHeight()) / 2);
                FloatingActionButton floatingActionButton = this.f14892a;
                floatingActionButton.layout(measuredWidth, measuredHeight, floatingActionButton.getMeasuredWidth() + measuredWidth, this.f14892a.getMeasuredHeight() + measuredHeight);
                int measuredWidth2 = z2 ? measuredWidth - this.f14893c : this.f14892a.getMeasuredWidth() + measuredWidth + this.f14893c;
                int i7 = this.l - 1;
                while (i7 >= 0) {
                    View childAt = getChildAt(i7);
                    int i8 = measuredWidth2;
                    if (childAt != this.f14892a) {
                        if (childAt.getVisibility() == 8) {
                            i8 = measuredWidth2;
                        } else {
                            int i9 = measuredWidth2;
                            if (z2) {
                                i9 = measuredWidth2 - childAt.getMeasuredWidth();
                            }
                            int measuredHeight2 = ((this.f14892a.getMeasuredHeight() - childAt.getMeasuredHeight()) / 2) + measuredHeight;
                            childAt.layout(i9, measuredHeight2, childAt.getMeasuredWidth() + i9, childAt.getMeasuredHeight() + measuredHeight2);
                            float f = measuredWidth - i9;
                            childAt.setTranslationX(this.e ? 0.0f : f);
                            childAt.setAlpha(this.e ? 1.0f : 0.0f);
                            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                            layoutParams.d.setFloatValues(0.0f, f);
                            layoutParams.b.setFloatValues(f, 0.0f);
                            layoutParams.a(childAt);
                            i8 = z2 ? i9 - this.f14893c : i9 + childAt.getMeasuredWidth() + this.f14893c;
                        }
                    }
                    i7--;
                    measuredWidth2 = i8;
                }
                return;
            }
            return;
        }
        boolean z3 = this.b == 0;
        if (z) {
            this.p.a();
        }
        int measuredHeight3 = z3 ? (i4 - i2) - this.f14892a.getMeasuredHeight() : 0;
        int i10 = this.k == 0 ? (i3 - i) - (this.h / 2) : this.h / 2;
        int measuredWidth3 = i10 - (this.f14892a.getMeasuredWidth() / 2);
        FloatingActionButton floatingActionButton2 = this.f14892a;
        floatingActionButton2.layout(measuredWidth3, measuredHeight3, floatingActionButton2.getMeasuredWidth() + measuredWidth3, this.f14892a.getMeasuredHeight() + measuredHeight3);
        int i11 = (this.h / 2) + this.d;
        int i12 = this.k == 0 ? i10 - i11 : i11 + i10;
        int measuredHeight4 = z3 ? measuredHeight3 - this.f14893c : this.f14892a.getMeasuredHeight() + measuredHeight3 + this.f14893c;
        int i13 = measuredHeight3;
        for (int i14 = this.l - 1; i14 >= 0; i14--) {
            View childAt2 = getChildAt(i14);
            if (i14 == this.l - 1 && (view = (View) childAt2.getTag(R.id.fab_label)) != null) {
                int measuredWidth4 = i10 - (childAt2.getMeasuredWidth() / 2);
                int i15 = this.f14893c + measuredHeight4;
                int measuredWidth5 = this.k == 0 ? i12 - view.getMeasuredWidth() : view.getMeasuredWidth() + i12;
                int i16 = this.k == 0 ? measuredWidth5 : i12;
                if (this.k == 0) {
                    measuredWidth5 = i12;
                }
                int measuredHeight5 = ((childAt2.getMeasuredHeight() - view.getMeasuredHeight()) / 2) + i15;
                float f2 = i13 - i15;
                view.layout(i16, measuredHeight5, measuredWidth5, measuredHeight5 + view.getMeasuredHeight());
                this.p.a(new TouchDelegate(new Rect(Math.min(measuredWidth4, i16), i15 - (this.f14893c / 2), Math.max(measuredWidth4 + childAt2.getMeasuredWidth(), measuredWidth5), i15 + childAt2.getMeasuredHeight() + (this.f14893c / 2)), childAt2));
                if (this.o) {
                    this.o = false;
                    view.setTranslationY(this.e ? 0.0f : f2);
                    view.setAlpha(this.e ? 1.0f : 0.0f);
                }
                LayoutParams layoutParams2 = (LayoutParams) view.getLayoutParams();
                layoutParams2.d.setFloatValues(0.0f, f2);
                layoutParams2.b.setFloatValues(f2, 0.0f);
                layoutParams2.a(view);
            }
            if (childAt2 != this.f14892a && childAt2.getVisibility() != 8) {
                int measuredWidth6 = i10 - (childAt2.getMeasuredWidth() / 2);
                int i17 = measuredHeight4;
                if (z3) {
                    i17 = measuredHeight4 - childAt2.getMeasuredHeight();
                }
                childAt2.layout(measuredWidth6, i17, childAt2.getMeasuredWidth() + measuredWidth6, childAt2.getMeasuredHeight() + i17);
                float f3 = i13 - i17;
                if (this.o) {
                    this.o = false;
                    childAt2.setTranslationY(this.e ? 0.0f : f3);
                    childAt2.setAlpha(this.e ? 1.0f : 0.0f);
                }
                LayoutParams layoutParams3 = (LayoutParams) childAt2.getLayoutParams();
                layoutParams3.d.setFloatValues(0.0f, f3);
                layoutParams3.b.setFloatValues(f3, 0.0f);
                layoutParams3.a(childAt2);
                View view2 = (View) childAt2.getTag(R.id.fab_label);
                if (view2 != null) {
                    int measuredWidth7 = this.k == 0 ? i12 - view2.getMeasuredWidth() : view2.getMeasuredWidth() + i12;
                    int i18 = this.k == 0 ? measuredWidth7 : i12;
                    if (this.k == 0) {
                        measuredWidth7 = i12;
                    }
                    int measuredHeight6 = ((childAt2.getMeasuredHeight() - view2.getMeasuredHeight()) / 2) + i17;
                    view2.layout(i18, measuredHeight6, measuredWidth7, measuredHeight6 + view2.getMeasuredHeight());
                    this.p.a(new TouchDelegate(new Rect(Math.min(measuredWidth6, i18), i17 - (this.f14893c / 2), Math.max(measuredWidth6 + childAt2.getMeasuredWidth(), measuredWidth7), childAt2.getMeasuredHeight() + i17 + (this.f14893c / 2)), childAt2));
                    if (this.o) {
                        this.o = false;
                        view2.setTranslationY(this.e ? 0.0f : f3);
                        view2.setAlpha(this.e ? 1.0f : 0.0f);
                    }
                    LayoutParams layoutParams4 = (LayoutParams) view2.getLayoutParams();
                    layoutParams4.d.setFloatValues(0.0f, f3);
                    layoutParams4.b.setFloatValues(f3, 0.0f);
                    layoutParams4.a(view2);
                }
                measuredHeight4 = z3 ? i17 - this.f14893c : i17 + childAt2.getMeasuredHeight() + this.f14893c;
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        measureChildren(i, i2);
        this.h = 0;
        this.i = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        while (true) {
            i3 = i10;
            if (i7 >= this.l) {
                break;
            }
            View childAt = getChildAt(i7);
            if (childAt.getVisibility() == 8) {
                i4 = i8;
                i5 = i9;
                i6 = i3;
            } else {
                int i11 = this.b;
                if (i11 == 0 || i11 == 1) {
                    this.h = Math.max(this.h, childAt.getMeasuredWidth());
                    i9 += childAt.getMeasuredHeight();
                } else if (i11 == 2 || i11 == 3) {
                    i3 += childAt.getMeasuredWidth();
                    this.i = Math.max(this.i, childAt.getMeasuredHeight());
                }
                i4 = i8;
                i5 = i9;
                i6 = i3;
                if (!g()) {
                    TextView textView = (TextView) childAt.getTag(R.id.fab_label);
                    i4 = i8;
                    i5 = i9;
                    i6 = i3;
                    if (textView != null) {
                        i4 = Math.max(i8, textView.getMeasuredWidth());
                        i6 = i3;
                        i5 = i9;
                    }
                }
            }
            i7++;
            i8 = i4;
            i9 = i5;
            i10 = i6;
        }
        if (g()) {
            i9 = this.i;
        } else {
            int i12 = this.h;
            int i13 = 0;
            if (i8 > 0) {
                i13 = this.d + i8;
            }
            i3 = i12 + i13;
        }
        int i14 = this.b;
        if (i14 == 0 || i14 == 1) {
            i9 = a(i9 + (this.f14893c * (this.l - 1)));
        } else if (i14 == 2 || i14 == 3) {
            i3 = a(i3 + (this.f14893c * (this.l - 1)));
        }
        setMeasuredDimension(i3, i9);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        boolean z = savedState.f14898a;
        this.e = z;
        this.p.a(z);
        super.onRestoreInstanceState(savedState.getSuperState());
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f14898a = this.e;
        return savedState;
    }

    public void setButtonClickListener(View.OnClickListener onClickListener) {
        this.f14892a.setOnClickListener(onClickListener);
    }

    public void setButtonTitle(String str) {
        this.f14892a.setTitle(str);
    }

    public void setButtonTitleColor(String str) {
        this.f14892a.setLabelColor(str);
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        this.f14892a.setEnabled(z);
    }

    public void setOnFloatingActionsMenuUpdateListener(OnFloatingActionsMenuUpdateListener onFloatingActionsMenuUpdateListener) {
        this.q = onFloatingActionsMenuUpdateListener;
    }
}
