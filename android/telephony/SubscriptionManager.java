package android.telephony;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import android.os.ServiceManager;
import com.android.internal.telephony.IOnSubscriptionsChangedListener;
import com.android.internal.telephony.ISub;
import com.android.internal.telephony.ITelephonyRegistry;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-9557208-dex2jar.jar:android/telephony/SubscriptionManager.class */
public class SubscriptionManager {
    public static final int ACTIVE = 1;
    public static final String CARRIER_NAME = "carrier_name";
    public static final String COLOR = "color";
    public static final int COLOR_1 = 0;
    public static final int COLOR_2 = 1;
    public static final int COLOR_3 = 2;
    public static final int COLOR_4 = 3;
    public static final int COLOR_DEFAULT = 0;
    public static final Uri CONTENT_URI = Uri.parse("content://telephony/siminfo");
    public static final String DATA_ROAMING = "data_roaming";
    public static final int DATA_ROAMING_DEFAULT = 0;
    public static final int DATA_ROAMING_DISABLE = 0;
    public static final int DATA_ROAMING_ENABLE = 1;
    private static final boolean DBG = false;
    public static final int DEFAULT_NAME_RES = 17039374;
    public static final int DEFAULT_NW_MODE = -1;
    public static final int DEFAULT_PHONE_INDEX = Integer.MAX_VALUE;
    public static final int DEFAULT_SIM_SLOT_INDEX = Integer.MAX_VALUE;
    public static final int DEFAULT_SUBSCRIPTION_ID = Integer.MAX_VALUE;
    public static final String DISPLAY_NAME = "display_name";
    public static final int DISPLAY_NUMBER_DEFAULT = 1;
    public static final int DISPLAY_NUMBER_FIRST = 1;
    public static final String DISPLAY_NUMBER_FORMAT = "display_number_format";
    public static final int DISPLAY_NUMBER_LAST = 2;
    public static final int DISPLAY_NUMBER_NONE = 0;
    public static final int DUMMY_SUBSCRIPTION_ID_BASE = -2;
    public static final String ICC_ID = "icc_id";
    public static final int INACTIVE = 0;
    public static final int INVALID_PHONE_INDEX = -1;
    public static final int INVALID_SIM_SLOT_INDEX = -1;
    public static final int INVALID_SUBSCRIPTION_ID = -1;
    private static final String LOG_TAG = "SubscriptionManager";
    public static final int MAX_SUBSCRIPTION_ID_VALUE = 2147483646;
    public static final String MCC = "mcc";
    public static final int MIN_SUBSCRIPTION_ID_VALUE = 0;
    public static final String MNC = "mnc";
    public static final String NAME_SOURCE = "name_source";
    public static final int NAME_SOURCE_DEFAULT_SOURCE = 0;
    public static final int NAME_SOURCE_SIM_SOURCE = 1;
    public static final int NAME_SOURCE_UNDEFINDED = -1;
    public static final int NAME_SOURCE_USER_INPUT = 2;
    public static final String NETWORK_MODE = "network_mode";
    public static final String NUMBER = "number";
    public static final int SIM_NOT_INSERTED = -1;
    public static final String SIM_SLOT_INDEX = "sim_id";
    public static final int SUB_CONFIGURATION_IN_PROGRESS = 2;
    public static final String SUB_DEFAULT_CHANGED_ACTION = "android.intent.action.SUB_DEFAULT_CHANGED";
    public static final String SUB_STATE = "sub_state";
    public static final String UNIQUE_KEY_SUBSCRIPTION_ID = "_id";
    public static final String USER_NETWORK_MODE = "user_network_mode";
    private static final boolean VDBG = false;
    private final Context mContext;

    /* loaded from: source-9557208-dex2jar.jar:android/telephony/SubscriptionManager$OnSubscriptionsChangedListener.class */
    public static class OnSubscriptionsChangedListener {
        public static final String PERMISSION_ON_SUBSCRIPTIONS_CHANGED = "android.permission.READ_PHONE_STATE";
        private final Handler mHandler = new Handler() { // from class: android.telephony.SubscriptionManager.OnSubscriptionsChangedListener.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                OnSubscriptionsChangedListener.this.onSubscriptionsChanged();
            }
        };
        IOnSubscriptionsChangedListener callback = new IOnSubscriptionsChangedListener.Stub() { // from class: android.telephony.SubscriptionManager.OnSubscriptionsChangedListener.2
            public void onSubscriptionsChanged() {
                OnSubscriptionsChangedListener.this.mHandler.sendEmptyMessage(0);
            }

            public void onUnregistered() {
                OnSubscriptionsChangedListener.this.mHandler.removeMessages(0);
            }
        };

