package com.xiaomi.push;

import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.text.format.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/gl.class */
public abstract class gl {

    /* renamed from: a  reason: collision with root package name */
    private static long f41443a;

    /* renamed from: a  reason: collision with other field name */
    public static final DateFormat f517a;

    /* renamed from: c  reason: collision with root package name */
    private static String f41444c;

    /* renamed from: a  reason: collision with other field name */
    private gp f518a;

    /* renamed from: a  reason: collision with other field name */
    private List<gi> f519a;

    /* renamed from: a  reason: collision with other field name */
    private final Map<String, Object> f520a;
    private String d;
    private String e;
    private String f;
    private String g;
    private String h;
    private String i;

    /* renamed from: a  reason: collision with other field name */
    protected static final String f516a = Locale.getDefault().getLanguage().toLowerCase();
    private static String b = null;

    static {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        f517a = simpleDateFormat;
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone(Time.TIMEZONE_UTC));
        f41444c = gw.a(5) + "-";
        f41443a = 0L;
    }

    public gl() {
        this.d = b;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.f519a = new CopyOnWriteArrayList();
        this.f520a = new HashMap();
        this.f518a = null;
    }

    public gl(Bundle bundle) {
        this.d = b;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.f519a = new CopyOnWriteArrayList();
        this.f520a = new HashMap();
        this.f518a = null;
        this.f = bundle.getString("ext_to");
        this.g = bundle.getString("ext_from");
        this.h = bundle.getString("ext_chid");
        this.e = bundle.getString("ext_pkt_id");
        Parcelable[] parcelableArray = bundle.getParcelableArray("ext_exts");
        if (parcelableArray != null) {
            this.f519a = new ArrayList(parcelableArray.length);
            int length = parcelableArray.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    break;
                }
                gi a2 = gi.a((Bundle) parcelableArray[i2]);
                if (a2 != null) {
                    this.f519a.add(a2);
                }
                i = i2 + 1;
            }
        }
        Bundle bundle2 = bundle.getBundle("ext_ERROR");
        if (bundle2 != null) {
            this.f518a = new gp(bundle2);
        }
    }

    public static String i() {
        String sb;
        synchronized (gl.class) {
            try {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(f41444c);
                long j = f41443a;
                f41443a = 1 + j;
                sb2.append(Long.toString(j));
                sb = sb2.toString();
            } catch (Throwable th) {
                throw th;
            }
        }
        return sb;
    }

    public static String q() {
        return f516a;
    }

    public Bundle a() {
        Bundle bundle = new Bundle();
        if (!TextUtils.isEmpty(this.d)) {
            bundle.putString("ext_ns", this.d);
        }
        if (!TextUtils.isEmpty(this.g)) {
            bundle.putString("ext_from", this.g);
        }
        if (!TextUtils.isEmpty(this.f)) {
            bundle.putString("ext_to", this.f);
        }
        if (!TextUtils.isEmpty(this.e)) {
            bundle.putString("ext_pkt_id", this.e);
        }
        if (!TextUtils.isEmpty(this.h)) {
            bundle.putString("ext_chid", this.h);
        }
        gp gpVar = this.f518a;
        if (gpVar != null) {
            bundle.putBundle("ext_ERROR", gpVar.a());
        }
        List<gi> list = this.f519a;
        if (list != null) {
            Bundle[] bundleArr = new Bundle[list.size()];
            int i = 0;
            for (gi giVar : this.f519a) {
                Bundle a2 = giVar.a();
                if (a2 != null) {
                    bundleArr[i] = a2;
                    i++;
                }
            }
            bundle.putParcelableArray("ext_exts", bundleArr);
        }
        return bundle;
    }

    public gi a(String str) {
        return a(str, null);
    }

    public gi a(String str, String str2) {
        for (gi giVar : this.f519a) {
            if (str2 == null || str2.equals(giVar.b())) {
                if (str.equals(giVar.m11811a())) {
                    return giVar;
                }
            }
        }
        return null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public gp m11817a() {
        return this.f518a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public Object m11818a(String str) {
        synchronized (this) {
            if (this.f520a == null) {
                return null;
            }
            return this.f520a.get(str);
        }
    }

    /* renamed from: a */
    public abstract String mo11814a();

    /* renamed from: a  reason: collision with other method in class */
    public Collection<gi> m11819a() {
        synchronized (this) {
            if (this.f519a == null) {
                return Collections.emptyList();
            }
            return Collections.unmodifiableList(new ArrayList(this.f519a));
        }
    }

    public void a(gi giVar) {
        this.f519a.add(giVar);
    }

    public void a(gp gpVar) {
        this.f518a = gpVar;
    }

    public Collection<String> b() {
        synchronized (this) {
            if (this.f520a == null) {
                return Collections.emptySet();
            }
            return Collections.unmodifiableSet(new HashSet(this.f520a.keySet()));
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        gl glVar = (gl) obj;
        gp gpVar = this.f518a;
        if (gpVar != null) {
            if (!gpVar.equals(glVar.f518a)) {
                return false;
            }
        } else if (glVar.f518a != null) {
            return false;
        }
        String str = this.g;
        if (str != null) {
            if (!str.equals(glVar.g)) {
                return false;
            }
        } else if (glVar.g != null) {
            return false;
        }
        if (this.f519a.equals(glVar.f519a)) {
            String str2 = this.e;
            if (str2 != null) {
                if (!str2.equals(glVar.e)) {
                    return false;
                }
            } else if (glVar.e != null) {
                return false;
            }
            String str3 = this.h;
            if (str3 != null) {
                if (!str3.equals(glVar.h)) {
                    return false;
                }
            } else if (glVar.h != null) {
                return false;
            }
            Map<String, Object> map = this.f520a;
            if (map != null) {
                if (!map.equals(glVar.f520a)) {
                    return false;
                }
            } else if (glVar.f520a != null) {
                return false;
            }
            String str4 = this.f;
            if (str4 != null) {
                if (!str4.equals(glVar.f)) {
                    return false;
                }
            } else if (glVar.f != null) {
                return false;
            }
            String str5 = this.d;
            String str6 = glVar.d;
            return str5 != null ? str5.equals(str6) : str6 == null;
        }
        return false;
    }

    public int hashCode() {
        String str = this.d;
        int i = 0;
        int hashCode = str != null ? str.hashCode() : 0;
        String str2 = this.e;
        int hashCode2 = str2 != null ? str2.hashCode() : 0;
        String str3 = this.f;
        int hashCode3 = str3 != null ? str3.hashCode() : 0;
        String str4 = this.g;
        int hashCode4 = str4 != null ? str4.hashCode() : 0;
        String str5 = this.h;
        int hashCode5 = str5 != null ? str5.hashCode() : 0;
        int hashCode6 = this.f519a.hashCode();
        int hashCode7 = this.f520a.hashCode();
        gp gpVar = this.f518a;
        if (gpVar != null) {
            i = gpVar.hashCode();
        }
        return (((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + hashCode7) * 31) + i;
    }

    public String j() {
        if ("ID_NOT_AVAILABLE".equals(this.e)) {
            return null;
        }
        if (this.e == null) {
            this.e = i();
        }
        return this.e;
    }

    public String k() {
        return this.h;
    }

    public void k(String str) {
        this.e = str;
    }

    public String l() {
        return this.f;
    }

    public void l(String str) {
        this.h = str;
    }

    public String m() {
        return this.g;
    }

    public void m(String str) {
        this.f = str;
    }

    public String n() {
        return this.i;
    }

    public void n(String str) {
        this.g = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:108:0x01e5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:125:0x01f4 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String o() {
        /*
            Method dump skipped, instructions count: 584
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.gl.o():java.lang.String");
    }

    public void o(String str) {
        this.i = str;
    }

    public String p() {
        return this.d;
    }
}
