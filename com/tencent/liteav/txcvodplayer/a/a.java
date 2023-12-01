package com.tencent.liteav.txcvodplayer.a;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.liteav.base.datareport.Event4XReporter;
import com.tencent.liteav.base.system.LiteavSystemInfo;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.sdk.common.LicenseChecker;
import com.tencent.ugc.datereport.UGCDataReportDef;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/txcvodplayer/a/a.class */
public final class a {
    public String B;
    public Event4XReporter C;
    private int J;
    private int L;
    private int N;
    private Event4XReporter O;

    /* renamed from: a  reason: collision with root package name */
    public Context f22816a;
    public int o;
    public String y;
    public String z;
    private final String D = "TXCVodPlayCollection";
    private final String E = "1";
    public String b = null;

    /* renamed from: c  reason: collision with root package name */
    public long f22817c = 0;
    public long d = 0;
    public long e = 0;
    private boolean F = false;
    public boolean f = true;
    public boolean g = false;
    public boolean h = false;
    public int i = 0;
    public int j = 0;
    private int G = 0;
    public long k = 0;
    public int l = 0;
    public int m = 0;
    public int n = 0;
    public boolean p = false;
    public boolean q = false;
    private int I = 0;
    public int r = 0;
    public String s = "0";
    public String t = "";
    private String K = "";
    public int u = -1;
    public int v = 0;
    public int w = 0;
    public int x = 0;
    private float M = 1.0f;
    private String H = LiteavSystemInfo.getAppVersion();
    public String A = LiteavSystemInfo.getDeviceUuid();

    public a(Context context) {
        this.B = "";
        this.f22816a = context;
        String appId = LicenseChecker.getInstance().getAppId();
        LiteavLog.i("VodLicenseCheck", "getLicenseAppId = ".concat(String.valueOf(appId)));
        this.B = appId;
        this.O = new Event4XReporter(UGCDataReportDef.COMMAND_ID_DAU, 1004, "", true, 1);
    }

    private static String a(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        Display defaultDisplay = windowManager.getDefaultDisplay();
        try {
            Class<?> cls = Class.forName("android.view.Display");
            if (LiteavSystemInfo.getSystemOSVersionInt() > 8) {
                cls.getMethod("getRealMetrics", DisplayMetrics.class).invoke(defaultDisplay, displayMetrics);
            }
            int i = displayMetrics.heightPixels;
            int i2 = displayMetrics.widthPixels;
            return i2 + "_" + i;
        } catch (Throwable th) {
            return "";
        }
    }

    private String f() {
        Context context = this.f22816a;
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        int i = applicationInfo.labelRes;
        return i == 0 ? applicationInfo.nonLocalizedLabel.toString() : context.getString(i);
    }

