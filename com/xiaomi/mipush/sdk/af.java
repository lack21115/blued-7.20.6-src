package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/mipush/sdk/af.class */
public class af {

    /* renamed from: a  reason: collision with root package name */
    private static volatile af f41200a;

    /* renamed from: a  reason: collision with other field name */
    private Context f123a;

    /* renamed from: a  reason: collision with other field name */
    private List<x> f124a = new ArrayList();

    private af(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.f123a = applicationContext;
        if (applicationContext == null) {
            this.f123a = context;
        }
    }

    public static af a(Context context) {
        if (f41200a == null) {
            synchronized (af.class) {
                try {
                    if (f41200a == null) {
                        f41200a = new af(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f41200a;
    }

    public int a(String str) {
        x next;
        synchronized (this.f124a) {
            x xVar = new x();
            xVar.f165a = str;
            if (this.f124a.contains(xVar)) {
                Iterator<x> it = this.f124a.iterator();
                do {
                    if (it.hasNext()) {
                        next = it.next();
                    }
                } while (!next.equals(xVar));
                return next.f41238a;
            }
            return 0;
        }
    }

    public String a(au auVar) {
        String string;
        synchronized (this) {
            string = this.f123a.getSharedPreferences("mipush_extra", 0).getString(auVar.name(), "");
        }
        return string;
    }

    public void a(au auVar, String str) {
        synchronized (this) {
            SharedPreferences sharedPreferences = this.f123a.getSharedPreferences("mipush_extra", 0);
            sharedPreferences.edit().putString(auVar.name(), str).commit();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m11427a(String str) {
        synchronized (this.f124a) {
            x xVar = new x();
            xVar.f41238a = 0;
            xVar.f165a = str;
            if (this.f124a.contains(xVar)) {
                this.f124a.remove(xVar);
            }
            this.f124a.add(xVar);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m11428a(String str) {
        synchronized (this.f124a) {
            x xVar = new x();
            xVar.f165a = str;
            return this.f124a.contains(xVar);
        }
    }

    public void b(String str) {
        synchronized (this.f124a) {
            x xVar = new x();
            xVar.f165a = str;
            x xVar2 = xVar;
            if (this.f124a.contains(xVar)) {
                Iterator<x> it = this.f124a.iterator();
                do {
                    xVar2 = xVar;
                    if (!it.hasNext()) {
                        break;
                    }
                    xVar2 = it.next();
                } while (!xVar.equals(xVar2));
            }
            xVar2.f41238a++;
            this.f124a.remove(xVar2);
            this.f124a.add(xVar2);
        }
    }

    public void c(String str) {
        synchronized (this.f124a) {
            x xVar = new x();
            xVar.f165a = str;
            if (this.f124a.contains(xVar)) {
                this.f124a.remove(xVar);
            }
        }
    }
}
