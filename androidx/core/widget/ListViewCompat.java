package androidx.core.widget;

import android.os.Build;
import android.view.View;
import android.widget.ListView;

/* loaded from: source-8756600-dex2jar.jar:androidx/core/widget/ListViewCompat.class */
public final class ListViewCompat {
    private ListViewCompat() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0066, code lost:
        if (r0 < r4.getListPaddingTop()) goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean canScrollList(android.widget.ListView r4, int r5) {
        /*
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 19
            if (r0 < r1) goto Le
            r0 = r4
            r1 = r5
            boolean r0 = r0.canScrollList(r1)
            return r0
        Le:
            r0 = r4
            int r0 = r0.getChildCount()
            r7 = r0
            r0 = 0
            r9 = r0
            r0 = 0
            r8 = r0
            r0 = r7
            if (r0 != 0) goto L1f
            r0 = 0
            return r0
        L1f:
            r0 = r4
            int r0 = r0.getFirstVisiblePosition()
            r6 = r0
            r0 = r5
            if (r0 <= 0) goto L50
            r0 = r4
            r1 = r7
            r2 = 1
            int r1 = r1 - r2
            android.view.View r0 = r0.getChildAt(r1)
            int r0 = r0.getBottom()
            r5 = r0
            r0 = r6
            r1 = r7
            int r0 = r0 + r1
            r1 = r4
            int r1 = r1.getCount()
            if (r0 < r1) goto L4a
            r0 = r5
            r1 = r4
            int r1 = r1.getHeight()
            r2 = r4
            int r2 = r2.getListPaddingBottom()
            int r1 = r1 - r2
            if (r0 <= r1) goto L4d
        L4a:
            r0 = 1
            r8 = r0
        L4d:
            r0 = r8
            return r0
        L50:
            r0 = r4
            r1 = 0
            android.view.View r0 = r0.getChildAt(r1)
            int r0 = r0.getTop()
            r5 = r0
            r0 = r6
            if (r0 > 0) goto L69
            r0 = r9
            r8 = r0
            r0 = r5
            r1 = r4
            int r1 = r1.getListPaddingTop()
            if (r0 >= r1) goto L6c
        L69:
            r0 = 1
            r8 = r0
        L6c:
            r0 = r8
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.ListViewCompat.canScrollList(android.widget.ListView, int):boolean");
    }

    public static void scrollListBy(ListView listView, int i) {
        View childAt;
        if (Build.VERSION.SDK_INT >= 19) {
            listView.scrollListBy(i);
            return;
        }
        int firstVisiblePosition = listView.getFirstVisiblePosition();
        if (firstVisiblePosition == -1 || (childAt = listView.getChildAt(0)) == null) {
            return;
        }
        listView.setSelectionFromTop(firstVisiblePosition, childAt.getTop() - i);
    }
}
