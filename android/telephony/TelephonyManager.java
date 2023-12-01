package android.telephony;

import android.Manifest;
import android.app.AppOpsManager;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.SystemProperties;
import android.provider.Settings;
import android.util.Log;
import com.android.internal.R;
import com.android.internal.telecom.ITelecomService;
import com.android.internal.telephony.IPhoneSubInfo;
import com.android.internal.telephony.ITelephony;
import com.android.internal.telephony.ITelephonyRegistry;
import com.android.internal.telephony.PhoneConstants;
import com.android.internal.telephony.TelephonyProperties;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: source-9557208-dex2jar.jar:android/telephony/TelephonyManager.class */
public class TelephonyManager {
    public static final String ACTION_PHONE_STATE_CHANGED = "android.intent.action.PHONE_STATE";
    public static final String ACTION_PRECISE_CALL_STATE_CHANGED = "android.intent.action.PRECISE_CALL_STATE";
    public static final String ACTION_PRECISE_DATA_CONNECTION_STATE_CHANGED = "android.intent.action.PRECISE_DATA_CONNECTION_STATE_CHANGED";
    public static final String ACTION_RESPOND_VIA_MESSAGE = "android.intent.action.RESPOND_VIA_MESSAGE";
    public static final int CALL_STATE_IDLE = 0;
    public static final int CALL_STATE_OFFHOOK = 2;
    public static final int CALL_STATE_RINGING = 1;
    public static final int CARRIER_PRIVILEGE_STATUS_ERROR_LOADING_RULES = -2;
    public static final int CARRIER_PRIVILEGE_STATUS_HAS_ACCESS = 1;
    public static final int CARRIER_PRIVILEGE_STATUS_NO_ACCESS = 0;
    public static final int CARRIER_PRIVILEGE_STATUS_RULES_NOT_LOADED = -1;
    public static final int DATA_ACTIVITY_DORMANT = 4;
    public static final int DATA_ACTIVITY_IN = 1;
    public static final int DATA_ACTIVITY_INOUT = 3;
    public static final int DATA_ACTIVITY_NONE = 0;
    public static final int DATA_ACTIVITY_OUT = 2;
    public static final int DATA_CONNECTED = 2;
    public static final int DATA_CONNECTING = 1;
    public static final int DATA_DISCONNECTED = 0;
    public static final int DATA_SUSPENDED = 3;
    public static final int DATA_UNKNOWN = -1;
    public static final String EXTRA_BACKGROUND_CALL_STATE = "background_state";
    public static final String EXTRA_DATA_APN = "apn";
    public static final String EXTRA_DATA_APN_TYPE = "apnType";
    public static final String EXTRA_DATA_CHANGE_REASON = "reason";
    public static final String EXTRA_DATA_FAILURE_CAUSE = "failCause";
    public static final String EXTRA_DATA_LINK_PROPERTIES_KEY = "linkProperties";
    public static final String EXTRA_DATA_NETWORK_TYPE = "networkType";
    public static final String EXTRA_DATA_STATE = "state";
    public static final String EXTRA_DISCONNECT_CAUSE = "disconnect_cause";
    public static final String EXTRA_FOREGROUND_CALL_STATE = "foreground_state";
    public static final String EXTRA_INCOMING_NUMBER = "incoming_number";
    public static final String EXTRA_IS_FORWARDED = "is_forwarded";
    public static final String EXTRA_PRECISE_DISCONNECT_CAUSE = "precise_disconnect_cause";
    public static final String EXTRA_RINGING_CALL_STATE = "ringing_state";
    public static final String EXTRA_STATE = "state";
    public static final int NETWORK_CLASS_2_G = 1;
    public static final int NETWORK_CLASS_3_G = 2;
    public static final int NETWORK_CLASS_4_G = 3;
    public static final int NETWORK_CLASS_UNKNOWN = 0;
    public static final int NETWORK_TYPE_1xRTT = 7;
    public static final int NETWORK_TYPE_CDMA = 4;
    public static final int NETWORK_TYPE_EDGE = 2;
    public static final int NETWORK_TYPE_EHRPD = 14;
    public static final int NETWORK_TYPE_EVDO_0 = 5;
    public static final int NETWORK_TYPE_EVDO_A = 6;
    public static final int NETWORK_TYPE_EVDO_B = 12;
    public static final int NETWORK_TYPE_GPRS = 1;
    public static final int NETWORK_TYPE_GSM = 16;
    public static final int NETWORK_TYPE_HSDPA = 8;
    public static final int NETWORK_TYPE_HSPA = 10;
    public static final int NETWORK_TYPE_HSPAP = 15;
    public static final int NETWORK_TYPE_HSUPA = 9;
    public static final int NETWORK_TYPE_IDEN = 11;
    public static final int NETWORK_TYPE_IWLAN = 18;
    public static final int NETWORK_TYPE_LTE = 13;
    public static final int NETWORK_TYPE_TD_SCDMA = 17;
    public static final int NETWORK_TYPE_UMTS = 3;
    public static final int NETWORK_TYPE_UNKNOWN = 0;
    public static final int PHONE_TYPE_CDMA = 2;
    public static final int PHONE_TYPE_GSM = 1;
    public static final int PHONE_TYPE_NONE = 0;
    public static final int PHONE_TYPE_SIP = 3;
    public static final int SIM_STATE_ABSENT = 1;
    public static final int SIM_STATE_CARD_IO_ERROR = 8;
    public static final int SIM_STATE_NETWORK_LOCKED = 4;
    public static final int SIM_STATE_NOT_READY = 6;
    public static final int SIM_STATE_PERM_DISABLED = 7;
    public static final int SIM_STATE_PIN_REQUIRED = 2;
    public static final int SIM_STATE_PUK_REQUIRED = 3;
    public static final int SIM_STATE_READY = 5;
    public static final int SIM_STATE_UNKNOWN = 0;
    private static final String TAG = "TelephonyManager";
    private static ITelephonyRegistry sRegistry;
    private final Context mContext;
    private SubscriptionManager mSubscriptionManager;
    private static String multiSimConfig = SystemProperties.get(TelephonyProperties.PROPERTY_MULTI_SIM_CONFIG);
    private static TelephonyManager sInstance = new TelephonyManager();
    public static final String EXTRA_STATE_IDLE = PhoneConstants.State.IDLE.toString();
    public static final String EXTRA_STATE_RINGING = PhoneConstants.State.RINGING.toString();
    public static final String EXTRA_STATE_OFFHOOK = PhoneConstants.State.OFFHOOK.toString();
    private static final String sKernelCmdLine = getProcCmdLine();
    private static final Pattern sProductTypePattern = Pattern.compile("\\sproduct_type\\s*=\\s*(\\w+)");
    private static final String sLteOnCdmaProductType = SystemProperties.get(TelephonyProperties.PROPERTY_LTE_ON_CDMA_PRODUCT_TYPE, "");

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: android.telephony.TelephonyManager$1  reason: invalid class name */
    /* loaded from: source-9557208-dex2jar.jar:android/telephony/TelephonyManager$1.class */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$android$telephony$TelephonyManager$MultiSimVariants = new int[MultiSimVariants.values().length];

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x0038 -> B:23:0x002a). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x003c -> B:21:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0040 -> B:19:0x0014). Please submit an issue!!! */
        static {
            try {
                $SwitchMap$android$telephony$TelephonyManager$MultiSimVariants[MultiSimVariants.UNKNOWN.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$android$telephony$TelephonyManager$MultiSimVariants[MultiSimVariants.DSDS.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$android$telephony$TelephonyManager$MultiSimVariants[MultiSimVariants.DSDA.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$android$telephony$TelephonyManager$MultiSimVariants[MultiSimVariants.TSTS.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/telephony/TelephonyManager$MultiSimVariants.class */
    public enum MultiSimVariants {
        DSDS,
        DSDA,
        TSTS,
        UNKNOWN
    }

    /* loaded from: source-9557208-dex2jar.jar:android/telephony/TelephonyManager$WifiCallingChoices.class */
    public interface WifiCallingChoices {
        public static final int ALWAYS_USE = 0;
        public static final int ASK_EVERY_TIME = 1;
        public static final int NEVER_USE = 2;
    }

    private TelephonyManager() {
        this.mContext = null;
    }

    public TelephonyManager(Context context) {
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            this.mContext = applicationContext;
        } else {
            this.mContext = context;
        }
        this.mSubscriptionManager = SubscriptionManager.from(this.mContext);
        if (sRegistry == null) {
            sRegistry = ITelephonyRegistry.Stub.asInterface(ServiceManager.getService("telephony.registry"));
        }
    }

    public static TelephonyManager from(Context context) {
        return (TelephonyManager) context.getSystemService("phone");
    }

    public static TelephonyManager getDefault() {
        return sInstance;
    }

    private static int getDefaultPhone() {
        return SubscriptionManager.getPhoneId(SubscriptionManager.getDefaultSubId());
    }

    private static int getDefaultSubscription() {
        return SubscriptionManager.getDefaultSubId();
    }

    private ITelephony getITelephony() {
        return ITelephony.Stub.asInterface(ServiceManager.getService("phone"));
    }

    public static int getIntAtIndex(ContentResolver contentResolver, String str, int i) throws Settings.SettingNotFoundException {
        String string = Settings.Global.getString(contentResolver, str);
        if (string != null) {
            String[] split = string.split(",");
            if (i >= 0 && i < split.length && split[i] != null) {
                try {
                    return Integer.parseInt(split[i]);
                } catch (NumberFormatException e) {
                }
            }
        }
        throw new Settings.SettingNotFoundException(str);
    }

    public static int getIntWithSubId(ContentResolver contentResolver, String str, int i) throws Settings.SettingNotFoundException {
        int i2;
        try {
            i2 = Settings.Global.getInt(contentResolver, str + i);
        } catch (Settings.SettingNotFoundException e) {
            try {
                int i3 = Settings.Global.getInt(contentResolver, str);
                Settings.Global.putInt(contentResolver, str + i, i3);
                int i4 = i3;
                if (str.equals(Settings.Global.MOBILE_DATA)) {
                    i4 = "true".equalsIgnoreCase(SystemProperties.get("ro.com.android.mobiledata", "true")) ? 1 : 0;
                }
                i2 = i3;
                if (i4 != i3) {
                    Settings.Global.putInt(contentResolver, str, i4);
                    return i3;
                }
            } catch (Settings.SettingNotFoundException e2) {
                throw new Settings.SettingNotFoundException(str);
            }
        }
        return i2;
    }

    public static int getIntWithSubId(ContentResolver contentResolver, String str, int i, int i2) {
        return Settings.Global.getInt(contentResolver, str + i, Settings.Global.getInt(contentResolver, str, i2));
    }

    public static int getLteOnCdmaModeStatic() {
        return getLteOnCdmaModeStatic(SubscriptionManager.getSlotId(SubscriptionManager.getDefaultSubId()));
    }

    public static int getLteOnCdmaModeStatic(int i) {
        int telephonyProperty = getTelephonyProperty(TelephonyProperties.PROPERTY_LTE_ON_CDMA_DEVICE, i, -1);
        String str = "";
        int i2 = telephonyProperty;
        if (telephonyProperty == -1) {
            Matcher matcher = sProductTypePattern.matcher(sKernelCmdLine);
            if (matcher.find()) {
                str = matcher.group(1);
                i2 = sLteOnCdmaProductType.equals(str) ? 1 : 0;
            } else {
                i2 = 0;
                str = "";
            }
        }
        Rlog.d(TAG, "getLteOnCdmaMode=" + i2 + " curVal=" + telephonyProperty + " product_type='" + str + "' lteOnCdmaProductType='" + sLteOnCdmaProductType + "'");
        return i2;
    }

    public static int getLteOnGsmModeStatic() {
        return SystemProperties.getInt(TelephonyProperties.PROPERTY_LTE_ON_GSM_DEVICE, 0);
    }

    public static int getNetworkClass(int i) {
        switch (i) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
            case 16:
                return 1;
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
            case 17:
                return 2;
            case 13:
            case 18:
                return 3;
            default:
                return 0;
        }
    }

    public static String getNetworkTypeName(int i) {
        switch (i) {
            case 1:
                return "GPRS";
            case 2:
                return "EDGE";
            case 3:
                return "UMTS";
            case 4:
                return "CDMA";
            case 5:
                return "CDMA - EvDo rev. 0";
            case 6:
                return "CDMA - EvDo rev. A";
            case 7:
                return "CDMA - 1xRTT";
            case 8:
                return "HSDPA";
            case 9:
                return "HSUPA";
            case 10:
                return "HSPA";
            case 11:
                return "iDEN";
            case 12:
                return "CDMA - EvDo rev. B";
            case 13:
                return "LTE";
            case 14:
                return "CDMA - eHRPD";
            case 15:
                return "HSPA+";
            case 16:
                return "GSM";
            case 17:
                return "TD-SCDMA";
            case 18:
                return "IWLAN";
            default:
                return "UNKNOWN";
        }
    }

    public static int getPhoneType(int i) {
        int i2 = 2;
        switch (i) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 9:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
                return 1;
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 10:
            case 21:
            case 22:
                break;
            case 11:
                i2 = 2;
                if (getLteOnCdmaModeStatic() != 1) {
                    return 1;
                }
                break;
            default:
                i2 = 1;
                break;
        }
        return i2;
    }

    private int getPhoneTypeFromNetworkType() {
        return getPhoneTypeFromNetworkType(getDefaultPhone());
    }

    private int getPhoneTypeFromNetworkType(int i) {
        String telephonyProperty = getTelephonyProperty(i, "ro.telephony.default_network", (String) null);
        if (telephonyProperty != null) {
            return getPhoneType(Integer.parseInt(telephonyProperty));
        }
        return 0;
    }

    private int getPhoneTypeFromProperty() {
        return getPhoneTypeFromProperty(getDefaultPhone());
    }

    private int getPhoneTypeFromProperty(int i) {
        String telephonyProperty = getTelephonyProperty(i, TelephonyProperties.CURRENT_ACTIVE_PHONE, (String) null);
        return (telephonyProperty == null || telephonyProperty.equals("")) ? getPhoneTypeFromNetworkType(i) : Integer.parseInt(telephonyProperty);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v18, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v30, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.lang.String] */
    private static String getProcCmdLine() {
        FileInputStream fileInputStream;
        IOException e;
        String str = null;
        try {
            try {
                fileInputStream = new FileInputStream("/proc/cmdline");
                try {
                    byte[] bArr = new byte[2048];
                    int read = fileInputStream.read(bArr);
                    str = read > 0 ? new String(bArr, 0, read) : "";
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e2) {
                        }
                    }
                } catch (IOException e3) {
                    e = e3;
                    Rlog.d(TAG, "No /proc/cmdline exception=" + e);
                    str = "";
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                            str = "";
                        } catch (IOException e4) {
                            str = "";
                        }
                    }
                    Rlog.d(TAG, "/proc/cmdline=" + ((String) str));
                    return str;
                } catch (Throwable th) {
                    str = fileInputStream;
                    th = th;
                    if (str != null) {
                        try {
                            str.close();
                        } catch (IOException e5) {
                        }
                    }
                    throw th;
                }
            } catch (IOException e6) {
                fileInputStream = null;
                e = e6;
            }
            Rlog.d(TAG, "/proc/cmdline=" + ((String) str));
            return str;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private IPhoneSubInfo getSubscriberInfo() {
        return IPhoneSubInfo.Stub.asInterface(ServiceManager.getService("iphonesubinfo"));
    }

    private ITelecomService getTelecomService() {
        return ITelecomService.Stub.asInterface(ServiceManager.getService("telecom"));
    }

    public static int getTelephonyProperty(String str, int i, int i2) {
        String str2 = SystemProperties.get(str);
        String str3 = null;
        if (str2 != null) {
            str3 = null;
            if (str2.length() > 0) {
                String[] split = str2.split(",");
                str3 = null;
                if (i >= 0) {
                    str3 = null;
                    if (i < split.length) {
                        str3 = null;
                        if (split[i] != null) {
                            str3 = split[i];
                        }
                    }
                }
            }
        }
        return str3 == null ? i2 : Integer.parseInt(str3);
    }

    public static String getTelephonyProperty(int i, String str, String str2) {
        String str3 = SystemProperties.get(str);
        String str4 = null;
        if (str3 != null) {
            str4 = null;
            if (str3.length() > 0) {
                String[] split = str3.split(",");
                str4 = null;
                if (i >= 0) {
                    str4 = null;
                    if (i < split.length) {
                        str4 = null;
                        if (split[i] != null) {
                            str4 = split[i];
                        }
                    }
                }
            }
        }
        Rlog.d(TAG, "getTelephonyProperty: return propVal='" + str4 + "' phoneId=" + i + " property='" + str + "' defaultVal='" + str2 + "' prop=" + str3);
        return str4 == null ? str2 : str4;
    }

    public static boolean putIntAtIndex(ContentResolver contentResolver, String str, int i, int i2) {
        String str2 = "";
        String[] strArr = null;
        String string = Settings.Global.getString(contentResolver, str);
        if (i == Integer.MAX_VALUE) {
            throw new RuntimeException("putIntAtIndex index == MAX_VALUE index=" + i);
        }
        if (i < 0) {
            throw new RuntimeException("putIntAtIndex index < 0 index=" + i);
        }
        if (string != null) {
            strArr = string.split(",");
        }
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= i) {
                break;
            }
            String str3 = "";
            if (strArr != null) {
                str3 = "";
                if (i4 < strArr.length) {
                    str3 = strArr[i4];
                }
            }
            str2 = str2 + str3 + ",";
            i3 = i4 + 1;
        }
        String str4 = str2 + i2;
        String str5 = str4;
        if (strArr != null) {
            while (true) {
                i++;
                str5 = str4;
                if (i >= strArr.length) {
                    break;
                }
                str4 = str4 + "," + strArr[i];
            }
        }
        return Settings.Global.putString(contentResolver, str, str5);
    }

    public static void setTelephonyProperty(int i, String str, String str2) {
        String str3 = SystemProperties.get(str);
        String str4 = str2;
        if (str2 == null) {
            str4 = "";
        }
        String[] split = str3 != null ? str3.split(",") : null;
        if (!SubscriptionManager.isValidPhoneId(i)) {
            Rlog.d(TAG, "setTelephonyProperty: invalid phoneId=" + i + " property=" + str + " value: " + str4 + " prop=" + str3);
            return;
        }
        String str5 = "";
        for (int i2 = 0; i2 < i; i2++) {
            String str6 = "";
            if (split != null) {
                str6 = "";
                if (i2 < split.length) {
                    str6 = split[i2];
                }
            }
            str5 = str5 + str6 + ",";
        }
        String str7 = str5 + str4;
        String str8 = str7;
        if (split != null) {
            int i3 = i;
            while (true) {
                int i4 = i3 + 1;
                str8 = str7;
                if (i4 >= split.length) {
                    break;
                }
                str7 = str7 + "," + split[i4];
                i3 = i4;
            }
        }
        if (str.length() > 31 || str8.length() > 91) {
            Rlog.d(TAG, "setTelephonyProperty: property to long phoneId=" + i + " property=" + str + " value: " + str4 + " propVal=" + str8);
            return;
        }
        Rlog.d(TAG, "setTelephonyProperty: success phoneId=" + i + " property=" + str + " value: " + str4 + " propVal=" + str8);
        SystemProperties.set(str, str8);
    }

    public void addProtectedSmsAddress(String str) {
        this.mContext.enforceCallingOrSelfPermission(Manifest.permission.MODIFY_PROTECTED_SMS_LIST, null);
        try {
            getITelephony().addProtectedSmsAddress(str);
        } catch (RemoteException e) {
        } catch (NullPointerException e2) {
        }
    }

    public void answerRingingCall() {
        try {
            getITelephony().answerRingingCall();
        } catch (RemoteException e) {
            Log.e(TAG, "Error calling ITelephony#answerRingingCall", e);
        }
    }

    public void call(String str, String str2) {
        try {
            getITelephony().call(str, str2);
        } catch (RemoteException e) {
            Log.e(TAG, "Error calling ITelephony#call", e);
        }
    }

    public int checkCarrierPrivilegesForPackage(String str) {
        try {
            return getITelephony().checkCarrierPrivilegesForPackage(str);
        } catch (RemoteException e) {
            Rlog.e(TAG, "checkCarrierPrivilegesForPackage RemoteException", e);
            return 0;
        } catch (NullPointerException e2) {
            Rlog.e(TAG, "checkCarrierPrivilegesForPackage NPE", e2);
            return 0;
        }
    }

    public void dial(String str) {
        try {
            getITelephony().dial(str);
        } catch (RemoteException e) {
            Log.e(TAG, "Error calling ITelephony#dial", e);
        }
    }

    public boolean disableDataConnectivity() {
        try {
            return getITelephony().disableDataConnectivity();
        } catch (RemoteException e) {
            Log.e(TAG, "Error calling ITelephony#disableDataConnectivity", e);
            return false;
        }
    }

    public void disableLocationUpdates() {
        disableLocationUpdates(getDefaultSubscription());
    }

    public void disableLocationUpdates(int i) {
        try {
            getITelephony().disableLocationUpdatesForSubscriber(i);
        } catch (RemoteException e) {
        } catch (NullPointerException e2) {
        }
    }

    public boolean enableDataConnectivity() {
        try {
            return getITelephony().enableDataConnectivity();
        } catch (RemoteException e) {
            Log.e(TAG, "Error calling ITelephony#enableDataConnectivity", e);
            return false;
        }
    }

    public void enableLocationUpdates() {
        enableLocationUpdates(getDefaultSubscription());
    }

    public void enableLocationUpdates(int i) {
        try {
            getITelephony().enableLocationUpdatesForSubscriber(i);
        } catch (RemoteException e) {
        } catch (NullPointerException e2) {
        }
    }

    public void enableVideoCalling(boolean z) {
        try {
            getITelephony().enableVideoCalling(z);
        } catch (RemoteException e) {
            Log.e(TAG, "Error calling ITelephony#enableVideoCalling", e);
        }
    }

    public boolean endCall() {
        try {
            return getITelephony().endCall();
        } catch (RemoteException e) {
            Log.e(TAG, "Error calling ITelephony#endCall", e);
            return false;
        }
    }

    public List<CellInfo> getAllCellInfo() {
        return getAllCellInfo(getDefaultSubscription());
    }

    public List<CellInfo> getAllCellInfo(int i) {
        try {
            return getITelephony().getAllCellInfoUsingSubId(i);
        } catch (RemoteException e) {
            return null;
        } catch (NullPointerException e2) {
            return null;
        }
    }

    public int getCallState() {
        try {
            return getTelecomService().getCallState();
        } catch (RemoteException | NullPointerException e) {
            return 0;
        }
    }

    public int getCallState(int i) {
        try {
            return getITelephony().getCallStateForSubscriber(i);
        } catch (RemoteException e) {
            return 0;
        } catch (NullPointerException e2) {
            return 0;
        }
    }

    public List<String> getCarrierPackageNamesForIntent(Intent intent) {
        try {
            return getITelephony().getCarrierPackageNamesForIntent(intent);
        } catch (RemoteException e) {
            Rlog.e(TAG, "getCarrierPackageNamesForIntent RemoteException", e);
            return null;
        } catch (NullPointerException e2) {
            Rlog.e(TAG, "getCarrierPackageNamesForIntent NPE", e2);
            return null;
        }
    }

    public int getCdmaEriIconIndex() {
        return getCdmaEriIconIndex(getDefaultSubscription());
    }

    public int getCdmaEriIconIndex(int i) {
        try {
            return getITelephony().getCdmaEriIconIndexForSubscriber(i);
        } catch (RemoteException e) {
            return -1;
        } catch (NullPointerException e2) {
            return -1;
        }
    }

    public int getCdmaEriIconMode() {
        return getCdmaEriIconMode(getDefaultSubscription());
    }

    public int getCdmaEriIconMode(int i) {
        try {
            return getITelephony().getCdmaEriIconModeForSubscriber(i);
        } catch (RemoteException e) {
            return -1;
        } catch (NullPointerException e2) {
            return -1;
        }
    }

    public String getCdmaEriText() {
        return getCdmaEriText(getDefaultSubscription());
    }

    public String getCdmaEriText(int i) {
        try {
            return getITelephony().getCdmaEriTextForSubscriber(i);
        } catch (RemoteException e) {
            return null;
        } catch (NullPointerException e2) {
            return null;
        }
    }

    public String getCdmaMdn() {
        return getCdmaMdn(getDefaultSubscription());
    }

    public String getCdmaMdn(int i) {
        try {
            return getITelephony().getCdmaMdn(i);
        } catch (RemoteException e) {
            return null;
        } catch (NullPointerException e2) {
            return null;
        }
    }

    public String getCdmaMin() {
        return getCdmaMin(getDefaultSubscription());
    }

    public String getCdmaMin(int i) {
        try {
            return getITelephony().getCdmaMin(i);
        } catch (RemoteException e) {
            return null;
        } catch (NullPointerException e2) {
            return null;
        }
    }

    public CellLocation getCellLocation() {
        CellLocation cellLocation;
        Bundle cellLocation2;
        try {
            cellLocation2 = getITelephony().getCellLocation();
        } catch (RemoteException e) {
            return null;
        } catch (NullPointerException e2) {
            cellLocation = null;
        }
        if (cellLocation2.isEmpty()) {
            return null;
        }
        cellLocation = CellLocation.newFromBundle(cellLocation2);
        if (cellLocation.isEmpty()) {
            return null;
        }
        return cellLocation;
    }

    public String getCompleteVoiceMailNumber() {
        return getCompleteVoiceMailNumber(getDefaultSubscription());
    }

    public String getCompleteVoiceMailNumber(int i) {
        try {
            return getSubscriberInfo().getCompleteVoiceMailNumberForSubscriber(i);
        } catch (RemoteException e) {
            return null;
        } catch (NullPointerException e2) {
            return null;
        }
    }

    public int getCurrentPhoneType() {
        return getCurrentPhoneType(getDefaultSubscription());
    }

    public int getCurrentPhoneType(int i) {
        int phoneId = SubscriptionManager.getPhoneId(i);
        try {
            ITelephony iTelephony = getITelephony();
            return iTelephony != null ? iTelephony.getActivePhoneTypeForSubscriber(i) : getPhoneTypeFromProperty(phoneId);
        } catch (RemoteException e) {
            return getPhoneTypeFromProperty(phoneId);
        } catch (NullPointerException e2) {
            return getPhoneTypeFromProperty(phoneId);
        }
    }

    public int getDataActivity() {
        try {
            return getITelephony().getDataActivity();
        } catch (RemoteException e) {
            return 0;
        } catch (NullPointerException e2) {
            return 0;
        }
    }

    public boolean getDataEnabled() {
        return getDataEnabled(SubscriptionManager.getDefaultDataSubId());
    }

    public boolean getDataEnabled(int i) {
        boolean z = false;
        try {
            z = getITelephony().getDataEnabled(i);
        } catch (RemoteException e) {
            Log.e(TAG, "Error calling ITelephony#getDataEnabled", e);
        } catch (NullPointerException e2) {
        }
        Log.d(TAG, "getDataEnabled: retVal=" + z);
        return z;
    }

    public int getDataNetworkType() {
        return getDataNetworkType(SubscriptionManager.getDefaultDataSubId());
    }

    public int getDataNetworkType(int i) {
        int i2 = 0;
        try {
            ITelephony iTelephony = getITelephony();
            if (iTelephony != null) {
                i2 = iTelephony.getDataNetworkTypeForSubscriber(i);
            }
            return i2;
        } catch (RemoteException e) {
            return 0;
        } catch (NullPointerException e2) {
            return 0;
        }
    }

    public int getDataState() {
        try {
            return getITelephony().getDataState();
        } catch (RemoteException e) {
            return 0;
        } catch (NullPointerException e2) {
            return 0;
        }
    }

    public int getDefaultSim() {
        return SubscriptionManager.getSlotId(SubscriptionManager.getDefaultSubId());
    }

    public String getDeviceId() {
        try {
            return getITelephony().getDeviceId();
        } catch (RemoteException e) {
            return null;
        } catch (NullPointerException e2) {
            return null;
        }
    }

    public String getDeviceId(int i) {
        try {
            return getSubscriberInfo().getDeviceIdForPhone(i);
        } catch (RemoteException e) {
            return null;
        } catch (NullPointerException e2) {
            return null;
        }
    }

    public String getDeviceSoftwareVersion() {
        return getDeviceSoftwareVersion(getDefaultSim());
    }

    public String getDeviceSoftwareVersion(int i) {
        int[] subId = SubscriptionManager.getSubId(i);
        if (subId == null || subId.length == 0) {
            return null;
        }
        try {
            return getSubscriberInfo().getDeviceSvnUsingSubId(subId[0]);
        } catch (RemoteException e) {
            return null;
        } catch (NullPointerException e2) {
            return null;
        }
    }

    public String getGroupIdLevel1() {
        try {
            return getSubscriberInfo().getGroupIdLevel1();
        } catch (RemoteException e) {
            return null;
        } catch (NullPointerException e2) {
            return null;
        }
    }

    public String getGroupIdLevel1(int i) {
        try {
            return getSubscriberInfo().getGroupIdLevel1ForSubscriber(i);
        } catch (RemoteException e) {
            return null;
        } catch (NullPointerException e2) {
            return null;
        }
    }

    public String getIccOperatorNumeric(int i) {
        try {
            return getITelephony().getIccOperatorNumeric(i);
        } catch (RemoteException e) {
            return null;
        } catch (NullPointerException e2) {
            return null;
        }
    }

    public String getIccSimChallengeResponse(int i, int i2, String str) {
        try {
            return getSubscriberInfo().getIccSimChallengeResponse(i, i2, str);
        } catch (RemoteException e) {
            return null;
        } catch (NullPointerException e2) {
            return null;
        }
    }

    public String getIccSimChallengeResponse(int i, String str) {
        return getIccSimChallengeResponse(getDefaultSubscription(), i, str);
    }

    public String getImei() {
        return getImei(getDefaultSim());
    }

    public String getImei(int i) {
        try {
            return getSubscriberInfo().getImeiForSubscriber(SubscriptionManager.getSubId(i)[0]);
        } catch (RemoteException e) {
            return null;
        } catch (NullPointerException e2) {
            return null;
        }
    }

    public String getIsimChallengeResponse(String str) {
        try {
            return getSubscriberInfo().getIsimChallengeResponse(str);
        } catch (RemoteException e) {
            return null;
        } catch (NullPointerException e2) {
            return null;
        }
    }

    public String getIsimDomain() {
        try {
            return getSubscriberInfo().getIsimDomain();
        } catch (RemoteException e) {
            return null;
        } catch (NullPointerException e2) {
            return null;
        }
    }

    public String getIsimImpi() {
        try {
            return getSubscriberInfo().getIsimImpi();
        } catch (RemoteException e) {
            return null;
        } catch (NullPointerException e2) {
            return null;
        }
    }

    public String[] getIsimImpu() {
        try {
            return getSubscriberInfo().getIsimImpu();
        } catch (RemoteException e) {
            return null;
        } catch (NullPointerException e2) {
            return null;
        }
    }

    public String getIsimIst() {
        try {
            return getSubscriberInfo().getIsimIst();
        } catch (RemoteException e) {
            return null;
        } catch (NullPointerException e2) {
            return null;
        }
    }

    public String[] getIsimPcscf() {
        try {
            return getSubscriberInfo().getIsimPcscf();
        } catch (RemoteException e) {
            return null;
        } catch (NullPointerException e2) {
            return null;
        }
    }

    public String getLine1AlphaTag() {
        return getLine1AlphaTagForSubscriber(getDefaultSubscription());
    }

    public String getLine1AlphaTagForSubscriber(int i) {
        String str = null;
        try {
            str = getITelephony().getLine1AlphaTagForDisplay(i);
        } catch (RemoteException e) {
        } catch (NullPointerException e2) {
        }
        if (str != null) {
            return str;
        }
        try {
            return getSubscriberInfo().getLine1AlphaTagForSubscriber(i);
        } catch (RemoteException e3) {
            return null;
        } catch (NullPointerException e4) {
            return null;
        }
    }

    public String getLine1Number() {
        return getLine1NumberForSubscriber(getDefaultSubscription());
    }

    public String getLine1NumberForSubscriber(int i) {
        String str = null;
        try {
            str = getITelephony().getLine1NumberForDisplay(i);
        } catch (RemoteException e) {
        } catch (NullPointerException e2) {
        }
        if (str != null) {
            return str;
        }
        try {
            return getSubscriberInfo().getLine1NumberForSubscriber(i);
        } catch (RemoteException e3) {
            return null;
        } catch (NullPointerException e4) {
            return null;
        }
    }

    public int getLteOnCdmaMode() {
        return getLteOnCdmaMode(getDefaultSubscription());
    }

    public int getLteOnCdmaMode(int i) {
        try {
            return getITelephony().getLteOnCdmaModeForSubscriber(i);
        } catch (RemoteException e) {
            return -1;
        } catch (NullPointerException e2) {
            return -1;
        }
    }

    public int getLteOnGsmMode() {
        try {
            return getITelephony().getLteOnGsmMode();
        } catch (RemoteException e) {
            return 0;
        } catch (NullPointerException e2) {
            return 0;
        }
    }

    public String getMmsUAProfUrl() {
        if (this.mContext == null) {
            return null;
        }
        return this.mContext.getResources().getString(R.string.config_mms_user_agent_profile_url);
    }

    public String getMmsUserAgent() {
        if (this.mContext == null) {
            return null;
        }
        return this.mContext.getResources().getString(R.string.config_mms_user_agent);
    }

    public String getMsisdn() {
        return getMsisdn(getDefaultSubscription());
    }

    public String getMsisdn(int i) {
        try {
            return getSubscriberInfo().getMsisdnForSubscriber(i);
        } catch (RemoteException e) {
            return null;
        } catch (NullPointerException e2) {
            return null;
        }
    }

    public MultiSimVariants getMultiSimConfiguration() {
        String str = SystemProperties.get(TelephonyProperties.PROPERTY_MULTI_SIM_CONFIG);
        return str.equals("dsds") ? MultiSimVariants.DSDS : str.equals("dsda") ? MultiSimVariants.DSDA : str.equals("tsts") ? MultiSimVariants.TSTS : MultiSimVariants.UNKNOWN;
    }

    public String getNai() {
        return getNai(getDefaultSim());
    }

    public String getNai(int i) {
        try {
            String naiForSubscriber = getSubscriberInfo().getNaiForSubscriber(SubscriptionManager.getSubId(i)[0]);
            if (Log.isLoggable(TAG, 2)) {
                Rlog.v(TAG, "Nai = " + naiForSubscriber);
            }
            return naiForSubscriber;
        } catch (RemoteException e) {
            return null;
        } catch (NullPointerException e2) {
            return null;
        }
    }

    public List<NeighboringCellInfo> getNeighboringCellInfo() {
        try {
            return getITelephony().getNeighboringCellInfo(this.mContext.getOpPackageName());
        } catch (RemoteException e) {
            return null;
        } catch (NullPointerException e2) {
            return null;
        }
    }

    public String getNetworkCountryIso() {
        return getNetworkCountryIsoForPhone(getDefaultPhone());
    }

    public String getNetworkCountryIsoForPhone(int i) {
        return getTelephonyProperty(i, TelephonyProperties.PROPERTY_OPERATOR_ISO_COUNTRY, "");
    }

    public String getNetworkCountryIsoForSubscription(int i) {
        return getNetworkCountryIsoForPhone(SubscriptionManager.getPhoneId(i));
    }

    public String getNetworkOperator() {
        return getNetworkOperatorForPhone(getDefaultPhone());
    }

    public String getNetworkOperatorForPhone(int i) {
        return getTelephonyProperty(i, TelephonyProperties.PROPERTY_OPERATOR_NUMERIC, "");
    }

    public String getNetworkOperatorForSubscription(int i) {
        return getNetworkOperatorForPhone(SubscriptionManager.getPhoneId(i));
    }

    public String getNetworkOperatorName() {
        return getNetworkOperatorName(getDefaultSubscription());
    }

    public String getNetworkOperatorName(int i) {
        return getTelephonyProperty(SubscriptionManager.getPhoneId(i), TelephonyProperties.PROPERTY_OPERATOR_ALPHA, "");
    }

    public int getNetworkType() {
        return getDataNetworkType();
    }

    public int getNetworkType(int i) {
        int i2 = 0;
        try {
            ITelephony iTelephony = getITelephony();
            if (iTelephony != null) {
                i2 = iTelephony.getNetworkTypeForSubscriber(i);
            }
            return i2;
        } catch (RemoteException e) {
            return 0;
        } catch (NullPointerException e2) {
            return 0;
        }
    }

    public String getNetworkTypeName() {
        return getNetworkTypeName(getNetworkType());
    }

    public String getOtaSpNumberSchema(String str) {
        return getOtaSpNumberSchemaForPhone(getDefaultPhone(), str);
    }

    public String getOtaSpNumberSchemaForPhone(int i, String str) {
        String str2 = str;
        if (SubscriptionManager.isValidPhoneId(i)) {
            str2 = getTelephonyProperty(i, TelephonyProperties.PROPERTY_OTASP_NUM_SCHEMA, str);
        }
        return str2;
    }

    public String[] getPcscfAddress(String str) {
        try {
            return getITelephony().getPcscfAddress(str);
        } catch (RemoteException e) {
            return new String[0];
        }
    }

    public int getPhoneCount() {
        switch (AnonymousClass1.$SwitchMap$android$telephony$TelephonyManager$MultiSimVariants[getMultiSimConfiguration().ordinal()]) {
            case 1:
                return 1;
            case 2:
            case 3:
                return 2;
            case 4:
                return 3;
            default:
                return 1;
        }
    }

    public int getPhoneType() {
        if (isVoiceCapable()) {
            return getCurrentPhoneType();
        }
        return 0;
    }

    public int getPreferredNetworkType() {
        try {
            return getITelephony().getPreferredNetworkType();
        } catch (RemoteException e) {
            Rlog.e(TAG, "getPreferredNetworkType RemoteException", e);
            return -1;
        } catch (NullPointerException e2) {
            Rlog.e(TAG, "getPreferredNetworkType NPE", e2);
            return -1;
        }
    }

    public int getSimCount() {
        return getPhoneCount();
    }

    public String getSimCountryIso() {
        return getSimCountryIsoForPhone(getDefaultPhone());
    }

    public String getSimCountryIso(int i) {
        return getSimCountryIsoForSubscription(i);
    }

    public String getSimCountryIsoForPhone(int i) {
        return getTelephonyProperty(i, TelephonyProperties.PROPERTY_ICC_OPERATOR_ISO_COUNTRY, "");
    }

    public String getSimCountryIsoForSubscription(int i) {
        return getSimCountryIsoForPhone(SubscriptionManager.getPhoneId(i));
    }

    public String getSimOperator() {
        return getSimOperatorNumeric();
    }

    public String getSimOperator(int i) {
        return getSimOperatorNumericForSubscription(i);
    }

    public String getSimOperatorName() {
        return getSimOperatorNameForPhone(getDefaultPhone());
    }

    public String getSimOperatorNameForPhone(int i) {
        return getTelephonyProperty(i, TelephonyProperties.PROPERTY_ICC_OPERATOR_ALPHA, "");
    }

    public String getSimOperatorNameForSubscription(int i) {
        return getSimOperatorNameForPhone(SubscriptionManager.getPhoneId(i));
    }

    public String getSimOperatorNumeric() {
        int defaultDataSubId = SubscriptionManager.getDefaultDataSubId();
        int i = defaultDataSubId;
        if (!SubscriptionManager.isUsableSubIdValue(defaultDataSubId)) {
            int defaultSmsSubId = SubscriptionManager.getDefaultSmsSubId();
            i = defaultSmsSubId;
            if (!SubscriptionManager.isUsableSubIdValue(defaultSmsSubId)) {
                int defaultVoiceSubId = SubscriptionManager.getDefaultVoiceSubId();
                i = defaultVoiceSubId;
                if (!SubscriptionManager.isUsableSubIdValue(defaultVoiceSubId)) {
                    i = SubscriptionManager.getDefaultSubId();
                }
            }
        }
        return getSimOperatorNumericForSubscription(i);
    }

    public String getSimOperatorNumericForPhone(int i) {
        return getTelephonyProperty(i, TelephonyProperties.PROPERTY_ICC_OPERATOR_NUMERIC, "");
    }

    public String getSimOperatorNumericForSubscription(int i) {
        return getSimOperatorNumericForPhone(SubscriptionManager.getPhoneId(i));
    }

    public String getSimSerialNumber() {
        return getSimSerialNumber(getDefaultSubscription());
    }

    public String getSimSerialNumber(int i) {
        try {
            return getSubscriberInfo().getIccSerialNumberForSubscriber(i);
        } catch (RemoteException e) {
            return null;
        } catch (NullPointerException e2) {
            return null;
        }
    }

    public int getSimState() {
        return getSimState(getDefaultSim());
    }

    public int getSimState(int i) {
        int[] subId = SubscriptionManager.getSubId(i);
        if (subId == null || subId.length == 0) {
            Rlog.d(TAG, "getSimState:- empty subId return SIM_STATE_ABSENT");
            return 0;
        }
        return SubscriptionManager.getSimStateForSubscriber(subId[0]);
    }

    public boolean getSmsReceiveCapable(boolean z) {
        return getSmsReceiveCapableForPhone(getDefaultPhone(), z);
    }

    public boolean getSmsReceiveCapableForPhone(int i, boolean z) {
        boolean z2 = z;
        if (SubscriptionManager.isValidPhoneId(i)) {
            z2 = Boolean.valueOf(getTelephonyProperty(i, TelephonyProperties.PROPERTY_SMS_RECEIVE, String.valueOf(z))).booleanValue();
        }
        return z2;
    }

    public boolean getSmsSendCapable(boolean z) {
        return getSmsSendCapableForPhone(getDefaultPhone(), z);
    }

    public boolean getSmsSendCapableForPhone(int i, boolean z) {
        boolean z2 = z;
        if (SubscriptionManager.isValidPhoneId(i)) {
            z2 = Boolean.valueOf(getTelephonyProperty(i, TelephonyProperties.PROPERTY_SMS_SEND, String.valueOf(z))).booleanValue();
        }
        return z2;
    }

    public String getSubscriberId() {
        return getSubscriberId(getDefaultSubscription());
    }

    public String getSubscriberId(int i) {
        try {
            return getSubscriberInfo().getSubscriberIdForSubscriber(i);
        } catch (RemoteException e) {
            return null;
        } catch (NullPointerException e2) {
            return null;
        }
    }

    public int getTetherApnRequired() {
        try {
            return getITelephony().getTetherApnRequired();
        } catch (RemoteException e) {
            Rlog.e(TAG, "hasMatchedTetherApnSetting RemoteException", e);
            return 2;
        } catch (NullPointerException e2) {
            Rlog.e(TAG, "hasMatchedTetherApnSetting NPE", e2);
            return 2;
        }
    }

    public String getVoiceMailAlphaTag() {
        return getVoiceMailAlphaTag(getDefaultSubscription());
    }

    public String getVoiceMailAlphaTag(int i) {
        try {
            return getSubscriberInfo().getVoiceMailAlphaTagForSubscriber(i);
        } catch (RemoteException e) {
            return null;
        } catch (NullPointerException e2) {
            return null;
        }
    }

    public String getVoiceMailNumber() {
        return getVoiceMailNumber(getDefaultSubscription());
    }

    public String getVoiceMailNumber(int i) {
        try {
            return getSubscriberInfo().getVoiceMailNumberForSubscriber(i);
        } catch (RemoteException e) {
            return null;
        } catch (NullPointerException e2) {
            return null;
        }
    }

    public int getVoiceMessageCount() {
        return getVoiceMessageCount(getDefaultSubscription());
    }

    public int getVoiceMessageCount(int i) {
        try {
            return getITelephony().getVoiceMessageCountForSubscriber(i);
        } catch (RemoteException e) {
            return 0;
        } catch (NullPointerException e2) {
            return 0;
        }
    }

    public int getVoiceNetworkType() {
        return getVoiceNetworkType(getDefaultSubscription());
    }

    public int getVoiceNetworkType(int i) {
        int i2 = 0;
        try {
            ITelephony iTelephony = getITelephony();
            if (iTelephony != null) {
                i2 = iTelephony.getVoiceNetworkTypeForSubscriber(i);
            }
            return i2;
        } catch (RemoteException e) {
            return 0;
        } catch (NullPointerException e2) {
            return 0;
        }
    }

    public boolean handlePinMmi(String str) {
        try {
            return getITelephony().handlePinMmi(str);
        } catch (RemoteException e) {
            Log.e(TAG, "Error calling ITelephony#handlePinMmi", e);
            return false;
        }
    }

    public boolean handlePinMmiForSubscriber(int i, String str) {
        try {
            return getITelephony().handlePinMmiForSubscriber(i, str);
        } catch (RemoteException e) {
            Log.e(TAG, "Error calling ITelephony#handlePinMmi", e);
            return false;
        }
    }

    public boolean hasCarrierPrivileges() {
        try {
            return getITelephony().getCarrierPrivilegeStatus() == 1;
        } catch (RemoteException e) {
            Rlog.e(TAG, "hasCarrierPrivileges RemoteException", e);
            return false;
        } catch (NullPointerException e2) {
            Rlog.e(TAG, "hasCarrierPrivileges NPE", e2);
            return false;
        }
    }

    public boolean hasIccCard() {
        return hasIccCard(getDefaultSim());
    }

    public boolean hasIccCard(int i) {
        try {
            return getITelephony().hasIccCardUsingSlotId(i);
        } catch (RemoteException e) {
            return false;
        } catch (NullPointerException e2) {
            return false;
        }
    }

    public boolean iccCloseLogicalChannel(int i) {
        try {
            return getITelephony().iccCloseLogicalChannel(i);
        } catch (RemoteException | NullPointerException e) {
            return false;
        }
    }

    public byte[] iccExchangeSimIO(int i, int i2, int i3, int i4, int i5, String str) {
        try {
            return getITelephony().iccExchangeSimIO(i, i2, i3, i4, i5, str);
        } catch (RemoteException | NullPointerException e) {
            return null;
        }
    }

    public IccOpenLogicalChannelResponse iccOpenLogicalChannel(String str) {
        try {
            return getITelephony().iccOpenLogicalChannel(str);
        } catch (RemoteException | NullPointerException e) {
            return null;
        }
    }

    public String iccTransmitApduBasicChannel(int i, int i2, int i3, int i4, int i5, String str) {
        try {
            return getITelephony().iccTransmitApduBasicChannel(i, i2, i3, i4, i5, str);
        } catch (RemoteException | NullPointerException e) {
            return "";
        }
    }

    public String iccTransmitApduLogicalChannel(int i, int i2, int i3, int i4, int i5, int i6, String str) {
        try {
            return getITelephony().iccTransmitApduLogicalChannel(i, i2, i3, i4, i5, i6, str);
        } catch (RemoteException | NullPointerException e) {
            return "";
        }
    }

    public int invokeOemRilRequestRaw(byte[] bArr, byte[] bArr2) {
        try {
            return getITelephony().invokeOemRilRequestRaw(bArr, bArr2);
        } catch (RemoteException | NullPointerException e) {
            return -1;
        }
    }

    public boolean isDataConnectivityPossible() {
        try {
            return getITelephony().isDataConnectivityPossible();
        } catch (RemoteException e) {
            Log.e(TAG, "Error calling ITelephony#isDataConnectivityPossible", e);
            return false;
        }
    }

    public boolean isDataPossibleForSubscription(int i, String str) {
        try {
            return getITelephony().isDataPossibleForSubscription(i, str);
        } catch (RemoteException e) {
            Log.e(TAG, "Error calling ITelephony#isDataPossibleForSubscription", e);
            return false;
        } catch (NullPointerException e2) {
            Log.e(TAG, "Error calling ITelephony#isDataPossibleForSubscription", e2);
            return false;
        }
    }

    public boolean isIdle() {
        try {
            return getITelephony().isIdle();
        } catch (RemoteException e) {
            Log.e(TAG, "Error calling ITelephony#isIdle", e);
            return true;
        }
    }

    public boolean isImsRegistered() {
        try {
            return getITelephony().isImsRegistered();
        } catch (RemoteException e) {
            return false;
        } catch (NullPointerException e2) {
            return false;
        }
    }

    public boolean isMultiSimEnabled() {
        return multiSimConfig.equals("dsds") || multiSimConfig.equals("dsda") || multiSimConfig.equals("tsts");
    }

    public boolean isNetworkRoaming() {
        return isNetworkRoaming(getDefaultSubscription());
    }

    public boolean isNetworkRoaming(int i) {
        return Boolean.parseBoolean(getTelephonyProperty(SubscriptionManager.getPhoneId(i), TelephonyProperties.PROPERTY_OPERATOR_ISROAMING, (String) null));
    }

    public boolean isOffhook() {
        try {
            return getITelephony().isOffhook();
        } catch (RemoteException e) {
            Log.e(TAG, "Error calling ITelephony#isOffhook", e);
            return false;
        }
    }

    public boolean isRadioOn() {
        try {
            return getITelephony().isRadioOn();
        } catch (RemoteException e) {
            Log.e(TAG, "Error calling ITelephony#isRadioOn", e);
            return false;
        }
    }

    public boolean isRinging() {
        try {
            return getITelephony().isRinging();
        } catch (RemoteException e) {
            Log.e(TAG, "Error calling ITelephony#isRinging", e);
            return false;
        }
    }

    public boolean isSimPinEnabled() {
        try {
            return getITelephony().isSimPinEnabled();
        } catch (RemoteException e) {
            Log.e(TAG, "Error calling ITelephony#isSimPinEnabled", e);
            return false;
        }
    }

    public boolean isSmsCapable() {
        if (this.mContext == null) {
            return true;
        }
        return this.mContext.getResources().getBoolean(R.bool.config_sms_capable);
    }

    public boolean isVideoCallingEnabled() {
        try {
            return getITelephony().isVideoCallingEnabled();
        } catch (RemoteException e) {
            Log.e(TAG, "Error calling ITelephony#isVideoCallingEnabled", e);
            return false;
        }
    }

    public boolean isVoiceCapable() {
        if (this.mContext == null) {
            return true;
        }
        return this.mContext.getResources().getBoolean(R.bool.config_voice_capable);
    }

    public void listen(PhoneStateListener phoneStateListener, int i) {
        try {
            sRegistry.listenForSubscriber(phoneStateListener.mSubId, this.mContext != null ? this.mContext.getPackageName() : "<unknown>", phoneStateListener.callback, i, Boolean.valueOf(getITelephony() != null).booleanValue());
        } catch (RemoteException e) {
        } catch (NullPointerException e2) {
        }
    }

    public boolean needsOtaServiceProvisioning() {
        try {
            return getITelephony().needsOtaServiceProvisioning();
        } catch (RemoteException e) {
            Log.e(TAG, "Error calling ITelephony#needsOtaServiceProvisioning", e);
            return false;
        } catch (NullPointerException e2) {
            Log.e(TAG, "Error calling ITelephony#needsOtaServiceProvisioning", e2);
            return false;
        }
    }

    public String networkTypeToString(int i) {
        String string;
        int networkClass = getNetworkClass(i);
        Rlog.d(TAG, "networkType = " + i + " networkClass = " + networkClass);
        if (this.mContext == null) {
            return null;
        }
        switch (networkClass) {
            case 1:
                string = this.mContext.getResources().getString(R.string.config_rat_2g);
                break;
            case 2:
                string = this.mContext.getResources().getString(R.string.config_rat_3g);
                break;
            case 3:
                string = this.mContext.getResources().getString(R.string.config_rat_4g);
                break;
            default:
                string = "";
                break;
        }
        return string;
    }

    public String nvReadItem(int i) {
        try {
            return getITelephony().nvReadItem(i);
        } catch (RemoteException e) {
            Rlog.e(TAG, "nvReadItem RemoteException", e);
            return "";
        } catch (NullPointerException e2) {
            Rlog.e(TAG, "nvReadItem NPE", e2);
            return "";
        }
    }

    public boolean nvResetConfig(int i) {
        try {
            return getITelephony().nvResetConfig(i);
        } catch (RemoteException e) {
            Rlog.e(TAG, "nvResetConfig RemoteException", e);
            return false;
        } catch (NullPointerException e2) {
            Rlog.e(TAG, "nvResetConfig NPE", e2);
            return false;
        }
    }

    public boolean nvWriteCdmaPrl(byte[] bArr) {
        try {
            return getITelephony().nvWriteCdmaPrl(bArr);
        } catch (RemoteException e) {
            Rlog.e(TAG, "nvWriteCdmaPrl RemoteException", e);
            return false;
        } catch (NullPointerException e2) {
            Rlog.e(TAG, "nvWriteCdmaPrl NPE", e2);
            return false;
        }
    }

    public boolean nvWriteItem(int i, String str) {
        try {
            return getITelephony().nvWriteItem(i, str);
        } catch (RemoteException e) {
            Rlog.e(TAG, "nvWriteItem RemoteException", e);
            return false;
        } catch (NullPointerException e2) {
            Rlog.e(TAG, "nvWriteItem NPE", e2);
            return false;
        }
    }

    public boolean revokeProtectedSmsAddress(String str) {
        this.mContext.enforceCallingOrSelfPermission(Manifest.permission.MODIFY_PROTECTED_SMS_LIST, null);
        try {
            return getITelephony().revokeProtectedSmsAddress(str);
        } catch (RemoteException | NullPointerException e) {
            return false;
        }
    }

    public String sendEnvelopeWithStatus(String str) {
        try {
            return getITelephony().sendEnvelopeWithStatus(str);
        } catch (RemoteException | NullPointerException e) {
            return "";
        }
    }

    public void setBasebandVersion(String str) {
        setBasebandVersionForPhone(getDefaultPhone(), str);
    }

    public void setBasebandVersionForPhone(int i, String str) {
        if (SubscriptionManager.isValidPhoneId(i)) {
            SystemProperties.set(TelephonyProperties.PROPERTY_BASEBAND_VERSION + (i == 0 ? "" : Integer.toString(i)), str);
        }
    }

    public void setCellInfoListRate(int i) {
        try {
            getITelephony().setCellInfoListRate(i);
        } catch (RemoteException e) {
        } catch (NullPointerException e2) {
        }
    }

    public void setDataEnabled(int i, boolean z) {
        setDataEnabledUsingSubId(i, z);
    }

    public void setDataEnabled(boolean z) {
        AppOpsManager appOpsManager = (AppOpsManager) this.mContext.getSystemService(Context.APP_OPS_SERVICE);
        if (!z || appOpsManager.noteOp(59) == 0) {
            setDataEnabled(SubscriptionManager.getDefaultDataSubId(), z);
        } else {
            Log.w(TAG, "Permission denied by user.");
        }
    }

    public void setDataEnabledUsingSubId(int i, boolean z) {
        try {
            AppOpsManager appOpsManager = (AppOpsManager) this.mContext.getSystemService(Context.APP_OPS_SERVICE);
            if (z && appOpsManager.noteOp(59) != 0) {
                Log.w(TAG, "Permission denied by user.");
                return;
            }
            Log.d(TAG, "setDataEnabled: enabled=" + z);
            getITelephony().setDataEnabled(i, z);
        } catch (RemoteException e) {
            Log.e(TAG, "Error calling setDataEnabled", e);
        } catch (NullPointerException e2) {
            Log.e(TAG, "Error calling setDataEnabled", e2);
        }
    }

    public void setDataNetworkType(int i) {
        setDataNetworkTypeForPhone(getDefaultPhone(), i);
    }

    public void setDataNetworkTypeForPhone(int i, int i2) {
        if (SubscriptionManager.isValidPhoneId(i)) {
            setTelephonyProperty(i, TelephonyProperties.PROPERTY_DATA_NETWORK_TYPE, ServiceState.rilRadioTechnologyToString(i2));
        }
    }

    public void setImsRegistrationState(boolean z) {
        try {
            getITelephony().setImsRegistrationState(z);
        } catch (RemoteException e) {
        }
    }

    public boolean setLine1NumberForDisplay(String str, String str2) {
        return setLine1NumberForDisplayForSubscriber(getDefaultSubscription(), str, str2);
    }

    public boolean setLine1NumberForDisplayForSubscriber(int i, String str, String str2) {
        try {
            return getITelephony().setLine1NumberForDisplayForSubscriber(i, str, str2);
        } catch (RemoteException | NullPointerException e) {
            return false;
        }
    }

    public void setNetworkCountryIso(String str) {
        setNetworkCountryIsoForPhone(getDefaultPhone(), str);
    }

    public void setNetworkCountryIsoForPhone(int i, String str) {
        if (SubscriptionManager.isValidPhoneId(i)) {
            setTelephonyProperty(i, TelephonyProperties.PROPERTY_OPERATOR_ISO_COUNTRY, str);
        }
    }

    public void setNetworkOperatorName(String str) {
        setNetworkOperatorNameForPhone(getDefaultPhone(), str);
    }

    public void setNetworkOperatorNameForPhone(int i, String str) {
        if (SubscriptionManager.isValidPhoneId(i)) {
            setTelephonyProperty(i, TelephonyProperties.PROPERTY_OPERATOR_ALPHA, str);
        }
    }

    public void setNetworkOperatorNumeric(String str) {
        setNetworkOperatorNumericForPhone(getDefaultPhone(), str);
    }

    public void setNetworkOperatorNumericForPhone(int i, String str) {
        setTelephonyProperty(i, TelephonyProperties.PROPERTY_OPERATOR_NUMERIC, str);
    }

    public void setNetworkRoaming(boolean z) {
        setNetworkRoamingForPhone(getDefaultPhone(), z);
    }

    public void setNetworkRoamingForPhone(int i, boolean z) {
        if (SubscriptionManager.isValidPhoneId(i)) {
            setTelephonyProperty(i, TelephonyProperties.PROPERTY_OPERATOR_ISROAMING, z ? "true" : "false");
        }
    }

    public boolean setOperatorBrandOverride(String str) {
        try {
            return getITelephony().setOperatorBrandOverride(str);
        } catch (RemoteException e) {
            Rlog.e(TAG, "setOperatorBrandOverride RemoteException", e);
            return false;
        } catch (NullPointerException e2) {
            Rlog.e(TAG, "setOperatorBrandOverride NPE", e2);
            return false;
        }
    }

    public void setPhoneType(int i) {
        setPhoneType(getDefaultPhone(), i);
    }

    public void setPhoneType(int i, int i2) {
        if (SubscriptionManager.isValidPhoneId(i)) {
            setTelephonyProperty(i, TelephonyProperties.CURRENT_ACTIVE_PHONE, String.valueOf(i2));
        }
    }

    public boolean setPreferredNetworkType(int i) {
        try {
            return getITelephony().setPreferredNetworkType(i);
        } catch (RemoteException e) {
            Rlog.e(TAG, "setPreferredNetworkType RemoteException", e);
            return false;
        } catch (NullPointerException e2) {
            Rlog.e(TAG, "setPreferredNetworkType NPE", e2);
            return false;
        }
    }

    public boolean setPreferredNetworkTypeToGlobal() {
        return setPreferredNetworkType(10);
    }

    public boolean setRadio(boolean z) {
        try {
            return getITelephony().setRadio(z);
        } catch (RemoteException e) {
            Log.e(TAG, "Error calling ITelephony#setRadio", e);
            return false;
        }
    }

    public boolean setRadioPower(boolean z) {
        try {
            return getITelephony().setRadioPower(z);
        } catch (RemoteException e) {
            Log.e(TAG, "Error calling ITelephony#setRadioPower", e);
            return false;
        }
    }

    public boolean setRoamingOverride(List<String> list, List<String> list2, List<String> list3, List<String> list4) {
        try {
            return getITelephony().setRoamingOverride(list, list2, list3, list4);
        } catch (RemoteException e) {
            Rlog.e(TAG, "setRoamingOverride RemoteException", e);
            return false;
        } catch (NullPointerException e2) {
            Rlog.e(TAG, "setRoamingOverride NPE", e2);
            return false;
        }
    }

    public void setSimCountryIso(String str) {
        setSimCountryIsoForPhone(getDefaultPhone(), str);
    }

    public void setSimCountryIsoForPhone(int i, String str) {
        setTelephonyProperty(i, TelephonyProperties.PROPERTY_ICC_OPERATOR_ISO_COUNTRY, str);
    }

    public void setSimOperatorName(String str) {
        setSimOperatorNameForPhone(getDefaultPhone(), str);
    }

    public void setSimOperatorNameForPhone(int i, String str) {
        setTelephonyProperty(i, TelephonyProperties.PROPERTY_ICC_OPERATOR_ALPHA, str);
    }

    public void setSimOperatorNumeric(String str) {
        setSimOperatorNumericForPhone(getDefaultPhone(), str);
    }

    public void setSimOperatorNumericForPhone(int i, String str) {
        setTelephonyProperty(i, TelephonyProperties.PROPERTY_ICC_OPERATOR_NUMERIC, str);
    }

    public void setSimState(String str) {
        setSimStateForPhone(getDefaultPhone(), str);
    }

    public void setSimStateForPhone(int i, String str) {
        setTelephonyProperty(i, TelephonyProperties.PROPERTY_SIM_STATE, str);
    }

    public boolean setVoiceMailNumber(int i, String str, String str2) {
        try {
            return getITelephony().setVoiceMailNumber(i, str, str2);
        } catch (RemoteException | NullPointerException e) {
            return false;
        }
    }

    public boolean setVoiceMailNumber(String str, String str2) {
        return setVoiceMailNumber(getDefaultSubscription(), str, str2);
    }

    public void silenceRinger() {
        try {
            getTelecomService().silenceRinger();
        } catch (RemoteException e) {
            Log.e(TAG, "Error calling ITelecomService#silenceRinger", e);
        }
    }

    public boolean supplyPin(String str) {
        try {
            return getITelephony().supplyPin(str);
        } catch (RemoteException e) {
            Log.e(TAG, "Error calling ITelephony#supplyPin", e);
            return false;
        }
    }

    public int[] supplyPinReportResult(String str) {
        try {
            return getITelephony().supplyPinReportResult(str);
        } catch (RemoteException e) {
            Log.e(TAG, "Error calling ITelephony#supplyPinReportResult", e);
            return new int[0];
        }
    }

    public boolean supplyPuk(String str, String str2) {
        try {
            return getITelephony().supplyPuk(str, str2);
        } catch (RemoteException e) {
            Log.e(TAG, "Error calling ITelephony#supplyPuk", e);
            return false;
        }
    }

    public int[] supplyPukReportResult(String str, String str2) {
        try {
            return getITelephony().supplyPukReportResult(str, str2);
        } catch (RemoteException e) {
            Log.e(TAG, "Error calling ITelephony#]", e);
            return new int[0];
        }
    }

    public void toggleLTE(boolean z) {
        try {
            getITelephony().toggleLTE(z);
        } catch (RemoteException e) {
        }
    }

    public void toggleRadioOnOff() {
        try {
            getITelephony().toggleRadioOnOff();
        } catch (RemoteException e) {
            Log.e(TAG, "Error calling ITelephony#toggleRadioOnOff", e);
        }
    }

    public void updateServiceLocation() {
        try {
            getITelephony().updateServiceLocation();
        } catch (RemoteException e) {
            Log.e(TAG, "Error calling ITelephony#updateServiceLocation", e);
        }
    }
}
