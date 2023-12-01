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
        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public ModelLoader<GlideUrl, InputStream> a(MultiModelLoaderFactory multiModelLoaderFactory) {
            if (ImageLoader.a()) {
                Log.e("IMAGE", "-- new HttpModelLoader ");
            }
            return new HttpModelLoader();
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public void a() {
        }
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public ModelLoader.LoadData<InputStream> a(GlideUrl glideUrl, int i, int i2, Options options) {
        String b = glideUrl.b();
        if (ImageLoader.a()) {
            Log.e("IMAGE", "-- buildLoadData : " + b);
        }
        File a2 = FileUtils.a(b);
        if (a2 != null) {
            if (ImageLoader.a()) {
                Log.e("IMAGE", "-- buildLoadData 0: " + a2.getPath());
            }
            return new ModelLoader.LoadData<>(glideUrl, new PrevCacheFileDataFetcher(a2));
        }
        String str = (String) options.a(ImageLoaderOptions.f9505a);
        if (ImageLoader.a()) {
            Log.e("IMAGE", "-- buildLoadData 1: " + str);
        }
        return !TextUtils.isEmpty(str) ? new ModelLoader.LoadData<>(glideUrl, new FileDataFetcher(str)) : new ModelLoader.LoadData<>(glideUrl, new HttpDataFetcher(glideUrl));
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public boolean a(GlideUrl glideUrl) {
        return true;
    }
}
