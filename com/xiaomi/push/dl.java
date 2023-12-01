package com.xiaomi.push;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/dl.class */
public class dl {

    /* renamed from: a  reason: collision with root package name */
    private static volatile dl f41339a;

    /* renamed from: a  reason: collision with other field name */
    private dk f306a;

    public static dl a() {
        if (f41339a == null) {
            synchronized (dl.class) {
                try {
                    if (f41339a == null) {
                        f41339a = new dl();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f41339a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public dk m11623a() {
        return this.f306a;
    }

    public void a(dk dkVar) {
        this.f306a = dkVar;
    }
}
