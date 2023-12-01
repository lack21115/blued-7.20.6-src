package com.baidu.mobads.sdk.internal.widget;

import android.util.DisplayMetrics;
import android.view.View;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

/* loaded from: source-8756600-dex2jar.jar:com/baidu/mobads/sdk/internal/widget/PagerSnapHelper.class */
public class PagerSnapHelper extends SnapHelper {

    /* renamed from: a  reason: collision with root package name */
    private static final int f9452a = 100;
    private static final float b = 100.0f;

    /* renamed from: c  reason: collision with root package name */
    private OrientationHelper f9453c;
    private OrientationHelper d;
    private RecyclerView e;

    private int a(RecyclerView.LayoutManager layoutManager, View view, OrientationHelper orientationHelper) {
        return (orientationHelper.getDecoratedStart(view) + (orientationHelper.getDecoratedMeasurement(view) / 2)) - (orientationHelper.getStartAfterPadding() + (orientationHelper.getTotalSpace() / 2));
    }

    private View a(RecyclerView.LayoutManager layoutManager, OrientationHelper orientationHelper) {
        int childCount = layoutManager.getChildCount();
        View view = null;
        if (childCount == 0) {
            return null;
        }
        int startAfterPadding = orientationHelper.getStartAfterPadding();
        int totalSpace = orientationHelper.getTotalSpace() / 2;
        int i = Integer.MAX_VALUE;
        int i2 = 0;
        while (i2 < childCount) {
            View childAt = layoutManager.getChildAt(i2);
            int abs = Math.abs((orientationHelper.getDecoratedStart(childAt) + (orientationHelper.getDecoratedMeasurement(childAt) / 2)) - (startAfterPadding + totalSpace));
            int i3 = i;
            if (abs < i) {
                view = childAt;
                i3 = abs;
            }
            i2++;
            i = i3;
        }
        return view;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x003c, code lost:
        if (r0.y < 0.0f) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean a(androidx.recyclerview.widget.RecyclerView.LayoutManager r5) {
        /*
            r4 = this;
            r0 = r5
            int r0 = r0.getItemCount()
            r6 = r0
            r0 = r5
            boolean r0 = r0 instanceof androidx.recyclerview.widget.RecyclerView.SmoothScroller.ScrollVectorProvider
            r9 = r0
            r0 = 0
            r8 = r0
            r0 = r8
            r7 = r0
            r0 = r9
            if (r0 == 0) goto L41
            r0 = r5
            androidx.recyclerview.widget.RecyclerView$SmoothScroller$ScrollVectorProvider r0 = (androidx.recyclerview.widget.RecyclerView.SmoothScroller.ScrollVectorProvider) r0
            r1 = r6
            r2 = 1
            int r1 = r1 - r2
            android.graphics.PointF r0 = r0.computeScrollVectorForPosition(r1)
            r5 = r0
            r0 = r8
            r7 = r0
            r0 = r5
            if (r0 == 0) goto L41
            r0 = r5
            float r0 = r0.x
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 < 0) goto L3f
            r0 = r8
            r7 = r0
            r0 = r5
            float r0 = r0.y
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 >= 0) goto L41
        L3f:
            r0 = 1
            r7 = r0
        L41:
            r0 = r7
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.sdk.internal.widget.PagerSnapHelper.a(androidx.recyclerview.widget.RecyclerView$LayoutManager):boolean");
    }

    private boolean a(RecyclerView.LayoutManager layoutManager, int i, int i2) {
        return layoutManager.canScrollHorizontally() ? i > 0 : i2 > 0;
    }

    private OrientationHelper b(RecyclerView.LayoutManager layoutManager) {
        if (layoutManager.canScrollVertically()) {
            return c(layoutManager);
        }
        if (layoutManager.canScrollHorizontally()) {
            return d(layoutManager);
        }
        return null;
    }

    private OrientationHelper c(RecyclerView.LayoutManager layoutManager) {
        OrientationHelper orientationHelper = this.f9453c;
        if (orientationHelper == null || orientationHelper.getLayoutManager() != layoutManager) {
            this.f9453c = OrientationHelper.createVerticalHelper(layoutManager);
        }
        return this.f9453c;
    }

    private OrientationHelper d(RecyclerView.LayoutManager layoutManager) {
        OrientationHelper orientationHelper = this.d;
        if (orientationHelper == null || orientationHelper.getLayoutManager() != layoutManager) {
            this.d = OrientationHelper.createHorizontalHelper(layoutManager);
        }
        return this.d;
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    public void attachToRecyclerView(RecyclerView recyclerView) {
        super.attachToRecyclerView(recyclerView);
        if (this.e == recyclerView) {
            return;
        }
        this.e = recyclerView;
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    public int[] calculateDistanceToFinalSnap(RecyclerView.LayoutManager layoutManager, View view) {
        int[] iArr = new int[2];
        if (layoutManager.canScrollHorizontally()) {
            iArr[0] = a(layoutManager, view, d(layoutManager));
        } else {
            iArr[0] = 0;
        }
        if (layoutManager.canScrollVertically()) {
            iArr[1] = a(layoutManager, view, c(layoutManager));
            return iArr;
        }
        iArr[1] = 0;
        return iArr;
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    public LinearSmoothScroller createSnapScroller(RecyclerView.LayoutManager layoutManager) {
        RecyclerView recyclerView;
        if (!(layoutManager instanceof RecyclerView.SmoothScroller.ScrollVectorProvider) || (recyclerView = this.e) == null) {
            return null;
        }
        return new LinearSmoothScroller(recyclerView.getContext()) { // from class: com.baidu.mobads.sdk.internal.widget.PagerSnapHelper.1
            @Override // androidx.recyclerview.widget.LinearSmoothScroller
            public float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
                return 100.0f / displayMetrics.densityDpi;
            }

            @Override // androidx.recyclerview.widget.LinearSmoothScroller
            public int calculateTimeForScrolling(int i) {
                return Math.min(100, super.calculateTimeForScrolling(i));
            }

            @Override // androidx.recyclerview.widget.LinearSmoothScroller, androidx.recyclerview.widget.RecyclerView.SmoothScroller
            public void onStop() {
                RecyclerView.LayoutManager layoutManager2;
                super.onStop();
                if (PagerSnapHelper.this.e == null || PagerSnapHelper.this.e.getScrollState() == 0 || (layoutManager2 = PagerSnapHelper.this.e.getLayoutManager()) == null || layoutManager2.getChildCount() > 1) {
                    return;
                }
                PagerSnapHelper.this.e.stopScroll();
            }

            @Override // androidx.recyclerview.widget.LinearSmoothScroller, androidx.recyclerview.widget.RecyclerView.SmoothScroller
            public void onTargetFound(View view, RecyclerView.State state, RecyclerView.SmoothScroller.Action action) {
                if (PagerSnapHelper.this.e == null || PagerSnapHelper.this.e.getLayoutManager() == null) {
                    return;
                }
                PagerSnapHelper pagerSnapHelper = PagerSnapHelper.this;
                int[] calculateDistanceToFinalSnap = pagerSnapHelper.calculateDistanceToFinalSnap(pagerSnapHelper.e.getLayoutManager(), view);
                int i = calculateDistanceToFinalSnap[0];
                int i2 = calculateDistanceToFinalSnap[1];
                int calculateTimeForDeceleration = calculateTimeForDeceleration(Math.max(Math.abs(i), Math.abs(i2)));
                if (calculateTimeForDeceleration > 0) {
                    action.update(i, i2, calculateTimeForDeceleration, this.mDecelerateInterpolator);
                }
            }
        };
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    public View findSnapView(RecyclerView.LayoutManager layoutManager) {
        if (layoutManager.canScrollVertically()) {
            return a(layoutManager, c(layoutManager));
        }
        if (layoutManager.canScrollHorizontally()) {
            return a(layoutManager, d(layoutManager));
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    public int findTargetSnapPosition(RecyclerView.LayoutManager layoutManager, int i, int i2) {
        OrientationHelper b2;
        int i3;
        View view;
        int itemCount = layoutManager.getItemCount();
        if (itemCount == 0 || (b2 = b(layoutManager)) == null) {
            return -1;
        }
        int i4 = Integer.MIN_VALUE;
        int i5 = Integer.MAX_VALUE;
        int childCount = layoutManager.getChildCount();
        int i6 = 0;
        View view2 = null;
        View view3 = null;
        while (i6 < childCount) {
            View childAt = layoutManager.getChildAt(i6);
            if (childAt == null) {
                i3 = i5;
                view = view2;
            } else {
                int a2 = a(layoutManager, childAt, b2);
                int i7 = i4;
                View view4 = view3;
                if (a2 <= 0) {
                    i7 = i4;
                    view4 = view3;
                    if (a2 > i4) {
                        view4 = childAt;
                        i7 = a2;
                    }
                }
                i4 = i7;
                i3 = i5;
                view = view2;
                view3 = view4;
                if (a2 >= 0) {
                    i4 = i7;
                    i3 = i5;
                    view = view2;
                    view3 = view4;
                    if (a2 < i5) {
                        view3 = view4;
                        view = childAt;
                        i3 = a2;
                        i4 = i7;
                    }
                }
            }
            i6++;
            i5 = i3;
            view2 = view;
        }
        boolean a3 = a(layoutManager, i, i2);
        if (!a3 || view2 == null) {
            if (a3 || view3 == null) {
                if (a3) {
                    view2 = view3;
                }
                if (view2 == null) {
                    return -1;
                }
                int position = layoutManager.getPosition(view2) + (a(layoutManager) == a3 ? -1 : 1);
                if (position < 0 || position >= itemCount) {
                    return -1;
                }
                return position;
            }
            return layoutManager.getPosition(view3);
        }
        return layoutManager.getPosition(view2);
    }
}
