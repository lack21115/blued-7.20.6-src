package com.kwad.sdk.core.webview.a.b;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/webview/a/b/a.class */
public final class a {
    public static String A(Context context, String str) {
        String bi = bi(context);
        if (TextUtils.isEmpty(bi)) {
            return null;
        }
        return bi + File.separator + str + File.separator + "_manifest_.json";
    }

    private static File bh(Context context) {
        File filesDir = context.getFilesDir();
        File file = filesDir;
        if (filesDir == null) {
            file = new File("/data/data/" + context.getPackageName() + "/file/");
        }
        return file;
    }

    private static String bi(Context context) {
        String str = bh(context) + File.separator + "offlinepackage";
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return str;
    }

    public static File bj(Context context) {
        String bi = bi(context);
        if (TextUtils.isEmpty(bi)) {
            return null;
        }
        dk(bi);
        File file = new File(bi, "packageIndex.json");
        if (!file.exists()) {
            file.createNewFile();
        }
        return file;
    }

    public static String di(String str) {
        try {
            return Uri.parse(str).getQueryParameter("sceneId");
        } catch (Throwable th) {
            com.kwad.sdk.core.d.b.e("HybridFileUtils", "getSceneId This isn't a hierarchical URI url is " + str);
            return "";
        }
    }

    public static String dj(String str) {
        try {
            List<String> pathSegments = Uri.parse(str).getPathSegments();
            String str2 = null;
            if (pathSegments != null) {
                str2 = null;
                if (pathSegments.size() > 0) {
                    str2 = pathSegments.get(pathSegments.size() - 1);
                }
            }
            return (TextUtils.isEmpty(str2) || !str2.contains(".zip")) ? "" : str2.substring(0, str2.indexOf(".zip"));
        } catch (Throwable th) {
            com.kwad.sdk.core.d.b.e("HybridFileUtils", "getZipName This isn't a hierarchical URI url is " + str);
            return "";
        }
    }

    private static boolean dk(String str) {
        File file = new File(str);
        if (file.exists()) {
            return true;
        }
        return file.mkdirs();
    }

    public static void e(Context context, String str, String str2) {
        ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(str));
        while (true) {
            ZipEntry nextEntry = zipInputStream.getNextEntry();
            if (nextEntry == null) {
                break;
            }
            String name = nextEntry.getName();
            String bi = bi(context);
            if (!new File(bi, name).getAbsolutePath().startsWith(bi)) {
                break;
            } else if (!nextEntry.isDirectory()) {
                File file = new File(str2 + File.separator + name);
                if (!file.exists()) {
                    file.getParentFile().mkdirs();
                    file.createNewFile();
                }
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = zipInputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    fileOutputStream.write(bArr, 0, read);
                    fileOutputStream.flush();
                }
                com.kwad.sdk.crash.utils.b.closeQuietly(fileOutputStream);
            } else if (!name.contains("../")) {
                String substring = name.substring(0, name.length() - 1);
                new File(str2 + File.separator + substring).mkdirs();
            }
        }
        com.kwad.sdk.crash.utils.b.closeQuietly(zipInputStream);
    }

    public static String x(Context context, String str) {
        String bi = bi(context);
        if (TextUtils.isEmpty(bi)) {
            return null;
        }
        return bi + File.separator + str;
    }

    public static String y(Context context, String str) {
        String bi = bi(context);
        if (TextUtils.isEmpty(bi)) {
            return null;
        }
        return bi + File.separator + str + ".zip";
    }

    public static String z(Context context, String str) {
        String bi = bi(context);
        if (TextUtils.isEmpty(bi)) {
            return null;
        }
        return bi + File.separator + str;
    }
}
