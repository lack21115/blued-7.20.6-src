package android.app.admin;

import android.app.admin.IDevicePolicyManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.ProxyInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.PersistableBundle;
import android.os.Process;
import android.os.RemoteCallback;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.UserHandle;
import android.security.Credentials;
import android.util.Log;
import com.android.org.conscrypt.TrustedCertificateStore;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.security.PrivateKey;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: source-9557208-dex2jar.jar:android/app/admin/DevicePolicyManager.class */
public class DevicePolicyManager {
    public static final String ACTION_ADD_DEVICE_ADMIN = "android.app.action.ADD_DEVICE_ADMIN";
    public static final String ACTION_DEVICE_POLICY_MANAGER_STATE_CHANGED = "android.app.action.DEVICE_POLICY_MANAGER_STATE_CHANGED";
    public static final String ACTION_PROVISION_MANAGED_PROFILE = "android.app.action.PROVISION_MANAGED_PROFILE";
    public static final String ACTION_SET_NEW_PASSWORD = "android.app.action.SET_NEW_PASSWORD";
    public static final String ACTION_SET_PROFILE_OWNER = "android.app.action.SET_PROFILE_OWNER";
    public static final String ACTION_START_ENCRYPTION = "android.app.action.START_ENCRYPTION";
    public static final int ENCRYPTION_STATUS_ACTIVATING = 2;
    public static final int ENCRYPTION_STATUS_ACTIVE = 3;
    public static final int ENCRYPTION_STATUS_INACTIVE = 1;
    public static final int ENCRYPTION_STATUS_UNSUPPORTED = 0;
    public static final String EXTRA_ADD_EXPLANATION = "android.app.extra.ADD_EXPLANATION";
    public static final String EXTRA_DEVICE_ADMIN = "android.app.extra.DEVICE_ADMIN";
    public static final String EXTRA_PROFILE_OWNER_NAME = "android.app.extra.PROFILE_OWNER_NAME";
    public static final String EXTRA_PROVISIONING_ACCOUNT_TO_MIGRATE = "android.app.extra.PROVISIONING_ACCOUNT_TO_MIGRATE";
    public static final String EXTRA_PROVISIONING_ADMIN_EXTRAS_BUNDLE = "android.app.extra.PROVISIONING_ADMIN_EXTRAS_BUNDLE";
    public static final String EXTRA_PROVISIONING_DEVICE_ADMIN_PACKAGE_CHECKSUM = "android.app.extra.PROVISIONING_DEVICE_ADMIN_PACKAGE_CHECKSUM";
    public static final String EXTRA_PROVISIONING_DEVICE_ADMIN_PACKAGE_DOWNLOAD_COOKIE_HEADER = "android.app.extra.PROVISIONING_DEVICE_ADMIN_PACKAGE_DOWNLOAD_COOKIE_HEADER";
    public static final String EXTRA_PROVISIONING_DEVICE_ADMIN_PACKAGE_DOWNLOAD_LOCATION = "android.app.extra.PROVISIONING_DEVICE_ADMIN_PACKAGE_DOWNLOAD_LOCATION";
    public static final String EXTRA_PROVISIONING_DEVICE_ADMIN_PACKAGE_NAME = "android.app.extra.PROVISIONING_DEVICE_ADMIN_PACKAGE_NAME";
    public static final String EXTRA_PROVISIONING_EMAIL_ADDRESS = "android.app.extra.PROVISIONING_EMAIL_ADDRESS";
    public static final String EXTRA_PROVISIONING_LEAVE_ALL_SYSTEM_APPS_ENABLED = "android.app.extra.PROVISIONING_LEAVE_ALL_SYSTEM_APPS_ENABLED";
    public static final String EXTRA_PROVISIONING_LOCALE = "android.app.extra.PROVISIONING_LOCALE";
    public static final String EXTRA_PROVISIONING_LOCAL_TIME = "android.app.extra.PROVISIONING_LOCAL_TIME";
    public static final String EXTRA_PROVISIONING_TIME_ZONE = "android.app.extra.PROVISIONING_TIME_ZONE";
    public static final String EXTRA_PROVISIONING_WIFI_HIDDEN = "android.app.extra.PROVISIONING_WIFI_HIDDEN";
    public static final String EXTRA_PROVISIONING_WIFI_PAC_URL = "android.app.extra.PROVISIONING_WIFI_PAC_URL";
    public static final String EXTRA_PROVISIONING_WIFI_PASSWORD = "android.app.extra.PROVISIONING_WIFI_PASSWORD";
    public static final String EXTRA_PROVISIONING_WIFI_PROXY_BYPASS = "android.app.extra.PROVISIONING_WIFI_PROXY_BYPASS";
    public static final String EXTRA_PROVISIONING_WIFI_PROXY_HOST = "android.app.extra.PROVISIONING_WIFI_PROXY_HOST";
    public static final String EXTRA_PROVISIONING_WIFI_PROXY_PORT = "android.app.extra.PROVISIONING_WIFI_PROXY_PORT";
    public static final String EXTRA_PROVISIONING_WIFI_SECURITY_TYPE = "android.app.extra.PROVISIONING_WIFI_SECURITY_TYPE";
    public static final String EXTRA_PROVISIONING_WIFI_SSID = "android.app.extra.PROVISIONING_WIFI_SSID";
    public static final int FLAG_MANAGED_CAN_ACCESS_PARENT = 2;
    public static final int FLAG_PARENT_CAN_ACCESS_MANAGED = 1;
    public static final int KEYGUARD_DISABLE_FEATURES_ALL = Integer.MAX_VALUE;
    public static final int KEYGUARD_DISABLE_FEATURES_NONE = 0;
    public static final int KEYGUARD_DISABLE_FINGERPRINT = 32;
    public static final int KEYGUARD_DISABLE_SECURE_CAMERA = 2;
    public static final int KEYGUARD_DISABLE_SECURE_NOTIFICATIONS = 4;
    public static final int KEYGUARD_DISABLE_TRUST_AGENTS = 16;
    public static final int KEYGUARD_DISABLE_UNREDACTED_NOTIFICATIONS = 8;
    public static final int KEYGUARD_DISABLE_WIDGETS_ALL = 1;
    public static final String MIME_TYPE_PROVISIONING_NFC = "application/com.android.managedprovisioning";
    public static final int PASSWORD_QUALITY_ALPHABETIC = 262144;
    public static final int PASSWORD_QUALITY_ALPHANUMERIC = 327680;
    public static final int PASSWORD_QUALITY_BIOMETRIC_WEAK = 32768;
    public static final int PASSWORD_QUALITY_COMPLEX = 393216;
    public static final int PASSWORD_QUALITY_GESTURE_WEAK = 524288;
    public static final int PASSWORD_QUALITY_NUMERIC = 131072;
    public static final int PASSWORD_QUALITY_NUMERIC_COMPLEX = 196608;
    public static final int PASSWORD_QUALITY_SOMETHING = 65536;
    public static final int PASSWORD_QUALITY_UNSPECIFIED = 0;
    public static final int PASSWORD_THIRD_PARTY_UNSECURED = 2048;
    public static final int RESET_PASSWORD_REQUIRE_ENTRY = 1;
    private static String TAG = "DevicePolicyManager";
    public static final int WIPE_EXTERNAL_STORAGE = 1;
    public static final int WIPE_RESET_PROTECTION_DATA = 2;
    private final Context mContext;
    private final IDevicePolicyManager mService = IDevicePolicyManager.Stub.asInterface(ServiceManager.getService(Context.DEVICE_POLICY_SERVICE));

