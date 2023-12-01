package com.blued.android.sdk.a;

import com.alibaba.fastjson.support.spring.FastJsonJsonView;
import com.google.gson.Gson;
import io.grpc.internal.GrpcUtil;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/sdk/a/e.class */
public class e {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.blued.android.sdk.a.e$1  reason: invalid class name */
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/sdk/a/e$1.class */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x0036 -> B:21:0x0014). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x003a -> B:19:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x003e -> B:25:0x002a). Please submit an issue!!! */
        static {
            int[] iArr = new int[a.values().length];
            a = iArr;
            try {
                iArr[a.Get.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                a[a.Delete.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                a[a.Post.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                a[a.Put.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/sdk/a/e$a.class */
    public enum a {
        Get,
        Post,
        Put,
        Delete
    }

    public static String a(String str, Map<String, String> map) {
        String str2 = str;
        if (map != null) {
            str2 = str;
            if (map.size() > 0) {
                Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
                while (true) {
                    str2 = str;
                    if (!it.hasNext()) {
                        break;
                    }
                    Map.Entry<String, String> next = it.next();
                    String str3 = next.getKey() + "=" + next.getValue();
                    if (str.indexOf("?") == -1) {
                        str = str + "?" + str3;
                    } else {
                        str = str + com.alipay.sdk.sys.a.b + str3;
                    }
                }
            }
        }
        return str2;
    }

    public static String a(HttpURLConnection httpURLConnection) {
        InputStream errorStream;
        byte[] bArr = new byte[1024];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            try {
                errorStream = httpURLConnection.getInputStream();
            } catch (IOException e) {
                errorStream = httpURLConnection.getErrorStream();
            }
            while (true) {
                int read = errorStream.read(bArr);
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        return new String(byteArrayOutputStream.toByteArray());
    }

    public static HttpURLConnection a(a aVar, URL url, Map<String, String> map, Map<String, String> map2) {
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setConnectTimeout(30000);
        httpURLConnection.setReadTimeout(30000);
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setDoInput(true);
        if (map != null && map.size() > 0) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                httpURLConnection.addRequestProperty(entry.getKey(), entry.getValue());
            }
        }
        int i = AnonymousClass1.a[aVar.ordinal()];
        if (i == 1) {
            httpURLConnection.setRequestMethod("GET");
            return httpURLConnection;
        } else if (i == 2) {
            httpURLConnection.setRequestMethod("DELETE");
            return httpURLConnection;
        } else if (i == 3) {
            httpURLConnection.setRequestMethod(GrpcUtil.HTTP_METHOD);
            a(httpURLConnection, map2);
            return httpURLConnection;
        } else if (i == 4) {
            httpURLConnection.setRequestMethod("PUT");
            a(httpURLConnection, map2);
            return httpURLConnection;
        } else {
            throw new IllegalStateException("Unknown method type.");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x00e3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.Map<java.lang.String, java.lang.String> a(java.lang.String r5, java.lang.String r6, java.lang.String r7, java.lang.String r8) {
        /*
            Method dump skipped, instructions count: 331
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.sdk.a.e.a(java.lang.String, java.lang.String, java.lang.String, java.lang.String):java.util.Map");
    }

    private static void a(HttpURLConnection httpURLConnection, Map<String, String> map) {
        if (httpURLConnection == null || map == null) {
            return;
        }
        httpURLConnection.addRequestProperty("Content-Type", FastJsonJsonView.DEFAULT_CONTENT_TYPE);
        String json = new Gson().toJson(map);
        DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
        dataOutputStream.writeUTF(json);
        dataOutputStream.close();
    }
}
