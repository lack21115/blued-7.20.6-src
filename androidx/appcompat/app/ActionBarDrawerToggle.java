package androidx.appcompat.app;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.app.ActionBarDrawerToggleHoneycomb;
import androidx.appcompat.graphics.drawable.DrawerArrowDrawable;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import com.bytedance.applog.tracker.Tracker;

/* loaded from: source-8756600-dex2jar.jar:androidx/appcompat/app/ActionBarDrawerToggle.class */
public class ActionBarDrawerToggle implements DrawerLayout.DrawerListener {

    /* renamed from: a  reason: collision with root package name */
    boolean f1483a;
    View.OnClickListener b;

    /* renamed from: c  reason: collision with root package name */
    private final Delegate f1484c;
    private final DrawerLayout d;
    private DrawerArrowDrawable e;
    private boolean f;
    private Drawable g;
    private boolean h;
    private final int i;
    private final int j;
    private boolean k;

    /* loaded from: source-8756600-dex2jar.jar:androidx/appcompat/app/ActionBarDrawerToggle$Delegate.class */
    public interface Delegate {
        Context getActionBarThemedContext();

        Drawable getThemeUpIndicator();

        boolean isNavigationVisible();

        void setActionBarDescription(int i);

        void setActionBarUpIndicator(Drawable drawable, int i);
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/appcompat/app/ActionBarDrawerToggle$DelegateProvider.class */
    public interface DelegateProvider {
        Delegate getDrawerToggleDelegate();
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/appcompat/app/ActionBarDrawerToggle$FrameworkActionBarDelegate.class */
    static class FrameworkActionBarDelegate implements Delegate {

        /* renamed from: a  reason: collision with root package name */
        private final Activity f1486a;
        private ActionBarDrawerToggleHoneycomb.SetIndicatorInfo b;

        FrameworkActionBarDelegate(Activity activity) {
            this.f1486a = activity;
        }

        @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
        public Context getActionBarThemedContext() {
            android.app.ActionBar actionBar = this.f1486a.getActionBar();
            return actionBar != null ? actionBar.getThemedContext() : this.f1486a;
        }

        @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
        public Drawable getThemeUpIndicator() {
            if (Build.VERSION.SDK_INT >= 18) {
                TypedArray obtainStyledAttributes = getActionBarThemedContext().obtainStyledAttributes(null, new int[]{R.attr.homeAsUpIndicator}, R.attr.actionBarStyle, 0);
                Drawable drawable = obtainStyledAttributes.getDrawable(0);
                obtainStyledAttributes.recycle();
                return drawable;
            }
            return ActionBarDrawerToggleHoneycomb.getThemeUpIndicator(this.f1486a);
        }

        @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
        public boolean isNavigationVisible() {
            android.app.ActionBar actionBar = this.f1486a.getActionBar();
            return (actionBar == null || (actionBar.getDisplayOptions() & 4) == 0) ? false : true;
        }

        @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
        public void setActionBarDescription(int i) {
            if (Build.VERSION.SDK_INT < 18) {
                this.b = ActionBarDrawerToggleHoneycomb.setActionBarDescription(this.b, this.f1486a, i);
                return;
            }
            android.app.ActionBar actionBar = this.f1486a.getActionBar();
            if (actionBar != null) {
                actionBar.setHomeActionContentDescription(i);
            }
        }

        @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
        public void setActionBarUpIndicator(Drawable drawable, int i) {
            android.app.ActionBar actionBar = this.f1486a.getActionBar();
            if (actionBar != null) {
                if (Build.VERSION.SDK_INT >= 18) {
                    actionBar.setHomeAsUpIndicator(drawable);
                    actionBar.setHomeActionContentDescription(i);
                    return;
                }
                actionBar.setDisplayShowHomeEnabled(true);
                this.b = ActionBarDrawerToggleHoneycomb.setActionBarUpIndicator(this.f1486a, drawable, i);
                actionBar.setDisplayShowHomeEnabled(false);
            }
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/appcompat/app/ActionBarDrawerToggle$ToolbarCompatDelegate.class */
    static class ToolbarCompatDelegate implements Delegate {

        /* renamed from: a  reason: collision with root package name */
        final Toolbar f1487a;
        final Drawable b;

        /* renamed from: c  reason: collision with root package name */
        final CharSequence f1488c;

        ToolbarCompatDelegate(Toolbar toolbar) {
            this.f1487a = toolbar;
            this.b = toolbar.getNavigationIcon();
            this.f1488c = toolbar.getNavigationContentDescription();
        }

        @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
        public Context getActionBarThemedContext() {
            return this.f1487a.getContext();
        }

        @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
        public Drawable getThemeUpIndicator() {
            return this.b;
        }

        @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
        public boolean isNavigationVisible() {
            return true;
        }

        @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
        public void setActionBarDescription(int i) {
            if (i == 0) {
                this.f1487a.setNavigationContentDescription(this.f1488c);
            } else {
                this.f1487a.setNavigationContentDescription(i);
            }
        }

        @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
        public void setActionBarUpIndicator(Drawable drawable, int i) {
            this.f1487a.setNavigationIcon(drawable);
            setActionBarDescription(i);
        }
    }

    ActionBarDrawerToggle(Activity activity, Toolbar toolbar, DrawerLayout drawerLayout, DrawerArrowDrawable drawerArrowDrawable, int i, int i2) {
        this.f = true;
        this.f1483a = true;
        this.k = false;
        if (toolbar != null) {
            this.f1484c = new ToolbarCompatDelegate(toolbar);
            toolbar.setNavigationOnClickListener(new View.OnClickListener() { // from class: androidx.appcompat.app.ActionBarDrawerToggle.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    if (ActionBarDrawerToggle.this.f1483a) {
                        ActionBarDrawerToggle.this.a();
                    } else if (ActionBarDrawerToggle.this.b != null) {
                        ActionBarDrawerToggle.this.b.onClick(view);
                    }
                }
            });
        } else if (activity instanceof DelegateProvider) {
            this.f1484c = ((DelegateProvider) activity).getDrawerToggleDelegate();
        } else {
            this.f1484c = new FrameworkActionBarDelegate(activity);
        }
        this.d = drawerLayout;
        this.i = i;
        this.j = i2;
        if (drawerArrowDrawable == null) {
            this.e = new DrawerArrowDrawable(this.f1484c.getActionBarThemedContext());
        } else {
            this.e = drawerArrowDrawable;
        }
        this.g = b();
    }

