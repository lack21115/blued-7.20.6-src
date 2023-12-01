package com.tencent.tmsqmsp.sdk.e;

import com.tencent.tmsqmsp.sdk.c.f;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsqmsp/sdk/e/a.class */
public class a {

    /* renamed from: com.tencent.tmsqmsp.sdk.e.a$a  reason: collision with other inner class name */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsqmsp/sdk/e/a$a.class */
    public static final class RunnableC1046a implements Runnable {
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
        f.i().c().post(new RunnableC1046a());
    }
}
