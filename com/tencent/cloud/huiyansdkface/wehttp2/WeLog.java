package com.tencent.cloud.huiyansdkface.wehttp2;

import android.net.wifi.WifiEnterpriseConfig;
import com.tencent.cloud.huiyansdkface.okhttp3.Headers;
import com.tencent.cloud.huiyansdkface.okhttp3.HttpUrl;
import com.tencent.cloud.huiyansdkface.okhttp3.Interceptor;
import com.tencent.cloud.huiyansdkface.okhttp3.MediaType;
import com.tencent.cloud.huiyansdkface.okhttp3.MultipartBody;
import com.tencent.cloud.huiyansdkface.okhttp3.RequestBody;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.platform.Platform;
import com.tencent.cloud.huiyansdkface.okio.Buffer;
import com.tencent.thumbplayer.api.TPErrorCode;
import java.io.EOFException;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/wehttp2/WeLog.class */
public final class WeLog implements Interceptor {
    boolean b;

    /* renamed from: c  reason: collision with root package name */
    InnerLogger f22440c;
    volatile Level d;
    private boolean f;
    private Logger g;
    private volatile Set<String> h;
    private boolean i;
    private int j;
    private static final Charset e = Charset.forName("UTF-8");

    /* renamed from: a  reason: collision with root package name */
    public static final Logger f22439a = new Logger() { // from class: com.tencent.cloud.huiyansdkface.wehttp2.WeLog.1
        @Override // com.tencent.cloud.huiyansdkface.wehttp2.WeLog.Logger
        public void log(String str) {
            Platform.get().log(4, str, null);
        }
    };

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/wehttp2/WeLog$Builder.class */
    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        boolean f22442a = false;
        boolean b = false;

        /* renamed from: c  reason: collision with root package name */
        boolean f22443c = false;
        int d = 3072;
        Level e = Level.NONE;
        ILogTag f = null;
        Logger g = null;

        public WeLog build() {
            WeLog weLog = new WeLog();
            weLog.prettyLog(this.f22442a);
            weLog.logTag(this.b);
            weLog.cutLongStr(this.f22443c);
            weLog.longStrLength(this.d);
            weLog.setLevel(this.e);
            weLog.setLogger(this.g);
            return weLog;
        }

        public Builder setCutLongStr(boolean z) {
            this.f22443c = z;
            return this;
        }

        public Builder setLevel(Level level) {
            this.e = level;
            return this;
        }

        public Builder setLogTag(ILogTag iLogTag) {
            this.f = iLogTag;
            return this;
        }

        public Builder setLogWithTag(boolean z) {
            this.b = z;
            return this;
        }

        public Builder setLogger(Logger logger) {
            this.g = logger;
            return this;
        }

        public Builder setLongStrLength(int i) {
            this.d = i;
            return this;
        }

        public Builder setPrettyLog(boolean z) {
            this.f22442a = z;
            return this;
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/wehttp2/WeLog$ILogTag.class */
    public interface ILogTag {
        String tag(HttpUrl httpUrl, Object obj);
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/wehttp2/WeLog$InnerLogger.class */
    public static abstract class InnerLogger {
        public abstract void log(String str);

        public void print(String str) {
            int min;
            int length = str.length();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    return;
                }
                int indexOf = str.indexOf(10, i2);
                if (indexOf == -1) {
                    indexOf = length;
                }
                while (true) {
                    min = Math.min(indexOf, i2 + TPErrorCode.TP_ERROR_TYPE_DOWNLOAD_PROXY);
                    log(str.substring(i2, min));
                    if (min >= indexOf) {
                        break;
                    }
                    i2 = min;
                }
                i = min + 1;
            }
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/wehttp2/WeLog$Level.class */
    public enum Level {
        NONE,
        BASIC,
        HEADERS,
        BODY
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/wehttp2/WeLog$Logger.class */
    public interface Logger {
        void log(String str);
    }

    public WeLog() {
        this(f22439a);
    }

    public WeLog(Logger logger) {
        this.f = false;
        this.b = false;
        this.f22440c = new InnerLogger() { // from class: com.tencent.cloud.huiyansdkface.wehttp2.WeLog.2
            @Override // com.tencent.cloud.huiyansdkface.wehttp2.WeLog.InnerLogger
            public void log(String str) {
                if (WeLog.this.g != null) {
                    WeLog.this.g.log(str);
                }
            }
        };
        this.h = Collections.emptySet();
        this.d = Level.NONE;
        this.i = false;
        this.j = 3072;
        setLogger(logger);
    }

    private void a(String str, Headers headers) {
        int size = headers.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return;
            }
            String name = headers.name(i2);
            if (!"Content-Type".equalsIgnoreCase(name) && !"Content-Length".equalsIgnoreCase(name)) {
                a(str, headers, i2);
            }
            i = i2 + 1;
        }
    }

    private void a(String str, Headers headers, int i) {
        String value = this.h.contains(headers.name(i)) ? "██" : headers.value(i);
        InnerLogger innerLogger = this.f22440c;
        innerLogger.print(str + headers.name(i) + ": " + value);
    }

    private void a(String str, String str2) {
        StringBuilder sb;
        InnerLogger innerLogger;
        if (!this.i || str2 == null) {
            InnerLogger innerLogger2 = this.f22440c;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str);
            sb2.append(str2);
            sb = sb2;
            innerLogger = innerLogger2;
        } else {
            InnerLogger innerLogger3 = this.f22440c;
            StringBuilder sb3 = new StringBuilder();
            sb3.append(str);
            sb3.append(WeLogUtils.getShortString(str2, this.j));
            innerLogger = innerLogger3;
            sb = sb3;
        }
        innerLogger.print(sb.toString());
    }

