package com.blued.android.module.live_china.mine;

import android.view.View;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/mine/PagerGridSnapHelper.class */
public class PagerGridSnapHelper extends SnapHelper {

    /* renamed from: a  reason: collision with root package name */
    private RecyclerView f13878a;

    private boolean a(RecyclerView.LayoutManager layoutManager, int i, int i2) {
        LinearSmoothScroller createSnapScroller;
        int findTargetSnapPosition;
        if (!(layoutManager instanceof RecyclerView.SmoothScroller.ScrollVectorProvider) || (createSnapScroller = createSnapScroller(layoutManager)) == null || (findTargetSnapPosition = findTargetSnapPosition(layoutManager, i, i2)) == -1) {
            return false;
        }
        createSnapScroller.setTargetPosition(findTargetSnapPosition);
        layoutManager.startSmoothScroll(createSnapScroller);
        return true;
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    public void attachToRecyclerView(RecyclerView recyclerView) throws IllegalStateException {
        super.attachToRecyclerView(recyclerView);
        this.f13878a = recyclerView;
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    public int[] calculateDistanceToFinalSnap(RecyclerView.LayoutManager layoutManager, View view) {
        int position = layoutManager.getPosition(view);
        int[] iArr = new int[2];
        if (layoutManager instanceof PagerGridLayoutManager) {
            iArr = ((PagerGridLayoutManager) layoutManager).a(position);
        }
        return iArr;
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    public LinearSmoothScroller createSnapScroller(RecyclerView.LayoutManager layoutManager) {
        if (layoutManager instanceof RecyclerView.SmoothScroller.ScrollVectorProvider) {
            return new PagerGridSmoothScroller(this.f13878a);
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    public View findSnapView(RecyclerView.LayoutManager layoutManager) {
        if (layoutManager instanceof PagerGridLayoutManager) {
            return ((PagerGridLayoutManager) layoutManager).c();
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    public int findTargetSnapPosition(RecyclerView.LayoutManager layoutManager, int i, int i2) {
        if (layoutManager == null || !(layoutManager instanceof PagerGridLayoutManager)) {
            return -1;
        }
        PagerGridLayoutManager pagerGridLayoutManager = (PagerGridLayoutManager) layoutManager;
        if (pagerGridLayoutManager.canScrollHorizontally()) {
            if (i > PagerConfig.a()) {
                return pagerGridLayoutManager.a();
            }
            if (i < (-PagerConfig.a())) {
                return pagerGridLayoutManager.b();
            }
            return -1;
        } else if (pagerGridLayoutManager.canScrollVertically()) {
            if (i2 > PagerConfig.a()) {
                return pagerGridLayoutManager.a();
            }
            if (i2 < (-PagerConfig.a())) {
                return pagerGridLayoutManager.b();
            }
            return -1;
        } else {
            return -1;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0034, code lost:
        if (java.lang.Math.abs(r6) > r0) goto L14;
     */
    @Override // androidx.recyclerview.widget.SnapHelper, androidx.recyclerview.widget.RecyclerView.OnFlingListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onFling(int r6, int r7) {
        /*
            r5 = this;
            r0 = r5
            androidx.recyclerview.widget.RecyclerView r0 = r0.f13878a
            androidx.recyclerview.widget.RecyclerView$LayoutManager r0 = r0.getLayoutManager()
            r11 = r0
            r0 = 0
            r10 = r0
            r0 = r11
            if (r0 != 0) goto L13
            r0 = 0
            return r0
        L13:
            r0 = r5
            androidx.recyclerview.widget.RecyclerView r0 = r0.f13878a
            androidx.recyclerview.widget.RecyclerView$Adapter r0 = r0.getAdapter()
            if (r0 != 0) goto L1f
            r0 = 0
            return r0
        L1f:
            int r0 = com.blued.android.module.live_china.mine.PagerConfig.a()
            r8 = r0
            r0 = r7
            int r0 = java.lang.Math.abs(r0)
            r1 = r8
            if (r0 > r1) goto L37
            r0 = r10
            r9 = r0
            r0 = r6
            int r0 = java.lang.Math.abs(r0)
            r1 = r8
            if (r0 <= r1) goto L49
        L37:
            r0 = r10
            r9 = r0
            r0 = r5
            r1 = r11
            r2 = r6
            r3 = r7
            boolean r0 = r0.a(r1, r2, r3)
            if (r0 == 0) goto L49
            r0 = 1
            r9 = r0
        L49:
            r0 = r9
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.live_china.mine.PagerGridSnapHelper.onFling(int, int):boolean");
    }
}
