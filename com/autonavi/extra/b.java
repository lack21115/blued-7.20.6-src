package com.autonavi.extra;

import android.text.TextUtils;
import com.huawei.openalliance.ad.constant.t;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: source-8756600-dex2jar.jar:com/autonavi/extra/b.class */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private List<a> f6449a = new ArrayList();

    public final void a() {
        synchronized (b.class) {
            try {
                if (this.f6449a != null) {
                    this.f6449a.add(null);
                }
            } finally {
            }
        }
    }

    public final void b() {
        synchronized (b.class) {
            try {
                Iterator<a> it = this.f6449a.iterator();
                while (it.hasNext()) {
                    it.next();
                }
            } finally {
            }
        }
    }

    public final void c() {
        synchronized (b.class) {
            try {
                Iterator<a> it = this.f6449a.iterator();
                while (it.hasNext()) {
                    it.next();
                }
            } finally {
            }
        }
    }

    public final void d() {
        synchronized (b.class) {
            try {
                Iterator<a> it = this.f6449a.iterator();
                while (it.hasNext()) {
                    it.next();
                }
            } finally {
            }
        }
    }

    public final void e() {
        synchronized (b.class) {
            try {
                Iterator<a> it = this.f6449a.iterator();
                while (it.hasNext()) {
                    it.next();
                }
            } finally {
            }
        }
    }

    public final void f() {
        synchronized (b.class) {
            try {
                Iterator<a> it = this.f6449a.iterator();
                while (it.hasNext()) {
                    it.next();
                }
                this.f6449a.clear();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final String g() {
        String stringBuffer;
        synchronized (b.class) {
            try {
                StringBuffer stringBuffer2 = new StringBuffer();
                for (a aVar : this.f6449a) {
                    if (aVar != null) {
                        String a2 = aVar.a();
                        if (!TextUtils.isEmpty(a2)) {
                            stringBuffer2.append(a2);
                            if (!a2.endsWith(t.aE)) {
                                stringBuffer2.append(t.aE);
                            }
                        }
                    }
                }
                stringBuffer = stringBuffer2.toString();
            } catch (Throwable th) {
                throw th;
            }
        }
        return stringBuffer;
    }

    public final void h() {
        synchronized (b.class) {
            try {
                Iterator<a> it = this.f6449a.iterator();
                while (it.hasNext()) {
                    it.next();
                }
            } finally {
            }
        }
    }

    public final void i() {
        synchronized (b.class) {
            try {
                Iterator<a> it = this.f6449a.iterator();
                while (it.hasNext()) {
                    it.next();
                }
            } finally {
            }
        }
    }

    public final Object j() {
        Object b;
        synchronized (b.class) {
            try {
                for (a aVar : this.f6449a) {
                    if (aVar != null && (b = aVar.b()) != null) {
                        return b;
                    }
                }
                return null;
            } finally {
            }
        }
    }
}
