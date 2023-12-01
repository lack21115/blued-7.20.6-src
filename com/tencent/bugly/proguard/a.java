package com.tencent.bugly.proguard;

import android.content.Context;
import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.j256.ormlite.stmt.query.SimpleComparison;
import com.tencent.bugly.crashreport.biz.UserInfoBean;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.lbssearch.object.param.Geo2AddressParam;
import java.lang.reflect.Array;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/bugly/proguard/a.class */
public class a {
    private static Proxy e;

    /* renamed from: a  reason: collision with root package name */
    protected HashMap<String, HashMap<String, byte[]>> f21665a = new HashMap<>();
    protected String b;

    /* renamed from: c  reason: collision with root package name */
    i f21666c;
    private HashMap<String, Object> d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a() {
        new HashMap();
        this.d = new HashMap<>();
        this.b = "GBK";
        this.f21666c = new i();
    }

    public static am a(Context context, int i, byte[] bArr) {
        com.tencent.bugly.crashreport.common.info.a b = com.tencent.bugly.crashreport.common.info.a.b();
        StrategyBean c2 = com.tencent.bugly.crashreport.common.strategy.a.a().c();
        if (b == null || c2 == null) {
            x.e("Can not create request pkg for parameters is invalid.", new Object[0]);
            return null;
        }
        try {
            am amVar = new am();
            synchronized (b) {
                amVar.f21680a = 1;
                amVar.b = b.f();
                amVar.f21681c = b.f21439c;
                amVar.d = b.k;
                amVar.e = b.m;
                amVar.f = b.f;
                amVar.g = i;
                byte[] bArr2 = bArr;
                if (bArr == null) {
                    bArr2 = "".getBytes();
                }
                amVar.h = bArr2;
                amVar.i = b.h;
                amVar.j = b.i;
                amVar.k = new HashMap();
                amVar.l = b.e();
                amVar.m = c2.n;
                amVar.o = b.h();
                amVar.p = com.tencent.bugly.crashreport.common.info.b.b(context);
                amVar.q = System.currentTimeMillis();
                amVar.r = b.i();
                amVar.s = b.h();
                amVar.t = amVar.p;
                b.getClass();
                amVar.n = "com.tencent.bugly";
                Map<String, String> map = amVar.k;
                map.put("A26", b.s());
                Map<String, String> map2 = amVar.k;
                StringBuilder sb = new StringBuilder();
                sb.append(b.D());
                map2.put("A62", sb.toString());
                Map<String, String> map3 = amVar.k;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(b.E());
                map3.put("A63", sb2.toString());
                Map<String, String> map4 = amVar.k;
                StringBuilder sb3 = new StringBuilder();
                sb3.append(b.B);
                map4.put("F11", sb3.toString());
                Map<String, String> map5 = amVar.k;
                StringBuilder sb4 = new StringBuilder();
                sb4.append(b.A);
                map5.put("F12", sb4.toString());
                Map<String, String> map6 = amVar.k;
                map6.put("D3", b.l);
                if (com.tencent.bugly.b.b != null) {
                    for (com.tencent.bugly.a aVar : com.tencent.bugly.b.b) {
                        if (aVar.versionKey != null && aVar.version != null) {
                            amVar.k.put(aVar.versionKey, aVar.version);
                        }
                    }
                }
                amVar.k.put("G15", z.b("G15", ""));
                amVar.k.put("D4", z.b("D4", "0"));
            }
            Map<String, String> x = b.x();
            if (x != null) {
                for (Map.Entry<String, String> entry : x.entrySet()) {
                    amVar.k.put(entry.getKey(), entry.getValue());
                }
            }
            return amVar;
        } catch (Throwable th) {
            if (x.b(th)) {
                return null;
            }
            th.printStackTrace();
            return null;
        }
    }

