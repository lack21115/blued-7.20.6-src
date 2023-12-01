package com.android.internal.app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.Toast;
import com.android.internal.R;
import com.android.internal.app.AlertController;
import com.android.internal.location.GpsNetInitiatedHandler;
import com.android.internal.util.cm.QSConstants;

/* loaded from: source-4181928-dex2jar.jar:com/android/internal/app/NetInitiatedActivity.class */
public class NetInitiatedActivity extends AlertActivity implements DialogInterface.OnClickListener {
    private static final boolean DEBUG = true;
    private static final int GPS_NO_RESPONSE_TIME_OUT = 1;
    private static final int NEGATIVE_BUTTON = -2;
    private static final int POSITIVE_BUTTON = -1;
    private static final String TAG = "NetInitiatedActivity";
    private static final boolean VERBOSE = false;
    private int notificationId = -1;
    private int timeout = -1;
    private int default_response = -1;
    private int default_response_timeout = 6;
    private BroadcastReceiver mNetInitiatedReceiver = new BroadcastReceiver() { // from class: com.android.internal.app.NetInitiatedActivity.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Log.d(NetInitiatedActivity.TAG, "NetInitiatedReceiver onReceive: " + intent.getAction());
            if (intent.getAction() == GpsNetInitiatedHandler.ACTION_NI_VERIFY) {
                NetInitiatedActivity.this.handleNIVerify(intent);
            }
        }
    };
    private final Handler mHandler = new Handler() { // from class: com.android.internal.app.NetInitiatedActivity.2
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    if (NetInitiatedActivity.this.notificationId != -1) {
                        NetInitiatedActivity.this.sendUserResponse(NetInitiatedActivity.this.default_response);
                    }
                    NetInitiatedActivity.this.finish();
                    return;
                default:
                    return;
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void handleNIVerify(Intent intent) {
        this.notificationId = intent.getIntExtra("notif_id", -1);
        Log.d(TAG, "handleNIVerify action: " + intent.getAction());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendUserResponse(int i) {
        Log.d(TAG, "sendUserResponse, response: " + i);
        ((LocationManager) getSystemService(QSConstants.TILE_LOCATION)).sendNiResponse(this.notificationId, i);
    }

    private void showNIError() {
        Toast.makeText(this, "NI error", 1).show();
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (i == -1) {
            sendUserResponse(1);
        }
        if (i == -2) {
            sendUserResponse(2);
        }
        finish();
        this.notificationId = -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.android.internal.app.AlertActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        AlertController.AlertParams alertParams = this.mAlertParams;
        Context applicationContext = getApplicationContext();
        alertParams.mTitle = intent.getStringExtra("title");
        alertParams.mMessage = intent.getStringExtra("message");
        alertParams.mPositiveButtonText = String.format(applicationContext.getString(R.string.gpsVerifYes), new Object[0]);
        alertParams.mPositiveButtonListener = this;
        alertParams.mNegativeButtonText = String.format(applicationContext.getString(R.string.gpsVerifNo), new Object[0]);
        alertParams.mNegativeButtonListener = this;
        this.notificationId = intent.getIntExtra("notif_id", -1);
        this.timeout = intent.getIntExtra(GpsNetInitiatedHandler.NI_INTENT_KEY_TIMEOUT, this.default_response_timeout);
        this.default_response = intent.getIntExtra(GpsNetInitiatedHandler.NI_INTENT_KEY_DEFAULT_RESPONSE, 1);
        Log.d(TAG, "onCreate() : notificationId: " + this.notificationId + " timeout: " + this.timeout + " default_response:" + this.default_response);
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.timeout * 1000);
        setupAlert();
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
        unregisterReceiver(this.mNetInitiatedReceiver);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
        registerReceiver(this.mNetInitiatedReceiver, new IntentFilter(GpsNetInitiatedHandler.ACTION_NI_VERIFY));
    }
}
