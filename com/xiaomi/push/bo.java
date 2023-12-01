package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.push.ai;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/bo.class */
public class bo extends ai.a {

    /* renamed from: a  reason: collision with root package name */
    private Context f27596a;

    public bo(Context context) {
        this.f27596a = context;
    }

    private boolean a() {
        return com.xiaomi.clientreport.manager.a.a(this.f27596a).m8350a().isEventUploadSwitchOpen();
    }

    @Override // com.xiaomi.push.ai.a
    /* renamed from: a  reason: collision with other method in class */
    public String mo8500a() {
        return "100886";
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (a()) {
                com.xiaomi.channel.commonutils.logger.b.c(this.f27596a.getPackageName() + " begin upload event");
                com.xiaomi.clientreport.manager.a.a(this.f27596a).m8352b();
            }
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
        }
    }
}
