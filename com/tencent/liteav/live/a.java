package com.tencent.liteav.live;

import com.tencent.rtmp.ui.TXCloudVideoView;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/live/a.class */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static Method f22727a;
    private static Method b;

    static {
        try {
            Method declaredMethod = TXCloudVideoView.class.getDeclaredMethod("setShowLogCallback", WeakReference.class);
            f22727a = declaredMethod;
            declaredMethod.setAccessible(true);
            Method declaredMethod2 = TXCloudVideoView.class.getDeclaredMethod("isShowLogEnabled", new Class[0]);
            b = declaredMethod2;
            declaredMethod2.setAccessible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void a(TXCloudVideoView tXCloudVideoView, WeakReference<TXCloudVideoView.b> weakReference) {
        if (tXCloudVideoView == null) {
            return;
        }
        try {
            f22727a.invoke(tXCloudVideoView, weakReference);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean a(TXCloudVideoView tXCloudVideoView) {
        if (tXCloudVideoView == null) {
            return false;
        }
        try {
            Object invoke = b.invoke(tXCloudVideoView, new Object[0]);
            if (invoke == null || !(invoke instanceof Boolean)) {
                return false;
            }
            return ((Boolean) invoke).booleanValue();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
