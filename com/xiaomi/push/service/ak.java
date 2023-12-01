package com.xiaomi.push.service;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import android.util.Pair;
import android.widget.RemoteViews;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.xiaomi.push.em;
import com.xiaomi.push.en;
import com.xiaomi.push.eo;
import com.xiaomi.push.ep;
import com.xiaomi.push.g;
import com.xiaomi.push.hg;
import com.xiaomi.push.ht;
import com.xiaomi.push.ic;
import com.xiaomi.push.service.aw;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/service/ak.class */
public class ak {

    /* renamed from: a  reason: collision with root package name */
    public static long f41601a;

    /* renamed from: a  reason: collision with other field name */
    private static volatile as f964a;

    /* renamed from: a  reason: collision with other field name */
    private static final LinkedList<Pair<Integer, ic>> f965a = new LinkedList<>();

    /* renamed from: a  reason: collision with other field name */
    private static ExecutorService f966a = Executors.newCachedThreadPool();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/service/ak$a.class */
    public static class a implements Callable<Bitmap> {

        /* renamed from: a  reason: collision with root package name */
        private Context f41602a;

        /* renamed from: a  reason: collision with other field name */
        private String f967a;

        /* renamed from: a  reason: collision with other field name */
        private boolean f968a;

        public a(String str, Context context, boolean z) {
            this.f41602a = context;
            this.f967a = str;
            this.f968a = z;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Bitmap call() {
            Bitmap bitmap;
            if (TextUtils.isEmpty(this.f967a)) {
                com.xiaomi.channel.commonutils.logger.b.m11394a("Failed get online picture/icon resource cause picUrl is empty");
            } else if (!this.f967a.startsWith("http")) {
                Bitmap a2 = aw.a(this.f41602a, this.f967a);
                bitmap = a2;
                if (a2 == null) {
                    com.xiaomi.channel.commonutils.logger.b.m11394a("Failed get online picture/icon resource");
                    return a2;
                }
                return bitmap;
            } else {
                aw.b a3 = aw.a(this.f41602a, this.f967a, this.f968a);
                if (a3 != null) {
                    return a3.f988a;
                }
                com.xiaomi.channel.commonutils.logger.b.m11394a("Failed get online picture/icon resource");
            }
            bitmap = null;
            return bitmap;
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/service/ak$b.class */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        long f41603a = 0;

        /* renamed from: a  reason: collision with other field name */
        Notification f969a;
    }

    /* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/service/ak$c.class */
    public static class c {

        /* renamed from: a  reason: collision with other field name */
        public String f970a;

        /* renamed from: a  reason: collision with root package name */
        public long f41604a = 0;

        /* renamed from: a  reason: collision with other field name */
        public boolean f971a = false;
    }

    static int a(Context context, String str) {
        return context.getSharedPreferences("pref_notify_type", 0).getInt(str, Integer.MAX_VALUE);
    }

    private static int a(Context context, String str, String str2) {
        if (str.equals(context.getPackageName())) {
            return context.getResources().getIdentifier(str2, com.anythink.expressad.foundation.h.i.f7952c, str);
        }
        return 0;
    }

    private static int a(Context context, String str, Map<String, String> map, int i) {
        ComponentName a2;
        Intent b2 = b(context, str, map, i);
        if (b2 == null || (a2 = l.a(context, b2)) == null) {
            return 0;
        }
        return a2.hashCode();
    }

    private static int a(Map<String, String> map) {
        String str = map == null ? null : map.get("timeout");
        int i = 0;
        if (!TextUtils.isEmpty(str)) {
            try {
                i = Integer.parseInt(str);
            } catch (Exception e) {
                return 0;
            }
        }
        return i;
    }

    private static Notification a(Notification notification) {
        Object a2 = com.xiaomi.push.bi.a(notification, "extraNotification");
        if (a2 != null) {
            com.xiaomi.push.bi.a(a2, "setCustomizedIcon", Boolean.TRUE);
        }
        return notification;
    }

    private static PendingIntent a(Context context, ic icVar, String str, byte[] bArr, int i) {
        return a(context, icVar, str, bArr, i, 0, a(context, icVar, str));
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00e9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static android.app.PendingIntent a(android.content.Context r7, com.xiaomi.push.ic r8, java.lang.String r9, byte[] r10, int r11, int r12, boolean r13) {
        /*
            Method dump skipped, instructions count: 535
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.ak.a(android.content.Context, com.xiaomi.push.ic, java.lang.String, byte[], int, int, boolean):android.app.PendingIntent");
    }

    private static PendingIntent a(Context context, String str, ic icVar, byte[] bArr, int i, int i2) {
        Map<String, String> m11896a = icVar.m11945a().m11896a();
        if (m11896a == null) {
            return null;
        }
        boolean a2 = a(context, icVar, str);
        if (a2) {
            return a(context, icVar, str, bArr, i, i2, a2);
        }
        Intent m12108a = m12108a(context, str, m11896a, i2);
        PendingIntent pendingIntent = null;
        if (m12108a != null) {
            pendingIntent = PendingIntent.getActivity(context, 0, m12108a, Build.VERSION.SDK_INT >= 31 ? 167772160 : 134217728);
        }
        return pendingIntent;
    }

    public static ComponentName a(String str) {
        return new ComponentName(str, "com.xiaomi.mipush.sdk.NotificationClickedActivity");
    }

    /* renamed from: a  reason: collision with other method in class */
    public static Intent m12108a(Context context, String str, Map<String, String> map, int i) {
        if (m12118b(map)) {
            return a(context, str, map, String.format("cust_btn_%s_ne", Integer.valueOf(i)), String.format("cust_btn_%s_iu", Integer.valueOf(i)), String.format("cust_btn_%s_ic", Integer.valueOf(i)), String.format("cust_btn_%s_wu", Integer.valueOf(i)));
        }
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        return null;
                    }
                    return a(context, str, map, "notification_colorful_button_notify_effect", "notification_colorful_button_intent_uri", "notification_colorful_button_intent_class", "notification_colorful_button_web_uri");
                }
                return a(context, str, map, "notification_style_button_right_notify_effect", "notification_style_button_right_intent_uri", "notification_style_button_right_intent_class", "notification_style_button_right_web_uri");
            }
            return a(context, str, map, "notification_style_button_mid_notify_effect", "notification_style_button_mid_intent_uri", "notification_style_button_mid_intent_class", "notification_style_button_mid_web_uri");
        }
        return a(context, str, map, "notification_style_button_left_notify_effect", "notification_style_button_left_intent_uri", "notification_style_button_left_intent_class", "notification_style_button_left_web_uri");
    }

