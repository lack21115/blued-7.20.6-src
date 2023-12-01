package com.xiaomi.push;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.RemoteViews;
import com.cdo.oaps.ad.OapsKey;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/en.class */
public class en extends eq {

    /* renamed from: a  reason: collision with root package name */
    private int f27685a;
    private Bitmap b;

    /* renamed from: c  reason: collision with root package name */
    private Bitmap f27686c;

    public en(Context context, String str) {
        super(context, str);
        this.f27685a = 16777216;
    }

    @Override // com.xiaomi.push.eq
    public en a(Bitmap bitmap) {
        if (b() && bitmap != null) {
            if (bitmap.getWidth() == 984 && 184 <= bitmap.getHeight() && bitmap.getHeight() <= 1678) {
                this.b = bitmap;
                return this;
            }
            com.xiaomi.channel.commonutils.logger.b.m8344a("colorful notification banner image resolution error, must belong to [984*184, 984*1678]");
        }
        return this;
    }

    @Override // com.xiaomi.push.eo
    /* renamed from: a */
    public en mo8670a(String str) {
        if (b() && !TextUtils.isEmpty(str)) {
            try {
                this.f27685a = Color.parseColor(str);
                return this;
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.m8344a("parse banner notification image text color error");
            }
        }
        return this;
    }

    @Override // com.xiaomi.push.eq, android.app.Notification.Builder
    /* renamed from: a */
    public eq setLargeIcon(Bitmap bitmap) {
        return this;
    }

    @Override // com.xiaomi.push.eq
    /* renamed from: a */
    protected String mo8675a() {
        return "notification_banner";
    }

    @Override // com.xiaomi.push.eq, com.xiaomi.push.eo
    /* renamed from: a  reason: collision with other method in class */
    public void mo8668a() {
        RemoteViews a2;
        Bitmap bitmap;
        if (!b() || this.b == null) {
            b();
            return;
        }
        super.mo8668a();
        Resources resources = mo8675a().getResources();
        String packageName = mo8675a().getPackageName();
        int a3 = a(resources, OapsKey.KEY_BG, "id", packageName);
        if (j.a(mo8675a()) >= 10) {
            a2 = mo8675a();
            bitmap = a(this.b, 30.0f);
        } else {
            a2 = mo8675a();
            bitmap = this.b;
        }
        a2.setImageViewBitmap(a3, bitmap);
        int a4 = a(resources, "icon", "id", packageName);
        if (this.f27686c != null) {
            mo8675a().setImageViewBitmap(a4, this.f27686c);
        } else {
            a(a4);
        }
        int a5 = a(resources, "title", "id", packageName);
        mo8675a().setTextViewText(a5, this.f349a);
        if (this.f352a != null && this.f27685a == 16777216) {
            mo8670a(this.f352a.get("notification_image_text_color"));
        }
        RemoteViews a6 = mo8675a();
        int i = this.f27685a;
        a6.setTextColor(a5, (i == 16777216 || !a(i)) ? -1 : -16777216);
        setCustomContentView(mo8675a());
        Bundle bundle = new Bundle();
        bundle.putBoolean("miui.customHeight", true);
        addExtras(bundle);
    }

    @Override // com.xiaomi.push.eq
    /* renamed from: a  reason: collision with other method in class */
    protected boolean mo8669a() {
        if (j.m8997a()) {
            Resources resources = mo8675a().getResources();
            String packageName = mo8675a().getPackageName();
            return (a(mo8675a().getResources(), OapsKey.KEY_BG, "id", mo8675a().getPackageName()) == 0 || a(resources, "icon", "id", packageName) == 0 || a(resources, "title", "id", packageName) == 0 || j.a(mo8675a()) < 9) ? false : true;
        }
        return false;
    }

    public en b(Bitmap bitmap) {
        if (b() && bitmap != null) {
            this.f27686c = bitmap;
        }
        return this;
    }

    @Override // com.xiaomi.push.eq
    protected String b() {
        return null;
    }
}
