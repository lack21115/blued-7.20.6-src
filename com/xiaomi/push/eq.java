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
    private int f41381a;

    /* renamed from: a  reason: collision with other field name */
    protected Bitmap f394a;

    /* renamed from: a  reason: collision with other field name */
    private RemoteViews f395a;

    /* renamed from: a  reason: collision with other field name */
    protected CharSequence f396a;

    /* renamed from: a  reason: collision with other field name */
    private String f397a;

    /* renamed from: a  reason: collision with other field name */
    private ArrayList<Notification.Action> f398a;

    /* renamed from: a  reason: collision with other field name */
    protected Map<String, String> f399a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f400a;
    private int b;

    /* renamed from: b  reason: collision with other field name */
    protected CharSequence f401b;

    /* renamed from: b  reason: collision with other field name */
    private boolean f402b;

    public eq(Context context, int i, String str) {
        super(context);
        this.f398a = new ArrayList<>();
        this.b = 0;
        this.f397a = str;
        this.f41381a = i;
        m11721c();
    }

    public eq(Context context, String str) {
        this(context, 0, str);
    }

    private Bitmap a() {
        return com.xiaomi.push.service.ak.a(g.m11797a(a(), this.f397a));
    }

    private String c() {
        boolean e = e();
        this.f402b = e;
        return e ? b() : mo11725a();
    }

    /* renamed from: c  reason: collision with other method in class */
    private void m11721c() {
        int a2 = a(a().getResources(), c(), "layout", a().getPackageName());
        if (a2 == 0) {
            com.xiaomi.channel.commonutils.logger.b.m11394a("create RemoteViews failed, no such layout resource was found");
            return;
        }
        this.f395a = new RemoteViews(a().getPackageName(), a2);
        this.f400a = mo11719a();
    }

    /* renamed from: c  reason: collision with other method in class */
    private boolean m11722c() {
        Map<String, String> map = this.f399a;
        return map != null && Boolean.parseBoolean(map.get("custom_builder_set_title"));
    }

    private void d() {
        super.setContentTitle(this.f396a);
        super.setContentText(this.f401b);
    }

    /* renamed from: d  reason: collision with other method in class */
    private boolean m11723d() {
        return (TextUtils.isEmpty(b()) || TextUtils.isEmpty(this.f397a)) ? false : true;
    }

    private boolean e() {
        return m11723d() && f();
    }

    private boolean f() {
        List<StatusBarNotification> m12141b;
        if (Build.VERSION.SDK_INT < 20 || (m12141b = com.xiaomi.push.service.ax.a(a(), this.f397a).m12141b()) == null || m12141b.isEmpty()) {
            return false;
        }
        for (StatusBarNotification statusBarNotification : m12141b) {
            if (statusBarNotification.getId() == this.f41381a) {
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
    public final RemoteViews m11724a() {
        return this.f395a;
    }

    @Override // com.xiaomi.push.eo
    public eo a(Map<String, String> map) {
        this.f399a = map;
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
            this.f398a.add(action);
        }
        int i = this.b;
        this.b = i + 1;
        a(i, action);
        return this;
    }

    @Override // android.app.Notification.Builder
    /* renamed from: a */
    public eq setLargeIcon(Bitmap bitmap) {
        this.f394a = bitmap;
        return this;
    }

    @Override // android.app.Notification.Builder
    /* renamed from: a */
    public eq setContentTitle(CharSequence charSequence) {
        this.f396a = charSequence;
        return this;
    }

    /* renamed from: a  reason: collision with other method in class */
    protected abstract String mo11725a();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaomi.push.eo
    /* renamed from: a */
    public void mo11718a() {
        super.mo11718a();
        Bundle bundle = new Bundle();
        if (m11723d()) {
            bundle.putBoolean("mipush.customCopyLayout", this.f402b);
        } else {
            bundle.putBoolean("mipush.customCopyLayout", false);
        }
        bundle.putBoolean("miui.customHeight", false);
        bundle.putBoolean("mipush.customNotification", true);
        bundle.putInt("mipush.customLargeIconId", a("large_icon"));
        if (this.f398a.size() > 0) {
            Notification.Action[] actionArr = new Notification.Action[this.f398a.size()];
            this.f398a.toArray(actionArr);
            bundle.putParcelableArray("mipush.customActions", actionArr);
        }
        if (m11722c() || !com.xiaomi.push.service.ay.m12144a(a().getContentResolver())) {
            d();
        } else {
            bundle.putCharSequence("mipush.customTitle", this.f396a);
            bundle.putCharSequence("mipush.customContent", this.f401b);
        }
        addExtras(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i) {
        Bitmap a2 = a();
        if (a2 != null) {
            m11724a().setImageViewBitmap(i, a2);
            return;
        }
        int b = g.b(a(), this.f397a);
        if (b != 0) {
            m11724a().setImageViewResource(i, b);
        }
    }

    protected void a(int i, Notification.Action action) {
    }

    /* renamed from: a */
    protected abstract boolean mo11719a();

    /* renamed from: a  reason: collision with other method in class */
    protected final boolean m11726a(int i) {
        return ((((double) Color.red(i)) * 0.299d) + (((double) Color.green(i)) * 0.587d)) + (((double) Color.blue(i)) * 0.114d) < 192.0d;
    }

    @Override // android.app.Notification.Builder
    /* renamed from: b */
    public eq setContentText(CharSequence charSequence) {
        this.f401b = charSequence;
        return this;
    }

    protected abstract String b();

    /* renamed from: b  reason: collision with other method in class */
    protected final void m11727b() {
        super.setContentTitle(this.f396a);
        super.setContentText(this.f401b);
        Bitmap bitmap = this.f394a;
        if (bitmap != null) {
            super.setLargeIcon(bitmap);
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    protected final boolean m11728b() {
        return this.f400a;
    }
}
