package com.blued.android.core.image;

import com.blued.android.core.net.IRequestHost;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/image/ImageLoaderHostManager.class */
public class ImageLoaderHostManager {

    /* renamed from: a  reason: collision with root package name */
    private static final ConcurrentHashMap<IRequestHost, Object> f9504a = new ConcurrentHashMap<>();

    public static Object a(IRequestHost iRequestHost) {
        if (iRequestHost == null) {
            return null;
        }
        return f9504a.get(iRequestHost);
    }

    public static void a(IRequestHost iRequestHost, Object obj) {
        if (iRequestHost == null || obj == null) {
            return;
        }
        f9504a.put(iRequestHost, obj);
    }

    public static void b(IRequestHost iRequestHost) {
        if (iRequestHost == null) {
            return;
        }
        f9504a.remove(iRequestHost);
    }
}
