package com.getui.gtc.a;

import android.os.Bundle;
import android.text.TextUtils;
import com.getui.gtc.a.a.g;
import com.getui.gtc.base.GtcProvider;
import com.getui.gtc.base.util.ScheduleQueue;
import com.getui.gtc.e.c;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: source-8110460-dex2jar.jar:com/getui/gtc/a/f.class */
public final class f implements b {
    public static int d = 4;
    private static long h = 86400000;

    /* renamed from: a  reason: collision with root package name */
    public int f21889a;
    public int b;
    private boolean g = false;
    private long i = 604800000;
    private String j = "none";

    /* renamed from: c  reason: collision with root package name */
    public boolean f21890c = true;
    public boolean e = false;
    public boolean f = false;
    private final AtomicBoolean k = new AtomicBoolean(true);

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final int i) {
        if (i == -1) {
            com.getui.gtc.i.c.a.d("not integrate ct.");
            a(3, new g(-3));
        } else if (!com.getui.gtc.a.a.d.c()) {
            com.getui.gtc.i.c.a.d("not init ct.");
            a(3, new g(-4));
        } else {
            g b = com.getui.gtc.a.a.d.b("");
            boolean isEmpty = TextUtils.isEmpty(b.f21882c);
            if (this.k.getAndSet(false) && isEmpty) {
                ScheduleQueue.getInstance().addSchedule(new Runnable() { // from class: com.getui.gtc.a.f.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            com.getui.gtc.i.c.a.d("ct retry.");
                            f.this.a(i);
                        } catch (Throwable th) {
                            com.getui.gtc.i.c.a.b(th);
                        }
                    }
                }, 5000L);
            } else if (isEmpty && (this.b & 1) == 1) {
                com.getui.gtc.a.a.d.g();
            } else {
                a(3, b);
            }
        }
    }

    public static void a(int i, g gVar) {
        String str;
        try {
            String str2 = gVar.f21882c;
            String str3 = "";
            if (TextUtils.isEmpty(str2)) {
                str = "";
            } else {
                if (i != 1) {
                    str3 = com.getui.gtc.a.a.f.a(str2);
                    com.getui.gtc.i.c.a.d("305 * PM: ".concat(String.valueOf(str2)));
                } else {
                    str3 = com.getui.gtc.a.a.f.a(com.getui.gtc.a.a.c.a(str2));
                }
                str = "2#" + com.getui.gtc.a.a.f.a();
            }
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);
            a(a.a(simpleDateFormat.format(new Date())) + "|" + a.a(com.getui.gtc.c.b.d) + "|" + a.a(com.getui.gtc.c.b.f21920a) + "|android|" + GtcProvider.context().getPackageName() + "|GTC-3.2.1.0|" + i + "|" + gVar.f21881a + "|" + str3 + "|" + gVar.b + "|" + str);
        } catch (Throwable th) {
            com.getui.gtc.i.c.a.c("type 305 report error: " + th.toString());
        }
    }

    private static void a(String str) {
        com.getui.gtc.e.c cVar;
        com.getui.gtc.e.c cVar2;
        com.getui.gtc.e.c cVar3;
        try {
            cVar = c.a.f21997a;
            JSONObject a2 = cVar.f21995a.a();
            if (str == null) {
                str = a2.optString("content");
            } else {
                a2.put("collectTime", System.currentTimeMillis());
                a2.put("content", str);
                cVar2 = c.a.f21997a;
                cVar2.f21995a.a(a2);
            }
            if (TextUtils.isEmpty(str)) {
                com.getui.gtc.i.c.a.c("type 305 no content report");
            } else if (System.currentTimeMillis() - a2.optLong("reportTime") < h) {
                com.getui.gtc.i.c.a.c("type 305 report not expired");
            } else {
                com.getui.gtc.h.a.a(str, 305);
                a2.put("reportTime", System.currentTimeMillis());
                cVar3 = c.a.f21997a;
                cVar3.f21995a.a(a2);
            }
        } catch (Throwable th) {
            com.getui.gtc.i.c.a.b(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        if (!z) {
            com.getui.gtc.i.c.a.d("not integrate cu.");
            a(2, new g(-3));
        } else if (!com.getui.gtc.a.a.d.d()) {
            com.getui.gtc.i.c.a.d("not init cu.");
            a(2, new g(-4));
        } else {
            g e = com.getui.gtc.a.a.d.e();
            boolean isEmpty = TextUtils.isEmpty(e.f21882c);
            if (this.k.getAndSet(false) && isEmpty) {
                ScheduleQueue.getInstance().addSchedule(new Runnable() { // from class: com.getui.gtc.a.f.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            com.getui.gtc.i.c.a.d("cu retry.");
                            f.this.a(true);
                        } catch (Throwable th) {
                            com.getui.gtc.i.c.a.b(th);
                        }
                    }
                }, 5000L);
            } else if (isEmpty && (this.b & 2) == 2) {
                com.getui.gtc.a.a.d.f();
            } else {
                a(2, e);
            }
        }
    }

    private static boolean a() {
        String str;
        try {
            Bundle bundle = new Bundle();
            bundle.putString(AdvanceSetting.CLEAR_NOTIFICATION, "com.igexin.push.extension.distribution.gbd.stub.PushExtension");
            ClassLoader a2 = com.getui.gtc.g.b.a(bundle);
            String str2 = "";
            if (a2 != null) {
                Field[] declaredFields = Class.forName("igexin.gbd.a", false, a2).getDeclaredFields();
                int length = declaredFields.length;
                int i = 0;
                while (true) {
                    int i2 = i;
                    str2 = "";
                    if (i2 >= length) {
                        break;
                    }
                    Field field = declaredFields[i2];
                    if (field.getType() == String.class && (str = (String) field.get(null)) != null && str.startsWith("GBD-")) {
                        str2 = str.substring(4);
                        break;
                    }
                    i = i2 + 1;
                }
            }
            if (TextUtils.isEmpty(str2)) {
                return false;
            }
            String[] split = str2.split("\\.");
            if (split.length != 4) {
                return false;
            }
            int[] iArr = new int[4];
            iArr[0] = 2;
            iArr[1] = 9;
            iArr[2] = 0;
            iArr[3] = 0;
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= 3) {
                    return false;
                }
                int parseInt = Integer.parseInt(split[i4]);
                if (parseInt != iArr[i4]) {
                    return parseInt > iArr[i4];
                }
                i3 = i4 + 1;
            }
        } catch (Throwable th) {
            com.getui.gtc.i.c.a.b(th);
            return false;
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.getui.gtc.e.c cVar;
        com.getui.gtc.e.c cVar2;
        Map<String, String> a2 = com.getui.gtc.f.b.a(null);
        if (a2 != null && a2.size() > 0) {
            try {
                String str = a2.get("sdk.gtc.type305.enable");
                if (str != null) {
                    this.g = Boolean.parseBoolean(str);
                }
            } catch (Exception e) {
                com.getui.gtc.i.c.a.a(e);
            }
            try {
                String str2 = a2.get("sdk.gtc.type305.interval");
                if (str2 != null) {
                    h = Long.parseLong(str2) * 1000;
                }
            } catch (Exception e2) {
                com.getui.gtc.i.c.a.a(e2);
            }
            try {
                String str3 = a2.get("sdk.gtc.type305.collect_interval");
                if (str3 != null) {
                    this.i = Long.parseLong(str3) * 1000;
                }
            } catch (Exception e3) {
                com.getui.gtc.i.c.a.a(e3);
            }
            try {
                String str4 = a2.get("sdk.gtc.type305.cu_path_list");
                if (str4 != null) {
                    this.j = str4;
                }
            } catch (Exception e4) {
                com.getui.gtc.i.c.a.a(e4);
            }
            try {
                String str5 = a2.get("sdk.gtc.type305.s_pm_enable");
                if (str5 != null) {
                    this.f21889a = Integer.parseInt(str5);
                }
            } catch (Exception e5) {
                com.getui.gtc.i.c.a.a(e5);
            }
            try {
                String str6 = a2.get("sdk.gtc.type305.pl_enable");
                if (str6 != null) {
                    this.b = Integer.parseInt(str6);
                }
            } catch (Exception e6) {
                com.getui.gtc.i.c.a.a(e6);
            }
            try {
                String str7 = a2.get("sdk.gtc.type305.first_call");
                if (str7 != null) {
                    d = Integer.parseInt(str7);
                }
            } catch (Exception e7) {
                com.getui.gtc.i.c.a.a(e7);
            }
            try {
                String str8 = a2.get("sdk.gtc.type305.n_pm_enable");
                if (str8 != null) {
                    this.e = Boolean.parseBoolean(str8);
                }
            } catch (Exception e8) {
                com.getui.gtc.i.c.a.a(e8);
            }
            try {
                String str9 = a2.get("sdk.gtc.type305.cl_enable");
                if (str9 != null) {
                    this.f = Boolean.parseBoolean(str9);
                }
            } catch (Exception e9) {
                com.getui.gtc.i.c.a.a(e9);
            }
            try {
                String str10 = a2.get("sdk.gtc.type305.sf_enable");
                if (str10 != null) {
                    this.f21890c = Boolean.parseBoolean(str10);
                }
            } catch (Exception e10) {
                com.getui.gtc.i.c.a.a(e10);
            }
        }
        if (!this.g) {
            com.getui.gtc.i.c.a.b("type 305 is not enabled");
            return;
        }
        try {
            if (a()) {
                com.getui.gtc.i.c.a.a("type 305 exist gbd pm");
                return;
            }
            a((String) null);
            cVar = c.a.f21997a;
            JSONObject a3 = cVar.f21995a.a();
            if (System.currentTimeMillis() - a3.optLong("collectTime") < this.i) {
                com.getui.gtc.i.c.a.c("type 305 collect time not expired");
                return;
            }
            int optInt = a3.optInt("accessCount") + 1;
            a3.put("accessCount", optInt);
            cVar2 = c.a.f21997a;
            cVar2.f21995a.a(a3);
            if (optInt < d) {
                com.getui.gtc.i.c.a.d("accessCount:" + optInt + " < starPnFirstCall:" + d + ", ignored");
                return;
            }
            int a4 = com.getui.gtc.a.a.d.a(GtcProvider.context());
            if (this.f21890c && !com.getui.gtc.a.a.d.b(GtcProvider.context())) {
                com.getui.gtc.i.c.a.d("type 305 report not sf.");
                a(a4, new g(-1));
            } else if (!com.getui.gtc.a.a.d.a()) {
                com.getui.gtc.i.c.a.d("type 305 report not net.");
                a(a4, new g(-2));
            } else {
                com.getui.gtc.i.c.a.d("type 305 pmEnable: " + this.f21889a);
                if (a4 == 1) {
                    com.getui.gtc.i.c.a.d("type 305 cm n disable.");
                } else if (a4 == 2) {
                    if ((this.f21889a & 2) != 2) {
                        com.getui.gtc.i.c.a.d("type 305 starPm disable.");
                        return;
                    }
                    com.getui.gtc.i.c.a.d("type 305 cu fetch.");
                    a(com.getui.gtc.a.a.d.a(this.j));
                } else if (a4 != 3) {
                    com.getui.gtc.i.c.a.d("type 305 no sim or error.");
                } else if ((this.f21889a & 1) != 1) {
                    com.getui.gtc.i.c.a.d("type 305 starPm disable.");
                } else {
                    com.getui.gtc.i.c.a.d("type 305 ct fetch.");
                    a(com.getui.gtc.a.a.d.b());
                }
            }
        } catch (Throwable th) {
            com.getui.gtc.i.c.a.c("type 305 report error: " + th.toString());
        }
    }
}
