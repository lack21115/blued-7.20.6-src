package com.blued.android.framework.web.cache;

import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.MimeTypeMap;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.web.cache.DiskLruCache;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.Nullable;
import okio.ByteString;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/web/cache/BluedWebViewCache.class */
public class BluedWebViewCache {
    private static ArrayList<String> a = new ArrayList<>();
    private static ArrayList<String> b = new ArrayList<>();
    private static DiskLruCache c;
    private static final Map<String, String> d;

    static {
        HashMap hashMap = new HashMap();
        d = hashMap;
        hashMap.put("js", "text/javascript");
    }

    private BluedWebViewCache() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static WebResourceResponse a(WebResourceRequest webResourceRequest) {
        boolean z;
        if (webResourceRequest == null) {
            return null;
        }
        Uri url = webResourceRequest.getUrl();
        String method = webResourceRequest.getMethod();
        if (url == null || !method.equalsIgnoreCase("get") || a.size() == 0 || b.size() == 0) {
            return null;
        }
        String uri = url.toString();
        if (a.contains(url.getAuthority())) {
            z = true;
        } else {
            Iterator<String> it = a.iterator();
            do {
                z = false;
                if (!it.hasNext()) {
                    break;
                }
            } while (!uri.startsWith(it.next()));
            z = true;
        }
        if (z) {
            try {
                String queryParameter = url.getQueryParameter("_no_cache");
                if (!TextUtils.isEmpty(queryParameter)) {
                    if (queryParameter.equals("1")) {
                        return null;
                    }
                }
            } catch (Exception e) {
                if (AppInfo.m()) {
                    Log.e("BluedWebViewCache", e.toString());
                }
            }
            String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(uri);
            if (TextUtils.isEmpty(fileExtensionFromUrl)) {
                return null;
            }
            String lowerCase = fileExtensionFromUrl.toLowerCase();
            if (b.contains(lowerCase)) {
                String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(lowerCase);
                String str = mimeTypeFromExtension;
                if (TextUtils.isEmpty(mimeTypeFromExtension)) {
                    String str2 = d.get(lowerCase);
                    str = str2;
                    if (TextUtils.isEmpty(str2)) {
                        if (AppInfo.m()) {
                            throw new RuntimeException("Not found MimeType of '" + lowerCase + "'!");
                        }
                        return null;
                    }
                }
                InputStream b2 = b(uri);
                InputStream inputStream = b2;
                if (b2 == null) {
                    inputStream = b2;
                    if (c(uri)) {
                        inputStream = b(uri);
                    }
                }
                if (inputStream == null) {
                    return null;
                }
                if (AppInfo.m()) {
                    Log.v("BluedWebViewCache", "load '" + uri + "' from DiskCache!");
                }
                return new WebResourceResponse(str, "UTF-8", inputStream);
            }
            return null;
        }
        return null;
    }

    private static File a() {
        return new File((("mounted".equals(Environment.getExternalStorageState()) || !Environment.isExternalStorageRemovable()) && AppInfo.d().getExternalCacheDir() != null) ? AppInfo.d().getExternalCacheDir() : AppInfo.d().getCacheDir(), "webview_cache");
    }

    private static String a(String str) {
        return ByteString.encodeUtf8(str).md5().hex();
    }

    public static void a(String... strArr) {
        if (strArr != null && strArr.length > 0) {
            int length = strArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    break;
                }
                String str = strArr[i2];
                if (!a.contains(str)) {
                    a.add(str);
                }
                i = i2 + 1;
            }
        }
        if (a.size() <= 0 || c != null) {
            return;
        }
        try {
            c = DiskLruCache.a(a(), 1, 1, 10485760L);
        } catch (IOException e) {
            if (AppInfo.m()) {
                e.printStackTrace();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x010a A[Catch: IOException -> 0x0120, TRY_ENTER, TryCatch #6 {IOException -> 0x0120, blocks: (B:55:0x00fe, B:58:0x010a), top: B:76:0x00fe }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00fe A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:89:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean a(java.lang.String r5, java.io.OutputStream r6) {
        /*
            Method dump skipped, instructions count: 298
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.framework.web.cache.BluedWebViewCache.a(java.lang.String, java.io.OutputStream):boolean");
    }

    private static InputStream b(String str) {
        DiskLruCache diskLruCache = c;
        if (diskLruCache != null) {
            try {
                DiskLruCache.Snapshot a2 = diskLruCache.a(a(str));
                if (a2 != null) {
                    return a2.a(0);
                }
                return null;
            } catch (Exception e) {
                if (AppInfo.m()) {
                    e.printStackTrace();
                    return null;
                }
                return null;
            }
        }
        return null;
    }

    public static void b(String... strArr) {
        if (strArr == null) {
            return;
        }
        int length = strArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            String lowerCase = strArr[i2].toLowerCase();
            if (!b.contains(lowerCase)) {
                b.add(lowerCase);
            }
            i = i2 + 1;
        }
    }

    @Nullable
    private static boolean c(String str) {
        DiskLruCache diskLruCache = c;
        boolean z = false;
        if (diskLruCache != null) {
            boolean z2 = false;
            try {
                DiskLruCache.Editor b2 = diskLruCache.b(a(str));
                boolean z3 = false;
                if (b2 != null) {
                    if (a(str, b2.a(0))) {
                        b2.a();
                        z3 = true;
                    } else {
                        b2.b();
                        z3 = false;
                    }
                }
                z2 = z3;
                c.a();
                return z3;
            } catch (Exception e) {
                z = z2;
                if (AppInfo.m()) {
                    e.printStackTrace();
                    z = z2;
                }
            }
        }
        return z;
    }
}