    private static boolean a(Headers headers) {
        String str = headers.get("Content-Encoding");
        return (str == null || str.equalsIgnoreCase(WifiEnterpriseConfig.IDENTITY_KEY) || str.equalsIgnoreCase("gzip")) ? false : true;
    }

    private boolean a(MediaType mediaType) {
        return mediaType != null && "json".equals(mediaType.subtype());
    }

    private boolean a(RequestBody requestBody) {
        return requestBody instanceof MultipartBody;
    }

    static boolean a(Buffer buffer) {
        try {
            Buffer buffer2 = new Buffer();
            buffer.copyTo(buffer2, 0L, buffer.size() < 64 ? buffer.size() : 64L);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= 16) {
                    return true;
                }
                if (buffer2.exhausted()) {
                    return true;
                }
                int readUtf8CodePoint = buffer2.readUtf8CodePoint();
                if (Character.isISOControl(readUtf8CodePoint) && !Character.isWhitespace(readUtf8CodePoint)) {
                    return false;
                }
                i = i2 + 1;
            }
        } catch (EOFException e2) {
            return false;
        }
    }

    private boolean b(MediaType mediaType) {
        if (mediaType != null) {
            return "video".equals(mediaType.type()) || "image".equals(mediaType.type()) || "audio".equals(mediaType.type()) || MediaType.j.equals(mediaType);
        }
        return false;
    }

    public void cutLongStr(boolean z) {
        this.i = z;
    }

    public Level getLevel() {
        return this.d;
    }

    /* JADX WARN: Removed duplicated region for block: B:117:0x07d4  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x07f3  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x082d  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0834  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0893  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x08be  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x08de  */
    @Override // com.tencent.cloud.huiyansdkface.okhttp3.Interceptor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.tencent.cloud.huiyansdkface.okhttp3.Response intercept(com.tencent.cloud.huiyansdkface.okhttp3.Interceptor.Chain r7) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 3259
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.cloud.huiyansdkface.wehttp2.WeLog.intercept(com.tencent.cloud.huiyansdkface.okhttp3.Interceptor$Chain):com.tencent.cloud.huiyansdkface.okhttp3.Response");
    }

    public WeLog logTag(boolean z) {
        this.b = z;
        return this;
    }

    public void longStrLength(int i) {
        this.j = i;
    }

    public WeLog prettyLog(boolean z) {
        this.f = z;
        return this;
    }

    public void redactHeader(String str) {
        TreeSet treeSet = new TreeSet(String.CASE_INSENSITIVE_ORDER);
        treeSet.addAll(this.h);
        treeSet.add(str);
        this.h = treeSet;
    }

    public WeLog setLevel(Level level) {
        if (level != null) {
            this.d = level;
            return this;
        }
        throw new NullPointerException("level == null. Use Level.NONE instead.");
    }

    public void setLogger(Logger logger) {
        if (logger != null) {
            this.g = logger;
        }
    }
}
