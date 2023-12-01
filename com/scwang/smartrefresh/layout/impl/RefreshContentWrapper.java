package com.scwang.smartrefresh.layout.impl;

import android.animation.ValueAnimator;
import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.NestedScrollingParent;
import androidx.legacy.widget.Space;
import com.scwang.smartrefresh.layout.api.RefreshContent;
import com.scwang.smartrefresh.layout.api.RefreshKernel;
import com.scwang.smartrefresh.layout.api.ScrollBoundaryDecider;
import com.scwang.smartrefresh.layout.listener.CoordinatorLayoutListener;
import com.scwang.smartrefresh.layout.util.DesignUtil;
import com.scwang.smartrefresh.layout.util.ScrollBoundaryUtil;
import com.scwang.smartrefresh.layout.util.SmartUtil;
import java.util.Collections;
import java.util.LinkedList;

/* loaded from: source-8303388-dex2jar.jar:com/scwang/smartrefresh/layout/impl/RefreshContentWrapper.class */
public class RefreshContentWrapper implements ValueAnimator.AnimatorUpdateListener, RefreshContent, CoordinatorLayoutListener {

    /* renamed from: a  reason: collision with root package name */
    protected View f27990a;
    protected View b;

    /* renamed from: c  reason: collision with root package name */
    protected View f27991c;
    protected View d;
    protected View e;
    protected int f = 0;
    protected boolean g = true;
    protected boolean h = true;
    protected ScrollBoundaryDeciderAdapter i = new ScrollBoundaryDeciderAdapter();

