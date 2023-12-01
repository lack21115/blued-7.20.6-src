package com.blued.android.module.common.widget.consecutivescroller;

import android.graphics.Rect;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import androidx.core.view.ScrollingView;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.module.common.widget.consecutivescroller.ConsecutiveScrollerLayout;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/widget/consecutivescroller/ScrollUtils.class */
public class ScrollUtils {
    private static final Rect a = new Rect();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(View view) {
        ScrollingView h = h(view);
        if (h instanceof ScrollingView) {
            return h.computeVerticalScrollOffset();
        }
        try {
            Method declaredMethod = View.class.getDeclaredMethod("computeVerticalScrollOffset", new Class[0]);
            declaredMethod.setAccessible(true);
            return ((Integer) declaredMethod.invoke(h, new Object[0])).intValue();
        } catch (Exception e) {
            e.printStackTrace();
            return h.getScrollY();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(View view, MotionEvent motionEvent, int i) {
        float x;
        if (Build.VERSION.SDK_INT >= 29) {
            x = motionEvent.getRawX(i);
        } else {
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            x = iArr[0] + motionEvent.getX(i);
        }
        return (int) x;
    }

    static List<View> a(View view, int i, int i2) {
        ArrayList arrayList = new ArrayList();
        a(arrayList, view, i, i2);
        return arrayList;
    }

    private static void a(List<View> list, View view, int i, int i2) {
        if (b(view, i, i2)) {
            list.add(view);
        }
        if (!(view instanceof ViewGroup)) {
            return;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= childCount) {
                return;
            }
            a(list, viewGroup.getChildAt(i4), i, i2);
            i3 = i4 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(View view, int i) {
        RecyclerView h = h(view);
        if (h instanceof AbsListView) {
            AbsListView absListView = (AbsListView) h;
            if (Build.VERSION.SDK_INT >= 19) {
                return absListView.canScrollList(i);
            }
            return false;
        } else if (!(h instanceof RecyclerView)) {
            return h.canScrollVertically(i);
        } else {
            RecyclerView recyclerView = h;
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            RecyclerView.Adapter adapter = recyclerView.getAdapter();
            if (layoutManager == null || adapter == null || adapter.getItemCount() <= 0) {
                return false;
            }
            if (layoutManager.findViewByPosition(i > 0 ? adapter.getItemCount() - 1 : 0) == null) {
                return true;
            }
            int childCount = recyclerView.getChildCount();
            if (i > 0) {
                int i2 = childCount;
                while (true) {
                    int i3 = i2 - 1;
                    if (i3 < 0) {
                        return false;
                    }
                    recyclerView.getDecoratedBoundsWithMargins(recyclerView.getChildAt(i3), a);
                    if (a.bottom > recyclerView.getHeight() - recyclerView.getPaddingBottom()) {
                        return true;
                    }
                    i2 = i3;
                }
            } else {
                int i4 = 0;
                while (true) {
                    int i5 = i4;
                    if (i5 >= childCount) {
                        return false;
                    }
                    recyclerView.getDecoratedBoundsWithMargins(recyclerView.getChildAt(i5), a);
                    if (a.top < recyclerView.getPaddingTop()) {
                        return true;
                    }
                    i4 = i5 + 1;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(RecyclerView recyclerView) {
        if ("InterceptRequestLayout".equals(recyclerView.getTag())) {
            try {
                Method declaredMethod = RecyclerView.class.getDeclaredMethod("startInterceptRequestLayout", new Class[0]);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(recyclerView, new Object[0]);
                return true;
            } catch (Exception e) {
                return false;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(View view) {
        ScrollingView h = h(view);
        if (h instanceof ScrollingView) {
            return h.computeVerticalScrollRange();
        }
        try {
            Method declaredMethod = View.class.getDeclaredMethod("computeVerticalScrollRange", new Class[0]);
            declaredMethod.setAccessible(true);
            return ((Integer) declaredMethod.invoke(h, new Object[0])).intValue();
        } catch (Exception e) {
            e.printStackTrace();
            return h.getHeight();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(View view, MotionEvent motionEvent, int i) {
        float y;
        if (Build.VERSION.SDK_INT >= 29) {
            y = motionEvent.getRawY(i);
        } else {
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            y = iArr[1] + motionEvent.getY(i);
        }
        return (int) y;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(RecyclerView recyclerView) {
        if ("InterceptRequestLayout".equals(recyclerView.getTag())) {
            try {
                Method declaredMethod = RecyclerView.class.getDeclaredMethod("stopInterceptRequestLayout", Boolean.TYPE);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(recyclerView, false);
            } catch (Exception e) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean b(View view, int i, int i2) {
        if (view == null) {
            return false;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i3 = iArr[0];
        int i4 = iArr[1];
        return i >= i3 && i <= view.getMeasuredWidth() + i3 && i2 >= i4 && i2 <= view.getMeasuredHeight() + i4;
    }

    static int c(View view) {
        ScrollingView h = h(view);
        if (h instanceof ScrollingView) {
            return h.computeVerticalScrollExtent();
        }
        try {
            Method declaredMethod = View.class.getDeclaredMethod("computeVerticalScrollExtent", new Class[0]);
            declaredMethod.setAccessible(true);
            return ((Integer) declaredMethod.invoke(h, new Object[0])).intValue();
        } catch (Exception e) {
            e.printStackTrace();
            return h.getHeight();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:5:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean c(android.view.View r4, int r5, int r6) {
        /*
            r0 = r4
            r1 = r5
            r2 = r6
            java.util.List r0 = a(r0, r1, r2)
            java.util.Iterator r0 = r0.iterator()
            r4 = r0
        Lc:
            r0 = r4
            boolean r0 = r0.hasNext()
            if (r0 == 0) goto L31
            r0 = r4
            java.lang.Object r0 = r0.next()
            android.view.View r0 = (android.view.View) r0
            r7 = r0
            r0 = r7
            r1 = 1
            boolean r0 = r0.canScrollHorizontally(r1)
            if (r0 != 0) goto L2f
            r0 = r7
            r1 = -1
            boolean r0 = r0.canScrollHorizontally(r1)
            if (r0 == 0) goto Lc
        L2f:
            r0 = 1
            return r0
        L31:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.common.widget.consecutivescroller.ScrollUtils.c(android.view.View, int, int):boolean");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int d(View view) {
        if (g(view) && a(view, -1)) {
            return Math.min(-a(view), -1);
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int e(View view) {
        if (g(view) && a(view, 1)) {
            return Math.max((b(view) - a(view)) - c(view), 1);
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean f(View view) {
        boolean z = true;
        if (g(view)) {
            if (!a(view, 1)) {
                if (a(view, -1)) {
                    return true;
                }
            }
            return z;
        }
        z = false;
        return z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean g(View view) {
        if (view != null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof ConsecutiveScrollerLayout.LayoutParams) {
                return ((ConsecutiveScrollerLayout.LayoutParams) layoutParams).a;
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static View h(View view) {
        while (view instanceof IConsecutiveScroller) {
            View currentScrollerView = ((IConsecutiveScroller) view).getCurrentScrollerView();
            if (view == currentScrollerView) {
                return currentScrollerView;
            }
            view = currentScrollerView;
        }
        return view;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean i(View view) {
        while ((view.getParent() instanceof ViewGroup) && !(view.getParent() instanceof ConsecutiveScrollerLayout)) {
            view = (View) view.getParent();
        }
        if (view.getParent() instanceof ConsecutiveScrollerLayout) {
            return g(view);
        }
        return false;
    }
}
