package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.push.service.XMPushService;
import java.io.File;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/hb.class */
public class hb implements XMPushService.n {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f41465a = false;

    /* renamed from: a  reason: collision with other field name */
    private int f540a;

    /* renamed from: a  reason: collision with other field name */
    private Context f541a;
    private boolean b;

    public hb(Context context) {
        this.f541a = context;
    }

    private String a(String str) {
        return "com.xiaomi.xmsf".equals(str) ? "1000271" : this.f541a.getSharedPreferences("pref_registered_pkg_names", 0).getString(str, null);
    }

    private void a(Context context) {
        this.b = com.xiaomi.push.service.ba.a(context).a(hl.TinyDataUploadSwitch.a(), true);
        int a2 = com.xiaomi.push.service.ba.a(context).a(hl.TinyDataUploadFrequency.a(), com.cdo.oaps.ad.p.j);
        this.f540a = a2;
        this.f540a = Math.max(60, a2);
    }

    public static void a(boolean z) {
        f41465a = z;
    }

    private boolean a() {
        return Math.abs((System.currentTimeMillis() / 1000) - this.f541a.getSharedPreferences("mipush_extra", 4).getLong("last_tiny_data_upload_timestamp", -1L)) > ((long) this.f540a);
    }

    private boolean a(hf hfVar) {
        if (!bh.b(this.f541a) || hfVar == null || TextUtils.isEmpty(a(this.f541a.getPackageName())) || !new File(this.f541a.getFilesDir(), "tiny_data.data").exists() || f41465a) {
            return false;
        }
        return !com.xiaomi.push.service.ba.a(this.f541a).a(hl.ScreenOnOrChargingTinyDataUploadSwitch.a(), false) || i.m11928a(this.f541a) || i.m11930b(this.f541a);
    }

    @Override // com.xiaomi.push.service.XMPushService.n
    /* renamed from: a  reason: collision with other method in class */
    public void mo11843a() {
        a(this.f541a);
        if (this.b && a()) {
            com.xiaomi.channel.commonutils.logger.b.m11394a("TinyData TinyDataCacheProcessor.pingFollowUpAction ts:" + System.currentTimeMillis());
            hf a2 = he.a(this.f541a).a();
            if (a(a2)) {
                f41465a = true;
                hc.a(this.f541a, a2);
                return;
            }
            com.xiaomi.channel.commonutils.logger.b.m11394a("TinyData TinyDataCacheProcessor.pingFollowUpAction !canUpload(uploader) ts:" + System.currentTimeMillis());
        }
    }
}
