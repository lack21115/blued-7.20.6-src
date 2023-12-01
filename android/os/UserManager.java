package android.os;

import android.app.ActivityManager;
import android.app.ActivityManagerNative;
import android.content.Context;
import android.content.pm.UserInfo;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.provider.Settings;
import android.util.Log;
import com.android.internal.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: source-9557208-dex2jar.jar:android/os/UserManager.class */
public class UserManager {
    public static final String DISALLOW_ADD_USER = "no_add_user";
    public static final String DISALLOW_ADJUST_VOLUME = "no_adjust_volume";
    public static final String DISALLOW_APPS_CONTROL = "no_control_apps";
    public static final String DISALLOW_CONFIG_BLUETOOTH = "no_config_bluetooth";
    public static final String DISALLOW_CONFIG_CELL_BROADCASTS = "no_config_cell_broadcasts";
    public static final String DISALLOW_CONFIG_CREDENTIALS = "no_config_credentials";
    public static final String DISALLOW_CONFIG_MOBILE_NETWORKS = "no_config_mobile_networks";
    public static final String DISALLOW_CONFIG_TETHERING = "no_config_tethering";
    public static final String DISALLOW_CONFIG_VPN = "no_config_vpn";
    public static final String DISALLOW_CONFIG_WIFI = "no_config_wifi";
    public static final String DISALLOW_CREATE_WINDOWS = "no_create_windows";
    public static final String DISALLOW_CROSS_PROFILE_COPY_PASTE = "no_cross_profile_copy_paste";
    public static final String DISALLOW_DEBUGGING_FEATURES = "no_debugging_features";
    public static final String DISALLOW_FACTORY_RESET = "no_factory_reset";
    public static final String DISALLOW_INSTALL_APPS = "no_install_apps";
    public static final String DISALLOW_INSTALL_UNKNOWN_SOURCES = "no_install_unknown_sources";
    public static final String DISALLOW_MODIFY_ACCOUNTS = "no_modify_accounts";
    public static final String DISALLOW_MOUNT_PHYSICAL_MEDIA = "no_physical_media";
    public static final String DISALLOW_OUTGOING_BEAM = "no_outgoing_beam";
    public static final String DISALLOW_OUTGOING_CALLS = "no_outgoing_calls";
    public static final String DISALLOW_REMOVE_USER = "no_remove_user";
    public static final String DISALLOW_SHARE_LOCATION = "no_share_location";
    public static final String DISALLOW_SMS = "no_sms";
    public static final String DISALLOW_SU = "no_su";
    public static final String DISALLOW_UNINSTALL_APPS = "no_uninstall_apps";
    public static final String DISALLOW_UNMUTE_MICROPHONE = "no_unmute_microphone";
    public static final String DISALLOW_USB_FILE_TRANSFER = "no_usb_file_transfer";
    public static final String ENSURE_VERIFY_APPS = "ensure_verify_apps";
    public static final String KEY_RESTRICTIONS_PENDING = "restrictions_pending";
    public static final int PIN_VERIFICATION_FAILED_INCORRECT = -3;
    public static final int PIN_VERIFICATION_FAILED_NOT_SET = -2;
    public static final int PIN_VERIFICATION_SUCCESS = -1;
    private static String TAG = "UserManager";
    private static UserManager sInstance = null;
    private final Context mContext;
    private final IUserManager mService;

    public UserManager(Context context, IUserManager iUserManager) {
        this.mService = iUserManager;
        this.mContext = context;
    }

    private static void addDefaultUserRestrictions(Bundle bundle) {
        bundle.putBoolean(DISALLOW_OUTGOING_CALLS, true);
        bundle.putBoolean(DISALLOW_SMS, true);
        bundle.putBoolean(DISALLOW_SU, true);
    }

    public static UserManager get(Context context) {
        UserManager userManager;
        synchronized (UserManager.class) {
            try {
                if (sInstance == null) {
                    sInstance = (UserManager) context.getSystemService("user");
                }
                userManager = sInstance;
            } catch (Throwable th) {
                throw th;
            }
        }
        return userManager;
    }

    public static int getMaxSupportedUsers() {
        if (Build.ID.startsWith("JVP") || ActivityManager.isLowRamDeviceStatic()) {
            return 1;
        }
        return SystemProperties.getInt("fw.max_users", Resources.getSystem().getInteger(R.integer.config_multiuserMaximumUsers));
    }

