package com.blued.android.framework.view.pulltorefresh;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SectionIndexer;
import com.blued.android.framework.R;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/view/pulltorefresh/PinnedSectionListView.class */
public class PinnedSectionListView extends ListView {
    AbsListView.OnScrollListener a;
    PinnedSection b;
    PinnedSection c;
    int d;
    private final Rect e;
    private final PointF f;
    private int g;
    private View h;
    private MotionEvent i;
    private GradientDrawable j;
    private int k;
    private int l;
    private final AbsListView.OnScrollListener m;
    private final DataSetObserver n;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/view/pulltorefresh/PinnedSectionListView$PinnedSection.class */
    public static class PinnedSection {
        public View a;
        public int b;
        public long c;

        PinnedSection() {
        }
    }

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/view/pulltorefresh/PinnedSectionListView$PinnedSectionListAdapter.class */
    public interface PinnedSectionListAdapter extends ListAdapter {
        boolean a(int i);
    }

    public PinnedSectionListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.e = new Rect();
        this.f = new PointF();
        this.m = new AbsListView.OnScrollListener() { // from class: com.blued.android.framework.view.pulltorefresh.PinnedSectionListView.1
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                if (PinnedSectionListView.this.a != null) {
                    PinnedSectionListView.this.a.onScroll(absListView, i, i2, i3);
                }
                ListAdapter adapter = PinnedSectionListView.this.getAdapter();
                if (adapter == null || i2 == 0) {
                    return;
                }
                if (PinnedSectionListView.a(adapter, adapter.getItemViewType(i))) {
                    if (PinnedSectionListView.this.getChildAt(0).getTop() == PinnedSectionListView.this.getPaddingTop()) {
                        PinnedSectionListView.this.a();
                        return;
                    } else {
                        PinnedSectionListView.this.a(i, i, i2);
                        return;
                    }
                }
                int b = PinnedSectionListView.this.b(i);
                if (b > -1) {
                    PinnedSectionListView.this.a(b, i, i2);
                } else {
                    PinnedSectionListView.this.a();
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (PinnedSectionListView.this.a != null) {
                    PinnedSectionListView.this.a.onScrollStateChanged(absListView, i);
                }
            }
        };
        this.n = new DataSetObserver() { // from class: com.blued.android.framework.view.pulltorefresh.PinnedSectionListView.2
            @Override // android.database.DataSetObserver
            public void onChanged() {
                PinnedSectionListView.this.b();
            }

            @Override // android.database.DataSetObserver
            public void onInvalidated() {
                PinnedSectionListView.this.b();
            }
        };
        c();
    }

    public PinnedSectionListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.e = new Rect();
        this.f = new PointF();
        this.m = new AbsListView.OnScrollListener() { // from class: com.blued.android.framework.view.pulltorefresh.PinnedSectionListView.1
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i2, int i22, int i3) {
                if (PinnedSectionListView.this.a != null) {
                    PinnedSectionListView.this.a.onScroll(absListView, i2, i22, i3);
                }
                ListAdapter adapter = PinnedSectionListView.this.getAdapter();
                if (adapter == null || i22 == 0) {
                    return;
                }
                if (PinnedSectionListView.a(adapter, adapter.getItemViewType(i2))) {
                    if (PinnedSectionListView.this.getChildAt(0).getTop() == PinnedSectionListView.this.getPaddingTop()) {
                        PinnedSectionListView.this.a();
                        return;
                    } else {
                        PinnedSectionListView.this.a(i2, i2, i22);
                        return;
                    }
                }
                int b = PinnedSectionListView.this.b(i2);
                if (b > -1) {
                    PinnedSectionListView.this.a(b, i2, i22);
                } else {
                    PinnedSectionListView.this.a();
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i2) {
                if (PinnedSectionListView.this.a != null) {
                    PinnedSectionListView.this.a.onScrollStateChanged(absListView, i2);
                }
            }
        };
        this.n = new DataSetObserver() { // from class: com.blued.android.framework.view.pulltorefresh.PinnedSectionListView.2
            @Override // android.database.DataSetObserver
            public void onChanged() {
                PinnedSectionListView.this.b();
            }

            @Override // android.database.DataSetObserver
            public void onInvalidated() {
                PinnedSectionListView.this.b();
            }
        };
        c();
    }

    private boolean a(View view, float f, float f2) {
        view.getHitRect(this.e);
        this.e.top += this.d;
        this.e.bottom += this.d + getPaddingTop();
        this.e.left += getPaddingLeft();
        this.e.right -= getPaddingRight();
        return this.e.contains((int) f, (int) f2);
    }

    public static boolean a(ListAdapter listAdapter, int i) {
        ListAdapter listAdapter2 = listAdapter;
        if (listAdapter instanceof HeaderViewListAdapter) {
            listAdapter2 = ((HeaderViewListAdapter) listAdapter).getWrappedAdapter();
        }
        return ((PinnedSectionListAdapter) listAdapter2).a(i);
    }

    private void c() {
        setOnScrollListener(this.m);
        this.g = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        a(true);
    }

    private void d() {
        this.h = null;
        MotionEvent motionEvent = this.i;
        if (motionEvent != null) {
            motionEvent.recycle();
            this.i = null;
        }
    }

    private boolean e() {
        AdapterView.OnItemClickListener onItemClickListener;
        if (this.c == null || (onItemClickListener = getOnItemClickListener()) == null) {
            return false;
        }
        View view = this.c.a;
        playSoundEffect(0);
        if (view != null) {
            view.sendAccessibilityEvent(1);
        }
        onItemClickListener.onItemClick(this, view, this.c.b, this.c.c);
        return true;
    }

    int a(int i, int i2) {
        ListAdapter adapter = getAdapter();
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= i2) {
                return -1;
            }
            int i5 = i + i4;
            if (a(adapter, adapter.getItemViewType(i5))) {
                return i5;
            }
            i3 = i4 + 1;
        }
    }

    void a() {
        PinnedSection pinnedSection = this.c;
        if (pinnedSection != null) {
            this.b = pinnedSection;
            this.c = null;
        }
    }

    void a(int i) {
        PinnedSection pinnedSection = this.b;
        this.b = null;
        PinnedSection pinnedSection2 = pinnedSection;
        if (pinnedSection == null) {
            pinnedSection2 = new PinnedSection();
        }
        View view = getAdapter().getView(i, pinnedSection2.a, this);
        AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) view.getLayoutParams();
        AbsListView.LayoutParams layoutParams2 = layoutParams;
        if (layoutParams == null) {
            layoutParams2 = new AbsListView.LayoutParams(-1, -2);
        }
        int mode = View.MeasureSpec.getMode(layoutParams2.height);
        int size = View.MeasureSpec.getSize(layoutParams2.height);
        int i2 = mode;
        if (mode == 0) {
            i2 = 1073741824;
        }
        int height = (getHeight() - getListPaddingTop()) - getListPaddingBottom();
        int i3 = size;
        if (size > height) {
            i3 = height;
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec((getWidth() - getListPaddingLeft()) - getListPaddingRight(), 1073741824);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i3, i2);
        view.setLayoutParams(new AbsListView.LayoutParams(-2, -2));
        view.measure(makeMeasureSpec, makeMeasureSpec2);
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
        this.d = 0;
        view.setBackgroundResource(R.drawable.group_distance_bg);
        pinnedSection2.a = view;
        pinnedSection2.b = i;
        pinnedSection2.c = getAdapter().getItemId(i);
        this.c = pinnedSection2;
    }

    void a(int i, int i2, int i3) {
        if (i3 < 2) {
            a();
            return;
        }
        PinnedSection pinnedSection = this.c;
        if (pinnedSection != null && pinnedSection.b != i) {
            a();
        }
        if (this.c == null) {
            a(i);
        }
        int i4 = i + 1;
        if (i4 < getCount()) {
            int a = a(i4, i3 - (i4 - i2));
            if (a <= -1) {
                this.d = 0;
                this.k = Integer.MAX_VALUE;
                return;
            }
            int top = getChildAt(a - i2).getTop() - (this.c.a.getBottom() + getPaddingTop());
            this.k = top;
            if (top < 0) {
                this.d = top;
            } else {
                this.d = 0;
            }
        }
    }

    public void a(boolean z) {
        if (z) {
            if (this.j == null) {
                this.j = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{Color.parseColor("#ffa0a0a0"), Color.parseColor("#50a0a0a0"), Color.parseColor("#00a0a0a0")});
                this.l = (int) (getResources().getDisplayMetrics().density * 8.0f);
            }
        } else if (this.j != null) {
            this.j = null;
            this.l = 0;
        }
    }

    int b(int i) {
        ListAdapter adapter = getAdapter();
        int i2 = i;
        if (adapter instanceof SectionIndexer) {
            SectionIndexer sectionIndexer = (SectionIndexer) adapter;
            int positionForSection = sectionIndexer.getPositionForSection(sectionIndexer.getSectionForPosition(i));
            i2 = i;
            if (a(adapter, adapter.getItemViewType(positionForSection))) {
                return positionForSection;
            }
        }
        while (i2 >= 0) {
            if (a(adapter, adapter.getItemViewType(i2))) {
                return i2;
            }
            i2--;
        }
        return -1;
    }

    void b() {
        int firstVisiblePosition;
        int b;
        a();
        ListAdapter adapter = getAdapter();
        if (adapter == null || adapter.getCount() <= 0 || (b = b((firstVisiblePosition = getFirstVisiblePosition()))) == -1) {
            return;
        }
        a(b, firstVisiblePosition, getLastVisiblePosition() - firstVisiblePosition);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.c != null) {
            int listPaddingLeft = getListPaddingLeft();
            int listPaddingTop = getListPaddingTop();
            View view = this.c.a;
            canvas.save();
            canvas.clipRect(listPaddingLeft, listPaddingTop, view.getWidth() + listPaddingLeft, view.getHeight() + (this.j == null ? 0 : Math.min(this.l, this.k)) + listPaddingTop);
            canvas.translate(listPaddingLeft, listPaddingTop + this.d);
            drawChild(canvas, this.c.a, getDrawingTime());
            GradientDrawable gradientDrawable = this.j;
            if (gradientDrawable != null && this.k > 0) {
                gradientDrawable.setBounds(this.c.a.getLeft(), this.c.a.getBottom(), this.c.a.getRight(), this.c.a.getBottom() + this.l);
                this.j.draw(canvas);
            }
            canvas.restore();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        PinnedSection pinnedSection;
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        int action = motionEvent.getAction();
        if (action == 0 && this.h == null && (pinnedSection = this.c) != null && a(pinnedSection.a, x, y)) {
            this.h = this.c.a;
            this.f.x = x;
            this.f.y = y;
            this.i = MotionEvent.obtain(motionEvent);
        }
        View view = this.h;
        if (view != null) {
            if (a(view, x, y)) {
                this.h.dispatchTouchEvent(motionEvent);
            }
            if (action == 1) {
                super.dispatchTouchEvent(motionEvent);
                e();
                d();
                return true;
            } else if (action == 3) {
                d();
                return true;
            } else if (action != 2 || Math.abs(y - this.f.y) <= this.g) {
                return true;
            } else {
                MotionEvent obtain = MotionEvent.obtain(motionEvent);
                obtain.setAction(3);
                this.h.dispatchTouchEvent(obtain);
                obtain.recycle();
                super.dispatchTouchEvent(this.i);
                super.dispatchTouchEvent(motionEvent);
                d();
                return true;
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.c == null || ((i3 - i) - getPaddingLeft()) - getPaddingRight() == this.c.a.getWidth()) {
            return;
        }
        b();
    }

    @Override // android.widget.AbsListView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        super.onRestoreInstanceState(parcelable);
        post(new Runnable() { // from class: com.blued.android.framework.view.pulltorefresh.PinnedSectionListView.3
            @Override // java.lang.Runnable
            public void run() {
                PinnedSectionListView.this.b();
            }
        });
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView
    public void setAdapter(ListAdapter listAdapter) {
        ListAdapter adapter = getAdapter();
        if (adapter != null) {
            adapter.unregisterDataSetObserver(this.n);
        }
        if (listAdapter != null) {
            listAdapter.registerDataSetObserver(this.n);
        }
        if (adapter != listAdapter) {
            a();
        }
        super.setAdapter(listAdapter);
    }

    @Override // android.widget.AbsListView
    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        if (onScrollListener == this.m) {
            super.setOnScrollListener(onScrollListener);
        } else {
            this.a = onScrollListener;
        }
    }

    public void setShadowVisible(boolean z) {
        a(z);
        PinnedSection pinnedSection = this.c;
        if (pinnedSection != null) {
            View view = pinnedSection.a;
            invalidate(view.getLeft(), view.getTop(), view.getRight(), view.getBottom() + this.l);
        }
    }
}
