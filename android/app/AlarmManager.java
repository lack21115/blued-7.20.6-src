package android.app;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.os.UserHandle;
import android.os.WorkSource;

/* loaded from: source-9557208-dex2jar.jar:android/app/AlarmManager.class */
public class AlarmManager {
    public static final String ACTION_NEXT_ALARM_CLOCK_CHANGED = "android.app.action.NEXT_ALARM_CLOCK_CHANGED";
    public static final int ELAPSED_REALTIME = 3;
    public static final int ELAPSED_REALTIME_WAKEUP = 2;
    public static final long INTERVAL_DAY = 86400000;
    public static final long INTERVAL_FIFTEEN_MINUTES = 900000;
    public static final long INTERVAL_HALF_DAY = 43200000;
    public static final long INTERVAL_HALF_HOUR = 1800000;
    public static final long INTERVAL_HOUR = 3600000;
    public static final int RTC = 1;
    public static final int RTC_POWEROFF_WAKEUP = 4;
    public static final int RTC_WAKEUP = 0;
    private static final String TAG = "AlarmManager";
    public static final long WINDOW_EXACT = 0;
    public static final long WINDOW_HEURISTIC = -1;
    private final boolean mAlwaysExact;
    private final IAlarmManager mService;

    /* loaded from: source-9557208-dex2jar.jar:android/app/AlarmManager$AlarmClockInfo.class */
    public static final class AlarmClockInfo implements Parcelable {
        public static final Parcelable.Creator<AlarmClockInfo> CREATOR = new Parcelable.Creator<AlarmClockInfo>() { // from class: android.app.AlarmManager.AlarmClockInfo.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public AlarmClockInfo createFromParcel(Parcel parcel) {
                return new AlarmClockInfo(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public AlarmClockInfo[] newArray(int i) {
                return new AlarmClockInfo[i];
            }
        };
        private final PendingIntent mShowIntent;
        private final long mTriggerTime;

        public AlarmClockInfo(long j, PendingIntent pendingIntent) {
            this.mTriggerTime = j;
            this.mShowIntent = pendingIntent;
        }

        AlarmClockInfo(Parcel parcel) {
            this.mTriggerTime = parcel.readLong();
            this.mShowIntent = (PendingIntent) parcel.readParcelable(PendingIntent.class.getClassLoader());
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public PendingIntent getShowIntent() {
            return this.mShowIntent;
        }

        public long getTriggerTime() {
            return this.mTriggerTime;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeLong(this.mTriggerTime);
            parcel.writeParcelable(this.mShowIntent, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AlarmManager(IAlarmManager iAlarmManager, Context context) {
        this.mService = iAlarmManager;
        this.mAlwaysExact = context.getApplicationInfo().targetSdkVersion < 19;
    }

    private long legacyExactLength() {
        return this.mAlwaysExact ? 0L : -1L;
    }

    private void setImpl(int i, long j, long j2, long j3, PendingIntent pendingIntent, WorkSource workSource, AlarmClockInfo alarmClockInfo) {
        long j4 = j;
        if (j < 0) {
            j4 = 0;
        }
        try {
            this.mService.set(i, j4, j2, j3, pendingIntent, workSource, alarmClockInfo);
        } catch (RemoteException e) {
        }
    }

    public void cancel(PendingIntent pendingIntent) {
        try {
            this.mService.remove(pendingIntent);
        } catch (RemoteException e) {
        }
    }

    public AlarmClockInfo getNextAlarmClock() {
        return getNextAlarmClock(UserHandle.myUserId());
    }

    public AlarmClockInfo getNextAlarmClock(int i) {
        try {
            return this.mService.getNextAlarmClock(i);
        } catch (RemoteException e) {
            return null;
        }
    }

    public void set(int i, long j, long j2, long j3, PendingIntent pendingIntent, WorkSource workSource) {
        setImpl(i, j, j2, j3, pendingIntent, workSource, null);
    }

    public void set(int i, long j, PendingIntent pendingIntent) {
        setImpl(i, j, legacyExactLength(), 0L, pendingIntent, null, null);
    }

    public void setAlarmClock(AlarmClockInfo alarmClockInfo, PendingIntent pendingIntent) {
        setImpl(0, alarmClockInfo.getTriggerTime(), 0L, 0L, pendingIntent, null, alarmClockInfo);
    }

    public void setExact(int i, long j, PendingIntent pendingIntent) {
        setImpl(i, j, 0L, 0L, pendingIntent, null, null);
    }

    public void setInexactRepeating(int i, long j, long j2, PendingIntent pendingIntent) {
        setImpl(i, j, -1L, j2, pendingIntent, null, null);
    }

    public void setRepeating(int i, long j, long j2, PendingIntent pendingIntent) {
        setImpl(i, j, legacyExactLength(), j2, pendingIntent, null, null);
    }

    public void setTime(long j) {
        try {
            this.mService.setTime(j);
        } catch (RemoteException e) {
        }
    }

    public void setTimeZone(String str) {
        try {
            this.mService.setTimeZone(str);
        } catch (RemoteException e) {
        }
    }

    public void setWindow(int i, long j, long j2, PendingIntent pendingIntent) {
        setImpl(i, j, j2, 0L, pendingIntent, null, null);
    }
}
