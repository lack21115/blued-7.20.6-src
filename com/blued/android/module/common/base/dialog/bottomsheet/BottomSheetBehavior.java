package com.blued.android.module.common.base.dialog.bottomsheet;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.math.MathUtils;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.customview.view.AbsSavedState;
import androidx.customview.widget.ViewDragHelper;
import com.blued.android.module.common.R;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/base/dialog/bottomsheet/BottomSheetBehavior.class */
public class BottomSheetBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {
    private static final int F = R.style.Widget_Design_BottomSheet_Modal;
    private boolean A;
    private ShapeAppearanceModel B;
    private boolean C;
    private BottomSheetBehavior<V>.SettleRunnable D;
    private ValueAnimator E;
    private boolean G;
    private boolean H;
    private boolean I;
    private int J;
    private boolean K;
    private int L;
    private final ArrayList<BottomSheetCallback> M;
    private VelocityTracker N;
    private int O;
    private Map<View, Integer> P;
    private final ViewDragHelper.Callback Q;
    int a;
    int b;
    int c;
    float d;
    int e;
    float f;
    boolean g;
    int h;
    ViewDragHelper i;
    int j;
    int k;
    WeakReference<V> l;
    WeakReference<View> m;
    int n;
    boolean o;
    private int p;
    private boolean q;
    private boolean r;
    private float s;
    private int t;
    private boolean u;
    private int v;
    private int w;
    private boolean x;
    private MaterialShapeDrawable y;
    private int z;

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/base/dialog/bottomsheet/BottomSheetBehavior$BottomSheetCallback.class */
    public static abstract class BottomSheetCallback {
        public abstract void a(View view, float f);

        public abstract void a(View view, int i);
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/base/dialog/bottomsheet/BottomSheetBehavior$SaveFlags.class */
    public @interface SaveFlags {
    }

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/base/dialog/bottomsheet/BottomSheetBehavior$SavedState.class */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: com.blued.android.module.common.base.dialog.bottomsheet.BottomSheetBehavior.SavedState.1
            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, (ClassLoader) null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        final int a;
        int b;
        boolean c;
        boolean d;
        boolean e;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.a = parcel.readInt();
            this.b = parcel.readInt();
            this.c = parcel.readInt() == 1;
            this.d = parcel.readInt() == 1;
            this.e = parcel.readInt() == 1;
        }

