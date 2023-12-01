package com.blued.android.module.media.selector.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.module.media.selector.R;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/media/selector/widget/MediaItemDecoration.class */
public class MediaItemDecoration extends RecyclerView.ItemDecoration {
    private int a;
    private int b;
    private int c;
    private boolean d;
    private int e;
    private ColorDrawable f;

    public MediaItemDecoration(Context context, AttributeSet attributeSet) {
        this.a = -7829368;
        this.b = 1;
        this.c = 0;
        this.d = true;
        this.e = 1;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.media_divder);
        this.a = obtainStyledAttributes.getColor(R.styleable.media_divder_divider_color, this.a);
        this.b = (int) obtainStyledAttributes.getDimension(R.styleable.media_divder_thickness, this.b);
        this.c = obtainStyledAttributes.getInt(R.styleable.media_divder_orientation, 0);
        this.d = obtainStyledAttributes.getBoolean(R.styleable.media_divder_draw_side, true);
        this.e = obtainStyledAttributes.getInt(R.styleable.media_divder_grid_col_num, 1);
        this.f = new ColorDrawable(this.a);
        obtainStyledAttributes.recycle();
    }

    private void a(Canvas canvas, RecyclerView recyclerView) {
        int childCount = recyclerView.getChildCount();
        View childAt = recyclerView.getChildAt(0);
        int i = this.c;
        if (i == 1) {
            int left = recyclerView.getLeft();
            int right = recyclerView.getRight();
            for (int i2 = 1; i2 < childCount; i2++) {
                this.f.setBounds(left, childAt.getBottom() - (this.b / 2), right, childAt.getBottom() + (this.b / 2));
                this.f.draw(canvas);
                if (this.d && i2 == 0) {
                    this.f.setBounds(left, childAt.getTop() - (this.b / 2), right, childAt.getTop() + (this.b / 2));
                    this.f.draw(canvas);
                }
                childAt = recyclerView.getChildAt(i2);
            }
        } else if (i == 0) {
            int top = childAt.getTop();
            int bottom = childAt.getBottom();
            int i3 = 1;
            while (true) {
                int i4 = i3;
                if (i4 >= childCount) {
                    return;
                }
                this.f.setBounds(childAt.getRight() - (this.b / 2), top, childAt.getRight() + (this.b / 2), bottom);
                this.f.draw(canvas);
                if (this.d && i4 == 0) {
                    this.f.setBounds(childAt.getLeft() - (this.b / 2), top, childAt.getLeft() + (this.b / 2), bottom);
                    this.f.draw(canvas);
                }
                childAt = recyclerView.getChildAt(i4);
                i3 = i4 + 1;
            }
        }
    }

    private void b(Canvas canvas, RecyclerView recyclerView) {
        int childCount = recyclerView.getChildCount();
        int i = this.e;
        int i2 = ((childCount / i) - 1) + (childCount % i == 0 ? 0 : 1);
        int left = recyclerView.getLeft() + (this.b / 2);
        int right = recyclerView.getRight() - (this.b / 2);
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= i2) {
                break;
            }
            View childAt = recyclerView.getChildAt(this.e * i4);
            if (childAt != null) {
                this.f.setBounds(left, childAt.getBottom(), right, childAt.getBottom() + this.b);
                this.f.draw(canvas);
                if (this.d) {
                    if (i4 == 0) {
                        this.f.setBounds(left, childAt.getTop() - this.b, right, childAt.getTop());
                        this.f.draw(canvas);
                    } else if (i4 == i2 - 1) {
                        this.f.setBounds(left, childAt.getBottom(), right, childAt.getBottom() + this.b);
                        this.f.draw(canvas);
                    }
                }
            }
            i3 = i4 + 1;
        }
        int top = recyclerView.getTop();
        int bottom = recyclerView.getBottom();
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 >= this.e) {
                return;
            }
            View childAt2 = recyclerView.getChildAt(i6);
            if (childAt2 != null) {
                this.f.setBounds(childAt2.getRight(), top, childAt2.getRight() + this.b, bottom);
                this.f.draw(canvas);
                if (this.d) {
                    if (i6 == 0) {
                        this.f.setBounds(childAt2.getLeft() - this.b, top, childAt2.getLeft(), bottom);
                        this.f.draw(canvas);
                    } else if (i6 == this.e - 1) {
                        this.f.setBounds(childAt2.getRight(), top, childAt2.getRight() + this.b, bottom);
                        this.f.draw(canvas);
                    }
                }
            }
            i5 = i6 + 1;
        }
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        int i = this.c;
        if (i == 1) {
            int i2 = this.b;
            rect.set(0, i2 / 2, 0, i2 / 2);
        } else if (i == 0) {
            int i3 = this.b;
            rect.set(i3 / 2, 0, i3 / 2, 0);
        } else {
            int i4 = this.b;
            rect.set(i4 / 2, i4 / 2, i4 / 2, i4 / 2);
        }
    }

    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        super.onDraw(canvas, recyclerView, state);
        int i = this.c;
        if (i == 0 || i == 1) {
            a(canvas, recyclerView);
        } else if (i == 2) {
            b(canvas, recyclerView);
        }
    }
}
