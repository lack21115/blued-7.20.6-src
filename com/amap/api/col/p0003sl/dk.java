package com.amap.api.col.p0003sl;

import android.content.Context;
import android.text.TextUtils;
import com.alipay.sdk.util.i;
import com.amap.api.maps.model.LatLng;
import java.lang.ref.WeakReference;
import java.util.Hashtable;

/* renamed from: com.amap.api.col.3sl.dk  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/dk.class */
public class dk {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f4856a = false;
    private static volatile dk d;
    private Hashtable<String, String> b = new Hashtable<>();

    /* renamed from: c  reason: collision with root package name */
    private WeakReference<Context> f4857c = null;

    private dk() {
    }

    public static dk a() {
        if (d == null) {
            synchronized (dk.class) {
                try {
                    if (d == null) {
                        d = new dk();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return d;
    }

    private void a(String str) {
        Hashtable<String, String> hashtable;
        if (str == null || (hashtable = this.b) == null) {
            return;
        }
        synchronized (hashtable) {
            String b = hw.b(str);
            if (this.b != null && !this.b.contains(b)) {
                this.b.put(b, str);
            }
            if (e()) {
                d();
            }
        }
    }

    public static void a(boolean z) {
        f4856a = z;
    }

    public static void b() {
        if (d != null) {
            if (d.b != null && d.b.size() > 0) {
                synchronized (d.b) {
                    d.d();
                    if (d.f4857c != null) {
                        d.f4857c.clear();
                    }
                }
            }
            d = null;
        }
        a(false);
    }

    public static boolean c() {
        return f4856a;
    }

    private void d() {
        WeakReference<Context> weakReference;
        if (!f4856a) {
            this.b.clear();
        } else if (this.b != null) {
            StringBuffer stringBuffer = new StringBuffer();
            int i = 0;
            int size = this.b.size();
            if (size > 0) {
                stringBuffer.append("[");
                for (String str : this.b.values()) {
                    int i2 = i + 1;
                    stringBuffer.append(str);
                    i = i2;
                    if (i2 < size) {
                        stringBuffer.append(",");
                        i = i2;
                    }
                }
                stringBuffer.append("]");
                String stringBuffer2 = stringBuffer.toString();
                if (!TextUtils.isEmpty(stringBuffer2) && (weakReference = this.f4857c) != null && weakReference.get() != null) {
                    kg.a(stringBuffer2, this.f4857c.get());
                }
            }
            this.b.clear();
        }
    }

    private boolean e() {
        Hashtable<String, String> hashtable = this.b;
        return hashtable != null && hashtable.size() > 20;
    }

    public final void a(Context context) {
        if (context != null) {
            this.f4857c = new WeakReference<>(context);
        }
    }

    public final void a(LatLng latLng, String str, String str2) {
        if (!f4856a) {
            this.b.clear();
        } else if (latLng == null || TextUtils.isEmpty(str)) {
        } else {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("{");
            stringBuffer.append("\"lon\":");
            stringBuffer.append(latLng.longitude);
            stringBuffer.append(",");
            stringBuffer.append("\"lat\":");
            stringBuffer.append(latLng.latitude);
            stringBuffer.append(",");
            stringBuffer.append("\"title\":\"");
            stringBuffer.append(str);
            stringBuffer.append("\",");
            String str3 = str2;
            if (TextUtils.isEmpty(str2)) {
                str3 = "";
            }
            stringBuffer.append("\"snippet\":\"");
            stringBuffer.append(str3);
            stringBuffer.append("\"");
            stringBuffer.append(i.d);
            a(stringBuffer.toString());
        }
    }
}
