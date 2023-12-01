package com.blued.android.framework.ui.mvp;

import android.os.Looper;
import java.util.List;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/ui/mvp/MvpUtils.class */
public class MvpUtils {

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/ui/mvp/MvpUtils$DataHandler.class */
    public interface DataHandler<T> {
        void a();

        void a(T t);
    }

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/ui/mvp/MvpUtils$DataListHandler.class */
    public interface DataListHandler<T> {
        void a();

        void a(List<T> list);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> void a(List list, Class<T> cls, DataHandler<T> dataHandler) {
        if (list != null && list.size() > 0) {
            Object obj = list.get(0);
            if (cls.isInstance(obj)) {
                dataHandler.a(obj);
                return;
            }
        }
        dataHandler.a();
    }

    public static <T> void a(List list, Class<T> cls, DataListHandler<T> dataListHandler) {
        if (list == null || list.size() <= 0 || !cls.isInstance(list.get(0))) {
            dataListHandler.a();
        } else {
            dataListHandler.a(list);
        }
    }

    public static boolean a() {
        return Thread.currentThread() == Looper.getMainLooper().getThread();
    }
}
