package com.bumptech.glide.load.data.mediastore;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;
import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.data.ExifOrientationStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/data/mediastore/ThumbFetcher.class */
public class ThumbFetcher implements DataFetcher<InputStream> {

    /* renamed from: a  reason: collision with root package name */
    private final Uri f7122a;
    private final ThumbnailStreamOpener b;

    /* renamed from: c  reason: collision with root package name */
    private InputStream f7123c;

    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/data/mediastore/ThumbFetcher$ImageThumbnailQuery.class */
    static class ImageThumbnailQuery implements ThumbnailQuery {
        private static final String[] b = {"_data"};

        /* renamed from: a  reason: collision with root package name */
        private final ContentResolver f7124a;

        ImageThumbnailQuery(ContentResolver contentResolver) {
            this.f7124a = contentResolver;
        }

        @Override // com.bumptech.glide.load.data.mediastore.ThumbnailQuery
        public Cursor query(Uri uri) {
            return this.f7124a.query(MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI, b, "kind = 1 AND image_id = ?", new String[]{uri.getLastPathSegment()}, null);
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/data/mediastore/ThumbFetcher$VideoThumbnailQuery.class */
    static class VideoThumbnailQuery implements ThumbnailQuery {
        private static final String[] b = {"_data"};

        /* renamed from: a  reason: collision with root package name */
        private final ContentResolver f7125a;

        VideoThumbnailQuery(ContentResolver contentResolver) {
            this.f7125a = contentResolver;
        }

        @Override // com.bumptech.glide.load.data.mediastore.ThumbnailQuery
        public Cursor query(Uri uri) {
            return this.f7125a.query(MediaStore.Video.Thumbnails.EXTERNAL_CONTENT_URI, b, "kind = 1 AND video_id = ?", new String[]{uri.getLastPathSegment()}, null);
        }
    }

    ThumbFetcher(Uri uri, ThumbnailStreamOpener thumbnailStreamOpener) {
        this.f7122a = uri;
        this.b = thumbnailStreamOpener;
    }

    public static ThumbFetcher a(Context context, Uri uri) {
        return a(context, uri, new ImageThumbnailQuery(context.getContentResolver()));
    }

    private static ThumbFetcher a(Context context, Uri uri, ThumbnailQuery thumbnailQuery) {
        return new ThumbFetcher(uri, new ThumbnailStreamOpener(Glide.a(context).h().a(), thumbnailQuery, Glide.a(context).b(), context.getContentResolver()));
    }

    public static ThumbFetcher b(Context context, Uri uri) {
        return a(context, uri, new VideoThumbnailQuery(context.getContentResolver()));
    }

    private InputStream e() throws FileNotFoundException {
        InputStream b = this.b.b(this.f7122a);
        int a2 = b != null ? this.b.a(this.f7122a) : -1;
        ExifOrientationStream exifOrientationStream = b;
        if (a2 != -1) {
            exifOrientationStream = new ExifOrientationStream(b, a2);
        }
        return exifOrientationStream;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void a() {
        InputStream inputStream = this.f7123c;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e) {
            }
        }
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void a(Priority priority, DataFetcher.DataCallback<? super InputStream> dataCallback) {
        try {
            InputStream e = e();
            this.f7123c = e;
            dataCallback.a((DataFetcher.DataCallback<? super InputStream>) e);
        } catch (FileNotFoundException e2) {
            if (Log.isLoggable("MediaStoreThumbFetcher", 3)) {
                Log.d("MediaStoreThumbFetcher", "Failed to find thumbnail file", e2);
            }
            dataCallback.a((Exception) e2);
        }
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void b() {
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public Class<InputStream> c() {
        return InputStream.class;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public DataSource d() {
        return DataSource.LOCAL;
    }
}
