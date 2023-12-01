package java.net;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.AllPermission;
import java.security.Permission;
import java.util.Collections;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.apache.commons.codec.CharEncoding;

/* loaded from: source-2895416-dex2jar.jar:java/net/URLConnection.class */
public abstract class URLConnection {
    private static ContentHandlerFactory contentHandlerFactory;
    private static boolean defaultAllowUserInteraction;
    private static FileNameMap fileNameMap;
    protected boolean connected;
    private String contentType;
    protected boolean doOutput;
    protected long ifModifiedSince;
    protected URL url;
    private static boolean defaultUseCaches = true;
    static Hashtable<String, Object> contentHandlers = new Hashtable<>();
    ContentHandler defaultHandler = new DefaultContentHandler();
    private long lastModified = -1;
    protected boolean useCaches = defaultUseCaches;
    protected boolean doInput = true;
    protected boolean allowUserInteraction = defaultAllowUserInteraction;
    private int readTimeout = 0;
    private int connectTimeout = 0;

    /* loaded from: source-2895416-dex2jar.jar:java/net/URLConnection$DefaultContentHandler.class */
    static class DefaultContentHandler extends ContentHandler {
        DefaultContentHandler() {
        }

        @Override // java.net.ContentHandler
        public Object getContent(URLConnection uRLConnection) throws IOException {
            return uRLConnection.getInputStream();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public URLConnection(URL url) {
        this.url = url;
    }

    private void checkNotConnected() {
        if (this.connected) {
            throw new IllegalStateException("Already connected");
        }
    }

    private ContentHandler getContentHandler(String str) throws IOException {
        String[] split;
        Object obj;
        String parseTypeString = parseTypeString(str.replace('/', '.'));
        Object obj2 = contentHandlers.get(str);
        if (obj2 != null) {
            return (ContentHandler) obj2;
        }
        if (contentHandlerFactory != null) {
            ContentHandler createContentHandler = contentHandlerFactory.createContentHandler(str);
            contentHandlers.put(str, createContentHandler);
            return createContentHandler;
        }
        String property = System.getProperty("java.content.handler.pkgs");
        Object obj3 = obj2;
        if (property != null) {
            int length = property.split("\\|").length;
            int i = 0;
            while (true) {
                obj3 = obj2;
                if (i >= length) {
                    break;
                }
                try {
                    obj = Class.forName(split[i] + "." + parseTypeString, true, ClassLoader.getSystemClassLoader()).newInstance();
                } catch (ClassNotFoundException e) {
                    obj = obj2;
                } catch (IllegalAccessException e2) {
                    obj = obj2;
                } catch (InstantiationException e3) {
                    obj = obj2;
                }
                i++;
                obj2 = obj;
            }
        }
        Object obj4 = obj3;
        if (obj3 == null) {
            try {
                obj4 = Class.forName("org.apache.harmony.awt.www.content." + parseTypeString).newInstance();
            } catch (ClassNotFoundException e4) {
                obj4 = obj3;
            } catch (IllegalAccessException e5) {
                obj4 = obj3;
            } catch (InstantiationException e6) {
                obj4 = obj3;
            }
        }
        if (obj4 != null) {
            if (obj4 instanceof ContentHandler) {
                contentHandlers.put(str, obj4);
                return (ContentHandler) obj4;
            }
            throw new UnknownServiceException();
        }
        return this.defaultHandler;
    }

    public static boolean getDefaultAllowUserInteraction() {
        return defaultAllowUserInteraction;
    }

    @Deprecated
    public static String getDefaultRequestProperty(String str) {
        return null;
    }

    public static FileNameMap getFileNameMap() {
        FileNameMap fileNameMap2;
        synchronized (URLConnection.class) {
            try {
                if (fileNameMap == null) {
                    fileNameMap = new DefaultFileNameMap();
                }
                fileNameMap2 = fileNameMap;
            } catch (Throwable th) {
                throw th;
            }
        }
        return fileNameMap2;
    }

    public static String guessContentTypeFromName(String str) {
        return getFileNameMap().getContentTypeFor(str);
    }

    public static String guessContentTypeFromStream(InputStream inputStream) throws IOException {
        if (inputStream.markSupported()) {
            inputStream.mark(64);
            byte[] bArr = new byte[64];
            int read = inputStream.read(bArr);
            inputStream.reset();
            if (read == -1) {
                return null;
            }
            int i = 0;
            String str = "US-ASCII";
            int i2 = read;
            if (read > 1) {
                String str2 = "US-ASCII";
                int i3 = read;
                int i4 = 0;
                if (bArr[0] == -1) {
                    str2 = "US-ASCII";
                    i3 = read;
                    i4 = 0;
                    if (bArr[1] == -2) {
                        str2 = CharEncoding.UTF_16LE;
                        i4 = 2;
                        i3 = read - (read & 1);
                    }
                }
                String str3 = str2;
                int i5 = i3;
                int i6 = i4;
                if (bArr[0] == -2) {
                    str3 = str2;
                    i5 = i3;
                    i6 = i4;
                    if (bArr[1] == -1) {
                        str3 = CharEncoding.UTF_16BE;
                        i6 = 2;
                        i5 = i3 - (i3 & 1);
                    }
                }
                str = str3;
                i2 = i5;
                i = i6;
                if (i5 > 2) {
                    String str4 = str3;
                    int i7 = i6;
                    if (bArr[0] == -17) {
                        str4 = str3;
                        i7 = i6;
                        if (bArr[1] == -69) {
                            str4 = str3;
                            i7 = i6;
                            if (bArr[2] == -65) {
                                str4 = "UTF-8";
                                i7 = 3;
                            }
                        }
                    }
                    str = str4;
                    i2 = i5;
                    i = i7;
                    if (i5 > 3) {
                        String str5 = str4;
                        int i8 = i5;
                        int i9 = i7;
                        if (bArr[0] == 0) {
                            str5 = str4;
                            i8 = i5;
                            i9 = i7;
                            if (bArr[1] == 0) {
                                str5 = str4;
                                i8 = i5;
                                i9 = i7;
                                if (bArr[2] == -2) {
                                    str5 = str4;
                                    i8 = i5;
                                    i9 = i7;
                                    if (bArr[3] == -1) {
                                        str5 = "UTF-32BE";
                                        i9 = 4;
                                        i8 = i5 - (i5 & 3);
                                    }
                                }
                            }
                        }
                        str = str5;
                        i2 = i8;
                        i = i9;
                        if (bArr[0] == -1) {
                            str = str5;
                            i2 = i8;
                            i = i9;
                            if (bArr[1] == -2) {
                                str = str5;
                                i2 = i8;
                                i = i9;
                                if (bArr[2] == 0) {
                                    str = str5;
                                    i2 = i8;
                                    i = i9;
                                    if (bArr[3] == 0) {
                                        str = "UTF-32LE";
                                        i = 4;
                                        i2 = i8 - (i8 & 3);
                                    }
                                }
                            }
                        }
                    }
                }
            }
            String str6 = new String(bArr, i, i2 - i, str);
            if (str6.startsWith("PK")) {
                return "application/zip";
            }
            if (str6.startsWith("GI")) {
                return "image/gif";
            }
            String upperCase = str6.trim().toUpperCase(Locale.US);
            if (upperCase.startsWith("<!DOCTYPE HTML") || upperCase.startsWith("<HTML") || upperCase.startsWith("<HEAD") || upperCase.startsWith("<BODY") || upperCase.startsWith("<HEAD")) {
                return "text/html";
            }
            if (upperCase.startsWith("<?XML")) {
                return "application/xml";
            }
            return null;
        }
        return null;
    }

    private String parseTypeString(String str) {
        StringBuilder sb = new StringBuilder(str);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= sb.length()) {
                return sb.toString();
            }
            char charAt = sb.charAt(i2);
            if (!Character.isLetter(charAt) && !Character.isDigit(charAt) && charAt != '.') {
                sb.setCharAt(i2, '_');
            }
            i = i2 + 1;
        }
    }

