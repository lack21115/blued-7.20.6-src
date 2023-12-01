package com.android.internal.location;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.INetInitiatedListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.RemoteException;
import android.os.SystemProperties;
import android.os.UserHandle;
import android.telephony.PhoneNumberUtils;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;
import com.android.internal.R;
import com.android.internal.app.NetInitiatedActivity;
import com.android.internal.telephony.GsmAlphabet;
import com.android.internal.telephony.TelephonyProperties;
import java.io.UnsupportedEncodingException;

/* loaded from: source-4181928-dex2jar.jar:com/android/internal/location/GpsNetInitiatedHandler.class */
public class GpsNetInitiatedHandler {
    public static final String ACTION_NI_VERIFY = "android.intent.action.NETWORK_INITIATED_VERIFY";
    private static final boolean DEBUG = true;
    public static final int GPS_ENC_NONE = 0;
    public static final int GPS_ENC_SUPL_GSM_DEFAULT = 1;
    public static final int GPS_ENC_SUPL_UCS2 = 3;
    public static final int GPS_ENC_SUPL_UTF8 = 2;
    public static final int GPS_ENC_UNKNOWN = -1;
    public static final int GPS_NI_NEED_NOTIFY = 1;
    public static final int GPS_NI_NEED_VERIFY = 2;
    public static final int GPS_NI_PRIVACY_OVERRIDE = 4;
    public static final int GPS_NI_RESPONSE_ACCEPT = 1;
    public static final int GPS_NI_RESPONSE_DENY = 2;
    public static final int GPS_NI_RESPONSE_IGNORE = 4;
    public static final int GPS_NI_RESPONSE_NORESP = 3;
    public static final int GPS_NI_TYPE_EMERGENCY_SUPL = 4;
    public static final int GPS_NI_TYPE_UMTS_CTRL_PLANE = 3;
    public static final int GPS_NI_TYPE_UMTS_SUPL = 2;
    public static final int GPS_NI_TYPE_VOICE = 1;
    public static final String NI_EXTRA_CMD_NOTIF_ID = "notif_id";
    public static final String NI_EXTRA_CMD_RESPONSE = "response";
    public static final String NI_INTENT_KEY_DEFAULT_RESPONSE = "default_resp";
    public static final String NI_INTENT_KEY_MESSAGE = "message";
    public static final String NI_INTENT_KEY_NOTIF_ID = "notif_id";
    public static final String NI_INTENT_KEY_TIMEOUT = "timeout";
    public static final String NI_INTENT_KEY_TITLE = "title";
    public static final String NI_RESPONSE_EXTRA_CMD = "send_ni_response";
    private static final String TAG = "GpsNetInitiatedHandler";
    private static final boolean VERBOSE = false;
    private static boolean mIsHexInput = true;
    private final Context mContext;
    private volatile boolean mIsInEmergency;
    private volatile boolean mIsSuplEsEnabled;
    private final LocationManager mLocationManager;
    private final INetInitiatedListener mNetInitiatedListener;
    private Notification mNiNotification;
    private final PhoneStateListener mPhoneStateListener;
    private final TelephonyManager mTelephonyManager;
    private boolean mPlaySounds = false;
    private boolean mPopupImmediately = true;
    private volatile boolean mIsLocationEnabled = false;
    private final BroadcastReceiver mBroadcastReciever = new BroadcastReceiver() { // from class: com.android.internal.location.GpsNetInitiatedHandler.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (action.equals(Intent.ACTION_NEW_OUTGOING_CALL)) {
                GpsNetInitiatedHandler.this.setInEmergency(PhoneNumberUtils.isEmergencyNumber(intent.getStringExtra(Intent.EXTRA_PHONE_NUMBER)));
                Log.v(GpsNetInitiatedHandler.TAG, "ACTION_NEW_OUTGOING_CALL - " + GpsNetInitiatedHandler.this.getInEmergency());
            } else if (action.equals(LocationManager.MODE_CHANGED_ACTION)) {
                GpsNetInitiatedHandler.this.updateLocationMode();
                Log.d(GpsNetInitiatedHandler.TAG, "location enabled :" + GpsNetInitiatedHandler.this.getLocationEnabled());
            }
        }
    };

    /* loaded from: source-4181928-dex2jar.jar:com/android/internal/location/GpsNetInitiatedHandler$GpsNiNotification.class */
    public static class GpsNiNotification {
        public int defaultResponse;
        public Bundle extras;
        public boolean needNotify;
        public boolean needVerify;
        public int niType;
        public int notificationId;
        public boolean privacyOverride;
        public String requestorId;
        public int requestorIdEncoding;
        public String text;
        public int textEncoding;
        public int timeout;
    }

    /* loaded from: source-4181928-dex2jar.jar:com/android/internal/location/GpsNetInitiatedHandler$GpsNiResponse.class */
    public static class GpsNiResponse {
        Bundle extras;
        int userResponse;
    }

    public GpsNetInitiatedHandler(Context context, INetInitiatedListener iNetInitiatedListener, boolean z) {
        this.mContext = context;
        if (iNetInitiatedListener == null) {
            throw new IllegalArgumentException("netInitiatedListener is null");
        }
        this.mNetInitiatedListener = iNetInitiatedListener;
        setSuplEsEnabled(z);
        this.mLocationManager = (LocationManager) context.getSystemService("location");
        updateLocationMode();
        this.mTelephonyManager = (TelephonyManager) context.getSystemService("phone");
        this.mPhoneStateListener = new PhoneStateListener() { // from class: com.android.internal.location.GpsNetInitiatedHandler.2
            @Override // android.telephony.PhoneStateListener
            public void onCallStateChanged(int i, String str) {
                Log.d(GpsNetInitiatedHandler.TAG, "onCallStateChanged(): state is " + i);
                if (i == 0) {
                    GpsNetInitiatedHandler.this.setInEmergency(false);
                }
            }
        };
        this.mTelephonyManager.listen(this.mPhoneStateListener, 32);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Intent.ACTION_NEW_OUTGOING_CALL);
        intentFilter.addAction(LocationManager.MODE_CHANGED_ACTION);
        this.mContext.registerReceiver(this.mBroadcastReciever, intentFilter);
    }

    static String decodeGSMPackedString(byte[] bArr) {
        int length = bArr.length;
        int i = (length * 8) / 7;
        int i2 = i;
        if (length % 7 == 0) {
            i2 = i;
            if (length > 0) {
                i2 = i;
                if ((bArr[length - 1] >> 1) == 0) {
                    i2 = i - 1;
                }
            }
        }
        String gsm7BitPackedToString = GsmAlphabet.gsm7BitPackedToString(bArr, 0, i2);
        String str = gsm7BitPackedToString;
        if (gsm7BitPackedToString == null) {
            Log.e(TAG, "Decoding of GSM packed string failed");
            str = "";
        }
        return str;
    }

    private static String decodeString(String str, boolean z, int i) {
        byte[] stringToByteArray = stringToByteArray(str, z);
        switch (i) {
            case -1:
                return str;
            case 0:
                return str;
            case 1:
                return decodeGSMPackedString(stringToByteArray);
            case 2:
                return decodeUTF8String(stringToByteArray);
            case 3:
                return decodeUCS2String(stringToByteArray);
            default:
                Log.e(TAG, "Unknown encoding " + i + " for NI text " + str);
                return str;
        }
    }

    static String decodeUCS2String(byte[] bArr) {
        try {
            return new String(bArr, "UTF-16");
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError();
        }
    }

    static String decodeUTF8String(byte[] bArr) {
        try {
            return new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError();
        }
    }

    private static String getDialogMessage(GpsNiNotification gpsNiNotification, Context context) {
        return getNotifMessage(gpsNiNotification, context);
    }

    public static String getDialogTitle(GpsNiNotification gpsNiNotification, Context context) {
        return getNotifTitle(gpsNiNotification, context);
    }

    private Intent getDlgIntent(GpsNiNotification gpsNiNotification) {
        Intent intent = new Intent();
        String dialogTitle = getDialogTitle(gpsNiNotification, this.mContext);
        String dialogMessage = getDialogMessage(gpsNiNotification, this.mContext);
        intent.setFlags(268468224);
        intent.setClass(this.mContext, NetInitiatedActivity.class);
        intent.putExtra("notif_id", gpsNiNotification.notificationId);
        intent.putExtra("title", dialogTitle);
        intent.putExtra("message", dialogMessage);
        intent.putExtra("timeout", gpsNiNotification.timeout);
        intent.putExtra(NI_INTENT_KEY_DEFAULT_RESPONSE, gpsNiNotification.defaultResponse);
        Log.d(TAG, "generateIntent, title: " + dialogTitle + ", message: " + dialogMessage + ", timeout: " + gpsNiNotification.timeout);
        return intent;
    }

    private static String getNotifMessage(GpsNiNotification gpsNiNotification, Context context) {
        return String.format(context.getString(R.string.gpsNotifMessage), decodeString(gpsNiNotification.requestorId, mIsHexInput, gpsNiNotification.requestorIdEncoding), decodeString(gpsNiNotification.text, mIsHexInput, gpsNiNotification.textEncoding));
    }

    private static String getNotifTicker(GpsNiNotification gpsNiNotification, Context context) {
        return String.format(context.getString(R.string.gpsNotifTicker), decodeString(gpsNiNotification.requestorId, mIsHexInput, gpsNiNotification.requestorIdEncoding), decodeString(gpsNiNotification.text, mIsHexInput, gpsNiNotification.textEncoding));
    }

    private static String getNotifTitle(GpsNiNotification gpsNiNotification, Context context) {
        return String.format(context.getString(R.string.gpsNotifTitle), new Object[0]);
    }

    private void handleNi(GpsNiNotification gpsNiNotification) {
        Log.d(TAG, "in handleNi () : needNotify: " + gpsNiNotification.needNotify + " needVerify: " + gpsNiNotification.needVerify + " privacyOverride: " + gpsNiNotification.privacyOverride + " mPopupImmediately: " + this.mPopupImmediately + " mInEmergency: " + getInEmergency());
        if (!getLocationEnabled() && !getInEmergency()) {
            try {
                this.mNetInitiatedListener.sendNiResponse(gpsNiNotification.notificationId, 4);
            } catch (RemoteException e) {
                Log.e(TAG, "RemoteException in sendNiResponse");
            }
        }
        if (gpsNiNotification.needNotify) {
            if (gpsNiNotification.needVerify && this.mPopupImmediately) {
                openNiDialog(gpsNiNotification);
            } else {
                setNiNotification(gpsNiNotification);
            }
        }
        if (!gpsNiNotification.needVerify || gpsNiNotification.privacyOverride) {
            try {
                this.mNetInitiatedListener.sendNiResponse(gpsNiNotification.notificationId, 1);
            } catch (RemoteException e2) {
                Log.e(TAG, "RemoteException in sendNiResponse");
            }
        }
    }

    private void handleNiInEs(GpsNiNotification gpsNiNotification) {
        Log.d(TAG, "in handleNiInEs () : niType: " + gpsNiNotification.niType + " notificationId: " + gpsNiNotification.notificationId);
        if ((gpsNiNotification.niType == 4) == getInEmergency()) {
            handleNi(gpsNiNotification);
            return;
        }
        try {
            this.mNetInitiatedListener.sendNiResponse(gpsNiNotification.notificationId, 4);
        } catch (RemoteException e) {
            Log.e(TAG, "RemoteException in sendNiResponse");
        }
    }

    private void openNiDialog(GpsNiNotification gpsNiNotification) {
        Intent dlgIntent = getDlgIntent(gpsNiNotification);
        Log.d(TAG, "openNiDialog, notifyId: " + gpsNiNotification.notificationId + ", requestorId: " + gpsNiNotification.requestorId + ", text: " + gpsNiNotification.text);
        this.mContext.startActivity(dlgIntent);
    }

    private void setNiNotification(GpsNiNotification gpsNiNotification) {
        synchronized (this) {
            NotificationManager notificationManager = (NotificationManager) this.mContext.getSystemService("notification");
            if (notificationManager != null) {
                String notifTitle = getNotifTitle(gpsNiNotification, this.mContext);
                String notifMessage = getNotifMessage(gpsNiNotification, this.mContext);
                Log.d(TAG, "setNiNotification, notifyId: " + gpsNiNotification.notificationId + ", title: " + notifTitle + ", message: " + notifMessage);
                if (this.mNiNotification == null) {
                    this.mNiNotification = new Notification();
                    this.mNiNotification.icon = R.drawable.stat_sys_gps_on;
                    this.mNiNotification.when = 0L;
                }
                if (this.mPlaySounds) {
                    this.mNiNotification.defaults |= 1;
                } else {
                    this.mNiNotification.defaults &= -2;
                }
                this.mNiNotification.flags = 18;
                this.mNiNotification.tickerText = getNotifTicker(gpsNiNotification, this.mContext);
                PendingIntent broadcast = PendingIntent.getBroadcast(this.mContext, 0, !this.mPopupImmediately ? getDlgIntent(gpsNiNotification) : new Intent(), 0);
                this.mNiNotification.color = this.mContext.getResources().getColor(R.color.system_notification_accent_color);
                this.mNiNotification.setLatestEventInfo(this.mContext, notifTitle, notifMessage, broadcast);
                notificationManager.notifyAsUser(null, gpsNiNotification.notificationId, this.mNiNotification, UserHandle.ALL);
            }
        }
    }

    static byte[] stringToByteArray(String str, boolean z) {
        int length = z ? str.length() / 2 : str.length();
        byte[] bArr = new byte[length];
        if (!z) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    break;
                }
                bArr[i2] = (byte) str.charAt(i2);
                i = i2 + 1;
            }
        } else {
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= length) {
                    break;
                }
                bArr[i4] = (byte) Integer.parseInt(str.substring(i4 * 2, (i4 * 2) + 2), 16);
                i3 = i4 + 1;
            }
        }
        return bArr;
    }

    public boolean getInEmergency() {
        return this.mIsInEmergency || Boolean.parseBoolean(SystemProperties.get(TelephonyProperties.PROPERTY_INECM_MODE));
    }

    public boolean getLocationEnabled() {
        return this.mIsLocationEnabled;
    }

    public boolean getSuplEsEnabled() {
        return this.mIsSuplEsEnabled;
    }

    public void handleNiNotification(GpsNiNotification gpsNiNotification) {
        Log.d(TAG, "in handleNiNotification () : notificationId: " + gpsNiNotification.notificationId + " requestorId: " + gpsNiNotification.requestorId + " text: " + gpsNiNotification.text + " mIsSuplEsEnabled" + getSuplEsEnabled() + " mIsLocationEnabled" + getLocationEnabled());
        if (getSuplEsEnabled()) {
            handleNiInEs(gpsNiNotification);
        } else {
            handleNi(gpsNiNotification);
        }
    }

    public void setInEmergency(boolean z) {
        this.mIsInEmergency = z;
    }

    public void setSuplEsEnabled(boolean z) {
        this.mIsSuplEsEnabled = z;
    }

    public void updateLocationMode() {
        this.mIsLocationEnabled = this.mLocationManager.isProviderEnabled("gps");
    }
}
