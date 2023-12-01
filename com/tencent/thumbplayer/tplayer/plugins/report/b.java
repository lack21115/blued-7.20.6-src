package com.tencent.thumbplayer.tplayer.plugins.report;

import android.app.UiModeManager;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiConfiguration;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.speech.tts.TextToSpeech;
import android.text.TextUtils;
import com.android.internal.telephony.PhoneConstants;
import com.baidu.mobads.sdk.internal.ci;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.tencent.tendinsv.a.b;
import com.tencent.thumbplayer.api.TPPlayerMgr;
import com.tencent.thumbplayer.api.report.ITPBusinessReportManager;
import com.tencent.thumbplayer.api.report.TPDefaultReportInfo;
import com.tencent.thumbplayer.config.TPPlayerConfig;
import com.tencent.thumbplayer.core.common.TPSystemInfo;
import com.tencent.thumbplayer.tplayer.plugins.report.TPReportParams;
import com.tencent.thumbplayer.utils.TPLogUtil;
import com.tencent.thumbplayer.utils.f;
import com.tencent.thumbplayer.utils.l;
import com.tencent.thumbplayer.utils.o;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.UUID;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/tplayer/plugins/report/b.class */
public class b implements ITPBusinessReportManager, com.tencent.thumbplayer.tplayer.plugins.a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f39411a = String.format("Android %s", TPSystemInfo.getOsVersion());
    private static String b = "";

    /* renamed from: c  reason: collision with root package name */
    private static boolean f39412c = false;
    private static com.tencent.thumbplayer.utils.c h = null;
    private Context I;
    private HandlerThread d;
    private HandlerC1027b e;
    private final Object f = new Object();
    private boolean g = false;
    private TPDefaultReportInfo i = null;
    private TPReportParams j = null;
    private int k = 1;
    private int l = 0;
    private boolean m = true;
    private boolean n = true;
    private boolean o = false;
    private boolean p = false;
    private long q = 0;
    private long r = 0;
    private int s = 81;
    private int t = 0;
    private int u = 0;
    private int v = 0;
    private boolean w = false;
    private boolean x = false;
    private boolean y = false;
    private String z = "0";
    private String A = "";
    private String B = "";
    private String C = "";
    private int D = 0;
    private int E = 0;
    private String F = "";
    private int G = 0;
    private long H = 0;
    private int J = -1;
    private c K = new a();
    private TPReportParams.BufferingOnceParams L = null;
    private TPReportParams.UserSeekOnceParams M = null;
    private final e N = new e();
    private f.a O = new f.a() { // from class: com.tencent.thumbplayer.tplayer.plugins.report.b.1
        @Override // com.tencent.thumbplayer.utils.f.a
        public void a(int i, int i2, int i3, Object obj) {
            int i4;
            TPLogUtil.i("TPReportManager", "OnGlobalEventChangeListener eventId: ".concat(String.valueOf(i)));
            switch (i) {
                case TPPlayerMgr.EVENT_ID_APP_ENTER_BACKGROUND /* 100001 */:
                    i4 = 2100;
                    break;
                case TPPlayerMgr.EVENT_ID_APP_ENTER_FOREGROUND /* 100002 */:
                    i4 = 2101;
                    break;
                default:
                    return;
            }
            b.this.e.obtainMessage(i4, null).sendToTarget();
        }
    };

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/tplayer/plugins/report/b$a.class */
    class a implements c {
        a() {
        }

        @Override // com.tencent.thumbplayer.tplayer.plugins.report.b.c
        public void a(int i, com.tencent.thumbplayer.common.a.a aVar) {
            b.this.a(aVar, i, i <= 30);
            b.this.b(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.tencent.thumbplayer.tplayer.plugins.report.b$b  reason: collision with other inner class name */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/tplayer/plugins/report/b$b.class */
    public class HandlerC1027b extends Handler {
        HandlerC1027b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Map map = message.obj instanceof Map ? (Map) message.obj : null;
            int i = message.what;
            if (i == 100) {
                b.this.k();
            } else if (i == 3000) {
                b.this.e();
            } else if (i == 4000) {
                b.this.i();
            } else if (i == 2100) {
                b.this.h();
            } else if (i == 2101) {
                b.this.f();
            } else {
                switch (i) {
                    case 999:
                        b.this.a(map);
                        return;
                    case 1000:
                        b.this.b(map);
                        return;
                    case 1001:
                        b.this.c(map);
                        return;
                    case 1002:
                        b.this.d(map);
                        return;
                    case 1003:
                        b.this.e(map);
                        return;
                    case 1004:
                        b.this.g(map);
                        return;
                    case 1005:
                        b.this.h(map);
                        return;
                    case 1006:
                        b.this.i(map);
                        return;
                    case 1007:
                        b.this.j(map);
                        return;
                    case 1008:
                        b.this.k(map);
                        return;
                    case 1009:
                        b.this.n(map);
                        return;
                    case 1010:
                        b.this.p(map);
                        return;
                    case 1011:
                        b.this.o(map);
                        return;
                    case 1012:
                        b.this.f(map);
                        return;
                    case 1013:
                        b.this.l(map);
                        return;
                    case 1014:
                        b.this.m(map);
                        return;
                    case 1015:
                        b.this.r(map);
                        return;
                    case 1016:
                        if (message.obj instanceof String) {
                            b.this.a((String) message.obj);
                            return;
                        }
                        return;
                    case 1017:
                        b.this.C(map);
                        return;
                    case 1018:
                        b.this.D(map);
                        return;
                    case 1019:
                        b.this.A(map);
                        return;
                    case 1020:
                        b.this.y(map);
                        return;
                    case 1021:
                        b.this.z(map);
                        return;
                    case 1022:
                        b.this.B(map);
                        return;
                    case 1023:
                        b.this.E(map);
                        return;
                    default:
                        switch (i) {
                            case 2000:
                                b.this.s(map);
                                return;
                            case 2001:
                                b.this.t(map);
                                return;
                            case 2002:
                                b.this.v(map);
                                return;
                            case 2003:
                                b.this.u(map);
                                return;
                            case 2004:
                                b.this.w(map);
                                return;
                            case 2005:
                                b.this.x(map);
                                return;
                            default:
                                return;
                        }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/tplayer/plugins/report/b$c.class */
    public interface c {
        void a(int i, com.tencent.thumbplayer.common.a.a aVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/tplayer/plugins/report/b$d.class */
    public class d implements c {
        d() {
        }

        @Override // com.tencent.thumbplayer.tplayer.plugins.report.b.c
        public void a(int i, com.tencent.thumbplayer.common.a.a aVar) {
            l lVar = new l();
            boolean z = i <= 30 || i == 263;
            if (i == 30) {
                i = 205;
            } else if (i == 50) {
                b.this.e.removeMessages(3000);
                i = 263;
            } else if (i == 150) {
                b.this.e.removeMessages(3000);
            } else if (i != 263) {
                return;
            } else {
                b.this.e.removeMessages(3000);
                b.this.e.sendEmptyMessageDelayed(3000, 60000L);
            }
            b.this.a(lVar, i, z);
            b.this.b(lVar, z);
            if (i != 205) {
                lVar.a("loadingtime", 0);
            }
            TPLogUtil.i("TPReportManager", "liveExParam.prePlayLengthInt: " + b.this.j.getLiveExParam().prePlayLengthInt);
            b.this.b(lVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/tplayer/plugins/report/b$e.class */
    public class e {

        /* renamed from: a  reason: collision with root package name */
        long f39417a;
        int b;

        /* renamed from: c  reason: collision with root package name */
        long f39418c;
        long d;
        int e;
        int f;
        long g;
        long h;
        int i;
        int j;
        int k;
        int l;
        boolean m;
        boolean n;
        boolean o;
        int p;
        String q;
        String r;
        String s;
        String t;
        String u;
        String v;
        ArrayList<f> w;

        private e() {
            this.f39417a = 0L;
            this.b = 0;
            this.f39418c = 0L;
            this.d = 0L;
            this.e = 0;
            this.f = 0;
            this.g = 0L;
            this.h = 0L;
            this.i = 0;
            this.j = 0;
            this.k = 0;
            this.l = 0;
            this.m = false;
            this.n = false;
            this.o = false;
            this.p = -1;
            this.q = "";
            this.r = "";
            this.s = "";
            this.t = "";
            this.u = "";
            this.v = "";
            this.w = new ArrayList<>();
        }

        void a() {
            this.f39417a = 0L;
            this.b = 0;
            this.f39418c = 0L;
            this.d = 0L;
            this.e = 0;
            this.f = 0;
            this.g = 0L;
            this.h = 0L;
            this.i = 0;
            this.j = 0;
            this.k = 0;
            this.l = 0;
            this.m = false;
            this.n = false;
            this.o = false;
            this.p = -1;
            this.q = "";
            this.r = "";
            this.s = "";
            this.t = "";
            this.u = "";
            this.v = "";
            this.w.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/tplayer/plugins/report/b$f.class */
    public class f {

        /* renamed from: a  reason: collision with root package name */
        String f39419a;
        String b;

        /* renamed from: c  reason: collision with root package name */
        long f39420c = -1;

        f(String str, String str2) {
            this.f39419a = "";
            this.b = "";
            this.f39419a = str;
            this.b = str2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/tplayer/plugins/report/b$g.class */
    public class g implements c {
        g() {
        }

        @Override // com.tencent.thumbplayer.tplayer.plugins.report.b.c
        public void a(int i, com.tencent.thumbplayer.common.a.a aVar) {
            boolean z = i <= 30;
            b.this.a(aVar, i, z);
            b.this.a(aVar, z);
            b.this.b(aVar);
        }
    }

    public b(Context context) {
        this.I = context.getApplicationContext();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A(Map<String, Object> map) {
        if (map == null) {
            return;
        }
        TPReportParams.LiveExParam liveExParam = this.j.getLiveExParam();
        long a2 = a(map, "stime", System.currentTimeMillis());
        liveExParam.getSyncFrameDurationInt = (int) (a2 - this.N.f39418c);
        this.j.getFirstLoadParams().firstPacketReadTimeUnix = a2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B(Map<String, Object> map) {
        if (map == null) {
            return;
        }
        this.j.getFirstLoadParams().firstOpenTimeUnix = a(map, "stime", System.currentTimeMillis());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C(Map<String, Object> map) {
        if (map == null) {
            return;
        }
        this.t = a(map, "speed", 0);
        this.N.k += this.t;
        this.N.l++;
        if (this.t > this.N.j) {
            this.N.j = this.t;
        }
        String a2 = a(map, "spanId", "");
        if (TextUtils.isEmpty(a2)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(a2);
            if (jSONObject.has("spanId")) {
                this.N.u = jSONObject.getString("spanId");
            }
        } catch (Exception e2) {
            TPLogUtil.e("TPReportManager", e2);
        }
        b(a2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D(Map<String, Object> map) {
        if (map == null) {
            return;
        }
        this.N.r = a(map, "url", "");
        this.N.s = a(map, "cdnip", "");
        this.N.t = a(map, "cdnuip", "");
        if (TextUtils.isEmpty(this.N.r) || !this.N.r.contains("sid=")) {
            return;
        }
        int indexOf = this.N.r.indexOf("sid=");
        int indexOf2 = this.N.r.indexOf("&", indexOf);
        e eVar = this.N;
        eVar.v = indexOf2 >= 0 ? eVar.r.substring(indexOf + 4, indexOf2) : eVar.r.substring(indexOf + 4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E(Map<String, Object> map) {
        this.A = a(map, WifiConfiguration.Protocol.varName, "");
        this.B = a(map, "protover", "");
    }

    private float a(Map<String, Object> map, String str, float f2) {
        Object obj;
        if (map != null && (obj = map.get(str)) != null) {
            return ((Float) obj).floatValue();
        }
        return f2;
    }

    private int a(Map<String, Object> map, String str, int i) {
        Object obj;
        if (map != null && (obj = map.get(str)) != null) {
            return ((Integer) obj).intValue();
        }
        return i;
    }

    private long a(Map<String, Object> map, String str, long j) {
        Object obj;
        if (map != null && (obj = map.get(str)) != null) {
            return ((Long) obj).longValue();
        }
        return j;
    }

    private static String a(int i) {
        if (i != 5) {
            if (i != 15) {
                if (i != 30) {
                    if (i != 40) {
                        if (i != 50) {
                            if (i != 150) {
                                if (i != 205) {
                                    if (i != 263) {
                                        switch (i) {
                                            case 32:
                                                return "first_rendering";
                                            case 33:
                                                return "load_subtitle";
                                            case 34:
                                                return "302_redirect";
                                            case 35:
                                                return "second_buffering";
                                            default:
                                                return "";
                                        }
                                    }
                                    return "live_period";
                                }
                                return "live_loading";
                            }
                            return "live_error";
                        }
                        return "play_done";
                    }
                    return "user_seek";
                }
                return "first_load";
            }
            return "get_cdn_url";
        }
        return "init_player";
    }

    private String a(Map<String, Object> map, String str, String str2) {
        Object obj;
        if (map != null && (obj = map.get(str)) != null) {
            return (String) obj;
        }
        return str2;
    }

    private static void a(com.tencent.thumbplayer.common.a.a aVar) {
        String str;
        HashMap hashMap = new HashMap();
        aVar.a(hashMap);
        if (!hashMap.containsKey("step") || (str = hashMap.get("step")) == null) {
            return;
        }
        String a2 = a(Integer.parseInt(str));
        if (TextUtils.isEmpty(a2)) {
            return;
        }
        TPLogUtil.i("TPReportManager", "reportEvent: eventId = ".concat(String.valueOf(a2)));
        com.tencent.thumbplayer.common.a.b.a(a2, hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    public void a(com.tencent.thumbplayer.common.a.a aVar, int i, boolean z) {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    public void a(com.tencent.thumbplayer.common.a.a aVar, boolean z) {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        String str2;
        long j;
        if (TextUtils.isEmpty(str)) {
            TPLogUtil.i("TPReportManager", "onHandleHlsTag, tag is null");
        } else if (!str.startsWith("#EXT-X-PROGRAM-DATE-TIME:")) {
            TPLogUtil.i("TPReportManager", "onHandleHlsTag, tag is not start with #EXT-X-PROGRAM-DATE-TIME:");
        } else {
            try {
                String substring = str.substring(25);
                int indexOf = substring.indexOf(43);
                if (indexOf != -1) {
                    substring = substring.substring(0, indexOf);
                } else {
                    TPLogUtil.i("TPReportManager", "handleOnPlayerPrivaterHlsM3u8Tag , player_m3u8_tag , tag do not contains time zone");
                }
                str2 = substring.replace('T', ' ');
            } catch (Exception e2) {
                TPLogUtil.e("TPReportManager", e2);
                str2 = "";
            }
            if (TextUtils.isEmpty(str2)) {
                TPLogUtil.i("TPReportManager", "onHandleHlsTag , player_m3u8_tag , dataTime is null ");
                return;
            }
            try {
                Date parse = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(str2);
                j = 0;
                if (parse != null) {
                    j = parse.getTime();
                }
            } catch (Exception e3) {
                TPLogUtil.e("TPReportManager", e3);
                j = 0;
            }
            long currentTimeMillis = System.currentTimeMillis();
            StringBuilder sb = new StringBuilder("onHandleHlsTag , player_m3u8_tag , sysCurTime: ");
            sb.append(currentTimeMillis);
            sb.append(", time:");
            sb.append(j);
            sb.append(", delay:");
            long j2 = currentTimeMillis - j;
            sb.append(j2);
            TPLogUtil.i("TPReportManager", sb.toString());
            this.N.i = (int) j2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Map<String, Object> map) {
        TPLogUtil.i("TPReportManager", "onPlayerCreateStart");
        if (map == null) {
            return;
        }
        this.j.getInitParams().playStarTimeUnix = a(map, "stime", System.currentTimeMillis());
    }

    private boolean a(Map<String, Object> map, String str, boolean z) {
        Object obj;
        if (map != null && (obj = map.get(str)) != null) {
            return ((Boolean) obj).booleanValue();
        }
        return z;
    }

    private int b(int i) {
        switch (i) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
                return 2;
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
                return 3;
            case 13:
                return 4;
            default:
                return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.tencent.thumbplayer.common.a.a aVar) {
        TPLogUtil.i("TPReportManager", "onReportEvent: " + aVar.toString());
        a(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    public void b(com.tencent.thumbplayer.common.a.a aVar, boolean z) {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    private void b(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("hitDownloaded") && this.N.p == -1) {
                this.N.p = jSONObject.getInt("hitDownloaded");
            }
        } catch (Exception e2) {
            TPLogUtil.e("TPReportManager", e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Map<String, Object> map) {
        TPLogUtil.i("TPReportManager", "onPlayerCreateDone");
        if (map == null) {
            return;
        }
        l lVar = new l();
        TPReportParams.PlayerInitParams initParams = this.j.getInitParams();
        initParams.playEndTimeUnix = a(map, "etime", System.currentTimeMillis());
        initParams.errCodeString = this.z;
        initParams.paramsToProperties(lVar);
    }

    private void c() {
        this.d = o.a().a("TP-ReportThread");
        this.e = new HandlerC1027b(this.d.getLooper());
        this.j = new TPReportParams();
        com.tencent.thumbplayer.utils.f.a(this.O);
        synchronized (b.class) {
            try {
                if (h == null) {
                    h = new com.tencent.thumbplayer.utils.c(this.I, "TPReportCache");
                }
                if (!f39412c) {
                    this.e.obtainMessage(4000).sendToTarget();
                }
                f39412c = true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00cb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void c(java.util.Map<java.lang.String, java.lang.Object> r8) {
        /*
            Method dump skipped, instructions count: 261
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.thumbplayer.tplayer.plugins.report.b.c(java.util.Map):void");
    }

    private void d() {
        TPLogUtil.i("TPReportManager", "release: ");
        com.tencent.thumbplayer.utils.f.b(this.O);
        if (this.d != null) {
            if (Build.VERSION.SDK_INT >= 18) {
                this.d.quitSafely();
            } else {
                synchronized (this.f) {
                    this.g = false;
                    this.e.sendEmptyMessage(100);
                    while (!this.g) {
                        try {
                            this.f.wait(5000L, 0);
                        } catch (InterruptedException e2) {
                            TPLogUtil.e("TPReportManager", e2);
                        }
                    }
                }
                o.a().a(this.d, (Handler) null);
            }
            this.d = null;
        }
        TPLogUtil.i("TPReportManager", "release: end!");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(Map<String, Object> map) {
        if (this.o) {
            this.o = false;
            TPLogUtil.i("TPReportManager", "onPrepareDone");
            if (map == null) {
                return;
            }
            this.N.d = System.currentTimeMillis();
            this.N.n = a(map, "multitrack", false);
            l lVar = new l();
            if (a(map, "playertype", 0) == 1) {
                this.D = 0;
            } else {
                this.D = 1;
            }
            this.F = a(map, "definition", "");
            this.H = a(map, "duration", 0L);
            this.G = (int) a(map, TextToSpeech.Engine.KEY_PARAM_RATE, 0L);
            String a2 = a(map, "fmt", "");
            if (a2 == null || !a2.contains("hls")) {
                this.E = 1;
            } else {
                this.E = 3;
            }
            TPReportParams.FirstLoadParams firstLoadParams = this.j.getFirstLoadParams();
            firstLoadParams.endTimeUnix = a(map, "etime", 0L);
            firstLoadParams.errCodeString = this.z;
            firstLoadParams.paramsToProperties(lVar);
            this.K.a(30, lVar);
            this.j.getFirstLoadParams().reset();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        TPLogUtil.i("TPReportManager", "onLivePeriodReport");
        this.K.a(263, new l());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(Map<String, Object> map) {
        TPLogUtil.i("TPReportManager", "onStartPlayer");
        this.m = false;
        if (map == null) {
            return;
        }
        this.N.f39417a = System.currentTimeMillis();
        long a2 = a(map, "stime", 0L);
        if (this.q > 0) {
            this.r += System.currentTimeMillis() - a2;
        }
        this.q = a2;
        if (this.J == 1) {
            this.e.removeMessages(3000);
            this.e.sendEmptyMessageDelayed(3000, 60000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        TPLogUtil.i("TPReportManager", "onAppForeground");
        if (this.n) {
            return;
        }
        this.n = true;
        g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(Map<String, Object> map) {
        TPLogUtil.i("TPReportManager", "onRenderingStart");
        if (map == null) {
            return;
        }
        l lVar = new l();
        TPReportParams.FirstRenderParams firstRenderParams = this.j.getFirstRenderParams();
        firstRenderParams.endTimeUnix = a(map, "etime", 0L);
        firstRenderParams.errCodeString = this.z;
        firstRenderParams.paramsToProperties(lVar);
        this.K.a(32, lVar);
        this.j.getFirstRenderParams().reset();
    }

    private void g() {
        TPLogUtil.i("TPReportManager", "removeCacheEvent: mFlowId: " + this.C);
        if (h == null || TextUtils.isEmpty(this.C)) {
            return;
        }
        h.a(this.C);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(Map<String, Object> map) {
        TPLogUtil.i("TPReportManager", "onPlayerPause");
        if (map == null) {
            return;
        }
        if (this.q > 0) {
            this.r += a(map, "stime", System.currentTimeMillis()) - this.q;
            this.q = 0L;
        }
        if (this.N.f39417a > 0) {
            this.N.b += (int) (System.currentTimeMillis() - this.N.f39417a);
            this.N.f39417a = 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        TPLogUtil.i("TPReportManager", "onAppBackground");
        if (this.m || this.J == 1 || !this.n) {
            return;
        }
        this.n = false;
        l lVar = new l();
        this.j.getBufferingTotalParams().paramsToProperties(lVar);
        this.j.getUserSeekTotalParams().paramsToProperties(lVar);
        TPReportParams.PlayDoneParams playDoneParams = this.j.getPlayDoneParams();
        playDoneParams.endTimeUnix = System.currentTimeMillis();
        playDoneParams.reasonInt = 2;
        playDoneParams.errCodeString = this.z;
        if (this.N.f39417a > 0) {
            this.N.b += (int) (System.currentTimeMillis() - this.N.f39417a);
            this.N.f39417a = 0L;
        }
        if (this.q > 0) {
            this.r += playDoneParams.endTimeUnix - this.q;
            this.q = 0L;
        }
        playDoneParams.playDurationFloat = ((float) this.r) / 1000.0f;
        playDoneParams.paramsToProperties(lVar);
        TPReportParams.CommonParams commonParams = this.j.getCommonParams();
        commonParams.stepInt = 50;
        commonParams.paramsToProperties(lVar);
        int i = this.J;
        if (i == 0) {
            a((com.tencent.thumbplayer.common.a.a) lVar, false);
        } else if (i == 1) {
            b((com.tencent.thumbplayer.common.a.a) lVar, false);
        }
        if (h == null || TextUtils.isEmpty(this.C)) {
            return;
        }
        TPLogUtil.i("TPReportManager", "Cache report event. mFlowId: " + this.C);
        h.a(this.C, lVar.a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(Map<String, Object> map) {
        TPLogUtil.i("TPReportManager", "onPlayerStop");
        if (map == null) {
            return;
        }
        if (this.q > 0) {
            this.r += a(map, "etime", System.currentTimeMillis()) - this.q;
            this.q = 0L;
        }
        if (this.N.f39417a > 0) {
            this.N.b += (int) (System.currentTimeMillis() - this.N.f39417a);
            this.N.f39417a = 0L;
        }
        map.put("reason", 1);
        q(map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        TPLogUtil.i("TPReportManager", "onReportLastEvent");
        com.tencent.thumbplayer.utils.c cVar = h;
        if (cVar == null) {
            return;
        }
        try {
            ArrayList arrayList = (ArrayList) cVar.a();
            if (arrayList == null) {
                return;
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= arrayList.size()) {
                    return;
                }
                try {
                    Properties properties = (Properties) arrayList.get(i2);
                    if (properties != null) {
                        b(new l(properties));
                    }
                } catch (Exception e2) {
                    TPLogUtil.e("TPReportManager", e2);
                }
                i = i2 + 1;
            }
        } catch (Exception e3) {
            TPLogUtil.e("TPReportManager", e3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(Map<String, Object> map) {
        TPLogUtil.i("TPReportManager", "onPlayerError");
        if (map == null) {
            return;
        }
        if (this.N.f39417a > 0) {
            this.N.b += (int) (System.currentTimeMillis() - this.N.f39417a);
            this.N.f39417a = 0L;
        }
        this.z = a(map, "code", "0");
        if (this.J == 1) {
            this.K.a(150, new l());
            return;
        }
        map.put("reason", 3);
        q(map);
    }

    private void j() {
        this.q = 0L;
        this.r = 0L;
        this.v = 0;
        this.u = 0;
        this.w = false;
        this.x = false;
        this.o = false;
        this.p = false;
        this.C = "";
        this.D = 0;
        this.E = 0;
        this.G = 0;
        this.H = 0L;
        this.t = 0;
        this.y = false;
        this.A = "";
        this.B = "";
        this.F = "";
        this.J = -1;
        this.z = "0";
        this.N.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(Map<String, Object> map) {
        TPLogUtil.i("TPReportManager", "onStartSeek");
        if (map == null) {
            return;
        }
        if (this.x) {
            m(new com.tencent.thumbplayer.utils.g().a("etime", Long.valueOf(System.currentTimeMillis())).a());
        }
        if (this.w) {
            k(new com.tencent.thumbplayer.utils.g().a("etime", Long.valueOf(System.currentTimeMillis())).a("petime", Long.valueOf(a(map, "pstime", 0L) / 1000)).a());
        }
        this.w = true;
        this.l = 1;
        TPReportParams.UserSeekOnceParams createUserSeekOnceParams = this.j.createUserSeekOnceParams();
        this.M = createUserSeekOnceParams;
        createUserSeekOnceParams.seekStartTimeUnix = a(map, "stime", System.currentTimeMillis());
        TPReportParams.CommonParams commonParams = this.j.getCommonParams();
        this.M.formatInt = commonParams.mediaFormatInt;
        this.M.startPresentTimeLong = a(map, "pstime", 0L) / 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        TPLogUtil.d("TPReportManager", "handleReportThreadExit");
        synchronized (this.f) {
            this.g = true;
            this.f.notify();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(Map<String, Object> map) {
        TPReportParams.UserSeekOnceParams userSeekOnceParams;
        TPLogUtil.i("TPReportManager", "onSeekComplete");
        this.w = false;
        if (map == null || (userSeekOnceParams = this.M) == null) {
            return;
        }
        userSeekOnceParams.seekEndTimeUnix = a(map, "etime", System.currentTimeMillis());
        this.M.endPresentTimeLong = a(map, "petime", 0L) / 1000;
        this.M.errCodeString = this.z;
        long j = this.M.seekEndTimeUnix - this.M.seekStartTimeUnix;
        if (j > 1200) {
            this.v++;
            this.u = (int) (this.u + j);
        }
        TPReportParams.UserSeekTotalParams userSeekTotalParams = this.j.getUserSeekTotalParams();
        userSeekTotalParams.seekTotalCountInt++;
        userSeekTotalParams.seekBufferingDurationInt = this.u;
        userSeekTotalParams.seekBufferingCountInt = this.v;
        if (userSeekTotalParams.seekOnceParamsList.size() < 20) {
            userSeekTotalParams.seekOnceParamsList.add(this.M);
            l lVar = new l();
            this.M.paramsToProperties(lVar);
            this.K.a(40, lVar);
        }
        this.M = null;
    }

    private String l() {
        if (this.I == null) {
            return "0";
        }
        if (TextUtils.isEmpty(b)) {
            int i = this.I.getResources().getDisplayMetrics().widthPixels;
            String str = this.I.getResources().getDisplayMetrics().heightPixels + PhoneConstants.APN_TYPE_ALL + i;
            b = str;
            return str;
        }
        return b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(Map<String, Object> map) {
        TPLogUtil.i("TPReportManager", "onBufferingStart");
        if (map == null) {
            return;
        }
        this.x = true;
        if (this.w) {
            return;
        }
        if (this.N.f39417a > 0) {
            this.N.b += (int) (System.currentTimeMillis() - this.N.f39417a);
            this.N.f39417a = 0L;
        }
        this.N.g = a(map, "stime", System.currentTimeMillis());
        TPReportParams.BufferingOnceParams createBufferingOnceParams = this.j.createBufferingOnceParams();
        this.L = createBufferingOnceParams;
        createBufferingOnceParams.starTimeUnix = this.N.g;
        this.L.formatInt = a(map, "format", 0);
        this.L.formatInt = this.j.getCommonParams().mediaFormatInt;
        this.L.reasonInt = a(map, "reason", 0);
        this.L.lastEventInt = this.l;
        this.L.sceneInt = this.k;
        this.L.bufferingPresentTimeLong = a(map, "ptime", 0L) / 1000;
        this.L.urlString = a(map, "url", "");
    }

    private int m() {
        NetworkInfo activeNetworkInfo;
        Context context = this.I;
        if (context == null) {
            return 0;
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || !activeNetworkInfo.isConnected()) {
                return 0;
            }
            int type = activeNetworkInfo.getType();
            if (type != 0) {
                if (type != 1) {
                    return type != 9 ? 0 : 10;
                }
                return 1;
            }
            return b(activeNetworkInfo.getSubtype());
        } catch (Exception e2) {
            TPLogUtil.e("TPReportManager", e2);
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(Map<String, Object> map) {
        TPLogUtil.i("TPReportManager", "onBufferingEnd");
        this.x = false;
        if (!this.N.o) {
            this.N.f39417a = System.currentTimeMillis();
        }
        if (map == null) {
            return;
        }
        long a2 = a(map, "etime", System.currentTimeMillis());
        int i = (int) (a2 - this.N.g);
        if (i > 1200 && !this.w) {
            this.N.e++;
            this.N.h = a2;
            this.N.f += (int) (this.N.h - this.N.g);
            TPReportParams.BufferingOnceParams bufferingOnceParams = this.L;
            if (bufferingOnceParams == null) {
                return;
            }
            bufferingOnceParams.endTimeUnix = a(map, "etime", 0L);
            this.L.errCodeString = this.z;
            TPReportParams.BufferingTotalParams bufferingTotalParams = this.j.getBufferingTotalParams();
            bufferingTotalParams.bufferingCountInt++;
            bufferingTotalParams.bufferingDurationInt += i;
            if (bufferingTotalParams.bufferingOnceParamsList.size() < 20) {
                bufferingTotalParams.bufferingOnceParamsList.add(this.L);
                l lVar = new l();
                this.L.paramsToProperties(lVar);
                this.K.a(35, lVar);
            }
            this.L = null;
        }
    }

    private int n() {
        UiModeManager uiModeManager = (UiModeManager) this.I.getSystemService(Context.UI_MODE_SERVICE);
        if (uiModeManager == null) {
            return 2;
        }
        if (uiModeManager.getCurrentModeType() == 4) {
            return 9;
        }
        return (this.I.getResources().getConfiguration().screenLayout & 15) >= 3 ? 5 : 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(Map<String, Object> map) {
        TPLogUtil.i("TPReportManager", "onPlayComplete");
        if (map == null) {
            return;
        }
        map.put("reason", 0);
        q(map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(Map<String, Object> map) {
        TPLogUtil.i("TPReportManager", "onPlayerReset");
        if (map == null) {
            return;
        }
        map.put("reason", 1);
        q(map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(Map<String, Object> map) {
        TPLogUtil.i("TPReportManager", "onPlayerRelease");
        if (map == null) {
            return;
        }
        map.put("reason", 1);
        q(map);
    }

    private void q(Map<String, Object> map) {
        TPLogUtil.i("TPReportManager", "onPlayEnd");
        if (map == null || this.m) {
            return;
        }
        this.m = true;
        if (this.J != 1 && this.o) {
            d(new com.tencent.thumbplayer.utils.g().a("etime", Long.valueOf(System.currentTimeMillis())).a());
        }
        if (this.x) {
            m(new com.tencent.thumbplayer.utils.g().a("etime", Long.valueOf(System.currentTimeMillis())).a());
        }
        if (this.w) {
            k(new com.tencent.thumbplayer.utils.g().a("etime", Long.valueOf(System.currentTimeMillis())).a());
        }
        if (this.N.f39417a > 0) {
            this.N.b += (int) (System.currentTimeMillis() - this.N.f39417a);
            this.N.f39417a = 0L;
        }
        this.w = false;
        l lVar = new l();
        this.j.getBufferingTotalParams().paramsToProperties(lVar);
        this.j.getBufferingTotalParams().reset();
        this.j.getUserSeekTotalParams().paramsToProperties(lVar);
        this.j.getUserSeekTotalParams().reset();
        TPReportParams.PlayDoneParams playDoneParams = this.j.getPlayDoneParams();
        playDoneParams.endTimeUnix = a(map, "etime", System.currentTimeMillis());
        playDoneParams.reasonInt = a(map, "reason", 0);
        playDoneParams.errCodeString = this.z;
        if (this.q > 0) {
            this.r += playDoneParams.endTimeUnix - this.q;
            this.q = 0L;
        }
        playDoneParams.playDurationFloat = ((float) this.r) / 1000.0f;
        playDoneParams.paramsToProperties(lVar);
        this.K.a(50, lVar);
        this.z = "0";
        this.j.resetAllParam();
        g();
        j();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(Map<String, Object> map) {
        if (map == null) {
            return;
        }
        this.k = a(map, "scene", 1.0f) != 1.0f ? 2 : 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(Map<String, Object> map) {
        TPLogUtil.i("TPReportManager", "onGetCdn");
        if (map == null) {
            return;
        }
        l lVar = new l();
        TPReportParams.GetCdnUrlParams getCdnParams = this.j.getGetCdnParams();
        getCdnParams.proxyIpString = a(map, b.a.q, "");
        getCdnParams.starTimeUnix = a(map, "stime", 0L);
        getCdnParams.endTimeUnix = a(map, "etime", 0L);
        getCdnParams.errCodeString = a(map, "code", "0");
        getCdnParams.paramsToProperties(lVar);
        this.K.a(15, lVar);
        if (TextUtils.isEmpty(getCdnParams.errCodeString) || getCdnParams.errCodeString.equals("0") || getCdnParams.errCodeString.equals(ci.d)) {
            return;
        }
        this.z = getCdnParams.errCodeString;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(Map<String, Object> map) {
        TPLogUtil.i("TPReportManager", "on302Redirect");
        if (map == null) {
            return;
        }
        l lVar = new l();
        TPReportParams.RedirectParams redirectParams = this.j.getRedirectParams();
        redirectParams.cdnTypeInt = a(map, "vt", 0);
        redirectParams.redirectCountInt = a(map, "t302", 0);
        redirectParams.redirectedUrlString = a(map, "url", "");
        redirectParams.starTimeUnix = a(map, "stime", 0L);
        redirectParams.endTimeUnix = a(map, "etime", 0L);
        redirectParams.errCodeString = a(map, "code", "0");
        redirectParams.paramsToProperties(lVar);
        this.K.a(34, lVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(Map<String, Object> map) {
        if (map == null) {
            return;
        }
        this.C = UUID.randomUUID().toString() + System.nanoTime() + BridgeUtil.UNDERLINE_STR + TPPlayerConfig.getPlatform();
        this.z = a(map, "code", "0");
        TPDefaultReportInfo tPDefaultReportInfo = this.i;
        if (tPDefaultReportInfo != null) {
            this.J = tPDefaultReportInfo.getPlayType();
        }
        if (this.J == 1) {
            this.K.a(150, new l());
            return;
        }
        map.put("reason", 3);
        this.m = false;
        q(map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(Map<String, Object> map) {
        TPLogUtil.i("TPReportManager", "onLoadSubtitle");
        if (map == null) {
            return;
        }
        this.N.w.add(new f(a(map, "name", ""), a(map, "url", "")));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(Map<String, Object> map) {
        TPLogUtil.i("TPReportManager", "onSelectTrack");
        if (map == null || this.N.w.size() == 0 || a(map, "tracktype", 0) != 3) {
            return;
        }
        this.p = true;
        this.N.m = true;
        TPReportParams.LoadSubtitleParams loadSubtitleParams = this.j.getLoadSubtitleParams();
        loadSubtitleParams.starTimeUnix = a(map, "stime", 0L);
        TPDefaultReportInfo tPDefaultReportInfo = this.i;
        if (tPDefaultReportInfo != null) {
            loadSubtitleParams.cdnTypeInt = tPDefaultReportInfo.subtitleCdnType;
            loadSubtitleParams.cgiUrlIndex = this.i.subtitleUrlIndex;
        }
        long a2 = a(map, "opaque", -1L);
        String a3 = a(map, "name", "");
        Iterator<f> it = this.N.w.iterator();
        while (it.hasNext()) {
            f next = it.next();
            if (!TextUtils.isEmpty(a3) && next.f39419a.equals(a3)) {
                loadSubtitleParams.subtitleUrlString = next.b;
                next.f39420c = a2;
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(Map<String, Object> map) {
        TPLogUtil.i("TPReportManager", "onSelectTrackDone");
        if (!this.p || map == null || this.N.w.size() == 0) {
            return;
        }
        long a2 = a(map, "opaque", -1L);
        if (a2 == -1) {
            return;
        }
        Iterator<f> it = this.N.w.iterator();
        while (it.hasNext()) {
            if (it.next().f39420c == a2) {
                TPReportParams.LoadSubtitleParams loadSubtitleParams = this.j.getLoadSubtitleParams();
                loadSubtitleParams.endTimeUnix = a(map, "etime", 0L);
                loadSubtitleParams.errCodeString = a(map, "code", "0");
                loadSubtitleParams.bufferingDurationInt = (int) (loadSubtitleParams.endTimeUnix - loadSubtitleParams.starTimeUnix);
                l lVar = new l();
                loadSubtitleParams.paramsToProperties(lVar);
                this.K.a(33, lVar);
                this.p = false;
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(Map<String, Object> map) {
        TPLogUtil.i("TPReportManager", "onSwitchDef");
        if (map == null) {
            return;
        }
        this.N.q = a(map, "switch", "");
        this.N.o = true;
        if (this.J == 1) {
            this.e.removeMessages(3000);
            e();
            this.N.f39418c = 0L;
            this.N.d = 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(Map<String, Object> map) {
        TPLogUtil.i("TPReportManager", "onSwitchDefEnd");
        if (map == null) {
            return;
        }
        this.N.q = a(map, "switch", "");
        this.N.o = false;
        if (this.J == 1) {
            this.K.a(30, new l());
            this.e.removeMessages(3000);
            this.e.sendEmptyMessageDelayed(3000, 60000L);
            this.N.f39417a = System.currentTimeMillis();
        }
    }

    @Override // com.tencent.thumbplayer.tplayer.plugins.a
    public void a() {
        c();
    }

    @Override // com.tencent.thumbplayer.tplayer.plugins.a
    public void a(int i, int i2, int i3, String str, Object obj) {
        int i4;
        switch (i) {
            case 100:
                i4 = 999;
                break;
            case 101:
                i4 = 1000;
                break;
            case 102:
                i4 = 1001;
                break;
            case 103:
                i4 = 1002;
                break;
            case 104:
                i4 = 1003;
                break;
            case 105:
                i4 = 1012;
                break;
            case 106:
                i4 = 1004;
                break;
            case 107:
                i4 = 1005;
                break;
            case 108:
                i4 = 1006;
                break;
            case 109:
                i4 = 1007;
                break;
            case 110:
                i4 = 1008;
                break;
            case 111:
                i4 = 1009;
                break;
            case 112:
                i4 = 1010;
                break;
            case 113:
                i4 = 1011;
                break;
            case 114:
                i4 = 1013;
                break;
            case 115:
                i4 = 1014;
                break;
            case 116:
                i4 = 1015;
                break;
            case 117:
                i4 = 1016;
                break;
            case 118:
                i4 = 2002;
                break;
            case 119:
                i4 = 1019;
                break;
            case 120:
                i4 = 1020;
                break;
            case 121:
                i4 = 1021;
                break;
            case 122:
                i4 = 2004;
                break;
            case 123:
                i4 = 2005;
                break;
            case 124:
                i4 = 1022;
                break;
            default:
                switch (i) {
                    case 200:
                        i4 = 1017;
                        break;
                    case 201:
                        i4 = 1018;
                        break;
                    case 202:
                        i4 = 1023;
                        break;
                    default:
                        return;
                }
        }
        this.e.obtainMessage(i4, obj).sendToTarget();
    }

    @Override // com.tencent.thumbplayer.tplayer.plugins.a
    public void b() {
        d();
    }

    @Override // com.tencent.thumbplayer.api.report.ITPBusinessReportManager
    public void reportEvent(int i, Map<String, Object> map) {
    }

    @Override // com.tencent.thumbplayer.api.report.ITPBusinessReportManager
    public void setReportInfoGetter(TPDefaultReportInfo tPDefaultReportInfo) {
        this.i = tPDefaultReportInfo;
    }
}