    public static aq a(UserInfoBean userInfoBean) {
        if (userInfoBean == null) {
            return null;
        }
        aq aqVar = new aq();
        aqVar.f21687a = userInfoBean.e;
        aqVar.e = userInfoBean.j;
        aqVar.d = userInfoBean.f21423c;
        aqVar.f21688c = userInfoBean.d;
        aqVar.g = userInfoBean.o == 1;
        int i = userInfoBean.b;
        if (i == 1) {
            aqVar.b = (byte) 1;
        } else if (i == 2) {
            aqVar.b = (byte) 4;
        } else if (i == 3) {
            aqVar.b = (byte) 2;
        } else if (i == 4) {
            aqVar.b = (byte) 3;
        } else if (userInfoBean.b < 10 || userInfoBean.b >= 20) {
            x.e("unknown uinfo type %d ", Integer.valueOf(userInfoBean.b));
            return null;
        } else {
            aqVar.b = (byte) userInfoBean.b;
        }
        aqVar.f = new HashMap();
        if (userInfoBean.p >= 0) {
            Map<String, String> map = aqVar.f;
            StringBuilder sb = new StringBuilder();
            sb.append(userInfoBean.p);
            map.put("C01", sb.toString());
        }
        if (userInfoBean.q >= 0) {
            Map<String, String> map2 = aqVar.f;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(userInfoBean.q);
            map2.put("C02", sb2.toString());
        }
        if (userInfoBean.r != null && userInfoBean.r.size() > 0) {
            for (Map.Entry<String, String> entry : userInfoBean.r.entrySet()) {
                Map<String, String> map3 = aqVar.f;
                map3.put("C03_" + entry.getKey(), entry.getValue());
            }
        }
        if (userInfoBean.s != null && userInfoBean.s.size() > 0) {
            for (Map.Entry<String, String> entry2 : userInfoBean.s.entrySet()) {
                Map<String, String> map4 = aqVar.f;
                map4.put("C04_" + entry2.getKey(), entry2.getValue());
            }
        }
        Map<String, String> map5 = aqVar.f;
        StringBuilder sb3 = new StringBuilder();
        sb3.append(!userInfoBean.l);
        map5.put("A36", sb3.toString());
        Map<String, String> map6 = aqVar.f;
        StringBuilder sb4 = new StringBuilder();
        sb4.append(userInfoBean.g);
        map6.put("F02", sb4.toString());
        Map<String, String> map7 = aqVar.f;
        StringBuilder sb5 = new StringBuilder();
        sb5.append(userInfoBean.h);
        map7.put("F03", sb5.toString());
        Map<String, String> map8 = aqVar.f;
        map8.put("F04", userInfoBean.j);
        Map<String, String> map9 = aqVar.f;
        StringBuilder sb6 = new StringBuilder();
        sb6.append(userInfoBean.i);
        map9.put("F05", sb6.toString());
        Map<String, String> map10 = aqVar.f;
        map10.put("F06", userInfoBean.m);
        Map<String, String> map11 = aqVar.f;
        StringBuilder sb7 = new StringBuilder();
        sb7.append(userInfoBean.k);
        map11.put("F10", sb7.toString());
        x.c("summary type %d vm:%d", Byte.valueOf(aqVar.b), Integer.valueOf(aqVar.f.size()));
        return aqVar;
    }

    public static ar a(List<UserInfoBean> list, int i) {
        com.tencent.bugly.crashreport.common.info.a b;
        if (list == null || list.size() == 0 || (b = com.tencent.bugly.crashreport.common.info.a.b()) == null) {
            return null;
        }
        b.o();
        ar arVar = new ar();
        arVar.b = b.d;
        arVar.f21690c = b.h();
        ArrayList<aq> arrayList = new ArrayList<>();
        for (UserInfoBean userInfoBean : list) {
            aq a2 = a(userInfoBean);
            if (a2 != null) {
                arrayList.add(a2);
            }
        }
        arVar.d = arrayList;
        arVar.e = new HashMap();
        Map<String, String> map = arVar.e;
        map.put("A7", b.g);
        Map<String, String> map2 = arVar.e;
        map2.put("A6", b.n());
        Map<String, String> map3 = arVar.e;
        map3.put("A5", b.m());
        Map<String, String> map4 = arVar.e;
        StringBuilder sb = new StringBuilder();
        sb.append(b.k());
        map4.put("A2", sb.toString());
        Map<String, String> map5 = arVar.e;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(b.k());
        map5.put("A1", sb2.toString());
        Map<String, String> map6 = arVar.e;
        map6.put("A24", b.i);
        Map<String, String> map7 = arVar.e;
        StringBuilder sb3 = new StringBuilder();
        sb3.append(b.l());
        map7.put("A17", sb3.toString());
        Map<String, String> map8 = arVar.e;
        map8.put("A15", b.q());
        Map<String, String> map9 = arVar.e;
        StringBuilder sb4 = new StringBuilder();
        sb4.append(b.r());
        map9.put("A13", sb4.toString());
        Map<String, String> map10 = arVar.e;
        map10.put("F08", b.w);
        Map<String, String> map11 = arVar.e;
        map11.put("F09", b.x);
        Map<String, String> y = b.y();
        if (y != null && y.size() > 0) {
            for (Map.Entry<String, String> entry : y.entrySet()) {
                Map<String, String> map12 = arVar.e;
                map12.put("C04_" + entry.getKey(), entry.getValue());
            }
        }
        if (i == 1) {
            arVar.f21689a = (byte) 1;
            return arVar;
        } else if (i != 2) {
            x.e("unknown up type %d ", Integer.valueOf(i));
            return null;
        } else {
            arVar.f21689a = (byte) 2;
            return arVar;
        }
    }

