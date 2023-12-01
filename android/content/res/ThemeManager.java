package android.content.res;

import android.content.Context;
import android.content.res.IThemeChangeListener;
import android.content.res.IThemeProcessingListener;
import android.content.res.ThemeChangeRequest;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: source-9557208-dex2jar.jar:android/content/res/ThemeManager.class */
public class ThemeManager {
    private static final String TAG = ThemeManager.class.getName();
    private Context mContext;
    private IThemeService mService;
    private Set<ThemeChangeListener> mChangeListeners = new HashSet();
    private Set<ThemeProcessingListener> mProcessingListeners = new HashSet();
    private final IThemeChangeListener mThemeChangeListener = new IThemeChangeListener.Stub() { // from class: android.content.res.ThemeManager.1
        @Override // android.content.res.IThemeChangeListener
        public void onFinish(final boolean z) throws RemoteException {
            ThemeManager.this.mHandler.post(new Runnable() { // from class: android.content.res.ThemeManager.1.2
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (ThemeManager.this.mChangeListeners) {
                        ArrayList<ThemeChangeListener> arrayList = new ArrayList();
                        for (ThemeChangeListener themeChangeListener : ThemeManager.this.mChangeListeners) {
                            themeChangeListener.onFinish(z);
                        }
                        if (arrayList.size() > 0) {
                            for (ThemeChangeListener themeChangeListener2 : arrayList) {
                                ThemeManager.this.mChangeListeners.remove(themeChangeListener2);
                            }
                        }
                    }
                }
            });
        }

