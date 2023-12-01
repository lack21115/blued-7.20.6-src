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
    private int f27688a;

    /* renamed from: a  reason: collision with other field name */
    private PendingIntent f344a;
    private int b;

    /* renamed from: b  reason: collision with other field name */
    private Bitmap f345b;

    /* renamed from: c  reason: collision with root package name */
    private int f27689c;

    /* renamed from: c  reason: collision with other field name */
    private CharSequence f346c;

    public ep(Context context, int i, String str) {
        super(context, i, str);
        this.f27688a = 16777216;
        this.b = 16777216;
        this.f27689c = 16777216;
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
                this.f345b = bitmap;
                return this;
            }
            com.xiaomi.channel.commonutils.logger.b.m8344a("colorful notification bg image resolution error, must [984*177, 984*207]");
        }
        return this;
    }

    public ep a(CharSequence charSequence, PendingIntent pendingIntent) {
        if (b()) {
            super.addAction(0, charSequence, pendingIntent);
            this.f346c = charSequence;
            this.f344a = pendingIntent;
        }
        return this;
    }

    @Override // com.xiaomi.push.eo
    /* renamed from: a */
    public ep mo8670a(String str) {
        if (b() && !TextUtils.isEmpty(str)) {
            try {
                this.b = Color.parseColor(str);
                return this;
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.m8344a("parse colorful notification button bg color error");
            }
        }
        return this;
    }

    @Override // com.xiaomi.push.eq
    /* renamed from: a */
    protected String mo8675a() {
        return "notification_colorful";
    }

    @Override // com.xiaomi.push.eq, com.xiaomi.push.eo
    /* renamed from: a */
    public void mo8668a() {
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
        super.mo8668a();
        Resources resources = mo8675a().getResources();
        String packageName = mo8675a().getPackageName();
        int a6 = a(resources, "icon", "id", packageName);
        if (this.f347a == null) {
            a(a6);
        } else {
            mo8675a().setImageViewBitmap(a6, this.f347a);
        }
        int a7 = a(resources, "title", "id", packageName);
        int a8 = a(resources, "content", "id", packageName);
        mo8675a().setTextViewText(a7, this.f349a);
        mo8675a().setTextViewText(a8, this.f354b);
        if (!TextUtils.isEmpty(this.f346c)) {
            int a9 = a(resources, "buttonContainer", "id", packageName);
            int a10 = a(resources, "button", "id", packageName);
            int a11 = a(resources, "buttonBg", "id", packageName);
            mo8675a().setViewVisibility(a9, 0);
            mo8675a().setTextViewText(a10, this.f346c);
            mo8675a().setOnClickPendingIntent(a9, this.f344a);
            if (this.b != 16777216) {
                int a12 = a(70.0f);
                int a13 = a(29.0f);
                mo8675a().setImageViewBitmap(a11, com.xiaomi.push.service.ak.a(a(this.b, a12, a13, a13 / 2.0f)));
                mo8675a().setTextColor(a10, a(this.b) ? -1 : -16777216);
            }
        }
        int a14 = a(resources, OapsKey.KEY_BG, "id", packageName);
        int a15 = a(resources, "container", "id", packageName);
        if (this.f27688a != 16777216) {
            if (j.a(mo8675a()) >= 10) {
                a4 = mo8675a();
                a5 = a(this.f27688a, 984, 192, 30.0f);
            } else {
                a4 = mo8675a();
                a5 = a(this.f27688a, 984, 192, 0.0f);
            }
            a4.setImageViewBitmap(a14, com.xiaomi.push.service.ak.a(a5));
            a3 = mo8675a();
            z = a(this.f27688a);
        } else if (this.f345b == null) {
            if (Build.VERSION.SDK_INT >= 24) {
                mo8675a().setViewVisibility(a6, 8);
                mo8675a().setViewVisibility(a14, 8);
                try {
                    bi.a((Object) this, "setStyle", r.a(mo8675a(), "android.app.Notification$DecoratedCustomViewStyle").getConstructor(new Class[0]).newInstance(new Object[0]));
                } catch (Exception e) {
                    com.xiaomi.channel.commonutils.logger.b.m8344a("load class DecoratedCustomViewStyle failed");
                }
            }
            Bundle bundle = new Bundle();
            bundle.putBoolean("miui.customHeight", true);
            addExtras(bundle);
            setCustomContentView(mo8675a());
        } else {
            if (j.a(mo8675a()) >= 10) {
                a2 = mo8675a();
                bitmap = a(this.f345b, 30.0f);
            } else {
                a2 = mo8675a();
                bitmap = this.f345b;
            }
            a2.setImageViewBitmap(a14, bitmap);
            if (this.f352a != null && this.f27689c == 16777216) {
                c(this.f352a.get("notification_image_text_color"));
            }
            int i = this.f27689c;
            z = i == 16777216 || !a(i);
            a3 = mo8675a();
        }
        a(a3, a15, a7, a8, z);
        Bundle bundle2 = new Bundle();
        bundle2.putBoolean("miui.customHeight", true);
        addExtras(bundle2);
        setCustomContentView(mo8675a());
    }

    @Override // com.xiaomi.push.eq
    /* renamed from: a */
    protected boolean mo8669a() {
        if (j.m8997a()) {
            Resources resources = mo8675a().getResources();
            String packageName = mo8675a().getPackageName();
            return (a(resources, "icon", "id", packageName) == 0 || a(resources, "title", "id", packageName) == 0 || a(resources, "content", "id", packageName) == 0) ? false : true;
        }
        return false;
    }

    public ep b(String str) {
        if (b() && !TextUtils.isEmpty(str)) {
            try {
                this.f27688a = Color.parseColor(str);
                return this;
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.m8344a("parse colorful notification bg color error");
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
                this.f27689c = Color.parseColor(str);
                return this;
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.m8344a("parse colorful notification image text color error");
            }
        }
        return this;
    }
}
