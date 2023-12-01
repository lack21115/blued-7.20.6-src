package android.hardware.camera2.utils;

import android.hardware.camera2.utils.Decorator;
import android.os.DeadObjectException;
import android.os.RemoteException;
import java.lang.reflect.Method;

/* loaded from: source-9557208-dex2jar.jar:android/hardware/camera2/utils/CameraBinderDecorator.class */
public class CameraBinderDecorator {
    public static final int ALREADY_EXISTS = -17;
    public static final int BAD_VALUE = -22;
    public static final int DEAD_OBJECT = -32;
    public static final int EACCES = -13;
    public static final int EBUSY = -16;
    public static final int ENODEV = -19;
    public static final int EOPNOTSUPP = -95;
    public static final int EUSERS = -87;
    public static final int INVALID_OPERATION = -38;
    public static final int NO_ERROR = 0;
    public static final int PERMISSION_DENIED = -1;
    public static final int TIMED_OUT = -110;

    /* loaded from: source-9557208-dex2jar.jar:android/hardware/camera2/utils/CameraBinderDecorator$CameraBinderDecoratorListener.class */
    static class CameraBinderDecoratorListener implements Decorator.DecoratorListener {
        @Override // android.hardware.camera2.utils.Decorator.DecoratorListener
        public void onAfterInvocation(Method method, Object[] objArr, Object obj) {
            if (method.getReturnType() == Integer.TYPE) {
                CameraBinderDecorator.throwOnError(((Integer) obj).intValue());
            }
        }

        @Override // android.hardware.camera2.utils.Decorator.DecoratorListener
        public void onBeforeInvocation(Method method, Object[] objArr) {
        }

        @Override // android.hardware.camera2.utils.Decorator.DecoratorListener
        public boolean onCatchException(Method method, Object[] objArr, Throwable th) {
            if (th instanceof DeadObjectException) {
                throw new CameraRuntimeException(2, "Process hosting the camera service has died unexpectedly", th);
            }
            if (th instanceof RemoteException) {
                throw new UnsupportedOperationException("An unknown RemoteException was thrown which should never happen.", th);
            }
            return false;
        }

        @Override // android.hardware.camera2.utils.Decorator.DecoratorListener
        public void onFinally(Method method, Object[] objArr) {
        }
    }

    public static <T> T newInstance(T t) {
        return (T) Decorator.newInstance(t, new CameraBinderDecoratorListener());
    }

    public static void throwOnError(int i) {
        switch (i) {
            case -110:
                throw new CameraRuntimeException(3, "Operation timed out in camera service");
            case EOPNOTSUPP /* -95 */:
                throw new CameraRuntimeException(1000);
            case EUSERS /* -87 */:
                throw new CameraRuntimeException(5);
            case -38:
                throw new CameraRuntimeException(3, "Illegal state encountered in camera service.");
            case -32:
                throw new CameraRuntimeException(2);
            case -22:
                throw new IllegalArgumentException("Bad argument passed to camera service");
            case -19:
                throw new CameraRuntimeException(2);
            case -17:
            case 0:
                return;
            case -16:
                throw new CameraRuntimeException(4);
            case -13:
                throw new CameraRuntimeException(1);
            case -1:
                throw new SecurityException("Lacking privileges to access camera service");
            default:
                if (i < 0) {
                    throw new UnsupportedOperationException(String.format("Unknown error %d", Integer.valueOf(i)));
                }
                return;
        }
    }
}
