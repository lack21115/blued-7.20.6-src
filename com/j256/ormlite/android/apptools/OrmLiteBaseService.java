package com.j256.ormlite.android.apptools;

import android.app.Service;
import android.content.Context;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;

/* loaded from: source-7994992-dex2jar.jar:com/j256/ormlite/android/apptools/OrmLiteBaseService.class */
public abstract class OrmLiteBaseService<H extends OrmLiteSqliteOpenHelper> extends Service {
    private volatile boolean created = false;
    private volatile boolean destroyed = false;
    private volatile H helper;

    public ConnectionSource getConnectionSource() {
        return getHelper().getConnectionSource();
    }

    public H getHelper() {
        if (this.helper == null) {
            if (this.created) {
                if (this.destroyed) {
                    throw new IllegalStateException("A call to onDestroy has already been made and the helper cannot be used after that point");
                }
                throw new IllegalStateException("Helper is null for some unknown reason");
            }
            throw new IllegalStateException("A call has not been made to onCreate() yet so the helper is null");
        }
        return this.helper;
    }

    protected H getHelperInternal(Context context) {
        return (H) OpenHelperManager.getHelper(context);
    }

    @Override // android.app.Service
    public void onCreate() {
        if (this.helper == null) {
            this.helper = getHelperInternal(this);
            this.created = true;
        }
        super.onCreate();
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        releaseHelper(this.helper);
        this.destroyed = true;
    }

    protected void releaseHelper(H h) {
        OpenHelperManager.releaseHelper();
        this.helper = null;
    }
}
