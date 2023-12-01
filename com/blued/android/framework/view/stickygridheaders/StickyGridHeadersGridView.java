package com.blued.android.framework.view.stickygridheaders;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListAdapter;
import com.alipay.sdk.util.i;
import com.blued.android.framework.view.stickygridheaders.StickyGridHeadersBaseAdapterWrapper;
import com.bytedance.applog.tracker.Tracker;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/view/stickygridheaders/StickyGridHeadersGridView.class */
public class StickyGridHeadersGridView extends GridView implements AbsListView.OnScrollListener, AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener, AdapterView.OnItemSelectedListener {
    private AdapterView.OnItemClickListener A;
    private AdapterView.OnItemLongClickListener B;
    private AdapterView.OnItemSelectedListener C;
    private PerformHeaderClick D;
    private AbsListView.OnScrollListener E;
    private int F;
    private View G;
    private Runnable H;
    private int I;
    private int J;
    public CheckForHeaderLongPress b;

    /* renamed from: c  reason: collision with root package name */
    public CheckForHeaderTap f10304c;
    protected StickyGridHeadersBaseAdapterWrapper d;
    protected boolean e;
    protected int f;
    protected int g;
    boolean h;
    private boolean j;
    private final Rect k;
    private boolean l;
    private boolean m;
    private int n;
    private long o;
    private DataSetObserver p;
    private int q;
    private boolean r;
    private int s;
    private boolean t;
    private float u;
    private int v;
    private boolean w;
    private int x;
    private OnHeaderClickListener y;
    private OnHeaderLongClickListener z;
    private static final String i = "Error supporting platform " + Build.VERSION.SDK_INT + ".";

