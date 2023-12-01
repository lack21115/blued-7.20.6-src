package com.tencent.smtt.sdk;

import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.wifi.WifiEnterpriseConfig;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.Log;
import com.tencent.smtt.sdk.TbsDownloadConfig;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.f;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.json.JSONArray;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/smtt/sdk/TbsLogReport.class */
public class TbsLogReport {

    /* renamed from: a  reason: collision with root package name */
    private static TbsLogReport f25079a;
    private Handler b;

    /* renamed from: c  reason: collision with root package name */
    private Context f25080c;
    private boolean d = false;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/smtt/sdk/TbsLogReport$EventType.class */
    public enum EventType {
        TYPE_DOWNLOAD(0),
        TYPE_INSTALL(1),
        TYPE_LOAD(2),
        TYPE_DOWNLOAD_DECOUPLE(3),
        TYPE_INSTALL_DECOUPLE(4),
        TYPE_COOKIE_DB_SWITCH(5),
        TYPE_SDK_REPORT_INFO(6);
        

        /* renamed from: a  reason: collision with root package name */
        int f25084a;

        EventType(int i) {
            this.f25084a = i;
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo.class */
    public static class TbsLogInfo implements Cloneable {

        /* renamed from: a  reason: collision with root package name */
        int f25085a;
        private long b;

        /* renamed from: c  reason: collision with root package name */
        private String f25086c;
        private String d;
        private int e;
        private int f;
        private int g;
        private int h;
        private String i;
        private int j;
        private int k;
        private long l;
        private long m;
        private int n;
        private String o;
        private String p;
        private long q;

        private TbsLogInfo() {
            resetArgs();
        }

        protected Object clone() {
            try {
                return super.clone();
            } catch (CloneNotSupportedException e) {
                return this;
            }
        }

        public int getDownFinalFlag() {
            return this.k;
        }

        public void resetArgs() {
            this.b = 0L;
            this.f25086c = null;
            this.d = null;
            this.e = 0;
            this.f = 0;
            this.g = 0;
            this.h = 2;
            this.i = "unknown";
            this.j = 0;
            this.k = 2;
            this.l = 0L;
            this.m = 0L;
            this.n = 1;
            this.f25085a = 0;
            this.o = null;
            this.p = null;
            this.q = 0L;
        }

        public void setApn(String str) {
            this.i = str;
        }

        public void setCheckErrorDetail(String str) {
            setErrorCode(108);
            this.o = str;
        }

        public void setDownConsumeTime(long j) {
            this.m += j;
        }

        public void setDownFinalFlag(int i) {
            this.k = i;
        }

        public void setDownloadCancel(int i) {
            this.g = i;
        }

        public void setDownloadSize(long j) {
            this.q += j;
        }

        public void setDownloadUrl(String str) {
            if (this.f25086c != null) {
                str = this.f25086c + com.huawei.openalliance.ad.constant.t.aE + str;
            }
            this.f25086c = str;
        }

        public void setErrorCode(int i) {
            if (i != 100 && i != 110 && i != 120 && i != 111 && i < 400) {
                TbsLog.i(TbsDownloader.LOGTAG, "error occured, errorCode:" + i, true);
            }
            if (i == 111) {
                TbsLog.i(TbsDownloader.LOGTAG, "you are not in wifi, downloading stoped", true);
            }
            this.f25085a = i;
        }

        public void setEventTime(long j) {
            this.b = j;
        }

        public void setFailDetail(String str) {
            if (str == null) {
                return;
            }
            String str2 = str;
            if (str.length() > 1024) {
                str2 = str.substring(0, 1024);
            }
            this.p = str2;
        }

        public void setFailDetail(Throwable th) {
            if (th == null) {
                this.p = "";
                return;
            }
            String stackTraceString = Log.getStackTraceString(th);
            String str = stackTraceString;
            if (stackTraceString.length() > 1024) {
                str = stackTraceString.substring(0, 1024);
            }
            this.p = str;
        }

        public void setHttpCode(int i) {
            this.e = i;
        }

        public void setNetworkChange(int i) {
            this.n = i;
        }

        public void setNetworkType(int i) {
            this.j = i;
        }

        public void setPatchUpdateFlag(int i) {
            this.f = i;
        }

        public void setPkgSize(long j) {
            this.l = j;
        }

        public void setResolveIp(String str) {
            this.d = str;
        }

        public void setUnpkgFlag(int i) {
            this.h = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/smtt/sdk/TbsLogReport$a.class */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private final String f25087a;
        private final String b;

        public a(String str, String str2) {
            this.f25087a = str;
            this.b = str2;
        }

        private static void a(File file) throws IOException {
            RandomAccessFile randomAccessFile;
            RandomAccessFile randomAccessFile2 = null;
            try {
                try {
                    try {
                        randomAccessFile = new RandomAccessFile(file, "rw");
                        try {
                            int parseInt = Integer.parseInt("00001000", 2);
                            randomAccessFile.seek(7L);
                            int read = randomAccessFile.read();
                            if ((read & parseInt) > 0) {
                                randomAccessFile.seek(7L);
                                randomAccessFile.write(parseInt & 255 & read);
                            }
                            randomAccessFile.close();
                        } catch (Exception e) {
                            e = e;
                            randomAccessFile2 = randomAccessFile;
                            e.printStackTrace();
                            if (randomAccessFile != null) {
                                randomAccessFile.close();
                            }
                        } catch (Throwable th) {
                            randomAccessFile2 = randomAccessFile;
                            th = th;
                            if (randomAccessFile2 != null) {
                                try {
                                    randomAccessFile2.close();
                                } catch (IOException e2) {
                                    e2.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (Exception e3) {
                    e = e3;
                    randomAccessFile = null;
                }
            } catch (IOException e4) {
                e4.printStackTrace();
            }
        }

        /* JADX WARN: Can't wrap try/catch for region: R(17:11|12|13|14|15|16|17|18|19|(14:20|21|(5:22|23|24|25|(2:27|28)(1:29))|30|31|32|33|34|35|36|37|38|39|40)|41|42|43|44|45|46|47) */
        /* JADX WARN: Code restructure failed: missing block: B:67:0x0176, code lost:
            r9 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:68:0x0177, code lost:
            r9.printStackTrace();
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Not initialized variable reg: 11, insn: 0x0224: MOVE  (r0 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r11 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), block:B:115:0x0224 */
        /* JADX WARN: Removed duplicated region for block: B:52:0x0126  */
        /* JADX WARN: Removed duplicated region for block: B:59:0x0147  */
        /* JADX WARN: Type inference failed for: r0v44, types: [java.io.FileInputStream] */
        /* JADX WARN: Type inference failed for: r0v50, types: [java.io.BufferedInputStream] */
        /* JADX WARN: Type inference failed for: r9v15 */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void a() {
            /*
                Method dump skipped, instructions count: 589
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.TbsLogReport.a.a():void");
        }
    }

    private TbsLogReport(Context context) {
        this.b = null;
        this.f25080c = context.getApplicationContext();
        HandlerThread handlerThread = new HandlerThread("TbsLogReportThread");
        handlerThread.start();
        this.b = new Handler(handlerThread.getLooper()) { // from class: com.tencent.smtt.sdk.TbsLogReport.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what != 600) {
                    if (message.what == 601) {
                        TbsLogReport.this.b();
                    }
                } else if (message.obj instanceof TbsLogInfo) {
                    try {
                        TbsLogInfo tbsLogInfo = (TbsLogInfo) message.obj;
                        TbsLogReport.this.a(message.arg1, tbsLogInfo);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        };
    }

    private String a(int i) {
        return i + "|";
    }

    private String a(long j) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date(j));
        } catch (Exception e) {
            return null;
        }
    }

    private String a(String str) {
        StringBuilder sb = new StringBuilder();
        String str2 = str;
        if (str == null) {
            str2 = "";
        }
        sb.append(str2);
        sb.append("|");
        return sb.toString();
    }

    private JSONArray a() {
        String string = d().getString("tbs_download_upload", null);
        if (string == null) {
            return new JSONArray();
        }
        try {
            JSONArray jSONArray = new JSONArray(string);
            if (jSONArray.length() > 5) {
                JSONArray jSONArray2 = new JSONArray();
                int length = jSONArray.length() - 1;
                if (length > jSONArray.length() - 5) {
                    jSONArray2.put(jSONArray.get(length));
                    return jSONArray2;
                }
            }
            return jSONArray;
        } catch (Exception e) {
            return new JSONArray();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, TbsLogInfo tbsLogInfo) {
        StringBuilder sb = new StringBuilder();
        sb.append(a(i));
        sb.append(a(com.tencent.smtt.utils.b.f(this.f25080c)));
        sb.append(a(com.tencent.smtt.utils.j.a(this.f25080c)));
        sb.append(a(o.a().i(this.f25080c)));
        String str = Build.MODEL;
        try {
            str = new String(str.getBytes("UTF-8"), "ISO8859-1");
        } catch (Exception e) {
        }
        sb.append(a(str));
        String packageName = this.f25080c.getPackageName();
        sb.append(a(packageName));
        sb.append("com.tencent.mm".equals(packageName) ? a(com.tencent.smtt.utils.b.a(this.f25080c, TbsDownloader.TBS_METADATA)) : a(com.tencent.smtt.utils.b.d(this.f25080c)));
        sb.append(a(a(tbsLogInfo.b)));
        sb.append(a(tbsLogInfo.f25086c));
        sb.append(a(tbsLogInfo.d));
        sb.append(a(tbsLogInfo.e));
        sb.append(a(tbsLogInfo.f));
        sb.append(a(tbsLogInfo.g));
        sb.append(a(tbsLogInfo.h));
        sb.append(a(tbsLogInfo.i));
        sb.append(a(tbsLogInfo.j));
        sb.append(a(tbsLogInfo.k));
        sb.append(b(tbsLogInfo.q));
        sb.append(b(tbsLogInfo.l));
        sb.append(b(tbsLogInfo.m));
        sb.append(a(tbsLogInfo.n));
        sb.append(a(tbsLogInfo.f25085a));
        sb.append(a(tbsLogInfo.o));
        sb.append(a(tbsLogInfo.p));
        sb.append(a(TbsDownloadConfig.getInstance(this.f25080c).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0)));
        sb.append(a(com.tencent.smtt.utils.b.i(this.f25080c)));
        sb.append(a("4.3.0.67_43967"));
        sb.append(false);
        SharedPreferences d = d();
        JSONArray a2 = a();
        JSONArray jSONArray = new JSONArray();
        JSONArray jSONArray2 = a2;
        if (jSONArray.length() >= 5) {
            int i2 = 4;
            while (true) {
                int i3 = i2;
                if (i3 < 1) {
                    break;
                }
                try {
                    jSONArray.put(a2.get(jSONArray.length() - i3));
                } catch (Exception e2) {
                    TbsLog.e(ContentResolver.SYNC_EXTRAS_UPLOAD, "JSONArray transform error!");
                }
                i2 = i3 - 1;
            }
            jSONArray2 = jSONArray;
        }
        jSONArray2.put(sb.toString());
        SharedPreferences.Editor edit = d.edit();
        edit.putString("tbs_download_upload", jSONArray2.toString());
        edit.commit();
        if (this.d || i != EventType.TYPE_LOAD.f25084a) {
            b();
        }
    }

    private void a(int i, TbsLogInfo tbsLogInfo, EventType eventType) {
        tbsLogInfo.setErrorCode(i);
        tbsLogInfo.setEventTime(System.currentTimeMillis());
        QbSdk.m.onInstallFinish(i);
        eventReport(eventType, tbsLogInfo);
    }

    private String b(long j) {
        return j + "|";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        String str;
        String str2;
        if (QbSdk.n != null && QbSdk.n.containsKey(QbSdk.KEY_SET_SENDREQUEST_AND_UPLOAD) && QbSdk.n.get(QbSdk.KEY_SET_SENDREQUEST_AND_UPLOAD).equals("false")) {
            str = ContentResolver.SYNC_EXTRAS_UPLOAD;
            str2 = "[TbsLogReport.sendLogReportRequest] -- SET_SENDREQUEST_AND_UPLOAD is false";
        } else {
            str = TbsDownloader.LOGTAG;
            TbsLog.i(TbsDownloader.LOGTAG, "[TbsApkDownloadStat.reportDownloadStat]");
            JSONArray a2 = a();
            if (a2 != null && a2.length() != 0) {
                TbsLog.i(TbsDownloader.LOGTAG, "[TbsApkDownloadStat.reportDownloadStat] jsonArray:" + a2);
                try {
                    String a3 = com.tencent.smtt.utils.f.a(com.tencent.smtt.utils.m.a(this.f25080c).c(), a2.toString().getBytes("utf-8"), new f.a() { // from class: com.tencent.smtt.sdk.TbsLogReport.3
                        @Override // com.tencent.smtt.utils.f.a
                        public void a(int i) {
                            TbsLog.i(TbsDownloader.LOGTAG, "[TbsApkDownloadStat.reportDownloadStat] onHttpResponseCode:" + i);
                            if (i < 300) {
                                TbsLogReport.this.c();
                            }
                        }
                    }, true);
                    TbsLog.i(TbsDownloader.LOGTAG, "[TbsApkDownloadStat.reportDownloadStat] response:" + a3 + " testcase: -1");
                    return;
                } catch (Throwable th) {
                    th.printStackTrace();
                    return;
                }
            }
            str2 = "[TbsApkDownloadStat.reportDownloadStat] no data";
        }
        TbsLog.i(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        SharedPreferences.Editor edit = d().edit();
        edit.remove("tbs_download_upload");
        edit.commit();
    }

    private SharedPreferences d() {
        return this.f25080c.getSharedPreferences("tbs_download_stat", 4);
    }

    public static TbsLogReport getInstance(Context context) {
        if (f25079a == null) {
            synchronized (TbsLogReport.class) {
                try {
                    if (f25079a == null) {
                        f25079a = new TbsLogReport(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f25079a;
    }

    public void clear() {
        try {
            SharedPreferences.Editor edit = d().edit();
            edit.clear();
            edit.commit();
        } catch (Exception e) {
        }
    }

    public void dailyReport() {
        this.b.sendEmptyMessage(601);
    }

    public void eventReport(EventType eventType, TbsLogInfo tbsLogInfo) {
        try {
            TbsLogInfo tbsLogInfo2 = (TbsLogInfo) tbsLogInfo.clone();
            Message obtainMessage = this.b.obtainMessage();
            obtainMessage.what = 600;
            obtainMessage.arg1 = eventType.f25084a;
            obtainMessage.obj = tbsLogInfo2;
            this.b.sendMessage(obtainMessage);
        } catch (Throwable th) {
            TbsLog.w(ContentResolver.SYNC_EXTRAS_UPLOAD, "[TbsLogReport.eventReport] error, message=" + th.getMessage());
        }
    }

    public boolean getShouldUploadEventReport() {
        return this.d;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0220 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:107:0x022c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x023a  */
    /* JADX WARN: Type inference failed for: r0v58, types: [java.io.ByteArrayOutputStream] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void reportTbsLog() {
        /*
            Method dump skipped, instructions count: 710
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.TbsLogReport.reportTbsLog():void");
    }

    public void setInstallErrorCode(int i, String str) {
        setInstallErrorCode(i, str, EventType.TYPE_INSTALL);
    }

    public void setInstallErrorCode(int i, String str, EventType eventType) {
        if (i != 200 && i != 220 && i != 221) {
            TbsLog.i(TbsDownloader.LOGTAG, "error occured in installation, errorCode:" + i, true);
        }
        TbsLogInfo tbsLogInfo = tbsLogInfo();
        tbsLogInfo.setFailDetail(str);
        a(i, tbsLogInfo, eventType);
    }

    public void setInstallErrorCode(int i, Throwable th) {
        TbsLogInfo tbsLogInfo = tbsLogInfo();
        tbsLogInfo.setFailDetail(th);
        a(i, tbsLogInfo, EventType.TYPE_INSTALL);
    }

    public void setLoadErrorCode(int i, String str) {
        TbsLogInfo tbsLogInfo = tbsLogInfo();
        tbsLogInfo.setErrorCode(i);
        tbsLogInfo.setEventTime(System.currentTimeMillis());
        tbsLogInfo.setFailDetail(str);
        eventReport(EventType.TYPE_LOAD, tbsLogInfo);
    }

    public void setLoadErrorCode(int i, Throwable th) {
        String str;
        if (th != null) {
            String str2 = "msg: " + th.getMessage() + "; err: " + th + "; cause: " + Log.getStackTraceString(th.getCause());
            str = str2;
            if (str2.length() > 1024) {
                str = str2.substring(0, 1024);
            }
        } else {
            str = WifiEnterpriseConfig.EMPTY_VALUE;
        }
        setLoadErrorCode(i, str);
    }

    public void setShouldUploadEventReport(boolean z) {
        this.d = z;
    }

    public TbsLogInfo tbsLogInfo() {
        return new TbsLogInfo();
    }
}
