package com.tencent.tmsbeacon.event.c;

import android.os.Build;
import android.text.TextUtils;
import com.anythink.core.api.ATAdConst;
import com.tencent.tmsbeacon.a.c.c;
import com.tencent.tmsbeacon.a.c.e;
import com.tencent.tmsbeacon.a.c.f;
import com.tencent.tmsbeacon.base.net.RequestType;
import com.tencent.tmsbeacon.base.net.call.JceRequestEntity;
import com.tencent.tmsbeacon.event.EventBean;
import com.tencent.tmsbeacon.event.open.EventType;
import com.tencent.tmsbeacon.module.BeaconModule;
import com.tencent.tmsbeacon.pack.EventRecordV2;
import com.tencent.tmsbeacon.pack.RequestPackageV2;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsbeacon/event/c/d.class */
public final class d {

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsbeacon/event/c/d$a.class */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f39563a;

        static {
            EventType.values();
            int[] iArr = new int[6];
            f39563a = iArr;
            try {
                EventType eventType = EventType.NORMAL;
                iArr[0] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                int[] iArr2 = f39563a;
                EventType eventType2 = EventType.DT_NORMAL;
                iArr2[2] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                int[] iArr3 = f39563a;
                EventType eventType3 = EventType.REALTIME;
                iArr3[1] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                int[] iArr4 = f39563a;
                EventType eventType4 = EventType.DT_REALTIME;
                iArr4[3] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                int[] iArr5 = f39563a;
                EventType eventType5 = EventType.IMMEDIATE_WNS;
                iArr5[4] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                int[] iArr6 = f39563a;
                EventType eventType6 = EventType.IMMEDIATE_MSF;
                iArr6[5] = 6;
            } catch (NoSuchFieldError e6) {
            }
        }
    }

    public static int a(EventType eventType) {
        int i = a.f39563a[eventType.ordinal()];
        int i2 = 3;
        if (i == 3 || i == 4) {
            i2 = 1;
        } else if (i == 5) {
            return 2;
        } else {
            if (i != 6) {
                return 0;
            }
        }
        return i2;
    }

    public static JceRequestEntity a(List<EventBean> list, boolean z) {
        return JceRequestEntity.builder().a(RequestType.EVENT).a(z ? 2 : 1).b(com.tencent.tmsbeacon.base.net.b.b.a(false)).a(com.tencent.tmsbeacon.base.net.b.b.a(true), 8081).a(c.d().f()).a("version", com.huawei.hms.ads.dynamicloader.b.g).a(a(list)).a();
    }

    public static RequestPackageV2 a(EventBean eventBean) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(eventBean);
        return a(arrayList);
    }

    public static RequestPackageV2 a(List<EventBean> list) {
        RequestPackageV2 requestPackageV2 = new RequestPackageV2();
        requestPackageV2.appVersion = com.tencent.tmsbeacon.a.c.b.a();
        requestPackageV2.common = a();
        ArrayList<EventRecordV2> arrayList = new ArrayList<>();
        for (EventBean eventBean : list) {
            EventRecordV2 b = b(eventBean);
            if (b != null) {
                arrayList.add(b);
            }
        }
        requestPackageV2.events = arrayList;
        c d = c.d();
        requestPackageV2.mainAppKey = d.f();
        requestPackageV2.model = f.e().h();
        requestPackageV2.osVersion = e.l().s();
        requestPackageV2.packageName = com.tencent.tmsbeacon.a.c.b.b();
        requestPackageV2.platformId = d.g();
        requestPackageV2.sdkId = d.h();
        requestPackageV2.sdkVersion = d.i();
        requestPackageV2.reserved = "";
        return requestPackageV2;
    }

    public static String a(String str) {
        if (str == null || str.trim().length() == 0) {
            return "unknown";
        }
        if (e(str.trim())) {
            String trim = str.trim();
            String str2 = trim;
            if (trim.length() > 16) {
                str2 = trim.substring(0, 16);
            }
            return str2;
        }
        com.tencent.tmsbeacon.base.util.c.e("[core] channelID should be Numeric! channelID:" + str, new Object[0]);
        return "unknown";
    }

    private static Map<String, String> a() {
        HashMap hashMap = new HashMap();
        e l = e.l();
        c d = c.d();
        f e = f.e();
        hashMap.put("A31", "" + l.p());
        hashMap.put("A67", com.tencent.tmsbeacon.a.c.b.c(d.c()));
        hashMap.put("A76", com.tencent.tmsbeacon.a.c.b.d());
        hashMap.put("A89", l.a(d.c()));
        hashMap.put("A52", String.valueOf(l.y()));
        hashMap.put("A58", l.m() ? "Y" : "N");
        hashMap.put("A12", l.n());
        hashMap.put("A17", l.u());
        hashMap.put("A10", e.h());
        hashMap.put("A2", "" + e.b());
        hashMap.put("A4", e.d());
        hashMap.put("A6", e.f());
        hashMap.put("A7", e.a());
        hashMap.put("A20", e.j());
        hashMap.put("A69", e.k());
        hashMap.put("A60", e.j());
        hashMap.put("A9", Build.BRAND);
        hashMap.put("A158", l.d());
        return hashMap;
    }

    public static Map<String, String> a(String str, Map<String, String> map) {
        if (map == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        int i = 0;
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String valueOf = String.valueOf(entry.getKey());
            int length = valueOf.trim().length();
            if (length <= 0 || !e(valueOf)) {
                com.tencent.tmsbeacon.base.util.c.e("[core] '%s' should be ASCII code in 32-126!", valueOf);
                com.tencent.tmsbeacon.a.b.d.b().a(ATAdConst.BIDDING_TYPE.BIDDING_LOSS_WITH_LOW_PRICE_IN_HB, "[event] eventName: " + str + ", key: " + valueOf + " should be ASCII code in 32-126!");
            } else {
                String trim = valueOf.trim();
                String str2 = trim;
                if (length > 64) {
                    str2 = trim.substring(0, 64);
                    String str3 = "[event] eventName: " + str + ", key: " + str2 + " should be less than 64!";
                    com.tencent.tmsbeacon.a.b.d.b().a(ATAdConst.BIDDING_TYPE.BIDDING_LOSS_WITH_LOW_PRICE_IN_HB, str3);
                    com.tencent.tmsbeacon.base.util.e.a(str3);
                }
                String replace = str2.replace("|", "%7C").replace("&", "%26").replace("=", "%3D");
                String trim2 = String.valueOf(entry.getValue()).trim();
                String str4 = trim2;
                if (trim2.length() > 10240) {
                    String str5 = "[event] eventName: " + str + ", key: " + replace + "'s value > 10K.";
                    com.tencent.tmsbeacon.a.b.d.b().a(ATAdConst.BIDDING_TYPE.BIDDING_LOSS_WITH_LOW_PRICE_IN_NORMAL, str5);
                    com.tencent.tmsbeacon.base.util.e.a(str5);
                    str4 = trim2.substring(0, 10240);
                }
                String replace2 = str4.replace('\n', ' ').replace('\r', ' ').replace("|", "%7C").replace("&", "%26").replace("=", "%3D");
                hashMap.put(replace, replace2);
                i += replace.length() + replace2.length();
            }
        }
        if (i > 46080) {
            String str6 = "[event] eventName: " + str + " params > 45K";
            com.tencent.tmsbeacon.a.b.d.b().a("104", str6);
            com.tencent.tmsbeacon.base.util.e.a(str6);
            return null;
        }
        return hashMap;
    }

    public static boolean a(int i) {
        return i != 0;
    }

    private static EventRecordV2 b(EventBean eventBean) {
        if (eventBean == null) {
            return null;
        }
        EventRecordV2 eventRecordV2 = new EventRecordV2();
        eventRecordV2.appKey = eventBean.getAppKey();
        eventRecordV2.apn = eventBean.getApn() != null ? eventBean.getApn() : "";
        eventRecordV2.srcIp = eventBean.getSrcIp() != null ? eventBean.getSrcIp() : "";
        eventRecordV2.eventCode = eventBean.getEventCode();
        eventRecordV2.valueType = eventBean.getValueType();
        eventRecordV2.mapValue = eventBean.getEventValue();
        eventRecordV2.byteValue = eventBean.getByteValue();
        eventRecordV2.eventTime = eventBean.getEventTime();
        eventRecordV2.eventResult = eventBean.getEventResult();
        eventRecordV2.eventType = eventBean.getEventType();
        eventRecordV2.reserved = eventBean.getReserved();
        return eventRecordV2;
    }

    public static String b(String str) {
        if (TextUtils.isEmpty(str)) {
            if (com.tencent.tmsbeacon.base.util.e.f39530a.get()) {
                com.tencent.tmsbeacon.a.b.d.b().a("101", "eventCode == null");
                com.tencent.tmsbeacon.base.util.e.a("eventCode == null");
                return "";
            }
            return "";
        }
        String trim = str.replace('|', '_').trim();
        if (!e(trim)) {
            String str2 = str + " is not ASCII";
            com.tencent.tmsbeacon.a.b.d.b().a("101", str2);
            com.tencent.tmsbeacon.base.util.e.a(str2);
            return "";
        }
        String str3 = trim;
        if (trim.length() > 128) {
            String str4 = str + " length > 128.";
            com.tencent.tmsbeacon.a.b.d.b().a("101", str4);
            com.tencent.tmsbeacon.base.util.e.a(str4);
            str3 = trim.substring(0, 128);
        }
        return str3;
    }

    public static String c(String str) {
        if (str == null || str.length() == 0) {
            return "DefaultPageID";
        }
        String str2 = str;
        if (str.length() > 50) {
            str2 = str.substring(0, 50);
        }
        return str2;
    }

    public static String d(String str) {
        if (str == null || str.length() == 0) {
            return "10000";
        }
        String trim = str.replace('|', '_').trim();
        if (e(trim)) {
            if (trim.length() < 5) {
                com.tencent.tmsbeacon.base.util.c.e("[core] userID length should < 5!", new Object[0]);
            }
            return trim.length() > 128 ? trim.substring(0, 128) : trim;
        }
        com.tencent.tmsbeacon.base.util.c.e("[core] userID should be ASCII code in 32-126! userID:" + str, new Object[0]);
        return "10000";
    }

    public static boolean e(String str) {
        int length = str.length();
        boolean z = true;
        while (true) {
            int i = length - 1;
            if (i < 0) {
                return z;
            }
            char charAt = str.charAt(i);
            if (charAt >= ' ') {
                length = i;
                if (charAt >= 127) {
                }
            }
            z = false;
            length = i;
        }
    }

    public static BeaconModule f(String str) throws Exception {
        return (BeaconModule) Class.forName(str).newInstance();
    }
}