    private DevicePolicyManager(Context context, Handler handler) {
        this.mContext = context;
    }

    public static DevicePolicyManager create(Context context, Handler handler) {
        DevicePolicyManager devicePolicyManager = new DevicePolicyManager(context, handler);
        if (devicePolicyManager.mService != null) {
            return devicePolicyManager;
        }
        return null;
    }

    private static String getCaCertAlias(byte[] bArr) throws CertificateException {
        return new TrustedCertificateStore().getCertificateAlias((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(bArr)));
    }

    public void addCrossProfileIntentFilter(ComponentName componentName, IntentFilter intentFilter, int i) {
        if (this.mService != null) {
            try {
                this.mService.addCrossProfileIntentFilter(componentName, intentFilter, i);
            } catch (RemoteException e) {
                Log.w(TAG, "Failed talking with device policy service", e);
            }
        }
    }

    public boolean addCrossProfileWidgetProvider(ComponentName componentName, String str) {
        if (this.mService != null) {
            try {
                return this.mService.addCrossProfileWidgetProvider(componentName, str);
            } catch (RemoteException e) {
                Log.w(TAG, "Error calling addCrossProfileWidgetProvider", e);
                return false;
            }
        }
        return false;
    }

    public void addPersistentPreferredActivity(ComponentName componentName, IntentFilter intentFilter, ComponentName componentName2) {
        if (this.mService != null) {
            try {
                this.mService.addPersistentPreferredActivity(componentName, intentFilter, componentName2);
            } catch (RemoteException e) {
                Log.w(TAG, "Failed talking with device policy service", e);
            }
        }
    }

    public void addUserRestriction(ComponentName componentName, String str) {
        if (this.mService != null) {
            try {
                this.mService.setUserRestriction(componentName, str, true);
            } catch (RemoteException e) {
                Log.w(TAG, "Failed talking with device policy service", e);
            }
        }
    }

    public void clearCrossProfileIntentFilters(ComponentName componentName) {
        if (this.mService != null) {
            try {
                this.mService.clearCrossProfileIntentFilters(componentName);
            } catch (RemoteException e) {
                Log.w(TAG, "Failed talking with device policy service", e);
            }
        }
    }

    public void clearDeviceOwnerApp(String str) {
        if (this.mService != null) {
            try {
                this.mService.clearDeviceOwner(str);
            } catch (RemoteException e) {
                Log.w(TAG, "Failed to clear device owner");
            }
        }
    }

    public void clearPackagePersistentPreferredActivities(ComponentName componentName, String str) {
        if (this.mService != null) {
            try {
                this.mService.clearPackagePersistentPreferredActivities(componentName, str);
            } catch (RemoteException e) {
                Log.w(TAG, "Failed talking with device policy service", e);
            }
        }
    }

    public void clearProfileOwner(ComponentName componentName) {
        if (this.mService != null) {
            try {
                this.mService.clearProfileOwner(componentName);
            } catch (RemoteException e) {
                Log.w(TAG, "Failed to clear profile owner " + componentName + e);
            }
        }
    }

    public void clearUserRestriction(ComponentName componentName, String str) {
        if (this.mService != null) {
            try {
                this.mService.setUserRestriction(componentName, str, false);
            } catch (RemoteException e) {
                Log.w(TAG, "Failed talking with device policy service", e);
            }
        }
    }

    public UserHandle createAndInitializeUser(ComponentName componentName, String str, String str2, ComponentName componentName2, Bundle bundle) {
        try {
            return this.mService.createAndInitializeUser(componentName, str, str2, componentName2, bundle);
        } catch (RemoteException e) {
            Log.w(TAG, "Could not create a user", e);
            return null;
        }
    }

    public UserHandle createUser(ComponentName componentName, String str) {
        try {
            return this.mService.createUser(componentName, str);
        } catch (RemoteException e) {
            Log.w(TAG, "Could not create a user", e);
            return null;
        }
    }

    public int enableSystemApp(ComponentName componentName, Intent intent) {
        if (this.mService != null) {
            try {
                return this.mService.enableSystemAppWithIntent(componentName, intent);
            } catch (RemoteException e) {
                Log.w(TAG, "Failed to install packages matching filter: " + intent);
                return 0;
            }
        }
        return 0;
    }

    public void enableSystemApp(ComponentName componentName, String str) {
        if (this.mService != null) {
            try {
                this.mService.enableSystemApp(componentName, str);
            } catch (RemoteException e) {
                Log.w(TAG, "Failed to install package: " + str);
            }
        }
    }

    public String[] getAccountTypesWithManagementDisabled() {
        return getAccountTypesWithManagementDisabledAsUser(UserHandle.myUserId());
    }

    public String[] getAccountTypesWithManagementDisabledAsUser(int i) {
        if (this.mService != null) {
            try {
                return this.mService.getAccountTypesWithManagementDisabledAsUser(i);
            } catch (RemoteException e) {
                Log.w(TAG, "Failed talking with device policy service", e);
                return null;
            }
        }
        return null;
    }

    public List<ComponentName> getActiveAdmins() {
        return getActiveAdminsAsUser(UserHandle.myUserId());
    }

    public List<ComponentName> getActiveAdminsAsUser(int i) {
        if (this.mService != null) {
            try {
                return this.mService.getActiveAdmins(i);
            } catch (RemoteException e) {
                Log.w(TAG, "Failed talking with device policy service", e);
                return null;
            }
        }
        return null;
    }

    public DeviceAdminInfo getAdminInfo(ComponentName componentName) {
        try {
            ActivityInfo receiverInfo = this.mContext.getPackageManager().getReceiverInfo(componentName, 128);
            ResolveInfo resolveInfo = new ResolveInfo();
            resolveInfo.activityInfo = receiverInfo;
            try {
                return new DeviceAdminInfo(this.mContext, resolveInfo);
            } catch (IOException e) {
                Log.w(TAG, "Unable to parse device policy " + componentName, e);
                return null;
            } catch (XmlPullParserException e2) {
                Log.w(TAG, "Unable to parse device policy " + componentName, e2);
                return null;
            }
        } catch (PackageManager.NameNotFoundException e3) {
            Log.w(TAG, "Unable to retrieve device policy " + componentName, e3);
            return null;
        }
    }

