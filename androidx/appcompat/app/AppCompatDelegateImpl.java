package androidx.appcompat.app;

import android.app.Activity;
import android.app.Dialog;
import android.app.UiModeManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.os.LocaleList;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.KeyboardShortcutGroup;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.view.SupportActionModeWrapper;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.WindowCallbackWrapper;
import androidx.appcompat.view.menu.ListMenuPresenter;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.AppCompatDrawableManager;
import androidx.appcompat.widget.ContentFrameLayout;
import androidx.appcompat.widget.DecorContentParent;
import androidx.appcompat.widget.FitWindowsViewGroup;
import androidx.appcompat.widget.TintTypedArray;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.VectorEnabledTintResources;
import androidx.appcompat.widget.ViewUtils;
import androidx.collection.SimpleArrayMap;
import androidx.core.app.NavUtils;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.util.ObjectsCompat;
import androidx.core.view.KeyEventDispatcher;
import androidx.core.view.LayoutInflaterCompat;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorListenerAdapter;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import java.lang.Thread;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8756600-dex2jar.jar:androidx/appcompat/app/AppCompatDelegateImpl.class */
public class AppCompatDelegateImpl extends AppCompatDelegate implements LayoutInflater.Factory2, MenuBuilder.Callback {
    private static final SimpleArrayMap<String, Integer> u = new SimpleArrayMap<>();
    private static final boolean v;
    private static final int[] w;
    private static final boolean x;
    private static final boolean y;
    private static boolean z;
    private AppCompatWindowCallback A;
    private CharSequence B;
    private DecorContentParent C;
    private ActionMenuPresenterCallback D;
    private PanelMenuPresenterCallback E;
    private boolean F;
    private boolean G;
    private TextView H;
    private View I;
    private boolean J;
    private boolean K;
    private boolean L;
    private PanelFeatureState[] M;
    private PanelFeatureState N;
    private boolean O;
    private boolean P;
    private boolean Q;
    private Configuration R;
    private int S;
    private int T;
    private boolean U;
    private boolean V;
    private AutoNightModeManager W;
    private AutoNightModeManager X;
    private final Runnable Y;
    private boolean Z;

    /* renamed from: a  reason: collision with root package name */
    final Object f1562a;
    private Rect aa;
    private Rect ab;
    private AppCompatViewInflater ac;
    private LayoutIncludeDetector ad;
    final Context b;

    /* renamed from: c  reason: collision with root package name */
    Window f1563c;
    final AppCompatCallback d;
    ActionBar e;
    MenuInflater f;
    ActionMode g;
    ActionBarContextView h;
    PopupWindow i;
    Runnable j;
    ViewPropertyAnimatorCompat k;
    ViewGroup l;
    boolean m;
    boolean n;
    boolean o;
    boolean p;
    boolean q;
    boolean r;
    boolean s;
    int t;

    /* loaded from: source-8756600-dex2jar.jar:androidx/appcompat/app/AppCompatDelegateImpl$ActionBarDrawableToggleImpl.class */
    class ActionBarDrawableToggleImpl implements ActionBarDrawerToggle.Delegate {
        ActionBarDrawableToggleImpl() {
        }

        @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
        public Context getActionBarThemedContext() {
            return AppCompatDelegateImpl.this.c();
        }

        @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
        public Drawable getThemeUpIndicator() {
            TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(getActionBarThemedContext(), (AttributeSet) null, new int[]{R.attr.homeAsUpIndicator});
            Drawable drawable = obtainStyledAttributes.getDrawable(0);
            obtainStyledAttributes.recycle();
            return drawable;
        }

        @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
        public boolean isNavigationVisible() {
            ActionBar supportActionBar = AppCompatDelegateImpl.this.getSupportActionBar();
            return (supportActionBar == null || (supportActionBar.getDisplayOptions() & 4) == 0) ? false : true;
        }

        @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
        public void setActionBarDescription(int i) {
            ActionBar supportActionBar = AppCompatDelegateImpl.this.getSupportActionBar();
            if (supportActionBar != null) {
                supportActionBar.setHomeActionContentDescription(i);
            }
        }

