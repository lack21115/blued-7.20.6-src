package androidx.recyclerview.widget;

import android.graphics.PointF;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: source-8756600-dex2jar.jar:androidx/recyclerview/widget/LinearSnapHelper.class */
public class LinearSnapHelper extends SnapHelper {

    /* renamed from: a  reason: collision with root package name */
    private OrientationHelper f3298a;
    private OrientationHelper b;

    private int a(RecyclerView.LayoutManager layoutManager, View view, OrientationHelper orientationHelper) {
        return (orientationHelper.getDecoratedStart(view) + (orientationHelper.getDecoratedMeasurement(view) / 2)) - (orientationHelper.getStartAfterPadding() + (orientationHelper.getTotalSpace() / 2));
    }

    private int a(RecyclerView.LayoutManager layoutManager, OrientationHelper orientationHelper, int i, int i2) {
        int[] calculateScrollDistance = calculateScrollDistance(i, i2);
        float b = b(layoutManager, orientationHelper);
        if (b <= 0.0f) {
            return 0;
        }
        return Math.round((Math.abs(calculateScrollDistance[0]) > Math.abs(calculateScrollDistance[1]) ? calculateScrollDistance[0] : calculateScrollDistance[1]) / b);
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

    private OrientationHelper a(RecyclerView.LayoutManager layoutManager) {
        OrientationHelper orientationHelper = this.f3298a;
        if (orientationHelper == null || orientationHelper.f3311a != layoutManager) {
            this.f3298a = OrientationHelper.createVerticalHelper(layoutManager);
        }
        return this.f3298a;
    }

    private float b(RecyclerView.LayoutManager layoutManager, OrientationHelper orientationHelper) {
        int i;
        View view;
        int i2;
        int childCount = layoutManager.getChildCount();
        if (childCount == 0) {
            return 1.0f;
        }
        int i3 = 0;
        View view2 = null;
        View view3 = null;
        int i4 = Integer.MAX_VALUE;
        int i5 = Integer.MIN_VALUE;
        while (true) {
            i = i5;
            if (i3 >= childCount) {
                break;
            }
            View childAt = layoutManager.getChildAt(i3);
            int position = layoutManager.getPosition(childAt);
            if (position == -1) {
                view = view2;
                i2 = i;
            } else {
                int i6 = i4;
                if (position < i4) {
                    view2 = childAt;
                    i6 = position;
                }
                view = view2;
                i4 = i6;
                i2 = i;
                if (position > i) {
                    view3 = childAt;
                    i2 = position;
                    i4 = i6;
                    view = view2;
                }
            }
            i3++;
            view2 = view;
            i5 = i2;
        }
        if (view2 == null || view3 == null) {
            return 1.0f;
        }
        int max = Math.max(orientationHelper.getDecoratedEnd(view2), orientationHelper.getDecoratedEnd(view3)) - Math.min(orientationHelper.getDecoratedStart(view2), orientationHelper.getDecoratedStart(view3));
        if (max == 0) {
            return 1.0f;
        }
        return (max * 1.0f) / ((i - i4) + 1);
    }

    private OrientationHelper b(RecyclerView.LayoutManager layoutManager) {
        OrientationHelper orientationHelper = this.b;
        if (orientationHelper == null || orientationHelper.f3311a != layoutManager) {
            this.b = OrientationHelper.createHorizontalHelper(layoutManager);
        }
        return this.b;
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    public int[] calculateDistanceToFinalSnap(RecyclerView.LayoutManager layoutManager, View view) {
        int[] iArr = new int[2];
        if (layoutManager.canScrollHorizontally()) {
            iArr[0] = a(layoutManager, view, b(layoutManager));
        } else {
            iArr[0] = 0;
        }
        if (layoutManager.canScrollVertically()) {
            iArr[1] = a(layoutManager, view, a(layoutManager));
            return iArr;
        }
        iArr[1] = 0;
        return iArr;
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    public View findSnapView(RecyclerView.LayoutManager layoutManager) {
        if (layoutManager.canScrollVertically()) {
            return a(layoutManager, a(layoutManager));
        }
        if (layoutManager.canScrollHorizontally()) {
            return a(layoutManager, b(layoutManager));
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    public int findTargetSnapPosition(RecyclerView.LayoutManager layoutManager, int i, int i2) {
        int itemCount;
        View findSnapView;
        int position;
        int i3;
        PointF computeScrollVectorForPosition;
        int i4;
        int i5;
        if (!(layoutManager instanceof RecyclerView.SmoothScroller.ScrollVectorProvider) || (itemCount = layoutManager.getItemCount()) == 0 || (findSnapView = findSnapView(layoutManager)) == null || (position = layoutManager.getPosition(findSnapView)) == -1 || (computeScrollVectorForPosition = ((RecyclerView.SmoothScroller.ScrollVectorProvider) layoutManager).computeScrollVectorForPosition((i3 = itemCount - 1))) == null) {
            return -1;
        }
        if (layoutManager.canScrollHorizontally()) {
            int a2 = a(layoutManager, b(layoutManager), i, 0);
            i4 = a2;
            if (computeScrollVectorForPosition.x < 0.0f) {
                i4 = -a2;
            }
        } else {
            i4 = 0;
        }
        if (layoutManager.canScrollVertically()) {
            int a3 = a(layoutManager, a(layoutManager), 0, i2);
            i5 = a3;
            if (computeScrollVectorForPosition.y < 0.0f) {
                i5 = -a3;
            }
        } else {
            i5 = 0;
        }
        if (layoutManager.canScrollVertically()) {
            i4 = i5;
        }
        if (i4 == 0) {
            return -1;
        }
        int i6 = position + i4;
        if (i6 < 0) {
            i6 = 0;
        }
        return i6 >= itemCount ? i3 : i6;
    }
}
