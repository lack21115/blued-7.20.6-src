package com.tencent.qmsp.sdk.e;

import com.tencent.qmsp.sdk.c.f;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qmsp/sdk/e/a.class */
public class a {

    /* renamed from: com.tencent.qmsp.sdk.e.a$a  reason: collision with other inner class name */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/qmsp/sdk/e/a$a.class */
    static final class RunnableC0989a implements Runnable {
        RunnableC0989a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                f.i().b().a(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void a() {
        f.i().c().post(new RunnableC0989a());
    }
}
