package com.tencent.thumbplayer.tplayer.a.b;

import com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadProxyEnum;
import com.tencent.thumbplayer.utils.TPLogUtil;
import java.io.Serializable;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/tplayer/a/b/a.class */
public class a implements Serializable {
    @InterfaceC0855a(a = "flowid")

    /* renamed from: a  reason: collision with root package name */
    private String f25676a = "";
    @InterfaceC0855a(a = TPDownloadProxyEnum.USER_GUID)
    private String b = "";
    @InterfaceC0855a(a = "seq")

    /* renamed from: c  reason: collision with root package name */
    private int f25677c = -1;
    @InterfaceC0855a(a = "platformtype")
    private int d = -1;
    @InterfaceC0855a(a = "devtype")
    private int e = -1;
    @InterfaceC0855a(a = "networktype")
    private int f = -1;
    @InterfaceC0855a(a = "devicename")
    private String g = "";
    @InterfaceC0855a(a = "osver")
    private String h = "";
    @InterfaceC0855a(a = "appname")
    private String i = "";
    @InterfaceC0855a(a = "appver")
    private String j = "";
    @InterfaceC0855a(a = "playerver")
    private String k = "";
    @InterfaceC0855a(a = "reportprotocolver")
    private String l = "";
    @InterfaceC0855a(a = "durationms")
    private long m = -1;
    @InterfaceC0855a(a = "hlssourcetype")
    private int n = -1;
    @InterfaceC0855a(a = "playertype")
    private int o = -1;
    @InterfaceC0855a(a = "urlprotocol")
    private int p = -1;
    @InterfaceC0855a(a = "containerformat")
    private String q = "";
    @InterfaceC0855a(a = "videoencodefmt")
    private int r = -1;
    @InterfaceC0855a(a = "audioencodefmt")
    private int s = -1;
    @InterfaceC0855a(a = "subtitleencodefmt")
    private int t = -1;
    @InterfaceC0855a(a = "streambitratekbps")
    private long u = -1;
    @InterfaceC0855a(a = "videoframerate")
    private float v = -1.0f;
    @InterfaceC0855a(a = "url")
    private String w = "";
    @InterfaceC0855a(a = "resolution")
    private String x = "";
    @InterfaceC0855a(a = "datatransportver")
    private String y = "";
    @InterfaceC0855a(a = "speedkbps")
    private int z = -1;
    @InterfaceC0855a(a = "usedatatransport")
    private int A = -1;
    @InterfaceC0855a(a = "datatransportprotocolver")
    private String B = "";
    @InterfaceC0855a(a = "cdnuip")
    private String C = "";
    @InterfaceC0855a(a = "cdnip")
    private String D = "";
    @InterfaceC0855a(a = "platform")
    private int E = -1;
    @InterfaceC0855a(a = "playerconfig")
    private String F = "";
    @InterfaceC0855a(a = "drmability")
    private int G = -1;
    private Map<String, String> H = null;
    private Map<String, String> I = null;
    private Map<String, String> J = null;
    private Map<String, String> K = null;

    @Target({ElementType.FIELD})
    @Retention(RetentionPolicy.RUNTIME)
    /* renamed from: com.tencent.thumbplayer.tplayer.a.b.a$a  reason: collision with other inner class name */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/tplayer/a/b/a$a.class */
    public @interface InterfaceC0855a {
        String a() default "";
    }

    private String a(Field field) {
        try {
            field.setAccessible(true);
            if (field.getType() == Integer.TYPE) {
                return String.valueOf(field.getInt(this));
            }
            if (field.getType() == Long.TYPE) {
                return String.valueOf(field.getLong(this));
            }
            if (field.getType() == Float.TYPE) {
                return String.valueOf(field.getFloat(this));
            }
            if (field.getType() == Boolean.TYPE) {
                return String.valueOf(field.getBoolean(this));
            }
            if (field.getType() == String.class) {
                return (String) field.get(this);
            }
            String name = getClass().getName();
            TPLogUtil.e(name, "getFieldValue field:" + field.getName() + " is not match.");
            return "-1";
        } catch (Exception e) {
            TPLogUtil.e(getClass().getName(), e);
            return "-1";
        }
    }

