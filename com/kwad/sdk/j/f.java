package com.kwad.sdk.j;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/j/f.class */
public final class f extends Application implements a {
    private final Application aDK;
    private final g aDL;

    public f(Application application, g gVar) {
        this.aDK = application;
        this.aDL = gVar;
        attachBaseContext(gVar);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final Context getApplicationContext() {
        return this.aDL.getApplicationContext();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final ClassLoader getClassLoader() {
        return this.aDL.getClassLoader();
    }

    @Override // com.kwad.sdk.j.a
    public final Context getDelegatedContext() {
        return this.aDK;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final Resources getResources() {
        return this.aDL.getResources();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final void startActivity(Intent intent) {
        super.startActivity(intent);
    }
}
