package com.blued.android.core.image.http;

import android.text.TextUtils;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.image.ImageLoaderOptions;
import com.blued.android.core.image.util.FileUtils;
import com.blued.android.core.utils.Log;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.MultiModelLoaderFactory;
import java.io.File;
import java.io.InputStream;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/image/http/HttpModelLoader.class */
public class HttpModelLoader implements ModelLoader<GlideUrl, InputStream> {

    /* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/image/http/HttpModelLoader$Factory.class */
    public static class Factory implements ModelLoaderFactory<GlideUrl, InputStream> {
        public ModelLoader<GlideUrl, InputStream> a(MultiModelLoaderFactory multiModelLoaderFactory) {
            if (ImageLoader.a()) {
                Log.e("IMAGE", "-- new HttpModelLoader ");
            }
            return new HttpModelLoader();
        }

        public void a() {
        }
    }

    public ModelLoader.LoadData<InputStream> a(GlideUrl glideUrl, int i, int i2, Options options) {
        String b = glideUrl.b();
        if (ImageLoader.a()) {
            Log.e("IMAGE", "-- buildLoadData : " + b);
        }
        File a = FileUtils.a(b);
        if (a != null) {
            if (ImageLoader.a()) {
                Log.e("IMAGE", "-- buildLoadData 0: " + a.getPath());
            }
            return new ModelLoader.LoadData<>(glideUrl, new PrevCacheFileDataFetcher(a));
        }
        String str = (String) options.a(ImageLoaderOptions.a);
        if (ImageLoader.a()) {
            Log.e("IMAGE", "-- buildLoadData 1: " + str);
        }
        return !TextUtils.isEmpty(str) ? new ModelLoader.LoadData<>(glideUrl, new FileDataFetcher(str)) : new ModelLoader.LoadData<>(glideUrl, new HttpDataFetcher(glideUrl));
    }

    public boolean a(GlideUrl glideUrl) {
        return true;
    }
}
