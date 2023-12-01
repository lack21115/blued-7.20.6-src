package com.bumptech.glide.load.model.stream;

import android.content.Context;
import android.net.Uri;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.mediastore.MediaStoreUtil;
import com.bumptech.glide.load.data.mediastore.ThumbFetcher;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.MultiModelLoaderFactory;
import com.bumptech.glide.load.resource.bitmap.VideoDecoder;
import com.bumptech.glide.signature.ObjectKey;
import java.io.InputStream;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/model/stream/MediaStoreVideoThumbLoader.class */
public class MediaStoreVideoThumbLoader implements ModelLoader<Uri, InputStream> {

    /* renamed from: a  reason: collision with root package name */
    private final Context f7316a;

    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/model/stream/MediaStoreVideoThumbLoader$Factory.class */
    public static class Factory implements ModelLoaderFactory<Uri, InputStream> {

        /* renamed from: a  reason: collision with root package name */
        private final Context f7317a;

        public Factory(Context context) {
            this.f7317a = context;
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public ModelLoader<Uri, InputStream> a(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new MediaStoreVideoThumbLoader(this.f7317a);
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public void a() {
        }
    }

    public MediaStoreVideoThumbLoader(Context context) {
        this.f7316a = context.getApplicationContext();
    }

    private boolean a(Options options) {
        Long l = (Long) options.a(VideoDecoder.f7372a);
        return l != null && l.longValue() == -1;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public ModelLoader.LoadData<InputStream> a(Uri uri, int i, int i2, Options options) {
        if (MediaStoreUtil.a(i, i2) && a(options)) {
            return new ModelLoader.LoadData<>(new ObjectKey(uri), ThumbFetcher.b(this.f7316a, uri));
        }
        return null;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public boolean a(Uri uri) {
        return MediaStoreUtil.b(uri);
    }
}
