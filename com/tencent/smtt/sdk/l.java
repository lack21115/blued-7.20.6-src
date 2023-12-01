package com.tencent.smtt.sdk;

import android.content.Context;
import android.net.wifi.WifiEnterpriseConfig;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.openalliance.ad.constant.ab;
import com.tencent.smtt.sdk.TbsDownloadConfig;
import com.tencent.smtt.sdk.TbsLogReport;
import com.tencent.smtt.utils.Apn;
import com.tencent.smtt.utils.FileUtil;
import com.tencent.smtt.utils.TbsLog;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/tencent/smtt/sdk/l.class */
public class l {
    private static int e = 5;
    private static int f = 1;
    private static final String[] g = {"tbs_downloading_com.tencent.mtt", "tbs_downloading_com.tencent.mm", "tbs_downloading_com.tencent.mobileqq", "tbs_downloading_com.tencent.tbs", "tbs_downloading_com.qzone"};
    private Handler A;
    private Set<String> B;
    private boolean D;

    /* renamed from: a  reason: collision with root package name */
    String f38859a;
    private Context h;
    private String i;
    private String j;
    private String k;
    private File l;
    private long m;
    private boolean p;
    private int q;
    private int r;
    private boolean s;
    private boolean t;
    private HttpURLConnection u;
    private String v;
    private TbsLogReport.TbsLogInfo w;
    private String x;
    private int y;
    private boolean z;
    private boolean d = false;
    private int n = 30000;
    private int o = 20000;
    private int C = e;
    String[] b = null;

    /* renamed from: c  reason: collision with root package name */
    int f38860c = 0;

    public l(Context context) throws NullPointerException {
        Context applicationContext = context.getApplicationContext();
        this.h = applicationContext;
        this.w = TbsLogReport.getInstance(applicationContext).tbsLogInfo();
        this.B = new HashSet();
        this.v = "tbs_downloading_" + this.h.getPackageName();
        o.a();
        File s = o.s(this.h);
        this.l = s;
        if (s == null) {
            throw new NullPointerException("TbsCorePrivateDir is null!");
        }
        g();
        this.x = null;
        this.y = -1;
    }

    private long a(long j, long j2) {
        long currentTimeMillis = System.currentTimeMillis();
        this.w.setDownConsumeTime(currentTimeMillis - j);
        this.w.setDownloadSize(j2);
        return currentTimeMillis;
    }

    static File a(Context context) {
        try {
            File file = Build.VERSION.SDK_INT >= 8 ? new File(FileUtil.a(context, 4)) : null;
            if (file != null && !file.exists() && !file.isDirectory()) {
                file.mkdirs();
            }
            return file;
        } catch (Exception e2) {
            e2.printStackTrace();
            TbsLog.e(TbsDownloader.LOGTAG, "[TbsApkDownloader.backupApkPath] Exception is " + e2.getMessage());
            return null;
        }
    }

    private static File a(Context context, int i) {
        File file = new File(FileUtil.a(context, i));
        if (file.exists() && file.isDirectory()) {
            if (new File(file, TbsDownloader.getOverSea(context) ? "x5.oversea.tbs.org" : TbsDownloader.getBackupFileName(false)).exists()) {
                return file;
            }
            return null;
        }
        return null;
    }

    private String a(Throwable th) {
        String stackTraceString = Log.getStackTraceString(th);
        String str = stackTraceString;
        if (stackTraceString.length() > 1024) {
            str = stackTraceString.substring(0, 1024);
        }
        return str;
    }

    private String a(URL url) {
        try {
            return InetAddress.getByName(url.getHost()).getHostAddress();
        } catch (Error e2) {
            e2.printStackTrace();
            return "";
        } catch (Exception e3) {
            e3.printStackTrace();
            return "";
        }
    }

    private void a(int i, String str, boolean z) {
        if (z || this.q > this.C) {
            this.w.setErrorCode(i);
            this.w.setFailDetail(str);
        }
    }

    private void a(long j) {
        this.q++;
        long j2 = j;
        if (j <= 0) {
            try {
                j2 = n();
            } catch (Exception e2) {
                return;
            }
        }
        Thread.sleep(j2);
    }

