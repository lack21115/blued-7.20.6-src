package com.tencent.tmsqmsp.sdk.e;

import android.content.Context;
import com.tencent.mapsdk.internal.oj;
import com.tencent.tmsqmsp.sdk.c.f;
import com.tencent.tmsqmsp.sdk.c.h;
import com.tencent.tmsqmsp.sdk.c.i;
import com.tencent.tmsqmsp.sdk.f.g;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsqmsp/sdk/e/b.class */
public class b {

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsqmsp/sdk/e/b$a.class */
    public static final class a implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            Context context;
            Context context2;
            try {
                context = oj.getContext();
                if (context == null) {
                    g.d("qmsp.cbid", 2, "Context is null!");
                    return;
                }
                context2 = oj.getContext();
                h.a(context2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void a() {
        f.i().c().postDelayed(new a(), i.f);
    }
}
