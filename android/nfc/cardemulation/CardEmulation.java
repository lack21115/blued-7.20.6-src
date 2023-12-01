package android.nfc.cardemulation;

import android.app.Activity;
import android.app.ActivityThread;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.IPackageManager;
import android.nfc.INfcCardEmulation;
import android.nfc.NfcAdapter;
import android.os.RemoteException;
import android.os.UserHandle;
import android.provider.Settings;
import android.util.Log;
import com.android.internal.telephony.PhoneConstants;
import java.util.HashMap;
import java.util.List;

/* loaded from: source-9557208-dex2jar.jar:android/nfc/cardemulation/CardEmulation.class */
public final class CardEmulation {
    public static final String ACTION_CHANGE_DEFAULT = "android.nfc.cardemulation.action.ACTION_CHANGE_DEFAULT";
    public static final String CATEGORY_OTHER = "other";
    public static final String CATEGORY_PAYMENT = "payment";
    public static final String EXTRA_CATEGORY = "category";
    public static final String EXTRA_SERVICE_COMPONENT = "component";
    public static final int SELECTION_MODE_ALWAYS_ASK = 1;
    public static final int SELECTION_MODE_ASK_IF_CONFLICT = 2;
    public static final int SELECTION_MODE_PREFER_DEFAULT = 0;
    static final String TAG = "CardEmulation";
    static INfcCardEmulation sService;
    final Context mContext;
    static boolean sIsInitialized = false;
    static HashMap<Context, CardEmulation> sCardEmus = new HashMap<>();

    private CardEmulation(Context context, INfcCardEmulation iNfcCardEmulation) {
        this.mContext = context.getApplicationContext();
        sService = iNfcCardEmulation;
    }

