package com.soft.blued.customview.swipecard;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.FrameLayout;
import com.soft.blued.R;
import com.soft.blued.customview.swipecard.FlingCardListener;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/customview/swipecard/SwipeFlingAdapterView.class */
public class SwipeFlingAdapterView extends BaseFlingAdapterView {

    /* renamed from: a  reason: collision with root package name */
    public View f28663a;
    public int b;

    /* renamed from: c  reason: collision with root package name */
    public int f28664c;
    public int d;
    public int e;
    private int f;
    private int g;
    private int h;
    private int i;
    private float j;
    private int k;
    private Adapter l;
    private onFlingListener m;
    private AdapterDataSetObserver n;
    private boolean o;
    private OnItemClickListener p;
    private FlingCardListener q;
    private float r;
    private float s;
    private float t;
    private float u;

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/customview/swipecard/SwipeFlingAdapterView$AdapterDataSetObserver.class */
    class AdapterDataSetObserver extends DataSetObserver {
        private AdapterDataSetObserver() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            SwipeFlingAdapterView.this.o = false;
            SwipeFlingAdapterView.this.requestLayout();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            SwipeFlingAdapterView.this.o = false;
            SwipeFlingAdapterView.this.requestLayout();
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/customview/swipecard/SwipeFlingAdapterView$OnItemClickListener.class */
    public interface OnItemClickListener {
        void a(MotionEvent motionEvent, View view, Object obj);
    }

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/customview/swipecard/SwipeFlingAdapterView$onFlingListener.class */
    public interface onFlingListener {
        void a();

        void a(float f, float f2);

        void a(int i);

        void a(Object obj);

        void b(Object obj);
    }

    public SwipeFlingAdapterView(Context context) {
        this(context, null);
    }

    public SwipeFlingAdapterView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SwipeFlingAdapterView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.g = 20;
        this.h = 7;
        this.i = 3;
        this.j = 2.0f;
        this.k = 0;
        this.o = false;
        this.f28663a = null;
        this.r = 0.0f;
        this.s = 0.0f;
        this.t = 0.0f;
        this.u = 0.0f;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SwipeFlingAdapterView, i, 0);
        this.h = obtainStyledAttributes.getInt(0, this.h);
        this.i = obtainStyledAttributes.getInt(1, this.i);
        this.j = obtainStyledAttributes.getFloat(2, this.j);
        this.f = obtainStyledAttributes.getDimensionPixelOffset(3, 0);
        obtainStyledAttributes.recycle();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(float f) {
        View view;
        int i;
        if (this.o) {
            int intValue = getTag(R.id.current_index) == null ? 0 : ((Integer) getTag(R.id.current_index)).intValue();
            int intValue2 = getTag(R.id.total_szie) == null ? 0 : ((Integer) getTag(R.id.total_szie)).intValue();
            int i2 = intValue2 - 1;
            View view2 = null;
            if (intValue == i2 && intValue != 0) {
                view = getChildAt(this.k - 1);
            } else if (intValue < i2) {
                int i3 = 1;
                int i4 = 1;
                while (true) {
                    i = i4;
                    if (i3 > this.h / 2) {
                        break;
                    }
                    int i5 = i;
                    if (intValue + i3 < intValue2) {
                        i5 = i + 1;
                    }
                    i3++;
                    i4 = i5;
                }
                view = getChildAt(this.k - i);
            } else {
                view = null;
            }
            if (intValue < i2) {
                view2 = getChildAt(this.k - 1);
            }
            if (view2 != null && f <= 0.0f) {
                float f2 = (1.0f - (f * 0.3f)) - 0.3f;
                view2.setScaleX(f2);
                view2.setScaleY(f2);
                int i6 = this.f28664c;
                int i7 = this.f;
                view2.setX((int) (i6 + i7 + (i7 * f)));
                if (view != null) {
                    view.setScaleX(0.7f);
                    view.setScaleY(0.7f);
                    int i8 = this.f28664c;
                    int i9 = this.f;
                    view.setX((i8 - i9) + (i9 * 0));
                }
            }
            if (view == null || f < 0.0f) {
                return;
            }
            float f3 = ((f * 0.3f) + 1.0f) - 0.3f;
            view.setScaleX(f3);
            view.setScaleY(f3);
            int i10 = this.f28664c;
            int i11 = this.f;
            view.setX((int) ((i10 - i11) + (i11 * f)));
            if (view2 != null) {
                view2.setScaleX(0.7f);
                view2.setScaleY(0.7f);
                int i12 = this.f28664c;
                int i13 = this.f;
                view2.setX(i12 + i13 + (i13 * 0));
            }
        }
    }

