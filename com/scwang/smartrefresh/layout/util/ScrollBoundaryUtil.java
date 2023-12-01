package com.scwang.smartrefresh.layout.util;

import android.graphics.PointF;
import android.hardware.Camera;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;

/* loaded from: source-8303388-dex2jar.jar:com/scwang/smartrefresh/layout/util/ScrollBoundaryUtil.class */
public class ScrollBoundaryUtil {
    public static boolean a(View view) {
        if (Build.VERSION.SDK_INT < 14) {
            boolean z = true;
            if (!(view instanceof AbsListView)) {
                return view.getScrollY() > 0;
            }
            ViewGroup viewGroup = (ViewGroup) view;
            AbsListView absListView = (AbsListView) view;
            if (viewGroup.getChildCount() > 0) {
                if (absListView.getFirstVisiblePosition() <= 0) {
                    if (viewGroup.getChildAt(0).getTop() < view.getPaddingTop()) {
                        return true;
                    }
                }
                return z;
            }
            z = false;
            return z;
        }
        return view.canScrollVertically(-1);
    }

    public static boolean a(View view, PointF pointF) {
        if (a(view) && view.getVisibility() == 0) {
            return false;
        }
        if (!(view instanceof ViewGroup) || pointF == null) {
            return true;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        PointF pointF2 = new PointF();
        for (int childCount = viewGroup.getChildCount(); childCount > 0; childCount--) {
            View childAt = viewGroup.getChildAt(childCount - 1);
            if (a(viewGroup, childAt, pointF.x, pointF.y, pointF2)) {
                if (Camera.Parameters.FOCUS_MODE_FIXED.equals(childAt.getTag())) {
                    return false;
                }
                pointF.offset(pointF2.x, pointF2.y);
                boolean a2 = a(childAt, pointF);
                pointF.offset(-pointF2.x, -pointF2.y);
                return a2;
            }
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x00ac, code lost:
        if (a(r6) != false) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean a(android.view.View r6, android.graphics.PointF r7, boolean r8) {
        /*
            r0 = r6
            boolean r0 = b(r0)
            r12 = r0
            r0 = 0
            r11 = r0
            r0 = r12
            if (r0 == 0) goto L17
            r0 = r6
            int r0 = r0.getVisibility()
            if (r0 != 0) goto L17
            r0 = 0
            return r0
        L17:
            r0 = r6
            boolean r0 = r0 instanceof android.view.ViewGroup
            if (r0 == 0) goto La1
            r0 = r7
            if (r0 == 0) goto La1
            r0 = r6
            boolean r0 = com.scwang.smartrefresh.layout.util.SmartUtil.b(r0)
            if (r0 != 0) goto La1
            r0 = r6
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0
            r13 = r0
            r0 = r13
            int r0 = r0.getChildCount()
            r10 = r0
            android.graphics.PointF r0 = new android.graphics.PointF
            r1 = r0
            r1.<init>()
            r14 = r0
            r0 = 0
            r9 = r0
        L41:
            r0 = r9
            r1 = r10
            if (r0 >= r1) goto La1
            r0 = r13
            r1 = r9
            android.view.View r0 = r0.getChildAt(r1)
            r15 = r0
            r0 = r13
            r1 = r15
            r2 = r7
            float r2 = r2.x
            r3 = r7
            float r3 = r3.y
            r4 = r14
            boolean r0 = a(r0, r1, r2, r3, r4)
            if (r0 == 0) goto L9a
            java.lang.String r0 = "fixed"
            r1 = r15
            java.lang.Object r1 = r1.getTag()
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L72
            r0 = 0
            return r0
        L72:
            r0 = r7
            r1 = r14
            float r1 = r1.x
            r2 = r14
            float r2 = r2.y
            r0.offset(r1, r2)
            r0 = r15
            r1 = r7
            r2 = r8
            boolean r0 = a(r0, r1, r2)
            r8 = r0
            r0 = r7
            r1 = r14
            float r1 = r1.x
            float r1 = -r1
            r2 = r14
            float r2 = r2.y
            float r2 = -r2
            r0.offset(r1, r2)
            r0 = r8
            return r0
        L9a:
            r0 = r9
            r1 = 1
            int r0 = r0 + r1
            r9 = r0
            goto L41
        La1:
            r0 = r8
            if (r0 != 0) goto Laf
            r0 = r11
            r8 = r0
            r0 = r6
            boolean r0 = a(r0)
            if (r0 == 0) goto Lb1
        Laf:
            r0 = 1
            r8 = r0
        Lb1:
            r0 = r8
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.scwang.smartrefresh.layout.util.ScrollBoundaryUtil.a(android.view.View, android.graphics.PointF, boolean):boolean");
    }

    public static boolean a(View view, View view2, float f, float f2, PointF pointF) {
        if (view2.getVisibility() != 0) {
            return false;
        }
        float[] fArr = {f, f2};
        fArr[0] = fArr[0] + (view.getScrollX() - view2.getLeft());
        fArr[1] = fArr[1] + (view.getScrollY() - view2.getTop());
        boolean z = fArr[0] >= 0.0f && fArr[1] >= 0.0f && fArr[0] < ((float) view2.getWidth()) && fArr[1] < ((float) view2.getHeight());
        if (z && pointF != null) {
            pointF.set(fArr[0] - f, fArr[1] - f2);
        }
        return z;
    }

    public static boolean b(View view) {
        boolean z = true;
        if (Build.VERSION.SDK_INT < 14) {
            if (!(view instanceof AbsListView)) {
                return view.getScrollY() < 0;
            }
            ViewGroup viewGroup = (ViewGroup) view;
            AbsListView absListView = (AbsListView) view;
            int childCount = viewGroup.getChildCount();
            if (childCount > 0) {
                int lastVisiblePosition = absListView.getLastVisiblePosition();
                int i = childCount - 1;
                if (lastVisiblePosition >= i) {
                    if (viewGroup.getChildAt(i).getBottom() > view.getPaddingBottom()) {
                        return true;
                    }
                }
                return z;
            }
            z = false;
            return z;
        }
        return view.canScrollVertically(1);
    }
}
