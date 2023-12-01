package com.ss.android.downloadlib.addownload;

import android.content.Context;
import com.ss.android.download.api.config.e;
import com.ss.android.download.api.config.g;
import com.ss.android.download.api.config.io;
import com.ss.android.download.api.config.lc;
import com.ss.android.download.api.config.m;
import com.ss.android.download.api.config.nk;
import com.ss.android.download.api.config.o;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import org.json.JSONObject;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/downloadlib/addownload/x.class */
public class x {
    private static com.ss.android.download.api.config.ko b;
    private static m df;
    private static o e;
    private static e g;
    private static com.ss.android.download.api.ox.mb gm;
    private static com.ss.android.download.api.config.je h;
    private static com.ss.android.download.api.config.b hj;

    /* renamed from: io  reason: collision with root package name */
    private static g f34888io;
    private static com.ss.android.socialbase.appdownloader.b.ww jb;
    private static com.ss.android.download.api.config.hj je;
    private static com.ss.android.download.api.config.lz ko;
    private static nk l;
    private static com.ss.android.download.api.config.jb lc;
    private static com.ss.android.download.api.model.mb lz;
    private static io m;
    public static final JSONObject mb = new JSONObject();
    private static com.ss.android.download.api.config.h nk;
    private static lc o;
    private static Context ox;
    private static com.ss.android.download.api.config.ww u;
    private static com.ss.android.download.api.config.x ww;
    private static com.ss.android.download.api.config.ox x;

    public static com.ss.android.download.api.config.je b() {
        if (h == null) {
            h = new com.ss.android.download.api.mb.mb();
        }
        return h;
    }

    public static boolean df() {
        return (b == null || u == null || ww == null || x == null || g == null) ? false : true;
    }

