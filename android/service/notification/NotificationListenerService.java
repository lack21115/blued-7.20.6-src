package android.service.notification;

import android.app.INotificationManager;
import android.app.Notification;
import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.service.notification.INotificationListener;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.Log;
import java.util.Collections;
import java.util.List;

/* loaded from: source-9557208-dex2jar.jar:android/service/notification/NotificationListenerService.class */
public abstract class NotificationListenerService extends Service {
    public static final int HINT_HOST_DISABLE_EFFECTS = 1;
    public static final int INTERRUPTION_FILTER_ALL = 1;
    public static final int INTERRUPTION_FILTER_NONE = 3;
    public static final int INTERRUPTION_FILTER_PRIORITY = 2;
    public static final String SERVICE_INTERFACE = "android.service.notification.NotificationListenerService";
    public static final int TRIM_FULL = 0;
    public static final int TRIM_LIGHT = 1;
    private int mCurrentUser;
    private INotificationManager mNoMan;
    private RankingMap mRankingMap;
    private Context mSystemContext;
    private final String TAG = NotificationListenerService.class.getSimpleName() + "[" + getClass().getSimpleName() + "]";
    private INotificationListenerWrapper mWrapper = null;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/service/notification/NotificationListenerService$INotificationListenerWrapper.class */
    public class INotificationListenerWrapper extends INotificationListener.Stub {
        private INotificationListenerWrapper() {
        }

        @Override // android.service.notification.INotificationListener
        public void onInterruptionFilterChanged(int i) throws RemoteException {
            try {
                NotificationListenerService.this.onInterruptionFilterChanged(i);
            } catch (Throwable th) {
                Log.w(NotificationListenerService.this.TAG, "Error running onInterruptionFilterChanged", th);
            }
        }

        @Override // android.service.notification.INotificationListener
        public void onListenerConnected(NotificationRankingUpdate notificationRankingUpdate) {
            synchronized (NotificationListenerService.this.mWrapper) {
                NotificationListenerService.this.applyUpdate(notificationRankingUpdate);
                NotificationListenerService.this.onListenerConnected();
            }
        }

        @Override // android.service.notification.INotificationListener
        public void onListenerHintsChanged(int i) throws RemoteException {
            try {
                NotificationListenerService.this.onListenerHintsChanged(i);
            } catch (Throwable th) {
                Log.w(NotificationListenerService.this.TAG, "Error running onListenerHintsChanged", th);
            }
        }

        @Override // android.service.notification.INotificationListener
        public void onNotificationPosted(IStatusBarNotificationHolder iStatusBarNotificationHolder, NotificationRankingUpdate notificationRankingUpdate) {
            try {
                StatusBarNotification statusBarNotification = iStatusBarNotificationHolder.get();
                Notification.Builder.rebuild(NotificationListenerService.this.getContext(), statusBarNotification.getNotification());
                synchronized (NotificationListenerService.this.mWrapper) {
                    NotificationListenerService.this.applyUpdate(notificationRankingUpdate);
                    NotificationListenerService.this.onNotificationPosted(statusBarNotification, NotificationListenerService.this.mRankingMap);
                }
            } catch (RemoteException e) {
                Log.w(NotificationListenerService.this.TAG, "onNotificationPosted: Error receiving StatusBarNotification", e);
            }
        }

        @Override // android.service.notification.INotificationListener
        public void onNotificationRankingUpdate(NotificationRankingUpdate notificationRankingUpdate) throws RemoteException {
            synchronized (NotificationListenerService.this.mWrapper) {
                NotificationListenerService.this.applyUpdate(notificationRankingUpdate);
                NotificationListenerService.this.onNotificationRankingUpdate(NotificationListenerService.this.mRankingMap);
            }
        }

