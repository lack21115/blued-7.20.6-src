package com.bumptech.glide.signature;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import com.bumptech.glide.load.Key;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/signature/ApplicationVersionSignature.class */
public final class ApplicationVersionSignature {

    /* renamed from: a  reason: collision with root package name */
    private static final ConcurrentMap<String, Key> f21091a = new ConcurrentHashMap();

    private ApplicationVersionSignature() {
    }

    public static Key a(Context context) {
        String packageName = context.getPackageName();
        Key key = f21091a.get(packageName);
        Key key2 = key;
        if (key == null) {
            Key b = b(context);
            key2 = f21091a.putIfAbsent(packageName, b);
            if (key2 == null) {
                return b;
            }
        }
        return key2;
    }

    private static String a(PackageInfo packageInfo) {
        return packageInfo != null ? String.valueOf(packageInfo.versionCode) : UUID.randomUUID().toString();
    }

    private static Key b(Context context) {
        return new ObjectKey(a(c(context)));
    }

    private static PackageInfo c(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            Log.e("AppVersionSignature", "Cannot resolve info for" + context.getPackageName(), e);
            return null;
        }
    }
}
