package com.android.internal.widget;

import android.Manifest;
import android.app.ActivityManagerNative;
import android.app.AlarmManager;
import android.app.admin.DevicePolicyManager;
import android.app.trust.TrustManager;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.UserInfo;
import android.gesture.Gesture;
import android.os.AsyncTask;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.SystemClock;
import android.os.SystemProperties;
import android.os.UserHandle;
import android.os.UserManager;
import android.os.storage.IMountService;
import android.os.storage.StorageManager;
import android.provider.Settings;
import android.support.v4.media.session.PlaybackStateCompat;
import android.telecom.TelecomManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.IWindowManager;
import android.widget.Button;
import com.android.internal.R;
import com.android.internal.widget.ILockSettings;
import com.android.internal.widget.LockPatternView;
import com.google.android.collect.Lists;
import java.lang.reflect.Array;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: source-4181928-dex2jar.jar:com/android/internal/widget/LockPatternUtils.class */
public class LockPatternUtils {
    public static final String BIOMETRIC_WEAK_EVER_CHOSEN_KEY = "lockscreen.biometricweakeverchosen";
    public static final int BIOMETRIC_WEAK_FACE = 0;
    public static final int BIOMETRIC_WEAK_FINGERPRINT = 1;
    public static final int BIOMETRIC_WEAK_UNKNOWN = -1;
    private static final boolean DEBUG = false;
    public static final String DISABLE_LOCKSCREEN_KEY = "lockscreen.disabled";
    private static final String ENABLED_TRUST_AGENTS = "lockscreen.enabledtrustagents";
    public static final int FAILED_ATTEMPTS_BEFORE_RESET = 20;
    public static final int FAILED_ATTEMPTS_BEFORE_TIMEOUT = 5;
    public static final int FAILED_ATTEMPTS_BEFORE_WIPE_GRACE = 5;
    public static final long FAILED_ATTEMPT_COUNTDOWN_INTERVAL_MS = 1000;
    public static final long FAILED_ATTEMPT_TIMEOUT_MS = 30000;
    public static final int FLAG_BIOMETRIC_WEAK_LIVELINESS = 1;
    public static final String GESTURE_EVER_CHOSEN_KEY = "lockscreen.gestureeverchosen";
    public static final int ID_DEFAULT_STATUS_WIDGET = -2;
    public static final String KEYGUARD_SHOW_APPWIDGET = "showappwidget";
    public static final String KEYGUARD_SHOW_SECURITY_CHALLENGE = "showsecuritychallenge";
    public static final String KEYGUARD_SHOW_USER_SWITCHER = "showuserswitcher";
    public static final String LOCKOUT_ATTEMPT_DEADLINE = "lockscreen.lockoutattemptdeadline";
    public static final String LOCKOUT_PERMANENT_KEY = "lockscreen.lockedoutpermanently";
    public static final String LOCKSCREEN_BIOMETRIC_WEAK_FALLBACK = "lockscreen.biometric_weak_fallback";
    public static final String LOCKSCREEN_FINGERPRINT_FALLBACK = "lockscreen.fingerprint_fallback";
    public static final String LOCKSCREEN_OPTIONS = "lockscreen.options";
    public static final String LOCKSCREEN_POWER_BUTTON_INSTANTLY_LOCKS = "lockscreen.power_button_instantly_locks";
    public static final String LOCKSCREEN_WIDGETS_ENABLED = "lockscreen.widgets_enabled";
    public static final String LOCK_PASSWORD_SALT_KEY = "lockscreen.password_salt";
    private static final String LOCK_SCREEN_OWNER_INFO = "lock_screen_owner_info";
    private static final String LOCK_SCREEN_OWNER_INFO_ENABLED = "lock_screen_owner_info_enabled";
    public static final int MAX_ALLOWED_SEQUENCE = 3;
    public static final int MIN_LOCK_PATTERN_SIZE = 4;
    public static final int MIN_PATTERN_REGISTER_FAIL = 4;
    public static final String PASSWORD_BIOMETRIC_EXACT_TYPE = "lockscreen.password_biometric_type";
    public static final String PASSWORD_HISTORY_KEY = "lockscreen.passwordhistory";
    public static final String PASSWORD_TYPE_ALTERNATE_KEY = "lockscreen.password_type_alternate";
    public static final String PASSWORD_TYPE_KEY = "lockscreen.password_type";
    public static final String PATTERN_EVER_CHOSEN_KEY = "lockscreen.patterneverchosen";
    public static final byte PATTERN_SIZE_DEFAULT = 3;
    private static final String TAG = "LockPatternUtils";
    public static final String THIRD_PARTY_KEYGUARD_COMPONENT = "lockscreen.third_party";
    private static volatile int sCurrentUserId = -10000;
    private final ContentResolver mContentResolver;
    private final Context mContext;
    private DevicePolicyManager mDevicePolicyManager;
    private ILockSettings mLockSettingsService;
    private final boolean mMultiUserMode;

    public LockPatternUtils(Context context) {
        this.mContext = context;
        this.mContentResolver = context.getContentResolver();
        this.mMultiUserMode = context.checkCallingOrSelfPermission(Manifest.permission.INTERACT_ACROSS_USERS_FULL) == 0;
    }

    private static int categoryChar(char c2) {
        if ('a' > c2 || c2 > 'z') {
            if ('A' > c2 || c2 > 'Z') {
                return ('0' > c2 || c2 > '9') ? 3 : 2;
            }
            return 1;
        }
        return 0;
    }

