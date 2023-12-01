package com.xiaomi.push;

import android.app.PendingIntent;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.RemoteViews;
import com.cdo.oaps.ad.OapsKey;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/ep.class */
public class ep extends eq {

    /* renamed from: a  reason: collision with root package name */
    private int f41379a;

    /* renamed from: a  reason: collision with other field name */
    private PendingIntent f391a;
    private int b;

    /* renamed from: b  reason: collision with other field name */
    private Bitmap f392b;

    /* renamed from: c  reason: collision with root package name */
    private int f41380c;

    /* renamed from: c  reason: collision with other field name */
    private CharSequence f393c;

    public ep(Context context, int i, String str) {
        super(context, i, str);
        this.f41379a = 16777216;
        this.b = 16777216;
        this.f41380c = 16777216;
    }

    private Drawable a(int i, int i2, int i3, float f) {
        ShapeDrawable shapeDrawable = new ShapeDrawable();
        shapeDrawable.setShape(new RoundRectShape(new float[]{f, f, f, f, f, f, f, f}, null, null));
        shapeDrawable.getPaint().setColor(i);
        shapeDrawable.getPaint().setStyle(Paint.Style.FILL);
        shapeDrawable.setIntrinsicWidth(i2);
        shapeDrawable.setIntrinsicHeight(i3);
        return shapeDrawable;
    }

    private void a(RemoteViews remoteViews, int i, int i2, int i3, boolean z) {
        int a2 = a(6.0f);
        remoteViews.setViewPadding(i, a2, 0, a2, 0);
        int i4 = z ? -1 : -16777216;
        remoteViews.setTextColor(i2, i4);
        remoteViews.setTextColor(i3, i4);
    }

    @Override // com.xiaomi.push.eq
    public ep a(Bitmap bitmap) {
        if (b() && bitmap != null) {
            if (bitmap.getWidth() == 984 && bitmap.getHeight() >= 177 && bitmap.getHeight() <= 207) {
                this.f392b = bitmap;
                return this;
            }
            com.xiaomi.channel.commonutils.logger.b.m11394a("colorful notification bg image resolution error, must [984*177, 984*207]");
        }
        return this;
    }

    public ep a(CharSequence charSequence, PendingIntent pendingIntent) {
        if (b()) {
            super.addAction(0, charSequence, pendingIntent);
            this.f393c = charSequence;
            this.f391a = pendingIntent;
        }
        return this;
    }

    @Override // com.xiaomi.push.eo
    /* renamed from: a */
    public ep mo11720a(String str) {
        if (b() && !TextUtils.isEmpty(str)) {
            try {
                this.b = Color.parseColor(str);
                return this;
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.m11394a("parse colorful notification button bg color error");
            }
        }
        return this;
    }

    @Override // com.xiaomi.push.eq
    /* renamed from: a */
    protected String mo11725a() {
        return "notification_colorful";
    }

    @Override // com.xiaomi.push.eq, com.xiaomi.push.eo
    /* renamed from: a */
    public void mo11718a() {
        RemoteViews a2;
        Bitmap bitmap;
        boolean z;
        RemoteViews a3;
        RemoteViews a4;
        Drawable a5;
        if (!b()) {
            b();
            return;
        }
        super.mo11718a();
        Resources resources = mo11725a().getResources();
        String packageName = mo11725a().getPackageName();
        int a6 = a(resources, "icon", "id", packageName);
        if (this.f394a == null) {
            a(a6);
        } else {
            mo11725a().setImageViewBitmap(a6, this.f394a);
        }
        int a7 = a(resources, "title", "id", packageName);
        int a8 = a(resources, "content", "id", packageName);
        mo11725a().setTextViewText(a7, this.f396a);
        mo11725a().setTextViewText(a8, this.f401b);
        if (!TextUtils.isEmpty(this.f393c)) {
            int a9 = a(resources, "buttonContainer", "id", packageName);
            int a10 = a(resources, "button", "id", packageName);
            int a11 = a(resources, "buttonBg", "id", packageName);
            mo11725a().setViewVisibility(a9, 0);
            mo11725a().setTextViewText(a10, this.f393c);
            mo11725a().setOnClickPendingIntent(a9, this.f391a);
            if (this.b != 16777216) {
                int a12 = a(70.0f);
                int a13 = a(29.0f);
                mo11725a().setImageViewBitmap(a11, com.xiaomi.push.service.ak.a(a(this.b, a12, a13, a13 / 2.0f)));
                mo11725a().setTextColor(a10, a(this.b) ? -1 : -16777216);
            }
        }
        int a14 = a(resources, OapsKey.KEY_BG, "id", packageName);
        int a15 = a(resources, "container", "id", packageName);
        if (this.f41379a != 16777216) {
            if (j.a(mo11725a()) >= 10) {
                a4 = mo11725a();
                a5 = a(this.f41379a, 984, 192, 30.0f);
            } else {
                a4 = mo11725a();
                a5 = a(this.f41379a, 984, 192, 0.0f);
            }
            a4.setImageViewBitmap(a14, com.xiaomi.push.service.ak.a(a5));
            a3 = mo11725a();
            z = a(this.f41379a);
        } else if (this.f392b == null) {
            if (Build.VERSION.SDK_INT >= 24) {
                mo11725a().setViewVisibility(a6, 8);
                mo11725a().setViewVisibility(a14, 8);
                try {
                    bi.a((Object) this, "setStyle", r.a(mo11725a(), "android.app.Notification$DecoratedCustomViewStyle").getConstructor(new Class[0]).newInstance(new Object[0]));
                } catch (Exception e) {
                    com.xiaomi.channel.commonutils.logger.b.m11394a("load class DecoratedCustomViewStyle failed");
                }
            }
            Bundle bundle = new Bundle();
            bundle.putBoolean("miui.customHeight", true);
            addExtras(bundle);
            setCustomContentView(mo11725a());
        } else {
            if (j.a(mo11725a()) >= 10) {
                a2 = mo11725a();
                bitmap = a(this.f392b, 30.0f);
            } else {
                a2 = mo11725a();
                bitmap = this.f392b;
            }
            a2.setImageViewBitmap(a14, bitmap);
            if (this.f399a != null && this.f41380c == 16777216) {
                c(this.f399a.get("notification_image_text_color"));
            }
            int i = this.f41380c;
            z = i == 16777216 || !a(i);
            a3 = mo11725a();
        }
        a(a3, a15, a7, a8, z);
        Bundle bundle2 = new Bundle();
        bundle2.putBoolean("miui.customHeight", true);
        addExtras(bundle2);
        setCustomContentView(mo11725a());
    }

    @Override // com.xiaomi.push.eq
    /* renamed from: a */
    protected boolean mo11719a() {
        if (j.m12047a()) {
            Resources resources = mo11725a().getResources();
            String packageName = mo11725a().getPackageName();
            return (a(resources, "icon", "id", packageName) == 0 || a(resources, "title", "id", packageName) == 0 || a(resources, "content", "id", packageName) == 0) ? false : true;
        }
        return false;
    }

    public ep b(String str) {
        if (b() && !TextUtils.isEmpty(str)) {
            try {
                this.f41379a = Color.parseColor(str);
                return this;
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.m11394a("parse colorful notification bg color error");
            }
        }
        return this;
    }

    @Override // com.xiaomi.push.eq
    protected String b() {
        return "notification_colorful_copy";
    }

    public ep c(String str) {
        if (b() && !TextUtils.isEmpty(str)) {
            try {
                this.f41380c = Color.parseColor(str);
                return this;
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.m11394a("parse colorful notification image text color error");
            }
        }
        return this;
    }
}
