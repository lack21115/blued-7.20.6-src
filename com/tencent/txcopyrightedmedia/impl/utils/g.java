package com.tencent.txcopyrightedmedia.impl.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.txcopyrightedmedia.TXCopyrightedMedia;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/txcopyrightedmedia/impl/utils/g.class */
public final class g {
    static volatile boolean b;

    /* renamed from: a  reason: collision with root package name */
    public final SharedPreferences f26408a;

    public g(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("m4a_sp", 0);
        this.f26408a = sharedPreferences;
        String string = sharedPreferences.getString("SDK_VERSION", null);
        if (TextUtils.equals(TXCopyrightedMedia.getSDKVersion(), string)) {
            return;
        }
        b = true;
        SharedPreferences.Editor edit = this.f26408a.edit();
        edit.putString("SDK_VERSION", TXCopyrightedMedia.getSDKVersion());
        if (!TextUtils.isEmpty(string)) {
            edit.putString("LAST_SDK_VERSION", string);
        }
        edit.apply();
    }

    public final int a() {
        return this.f26408a.getInt("MAX_CACHE_ITEM_COUNT", 50);
    }

    public final int b() {
        String string = this.f26408a.getString("LAST_SDK_VERSION", null);
        if (TextUtils.isEmpty(string)) {
            return -1;
        }
        return string.contains("ysd") ? 1 : 0;
    }
}