    private static String combineStrings(int[] iArr, String str) {
        int length = iArr.length;
        switch (length) {
            case 0:
                return "";
            case 1:
                return Integer.toString(iArr[0]);
            default:
                int i = 0;
                int length2 = str.length();
                String[] strArr = new String[iArr.length];
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 < length) {
                        strArr[i3] = Integer.toString(iArr[i3]);
                        int length3 = i + strArr[i3].length();
                        i = length3;
                        if (i3 < length - 1) {
                            i = length3 + length2;
                        }
                        i2 = i3 + 1;
                    } else {
                        StringBuilder sb = new StringBuilder(i);
                        int i4 = 0;
                        while (true) {
                            int i5 = i4;
                            if (i5 >= length) {
                                return sb.toString();
                            }
                            sb.append(iArr[i5]);
                            if (i5 < length - 1) {
                                sb.append(str);
                            }
                            i4 = i5 + 1;
                        }
                    }
                }
        }
    }

    public static int computePasswordQuality(String str) {
        boolean z = false;
        boolean z2 = false;
        int length = str.length();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                break;
            }
            if (Character.isDigit(str.charAt(i2))) {
                z = true;
            } else {
                z2 = true;
            }
            i = i2 + 1;
        }
        if (z2 && z) {
            return 327680;
        }
        if (z2) {
            return 262144;
        }
        if (z) {
            return maxLengthSequence(str) > 3 ? 131072 : 196608;
        }
        return 0;
    }

    private void finishBiometricWeak(int i) {
        setBoolean(BIOMETRIC_WEAK_EVER_CHOSEN_KEY, true, i);
        Intent intent = new Intent();
        intent.setClassName("com.android.facelock", "com.android.facelock.SetupEndScreen");
        this.mContext.startActivityAsUser(intent, new UserHandle(i));
    }

    private int[] getAppWidgets(int i) {
        int[] iArr;
        String stringForUser = Settings.Secure.getStringForUser(this.mContentResolver, Settings.Secure.LOCK_SCREEN_APPWIDGET_IDS, i);
        if (stringForUser == null || stringForUser.length() <= 0) {
            return new int[0];
        }
        String[] split = stringForUser.split(",");
        int[] iArr2 = new int[split.length];
        int i2 = 0;
        while (true) {
            int i3 = i2;
            iArr = iArr2;
            if (i3 >= split.length) {
                break;
            }
            String str = split[i3];
            try {
                iArr2[i3] = Integer.decode(str).intValue();
                i2 = i3 + 1;
            } catch (NumberFormatException e) {
                Log.d(TAG, "Error when parsing widget id " + str);
                iArr = null;
            }
        }
        return iArr;
    }

    private boolean getBoolean(String str, boolean z) {
        return getBoolean(str, z, getCurrentOrCallingUserId());
    }

    private boolean getBoolean(String str, boolean z, int i) {
        try {
            return getLockSettings().getBoolean(str, z, i);
        } catch (RemoteException e) {
            return z;
        }
    }

    private int getCurrentOrCallingUserId() {
        return this.mMultiUserMode ? getCurrentUser() : UserHandle.getCallingUserId();
    }

    private ILockSettings getLockSettings() {
        if (this.mLockSettingsService == null) {
            this.mLockSettingsService = ILockSettings.Stub.asInterface(ServiceManager.getService("lock_settings"));
        }
        return this.mLockSettingsService;
    }

    private long getLong(String str, long j) {
        try {
            return getLockSettings().getLong(str, j, getCurrentOrCallingUserId());
        } catch (RemoteException e) {
            return j;
        }
    }

    private long getLong(String str, long j, int i) {
        try {
            return getLockSettings().getLong(str, j, i);
        } catch (RemoteException e) {
            return j;
        }
    }

    private String getSalt(int i) {
        long j = getLong(LOCK_PASSWORD_SALT_KEY, 0L, i);
        long j2 = j;
        if (j == 0) {
            try {
                j2 = SecureRandom.getInstance("SHA1PRNG").nextLong();
                setLong(LOCK_PASSWORD_SALT_KEY, j2, i);
                Log.v(TAG, "Initialized lock password salt for user: " + i);
            } catch (NoSuchAlgorithmException e) {
                throw new IllegalStateException("Couldn't get SecureRandom number", e);
            }
        }
        return Long.toHexString(j2);
    }

    private String getString(String str) {
        return getString(str, getCurrentOrCallingUserId());
    }

    private String getString(String str, int i) {
        try {
            return getLockSettings().getString(str, null, i);
        } catch (RemoteException e) {
            return null;
        }
    }

    private TelecomManager getTelecommManager() {
        return (TelecomManager) this.mContext.getSystemService("telecom");
    }

    private TrustManager getTrustManager() {
        TrustManager trustManager = (TrustManager) this.mContext.getSystemService(Context.TRUST_SERVICE);
        if (trustManager == null) {
            Log.e(TAG, "Can't get TrustManagerService: is it running?", new IllegalStateException("Stack trace:"));
        }
        return trustManager;
    }

    public static boolean isDeviceEncrypted() {
        IMountService asInterface = IMountService.Stub.asInterface(ServiceManager.getService("mount"));
        try {
            if (asInterface.getEncryptionState() != 1) {
                return asInterface.getPasswordType() != 1;
            }
            return false;
        } catch (RemoteException e) {
            Log.e(TAG, "Error getting encryption state", e);
            return true;
        }
    }

    public static boolean isDeviceEncryptionEnabled() {
        return "encrypted".equalsIgnoreCase(SystemProperties.get("ro.crypto.state", "unsupported"));
    }

    public static boolean isSafeModeEnabled() {
        try {
            return IWindowManager.Stub.asInterface(ServiceManager.getService(Context.WINDOW_SERVICE)).isSafeModeEnabled();
        } catch (RemoteException e) {
            return false;
        }
    }

    private static int maxDiffCategory(int i) {
        if (i == 0 || i == 1) {
            return 1;
        }
        return i == 2 ? 10 : 0;
    }

    public static int maxLengthSequence(String str) {
        if (str.length() == 0) {
            return 0;
        }
        char charAt = str.charAt(0);
        int categoryChar = categoryChar(charAt);
        int i = 0;
        boolean z = false;
        int i2 = 0;
        int i3 = 0;
        char c2 = charAt;
        for (int i4 = 1; i4 < str.length(); i4++) {
            char charAt2 = str.charAt(i4);
            int categoryChar2 = categoryChar(charAt2);
            int i5 = charAt2 - c2;
            if (categoryChar2 != categoryChar || Math.abs(i5) > maxDiffCategory(categoryChar)) {
                i2 = Math.max(i2, i4 - i3);
                i3 = i4;
                z = false;
                categoryChar = categoryChar2;
            } else {
                int i6 = i2;
                int i7 = i3;
                if (z) {
                    i6 = i2;
                    i7 = i3;
                    if (i5 != i) {
                        i6 = Math.max(i2, i4 - i3);
                        i7 = i4 - 1;
                    }
                }
                i = i5;
                z = true;
                i2 = i6;
                i3 = i7;
            }
            c2 = charAt2;
        }
        return Math.max(i2, str.length() - i3);
    }

    private void onAfterChangingPassword(int i) {
        getTrustManager().reportEnabledTrustAgentsChanged(i);
    }

    public static boolean patternMatches(List<LockPatternView.Cell> list, List<LockPatternView.Cell> list2) {
        if (list == null || list2 == null || list.size() != list2.size()) {
            return false;
        }
        int size = (byte) list.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return true;
            }
            if (!list.get(i2).equals(list2.get(i2))) {
                return false;
            }
            i = i2 + 1;
        }
    }

    public static String patternToString(List<LockPatternView.Cell> list, int i) {
        if (list == null) {
            return "";
        }
        int size = list.size();
        byte[] bArr = new byte[size];
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= size) {
                return new String(bArr);
            }
            LockPatternView.Cell cell = list.get(i3);
            bArr[i3] = (byte) ((cell.getRow() * i) + cell.getColumn());
            i2 = i3 + 1;
        }
    }

    private void setBoolean(String str, boolean z) {
        setBoolean(str, z, getCurrentOrCallingUserId());
    }

    private void setBoolean(String str, boolean z, int i) {
        try {
            getLockSettings().setBoolean(str, z, i);
        } catch (RemoteException e) {
            Log.e(TAG, "Couldn't write boolean " + str + e);
        }
    }

    private void setLong(String str, long j) {
        setLong(str, j, getCurrentOrCallingUserId());
    }

    private void setLong(String str, long j, int i) {
        try {
            getLockSettings().setLong(str, j, i);
        } catch (RemoteException e) {
            Log.e(TAG, "Couldn't write long " + str + e);
        }
    }

    private void setString(String str, String str2) {
        setString(str, str2, getCurrentOrCallingUserId());
    }

    private void setString(String str, String str2, int i) {
        try {
            getLockSettings().setString(str, str2, i);
        } catch (RemoteException e) {
            Log.e(TAG, "Couldn't write string " + str + e);
        }
    }

    public static List<LockPatternView.Cell> stringToPattern(String str, byte b) {
        ArrayList newArrayList = Lists.newArrayList();
        LockPatternView.Cell[][] cellArr = (LockPatternView.Cell[][]) Array.newInstance(LockPatternView.Cell.class, b, b);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= b) {
                break;
            }
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 < b) {
                    cellArr[i2][i4] = new LockPatternView.Cell(i2, i4, b);
                    i3 = i4 + 1;
                }
            }
            i = i2 + 1;
        }
        byte[] bytes = str.getBytes();
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 >= bytes.length) {
                return newArrayList;
            }
            byte b2 = bytes[i6];
            newArrayList.add(LockPatternView.Cell.of(cellArr, b2 / b, b2 % b, b));
            i5 = i6 + 1;
        }
    }

    private static String toHex(byte[] bArr) {
        String str = "";
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= bArr.length) {
                return str;
            }
            str = (str + "0123456789ABCDEF".charAt((bArr[i2] >> 4) & 15)) + "0123456789ABCDEF".charAt(bArr[i2] & 15);
            i = i2 + 1;
        }
    }

    private void updateCryptoUserInfo() {
        int currentOrCallingUserId = getCurrentOrCallingUserId();
        if (currentOrCallingUserId != 0) {
            return;
        }
        String ownerInfo = isOwnerInfoEnabled() ? getOwnerInfo(currentOrCallingUserId) : "";
        IBinder service = ServiceManager.getService("mount");
        if (service == null) {
            Log.e(TAG, "Could not find the mount service to update the user info");
            return;
        }
        IMountService asInterface = IMountService.Stub.asInterface(service);
        try {
            Log.d(TAG, "Setting owner info");
            asInterface.setField(StorageManager.OWNER_INFO_KEY, ownerInfo);
        } catch (RemoteException e) {
            Log.e(TAG, "Error changing user info", e);
        }
    }

    private void updateEncryptionPassword(final int i, final String str) {
        if (isDeviceEncryptionEnabled()) {
            final IBinder service = ServiceManager.getService("mount");
            if (service == null) {
                Log.e(TAG, "Could not find the mount service to update the encryption password");
            } else {
                new AsyncTask<Void, Void, Void>() { // from class: com.android.internal.widget.LockPatternUtils.1
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // android.os.AsyncTask
                    public Void doInBackground(Void... voidArr) {
                        try {
                            IMountService.Stub.asInterface(service).changeEncryptionPassword(i, str);
                            return null;
                        } catch (RemoteException e) {
                            Log.e(LockPatternUtils.TAG, "Error changing encryption password", e);
                            return null;
                        }
                    }
                }.execute(new Void[0]);
            }
        }
    }

    private void writeAppWidgets(int[] iArr) {
        Settings.Secure.putStringForUser(this.mContentResolver, Settings.Secure.LOCK_SCREEN_APPWIDGET_IDS, combineStrings(iArr, ","), -2);
    }

    public boolean addAppWidget(int i, int i2) {
        int[] appWidgets = getAppWidgets();
        if (appWidgets == null || i2 < 0 || i2 > appWidgets.length) {
            return false;
        }
        int[] iArr = new int[appWidgets.length + 1];
        int i3 = 0;
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i3 >= iArr.length) {
                writeAppWidgets(iArr);
                return true;
            }
            int i6 = i3;
            if (i2 == i3) {
                iArr[i3] = i;
                i6 = i3 + 1;
            }
            int i7 = i5;
            if (i6 < iArr.length) {
                iArr[i6] = appWidgets[i5];
                i7 = i5 + 1;
            }
            i3 = i6 + 1;
            i4 = i7;
        }
    }

    public boolean checkGesture(Gesture gesture) {
        int currentOrCallingUserId = getCurrentOrCallingUserId();
        try {
            boolean checkGesture = getLockSettings().checkGesture(gesture, currentOrCallingUserId);
            if (!checkGesture || currentOrCallingUserId == 0) {
            }
            return checkGesture;
        } catch (RemoteException e) {
            return true;
        }
    }

    public boolean checkPassword(String str) {
        try {
            return getLockSettings().checkPassword(str, getCurrentOrCallingUserId());
        } catch (RemoteException e) {
            return true;
        }
    }

    public boolean checkPasswordHistory(String str) {
        String str2 = new String(passwordToHash(str, getCurrentOrCallingUserId()));
        String string = getString(PASSWORD_HISTORY_KEY);
        if (string == null) {
            return false;
        }
        int length = str2.length();
        int requestedPasswordHistoryLength = getRequestedPasswordHistoryLength();
        if (requestedPasswordHistoryLength != 0) {
            int i = ((length * requestedPasswordHistoryLength) + requestedPasswordHistoryLength) - 1;
            String str3 = string;
            if (string.length() > i) {
                str3 = string.substring(0, i);
            }
            return str3.contains(str2);
        }
        return false;
    }

    public boolean checkPattern(List<LockPatternView.Cell> list) {
        try {
            return getLockSettings().checkPattern(patternToString(list), getCurrentOrCallingUserId());
        } catch (RemoteException e) {
            return true;
        }
    }

    public boolean checkVoldPassword() {
        try {
            return getLockSettings().checkVoldPassword(getCurrentOrCallingUserId());
        } catch (RemoteException e) {
            return false;
        }
    }

    public void clearEncryptionPassword() {
        updateEncryptionPassword(1, null);
    }

    public void clearLock(boolean z) {
        clearLock(z, getCurrentOrCallingUserId());
    }

    public void clearLock(boolean z, int i) {
        if (!z) {
            deleteGallery(i);
        }
        saveLockPassword(null, 65536, z, false, i);
        setLockPatternEnabled(false, i);
        saveLockPattern(null, z, false, i);
        setLockGestureEnabled(false, i);
        saveLockGesture(null, z, i);
        setLong(PASSWORD_TYPE_KEY, 0L, i);
        setLong(PASSWORD_TYPE_ALTERNATE_KEY, 0L, i);
        onAfterChangingPassword(i);
    }

    void deleteGallery(int i) {
        if (usingBiometricWeak(i)) {
            Intent action = new Intent().setAction("com.android.facelock.DELETE_GALLERY");
            action.putExtra("deleteGallery", true);
            this.mContext.sendBroadcastAsUser(action, new UserHandle(i));
        }
    }

    public void deleteTempGallery() {
        Intent action = new Intent().setAction("com.android.facelock.DELETE_GALLERY");
        action.putExtra("deleteTempGallery", true);
        this.mContext.sendBroadcast(action);
    }

    public int getActivePasswordQuality() {
        switch ((int) getLong(PASSWORD_TYPE_KEY, 65536L)) {
            case 2048:
                return isThirdPartyKeyguardEnabled() ? 2048 : 0;
            case 32768:
                return isBiometricWeakInstalled() ? 32768 : 0;
            case 65536:
                return isLockPatternEnabled() ? 65536 : 0;
            case 131072:
                return isLockPasswordEnabled() ? 131072 : 0;
            case 196608:
                return isLockPasswordEnabled() ? 196608 : 0;
            case 262144:
                return isLockPasswordEnabled() ? 262144 : 0;
            case 327680:
                return isLockPasswordEnabled() ? 327680 : 0;
            case 393216:
                return isLockPasswordEnabled() ? 393216 : 0;
            case 524288:
                return isLockGestureEnabled() ? 524288 : 0;
            default:
                return 0;
        }
    }

    public int[] getAppWidgets() {
        return getAppWidgets(-2);
    }

    public int getCurrentUser() {
        if (sCurrentUserId != -10000) {
            return sCurrentUserId;
        }
        try {
            return ActivityManagerNative.getDefault().getCurrentUser().id;
        } catch (RemoteException e) {
            return 0;
        }
    }

    public DevicePolicyManager getDevicePolicyManager() {
        if (this.mDevicePolicyManager == null) {
            this.mDevicePolicyManager = (DevicePolicyManager) this.mContext.getSystemService(Context.DEVICE_POLICY_SERVICE);
            if (this.mDevicePolicyManager == null) {
                Log.e(TAG, "Can't get DevicePolicyManagerService: is it running?", new IllegalStateException("Stack trace:"));
            }
        }
        return this.mDevicePolicyManager;
    }

    public List<ComponentName> getEnabledTrustAgents() {
        return getEnabledTrustAgents(getCurrentOrCallingUserId());
    }

    public List<ComponentName> getEnabledTrustAgents(int i) {
        ArrayList arrayList;
        String string = getString(ENABLED_TRUST_AGENTS, i);
        if (!TextUtils.isEmpty(string)) {
            String[] split = string.split(",");
            ArrayList arrayList2 = new ArrayList(split.length);
            int length = split.length;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                arrayList = arrayList2;
                if (i3 >= length) {
                    break;
                }
                String str = split[i3];
                if (!TextUtils.isEmpty(str)) {
                    arrayList2.add(ComponentName.unflattenFromString(str));
                }
                i2 = i3 + 1;
            }
        } else {
            arrayList = null;
        }
        return arrayList;
    }

    public int getFallbackAppWidgetId() {
        return Settings.Secure.getIntForUser(this.mContentResolver, Settings.Secure.LOCK_SCREEN_FALLBACK_APPWIDGET_ID, 0, -2);
    }

    public int getKeyguardStoredPasswordQuality() {
        return getKeyguardStoredPasswordQuality(getCurrentOrCallingUserId());
    }

    public int getKeyguardStoredPasswordQuality(int i) {
        int i2 = (int) getLong(PASSWORD_TYPE_KEY, 0L, i);
        int i3 = i2;
        if (i2 == 32768) {
            i3 = (int) getLong(PASSWORD_TYPE_ALTERNATE_KEY, 0L, i);
        }
        return i3;
    }

    public byte getLockPatternSize() {
        long j = getLong(Settings.Secure.LOCK_PATTERN_SIZE, -1L);
        if (j <= 0 || j >= 128) {
            return (byte) 3;
        }
        return (byte) j;
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x001e, code lost:
        if (r0 > (30000 + r0)) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long getLockoutAttemptDeadline() {
        /*
            r7 = this;
            r0 = r7
            java.lang.String r1 = "lockscreen.lockoutattemptdeadline"
            r2 = 0
            long r0 = r0.getLong(r1, r2)
            r10 = r0
            long r0 = android.os.SystemClock.elapsedRealtime()
            r12 = r0
            r0 = r10
            r1 = r12
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 < 0) goto L21
            r0 = r10
            r8 = r0
            r0 = r10
            r1 = 30000(0x7530, double:1.4822E-319)
            r2 = r12
            long r1 = r1 + r2
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 <= 0) goto L23
        L21:
            r0 = 0
            r8 = r0
        L23:
            r0 = r8
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.internal.widget.LockPatternUtils.getLockoutAttemptDeadline():long");
    }

    public AlarmManager.AlarmClockInfo getNextAlarm() {
        return ((AlarmManager) this.mContext.getSystemService("alarm")).getNextAlarmClock(-2);
    }

    public String getOwnerInfo(int i) {
        return getString("lock_screen_owner_info");
    }

    public boolean getPowerButtonInstantlyLocks() {
        return getBoolean(LOCKSCREEN_POWER_BUTTON_INSTANTLY_LOCKS, true);
    }

    public int getRequestedMinimumPasswordLength() {
        return getDevicePolicyManager().getPasswordMinimumLength(null, getCurrentOrCallingUserId());
    }

    public int getRequestedPasswordHistoryLength() {
        return getDevicePolicyManager().getPasswordHistoryLength(null, getCurrentOrCallingUserId());
    }

    public int getRequestedPasswordMinimumLetters() {
        return getDevicePolicyManager().getPasswordMinimumLetters(null, getCurrentOrCallingUserId());
    }

    public int getRequestedPasswordMinimumLowerCase() {
        return getDevicePolicyManager().getPasswordMinimumLowerCase(null, getCurrentOrCallingUserId());
    }

    public int getRequestedPasswordMinimumNonLetter() {
        return getDevicePolicyManager().getPasswordMinimumNonLetter(null, getCurrentOrCallingUserId());
    }

    public int getRequestedPasswordMinimumNumeric() {
        return getDevicePolicyManager().getPasswordMinimumNumeric(null, getCurrentOrCallingUserId());
    }

    public int getRequestedPasswordMinimumSymbols() {
        return getDevicePolicyManager().getPasswordMinimumSymbols(null, getCurrentOrCallingUserId());
    }

    public int getRequestedPasswordMinimumUpperCase() {
        return getDevicePolicyManager().getPasswordMinimumUpperCase(null, getCurrentOrCallingUserId());
    }

    public int getRequestedPasswordQuality() {
        return getDevicePolicyManager().getPasswordQuality(null, getCurrentOrCallingUserId());
    }

    public ComponentName getThirdPartyKeyguardComponent() {
        String string = getString(THIRD_PARTY_KEYGUARD_COMPONENT);
        if (string != null) {
            return ComponentName.unflattenFromString(string);
        }
        return null;
    }

    public boolean getWidgetsEnabled() {
        return getWidgetsEnabled(getCurrentOrCallingUserId());
    }

    public boolean getWidgetsEnabled(int i) {
        return getBoolean(LOCKSCREEN_WIDGETS_ENABLED, false, i);
    }

    public boolean hasWidgetsEnabledInKeyguard(int i) {
        int[] appWidgets = getAppWidgets(i);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= appWidgets.length) {
                return false;
            }
            if (appWidgets[i3] > 0) {
                return true;
            }
            i2 = i3 + 1;
        }
    }

    public boolean isBiometricWeakEverChosen() {
        return getBoolean(BIOMETRIC_WEAK_EVER_CHOSEN_KEY, false);
    }

    public boolean isBiometricWeakInstalled() {
        PackageManager packageManager = this.mContext.getPackageManager();
        try {
            packageManager.getPackageInfo("com.android.facelock", 1);
            return (packageManager.hasSystemFeature(PackageManager.FEATURE_CAMERA_FRONT) && getDevicePolicyManager().getCameraDisabled(null, getCurrentOrCallingUserId())) ? false : false;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }

    public boolean isBiometricWeakLivelinessEnabled() {
        return (1 & getLong(Settings.Secure.LOCK_BIOMETRIC_WEAK_FLAGS, 0L)) != 0;
    }

    public boolean isCredentialRequiredToDecrypt(boolean z) {
        int i = Settings.Global.getInt(this.mContentResolver, Settings.Global.REQUIRE_PASSWORD_TO_DECRYPT, -1);
        return i == -1 ? z : i != 0;
    }

    public boolean isEmergencyCallCapable() {
        return this.mContext.getResources().getBoolean(R.bool.config_voice_capable);
    }

    public boolean isEmergencyCallEnabledWhileSimLocked() {
        return this.mContext.getResources().getBoolean(R.bool.config_enable_emergency_call_while_sim_locked);
    }

    public boolean isFingerprintInstalled(Context context) {
        return context.getPackageManager().hasSystemFeature(PackageManager.FEATURE_FINGERPRINT);
    }

    public boolean isGestureEverChosen() {
        return getBoolean(GESTURE_EVER_CHOSEN_KEY, false);
    }

    public boolean isInCall() {
        return getTelecommManager().isInCall();
    }

    public boolean isLockGestureEnabled() {
        return isLockGestureEnabled(getCurrentOrCallingUserId());
    }

    public boolean isLockGestureEnabled(int i) {
        boolean z = getLong(PASSWORD_TYPE_ALTERNATE_KEY, PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED, i) == PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED;
        if (getBoolean(Settings.Secure.LOCK_GESTURE_ENABLED, false, i)) {
            if (getLong(PASSWORD_TYPE_KEY, PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED, i) != PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED) {
                return usingBiometricWeak(i) && z;
            }
            return true;
        }
        return false;
    }

    public boolean isLockPasswordEnabled() {
        long j = getLong(PASSWORD_TYPE_KEY, 0L);
        long j2 = getLong(PASSWORD_TYPE_ALTERNATE_KEY, 0L);
        boolean z = j == 262144 || j == 131072 || j == 196608 || j == 327680 || j == 393216;
        boolean z2 = j2 == 262144 || j2 == 131072 || j2 == 196608 || j2 == 327680 || j2 == 393216;
        if (savedPasswordExists()) {
            if (z) {
                return true;
            }
            return usingBiometricWeak() && z2;
        }
        return false;
    }

    public boolean isLockPatternEnabled() {
        return isLockPatternEnabled(getCurrentOrCallingUserId());
    }

    public boolean isLockPatternEnabled(int i) {
        boolean z = getLong(PASSWORD_TYPE_ALTERNATE_KEY, 0L, i) == 65536;
        if (getBoolean("lock_pattern_autolock", false, i)) {
            if (getLong(PASSWORD_TYPE_KEY, 0L, i) != 65536) {
                return usingBiometricWeak(i) && z;
            }
            return true;
        }
        return false;
    }

    public boolean isLockScreenDisabled() {
        if (isSecure() || getLong("lockscreen.disabled", 0L) == 0) {
            return false;
        }
        List<UserInfo> users = UserManager.get(this.mContext).getUsers(true);
        int size = users.size();
        int i = 0;
        int i2 = 0;
        while (i2 < size) {
            int i3 = i;
            if (users.get(i2).supportsSwitchTo()) {
                i3 = i + 1;
            }
            i2++;
            i = i3;
        }
        return i < 2;
    }

    public boolean isOwnerInfoEnabled() {
        return getBoolean("lock_screen_owner_info_enabled", false);
    }

    public boolean isPatternEverChosen() {
        return getBoolean(PATTERN_EVER_CHOSEN_KEY, false);
    }

    public boolean isPermanentlyLocked() {
        return getBoolean(LOCKOUT_PERMANENT_KEY, false);
    }

    public boolean isPukUnlockScreenEnable() {
        return this.mContext.getResources().getBoolean(R.bool.config_enable_puk_unlock_screen);
    }

    public boolean isSecure() {
        return isSecure(getCurrentOrCallingUserId());
    }

    public boolean isSecure(int i) {
        long keyguardStoredPasswordQuality = getKeyguardStoredPasswordQuality(i);
        boolean z = keyguardStoredPasswordQuality == 65536;
        boolean z2 = keyguardStoredPasswordQuality == PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED;
        boolean z3 = keyguardStoredPasswordQuality == 131072 || keyguardStoredPasswordQuality == 196608 || keyguardStoredPasswordQuality == 262144 || keyguardStoredPasswordQuality == 327680 || keyguardStoredPasswordQuality == 393216;
        if (z && isLockPatternEnabled(i) && savedPatternExists(i)) {
            return true;
        }
        if (z3 && savedPasswordExists(i)) {
            return true;
        }
        return z2 && isLockGestureEnabled(i) && savedGestureExists(i);
    }

    public boolean isShowErrorPath() {
        return getBoolean(Settings.Secure.LOCK_SHOW_ERROR_PATH, true);
    }

    public boolean isTactileFeedbackEnabled() {
        return Settings.System.getIntForUser(this.mContentResolver, Settings.System.HAPTIC_FEEDBACK_ENABLED, 1, -2) != 0;
    }

    public boolean isThirdPartyKeyguardEnabled() {
        return !TextUtils.isEmpty(getString(THIRD_PARTY_KEYGUARD_COMPONENT)) && getLong(PASSWORD_TYPE_KEY, 0L) == 2048;
    }

    public boolean isVisibleDotsEnabled() {
        return getBoolean(Settings.Secure.LOCK_DOTS_VISIBLE, true);
    }

    public boolean isVisibleGestureEnabled() {
        return getBoolean(Settings.Secure.LOCK_GESTURE_VISIBLE, true);
    }

    public boolean isVisiblePatternEnabled() {
        return getBoolean("lock_pattern_visible_pattern", false);
    }

    public byte[] passwordToHash(String str, int i) {
        if (str == null) {
            return null;
        }
        String str2 = null;
        try {
            byte[] bytes = (str + getSalt(i)).getBytes();
            str2 = "MD5";
            return (toHex(MessageDigest.getInstance("SHA-1").digest(bytes)) + toHex(MessageDigest.getInstance("MD5").digest(bytes))).getBytes();
        } catch (NoSuchAlgorithmException e) {
            Log.w(TAG, "Failed to encode string because of missing algorithm: " + str2);
            return null;
        }
    }

    public byte[] patternToHash(List<LockPatternView.Cell> list) {
        if (list == null) {
            return null;
        }
        int size = list.size();
        byte[] bArr = new byte[size];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                try {
                    return MessageDigest.getInstance("SHA-1").digest(bArr);
                } catch (NoSuchAlgorithmException e) {
                    return bArr;
                }
            }
            LockPatternView.Cell cell = list.get(i2);
            bArr[i2] = (byte) ((cell.getRow() * getLockPatternSize()) + cell.getColumn());
            i = i2 + 1;
        }
    }

    public String patternToString(List<LockPatternView.Cell> list) {
        return patternToString(list, getLockPatternSize());
    }

    public boolean removeAppWidget(int i) {
        int[] appWidgets = getAppWidgets();
        if (appWidgets.length == 0) {
            return false;
        }
        int[] iArr = new int[appWidgets.length - 1];
        int i2 = 0;
        for (int i3 = 0; i3 < appWidgets.length; i3++) {
            if (appWidgets[i3] != i) {
                if (i2 >= iArr.length) {
                    return false;
                }
                iArr[i2] = appWidgets[i3];
                i2++;
            }
        }
        writeAppWidgets(iArr);
        return true;
    }

    public void removeUser(int i) {
        try {
            getLockSettings().removeUser(i);
        } catch (RemoteException e) {
            Log.e(TAG, "Couldn't remove lock settings for user " + i);
        }
    }

    public void reportFailedPasswordAttempt() {
        int currentOrCallingUserId = getCurrentOrCallingUserId();
        getDevicePolicyManager().reportFailedPasswordAttempt(currentOrCallingUserId);
        getTrustManager().reportUnlockAttempt(false, currentOrCallingUserId);
        getTrustManager().reportRequireCredentialEntry(currentOrCallingUserId);
    }

    public void reportSuccessfulPasswordAttempt() {
        getDevicePolicyManager().reportSuccessfulPasswordAttempt(getCurrentOrCallingUserId());
        getTrustManager().reportUnlockAttempt(true, getCurrentOrCallingUserId());
    }

    public void requireCredentialEntry(int i) {
        getTrustManager().reportRequireCredentialEntry(i);
    }

    public void resumeCall() {
        getTelecommManager().showInCallScreen(false);
    }

    public void saveLockGesture(Gesture gesture) {
        saveLockGesture(gesture, false);
    }

    public void saveLockGesture(Gesture gesture, boolean z) {
        saveLockGesture(gesture, z, getCurrentOrCallingUserId());
    }

    public void saveLockGesture(Gesture gesture, boolean z, int i) {
        try {
            getLockSettings().setLockGesture(gesture, i);
            DevicePolicyManager devicePolicyManager = getDevicePolicyManager();
            if (gesture == null) {
                devicePolicyManager.setActivePasswordState(0, 0, 0, 0, 0, 0, 0, 0, i);
                return;
            }
            setBoolean(GESTURE_EVER_CHOSEN_KEY, true);
            if (!z) {
                deleteGallery(i);
                setLong(PASSWORD_TYPE_KEY, PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED, i);
                devicePolicyManager.setActivePasswordState(524288, 0, 0, 0, 0, 0, 0, 0, i);
                return;
            }
            setLong(PASSWORD_TYPE_KEY, 32768L, i);
            setLong(PASSWORD_TYPE_ALTERNATE_KEY, PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED, i);
            finishBiometricWeak(i);
            devicePolicyManager.setActivePasswordState(32768, 0, 0, 0, 0, 0, 0, 0, i);
        } catch (RemoteException e) {
            Log.e(TAG, "Couldn't save lock gesture " + e);
        }
    }

    public void saveLockPassword(String str, int i) {
        saveLockPassword(str, i, false);
    }

    public void saveLockPassword(String str, int i, boolean z) {
        saveLockPassword(str, i, z, false);
    }

    public void saveLockPassword(String str, int i, boolean z, boolean z2) {
        saveLockPassword(str, i, z, z2, getCurrentOrCallingUserId());
    }

    public void saveLockPassword(String str, int i, boolean z, boolean z2, int i2) {
        byte[] passwordToHash;
        String substring;
        try {
            DevicePolicyManager devicePolicyManager = getDevicePolicyManager();
            if (TextUtils.isEmpty(str)) {
                getLockSettings().setLockPassword(null, i2);
                if (i2 == 0) {
                    updateEncryptionPassword(1, null);
                }
                devicePolicyManager.setActivePasswordState(0, 0, 0, 0, 0, 0, 0, 0, i2);
            } else {
                getLockSettings().setLockPassword(str, i2);
                int computePasswordQuality = computePasswordQuality(str);
                if (i2 == 0 && isDeviceEncryptionEnabled()) {
                    if (isCredentialRequiredToDecrypt(true)) {
                        updateEncryptionPassword(((computePasswordQuality == 131072) || (computePasswordQuality == 196608)) ? 3 : 0, str);
                    } else {
                        clearEncryptionPassword();
                    }
                }
                if (z) {
                    setLong(PASSWORD_TYPE_ALTERNATE_KEY, Math.max(i, computePasswordQuality), i2);
                    if (!z2) {
                        setLong(PASSWORD_TYPE_KEY, 32768L, i2);
                        finishBiometricWeak(i2);
                        devicePolicyManager.setActivePasswordState(32768, 0, 0, 0, 0, 0, 0, 0, i2);
                    }
                } else {
                    deleteGallery(i2);
                    setLong(PASSWORD_TYPE_KEY, Math.max(i, computePasswordQuality), i2);
                    if (computePasswordQuality != 0) {
                        int i3 = 0;
                        int i4 = 0;
                        int i5 = 0;
                        int i6 = 0;
                        int i7 = 0;
                        int i8 = 0;
                        int i9 = 0;
                        while (true) {
                            int i10 = i9;
                            if (i10 >= str.length()) {
                                break;
                            }
                            char charAt = str.charAt(i10);
                            if (charAt >= 'A' && charAt <= 'Z') {
                                i3++;
                                i4++;
                            } else if (charAt >= 'a' && charAt <= 'z') {
                                i3++;
                                i5++;
                            } else if (charAt < '0' || charAt > '9') {
                                i7++;
                                i8++;
                            } else {
                                i6++;
                                i8++;
                            }
                            i9 = i10 + 1;
                        }
                        devicePolicyManager.setActivePasswordState(Math.max(i, computePasswordQuality), str.length(), i3, i4, i5, i6, i7, i8, i2);
                    } else {
                        devicePolicyManager.setActivePasswordState(0, 0, 0, 0, 0, 0, 0, 0, i2);
                    }
                }
                String string = getString(PASSWORD_HISTORY_KEY, i2);
                String str2 = string;
                if (string == null) {
                    str2 = "";
                }
                int requestedPasswordHistoryLength = getRequestedPasswordHistoryLength();
                if (requestedPasswordHistoryLength == 0) {
                    substring = "";
                } else {
                    String str3 = new String(passwordToHash) + "," + str2;
                    substring = str3.substring(0, Math.min(((passwordToHash(str, i2).length * requestedPasswordHistoryLength) + requestedPasswordHistoryLength) - 1, str3.length()));
                }
                setString(PASSWORD_HISTORY_KEY, substring, i2);
            }
            onAfterChangingPassword(i2);
        } catch (RemoteException e) {
            Log.e(TAG, "Unable to save lock password " + e);
        }
    }

    public void saveLockPattern(List<LockPatternView.Cell> list) {
        saveLockPattern(list, false, false);
    }

    public void saveLockPattern(List<LockPatternView.Cell> list, boolean z, boolean z2) {
        saveLockPattern(list, z, z2, getCurrentOrCallingUserId());
    }

    public void saveLockPattern(List<LockPatternView.Cell> list, boolean z, boolean z2, int i) {
        try {
            getLockSettings().setLockPattern(patternToString(list), i);
            DevicePolicyManager devicePolicyManager = getDevicePolicyManager();
            if (list != null) {
                if (i == 0 && isDeviceEncryptionEnabled()) {
                    if (isCredentialRequiredToDecrypt(true)) {
                        updateEncryptionPassword(2, patternToString(list));
                    } else {
                        clearEncryptionPassword();
                    }
                }
                setBoolean(PATTERN_EVER_CHOSEN_KEY, true, i);
                if (z) {
                    setLong(PASSWORD_TYPE_ALTERNATE_KEY, 65536L, i);
                    if (!z2) {
                        setLong(PASSWORD_TYPE_KEY, 32768L, i);
                        finishBiometricWeak(i);
                        devicePolicyManager.setActivePasswordState(32768, 0, 0, 0, 0, 0, 0, 0, i);
                    }
                } else {
                    deleteGallery(i);
                    setLong(PASSWORD_TYPE_KEY, 65536L, i);
                    devicePolicyManager.setActivePasswordState(65536, list.size(), 0, 0, 0, 0, 0, 0, i);
                }
            } else {
                devicePolicyManager.setActivePasswordState(0, 0, 0, 0, 0, 0, 0, 0, i);
            }
            onAfterChangingPassword(i);
        } catch (RemoteException e) {
            Log.e(TAG, "Couldn't save lock pattern " + e);
        }
    }

    public boolean savedGestureExists() {
        return savedGestureExists(getCurrentOrCallingUserId());
    }

    public boolean savedGestureExists(int i) {
        try {
            return getLockSettings().haveGesture(i);
        } catch (RemoteException e) {
            return false;
        }
    }

    public boolean savedPasswordExists() {
        return savedPasswordExists(getCurrentOrCallingUserId());
    }

    public boolean savedPasswordExists(int i) {
        try {
            return getLockSettings().havePassword(i);
        } catch (RemoteException e) {
            return false;
        }
    }

    public boolean savedPatternExists() {
        return savedPatternExists(getCurrentOrCallingUserId());
    }

    public boolean savedPatternExists(int i) {
        try {
            return getLockSettings().havePattern(i);
        } catch (RemoteException e) {
            return false;
        }
    }

    public void setBiometricWeakLivelinessEnabled(boolean z) {
        long j = getLong(Settings.Secure.LOCK_BIOMETRIC_WEAK_FLAGS, 0L);
        setLong(Settings.Secure.LOCK_BIOMETRIC_WEAK_FLAGS, z ? j | 1 : j & (-2));
    }

    public void setCredentialRequiredToDecrypt(boolean z) {
        if (getCurrentUser() != 0) {
            Log.w(TAG, "Only device owner may call setCredentialRequiredForDecrypt()");
        } else {
            Settings.Global.putInt(this.mContext.getContentResolver(), Settings.Global.REQUIRE_PASSWORD_TO_DECRYPT, z ? 1 : 0);
        }
    }

    public void setCurrentUser(int i) {
        sCurrentUserId = i;
    }

    public void setEnabledTrustAgents(Collection<ComponentName> collection) {
        setEnabledTrustAgents(collection, getCurrentOrCallingUserId());
    }

    public void setEnabledTrustAgents(Collection<ComponentName> collection, int i) {
        StringBuilder sb = new StringBuilder();
        for (ComponentName componentName : collection) {
            if (sb.length() > 0) {
                sb.append(',');
            }
            sb.append(componentName.flattenToShortString());
        }
        setString(ENABLED_TRUST_AGENTS, sb.toString(), i);
        getTrustManager().reportEnabledTrustAgentsChanged(getCurrentOrCallingUserId());
    }

    public void setLockGestureEnabled(boolean z) {
        setLockGestureEnabled(z, getCurrentOrCallingUserId());
    }

    public void setLockGestureEnabled(boolean z, int i) {
        setBoolean(Settings.Secure.LOCK_GESTURE_ENABLED, z, i);
    }

    public void setLockPatternEnabled(boolean z) {
        setLockPatternEnabled(z, getCurrentOrCallingUserId());
    }

    public void setLockPatternEnabled(boolean z, int i) {
        setBoolean("lock_pattern_autolock", z, i);
    }

    public void setLockPatternSize(long j) {
        setLong(Settings.Secure.LOCK_PATTERN_SIZE, j);
    }

    public void setLockScreenDisabled(boolean z) {
        setLong("lockscreen.disabled", z ? 1L : 0L);
    }

    public long setLockoutAttemptDeadline() {
        long elapsedRealtime = SystemClock.elapsedRealtime() + 30000;
        setLong(LOCKOUT_ATTEMPT_DEADLINE, elapsedRealtime);
        return elapsedRealtime;
    }

    public void setOwnerInfo(String str, int i) {
        setString("lock_screen_owner_info", str, i);
        updateCryptoUserInfo();
    }

    public void setOwnerInfoEnabled(boolean z) {
        setBoolean("lock_screen_owner_info_enabled", z);
        updateCryptoUserInfo();
    }

    public void setPassToSecurityView(boolean z) {
        setBoolean(Settings.Secure.LOCK_PASS_TO_SECURITY_VIEW, z);
    }

    public void setPermanentlyLocked(boolean z) {
        setBoolean(LOCKOUT_PERMANENT_KEY, z);
    }

    public void setPowerButtonInstantlyLocks(boolean z) {
        setBoolean(LOCKSCREEN_POWER_BUTTON_INSTANTLY_LOCKS, z);
    }

    public void setShowErrorPath(boolean z) {
        setBoolean(Settings.Secure.LOCK_SHOW_ERROR_PATH, z);
    }

    public void setThirdPartyKeyguard(ComponentName componentName) throws PackageManager.NameNotFoundException {
        boolean z;
        if (componentName != null) {
            String[] strArr = this.mContext.getPackageManager().getPackageInfo(componentName.getPackageName(), 4096).requestedPermissions;
            int length = strArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                z = false;
                if (i2 >= length) {
                    break;
                } else if (Manifest.permission.THIRD_PARTY_KEYGUARD.equals(strArr[i2])) {
                    z = true;
                    break;
                } else {
                    i = i2 + 1;
                }
            }
            if (!z) {
                throw new SecurityException("Package " + componentName.getPackageName() + " does nothave " + Manifest.permission.THIRD_PARTY_KEYGUARD);
            }
        }
        setString(THIRD_PARTY_KEYGUARD_COMPONENT, componentName != null ? componentName.flattenToString() : "");
        setLong(PASSWORD_TYPE_KEY, componentName != null ? 2048L : 0L);
    }

    public void setUseFingerprint() {
        setUseFingerprint(getCurrentUser());
    }

    public void setUseFingerprint(int i) {
        DevicePolicyManager devicePolicyManager = getDevicePolicyManager();
        setLong(PASSWORD_TYPE_KEY, 32768L, i);
        setLong(PASSWORD_BIOMETRIC_EXACT_TYPE, 1L, i);
        devicePolicyManager.setActivePasswordState(32768, 0, 0, 0, 0, 0, 0, 0, i);
    }

    public void setVisibleDotsEnabled(boolean z) {
        setBoolean(Settings.Secure.LOCK_DOTS_VISIBLE, z);
    }

    public void setVisibleGestureEnabled(boolean z) {
        setBoolean(Settings.Secure.LOCK_GESTURE_VISIBLE, z);
    }

    public void setVisiblePatternEnabled(boolean z) {
        setBoolean("lock_pattern_visible_pattern", z);
        if (getCurrentOrCallingUserId() != 0) {
            return;
        }
        IBinder service = ServiceManager.getService("mount");
        if (service == null) {
            Log.e(TAG, "Could not find the mount service to update the user info");
            return;
        }
        try {
            IMountService.Stub.asInterface(service).setField(StorageManager.PATTERN_VISIBLE_KEY, z ? "1" : "0");
        } catch (RemoteException e) {
            Log.e(TAG, "Error changing pattern visible state", e);
        }
    }

    public void setWidgetsEnabled(boolean z) {
        setWidgetsEnabled(z, getCurrentOrCallingUserId());
    }

    public void setWidgetsEnabled(boolean z, int i) {
        setBoolean(LOCKSCREEN_WIDGETS_ENABLED, z, i);
    }

    public boolean shouldPassToSecurityView() {
        return getBoolean(Settings.Secure.LOCK_PASS_TO_SECURITY_VIEW, false);
    }

    public List<LockPatternView.Cell> stringToPattern(String str) {
        return stringToPattern(str, getLockPatternSize());
    }

    public void updateEmergencyCallButtonState(Button button, boolean z, boolean z2) {
        int i;
        if (!isEmergencyCallCapable() || !z) {
            button.setVisibility(8);
            return;
        }
        button.setVisibility(0);
        if (isInCall()) {
            button.setCompoundDrawablesWithIntrinsicBounds(z2 ? 17301636 : 0, 0, 0, 0);
            i = 17040479;
        } else {
            button.setCompoundDrawablesWithIntrinsicBounds(z2 ? 17302360 : 0, 0, 0, 0);
            i = 17040478;
        }
        button.setText(i);
    }

    public boolean usingBiometricWeak() {
        return usingBiometricWeak(getCurrentOrCallingUserId());
    }

    public boolean usingBiometricWeak(int i) {
        return ((int) getLong(PASSWORD_TYPE_KEY, 0L, i)) == 32768;
    }

    public boolean usingFingerprint() {
        return usingFingerprint(getCurrentOrCallingUserId());
    }

    public boolean usingFingerprint(int i) {
        return ((int) getLong(PASSWORD_TYPE_KEY, 0L, i)) == 32768 && ((int) getLong(PASSWORD_BIOMETRIC_EXACT_TYPE, -1L)) == 1;
    }

    public void writeFallbackAppWidgetId(int i) {
        Settings.Secure.putIntForUser(this.mContentResolver, Settings.Secure.LOCK_SCREEN_FALLBACK_APPWIDGET_ID, i, -2);
    }
}
