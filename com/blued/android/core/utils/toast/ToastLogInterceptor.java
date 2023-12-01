package com.blued.android.core.utils.toast;

import android.util.Log;
import com.blued.android.core.utils.toast.config.IToastInterceptor;
import java.lang.reflect.Modifier;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/utils/toast/ToastLogInterceptor.class */
public class ToastLogInterceptor implements IToastInterceptor {
    protected void a(String str) {
        Log.i("ToastUtils", str);
    }

    protected boolean a() {
        return ToastUtils.a();
    }

    @Override // com.blued.android.core.utils.toast.config.IToastInterceptor
    public boolean a(CharSequence charSequence) {
        b(charSequence);
        return false;
    }

    protected boolean a(Class<?> cls) {
        return ToastLogInterceptor.class.equals(cls) || ToastUtils.class.equals(cls) || cls.isInterface() || Modifier.isAbstract(cls.getModifiers());
    }

    protected void b(CharSequence charSequence) {
        if (!a()) {
            return;
        }
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        int length = stackTrace.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            StackTraceElement stackTraceElement = stackTrace[i2];
            int lineNumber = stackTraceElement.getLineNumber();
            if (lineNumber > 0) {
                try {
                    if (!a(Class.forName(stackTraceElement.getClassName()))) {
                        a("(" + stackTraceElement.getFileName() + ":" + lineNumber + ") " + charSequence.toString());
                        return;
                    }
                    continue;
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
            i = i2 + 1;
        }
    }
}
