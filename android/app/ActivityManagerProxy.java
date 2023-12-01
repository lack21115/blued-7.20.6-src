package android.app;

import android.app.ActivityManager;
import android.app.ApplicationErrorReport;
import android.app.IActivityContainer;
import android.app.IActivityManager;
import android.app.IAppTask;
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
import android.os.Bundle;
import android.os.Debug;
import android.os.IBinder;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.PersistableBundle;
import android.os.RemoteException;
import android.os.StrictMode;
import android.os.SystemClock;
import android.service.voice.IVoiceInteractionSession;
import android.text.TextUtils;
import android.util.Log;
import com.android.internal.app.IVoiceInteractor;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-9557208-dex2jar.jar:android/app/ActivityManagerProxy.class */
public class ActivityManagerProxy implements IActivityManager {
    static final String TAG_TIMELINE = "Timeline";
    private IBinder mRemote;

    public ActivityManagerProxy(IBinder iBinder) {
        this.mRemote = iBinder;
    }

    @Override // android.app.IActivityManager
    public void activityDestroyed(IBinder iBinder) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        obtain.writeStrongBinder(iBinder);
        this.mRemote.transact(62, obtain, obtain2, 1);
        obtain2.readException();
        obtain.recycle();
        obtain2.recycle();
    }

    @Override // android.app.IActivityManager
    public void activityIdle(IBinder iBinder, Configuration configuration, boolean z) throws RemoteException {
        int i = 0;
        Log.i(TAG_TIMELINE, "Timeline: Activity_idle id: " + iBinder + " time:" + SystemClock.uptimeMillis());
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        obtain.writeStrongBinder(iBinder);
        if (configuration != null) {
            obtain.writeInt(1);
            configuration.writeToParcel(obtain, 0);
        } else {
            obtain.writeInt(0);
        }
        if (z) {
            i = 1;
        }
        obtain.writeInt(i);
        this.mRemote.transact(18, obtain, obtain2, 1);
        obtain2.readException();
        obtain.recycle();
        obtain2.recycle();
    }

    @Override // android.app.IActivityManager
    public void activityPaused(IBinder iBinder) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        obtain.writeStrongBinder(iBinder);
        this.mRemote.transact(19, obtain, obtain2, 0);
        obtain2.readException();
        obtain.recycle();
        obtain2.recycle();
    }

    @Override // android.app.IActivityManager
    public void activityResumed(IBinder iBinder) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        obtain.writeStrongBinder(iBinder);
        this.mRemote.transact(39, obtain, obtain2, 0);
        obtain2.readException();
        obtain.recycle();
        obtain2.recycle();
    }

    @Override // android.app.IActivityManager
    public void activitySlept(IBinder iBinder) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        obtain.writeStrongBinder(iBinder);
        this.mRemote.transact(123, obtain, obtain2, 1);
        obtain2.readException();
        obtain.recycle();
        obtain2.recycle();
    }

    @Override // android.app.IActivityManager
    public void activityStopped(IBinder iBinder, Bundle bundle, PersistableBundle persistableBundle, CharSequence charSequence) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        obtain.writeStrongBinder(iBinder);
        obtain.writeBundle(bundle);
        obtain.writePersistableBundle(persistableBundle);
        TextUtils.writeToParcel(charSequence, obtain, 0);
        this.mRemote.transact(20, obtain, obtain2, 1);
        obtain2.readException();
        obtain.recycle();
        obtain2.recycle();
    }

    @Override // android.app.IActivityManager
    public int addAppTask(IBinder iBinder, Intent intent, ActivityManager.TaskDescription taskDescription, Bitmap bitmap) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        obtain.writeStrongBinder(iBinder);
        intent.writeToParcel(obtain, 0);
        taskDescription.writeToParcel(obtain, 0);
        bitmap.writeToParcel(obtain, 0);
        this.mRemote.transact(234, obtain, obtain2, 0);
        obtain2.readException();
        int readInt = obtain2.readInt();
        obtain.recycle();
        obtain2.recycle();
        return readInt;
    }

    @Override // android.app.IActivityManager
    public void addPackageDependency(String str) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        obtain.writeString(str);
        this.mRemote.transact(95, obtain, obtain2, 0);
        obtain2.readException();
        obtain.recycle();
        obtain2.recycle();
    }

    @Override // android.app.IActivityManager
    public void appNotRespondingViaProvider(IBinder iBinder) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        obtain.writeStrongBinder(iBinder);
        this.mRemote.transact(183, obtain, obtain2, 0);
        obtain2.readException();
        obtain.recycle();
        obtain2.recycle();
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.mRemote;
    }

    @Override // android.app.IActivityManager
    public void attachApplication(IApplicationThread iApplicationThread) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        obtain.writeStrongBinder(iApplicationThread.asBinder());
        this.mRemote.transact(17, obtain, obtain2, 0);
        obtain2.readException();
        obtain.recycle();
        obtain2.recycle();
    }

    @Override // android.app.IActivityManager
    public void backgroundResourcesReleased(IBinder iBinder) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        obtain.writeStrongBinder(iBinder);
        this.mRemote.transact(228, obtain, obtain2, 1);
        obtain2.readException();
        obtain.recycle();
        obtain2.recycle();
    }

    @Override // android.app.IActivityManager
    public void backupAgentCreated(String str, IBinder iBinder) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        obtain.writeString(str);
        obtain.writeStrongBinder(iBinder);
        this.mRemote.transact(91, obtain, obtain2, 0);
        obtain2.recycle();
        obtain.recycle();
    }

    @Override // android.app.IActivityManager
    public boolean bindBackupAgent(ApplicationInfo applicationInfo, int i) throws RemoteException {
        boolean z = false;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        applicationInfo.writeToParcel(obtain, 0);
        obtain.writeInt(i);
        this.mRemote.transact(90, obtain, obtain2, 0);
        obtain2.readException();
        if (obtain2.readInt() != 0) {
            z = true;
        }
        obtain2.recycle();
        obtain.recycle();
        return z;
    }

    @Override // android.app.IActivityManager
    public int bindService(IApplicationThread iApplicationThread, IBinder iBinder, Intent intent, String str, IServiceConnection iServiceConnection, int i, int i2) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        obtain.writeStrongBinder(iApplicationThread != null ? iApplicationThread.asBinder() : null);
        obtain.writeStrongBinder(iBinder);
        intent.writeToParcel(obtain, 0);
        obtain.writeString(str);
        obtain.writeStrongBinder(iServiceConnection.asBinder());
        obtain.writeInt(i);
        obtain.writeInt(i2);
        this.mRemote.transact(36, obtain, obtain2, 0);
        obtain2.readException();
        int readInt = obtain2.readInt();
        obtain.recycle();
        obtain2.recycle();
        return readInt;
    }

    @Override // android.app.IActivityManager
    public void bootAnimationComplete() throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        this.mRemote.transact(238, obtain, obtain2, 0);
        obtain2.readException();
        obtain.recycle();
        obtain2.recycle();
    }

    @Override // android.app.IActivityManager
    public int broadcastIntent(IApplicationThread iApplicationThread, Intent intent, String str, IIntentReceiver iIntentReceiver, int i, String str2, Bundle bundle, String str3, int i2, boolean z, boolean z2, int i3) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        obtain.writeStrongBinder(iApplicationThread != null ? iApplicationThread.asBinder() : null);
        intent.writeToParcel(obtain, 0);
        obtain.writeString(str);
        obtain.writeStrongBinder(iIntentReceiver != null ? iIntentReceiver.asBinder() : null);
        obtain.writeInt(i);
        obtain.writeString(str2);
        obtain.writeBundle(bundle);
        obtain.writeString(str3);
        obtain.writeInt(i2);
        obtain.writeInt(z ? 1 : 0);
        obtain.writeInt(z2 ? 1 : 0);
        obtain.writeInt(i3);
        this.mRemote.transact(14, obtain, obtain2, 0);
        obtain2.readException();
        int readInt = obtain2.readInt();
        obtain2.recycle();
        obtain.recycle();
        return readInt;
    }

    @Override // android.app.IActivityManager
    public void cancelIntentSender(IIntentSender iIntentSender) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        obtain.writeStrongBinder(iIntentSender.asBinder());
        this.mRemote.transact(64, obtain, obtain2, 0);
        obtain2.readException();
        obtain.recycle();
        obtain2.recycle();
    }

    @Override // android.app.IActivityManager
    public int checkGrantUriPermission(int i, String str, Uri uri, int i2, int i3) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        obtain.writeInt(i);
        obtain.writeString(str);
        uri.writeToParcel(obtain, 0);
        obtain.writeInt(i2);
        obtain.writeInt(i3);
        this.mRemote.transact(119, obtain, obtain2, 0);
        obtain2.readException();
        int readInt = obtain2.readInt();
        obtain.recycle();
        obtain2.recycle();
        return readInt;
    }

    @Override // android.app.IActivityManager
    public int checkPermission(String str, int i, int i2) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        obtain.writeString(str);
        obtain.writeInt(i);
        obtain.writeInt(i2);
        this.mRemote.transact(53, obtain, obtain2, 0);
        obtain2.readException();
        int readInt = obtain2.readInt();
        obtain.recycle();
        obtain2.recycle();
        return readInt;
    }

    @Override // android.app.IActivityManager
    public int checkPermissionWithToken(String str, int i, int i2, IBinder iBinder) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        obtain.writeString(str);
        obtain.writeInt(i);
        obtain.writeInt(i2);
        obtain.writeStrongBinder(iBinder);
        this.mRemote.transact(242, obtain, obtain2, 0);
        obtain2.readException();
        int readInt = obtain2.readInt();
        obtain.recycle();
        obtain2.recycle();
        return readInt;
    }

    @Override // android.app.IActivityManager
    public int checkUriPermission(Uri uri, int i, int i2, int i3, int i4, IBinder iBinder) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        uri.writeToParcel(obtain, 0);
        obtain.writeInt(i);
        obtain.writeInt(i2);
        obtain.writeInt(i3);
        obtain.writeInt(i4);
        obtain.writeStrongBinder(iBinder);
        this.mRemote.transact(54, obtain, obtain2, 0);
        obtain2.readException();
        int readInt = obtain2.readInt();
        obtain.recycle();
        obtain2.recycle();
        return readInt;
    }

    @Override // android.app.IActivityManager
    public boolean clearApplicationUserData(String str, IPackageDataObserver iPackageDataObserver, int i) throws RemoteException {
        boolean z = false;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        obtain.writeString(str);
        obtain.writeStrongBinder(iPackageDataObserver != null ? iPackageDataObserver.asBinder() : null);
        obtain.writeInt(i);
        this.mRemote.transact(78, obtain, obtain2, 0);
        obtain2.readException();
        if (obtain2.readInt() != 0) {
            z = true;
        }
        obtain.recycle();
        obtain2.recycle();
        return z;
    }

    @Override // android.app.IActivityManager
    public void clearPendingBackup() throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        this.mRemote.transact(160, obtain, obtain2, 0);
        obtain2.recycle();
        obtain.recycle();
    }

    @Override // android.app.IActivityManager
    public void closeSystemDialogs(String str) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        obtain.writeString(str);
        this.mRemote.transact(97, obtain, obtain2, 0);
        obtain2.readException();
        obtain.recycle();
        obtain2.recycle();
    }

    @Override // android.app.IActivityManager
    public boolean convertFromTranslucent(IBinder iBinder) throws RemoteException {
        boolean z = false;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        obtain.writeStrongBinder(iBinder);
        this.mRemote.transact(174, obtain, obtain2, 0);
        obtain2.readException();
        if (obtain2.readInt() != 0) {
            z = true;
        }
        obtain.recycle();
        obtain2.recycle();
        return z;
    }

    @Override // android.app.IActivityManager
    public boolean convertToTranslucent(IBinder iBinder, ActivityOptions activityOptions) throws RemoteException {
        boolean z = true;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        obtain.writeStrongBinder(iBinder);
        if (activityOptions == null) {
            obtain.writeInt(0);
        } else {
            obtain.writeInt(1);
            obtain.writeBundle(activityOptions.toBundle());
        }
        this.mRemote.transact(175, obtain, obtain2, 0);
        obtain2.readException();
        if (obtain2.readInt() == 0) {
            z = false;
        }
        obtain.recycle();
        obtain2.recycle();
        return z;
    }

    @Override // android.app.IActivityManager
    public void crashApplication(int i, int i2, String str, String str2) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        obtain.writeInt(i);
        obtain.writeInt(i2);
        obtain.writeString(str);
        obtain.writeString(str2);
        this.mRemote.transact(114, obtain, obtain2, 0);
        obtain2.readException();
        obtain.recycle();
        obtain2.recycle();
    }

    @Override // android.app.IActivityManager
    public IActivityContainer createActivityContainer(IBinder iBinder, IActivityContainerCallback iActivityContainerCallback) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        obtain.writeStrongBinder(iBinder);
        obtain.writeStrongBinder(iActivityContainerCallback == null ? null : iActivityContainerCallback.asBinder());
        this.mRemote.transact(168, obtain, obtain2, 0);
        obtain2.readException();
        IActivityContainer asInterface = obtain2.readInt() == 1 ? IActivityContainer.Stub.asInterface(obtain2.readStrongBinder()) : null;
        obtain.recycle();
        obtain2.recycle();
        return asInterface;
    }

    @Override // android.app.IActivityManager
    public void deleteActivityContainer(IActivityContainer iActivityContainer) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        obtain.writeStrongBinder(iActivityContainer.asBinder());
        this.mRemote.transact(186, obtain, obtain2, 0);
        obtain2.readException();
        obtain.recycle();
        obtain2.recycle();
    }

    @Override // android.app.IActivityManager
    public boolean dumpHeap(String str, int i, boolean z, String str2, ParcelFileDescriptor parcelFileDescriptor) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        obtain.writeString(str);
        obtain.writeInt(i);
        obtain.writeInt(z ? 1 : 0);
        obtain.writeString(str2);
        if (parcelFileDescriptor != null) {
            obtain.writeInt(1);
            parcelFileDescriptor.writeToParcel(obtain, 1);
        } else {
            obtain.writeInt(0);
        }
        this.mRemote.transact(120, obtain, obtain2, 0);
        obtain2.readException();
        boolean z2 = obtain2.readInt() != 0;
        obtain2.recycle();
        obtain.recycle();
        return z2;
    }

    @Override // android.app.IActivityManager
    public void enterSafeMode() throws RemoteException {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        this.mRemote.transact(66, obtain, null, 0);
        obtain.recycle();
    }

    @Override // android.app.IActivityManager
    public boolean finishActivity(IBinder iBinder, int i, Intent intent, boolean z) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        obtain.writeStrongBinder(iBinder);
        obtain.writeInt(i);
        if (intent != null) {
            obtain.writeInt(1);
            intent.writeToParcel(obtain, 0);
        } else {
            obtain.writeInt(0);
        }
        obtain.writeInt(z ? 1 : 0);
        this.mRemote.transact(11, obtain, obtain2, 0);
        obtain2.readException();
        boolean z2 = obtain2.readInt() != 0;
        obtain.recycle();
        obtain2.recycle();
        return z2;
    }

    @Override // android.app.IActivityManager
    public boolean finishActivityAffinity(IBinder iBinder) throws RemoteException {
        boolean z = false;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        obtain.writeStrongBinder(iBinder);
        this.mRemote.transact(149, obtain, obtain2, 0);
        obtain2.readException();
        if (obtain2.readInt() != 0) {
            z = true;
        }
        obtain.recycle();
        obtain2.recycle();
        return z;
    }

    @Override // android.app.IActivityManager
    public void finishHeavyWeightApp() throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        this.mRemote.transact(109, obtain, obtain2, 0);
        obtain2.readException();
        obtain.recycle();
        obtain2.recycle();
    }

    @Override // android.app.IActivityManager
    public void finishInstrumentation(IApplicationThread iApplicationThread, int i, Bundle bundle) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        obtain.writeStrongBinder(iApplicationThread != null ? iApplicationThread.asBinder() : null);
        obtain.writeInt(i);
        obtain.writeBundle(bundle);
        this.mRemote.transact(45, obtain, obtain2, 0);
        obtain2.readException();
        obtain.recycle();
        obtain2.recycle();
    }

    @Override // android.app.IActivityManager
    public void finishReceiver(IBinder iBinder, int i, String str, Bundle bundle, boolean z, int i2) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        obtain.writeStrongBinder(iBinder);
        obtain.writeInt(i);
        obtain.writeString(str);
        obtain.writeBundle(bundle);
        obtain.writeInt(z ? 1 : 0);
        obtain.writeInt(i2);
        this.mRemote.transact(16, obtain, obtain2, 1);
        obtain2.readException();
        obtain.recycle();
        obtain2.recycle();
    }

    @Override // android.app.IActivityManager
    public void finishSubActivity(IBinder iBinder, String str, int i) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        obtain.writeStrongBinder(iBinder);
        obtain.writeString(str);
        obtain.writeInt(i);
        this.mRemote.transact(32, obtain, obtain2, 0);
        obtain2.readException();
        obtain.recycle();
        obtain2.recycle();
    }

    @Override // android.app.IActivityManager
    public void finishVoiceTask(IVoiceInteractionSession iVoiceInteractionSession) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        obtain.writeStrongBinder(iVoiceInteractionSession.asBinder());
        this.mRemote.transact(224, obtain, obtain2, 0);
        obtain2.readException();
        obtain.recycle();
        obtain2.recycle();
    }

    @Override // android.app.IActivityManager
    public void forceStopPackage(String str, int i) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        obtain.writeString(str);
        obtain.writeInt(i);
        this.mRemote.transact(79, obtain, obtain2, 0);
        obtain2.readException();
        obtain.recycle();
        obtain2.recycle();
    }

    @Override // android.app.IActivityManager
    public ComponentName getActivityClassForToken(IBinder iBinder) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        obtain.writeStrongBinder(iBinder);
        this.mRemote.transact(49, obtain, obtain2, 0);
        obtain2.readException();
        ComponentName readFromParcel = ComponentName.readFromParcel(obtain2);
        obtain.recycle();
        obtain2.recycle();
        return readFromParcel;
    }

    @Override // android.app.IActivityManager
    public int getActivityDisplayId(IBinder iBinder) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        obtain.writeStrongBinder(iBinder);
        this.mRemote.transact(185, obtain, obtain2, 0);
        obtain2.readException();
        int readInt = obtain2.readInt();
        obtain.recycle();
        obtain2.recycle();
        return readInt;
    }

    @Override // android.app.IActivityManager
    public ActivityOptions getActivityOptions(IBinder iBinder) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        obtain.writeStrongBinder(iBinder);
        this.mRemote.transact(220, obtain, obtain2, 0);
        obtain2.readException();
        Bundle readBundle = obtain2.readBundle();
        ActivityOptions activityOptions = readBundle == null ? null : new ActivityOptions(readBundle);
        obtain.recycle();
        obtain2.recycle();
        return activityOptions;
    }

    @Override // android.app.IActivityManager
    public List<ActivityManager.StackInfo> getAllStackInfos() throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        this.mRemote.transact(171, obtain, obtain2, 0);
        obtain2.readException();
        ArrayList createTypedArrayList = obtain2.createTypedArrayList(ActivityManager.StackInfo.CREATOR);
        obtain.recycle();
        obtain2.recycle();
        return createTypedArrayList;
    }

    @Override // android.app.IActivityManager
    public Point getAppTaskThumbnailSize() throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        this.mRemote.transact(235, obtain, obtain2, 0);
        obtain2.readException();
        Point createFromParcel = Point.CREATOR.createFromParcel(obtain2);
        obtain.recycle();
        obtain2.recycle();
        return createFromParcel;
    }

    @Override // android.app.IActivityManager
    public List<IAppTask> getAppTasks(String str) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        obtain.writeString(str);
        this.mRemote.transact(221, obtain, obtain2, 0);
        obtain2.readException();
        ArrayList arrayList = null;
        int readInt = obtain2.readInt();
        if (readInt >= 0) {
            ArrayList arrayList2 = new ArrayList();
            while (true) {
                arrayList = arrayList2;
                if (readInt <= 0) {
                    break;
                }
                arrayList2.add(IAppTask.Stub.asInterface(obtain2.readStrongBinder()));
                readInt--;
            }
        }
        obtain.recycle();
        obtain2.recycle();
        return arrayList;
    }

    @Override // android.app.IActivityManager
    public Bundle getAssistContextExtras(int i) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        obtain.writeInt(i);
        this.mRemote.transact(162, obtain, obtain2, 0);
        obtain2.readException();
        Bundle readBundle = obtain2.readBundle();
        obtain.recycle();
        obtain2.recycle();
        return readBundle;
    }

    @Override // android.app.IActivityManager
    public ComponentName getCallingActivity(IBinder iBinder) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        obtain.writeStrongBinder(iBinder);
        this.mRemote.transact(22, obtain, obtain2, 0);
        obtain2.readException();
        ComponentName readFromParcel = ComponentName.readFromParcel(obtain2);
        obtain.recycle();
        obtain2.recycle();
        return readFromParcel;
    }

    @Override // android.app.IActivityManager
    public String getCallingPackage(IBinder iBinder) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        obtain.writeStrongBinder(iBinder);
        this.mRemote.transact(21, obtain, obtain2, 0);
        obtain2.readException();
        String readString = obtain2.readString();
        obtain.recycle();
        obtain2.recycle();
        return readString;
    }

    @Override // android.app.IActivityManager
    public String getCallingPackageForBroadcast(boolean z) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        obtain.writeInt(z ? 1 : 0);
        this.mRemote.transact(245, obtain, obtain2, 0);
        obtain2.readException();
        String readString = obtain2.readString();
        obtain.recycle();
        obtain2.recycle();
        return readString;
    }

    @Override // android.app.IActivityManager
    public Configuration getConfiguration() throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        this.mRemote.transact(46, obtain, obtain2, 0);
        obtain2.readException();
        Configuration createFromParcel = Configuration.CREATOR.createFromParcel(obtain2);
        obtain2.recycle();
        obtain.recycle();
        return createFromParcel;
    }

    @Override // android.app.IActivityManager
    public IActivityManager.ContentProviderHolder getContentProvider(IApplicationThread iApplicationThread, String str, int i, boolean z) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        obtain.writeStrongBinder(iApplicationThread != null ? iApplicationThread.asBinder() : null);
        obtain.writeString(str);
        obtain.writeInt(i);
        obtain.writeInt(z ? 1 : 0);
        this.mRemote.transact(29, obtain, obtain2, 0);
        obtain2.readException();
        IActivityManager.ContentProviderHolder contentProviderHolder = null;
        if (obtain2.readInt() != 0) {
            contentProviderHolder = IActivityManager.ContentProviderHolder.CREATOR.createFromParcel(obtain2);
        }
        obtain.recycle();
        obtain2.recycle();
        return contentProviderHolder;
    }

    @Override // android.app.IActivityManager
    public IActivityManager.ContentProviderHolder getContentProviderExternal(String str, int i, IBinder iBinder) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        obtain.writeString(str);
        obtain.writeInt(i);
        obtain.writeStrongBinder(iBinder);
        this.mRemote.transact(141, obtain, obtain2, 0);
        obtain2.readException();
        IActivityManager.ContentProviderHolder contentProviderHolder = null;
        if (obtain2.readInt() != 0) {
            contentProviderHolder = IActivityManager.ContentProviderHolder.CREATOR.createFromParcel(obtain2);
        }
        obtain.recycle();
        obtain2.recycle();
        return contentProviderHolder;
    }

    @Override // android.app.IActivityManager
    public UserInfo getCurrentUser() throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        this.mRemote.transact(145, obtain, obtain2, 0);
        obtain2.readException();
        UserInfo createFromParcel = UserInfo.CREATOR.createFromParcel(obtain2);
        obtain2.recycle();
        obtain.recycle();
        return createFromParcel;
    }

    @Override // android.app.IActivityManager
    public ConfigurationInfo getDeviceConfigurationInfo() throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        this.mRemote.transact(84, obtain, obtain2, 0);
        obtain2.readException();
        ConfigurationInfo createFromParcel = ConfigurationInfo.CREATOR.createFromParcel(obtain2);
        obtain2.recycle();
        obtain.recycle();
        return createFromParcel;
    }

    @Override // android.app.IActivityManager
    public int getFrontActivityScreenCompatMode() throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        this.mRemote.transact(124, obtain, obtain2, 0);
        obtain2.readException();
        int readInt = obtain2.readInt();
        obtain2.recycle();
        obtain.recycle();
        return readInt;
    }

    @Override // android.app.IActivityManager
    public IBinder getHomeActivityToken() throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        this.mRemote.transact(184, obtain, obtain2, 0);
        obtain2.readException();
        IBinder readStrongBinder = obtain2.readStrongBinder();
        obtain.recycle();
        obtain2.recycle();
        return readStrongBinder;
    }

    @Override // android.app.IActivityManager
    public Intent getIntentForIntentSender(IIntentSender iIntentSender) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        obtain.writeStrongBinder(iIntentSender.asBinder());
        this.mRemote.transact(161, obtain, obtain2, 0);
        obtain2.readException();
        Intent createFromParcel = obtain2.readInt() != 0 ? Intent.CREATOR.createFromParcel(obtain2) : null;
        obtain.recycle();
        obtain2.recycle();
        return createFromParcel;
    }

    @Override // android.app.IActivityManager
    public IIntentSender getIntentSender(int i, String str, IBinder iBinder, String str2, int i2, Intent[] intentArr, String[] strArr, int i3, Bundle bundle, int i4) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        obtain.writeInt(i);
        obtain.writeString(str);
        obtain.writeStrongBinder(iBinder);
        obtain.writeString(str2);
        obtain.writeInt(i2);
        if (intentArr != null) {
            obtain.writeInt(1);
            obtain.writeTypedArray(intentArr, 0);
            obtain.writeStringArray(strArr);
        } else {
            obtain.writeInt(0);
        }
        obtain.writeInt(i3);
        if (bundle != null) {
            obtain.writeInt(1);
            bundle.writeToParcel(obtain, 0);
        } else {
            obtain.writeInt(0);
        }
        obtain.writeInt(i4);
        this.mRemote.transact(63, obtain, obtain2, 0);
        obtain2.readException();
        IIntentSender asInterface = IIntentSender.Stub.asInterface(obtain2.readStrongBinder());
        obtain.recycle();
        obtain2.recycle();
        return asInterface;
    }

    @Override // android.app.IActivityManager
    public String getLaunchedFromPackage(IBinder iBinder) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        obtain.writeStrongBinder(iBinder);
        this.mRemote.transact(164, obtain, obtain2, 0);
        obtain2.readException();
        String readString = obtain2.readString();
        obtain.recycle();
        obtain2.recycle();
        return readString;
    }

    @Override // android.app.IActivityManager
    public int getLaunchedFromUid(IBinder iBinder) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        obtain.writeStrongBinder(iBinder);
        this.mRemote.transact(150, obtain, obtain2, 0);
        obtain2.readException();
        int readInt = obtain2.readInt();
        obtain.recycle();
        obtain2.recycle();
        return readInt;
    }

    @Override // android.app.IActivityManager
    public void getMemoryInfo(ActivityManager.MemoryInfo memoryInfo) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        this.mRemote.transact(76, obtain, obtain2, 0);
        obtain2.readException();
        memoryInfo.readFromParcel(obtain2);
        obtain.recycle();
        obtain2.recycle();
    }

    @Override // android.app.IActivityManager
    public void getMyMemoryState(ActivityManager.RunningAppProcessInfo runningAppProcessInfo) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        this.mRemote.transact(143, obtain, obtain2, 0);
        obtain2.readException();
        runningAppProcessInfo.readFromParcel(obtain2);
        obtain2.recycle();
        obtain.recycle();
    }

    @Override // android.app.IActivityManager
    public boolean getPackageAskScreenCompat(String str) throws RemoteException {
        boolean z = false;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        obtain.writeString(str);
        this.mRemote.transact(128, obtain, obtain2, 0);
        obtain2.readException();
        if (obtain2.readInt() != 0) {
            z = true;
        }
        obtain2.recycle();
        obtain.recycle();
        return z;
    }

    @Override // android.app.IActivityManager
    public String getPackageForIntentSender(IIntentSender iIntentSender) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        obtain.writeStrongBinder(iIntentSender.asBinder());
        this.mRemote.transact(65, obtain, obtain2, 0);
        obtain2.readException();
        String readString = obtain2.readString();
        obtain.recycle();
        obtain2.recycle();
        return readString;
    }

    @Override // android.app.IActivityManager
    public String getPackageForToken(IBinder iBinder) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        obtain.writeStrongBinder(iBinder);
        this.mRemote.transact(50, obtain, obtain2, 0);
        obtain2.readException();
        String readString = obtain2.readString();
        obtain.recycle();
        obtain2.recycle();
        return readString;
    }

    @Override // android.app.IActivityManager
    public int getPackageScreenCompatMode(String str) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        obtain.writeString(str);
        this.mRemote.transact(126, obtain, obtain2, 0);
        obtain2.readException();
        int readInt = obtain2.readInt();
        obtain2.recycle();
        obtain.recycle();
        return readInt;
    }

    @Override // android.app.IActivityManager
    public ParceledListSlice<UriPermission> getPersistedUriPermissions(String str, boolean z) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        obtain.writeString(str);
        obtain.writeInt(z ? 1 : 0);
        this.mRemote.transact(182, obtain, obtain2, 0);
        obtain2.readException();
        ParceledListSlice<UriPermission> createFromParcel = ParceledListSlice.CREATOR.createFromParcel(obtain2);
        obtain.recycle();
        obtain2.recycle();
        return createFromParcel;
    }

    @Override // android.app.IActivityManager
    public int getProcessLimit() throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        this.mRemote.transact(52, obtain, obtain2, 0);
        obtain2.readException();
        int readInt = obtain2.readInt();
        obtain.recycle();
        obtain2.recycle();
        return readInt;
    }

    @Override // android.app.IActivityManager
    public Debug.MemoryInfo[] getProcessMemoryInfo(int[] iArr) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        obtain.writeIntArray(iArr);
        this.mRemote.transact(98, obtain, obtain2, 0);
        obtain2.readException();
        Debug.MemoryInfo[] memoryInfoArr = (Debug.MemoryInfo[]) obtain2.createTypedArray(Debug.MemoryInfo.CREATOR);
        obtain.recycle();
        obtain2.recycle();
        return memoryInfoArr;
    }

    @Override // android.app.IActivityManager
    public long[] getProcessPss(int[] iArr) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        obtain.writeIntArray(iArr);
        this.mRemote.transact(137, obtain, obtain2, 0);
        obtain2.readException();
        long[] createLongArray = obtain2.createLongArray();
        obtain.recycle();
        obtain2.recycle();
        return createLongArray;
    }

    @Override // android.app.IActivityManager
    public List<ActivityManager.ProcessErrorStateInfo> getProcessesInErrorState() throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        this.mRemote.transact(77, obtain, obtain2, 0);
        obtain2.readException();
        ArrayList createTypedArrayList = obtain2.createTypedArrayList(ActivityManager.ProcessErrorStateInfo.CREATOR);
        obtain.recycle();
        obtain2.recycle();
        return createTypedArrayList;
    }

    @Override // android.app.IActivityManager
    public String getProviderMimeType(Uri uri, int i) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        uri.writeToParcel(obtain, 0);
        obtain.writeInt(i);
        this.mRemote.transact(115, obtain, obtain2, 0);
        obtain2.readException();
        String readString = obtain2.readString();
        obtain.recycle();
        obtain2.recycle();
        return readString;
    }

    @Override // android.app.IActivityManager
    public List<ActivityManager.RecentTaskInfo> getRecentTasks(int i, int i2, int i3) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        obtain.writeInt(i);
        obtain.writeInt(i2);
        obtain.writeInt(i3);
        this.mRemote.transact(60, obtain, obtain2, 0);
        obtain2.readException();
        ArrayList createTypedArrayList = obtain2.createTypedArrayList(ActivityManager.RecentTaskInfo.CREATOR);
        obtain.recycle();
        obtain2.recycle();
        return createTypedArrayList;
    }

    @Override // android.app.IActivityManager
    public int getRequestedOrientation(IBinder iBinder) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        obtain.writeStrongBinder(iBinder);
        this.mRemote.transact(71, obtain, obtain2, 0);
        obtain2.readException();
        int readInt = obtain2.readInt();
        obtain.recycle();
        obtain2.recycle();
        return readInt;
    }

    @Override // android.app.IActivityManager
    public List<ActivityManager.RunningAppProcessInfo> getRunningAppProcesses() throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        this.mRemote.transact(83, obtain, obtain2, 0);
        obtain2.readException();
        ArrayList createTypedArrayList = obtain2.createTypedArrayList(ActivityManager.RunningAppProcessInfo.CREATOR);
        obtain.recycle();
        obtain2.recycle();
        return createTypedArrayList;
    }

    @Override // android.app.IActivityManager
    public List<ApplicationInfo> getRunningExternalApplications() throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        this.mRemote.transact(108, obtain, obtain2, 0);
        obtain2.readException();
        ArrayList createTypedArrayList = obtain2.createTypedArrayList(ApplicationInfo.CREATOR);
        obtain.recycle();
        obtain2.recycle();
        return createTypedArrayList;
    }

    @Override // android.app.IActivityManager
    public PendingIntent getRunningServiceControlPanel(ComponentName componentName) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        componentName.writeToParcel(obtain, 0);
        this.mRemote.transact(33, obtain, obtain2, 0);
        obtain2.readException();
        PendingIntent readPendingIntentOrNullFromParcel = PendingIntent.readPendingIntentOrNullFromParcel(obtain2);
        obtain.recycle();
        obtain2.recycle();
        return readPendingIntentOrNullFromParcel;
    }

    @Override // android.app.IActivityManager
    public int[] getRunningUserIds() throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        this.mRemote.transact(157, obtain, obtain2, 0);
        obtain2.readException();
        int[] createIntArray = obtain2.createIntArray();
        obtain2.recycle();
        obtain.recycle();
        return createIntArray;
    }

    @Override // android.app.IActivityManager
    public List getServices(int i, int i2) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        obtain.writeInt(i);
        obtain.writeInt(i2);
        this.mRemote.transact(81, obtain, obtain2, 0);
        obtain2.readException();
        ArrayList arrayList = null;
        int readInt = obtain2.readInt();
        if (readInt >= 0) {
            ArrayList arrayList2 = new ArrayList();
            while (true) {
                arrayList = arrayList2;
                if (readInt <= 0) {
                    break;
                }
                arrayList2.add(ActivityManager.RunningServiceInfo.CREATOR.createFromParcel(obtain2));
                readInt--;
            }
        }
        obtain.recycle();
        obtain2.recycle();
        return arrayList;
    }

    @Override // android.app.IActivityManager
    public ActivityManager.StackInfo getStackInfo(int i) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        obtain.writeInt(i);
        this.mRemote.transact(173, obtain, obtain2, 0);
        obtain2.readException();
        ActivityManager.StackInfo stackInfo = null;
        if (obtain2.readInt() != 0) {
            stackInfo = ActivityManager.StackInfo.CREATOR.createFromParcel(obtain2);
        }
        obtain.recycle();
        obtain2.recycle();
        return stackInfo;
    }

    @Override // android.app.IActivityManager
    public String getTagForIntentSender(IIntentSender iIntentSender, String str) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        obtain.writeStrongBinder(iIntentSender.asBinder());
        obtain.writeString(str);
        this.mRemote.transact(211, obtain, obtain2, 0);
        obtain2.readException();
        String readString = obtain2.readString();
        obtain.recycle();
        obtain2.recycle();
        return readString;
    }

    @Override // android.app.IActivityManager
    public Bitmap getTaskDescriptionIcon(String str) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        obtain.writeString(str);
        this.mRemote.transact(239, obtain, obtain2, 0);
        obtain2.readException();
        Bitmap createFromParcel = obtain2.readInt() == 0 ? null : Bitmap.CREATOR.createFromParcel(obtain2);
        obtain.recycle();
        obtain2.recycle();
        return createFromParcel;
    }

    @Override // android.app.IActivityManager
    public int getTaskForActivity(IBinder iBinder, boolean z) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        obtain.writeStrongBinder(iBinder);
        obtain.writeInt(z ? 1 : 0);
        this.mRemote.transact(27, obtain, obtain2, 0);
        obtain2.readException();
        int readInt = obtain2.readInt();
        obtain.recycle();
        obtain2.recycle();
        return readInt;
    }

    @Override // android.app.IActivityManager
    public ActivityManager.TaskThumbnail getTaskThumbnail(int i) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        obtain.writeInt(i);
        this.mRemote.transact(82, obtain, obtain2, 0);
        obtain2.readException();
        ActivityManager.TaskThumbnail taskThumbnail = null;
        if (obtain2.readInt() != 0) {
            taskThumbnail = ActivityManager.TaskThumbnail.CREATOR.createFromParcel(obtain2);
        }
        obtain.recycle();
        obtain2.recycle();
        return taskThumbnail;
    }

    @Override // android.app.IActivityManager
    public List getTasks(int i, int i2) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        obtain.writeInt(i);
        obtain.writeInt(i2);
        this.mRemote.transact(23, obtain, obtain2, 0);
        obtain2.readException();
        ArrayList arrayList = null;
        int readInt = obtain2.readInt();
        if (readInt >= 0) {
            ArrayList arrayList2 = new ArrayList();
            while (true) {
                arrayList = arrayList2;
                if (readInt <= 0) {
                    break;
                }
                arrayList2.add(ActivityManager.RunningTaskInfo.CREATOR.createFromParcel(obtain2));
                readInt--;
            }
        }
        obtain.recycle();
        obtain2.recycle();
        return arrayList;
    }

    @Override // android.app.IActivityManager
    public int getUidForIntentSender(IIntentSender iIntentSender) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        obtain.writeStrongBinder(iIntentSender.asBinder());
        this.mRemote.transact(93, obtain, obtain2, 0);
        obtain2.readException();
        int readInt = obtain2.readInt();
        obtain.recycle();
        obtain2.recycle();
        return readInt;
    }

    @Override // android.app.IActivityManager
    public void grantUriPermission(IApplicationThread iApplicationThread, String str, Uri uri, int i, int i2) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        obtain.writeStrongBinder(iApplicationThread.asBinder());
        obtain.writeString(str);
        uri.writeToParcel(obtain, 0);
        obtain.writeInt(i);
        obtain.writeInt(i2);
        this.mRemote.transact(55, obtain, obtain2, 0);
        obtain2.readException();
        obtain.recycle();
        obtain2.recycle();
    }

    @Override // android.app.IActivityManager
    public void grantUriPermissionFromOwner(IBinder iBinder, int i, String str, Uri uri, int i2, int i3, int i4) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        obtain.writeStrongBinder(iBinder);
        obtain.writeInt(i);
        obtain.writeString(str);
        uri.writeToParcel(obtain, 0);
        obtain.writeInt(i2);
        obtain.writeInt(i3);
        obtain.writeInt(i4);
        this.mRemote.transact(55, obtain, obtain2, 0);
        obtain2.readException();
        obtain.recycle();
        obtain2.recycle();
    }

    @Override // android.app.IActivityManager
    public void handleApplicationCrash(IBinder iBinder, ApplicationErrorReport.CrashInfo crashInfo) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        obtain.writeStrongBinder(iBinder);
        crashInfo.writeToParcel(obtain, 0);
        this.mRemote.transact(2, obtain, obtain2, 0);
        obtain2.readException();
        obtain2.recycle();
        obtain.recycle();
    }

    @Override // android.app.IActivityManager
    public void handleApplicationStrictModeViolation(IBinder iBinder, int i, StrictMode.ViolationInfo violationInfo) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        obtain.writeStrongBinder(iBinder);
        obtain.writeInt(i);
        violationInfo.writeToParcel(obtain, 0);
        this.mRemote.transact(110, obtain, obtain2, 0);
        obtain2.readException();
        obtain2.recycle();
        obtain.recycle();
    }

    @Override // android.app.IActivityManager
    public boolean handleApplicationWtf(IBinder iBinder, String str, boolean z, ApplicationErrorReport.CrashInfo crashInfo) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        obtain.writeStrongBinder(iBinder);
        obtain.writeString(str);
        obtain.writeInt(z ? 1 : 0);
        crashInfo.writeToParcel(obtain, 0);
        this.mRemote.transact(102, obtain, obtain2, 0);
        obtain2.readException();
        boolean z2 = obtain2.readInt() != 0;
        obtain2.recycle();
        obtain.recycle();
        return z2;
    }

    @Override // android.app.IActivityManager
    public int handleIncomingUser(int i, int i2, int i3, boolean z, boolean z2, String str, String str2) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        obtain.writeInt(i);
        obtain.writeInt(i2);
        obtain.writeInt(i3);
        obtain.writeInt(z ? 1 : 0);
        obtain.writeInt(z2 ? 1 : 0);
        obtain.writeString(str);
        obtain.writeString(str2);
        this.mRemote.transact(94, obtain, obtain2, 0);
        obtain2.readException();
        int readInt = obtain2.readInt();
        obtain.recycle();
        obtain2.recycle();
        return readInt;
    }

    @Override // android.app.IActivityManager
    public void hang(IBinder iBinder, boolean z) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        obtain.writeStrongBinder(iBinder);
        obtain.writeInt(z ? 1 : 0);
        this.mRemote.transact(167, obtain, obtain2, 0);
        obtain2.readException();
        obtain.recycle();
        obtain2.recycle();
    }

    @Override // android.app.IActivityManager
    public long inputDispatchingTimedOut(int i, boolean z, String str) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        obtain.writeInt(i);
        obtain.writeInt(z ? 1 : 0);
        obtain.writeString(str);
        this.mRemote.transact(159, obtain, obtain2, 0);
        obtain2.readException();
        long readInt = obtain2.readInt();
        obtain.recycle();
        obtain2.recycle();
        return readInt;
    }

    @Override // android.app.IActivityManager
    public boolean isBackgroundVisibleBehind(IBinder iBinder) throws RemoteException {
        boolean z = false;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        obtain.writeStrongBinder(iBinder);
        this.mRemote.transact(227, obtain, obtain2, 0);
        obtain2.readException();
        if (obtain2.readInt() > 0) {
            z = true;
        }
        obtain.recycle();
        obtain2.recycle();
        return z;
    }

    @Override // android.app.IActivityManager
    public boolean isImmersive(IBinder iBinder) throws RemoteException {
        boolean z = true;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        obtain.writeStrongBinder(iBinder);
        this.mRemote.transact(111, obtain, obtain2, 0);
        obtain2.readException();
        if (obtain2.readInt() != 1) {
            z = false;
        }
        obtain.recycle();
        obtain2.recycle();
        return z;
    }

    @Override // android.app.IActivityManager
    public boolean isInHomeStack(int i) throws RemoteException {
        boolean z = false;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        obtain.writeInt(i);
        this.mRemote.transact(213, obtain, obtain2, 0);
        obtain2.readException();
        if (obtain2.readInt() > 0) {
            z = true;
        }
        obtain.recycle();
        obtain2.recycle();
        return z;
    }

    @Override // android.app.IActivityManager
    public boolean isInLockTaskMode() throws RemoteException {
        boolean z = true;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        this.mRemote.transact(217, obtain, obtain2, 0);
        obtain2.readException();
        if (obtain2.readInt() != 1) {
            z = false;
        }
        obtain.recycle();
        obtain2.recycle();
        return z;
    }

    @Override // android.app.IActivityManager
    public boolean isIntentSenderAnActivity(IIntentSender iIntentSender) throws RemoteException {
        boolean z = false;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        obtain.writeStrongBinder(iIntentSender.asBinder());
        this.mRemote.transact(152, obtain, obtain2, 0);
        obtain2.readException();
        if (obtain2.readInt() != 0) {
            z = true;
        }
        obtain.recycle();
        obtain2.recycle();
        return z;
    }

    @Override // android.app.IActivityManager
    public boolean isIntentSenderTargetedToPackage(IIntentSender iIntentSender) throws RemoteException {
        boolean z = false;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        obtain.writeStrongBinder(iIntentSender.asBinder());
        this.mRemote.transact(135, obtain, obtain2, 0);
        obtain2.readException();
        if (obtain2.readInt() != 0) {
            z = true;
        }
        obtain.recycle();
        obtain2.recycle();
        return z;
    }

    @Override // android.app.IActivityManager
    public boolean isTopActivityImmersive() throws RemoteException {
        boolean z = true;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        this.mRemote.transact(113, obtain, obtain2, 0);
        obtain2.readException();
        if (obtain2.readInt() != 1) {
            z = false;
        }
        obtain.recycle();
        obtain2.recycle();
        return z;
    }

    @Override // android.app.IActivityManager
    public boolean isTopOfTask(IBinder iBinder) throws RemoteException {
        boolean z = true;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        obtain.writeStrongBinder(iBinder);
        this.mRemote.transact(225, obtain, obtain2, 0);
        obtain2.readException();
        if (obtain2.readInt() != 1) {
            z = false;
        }
        obtain.recycle();
        obtain2.recycle();
        return z;
    }

    @Override // android.app.IActivityManager
    public boolean isUserAMonkey() throws RemoteException {
        boolean z = false;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        this.mRemote.transact(104, obtain, obtain2, 0);
        obtain2.readException();
        if (obtain2.readInt() != 0) {
            z = true;
        }
        obtain.recycle();
        obtain2.recycle();
        return z;
    }

    @Override // android.app.IActivityManager
    public boolean isUserRunning(int i, boolean z) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        obtain.writeInt(i);
        obtain.writeInt(z ? 1 : 0);
        this.mRemote.transact(122, obtain, obtain2, 0);
        obtain2.readException();
        boolean z2 = obtain2.readInt() != 0;
        obtain2.recycle();
        obtain.recycle();
        return z2;
    }

    @Override // android.app.IActivityManager
    public void keyguardWaitingForActivityDrawn() throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        this.mRemote.transact(232, obtain, obtain2, 0);
        obtain2.readException();
        obtain.recycle();
        obtain2.recycle();
    }

    @Override // android.app.IActivityManager
    public void killAllBackgroundProcesses() throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        this.mRemote.transact(140, obtain, obtain2, 0);
        obtain2.readException();
        obtain.recycle();
        obtain2.recycle();
    }

    @Override // android.app.IActivityManager
    public void killApplicationProcess(String str, int i) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        obtain.writeString(str);
        obtain.writeInt(i);
        this.mRemote.transact(99, obtain, obtain2, 0);
        obtain2.readException();
        obtain.recycle();
        obtain2.recycle();
    }

    @Override // android.app.IActivityManager
    public void killApplicationWithAppId(String str, int i, String str2) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        obtain.writeString(str);
        obtain.writeInt(i);
        obtain.writeString(str2);
        this.mRemote.transact(96, obtain, obtain2, 0);
        obtain2.readException();
        obtain.recycle();
        obtain2.recycle();
    }

    @Override // android.app.IActivityManager
    public void killBackgroundProcesses(String str, int i) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        obtain.writeString(str);
        obtain.writeInt(i);
        this.mRemote.transact(103, obtain, obtain2, 0);
        obtain2.readException();
        obtain.recycle();
        obtain2.recycle();
    }

    @Override // android.app.IActivityManager
    public boolean killPids(int[] iArr, String str, boolean z) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        obtain.writeIntArray(iArr);
        obtain.writeString(str);
        obtain.writeInt(z ? 1 : 0);
        this.mRemote.transact(80, obtain, obtain2, 0);
        obtain2.readException();
        boolean z2 = obtain2.readInt() != 0;
        obtain.recycle();
        obtain2.recycle();
        return z2;
    }

    @Override // android.app.IActivityManager
    public boolean killProcessesBelowForeground(String str) throws RemoteException {
        boolean z = false;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        obtain.writeString(str);
        this.mRemote.transact(144, obtain, obtain2, 0);
        if (obtain2.readInt() != 0) {
            z = true;
        }
        obtain.recycle();
        obtain2.recycle();
        return z;
    }

    @Override // android.app.IActivityManager
    public void killUid(int i, String str) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        obtain.writeInt(i);
        obtain.writeString(str);
        this.mRemote.transact(165, obtain, obtain2, 0);
        obtain2.readException();
        obtain.recycle();
        obtain2.recycle();
    }

    @Override // android.app.IActivityManager
    public boolean launchAssistIntent(Intent intent, int i, String str, int i2) throws RemoteException {
        boolean z = false;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        intent.writeToParcel(obtain, 0);
        obtain.writeInt(i);
        obtain.writeString(str);
        obtain.writeInt(i2);
        this.mRemote.transact(240, obtain, obtain2, 0);
        obtain2.readException();
        if (obtain2.readInt() != 0) {
            z = true;
        }
        obtain.recycle();
        obtain2.recycle();
        return z;
    }

    @Override // android.app.IActivityManager
    public boolean moveActivityTaskToBack(IBinder iBinder, boolean z) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        obtain.writeStrongBinder(iBinder);
        obtain.writeInt(z ? 1 : 0);
        this.mRemote.transact(75, obtain, obtain2, 0);
        obtain2.readException();
        boolean z2 = obtain2.readInt() != 0;
        obtain.recycle();
        obtain2.recycle();
        return z2;
    }

    @Override // android.app.IActivityManager
    public void moveTaskBackwards(int i) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        obtain.writeInt(i);
        this.mRemote.transact(26, obtain, obtain2, 0);
        obtain2.readException();
        obtain.recycle();
        obtain2.recycle();
    }

    @Override // android.app.IActivityManager
    public void moveTaskToBack(int i) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        obtain.writeInt(i);
        this.mRemote.transact(25, obtain, obtain2, 0);
        obtain2.readException();
        obtain.recycle();
        obtain2.recycle();
    }

    @Override // android.app.IActivityManager
    public void moveTaskToFront(int i, int i2, Bundle bundle) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        obtain.writeInt(i);
        obtain.writeInt(i2);
        if (bundle != null) {
            obtain.writeInt(1);
            bundle.writeToParcel(obtain, 0);
        } else {
            obtain.writeInt(0);
        }
        this.mRemote.transact(24, obtain, obtain2, 0);
        obtain2.readException();
        obtain.recycle();
        obtain2.recycle();
    }

    @Override // android.app.IActivityManager
    public void moveTaskToStack(int i, int i2, boolean z) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        obtain.writeInt(i);
        obtain.writeInt(i2);
        obtain.writeInt(z ? 1 : 0);
        this.mRemote.transact(169, obtain, obtain2, 0);
        obtain2.readException();
        obtain.recycle();
        obtain2.recycle();
    }

    @Override // android.app.IActivityManager
    public boolean navigateUpTo(IBinder iBinder, Intent intent, int i, Intent intent2) throws RemoteException {
        boolean z = true;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        obtain.writeStrongBinder(iBinder);
        intent.writeToParcel(obtain, 0);
        obtain.writeInt(i);
        if (intent2 != null) {
            obtain.writeInt(1);
            intent2.writeToParcel(obtain, 0);
        } else {
            obtain.writeInt(0);
        }
        this.mRemote.transact(147, obtain, obtain2, 0);
        obtain2.readException();
        if (obtain2.readInt() == 0) {
            z = false;
        }
        obtain.recycle();
        obtain2.recycle();
        return z;
    }

    @Override // android.app.IActivityManager
    public IBinder newUriPermissionOwner(String str) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        obtain.writeString(str);
        this.mRemote.transact(116, obtain, obtain2, 0);
        obtain2.readException();
        IBinder readStrongBinder = obtain2.readStrongBinder();
        obtain.recycle();
        obtain2.recycle();
        return readStrongBinder;
    }

    @Override // android.app.IActivityManager
    public void noteWakeupAlarm(IIntentSender iIntentSender, int i, String str) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        obtain.writeStrongBinder(iIntentSender.asBinder());
        obtain.writeInt(i);
        obtain.writeString(str);
        this.mRemote.transact(68, obtain, null, 0);
        obtain.recycle();
    }

    @Override // android.app.IActivityManager
    public void notifyActivityDrawn(IBinder iBinder) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        obtain.writeStrongBinder(iBinder);
        this.mRemote.transact(176, obtain, obtain2, 0);
        obtain2.readException();
        obtain.recycle();
        obtain2.recycle();
    }

    @Override // android.app.IActivityManager
    public void notifyEnterAnimationComplete(IBinder iBinder) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        obtain.writeStrongBinder(iBinder);
        this.mRemote.transact(231, obtain, obtain2, 1);
        obtain2.readException();
        obtain.recycle();
        obtain2.recycle();
    }

    @Override // android.app.IActivityManager
    public void notifyLaunchTaskBehindComplete(IBinder iBinder) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        obtain.writeStrongBinder(iBinder);
        this.mRemote.transact(229, obtain, obtain2, 1);
        obtain2.readException();
        obtain.recycle();
        obtain2.recycle();
    }

    @Override // android.app.IActivityManager
    public ParcelFileDescriptor openContentUri(Uri uri) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        this.mRemote.transact(5, obtain, obtain2, 0);
        obtain2.readException();
        ParcelFileDescriptor parcelFileDescriptor = null;
        if (obtain2.readInt() != 0) {
            parcelFileDescriptor = ParcelFileDescriptor.CREATOR.createFromParcel(obtain2);
        }
        obtain.recycle();
        obtain2.recycle();
        return parcelFileDescriptor;
    }

    @Override // android.app.IActivityManager
    public void overridePendingTransition(IBinder iBinder, String str, int i, int i2) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        obtain.writeStrongBinder(iBinder);
        obtain.writeString(str);
        obtain.writeInt(i);
        obtain.writeInt(i2);
        this.mRemote.transact(101, obtain, obtain2, 0);
        obtain2.readException();
        obtain.recycle();
        obtain2.recycle();
    }

    @Override // android.app.IActivityManager
    public IBinder peekService(Intent intent, String str) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        intent.writeToParcel(obtain, 0);
        obtain.writeString(str);
        this.mRemote.transact(85, obtain, obtain2, 0);
        obtain2.readException();
        IBinder readStrongBinder = obtain2.readStrongBinder();
        obtain2.recycle();
        obtain.recycle();
        return readStrongBinder;
    }

    @Override // android.app.IActivityManager
    public void performIdleMaintenance() throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        this.mRemote.transact(179, obtain, obtain2, 0);
        obtain2.readException();
        obtain.recycle();
        obtain2.recycle();
    }

    @Override // android.app.IActivityManager
    public boolean profileControl(String str, int i, boolean z, ProfilerInfo profilerInfo, int i2) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        obtain.writeString(str);
        obtain.writeInt(i);
        obtain.writeInt(z ? 1 : 0);
        obtain.writeInt(i2);
        if (profilerInfo != null) {
            obtain.writeInt(1);
            profilerInfo.writeToParcel(obtain, 1);
        } else {
            obtain.writeInt(0);
        }
        this.mRemote.transact(86, obtain, obtain2, 0);
        obtain2.readException();
        boolean z2 = obtain2.readInt() != 0;
        obtain2.recycle();
        obtain.recycle();
        return z2;
    }

    @Override // android.app.IActivityManager
    public void publishContentProviders(IApplicationThread iApplicationThread, List<IActivityManager.ContentProviderHolder> list) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        obtain.writeStrongBinder(iApplicationThread != null ? iApplicationThread.asBinder() : null);
        obtain.writeTypedList(list);
        this.mRemote.transact(30, obtain, obtain2, 0);
        obtain2.readException();
        obtain.recycle();
        obtain2.recycle();
    }

    @Override // android.app.IActivityManager
    public void publishService(IBinder iBinder, Intent intent, IBinder iBinder2) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        obtain.writeStrongBinder(iBinder);
        intent.writeToParcel(obtain, 0);
        obtain.writeStrongBinder(iBinder2);
        this.mRemote.transact(38, obtain, obtain2, 0);
        obtain2.readException();
        obtain.recycle();
        obtain2.recycle();
    }

    @Override // android.app.IActivityManager
    public boolean refContentProvider(IBinder iBinder, int i, int i2) throws RemoteException {
        boolean z = false;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        obtain.writeStrongBinder(iBinder);
        obtain.writeInt(i);
        obtain.writeInt(i2);
        this.mRemote.transact(31, obtain, obtain2, 0);
        obtain2.readException();
        if (obtain2.readInt() != 0) {
            z = true;
        }
        obtain.recycle();
        obtain2.recycle();
        return z;
    }

    @Override // android.app.IActivityManager
    public void registerProcessObserver(IProcessObserver iProcessObserver) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        obtain.writeStrongBinder(iProcessObserver != null ? iProcessObserver.asBinder() : null);
        this.mRemote.transact(133, obtain, obtain2, 0);
        obtain2.readException();
        obtain.recycle();
        obtain2.recycle();
    }

    @Override // android.app.IActivityManager
    public Intent registerReceiver(IApplicationThread iApplicationThread, String str, IIntentReceiver iIntentReceiver, IntentFilter intentFilter, String str2, int i) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        obtain.writeStrongBinder(iApplicationThread != null ? iApplicationThread.asBinder() : null);
        obtain.writeString(str);
        IBinder iBinder = null;
        if (iIntentReceiver != null) {
            iBinder = iIntentReceiver.asBinder();
        }
        obtain.writeStrongBinder(iBinder);
        intentFilter.writeToParcel(obtain, 0);
        obtain.writeString(str2);
        obtain.writeInt(i);
        this.mRemote.transact(12, obtain, obtain2, 0);
        obtain2.readException();
        Intent intent = null;
        if (obtain2.readInt() != 0) {
            intent = Intent.CREATOR.createFromParcel(obtain2);
        }
        obtain2.recycle();
        obtain.recycle();
        return intent;
    }

    @Override // android.app.IActivityManager
    public void registerTaskStackListener(ITaskStackListener iTaskStackListener) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        obtain.writeStrongBinder(iTaskStackListener.asBinder());
        this.mRemote.transact(243, obtain, obtain2, 1);
        obtain2.readException();
        obtain.recycle();
        obtain2.recycle();
    }

    @Override // android.app.IActivityManager
    public void registerUserSwitchObserver(IUserSwitchObserver iUserSwitchObserver) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        obtain.writeStrongBinder(iUserSwitchObserver != null ? iUserSwitchObserver.asBinder() : null);
        this.mRemote.transact(155, obtain, obtain2, 0);
        obtain2.readException();
        obtain.recycle();
        obtain2.recycle();
    }

    @Override // android.app.IActivityManager
    public boolean releaseActivityInstance(IBinder iBinder) throws RemoteException {
        boolean z = false;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        obtain.writeStrongBinder(iBinder);
        this.mRemote.transact(236, obtain, obtain2, 0);
        obtain2.readException();
        if (obtain2.readInt() != 0) {
            z = true;
        }
        obtain.recycle();
        obtain2.recycle();
        return z;
    }

    @Override // android.app.IActivityManager
    public void releasePersistableUriPermission(Uri uri, int i, int i2) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        uri.writeToParcel(obtain, 0);
        obtain.writeInt(i);
        obtain.writeInt(i2);
        this.mRemote.transact(181, obtain, obtain2, 0);
        obtain2.readException();
        obtain.recycle();
        obtain2.recycle();
    }

    @Override // android.app.IActivityManager
    public void releaseSomeActivities(IApplicationThread iApplicationThread) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        obtain.writeStrongBinder(iApplicationThread.asBinder());
        this.mRemote.transact(237, obtain, obtain2, 0);
        obtain2.readException();
        obtain.recycle();
        obtain2.recycle();
    }

    @Override // android.app.IActivityManager
    public void removeContentProvider(IBinder iBinder, boolean z) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        obtain.writeStrongBinder(iBinder);
        obtain.writeInt(z ? 1 : 0);
        this.mRemote.transact(69, obtain, obtain2, 0);
        obtain2.readException();
        obtain.recycle();
        obtain2.recycle();
    }

    @Override // android.app.IActivityManager
    public void removeContentProviderExternal(String str, IBinder iBinder) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        obtain.writeString(str);
        obtain.writeStrongBinder(iBinder);
        this.mRemote.transact(142, obtain, obtain2, 0);
        obtain2.readException();
        obtain.recycle();
        obtain2.recycle();
    }

    @Override // android.app.IActivityManager
    public boolean removeTask(int i) throws RemoteException {
        boolean z = false;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        obtain.writeInt(i);
        this.mRemote.transact(132, obtain, obtain2, 0);
        obtain2.readException();
        if (obtain2.readInt() != 0) {
            z = true;
        }
        obtain2.recycle();
        obtain.recycle();
        return z;
    }

    @Override // android.app.IActivityManager
    public void reportActivityFullyDrawn(IBinder iBinder) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        obtain.writeStrongBinder(iBinder);
        this.mRemote.transact(177, obtain, obtain2, 0);
        obtain2.readException();
        obtain.recycle();
        obtain2.recycle();
    }

    @Override // android.app.IActivityManager
    public void reportAssistContextExtras(IBinder iBinder, Bundle bundle) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        obtain.writeStrongBinder(iBinder);
        obtain.writeBundle(bundle);
        this.mRemote.transact(163, obtain, obtain2, 0);
        obtain2.readException();
        obtain.recycle();
        obtain2.recycle();
    }

    @Override // android.app.IActivityManager
    public void requestBugReport() throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        this.mRemote.transact(158, obtain, obtain2, 0);
        obtain2.readException();
        obtain.recycle();
        obtain2.recycle();
    }

    @Override // android.app.IActivityManager
    public boolean requestVisibleBehind(IBinder iBinder, boolean z) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        obtain.writeStrongBinder(iBinder);
        obtain.writeInt(z ? 1 : 0);
        this.mRemote.transact(226, obtain, obtain2, 0);
        obtain2.readException();
        boolean z2 = obtain2.readInt() > 0;
        obtain.recycle();
        obtain2.recycle();
        return z2;
    }

    @Override // android.app.IActivityManager
    public void resizeStack(int i, Rect rect) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        obtain.writeInt(i);
        rect.writeToParcel(obtain, 0);
        this.mRemote.transact(170, obtain, obtain2, 1);
        obtain2.readException();
        obtain.recycle();
        obtain2.recycle();
    }

    @Override // android.app.IActivityManager
    public void restart() throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        this.mRemote.transact(178, obtain, obtain2, 0);
        obtain2.readException();
        obtain.recycle();
        obtain2.recycle();
    }

    @Override // android.app.IActivityManager
    public void resumeAppSwitches() throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        this.mRemote.transact(89, obtain, obtain2, 0);
        obtain2.readException();
        obtain2.recycle();
        obtain.recycle();
    }

    @Override // android.app.IActivityManager
    public void revokeUriPermission(IApplicationThread iApplicationThread, Uri uri, int i, int i2) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        obtain.writeStrongBinder(iApplicationThread.asBinder());
        uri.writeToParcel(obtain, 0);
        obtain.writeInt(i);
        obtain.writeInt(i2);
        this.mRemote.transact(56, obtain, obtain2, 0);
        obtain2.readException();
        obtain.recycle();
        obtain2.recycle();
    }

    @Override // android.app.IActivityManager
    public void revokeUriPermissionFromOwner(IBinder iBinder, Uri uri, int i, int i2) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        obtain.writeStrongBinder(iBinder);
        if (uri != null) {
            obtain.writeInt(1);
            uri.writeToParcel(obtain, 0);
        } else {
            obtain.writeInt(0);
        }
        obtain.writeInt(i);
        obtain.writeInt(i2);
        this.mRemote.transact(56, obtain, obtain2, 0);
        obtain2.readException();
        obtain.recycle();
        obtain2.recycle();
    }

    @Override // android.app.IActivityManager
    public void serviceDoneExecuting(IBinder iBinder, int i, int i2, int i3) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        obtain.writeStrongBinder(iBinder);
        obtain.writeInt(i);
        obtain.writeInt(i2);
        obtain.writeInt(i3);
        this.mRemote.transact(61, obtain, obtain2, 1);
        obtain2.readException();
        obtain.recycle();
        obtain2.recycle();
    }

    @Override // android.app.IActivityManager
    public void setActivityController(IActivityController iActivityController) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        obtain.writeStrongBinder(iActivityController != null ? iActivityController.asBinder() : null);
        this.mRemote.transact(57, obtain, obtain2, 0);
        obtain2.readException();
        obtain.recycle();
        obtain2.recycle();
    }

    @Override // android.app.IActivityManager
    public void setAlwaysFinish(boolean z) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        obtain.writeInt(z ? 1 : 0);
        this.mRemote.transact(43, obtain, obtain2, 0);
        obtain2.readException();
        obtain.recycle();
        obtain2.recycle();
    }

    @Override // android.app.IActivityManager
    public void setDebugApp(String str, boolean z, boolean z2) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        obtain.writeString(str);
        obtain.writeInt(z ? 1 : 0);
        obtain.writeInt(z2 ? 1 : 0);
        this.mRemote.transact(42, obtain, obtain2, 0);
        obtain2.readException();
        obtain.recycle();
        obtain2.recycle();
    }

    @Override // android.app.IActivityManager
    public void setFocusedStack(int i) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        obtain.writeInt(i);
        this.mRemote.transact(172, obtain, obtain2, 1);
        obtain2.readException();
        obtain.recycle();
        obtain2.recycle();
    }

    @Override // android.app.IActivityManager
    public void setFrontActivityScreenCompatMode(int i) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        obtain.writeInt(i);
        this.mRemote.transact(125, obtain, obtain2, 0);
        obtain2.readException();
        obtain2.recycle();
        obtain.recycle();
    }

    @Override // android.app.IActivityManager
    public void setImmersive(IBinder iBinder, boolean z) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        obtain.writeStrongBinder(iBinder);
        obtain.writeInt(z ? 1 : 0);
        this.mRemote.transact(112, obtain, obtain2, 0);
        obtain2.readException();
        obtain.recycle();
        obtain2.recycle();
    }

    @Override // android.app.IActivityManager
    public void setLockScreenShown(boolean z) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        obtain.writeInt(z ? 1 : 0);
        this.mRemote.transact(148, obtain, obtain2, 0);
        obtain2.readException();
        obtain.recycle();
        obtain2.recycle();
    }

    @Override // android.app.IActivityManager
    public void setPackageAskScreenCompat(String str, boolean z) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        obtain.writeString(str);
        obtain.writeInt(z ? 1 : 0);
        this.mRemote.transact(129, obtain, obtain2, 0);
        obtain2.readException();
        obtain2.recycle();
        obtain.recycle();
    }

    @Override // android.app.IActivityManager
    public void setPackageScreenCompatMode(String str, int i) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        obtain.writeString(str);
        obtain.writeInt(i);
        this.mRemote.transact(127, obtain, obtain2, 0);
        obtain2.readException();
        obtain2.recycle();
        obtain.recycle();
    }

    @Override // android.app.IActivityManager
    public void setProcessForeground(IBinder iBinder, int i, boolean z) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        obtain.writeStrongBinder(iBinder);
        obtain.writeInt(i);
        obtain.writeInt(z ? 1 : 0);
        this.mRemote.transact(73, obtain, obtain2, 0);
        obtain2.readException();
        obtain.recycle();
        obtain2.recycle();
    }

    @Override // android.app.IActivityManager
    public void setProcessLimit(int i) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        obtain.writeInt(i);
        this.mRemote.transact(51, obtain, obtain2, 0);
        obtain2.readException();
        obtain.recycle();
        obtain2.recycle();
    }

    @Override // android.app.IActivityManager
    public void setRequestedOrientation(IBinder iBinder, int i) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        obtain.writeStrongBinder(iBinder);
        obtain.writeInt(i);
        this.mRemote.transact(70, obtain, obtain2, 0);
        obtain2.readException();
        obtain.recycle();
        obtain2.recycle();
    }

    @Override // android.app.IActivityManager
    public void setServiceForeground(ComponentName componentName, IBinder iBinder, int i, Notification notification, boolean z) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        ComponentName.writeToParcel(componentName, obtain);
        obtain.writeStrongBinder(iBinder);
        obtain.writeInt(i);
        if (notification != null) {
            obtain.writeInt(1);
            notification.writeToParcel(obtain, 0);
        } else {
            obtain.writeInt(0);
        }
        obtain.writeInt(z ? 1 : 0);
        this.mRemote.transact(74, obtain, obtain2, 0);
        obtain2.readException();
        obtain.recycle();
        obtain2.recycle();
    }

    @Override // android.app.IActivityManager
    public void setTaskDescription(IBinder iBinder, ActivityManager.TaskDescription taskDescription) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        obtain.writeStrongBinder(iBinder);
        taskDescription.writeToParcel(obtain, 0);
        this.mRemote.transact(218, obtain, obtain2, 1);
        obtain2.readException();
        obtain.recycle();
        obtain2.recycle();
    }

    @Override // android.app.IActivityManager
    public void setUserIsMonkey(boolean z) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        obtain.writeInt(z ? 1 : 0);
        this.mRemote.transact(166, obtain, obtain2, 0);
        obtain2.readException();
        obtain.recycle();
        obtain2.recycle();
    }

    @Override // android.app.IActivityManager
    public boolean shouldUpRecreateTask(IBinder iBinder, String str) throws RemoteException {
        boolean z = false;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        obtain.writeStrongBinder(iBinder);
        obtain.writeString(str);
        this.mRemote.transact(146, obtain, obtain2, 0);
        obtain2.readException();
        if (obtain2.readInt() != 0) {
            z = true;
        }
        obtain.recycle();
        obtain2.recycle();
        return z;
    }

    @Override // android.app.IActivityManager
    public void showBootMessage(CharSequence charSequence, boolean z) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        TextUtils.writeToParcel(charSequence, obtain, 0);
        obtain.writeInt(z ? 1 : 0);
        this.mRemote.transact(138, obtain, obtain2, 0);
        obtain2.readException();
        obtain.recycle();
        obtain2.recycle();
    }

    @Override // android.app.IActivityManager
    public void showWaitingForDebugger(IApplicationThread iApplicationThread, boolean z) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        obtain.writeStrongBinder(iApplicationThread.asBinder());
        obtain.writeInt(z ? 1 : 0);
        this.mRemote.transact(58, obtain, obtain2, 0);
        obtain2.readException();
        obtain.recycle();
        obtain2.recycle();
    }

    @Override // android.app.IActivityManager
    public boolean shutdown(int i) throws RemoteException {
        boolean z = false;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        obtain.writeInt(i);
        this.mRemote.transact(87, obtain, obtain2, 0);
        obtain2.readException();
        if (obtain2.readInt() != 0) {
            z = true;
        }
        obtain2.recycle();
        obtain.recycle();
        return z;
    }

    @Override // android.app.IActivityManager
    public void signalPersistentProcesses(int i) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        obtain.writeInt(i);
        this.mRemote.transact(59, obtain, obtain2, 0);
        obtain2.readException();
        obtain.recycle();
        obtain2.recycle();
    }

    @Override // android.app.IActivityManager
    public int startActivities(IApplicationThread iApplicationThread, String str, Intent[] intentArr, String[] strArr, IBinder iBinder, Bundle bundle, int i) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        obtain.writeStrongBinder(iApplicationThread != null ? iApplicationThread.asBinder() : null);
        obtain.writeString(str);
        obtain.writeTypedArray(intentArr, 0);
        obtain.writeStringArray(strArr);
        obtain.writeStrongBinder(iBinder);
        if (bundle != null) {
            obtain.writeInt(1);
            bundle.writeToParcel(obtain, 0);
        } else {
            obtain.writeInt(0);
        }
        obtain.writeInt(i);
        this.mRemote.transact(121, obtain, obtain2, 0);
        obtain2.readException();
        int readInt = obtain2.readInt();
        obtain2.recycle();
        obtain.recycle();
        return readInt;
    }

    @Override // android.app.IActivityManager
    public int startActivity(IApplicationThread iApplicationThread, String str, Intent intent, String str2, IBinder iBinder, String str3, int i, int i2, ProfilerInfo profilerInfo, Bundle bundle) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        if (intent.getComponent() != null) {
            Log.i(TAG_TIMELINE, "Timeline: Activity_launch_request id:" + intent.getComponent().getPackageName() + " time:" + SystemClock.uptimeMillis());
        }
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        obtain.writeStrongBinder(iApplicationThread != null ? iApplicationThread.asBinder() : null);
        obtain.writeString(str);
        intent.writeToParcel(obtain, 0);
        obtain.writeString(str2);
        obtain.writeStrongBinder(iBinder);
        obtain.writeString(str3);
        obtain.writeInt(i);
        obtain.writeInt(i2);
        if (profilerInfo != null) {
            obtain.writeInt(1);
            profilerInfo.writeToParcel(obtain, 1);
        } else {
            obtain.writeInt(0);
        }
        if (bundle != null) {
            obtain.writeInt(1);
            bundle.writeToParcel(obtain, 0);
        } else {
            obtain.writeInt(0);
        }
        this.mRemote.transact(3, obtain, obtain2, 0);
        obtain2.readException();
        int readInt = obtain2.readInt();
        obtain2.recycle();
        obtain.recycle();
        return readInt;
    }

    @Override // android.app.IActivityManager
    public IActivityManager.WaitResult startActivityAndWait(IApplicationThread iApplicationThread, String str, Intent intent, String str2, IBinder iBinder, String str3, int i, int i2, ProfilerInfo profilerInfo, Bundle bundle, int i3) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        obtain.writeStrongBinder(iApplicationThread != null ? iApplicationThread.asBinder() : null);
        obtain.writeString(str);
        intent.writeToParcel(obtain, 0);
        obtain.writeString(str2);
        obtain.writeStrongBinder(iBinder);
        obtain.writeString(str3);
        obtain.writeInt(i);
        obtain.writeInt(i2);
        if (profilerInfo != null) {
            obtain.writeInt(1);
            profilerInfo.writeToParcel(obtain, 1);
        } else {
            obtain.writeInt(0);
        }
        if (bundle != null) {
            obtain.writeInt(1);
            bundle.writeToParcel(obtain, 0);
        } else {
            obtain.writeInt(0);
        }
        obtain.writeInt(i3);
        this.mRemote.transact(105, obtain, obtain2, 0);
        obtain2.readException();
        IActivityManager.WaitResult createFromParcel = IActivityManager.WaitResult.CREATOR.createFromParcel(obtain2);
        obtain2.recycle();
        obtain.recycle();
        return createFromParcel;
    }

    @Override // android.app.IActivityManager
    public int startActivityAsCaller(IApplicationThread iApplicationThread, String str, Intent intent, String str2, IBinder iBinder, String str3, int i, int i2, ProfilerInfo profilerInfo, Bundle bundle, int i3) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        obtain.writeStrongBinder(iApplicationThread != null ? iApplicationThread.asBinder() : null);
        obtain.writeString(str);
        intent.writeToParcel(obtain, 0);
        obtain.writeString(str2);
        obtain.writeStrongBinder(iBinder);
        obtain.writeString(str3);
        obtain.writeInt(i);
        obtain.writeInt(i2);
        if (profilerInfo != null) {
            obtain.writeInt(1);
            profilerInfo.writeToParcel(obtain, 1);
        } else {
            obtain.writeInt(0);
        }
        if (bundle != null) {
            obtain.writeInt(1);
            bundle.writeToParcel(obtain, 0);
        } else {
            obtain.writeInt(0);
        }
        obtain.writeInt(i3);
        this.mRemote.transact(233, obtain, obtain2, 0);
        obtain2.readException();
        int readInt = obtain2.readInt();
        obtain2.recycle();
        obtain.recycle();
        return readInt;
    }

    @Override // android.app.IActivityManager
    public int startActivityAsUser(IApplicationThread iApplicationThread, String str, Intent intent, String str2, IBinder iBinder, String str3, int i, int i2, ProfilerInfo profilerInfo, Bundle bundle, int i3) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        obtain.writeStrongBinder(iApplicationThread != null ? iApplicationThread.asBinder() : null);
        obtain.writeString(str);
        intent.writeToParcel(obtain, 0);
        obtain.writeString(str2);
        obtain.writeStrongBinder(iBinder);
        obtain.writeString(str3);
        obtain.writeInt(i);
        obtain.writeInt(i2);
        if (profilerInfo != null) {
            obtain.writeInt(1);
            profilerInfo.writeToParcel(obtain, 1);
        } else {
            obtain.writeInt(0);
        }
        if (bundle != null) {
            obtain.writeInt(1);
            bundle.writeToParcel(obtain, 0);
        } else {
            obtain.writeInt(0);
        }
        obtain.writeInt(i3);
        this.mRemote.transact(153, obtain, obtain2, 0);
        obtain2.readException();
        int readInt = obtain2.readInt();
        obtain2.recycle();
        obtain.recycle();
        return readInt;
    }

    @Override // android.app.IActivityManager
    public int startActivityFromRecents(int i, Bundle bundle) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        obtain.writeInt(i);
        if (bundle == null) {
            obtain.writeInt(0);
        } else {
            obtain.writeInt(1);
            bundle.writeToParcel(obtain, 0);
        }
        this.mRemote.transact(230, obtain, obtain2, 0);
        obtain2.readException();
        int readInt = obtain2.readInt();
        obtain2.recycle();
        obtain.recycle();
        return readInt;
    }

    @Override // android.app.IActivityManager
    public int startActivityIntentSender(IApplicationThread iApplicationThread, IntentSender intentSender, Intent intent, String str, IBinder iBinder, String str2, int i, int i2, int i3, Bundle bundle) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        obtain.writeStrongBinder(iApplicationThread != null ? iApplicationThread.asBinder() : null);
        intentSender.writeToParcel(obtain, 0);
        if (intent != null) {
            obtain.writeInt(1);
            intent.writeToParcel(obtain, 0);
        } else {
            obtain.writeInt(0);
        }
        obtain.writeString(str);
        obtain.writeStrongBinder(iBinder);
        obtain.writeString(str2);
        obtain.writeInt(i);
        obtain.writeInt(i2);
        obtain.writeInt(i3);
        if (bundle != null) {
            obtain.writeInt(1);
            bundle.writeToParcel(obtain, 0);
        } else {
            obtain.writeInt(0);
        }
        this.mRemote.transact(100, obtain, obtain2, 0);
        obtain2.readException();
        int readInt = obtain2.readInt();
        obtain2.recycle();
        obtain.recycle();
        return readInt;
    }

    @Override // android.app.IActivityManager
    public int startActivityWithConfig(IApplicationThread iApplicationThread, String str, Intent intent, String str2, IBinder iBinder, String str3, int i, int i2, Configuration configuration, Bundle bundle, int i3) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        obtain.writeStrongBinder(iApplicationThread != null ? iApplicationThread.asBinder() : null);
        obtain.writeString(str);
        intent.writeToParcel(obtain, 0);
        obtain.writeString(str2);
        obtain.writeStrongBinder(iBinder);
        obtain.writeString(str3);
        obtain.writeInt(i);
        obtain.writeInt(i2);
        configuration.writeToParcel(obtain, 0);
        if (bundle != null) {
            obtain.writeInt(1);
            bundle.writeToParcel(obtain, 0);
        } else {
            obtain.writeInt(0);
        }
        obtain.writeInt(i3);
        this.mRemote.transact(3, obtain, obtain2, 0);
        obtain2.readException();
        int readInt = obtain2.readInt();
        obtain2.recycle();
        obtain.recycle();
        return readInt;
    }

    @Override // android.app.IActivityManager
    public void startInPlaceAnimationOnFrontMostApplication(ActivityOptions activityOptions) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        if (activityOptions == null) {
            obtain.writeInt(0);
        } else {
            obtain.writeInt(1);
            obtain.writeBundle(activityOptions.toBundle());
        }
        this.mRemote.transact(241, obtain, obtain2, 1);
        obtain2.readException();
        obtain.recycle();
        obtain2.recycle();
    }

    @Override // android.app.IActivityManager
    public boolean startInstrumentation(ComponentName componentName, String str, int i, Bundle bundle, IInstrumentationWatcher iInstrumentationWatcher, IUiAutomationConnection iUiAutomationConnection, int i2, String str2) throws RemoteException {
        boolean z = false;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        ComponentName.writeToParcel(componentName, obtain);
        obtain.writeString(str);
        obtain.writeInt(i);
        obtain.writeBundle(bundle);
        obtain.writeStrongBinder(iInstrumentationWatcher != null ? iInstrumentationWatcher.asBinder() : null);
        IBinder iBinder = null;
        if (iUiAutomationConnection != null) {
            iBinder = iUiAutomationConnection.asBinder();
        }
        obtain.writeStrongBinder(iBinder);
        obtain.writeInt(i2);
        obtain.writeString(str2);
        this.mRemote.transact(44, obtain, obtain2, 0);
        obtain2.readException();
        if (obtain2.readInt() != 0) {
            z = true;
        }
        obtain2.recycle();
        obtain.recycle();
        return z;
    }

    @Override // android.app.IActivityManager
    public void startLockTaskMode(int i) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        obtain.writeInt(i);
        this.mRemote.transact(214, obtain, obtain2, 0);
        obtain2.readException();
        obtain.recycle();
        obtain2.recycle();
    }

    @Override // android.app.IActivityManager
    public void startLockTaskMode(IBinder iBinder) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        obtain.writeStrongBinder(iBinder);
        this.mRemote.transact(215, obtain, obtain2, 0);
        obtain2.readException();
        obtain.recycle();
        obtain2.recycle();
    }

    @Override // android.app.IActivityManager
    public void startLockTaskModeOnCurrent() throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        this.mRemote.transact(222, obtain, obtain2, 0);
        obtain2.readException();
        obtain.recycle();
        obtain2.recycle();
    }

    @Override // android.app.IActivityManager
    public boolean startNextMatchingActivity(IBinder iBinder, Intent intent, Bundle bundle) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        obtain.writeStrongBinder(iBinder);
        intent.writeToParcel(obtain, 0);
        if (bundle != null) {
            obtain.writeInt(1);
            bundle.writeToParcel(obtain, 0);
        } else {
            obtain.writeInt(0);
        }
        this.mRemote.transact(67, obtain, obtain2, 0);
        obtain2.readException();
        int readInt = obtain2.readInt();
        obtain2.recycle();
        obtain.recycle();
        return readInt != 0;
    }

    @Override // android.app.IActivityManager
    public ComponentName startService(IApplicationThread iApplicationThread, Intent intent, String str, int i) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        obtain.writeStrongBinder(iApplicationThread != null ? iApplicationThread.asBinder() : null);
        intent.writeToParcel(obtain, 0);
        obtain.writeString(str);
        obtain.writeInt(i);
        this.mRemote.transact(34, obtain, obtain2, 0);
        obtain2.readException();
        ComponentName readFromParcel = ComponentName.readFromParcel(obtain2);
        obtain.recycle();
        obtain2.recycle();
        return readFromParcel;
    }

    @Override // android.app.IActivityManager
    public boolean startUserInBackground(int i) throws RemoteException {
        boolean z = false;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        obtain.writeInt(i);
        this.mRemote.transact(212, obtain, obtain2, 0);
        obtain2.readException();
        if (obtain2.readInt() != 0) {
            z = true;
        }
        obtain2.recycle();
        obtain.recycle();
        return z;
    }

    @Override // android.app.IActivityManager
    public int startVoiceActivity(String str, int i, int i2, Intent intent, String str2, IVoiceInteractionSession iVoiceInteractionSession, IVoiceInteractor iVoiceInteractor, int i3, ProfilerInfo profilerInfo, Bundle bundle, int i4) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        obtain.writeString(str);
        obtain.writeInt(i);
        obtain.writeInt(i2);
        intent.writeToParcel(obtain, 0);
        obtain.writeString(str2);
        obtain.writeStrongBinder(iVoiceInteractionSession.asBinder());
        obtain.writeStrongBinder(iVoiceInteractor.asBinder());
        obtain.writeInt(i3);
        if (profilerInfo != null) {
            obtain.writeInt(1);
            profilerInfo.writeToParcel(obtain, 1);
        } else {
            obtain.writeInt(0);
        }
        if (bundle != null) {
            obtain.writeInt(1);
            bundle.writeToParcel(obtain, 0);
        } else {
            obtain.writeInt(0);
        }
        obtain.writeInt(i4);
        this.mRemote.transact(219, obtain, obtain2, 0);
        obtain2.readException();
        int readInt = obtain2.readInt();
        obtain2.recycle();
        obtain.recycle();
        return readInt;
    }

    @Override // android.app.IActivityManager
    public void stopAppSwitches() throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        this.mRemote.transact(88, obtain, obtain2, 0);
        obtain2.readException();
        obtain2.recycle();
        obtain.recycle();
    }

    @Override // android.app.IActivityManager
    public void stopLockTaskMode() throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        this.mRemote.transact(216, obtain, obtain2, 0);
        obtain2.readException();
        obtain.recycle();
        obtain2.recycle();
    }

    @Override // android.app.IActivityManager
    public void stopLockTaskModeOnCurrent() throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        this.mRemote.transact(223, obtain, obtain2, 0);
        obtain2.readException();
        obtain.recycle();
        obtain2.recycle();
    }

    @Override // android.app.IActivityManager
    public int stopService(IApplicationThread iApplicationThread, Intent intent, String str, int i) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        obtain.writeStrongBinder(iApplicationThread != null ? iApplicationThread.asBinder() : null);
        intent.writeToParcel(obtain, 0);
        obtain.writeString(str);
        obtain.writeInt(i);
        this.mRemote.transact(35, obtain, obtain2, 0);
        obtain2.readException();
        int readInt = obtain2.readInt();
        obtain2.recycle();
        obtain.recycle();
        return readInt;
    }

    @Override // android.app.IActivityManager
    public boolean stopServiceToken(ComponentName componentName, IBinder iBinder, int i) throws RemoteException {
        boolean z = false;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        ComponentName.writeToParcel(componentName, obtain);
        obtain.writeStrongBinder(iBinder);
        obtain.writeInt(i);
        this.mRemote.transact(48, obtain, obtain2, 0);
        obtain2.readException();
        if (obtain2.readInt() != 0) {
            z = true;
        }
        obtain.recycle();
        obtain2.recycle();
        return z;
    }

    @Override // android.app.IActivityManager
    public int stopUser(int i, IStopUserCallback iStopUserCallback) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        obtain.writeInt(i);
        obtain.writeStrongInterface(iStopUserCallback);
        this.mRemote.transact(154, obtain, obtain2, 0);
        obtain2.readException();
        int readInt = obtain2.readInt();
        obtain2.recycle();
        obtain.recycle();
        return readInt;
    }

    @Override // android.app.IActivityManager
    public boolean switchUser(int i) throws RemoteException {
        boolean z = false;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        obtain.writeInt(i);
        this.mRemote.transact(130, obtain, obtain2, 0);
        obtain2.readException();
        if (obtain2.readInt() != 0) {
            z = true;
        }
        obtain2.recycle();
        obtain.recycle();
        return z;
    }

    @Override // android.app.IActivityManager
    public void systemBackupRestored() throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        this.mRemote.transact(244, obtain, obtain2, 0);
        obtain2.readException();
        obtain.recycle();
        obtain2.recycle();
    }

    @Override // android.app.IActivityManager
    public void takePersistableUriPermission(Uri uri, int i, int i2) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        uri.writeToParcel(obtain, 0);
        obtain.writeInt(i);
        obtain.writeInt(i2);
        this.mRemote.transact(180, obtain, obtain2, 0);
        obtain2.readException();
        obtain.recycle();
        obtain2.recycle();
    }

    @Override // android.app.IActivityManager
    public boolean testIsSystemReady() {
        return true;
    }

    @Override // android.app.IActivityManager
    public void unbindBackupAgent(ApplicationInfo applicationInfo) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        applicationInfo.writeToParcel(obtain, 0);
        this.mRemote.transact(92, obtain, obtain2, 0);
        obtain2.readException();
        obtain2.recycle();
        obtain.recycle();
    }

    @Override // android.app.IActivityManager
    public void unbindFinished(IBinder iBinder, Intent intent, boolean z) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        obtain.writeStrongBinder(iBinder);
        intent.writeToParcel(obtain, 0);
        obtain.writeInt(z ? 1 : 0);
        this.mRemote.transact(72, obtain, obtain2, 0);
        obtain2.readException();
        obtain.recycle();
        obtain2.recycle();
    }

    @Override // android.app.IActivityManager
    public boolean unbindService(IServiceConnection iServiceConnection) throws RemoteException {
        boolean z = false;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        obtain.writeStrongBinder(iServiceConnection.asBinder());
        this.mRemote.transact(37, obtain, obtain2, 0);
        obtain2.readException();
        if (obtain2.readInt() != 0) {
            z = true;
        }
        obtain.recycle();
        obtain2.recycle();
        return z;
    }

    @Override // android.app.IActivityManager
    public void unbroadcastIntent(IApplicationThread iApplicationThread, Intent intent, int i) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        obtain.writeStrongBinder(iApplicationThread != null ? iApplicationThread.asBinder() : null);
        intent.writeToParcel(obtain, 0);
        obtain.writeInt(i);
        this.mRemote.transact(15, obtain, obtain2, 0);
        obtain2.readException();
        obtain.recycle();
        obtain2.recycle();
    }

    @Override // android.app.IActivityManager
    public void unhandledBack() throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        this.mRemote.transact(4, obtain, obtain2, 0);
        obtain2.readException();
        obtain.recycle();
        obtain2.recycle();
    }

    @Override // android.app.IActivityManager
    public void unregisterProcessObserver(IProcessObserver iProcessObserver) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        obtain.writeStrongBinder(iProcessObserver != null ? iProcessObserver.asBinder() : null);
        this.mRemote.transact(134, obtain, obtain2, 0);
        obtain2.readException();
        obtain.recycle();
        obtain2.recycle();
    }

    @Override // android.app.IActivityManager
    public void unregisterReceiver(IIntentReceiver iIntentReceiver) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        obtain.writeStrongBinder(iIntentReceiver.asBinder());
        this.mRemote.transact(13, obtain, obtain2, 0);
        obtain2.readException();
        obtain.recycle();
        obtain2.recycle();
    }

    @Override // android.app.IActivityManager
    public void unregisterUserSwitchObserver(IUserSwitchObserver iUserSwitchObserver) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        obtain.writeStrongBinder(iUserSwitchObserver != null ? iUserSwitchObserver.asBinder() : null);
        this.mRemote.transact(156, obtain, obtain2, 0);
        obtain2.readException();
        obtain.recycle();
        obtain2.recycle();
    }

    @Override // android.app.IActivityManager
    public void unstableProviderDied(IBinder iBinder) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        obtain.writeStrongBinder(iBinder);
        this.mRemote.transact(151, obtain, obtain2, 0);
        obtain2.readException();
        obtain.recycle();
        obtain2.recycle();
    }

    @Override // android.app.IActivityManager
    public void updateConfiguration(Configuration configuration) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        configuration.writeToParcel(obtain, 0);
        this.mRemote.transact(47, obtain, obtain2, 0);
        obtain2.readException();
        obtain.recycle();
        obtain2.recycle();
    }

    @Override // android.app.IActivityManager
    public void updatePersistentConfiguration(Configuration configuration) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        configuration.writeToParcel(obtain, 0);
        this.mRemote.transact(136, obtain, obtain2, 0);
        obtain2.readException();
        obtain.recycle();
        obtain2.recycle();
    }

    @Override // android.app.IActivityManager
    public boolean willActivityBeVisible(IBinder iBinder) throws RemoteException {
        boolean z = false;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IActivityManager.descriptor);
        obtain.writeStrongBinder(iBinder);
        this.mRemote.transact(106, obtain, obtain2, 0);
        obtain2.readException();
        if (obtain2.readInt() != 0) {
            z = true;
        }
        obtain.recycle();
        obtain2.recycle();
        return z;
    }
}
