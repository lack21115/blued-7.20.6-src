package com.anythink.expressad.foundation.h;

import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/foundation/h/y.class */
public final class y {

    /* renamed from: a  reason: collision with root package name */
    private static final String f7982a = "ViewUtils";
    private static boolean b = false;

    private static int a(View view, ViewGroup viewGroup) {
        int i;
        int i2 = 0;
        while (true) {
            i = i2;
            if (i >= viewGroup.getChildCount() || viewGroup.getChildAt(i) == view) {
                break;
            }
            i2 = i + 1;
        }
        return i;
    }

    public static boolean a(View view) {
        ViewGroup viewGroup;
        if (view.getVisibility() != 0) {
            o.d(f7982a, "Banner Judge : Banner's not visible.");
            return true;
        } else if (view.getAlpha() < 0.5f) {
            o.d(f7982a, "Banner Judge : Banner's alpha must set up 50%.");
            return true;
        } else if (view.getParent() != null && (view.getParent() instanceof ViewGroup) && ((ViewGroup) view.getParent()).getVisibility() != 0) {
            o.d(f7982a, "View Judge : View's container is not visible.");
            return true;
        } else {
            Rect rect = new Rect();
            boolean globalVisibleRect = view.getGlobalVisibleRect(rect);
            boolean z = (rect.bottom - rect.top) * (rect.right - rect.left) >= (view.getMeasuredHeight() * view.getMeasuredWidth()) / 2;
            boolean z2 = globalVisibleRect && z;
            o.d(f7982a, "View Judge : partVisible is " + globalVisibleRect + " halfPercentVisible is " + z);
            o.d(f7982a, "View Judge : totalViewVisible is ".concat(String.valueOf(z2)));
            if (!z2) {
                return true;
            }
            ViewGroup viewGroup2 = view;
            while (true) {
                View view2 = viewGroup2;
                if (!(view2.getParent() instanceof ViewGroup)) {
                    o.d(f7982a, "View Judge : Well done, View is not covered.");
                    return false;
                }
                viewGroup = (ViewGroup) view2.getParent();
                int a2 = a(view2, viewGroup);
                while (true) {
                    int i = a2 + 1;
                    if (i < viewGroup.getChildCount()) {
                        View childAt = viewGroup.getChildAt(i);
                        if (childAt.getVisibility() == 0 && a(view, childAt)) {
                            if (childAt instanceof ViewGroup) {
                                ViewGroup viewGroup3 = (ViewGroup) childAt;
                                if (viewGroup3.getChildCount() > 0) {
                                    o.d(f7982a, "View Judge : Covered by ViewGroup.");
                                    boolean b2 = b(view, viewGroup3);
                                    b = false;
                                    if (b2) {
                                        return true;
                                    }
                                }
                            }
                            if (b(childAt)) {
                                o.d(f7982a, "View Judge : View Covered and Cover View is not transparent.");
                                return true;
                            }
                        }
                        a2 = i;
                    }
                }
                viewGroup2 = viewGroup;
            }
        }
    }

    private static boolean a(View view, View view2) {
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        Rect rect2 = new Rect();
        view2.getGlobalVisibleRect(rect2);
        return Rect.intersects(rect, rect2) && ((Math.min(rect.right, rect2.right) - Math.max(rect.left, rect2.left)) * (Math.min(rect.bottom, rect2.bottom) - Math.max(rect.top, rect2.top))) * 2 >= view.getMeasuredHeight() * view.getMeasuredWidth();
    }

    private static boolean b(View view) {
        if (view.getAlpha() <= 0.5f) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            return view.getBackground() != null && view.getBackground().getAlpha() > 127;
        }
        return true;
    }

    private static boolean b(View view, ViewGroup viewGroup) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= viewGroup.getChildCount()) {
                break;
            }
            o.d(f7982a, "View Judge : Start Loop");
            View childAt = viewGroup.getChildAt(i2);
            if (childAt.getVisibility() == 0 && a(view, childAt)) {
                if ((childAt instanceof WebView) && childAt.getVisibility() == 0) {
                    o.d(f7982a, "View Judge : View Covered by WebView.");
                    b = true;
                }
                if (b(childAt)) {
                    o.d(f7982a, "View Judge : View Covered and Cover ViewGroup is not transparent.");
                    b = true;
                }
                if (b) {
                    break;
                } else if (childAt instanceof ViewGroup) {
                    b(view, (ViewGroup) childAt);
                }
            }
            i = i2 + 1;
        }
        return b;
    }
}
