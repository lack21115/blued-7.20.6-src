package com.tencent.cloud.huiyansdkface.facelight.c.a;

import android.content.Context;
import android.content.Intent;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/facelight/c/a/c.class */
public class c implements com.tencent.cloud.huiyansdkface.a.a.g<String> {

    /* renamed from: a  reason: collision with root package name */
    private Context f35539a;

    public c(Context context) {
        this.f35539a = context;
    }

    @Override // com.tencent.cloud.huiyansdkface.a.a.g
    /* renamed from: a */
    public String b(List<String> list, com.tencent.cloud.huiyansdkface.a.c.d dVar) {
        if (a()) {
            com.tencent.cloud.huiyansdkface.a.d.a.b("PatchFocusModeSelector", "Gionee Phone set camera focus mode auto", new Object[0]);
            return (String) new com.tencent.cloud.huiyansdkface.a.a.b.g("auto").b(list, dVar);
        }
        return null;
    }

    public boolean a() {
        Intent intent = new Intent();
        intent.setClassName("com.gionee.account", "com.gionee.account.activity.LoginActivity");
        return this.f35539a.getPackageManager().queryIntentActivities(intent, 65536).size() > 0;
    }
}