    /* JADX WARN: Removed duplicated region for block: B:57:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:88:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static android.content.Intent a(android.content.Context r6, java.lang.String r7, java.util.Map<java.lang.String, java.lang.String> r8, java.lang.String r9, java.lang.String r10, java.lang.String r11, java.lang.String r12) {
        /*
            Method dump skipped, instructions count: 510
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.ak.a(android.content.Context, java.lang.String, java.util.Map, java.lang.String, java.lang.String, java.lang.String, java.lang.String):android.content.Intent");
    }

    private static Bitmap a(Context context, int i) {
        return a(context.getResources().getDrawable(i));
    }

    private static Bitmap a(Context context, String str, boolean z) {
        Bitmap bitmap;
        Future submit = f966a.submit(new a(str, context, z));
        try {
            try {
                Bitmap bitmap2 = (Bitmap) submit.get(180L, TimeUnit.SECONDS);
                bitmap = bitmap2;
                if (bitmap2 == null) {
                    return bitmap2;
                }
            } catch (InterruptedException | ExecutionException | TimeoutException e) {
                com.xiaomi.channel.commonutils.logger.b.a(e);
                submit.cancel(true);
                bitmap = null;
            }
            return bitmap;
        } finally {
            submit.cancel(true);
        }
    }

    public static Bitmap a(Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int i = 1;
        if (intrinsicWidth <= 0) {
            intrinsicWidth = 1;
        }
        int intrinsicHeight = drawable.getIntrinsicHeight();
        if (intrinsicHeight > 0) {
            i = intrinsicHeight;
        }
        Bitmap createBitmap = Bitmap.createBitmap(intrinsicWidth, i, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return createBitmap;
    }

    private static RemoteViews a(Context context, ic icVar, byte[] bArr) {
        ht m11945a = icVar.m11945a();
        String a2 = a(icVar);
        if (m11945a == null || m11945a.m11896a() == null) {
            return null;
        }
        Map<String, String> m11896a = m11945a.m11896a();
        String str = m11896a.get("layout_name");
        String str2 = m11896a.get("layout_value");
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        try {
            Resources resourcesForApplication = context.getPackageManager().getResourcesForApplication(a2);
            int identifier = resourcesForApplication.getIdentifier(str, "layout", a2);
            if (identifier == 0) {
                return null;
            }
            RemoteViews remoteViews = new RemoteViews(a2, identifier);
            try {
                JSONObject jSONObject = new JSONObject(str2);
                if (jSONObject.has("text")) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject("text");
                    Iterator<String> keys = jSONObject2.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        String string = jSONObject2.getString(next);
                        int identifier2 = resourcesForApplication.getIdentifier(next, "id", a2);
                        if (identifier2 > 0) {
                            remoteViews.setTextViewText(identifier2, string);
                        }
                    }
                }
                if (jSONObject.has("image")) {
                    JSONObject jSONObject3 = jSONObject.getJSONObject("image");
                    Iterator<String> keys2 = jSONObject3.keys();
                    while (keys2.hasNext()) {
                        String next2 = keys2.next();
                        String string2 = jSONObject3.getString(next2);
                        int identifier3 = resourcesForApplication.getIdentifier(next2, "id", a2);
                        int identifier4 = resourcesForApplication.getIdentifier(string2, com.anythink.expressad.foundation.h.i.f7952c, a2);
                        if (identifier3 > 0) {
                            remoteViews.setImageViewResource(identifier3, identifier4);
                        }
                    }
                }
                if (jSONObject.has("time")) {
                    JSONObject jSONObject4 = jSONObject.getJSONObject("time");
                    Iterator<String> keys3 = jSONObject4.keys();
                    while (keys3.hasNext()) {
                        String next3 = keys3.next();
                        String string3 = jSONObject4.getString(next3);
                        String str3 = string3;
                        if (string3.length() == 0) {
                            str3 = "yy-MM-dd hh:mm";
                        }
                        int identifier5 = resourcesForApplication.getIdentifier(next3, "id", a2);
                        if (identifier5 > 0) {
                            remoteViews.setTextViewText(identifier5, new SimpleDateFormat(str3).format(new Date(System.currentTimeMillis())));
                        }
                    }
                }
                return remoteViews;
            } catch (JSONException e) {
                com.xiaomi.channel.commonutils.logger.b.a(e);
                return null;
            }
        } catch (PackageManager.NameNotFoundException e2) {
            com.xiaomi.channel.commonutils.logger.b.a(e2);
            return null;
        }
    }

    private static eo a(Context context, ic icVar, byte[] bArr, String str, int i) {
        PendingIntent a2;
        String a3 = a(icVar);
        Map<String, String> m11896a = icVar.m11945a().m11896a();
        String str2 = m11896a.get("notification_style_type");
        eo a4 = (!com.xiaomi.push.j.m12048a(context) || f964a == null) ? null : f964a.a(context, i, a3, m11896a);
        if (a4 != null) {
            a4.a(m11896a);
            return a4;
        } else if ("2".equals(str2)) {
            eo eoVar = new eo(context);
            Bitmap a5 = TextUtils.isEmpty(m11896a.get("notification_bigPic_uri")) ? null : a(context, m11896a.get("notification_bigPic_uri"), false);
            if (a5 == null) {
                com.xiaomi.channel.commonutils.logger.b.m11394a("can not get big picture.");
                return eoVar;
            }
            Notification.BigPictureStyle bigPictureStyle = new Notification.BigPictureStyle(eoVar);
            bigPictureStyle.bigPicture(a5);
            bigPictureStyle.setSummaryText(str);
            bigPictureStyle.bigLargeIcon(null);
            eoVar.setStyle(bigPictureStyle);
            return eoVar;
        } else if ("1".equals(str2)) {
            eo eoVar2 = new eo(context);
            eoVar2.setStyle(new Notification.BigTextStyle().bigText(str));
            return eoVar2;
        } else if ("4".equals(str2) && com.xiaomi.push.j.m12047a()) {
            en enVar = new en(context, a3);
            if (!TextUtils.isEmpty(m11896a.get("notification_banner_image_uri"))) {
                enVar.a(a(context, m11896a.get("notification_banner_image_uri"), false));
            }
            if (!TextUtils.isEmpty(m11896a.get("notification_banner_icon_uri"))) {
                enVar.b(a(context, m11896a.get("notification_banner_icon_uri"), false));
            }
            enVar.a(m11896a);
            return enVar;
        } else if ("3".equals(str2) && com.xiaomi.push.j.m12047a()) {
            ep epVar = new ep(context, i, a3);
            if (!TextUtils.isEmpty(m11896a.get("notification_colorful_button_text")) && (a2 = a(context, a3, icVar, bArr, i, 4)) != null) {
                epVar.a(m11896a.get("notification_colorful_button_text"), a2).mo11720a(m11896a.get("notification_colorful_button_bg_color"));
            }
            if (!TextUtils.isEmpty(m11896a.get("notification_colorful_bg_color"))) {
                epVar.b(m11896a.get("notification_colorful_bg_color"));
            } else if (!TextUtils.isEmpty(m11896a.get("notification_colorful_bg_image_uri"))) {
                epVar.a(a(context, m11896a.get("notification_colorful_bg_image_uri"), false));
            }
            epVar.a(m11896a);
            return epVar;
        } else {
            return new eo(context);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:71:0x0281, code lost:
        if (r0 == false) goto L57;
     */
    /* JADX WARN: Removed duplicated region for block: B:102:0x03c2  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0570  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x05dd  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0209  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x020e  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0225  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0343  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static com.xiaomi.push.service.ak.b a(android.content.Context r14, com.xiaomi.push.ic r15, byte[] r16, android.widget.RemoteViews r17, android.app.PendingIntent r18, int r19) {
        /*
            Method dump skipped, instructions count: 1717
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.ak.a(android.content.Context, com.xiaomi.push.ic, byte[], android.widget.RemoteViews, android.app.PendingIntent, int):com.xiaomi.push.service.ak$b");
    }

    /* renamed from: a  reason: collision with other method in class */
    public static c m12109a(Context context, ic icVar, byte[] bArr) {
        int i;
        Map<String, String> map;
        String str;
        c cVar = new c();
        g.b a2 = com.xiaomi.push.g.a(context, a(icVar), true);
        ht m11945a = icVar.m11945a();
        if (m11945a != null) {
            i = m11945a.c();
            map = m11945a.m11896a();
        } else {
            i = 0;
            map = null;
        }
        int b2 = com.xiaomi.push.s.b(a(icVar), i);
        if (com.xiaomi.push.j.m12048a(context) && a2 == g.b.NOT_ALLOWED) {
            if (m11945a != null) {
                em.a(context.getApplicationContext()).a(icVar.b(), b(icVar), m11945a.m11895a(), "10:" + a(icVar));
            }
            str = "Do not notify because user block " + a(icVar) + "‘s notification";
        } else if (com.xiaomi.push.j.m12048a(context) && f964a != null && f964a.m12123a(context, b2, a(icVar), map)) {
            if (m11945a != null) {
                em.a(context.getApplicationContext()).a(icVar.b(), b(icVar), m11945a.m11895a(), "14:" + a(icVar));
            }
            str = "Do not notify because card notification is canceled or sequence incorrect";
        } else {
            RemoteViews a3 = a(context, icVar, bArr);
            PendingIntent a4 = a(context, icVar, icVar.b(), bArr, b2);
            if (a4 != null) {
                b a5 = a(context, icVar, bArr, a3, a4, b2);
                cVar.f41604a = a5.f41603a;
                cVar.f970a = a(icVar);
                Notification notification = a5.f969a;
                if (com.xiaomi.push.j.m12047a()) {
                    if (!TextUtils.isEmpty(m11945a.m11895a())) {
                        notification.extras.putString("message_id", m11945a.m11895a());
                    }
                    notification.extras.putString("local_paid", icVar.m11946a());
                    ay.a(map, notification.extras, "msg_busi_type");
                    ay.a(map, notification.extras, "disable_notification_flags");
                    String str2 = m11945a.m11901b() == null ? null : m11945a.m11901b().get("score_info");
                    if (!TextUtils.isEmpty(str2)) {
                        notification.extras.putString("score_info", str2);
                    }
                    notification.extras.putString("pushUid", a(m11945a.f618a, "n_stats_expose"));
                    int i2 = -1;
                    if (c(icVar)) {
                        i2 = 1000;
                    } else if (m12113a(icVar)) {
                        i2 = 3000;
                    }
                    notification.extras.putString("eventMessageType", String.valueOf(i2));
                    notification.extras.putString(HiAnalyticsConstant.BI_KEY_TARGET_PACKAGE, a(icVar));
                }
                String str3 = m11945a.m11896a() == null ? null : m11945a.m11896a().get("message_count");
                if (com.xiaomi.push.j.m12047a() && str3 != null) {
                    try {
                        ay.a(notification, Integer.parseInt(str3));
                    } catch (NumberFormatException e) {
                        if (m11945a != null) {
                            em.a(context.getApplicationContext()).b(icVar.b(), b(icVar), m11945a.m11895a(), "8");
                        }
                        com.xiaomi.channel.commonutils.logger.b.d("fail to set message count. ".concat(String.valueOf(e)));
                    }
                }
                String a6 = a(icVar);
                ay.m12143a(notification, a6);
                ax a7 = ax.a(context, a6);
                if (com.xiaomi.push.j.m12048a(context) && f964a != null) {
                    f964a.a(icVar, m11945a.m11896a(), b2, notification);
                }
                if (com.xiaomi.push.j.m12048a(context) && f964a != null && f964a.a(m11945a.m11896a(), b2, notification)) {
                    com.xiaomi.channel.commonutils.logger.b.b("consume this notificaiton by agent");
                } else {
                    a7.a(b2, notification);
                    cVar.f971a = true;
                    com.xiaomi.channel.commonutils.logger.b.m11394a("notification: " + m11945a.m11895a() + " is notifyied");
                }
                if (com.xiaomi.push.j.m12047a() && com.xiaomi.push.j.m12048a(context)) {
                    au.a().a(context, b2, notification);
                    cc.m12178a(context, a6, b2, m11945a.m11895a(), notification);
                }
                if (m12113a(icVar)) {
                    em.a(context.getApplicationContext()).a(icVar.b(), b(icVar), m11945a.m11895a(), 3002, null);
                }
                if (c(icVar)) {
                    em.a(context.getApplicationContext()).a(icVar.b(), b(icVar), m11945a.m11895a(), 1002, null);
                }
                if (Build.VERSION.SDK_INT < 26) {
                    String str4 = null;
                    if (m11945a != null) {
                        str4 = m11945a.m11895a();
                    }
                    com.xiaomi.push.ai a8 = com.xiaomi.push.ai.a(context);
                    int a9 = a(m11945a.m11896a());
                    if (a9 > 0 && !TextUtils.isEmpty(str4)) {
                        String concat = "n_timeout_".concat(String.valueOf(str4));
                        a8.m11503a(concat);
                        a8.b(new al(concat, a7, b2), a9);
                    }
                }
                Pair<Integer, ic> pair = new Pair<>(Integer.valueOf(b2), icVar);
                synchronized (f965a) {
                    f965a.add(pair);
                    if (f965a.size() > 100) {
                        f965a.remove();
                    }
                }
                return cVar;
            }
            if (m11945a != null) {
                em.a(context.getApplicationContext()).a(icVar.b(), b(icVar), m11945a.m11895a(), "11");
            }
            str = "The click PendingIntent is null. ";
        }
        com.xiaomi.channel.commonutils.logger.b.m11394a(str);
        return cVar;
    }

