package android.app;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.ConfigurationInfo;
import android.content.pm.IPackageDataObserver;
import android.content.pm.UserInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.BatteryStats;
import android.os.Bundle;
import android.os.Debug;
import android.os.Handler;
import android.os.IBinder;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.SystemProperties;
import android.os.UserHandle;
import android.text.TextUtils;
import android.util.Size;
import android.util.Slog;
import com.android.internal.R;
import com.android.internal.app.ProcessStats;
import com.android.internal.os.TransferPipe;
import com.android.internal.util.FastPrintWriter;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlSerializer;

/* loaded from: source-9557208-dex2jar.jar:android/app/ActivityManager.class */
public class ActivityManager {
    public static final int BROADCAST_FAILED_USER_STOPPED = -2;
    public static final int BROADCAST_STICKY_CANT_HAVE_PERMISSION = -1;
    public static final int BROADCAST_SUCCESS = 0;
    public static final int COMPAT_MODE_ALWAYS = -1;
    public static final int COMPAT_MODE_DISABLED = 0;
    public static final int COMPAT_MODE_ENABLED = 1;
    public static final int COMPAT_MODE_NEVER = -2;
    public static final int COMPAT_MODE_TOGGLE = 2;
    public static final int COMPAT_MODE_UNKNOWN = -3;
    public static final int INTENT_SENDER_ACTIVITY = 2;
    public static final int INTENT_SENDER_ACTIVITY_RESULT = 3;
    public static final int INTENT_SENDER_BROADCAST = 1;
    public static final int INTENT_SENDER_SERVICE = 4;
    public static final String META_HOME_ALTERNATE = "android.app.home.alternate";
    public static final int MOVE_TASK_NO_USER_ACTION = 2;
    public static final int MOVE_TASK_WITH_HOME = 1;
    public static final int PROCESS_STATE_BACKUP = 5;
    public static final int PROCESS_STATE_CACHED_ACTIVITY = 11;
    public static final int PROCESS_STATE_CACHED_ACTIVITY_CLIENT = 12;
    public static final int PROCESS_STATE_CACHED_EMPTY = 13;
    public static final int PROCESS_STATE_HEAVY_WEIGHT = 6;
    public static final int PROCESS_STATE_HOME = 9;
    public static final int PROCESS_STATE_IMPORTANT_BACKGROUND = 4;
    public static final int PROCESS_STATE_IMPORTANT_FOREGROUND = 3;
    public static final int PROCESS_STATE_LAST_ACTIVITY = 10;
    public static final int PROCESS_STATE_NONEXISTENT = -1;
    public static final int PROCESS_STATE_PERSISTENT = 0;
    public static final int PROCESS_STATE_PERSISTENT_UI = 1;
    public static final int PROCESS_STATE_RECEIVER = 8;
    public static final int PROCESS_STATE_SERVICE = 7;
    public static final int PROCESS_STATE_TOP = 2;
    public static final int RECENT_IGNORE_HOME_STACK_TASKS = 8;
    public static final int RECENT_IGNORE_UNAVAILABLE = 2;
    public static final int RECENT_INCLUDE_PROFILES = 4;
    public static final int RECENT_WITH_EXCLUDED = 1;
    public static final int START_CANCELED = -6;
    public static final int START_CLASS_NOT_FOUND = -2;
    public static final int START_DELIVERED_TO_TOP = 3;
    public static final int START_FLAG_DEBUG = 2;
    public static final int START_FLAG_ONLY_IF_NEEDED = 1;
    public static final int START_FLAG_OPENGL_TRACES = 4;
    public static final int START_FORWARD_AND_REQUEST_CONFLICT = -3;
    public static final int START_INTENT_NOT_RESOLVED = -1;
    public static final int START_NOT_ACTIVITY = -5;
    public static final int START_NOT_VOICE_COMPATIBLE = -7;
    public static final int START_PERMISSION_DENIED = -4;
    public static final int START_RETURN_INTENT_TO_CALLER = 1;
    public static final int START_RETURN_LOCK_TASK_MODE_VIOLATION = 5;
    public static final int START_SUCCESS = 0;
    public static final int START_SWITCHES_CANCELED = 4;
    public static final int START_TASK_TO_FRONT = 2;
    public static final int USER_OP_IS_CURRENT = -2;
    public static final int USER_OP_SUCCESS = 0;
    public static final int USER_OP_UNKNOWN_USER = -1;
    Point mAppTaskThumbnailSize;
    private final Context mContext;
    private final Handler mHandler;
    private static String TAG = "ActivityManager";
    private static boolean localLOGV = false;
    private static int gMaxRecentTasks = -1;

    /* loaded from: source-9557208-dex2jar.jar:android/app/ActivityManager$AppTask.class */
    public static class AppTask {
        private IAppTask mAppTaskImpl;

        public AppTask(IAppTask iAppTask) {
            this.mAppTaskImpl = iAppTask;
        }

        public void finishAndRemoveTask() {
            try {
                this.mAppTaskImpl.finishAndRemoveTask();
            } catch (RemoteException e) {
                Slog.e(ActivityManager.TAG, "Invalid AppTask", e);
            }
        }

        public RecentTaskInfo getTaskInfo() {
            try {
                return this.mAppTaskImpl.getTaskInfo();
            } catch (RemoteException e) {
                Slog.e(ActivityManager.TAG, "Invalid AppTask", e);
                return null;
            }
        }

        public void moveToFront() {
            try {
                this.mAppTaskImpl.moveToFront();
            } catch (RemoteException e) {
                Slog.e(ActivityManager.TAG, "Invalid AppTask", e);
            }
        }