    public Bundle getApplicationRestrictions(ComponentName componentName, String str) {
        if (this.mService != null) {
            try {
                return this.mService.getApplicationRestrictions(componentName, str);
            } catch (RemoteException e) {
                Log.w(TAG, "Failed talking with device policy service", e);
                return null;
            }
        }
        return null;
    }

    public boolean getAutoTimeRequired() {
        if (this.mService != null) {
            try {
                return this.mService.getAutoTimeRequired();
            } catch (RemoteException e) {
                Log.w(TAG, "Failed talking with device policy service", e);
                return false;
            }
        }
        return false;
    }

    public boolean getCameraDisabled(ComponentName componentName) {
        return getCameraDisabled(componentName, UserHandle.myUserId());
    }

    public boolean getCameraDisabled(ComponentName componentName, int i) {
        if (this.mService != null) {
            try {
                return this.mService.getCameraDisabled(componentName, i);
            } catch (RemoteException e) {
                Log.w(TAG, "Failed talking with device policy service", e);
                return false;
            }
        }
        return false;
    }

    public boolean getCrossProfileCallerIdDisabled(ComponentName componentName) {
        if (this.mService != null) {
            try {
                return this.mService.getCrossProfileCallerIdDisabled(componentName);
            } catch (RemoteException e) {
                Log.w(TAG, "Failed talking with device policy service", e);
                return false;
            }
        }
        return false;
    }

    public boolean getCrossProfileCallerIdDisabled(UserHandle userHandle) {
        if (this.mService != null) {
            try {
                return this.mService.getCrossProfileCallerIdDisabledForUser(userHandle.getIdentifier());
            } catch (RemoteException e) {
                Log.w(TAG, "Failed talking with device policy service", e);
                return false;
            }
        }
        return false;
    }

    public List<String> getCrossProfileWidgetProviders(ComponentName componentName) {
        if (this.mService != null) {
            try {
                List<String> crossProfileWidgetProviders = this.mService.getCrossProfileWidgetProviders(componentName);
                if (crossProfileWidgetProviders != null) {
                    return crossProfileWidgetProviders;
                }
            } catch (RemoteException e) {
                Log.w(TAG, "Error calling getCrossProfileWidgetProviders", e);
            }
        }
        return Collections.emptyList();
    }

    public int getCurrentFailedPasswordAttempts() {
        if (this.mService != null) {
            try {
                return this.mService.getCurrentFailedPasswordAttempts(UserHandle.myUserId());
            } catch (RemoteException e) {
                Log.w(TAG, "Failed talking with device policy service", e);
                return -1;
            }
        }
        return -1;
    }

    public String getDeviceOwner() {
        if (this.mService != null) {
            try {
                return this.mService.getDeviceOwner();
            } catch (RemoteException e) {
                Log.w(TAG, "Failed to get device owner");
                return null;
            }
        }
        return null;
    }

    public String getDeviceOwnerName() {
        if (this.mService != null) {
            try {
                return this.mService.getDeviceOwnerName();
            } catch (RemoteException e) {
                Log.w(TAG, "Failed to get device owner");
                return null;
            }
        }
        return null;
    }

    public ComponentName getGlobalProxyAdmin() {
        if (this.mService != null) {
            try {
                return this.mService.getGlobalProxyAdmin(UserHandle.myUserId());
            } catch (RemoteException e) {
                Log.w(TAG, "Failed talking with device policy service", e);
                return null;
            }
        }
        return null;
    }

    public List<byte[]> getInstalledCaCerts(ComponentName componentName) {
        ArrayList arrayList = new ArrayList();
        if (this.mService != null) {
            try {
                this.mService.enforceCanManageCaCerts(componentName);
                TrustedCertificateStore trustedCertificateStore = new TrustedCertificateStore();
                for (String str : trustedCertificateStore.userAliases()) {
                    try {
                        arrayList.add(trustedCertificateStore.getCertificate(str).getEncoded());
                    } catch (CertificateException e) {
                        Log.w(TAG, "Could not encode certificate: " + str, e);
                    }
                }
            } catch (RemoteException e2) {
                Log.w(TAG, "Failed talking with device policy service", e2);
            }
        }
        return arrayList;
    }

    public int getKeyguardDisabledFeatures(ComponentName componentName) {
        return getKeyguardDisabledFeatures(componentName, UserHandle.myUserId());
    }

    public int getKeyguardDisabledFeatures(ComponentName componentName, int i) {
        if (this.mService != null) {
            try {
                return this.mService.getKeyguardDisabledFeatures(componentName, i);
            } catch (RemoteException e) {
                Log.w(TAG, "Failed talking with device policy service", e);
                return 0;
            }
        }
        return 0;
    }

    public String[] getLockTaskPackages(ComponentName componentName) {
        if (this.mService != null) {
            try {
                return this.mService.getLockTaskPackages(componentName);
            } catch (RemoteException e) {
                Log.w(TAG, "Failed talking with device policy service", e);
                return null;
            }
        }
        return null;
    }

    public int getMaximumFailedPasswordsForWipe(ComponentName componentName) {
        return getMaximumFailedPasswordsForWipe(componentName, UserHandle.myUserId());
    }

    public int getMaximumFailedPasswordsForWipe(ComponentName componentName, int i) {
        if (this.mService != null) {
            try {
                return this.mService.getMaximumFailedPasswordsForWipe(componentName, i);
            } catch (RemoteException e) {
                Log.w(TAG, "Failed talking with device policy service", e);
                return 0;
            }
        }
        return 0;
    }

    public long getMaximumTimeToLock(ComponentName componentName) {
        return getMaximumTimeToLock(componentName, UserHandle.myUserId());
    }

    public long getMaximumTimeToLock(ComponentName componentName, int i) {
        if (this.mService != null) {
            try {
                return this.mService.getMaximumTimeToLock(componentName, i);
            } catch (RemoteException e) {
                Log.w(TAG, "Failed talking with device policy service", e);
                return 0L;
            }
        }
        return 0L;
    }

    public long getPasswordExpiration(ComponentName componentName) {
        if (this.mService != null) {
            try {
                return this.mService.getPasswordExpiration(componentName, UserHandle.myUserId());
            } catch (RemoteException e) {
                Log.w(TAG, "Failed talking with device policy service", e);
                return 0L;
            }
        }
        return 0L;
    }

    public long getPasswordExpirationTimeout(ComponentName componentName) {
        if (this.mService != null) {
            try {
                return this.mService.getPasswordExpirationTimeout(componentName, UserHandle.myUserId());
            } catch (RemoteException e) {
                Log.w(TAG, "Failed talking with device policy service", e);
                return 0L;
            }
        }
        return 0L;
    }

