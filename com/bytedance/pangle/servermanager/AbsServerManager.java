package com.bytedance.pangle.servermanager;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/pangle/servermanager/AbsServerManager.class */
public abstract class AbsServerManager extends ContentProvider {
    static final String BUNDLE_BINDER = "binder";
    static final String METHOD_QUERY_BINDER = "query_binder";
    static final String PACKAGE_QUERY_BINDER = "package";
    static final String SERVICE_QUERY_BINDER = "service";

    @Override // android.content.ContentProvider
    public Bundle call(String str, String str2, Bundle bundle) {
        IBinder onBind;
        if (!METHOD_QUERY_BINDER.equals(str) || (onBind = onBind(str2)) == null) {
            return null;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putParcelable(BUNDLE_BINDER, new a(onBind));
        return bundle2;
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    protected IBinder onBind(String str) {
        boolean z;
        int hashCode = str.hashCode();
        if (hashCode != -807062458) {
            if (hashCode == 1984153269 && str.equals("service")) {
                z = true;
            }
            z = true;
        } else {
            if (str.equals("package")) {
                z = false;
            }
            z = true;
        }
        if (z) {
            if (!z) {
                return null;
            }
            return com.bytedance.pangle.service.a.a.b();
        }
        return com.bytedance.pangle.f.a.b();
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return false;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}
