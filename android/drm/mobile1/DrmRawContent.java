package android.drm.mobile1;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: source-9557208-dex2jar.jar:android/drm/mobile1/DrmRawContent.class */
public class DrmRawContent {
    public static final int DRM_COMBINED_DELIVERY = 2;
    public static final int DRM_FORWARD_LOCK = 1;
    private static final int DRM_MIMETYPE_CONTENT = 2;
    public static final String DRM_MIMETYPE_CONTENT_STRING = "application/vnd.oma.drm.content";
    private static final int DRM_MIMETYPE_MESSAGE = 1;
    public static final String DRM_MIMETYPE_MESSAGE_STRING = "application/vnd.oma.drm.message";
    public static final int DRM_SEPARATE_DELIVERY = 3;
    public static final int DRM_SEPARATE_DELIVERY_DM = 4;
    public static final int DRM_UNKNOWN_DATA_LEN = -1;
    private static final int JNI_DRM_EOF = -2;
    private static final int JNI_DRM_FAILURE = -1;
    private static final int JNI_DRM_SUCCESS = 0;
    private static final int JNI_DRM_UNKNOWN_DATA_LEN = -3;
    private int id;
    private BufferedInputStream inData;
    private int inDataLen;
    private String mediaType;
    private int rawType;
    private String rightsIssuer;

    /* loaded from: source-9557208-dex2jar.jar:android/drm/mobile1/DrmRawContent$DrmInputStream.class */
    class DrmInputStream extends InputStream {
        private boolean isClosed = false;
        private int offset = 0;
        private byte[] b = new byte[1];

        public DrmInputStream(DrmRights drmRights) {
        }

        @Override // java.io.InputStream
        public int available() throws IOException {
            int i;
            int nativeGetContentLength = DrmRawContent.this.nativeGetContentLength();
            if (-1 == nativeGetContentLength) {
                throw new IOException();
            }
            if (-3 == nativeGetContentLength) {
                i = 0;
            } else {
                int i2 = nativeGetContentLength - this.offset;
                i = i2;
                if (i2 < 0) {
                    throw new IOException();
                }
            }
            return i;
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.isClosed = true;
        }

        @Override // java.io.InputStream
        public void mark(int i) {
        }

        @Override // java.io.InputStream
        public boolean markSupported() {
            return false;
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            if (-1 == read(this.b, 0, 1)) {
                return -1;
            }
            return this.b[0] & 255;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr) throws IOException {
            return read(bArr, 0, bArr.length);
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i, int i2) throws IOException {
            int i3;
            if (bArr == null) {
                throw new NullPointerException();
            }
            if (i < 0 || i2 < 0 || i + i2 > bArr.length) {
                throw new IndexOutOfBoundsException();
            }
            if (true == this.isClosed) {
                throw new IOException();
            }
            if (i2 == 0) {
                i3 = 0;
            } else {
                int nativeReadContent = DrmRawContent.this.nativeReadContent(bArr, i, i2, this.offset);
                if (-1 == nativeReadContent) {
                    throw new IOException();
                }
                i3 = -1;
                if (-2 != nativeReadContent) {
                    this.offset += nativeReadContent;
                    return nativeReadContent;
                }
            }
            return i3;
        }

        @Override // java.io.InputStream
        public void reset() throws IOException {
            throw new IOException();
        }

        @Override // java.io.InputStream
        public long skip(long j) throws IOException {
            return 0L;
        }
    }

    static {
        try {
            System.loadLibrary("drm1_jni");
        } catch (UnsatisfiedLinkError e) {
            System.err.println("WARNING: Could not load libdrm1_jni.so");
        }
    }

    public DrmRawContent(InputStream inputStream, int i, String str) throws DrmException, IOException {
        int i2;
        this.id = -1;
        this.inData = new BufferedInputStream(inputStream, 1024);
        this.inDataLen = i;
        if ("application/vnd.oma.drm.message".equals(str)) {
            i2 = 1;
        } else if (!"application/vnd.oma.drm.content".equals(str)) {
            throw new IllegalArgumentException("mimeType must be DRM_MIMETYPE_MESSAGE or DRM_MIMETYPE_CONTENT");
        } else {
            i2 = 2;
        }
        if (i <= 0) {
            throw new IllegalArgumentException("len must be > 0");
        }
        this.id = nativeConstructDrmContent(this.inData, this.inDataLen, i2);
        if (-1 == this.id) {
            throw new DrmException("nativeConstructDrmContent() returned JNI_DRM_FAILURE");
        }
        this.rightsIssuer = nativeGetRightsAddress();
        this.rawType = nativeGetDeliveryMethod();
        if (-1 == this.rawType) {
            throw new DrmException("nativeGetDeliveryMethod() returned JNI_DRM_FAILURE");
        }
        this.mediaType = nativeGetContentType();
        if (this.mediaType == null) {
            throw new DrmException("nativeGetContentType() returned null");
        }
    }

    private native int nativeConstructDrmContent(InputStream inputStream, int i, int i2);

    /* JADX INFO: Access modifiers changed from: private */
    public native int nativeGetContentLength();

    private native String nativeGetContentType();

    private native int nativeGetDeliveryMethod();

    private native String nativeGetRightsAddress();

    /* JADX INFO: Access modifiers changed from: private */
    public native int nativeReadContent(byte[] bArr, int i, int i2, int i3);

    protected native void finalize();

    public InputStream getContentInputStream(DrmRights drmRights) {
        if (drmRights == null) {
            throw new NullPointerException();
        }
        return new DrmInputStream(drmRights);
    }

    public int getContentLength(DrmRights drmRights) throws DrmException {
        if (drmRights == null) {
            throw new NullPointerException();
        }
        int nativeGetContentLength = nativeGetContentLength();
        if (-1 == nativeGetContentLength) {
            throw new DrmException("nativeGetContentLength() returned JNI_DRM_FAILURE");
        }
        int i = nativeGetContentLength;
        if (-3 == nativeGetContentLength) {
            i = -1;
        }
        return i;
    }

    public String getContentType() {
        return this.mediaType;
    }

    public int getRawType() {
        return this.rawType;
    }

    public String getRightsAddress() {
        return this.rightsIssuer;
    }
}
