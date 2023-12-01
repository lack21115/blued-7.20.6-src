package androidx.legacy.app;

import android.R;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.os.Build;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import java.lang.reflect.Method;

@Deprecated
/* loaded from: source-8756600-dex2jar.jar:androidx/legacy/app/ActionBarDrawerToggle.class */
public class ActionBarDrawerToggle implements DrawerLayout.DrawerListener {
    private static final int[] b = {R.attr.homeAsUpIndicator};

    /* renamed from: a  reason: collision with root package name */
    final Activity f3019a;

    /* renamed from: c  reason: collision with root package name */
    private final Delegate f3020c;
    private final DrawerLayout d;
    private boolean e;
    private boolean f;
    private Drawable g;
    private Drawable h;
    private SlideDrawable i;
    private final int j;
    private final int k;
    private final int l;
    private SetIndicatorInfo m;

    @Deprecated
    /* loaded from: source-8756600-dex2jar.jar:androidx/legacy/app/ActionBarDrawerToggle$Delegate.class */
    public interface Delegate {
        Drawable getThemeUpIndicator();

        void setActionBarDescription(int i);

        void setActionBarUpIndicator(Drawable drawable, int i);
    }

    @Deprecated
    /* loaded from: source-8756600-dex2jar.jar:androidx/legacy/app/ActionBarDrawerToggle$DelegateProvider.class */
    public interface DelegateProvider {
        Delegate getDrawerToggleDelegate();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/legacy/app/ActionBarDrawerToggle$SetIndicatorInfo.class */
    public static class SetIndicatorInfo {

        /* renamed from: a  reason: collision with root package name */
        Method f3021a;
        Method b;

        /* renamed from: c  reason: collision with root package name */
        ImageView f3022c;