    private Map<String, String> a(Field[] fieldArr) {
        HashMap hashMap = new HashMap();
        int length = fieldArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return hashMap;
            }
            Field field = fieldArr[i2];
            InterfaceC0855a interfaceC0855a = (InterfaceC0855a) field.getAnnotation(InterfaceC0855a.class);
            if (interfaceC0855a != null) {
                hashMap.put(interfaceC0855a.a(), a(field));
            }
            i = i2 + 1;
        }
    }

    private static void a(Map<String, String> map, Map<String, String> map2) {
        for (Map.Entry<String, String> entry : map2.entrySet()) {
            if (map.containsKey(entry.getKey())) {
                map.put(entry.getKey(), entry.getValue());
            }
        }
    }

    private void c() {
        Map<String, String> map;
        Map<String, String> map2 = this.H;
        if (map2 == null || (map = this.J) == null) {
            return;
        }
        a(map2, map);
    }

    private void d() {
        Map<String, String> map;
        Map<String, String> map2 = this.I;
        if (map2 == null || (map = this.K) == null) {
            return;
        }
        a(map2, map);
    }

    public String a() {
        return this.f25676a;
    }

    public void a(float f) {
        this.v = f;
    }

    public void a(int i) {
        this.f25677c = i;
    }

    public void a(long j) {
        this.m = j;
    }

    public void a(a aVar) {
        this.f25676a = aVar.f25676a;
        this.b = aVar.b;
        this.f25677c = aVar.f25677c;
        this.d = aVar.d;
        this.e = aVar.e;
        this.f = aVar.f;
        this.g = aVar.g;
        this.h = aVar.h;
        this.i = aVar.i;
        this.k = aVar.k;
        this.j = aVar.j;
        this.l = aVar.l;
        this.m = aVar.m;
        this.n = aVar.n;
        this.o = aVar.o;
        this.p = aVar.p;
        this.q = aVar.q;
        this.r = aVar.r;
        this.s = aVar.s;
        this.t = aVar.t;
        this.u = aVar.u;
        this.v = aVar.v;
        this.w = aVar.w;
        this.x = aVar.x;
        this.y = aVar.y;
        this.z = aVar.z;
        this.A = aVar.A;
        this.C = aVar.C;
        this.D = aVar.D;
        this.B = aVar.B;
        this.E = aVar.E;
        this.F = aVar.F;
        this.H = aVar.H;
        this.I = aVar.I;
        this.J = aVar.J;
        this.K = aVar.K;
        this.G = aVar.G;
    }

    public void a(String str) {
        this.f25676a = str;
    }

    public void a(Map<String, String> map) {
        this.H = map;
    }

    public Map<String, String> b() {
        HashMap hashMap = new HashMap();
        Class<? super Object> superclass = getClass().getSuperclass();
        if (superclass != null) {
            hashMap.putAll(a(superclass.getDeclaredFields()));
        }
        hashMap.putAll(a(getClass().getDeclaredFields()));
        c();
        d();
        Map<String, String> map = this.H;
        if (map != null) {
            hashMap.putAll(map);
        }
        Map<String, String> map2 = this.J;
        if (map2 != null) {
            hashMap.putAll(map2);
        }
        Map<String, String> map3 = this.I;
        if (map3 != null) {
            hashMap.putAll(map3);
        }
        Map<String, String> map4 = this.K;
        if (map4 != null) {
            hashMap.putAll(map4);
        }
        return hashMap;
    }

    public void b(int i) {
        this.d = i;
    }

    public void b(long j) {
        this.u = j;
    }

    public void b(String str) {
        this.b = str;
    }

    public void b(Map<String, String> map) {
        this.I = map;
    }

    public void c(int i) {
        this.e = i;
    }

    public void c(String str) {
        this.g = str;
    }

    public void c(Map<String, String> map) {
        this.J = map;
    }

    public void d(int i) {
        this.f = i;
    }

    public void d(String str) {
        this.h = str;
    }

    public void d(Map<String, String> map) {
        this.K = map;
    }

    public void e(int i) {
        this.n = i;
    }

    public void e(String str) {
        this.i = str;
    }

    public void f(int i) {
        this.o = i;
    }

    public void f(String str) {
        this.k = str;
    }

    public void g(int i) {
        this.p = i;
    }

    public void g(String str) {
        this.j = str;
    }

    public void h(int i) {
        this.r = i;
    }

    public void h(String str) {
        this.l = str;
    }

    public void i(int i) {
        this.s = i;
    }

    public void i(String str) {
        this.q = str;
    }

    public void j(int i) {
        this.t = i;
    }

    public void j(String str) {
        this.w = str;
    }

    public void k(int i) {
        this.z = i;
    }

    public void k(String str) {
        this.x = str;
    }

    public void l(int i) {
        this.A = i;
    }

    public void l(String str) {
        this.y = str;
    }

    public void m(int i) {
        this.E = i;
    }

    public void m(String str) {
        this.C = str;
    }

    public void n(int i) {
        this.G = i;
    }

    public void n(String str) {
        this.D = str;
    }

    public void o(String str) {
        this.B = str;
    }

    public void p(String str) {
        this.F = str;
    }
}
