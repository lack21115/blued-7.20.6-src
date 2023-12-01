package android.app;

import android.app.IInstrumentationWatcher;
import android.app.IUiAutomationConnection;
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
import android.os.Binder;
import android.os.Debug;
import android.os.IBinder;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import com.android.internal.app.IVoiceInteractor;
import com.android.internal.content.ReferrerIntent;
import java.io.IOException;
import java.util.ArrayList;

/* loaded from: source-9557208-dex2jar.jar:android/app/ApplicationThreadNative.class */
public abstract class ApplicationThreadNative extends Binder implements IApplicationThread {
    public ApplicationThreadNative() {
        attachInterface(this, IApplicationThread.descriptor);
    }

    public static IApplicationThread asInterface(IBinder iBinder) {
        IApplicationThread iApplicationThread;
        if (iBinder == null) {
            iApplicationThread = null;
        } else {
            IApplicationThread iApplicationThread2 = (IApplicationThread) iBinder.queryLocalInterface(IApplicationThread.descriptor);
            iApplicationThread = iApplicationThread2;
            if (iApplicationThread2 == null) {
                return new ApplicationThreadProxy(iBinder);
            }
        }
        return iApplicationThread;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this;
    }

    @Override // android.os.Binder
    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        ParcelFileDescriptor readFileDescriptor;
        switch (i) {
            case 1:
                parcel.enforceInterface(IApplicationThread.descriptor);
                schedulePauseActivity(parcel.readStrongBinder(), parcel.readInt() != 0, parcel.readInt() != 0, parcel.readInt(), parcel.readInt() != 0);
                return true;
            case 2:
            case 15:
            default:
                return super.onTransact(i, parcel, parcel2, i2);
            case 3:
                parcel.enforceInterface(IApplicationThread.descriptor);
                scheduleStopActivity(parcel.readStrongBinder(), parcel.readInt() != 0, parcel.readInt());
                return true;
            case 4:
                parcel.enforceInterface(IApplicationThread.descriptor);
                scheduleWindowVisibility(parcel.readStrongBinder(), parcel.readInt() != 0);
                return true;
            case 5:
                parcel.enforceInterface(IApplicationThread.descriptor);
                scheduleResumeActivity(parcel.readStrongBinder(), parcel.readInt(), parcel.readInt() != 0, parcel.readBundle());
                return true;
            case 6:
                parcel.enforceInterface(IApplicationThread.descriptor);
                scheduleSendResult(parcel.readStrongBinder(), parcel.createTypedArrayList(ResultInfo.CREATOR));
                return true;
            case 7:
                parcel.enforceInterface(IApplicationThread.descriptor);
                scheduleLaunchActivity(Intent.CREATOR.createFromParcel(parcel), parcel.readStrongBinder(), parcel.readInt(), ActivityInfo.CREATOR.createFromParcel(parcel), Configuration.CREATOR.createFromParcel(parcel), CompatibilityInfo.CREATOR.createFromParcel(parcel), parcel.readString(), IVoiceInteractor.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readBundle(), parcel.readPersistableBundle(), parcel.createTypedArrayList(ResultInfo.CREATOR), parcel.createTypedArrayList(ReferrerIntent.CREATOR), parcel.readInt() != 0, parcel.readInt() != 0, parcel.readInt() != 0 ? ProfilerInfo.CREATOR.createFromParcel(parcel) : null);
                return true;
            case 8:
                parcel.enforceInterface(IApplicationThread.descriptor);
                scheduleNewIntent(parcel.createTypedArrayList(ReferrerIntent.CREATOR), parcel.readStrongBinder());
                return true;
            case 9:
                parcel.enforceInterface(IApplicationThread.descriptor);
                scheduleDestroyActivity(parcel.readStrongBinder(), parcel.readInt() != 0, parcel.readInt());
                return true;
            case 10:
                parcel.enforceInterface(IApplicationThread.descriptor);
                scheduleReceiver(Intent.CREATOR.createFromParcel(parcel), ActivityInfo.CREATOR.createFromParcel(parcel), CompatibilityInfo.CREATOR.createFromParcel(parcel), parcel.readInt(), parcel.readString(), parcel.readBundle(), parcel.readInt() != 0, parcel.readInt(), parcel.readInt());
                return true;
            case 11:
                parcel.enforceInterface(IApplicationThread.descriptor);
                scheduleCreateService(parcel.readStrongBinder(), ServiceInfo.CREATOR.createFromParcel(parcel), CompatibilityInfo.CREATOR.createFromParcel(parcel), parcel.readInt());
                return true;
            case 12:
                parcel.enforceInterface(IApplicationThread.descriptor);
                scheduleStopService(parcel.readStrongBinder());
                return true;
            case 13:
                parcel.enforceInterface(IApplicationThread.descriptor);
                bindApplication(parcel.readString(), ApplicationInfo.CREATOR.createFromParcel(parcel), parcel.createTypedArrayList(ProviderInfo.CREATOR), parcel.readInt() != 0 ? new ComponentName(parcel) : null, parcel.readInt() != 0 ? ProfilerInfo.CREATOR.createFromParcel(parcel) : null, parcel.readBundle(), IInstrumentationWatcher.Stub.asInterface(parcel.readStrongBinder()), IUiAutomationConnection.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt() != 0, parcel.readInt() != 0, parcel.readInt() != 0, Configuration.CREATOR.createFromParcel(parcel), CompatibilityInfo.CREATOR.createFromParcel(parcel), parcel.readHashMap(null), parcel.readBundle());
                return true;
            case 14:
                parcel.enforceInterface(IApplicationThread.descriptor);
                scheduleExit();
                return true;
            case 16:
                parcel.enforceInterface(IApplicationThread.descriptor);
                scheduleConfigurationChanged(Configuration.CREATOR.createFromParcel(parcel));
                return true;
            case 17:
                parcel.enforceInterface(IApplicationThread.descriptor);
                scheduleServiceArgs(parcel.readStrongBinder(), parcel.readInt() != 0, parcel.readInt(), parcel.readInt(), parcel.readInt() != 0 ? Intent.CREATOR.createFromParcel(parcel) : null);
                return true;
            case 18:
                parcel.enforceInterface(IApplicationThread.descriptor);
                updateTimeZone();
                return true;
            case 19:
                parcel.enforceInterface(IApplicationThread.descriptor);
                processInBackground();
                return true;
            case 20:
                parcel.enforceInterface(IApplicationThread.descriptor);
                scheduleBindService(parcel.readStrongBinder(), Intent.CREATOR.createFromParcel(parcel), parcel.readInt() != 0, parcel.readInt());
                return true;
            case 21:
                parcel.enforceInterface(IApplicationThread.descriptor);
                scheduleUnbindService(parcel.readStrongBinder(), Intent.CREATOR.createFromParcel(parcel));
                return true;
            case 22:
                parcel.enforceInterface(IApplicationThread.descriptor);
                readFileDescriptor = parcel.readFileDescriptor();
                IBinder readStrongBinder = parcel.readStrongBinder();
                String[] readStringArray = parcel.readStringArray();
                if (readFileDescriptor != null) {
                    dumpService(readFileDescriptor.getFileDescriptor(), readStrongBinder, readStringArray);
                    try {
                        return true;
                    } catch (IOException e) {
                        return true;
                    }
                }
                return true;
            case 23:
                parcel.enforceInterface(IApplicationThread.descriptor);
                scheduleRegisteredReceiver(IIntentReceiver.Stub.asInterface(parcel.readStrongBinder()), Intent.CREATOR.createFromParcel(parcel), parcel.readInt(), parcel.readString(), parcel.readBundle(), parcel.readInt() != 0, parcel.readInt() != 0, parcel.readInt(), parcel.readInt());
                return true;
            case 24:
                parcel.enforceInterface(IApplicationThread.descriptor);
                scheduleLowMemory();
                return true;
            case 25:
                parcel.enforceInterface(IApplicationThread.descriptor);
                scheduleActivityConfigurationChanged(parcel.readStrongBinder());
                return true;
            case 26:
                parcel.enforceInterface(IApplicationThread.descriptor);
                IBinder readStrongBinder2 = parcel.readStrongBinder();
                ArrayList createTypedArrayList = parcel.createTypedArrayList(ResultInfo.CREATOR);
                ArrayList createTypedArrayList2 = parcel.createTypedArrayList(ReferrerIntent.CREATOR);
                int readInt = parcel.readInt();
                boolean z = parcel.readInt() != 0;
                Configuration configuration = null;
                if (parcel.readInt() != 0) {
                    configuration = Configuration.CREATOR.createFromParcel(parcel);
                }
                scheduleRelaunchActivity(readStrongBinder2, createTypedArrayList, createTypedArrayList2, readInt, z, configuration);
                return true;
            case 27:
                parcel.enforceInterface(IApplicationThread.descriptor);
                scheduleSleeping(parcel.readStrongBinder(), parcel.readInt() != 0);
                return true;
            case 28:
                parcel.enforceInterface(IApplicationThread.descriptor);
                profilerControl(parcel.readInt() != 0, parcel.readInt() != 0 ? ProfilerInfo.CREATOR.createFromParcel(parcel) : null, parcel.readInt());
                return true;
            case 29:
                parcel.enforceInterface(IApplicationThread.descriptor);
                setSchedulingGroup(parcel.readInt());
                return true;
            case 30:
                parcel.enforceInterface(IApplicationThread.descriptor);
                scheduleCreateBackupAgent(ApplicationInfo.CREATOR.createFromParcel(parcel), CompatibilityInfo.CREATOR.createFromParcel(parcel), parcel.readInt());
                return true;
            case 31:
                parcel.enforceInterface(IApplicationThread.descriptor);
                scheduleDestroyBackupAgent(ApplicationInfo.CREATOR.createFromParcel(parcel), CompatibilityInfo.CREATOR.createFromParcel(parcel));
                return true;
            case 32:
                parcel.enforceInterface(IApplicationThread.descriptor);
                scheduleOnNewActivityOptions(parcel.readStrongBinder(), new ActivityOptions(parcel.readBundle()));
                parcel2.writeNoException();
                return true;
            case 33:
                parcel.enforceInterface(IApplicationThread.descriptor);
                scheduleSuicide();
                return true;
            case 34:
                parcel.enforceInterface(IApplicationThread.descriptor);
                dispatchPackageBroadcast(parcel.readInt(), parcel.readStringArray());
                return true;
            case 35:
                parcel.enforceInterface(IApplicationThread.descriptor);
                scheduleCrash(parcel.readString());
                return true;
            case 36:
                parcel.enforceInterface(IApplicationThread.descriptor);
                dumpHeap(parcel.readInt() != 0, parcel.readString(), parcel.readInt() != 0 ? ParcelFileDescriptor.CREATOR.createFromParcel(parcel) : null);
                return true;
            case 37:
                parcel.enforceInterface(IApplicationThread.descriptor);
                ParcelFileDescriptor readFileDescriptor2 = parcel.readFileDescriptor();
                IBinder readStrongBinder3 = parcel.readStrongBinder();
                String readString = parcel.readString();
                String[] readStringArray2 = parcel.readStringArray();
                if (readFileDescriptor2 != null) {
                    dumpActivity(readFileDescriptor2.getFileDescriptor(), readStrongBinder3, readString, readStringArray2);
                    try {
                        readFileDescriptor2.close();
                        return true;
                    } catch (IOException e2) {
                        return true;
                    }
                }
                return true;
            case 38:
                parcel.enforceInterface(IApplicationThread.descriptor);
                clearDnsCache();
                return true;
            case 39:
                parcel.enforceInterface(IApplicationThread.descriptor);
                setHttpProxy(parcel.readString(), parcel.readString(), parcel.readString(), Uri.CREATOR.createFromParcel(parcel));
                return true;
            case 40:
                parcel.enforceInterface(IApplicationThread.descriptor);
                setCoreSettings(parcel.readBundle());
                return true;
            case 41:
                parcel.enforceInterface(IApplicationThread.descriptor);
                updatePackageCompatibilityInfo(parcel.readString(), CompatibilityInfo.CREATOR.createFromParcel(parcel));
                return true;
            case 42:
                parcel.enforceInterface(IApplicationThread.descriptor);
                scheduleTrimMemory(parcel.readInt());
                return true;
            case 43:
                parcel.enforceInterface(IApplicationThread.descriptor);
                ParcelFileDescriptor readFileDescriptor3 = parcel.readFileDescriptor();
                Debug.MemoryInfo createFromParcel = Debug.MemoryInfo.CREATOR.createFromParcel(parcel);
                boolean z2 = parcel.readInt() != 0;
                boolean z3 = parcel.readInt() != 0;
                boolean z4 = parcel.readInt() != 0;
                String[] readStringArray3 = parcel.readStringArray();
                if (readFileDescriptor3 != null) {
                    try {
                        dumpMemInfo(readFileDescriptor3.getFileDescriptor(), createFromParcel, z2, z3, z4, readStringArray3);
                        try {
                            readFileDescriptor3.close();
                        } catch (IOException e3) {
                        }
                    } finally {
                        try {
                            readFileDescriptor3.close();
                        } catch (IOException e4) {
                        }
                    }
                }
                parcel2.writeNoException();
                return true;
            case 44:
                parcel.enforceInterface(IApplicationThread.descriptor);
                ParcelFileDescriptor readFileDescriptor4 = parcel.readFileDescriptor();
                String[] readStringArray4 = parcel.readStringArray();
                if (readFileDescriptor4 != null) {
                    try {
                        dumpGfxInfo(readFileDescriptor4.getFileDescriptor(), readStringArray4);
                        try {
                            readFileDescriptor4.close();
                        } catch (IOException e5) {
                        }
                    } finally {
                        try {
                            readFileDescriptor4.close();
                        } catch (IOException e6) {
                        }
                    }
                }
                parcel2.writeNoException();
                return true;
            case 45:
                parcel.enforceInterface(IApplicationThread.descriptor);
                ParcelFileDescriptor readFileDescriptor5 = parcel.readFileDescriptor();
                IBinder readStrongBinder4 = parcel.readStrongBinder();
                String[] readStringArray5 = parcel.readStringArray();
                if (readFileDescriptor5 != null) {
                    dumpProvider(readFileDescriptor5.getFileDescriptor(), readStrongBinder4, readStringArray5);
                    try {
                        readFileDescriptor5.close();
                        return true;
                    } catch (IOException e7) {
                        return true;
                    }
                }
                return true;
            case 46:
                parcel.enforceInterface(IApplicationThread.descriptor);
                readFileDescriptor = parcel.readFileDescriptor();
                String[] readStringArray6 = parcel.readStringArray();
                if (readFileDescriptor != null) {
                    try {
                        dumpDbInfo(readFileDescriptor.getFileDescriptor(), readStringArray6);
                        try {
                            readFileDescriptor.close();
                        } catch (IOException e8) {
                        }
                    } finally {
                        try {
                            readFileDescriptor.close();
                        } catch (IOException e9) {
                        }
                    }
                }
                parcel2.writeNoException();
                return true;
            case 47:
                parcel.enforceInterface(IApplicationThread.descriptor);
                unstableProviderDied(parcel.readStrongBinder());
                parcel2.writeNoException();
                return true;
            case 48:
                parcel.enforceInterface(IApplicationThread.descriptor);
                requestAssistContextExtras(parcel.readStrongBinder(), parcel.readStrongBinder(), parcel.readInt());
                parcel2.writeNoException();
                return true;
            case 49:
                parcel.enforceInterface(IApplicationThread.descriptor);
                scheduleTranslucentConversionComplete(parcel.readStrongBinder(), parcel.readInt() == 1);
                parcel2.writeNoException();
                return true;
            case 50:
                parcel.enforceInterface(IApplicationThread.descriptor);
                setProcessState(parcel.readInt());
                parcel2.writeNoException();
                return true;
            case 51:
                parcel.enforceInterface(IApplicationThread.descriptor);
                scheduleInstallProvider(ProviderInfo.CREATOR.createFromParcel(parcel));
                parcel2.writeNoException();
                return true;
            case 52:
                parcel.enforceInterface(IApplicationThread.descriptor);
                updateTimePrefs(parcel.readByte() == 1);
                parcel2.writeNoException();
                return true;
            case 53:
                parcel.enforceInterface(IApplicationThread.descriptor);
                scheduleCancelVisibleBehind(parcel.readStrongBinder());
                parcel2.writeNoException();
                return true;
            case 54:
                parcel.enforceInterface(IApplicationThread.descriptor);
                scheduleBackgroundVisibleBehindChanged(parcel.readStrongBinder(), parcel.readInt() > 0);
                parcel2.writeNoException();
                return true;
            case 55:
                parcel.enforceInterface(IApplicationThread.descriptor);
                scheduleEnterAnimationComplete(parcel.readStrongBinder());
                parcel2.writeNoException();
                return true;
        }
    }
}
