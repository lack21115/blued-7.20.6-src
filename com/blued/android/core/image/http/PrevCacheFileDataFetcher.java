package com.blued.android.core.image.http;

import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.utils.Log;
import java.io.File;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/image/http/PrevCacheFileDataFetcher.class */
public class PrevCacheFileDataFetcher extends FileDataFetcher {
    private File a;

    public PrevCacheFileDataFetcher(File file) {
        super(file.getPath());
        this.a = file;
    }

    @Override // com.blued.android.core.image.http.FileDataFetcher
    public void a() {
        super.a();
        File file = this.a;
        if (file == null || !file.exists()) {
            return;
        }
        if (ImageLoader.a()) {
            Log.e("IMAGE", "-- PrevCacheFileDataFetcher delete : " + this.a.getPath());
        }
        this.a.delete();
        this.a = null;
    }
}