    public int getPasswordHistoryLength(ComponentName componentName) {
        return getPasswordHistoryLength(componentName, UserHandle.myUserId());
    }

    public int getPasswordHistoryLength(ComponentName componentName, int i) {
        if (this.mService != null) {
            try {
                return this.mService.getPasswordHistoryLength(componentName, i);
            } catch (RemoteException e) {
                Log.w(TAG, "Failed talking with device policy service", e);
                return 0;
            }
        }
        return 0;
    }

    public int getPasswordMaximumLength(int i) {
        return 16;
    }

    public int getPasswordMinimumLength(ComponentName componentName) {
        return getPasswordMinimumLength(componentName, UserHandle.myUserId());
    }

    public int getPasswordMinimumLength(ComponentName componentName, int i) {
        if (this.mService != null) {
            try {
                return this.mService.getPasswordMinimumLength(componentName, i);
            } catch (RemoteException e) {
                Log.w(TAG, "Failed talking with device policy service", e);
                return 0;
            }
        }
        return 0;
    }

    public int getPasswordMinimumLetters(ComponentName componentName) {
        return getPasswordMinimumLetters(componentName, UserHandle.myUserId());
    }

    public int getPasswordMinimumLetters(ComponentName componentName, int i) {
        if (this.mService != null) {
            try {
                return this.mService.getPasswordMinimumLetters(componentName, i);
            } catch (RemoteException e) {
                Log.w(TAG, "Failed talking with device policy service", e);
                return 0;
            }
        }
        return 0;
    }

    public int getPasswordMinimumLowerCase(ComponentName componentName) {
        return getPasswordMinimumLowerCase(componentName, UserHandle.myUserId());
    }

    public int getPasswordMinimumLowerCase(ComponentName componentName, int i) {
        if (this.mService != null) {
            try {
                return this.mService.getPasswordMinimumLowerCase(componentName, i);
            } catch (RemoteException e) {
                Log.w(TAG, "Failed talking with device policy service", e);
                return 0;
            }
        }
        return 0;
    }

    public int getPasswordMinimumNonLetter(ComponentName componentName) {
        return getPasswordMinimumNonLetter(componentName, UserHandle.myUserId());
    }

    public int getPasswordMinimumNonLetter(ComponentName componentName, int i) {
        if (this.mService != null) {
            try {
                return this.mService.getPasswordMinimumNonLetter(componentName, i);
            } catch (RemoteException e) {
                Log.w(TAG, "Failed talking with device policy service", e);
                return 0;
            }
        }
        return 0;
    }

    public int getPasswordMinimumNumeric(ComponentName componentName) {
        return getPasswordMinimumNumeric(componentName, UserHandle.myUserId());
    }

    public int getPasswordMinimumNumeric(ComponentName componentName, int i) {
        if (this.mService != null) {
            try {
                return this.mService.getPasswordMinimumNumeric(componentName, i);
            } catch (RemoteException e) {
                Log.w(TAG, "Failed talking with device policy service", e);
                return 0;
            }
        }
        return 0;
    }

    public int getPasswordMinimumSymbols(ComponentName componentName) {
        return getPasswordMinimumSymbols(componentName, UserHandle.myUserId());
    }

    public int getPasswordMinimumSymbols(ComponentName componentName, int i) {
        if (this.mService != null) {
            try {
                return this.mService.getPasswordMinimumSymbols(componentName, i);
            } catch (RemoteException e) {
                Log.w(TAG, "Failed talking with device policy service", e);
                return 0;
            }
        }
        return 0;
    }

    public int getPasswordMinimumUpperCase(ComponentName componentName) {
        return getPasswordMinimumUpperCase(componentName, UserHandle.myUserId());
    }

    public int getPasswordMinimumUpperCase(ComponentName componentName, int i) {
        if (this.mService != null) {
            try {
                return this.mService.getPasswordMinimumUpperCase(componentName, i);
            } catch (RemoteException e) {
                Log.w(TAG, "Failed talking with device policy service", e);
                return 0;
            }
        }
        return 0;
    }

    public int getPasswordQuality(ComponentName componentName) {
        return getPasswordQuality(componentName, UserHandle.myUserId());
    }

    public int getPasswordQuality(ComponentName componentName, int i) {
        if (this.mService != null) {
            try {
                return this.mService.getPasswordQuality(componentName, i);
            } catch (RemoteException e) {
                Log.w(TAG, "Failed talking with device policy service", e);
                return 0;
            }
        }
        return 0;
    }

    public List<String> getPermittedAccessibilityServices(int i) {
        if (this.mService != null) {
            try {
                return this.mService.getPermittedAccessibilityServicesForUser(i);
            } catch (RemoteException e) {
                Log.w(TAG, "Failed talking with device policy service", e);
                return null;
            }
        }
        return null;
    }

    public List<String> getPermittedAccessibilityServices(ComponentName componentName) {
        if (this.mService != null) {
            try {
                return this.mService.getPermittedAccessibilityServices(componentName);
            } catch (RemoteException e) {
                Log.w(TAG, "Failed talking with device policy service", e);
                return null;
            }
        }
        return null;
    }

    public List<String> getPermittedInputMethods(ComponentName componentName) {
        if (this.mService != null) {
            try {
                return this.mService.getPermittedInputMethods(componentName);
            } catch (RemoteException e) {
                Log.w(TAG, "Failed talking with device policy service", e);
                return null;
            }
        }
        return null;
    }

    public List<String> getPermittedInputMethodsForCurrentUser() {
        if (this.mService != null) {
            try {
                return this.mService.getPermittedInputMethodsForCurrentUser();
            } catch (RemoteException e) {
                Log.w(TAG, "Failed talking with device policy service", e);
                return null;
            }
        }
        return null;
    }

    public ComponentName getProfileOwner() throws IllegalArgumentException {
        return getProfileOwnerAsUser(Process.myUserHandle().getIdentifier());
    }

    public ComponentName getProfileOwnerAsUser(int i) throws IllegalArgumentException {
        if (this.mService != null) {
            try {
                return this.mService.getProfileOwner(i);
            } catch (RemoteException e) {
                Log.w(TAG, "Failed to get profile owner");
                throw new IllegalArgumentException("Requested profile owner for invalid userId", e);
            }
        }
        return null;
    }

    public String getProfileOwnerName() throws IllegalArgumentException {
        if (this.mService != null) {
            try {
                return this.mService.getProfileOwnerName(Process.myUserHandle().getIdentifier());
            } catch (RemoteException e) {
                Log.w(TAG, "Failed to get profile owner");
                throw new IllegalArgumentException("Requested profile owner for invalid userId", e);
            }
        }
        return null;
    }

