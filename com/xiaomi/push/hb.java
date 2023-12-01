package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.push.service.XMPushService;
import java.io.File;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/hb.class */
public class hb implements XMPushService.n {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f27774a = false;

    /* renamed from: a  reason: collision with other field name */
    private int f493a;

    /* renamed from: a  reason: collision with other field name */
    private Context f494a;
    private boolean b;

    public hb(Context context) {
        this.f494a = context;
    }

    private String a(String str) {
        return "com.xiaomi.xmsf".equals(str) ? "1000271" : this.f494a.getSharedPreferences("pref_registered_pkg_names", 0).getString(str, null);
    }

    private void a(Context context) {
        this.b = com.xiaomi.push.service.ba.a(context).a(hl.TinyDataUploadSwitch.a(), true);
        int a2 = com.xiaomi.push.service.ba.a(context).a(hl.TinyDataUploadFrequency.a(), com.cdo.oaps.ad.p.j);
        this.f493a = a2;
        this.f493a = Math.max(60, a2);
    }

    public static void a(boolean z) {
        f27774a = z;
    }

    private boolean a() {
        return Math.abs((System.currentTimeMillis() / 1000) - this.f494a.getSharedPreferences("mipush_extra", 4).getLong("last_tiny_data_upload_timestamp", -1L)) > ((long) this.f493a);
    }

    private boolean a(hf hfVar) {
        if (!bh.b(this.f494a) || hfVar == null || TextUtils.isEmpty(a(this.f494a.getPackageName())) || !new File(this.f494a.getFilesDir(), "tiny_data.data").exists() || f27774a) {
            return false;
        }
        return !com.xiaomi.push.service.ba.a(this.f494a).a(hl.ScreenOnOrChargingTinyDataUploadSwitch.a(), false) || i.m8878a(this.f494a) || i.m8880b(this.f494a);
    }

    @Override // com.xiaomi.push.service.XMPushService.n
    /* renamed from: a  reason: collision with other method in class */
    public void mo8793a() {
        a(this.f494a);
        if (this.b && a()) {
            com.xiaomi.channel.commonutils.logger.b.m8344a("TinyData TinyDataCacheProcessor.pingFollowUpAction ts:" + System.currentTimeMillis());
            hf a2 = he.a(this.f494a).a();
            if (a(a2)) {
                f27774a = true;
                hc.a(this.f494a, a2);
                return;
            }
            com.xiaomi.channel.commonutils.logger.b.m8344a("TinyData TinyDataCacheProcessor.pingFollowUpAction !canUpload(uploader) ts:" + System.currentTimeMillis());
        }
    }
}
