package com.soft.blued.utils;

import android.app.NotificationManager;
import android.content.Context;
import androidx.core.app.NotificationCompat;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/utils/NotificationHelper.class */
public class NotificationHelper {

    /* renamed from: a  reason: collision with root package name */
    private static final long[] f21073a = {200, 200, 200, 200};
    private Context b;

    /* renamed from: c  reason: collision with root package name */
    private NotificationManager f21074c;

    /* renamed from: com.soft.blued.utils.NotificationHelper$1  reason: invalid class name */
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/utils/NotificationHelper$1.class */
    class AnonymousClass1 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ NotificationCompat.Builder f21075a;
        final /* synthetic */ int b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ NotificationHelper f21076c;

        @Override // java.lang.Runnable
        public final void run() {
            try {
                this.f21076c.a().notify(this.b, this.f21075a.getNotification());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public NotificationManager a() {
        if (this.f21074c == null) {
            this.f21074c = (NotificationManager) this.b.getSystemService("notification");
        }
        return this.f21074c;
    }
}
