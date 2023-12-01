package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.view.CollapsibleActionView;
import androidx.core.internal.view.SupportMenuItem;
import androidx.core.view.ActionProvider;
import com.bytedance.applog.tracker.Tracker;
import java.lang.reflect.Method;

/* loaded from: source-8756600-dex2jar.jar:androidx/appcompat/view/menu/MenuItemWrapperICS.class */
public class MenuItemWrapperICS extends BaseMenuWrapper implements MenuItem {
    private final SupportMenuItem b;

    /* renamed from: c  reason: collision with root package name */
    private Method f1634c;

    /* loaded from: source-8756600-dex2jar.jar:androidx/appcompat/view/menu/MenuItemWrapperICS$ActionProviderWrapper.class */
    class ActionProviderWrapper extends ActionProvider {

        /* renamed from: a  reason: collision with root package name */
        final android.view.ActionProvider f1635a;

        ActionProviderWrapper(Context context, android.view.ActionProvider actionProvider) {
            super(context);
            this.f1635a = actionProvider;
        }

        @Override // androidx.core.view.ActionProvider
        public boolean hasSubMenu() {
            return this.f1635a.hasSubMenu();
        }

        @Override // androidx.core.view.ActionProvider
        public View onCreateActionView() {
            return this.f1635a.onCreateActionView();
        }

        @Override // androidx.core.view.ActionProvider
        public boolean onPerformDefaultAction() {
            return this.f1635a.onPerformDefaultAction();
        }

