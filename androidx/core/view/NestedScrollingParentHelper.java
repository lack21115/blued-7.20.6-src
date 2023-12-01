package androidx.core.view;

import android.view.View;
import android.view.ViewGroup;

/* loaded from: source-8756600-dex2jar.jar:androidx/core/view/NestedScrollingParentHelper.class */
public class NestedScrollingParentHelper {

    /* renamed from: a  reason: collision with root package name */
    private int f2603a;
    private int b;

    public NestedScrollingParentHelper(ViewGroup viewGroup) {
    }

    public int getNestedScrollAxes() {
        return this.f2603a | this.b;
    }

    public void onNestedScrollAccepted(View view, View view2, int i) {
        onNestedScrollAccepted(view, view2, i, 0);
    }

    public void onNestedScrollAccepted(View view, View view2, int i, int i2) {
        if (i2 == 1) {
            this.b = i;
        } else {
            this.f2603a = i;
        }
    }

    public void onStopNestedScroll(View view) {
        onStopNestedScroll(view, 0);
    }

    public void onStopNestedScroll(View view, int i) {
        if (i == 1) {
            this.b = 0;
        } else {
            this.f2603a = 0;
        }
    }
}