        @Override // android.service.notification.INotificationListener
        public void onNotificationRemoved(IStatusBarNotificationHolder iStatusBarNotificationHolder, NotificationRankingUpdate notificationRankingUpdate) {
            try {
                StatusBarNotification statusBarNotification = iStatusBarNotificationHolder.get();
                synchronized (NotificationListenerService.this.mWrapper) {
                    NotificationListenerService.this.applyUpdate(notificationRankingUpdate);
                    NotificationListenerService.this.onNotificationRemoved(statusBarNotification, NotificationListenerService.this.mRankingMap);
                }
            } catch (RemoteException e) {
                Log.w(NotificationListenerService.this.TAG, "onNotificationRemoved: Error receiving StatusBarNotification", e);
            }
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/service/notification/NotificationListenerService$Ranking.class */
    public static class Ranking {
        public static final int VISIBILITY_NO_OVERRIDE = -1000;
        private boolean mIsAmbient;
        private String mKey;
        private boolean mMatchesInterruptionFilter;
        private int mRank = -1;
        private int mVisibilityOverride;

        /* JADX INFO: Access modifiers changed from: private */
        public void populate(String str, int i, boolean z, boolean z2, int i2) {
            this.mKey = str;
            this.mRank = i;
            this.mIsAmbient = z;
            this.mMatchesInterruptionFilter = z2;
            this.mVisibilityOverride = i2;
        }

        public String getKey() {
            return this.mKey;
        }

        public int getRank() {
            return this.mRank;
        }

        public int getVisibilityOverride() {
            return this.mVisibilityOverride;
        }

        public boolean isAmbient() {
            return this.mIsAmbient;
        }

        public boolean matchesInterruptionFilter() {
            return this.mMatchesInterruptionFilter;
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/service/notification/NotificationListenerService$RankingMap.class */
    public static class RankingMap implements Parcelable {
        public static final Parcelable.Creator<RankingMap> CREATOR = new Parcelable.Creator<RankingMap>() { // from class: android.service.notification.NotificationListenerService.RankingMap.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public RankingMap createFromParcel(Parcel parcel) {
                return new RankingMap((NotificationRankingUpdate) parcel.readParcelable(null));
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public RankingMap[] newArray(int i) {
                return new RankingMap[i];
            }
        };
        private ArraySet<Object> mIntercepted;
        private final NotificationRankingUpdate mRankingUpdate;
        private ArrayMap<String, Integer> mRanks;
        private ArrayMap<String, Integer> mVisibilityOverrides;

        private RankingMap(NotificationRankingUpdate notificationRankingUpdate) {
            this.mRankingUpdate = notificationRankingUpdate;
        }

        private void buildInterceptedSetLocked() {
            String[] interceptedKeys = this.mRankingUpdate.getInterceptedKeys();
            this.mIntercepted = new ArraySet<>(interceptedKeys.length);
            Collections.addAll(this.mIntercepted, interceptedKeys);
        }

        private void buildRanksLocked() {
            String[] orderedKeys = this.mRankingUpdate.getOrderedKeys();
            this.mRanks = new ArrayMap<>(orderedKeys.length);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= orderedKeys.length) {
                    return;
                }
                this.mRanks.put(orderedKeys[i2], Integer.valueOf(i2));
                i = i2 + 1;
            }
        }

        private void buildVisibilityOverridesLocked() {
            Bundle visibilityOverrides = this.mRankingUpdate.getVisibilityOverrides();
            this.mVisibilityOverrides = new ArrayMap<>(visibilityOverrides.size());
            for (String str : visibilityOverrides.keySet()) {
                this.mVisibilityOverrides.put(str, Integer.valueOf(visibilityOverrides.getInt(str)));
            }
        }

        private int getRank(String str) {
            synchronized (this) {
                if (this.mRanks == null) {
                    buildRanksLocked();
                }
            }
            Integer num = this.mRanks.get(str);
            if (num != null) {
                return num.intValue();
            }
            return -1;
        }

        private int getVisibilityOverride(String str) {
            synchronized (this) {
                if (this.mVisibilityOverrides == null) {
                    buildVisibilityOverridesLocked();
                }
            }
            Integer num = this.mVisibilityOverrides.get(str);
            if (num == null) {
                return -1000;
            }
            return num.intValue();
        }

        private boolean isAmbient(String str) {
            int rank;
            int firstAmbientIndex = this.mRankingUpdate.getFirstAmbientIndex();
            return firstAmbientIndex >= 0 && (rank = getRank(str)) >= 0 && rank >= firstAmbientIndex;
        }

        private boolean isIntercepted(String str) {
            synchronized (this) {
                if (this.mIntercepted == null) {
                    buildInterceptedSetLocked();
                }
            }
            return this.mIntercepted.contains(str);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String[] getOrderedKeys() {
            return this.mRankingUpdate.getOrderedKeys();
        }

        public boolean getRanking(String str, Ranking ranking) {
            int rank = getRank(str);
            ranking.populate(str, rank, isAmbient(str), !isIntercepted(str), getVisibilityOverride(str));
            return rank >= 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeParcelable(this.mRankingUpdate, i);
        }
    }

    static /* synthetic */ String access$100(NotificationListenerService notificationListenerService) {
        return notificationListenerService.TAG;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void applyUpdate(NotificationRankingUpdate notificationRankingUpdate) {
        this.mRankingMap = new RankingMap(notificationRankingUpdate);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v5, types: [android.content.Context] */
    public Context getContext() {
        NotificationListenerService notificationListenerService = this;
        if (this.mSystemContext != null) {
            notificationListenerService = this.mSystemContext;
        }
        return notificationListenerService;
    }

    private final INotificationManager getNotificationInterface() {
        if (this.mNoMan == null) {
            this.mNoMan = INotificationManager.Stub.asInterface(ServiceManager.getService("notification"));
        }
        return this.mNoMan;
    }

    private boolean isBound() {
        if (this.mWrapper == null) {
            Log.w(this.TAG, "Notification listener service not yet bound.");
            return false;
        }
        return true;
    }

    public final void cancelAllNotifications() {
        cancelNotifications(null);
    }

    public final void cancelNotification(String str) {
        if (isBound()) {
            try {
                getNotificationInterface().cancelNotificationsFromListener(this.mWrapper, new String[]{str});
            } catch (RemoteException e) {
                Log.v(this.TAG, "Unable to contact notification manager", e);
            }
        }
    }

    public final void cancelNotification(String str, String str2, int i) {
        if (isBound()) {
            try {
                getNotificationInterface().cancelNotificationFromListener(this.mWrapper, str, str2, i);
            } catch (RemoteException e) {
                Log.v(this.TAG, "Unable to contact notification manager", e);
            }
        }
    }

    public final void cancelNotifications(String[] strArr) {
        if (isBound()) {
            try {
                getNotificationInterface().cancelNotificationsFromListener(this.mWrapper, strArr);
            } catch (RemoteException e) {
                Log.v(this.TAG, "Unable to contact notification manager", e);
            }
        }
    }

    public StatusBarNotification[] getActiveNotifications() {
        return getActiveNotifications(null, 0);
    }

    public StatusBarNotification[] getActiveNotifications(int i) {
        return getActiveNotifications(null, i);
    }

    public StatusBarNotification[] getActiveNotifications(String[] strArr) {
        return getActiveNotifications(strArr, 0);
    }

    public StatusBarNotification[] getActiveNotifications(String[] strArr, int i) {
        if (!isBound()) {
            return null;
        }
        try {
            List list = getNotificationInterface().getActiveNotificationsFromListener(this.mWrapper, strArr, i).getList();
            int size = list.size();
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= size) {
                    return (StatusBarNotification[]) list.toArray(new StatusBarNotification[size]);
                }
                Notification.Builder.rebuild(getContext(), ((StatusBarNotification) list.get(i3)).getNotification());
                i2 = i3 + 1;
            }
        } catch (RemoteException e) {
            Log.v(this.TAG, "Unable to contact notification manager", e);
            return null;
        }
    }

    public final int getCurrentInterruptionFilter() {
        if (isBound()) {
            try {
                return getNotificationInterface().getInterruptionFilterFromListener(this.mWrapper);
            } catch (RemoteException e) {
                Log.v(this.TAG, "Unable to contact notification manager", e);
                return 0;
            }
        }
        return 0;
    }

    public final int getCurrentListenerHints() {
        if (isBound()) {
            try {
                return getNotificationInterface().getHintsFromListener(this.mWrapper);
            } catch (RemoteException e) {
                Log.v(this.TAG, "Unable to contact notification manager", e);
                return 0;
            }
        }
        return 0;
    }

    public RankingMap getCurrentRanking() {
        return this.mRankingMap;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        if (this.mWrapper == null) {
            this.mWrapper = new INotificationListenerWrapper();
        }
        return this.mWrapper;
    }

    public void onInterruptionFilterChanged(int i) {
    }

    public void onListenerConnected() {
    }

    public void onListenerHintsChanged(int i) {
    }

    public void onNotificationPosted(StatusBarNotification statusBarNotification) {
    }

    public void onNotificationPosted(StatusBarNotification statusBarNotification, RankingMap rankingMap) {
        onNotificationPosted(statusBarNotification);
    }

    public void onNotificationRankingUpdate(RankingMap rankingMap) {
    }

    public void onNotificationRemoved(StatusBarNotification statusBarNotification) {
    }

    public void onNotificationRemoved(StatusBarNotification statusBarNotification, RankingMap rankingMap) {
        onNotificationRemoved(statusBarNotification);
    }

    public void registerAsSystemService(Context context, ComponentName componentName, int i) throws RemoteException {
        this.mSystemContext = context;
        if (this.mWrapper == null) {
            this.mWrapper = new INotificationListenerWrapper();
        }
        getNotificationInterface().registerListener(this.mWrapper, componentName, i);
        this.mCurrentUser = i;
    }

    public final void requestInterruptionFilter(int i) {
        if (isBound()) {
            try {
                getNotificationInterface().requestInterruptionFilterFromListener(this.mWrapper, i);
            } catch (RemoteException e) {
                Log.v(this.TAG, "Unable to contact notification manager", e);
            }
        }
    }

    public final void requestListenerHints(int i) {
        if (isBound()) {
            try {
                getNotificationInterface().requestHintsFromListener(this.mWrapper, i);
            } catch (RemoteException e) {
                Log.v(this.TAG, "Unable to contact notification manager", e);
            }
        }
    }

    public final void setOnNotificationPostedTrim(int i) {
        if (isBound()) {
            try {
                getNotificationInterface().setOnNotificationPostedTrimFromListener(this.mWrapper, i);
            } catch (RemoteException e) {
                Log.v(this.TAG, "Unable to contact notification manager", e);
            }
        }
    }

    public void unregisterAsSystemService() throws RemoteException {
        if (this.mWrapper != null) {
            getNotificationInterface().unregisterListener(this.mWrapper, this.mCurrentUser);
        }
    }
}
