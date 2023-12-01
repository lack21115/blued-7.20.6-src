package android.app;

import android.app.ActivityManager;
import android.app.ApplicationErrorReport;
import android.app.IActivityContainer;
import android.app.IActivityContainerCallback;
import android.app.IActivityController;
import android.app.IActivityManager;
import android.app.IInstrumentationWatcher;
import android.app.IProcessObserver;
import android.app.IServiceConnection;
import android.app.IStopUserCallback;
import android.app.ITaskStackListener;
import android.app.IUiAutomationConnection;
import android.app.IUserSwitchObserver;
import android.content.ComponentName;
import android.content.IIntentReceiver;
import android.content.IIntentSender;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.content.UriPermission;
import android.content.pm.ApplicationInfo;
import android.content.pm.ConfigurationInfo;
import android.content.pm.IPackageDataObserver;
import android.content.pm.ParceledListSlice;
import android.content.pm.UserInfo;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.Debug;
import android.os.IBinder;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.StrictMode;
import android.service.voice.IVoiceInteractionSession;
import android.text.TextUtils;
import android.util.Singleton;
import com.android.internal.app.IVoiceInteractor;
import java.util.List;

/* loaded from: source-9557208-dex2jar.jar:android/app/ActivityManagerNative.class */
public abstract class ActivityManagerNative extends Binder implements IActivityManager {
    static boolean sSystemReady = false;
    private static final Singleton<IActivityManager> gDefault = new Singleton<IActivityManager>() { // from class: android.app.ActivityManagerNative.1
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.util.Singleton
        public IActivityManager create() {
            return ActivityManagerNative.asInterface(ServiceManager.getService("activity"));
        }
    };

    public ActivityManagerNative() {
        attachInterface(this, IActivityManager.descriptor);
    }

    public static IActivityManager asInterface(IBinder iBinder) {
        IActivityManager iActivityManager;
        if (iBinder == null) {
            iActivityManager = null;
        } else {
            IActivityManager iActivityManager2 = (IActivityManager) iBinder.queryLocalInterface(IActivityManager.descriptor);
            iActivityManager = iActivityManager2;
            if (iActivityManager2 == null) {
                return new ActivityManagerProxy(iBinder);
            }
        }
        return iActivityManager;
    }

    public static void broadcastStickyIntent(Intent intent, String str, int i) {
        try {
            getDefault().broadcastIntent(null, intent, null, null, -1, null, null, null, -1, false, true, i);
        } catch (RemoteException e) {
        }
    }

    public static IActivityManager getDefault() {
        return gDefault.get();
    }

    public static boolean isSystemReady() {
        if (!sSystemReady) {
            sSystemReady = getDefault().testIsSystemReady();
        }
        return sSystemReady;
    }

    public static void noteWakeupAlarm(PendingIntent pendingIntent, int i, String str) {
        try {
            getDefault().noteWakeupAlarm(pendingIntent.getTarget(), i, str);
        } catch (RemoteException e) {
        }
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this;
    }