    private void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e2) {
            }
        }
    }

    public static void a(File file, Context context) {
        File file2;
        synchronized (com.tencent.smtt.utils.a.class) {
            if (file != null) {
                try {
                    if (file.exists()) {
                        if (TbsShareManager.isThirdPartyApp(context)) {
                            return;
                        }
                        try {
                            File a2 = a(context);
                            if (a2 != null) {
                                if (TbsDownloadConfig.getInstance(context).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V_TYPE, 0) == 1) {
                                    file2 = new File(a2, TbsDownloader.getBackupFileName(true));
                                } else {
                                    file2 = new File(a2, TbsDownloader.getOverSea(context) ? "x5.oversea.tbs.org" : TbsDownloader.getBackupFileName(false));
                                }
                                file2.delete();
                                FileUtil.b(file, file2);
                                boolean contains = file2.getName().contains("tbs.org");
                                boolean contains2 = file2.getName().contains("x5.tbs.decouple");
                                if (contains2 || contains) {
                                    File[] listFiles = a2.listFiles();
                                    Pattern compile = Pattern.compile(com.tencent.smtt.utils.a.a(contains2) + "(.*)");
                                    int length = listFiles.length;
                                    int i = 0;
                                    while (true) {
                                        int i2 = i;
                                        if (i2 >= length) {
                                            break;
                                        }
                                        File file3 = listFiles[i2];
                                        if (compile.matcher(file3.getName()).find() && file3.isFile() && file3.exists()) {
                                            file3.delete();
                                        }
                                        i = i2 + 1;
                                    }
                                    int i3 = TbsDownloadConfig.getInstance(context).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0);
                                    File file4 = new File(a2, com.tencent.smtt.utils.a.a(contains2) + "." + i3);
                                    if (file4.exists()) {
                                        TbsLog.e(TbsDownloader.LOGTAG, "[TbsApkDownloader.backupTbsApk]delete bacup config file error ");
                                        return;
                                    }
                                    file4.createNewFile();
                                }
                                if (TbsDownloadConfig.getInstance(context).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V_TYPE, 0) != 1 && TbsDownloadConfig.getInstance(context).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_DECOUPLECOREVERSION, 0) == com.tencent.smtt.utils.a.a(context, file)) {
                                    int i4 = TbsDownloadConfig.getInstance(context).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_RESPONSECODE, 0);
                                    if (i4 == 5 || i4 == 3) {
                                        TbsLog.i("TbsApkDownloader", "response code=" + i4 + "return backup decouple apk");
                                    }
                                    File file5 = new File(a2, TbsDownloader.getBackupFileName(true));
                                    if (com.tencent.smtt.utils.a.a(context, file) != com.tencent.smtt.utils.a.a(context, file5)) {
                                        file5.delete();
                                        FileUtil.b(file, file5);
                                    }
                                }
                            }
                        } catch (Exception e2) {
                        }
                    }
                } finally {
                }
            }
        }
    }

    private void a(String str) throws Exception {
        URL url = new URL(str);
        HttpURLConnection httpURLConnection = this.u;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Throwable th) {
                TbsLog.e(TbsDownloader.LOGTAG, "[initHttpRequest] mHttpRequest.disconnect() Throwable:" + th.toString());
            }
        }
        HttpURLConnection httpURLConnection2 = (HttpURLConnection) url.openConnection();
        this.u = httpURLConnection2;
        httpURLConnection2.setRequestProperty("User-Agent", TbsDownloader.b(this.h));
        this.u.setRequestProperty("Accept-Encoding", WifiEnterpriseConfig.IDENTITY_KEY);
        this.u.setRequestMethod("GET");
        this.u.setInstanceFollowRedirects(false);
        this.u.setConnectTimeout(this.o);
        this.u.setReadTimeout(this.n);
    }

    private boolean a(File file) {
        int i = TbsDownloadConfig.getInstance(this.h).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_USE_BACKUP_VERSION, 0);
        int i2 = i;
        if (i == 0) {
            i2 = TbsDownloadConfig.getInstance(this.h).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0);
        }
        return com.tencent.smtt.utils.a.a(this.h, file, 0L, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static File b(Context context) {
        File file = null;
        try {
            if (Build.VERSION.SDK_INT >= 8) {
                File a2 = a(context, 4);
                File file2 = a2;
                if (a2 == null) {
                    file2 = a(context, 3);
                }
                File file3 = file2;
                if (file2 == null) {
                    file3 = a(context, 2);
                }
                if (file3 == null) {
                    return a(context, 1);
                }
                file = file3;
            }
            return file;
        } catch (Exception e2) {
            e2.printStackTrace();
            TbsLog.e(TbsDownloader.LOGTAG, "[TbsApkDownloader.backupApkPath] Exception is " + e2.getMessage());
            return null;
        }
    }

    private boolean b(int i) {
        try {
            File file = new File(this.l, "x5.tbs");
            File a2 = a(this.h);
            if (a2 != null) {
                File file2 = new File(a2, TbsDownloader.getOverSea(this.h) ? "x5.oversea.tbs.org" : TbsDownloader.getBackupFileName(false));
                file.delete();
                FileUtil.b(file2, file);
                if (com.tencent.smtt.utils.a.a(this.h, file, 0L, i)) {
                    return true;
                }
                TbsLog.i(TbsDownloader.LOGTAG, "[TbsApkDownloader.copyTbsApkFromBackupToInstall] verifyTbsApk error!!");
                return false;
            }
            return false;
        } catch (Exception e2) {
            e2.printStackTrace();
            TbsLog.e(TbsDownloader.LOGTAG, "[TbsApkDownloader.copyTbsApkFromBackupToInstall] Exception is " + e2.getMessage());
            return false;
        }
    }

    public static void c(Context context) {
        try {
            o.a();
            File s = o.s(context);
            new File(s, "x5.tbs").delete();
            new File(s, "x5.tbs.temp").delete();
            File a2 = a(context);
            if (a2 == null) {
                return;
            }
            new File(a2, TbsDownloader.getBackupFileName(false)).delete();
            new File(a2, "x5.oversea.tbs.org").delete();
            File[] listFiles = a2.listFiles();
            Pattern compile = Pattern.compile(com.tencent.smtt.utils.a.a(true) + "(.*)");
            int length = listFiles.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    break;
                }
                File file = listFiles[i2];
                if (compile.matcher(file.getName()).find() && file.isFile() && file.exists()) {
                    file.delete();
                }
                i = i2 + 1;
            }
            Pattern compile2 = Pattern.compile(com.tencent.smtt.utils.a.a(false) + "(.*)");
            int length2 = listFiles.length;
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= length2) {
                    return;
                }
                File file2 = listFiles[i4];
                if (compile2.matcher(file2.getName()).find() && file2.isFile() && file2.exists()) {
                    file2.delete();
                }
                i3 = i4 + 1;
            }
        } catch (Exception e2) {
        }
    }

    private boolean c(boolean z, boolean z2) {
        boolean z3;
        TbsLog.i(TbsDownloader.LOGTAG, "[TbsApkDownloader.verifyTbsApk] isTempFile=" + z);
        File file = new File(this.l, !z ? "x5.tbs" : "x5.tbs.temp");
        if (file.exists()) {
            Exception e2 = null;
            String string = TbsDownloadConfig.getInstance(this.h).mPreferences.getString(TbsDownloadConfig.TbsConfigKey.KEY_TBSAPK_MD5, null);
            String a2 = com.tencent.smtt.utils.a.a(file);
            if (string == null || !string.equals(a2)) {
                TbsLog.i(TbsDownloader.LOGTAG, "[TbsApkDownloader.verifyTbsApk] isTempFile=" + z + " md5 failed");
                if (z) {
                    this.w.setCheckErrorDetail("fileMd5 not match");
                    return false;
                }
                return false;
            }
            TbsLog.i(TbsDownloader.LOGTAG, "[TbsApkDownloader.verifyTbsApk] md5(" + a2 + ") successful!");
            long j = 0L;
            if (z) {
                long j2 = TbsDownloadConfig.getInstance(this.h).mPreferences.getLong(TbsDownloadConfig.TbsConfigKey.KEY_TBSAPKFILESIZE, 0L);
                long j3 = 0;
                if (file.exists()) {
                    j = 0;
                    if (j2 > 0) {
                        long length = file.length();
                        j = length;
                        if (j2 != length) {
                            j3 = length;
                        }
                    }
                }
                TbsLog.i(TbsDownloader.LOGTAG, "[TbsApkDownloader.verifyTbsApk] isTempFile=" + z + " filelength failed");
                this.w.setCheckErrorDetail("fileLength:" + j3 + ",contentLength:" + j2);
                return false;
            }
            TbsLog.i(TbsDownloader.LOGTAG, "[TbsApkDownloader.verifyTbsApk] length(" + j + ") successful!");
            int i = -1;
            if (z2) {
                i = -1;
                if (!z) {
                    int a3 = com.tencent.smtt.utils.a.a(this.h, file);
                    int i2 = TbsDownloadConfig.getInstance(this.h).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0);
                    i = a3;
                    if (i2 != a3) {
                        TbsLog.i(TbsDownloader.LOGTAG, "[TbsApkDownloader.verifyTbsApk] isTempFile=" + z + " versionCode failed");
                        if (z) {
                            this.w.setCheckErrorDetail("fileVersion:" + a3 + ",configVersion:" + i2);
                            return false;
                        }
                        return false;
                    }
                }
            }
            TbsLog.i(TbsDownloader.LOGTAG, "[TbsApkDownloader.verifyTbsApk] tbsApkVersionCode(" + i + ") successful!");
            if (z2 && !z) {
                String a4 = com.tencent.smtt.utils.b.a(this.h, false, file);
                if (!"3082023f308201a8a00302010202044c46914a300d06092a864886f70d01010505003064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f301e170d3130303732313036313835305a170d3430303731333036313835305a3064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f30819f300d06092a864886f70d010101050003818d0030818902818100c209077044bd0d63ea00ede5b839914cabcc912a87f0f8b390877e0f7a2583f0d5933443c40431c35a4433bc4c965800141961adc44c9625b1d321385221fd097e5bdc2f44a1840d643ab59dc070cf6c4b4b4d98bed5cbb8046e0a7078ae134da107cdf2bfc9b440fe5cb2f7549b44b73202cc6f7c2c55b8cfb0d333a021f01f0203010001300d06092a864886f70d010105050003818100b007db9922774ef4ccfee81ba514a8d57c410257e7a2eba64bfa17c9e690da08106d32f637ac41fbc9f205176c71bde238c872c3ee2f8313502bee44c80288ea4ef377a6f2cdfe4d3653c145c4acfedbfbadea23b559d41980cc3cdd35d79a68240693739aabf5c5ed26148756cf88264226de394c8a24ac35b712b120d4d23a".equals(a4)) {
                    TbsLog.i(TbsDownloader.LOGTAG, "[TbsApkDownloader.verifyTbsApk] isTempFile=" + z + " signature failed");
                    if (z) {
                        TbsLogReport.TbsLogInfo tbsLogInfo = this.w;
                        StringBuilder sb = new StringBuilder();
                        sb.append("signature:");
                        sb.append(a4 == null ? com.igexin.push.core.b.l : Integer.valueOf(a4.length()));
                        tbsLogInfo.setCheckErrorDetail(sb.toString());
                        return false;
                    }
                    return false;
                }
            }
            TbsLog.i(TbsDownloader.LOGTAG, "[TbsApkDownloader.verifyTbsApk] signature successful!");
            boolean z4 = false;
            if (z) {
                try {
                    z3 = file.renameTo(new File(this.l, "x5.tbs"));
                } catch (Exception e3) {
                    e2 = e3;
                    z3 = false;
                }
                if (!z3) {
                    a(109, a(e2), true);
                    return false;
                }
                z4 = z3;
            }
            TbsLog.i(TbsDownloader.LOGTAG, "[TbsApkDownloader.verifyTbsApk] rename(" + z4 + ") successful!");
            return true;
        }
        return false;
    }

    private void d(boolean z) {
        Bundle a2;
        com.tencent.smtt.utils.p.a(this.h);
        TbsDownloadConfig tbsDownloadConfig = TbsDownloadConfig.getInstance(this.h);
        tbsDownloadConfig.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_FULL_PACKAGE, false);
        tbsDownloadConfig.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD, false);
        tbsDownloadConfig.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_INTERRUPT_CODE_REASON, -123);
        tbsDownloadConfig.commit();
        QbSdk.m.onDownloadFinish(z ? 100 : 120);
        int i = tbsDownloadConfig.mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_RESPONSECODE, 0);
        boolean a3 = TbsDownloader.a(this.h);
        if (i == 5) {
            Bundle a4 = a(i, a3);
            a2 = a4;
            if (a4 == null) {
                return;
            }
        } else if (i != 3 && i <= 10000) {
            o.a().a(this.h, new File(this.l, "x5.tbs").getAbsolutePath(), tbsDownloadConfig.mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0));
            a(new File(this.l, "x5.tbs"), this.h);
            return;
        } else {
            File a5 = a(this.h);
            if (a5 == null) {
                c();
                tbsDownloadConfig.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD, true);
                tbsDownloadConfig.commit();
                return;
            }
            a2 = a(i, a5, a3);
        }
        o.a().b(this.h, a2);
    }

    private boolean e(boolean z) {
        TbsLog.i(TbsDownloader.LOGTAG, "[TbsApkDownloader.deleteFile] isApk=" + z);
        File file = z ? new File(this.l, "x5.tbs") : new File(this.l, "x5.tbs.temp");
        if (file.exists()) {
            FileUtil.b(file);
            return true;
        }
        return true;
    }

    private void g() {
        this.q = 0;
        this.r = 0;
        this.m = -1L;
        this.k = null;
        this.p = false;
        this.s = false;
        this.t = false;
        this.z = false;
    }

    private void h() {
        TbsLogReport tbsLogReport;
        TbsLogReport.EventType eventType;
        TbsLog.i(TbsDownloader.LOGTAG, "[TbsApkDownloader.closeHttpRequest]");
        HttpURLConnection httpURLConnection = this.u;
        if (httpURLConnection != null) {
            if (!this.s) {
                this.w.setResolveIp(a(httpURLConnection.getURL()));
            }
            try {
                this.u.disconnect();
            } catch (Throwable th) {
                TbsLog.e(TbsDownloader.LOGTAG, "[closeHttpRequest] mHttpRequest.disconnect() Throwable:" + th.toString());
            }
            this.u = null;
        }
        int i = this.w.f38776a;
        if (this.s || !this.z) {
            if (this.d) {
                return;
            }
            TbsDownloader.f38764a = false;
            return;
        }
        this.w.setEventTime(System.currentTimeMillis());
        String apnInfo = Apn.getApnInfo(this.h);
        String str = apnInfo;
        if (apnInfo == null) {
            str = "";
        }
        int apnType = Apn.getApnType(this.h);
        this.w.setApn(str);
        this.w.setNetworkType(apnType);
        if (apnType != this.y || !str.equals(this.x)) {
            this.w.setNetworkChange(0);
        }
        if ((this.w.f38776a == 0 || this.w.f38776a == 107) && this.w.getDownFinalFlag() == 0 && (!Apn.isNetworkAvailable(this.h) || !m())) {
            a(101, (String) null, true);
        }
        if (TbsDownloader.a(this.h)) {
            tbsLogReport = TbsLogReport.getInstance(this.h);
            eventType = TbsLogReport.EventType.TYPE_DOWNLOAD_DECOUPLE;
        } else {
            tbsLogReport = TbsLogReport.getInstance(this.h);
            eventType = TbsLogReport.EventType.TYPE_DOWNLOAD;
        }
        tbsLogReport.eventReport(eventType, this.w);
        this.w.resetArgs();
        if (i != 100) {
            QbSdk.m.onDownloadFinish(i);
        }
    }

    private File i() {
        File file = new File(FileUtil.a(this.h, 4), TbsDownloader.getOverSea(this.h) ? "x5.oversea.tbs.org" : TbsDownloader.getBackupFileName(false));
        if (TbsDownloader.a(this.h)) {
            file = new File(FileUtil.a(this.h, 4), TbsDownloader.getBackupFileName(true));
        }
        return file;
    }

    private void j() {
        try {
            File i = i();
            if (i == null || !i.exists()) {
                return;
            }
            FileUtil.b(i);
            File[] listFiles = i.getParentFile().listFiles();
            Pattern compile = Pattern.compile(com.tencent.smtt.utils.a.a(TbsDownloader.a(this.h)) + "(.*)");
            int length = listFiles.length;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= length) {
                    return;
                }
                File file = listFiles[i3];
                if (compile.matcher(file.getName()).find() && file.isFile() && file.exists()) {
                    FileUtil.b(file);
                }
                i2 = i3 + 1;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private boolean k() {
        return new File(this.l, "x5.tbs.temp").exists();
    }

    private long l() {
        File file = new File(this.l, "x5.tbs.temp");
        if (file.exists()) {
            return file.length();
        }
        return 0L;
    }

    private boolean m() {
        InputStreamReader inputStreamReader;
        BufferedReader bufferedReader;
        InputStream inputStream;
        BufferedReader bufferedReader2;
        boolean z;
        InputStreamReader inputStreamReader2;
        InputStream inputStream2;
        try {
            inputStream = Runtime.getRuntime().exec("ping www.qq.com").getInputStream();
            try {
                inputStreamReader = new InputStreamReader(inputStream);
                try {
                    bufferedReader = new BufferedReader(inputStreamReader);
                    int i = 0;
                    while (true) {
                        try {
                            String readLine = bufferedReader.readLine();
                            inputStream2 = inputStream;
                            inputStreamReader2 = inputStreamReader;
                            z = false;
                            bufferedReader2 = bufferedReader;
                            if (readLine != null) {
                                if (!readLine.contains("TTL") && !readLine.contains(RemoteMessageConst.TTL)) {
                                    int i2 = i + 1;
                                    i = i2;
                                    if (i2 >= 5) {
                                        inputStream2 = inputStream;
                                        inputStreamReader2 = inputStreamReader;
                                        z = false;
                                        bufferedReader2 = bufferedReader;
                                        break;
                                    }
                                } else {
                                    break;
                                }
                            } else {
                                break;
                            }
                        } catch (Throwable th) {
                            th = th;
                            try {
                                th.printStackTrace();
                                bufferedReader2 = bufferedReader;
                                z = false;
                                inputStreamReader2 = inputStreamReader;
                                inputStream2 = inputStream;
                                a(inputStream2);
                                a(inputStreamReader2);
                                a(bufferedReader2);
                                return z;
                            } catch (Throwable th2) {
                                a(inputStream);
                                a(inputStreamReader);
                                a(bufferedReader);
                                throw th2;
                            }
                        }
                    }
                    z = true;
                    inputStream2 = inputStream;
                    inputStreamReader2 = inputStreamReader;
                    bufferedReader2 = bufferedReader;
                } catch (Throwable th3) {
                    th = th3;
                    bufferedReader = null;
                }
            } catch (Throwable th4) {
                th = th4;
                bufferedReader = null;
                inputStreamReader = null;
            }
        } catch (Throwable th5) {
            th = th5;
            inputStreamReader = null;
            bufferedReader = null;
            inputStream = null;
        }
        a(inputStream2);
        a(inputStreamReader2);
        a(bufferedReader2);
        return z;
    }

    private long n() {
        int i = this.q;
        return (i == 1 || i == 2) ? this.q * 20000 : (i == 3 || i == 4) ? 100000L : 200000L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean o() {
        HttpURLConnection httpURLConnection;
        boolean z = Apn.getApnType(this.h) == 3;
        TbsLog.i(TbsDownloader.LOGTAG, "[TbsApkDwonloader.detectWifiNetworkAvailable] isWifi=" + z);
        String str = null;
        HttpURLConnection httpURLConnection2 = null;
        boolean z2 = false;
        if (z) {
            str = Apn.getWifiSSID(this.h);
            TbsLog.i(TbsDownloader.LOGTAG, "[TbsApkDwonloader.detectWifiNetworkAvailable] localBSSID=" + str);
            try {
                httpURLConnection = (HttpURLConnection) new URL("https://pms.mb.qq.com/rsp204").openConnection();
            } catch (Throwable th) {
                th = th;
            }
            try {
                httpURLConnection.setInstanceFollowRedirects(false);
                httpURLConnection.setConnectTimeout(10000);
                httpURLConnection.setReadTimeout(10000);
                httpURLConnection.setUseCaches(false);
                httpURLConnection.getInputStream();
                int responseCode = httpURLConnection.getResponseCode();
                TbsLog.i(TbsDownloader.LOGTAG, "[TbsApkDwonloader.detectWifiNetworkAvailable] responseCode=" + responseCode);
                boolean z3 = responseCode == 204;
                if (httpURLConnection != null) {
                    try {
                        httpURLConnection.disconnect();
                    } catch (Exception e2) {
                    }
                }
                z2 = z3;
            } catch (Throwable th2) {
                httpURLConnection2 = httpURLConnection;
                th = th2;
                try {
                    th.printStackTrace();
                    if (httpURLConnection2 != null) {
                        try {
                            httpURLConnection2.disconnect();
                        } catch (Exception e3) {
                        }
                    }
                    z2 = false;
                    if (!z2) {
                        this.B.add(str);
                        p();
                        this.A.sendMessageDelayed(this.A.obtainMessage(150, str), com.igexin.push.config.c.l);
                    }
                    if (z2) {
                        this.B.remove(str);
                    }
                    return z2;
                } catch (Throwable th3) {
                    if (httpURLConnection2 != null) {
                        try {
                            httpURLConnection2.disconnect();
                        } catch (Exception e4) {
                        }
                    }
                    throw th3;
                }
            }
        }
        if (!z2 && !TextUtils.isEmpty(str) && !this.B.contains(str)) {
            this.B.add(str);
            p();
            this.A.sendMessageDelayed(this.A.obtainMessage(150, str), com.igexin.push.config.c.l);
        }
        if (z2 && this.B.contains(str)) {
            this.B.remove(str);
        }
        return z2;
    }

    private void p() {
        if (this.A == null) {
            this.A = new Handler(n.a().getLooper()) { // from class: com.tencent.smtt.sdk.l.1
                @Override // android.os.Handler
                public void handleMessage(Message message) {
                    if (message.what == 150) {
                        l.this.o();
                    }
                }
            };
        }
    }

    public Bundle a(int i, File file, boolean z) {
        File file2;
        if (z) {
            file2 = new File(file, TbsDownloader.getBackupFileName(true));
        } else {
            file2 = new File(file, TbsDownloader.getOverSea(this.h) ? "x5.oversea.tbs.org" : TbsDownloader.getBackupFileName(false));
        }
        int a2 = com.tencent.smtt.utils.a.a(this.h, file2);
        File file3 = new File(this.l, "x5.tbs");
        String absolutePath = file3.exists() ? file3.getAbsolutePath() : null;
        int i2 = TbsDownloadConfig.getInstance(this.h).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0);
        Bundle bundle = new Bundle();
        bundle.putInt("operation", i);
        bundle.putInt("old_core_ver", a2);
        bundle.putInt("new_core_ver", i2);
        bundle.putString("old_apk_location", file2.getAbsolutePath());
        bundle.putString("new_apk_location", absolutePath);
        bundle.putString("diff_file_location", absolutePath);
        return bundle;
    }

    public Bundle a(int i, boolean z) {
        File q;
        int i2;
        o a2;
        Context context;
        int i3;
        o a3 = o.a();
        Context context2 = this.h;
        if (z) {
            q = a3.p(context2);
            i2 = o.a().h(this.h);
        } else {
            q = a3.q(context2);
            i2 = o.a().i(this.h);
        }
        File file = new File(this.l, "x5.tbs");
        String absolutePath = file.exists() ? file.getAbsolutePath() : null;
        if (absolutePath == null) {
            return null;
        }
        int i4 = TbsDownloadConfig.getInstance(this.h).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0);
        if (z) {
            a2 = o.a();
            context = this.h;
            i3 = 6;
        } else {
            a2 = o.a();
            context = this.h;
            i3 = 5;
        }
        File f2 = a2.f(context, i3);
        Bundle bundle = new Bundle();
        bundle.putInt("operation", i);
        bundle.putInt("old_core_ver", i2);
        bundle.putInt("new_core_ver", i4);
        bundle.putString("old_apk_location", q.getAbsolutePath());
        bundle.putString("new_apk_location", f2.getAbsolutePath());
        bundle.putString("diff_file_location", absolutePath);
        String a4 = FileUtil.a(this.h, 7);
        File file2 = new File(a4);
        if (!file2.exists()) {
            file2.mkdirs();
        }
        bundle.putString("backup_apk", new File(a4, i4 + ".tbs").getAbsolutePath());
        return bundle;
    }

    public void a(int i) {
        if (o.a().t(this.h)) {
            o.a().b();
            try {
                File file = new File(this.l, "x5.tbs");
                int a2 = com.tencent.smtt.utils.a.a(this.h, file);
                if (-1 == a2 || (i > 0 && i == a2)) {
                    FileUtil.b(file);
                }
            } catch (Exception e2) {
            }
        }
    }

    public void a(boolean z) {
        b(z, false);
    }

    public boolean a() {
        TbsLog.i("TbsApkDownloader", "verifyAndInstallDecoupleCoreFromBackup #1");
        try {
            File file = new File(FileUtil.a(this.h, 4), TbsDownloader.getBackupFileName(true));
            if (file.exists()) {
                TbsLog.i("TbsApkDownloader", "verifyAndInstallDecoupleCoreFromBackup #2");
            } else {
                File b = TbsDownloader.b(TbsDownloadConfig.getInstance(this.h).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_DECOUPLECOREVERSION, -1));
                if (b != null && b.exists()) {
                    FileUtil.b(b, file);
                }
            }
            if (com.tencent.smtt.utils.a.a(this.h, file, 0L, TbsDownloadConfig.getInstance(this.h).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_DECOUPLECOREVERSION, -1))) {
                TbsLog.i("TbsApkDownloader", "verifyAndInstallDecoupleCoreFromBackup #3");
                return o.a().e(this.h);
            }
            return false;
        } catch (Exception e2) {
            return false;
        }
    }

    public boolean a(boolean z, boolean z2) {
        String str;
        boolean z3;
        File i;
        TbsLogReport tbsLogReport;
        TbsLogReport.EventType eventType;
        if (Build.VERSION.SDK_INT == 23) {
            return false;
        }
        int i2 = TbsDownloadConfig.getInstance(this.h).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_USE_BACKUP_VERSION, 0);
        int i3 = o.a().i(this.h);
        if (i2 == 0) {
            i2 = TbsDownloadConfig.getInstance(this.h).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0);
            str = "by default key";
        } else {
            str = "by new key";
        }
        this.f38859a = str;
        if (i2 == 0 || i2 == i3) {
            return false;
        }
        if (z2) {
            File a2 = TbsDownloader.a(i2);
            if (a2 != null && a2.exists()) {
                File file = new File(FileUtil.a(this.h, 4), TbsDownloader.getOverSea(this.h) ? "x5.oversea.tbs.org" : TbsDownloader.getBackupFileName(false));
                try {
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                if (TbsDownloadConfig.getInstance(this.h).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V_TYPE, 0) != 1) {
                    FileUtil.b(a2, file);
                    z3 = true;
                    i = i();
                    if (i != null || !i.exists() || !a(i)) {
                        j();
                        if (a2 != null && a2.exists() && !com.tencent.smtt.utils.a.a(this.h, a2, 0L, i2) && a2 != null && a2.exists()) {
                            FileUtil.b(a2);
                        }
                    } else if (b(i2)) {
                        TbsDownloadConfig.getInstance(this.h).mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_INTERRUPT_CODE_REASON, -214);
                        TbsDownloadConfig.getInstance(this.h).setDownloadInterruptCode(-214);
                        d(false);
                        if (z3) {
                            a(100, "use local backup apk in startDownload" + this.f38859a, true);
                            if (TbsDownloader.a(this.h)) {
                                tbsLogReport = TbsLogReport.getInstance(this.h);
                                eventType = TbsLogReport.EventType.TYPE_DOWNLOAD_DECOUPLE;
                            } else {
                                tbsLogReport = TbsLogReport.getInstance(this.h);
                                eventType = TbsLogReport.EventType.TYPE_DOWNLOAD;
                            }
                            tbsLogReport.eventReport(eventType, this.w);
                            this.w.resetArgs();
                            return true;
                        }
                        return true;
                    }
                }
            }
            z3 = false;
            i = i();
            if (i != null) {
            }
            j();
            if (a2 != null) {
                FileUtil.b(a2);
            }
        }
        if (c(false, z2)) {
            TbsDownloadConfig.getInstance(this.h).mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_INTERRUPT_CODE_REASON, -214);
            TbsDownloadConfig.getInstance(this.h).setDownloadInterruptCode(-214);
            d(false);
            return true;
        } else if (e(true) || e(true)) {
            return false;
        } else {
            TbsLog.e(TbsDownloader.LOGTAG, "[TbsApkDownloader] delete file failed!");
            TbsDownloadConfig.getInstance(this.h).setDownloadInterruptCode(ab.I);
            return false;
        }
    }

    public void b() {
        TbsLogReport tbsLogReport;
        TbsLogReport.EventType eventType;
        this.s = true;
        if (TbsShareManager.isThirdPartyApp(this.h)) {
            TbsLogReport.TbsLogInfo tbsLogInfo = TbsLogReport.getInstance(this.h).tbsLogInfo();
            tbsLogInfo.setErrorCode(-309);
            tbsLogInfo.setFailDetail(new Exception());
            if (TbsDownloader.a(this.h)) {
                tbsLogReport = TbsLogReport.getInstance(this.h);
                eventType = TbsLogReport.EventType.TYPE_DOWNLOAD_DECOUPLE;
            } else {
                tbsLogReport = TbsLogReport.getInstance(this.h);
                eventType = TbsLogReport.EventType.TYPE_DOWNLOAD;
            }
            tbsLogReport.eventReport(eventType, tbsLogInfo);
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    public void b(boolean z, boolean z2) {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    public boolean b(boolean z) {
        String[] strArr;
        int i;
        if ((!z || o() || (QbSdk.getDownloadWithoutWifi() && Apn.isNetworkAvailable(this.h))) && (strArr = this.b) != null && (i = this.f38860c) >= 0 && i < strArr.length) {
            this.f38860c = i + 1;
            this.k = strArr[i];
            this.q = 0;
            this.r = 0;
            this.m = -1L;
            this.p = false;
            this.s = false;
            this.t = false;
            this.z = false;
            return true;
        }
        return false;
    }

    public int c(boolean z) {
        File a2 = a(this.h);
        if (z) {
            if (a2 == null) {
                return 0;
            }
            return com.tencent.smtt.utils.a.a(this.h, new File(a2, TbsDownloader.getBackupFileName(true)));
        } else if (a2 == null) {
            return 0;
        } else {
            return com.tencent.smtt.utils.a.a(this.h, new File(a2, TbsDownloader.getOverSea(this.h) ? "x5.oversea.tbs.org" : TbsDownloader.getBackupFileName(false)));
        }
    }

    public void c() {
        b();
        e(false);
        e(true);
    }

    public boolean d() {
        TbsLog.i(TbsDownloader.LOGTAG, "[TbsApkDownloader.isDownloadForeground] mIsDownloadForeground=" + this.D);
        return this.D;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e() {
        TbsLog.i(TbsDownloader.LOGTAG, "pauseDownload,isPause=" + this.d + "isDownloading=" + TbsDownloader.isDownloading());
        if (this.d || !TbsDownloader.isDownloading()) {
            return;
        }
        b();
        this.d = true;
        this.z = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f() {
        TbsLog.i(TbsDownloader.LOGTAG, "resumeDownload,isPause=" + this.d + "isDownloading=" + TbsDownloader.isDownloading());
        if (this.d && TbsDownloader.isDownloading()) {
            this.d = false;
            a(false);
        }
    }
}
