package android.hardware.camera2.utils;

import android.hardware.camera2.utils.CameraBinderDecorator;
import android.os.DeadObjectException;
import android.os.RemoteException;
import android.util.Log;
import java.lang.reflect.Method;

/* loaded from: source-9557208-dex2jar.jar:android/hardware/camera2/utils/CameraServiceBinderDecorator.class */
public class CameraServiceBinderDecorator extends CameraBinderDecorator {
    private static final String TAG = "CameraServiceBinderDecorator";

    /* loaded from: source-9557208-dex2jar.jar:android/hardware/camera2/utils/CameraServiceBinderDecorator$CameraServiceBinderDecoratorListener.class */
    static class CameraServiceBinderDecoratorListener extends CameraBinderDecorator.CameraBinderDecoratorListener {
        CameraServiceBinderDecoratorListener() {
        }

        @Override // android.hardware.camera2.utils.CameraBinderDecorator.CameraBinderDecoratorListener, android.hardware.camera2.utils.Decorator.DecoratorListener
        public boolean onCatchException(Method method, Object[] objArr, Throwable th) {
            if (!(th instanceof DeadObjectException) && (th instanceof RemoteException)) {
                Log.e(CameraServiceBinderDecorator.TAG, "Unexpected RemoteException from camera service call.", th);
                return false;
            }
            return false;
        }
    }

    public static <T> T newInstance(T t) {
        return (T) Decorator.newInstance(t, new CameraServiceBinderDecoratorListener());
    }
}