    /* renamed from: a  reason: collision with root package name */
    static final String f10303a = StickyGridHeadersGridView.class.getSimpleName();

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/view/stickygridheaders/StickyGridHeadersGridView$CheckForHeaderLongPress.class */
    class CheckForHeaderLongPress extends WindowRunnable implements Runnable {
        private CheckForHeaderLongPress() {
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            StickyGridHeadersGridView stickyGridHeadersGridView = StickyGridHeadersGridView.this;
            View a2 = stickyGridHeadersGridView.a(stickyGridHeadersGridView.f);
            if (a2 != null) {
                StickyGridHeadersGridView stickyGridHeadersGridView2 = StickyGridHeadersGridView.this;
                if (!((!b() || StickyGridHeadersGridView.this.e) ? false : StickyGridHeadersGridView.this.b(a2, stickyGridHeadersGridView2.b(stickyGridHeadersGridView2.f)))) {
                    StickyGridHeadersGridView.this.g = 2;
                    return;
                }
                StickyGridHeadersGridView.this.g = -2;
                StickyGridHeadersGridView.this.setPressed(false);
                a2.setPressed(false);
            }
        }
    }

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/view/stickygridheaders/StickyGridHeadersGridView$CheckForHeaderTap.class */
    final class CheckForHeaderTap implements Runnable {
        CheckForHeaderTap() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (StickyGridHeadersGridView.this.g == 0) {
                StickyGridHeadersGridView.this.g = 1;
                StickyGridHeadersGridView stickyGridHeadersGridView = StickyGridHeadersGridView.this;
                View a2 = stickyGridHeadersGridView.a(stickyGridHeadersGridView.f);
                if (a2 == null || StickyGridHeadersGridView.this.h) {
                    return;
                }
                if (StickyGridHeadersGridView.this.e) {
                    StickyGridHeadersGridView.this.g = 2;
                    return;
                }
                a2.setPressed(true);
                StickyGridHeadersGridView.this.setPressed(true);
                StickyGridHeadersGridView.this.refreshDrawableState();
                int longPressTimeout = ViewConfiguration.getLongPressTimeout();
                if (!StickyGridHeadersGridView.this.isLongClickable()) {
                    StickyGridHeadersGridView.this.g = 2;
                    return;
                }
                if (StickyGridHeadersGridView.this.b == null) {
                    StickyGridHeadersGridView stickyGridHeadersGridView2 = StickyGridHeadersGridView.this;
                    stickyGridHeadersGridView2.b = new CheckForHeaderLongPress();
                }
                StickyGridHeadersGridView.this.b.a();
                StickyGridHeadersGridView stickyGridHeadersGridView3 = StickyGridHeadersGridView.this;
                stickyGridHeadersGridView3.postDelayed(stickyGridHeadersGridView3.b, longPressTimeout);
            }
        }
    }

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/view/stickygridheaders/StickyGridHeadersGridView$OnHeaderClickListener.class */
    public interface OnHeaderClickListener {
        void a(AdapterView<?> adapterView, View view, long j);
    }

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/view/stickygridheaders/StickyGridHeadersGridView$OnHeaderLongClickListener.class */
    public interface OnHeaderLongClickListener {
        boolean a(AdapterView<?> adapterView, View view, long j);
    }

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/view/stickygridheaders/StickyGridHeadersGridView$PerformHeaderClick.class */
    class PerformHeaderClick extends WindowRunnable implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        int f10311a;

        private PerformHeaderClick() {
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            int i;
            View a2;
            if (StickyGridHeadersGridView.this.e || StickyGridHeadersGridView.this.d == null || StickyGridHeadersGridView.this.d.getCount() <= 0 || (i = this.f10311a) == -1 || i >= StickyGridHeadersGridView.this.d.getCount() || !b() || (a2 = StickyGridHeadersGridView.this.a(this.f10311a)) == null) {
                return;
            }
            StickyGridHeadersGridView stickyGridHeadersGridView = StickyGridHeadersGridView.this;
            stickyGridHeadersGridView.a(a2, stickyGridHeadersGridView.b(this.f10311a));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/view/stickygridheaders/StickyGridHeadersGridView$RuntimePlatformSupportException.class */
    public class RuntimePlatformSupportException extends RuntimeException {
        private static final long serialVersionUID = -6512098808936536538L;

        public RuntimePlatformSupportException(Exception exc) {
            super(StickyGridHeadersGridView.i, exc);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/view/stickygridheaders/StickyGridHeadersGridView$SavedState.class */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.blued.android.framework.view.stickygridheaders.StickyGridHeadersGridView.SavedState.1
            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };

        /* renamed from: a  reason: collision with root package name */
        boolean f10313a;

        private SavedState(Parcel parcel) {
            super(parcel);
            this.f10313a = parcel.readByte() != 0;
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "StickyGridHeadersGridView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " areHeadersSticky=" + this.f10313a + i.d;
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeByte(this.f10313a ? (byte) 1 : (byte) 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/view/stickygridheaders/StickyGridHeadersGridView$WindowRunnable.class */
    public class WindowRunnable {

        /* renamed from: a  reason: collision with root package name */
        private int f10314a;

        private WindowRunnable() {
        }

        public void a() {
            this.f10314a = StickyGridHeadersGridView.this.getWindowAttachCount();
        }

        public boolean b() {
            return StickyGridHeadersGridView.this.hasWindowFocus() && StickyGridHeadersGridView.this.getWindowAttachCount() == this.f10314a;
        }
    }

    public StickyGridHeadersGridView(Context context) {
        this(context, null);
    }

    public StickyGridHeadersGridView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842865);
    }

    public StickyGridHeadersGridView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.j = true;
        this.k = new Rect();
        this.o = -1L;
        this.p = new DataSetObserver() { // from class: com.blued.android.framework.view.stickygridheaders.StickyGridHeadersGridView.1
            @Override // android.database.DataSetObserver
            public void onChanged() {
                StickyGridHeadersGridView.this.c();
            }

            @Override // android.database.DataSetObserver
            public void onInvalidated() {
                StickyGridHeadersGridView.this.c();
            }
        };
        this.t = true;
        this.x = 1;
        this.F = 0;
        this.h = false;
        super.setOnScrollListener(this);
        setVerticalFadingEdgeEnabled(false);
        if (!this.w) {
            this.v = -1;
        }
        this.I = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    private int a(float f) {
        if (this.G == null || f > this.q) {
            int i2 = 0;
            int firstVisiblePosition = getFirstVisiblePosition();
            while (firstVisiblePosition <= getLastVisiblePosition()) {
                if (getItemIdAtPosition(firstVisiblePosition) == -1) {
                    View childAt = getChildAt(i2);
                    int bottom = childAt.getBottom();
                    int top = childAt.getTop();
                    if (f <= bottom && f >= top) {
                        return i2;
                    }
                }
                int i3 = this.x;
                firstVisiblePosition += i3;
                i2 += i3;
            }
            return -1;
        }
        return -2;
    }

    private MotionEvent a(MotionEvent motionEvent, int i2) {
        if (i2 == -2) {
            return motionEvent;
        }
        long downTime = motionEvent.getDownTime();
        long eventTime = motionEvent.getEventTime();
        int action = motionEvent.getAction();
        int pointerCount = motionEvent.getPointerCount();
        int[] b = b(motionEvent);
        MotionEvent.PointerCoords[] a2 = a(motionEvent);
        int metaState = motionEvent.getMetaState();
        float xPrecision = motionEvent.getXPrecision();
        float yPrecision = motionEvent.getYPrecision();
        int deviceId = motionEvent.getDeviceId();
        int edgeFlags = motionEvent.getEdgeFlags();
        int source = motionEvent.getSource();
        int flags = motionEvent.getFlags();
        View childAt = getChildAt(i2);
        for (int i3 = 0; i3 < pointerCount; i3++) {
            a2[i3].y -= childAt.getTop();
        }
        return MotionEvent.obtain(downTime, eventTime, action, pointerCount, b, a2, metaState, xPrecision, yPrecision, deviceId, edgeFlags, source, flags);
    }

    private static MotionEvent.PointerCoords[] a(MotionEvent motionEvent) {
        int pointerCount = motionEvent.getPointerCount();
        MotionEvent.PointerCoords[] pointerCoordsArr = new MotionEvent.PointerCoords[pointerCount];
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= pointerCount) {
                return pointerCoordsArr;
            }
            pointerCoordsArr[i3] = new MotionEvent.PointerCoords();
            motionEvent.getPointerCoords(i3, pointerCoordsArr[i3]);
            i2 = i3 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long b(int i2) {
        return i2 == -2 ? this.o : this.d.b(getFirstVisiblePosition() + i2);
    }

    private void b() {
        if (this.G == null) {
            return;
        }
        int makeMeasureSpec = this.r ? View.MeasureSpec.makeMeasureSpec(getWidth(), 1073741824) : View.MeasureSpec.makeMeasureSpec((getWidth() - getPaddingLeft()) - getPaddingRight(), 1073741824);
        ViewGroup.LayoutParams layoutParams = this.G.getLayoutParams();
        int makeMeasureSpec2 = (layoutParams == null || layoutParams.height <= 0) ? View.MeasureSpec.makeMeasureSpec(0, 0) : View.MeasureSpec.makeMeasureSpec(layoutParams.height, 1073741824);
        this.G.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        this.G.measure(makeMeasureSpec, makeMeasureSpec2);
        if (this.r) {
            this.G.layout(getLeft(), 0, getRight(), this.G.getMeasuredHeight());
        } else {
            this.G.layout(getLeft() + getPaddingLeft(), 0, getRight() - getPaddingRight(), this.G.getMeasuredHeight());
        }
    }

    private static int[] b(MotionEvent motionEvent) {
        int pointerCount = motionEvent.getPointerCount();
        int[] iArr = new int[pointerCount];
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= pointerCount) {
                return iArr;
            }
            iArr[i3] = motionEvent.getPointerId(i3);
            i2 = i3 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        this.q = 0;
        c((View) null);
        this.o = Long.MIN_VALUE;
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:90:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void c(int r7) {
        /*
            Method dump skipped, instructions count: 532
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.framework.view.stickygridheaders.StickyGridHeadersGridView.c(int):void");
    }

    private void c(View view) {
        b(this.G);
        a(view);
        this.G = view;
    }

    private int getHeaderHeight() {
        View view = this.G;
        if (view != null) {
            return view.getMeasuredHeight();
        }
        return 0;
    }

    public View a(int i2) {
        if (i2 == -2) {
            return this.G;
        }
        try {
            return (View) getChildAt(i2).getTag();
        } catch (Exception e) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(View view) {
        if (view == null) {
            return;
        }
        try {
            Field declaredField = View.class.getDeclaredField("mAttachInfo");
            declaredField.setAccessible(true);
            Method declaredMethod = View.class.getDeclaredMethod("dispatchAttachedToWindow", Class.forName("android.view.View$AttachInfo"), Integer.TYPE);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(view, declaredField.get(this), 8);
        } catch (ClassNotFoundException e) {
            throw new RuntimePlatformSupportException(e);
        } catch (IllegalAccessException e2) {
            throw new RuntimePlatformSupportException(e2);
        } catch (IllegalArgumentException e3) {
            throw new RuntimePlatformSupportException(e3);
        } catch (NoSuchFieldException e4) {
            throw new RuntimePlatformSupportException(e4);
        } catch (NoSuchMethodException e5) {
            throw new RuntimePlatformSupportException(e5);
        } catch (InvocationTargetException e6) {
            throw new RuntimePlatformSupportException(e6);
        }
    }

    public boolean a(View view, long j) {
        if (this.y != null) {
            playSoundEffect(0);
            if (view != null) {
                view.sendAccessibilityEvent(1);
            }
            this.y.a(this, view, j);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(View view) {
        if (view == null) {
            return;
        }
        try {
            Method declaredMethod = View.class.getDeclaredMethod("dispatchDetachedFromWindow", new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(view, new Object[0]);
        } catch (IllegalAccessException e) {
            throw new RuntimePlatformSupportException(e);
        } catch (IllegalArgumentException e2) {
            throw new RuntimePlatformSupportException(e2);
        } catch (NoSuchMethodException e3) {
            throw new RuntimePlatformSupportException(e3);
        } catch (InvocationTargetException e4) {
            throw new RuntimePlatformSupportException(e4);
        }
    }

    public boolean b(View view, long j) {
        OnHeaderLongClickListener onHeaderLongClickListener = this.z;
        boolean a2 = onHeaderLongClickListener != null ? onHeaderLongClickListener.a(this, view, j) : false;
        if (a2) {
            if (view != null) {
                view.sendAccessibilityEvent(2);
            }
            performHapticFeedback(0);
        }
        return a2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        if (Build.VERSION.SDK_INT < 8) {
            c(getFirstVisiblePosition());
        }
        View view = this.G;
        boolean z = view != null && this.j && view.getVisibility() == 0;
        int headerHeight = getHeaderHeight();
        int i2 = this.q - headerHeight;
        if (z && this.t) {
            if (this.r) {
                this.k.left = 0;
                this.k.right = getWidth();
            } else {
                this.k.left = getPaddingLeft();
                this.k.right = getWidth() - getPaddingRight();
            }
            this.k.top = this.q;
            this.k.bottom = getHeight();
            canvas.save();
            canvas.clipRect(this.k);
        }
        super.dispatchDraw(canvas);
        ArrayList arrayList = new ArrayList();
        int firstVisiblePosition = getFirstVisiblePosition();
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (firstVisiblePosition > getLastVisiblePosition()) {
                break;
            }
            if (getItemIdAtPosition(firstVisiblePosition) == -1) {
                arrayList.add(Integer.valueOf(i4));
            }
            int i5 = this.x;
            firstVisiblePosition += i5;
            i3 = i4 + i5;
        }
        int i6 = 0;
        while (true) {
            int i7 = i6;
            if (i7 >= arrayList.size()) {
                break;
            }
            View childAt = getChildAt(((Integer) arrayList.get(i7)).intValue());
            try {
                View view2 = (View) childAt.getTag();
                boolean z2 = ((long) ((StickyGridHeadersBaseAdapterWrapper.HeaderFillerView) childAt).getHeaderId()) == this.o && childAt.getTop() < 0 && this.j;
                if (view2.getVisibility() == 0 && !z2) {
                    int makeMeasureSpec = this.r ? View.MeasureSpec.makeMeasureSpec(getWidth(), 1073741824) : View.MeasureSpec.makeMeasureSpec((getWidth() - getPaddingLeft()) - getPaddingRight(), 1073741824);
                    int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
                    view2.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
                    view2.measure(makeMeasureSpec, makeMeasureSpec2);
                    if (this.r) {
                        view2.layout(getLeft(), 0, getRight(), childAt.getHeight());
                    } else {
                        view2.layout(getLeft() + getPaddingLeft(), 0, getRight() - getPaddingRight(), childAt.getHeight());
                    }
                    if (this.r) {
                        this.k.left = 0;
                        this.k.right = getWidth();
                    } else {
                        this.k.left = getPaddingLeft();
                        this.k.right = getWidth() - getPaddingRight();
                    }
                    this.k.bottom = childAt.getBottom();
                    this.k.top = childAt.getTop();
                    canvas.save();
                    canvas.clipRect(this.k);
                    if (this.r) {
                        canvas.translate(0.0f, childAt.getTop());
                    } else {
                        canvas.translate(getPaddingLeft(), childAt.getTop());
                    }
                    view2.draw(canvas);
                    canvas.restore();
                }
                i6 = i7 + 1;
            } catch (Exception e) {
                return;
            }
        }
        if (z && this.t) {
            canvas.restore();
        } else if (!z) {
            return;
        }
        if (this.G.getWidth() != (this.r ? getWidth() : (getWidth() - getPaddingLeft()) - getPaddingRight())) {
            int makeMeasureSpec3 = this.r ? View.MeasureSpec.makeMeasureSpec(getWidth(), 1073741824) : View.MeasureSpec.makeMeasureSpec((getWidth() - getPaddingLeft()) - getPaddingRight(), 1073741824);
            int makeMeasureSpec4 = View.MeasureSpec.makeMeasureSpec(0, 0);
            this.G.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            this.G.measure(makeMeasureSpec3, makeMeasureSpec4);
            if (this.r) {
                this.G.layout(getLeft(), 0, getRight(), this.G.getHeight());
            } else {
                this.G.layout(getLeft() + getPaddingLeft(), 0, getRight() - getPaddingRight(), this.G.getHeight());
            }
        }
        if (this.r) {
            this.k.left = 0;
            this.k.right = getWidth();
        } else {
            this.k.left = getPaddingLeft();
            this.k.right = getWidth() - getPaddingRight();
        }
        this.k.bottom = i2 + headerHeight;
        if (this.l) {
            this.k.top = getPaddingTop();
        } else {
            this.k.top = 0;
        }
        canvas.save();
        canvas.clipRect(this.k);
        if (this.r) {
            canvas.translate(0.0f, i2);
        } else {
            canvas.translate(getPaddingLeft(), i2);
        }
        if (this.q != headerHeight) {
            canvas.saveLayerAlpha(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight(), (this.q * 255) / headerHeight, 31);
        }
        this.G.draw(canvas);
        if (this.q != headerHeight) {
            canvas.restore();
        }
        canvas.restore();
    }

    public View getStickiedHeader() {
        return this.G;
    }

    public boolean getStickyHeaderIsTranscluent() {
        return !this.t;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
        Tracker.onItemClick(adapterView, view, i2, j);
        this.A.onItemClick(adapterView, view, this.d.c(i2).b, j);
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i2, long j) {
        return this.B.onItemLongClick(adapterView, view, this.d.c(i2).b, j);
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> adapterView, View view, int i2, long j) {
        Tracker.onItemSelected(adapterView, view, i2, j);
        this.C.onItemSelected(adapterView, view, this.d.c(i2).b, j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    public void onMeasure(int i2, int i3) {
        int i4;
        int i5 = this.v;
        if (i5 == -1) {
            if (this.n > 0) {
                int max = Math.max((View.MeasureSpec.getSize(i2) - getPaddingLeft()) - getPaddingRight(), 0);
                int i6 = max / this.n;
                i4 = 1;
                if (i6 > 0) {
                    int i7 = i6;
                    while (true) {
                        i4 = i7;
                        if (i4 == 1 || (this.n * i4) + ((i4 - 1) * this.s) <= max) {
                            break;
                        }
                        i7 = i4 - 1;
                    }
                }
            } else {
                i4 = 2;
            }
            this.x = i4;
        } else {
            this.x = i5;
        }
        StickyGridHeadersBaseAdapterWrapper stickyGridHeadersBaseAdapterWrapper = this.d;
        if (stickyGridHeadersBaseAdapterWrapper != null) {
            stickyGridHeadersBaseAdapterWrapper.a(this.x);
        }
        b();
        super.onMeasure(i2, i3);
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> adapterView) {
        this.C.onNothingSelected(adapterView);
    }

    @Override // android.widget.AbsListView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.j = savedState.f10313a;
        requestLayout();
    }

    @Override // android.widget.AbsListView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f10313a = this.j;
        return savedState;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
        AbsListView.OnScrollListener onScrollListener = this.E;
        if (onScrollListener != null) {
            onScrollListener.onScroll(absListView, i2, i3, i4);
        }
        if (Build.VERSION.SDK_INT >= 8) {
            c(i2);
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i2) {
        AbsListView.OnScrollListener onScrollListener = this.E;
        if (onScrollListener != null) {
            onScrollListener.onScrollStateChanged(absListView, i2);
        }
        this.F = i2;
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i2;
        int action = motionEvent.getAction();
        boolean z = this.h;
        if (z) {
            View a2 = a(this.f);
            int i3 = this.f;
            View childAt = i3 == -2 ? a2 : getChildAt(i3);
            if (action == 1 || action == 3) {
                this.h = false;
            }
            if (a2 != null) {
                a2.dispatchTouchEvent(a(motionEvent, this.f));
                a2.invalidate();
                final View view = childAt;
                a2.postDelayed(new Runnable() { // from class: com.blued.android.framework.view.stickygridheaders.StickyGridHeadersGridView.2
                    @Override // java.lang.Runnable
                    public void run() {
                        StickyGridHeadersGridView.this.invalidate(0, view.getTop(), StickyGridHeadersGridView.this.getWidth(), view.getTop() + view.getHeight());
                    }
                }, ViewConfiguration.getPressedStateDuration());
                invalidate(0, childAt.getTop(), getWidth(), childAt.getTop() + childAt.getHeight());
            }
        }
        int i4 = action & 255;
        if (i4 == 0) {
            if (this.f10304c == null) {
                this.f10304c = new CheckForHeaderTap();
            }
            postDelayed(this.f10304c, ViewConfiguration.getTapTimeout());
            float y = (int) motionEvent.getY();
            this.u = y;
            int a3 = a(y);
            this.f = a3;
            if (a3 != -1 && this.F != 2) {
                View a4 = a(a3);
                if (a4 != null) {
                    if (a4.dispatchTouchEvent(a(motionEvent, this.f))) {
                        this.h = true;
                        a4.setPressed(true);
                    }
                    a4.invalidate();
                    int i5 = this.f;
                    View view2 = a4;
                    if (i5 != -2) {
                        view2 = getChildAt(i5);
                    }
                    invalidate(0, view2.getTop(), getWidth(), view2.getTop() + view2.getHeight());
                }
                this.g = 0;
                return true;
            }
        } else if (i4 == 1) {
            int i6 = this.g;
            if (i6 == -2) {
                this.g = -1;
                return true;
            } else if (i6 != -1 && (i2 = this.f) != -1) {
                final View a5 = a(i2);
                if (!z && a5 != null) {
                    if (this.g != 0) {
                        a5.setPressed(false);
                    }
                    if (this.D == null) {
                        this.D = new PerformHeaderClick();
                    }
                    final PerformHeaderClick performHeaderClick = this.D;
                    performHeaderClick.f10311a = this.f;
                    performHeaderClick.a();
                    int i7 = this.g;
                    if (i7 == 0 || i7 == 1) {
                        Handler handler = getHandler();
                        if (handler != null) {
                            handler.removeCallbacks(this.g == 0 ? this.f10304c : this.b);
                        }
                        if (this.e) {
                            this.g = -1;
                        } else {
                            this.g = 1;
                            a5.setPressed(true);
                            setPressed(true);
                            Runnable runnable = this.H;
                            if (runnable != null) {
                                removeCallbacks(runnable);
                            }
                            Runnable runnable2 = new Runnable() { // from class: com.blued.android.framework.view.stickygridheaders.StickyGridHeadersGridView.3
                                @Override // java.lang.Runnable
                                public void run() {
                                    StickyGridHeadersGridView.this.f = -1;
                                    StickyGridHeadersGridView.this.H = null;
                                    StickyGridHeadersGridView.this.g = -1;
                                    a5.setPressed(false);
                                    StickyGridHeadersGridView.this.setPressed(false);
                                    a5.invalidate();
                                    StickyGridHeadersGridView.this.invalidate(0, a5.getTop(), StickyGridHeadersGridView.this.getWidth(), a5.getHeight());
                                    if (StickyGridHeadersGridView.this.e) {
                                        return;
                                    }
                                    performHeaderClick.run();
                                }
                            };
                            this.H = runnable2;
                            postDelayed(runnable2, ViewConfiguration.getPressedStateDuration());
                        }
                    } else if (!this.e) {
                        performHeaderClick.run();
                    }
                }
                this.g = -1;
                return true;
            }
        } else if (i4 == 2 && this.f != -1 && Math.abs(motionEvent.getY() - this.u) > this.I) {
            this.g = -1;
            View a6 = a(this.f);
            if (a6 != null) {
                a6.setPressed(false);
                a6.invalidate();
            }
            Handler handler2 = getHandler();
            if (handler2 != null) {
                handler2.removeCallbacks(this.b);
            }
            this.f = -1;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.widget.AdapterView
    public void setAdapter(ListAdapter listAdapter) {
        DataSetObserver dataSetObserver;
        StickyGridHeadersBaseAdapterWrapper stickyGridHeadersBaseAdapterWrapper = this.d;
        if (stickyGridHeadersBaseAdapterWrapper != null && (dataSetObserver = this.p) != null) {
            stickyGridHeadersBaseAdapterWrapper.unregisterDataSetObserver(dataSetObserver);
        }
        if (!this.m) {
            this.l = true;
        }
        StickyGridHeadersBaseAdapterWrapper stickyGridHeadersBaseAdapterWrapper2 = new StickyGridHeadersBaseAdapterWrapper(getContext(), this, listAdapter instanceof StickyGridHeadersBaseAdapter ? (StickyGridHeadersBaseAdapter) listAdapter : listAdapter instanceof StickyGridHeadersSimpleAdapter ? new StickyGridHeadersSimpleAdapterWrapper((StickyGridHeadersSimpleAdapter) listAdapter) : new StickyGridHeadersListAdapterWrapper(listAdapter));
        this.d = stickyGridHeadersBaseAdapterWrapper2;
        stickyGridHeadersBaseAdapterWrapper2.registerDataSetObserver(this.p);
        c();
        super.setAdapter((ListAdapter) this.d);
    }

    public void setAreHeadersSticky(boolean z) {
        if (z != this.j) {
            this.j = z;
            requestLayout();
        }
    }

    @Override // android.view.ViewGroup
    public void setClipToPadding(boolean z) {
        super.setClipToPadding(z);
        this.l = z;
        this.m = true;
    }

    @Override // android.widget.GridView
    public void setColumnWidth(int i2) {
        super.setColumnWidth(i2);
        this.n = i2;
    }

    public void setHeadersIgnorePadding(boolean z) {
        this.r = z;
    }

    @Override // android.widget.GridView
    public void setHorizontalSpacing(int i2) {
        super.setHorizontalSpacing(i2);
        this.s = i2;
    }

    @Override // android.widget.GridView
    public void setNumColumns(int i2) {
        StickyGridHeadersBaseAdapterWrapper stickyGridHeadersBaseAdapterWrapper;
        super.setNumColumns(i2);
        this.w = true;
        this.v = i2;
        if (i2 == -1 || (stickyGridHeadersBaseAdapterWrapper = this.d) == null) {
            return;
        }
        stickyGridHeadersBaseAdapterWrapper.a(i2);
    }

    public void setOnHeaderClickListener(OnHeaderClickListener onHeaderClickListener) {
        this.y = onHeaderClickListener;
    }

    public void setOnHeaderLongClickListener(OnHeaderLongClickListener onHeaderLongClickListener) {
        if (!isLongClickable()) {
            setLongClickable(true);
        }
        this.z = onHeaderLongClickListener;
    }

    @Override // android.widget.AdapterView
    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.A = onItemClickListener;
        super.setOnItemClickListener(this);
    }

    @Override // android.widget.AdapterView
    public void setOnItemLongClickListener(AdapterView.OnItemLongClickListener onItemLongClickListener) {
        this.B = onItemLongClickListener;
        super.setOnItemLongClickListener(this);
    }

    @Override // android.widget.AdapterView
    public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener onItemSelectedListener) {
        this.C = onItemSelectedListener;
        super.setOnItemSelectedListener(this);
    }

    @Override // android.widget.AbsListView
    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.E = onScrollListener;
    }

    public void setStickyHeaderIsTranscluent(boolean z) {
        this.t = !z;
    }

    @Override // android.widget.GridView
    public void setVerticalSpacing(int i2) {
        super.setVerticalSpacing(i2);
        this.J = i2;
    }
}
