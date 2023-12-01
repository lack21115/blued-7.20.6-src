package android.telecom;

import android.content.ComponentName;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.text.TextUtils;
import com.android.internal.telecom.ITelecomService;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: source-9557208-dex2jar.jar:android/telecom/TelecomManager.class */
public class TelecomManager {
    public static final String ACTION_CHANGE_PHONE_ACCOUNTS = "android.telecom.action.CHANGE_PHONE_ACCOUNTS";
    public static final String ACTION_CONNECTION_SERVICE_CONFIGURE = "android.telecom.action.CONNECTION_SERVICE_CONFIGURE";
    public static final String ACTION_CURRENT_TTY_MODE_CHANGED = "android.telecom.action.CURRENT_TTY_MODE_CHANGED";
    public static final String ACTION_INCOMING_CALL = "android.telecom.action.INCOMING_CALL";
    public static final String ACTION_NEW_UNKNOWN_CALL = "android.telecom.action.NEW_UNKNOWN_CALL";
    public static final String ACTION_SHOW_CALL_SETTINGS = "android.telecom.action.SHOW_CALL_SETTINGS";
    public static final String ACTION_TTY_PREFERRED_MODE_CHANGED = "android.telecom.action.TTY_PREFERRED_MODE_CHANGED";
    public static final char DTMF_CHARACTER_PAUSE = ',';
    public static final char DTMF_CHARACTER_WAIT = ';';
    public static final String EXTRA_CALL_BACK_NUMBER = "android.telecom.extra.CALL_BACK_NUMBER";
    public static final String EXTRA_CALL_DISCONNECT_CAUSE = "android.telecom.extra.CALL_DISCONNECT_CAUSE";
    public static final String EXTRA_CALL_DISCONNECT_MESSAGE = "android.telecom.extra.CALL_DISCONNECT_MESSAGE";
    public static final String EXTRA_CONNECTION_SERVICE = "android.telecom.extra.CONNECTION_SERVICE";
    public static final String EXTRA_CURRENT_TTY_MODE = "android.telecom.intent.extra.CURRENT_TTY_MODE";
    public static final String EXTRA_INCOMING_CALL_EXTRAS = "android.telecom.extra.INCOMING_CALL_EXTRAS";
    public static final String EXTRA_OUTGOING_CALL_EXTRAS = "android.telecom.extra.OUTGOING_CALL_EXTRAS";
    public static final String EXTRA_PHONE_ACCOUNT_HANDLE = "android.telecom.extra.PHONE_ACCOUNT_HANDLE";
    public static final String EXTRA_START_CALL_WITH_SPEAKERPHONE = "android.telecom.extra.START_CALL_WITH_SPEAKERPHONE";
    public static final String EXTRA_START_CALL_WITH_VIDEO_STATE = "android.telecom.extra.START_CALL_WITH_VIDEO_STATE";
    public static final String EXTRA_TTY_PREFERRED_MODE = "android.telecom.intent.extra.TTY_PREFERRED";
    public static final String EXTRA_UNKNOWN_CALL_HANDLE = "android.telecom.extra.UNKNOWN_CALL_HANDLE";
    public static final String EXTRA_UNKNOWN_CALL_STATE = "codeaurora.telecom.extra.UNKNOWN_CALL_STATE";
    public static final String GATEWAY_ORIGINAL_ADDRESS = "android.telecom.extra.GATEWAY_ORIGINAL_ADDRESS";
    public static final String GATEWAY_PROVIDER_PACKAGE = "android.telecom.extra.GATEWAY_PROVIDER_PACKAGE";
    public static final int PRESENTATION_ALLOWED = 1;
    public static final int PRESENTATION_PAYPHONE = 4;
    public static final int PRESENTATION_RESTRICTED = 2;
    public static final int PRESENTATION_UNKNOWN = 3;
    private static final String TAG = "TelecomManager";
    public static final int TTY_MODE_FULL = 1;
    public static final int TTY_MODE_HCO = 2;
    public static final int TTY_MODE_OFF = 0;
    public static final int TTY_MODE_VCO = 3;
    private final Context mContext;