    public String getProfileOwnerNameAsUser(int i) throws IllegalArgumentException {
        if (this.mService != null) {
            try {
                return this.mService.getProfileOwnerName(i);
            } catch (RemoteException e) {
                Log.w(TAG, "Failed to get profile owner");
                throw new IllegalArgumentException("Requested profile owner for invalid userId", e);
            }
        }
        return null;
    }

    public int getProfileWithMinimumFailedPasswordsForWipe(int i) {
        if (this.mService != null) {
            try {
                return this.mService.getProfileWithMinimumFailedPasswordsForWipe(i);
            } catch (RemoteException e) {
                Log.w(TAG, "Failed talking with device policy service", e);
                return -10000;
            }
        }
        return -10000;
    }

    public void getRemoveWarning(ComponentName componentName, RemoteCallback remoteCallback) {
        if (this.mService != null) {
            try {
                this.mService.getRemoveWarning(componentName, remoteCallback, UserHandle.myUserId());
            } catch (RemoteException e) {
                Log.w(TAG, "Failed talking with device policy service", e);
            }
        }
    }

    public boolean getScreenCaptureDisabled(ComponentName componentName) {
        return getScreenCaptureDisabled(componentName, UserHandle.myUserId());
    }

    public boolean getScreenCaptureDisabled(ComponentName componentName, int i) {
        if (this.mService != null) {
            try {
                return this.mService.getScreenCaptureDisabled(componentName, i);
            } catch (RemoteException e) {
                Log.w(TAG, "Failed talking with device policy service", e);
                return false;
            }
        }
        return false;
    }

    public boolean getStorageEncryption(ComponentName componentName) {
        if (this.mService != null) {
            try {
                return this.mService.getStorageEncryption(componentName, UserHandle.myUserId());
            } catch (RemoteException e) {
                Log.w(TAG, "Failed talking with device policy service", e);
                return false;
            }
        }
        return false;
    }

    public int getStorageEncryptionStatus() {
        return getStorageEncryptionStatus(UserHandle.myUserId());
    }

    public int getStorageEncryptionStatus(int i) {
        if (this.mService != null) {
            try {
                return this.mService.getStorageEncryptionStatus(i);
            } catch (RemoteException e) {
                Log.w(TAG, "Failed talking with device policy service", e);
                return 0;
            }
        }
        return 0;
    }

    public List<PersistableBundle> getTrustAgentConfiguration(ComponentName componentName, ComponentName componentName2) {
        return getTrustAgentConfiguration(componentName, componentName2, UserHandle.myUserId());
    }

    public List<PersistableBundle> getTrustAgentConfiguration(ComponentName componentName, ComponentName componentName2, int i) {
        if (this.mService != null) {
            try {
                return this.mService.getTrustAgentConfiguration(componentName, componentName2, i);
            } catch (RemoteException e) {
                Log.w(TAG, "Failed talking with device policy service", e);
            }
        }
        return new ArrayList();
    }

    public boolean hasCaCertInstalled(ComponentName componentName, byte[] bArr) {
        boolean z = false;
        if (this.mService != null) {
            try {
                this.mService.enforceCanManageCaCerts(componentName);
                z = false;
                if (getCaCertAlias(bArr) != null) {
                    z = true;
                }
            } catch (RemoteException e) {
                Log.w(TAG, "Failed talking with device policy service", e);
                return false;
            } catch (CertificateException e2) {
                Log.w(TAG, "Could not parse certificate", e2);
                return false;
            }
        }
        return z;
    }

    public boolean hasGrantedPolicy(ComponentName componentName, int i) {
        if (this.mService != null) {
            try {
                return this.mService.hasGrantedPolicy(componentName, i, UserHandle.myUserId());
            } catch (RemoteException e) {
                Log.w(TAG, "Failed talking with device policy service", e);
                return false;
            }
        }
        return false;
    }

    public boolean hasUserSetupCompleted() {
        if (this.mService != null) {
            try {
                return this.mService.hasUserSetupCompleted();
            } catch (RemoteException e) {
                Log.w(TAG, "Failed to check if user setup has completed");
                return true;
            }
        }
        return true;
    }

    public boolean installCaCert(ComponentName componentName, byte[] bArr) {
        if (this.mService != null) {
            try {
                return this.mService.installCaCert(componentName, bArr);
            } catch (RemoteException e) {
                Log.w(TAG, "Failed talking with device policy service", e);
                return false;
            }
        }
        return false;
    }

    public boolean installKeyPair(ComponentName componentName, PrivateKey privateKey, Certificate certificate, String str) {
        try {
            return this.mService.installKeyPair(componentName, privateKey.getEncoded(), Credentials.convertToPem(certificate), str);
        } catch (RemoteException e) {
            Log.w(TAG, "Failed talking with device policy service", e);
            return false;
        } catch (IOException e2) {
            Log.w(TAG, "Error writing certificate", e2);
            return false;
        } catch (CertificateException e3) {
            Log.w(TAG, "Error encoding certificate", e3);
            return false;
        }
    }

    public boolean isActivePasswordSufficient() {
        if (this.mService != null) {
            try {
                return this.mService.isActivePasswordSufficient(UserHandle.myUserId());
            } catch (RemoteException e) {
                Log.w(TAG, "Failed talking with device policy service", e);
                return false;
            }
        }
        return false;
    }

    public boolean isAdminActive(ComponentName componentName) {
        return isAdminActiveAsUser(componentName, UserHandle.myUserId());
    }

    public boolean isAdminActiveAsUser(ComponentName componentName, int i) {
        if (this.mService != null) {
            try {
                return this.mService.isAdminActive(componentName, i);
            } catch (RemoteException e) {
                Log.w(TAG, "Failed talking with device policy service", e);
                return false;
            }
        }
        return false;
    }

    public boolean isApplicationHidden(ComponentName componentName, String str) {
        if (this.mService != null) {
            try {
                return this.mService.isApplicationHidden(componentName, str);
            } catch (RemoteException e) {
                Log.w(TAG, "Failed talking with device policy service", e);
                return false;
            }
        }
        return false;
    }

    public boolean isDeviceOwner(String str) {
        return isDeviceOwnerApp(str);
    }

    public boolean isDeviceOwnerApp(String str) {
        if (this.mService != null) {
            try {
                return this.mService.isDeviceOwner(str);
            } catch (RemoteException e) {
                Log.w(TAG, "Failed to check device owner");
                return false;
            }
        }
        return false;
    }

    public boolean isLockTaskPermitted(String str) {
        if (this.mService != null) {
            try {
                return this.mService.isLockTaskPermitted(str);
            } catch (RemoteException e) {
                Log.w(TAG, "Failed talking with device policy service", e);
                return false;
            }
        }
        return false;
    }

