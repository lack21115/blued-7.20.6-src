package com.igexin.sdk;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.igexin.push.core.ServiceManager;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/sdk/GTServiceManager.class */
public class GTServiceManager {

    /* loaded from: source-7994992-dex2jar.jar:com/igexin/sdk/GTServiceManager$a.class */
    static final class a {

        /* renamed from: a  reason: collision with root package name */
        private static final GTServiceManager f23670a = new GTServiceManager();

        private a() {
        }
    }

    private GTServiceManager() {
    }

    public static GTServiceManager getInstance() {
        return a.f23670a;
    }

    public void onActivityCreate(Activity activity) {
        ServiceManager.getInstance().a(activity);
    }

    public void onServiceCreate(Context context, Intent intent) {
        ServiceManager.getInstance().a(context, intent);
    }
}
