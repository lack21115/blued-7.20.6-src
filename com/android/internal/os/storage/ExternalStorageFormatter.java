package com.android.internal.os.storage;

import android.app.ProgressDialog;
import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Environment;
import android.os.IBinder;
import android.os.Looper;
import android.os.PowerManager;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.storage.IMountService;
import android.os.storage.StorageEventListener;
import android.os.storage.StorageManager;
import android.os.storage.StorageVolume;
import android.util.Log;
import android.widget.Toast;
import com.android.internal.R;
import java.util.ArrayList;

/* loaded from: source-4181928-dex2jar.jar:com/android/internal/os/storage/ExternalStorageFormatter.class */
public class ExternalStorageFormatter extends Service implements DialogInterface.OnCancelListener {
    public static final ComponentName COMPONENT_NAME = new ComponentName("android", ExternalStorageFormatter.class.getName());
    public static final String EXTRA_ALWAYS_RESET = "always_reset";
    public static final String EXTRA_WIPE_MEDIA = "wipe_media";
    public static final String FORMAT_AND_FACTORY_RESET = "com.android.internal.os.storage.FORMAT_AND_FACTORY_RESET";
    public static final String FORMAT_ONLY = "com.android.internal.os.storage.FORMAT_ONLY";
    static final String TAG = "ExternalStorageFormatter";
    private StorageVolume mStorageVolume;
    private PowerManager.WakeLock mWakeLock;
    private IMountService mMountService = null;
    private StorageManager mStorageManager = null;
    private ProgressDialog mProgressDialog = null;
    private boolean mFactoryReset = false;
    private boolean mAlwaysReset = false;
    private boolean mWipeInternalStorage = false;
    private String mReason = null;
    private boolean mIsFormatSuccess = false;
    StorageEventListener mStorageListener = new StorageEventListener() { // from class: com.android.internal.os.storage.ExternalStorageFormatter.1
        @Override // android.os.storage.StorageEventListener
        public void onStorageStateChanged(String str, String str2, String str3) {
            Log.i(ExternalStorageFormatter.TAG, "Received storage state changed notification that " + str + " changed state from " + str2 + " to " + str3);
            ExternalStorageFormatter.this.updateProgressState();
        }
    };

    void fail(int i) {
        Toast.makeText(this, i, 1).show();
        if (this.mAlwaysReset) {
            Intent intent = new Intent(Intent.ACTION_MASTER_CLEAR);
            intent.addFlags(268435456);
            intent.putExtra(Intent.EXTRA_REASON, this.mReason);
            sendBroadcast(intent);
        }
        stopSelf();
    }

    IMountService getMountService() {
        if (this.mMountService == null) {
            IBinder service = ServiceManager.getService("mount");
            if (service != null) {
                this.mMountService = IMountService.Stub.asInterface(service);
            } else {
                Log.e(TAG, "Can't get mount service");
            }
        }
        return this.mMountService;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        IMountService mountService = getMountService();
        try {
            ArrayList<StorageVolume> physicalExternalVolume = StorageManager.getPhysicalExternalVolume(mountService.getVolumeList());
            if (this.mStorageVolume != null) {
                mountService.mountVolume(this.mStorageVolume.getPath());
            } else if (physicalExternalVolume.size() == 0) {
                updateProgressDialog(R.string.progress_nomediapresent);
            } else {
                mountService.mountVolume(physicalExternalVolume.get(0).toString());
            }
        } catch (RemoteException e) {
            Log.w(TAG, "Failed talking with mount service", e);
        }
        stopSelf();
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        if (this.mStorageManager == null) {
            this.mStorageManager = (StorageManager) getSystemService(Context.STORAGE_SERVICE);
            this.mStorageManager.registerListener(this.mStorageListener);
        }
        this.mWakeLock = ((PowerManager) getSystemService("power")).newWakeLock(1, TAG);
        this.mWakeLock.acquire();
    }

