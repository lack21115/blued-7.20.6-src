package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.push.ai;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/bp.class */
public class bp extends ai.a {

    /* renamed from: a  reason: collision with root package name */
    private Context f41288a;

    public bp(Context context) {
        this.f41288a = context;
    }

    private boolean a() {
        return com.xiaomi.clientreport.manager.a.a(this.f41288a).m11400a().isPerfUploadSwitchOpen();
    }

    @Override // com.xiaomi.push.ai.a
    /* renamed from: a */
    public String mo11550a() {
        return "100887";
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (a()) {
                com.xiaomi.clientreport.manager.a.a(this.f41288a).c();
                com.xiaomi.channel.commonutils.logger.b.c(this.f41288a.getPackageName() + " perf begin upload");
            }
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.d("fail to send perf data. ".concat(String.valueOf(e)));
        }
    }
}
