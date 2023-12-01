package androidx.appcompat.app;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.widget.Toolbar;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.WeakHashMap;

/* loaded from: source-8756600-dex2jar.jar:androidx/appcompat/app/SkinAppCompatDelegateImpl.class */
public class SkinAppCompatDelegateImpl extends AppCompatDelegateImpl {
    private static Map<Activity, WeakReference<AppCompatDelegate>> u = new WeakHashMap();

    private SkinAppCompatDelegateImpl(Context context, Window window, AppCompatCallback appCompatCallback) {
        super(context, window, appCompatCallback);
    }

    public static AppCompatDelegate get(Activity activity, AppCompatCallback appCompatCallback) {
        WeakReference<AppCompatDelegate> weakReference = u.get(activity);
        AppCompatDelegate appCompatDelegate = weakReference == null ? null : weakReference.get();
        SkinAppCompatDelegateImpl skinAppCompatDelegateImpl = appCompatDelegate;
        if (appCompatDelegate == null) {
            skinAppCompatDelegateImpl = new SkinAppCompatDelegateImpl(activity, activity.getWindow(), appCompatCallback);
            u.put(activity, new WeakReference<>(skinAppCompatDelegateImpl));
        }
        return skinAppCompatDelegateImpl;
    }

    @Override // androidx.appcompat.app.AppCompatDelegateImpl, androidx.appcompat.app.AppCompatDelegate
    public /* bridge */ /* synthetic */ void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        super.addContentView(view, layoutParams);
    }

    @Override // androidx.appcompat.app.AppCompatDelegateImpl, androidx.appcompat.app.AppCompatDelegate
    public /* bridge */ /* synthetic */ boolean applyDayNight() {
        return super.applyDayNight();
    }

    @Override // androidx.appcompat.app.AppCompatDelegateImpl, androidx.appcompat.app.AppCompatDelegate
    public /* bridge */ /* synthetic */ Context attachBaseContext2(Context context) {
        return super.attachBaseContext2(context);
    }

    @Override // androidx.appcompat.app.AppCompatDelegateImpl, androidx.appcompat.app.AppCompatDelegate
    public /* bridge */ /* synthetic */ View createView(View view, String str, Context context, AttributeSet attributeSet) {
        return super.createView(view, str, context, attributeSet);
    }

    @Override // androidx.appcompat.app.AppCompatDelegateImpl, androidx.appcompat.app.AppCompatDelegate
    public /* bridge */ /* synthetic */ View findViewById(int i) {
        return super.findViewById(i);
    }

    @Override // androidx.appcompat.app.AppCompatDelegateImpl, androidx.appcompat.app.AppCompatDelegate
    public /* bridge */ /* synthetic */ int getLocalNightMode() {
        return super.getLocalNightMode();
    }

    @Override // androidx.appcompat.app.AppCompatDelegateImpl, androidx.appcompat.app.AppCompatDelegate
    public /* bridge */ /* synthetic */ MenuInflater getMenuInflater() {
        return super.getMenuInflater();
    }

    @Override // androidx.appcompat.app.AppCompatDelegateImpl, androidx.appcompat.app.AppCompatDelegate
    public /* bridge */ /* synthetic */ ActionBar getSupportActionBar() {
        return super.getSupportActionBar();
    }

    @Override // androidx.appcompat.app.AppCompatDelegateImpl, androidx.appcompat.app.AppCompatDelegate
    public /* bridge */ /* synthetic */ boolean hasWindowFeature(int i) {
        return super.hasWindowFeature(i);
    }

    @Override // androidx.appcompat.app.AppCompatDelegateImpl, androidx.appcompat.app.AppCompatDelegate
    public void installViewFactory() {
    }

    @Override // androidx.appcompat.app.AppCompatDelegateImpl, androidx.appcompat.app.AppCompatDelegate
    public /* bridge */ /* synthetic */ void invalidateOptionsMenu() {
        super.invalidateOptionsMenu();
    }

    @Override // androidx.appcompat.app.AppCompatDelegateImpl, androidx.appcompat.app.AppCompatDelegate
    public /* bridge */ /* synthetic */ boolean isHandleNativeActionModesEnabled() {
        return super.isHandleNativeActionModesEnabled();
    }

    @Override // androidx.appcompat.app.AppCompatDelegateImpl, androidx.appcompat.app.AppCompatDelegate
    public /* bridge */ /* synthetic */ void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override // androidx.appcompat.app.AppCompatDelegateImpl, androidx.appcompat.app.AppCompatDelegate
    public /* bridge */ /* synthetic */ void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // androidx.appcompat.app.AppCompatDelegateImpl, android.view.LayoutInflater.Factory
    public /* bridge */ /* synthetic */ View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return super.onCreateView(str, context, attributeSet);
    }

    @Override // androidx.appcompat.app.AppCompatDelegateImpl, androidx.appcompat.app.AppCompatDelegate
    public /* bridge */ /* synthetic */ void onDestroy() {
        super.onDestroy();
    }

    @Override // androidx.appcompat.app.AppCompatDelegateImpl, androidx.appcompat.view.menu.MenuBuilder.Callback
    public /* bridge */ /* synthetic */ boolean onMenuItemSelected(MenuBuilder menuBuilder, MenuItem menuItem) {
        return super.onMenuItemSelected(menuBuilder, menuItem);
    }

    @Override // androidx.appcompat.app.AppCompatDelegateImpl, androidx.appcompat.view.menu.MenuBuilder.Callback
    public /* bridge */ /* synthetic */ void onMenuModeChange(MenuBuilder menuBuilder) {
        super.onMenuModeChange(menuBuilder);
    }

    @Override // androidx.appcompat.app.AppCompatDelegateImpl, androidx.appcompat.app.AppCompatDelegate
    public /* bridge */ /* synthetic */ void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
    }

    @Override // androidx.appcompat.app.AppCompatDelegateImpl, androidx.appcompat.app.AppCompatDelegate
    public /* bridge */ /* synthetic */ void onPostResume() {
        super.onPostResume();
    }

    @Override // androidx.appcompat.app.AppCompatDelegateImpl, androidx.appcompat.app.AppCompatDelegate
    public /* bridge */ /* synthetic */ void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
    }

    @Override // androidx.appcompat.app.AppCompatDelegateImpl, androidx.appcompat.app.AppCompatDelegate
    public /* bridge */ /* synthetic */ void onStart() {
        super.onStart();
    }

    @Override // androidx.appcompat.app.AppCompatDelegateImpl, androidx.appcompat.app.AppCompatDelegate
    public /* bridge */ /* synthetic */ void onStop() {
        super.onStop();
    }

    @Override // androidx.appcompat.app.AppCompatDelegateImpl, androidx.appcompat.app.AppCompatDelegate
    public /* bridge */ /* synthetic */ boolean requestWindowFeature(int i) {
        return super.requestWindowFeature(i);
    }

    @Override // androidx.appcompat.app.AppCompatDelegateImpl, androidx.appcompat.app.AppCompatDelegate
    public /* bridge */ /* synthetic */ void setContentView(int i) {
        super.setContentView(i);
    }

    @Override // androidx.appcompat.app.AppCompatDelegateImpl, androidx.appcompat.app.AppCompatDelegate
    public /* bridge */ /* synthetic */ void setContentView(View view) {
        super.setContentView(view);
    }

    @Override // androidx.appcompat.app.AppCompatDelegateImpl, androidx.appcompat.app.AppCompatDelegate
    public /* bridge */ /* synthetic */ void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        super.setContentView(view, layoutParams);
    }

    @Override // androidx.appcompat.app.AppCompatDelegateImpl, androidx.appcompat.app.AppCompatDelegate
    public /* bridge */ /* synthetic */ void setHandleNativeActionModesEnabled(boolean z) {
        super.setHandleNativeActionModesEnabled(z);
    }

    @Override // androidx.appcompat.app.AppCompatDelegateImpl, androidx.appcompat.app.AppCompatDelegate
    public /* bridge */ /* synthetic */ void setLocalNightMode(int i) {
        super.setLocalNightMode(i);
    }

    @Override // androidx.appcompat.app.AppCompatDelegateImpl, androidx.appcompat.app.AppCompatDelegate
    public /* bridge */ /* synthetic */ void setSupportActionBar(Toolbar toolbar) {
        super.setSupportActionBar(toolbar);
    }

    @Override // androidx.appcompat.app.AppCompatDelegateImpl, androidx.appcompat.app.AppCompatDelegate
    public /* bridge */ /* synthetic */ void setTheme(int i) {
        super.setTheme(i);
    }

    @Override // androidx.appcompat.app.AppCompatDelegateImpl, androidx.appcompat.app.AppCompatDelegate
    public /* bridge */ /* synthetic */ ActionMode startSupportActionMode(ActionMode.Callback callback) {
        return super.startSupportActionMode(callback);
    }
}