    @Override // android.app.Service
    public void onDestroy() {
        if (this.mStorageManager != null) {
            this.mStorageManager.unregisterListener(this.mStorageListener);
        }
        if (this.mProgressDialog != null) {
            this.mProgressDialog.dismiss();
        }
        this.mWakeLock.release();
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        if (FORMAT_AND_FACTORY_RESET.equals(intent.getAction())) {
            this.mFactoryReset = true;
        }
        if (intent.getBooleanExtra(EXTRA_ALWAYS_RESET, false)) {
            this.mAlwaysReset = true;
        }
        this.mWipeInternalStorage = intent.getBooleanExtra(EXTRA_WIPE_MEDIA, false);
        this.mReason = intent.getStringExtra(Intent.EXTRA_REASON);
        this.mStorageVolume = (StorageVolume) intent.getParcelableExtra(StorageVolume.EXTRA_STORAGE_VOLUME);
        if (this.mProgressDialog == null) {
            this.mProgressDialog = new ProgressDialog(this);
            this.mProgressDialog.setIndeterminate(true);
            this.mProgressDialog.setCancelable(true);
            this.mProgressDialog.getWindow().setType(2003);
            if (!this.mAlwaysReset) {
                this.mProgressDialog.setOnCancelListener(this);
            }
            updateProgressState();
            this.mProgressDialog.show();
            return 3;
        }
        return 3;
    }

    public void updateProgressDialog(int i) {
        if (this.mProgressDialog == null) {
            this.mProgressDialog = new ProgressDialog(this);
            this.mProgressDialog.setIndeterminate(true);
            this.mProgressDialog.setCancelable(false);
            this.mProgressDialog.getWindow().setType(2003);
            this.mProgressDialog.show();
        }
        this.mProgressDialog.setMessage(getText(i));
    }

