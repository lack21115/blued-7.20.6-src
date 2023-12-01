package com.baidu.mobads.sdk.internal;

import com.baidu.mobads.sdk.internal.z;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: source-8756600-dex2jar.jar:com/baidu/mobads/sdk/internal/p.class */
public class p {

    /* renamed from: a  reason: collision with root package name */
    private static volatile p f9439a;
    private List<z.a> b = new CopyOnWriteArrayList();

    private p() {
    }

    public static p a() {
        if (f9439a == null) {
            synchronized (p.class) {
                try {
                    if (f9439a == null) {
                        f9439a = new p();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f9439a;
    }

    private void b(z.a aVar) {
        if (this.b.contains(aVar)) {
            this.b.remove(aVar);
        }
    }

    public void a(int i) {
        for (z.a aVar : this.b) {
            if (i == 1) {
                aVar.onSuccess();
            } else if (i == 2) {
                aVar.onFailure();
            }
            b(aVar);
        }
    }

    public void a(z.a aVar) {
        if (aVar == null || this.b.contains(aVar)) {
            return;
        }
        this.b.add(aVar);
    }
}
