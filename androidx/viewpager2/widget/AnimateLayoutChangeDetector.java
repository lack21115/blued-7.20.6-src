package androidx.viewpager2.widget;

import android.animation.LayoutTransition;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8756600-dex2jar.jar:androidx/viewpager2/widget/AnimateLayoutChangeDetector.class */
public final class AnimateLayoutChangeDetector {

    /* renamed from: a  reason: collision with root package name */
    private static final ViewGroup.MarginLayoutParams f3533a;
    private LinearLayoutManager b;

    static {
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-1, -1);
        f3533a = marginLayoutParams;
        marginLayoutParams.setMargins(0, 0, 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AnimateLayoutChangeDetector(LinearLayoutManager linearLayoutManager) {
        this.b = linearLayoutManager;
    }

    private static boolean a(View view) {
        if (!(view instanceof ViewGroup)) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        LayoutTransition layoutTransition = viewGroup.getLayoutTransition();
        if (layoutTransition != null && layoutTransition.isChangingLayout()) {
            return true;
        }
        int childCount = viewGroup.getChildCount();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= childCount) {
                return false;
            }
            if (a(viewGroup.getChildAt(i2))) {
                return true;
            }
            i = i2 + 1;
        }
    }

    private boolean b() {
        int top;
        int i;
        int bottom;
        int i2;
        int childCount = this.b.getChildCount();
        if (childCount == 0) {
            return true;
        }
        boolean z = this.b.getOrientation() == 0;
        int[][] iArr = (int[][]) Array.newInstance(Integer.TYPE, childCount, 2);
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 < childCount) {
                View childAt = this.b.getChildAt(i4);
                if (childAt == null) {
                    throw new IllegalStateException("null view contained in the view hierarchy");
                }
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : f3533a;
                int[] iArr2 = iArr[i4];
                if (z) {
                    top = childAt.getLeft();
                    i = marginLayoutParams.leftMargin;
                } else {
                    top = childAt.getTop();
                    i = marginLayoutParams.topMargin;
                }
                iArr2[0] = top - i;
                int[] iArr3 = iArr[i4];
                if (z) {
                    bottom = childAt.getRight();
                    i2 = marginLayoutParams.rightMargin;
                } else {
                    bottom = childAt.getBottom();
                    i2 = marginLayoutParams.bottomMargin;
                }
                iArr3[1] = bottom + i2;
                i3 = i4 + 1;
            } else {
                Arrays.sort(iArr, new Comparator<int[]>() { // from class: androidx.viewpager2.widget.AnimateLayoutChangeDetector.1
                    @Override // java.util.Comparator
                    public int compare(int[] iArr4, int[] iArr5) {
                        return iArr4[0] - iArr5[0];
                    }
                });
                int i5 = 1;
                while (true) {
                    int i6 = i5;
                    if (i6 >= childCount) {
                        return iArr[0][0] <= 0 && iArr[childCount - 1][1] >= iArr[0][1] - iArr[0][0];
                    } else if (iArr[i6 - 1][1] != iArr[i6][0]) {
                        return false;
                    } else {
                        i5 = i6 + 1;
                    }
                }
            }
        }
    }

    private boolean c() {
        int childCount = this.b.getChildCount();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= childCount) {
                return false;
            }
            if (a(this.b.getChildAt(i2))) {
                return true;
            }
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a() {
        return (!b() || this.b.getChildCount() <= 1) && c();
    }
}