    public static boolean supportsMultipleUsers() {
        return getMaxSupportedUsers() > 1 && SystemProperties.getBoolean("fw.show_multiuserui", Resources.getSystem().getBoolean(R.bool.config_enableMultiUserUI));
    }

    public boolean canAddMoreUsers() {
        List<UserInfo> users = getUsers(true);
        int size = users.size();
        int i = 0;
        int i2 = 0;
        while (i2 < size) {
            int i3 = i;
            if (!users.get(i2).isGuest()) {
                i3 = i + 1;
            }
            i2++;
            i = i3;
        }
        return i < getMaxSupportedUsers();
    }

    public int checkRestrictionsChallenge(String str) {
        try {
            return this.mService.checkRestrictionsChallenge(str);
        } catch (RemoteException e) {
            Log.w(TAG, "Could not check restrictions pin");
            return -3;
        }
    }

    public UserInfo createGuest(Context context, String str) {
        UserInfo createUser = createUser(str, 4);
        if (createUser != null) {
            Settings.Secure.putStringForUser(context.getContentResolver(), Settings.Secure.SKIP_FIRST_USE_HINTS, "1", createUser.id);
            try {
                Bundle defaultGuestRestrictions = this.mService.getDefaultGuestRestrictions();
                defaultGuestRestrictions.putBoolean(DISALLOW_SMS, true);
                defaultGuestRestrictions.putBoolean(DISALLOW_INSTALL_UNKNOWN_SOURCES, true);
                defaultGuestRestrictions.putBoolean(DISALLOW_SU, true);
                this.mService.setUserRestrictions(defaultGuestRestrictions, createUser.id);
            } catch (RemoteException e) {
                Log.w(TAG, "Could not update guest restrictions");
                return createUser;
            }
        }
        return createUser;
    }

    public UserInfo createProfileForUser(String str, int i, int i2) {
        try {
            return this.mService.createProfileForUser(str, i, i2);
        } catch (RemoteException e) {
            Log.w(TAG, "Could not create a user", e);
            return null;
        }
    }

    public UserInfo createSecondaryUser(String str, int i) {
        try {
            UserInfo createUser = this.mService.createUser(str, i);
            if (createUser == null) {
                return null;
            }
            Bundle userRestrictions = this.mService.getUserRestrictions(createUser.id);
            addDefaultUserRestrictions(userRestrictions);
            this.mService.setUserRestrictions(userRestrictions, createUser.id);
            return createUser;
        } catch (RemoteException e) {
            Log.w(TAG, "Could not create a user", e);
            return null;
        }
    }

    public UserInfo createUser(String str, int i) {
        try {
            return this.mService.createUser(str, i);
        } catch (RemoteException e) {
            Log.w(TAG, "Could not create a user", e);
            return null;
        }
    }

    public Bundle getApplicationRestrictions(String str) {
        try {
            return this.mService.getApplicationRestrictions(str);
        } catch (RemoteException e) {
            Log.w(TAG, "Could not get application restrictions for package " + str);
            return null;
        }
    }

    public Bundle getApplicationRestrictions(String str, UserHandle userHandle) {
        try {
            return this.mService.getApplicationRestrictionsForUser(str, userHandle.getIdentifier());
        } catch (RemoteException e) {
            Log.w(TAG, "Could not get application restrictions for user " + userHandle.getIdentifier());
            return null;
        }
    }

    public Drawable getBadgedDrawableForUser(Drawable drawable, UserHandle userHandle, Rect rect, int i) {
        return this.mContext.getPackageManager().getUserBadgedDrawableForDensity(drawable, userHandle, rect, i);
    }

    public Drawable getBadgedIconForUser(Drawable drawable, UserHandle userHandle) {
        return this.mContext.getPackageManager().getUserBadgedIcon(drawable, userHandle);
    }

    public CharSequence getBadgedLabelForUser(CharSequence charSequence, UserHandle userHandle) {
        return this.mContext.getPackageManager().getUserBadgedLabel(charSequence, userHandle);
    }

    public Bundle getDefaultGuestRestrictions() {
        try {
            return this.mService.getDefaultGuestRestrictions();
        } catch (RemoteException e) {
            Log.w(TAG, "Could not set guest restrictions");
            return new Bundle();
        }
    }

    public UserInfo getProfileParent(int i) {
        try {
            return this.mService.getProfileParent(i);
        } catch (RemoteException e) {
            Log.w(TAG, "Could not get profile parent", e);
            return null;
        }
    }

