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
    private int f41376a;
    private Bitmap b;

    /* renamed from: c  reason: collision with root package name */
    private Bitmap f41377c;

    public en(Context context, String str) {
        super(context, str);
        this.f41376a = 16777216;
    }

    @Override // com.xiaomi.push.eq
    public en a(Bitmap bitmap) {
        if (b() && bitmap != null) {
            if (bitmap.getWidth() == 984 && 184 <= bitmap.getHeight() && bitmap.getHeight() <= 1678) {
                this.b = bitmap;
                return this;
            }
            com.xiaomi.channel.commonutils.logger.b.m11394a("colorful notification banner image resolution error, must belong to [984*184, 984*1678]");
        }
        return this;
    }

    @Override // com.xiaomi.push.eo
    /* renamed from: a */
    public en mo11720a(String str) {
        if (b() && !TextUtils.isEmpty(str)) {
            try {
                this.f41376a = Color.parseColor(str);
                return this;
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.m11394a("parse banner notification image text color error");
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
    protected String mo11725a() {
        return "notification_banner";
    }

    @Override // com.xiaomi.push.eq, com.xiaomi.push.eo
    /* renamed from: a  reason: collision with other method in class */
    public void mo11718a() {
        RemoteViews a2;
        Bitmap bitmap;
        if (!b() || this.b == null) {
            b();
            return;
        }
        super.mo11718a();
        Resources resources = mo11725a().getResources();
        String packageName = mo11725a().getPackageName();
        int a3 = a(resources, OapsKey.KEY_BG, "id", packageName);
        if (j.a(mo11725a()) >= 10) {
            a2 = mo11725a();
            bitmap = a(this.b, 30.0f);
        } else {
            a2 = mo11725a();
            bitmap = this.b;
        }
        a2.setImageViewBitmap(a3, bitmap);
        int a4 = a(resources, "icon", "id", packageName);
        if (this.f41377c != null) {
            mo11725a().setImageViewBitmap(a4, this.f41377c);
        } else {
            a(a4);
        }
        int a5 = a(resources, "title", "id", packageName);
        mo11725a().setTextViewText(a5, this.f396a);
        if (this.f399a != null && this.f41376a == 16777216) {
            mo11720a(this.f399a.get("notification_image_text_color"));
        }
        RemoteViews a6 = mo11725a();
        int i = this.f41376a;
        a6.setTextColor(a5, (i == 16777216 || !a(i)) ? -1 : -16777216);
        setCustomContentView(mo11725a());
        Bundle bundle = new Bundle();
        bundle.putBoolean("miui.customHeight", true);
        addExtras(bundle);
    }

    @Override // com.xiaomi.push.eq
    /* renamed from: a  reason: collision with other method in class */
    protected boolean mo11719a() {
        if (j.m12047a()) {
            Resources resources = mo11725a().getResources();
            String packageName = mo11725a().getPackageName();
            return (a(mo11725a().getResources(), OapsKey.KEY_BG, "id", mo11725a().getPackageName()) == 0 || a(resources, "icon", "id", packageName) == 0 || a(resources, "title", "id", packageName) == 0 || j.a(mo11725a()) < 9) ? false : true;
        }
        return false;
    }

    public en b(Bitmap bitmap) {
        if (b() && bitmap != null) {
            this.f41377c = bitmap;
        }
        return this;
    }

    @Override // com.xiaomi.push.eq
    protected String b() {
        return null;
    }
}