    void updateProgressState() {
        StorageVolume storageVolume;
        boolean z = false;
        String str = null;
        try {
            ArrayList<StorageVolume> physicalExternalVolume = StorageManager.getPhysicalExternalVolume(getMountService().getVolumeList());
            if (this.mStorageVolume != null) {
                String volumeState = this.mStorageManager.getVolumeState(this.mStorageVolume.getPath());
                z = this.mStorageVolume.getDescriptionId() == 17041020;
                str = volumeState;
            } else if (physicalExternalVolume.size() == 0) {
                updateProgressDialog(R.string.progress_nomediapresent);
                return;
            } else {
                StorageVolume storageVolume2 = physicalExternalVolume.get(0);
                String volumeState2 = this.mStorageManager.getVolumeState(storageVolume2.getPath());
                if (storageVolume2.getDescriptionId() == 17041020) {
                    z = true;
                    str = volumeState2;
                } else {
                    z = false;
                    str = volumeState2;
                }
            }
        } catch (RemoteException e) {
            Log.w(TAG, "Failed talking with mount service", e);
        }
        if (Environment.MEDIA_MOUNTED.equals(str) || Environment.MEDIA_MOUNTED_READ_ONLY.equals(str)) {
            updateProgressDialog(z ? 17039521 : 17039514);
            try {
                if (this.mIsFormatSuccess) {
                    return;
                }
                IMountService mountService = getMountService();
                ArrayList<StorageVolume> physicalExternalVolume2 = StorageManager.getPhysicalExternalVolume(mountService.getVolumeList());
                if (this.mStorageVolume != null) {
                    mountService.unmountVolume(this.mStorageVolume.getPath(), true, this.mFactoryReset);
                } else if (physicalExternalVolume2.size() == 0) {
                    updateProgressDialog(R.string.progress_nomediapresent);
                } else {
                    String path = physicalExternalVolume2.get(0).getPath();
                    Log.e(TAG, "physicalVol : " + storageVolume.toString());
                    mountService.unmountVolume(path, true, this.mFactoryReset);
                }
            } catch (RemoteException e2) {
                Log.w(TAG, "Failed talking with mount service", e2);
            }
        } else if (Environment.MEDIA_NOFS.equals(str) || Environment.MEDIA_UNMOUNTED.equals(str) || Environment.MEDIA_UNMOUNTABLE.equals(str)) {
            updateProgressDialog(z ? 17039522 : 17039515);
            int i = z ? 17039523 : 17039516;
            final IMountService mountService2 = getMountService();
            if (mountService2 == null) {
                Log.w(TAG, "Unable to locate IMountService");
                return;
            }
            final int i2 = i;
            new Thread() { // from class: com.android.internal.os.storage.ExternalStorageFormatter.2
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    String path2;
                    boolean z2 = false;
                    ArrayList<StorageVolume> arrayList = null;
                    try {
                        ArrayList<StorageVolume> physicalExternalVolume3 = StorageManager.getPhysicalExternalVolume(mountService2.getVolumeList());
                        if (ExternalStorageFormatter.this.mStorageVolume != null) {
                            path2 = ExternalStorageFormatter.this.mStorageVolume.getPath();
                        } else if (physicalExternalVolume3.size() == 0) {
                            ExternalStorageFormatter.this.updateProgressDialog(R.string.progress_nomediapresent);
                            return;
                        } else {
                            path2 = physicalExternalVolume3.get(0).getPath();
                        }
                        mountService2.formatVolume(path2);
                        ExternalStorageFormatter.this.mIsFormatSuccess = true;
                        z2 = true;
                        arrayList = physicalExternalVolume3;
                    } catch (Exception e3) {
                        Looper.prepare();
                        Toast.makeText(ExternalStorageFormatter.this, i2, 1).show();
                    }
                    if (z2 && ExternalStorageFormatter.this.mFactoryReset) {
                        Intent intent = new Intent(Intent.ACTION_MASTER_CLEAR);
                        intent.addFlags(268435456);
                        intent.putExtra(Intent.EXTRA_REASON, ExternalStorageFormatter.this.mReason);
                        intent.putExtra(ExternalStorageFormatter.EXTRA_WIPE_MEDIA, ExternalStorageFormatter.this.mWipeInternalStorage);
                        ExternalStorageFormatter.this.sendBroadcast(intent);
                        ExternalStorageFormatter.this.stopSelf();
                        return;
                    }
                    if (z2 || !ExternalStorageFormatter.this.mAlwaysReset) {
                        try {
                            if (arrayList.size() == 0) {
                                ExternalStorageFormatter.this.updateProgressDialog(R.string.progress_nomediapresent);
                                return;
                            }
                            mountService2.mountVolume(ExternalStorageFormatter.this.mStorageVolume == null ? arrayList.get(0).getPath() : ExternalStorageFormatter.this.mStorageVolume.getPath());
                        } catch (RemoteException e4) {
                            Log.w(ExternalStorageFormatter.TAG, "Failed talking with mount service", e4);
                        }
                    } else {
                        Intent intent2 = new Intent(Intent.ACTION_MASTER_CLEAR);
                        intent2.addFlags(268435456);
                        intent2.putExtra(Intent.EXTRA_REASON, ExternalStorageFormatter.this.mReason);
                        intent2.putExtra(ExternalStorageFormatter.EXTRA_WIPE_MEDIA, ExternalStorageFormatter.this.mWipeInternalStorage);
                        ExternalStorageFormatter.this.sendBroadcast(intent2);
                    }
                    ExternalStorageFormatter.this.stopSelf();
                }
            }.start();
        } else if (Environment.MEDIA_BAD_REMOVAL.equals(str)) {
            fail(z ? 17039524 : 17039517);
        } else if (Environment.MEDIA_CHECKING.equals(str)) {
            fail(z ? 17039525 : 17039518);
        } else if (Environment.MEDIA_REMOVED.equals(str)) {
            fail(z ? 17039526 : 17039519);
        } else if ("shared".equals(str)) {
            fail(z ? 17039527 : 17039520);
        } else {
            fail(R.string.media_unknown_state);
            Log.w(TAG, "Unknown storage state: " + str);
            stopSelf();
        }
    }
}
