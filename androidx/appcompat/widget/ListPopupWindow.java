package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.ShowableListMenu;
import androidx.core.view.ViewCompat;
import androidx.core.widget.PopupWindowCompat;
import com.bytedance.applog.tracker.Tracker;
import java.lang.reflect.Method;

/* loaded from: source-8756600-dex2jar.jar:androidx/appcompat/widget/ListPopupWindow.class */
public class ListPopupWindow implements ShowableListMenu {
    public static final int INPUT_METHOD_FROM_FOCUSABLE = 0;
    public static final int INPUT_METHOD_NEEDED = 1;
    public static final int INPUT_METHOD_NOT_NEEDED = 2;
    public static final int MATCH_PARENT = -1;
    public static final int POSITION_PROMPT_ABOVE = 0;
    public static final int POSITION_PROMPT_BELOW = 1;
    public static final int WRAP_CONTENT = -2;

    /* renamed from: a  reason: collision with root package name */
    private static Method f1783a;
    private static Method b;
    private static Method h;
    private AdapterView.OnItemClickListener A;
    private AdapterView.OnItemSelectedListener B;
    private final PopupTouchInterceptor C;
    private final PopupScrollListener D;
    private final ListSelectorHider E;
    private Runnable F;
    private final Rect G;
    private Rect H;
    private boolean I;

    /* renamed from: c  reason: collision with root package name */
    DropDownListView f1784c;
    int d;
    final ResizePopupRunnable e;
    final Handler f;
    PopupWindow g;
    private Context i;
    private ListAdapter j;
    private int k;
    private int l;
    private int m;
    private int n;
    private int o;
    private boolean p;
    private boolean q;
    private boolean r;
    private int s;
    private boolean t;
    private boolean u;
    private View v;
    private int w;
    private DataSetObserver x;
    private View y;
    private Drawable z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/appcompat/widget/ListPopupWindow$ListSelectorHider.class */
    public class ListSelectorHider implements Runnable {
        ListSelectorHider() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ListPopupWindow.this.clearListSelection();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/appcompat/widget/ListPopupWindow$PopupDataSetObserver.class */
    public class PopupDataSetObserver extends DataSetObserver {
        PopupDataSetObserver() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            if (ListPopupWindow.this.isShowing()) {
                ListPopupWindow.this.show();
            }
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            ListPopupWindow.this.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/appcompat/widget/ListPopupWindow$PopupScrollListener.class */
    public class PopupScrollListener implements AbsListView.OnScrollListener {
        PopupScrollListener() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i != 1 || ListPopupWindow.this.isInputMethodNotNeeded() || ListPopupWindow.this.g.getContentView() == null) {
                return;
            }
            ListPopupWindow.this.f.removeCallbacks(ListPopupWindow.this.e);
            ListPopupWindow.this.e.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/appcompat/widget/ListPopupWindow$PopupTouchInterceptor.class */
    public class PopupTouchInterceptor implements View.OnTouchListener {
        PopupTouchInterceptor() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            if (action == 0 && ListPopupWindow.this.g != null && ListPopupWindow.this.g.isShowing() && x >= 0 && x < ListPopupWindow.this.g.getWidth() && y >= 0 && y < ListPopupWindow.this.g.getHeight()) {
                ListPopupWindow.this.f.postDelayed(ListPopupWindow.this.e, 250L);
                return false;
            } else if (action == 1) {
                ListPopupWindow.this.f.removeCallbacks(ListPopupWindow.this.e);
                return false;
            } else {
                return false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/appcompat/widget/ListPopupWindow$ResizePopupRunnable.class */
    public class ResizePopupRunnable implements Runnable {
        ResizePopupRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ListPopupWindow.this.f1784c == null || !ViewCompat.isAttachedToWindow(ListPopupWindow.this.f1784c) || ListPopupWindow.this.f1784c.getCount() <= ListPopupWindow.this.f1784c.getChildCount() || ListPopupWindow.this.f1784c.getChildCount() > ListPopupWindow.this.d) {
                return;
            }
            ListPopupWindow.this.g.setInputMethodMode(2);
            ListPopupWindow.this.show();
        }
    }

