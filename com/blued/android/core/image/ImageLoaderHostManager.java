package com.blued.android.core.image;

import com.blued.android.core.net.IRequestHost;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/image/ImageLoaderHostManager.class */
public class ImageLoaderHostManager {
    private static final ConcurrentHashMap<IRequestHost, Object> a = new ConcurrentHashMap<>();

    public static Object a(IRequestHost iRequestHost) {
        if (iRequestHost == null) {
            return null;
        }
        return a.get(iRequestHost);
    }

    public static void a(IRequestHost iRequestHost, Object obj) {
        if (iRequestHost == null || obj == null) {
            return;
        }
        a.put(iRequestHost, obj);
    }

    public static void b(IRequestHost iRequestHost) {
        if (iRequestHost == null) {
            return;
        }
        a.remove(iRequestHost);
    }
}