        @Override // androidx.core.view.ActionProvider
        public void onPrepareSubMenu(SubMenu subMenu) {
            this.f1635a.onPrepareSubMenu(MenuItemWrapperICS.this.a(subMenu));
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/appcompat/view/menu/MenuItemWrapperICS$ActionProviderWrapperJB.class */
    class ActionProviderWrapperJB extends ActionProviderWrapper implements ActionProvider.VisibilityListener {
        private ActionProvider.VisibilityListener d;

        ActionProviderWrapperJB(Context context, android.view.ActionProvider actionProvider) {
            super(context, actionProvider);
        }

        @Override // androidx.core.view.ActionProvider
        public boolean isVisible() {
            return this.f1635a.isVisible();
        }

        @Override // android.view.ActionProvider.VisibilityListener
        public void onActionProviderVisibilityChanged(boolean z) {
            ActionProvider.VisibilityListener visibilityListener = this.d;
            if (visibilityListener != null) {
                visibilityListener.onActionProviderVisibilityChanged(z);
            }
        }

        @Override // androidx.core.view.ActionProvider
        public View onCreateActionView(MenuItem menuItem) {
            return this.f1635a.onCreateActionView(menuItem);
        }

        @Override // androidx.core.view.ActionProvider
        public boolean overridesItemVisibility() {
            return this.f1635a.overridesItemVisibility();
        }

        @Override // androidx.core.view.ActionProvider
        public void refreshVisibility() {
            this.f1635a.refreshVisibility();
        }

        @Override // androidx.core.view.ActionProvider
        public void setVisibilityListener(ActionProvider.VisibilityListener visibilityListener) {
            this.d = visibilityListener;
            this.f1635a.setVisibilityListener(visibilityListener != null ? this : null);
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/appcompat/view/menu/MenuItemWrapperICS$CollapsibleActionViewWrapper.class */
    static class CollapsibleActionViewWrapper extends FrameLayout implements CollapsibleActionView {

        /* renamed from: a  reason: collision with root package name */
        final android.view.CollapsibleActionView f1637a;

        CollapsibleActionViewWrapper(View view) {
            super(view.getContext());
            this.f1637a = (android.view.CollapsibleActionView) view;
            addView(view);
        }

        View a() {
            return (View) this.f1637a;
        }

        @Override // androidx.appcompat.view.CollapsibleActionView
        public void onActionViewCollapsed() {
            this.f1637a.onActionViewCollapsed();
        }

        @Override // androidx.appcompat.view.CollapsibleActionView
        public void onActionViewExpanded() {
            this.f1637a.onActionViewExpanded();
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/appcompat/view/menu/MenuItemWrapperICS$OnActionExpandListenerWrapper.class */
    class OnActionExpandListenerWrapper implements MenuItem.OnActionExpandListener {
        private final MenuItem.OnActionExpandListener b;

        OnActionExpandListenerWrapper(MenuItem.OnActionExpandListener onActionExpandListener) {
            this.b = onActionExpandListener;
        }

        @Override // android.view.MenuItem.OnActionExpandListener
        public boolean onMenuItemActionCollapse(MenuItem menuItem) {
            return this.b.onMenuItemActionCollapse(MenuItemWrapperICS.this.a(menuItem));
        }

        @Override // android.view.MenuItem.OnActionExpandListener
        public boolean onMenuItemActionExpand(MenuItem menuItem) {
            return this.b.onMenuItemActionExpand(MenuItemWrapperICS.this.a(menuItem));
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/appcompat/view/menu/MenuItemWrapperICS$OnMenuItemClickListenerWrapper.class */
    class OnMenuItemClickListenerWrapper implements MenuItem.OnMenuItemClickListener {
        private final MenuItem.OnMenuItemClickListener b;

        OnMenuItemClickListenerWrapper(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
            this.b = onMenuItemClickListener;
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            Tracker.onMenuItemClick(menuItem);
            return this.b.onMenuItemClick(MenuItemWrapperICS.this.a(menuItem));
        }
    }

    public MenuItemWrapperICS(Context context, SupportMenuItem supportMenuItem) {
        super(context);
        if (supportMenuItem == null) {
            throw new IllegalArgumentException("Wrapped Object can not be null.");
        }
        this.b = supportMenuItem;
    }

    @Override // android.view.MenuItem
    public boolean collapseActionView() {
        return this.b.collapseActionView();
    }

    @Override // android.view.MenuItem
    public boolean expandActionView() {
        return this.b.expandActionView();
    }

    @Override // android.view.MenuItem
    public android.view.ActionProvider getActionProvider() {
        androidx.core.view.ActionProvider supportActionProvider = this.b.getSupportActionProvider();
        if (supportActionProvider instanceof ActionProviderWrapper) {
            return ((ActionProviderWrapper) supportActionProvider).f1635a;
        }
        return null;
    }

    @Override // android.view.MenuItem
    public View getActionView() {
        View actionView = this.b.getActionView();
        View view = actionView;
        if (actionView instanceof CollapsibleActionViewWrapper) {
            view = ((CollapsibleActionViewWrapper) actionView).a();
        }
        return view;
    }

    public int getAlphabeticModifiers() {
        return this.b.getAlphabeticModifiers();
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        return this.b.getAlphabeticShortcut();
    }

    public CharSequence getContentDescription() {
        return this.b.getContentDescription();
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        return this.b.getGroupId();
    }

    @Override // android.view.MenuItem
    public Drawable getIcon() {
        return this.b.getIcon();
    }

    public ColorStateList getIconTintList() {
        return this.b.getIconTintList();
    }

    public PorterDuff.Mode getIconTintMode() {
        return this.b.getIconTintMode();
    }

    @Override // android.view.MenuItem
    public Intent getIntent() {
        return this.b.getIntent();
    }

    @Override // android.view.MenuItem
    public int getItemId() {
        return this.b.getItemId();
    }

    @Override // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return this.b.getMenuInfo();
    }

    public int getNumericModifiers() {
        return this.b.getNumericModifiers();
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        return this.b.getNumericShortcut();
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        return this.b.getOrder();
    }

    @Override // android.view.MenuItem
    public SubMenu getSubMenu() {
        return a(this.b.getSubMenu());
    }

    @Override // android.view.MenuItem
    public CharSequence getTitle() {
        return this.b.getTitle();
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        return this.b.getTitleCondensed();
    }

    public CharSequence getTooltipText() {
        return this.b.getTooltipText();
    }

    @Override // android.view.MenuItem
    public boolean hasSubMenu() {
        return this.b.hasSubMenu();
    }

    @Override // android.view.MenuItem
    public boolean isActionViewExpanded() {
        return this.b.isActionViewExpanded();
    }

    @Override // android.view.MenuItem
    public boolean isCheckable() {
        return this.b.isCheckable();
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        return this.b.isChecked();
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        return this.b.isEnabled();
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        return this.b.isVisible();
    }

    @Override // android.view.MenuItem
    public MenuItem setActionProvider(android.view.ActionProvider actionProvider) {
        ActionProviderWrapperJB actionProviderWrapperJB = Build.VERSION.SDK_INT >= 16 ? new ActionProviderWrapperJB(this.f1611a, actionProvider) : new ActionProviderWrapper(this.f1611a, actionProvider);
        SupportMenuItem supportMenuItem = this.b;
        if (actionProvider == null) {
            actionProviderWrapperJB = null;
        }
        supportMenuItem.setSupportActionProvider(actionProviderWrapperJB);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionView(int i) {
        this.b.setActionView(i);
        View actionView = this.b.getActionView();
        if (actionView instanceof android.view.CollapsibleActionView) {
            this.b.setActionView(new CollapsibleActionViewWrapper(actionView));
        }
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionView(View view) {
        CollapsibleActionViewWrapper collapsibleActionViewWrapper = view;
        if (view instanceof android.view.CollapsibleActionView) {
            collapsibleActionViewWrapper = new CollapsibleActionViewWrapper(view);
        }
        this.b.setActionView(collapsibleActionViewWrapper);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c2) {
        this.b.setAlphabeticShortcut(c2);
        return this;
    }

    public MenuItem setAlphabeticShortcut(char c2, int i) {
        this.b.setAlphabeticShortcut(c2, i);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean z) {
        this.b.setCheckable(z);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean z) {
        this.b.setChecked(z);
        return this;
    }

    public MenuItem setContentDescription(CharSequence charSequence) {
        this.b.mo1090setContentDescription(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean z) {
        this.b.setEnabled(z);
        return this;
    }

    public void setExclusiveCheckable(boolean z) {
        try {
            if (this.f1634c == null) {
                this.f1634c = this.b.getClass().getDeclaredMethod("setExclusiveCheckable", Boolean.TYPE);
            }
            this.f1634c.invoke(this.b, Boolean.valueOf(z));
        } catch (Exception e) {
            Log.w("MenuItemWrapper", "Error while calling setExclusiveCheckable", e);
        }
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int i) {
        this.b.setIcon(i);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable drawable) {
        this.b.setIcon(drawable);
        return this;
    }

    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.b.setIconTintList(colorStateList);
        return this;
    }

    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.b.setIconTintMode(mode);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent intent) {
        this.b.setIntent(intent);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c2) {
        this.b.setNumericShortcut(c2);
        return this;
    }

    public MenuItem setNumericShortcut(char c2, int i) {
        this.b.setNumericShortcut(c2, i);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        this.b.setOnActionExpandListener(onActionExpandListener != null ? new OnActionExpandListenerWrapper(onActionExpandListener) : null);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.b.setOnMenuItemClickListener(onMenuItemClickListener != null ? new OnMenuItemClickListenerWrapper(onMenuItemClickListener) : null);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c2, char c3) {
        this.b.setShortcut(c2, c3);
        return this;
    }

    public MenuItem setShortcut(char c2, char c3, int i, int i2) {
        this.b.setShortcut(c2, c3, i, i2);
        return this;
    }

    @Override // android.view.MenuItem
    public void setShowAsAction(int i) {
        this.b.setShowAsAction(i);
    }

    @Override // android.view.MenuItem
    public MenuItem setShowAsActionFlags(int i) {
        this.b.setShowAsActionFlags(i);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int i) {
        this.b.setTitle(i);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence charSequence) {
        this.b.setTitle(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.b.setTitleCondensed(charSequence);
        return this;
    }

    public MenuItem setTooltipText(CharSequence charSequence) {
        this.b.mo1091setTooltipText(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean z) {
        return this.b.setVisible(z);
    }
}
