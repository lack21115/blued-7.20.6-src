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

    /* renamed from: a  reason: collision with root package name */
    private String f9553a;
    private InputStream b;

    public FileDataFetcher(String str) {
        if (ImageLoader.a()) {
            Log.e("IMAGE", "-- FileDataFetcher :" + str);
        }
        this.f9553a = str;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
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

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void a(Priority priority, DataFetcher.DataCallback<? super InputStream> dataCallback) {
        if (ImageLoader.a()) {
            Log.e("IMAGE", "-- FileDataFetcher loadData");
        }
        try {
            DataInputStream dataInputStream = new DataInputStream(new FileInputStream(this.f9553a));
            this.b = ContentLengthInputStream.a(dataInputStream, dataInputStream.available());
            if (ImageLoader.a()) {
                Log.e("IMAGE", "-- FileDataFetcher loadData ++ onSuccess");
            }
            dataCallback.a((DataFetcher.DataCallback<? super InputStream>) this.b);
        } catch (Exception e) {
            if (ImageLoader.a()) {
                Log.e("IMAGE", "-- FileDataFetcher loadData ++ onFailure");
            }
            dataCallback.a(e);
        }
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void b() {
        if (ImageLoader.a()) {
            Log.e("IMAGE", "-- FileDataFetcher cancel");
        }
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public Class<InputStream> c() {
        return InputStream.class;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public DataSource d() {
        return DataSource.REMOTE;
    }
}
