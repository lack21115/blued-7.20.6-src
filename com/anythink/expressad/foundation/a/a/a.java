package com.anythink.expressad.foundation.a.a;

import android.content.Context;
import android.content.SharedPreferences;
import com.anythink.expressad.foundation.h.o;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/foundation/a/a/a.class */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final String f7749a = a.class.getSimpleName();

    /* renamed from: c  reason: collision with root package name */
    private static volatile a f7750c;
    SharedPreferences b;

    private a() {
    }

    public static a a() {
        if (f7750c == null) {
            synchronized (a.class) {
                try {
                    if (f7750c == null) {
                        f7750c = new a();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f7750c;
    }

    private void a(String str, int i) {
        try {
            Context d = com.anythink.expressad.foundation.b.a.b().d();
            if (d == null) {
                return;
            }
            if (this.b == null && d != null) {
                this.b = d.getSharedPreferences(com.anythink.expressad.foundation.g.a.o, 0);
            }
            SharedPreferences.Editor edit = this.b.edit();
            edit.putInt(str, i);
            edit.apply();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void a(String str, long j) {
        try {
            Context d = com.anythink.expressad.foundation.b.a.b().d();
            if (d == null) {
                o.d(f7749a, "context is null in put");
                return;
            }
            if (this.b == null && d != null) {
                this.b = d.getSharedPreferences(com.anythink.expressad.foundation.g.a.o, 0);
            }
            SharedPreferences.Editor edit = this.b.edit();
            edit.putLong(str, j);
            edit.apply();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private int b(String str, int i) {
        try {
            Context d = com.anythink.expressad.foundation.b.a.b().d();
            if (d == null) {
                return i;
            }
            if (this.b == null) {
                this.b = d.getSharedPreferences(com.anythink.expressad.foundation.g.a.o, 0);
            }
            return this.b.getInt(str, i);
        } catch (Exception e) {
            e.printStackTrace();
            return i;
        }
    }

    private List<String> b() {
        ArrayList arrayList = new ArrayList();
        Context d = com.anythink.expressad.foundation.b.a.b().d();
        if (d == null) {
            return null;
        }
        if (this.b == null && d != null) {
            this.b = d.getSharedPreferences(com.anythink.expressad.foundation.g.a.o, 0);
        }
        for (Map.Entry<String, ?> entry : this.b.getAll().entrySet()) {
            arrayList.add(entry.getKey());
        }
        return arrayList;
    }

    private int c(String str) {
        try {
            Context d = com.anythink.expressad.foundation.b.a.b().d();
            if (d == null) {
                return 0;
            }
            if (this.b == null && d != null) {
                this.b = d.getSharedPreferences(com.anythink.expressad.foundation.g.a.o, 0);
            }
            return this.b.getInt(str, 0);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    private Long d(String str) {
        try {
            Context d = com.anythink.expressad.foundation.b.a.b().d();
            if (d == null) {
                o.d(f7749a, "context is null in get");
                return 0L;
            }
            if (this.b == null && d != null) {
                this.b = d.getSharedPreferences(com.anythink.expressad.foundation.g.a.o, 0);
            }
            return Long.valueOf(this.b.getLong(str, 0L));
        } catch (Exception e) {
            e.printStackTrace();
            return 0L;
        }
    }

    public final String a(String str) {
        try {
            Context d = com.anythink.expressad.foundation.b.a.b().d();
            if (d == null) {
                return null;
            }
            if (this.b == null && d != null) {
                this.b = d.getSharedPreferences(com.anythink.expressad.foundation.g.a.o, 0);
            }
            return this.b.getString(str, "");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public final void a(String str, String str2) {
        try {
            Context d = com.anythink.expressad.foundation.b.a.b().d();
            if (d == null) {
                return;
            }
            if (this.b == null && d != null) {
                this.b = d.getSharedPreferences(com.anythink.expressad.foundation.g.a.o, 0);
            }
            SharedPreferences.Editor edit = this.b.edit();
            edit.putString(str, str2);
            edit.apply();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void b(String str) {
        Context d = com.anythink.expressad.foundation.b.a.b().d();
        if (d == null) {
            return;
        }
        if (this.b == null && d != null) {
            this.b = d.getSharedPreferences(com.anythink.expressad.foundation.g.a.o, 0);
        }
        this.b.edit().remove(str).apply();
    }
}
