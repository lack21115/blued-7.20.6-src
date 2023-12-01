package com.blued.android.module.common.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import com.blued.android.module.common.R;
import com.bytedance.applog.tracker.Tracker;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/view/FlowLayout.class */
public class FlowLayout extends ViewGroup {
    private static final String a = FlowLayout.class.getSimpleName();
    private boolean b;
    private int c;
    private int d;
    private int e;
    private float f;
    private float g;
    private boolean h;
    private int i;
    private int j;
    private int k;
    private int l;
    private List<Float> m;
    private List<Integer> n;
    private List<Integer> o;
    private List<Integer> p;

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/view/FlowLayout$OnItemClickListener.class */
    public interface OnItemClickListener {
        void onItemClick(View view, int i);
    }

    public FlowLayout(Context context) {
        this(context, null);
    }

    public FlowLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = true;
        this.c = 0;
        this.d = 0;
        this.e = -65538;
        this.f = 0.0f;
        this.g = 0.0f;
        this.h = false;
        this.i = Integer.MAX_VALUE;
        this.j = -1;
        this.k = -65536;
        this.m = new ArrayList();
        this.n = new ArrayList();
        this.o = new ArrayList();
        this.p = new ArrayList();
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.FlowLayout, 0, 0);
        try {
            this.b = obtainStyledAttributes.getBoolean(R.styleable.FlowLayout_flFlow, true);
            try {
                this.c = obtainStyledAttributes.getInt(R.styleable.FlowLayout_flChildSpacing, 0);
            } catch (NumberFormatException e) {
                this.c = obtainStyledAttributes.getDimensionPixelSize(R.styleable.FlowLayout_flChildSpacing, (int) a(0.0f));
            }
            try {
                this.d = obtainStyledAttributes.getInt(R.styleable.FlowLayout_flMinChildSpacing, 0);
            } catch (NumberFormatException e2) {
                this.d = obtainStyledAttributes.getDimensionPixelSize(R.styleable.FlowLayout_flMinChildSpacing, (int) a(0.0f));
            }
            try {
                this.e = obtainStyledAttributes.getInt(R.styleable.FlowLayout_flChildSpacingForLastRow, -65538);
            } catch (NumberFormatException e3) {
                this.e = obtainStyledAttributes.getDimensionPixelSize(R.styleable.FlowLayout_flChildSpacingForLastRow, (int) a(0.0f));
            }
            try {
                this.f = obtainStyledAttributes.getInt(R.styleable.FlowLayout_flRowSpacing, 0);
            } catch (NumberFormatException e4) {
                this.f = obtainStyledAttributes.getDimension(R.styleable.FlowLayout_flRowSpacing, a(0.0f));
            }
            this.i = obtainStyledAttributes.getInt(R.styleable.FlowLayout_flMaxRows, Integer.MAX_VALUE);
            this.h = obtainStyledAttributes.getBoolean(R.styleable.FlowLayout_flRtl, false);
            this.j = obtainStyledAttributes.getInt(R.styleable.FlowLayout_android_gravity, -1);
            this.k = obtainStyledAttributes.getInt(R.styleable.FlowLayout_flRowVerticalGravity, -65536);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    private float a(float f) {
        return TypedValue.applyDimension(1, f, getResources().getDisplayMetrics());
    }

    private int a(int i, int i2, int i3, int i4) {
        int i5 = 0;
        if (this.c != -65536) {
            i5 = 0;
            if (i4 < this.o.size()) {
                i5 = 0;
                if (i4 < this.p.size()) {
                    if (this.p.get(i4).intValue() <= 0) {
                        return 0;
                    }
                    if (i != 1) {
                        if (i != 5) {
                            return 0;
                        }
                        return (i2 - i3) - this.o.get(i4).intValue();
                    }
                    i5 = ((i2 - i3) - this.o.get(i4).intValue()) / 2;
                }
            }
        }
        return i5;
    }

    private float b(int i, int i2, int i3, int i4) {
        if (i == -65536) {
            if (i4 > 1) {
                return (i2 - i3) / (i4 - 1);
            }
            return 0.0f;
        }
        return i;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new ViewGroup.MarginLayoutParams(layoutParams);
    }

    public int getChildSpacing() {
        return this.c;
    }

    public int getChildSpacingForLastRow() {
        return this.e;
    }

    public int getMaxRows() {
        return this.i;
    }

    public int getMinChildSpacing() {
        return this.d;
    }

    public float getRowSpacing() {
        return this.f;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00cc  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onLayout(boolean r8, int r9, int r10, int r11, int r12) {
        /*
            Method dump skipped, instructions count: 650
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.common.view.FlowLayout.onLayout(boolean, int, int, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int max;
        int i8;
        int i9;
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i2);
        this.m.clear();
        this.n.clear();
        this.o.clear();
        this.p.clear();
        int childCount = getChildCount();
        int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
        boolean z = mode != 0 && this.b;
        int i10 = (this.c == -65536 && mode == 0) ? 0 : this.c;
        float f = i10 == -65536 ? this.d : i10;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        int i16 = 0;
        int i17 = 0;
        while (true) {
            i3 = i17;
            if (i13 >= childCount) {
                break;
            }
            View childAt = getChildAt(i13);
            if (childAt.getVisibility() == 8) {
                int i18 = i10;
                i9 = i12;
                i8 = i11;
                i7 = i18;
                max = i3;
            } else {
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    measureChildWithMargins(childAt, i, 0, i2, i16);
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    i5 = marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
                    i6 = marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
                } else {
                    measureChild(childAt, i, i2);
                    i5 = 0;
                    i6 = 0;
                }
                int i19 = i11;
                float f2 = f;
                int i20 = i12;
                int measuredWidth = i5 + childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight() + i6;
                if (!z || i15 + measuredWidth <= paddingLeft) {
                    i7 = i10;
                    i15 = (int) (i15 + measuredWidth + f2);
                    max = Math.max(i3, measuredHeight);
                    i8 = i19 + 1;
                    i9 = measuredWidth + i20;
                } else {
                    i7 = i10;
                    this.m.add(Float.valueOf(b(i7, paddingLeft, i20, i19)));
                    this.p.add(Integer.valueOf(i19));
                    this.n.add(Integer.valueOf(i3));
                    int i21 = (int) f2;
                    this.o.add(Integer.valueOf(i15 - i21));
                    int i22 = i16;
                    if (this.m.size() <= this.i) {
                        i22 = i16 + i3;
                    }
                    i14 = Math.max(i14, i15);
                    i15 = measuredWidth + i21;
                    i9 = measuredWidth;
                    i8 = 1;
                    i16 = i22;
                    max = measuredHeight;
                }
            }
            i13++;
            int i23 = i7;
            i11 = i8;
            i12 = i9;
            i10 = i23;
            i17 = max;
        }
        int i24 = this.e;
        if (i24 == -65537) {
            if (this.m.size() >= 1) {
                List<Float> list = this.m;
                list.add(list.get(list.size() - 1));
            } else {
                this.m.add(Float.valueOf(b(i10, paddingLeft, i12, i11)));
            }
        } else if (i24 != -65538) {
            this.m.add(Float.valueOf(b(i24, paddingLeft, i12, i11)));
        } else {
            this.m.add(Float.valueOf(b(i10, paddingLeft, i12, i11)));
        }
        this.p.add(Integer.valueOf(i11));
        this.n.add(Integer.valueOf(i3));
        this.o.add(Integer.valueOf(i15 - ((int) f)));
        int i25 = i16;
        if (this.m.size() <= this.i) {
            i25 = i16 + i3;
        }
        int max2 = Math.max(i14, i15);
        int paddingLeft2 = i10 == -65536 ? size : mode == 0 ? max2 + getPaddingLeft() + getPaddingRight() : Math.min(max2 + getPaddingLeft() + getPaddingRight(), size);
        int paddingTop = i25 + getPaddingTop() + getPaddingBottom();
        int min = Math.min(this.m.size(), this.i);
        float f3 = (this.f == -65536.0f && mode2 == 0) ? 0.0f : this.f;
        if (f3 == -65536.0f) {
            if (min > 1) {
                this.g = (size2 - paddingTop) / (min - 1);
            } else {
                this.g = 0.0f;
            }
            i4 = size2;
        } else {
            this.g = f3;
            i4 = paddingTop;
            if (min > 1) {
                i4 = mode2 == 0 ? (int) (paddingTop + (f3 * (min - 1))) : Math.min((int) (paddingTop + (f3 * (min - 1))), size2);
            }
        }
        this.l = i4;
        if (mode == 1073741824) {
            paddingLeft2 = size;
        }
        if (mode2 == 1073741824) {
            i4 = size2;
        }
        setMeasuredDimension(paddingLeft2, i4);
    }

    public void setChildSpacing(int i) {
        this.c = i;
        requestLayout();
    }

    public void setChildSpacingForLastRow(int i) {
        this.e = i;
        requestLayout();
    }

    public void setFlow(boolean z) {
        this.b = z;
        requestLayout();
    }

    public void setGravity(int i) {
        if (this.j != i) {
            this.j = i;
            requestLayout();
        }
    }

    public void setMaxRows(int i) {
        this.i = i;
        requestLayout();
    }

    public void setMinChildSpacing(int i) {
        this.d = i;
        requestLayout();
    }

    public void setOnItemClickListener(final OnItemClickListener onItemClickListener) {
        int childCount = getChildCount();
        int i = 0;
        while (true) {
            final int i2 = i;
            if (i2 >= childCount) {
                return;
            }
            getChildAt(i2).setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.common.view.FlowLayout.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    onItemClickListener.onItemClick(view, i2);
                }
            });
            i = i2 + 1;
        }
    }

    public void setRowSpacing(float f) {
        this.f = f;
        requestLayout();
    }

    public void setRowVerticalGravity(int i) {
        if (this.k != i) {
            this.k = i;
            requestLayout();
        }
    }

    public void setRtl(boolean z) {
        this.h = z;
        requestLayout();
    }
}
