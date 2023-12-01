package com.oplus.log.b.a;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import com.oplus.log.d.f;
import java.util.HashMap;

/* loaded from: source-8303388-dex2jar.jar:com/oplus/log/b/a/e.class */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    private com.oplus.log.f.d f10635a;

    public e(com.oplus.log.f.d dVar) {
        this.f10635a = dVar;
    }

    public final void a(Context context) {
        HashMap hashMap = new HashMap();
        hashMap.put("Model", Build.PRODUCT);
        hashMap.put("BrandOS_version", f.a());
        hashMap.put("SDK_version", Build.VERSION.RELEASE);
        hashMap.put("ROM_version", Build.DISPLAY);
        hashMap.put("RAMSize", String.valueOf(com.oplus.log.d.e.a().get("MemTotal:")));
        hashMap.put("InternalFreeSpace", String.valueOf(com.oplus.log.d.c.a(Environment.getDataDirectory()) / 1024));
        hashMap.put("App_version", com.oplus.log.d.b.c(context));
        hashMap.put("App_versioncode", String.valueOf(com.oplus.log.d.b.d(context)));
        if (this.f10635a != null) {
            this.f10635a.a(new com.oplus.log.b.b("BASE_INFO", "record_base_info", (byte) 4, null, hashMap));
        }
    }
}
