package com.oplus.log.b.a;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;
import java.util.HashMap;

/* loaded from: source-8303388-dex2jar.jar:com/oplus/log/b/a/a.class */
public final class a implements c {

    /* renamed from: a  reason: collision with root package name */
    static com.oplus.log.f.d f10629a;
    private int b = 0;

    /* renamed from: c  reason: collision with root package name */
    private boolean f10630c = false;
    private Handler d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.oplus.log.b.a.a$a  reason: collision with other inner class name */
    /* loaded from: source-8303388-dex2jar.jar:com/oplus/log/b/a/a$a.class */
    public static final class HandlerC0443a extends Handler {

        /* renamed from: a  reason: collision with root package name */
        private final WeakReference<Activity> f10631a;

        public HandlerC0443a(Activity activity) {
            this.f10631a = new WeakReference<>(activity);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            com.oplus.log.b.b bVar;
            Activity activity = this.f10631a.get();
            if (activity != null) {
                if (message.what == 123) {
                    Bitmap a2 = com.oplus.log.d.c.a(activity);
                    if (a2 == null) {
                        return;
                    }
                    HashMap hashMap = new HashMap();
                    hashMap.put("activity_name", (String) message.obj);
                    bVar = new com.oplus.log.b.b("screenshot", a2, (byte) 4, null, hashMap);
                } else if (message.what != 124) {
                    return;
                } else {
                    bVar = new com.oplus.log.b.b("Network_Info", com.oplus.log.d.c.a(), (byte) 4, null, null);
                }
                a.f10629a.a(bVar);
            }
        }
    }

    public a(com.oplus.log.f.d dVar) {
        f10629a = dVar;
    }

    private void a(boolean z, boolean z2, Context context) {
        if (f10629a == null) {
            return;
        }
        if (!z) {
            int i = this.b - 1;
            this.b = i;
            if (i == 0 || z2) {
                f10629a.a(new com.oplus.log.b.b(com.umeng.analytics.pro.d.aw, "session end", (byte) 4, null, null));
                return;
            }
            return;
        }
        int i2 = this.b;
        this.b = i2 + 1;
        if (i2 != 0 || z2) {
            return;
        }
        f10629a.a(new com.oplus.log.b.b(com.umeng.analytics.pro.d.aw, "session start", (byte) 4, null, null));
        if (this.d == null) {
            this.d = new HandlerC0443a((Activity) context);
        }
        this.d.sendEmptyMessage(124);
    }

    @Override // com.oplus.log.b.a.c
    public final void a(Context context) {
        if (f10629a == null) {
            return;
        }
        String simpleName = ((Activity) context).getClass().getSimpleName();
        a(true, this.f10630c, context);
        this.f10630c = false;
        f10629a.a(new com.oplus.log.b.b("activity_lifecycle", simpleName + " start ", (byte) 4, null, null));
    }

    @Override // com.oplus.log.b.a.c
    public final void b(Context context) {
        if (f10629a == null) {
            return;
        }
        Activity activity = (Activity) context;
        String simpleName = activity.getClass().getSimpleName();
        f10629a.a(new com.oplus.log.b.b("activity_lifecycle", simpleName + " stop ", (byte) 4, null, null));
        boolean z = activity.getChangingConfigurations() != 0;
        this.f10630c = z;
        a(false, z, null);
    }
}