    public boolean isMasterVolumeMuted(ComponentName componentName) {
        if (this.mService != null) {
            try {
                return this.mService.isMasterVolumeMuted(componentName);
            } catch (RemoteException e) {
                Log.w(TAG, "Failed to get isMasterMute on device policy service");
                return false;
            }
        }
        return false;
    }

    public boolean isProfileOwnerApp(String str) {
        boolean z = false;
        if (this.mService != null) {
            try {
                ComponentName profileOwner = this.mService.getProfileOwner(Process.myUserHandle().getIdentifier());
                z = false;
                if (profileOwner != null) {
                    z = false;
                    if (profileOwner.getPackageName().equals(str)) {
                        z = true;
                    }
                }
            } catch (RemoteException e) {
                Log.w(TAG, "Failed to check profile owner");
                return false;
            }
        }
        return z;
    }

    public boolean isRemovingAdmin(ComponentName componentName, int i) {
        if (this.mService != null) {
            try {
                return this.mService.isRemovingAdmin(componentName, i);
            } catch (RemoteException e) {
                Log.w(TAG, "Failed talking with device policy service", e);
                return false;
            }
        }
        return false;
    }

    public boolean isUninstallBlocked(ComponentName componentName, String str) {
        if (this.mService != null) {
            try {
                return this.mService.isUninstallBlocked(componentName, str);
            } catch (RemoteException e) {
                Log.w(TAG, "Failed to call block uninstall on device policy service");
                return false;
            }
        }
        return false;
    }

    public void lockNow() {
        if (this.mService != null) {
            try {
                this.mService.lockNow();
            } catch (RemoteException e) {
                Log.w(TAG, "Failed talking with device policy service", e);
            }
        }
    }

    public boolean packageHasActiveAdmins(String str) {
        if (this.mService != null) {
            try {
                return this.mService.packageHasActiveAdmins(str, UserHandle.myUserId());
            } catch (RemoteException e) {
                Log.w(TAG, "Failed talking with device policy service", e);
                return false;
            }
        }
        return false;
    }

    public void removeActiveAdmin(ComponentName componentName) {
        if (this.mService != null) {
            try {
                this.mService.removeActiveAdmin(componentName, UserHandle.myUserId());
            } catch (RemoteException e) {
                Log.w(TAG, "Failed talking with device policy service", e);
            }
        }
    }

    public boolean removeCrossProfileWidgetProvider(ComponentName componentName, String str) {
        if (this.mService != null) {
            try {
                return this.mService.removeCrossProfileWidgetProvider(componentName, str);
            } catch (RemoteException e) {
                Log.w(TAG, "Error calling removeCrossProfileWidgetProvider", e);
                return false;
            }
        }
        return false;
    }

    public boolean removeUser(ComponentName componentName, UserHandle userHandle) {
        try {
            return this.mService.removeUser(componentName, userHandle);
        } catch (RemoteException e) {
            Log.w(TAG, "Could not remove user ", e);
            return false;
        }
    }

    public void reportFailedPasswordAttempt(int i) {
        if (this.mService != null) {
            try {
                this.mService.reportFailedPasswordAttempt(i);
            } catch (RemoteException e) {
                Log.w(TAG, "Failed talking with device policy service", e);
            }
        }
    }

    public void reportSuccessfulPasswordAttempt(int i) {
        if (this.mService != null) {
            try {
                this.mService.reportSuccessfulPasswordAttempt(i);
            } catch (RemoteException e) {
                Log.w(TAG, "Failed talking with device policy service", e);
            }
        }
    }

    public boolean requireSecureKeyguard() {
        return requireSecureKeyguard(UserHandle.myUserId());
    }

    public boolean requireSecureKeyguard(int i) {
        if (this.mService != null) {
            try {
                return this.mService.requireSecureKeyguard(i);
            } catch (RemoteException e) {
                Log.w(TAG, "Failed to get secure keyguard requirement");
                return true;
            }
        }
        return true;
    }

    public boolean resetPassword(String str, int i) {
        if (this.mService != null) {
            try {
                return this.mService.resetPassword(str, i, UserHandle.myUserId());
            } catch (RemoteException e) {
                Log.w(TAG, "Failed talking with device policy service", e);
                return false;
            }
        }
        return false;
    }

    public void setAccountManagementDisabled(ComponentName componentName, String str, boolean z) {
        if (this.mService != null) {
            try {
                this.mService.setAccountManagementDisabled(componentName, str, z);
            } catch (RemoteException e) {
                Log.w(TAG, "Failed talking with device policy service", e);
            }
        }
    }

    public void setActiveAdmin(ComponentName componentName, boolean z) {
        setActiveAdmin(componentName, z, UserHandle.myUserId());
    }

    public void setActiveAdmin(ComponentName componentName, boolean z, int i) {
        if (this.mService != null) {
            try {
                this.mService.setActiveAdmin(componentName, z, i);
            } catch (RemoteException e) {
                Log.w(TAG, "Failed talking with device policy service", e);
            }
        }
    }

    public void setActivePasswordState(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        if (this.mService != null) {
            try {
                this.mService.setActivePasswordState(i, i2, i3, i4, i5, i6, i7, i8, i9);
            } catch (RemoteException e) {
                Log.w(TAG, "Failed talking with device policy service", e);
            }
        }
    }

    public boolean setActiveProfileOwner(ComponentName componentName, String str) throws IllegalArgumentException {
        boolean z = false;
        if (this.mService != null) {
            try {
                int myUserId = UserHandle.myUserId();
                this.mService.setActiveAdmin(componentName, false, myUserId);
                z = this.mService.setProfileOwner(componentName, str, myUserId);
            } catch (RemoteException e) {
                Log.w(TAG, "Failed to set profile owner " + e);
                throw new IllegalArgumentException("Couldn't set profile owner.", e);
            }
        }
        return z;
    }

    public boolean setApplicationHidden(ComponentName componentName, String str, boolean z) {
        if (this.mService != null) {
            try {
                return this.mService.setApplicationHidden(componentName, str, z);
            } catch (RemoteException e) {
                Log.w(TAG, "Failed talking with device policy service", e);
                return false;
            }
        }
        return false;
    }

    public void setApplicationRestrictions(ComponentName componentName, String str, Bundle bundle) {
        if (this.mService != null) {
            try {
                this.mService.setApplicationRestrictions(componentName, str, bundle);
            } catch (RemoteException e) {
                Log.w(TAG, "Failed talking with device policy service", e);
            }
        }
    }

    public void setAutoTimeRequired(ComponentName componentName, boolean z) {
        if (this.mService != null) {
            try {
                this.mService.setAutoTimeRequired(componentName, UserHandle.myUserId(), z);
            } catch (RemoteException e) {
                Log.w(TAG, "Failed talking with device policy service", e);
            }
        }
    }