    public List<UserInfo> getProfiles(int i) {
        try {
            return this.mService.getProfiles(i, false);
        } catch (RemoteException e) {
            Log.w(TAG, "Could not get user list", e);
            return null;
        }
    }

    public long getSerialNumberForUser(UserHandle userHandle) {
        return getUserSerialNumber(userHandle.getIdentifier());
    }

    public int getUserCount() {
        List<UserInfo> users = getUsers();
        if (users != null) {
            return users.size();
        }
        return 1;
    }

    public UserHandle getUserForSerialNumber(long j) {
        int userHandle = getUserHandle((int) j);
        if (userHandle >= 0) {
            return new UserHandle(userHandle);
        }
        return null;
    }

    public int getUserHandle() {
        return UserHandle.myUserId();
    }

    public int getUserHandle(int i) {
        try {
            return this.mService.getUserHandle(i);
        } catch (RemoteException e) {
            Log.w(TAG, "Could not get userHandle for user " + i);
            return -1;
        }
    }

    public Bitmap getUserIcon(int i) {
        try {
            return this.mService.getUserIcon(i);
        } catch (RemoteException e) {
            Log.w(TAG, "Could not get the user icon ", e);
            return null;
        }
    }

    public UserInfo getUserInfo(int i) {
        try {
            return this.mService.getUserInfo(i);
        } catch (RemoteException e) {
            Log.w(TAG, "Could not get user info", e);
            return null;
        }
    }

    public String getUserName() {
        try {
            return this.mService.getUserInfo(getUserHandle()).name;
        } catch (RemoteException e) {
            Log.w(TAG, "Could not get user name", e);
            return "";
        }
    }

    public List<UserHandle> getUserProfiles() {
        ArrayList arrayList;
        ArrayList arrayList2 = new ArrayList();
        new ArrayList();
        try {
            Iterator<UserInfo> it = this.mService.getProfiles(UserHandle.myUserId(), true).iterator();
            while (true) {
                arrayList = arrayList2;
                if (!it.hasNext()) {
                    break;
                }
                arrayList2.add(new UserHandle(it.next().id));
            }
        } catch (RemoteException e) {
            Log.w(TAG, "Could not get user list", e);
            arrayList = null;
        }
        return arrayList;
    }

    public Bundle getUserRestrictions() {
        return getUserRestrictions(Process.myUserHandle());
    }

    public Bundle getUserRestrictions(UserHandle userHandle) {
        try {
            return this.mService.getUserRestrictions(userHandle.getIdentifier());
        } catch (RemoteException e) {
            Log.w(TAG, "Could not get user restrictions", e);
            return Bundle.EMPTY;
        }
    }

    public int getUserSerialNumber(int i) {
        try {
            return this.mService.getUserSerialNumber(i);
        } catch (RemoteException e) {
            Log.w(TAG, "Could not get serial number for user " + i);
            return -1;
        }
    }

    public List<UserInfo> getUsers() {
        try {
            return this.mService.getUsers(false);
        } catch (RemoteException e) {
            Log.w(TAG, "Could not get user list", e);
            return null;
        }
    }

    public List<UserInfo> getUsers(boolean z) {
        try {
            return this.mService.getUsers(z);
        } catch (RemoteException e) {
            Log.w(TAG, "Could not get user list", e);
            return null;
        }
    }

    public boolean hasRestrictionsChallenge() {
        try {
            return this.mService.hasRestrictionsChallenge();
        } catch (RemoteException e) {
            Log.w(TAG, "Could not change restrictions pin");
            return false;
        }
    }

    public boolean hasUserRestriction(String str) {
        return hasUserRestriction(str, Process.myUserHandle());
    }

    public boolean hasUserRestriction(String str, UserHandle userHandle) {
        try {
            return this.mService.hasUserRestriction(str, userHandle.getIdentifier());
        } catch (RemoteException e) {
            Log.w(TAG, "Could not check user restrictions", e);
            return false;
        }
    }

    public boolean isGuestUser() {
        UserInfo userInfo = getUserInfo(UserHandle.myUserId());
        if (userInfo != null) {
            return userInfo.isGuest();
        }
        return false;
    }

    public boolean isLinkedUser() {
        try {
            return this.mService.isRestricted();
        } catch (RemoteException e) {
            Log.w(TAG, "Could not check if user is limited ", e);
            return false;
        }
    }