    private void g() {
        int i;
        this.C = new Event4XReporter(40304, 1011, "", true, 1);
        a();
        this.C.SetEventIntValue("u32_timeuse", this.G);
        this.C.SetEventIntValue("u32_videotime", this.i);
        this.C.SetEventIntValue("u32_avg_load", this.m == 0 ? 0L : this.n / i);
        this.C.SetEventIntValue("u32_load_cnt", this.m);
        this.C.SetEventIntValue("u32_max_load", this.o);
        this.C.SetEventIntValue("u32_avg_block_time", this.n);
        this.C.SetEventIntValue("u32_player_type", this.r);
        Event4XReporter event4XReporter = this.C;
        int i2 = this.w;
        event4XReporter.SetEventIntValue("u32_dns_time", i2 > 0 ? i2 : 0L);
        Event4XReporter event4XReporter2 = this.C;
        int i3 = this.v;
        event4XReporter2.SetEventIntValue("u32_tcp_did_connect", i3 > 0 ? i3 : 0L);
        Event4XReporter event4XReporter3 = this.C;
        int i4 = this.x;
        event4XReporter3.SetEventIntValue("u32_first_video_packet", i4 > 0 ? i4 : 0L);
        Event4XReporter event4XReporter4 = this.C;
        int i5 = this.l;
        long j = 0;
        if (i5 > 0) {
            j = i5;
        }
        event4XReporter4.SetEventIntValue("u32_first_i_frame", j);
        this.C.SetEventStringValue("u32_server_ip", this.y);
        this.C.SetEventStringValue("u32_drm_type", this.z);
        this.C.SetEventStringValue("str_fileid", this.t);
        this.C.SetEventStringValue("u32_playmode", this.s);
        this.C.SetEventIntValue("u64_err_code", this.J);
        this.C.SetEventStringValue("str_err_info", this.K);
        this.C.SetEventIntValue("u32_video_decode_type", this.u);
        this.C.SetEventIntValue("u32_speed", (int) (this.M * 100.0f));
        this.C.SendReport();
        StringBuilder sb = new StringBuilder("report evt 40304: token=");
        sb.append(this.A);
        sb.append(" ,dev_uuid=");
        sb.append(LiteavSystemInfo.getDeviceUuid());
        sb.append(" ,str_app_version=");
        sb.append(this.H);
        sb.append(" ,sys_version=");
        sb.append(LiteavSystemInfo.getSystemOSVersionInt());
        sb.append(" ,str_stream_url=");
        sb.append(this.b);
        sb.append(" ,u32_timeuse=");
        sb.append(this.G);
        sb.append(" ,u32_videotime=");
        sb.append(this.i);
        sb.append(" ,u32_avg_load=");
        int i6 = this.m;
        sb.append(i6 == 0 ? 0 : this.n / i6);
        sb.append(" ,u32_load_cnt=");
        sb.append(this.m);
        sb.append(" ,u32_max_load=");
        sb.append(this.o);
        sb.append(" ,u32_avg_block_time=");
        sb.append(this.n);
        sb.append(" ,u32_player_type=");
        sb.append(this.r);
        sb.append(" ,u32_dns_time=");
        sb.append(this.w);
        sb.append(" ,u32_tcp_did_connect=");
        int i7 = this.v;
        if (i7 <= 0) {
            i7 = -1;
        }
        sb.append(i7);
        sb.append(" ,u32_first_video_packet=");
        int i8 = this.x;
        int i9 = -1;
        if (i8 > 0) {
            i9 = i8;
        }
        sb.append(i9);
        sb.append(" ,u32_first_i_frame=");
        sb.append(this.l);
        sb.append(" ,u32_server_ip=");
        sb.append(this.y);
        sb.append(" ,u32_drm_type=");
        sb.append(this.z);
        sb.append(" ,str_fileid=");
        sb.append(this.t);
        sb.append(" ,u32_playmode=");
        sb.append(this.s);
        sb.append(" ,u64_err_code=");
        sb.append(this.J);
        sb.append(" ,str_err_info=");
        sb.append(this.K);
        sb.append(" ,u32_speed=");
        sb.append(this.M * 100.0f);
        sb.append(" ,u32_app_id= ,u32_video_decode_type=");
        sb.append(this.u);
        LiteavLog.i("TXCVodPlayCollection", sb.toString());
    }

    private void h() {
        LiteavLog.i("TXCVodPlayCollection", "onSegmentReport");
        this.C = new Event4XReporter(40305, 1011, "", true, 1);
        a();
        this.C.SetEventIntValue("u32_videotime", this.i);
        this.C.SetEventIntValue("u32_player_type", this.r);
        this.C.SetEventStringValue("u32_server_ip", this.y);
        this.C.SetEventStringValue("u32_drm_type", this.z);
        this.C.SetEventStringValue("str_fileid", this.t);
        this.C.SetEventStringValue("u32_playmode", this.s);
        this.C.SetEventIntValue("u32_videoindex", this.j);
        this.C.SetEventIntValue("u32_realplaytime", this.k / 1000);
        this.C.SetEventIntValue("u64_timestamp", System.currentTimeMillis());
        this.C.SetEventIntValue("u32_speed", (int) (this.M * 100.0f));
        this.C.SetEventIntValue("u32_segment_duration", b.a(this.f22816a).a(this.B));
        this.C.SendReport();
        LiteavLog.i("TXCVodPlayCollection", "report evt 40305: token=" + this.A + " ,dev_uuid=" + LiteavSystemInfo.getDeviceUuid() + " ,str_app_version=" + this.H + " ,sys_version=" + LiteavSystemInfo.getSystemOSVersionInt() + " ,str_stream_url=" + this.b + " ,u32_videotime=" + this.i + " ,u32_player_type=" + this.r + " ,u32_server_ip=" + this.y + " ,u32_drm_type=" + this.z + " ,str_fileid=" + this.t + " ,u32_playmode=" + this.s + " ,u32_videoindex=" + this.j + " ,u32_realplaytime=" + (this.k / 1000) + " ,u32_speed=" + (this.M * 100.0f) + " ,u32_app_id= ,u64_timestamp=" + System.currentTimeMillis());
    }

