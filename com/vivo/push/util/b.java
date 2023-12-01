package com.vivo.push.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Base64;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/vivo/push/util/b.class */
public class b {

    /* renamed from: a  reason: collision with root package name */
    protected Context f41131a;
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private volatile SharedPreferences f41132c;
    private HashMap<String, String> d = new HashMap<>();
    private HashMap<String, Long> e = new HashMap<>();
    private HashMap<String, Integer> f = new HashMap<>();
    private HashMap<String, Boolean> g = new HashMap<>();

    public static void a(SharedPreferences.Editor editor) {
        if (editor == null) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            editor.apply();
        } else {
            editor.commit();
        }
    }

    private void a(Map<String, String> map) {
        if (map.size() > 0) {
            b();
            if (this.f41132c != null) {
                SharedPreferences.Editor edit = this.f41132c.edit();
                for (String str : map.keySet()) {
                    String str2 = map.get(str);
                    this.d.put(str, str2);
                    edit.putString(str, str2);
                }
                a(edit);
            }
        }
    }

    private void b() {
        if (this.f41132c == null) {
            Context context = this.f41131a;
            if (context == null) {
                throw new RuntimeException("SharedPreferences is not init", new Throwable());
            }
            this.f41132c = context.getSharedPreferences(this.b, 0);
        }
    }

    private List<String> c(String str) {
        Object a2;
        String[] split;
        if (this.f41131a == null) {
            p.c("BaseSharePreference", " parsLocalIv error mContext is null ");
            return null;
        }
        ArrayList arrayList = new ArrayList();
        try {
            a2 = z.a(this.f41131a, this.f41131a.getPackageName(), str);
        } catch (Exception e) {
            p.c("BaseSharePreference", " parsLocalIv error e =" + e.getMessage());
            e.printStackTrace();
        }
        if (a2 == null) {
            return null;
        }
        String str2 = new String(Base64.decode(a2.toString(), 2));
        if (TextUtils.isEmpty(str2) || (split = str2.split(",#@")) == null || split.length < 4) {
            return null;
        }
        int length = split.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                break;
            }
            arrayList.add(split[i2].replace(",#@", ""));
            i = i2 + 1;
        }
        if (arrayList.size() < 4) {
            return null;
        }
        return arrayList;
    }

    public final int a(String str) {
        Integer num = this.f.get(str);
        if (num != null) {
            return num.intValue();
        }
        b();
        if (this.f41132c != null) {
            Integer valueOf = Integer.valueOf(this.f41132c.getInt(str, 0));
            num = valueOf;
            if (!valueOf.equals(0)) {
                this.f.put(str, valueOf);
                num = valueOf;
            }
        }
        return num.intValue();
    }

    public final void a() {
        this.e.clear();
        this.f.clear();
        this.g.clear();
        this.d.clear();
        b();
        if (this.f41132c != null) {
            SharedPreferences.Editor edit = this.f41132c.edit();
            edit.clear();
            a(edit);
        }
    }

    public final void a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            throw new RuntimeException("sharedFileName can't be null");
        }
        this.b = str;
        this.f41132c = context.getSharedPreferences(str, 0);
        this.f41131a = context;
        List<String> c2 = c("local_iv");
        if (c2 == null || c2.size() < 4) {
            p.a("BaseSharePreference", " initSecureCode error list is null ");
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("com.vivo.push.secure_sub_iv", c2.get(1));
        hashMap.put("com.vivo.push.secure_sub_key", c2.get(2));
        hashMap.put("com.vivo.push.secure_cache_iv", c2.get(3));
        hashMap.put("com.vivo.push.secure_cache_key", c2.get(0));
        a(hashMap);
    }

    public final void a(String str, int i) {
        this.f.put(str, Integer.valueOf(i));
        b();
        if (this.f41132c != null) {
            SharedPreferences.Editor edit = this.f41132c.edit();
            edit.putInt(str, i);
            a(edit);
        }
    }

    public final void a(String str, long j) {
        this.e.put(str, Long.valueOf(j));
        b();
        if (this.f41132c != null) {
            SharedPreferences.Editor edit = this.f41132c.edit();
            edit.putLong(str, j);
            a(edit);
        }
    }

    public final void a(String str, String str2) {
        this.d.put(str, str2);
        b();
        if (this.f41132c != null) {
            SharedPreferences.Editor edit = this.f41132c.edit();
            edit.putString(str, str2);
            a(edit);
        }
    }

    public final long b(String str, long j) {
        Long l = this.e.get(str);
        if (l != null) {
            return l.longValue();
        }
        b();
        if (this.f41132c != null) {
            Long valueOf = Long.valueOf(this.f41132c.getLong(str, j));
            l = valueOf;
            if (!valueOf.equals(Long.valueOf(j))) {
                this.e.put(str, valueOf);
                l = valueOf;
            }
        }
        return l.longValue();
    }

    public final String b(String str, String str2) {
        String str3 = this.d.get(str);
        if (str3 != null) {
            return str3;
        }
        b();
        if (this.f41132c != null) {
            String string = this.f41132c.getString(str, str2);
            str3 = string;
            if (!TextUtils.isEmpty(string)) {
                str3 = string;
                if (!string.equals(str2)) {
                    this.d.put(str, string);
                    str3 = string;
                }
            }
        }
        return str3;
    }

    public final void b(String str) {
        this.e.remove(str);
        this.f.remove(str);
        this.g.remove(str);
        this.d.remove(str);
        b();
        if (this.f41132c != null) {
            SharedPreferences.Editor edit = this.f41132c.edit();
            if (this.f41132c.contains(str)) {
                edit.remove(str);
                a(edit);
            }
        }
    }
}
