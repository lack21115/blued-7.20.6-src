package com.blued.android.core.utils.toast;

import android.app.Activity;
import android.app.AppOpsManager;
import android.app.Application;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import com.blued.android.core.utils.toast.config.IToast;
import com.blued.android.core.utils.toast.config.IToastStrategy;
import com.blued.android.core.utils.toast.config.IToastStyle;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/utils/toast/ToastStrategy.class */
public class ToastStrategy implements IToastStrategy {
    private static final Handler a = new Handler(Looper.getMainLooper());
    private Application b;
    private ActivityStack c;
    private WeakReference<IToast> d;
    private IToastStyle<?> e;
    private volatile CharSequence f;
    private volatile ConcurrentHashMap<CharSequence, Integer> g = new ConcurrentHashMap<>();
    private final Runnable h = new Runnable() { // from class: com.blued.android.core.utils.toast.ToastStrategy.1
        @Override // java.lang.Runnable
        public void run() {
            IToast iToast = ToastStrategy.this.d != null ? (IToast) ToastStrategy.this.d.get() : null;
            if (iToast != null) {
                iToast.cancel();
            }
            ToastStrategy toastStrategy = ToastStrategy.this;
            IToast b = toastStrategy.b(toastStrategy.b);
            ToastStrategy.this.d = new WeakReference(b);
            ToastStrategy toastStrategy2 = ToastStrategy.this;
            b.setDuration(toastStrategy2.a(toastStrategy2.f));
            b.setText(ToastStrategy.this.f);
            b.show();
            ToastStrategy.this.g.remove(ToastStrategy.this.f);
        }
    };
    private final Runnable i = new Runnable() { // from class: com.blued.android.core.utils.toast.ToastStrategy.2
        @Override // java.lang.Runnable
        public void run() {
            IToast iToast = ToastStrategy.this.d != null ? (IToast) ToastStrategy.this.d.get() : null;
            if (iToast == null) {
                return;
            }
            iToast.cancel();
        }
    };

    protected int a(CharSequence charSequence) {
        Integer num = this.g.get(charSequence);
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    @Override // com.blued.android.core.utils.toast.config.IToastStrategy
    public void a(Application application) {
        this.b = application;
        this.c = ActivityStack.a(application);
    }

    @Override // com.blued.android.core.utils.toast.config.IToastStrategy
    public void a(IToastStyle<?> iToastStyle) {
        this.e = iToastStyle;
    }

    @Override // com.blued.android.core.utils.toast.config.IToastStrategy
    public void a(CharSequence charSequence, long j, int i) {
        this.f = charSequence;
        this.g.put(this.f, Integer.valueOf(i));
        a.removeCallbacks(this.h);
        a.postDelayed(this.h, j + 200);
    }

    protected boolean a(Context context) {
        NotificationManager notificationManager;
        if (Build.VERSION.SDK_INT < 24 || (notificationManager = (NotificationManager) context.getSystemService(NotificationManager.class)) == null) {
            if (Build.VERSION.SDK_INT >= 19) {
                AppOpsManager appOpsManager = (AppOpsManager) context.getSystemService("appops");
                try {
                    return ((Integer) appOpsManager.getClass().getMethod("checkOpNoThrow", Integer.TYPE, Integer.TYPE, String.class).invoke(appOpsManager, Integer.valueOf(((Integer) appOpsManager.getClass().getDeclaredField("OP_POST_NOTIFICATION").get(Integer.class)).intValue()), Integer.valueOf(context.getApplicationInfo().uid), context.getPackageName())).intValue() == 0;
                } catch (IllegalAccessException | NoSuchFieldException | NoSuchMethodException | RuntimeException | InvocationTargetException e) {
                    e.printStackTrace();
                    return true;
                }
            }
            return true;
        }
        return notificationManager.areNotificationsEnabled();
    }

    public IToast b(Application application) {
        Activity a2 = this.c.a();
        IToast activityToast = (Build.VERSION.SDK_INT < 23 || !Settings.canDrawOverlays(application)) ? a2 != null ? new ActivityToast(a2) : Build.VERSION.SDK_INT == 25 ? new SafeToast(application) : (Build.VERSION.SDK_INT >= 29 || a((Context) application)) ? new SystemToast(application) : new NotificationToast(application) : new WindowToast(application);
        if ((activityToast instanceof CustomToast) || Build.VERSION.SDK_INT < 30 || application.getApplicationInfo().targetSdkVersion < 30) {
            activityToast.setView(this.e.a(application));
            activityToast.setGravity(this.e.a(), this.e.b(application), this.e.c(application));
            activityToast.setMargin(this.e.b(), this.e.c());
        }
        return activityToast;
    }
}