        private void log(String str) {
            Rlog.d(SubscriptionManager.LOG_TAG, str);
        }

        public void onSubscriptionsChanged() {
        }
    }

    public SubscriptionManager(Context context) {
        this.mContext = context;
    }

    public static void activateSubId(int i) {
        logd("activateSubId sub id = " + i);
        try {
            getISubInfo().activateSubId(i);
        } catch (RemoteException e) {
        }
    }

    public static void deactivateSubId(int i) {
        logd("deactivateSubId sub id = " + i);
        try {
            getISubInfo().deactivateSubId(i);
        } catch (RemoteException e) {
        }
    }

    public static SubscriptionManager from(Context context) {
        return (SubscriptionManager) context.getSystemService(Context.TELEPHONY_SUBSCRIPTION_SERVICE);
    }

    public static int getDefaultDataSubId() {
        int i = -1;
        try {
            ISub asInterface = ISub.Stub.asInterface(ServiceManager.getService("isub"));
            if (asInterface != null) {
                i = asInterface.getDefaultDataSubId();
            }
            return i;
        } catch (RemoteException e) {
            return -1;
        }
    }

    public static int getDefaultSmsSubId() {
        int i = -1;
        try {
            ISub asInterface = ISub.Stub.asInterface(ServiceManager.getService("isub"));
            if (asInterface != null) {
                i = asInterface.getDefaultSmsSubId();
            }
            return i;
        } catch (RemoteException e) {
            return -1;
        }
    }

    public static int getDefaultSubId() {
        int i = -1;
        try {
            ISub asInterface = ISub.Stub.asInterface(ServiceManager.getService("isub"));
            if (asInterface != null) {
                i = asInterface.getDefaultSubId();
            }
            return i;
        } catch (RemoteException e) {
            return -1;
        }
    }

    public static int getDefaultVoicePhoneId() {
        return getPhoneId(getDefaultVoiceSubId());
    }

    public static int getDefaultVoiceSubId() {
        int i = -1;
        try {
            ISub asInterface = ISub.Stub.asInterface(ServiceManager.getService("isub"));
            if (asInterface != null) {
                i = asInterface.getDefaultVoiceSubId();
            }
            return i;
        } catch (RemoteException e) {
            return -1;
        }
    }

    private static ISub getISubInfo() {
        return ISub.Stub.asInterface(ServiceManager.getService("isub"));
    }

    public static int getOnDemandDataSubId() {
        int i = -1;
        try {
            ISub asInterface = ISub.Stub.asInterface(ServiceManager.getService("isub"));
            if (asInterface != null) {
                i = asInterface.getOnDemandDataSubId();
            }
            return i;
        } catch (RemoteException e) {
            return -1;
        }
    }

    public static int getPhoneId(int i) {
        if (!isValidSubscriptionId(i)) {
            logd("[getPhoneId]- fail");
            return -1;
        }
        try {
            ISub asInterface = ISub.Stub.asInterface(ServiceManager.getService("isub"));
            if (asInterface != null) {
                return asInterface.getPhoneId(i);
            }
            return -1;
        } catch (RemoteException e) {
            return -1;
        }
    }

    public static int getSimStateForSubscriber(int i) {
        int i2 = 0;
        try {
            ISub asInterface = ISub.Stub.asInterface(ServiceManager.getService("isub"));
            if (asInterface != null) {
                i2 = asInterface.getSimStateForSubscriber(i);
            }
            return i2;
        } catch (RemoteException e) {
            return 0;
        }
    }

    public static int getSlotId(int i) {
        if (!isValidSubscriptionId(i)) {
            logd("[getSlotId]- fail");
        }
        int i2 = -1;
        try {
            ISub asInterface = ISub.Stub.asInterface(ServiceManager.getService("isub"));
            if (asInterface != null) {
                i2 = asInterface.getSlotId(i);
            }
            return i2;
        } catch (RemoteException e) {
            return -1;
        }
    }

    public static int[] getSubId(int i) {
        if (!isValidSlotId(i)) {
            logd("[getSubId]- fail");
            return null;
        }
        try {
            ISub asInterface = ISub.Stub.asInterface(ServiceManager.getService("isub"));
            if (asInterface != null) {
                return asInterface.getSubId(i);
            }
            return null;
        } catch (RemoteException e) {
            return null;
        }
    }

    public static int getSubState(int i) {
        logd("getSubState sub id = " + i);
        try {
            return getISubInfo().getSubState(i);
        } catch (RemoteException e) {
            return 0;
        }
    }

    public static boolean isSMSPromptEnabled() {
        try {
            ISub asInterface = ISub.Stub.asInterface(ServiceManager.getService("isub"));
            if (asInterface != null) {
                return asInterface.isSMSPromptEnabled();
            }
            return false;
        } catch (RemoteException e) {
            return false;
        }
    }

    public static boolean isUsableSubIdValue(int i) {
        return i >= 0 && i <= 2147483646;
    }

    public static boolean isValidPhoneId(int i) {
        return i >= 0 && i < TelephonyManager.getDefault().getPhoneCount();
    }

    public static boolean isValidSlotId(int i) {
        return i >= 0 && i < TelephonyManager.getDefault().getSimCount();
    }

    public static boolean isValidSubscriptionId(int i) {
        return i > -1;
    }

    public static boolean isVoicePromptEnabled() {
        try {
            ISub asInterface = ISub.Stub.asInterface(ServiceManager.getService("isub"));
            if (asInterface != null) {
                return asInterface.isVoicePromptEnabled();
            }
            return false;
        } catch (RemoteException e) {
            return false;
        }
    }

    private static void logd(String str) {
        Rlog.d(LOG_TAG, str);
    }

    public static void putPhoneIdAndSubIdExtra(Intent intent, int i) {
        int[] subId = getSubId(i);
        if (subId == null || subId.length <= 0) {
            logd("putPhoneIdAndSubIdExtra: no valid subs");
        } else {
            putPhoneIdAndSubIdExtra(intent, i, subId[0]);
        }
    }

    public static void putPhoneIdAndSubIdExtra(Intent intent, int i, int i2) {
        intent.putExtra("subscription", i2);
        intent.putExtra("phone", i);
        intent.putExtra("slot", i);
    }

    public static void setSMSPromptEnabled(boolean z) {
        try {
            ISub asInterface = ISub.Stub.asInterface(ServiceManager.getService("isub"));
            if (asInterface != null) {
                asInterface.setSMSPromptEnabled(z);
            }
        } catch (RemoteException e) {
        }
    }

    public static int setSubState(int i, int i2) {
        logd("setSubState sub id = " + i + " state = " + i2);
        try {
            return getISubInfo().setSubState(i, i2);
        } catch (RemoteException e) {
            return 0;
        }
    }

    public static void setVoicePromptEnabled(boolean z) {
        try {
            ISub asInterface = ISub.Stub.asInterface(ServiceManager.getService("isub"));
            if (asInterface != null) {
                asInterface.setVoicePromptEnabled(z);
            }
        } catch (RemoteException e) {
        }
    }

    public void addOnSubscriptionsChangedListener(OnSubscriptionsChangedListener onSubscriptionsChangedListener) {
        String packageName = this.mContext != null ? this.mContext.getPackageName() : "<unknown>";
        try {
            ITelephonyRegistry asInterface = ITelephonyRegistry.Stub.asInterface(ServiceManager.getService("telephony.registry"));
            if (asInterface != null) {
                asInterface.addOnSubscriptionsChangedListener(packageName, onSubscriptionsChangedListener.callback);
            }
        } catch (RemoteException e) {
        }
    }

    public Uri addSubscriptionInfoRecord(String str, int i) {
        if (str == null) {
            logd("[addSubscriptionInfoRecord]- null iccId");
        }
        if (!isValidSlotId(i)) {
            logd("[addSubscriptionInfoRecord]- invalid slotId");
        }
        try {
            ISub asInterface = ISub.Stub.asInterface(ServiceManager.getService("isub"));
            if (asInterface != null) {
                asInterface.addSubInfoRecord(str, i);
                return null;
            }
            return null;
        } catch (RemoteException e) {
            return null;
        }
    }

    public boolean allDefaultsSelected() {
        return isValidSubscriptionId(getDefaultDataSubId()) && isValidSubscriptionId(getDefaultSmsSubId()) && isValidSubscriptionId(getDefaultVoiceSubId());
    }

    public void clearDefaultsForInactiveSubIds() {
        try {
            ISub asInterface = ISub.Stub.asInterface(ServiceManager.getService("isub"));
            if (asInterface != null) {
                asInterface.clearDefaultsForInactiveSubIds();
            }
        } catch (RemoteException e) {
        }
    }

    public void clearSubscriptionInfo() {
        try {
            ISub asInterface = ISub.Stub.asInterface(ServiceManager.getService("isub"));
            if (asInterface != null) {
                asInterface.clearSubInfo();
            }
        } catch (RemoteException e) {
        }
    }

    public int[] getActiveSubscriptionIdList() {
        int[] iArr;
        try {
            ISub asInterface = ISub.Stub.asInterface(ServiceManager.getService("isub"));
            iArr = null;
            if (asInterface != null) {
                iArr = asInterface.getActiveSubIdList();
            }
        } catch (RemoteException e) {
            iArr = null;
        }
        int[] iArr2 = iArr;
        if (iArr == null) {
            iArr2 = new int[0];
        }
        return iArr2;
    }

    public SubscriptionInfo getActiveSubscriptionInfo(int i) {
        if (!isValidSubscriptionId(i)) {
            logd("[getActiveSubscriptionInfo]- invalid subId");
            return null;
        }
        try {
            ISub asInterface = ISub.Stub.asInterface(ServiceManager.getService("isub"));
            if (asInterface != null) {
                return asInterface.getActiveSubscriptionInfo(i);
            }
            return null;
        } catch (RemoteException e) {
            return null;
        }
    }

    public int getActiveSubscriptionInfoCount() {
        int i = 0;
        try {
            ISub asInterface = ISub.Stub.asInterface(ServiceManager.getService("isub"));
            if (asInterface != null) {
                i = asInterface.getActiveSubInfoCount();
            }
            return i;
        } catch (RemoteException e) {
            return 0;
        }
    }

    public int getActiveSubscriptionInfoCountMax() {
        int i = 0;
        try {
            ISub asInterface = ISub.Stub.asInterface(ServiceManager.getService("isub"));
            if (asInterface != null) {
                i = asInterface.getActiveSubInfoCountMax();
            }
            return i;
        } catch (RemoteException e) {
            return 0;
        }
    }

    public SubscriptionInfo getActiveSubscriptionInfoForIccIndex(String str) {
        if (str == null) {
            logd("[getActiveSubscriptionInfoForIccIndex]- null iccid");
            return null;
        }
        try {
            ISub asInterface = ISub.Stub.asInterface(ServiceManager.getService("isub"));
            if (asInterface != null) {
                return asInterface.getActiveSubscriptionInfoForIccId(str);
            }
            return null;
        } catch (RemoteException e) {
            return null;
        }
    }

    public SubscriptionInfo getActiveSubscriptionInfoForSimSlotIndex(int i) {
        if (!isValidSlotId(i)) {
            logd("[getActiveSubscriptionInfoForSimSlotIndex]- invalid slotIdx");
            return null;
        }
        try {
            ISub asInterface = ISub.Stub.asInterface(ServiceManager.getService("isub"));
            if (asInterface != null) {
                return asInterface.getActiveSubscriptionInfoForSimSlotIndex(i);
            }
            return null;
        } catch (RemoteException e) {
            return null;
        }
    }

    public List<SubscriptionInfo> getActiveSubscriptionInfoList() {
        List<SubscriptionInfo> list = null;
        try {
            ISub asInterface = ISub.Stub.asInterface(ServiceManager.getService("isub"));
            if (asInterface != null) {
                list = asInterface.getActiveSubscriptionInfoList();
            }
            return list;
        } catch (RemoteException e) {
            return null;
        }
    }

    public int getAllSubscriptionInfoCount() {
        int i = 0;
        try {
            ISub asInterface = ISub.Stub.asInterface(ServiceManager.getService("isub"));
            if (asInterface != null) {
                i = asInterface.getAllSubInfoCount();
            }
            return i;
        } catch (RemoteException e) {
            return 0;
        }
    }

    public List<SubscriptionInfo> getAllSubscriptionInfoList() {
        ArrayList arrayList;
        try {
            ISub asInterface = ISub.Stub.asInterface(ServiceManager.getService("isub"));
            arrayList = null;
            if (asInterface != null) {
                arrayList = asInterface.getAllSubInfoList();
            }
        } catch (RemoteException e) {
            arrayList = null;
        }
        ArrayList arrayList2 = arrayList;
        if (arrayList == null) {
            arrayList2 = new ArrayList();
        }
        return arrayList2;
    }

    public int getDefaultDataPhoneId() {
        return getPhoneId(getDefaultDataSubId());
    }

    public SubscriptionInfo getDefaultDataSubscriptionInfo() {
        return getActiveSubscriptionInfo(getDefaultDataSubId());
    }

    public int getDefaultSmsPhoneId() {
        return getPhoneId(getDefaultSmsSubId());
    }

    public SubscriptionInfo getDefaultSmsSubscriptionInfo() {
        return getActiveSubscriptionInfo(getDefaultSmsSubId());
    }

    public SubscriptionInfo getDefaultVoiceSubscriptionInfo() {
        return getActiveSubscriptionInfo(getDefaultVoiceSubId());
    }

    public boolean isNetworkRoaming(int i) {
        if (getPhoneId(i) < 0) {
            return false;
        }
        return TelephonyManager.getDefault().isNetworkRoaming(i);
    }

    public void removeOnSubscriptionsChangedListener(OnSubscriptionsChangedListener onSubscriptionsChangedListener) {
        String packageName = this.mContext != null ? this.mContext.getPackageName() : "<unknown>";
        try {
            ITelephonyRegistry asInterface = ITelephonyRegistry.Stub.asInterface(ServiceManager.getService("telephony.registry"));
            if (asInterface != null) {
                asInterface.removeOnSubscriptionsChangedListener(packageName, onSubscriptionsChangedListener.callback);
            }
        } catch (RemoteException e) {
        }
    }

    public int setDataRoaming(int i, int i2) {
        int i3;
        if (i < 0 || !isValidSubscriptionId(i2)) {
            logd("[setDataRoaming]- fail");
            i3 = -1;
        } else {
            i3 = 0;
            try {
                ISub asInterface = ISub.Stub.asInterface(ServiceManager.getService("isub"));
                if (asInterface != null) {
                    return asInterface.setDataRoaming(i, i2);
                }
            } catch (RemoteException e) {
                return 0;
            }
        }
        return i3;
    }

    public void setDefaultDataSubId(int i) {
        try {
            ISub asInterface = ISub.Stub.asInterface(ServiceManager.getService("isub"));
            if (asInterface != null) {
                asInterface.setDefaultDataSubId(i);
            }
        } catch (RemoteException e) {
        }
    }

    public void setDefaultSmsSubId(int i) {
        try {
            ISub asInterface = ISub.Stub.asInterface(ServiceManager.getService("isub"));
            if (asInterface != null) {
                asInterface.setDefaultSmsSubId(i);
            }
        } catch (RemoteException e) {
        }
    }

    public void setDefaultVoiceSubId(int i) {
        try {
            ISub asInterface = ISub.Stub.asInterface(ServiceManager.getService("isub"));
            if (asInterface != null) {
                asInterface.setDefaultVoiceSubId(i);
            }
        } catch (RemoteException e) {
        }
    }

    public int setDisplayName(String str, int i) {
        return setDisplayName(str, i, -1L);
    }

    public int setDisplayName(String str, int i, long j) {
        int i2;
        if (isValidSubscriptionId(i)) {
            i2 = 0;
            try {
                ISub asInterface = ISub.Stub.asInterface(ServiceManager.getService("isub"));
                if (asInterface != null) {
                    return asInterface.setDisplayNameUsingSrc(str, i, j);
                }
            } catch (RemoteException e) {
                return 0;
            }
        } else {
            logd("[setDisplayName]- fail");
            i2 = -1;
        }
        return i2;
    }

    public int setDisplayNumber(String str, int i) {
        int i2;
        if (str == null || !isValidSubscriptionId(i)) {
            logd("[setDisplayNumber]- fail");
            i2 = -1;
        } else {
            i2 = 0;
            try {
                ISub asInterface = ISub.Stub.asInterface(ServiceManager.getService("isub"));
                if (asInterface != null) {
                    return asInterface.setDisplayNumber(str, i);
                }
            } catch (RemoteException e) {
                return 0;
            }
        }
        return i2;
    }

    public int setIconTint(int i, int i2) {
        int i3;
        if (isValidSubscriptionId(i2)) {
            i3 = 0;
            try {
                ISub asInterface = ISub.Stub.asInterface(ServiceManager.getService("isub"));
                if (asInterface != null) {
                    return asInterface.setIconTint(i, i2);
                }
            } catch (RemoteException e) {
                return 0;
            }
        } else {
            logd("[setIconTint]- fail");
            i3 = -1;
        }
        return i3;
    }
}
