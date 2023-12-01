package com.kwad.sdk.j;

import android.app.Application;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/j/g.class */
public final class g extends ContextThemeWrapper {
    private final Context aDD;
    private final e aDM;
    private f aDN;
    private LayoutInflater mInflater;

    public g(Context context, e eVar) {
        super(context, k.di(context));
        this.aDD = context;
        this.aDM = eVar;
    }

    private Context FN() {
        Context baseContext = super.getBaseContext();
        Context context = baseContext;
        if (baseContext instanceof ContextWrapper) {
            context = ((ContextWrapper) baseContext).getBaseContext();
        }
        return context;
    }

    @Override // android.view.ContextThemeWrapper
    public final void applyOverrideConfiguration(Configuration configuration) {
        super.applyOverrideConfiguration(configuration);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final Context createConfigurationContext(Configuration configuration) {
        return k.wrapContextIfNeed(super.createConfigurationContext(configuration));
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final Context getApplicationContext() {
        f fVar = this.aDN;
        if (fVar != null) {
            return fVar;
        }
        Context context = this.aDD;
        if (!(context instanceof f)) {
            context = context.getApplicationContext();
            if (!(context instanceof f)) {
                boolean z = context instanceof Application;
                context = k.wrapContextIfNeed(context);
                if (!z) {
                    return context;
                }
            }
        }
        f fVar2 = (f) context;
        this.aDN = fVar2;
        return fVar2;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final ApplicationInfo getApplicationInfo() {
        return super.getApplicationInfo();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final AssetManager getAssets() {
        return this.aDM.getResources().getAssets();
    }

    @Override // android.content.ContextWrapper
    public final Context getBaseContext() {
        return super.getBaseContext();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final ClassLoader getClassLoader() {
        return this.aDM.getClassLoader();
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Resources getResources() {
        return this.aDM.getResources();
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Object getSystemService(String str) {
        if (Context.LAYOUT_INFLATER_SERVICE.equals(str)) {
            if (this.mInflater == null) {
                LayoutInflater cloneInContext = LayoutInflater.from(FN()).cloneInContext(this);
                this.mInflater = cloneInContext;
                k.a(cloneInContext);
            }
            return this.mInflater;
        }
        return this.aDD.getSystemService(str);
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Resources.Theme getTheme() {
        return super.getTheme();
    }

    @Override // android.content.Context
    public final void registerComponentCallbacks(ComponentCallbacks componentCallbacks) {
        this.aDD.registerComponentCallbacks(componentCallbacks);
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final void setTheme(int i) {
        super.setTheme(i);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final void startActivity(Intent intent) {
        super.startActivity(intent);
    }

    @Override // android.content.Context
    public final void unregisterComponentCallbacks(ComponentCallbacks componentCallbacks) {
        this.aDD.unregisterComponentCallbacks(componentCallbacks);
    }
}
