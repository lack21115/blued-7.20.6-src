package com.blued.android.core.utils.toast;

import android.app.Application;
import android.os.Handler;
import android.widget.Toast;
import java.lang.reflect.Field;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/utils/toast/SafeToast.class */
public class SafeToast extends NotificationToast {

    /* renamed from: a  reason: collision with root package name */
    private boolean f9755a;

    public SafeToast(Application application) {
        super(application);
    }

    private void a() {
        if (this.f9755a) {
            return;
        }
        this.f9755a = true;
        try {
            Field declaredField = Toast.class.getDeclaredField("mTN");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(this);
            Field declaredField2 = declaredField.getType().getDeclaredField("mHandler");
            declaredField2.setAccessible(true);
            Handler handler = (Handler) declaredField2.get(obj);
            if (handler instanceof SafeHandler) {
                return;
            }
            declaredField2.set(obj, new SafeHandler(handler));
        } catch (IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    @Override // com.blued.android.core.utils.toast.NotificationToast, android.widget.Toast, com.blued.android.core.utils.toast.config.IToast
    public void show() {
        a();
        super.show();
    }
}
