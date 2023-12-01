package com.soft.blued.utils;

import android.app.NotificationManager;
import android.content.Context;
import androidx.core.app.NotificationCompat;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/utils/NotificationHelper.class */
public class NotificationHelper {

    /* renamed from: a  reason: collision with root package name */
    private static final long[] f34764a = {200, 200, 200, 200};
    private Context b;

    /* renamed from: c  reason: collision with root package name */
    private NotificationManager f34765c;

    /* renamed from: com.soft.blued.utils.NotificationHelper$1  reason: invalid class name */
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/utils/NotificationHelper$1.class */
    class AnonymousClass1 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ NotificationCompat.Builder f34766a;
        final /* synthetic */ int b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ NotificationHelper f34767c;

        @Override // java.lang.Runnable
        public final void run() {
            try {
                this.f34767c.a().notify(this.b, this.f34766a.getNotification());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public NotificationManager a() {
        if (this.f34765c == null) {
            this.f34765c = (NotificationManager) this.b.getSystemService("notification");
        }
        return this.f34765c;
    }
}