    public boolean isManagedProfile() {
        UserInfo userInfo = getUserInfo(UserHandle.myUserId());
        if (userInfo != null) {
            return userInfo.isManagedProfile();
        }
        return false;
    }

    public boolean isUserAGoat() {
        return this.mContext.getPackageManager().isPackageAvailable("com.coffeestainstudios.goatsimulator");
    }

    public boolean isUserRunning(UserHandle userHandle) {
        try {
            return ActivityManagerNative.getDefault().isUserRunning(userHandle.getIdentifier(), false);
        } catch (RemoteException e) {
            return false;
        }
    }

    public boolean isUserRunningOrStopping(UserHandle userHandle) {
        try {
            return ActivityManagerNative.getDefault().isUserRunning(userHandle.getIdentifier(), true);
        } catch (RemoteException e) {
            return false;
        }
    }

    public boolean isUserSwitcherEnabled() {
        List<UserInfo> users = getUsers(true);
        if (users == null) {
            return false;
        }
        int i = 0;
        for (UserInfo userInfo : users) {
            if (userInfo.supportsSwitchTo()) {
                i++;
            }
        }
        return i > 1 || (Settings.Global.getInt(this.mContext.getContentResolver(), Settings.Global.GUEST_USER_ENABLED, 0) == 1);
    }

    public boolean markGuestForDeletion(int i) {
        try {
            return this.mService.markGuestForDeletion(i);
        } catch (RemoteException e) {
            Log.w(TAG, "Could not mark guest for deletion", e);
            return false;
        }
    }

    public void removeRestrictions() {
        try {
            this.mService.removeRestrictions();
        } catch (RemoteException e) {
            Log.w(TAG, "Could not change restrictions pin");
        }
    }

    public boolean removeUser(int i) {
        try {
            return this.mService.removeUser(i);
        } catch (RemoteException e) {
            Log.w(TAG, "Could not remove user ", e);
            return false;
        }
    }

    public void setApplicationRestrictions(String str, Bundle bundle, UserHandle userHandle) {
        try {
            this.mService.setApplicationRestrictions(str, bundle, userHandle.getIdentifier());
        } catch (RemoteException e) {
            Log.w(TAG, "Could not set application restrictions for user " + userHandle.getIdentifier());
        }
    }

    public void setDefaultGuestRestrictions(Bundle bundle) {
        try {
            this.mService.setDefaultGuestRestrictions(bundle);
        } catch (RemoteException e) {
            Log.w(TAG, "Could not set guest restrictions");
        }
    }

    public boolean setRestrictionsChallenge(String str) {
        try {
            return this.mService.setRestrictionsChallenge(str);
        } catch (RemoteException e) {
            Log.w(TAG, "Could not change restrictions pin");
            return false;
        }
    }

    public void setUserEnabled(int i) {
        try {
            this.mService.setUserEnabled(i);
        } catch (RemoteException e) {
            Log.w(TAG, "Could not enable the profile", e);
        }
    }

    public void setUserIcon(int i, Bitmap bitmap) {
        try {
            this.mService.setUserIcon(i, bitmap);
        } catch (RemoteException e) {
            Log.w(TAG, "Could not set the user icon ", e);
        }
    }

    public void setUserName(int i, String str) {
        try {
            this.mService.setUserName(i, str);
        } catch (RemoteException e) {
            Log.w(TAG, "Could not set the user name ", e);
        }
    }

    @Deprecated
    public void setUserRestriction(String str, boolean z) {
        Bundle userRestrictions = getUserRestrictions();
        userRestrictions.putBoolean(str, z);
        setUserRestrictions(userRestrictions);
    }

    @Deprecated
    public void setUserRestriction(String str, boolean z, UserHandle userHandle) {
        Bundle userRestrictions = getUserRestrictions(userHandle);
        userRestrictions.putBoolean(str, z);
        setUserRestrictions(userRestrictions, userHandle);
    }

    @Deprecated
    public void setUserRestrictions(Bundle bundle) {
        setUserRestrictions(bundle, Process.myUserHandle());
    }

    @Deprecated
    public void setUserRestrictions(Bundle bundle, UserHandle userHandle) {
        try {
            this.mService.setUserRestrictions(bundle, userHandle.getIdentifier());
        } catch (RemoteException e) {
            Log.w(TAG, "Could not set user restrictions", e);
        }
    }
}
