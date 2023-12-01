package com.blued.android.core.image.http;

import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.utils.Log;
import java.io.File;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/image/http/PrevCacheFileDataFetcher.class */
public class PrevCacheFileDataFetcher extends FileDataFetcher {

    /* renamed from: a  reason: collision with root package name */
    private File f9562a;

    public PrevCacheFileDataFetcher(File file) {
        super(file.getPath());
        this.f9562a = file;
    }

    @Override // com.blued.android.core.image.http.FileDataFetcher, com.bumptech.glide.load.data.DataFetcher
    public void a() {
        super.a();
        File file = this.f9562a;
        if (file == null || !file.exists()) {
            return;
        }
        if (ImageLoader.a()) {
            Log.e("IMAGE", "-- PrevCacheFileDataFetcher delete : " + this.f9562a.getPath());
        }
        this.f9562a.delete();
        this.f9562a = null;
    }
}