    public RefreshContentWrapper(View view) {
        this.f27991c = view;
        this.b = view;
        this.f27990a = view;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshContent
    public ValueAnimator.AnimatorUpdateListener a(int i) {
        View view = this.f27991c;
        if (view == null || i == 0) {
            return null;
        }
        if ((i >= 0 || !ScrollBoundaryUtil.b(view)) && (i <= 0 || !ScrollBoundaryUtil.a(this.f27991c))) {
            return null;
        }
        this.f = i;
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshContent
    public View a() {
        return this.f27990a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0051, code lost:
        if (com.scwang.smartrefresh.layout.util.SmartUtil.c(r0) == false) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected android.view.View a(android.view.View r7, android.graphics.PointF r8, android.view.View r9) {
        /*
            r6 = this;
            r0 = r7
            boolean r0 = r0 instanceof android.view.ViewGroup
            if (r0 == 0) goto L86
            r0 = r8
            if (r0 == 0) goto L86
            r0 = r7
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0
            r7 = r0
            r0 = r7
            int r0 = r0.getChildCount()
            r10 = r0
            android.graphics.PointF r0 = new android.graphics.PointF
            r1 = r0
            r1.<init>()
            r12 = r0
        L1f:
            r0 = r10
            if (r0 <= 0) goto L86
            r0 = r7
            r1 = r10
            r2 = 1
            int r1 = r1 - r2
            android.view.View r0 = r0.getChildAt(r1)
            r11 = r0
            r0 = r7
            r1 = r11
            r2 = r8
            float r2 = r2.x
            r3 = r8
            float r3 = r3.y
            r4 = r12
            boolean r0 = com.scwang.smartrefresh.layout.util.ScrollBoundaryUtil.a(r0, r1, r2, r3, r4)
            if (r0 == 0) goto L7d
            r0 = r11
            boolean r0 = r0 instanceof androidx.viewpager.widget.ViewPager
            if (r0 != 0) goto L54
            r0 = r11
            r7 = r0
            r0 = r11
            boolean r0 = com.scwang.smartrefresh.layout.util.SmartUtil.c(r0)
            if (r0 != 0) goto L7b
        L54:
            r0 = r8
            r1 = r12
            float r1 = r1.x
            r2 = r12
            float r2 = r2.y
            r0.offset(r1, r2)
            r0 = r6
            r1 = r11
            r2 = r8
            r3 = r9
            android.view.View r0 = r0.a(r1, r2, r3)
            r7 = r0
            r0 = r8
            r1 = r12
            float r1 = r1.x
            float r1 = -r1
            r2 = r12
            float r2 = r2.y
            float r2 = -r2
            r0.offset(r1, r2)
        L7b:
            r0 = r7
            return r0
        L7d:
            r0 = r10
            r1 = 1
            int r0 = r0 - r1
            r10 = r0
            goto L1f
        L86:
            r0 = r9
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.scwang.smartrefresh.layout.impl.RefreshContentWrapper.a(android.view.View, android.graphics.PointF, android.view.View):android.view.View");
    }

    protected View a(View view, boolean z) {
        LinkedList linkedList = new LinkedList(Collections.singletonList(view));
        View view2 = null;
        while (!linkedList.isEmpty() && view2 == null) {
            View view3 = (View) linkedList.poll();
            if (view3 != null) {
                if ((z || view3 != view) && SmartUtil.c(view3)) {
                    view2 = view3;
                } else if (view3 instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view3;
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < viewGroup.getChildCount()) {
                            linkedList.add(viewGroup.getChildAt(i2));
                            i = i2 + 1;
                        }
                    }
                }
            }
        }
        return view2 == null ? view : view2;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    @Override // com.scwang.smartrefresh.layout.api.RefreshContent
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(int r5, int r6, int r7) {
        /*
            r4 = this;
            r0 = 1
            r8 = r0
            r0 = r6
            r1 = -1
            if (r0 == r1) goto L37
            r0 = r4
            android.view.View r0 = r0.b
            r1 = r6
            android.view.View r0 = r0.findViewById(r1)
            r9 = r0
            r0 = r9
            if (r0 == 0) goto L37
            r0 = r5
            if (r0 <= 0) goto L27
            r0 = r9
            r1 = r5
            float r1 = (float) r1
            r0.setTranslationY(r1)
            r0 = 1
            r6 = r0
            goto L39
        L27:
            r0 = r9
            float r0 = r0.getTranslationY()
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 <= 0) goto L37
            r0 = r9
            r1 = 0
            r0.setTranslationY(r1)
        L37:
            r0 = 0
            r6 = r0
        L39:
            r0 = r7
            r1 = -1
            if (r0 == r1) goto L6e
            r0 = r4
            android.view.View r0 = r0.b
            r1 = r7
            android.view.View r0 = r0.findViewById(r1)
            r9 = r0
            r0 = r9
            if (r0 == 0) goto L6e
            r0 = r5
            if (r0 >= 0) goto L5e
            r0 = r9
            r1 = r5
            float r1 = (float) r1
            r0.setTranslationY(r1)
            r0 = r8
            r6 = r0
            goto L6e
        L5e:
            r0 = r9
            float r0 = r0.getTranslationY()
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 >= 0) goto L6e
            r0 = r9
            r1 = 0
            r0.setTranslationY(r1)
        L6e:
            r0 = r6
            if (r0 != 0) goto L7e
            r0 = r4
            android.view.View r0 = r0.b
            r1 = r5
            float r1 = (float) r1
            r0.setTranslationY(r1)
            goto L86
        L7e:
            r0 = r4
            android.view.View r0 = r0.b
            r1 = 0
            r0.setTranslationY(r1)
        L86:
            r0 = r4
            android.view.View r0 = r0.d
            r9 = r0
            r0 = r9
            if (r0 == 0) goto L9c
            r0 = r9
            r1 = 0
            r2 = r5
            int r1 = java.lang.Math.max(r1, r2)
            float r1 = (float) r1
            r0.setTranslationY(r1)
        L9c:
            r0 = r4
            android.view.View r0 = r0.e
            r9 = r0
            r0 = r9
            if (r0 == 0) goto Lb2
            r0 = r9
            r1 = 0
            r2 = r5
            int r1 = java.lang.Math.min(r1, r2)
            float r1 = (float) r1
            r0.setTranslationY(r1)
        Lb2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.scwang.smartrefresh.layout.impl.RefreshContentWrapper.a(int, int, int):void");
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshContent
    public void a(MotionEvent motionEvent) {
        PointF pointF = new PointF(motionEvent.getX(), motionEvent.getY());
        pointF.offset(-this.f27990a.getLeft(), -this.f27990a.getTop());
        View view = this.f27991c;
        View view2 = this.f27990a;
        if (view != view2) {
            this.f27991c = a(view2, pointF, view);
        }
        if (this.f27991c == this.f27990a) {
            this.i.f27992a = null;
        } else {
            this.i.f27992a = pointF;
        }
    }

    protected void a(View view, RefreshKernel refreshKernel) {
        View view2;
        boolean isInEditMode = this.f27990a.isInEditMode();
        View view3 = view;
        View view4 = null;
        while (true) {
            view2 = view4;
            if (view2 != null && (!(view2 instanceof NestedScrollingParent) || (view2 instanceof NestedScrollingChild))) {
                break;
            }
            view3 = a(view3, view2 == null);
            if (view3 == view2) {
                break;
            }
            if (!isInEditMode) {
                DesignUtil.a(view3, refreshKernel, this);
            }
            view4 = view3;
        }
        if (view2 != null) {
            this.f27991c = view2;
        }
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshContent
    public void a(RefreshKernel refreshKernel, View view, View view2) {
        a(this.f27990a, refreshKernel);
        if (view == null && view2 == null) {
            return;
        }
        this.d = view;
        this.e = view2;
        FrameLayout frameLayout = new FrameLayout(this.f27990a.getContext());
        refreshKernel.a().getLayout().removeView(this.f27990a);
        ViewGroup.LayoutParams layoutParams = this.f27990a.getLayoutParams();
        frameLayout.addView(this.f27990a, -1, -1);
        refreshKernel.a().getLayout().addView(frameLayout, layoutParams);
        this.f27990a = frameLayout;
        if (view != null) {
            view.setClickable(true);
            ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            int indexOfChild = viewGroup.indexOfChild(view);
            viewGroup.removeView(view);
            layoutParams2.height = SmartUtil.a(view);
            viewGroup.addView(new Space(this.f27990a.getContext()), indexOfChild, layoutParams2);
            frameLayout.addView(view);
        }
        if (view2 != null) {
            view2.setClickable(true);
            ViewGroup.LayoutParams layoutParams3 = view2.getLayoutParams();
            ViewGroup viewGroup2 = (ViewGroup) view2.getParent();
            int indexOfChild2 = viewGroup2.indexOfChild(view2);
            viewGroup2.removeView(view2);
            FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(layoutParams3);
            layoutParams3.height = SmartUtil.a(view2);
            viewGroup2.addView(new Space(this.f27990a.getContext()), indexOfChild2, layoutParams3);
            layoutParams4.gravity = 80;
            frameLayout.addView(view2, layoutParams4);
        }
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshContent
    public void a(ScrollBoundaryDecider scrollBoundaryDecider) {
        if (scrollBoundaryDecider instanceof ScrollBoundaryDeciderAdapter) {
            this.i = (ScrollBoundaryDeciderAdapter) scrollBoundaryDecider;
        } else {
            this.i.b = scrollBoundaryDecider;
        }
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshContent
    public void a(boolean z) {
        this.i.f27993c = z;
    }

    @Override // com.scwang.smartrefresh.layout.listener.CoordinatorLayoutListener
    public void a(boolean z, boolean z2) {
        this.g = z;
        this.h = z2;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshContent
    public View b() {
        return this.f27991c;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshContent
    public boolean c() {
        return this.g && this.i.a(this.f27990a);
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshContent
    public boolean d() {
        return this.h && this.i.b(this.f27990a);
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        try {
            if (this.f27991c instanceof AbsListView) {
                SmartUtil.a((AbsListView) this.f27991c, intValue - this.f);
            } else {
                this.f27991c.scrollBy(0, intValue - this.f);
            }
        } catch (Throwable th) {
        }
        this.f = intValue;
    }
}