        public void setExcludeFromRecents(boolean z) {
            try {
                this.mAppTaskImpl.setExcludeFromRecents(z);
            } catch (RemoteException e) {
                Slog.e(ActivityManager.TAG, "Invalid AppTask", e);
            }
        }

        public void startActivity(Context context, Intent intent, Bundle bundle) {
            ActivityThread currentActivityThread = ActivityThread.currentActivityThread();
            currentActivityThread.getInstrumentation().execStartActivityFromAppTask(context, currentActivityThread.getApplicationThread(), this.mAppTaskImpl, intent, bundle);
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/app/ActivityManager$MemoryInfo.class */
    public static class MemoryInfo implements Parcelable {
        public static final Parcelable.Creator<MemoryInfo> CREATOR = new Parcelable.Creator<MemoryInfo>() { // from class: android.app.ActivityManager.MemoryInfo.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public MemoryInfo createFromParcel(Parcel parcel) {
                return new MemoryInfo(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public MemoryInfo[] newArray(int i) {
                return new MemoryInfo[i];
            }
        };
        public long availMem;
        public long foregroundAppThreshold;
        public long hiddenAppThreshold;
        public boolean lowMemory;
        public long secondaryServerThreshold;
        public long threshold;
        public long totalMem;
        public long visibleAppThreshold;

        public MemoryInfo() {
        }

        private MemoryInfo(Parcel parcel) {
            readFromParcel(parcel);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public void readFromParcel(Parcel parcel) {
            this.availMem = parcel.readLong();
            this.totalMem = parcel.readLong();
            this.threshold = parcel.readLong();
            this.lowMemory = parcel.readInt() != 0;
            this.hiddenAppThreshold = parcel.readLong();
            this.secondaryServerThreshold = parcel.readLong();
            this.visibleAppThreshold = parcel.readLong();
            this.foregroundAppThreshold = parcel.readLong();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeLong(this.availMem);
            parcel.writeLong(this.totalMem);
            parcel.writeLong(this.threshold);
            parcel.writeInt(this.lowMemory ? 1 : 0);
            parcel.writeLong(this.hiddenAppThreshold);
            parcel.writeLong(this.secondaryServerThreshold);
            parcel.writeLong(this.visibleAppThreshold);
            parcel.writeLong(this.foregroundAppThreshold);
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/app/ActivityManager$ProcessErrorStateInfo.class */
    public static class ProcessErrorStateInfo implements Parcelable {
        public static final int CRASHED = 1;
        public static final Parcelable.Creator<ProcessErrorStateInfo> CREATOR = new Parcelable.Creator<ProcessErrorStateInfo>() { // from class: android.app.ActivityManager.ProcessErrorStateInfo.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public ProcessErrorStateInfo createFromParcel(Parcel parcel) {
                return new ProcessErrorStateInfo(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public ProcessErrorStateInfo[] newArray(int i) {
                return new ProcessErrorStateInfo[i];
            }
        };
        public static final int NOT_RESPONDING = 2;
        public static final int NO_ERROR = 0;
        public int condition;
        public byte[] crashData;
        public String longMsg;
        public int pid;
        public String processName;
        public String shortMsg;
        public String stackTrace;
        public String tag;
        public int uid;

        public ProcessErrorStateInfo() {
            this.crashData = null;
        }

        private ProcessErrorStateInfo(Parcel parcel) {
            this.crashData = null;
            readFromParcel(parcel);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public void readFromParcel(Parcel parcel) {
            this.condition = parcel.readInt();
            this.processName = parcel.readString();
            this.pid = parcel.readInt();
            this.uid = parcel.readInt();
            this.tag = parcel.readString();
            this.shortMsg = parcel.readString();
            this.longMsg = parcel.readString();
            this.stackTrace = parcel.readString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.condition);
            parcel.writeString(this.processName);
            parcel.writeInt(this.pid);
            parcel.writeInt(this.uid);
            parcel.writeString(this.tag);
            parcel.writeString(this.shortMsg);
            parcel.writeString(this.longMsg);
            parcel.writeString(this.stackTrace);
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/app/ActivityManager$RecentTaskInfo.class */
    public static class RecentTaskInfo implements Parcelable {
        public static final Parcelable.Creator<RecentTaskInfo> CREATOR = new Parcelable.Creator<RecentTaskInfo>() { // from class: android.app.ActivityManager.RecentTaskInfo.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public RecentTaskInfo createFromParcel(Parcel parcel) {
                return new RecentTaskInfo(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public RecentTaskInfo[] newArray(int i) {
                return new RecentTaskInfo[i];
            }
        };
        public int affiliatedTaskColor;
        public int affiliatedTaskId;
        public Intent baseIntent;
        public CharSequence description;
        public long firstActiveTime;
        public int id;
        public long lastActiveTime;
        public ComponentName origActivity;
        public int persistentId;
        public int stackId;
        public TaskDescription taskDescription;
        public int userId;

        public RecentTaskInfo() {
        }

        private RecentTaskInfo(Parcel parcel) {
            readFromParcel(parcel);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public void readFromParcel(Parcel parcel) {
            this.id = parcel.readInt();
            this.persistentId = parcel.readInt();
            this.baseIntent = parcel.readInt() > 0 ? Intent.CREATOR.createFromParcel(parcel) : null;
            this.origActivity = ComponentName.readFromParcel(parcel);
            this.description = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.taskDescription = parcel.readInt() > 0 ? TaskDescription.CREATOR.createFromParcel(parcel) : null;
            this.stackId = parcel.readInt();
            this.userId = parcel.readInt();
            this.firstActiveTime = parcel.readLong();
            this.lastActiveTime = parcel.readLong();
            this.affiliatedTaskId = parcel.readInt();
            this.affiliatedTaskColor = parcel.readInt();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.id);
            parcel.writeInt(this.persistentId);
            if (this.baseIntent != null) {
                parcel.writeInt(1);
                this.baseIntent.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            ComponentName.writeToParcel(this.origActivity, parcel);
            TextUtils.writeToParcel(this.description, parcel, 1);
            if (this.taskDescription != null) {
                parcel.writeInt(1);
                this.taskDescription.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            parcel.writeInt(this.stackId);
            parcel.writeInt(this.userId);
            parcel.writeLong(this.firstActiveTime);
            parcel.writeLong(this.lastActiveTime);
            parcel.writeInt(this.affiliatedTaskId);
            parcel.writeInt(this.affiliatedTaskColor);
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/app/ActivityManager$RunningAppProcessInfo.class */
    public static class RunningAppProcessInfo implements Parcelable {
        public static final Parcelable.Creator<RunningAppProcessInfo> CREATOR = new Parcelable.Creator<RunningAppProcessInfo>() { // from class: android.app.ActivityManager.RunningAppProcessInfo.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public RunningAppProcessInfo createFromParcel(Parcel parcel) {
                return new RunningAppProcessInfo(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public RunningAppProcessInfo[] newArray(int i) {
                return new RunningAppProcessInfo[i];
            }
        };
        public static final int FLAG_CANT_SAVE_STATE = 1;
        public static final int FLAG_HAS_ACTIVITIES = 4;
        public static final int FLAG_PERSISTENT = 2;
        public static final int IMPORTANCE_BACKGROUND = 400;
        public static final int IMPORTANCE_CANT_SAVE_STATE = 170;
        public static final int IMPORTANCE_EMPTY = 500;
        public static final int IMPORTANCE_FOREGROUND = 100;
        public static final int IMPORTANCE_GONE = 1000;
        public static final int IMPORTANCE_PERCEPTIBLE = 130;
        public static final int IMPORTANCE_SERVICE = 300;
        public static final int IMPORTANCE_VISIBLE = 200;
        public static final int REASON_PROVIDER_IN_USE = 1;
        public static final int REASON_SERVICE_IN_USE = 2;
        public static final int REASON_UNKNOWN = 0;
        public int flags;
        public int importance;
        public int importanceReasonCode;
        public ComponentName importanceReasonComponent;
        public int importanceReasonImportance;
        public int importanceReasonPid;
        public int lastTrimLevel;
        public int lru;
        public int pid;
        public String[] pkgList;
        public String processName;
        public int processState;
        public int uid;

        public RunningAppProcessInfo() {
            this.importance = 100;
            this.importanceReasonCode = 0;
            this.processState = 3;
        }

        private RunningAppProcessInfo(Parcel parcel) {
            readFromParcel(parcel);
        }

        public RunningAppProcessInfo(String str, int i, String[] strArr) {
            this.processName = str;
            this.pid = i;
            this.pkgList = strArr;
        }

        public static int procStateToImportance(int i) {
            if (i >= 9) {
                return 400;
            }
            if (i >= 7) {
                return 300;
            }
            if (i > 6) {
                return 170;
            }
            if (i >= 4) {
                return 130;
            }
            return i >= 3 ? 200 : 100;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public void readFromParcel(Parcel parcel) {
            this.processName = parcel.readString();
            this.pid = parcel.readInt();
            this.uid = parcel.readInt();
            this.pkgList = parcel.readStringArray();
            this.flags = parcel.readInt();
            this.lastTrimLevel = parcel.readInt();
            this.importance = parcel.readInt();
            this.lru = parcel.readInt();
            this.importanceReasonCode = parcel.readInt();
            this.importanceReasonPid = parcel.readInt();
            this.importanceReasonComponent = ComponentName.readFromParcel(parcel);
            this.importanceReasonImportance = parcel.readInt();
            this.processState = parcel.readInt();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.processName);
            parcel.writeInt(this.pid);
            parcel.writeInt(this.uid);
            parcel.writeStringArray(this.pkgList);
            parcel.writeInt(this.flags);
            parcel.writeInt(this.lastTrimLevel);
            parcel.writeInt(this.importance);
            parcel.writeInt(this.lru);
            parcel.writeInt(this.importanceReasonCode);
            parcel.writeInt(this.importanceReasonPid);
            ComponentName.writeToParcel(this.importanceReasonComponent, parcel);
            parcel.writeInt(this.importanceReasonImportance);
            parcel.writeInt(this.processState);
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/app/ActivityManager$RunningServiceInfo.class */
    public static class RunningServiceInfo implements Parcelable {
        public static final Parcelable.Creator<RunningServiceInfo> CREATOR = new Parcelable.Creator<RunningServiceInfo>() { // from class: android.app.ActivityManager.RunningServiceInfo.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public RunningServiceInfo createFromParcel(Parcel parcel) {
                return new RunningServiceInfo(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public RunningServiceInfo[] newArray(int i) {
                return new RunningServiceInfo[i];
            }
        };
        public static final int FLAG_FOREGROUND = 2;
        public static final int FLAG_PERSISTENT_PROCESS = 8;
        public static final int FLAG_STARTED = 1;
        public static final int FLAG_SYSTEM_PROCESS = 4;
        public long activeSince;
        public int clientCount;
        public int clientLabel;
        public String clientPackage;
        public int crashCount;
        public int flags;
        public boolean foreground;
        public long lastActivityTime;
        public int pid;
        public String process;
        public long restarting;
        public ComponentName service;
        public boolean started;
        public int uid;

        public RunningServiceInfo() {
        }

        private RunningServiceInfo(Parcel parcel) {
            readFromParcel(parcel);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public void readFromParcel(Parcel parcel) {
            this.service = ComponentName.readFromParcel(parcel);
            this.pid = parcel.readInt();
            this.uid = parcel.readInt();
            this.process = parcel.readString();
            this.foreground = parcel.readInt() != 0;
            this.activeSince = parcel.readLong();
            this.started = parcel.readInt() != 0;
            this.clientCount = parcel.readInt();
            this.crashCount = parcel.readInt();
            this.lastActivityTime = parcel.readLong();
            this.restarting = parcel.readLong();
            this.flags = parcel.readInt();
            this.clientPackage = parcel.readString();
            this.clientLabel = parcel.readInt();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            ComponentName.writeToParcel(this.service, parcel);
            parcel.writeInt(this.pid);
            parcel.writeInt(this.uid);
            parcel.writeString(this.process);
            parcel.writeInt(this.foreground ? 1 : 0);
            parcel.writeLong(this.activeSince);
            parcel.writeInt(this.started ? 1 : 0);
            parcel.writeInt(this.clientCount);
            parcel.writeInt(this.crashCount);
            parcel.writeLong(this.lastActivityTime);
            parcel.writeLong(this.restarting);
            parcel.writeInt(this.flags);
            parcel.writeString(this.clientPackage);
            parcel.writeInt(this.clientLabel);
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/app/ActivityManager$RunningTaskInfo.class */
    public static class RunningTaskInfo implements Parcelable {
        public static final Parcelable.Creator<RunningTaskInfo> CREATOR = new Parcelable.Creator<RunningTaskInfo>() { // from class: android.app.ActivityManager.RunningTaskInfo.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public RunningTaskInfo createFromParcel(Parcel parcel) {
                return new RunningTaskInfo(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public RunningTaskInfo[] newArray(int i) {
                return new RunningTaskInfo[i];
            }
        };
        public ComponentName baseActivity;
        public CharSequence description;
        public int id;
        public long lastActiveTime;
        public int numActivities;
        public int numRunning;
        public Bitmap thumbnail;
        public ComponentName topActivity;

        public RunningTaskInfo() {
        }

        private RunningTaskInfo(Parcel parcel) {
            readFromParcel(parcel);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public void readFromParcel(Parcel parcel) {
            this.id = parcel.readInt();
            this.baseActivity = ComponentName.readFromParcel(parcel);
            this.topActivity = ComponentName.readFromParcel(parcel);
            if (parcel.readInt() != 0) {
                this.thumbnail = Bitmap.CREATOR.createFromParcel(parcel);
            } else {
                this.thumbnail = null;
            }
            this.description = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.numActivities = parcel.readInt();
            this.numRunning = parcel.readInt();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.id);
            ComponentName.writeToParcel(this.baseActivity, parcel);
            ComponentName.writeToParcel(this.topActivity, parcel);
            if (this.thumbnail != null) {
                parcel.writeInt(1);
                this.thumbnail.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            TextUtils.writeToParcel(this.description, parcel, 1);
            parcel.writeInt(this.numActivities);
            parcel.writeInt(this.numRunning);
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/app/ActivityManager$StackInfo.class */
    public static class StackInfo implements Parcelable {
        public static final Parcelable.Creator<StackInfo> CREATOR = new Parcelable.Creator<StackInfo>() { // from class: android.app.ActivityManager.StackInfo.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public StackInfo createFromParcel(Parcel parcel) {
                return new StackInfo(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public StackInfo[] newArray(int i) {
                return new StackInfo[i];
            }
        };
        public Rect bounds;
        public int displayId;
        public int stackId;
        public int[] taskIds;
        public String[] taskNames;

        public StackInfo() {
            this.bounds = new Rect();
        }

        private StackInfo(Parcel parcel) {
            this.bounds = new Rect();
            readFromParcel(parcel);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public void readFromParcel(Parcel parcel) {
            this.stackId = parcel.readInt();
            this.bounds = new Rect(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt());
            this.taskIds = parcel.createIntArray();
            this.taskNames = parcel.createStringArray();
            this.displayId = parcel.readInt();
        }

        public String toString() {
            return toString("");
        }

        public String toString(String str) {
            StringBuilder sb = new StringBuilder(256);
            sb.append(str);
            sb.append("Stack id=");
            sb.append(this.stackId);
            sb.append(" bounds=");
            sb.append(this.bounds.toShortString());
            sb.append(" displayId=");
            sb.append(this.displayId);
            sb.append("\n");
            String str2 = str + "  ";
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.taskIds.length) {
                    return sb.toString();
                }
                sb.append(str2);
                sb.append("taskId=");
                sb.append(this.taskIds[i2]);
                sb.append(": ");
                sb.append(this.taskNames[i2]);
                sb.append("\n");
                i = i2 + 1;
            }
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.stackId);
            parcel.writeInt(this.bounds.left);
            parcel.writeInt(this.bounds.top);
            parcel.writeInt(this.bounds.right);
            parcel.writeInt(this.bounds.bottom);
            parcel.writeIntArray(this.taskIds);
            parcel.writeStringArray(this.taskNames);
            parcel.writeInt(this.displayId);
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/app/ActivityManager$TaskDescription.class */
    public static class TaskDescription implements Parcelable {
        private static final String ATTR_TASKDESCRIPTIONCOLOR = "task_description_color";
        private static final String ATTR_TASKDESCRIPTIONICONFILENAME = "task_description_icon_filename";
        private static final String ATTR_TASKDESCRIPTIONLABEL = "task_description_label";
        public static final String ATTR_TASKDESCRIPTION_PREFIX = "task_description_";
        public static final Parcelable.Creator<TaskDescription> CREATOR = new Parcelable.Creator<TaskDescription>() { // from class: android.app.ActivityManager.TaskDescription.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public TaskDescription createFromParcel(Parcel parcel) {
                return new TaskDescription(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public TaskDescription[] newArray(int i) {
                return new TaskDescription[i];
            }
        };
        private int mColorPrimary;
        private Bitmap mIcon;
        private String mIconFilename;
        private String mLabel;

        public TaskDescription() {
            this((String) null, (Bitmap) null, 0);
        }

        public TaskDescription(TaskDescription taskDescription) {
            this.mLabel = taskDescription.mLabel;
            this.mIcon = taskDescription.mIcon;
            this.mColorPrimary = taskDescription.mColorPrimary;
            this.mIconFilename = taskDescription.mIconFilename;
        }

        private TaskDescription(Parcel parcel) {
            readFromParcel(parcel);
        }

        public TaskDescription(String str) {
            this(str, (Bitmap) null, 0);
        }

        public TaskDescription(String str, int i, String str2) {
            this(str, (Bitmap) null, i);
            this.mIconFilename = str2;
        }

        public TaskDescription(String str, Bitmap bitmap) {
            this(str, bitmap, 0);
        }

        public TaskDescription(String str, Bitmap bitmap, int i) {
            if (i != 0 && Color.alpha(i) != 255) {
                throw new RuntimeException("A TaskDescription's primary color should be opaque");
            }
            this.mLabel = str;
            this.mIcon = bitmap;
            this.mColorPrimary = i;
        }

        public static Bitmap loadTaskDescriptionIcon(String str) {
            if (str != null) {
                try {
                    return ActivityManagerNative.getDefault().getTaskDescriptionIcon(str);
                } catch (RemoteException e) {
                    return null;
                }
            }
            return null;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public Bitmap getIcon() {
            return this.mIcon != null ? this.mIcon : loadTaskDescriptionIcon(this.mIconFilename);
        }

        public String getIconFilename() {
            return this.mIconFilename;
        }

        public Bitmap getInMemoryIcon() {
            return this.mIcon;
        }

        public String getLabel() {
            return this.mLabel;
        }

        public int getPrimaryColor() {
            return this.mColorPrimary;
        }

        public void readFromParcel(Parcel parcel) {
            this.mLabel = parcel.readInt() > 0 ? parcel.readString() : null;
            this.mIcon = parcel.readInt() > 0 ? Bitmap.CREATOR.createFromParcel(parcel) : null;
            this.mColorPrimary = parcel.readInt();
            String str = null;
            if (parcel.readInt() > 0) {
                str = parcel.readString();
            }
            this.mIconFilename = str;
        }

        public void restoreFromXml(String str, String str2) {
            if (ATTR_TASKDESCRIPTIONLABEL.equals(str)) {
                setLabel(str2);
            } else if (ATTR_TASKDESCRIPTIONCOLOR.equals(str)) {
                setPrimaryColor((int) Long.parseLong(str2, 16));
            } else if (ATTR_TASKDESCRIPTIONICONFILENAME.equals(str)) {
                setIconFilename(str2);
            }
        }

        public void saveToXml(XmlSerializer xmlSerializer) throws IOException {
            if (this.mLabel != null) {
                xmlSerializer.attribute(null, ATTR_TASKDESCRIPTIONLABEL, this.mLabel);
            }
            if (this.mColorPrimary != 0) {
                xmlSerializer.attribute(null, ATTR_TASKDESCRIPTIONCOLOR, Integer.toHexString(this.mColorPrimary));
            }
            if (this.mIconFilename != null) {
                xmlSerializer.attribute(null, ATTR_TASKDESCRIPTIONICONFILENAME, this.mIconFilename);
            }
        }

        public void setIcon(Bitmap bitmap) {
            this.mIcon = bitmap;
        }

        public void setIconFilename(String str) {
            this.mIconFilename = str;
            this.mIcon = null;
        }

        public void setLabel(String str) {
            this.mLabel = str;
        }

        public void setPrimaryColor(int i) {
            if (i != 0 && Color.alpha(i) != 255) {
                throw new RuntimeException("A TaskDescription's primary color should be opaque");
            }
            this.mColorPrimary = i;
        }

        public String toString() {
            return "TaskDescription Label: " + this.mLabel + " Icon: " + this.mIcon + " colorPrimary: " + this.mColorPrimary;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            if (this.mLabel == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                parcel.writeString(this.mLabel);
            }
            if (this.mIcon == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                this.mIcon.writeToParcel(parcel, 0);
            }
            parcel.writeInt(this.mColorPrimary);
            if (this.mIconFilename == null) {
                parcel.writeInt(0);
                return;
            }
            parcel.writeInt(1);
            parcel.writeString(this.mIconFilename);
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/app/ActivityManager$TaskThumbnail.class */
    public static class TaskThumbnail implements Parcelable {
        public static final Parcelable.Creator<TaskThumbnail> CREATOR = new Parcelable.Creator<TaskThumbnail>() { // from class: android.app.ActivityManager.TaskThumbnail.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public TaskThumbnail createFromParcel(Parcel parcel) {
                return new TaskThumbnail(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public TaskThumbnail[] newArray(int i) {
                return new TaskThumbnail[i];
            }
        };
        public Bitmap mainThumbnail;
        public ParcelFileDescriptor thumbnailFileDescriptor;

        public TaskThumbnail() {
        }

        private TaskThumbnail(Parcel parcel) {
            readFromParcel(parcel);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            if (this.thumbnailFileDescriptor != null) {
                return this.thumbnailFileDescriptor.describeContents();
            }
            return 0;
        }

        public void readFromParcel(Parcel parcel) {
            if (parcel.readInt() != 0) {
                this.mainThumbnail = Bitmap.CREATOR.createFromParcel(parcel);
            } else {
                this.mainThumbnail = null;
            }
            if (parcel.readInt() != 0) {
                this.thumbnailFileDescriptor = ParcelFileDescriptor.CREATOR.createFromParcel(parcel);
            } else {
                this.thumbnailFileDescriptor = null;
            }
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            if (this.mainThumbnail != null) {
                parcel.writeInt(1);
                this.mainThumbnail.writeToParcel(parcel, i);
            } else {
                parcel.writeInt(0);
            }
            if (this.thumbnailFileDescriptor == null) {
                parcel.writeInt(0);
                return;
            }
            parcel.writeInt(1);
            this.thumbnailFileDescriptor.writeToParcel(parcel, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ActivityManager(Context context, Handler handler) {
        this.mContext = context;
        this.mHandler = handler;
    }

    public static int checkComponentPermission(String str, int i, int i2, boolean z) {
        int i3;
        if (i == 0 || i == 1000) {
            i3 = 0;
        } else {
            i3 = -1;
            if (!UserHandle.isIsolated(i)) {
                if (i2 >= 0 && UserHandle.isSameApp(i, i2)) {
                    return 0;
                }
                i3 = -1;
                if (z) {
                    if (str == null) {
                        return 0;
                    }
                    try {
                        return AppGlobals.getPackageManager().checkUidPermission(str, i);
                    } catch (RemoteException e) {
                        Slog.e(TAG, "PackageManager is dead?!?", e);
                        return -1;
                    }
                }
            }
        }
        return i3;
    }

    public static int checkUidPermission(String str, int i) {
        try {
            return AppGlobals.getPackageManager().checkUidPermission(str, i);
        } catch (RemoteException e) {
            Slog.e(TAG, "PackageManager is dead?!?", e);
            return -1;
        }
    }

    public static void dumpPackageStateStatic(FileDescriptor fileDescriptor, String str) {
        FastPrintWriter fastPrintWriter = new FastPrintWriter(new FileOutputStream(fileDescriptor));
        dumpService(fastPrintWriter, fileDescriptor, "package", new String[]{str});
        fastPrintWriter.println();
        dumpService(fastPrintWriter, fileDescriptor, "activity", new String[]{"-a", "package", str});
        fastPrintWriter.println();
        dumpService(fastPrintWriter, fileDescriptor, "meminfo", new String[]{"--local", "--package", str});
        fastPrintWriter.println();
        dumpService(fastPrintWriter, fileDescriptor, ProcessStats.SERVICE_NAME, new String[]{str});
        fastPrintWriter.println();
        dumpService(fastPrintWriter, fileDescriptor, Context.USAGE_STATS_SERVICE, new String[]{"--packages", str});
        fastPrintWriter.println();
        dumpService(fastPrintWriter, fileDescriptor, BatteryStats.SERVICE_NAME, new String[]{str});
        fastPrintWriter.flush();
    }

    private static void dumpService(PrintWriter printWriter, FileDescriptor fileDescriptor, String str, String[] strArr) {
        TransferPipe transferPipe;
        printWriter.print("DUMP OF SERVICE ");
        printWriter.print(str);
        printWriter.println(":");
        IBinder checkService = ServiceManager.checkService(str);
        if (checkService == null) {
            printWriter.println("  (Service not found)");
            return;
        }
        TransferPipe transferPipe2 = null;
        try {
            printWriter.flush();
            transferPipe = new TransferPipe();
        } catch (Throwable th) {
            th = th;
        }
        try {
            transferPipe.setBufferPrefix("  ");
            checkService.dumpAsync(transferPipe.getWriteFd().getFileDescriptor(), strArr);
            transferPipe.go(fileDescriptor, 10000L);
        } catch (Throwable th2) {
            th = th2;
            transferPipe2 = transferPipe;
            if (transferPipe2 != null) {
                transferPipe2.kill();
            }
            printWriter.println("Failure dumping service:");
            th.printStackTrace(printWriter);
        }
    }

    private void ensureAppTaskThumbnailSizeLocked() {
        if (this.mAppTaskThumbnailSize == null) {
            try {
                this.mAppTaskThumbnailSize = ActivityManagerNative.getDefault().getAppTaskThumbnailSize();
            } catch (RemoteException e) {
                throw new IllegalStateException("System dead?", e);
            }
        }
    }

    public static int getCurrentUser() {
        int i = 0;
        try {
            UserInfo currentUser = ActivityManagerNative.getDefault().getCurrentUser();
            if (currentUser != null) {
                i = currentUser.id;
            }
            return i;
        } catch (RemoteException e) {
            return 0;
        }
    }

    public static int getDefaultAppRecentsLimitStatic() {
        return getMaxRecentTasksStatic() / 6;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int getLauncherLargeIconSizeInner(Context context) {
        Resources resources = context.getResources();
        int dimensionPixelSize = resources.getDimensionPixelSize(17104896);
        if (resources.getConfiguration().smallestScreenWidthDp < 600) {
            return dimensionPixelSize;
        }
        switch (resources.getDisplayMetrics().densityDpi) {
            case 120:
                return (dimensionPixelSize * 160) / 120;
            case 160:
                return (dimensionPixelSize * 240) / 160;
            case 213:
                return (dimensionPixelSize * 320) / 240;
            case 240:
                return (dimensionPixelSize * 320) / 240;
            case 320:
                return (dimensionPixelSize * 480) / 320;
            case 480:
                return ((dimensionPixelSize * 320) * 2) / 480;
            default:
                return (int) ((dimensionPixelSize * 1.5f) + 0.5f);
        }
    }

    public static int getMaxAppRecentsLimitStatic() {
        return getMaxRecentTasksStatic() / 2;
    }

    public static int getMaxRecentTasksStatic() {
        if (gMaxRecentTasks < 0) {
            int i = isLowRamDeviceStatic() ? 50 : 100;
            gMaxRecentTasks = i;
            return i;
        }
        return gMaxRecentTasks;
    }

    public static void getMyMemoryState(RunningAppProcessInfo runningAppProcessInfo) {
        try {
            ActivityManagerNative.getDefault().getMyMemoryState(runningAppProcessInfo);
        } catch (RemoteException e) {
        }
    }

    public static int handleIncomingUser(int i, int i2, int i3, boolean z, boolean z2, String str, String str2) {
        if (UserHandle.getUserId(i2) == i3) {
            return i3;
        }
        try {
            return ActivityManagerNative.getDefault().handleIncomingUser(i, i2, i3, z, z2, str, str2);
        } catch (RemoteException e) {
            throw new SecurityException("Failed calling activity manager", e);
        }
    }

    public static boolean isForcedHighEndGfx() {
        return SystemProperties.getBoolean("persist.sys.force_highendgfx", false);
    }

    public static boolean isHighEndGfx() {
        return !(isLowRamDeviceStatic() || Resources.getSystem().getBoolean(R.bool.config_avoidGfxAccel)) || isForcedHighEndGfx();
    }

    public static boolean isLowRamDeviceStatic() {
        return "true".equals(SystemProperties.get("ro.config.low_ram", "false"));
    }

    public static boolean isRunningInTestHarness() {
        return SystemProperties.getBoolean("ro.test_harness", false);
    }

    public static boolean isUserAMonkey() {
        try {
            return ActivityManagerNative.getDefault().isUserAMonkey();
        } catch (RemoteException e) {
            return false;
        }
    }

    public static int staticGetLargeMemoryClass() {
        String str = SystemProperties.get("dalvik.vm.heapsize", "16m");
        return Integer.parseInt(str.substring(0, str.length() - 1));
    }

    public static int staticGetMemoryClass() {
        String str = SystemProperties.get("dalvik.vm.heapgrowthlimit", "");
        return (str == null || "".equals(str)) ? staticGetLargeMemoryClass() : Integer.parseInt(str.substring(0, str.length() - 1));
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0031, code lost:
        if (r0 != r0.y) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int addAppTask(android.app.Activity r7, android.content.Intent r8, android.app.ActivityManager.TaskDescription r9, android.graphics.Bitmap r10) {
        /*
            Method dump skipped, instructions count: 269
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.app.ActivityManager.addAppTask(android.app.Activity, android.content.Intent, android.app.ActivityManager$TaskDescription, android.graphics.Bitmap):int");
    }

    public boolean clearApplicationUserData() {
        return clearApplicationUserData(this.mContext.getPackageName(), null);
    }

    public boolean clearApplicationUserData(String str, IPackageDataObserver iPackageDataObserver) {
        try {
            return ActivityManagerNative.getDefault().clearApplicationUserData(str, iPackageDataObserver, UserHandle.myUserId());
        } catch (RemoteException e) {
            return false;
        }
    }

    public void dumpPackageState(FileDescriptor fileDescriptor, String str) {
        dumpPackageStateStatic(fileDescriptor, str);
    }

    public void forceStopPackage(String str) {
        forceStopPackageAsUser(str, UserHandle.myUserId());
    }

    public void forceStopPackageAsUser(String str, int i) {
        try {
            ActivityManagerNative.getDefault().forceStopPackage(str, i);
        } catch (RemoteException e) {
        }
    }

    public Size getAppTaskThumbnailSize() {
        Size size;
        synchronized (this) {
            ensureAppTaskThumbnailSizeLocked();
            size = new Size(this.mAppTaskThumbnailSize.x, this.mAppTaskThumbnailSize.y);
        }
        return size;
    }

    public List<AppTask> getAppTasks() {
        ArrayList arrayList;
        ArrayList arrayList2 = new ArrayList();
        try {
            List<IAppTask> appTasks = ActivityManagerNative.getDefault().getAppTasks(this.mContext.getPackageName());
            int size = appTasks.size();
            int i = 0;
            while (true) {
                int i2 = i;
                arrayList = arrayList2;
                if (i2 >= size) {
                    break;
                }
                arrayList2.add(new AppTask(appTasks.get(i2)));
                i = i2 + 1;
            }
        } catch (RemoteException e) {
            arrayList = null;
        }
        return arrayList;
    }

    public Configuration getConfiguration() {
        try {
            return ActivityManagerNative.getDefault().getConfiguration();
        } catch (RemoteException e) {
            return null;
        }
    }

    public ConfigurationInfo getDeviceConfigurationInfo() {
        try {
            return ActivityManagerNative.getDefault().getDeviceConfigurationInfo();
        } catch (RemoteException e) {
            return null;
        }
    }

    public int getFrontActivityScreenCompatMode() {
        try {
            return ActivityManagerNative.getDefault().getFrontActivityScreenCompatMode();
        } catch (RemoteException e) {
            return 0;
        }
    }

    public int getLargeMemoryClass() {
        return staticGetLargeMemoryClass();
    }

    public int getLauncherLargeIconDensity() {
        Resources resources = this.mContext.getResources();
        int i = resources.getDisplayMetrics().densityDpi;
        if (resources.getConfiguration().smallestScreenWidthDp < 600) {
            return i;
        }
        switch (i) {
            case 120:
                return 160;
            case 160:
                return 240;
            case 213:
                return 320;
            case 240:
                return 320;
            case 320:
                return 480;
            case 480:
                return 640;
            default:
                return (int) ((i * 1.5f) + 0.5f);
        }
    }

    public int getLauncherLargeIconSize() {
        return getLauncherLargeIconSizeInner(this.mContext);
    }

    public int getMemoryClass() {
        return staticGetMemoryClass();
    }

    public void getMemoryInfo(MemoryInfo memoryInfo) {
        try {
            ActivityManagerNative.getDefault().getMemoryInfo(memoryInfo);
        } catch (RemoteException e) {
        }
    }

    public boolean getPackageAskScreenCompat(String str) {
        try {
            return ActivityManagerNative.getDefault().getPackageAskScreenCompat(str);
        } catch (RemoteException e) {
            return false;
        }
    }

    public int getPackageScreenCompatMode(String str) {
        try {
            return ActivityManagerNative.getDefault().getPackageScreenCompatMode(str);
        } catch (RemoteException e) {
            return 0;
        }
    }

    public Debug.MemoryInfo[] getProcessMemoryInfo(int[] iArr) {
        try {
            return ActivityManagerNative.getDefault().getProcessMemoryInfo(iArr);
        } catch (RemoteException e) {
            return null;
        }
    }

    public List<ProcessErrorStateInfo> getProcessesInErrorState() {
        try {
            return ActivityManagerNative.getDefault().getProcessesInErrorState();
        } catch (RemoteException e) {
            return null;
        }
    }

    @Deprecated
    public List<RecentTaskInfo> getRecentTasks(int i, int i2) throws SecurityException {
        try {
            return ActivityManagerNative.getDefault().getRecentTasks(i, i2, UserHandle.myUserId());
        } catch (RemoteException e) {
            return null;
        }
    }

    public List<RecentTaskInfo> getRecentTasksForUser(int i, int i2, int i3) throws SecurityException {
        try {
            return ActivityManagerNative.getDefault().getRecentTasks(i, i2, i3);
        } catch (RemoteException e) {
            return null;
        }
    }

    public List<RunningAppProcessInfo> getRunningAppProcesses() {
        try {
            return ActivityManagerNative.getDefault().getRunningAppProcesses();
        } catch (RemoteException e) {
            return null;
        }
    }

    public List<ApplicationInfo> getRunningExternalApplications() {
        try {
            return ActivityManagerNative.getDefault().getRunningExternalApplications();
        } catch (RemoteException e) {
            return null;
        }
    }

    public PendingIntent getRunningServiceControlPanel(ComponentName componentName) throws SecurityException {
        try {
            return ActivityManagerNative.getDefault().getRunningServiceControlPanel(componentName);
        } catch (RemoteException e) {
            return null;
        }
    }

    public List<RunningServiceInfo> getRunningServices(int i) throws SecurityException {
        try {
            return ActivityManagerNative.getDefault().getServices(i, 0);
        } catch (RemoteException e) {
            return null;
        }
    }

    @Deprecated
    public List<RunningTaskInfo> getRunningTasks(int i) throws SecurityException {
        try {
            return ActivityManagerNative.getDefault().getTasks(i, 0);
        } catch (RemoteException e) {
            return null;
        }
    }

    public TaskThumbnail getTaskThumbnail(int i) throws SecurityException {
        try {
            return ActivityManagerNative.getDefault().getTaskThumbnail(i);
        } catch (RemoteException e) {
            return null;
        }
    }

    public boolean isInHomeStack(int i) {
        try {
            return ActivityManagerNative.getDefault().isInHomeStack(i);
        } catch (RemoteException e) {
            return false;
        }
    }

    public boolean isInLockTaskMode() {
        try {
            return ActivityManagerNative.getDefault().isInLockTaskMode();
        } catch (RemoteException e) {
            return false;
        }
    }

    public boolean isLowRamDevice() {
        return isLowRamDeviceStatic();
    }

    public boolean isUserRunning(int i) {
        try {
            return ActivityManagerNative.getDefault().isUserRunning(i, false);
        } catch (RemoteException e) {
            return false;
        }
    }

    public void killBackgroundProcesses(String str) {
        try {
            ActivityManagerNative.getDefault().killBackgroundProcesses(str, UserHandle.myUserId());
        } catch (RemoteException e) {
        }
    }

    public void moveTaskToFront(int i, int i2) {
        moveTaskToFront(i, i2, null);
    }

    public void moveTaskToFront(int i, int i2, Bundle bundle) {
        try {
            ActivityManagerNative.getDefault().moveTaskToFront(i, i2, bundle);
        } catch (RemoteException e) {
        }
    }

    public boolean removeTask(int i) throws SecurityException {
        try {
            return ActivityManagerNative.getDefault().removeTask(i);
        } catch (RemoteException e) {
            return false;
        }
    }

    @Deprecated
    public void restartPackage(String str) {
        killBackgroundProcesses(str);
    }

    public void setFrontActivityScreenCompatMode(int i) {
        try {
            ActivityManagerNative.getDefault().setFrontActivityScreenCompatMode(i);
        } catch (RemoteException e) {
        }
    }

    public void setPackageAskScreenCompat(String str, boolean z) {
        try {
            ActivityManagerNative.getDefault().setPackageAskScreenCompat(str, z);
        } catch (RemoteException e) {
        }
    }

    public void setPackageScreenCompatMode(String str, int i) {
        try {
            ActivityManagerNative.getDefault().setPackageScreenCompatMode(str, i);
        } catch (RemoteException e) {
        }
    }

    public void startLockTaskMode(int i) {
        try {
            ActivityManagerNative.getDefault().startLockTaskMode(i);
        } catch (RemoteException e) {
        }
    }

    public void stopLockTaskMode() {
        try {
            ActivityManagerNative.getDefault().stopLockTaskMode();
        } catch (RemoteException e) {
        }
    }

    public boolean switchUser(int i) {
        try {
            return ActivityManagerNative.getDefault().switchUser(i);
        } catch (RemoteException e) {
            return false;
        }
    }

    public void updateConfiguration(Configuration configuration) throws SecurityException {
        try {
            ActivityManagerNative.getDefault().updateConfiguration(configuration);
        } catch (RemoteException e) {
        }
    }
}
