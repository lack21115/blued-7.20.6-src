package com.blued.android.core.image;

import com.blued.android.core.net.IRequestHost;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.util.Util;
import java.io.File;
import java.util.HashMap;
import java.util.LinkedHashSet;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/image/ImageFileLoader.class */
public class ImageFileLoader {

    /* renamed from: a  reason: collision with root package name */
    private static HashMap<Integer, LinkedHashSet<ImageFileWrapper>> f9494a = new HashMap<>();
    private static HashMap<Integer, LinkedHashSet<ImageFileWrapper>> b = new HashMap<>();

    /* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/image/ImageFileLoader$OnLoadFileListener.class */
    public interface OnLoadFileListener {
        void onUIFinish(File file, Exception exc);
    }

    private ImageFileLoader() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static int a(Object obj, String str) {
        return Util.a(str, Util.a(obj, Util.a(1.0f)));
    }

    public static ImageFileWrapper a(IRequestHost iRequestHost) {
        return new ImageFileWrapper(iRequestHost, ImageLoader.a((IRequestHost) null).d().b(DiskCacheStrategy.f20763c).e(Integer.MIN_VALUE).d(true));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static HashMap<Integer, LinkedHashSet<ImageFileWrapper>> a(boolean z) {
        return z ? f9494a : b;
    }
}
