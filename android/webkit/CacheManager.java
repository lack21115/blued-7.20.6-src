package android.webkit;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

@Deprecated
/* loaded from: source-4181928-dex2jar.jar:android/webkit/CacheManager.class */
public final class CacheManager {
    static final /* synthetic */ boolean $assertionsDisabled;

    @Deprecated
    /* loaded from: source-4181928-dex2jar.jar:android/webkit/CacheManager$CacheResult.class */
    public static class CacheResult {
        long contentLength;
        String contentdisposition;
        String crossDomain;
        String encoding;
        String etag;
        long expires;
        String expiresString;
        int httpStatusCode;
        InputStream inStream;
        String lastModified;
        String localPath;
        String location;
        String mimeType;
        File outFile;
        OutputStream outStream;

        public String getContentDisposition() {
            return this.contentdisposition;
        }

        public long getContentLength() {
            return this.contentLength;
        }

        public String getETag() {
            return this.etag;
        }

        public String getEncoding() {
            return this.encoding;
        }

        public long getExpires() {
            return this.expires;
        }

        public String getExpiresString() {
            return this.expiresString;
        }

        public int getHttpStatusCode() {
            return this.httpStatusCode;
        }

        public InputStream getInputStream() {
            return this.inStream;
        }

        public String getLastModified() {
            return this.lastModified;
        }

        public String getLocalPath() {
            return this.localPath;
        }

        public String getLocation() {
            return this.location;
        }

        public String getMimeType() {
            return this.mimeType;
        }

        public OutputStream getOutputStream() {
            return this.outStream;
        }

        public void setContentLength(long j) {
            this.contentLength = j;
        }

        public void setEncoding(String str) {
            this.encoding = str;
        }

        public void setInputStream(InputStream inputStream) {
            this.inStream = inputStream;
        }
    }

    static {
        $assertionsDisabled = !CacheManager.class.desiredAssertionStatus();
    }

    @Deprecated
    public static boolean cacheDisabled() {
        return false;
    }

    @Deprecated
    public static boolean endCacheTransaction() {
        return false;
    }

    @Deprecated
    public static CacheResult getCacheFile(String str, Map<String, String> map) {
        return null;
    }

    @Deprecated
    public static File getCacheFileBaseDir() {
        return null;
    }

    static void saveCacheFile(String str, long j, CacheResult cacheResult) {
        try {
            cacheResult.outStream.close();
            if (!$assertionsDisabled) {
                throw new AssertionError();
            }
        } catch (IOException e) {
        }
    }

    @Deprecated
    public static void saveCacheFile(String str, CacheResult cacheResult) {
        saveCacheFile(str, 0L, cacheResult);
    }

    @Deprecated
    public static boolean startCacheTransaction() {
        return false;
    }
}
