package com.xiaomi.push;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/dl.class */
public class dl {

    /* renamed from: a  reason: collision with root package name */
    private static volatile dl f27648a;

    /* renamed from: a  reason: collision with other field name */
    private dk f259a;

    public static dl a() {
        if (f27648a == null) {
            synchronized (dl.class) {
                try {
                    if (f27648a == null) {
                        f27648a = new dl();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f27648a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public dk m8573a() {
        return this.f259a;
    }

    public void a(dk dkVar) {
        this.f259a = dkVar;
    }
}
