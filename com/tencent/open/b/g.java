package com.tencent.open.b;

import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import android.provider.BrowserContract;
import android.text.TextUtils;
import com.opos.process.bridge.provider.ProcessBridgeProvider;
import com.tencent.connect.common.Constants;
import com.tencent.open.utils.Global;
import com.tencent.open.utils.OpenConfig;
import com.tencent.open.utils.ThreadManager;
import com.tencent.open.utils.Util;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.TimeZone;
import java.util.concurrent.Executor;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/open/b/g.class */
public class g {

    /* renamed from: a  reason: collision with root package name */
    protected static g f38249a;
    protected HandlerThread e;
    protected Handler f;
    protected Random b = new Random();
    protected List<Serializable> d = Collections.synchronizedList(new ArrayList());

    /* renamed from: c  reason: collision with root package name */
    protected List<Serializable> f38250c = Collections.synchronizedList(new ArrayList());
    protected Executor g = ThreadManager.newSerialExecutor();
    protected Executor h = ThreadManager.newSerialExecutor();

    private g() {
        this.e = null;
        if (this.e == null) {
            HandlerThread handlerThread = new HandlerThread("opensdk.report.handlerthread", 10);
            this.e = handlerThread;
            handlerThread.start();
        }
        if (!this.e.isAlive() || this.e.getLooper() == null) {
            return;
        }
        this.f = new Handler(this.e.getLooper()) { // from class: com.tencent.open.b.g.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                int i = message.what;
                if (i == 1000) {
                    g.this.b();
                } else if (i == 1001) {
                    g.this.e();
                }
                super.handleMessage(message);
            }
        };
    }

    public static g a() {
        g gVar;
        synchronized (g.class) {
            try {
                if (f38249a == null) {
                    f38249a = new g();
                }
                gVar = f38249a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return gVar;
    }

    protected int a(int i) {
        int i2;
        if (i == 0) {
            int i3 = OpenConfig.getInstance(Global.getContext(), null).getInt("Common_CGIReportFrequencySuccess");
            i2 = i3;
            if (i3 == 0) {
                return 10;
            }
        } else {
            int i4 = OpenConfig.getInstance(Global.getContext(), null).getInt("Common_CGIReportFrequencyFailed");
            i2 = i4;
            if (i4 == 0) {
                i2 = 100;
            }
        }
        return i2;
    }

    public void a(final Bundle bundle, String str, final boolean z) {
        if (bundle == null) {
            return;
        }
        com.tencent.open.a.f.a("openSDK_LOG.ReportManager", "-->reportVia, bundle: " + bundle.toString());
        if (a("report_via", str) || z) {
            this.g.execute(new Runnable() { // from class: com.tencent.open.b.g.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        Bundle bundle2 = new Bundle();
                        bundle2.putString("uin", Constants.DEFAULT_UIN);
                        bundle2.putString("imei", c.b(Global.getContext()));
                        bundle2.putString("imsi", c.c(Global.getContext()));
                        bundle2.putString("android_id", c.d(Global.getContext()));
                        bundle2.putString("mac", c.a());
                        bundle2.putString("platform", "1");
                        bundle2.putString("os_ver", Build.VERSION.RELEASE);
                        bundle2.putString(BrowserContract.Bookmarks.POSITION, Util.getLocation(Global.getContext()));
                        bundle2.putString("network", a.a(Global.getContext()));
                        bundle2.putString("language", c.b());
                        bundle2.putString("resolution", c.a(Global.getContext()));
                        bundle2.putString("apn", a.b(Global.getContext()));
                        bundle2.putString("model_name", Build.MODEL);
                        bundle2.putString("timezone", TimeZone.getDefault().getID());
                        bundle2.putString("sdk_ver", Constants.SDK_VERSION);
                        bundle2.putString("qz_ver", Util.getAppVersionName(Global.getContext(), "com.qzone"));
                        bundle2.putString("qq_ver", Util.getVersionName(Global.getContext(), "com.tencent.mobileqq"));
                        bundle2.putString("qua", Util.getQUA3(Global.getContext(), Global.getPackageName()));
                        bundle2.putString("packagename", Global.getPackageName());
                        bundle2.putString("app_ver", Util.getAppVersionName(Global.getContext(), Global.getPackageName()));
                        if (bundle != null) {
                            bundle2.putAll(bundle);
                        }
                        g.this.d.add(new b(bundle2));
                        int size = g.this.d.size();
                        int i = OpenConfig.getInstance(Global.getContext(), null).getInt("Agent_ReportTimeInterval");
                        int i2 = i;
                        if (i == 0) {
                            i2 = 10000;
                        }
                        if (!g.this.a("report_via", size) && !z) {
                            if (g.this.f.hasMessages(1001)) {
                                return;
                            }
                            Message obtain = Message.obtain();
                            obtain.what = 1001;
                            g.this.f.sendMessageDelayed(obtain, i2);
                            return;
                        }
                        g.this.e();
                        g.this.f.removeMessages(1001);
                    } catch (Exception e) {
                        com.tencent.open.a.f.b("openSDK_LOG.ReportManager", "--> reporVia, exception in sub thread.", e);
                    }
                }
            });
        }
    }

    public void a(String str, long j, long j2, long j3, int i) {
        a(str, j, j2, j3, i, "", false);
    }

    public void a(final String str, final long j, final long j2, final long j3, final int i, final String str2, final boolean z) {
        com.tencent.open.a.f.a("openSDK_LOG.ReportManager", "-->reportCgi, command: " + str + " | startTime: " + j + " | reqSize:" + j2 + " | rspSize: " + j3 + " | responseCode: " + i + " | detail: " + str2);
        if (a("report_cgi", "" + i) || z) {
            this.h.execute(new Runnable() { // from class: com.tencent.open.b.g.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        long elapsedRealtime = SystemClock.elapsedRealtime();
                        long j4 = j;
                        Bundle bundle = new Bundle();
                        String a2 = a.a(Global.getContext());
                        bundle.putString("apn", a2);
                        bundle.putString("appid", "1000067");
                        bundle.putString("commandid", str);
                        bundle.putString("detail", str2);
                        StringBuilder sb = new StringBuilder();
                        sb.append("network=");
                        sb.append(a2);
                        sb.append('&');
                        sb.append("sdcard=");
                        sb.append(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED) ? 1 : 0);
                        sb.append('&');
                        sb.append("wifi=");
                        sb.append(a.e(Global.getContext()));
                        bundle.putString("deviceInfo", sb.toString());
                        int a3 = 100 / g.this.a(i);
                        if (a3 <= 0) {
                            a3 = 1;
                        } else if (a3 > 100) {
                            a3 = 100;
                        }
                        bundle.putString("frequency", a3 + "");
                        bundle.putString("reqSize", j2 + "");
                        bundle.putString(ProcessBridgeProvider.KEY_RESULT_CODE, i + "");
                        bundle.putString("rspSize", j3 + "");
                        bundle.putString("timeCost", (elapsedRealtime - j4) + "");
                        bundle.putString("uin", Constants.DEFAULT_UIN);
                        g.this.f38250c.add(new b(bundle));
                        int size = g.this.f38250c.size();
                        int i2 = OpenConfig.getInstance(Global.getContext(), null).getInt("Agent_ReportTimeInterval");
                        int i3 = i2;
                        if (i2 == 0) {
                            i3 = 10000;
                        }
                        if (!g.this.a("report_cgi", size) && !z) {
                            if (g.this.f.hasMessages(1000)) {
                                return;
                            }
                            Message obtain = Message.obtain();
                            obtain.what = 1000;
                            g.this.f.sendMessageDelayed(obtain, i3);
                            return;
                        }
                        g.this.b();
                        g.this.f.removeMessages(1000);
                    } catch (Exception e) {
                        com.tencent.open.a.f.b("openSDK_LOG.ReportManager", "--> reportCGI, exception in sub thread.", e);
                    }
                }
            });
        }
    }

    public void a(final String str, final String str2, final Bundle bundle, final boolean z) {
        ThreadManager.executeOnSubThread(new Runnable() { // from class: com.tencent.open.b.g.6
            /* JADX WARN: Removed duplicated region for block: B:42:0x0175 A[Catch: Exception -> 0x0195, TRY_ENTER, TryCatch #4 {Exception -> 0x0195, blocks: (B:2:0x0000, B:4:0x0007, B:6:0x000f, B:10:0x001b, B:12:0x0057, B:14:0x005e, B:16:0x0066, B:18:0x0074, B:23:0x00cb, B:42:0x0175, B:44:0x017d, B:38:0x0164, B:36:0x0158, B:35:0x014e, B:19:0x009a, B:21:0x00a9, B:46:0x0185), top: B:67:0x0000 }] */
            /* JADX WARN: Removed duplicated region for block: B:44:0x017d A[Catch: Exception -> 0x0195, TRY_ENTER, TryCatch #4 {Exception -> 0x0195, blocks: (B:2:0x0000, B:4:0x0007, B:6:0x000f, B:10:0x001b, B:12:0x0057, B:14:0x005e, B:16:0x0066, B:18:0x0074, B:23:0x00cb, B:42:0x0175, B:44:0x017d, B:38:0x0164, B:36:0x0158, B:35:0x014e, B:19:0x009a, B:21:0x00a9, B:46:0x0185), top: B:67:0x0000 }] */
            /* JADX WARN: Removed duplicated region for block: B:72:0x01c4 A[SYNTHETIC] */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void run() {
                /*
                    Method dump skipped, instructions count: 457
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.open.b.g.AnonymousClass6.run():void");
            }
        });
    }

    protected boolean a(String str, int i) {
        int i2;
        if (str.equals("report_cgi")) {
            int i3 = OpenConfig.getInstance(Global.getContext(), null).getInt("Common_CGIReportMaxcount");
            i2 = i3;
            if (i3 == 0) {
                i2 = 5;
            }
        } else if (str.equals("report_via")) {
            int i4 = OpenConfig.getInstance(Global.getContext(), null).getInt("Agent_ReportBatchCount");
            i2 = i4;
            if (i4 == 0) {
                i2 = 5;
            }
        } else {
            i2 = 0;
        }
        com.tencent.open.a.f.b("openSDK_LOG.ReportManager", "-->availableCount, report: " + str + " | dataSize: " + i + " | maxcount: " + i2);
        return i >= i2;
    }

    protected boolean a(String str, String str2) {
        com.tencent.open.a.f.b("openSDK_LOG.ReportManager", "-->availableFrequency, report: " + str + " | ext: " + str2);
        boolean z = false;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        int i = 100;
        if (str.equals("report_cgi")) {
            try {
                int a2 = a(Integer.parseInt(str2));
                z = false;
                i = a2;
                if (this.b.nextInt(100) < a2) {
                    z = true;
                    i = a2;
                }
            } catch (Exception e) {
                return false;
            }
        } else if (str.equals("report_via")) {
            int a3 = e.a(str2);
            z = false;
            i = a3;
            if (this.b.nextInt(100) < a3) {
                i = a3;
                z = true;
            }
        }
        com.tencent.open.a.f.b("openSDK_LOG.ReportManager", "-->availableFrequency, result: " + z + " | frequency: " + i);
        return z;
    }

    protected void b() {
        this.h.execute(new Runnable() { // from class: com.tencent.open.b.g.4
            /* JADX WARN: Removed duplicated region for block: B:26:0x010a A[Catch: Exception -> 0x0126, TRY_ENTER, TryCatch #2 {Exception -> 0x0126, blocks: (B:2:0x0000, B:5:0x000f, B:9:0x0024, B:26:0x010a, B:28:0x011a, B:18:0x00dc, B:21:0x00ec, B:23:0x00fa, B:12:0x004f, B:15:0x00cd), top: B:36:0x0000, inners: #3, #4 }] */
            /* JADX WARN: Removed duplicated region for block: B:43:0x013b A[SYNTHETIC] */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void run() {
                /*
                    Method dump skipped, instructions count: 320
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.open.b.g.AnonymousClass4.run():void");
            }
        });
    }

    protected Bundle c() {
        if (this.f38250c.size() == 0) {
            return null;
        }
        b bVar = (b) this.f38250c.get(0);
        if (bVar == null) {
            com.tencent.open.a.f.b("openSDK_LOG.ReportManager", "-->prepareCgiData, the 0th cgireportitem is null.");
            return null;
        }
        String str = bVar.f38244a.get("appid");
        List<Serializable> a2 = f.a().a("report_cgi");
        if (a2 != null) {
            this.f38250c.addAll(a2);
        }
        com.tencent.open.a.f.b("openSDK_LOG.ReportManager", "-->prepareCgiData, mCgiList size: " + this.f38250c.size());
        if (this.f38250c.size() == 0) {
            return null;
        }
        Bundle bundle = new Bundle();
        try {
            bundle.putString("appid", str);
            bundle.putString("releaseversion", Constants.SDK_VERSION_REPORT);
            bundle.putString("device", Build.DEVICE);
            bundle.putString("qua", Constants.SDK_QUA);
            bundle.putString("key", "apn,frequency,commandid,resultcode,tmcost,reqsize,rspsize,detail,touin,deviceinfo");
            for (int i = 0; i < this.f38250c.size(); i++) {
                b bVar2 = (b) this.f38250c.get(i);
                bundle.putString(i + "_1", bVar2.f38244a.get("apn"));
                bundle.putString(i + "_2", bVar2.f38244a.get("frequency"));
                bundle.putString(i + "_3", bVar2.f38244a.get("commandid"));
                bundle.putString(i + "_4", bVar2.f38244a.get(ProcessBridgeProvider.KEY_RESULT_CODE));
                bundle.putString(i + "_5", bVar2.f38244a.get("timeCost"));
                bundle.putString(i + "_6", bVar2.f38244a.get("reqSize"));
                bundle.putString(i + "_7", bVar2.f38244a.get("rspSize"));
                bundle.putString(i + "_8", bVar2.f38244a.get("detail"));
                bundle.putString(i + "_9", bVar2.f38244a.get("uin"));
                bundle.putString(i + "_10", c.e(Global.getContext()) + "&" + bVar2.f38244a.get("deviceInfo"));
            }
            com.tencent.open.a.f.a("openSDK_LOG.ReportManager", "-->prepareCgiData, end. params: " + bundle.toString());
            return bundle;
        } catch (Exception e) {
            com.tencent.open.a.f.b("openSDK_LOG.ReportManager", "-->prepareCgiData, exception.", e);
            return null;
        }
    }

    protected Bundle d() {
        List<Serializable> a2 = f.a().a("report_via");
        if (a2 != null) {
            this.d.addAll(a2);
        }
        com.tencent.open.a.f.b("openSDK_LOG.ReportManager", "-->prepareViaData, mViaList size: " + this.d.size());
        if (this.d.size() == 0) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (Serializable serializable : this.d) {
            JSONObject jSONObject = new JSONObject();
            b bVar = (b) serializable;
            for (String str : bVar.f38244a.keySet()) {
                try {
                    String str2 = bVar.f38244a.get(str);
                    String str3 = str2;
                    if (str2 == null) {
                        str3 = "";
                    }
                    jSONObject.put(str, str3);
                } catch (JSONException e) {
                    com.tencent.open.a.f.b("openSDK_LOG.ReportManager", "-->prepareViaData, put bundle to json array exception", e);
                }
            }
            jSONArray.put(jSONObject);
        }
        com.tencent.open.a.f.a("openSDK_LOG.ReportManager", "-->prepareViaData, JSONArray array: " + jSONArray.toString());
        Bundle bundle = new Bundle();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("data", jSONArray);
            bundle.putString("data", jSONObject2.toString());
            return bundle;
        } catch (JSONException e2) {
            com.tencent.open.a.f.b("openSDK_LOG.ReportManager", "-->prepareViaData, put bundle to json array exception", e2);
            return null;
        }
    }

    protected void e() {
        this.g.execute(new Runnable() { // from class: com.tencent.open.b.g.5
            /* JADX WARN: Removed duplicated region for block: B:40:0x0223 A[Catch: Exception -> 0x026d, TRY_ENTER, TRY_LEAVE, TryCatch #5 {Exception -> 0x026d, blocks: (B:2:0x0000, B:5:0x000f, B:38:0x020c, B:40:0x0223, B:43:0x023e, B:41:0x022e, B:27:0x01a3, B:36:0x01fa, B:34:0x01e8, B:32:0x01d4, B:8:0x007a, B:10:0x00b0, B:12:0x00db, B:17:0x011b, B:21:0x0151, B:23:0x0180), top: B:72:0x0000, inners: #8, #10, #9, #8 }] */
            /* JADX WARN: Removed duplicated region for block: B:41:0x022e A[Catch: Exception -> 0x026d, TRY_ENTER, TryCatch #5 {Exception -> 0x026d, blocks: (B:2:0x0000, B:5:0x000f, B:38:0x020c, B:40:0x0223, B:43:0x023e, B:41:0x022e, B:27:0x01a3, B:36:0x01fa, B:34:0x01e8, B:32:0x01d4, B:8:0x007a, B:10:0x00b0, B:12:0x00db, B:17:0x011b, B:21:0x0151, B:23:0x0180), top: B:72:0x0000, inners: #8, #10, #9, #8 }] */
            /* JADX WARN: Removed duplicated region for block: B:75:0x02e6 A[SYNTHETIC] */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void run() {
                /*
                    Method dump skipped, instructions count: 749
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.open.b.g.AnonymousClass5.run():void");
            }
        });
    }
}
