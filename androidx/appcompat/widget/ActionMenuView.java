package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.widget.LinearLayoutCompat;

/* loaded from: source-8756600-dex2jar.jar:androidx/appcompat/widget/ActionMenuView.class */
public class ActionMenuView extends LinearLayoutCompat implements MenuBuilder.ItemInvoker, MenuView {

    /* renamed from: a  reason: collision with root package name */
    MenuBuilder.Callback f1717a;
    OnMenuItemClickListener b;

    /* renamed from: c  reason: collision with root package name */
    private MenuBuilder f1718c;
    private Context d;
    private int e;
    private boolean f;
    private ActionMenuPresenter g;
    private MenuPresenter.Callback h;
    private boolean i;
    private int j;
    private int k;
    private int l;

    /* loaded from: source-8756600-dex2jar.jar:androidx/appcompat/widget/ActionMenuView$ActionMenuChildView.class */
    public interface ActionMenuChildView {
        boolean needsDividerAfter();

        boolean needsDividerBefore();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/appcompat/widget/ActionMenuView$ActionMenuPresenterCallback.class */
    public static class ActionMenuPresenterCallback implements MenuPresenter.Callback {
        ActionMenuPresenterCallback() {
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
        public void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
        public boolean onOpenSubMenu(MenuBuilder menuBuilder) {
            return false;
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/appcompat/widget/ActionMenuView$LayoutParams.class */
    public static class LayoutParams extends LinearLayoutCompat.LayoutParams {

        /* renamed from: a  reason: collision with root package name */
        boolean f1719a;
        @ViewDebug.ExportedProperty
        public int cellsUsed;
        @ViewDebug.ExportedProperty
        public boolean expandable;
        @ViewDebug.ExportedProperty
        public int extraPixels;
        @ViewDebug.ExportedProperty
        public boolean isOverflowButton;
        @ViewDebug.ExportedProperty
        public boolean preventEdgeOffset;

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.isOverflowButton = false;
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((ViewGroup.LayoutParams) layoutParams);
            this.isOverflowButton = layoutParams.isOverflowButton;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/appcompat/widget/ActionMenuView$MenuBuilderCallback.class */
    public class MenuBuilderCallback implements MenuBuilder.Callback {
        MenuBuilderCallback() {
        }

        @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
        public boolean onMenuItemSelected(MenuBuilder menuBuilder, MenuItem menuItem) {
            return ActionMenuView.this.b != null && ActionMenuView.this.b.onMenuItemClick(menuItem);
        }

        @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
        public void onMenuModeChange(MenuBuilder menuBuilder) {
            if (ActionMenuView.this.f1717a != null) {
                ActionMenuView.this.f1717a.onMenuModeChange(menuBuilder);
            }
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/appcompat/widget/ActionMenuView$OnMenuItemClickListener.class */
    public interface OnMenuItemClickListener {
        boolean onMenuItemClick(MenuItem menuItem);
    }

    public ActionMenuView(Context context) {
        this(context, null);
    }

    public ActionMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setBaselineAligned(false);
        float f = context.getResources().getDisplayMetrics().density;
        this.k = (int) (56.0f * f);
        this.l = (int) (f * 4.0f);
        this.d = context;
        this.e = 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(View view, int i, int i2, int i3, int i4) {
        int i5;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i3) - i4, View.MeasureSpec.getMode(i3));
        ActionMenuItemView actionMenuItemView = view instanceof ActionMenuItemView ? (ActionMenuItemView) view : null;
        boolean z = true;
        boolean z2 = actionMenuItemView != null && actionMenuItemView.hasText();
        if (i2 <= 0 || (z2 && i2 < 2)) {
            i5 = 0;
        } else {
            view.measure(View.MeasureSpec.makeMeasureSpec(i2 * i, Integer.MIN_VALUE), makeMeasureSpec);
            int measuredWidth = view.getMeasuredWidth();
            int i6 = measuredWidth / i;
            i5 = i6;
            if (measuredWidth % i != 0) {
                i5 = i6 + 1;
            }
            if (z2 && i5 < 2) {
                i5 = 2;
            }
        }
        if (layoutParams.isOverflowButton || !z2) {
            z = false;
        }
        layoutParams.expandable = z;
        layoutParams.cellsUsed = i5;
        view.measure(View.MeasureSpec.makeMeasureSpec(i * i5, 1073741824), makeMeasureSpec);
        return i5;
    }

    private void a(int i, int i2) {
        boolean z;
        int i3;
        boolean z2;
        boolean z3;
        long j;
        int i4;
        int i5;
        long j2;
        int i6;
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int childMeasureSpec = getChildMeasureSpec(i2, paddingTop, -2);
        int i7 = size - (paddingLeft + paddingRight);
        int i8 = this.k;
        int i9 = i7 / i8;
        if (i9 == 0) {
            setMeasuredDimension(i7, 0);
            return;
        }
        int i10 = i8 + ((i7 % i8) / i9);
        int childCount = getChildCount();
        int i11 = 0;
        int i12 = 0;
        boolean z4 = false;
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        long j3 = 0;
        while (i12 < childCount) {
            View childAt = getChildAt(i12);
            if (childAt.getVisibility() == 8) {
                i6 = i15;
            } else {
                boolean z5 = childAt instanceof ActionMenuItemView;
                i13++;
                if (z5) {
                    int i16 = this.l;
                    childAt.setPadding(i16, 0, i16, 0);
                }
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                layoutParams.f1719a = false;
                layoutParams.extraPixels = 0;
                layoutParams.cellsUsed = 0;
                layoutParams.expandable = false;
                layoutParams.leftMargin = 0;
                layoutParams.rightMargin = 0;
                layoutParams.preventEdgeOffset = z5 && ((ActionMenuItemView) childAt).hasText();
                int a2 = a(childAt, i10, layoutParams.isOverflowButton ? 1 : i9, childMeasureSpec, paddingTop);
                i14 = Math.max(i14, a2);
                i6 = i15;
                if (layoutParams.expandable) {
                    i6 = i15 + 1;
                }
                if (layoutParams.isOverflowButton) {
                    z4 = true;
                }
                i9 -= a2;
                i11 = Math.max(i11, childAt.getMeasuredHeight());
                if (a2 == 1) {
                    j3 |= 1 << i12;
                }
            }
            i12++;
            i15 = i6;
        }
        boolean z6 = false;
        int i17 = i9;
        boolean z7 = z4 && i13 == 2;
        while (i15 > 0 && i17 > 0) {
            int i18 = 0;
            int i19 = 0;
            int i20 = Integer.MAX_VALUE;
            long j4 = 0;
            while (true) {
                j = j4;
                if (i19 >= childCount) {
                    break;
                }
                LayoutParams layoutParams2 = (LayoutParams) getChildAt(i19).getLayoutParams();
                if (!layoutParams2.expandable) {
                    i4 = i18;
                    i5 = i20;
                    j2 = j;
                } else if (layoutParams2.cellsUsed < i20) {
                    i5 = layoutParams2.cellsUsed;
                    j2 = 1 << i19;
                    i4 = 1;
                } else {
                    i4 = i18;
                    i5 = i20;
                    j2 = j;
                    if (layoutParams2.cellsUsed == i20) {
                        i4 = i18 + 1;
                        j2 = j | (1 << i19);
                        i5 = i20;
                    }
                }
                i19++;
                i18 = i4;
                i20 = i5;
                j4 = j2;
            }
            z = z6;
            i3 = i11;
            j3 |= j;
            if (i18 > i17) {
                break;
            }
            int i21 = 0;
            while (true) {
                int i22 = i21;
                if (i22 < childCount) {
                    View childAt2 = getChildAt(i22);
                    LayoutParams layoutParams3 = (LayoutParams) childAt2.getLayoutParams();
                    long j5 = 1 << i22;
                    if ((j & j5) == 0) {
                        long j6 = j3;
                        if (layoutParams3.cellsUsed == i20 + 1) {
                            j6 = j3 | j5;
                        }
                        j3 = j6;
                    } else {
                        if (z7 && layoutParams3.preventEdgeOffset && i17 == 1) {
                            int i23 = this.l;
                            childAt2.setPadding(i23 + i10, 0, i23, 0);
                        }
                        layoutParams3.cellsUsed++;
                        layoutParams3.f1719a = true;
                        i17--;
                    }
                    i21 = i22 + 1;
                }
            }
            i11 = i3;
            z6 = true;
        }
        z = z6;
        i3 = i11;
        boolean z8 = !z4 && i13 == 1;
        if (i17 > 0 && j3 != 0 && (i17 < i13 - 1 || z8 || i14 > 1)) {
            float bitCount = Long.bitCount(j3);
            if (!z8) {
                float f = bitCount;
                if ((j3 & 1) != 0) {
                    f = bitCount;
                    if (!((LayoutParams) getChildAt(0).getLayoutParams()).preventEdgeOffset) {
                        f = bitCount - 0.5f;
                    }
                }
                int i24 = childCount - 1;
                bitCount = f;
                if ((j3 & (1 << i24)) != 0) {
                    bitCount = f;
                    if (!((LayoutParams) getChildAt(i24).getLayoutParams()).preventEdgeOffset) {
                        bitCount = f - 0.5f;
                    }
                }
            }
            int i25 = bitCount > 0.0f ? (int) ((i17 * i10) / bitCount) : 0;
            int i26 = 0;
            while (true) {
                z2 = z;
                if (i26 >= childCount) {
                    break;
                }
                if ((j3 & (1 << i26)) == 0) {
                    z3 = z;
                } else {
                    View childAt3 = getChildAt(i26);
                    LayoutParams layoutParams4 = (LayoutParams) childAt3.getLayoutParams();
                    if (childAt3 instanceof ActionMenuItemView) {
                        layoutParams4.extraPixels = i25;
                        layoutParams4.f1719a = true;
                        if (i26 == 0 && !layoutParams4.preventEdgeOffset) {
                            layoutParams4.leftMargin = (-i25) / 2;
                        }
                    } else if (layoutParams4.isOverflowButton) {
                        layoutParams4.extraPixels = i25;
                        layoutParams4.f1719a = true;
                        layoutParams4.rightMargin = (-i25) / 2;
                    } else {
                        if (i26 != 0) {
                            layoutParams4.leftMargin = i25 / 2;
                        }
                        z3 = z;
                        if (i26 != childCount - 1) {
                            layoutParams4.rightMargin = i25 / 2;
                            z3 = z;
                        }
                    }
                    z3 = true;
                }
                i26++;
                z = z3;
            }
        } else {
            z2 = z;
        }
        if (z2) {
            int i27 = 0;
            while (true) {
                int i28 = i27;
                if (i28 >= childCount) {
                    break;
                }
                View childAt4 = getChildAt(i28);
                LayoutParams layoutParams5 = (LayoutParams) childAt4.getLayoutParams();
                if (layoutParams5.f1719a) {
                    childAt4.measure(View.MeasureSpec.makeMeasureSpec((layoutParams5.cellsUsed * i10) + layoutParams5.extraPixels, 1073741824), childMeasureSpec);
                }
                i27 = i28 + 1;
            }
        }
        if (mode == 1073741824) {
            i3 = size2;
        }
        setMeasuredDimension(i7, i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    /* renamed from: a */
    public LayoutParams generateDefaultLayoutParams() {
        LayoutParams layoutParams = new LayoutParams(-2, -2);
        layoutParams.gravity = 16;
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    /* renamed from: a */
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams != null) {
            LayoutParams layoutParams2 = layoutParams instanceof LayoutParams ? new LayoutParams((LayoutParams) layoutParams) : new LayoutParams(layoutParams);
            if (layoutParams2.gravity <= 0) {
                layoutParams2.gravity = 16;
            }
            return layoutParams2;
        }
        return generateDefaultLayoutParams();
    }

    protected boolean a(int i) {
        if (i == 0) {
            return false;
        }
        View childAt = getChildAt(i - 1);
        View childAt2 = getChildAt(i);
        boolean z = false;
        if (i < getChildCount()) {
            z = false;
            if (childAt instanceof ActionMenuChildView) {
                z = false | ((ActionMenuChildView) childAt).needsDividerAfter();
            }
        }
        boolean z2 = z;
        if (i > 0) {
            z2 = z;
            if (childAt2 instanceof ActionMenuChildView) {
                z2 = z | ((ActionMenuChildView) childAt2).needsDividerBefore();
            }
        }
        return z2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public void dismissPopupMenus() {
        ActionMenuPresenter actionMenuPresenter = this.g;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.dismissPopupMenus();
        }
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return false;
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public LayoutParams generateOverflowButtonLayoutParams() {
        LayoutParams generateDefaultLayoutParams = generateDefaultLayoutParams();
        generateDefaultLayoutParams.isOverflowButton = true;
        return generateDefaultLayoutParams;
    }

    public Menu getMenu() {
        if (this.f1718c == null) {
            Context context = getContext();
            MenuBuilder menuBuilder = new MenuBuilder(context);
            this.f1718c = menuBuilder;
            menuBuilder.setCallback(new MenuBuilderCallback());
            ActionMenuPresenter actionMenuPresenter = new ActionMenuPresenter(context);
            this.g = actionMenuPresenter;
            actionMenuPresenter.setReserveOverflow(true);
            ActionMenuPresenter actionMenuPresenter2 = this.g;
            ActionMenuPresenterCallback actionMenuPresenterCallback = this.h;
            if (actionMenuPresenterCallback == null) {
                actionMenuPresenterCallback = new ActionMenuPresenterCallback();
            }
            actionMenuPresenter2.setCallback(actionMenuPresenterCallback);
            this.f1718c.addMenuPresenter(this.g, this.d);
            this.g.setMenuView(this);
        }
        return this.f1718c;
    }

    public Drawable getOverflowIcon() {
        getMenu();
        return this.g.getOverflowIcon();
    }

    public int getPopupTheme() {
        return this.e;
    }

    @Override // androidx.appcompat.view.menu.MenuView
    public int getWindowAnimations() {
        return 0;
    }

    public boolean hideOverflowMenu() {
        ActionMenuPresenter actionMenuPresenter = this.g;
        return actionMenuPresenter != null && actionMenuPresenter.hideOverflowMenu();
    }

    @Override // androidx.appcompat.view.menu.MenuView
    public void initialize(MenuBuilder menuBuilder) {
        this.f1718c = menuBuilder;
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder.ItemInvoker
    public boolean invokeItem(MenuItemImpl menuItemImpl) {
        return this.f1718c.performItemAction(menuItemImpl, 0);
    }

    public boolean isOverflowMenuShowPending() {
        ActionMenuPresenter actionMenuPresenter = this.g;
        return actionMenuPresenter != null && actionMenuPresenter.isOverflowMenuShowPending();
    }

    public boolean isOverflowMenuShowing() {
        ActionMenuPresenter actionMenuPresenter = this.g;
        return actionMenuPresenter != null && actionMenuPresenter.isOverflowMenuShowing();
    }

    public boolean isOverflowReserved() {
        return this.f;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        ActionMenuPresenter actionMenuPresenter = this.g;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.updateMenuView(false);
            if (this.g.isOverflowMenuShowing()) {
                this.g.hideOverflowMenu();
                this.g.showOverflowMenu();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        dismissPopupMenus();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int width;
        int i5;
        if (!this.i) {
            super.onLayout(z, i, i2, i3, i4);
            return;
        }
        int childCount = getChildCount();
        int i6 = (i4 - i2) / 2;
        int dividerWidth = getDividerWidth();
        int i7 = i3 - i;
        int paddingRight = (i7 - getPaddingRight()) - getPaddingLeft();
        boolean isLayoutRtl = ViewUtils.isLayoutRtl(this);
        int i8 = 0;
        int i9 = 0;
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.isOverflowButton) {
                    int measuredWidth = childAt.getMeasuredWidth();
                    int i11 = measuredWidth;
                    if (a(i10)) {
                        i11 = measuredWidth + dividerWidth;
                    }
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (isLayoutRtl) {
                        i5 = getPaddingLeft() + layoutParams.leftMargin;
                        width = i5 + i11;
                    } else {
                        width = (getWidth() - getPaddingRight()) - layoutParams.rightMargin;
                        i5 = width - i11;
                    }
                    int i12 = i6 - (measuredHeight / 2);
                    childAt.layout(i5, i12, width, measuredHeight + i12);
                    paddingRight -= i11;
                    i8 = 1;
                } else {
                    paddingRight -= (childAt.getMeasuredWidth() + layoutParams.leftMargin) + layoutParams.rightMargin;
                    a(i10);
                    i9++;
                }
            }
        }
        if (childCount == 1 && i8 == 0) {
            View childAt2 = getChildAt(0);
            int measuredWidth2 = childAt2.getMeasuredWidth();
            int measuredHeight2 = childAt2.getMeasuredHeight();
            int i13 = (i7 / 2) - (measuredWidth2 / 2);
            int i14 = i6 - (measuredHeight2 / 2);
            childAt2.layout(i13, i14, measuredWidth2 + i13, measuredHeight2 + i14);
            return;
        }
        int i15 = i9 - (i8 ^ 1);
        int max = Math.max(0, i15 > 0 ? paddingRight / i15 : 0);
        if (isLayoutRtl) {
            int width2 = getWidth() - getPaddingRight();
            int i16 = 0;
            while (i16 < childCount) {
                View childAt3 = getChildAt(i16);
                LayoutParams layoutParams2 = (LayoutParams) childAt3.getLayoutParams();
                int i17 = width2;
                if (childAt3.getVisibility() != 8) {
                    if (layoutParams2.isOverflowButton) {
                        i17 = width2;
                    } else {
                        int i18 = width2 - layoutParams2.rightMargin;
                        int measuredWidth3 = childAt3.getMeasuredWidth();
                        int measuredHeight3 = childAt3.getMeasuredHeight();
                        int i19 = i6 - (measuredHeight3 / 2);
                        childAt3.layout(i18 - measuredWidth3, i19, i18, measuredHeight3 + i19);
                        i17 = i18 - ((measuredWidth3 + layoutParams2.leftMargin) + max);
                    }
                }
                i16++;
                width2 = i17;
            }
            return;
        }
        int paddingLeft = getPaddingLeft();
        int i20 = 0;
        while (i20 < childCount) {
            View childAt4 = getChildAt(i20);
            LayoutParams layoutParams3 = (LayoutParams) childAt4.getLayoutParams();
            int i21 = paddingLeft;
            if (childAt4.getVisibility() != 8) {
                if (layoutParams3.isOverflowButton) {
                    i21 = paddingLeft;
                } else {
                    int i22 = paddingLeft + layoutParams3.leftMargin;
                    int measuredWidth4 = childAt4.getMeasuredWidth();
                    int measuredHeight4 = childAt4.getMeasuredHeight();
                    int i23 = i6 - (measuredHeight4 / 2);
                    childAt4.layout(i22, i23, i22 + measuredWidth4, measuredHeight4 + i23);
                    i21 = i22 + measuredWidth4 + layoutParams3.rightMargin + max;
                }
            }
            i20++;
            paddingLeft = i21;
        }
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.View
    protected void onMeasure(int i, int i2) {
        MenuBuilder menuBuilder;
        boolean z = this.i;
        boolean z2 = View.MeasureSpec.getMode(i) == 1073741824;
        this.i = z2;
        if (z != z2) {
            this.j = 0;
        }
        int size = View.MeasureSpec.getSize(i);
        if (this.i && (menuBuilder = this.f1718c) != null && size != this.j) {
            this.j = size;
            menuBuilder.onItemsChanged(true);
        }
        int childCount = getChildCount();
        if (this.i && childCount > 0) {
            a(i, i2);
            return;
        }
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= childCount) {
                super.onMeasure(i, i2);
                return;
            }
            LayoutParams layoutParams = (LayoutParams) getChildAt(i4).getLayoutParams();
            layoutParams.rightMargin = 0;
            layoutParams.leftMargin = 0;
            i3 = i4 + 1;
        }
    }

    public MenuBuilder peekMenu() {
        return this.f1718c;
    }

    public void setExpandedActionViewsExclusive(boolean z) {
        this.g.setExpandedActionViewsExclusive(z);
    }

    public void setMenuCallbacks(MenuPresenter.Callback callback, MenuBuilder.Callback callback2) {
        this.h = callback;
        this.f1717a = callback2;
    }

    public void setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        this.b = onMenuItemClickListener;
    }

    public void setOverflowIcon(Drawable drawable) {
        getMenu();
        this.g.setOverflowIcon(drawable);
    }

    public void setOverflowReserved(boolean z) {
        this.f = z;
    }

    public void setPopupTheme(int i) {
        if (this.e != i) {
            this.e = i;
            if (i == 0) {
                this.d = getContext();
            } else {
                this.d = new ContextThemeWrapper(getContext(), i);
            }
        }
    }

    public void setPresenter(ActionMenuPresenter actionMenuPresenter) {
        this.g = actionMenuPresenter;
        actionMenuPresenter.setMenuView(this);
    }

    public boolean showOverflowMenu() {
        ActionMenuPresenter actionMenuPresenter = this.g;
        return actionMenuPresenter != null && actionMenuPresenter.showOverflowMenu();
    }
}
