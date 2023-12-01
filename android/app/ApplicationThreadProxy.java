package android.app;

import android.content.ComponentName;
import android.content.IIntentReceiver;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.ProviderInfo;
import android.content.pm.ServiceInfo;
import android.content.res.CompatibilityInfo;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.os.Debug;
import android.os.IBinder;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.PersistableBundle;
import android.os.RemoteException;
import com.android.internal.app.IVoiceInteractor;
import com.android.internal.content.ReferrerIntent;
import java.io.FileDescriptor;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-9557208-dex2jar.jar:android/app/ApplicationThreadProxy.class */
public class ApplicationThreadProxy implements IApplicationThread {
    private final IBinder mRemote;

    public ApplicationThreadProxy(IBinder iBinder) {
        this.mRemote = iBinder;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.mRemote;
    }

    @Override // android.app.IApplicationThread
    public final void bindApplication(String str, ApplicationInfo applicationInfo, List<ProviderInfo> list, ComponentName componentName, ProfilerInfo profilerInfo, Bundle bundle, IInstrumentationWatcher iInstrumentationWatcher, IUiAutomationConnection iUiAutomationConnection, int i, boolean z, boolean z2, boolean z3, Configuration configuration, CompatibilityInfo compatibilityInfo, Map<String, IBinder> map, Bundle bundle2) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(IApplicationThread.descriptor);
        obtain.writeString(str);
        applicationInfo.writeToParcel(obtain, 0);
        obtain.writeTypedList(list);
        if (componentName == null) {
            obtain.writeInt(0);
        } else {
            obtain.writeInt(1);
            componentName.writeToParcel(obtain, 0);
        }
        if (profilerInfo != null) {
            obtain.writeInt(1);
            profilerInfo.writeToParcel(obtain, 1);
        } else {
            obtain.writeInt(0);
        }
        obtain.writeBundle(bundle);
        obtain.writeStrongInterface(iInstrumentationWatcher);
        obtain.writeStrongInterface(iUiAutomationConnection);
        obtain.writeInt(i);
        obtain.writeInt(z ? 1 : 0);
        obtain.writeInt(z2 ? 1 : 0);
        obtain.writeInt(z3 ? 1 : 0);
        configuration.writeToParcel(obtain, 0);
        compatibilityInfo.writeToParcel(obtain, 0);
        obtain.writeMap(map);
        obtain.writeBundle(bundle2);
        this.mRemote.transact(13, obtain, null, 1);
        obtain.recycle();
    }

    @Override // android.app.IApplicationThread
    public void clearDnsCache() throws RemoteException {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(IApplicationThread.descriptor);
        this.mRemote.transact(38, obtain, null, 1);
        obtain.recycle();
    }

    @Override // android.app.IApplicationThread
    public void dispatchPackageBroadcast(int i, String[] strArr) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(IApplicationThread.descriptor);
        obtain.writeInt(i);
        obtain.writeStringArray(strArr);
        this.mRemote.transact(34, obtain, null, 1);
        obtain.recycle();
    }

    @Override // android.app.IApplicationThread
    public void dumpActivity(FileDescriptor fileDescriptor, IBinder iBinder, String str, String[] strArr) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(IApplicationThread.descriptor);
        obtain.writeFileDescriptor(fileDescriptor);
        obtain.writeStrongBinder(iBinder);
        obtain.writeString(str);
        obtain.writeStringArray(strArr);
        this.mRemote.transact(37, obtain, null, 1);
        obtain.recycle();
    }

    @Override // android.app.IApplicationThread
    public void dumpDbInfo(FileDescriptor fileDescriptor, String[] strArr) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(IApplicationThread.descriptor);
        obtain.writeFileDescriptor(fileDescriptor);
        obtain.writeStringArray(strArr);
        this.mRemote.transact(46, obtain, null, 1);
        obtain.recycle();
    }

    @Override // android.app.IApplicationThread
    public void dumpGfxInfo(FileDescriptor fileDescriptor, String[] strArr) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(IApplicationThread.descriptor);
        obtain.writeFileDescriptor(fileDescriptor);
        obtain.writeStringArray(strArr);
        this.mRemote.transact(44, obtain, null, 1);
        obtain.recycle();
    }

    @Override // android.app.IApplicationThread
    public void dumpHeap(boolean z, String str, ParcelFileDescriptor parcelFileDescriptor) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(IApplicationThread.descriptor);
        obtain.writeInt(z ? 1 : 0);
        obtain.writeString(str);
        if (parcelFileDescriptor != null) {
            obtain.writeInt(1);
            parcelFileDescriptor.writeToParcel(obtain, 1);
        } else {
            obtain.writeInt(0);
        }
        this.mRemote.transact(36, obtain, null, 1);
        obtain.recycle();
    }

    @Override // android.app.IApplicationThread
    public void dumpMemInfo(FileDescriptor fileDescriptor, Debug.MemoryInfo memoryInfo, boolean z, boolean z2, boolean z3, String[] strArr) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IApplicationThread.descriptor);
        obtain.writeFileDescriptor(fileDescriptor);
        memoryInfo.writeToParcel(obtain, 0);
        obtain.writeInt(z ? 1 : 0);
        obtain.writeInt(z2 ? 1 : 0);
        obtain.writeInt(z3 ? 1 : 0);
        obtain.writeStringArray(strArr);
        this.mRemote.transact(43, obtain, obtain2, 0);
        obtain2.readException();
        obtain.recycle();
        obtain2.recycle();
    }

    @Override // android.app.IApplicationThread
    public void dumpProvider(FileDescriptor fileDescriptor, IBinder iBinder, String[] strArr) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(IApplicationThread.descriptor);
        obtain.writeFileDescriptor(fileDescriptor);
        obtain.writeStrongBinder(iBinder);
        obtain.writeStringArray(strArr);
        this.mRemote.transact(45, obtain, null, 1);
        obtain.recycle();
    }

    @Override // android.app.IApplicationThread
    public void dumpService(FileDescriptor fileDescriptor, IBinder iBinder, String[] strArr) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(IApplicationThread.descriptor);
        obtain.writeFileDescriptor(fileDescriptor);
        obtain.writeStrongBinder(iBinder);
        obtain.writeStringArray(strArr);
        this.mRemote.transact(22, obtain, null, 1);
        obtain.recycle();
    }

    @Override // android.app.IApplicationThread
    public void processInBackground() throws RemoteException {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(IApplicationThread.descriptor);
        this.mRemote.transact(19, obtain, null, 1);
        obtain.recycle();
    }

    @Override // android.app.IApplicationThread
    public void profilerControl(boolean z, ProfilerInfo profilerInfo, int i) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(IApplicationThread.descriptor);
        obtain.writeInt(z ? 1 : 0);
        obtain.writeInt(i);
        if (profilerInfo != null) {
            obtain.writeInt(1);
            profilerInfo.writeToParcel(obtain, 1);
        } else {
            obtain.writeInt(0);
        }
        this.mRemote.transact(28, obtain, null, 1);
        obtain.recycle();
    }

    @Override // android.app.IApplicationThread
    public void requestAssistContextExtras(IBinder iBinder, IBinder iBinder2, int i) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(IApplicationThread.descriptor);
        obtain.writeStrongBinder(iBinder);
        obtain.writeStrongBinder(iBinder2);
        obtain.writeInt(i);
        this.mRemote.transact(48, obtain, null, 1);
        obtain.recycle();
    }

    @Override // android.app.IApplicationThread
    public final void scheduleActivityConfigurationChanged(IBinder iBinder) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(IApplicationThread.descriptor);
        obtain.writeStrongBinder(iBinder);
        this.mRemote.transact(25, obtain, null, 1);
        obtain.recycle();
    }

    @Override // android.app.IApplicationThread
    public void scheduleBackgroundVisibleBehindChanged(IBinder iBinder, boolean z) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(IApplicationThread.descriptor);
        obtain.writeStrongBinder(iBinder);
        obtain.writeInt(z ? 1 : 0);
        this.mRemote.transact(54, obtain, null, 1);
        obtain.recycle();
    }

    @Override // android.app.IApplicationThread
    public final void scheduleBindService(IBinder iBinder, Intent intent, boolean z, int i) throws RemoteException {
        int i2 = 0;
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(IApplicationThread.descriptor);
        obtain.writeStrongBinder(iBinder);
        intent.writeToParcel(obtain, 0);
        if (z) {
            i2 = 1;
        }
        obtain.writeInt(i2);
        obtain.writeInt(i);
        this.mRemote.transact(20, obtain, null, 1);
        obtain.recycle();
    }

    @Override // android.app.IApplicationThread
    public void scheduleCancelVisibleBehind(IBinder iBinder) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(IApplicationThread.descriptor);
        obtain.writeStrongBinder(iBinder);
        this.mRemote.transact(53, obtain, null, 1);
        obtain.recycle();
    }

    @Override // android.app.IApplicationThread
    public final void scheduleConfigurationChanged(Configuration configuration) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(IApplicationThread.descriptor);
        configuration.writeToParcel(obtain, 0);
        this.mRemote.transact(16, obtain, null, 1);
        obtain.recycle();
    }

    @Override // android.app.IApplicationThread
    public void scheduleCrash(String str) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(IApplicationThread.descriptor);
        obtain.writeString(str);
        this.mRemote.transact(35, obtain, null, 1);
        obtain.recycle();
    }

    @Override // android.app.IApplicationThread
    public final void scheduleCreateBackupAgent(ApplicationInfo applicationInfo, CompatibilityInfo compatibilityInfo, int i) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(IApplicationThread.descriptor);
        applicationInfo.writeToParcel(obtain, 0);
        compatibilityInfo.writeToParcel(obtain, 0);
        obtain.writeInt(i);
        this.mRemote.transact(30, obtain, null, 1);
        obtain.recycle();
    }

    @Override // android.app.IApplicationThread
    public final void scheduleCreateService(IBinder iBinder, ServiceInfo serviceInfo, CompatibilityInfo compatibilityInfo, int i) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(IApplicationThread.descriptor);
        obtain.writeStrongBinder(iBinder);
        serviceInfo.writeToParcel(obtain, 0);
        compatibilityInfo.writeToParcel(obtain, 0);
        obtain.writeInt(i);
        this.mRemote.transact(11, obtain, null, 1);
        obtain.recycle();
    }

    @Override // android.app.IApplicationThread
    public final void scheduleDestroyActivity(IBinder iBinder, boolean z, int i) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(IApplicationThread.descriptor);
        obtain.writeStrongBinder(iBinder);
        obtain.writeInt(z ? 1 : 0);
        obtain.writeInt(i);
        this.mRemote.transact(9, obtain, null, 1);
        obtain.recycle();
    }

    @Override // android.app.IApplicationThread
    public final void scheduleDestroyBackupAgent(ApplicationInfo applicationInfo, CompatibilityInfo compatibilityInfo) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(IApplicationThread.descriptor);
        applicationInfo.writeToParcel(obtain, 0);
        compatibilityInfo.writeToParcel(obtain, 0);
        this.mRemote.transact(31, obtain, null, 1);
        obtain.recycle();
    }

    @Override // android.app.IApplicationThread
    public void scheduleEnterAnimationComplete(IBinder iBinder) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(IApplicationThread.descriptor);
        obtain.writeStrongBinder(iBinder);
        this.mRemote.transact(55, obtain, null, 1);
        obtain.recycle();
    }

    @Override // android.app.IApplicationThread
    public final void scheduleExit() throws RemoteException {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(IApplicationThread.descriptor);
        this.mRemote.transact(14, obtain, null, 1);
        obtain.recycle();
    }

    @Override // android.app.IApplicationThread
    public void scheduleInstallProvider(ProviderInfo providerInfo) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(IApplicationThread.descriptor);
        providerInfo.writeToParcel(obtain, 0);
        this.mRemote.transact(51, obtain, null, 1);
        obtain.recycle();
    }

    @Override // android.app.IApplicationThread
    public final void scheduleLaunchActivity(Intent intent, IBinder iBinder, int i, ActivityInfo activityInfo, Configuration configuration, CompatibilityInfo compatibilityInfo, String str, IVoiceInteractor iVoiceInteractor, int i2, Bundle bundle, PersistableBundle persistableBundle, List<ResultInfo> list, List<ReferrerIntent> list2, boolean z, boolean z2, ProfilerInfo profilerInfo) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(IApplicationThread.descriptor);
        intent.writeToParcel(obtain, 0);
        obtain.writeStrongBinder(iBinder);
        obtain.writeInt(i);
        activityInfo.writeToParcel(obtain, 0);
        configuration.writeToParcel(obtain, 0);
        compatibilityInfo.writeToParcel(obtain, 0);
        obtain.writeString(str);
        obtain.writeStrongBinder(iVoiceInteractor != null ? iVoiceInteractor.asBinder() : null);
        obtain.writeInt(i2);
        obtain.writeBundle(bundle);
        obtain.writePersistableBundle(persistableBundle);
        obtain.writeTypedList(list);
        obtain.writeTypedList(list2);
        obtain.writeInt(z ? 1 : 0);
        obtain.writeInt(z2 ? 1 : 0);
        if (profilerInfo != null) {
            obtain.writeInt(1);
            profilerInfo.writeToParcel(obtain, 1);
        } else {
            obtain.writeInt(0);
        }
        this.mRemote.transact(7, obtain, null, 1);
        obtain.recycle();
    }

    @Override // android.app.IApplicationThread
    public final void scheduleLowMemory() throws RemoteException {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(IApplicationThread.descriptor);
        this.mRemote.transact(24, obtain, null, 1);
        obtain.recycle();
    }

    @Override // android.app.IApplicationThread
    public void scheduleNewIntent(List<ReferrerIntent> list, IBinder iBinder) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(IApplicationThread.descriptor);
        obtain.writeTypedList(list);
        obtain.writeStrongBinder(iBinder);
        this.mRemote.transact(8, obtain, null, 1);
        obtain.recycle();
    }

    @Override // android.app.IApplicationThread
    public void scheduleOnNewActivityOptions(IBinder iBinder, ActivityOptions activityOptions) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(IApplicationThread.descriptor);
        obtain.writeStrongBinder(iBinder);
        obtain.writeBundle(activityOptions == null ? null : activityOptions.toBundle());
        this.mRemote.transact(32, obtain, null, 1);
        obtain.recycle();
    }

    @Override // android.app.IApplicationThread
    public final void schedulePauseActivity(IBinder iBinder, boolean z, boolean z2, int i, boolean z3) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(IApplicationThread.descriptor);
        obtain.writeStrongBinder(iBinder);
        obtain.writeInt(z ? 1 : 0);
        obtain.writeInt(z2 ? 1 : 0);
        obtain.writeInt(i);
        int i2 = 0;
        if (z3) {
            i2 = 1;
        }
        obtain.writeInt(i2);
        this.mRemote.transact(1, obtain, null, 1);
        obtain.recycle();
    }

    @Override // android.app.IApplicationThread
    public final void scheduleReceiver(Intent intent, ActivityInfo activityInfo, CompatibilityInfo compatibilityInfo, int i, String str, Bundle bundle, boolean z, int i2, int i3) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(IApplicationThread.descriptor);
        intent.writeToParcel(obtain, 0);
        activityInfo.writeToParcel(obtain, 0);
        compatibilityInfo.writeToParcel(obtain, 0);
        obtain.writeInt(i);
        obtain.writeString(str);
        obtain.writeBundle(bundle);
        int i4 = 0;
        if (z) {
            i4 = 1;
        }
        obtain.writeInt(i4);
        obtain.writeInt(i2);
        obtain.writeInt(i3);
        this.mRemote.transact(10, obtain, null, 1);
        obtain.recycle();
    }

    @Override // android.app.IApplicationThread
    public void scheduleRegisteredReceiver(IIntentReceiver iIntentReceiver, Intent intent, int i, String str, Bundle bundle, boolean z, boolean z2, int i2, int i3) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(IApplicationThread.descriptor);
        obtain.writeStrongBinder(iIntentReceiver.asBinder());
        intent.writeToParcel(obtain, 0);
        obtain.writeInt(i);
        obtain.writeString(str);
        obtain.writeBundle(bundle);
        obtain.writeInt(z ? 1 : 0);
        int i4 = 0;
        if (z2) {
            i4 = 1;
        }
        obtain.writeInt(i4);
        obtain.writeInt(i2);
        obtain.writeInt(i3);
        this.mRemote.transact(23, obtain, null, 1);
        obtain.recycle();
    }

    @Override // android.app.IApplicationThread
    public final void scheduleRelaunchActivity(IBinder iBinder, List<ResultInfo> list, List<ReferrerIntent> list2, int i, boolean z, Configuration configuration) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(IApplicationThread.descriptor);
        obtain.writeStrongBinder(iBinder);
        obtain.writeTypedList(list);
        obtain.writeTypedList(list2);
        obtain.writeInt(i);
        obtain.writeInt(z ? 1 : 0);
        if (configuration != null) {
            obtain.writeInt(1);
            configuration.writeToParcel(obtain, 0);
        } else {
            obtain.writeInt(0);
        }
        this.mRemote.transact(26, obtain, null, 1);
        obtain.recycle();
    }

    @Override // android.app.IApplicationThread
    public final void scheduleResumeActivity(IBinder iBinder, int i, boolean z, Bundle bundle) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(IApplicationThread.descriptor);
        obtain.writeStrongBinder(iBinder);
        obtain.writeInt(i);
        obtain.writeInt(z ? 1 : 0);
        obtain.writeBundle(bundle);
        this.mRemote.transact(5, obtain, null, 1);
        obtain.recycle();
    }

    @Override // android.app.IApplicationThread
    public final void scheduleSendResult(IBinder iBinder, List<ResultInfo> list) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(IApplicationThread.descriptor);
        obtain.writeStrongBinder(iBinder);
        obtain.writeTypedList(list);
        this.mRemote.transact(6, obtain, null, 1);
        obtain.recycle();
    }

    @Override // android.app.IApplicationThread
    public final void scheduleServiceArgs(IBinder iBinder, boolean z, int i, int i2, Intent intent) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(IApplicationThread.descriptor);
        obtain.writeStrongBinder(iBinder);
        obtain.writeInt(z ? 1 : 0);
        obtain.writeInt(i);
        obtain.writeInt(i2);
        if (intent != null) {
            obtain.writeInt(1);
            intent.writeToParcel(obtain, 0);
        } else {
            obtain.writeInt(0);
        }
        this.mRemote.transact(17, obtain, null, 1);
        obtain.recycle();
    }

    @Override // android.app.IApplicationThread
    public final void scheduleSleeping(IBinder iBinder, boolean z) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(IApplicationThread.descriptor);
        obtain.writeStrongBinder(iBinder);
        obtain.writeInt(z ? 1 : 0);
        this.mRemote.transact(27, obtain, null, 1);
        obtain.recycle();
    }

    @Override // android.app.IApplicationThread
    public final void scheduleStopActivity(IBinder iBinder, boolean z, int i) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(IApplicationThread.descriptor);
        obtain.writeStrongBinder(iBinder);
        obtain.writeInt(z ? 1 : 0);
        obtain.writeInt(i);
        this.mRemote.transact(3, obtain, null, 1);
        obtain.recycle();
    }

    @Override // android.app.IApplicationThread
    public final void scheduleStopService(IBinder iBinder) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(IApplicationThread.descriptor);
        obtain.writeStrongBinder(iBinder);
        this.mRemote.transact(12, obtain, null, 1);
        obtain.recycle();
    }

    @Override // android.app.IApplicationThread
    public final void scheduleSuicide() throws RemoteException {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(IApplicationThread.descriptor);
        this.mRemote.transact(33, obtain, null, 1);
        obtain.recycle();
    }

    @Override // android.app.IApplicationThread
    public void scheduleTranslucentConversionComplete(IBinder iBinder, boolean z) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(IApplicationThread.descriptor);
        obtain.writeStrongBinder(iBinder);
        obtain.writeInt(z ? 1 : 0);
        this.mRemote.transact(49, obtain, null, 1);
        obtain.recycle();
    }

    @Override // android.app.IApplicationThread
    public void scheduleTrimMemory(int i) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(IApplicationThread.descriptor);
        obtain.writeInt(i);
        this.mRemote.transact(42, obtain, null, 1);
        obtain.recycle();
    }

    @Override // android.app.IApplicationThread
    public final void scheduleUnbindService(IBinder iBinder, Intent intent) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(IApplicationThread.descriptor);
        obtain.writeStrongBinder(iBinder);
        intent.writeToParcel(obtain, 0);
        this.mRemote.transact(21, obtain, null, 1);
        obtain.recycle();
    }

    @Override // android.app.IApplicationThread
    public final void scheduleWindowVisibility(IBinder iBinder, boolean z) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(IApplicationThread.descriptor);
        obtain.writeStrongBinder(iBinder);
        obtain.writeInt(z ? 1 : 0);
        this.mRemote.transact(4, obtain, null, 1);
        obtain.recycle();
    }

    @Override // android.app.IApplicationThread
    public void setCoreSettings(Bundle bundle) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(IApplicationThread.descriptor);
        obtain.writeBundle(bundle);
        this.mRemote.transact(40, obtain, null, 1);
    }

    @Override // android.app.IApplicationThread
    public void setHttpProxy(String str, String str2, String str3, Uri uri) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(IApplicationThread.descriptor);
        obtain.writeString(str);
        obtain.writeString(str2);
        obtain.writeString(str3);
        uri.writeToParcel(obtain, 0);
        this.mRemote.transact(39, obtain, null, 1);
        obtain.recycle();
    }

    @Override // android.app.IApplicationThread
    public void setProcessState(int i) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(IApplicationThread.descriptor);
        obtain.writeInt(i);
        this.mRemote.transact(50, obtain, null, 1);
        obtain.recycle();
    }

    @Override // android.app.IApplicationThread
    public void setSchedulingGroup(int i) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(IApplicationThread.descriptor);
        obtain.writeInt(i);
        this.mRemote.transact(29, obtain, null, 1);
        obtain.recycle();
    }

    @Override // android.app.IApplicationThread
    public void unstableProviderDied(IBinder iBinder) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(IApplicationThread.descriptor);
        obtain.writeStrongBinder(iBinder);
        this.mRemote.transact(47, obtain, null, 1);
        obtain.recycle();
    }

    @Override // android.app.IApplicationThread
    public void updatePackageCompatibilityInfo(String str, CompatibilityInfo compatibilityInfo) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(IApplicationThread.descriptor);
        obtain.writeString(str);
        compatibilityInfo.writeToParcel(obtain, 0);
        this.mRemote.transact(41, obtain, null, 1);
    }

    @Override // android.app.IApplicationThread
    public void updateTimePrefs(boolean z) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(IApplicationThread.descriptor);
        obtain.writeByte(z ? (byte) 1 : (byte) 0);
        this.mRemote.transact(52, obtain, null, 1);
        obtain.recycle();
    }

    @Override // android.app.IApplicationThread
    public void updateTimeZone() throws RemoteException {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(IApplicationThread.descriptor);
        this.mRemote.transact(18, obtain, null, 1);
        obtain.recycle();
    }
}