    public TelecomManager(Context context) {
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            this.mContext = applicationContext;
        } else {
            this.mContext = context;
        }
    }

    public static TelecomManager from(Context context) {
        return (TelecomManager) context.getSystemService("telecom");
    }

    private ITelecomService getTelecomService() {
        return ITelecomService.Stub.asInterface(ServiceManager.getService("telecom"));
    }

    private boolean isServiceConnected() {
        boolean z = getTelecomService() != null;
        if (!z) {
            android.util.Log.w(TAG, "Telecom Service not found.");
        }
        return z;
    }

    public void acceptRingingCall() {
        try {
            if (isServiceConnected()) {
                getTelecomService().acceptRingingCall();
            }
        } catch (RemoteException e) {
            android.util.Log.e(TAG, "Error calling ITelecomService#acceptRingingCall", e);
        }
    }

    public void addNewIncomingCall(PhoneAccountHandle phoneAccountHandle, Bundle bundle) {
        try {
            if (isServiceConnected()) {
                ITelecomService telecomService = getTelecomService();
                Bundle bundle2 = bundle;
                if (bundle == null) {
                    bundle2 = new Bundle();
                }
                telecomService.addNewIncomingCall(phoneAccountHandle, bundle2);
            }
        } catch (RemoteException e) {
            android.util.Log.e(TAG, "RemoteException adding a new incoming call: " + phoneAccountHandle, e);
        }
    }

    public void addNewUnknownCall(PhoneAccountHandle phoneAccountHandle, Bundle bundle) {
        try {
            if (isServiceConnected()) {
                ITelecomService telecomService = getTelecomService();
                Bundle bundle2 = bundle;
                if (bundle == null) {
                    bundle2 = new Bundle();
                }
                telecomService.addNewUnknownCall(phoneAccountHandle, bundle2);
            }
        } catch (RemoteException e) {
            android.util.Log.e(TAG, "RemoteException adding a new unknown call: " + phoneAccountHandle, e);
        }
    }

    public void cancelMissedCallsNotification() {
        ITelecomService telecomService = getTelecomService();
        if (telecomService != null) {
            try {
                telecomService.cancelMissedCallsNotification();
            } catch (RemoteException e) {
                android.util.Log.e(TAG, "Error calling ITelecomService#cancelMissedCallsNotification", e);
            }
        }
    }

    public void clearAccounts() {
        try {
            if (isServiceConnected()) {
                getTelecomService().clearAccounts(this.mContext.getPackageName());
            }
        } catch (RemoteException e) {
            android.util.Log.e(TAG, "Error calling ITelecomService#clearAccounts", e);
        }
    }

    public void clearAccountsForPackage(String str) {
        try {
            if (!isServiceConnected() || TextUtils.isEmpty(str)) {
                return;
            }
            getTelecomService().clearAccounts(str);
        } catch (RemoteException e) {
            android.util.Log.e(TAG, "Error calling ITelecomService#clearAccountsForPackage", e);
        }
    }

    public boolean endCall() {
        try {
            if (isServiceConnected()) {
                return getTelecomService().endCall();
            }
            return false;
        } catch (RemoteException e) {
            android.util.Log.e(TAG, "Error calling ITelecomService#endCall", e);
            return false;
        }
    }

    public int getActiveSubscription() {
        try {
            if (isServiceConnected()) {
                return getTelecomService().getActiveSubscription();
            }
            return -1;
        } catch (RemoteException e) {
            android.util.Log.e(TAG, "RemoteException attempting to get the active subsription.", e);
            return -1;
        }
    }

    public Uri getAdnUriForPhoneAccount(PhoneAccountHandle phoneAccountHandle) {
        ITelecomService telecomService = getTelecomService();
        if (telecomService != null && phoneAccountHandle != null) {
            try {
                return telecomService.getAdnUriForPhoneAccount(phoneAccountHandle);
            } catch (RemoteException e) {
                android.util.Log.e(TAG, "Error calling ITelecomService#getAdnUriForPhoneAccount", e);
            }
        }
        return Uri.parse("content://icc/adn");
    }

    public List<PhoneAccountHandle> getAllPhoneAccountHandles() {
        try {
            if (isServiceConnected()) {
                return getTelecomService().getAllPhoneAccountHandles();
            }
        } catch (RemoteException e) {
            android.util.Log.e(TAG, "Error calling ITelecomService#getAllPhoneAccountHandles", e);
        }
        return Collections.EMPTY_LIST;
    }

    public List<PhoneAccount> getAllPhoneAccounts() {
        try {
            if (isServiceConnected()) {
                return getTelecomService().getAllPhoneAccounts();
            }
        } catch (RemoteException e) {
            android.util.Log.e(TAG, "Error calling ITelecomService#getAllPhoneAccounts", e);
        }
        return Collections.EMPTY_LIST;
    }

    public int getAllPhoneAccountsCount() {
        try {
            if (isServiceConnected()) {
                return getTelecomService().getAllPhoneAccountsCount();
            }
            return 0;
        } catch (RemoteException e) {
            android.util.Log.e(TAG, "Error calling ITelecomService#getAllPhoneAccountsCount", e);
            return 0;
        }
    }

    public List<PhoneAccountHandle> getCallCapablePhoneAccounts() {
        try {
            if (isServiceConnected()) {
                return getTelecomService().getCallCapablePhoneAccounts();
            }
        } catch (RemoteException e) {
            android.util.Log.e(TAG, "Error calling ITelecomService#getCallCapablePhoneAccounts", e);
        }
        return new ArrayList();
    }

    public int getCallState() {
        try {
            if (isServiceConnected()) {
                return getTelecomService().getCallState();
            }
            return 0;
        } catch (RemoteException e) {
            android.util.Log.d(TAG, "RemoteException calling getCallState().", e);
            return 0;
        }
    }

    public PhoneAccountHandle getConnectionManager() {
        return getSimCallManager();
    }

    public int getCurrentTtyMode() {
        try {
            if (isServiceConnected()) {
                return getTelecomService().getCurrentTtyMode();
            }
            return 0;
        } catch (RemoteException e) {
            android.util.Log.e(TAG, "RemoteException attempting to get the current TTY mode.", e);
            return 0;
        }
    }

    public PhoneAccountHandle getDefaultOutgoingPhoneAccount(String str) {
        try {
            if (isServiceConnected()) {
                return getTelecomService().getDefaultOutgoingPhoneAccount(str);
            }
            return null;
        } catch (RemoteException e) {
            android.util.Log.e(TAG, "Error calling ITelecomService#getDefaultOutgoingPhoneAccount", e);
            return null;
        }
    }

    public ComponentName getDefaultPhoneApp() {
        try {
            if (isServiceConnected()) {
                return getTelecomService().getDefaultPhoneApp();
            }
            return null;
        } catch (RemoteException e) {
            android.util.Log.e(TAG, "RemoteException attempting to get the default phone app.", e);
            return null;
        }
    }

    public String getLine1Number(PhoneAccountHandle phoneAccountHandle) {
        try {
            if (isServiceConnected()) {
                return getTelecomService().getLine1Number(phoneAccountHandle);
            }
            return null;
        } catch (RemoteException e) {
            android.util.Log.e(TAG, "RemoteException calling ITelecomService#getLine1Number.", e);
            return null;
        }
    }

    public PhoneAccount getPhoneAccount(PhoneAccountHandle phoneAccountHandle) {
        try {
            if (isServiceConnected()) {
                return getTelecomService().getPhoneAccount(phoneAccountHandle);
            }
            return null;
        } catch (RemoteException e) {
            android.util.Log.e(TAG, "Error calling ITelecomService#getPhoneAccount", e);
            return null;
        }
    }

    public List<PhoneAccountHandle> getPhoneAccountsForPackage() {
        try {
            if (isServiceConnected()) {
                return getTelecomService().getPhoneAccountsForPackage(this.mContext.getPackageName());
            }
            return null;
        } catch (RemoteException e) {
            android.util.Log.e(TAG, "Error calling ITelecomService#getPhoneAccountsForPackage", e);
            return null;
        }
    }

    public List<PhoneAccountHandle> getPhoneAccountsSupportingScheme(String str) {
        try {
            if (isServiceConnected()) {
                return getTelecomService().getPhoneAccountsSupportingScheme(str);
            }
        } catch (RemoteException e) {
            android.util.Log.e(TAG, "Error calling ITelecomService#getPhoneAccountsSupportingScheme", e);
        }
        return new ArrayList();
    }

    public List<PhoneAccountHandle> getRegisteredConnectionManagers() {
        return getSimCallManagers();
    }

    public PhoneAccountHandle getSimCallManager() {
        try {
            if (isServiceConnected()) {
                return getTelecomService().getSimCallManager();
            }
            return null;
        } catch (RemoteException e) {
            android.util.Log.e(TAG, "Error calling ITelecomService#getSimCallManager");
            return null;
        }
    }

    public List<PhoneAccountHandle> getSimCallManagers() {
        try {
            if (isServiceConnected()) {
                return getTelecomService().getSimCallManagers();
            }
        } catch (RemoteException e) {
            android.util.Log.e(TAG, "Error calling ITelecomService#getSimCallManagers");
        }
        return new ArrayList();
    }

    public PhoneAccountHandle getUserSelectedOutgoingPhoneAccount() {
        try {
            if (isServiceConnected()) {
                return getTelecomService().getUserSelectedOutgoingPhoneAccount();
            }
            return null;
        } catch (RemoteException e) {
            android.util.Log.e(TAG, "Error calling ITelecomService#getUserSelectedOutgoingPhoneAccount", e);
            return null;
        }
    }

    public String getVoiceMailNumber(PhoneAccountHandle phoneAccountHandle) {
        try {
            if (isServiceConnected()) {
                return getTelecomService().getVoiceMailNumber(phoneAccountHandle);
            }
            return null;
        } catch (RemoteException e) {
            android.util.Log.e(TAG, "RemoteException calling ITelecomService#getVoiceMailNumber.", e);
            return null;
        }
    }

    public boolean handleMmi(PhoneAccountHandle phoneAccountHandle, String str) {
        ITelecomService telecomService = getTelecomService();
        if (telecomService != null) {
            try {
                return telecomService.handlePinMmiForPhoneAccount(phoneAccountHandle, str);
            } catch (RemoteException e) {
                android.util.Log.e(TAG, "Error calling ITelecomService#handlePinMmi", e);
                return false;
            }
        }
        return false;
    }

    public boolean handleMmi(String str) {
        ITelecomService telecomService = getTelecomService();
        if (telecomService != null) {
            try {
                return telecomService.handlePinMmi(str);
            } catch (RemoteException e) {
                android.util.Log.e(TAG, "Error calling ITelecomService#handlePinMmi", e);
                return false;
            }
        }
        return false;
    }

    public boolean hasMultipleCallCapableAccounts() {
        return getCallCapablePhoneAccounts().size() > 1;
    }

    public boolean hasVoiceMailNumber(PhoneAccountHandle phoneAccountHandle) {
        try {
            if (isServiceConnected()) {
                return getTelecomService().hasVoiceMailNumber(phoneAccountHandle);
            }
            return false;
        } catch (RemoteException e) {
            android.util.Log.e(TAG, "RemoteException calling ITelecomService#hasVoiceMailNumber.", e);
            return false;
        }
    }

    public boolean isInCall() {
        try {
            if (isServiceConnected()) {
                return getTelecomService().isInCall();
            }
            return false;
        } catch (RemoteException e) {
            android.util.Log.e(TAG, "RemoteException calling isInCall().", e);
            return false;
        }
    }

    public boolean isRinging() {
        try {
            if (isServiceConnected()) {
                return getTelecomService().isRinging();
            }
            return false;
        } catch (RemoteException e) {
            android.util.Log.e(TAG, "RemoteException attempting to get ringing state of phone app.", e);
            return false;
        }
    }

    public boolean isTtySupported() {
        try {
            if (isServiceConnected()) {
                return getTelecomService().isTtySupported();
            }
            return false;
        } catch (RemoteException e) {
            android.util.Log.e(TAG, "RemoteException attempting to get TTY supported state.", e);
            return false;
        }
    }

    public boolean isVoiceMailNumber(PhoneAccountHandle phoneAccountHandle, String str) {
        try {
            if (isServiceConnected()) {
                return getTelecomService().isVoiceMailNumber(phoneAccountHandle, str);
            }
            return false;
        } catch (RemoteException e) {
            android.util.Log.e(TAG, "RemoteException calling ITelecomService#isVoiceMailNumber.", e);
            return false;
        }
    }

    public void registerPhoneAccount(PhoneAccount phoneAccount) {
        try {
            if (isServiceConnected()) {
                getTelecomService().registerPhoneAccount(phoneAccount);
            }
        } catch (RemoteException e) {
            android.util.Log.e(TAG, "Error calling ITelecomService#registerPhoneAccount", e);
        }
    }

    public void setSimCallManager(PhoneAccountHandle phoneAccountHandle) {
        try {
            if (isServiceConnected()) {
                getTelecomService().setSimCallManager(phoneAccountHandle);
            }
        } catch (RemoteException e) {
            android.util.Log.e(TAG, "Error calling ITelecomService#setSimCallManager");
        }
    }

    public void setUserSelectedOutgoingPhoneAccount(PhoneAccountHandle phoneAccountHandle) {
        try {
            if (isServiceConnected()) {
                getTelecomService().setUserSelectedOutgoingPhoneAccount(phoneAccountHandle);
            }
        } catch (RemoteException e) {
            android.util.Log.e(TAG, "Error calling ITelecomService#setUserSelectedOutgoingPhoneAccount");
        }
    }

    public void showInCallScreen(boolean z) {
        ITelecomService telecomService = getTelecomService();
        if (telecomService != null) {
            try {
                telecomService.showInCallScreen(z);
            } catch (RemoteException e) {
                android.util.Log.e(TAG, "Error calling ITelecomService#showCallScreen", e);
            }
        }
    }

    public void silenceRinger() {
        try {
            if (isServiceConnected()) {
                getTelecomService().silenceRinger();
            }
        } catch (RemoteException e) {
            android.util.Log.e(TAG, "Error calling ITelecomService#silenceRinger", e);
        }
    }

    public void switchToOtherActiveSub(int i) {
        try {
            if (isServiceConnected()) {
                getTelecomService().switchToOtherActiveSub(i);
            }
        } catch (RemoteException e) {
            android.util.Log.e(TAG, "RemoteException attempting to switchToOtherActiveSub.", e);
        }
    }

    public void unregisterPhoneAccount(PhoneAccountHandle phoneAccountHandle) {
        try {
            if (isServiceConnected()) {
                getTelecomService().unregisterPhoneAccount(phoneAccountHandle);
            }
        } catch (RemoteException e) {
            android.util.Log.e(TAG, "Error calling ITelecomService#unregisterPhoneAccount", e);
        }
    }
}
