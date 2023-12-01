package android.content;

import android.content.ClipData;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Process;
import android.os.StrictMode;
import android.os.UserHandle;
import android.provider.MediaStore;
import android.util.ArraySet;
import android.util.AttributeSet;
import android.util.Log;
import com.alipay.sdk.util.i;
import com.android.internal.R;
import com.android.internal.util.XmlUtils;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import java.io.IOException;
import java.io.Serializable;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Set;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

/* loaded from: source-9557208-dex2jar.jar:android/content/Intent.class */
public class Intent implements Parcelable, Cloneable {
    public static final String ACTION_ADVANCED_SETTINGS_CHANGED = "android.intent.action.ADVANCED_SETTINGS";
    public static final String ACTION_AIRPLANE_MODE_CHANGED = "android.intent.action.AIRPLANE_MODE";
    public static final String ACTION_ALARM_CHANGED = "android.intent.action.ALARM_CHANGED";
    public static final String ACTION_ALL_APPS = "android.intent.action.ALL_APPS";
    public static final String ACTION_ANSWER = "android.intent.action.ANSWER";
    public static final String ACTION_APPLICATION_RESTRICTIONS_CHANGED = "android.intent.action.APPLICATION_RESTRICTIONS_CHANGED";
    public static final String ACTION_APP_ERROR = "android.intent.action.APP_ERROR";
    public static final String ACTION_APP_FAILURE = "com.tmobile.intent.action.APP_FAILURE";
    public static final String ACTION_APP_FAILURE_RESET = "com.tmobile.intent.action.APP_FAILURE_RESET";
    public static final String ACTION_ASSIST = "android.intent.action.ASSIST";
    public static final String ACTION_ATTACH_DATA = "android.intent.action.ATTACH_DATA";
    public static final String ACTION_BATTERY_CHANGED = "android.intent.action.BATTERY_CHANGED";
    public static final String ACTION_BATTERY_LOW = "android.intent.action.BATTERY_LOW";
    public static final String ACTION_BATTERY_OKAY = "android.intent.action.BATTERY_OKAY";
    public static final String ACTION_BOOT_COMPLETED = "android.intent.action.BOOT_COMPLETED";
    public static final String ACTION_BUG_REPORT = "android.intent.action.BUG_REPORT";
    public static final String ACTION_CALL = "android.intent.action.CALL";
    public static final String ACTION_CALL_BUTTON = "android.intent.action.CALL_BUTTON";
    public static final String ACTION_CALL_EMERGENCY = "android.intent.action.CALL_EMERGENCY";
    public static final String ACTION_CALL_PRIVILEGED = "android.intent.action.CALL_PRIVILEGED";
    public static final String ACTION_CAMERA_BUTTON = "android.intent.action.CAMERA_BUTTON";
    public static final String ACTION_CHOOSER = "android.intent.action.CHOOSER";
    public static final String ACTION_CLEAR_DNS_CACHE = "android.intent.action.CLEAR_DNS_CACHE";
    public static final String ACTION_CLOSE_SYSTEM_DIALOGS = "android.intent.action.CLOSE_SYSTEM_DIALOGS";
    public static final String ACTION_CONFIGURATION_CHANGED = "android.intent.action.CONFIGURATION_CHANGED";
    public static final String ACTION_CREATE_DOCUMENT = "android.intent.action.CREATE_DOCUMENT";
    public static final String ACTION_CREATE_SHORTCUT = "android.intent.action.CREATE_SHORTCUT";
    public static final String ACTION_CUSTOM_CARRIER_LABEL_CHANGED = "android.intent.action.CUSTOM_CARRIER_LABEL";
    public static final String ACTION_DATE_CHANGED = "android.intent.action.DATE_CHANGED";
    public static final String ACTION_DEFAULT = "android.intent.action.VIEW";
    public static final String ACTION_DELETE = "android.intent.action.DELETE";
    public static final String ACTION_DEVICE_STORAGE_FULL = "android.intent.action.DEVICE_STORAGE_FULL";
    public static final String ACTION_DEVICE_STORAGE_LOW = "android.intent.action.DEVICE_STORAGE_LOW";
    public static final String ACTION_DEVICE_STORAGE_NOT_FULL = "android.intent.action.DEVICE_STORAGE_NOT_FULL";
    public static final String ACTION_DEVICE_STORAGE_OK = "android.intent.action.DEVICE_STORAGE_OK";
    public static final String ACTION_DIAL = "android.intent.action.DIAL";
    public static final String ACTION_DOCK_EVENT = "android.intent.action.DOCK_EVENT";
    public static final String ACTION_DOZE_PULSE_STARTING = "android.intent.action.DOZE_PULSE_STARTING";
    public static final String ACTION_DREAMING_STARTED = "android.intent.action.DREAMING_STARTED";
    public static final String ACTION_DREAMING_STOPPED = "android.intent.action.DREAMING_STOPPED";
    public static final String ACTION_EDIT = "android.intent.action.EDIT";
    public static final String ACTION_EXTERNAL_APPLICATIONS_AVAILABLE = "android.intent.action.EXTERNAL_APPLICATIONS_AVAILABLE";
    public static final String ACTION_EXTERNAL_APPLICATIONS_UNAVAILABLE = "android.intent.action.EXTERNAL_APPLICATIONS_UNAVAILABLE";
    public static final String ACTION_FACTORY_TEST = "android.intent.action.FACTORY_TEST";
    public static final String ACTION_GET_CONTENT = "android.intent.action.GET_CONTENT";
    public static final String ACTION_GET_RESTRICTION_ENTRIES = "android.intent.action.GET_RESTRICTION_ENTRIES";
    public static final String ACTION_GLOBAL_BUTTON = "android.intent.action.GLOBAL_BUTTON";
    public static final String ACTION_GTALK_SERVICE_CONNECTED = "android.intent.action.GTALK_CONNECTED";
    public static final String ACTION_GTALK_SERVICE_DISCONNECTED = "android.intent.action.GTALK_DISCONNECTED";
    public static final String ACTION_HEADSET_PLUG = "android.intent.action.HEADSET_PLUG";
    public static final String ACTION_HOTWORD_INPUT_CHANGED = "com.mokee.intent.action.HOTWORD_INPUT_CHANGED";
    public static final String ACTION_IDLE_MAINTENANCE_END = "android.intent.action.ACTION_IDLE_MAINTENANCE_END";
    public static final String ACTION_IDLE_MAINTENANCE_START = "android.intent.action.ACTION_IDLE_MAINTENANCE_START";
    public static final String ACTION_INPUT_METHOD_CHANGED = "android.intent.action.INPUT_METHOD_CHANGED";
    public static final String ACTION_INSERT = "android.intent.action.INSERT";
    public static final String ACTION_INSERT_OR_EDIT = "android.intent.action.INSERT_OR_EDIT";
    public static final String ACTION_INSTALL_PACKAGE = "android.intent.action.INSTALL_PACKAGE";
    public static final String ACTION_KEYGUARD_WALLPAPER_CHANGED = "android.intent.action.KEYGUARD_WALLPAPER_CHANGED";
    public static final String ACTION_LOCALE_CHANGED = "android.intent.action.LOCALE_CHANGED";
    public static final String ACTION_MAIN = "android.intent.action.MAIN";
    public static final String ACTION_MANAGED_PROFILE_ADDED = "android.intent.action.MANAGED_PROFILE_ADDED";
    public static final String ACTION_MANAGED_PROFILE_REMOVED = "android.intent.action.MANAGED_PROFILE_REMOVED";
    public static final String ACTION_MANAGE_NETWORK_USAGE = "android.intent.action.MANAGE_NETWORK_USAGE";
    public static final String ACTION_MANAGE_PACKAGE_STORAGE = "android.intent.action.MANAGE_PACKAGE_STORAGE";
    public static final String ACTION_MASTER_CLEAR = "android.intent.action.MASTER_CLEAR";
    public static final String ACTION_MEDIA_BAD_REMOVAL = "android.intent.action.MEDIA_BAD_REMOVAL";
    public static final String ACTION_MEDIA_BUTTON = "android.intent.action.MEDIA_BUTTON";
    public static final String ACTION_MEDIA_CHECKING = "android.intent.action.MEDIA_CHECKING";
    public static final String ACTION_MEDIA_EJECT = "android.intent.action.MEDIA_EJECT";
    public static final String ACTION_MEDIA_MOUNTED = "android.intent.action.MEDIA_MOUNTED";
    public static final String ACTION_MEDIA_NOFS = "android.intent.action.MEDIA_NOFS";
    public static final String ACTION_MEDIA_REMOVED = "android.intent.action.MEDIA_REMOVED";
    public static final String ACTION_MEDIA_SCANNER_FINISHED = "android.intent.action.MEDIA_SCANNER_FINISHED";
    public static final String ACTION_MEDIA_SCANNER_SCAN_FILE = "android.intent.action.MEDIA_SCANNER_SCAN_FILE";
    public static final String ACTION_MEDIA_SCANNER_STARTED = "android.intent.action.MEDIA_SCANNER_STARTED";
    public static final String ACTION_MEDIA_SHARED = "android.intent.action.MEDIA_SHARED";
    public static final String ACTION_MEDIA_UNMOUNTABLE = "android.intent.action.MEDIA_UNMOUNTABLE";
    public static final String ACTION_MEDIA_UNMOUNTED = "android.intent.action.MEDIA_UNMOUNTED";
    public static final String ACTION_MEDIA_UNSHARED = "android.intent.action.MEDIA_UNSHARED";
    public static final String ACTION_MY_PACKAGE_REPLACED = "android.intent.action.MY_PACKAGE_REPLACED";
    public static final String ACTION_NEW_OUTGOING_CALL = "android.intent.action.NEW_OUTGOING_CALL";
    public static final String ACTION_NEW_OUTGOING_SMS = "android.intent.action.NEW_OUTGOING_SMS";
    public static final String ACTION_OPEN_DOCUMENT = "android.intent.action.OPEN_DOCUMENT";
    public static final String ACTION_OPEN_DOCUMENT_TREE = "android.intent.action.OPEN_DOCUMENT_TREE";
    public static final String ACTION_PACKAGE_ADDED = "android.intent.action.PACKAGE_ADDED";
    public static final String ACTION_PACKAGE_CHANGED = "android.intent.action.PACKAGE_CHANGED";
    public static final String ACTION_PACKAGE_DATA_CLEARED = "android.intent.action.PACKAGE_DATA_CLEARED";
    public static final String ACTION_PACKAGE_FIRST_LAUNCH = "android.intent.action.PACKAGE_FIRST_LAUNCH";
    public static final String ACTION_PACKAGE_FULLY_REMOVED = "android.intent.action.PACKAGE_FULLY_REMOVED";
    @Deprecated
    public static final String ACTION_PACKAGE_INSTALL = "android.intent.action.PACKAGE_INSTALL";
    public static final String ACTION_PACKAGE_NEEDS_VERIFICATION = "android.intent.action.PACKAGE_NEEDS_VERIFICATION";
    public static final String ACTION_PACKAGE_REMOVED = "android.intent.action.PACKAGE_REMOVED";
    public static final String ACTION_PACKAGE_REPLACED = "android.intent.action.PACKAGE_REPLACED";
    public static final String ACTION_PACKAGE_RESTARTED = "android.intent.action.PACKAGE_RESTARTED";
    public static final String ACTION_PACKAGE_VERIFIED = "android.intent.action.PACKAGE_VERIFIED";
    public static final String ACTION_PASTE = "android.intent.action.PASTE";
    public static final String ACTION_PICK = "android.intent.action.PICK";
    public static final String ACTION_PICK_ACTIVITY = "android.intent.action.PICK_ACTIVITY";
    public static final String ACTION_POWER_CONNECTED = "android.intent.action.ACTION_POWER_CONNECTED";
    public static final String ACTION_POWER_DISCONNECTED = "android.intent.action.ACTION_POWER_DISCONNECTED";
    public static final String ACTION_POWER_USAGE_SUMMARY = "android.intent.action.POWER_USAGE_SUMMARY";
    public static final String ACTION_PRE_BOOT_COMPLETED = "android.intent.action.PRE_BOOT_COMPLETED";
    public static final String ACTION_PROVIDER_CHANGED = "android.intent.action.PROVIDER_CHANGED";
    public static final String ACTION_QUERY_PACKAGE_RESTART = "android.intent.action.QUERY_PACKAGE_RESTART";
    public static final String ACTION_QUICK_CLOCK = "android.intent.action.QUICK_CLOCK";
    public static final String ACTION_REBOOT = "android.intent.action.REBOOT";
    public static final String ACTION_RECENTS_LONG_PRESS = "android.intent.action.RECENTS_LONG_PRESS";
    public static final String ACTION_REMOTE_INTENT = "com.google.android.c2dm.intent.RECEIVE";
    public static final String ACTION_REQUEST_SHUTDOWN = "android.intent.action.ACTION_REQUEST_SHUTDOWN";
    public static final String ACTION_RESTRICTIONS_CHALLENGE = "android.intent.action.RESTRICTIONS_CHALLENGE";
    public static final String ACTION_RUN = "android.intent.action.RUN";
    public static final String ACTION_SCREEN_OFF = "android.intent.action.SCREEN_OFF";
    public static final String ACTION_SCREEN_ON = "android.intent.action.SCREEN_ON";
    public static final String ACTION_SEARCH = "android.intent.action.SEARCH";
    public static final String ACTION_SEARCH_LONG_PRESS = "android.intent.action.SEARCH_LONG_PRESS";
    public static final String ACTION_SEND = "android.intent.action.SEND";
    public static final String ACTION_SENDTO = "android.intent.action.SENDTO";
    public static final String ACTION_SEND_MULTIPLE = "android.intent.action.SEND_MULTIPLE";
    public static final String ACTION_SET_WALLPAPER = "android.intent.action.SET_WALLPAPER";
    public static final String ACTION_SHOW_BRIGHTNESS_DIALOG = "android.intent.action.SHOW_BRIGHTNESS_DIALOG";
    public static final String ACTION_SHOW_NOTIFICATION_BRIGHTNESS_DIALOG = "android.intent.action.SHOW_NOTIFICATION_BRIGHTNESS_DIALOG";
    public static final String ACTION_SHUTDOWN = "android.intent.action.ACTION_SHUTDOWN";
    public static final String ACTION_SYNC = "android.intent.action.SYNC";
    public static final String ACTION_SYNC_STATE_CHANGED = "android.intent.action.SYNC_STATE_CHANGED";
    public static final String ACTION_SYSTEM_TUTORIAL = "android.intent.action.SYSTEM_TUTORIAL";
    public static final String ACTION_THEME_RESOURCES_CACHED = "android.intent.action.THEME_RESOURCES_CACHED";
    public static final String ACTION_TIMEZONE_CHANGED = "android.intent.action.TIMEZONE_CHANGED";
    public static final String ACTION_TIME_CHANGED = "android.intent.action.TIME_SET";
    public static final String ACTION_TIME_TICK = "android.intent.action.TIME_TICK";
    public static final String ACTION_UID_REMOVED = "android.intent.action.UID_REMOVED";
    @Deprecated
    public static final String ACTION_UMS_CONNECTED = "android.intent.action.UMS_CONNECTED";
    @Deprecated
    public static final String ACTION_UMS_DISCONNECTED = "android.intent.action.UMS_DISCONNECTED";
    public static final String ACTION_UNINSTALL_PACKAGE = "android.intent.action.UNINSTALL_PACKAGE";
    public static final String ACTION_UPGRADE_SETUP = "android.intent.action.UPGRADE_SETUP";
    public static final String ACTION_USER_ADDED = "android.intent.action.USER_ADDED";
    public static final String ACTION_USER_BACKGROUND = "android.intent.action.USER_BACKGROUND";
    public static final String ACTION_USER_FOREGROUND = "android.intent.action.USER_FOREGROUND";
    public static final String ACTION_USER_INFO_CHANGED = "android.intent.action.USER_INFO_CHANGED";
    public static final String ACTION_USER_INITIALIZE = "android.intent.action.USER_INITIALIZE";
    public static final String ACTION_USER_PRESENT = "android.intent.action.USER_PRESENT";
    public static final String ACTION_USER_REMOVED = "android.intent.action.USER_REMOVED";
    public static final String ACTION_USER_STARTED = "android.intent.action.USER_STARTED";
    public static final String ACTION_USER_STARTING = "android.intent.action.USER_STARTING";
    public static final String ACTION_USER_STOPPED = "android.intent.action.USER_STOPPED";
    public static final String ACTION_USER_STOPPING = "android.intent.action.USER_STOPPING";
    public static final String ACTION_USER_SWITCHED = "android.intent.action.USER_SWITCHED";
    public static final String ACTION_VIEW = "android.intent.action.VIEW";
    public static final String ACTION_VOICE_ASSIST = "android.intent.action.VOICE_ASSIST";
    public static final String ACTION_VOICE_COMMAND = "android.intent.action.VOICE_COMMAND";
    @Deprecated
    public static final String ACTION_WALLPAPER_CHANGED = "android.intent.action.WALLPAPER_CHANGED";
    public static final String ACTION_WEB_SEARCH = "android.intent.action.WEB_SEARCH";
    private static final String ATTR_ACTION = "action";
    private static final String ATTR_CATEGORY = "category";
    private static final String ATTR_COMPONENT = "component";
    private static final String ATTR_DATA = "data";
    private static final String ATTR_FLAGS = "flags";
    private static final String ATTR_TYPE = "type";
    public static final String CATEGORY_ALTERNATIVE = "android.intent.category.ALTERNATIVE";
    public static final String CATEGORY_APP_BROWSER = "android.intent.category.APP_BROWSER";
    public static final String CATEGORY_APP_CALCULATOR = "android.intent.category.APP_CALCULATOR";
    public static final String CATEGORY_APP_CALENDAR = "android.intent.category.APP_CALENDAR";
    public static final String CATEGORY_APP_CONTACTS = "android.intent.category.APP_CONTACTS";
    public static final String CATEGORY_APP_EMAIL = "android.intent.category.APP_EMAIL";
    public static final String CATEGORY_APP_GALLERY = "android.intent.category.APP_GALLERY";
    public static final String CATEGORY_APP_MAPS = "android.intent.category.APP_MAPS";
    public static final String CATEGORY_APP_MARKET = "android.intent.category.APP_MARKET";
    public static final String CATEGORY_APP_MESSAGING = "android.intent.category.APP_MESSAGING";
    public static final String CATEGORY_APP_MUSIC = "android.intent.category.APP_MUSIC";
    public static final String CATEGORY_BROWSABLE = "android.intent.category.BROWSABLE";
    public static final String CATEGORY_CAR_DOCK = "android.intent.category.CAR_DOCK";
    public static final String CATEGORY_CAR_MODE = "android.intent.category.CAR_MODE";
    public static final String CATEGORY_DEFAULT = "android.intent.category.DEFAULT";
    public static final String CATEGORY_DESK_DOCK = "android.intent.category.DESK_DOCK";
    public static final String CATEGORY_DEVELOPMENT_PREFERENCE = "android.intent.category.DEVELOPMENT_PREFERENCE";
    public static final String CATEGORY_EMBED = "android.intent.category.EMBED";
    public static final String CATEGORY_FRAMEWORK_INSTRUMENTATION_TEST = "android.intent.category.FRAMEWORK_INSTRUMENTATION_TEST";
    public static final String CATEGORY_HE_DESK_DOCK = "android.intent.category.HE_DESK_DOCK";
    public static final String CATEGORY_HOME = "android.intent.category.HOME";
    public static final String CATEGORY_INFO = "android.intent.category.INFO";
    public static final String CATEGORY_LAUNCHER = "android.intent.category.LAUNCHER";
    public static final String CATEGORY_LEANBACK_LAUNCHER = "android.intent.category.LEANBACK_LAUNCHER";
    public static final String CATEGORY_LEANBACK_SETTINGS = "android.intent.category.LEANBACK_SETTINGS";
    public static final String CATEGORY_LE_DESK_DOCK = "android.intent.category.LE_DESK_DOCK";
    public static final String CATEGORY_MONKEY = "android.intent.category.MONKEY";
    public static final String CATEGORY_OPENABLE = "android.intent.category.OPENABLE";
    public static final String CATEGORY_PREFERENCE = "android.intent.category.PREFERENCE";
    public static final String CATEGORY_SAMPLE_CODE = "android.intent.category.SAMPLE_CODE";
    public static final String CATEGORY_SELECTED_ALTERNATIVE = "android.intent.category.SELECTED_ALTERNATIVE";
    public static final String CATEGORY_TAB = "android.intent.category.TAB";
    public static final String CATEGORY_TEST = "android.intent.category.TEST";
    public static final String CATEGORY_THEME_PACKAGE_INSTALLED_STATE_CHANGE = "com.tmobile.intent.category.THEME_PACKAGE_INSTALL_STATE_CHANGE";
    public static final String CATEGORY_UNIT_TEST = "android.intent.category.UNIT_TEST";
    public static final String CATEGORY_VOICE = "android.intent.category.VOICE";
    public static final Parcelable.Creator<Intent> CREATOR = new Parcelable.Creator<Intent>() { // from class: android.content.Intent.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Intent createFromParcel(Parcel parcel) {
            return new Intent(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Intent[] newArray(int i) {
            return new Intent[i];
        }
    };
    public static final String EXTRA_ALARM_COUNT = "android.intent.extra.ALARM_COUNT";
    public static final String EXTRA_ALLOW_MULTIPLE = "android.intent.extra.ALLOW_MULTIPLE";
    @Deprecated
    public static final String EXTRA_ALLOW_REPLACE = "android.intent.extra.ALLOW_REPLACE";
    public static final String EXTRA_ASSIST_CONTEXT = "android.intent.extra.ASSIST_CONTEXT";
    public static final String EXTRA_ASSIST_INPUT_HINT_KEYBOARD = "android.intent.extra.ASSIST_INPUT_HINT_KEYBOARD";
    public static final String EXTRA_ASSIST_PACKAGE = "android.intent.extra.ASSIST_PACKAGE";
    public static final String EXTRA_BCC = "android.intent.extra.BCC";
    public static final String EXTRA_BUG_REPORT = "android.intent.extra.BUG_REPORT";
    public static final String EXTRA_CC = "android.intent.extra.CC";
    @Deprecated
    public static final String EXTRA_CHANGED_COMPONENT_NAME = "android.intent.extra.changed_component_name";
    public static final String EXTRA_CHANGED_COMPONENT_NAME_LIST = "android.intent.extra.changed_component_name_list";
    public static final String EXTRA_CHANGED_PACKAGE_LIST = "android.intent.extra.changed_package_list";
    public static final String EXTRA_CHANGED_UID_LIST = "android.intent.extra.changed_uid_list";
    public static final String EXTRA_CHOSEN_COMPONENT = "android.intent.extra.CHOSEN_COMPONENT";
    public static final String EXTRA_CHOSEN_COMPONENT_INTENT_SENDER = "android.intent.extra.CHOSEN_COMPONENT_INTENT_SENDER";
    public static final String EXTRA_CLIENT_INTENT = "android.intent.extra.client_intent";
    public static final String EXTRA_CLIENT_LABEL = "android.intent.extra.client_label";
    public static final String EXTRA_CURRENT_PACKAGE_NAME = "com.mokee.intent.extra.CURRENT_PACKAGE_NAME";
    public static final String EXTRA_DATA_REMOVED = "android.intent.extra.DATA_REMOVED";
    public static final String EXTRA_DOCK_STATE = "android.intent.extra.DOCK_STATE";
    public static final int EXTRA_DOCK_STATE_CAR = 2;
    public static final int EXTRA_DOCK_STATE_DESK = 1;
    public static final int EXTRA_DOCK_STATE_HE_DESK = 4;
    public static final int EXTRA_DOCK_STATE_LE_DESK = 3;
    public static final int EXTRA_DOCK_STATE_UNDOCKED = 0;
    public static final String EXTRA_DONT_KILL_APP = "android.intent.extra.DONT_KILL_APP";
    public static final String EXTRA_EMAIL = "android.intent.extra.EMAIL";
    public static final String EXTRA_HOTWORD_INPUT_STATE = "com.mokee.intent.extra.HOTWORD_INPUT_STATE";
    public static final String EXTRA_HTML_TEXT = "android.intent.extra.HTML_TEXT";
    public static final String EXTRA_INITIAL_INTENTS = "android.intent.extra.INITIAL_INTENTS";
    public static final String EXTRA_INSTALLER_PACKAGE_NAME = "android.intent.extra.INSTALLER_PACKAGE_NAME";
    public static final String EXTRA_INSTALL_RESULT = "android.intent.extra.INSTALL_RESULT";
    public static final String EXTRA_INTENT = "android.intent.extra.INTENT";
    public static final String EXTRA_KEY_CONFIRM = "android.intent.extra.KEY_CONFIRM";
    public static final String EXTRA_KEY_EVENT = "android.intent.extra.KEY_EVENT";
    public static final String EXTRA_LOCAL_ONLY = "android.intent.extra.LOCAL_ONLY";
    public static final String EXTRA_MIME_TYPES = "android.intent.extra.MIME_TYPES";
    public static final String EXTRA_NOT_UNKNOWN_SOURCE = "android.intent.extra.NOT_UNKNOWN_SOURCE";
    public static final String EXTRA_ORIGINATING_UID = "android.intent.extra.ORIGINATING_UID";
    public static final String EXTRA_ORIGINATING_URI = "android.intent.extra.ORIGINATING_URI";
    public static final String EXTRA_PACKAGES = "android.intent.extra.PACKAGES";
    public static final String EXTRA_PHONE_NUMBER = "android.intent.extra.PHONE_NUMBER";
    public static final String EXTRA_REASON = "android.intent.extra.REASON";
    public static final String EXTRA_RECENTS_LONG_PRESS_RELEASE = "android.intent.extra.RECENTS_LONG_PRESS_RELEASE";
    public static final String EXTRA_REFERRER = "android.intent.extra.REFERRER";
    public static final String EXTRA_REFERRER_NAME = "android.intent.extra.REFERRER_NAME";
    public static final String EXTRA_REMOTE_INTENT_TOKEN = "android.intent.extra.remote_intent_token";
    public static final String EXTRA_REMOVED_FOR_ALL_USERS = "android.intent.extra.REMOVED_FOR_ALL_USERS";
    public static final String EXTRA_REPLACEMENT_EXTRAS = "android.intent.extra.REPLACEMENT_EXTRAS";
    public static final String EXTRA_REPLACING = "android.intent.extra.REPLACING";
    public static final String EXTRA_RESTRICTIONS_BUNDLE = "android.intent.extra.restrictions_bundle";
    public static final String EXTRA_RESTRICTIONS_INTENT = "android.intent.extra.restrictions_intent";
    public static final String EXTRA_RESTRICTIONS_LIST = "android.intent.extra.restrictions_list";
    public static final String EXTRA_RETURN_RESULT = "android.intent.extra.RETURN_RESULT";
    public static final String EXTRA_SHORTCUT_ICON = "android.intent.extra.shortcut.ICON";
    public static final String EXTRA_SHORTCUT_ICON_RESOURCE = "android.intent.extra.shortcut.ICON_RESOURCE";
    public static final String EXTRA_SHORTCUT_INTENT = "android.intent.extra.shortcut.INTENT";
    public static final String EXTRA_SHORTCUT_NAME = "android.intent.extra.shortcut.NAME";
    public static final String EXTRA_SHUTDOWN_USERSPACE_ONLY = "android.intent.extra.SHUTDOWN_USERSPACE_ONLY";
    public static final String EXTRA_STREAM = "android.intent.extra.STREAM";
    public static final String EXTRA_SUBJECT = "android.intent.extra.SUBJECT";
    public static final String EXTRA_TEMPLATE = "android.intent.extra.TEMPLATE";
    public static final String EXTRA_TEXT = "android.intent.extra.TEXT";
    public static final String EXTRA_THEME_PACKAGE_NAME = "android.intent.extra.PACKAGE_NAME";
    public static final String EXTRA_THEME_RESULT = "android.intent.extra.RESULT";
    public static final String EXTRA_TIME_PREF_24_HOUR_FORMAT = "android.intent.extra.TIME_PREF_24_HOUR_FORMAT";
    public static final String EXTRA_TITLE = "android.intent.extra.TITLE";
    public static final String EXTRA_UID = "android.intent.extra.UID";
    public static final String EXTRA_UNINSTALL_ALL_USERS = "android.intent.extra.UNINSTALL_ALL_USERS";
    public static final String EXTRA_USER = "android.intent.extra.USER";
    public static final String EXTRA_USER_HANDLE = "android.intent.extra.user_handle";
    public static final int FILL_IN_ACTION = 1;
    public static final int FILL_IN_CATEGORIES = 4;
    public static final int FILL_IN_CLIP_DATA = 128;
    public static final int FILL_IN_COMPONENT = 8;
    public static final int FILL_IN_DATA = 2;
    public static final int FILL_IN_PACKAGE = 16;
    public static final int FILL_IN_SELECTOR = 64;
    public static final int FILL_IN_SOURCE_BOUNDS = 32;
    public static final int FLAG_ACTIVITY_BROUGHT_TO_FRONT = 4194304;
    public static final int FLAG_ACTIVITY_CLEAR_TASK = 32768;
    public static final int FLAG_ACTIVITY_CLEAR_TOP = 67108864;
    public static final int FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET = 524288;
    public static final int FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS = 8388608;
    public static final int FLAG_ACTIVITY_FORWARD_RESULT = 33554432;
    public static final int FLAG_ACTIVITY_LAUNCHED_FROM_HISTORY = 1048576;
    public static final int FLAG_ACTIVITY_MULTIPLE_TASK = 134217728;
    public static final int FLAG_ACTIVITY_NEW_DOCUMENT = 524288;
    public static final int FLAG_ACTIVITY_NEW_TASK = 268435456;
    public static final int FLAG_ACTIVITY_NO_ANIMATION = 65536;
    public static final int FLAG_ACTIVITY_NO_HISTORY = 1073741824;
    public static final int FLAG_ACTIVITY_NO_USER_ACTION = 262144;
    public static final int FLAG_ACTIVITY_PREVIOUS_IS_TOP = 16777216;
    public static final int FLAG_ACTIVITY_REORDER_TO_FRONT = 131072;
    public static final int FLAG_ACTIVITY_RESET_TASK_IF_NEEDED = 2097152;
    public static final int FLAG_ACTIVITY_RETAIN_IN_RECENTS = 8192;
    public static final int FLAG_ACTIVITY_SINGLE_TOP = 536870912;
    public static final int FLAG_ACTIVITY_TASK_ON_HOME = 16384;
    public static final int FLAG_DEBUG_LOG_RESOLUTION = 8;
    public static final int FLAG_EXCLUDE_STOPPED_PACKAGES = 16;
    public static final int FLAG_FROM_BACKGROUND = 4;
    public static final int FLAG_GRANT_PERSISTABLE_URI_PERMISSION = 64;
    public static final int FLAG_GRANT_PREFIX_URI_PERMISSION = 128;
    public static final int FLAG_GRANT_READ_URI_PERMISSION = 1;
    public static final int FLAG_GRANT_WRITE_URI_PERMISSION = 2;
    public static final int FLAG_INCLUDE_STOPPED_PACKAGES = 32;
    public static final int FLAG_RECEIVER_BOOT_UPGRADE = 33554432;
    public static final int FLAG_RECEIVER_FOREGROUND = 268435456;
    public static final int FLAG_RECEIVER_NO_ABORT = 134217728;
    public static final int FLAG_RECEIVER_REGISTERED_ONLY = 1073741824;
    public static final int FLAG_RECEIVER_REGISTERED_ONLY_BEFORE_BOOT = 67108864;
    public static final int FLAG_RECEIVER_REPLACE_PENDING = 536870912;
    public static final int IMMUTABLE_FLAGS = 195;
    public static final String METADATA_DOCK_HOME = "android.dock_home";
    public static final String METADATA_SETUP_VERSION = "android.SETUP_VERSION";
    private static final String TAG_CATEGORIES = "categories";
    private static final String TAG_EXTRA = "extra";
    public static final String UPDATE_POWER_MENU = "android.intent.action.UPDATE_POWER_MENU";
    public static final int URI_ALLOW_UNSAFE = 4;
    public static final int URI_ANDROID_APP_SCHEME = 2;
    public static final int URI_INTENT_SCHEME = 1;
    private String mAction;
    private ArraySet<String> mCategories;
    private ClipData mClipData;
    private ComponentName mComponent;
    private int mContentUserHint;
    private Uri mData;
    private Bundle mExtras;
    private int mFlags;
    private String mPackage;
    private Intent mSelector;
    private Rect mSourceBounds;
    private String mType;

    /* loaded from: source-9557208-dex2jar.jar:android/content/Intent$FilterComparison.class */
    public static final class FilterComparison {
        private final int mHashCode;
        private final Intent mIntent;

        public FilterComparison(Intent intent) {
            this.mIntent = intent;
            this.mHashCode = intent.filterHashCode();
        }

        public boolean equals(Object obj) {
            if (obj instanceof FilterComparison) {
                return this.mIntent.filterEquals(((FilterComparison) obj).mIntent);
            }
            return false;
        }

        public Intent getIntent() {
            return this.mIntent;
        }

        public int hashCode() {
            return this.mHashCode;
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/content/Intent$ShortcutIconResource.class */
    public static class ShortcutIconResource implements Parcelable {
        public static final Parcelable.Creator<ShortcutIconResource> CREATOR = new Parcelable.Creator<ShortcutIconResource>() { // from class: android.content.Intent.ShortcutIconResource.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public ShortcutIconResource createFromParcel(Parcel parcel) {
                ShortcutIconResource shortcutIconResource = new ShortcutIconResource();
                shortcutIconResource.packageName = parcel.readString();
                shortcutIconResource.resourceName = parcel.readString();
                return shortcutIconResource;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public ShortcutIconResource[] newArray(int i) {
                return new ShortcutIconResource[i];
            }
        };
        public String packageName;
        public String resourceName;

        public static ShortcutIconResource fromContext(Context context, int i) {
            ShortcutIconResource shortcutIconResource = new ShortcutIconResource();
            shortcutIconResource.packageName = context.getPackageName();
            shortcutIconResource.resourceName = context.getResources().getResourceName(i);
            return shortcutIconResource;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String toString() {
            return this.resourceName;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.packageName);
            parcel.writeString(this.resourceName);
        }
    }

    public Intent() {
        this.mContentUserHint = -2;
    }

    public Intent(Context context, Class<?> cls) {
        this.mContentUserHint = -2;
        this.mComponent = new ComponentName(context, cls);
    }

    public Intent(Intent intent) {
        this.mContentUserHint = -2;
        this.mAction = intent.mAction;
        this.mData = intent.mData;
        this.mType = intent.mType;
        this.mPackage = intent.mPackage;
        this.mComponent = intent.mComponent;
        this.mFlags = intent.mFlags;
        this.mContentUserHint = intent.mContentUserHint;
        if (intent.mCategories != null) {
            this.mCategories = new ArraySet<>(intent.mCategories);
        }
        if (intent.mExtras != null) {
            this.mExtras = new Bundle(intent.mExtras);
        }
        if (intent.mSourceBounds != null) {
            this.mSourceBounds = new Rect(intent.mSourceBounds);
        }
        if (intent.mSelector != null) {
            this.mSelector = new Intent(intent.mSelector);
        }
        if (intent.mClipData != null) {
            this.mClipData = new ClipData(intent.mClipData);
        }
    }

    private Intent(Intent intent, boolean z) {
        this.mContentUserHint = -2;
        this.mAction = intent.mAction;
        this.mData = intent.mData;
        this.mType = intent.mType;
        this.mPackage = intent.mPackage;
        this.mComponent = intent.mComponent;
        if (intent.mCategories != null) {
            this.mCategories = new ArraySet<>(intent.mCategories);
        }
    }

    protected Intent(Parcel parcel) {
        this.mContentUserHint = -2;
        readFromParcel(parcel);
    }

    public Intent(String str) {
        this.mContentUserHint = -2;
        setAction(str);
    }

    public Intent(String str, Uri uri) {
        this.mContentUserHint = -2;
        setAction(str);
        this.mData = uri;
    }

    public Intent(String str, Uri uri, Context context, Class<?> cls) {
        this.mContentUserHint = -2;
        setAction(str);
        this.mData = uri;
        this.mComponent = new ComponentName(context, cls);
    }

    public static Intent createChooser(Intent intent, CharSequence charSequence) {
        return createChooser(intent, charSequence, null);
    }

    public static Intent createChooser(Intent intent, CharSequence charSequence, IntentSender intentSender) {
        Intent intent2 = new Intent(ACTION_CHOOSER);
        intent2.putExtra(EXTRA_INTENT, intent);
        if (charSequence != null) {
            intent2.putExtra(EXTRA_TITLE, charSequence);
        }
        if (intentSender != null) {
            intent2.putExtra(EXTRA_CHOSEN_COMPONENT_INTENT_SENDER, intentSender);
        }
        int flags = intent.getFlags() & 195;
        if (flags != 0) {
            ClipData clipData = intent.getClipData();
            ClipData clipData2 = clipData;
            if (clipData == null) {
                clipData2 = clipData;
                if (intent.getData() != null) {
                    clipData2 = new ClipData(null, intent.getType() != null ? new String[]{intent.getType()} : new String[0], new ClipData.Item(intent.getData()));
                }
            }
            if (clipData2 != null) {
                intent2.setClipData(clipData2);
                intent2.addFlags(flags);
            }
        }
        return intent2;
    }

    @Deprecated
    public static Intent getIntent(String str) throws URISyntaxException {
        return parseUri(str, 0);
    }

    public static Intent getIntentOld(String str) throws URISyntaxException {
        return getIntentOld(str, 0);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x008b, code lost:
        if (r0 > r0) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x01d6, code lost:
        throw new java.net.URISyntaxException(r8, "EXTRA missing '='", r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0205, code lost:
        if (r0 >= r0) goto L96;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static android.content.Intent getIntentOld(java.lang.String r8, int r9) throws java.net.URISyntaxException {
        /*
            Method dump skipped, instructions count: 948
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.content.Intent.getIntentOld(java.lang.String, int):android.content.Intent");
    }

    public static boolean isAccessUriMode(int i) {
        return (i & 3) != 0;
    }

    private static ClipData.Item makeClipItem(ArrayList<Uri> arrayList, ArrayList<CharSequence> arrayList2, ArrayList<String> arrayList3, int i) {
        return new ClipData.Item(arrayList2 != null ? arrayList2.get(i) : null, arrayList3 != null ? arrayList3.get(i) : null, null, arrayList != null ? arrayList.get(i) : null);
    }

    public static Intent makeMainActivity(ComponentName componentName) {
        Intent intent = new Intent(ACTION_MAIN);
        intent.setComponent(componentName);
        intent.addCategory(CATEGORY_LAUNCHER);
        return intent;
    }

    public static Intent makeMainSelectorActivity(String str, String str2) {
        Intent intent = new Intent(ACTION_MAIN);
        intent.addCategory(CATEGORY_LAUNCHER);
        Intent intent2 = new Intent();
        intent2.setAction(str);
        intent2.addCategory(str2);
        intent.setSelector(intent2);
        return intent;
    }

    public static Intent makeRestartActivityTask(ComponentName componentName) {
        Intent makeMainActivity = makeMainActivity(componentName);
        makeMainActivity.addFlags(268468224);
        return makeMainActivity;
    }

    public static String normalizeMimeType(String str) {
        String str2;
        if (str == null) {
            str2 = null;
        } else {
            String lowerCase = str.trim().toLowerCase(Locale.ROOT);
            int indexOf = lowerCase.indexOf(59);
            str2 = lowerCase;
            if (indexOf != -1) {
                return lowerCase.substring(0, indexOf);
            }
        }
        return str2;
    }

    public static Intent parseIntent(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        Intent intent = new Intent();
        TypedArray obtainAttributes = resources.obtainAttributes(attributeSet, R.styleable.Intent);
        intent.setAction(obtainAttributes.getString(2));
        String string = obtainAttributes.getString(3);
        intent.setDataAndType(string != null ? Uri.parse(string) : null, obtainAttributes.getString(1));
        String string2 = obtainAttributes.getString(0);
        String string3 = obtainAttributes.getString(4);
        if (string2 != null && string3 != null) {
            intent.setComponent(new ComponentName(string2, string3));
        }
        obtainAttributes.recycle();
        int depth = xmlPullParser.getDepth();
        while (true) {
            int next = xmlPullParser.next();
            if (next == 1 || (next == 3 && xmlPullParser.getDepth() <= depth)) {
                break;
            } else if (next != 3 && next != 4) {
                String name = xmlPullParser.getName();
                if (name.equals(TAG_CATEGORIES)) {
                    TypedArray obtainAttributes2 = resources.obtainAttributes(attributeSet, R.styleable.IntentCategory);
                    String string4 = obtainAttributes2.getString(0);
                    obtainAttributes2.recycle();
                    if (string4 != null) {
                        intent.addCategory(string4);
                    }
                    XmlUtils.skipCurrentTag(xmlPullParser);
                } else if (name.equals("extra")) {
                    if (intent.mExtras == null) {
                        intent.mExtras = new Bundle();
                    }
                    resources.parseBundleExtra("extra", attributeSet, intent.mExtras);
                    XmlUtils.skipCurrentTag(xmlPullParser);
                } else {
                    XmlUtils.skipCurrentTag(xmlPullParser);
                }
            }
        }
        return intent;
    }

    public static Intent parseUri(String str, int i) throws URISyntaxException {
        int i2;
        String str2;
        Intent intent;
        Intent intent2;
        String str3;
        boolean z;
        boolean z2;
        Intent intent3;
        String str4;
        int i3 = 0;
        try {
            boolean startsWith = str.startsWith("android-app:");
            if ((i & 3) != 0 && !str.startsWith("intent:") && !startsWith) {
                intent2 = new Intent("android.intent.action.VIEW");
                i3 = 0;
                try {
                    intent2.setData(Uri.parse(str));
                    return intent2;
                } catch (IllegalArgumentException e) {
                    throw new URISyntaxException(str, e.getMessage());
                }
            }
            int lastIndexOf = str.lastIndexOf("#");
            if (lastIndexOf == -1) {
                i2 = lastIndexOf;
                if (!startsWith) {
                    return new Intent("android.intent.action.VIEW", Uri.parse(str));
                }
            } else {
                i2 = lastIndexOf;
                if (!str.startsWith("#Intent;", lastIndexOf)) {
                    if (!startsWith) {
                        return getIntentOld(str, i);
                    }
                    i2 = -1;
                }
            }
            int i4 = i2;
            Intent intent4 = new Intent("android.intent.action.VIEW");
            boolean z3 = false;
            boolean z4 = false;
            String str5 = null;
            if (i2 >= 0) {
                str2 = str.substring(0, i2);
                i2 += 8;
                intent = intent4;
            } else {
                str2 = str;
                intent = intent4;
            }
            while (i2 >= 0 && !str.startsWith("end", i2)) {
                int i5 = i2;
                int indexOf = str.indexOf(61, i2);
                int i6 = indexOf;
                if (indexOf < 0) {
                    i6 = i2 - 1;
                }
                int indexOf2 = str.indexOf(59, i2);
                String decode = i6 < indexOf2 ? Uri.decode(str.substring(i6 + 1, indexOf2)) : "";
                int i7 = i2;
                if (str.startsWith("action=", i2)) {
                    int i8 = i2;
                    intent.setAction(decode);
                    z = z3;
                    z2 = z4;
                    intent3 = intent;
                    str4 = str5;
                    if (!z4) {
                        z = true;
                        z2 = z4;
                        intent3 = intent;
                        str4 = str5;
                    }
                } else if (str.startsWith("category=", i2)) {
                    int i9 = i2;
                    intent.addCategory(decode);
                    z = z3;
                    z2 = z4;
                    intent3 = intent;
                    str4 = str5;
                } else if (str.startsWith("type=", i2)) {
                    int i10 = i2;
                    intent.mType = decode;
                    z = z3;
                    z2 = z4;
                    intent3 = intent;
                    str4 = str5;
                } else if (str.startsWith("launchFlags=", i2)) {
                    int i11 = i2;
                    intent.mFlags = Integer.decode(decode).intValue();
                    z = z3;
                    z2 = z4;
                    intent3 = intent;
                    str4 = str5;
                    if ((i & 4) == 0) {
                        intent.mFlags &= -196;
                        z = z3;
                        z2 = z4;
                        intent3 = intent;
                        str4 = str5;
                    }
                } else if (str.startsWith("package=", i2)) {
                    int i12 = i2;
                    intent.mPackage = decode;
                    z = z3;
                    z2 = z4;
                    intent3 = intent;
                    str4 = str5;
                } else if (str.startsWith("component=", i2)) {
                    int i13 = i2;
                    intent.mComponent = ComponentName.unflattenFromString(decode);
                    z = z3;
                    z2 = z4;
                    intent3 = intent;
                    str4 = str5;
                } else if (str.startsWith("scheme=", i2)) {
                    if (z4) {
                        intent.mData = Uri.parse(decode + ":");
                        z = z3;
                        z2 = z4;
                        intent3 = intent;
                        str4 = str5;
                    } else {
                        str4 = decode;
                        z = z3;
                        z2 = z4;
                        intent3 = intent;
                    }
                } else if (str.startsWith("sourceBounds=", i2)) {
                    int i14 = i2;
                    intent.mSourceBounds = Rect.unflattenFromString(decode);
                    z = z3;
                    z2 = z4;
                    intent3 = intent;
                    str4 = str5;
                } else if (indexOf2 == i2 + 3 && str.startsWith("SEL", i2)) {
                    int i15 = i2;
                    intent3 = new Intent();
                    z2 = true;
                    z = z3;
                    str4 = str5;
                } else {
                    String decode2 = Uri.decode(str.substring(i2 + 2, i6));
                    int i16 = i2;
                    if (intent.mExtras == null) {
                        int i17 = i2;
                        intent.mExtras = new Bundle();
                    }
                    int i18 = i2;
                    Bundle bundle = intent.mExtras;
                    int i19 = i2;
                    if (str.startsWith("S.", i2)) {
                        int i20 = i2;
                        bundle.putString(decode2, decode);
                        z = z3;
                        z2 = z4;
                        intent3 = intent;
                        str4 = str5;
                    } else if (str.startsWith("B.", i2)) {
                        int i21 = i2;
                        bundle.putBoolean(decode2, Boolean.parseBoolean(decode));
                        z = z3;
                        z2 = z4;
                        intent3 = intent;
                        str4 = str5;
                    } else if (str.startsWith("b.", i2)) {
                        int i22 = i2;
                        bundle.putByte(decode2, Byte.parseByte(decode));
                        z = z3;
                        z2 = z4;
                        intent3 = intent;
                        str4 = str5;
                    } else if (str.startsWith("c.", i2)) {
                        int i23 = i2;
                        bundle.putChar(decode2, decode.charAt(0));
                        z = z3;
                        z2 = z4;
                        intent3 = intent;
                        str4 = str5;
                    } else if (str.startsWith("d.", i2)) {
                        int i24 = i2;
                        bundle.putDouble(decode2, Double.parseDouble(decode));
                        z = z3;
                        z2 = z4;
                        intent3 = intent;
                        str4 = str5;
                    } else if (str.startsWith("f.", i2)) {
                        int i25 = i2;
                        bundle.putFloat(decode2, Float.parseFloat(decode));
                        z = z3;
                        z2 = z4;
                        intent3 = intent;
                        str4 = str5;
                    } else if (str.startsWith("i.", i2)) {
                        int i26 = i2;
                        bundle.putInt(decode2, Integer.parseInt(decode));
                        z = z3;
                        z2 = z4;
                        intent3 = intent;
                        str4 = str5;
                    } else if (str.startsWith("l.", i2)) {
                        int i27 = i2;
                        bundle.putLong(decode2, Long.parseLong(decode));
                        z = z3;
                        z2 = z4;
                        intent3 = intent;
                        str4 = str5;
                    } else if (!str.startsWith("s.", i2)) {
                        throw new URISyntaxException(str, "unknown EXTRA type", i2);
                    } else {
                        int i28 = i2;
                        bundle.putShort(decode2, Short.parseShort(decode));
                        z = z3;
                        z2 = z4;
                        intent3 = intent;
                        str4 = str5;
                    }
                }
                i2 = indexOf2 + 1;
                z3 = z;
                z4 = z2;
                intent = intent3;
                str5 = str4;
            }
            Intent intent5 = intent;
            if (z4) {
                if (intent4.mPackage == null) {
                    int i29 = i2;
                    intent4.setSelector(intent);
                }
                intent5 = intent4;
            }
            intent2 = intent5;
            if (str2 != null) {
                if (str2.startsWith("intent:")) {
                    int i30 = i2;
                    String substring = str2.substring(7);
                    str3 = substring;
                    if (str5 != null) {
                        str3 = str5 + ':' + substring;
                    }
                } else {
                    int i31 = i2;
                    str3 = str2;
                    if (str2.startsWith("android-app:")) {
                        int i32 = i2;
                        if (str2.charAt(12) == '/') {
                            int i33 = i2;
                            if (str2.charAt(13) == '/') {
                                int i34 = i2;
                                int indexOf3 = str2.indexOf(47, 14);
                                if (indexOf3 < 0) {
                                    intent5.mPackage = str2.substring(14);
                                    if (!z3) {
                                        intent5.setAction(ACTION_MAIN);
                                    }
                                    str3 = "";
                                } else {
                                    intent5.mPackage = str2.substring(14, indexOf3);
                                    int i35 = i2;
                                    String str6 = null;
                                    int i36 = indexOf3;
                                    if (indexOf3 + 1 < str2.length()) {
                                        int i37 = i2;
                                        int indexOf4 = str2.indexOf(47, indexOf3 + 1);
                                        if (indexOf4 >= 0) {
                                            String substring2 = str2.substring(indexOf3 + 1, indexOf4);
                                            str6 = null;
                                            i36 = indexOf4;
                                            str5 = substring2;
                                            if (indexOf4 < str2.length()) {
                                                int i38 = i2;
                                                int indexOf5 = str2.indexOf(47, indexOf4 + 1);
                                                str6 = null;
                                                i36 = indexOf4;
                                                str5 = substring2;
                                                if (indexOf5 >= 0) {
                                                    str6 = str2.substring(indexOf4 + 1, indexOf5);
                                                    i36 = indexOf5;
                                                    str5 = substring2;
                                                }
                                            }
                                        } else {
                                            str5 = str2.substring(indexOf3 + 1);
                                            str6 = null;
                                            i36 = indexOf3;
                                        }
                                    }
                                    if (str5 == null) {
                                        if (!z3) {
                                            intent5.setAction(ACTION_MAIN);
                                        }
                                        str3 = "";
                                    } else {
                                        str3 = str6 == null ? str5 + ":" : str5 + "://" + str6 + str2.substring(i36);
                                    }
                                }
                            }
                        }
                        str3 = "";
                    }
                }
                int i39 = i2;
                intent2 = intent5;
                if (str3.length() > 0) {
                    i3 = i2;
                    try {
                        intent5.mData = Uri.parse(str3);
                        return intent5;
                    } catch (IllegalArgumentException e2) {
                        throw new URISyntaxException(str, e2.getMessage());
                    }
                }
            }
            return intent2;
        } catch (IndexOutOfBoundsException e3) {
            throw new URISyntaxException(str, "illegal Intent URI format", i3);
        }
    }

    public static Intent restoreFromXml(XmlPullParser xmlPullParser) throws IOException, XmlPullParserException {
        Intent intent = new Intent();
        int depth = xmlPullParser.getDepth();
        int attributeCount = xmlPullParser.getAttributeCount();
        while (true) {
            int i = attributeCount - 1;
            if (i < 0) {
                break;
            }
            String attributeName = xmlPullParser.getAttributeName(i);
            String attributeValue = xmlPullParser.getAttributeValue(i);
            if ("action".equals(attributeName)) {
                intent.setAction(attributeValue);
            } else if ("data".equals(attributeName)) {
                intent.setData(Uri.parse(attributeValue));
            } else if ("type".equals(attributeName)) {
                intent.setType(attributeValue);
            } else if ("component".equals(attributeName)) {
                intent.setComponent(ComponentName.unflattenFromString(attributeValue));
            } else if ("flags".equals(attributeName)) {
                intent.setFlags(Integer.valueOf(attributeValue, 16).intValue());
            } else {
                Log.e("Intent", "restoreFromXml: unknown attribute=" + attributeName);
            }
            attributeCount = i;
        }
        while (true) {
            int next = xmlPullParser.next();
            if (next == 1 || (next == 3 && xmlPullParser.getDepth() >= depth)) {
                break;
            } else if (next == 2) {
                String name = xmlPullParser.getName();
                if (TAG_CATEGORIES.equals(name)) {
                    int attributeCount2 = xmlPullParser.getAttributeCount();
                    while (true) {
                        int i2 = attributeCount2 - 1;
                        if (i2 >= 0) {
                            intent.addCategory(xmlPullParser.getAttributeValue(i2));
                            attributeCount2 = i2;
                        }
                    }
                } else {
                    Log.w("Intent", "restoreFromXml: unknown name=" + name);
                    XmlUtils.skipCurrentTag(xmlPullParser);
                }
            }
        }
        return intent;
    }

    private void toUriFragment(StringBuilder sb, String str, String str2, String str3, int i) {
        StringBuilder sb2 = new StringBuilder(128);
        toUriInner(sb2, str, str2, str3, i);
        if (this.mSelector != null) {
            sb2.append("SEL;");
            this.mSelector.toUriInner(sb2, this.mSelector.mData != null ? this.mSelector.mData.getScheme() : null, null, null, i);
        }
        if (sb2.length() > 0) {
            sb.append("#Intent;");
            sb.append((CharSequence) sb2);
            sb.append("end");
        }
    }

    private void toUriInner(StringBuilder sb, String str, String str2, String str3, int i) {
        if (str != null) {
            sb.append("scheme=").append(str).append(';');
        }
        if (this.mAction != null && !this.mAction.equals(str2)) {
            sb.append("action=").append(Uri.encode(this.mAction)).append(';');
        }
        if (this.mCategories != null) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= this.mCategories.size()) {
                    break;
                }
                sb.append("category=").append(Uri.encode(this.mCategories.valueAt(i3))).append(';');
                i2 = i3 + 1;
            }
        }
        if (this.mType != null) {
            sb.append("type=").append(Uri.encode(this.mType, BridgeUtil.SPLIT_MARK)).append(';');
        }
        if (this.mFlags != 0) {
            sb.append("launchFlags=0x").append(Integer.toHexString(this.mFlags)).append(';');
        }
        if (this.mPackage != null && !this.mPackage.equals(str3)) {
            sb.append("package=").append(Uri.encode(this.mPackage)).append(';');
        }
        if (this.mComponent != null) {
            sb.append("component=").append(Uri.encode(this.mComponent.flattenToShortString(), BridgeUtil.SPLIT_MARK)).append(';');
        }
        if (this.mSourceBounds != null) {
            sb.append("sourceBounds=").append(Uri.encode(this.mSourceBounds.flattenToString())).append(';');
        }
        if (this.mExtras != null) {
            for (String str4 : this.mExtras.keySet()) {
                Object obj = this.mExtras.get(str4);
                char c2 = obj instanceof String ? 'S' : obj instanceof Boolean ? 'B' : obj instanceof Byte ? 'b' : obj instanceof Character ? 'c' : obj instanceof Double ? 'd' : obj instanceof Float ? 'f' : obj instanceof Integer ? 'i' : obj instanceof Long ? 'l' : obj instanceof Short ? 's' : (char) 0;
                if (c2 != 0) {
                    sb.append(c2);
                    sb.append('.');
                    sb.append(Uri.encode(str4));
                    sb.append('=');
                    sb.append(Uri.encode(obj.toString()));
                    sb.append(';');
                }
            }
        }
    }

    public Intent addCategory(String str) {
        if (this.mCategories == null) {
            this.mCategories = new ArraySet<>();
        }
        this.mCategories.add(str.intern());
        return this;
    }

    public Intent addFlags(int i) {
        this.mFlags |= i;
        return this;
    }

    public Object clone() {
        return new Intent(this);
    }

    public Intent cloneFilter() {
        return new Intent(this, false);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        if (this.mExtras != null) {
            return this.mExtras.describeContents();
        }
        return 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x003e, code lost:
        if (r6.mType != null) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0059, code lost:
        if ((r7 & 2) != 0) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x008d, code lost:
        if ((r7 & 4) != 0) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00c6, code lost:
        if ((r7 & 16) != 0) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0140, code lost:
        if ((r7 & 128) != 0) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x019d, code lost:
        if ((r7 & 32) != 0) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x001c, code lost:
        if ((r7 & 1) != 0) goto L7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int fillIn(android.content.Intent r6, int r7) {
        /*
            Method dump skipped, instructions count: 567
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.content.Intent.fillIn(android.content.Intent, int):int");
    }

    public boolean filterEquals(Intent intent) {
        return intent != null && Objects.equals(this.mAction, intent.mAction) && Objects.equals(this.mData, intent.mData) && Objects.equals(this.mType, intent.mType) && Objects.equals(this.mPackage, intent.mPackage) && Objects.equals(this.mComponent, intent.mComponent) && Objects.equals(this.mCategories, intent.mCategories);
    }

    public int filterHashCode() {
        int i = 0;
        if (this.mAction != null) {
            i = 0 + this.mAction.hashCode();
        }
        int i2 = i;
        if (this.mData != null) {
            i2 = i + this.mData.hashCode();
        }
        int i3 = i2;
        if (this.mType != null) {
            i3 = i2 + this.mType.hashCode();
        }
        int i4 = i3;
        if (this.mPackage != null) {
            i4 = i3 + this.mPackage.hashCode();
        }
        int i5 = i4;
        if (this.mComponent != null) {
            i5 = i4 + this.mComponent.hashCode();
        }
        int i6 = i5;
        if (this.mCategories != null) {
            i6 = i5 + this.mCategories.hashCode();
        }
        return i6;
    }

    public void fixUris(int i) {
        Uri uri;
        Uri data = getData();
        if (data != null) {
            this.mData = ContentProvider.maybeAddUserId(data, i);
        }
        if (this.mClipData != null) {
            this.mClipData.fixUris(i);
        }
        String action = getAction();
        if (ACTION_SEND.equals(action)) {
            Uri uri2 = (Uri) getParcelableExtra(EXTRA_STREAM);
            if (uri2 != null) {
                putExtra(EXTRA_STREAM, ContentProvider.maybeAddUserId(uri2, i));
            }
        } else if (!ACTION_SEND_MULTIPLE.equals(action)) {
            if ((MediaStore.ACTION_IMAGE_CAPTURE.equals(action) || MediaStore.ACTION_IMAGE_CAPTURE_SECURE.equals(action) || MediaStore.ACTION_VIDEO_CAPTURE.equals(action)) && (uri = (Uri) getParcelableExtra(MediaStore.EXTRA_OUTPUT)) != null) {
                putExtra(MediaStore.EXTRA_OUTPUT, ContentProvider.maybeAddUserId(uri, i));
            }
        } else {
            ArrayList parcelableArrayListExtra = getParcelableArrayListExtra(EXTRA_STREAM);
            if (parcelableArrayListExtra == null) {
                return;
            }
            ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= parcelableArrayListExtra.size()) {
                    putParcelableArrayListExtra(EXTRA_STREAM, arrayList);
                    return;
                } else {
                    arrayList.add(ContentProvider.maybeAddUserId((Uri) parcelableArrayListExtra.get(i3), i));
                    i2 = i3 + 1;
                }
            }
        }
    }

    public String getAction() {
        return this.mAction;
    }

    public boolean[] getBooleanArrayExtra(String str) {
        if (this.mExtras == null) {
            return null;
        }
        return this.mExtras.getBooleanArray(str);
    }

    public boolean getBooleanExtra(String str, boolean z) {
        return this.mExtras == null ? z : this.mExtras.getBoolean(str, z);
    }

    public Bundle getBundleExtra(String str) {
        if (this.mExtras == null) {
            return null;
        }
        return this.mExtras.getBundle(str);
    }

    public byte[] getByteArrayExtra(String str) {
        if (this.mExtras == null) {
            return null;
        }
        return this.mExtras.getByteArray(str);
    }

    public byte getByteExtra(String str, byte b) {
        return this.mExtras == null ? b : this.mExtras.getByte(str, b).byteValue();
    }

    public Set<String> getCategories() {
        return this.mCategories;
    }

    public char[] getCharArrayExtra(String str) {
        if (this.mExtras == null) {
            return null;
        }
        return this.mExtras.getCharArray(str);
    }

    public char getCharExtra(String str, char c2) {
        return this.mExtras == null ? c2 : this.mExtras.getChar(str, c2);
    }

    public CharSequence[] getCharSequenceArrayExtra(String str) {
        if (this.mExtras == null) {
            return null;
        }
        return this.mExtras.getCharSequenceArray(str);
    }

    public ArrayList<CharSequence> getCharSequenceArrayListExtra(String str) {
        if (this.mExtras == null) {
            return null;
        }
        return this.mExtras.getCharSequenceArrayList(str);
    }

    public CharSequence getCharSequenceExtra(String str) {
        if (this.mExtras == null) {
            return null;
        }
        return this.mExtras.getCharSequence(str);
    }

    public ClipData getClipData() {
        return this.mClipData;
    }

    public ComponentName getComponent() {
        return this.mComponent;
    }

    public int getContentUserHint() {
        return this.mContentUserHint;
    }

    public Uri getData() {
        return this.mData;
    }

    public String getDataString() {
        if (this.mData != null) {
            return this.mData.toString();
        }
        return null;
    }

    public double[] getDoubleArrayExtra(String str) {
        if (this.mExtras == null) {
            return null;
        }
        return this.mExtras.getDoubleArray(str);
    }

    public double getDoubleExtra(String str, double d) {
        return this.mExtras == null ? d : this.mExtras.getDouble(str, d);
    }

    @Deprecated
    public Object getExtra(String str) {
        return getExtra(str, null);
    }

    @Deprecated
    public Object getExtra(String str, Object obj) {
        Object obj2 = obj;
        if (this.mExtras != null) {
            Object obj3 = this.mExtras.get(str);
            obj2 = obj;
            if (obj3 != null) {
                obj2 = obj3;
            }
        }
        return obj2;
    }

    public Bundle getExtras() {
        if (this.mExtras != null) {
            return new Bundle(this.mExtras);
        }
        return null;
    }

    public int getFlags() {
        return this.mFlags;
    }

    public float[] getFloatArrayExtra(String str) {
        if (this.mExtras == null) {
            return null;
        }
        return this.mExtras.getFloatArray(str);
    }

    public float getFloatExtra(String str, float f) {
        return this.mExtras == null ? f : this.mExtras.getFloat(str, f);
    }

    @Deprecated
    public IBinder getIBinderExtra(String str) {
        if (this.mExtras == null) {
            return null;
        }
        return this.mExtras.getIBinder(str);
    }

    public int[] getIntArrayExtra(String str) {
        if (this.mExtras == null) {
            return null;
        }
        return this.mExtras.getIntArray(str);
    }

    public int getIntExtra(String str, int i) {
        return this.mExtras == null ? i : this.mExtras.getInt(str, i);
    }

    public ArrayList<Integer> getIntegerArrayListExtra(String str) {
        if (this.mExtras == null) {
            return null;
        }
        return this.mExtras.getIntegerArrayList(str);
    }

    public long[] getLongArrayExtra(String str) {
        if (this.mExtras == null) {
            return null;
        }
        return this.mExtras.getLongArray(str);
    }

    public long getLongExtra(String str, long j) {
        return this.mExtras == null ? j : this.mExtras.getLong(str, j);
    }

    public String getPackage() {
        return this.mPackage;
    }

    public Parcelable[] getParcelableArrayExtra(String str) {
        if (this.mExtras == null) {
            return null;
        }
        return this.mExtras.getParcelableArray(str);
    }

    public <T extends Parcelable> ArrayList<T> getParcelableArrayListExtra(String str) {
        if (this.mExtras == null) {
            return null;
        }
        return this.mExtras.getParcelableArrayList(str);
    }

    public <T extends Parcelable> T getParcelableExtra(String str) {
        if (this.mExtras == null) {
            return null;
        }
        return (T) this.mExtras.getParcelable(str);
    }

    public String getScheme() {
        if (this.mData != null) {
            return this.mData.getScheme();
        }
        return null;
    }

    public Intent getSelector() {
        return this.mSelector;
    }

    public Serializable getSerializableExtra(String str) {
        if (this.mExtras == null) {
            return null;
        }
        return this.mExtras.getSerializable(str);
    }

    public short[] getShortArrayExtra(String str) {
        if (this.mExtras == null) {
            return null;
        }
        return this.mExtras.getShortArray(str);
    }

    public short getShortExtra(String str, short s) {
        return this.mExtras == null ? s : this.mExtras.getShort(str, s);
    }

    public Rect getSourceBounds() {
        return this.mSourceBounds;
    }

    public String[] getStringArrayExtra(String str) {
        if (this.mExtras == null) {
            return null;
        }
        return this.mExtras.getStringArray(str);
    }

    public ArrayList<String> getStringArrayListExtra(String str) {
        if (this.mExtras == null) {
            return null;
        }
        return this.mExtras.getStringArrayList(str);
    }

    public String getStringExtra(String str) {
        if (this.mExtras == null) {
            return null;
        }
        return this.mExtras.getString(str);
    }

    public String getType() {
        return this.mType;
    }

    public boolean hasCategory(String str) {
        return this.mCategories != null && this.mCategories.contains(str);
    }

    public boolean hasExtra(String str) {
        return this.mExtras != null && this.mExtras.containsKey(str);
    }

    public boolean hasFileDescriptors() {
        return this.mExtras != null && this.mExtras.hasFileDescriptors();
    }

    public boolean isDocument() {
        return (this.mFlags & 524288) == 524288;
    }

    public boolean isExcludingStopped() {
        return (this.mFlags & 48) == 16;
    }

    public boolean migrateExtraStreamToClipData() {
        boolean z;
        boolean z2;
        if (this.mExtras != null && this.mExtras.isParcelled()) {
            z2 = false;
        } else if (getClipData() != null) {
            return false;
        } else {
            String action = getAction();
            if (ACTION_CHOOSER.equals(action)) {
                try {
                    Intent intent = (Intent) getParcelableExtra(EXTRA_INTENT);
                    z = false;
                    if (intent != null) {
                        z = false | intent.migrateExtraStreamToClipData();
                    }
                } catch (ClassCastException e) {
                    z = false;
                }
                boolean z3 = z;
                try {
                    Parcelable[] parcelableArrayExtra = getParcelableArrayExtra(EXTRA_INITIAL_INTENTS);
                    z2 = z;
                    if (parcelableArrayExtra != null) {
                        int i = 0;
                        while (true) {
                            z2 = z;
                            z3 = z;
                            if (i >= parcelableArrayExtra.length) {
                                break;
                            }
                            boolean z4 = z;
                            Intent intent2 = (Intent) parcelableArrayExtra[i];
                            boolean z5 = z;
                            if (intent2 != null) {
                                z5 = z | intent2.migrateExtraStreamToClipData();
                            }
                            i++;
                            z = z5;
                        }
                    }
                } catch (ClassCastException e2) {
                    return z3;
                }
            } else if (ACTION_SEND.equals(action)) {
                try {
                    Uri uri = (Uri) getParcelableExtra(EXTRA_STREAM);
                    CharSequence charSequenceExtra = getCharSequenceExtra(EXTRA_TEXT);
                    String stringExtra = getStringExtra("android.intent.extra.HTML_TEXT");
                    if (uri == null && charSequenceExtra == null && stringExtra == null) {
                        return false;
                    }
                    setClipData(new ClipData(null, new String[]{getType()}, new ClipData.Item(charSequenceExtra, stringExtra, null, uri)));
                    addFlags(1);
                    return true;
                } catch (ClassCastException e3) {
                    return false;
                }
            } else if (!ACTION_SEND_MULTIPLE.equals(action)) {
                if (MediaStore.ACTION_IMAGE_CAPTURE.equals(action) || MediaStore.ACTION_IMAGE_CAPTURE_SECURE.equals(action) || MediaStore.ACTION_VIDEO_CAPTURE.equals(action)) {
                    try {
                        Uri uri2 = (Uri) getParcelableExtra(MediaStore.EXTRA_OUTPUT);
                        if (uri2 != null) {
                            setClipData(ClipData.newRawUri("", uri2));
                            addFlags(3);
                            return true;
                        }
                        return false;
                    } catch (ClassCastException e4) {
                        return false;
                    }
                }
                return false;
            } else {
                try {
                    ArrayList parcelableArrayListExtra = getParcelableArrayListExtra(EXTRA_STREAM);
                    ArrayList<CharSequence> charSequenceArrayListExtra = getCharSequenceArrayListExtra(EXTRA_TEXT);
                    ArrayList<String> stringArrayListExtra = getStringArrayListExtra("android.intent.extra.HTML_TEXT");
                    int i2 = -1;
                    if (parcelableArrayListExtra != null) {
                        i2 = parcelableArrayListExtra.size();
                    }
                    int i3 = i2;
                    if (charSequenceArrayListExtra != null) {
                        if (i2 >= 0 && i2 != charSequenceArrayListExtra.size()) {
                            return false;
                        }
                        i3 = charSequenceArrayListExtra.size();
                    }
                    int i4 = i3;
                    if (stringArrayListExtra != null) {
                        if (i3 >= 0 && i3 != stringArrayListExtra.size()) {
                            return false;
                        }
                        i4 = stringArrayListExtra.size();
                    }
                    if (i4 <= 0) {
                        return false;
                    }
                    ClipData clipData = new ClipData(null, new String[]{getType()}, makeClipItem(parcelableArrayListExtra, charSequenceArrayListExtra, stringArrayListExtra, 0));
                    int i5 = 1;
                    while (true) {
                        int i6 = i5;
                        if (i6 >= i4) {
                            setClipData(clipData);
                            addFlags(1);
                            return true;
                        }
                        clipData.addItem(makeClipItem(parcelableArrayListExtra, charSequenceArrayListExtra, stringArrayListExtra, i6));
                        i5 = i6 + 1;
                    }
                } catch (ClassCastException e5) {
                    return false;
                }
            }
        }
        return z2;
    }

    public void prepareToEnterProcess() {
        if (this.mContentUserHint == -2 || UserHandle.getAppId(Process.myUid()) == 1000) {
            return;
        }
        fixUris(this.mContentUserHint);
        this.mContentUserHint = -2;
    }

    public void prepareToLeaveProcess() {
        setAllowFds(false);
        if (this.mSelector != null) {
            this.mSelector.prepareToLeaveProcess();
        }
        if (this.mClipData != null) {
            this.mClipData.prepareToLeaveProcess();
        }
        if (this.mData == null || !StrictMode.vmFileUriExposureEnabled()) {
            return;
        }
        if ("android.intent.action.VIEW".equals(this.mAction) || ACTION_EDIT.equals(this.mAction) || ACTION_ATTACH_DATA.equals(this.mAction)) {
            this.mData.checkFileUriExposed("Intent.getData()");
        }
    }

    public Intent putCharSequenceArrayListExtra(String str, ArrayList<CharSequence> arrayList) {
        if (this.mExtras == null) {
            this.mExtras = new Bundle();
        }
        this.mExtras.putCharSequenceArrayList(str, arrayList);
        return this;
    }

    public Intent putExtra(String str, byte b) {
        if (this.mExtras == null) {
            this.mExtras = new Bundle();
        }
        this.mExtras.putByte(str, b);
        return this;
    }

    public Intent putExtra(String str, char c2) {
        if (this.mExtras == null) {
            this.mExtras = new Bundle();
        }
        this.mExtras.putChar(str, c2);
        return this;
    }

    public Intent putExtra(String str, double d) {
        if (this.mExtras == null) {
            this.mExtras = new Bundle();
        }
        this.mExtras.putDouble(str, d);
        return this;
    }

    public Intent putExtra(String str, float f) {
        if (this.mExtras == null) {
            this.mExtras = new Bundle();
        }
        this.mExtras.putFloat(str, f);
        return this;
    }

    public Intent putExtra(String str, int i) {
        if (this.mExtras == null) {
            this.mExtras = new Bundle();
        }
        this.mExtras.putInt(str, i);
        return this;
    }

    public Intent putExtra(String str, long j) {
        if (this.mExtras == null) {
            this.mExtras = new Bundle();
        }
        this.mExtras.putLong(str, j);
        return this;
    }

    public Intent putExtra(String str, Bundle bundle) {
        if (this.mExtras == null) {
            this.mExtras = new Bundle();
        }
        this.mExtras.putBundle(str, bundle);
        return this;
    }

    @Deprecated
    public Intent putExtra(String str, IBinder iBinder) {
        if (this.mExtras == null) {
            this.mExtras = new Bundle();
        }
        this.mExtras.putIBinder(str, iBinder);
        return this;
    }

    public Intent putExtra(String str, Parcelable parcelable) {
        if (this.mExtras == null) {
            this.mExtras = new Bundle();
        }
        this.mExtras.putParcelable(str, parcelable);
        return this;
    }

    public Intent putExtra(String str, Serializable serializable) {
        if (this.mExtras == null) {
            this.mExtras = new Bundle();
        }
        this.mExtras.putSerializable(str, serializable);
        return this;
    }

    public Intent putExtra(String str, CharSequence charSequence) {
        if (this.mExtras == null) {
            this.mExtras = new Bundle();
        }
        this.mExtras.putCharSequence(str, charSequence);
        return this;
    }

    public Intent putExtra(String str, String str2) {
        if (this.mExtras == null) {
            this.mExtras = new Bundle();
        }
        this.mExtras.putString(str, str2);
        return this;
    }

    public Intent putExtra(String str, short s) {
        if (this.mExtras == null) {
            this.mExtras = new Bundle();
        }
        this.mExtras.putShort(str, s);
        return this;
    }

    public Intent putExtra(String str, boolean z) {
        if (this.mExtras == null) {
            this.mExtras = new Bundle();
        }
        this.mExtras.putBoolean(str, z);
        return this;
    }

    public Intent putExtra(String str, byte[] bArr) {
        if (this.mExtras == null) {
            this.mExtras = new Bundle();
        }
        this.mExtras.putByteArray(str, bArr);
        return this;
    }

    public Intent putExtra(String str, char[] cArr) {
        if (this.mExtras == null) {
            this.mExtras = new Bundle();
        }
        this.mExtras.putCharArray(str, cArr);
        return this;
    }

    public Intent putExtra(String str, double[] dArr) {
        if (this.mExtras == null) {
            this.mExtras = new Bundle();
        }
        this.mExtras.putDoubleArray(str, dArr);
        return this;
    }

    public Intent putExtra(String str, float[] fArr) {
        if (this.mExtras == null) {
            this.mExtras = new Bundle();
        }
        this.mExtras.putFloatArray(str, fArr);
        return this;
    }

    public Intent putExtra(String str, int[] iArr) {
        if (this.mExtras == null) {
            this.mExtras = new Bundle();
        }
        this.mExtras.putIntArray(str, iArr);
        return this;
    }

    public Intent putExtra(String str, long[] jArr) {
        if (this.mExtras == null) {
            this.mExtras = new Bundle();
        }
        this.mExtras.putLongArray(str, jArr);
        return this;
    }

    public Intent putExtra(String str, Parcelable[] parcelableArr) {
        if (this.mExtras == null) {
            this.mExtras = new Bundle();
        }
        this.mExtras.putParcelableArray(str, parcelableArr);
        return this;
    }

    public Intent putExtra(String str, CharSequence[] charSequenceArr) {
        if (this.mExtras == null) {
            this.mExtras = new Bundle();
        }
        this.mExtras.putCharSequenceArray(str, charSequenceArr);
        return this;
    }

    public Intent putExtra(String str, String[] strArr) {
        if (this.mExtras == null) {
            this.mExtras = new Bundle();
        }
        this.mExtras.putStringArray(str, strArr);
        return this;
    }

    public Intent putExtra(String str, short[] sArr) {
        if (this.mExtras == null) {
            this.mExtras = new Bundle();
        }
        this.mExtras.putShortArray(str, sArr);
        return this;
    }

    public Intent putExtra(String str, boolean[] zArr) {
        if (this.mExtras == null) {
            this.mExtras = new Bundle();
        }
        this.mExtras.putBooleanArray(str, zArr);
        return this;
    }

    public Intent putExtras(Intent intent) {
        if (intent.mExtras != null) {
            if (this.mExtras != null) {
                this.mExtras.putAll(intent.mExtras);
                return this;
            }
            this.mExtras = new Bundle(intent.mExtras);
        }
        return this;
    }

    public Intent putExtras(Bundle bundle) {
        if (this.mExtras == null) {
            this.mExtras = new Bundle();
        }
        this.mExtras.putAll(bundle);
        return this;
    }

    public Intent putIntegerArrayListExtra(String str, ArrayList<Integer> arrayList) {
        if (this.mExtras == null) {
            this.mExtras = new Bundle();
        }
        this.mExtras.putIntegerArrayList(str, arrayList);
        return this;
    }

    public Intent putParcelableArrayListExtra(String str, ArrayList<? extends Parcelable> arrayList) {
        if (this.mExtras == null) {
            this.mExtras = new Bundle();
        }
        this.mExtras.putParcelableArrayList(str, arrayList);
        return this;
    }

    public Intent putStringArrayListExtra(String str, ArrayList<String> arrayList) {
        if (this.mExtras == null) {
            this.mExtras = new Bundle();
        }
        this.mExtras.putStringArrayList(str, arrayList);
        return this;
    }

    public void readFromParcel(Parcel parcel) {
        setAction(parcel.readString());
        this.mData = Uri.CREATOR.createFromParcel(parcel);
        this.mType = parcel.readString();
        this.mFlags = parcel.readInt();
        this.mPackage = parcel.readString();
        this.mComponent = ComponentName.readFromParcel(parcel);
        if (parcel.readInt() != 0) {
            this.mSourceBounds = Rect.CREATOR.createFromParcel(parcel);
        }
        int readInt = parcel.readInt();
        if (readInt > 0) {
            this.mCategories = new ArraySet<>();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= readInt) {
                    break;
                }
                this.mCategories.add(parcel.readString().intern());
                i = i2 + 1;
            }
        } else {
            this.mCategories = null;
        }
        if (parcel.readInt() != 0) {
            this.mSelector = new Intent(parcel);
        }
        if (parcel.readInt() != 0) {
            this.mClipData = new ClipData(parcel);
        }
        this.mContentUserHint = parcel.readInt();
        this.mExtras = parcel.readBundle();
    }

    public void removeCategory(String str) {
        if (this.mCategories != null) {
            this.mCategories.remove(str);
            if (this.mCategories.size() == 0) {
                this.mCategories = null;
            }
        }
    }

    public void removeExtra(String str) {
        if (this.mExtras != null) {
            this.mExtras.remove(str);
            if (this.mExtras.size() == 0) {
                this.mExtras = null;
            }
        }
    }

    public Intent replaceExtras(Intent intent) {
        this.mExtras = intent.mExtras != null ? new Bundle(intent.mExtras) : null;
        return this;
    }

    public Intent replaceExtras(Bundle bundle) {
        this.mExtras = bundle != null ? new Bundle(bundle) : null;
        return this;
    }

    public ComponentName resolveActivity(PackageManager packageManager) {
        if (this.mComponent != null) {
            return this.mComponent;
        }
        ResolveInfo resolveActivity = packageManager.resolveActivity(this, 65536);
        if (resolveActivity != null) {
            return new ComponentName(resolveActivity.activityInfo.applicationInfo.packageName, resolveActivity.activityInfo.name);
        }
        return null;
    }

    public ActivityInfo resolveActivityInfo(PackageManager packageManager, int i) {
        ActivityInfo activityInfo;
        if (this.mComponent != null) {
            try {
                activityInfo = packageManager.getActivityInfo(this.mComponent, i);
            } catch (PackageManager.NameNotFoundException e) {
                return null;
            }
        } else {
            ResolveInfo resolveActivity = packageManager.resolveActivity(this, 65536 | i);
            activityInfo = null;
            if (resolveActivity != null) {
                return resolveActivity.activityInfo;
            }
        }
        return activityInfo;
    }

    public ComponentName resolveSystemService(PackageManager packageManager, int i) {
        ComponentName componentName;
        if (this.mComponent == null) {
            List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(this, i);
            if (queryIntentServices != null) {
                ComponentName componentName2 = null;
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    componentName = componentName2;
                    if (i3 >= queryIntentServices.size()) {
                        break;
                    }
                    ResolveInfo resolveInfo = queryIntentServices.get(i3);
                    if ((resolveInfo.serviceInfo.applicationInfo.flags & 1) != 0) {
                        ComponentName componentName3 = new ComponentName(resolveInfo.serviceInfo.applicationInfo.packageName, resolveInfo.serviceInfo.name);
                        if (componentName2 != null) {
                            throw new IllegalStateException("Multiple system services handle " + this + ": " + componentName2 + ", " + componentName3);
                        }
                        componentName2 = componentName3;
                    }
                    i2 = i3 + 1;
                }
            } else {
                return null;
            }
        } else {
            componentName = this.mComponent;
        }
        return componentName;
    }

    public String resolveType(ContentResolver contentResolver) {
        if (this.mType != null) {
            return this.mType;
        }
        if (this.mData == null || !"content".equals(this.mData.getScheme())) {
            return null;
        }
        return contentResolver.getType(this.mData);
    }

    public String resolveType(Context context) {
        return resolveType(context.getContentResolver());
    }

    public String resolveTypeIfNeeded(ContentResolver contentResolver) {
        return this.mComponent != null ? this.mType : resolveType(contentResolver);
    }

    public void saveToXml(XmlSerializer xmlSerializer) throws IOException {
        if (this.mAction != null) {
            xmlSerializer.attribute(null, "action", this.mAction);
        }
        if (this.mData != null) {
            xmlSerializer.attribute(null, "data", this.mData.toString());
        }
        if (this.mType != null) {
            xmlSerializer.attribute(null, "type", this.mType);
        }
        if (this.mComponent != null) {
            xmlSerializer.attribute(null, "component", this.mComponent.flattenToShortString());
        }
        xmlSerializer.attribute(null, "flags", Integer.toHexString(getFlags()));
        if (this.mCategories == null) {
            return;
        }
        xmlSerializer.startTag(null, TAG_CATEGORIES);
        int size = this.mCategories.size();
        while (true) {
            int i = size - 1;
            if (i < 0) {
                xmlSerializer.endTag(null, TAG_CATEGORIES);
                return;
            } else {
                xmlSerializer.attribute(null, "category", this.mCategories.valueAt(i));
                size = i;
            }
        }
    }

    public Intent setAction(String str) {
        this.mAction = str != null ? str.intern() : null;
        return this;
    }

    public void setAllowFds(boolean z) {
        if (this.mExtras != null) {
            this.mExtras.setAllowFds(z);
        }
    }

    public Intent setClass(Context context, Class<?> cls) {
        this.mComponent = new ComponentName(context, cls);
        return this;
    }

    public Intent setClassName(Context context, String str) {
        this.mComponent = new ComponentName(context, str);
        return this;
    }

    public Intent setClassName(String str, String str2) {
        this.mComponent = new ComponentName(str, str2);
        return this;
    }

    public void setClipData(ClipData clipData) {
        this.mClipData = clipData;
    }

    public Intent setComponent(ComponentName componentName) {
        this.mComponent = componentName;
        return this;
    }

    public void setContentUserHint(int i) {
        this.mContentUserHint = i;
    }

    public Intent setData(Uri uri) {
        this.mData = uri;
        this.mType = null;
        return this;
    }

    public Intent setDataAndNormalize(Uri uri) {
        return setData(uri.normalizeScheme());
    }

    public Intent setDataAndType(Uri uri, String str) {
        this.mData = uri;
        this.mType = str;
        return this;
    }

    public Intent setDataAndTypeAndNormalize(Uri uri, String str) {
        return setDataAndType(uri.normalizeScheme(), normalizeMimeType(str));
    }

    public void setExtrasClassLoader(ClassLoader classLoader) {
        if (this.mExtras != null) {
            this.mExtras.setClassLoader(classLoader);
        }
    }

    public Intent setFlags(int i) {
        this.mFlags = i;
        return this;
    }

    public Intent setPackage(String str) {
        if (str == null || this.mSelector == null) {
            this.mPackage = str;
            return this;
        }
        throw new IllegalArgumentException("Can't set package name when selector is already set");
    }

    public void setSelector(Intent intent) {
        if (intent == this) {
            throw new IllegalArgumentException("Intent being set as a selector of itself");
        }
        if (intent != null && this.mPackage != null) {
            throw new IllegalArgumentException("Can't set selector when package name is already set");
        }
        this.mSelector = intent;
    }

    public void setSourceBounds(Rect rect) {
        if (rect != null) {
            this.mSourceBounds = new Rect(rect);
        } else {
            this.mSourceBounds = null;
        }
    }

    public Intent setType(String str) {
        this.mData = null;
        this.mType = str;
        return this;
    }

    public Intent setTypeAndNormalize(String str) {
        return setType(normalizeMimeType(str));
    }

    public String toInsecureString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("Intent { ");
        toShortString(sb, false, true, true, false);
        sb.append(" }");
        return sb.toString();
    }

    public String toInsecureStringWithClip() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("Intent { ");
        toShortString(sb, false, true, true, true);
        sb.append(" }");
        return sb.toString();
    }

    public String toShortString(boolean z, boolean z2, boolean z3, boolean z4) {
        StringBuilder sb = new StringBuilder(128);
        toShortString(sb, z, z2, z3, z4);
        return sb.toString();
    }

    public void toShortString(StringBuilder sb, boolean z, boolean z2, boolean z3, boolean z4) {
        boolean z5 = true;
        if (this.mAction != null) {
            sb.append("act=").append(this.mAction);
            z5 = false;
        }
        boolean z6 = z5;
        if (this.mCategories != null) {
            if (!z5) {
                sb.append(' ');
            }
            sb.append("cat=[");
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.mCategories.size()) {
                    break;
                }
                if (i2 > 0) {
                    sb.append(',');
                }
                sb.append(this.mCategories.valueAt(i2));
                i = i2 + 1;
            }
            sb.append("]");
            z6 = false;
        }
        boolean z7 = z6;
        if (this.mData != null) {
            if (!z6) {
                sb.append(' ');
            }
            z7 = false;
            sb.append("dat=");
            if (z) {
                sb.append(this.mData.toSafeString());
            } else {
                sb.append(this.mData);
            }
        }
        boolean z8 = z7;
        if (this.mType != null) {
            if (!z7) {
                sb.append(' ');
            }
            z8 = false;
            sb.append("typ=").append(this.mType);
        }
        boolean z9 = z8;
        if (this.mFlags != 0) {
            if (!z8) {
                sb.append(' ');
            }
            z9 = false;
            sb.append("flg=0x").append(Integer.toHexString(this.mFlags));
        }
        boolean z10 = z9;
        if (this.mPackage != null) {
            if (!z9) {
                sb.append(' ');
            }
            z10 = false;
            sb.append("pkg=").append(this.mPackage);
        }
        boolean z11 = z10;
        if (z2) {
            z11 = z10;
            if (this.mComponent != null) {
                if (!z10) {
                    sb.append(' ');
                }
                z11 = false;
                sb.append("cmp=").append(this.mComponent.flattenToShortString());
            }
        }
        boolean z12 = z11;
        if (this.mSourceBounds != null) {
            if (!z11) {
                sb.append(' ');
            }
            z12 = false;
            sb.append("bnds=").append(this.mSourceBounds.toShortString());
        }
        boolean z13 = z12;
        if (this.mClipData != null) {
            if (!z12) {
                sb.append(' ');
            }
            z13 = false;
            if (z4) {
                sb.append("clip={");
                this.mClipData.toShortString(sb);
                sb.append('}');
            } else {
                sb.append("(has clip)");
            }
        }
        boolean z14 = z13;
        if (z3) {
            z14 = z13;
            if (this.mExtras != null) {
                if (!z13) {
                    sb.append(' ');
                }
                z14 = false;
                sb.append("(has extras)");
            }
        }
        if (this.mContentUserHint != -2) {
            if (!z14) {
                sb.append(' ');
            }
            sb.append("u=").append(this.mContentUserHint);
        }
        if (this.mSelector != null) {
            sb.append(" sel=");
            this.mSelector.toShortString(sb, z, z2, z3, z4);
            sb.append(i.d);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("Intent { ");
        toShortString(sb, true, true, true, false);
        sb.append(" }");
        return sb.toString();
    }

    @Deprecated
    public String toURI() {
        return toUri(0);
    }

    public String toUri(int i) {
        String str;
        StringBuilder sb = new StringBuilder(128);
        if ((i & 2) != 0) {
            if (this.mPackage == null) {
                throw new IllegalArgumentException("Intent must include an explicit package name to build an android-app: " + this);
            }
            sb.append("android-app://");
            sb.append(this.mPackage);
            String str2 = null;
            if (this.mData != null) {
                String scheme = this.mData.getScheme();
                str2 = scheme;
                if (scheme != null) {
                    sb.append('/');
                    sb.append(scheme);
                    String encodedAuthority = this.mData.getEncodedAuthority();
                    str2 = scheme;
                    if (encodedAuthority != null) {
                        sb.append('/');
                        sb.append(encodedAuthority);
                        String encodedPath = this.mData.getEncodedPath();
                        if (encodedPath != null) {
                            sb.append(encodedPath);
                        }
                        String encodedQuery = this.mData.getEncodedQuery();
                        if (encodedQuery != null) {
                            sb.append('?');
                            sb.append(encodedQuery);
                        }
                        String encodedFragment = this.mData.getEncodedFragment();
                        str2 = scheme;
                        if (encodedFragment != null) {
                            sb.append('#');
                            sb.append(encodedFragment);
                            str2 = scheme;
                        }
                    }
                }
            }
            toUriFragment(sb, null, str2 == null ? ACTION_MAIN : "android.intent.action.VIEW", this.mPackage, i);
            return sb.toString();
        }
        if (this.mData != null) {
            String uri = this.mData.toString();
            str = null;
            String str3 = uri;
            if ((i & 1) != 0) {
                int length = uri.length();
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    str = null;
                    str3 = uri;
                    if (i3 >= length) {
                        break;
                    }
                    char charAt = uri.charAt(i3);
                    if ((charAt < 'a' || charAt > 'z') && !((charAt >= 'A' && charAt <= 'Z') || charAt == '.' || charAt == '-')) {
                        str = null;
                        str3 = uri;
                        if (charAt == ':') {
                            str = null;
                            str3 = uri;
                            if (i3 > 0) {
                                str = uri.substring(0, i3);
                                sb.append("intent:");
                                str3 = uri.substring(i3 + 1);
                            }
                        }
                    } else {
                        i2 = i3 + 1;
                    }
                }
            }
            sb.append(str3);
        } else {
            str = null;
            if ((i & 1) != 0) {
                sb.append("intent:");
                str = null;
            }
        }
        toUriFragment(sb, str, "android.intent.action.VIEW", null, i);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mAction);
        Uri.writeToParcel(parcel, this.mData);
        parcel.writeString(this.mType);
        parcel.writeInt(this.mFlags);
        parcel.writeString(this.mPackage);
        ComponentName.writeToParcel(this.mComponent, parcel);
        if (this.mSourceBounds != null) {
            parcel.writeInt(1);
            this.mSourceBounds.writeToParcel(parcel, i);
        } else {
            parcel.writeInt(0);
        }
        if (this.mCategories != null) {
            int size = this.mCategories.size();
            parcel.writeInt(size);
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= size) {
                    break;
                }
                parcel.writeString(this.mCategories.valueAt(i3));
                i2 = i3 + 1;
            }
        } else {
            parcel.writeInt(0);
        }
        if (this.mSelector != null) {
            parcel.writeInt(1);
            this.mSelector.writeToParcel(parcel, i);
        } else {
            parcel.writeInt(0);
        }
        if (this.mClipData != null) {
            parcel.writeInt(1);
            this.mClipData.writeToParcel(parcel, i);
        } else {
            parcel.writeInt(0);
        }
        parcel.writeInt(this.mContentUserHint);
        parcel.writeBundle(this.mExtras);
    }
}