        @Override // android.content.res.IThemeChangeListener
        public void onProgress(final int i) throws RemoteException {
            ThemeManager.this.mHandler.post(new Runnable() { // from class: android.content.res.ThemeManager.1.1
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (ThemeManager.this.mChangeListeners) {
                        ArrayList<ThemeChangeListener> arrayList = new ArrayList();
                        for (ThemeChangeListener themeChangeListener : ThemeManager.this.mChangeListeners) {
                            themeChangeListener.onProgress(i);
                        }
                        if (arrayList.size() > 0) {
                            for (ThemeChangeListener themeChangeListener2 : arrayList) {
                                ThemeManager.this.mChangeListeners.remove(themeChangeListener2);
                            }
                        }
                    }
                }
            });
        }
    };
    private final IThemeProcessingListener mThemeProcessingListener = new IThemeProcessingListener.Stub() { // from class: android.content.res.ThemeManager.2
        @Override // android.content.res.IThemeProcessingListener
        public void onFinishedProcessing(final String str) throws RemoteException {
            ThemeManager.this.mHandler.post(new Runnable() { // from class: android.content.res.ThemeManager.2.1
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (ThemeManager.this.mProcessingListeners) {
                        ArrayList<ThemeProcessingListener> arrayList = new ArrayList();
                        for (ThemeProcessingListener themeProcessingListener : ThemeManager.this.mProcessingListeners) {
                            themeProcessingListener.onFinishedProcessing(str);
                        }
                        if (arrayList.size() > 0) {
                            for (ThemeProcessingListener themeProcessingListener2 : arrayList) {
                                ThemeManager.this.mProcessingListeners.remove(themeProcessingListener2);
                            }
                        }
                    }
                }
            });
        }
    };
    private Handler mHandler = new Handler(Looper.getMainLooper());

    /* loaded from: source-9557208-dex2jar.jar:android/content/res/ThemeManager$ThemeChangeListener.class */
    public interface ThemeChangeListener {
        void onFinish(boolean z);

        void onProgress(int i);
    }

    /* loaded from: source-9557208-dex2jar.jar:android/content/res/ThemeManager$ThemeProcessingListener.class */
    public interface ThemeProcessingListener {
        void onFinishedProcessing(String str);
    }

    public ThemeManager(Context context, IThemeService iThemeService) {
        this.mContext = context;
        this.mService = iThemeService;
    }

    static /* synthetic */ String access$100() {
        return TAG;
    }

    private void logThemeServiceException(Exception exc) {
        Log.w(TAG, "Unable to access ThemeService", exc);
    }

    public void addClient(ThemeChangeListener themeChangeListener) {
        synchronized (this.mChangeListeners) {
            if (this.mChangeListeners.contains(themeChangeListener)) {
                throw new IllegalArgumentException("Client was already added ");
            }
            if (this.mChangeListeners.size() == 0) {
                try {
                    this.mService.requestThemeChangeUpdates(this.mThemeChangeListener);
                } catch (RemoteException e) {
                    Log.w(TAG, "Unable to register listener", e);
                }
            }
            this.mChangeListeners.add(themeChangeListener);
        }
    }

    public void applyDefaultTheme() {
        try {
            this.mService.applyDefaultTheme();
        } catch (RemoteException e) {
            logThemeServiceException(e);
        }
    }

    public int getProgress() {
        try {
            return this.mService.getProgress();
        } catch (RemoteException e) {
            logThemeServiceException(e);
            return -1;
        }
    }

    public boolean isThemeApplying() {
        try {
            return this.mService.isThemeApplying();
        } catch (RemoteException e) {
            logThemeServiceException(e);
            return false;
        }
    }

    public boolean isThemeBeingProcessed(String str) {
        try {
            return this.mService.isThemeBeingProcessed(str);
        } catch (RemoteException e) {
            logThemeServiceException(e);
            return false;
        }
    }

    public void onClientDestroyed(ThemeChangeListener themeChangeListener) {
        removeClient(themeChangeListener);
    }

    public void onClientPaused(ThemeChangeListener themeChangeListener) {
        removeClient(themeChangeListener);
    }

    public void onClientResumed(ThemeChangeListener themeChangeListener) {
        addClient(themeChangeListener);
    }

    public boolean processThemeResources(String str) {
        try {
            return this.mService.processThemeResources(str);
        } catch (RemoteException e) {
            logThemeServiceException(e);
            return false;
        }
    }

    public void registerProcessingListener(ThemeProcessingListener themeProcessingListener) {
        synchronized (this.mProcessingListeners) {
            if (this.mProcessingListeners.contains(themeProcessingListener)) {
                throw new IllegalArgumentException("Listener was already added ");
            }
            if (this.mProcessingListeners.size() == 0) {
                try {
                    this.mService.registerThemeProcessingListener(this.mThemeProcessingListener);
                } catch (RemoteException e) {
                    Log.w(TAG, "Unable to register listener", e);
                }
            }
            this.mProcessingListeners.add(themeProcessingListener);
        }
    }

    public void removeClient(ThemeChangeListener themeChangeListener) {
        synchronized (this.mChangeListeners) {
            this.mChangeListeners.remove(themeChangeListener);
            if (this.mChangeListeners.size() == 0) {
                try {
                    this.mService.removeUpdates(this.mThemeChangeListener);
                } catch (RemoteException e) {
                    Log.w(TAG, "Unable to remove listener", e);
                }
            }
        }
    }

    public void requestThemeChange(ThemeChangeRequest themeChangeRequest, boolean z) {
        try {
            this.mService.requestThemeChange(themeChangeRequest, z);
        } catch (RemoteException e) {
            logThemeServiceException(e);
        }
    }

    public void requestThemeChange(String str) {
    }

    public void requestThemeChange(String str, List<String> list) {
        requestThemeChange(str, list, true);
    }

    public void requestThemeChange(String str, List<String> list, boolean z) {
        HashMap hashMap = new HashMap(list.size());
        for (String str2 : list) {
            hashMap.put(str2, str);
        }
        requestThemeChange(hashMap, z);
    }

    public void requestThemeChange(Map<String, String> map) {
        requestThemeChange(map, true);
    }

    public void requestThemeChange(Map<String, String> map, boolean z) {
        ThemeChangeRequest.Builder builder = new ThemeChangeRequest.Builder();
        for (String str : map.keySet()) {
            builder.setComponent(str, map.get(str));
        }
        requestThemeChange(builder.build(), z);
    }

    public void unregisterProcessingListener(ThemeChangeListener themeChangeListener) {
        synchronized (this.mProcessingListeners) {
            this.mProcessingListeners.remove(themeChangeListener);
            if (this.mProcessingListeners.size() == 0) {
                try {
                    this.mService.unregisterThemeProcessingListener(this.mThemeProcessingListener);
                } catch (RemoteException e) {
                    Log.w(TAG, "Unable to remove listener", e);
                }
            }
        }
    }
}
