package com.tencent.liteav.base.util;

import android.net.Uri;
import com.tencent.liteav.base.ContextUtils;
import com.tencent.liteav.base.Log;
import com.tencent.liteav.base.annotations.JNINamespace;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

@JNINamespace("liteav")
/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/base/util/UrlReader.class */
public class UrlReader {
    private static final int AVSEEK_SIZE = 65536;
    private static final int SEEK_CUR = 1;
    private static final int SEEK_END = 2;
    private static final int SEEK_SET = 0;
    private static final String TAG = "UrlReader";
    private int mFileSize;
    private long mOffset;
    private InputStream mStream;
    private Uri mUri;

    public UrlReader(String str) {
        this.mUri = Uri.parse(str);
        open();
    }

    private void open() {
        try {
            InputStream openInputStream = ContextUtils.getApplicationContext().getContentResolver().openInputStream(this.mUri);
            this.mStream = openInputStream;
            this.mFileSize = openInputStream.available();
        } catch (FileNotFoundException e) {
            Log.e(TAG, "Fail to open uri " + this.mUri.toString(), new Object[0]);
            this.mStream = null;
        } catch (IOException e2) {
            Log.e(TAG, "Fail to get file size " + e2.getMessage(), new Object[0]);
            this.mStream = null;
        }
    }

    private long seekFromBegin(long j) {
        if (j < 0) {
            return -1L;
        }
        close();
        open();
        InputStream inputStream = this.mStream;
        if (inputStream == null) {
            return -1L;
        }
        try {
            long skip = inputStream.skip(j);
            this.mOffset = skip;
            return skip;
        } catch (IOException e) {
            Log.e(TAG, "Fail to seek " + j + " exception " + e.getMessage(), new Object[0]);
            return -1L;
        }
    }

    private long seekFromCurrent(long j) {
        if (j < 0) {
            return seekFromBegin(this.mOffset + j);
        }
        try {
            long skip = this.mOffset + this.mStream.skip(j);
            this.mOffset = skip;
            return skip;
        } catch (IOException e) {
            Log.e(TAG, "Fail to seek " + j + " exception " + e.getMessage(), new Object[0]);
            return -1L;
        }
    }

    private long seekFromEnd(long j) {
        if (j > 0) {
            return -1L;
        }
        long j2 = this.mFileSize + j;
        if (j2 < 0) {
            return -1L;
        }
        long j3 = this.mOffset;
        if (j2 < j3) {
            return seekFromBegin(j2);
        }
        try {
            long skip = j3 + this.mStream.skip(j2 - j3);
            this.mOffset = skip;
            return skip;
        } catch (IOException e) {
            Log.e(TAG, "Fail to seek " + j + " exception " + e.getMessage(), new Object[0]);
            return -1L;
        }
    }

    public void close() {
        InputStream inputStream = this.mStream;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e) {
                Log.e(TAG, "Close exception " + e.getMessage(), new Object[0]);
            }
        }
        this.mStream = null;
        this.mOffset = 0L;
        this.mFileSize = 0;
    }

    public int read(byte[] bArr, int i) {
        InputStream inputStream = this.mStream;
        int i2 = -1;
        if (inputStream == null) {
            return -1;
        }
        try {
            int read = inputStream.read(bArr, 0, i);
            i2 = read;
            this.mOffset += read;
            return read;
        } catch (IOException e) {
            Log.e(TAG, "Read exception " + e.getMessage(), new Object[0]);
            return i2;
        }
    }

    public long seek(long j, int i) {
        if (this.mStream == null) {
            return -1L;
        }
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 65536) {
                        return -1L;
                    }
                    return this.mFileSize;
                }
                return seekFromEnd(j);
            }
            return seekFromCurrent(j);
        }
        return seekFromBegin(j);
    }
}