    public void setCameraDisabled(ComponentName componentName, boolean z) {
        if (this.mService != null) {
            try {
                this.mService.setCameraDisabled(componentName, z, UserHandle.myUserId());
            } catch (RemoteException e) {
                Log.w(TAG, "Failed talking with device policy service", e);
            }
        }
    }

    public void setCrossProfileCallerIdDisabled(ComponentName componentName, boolean z) {
        if (this.mService != null) {
            try {
                this.mService.setCrossProfileCallerIdDisabled(componentName, z);
            } catch (RemoteException e) {
                Log.w(TAG, "Failed talking with device policy service", e);
            }
        }
    }

    public boolean setDeviceOwner(String str) throws IllegalArgumentException, IllegalStateException {
        return setDeviceOwner(str, null);
    }

    public boolean setDeviceOwner(String str, String str2) throws IllegalArgumentException, IllegalStateException {
        if (this.mService != null) {
            try {
                return this.mService.setDeviceOwner(str, str2);
            } catch (RemoteException e) {
                Log.w(TAG, "Failed to set device owner");
                return false;
            }
        }
        return false;
    }

    public ComponentName setGlobalProxy(ComponentName componentName, Proxy proxy, List<String> list) {
        String str;
        String sb;
        String str2;
        if (proxy == null) {
            throw new NullPointerException();
        }
        if (this.mService != null) {
            try {
                if (proxy.equals(Proxy.NO_PROXY)) {
                    str = null;
                    str2 = null;
                } else if (!proxy.type().equals(Proxy.Type.HTTP)) {
                    throw new IllegalArgumentException();
                } else {
                    InetSocketAddress inetSocketAddress = (InetSocketAddress) proxy.address();
                    String hostName = inetSocketAddress.getHostName();
                    int port = inetSocketAddress.getPort();
                    str = hostName + ":" + Integer.toString(port);
                    if (list == null) {
                        sb = "";
                    } else {
                        StringBuilder sb2 = new StringBuilder();
                        boolean z = true;
                        for (String str3 : list) {
                            if (z) {
                                z = false;
                            } else {
                                sb2 = sb2.append(",");
                            }
                            sb2 = sb2.append(str3.trim());
                        }
                        sb = sb2.toString();
                    }
                    str2 = sb;
                    if (android.net.Proxy.validate(hostName, Integer.toString(port), sb) != 0) {
                        throw new IllegalArgumentException();
                    }
                }
                return this.mService.setGlobalProxy(componentName, str, str2, UserHandle.myUserId());
            } catch (RemoteException e) {
                Log.w(TAG, "Failed talking with device policy service", e);
                return null;
            }
        }
        return null;
    }

    public void setGlobalSetting(ComponentName componentName, String str, String str2) {
        if (this.mService != null) {
            try {
                this.mService.setGlobalSetting(componentName, str, str2);
            } catch (RemoteException e) {
                Log.w(TAG, "Failed talking with device policy service", e);
            }
        }
    }

    public void setKeyguardDisabledFeatures(ComponentName componentName, int i) {
        if (this.mService != null) {
            try {
                this.mService.setKeyguardDisabledFeatures(componentName, i, UserHandle.myUserId());
            } catch (RemoteException e) {
                Log.w(TAG, "Failed talking with device policy service", e);
            }
        }
    }

    public void setLockTaskPackages(ComponentName componentName, String[] strArr) throws SecurityException {
        if (this.mService != null) {
            try {
                this.mService.setLockTaskPackages(componentName, strArr);
            } catch (RemoteException e) {
                Log.w(TAG, "Failed talking with device policy service", e);
            }
        }
    }

    public void setMasterVolumeMuted(ComponentName componentName, boolean z) {
        if (this.mService != null) {
            try {
                this.mService.setMasterVolumeMuted(componentName, z);
            } catch (RemoteException e) {
                Log.w(TAG, "Failed to setMasterMute on device policy service");
            }
        }
    }

    public void setMaximumFailedPasswordsForWipe(ComponentName componentName, int i) {
        if (this.mService != null) {
            try {
                this.mService.setMaximumFailedPasswordsForWipe(componentName, i, UserHandle.myUserId());
            } catch (RemoteException e) {
                Log.w(TAG, "Failed talking with device policy service", e);
            }
        }
    }

    public void setMaximumTimeToLock(ComponentName componentName, long j) {
        if (this.mService != null) {
            try {
                this.mService.setMaximumTimeToLock(componentName, j, UserHandle.myUserId());
            } catch (RemoteException e) {
                Log.w(TAG, "Failed talking with device policy service", e);
            }
        }
    }

    public void setPasswordExpirationTimeout(ComponentName componentName, long j) {
        if (this.mService != null) {
            try {
                this.mService.setPasswordExpirationTimeout(componentName, j, UserHandle.myUserId());
            } catch (RemoteException e) {
                Log.w(TAG, "Failed talking with device policy service", e);
            }
        }
    }

    public void setPasswordHistoryLength(ComponentName componentName, int i) {
        if (this.mService != null) {
            try {
                this.mService.setPasswordHistoryLength(componentName, i, UserHandle.myUserId());
            } catch (RemoteException e) {
                Log.w(TAG, "Failed talking with device policy service", e);
            }
        }
    }

    public void setPasswordMinimumLength(ComponentName componentName, int i) {
        if (this.mService != null) {
            try {
                this.mService.setPasswordMinimumLength(componentName, i, UserHandle.myUserId());
            } catch (RemoteException e) {
                Log.w(TAG, "Failed talking with device policy service", e);
            }
        }
    }

    public void setPasswordMinimumLetters(ComponentName componentName, int i) {
        if (this.mService != null) {
            try {
                this.mService.setPasswordMinimumLetters(componentName, i, UserHandle.myUserId());
            } catch (RemoteException e) {
                Log.w(TAG, "Failed talking with device policy service", e);
            }
        }
    }

    public void setPasswordMinimumLowerCase(ComponentName componentName, int i) {
        if (this.mService != null) {
            try {
                this.mService.setPasswordMinimumLowerCase(componentName, i, UserHandle.myUserId());
            } catch (RemoteException e) {
                Log.w(TAG, "Failed talking with device policy service", e);
            }
        }
    }

    public void setPasswordMinimumNonLetter(ComponentName componentName, int i) {
        if (this.mService != null) {
            try {
                this.mService.setPasswordMinimumNonLetter(componentName, i, UserHandle.myUserId());
            } catch (RemoteException e) {
                Log.w(TAG, "Failed talking with device policy service", e);
            }
        }
    }

    public void setPasswordMinimumNumeric(ComponentName componentName, int i) {
        if (this.mService != null) {
            try {
                this.mService.setPasswordMinimumNumeric(componentName, i, UserHandle.myUserId());
            } catch (RemoteException e) {
                Log.w(TAG, "Failed talking with device policy service", e);
            }
        }
    }

