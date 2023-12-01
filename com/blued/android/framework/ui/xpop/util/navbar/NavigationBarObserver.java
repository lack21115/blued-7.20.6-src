package com.blued.android.framework.ui.xpop.util.navbar;

import android.content.Context;
import android.database.ContentObserver;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/ui/xpop/util/navbar/NavigationBarObserver.class */
public final class NavigationBarObserver extends ContentObserver {
    private ArrayList<OnNavigationBarListener> a;
    private Context b;
    private Boolean c;

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/ui/xpop/util/navbar/NavigationBarObserver$NavigationBarObserverInstance.class */
    static class NavigationBarObserverInstance {
        private static final NavigationBarObserver a = new NavigationBarObserver();

        private NavigationBarObserverInstance() {
        }
    }

    private NavigationBarObserver() {
        super(new Handler(Looper.getMainLooper()));
        this.c = false;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        Context context;
        ArrayList<OnNavigationBarListener> arrayList;
        super.onChange(z);
        if (Build.VERSION.SDK_INT < 17 || (context = this.b) == null || context.getContentResolver() == null || (arrayList = this.a) == null || arrayList.isEmpty()) {
            return;
        }
        int i = OSUtils.a() ? Settings.Global.getInt(this.b.getContentResolver(), "force_fsg_nav_bar", 0) : OSUtils.b() ? (OSUtils.f() || Build.VERSION.SDK_INT < 21) ? Settings.System.getInt(this.b.getContentResolver(), "navigationbar_is_min", 0) : Settings.Global.getInt(this.b.getContentResolver(), "navigationbar_is_min", 0) : 0;
        Iterator<OnNavigationBarListener> it = this.a.iterator();
        while (it.hasNext()) {
            OnNavigationBarListener next = it.next();
            boolean z2 = true;
            if (i == 1) {
                z2 = false;
            }
            next.a(z2);
        }
    }
}
