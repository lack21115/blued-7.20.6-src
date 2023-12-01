package com.kwad.sdk.api.loader;

import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/api/loader/c.class */
public final class c {

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/api/loader/c$a.class */
    static final class a extends Application {
        private final Context Zp;

        a(Context context) {
            this.Zp = context;
        }

        @Override // android.content.ContextWrapper, android.content.Context
        public final Context getApplicationContext() {
            return this.Zp;
        }

        @Override // android.content.ContextWrapper, android.content.Context
        public final ApplicationInfo getApplicationInfo() {
            return this.Zp.getApplicationInfo();
        }
    }

    public static Context am(Context context) {
        if (context == null) {
            return null;
        }
        Context applicationContext = context.getApplicationContext();
        return applicationContext == null ? context : !applicationContext.getClassLoader().equals(context.getClassLoader()) ? new a(context) : context.getApplicationContext();
    }
}