    public static <T extends k> T a(byte[] bArr, Class<T> cls) {
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        try {
            T newInstance = cls.newInstance();
            i iVar = new i(bArr);
            iVar.a("utf-8");
            newInstance.a(iVar);
            return newInstance;
        } catch (Throwable th) {
            if (x.b(th)) {
                return null;
            }
            th.printStackTrace();
            return null;
        }
    }

    public static String a(ArrayList<String> arrayList) {
        StringBuffer stringBuffer = new StringBuffer();
        int i = 0;
        while (true) {
            int i2 = i;
            String str = "map";
            if (i2 >= arrayList.size()) {
                Collections.reverse(arrayList);
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 >= arrayList.size()) {
                        break;
                    }
                    String str2 = arrayList.get(i4);
                    if (str2.equals("list")) {
                        int i5 = i4 - 1;
                        arrayList.set(i5, SimpleComparison.LESS_THAN_OPERATION + arrayList.get(i5));
                        arrayList.set(0, arrayList.get(0) + SimpleComparison.GREATER_THAN_OPERATION);
                    } else if (str2.equals("map")) {
                        int i6 = i4 - 1;
                        arrayList.set(i6, SimpleComparison.LESS_THAN_OPERATION + arrayList.get(i6) + ",");
                        arrayList.set(0, arrayList.get(0) + SimpleComparison.GREATER_THAN_OPERATION);
                    } else if (str2.equals("Array")) {
                        int i7 = i4 - 1;
                        arrayList.set(i7, SimpleComparison.LESS_THAN_OPERATION + arrayList.get(i7));
                        arrayList.set(0, arrayList.get(0) + SimpleComparison.GREATER_THAN_OPERATION);
                    }
                    i3 = i4 + 1;
                }
                Collections.reverse(arrayList);
                Iterator<String> it = arrayList.iterator();
                while (it.hasNext()) {
                    stringBuffer.append(it.next());
                }
                return stringBuffer.toString();
            }
            String str3 = arrayList.get(i2);
            if (str3.equals("java.lang.Integer") || str3.equals(IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL)) {
                str = "int32";
            } else if (str3.equals("java.lang.Boolean") || str3.equals(TypedValues.Custom.S_BOOLEAN)) {
                str = "bool";
            } else if (str3.equals("java.lang.Byte") || str3.equals("byte")) {
                str = "char";
            } else if (str3.equals("java.lang.Double") || str3.equals("double")) {
                str = "double";
            } else if (str3.equals("java.lang.Float") || str3.equals(TypedValues.Custom.S_FLOAT)) {
                str = TypedValues.Custom.S_FLOAT;
            } else if (str3.equals("java.lang.Long") || str3.equals("long")) {
                str = "int64";
            } else if (str3.equals("java.lang.Short") || str3.equals(Geo2AddressParam.PoiOptions.ADDRESS_FORMAT_SHORT)) {
                str = Geo2AddressParam.PoiOptions.ADDRESS_FORMAT_SHORT;
            } else if (str3.equals("java.lang.Character")) {
                throw new IllegalArgumentException("can not support java.lang.Character");
            } else {
                if (str3.equals("java.lang.String")) {
                    str = "string";
                } else if (str3.equals("java.util.List")) {
                    str = "list";
                } else if (!str3.equals("java.util.Map")) {
                    str = str3;
                }
            }
            arrayList.set(i2, str);
            i = i2 + 1;
        }
    }

    public static void a(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            e = null;
        } else {
            e = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(str, i));
        }
    }

    public static void a(InetAddress inetAddress, int i) {
        if (inetAddress == null) {
            e = null;
        } else {
            e = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(inetAddress, i));
        }
    }

    private void a(ArrayList<String> arrayList, Object obj) {
        if (obj.getClass().isArray()) {
            if (!obj.getClass().getComponentType().toString().equals("byte")) {
                throw new IllegalArgumentException("only byte[] is supported");
            }
            if (Array.getLength(obj) > 0) {
                arrayList.add("java.util.List");
                a(arrayList, Array.get(obj, 0));
                return;
            }
            arrayList.add("Array");
            arrayList.add("?");
        } else if (obj instanceof Array) {
            throw new IllegalArgumentException("can not support Array, please use List");
        } else {
            if (obj instanceof List) {
                arrayList.add("java.util.List");
                List list = (List) obj;
                if (list.size() > 0) {
                    a(arrayList, list.get(0));
                } else {
                    arrayList.add("?");
                }
            } else if (!(obj instanceof Map)) {
                arrayList.add(obj.getClass().getName());
            } else {
                arrayList.add("java.util.Map");
                Map map = (Map) obj;
                if (map.size() <= 0) {
                    arrayList.add("?");
                    arrayList.add("?");
                    return;
                }
                Object next = map.keySet().iterator().next();
                Object obj2 = map.get(next);
                arrayList.add(next.getClass().getName());
                a(arrayList, obj2);
            }
        }
    }

    public static byte[] a(k kVar) {
        try {
            j jVar = new j();
            jVar.a("utf-8");
            kVar.a(jVar);
            return jVar.b();
        } catch (Throwable th) {
            if (x.b(th)) {
                return null;
            }
            th.printStackTrace();
            return null;
        }
    }

    public static byte[] a(Object obj) {
        try {
            d dVar = new d();
            dVar.c();
            dVar.a("utf-8");
            dVar.a(1);
            dVar.b("RqdServer");
            dVar.c("sync");
            dVar.a("detail", (String) obj);
            return dVar.a();
        } catch (Throwable th) {
            if (x.b(th)) {
                return null;
            }
            th.printStackTrace();
            return null;
        }
    }

    public static an b(byte[] bArr) {
        if (bArr != null) {
            try {
                d dVar = new d();
                dVar.c();
                dVar.a("utf-8");
                dVar.a(bArr);
                Object b = dVar.b("detail", new an());
                an anVar = null;
                if (an.class.isInstance(b)) {
                    anVar = (an) an.class.cast(b);
                }
                return anVar;
            } catch (Throwable th) {
                if (x.b(th)) {
                    return null;
                }
                th.printStackTrace();
                return null;
            }
        }
        return null;
    }

    public static Proxy b() {
        return e;
    }

    public void a(String str) {
        this.b = str;
    }

    public <T> void a(String str, T t) {
        if (str == null) {
            throw new IllegalArgumentException("put key can not is null");
        }
        if (t == null) {
            throw new IllegalArgumentException("put value can not is null");
        }
        if (t instanceof Set) {
            throw new IllegalArgumentException("can not support Set");
        }
        j jVar = new j();
        jVar.a(this.b);
        jVar.a(t, 0);
        byte[] a2 = l.a(jVar.a());
        HashMap<String, byte[]> hashMap = new HashMap<>(1);
        ArrayList<String> arrayList = new ArrayList<>(1);
        a(arrayList, t);
        hashMap.put(a(arrayList), a2);
        this.d.remove(str);
        this.f21665a.put(str, hashMap);
    }

    public void a(byte[] bArr) {
        this.f21666c.a(bArr);
        this.f21666c.a(this.b);
        HashMap hashMap = new HashMap(1);
        HashMap hashMap2 = new HashMap(1);
        hashMap2.put("", new byte[0]);
        hashMap.put("", hashMap2);
        this.f21665a = this.f21666c.a((Map) hashMap, 0, false);
    }

    public byte[] a() {
        j jVar = new j(0);
        jVar.a(this.b);
        jVar.a((Map) this.f21665a, 0);
        return l.a(jVar.a());
    }
}
