package com.xiaomi.push;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.os.Bundle;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import android.widget.RemoteViews;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/eq.class */
public abstract class eq extends eo {

    /* renamed from: a  reason: collision with root package name */
    private int f27690a;

    /* renamed from: a  reason: collision with other field name */
    protected Bitmap f347a;

    /* renamed from: a  reason: collision with other field name */
    private RemoteViews f348a;

    /* renamed from: a  reason: collision with other field name */
    protected CharSequence f349a;

    /* renamed from: a  reason: collision with other field name */
    private String f350a;

    /* renamed from: a  reason: collision with other field name */
    private ArrayList<Notification.Action> f351a;

    /* renamed from: a  reason: collision with other field name */
    protected Map<String, String> f352a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f353a;
    private int b;

    /* renamed from: b  reason: collision with other field name */
    protected CharSequence f354b;

    /* renamed from: b  reason: collision with other field name */
    private boolean f355b;

    public eq(Context context, int i, String str) {
        super(context);
        this.f351a = new ArrayList<>();
        this.b = 0;
        this.f350a = str;
        this.f27690a = i;
        m8671c();
    }

    public eq(Context context, String str) {
        this(context, 0, str);
    }

    private Bitmap a() {
        return com.xiaomi.push.service.ak.a(g.m8747a(a(), this.f350a));
    }

    private String c() {
        boolean e = e();
        this.f355b = e;
        return e ? b() : mo8675a();
    }

    /* renamed from: c  reason: collision with other method in class */
    private void m8671c() {
        int a2 = a(a().getResources(), c(), "layout", a().getPackageName());
        if (a2 == 0) {
            com.xiaomi.channel.commonutils.logger.b.m8344a("create RemoteViews failed, no such layout resource was found");
            return;
        }
        this.f348a = new RemoteViews(a().getPackageName(), a2);
        this.f353a = mo8669a();
    }

    /* renamed from: c  reason: collision with other method in class */
    private boolean m8672c() {
        Map<String, String> map = this.f352a;
        return map != null && Boolean.parseBoolean(map.get("custom_builder_set_title"));
    }

    private void d() {
        super.setContentTitle(this.f349a);
        super.setContentText(this.f354b);
    }

    /* renamed from: d  reason: collision with other method in class */
    private boolean m8673d() {
        return (TextUtils.isEmpty(b()) || TextUtils.isEmpty(this.f350a)) ? false : true;
    }

    private boolean e() {
        return m8673d() && f();
    }

    private boolean f() {
        List<StatusBarNotification> m9091b;
        if (Build.VERSION.SDK_INT < 20 || (m9091b = com.xiaomi.push.service.ax.a(a(), this.f350a).m9091b()) == null || m9091b.isEmpty()) {
            return false;
        }
        for (StatusBarNotification statusBarNotification : m9091b) {
            if (statusBarNotification.getId() == this.f27690a) {
                Notification notification = statusBarNotification.getNotification();
                return (notification == null || notification.extras.getBoolean("mipush.customCopyLayout", true)) ? false : true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int a(float f) {
        return (int) ((f * a().getResources().getDisplayMetrics().density) + 0.5f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Bitmap a(Bitmap bitmap, float f) {
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        canvas.drawRoundRect(new RectF(rect), f, f, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        if (!bitmap.isRecycled()) {
            bitmap.recycle();
        }
        return createBitmap;
    }

    /* renamed from: a  reason: collision with other method in class */
    public final RemoteViews m8674a() {
        return this.f348a;
    }

    @Override // com.xiaomi.push.eo
    public eo a(Map<String, String> map) {
        this.f352a = map;
        return this;
    }

    @Override // android.app.Notification.Builder
    /* renamed from: a */
    public eq addAction(int i, CharSequence charSequence, PendingIntent pendingIntent) {
        addAction(new Notification.Action(i, charSequence, pendingIntent));
        return this;
    }

    @Override // android.app.Notification.Builder
    /* renamed from: a */
    public eq addAction(Notification.Action action) {
        if (action != null) {
            this.f351a.add(action);
        }
        int i = this.b;
        this.b = i + 1;
        a(i, action);
        return this;
    }

    @Override // android.app.Notification.Builder
    /* renamed from: a */
    public eq setLargeIcon(Bitmap bitmap) {
        this.f347a = bitmap;
        return this;
    }

    @Override // android.app.Notification.Builder
    /* renamed from: a */
    public eq setContentTitle(CharSequence charSequence) {
        this.f349a = charSequence;
        return this;
    }

    /* renamed from: a  reason: collision with other method in class */
    protected abstract String mo8675a();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaomi.push.eo
    /* renamed from: a */
    public void mo8668a() {
        super.mo8668a();
        Bundle bundle = new Bundle();
        if (m8673d()) {
            bundle.putBoolean("mipush.customCopyLayout", this.f355b);
        } else {
            bundle.putBoolean("mipush.customCopyLayout", false);
        }
        bundle.putBoolean("miui.customHeight", false);
        bundle.putBoolean("mipush.customNotification", true);
        bundle.putInt("mipush.customLargeIconId", a("large_icon"));
        if (this.f351a.size() > 0) {
            Notification.Action[] actionArr = new Notification.Action[this.f351a.size()];
            this.f351a.toArray(actionArr);
            bundle.putParcelableArray("mipush.customActions", actionArr);
        }
        if (m8672c() || !com.xiaomi.push.service.ay.m9094a(a().getContentResolver())) {
            d();
        } else {
            bundle.putCharSequence("mipush.customTitle", this.f349a);
            bundle.putCharSequence("mipush.customContent", this.f354b);
        }
        addExtras(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i) {
        Bitmap a2 = a();
        if (a2 != null) {
            m8674a().setImageViewBitmap(i, a2);
            return;
        }
        int b = g.b(a(), this.f350a);
        if (b != 0) {
            m8674a().setImageViewResource(i, b);
        }
    }

    protected void a(int i, Notification.Action action) {
    }

    /* renamed from: a */
    protected abstract boolean mo8669a();

    /* renamed from: a  reason: collision with other method in class */
    protected final boolean m8676a(int i) {
        return ((((double) Color.red(i)) * 0.299d) + (((double) Color.green(i)) * 0.587d)) + (((double) Color.blue(i)) * 0.114d) < 192.0d;
    }

    @Override // android.app.Notification.Builder
    /* renamed from: b */
    public eq setContentText(CharSequence charSequence) {
        this.f354b = charSequence;
        return this;
    }

    protected abstract String b();

    /* renamed from: b  reason: collision with other method in class */
    protected final void m8677b() {
        super.setContentTitle(this.f349a);
        super.setContentText(this.f354b);
        Bitmap bitmap = this.f347a;
        if (bitmap != null) {
            super.setLargeIcon(bitmap);
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    protected final boolean m8678b() {
        return this.f353a;
    }
}
