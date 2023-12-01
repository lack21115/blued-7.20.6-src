package com.kwad.sdk.core.imageloader.cache.disc.impl;

import android.graphics.Bitmap;
import com.kwad.sdk.core.imageloader.cache.disc.DiskCache;
import com.kwad.sdk.core.imageloader.cache.disc.naming.FileNameGenerator;
import com.kwad.sdk.core.imageloader.core.DefaultConfigurationFactory;
import com.kwad.sdk.core.imageloader.utils.IoUtils;
import com.kwad.sdk.crash.utils.b;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/imageloader/cache/disc/impl/BaseDiskCache.class */
public abstract class BaseDiskCache implements DiskCache {
    public static final int DEFAULT_BUFFER_SIZE = 32768;
    public static final Bitmap.CompressFormat DEFAULT_COMPRESS_FORMAT = Bitmap.CompressFormat.PNG;
    public static final int DEFAULT_COMPRESS_QUALITY = 100;
    private static final String ERROR_ARG_NULL = " argument must be not null";
    private static final String TEMP_IMAGE_POSTFIX = ".tmp";
    protected int bufferSize;
    protected final File cacheDir;
    protected Bitmap.CompressFormat compressFormat;
    protected int compressQuality;
    protected final FileNameGenerator fileNameGenerator;
    protected final File reserveCacheDir;

    public BaseDiskCache(File file) {
        this(file, null);
    }

    public BaseDiskCache(File file, File file2) {
        this(file, file2, DefaultConfigurationFactory.createFileNameGenerator());
    }

    public BaseDiskCache(File file, File file2, FileNameGenerator fileNameGenerator) {
        this.bufferSize = 32768;
        this.compressFormat = DEFAULT_COMPRESS_FORMAT;
        this.compressQuality = 100;
        if (file == null) {
            throw new IllegalArgumentException("cacheDir argument must be not null");
        }
        if (fileNameGenerator == null) {
            throw new IllegalArgumentException("fileNameGenerator argument must be not null");
        }
        this.cacheDir = file;
        this.reserveCacheDir = file2;
        this.fileNameGenerator = fileNameGenerator;
    }

    @Override // com.kwad.sdk.core.imageloader.cache.disc.DiskCache
    public void clear() {
        File[] listFiles = this.cacheDir.listFiles();
        if (listFiles == null) {
            return;
        }
        int length = listFiles.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            listFiles[i2].delete();
            i = i2 + 1;
        }
    }

    @Override // com.kwad.sdk.core.imageloader.cache.disc.DiskCache
    public void close() {
    }

    @Override // com.kwad.sdk.core.imageloader.cache.disc.DiskCache
    public File get(String str) {
        return getFile(str);
    }

    @Override // com.kwad.sdk.core.imageloader.cache.disc.DiskCache
    public File getDirectory() {
        return this.cacheDir;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0043, code lost:
        if (r5.reserveCacheDir.mkdirs() != false) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.io.File getFile(java.lang.String r6) {
        /*
            r5 = this;
            r0 = r5
            com.kwad.sdk.core.imageloader.cache.disc.naming.FileNameGenerator r0 = r0.fileNameGenerator
            r1 = r6
            java.lang.String r0 = r0.generate(r1)
            r8 = r0
            r0 = r5
            java.io.File r0 = r0.cacheDir
            r7 = r0
            r0 = r7
            r6 = r0
            r0 = r7
            boolean r0 = r0.exists()
            if (r0 != 0) goto L4b
            r0 = r7
            r6 = r0
            r0 = r5
            java.io.File r0 = r0.cacheDir
            boolean r0 = r0.mkdirs()
            if (r0 != 0) goto L4b
            r0 = r5
            java.io.File r0 = r0.reserveCacheDir
            r9 = r0
            r0 = r7
            r6 = r0
            r0 = r9
            if (r0 == 0) goto L4b
            r0 = r9
            boolean r0 = r0.exists()
            if (r0 != 0) goto L46
            r0 = r7
            r6 = r0
            r0 = r5
            java.io.File r0 = r0.reserveCacheDir
            boolean r0 = r0.mkdirs()
            if (r0 == 0) goto L4b
        L46:
            r0 = r5
            java.io.File r0 = r0.reserveCacheDir
            r6 = r0
        L4b:
            java.io.File r0 = new java.io.File
            r1 = r0
            r2 = r6
            r3 = r8
            r1.<init>(r2, r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.core.imageloader.cache.disc.impl.BaseDiskCache.getFile(java.lang.String):java.io.File");
    }

    @Override // com.kwad.sdk.core.imageloader.cache.disc.DiskCache
    public boolean remove(String str) {
        return getFile(str).delete();
    }

    @Override // com.kwad.sdk.core.imageloader.cache.disc.DiskCache
    public boolean save(String str, Bitmap bitmap) {
        File file = getFile(str);
        File file2 = new File(file.getAbsolutePath() + ".tmp");
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file2), this.bufferSize);
        try {
            boolean compress = bitmap.compress(this.compressFormat, this.compressQuality, bufferedOutputStream);
            b.closeQuietly(bufferedOutputStream);
            boolean z = compress;
            if (compress) {
                z = compress;
                if (!file2.renameTo(file)) {
                    z = false;
                }
            }
            if (!z) {
                file2.delete();
            }
            bitmap.recycle();
            return z;
        } catch (Throwable th) {
            b.closeQuietly(bufferedOutputStream);
            file2.delete();
            throw th;
        }
    }

    @Override // com.kwad.sdk.core.imageloader.cache.disc.DiskCache
    public boolean save(String str, InputStream inputStream, IoUtils.CopyListener copyListener) {
        boolean z;
        File file = getFile(str);
        File file2 = new File(file.getAbsolutePath() + ".tmp");
        try {
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file2), this.bufferSize);
            z = IoUtils.copyStream(inputStream, bufferedOutputStream, copyListener, this.bufferSize);
            try {
                b.closeQuietly(bufferedOutputStream);
                if (z && !file2.renameTo(file)) {
                    z = false;
                }
                if (!z) {
                    file2.delete();
                }
                return z;
            } catch (Throwable th) {
                th = th;
                if (z && !file2.renameTo(file)) {
                    z = false;
                }
                if (!z) {
                    file2.delete();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            z = false;
        }
    }

    public void setBufferSize(int i) {
        this.bufferSize = i;
    }

    public void setCompressFormat(Bitmap.CompressFormat compressFormat) {
        this.compressFormat = compressFormat;
    }

    public void setCompressQuality(int i) {
        this.compressQuality = i;
    }
}