    public static CardEmulation getInstance(NfcAdapter nfcAdapter) {
        CardEmulation cardEmulation;
        synchronized (CardEmulation.class) {
            try {
                if (nfcAdapter == null) {
                    throw new NullPointerException("NfcAdapter is null");
                }
                Context context = nfcAdapter.getContext();
                if (context == null) {
                    Log.e(TAG, "NfcAdapter context is null.");
                    throw new UnsupportedOperationException();
                }
                if (!sIsInitialized) {
                    IPackageManager packageManager = ActivityThread.getPackageManager();
                    if (packageManager == null) {
                        Log.e(TAG, "Cannot get PackageManager");
                        throw new UnsupportedOperationException();
                    }
                    try {
                        if (!packageManager.hasSystemFeature("android.hardware.nfc.hce")) {
                            Log.e(TAG, "This device does not support card emulation");
                            throw new UnsupportedOperationException();
                        }
                        sIsInitialized = true;
                    } catch (RemoteException e) {
                        Log.e(TAG, "PackageManager query failed.");
                        throw new UnsupportedOperationException();
                    }
                }
                CardEmulation cardEmulation2 = sCardEmus.get(context);
                cardEmulation = cardEmulation2;
                if (cardEmulation2 == null) {
                    INfcCardEmulation cardEmulationService = nfcAdapter.getCardEmulationService();
                    if (cardEmulationService == null) {
                        Log.e(TAG, "This device does not implement the INfcCardEmulation interface.");
                        throw new UnsupportedOperationException();
                    }
                    cardEmulation = new CardEmulation(context, cardEmulationService);
                    sCardEmus.put(context, cardEmulation);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cardEmulation;
    }

    public static boolean isValidAid(String str) {
        if (str == null) {
            return false;
        }
        if (str.endsWith(PhoneConstants.APN_TYPE_ALL) && str.length() % 2 == 0) {
            Log.e(TAG, "AID " + str + " is not a valid AID.");
            return false;
        } else if (!str.endsWith(PhoneConstants.APN_TYPE_ALL) && str.length() % 2 != 0) {
            Log.e(TAG, "AID " + str + " is not a valid AID.");
            return false;
        } else if (str.matches("[0-9A-Fa-f]{10,32}\\*?")) {
            return true;
        } else {
            Log.e(TAG, "AID " + str + " is not a valid AID.");
            return false;
        }
    }

    public boolean categoryAllowsForegroundPreference(String str) {
        if (CATEGORY_PAYMENT.equals(str)) {
            try {
                return Settings.Secure.getInt(this.mContext.getContentResolver(), Settings.Secure.NFC_PAYMENT_FOREGROUND) != 0;
            } catch (Settings.SettingNotFoundException e) {
                return false;
            }
        }
        return true;
    }

    public List<String> getAidsForService(ComponentName componentName, String str) {
        List<String> list;
        try {
            AidGroup aidGroupForService = sService.getAidGroupForService(UserHandle.myUserId(), componentName, str);
            list = null;
            if (aidGroupForService != null) {
                list = aidGroupForService.getAids();
            }
        } catch (RemoteException e) {
            recoverService();
            if (sService == null) {
                Log.e(TAG, "Failed to recover CardEmulationService.");
                return null;
            }
            try {
                AidGroup aidGroupForService2 = sService.getAidGroupForService(UserHandle.myUserId(), componentName, str);
                list = null;
                if (aidGroupForService2 != null) {
                    return aidGroupForService2.getAids();
                }
            } catch (RemoteException e2) {
                Log.e(TAG, "Failed to recover CardEmulationService.");
                return null;
            }
        }
        return list;
    }

    public int getSelectionModeForCategory(String str) {
        if (CATEGORY_PAYMENT.equals(str)) {
            return Settings.Secure.getString(this.mContext.getContentResolver(), Settings.Secure.NFC_PAYMENT_DEFAULT_COMPONENT) != null ? 0 : 1;
        }
        return 2;
    }

    public List<ApduServiceInfo> getServices(String str) {
        try {
            return sService.getServices(UserHandle.myUserId(), str);
        } catch (RemoteException e) {
            recoverService();
            if (sService == null) {
                Log.e(TAG, "Failed to recover CardEmulationService.");
                return null;
            }
            try {
                return sService.getServices(UserHandle.myUserId(), str);
            } catch (RemoteException e2) {
                Log.e(TAG, "Failed to reach CardEmulationService.");
                return null;
            }
        }
    }

    public boolean isDefaultServiceForAid(ComponentName componentName, String str) {
        try {
            return sService.isDefaultServiceForAid(UserHandle.myUserId(), componentName, str);
        } catch (RemoteException e) {
            recoverService();
            if (sService == null) {
                Log.e(TAG, "Failed to recover CardEmulationService.");
                return false;
            }
            try {
                return sService.isDefaultServiceForAid(UserHandle.myUserId(), componentName, str);
            } catch (RemoteException e2) {
                Log.e(TAG, "Failed to reach CardEmulationService.");
                return false;
            }
        }
    }

    public boolean isDefaultServiceForCategory(ComponentName componentName, String str) {
        try {
            return sService.isDefaultServiceForCategory(UserHandle.myUserId(), componentName, str);
        } catch (RemoteException e) {
            recoverService();
            if (sService == null) {
                Log.e(TAG, "Failed to recover CardEmulationService.");
                return false;
            }
            try {
                return sService.isDefaultServiceForCategory(UserHandle.myUserId(), componentName, str);
            } catch (RemoteException e2) {
                Log.e(TAG, "Failed to recover CardEmulationService.");
                return false;
            }
        }
    }

    void recoverService() {
        sService = NfcAdapter.getDefaultAdapter(this.mContext).getCardEmulationService();
    }

    public boolean registerAidsForService(ComponentName componentName, String str, List<String> list) {
        AidGroup aidGroup = new AidGroup(list, str);
        try {
            return sService.registerAidGroupForService(UserHandle.myUserId(), componentName, aidGroup);
        } catch (RemoteException e) {
            recoverService();
            if (sService == null) {
                Log.e(TAG, "Failed to recover CardEmulationService.");
                return false;
            }
            try {
                return sService.registerAidGroupForService(UserHandle.myUserId(), componentName, aidGroup);
            } catch (RemoteException e2) {
                Log.e(TAG, "Failed to reach CardEmulationService.");
                return false;
            }
        }
    }

    public boolean removeAidsForService(ComponentName componentName, String str) {
        try {
            return sService.removeAidGroupForService(UserHandle.myUserId(), componentName, str);
        } catch (RemoteException e) {
            recoverService();
            if (sService == null) {
                Log.e(TAG, "Failed to recover CardEmulationService.");
                return false;
            }
            try {
                return sService.removeAidGroupForService(UserHandle.myUserId(), componentName, str);
            } catch (RemoteException e2) {
                Log.e(TAG, "Failed to reach CardEmulationService.");
                return false;
            }
        }
    }

    public boolean setDefaultForNextTap(ComponentName componentName) {
        try {
            return sService.setDefaultForNextTap(UserHandle.myUserId(), componentName);
        } catch (RemoteException e) {
            recoverService();
            if (sService == null) {
                Log.e(TAG, "Failed to recover CardEmulationService.");
                return false;
            }
            try {
                return sService.setDefaultForNextTap(UserHandle.myUserId(), componentName);
            } catch (RemoteException e2) {
                Log.e(TAG, "Failed to reach CardEmulationService.");
                return false;
            }
        }
    }

    public boolean setDefaultServiceForCategory(ComponentName componentName, String str) {
        try {
            return sService.setDefaultServiceForCategory(UserHandle.myUserId(), componentName, str);
        } catch (RemoteException e) {
            recoverService();
            if (sService == null) {
                Log.e(TAG, "Failed to recover CardEmulationService.");
                return false;
            }
            try {
                return sService.setDefaultServiceForCategory(UserHandle.myUserId(), componentName, str);
            } catch (RemoteException e2) {
                Log.e(TAG, "Failed to reach CardEmulationService.");
                return false;
            }
        }
    }

    public boolean setPreferredService(Activity activity, ComponentName componentName) {
        if (activity == null || componentName == null) {
            throw new NullPointerException("activity or service or category is null");
        }
        if (activity.isResumed()) {
            try {
                return sService.setPreferredService(componentName);
            } catch (RemoteException e) {
                recoverService();
                if (sService == null) {
                    Log.e(TAG, "Failed to recover CardEmulationService.");
                    return false;
                }
                try {
                    return sService.setPreferredService(componentName);
                } catch (RemoteException e2) {
                    Log.e(TAG, "Failed to reach CardEmulationService.");
                    return false;
                }
            }
        }
        throw new IllegalArgumentException("Activity must be resumed.");
    }

    public boolean supportsAidPrefixRegistration() {
        try {
            return sService.supportsAidPrefixRegistration();
        } catch (RemoteException e) {
            recoverService();
            if (sService == null) {
                Log.e(TAG, "Failed to recover CardEmulationService.");
                return false;
            }
            try {
                return sService.supportsAidPrefixRegistration();
            } catch (RemoteException e2) {
                Log.e(TAG, "Failed to reach CardEmulationService.");
                return false;
            }
        }
    }

    public boolean unsetPreferredService(Activity activity) {
        if (activity == null) {
            throw new NullPointerException("activity is null");
        }
        if (activity.isResumed()) {
            try {
                return sService.unsetPreferredService();
            } catch (RemoteException e) {
                recoverService();
                if (sService == null) {
                    Log.e(TAG, "Failed to recover CardEmulationService.");
                    return false;
                }
                try {
                    return sService.unsetPreferredService();
                } catch (RemoteException e2) {
                    Log.e(TAG, "Failed to reach CardEmulationService.");
                    return false;
                }
            }
        }
        throw new IllegalArgumentException("Activity must be resumed.");
    }
}
