package com.blued.android.core.image.http;

import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.utils.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.util.ContentLengthInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/image/http/FileDataFetcher.class */
public class FileDataFetcher implements DataFetcher<InputStream> {
    private String a;
    private InputStream b;

    public FileDataFetcher(String str) {
        if (ImageLoader.a()) {
            Log.e("IMAGE", "-- FileDataFetcher :" + str);
        }
        this.a = str;
    }

    public void a() {
        if (ImageLoader.a()) {
            Log.e("IMAGE", "-- FileDataFetcher cleanup");
        }
        try {
            if (this.b != null) {
                this.b.close();
                this.b = null;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void a(Priority priority, DataFetcher.DataCallback<? super InputStream> dataCallback) {
        if (ImageLoader.a()) {
            Log.e("IMAGE", "-- FileDataFetcher loadData");
        }
        try {
            DataInputStream dataInputStream = new DataInputStream(new FileInputStream(this.a));
            this.b = ContentLengthInputStream.a(dataInputStream, dataInputStream.available());
            if (ImageLoader.a()) {
                Log.e("IMAGE", "-- FileDataFetcher loadData ++ onSuccess");
            }
            dataCallback.a(this.b);
        } catch (Exception e) {
            if (ImageLoader.a()) {
                Log.e("IMAGE", "-- FileDataFetcher loadData ++ onFailure");
            }
            dataCallback.a(e);
        }
    }

    public void b() {
        if (ImageLoader.a()) {
            Log.e("IMAGE", "-- FileDataFetcher cancel");
        }
    }

    public Class<InputStream> c() {
        return InputStream.class;
    }

    public DataSource d() {
        return DataSource.b;
    }
}
