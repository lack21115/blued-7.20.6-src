package com.soft.blued.customview;

import android.R;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.core.utils.skin.listener.BluedSkinSupportable;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/customview/DividerGridItemDecoration.class */
public class DividerGridItemDecoration extends RecyclerView.ItemDecoration implements BluedSkinSupportable {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f14717a = {R.attr.listDivider};
    private RecyclerView b;

    /* renamed from: c  reason: collision with root package name */
    private Drawable f14718c;
    private Paint d;
    private Context e;
    private int f;
    private int g;

    public DividerGridItemDecoration(RecyclerView recyclerView, int i, int i2) {
        this.f = 2;
        this.g = 2131102360;
        this.e = recyclerView.getContext();
        this.b = recyclerView;
        this.f = i;
        this.g = i2;
        Paint paint = new Paint(1);
        this.d = paint;
        paint.setColor(BluedSkinUtils.a(this.e, i2));
        this.d.setStyle(Paint.Style.FILL);
    }

    private int a(RecyclerView recyclerView) {
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            return ((GridLayoutManager) layoutManager).getSpanCount();
        }
        if (layoutManager instanceof StaggeredGridLayoutManager) {
            return ((StaggeredGridLayoutManager) layoutManager).getSpanCount();
        }
        return -1;
    }

    private boolean a(RecyclerView recyclerView, int i, int i2, int i3) {
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            return (i + 1) % i2 == 0;
        } else if (layoutManager instanceof StaggeredGridLayoutManager) {
            return ((StaggeredGridLayoutManager) layoutManager).getOrientation() == 1 ? (i + 1) % i2 == 0 : i >= i3 - (i3 % i2);
        } else {
            return false;
        }
    }

    private boolean b(RecyclerView recyclerView, int i, int i2, int i3) {
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            int i4 = i3 % i2;
            return i >= (i4 != 0 ? i3 - i4 : i3 - i2);
        } else if (layoutManager instanceof StaggeredGridLayoutManager) {
            if (((StaggeredGridLayoutManager) layoutManager).getOrientation() != 1) {
                return (i + 1) % i2 == 0;
            }
            int i5 = i3 % i2;
            return i >= (i5 != 0 ? i3 - i5 : i3 - i2);
        } else {
            return false;
        }
    }

    public void a(Canvas canvas, RecyclerView recyclerView) {
        int childCount = recyclerView.getChildCount();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= childCount) {
                return;
            }
            View childAt = recyclerView.getChildAt(i2);
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) childAt.getLayoutParams();
            int left = (childAt.getLeft() - layoutParams.leftMargin) - this.f;
            int right = childAt.getRight() + layoutParams.rightMargin + this.f;
            int bottom = childAt.getBottom() + layoutParams.bottomMargin;
            int i3 = this.f + bottom;
            Drawable drawable = this.f14718c;
            if (drawable != null) {
                drawable.setBounds(left, bottom, right, i3);
                this.f14718c.draw(canvas);
            }
            Paint paint = this.d;
            if (paint != null) {
                canvas.drawRect(left, bottom, right, i3, paint);
            }
            i = i2 + 1;
        }
    }

    public void applySkin() {
        Paint paint = this.d;
        if (paint == null || this.b == null) {
            return;
        }
        paint.setColor(BluedSkinUtils.a(this.e, this.g));
        this.b.invalidateItemDecorations();
    }

    public void b(Canvas canvas, RecyclerView recyclerView) {
        int childCount = recyclerView.getChildCount();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= childCount) {
                return;
            }
            View childAt = recyclerView.getChildAt(i2);
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) childAt.getLayoutParams();
            int top = (childAt.getTop() - layoutParams.topMargin) - this.f;
            int bottom = childAt.getBottom() + layoutParams.bottomMargin;
            int right = childAt.getRight() + layoutParams.rightMargin;
            int i3 = this.f + right;
            Drawable drawable = this.f14718c;
            if (drawable != null) {
                drawable.setBounds(right, top, i3, bottom);
                this.f14718c.draw(canvas);
            }
            Paint paint = this.d;
            if (paint != null) {
                canvas.drawRect(right, top, i3, bottom, paint);
            }
            i = i2 + 1;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, int i, RecyclerView recyclerView) {
        int a2 = a(recyclerView);
        int itemCount = recyclerView.getAdapter().getItemCount();
        if (b(recyclerView, i, a2, itemCount)) {
            if (a(recyclerView, i, a2, itemCount)) {
                return;
            }
            rect.set(0, 0, this.f, 0);
        } else if (a(recyclerView, i, a2, itemCount)) {
            rect.set(0, 0, 0, this.f);
        } else {
            int i2 = this.f;
            rect.set(0, 0, i2, i2);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        a(canvas, recyclerView);
        b(canvas, recyclerView);
    }
}
