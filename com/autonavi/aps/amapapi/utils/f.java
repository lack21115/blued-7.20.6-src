package com.autonavi.aps.amapapi.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.amap.api.col.3sl.ht;
import com.amap.api.col.3sl.mt;
import com.amap.api.location.AMapLocation;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: source-8756600-dex2jar.jar:com/autonavi/aps/amapapi/utils/f.class */
public final class f {
    private static f f;
    private static long i;
    private File d;
    private String e;
    private Context g;
    private boolean h;

    /* renamed from: c  reason: collision with root package name */
    private LinkedHashMap<String, Long> f6442c = new LinkedHashMap<>();

    /* renamed from: a  reason: collision with root package name */
    String f6441a = "";
    String b = null;

    private f(Context context) {
        this.e = null;
        Context applicationContext = context.getApplicationContext();
        this.g = applicationContext;
        String path = applicationContext.getFilesDir().getPath();
        if (this.e == null) {
            this.e = i.l(this.g);
        }
        try {
            this.d = new File(path, "reportRecorder");
        } catch (Throwable th) {
            mt.a(th);
        }
        c();
    }

    public static f a(Context context) {
        f fVar;
        synchronized (f.class) {
            try {
                if (f == null) {
                    f = new f(context);
                }
                fVar = f;
            } catch (Throwable th) {
                throw th;
            }
        }
        return fVar;
    }

    private boolean b(Context context) {
        if (this.b == null) {
            this.b = h.a(context, "pref", "lastavedate", "0");
        }
        if (this.b.equals(this.f6441a)) {
            return false;
        }
        SharedPreferences.Editor a2 = h.a(context, "pref");
        h.a(a2, "lastavedate", this.f6441a);
        h.a(a2);
        this.b = this.f6441a;
        return true;
    }

    private void c() {
        synchronized (this) {
            if (this.f6442c == null || this.f6442c.size() <= 0) {
                this.f6441a = new SimpleDateFormat("yyyyMMdd").format(new Date(System.currentTimeMillis()));
                for (String str : i.a(this.d)) {
                    try {
                        String[] split = new String(com.autonavi.aps.amapapi.security.a.b(ht.b(str), this.e), "UTF-8").split(",");
                        if (split != null && split.length > 1) {
                            this.f6442c.put(split[0], Long.valueOf(Long.parseLong(split[1])));
                        }
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    private void d() {
        try {
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<String, Long> entry : this.f6442c.entrySet()) {
                try {
                    String str = entry.getKey() + "," + entry.getValue();
                    sb.append(ht.b(com.autonavi.aps.amapapi.security.a.a(str.getBytes("UTF-8"), this.e)) + "\n");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
            String sb2 = sb.toString();
            if (TextUtils.isEmpty(sb2)) {
                return;
            }
            i.a(this.d, sb2);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void a() {
        synchronized (this) {
            if (this.h) {
                d();
                this.h = false;
            }
        }
    }

    public final void a(AMapLocation aMapLocation) {
        synchronized (this) {
            try {
                if ((!this.f6442c.containsKey(this.f6441a) && this.f6442c.size() >= 8) || (this.f6442c.containsKey(this.f6441a) && this.f6442c.size() >= 9)) {
                    ArrayList<String> arrayList = new ArrayList();
                    Iterator<Map.Entry<String, Long>> it = this.f6442c.entrySet().iterator();
                    do {
                        if (!it.hasNext()) {
                            break;
                        }
                        arrayList.add(it.next().getKey());
                    } while (arrayList.size() != this.f6442c.size() - 7);
                    for (String str : arrayList) {
                        this.f6442c.remove(str);
                    }
                }
                if (aMapLocation.getErrorCode() != 0) {
                    return;
                }
                if (aMapLocation.getLocationType() != 6 && aMapLocation.getLocationType() != 5) {
                    if (this.f6442c.containsKey(this.f6441a)) {
                        long longValue = this.f6442c.get(this.f6441a).longValue() + 1;
                        i = longValue;
                        this.f6442c.put(this.f6441a, Long.valueOf(longValue));
                    } else {
                        this.f6442c.put(this.f6441a, 1L);
                        i = 1L;
                    }
                    if (i != 0 && i % 100 == 0) {
                        a();
                    }
                    this.h = true;
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public final void b() {
        synchronized (this) {
            try {
                if (b(this.g)) {
                    for (Map.Entry<String, Long> entry : this.f6442c.entrySet()) {
                        if (!this.f6441a.equals(entry.getKey())) {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("param_long_first", entry.getKey());
                            jSONObject.put("param_long_second", entry.getValue());
                            g.a(this.g, "O023", jSONObject);
                        }
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }
}