    public static void setContentHandlerFactory(ContentHandlerFactory contentHandlerFactory2) {
        synchronized (URLConnection.class) {
            try {
                if (contentHandlerFactory != null) {
                    throw new Error("Factory already set");
                }
                contentHandlerFactory = contentHandlerFactory2;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void setDefaultAllowUserInteraction(boolean z) {
        defaultAllowUserInteraction = z;
    }

    @Deprecated
    public static void setDefaultRequestProperty(String str, String str2) {
    }

    public static void setFileNameMap(FileNameMap fileNameMap2) {
        synchronized (URLConnection.class) {
            try {
                fileNameMap = fileNameMap2;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void addRequestProperty(String str, String str2) {
        checkNotConnected();
        if (str == null) {
            throw new NullPointerException("field == null");
        }
    }

    public abstract void connect() throws IOException;

    public boolean getAllowUserInteraction() {
        return this.allowUserInteraction;
    }

    public int getConnectTimeout() {
        return this.connectTimeout;
    }

    public Object getContent() throws IOException {
        if (!this.connected) {
            connect();
        }
        String contentType = getContentType();
        this.contentType = contentType;
        if (contentType == null) {
            String guessContentTypeFromName = guessContentTypeFromName(this.url.getFile());
            this.contentType = guessContentTypeFromName;
            if (guessContentTypeFromName == null) {
                this.contentType = guessContentTypeFromStream(getInputStream());
            }
        }
        if (this.contentType != null) {
            return getContentHandler(this.contentType).getContent(this);
        }
        return null;
    }

    public Object getContent(Class[] clsArr) throws IOException {
        if (!this.connected) {
            connect();
        }
        String contentType = getContentType();
        this.contentType = contentType;
        if (contentType == null) {
            String guessContentTypeFromName = guessContentTypeFromName(this.url.getFile());
            this.contentType = guessContentTypeFromName;
            if (guessContentTypeFromName == null) {
                this.contentType = guessContentTypeFromStream(getInputStream());
            }
        }
        if (this.contentType != null) {
            return getContentHandler(this.contentType).getContent(this, clsArr);
        }
        return null;
    }

    public String getContentEncoding() {
        return getHeaderField("Content-Encoding");
    }

    public int getContentLength() {
        return getHeaderFieldInt("Content-Length", -1);
    }

    public String getContentType() {
        return getHeaderField("Content-Type");
    }

    public long getDate() {
        return getHeaderFieldDate("Date", 0L);
    }

    public boolean getDefaultUseCaches() {
        return defaultUseCaches;
    }

    public boolean getDoInput() {
        return this.doInput;
    }

    public boolean getDoOutput() {
        return this.doOutput;
    }

    public long getExpiration() {
        return getHeaderFieldDate("Expires", 0L);
    }

    public String getHeaderField(int i) {
        return null;
    }

    public String getHeaderField(String str) {
        return null;
    }

    public long getHeaderFieldDate(String str, long j) {
        String headerField = getHeaderField(str);
        if (headerField == null) {
            return j;
        }
        try {
            return Date.parse(headerField);
        } catch (Exception e) {
            return j;
        }
    }

    public int getHeaderFieldInt(String str, int i) {
        try {
            return Integer.parseInt(getHeaderField(str));
        } catch (NumberFormatException e) {
            return i;
        }
    }

    public String getHeaderFieldKey(int i) {
        return null;
    }

    public Map<String, List<String>> getHeaderFields() {
        return Collections.emptyMap();
    }

    public long getIfModifiedSince() {
        return this.ifModifiedSince;
    }

    public InputStream getInputStream() throws IOException {
        throw new UnknownServiceException("Does not support writing to the input stream");
    }

    public long getLastModified() {
        if (this.lastModified != -1) {
            return this.lastModified;
        }
        long headerFieldDate = getHeaderFieldDate("Last-Modified", 0L);
        this.lastModified = headerFieldDate;
        return headerFieldDate;
    }

    public OutputStream getOutputStream() throws IOException {
        throw new UnknownServiceException("Does not support writing to the output stream");
    }

    public Permission getPermission() throws IOException {
        return new AllPermission();
    }

    public int getReadTimeout() {
        return this.readTimeout;
    }

    public Map<String, List<String>> getRequestProperties() {
        checkNotConnected();
        return Collections.emptyMap();
    }

    public String getRequestProperty(String str) {
        checkNotConnected();
        return null;
    }

    public URL getURL() {
        return this.url;
    }

    public boolean getUseCaches() {
        return this.useCaches;
    }

    public void setAllowUserInteraction(boolean z) {
        checkNotConnected();
        this.allowUserInteraction = z;
    }

    public void setConnectTimeout(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("timeoutMillis < 0");
        }
        this.connectTimeout = i;
    }

    public void setDefaultUseCaches(boolean z) {
        defaultUseCaches = z;
    }

    public void setDoInput(boolean z) {
        checkNotConnected();
        this.doInput = z;
    }

    public void setDoOutput(boolean z) {
        checkNotConnected();
        this.doOutput = z;
    }

    public void setIfModifiedSince(long j) {
        checkNotConnected();
        this.ifModifiedSince = j;
    }

    public void setReadTimeout(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("timeoutMillis < 0");
        }
        this.readTimeout = i;
    }

    public void setRequestProperty(String str, String str2) {
        checkNotConnected();
        if (str == null) {
            throw new NullPointerException("field == null");
        }
    }

    public void setUseCaches(boolean z) {
        checkNotConnected();
        this.useCaches = z;
    }

    public String toString() {
        return getClass().getName() + ":" + this.url.toString();
    }
}