        public SavedState(Parcelable parcelable, BottomSheetBehavior<?> bottomSheetBehavior) {
            super(parcelable);
            this.a = bottomSheetBehavior.h;
            this.b = ((BottomSheetBehavior) bottomSheetBehavior).t;
            this.c = ((BottomSheetBehavior) bottomSheetBehavior).q;
            this.d = bottomSheetBehavior.g;
            this.e = ((BottomSheetBehavior) bottomSheetBehavior).G;
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
        public void writeToParcel(Parcel parcel, int i) {
            throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/base/dialog/bottomsheet/BottomSheetBehavior$SettleRunnable.class */
    public class SettleRunnable implements Runnable {
        int a;
        private final View c;
        private boolean d;

        SettleRunnable(View view, int i) {
            this.c = view;
            this.a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (BottomSheetBehavior.this.i == null || !BottomSheetBehavior.this.i.continueSettling(true)) {
                BottomSheetBehavior.this.e(this.a);
            } else {
                ViewCompat.postOnAnimation(this.c, this);
            }
            this.d = false;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/base/dialog/bottomsheet/BottomSheetBehavior$State.class */
    public @interface State {
    }

    public BottomSheetBehavior() {
        this.p = 0;
        this.q = true;
        this.r = false;
        this.D = null;
        this.d = 0.5f;
        this.f = -1.0f;
        this.H = true;
        this.h = 4;
        this.M = new ArrayList<>();
        this.Q = new ViewDragHelper.Callback() { // from class: com.blued.android.module.common.base.dialog.bottomsheet.BottomSheetBehavior.4
            private boolean a(View view) {
                return view.getTop() > (BottomSheetBehavior.this.k + BottomSheetBehavior.this.a()) / 2;
            }

            public int clampViewPositionHorizontal(View view, int i, int i2) {
                return view.getLeft();
            }

            public int clampViewPositionVertical(View view, int i, int i2) {
                return MathUtils.clamp(i, BottomSheetBehavior.this.a(), BottomSheetBehavior.this.g ? BottomSheetBehavior.this.k : BottomSheetBehavior.this.e);
            }

            public int getViewVerticalDragRange(View view) {
                return BottomSheetBehavior.this.g ? BottomSheetBehavior.this.k : BottomSheetBehavior.this.e;
            }

            public void onViewDragStateChanged(int i) {
                if (i == 1 && BottomSheetBehavior.this.H) {
                    BottomSheetBehavior.this.e(1);
                }
            }

            public void onViewPositionChanged(View view, int i, int i2, int i3, int i4) {
                BottomSheetBehavior.this.f(i2);
            }

            public void onViewReleased(View view, float f, float f2) {
                int i;
                int i2 = 4;
                if (f2 < 0.0f) {
                    if (BottomSheetBehavior.this.q) {
                        i = BottomSheetBehavior.this.b;
                    } else if (view.getTop() > BottomSheetBehavior.this.c) {
                        i = BottomSheetBehavior.this.c;
                        i2 = 6;
                    } else {
                        i = BottomSheetBehavior.this.a;
                    }
                    i2 = 3;
                } else if (BottomSheetBehavior.this.g && BottomSheetBehavior.this.a(view, f2)) {
                    if ((Math.abs(f) >= Math.abs(f2) || f2 <= 500.0f) && !a(view)) {
                        if (BottomSheetBehavior.this.q) {
                            i = BottomSheetBehavior.this.b;
                        } else if (Math.abs(view.getTop() - BottomSheetBehavior.this.a) < Math.abs(view.getTop() - BottomSheetBehavior.this.c)) {
                            i = BottomSheetBehavior.this.a;
                        } else {
                            i = BottomSheetBehavior.this.c;
                            i2 = 6;
                        }
                        i2 = 3;
                    } else {
                        i = BottomSheetBehavior.this.k;
                        i2 = 5;
                    }
                } else if (f2 == 0.0f || Math.abs(f) > Math.abs(f2)) {
                    int top = view.getTop();
                    if (!BottomSheetBehavior.this.q) {
                        if (top < BottomSheetBehavior.this.c) {
                            if (top < Math.abs(top - BottomSheetBehavior.this.e)) {
                                i = BottomSheetBehavior.this.a;
                                i2 = 3;
                            } else {
                                i = BottomSheetBehavior.this.c;
                            }
                        } else if (Math.abs(top - BottomSheetBehavior.this.c) < Math.abs(top - BottomSheetBehavior.this.e)) {
                            i = BottomSheetBehavior.this.c;
                        } else {
                            i = BottomSheetBehavior.this.e;
                        }
                        i2 = 6;
                    } else if (Math.abs(top - BottomSheetBehavior.this.b) < Math.abs(top - BottomSheetBehavior.this.e)) {
                        i = BottomSheetBehavior.this.b;
                        i2 = 3;
                    } else {
                        i = BottomSheetBehavior.this.e;
                    }
                } else if (BottomSheetBehavior.this.q) {
                    i = BottomSheetBehavior.this.e;
                } else {
                    int top2 = view.getTop();
                    if (Math.abs(top2 - BottomSheetBehavior.this.c) < Math.abs(top2 - BottomSheetBehavior.this.e)) {
                        i = BottomSheetBehavior.this.c;
                        i2 = 6;
                    } else {
                        i = BottomSheetBehavior.this.e;
                    }
                }
                BottomSheetBehavior.this.a(view, i2, i, true);
            }

            public boolean tryCaptureView(View view, int i) {
                if (BottomSheetBehavior.this.h == 1 || BottomSheetBehavior.this.o) {
                    return false;
                }
                if (BottomSheetBehavior.this.h == 3 && BottomSheetBehavior.this.n == i) {
                    View view2 = BottomSheetBehavior.this.m != null ? BottomSheetBehavior.this.m.get() : null;
                    if (view2 != null && view2.canScrollVertically(-1)) {
                        return false;
                    }
                }
                return BottomSheetBehavior.this.l != null && BottomSheetBehavior.this.l.get() == view;
            }
        };
    }

    public BottomSheetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.p = 0;
        this.q = true;
        this.r = false;
        this.D = null;
        this.d = 0.5f;
        this.f = -1.0f;
        this.H = true;
        this.h = 4;
        this.M = new ArrayList<>();
        this.Q = new ViewDragHelper.Callback() { // from class: com.blued.android.module.common.base.dialog.bottomsheet.BottomSheetBehavior.4
            private boolean a(View view) {
                return view.getTop() > (BottomSheetBehavior.this.k + BottomSheetBehavior.this.a()) / 2;
            }

            public int clampViewPositionHorizontal(View view, int i, int i2) {
                return view.getLeft();
            }

            public int clampViewPositionVertical(View view, int i, int i2) {
                return MathUtils.clamp(i, BottomSheetBehavior.this.a(), BottomSheetBehavior.this.g ? BottomSheetBehavior.this.k : BottomSheetBehavior.this.e);
            }

            public int getViewVerticalDragRange(View view) {
                return BottomSheetBehavior.this.g ? BottomSheetBehavior.this.k : BottomSheetBehavior.this.e;
            }

            public void onViewDragStateChanged(int i) {
                if (i == 1 && BottomSheetBehavior.this.H) {
                    BottomSheetBehavior.this.e(1);
                }
            }

            public void onViewPositionChanged(View view, int i, int i2, int i3, int i4) {
                BottomSheetBehavior.this.f(i2);
            }

            public void onViewReleased(View view, float f, float f2) {
                int i;
                int i2 = 4;
                if (f2 < 0.0f) {
                    if (BottomSheetBehavior.this.q) {
                        i = BottomSheetBehavior.this.b;
                    } else if (view.getTop() > BottomSheetBehavior.this.c) {
                        i = BottomSheetBehavior.this.c;
                        i2 = 6;
                    } else {
                        i = BottomSheetBehavior.this.a;
                    }
                    i2 = 3;
                } else if (BottomSheetBehavior.this.g && BottomSheetBehavior.this.a(view, f2)) {
                    if ((Math.abs(f) >= Math.abs(f2) || f2 <= 500.0f) && !a(view)) {
                        if (BottomSheetBehavior.this.q) {
                            i = BottomSheetBehavior.this.b;
                        } else if (Math.abs(view.getTop() - BottomSheetBehavior.this.a) < Math.abs(view.getTop() - BottomSheetBehavior.this.c)) {
                            i = BottomSheetBehavior.this.a;
                        } else {
                            i = BottomSheetBehavior.this.c;
                            i2 = 6;
                        }
                        i2 = 3;
                    } else {
                        i = BottomSheetBehavior.this.k;
                        i2 = 5;
                    }
                } else if (f2 == 0.0f || Math.abs(f) > Math.abs(f2)) {
                    int top = view.getTop();
                    if (!BottomSheetBehavior.this.q) {
                        if (top < BottomSheetBehavior.this.c) {
                            if (top < Math.abs(top - BottomSheetBehavior.this.e)) {
                                i = BottomSheetBehavior.this.a;
                                i2 = 3;
                            } else {
                                i = BottomSheetBehavior.this.c;
                            }
                        } else if (Math.abs(top - BottomSheetBehavior.this.c) < Math.abs(top - BottomSheetBehavior.this.e)) {
                            i = BottomSheetBehavior.this.c;
                        } else {
                            i = BottomSheetBehavior.this.e;
                        }
                        i2 = 6;
                    } else if (Math.abs(top - BottomSheetBehavior.this.b) < Math.abs(top - BottomSheetBehavior.this.e)) {
                        i = BottomSheetBehavior.this.b;
                        i2 = 3;
                    } else {
                        i = BottomSheetBehavior.this.e;
                    }
                } else if (BottomSheetBehavior.this.q) {
                    i = BottomSheetBehavior.this.e;
                } else {
                    int top2 = view.getTop();
                    if (Math.abs(top2 - BottomSheetBehavior.this.c) < Math.abs(top2 - BottomSheetBehavior.this.e)) {
                        i = BottomSheetBehavior.this.c;
                        i2 = 6;
                    } else {
                        i = BottomSheetBehavior.this.e;
                    }
                }
                BottomSheetBehavior.this.a(view, i2, i, true);
            }

            public boolean tryCaptureView(View view, int i) {
                if (BottomSheetBehavior.this.h == 1 || BottomSheetBehavior.this.o) {
                    return false;
                }
                if (BottomSheetBehavior.this.h == 3 && BottomSheetBehavior.this.n == i) {
                    View view2 = BottomSheetBehavior.this.m != null ? BottomSheetBehavior.this.m.get() : null;
                    if (view2 != null && view2.canScrollVertically(-1)) {
                        return false;
                    }
                }
                return BottomSheetBehavior.this.l != null && BottomSheetBehavior.this.l.get() == view;
            }
        };
        this.w = context.getResources().getDimensionPixelSize(R.dimen.mtrl_min_touch_target_size);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.BottomSheetBehavior_Layout);
        this.x = obtainStyledAttributes.hasValue(R.styleable.BottomSheetBehavior_Layout_shapeAppearance);
        boolean hasValue = obtainStyledAttributes.hasValue(R.styleable.BottomSheetBehavior_Layout_backgroundTint);
        if (hasValue) {
            a(context, attributeSet, hasValue, MaterialResources.getColorStateList(context, obtainStyledAttributes, R.styleable.BottomSheetBehavior_Layout_backgroundTint));
        } else {
            a(context, attributeSet, hasValue);
        }
        i();
        if (Build.VERSION.SDK_INT >= 21) {
            this.f = obtainStyledAttributes.getDimension(R.styleable.BottomSheetBehavior_Layout_android_elevation, -1.0f);
        }
        TypedValue peekValue = obtainStyledAttributes.peekValue(R.styleable.BottomSheetBehavior_Layout_behavior_peekHeight);
        if (peekValue == null || peekValue.data != -1) {
            a(obtainStyledAttributes.getDimensionPixelSize(R.styleable.BottomSheetBehavior_Layout_behavior_peekHeight, -1));
        } else {
            a(peekValue.data);
        }
        b(obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_hideable, false));
        e(obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_gestureInsetBottomIgnored, false));
        a(obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_fitToContents, true));
        c(obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_skipCollapsed, false));
        d(obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_draggable, true));
        c(obtainStyledAttributes.getInt(R.styleable.BottomSheetBehavior_Layout_behavior_saveFlags, 0));
        a(obtainStyledAttributes.getFloat(R.styleable.BottomSheetBehavior_Layout_behavior_halfExpandedRatio, 0.5f));
        TypedValue peekValue2 = obtainStyledAttributes.peekValue(R.styleable.BottomSheetBehavior_Layout_behavior_expandedOffset);
        if (peekValue2 == null || peekValue2.type != 16) {
            b(obtainStyledAttributes.getDimensionPixelOffset(R.styleable.BottomSheetBehavior_Layout_behavior_expandedOffset, 0));
        } else {
            b(peekValue2.data);
        }
        obtainStyledAttributes.recycle();
        this.s = ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
    }

    private void a(Context context, AttributeSet attributeSet, boolean z) {
        a(context, attributeSet, z, (ColorStateList) null);
    }

    private void a(Context context, AttributeSet attributeSet, boolean z, ColorStateList colorStateList) {
        if (this.x) {
            this.B = ShapeAppearanceModel.builder(context, attributeSet, R.attr.bottomSheetStyle, F).build();
            MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(this.B);
            this.y = materialShapeDrawable;
            materialShapeDrawable.initializeElevationOverlay(context);
            if (z && colorStateList != null) {
                this.y.setFillColor(colorStateList);
                return;
            }
            TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(com.android.internal.R.attr.colorBackground, typedValue, true);
            this.y.setTint(typedValue.data);
        }
    }

    private void a(V v, AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat, final int i) {
        ViewCompat.replaceAccessibilityAction(v, accessibilityActionCompat, (CharSequence) null, new AccessibilityViewCommand() { // from class: com.blued.android.module.common.base.dialog.bottomsheet.BottomSheetBehavior.5
            public boolean perform(View view, AccessibilityViewCommand.CommandArguments commandArguments) {
                BottomSheetBehavior.this.d(i);
                return true;
            }
        });
    }

    private void a(SavedState savedState) {
        int i = this.p;
        if (i == 0) {
            return;
        }
        if (i == -1 || (i & 1) == 1) {
            this.t = savedState.b;
        }
        int i2 = this.p;
        if (i2 == -1 || (i2 & 2) == 2) {
            this.q = savedState.c;
        }
        int i3 = this.p;
        if (i3 == -1 || (i3 & 4) == 4) {
            this.g = savedState.d;
        }
        int i4 = this.p;
        if (i4 == -1 || (i4 & 8) == 8) {
            this.G = savedState.e;
        }
    }

    public static <V extends View> BottomSheetBehavior<V> b(V v) {
        CoordinatorLayout.LayoutParams layoutParams = v.getLayoutParams();
        if (layoutParams instanceof CoordinatorLayout.LayoutParams) {
            CoordinatorLayout.Behavior behavior = layoutParams.getBehavior();
            if (behavior instanceof BottomSheetBehavior) {
                return (BottomSheetBehavior) behavior;
            }
            throw new IllegalArgumentException("The view is not associated with BottomSheetBehavior");
        }
        throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
    }

    private void c(View view) {
        if (Build.VERSION.SDK_INT < 29 || c() || this.u) {
            return;
        }
        ViewUtils.doOnApplyWindowInsets(view, new ViewUtils.OnApplyWindowInsetsListener() { // from class: com.blued.android.module.common.base.dialog.bottomsheet.BottomSheetBehavior.3
            public WindowInsetsCompat onApplyWindowInsets(View view2, WindowInsetsCompat windowInsetsCompat, ViewUtils.RelativePadding relativePadding) {
                BottomSheetBehavior.this.z = windowInsetsCompat.getMandatorySystemGestureInsets().bottom;
                BottomSheetBehavior.this.f(false);
                return windowInsetsCompat;
            }
        });
    }

    private int e() {
        int i;
        return this.u ? Math.min(Math.max(this.v, this.k - ((this.j * 9) / 16)), this.L) : (this.A || (i = this.z) <= 0) ? this.t : Math.max(this.t, i + this.w);
    }

    private void f() {
        int e = e();
        if (this.q) {
            this.e = Math.max(this.k - e, this.b);
        } else {
            this.e = this.k - e;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(boolean z) {
        V v;
        if (this.l != null) {
            f();
            if (this.h != 4 || (v = this.l.get()) == null) {
                return;
            }
            if (z) {
                g(this.h);
            } else {
                v.requestLayout();
            }
        }
    }

    private void g() {
        this.c = (int) (this.k * (1.0f - this.d));
    }

    private void g(final int i) {
        final V v = this.l.get();
        if (v == null) {
            return;
        }
        ViewParent parent = v.getParent();
        if (parent != null && parent.isLayoutRequested() && ViewCompat.isAttachedToWindow(v)) {
            v.post(new Runnable() { // from class: com.blued.android.module.common.base.dialog.bottomsheet.BottomSheetBehavior.1
                @Override // java.lang.Runnable
                public void run() {
                    BottomSheetBehavior.this.a(v, i);
                }
            });
        } else {
            a((View) v, i);
        }
    }

    private void g(boolean z) {
        Map<View, Integer> map;
        WeakReference<V> weakReference = this.l;
        if (weakReference == null) {
            return;
        }
        CoordinatorLayout parent = weakReference.get().getParent();
        if (parent instanceof CoordinatorLayout) {
            CoordinatorLayout coordinatorLayout = parent;
            int childCount = coordinatorLayout.getChildCount();
            if (Build.VERSION.SDK_INT >= 16 && z) {
                if (this.P != null) {
                    return;
                }
                this.P = new HashMap(childCount);
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= childCount) {
                    break;
                }
                View childAt = coordinatorLayout.getChildAt(i2);
                if (childAt != this.l.get()) {
                    if (z) {
                        if (Build.VERSION.SDK_INT >= 16) {
                            this.P.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                        }
                        if (this.r) {
                            ViewCompat.setImportantForAccessibility(childAt, 4);
                        }
                    } else if (this.r && (map = this.P) != null && map.containsKey(childAt)) {
                        ViewCompat.setImportantForAccessibility(childAt, this.P.get(childAt).intValue());
                    }
                }
                i = i2 + 1;
            }
            if (z) {
                return;
            }
            this.P = null;
        }
    }

    private void h() {
        this.n = -1;
        VelocityTracker velocityTracker = this.N;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.N = null;
        }
    }

    private void h(int i) {
        ValueAnimator valueAnimator;
        if (i == 2) {
            return;
        }
        boolean z = i == 3;
        if (this.C != z) {
            this.C = z;
            if (this.y == null || (valueAnimator = this.E) == null) {
                return;
            }
            if (valueAnimator.isRunning()) {
                this.E.reverse();
                return;
            }
            float f = z ? 0.0f : 1.0f;
            this.E.setFloatValues(1.0f - f, f);
            this.E.start();
        }
    }

    private void i() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.E = ofFloat;
        ofFloat.setDuration(500L);
        this.E.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.blued.android.module.common.base.dialog.bottomsheet.BottomSheetBehavior.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (BottomSheetBehavior.this.y != null) {
                    BottomSheetBehavior.this.y.setInterpolation(floatValue);
                }
            }
        });
    }

    private float j() {
        VelocityTracker velocityTracker = this.N;
        if (velocityTracker == null) {
            return 0.0f;
        }
        velocityTracker.computeCurrentVelocity(1000, this.s);
        return this.N.getYVelocity(this.n);
    }

    private void k() {
        V v;
        WeakReference<V> weakReference = this.l;
        if (weakReference == null || (v = weakReference.get()) == null) {
            return;
        }
        ViewCompat.removeAccessibilityAction(v, 524288);
        ViewCompat.removeAccessibilityAction(v, 262144);
        ViewCompat.removeAccessibilityAction(v, 1048576);
        if (this.g && this.h != 5) {
            a((BottomSheetBehavior<V>) v, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_DISMISS, 5);
        }
        int i = this.h;
        int i2 = 6;
        if (i == 3) {
            if (this.q) {
                i2 = 4;
            }
            a((BottomSheetBehavior<V>) v, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_COLLAPSE, i2);
        } else if (i == 4) {
            if (this.q) {
                i2 = 3;
            }
            a((BottomSheetBehavior<V>) v, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_EXPAND, i2);
        } else if (i != 6) {
        } else {
            a((BottomSheetBehavior<V>) v, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_COLLAPSE, 4);
            a((BottomSheetBehavior<V>) v, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_EXPAND, 3);
        }
    }

    public int a() {
        return this.q ? this.b : this.a;
    }

    View a(View view) {
        if (ViewCompat.isNestedScrollingEnabled(view)) {
            return view;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View a = a(viewGroup.getChildAt(i));
                if (a != null) {
                    return a;
                }
            }
            return null;
        }
        return null;
    }

    public void a(float f) {
        if (f <= 0.0f || f >= 1.0f) {
            throw new IllegalArgumentException("ratio must be a float value between 0 and 1");
        }
        this.d = f;
        if (this.l != null) {
            g();
        }
    }

    public void a(int i) {
        a(i, false);
    }

    public final void a(int i, boolean z) {
        boolean z2;
        if (i == -1) {
            if (!this.u) {
                this.u = true;
                z2 = true;
            }
            z2 = false;
        } else {
            if (this.u || this.t != i) {
                this.u = false;
                this.t = Math.max(0, i);
                z2 = true;
            }
            z2 = false;
        }
        if (z2) {
            f(z);
        }
    }

    void a(View view, int i) {
        int i2;
        int i3;
        if (i == 4) {
            i2 = this.e;
        } else if (i == 6) {
            i2 = this.c;
            if (this.q && i2 <= (i3 = this.b)) {
                i2 = i3;
                i = 3;
            }
        } else if (i == 3) {
            i2 = a();
        } else if (!this.g || i != 5) {
            throw new IllegalArgumentException("Illegal state argument: " + i);
        } else {
            i2 = this.k;
        }
        a(view, i, i2, false);
    }

    void a(View view, int i, int i2, boolean z) {
        ViewDragHelper viewDragHelper = this.i;
        if (!(viewDragHelper != null && (!z ? !viewDragHelper.smoothSlideViewTo(view, view.getLeft(), i2) : !viewDragHelper.settleCapturedViewAt(view.getLeft(), i2)))) {
            e(i);
            return;
        }
        e(2);
        h(i);
        if (this.D == null) {
            this.D = new SettleRunnable(view, i);
        }
        if (((SettleRunnable) this.D).d) {
            this.D.a = i;
            return;
        }
        this.D.a = i;
        ViewCompat.postOnAnimation(view, this.D);
        ((SettleRunnable) this.D).d = true;
    }

    public void a(BottomSheetCallback bottomSheetCallback) {
        if (this.M.contains(bottomSheetCallback)) {
            return;
        }
        this.M.add(bottomSheetCallback);
    }

    public void a(boolean z) {
        if (this.q == z) {
            return;
        }
        this.q = z;
        if (this.l != null) {
            f();
        }
        e((this.q && this.h == 6) ? 3 : this.h);
        k();
    }

    boolean a(View view, float f) {
        if (this.G) {
            return true;
        }
        if (view.getTop() < this.e) {
            return false;
        }
        return Math.abs((((float) view.getTop()) + (f * 0.1f)) - ((float) this.e)) / ((float) e()) > 0.5f;
    }

    public void b(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("offset must be greater than or equal to 0");
        }
        this.a = i;
    }

    public void b(BottomSheetCallback bottomSheetCallback) {
        this.M.remove(bottomSheetCallback);
    }

    public void b(boolean z) {
        if (this.g != z) {
            this.g = z;
            if (!z && this.h == 5) {
                d(4);
            }
            k();
        }
    }

    public boolean b() {
        return this.g;
    }

    public void c(int i) {
        this.p = i;
    }

    public void c(boolean z) {
        this.G = z;
    }

    public boolean c() {
        return this.A;
    }

    public int d() {
        return this.h;
    }

    public void d(int i) {
        if (i == this.h) {
            return;
        }
        if (this.l != null) {
            g(i);
        } else if (i == 4 || i == 3 || i == 6 || (this.g && i == 5)) {
            this.h = i;
        }
    }

    public void d(boolean z) {
        this.H = z;
    }

    void e(int i) {
        V v;
        if (this.h == i) {
            return;
        }
        this.h = i;
        WeakReference<V> weakReference = this.l;
        if (weakReference == null || (v = weakReference.get()) == null) {
            return;
        }
        if (i == 3) {
            g(true);
        } else if (i == 6 || i == 5 || i == 4) {
            g(false);
        }
        h(i);
        for (int i2 = 0; i2 < this.M.size(); i2++) {
            this.M.get(i2).a((View) v, i);
        }
        k();
    }

    public void e(boolean z) {
        this.A = z;
    }

    void f(int i) {
        float f;
        float f2;
        V v = this.l.get();
        if (v == null || this.M.isEmpty()) {
            return;
        }
        int i2 = this.e;
        if (i > i2 || i2 == a()) {
            int i3 = this.e;
            f = i3 - i;
            f2 = this.k - i3;
        } else {
            int i4 = this.e;
            f = i4 - i;
            f2 = i4 - a();
        }
        float f3 = f / f2;
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 >= this.M.size()) {
                return;
            }
            this.M.get(i6).a(v, f3);
            i5 = i6 + 1;
        }
    }

    public void onAttachedToLayoutParams(CoordinatorLayout.LayoutParams layoutParams) {
        super.onAttachedToLayoutParams(layoutParams);
        this.l = null;
        this.i = null;
    }

    public void onDetachedFromLayoutParams() {
        super.onDetachedFromLayoutParams();
        this.l = null;
        this.i = null;
    }

    public boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        ViewDragHelper viewDragHelper;
        if (!v.isShown() || !this.H) {
            this.I = true;
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            h();
        }
        if (this.N == null) {
            this.N = VelocityTracker.obtain();
        }
        this.N.addMovement(motionEvent);
        if (actionMasked == 0) {
            int x = (int) motionEvent.getX();
            this.O = (int) motionEvent.getY();
            if (this.h != 2) {
                WeakReference<View> weakReference = this.m;
                View view = weakReference != null ? weakReference.get() : null;
                if (view != null && coordinatorLayout.isPointInChildBounds(view, x, this.O)) {
                    this.n = motionEvent.getPointerId(motionEvent.getActionIndex());
                    this.o = true;
                }
            }
            this.I = this.n == -1 && !coordinatorLayout.isPointInChildBounds(v, x, this.O);
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.o = false;
            this.n = -1;
            if (this.I) {
                this.I = false;
                return false;
            }
        }
        if (this.I || (viewDragHelper = this.i) == null || !viewDragHelper.shouldInterceptTouchEvent(motionEvent)) {
            WeakReference<View> weakReference2 = this.m;
            View view2 = null;
            if (weakReference2 != null) {
                view2 = weakReference2.get();
            }
            boolean z = false;
            if (actionMasked == 2) {
                z = false;
                if (view2 != null) {
                    z = false;
                    if (!this.I) {
                        z = false;
                        if (this.h != 1) {
                            z = false;
                            if (!coordinatorLayout.isPointInChildBounds(view2, (int) motionEvent.getX(), (int) motionEvent.getY())) {
                                z = false;
                                if (this.i != null) {
                                    z = false;
                                    if (Math.abs(this.O - motionEvent.getY()) > this.i.getTouchSlop()) {
                                        z = true;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return z;
        }
        return true;
    }

    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, V v, int i) {
        MaterialShapeDrawable materialShapeDrawable;
        if (ViewCompat.getFitsSystemWindows(coordinatorLayout) && !ViewCompat.getFitsSystemWindows(v)) {
            v.setFitsSystemWindows(true);
        }
        if (this.l == null) {
            this.v = coordinatorLayout.getResources().getDimensionPixelSize(R.dimen.design_bottom_sheet_peek_height_min);
            c(v);
            this.l = new WeakReference<>(v);
            if (this.x && (materialShapeDrawable = this.y) != null) {
                ViewCompat.setBackground(v, materialShapeDrawable);
            }
            MaterialShapeDrawable materialShapeDrawable2 = this.y;
            if (materialShapeDrawable2 != null) {
                float f = this.f;
                float f2 = f;
                if (f == -1.0f) {
                    f2 = ViewCompat.getElevation(v);
                }
                materialShapeDrawable2.setElevation(f2);
                boolean z = this.h == 3;
                this.C = z;
                this.y.setInterpolation(z ? 0.0f : 1.0f);
            }
            k();
            if (ViewCompat.getImportantForAccessibility(v) == 0) {
                ViewCompat.setImportantForAccessibility(v, 1);
            }
        }
        if (this.i == null) {
            this.i = ViewDragHelper.create(coordinatorLayout, this.Q);
        }
        int top = v.getTop();
        coordinatorLayout.onLayoutChild(v, i);
        this.j = coordinatorLayout.getWidth();
        this.k = coordinatorLayout.getHeight();
        int height = v.getHeight();
        this.L = height;
        this.b = Math.max(0, this.k - height);
        g();
        f();
        int i2 = this.h;
        if (i2 == 3) {
            ViewCompat.offsetTopAndBottom(v, a());
        } else if (i2 == 6) {
            ViewCompat.offsetTopAndBottom(v, this.c);
        } else if (this.g && i2 == 5) {
            ViewCompat.offsetTopAndBottom(v, this.k);
        } else {
            int i3 = this.h;
            if (i3 == 4) {
                ViewCompat.offsetTopAndBottom(v, this.e);
            } else if (i3 == 1 || i3 == 2) {
                ViewCompat.offsetTopAndBottom(v, top - v.getTop());
            }
        }
        this.m = new WeakReference<>(a(v));
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0036, code lost:
        if (super.onNestedPreFling(r8, r9, r10, r11, r12) != false) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onNestedPreFling(androidx.coordinatorlayout.widget.CoordinatorLayout r8, V r9, android.view.View r10, float r11, float r12) {
        /*
            r7 = this;
            r0 = r7
            java.lang.ref.WeakReference<android.view.View> r0 = r0.m
            r15 = r0
            r0 = 0
            r14 = r0
            r0 = r14
            r13 = r0
            r0 = r15
            if (r0 == 0) goto L3c
            r0 = r14
            r13 = r0
            r0 = r10
            r1 = r15
            java.lang.Object r1 = r1.get()
            if (r0 != r1) goto L3c
            r0 = r7
            int r0 = r0.h
            r1 = 3
            if (r0 != r1) goto L39
            r0 = r14
            r13 = r0
            r0 = r7
            r1 = r8
            r2 = r9
            r3 = r10
            r4 = r11
            r5 = r12
            boolean r0 = super.onNestedPreFling(r1, r2, r3, r4, r5)
            if (r0 == 0) goto L3c
        L39:
            r0 = 1
            r13 = r0
        L3c:
            r0 = r13
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.common.base.dialog.bottomsheet.BottomSheetBehavior.onNestedPreFling(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, android.view.View, float, float):boolean");
    }

    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int[] iArr, int i3) {
        if (i3 == 1) {
            return;
        }
        WeakReference<View> weakReference = this.m;
        if (view != (weakReference != null ? weakReference.get() : null)) {
            return;
        }
        int top = v.getTop();
        int i4 = top - i2;
        if (i2 > 0) {
            if (i4 < a()) {
                iArr[1] = top - a();
                ViewCompat.offsetTopAndBottom(v, -iArr[1]);
                e(3);
            } else if (!this.H) {
                return;
            } else {
                iArr[1] = i2;
                ViewCompat.offsetTopAndBottom(v, -i2);
                e(1);
            }
        } else if (i2 < 0 && !view.canScrollVertically(-1)) {
            int i5 = this.e;
            if (i4 > i5 && !this.g) {
                iArr[1] = top - i5;
                ViewCompat.offsetTopAndBottom(v, -iArr[1]);
                e(4);
            } else if (!this.H) {
                return;
            } else {
                iArr[1] = i2;
                ViewCompat.offsetTopAndBottom(v, -i2);
                e(1);
            }
        }
        f(v.getTop());
        this.J = i2;
        this.K = true;
    }

    public void onNestedScroll(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int i3, int i4, int i5, int[] iArr) {
    }

    public void onRestoreInstanceState(CoordinatorLayout coordinatorLayout, V v, Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(coordinatorLayout, v, savedState.getSuperState());
        a(savedState);
        if (savedState.a == 1 || savedState.a == 2) {
            this.h = 4;
        } else {
            this.h = savedState.a;
        }
    }

    public Parcelable onSaveInstanceState(CoordinatorLayout coordinatorLayout, V v) {
        return new SavedState(super.onSaveInstanceState(coordinatorLayout, v), (BottomSheetBehavior<?>) this);
    }

    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i, int i2) {
        boolean z = false;
        this.J = 0;
        this.K = false;
        if ((i & 2) != 0) {
            z = true;
        }
        return z;
    }

    public void onStopNestedScroll(CoordinatorLayout coordinatorLayout, V v, View view, int i) {
        int i2;
        int i3 = 3;
        if (v.getTop() == a()) {
            e(3);
            return;
        }
        WeakReference<View> weakReference = this.m;
        if (weakReference != null && view == weakReference.get() && this.K) {
            if (this.J > 0) {
                if (this.q) {
                    i2 = this.b;
                } else {
                    int top = v.getTop();
                    i2 = this.c;
                    if (top <= i2) {
                        i2 = this.a;
                    }
                    i3 = 6;
                }
            } else if (this.g && a(v, j())) {
                i2 = this.k;
                i3 = 5;
            } else if (this.J == 0) {
                int top2 = v.getTop();
                if (!this.q) {
                    int i4 = this.c;
                    if (top2 < i4) {
                        if (top2 < Math.abs(top2 - this.e)) {
                            i2 = this.a;
                        } else {
                            i2 = this.c;
                        }
                    } else if (Math.abs(top2 - i4) < Math.abs(top2 - this.e)) {
                        i2 = this.c;
                    } else {
                        i2 = this.e;
                        i3 = 4;
                    }
                    i3 = 6;
                } else if (Math.abs(top2 - this.b) < Math.abs(top2 - this.e)) {
                    i2 = this.b;
                } else {
                    i2 = this.e;
                    i3 = 4;
                }
            } else {
                if (this.q) {
                    i2 = this.e;
                } else {
                    int top3 = v.getTop();
                    if (Math.abs(top3 - this.c) < Math.abs(top3 - this.e)) {
                        i2 = this.c;
                        i3 = 6;
                    } else {
                        i2 = this.e;
                    }
                }
                i3 = 4;
            }
            a((View) v, i3, i2, false);
            this.K = false;
        }
    }

    public boolean onTouchEvent(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        if (v.isShown()) {
            int actionMasked = motionEvent.getActionMasked();
            if (this.h == 1 && actionMasked == 0) {
                return true;
            }
            ViewDragHelper viewDragHelper = this.i;
            if (viewDragHelper != null) {
                viewDragHelper.processTouchEvent(motionEvent);
            }
            if (actionMasked == 0) {
                h();
            }
            if (this.N == null) {
                this.N = VelocityTracker.obtain();
            }
            this.N.addMovement(motionEvent);
            if (this.i != null && actionMasked == 2 && !this.I && Math.abs(this.O - motionEvent.getY()) > this.i.getTouchSlop()) {
                this.i.captureChildView(v, motionEvent.getPointerId(motionEvent.getActionIndex()));
            }
            return !this.I;
        }
        return false;
    }
}
