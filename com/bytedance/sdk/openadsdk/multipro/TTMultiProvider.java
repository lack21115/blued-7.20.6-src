package com.bytedance.sdk.openadsdk.multipro;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import com.bytedance.sdk.openadsdk.ITTProvider;
import com.bytedance.sdk.openadsdk.TTAdSdk;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/sdk/openadsdk/multipro/TTMultiProvider.class */
public class TTMultiProvider extends ContentProvider {
    private ITTProvider mb() {
        ITTProvider iTTProvider = null;
        if (TTAdSdk.getAdManager() != null) {
            iTTProvider = (ITTProvider) TTAdSdk.getAdManager().getExtra(ITTProvider.class, null);
        }
        return iTTProvider;
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        if (mb() != null) {
            return mb().delete(uri, str, strArr);
        }
        return 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        return mb() != null ? mb().getType(uri) : "";
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        if (mb() != null) {
            return mb().insert(uri, contentValues);
        }
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return true;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        if (mb() != null) {
            return mb().query(uri, strArr, str, strArr2, str2);
        }
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        if (mb() != null) {
            return mb().update(uri, contentValues, str, strArr);
        }
        return 0;
    }
}
