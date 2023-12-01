package androidx.appcompat.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.R;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.view.ViewCompat;

/* loaded from: source-8756600-dex2jar.jar:androidx/appcompat/widget/AlertDialogLayout.class */
public class AlertDialogLayout extends LinearLayoutCompat {
    public AlertDialogLayout(Context context) {
        super(context);
    }

    public AlertDialogLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private static int a(View view) {
        int minimumHeight = ViewCompat.getMinimumHeight(view);
        if (minimumHeight > 0) {
            return minimumHeight;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (viewGroup.getChildCount() == 1) {
                return a(viewGroup.getChildAt(0));
            }
            return 0;
        }
        return 0;
    }

    private void a(View view, int i, int i2, int i3, int i4) {
        view.layout(i, i2, i3 + i, i4 + i2);
    }

    private boolean a(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int childCount = getChildCount();
        View view = null;
        View view2 = null;
        View view3 = null;
        int i8 = 0;
        while (true) {
            int i9 = i8;
            if (i9 >= childCount) {
                int mode = View.MeasureSpec.getMode(i2);
                int size = View.MeasureSpec.getSize(i2);
                int mode2 = View.MeasureSpec.getMode(i);
                int paddingTop = getPaddingTop() + getPaddingBottom();
                if (view != null) {
                    view.measure(i, 0);
                    paddingTop += view.getMeasuredHeight();
                    i3 = View.combineMeasuredStates(0, view.getMeasuredState());
                } else {
                    i3 = 0;
                }
                if (view2 != null) {
                    view2.measure(i, 0);
                    i4 = a(view2);
                    i5 = view2.getMeasuredHeight() - i4;
                    paddingTop += i4;
                    i3 = View.combineMeasuredStates(i3, view2.getMeasuredState());
                } else {
                    i4 = 0;
                    i5 = 0;
                }
                if (view3 != null) {
                    view3.measure(i, mode == 0 ? 0 : View.MeasureSpec.makeMeasureSpec(Math.max(0, size - paddingTop), mode));
                    i6 = view3.getMeasuredHeight();
                    paddingTop += i6;
                    i3 = View.combineMeasuredStates(i3, view3.getMeasuredState());
                } else {
                    i6 = 0;
                }
                int i10 = size - paddingTop;
                int i11 = i3;
                int i12 = i10;
                int i13 = paddingTop;
                if (view2 != null) {
                    int min = Math.min(i10, i5);
                    int i14 = i10;
                    int i15 = i4;
                    if (min > 0) {
                        i14 = i10 - min;
                        i15 = i4 + min;
                    }
                    view2.measure(i, View.MeasureSpec.makeMeasureSpec(i15, 1073741824));
                    i13 = (paddingTop - i4) + view2.getMeasuredHeight();
                    i12 = i14;
                    i11 = View.combineMeasuredStates(i3, view2.getMeasuredState());
                }
                int i16 = i11;
                int i17 = i13;
                if (view3 != null) {
                    i16 = i11;
                    i17 = i13;
                    if (i12 > 0) {
                        view3.measure(i, View.MeasureSpec.makeMeasureSpec(i6 + i12, mode));
                        i17 = (i13 - i6) + view3.getMeasuredHeight();
                        i16 = View.combineMeasuredStates(i11, view3.getMeasuredState());
                    }
                }
                int i18 = 0;
                int i19 = 0;
                while (true) {
                    i7 = i19;
                    if (i18 >= childCount) {
                        break;
                    }
                    View childAt = getChildAt(i18);
                    int i20 = i7;
                    if (childAt.getVisibility() != 8) {
                        i20 = Math.max(i7, childAt.getMeasuredWidth());
                    }
                    i18++;
                    i19 = i20;
                }
                setMeasuredDimension(View.resolveSizeAndState(i7 + getPaddingLeft() + getPaddingRight(), i, i16), View.resolveSizeAndState(i17, i2, 0));
                if (mode2 != 1073741824) {
                    b(childCount, i2);
                    return true;
                }
                return true;
            }
            View childAt2 = getChildAt(i9);
            if (childAt2.getVisibility() != 8) {
                int id = childAt2.getId();
                if (id == R.id.topPanel) {
                    view = childAt2;
                } else if (id == R.id.buttonPanel) {
                    view2 = childAt2;
                } else if ((id != R.id.contentPanel && id != R.id.customPanel) || view3 != null) {
                    return false;
                } else {
                    view3 = childAt2;
                }
            }
            i8 = i9 + 1;
        }
    }

    private void b(int i, int i2) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= i) {
                return;
            }
            View childAt = getChildAt(i4);
            if (childAt.getVisibility() != 8) {
                LinearLayoutCompat.LayoutParams layoutParams = (LinearLayoutCompat.LayoutParams) childAt.getLayoutParams();
                if (layoutParams.width == -1) {
                    int i5 = layoutParams.height;
                    layoutParams.height = childAt.getMeasuredHeight();
                    measureChildWithMargins(childAt, makeMeasureSpec, 0, i2, 0);
                    layoutParams.height = i5;
                }
            }
            i3 = i4 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:33:0x013c  */
    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onLayout(boolean r8, int r9, int r10, int r11, int r12) {
        /*
            Method dump skipped, instructions count: 368
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.AlertDialogLayout.onLayout(boolean, int, int, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.View
    public void onMeasure(int i, int i2) {
        if (a(i, i2)) {
            return;
        }
        super.onMeasure(i, i2);
    }
}
