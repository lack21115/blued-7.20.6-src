package com.blued.android.core.utils.toast;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.widget.Toast;
import com.blued.android.core.utils.toast.ToastImpl;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/utils/toast/ToastImpl.class */
public final class ToastImpl {
    private static final Handler a = new Handler(Looper.getMainLooper());
    private final CustomToast b;
    private WindowLifecycle c;
    private final String d;
    private boolean e;
    private boolean f;
    private final Runnable g;
    private final Runnable h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.blued.android.core.utils.toast.ToastImpl$1  reason: invalid class name */
    /* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/utils/toast/ToastImpl$1.class */
    public class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a() {
            ToastImpl.this.c();
        }

        @Override // java.lang.Runnable
        public void run() {
            WindowManager a = ToastImpl.this.c.a();
            if (a == null) {
                return;
            }
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            layoutParams.height = -2;
            layoutParams.width = -2;
            layoutParams.format = -3;
            layoutParams.flags = 152;
            layoutParams.packageName = ToastImpl.this.d;
            layoutParams.gravity = ToastImpl.this.b.c();
            layoutParams.x = ToastImpl.this.b.d();
            layoutParams.y = ToastImpl.this.b.e();
            layoutParams.verticalMargin = ToastImpl.this.b.g();
            layoutParams.horizontalMargin = ToastImpl.this.b.f();
            layoutParams.windowAnimations = ToastImpl.this.b.h();
            if (ToastImpl.this.f) {
                if (Build.VERSION.SDK_INT >= 26) {
                    layoutParams.type = 2038;
                } else {
                    layoutParams.type = 2003;
                }
            }
            try {
                a.addView(ToastImpl.this.b.a(), layoutParams);
                ToastImpl.a.postDelayed(new Runnable() { // from class: com.blued.android.core.utils.toast.-$$Lambda$ToastImpl$1$wuYqxjhtn6fgPDJpRnEykKenJUY
                    @Override // java.lang.Runnable
                    public final void run() {
                        ToastImpl.AnonymousClass1.this.a();
                    }
                }, ToastImpl.this.b.b() == 1 ? ToastImpl.this.b.j() : ToastImpl.this.b.i());
                ToastImpl.this.c.a(ToastImpl.this);
                ToastImpl.this.a(true);
                ToastImpl.this.a(ToastImpl.this.b.a());
            } catch (WindowManager.BadTokenException | IllegalStateException e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ToastImpl(Activity activity, CustomToast customToast) {
        this((Context) activity, customToast);
        this.f = false;
        this.c = new WindowLifecycle(activity);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ToastImpl(Application application, CustomToast customToast) {
        this((Context) application, customToast);
        this.f = true;
        this.c = new WindowLifecycle(application);
    }

    private ToastImpl(Context context, CustomToast customToast) {
        this.g = new AnonymousClass1();
        this.h = new Runnable() { // from class: com.blued.android.core.utils.toast.ToastImpl.2
            @Override // java.lang.Runnable
            public void run() {
                WindowManager a2;
                try {
                    try {
                        a2 = ToastImpl.this.c.a();
                    } catch (IllegalArgumentException e) {
                        e.printStackTrace();
                    }
                    if (a2 == null) {
                        return;
                    }
                    a2.removeViewImmediate(ToastImpl.this.b.a());
                } finally {
                    ToastImpl.this.c.b();
                    ToastImpl.this.a(false);
                }
            }
        };
        this.b = customToast;
        this.d = context.getPackageName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view) {
        Context context = view.getContext();
        AccessibilityManager accessibilityManager = (AccessibilityManager) context.getSystemService("accessibility");
        if (accessibilityManager.isEnabled()) {
            AccessibilityEvent obtain = AccessibilityEvent.obtain(64);
            obtain.setClassName(Toast.class.getName());
            obtain.setPackageName(context.getPackageName());
            view.dispatchPopulateAccessibilityEvent(obtain);
            accessibilityManager.sendAccessibilityEvent(obtain);
        }
    }

    private boolean e() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    void a(boolean z) {
        this.e = z;
    }

    boolean a() {
        return this.e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        if (a()) {
            return;
        }
        if (e()) {
            this.g.run();
            return;
        }
        a.removeCallbacks(this.g);
        a.post(this.g);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        if (a()) {
            a.removeCallbacks(this.g);
            if (e()) {
                this.h.run();
                return;
            }
            a.removeCallbacks(this.h);
            a.post(this.h);
        }
    }
}