        @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
        public void setActionBarUpIndicator(Drawable drawable, int i) {
            ActionBar supportActionBar = AppCompatDelegateImpl.this.getSupportActionBar();
            if (supportActionBar != null) {
                supportActionBar.setHomeAsUpIndicator(drawable);
                supportActionBar.setHomeActionContentDescription(i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/appcompat/app/AppCompatDelegateImpl$ActionBarMenuCallback.class */
    public interface ActionBarMenuCallback {
        View onCreatePanelView(int i);

        boolean onPreparePanel(int i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/appcompat/app/AppCompatDelegateImpl$ActionMenuPresenterCallback.class */
    public final class ActionMenuPresenterCallback implements MenuPresenter.Callback {
        ActionMenuPresenterCallback() {
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
        public void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
            AppCompatDelegateImpl.this.a(menuBuilder);
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
        public boolean onOpenSubMenu(MenuBuilder menuBuilder) {
            Window.Callback b = AppCompatDelegateImpl.this.b();
            if (b != null) {
                b.onMenuOpened(108, menuBuilder);
                return true;
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/appcompat/app/AppCompatDelegateImpl$ActionModeCallbackWrapperV9.class */
    public class ActionModeCallbackWrapperV9 implements ActionMode.Callback {
        private ActionMode.Callback b;

        public ActionModeCallbackWrapperV9(ActionMode.Callback callback) {
            this.b = callback;
        }

        @Override // androidx.appcompat.view.ActionMode.Callback
        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            return this.b.onActionItemClicked(actionMode, menuItem);
        }

        @Override // androidx.appcompat.view.ActionMode.Callback
        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            return this.b.onCreateActionMode(actionMode, menu);
        }

        @Override // androidx.appcompat.view.ActionMode.Callback
        public void onDestroyActionMode(ActionMode actionMode) {
            this.b.onDestroyActionMode(actionMode);
            if (AppCompatDelegateImpl.this.i != null) {
                AppCompatDelegateImpl.this.f1563c.getDecorView().removeCallbacks(AppCompatDelegateImpl.this.j);
            }
            if (AppCompatDelegateImpl.this.h != null) {
                AppCompatDelegateImpl.this.f();
                AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
                appCompatDelegateImpl.k = ViewCompat.animate(appCompatDelegateImpl.h).alpha(0.0f);
                AppCompatDelegateImpl.this.k.setListener(new ViewPropertyAnimatorListenerAdapter() { // from class: androidx.appcompat.app.AppCompatDelegateImpl.ActionModeCallbackWrapperV9.1
                    @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
                    public void onAnimationEnd(View view) {
                        AppCompatDelegateImpl.this.h.setVisibility(8);
                        if (AppCompatDelegateImpl.this.i != null) {
                            AppCompatDelegateImpl.this.i.dismiss();
                        } else if (AppCompatDelegateImpl.this.h.getParent() instanceof View) {
                            ViewCompat.requestApplyInsets((View) AppCompatDelegateImpl.this.h.getParent());
                        }
                        AppCompatDelegateImpl.this.h.killMode();
                        AppCompatDelegateImpl.this.k.setListener(null);
                        AppCompatDelegateImpl.this.k = null;
                        ViewCompat.requestApplyInsets(AppCompatDelegateImpl.this.l);
                    }
                });
            }
            if (AppCompatDelegateImpl.this.d != null) {
                AppCompatDelegateImpl.this.d.onSupportActionModeFinished(AppCompatDelegateImpl.this.g);
            }
            AppCompatDelegateImpl.this.g = null;
            ViewCompat.requestApplyInsets(AppCompatDelegateImpl.this.l);
        }

        @Override // androidx.appcompat.view.ActionMode.Callback
        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            ViewCompat.requestApplyInsets(AppCompatDelegateImpl.this.l);
            return this.b.onPrepareActionMode(actionMode, menu);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/appcompat/app/AppCompatDelegateImpl$Api17Impl.class */
    public static class Api17Impl {
        private Api17Impl() {
        }

        static Context a(Context context, Configuration configuration) {
            return context.createConfigurationContext(configuration);
        }

        static void a(Configuration configuration, Configuration configuration2, Configuration configuration3) {
            if (configuration.densityDpi != configuration2.densityDpi) {
                configuration3.densityDpi = configuration2.densityDpi;
            }
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/appcompat/app/AppCompatDelegateImpl$Api21Impl.class */
    static class Api21Impl {
        private Api21Impl() {
        }

        static boolean a(PowerManager powerManager) {
            return powerManager.isPowerSaveMode();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/appcompat/app/AppCompatDelegateImpl$Api24Impl.class */
    public static class Api24Impl {
        private Api24Impl() {
        }

        static void a(Configuration configuration, Configuration configuration2, Configuration configuration3) {
            LocaleList locales = configuration.getLocales();
            LocaleList locales2 = configuration2.getLocales();
            if (locales.equals(locales2)) {
                return;
            }
            configuration3.setLocales(locales2);
            configuration3.locale = configuration2.locale;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/appcompat/app/AppCompatDelegateImpl$Api26Impl.class */
    public static class Api26Impl {
        private Api26Impl() {
        }

        static void a(Configuration configuration, Configuration configuration2, Configuration configuration3) {
            if ((configuration.colorMode & 3) != (configuration2.colorMode & 3)) {
                configuration3.colorMode |= configuration2.colorMode & 3;
            }
            if ((configuration.colorMode & 12) != (configuration2.colorMode & 12)) {
                configuration3.colorMode |= configuration2.colorMode & 12;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/appcompat/app/AppCompatDelegateImpl$AppCompatWindowCallback.class */
    public class AppCompatWindowCallback extends WindowCallbackWrapper {

        /* renamed from: c  reason: collision with root package name */
        private ActionBarMenuCallback f1577c;

        AppCompatWindowCallback(Window.Callback callback) {
            super(callback);
        }

        final android.view.ActionMode a(ActionMode.Callback callback) {
            SupportActionModeWrapper.CallbackWrapper callbackWrapper = new SupportActionModeWrapper.CallbackWrapper(AppCompatDelegateImpl.this.b, callback);
            androidx.appcompat.view.ActionMode startSupportActionMode = AppCompatDelegateImpl.this.startSupportActionMode(callbackWrapper);
            if (startSupportActionMode != null) {
                return callbackWrapper.getActionModeWrapper(startSupportActionMode);
            }
            return null;
        }

        void a(ActionBarMenuCallback actionBarMenuCallback) {
            this.f1577c = actionBarMenuCallback;
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return AppCompatDelegateImpl.this.a(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
            return super.dispatchKeyShortcutEvent(keyEvent) || AppCompatDelegateImpl.this.a(keyEvent.getKeyCode(), keyEvent);
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        public void onContentChanged() {
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        public boolean onCreatePanelMenu(int i, Menu menu) {
            if (i != 0 || (menu instanceof MenuBuilder)) {
                return super.onCreatePanelMenu(i, menu);
            }
            return false;
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        public View onCreatePanelView(int i) {
            View onCreatePanelView;
            ActionBarMenuCallback actionBarMenuCallback = this.f1577c;
            return (actionBarMenuCallback == null || (onCreatePanelView = actionBarMenuCallback.onCreatePanelView(i)) == null) ? super.onCreatePanelView(i) : onCreatePanelView;
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        public boolean onMenuOpened(int i, Menu menu) {
            super.onMenuOpened(i, menu);
            AppCompatDelegateImpl.this.b(i);
            return true;
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        public void onPanelClosed(int i, Menu menu) {
            super.onPanelClosed(i, menu);
            AppCompatDelegateImpl.this.a(i);
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        public boolean onPreparePanel(int i, View view, Menu menu) {
            MenuBuilder menuBuilder = menu instanceof MenuBuilder ? (MenuBuilder) menu : null;
            if (i == 0 && menuBuilder == null) {
                return false;
            }
            boolean z = true;
            if (menuBuilder != null) {
                menuBuilder.setOverrideVisibleItems(true);
            }
            ActionBarMenuCallback actionBarMenuCallback = this.f1577c;
            if (actionBarMenuCallback == null || !actionBarMenuCallback.onPreparePanel(i)) {
                z = false;
            }
            boolean z2 = z;
            if (!z) {
                z2 = super.onPreparePanel(i, view, menu);
            }
            if (menuBuilder != null) {
                menuBuilder.setOverrideVisibleItems(false);
            }
            return z2;
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper
        public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> list, Menu menu, int i) {
            PanelFeatureState a2 = AppCompatDelegateImpl.this.a(0, true);
            if (a2 == null || a2.j == null) {
                super.onProvideKeyboardShortcuts(list, menu, i);
            } else {
                super.onProvideKeyboardShortcuts(list, a2.j, i);
            }
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        public android.view.ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
            if (Build.VERSION.SDK_INT >= 23) {
                return null;
            }
            return AppCompatDelegateImpl.this.isHandleNativeActionModesEnabled() ? a(callback) : super.onWindowStartingActionMode(callback);
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper
        public android.view.ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i) {
            return (AppCompatDelegateImpl.this.isHandleNativeActionModesEnabled() && i == 0) ? a(callback) : super.onWindowStartingActionMode(callback, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/appcompat/app/AppCompatDelegateImpl$AutoBatteryNightModeManager.class */
    public class AutoBatteryNightModeManager extends AutoNightModeManager {

        /* renamed from: c  reason: collision with root package name */
        private final PowerManager f1579c;

        AutoBatteryNightModeManager(Context context) {
            super();
            this.f1579c = (PowerManager) context.getApplicationContext().getSystemService("power");
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.AutoNightModeManager
        IntentFilter a() {
            if (Build.VERSION.SDK_INT >= 21) {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction(PowerManager.ACTION_POWER_SAVE_MODE_CHANGED);
                return intentFilter;
            }
            return null;
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.AutoNightModeManager
        public int getApplyableNightMode() {
            int i = 1;
            if (Build.VERSION.SDK_INT >= 21) {
                i = 1;
                if (Api21Impl.a(this.f1579c)) {
                    i = 2;
                }
            }
            return i;
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.AutoNightModeManager
        public void onChange() {
            AppCompatDelegateImpl.this.applyDayNight();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/appcompat/app/AppCompatDelegateImpl$AutoNightModeManager.class */
    public abstract class AutoNightModeManager {

        /* renamed from: a  reason: collision with root package name */
        private BroadcastReceiver f1580a;

        AutoNightModeManager() {
        }

        abstract IntentFilter a();

        void b() {
            c();
            IntentFilter a2 = a();
            if (a2 == null || a2.countActions() == 0) {
                return;
            }
            if (this.f1580a == null) {
                this.f1580a = new BroadcastReceiver() { // from class: androidx.appcompat.app.AppCompatDelegateImpl.AutoNightModeManager.1
                    @Override // android.content.BroadcastReceiver
                    public void onReceive(Context context, Intent intent) {
                        AutoNightModeManager.this.onChange();
                    }
                };
            }
            AppCompatDelegateImpl.this.b.registerReceiver(this.f1580a, a2);
        }

        void c() {
            if (this.f1580a != null) {
                try {
                    AppCompatDelegateImpl.this.b.unregisterReceiver(this.f1580a);
                } catch (IllegalArgumentException e) {
                }
                this.f1580a = null;
            }
        }

        abstract int getApplyableNightMode();

        abstract void onChange();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/appcompat/app/AppCompatDelegateImpl$AutoTimeNightModeManager.class */
    public class AutoTimeNightModeManager extends AutoNightModeManager {

        /* renamed from: c  reason: collision with root package name */
        private final TwilightManager f1583c;

        AutoTimeNightModeManager(TwilightManager twilightManager) {
            super();
            this.f1583c = twilightManager;
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.AutoNightModeManager
        IntentFilter a() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.TIME_SET");
            intentFilter.addAction(Intent.ACTION_TIMEZONE_CHANGED);
            intentFilter.addAction(Intent.ACTION_TIME_TICK);
            return intentFilter;
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.AutoNightModeManager
        public int getApplyableNightMode() {
            return this.f1583c.a() ? 2 : 1;
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.AutoNightModeManager
        public void onChange() {
            AppCompatDelegateImpl.this.applyDayNight();
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/appcompat/app/AppCompatDelegateImpl$ContextThemeWrapperCompatApi17Impl.class */
    static class ContextThemeWrapperCompatApi17Impl {
        private ContextThemeWrapperCompatApi17Impl() {
        }

        static void a(ContextThemeWrapper contextThemeWrapper, Configuration configuration) {
            contextThemeWrapper.applyOverrideConfiguration(configuration);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/appcompat/app/AppCompatDelegateImpl$ListMenuDecorView.class */
    public class ListMenuDecorView extends ContentFrameLayout {
        public ListMenuDecorView(Context context) {
            super(context);
        }

        private boolean a(int i, int i2) {
            return i < -5 || i2 < -5 || i > getWidth() + 5 || i2 > getHeight() + 5;
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return AppCompatDelegateImpl.this.a(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        @Override // android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0 && a((int) motionEvent.getX(), (int) motionEvent.getY())) {
                AppCompatDelegateImpl.this.c(0);
                return true;
            }
            return super.onInterceptTouchEvent(motionEvent);
        }

        @Override // android.view.View
        public void setBackgroundResource(int i) {
            setBackgroundDrawable(AppCompatResources.getDrawable(getContext(), i));
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/appcompat/app/AppCompatDelegateImpl$PanelFeatureState.class */
    public static final class PanelFeatureState {

        /* renamed from: a  reason: collision with root package name */
        int f1585a;
        int b;

        /* renamed from: c  reason: collision with root package name */
        int f1586c;
        int d;
        int e;
        int f;
        ViewGroup g;
        View h;
        View i;
        MenuBuilder j;
        ListMenuPresenter k;
        Context l;
        boolean m;
        boolean n;
        boolean o;
        boolean p = false;
        boolean q;
        public boolean qwertyMode;
        Bundle r;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: source-8756600-dex2jar.jar:androidx/appcompat/app/AppCompatDelegateImpl$PanelFeatureState$SavedState.class */
        public static class SavedState implements Parcelable {
            public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: androidx.appcompat.app.AppCompatDelegateImpl.PanelFeatureState.SavedState.1
                @Override // android.os.Parcelable.Creator
                public SavedState createFromParcel(Parcel parcel) {
                    return SavedState.a(parcel, null);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.ClassLoaderCreator
                public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                    return SavedState.a(parcel, classLoader);
                }

                @Override // android.os.Parcelable.Creator
                public SavedState[] newArray(int i) {
                    return new SavedState[i];
                }
            };

            /* renamed from: a  reason: collision with root package name */
            int f1587a;
            boolean b;

            /* renamed from: c  reason: collision with root package name */
            Bundle f1588c;

            SavedState() {
            }

            static SavedState a(Parcel parcel, ClassLoader classLoader) {
                SavedState savedState = new SavedState();
                savedState.f1587a = parcel.readInt();
                boolean z = true;
                if (parcel.readInt() != 1) {
                    z = false;
                }
                savedState.b = z;
                if (z) {
                    savedState.f1588c = parcel.readBundle(classLoader);
                }
                return savedState;
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
            @Override // android.os.Parcelable
            public void writeToParcel(Parcel parcel, int i) {
                throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
            }
        }

        PanelFeatureState(int i) {
            this.f1585a = i;
        }

        MenuView a(MenuPresenter.Callback callback) {
            if (this.j == null) {
                return null;
            }
            if (this.k == null) {
                ListMenuPresenter listMenuPresenter = new ListMenuPresenter(this.l, R.layout.abc_list_menu_item_layout);
                this.k = listMenuPresenter;
                listMenuPresenter.setCallback(callback);
                this.j.addMenuPresenter(this.k);
            }
            return this.k.getMenuView(this.g);
        }

        void a(Context context) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme newTheme = context.getResources().newTheme();
            newTheme.setTo(context.getTheme());
            newTheme.resolveAttribute(R.attr.actionBarPopupTheme, typedValue, true);
            if (typedValue.resourceId != 0) {
                newTheme.applyStyle(typedValue.resourceId, true);
            }
            newTheme.resolveAttribute(R.attr.panelMenuListTheme, typedValue, true);
            if (typedValue.resourceId != 0) {
                newTheme.applyStyle(typedValue.resourceId, true);
            } else {
                newTheme.applyStyle(R.style.Theme_AppCompat_CompactMenu, true);
            }
            androidx.appcompat.view.ContextThemeWrapper contextThemeWrapper = new androidx.appcompat.view.ContextThemeWrapper(context, 0);
            contextThemeWrapper.getTheme().setTo(newTheme);
            this.l = contextThemeWrapper;
            TypedArray obtainStyledAttributes = contextThemeWrapper.obtainStyledAttributes(R.styleable.AppCompatTheme);
            this.b = obtainStyledAttributes.getResourceId(R.styleable.AppCompatTheme_panelBackground, 0);
            this.f = obtainStyledAttributes.getResourceId(R.styleable.AppCompatTheme_android_windowAnimationStyle, 0);
            obtainStyledAttributes.recycle();
        }

        void a(MenuBuilder menuBuilder) {
            ListMenuPresenter listMenuPresenter;
            MenuBuilder menuBuilder2 = this.j;
            if (menuBuilder == menuBuilder2) {
                return;
            }
            if (menuBuilder2 != null) {
                menuBuilder2.removeMenuPresenter(this.k);
            }
            this.j = menuBuilder;
            if (menuBuilder == null || (listMenuPresenter = this.k) == null) {
                return;
            }
            menuBuilder.addMenuPresenter(listMenuPresenter);
        }

        public void clearMenuPresenters() {
            MenuBuilder menuBuilder = this.j;
            if (menuBuilder != null) {
                menuBuilder.removeMenuPresenter(this.k);
            }
            this.k = null;
        }

        public boolean hasPanelItems() {
            boolean z = false;
            if (this.h == null) {
                return false;
            }
            if (this.i != null) {
                return true;
            }
            if (this.k.getAdapter().getCount() > 0) {
                z = true;
            }
            return z;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/appcompat/app/AppCompatDelegateImpl$PanelMenuPresenterCallback.class */
    public final class PanelMenuPresenterCallback implements MenuPresenter.Callback {
        PanelMenuPresenterCallback() {
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
        public void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
            MenuBuilder rootMenu = menuBuilder.getRootMenu();
            boolean z2 = rootMenu != menuBuilder;
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            if (z2) {
                menuBuilder = rootMenu;
            }
            PanelFeatureState a2 = appCompatDelegateImpl.a((Menu) menuBuilder);
            if (a2 != null) {
                if (!z2) {
                    AppCompatDelegateImpl.this.a(a2, z);
                    return;
                }
                AppCompatDelegateImpl.this.a(a2.f1585a, a2, rootMenu);
                AppCompatDelegateImpl.this.a(a2, true);
            }
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
        public boolean onOpenSubMenu(MenuBuilder menuBuilder) {
            Window.Callback b;
            if (menuBuilder != menuBuilder.getRootMenu() || !AppCompatDelegateImpl.this.m || (b = AppCompatDelegateImpl.this.b()) == null || AppCompatDelegateImpl.this.r) {
                return true;
            }
            b.onMenuOpened(108, menuBuilder);
            return true;
        }
    }

    static {
        v = Build.VERSION.SDK_INT < 21;
        w = new int[]{16842836};
        x = !"robolectric".equals(Build.FINGERPRINT);
        boolean z2 = false;
        if (Build.VERSION.SDK_INT >= 17) {
            z2 = true;
        }
        y = z2;
        if (!v || z) {
            return;
        }
        final Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() { // from class: androidx.appcompat.app.AppCompatDelegateImpl.1
            /* JADX WARN: Code restructure failed: missing block: B:9:0x002b, code lost:
                if (r0.contains("Drawable") != false) goto L9;
             */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            private boolean a(java.lang.Throwable r4) {
                /*
                    r3 = this;
                    r0 = r4
                    boolean r0 = r0 instanceof android.content.res.Resources.NotFoundException
                    r7 = r0
                    r0 = 0
                    r6 = r0
                    r0 = r6
                    r5 = r0
                    r0 = r7
                    if (r0 == 0) goto L30
                    r0 = r4
                    java.lang.String r0 = r0.getMessage()
                    r4 = r0
                    r0 = r6
                    r5 = r0
                    r0 = r4
                    if (r0 == 0) goto L30
                    r0 = r4
                    java.lang.String r1 = "drawable"
                    boolean r0 = r0.contains(r1)
                    if (r0 != 0) goto L2e
                    r0 = r6
                    r5 = r0
                    r0 = r4
                    java.lang.String r1 = "Drawable"
                    boolean r0 = r0.contains(r1)
                    if (r0 == 0) goto L30
                L2e:
                    r0 = 1
                    r5 = r0
                L30:
                    r0 = r5
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.AnonymousClass1.a(java.lang.Throwable):boolean");
            }

            @Override // java.lang.Thread.UncaughtExceptionHandler
            public void uncaughtException(Thread thread, Throwable th) {
                if (!a(th)) {
                    Thread.UncaughtExceptionHandler.this.uncaughtException(thread, th);
                    return;
                }
                Resources.NotFoundException notFoundException = new Resources.NotFoundException(th.getMessage() + ". If the resource you are trying to use is a vector resource, you may be referencing it in an unsupported way. See AppCompatDelegate.setCompatVectorFromResourcesEnabled() for more info.");
                notFoundException.initCause(th.getCause());
                notFoundException.setStackTrace(th.getStackTrace());
                Thread.UncaughtExceptionHandler.this.uncaughtException(thread, notFoundException);
            }
        });
        z = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AppCompatDelegateImpl(Activity activity, AppCompatCallback appCompatCallback) {
        this(activity, null, appCompatCallback, activity);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AppCompatDelegateImpl(Dialog dialog, AppCompatCallback appCompatCallback) {
        this(dialog.getContext(), dialog.getWindow(), appCompatCallback, dialog);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AppCompatDelegateImpl(Context context, Activity activity, AppCompatCallback appCompatCallback) {
        this(context, null, appCompatCallback, activity);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AppCompatDelegateImpl(Context context, Window window, AppCompatCallback appCompatCallback) {
        this(context, window, appCompatCallback, context);
    }

    private AppCompatDelegateImpl(Context context, Window window, AppCompatCallback appCompatCallback, Object obj) {
        Integer num;
        AppCompatActivity o;
        this.k = null;
        this.F = true;
        this.S = -100;
        this.Y = new Runnable() { // from class: androidx.appcompat.app.AppCompatDelegateImpl.2
            @Override // java.lang.Runnable
            public void run() {
                if ((AppCompatDelegateImpl.this.t & 1) != 0) {
                    AppCompatDelegateImpl.this.d(0);
                }
                if ((AppCompatDelegateImpl.this.t & 4096) != 0) {
                    AppCompatDelegateImpl.this.d(108);
                }
                AppCompatDelegateImpl.this.s = false;
                AppCompatDelegateImpl.this.t = 0;
            }
        };
        this.b = context;
        this.d = appCompatCallback;
        this.f1562a = obj;
        if (this.S == -100 && (obj instanceof Dialog) && (o = o()) != null) {
            this.S = o.getDelegate().getLocalNightMode();
        }
        if (this.S == -100 && (num = u.get(this.f1562a.getClass().getName())) != null) {
            this.S = num.intValue();
            u.remove(this.f1562a.getClass().getName());
        }
        if (window != null) {
            a(window);
        }
        AppCompatDrawableManager.preload();
    }

    private Configuration a(Context context, int i, Configuration configuration) {
        int i2 = i != 1 ? i != 2 ? context.getApplicationContext().getResources().getConfiguration().uiMode & 48 : 32 : 16;
        Configuration configuration2 = new Configuration();
        configuration2.fontScale = 0.0f;
        if (configuration != null) {
            configuration2.setTo(configuration);
        }
        configuration2.uiMode = i2 | (configuration2.uiMode & (-49));
        return configuration2;
    }

    private static Configuration a(Configuration configuration, Configuration configuration2) {
        Configuration configuration3 = new Configuration();
        configuration3.fontScale = 0.0f;
        if (configuration2 != null) {
            if (configuration.diff(configuration2) == 0) {
                return configuration3;
            }
            if (configuration.fontScale != configuration2.fontScale) {
                configuration3.fontScale = configuration2.fontScale;
            }
            if (configuration.mcc != configuration2.mcc) {
                configuration3.mcc = configuration2.mcc;
            }
            if (configuration.mnc != configuration2.mnc) {
                configuration3.mnc = configuration2.mnc;
            }
            if (Build.VERSION.SDK_INT >= 24) {
                Api24Impl.a(configuration, configuration2, configuration3);
            } else if (!ObjectsCompat.equals(configuration.locale, configuration2.locale)) {
                configuration3.locale = configuration2.locale;
            }
            if (configuration.touchscreen != configuration2.touchscreen) {
                configuration3.touchscreen = configuration2.touchscreen;
            }
            if (configuration.keyboard != configuration2.keyboard) {
                configuration3.keyboard = configuration2.keyboard;
            }
            if (configuration.keyboardHidden != configuration2.keyboardHidden) {
                configuration3.keyboardHidden = configuration2.keyboardHidden;
            }
            if (configuration.navigation != configuration2.navigation) {
                configuration3.navigation = configuration2.navigation;
            }
            if (configuration.navigationHidden != configuration2.navigationHidden) {
                configuration3.navigationHidden = configuration2.navigationHidden;
            }
            if (configuration.orientation != configuration2.orientation) {
                configuration3.orientation = configuration2.orientation;
            }
            if ((configuration.screenLayout & 15) != (configuration2.screenLayout & 15)) {
                configuration3.screenLayout |= configuration2.screenLayout & 15;
            }
            if ((configuration.screenLayout & 192) != (configuration2.screenLayout & 192)) {
                configuration3.screenLayout |= configuration2.screenLayout & 192;
            }
            if ((configuration.screenLayout & 48) != (configuration2.screenLayout & 48)) {
                configuration3.screenLayout |= configuration2.screenLayout & 48;
            }
            if ((configuration.screenLayout & 768) != (configuration2.screenLayout & 768)) {
                configuration3.screenLayout |= configuration2.screenLayout & 768;
            }
            if (Build.VERSION.SDK_INT >= 26) {
                Api26Impl.a(configuration, configuration2, configuration3);
            }
            if ((configuration.uiMode & 15) != (configuration2.uiMode & 15)) {
                configuration3.uiMode |= configuration2.uiMode & 15;
            }
            if ((configuration.uiMode & 48) != (configuration2.uiMode & 48)) {
                configuration3.uiMode |= configuration2.uiMode & 48;
            }
            if (configuration.screenWidthDp != configuration2.screenWidthDp) {
                configuration3.screenWidthDp = configuration2.screenWidthDp;
            }
            if (configuration.screenHeightDp != configuration2.screenHeightDp) {
                configuration3.screenHeightDp = configuration2.screenHeightDp;
            }
            if (configuration.smallestScreenWidthDp != configuration2.smallestScreenWidthDp) {
                configuration3.smallestScreenWidthDp = configuration2.smallestScreenWidthDp;
            }
            if (Build.VERSION.SDK_INT >= 17) {
                Api17Impl.a(configuration, configuration2, configuration3);
            }
        }
        return configuration3;
    }

    private AutoNightModeManager a(Context context) {
        if (this.W == null) {
            this.W = new AutoTimeNightModeManager(TwilightManager.a(context));
        }
        return this.W;
    }

    private void a(int i, boolean z2, Configuration configuration) {
        Resources resources = this.b.getResources();
        Configuration configuration2 = new Configuration(resources.getConfiguration());
        if (configuration != null) {
            configuration2.updateFrom(configuration);
        }
        configuration2.uiMode = i | (resources.getConfiguration().uiMode & (-49));
        resources.updateConfiguration(configuration2, null);
        if (Build.VERSION.SDK_INT < 26) {
            ResourcesFlusher.a(resources);
        }
        int i2 = this.T;
        if (i2 != 0) {
            this.b.setTheme(i2);
            if (Build.VERSION.SDK_INT >= 23) {
                this.b.getTheme().applyStyle(this.T, true);
            }
        }
        if (z2) {
            Object obj = this.f1562a;
            if (obj instanceof Activity) {
                Activity activity = (Activity) obj;
                if (activity instanceof LifecycleOwner) {
                    if (((LifecycleOwner) activity).getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.CREATED)) {
                        activity.onConfigurationChanged(configuration2);
                    }
                } else if (!this.Q || this.r) {
                } else {
                    activity.onConfigurationChanged(configuration2);
                }
            }
        }
    }

    private void a(View view) {
        view.setBackgroundColor((ViewCompat.getWindowSystemUiVisibility(view) & 8192) != 0 ? ContextCompat.getColor(this.b, R.color.abc_decor_view_status_guard_light) : ContextCompat.getColor(this.b, R.color.abc_decor_view_status_guard));
    }

    private void a(Window window) {
        if (this.f1563c != null) {
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        Window.Callback callback = window.getCallback();
        if (callback instanceof AppCompatWindowCallback) {
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        AppCompatWindowCallback appCompatWindowCallback = new AppCompatWindowCallback(callback);
        this.A = appCompatWindowCallback;
        window.setCallback(appCompatWindowCallback);
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(this.b, (AttributeSet) null, w);
        Drawable drawableIfKnown = obtainStyledAttributes.getDrawableIfKnown(0);
        if (drawableIfKnown != null) {
            window.setBackgroundDrawable(drawableIfKnown);
        }
        obtainStyledAttributes.recycle();
        this.f1563c = window;
    }

    private void a(PanelFeatureState panelFeatureState, KeyEvent keyEvent) {
        int i;
        ViewGroup.LayoutParams layoutParams;
        if (panelFeatureState.o || this.r) {
            return;
        }
        if (panelFeatureState.f1585a == 0) {
            if ((this.b.getResources().getConfiguration().screenLayout & 15) == 4) {
                return;
            }
        }
        Window.Callback b = b();
        if (b != null && !b.onMenuOpened(panelFeatureState.f1585a, panelFeatureState.j)) {
            a(panelFeatureState, true);
            return;
        }
        WindowManager windowManager = (WindowManager) this.b.getSystemService(Context.WINDOW_SERVICE);
        if (windowManager != null && b(panelFeatureState, keyEvent)) {
            if (panelFeatureState.g == null || panelFeatureState.p) {
                if (panelFeatureState.g == null) {
                    if (!a(panelFeatureState) || panelFeatureState.g == null) {
                        return;
                    }
                } else if (panelFeatureState.p && panelFeatureState.g.getChildCount() > 0) {
                    panelFeatureState.g.removeAllViews();
                }
                if (!c(panelFeatureState) || !panelFeatureState.hasPanelItems()) {
                    panelFeatureState.p = true;
                    return;
                }
                ViewGroup.LayoutParams layoutParams2 = panelFeatureState.h.getLayoutParams();
                ViewGroup.LayoutParams layoutParams3 = layoutParams2;
                if (layoutParams2 == null) {
                    layoutParams3 = new ViewGroup.LayoutParams(-2, -2);
                }
                panelFeatureState.g.setBackgroundResource(panelFeatureState.b);
                ViewParent parent = panelFeatureState.h.getParent();
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(panelFeatureState.h);
                }
                panelFeatureState.g.addView(panelFeatureState.h, layoutParams3);
                if (!panelFeatureState.h.hasFocus()) {
                    panelFeatureState.h.requestFocus();
                }
            } else if (panelFeatureState.i != null && (layoutParams = panelFeatureState.i.getLayoutParams()) != null && layoutParams.width == -1) {
                i = -1;
                panelFeatureState.n = false;
                WindowManager.LayoutParams layoutParams4 = new WindowManager.LayoutParams(i, -2, panelFeatureState.d, panelFeatureState.e, 1002, 8519680, -3);
                layoutParams4.gravity = panelFeatureState.f1586c;
                layoutParams4.windowAnimations = panelFeatureState.f;
                windowManager.addView(panelFeatureState.g, layoutParams4);
                panelFeatureState.o = true;
            }
            i = -2;
            panelFeatureState.n = false;
            WindowManager.LayoutParams layoutParams42 = new WindowManager.LayoutParams(i, -2, panelFeatureState.d, panelFeatureState.e, 1002, 8519680, -3);
            layoutParams42.gravity = panelFeatureState.f1586c;
            layoutParams42.windowAnimations = panelFeatureState.f;
            windowManager.addView(panelFeatureState.g, layoutParams42);
            panelFeatureState.o = true;
        }
    }

    private void a(boolean z2) {
        DecorContentParent decorContentParent = this.C;
        if (decorContentParent == null || !decorContentParent.canShowOverflowMenu() || (ViewConfiguration.get(this.b).hasPermanentMenuKey() && !this.C.isOverflowMenuShowPending())) {
            PanelFeatureState a2 = a(0, true);
            a2.p = true;
            a(a2, false);
            a(a2, (KeyEvent) null);
            return;
        }
        Window.Callback b = b();
        if (this.C.isOverflowMenuShowing() && z2) {
            this.C.hideOverflowMenu();
            if (this.r) {
                return;
            }
            b.onPanelClosed(108, a(0, true).j);
        } else if (b == null || this.r) {
        } else {
            if (this.s && (this.t & 1) != 0) {
                this.f1563c.getDecorView().removeCallbacks(this.Y);
                this.Y.run();
            }
            PanelFeatureState a3 = a(0, true);
            if (a3.j == null || a3.q || !b.onPreparePanel(0, a3.i, a3.j)) {
                return;
            }
            b.onMenuOpened(108, a3.j);
            this.C.showOverflowMenu();
        }
    }

    private boolean a(ViewParent viewParent) {
        if (viewParent == null) {
            return false;
        }
        View decorView = this.f1563c.getDecorView();
        while (viewParent != null) {
            if (viewParent == decorView || !(viewParent instanceof View) || ViewCompat.isAttachedToWindow((View) viewParent)) {
                return false;
            }
            viewParent = viewParent.getParent();
        }
        return true;
    }

    private boolean a(PanelFeatureState panelFeatureState) {
        panelFeatureState.a(c());
        panelFeatureState.g = new ListMenuDecorView(panelFeatureState.l);
        panelFeatureState.f1586c = 81;
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0021, code lost:
        if (b(r6, r8) != false) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean a(androidx.appcompat.app.AppCompatDelegateImpl.PanelFeatureState r6, int r7, android.view.KeyEvent r8, int r9) {
        /*
            r5 = this;
            r0 = r8
            boolean r0 = r0.isSystem()
            r10 = r0
            r0 = 0
            r11 = r0
            r0 = r10
            if (r0 == 0) goto L10
            r0 = 0
            return r0
        L10:
            r0 = r6
            boolean r0 = r0.m
            if (r0 != 0) goto L24
            r0 = r11
            r10 = r0
            r0 = r5
            r1 = r6
            r2 = r8
            boolean r0 = r0.b(r1, r2)
            if (r0 == 0) goto L3c
        L24:
            r0 = r11
            r10 = r0
            r0 = r6
            androidx.appcompat.view.menu.MenuBuilder r0 = r0.j
            if (r0 == 0) goto L3c
            r0 = r6
            androidx.appcompat.view.menu.MenuBuilder r0 = r0.j
            r1 = r7
            r2 = r8
            r3 = r9
            boolean r0 = r0.performShortcut(r1, r2, r3)
            r10 = r0
        L3c:
            r0 = r10
            if (r0 == 0) goto L55
            r0 = r9
            r1 = 1
            r0 = r0 & r1
            if (r0 != 0) goto L55
            r0 = r5
            androidx.appcompat.widget.DecorContentParent r0 = r0.C
            if (r0 != 0) goto L55
            r0 = r5
            r1 = r6
            r2 = 1
            r0.a(r1, r2)
        L55:
            r0 = r10
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.a(androidx.appcompat.app.AppCompatDelegateImpl$PanelFeatureState, int, android.view.KeyEvent, int):boolean");
    }

    private AutoNightModeManager b(Context context) {
        if (this.X == null) {
            this.X = new AutoBatteryNightModeManager(context);
        }
        return this.X;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00ad  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean b(int r6, boolean r7) {
        /*
            r5 = this;
            r0 = r5
            r1 = r5
            android.content.Context r1 = r1.b
            r2 = r6
            r3 = 0
            android.content.res.Configuration r0 = r0.a(r1, r2, r3)
            r14 = r0
            r0 = r5
            boolean r0 = r0.r()
            r11 = r0
            r0 = r5
            android.content.res.Configuration r0 = r0.R
            r13 = r0
            r0 = r13
            r12 = r0
            r0 = r13
            if (r0 != 0) goto L2d
            r0 = r5
            android.content.Context r0 = r0.b
            android.content.res.Resources r0 = r0.getResources()
            android.content.res.Configuration r0 = r0.getConfiguration()
            r12 = r0
        L2d:
            r0 = r12
            int r0 = r0.uiMode
            r1 = 48
            r0 = r0 & r1
            r8 = r0
            r0 = r14
            int r0 = r0.uiMode
            r1 = 48
            r0 = r0 & r1
            r9 = r0
            r0 = 1
            r10 = r0
            r0 = r8
            r1 = r9
            if (r0 == r1) goto L8e
            r0 = r7
            if (r0 == 0) goto L8e
            r0 = r11
            if (r0 != 0) goto L8e
            r0 = r5
            boolean r0 = r0.P
            if (r0 == 0) goto L8e
            boolean r0 = androidx.appcompat.app.AppCompatDelegateImpl.x
            if (r0 != 0) goto L66
            r0 = r5
            boolean r0 = r0.Q
            if (r0 == 0) goto L8e
        L66:
            r0 = r5
            java.lang.Object r0 = r0.f1562a
            r12 = r0
            r0 = r12
            boolean r0 = r0 instanceof android.app.Activity
            if (r0 == 0) goto L8e
            r0 = r12
            android.app.Activity r0 = (android.app.Activity) r0
            boolean r0 = r0.isChild()
            if (r0 != 0) goto L8e
            r0 = r5
            java.lang.Object r0 = r0.f1562a
            android.app.Activity r0 = (android.app.Activity) r0
            androidx.core.app.ActivityCompat.recreate(r0)
            r0 = 1
            r7 = r0
            goto L90
        L8e:
            r0 = 0
            r7 = r0
        L90:
            r0 = r7
            if (r0 != 0) goto La9
            r0 = r8
            r1 = r9
            if (r0 == r1) goto La9
            r0 = r5
            r1 = r9
            r2 = r11
            r3 = 0
            r0.a(r1, r2, r3)
            r0 = r10
            r7 = r0
            goto La9
        La9:
            r0 = r7
            if (r0 == 0) goto Lc4
            r0 = r5
            java.lang.Object r0 = r0.f1562a
            r12 = r0
            r0 = r12
            boolean r0 = r0 instanceof androidx.appcompat.app.AppCompatActivity
            if (r0 == 0) goto Lc4
            r0 = r12
            androidx.appcompat.app.AppCompatActivity r0 = (androidx.appcompat.app.AppCompatActivity) r0
            r1 = r6
            r0.onNightModeChanged(r1)
        Lc4:
            r0 = r7
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.b(int, boolean):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0016, code lost:
        if (r6.f1585a == 108) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean b(androidx.appcompat.app.AppCompatDelegateImpl.PanelFeatureState r6) {
        /*
            Method dump skipped, instructions count: 212
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.b(androidx.appcompat.app.AppCompatDelegateImpl$PanelFeatureState):boolean");
    }

    private boolean b(PanelFeatureState panelFeatureState, KeyEvent keyEvent) {
        DecorContentParent decorContentParent;
        DecorContentParent decorContentParent2;
        DecorContentParent decorContentParent3;
        if (this.r) {
            return false;
        }
        if (panelFeatureState.m) {
            return true;
        }
        PanelFeatureState panelFeatureState2 = this.N;
        if (panelFeatureState2 != null && panelFeatureState2 != panelFeatureState) {
            a(panelFeatureState2, false);
        }
        Window.Callback b = b();
        if (b != null) {
            panelFeatureState.i = b.onCreatePanelView(panelFeatureState.f1585a);
        }
        boolean z2 = panelFeatureState.f1585a == 0 || panelFeatureState.f1585a == 108;
        if (z2 && (decorContentParent3 = this.C) != null) {
            decorContentParent3.setMenuPrepared();
        }
        if (panelFeatureState.i == null && (!z2 || !(a() instanceof ToolbarActionBar))) {
            if (panelFeatureState.j == null || panelFeatureState.q) {
                if (panelFeatureState.j == null && (!b(panelFeatureState) || panelFeatureState.j == null)) {
                    return false;
                }
                if (z2 && this.C != null) {
                    if (this.D == null) {
                        this.D = new ActionMenuPresenterCallback();
                    }
                    this.C.setMenu(panelFeatureState.j, this.D);
                }
                panelFeatureState.j.stopDispatchingItemsChanged();
                if (!b.onCreatePanelMenu(panelFeatureState.f1585a, panelFeatureState.j)) {
                    panelFeatureState.a((MenuBuilder) null);
                    if (!z2 || (decorContentParent = this.C) == null) {
                        return false;
                    }
                    decorContentParent.setMenu(null, this.D);
                    return false;
                }
                panelFeatureState.q = false;
            }
            panelFeatureState.j.stopDispatchingItemsChanged();
            if (panelFeatureState.r != null) {
                panelFeatureState.j.restoreActionViewStates(panelFeatureState.r);
                panelFeatureState.r = null;
            }
            if (!b.onPreparePanel(0, panelFeatureState.i, panelFeatureState.j)) {
                if (z2 && (decorContentParent2 = this.C) != null) {
                    decorContentParent2.setMenu(null, this.D);
                }
                panelFeatureState.j.startDispatchingItemsChanged();
                return false;
            }
            panelFeatureState.qwertyMode = KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1;
            panelFeatureState.j.setQwertyMode(panelFeatureState.qwertyMode);
            panelFeatureState.j.startDispatchingItemsChanged();
        }
        panelFeatureState.m = true;
        panelFeatureState.n = false;
        this.N = panelFeatureState;
        return true;
    }

    private boolean b(boolean z2) {
        if (this.r) {
            return false;
        }
        int q = q();
        boolean b = b(a(this.b, q), z2);
        if (q == 0) {
            a(this.b).b();
        } else {
            AutoNightModeManager autoNightModeManager = this.W;
            if (autoNightModeManager != null) {
                autoNightModeManager.c();
            }
        }
        if (q == 3) {
            b(this.b).b();
            return b;
        }
        AutoNightModeManager autoNightModeManager2 = this.X;
        if (autoNightModeManager2 != null) {
            autoNightModeManager2.c();
        }
        return b;
    }

    private boolean c(PanelFeatureState panelFeatureState) {
        if (panelFeatureState.i != null) {
            panelFeatureState.h = panelFeatureState.i;
            return true;
        } else if (panelFeatureState.j == null) {
            return false;
        } else {
            if (this.E == null) {
                this.E = new PanelMenuPresenterCallback();
            }
            panelFeatureState.h = (View) panelFeatureState.a(this.E);
            return panelFeatureState.h != null;
        }
    }

    private boolean d(int i, KeyEvent keyEvent) {
        if (keyEvent.getRepeatCount() == 0) {
            PanelFeatureState a2 = a(i, true);
            if (a2.o) {
                return false;
            }
            return b(a2, keyEvent);
        }
        return false;
    }

    private void e(int i) {
        this.t = (1 << i) | this.t;
        if (this.s) {
            return;
        }
        ViewCompat.postOnAnimation(this.f1563c.getDecorView(), this.Y);
        this.s = true;
    }

    private boolean e(int i, KeyEvent keyEvent) {
        boolean z2;
        boolean z3;
        DecorContentParent decorContentParent;
        if (this.g != null) {
            return false;
        }
        PanelFeatureState a2 = a(i, true);
        if (i != 0 || (decorContentParent = this.C) == null || !decorContentParent.canShowOverflowMenu() || ViewConfiguration.get(this.b).hasPermanentMenuKey()) {
            if (a2.o || a2.n) {
                z2 = a2.o;
                a(a2, true);
            } else {
                if (a2.m) {
                    if (a2.q) {
                        a2.m = false;
                        z3 = b(a2, keyEvent);
                    } else {
                        z3 = true;
                    }
                    if (z3) {
                        a(a2, keyEvent);
                        z2 = true;
                    }
                }
                z2 = false;
            }
        } else if (this.C.isOverflowMenuShowing()) {
            z2 = this.C.hideOverflowMenu();
        } else {
            if (!this.r && b(a2, keyEvent)) {
                z2 = this.C.showOverflowMenu();
            }
            z2 = false;
        }
        if (z2) {
            AudioManager audioManager = (AudioManager) this.b.getApplicationContext().getSystemService("audio");
            if (audioManager != null) {
                audioManager.playSoundEffect(0);
                return z2;
            }
            Log.w("AppCompatDelegate", "Couldn't get audio manager");
        }
        return z2;
    }

    private int f(int i) {
        if (i == 8) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR id when requesting this feature.");
            return 108;
        }
        int i2 = i;
        if (i == 9) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY id when requesting this feature.");
            i2 = 109;
        }
        return i2;
    }

    private void i() {
        l();
        if (this.m && this.e == null) {
            Object obj = this.f1562a;
            if (obj instanceof Activity) {
                this.e = new WindowDecorActionBar((Activity) obj, this.n);
            } else if (obj instanceof Dialog) {
                this.e = new WindowDecorActionBar((Dialog) obj);
            }
            ActionBar actionBar = this.e;
            if (actionBar != null) {
                actionBar.setDefaultDisplayHomeAsUpEnabled(this.Z);
            }
        }
    }

    private void j() {
        AutoNightModeManager autoNightModeManager = this.W;
        if (autoNightModeManager != null) {
            autoNightModeManager.c();
        }
        AutoNightModeManager autoNightModeManager2 = this.X;
        if (autoNightModeManager2 != null) {
            autoNightModeManager2.c();
        }
    }

    private void k() {
        if (this.f1563c == null) {
            Object obj = this.f1562a;
            if (obj instanceof Activity) {
                a(((Activity) obj).getWindow());
            }
        }
        if (this.f1563c == null) {
            throw new IllegalStateException("We have not been given a Window");
        }
    }

    private void l() {
        if (this.G) {
            return;
        }
        this.l = m();
        CharSequence d = d();
        if (!TextUtils.isEmpty(d)) {
            DecorContentParent decorContentParent = this.C;
            if (decorContentParent != null) {
                decorContentParent.setWindowTitle(d);
            } else if (a() != null) {
                a().setWindowTitle(d);
            } else {
                TextView textView = this.H;
                if (textView != null) {
                    textView.setText(d);
                }
            }
        }
        n();
        a(this.l);
        this.G = true;
        PanelFeatureState a2 = a(0, false);
        if (this.r) {
            return;
        }
        if (a2 == null || a2.j == null) {
            e(108);
        }
    }

    private ViewGroup m() {
        ViewGroup viewGroup;
        TypedArray obtainStyledAttributes = this.b.obtainStyledAttributes(R.styleable.AppCompatTheme);
        if (!obtainStyledAttributes.hasValue(R.styleable.AppCompatTheme_windowActionBar)) {
            obtainStyledAttributes.recycle();
            throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
        }
        if (obtainStyledAttributes.getBoolean(R.styleable.AppCompatTheme_windowNoTitle, false)) {
            requestWindowFeature(1);
        } else if (obtainStyledAttributes.getBoolean(R.styleable.AppCompatTheme_windowActionBar, false)) {
            requestWindowFeature(108);
        }
        if (obtainStyledAttributes.getBoolean(R.styleable.AppCompatTheme_windowActionBarOverlay, false)) {
            requestWindowFeature(109);
        }
        if (obtainStyledAttributes.getBoolean(R.styleable.AppCompatTheme_windowActionModeOverlay, false)) {
            requestWindowFeature(10);
        }
        this.p = obtainStyledAttributes.getBoolean(R.styleable.AppCompatTheme_android_windowIsFloating, false);
        obtainStyledAttributes.recycle();
        k();
        this.f1563c.getDecorView();
        LayoutInflater from = LayoutInflater.from(this.b);
        if (this.q) {
            viewGroup = this.o ? (ViewGroup) from.inflate(R.layout.abc_screen_simple_overlay_action_mode, (ViewGroup) null) : (ViewGroup) from.inflate(R.layout.abc_screen_simple, (ViewGroup) null);
        } else if (this.p) {
            viewGroup = (ViewGroup) from.inflate(R.layout.abc_dialog_title_material, (ViewGroup) null);
            this.n = false;
            this.m = false;
        } else if (this.m) {
            TypedValue typedValue = new TypedValue();
            this.b.getTheme().resolveAttribute(R.attr.actionBarTheme, typedValue, true);
            ViewGroup viewGroup2 = (ViewGroup) LayoutInflater.from(typedValue.resourceId != 0 ? new androidx.appcompat.view.ContextThemeWrapper(this.b, typedValue.resourceId) : this.b).inflate(R.layout.abc_screen_toolbar, (ViewGroup) null);
            DecorContentParent decorContentParent = (DecorContentParent) viewGroup2.findViewById(R.id.decor_content_parent);
            this.C = decorContentParent;
            decorContentParent.setWindowCallback(b());
            if (this.n) {
                this.C.initFeature(109);
            }
            if (this.J) {
                this.C.initFeature(2);
            }
            viewGroup = viewGroup2;
            if (this.K) {
                this.C.initFeature(5);
                viewGroup = viewGroup2;
            }
        } else {
            viewGroup = null;
        }
        if (viewGroup == null) {
            throw new IllegalArgumentException("AppCompat does not support the current theme features: { windowActionBar: " + this.m + ", windowActionBarOverlay: " + this.n + ", android:windowIsFloating: " + this.p + ", windowActionModeOverlay: " + this.o + ", windowNoTitle: " + this.q + " }");
        }
        if (Build.VERSION.SDK_INT >= 21) {
            ViewCompat.setOnApplyWindowInsetsListener(viewGroup, new OnApplyWindowInsetsListener() { // from class: androidx.appcompat.app.AppCompatDelegateImpl.3
                @Override // androidx.core.view.OnApplyWindowInsetsListener
                public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                    int systemWindowInsetTop = windowInsetsCompat.getSystemWindowInsetTop();
                    int a2 = AppCompatDelegateImpl.this.a(windowInsetsCompat, (Rect) null);
                    WindowInsetsCompat windowInsetsCompat2 = windowInsetsCompat;
                    if (systemWindowInsetTop != a2) {
                        windowInsetsCompat2 = windowInsetsCompat.replaceSystemWindowInsets(windowInsetsCompat.getSystemWindowInsetLeft(), a2, windowInsetsCompat.getSystemWindowInsetRight(), windowInsetsCompat.getSystemWindowInsetBottom());
                    }
                    return ViewCompat.onApplyWindowInsets(view, windowInsetsCompat2);
                }
            });
        } else if (viewGroup instanceof FitWindowsViewGroup) {
            ((FitWindowsViewGroup) viewGroup).setOnFitSystemWindowsListener(new FitWindowsViewGroup.OnFitSystemWindowsListener() { // from class: androidx.appcompat.app.AppCompatDelegateImpl.4
                @Override // androidx.appcompat.widget.FitWindowsViewGroup.OnFitSystemWindowsListener
                public void onFitSystemWindows(Rect rect) {
                    rect.top = AppCompatDelegateImpl.this.a((WindowInsetsCompat) null, rect);
                }
            });
        }
        if (this.C == null) {
            this.H = (TextView) viewGroup.findViewById(R.id.title);
        }
        ViewUtils.makeOptionalFitsSystemWindows(viewGroup);
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) viewGroup.findViewById(R.id.action_bar_activity_content);
        ViewGroup viewGroup3 = (ViewGroup) this.f1563c.findViewById(16908290);
        if (viewGroup3 != null) {
            while (viewGroup3.getChildCount() > 0) {
                View childAt = viewGroup3.getChildAt(0);
                viewGroup3.removeViewAt(0);
                contentFrameLayout.addView(childAt);
            }
            viewGroup3.setId(-1);
            contentFrameLayout.setId(16908290);
            if (viewGroup3 instanceof FrameLayout) {
                ((FrameLayout) viewGroup3).setForeground(null);
            }
        }
        this.f1563c.setContentView(viewGroup);
        contentFrameLayout.setAttachListener(new ContentFrameLayout.OnAttachListener() { // from class: androidx.appcompat.app.AppCompatDelegateImpl.5
            @Override // androidx.appcompat.widget.ContentFrameLayout.OnAttachListener
            public void onAttachedFromWindow() {
            }

            @Override // androidx.appcompat.widget.ContentFrameLayout.OnAttachListener
            public void onDetachedFromWindow() {
                AppCompatDelegateImpl.this.h();
            }
        });
        return viewGroup;
    }

    private void n() {
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) this.l.findViewById(16908290);
        View decorView = this.f1563c.getDecorView();
        contentFrameLayout.setDecorPadding(decorView.getPaddingLeft(), decorView.getPaddingTop(), decorView.getPaddingRight(), decorView.getPaddingBottom());
        TypedArray obtainStyledAttributes = this.b.obtainStyledAttributes(R.styleable.AppCompatTheme);
        obtainStyledAttributes.getValue(R.styleable.AppCompatTheme_windowMinWidthMajor, contentFrameLayout.getMinWidthMajor());
        obtainStyledAttributes.getValue(R.styleable.AppCompatTheme_windowMinWidthMinor, contentFrameLayout.getMinWidthMinor());
        if (obtainStyledAttributes.hasValue(R.styleable.AppCompatTheme_windowFixedWidthMajor)) {
            obtainStyledAttributes.getValue(R.styleable.AppCompatTheme_windowFixedWidthMajor, contentFrameLayout.getFixedWidthMajor());
        }
        if (obtainStyledAttributes.hasValue(R.styleable.AppCompatTheme_windowFixedWidthMinor)) {
            obtainStyledAttributes.getValue(R.styleable.AppCompatTheme_windowFixedWidthMinor, contentFrameLayout.getFixedWidthMinor());
        }
        if (obtainStyledAttributes.hasValue(R.styleable.AppCompatTheme_windowFixedHeightMajor)) {
            obtainStyledAttributes.getValue(R.styleable.AppCompatTheme_windowFixedHeightMajor, contentFrameLayout.getFixedHeightMajor());
        }
        if (obtainStyledAttributes.hasValue(R.styleable.AppCompatTheme_windowFixedHeightMinor)) {
            obtainStyledAttributes.getValue(R.styleable.AppCompatTheme_windowFixedHeightMinor, contentFrameLayout.getFixedHeightMinor());
        }
        obtainStyledAttributes.recycle();
        contentFrameLayout.requestLayout();
    }

    private AppCompatActivity o() {
        Context context = this.b;
        while (true) {
            Context context2 = context;
            if (context2 == null) {
                return null;
            }
            if (context2 instanceof AppCompatActivity) {
                return (AppCompatActivity) context2;
            }
            if (!(context2 instanceof ContextWrapper)) {
                return null;
            }
            context = ((ContextWrapper) context2).getBaseContext();
        }
    }

    private void p() {
        if (this.G) {
            throw new AndroidRuntimeException("Window feature must be requested before adding content");
        }
    }

    private int q() {
        int i = this.S;
        return i != -100 ? i : getDefaultNightMode();
    }

    private boolean r() {
        if (!this.V && (this.f1562a instanceof Activity)) {
            PackageManager packageManager = this.b.getPackageManager();
            if (packageManager == null) {
                return false;
            }
            try {
                ActivityInfo activityInfo = packageManager.getActivityInfo(new ComponentName(this.b, this.f1562a.getClass()), Build.VERSION.SDK_INT >= 29 ? 269221888 : Build.VERSION.SDK_INT >= 24 ? 786432 : 0);
                this.U = (activityInfo == null || (activityInfo.configChanges & 512) == 0) ? false : true;
            } catch (PackageManager.NameNotFoundException e) {
                Log.d("AppCompatDelegate", "Exception while getting ActivityInfo", e);
                this.U = false;
            }
        }
        this.V = true;
        return this.U;
    }

    int a(Context context, int i) {
        if (i != -100) {
            if (i != -1) {
                if (i == 0) {
                    if (Build.VERSION.SDK_INT < 23 || ((UiModeManager) context.getApplicationContext().getSystemService(Context.UI_MODE_SERVICE)).getNightMode() != 0) {
                        return a(context).getApplyableNightMode();
                    }
                    return -1;
                } else if (i != 1 && i != 2) {
                    if (i == 3) {
                        return b(context).getApplyableNightMode();
                    }
                    throw new IllegalStateException("Unknown value set for night mode. Please use one of the MODE_NIGHT values from AppCompatDelegate.");
                }
            }
            return i;
        }
        return -1;
    }

    final int a(WindowInsetsCompat windowInsetsCompat, Rect rect) {
        boolean z2;
        int i;
        boolean z3;
        boolean z4;
        int systemWindowInsetTop = windowInsetsCompat != null ? windowInsetsCompat.getSystemWindowInsetTop() : rect != null ? rect.top : 0;
        ActionBarContextView actionBarContextView = this.h;
        if (actionBarContextView == null || !(actionBarContextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            z2 = false;
            i = systemWindowInsetTop;
        } else {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.h.getLayoutParams();
            boolean z5 = true;
            if (this.h.isShown()) {
                if (this.aa == null) {
                    this.aa = new Rect();
                    this.ab = new Rect();
                }
                Rect rect2 = this.aa;
                Rect rect3 = this.ab;
                if (windowInsetsCompat == null) {
                    rect2.set(rect);
                } else {
                    rect2.set(windowInsetsCompat.getSystemWindowInsetLeft(), windowInsetsCompat.getSystemWindowInsetTop(), windowInsetsCompat.getSystemWindowInsetRight(), windowInsetsCompat.getSystemWindowInsetBottom());
                }
                ViewUtils.computeFitSystemWindows(this.l, rect2, rect3);
                int i2 = rect2.top;
                int i3 = rect2.left;
                int i4 = rect2.right;
                WindowInsetsCompat rootWindowInsets = ViewCompat.getRootWindowInsets(this.l);
                int systemWindowInsetLeft = rootWindowInsets == null ? 0 : rootWindowInsets.getSystemWindowInsetLeft();
                int systemWindowInsetRight = rootWindowInsets == null ? 0 : rootWindowInsets.getSystemWindowInsetRight();
                if (marginLayoutParams.topMargin == i2 && marginLayoutParams.leftMargin == i3 && marginLayoutParams.rightMargin == i4) {
                    z4 = false;
                } else {
                    marginLayoutParams.topMargin = i2;
                    marginLayoutParams.leftMargin = i3;
                    marginLayoutParams.rightMargin = i4;
                    z4 = true;
                }
                if (i2 <= 0 || this.I != null) {
                    View view = this.I;
                    if (view != null) {
                        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                        if (marginLayoutParams2.height != marginLayoutParams.topMargin || marginLayoutParams2.leftMargin != systemWindowInsetLeft || marginLayoutParams2.rightMargin != systemWindowInsetRight) {
                            marginLayoutParams2.height = marginLayoutParams.topMargin;
                            marginLayoutParams2.leftMargin = systemWindowInsetLeft;
                            marginLayoutParams2.rightMargin = systemWindowInsetRight;
                            this.I.setLayoutParams(marginLayoutParams2);
                        }
                    }
                } else {
                    View view2 = new View(this.b);
                    this.I = view2;
                    view2.setVisibility(8);
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, marginLayoutParams.topMargin, 51);
                    layoutParams.leftMargin = systemWindowInsetLeft;
                    layoutParams.rightMargin = systemWindowInsetRight;
                    this.l.addView(this.I, -1, layoutParams);
                }
                boolean z6 = this.I != null;
                if (z6 && this.I.getVisibility() != 0) {
                    a(this.I);
                }
                int i5 = systemWindowInsetTop;
                if (!this.o) {
                    i5 = systemWindowInsetTop;
                    if (z6) {
                        i5 = 0;
                    }
                }
                systemWindowInsetTop = i5;
                z5 = z4;
                z3 = z6;
            } else if (marginLayoutParams.topMargin != 0) {
                marginLayoutParams.topMargin = 0;
                z3 = false;
            } else {
                z3 = false;
                z5 = false;
            }
            i = systemWindowInsetTop;
            z2 = z3;
            if (z5) {
                this.h.setLayoutParams(marginLayoutParams);
                i = systemWindowInsetTop;
                z2 = z3;
            }
        }
        View view3 = this.I;
        if (view3 != null) {
            view3.setVisibility(z2 ? 0 : 8);
        }
        return i;
    }

    final ActionBar a() {
        return this.e;
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0012, code lost:
        if (r0.length <= r7) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected androidx.appcompat.app.AppCompatDelegateImpl.PanelFeatureState a(int r7, boolean r8) {
        /*
            r6 = this;
            r0 = r6
            androidx.appcompat.app.AppCompatDelegateImpl$PanelFeatureState[] r0 = r0.M
            r10 = r0
            r0 = r10
            if (r0 == 0) goto L15
            r0 = r10
            r9 = r0
            r0 = r10
            int r0 = r0.length
            r1 = r7
            if (r0 > r1) goto L31
        L15:
            r0 = r7
            r1 = 1
            int r0 = r0 + r1
            androidx.appcompat.app.AppCompatDelegateImpl$PanelFeatureState[] r0 = new androidx.appcompat.app.AppCompatDelegateImpl.PanelFeatureState[r0]
            r9 = r0
            r0 = r10
            if (r0 == 0) goto L2c
            r0 = r10
            r1 = 0
            r2 = r9
            r3 = 0
            r4 = r10
            int r4 = r4.length
            java.lang.System.arraycopy(r0, r1, r2, r3, r4)
        L2c:
            r0 = r6
            r1 = r9
            r0.M = r1
        L31:
            r0 = r9
            r1 = r7
            r0 = r0[r1]
            r11 = r0
            r0 = r11
            r10 = r0
            r0 = r11
            if (r0 != 0) goto L4e
            androidx.appcompat.app.AppCompatDelegateImpl$PanelFeatureState r0 = new androidx.appcompat.app.AppCompatDelegateImpl$PanelFeatureState
            r1 = r0
            r2 = r7
            r1.<init>(r2)
            r10 = r0
            r0 = r9
            r1 = r7
            r2 = r10
            r0[r1] = r2
        L4e:
            r0 = r10
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.a(int, boolean):androidx.appcompat.app.AppCompatDelegateImpl$PanelFeatureState");
    }

    PanelFeatureState a(Menu menu) {
        PanelFeatureState[] panelFeatureStateArr = this.M;
        int length = panelFeatureStateArr != null ? panelFeatureStateArr.length : 0;
        for (int i = 0; i < length; i++) {
            PanelFeatureState panelFeatureState = panelFeatureStateArr[i];
            if (panelFeatureState != null && panelFeatureState.j == menu) {
                return panelFeatureState;
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0053  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    androidx.appcompat.view.ActionMode a(androidx.appcompat.view.ActionMode.Callback r8) {
        /*
            Method dump skipped, instructions count: 602
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.a(androidx.appcompat.view.ActionMode$Callback):androidx.appcompat.view.ActionMode");
    }

    void a(int i) {
        if (i == 108) {
            ActionBar supportActionBar = getSupportActionBar();
            if (supportActionBar != null) {
                supportActionBar.dispatchMenuVisibilityChanged(false);
            }
        } else if (i == 0) {
            PanelFeatureState a2 = a(i, true);
            if (a2.o) {
                a(a2, false);
            }
        }
    }

    void a(int i, PanelFeatureState panelFeatureState, Menu menu) {
        PanelFeatureState panelFeatureState2 = panelFeatureState;
        MenuBuilder menuBuilder = menu;
        if (menu == null) {
            PanelFeatureState panelFeatureState3 = panelFeatureState;
            if (panelFeatureState == null) {
                panelFeatureState3 = panelFeatureState;
                if (i >= 0) {
                    PanelFeatureState[] panelFeatureStateArr = this.M;
                    panelFeatureState3 = panelFeatureState;
                    if (i < panelFeatureStateArr.length) {
                        panelFeatureState3 = panelFeatureStateArr[i];
                    }
                }
            }
            panelFeatureState2 = panelFeatureState3;
            menuBuilder = menu;
            if (panelFeatureState3 != null) {
                menuBuilder = panelFeatureState3.j;
                panelFeatureState2 = panelFeatureState3;
            }
        }
        if ((panelFeatureState2 == null || panelFeatureState2.o) && !this.r) {
            this.A.getWrapped().onPanelClosed(i, menuBuilder);
        }
    }

    void a(ViewGroup viewGroup) {
    }

    void a(PanelFeatureState panelFeatureState, boolean z2) {
        DecorContentParent decorContentParent;
        if (z2 && panelFeatureState.f1585a == 0 && (decorContentParent = this.C) != null && decorContentParent.isOverflowMenuShowing()) {
            a(panelFeatureState.j);
            return;
        }
        WindowManager windowManager = (WindowManager) this.b.getSystemService(Context.WINDOW_SERVICE);
        if (windowManager != null && panelFeatureState.o && panelFeatureState.g != null) {
            windowManager.removeView(panelFeatureState.g);
            if (z2) {
                a(panelFeatureState.f1585a, panelFeatureState, (Menu) null);
            }
        }
        panelFeatureState.m = false;
        panelFeatureState.n = false;
        panelFeatureState.o = false;
        panelFeatureState.h = null;
        panelFeatureState.p = true;
        if (this.N == panelFeatureState) {
            this.N = null;
        }
    }

    void a(MenuBuilder menuBuilder) {
        if (this.L) {
            return;
        }
        this.L = true;
        this.C.dismissPopups();
        Window.Callback b = b();
        if (b != null && !this.r) {
            b.onPanelClosed(108, menuBuilder);
        }
        this.L = false;
    }

    boolean a(int i, KeyEvent keyEvent) {
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar == null || !supportActionBar.onKeyShortcut(i, keyEvent)) {
            PanelFeatureState panelFeatureState = this.N;
            if (panelFeatureState != null && a(panelFeatureState, keyEvent.getKeyCode(), keyEvent, 1)) {
                PanelFeatureState panelFeatureState2 = this.N;
                if (panelFeatureState2 != null) {
                    panelFeatureState2.n = true;
                    return true;
                }
                return true;
            } else if (this.N == null) {
                PanelFeatureState a2 = a(0, true);
                b(a2, keyEvent);
                boolean a3 = a(a2, keyEvent.getKeyCode(), keyEvent, 1);
                a2.m = false;
                return a3;
            } else {
                return false;
            }
        }
        return true;
    }

    boolean a(KeyEvent keyEvent) {
        View decorView;
        Object obj = this.f1562a;
        boolean z2 = true;
        if (((obj instanceof KeyEventDispatcher.Component) || (obj instanceof AppCompatDialog)) && (decorView = this.f1563c.getDecorView()) != null && KeyEventDispatcher.dispatchBeforeHierarchy(decorView, keyEvent)) {
            return true;
        }
        if (keyEvent.getKeyCode() == 82 && this.A.getWrapped().dispatchKeyEvent(keyEvent)) {
            return true;
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyEvent.getAction() != 0) {
            z2 = false;
        }
        return z2 ? c(keyCode, keyEvent) : b(keyCode, keyEvent);
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        l();
        ((ViewGroup) this.l.findViewById(16908290)).addView(view, layoutParams);
        this.A.getWrapped().onContentChanged();
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public boolean applyDayNight() {
        return b(true);
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public Context attachBaseContext2(Context context) {
        boolean z2 = true;
        this.P = true;
        int a2 = a(context, q());
        if (y && (context instanceof ContextThemeWrapper)) {
            try {
                ContextThemeWrapperCompatApi17Impl.a((ContextThemeWrapper) context, a(context, a2, (Configuration) null));
                return context;
            } catch (IllegalStateException e) {
            }
        }
        if (context instanceof androidx.appcompat.view.ContextThemeWrapper) {
            try {
                ((androidx.appcompat.view.ContextThemeWrapper) context).applyOverrideConfiguration(a(context, a2, (Configuration) null));
                return context;
            } catch (IllegalStateException e2) {
            }
        }
        if (x) {
            Configuration configuration = null;
            if (Build.VERSION.SDK_INT >= 17) {
                Configuration configuration2 = new Configuration();
                configuration2.uiMode = -1;
                configuration2.fontScale = 0.0f;
                Configuration configuration3 = Api17Impl.a(context, configuration2).getResources().getConfiguration();
                Configuration configuration4 = context.getResources().getConfiguration();
                configuration3.uiMode = configuration4.uiMode;
                configuration = null;
                if (!configuration3.equals(configuration4)) {
                    configuration = a(configuration3, configuration4);
                }
            }
            Configuration a3 = a(context, a2, configuration);
            androidx.appcompat.view.ContextThemeWrapper contextThemeWrapper = new androidx.appcompat.view.ContextThemeWrapper(context, R.style.Theme_AppCompat_Empty);
            contextThemeWrapper.applyOverrideConfiguration(a3);
            try {
                if (context.getTheme() == null) {
                    z2 = false;
                }
            } catch (NullPointerException e3) {
                z2 = false;
            }
            if (z2) {
                ResourcesCompat.ThemeCompat.rebase(contextThemeWrapper.getTheme());
            }
            return super.attachBaseContext2(contextThemeWrapper);
        }
        return super.attachBaseContext2(context);
    }

    final Window.Callback b() {
        return this.f1563c.getCallback();
    }

    void b(int i) {
        ActionBar supportActionBar;
        if (i != 108 || (supportActionBar = getSupportActionBar()) == null) {
            return;
        }
        supportActionBar.dispatchMenuVisibilityChanged(true);
    }

    boolean b(int i, KeyEvent keyEvent) {
        if (i != 4) {
            if (i != 82) {
                return false;
            }
            e(0, keyEvent);
            return true;
        }
        boolean z2 = this.O;
        this.O = false;
        PanelFeatureState a2 = a(0, false);
        if (a2 == null || !a2.o) {
            return g();
        } else if (z2) {
            return true;
        } else {
            a(a2, true);
            return true;
        }
    }

    final Context c() {
        ActionBar supportActionBar = getSupportActionBar();
        Context themedContext = supportActionBar != null ? supportActionBar.getThemedContext() : null;
        Context context = themedContext;
        if (themedContext == null) {
            context = this.b;
        }
        return context;
    }

    void c(int i) {
        a(a(i, true), true);
    }

    boolean c(int i, KeyEvent keyEvent) {
        boolean z2 = true;
        if (i != 4) {
            if (i != 82) {
                return false;
            }
            d(0, keyEvent);
            return true;
        }
        if ((keyEvent.getFlags() & 128) == 0) {
            z2 = false;
        }
        this.O = z2;
        return false;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public View createView(View view, String str, Context context, AttributeSet attributeSet) {
        boolean z2 = false;
        if (this.ac == null) {
            String string = this.b.obtainStyledAttributes(R.styleable.AppCompatTheme).getString(R.styleable.AppCompatTheme_viewInflaterClass);
            if (string == null) {
                this.ac = new AppCompatViewInflater();
            } else {
                try {
                    this.ac = (AppCompatViewInflater) this.b.getClassLoader().loadClass(string).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                } catch (Throwable th) {
                    Log.i("AppCompatDelegate", "Failed to instantiate custom view inflater " + string + ". Falling back to default.", th);
                    this.ac = new AppCompatViewInflater();
                }
            }
        }
        if (v) {
            if (this.ad == null) {
                this.ad = new LayoutIncludeDetector();
            }
            if (this.ad.a(attributeSet)) {
                z2 = true;
            } else if (!(attributeSet instanceof XmlPullParser)) {
                z2 = a((ViewParent) view);
            } else if (((XmlPullParser) attributeSet).getDepth() > 1) {
                z2 = true;
            }
        } else {
            z2 = false;
        }
        return this.ac.createView(view, str, context, attributeSet, z2, v, true, VectorEnabledTintResources.shouldBeUsed());
    }

    final CharSequence d() {
        Object obj = this.f1562a;
        return obj instanceof Activity ? ((Activity) obj).getTitle() : this.B;
    }

    void d(int i) {
        PanelFeatureState a2;
        PanelFeatureState a3 = a(i, true);
        if (a3.j != null) {
            Bundle bundle = new Bundle();
            a3.j.saveActionViewStates(bundle);
            if (bundle.size() > 0) {
                a3.r = bundle;
            }
            a3.j.stopDispatchingItemsChanged();
            a3.j.clear();
        }
        a3.q = true;
        a3.p = true;
        if ((i != 108 && i != 0) || this.C == null || (a2 = a(0, false)) == null) {
            return;
        }
        a2.m = false;
        b(a2, (KeyEvent) null);
    }

    final boolean e() {
        ViewGroup viewGroup;
        return this.G && (viewGroup = this.l) != null && ViewCompat.isLaidOut(viewGroup);
    }

    void f() {
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = this.k;
        if (viewPropertyAnimatorCompat != null) {
            viewPropertyAnimatorCompat.cancel();
        }
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public <T extends View> T findViewById(int i) {
        l();
        return (T) this.f1563c.findViewById(i);
    }

    boolean g() {
        androidx.appcompat.view.ActionMode actionMode = this.g;
        if (actionMode != null) {
            actionMode.finish();
            return true;
        }
        ActionBar supportActionBar = getSupportActionBar();
        return supportActionBar != null && supportActionBar.collapseActionView();
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public final ActionBarDrawerToggle.Delegate getDrawerToggleDelegate() {
        return new ActionBarDrawableToggleImpl();
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public int getLocalNightMode() {
        return this.S;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public MenuInflater getMenuInflater() {
        if (this.f == null) {
            i();
            ActionBar actionBar = this.e;
            this.f = new SupportMenuInflater(actionBar != null ? actionBar.getThemedContext() : this.b);
        }
        return this.f;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public ActionBar getSupportActionBar() {
        i();
        return this.e;
    }

    void h() {
        DecorContentParent decorContentParent = this.C;
        if (decorContentParent != null) {
            decorContentParent.dismissPopups();
        }
        if (this.i != null) {
            this.f1563c.getDecorView().removeCallbacks(this.j);
            if (this.i.isShowing()) {
                try {
                    this.i.dismiss();
                } catch (IllegalArgumentException e) {
                }
            }
            this.i = null;
        }
        f();
        PanelFeatureState a2 = a(0, false);
        if (a2 == null || a2.j == null) {
            return;
        }
        a2.j.close();
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public boolean hasWindowFeature(int i) {
        int f = f(i);
        boolean z2 = true;
        if (!(f != 1 ? f != 2 ? f != 5 ? f != 10 ? f != 108 ? f != 109 ? false : this.n : this.m : this.o : this.K : this.J : this.q)) {
            if (this.f1563c.hasFeature(i)) {
                return true;
            }
            z2 = false;
        }
        return z2;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void installViewFactory() {
        LayoutInflater from = LayoutInflater.from(this.b);
        if (from.getFactory() == null) {
            LayoutInflaterCompat.setFactory2(from, this);
        } else if (from.getFactory2() instanceof AppCompatDelegateImpl) {
        } else {
            Log.i("AppCompatDelegate", "The Activity's LayoutInflater already has a Factory installed so we can not install AppCompat's");
        }
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void invalidateOptionsMenu() {
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar == null || !supportActionBar.invalidateOptionsMenu()) {
            e(0);
        }
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public boolean isHandleNativeActionModesEnabled() {
        return this.F;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void onConfigurationChanged(Configuration configuration) {
        ActionBar supportActionBar;
        if (this.m && this.G && (supportActionBar = getSupportActionBar()) != null) {
            supportActionBar.onConfigurationChanged(configuration);
        }
        AppCompatDrawableManager.get().onConfigurationChanged(this.b);
        this.R = new Configuration(this.b.getResources().getConfiguration());
        b(false);
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void onCreate(Bundle bundle) {
        this.P = true;
        b(false);
        k();
        Object obj = this.f1562a;
        if (obj instanceof Activity) {
            String str = null;
            try {
                str = NavUtils.getParentActivityName((Activity) obj);
            } catch (IllegalArgumentException e) {
            }
            if (str != null) {
                ActionBar a2 = a();
                if (a2 == null) {
                    this.Z = true;
                } else {
                    a2.setDefaultDisplayHomeAsUpEnabled(true);
                }
            }
            a(this);
        }
        this.R = new Configuration(this.b.getResources().getConfiguration());
        this.Q = true;
    }

    @Override // android.view.LayoutInflater.Factory2
    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return createView(view, str, context, attributeSet);
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x007d  */
    @Override // androidx.appcompat.app.AppCompatDelegate
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onDestroy() {
        /*
            r4 = this;
            r0 = r4
            java.lang.Object r0 = r0.f1562a
            boolean r0 = r0 instanceof android.app.Activity
            if (r0 == 0) goto Le
            r0 = r4
            b(r0)
        Le:
            r0 = r4
            boolean r0 = r0.s
            if (r0 == 0) goto L24
            r0 = r4
            android.view.Window r0 = r0.f1563c
            android.view.View r0 = r0.getDecorView()
            r1 = r4
            java.lang.Runnable r1 = r1.Y
            boolean r0 = r0.removeCallbacks(r1)
        L24:
            r0 = r4
            r1 = 1
            r0.r = r1
            r0 = r4
            int r0 = r0.S
            r1 = -100
            if (r0 == r1) goto L63
            r0 = r4
            java.lang.Object r0 = r0.f1562a
            r5 = r0
            r0 = r5
            boolean r0 = r0 instanceof android.app.Activity
            if (r0 == 0) goto L63
            r0 = r5
            android.app.Activity r0 = (android.app.Activity) r0
            boolean r0 = r0.isChangingConfigurations()
            if (r0 == 0) goto L63
            androidx.collection.SimpleArrayMap<java.lang.String, java.lang.Integer> r0 = androidx.appcompat.app.AppCompatDelegateImpl.u
            r1 = r4
            java.lang.Object r1 = r1.f1562a
            java.lang.Class r1 = r1.getClass()
            java.lang.String r1 = r1.getName()
            r2 = r4
            int r2 = r2.S
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            java.lang.Object r0 = r0.put(r1, r2)
            goto L74
        L63:
            androidx.collection.SimpleArrayMap<java.lang.String, java.lang.Integer> r0 = androidx.appcompat.app.AppCompatDelegateImpl.u
            r1 = r4
            java.lang.Object r1 = r1.f1562a
            java.lang.Class r1 = r1.getClass()
            java.lang.String r1 = r1.getName()
            java.lang.Object r0 = r0.remove(r1)
        L74:
            r0 = r4
            androidx.appcompat.app.ActionBar r0 = r0.e
            r5 = r0
            r0 = r5
            if (r0 == 0) goto L81
            r0 = r5
            r0.a()
        L81:
            r0 = r4
            r0.j()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.onDestroy():void");
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
    public boolean onMenuItemSelected(MenuBuilder menuBuilder, MenuItem menuItem) {
        PanelFeatureState a2;
        Window.Callback b = b();
        if (b == null || this.r || (a2 = a((Menu) menuBuilder.getRootMenu())) == null) {
            return false;
        }
        return b.onMenuItemSelected(a2.f1585a, menuItem);
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
    public void onMenuModeChange(MenuBuilder menuBuilder) {
        a(true);
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void onPostCreate(Bundle bundle) {
        l();
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void onPostResume() {
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setShowHideAnimationEnabled(true);
        }
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void onSaveInstanceState(Bundle bundle) {
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void onStart() {
        applyDayNight();
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void onStop() {
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setShowHideAnimationEnabled(false);
        }
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public boolean requestWindowFeature(int i) {
        int f = f(i);
        if (this.q && f == 108) {
            return false;
        }
        if (this.m && f == 1) {
            this.m = false;
        }
        if (f == 1) {
            p();
            this.q = true;
            return true;
        } else if (f == 2) {
            p();
            this.J = true;
            return true;
        } else if (f == 5) {
            p();
            this.K = true;
            return true;
        } else if (f == 10) {
            p();
            this.o = true;
            return true;
        } else if (f == 108) {
            p();
            this.m = true;
            return true;
        } else if (f != 109) {
            return this.f1563c.requestFeature(f);
        } else {
            p();
            this.n = true;
            return true;
        }
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void setContentView(int i) {
        l();
        ViewGroup viewGroup = (ViewGroup) this.l.findViewById(16908290);
        viewGroup.removeAllViews();
        LayoutInflater.from(this.b).inflate(i, viewGroup);
        this.A.getWrapped().onContentChanged();
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void setContentView(View view) {
        l();
        ViewGroup viewGroup = (ViewGroup) this.l.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        this.A.getWrapped().onContentChanged();
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        l();
        ViewGroup viewGroup = (ViewGroup) this.l.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        this.A.getWrapped().onContentChanged();
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void setHandleNativeActionModesEnabled(boolean z2) {
        this.F = z2;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void setLocalNightMode(int i) {
        if (this.S != i) {
            this.S = i;
            if (this.P) {
                applyDayNight();
            }
        }
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void setSupportActionBar(Toolbar toolbar) {
        if (this.f1562a instanceof Activity) {
            ActionBar supportActionBar = getSupportActionBar();
            if (supportActionBar instanceof WindowDecorActionBar) {
                throw new IllegalStateException("This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_SUPPORT_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead.");
            }
            this.f = null;
            if (supportActionBar != null) {
                supportActionBar.a();
            }
            this.e = null;
            if (toolbar != null) {
                ToolbarActionBar toolbarActionBar = new ToolbarActionBar(toolbar, d(), this.A);
                this.e = toolbarActionBar;
                this.A.a(toolbarActionBar.f1598c);
            } else {
                this.A.a((ActionBarMenuCallback) null);
            }
            invalidateOptionsMenu();
        }
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void setTheme(int i) {
        this.T = i;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public final void setTitle(CharSequence charSequence) {
        this.B = charSequence;
        DecorContentParent decorContentParent = this.C;
        if (decorContentParent != null) {
            decorContentParent.setWindowTitle(charSequence);
        } else if (a() != null) {
            a().setWindowTitle(charSequence);
        } else {
            TextView textView = this.H;
            if (textView != null) {
                textView.setText(charSequence);
            }
        }
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public androidx.appcompat.view.ActionMode startSupportActionMode(ActionMode.Callback callback) {
        AppCompatCallback appCompatCallback;
        if (callback != null) {
            androidx.appcompat.view.ActionMode actionMode = this.g;
            if (actionMode != null) {
                actionMode.finish();
            }
            ActionModeCallbackWrapperV9 actionModeCallbackWrapperV9 = new ActionModeCallbackWrapperV9(callback);
            ActionBar supportActionBar = getSupportActionBar();
            if (supportActionBar != null) {
                androidx.appcompat.view.ActionMode startActionMode = supportActionBar.startActionMode(actionModeCallbackWrapperV9);
                this.g = startActionMode;
                if (startActionMode != null && (appCompatCallback = this.d) != null) {
                    appCompatCallback.onSupportActionModeStarted(startActionMode);
                }
            }
            if (this.g == null) {
                this.g = a(actionModeCallbackWrapperV9);
            }
            return this.g;
        }
        throw new IllegalArgumentException("ActionMode callback can not be null.");
    }
}
