package com.sobot.chat.widget.horizontalgridpage;

import android.view.View;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;
import com.sobot.chat.utils.LogUtils;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/horizontalgridpage/PagerGridSnapHelper.class */
public class PagerGridSnapHelper extends SnapHelper {
    private String TAG = "PagerGridSnapHelper";
    private RecyclerView mRecyclerView;

    private boolean snapFromFling(RecyclerView.LayoutManager layoutManager, int i, int i2) {
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
        this.mRecyclerView = recyclerView;
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    public int[] calculateDistanceToFinalSnap(RecyclerView.LayoutManager layoutManager, View view) {
        int position = layoutManager.getPosition(view);
        LogUtils.e("findTargetSnapPosition, pos = " + position);
        int[] iArr = new int[2];
        if (layoutManager instanceof PagerGridLayoutManager) {
            iArr = ((PagerGridLayoutManager) layoutManager).getSnapOffset(position);
        }
        return iArr;
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    public LinearSmoothScroller createSnapScroller(RecyclerView.LayoutManager layoutManager) {
        if (layoutManager instanceof RecyclerView.SmoothScroller.ScrollVectorProvider) {
            return new PagerGridSmoothScroller(this.mRecyclerView);
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    public View findSnapView(RecyclerView.LayoutManager layoutManager) {
        if (layoutManager instanceof PagerGridLayoutManager) {
            return ((PagerGridLayoutManager) layoutManager).findSnapView();
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    public int findTargetSnapPosition(RecyclerView.LayoutManager layoutManager, int i, int i2) {
        int i3;
        LogUtils.e("findTargetSnapPosition, velocityX = " + i + ", velocityY" + i2);
        if (layoutManager != null && (layoutManager instanceof PagerGridLayoutManager)) {
            PagerGridLayoutManager pagerGridLayoutManager = (PagerGridLayoutManager) layoutManager;
            if (pagerGridLayoutManager.canScrollHorizontally()) {
                if (i > PagerConfig.getFlingThreshold()) {
                    i3 = pagerGridLayoutManager.findNextPageFirstPos();
                } else if (i < (-PagerConfig.getFlingThreshold())) {
                    i3 = pagerGridLayoutManager.findPrePageFirstPos();
                }
            } else if (pagerGridLayoutManager.canScrollVertically()) {
                if (i2 > PagerConfig.getFlingThreshold()) {
                    i3 = pagerGridLayoutManager.findNextPageFirstPos();
                } else if (i2 < (-PagerConfig.getFlingThreshold())) {
                    i3 = pagerGridLayoutManager.findPrePageFirstPos();
                }
            }
            LogUtils.e("findTargetSnapPosition, target = " + i3);
            return i3;
        }
        i3 = -1;
        LogUtils.e("findTargetSnapPosition, target = " + i3);
        return i3;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0054, code lost:
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
            androidx.recyclerview.widget.RecyclerView r0 = r0.mRecyclerView
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
            androidx.recyclerview.widget.RecyclerView r0 = r0.mRecyclerView
            androidx.recyclerview.widget.RecyclerView$Adapter r0 = r0.getAdapter()
            if (r0 != 0) goto L1f
            r0 = 0
            return r0
        L1f:
            int r0 = com.sobot.chat.widget.horizontalgridpage.PagerConfig.getFlingThreshold()
            r8 = r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r0
            r1.<init>()
            r12 = r0
            r0 = r12
            java.lang.String r1 = "minFlingVelocity = "
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r12
            r1 = r8
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r12
            java.lang.String r0 = r0.toString()
            com.sobot.chat.utils.LogUtils.e(r0)
            r0 = r7
            int r0 = java.lang.Math.abs(r0)
            r1 = r8
            if (r0 > r1) goto L57
            r0 = r10
            r9 = r0
            r0 = r6
            int r0 = java.lang.Math.abs(r0)
            r1 = r8
            if (r0 <= r1) goto L69
        L57:
            r0 = r10
            r9 = r0
            r0 = r5
            r1 = r11
            r2 = r6
            r3 = r7
            boolean r0 = r0.snapFromFling(r1, r2, r3)
            if (r0 == 0) goto L69
            r0 = 1
            r9 = r0
        L69:
            r0 = r9
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sobot.chat.widget.horizontalgridpage.PagerGridSnapHelper.onFling(int, int):boolean");
    }

    public void setFlingThreshold(int i) {
        PagerConfig.setFlingThreshold(i);
    }
}