    static {
        if (Build.VERSION.SDK_INT <= 28) {
            try {
                f1783a = PopupWindow.class.getDeclaredMethod("setClipToScreenEnabled", Boolean.TYPE);
            } catch (NoSuchMethodException e) {
                Log.i("ListPopupWindow", "Could not find method setClipToScreenEnabled() on PopupWindow. Oh well.");
            }
            try {
                h = PopupWindow.class.getDeclaredMethod("setEpicenterBounds", Rect.class);
            } catch (NoSuchMethodException e2) {
                Log.i("ListPopupWindow", "Could not find method setEpicenterBounds(Rect) on PopupWindow. Oh well.");
            }
        }
        if (Build.VERSION.SDK_INT <= 23) {
            try {
                b = PopupWindow.class.getDeclaredMethod("getMaxAvailableHeight", View.class, Integer.TYPE, Boolean.TYPE);
            } catch (NoSuchMethodException e3) {
                Log.i("ListPopupWindow", "Could not find method getMaxAvailableHeight(View, int, boolean) on PopupWindow. Oh well.");
            }
        }
    }

    public ListPopupWindow(Context context) {
        this(context, null, R.attr.listPopupWindowStyle);
    }

    public ListPopupWindow(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.listPopupWindowStyle);
    }

    public ListPopupWindow(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public ListPopupWindow(Context context, AttributeSet attributeSet, int i, int i2) {
        this.k = -2;
        this.l = -2;
        this.o = 1002;
        this.s = 0;
        this.t = false;
        this.u = false;
        this.d = Integer.MAX_VALUE;
        this.w = 0;
        this.e = new ResizePopupRunnable();
        this.C = new PopupTouchInterceptor();
        this.D = new PopupScrollListener();
        this.E = new ListSelectorHider();
        this.G = new Rect();
        this.i = context;
        this.f = new Handler(context.getMainLooper());
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ListPopupWindow, i, i2);
        this.m = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.ListPopupWindow_android_dropDownHorizontalOffset, 0);
        int dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.ListPopupWindow_android_dropDownVerticalOffset, 0);
        this.n = dimensionPixelOffset;
        if (dimensionPixelOffset != 0) {
            this.p = true;
        }
        obtainStyledAttributes.recycle();
        AppCompatPopupWindow appCompatPopupWindow = new AppCompatPopupWindow(context, attributeSet, i, i2);
        this.g = appCompatPopupWindow;
        appCompatPopupWindow.setInputMethodMode(1);
    }

    private int a(View view, int i, boolean z) {
        if (Build.VERSION.SDK_INT <= 23) {
            Method method = b;
            if (method != null) {
                try {
                    return ((Integer) method.invoke(this.g, view, Integer.valueOf(i), Boolean.valueOf(z))).intValue();
                } catch (Exception e) {
                    Log.i("ListPopupWindow", "Could not call getMaxAvailableHeightMethod(View, int, boolean) on PopupWindow. Using the public version.");
                }
            }
            return this.g.getMaxAvailableHeight(view, i);
        }
        return this.g.getMaxAvailableHeight(view, i, z);
    }

    private void a() {
        View view = this.v;
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.v);
            }
        }
    }

    private void a(boolean z) {
        if (Build.VERSION.SDK_INT > 28) {
            this.g.setIsClippedToScreen(z);
            return;
        }
        Method method = f1783a;
        if (method != null) {
            try {
                method.invoke(this.g, Boolean.valueOf(z));
            } catch (Exception e) {
                Log.i("ListPopupWindow", "Could not call setClipToScreenEnabled() on PopupWindow. Oh well.");
            }
        }
    }

    private static boolean a(int i) {
        return i == 66 || i == 23;
    }

    private int b() {
        int i;
        int i2;
        LinearLayout linearLayout;
        int i3;
        boolean z = true;
        if (this.f1784c == null) {
            Context context = this.i;
            this.F = new Runnable() { // from class: androidx.appcompat.widget.ListPopupWindow.2
                @Override // java.lang.Runnable
                public void run() {
                    View anchorView = ListPopupWindow.this.getAnchorView();
                    if (anchorView == null || anchorView.getWindowToken() == null) {
                        return;
                    }
                    ListPopupWindow.this.show();
                }
            };
            DropDownListView a2 = a(context, !this.I);
            this.f1784c = a2;
            Drawable drawable = this.z;
            if (drawable != null) {
                a2.setSelector(drawable);
            }
            this.f1784c.setAdapter(this.j);
            this.f1784c.setOnItemClickListener(this.A);
            this.f1784c.setFocusable(true);
            this.f1784c.setFocusableInTouchMode(true);
            this.f1784c.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: androidx.appcompat.widget.ListPopupWindow.3
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> adapterView, View view, int i4, long j) {
                    DropDownListView dropDownListView;
                    Tracker.onItemSelected(adapterView, view, i4, j);
                    if (i4 == -1 || (dropDownListView = ListPopupWindow.this.f1784c) == null) {
                        return;
                    }
                    dropDownListView.setListSelectionHidden(false);
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });
            this.f1784c.setOnScrollListener(this.D);
            AdapterView.OnItemSelectedListener onItemSelectedListener = this.B;
            if (onItemSelectedListener != null) {
                this.f1784c.setOnItemSelectedListener(onItemSelectedListener);
            }
            DropDownListView dropDownListView = this.f1784c;
            View view = this.v;
            if (view != null) {
                LinearLayout linearLayout2 = new LinearLayout(context);
                linearLayout2.setOrientation(1);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0, 1.0f);
                int i4 = this.w;
                if (i4 == 0) {
                    linearLayout2.addView(view);
                    linearLayout2.addView(dropDownListView, layoutParams);
                } else if (i4 != 1) {
                    Log.e("ListPopupWindow", "Invalid hint position " + this.w);
                } else {
                    linearLayout2.addView(dropDownListView, layoutParams);
                    linearLayout2.addView(view);
                }
                int i5 = this.l;
                if (i5 >= 0) {
                    i3 = Integer.MIN_VALUE;
                } else {
                    i5 = 0;
                    i3 = 0;
                }
                view.measure(View.MeasureSpec.makeMeasureSpec(i5, i3), 0);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) view.getLayoutParams();
                i = view.getMeasuredHeight() + layoutParams2.topMargin + layoutParams2.bottomMargin;
                linearLayout = linearLayout2;
            } else {
                i = 0;
                linearLayout = dropDownListView;
            }
            this.g.setContentView(linearLayout);
        } else {
            ViewGroup viewGroup = (ViewGroup) this.g.getContentView();
            View view2 = this.v;
            if (view2 != null) {
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) view2.getLayoutParams();
                i = view2.getMeasuredHeight() + layoutParams3.topMargin + layoutParams3.bottomMargin;
            } else {
                i = 0;
            }
        }
        Drawable background = this.g.getBackground();
        if (background != null) {
            background.getPadding(this.G);
            int i6 = this.G.top + this.G.bottom;
            i2 = i6;
            if (!this.p) {
                this.n = -this.G.top;
                i2 = i6;
            }
        } else {
            this.G.setEmpty();
            i2 = 0;
        }
        if (this.g.getInputMethodMode() != 2) {
            z = false;
        }
        int a3 = a(getAnchorView(), this.n, z);
        if (this.t || this.k == -1) {
            return a3 + i2;
        }
        int i7 = this.l;
        int measureHeightOfChildrenCompat = this.f1784c.measureHeightOfChildrenCompat(i7 != -2 ? i7 != -1 ? View.MeasureSpec.makeMeasureSpec(i7, 1073741824) : View.MeasureSpec.makeMeasureSpec(this.i.getResources().getDisplayMetrics().widthPixels - (this.G.left + this.G.right), 1073741824) : View.MeasureSpec.makeMeasureSpec(this.i.getResources().getDisplayMetrics().widthPixels - (this.G.left + this.G.right), Integer.MIN_VALUE), 0, -1, a3 - i, -1);
        int i8 = i;
        if (measureHeightOfChildrenCompat > 0) {
            i8 = i + i2 + this.f1784c.getPaddingTop() + this.f1784c.getPaddingBottom();
        }
        return measureHeightOfChildrenCompat + i8;
    }

    DropDownListView a(Context context, boolean z) {
        return new DropDownListView(context, z);
    }

    public void clearListSelection() {
        DropDownListView dropDownListView = this.f1784c;
        if (dropDownListView != null) {
            dropDownListView.setListSelectionHidden(true);
            dropDownListView.requestLayout();
        }
    }

    public View.OnTouchListener createDragToOpenListener(View view) {
        return new ForwardingListener(view) { // from class: androidx.appcompat.widget.ListPopupWindow.1
            @Override // androidx.appcompat.widget.ForwardingListener
            public ListPopupWindow getPopup() {
                return ListPopupWindow.this;
            }
        };
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public void dismiss() {
        this.g.dismiss();
        a();
        this.g.setContentView(null);
        this.f1784c = null;
        this.f.removeCallbacks(this.e);
    }

    public View getAnchorView() {
        return this.y;
    }

    public int getAnimationStyle() {
        return this.g.getAnimationStyle();
    }

    public Drawable getBackground() {
        return this.g.getBackground();
    }

    public Rect getEpicenterBounds() {
        if (this.H != null) {
            return new Rect(this.H);
        }
        return null;
    }

    public int getHeight() {
        return this.k;
    }

    public int getHorizontalOffset() {
        return this.m;
    }

    public int getInputMethodMode() {
        return this.g.getInputMethodMode();
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public ListView getListView() {
        return this.f1784c;
    }

    public int getPromptPosition() {
        return this.w;
    }

    public Object getSelectedItem() {
        if (isShowing()) {
            return this.f1784c.getSelectedItem();
        }
        return null;
    }

    public long getSelectedItemId() {
        if (isShowing()) {
            return this.f1784c.getSelectedItemId();
        }
        return Long.MIN_VALUE;
    }

    public int getSelectedItemPosition() {
        if (isShowing()) {
            return this.f1784c.getSelectedItemPosition();
        }
        return -1;
    }

    public View getSelectedView() {
        if (isShowing()) {
            return this.f1784c.getSelectedView();
        }
        return null;
    }

    public int getSoftInputMode() {
        return this.g.getSoftInputMode();
    }

    public int getVerticalOffset() {
        if (this.p) {
            return this.n;
        }
        return 0;
    }

    public int getWidth() {
        return this.l;
    }

    public boolean isDropDownAlwaysVisible() {
        return this.t;
    }

    public boolean isInputMethodNotNeeded() {
        return this.g.getInputMethodMode() == 2;
    }

    public boolean isModal() {
        return this.I;
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public boolean isShowing() {
        return this.g.isShowing();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (!isShowing() || i == 62) {
            return false;
        }
        if (this.f1784c.getSelectedItemPosition() >= 0 || !a(i)) {
            int selectedItemPosition = this.f1784c.getSelectedItemPosition();
            boolean z = !this.g.isAboveAnchor();
            ListAdapter listAdapter = this.j;
            int i2 = Integer.MAX_VALUE;
            int i3 = Integer.MIN_VALUE;
            if (listAdapter != null) {
                boolean areAllItemsEnabled = listAdapter.areAllItemsEnabled();
                i2 = areAllItemsEnabled ? 0 : this.f1784c.lookForSelectablePosition(0, true);
                i3 = areAllItemsEnabled ? listAdapter.getCount() - 1 : this.f1784c.lookForSelectablePosition(listAdapter.getCount() - 1, false);
            }
            if ((z && i == 19 && selectedItemPosition <= i2) || (!z && i == 20 && selectedItemPosition >= i3)) {
                clearListSelection();
                this.g.setInputMethodMode(1);
                show();
                return true;
            }
            this.f1784c.setListSelectionHidden(false);
            if (!this.f1784c.onKeyDown(i, keyEvent)) {
                return (z && i == 20) ? selectedItemPosition == i3 : !z && i == 19 && selectedItemPosition == i2;
            }
            this.g.setInputMethodMode(2);
            this.f1784c.requestFocusFromTouch();
            show();
            return i == 19 || i == 20 || i == 23 || i == 66;
        }
        return false;
    }

    public boolean onKeyPreIme(int i, KeyEvent keyEvent) {
        if (i == 4 && isShowing()) {
            View view = this.y;
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                KeyEvent.DispatcherState keyDispatcherState = view.getKeyDispatcherState();
                if (keyDispatcherState != null) {
                    keyDispatcherState.startTracking(keyEvent, this);
                    return true;
                }
                return true;
            } else if (keyEvent.getAction() == 1) {
                KeyEvent.DispatcherState keyDispatcherState2 = view.getKeyDispatcherState();
                if (keyDispatcherState2 != null) {
                    keyDispatcherState2.handleUpEvent(keyEvent);
                }
                if (!keyEvent.isTracking() || keyEvent.isCanceled()) {
                    return false;
                }
                dismiss();
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (!isShowing() || this.f1784c.getSelectedItemPosition() < 0) {
            return false;
        }
        boolean onKeyUp = this.f1784c.onKeyUp(i, keyEvent);
        if (onKeyUp && a(i)) {
            dismiss();
        }
        return onKeyUp;
    }

    public boolean performItemClick(int i) {
        if (isShowing()) {
            if (this.A != null) {
                DropDownListView dropDownListView = this.f1784c;
                this.A.onItemClick(dropDownListView, dropDownListView.getChildAt(i - dropDownListView.getFirstVisiblePosition()), i, dropDownListView.getAdapter().getItemId(i));
                return true;
            }
            return true;
        }
        return false;
    }

    public void postShow() {
        this.f.post(this.F);
    }

    public void setAdapter(ListAdapter listAdapter) {
        DataSetObserver dataSetObserver = this.x;
        if (dataSetObserver == null) {
            this.x = new PopupDataSetObserver();
        } else {
            ListAdapter listAdapter2 = this.j;
            if (listAdapter2 != null) {
                listAdapter2.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.j = listAdapter;
        if (listAdapter != null) {
            listAdapter.registerDataSetObserver(this.x);
        }
        DropDownListView dropDownListView = this.f1784c;
        if (dropDownListView != null) {
            dropDownListView.setAdapter(this.j);
        }
    }

    public void setAnchorView(View view) {
        this.y = view;
    }

    public void setAnimationStyle(int i) {
        this.g.setAnimationStyle(i);
    }

    public void setBackgroundDrawable(Drawable drawable) {
        this.g.setBackgroundDrawable(drawable);
    }

    public void setContentWidth(int i) {
        Drawable background = this.g.getBackground();
        if (background == null) {
            setWidth(i);
            return;
        }
        background.getPadding(this.G);
        this.l = this.G.left + this.G.right + i;
    }

    public void setDropDownAlwaysVisible(boolean z) {
        this.t = z;
    }

    public void setDropDownGravity(int i) {
        this.s = i;
    }

    public void setEpicenterBounds(Rect rect) {
        this.H = rect != null ? new Rect(rect) : null;
    }

    public void setForceIgnoreOutsideTouch(boolean z) {
        this.u = z;
    }

    public void setHeight(int i) {
        if (i < 0 && -2 != i && -1 != i) {
            throw new IllegalArgumentException("Invalid height. Must be a positive value, MATCH_PARENT, or WRAP_CONTENT.");
        }
        this.k = i;
    }

    public void setHorizontalOffset(int i) {
        this.m = i;
    }

    public void setInputMethodMode(int i) {
        this.g.setInputMethodMode(i);
    }

    public void setListSelector(Drawable drawable) {
        this.z = drawable;
    }

    public void setModal(boolean z) {
        this.I = z;
        this.g.setFocusable(z);
    }

    public void setOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
        this.g.setOnDismissListener(onDismissListener);
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.A = onItemClickListener;
    }

    public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener onItemSelectedListener) {
        this.B = onItemSelectedListener;
    }

    public void setOverlapAnchor(boolean z) {
        this.r = true;
        this.q = z;
    }

    public void setPromptPosition(int i) {
        this.w = i;
    }

    public void setPromptView(View view) {
        boolean isShowing = isShowing();
        if (isShowing) {
            a();
        }
        this.v = view;
        if (isShowing) {
            show();
        }
    }

    public void setSelection(int i) {
        DropDownListView dropDownListView = this.f1784c;
        if (!isShowing() || dropDownListView == null) {
            return;
        }
        dropDownListView.setListSelectionHidden(false);
        dropDownListView.setSelection(i);
        if (dropDownListView.getChoiceMode() != 0) {
            dropDownListView.setItemChecked(i, true);
        }
    }

    public void setSoftInputMode(int i) {
        this.g.setSoftInputMode(i);
    }

    public void setVerticalOffset(int i) {
        this.n = i;
        this.p = true;
    }

    public void setWidth(int i) {
        this.l = i;
    }

    public void setWindowLayoutType(int i) {
        this.o = i;
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public void show() {
        int i;
        int i2;
        int b2 = b();
        boolean isInputMethodNotNeeded = isInputMethodNotNeeded();
        PopupWindowCompat.setWindowLayoutType(this.g, this.o);
        boolean z = true;
        if (this.g.isShowing()) {
            if (ViewCompat.isAttachedToWindow(getAnchorView())) {
                int i3 = this.l;
                if (i3 == -1) {
                    i2 = -1;
                } else {
                    i2 = i3;
                    if (i3 == -2) {
                        i2 = getAnchorView().getWidth();
                    }
                }
                int i4 = this.k;
                if (i4 == -1) {
                    if (!isInputMethodNotNeeded) {
                        b2 = -1;
                    }
                    if (isInputMethodNotNeeded) {
                        this.g.setWidth(this.l == -1 ? -1 : 0);
                        this.g.setHeight(0);
                    } else {
                        this.g.setWidth(this.l == -1 ? -1 : 0);
                        this.g.setHeight(-1);
                    }
                } else if (i4 != -2) {
                    b2 = i4;
                }
                PopupWindow popupWindow = this.g;
                if (this.u || this.t) {
                    z = false;
                }
                popupWindow.setOutsideTouchable(z);
                PopupWindow popupWindow2 = this.g;
                View anchorView = getAnchorView();
                int i5 = this.m;
                int i6 = this.n;
                if (i2 < 0) {
                    i2 = -1;
                }
                if (b2 < 0) {
                    b2 = -1;
                }
                popupWindow2.update(anchorView, i5, i6, i2, b2);
                return;
            }
            return;
        }
        int i7 = this.l;
        if (i7 == -1) {
            i = -1;
        } else {
            i = i7;
            if (i7 == -2) {
                i = getAnchorView().getWidth();
            }
        }
        int i8 = this.k;
        if (i8 == -1) {
            b2 = -1;
        } else if (i8 != -2) {
            b2 = i8;
        }
        this.g.setWidth(i);
        this.g.setHeight(b2);
        a(true);
        this.g.setOutsideTouchable((this.u || this.t) ? false : true);
        this.g.setTouchInterceptor(this.C);
        if (this.r) {
            PopupWindowCompat.setOverlapAnchor(this.g, this.q);
        }
        if (Build.VERSION.SDK_INT <= 28) {
            Method method = h;
            if (method != null) {
                try {
                    method.invoke(this.g, this.H);
                } catch (Exception e) {
                    Log.e("ListPopupWindow", "Could not invoke setEpicenterBounds on PopupWindow", e);
                }
            }
        } else {
            this.g.setEpicenterBounds(this.H);
        }
        PopupWindowCompat.showAsDropDown(this.g, getAnchorView(), this.m, this.n, this.s);
        this.f1784c.setSelection(-1);
        if (!this.I || this.f1784c.isInTouchMode()) {
            clearListSelection();
        }
        if (this.I) {
            return;
        }
        this.f.post(this.E);
    }
}