    private void a(int i, int i2) {
        while (i < Math.min(i2, this.h)) {
            View view = this.l.getView(i, null, this);
            if (view.getVisibility() != 8) {
                a(view, i);
                this.k = i;
            }
            i++;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0137  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(android.view.View r8, int r9) {
        /*
            Method dump skipped, instructions count: 375
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.soft.blued.customview.swipecard.SwipeFlingAdapterView.a(android.view.View, int):void");
    }

    private void b(View view, int i) {
        if (i < 1 || i >= this.h) {
            return;
        }
        int i2 = 0;
        int intValue = getTag(R.id.current_index) == null ? 0 : ((Integer) getTag(R.id.current_index)).intValue();
        if (getTag(R.id.total_szie) != null) {
            i2 = ((Integer) getTag(R.id.total_szie)).intValue();
        }
        if (i <= this.h / 2) {
            if (intValue + i < i2) {
                view.offsetLeftAndRight(this.f);
                this.t = view.getX();
                this.u = view.getY();
            } else {
                view.offsetLeftAndRight(-this.f);
                this.r = view.getX();
                this.s = view.getY();
            }
        }
        if (i > this.h / 2) {
            view.offsetLeftAndRight(-this.f);
            this.r = view.getX();
            this.s = view.getY();
        }
        view.setScaleX(0.7f);
        view.setScaleY(0.7f);
    }

    private void setTopView(int i) {
        if (getChildCount() > 0) {
            View childAt = getChildAt(this.k);
            this.f28663a = childAt;
            if (childAt == null || this.m == null) {
                return;
            }
            childAt.setTag(R.id.current_index, getTag(R.id.current_index));
            this.f28663a.setTag(R.id.total_szie, getTag(R.id.total_szie));
            this.f28663a.setTag(R.id.left_x, Float.valueOf(this.r));
            this.f28663a.setTag(R.id.left_y, Float.valueOf(this.s));
            this.f28663a.setTag(R.id.right_x, Float.valueOf(this.t));
            this.f28663a.setTag(R.id.right_y, Float.valueOf(this.u));
            this.f28663a.setTag(R.id.scale_x, Float.valueOf(0.7f));
            this.f28663a.setTag(R.id.scale_Y, Float.valueOf(0.7f));
            FlingCardListener flingCardListener = new FlingCardListener(this.f28663a, this.l.getItem(0), this.j, new FlingCardListener.FlingListener() { // from class: com.soft.blued.customview.swipecard.SwipeFlingAdapterView.1
                @Override // com.soft.blued.customview.swipecard.FlingCardListener.FlingListener
                public void a() {
                    SwipeFlingAdapterView.this.f28663a = null;
                    SwipeFlingAdapterView.this.m.a();
                }

                @Override // com.soft.blued.customview.swipecard.FlingCardListener.FlingListener
                public void a(float f, float f2) {
                    SwipeFlingAdapterView.this.a(f);
                    SwipeFlingAdapterView.this.m.a(f, f2);
                }

                @Override // com.soft.blued.customview.swipecard.FlingCardListener.FlingListener
                public void a(MotionEvent motionEvent, View view, Object obj) {
                    if (SwipeFlingAdapterView.this.p != null) {
                        SwipeFlingAdapterView.this.p.a(motionEvent, view, obj);
                    }
                }

                @Override // com.soft.blued.customview.swipecard.FlingCardListener.FlingListener
                public void a(Object obj) {
                    SwipeFlingAdapterView.this.o = false;
                    SwipeFlingAdapterView.this.m.a(obj);
                }

                @Override // com.soft.blued.customview.swipecard.FlingCardListener.FlingListener
                public void b(Object obj) {
                    SwipeFlingAdapterView.this.o = false;
                    SwipeFlingAdapterView.this.m.b(obj);
                }
            });
            this.q = flingCardListener;
            this.f28663a.setOnTouchListener(flingCardListener);
        }
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new FrameLayout.LayoutParams(getContext(), attributeSet);
    }

    @Override // android.widget.AdapterView
    public Adapter getAdapter() {
        return this.l;
    }

    @Override // com.soft.blued.customview.swipecard.BaseFlingAdapterView
    public /* bridge */ /* synthetic */ int getHeightMeasureSpec() {
        return super.getHeightMeasureSpec();
    }

    @Override // android.widget.AdapterView
    public View getSelectedView() {
        return this.f28663a;
    }

    public FlingCardListener getTopCardListener() throws NullPointerException {
        FlingCardListener flingCardListener = this.q;
        if (flingCardListener != null) {
            return flingCardListener;
        }
        throw new NullPointerException("flingCardListener is null");
    }

    public int getVisibleCount() {
        return this.h;
    }

    @Override // com.soft.blued.customview.swipecard.BaseFlingAdapterView
    public /* bridge */ /* synthetic */ int getWidthMeasureSpec() {
        return super.getWidthMeasureSpec();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        onFlingListener onflinglistener;
        View view;
        super.onLayout(z, i, i2, i3, i4);
        Adapter adapter = this.l;
        if (adapter == null || this.o) {
            return;
        }
        int count = adapter.getCount();
        if (count == 0) {
            removeAllViewsInLayout();
        } else {
            removeAllViewsInLayout();
            a(0, count);
            setTopView(count);
        }
        this.o = true;
        if (this.b == 0 && this.f28664c == 0 && (view = this.f28663a) != null) {
            this.b = view.getTop();
            this.f28664c = this.f28663a.getLeft();
            this.d = this.f28663a.getRight();
            this.e = this.f28663a.getBottom();
            if (this.r == 0.0f) {
                int i5 = this.f28664c;
                float f = (int) (i5 - (this.t - i5));
                this.r = f;
                this.s = this.u;
                this.f28663a.setTag(R.id.left_x, Float.valueOf(f));
                this.f28663a.setTag(R.id.left_y, Float.valueOf(this.s));
            }
            if (this.t == 0.0f) {
                int i6 = this.f28664c;
                float f2 = (int) (i6 + (i6 - this.r));
                this.t = f2;
                this.u = this.s;
                this.f28663a.setTag(R.id.right_x, Float.valueOf(f2));
                this.f28663a.setTag(R.id.right_y, Float.valueOf(this.u));
            }
        }
        if (count >= this.i || (onflinglistener = this.m) == null) {
            return;
        }
        onflinglistener.a(count);
    }

    @Override // android.widget.AdapterView
    public void setAdapter(Adapter adapter) {
        AdapterDataSetObserver adapterDataSetObserver;
        Adapter adapter2 = this.l;
        if (adapter2 != null && (adapterDataSetObserver = this.n) != null) {
            adapter2.unregisterDataSetObserver(adapterDataSetObserver);
            this.n = null;
        }
        this.l = adapter;
        if (adapter == null || this.n != null) {
            return;
        }
        AdapterDataSetObserver adapterDataSetObserver2 = new AdapterDataSetObserver();
        this.n = adapterDataSetObserver2;
        this.l.registerDataSetObserver(adapterDataSetObserver2);
    }

    public void setFlingListener(onFlingListener onflinglistener) {
        this.m = onflinglistener;
    }

    public void setMaxVisible(int i) {
        this.h = i;
    }

    public void setMinStackInAdapter(int i) {
        this.i = i;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.p = onItemClickListener;
    }

    @Override // com.soft.blued.customview.swipecard.BaseFlingAdapterView, android.widget.AdapterView
    public /* bridge */ /* synthetic */ void setSelection(int i) {
        super.setSelection(i);
    }
}