    public void setPasswordMinimumSymbols(ComponentName componentName, int i) {
        if (this.mService != null) {
            try {
                this.mService.setPasswordMinimumSymbols(componentName, i, UserHandle.myUserId());
            } catch (RemoteException e) {
                Log.w(TAG, "Failed talking with device policy service", e);
            }
        }
    }

    public void setPasswordMinimumUpperCase(ComponentName componentName, int i) {
        if (this.mService != null) {
            try {
                this.mService.setPasswordMinimumUpperCase(componentName, i, UserHandle.myUserId());
            } catch (RemoteException e) {
                Log.w(TAG, "Failed talking with device policy service", e);
            }
        }
    }

    public void setPasswordQuality(ComponentName componentName, int i) {
        if (this.mService != null) {
            try {
                this.mService.setPasswordQuality(componentName, i, UserHandle.myUserId());
            } catch (RemoteException e) {
                Log.w(TAG, "Failed talking with device policy service", e);
            }
        }
    }

    public boolean setPermittedAccessibilityServices(ComponentName componentName, List<String> list) {
        if (this.mService != null) {
            try {
                return this.mService.setPermittedAccessibilityServices(componentName, list);
            } catch (RemoteException e) {
                Log.w(TAG, "Failed talking with device policy service", e);
                return false;
            }
        }
        return false;
    }

    public boolean setPermittedInputMethods(ComponentName componentName, List<String> list) {
        if (this.mService != null) {
            try {
                return this.mService.setPermittedInputMethods(componentName, list);
            } catch (RemoteException e) {
                Log.w(TAG, "Failed talking with device policy service", e);
                return false;
            }
        }
        return false;
    }

    public void setProfileEnabled(ComponentName componentName) {
        if (this.mService != null) {
            try {
                this.mService.setProfileEnabled(componentName);
            } catch (RemoteException e) {
                Log.w(TAG, "Failed talking with device policy service", e);
            }
        }
    }

    public void setProfileName(ComponentName componentName, String str) {
        if (this.mService != null) {
            try {
                this.mService.setProfileName(componentName, str);
            } catch (RemoteException e) {
                Log.w(TAG, "Failed talking with device policy service", e);
            }
        }
    }

    public boolean setProfileOwner(ComponentName componentName, String str, int i) throws IllegalArgumentException {
        if (componentName == null) {
            throw new NullPointerException("admin cannot be null");
        }
        if (this.mService != null) {
            String str2 = str;
            if (str == null) {
                str2 = "";
            }
            try {
                return this.mService.setProfileOwner(componentName, str2, i);
            } catch (RemoteException e) {
                Log.w(TAG, "Failed to set profile owner", e);
                throw new IllegalArgumentException("Couldn't set profile owner.", e);
            }
        }
        return false;
    }

    public boolean setProfileOwner(String str, String str2, int i) throws IllegalArgumentException {
        if (str == null) {
            throw new NullPointerException("packageName cannot be null");
        }
        return setProfileOwner(new ComponentName(str, ""), str2, i);
    }

    public void setRecommendedGlobalProxy(ComponentName componentName, ProxyInfo proxyInfo) {
        if (this.mService != null) {
            try {
                this.mService.setRecommendedGlobalProxy(componentName, proxyInfo);
            } catch (RemoteException e) {
                Log.w(TAG, "Failed talking with device policy service", e);
            }
        }
    }

    public void setRestrictionsProvider(ComponentName componentName, ComponentName componentName2) {
        if (this.mService != null) {
            try {
                this.mService.setRestrictionsProvider(componentName, componentName2);
            } catch (RemoteException e) {
                Log.w(TAG, "Failed to set permission provider on device policy service");
            }
        }
    }

    public void setScreenCaptureDisabled(ComponentName componentName, boolean z) {
        if (this.mService != null) {
            try {
                this.mService.setScreenCaptureDisabled(componentName, UserHandle.myUserId(), z);
            } catch (RemoteException e) {
                Log.w(TAG, "Failed talking with device policy service", e);
            }
        }
    }

    public void setSecureSetting(ComponentName componentName, String str, String str2) {
        if (this.mService != null) {
            try {
                this.mService.setSecureSetting(componentName, str, str2);
            } catch (RemoteException e) {
                Log.w(TAG, "Failed talking with device policy service", e);
            }
        }
    }

    public int setStorageEncryption(ComponentName componentName, boolean z) {
        if (this.mService != null) {
            try {
                return this.mService.setStorageEncryption(componentName, z, UserHandle.myUserId());
            } catch (RemoteException e) {
                Log.w(TAG, "Failed talking with device policy service", e);
                return 0;
            }
        }
        return 0;
    }

    public void setTrustAgentConfiguration(ComponentName componentName, ComponentName componentName2, PersistableBundle persistableBundle) {
        if (this.mService != null) {
            try {
                this.mService.setTrustAgentConfiguration(componentName, componentName2, persistableBundle, UserHandle.myUserId());
            } catch (RemoteException e) {
                Log.w(TAG, "Failed talking with device policy service", e);
            }
        }
    }

    public void setUninstallBlocked(ComponentName componentName, String str, boolean z) {
        if (this.mService != null) {
            try {
                this.mService.setUninstallBlocked(componentName, str, z);
            } catch (RemoteException e) {
                Log.w(TAG, "Failed to call block uninstall on device policy service");
            }
        }
    }

    public boolean switchUser(ComponentName componentName, UserHandle userHandle) {
        try {
            return this.mService.switchUser(componentName, userHandle);
        } catch (RemoteException e) {
            Log.w(TAG, "Could not switch user ", e);
            return false;
        }
    }

    public void uninstallAllUserCaCerts(ComponentName componentName) {
        if (this.mService != null) {
            for (String str : new TrustedCertificateStore().userAliases()) {
                try {
                    this.mService.uninstallCaCert(componentName, str);
                } catch (RemoteException e) {
                    Log.w(TAG, "Failed talking with device policy service", e);
                }
            }
        }
    }

    public void uninstallCaCert(ComponentName componentName, byte[] bArr) {
        if (this.mService != null) {
            try {
                this.mService.uninstallCaCert(componentName, getCaCertAlias(bArr));
            } catch (RemoteException e) {
                Log.w(TAG, "Failed talking with device policy service", e);
            } catch (CertificateException e2) {
                Log.w(TAG, "Unable to parse certificate", e2);
            }
        }
    }

    public void wipeData(int i) {
        if (this.mService != null) {
            try {
                this.mService.wipeData(i, UserHandle.myUserId());
            } catch (RemoteException e) {
                Log.w(TAG, "Failed talking with device policy service", e);
            }
        }
    }
}