        SetIndicatorInfo(Activity activity) {
            try {
                this.f3021a = ActionBar.class.getDeclaredMethod("setHomeAsUpIndicator", Drawable.class);
                this.b = ActionBar.class.getDeclaredMethod("setHomeActionContentDescription", Integer.TYPE);
            } catch (NoSuchMethodException e) {
                View findViewById = activity.findViewById(R.id.home);
                if (findViewById == null) {
                    return;
                }
                ViewGroup viewGroup = (ViewGroup) findViewById.getParent();
                if (viewGroup.getChildCount() != 2) {
                    return;
                }
                View childAt = viewGroup.getChildAt(0);
                View childAt2 = childAt.getId() == 16908332 ? viewGroup.getChildAt(1) : childAt;
                if (childAt2 instanceof ImageView) {
                    this.f3022c = (ImageView) childAt2;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/legacy/app/ActionBarDrawerToggle$SlideDrawable.class */
    public class SlideDrawable extends InsetDrawable implements Drawable.Callback {
        private final boolean b;

        /* renamed from: c  reason: collision with root package name */
        private final Rect f3024c;
        private float d;
        private float e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        SlideDrawable(Drawable drawable) {
            super(drawable, 0);
            boolean z = false;
            this.b = Build.VERSION.SDK_INT > 18 ? true : z;
            this.f3024c = new Rect();
        }

        @Override // android.graphics.drawable.InsetDrawable, android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            copyBounds(this.f3024c);
            canvas.save();
            int i = 1;
            boolean z = ViewCompat.getLayoutDirection(ActionBarDrawerToggle.this.f3019a.getWindow().getDecorView()) == 1;
            if (z) {
                i = -1;
            }
            float width = this.f3024c.width();
            canvas.translate((-this.e) * width * this.d * i, 0.0f);
            if (z && !this.b) {
                canvas.translate(width, 0.0f);
                canvas.scale(-1.0f, 1.0f);
            }
            super.draw(canvas);
            canvas.restore();
        }

        public float getPosition() {
            return this.d;
        }

        public void setOffset(float f) {
            this.e = f;
            invalidateSelf();
        }

        public void setPosition(float f) {
            this.d = f;
            invalidateSelf();
        }
    }

    public ActionBarDrawerToggle(Activity activity, DrawerLayout drawerLayout, int i, int i2, int i3) {
        this(activity, drawerLayout, !a(activity), i, i2, i3);
    }

    public ActionBarDrawerToggle(Activity activity, DrawerLayout drawerLayout, boolean z, int i, int i2, int i3) {
        this.e = true;
        this.f3019a = activity;
        if (activity instanceof DelegateProvider) {
            this.f3020c = ((DelegateProvider) activity).getDrawerToggleDelegate();
        } else {
            this.f3020c = null;
        }
        this.d = drawerLayout;
        this.j = i;
        this.k = i2;
        this.l = i3;
        this.g = a();
        this.h = ContextCompat.getDrawable(activity, i);
        SlideDrawable slideDrawable = new SlideDrawable(this.h);
        this.i = slideDrawable;
        slideDrawable.setOffset(z ? 0.33333334f : 0.0f);
    }

    private Drawable a() {
        Delegate delegate = this.f3020c;
        if (delegate != null) {
            return delegate.getThemeUpIndicator();
        }
        if (Build.VERSION.SDK_INT < 18) {
            TypedArray obtainStyledAttributes = this.f3019a.obtainStyledAttributes(b);
            Drawable drawable = obtainStyledAttributes.getDrawable(0);
            obtainStyledAttributes.recycle();
            return drawable;
        }
        ActionBar actionBar = this.f3019a.getActionBar();
        TypedArray obtainStyledAttributes2 = (actionBar != null ? actionBar.getThemedContext() : this.f3019a).obtainStyledAttributes(null, b, R.attr.actionBarStyle, 0);
        Drawable drawable2 = obtainStyledAttributes2.getDrawable(0);
        obtainStyledAttributes2.recycle();
        return drawable2;
    }

    private void a(int i) {
        Delegate delegate = this.f3020c;
        if (delegate != null) {
            delegate.setActionBarDescription(i);
        } else if (Build.VERSION.SDK_INT >= 18) {
            ActionBar actionBar = this.f3019a.getActionBar();
            if (actionBar != null) {
                actionBar.setHomeActionContentDescription(i);
            }
        } else {
            if (this.m == null) {
                this.m = new SetIndicatorInfo(this.f3019a);
            }
            if (this.m.f3021a != null) {
                try {
                    ActionBar actionBar2 = this.f3019a.getActionBar();
                    this.m.b.invoke(actionBar2, Integer.valueOf(i));
                    actionBar2.setSubtitle(actionBar2.getSubtitle());
                } catch (Exception e) {
                    Log.w("ActionBarDrawerToggle", "Couldn't set content description via JB-MR2 API", e);
                }
            }
        }
    }

    private void a(Drawable drawable, int i) {
        Delegate delegate = this.f3020c;
        if (delegate != null) {
            delegate.setActionBarUpIndicator(drawable, i);
        } else if (Build.VERSION.SDK_INT >= 18) {
            ActionBar actionBar = this.f3019a.getActionBar();
            if (actionBar != null) {
                actionBar.setHomeAsUpIndicator(drawable);
                actionBar.setHomeActionContentDescription(i);
            }
        } else {
            if (this.m == null) {
                this.m = new SetIndicatorInfo(this.f3019a);
            }
            if (this.m.f3021a == null) {
                if (this.m.f3022c != null) {
                    this.m.f3022c.setImageDrawable(drawable);
                    return;
                } else {
                    Log.w("ActionBarDrawerToggle", "Couldn't set home-as-up indicator");
                    return;
                }
            }
            try {
                ActionBar actionBar2 = this.f3019a.getActionBar();
                this.m.f3021a.invoke(actionBar2, drawable);
                this.m.b.invoke(actionBar2, Integer.valueOf(i));
            } catch (Exception e) {
                Log.w("ActionBarDrawerToggle", "Couldn't set home-as-up indicator via JB-MR2 API", e);
            }
        }
    }

    private static boolean a(Context context) {
        return context.getApplicationInfo().targetSdkVersion >= 21 && Build.VERSION.SDK_INT >= 21;
    }

    public boolean isDrawerIndicatorEnabled() {
        return this.e;
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (!this.f) {
            this.g = a();
        }
        this.h = ContextCompat.getDrawable(this.f3019a, this.j);
        syncState();
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
    public void onDrawerClosed(View view) {
        this.i.setPosition(0.0f);
        if (this.e) {
            a(this.k);
        }
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
    public void onDrawerOpened(View view) {
        this.i.setPosition(1.0f);
        if (this.e) {
            a(this.l);
        }
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
    public void onDrawerSlide(View view, float f) {
        float position = this.i.getPosition();
        this.i.setPosition(f > 0.5f ? Math.max(position, Math.max(0.0f, f - 0.5f) * 2.0f) : Math.min(position, f * 2.0f));
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
    public void onDrawerStateChanged(int i) {
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem != null && menuItem.getItemId() == 16908332 && this.e) {
            if (this.d.isDrawerVisible(8388611)) {
                this.d.closeDrawer(8388611);
                return true;
            }
            this.d.openDrawer(8388611);
            return true;
        }
        return false;
    }

    public void setDrawerIndicatorEnabled(boolean z) {
        if (z != this.e) {
            if (z) {
                a(this.i, this.d.isDrawerOpen(8388611) ? this.l : this.k);
            } else {
                a(this.g, 0);
            }
            this.e = z;
        }
    }

    public void setHomeAsUpIndicator(int i) {
        setHomeAsUpIndicator(i != 0 ? ContextCompat.getDrawable(this.f3019a, i) : null);
    }

    public void setHomeAsUpIndicator(Drawable drawable) {
        if (drawable == null) {
            this.g = a();
            this.f = false;
        } else {
            this.g = drawable;
            this.f = true;
        }
        if (this.e) {
            return;
        }
        a(this.g, 0);
    }

    public void syncState() {
        if (this.d.isDrawerOpen(8388611)) {
            this.i.setPosition(1.0f);
        } else {
            this.i.setPosition(0.0f);
        }
        if (this.e) {
            a(this.i, this.d.isDrawerOpen(8388611) ? this.l : this.k);
        }
    }
}
