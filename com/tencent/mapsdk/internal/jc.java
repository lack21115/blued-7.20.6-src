package com.tencent.mapsdk.internal;

import android.content.Context;
import android.content.res.AssetManager;
import android.text.TextUtils;
import com.tencent.tencentmap.mapsdk.maps.TencentMapOptions;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/jc.class */
public class jc {

    /* renamed from: a  reason: collision with root package name */
    private static final String f23875a = "tencentmap";
    private static final String b = "/mapsdk_vector/";

    /* renamed from: c  reason: collision with root package name */
    private static String f23876c;
    private static String d;
    private static String e = "resourceVersion.dat";

    public static final InputStream a(Context context, String str) {
        AssetManager assets;
        if (context == null || (assets = context.getAssets()) == null) {
            return null;
        }
        try {
            return assets.open(str);
        } catch (IOException e2) {
            na.f("asset", e2.getMessage(), e2);
            return null;
        }
    }

    public static final InputStream a(Context context, String str, String str2) {
        return a(context, str + str2);
    }

    public static String a() {
        return f23876c;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0070, code lost:
        if (a(r6, r7, com.tencent.mapsdk.internal.jc.f23876c, r9, true) != false) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00eb, code lost:
        if (a(r6, r7, com.tencent.mapsdk.internal.jc.d, r9, false) != false) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0165, code lost:
        if (a(r6, r7, r0, r9, false) != false) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x01ce, code lost:
        if (a(r6, r7, com.tencent.mapsdk.internal.c7.m, r9, true) != false) goto L93;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(android.content.Context r6, com.tencent.mapsdk.internal.ic r7, java.lang.String r8, java.lang.String r9) {
        /*
            Method dump skipped, instructions count: 594
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mapsdk.internal.jc.a(android.content.Context, com.tencent.mapsdk.internal.ic, java.lang.String, java.lang.String):void");
    }

    private static void a(ic icVar, String str) {
        File file = new File(str, k4.e);
        String d2 = icVar.d(m4.y);
        if (TextUtils.isEmpty(d2)) {
            return;
        }
        try {
            if (TextUtils.equals(wa.a(file), d2)) {
                return;
            }
            file.delete();
            icVar.a(new String[]{m4.s, m4.y});
        } catch (FileNotFoundException e2) {
            na.b("config error: ", e2);
            icVar.a(new String[]{m4.s, m4.y});
        }
    }

    public static void a(TencentMapOptions tencentMapOptions) {
        if (tencentMapOptions != null) {
            if (tencentMapOptions.getCustomAssetsPath() != null) {
                a(tencentMapOptions.getCustomAssetsPath());
            } else if (tencentMapOptions.getCustomLocalPath() != null) {
                b(tencentMapOptions.getCustomLocalPath());
            }
        }
    }

    public static void a(String str) {
        if (str == null || str.trim().length() == 0) {
            return;
        }
        String str2 = File.separator;
        String str3 = str;
        if (!str.endsWith(str2)) {
            str3 = str + str2;
        }
        f23876c = str3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v33, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r0v35, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r0v39, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r0v43, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r0v52, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r0v58, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r0v60, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r0v62, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r0v64, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r0v68, types: [java.io.InputStream] */
    private static boolean a(Context context, ic icVar, String str, String str2, boolean z) {
        String str3;
        String str4;
        if (icVar == null || (icVar instanceof kc)) {
            return false;
        }
        String str5 = null;
        if (str2.startsWith(k4.i)) {
            str4 = k4.i;
            str3 = m4.f23936a;
        } else if (str2.startsWith(k4.j)) {
            str3 = m4.d;
            str4 = k4.j;
        } else if (str2.startsWith("poi_icon")) {
            str3 = m4.f23937c;
            str4 = "poi_icon";
        } else {
            str3 = "";
            str4 = null;
        }
        if (str4 == null) {
            return false;
        }
        int b2 = icVar.b(str3);
        String str6 = str + e;
        try {
            try {
                String a2 = z ? a(context, str6) : ha.c(str6);
                if (a2 == null) {
                    ha.a((Closeable) a2);
                    return false;
                }
                byte[] b3 = ha.b((InputStream) a2);
                if (b3 == null) {
                    ha.a((Closeable) a2);
                    return false;
                }
                int optInt = new JSONObject(new String(b3)).optInt(str4, -1);
                if (optInt == -1) {
                    ha.a((Closeable) a2);
                    return false;
                } else if (optInt <= b2) {
                    ha.a((Closeable) a2);
                    return false;
                } else {
                    str = a2;
                    str5 = a2;
                    icVar.a(new String[]{str3});
                    ha.a((Closeable) a2);
                    return true;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                ha.a((Closeable) str);
                return false;
            }
        } catch (Throwable th) {
            ha.a((Closeable) str5);
            throw th;
        }
    }

    public static final InputStream b(Context context, String str) {
        return a(context, c7.m, str);
    }

    public static String b() {
        return d;
    }

    private static void b(ic icVar, String str) {
        String str2;
        String str3;
        File file = new File(str, k4.b);
        String d2 = icVar.d("indoormap_style_md5");
        if (!TextUtils.isEmpty(d2)) {
            na.a(ma.f, "校验文件:indoor_style.dat");
            try {
                str3 = wa.a(file);
            } catch (FileNotFoundException e2) {
                e2.printStackTrace();
                str3 = null;
            }
            if (!TextUtils.equals(str3, d2)) {
                na.a(ma.f, "文件md5校验失败:" + str3 + "," + str3);
                file.delete();
                icVar.a(new String[]{"indoormap_style_version", "indoormap_style_md5"});
            }
        }
        File file2 = new File(str, k4.f23893c);
        String d3 = icVar.d("indoormap_style_night_md5");
        if (TextUtils.isEmpty(d3)) {
            return;
        }
        na.a(ma.f, "校验文件:indoor_style_night.dat");
        try {
            str2 = wa.a(file2);
        } catch (FileNotFoundException e3) {
            e3.printStackTrace();
            str2 = null;
        }
        if (TextUtils.equals(str2, d3)) {
            return;
        }
        na.a(ma.f, "文件md5校验失败:" + str2 + "," + d3);
        file2.delete();
        icVar.a(new String[]{"indoormap_style_night_version", "indoormap_style_night_md5"});
    }

    public static void b(String str) {
        if (str == null || str.trim().length() == 0) {
            return;
        }
        String str2 = File.separator;
        String str3 = str;
        if (!str.endsWith(str2)) {
            str3 = str + str2;
        }
        d = str3;
    }

    public static void c(ic icVar, String str) {
        if (d(icVar, str)) {
            b(icVar, str);
            a(icVar, str);
        }
    }

    private static boolean d(ic icVar, String str) {
        File file = new File(str, k4.f23892a);
        String d2 = icVar.d(m4.t);
        if (file.exists() || !TextUtils.isEmpty(d2)) {
            try {
                if (TextUtils.equals(wa.a(file), d2)) {
                    return true;
                }
                file.delete();
                icVar.b();
                return false;
            } catch (FileNotFoundException e2) {
                e2.printStackTrace();
                icVar.b();
                return false;
            }
        }
        return true;
    }
}
