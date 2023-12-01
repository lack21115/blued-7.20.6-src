package com.tencent.mm.opensdk.utils;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mm/opensdk/utils/d.class */
public final class d {
    public static Context D;
    private static final int E;
    private static final int F;
    private static final int G;
    public static ThreadPoolExecutor H;

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        E = availableProcessors;
        F = availableProcessors + 1;
        G = (availableProcessors * 2) + 1;
        H = new ThreadPoolExecutor(F, G, 1L, TimeUnit.SECONDS, new LinkedBlockingDeque());
    }

    private static int a(ContentResolver contentResolver, Uri uri) {
        Log.i("MicroMsg.SDK.Util", "getFileSize with content url");
        if (contentResolver == null || uri == null) {
            Log.w("MicroMsg.SDK.Util", "getFileSize fail, resolver or uri is null");
            return 0;
        }
        InputStream inputStream = null;
        InputStream inputStream2 = null;
        try {
            try {
                InputStream openInputStream = contentResolver.openInputStream(uri);
                if (openInputStream == null) {
                    if (openInputStream != null) {
                        try {
                            openInputStream.close();
                            return 0;
                        } catch (IOException e) {
                            return 0;
                        }
                    }
                    return 0;
                }
                inputStream2 = openInputStream;
                inputStream = openInputStream;
                int available = openInputStream.available();
                if (openInputStream != null) {
                    try {
                        openInputStream.close();
                    } catch (IOException e2) {
                        return available;
                    }
                }
                return available;
            } catch (Throwable th) {
                if (inputStream2 != null) {
                    try {
                        inputStream2.close();
                    } catch (IOException e3) {
                    }
                }
                throw th;
            }
        } catch (Exception e4) {
            StringBuilder sb = new StringBuilder("getFileSize fail, ");
            InputStream inputStream3 = inputStream;
            sb.append(e4.getMessage());
            inputStream2 = inputStream;
            Log.w("MicroMsg.SDK.Util", sb.toString());
            if (inputStream != null) {
                try {
                    inputStream.close();
                    return 0;
                } catch (IOException e5) {
                    return 0;
                }
            }
            return 0;
        }
    }

    public static boolean a(int i) {
        return i == 36 || i == 46;
    }

    public static boolean b(String str) {
        return str == null || str.length() <= 0;
    }

    public static int c(String str) {
        if (str != null) {
            try {
                if (str.length() <= 0) {
                    return 0;
                }
                return Integer.parseInt(str);
            } catch (Exception e) {
                return 0;
            }
        }
        return 0;
    }

    public static int getFileSize(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        File file = new File(str);
        if (file.exists()) {
            return (int) file.length();
        }
        if (D == null || !str.startsWith("content")) {
            return 0;
        }
        try {
            return a(D.getContentResolver(), Uri.parse(str));
        } catch (Exception e) {
            return 0;
        }
    }
}
