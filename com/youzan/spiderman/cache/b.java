package com.youzan.spiderman.cache;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.youzan.spiderman.html.j;
import com.youzan.spiderman.html.l;
import com.youzan.spiderman.utils.FileUtil;
import com.youzan.spiderman.utils.JsonUtil;
import com.youzan.spiderman.utils.Logger;
import com.youzan.spiderman.utils.RegexUtil;
import com.youzan.spiderman.utils.Stone;
import com.youzan.spiderman.utils.StringUtils;
import com.youzan.spiderman.utils.UriUtil;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import okhttp3.FormBody;
import okhttp3.RequestBody;

/* loaded from: source-8829756-dex2jar.jar:com/youzan/spiderman/cache/b.class */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private Set<String> f41799a;
    private Set<String> b;

    /* renamed from: c  reason: collision with root package name */
    private Set<String> f41800c;
    private Set<String> d;
    private Set<String> e;
    private Set<String> f;

    /* loaded from: source-8829756-dex2jar.jar:com/youzan/spiderman/cache/b$a.class */
    static final class a {

        /* renamed from: a  reason: collision with root package name */
        static b f41801a = new b((byte) 0);
    }

    private b() {
        List<String> a2;
        List<String> c2;
        this.f41799a = null;
        this.b = null;
        this.f41800c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.f41799a = new HashSet(Arrays.asList(Stone.SUPPORTED_HOST));
        this.b = new HashSet(Arrays.asList(Stone.SUPPORTED_SCHEME));
        this.f41800c = new HashSet(Arrays.asList(Stone.SUPPORTED_EXTEND));
        this.f = new HashSet(Arrays.asList(Stone.SUPPORTED_HTML_HOST));
        if (this.d == null) {
            this.d = new HashSet();
            com.youzan.spiderman.c.a.b bVar = (com.youzan.spiderman.c.a.b) a((Class<Object>) com.youzan.spiderman.c.a.b.class, "config_pref");
            if (bVar != null && (c2 = bVar.a().b().a().c()) != null) {
                this.d.addAll(c2);
            }
        }
        if (this.e == null) {
            this.e = new HashSet();
            com.youzan.spiderman.c.a.b bVar2 = (com.youzan.spiderman.c.a.b) a((Class<Object>) com.youzan.spiderman.c.a.b.class, "config_pref");
            if (bVar2 == null || (a2 = bVar2.a().b().a().a()) == null) {
                return;
            }
            this.e.addAll(a2);
        }
    }

    /* synthetic */ b(byte b) {
        this();
    }

    public static b a() {
        return a.f41801a;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0036 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0038  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.youzan.spiderman.html.HtmlResponse a(com.youzan.spiderman.html.g r6) {
        /*
            java.io.File r0 = new java.io.File
            r1 = r0
            java.lang.String r2 = com.youzan.spiderman.cache.g.i()
            r3 = r6
            java.lang.String r3 = r3.b()
            r1.<init>(r2, r3)
            r7 = r0
            r0 = r7
            boolean r0 = r0.exists()
            if (r0 != 0) goto L18
            r0 = 0
            return r0
        L18:
            r0 = r7
            java.lang.String r0 = com.youzan.spiderman.utils.FileUtil.getFileContent(r0)     // Catch: com.google.gson.JsonParseException -> L23 java.io.IOException -> L2b
            com.youzan.spiderman.html.HtmlHeader r0 = com.youzan.spiderman.html.HtmlHeader.fromJson(r0)     // Catch: com.google.gson.JsonParseException -> L23 java.io.IOException -> L2b
            r7 = r0
            goto L32
        L23:
            r7 = move-exception
            r0 = r7
            r0.printStackTrace()
            goto L30
        L2b:
            r7 = move-exception
            r0 = r7
            r0.printStackTrace()
        L30:
            r0 = 0
            r7 = r0
        L32:
            r0 = r7
            if (r0 != 0) goto L38
            r0 = 0
            return r0
        L38:
            java.io.File r0 = new java.io.File
            r1 = r0
            java.lang.String r2 = com.youzan.spiderman.cache.g.h()
            r3 = r6
            java.lang.String r3 = r3.b()
            r1.<init>(r2, r3)
            r8 = r0
            java.io.FileInputStream r0 = new java.io.FileInputStream     // Catch: java.io.IOException -> L6a
            r1 = r0
            r2 = r8
            r1.<init>(r2)     // Catch: java.io.IOException -> L6a
            byte[] r0 = a(r0)     // Catch: java.io.IOException -> L6a
            r8 = r0
            r0 = r8
            if (r0 == 0) goto L72
            com.youzan.spiderman.html.HtmlResponse r0 = new com.youzan.spiderman.html.HtmlResponse     // Catch: java.io.IOException -> L6a
            r1 = r0
            r2 = r7
            java.util.Map r2 = r2.getHeaders()     // Catch: java.io.IOException -> L6a
            r3 = r8
            r4 = r6
            java.lang.String r4 = r4.c()     // Catch: java.io.IOException -> L6a
            r1.<init>(r2, r3, r4)     // Catch: java.io.IOException -> L6a
            r6 = r0
            r0 = r6
            return r0
        L6a:
            r6 = move-exception
            java.lang.String r0 = "FetchInterceptor"
            r1 = r6
            int r0 = com.youzan.spiderman.utils.Logger.e(r0, r1)
        L72:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.youzan.spiderman.cache.b.a(com.youzan.spiderman.html.g):com.youzan.spiderman.html.HtmlResponse");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0042 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static <T> T a(java.lang.Class<T> r5, java.lang.String r6) {
        /*
            r0 = r6
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L3c
            java.io.File r0 = new java.io.File
            r1 = r0
            java.lang.String r2 = com.youzan.spiderman.cache.g.e()
            r3 = r6
            r1.<init>(r2, r3)
            r6 = r0
            r0 = r6
            boolean r0 = r0.exists()
            if (r0 == 0) goto L3c
            r0 = r6
            java.lang.String r0 = r0.getPath()     // Catch: com.google.gson.JsonParseException -> L29 java.io.IOException -> L34
            java.lang.String r0 = com.youzan.spiderman.utils.FileUtil.getFileContent(r0)     // Catch: com.google.gson.JsonParseException -> L29 java.io.IOException -> L34
            r1 = r5
            java.lang.Object r0 = com.youzan.spiderman.utils.JsonUtil.fromJson(r0, r1)     // Catch: com.google.gson.JsonParseException -> L29 java.io.IOException -> L34
            r6 = r0
            goto L3e
        L29:
            r6 = move-exception
            java.lang.String r0 = "CachePreference"
            r1 = r6
            int r0 = com.youzan.spiderman.utils.Logger.e(r0, r1)
            goto L3c
        L34:
            r6 = move-exception
            java.lang.String r0 = "CachePreference"
            r1 = r6
            int r0 = com.youzan.spiderman.utils.Logger.e(r0, r1)
        L3c:
            r0 = 0
            r6 = r0
        L3e:
            r0 = r6
            if (r0 != 0) goto L5b
            r0 = r5
            java.lang.Object r0 = r0.newInstance()     // Catch: java.lang.IllegalAccessException -> L49 java.lang.InstantiationException -> L53
            r5 = r0
            r0 = r5
            return r0
        L49:
            r5 = move-exception
            java.lang.String r0 = "CachePreference"
            r1 = r5
            int r0 = com.youzan.spiderman.utils.Logger.e(r0, r1)
            r0 = r6
            return r0
        L53:
            r5 = move-exception
            java.lang.String r0 = "CachePreference"
            r1 = r5
            int r0 = com.youzan.spiderman.utils.Logger.e(r0, r1)
        L5b:
            r0 = r6
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.youzan.spiderman.cache.b.a(java.lang.Class, java.lang.String):java.lang.Object");
    }

    public static String a(String str, Map<String, String> map) {
        Uri.Builder buildUpon = Uri.parse(str).buildUpon();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            buildUpon.appendQueryParameter(entry.getKey(), entry.getValue());
        }
        return buildUpon.build().toString();
    }

    public static RequestBody a(Map<String, String> map) {
        FormBody.Builder builder = new FormBody.Builder();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            builder.add(entry.getKey(), entry.getValue());
        }
        return builder.build();
    }

    public static void a(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            Logger.e("CacheMerger", "context or path is null when unpack zip", new Object[0]);
            return;
        }
        int lastIndexOf = str.lastIndexOf(46);
        int lastIndexOf2 = str.lastIndexOf(95, lastIndexOf);
        if (lastIndexOf2 < 0 || lastIndexOf < 0) {
            throw new IllegalArgumentException("the zip file path format should be ${name}_${md5}.zip");
        }
        String substring = str.substring(lastIndexOf2 + 1, lastIndexOf);
        if (TextUtils.isEmpty(substring) || substring.length() != 10) {
            throw new IllegalArgumentException("md5 value in file name of zip should be 10 chars length");
        }
        d dVar = (d) a((Class<Object>) d.class, "merged_zip");
        if (dVar.a(substring)) {
            return;
        }
        new Thread(new c(context, str, substring, dVar)).start();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(Context context, String str, String str2, d dVar) {
        AutoCloseable autoCloseable = null;
        AutoCloseable autoCloseable2 = null;
        try {
            try {
                InputStream open = context.getAssets().open(str);
                File file = new File(g.b());
                if (file.exists() || file.mkdirs()) {
                    if (FileUtil.unpackToOverrideInDir(open, file)) {
                        dVar.b(str2);
                        a(dVar, "merged_zip");
                        com.youzan.spiderman.b.f.a().d();
                    }
                    open.close();
                    return;
                }
                StringBuilder sb = new StringBuilder("cannot mkdir for file:");
                sb.append(file);
                Logger.e("CacheMerger", sb.toString(), new Object[0]);
                if (open != null) {
                    try {
                        open.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            } catch (IOException e2) {
                Logger.e("CacheMerger", e2);
                if (0 != 0) {
                    try {
                        autoCloseable.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                }
            }
        } catch (Throwable th) {
            if (0 != 0) {
                try {
                    autoCloseable2.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
            }
            throw th;
        }
    }

    public static <T> void a(T t, String str) {
        if (TextUtils.isEmpty(str) || t == null) {
            return;
        }
        File file = new File(g.e());
        if (file.exists() || file.mkdir()) {
            File file2 = new File(g.e(), str);
            if (!file2.exists()) {
                try {
                    if (!file2.createNewFile()) {
                        return;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            try {
                com.youzan.spiderman.a.c.a().a(com.youzan.spiderman.a.b.a(file2.getPath(), JsonUtil.toJson(t, new e().getType())));
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static boolean a(com.youzan.spiderman.c.b.g gVar, com.youzan.spiderman.c.g.b bVar) {
        List<String> b;
        if (gVar == null || bVar == null) {
            return false;
        }
        String a2 = bVar.a();
        if (StringUtils.isEmpty(a2) || (b = gVar.b()) == null) {
            return false;
        }
        for (String str : b) {
            try {
            } catch (Exception e) {
                Logger.e("UploadPattern", "match exception, patter:" + str + ", url:" + a2, e);
            }
            if (RegexUtil.isMatch(str, a2)) {
                return true;
            }
        }
        return false;
    }

    public static byte[] a(InputStream inputStream) {
        byte[] byteArray;
        byte[] bArr = new byte[4096];
        try {
            try {
                if (inputStream instanceof j) {
                    do {
                    } while (inputStream.read(bArr) != -1);
                    byteArray = ((j) inputStream).a();
                } else {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    while (true) {
                        int read = inputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, read);
                    }
                    byteArray = byteArrayOutputStream.toByteArray();
                }
                try {
                    inputStream.close();
                    return byteArray;
                } catch (IOException e) {
                    Logger.e("FetchHelper", e);
                    return byteArray;
                }
            } catch (IOException e2) {
                Logger.e("FetchHelper", e2);
                try {
                    inputStream.close();
                    return null;
                } catch (IOException e3) {
                    Logger.e("FetchHelper", e3);
                    return null;
                }
            }
        } catch (Throwable th) {
            try {
                inputStream.close();
            } catch (IOException e4) {
                Logger.e("FetchHelper", e4);
            }
            throw th;
        }
    }

    public final void a(List<String> list) {
        this.d.addAll(list);
    }

    public final boolean a(CacheUrl cacheUrl) {
        String extend = cacheUrl.getExtend();
        Uri uri = cacheUrl.getUri();
        if (!TextUtils.isEmpty(extend) && this.f41800c.contains(extend) && this.f41799a.contains(uri.getHost()) && this.b.contains(uri.getScheme())) {
            return !this.d.contains(extend) && !this.e.contains(uri.getPath());
        }
        return false;
    }

    public final boolean a(l lVar) {
        Uri b = lVar.b();
        if (this.f.contains(b.getHost()) && this.b.contains(b.getScheme())) {
            String uriExtend = UriUtil.getUriExtend(b);
            return StringUtils.isEmpty(uriExtend) || uriExtend.equals(com.baidu.mobads.sdk.internal.a.f) || uriExtend.equals(com.baidu.mobads.sdk.internal.a.f);
        }
        return false;
    }

    public final void b(List<String> list) {
        this.e.addAll(list);
    }
}
