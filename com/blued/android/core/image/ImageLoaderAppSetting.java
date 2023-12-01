package com.blued.android.core.image;

import android.content.Context;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.util.FileUtils;
import com.blued.android.core.imagecache.RecyclingUtils;
import com.blued.android.core.utils.Log;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool;
import com.bumptech.glide.load.engine.cache.DiskLruCacheFactory;
import com.bumptech.glide.load.engine.cache.LruResourceCache;
import com.bumptech.glide.module.AppGlideModule;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/image/ImageLoaderAppSetting.class */
public class ImageLoaderAppSetting extends AppGlideModule {
    @Override // com.bumptech.glide.module.AppGlideModule, com.bumptech.glide.module.AppliesOptions
    public void a(Context context, GlideBuilder glideBuilder) {
        if (ImageLoader.a()) {
            Log.e("IMAGE", "ImageLoaderAppSetting -- applyDefaultOptions");
        }
        long a2 = RecyclingUtils.a(AppInfo.t);
        glideBuilder.a(new LruResourceCache((2 * a2) / 5));
        glideBuilder.a(new LruBitmapPool((a2 * 3) / 5));
        glideBuilder.a(new DiskLruCacheFactory(FileUtils.a(context), AppInfo.u));
        glideBuilder.a(AppInfo.m() ? 2 : 6);
    }
}
