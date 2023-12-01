package android.media.session;

import android.content.ComponentName;
import android.content.Context;
import android.media.IRemoteVolumeController;
import android.media.session.IActiveSessionsListener;
import android.media.session.ISessionController;
import android.media.session.ISessionManager;
import android.media.session.MediaSession;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.UserHandle;
import android.util.ArrayMap;
import android.util.Log;
import android.view.KeyEvent;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-9557208-dex2jar.jar:android/media/session/MediaSessionManager.class */
public final class MediaSessionManager {
    public static final int DIRECTION_MUTE = -99;
    private static final String TAG = "SessionManager";
    private Context mContext;
    private final ArrayMap<OnActiveSessionsChangedListener, SessionsChangedWrapper> mListeners = new ArrayMap<>();
    private final Object mLock = new Object();
    private final ISessionManager mService = ISessionManager.Stub.asInterface(ServiceManager.getService(Context.MEDIA_SESSION_SERVICE));

    /* loaded from: source-9557208-dex2jar.jar:android/media/session/MediaSessionManager$OnActiveSessionsChangedListener.class */
    public interface OnActiveSessionsChangedListener {
        void onActiveSessionsChanged(List<MediaController> list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/media/session/MediaSessionManager$SessionsChangedWrapper.class */
    public final class SessionsChangedWrapper {
        private final Handler mHandler;
        private final OnActiveSessionsChangedListener mListener;
        private final IActiveSessionsListener.Stub mStub = new IActiveSessionsListener.Stub() { // from class: android.media.session.MediaSessionManager.SessionsChangedWrapper.1
            @Override // android.media.session.IActiveSessionsListener
            public void onActiveSessionsChanged(final List<MediaSession.Token> list) {
                if (SessionsChangedWrapper.this.mHandler != null) {
                    SessionsChangedWrapper.this.mHandler.post(new Runnable() { // from class: android.media.session.MediaSessionManager.SessionsChangedWrapper.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            ArrayList arrayList = new ArrayList();
                            int size = list.size();
                            int i = 0;
                            while (true) {
                                int i2 = i;
                                if (i2 >= size) {
                                    SessionsChangedWrapper.this.mListener.onActiveSessionsChanged(arrayList);
                                    return;
                                } else {
                                    arrayList.add(new MediaController(MediaSessionManager.this.mContext, (MediaSession.Token) list.get(i2)));
                                    i = i2 + 1;
                                }
                            }
                        }
                    });
                }
            }
        };

        public SessionsChangedWrapper(OnActiveSessionsChangedListener onActiveSessionsChangedListener, Handler handler) {
            this.mListener = onActiveSessionsChangedListener;
            this.mHandler = handler;
        }
    }

    public MediaSessionManager(Context context) {
        this.mContext = context;
    }

    public void addOnActiveSessionsChangedListener(OnActiveSessionsChangedListener onActiveSessionsChangedListener, ComponentName componentName) {
        addOnActiveSessionsChangedListener(onActiveSessionsChangedListener, componentName, null);
    }

    public void addOnActiveSessionsChangedListener(OnActiveSessionsChangedListener onActiveSessionsChangedListener, ComponentName componentName, int i, Handler handler) {
        if (onActiveSessionsChangedListener == null) {
            throw new IllegalArgumentException("listener may not be null");
        }
        Handler handler2 = handler;
        if (handler == null) {
            handler2 = new Handler();
        }
        synchronized (this.mLock) {
            if (this.mListeners.get(onActiveSessionsChangedListener) != null) {
                Log.w(TAG, "Attempted to add session listener twice, ignoring.");
                return;
            }
            SessionsChangedWrapper sessionsChangedWrapper = new SessionsChangedWrapper(onActiveSessionsChangedListener, handler2);
            try {
                this.mService.addSessionsListener(sessionsChangedWrapper.mStub, componentName, i);
                this.mListeners.put(onActiveSessionsChangedListener, sessionsChangedWrapper);
            } catch (RemoteException e) {
                Log.e(TAG, "Error in addOnActiveSessionsChangedListener.", e);
            }
        }
    }

    public void addOnActiveSessionsChangedListener(OnActiveSessionsChangedListener onActiveSessionsChangedListener, ComponentName componentName, Handler handler) {
        addOnActiveSessionsChangedListener(onActiveSessionsChangedListener, componentName, UserHandle.myUserId(), handler);
    }

    public ISession createSession(MediaSession.CallbackStub callbackStub, String str, int i) throws RemoteException {
        return this.mService.createSession(this.mContext.getPackageName(), callbackStub, str, i);
    }

    public void dispatchAdjustVolume(int i, int i2, int i3) {
        try {
            this.mService.dispatchAdjustVolume(i, i2, i3);
        } catch (RemoteException e) {
            Log.e(TAG, "Failed to send adjust volume.", e);
        }
    }

    public void dispatchMediaKeyEvent(KeyEvent keyEvent) {
        dispatchMediaKeyEvent(keyEvent, false);
    }

    public void dispatchMediaKeyEvent(KeyEvent keyEvent, boolean z) {
        try {
            this.mService.dispatchMediaKeyEvent(keyEvent, z);
        } catch (RemoteException e) {
            Log.e(TAG, "Failed to send key event.", e);
        }
    }

    public List<MediaController> getActiveSessions(ComponentName componentName) {
        return getActiveSessionsForUser(componentName, UserHandle.myUserId());
    }

    public List<MediaController> getActiveSessionsForUser(ComponentName componentName, int i) {
        ArrayList arrayList = new ArrayList();
        try {
            List<IBinder> sessions = this.mService.getSessions(componentName, i);
            int size = sessions.size();
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= size) {
                    break;
                }
                arrayList.add(new MediaController(this.mContext, ISessionController.Stub.asInterface(sessions.get(i3))));
                i2 = i3 + 1;
            }
        } catch (RemoteException e) {
            Log.e(TAG, "Failed to get active sessions: ", e);
        }
        return arrayList;
    }

    public boolean isGlobalPriorityActive() {
        try {
            return this.mService.isGlobalPriorityActive();
        } catch (RemoteException e) {
            Log.e(TAG, "Failed to check if the global priority is active.", e);
            return false;
        }
    }

    public void removeOnActiveSessionsChangedListener(OnActiveSessionsChangedListener onActiveSessionsChangedListener) {
        if (onActiveSessionsChangedListener == null) {
            throw new IllegalArgumentException("listener may not be null");
        }
        synchronized (this.mLock) {
            SessionsChangedWrapper remove = this.mListeners.remove(onActiveSessionsChangedListener);
            if (remove != null) {
                try {
                    this.mService.removeSessionsListener(remove.mStub);
                } catch (RemoteException e) {
                    Log.e(TAG, "Error in removeOnActiveSessionsChangedListener.", e);
                }
            }
        }
    }

    public void setRemoteVolumeController(IRemoteVolumeController iRemoteVolumeController) {
        try {
            this.mService.setRemoteVolumeController(iRemoteVolumeController);
        } catch (RemoteException e) {
            Log.e(TAG, "Error in setRemoteVolumeController.", e);
        }
    }
}
