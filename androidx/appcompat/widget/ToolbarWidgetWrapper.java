package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import androidx.appcompat.R;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.menu.ActionMenuItem;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorListenerAdapter;
import com.bytedance.applog.tracker.Tracker;
import com.google.android.material.badge.BadgeDrawable;

/* loaded from: source-8756600-dex2jar.jar:androidx/appcompat/widget/ToolbarWidgetWrapper.class */
public class ToolbarWidgetWrapper implements DecorToolbar {

    /* renamed from: a  reason: collision with root package name */
    Toolbar f1861a;
    CharSequence b;

    /* renamed from: c  reason: collision with root package name */
    Window.Callback f1862c;
    boolean d;
    private int e;
    private View f;
    private Spinner g;
    private View h;
    private Drawable i;
    private Drawable j;
    private Drawable k;
    private boolean l;
    private CharSequence m;
    private CharSequence n;
    private ActionMenuPresenter o;
    private int p;
    private int q;
    private Drawable r;

    public ToolbarWidgetWrapper(Toolbar toolbar, boolean z) {
        this(toolbar, z, R.string.abc_action_bar_up_description, R.drawable.abc_ic_ab_back_material);
    }

    public ToolbarWidgetWrapper(Toolbar toolbar, boolean z, int i, int i2) {
        Drawable drawable;
        this.p = 0;
        this.q = 0;
        this.f1861a = toolbar;
        this.b = toolbar.getTitle();
        this.m = toolbar.getSubtitle();
        this.l = this.b != null;
        this.k = toolbar.getNavigationIcon();
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(toolbar.getContext(), null, R.styleable.ActionBar, R.attr.actionBarStyle, 0);
        this.r = obtainStyledAttributes.getDrawable(R.styleable.ActionBar_homeAsUpIndicator);
        if (z) {
            CharSequence text = obtainStyledAttributes.getText(R.styleable.ActionBar_title);
            if (!TextUtils.isEmpty(text)) {
                setTitle(text);
            }
            CharSequence text2 = obtainStyledAttributes.getText(R.styleable.ActionBar_subtitle);
            if (!TextUtils.isEmpty(text2)) {
                setSubtitle(text2);
            }
            Drawable drawable2 = obtainStyledAttributes.getDrawable(R.styleable.ActionBar_logo);
            if (drawable2 != null) {
                setLogo(drawable2);
            }
            Drawable drawable3 = obtainStyledAttributes.getDrawable(R.styleable.ActionBar_icon);
            if (drawable3 != null) {
                setIcon(drawable3);
            }
            if (this.k == null && (drawable = this.r) != null) {
                setNavigationIcon(drawable);
            }
            setDisplayOptions(obtainStyledAttributes.getInt(R.styleable.ActionBar_displayOptions, 0));
            int resourceId = obtainStyledAttributes.getResourceId(R.styleable.ActionBar_customNavigationLayout, 0);
            if (resourceId != 0) {
                setCustomView(LayoutInflater.from(this.f1861a.getContext()).inflate(resourceId, (ViewGroup) this.f1861a, false));
                setDisplayOptions(this.e | 16);
            }
            int layoutDimension = obtainStyledAttributes.getLayoutDimension(R.styleable.ActionBar_height, 0);
            if (layoutDimension > 0) {
                ViewGroup.LayoutParams layoutParams = this.f1861a.getLayoutParams();
                layoutParams.height = layoutDimension;
                this.f1861a.setLayoutParams(layoutParams);
            }
            int dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.ActionBar_contentInsetStart, -1);
            int dimensionPixelOffset2 = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.ActionBar_contentInsetEnd, -1);
            if (dimensionPixelOffset >= 0 || dimensionPixelOffset2 >= 0) {
                this.f1861a.setContentInsetsRelative(Math.max(dimensionPixelOffset, 0), Math.max(dimensionPixelOffset2, 0));
            }
            int resourceId2 = obtainStyledAttributes.getResourceId(R.styleable.ActionBar_titleTextStyle, 0);
            if (resourceId2 != 0) {
                Toolbar toolbar2 = this.f1861a;
                toolbar2.setTitleTextAppearance(toolbar2.getContext(), resourceId2);
            }
            int resourceId3 = obtainStyledAttributes.getResourceId(R.styleable.ActionBar_subtitleTextStyle, 0);
            if (resourceId3 != 0) {
                Toolbar toolbar3 = this.f1861a;
                toolbar3.setSubtitleTextAppearance(toolbar3.getContext(), resourceId3);
            }
            int resourceId4 = obtainStyledAttributes.getResourceId(R.styleable.ActionBar_popupTheme, 0);
            if (resourceId4 != 0) {
                this.f1861a.setPopupTheme(resourceId4);
            }
        } else {
            this.e = a();
        }
        obtainStyledAttributes.recycle();
        setDefaultNavigationContentDescription(i);
        this.n = this.f1861a.getNavigationContentDescription();
        this.f1861a.setNavigationOnClickListener(new View.OnClickListener() { // from class: androidx.appcompat.widget.ToolbarWidgetWrapper.1

            /* renamed from: a  reason: collision with root package name */
            final ActionMenuItem f1863a;

            {
                this.f1863a = new ActionMenuItem(ToolbarWidgetWrapper.this.f1861a.getContext(), 0, android.R.id.home, 0, 0, ToolbarWidgetWrapper.this.b);
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                if (ToolbarWidgetWrapper.this.f1862c == null || !ToolbarWidgetWrapper.this.d) {
                    return;
                }
                ToolbarWidgetWrapper.this.f1862c.onMenuItemSelected(0, this.f1863a);
            }
        });
    }

    private int a() {
        if (this.f1861a.getNavigationIcon() != null) {
            this.r = this.f1861a.getNavigationIcon();
            return 15;
        }
        return 11;
    }

    private void a(CharSequence charSequence) {
        this.b = charSequence;
        if ((this.e & 8) != 0) {
            this.f1861a.setTitle(charSequence);
            if (this.l) {
                ViewCompat.setAccessibilityPaneTitle(this.f1861a.getRootView(), charSequence);
            }
        }
    }

    private void b() {
        Drawable drawable;
        int i = this.e;
        if ((i & 2) == 0) {
            drawable = null;
        } else if ((i & 1) != 0) {
            drawable = this.j;
            if (drawable == null) {
                drawable = this.i;
            }
        } else {
            drawable = this.i;
        }
        this.f1861a.setLogo(drawable);
    }

    private void c() {
        if (this.g == null) {
            this.g = new AppCompatSpinner(getContext(), null, R.attr.actionDropDownStyle);
            this.g.setLayoutParams(new Toolbar.LayoutParams(-2, -2, 8388627));
        }
    }

    private void d() {
        if ((this.e & 4) == 0) {
            this.f1861a.setNavigationIcon((Drawable) null);
            return;
        }
        Toolbar toolbar = this.f1861a;
        Drawable drawable = this.k;
        if (drawable == null) {
            drawable = this.r;
        }
        toolbar.setNavigationIcon(drawable);
    }

    private void e() {
        if ((this.e & 4) != 0) {
            if (TextUtils.isEmpty(this.n)) {
                this.f1861a.setNavigationContentDescription(this.q);
            } else {
                this.f1861a.setNavigationContentDescription(this.n);
            }
        }
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void animateToVisibility(int i) {
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = setupAnimatorToVisibility(i, 200L);
        if (viewPropertyAnimatorCompat != null) {
            viewPropertyAnimatorCompat.start();
        }
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public boolean canShowOverflowMenu() {
        return this.f1861a.canShowOverflowMenu();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void collapseActionView() {
        this.f1861a.collapseActionView();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void dismissPopupMenus() {
        this.f1861a.dismissPopupMenus();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public Context getContext() {
        return this.f1861a.getContext();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public View getCustomView() {
        return this.h;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public int getDisplayOptions() {
        return this.e;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public int getDropdownItemCount() {
        Spinner spinner = this.g;
        if (spinner != null) {
            return spinner.getCount();
        }
        return 0;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public int getDropdownSelectedPosition() {
        Spinner spinner = this.g;
        if (spinner != null) {
            return spinner.getSelectedItemPosition();
        }
        return 0;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public int getHeight() {
        return this.f1861a.getHeight();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public Menu getMenu() {
        return this.f1861a.getMenu();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public int getNavigationMode() {
        return this.p;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public CharSequence getSubtitle() {
        return this.f1861a.getSubtitle();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public CharSequence getTitle() {
        return this.f1861a.getTitle();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public ViewGroup getViewGroup() {
        return this.f1861a;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public int getVisibility() {
        return this.f1861a.getVisibility();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public boolean hasEmbeddedTabs() {
        return this.f != null;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public boolean hasExpandedActionView() {
        return this.f1861a.hasExpandedActionView();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public boolean hasIcon() {
        return this.i != null;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public boolean hasLogo() {
        return this.j != null;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public boolean hideOverflowMenu() {
        return this.f1861a.hideOverflowMenu();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void initIndeterminateProgress() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void initProgress() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public boolean isOverflowMenuShowPending() {
        return this.f1861a.isOverflowMenuShowPending();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public boolean isOverflowMenuShowing() {
        return this.f1861a.isOverflowMenuShowing();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public boolean isTitleTruncated() {
        return this.f1861a.isTitleTruncated();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void restoreHierarchyState(SparseArray<Parcelable> sparseArray) {
        this.f1861a.restoreHierarchyState(sparseArray);
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void saveHierarchyState(SparseArray<Parcelable> sparseArray) {
        this.f1861a.saveHierarchyState(sparseArray);
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setBackgroundDrawable(Drawable drawable) {
        ViewCompat.setBackground(this.f1861a, drawable);
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setCollapsible(boolean z) {
        this.f1861a.setCollapsible(z);
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setCustomView(View view) {
        View view2 = this.h;
        if (view2 != null && (this.e & 16) != 0) {
            this.f1861a.removeView(view2);
        }
        this.h = view;
        if (view == null || (this.e & 16) == 0) {
            return;
        }
        this.f1861a.addView(view);
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setDefaultNavigationContentDescription(int i) {
        if (i == this.q) {
            return;
        }
        this.q = i;
        if (TextUtils.isEmpty(this.f1861a.getNavigationContentDescription())) {
            setNavigationContentDescription(this.q);
        }
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setDefaultNavigationIcon(Drawable drawable) {
        if (this.r != drawable) {
            this.r = drawable;
            d();
        }
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setDisplayOptions(int i) {
        View view;
        int i2 = this.e ^ i;
        this.e = i;
        if (i2 != 0) {
            if ((i2 & 4) != 0) {
                if ((i & 4) != 0) {
                    e();
                }
                d();
            }
            if ((i2 & 3) != 0) {
                b();
            }
            if ((i2 & 8) != 0) {
                if ((i & 8) != 0) {
                    this.f1861a.setTitle(this.b);
                    this.f1861a.setSubtitle(this.m);
                } else {
                    this.f1861a.setTitle((CharSequence) null);
                    this.f1861a.setSubtitle((CharSequence) null);
                }
            }
            if ((i2 & 16) == 0 || (view = this.h) == null) {
                return;
            }
            if ((i & 16) != 0) {
                this.f1861a.addView(view);
            } else {
                this.f1861a.removeView(view);
            }
        }
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setDropdownParams(SpinnerAdapter spinnerAdapter, AdapterView.OnItemSelectedListener onItemSelectedListener) {
        c();
        this.g.setAdapter(spinnerAdapter);
        this.g.setOnItemSelectedListener(onItemSelectedListener);
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setDropdownSelectedPosition(int i) {
        Spinner spinner = this.g;
        if (spinner == null) {
            throw new IllegalStateException("Can't set dropdown selected position without an adapter");
        }
        spinner.setSelection(i);
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setEmbeddedTabView(ScrollingTabContainerView scrollingTabContainerView) {
        View view = this.f;
        if (view != null) {
            ViewParent parent = view.getParent();
            Toolbar toolbar = this.f1861a;
            if (parent == toolbar) {
                toolbar.removeView(this.f);
            }
        }
        this.f = scrollingTabContainerView;
        if (scrollingTabContainerView == null || this.p != 2) {
            return;
        }
        this.f1861a.addView(scrollingTabContainerView, 0);
        Toolbar.LayoutParams layoutParams = (Toolbar.LayoutParams) this.f.getLayoutParams();
        layoutParams.width = -2;
        layoutParams.height = -2;
        layoutParams.gravity = BadgeDrawable.BOTTOM_START;
        scrollingTabContainerView.setAllowCollapse(true);
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setHomeButtonEnabled(boolean z) {
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setIcon(int i) {
        setIcon(i != 0 ? AppCompatResources.getDrawable(getContext(), i) : null);
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setIcon(Drawable drawable) {
        this.i = drawable;
        b();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setLogo(int i) {
        setLogo(i != 0 ? AppCompatResources.getDrawable(getContext(), i) : null);
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setLogo(Drawable drawable) {
        this.j = drawable;
        b();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setMenu(Menu menu, MenuPresenter.Callback callback) {
        if (this.o == null) {
            ActionMenuPresenter actionMenuPresenter = new ActionMenuPresenter(this.f1861a.getContext());
            this.o = actionMenuPresenter;
            actionMenuPresenter.setId(R.id.action_menu_presenter);
        }
        this.o.setCallback(callback);
        this.f1861a.setMenu((MenuBuilder) menu, this.o);
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setMenuCallbacks(MenuPresenter.Callback callback, MenuBuilder.Callback callback2) {
        this.f1861a.setMenuCallbacks(callback, callback2);
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setMenuPrepared() {
        this.d = true;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setNavigationContentDescription(int i) {
        setNavigationContentDescription(i == 0 ? null : getContext().getString(i));
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setNavigationContentDescription(CharSequence charSequence) {
        this.n = charSequence;
        e();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setNavigationIcon(int i) {
        setNavigationIcon(i != 0 ? AppCompatResources.getDrawable(getContext(), i) : null);
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setNavigationIcon(Drawable drawable) {
        this.k = drawable;
        d();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setNavigationMode(int i) {
        View view;
        int i2 = this.p;
        if (i != i2) {
            if (i2 == 1) {
                Spinner spinner = this.g;
                if (spinner != null) {
                    ViewParent parent = spinner.getParent();
                    Toolbar toolbar = this.f1861a;
                    if (parent == toolbar) {
                        toolbar.removeView(this.g);
                    }
                }
            } else if (i2 == 2 && (view = this.f) != null) {
                ViewParent parent2 = view.getParent();
                Toolbar toolbar2 = this.f1861a;
                if (parent2 == toolbar2) {
                    toolbar2.removeView(this.f);
                }
            }
            this.p = i;
            if (i != 0) {
                if (i == 1) {
                    c();
                    this.f1861a.addView(this.g, 0);
                } else if (i != 2) {
                    throw new IllegalArgumentException("Invalid navigation mode " + i);
                } else {
                    View view2 = this.f;
                    if (view2 != null) {
                        this.f1861a.addView(view2, 0);
                        Toolbar.LayoutParams layoutParams = (Toolbar.LayoutParams) this.f.getLayoutParams();
                        layoutParams.width = -2;
                        layoutParams.height = -2;
                        layoutParams.gravity = BadgeDrawable.BOTTOM_START;
                    }
                }
            }
        }
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setSubtitle(CharSequence charSequence) {
        this.m = charSequence;
        if ((this.e & 8) != 0) {
            this.f1861a.setSubtitle(charSequence);
        }
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setTitle(CharSequence charSequence) {
        this.l = true;
        a(charSequence);
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setVisibility(int i) {
        this.f1861a.setVisibility(i);
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setWindowCallback(Window.Callback callback) {
        this.f1862c = callback;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setWindowTitle(CharSequence charSequence) {
        if (this.l) {
            return;
        }
        a(charSequence);
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public ViewPropertyAnimatorCompat setupAnimatorToVisibility(final int i, long j) {
        return ViewCompat.animate(this.f1861a).alpha(i == 0 ? 1.0f : 0.0f).setDuration(j).setListener(new ViewPropertyAnimatorListenerAdapter() { // from class: androidx.appcompat.widget.ToolbarWidgetWrapper.2

            /* renamed from: c  reason: collision with root package name */
            private boolean f1865c = false;

            @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
            public void onAnimationCancel(View view) {
                this.f1865c = true;
            }

            @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
            public void onAnimationEnd(View view) {
                if (this.f1865c) {
                    return;
                }
                ToolbarWidgetWrapper.this.f1861a.setVisibility(i);
            }

            @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
            public void onAnimationStart(View view) {
                ToolbarWidgetWrapper.this.f1861a.setVisibility(0);
            }
        });
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public boolean showOverflowMenu() {
        return this.f1861a.showOverflowMenu();
    }
}
