package com.android.internal.app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.storage.StorageManager;
import android.os.storage.StorageVolume;
import android.util.Log;
import com.android.internal.R;
import com.android.internal.app.AlertController;
import com.android.internal.os.storage.ExternalStorageFormatter;

/* loaded from: source-4181928-dex2jar.jar:com/android/internal/app/ExternalMediaFormatActivity.class */
public class ExternalMediaFormatActivity extends AlertActivity implements DialogInterface.OnClickListener {
    public static final String FORMAT_PATH = "format_path";
    private static final int POSITIVE_BUTTON = -1;
    private StorageManager mStorageManager;
    private StorageVolume mStorageVolume = null;
    private BroadcastReceiver mStorageReceiver = new BroadcastReceiver() { // from class: com.android.internal.app.ExternalMediaFormatActivity.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            Log.d("ExternalMediaFormatActivity", "got action " + action);
            if (action == Intent.ACTION_MEDIA_REMOVED || action == Intent.ACTION_MEDIA_CHECKING || action == Intent.ACTION_MEDIA_MOUNTED || action == Intent.ACTION_MEDIA_SHARED) {
                ExternalMediaFormatActivity.this.finish();
            }
        }
    };

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (i == -1) {
            Intent intent = new Intent(ExternalStorageFormatter.FORMAT_ONLY);
            intent.setComponent(ExternalStorageFormatter.COMPONENT_NAME);
            intent.putExtra(StorageVolume.EXTRA_STORAGE_VOLUME, this.mStorageVolume);
            startService(intent);
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.android.internal.app.AlertActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mStorageManager = (StorageManager) getSystemService(Context.STORAGE_SERVICE);
        String stringExtra = getIntent().getStringExtra(FORMAT_PATH);
        StorageVolume[] volumeList = this.mStorageManager.getVolumeList();
        int length = volumeList.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                break;
            }
            StorageVolume storageVolume = volumeList[i2];
            if (stringExtra.equals(storageVolume.getPath())) {
                this.mStorageVolume = storageVolume;
                break;
            }
            i = i2 + 1;
        }
        Log.d("ExternalMediaFormatActivity", "onCreate!");
        Log.d("ExternalMediaFormatActivity", "The storage volume to be formatted is : " + this.mStorageVolume.getPath());
        boolean z = this.mStorageVolume.getDescriptionId() == 17041020;
        AlertController.AlertParams alertParams = this.mAlertParams;
        alertParams.mTitle = getString(R.string.extmedia_format_title);
        alertParams.mMessage = String.format(getString(z ? 17039512 : 17039513), this.mStorageVolume.getPath());
        alertParams.mPositiveButtonText = getString(R.string.extmedia_format_button_format);
        alertParams.mPositiveButtonListener = this;
        alertParams.mNegativeButtonText = getString(17039360);
        alertParams.mNegativeButtonListener = this;
        setupAlert();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        unregisterReceiver(this.mStorageReceiver);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Intent.ACTION_MEDIA_REMOVED);
        intentFilter.addAction(Intent.ACTION_MEDIA_CHECKING);
        intentFilter.addAction(Intent.ACTION_MEDIA_MOUNTED);
        intentFilter.addAction(Intent.ACTION_MEDIA_SHARED);
        registerReceiver(this.mStorageReceiver, intentFilter);
    }
}
