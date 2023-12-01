package com.blued.android.statistics.util;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.squareup.okhttp.ConnectionSpec;
import io.grpc.Metadata;
import io.grpc.Status;
import io.grpc.okhttp.OkHttpChannelBuilder;
import io.grpc.stub.AbstractStub;
import io.grpc.stub.MetadataUtils;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/statistics/util/Utils.class */
public final class Utils {

    /* renamed from: a  reason: collision with root package name */
    private static Handler f18734a = new Handler(Looper.getMainLooper());

    public static Metadata.Key<String> a(String str) {
        return Metadata.Key.of(str, Metadata.ASCII_STRING_MARSHALLER);
    }

    public static Metadata a(ConcurrentHashMap<String, String> concurrentHashMap, Metadata metadata, String str, String str2) {
        Metadata metadata2;
        if (TextUtils.isEmpty(str)) {
            return metadata;
        }
        String str3 = str2;
        if (str2 == null) {
            str3 = "";
        }
        boolean containsKey = concurrentHashMap.containsKey(str);
        if (containsKey && concurrentHashMap.get(str).equals(str3)) {
            return metadata;
        }
        concurrentHashMap.put(str, str3);
        if (containsKey) {
            Metadata metadata3 = new Metadata();
            Iterator<Map.Entry<String, String>> it = concurrentHashMap.entrySet().iterator();
            while (true) {
                metadata2 = metadata3;
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry<String, String> next = it.next();
                String value = next.getValue();
                if (!TextUtils.isEmpty(value)) {
                    metadata3.put(a(next.getKey()), value);
                }
            }
        } else {
            metadata2 = metadata;
            if (str3.length() > 0) {
                metadata.put(a(str), str3);
                metadata2 = metadata;
            }
        }
        return metadata2;
    }

    public static OkHttpChannelBuilder a(String str, int i) {
        OkHttpChannelBuilder okHttpChannelBuilder = (OkHttpChannelBuilder) OkHttpChannelBuilder.forAddress(str, i).connectionSpec(ConnectionSpec.MODERN_TLS).directExecutor();
        String property = System.getProperty("http.agent");
        if (!TextUtils.isEmpty(property)) {
            okHttpChannelBuilder.userAgent(property);
        }
        return okHttpChannelBuilder;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v8, types: [io.grpc.stub.AbstractStub] */
    public static <T extends AbstractStub<T>> T a(T t, Metadata metadata) {
        T t2 = t;
        if (metadata != null) {
            t2 = t;
            if (metadata.keys().size() > 0) {
                t2 = MetadataUtils.attachHeaders(t, metadata);
            }
        }
        return t2;
    }

    public static String a(Throwable th) {
        if (th == null) {
            return "";
        }
        Status fromThrowable = Status.fromThrowable(th);
        if (fromThrowable.getCode() == Status.Code.UNKNOWN) {
            return th.toString();
        }
        Throwable cause = fromThrowable.getCause();
        String description = fromThrowable.getDescription();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("code=");
        stringBuffer.append(fromThrowable.getCode());
        stringBuffer.append(", description=");
        String str = description;
        if (description == null) {
            str = "";
        }
        stringBuffer.append(str);
        stringBuffer.append(", cause=");
        stringBuffer.append(cause == null ? "" : cause.toString());
        return stringBuffer.toString();
    }

    public static void a(Runnable runnable) {
        f18734a.post(runnable);
    }

    public static void a(Runnable runnable, long j) {
        f18734a.postDelayed(runnable, j);
    }

    public static String b(String str) {
        String str2 = str;
        if (str == null) {
            str2 = "";
        }
        return str2;
    }

    public static void b(Runnable runnable) {
        f18734a.removeCallbacks(runnable);
    }
}
