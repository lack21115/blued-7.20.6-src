package com.amap.api.col.p0003sl;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.os.Environment;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;

/* renamed from: com.amap.api.col.3sl.ev  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/ev.class */
public class ev {
    private static AssetManager b;

    /* renamed from: c  reason: collision with root package name */
    private static Resources f4948c;
    private static Resources d;
    private static boolean e = true;
    private static Context f;
    private static String g = "amap_resource";
    private static String h = "1_0_0";
    private static String j = ".jar";
    private static String k = g + h + j;
    private static String i = ".png";
    private static String l = g + h + i;
    private static String m = "";
    private static String n = m + k;
    private static Resources.Theme o = null;
    private static Resources.Theme p = null;
    private static Field q = null;
    private static Field r = null;
    private static Activity s = null;

    /* renamed from: a  reason: collision with root package name */
    public static int f4947a = -1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.amap.api.col.3sl.ev$a */
    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/ev$a.class */
    public static final class a implements FilenameFilter {
        a() {
        }

        @Override // java.io.FilenameFilter
        public final boolean accept(File file, String str) {
            StringBuilder sb = new StringBuilder();
            sb.append(ev.h);
            sb.append(ev.j);
            return str.startsWith(ev.g) && !str.endsWith(sb.toString());
        }
    }

    private static AssetManager a(String str) {
        AssetManager assetManager;
        Class<?> cls;
        AssetManager assetManager2;
        try {
            cls = Class.forName("android.content.res.AssetManager");
            assetManager2 = (AssetManager) cls.getConstructor(null).newInstance(null);
        } catch (Throwable th) {
            th = th;
            assetManager = null;
        }
        try {
            cls.getDeclaredMethod("addAssetPath", String.class).invoke(assetManager2, str);
            return assetManager2;
        } catch (Throwable th2) {
            assetManager = assetManager2;
            th = th2;
            iw.c(th, "ResourcesUtil", "getAssetManager(String apkPath)");
            return assetManager;
        }
    }

    public static Resources a() {
        Resources resources = f4948c;
        Resources resources2 = resources;
        if (resources == null) {
            resources2 = f.getResources();
        }
        return resources2;
    }

    private static Resources a(Context context, AssetManager assetManager) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        displayMetrics.setToDefaults();
        return new Resources(assetManager, displayMetrics, context.getResources().getConfiguration());
    }

    public static View a(Context context, int i2) {
        View view;
        XmlResourceParser xml = a().getXml(i2);
        if (e) {
            try {
                view = LayoutInflater.from(new eu(context, f4947a == -1 ? 0 : f4947a, ev.class.getClassLoader())).inflate(xml, (ViewGroup) null);
            } catch (Throwable th) {
                try {
                    th.printStackTrace();
                    iw.c(th, "ResourcesUtil", "selfInflate(Activity activity, int resource, ViewGroup root)");
                    view = null;
                } catch (Throwable th2) {
                    xml.close();
                    throw th2;
                }
            }
            xml.close();
            return view;
        }
        return LayoutInflater.from(context).inflate(xml, (ViewGroup) null);
    }

    private static OutputStream a(InputStream inputStream) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(new File(m, k));
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr);
            if (read <= 0) {
                return fileOutputStream;
            }
            fileOutputStream.write(bArr, 0, read);
        }
    }

    public static boolean a(Context context) {
        try {
            f = context;
            File b2 = b(context);
            if (b2 != null) {
                m = b2.getAbsolutePath() + BridgeUtil.SPLIT_MARK;
            }
            n = m + k;
            if (e) {
                if (c(context)) {
                    AssetManager a2 = a(n);
                    b = a2;
                    f4948c = a(context, a2);
                    return true;
                }
                return false;
            }
            return true;
        } catch (Throwable th) {
            th.printStackTrace();
            return true;
        }
    }

    private static File b(Context context) {
        File filesDir;
        File file = null;
        if (context == null) {
            if (context != null) {
                context.getFilesDir();
                return null;
            }
            return null;
        }
        try {
            try {
                if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
                    File externalStorageDirectory = Environment.getExternalStorageDirectory();
                    file = externalStorageDirectory;
                    if (externalStorageDirectory.canWrite()) {
                        filesDir = context.getExternalFilesDir("LBS");
                        if (filesDir == null && context != null) {
                            context.getFilesDir();
                        }
                        return filesDir;
                    }
                }
                filesDir = context.getFilesDir();
                if (filesDir == null) {
                    context.getFilesDir();
                }
                return filesDir;
            } catch (Exception e2) {
                e2.printStackTrace();
                File file2 = null;
                if (0 == 0) {
                    file2 = null;
                    if (context != null) {
                        file2 = context.getFilesDir();
                    }
                }
                return file2;
            }
        } catch (Throwable th) {
            if (0 == 0 && context != null) {
                context.getFilesDir();
            }
            throw th;
        }
    }

    private static boolean b(InputStream inputStream) throws IOException {
        File file = new File(n);
        long length = file.length();
        int available = inputStream.available();
        if (file.exists() && length == available) {
            inputStream.close();
            return true;
        }
        return false;
    }

    private static boolean c(Context context) {
        d(context);
        InputStream inputStream = null;
        try {
            InputStream open = context.getResources().getAssets().open(l);
            if (b(open)) {
                if (open != null) {
                    try {
                        open.close();
                        return true;
                    } catch (IOException e2) {
                        e2.printStackTrace();
                        iw.c(e2, "ResourcesUtil", "copyResourceJarToAppFilesDir(Context ctx)");
                        return true;
                    }
                }
                return true;
            }
            e();
            inputStream = open;
            OutputStream a2 = a(open);
            if (open != null) {
                try {
                    open.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                    iw.c(e3, "ResourcesUtil", "copyResourceJarToAppFilesDir(Context ctx)");
                    return true;
                }
            }
            if (a2 != null) {
                a2.close();
                return true;
            }
            return true;
        } catch (Throwable th) {
            try {
                th.printStackTrace();
                iw.c(th, "ResourcesUtil", "copyResourceJarToAppFilesDir(Context ctx)");
                if (inputStream != null) {
                    try {
                        inputStream.close();
                        return false;
                    } catch (IOException e4) {
                        e4.printStackTrace();
                        iw.c(e4, "ResourcesUtil", "copyResourceJarToAppFilesDir(Context ctx)");
                        return false;
                    }
                }
                return false;
            } catch (Throwable th2) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e5) {
                        e5.printStackTrace();
                        iw.c(e5, "ResourcesUtil", "copyResourceJarToAppFilesDir(Context ctx)");
                    }
                }
                throw th2;
            }
        }
    }

    private static void d(Context context) {
        m = context.getFilesDir().getAbsolutePath();
        n = m + BridgeUtil.SPLIT_MARK + k;
    }

    private static void e() {
        File[] listFiles = new File(m).listFiles(new a());
        if (listFiles == null || listFiles.length <= 0) {
            return;
        }
        int length = listFiles.length;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= length) {
                return;
            }
            listFiles[i3].delete();
            i2 = i3 + 1;
        }
    }
}