    @Override // android.os.Binder
    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        Intent[] intentArr;
        String[] strArr;
        switch (i) {
            case 2:
                parcel.enforceInterface(IActivityManager.descriptor);
                handleApplicationCrash(parcel.readStrongBinder(), new ApplicationErrorReport.CrashInfo(parcel));
                parcel2.writeNoException();
                return true;
            case 3:
                parcel.enforceInterface(IActivityManager.descriptor);
                int startActivity = startActivity(ApplicationThreadNative.asInterface(parcel.readStrongBinder()), parcel.readString(), Intent.CREATOR.createFromParcel(parcel), parcel.readString(), parcel.readStrongBinder(), parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readInt() != 0 ? ProfilerInfo.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? Bundle.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                parcel2.writeInt(startActivity);
                return true;
            case 4:
                parcel.enforceInterface(IActivityManager.descriptor);
                unhandledBack();
                parcel2.writeNoException();
                return true;
            case 5:
                parcel.enforceInterface(IActivityManager.descriptor);
                ParcelFileDescriptor openContentUri = openContentUri(Uri.parse(parcel.readString()));
                parcel2.writeNoException();
                if (openContentUri == null) {
                    parcel2.writeInt(0);
                    return true;
                }
                parcel2.writeInt(1);
                openContentUri.writeToParcel(parcel2, 1);
                return true;
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 28:
            case 40:
            case 41:
            case 131:
            case 139:
            case 160:
            case 187:
            case 188:
            case 189:
            case 190:
            case 191:
            case 192:
            case 193:
            case 194:
            case 195:
            case 196:
            case 197:
            case 198:
            case 199:
            case 200:
            case 201:
            case 202:
            case 203:
            case 204:
            case 205:
            case 206:
            case 207:
            case 208:
            case 209:
            case 210:
            default:
                return super.onTransact(i, parcel, parcel2, i2);
            case 11:
                parcel.enforceInterface(IActivityManager.descriptor);
                IBinder readStrongBinder = parcel.readStrongBinder();
                Intent intent = null;
                int readInt = parcel.readInt();
                if (parcel.readInt() != 0) {
                    intent = Intent.CREATOR.createFromParcel(parcel);
                }
                boolean finishActivity = finishActivity(readStrongBinder, readInt, intent, parcel.readInt() != 0);
                parcel2.writeNoException();
                parcel2.writeInt(finishActivity ? 1 : 0);
                return true;
            case 12:
                parcel.enforceInterface(IActivityManager.descriptor);
                IBinder readStrongBinder2 = parcel.readStrongBinder();
                IApplicationThread asInterface = readStrongBinder2 != null ? ApplicationThreadNative.asInterface(readStrongBinder2) : null;
                String readString = parcel.readString();
                IBinder readStrongBinder3 = parcel.readStrongBinder();
                Intent registerReceiver = registerReceiver(asInterface, readString, readStrongBinder3 != null ? IIntentReceiver.Stub.asInterface(readStrongBinder3) : null, IntentFilter.CREATOR.createFromParcel(parcel), parcel.readString(), parcel.readInt());
                parcel2.writeNoException();
                if (registerReceiver == null) {
                    parcel2.writeInt(0);
                    return true;
                }
                parcel2.writeInt(1);
                registerReceiver.writeToParcel(parcel2, 0);
                return true;
            case 13:
                parcel.enforceInterface(IActivityManager.descriptor);
                IBinder readStrongBinder4 = parcel.readStrongBinder();
                if (readStrongBinder4 == null) {
                    return true;
                }
                unregisterReceiver(IIntentReceiver.Stub.asInterface(readStrongBinder4));
                parcel2.writeNoException();
                return true;
            case 14:
                parcel.enforceInterface(IActivityManager.descriptor);
                IBinder readStrongBinder5 = parcel.readStrongBinder();
                IApplicationThread asInterface2 = readStrongBinder5 != null ? ApplicationThreadNative.asInterface(readStrongBinder5) : null;
                Intent createFromParcel = Intent.CREATOR.createFromParcel(parcel);
                String readString2 = parcel.readString();
                IBinder readStrongBinder6 = parcel.readStrongBinder();
                int broadcastIntent = broadcastIntent(asInterface2, createFromParcel, readString2, readStrongBinder6 != null ? IIntentReceiver.Stub.asInterface(readStrongBinder6) : null, parcel.readInt(), parcel.readString(), parcel.readBundle(), parcel.readString(), parcel.readInt(), parcel.readInt() != 0, parcel.readInt() != 0, parcel.readInt());
                parcel2.writeNoException();
                parcel2.writeInt(broadcastIntent);
                return true;
            case 15:
                parcel.enforceInterface(IActivityManager.descriptor);
                IBinder readStrongBinder7 = parcel.readStrongBinder();
                unbroadcastIntent(readStrongBinder7 != null ? ApplicationThreadNative.asInterface(readStrongBinder7) : null, Intent.CREATOR.createFromParcel(parcel), parcel.readInt());
                parcel2.writeNoException();
                return true;
            case 16:
                parcel.enforceInterface(IActivityManager.descriptor);
                IBinder readStrongBinder8 = parcel.readStrongBinder();
                int readInt2 = parcel.readInt();
                String readString3 = parcel.readString();
                Bundle readBundle = parcel.readBundle();
                boolean z = parcel.readInt() != 0;
                int readInt3 = parcel.readInt();
                if (readStrongBinder8 != null) {
                    finishReceiver(readStrongBinder8, readInt2, readString3, readBundle, z, readInt3);
                }
                parcel2.writeNoException();
                return true;
            case 17:
                parcel.enforceInterface(IActivityManager.descriptor);
                IApplicationThread asInterface3 = ApplicationThreadNative.asInterface(parcel.readStrongBinder());
                if (asInterface3 != null) {
                    attachApplication(asInterface3);
                }
                parcel2.writeNoException();
                return true;
            case 18:
                parcel.enforceInterface(IActivityManager.descriptor);
                IBinder readStrongBinder9 = parcel.readStrongBinder();
                Configuration configuration = null;
                if (parcel.readInt() != 0) {
                    configuration = Configuration.CREATOR.createFromParcel(parcel);
                }
                boolean z2 = parcel.readInt() != 0;
                if (readStrongBinder9 != null) {
                    activityIdle(readStrongBinder9, configuration, z2);
                }
                parcel2.writeNoException();
                return true;
            case 19:
                parcel.enforceInterface(IActivityManager.descriptor);
                activityPaused(parcel.readStrongBinder());
                parcel2.writeNoException();
                return true;
            case 20:
                parcel.enforceInterface(IActivityManager.descriptor);
                activityStopped(parcel.readStrongBinder(), parcel.readBundle(), parcel.readPersistableBundle(), TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel));
                parcel2.writeNoException();
                return true;
            case 21:
                parcel.enforceInterface(IActivityManager.descriptor);
                IBinder readStrongBinder10 = parcel.readStrongBinder();
                String callingPackage = readStrongBinder10 != null ? getCallingPackage(readStrongBinder10) : null;
                parcel2.writeNoException();
                parcel2.writeString(callingPackage);
                return true;
            case 22:
                parcel.enforceInterface(IActivityManager.descriptor);
                ComponentName callingActivity = getCallingActivity(parcel.readStrongBinder());
                parcel2.writeNoException();
                ComponentName.writeToParcel(callingActivity, parcel2);
                return true;
            case 23:
                parcel.enforceInterface(IActivityManager.descriptor);
                List<ActivityManager.RunningTaskInfo> tasks = getTasks(parcel.readInt(), parcel.readInt());
                parcel2.writeNoException();
                int size = tasks != null ? tasks.size() : -1;
                parcel2.writeInt(size);
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 >= size) {
                        return true;
                    }
                    tasks.get(i4).writeToParcel(parcel2, 0);
                    i3 = i4 + 1;
                }
            case 24:
                parcel.enforceInterface(IActivityManager.descriptor);
                moveTaskToFront(parcel.readInt(), parcel.readInt(), parcel.readInt() != 0 ? Bundle.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                return true;
            case 25:
                parcel.enforceInterface(IActivityManager.descriptor);
                moveTaskToBack(parcel.readInt());
                parcel2.writeNoException();
                return true;
            case 26:
                parcel.enforceInterface(IActivityManager.descriptor);
                moveTaskBackwards(parcel.readInt());
                parcel2.writeNoException();
                return true;
            case 27:
                parcel.enforceInterface(IActivityManager.descriptor);
                IBinder readStrongBinder11 = parcel.readStrongBinder();
                int taskForActivity = readStrongBinder11 != null ? getTaskForActivity(readStrongBinder11, parcel.readInt() != 0) : -1;
                parcel2.writeNoException();
                parcel2.writeInt(taskForActivity);
                return true;
            case 29:
                parcel.enforceInterface(IActivityManager.descriptor);
                IActivityManager.ContentProviderHolder contentProvider = getContentProvider(ApplicationThreadNative.asInterface(parcel.readStrongBinder()), parcel.readString(), parcel.readInt(), parcel.readInt() != 0);
                parcel2.writeNoException();
                if (contentProvider == null) {
                    parcel2.writeInt(0);
                    return true;
                }
                parcel2.writeInt(1);
                contentProvider.writeToParcel(parcel2, 0);
                return true;
            case 30:
                parcel.enforceInterface(IActivityManager.descriptor);
                publishContentProviders(ApplicationThreadNative.asInterface(parcel.readStrongBinder()), parcel.createTypedArrayList(IActivityManager.ContentProviderHolder.CREATOR));
                parcel2.writeNoException();
                return true;
            case 31:
                parcel.enforceInterface(IActivityManager.descriptor);
                boolean refContentProvider = refContentProvider(parcel.readStrongBinder(), parcel.readInt(), parcel.readInt());
                parcel2.writeNoException();
                parcel2.writeInt(refContentProvider ? 1 : 0);
                return true;
            case 32:
                parcel.enforceInterface(IActivityManager.descriptor);
                finishSubActivity(parcel.readStrongBinder(), parcel.readString(), parcel.readInt());
                parcel2.writeNoException();
                return true;
            case 33:
                parcel.enforceInterface(IActivityManager.descriptor);
                PendingIntent runningServiceControlPanel = getRunningServiceControlPanel(ComponentName.CREATOR.createFromParcel(parcel));
                parcel2.writeNoException();
                PendingIntent.writePendingIntentOrNullToParcel(runningServiceControlPanel, parcel2);
                return true;
            case 34:
                parcel.enforceInterface(IActivityManager.descriptor);
                ComponentName startService = startService(ApplicationThreadNative.asInterface(parcel.readStrongBinder()), Intent.CREATOR.createFromParcel(parcel), parcel.readString(), parcel.readInt());
                parcel2.writeNoException();
                ComponentName.writeToParcel(startService, parcel2);
                return true;
            case 35:
                parcel.enforceInterface(IActivityManager.descriptor);
                int stopService = stopService(ApplicationThreadNative.asInterface(parcel.readStrongBinder()), Intent.CREATOR.createFromParcel(parcel), parcel.readString(), parcel.readInt());
                parcel2.writeNoException();
                parcel2.writeInt(stopService);
                return true;
            case 36:
                parcel.enforceInterface(IActivityManager.descriptor);
                int bindService = bindService(ApplicationThreadNative.asInterface(parcel.readStrongBinder()), parcel.readStrongBinder(), Intent.CREATOR.createFromParcel(parcel), parcel.readString(), IServiceConnection.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt());
                parcel2.writeNoException();
                parcel2.writeInt(bindService);
                return true;
            case 37:
                parcel.enforceInterface(IActivityManager.descriptor);
                boolean unbindService = unbindService(IServiceConnection.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                parcel2.writeInt(unbindService ? 1 : 0);
                return true;
            case 38:
                parcel.enforceInterface(IActivityManager.descriptor);
                publishService(parcel.readStrongBinder(), Intent.CREATOR.createFromParcel(parcel), parcel.readStrongBinder());
                parcel2.writeNoException();
                return true;
            case 39:
                parcel.enforceInterface(IActivityManager.descriptor);
                activityResumed(parcel.readStrongBinder());
                parcel2.writeNoException();
                return true;
            case 42:
                parcel.enforceInterface(IActivityManager.descriptor);
                setDebugApp(parcel.readString(), parcel.readInt() != 0, parcel.readInt() != 0);
                parcel2.writeNoException();
                return true;
            case 43:
                parcel.enforceInterface(IActivityManager.descriptor);
                setAlwaysFinish(parcel.readInt() != 0);
                parcel2.writeNoException();
                return true;
            case 44:
                parcel.enforceInterface(IActivityManager.descriptor);
                boolean startInstrumentation = startInstrumentation(ComponentName.readFromParcel(parcel), parcel.readString(), parcel.readInt(), parcel.readBundle(), IInstrumentationWatcher.Stub.asInterface(parcel.readStrongBinder()), IUiAutomationConnection.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeInt(startInstrumentation ? 1 : 0);
                return true;
            case 45:
                parcel.enforceInterface(IActivityManager.descriptor);
                finishInstrumentation(ApplicationThreadNative.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readBundle());
                parcel2.writeNoException();
                return true;
            case 46:
                parcel.enforceInterface(IActivityManager.descriptor);
                Configuration configuration2 = getConfiguration();
                parcel2.writeNoException();
                configuration2.writeToParcel(parcel2, 0);
                return true;
            case 47:
                parcel.enforceInterface(IActivityManager.descriptor);
                updateConfiguration(Configuration.CREATOR.createFromParcel(parcel));
                parcel2.writeNoException();
                return true;
            case 48:
                parcel.enforceInterface(IActivityManager.descriptor);
                boolean stopServiceToken = stopServiceToken(ComponentName.readFromParcel(parcel), parcel.readStrongBinder(), parcel.readInt());
                parcel2.writeNoException();
                parcel2.writeInt(stopServiceToken ? 1 : 0);
                return true;
            case 49:
                parcel.enforceInterface(IActivityManager.descriptor);
                ComponentName activityClassForToken = getActivityClassForToken(parcel.readStrongBinder());
                parcel2.writeNoException();
                ComponentName.writeToParcel(activityClassForToken, parcel2);
                return true;
            case 50:
                parcel.enforceInterface(IActivityManager.descriptor);
                IBinder readStrongBinder12 = parcel.readStrongBinder();
                parcel2.writeNoException();
                parcel2.writeString(getPackageForToken(readStrongBinder12));
                return true;
            case 51:
                parcel.enforceInterface(IActivityManager.descriptor);
                setProcessLimit(parcel.readInt());
                parcel2.writeNoException();
                return true;
            case 52:
                parcel.enforceInterface(IActivityManager.descriptor);
                int processLimit = getProcessLimit();
                parcel2.writeNoException();
                parcel2.writeInt(processLimit);
                return true;
            case 53:
                parcel.enforceInterface(IActivityManager.descriptor);
                int checkPermission = checkPermission(parcel.readString(), parcel.readInt(), parcel.readInt());
                parcel2.writeNoException();
                parcel2.writeInt(checkPermission);
                return true;
            case 54:
                parcel.enforceInterface(IActivityManager.descriptor);
                int checkUriPermission = checkUriPermission(Uri.CREATOR.createFromParcel(parcel), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readStrongBinder());
                parcel2.writeNoException();
                parcel2.writeInt(checkUriPermission);
                return true;
            case 55:
                parcel.enforceInterface(IActivityManager.descriptor);
                grantUriPermission(ApplicationThreadNative.asInterface(parcel.readStrongBinder()), parcel.readString(), Uri.CREATOR.createFromParcel(parcel), parcel.readInt(), parcel.readInt());
                parcel2.writeNoException();
                return true;
            case 56:
                parcel.enforceInterface(IActivityManager.descriptor);
                revokeUriPermission(ApplicationThreadNative.asInterface(parcel.readStrongBinder()), Uri.CREATOR.createFromParcel(parcel), parcel.readInt(), parcel.readInt());
                parcel2.writeNoException();
                return true;
            case 57:
                parcel.enforceInterface(IActivityManager.descriptor);
                setActivityController(IActivityController.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 58:
                parcel.enforceInterface(IActivityManager.descriptor);
                showWaitingForDebugger(ApplicationThreadNative.asInterface(parcel.readStrongBinder()), parcel.readInt() != 0);
                parcel2.writeNoException();
                return true;
            case 59:
                parcel.enforceInterface(IActivityManager.descriptor);
                signalPersistentProcesses(parcel.readInt());
                parcel2.writeNoException();
                return true;
            case 60:
                parcel.enforceInterface(IActivityManager.descriptor);
                List<ActivityManager.RecentTaskInfo> recentTasks = getRecentTasks(parcel.readInt(), parcel.readInt(), parcel.readInt());
                parcel2.writeNoException();
                parcel2.writeTypedList(recentTasks);
                return true;
            case 61:
                parcel.enforceInterface(IActivityManager.descriptor);
                serviceDoneExecuting(parcel.readStrongBinder(), parcel.readInt(), parcel.readInt(), parcel.readInt());
                parcel2.writeNoException();
                return true;
            case 62:
                parcel.enforceInterface(IActivityManager.descriptor);
                activityDestroyed(parcel.readStrongBinder());
                parcel2.writeNoException();
                return true;
            case 63:
                parcel.enforceInterface(IActivityManager.descriptor);
                int readInt4 = parcel.readInt();
                String readString4 = parcel.readString();
                IBinder readStrongBinder13 = parcel.readStrongBinder();
                String readString5 = parcel.readString();
                int readInt5 = parcel.readInt();
                if (parcel.readInt() != 0) {
                    intentArr = (Intent[]) parcel.createTypedArray(Intent.CREATOR);
                    strArr = parcel.createStringArray();
                } else {
                    intentArr = null;
                    strArr = null;
                }
                IIntentSender intentSender = getIntentSender(readInt4, readString4, readStrongBinder13, readString5, readInt5, intentArr, strArr, parcel.readInt(), parcel.readInt() != 0 ? Bundle.CREATOR.createFromParcel(parcel) : null, parcel.readInt());
                parcel2.writeNoException();
                parcel2.writeStrongBinder(intentSender != null ? intentSender.asBinder() : null);
                return true;
            case 64:
                parcel.enforceInterface(IActivityManager.descriptor);
                cancelIntentSender(IIntentSender.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 65:
                parcel.enforceInterface(IActivityManager.descriptor);
                String packageForIntentSender = getPackageForIntentSender(IIntentSender.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                parcel2.writeString(packageForIntentSender);
                return true;
            case 66:
                parcel.enforceInterface(IActivityManager.descriptor);
                enterSafeMode();
                parcel2.writeNoException();
                return true;
            case 67:
                parcel.enforceInterface(IActivityManager.descriptor);
                boolean startNextMatchingActivity = startNextMatchingActivity(parcel.readStrongBinder(), Intent.CREATOR.createFromParcel(parcel), parcel.readInt() != 0 ? Bundle.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                parcel2.writeInt(startNextMatchingActivity ? 1 : 0);
                return true;
            case 68:
                parcel.enforceInterface(IActivityManager.descriptor);
                noteWakeupAlarm(IIntentSender.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 69:
                parcel.enforceInterface(IActivityManager.descriptor);
                removeContentProvider(parcel.readStrongBinder(), parcel.readInt() != 0);
                parcel2.writeNoException();
                return true;
            case 70:
                parcel.enforceInterface(IActivityManager.descriptor);
                setRequestedOrientation(parcel.readStrongBinder(), parcel.readInt());
                parcel2.writeNoException();
                return true;
            case 71:
                parcel.enforceInterface(IActivityManager.descriptor);
                int requestedOrientation = getRequestedOrientation(parcel.readStrongBinder());
                parcel2.writeNoException();
                parcel2.writeInt(requestedOrientation);
                return true;
            case 72:
                parcel.enforceInterface(IActivityManager.descriptor);
                unbindFinished(parcel.readStrongBinder(), Intent.CREATOR.createFromParcel(parcel), parcel.readInt() != 0);
                parcel2.writeNoException();
                return true;
            case 73:
                parcel.enforceInterface(IActivityManager.descriptor);
                setProcessForeground(parcel.readStrongBinder(), parcel.readInt(), parcel.readInt() != 0);
                parcel2.writeNoException();
                return true;
            case 74:
                parcel.enforceInterface(IActivityManager.descriptor);
                ComponentName readFromParcel = ComponentName.readFromParcel(parcel);
                IBinder readStrongBinder14 = parcel.readStrongBinder();
                int readInt6 = parcel.readInt();
                Notification notification = null;
                if (parcel.readInt() != 0) {
                    notification = Notification.CREATOR.createFromParcel(parcel);
                }
                setServiceForeground(readFromParcel, readStrongBinder14, readInt6, notification, parcel.readInt() != 0);
                parcel2.writeNoException();
                return true;
            case 75:
                parcel.enforceInterface(IActivityManager.descriptor);
                boolean moveActivityTaskToBack = moveActivityTaskToBack(parcel.readStrongBinder(), parcel.readInt() != 0);
                parcel2.writeNoException();
                parcel2.writeInt(moveActivityTaskToBack ? 1 : 0);
                return true;
            case 76:
                parcel.enforceInterface(IActivityManager.descriptor);
                ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
                getMemoryInfo(memoryInfo);
                parcel2.writeNoException();
                memoryInfo.writeToParcel(parcel2, 0);
                return true;
            case 77:
                parcel.enforceInterface(IActivityManager.descriptor);
                List<ActivityManager.ProcessErrorStateInfo> processesInErrorState = getProcessesInErrorState();
                parcel2.writeNoException();
                parcel2.writeTypedList(processesInErrorState);
                return true;
            case 78:
                parcel.enforceInterface(IActivityManager.descriptor);
                boolean clearApplicationUserData = clearApplicationUserData(parcel.readString(), IPackageDataObserver.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                parcel2.writeInt(clearApplicationUserData ? 1 : 0);
                return true;
            case 79:
                parcel.enforceInterface(IActivityManager.descriptor);
                forceStopPackage(parcel.readString(), parcel.readInt());
                parcel2.writeNoException();
                return true;
            case 80:
                parcel.enforceInterface(IActivityManager.descriptor);
                boolean killPids = killPids(parcel.createIntArray(), parcel.readString(), parcel.readInt() != 0);
                parcel2.writeNoException();
                parcel2.writeInt(killPids ? 1 : 0);
                return true;
            case 81:
                parcel.enforceInterface(IActivityManager.descriptor);
                List<ActivityManager.RunningServiceInfo> services = getServices(parcel.readInt(), parcel.readInt());
                parcel2.writeNoException();
                int size2 = services != null ? services.size() : -1;
                parcel2.writeInt(size2);
                int i5 = 0;
                while (true) {
                    int i6 = i5;
                    if (i6 >= size2) {
                        return true;
                    }
                    services.get(i6).writeToParcel(parcel2, 0);
                    i5 = i6 + 1;
                }
            case 82:
                parcel.enforceInterface(IActivityManager.descriptor);
                ActivityManager.TaskThumbnail taskThumbnail = getTaskThumbnail(parcel.readInt());
                parcel2.writeNoException();
                if (taskThumbnail == null) {
                    parcel2.writeInt(0);
                    return true;
                }
                parcel2.writeInt(1);
                taskThumbnail.writeToParcel(parcel2, 1);
                return true;
            case 83:
                parcel.enforceInterface(IActivityManager.descriptor);
                List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = getRunningAppProcesses();
                parcel2.writeNoException();
                parcel2.writeTypedList(runningAppProcesses);
                return true;
            case 84:
                parcel.enforceInterface(IActivityManager.descriptor);
                ConfigurationInfo deviceConfigurationInfo = getDeviceConfigurationInfo();
                parcel2.writeNoException();
                deviceConfigurationInfo.writeToParcel(parcel2, 0);
                return true;
            case 85:
                parcel.enforceInterface(IActivityManager.descriptor);
                IBinder peekService = peekService(Intent.CREATOR.createFromParcel(parcel), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeStrongBinder(peekService);
                return true;
            case 86:
                parcel.enforceInterface(IActivityManager.descriptor);
                boolean profileControl = profileControl(parcel.readString(), parcel.readInt(), parcel.readInt() != 0, parcel.readInt() != 0 ? ProfilerInfo.CREATOR.createFromParcel(parcel) : null, parcel.readInt());
                parcel2.writeNoException();
                parcel2.writeInt(profileControl ? 1 : 0);
                return true;
            case 87:
                parcel.enforceInterface(IActivityManager.descriptor);
                boolean shutdown = shutdown(parcel.readInt());
                parcel2.writeNoException();
                parcel2.writeInt(shutdown ? 1 : 0);
                return true;
            case 88:
                parcel.enforceInterface(IActivityManager.descriptor);
                stopAppSwitches();
                parcel2.writeNoException();
                return true;
            case 89:
                parcel.enforceInterface(IActivityManager.descriptor);
                resumeAppSwitches();
                parcel2.writeNoException();
                return true;
            case 90:
                parcel.enforceInterface(IActivityManager.descriptor);
                boolean bindBackupAgent = bindBackupAgent(ApplicationInfo.CREATOR.createFromParcel(parcel), parcel.readInt());
                parcel2.writeNoException();
                parcel2.writeInt(bindBackupAgent ? 1 : 0);
                return true;
            case 91:
                parcel.enforceInterface(IActivityManager.descriptor);
                backupAgentCreated(parcel.readString(), parcel.readStrongBinder());
                parcel2.writeNoException();
                return true;
            case 92:
                parcel.enforceInterface(IActivityManager.descriptor);
                unbindBackupAgent(ApplicationInfo.CREATOR.createFromParcel(parcel));
                parcel2.writeNoException();
                return true;
            case 93:
                parcel.enforceInterface(IActivityManager.descriptor);
                int uidForIntentSender = getUidForIntentSender(IIntentSender.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                parcel2.writeInt(uidForIntentSender);
                return true;
            case 94:
                parcel.enforceInterface(IActivityManager.descriptor);
                int handleIncomingUser = handleIncomingUser(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt() != 0, parcel.readInt() != 0, parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeInt(handleIncomingUser);
                return true;
            case 95:
                parcel.enforceInterface(IActivityManager.descriptor);
                addPackageDependency(parcel.readString());
                parcel2.writeNoException();
                return true;
            case 96:
                parcel.enforceInterface(IActivityManager.descriptor);
                killApplicationWithAppId(parcel.readString(), parcel.readInt(), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 97:
                parcel.enforceInterface(IActivityManager.descriptor);
                closeSystemDialogs(parcel.readString());
                parcel2.writeNoException();
                return true;
            case 98:
                parcel.enforceInterface(IActivityManager.descriptor);
                Debug.MemoryInfo[] processMemoryInfo = getProcessMemoryInfo(parcel.createIntArray());
                parcel2.writeNoException();
                parcel2.writeTypedArray(processMemoryInfo, 1);
                return true;
            case 99:
                parcel.enforceInterface(IActivityManager.descriptor);
                killApplicationProcess(parcel.readString(), parcel.readInt());
                parcel2.writeNoException();
                return true;
            case 100:
                parcel.enforceInterface(IActivityManager.descriptor);
                IApplicationThread asInterface4 = ApplicationThreadNative.asInterface(parcel.readStrongBinder());
                IntentSender createFromParcel2 = IntentSender.CREATOR.createFromParcel(parcel);
                Intent intent2 = null;
                if (parcel.readInt() != 0) {
                    intent2 = Intent.CREATOR.createFromParcel(parcel);
                }
                int startActivityIntentSender = startActivityIntentSender(asInterface4, createFromParcel2, intent2, parcel.readString(), parcel.readStrongBinder(), parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt() != 0 ? Bundle.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                parcel2.writeInt(startActivityIntentSender);
                return true;
            case 101:
                parcel.enforceInterface(IActivityManager.descriptor);
                overridePendingTransition(parcel.readStrongBinder(), parcel.readString(), parcel.readInt(), parcel.readInt());
                parcel2.writeNoException();
                return true;
            case 102:
                parcel.enforceInterface(IActivityManager.descriptor);
                boolean handleApplicationWtf = handleApplicationWtf(parcel.readStrongBinder(), parcel.readString(), parcel.readInt() != 0, new ApplicationErrorReport.CrashInfo(parcel));
                parcel2.writeNoException();
                parcel2.writeInt(handleApplicationWtf ? 1 : 0);
                return true;
            case 103:
                parcel.enforceInterface(IActivityManager.descriptor);
                killBackgroundProcesses(parcel.readString(), parcel.readInt());
                parcel2.writeNoException();
                return true;
            case 104:
                parcel.enforceInterface(IActivityManager.descriptor);
                boolean isUserAMonkey = isUserAMonkey();
                parcel2.writeNoException();
                parcel2.writeInt(isUserAMonkey ? 1 : 0);
                return true;
            case 105:
                parcel.enforceInterface(IActivityManager.descriptor);
                IActivityManager.WaitResult startActivityAndWait = startActivityAndWait(ApplicationThreadNative.asInterface(parcel.readStrongBinder()), parcel.readString(), Intent.CREATOR.createFromParcel(parcel), parcel.readString(), parcel.readStrongBinder(), parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readInt() != 0 ? ProfilerInfo.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? Bundle.CREATOR.createFromParcel(parcel) : null, parcel.readInt());
                parcel2.writeNoException();
                startActivityAndWait.writeToParcel(parcel2, 0);
                return true;
            case 106:
                parcel.enforceInterface(IActivityManager.descriptor);
                boolean willActivityBeVisible = willActivityBeVisible(parcel.readStrongBinder());
                parcel2.writeNoException();
                parcel2.writeInt(willActivityBeVisible ? 1 : 0);
                return true;
            case 107:
                parcel.enforceInterface(IActivityManager.descriptor);
                int startActivityWithConfig = startActivityWithConfig(ApplicationThreadNative.asInterface(parcel.readStrongBinder()), parcel.readString(), Intent.CREATOR.createFromParcel(parcel), parcel.readString(), parcel.readStrongBinder(), parcel.readString(), parcel.readInt(), parcel.readInt(), Configuration.CREATOR.createFromParcel(parcel), parcel.readInt() != 0 ? Bundle.CREATOR.createFromParcel(parcel) : null, parcel.readInt());
                parcel2.writeNoException();
                parcel2.writeInt(startActivityWithConfig);
                return true;
            case 108:
                parcel.enforceInterface(IActivityManager.descriptor);
                List<ApplicationInfo> runningExternalApplications = getRunningExternalApplications();
                parcel2.writeNoException();
                parcel2.writeTypedList(runningExternalApplications);
                return true;
            case 109:
                parcel.enforceInterface(IActivityManager.descriptor);
                finishHeavyWeightApp();
                parcel2.writeNoException();
                return true;
            case 110:
                parcel.enforceInterface(IActivityManager.descriptor);
                handleApplicationStrictModeViolation(parcel.readStrongBinder(), parcel.readInt(), new StrictMode.ViolationInfo(parcel));
                parcel2.writeNoException();
                return true;
            case 111:
                parcel.enforceInterface(IActivityManager.descriptor);
                boolean isImmersive = isImmersive(parcel.readStrongBinder());
                parcel2.writeNoException();
                parcel2.writeInt(isImmersive ? 1 : 0);
                return true;
            case 112:
                parcel.enforceInterface(IActivityManager.descriptor);
                setImmersive(parcel.readStrongBinder(), parcel.readInt() == 1);
                parcel2.writeNoException();
                return true;
            case 113:
                parcel.enforceInterface(IActivityManager.descriptor);
                boolean isTopActivityImmersive = isTopActivityImmersive();
                parcel2.writeNoException();
                parcel2.writeInt(isTopActivityImmersive ? 1 : 0);
                return true;
            case 114:
                parcel.enforceInterface(IActivityManager.descriptor);
                crashApplication(parcel.readInt(), parcel.readInt(), parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 115:
                parcel.enforceInterface(IActivityManager.descriptor);
                String providerMimeType = getProviderMimeType(Uri.CREATOR.createFromParcel(parcel), parcel.readInt());
                parcel2.writeNoException();
                parcel2.writeString(providerMimeType);
                return true;
            case 116:
                parcel.enforceInterface(IActivityManager.descriptor);
                IBinder newUriPermissionOwner = newUriPermissionOwner(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeStrongBinder(newUriPermissionOwner);
                return true;
            case 117:
                parcel.enforceInterface(IActivityManager.descriptor);
                grantUriPermissionFromOwner(parcel.readStrongBinder(), parcel.readInt(), parcel.readString(), Uri.CREATOR.createFromParcel(parcel), parcel.readInt(), parcel.readInt(), parcel.readInt());
                parcel2.writeNoException();
                return true;
            case 118:
                parcel.enforceInterface(IActivityManager.descriptor);
                IBinder readStrongBinder15 = parcel.readStrongBinder();
                Uri uri = null;
                if (parcel.readInt() != 0) {
                    uri = Uri.CREATOR.createFromParcel(parcel);
                }
                revokeUriPermissionFromOwner(readStrongBinder15, uri, parcel.readInt(), parcel.readInt());
                parcel2.writeNoException();
                return true;
            case 119:
                parcel.enforceInterface(IActivityManager.descriptor);
                int checkGrantUriPermission = checkGrantUriPermission(parcel.readInt(), parcel.readString(), Uri.CREATOR.createFromParcel(parcel), parcel.readInt(), parcel.readInt());
                parcel2.writeNoException();
                parcel2.writeInt(checkGrantUriPermission);
                return true;
            case 120:
                parcel.enforceInterface(IActivityManager.descriptor);
                boolean dumpHeap = dumpHeap(parcel.readString(), parcel.readInt(), parcel.readInt() != 0, parcel.readString(), parcel.readInt() != 0 ? ParcelFileDescriptor.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                parcel2.writeInt(dumpHeap ? 1 : 0);
                return true;
            case 121:
                parcel.enforceInterface(IActivityManager.descriptor);
                int startActivities = startActivities(ApplicationThreadNative.asInterface(parcel.readStrongBinder()), parcel.readString(), (Intent[]) parcel.createTypedArray(Intent.CREATOR), parcel.createStringArray(), parcel.readStrongBinder(), parcel.readInt() != 0 ? Bundle.CREATOR.createFromParcel(parcel) : null, parcel.readInt());
                parcel2.writeNoException();
                parcel2.writeInt(startActivities);
                return true;
            case 122:
                parcel.enforceInterface(IActivityManager.descriptor);
                boolean isUserRunning = isUserRunning(parcel.readInt(), parcel.readInt() != 0);
                parcel2.writeNoException();
                parcel2.writeInt(isUserRunning ? 1 : 0);
                return true;
            case 123:
                parcel.enforceInterface(IActivityManager.descriptor);
                activitySlept(parcel.readStrongBinder());
                parcel2.writeNoException();
                return true;
            case 124:
                parcel.enforceInterface(IActivityManager.descriptor);
                int frontActivityScreenCompatMode = getFrontActivityScreenCompatMode();
                parcel2.writeNoException();
                parcel2.writeInt(frontActivityScreenCompatMode);
                return true;
            case 125:
                parcel.enforceInterface(IActivityManager.descriptor);
                int readInt7 = parcel.readInt();
                setFrontActivityScreenCompatMode(readInt7);
                parcel2.writeNoException();
                parcel2.writeInt(readInt7);
                return true;
            case 126:
                parcel.enforceInterface(IActivityManager.descriptor);
                int packageScreenCompatMode = getPackageScreenCompatMode(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeInt(packageScreenCompatMode);
                return true;
            case 127:
                parcel.enforceInterface(IActivityManager.descriptor);
                setPackageScreenCompatMode(parcel.readString(), parcel.readInt());
                parcel2.writeNoException();
                return true;
            case 128:
                parcel.enforceInterface(IActivityManager.descriptor);
                boolean packageAskScreenCompat = getPackageAskScreenCompat(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeInt(packageAskScreenCompat ? 1 : 0);
                return true;
            case 129:
                parcel.enforceInterface(IActivityManager.descriptor);
                setPackageAskScreenCompat(parcel.readString(), parcel.readInt() != 0);
                parcel2.writeNoException();
                return true;
            case 130:
                parcel.enforceInterface(IActivityManager.descriptor);
                boolean switchUser = switchUser(parcel.readInt());
                parcel2.writeNoException();
                parcel2.writeInt(switchUser ? 1 : 0);
                return true;
            case 132:
                parcel.enforceInterface(IActivityManager.descriptor);
                boolean removeTask = removeTask(parcel.readInt());
                parcel2.writeNoException();
                parcel2.writeInt(removeTask ? 1 : 0);
                return true;
            case 133:
                parcel.enforceInterface(IActivityManager.descriptor);
                registerProcessObserver(IProcessObserver.Stub.asInterface(parcel.readStrongBinder()));
                return true;
            case 134:
                parcel.enforceInterface(IActivityManager.descriptor);
                unregisterProcessObserver(IProcessObserver.Stub.asInterface(parcel.readStrongBinder()));
                return true;
            case 135:
                parcel.enforceInterface(IActivityManager.descriptor);
                boolean isIntentSenderTargetedToPackage = isIntentSenderTargetedToPackage(IIntentSender.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                parcel2.writeInt(isIntentSenderTargetedToPackage ? 1 : 0);
                return true;
            case 136:
                parcel.enforceInterface(IActivityManager.descriptor);
                updatePersistentConfiguration(Configuration.CREATOR.createFromParcel(parcel));
                parcel2.writeNoException();
                return true;
            case 137:
                parcel.enforceInterface(IActivityManager.descriptor);
                long[] processPss = getProcessPss(parcel.createIntArray());
                parcel2.writeNoException();
                parcel2.writeLongArray(processPss);
                return true;
            case 138:
                parcel.enforceInterface(IActivityManager.descriptor);
                showBootMessage(TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel), parcel.readInt() != 0);
                parcel2.writeNoException();
                return true;
            case 140:
                parcel.enforceInterface(IActivityManager.descriptor);
                killAllBackgroundProcesses();
                parcel2.writeNoException();
                return true;
            case 141:
                parcel.enforceInterface(IActivityManager.descriptor);
                IActivityManager.ContentProviderHolder contentProviderExternal = getContentProviderExternal(parcel.readString(), parcel.readInt(), parcel.readStrongBinder());
                parcel2.writeNoException();
                if (contentProviderExternal == null) {
                    parcel2.writeInt(0);
                    return true;
                }
                parcel2.writeInt(1);
                contentProviderExternal.writeToParcel(parcel2, 0);
                return true;
            case 142:
                parcel.enforceInterface(IActivityManager.descriptor);
                removeContentProviderExternal(parcel.readString(), parcel.readStrongBinder());
                parcel2.writeNoException();
                return true;
            case 143:
                parcel.enforceInterface(IActivityManager.descriptor);
                ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
                getMyMemoryState(runningAppProcessInfo);
                parcel2.writeNoException();
                runningAppProcessInfo.writeToParcel(parcel2, 0);
                return true;
            case 144:
                parcel.enforceInterface(IActivityManager.descriptor);
                boolean killProcessesBelowForeground = killProcessesBelowForeground(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeInt(killProcessesBelowForeground ? 1 : 0);
                return true;
            case 145:
                parcel.enforceInterface(IActivityManager.descriptor);
                UserInfo currentUser = getCurrentUser();
                parcel2.writeNoException();
                currentUser.writeToParcel(parcel2, 0);
                return true;
            case 146:
                parcel.enforceInterface(IActivityManager.descriptor);
                boolean shouldUpRecreateTask = shouldUpRecreateTask(parcel.readStrongBinder(), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeInt(shouldUpRecreateTask ? 1 : 0);
                return true;
            case 147:
                parcel.enforceInterface(IActivityManager.descriptor);
                IBinder readStrongBinder16 = parcel.readStrongBinder();
                Intent createFromParcel3 = Intent.CREATOR.createFromParcel(parcel);
                int readInt8 = parcel.readInt();
                Intent intent3 = null;
                if (parcel.readInt() != 0) {
                    intent3 = Intent.CREATOR.createFromParcel(parcel);
                }
                boolean navigateUpTo = navigateUpTo(readStrongBinder16, createFromParcel3, readInt8, intent3);
                parcel2.writeNoException();
                parcel2.writeInt(navigateUpTo ? 1 : 0);
                return true;
            case 148:
                parcel.enforceInterface(IActivityManager.descriptor);
                setLockScreenShown(parcel.readInt() != 0);
                parcel2.writeNoException();
                return true;
            case 149:
                parcel.enforceInterface(IActivityManager.descriptor);
                boolean finishActivityAffinity = finishActivityAffinity(parcel.readStrongBinder());
                parcel2.writeNoException();
                parcel2.writeInt(finishActivityAffinity ? 1 : 0);
                return true;
            case 150:
                parcel.enforceInterface(IActivityManager.descriptor);
                int launchedFromUid = getLaunchedFromUid(parcel.readStrongBinder());
                parcel2.writeNoException();
                parcel2.writeInt(launchedFromUid);
                return true;
            case 151:
                parcel.enforceInterface(IActivityManager.descriptor);
                unstableProviderDied(parcel.readStrongBinder());
                parcel2.writeNoException();
                return true;
            case 152:
                parcel.enforceInterface(IActivityManager.descriptor);
                boolean isIntentSenderAnActivity = isIntentSenderAnActivity(IIntentSender.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                parcel2.writeInt(isIntentSenderAnActivity ? 1 : 0);
                return true;
            case 153:
                parcel.enforceInterface(IActivityManager.descriptor);
                int startActivityAsUser = startActivityAsUser(ApplicationThreadNative.asInterface(parcel.readStrongBinder()), parcel.readString(), Intent.CREATOR.createFromParcel(parcel), parcel.readString(), parcel.readStrongBinder(), parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readInt() != 0 ? ProfilerInfo.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? Bundle.CREATOR.createFromParcel(parcel) : null, parcel.readInt());
                parcel2.writeNoException();
                parcel2.writeInt(startActivityAsUser);
                return true;
            case 154:
                parcel.enforceInterface(IActivityManager.descriptor);
                int stopUser = stopUser(parcel.readInt(), IStopUserCallback.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                parcel2.writeInt(stopUser);
                return true;
            case 155:
                parcel.enforceInterface(IActivityManager.descriptor);
                registerUserSwitchObserver(IUserSwitchObserver.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 156:
                parcel.enforceInterface(IActivityManager.descriptor);
                unregisterUserSwitchObserver(IUserSwitchObserver.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 157:
                parcel.enforceInterface(IActivityManager.descriptor);
                int[] runningUserIds = getRunningUserIds();
                parcel2.writeNoException();
                parcel2.writeIntArray(runningUserIds);
                return true;
            case 158:
                parcel.enforceInterface(IActivityManager.descriptor);
                requestBugReport();
                parcel2.writeNoException();
                return true;
            case 159:
                parcel.enforceInterface(IActivityManager.descriptor);
                long inputDispatchingTimedOut = inputDispatchingTimedOut(parcel.readInt(), parcel.readInt() != 0, parcel.readString());
                parcel2.writeNoException();
                parcel2.writeLong(inputDispatchingTimedOut);
                return true;
            case 161:
                parcel.enforceInterface(IActivityManager.descriptor);
                Intent intentForIntentSender = getIntentForIntentSender(IIntentSender.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                if (intentForIntentSender == null) {
                    parcel2.writeInt(0);
                    return true;
                }
                parcel2.writeInt(1);
                intentForIntentSender.writeToParcel(parcel2, 1);
                return true;
            case 162:
                parcel.enforceInterface(IActivityManager.descriptor);
                Bundle assistContextExtras = getAssistContextExtras(parcel.readInt());
                parcel2.writeNoException();
                parcel2.writeBundle(assistContextExtras);
                return true;
            case 163:
                parcel.enforceInterface(IActivityManager.descriptor);
                reportAssistContextExtras(parcel.readStrongBinder(), parcel.readBundle());
                parcel2.writeNoException();
                return true;
            case 164:
                parcel.enforceInterface(IActivityManager.descriptor);
                String launchedFromPackage = getLaunchedFromPackage(parcel.readStrongBinder());
                parcel2.writeNoException();
                parcel2.writeString(launchedFromPackage);
                return true;
            case 165:
                parcel.enforceInterface(IActivityManager.descriptor);
                killUid(parcel.readInt(), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 166:
                parcel.enforceInterface(IActivityManager.descriptor);
                setUserIsMonkey(parcel.readInt() == 1);
                parcel2.writeNoException();
                return true;
            case 167:
                parcel.enforceInterface(IActivityManager.descriptor);
                hang(parcel.readStrongBinder(), parcel.readInt() != 0);
                parcel2.writeNoException();
                return true;
            case 168:
                parcel.enforceInterface(IActivityManager.descriptor);
                IActivityContainer createActivityContainer = createActivityContainer(parcel.readStrongBinder(), IActivityContainerCallback.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                if (createActivityContainer == null) {
                    parcel2.writeInt(0);
                    return true;
                }
                parcel2.writeInt(1);
                parcel2.writeStrongBinder(createActivityContainer.asBinder());
                return true;
            case 169:
                parcel.enforceInterface(IActivityManager.descriptor);
                moveTaskToStack(parcel.readInt(), parcel.readInt(), parcel.readInt() != 0);
                parcel2.writeNoException();
                return true;
            case 170:
                parcel.enforceInterface(IActivityManager.descriptor);
                int readInt9 = parcel.readInt();
                parcel.readFloat();
                resizeStack(readInt9, Rect.CREATOR.createFromParcel(parcel));
                parcel2.writeNoException();
                return true;
            case 171:
                parcel.enforceInterface(IActivityManager.descriptor);
                List<ActivityManager.StackInfo> allStackInfos = getAllStackInfos();
                parcel2.writeNoException();
                parcel2.writeTypedList(allStackInfos);
                return true;
            case 172:
                parcel.enforceInterface(IActivityManager.descriptor);
                setFocusedStack(parcel.readInt());
                parcel2.writeNoException();
                return true;
            case 173:
                parcel.enforceInterface(IActivityManager.descriptor);
                ActivityManager.StackInfo stackInfo = getStackInfo(parcel.readInt());
                parcel2.writeNoException();
                if (stackInfo == null) {
                    parcel2.writeInt(0);
                    return true;
                }
                parcel2.writeInt(1);
                stackInfo.writeToParcel(parcel2, 0);
                return true;
            case 174:
                parcel.enforceInterface(IActivityManager.descriptor);
                boolean convertFromTranslucent = convertFromTranslucent(parcel.readStrongBinder());
                parcel2.writeNoException();
                parcel2.writeInt(convertFromTranslucent ? 1 : 0);
                return true;
            case 175:
                parcel.enforceInterface(IActivityManager.descriptor);
                IBinder readStrongBinder17 = parcel.readStrongBinder();
                Bundle readBundle2 = parcel.readInt() == 0 ? null : parcel.readBundle();
                boolean convertToTranslucent = convertToTranslucent(readStrongBinder17, readBundle2 == null ? null : new ActivityOptions(readBundle2));
                parcel2.writeNoException();
                parcel2.writeInt(convertToTranslucent ? 1 : 0);
                return true;
            case 176:
                parcel.enforceInterface(IActivityManager.descriptor);
                notifyActivityDrawn(parcel.readStrongBinder());
                parcel2.writeNoException();
                return true;
            case 177:
                parcel.enforceInterface(IActivityManager.descriptor);
                reportActivityFullyDrawn(parcel.readStrongBinder());
                parcel2.writeNoException();
                return true;
            case 178:
                parcel.enforceInterface(IActivityManager.descriptor);
                restart();
                parcel2.writeNoException();
                return true;
            case 179:
                parcel.enforceInterface(IActivityManager.descriptor);
                performIdleMaintenance();
                parcel2.writeNoException();
                return true;
            case 180:
                parcel.enforceInterface(IActivityManager.descriptor);
                takePersistableUriPermission(Uri.CREATOR.createFromParcel(parcel), parcel.readInt(), parcel.readInt());
                parcel2.writeNoException();
                return true;
            case 181:
                parcel.enforceInterface(IActivityManager.descriptor);
                releasePersistableUriPermission(Uri.CREATOR.createFromParcel(parcel), parcel.readInt(), parcel.readInt());
                parcel2.writeNoException();
                return true;
            case 182:
                parcel.enforceInterface(IActivityManager.descriptor);
                ParceledListSlice<UriPermission> persistedUriPermissions = getPersistedUriPermissions(parcel.readString(), parcel.readInt() != 0);
                parcel2.writeNoException();
                persistedUriPermissions.writeToParcel(parcel2, 1);
                return true;
            case 183:
                parcel.enforceInterface(IActivityManager.descriptor);
                appNotRespondingViaProvider(parcel.readStrongBinder());
                parcel2.writeNoException();
                return true;
            case 184:
                parcel.enforceInterface(IActivityManager.descriptor);
                IBinder homeActivityToken = getHomeActivityToken();
                parcel2.writeNoException();
                parcel2.writeStrongBinder(homeActivityToken);
                return true;
            case 185:
                parcel.enforceInterface(IActivityManager.descriptor);
                int activityDisplayId = getActivityDisplayId(parcel.readStrongBinder());
                parcel2.writeNoException();
                parcel2.writeInt(activityDisplayId);
                return true;
            case 186:
                parcel.enforceInterface(IActivityManager.descriptor);
                deleteActivityContainer(IActivityContainer.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 211:
                parcel.enforceInterface(IActivityManager.descriptor);
                String tagForIntentSender = getTagForIntentSender(IIntentSender.Stub.asInterface(parcel.readStrongBinder()), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeString(tagForIntentSender);
                return true;
            case 212:
                parcel.enforceInterface(IActivityManager.descriptor);
                boolean startUserInBackground = startUserInBackground(parcel.readInt());
                parcel2.writeNoException();
                parcel2.writeInt(startUserInBackground ? 1 : 0);
                return true;
            case 213:
                parcel.enforceInterface(IActivityManager.descriptor);
                boolean isInHomeStack = isInHomeStack(parcel.readInt());
                parcel2.writeNoException();
                parcel2.writeInt(isInHomeStack ? 1 : 0);
                return true;
            case 214:
                parcel.enforceInterface(IActivityManager.descriptor);
                startLockTaskMode(parcel.readInt());
                parcel2.writeNoException();
                return true;
            case 215:
                parcel.enforceInterface(IActivityManager.descriptor);
                startLockTaskMode(parcel.readStrongBinder());
                parcel2.writeNoException();
                return true;
            case 216:
                parcel.enforceInterface(IActivityManager.descriptor);
                stopLockTaskMode();
                parcel2.writeNoException();
                return true;
            case 217:
                parcel.enforceInterface(IActivityManager.descriptor);
                boolean isInLockTaskMode = isInLockTaskMode();
                parcel2.writeNoException();
                parcel2.writeInt(isInLockTaskMode ? 1 : 0);
                return true;
            case 218:
                parcel.enforceInterface(IActivityManager.descriptor);
                setTaskDescription(parcel.readStrongBinder(), ActivityManager.TaskDescription.CREATOR.createFromParcel(parcel));
                parcel2.writeNoException();
                return true;
            case 219:
                parcel.enforceInterface(IActivityManager.descriptor);
                int startVoiceActivity = startVoiceActivity(parcel.readString(), parcel.readInt(), parcel.readInt(), Intent.CREATOR.createFromParcel(parcel), parcel.readString(), IVoiceInteractionSession.Stub.asInterface(parcel.readStrongBinder()), IVoiceInteractor.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt() != 0 ? ProfilerInfo.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? Bundle.CREATOR.createFromParcel(parcel) : null, parcel.readInt());
                parcel2.writeNoException();
                parcel2.writeInt(startVoiceActivity);
                return true;
            case 220:
                parcel.enforceInterface(IActivityManager.descriptor);
                ActivityOptions activityOptions = getActivityOptions(parcel.readStrongBinder());
                parcel2.writeNoException();
                parcel2.writeBundle(activityOptions == null ? null : activityOptions.toBundle());
                return true;
            case 221:
                parcel.enforceInterface(IActivityManager.descriptor);
                List<IAppTask> appTasks = getAppTasks(parcel.readString());
                parcel2.writeNoException();
                int size3 = appTasks != null ? appTasks.size() : -1;
                parcel2.writeInt(size3);
                int i7 = 0;
                while (true) {
                    int i8 = i7;
                    if (i8 >= size3) {
                        return true;
                    }
                    parcel2.writeStrongBinder(appTasks.get(i8).asBinder());
                    i7 = i8 + 1;
                }
            case 222:
                parcel.enforceInterface(IActivityManager.descriptor);
                startLockTaskModeOnCurrent();
                parcel2.writeNoException();
                return true;
            case 223:
                parcel.enforceInterface(IActivityManager.descriptor);
                stopLockTaskModeOnCurrent();
                parcel2.writeNoException();
                return true;
            case 224:
                parcel.enforceInterface(IActivityManager.descriptor);
                finishVoiceTask(IVoiceInteractionSession.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 225:
                parcel.enforceInterface(IActivityManager.descriptor);
                boolean isTopOfTask = isTopOfTask(parcel.readStrongBinder());
                parcel2.writeNoException();
                parcel2.writeInt(isTopOfTask ? 1 : 0);
                return true;
            case 226:
                parcel.enforceInterface(IActivityManager.descriptor);
                boolean requestVisibleBehind = requestVisibleBehind(parcel.readStrongBinder(), parcel.readInt() > 0);
                parcel2.writeNoException();
                parcel2.writeInt(requestVisibleBehind ? 1 : 0);
                return true;
            case 227:
                parcel.enforceInterface(IActivityManager.descriptor);
                boolean isBackgroundVisibleBehind = isBackgroundVisibleBehind(parcel.readStrongBinder());
                parcel2.writeNoException();
                parcel2.writeInt(isBackgroundVisibleBehind ? 1 : 0);
                return true;
            case 228:
                parcel.enforceInterface(IActivityManager.descriptor);
                backgroundResourcesReleased(parcel.readStrongBinder());
                parcel2.writeNoException();
                return true;
            case 229:
                parcel.enforceInterface(IActivityManager.descriptor);
                notifyLaunchTaskBehindComplete(parcel.readStrongBinder());
                parcel2.writeNoException();
                return true;
            case 230:
                parcel.enforceInterface(IActivityManager.descriptor);
                int startActivityFromRecents = startActivityFromRecents(parcel.readInt(), parcel.readInt() == 0 ? null : Bundle.CREATOR.createFromParcel(parcel));
                parcel2.writeNoException();
                parcel2.writeInt(startActivityFromRecents);
                return true;
            case 231:
                parcel.enforceInterface(IActivityManager.descriptor);
                notifyEnterAnimationComplete(parcel.readStrongBinder());
                parcel2.writeNoException();
                return true;
            case 232:
                parcel.enforceInterface(IActivityManager.descriptor);
                keyguardWaitingForActivityDrawn();
                parcel2.writeNoException();
                return true;
            case 233:
                parcel.enforceInterface(IActivityManager.descriptor);
                int startActivityAsCaller = startActivityAsCaller(ApplicationThreadNative.asInterface(parcel.readStrongBinder()), parcel.readString(), Intent.CREATOR.createFromParcel(parcel), parcel.readString(), parcel.readStrongBinder(), parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readInt() != 0 ? ProfilerInfo.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? Bundle.CREATOR.createFromParcel(parcel) : null, parcel.readInt());
                parcel2.writeNoException();
                parcel2.writeInt(startActivityAsCaller);
                return true;
            case 234:
                parcel.enforceInterface(IActivityManager.descriptor);
                int addAppTask = addAppTask(parcel.readStrongBinder(), Intent.CREATOR.createFromParcel(parcel), ActivityManager.TaskDescription.CREATOR.createFromParcel(parcel), Bitmap.CREATOR.createFromParcel(parcel));
                parcel2.writeNoException();
                parcel2.writeInt(addAppTask);
                return true;
            case 235:
                parcel.enforceInterface(IActivityManager.descriptor);
                Point appTaskThumbnailSize = getAppTaskThumbnailSize();
                parcel2.writeNoException();
                appTaskThumbnailSize.writeToParcel(parcel2, 0);
                return true;
            case 236:
                parcel.enforceInterface(IActivityManager.descriptor);
                boolean releaseActivityInstance = releaseActivityInstance(parcel.readStrongBinder());
                parcel2.writeNoException();
                parcel2.writeInt(releaseActivityInstance ? 1 : 0);
                return true;
            case 237:
                parcel.enforceInterface(IActivityManager.descriptor);
                releaseSomeActivities(ApplicationThreadNative.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 238:
                parcel.enforceInterface(IActivityManager.descriptor);
                bootAnimationComplete();
                parcel2.writeNoException();
                return true;
            case 239:
                parcel.enforceInterface(IActivityManager.descriptor);
                Bitmap taskDescriptionIcon = getTaskDescriptionIcon(parcel.readString());
                parcel2.writeNoException();
                if (taskDescriptionIcon == null) {
                    parcel2.writeInt(0);
                    return true;
                }
                parcel2.writeInt(1);
                taskDescriptionIcon.writeToParcel(parcel2, 0);
                return true;
            case 240:
                parcel.enforceInterface(IActivityManager.descriptor);
                boolean launchAssistIntent = launchAssistIntent(Intent.CREATOR.createFromParcel(parcel), parcel.readInt(), parcel.readString(), parcel.readInt());
                parcel2.writeNoException();
                parcel2.writeInt(launchAssistIntent ? 1 : 0);
                return true;
            case 241:
                parcel.enforceInterface(IActivityManager.descriptor);
                Bundle readBundle3 = parcel.readInt() == 0 ? null : parcel.readBundle();
                startInPlaceAnimationOnFrontMostApplication(readBundle3 == null ? null : new ActivityOptions(readBundle3));
                parcel2.writeNoException();
                return true;
            case 242:
                parcel.enforceInterface(IActivityManager.descriptor);
                int checkPermissionWithToken = checkPermissionWithToken(parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readStrongBinder());
                parcel2.writeNoException();
                parcel2.writeInt(checkPermissionWithToken);
                return true;
            case 243:
                parcel.enforceInterface(IActivityManager.descriptor);
                registerTaskStackListener(ITaskStackListener.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 244:
                parcel.enforceInterface(IActivityManager.descriptor);
                systemBackupRestored();
                parcel2.writeNoException();
                return true;
            case 245:
                parcel.enforceInterface(IActivityManager.descriptor);
                String callingPackageForBroadcast = getCallingPackageForBroadcast(parcel.readInt() == 1);
                parcel2.writeNoException();
                parcel2.writeString(callingPackageForBroadcast);
                return true;
        }
    }
}
