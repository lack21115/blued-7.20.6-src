package com.blued.android.kbswitch;

import android.animation.TimeInterpolator;
import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.EditText;
import android.widget.ListView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.recyclerview.widget.RecyclerView;
import androidx.transition.ChangeBounds;
import androidx.transition.TransitionManager;
import androidx.transition.TransitionSet;
import com.blued.android.kbswitch.KBConstants;
import com.blued.android.kbswitch.utils.UtilsKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-4169892-dex2jar.jar:com/blued/android/kbswitch/KeyboardConstraintLayout.class */
public final class KeyboardConstraintLayout extends ConstraintLayout {

    /* renamed from: a  reason: collision with root package name */
    private TransitionSet f10415a;
    private final ConstraintSet b;

    /* renamed from: c  reason: collision with root package name */
    private final ConstraintSet f10416c;
    private final ConstraintSet d;
    private KBConstants.KeyboardStatus e;
    private KBConstants.KeyboardStatus f;
    private int g;
    private Rect h;
    private Rect i;
    private View j;
    private int k;
    private View l;
    private ViewGroup m;
    private View n;
    private View o;
    private KeyboardHelper p;

    @Metadata
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/kbswitch/KeyboardConstraintLayout$WhenMappings.class */
    public final /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f10417a;

        static {
            int[] iArr = new int[KBConstants.KeyboardStatus.values().length];
            iArr[KBConstants.KeyboardStatus.KB_STATUS_NONE.ordinal()] = 1;
            iArr[KBConstants.KeyboardStatus.KB_STATUS_KEYBOARD.ordinal()] = 2;
            iArr[KBConstants.KeyboardStatus.KB_STATUS_PANEL.ordinal()] = 3;
            f10417a = iArr;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public KeyboardConstraintLayout(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.e(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public KeyboardConstraintLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.e(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KeyboardConstraintLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.e(context, "context");
        TransitionSet transitionSet = new TransitionSet();
        transitionSet.setOrdering(0);
        transitionSet.addTransition(new ChangeBounds());
        this.f10415a = transitionSet;
        this.b = new ConstraintSet();
        this.f10416c = new ConstraintSet();
        this.d = new ConstraintSet();
        this.e = KBConstants.KeyboardStatus.KB_STATUS_NONE;
        this.f = KBConstants.KeyboardStatus.KB_STATUS_NONE;
        this.h = new Rect();
        Activity activity = context instanceof Activity ? (Activity) context : null;
        this.p = activity == null ? null : KeyboardHelper.f10418a.a(activity);
        try {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.KeyboardConstraintLayout);
            Intrinsics.c(obtainStyledAttributes, "context.obtainStyledAttr…KeyboardConstraintLayout)");
            Integer valueOf = Integer.valueOf(obtainStyledAttributes.getResourceId(R.styleable.KeyboardConstraintLayout_kb_expand_kb_constraint, -1));
            valueOf = valueOf.intValue() > 0 ? valueOf : null;
            if (valueOf != null) {
                this.b.load(context, valueOf.intValue());
            }
            Integer valueOf2 = Integer.valueOf(obtainStyledAttributes.getResourceId(R.styleable.KeyboardConstraintLayout_kb_expand_panel_constraint, -1));
            valueOf2 = valueOf2.intValue() > 0 ? valueOf2 : null;
            if (valueOf2 != null) {
                this.f10416c.load(context, valueOf2.intValue());
            }
            Integer valueOf3 = Integer.valueOf(obtainStyledAttributes.getResourceId(R.styleable.KeyboardConstraintLayout_kb_reset_constraint, -1));
            Integer num = valueOf3.intValue() > 0 ? valueOf3 : null;
            if (num != null) {
                this.d.load(context, num.intValue());
            }
            obtainStyledAttributes.recycle();
        } catch (Throwable th) {
        }
    }

    public /* synthetic */ KeyboardConstraintLayout(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    private static final EditText a(ViewGroup viewGroup) {
        int childCount = viewGroup.getChildCount();
        EditText editText = null;
        if (childCount > 0) {
            int i = 0;
            editText = null;
            while (true) {
                int i2 = i + 1;
                View childAt = viewGroup.getChildAt(i);
                Intrinsics.c(childAt, "getChildAt(index)");
                if (editText == null) {
                    if (childAt instanceof EditText) {
                        editText = childAt;
                    } else if (childAt instanceof ViewGroup) {
                        editText = a((ViewGroup) childAt);
                    }
                }
                if (i2 >= childCount) {
                    break;
                }
                i = i2;
            }
        }
        return editText;
    }

    private final void a(int i) {
        TransitionSet transitionSet = new TransitionSet();
        transitionSet.setOrdering(0);
        transitionSet.addTransition(new ChangeBounds());
        this.f10415a = transitionSet;
        View view = this.l;
        if (view == null) {
            return;
        }
        ViewGroup viewGroup = this.m;
        if (viewGroup == null || i == 0) {
            this.f10415a.addTransition(new CustomTransition().addTarget(view));
        } else if (viewGroup == null) {
        } else {
            if (viewGroup.getChildCount() <= 0) {
                this.f10415a.addTransition(new CustomTransition().addTarget(view));
                return;
            }
            if (i - (view.getBottom() - viewGroup.getChildAt(viewGroup.getChildCount() - 1).getBottom()) <= 0) {
                this.f10415a.addTransition(new CustomTransition().addTarget(view));
                return;
            }
            TransitionSet addTarget = this.f10415a.addTarget(view);
            View view2 = this.o;
            View view3 = view2;
            if (view2 == null) {
                Intrinsics.c("panelView");
                view3 = null;
            }
            TransitionSet addTarget2 = addTarget.addTarget(view3);
            View view4 = this.n;
            if (view4 == null) {
                Intrinsics.c("inputView");
                view4 = null;
            }
            addTarget2.addTarget(view4);
        }
    }

    private final void a(View view) {
        if (view == null) {
            return;
        }
        if (!(view instanceof ViewGroup)) {
            view = null;
        }
        if (view == null) {
            return;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int i = 0;
        int childCount = viewGroup.getChildCount();
        if (childCount <= 0) {
            return;
        }
        while (true) {
            int i2 = i + 1;
            View childAt = viewGroup.getChildAt(i);
            Intrinsics.c(childAt, "getChildAt(index)");
            if ((childAt instanceof RecyclerView) || (childAt instanceof ListView)) {
                this.m = (ViewGroup) childAt;
            } else if (childAt instanceof ViewGroup) {
                a(childAt);
            }
            if (i2 >= childCount) {
                return;
            }
            i = i2;
        }
    }

    static /* synthetic */ void a(KeyboardConstraintLayout keyboardConstraintLayout, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        keyboardConstraintLayout.a(i);
    }

    private static final RecyclerView b(View view) {
        if (view instanceof RecyclerView) {
            return (RecyclerView) view;
        }
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int i = 0;
        int childCount = viewGroup.getChildCount();
        if (childCount <= 0) {
            return null;
        }
        while (true) {
            int i2 = i + 1;
            View childAt = viewGroup.getChildAt(i);
            Intrinsics.c(childAt, "getChildAt(index)");
            RecyclerView b = b(childAt);
            if (b != null) {
                return b;
            }
            if (i2 >= childCount) {
                return null;
            }
            i = i2;
        }
    }

    private final void f() {
        KeyboardConstraintLayout keyboardConstraintLayout = this;
        int childCount = keyboardConstraintLayout.getChildCount();
        if (childCount <= 0) {
            return;
        }
        int i = 0;
        boolean z = false;
        boolean z2 = false;
        while (true) {
            int i2 = i + 1;
            View childAt = keyboardConstraintLayout.getChildAt(i);
            Intrinsics.c(childAt, "getChildAt(index)");
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            if (layoutParams == null) {
                throw new NullPointerException("null cannot be cast to non-null type com.blued.android.kbswitch.IKBLayoutParams");
            }
            int a2 = ((IKBLayoutParams) layoutParams).a();
            if (a2 != 1) {
                if (a2 != 2) {
                    if (a2 == 3) {
                        this.n = childAt;
                    } else if (a2 == 5) {
                        this.j = childAt;
                    }
                } else if (z2) {
                    throw new IllegalStateException("只能设置一个panel");
                } else {
                    this.o = childAt;
                    z2 = true;
                }
            } else if (z) {
                throw new IllegalStateException("只能设置一个content");
            } else {
                this.l = childAt;
                a(childAt);
                z = true;
            }
            if (i2 >= childCount) {
                return;
            }
            i = i2;
        }
    }

    private final void g() {
        View view = this.l;
        if (!(this.g == 0)) {
            view = null;
        }
        if (view == null) {
            return;
        }
        this.g = view.getHeight();
        view.requestLayout();
    }

    private final void h() {
        View view = this.l;
        if (!(this.i == null)) {
            view = null;
        }
        if (view == null) {
            return;
        }
        this.i = new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    /* renamed from: a */
    public KBLayoutParams generateDefaultLayoutParams() {
        return new KBLayoutParams(-2, -2);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    /* renamed from: a */
    public KBLayoutParams generateLayoutParams(AttributeSet attributeSet) {
        Context context = getContext();
        Intrinsics.c(context, "context");
        return new KBLayoutParams(context, attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    /* renamed from: a */
    public KBLayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ConstraintLayout.LayoutParams ? new KBLayoutParams((ConstraintLayout.LayoutParams) layoutParams) : new KBLayoutParams(layoutParams);
    }

    public final void a(KeyboardHelper helper, int i) {
        TimeInterpolator decelerateInterpolator;
        TimeInterpolator timeInterpolator;
        ConstraintSet constraintSet;
        TimeInterpolator linearInterpolator;
        KeyboardHelper keyboardHelper;
        Intrinsics.e(helper, "helper");
        this.e = this.f;
        this.f = helper.d();
        long j = 230;
        switch (i) {
            case 0:
            case 2:
                if (i == 0) {
                    decelerateInterpolator = new DecelerateInterpolator(2.0f);
                    j = 180;
                } else {
                    decelerateInterpolator = new DecelerateInterpolator(1.2f);
                }
                timeInterpolator = decelerateInterpolator;
                constraintSet = this.d;
                break;
            case 1:
            case 5:
            case 6:
                if (i == 1 || i == 6) {
                    linearInterpolator = new LinearInterpolator();
                    j = 210;
                } else {
                    linearInterpolator = new DecelerateInterpolator(1.2f);
                }
                View view = this.j;
                if (view != null) {
                    ConstraintSet constraintSet2 = this.f10416c;
                    View view2 = this.o;
                    View view3 = view2;
                    if (view2 == null) {
                        Intrinsics.c("panelView");
                        view3 = null;
                    }
                    constraintSet2.setMargin(view3.getId(), 3, (getHeight() - view.getBottom()) - helper.e());
                }
                ConstraintSet constraintSet3 = this.f10416c;
                if (i == 5 && (keyboardHelper = this.p) != null) {
                    a(keyboardHelper.e());
                }
                timeInterpolator = linearInterpolator;
                constraintSet = constraintSet3;
                break;
            case 3:
            case 4:
                if (i == 3) {
                    int b = helper.b();
                    View view4 = this.o;
                    View view5 = view4;
                    if (view4 == null) {
                        Intrinsics.c("panelView");
                        view5 = null;
                    }
                    if (b + view5.getTop() == getHeight()) {
                        return;
                    }
                }
                View view6 = this.j;
                if (view6 != null) {
                    ConstraintSet constraintSet4 = this.b;
                    View view7 = this.o;
                    View view8 = view7;
                    if (view7 == null) {
                        Intrinsics.c("panelView");
                        view8 = null;
                    }
                    constraintSet4.setMargin(view8.getId(), 3, (getHeight() - view6.getBottom()) - helper.b());
                }
                TimeInterpolator accelerateDecelerateInterpolator = i == 4 ? new AccelerateDecelerateInterpolator() : new LinearInterpolator();
                ConstraintSet constraintSet5 = this.b;
                timeInterpolator = accelerateDecelerateInterpolator;
                j = 170;
                constraintSet = constraintSet5;
                if (i == 4) {
                    KeyboardHelper keyboardHelper2 = this.p;
                    if (keyboardHelper2 != null) {
                        a(keyboardHelper2.b());
                        timeInterpolator = accelerateDecelerateInterpolator;
                        j = 170;
                        constraintSet = constraintSet5;
                        break;
                    } else {
                        timeInterpolator = accelerateDecelerateInterpolator;
                        j = 170;
                        constraintSet = constraintSet5;
                        break;
                    }
                }
                break;
            default:
                j = 0;
                timeInterpolator = null;
                constraintSet = null;
                break;
        }
        if (constraintSet == null) {
            return;
        }
        View view9 = this.l;
        if (view9 != null) {
            View view10 = null;
            if (constraintSet.getHeight(view9.getId()) != this.g) {
                view10 = view9;
            }
            if (view10 != null) {
                constraintSet.constrainHeight(view10.getId(), this.g);
            }
        }
        if (this.e != this.f) {
            this.f10415a.setDuration(j);
            this.f10415a.setInterpolator(timeInterpolator);
            TransitionManager.beginDelayedTransition(this, this.f10415a);
        } else if (UtilsKt.a(KBConstants.KeyboardStatus.KB_STATUS_KEYBOARD, this.e, this.f) || UtilsKt.a(KBConstants.KeyboardStatus.KB_STATUS_PANEL, this.e, this.f)) {
            this.f10415a.setDuration(125L);
            this.f10415a.setInterpolator((TimeInterpolator) new LinearInterpolator());
            TransitionManager.beginDelayedTransition(this, this.f10415a);
        }
        View view11 = this.l;
        if (view11 != null) {
            int i2 = WhenMappings.f10417a[this.f.ordinal()];
            int i3 = 0;
            if (i2 != 1) {
                if (i2 == 2) {
                    i3 = helper.b();
                } else if (i2 != 3) {
                    throw new NoWhenBranchMatchedException();
                } else {
                    i3 = helper.e();
                }
            }
            this.k = i3;
            view11.setPadding(view11.getPaddingLeft(), i3, view11.getPaddingRight(), view11.getPaddingBottom());
        }
        constraintSet.applyToWithoutCustom(this);
    }

    public final EditText b() {
        KeyboardConstraintLayout keyboardConstraintLayout = this;
        int childCount = keyboardConstraintLayout.getChildCount();
        EditText editText = null;
        EditText editText2 = null;
        if (childCount > 0) {
            int i = 0;
            while (true) {
                int i2 = i + 1;
                View childAt = keyboardConstraintLayout.getChildAt(i);
                Intrinsics.c(childAt, "getChildAt(index)");
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                if (layoutParams == null) {
                    throw new NullPointerException("null cannot be cast to non-null type com.blued.android.kbswitch.KBLayoutParams");
                }
                editText = editText2;
                if (((KBLayoutParams) layoutParams).a() == 3) {
                    if (childAt instanceof EditText) {
                        editText = childAt;
                    } else {
                        editText = editText2;
                        if (childAt instanceof ViewGroup) {
                            editText = a((ViewGroup) childAt);
                        }
                    }
                }
                if (i2 >= childCount) {
                    break;
                }
                i = i2;
                editText2 = editText;
            }
        }
        return editText;
    }

    public final View c() {
        return this.l;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof KBLayoutParams;
    }

    public final RecyclerView d() {
        View view = this.l;
        if (view == null) {
            return null;
        }
        return b(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View child, long j) {
        View view;
        Intrinsics.e(canvas, "canvas");
        Intrinsics.e(child, "child");
        try {
            if (this.i == null) {
                return super.drawChild(canvas, child, j);
            }
            if ((this.f != KBConstants.KeyboardStatus.KB_STATUS_NONE || this.e != this.f) && Intrinsics.a(child, this.l)) {
                Rect rect = this.i;
                if (rect != null && (view = this.j) != null) {
                    this.h.set(rect.left, view.getBottom(), rect.right, rect.bottom);
                }
                Rect rect2 = this.h;
                canvas.save();
                canvas.clipRect(rect2);
                boolean drawChild = super.drawChild(canvas, child, j);
                canvas.restore();
                return drawChild;
            }
            return super.drawChild(canvas, child, j);
        } catch (Throwable th) {
            return false;
        }
    }

    public final List<Pair<View, View>> e() {
        List<Pair<View, View>> list;
        KeyboardConstraintLayout keyboardConstraintLayout = this;
        KeyboardConstraintLayout keyboardConstraintLayout2 = keyboardConstraintLayout;
        int childCount = keyboardConstraintLayout2.getChildCount();
        if (childCount <= 0) {
            return null;
        }
        List<Pair<View, View>> list2 = null;
        int i = 0;
        while (true) {
            int i2 = i + 1;
            View childAt = keyboardConstraintLayout2.getChildAt(i);
            Intrinsics.c(childAt, "getChildAt(index)");
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            if (layoutParams == null) {
                throw new NullPointerException("null cannot be cast to non-null type com.blued.android.kbswitch.KBLayoutParams");
            }
            KBLayoutParams kBLayoutParams = (KBLayoutParams) layoutParams;
            List<Pair<View, View>> list3 = list2;
            if (kBLayoutParams.a() == 4) {
                if (list2 == null) {
                    list = null;
                } else {
                    list2.add(new Pair<>(childAt, keyboardConstraintLayout.findViewById(kBLayoutParams.b())));
                    list = list2;
                }
                list3 = list2;
                if (list == null) {
                    list3 = CollectionsKt.c(new Pair(childAt, keyboardConstraintLayout.findViewById(kBLayoutParams.b())));
                }
            }
            if (i2 >= childCount) {
                return list3;
            }
            i = i2;
            list2 = list3;
        }
    }

    public final KeyboardHelper getKeyboardHelper() {
        return this.p;
    }

    public final View getPanelView() {
        View view = this.o;
        View view2 = view;
        if (view == null) {
            Intrinsics.c("panelView");
            view2 = null;
        }
        return view2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        KeyboardHelper keyboardHelper = this.p;
        if (keyboardHelper == null) {
            return;
        }
        keyboardHelper.a(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        f();
        a(this, 0, 1, null);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        g();
        h();
    }

    public final void setKeyboardHelper(KeyboardHelper keyboardHelper) {
        this.p = keyboardHelper;
    }
}
