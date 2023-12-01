package com.getui.gtc.a;

import android.text.TextUtils;
import com.getui.gtc.base.util.ScheduleQueue;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: source-8110460-dex2jar.jar:com/getui/gtc/a/a.class */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static final AtomicBoolean f8262a = new AtomicBoolean(false);

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String str2 = str;
        if (str.contains("|")) {
            str2 = str.replace("|", "$");
        }
        return str2;
    }

    public static void a() {
        if (f8262a.getAndSet(true)) {
            return;
        }
        c cVar = new c();
        d dVar = new d();
        e eVar = new e();
        f fVar = new f();
        for (int i = 0; i < 4; i++) {
            ScheduleQueue.getInstance().addSchedule(new b[]{cVar, dVar, eVar, fVar}[i], 10000L);
        }
    }
}
