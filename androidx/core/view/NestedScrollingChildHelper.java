package androidx.core.view;

import android.view.View;
import android.view.ViewParent;

/* loaded from: source-8756600-dex2jar.jar:androidx/core/view/NestedScrollingChildHelper.class */
public class NestedScrollingChildHelper {

    /* renamed from: a  reason: collision with root package name */
    private ViewParent f2649a;
    private ViewParent b;

    /* renamed from: c  reason: collision with root package name */
    private final View f2650c;
    private boolean d;
    private int[] e;

    public NestedScrollingChildHelper(View view) {
        this.f2650c = view;
    }

    private ViewParent a(int i) {
        if (i != 0) {
            if (i != 1) {
                return null;
            }
            return this.b;
        }
        return this.f2649a;
    }

    private void a(int i, ViewParent viewParent) {
        if (i == 0) {
            this.f2649a = viewParent;
        } else if (i != 1) {
        } else {
            this.b = viewParent;
        }
    }

    private boolean a(int i, int i2, int i3, int i4, int[] iArr, int i5, int[] iArr2) {
        ViewParent a2;
        int i6;
        int i7;
        if (!isNestedScrollingEnabled() || (a2 = a(i5)) == null) {
            return false;
        }
        if (i == 0 && i2 == 0 && i3 == 0 && i4 == 0) {
            if (iArr != null) {
                iArr[0] = 0;
                iArr[1] = 0;
                return false;
            }
            return false;
        }
        if (iArr != null) {
            this.f2650c.getLocationInWindow(iArr);
            i6 = iArr[0];
            i7 = iArr[1];
        } else {
            i6 = 0;
            i7 = 0;
        }
        if (iArr2 == null) {
            iArr2 = a();
            iArr2[0] = 0;
            iArr2[1] = 0;
        }
        ViewParentCompat.onNestedScroll(a2, this.f2650c, i, i2, i3, i4, i5, iArr2);
        if (iArr != null) {
            this.f2650c.getLocationInWindow(iArr);
            iArr[0] = iArr[0] - i6;
            iArr[1] = iArr[1] - i7;
            return true;
        }
        return true;
    }

    private int[] a() {
        if (this.e == null) {
            this.e = new int[2];
        }
        return this.e;
    }

    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        ViewParent a2;
        if (!isNestedScrollingEnabled() || (a2 = a(0)) == null) {
            return false;
        }
        return ViewParentCompat.onNestedFling(a2, this.f2650c, f, f2, z);
    }

    public boolean dispatchNestedPreFling(float f, float f2) {
        ViewParent a2;
        if (!isNestedScrollingEnabled() || (a2 = a(0)) == null) {
            return false;
        }
        return ViewParentCompat.onNestedPreFling(a2, this.f2650c, f, f2);
    }

    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return dispatchNestedPreScroll(i, i2, iArr, iArr2, 0);
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x00bd, code lost:
        if (r18[1] != 0) goto L28;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean dispatchNestedPreScroll(int r8, int r9, int[] r10, int[] r11, int r12) {
        /*
            Method dump skipped, instructions count: 198
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.view.NestedScrollingChildHelper.dispatchNestedPreScroll(int, int, int[], int[], int):boolean");
    }

    public void dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr, int i5, int[] iArr2) {
        a(i, i2, i3, i4, iArr, i5, iArr2);
    }

    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return a(i, i2, i3, i4, iArr, 0, null);
    }

    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr, int i5) {
        return a(i, i2, i3, i4, iArr, i5, null);
    }

    public boolean hasNestedScrollingParent() {
        return hasNestedScrollingParent(0);
    }

    public boolean hasNestedScrollingParent(int i) {
        return a(i) != null;
    }

    public boolean isNestedScrollingEnabled() {
        return this.d;
    }

    public void onDetachedFromWindow() {
        ViewCompat.stopNestedScroll(this.f2650c);
    }

    public void onStopNestedScroll(View view) {
        ViewCompat.stopNestedScroll(this.f2650c);
    }

    public void setNestedScrollingEnabled(boolean z) {
        if (this.d) {
            ViewCompat.stopNestedScroll(this.f2650c);
        }
        this.d = z;
    }

    public boolean startNestedScroll(int i) {
        return startNestedScroll(i, 0);
    }

    public boolean startNestedScroll(int i, int i2) {
        if (hasNestedScrollingParent(i2)) {
            return true;
        }
        if (isNestedScrollingEnabled()) {
            View view = this.f2650c;
            for (ViewParent parent = this.f2650c.getParent(); parent != null; parent = parent.getParent()) {
                if (ViewParentCompat.onStartNestedScroll(parent, view, this.f2650c, i, i2)) {
                    a(i2, parent);
                    ViewParentCompat.onNestedScrollAccepted(parent, view, this.f2650c, i, i2);
                    return true;
                }
                if (parent instanceof View) {
                    view = (View) parent;
                }
            }
            return false;
        }
        return false;
    }

    public void stopNestedScroll() {
        stopNestedScroll(0);
    }

    public void stopNestedScroll(int i) {
        ViewParent a2 = a(i);
        if (a2 != null) {
            ViewParentCompat.onStopNestedScroll(a2, this.f2650c, i);
            a(i, null);
        }
    }
}