    public ActionBarDrawerToggle(Activity activity, DrawerLayout drawerLayout, int i, int i2) {
        this(activity, null, drawerLayout, null, i, i2);
    }

    public ActionBarDrawerToggle(Activity activity, DrawerLayout drawerLayout, Toolbar toolbar, int i, int i2) {
        this(activity, toolbar, drawerLayout, null, i, i2);
    }

    private void a(float f) {
        if (f == 1.0f) {
            this.e.setVerticalMirror(true);
        } else if (f == 0.0f) {
            this.e.setVerticalMirror(false);
        }
        this.e.setProgress(f);
    }

    void a() {
        int drawerLockMode = this.d.getDrawerLockMode(8388611);
        if (this.d.isDrawerVisible(8388611) && drawerLockMode != 2) {
            this.d.closeDrawer(8388611);
        } else if (drawerLockMode != 1) {
            this.d.openDrawer(8388611);
        }
    }

    void a(int i) {
        this.f1484c.setActionBarDescription(i);
    }

    void a(Drawable drawable, int i) {
        if (!this.k && !this.f1484c.isNavigationVisible()) {
            Log.w("ActionBarDrawerToggle", "DrawerToggle may not show up because NavigationIcon is not visible. You may need to call actionbar.setDisplayHomeAsUpEnabled(true);");
            this.k = true;
        }
        this.f1484c.setActionBarUpIndicator(drawable, i);
    }

    Drawable b() {
        return this.f1484c.getThemeUpIndicator();
    }

    public DrawerArrowDrawable getDrawerArrowDrawable() {
        return this.e;
    }

    public View.OnClickListener getToolbarNavigationClickListener() {
        return this.b;
    }

    public boolean isDrawerIndicatorEnabled() {
        return this.f1483a;
    }

    public boolean isDrawerSlideAnimationEnabled() {
        return this.f;
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (!this.h) {
            this.g = b();
        }
        syncState();
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
    public void onDrawerClosed(View view) {
        a(0.0f);
        if (this.f1483a) {
            a(this.i);
        }
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
    public void onDrawerOpened(View view) {
        a(1.0f);
        if (this.f1483a) {
            a(this.j);
        }
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
    public void onDrawerSlide(View view, float f) {
        if (this.f) {
            a(Math.min(1.0f, Math.max(0.0f, f)));
        } else {
            a(0.0f);
        }
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
    public void onDrawerStateChanged(int i) {
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem != null && menuItem.getItemId() == 16908332 && this.f1483a) {
            a();
            return true;
        }
        return false;
    }

    public void setDrawerArrowDrawable(DrawerArrowDrawable drawerArrowDrawable) {
        this.e = drawerArrowDrawable;
        syncState();
    }

    public void setDrawerIndicatorEnabled(boolean z) {
        if (z != this.f1483a) {
            if (z) {
                a(this.e, this.d.isDrawerOpen(8388611) ? this.j : this.i);
            } else {
                a(this.g, 0);
            }
            this.f1483a = z;
        }
    }

    public void setDrawerSlideAnimationEnabled(boolean z) {
        this.f = z;
        if (z) {
            return;
        }
        a(0.0f);
    }

    public void setHomeAsUpIndicator(int i) {
        setHomeAsUpIndicator(i != 0 ? this.d.getResources().getDrawable(i) : null);
    }

    public void setHomeAsUpIndicator(Drawable drawable) {
        if (drawable == null) {
            this.g = b();
            this.h = false;
        } else {
            this.g = drawable;
            this.h = true;
        }
        if (this.f1483a) {
            return;
        }
        a(this.g, 0);
    }

    public void setToolbarNavigationClickListener(View.OnClickListener onClickListener) {
        this.b = onClickListener;
    }

    public void syncState() {
        if (this.d.isDrawerOpen(8388611)) {
            a(1.0f);
        } else {
            a(0.0f);
        }
        if (this.f1483a) {
            a(this.e, this.d.isDrawerOpen(8388611) ? this.j : this.i);
        }
    }
}
