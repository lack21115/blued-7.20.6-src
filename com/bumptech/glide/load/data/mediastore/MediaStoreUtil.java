package com.bumptech.glide.load.data.mediastore;

import android.net.Uri;
import android.provider.MediaStore;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/data/mediastore/MediaStoreUtil.class */
public final class MediaStoreUtil {
    private MediaStoreUtil() {
    }

    public static boolean a(int i, int i2) {
        return i != Integer.MIN_VALUE && i2 != Integer.MIN_VALUE && i <= 512 && i2 <= 384;
    }

    public static boolean a(Uri uri) {
        return uri != null && "content".equals(uri.getScheme()) && MediaStore.AUTHORITY.equals(uri.getAuthority());
    }

    public static boolean b(Uri uri) {
        return a(uri) && d(uri);
    }

    public static boolean c(Uri uri) {
        return a(uri) && !d(uri);
    }

    private static boolean d(Uri uri) {
        return uri.getPathSegments().contains("video");
    }
}
