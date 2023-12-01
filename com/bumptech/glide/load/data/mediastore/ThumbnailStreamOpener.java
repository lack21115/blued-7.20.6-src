package com.bumptech.glide.load.data.mediastore;

import android.content.ContentResolver;
import android.net.Uri;
import android.text.TextUtils;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/data/mediastore/ThumbnailStreamOpener.class */
class ThumbnailStreamOpener {

    /* renamed from: a  reason: collision with root package name */
    private static final FileService f7126a = new FileService();
    private final FileService b;

    /* renamed from: c  reason: collision with root package name */
    private final ThumbnailQuery f7127c;
    private final ArrayPool d;
    private final ContentResolver e;
    private final List<ImageHeaderParser> f;

    ThumbnailStreamOpener(List<ImageHeaderParser> list, FileService fileService, ThumbnailQuery thumbnailQuery, ArrayPool arrayPool, ContentResolver contentResolver) {
        this.b = fileService;
        this.f7127c = thumbnailQuery;
        this.d = arrayPool;
        this.e = contentResolver;
        this.f = list;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ThumbnailStreamOpener(List<ImageHeaderParser> list, ThumbnailQuery thumbnailQuery, ArrayPool arrayPool, ContentResolver contentResolver) {
        this(list, f7126a, thumbnailQuery, arrayPool, contentResolver);
    }

    private boolean a(File file) {
        return this.b.a(file) && 0 < this.b.b(file);
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x0096  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String c(android.net.Uri r5) {
        /*
            r4 = this;
            r0 = 0
            r6 = r0
            r0 = r4
            com.bumptech.glide.load.data.mediastore.ThumbnailQuery r0 = r0.f7127c     // Catch: java.lang.Throwable -> L45 java.lang.SecurityException -> L49
            r1 = r5
            android.database.Cursor r0 = r0.query(r1)     // Catch: java.lang.Throwable -> L45 java.lang.SecurityException -> L49
            r7 = r0
            r0 = r7
            if (r0 == 0) goto L39
            r0 = r7
            r6 = r0
            r0 = r7
            boolean r0 = r0.moveToFirst()     // Catch: java.lang.SecurityException -> L34 java.lang.Throwable -> L91
            if (r0 == 0) goto L39
            r0 = r7
            r6 = r0
            r0 = r7
            r1 = 0
            java.lang.String r0 = r0.getString(r1)     // Catch: java.lang.SecurityException -> L34 java.lang.Throwable -> L91
            r8 = r0
            r0 = r7
            if (r0 == 0) goto L31
            r0 = r7
            r0.close()
        L31:
            r0 = r8
            return r0
        L34:
            r8 = move-exception
            goto L4d
        L39:
            r0 = r7
            if (r0 == 0) goto L43
            r0 = r7
            r0.close()
        L43:
            r0 = 0
            return r0
        L45:
            r5 = move-exception
            goto L92
        L49:
            r8 = move-exception
            r0 = 0
            r7 = r0
        L4d:
            r0 = r7
            r6 = r0
            java.lang.String r0 = "ThumbStreamOpener"
            r1 = 3
            boolean r0 = android.util.Log.isLoggable(r0, r1)     // Catch: java.lang.Throwable -> L91
            if (r0 == 0) goto L85
            r0 = r7
            r6 = r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L91
            r1 = r0
            r1.<init>()     // Catch: java.lang.Throwable -> L91
            r9 = r0
            r0 = r7
            r6 = r0
            r0 = r9
            java.lang.String r1 = "Failed to query for thumbnail for Uri: "
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch: java.lang.Throwable -> L91
            r0 = r7
            r6 = r0
            r0 = r9
            r1 = r5
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch: java.lang.Throwable -> L91
            r0 = r7
            r6 = r0
            java.lang.String r0 = "ThumbStreamOpener"
            r1 = r9
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L91
            r2 = r8
            int r0 = android.util.Log.d(r0, r1, r2)     // Catch: java.lang.Throwable -> L91
        L85:
            r0 = r7
            if (r0 == 0) goto L8f
            r0 = r7
            r0.close()
        L8f:
            r0 = 0
            return r0
        L91:
            r5 = move-exception
        L92:
            r0 = r6
            if (r0 == 0) goto L9c
            r0 = r6
            r0.close()
        L9c:
            r0 = r5
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.data.mediastore.ThumbnailStreamOpener.c(android.net.Uri):java.lang.String");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0088 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:53:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int a(android.net.Uri r5) {
        /*
            r4 = this;
            r0 = 0
            r8 = r0
            r0 = 0
            r9 = r0
            r0 = 0
            r7 = r0
            r0 = r4
            android.content.ContentResolver r0 = r0.e     // Catch: java.lang.Throwable -> L37 java.lang.NullPointerException -> L3b java.io.IOException -> L40
            r1 = r5
            java.io.InputStream r0 = r0.openInputStream(r1)     // Catch: java.lang.Throwable -> L37 java.lang.NullPointerException -> L3b java.io.IOException -> L40
            r10 = r0
            r0 = r10
            r7 = r0
            r0 = r10
            r8 = r0
            r0 = r10
            r9 = r0
            r0 = r4
            java.util.List<com.bumptech.glide.load.ImageHeaderParser> r0 = r0.f     // Catch: java.lang.Throwable -> L37 java.lang.NullPointerException -> L3b java.io.IOException -> L40
            r1 = r10
            r2 = r4
            com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool r2 = r2.d     // Catch: java.lang.Throwable -> L37 java.lang.NullPointerException -> L3b java.io.IOException -> L40
            int r0 = com.bumptech.glide.load.ImageHeaderParserUtils.a(r0, r1, r2)     // Catch: java.lang.Throwable -> L37 java.lang.NullPointerException -> L3b java.io.IOException -> L40
            r6 = r0
            r0 = r10
            if (r0 == 0) goto L35
            r0 = r10
            r0.close()     // Catch: java.io.IOException -> L99
        L35:
            r0 = r6
            return r0
        L37:
            r5 = move-exception
            goto L8f
        L3b:
            r10 = move-exception
            goto L46
        L40:
            r10 = move-exception
            r0 = r9
            r8 = r0
        L46:
            r0 = r8
            r7 = r0
            java.lang.String r0 = "ThumbStreamOpener"
            r1 = 3
            boolean r0 = android.util.Log.isLoggable(r0, r1)     // Catch: java.lang.Throwable -> L37
            if (r0 == 0) goto L83
            r0 = r8
            r7 = r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L37
            r1 = r0
            r1.<init>()     // Catch: java.lang.Throwable -> L37
            r9 = r0
            r0 = r8
            r7 = r0
            r0 = r9
            java.lang.String r1 = "Failed to open uri: "
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch: java.lang.Throwable -> L37
            r0 = r8
            r7 = r0
            r0 = r9
            r1 = r5
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch: java.lang.Throwable -> L37
            r0 = r8
            r7 = r0
            java.lang.String r0 = "ThumbStreamOpener"
            r1 = r9
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L37
            r2 = r10
            int r0 = android.util.Log.d(r0, r1, r2)     // Catch: java.lang.Throwable -> L37
        L83:
            r0 = r8
            if (r0 == 0) goto L8d
            r0 = r8
            r0.close()     // Catch: java.io.IOException -> L9c
        L8d:
            r0 = -1
            return r0
        L8f:
            r0 = r7
            if (r0 == 0) goto L97
            r0 = r7
            r0.close()     // Catch: java.io.IOException -> La0
        L97:
            r0 = r5
            throw r0
        L99:
            r5 = move-exception
            r0 = r6
            return r0
        L9c:
            r5 = move-exception
            goto L8d
        La0:
            r7 = move-exception
            goto L97
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.data.mediastore.ThumbnailStreamOpener.a(android.net.Uri):int");
    }

    public InputStream b(Uri uri) throws FileNotFoundException {
        String c2 = c(uri);
        if (TextUtils.isEmpty(c2)) {
            return null;
        }
        File a2 = this.b.a(c2);
        if (a(a2)) {
            Uri fromFile = Uri.fromFile(a2);
            try {
                return this.e.openInputStream(fromFile);
            } catch (NullPointerException e) {
                throw ((FileNotFoundException) new FileNotFoundException("NPE opening uri: " + uri + " -> " + fromFile).initCause(e));
            }
        }
        return null;
    }
}