    public final void a() {
        this.C.SetEventStringValue("str_sdk_name", "liteavSdk");
        this.C.SetEventStringValue("str_brand_type", LiteavSystemInfo.getBrand());
        this.C.SetEventStringValue("str_device_resolution", a(this.f22816a));
        this.C.SetEventStringValue("str_device_type", LiteavSystemInfo.getModel());
        this.C.SetEventIntValue("u32_network_type", LiteavSystemInfo.getNetworkType());
        String deviceUuid = LiteavSystemInfo.getDeviceUuid();
        this.C.SetEventStringValue(UGCDataReportDef.DR_KEY_DEV_UUID, deviceUuid);
        this.C.SetEventStringValue("str_app_version", this.H);
        this.C.SetEventStringValue("str_app_name", f());
        this.C.SetEventStringValue(UGCDataReportDef.DR_KEY_SYS_VER, String.valueOf(LiteavSystemInfo.getSystemOSVersionInt()));
        this.C.SetEventStringValue("str_stream_url", this.b);
        String deviceUuid2 = LiteavSystemInfo.getDeviceUuid();
        this.A = deviceUuid2;
        this.C.SetEventStringValue("token", deviceUuid2);
        this.C.SetEventStringValue("str_user_id", "_".concat(String.valueOf(deviceUuid)));
        this.C.SetEventStringValue("str_package_name", LiteavSystemInfo.getAppPackageName());
        this.C.SetEventStringValue("u32_app_id", this.B);
    }

    public final void a(float f) {
        this.M = f;
        this.O.ReportDau(1552, 0, "");
        LiteavLog.i("TXCVodPlayCollection", "mSpeed = " + this.M);
    }

    public final void a(int i, String str) {
        LiteavLog.i("TXCVodPlayCollection", "errorCode= " + i + " ，errorInfo= " + str);
        if (this.l == 0) {
            this.J = i;
            this.K = str;
            if (str == null) {
                this.K = "";
            }
        }
        if (this.F) {
            c();
        }
    }

    public final void a(boolean z) {
        this.F = true;
        long currentTimeMillis = System.currentTimeMillis();
        this.d = currentTimeMillis;
        this.f22817c = currentTimeMillis;
        this.G = 0;
        this.k = 0L;
        this.j = 0;
        this.e = 0L;
        this.m = 0;
        this.n = 0;
        this.o = 0;
        if (z) {
            this.f = false;
        } else {
            this.g = true;
        }
        LiteavLog.i("TXCVodPlayCollection", "start " + this.d + ", mIsPaused = " + this.f + " mIsPreLoading = " + this.g);
    }

    public final void b() {
        if (0 == this.d) {
            LiteavLog.i("TXCVodPlayCollection", "calculateSegmentPlayTime mBeginPlayTS == 0");
            return;
        }
        LiteavLog.i("TXCVodPlayCollection", "calculateSegmentPlayTime mCurIndexPlayTime= " + this.k + ", mBeginPlayTS=" + this.d);
        this.k = this.k + ((long) ((int) (System.currentTimeMillis() - this.d)));
        this.d = System.currentTimeMillis();
        if (this.s.equals("1")) {
            boolean b = b.a(this.f22816a).b(this.B);
            if (!b) {
                b.a(this.f22816a).c(this.B);
            }
            if (this.F && b) {
                h();
            }
            long j = this.G;
            long j2 = this.k;
            this.G = (int) (j + (j2 / 1000));
            this.k = j2 % 1000;
        }
    }

    public final void b(boolean z) {
        if (z) {
            this.L = 1;
            this.O.ReportDau(1553, 0, "");
        } else {
            this.L = 0;
        }
        LiteavLog.i("TXCVodPlayCollection", "mIsMirror= " + this.L);
    }

    public final void c() {
        LiteavLog.i("TXCVodPlayCollection", "stop " + this.k);
        if (this.f) {
            this.d = System.currentTimeMillis();
        }
        if (this.F && !this.g) {
            b();
            this.G = (int) (this.G + (this.k / 1000));
            this.k = 0L;
            g();
            this.F = false;
        }
        this.p = false;
        this.q = false;
        this.f = false;
        this.g = false;
        this.h = false;
    }

    public final void c(boolean z) {
        if (!z) {
            this.h = true;
        }
        this.N++;
        this.O.ReportDau(1554, 0, "");
        LiteavLog.d("TXCVodPlayCollection", "mSetBitrateIndexCnt= " + this.N);
    }

    public final void d() {
        LiteavLog.i("TXCVodPlayCollection", "setBitrateRenderStart");
        this.h = false;
    }

    public final void e() {
        this.p = true;
        this.I++;
        this.O.ReportDau(1551, 0, "");
        LiteavLog.d("TXCVodPlayCollection", "mSeekCnt= " + this.I);
    }
}
