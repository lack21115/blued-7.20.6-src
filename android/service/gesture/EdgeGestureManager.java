package android.service.gesture;

import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.service.gesture.IEdgeGestureActivationListener;
import android.service.gesture.IEdgeGestureService;
import android.util.Slog;
import com.android.internal.util.gesture.EdgeGesturePosition;

/* loaded from: source-9557208-dex2jar.jar:android/service/gesture/EdgeGestureManager.class */
public class EdgeGestureManager {
    public static final boolean DEBUG = false;
    public static final String TAG = "EdgeGestureManager";
    private static EdgeGestureManager sInstance;
    private final IEdgeGestureService mPs;

    /* loaded from: source-9557208-dex2jar.jar:android/service/gesture/EdgeGestureManager$EdgeGestureActivationListener.class */
    public static abstract class EdgeGestureActivationListener {
        private IEdgeGestureHostCallback mCallback;
        private Delegator mDelegator;
        private Handler mHandler;

        /* loaded from: source-9557208-dex2jar.jar:android/service/gesture/EdgeGestureManager$EdgeGestureActivationListener$Delegator.class */
        private class Delegator extends IEdgeGestureActivationListener.Stub {
            private Delegator() {
            }

            @Override // android.service.gesture.IEdgeGestureActivationListener
            public void onEdgeGestureActivation(final int i, final int i2, final int i3, final int i4) throws RemoteException {
                EdgeGestureActivationListener.this.mHandler.post(new Runnable() { // from class: android.service.gesture.EdgeGestureManager.EdgeGestureActivationListener.Delegator.1
                    @Override // java.lang.Runnable
                    public void run() {
                        EdgeGestureActivationListener.this.onEdgeGestureActivation(i, i2, EdgeGesturePosition.values()[i3], i4);
                    }
                });
            }
        }

        public EdgeGestureActivationListener() {
            this(Looper.getMainLooper());
        }

        public EdgeGestureActivationListener(Looper looper) {
            this.mHandler = new Handler(looper);
            this.mDelegator = new Delegator();
        }

        public boolean dropEventsUntilLift() {
            try {
                return this.mCallback.dropEventsUntilLift();
            } catch (RemoteException e) {
                Slog.w(EdgeGestureManager.TAG, "dropNextEvents failed: " + e.getMessage());
                return false;
            }
        }

        public boolean gainTouchFocus(IBinder iBinder) {
            try {
                return this.mCallback.gainTouchFocus(iBinder);
            } catch (RemoteException e) {
                Slog.w(EdgeGestureManager.TAG, "gainTouchFocus failed: " + e.getMessage());
                return false;
            }
        }

        public abstract void onEdgeGestureActivation(int i, int i2, EdgeGesturePosition edgeGesturePosition, int i3);

        public void restoreListenerState() {
            try {
                this.mCallback.restoreListenerState();
            } catch (RemoteException e) {
                Slog.w(EdgeGestureManager.TAG, "restoreListenerState failed: " + e.getMessage());
            }
        }

        void setHostCallback(IEdgeGestureHostCallback iEdgeGestureHostCallback) {
            this.mCallback = iEdgeGestureHostCallback;
        }
    }

    private EdgeGestureManager(IEdgeGestureService iEdgeGestureService) {
        this.mPs = iEdgeGestureService;
    }

    public static EdgeGestureManager getInstance() {
        EdgeGestureManager edgeGestureManager;
        synchronized (EdgeGestureManager.class) {
            try {
                if (sInstance == null) {
                    sInstance = new EdgeGestureManager(IEdgeGestureService.Stub.asInterface(ServiceManager.getService("edgegestureservice")));
                }
                edgeGestureManager = sInstance;
            } catch (Throwable th) {
                throw th;
            }
        }
        return edgeGestureManager;
    }

    public boolean isPresent() {
        return this.mPs != null;
    }

    public boolean setEdgeGestureActivationListener(EdgeGestureActivationListener edgeGestureActivationListener) {
        try {
            edgeGestureActivationListener.setHostCallback(this.mPs.registerEdgeGestureActivationListener(edgeGestureActivationListener.mDelegator));
            return true;
        } catch (RemoteException e) {
            Slog.e(TAG, "Failed to set edge gesture activation listener: " + e.getMessage());
            return false;
        }
    }

    public void updateEdgeGestureActivationListener(EdgeGestureActivationListener edgeGestureActivationListener, int i) {
        try {
            this.mPs.updateEdgeGestureActivationListener(edgeGestureActivationListener.mDelegator.asBinder(), i);
        } catch (RemoteException e) {
            Slog.e(TAG, "Failed to update edge gesture activation listener: " + e.getMessage());
        }
    }
}