    public static e e() {
        return g;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0068, code lost:
        if (r0 > 29) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String g() {
        /*
            android.content.Context r0 = getContext()     // Catch: java.lang.Throwable -> L61
            android.content.pm.ApplicationInfo r0 = r0.getApplicationInfo()     // Catch: java.lang.Throwable -> L61
            int r0 = r0.targetSdkVersion     // Catch: java.lang.Throwable -> L61
            r5 = r0
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> L61
            r1 = 29
            if (r0 < r1) goto L2e
            r0 = r5
            r1 = 29
            if (r0 != r1) goto L65
            boolean r0 = android.os.Environment.isExternalStorageLegacy()     // Catch: java.lang.Throwable -> L61
            if (r0 == 0) goto L21
            goto L65
        L21:
            android.content.Context r0 = getContext()     // Catch: java.lang.Throwable -> L61
            java.lang.String r1 = android.os.Environment.DIRECTORY_DOWNLOADS     // Catch: java.lang.Throwable -> L61
            java.io.File r0 = r0.getExternalFilesDir(r1)     // Catch: java.lang.Throwable -> L61
            java.lang.String r0 = r0.getAbsolutePath()     // Catch: java.lang.Throwable -> L61
            return r0
        L2e:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L61 java.lang.Throwable -> L61
            r1 = r0
            r1.<init>()     // Catch: java.lang.Throwable -> L61
            r6 = r0
            r0 = r6
            java.io.File r1 = android.os.Environment.getExternalStorageDirectory()     // Catch: java.lang.Throwable -> L61
            java.lang.String r1 = r1.getPath()     // Catch: java.lang.Throwable -> L61
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch: java.lang.Throwable -> L61
            r0 = r6
            java.lang.String r1 = java.io.File.separator     // Catch: java.lang.Throwable -> L61
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch: java.lang.Throwable -> L61
            r0 = r6
            org.json.JSONObject r1 = lz()     // Catch: java.lang.Throwable -> L61
            java.lang.String r2 = "default_save_dir_name"
            java.lang.String r3 = "ByteDownload"
            java.lang.String r1 = r1.optString(r2, r3)     // Catch: java.lang.Throwable -> L61
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch: java.lang.Throwable -> L61
            r0 = r6
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L61
            r6 = r0
            r0 = r6
            return r0
        L5f:
            r0 = 0
            return r0
        L61:
            r6 = move-exception
            goto L5f
        L65:
            r0 = r5
            r1 = 29
            if (r0 <= r1) goto L2e
            goto L21
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.downloadlib.addownload.x.g():java.lang.String");
    }

    public static Context getContext() {
        Context context = ox;
        if (context != null) {
            return context;
        }
        throw new IllegalArgumentException("Context is null");
    }

    public static m gm() {
        if (df == null) {
            df = new m() { // from class: com.ss.android.downloadlib.addownload.x.5
                @Override // com.ss.android.download.api.config.m
                public void mb(Context context, DownloadModel downloadModel, DownloadController downloadController, DownloadEventConfig downloadEventConfig, String str, int i) {
                }
            };
        }
        return df;
    }

    public static com.ss.android.download.api.config.lz h() {
        if (ko == null) {
            ko = new com.ss.android.download.api.mb.ox();
        }
        return ko;
    }

    public static com.ss.android.download.api.config.ww hj() {
        return u;
    }

    public static com.ss.android.download.api.config.jb io() {
        return lc;
    }

    public static com.ss.android.download.api.config.ox jb() {
        return x;
    }

    public static o je() {
        return e;
    }

    public static lc ko() {
        return o;
    }

    public static g l() {
        return f34888io;
    }

    public static com.ss.android.download.api.config.h lc() {
        return nk;
    }

    public static JSONObject lz() {
        com.ss.android.download.api.config.x xVar = ww;
        return (xVar == null || xVar.mb() == null) ? mb : ww.mb();
    }

    public static com.ss.android.download.api.ox.mb m() {
        if (gm == null) {
            gm = new com.ss.android.download.api.ox.mb() { // from class: com.ss.android.downloadlib.addownload.x.4
                @Override // com.ss.android.download.api.ox.mb
                public void mb(Throwable th, String str) {
                }
            };
        }
        return gm;
    }

    public static com.ss.android.download.api.config.ko mb() {
        return b;
    }

    public static void mb(Context context) {
        if (context == null || context.getApplicationContext() == null) {
            throw new IllegalArgumentException("Context is null");
        }
        ox = context.getApplicationContext();
    }

    public static void mb(e eVar) {
        g = eVar;
    }

    public static void mb(com.ss.android.download.api.config.je jeVar) {
        h = jeVar;
    }

    public static void mb(com.ss.android.download.api.config.ko koVar) {
        b = koVar;
    }

    public static void mb(com.ss.android.download.api.config.lz lzVar) {
        ko = lzVar;
    }

    public static void mb(com.ss.android.download.api.config.ox oxVar) {
        x = oxVar;
    }

    public static void mb(com.ss.android.download.api.config.ww wwVar) {
        u = wwVar;
    }

    public static void mb(com.ss.android.download.api.config.x xVar) {
        ww = xVar;
    }

    public static void mb(com.ss.android.download.api.model.mb mbVar) {
        lz = mbVar;
    }

    public static void mb(com.ss.android.download.api.ox.mb mbVar) {
        gm = mbVar;
    }

    public static void mb(String str) {
        com.ss.android.socialbase.appdownloader.hj.x().mb(str);
    }

    public static String nk() {
        return "1.7.0";
    }

    public static com.ss.android.download.api.config.hj o() {
        return je;
    }

    public static com.ss.android.download.api.config.b ox() {
        if (hj == null) {
            hj = new com.ss.android.download.api.config.b() { // from class: com.ss.android.downloadlib.addownload.x.1
                @Override // com.ss.android.download.api.config.b
                public void mb(Context context, DownloadModel downloadModel, DownloadController downloadController, DownloadEventConfig downloadEventConfig) {
                }

                @Override // com.ss.android.download.api.config.b
                public void mb(Context context, DownloadModel downloadModel, DownloadController downloadController, DownloadEventConfig downloadEventConfig, String str, String str2) {
                }
            };
        }
        return hj;
    }

    public static void ox(Context context) {
        if (ox != null || context == null || context.getApplicationContext() == null) {
            return;
        }
        ox = context.getApplicationContext();
    }

    public static com.ss.android.socialbase.appdownloader.b.ww u() {
        if (jb == null) {
            jb = new com.ss.android.socialbase.appdownloader.b.ww() { // from class: com.ss.android.downloadlib.addownload.x.2
                @Override // com.ss.android.socialbase.appdownloader.b.ww
                public void mb(DownloadInfo downloadInfo, BaseException baseException, int i) {
                }
            };
        }
        return jb;
    }

    public static io ww() {
        if (m == null) {
            m = new io() { // from class: com.ss.android.downloadlib.addownload.x.3
                @Override // com.ss.android.download.api.config.io
                public void mb(String str, int i, JSONObject jSONObject) {
                }
            };
        }
        return m;
    }

    public static nk x() {
        return l;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0000, code lost:
        continue;
     */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0085  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String x1672829046072dc(java.lang.String r5) {
        /*
        L0:
            r0 = 73
            r6 = r0
            r0 = 96
            r7 = r0
        L6:
            r0 = r6
            switch(r0) {
                case 72: goto L85;
                case 73: goto L23;
                case 74: goto L40;
                default: goto L20;
            }
        L20:
            goto L8e
        L23:
            r0 = r7
            switch(r0) {
                case 94: goto L0;
                case 95: goto L85;
                case 96: goto L85;
                default: goto L40;
            }
        L40:
            r0 = r7
            switch(r0) {
                case 55: goto L5f;
                case 56: goto L85;
                case 57: goto L85;
                default: goto L5c;
            }
        L5c:
            goto L0
        L5f:
            r0 = r5
            char[] r0 = r0.toCharArray()
            r5 = r0
            r0 = 0
            r6 = r0
        L66:
            r0 = r6
            r1 = r5
            int r1 = r1.length
            if (r0 >= r1) goto L7c
            r0 = r5
            r1 = r6
            r2 = r5
            r3 = r6
            char r2 = r2[r3]
            r3 = r6
            r2 = r2 ^ r3
            char r2 = (char) r2
            r0[r1] = r2
            r0 = r6
            r1 = 1
            int r0 = r0 + r1
            r6 = r0
            goto L66
        L7c:
            java.lang.String r0 = new java.lang.String
            r1 = r0
            r2 = r5
            r1.<init>(r2)
            return r0
        L85:
            r0 = 74
            r6 = r0
            r0 = 55
            r7 = r0
            goto L6
        L8e:
            r0 = 72
            r6 = r0
            goto L6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.downloadlib.addownload.x.x1672829046072dc(java.lang.String):java.lang.String");
    }
}