    private static String a(Context context, String str, Map<String, String> map) {
        return (map == null || TextUtils.isEmpty(map.get("channel_name"))) ? com.xiaomi.push.g.m11802b(context, str) : map.get("channel_name");
    }

    public static String a(ic icVar) {
        ht m11945a;
        if ("com.xiaomi.xmsf".equals(icVar.f713b) && (m11945a = icVar.m11945a()) != null && m11945a.m11896a() != null) {
            String str = m11945a.m11896a().get("miui_package_name");
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
        }
        return icVar.f713b;
    }

    public static String a(Map<String, String> map, int i) {
        String format = i == 0 ? "notify_effect" : m12118b(map) ? String.format("cust_btn_%s_ne", Integer.valueOf(i)) : i == 1 ? "notification_style_button_left_notify_effect" : i == 2 ? "notification_style_button_mid_notify_effect" : i == 3 ? "notification_style_button_right_notify_effect" : i == 4 ? "notification_colorful_button_notify_effect" : null;
        String str = null;
        if (map != null) {
            str = null;
            if (format != null) {
                str = map.get(format);
            }
        }
        return str;
    }

    private static String a(Map<String, String> map, String str) {
        if (map != null) {
            return map.get(str);
        }
        return null;
    }

    private static void a(Context context, Intent intent, ic icVar, ht htVar, String str, int i) {
        if (icVar == null || htVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        String a2 = a(htVar.m11896a(), i);
        if (TextUtils.isEmpty(a2)) {
            return;
        }
        if (bk.f41641a.equals(a2) || bk.b.equals(a2) || bk.f41642c.equals(a2)) {
            intent.putExtra("messageId", str);
            intent.putExtra("local_paid", icVar.f709a);
            if (!TextUtils.isEmpty(icVar.f713b)) {
                intent.putExtra(HiAnalyticsConstant.BI_KEY_TARGET_PACKAGE, icVar.f713b);
            }
            intent.putExtra("job_key", a(htVar.m11896a(), "jobkey"));
            intent.putExtra(i + "_target_component", a(context, icVar.f713b, htVar.m11896a(), i));
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static void m12110a(Context context, String str) {
        a(context, str, -1);
    }

    public static void a(Context context, String str, int i) {
        a(context, str, i, -1);
    }

    public static void a(Context context, String str, int i, int i2) {
        int hashCode;
        boolean z;
        if (context == null || TextUtils.isEmpty(str) || i < -1) {
            return;
        }
        ax a2 = ax.a(context, str);
        List<StatusBarNotification> m12141b = a2.m12141b();
        if (com.xiaomi.push.s.a(m12141b)) {
            return;
        }
        LinkedList linkedList = new LinkedList();
        if (i == -1) {
            hashCode = 0;
            z = true;
        } else {
            hashCode = ((str.hashCode() / 10) * 10) + i;
            z = false;
        }
        Iterator<StatusBarNotification> it = m12141b.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            StatusBarNotification next = it.next();
            if (!TextUtils.isEmpty(String.valueOf(next.getId()))) {
                int id = next.getId();
                if (z) {
                    linkedList.add(next);
                    a2.a(id);
                } else if (hashCode == id) {
                    d.a(context, next, i2);
                    linkedList.add(next);
                    a2.a(id);
                    break;
                }
            }
        }
        a(context, linkedList);
    }

    private static void a(Context context, String str, eo eoVar, Map<String, String> map) {
        int a2 = a(context, str, "mipush_small_notification");
        int a3 = a(context, str, "mipush_notification");
        if (com.xiaomi.push.j.m12048a(context)) {
            if (a2 <= 0 || a3 <= 0) {
                b(context, str, eoVar, map);
                return;
            }
            eoVar.setSmallIcon(a2);
            eoVar.setLargeIcon(a(context, a3));
            return;
        }
        if (a2 > 0) {
            eoVar.setSmallIcon(a2);
        } else {
            b(context, str, eoVar, map);
        }
        if (a3 > 0) {
            eoVar.setLargeIcon(a(context, a3));
        }
    }

    public static void a(Context context, String str, String str2, String str3) {
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return;
        }
        ax a2 = ax.a(context, str);
        List<StatusBarNotification> m12141b = a2.m12141b();
        if (com.xiaomi.push.s.a(m12141b)) {
            return;
        }
        LinkedList linkedList = new LinkedList();
        for (StatusBarNotification statusBarNotification : m12141b) {
            Notification notification = statusBarNotification.getNotification();
            if (notification != null && !TextUtils.isEmpty(String.valueOf(statusBarNotification.getId()))) {
                int id = statusBarNotification.getId();
                String a3 = ay.a(notification);
                String b2 = ay.b(notification);
                if (!TextUtils.isEmpty(a3) && !TextUtils.isEmpty(b2) && a(a3, str2) && a(b2, str3)) {
                    linkedList.add(statusBarNotification);
                    a2.a(id);
                }
            }
        }
        a(context, linkedList);
    }

    public static void a(Context context, LinkedList<? extends Object> linkedList) {
        if (linkedList == null || linkedList.size() <= 0) {
            return;
        }
        bz.a(context, "category_clear_notification", "clear_notification", linkedList.size(), "");
    }

    private static void a(Intent intent) {
        if (intent == null) {
            return;
        }
        int flags = intent.getFlags() & (-2) & (-3) & (-65);
        int i = flags;
        if (Build.VERSION.SDK_INT >= 21) {
            i = flags & (-129);
        }
        intent.setFlags(i);
    }

    private static void a(eo eoVar, Context context, String str, ic icVar, byte[] bArr, int i) {
        PendingIntent a2;
        PendingIntent a3;
        PendingIntent a4;
        PendingIntent a5;
        Map<String, String> m11896a = icVar.m11945a().m11896a();
        if (TextUtils.equals("3", m11896a.get("notification_style_type")) || TextUtils.equals("4", m11896a.get("notification_style_type"))) {
            return;
        }
        if (!m12118b(m11896a)) {
            if (!TextUtils.isEmpty(m11896a.get("notification_style_button_left_name")) && (a4 = a(context, str, icVar, bArr, i, 1)) != null) {
                eoVar.addAction(0, m11896a.get("notification_style_button_left_name"), a4);
            }
            if (!TextUtils.isEmpty(m11896a.get("notification_style_button_mid_name")) && (a3 = a(context, str, icVar, bArr, i, 2)) != null) {
                eoVar.addAction(0, m11896a.get("notification_style_button_mid_name"), a3);
            }
            if (TextUtils.isEmpty(m11896a.get("notification_style_button_right_name")) || (a2 = a(context, str, icVar, bArr, i, 3)) == null) {
                return;
            }
            eoVar.addAction(0, m11896a.get("notification_style_button_right_name"), a2);
            return;
        }
        int i2 = 1;
        while (true) {
            int i3 = i2;
            if (i3 > 3) {
                return;
            }
            String str2 = m11896a.get(String.format("cust_btn_%s_n", Integer.valueOf(i3)));
            if (!TextUtils.isEmpty(str2) && (a5 = a(context, str, icVar, bArr, i, i3)) != null) {
                eoVar.addAction(0, str2, a5);
            }
            i2 = i3 + 1;
        }
    }

    private static boolean a(Context context, ic icVar, String str) {
        if (icVar != null && icVar.m11945a() != null && icVar.m11945a().m11896a() != null && !TextUtils.isEmpty(str)) {
            return Boolean.parseBoolean(icVar.m11945a().m11896a().get("use_clicked_activity")) && l.a(context, a(str));
        }
        com.xiaomi.channel.commonutils.logger.b.m11394a("should clicked activity params are null.");
        return false;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m12111a(Context context, String str) {
        return com.xiaomi.push.g.m11803b(context, str);
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m12112a(Context context, String str, boolean z) {
        return com.xiaomi.push.j.m12047a() && !z && m12111a(context, str);
    }

    private static boolean a(ht htVar) {
        boolean z = false;
        if (htVar != null) {
            String m11895a = htVar.m11895a();
            z = false;
            if (!TextUtils.isEmpty(m11895a)) {
                z = false;
                if (m11895a.length() == 22) {
                    z = false;
                    if ("satuigmo".indexOf(m11895a.charAt(0)) >= 0) {
                        z = true;
                    }
                }
            }
        }
        return z;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m12113a(ic icVar) {
        ht m11945a = icVar.m11945a();
        return a(m11945a) && m11945a.l();
    }

    private static boolean a(String str, String str2) {
        return TextUtils.isEmpty(str) || str2.contains(str);
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m12114a(Map<String, String> map) {
        if (map == null || !map.containsKey("notify_foreground")) {
            return true;
        }
        return "1".equals(map.get("notify_foreground"));
    }

    private static String[] a(Context context, ht htVar) {
        String str;
        String str2;
        String m11903c = htVar.m11903c();
        String d = htVar.d();
        Map<String, String> m11896a = htVar.m11896a();
        String str3 = m11903c;
        String str4 = d;
        if (m11896a != null) {
            int intValue = Float.valueOf((context.getResources().getDisplayMetrics().widthPixels / context.getResources().getDisplayMetrics().density) + 0.5f).intValue();
            if (intValue <= 320) {
                String str5 = m11896a.get("title_short");
                str = m11903c;
                if (!TextUtils.isEmpty(str5)) {
                    str = str5;
                }
                String str6 = m11896a.get("description_short");
                str3 = str;
                str4 = d;
                if (!TextUtils.isEmpty(str6)) {
                    str2 = str6;
                    str4 = str2;
                    str3 = str;
                }
            } else {
                str3 = m11903c;
                str4 = d;
                if (intValue > 360) {
                    String str7 = m11896a.get("title_long");
                    str = m11903c;
                    if (!TextUtils.isEmpty(str7)) {
                        str = str7;
                    }
                    String str8 = m11896a.get("description_long");
                    str3 = str;
                    str4 = d;
                    if (!TextUtils.isEmpty(str8)) {
                        str2 = str8;
                        str4 = str2;
                        str3 = str;
                    }
                }
            }
        }
        return new String[]{str3, str4};
    }

    private static int b(Context context, String str) {
        int a2 = a(context, str, "mipush_notification");
        int a3 = a(context, str, "mipush_small_notification");
        if (a2 <= 0) {
            a2 = a3 <= 0 ? context.getApplicationInfo().icon : a3;
        }
        int i = a2;
        if (a2 == 0) {
            i = context.getApplicationInfo().logo;
        }
        return i;
    }

    private static int b(Map<String, String> map) {
        if (map != null) {
            String str = map.get("channel_importance");
            if (TextUtils.isEmpty(str)) {
                return 3;
            }
            try {
                com.xiaomi.channel.commonutils.logger.b.c("importance=".concat(String.valueOf(str)));
                return Integer.parseInt(str);
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.d("parsing channel importance error: ".concat(String.valueOf(e)));
                return 3;
            }
        }
        return 3;
    }

    /* JADX WARN: Removed duplicated region for block: B:107:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0204  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.content.Intent b(android.content.Context r6, java.lang.String r7, java.util.Map<java.lang.String, java.lang.String> r8, int r9) {
        /*
            Method dump skipped, instructions count: 626
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.ak.b(android.content.Context, java.lang.String, java.util.Map, int):android.content.Intent");
    }

    public static String b(ic icVar) {
        return m12113a(icVar) ? "E100002" : c(icVar) ? "E100000" : m12117b(icVar) ? "E100001" : d(icVar) ? "E100003" : "";
    }

    /* renamed from: b  reason: collision with other method in class */
    public static void m12115b(Context context, String str) {
        if (!com.xiaomi.push.j.m12048a(context) || f964a == null || TextUtils.isEmpty(str)) {
            return;
        }
        f964a.a(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(Context context, String str, int i) {
        context.getSharedPreferences("pref_notify_type", 0).edit().putInt(str, i).commit();
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void b(android.content.Context r5, java.lang.String r6, com.xiaomi.push.eo r7, java.util.Map<java.lang.String, java.lang.String> r8) {
        /*
            r0 = r5
            boolean r0 = com.xiaomi.push.j.m12048a(r0)
            if (r0 != 0) goto L48
            r0 = r8
            java.lang.String r1 = "fcm_icon_uri"
            java.lang.String r0 = a(r0, r1)
            r11 = r0
            r0 = r8
            java.lang.String r1 = "fcm_icon_color"
            java.lang.String r0 = a(r0, r1)
            r8 = r0
            r0 = r11
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L48
            r0 = r8
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L48
            r0 = r5
            r1 = r6
            r2 = r11
            int r0 = a(r0, r1, r2)
            r10 = r0
            r0 = r10
            if (r0 <= 0) goto L48
            r0 = 1
            r9 = r0
            r0 = r7
            r1 = r10
            android.app.Notification$Builder r0 = r0.setSmallIcon(r1)
            r0 = r7
            r1 = r8
            com.xiaomi.push.eo r0 = r0.mo11720a(r1)
            goto L4b
        L48:
            r0 = 0
            r9 = r0
        L4b:
            r0 = r9
            if (r0 != 0) goto L71
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 23
            if (r0 < r1) goto L67
            r0 = r7
            r1 = r6
            r2 = r5
            r3 = r6
            int r2 = com.xiaomi.push.service.ay.a(r2, r3)
            android.graphics.drawable.Icon r1 = android.graphics.drawable.Icon.createWithResource(r1, r2)
            android.app.Notification$Builder r0 = r0.setSmallIcon(r1)
            return
        L67:
            r0 = r7
            r1 = r5
            r2 = r6
            int r1 = b(r1, r2)
            android.app.Notification$Builder r0 = r0.setSmallIcon(r1)
        L71:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.ak.b(android.content.Context, java.lang.String, com.xiaomi.push.eo, java.util.Map):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b  reason: collision with other method in class */
    public static boolean m12116b(Context context, String str) {
        return context.getSharedPreferences("pref_notify_type", 0).contains(str);
    }

    /* renamed from: b  reason: collision with other method in class */
    public static boolean m12117b(ic icVar) {
        ht m11945a = icVar.m11945a();
        return a(m11945a) && m11945a.f620b == 1 && !m12113a(icVar);
    }

    /* renamed from: b  reason: collision with other method in class */
    private static boolean m12118b(Map<String, String> map) {
        if (map == null) {
            com.xiaomi.channel.commonutils.logger.b.m11394a("meta extra is null");
            return false;
        }
        return "6".equals(map.get("notification_style_type"));
    }

    private static int c(Map<String, String> map) {
        if (map != null) {
            String str = map.get("notification_priority");
            if (TextUtils.isEmpty(str)) {
                return 0;
            }
            try {
                com.xiaomi.channel.commonutils.logger.b.c("priority=".concat(String.valueOf(str)));
                return Integer.parseInt(str);
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.d("parsing notification priority error: ".concat(String.valueOf(e)));
                return 0;
            }
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void c(Context context, String str) {
        context.getSharedPreferences("pref_notify_type", 0).edit().remove(str).commit();
    }

    public static boolean c(ic icVar) {
        ht m11945a = icVar.m11945a();
        return a(m11945a) && m11945a.f620b == 0 && !m12113a(icVar);
    }

    public static boolean d(ic icVar) {
        return icVar.a() == hg.Registration;
    }

    public static boolean e(ic icVar) {
        return m12113a(icVar) || c(icVar) || m12117b(icVar);
    }
}
