package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/mipush/sdk/af.class */
public class af {

    /* renamed from: a  reason: collision with root package name */
    private static volatile af f27509a;

    /* renamed from: a  reason: collision with other field name */
    private Context f76a;

    /* renamed from: a  reason: collision with other field name */
    private List<x> f77a = new ArrayList();

    private af(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.f76a = applicationContext;
        if (applicationContext == null) {
            this.f76a = context;
        }
    }

    public static af a(Context context) {
        if (f27509a == null) {
            synchronized (af.class) {
                try {
                    if (f27509a == null) {
                        f27509a = new af(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f27509a;
    }

    public int a(String str) {
        x next;
        synchronized (this.f77a) {
            x xVar = new x();
            xVar.f118a = str;
            if (this.f77a.contains(xVar)) {
                Iterator<x> it = this.f77a.iterator();
                do {
                    if (it.hasNext()) {
                        next = it.next();
                    }
                } while (!next.equals(xVar));
                return next.f27547a;
            }
            return 0;
        }
    }

    public String a(au auVar) {
        String string;
        synchronized (this) {
            string = this.f76a.getSharedPreferences("mipush_extra", 0).getString(auVar.name(), "");
        }
        return string;
    }

    public void a(au auVar, String str) {
        synchronized (this) {
            SharedPreferences sharedPreferences = this.f76a.getSharedPreferences("mipush_extra", 0);
            sharedPreferences.edit().putString(auVar.name(), str).commit();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m8377a(String str) {
        synchronized (this.f77a) {
            x xVar = new x();
            xVar.f27547a = 0;
            xVar.f118a = str;
            if (this.f77a.contains(xVar)) {
                this.f77a.remove(xVar);
            }
            this.f77a.add(xVar);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m8378a(String str) {
        synchronized (this.f77a) {
            x xVar = new x();
            xVar.f118a = str;
            return this.f77a.contains(xVar);
        }
    }

    public void b(String str) {
        synchronized (this.f77a) {
            x xVar = new x();
            xVar.f118a = str;
            x xVar2 = xVar;
            if (this.f77a.contains(xVar)) {
                Iterator<x> it = this.f77a.iterator();
                do {
                    xVar2 = xVar;
                    if (!it.hasNext()) {
                        break;
                    }
                    xVar2 = it.next();
                } while (!xVar.equals(xVar2));
            }
            xVar2.f27547a++;
            this.f77a.remove(xVar2);
            this.f77a.add(xVar2);
        }
    }

    public void c(String str) {
        synchronized (this.f77a) {
            x xVar = new x();
            xVar.f118a = str;
            if (this.f77a.contains(xVar)) {
                this.f77a.remove(xVar);
            }
        }
    }
}
