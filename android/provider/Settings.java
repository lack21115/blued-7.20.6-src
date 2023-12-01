package android.provider;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.IContentProvider;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.SQLException;
import android.net.Uri;
import android.os.Bundle;
import android.os.Process;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.UserHandle;
import android.text.TextUtils;
import android.util.AndroidException;
import android.util.Log;
import com.android.internal.widget.ILockSettings;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;

/* loaded from: source-9557208-dex2jar.jar:android/provider/Settings.class */
public final class Settings {
    public static final String ACTION_ACCESSIBILITY_SETTINGS = "android.settings.ACCESSIBILITY_SETTINGS";
    public static final String ACTION_ADD_ACCOUNT = "android.settings.ADD_ACCOUNT_SETTINGS";
    public static final String ACTION_AIRPLANE_MODE_SETTINGS = "android.settings.AIRPLANE_MODE_SETTINGS";
    public static final String ACTION_APN_SETTINGS = "android.settings.APN_SETTINGS";
    public static final String ACTION_APPLICATION_DETAILS_SETTINGS = "android.settings.APPLICATION_DETAILS_SETTINGS";
    public static final String ACTION_APPLICATION_DEVELOPMENT_SETTINGS = "android.settings.APPLICATION_DEVELOPMENT_SETTINGS";
    public static final String ACTION_APPLICATION_SETTINGS = "android.settings.APPLICATION_SETTINGS";
    public static final String ACTION_APP_NOTIFICATION_REDACTION = "android.settings.ACTION_APP_NOTIFICATION_REDACTION";
    public static final String ACTION_APP_NOTIFICATION_SETTINGS = "android.settings.APP_NOTIFICATION_SETTINGS";
    public static final String ACTION_APP_OPS_DETAILS_SETTINGS = "android.settings.APP_OPS_DETAILS_SETTINGS";
    public static final String ACTION_APP_OPS_SETTINGS = "android.settings.APP_OPS_SETTINGS";
    public static final String ACTION_BATTERY_SAVER_SETTINGS = "android.settings.BATTERY_SAVER_SETTINGS";
    public static final String ACTION_BLUETOOTH_SETTINGS = "android.settings.BLUETOOTH_SETTINGS";
    public static final String ACTION_CAPTIONING_SETTINGS = "android.settings.CAPTIONING_SETTINGS";
    public static final String ACTION_CAST_SETTINGS = "android.settings.CAST_SETTINGS";
    public static final String ACTION_CONDITION_PROVIDER_SETTINGS = "android.settings.ACTION_CONDITION_PROVIDER_SETTINGS";
    public static final String ACTION_DATA_ROAMING_SETTINGS = "android.settings.DATA_ROAMING_SETTINGS";
    public static final String ACTION_DATE_SETTINGS = "android.settings.DATE_SETTINGS";
    public static final String ACTION_DEVICE_INFO_SETTINGS = "android.settings.DEVICE_INFO_SETTINGS";
    public static final String ACTION_DISPLAY_SETTINGS = "android.settings.DISPLAY_SETTINGS";
    public static final String ACTION_DREAM_SETTINGS = "android.settings.DREAM_SETTINGS";
    public static final String ACTION_HOME_SETTINGS = "android.settings.HOME_SETTINGS";
    public static final String ACTION_INPUT_METHOD_SETTINGS = "android.settings.INPUT_METHOD_SETTINGS";
    public static final String ACTION_INPUT_METHOD_SUBTYPE_SETTINGS = "android.settings.INPUT_METHOD_SUBTYPE_SETTINGS";
    public static final String ACTION_INTERNAL_STORAGE_SETTINGS = "android.settings.INTERNAL_STORAGE_SETTINGS";
    public static final String ACTION_LOCALE_SETTINGS = "android.settings.LOCALE_SETTINGS";
    public static final String ACTION_LOCATION_SOURCE_SETTINGS = "android.settings.LOCATION_SOURCE_SETTINGS";
    public static final String ACTION_MANAGE_ALL_APPLICATIONS_SETTINGS = "android.settings.MANAGE_ALL_APPLICATIONS_SETTINGS";
    public static final String ACTION_MANAGE_APPLICATIONS_SETTINGS = "android.settings.MANAGE_APPLICATIONS_SETTINGS";
    public static final String ACTION_MEMORY_CARD_SETTINGS = "android.settings.MEMORY_CARD_SETTINGS";
    public static final String ACTION_MONITORING_CERT_INFO = "com.android.settings.MONITORING_CERT_INFO";
    public static final String ACTION_NETWORK_OPERATOR_SETTINGS = "android.settings.NETWORK_OPERATOR_SETTINGS";
    public static final String ACTION_NFCSHARING_SETTINGS = "android.settings.NFCSHARING_SETTINGS";
    public static final String ACTION_NFC_PAYMENT_SETTINGS = "android.settings.NFC_PAYMENT_SETTINGS";
    public static final String ACTION_NFC_SETTINGS = "android.settings.NFC_SETTINGS";
    public static final String ACTION_NOTIFICATION_LISTENER_SETTINGS = "android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS";
    public static final String ACTION_NOTIFICATION_SETTINGS = "android.settings.NOTIFICATION_SETTINGS";
    public static final String ACTION_PAIRING_SETTINGS = "android.settings.PAIRING_SETTINGS";
    public static final String ACTION_PRINT_SETTINGS = "android.settings.ACTION_PRINT_SETTINGS";
    public static final String ACTION_PRIVACY_SETTINGS = "android.settings.PRIVACY_SETTINGS";
    public static final String ACTION_QUICK_LAUNCH_SETTINGS = "android.settings.QUICK_LAUNCH_SETTINGS";
    public static final String ACTION_SEARCH_SETTINGS = "android.search.action.SEARCH_SETTINGS";
    public static final String ACTION_SECURITY_SETTINGS = "android.settings.SECURITY_SETTINGS";
    public static final String ACTION_SETTINGS = "android.settings.SETTINGS";
    public static final String ACTION_SHOW_INPUT_METHOD_PICKER = "android.settings.SHOW_INPUT_METHOD_PICKER";
    public static final String ACTION_SHOW_REGULATORY_INFO = "android.settings.SHOW_REGULATORY_INFO";
    public static final String ACTION_SOUND_SETTINGS = "android.settings.SOUND_SETTINGS";
    public static final String ACTION_SYNC_SETTINGS = "android.settings.SYNC_SETTINGS";
    public static final String ACTION_SYSTEM_UPDATE_SETTINGS = "android.settings.SYSTEM_UPDATE_SETTINGS";
    public static final String ACTION_TRUSTED_CREDENTIALS_USER = "com.android.settings.TRUSTED_CREDENTIALS_USER";
    public static final String ACTION_USAGE_ACCESS_SETTINGS = "android.settings.USAGE_ACCESS_SETTINGS";
    public static final String ACTION_USER_DICTIONARY_INSERT = "com.android.settings.USER_DICTIONARY_INSERT";
    public static final String ACTION_USER_DICTIONARY_SETTINGS = "android.settings.USER_DICTIONARY_SETTINGS";
    public static final String ACTION_VOICE_CONTROL_AIRPLANE_MODE = "android.settings.VOICE_CONTROL_AIRPLANE_MODE";
    public static final String ACTION_VOICE_INPUT_SETTINGS = "android.settings.VOICE_INPUT_SETTINGS";
    public static final String ACTION_WIFI_DISPLAY_SETTINGS = "android.settings.WIFI_DISPLAY_SETTINGS";
    public static final String ACTION_WIFI_IP_SETTINGS = "android.settings.WIFI_IP_SETTINGS";
    public static final String ACTION_WIFI_SETTINGS = "android.settings.WIFI_SETTINGS";
    public static final String ACTION_WIRELESS_SETTINGS = "android.settings.WIRELESS_SETTINGS";
    public static final String ACTION_ZEN_MODE_SETTINGS = "android.settings.ZEN_MODE_SETTINGS";
    public static final String AUTHORITY = "settings";
    public static final String CALL_METHOD_GET_GLOBAL = "GET_global";
    public static final String CALL_METHOD_GET_SECURE = "GET_secure";
    public static final String CALL_METHOD_GET_SYSTEM = "GET_system";
    public static final String CALL_METHOD_PUT_GLOBAL = "PUT_global";
    public static final String CALL_METHOD_PUT_SECURE = "PUT_secure";
    public static final String CALL_METHOD_PUT_SYSTEM = "PUT_system";
    public static final String CALL_METHOD_USER_KEY = "_user";
    public static final String DEVICE_NAME_SETTINGS = "android.settings.DEVICE_NAME";
    public static final String EXTRA_ACCOUNT_TYPES = "account_types";
    public static final String EXTRA_AIRPLANE_MODE_ENABLED = "airplane_mode_enabled";
    public static final String EXTRA_APP_PACKAGE = "app_package";
    public static final String EXTRA_APP_UID = "app_uid";
    public static final String EXTRA_AUTHORITIES = "authorities";
    public static final String EXTRA_INPUT_DEVICE_IDENTIFIER = "input_device_identifier";
    public static final String EXTRA_INPUT_METHOD_ID = "input_method_id";
    private static final String JID_RESOURCE_PREFIX = "android";
    private static final boolean LOCAL_LOGV = false;
    private static final String TAG = "Settings";
    private static final Object mLocationSettingsLock = new Object();

    /* loaded from: source-9557208-dex2jar.jar:android/provider/Settings$Bookmarks.class */
    public static final class Bookmarks implements BaseColumns {
        public static final String FOLDER = "folder";
        public static final String ID = "_id";
        public static final String INTENT = "intent";
        public static final String ORDERING = "ordering";
        public static final String SHORTCUT = "shortcut";
        private static final String TAG = "Bookmarks";
        public static final String TITLE = "title";
        private static final String sShortcutSelection = "shortcut=?";
        public static final Uri CONTENT_URI = Uri.parse("content://settings/bookmarks");
        private static final String[] sIntentProjection = {"intent"};
        private static final String[] sShortcutProjection = {"_id", "shortcut"};

        public static Uri add(ContentResolver contentResolver, Intent intent, String str, String str2, char c2, int i) {
            if (c2 != 0) {
                contentResolver.delete(CONTENT_URI, sShortcutSelection, new String[]{String.valueOf((int) c2)});
            }
            ContentValues contentValues = new ContentValues();
            if (str != null) {
                contentValues.put("title", str);
            }
            if (str2 != null) {
                contentValues.put("folder", str2);
            }
            contentValues.put("intent", intent.toUri(0));
            if (c2 != 0) {
                contentValues.put("shortcut", Integer.valueOf(c2));
            }
            contentValues.put(ORDERING, Integer.valueOf(i));
            return contentResolver.insert(CONTENT_URI, contentValues);
        }

        public static Intent getIntentForShortcut(ContentResolver contentResolver, char c2) {
            Cursor query = contentResolver.query(CONTENT_URI, sIntentProjection, sShortcutSelection, new String[]{String.valueOf((int) c2)}, ORDERING);
            Intent intent = null;
            while (intent == null) {
                try {
                    if (!query.moveToNext()) {
                        break;
                    }
                    try {
                        intent = Intent.parseUri(query.getString(query.getColumnIndexOrThrow("intent")), 0);
                    } catch (IllegalArgumentException e) {
                        Log.w(TAG, "Intent column not found", e);
                    } catch (URISyntaxException e2) {
                    }
                } finally {
                    if (query != null) {
                        query.close();
                    }
                }
            }
            return intent;
        }

        public static CharSequence getLabelForFolder(Resources resources, String str) {
            return str;
        }

        public static CharSequence getTitle(Context context, Cursor cursor) {
            int columnIndex = cursor.getColumnIndex("title");
            int columnIndex2 = cursor.getColumnIndex("intent");
            if (columnIndex == -1 || columnIndex2 == -1) {
                throw new IllegalArgumentException("The cursor must contain the TITLE and INTENT columns.");
            }
            String string = cursor.getString(columnIndex);
            if (TextUtils.isEmpty(string)) {
                String string2 = cursor.getString(columnIndex2);
                if (TextUtils.isEmpty(string2)) {
                    return "";
                }
                try {
                    Intent parseUri = Intent.parseUri(string2, 0);
                    PackageManager packageManager = context.getPackageManager();
                    ResolveInfo resolveActivity = packageManager.resolveActivity(parseUri, 0);
                    return resolveActivity != null ? resolveActivity.loadLabel(packageManager) : "";
                } catch (URISyntaxException e) {
                    return "";
                }
            }
            return string;
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/provider/Settings$Global.class */
    public static final class Global extends NameValueTable {
        public static final String ADB_ENABLED = "adb_enabled";
        public static final String ADD_USERS_WHEN_LOCKED = "add_users_when_locked";
        public static final String AIRPLANE_MODE_ON = "airplane_mode_on";
        public static final String AIRPLANE_MODE_RADIOS = "airplane_mode_radios";
        public static final String AIRPLANE_MODE_TOGGLEABLE_RADIOS = "airplane_mode_toggleable_radios";
        public static final String ALWAYS_FINISH_ACTIVITIES = "always_finish_activities";
        public static final String ANIMATOR_DURATION_SCALE = "animator_duration_scale";
        public static final String ASSISTED_GPS_CONFIGURABLE_LIST = "assisted_gps_configurable_list";
        public static final String ASSISTED_GPS_ENABLED = "assisted_gps_enabled";
        public static final String ASSISTED_GPS_NETWORK = "assisted_gps_network";
        public static final String ASSISTED_GPS_POSITION_MODE = "assisted_gps_position_mode";
        public static final String ASSISTED_GPS_RESET_TYPE = "assisted_gps_reset_type";
        public static final String ASSISTED_GPS_SUPL_HOST = "assisted_gps_supl_host";
        public static final String ASSISTED_GPS_SUPL_PORT = "assisted_gps_supl_port";
        public static final String AUDIO_SAFE_VOLUME_STATE = "audio_safe_volume_state";
        public static final String AUTO_TIME = "auto_time";
        public static final String AUTO_TIME_ZONE = "auto_time_zone";
        public static final String BATTERY_DISCHARGE_DURATION_THRESHOLD = "battery_discharge_duration_threshold";
        public static final String BATTERY_DISCHARGE_THRESHOLD = "battery_discharge_threshold";
        public static final String BLUETOOTH_A2DP_SINK_PRIORITY_PREFIX = "bluetooth_a2dp_sink_priority_";
        public static final String BLUETOOTH_A2DP_SRC_PRIORITY_PREFIX = "bluetooth_a2dp_src_priority_";
        public static final String BLUETOOTH_HEADSET_PRIORITY_PREFIX = "bluetooth_headset_priority_";
        public static final String BLUETOOTH_INPUT_DEVICE_PRIORITY_PREFIX = "bluetooth_input_device_priority_";
        public static final String BLUETOOTH_MAP_PRIORITY_PREFIX = "bluetooth_map_priority_";
        public static final String BLUETOOTH_ON = "bluetooth_on";
        public static final String BUGREPORT_IN_POWER_MENU = "bugreport_in_power_menu";
        public static final String CAPTIVE_PORTAL_DETECTION_ENABLED = "captive_portal_detection_enabled";
        public static final String CAPTIVE_PORTAL_SERVER = "captive_portal_server";
        public static final String CAR_DOCK_SOUND = "car_dock_sound";
        public static final String CAR_UNDOCK_SOUND = "car_undock_sound";
        public static final String CDMA_CELL_BROADCAST_SMS = "cdma_cell_broadcast_sms";
        public static final String CDMA_ROAMING_MODE = "roaming_settings";
        public static final String CDMA_SUBSCRIPTION_MODE = "subscription_mode";
        public static final String CERT_PIN_UPDATE_CONTENT_URL = "cert_pin_content_url";
        public static final String CERT_PIN_UPDATE_METADATA_URL = "cert_pin_metadata_url";
        public static final String COMPATIBILITY_MODE = "compatibility_mode";
        public static final String CONNECTIVITY_CHANGE_DELAY = "connectivity_change_delay";
        public static final String CONNECTIVITY_SAMPLING_INTERVAL_IN_SECONDS = "connectivity_sampling_interval_in_seconds";
        public static final String DATA_ACTIVITY_TIMEOUT_MOBILE = "data_activity_timeout_mobile";
        public static final String DATA_ACTIVITY_TIMEOUT_WIFI = "data_activity_timeout_wifi";
        public static final String DATA_ROAMING = "data_roaming";
        public static final String DATA_STALL_ALARM_AGGRESSIVE_DELAY_IN_MS = "data_stall_alarm_aggressive_delay_in_ms";
        public static final String DATA_STALL_ALARM_NON_AGGRESSIVE_DELAY_IN_MS = "data_stall_alarm_non_aggressive_delay_in_ms";
        public static final String DEBUG_APP = "debug_app";
        public static final String DEBUG_VIEW_ATTRIBUTES = "debug_view_attributes";
        public static final String DEFAULT_DNS_SERVER = "default_dns_server";
        public static final String DEFAULT_INSTALL_LOCATION = "default_install_location";
        public static final String DESK_DOCK_SOUND = "desk_dock_sound";
        public static final String DESK_UNDOCK_SOUND = "desk_undock_sound";
        public static final String DEVELOPMENT_FORCE_RTL = "debug.force_rtl";
        public static final String DEVELOPMENT_SETTINGS_ENABLED = "development_settings_enabled";
        public static final String DEVICE_NAME = "device_name";
        public static final String DEVICE_PROVISIONED = "device_provisioned";
        public static final String DISK_FREE_CHANGE_REPORTING_THRESHOLD = "disk_free_change_reporting_threshold";
        public static final String DISPLAY_DENSITY_FORCED = "display_density_forced";
        public static final String DISPLAY_SIZE_FORCED = "display_size_forced";
        public static final String DOCK_SOUNDS_ENABLED = "dock_sounds_enabled";
        public static final String DOWNLOAD_MAX_BYTES_OVER_MOBILE = "download_manager_max_bytes_over_mobile";
        public static final String DOWNLOAD_RECOMMENDED_MAX_BYTES_OVER_MOBILE = "download_manager_recommended_max_bytes_over_mobile";
        public static final String DROPBOX_AGE_SECONDS = "dropbox_age_seconds";
        public static final String DROPBOX_MAX_FILES = "dropbox_max_files";
        public static final String DROPBOX_QUOTA_KB = "dropbox_quota_kb";
        public static final String DROPBOX_QUOTA_PERCENT = "dropbox_quota_percent";
        public static final String DROPBOX_RESERVE_PERCENT = "dropbox_reserve_percent";
        public static final String DROPBOX_TAG_PREFIX = "dropbox:";
        public static final String ENHANCED_4G_MODE_ENABLED = "volte_vt_enabled";
        public static final String ERROR_LOGCAT_PREFIX = "logcat_for_";
        public static final String FANCY_IME_ANIMATIONS = "fancy_ime_animations";
        public static final String FSTRIM_MANDATORY_INTERVAL = "fstrim_mandatory_interval";
        public static final String GLOBAL_HTTP_PROXY_EXCLUSION_LIST = "global_http_proxy_exclusion_list";
        public static final String GLOBAL_HTTP_PROXY_HOST = "global_http_proxy_host";
        public static final String GLOBAL_HTTP_PROXY_PAC = "global_proxy_pac_url";
        public static final String GLOBAL_HTTP_PROXY_PORT = "global_http_proxy_port";
        public static final String GPRS_REGISTER_CHECK_PERIOD_MS = "gprs_register_check_period_ms";
        public static final String GUEST_USER_ENABLED = "guest_user_enabled";
        public static final String HDMI_CONTROL_AUTO_DEVICE_OFF_ENABLED = "hdmi_control_auto_device_off_enabled";
        public static final String HDMI_CONTROL_AUTO_WAKEUP_ENABLED = "hdmi_control_auto_wakeup_enabled";
        public static final String HDMI_CONTROL_ENABLED = "hdmi_control_enabled";
        public static final String HDMI_SYSTEM_AUDIO_ENABLED = "hdmi_system_audio_enabled";
        public static final String HEADS_UP_NOTIFICATIONS_ENABLED = "heads_up_notifications_enabled";
        public static final int HEADS_UP_OFF = 0;
        public static final int HEADS_UP_ON = 1;
        public static final String HIDE_CARRIER_NETWORK_SETTINGS = "hide_carrier_network_settings";
        public static final String HTTP_PROXY = "http_proxy";
        public static final String INET_CONDITION_DEBOUNCE_DOWN_DELAY = "inet_condition_debounce_down_delay";
        public static final String INET_CONDITION_DEBOUNCE_UP_DELAY = "inet_condition_debounce_up_delay";
        @Deprecated
        public static final String INSTALL_NON_MARKET_APPS = "install_non_market_apps";
        public static final String INTENT_FIREWALL_UPDATE_CONTENT_URL = "intent_firewall_content_url";
        public static final String INTENT_FIREWALL_UPDATE_METADATA_URL = "intent_firewall_metadata_url";
        public static final String LOCK_SOUND = "lock_sound";
        public static final String LOW_BATTERY_SOUND = "low_battery_sound";
        public static final String LOW_BATTERY_SOUND_TIMEOUT = "low_battery_sound_timeout";
        public static final String LOW_POWER_MODE = "low_power";
        public static final String LTE_SERVICE_FORCED = "lte_service_forced";
        public static final String MDC_INITIAL_MAX_RETRY = "mdc_initial_max_retry";
        public static final String MHL_INPUT_SWITCHING_ENABLED = "mhl_input_switching_enabled";
        public static final String MHL_POWER_CHARGE_ENABLED = "mhl_power_charge_enabled";
        public static final String MOBILE_DATA = "mobile_data";
        public static final String MODE_RINGER = "mode_ringer";
        public static final String MULTI_SIM_DATA_CALL_SUBSCRIPTION = "multi_sim_data_call";
        public static final String MULTI_SIM_PRIORITY_SUBSCRIPTION = "multi_sim_priority";
        public static final String MULTI_SIM_SMS_PROMPT = "multi_sim_sms_prompt";
        public static final String MULTI_SIM_SMS_SUBSCRIPTION = "multi_sim_sms";
        public static final String[] MULTI_SIM_USER_PREFERRED_SUBS = null;
        public static final String MULTI_SIM_VOICE_CALL_SUBSCRIPTION = "multi_sim_voice_call";
        public static final String MULTI_SIM_VOICE_PROMPT = "multi_sim_voice_prompt";
        public static final String NETSTATS_DEV_BUCKET_DURATION = "netstats_dev_bucket_duration";
        public static final String NETSTATS_DEV_DELETE_AGE = "netstats_dev_delete_age";
        public static final String NETSTATS_DEV_PERSIST_BYTES = "netstats_dev_persist_bytes";
        public static final String NETSTATS_DEV_ROTATE_AGE = "netstats_dev_rotate_age";
        public static final String NETSTATS_ENABLED = "netstats_enabled";
        public static final String NETSTATS_GLOBAL_ALERT_BYTES = "netstats_global_alert_bytes";
        public static final String NETSTATS_POLL_INTERVAL = "netstats_poll_interval";
        public static final String NETSTATS_SAMPLE_ENABLED = "netstats_sample_enabled";
        public static final String NETSTATS_TIME_CACHE_MAX_AGE = "netstats_time_cache_max_age";
        public static final String NETSTATS_UID_BUCKET_DURATION = "netstats_uid_bucket_duration";
        public static final String NETSTATS_UID_DELETE_AGE = "netstats_uid_delete_age";
        public static final String NETSTATS_UID_PERSIST_BYTES = "netstats_uid_persist_bytes";
        public static final String NETSTATS_UID_ROTATE_AGE = "netstats_uid_rotate_age";
        public static final String NETSTATS_UID_TAG_BUCKET_DURATION = "netstats_uid_tag_bucket_duration";
        public static final String NETSTATS_UID_TAG_DELETE_AGE = "netstats_uid_tag_delete_age";
        public static final String NETSTATS_UID_TAG_PERSIST_BYTES = "netstats_uid_tag_persist_bytes";
        public static final String NETSTATS_UID_TAG_ROTATE_AGE = "netstats_uid_tag_rotate_age";
        public static final String NETWORK_PREFERENCE = "network_preference";
        public static final String NETWORK_SCORER_APP = "network_scorer_app";
        public static final String NETWORK_SCORING_PROVISIONED = "network_scoring_provisioned";
        public static final String NITZ_UPDATE_DIFF = "nitz_update_diff";
        public static final String NITZ_UPDATE_SPACING = "nitz_update_spacing";
        public static final String NSD_ON = "nsd_on";
        public static final String NTP_SERVER = "ntp_server";
        public static final String NTP_TIMEOUT = "ntp_timeout";
        public static final String OVERLAY_DISPLAY_DEVICES = "overlay_display_devices";
        public static final String PACKAGE_VERIFIER_DEFAULT_RESPONSE = "verifier_default_response";
        public static final String PACKAGE_VERIFIER_ENABLE = "package_verifier_enable";
        public static final String PACKAGE_VERIFIER_INCLUDE_ADB = "verifier_verify_adb_installs";
        public static final String PACKAGE_VERIFIER_SETTING_VISIBLE = "verifier_setting_visible";
        public static final String PACKAGE_VERIFIER_TIMEOUT = "verifier_timeout";
        public static final String PAC_CHANGE_DELAY = "pac_change_delay";
        public static final String PDP_WATCHDOG_ERROR_POLL_COUNT = "pdp_watchdog_error_poll_count";
        public static final String PDP_WATCHDOG_ERROR_POLL_INTERVAL_MS = "pdp_watchdog_error_poll_interval_ms";
        public static final String PDP_WATCHDOG_LONG_POLL_INTERVAL_MS = "pdp_watchdog_long_poll_interval_ms";
        public static final String PDP_WATCHDOG_MAX_PDP_RESET_FAIL_COUNT = "pdp_watchdog_max_pdp_reset_fail_count";
        public static final String PDP_WATCHDOG_POLL_INTERVAL_MS = "pdp_watchdog_poll_interval_ms";
        public static final String PDP_WATCHDOG_TRIGGER_PACKET_COUNT = "pdp_watchdog_trigger_packet_count";
        public static final String POLICY_CONTROL = "policy_control";
        public static final String POLICY_CONTROL_STYLE = "policy_control_style";
        @Deprecated
        public static final String POWER_MENU_ACTIONS = "power_menu_actions";
        public static final String POWER_NOTIFICATIONS_ENABLED = "power_notifications_enabled";
        public static final String POWER_NOTIFICATIONS_RINGTONE = "power_notifications_ringtone";
        public static final String POWER_NOTIFICATIONS_VIBRATE = "power_notifications_vibrate";
        public static final String POWER_SOUNDS_ENABLED = "power_sounds_enabled";
        public static final String PREFERRED_NETWORK_MODE = "preferred_network_mode";
        public static final String PROVISIONING_APN_ALARM_DELAY_IN_MS = "provisioning_apn_alarm_delay_in_ms";
        public static final String RADIO_BLUETOOTH = "bluetooth";
        public static final String RADIO_CELL = "cell";
        public static final String RADIO_NFC = "nfc";
        public static final String RADIO_WIFI = "wifi";
        public static final String RADIO_WIMAX = "wimax";
        public static final String READ_EXTERNAL_STORAGE_ENFORCED_DEFAULT = "read_external_storage_enforced_default";
        public static final String REQUIRE_PASSWORD_TO_DECRYPT = "require_password_to_decrypt";
        public static final String SAMPLING_PROFILER_MS = "sampling_profiler_ms";
        public static final String SELINUX_STATUS = "selinux_status";
        public static final String SELINUX_UPDATE_CONTENT_URL = "selinux_content_url";
        public static final String SELINUX_UPDATE_METADATA_URL = "selinux_metadata_url";
        public static final String SEND_ACTION_APP_ERROR = "send_action_app_error";
        public static final String SETUP_PREPAID_DATA_SERVICE_URL = "setup_prepaid_data_service_url";
        public static final String SETUP_PREPAID_DETECTION_REDIR_HOST = "setup_prepaid_detection_redir_host";
        public static final String SETUP_PREPAID_DETECTION_TARGET_URL = "setup_prepaid_detection_target_url";
        public static final String SET_GLOBAL_HTTP_PROXY = "set_global_http_proxy";
        public static final String SET_INSTALL_LOCATION = "set_install_location";
        public static final String SHOW_PROCESSES = "show_processes";
        public static final String SMS_OUTGOING_CHECK_INTERVAL_MS = "sms_outgoing_check_interval_ms";
        public static final String SMS_OUTGOING_CHECK_MAX_COUNT = "sms_outgoing_check_max_count";
        public static final String SMS_SHORT_CODES_UPDATE_CONTENT_URL = "sms_short_codes_content_url";
        public static final String SMS_SHORT_CODES_UPDATE_METADATA_URL = "sms_short_codes_metadata_url";
        public static final String SMS_SHORT_CODE_CONFIRMATION = "sms_short_code_confirmation";
        public static final String SMS_SHORT_CODE_RULE = "sms_short_code_rule";
        public static final String STAY_ON_WHILE_PLUGGED_IN = "stay_on_while_plugged_in";
        public static final String SYNC_MAX_RETRY_DELAY_IN_SECONDS = "sync_max_retry_delay_in_seconds";
        public static final String SYS_FREE_STORAGE_LOG_INTERVAL = "sys_free_storage_log_interval";
        public static final String SYS_STORAGE_FULL_THRESHOLD_BYTES = "sys_storage_full_threshold_bytes";
        public static final String SYS_STORAGE_THRESHOLD_MAX_BYTES = "sys_storage_threshold_max_bytes";
        public static final String SYS_STORAGE_THRESHOLD_PERCENTAGE = "sys_storage_threshold_percentage";
        public static final String TCP_DEFAULT_INIT_RWND = "tcp_default_init_rwnd";
        public static final String TETHER_DUN_APN = "tether_dun_apn";
        public static final String TETHER_DUN_REQUIRED = "tether_dun_required";
        public static final String TETHER_SUPPORTED = "tether_supported";
        public static final String THEATER_MODE_ON = "theater_mode_on";
        public static final String TRANSITION_ANIMATION_SCALE = "transition_animation_scale";
        public static final String TRUSTED_SOUND = "trusted_sound";
        public static final String TUNE_AWAY_STATUS = "tune_away";
        public static final String TZINFO_UPDATE_CONTENT_URL = "tzinfo_content_url";
        public static final String TZINFO_UPDATE_METADATA_URL = "tzinfo_metadata_url";
        public static final String UNLOCK_SOUND = "unlock_sound";
        public static final String USB_MASS_STORAGE_ENABLED = "usb_mass_storage_enabled";
        public static final String USER_FINGERPRINTS = "user_fingerprints";
        public static final String USE_GOOGLE_MAIL = "use_google_mail";
        public static final String VOLTE_FEATURE_DISABLED = "volte_feature_disabled";
        public static final String WAIT_FOR_DEBUGGER = "wait_for_debugger";
        public static final String WEBVIEW_DATA_REDUCTION_PROXY_KEY = "webview_data_reduction_proxy_key";
        public static final String WIFI_AUTO_PRIORITIES_CONFIGURATION = "wifi_auto_priority";
        public static final String WIFI_BOUNCE_DELAY_OVERRIDE_MS = "wifi_bounce_delay_override_ms";
        public static final String WIFI_COUNTRY_CODE = "wifi_country_code";
        public static final String WIFI_DISPLAY_CERTIFICATION_ON = "wifi_display_certification_on";
        public static final String WIFI_DISPLAY_ON = "wifi_display_on";
        public static final String WIFI_DISPLAY_WPS_CONFIG = "wifi_display_wps_config";
        public static final String WIFI_ENHANCED_AUTO_JOIN = "wifi_enhanced_auto_join";
        public static final String WIFI_EPHEMERAL_OUT_OF_RANGE_TIMEOUT_MS = "wifi_ephemeral_out_of_range_timeout_ms";
        public static final String WIFI_FRAMEWORK_SCAN_INTERVAL_MS = "wifi_framework_scan_interval_ms";
        public static final String WIFI_FREQUENCY_BAND = "wifi_frequency_band";
        public static final String WIFI_IDLE_MS = "wifi_idle_ms";
        public static final String WIFI_MAX_DHCP_RETRY_COUNT = "wifi_max_dhcp_retry_count";
        public static final String WIFI_MOBILE_DATA_TRANSITION_WAKELOCK_TIMEOUT_MS = "wifi_mobile_data_transition_wakelock_timeout_ms";
        public static final String WIFI_NETWORKS_AVAILABLE_NOTIFICATION_ON = "wifi_networks_available_notification_on";
        public static final String WIFI_NETWORKS_AVAILABLE_REPEAT_DELAY = "wifi_networks_available_repeat_delay";
        public static final String WIFI_NETWORK_SHOW_RSSI = "wifi_network_show_rssi";
        public static final String WIFI_NUM_OPEN_NETWORKS_KEPT = "wifi_num_open_networks_kept";
        public static final String WIFI_ON = "wifi_on";
        public static final String WIFI_P2P_DEVICE_NAME = "wifi_p2p_device_name";
        public static final String WIFI_REENABLE_DELAY_MS = "wifi_reenable_delay";
        public static final String WIFI_SAVED_STATE = "wifi_saved_state";
        public static final String WIFI_SCAN_ALWAYS_AVAILABLE = "wifi_scan_always_enabled";
        public static final String WIFI_SCAN_INTERVAL_WHEN_P2P_CONNECTED_MS = "wifi_scan_interval_p2p_connected_ms";
        public static final String WIFI_SLEEP_POLICY = "wifi_sleep_policy";
        public static final int WIFI_SLEEP_POLICY_DEFAULT = 0;
        public static final int WIFI_SLEEP_POLICY_NEVER = 2;
        public static final int WIFI_SLEEP_POLICY_NEVER_WHILE_PLUGGED = 1;
        public static final String WIFI_SUPPLICANT_SCAN_INTERVAL_MS = "wifi_supplicant_scan_interval_ms";
        public static final String WIFI_SUPPLICANT_SCAN_INTERVAL_WFD_CONNECTED_MS = "wifi_scan_intervel_wfd_connected_ms";
        public static final String WIFI_SUSPEND_OPTIMIZATIONS_ENABLED = "wifi_suspend_optimizations_enabled";
        public static final String WIFI_WATCHDOG_ON = "wifi_watchdog_on";
        public static final String WIMAX_NETWORKS_AVAILABLE_NOTIFICATION_ON = "wimax_networks_available_notification_on";
        public static final String WINDOW_ANIMATION_SCALE = "window_animation_scale";
        public static final String WIRELESS_CHARGING_STARTED_SOUND = "wireless_charging_started_sound";
        public static final String WTF_IS_FATAL = "wtf_is_fatal";
        public static final String ZEN_DISABLE_DUCKING_DURING_MEDIA_PLAYBACK = "zen_disable_ducking_during_media_playback";
        public static final String ZEN_MODE = "zen_mode";
        public static final String ZEN_MODE_CONFIG_ETAG = "zen_mode_config_etag";
        public static final int ZEN_MODE_IMPORTANT_INTERRUPTIONS = 1;
        public static final int ZEN_MODE_NO_INTERRUPTIONS = 2;
        public static final int ZEN_MODE_OFF = 0;
        public static final Uri CONTENT_URI = Uri.parse("content://settings/global");
        public static final String WAKE_WHEN_PLUGGED_OR_UNPLUGGED = "wake_when_plugged_or_unplugged";
        public static final String ENABLE_ACCESSIBILITY_GLOBAL_GESTURE_ENABLED = "enable_accessibility_global_gesture_enabled";
        public static final String WIFI_WATCHDOG_POOR_NETWORK_TEST_ENABLED = "wifi_watchdog_poor_network_test_enabled";
        public static final String EMERGENCY_TONE = "emergency_tone";
        public static final String CALL_AUTO_RETRY = "call_auto_retry";
        public static final String DOCK_AUDIO_MEDIA_ENABLED = "dock_audio_media_enabled";
        public static final String LOW_POWER_MODE_TRIGGER_LEVEL = "low_power_trigger_level";
        public static final String[] SETTINGS_TO_BACKUP = {"bugreport_in_power_menu", "stay_on_while_plugged_in", WAKE_WHEN_PLUGGED_OR_UNPLUGGED, "auto_time", "auto_time_zone", "power_sounds_enabled", "dock_sounds_enabled", "usb_mass_storage_enabled", ENABLE_ACCESSIBILITY_GLOBAL_GESTURE_ENABLED, "wifi_networks_available_notification_on", "wifi_networks_available_repeat_delay", WIFI_WATCHDOG_POOR_NETWORK_TEST_ENABLED, "wifi_num_open_networks_kept", EMERGENCY_TONE, CALL_AUTO_RETRY, DOCK_AUDIO_MEDIA_ENABLED, LOW_POWER_MODE_TRIGGER_LEVEL};
        public static final String SYS_PROP_SETTING_VERSION = "sys.settings_global_version";
        private static NameValueCache sNameValueCache = new NameValueCache(SYS_PROP_SETTING_VERSION, CONTENT_URI, Settings.CALL_METHOD_GET_GLOBAL, Settings.CALL_METHOD_PUT_GLOBAL);
        private static final HashSet<String> MOVED_TO_SECURE = new HashSet<>(1);

        static {
            HashSet<String> hashSet = MOVED_TO_SECURE;
            throw new VerifyError("bad dex opcode");
        }

        public static final String getBluetoothA2dpSinkPriorityKey(String str) {
            return BLUETOOTH_A2DP_SINK_PRIORITY_PREFIX + str.toUpperCase(Locale.ROOT);
        }

        public static final String getBluetoothA2dpSrcPriorityKey(String str) {
            return BLUETOOTH_A2DP_SRC_PRIORITY_PREFIX + str.toUpperCase(Locale.ROOT);
        }

        public static final String getBluetoothHeadsetPriorityKey(String str) {
            return BLUETOOTH_HEADSET_PRIORITY_PREFIX + str.toUpperCase(Locale.ROOT);
        }

        public static final String getBluetoothInputDevicePriorityKey(String str) {
            return BLUETOOTH_INPUT_DEVICE_PRIORITY_PREFIX + str.toUpperCase(Locale.ROOT);
        }

        public static final String getBluetoothMapPriorityKey(String str) {
            return BLUETOOTH_MAP_PRIORITY_PREFIX + str.toUpperCase(Locale.ROOT);
        }

        public static List<String> getDelimitedStringAsList(ContentResolver contentResolver, String str, String str2) {
            String string = getString(contentResolver, str);
            ArrayList arrayList = new ArrayList();
            if (!TextUtils.isEmpty(string)) {
                String[] split = TextUtils.split(string, Pattern.quote(str2));
                int length = split.length;
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= length) {
                        break;
                    }
                    String str3 = split[i2];
                    if (!TextUtils.isEmpty(str3)) {
                        arrayList.add(str3);
                    }
                    i = i2 + 1;
                }
            }
            return arrayList;
        }

        public static float getFloat(ContentResolver contentResolver, String str) throws SettingNotFoundException {
            String string = getString(contentResolver, str);
            if (string == null) {
                throw new SettingNotFoundException(str);
            }
            try {
                return Float.parseFloat(string);
            } catch (NumberFormatException e) {
                throw new SettingNotFoundException(str);
            }
        }

        public static float getFloat(ContentResolver contentResolver, String str, float f) {
            String string = getString(contentResolver, str);
            float f2 = f;
            if (string != null) {
                try {
                    f2 = Float.parseFloat(string);
                } catch (NumberFormatException e) {
                    return f;
                }
            }
            return f2;
        }

        public static int getInt(ContentResolver contentResolver, String str) throws SettingNotFoundException {
            try {
                return Integer.parseInt(getString(contentResolver, str));
            } catch (NumberFormatException e) {
                throw new SettingNotFoundException(str);
            }
        }

        public static int getInt(ContentResolver contentResolver, String str, int i) {
            String string = getString(contentResolver, str);
            int i2 = i;
            if (string != null) {
                try {
                    i2 = Integer.parseInt(string);
                } catch (NumberFormatException e) {
                    return i;
                }
            }
            return i2;
        }

        public static long getLong(ContentResolver contentResolver, String str) throws SettingNotFoundException {
            try {
                return Long.parseLong(getString(contentResolver, str));
            } catch (NumberFormatException e) {
                throw new SettingNotFoundException(str);
            }
        }

        public static long getLong(ContentResolver contentResolver, String str, long j) {
            String string = getString(contentResolver, str);
            if (string != null) {
                try {
                    return Long.parseLong(string);
                } catch (NumberFormatException e) {
                    return j;
                }
            }
            return j;
        }

        public static String getString(ContentResolver contentResolver, String str) {
            return getStringForUser(contentResolver, str, UserHandle.myUserId());
        }

        public static String getStringForUser(ContentResolver contentResolver, String str, int i) {
            if (MOVED_TO_SECURE.contains(str)) {
                Log.w(Settings.TAG, "Setting " + str + " has moved from android.provider.Settings.Global to android.provider.Settings.Secure, returning read-only value.");
                return Secure.getStringForUser(contentResolver, str, i);
            }
            return sNameValueCache.getStringForUser(contentResolver, str, i);
        }

        public static Uri getUriFor(String str) {
            if (MOVED_TO_SECURE.contains(str)) {
                Log.w(Settings.TAG, "Setting " + str + " has moved from android.provider.Settings.Global to android.provider.Settings.Secure, returning Secure URI.");
                return Secure.getUriFor(Secure.CONTENT_URI, str);
            }
            return getUriFor(CONTENT_URI, str);
        }

        public static boolean putFloat(ContentResolver contentResolver, String str, float f) {
            return putString(contentResolver, str, Float.toString(f));
        }

        public static boolean putInt(ContentResolver contentResolver, String str, int i) {
            return putString(contentResolver, str, Integer.toString(i));
        }

        public static void putListAsDelimitedString(ContentResolver contentResolver, String str, String str2, List<String> list) {
            putString(contentResolver, str, TextUtils.join(str2, list));
        }

        public static boolean putLong(ContentResolver contentResolver, String str, long j) {
            return putString(contentResolver, str, Long.toString(j));
        }

        public static boolean putString(ContentResolver contentResolver, String str, String str2) {
            return putStringForUser(contentResolver, str, str2, UserHandle.myUserId());
        }

        public static boolean putStringForUser(ContentResolver contentResolver, String str, String str2, int i) {
            if (MOVED_TO_SECURE.contains(str)) {
                Log.w(Settings.TAG, "Setting " + str + " has moved from android.provider.Settings.Global to android.provider.Settings.Secure, value is unchanged.");
                return Secure.putStringForUser(contentResolver, str, str2, i);
            }
            return sNameValueCache.putStringForUser(contentResolver, str, str2, i);
        }

        public static String zenModeToString(int i) {
            return i == 1 ? "ZEN_MODE_IMPORTANT_INTERRUPTIONS" : i == 2 ? "ZEN_MODE_NO_INTERRUPTIONS" : "ZEN_MODE_OFF";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/provider/Settings$NameValueCache.class */
    public static class NameValueCache {
        private static final String NAME_EQ_PLACEHOLDER = "name=?";
        private static final String[] SELECT_VALUE = {"value"};
        private final String mCallGetCommand;
        private final String mCallSetCommand;
        private final Uri mUri;
        private final String mVersionSystemProperty;
        private final HashMap<String, String> mValues = new HashMap<>();
        private long mValuesVersion = 0;
        private IContentProvider mContentProvider = null;

        public NameValueCache(String str, Uri uri, String str2, String str3) {
            this.mVersionSystemProperty = str;
            this.mUri = uri;
            this.mCallGetCommand = str2;
            this.mCallSetCommand = str3;
        }

        private IContentProvider lazyGetProvider(ContentResolver contentResolver) {
            IContentProvider iContentProvider;
            synchronized (this) {
                IContentProvider iContentProvider2 = this.mContentProvider;
                iContentProvider = iContentProvider2;
                if (iContentProvider2 == null) {
                    iContentProvider = contentResolver.acquireProvider(this.mUri.getAuthority());
                    this.mContentProvider = iContentProvider;
                }
            }
            return iContentProvider;
        }

        /* JADX WARN: Can't wrap try/catch for region: R(6:(5:30|(5:49|50|51|52|53)|32|33|(5:35|36|(4:38|a0|43|44)|47|48))|57|58|(4:60|61|62|(2:64|65))(10:66|67|(3:69|70|71)(1:93)|72|73|74|154|80|81|(2:83|84))|47|48) */
        /* JADX WARN: Code restructure failed: missing block: B:88:0x0184, code lost:
            r11 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:90:0x0189, code lost:
            android.util.Log.w(android.provider.Settings.TAG, "Can't get key " + r12 + " from " + r10.mUri, r11);
         */
        /* JADX WARN: Code restructure failed: missing block: B:91:0x01b0, code lost:
            r17 = null;
         */
        /* JADX WARN: Code restructure failed: missing block: B:92:0x01b4, code lost:
            if (0 != 0) goto L105;
         */
        /* JADX WARN: Code restructure failed: missing block: B:93:0x01b7, code lost:
            r0.close();
         */
        /* JADX WARN: Code restructure failed: missing block: B:94:0x01bf, code lost:
            return null;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public java.lang.String getStringForUser(android.content.ContentResolver r11, java.lang.String r12, int r13) {
            /*
                Method dump skipped, instructions count: 477
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: android.provider.Settings.NameValueCache.getStringForUser(android.content.ContentResolver, java.lang.String, int):java.lang.String");
        }

        public boolean putStringForUser(ContentResolver contentResolver, String str, String str2, int i) {
            try {
                Bundle bundle = new Bundle();
                bundle.putString("value", str2);
                bundle.putInt(Settings.CALL_METHOD_USER_KEY, i);
                lazyGetProvider(contentResolver).call(contentResolver.getPackageName(), this.mCallSetCommand, str, bundle);
                return true;
            } catch (RemoteException e) {
                Log.w(Settings.TAG, "Can't set key " + str + " in " + this.mUri, e);
                return false;
            }
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/provider/Settings$NameValueTable.class */
    public static class NameValueTable implements BaseColumns {
        public static final String NAME = "name";
        public static final String VALUE = "value";

        public static Uri getUriFor(Uri uri, String str) {
            return Uri.withAppendedPath(uri, str);
        }

        protected static boolean putString(ContentResolver contentResolver, Uri uri, String str, String str2) {
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put("name", str);
                contentValues.put("value", str2);
                contentResolver.insert(uri, contentValues);
                return true;
            } catch (SQLException e) {
                Log.w(Settings.TAG, "Can't set key " + str + " in " + uri, e);
                return false;
            }
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/provider/Settings$Secure.class */
    public static final class Secure extends NameValueTable {
        public static final String ACCESSIBILITY_CAPTIONING_BACKGROUND_COLOR = "accessibility_captioning_background_color";
        public static final String ACCESSIBILITY_CAPTIONING_EDGE_COLOR = "accessibility_captioning_edge_color";
        public static final String ACCESSIBILITY_CAPTIONING_EDGE_TYPE = "accessibility_captioning_edge_type";
        public static final String ACCESSIBILITY_CAPTIONING_ENABLED = "accessibility_captioning_enabled";
        public static final String ACCESSIBILITY_CAPTIONING_FONT_SCALE = "accessibility_captioning_font_scale";
        public static final String ACCESSIBILITY_CAPTIONING_FOREGROUND_COLOR = "accessibility_captioning_foreground_color";
        public static final String ACCESSIBILITY_CAPTIONING_LOCALE = "accessibility_captioning_locale";
        public static final String ACCESSIBILITY_CAPTIONING_PRESET = "accessibility_captioning_preset";
        public static final String ACCESSIBILITY_CAPTIONING_TYPEFACE = "accessibility_captioning_typeface";
        public static final String ACCESSIBILITY_CAPTIONING_WINDOW_COLOR = "accessibility_captioning_window_color";
        public static final String ACCESSIBILITY_DISPLAY_DALTONIZER = "accessibility_display_daltonizer";
        public static final String ACCESSIBILITY_DISPLAY_DALTONIZER_ENABLED = "accessibility_display_daltonizer_enabled";
        public static final String ACCESSIBILITY_DISPLAY_INVERSION_ENABLED = "accessibility_display_inversion_enabled";
        public static final String ACCESSIBILITY_DISPLAY_MAGNIFICATION_AUTO_UPDATE = "accessibility_display_magnification_auto_update";
        public static final String ACCESSIBILITY_DISPLAY_MAGNIFICATION_ENABLED = "accessibility_display_magnification_enabled";
        public static final String ACCESSIBILITY_DISPLAY_MAGNIFICATION_SCALE = "accessibility_display_magnification_scale";
        public static final String ACCESSIBILITY_ENABLED = "accessibility_enabled";
        public static final String ACCESSIBILITY_HIGH_TEXT_CONTRAST_ENABLED = "high_text_contrast_enabled";
        public static final String ACCESSIBILITY_SCREEN_READER_URL = "accessibility_script_injection_url";
        public static final String ACCESSIBILITY_SCRIPT_INJECTION = "accessibility_script_injection";
        public static final String ACCESSIBILITY_SPEAK_PASSWORD = "speak_password";
        public static final String ACCESSIBILITY_WEB_CONTENT_KEY_BINDINGS = "accessibility_web_content_key_bindings";
        @Deprecated
        public static final String ADB_ENABLED = "adb_enabled";
        public static final String ADB_NOTIFY = "adb_notify";
        public static final String ADB_PORT = "adb_port";
        @Deprecated
        public static final String ADVANCED_MODE = "advanced_mode";
        public static final String ADVANCED_REBOOT = "advanced_reboot";
        public static final String ALLOWED_GEOLOCATION_ORIGINS = "allowed_geolocation_origins";
        public static final String ALLOW_MOCK_LOCATION = "mock_location";
        public static final String ANDROID_ID = "android_id";
        public static final String ANR_SHOW_BACKGROUND = "anr_show_background";
        public static final String APP_PERFORMANCE_PROFILES_ENABLED = "app_perf_profiles_enabled";
        @Deprecated
        public static final String BACKGROUND_DATA = "background_data";
        public static final String BACKUP_AUTO_RESTORE = "backup_auto_restore";
        public static final String BACKUP_ENABLED = "backup_enabled";
        public static final String BACKUP_PROVISIONED = "backup_provisioned";
        public static final String BACKUP_TRANSPORT = "backup_transport";
        public static final String BAR_SERVICE_COMPONENT = "bar_service_component";
        public static final String BLUETOOTH_HCI_LOG = "bluetooth_hci_log";
        @Deprecated
        public static final String BLUETOOTH_ON = "bluetooth_on";
        @Deprecated
        public static final String BUGREPORT_IN_POWER_MENU = "bugreport_in_power_menu";
        @Deprecated
        public static final String BUTTON_BACKLIGHT_TIMEOUT = "button_backlight_timeout";
        @Deprecated
        public static final String BUTTON_BRIGHTNESS = "button_brightness";
        public static final String[] CLONE_TO_MANAGED_PROFILE = null;
        public static final String CONNECTIVITY_RELEASE_PENDING_INTENT_DELAY_MS = "connectivity_release_pending_intent_delay_ms";
        @Deprecated
        public static final String DATA_ROAMING = "data_roaming";
        public static final String DEFAULT_INPUT_METHOD = "default_input_method";
        @Deprecated
        public static final String DEFAULT_THEME_COMPONENTS = "default_theme_components";
        public static final String DEFAULT_THEME_PACKAGE = "default_theme_package";
        @Deprecated
        public static final String DEVELOPMENT_SETTINGS_ENABLED = "development_settings_enabled";
        public static final String DEVELOPMENT_SHORTCUT = "development_shortcut";
        public static final String DEVICE_HOSTNAME = "device_hostname";
        @Deprecated
        public static final String DEVICE_PROVISIONED = "device_provisioned";
        public static final String DEV_FORCE_SHOW_NAVBAR = "dev_force_show_navbar";
        public static final String DISABLED_SYSTEM_INPUT_METHODS = "disabled_system_input_methods";
        public static final String DOZE_ENABLED = "doze_enabled";
        public static final String ENABLED_ACCESSIBILITY_SERVICES = "enabled_accessibility_services";
        public static final String ENABLED_CONDITION_PROVIDERS = "enabled_condition_providers";
        public static final String ENABLED_INPUT_METHODS = "enabled_input_methods";
        public static final String ENABLED_NOTIFICATION_LISTENERS = "enabled_notification_listeners";
        public static final String ENABLED_ON_FIRST_BOOT_SYSTEM_PRINT_SERVICES = "enabled_on_first_boot_system_print_services";
        public static final String ENABLED_PRINT_SERVICES = "enabled_print_services";
        public static final String ENHANCED_VOICE_PRIVACY_ENABLED = "enhanced_voice_privacy_enabled";
        @Deprecated
        public static final String HTTP_PROXY = "http_proxy";
        public static final String IMMERSIVE_MODE_CONFIRMATIONS = "immersive_mode_confirmations";
        public static final String INCALL_POWER_BUTTON_BEHAVIOR = "incall_power_button_behavior";
        public static final int INCALL_POWER_BUTTON_BEHAVIOR_DEFAULT = 1;
        public static final int INCALL_POWER_BUTTON_BEHAVIOR_HANGUP = 2;
        public static final int INCALL_POWER_BUTTON_BEHAVIOR_SCREEN_OFF = 1;
        public static final String INPUT_METHODS_SUBTYPE_HISTORY = "input_methods_subtype_history";
        public static final String INPUT_METHOD_SELECTOR_VISIBILITY = "input_method_selector_visibility";
        public static final String INSTALL_NON_MARKET_APPS = "install_non_market_apps";
        @Deprecated
        public static final String KEYBOARD_BRIGHTNESS = "keyboard_brightness";
        public static final String KILL_APP_LONGPRESS_BACK = "kill_app_longpress_back";
        public static final String LAST_SETUP_SHOWN = "last_setup_shown";
        public static final String LIVE_DISPLAY_COLOR_MATRIX = "live_display_color_matrix";
        public static final String LOCATION_MODE = "location_mode";
        public static final int LOCATION_MODE_BATTERY_SAVING = 2;
        public static final int LOCATION_MODE_HIGH_ACCURACY = 3;
        public static final int LOCATION_MODE_OFF = 0;
        public static final int LOCATION_MODE_SENSORS_ONLY = 1;
        @Deprecated
        public static final String LOCATION_PROVIDERS_ALLOWED = "location_providers_allowed";
        public static final String LOCKSCREEN_HIDE_TILES_WITH_SENSITIVE_DATA = "lockscreen_hide_qs_tiles_with_sensitive_data";
        public static final String LOCKSCREEN_TARGETS = "lockscreen_target_actions";
        public static final String LOCKSCREEN_VISUALIZER_ENABLED = "lockscreen_visualizer";
        public static final String LOCK_BIOMETRIC_WEAK_FLAGS = "lock_biometric_weak_flags";
        public static final String LOCK_DOTS_VISIBLE = "lock_pattern_dotsvisible";
        public static final String LOCK_GESTURE_ENABLED = "lock_gesture_autolock";
        public static final String LOCK_GESTURE_VISIBLE = "lock_gesture_visible_pattern";
        public static final String LOCK_PASS_TO_SECURITY_VIEW = "lock_screen_pass_to_security_view";
        public static final String LOCK_PATTERN_ENABLED = "lock_pattern_autolock";
        public static final String LOCK_PATTERN_SIZE = "lock_pattern_size";
        @Deprecated
        public static final String LOCK_PATTERN_TACTILE_FEEDBACK_ENABLED = "lock_pattern_tactile_feedback_enabled";
        public static final String LOCK_PATTERN_VISIBLE = "lock_pattern_visible_pattern";
        public static final String LOCK_SCREEN_ALLOW_PRIVATE_NOTIFICATIONS = "lock_screen_allow_private_notifications";
        public static final String LOCK_SCREEN_APPWIDGET_IDS = "lock_screen_appwidget_ids";
        public static final String LOCK_SCREEN_FALLBACK_APPWIDGET_ID = "lock_screen_fallback_appwidget_id";
        public static final String LOCK_SCREEN_LOCK_AFTER_TIMEOUT = "lock_screen_lock_after_timeout";
        public static final String LOCK_SCREEN_OWNER_INFO = "lock_screen_owner_info";
        public static final String LOCK_SCREEN_OWNER_INFO_ENABLED = "lock_screen_owner_info_enabled";
        public static final String LOCK_SCREEN_SHOW_NOTIFICATIONS = "lock_screen_show_notifications";
        public static final String LOCK_SCREEN_STICKY_APPWIDGET = "lock_screen_sticky_appwidget";
        public static final String LOCK_SHOW_ERROR_PATH = "lock_pattern_show_error_path";
        public static final String LOCK_TO_APP_EXIT_LOCKED = "lock_to_app_exit_locked";
        @Deprecated
        public static final String LOGGING_ID = "logging_id";
        public static final String LONG_PRESS_TIMEOUT = "long_press_timeout";
        public static final String MOUNT_PLAY_NOTIFICATION_SND = "mount_play_not_snd";
        public static final String MOUNT_UMS_AUTOSTART = "mount_ums_autostart";
        public static final String MOUNT_UMS_NOTIFY_ENABLED = "mount_ums_notify_enabled";
        public static final String MOUNT_UMS_PROMPT = "mount_ums_prompt";
        private static final HashSet<String> MOVED_TO_GLOBAL = null;
        @Deprecated
        public static final String[] NAVIGATION_RING_TARGETS = null;
        @Deprecated
        public static final String NETWORK_PREFERENCE = "network_preference";
        public static final String NFC_PAYMENT_DEFAULT_COMPONENT = "nfc_payment_default_component";
        public static final String NFC_PAYMENT_FOREGROUND = "nfc_payment_foreground";
        public static final String PACKAGE_VERIFIER_USER_CONSENT = "package_verifier_user_consent";
        public static final String PARENTAL_CONTROL_ENABLED = "parental_control_enabled";
        public static final String PARENTAL_CONTROL_LAST_UPDATE = "parental_control_last_update";
        public static final String PARENTAL_CONTROL_REDIRECT_URL = "parental_control_redirect_url";
        public static final String PAYMENT_SERVICE_SEARCH_URI = "payment_service_search_uri";
        public static final String PERFORMANCE_PROFILE = "performance_profile";
        public static final String POWER_MENU_ACTIONS = "power_menu_actions";
        public static final String PREFERRED_TTY_MODE = "preferred_tty_mode";
        public static final String PRINT_SERVICE_SEARCH_URI = "print_service_search_uri";
        public static final String PRIVACY_GUARD_DEFAULT = "privacy_guard_default";
        public static final String PRIVACY_GUARD_NOTIFICATION = "privacy_guard_notification";
        public static final String PROTECTED_COMPONENTS = "protected_components";
        public static final String PROTECTED_SMS_ADDRESSES = "protected_sms_addresses";
        public static final String QS_LOCATION_ADVANCED = "qs_location_advanced";
        @Deprecated
        public static final String QS_SHOW_BRIGHTNESS_SLIDER = "qs_show_brightness_slider";
        public static final String QS_TILES = "sysui_qs_tiles";
        @Deprecated
        public static final String QS_USE_MAIN_TILES = "sysui_qs_main_tiles";
        public static final String RECENTS_LONG_PRESS_ACTIVITY = "recents_long_press_activity";
        public static final String RING_HOME_BUTTON_BEHAVIOR = "ring_home_button_behavior";
        public static final int RING_HOME_BUTTON_BEHAVIOR_ANSWER = 2;
        public static final int RING_HOME_BUTTON_BEHAVIOR_DEFAULT = 1;
        public static final int RING_HOME_BUTTON_BEHAVIOR_DO_NOTHING = 1;
        public static final String RING_VOLUME_BUTTON_BEHAVIOR = "ring_volume_button_behavior";
        public static final int RING_VOLUME_BUTTON_BEHAVIOR_ANSWER = 2;
        public static final int RING_VOLUME_BUTTON_BEHAVIOR_DEFAULT = 1;
        public static final int RING_VOLUME_BUTTON_BEHAVIOR_DO_NOTHING = 1;
        public static final String SCREENSAVER_ACTIVATE_ON_DOCK = "screensaver_activate_on_dock";
        public static final String SCREENSAVER_ACTIVATE_ON_SLEEP = "screensaver_activate_on_sleep";
        public static final String SCREENSAVER_COMPONENTS = "screensaver_components";
        public static final String SCREENSAVER_DEFAULT_COMPONENT = "screensaver_default_component";
        public static final String SCREENSAVER_ENABLED = "screensaver_enabled";
        public static final String SEARCH_GLOBAL_SEARCH_ACTIVITY = "search_global_search_activity";
        public static final String SEARCH_MAX_RESULTS_PER_SOURCE = "search_max_results_per_source";
        public static final String SEARCH_MAX_RESULTS_TO_DISPLAY = "search_max_results_to_display";
        public static final String SEARCH_MAX_SHORTCUTS_RETURNED = "search_max_shortcuts_returned";
        public static final String SEARCH_MAX_SOURCE_EVENT_AGE_MILLIS = "search_max_source_event_age_millis";
        public static final String SEARCH_MAX_STAT_AGE_MILLIS = "search_max_stat_age_millis";
        public static final String SEARCH_MIN_CLICKS_FOR_SOURCE_RANKING = "search_min_clicks_for_source_ranking";
        public static final String SEARCH_MIN_IMPRESSIONS_FOR_SOURCE_RANKING = "search_min_impressions_for_source_ranking";
        public static final String SEARCH_NUM_PROMOTED_SOURCES = "search_num_promoted_sources";
        public static final String SEARCH_PER_SOURCE_CONCURRENT_QUERY_LIMIT = "search_per_source_concurrent_query_limit";
        public static final String SEARCH_PREFILL_MILLIS = "search_prefill_millis";
        public static final String SEARCH_PROMOTED_SOURCE_DEADLINE_MILLIS = "search_promoted_source_deadline_millis";
        public static final String SEARCH_QUERY_THREAD_CORE_POOL_SIZE = "search_query_thread_core_pool_size";
        public static final String SEARCH_QUERY_THREAD_MAX_POOL_SIZE = "search_query_thread_max_pool_size";
        public static final String SEARCH_SHORTCUT_REFRESH_CORE_POOL_SIZE = "search_shortcut_refresh_core_pool_size";
        public static final String SEARCH_SHORTCUT_REFRESH_MAX_POOL_SIZE = "search_shortcut_refresh_max_pool_size";
        public static final String SEARCH_SOURCE_TIMEOUT_MILLIS = "search_source_timeout_millis";
        public static final String SEARCH_THREAD_KEEPALIVE_SECONDS = "search_thread_keepalive_seconds";
        public static final String SEARCH_WEB_RESULTS_OVERRIDE_LIMIT = "search_web_results_override_limit";
        public static final String SELECTED_INPUT_METHOD_SUBTYPE = "selected_input_method_subtype";
        public static final String SELECTED_SPELL_CHECKER = "selected_spell_checker";
        public static final String SELECTED_SPELL_CHECKER_SUBTYPE = "selected_spell_checker_subtype";
        public static final String SETTINGS_CLASSNAME = "settings_classname";
        public static final String[] SETTINGS_TO_BACKUP = null;
        public static final String SHOW_IME_WITH_HARD_KEYBOARD = "show_ime_with_hard_keyboard";
        public static final String SHOW_NOTE_ABOUT_NOTIFICATION_HIDING = "show_note_about_notification_hiding";
        public static final String SKIP_FIRST_USE_HINTS = "skip_first_use_hints";
        public static final String SLEEP_TIMEOUT = "sleep_timeout";
        public static final String SMS_DEFAULT_APPLICATION = "sms_default_application";
        public static final String SPELL_CHECKER_ENABLED = "spell_checker_enabled";
        public static final String THEME_PREV_BOOT_API_LEVEL = "theme_prev_boot_api_level";
        public static final String TOUCH_EXPLORATION_ENABLED = "touch_exploration_enabled";
        public static final String TOUCH_EXPLORATION_GRANTED_ACCESSIBILITY_SERVICES = "touch_exploration_granted_accessibility_services";
        public static final String TRUST_AGENTS_INITIALIZED = "trust_agents_initialized";
        @Deprecated
        public static final String TTS_DEFAULT_COUNTRY = "tts_default_country";
        @Deprecated
        public static final String TTS_DEFAULT_LANG = "tts_default_lang";
        public static final String TTS_DEFAULT_LOCALE = "tts_default_locale";
        public static final String TTS_DEFAULT_PITCH = "tts_default_pitch";
        public static final String TTS_DEFAULT_RATE = "tts_default_rate";
        public static final String TTS_DEFAULT_SYNTH = "tts_default_synth";
        @Deprecated
        public static final String TTS_DEFAULT_VARIANT = "tts_default_variant";
        public static final String TTS_ENABLED_PLUGINS = "tts_enabled_plugins";
        @Deprecated
        public static final String TTS_USE_DEFAULTS = "tts_use_defaults";
        public static final String TTY_MODE_ENABLED = "tty_mode_enabled";
        public static final String TV_INPUT_CUSTOM_LABELS = "tv_input_custom_labels";
        public static final String TV_INPUT_HIDDEN_INPUTS = "tv_input_hidden_inputs";
        public static final String UI_NIGHT_MODE = "ui_night_mode";
        public static final String UNSAFE_VOLUME_MUSIC_ACTIVE_MS = "unsafe_volume_music_active_ms";
        public static final String USB_AUDIO_AUTOMATIC_ROUTING_DISABLED = "usb_audio_automatic_routing_disabled";
        @Deprecated
        public static final String USB_MASS_STORAGE_ENABLED = "usb_mass_storage_enabled";
        public static final String USER_SETUP_COMPLETE = "user_setup_complete";
        @Deprecated
        public static final String USE_GOOGLE_MAIL = "use_google_mail";
        public static final String VOICE_INTERACTION_SERVICE = "voice_interaction_service";
        public static final String VOICE_RECOGNITION_SERVICE = "voice_recognition_service";
        public static final String VOLUME_LINK_NOTIFICATION = "volume_link_notification";
        public static final String WAKE_GESTURE_ENABLED = "wake_gesture_enabled";
        @Deprecated
        public static final String WIFI_IDLE_MS = "wifi_idle_ms";
        @Deprecated
        public static final String WIFI_MAX_DHCP_RETRY_COUNT = "wifi_max_dhcp_retry_count";
        @Deprecated
        public static final String WIFI_MOBILE_DATA_TRANSITION_WAKELOCK_TIMEOUT_MS = "wifi_mobile_data_transition_wakelock_timeout_ms";
        @Deprecated
        public static final String WIFI_NETWORKS_AVAILABLE_NOTIFICATION_ON = "wifi_networks_available_notification_on";
        @Deprecated
        public static final String WIFI_NETWORKS_AVAILABLE_REPEAT_DELAY = "wifi_networks_available_repeat_delay";
        @Deprecated
        public static final String WIFI_NUM_OPEN_NETWORKS_KEPT = "wifi_num_open_networks_kept";
        @Deprecated
        public static final String WIFI_ON = "wifi_on";
        @Deprecated
        public static final String WIFI_WATCHDOG_ACCEPTABLE_PACKET_LOSS_PERCENTAGE = "wifi_watchdog_acceptable_packet_loss_percentage";
        @Deprecated
        public static final String WIFI_WATCHDOG_AP_COUNT = "wifi_watchdog_ap_count";
        @Deprecated
        public static final String WIFI_WATCHDOG_BACKGROUND_CHECK_DELAY_MS = "wifi_watchdog_background_check_delay_ms";
        @Deprecated
        public static final String WIFI_WATCHDOG_BACKGROUND_CHECK_ENABLED = "wifi_watchdog_background_check_enabled";
        @Deprecated
        public static final String WIFI_WATCHDOG_BACKGROUND_CHECK_TIMEOUT_MS = "wifi_watchdog_background_check_timeout_ms";
        @Deprecated
        public static final String WIFI_WATCHDOG_INITIAL_IGNORED_PING_COUNT = "wifi_watchdog_initial_ignored_ping_count";
        @Deprecated
        public static final String WIFI_WATCHDOG_MAX_AP_CHECKS = "wifi_watchdog_max_ap_checks";
        @Deprecated
        public static final String WIFI_WATCHDOG_ON = "wifi_watchdog_on";
        @Deprecated
        public static final String WIFI_WATCHDOG_PING_COUNT = "wifi_watchdog_ping_count";
        @Deprecated
        public static final String WIFI_WATCHDOG_PING_DELAY_MS = "wifi_watchdog_ping_delay_ms";
        @Deprecated
        public static final String WIFI_WATCHDOG_PING_TIMEOUT_MS = "wifi_watchdog_ping_timeout_ms";
        @Deprecated
        public static final String WIFI_WATCHDOG_WATCH_LIST = "wifi_watchdog_watch_list";
        public static final String WIMAX_ON = "wimax_on";
        private static boolean sIsSystemProcess;
        public static final Uri CONTENT_URI = Uri.parse("content://settings/secure");
        public static final String SYS_PROP_SETTING_VERSION = "sys.settings_secure_version";
        private static final NameValueCache sNameValueCache = new NameValueCache(SYS_PROP_SETTING_VERSION, CONTENT_URI, Settings.CALL_METHOD_GET_SECURE, Settings.CALL_METHOD_PUT_SECURE);
        private static ILockSettings sLockSettings = null;
        private static final HashSet<String> MOVED_TO_LOCK_SETTINGS = new HashSet<>(3);

        static {
            HashSet<String> hashSet = MOVED_TO_LOCK_SETTINGS;
            throw new VerifyError("bad dex opcode");
        }

        public static List<String> getDelimitedStringAsList(ContentResolver contentResolver, String str, String str2) {
            String string = getString(contentResolver, str);
            ArrayList arrayList = new ArrayList();
            if (!TextUtils.isEmpty(string)) {
                String[] split = TextUtils.split(string, Pattern.quote(str2));
                int length = split.length;
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= length) {
                        break;
                    }
                    String str3 = split[i2];
                    if (!TextUtils.isEmpty(str3)) {
                        arrayList.add(str3);
                    }
                    i = i2 + 1;
                }
            }
            return arrayList;
        }

        public static float getFloat(ContentResolver contentResolver, String str) throws SettingNotFoundException {
            return getFloatForUser(contentResolver, str, UserHandle.myUserId());
        }

        public static float getFloat(ContentResolver contentResolver, String str, float f) {
            return getFloatForUser(contentResolver, str, f, UserHandle.myUserId());
        }

        public static float getFloatForUser(ContentResolver contentResolver, String str, float f, int i) {
            String stringForUser = getStringForUser(contentResolver, str, i);
            float f2 = f;
            if (stringForUser != null) {
                try {
                    f2 = Float.parseFloat(stringForUser);
                } catch (NumberFormatException e) {
                    return f;
                }
            }
            return f2;
        }

        public static float getFloatForUser(ContentResolver contentResolver, String str, int i) throws SettingNotFoundException {
            String stringForUser = getStringForUser(contentResolver, str, i);
            if (stringForUser == null) {
                throw new SettingNotFoundException(str);
            }
            try {
                return Float.parseFloat(stringForUser);
            } catch (NumberFormatException e) {
                throw new SettingNotFoundException(str);
            }
        }

        public static int getInt(ContentResolver contentResolver, String str) throws SettingNotFoundException {
            return getIntForUser(contentResolver, str, UserHandle.myUserId());
        }

        public static int getInt(ContentResolver contentResolver, String str, int i) {
            return getIntForUser(contentResolver, str, i, UserHandle.myUserId());
        }

        public static int getIntForUser(ContentResolver contentResolver, String str, int i) throws SettingNotFoundException {
            if (LOCATION_MODE.equals(str)) {
                return getLocationModeForUser(contentResolver, i);
            }
            try {
                return Integer.parseInt(getStringForUser(contentResolver, str, i));
            } catch (NumberFormatException e) {
                throw new SettingNotFoundException(str);
            }
        }

        public static int getIntForUser(ContentResolver contentResolver, String str, int i, int i2) {
            int i3;
            if (LOCATION_MODE.equals(str)) {
                i3 = getLocationModeForUser(contentResolver, i2);
            } else {
                String stringForUser = getStringForUser(contentResolver, str, i2);
                i3 = i;
                if (stringForUser != null) {
                    try {
                        return Integer.parseInt(stringForUser);
                    } catch (NumberFormatException e) {
                        return i;
                    }
                }
            }
            return i3;
        }

        private static final int getLocationModeForUser(ContentResolver contentResolver, int i) {
            synchronized (Settings.mLocationSettingsLock) {
                boolean isLocationProviderEnabledForUser = isLocationProviderEnabledForUser(contentResolver, "gps", i);
                boolean isLocationProviderEnabledForUser2 = isLocationProviderEnabledForUser(contentResolver, "network", i);
                if (isLocationProviderEnabledForUser && isLocationProviderEnabledForUser2) {
                    return 3;
                }
                if (isLocationProviderEnabledForUser) {
                    return 1;
                }
                return isLocationProviderEnabledForUser2 ? 2 : 0;
            }
        }

        public static long getLong(ContentResolver contentResolver, String str) throws SettingNotFoundException {
            return getLongForUser(contentResolver, str, UserHandle.myUserId());
        }

        public static long getLong(ContentResolver contentResolver, String str, long j) {
            return getLongForUser(contentResolver, str, j, UserHandle.myUserId());
        }

        public static long getLongForUser(ContentResolver contentResolver, String str, int i) throws SettingNotFoundException {
            try {
                return Long.parseLong(getStringForUser(contentResolver, str, i));
            } catch (NumberFormatException e) {
                throw new SettingNotFoundException(str);
            }
        }

        public static long getLongForUser(ContentResolver contentResolver, String str, long j, int i) {
            String stringForUser = getStringForUser(contentResolver, str, i);
            if (stringForUser != null) {
                try {
                    return Long.parseLong(stringForUser);
                } catch (NumberFormatException e) {
                    return j;
                }
            }
            return j;
        }

        public static void getMovedKeys(HashSet<String> hashSet) {
            hashSet.addAll(MOVED_TO_GLOBAL);
        }

        public static String getString(ContentResolver contentResolver, String str) {
            return getStringForUser(contentResolver, str, UserHandle.myUserId());
        }

        public static String getStringForUser(ContentResolver contentResolver, String str, int i) {
            if (MOVED_TO_GLOBAL.contains(str)) {
                Log.w(Settings.TAG, "Setting " + str + " has moved from android.provider.Settings.Secure to android.provider.Settings.Global.");
                return Global.getStringForUser(contentResolver, str, i);
            }
            if (MOVED_TO_LOCK_SETTINGS.contains(str)) {
                synchronized (Secure.class) {
                    try {
                        if (sLockSettings == null) {
                            sLockSettings = ILockSettings.Stub.asInterface(ServiceManager.getService("lock_settings"));
                            sIsSystemProcess = Process.myUid() == 1000;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                if (sLockSettings != null && !sIsSystemProcess) {
                    try {
                        return sLockSettings.getString(str, "0", i);
                    } catch (RemoteException e) {
                    }
                }
            }
            return sNameValueCache.getStringForUser(contentResolver, str, i);
        }

        public static Uri getUriFor(String str) {
            if (MOVED_TO_GLOBAL.contains(str)) {
                Log.w(Settings.TAG, "Setting " + str + " has moved from android.provider.Settings.Secure to android.provider.Settings.Global, returning global URI.");
                return Global.getUriFor(Global.CONTENT_URI, str);
            }
            return getUriFor(CONTENT_URI, str);
        }

        @Deprecated
        public static final boolean isLocationProviderEnabled(ContentResolver contentResolver, String str) {
            return isLocationProviderEnabledForUser(contentResolver, str, UserHandle.myUserId());
        }

        @Deprecated
        public static final boolean isLocationProviderEnabledForUser(ContentResolver contentResolver, String str, int i) {
            return TextUtils.delimitedStringContains(getStringForUser(contentResolver, "location_providers_allowed", i), ',', str);
        }

        public static boolean putFloat(ContentResolver contentResolver, String str, float f) {
            return putFloatForUser(contentResolver, str, f, UserHandle.myUserId());
        }

        public static boolean putFloatForUser(ContentResolver contentResolver, String str, float f, int i) {
            return putStringForUser(contentResolver, str, Float.toString(f), i);
        }

        public static boolean putInt(ContentResolver contentResolver, String str, int i) {
            return putIntForUser(contentResolver, str, i, UserHandle.myUserId());
        }

        public static boolean putIntForUser(ContentResolver contentResolver, String str, int i, int i2) {
            return putStringForUser(contentResolver, str, Integer.toString(i), i2);
        }

        public static void putListAsDelimitedString(ContentResolver contentResolver, String str, String str2, List<String> list) {
            putString(contentResolver, str, TextUtils.join(str2, list));
        }

        public static boolean putLong(ContentResolver contentResolver, String str, long j) {
            return putLongForUser(contentResolver, str, j, UserHandle.myUserId());
        }

        public static boolean putLongForUser(ContentResolver contentResolver, String str, long j, int i) {
            return putStringForUser(contentResolver, str, Long.toString(j), i);
        }

        public static boolean putString(ContentResolver contentResolver, String str, String str2) {
            return putStringForUser(contentResolver, str, str2, UserHandle.myUserId());
        }

        public static boolean putStringForUser(ContentResolver contentResolver, String str, String str2, int i) {
            if (LOCATION_MODE.equals(str)) {
                return setLocationModeForUser(contentResolver, Integer.parseInt(str2), i);
            }
            if (MOVED_TO_GLOBAL.contains(str)) {
                Log.w(Settings.TAG, "Setting " + str + " has moved from android.provider.Settings.System to android.provider.Settings.Global");
                return Global.putStringForUser(contentResolver, str, str2, i);
            }
            return sNameValueCache.putStringForUser(contentResolver, str, str2, i);
        }

        private static final boolean setLocationModeForUser(ContentResolver contentResolver, int i, int i2) {
            boolean z;
            synchronized (Settings.mLocationSettingsLock) {
                boolean z2 = false;
                boolean z3 = false;
                switch (i) {
                    case 0:
                        break;
                    case 1:
                        z2 = true;
                        z3 = false;
                        break;
                    case 2:
                        z3 = true;
                        z2 = false;
                        break;
                    case 3:
                        z2 = true;
                        z3 = true;
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid location mode: " + i);
                }
                z = setLocationProviderEnabledForUser(contentResolver, "gps", z2, i2) && setLocationProviderEnabledForUser(contentResolver, "network", z3, i2);
            }
            return z;
        }

        @Deprecated
        public static final void setLocationProviderEnabled(ContentResolver contentResolver, String str, boolean z) {
            setLocationProviderEnabledForUser(contentResolver, str, z, UserHandle.myUserId());
        }

        @Deprecated
        public static final boolean setLocationProviderEnabledForUser(ContentResolver contentResolver, String str, boolean z, int i) {
            boolean putStringForUser;
            synchronized (Settings.mLocationSettingsLock) {
                putStringForUser = putStringForUser(contentResolver, "location_providers_allowed", z ? "+" + str : "-" + str, i);
            }
            return putStringForUser;
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/provider/Settings$SettingNotFoundException.class */
    public static class SettingNotFoundException extends AndroidException {
        public SettingNotFoundException(String str) {
            super(str);
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/provider/Settings$System.class */
    public static final class System extends NameValueTable {
        public static final String ACCELEROMETER_ROTATION = "accelerometer_rotation";
        public static final String ACCELEROMETER_ROTATION_ANGLES = "accelerometer_rotation_angles";
        @Deprecated
        public static final String ADB_ENABLED = "adb_enabled";
        public static final String ADVANCED_SETTINGS = "advanced_settings";
        public static final int ADVANCED_SETTINGS_DEFAULT = 0;
        @Deprecated
        public static final String AIRPLANE_MODE_ON = "airplane_mode_on";
        @Deprecated
        public static final String AIRPLANE_MODE_RADIOS = "airplane_mode_radios";
        @Deprecated
        public static final String AIRPLANE_MODE_TOGGLEABLE_RADIOS = "airplane_mode_toggleable_radios";
        public static final String ALARM_ALERT = "alarm_alert";
        public static final String ALLOW_LIGHTS = "allow_lights";
        @Deprecated
        public static final String ALWAYS_FINISH_ACTIVITIES = "always_finish_activities";
        @Deprecated
        public static final String ANDROID_ID = "android_id";
        @Deprecated
        public static final String ANIMATOR_DURATION_SCALE = "animator_duration_scale";
        public static final String APPEND_FOR_LAST_AUDIBLE = "_last_audible";
        public static final String APP_SWITCH_WAKE_SCREEN = "app_switch_wake_screen";
        public static final String ASSIST_WAKE_SCREEN = "assist_wake_screen";
        @Deprecated
        public static final String AUTO_TIME = "auto_time";
        @Deprecated
        public static final String AUTO_TIME_ZONE = "auto_time_zone";
        public static final String BACK_WAKE_SCREEN = "back_wake_screen";
        public static final String BATTERY_LIGHT_ENABLED = "battery_light_enabled";
        public static final String BATTERY_LIGHT_FULL_COLOR = "battery_light_full_color";
        public static final String BATTERY_LIGHT_LOW_COLOR = "battery_light_low_color";
        public static final String BATTERY_LIGHT_MEDIUM_COLOR = "battery_light_medium_color";
        public static final String BATTERY_LIGHT_PULSE = "battery_light_pulse";
        public static final int BLACKLIST_BLOCK = 1;
        public static final int BLACKLIST_DO_NOT_BLOCK = 0;
        public static final int BLACKLIST_MESSAGE_SHIFT = 4;
        public static final int BLACKLIST_PHONE_SHIFT = 0;
        public static final String BLUETOOTH_ACCEPT_ALL_FILES = "bluetooth_accept_all_files";
        public static final String BLUETOOTH_DISCOVERABILITY = "bluetooth_discoverability";
        public static final String BLUETOOTH_DISCOVERABILITY_TIMEOUT = "bluetooth_discoverability_timeout";
        @Deprecated
        public static final String BLUETOOTH_ON = "bluetooth_on";
        @Deprecated
        public static final String BUTTON_BACKLIGHT_TIMEOUT = "button_backlight_timeout";
        @Deprecated
        public static final String BUTTON_BRIGHTNESS = "button_brightness";
        public static final String CALL_LOG_DELETE_LIMIT = "call_log_delete_limit";
        public static final String CALL_RECORDING_FORMAT = "call_recording_format";
        public static final String CAMERA_LAUNCH = "camera_launch";
        public static final String CAMERA_SLEEP_ON_RELEASE = "camera_sleep_on_release";
        public static final String CAMERA_WAKE_SCREEN = "camera_wake_screen";
        @Deprecated
        public static final String CAR_DOCK_SOUND = "car_dock_sound";
        @Deprecated
        public static final String CAR_UNDOCK_SOUND = "car_undock_sound";
        public static final String[] CLONE_TO_MANAGED_PROFILE = null;
        public static final String CUSTOM_CARRIER_LABEL = "custom_carrier_label";
        @Deprecated
        public static final String DATA_ROAMING = "data_roaming";
        public static final String DATE_FORMAT = "date_format";
        @Deprecated
        public static final String DEBUG_APP = "debug_app";
        public static final Uri DEFAULT_ALARM_ALERT_URI = null;
        public static final Uri DEFAULT_NOTIFICATION_URI = null;
        public static final String DEFAULT_RINGTONE = "ringtone_default";
        public static final Uri DEFAULT_RINGTONE_URI = null;
        public static final Uri DEFAULT_RINGTONE_URI_2 = null;
        public static final Uri DEFAULT_RINGTONE_URI_3 = null;
        @Deprecated
        public static final String DESK_DOCK_SOUND = "desk_dock_sound";
        @Deprecated
        public static final String DESK_UNDOCK_SOUND = "desk_undock_sound";
        @Deprecated
        public static final String DEVICE_PROVISIONED = "device_provisioned";
        @Deprecated
        public static final String DEV_FORCE_SHOW_NAVBAR = "dev_force_show_navbar";
        public static final String DIALER_OPENCNAM_ACCOUNT_SID = "dialer_opencnam_account_sid";
        public static final String DIALER_OPENCNAM_AUTH_TOKEN = "dialer_opencnam_auth_token";
        @Deprecated
        public static final String DIM_SCREEN = "dim_screen";
        public static final String DIRECT_CALL_FOR_DIALER = "direct_call_for_dialer";
        public static final String DIRECT_CALL_FOR_MMS = "direct_call_for_mms";
        public static final String DISPLAY_AUTO_OUTDOOR_MODE = "display_auto_outdoor_mode";
        public static final String DISPLAY_COLOR_ADJUSTMENT = "display_color_adjustment";
        public static final String DISPLAY_COLOR_ENHANCE = "display_color_enhance";
        public static final String DISPLAY_LOW_POWER = "display_low_power";
        public static final String DISPLAY_TEMPERATURE_DAY = "display_temperature_day";
        public static final String DISPLAY_TEMPERATURE_MODE = "display_temperature_mode";
        public static final String DISPLAY_TEMPERATURE_NIGHT = "display_temperature_night";
        @Deprecated
        public static final String DOCK_SOUNDS_ENABLED = "dock_sounds_enabled";
        public static final String DOUBLE_TAP_SLEEP_GESTURE = "double_tap_sleep_gesture";
        public static final String DOUBLE_TAP_SLEEP_GESTURE_NAVBAR = "double_tap_sleep_gesture_navbar";
        public static final String DTMF_TONE_TYPE_WHEN_DIALING = "dtmf_tone_type";
        public static final String DTMF_TONE_WHEN_DIALING = "dtmf_tone";
        public static final String EGG_MODE = "egg_mode";
        public static final String ENABLE_CLOUD_LOCATION_LOOKUP = "enable_cloud_location_lookup";
        public static final String ENABLE_FORWARD_LOOKUP = "enable_forward_lookup";
        public static final String ENABLE_MWI_NOTIFICATION = "enable_mwi_notification";
        public static final String ENABLE_PEOPLE_LOOKUP = "enable_people_lookup";
        public static final String ENABLE_REVERSE_LOOKUP = "enable_reverse_lookup";
        public static final String ENABLE_STYLUS_GESTURES = "enable_stylus_gestures";
        public static final String END_BUTTON_BEHAVIOR = "end_button_behavior";
        public static final int END_BUTTON_BEHAVIOR_DEFAULT = 2;
        public static final int END_BUTTON_BEHAVIOR_HOME = 1;
        public static final int END_BUTTON_BEHAVIOR_SLEEP = 2;
        public static final String FONT_SCALE = "font_scale";
        public static final String FORWARD_LOOKUP_PROVIDER = "forward_lookup_provider";
        public static final String GESTURES_DOUBLE_TAP = "gestures_double_tap";
        public static final String GESTURES_DOWN_SWIPE = "gestures_down_swipe";
        public static final String GESTURES_LEFT_SWIPE = "gestures_left_swipe";
        public static final String GESTURES_LONG_PRESS = "gestures_long_press";
        public static final String GESTURES_RIGHT_SWIPE = "gestures_right_swipe";
        public static final String GESTURES_UP_SWIPE = "gestures_up_swipe";
        public static final String HAPTIC_FEEDBACK_ENABLED = "haptic_feedback_enabled";
        public static final String HEADSET_CONNECT_PLAYER = "headset_connect_player";
        public static final String HEARING_AID = "hearing_aid";
        public static final String HIDE_ROTATION_LOCK_TOGGLE_FOR_ACCESSIBILITY = "hide_rotation_lock_toggle_for_accessibility";
        public static final String HOME_WAKE_SCREEN = "home_wake_screen";
        @Deprecated
        public static final String HTTP_PROXY = "http_proxy";
        public static final String INCREASING_RING = "increasing_ring";
        public static final String INCREASING_RING_RAMP_UP_TIME = "increasing_ring_ramp_up_time";
        public static final String INCREASING_RING_START_VOLUME = "increasing_ring_start_vol";
        @Deprecated
        public static final String INSTALL_NON_MARKET_APPS = "install_non_market_apps";
        @Deprecated
        public static final String KEYBOARD_BRIGHTNESS = "keyboard_brightness";
        public static final String KEY_APP_SWITCH_ACTION = "key_app_switch_action";
        public static final String KEY_APP_SWITCH_LONG_PRESS_ACTION = "key_app_switch_long_press_action";
        public static final String KEY_ASSIST_ACTION = "key_assist_action";
        public static final String KEY_ASSIST_LONG_PRESS_ACTION = "key_assist_long_press_action";
        public static final String KEY_HOME_DOUBLE_TAP_ACTION = "key_home_double_tap_action";
        public static final String KEY_HOME_LONG_PRESS_ACTION = "key_home_long_press_action";
        public static final String KEY_MENU_ACTION = "key_menu_action";
        public static final String KEY_MENU_LONG_PRESS_ACTION = "key_menu_long_press_action";
        public static final String LISTVIEW_ANIMATION = "listview_animation";
        public static final String LISTVIEW_INTERPOLATOR = "listview_interpolator";
        public static final String LIVE_DISPLAY_HINTED = "live_display_hinted";
        @Deprecated
        public static final String LOCATION_PROVIDERS_ALLOWED = "location_providers_allowed";
        public static final String LOCKSCREEN_DISABLED = "lockscreen.disabled";
        public static final String LOCKSCREEN_PIN_SCRAMBLE_LAYOUT = "lockscreen_scramble_pin_layout";
        public static final String LOCKSCREEN_QUICK_UNLOCK_CONTROL = "lockscreen_quick_unlock_control";
        public static final String LOCKSCREEN_SOUNDS_ENABLED = "lockscreen_sounds_enabled";
        @Deprecated
        public static final String LOCK_PATTERN_ENABLED = "lock_pattern_autolock";
        @Deprecated
        public static final String LOCK_PATTERN_TACTILE_FEEDBACK_ENABLED = "lock_pattern_tactile_feedback_enabled";
        @Deprecated
        public static final String LOCK_PATTERN_VISIBLE = "lock_pattern_visible_pattern";
        @Deprecated
        public static final String LOCK_SOUND = "lock_sound";
        public static final String LOCK_TO_APP_ENABLED = "lock_to_app_enabled";
        @Deprecated
        public static final String LOGGING_ID = "logging_id";
        @Deprecated
        public static final String LOW_BATTERY_SOUND = "low_battery_sound";
        public static final String Locked_APP_LIST = "locked_app_list";
        public static final int MAX_NUM_RINGTONES = 3;
        public static final String MEDIA_BUTTON_RECEIVER = "media_button_receiver";
        public static final String MENU_WAKE_SCREEN = "menu_wake_screen";
        public static final String MICROPHONE_MUTE = "microphone_mute";
        @Deprecated
        public static final String MODE_RINGER = "mode_ringer";
        public static final String MODE_RINGER_STREAMS_AFFECTED = "mode_ringer_streams_affected";
        private static final HashSet<String> MOVED_TO_GLOBAL = null;
        private static final HashSet<String> MOVED_TO_SECURE_THEN_GLOBAL = null;
        public static final String MUTE_STREAMS_AFFECTED = "mute_streams_affected";
        public static final String NAVBAR_LEFT_IN_LANDSCAPE = "navigation_bar_left";
        public static final String NAVIGATION_BAR_HEIGHT = "navigation_bar_height";
        public static final String NAVIGATION_BAR_MENU_ARROW_KEYS = "navigation_bar_menu_arrow_keys";
        public static final String NAV_BUTTONS = "nav_buttons";
        @Deprecated
        public static final String NETWORK_PREFERENCE = "network_preference";
        @Deprecated
        public static final String NEXT_ALARM_FORMATTED = "next_alarm_formatted";
        public static final String NONE_IS_SILENT = "none_is_silent";
        @Deprecated
        public static final String NOTIFICATIONS_USE_RING_VOLUME = "notifications_use_ring_volume";
        public static final String NOTIFICATION_LIGHT_BRIGHTNESS_LEVEL = "notification_light_brightness_level";
        public static final String NOTIFICATION_LIGHT_MULTIPLE_LEDS_ENABLE = "notification_light_multiple_leds_enable";
        public static final String NOTIFICATION_LIGHT_PULSE = "notification_light_pulse";
        public static final String NOTIFICATION_LIGHT_PULSE_CALL_COLOR = "notification_light_pulse_call_color";
        public static final String NOTIFICATION_LIGHT_PULSE_CALL_LED_OFF = "notification_light_pulse_call_led_off";
        public static final String NOTIFICATION_LIGHT_PULSE_CALL_LED_ON = "notification_light_pulse_call_led_on";
        public static final String NOTIFICATION_LIGHT_PULSE_CUSTOM_ENABLE = "notification_light_pulse_custom_enable";
        public static final String NOTIFICATION_LIGHT_PULSE_CUSTOM_VALUES = "notification_light_pulse_custom_values";
        public static final String NOTIFICATION_LIGHT_PULSE_DEFAULT_COLOR = "notification_light_pulse_default_color";
        public static final String NOTIFICATION_LIGHT_PULSE_DEFAULT_LED_OFF = "notification_light_pulse_default_led_off";
        public static final String NOTIFICATION_LIGHT_PULSE_DEFAULT_LED_ON = "notification_light_pulse_default_led_on";
        public static final String NOTIFICATION_LIGHT_PULSE_VMAIL_COLOR = "notification_light_pulse_vmail_color";
        public static final String NOTIFICATION_LIGHT_PULSE_VMAIL_LED_OFF = "notification_light_pulse_vmail_led_off";
        public static final String NOTIFICATION_LIGHT_PULSE_VMAIL_LED_ON = "notification_light_pulse_vmail_led_on";
        public static final String NOTIFICATION_LIGHT_SCREEN_ON = "notification_light_screen_on_enable";
        public static final String NOTIFICATION_SOUND = "notification_sound";
        @Deprecated
        public static final String PARENTAL_CONTROL_ENABLED = "parental_control_enabled";
        @Deprecated
        public static final String PARENTAL_CONTROL_LAST_UPDATE = "parental_control_last_update";
        @Deprecated
        public static final String PARENTAL_CONTROL_REDIRECT_URL = "parental_control_redirect_url";
        public static final String PEOPLE_LOOKUP_PROVIDER = "people_lookup_provider";
        public static final String PHONE_BLACKLIST_ADVERTISEMENT_NUMBER_MODE = "phone_blacklist_advertisement_number";
        public static final String PHONE_BLACKLIST_ALL_NUMBER_MODE = "phone_blacklist_all_number";
        public static final String PHONE_BLACKLIST_ENABLED = "phone_blacklist_enabled";
        public static final String PHONE_BLACKLIST_FRAUD_NUMBER_MODE = "phone_blacklist_fraud_number";
        public static final String PHONE_BLACKLIST_HARASS_NUMBER_MODE = "phone_blacklist_harass_number";
        public static final String PHONE_BLACKLIST_NOTIFY_ENABLED = "phone_blacklist_notify_enabled";
        public static final String PHONE_BLACKLIST_PRIVATE_NUMBER_MODE = "phone_blacklist_private_number_enabled";
        public static final String PHONE_BLACKLIST_REGEX_ENABLED = "phone_blacklist_regex_enabled";
        public static final String PHONE_BLACKLIST_UNKNOWN_NUMBER_MODE = "phone_blacklist_unknown_number_enabled";
        public static final String POINTER_LOCATION = "pointer_location";
        public static final String POINTER_SPEED = "pointer_speed";
        @Deprecated
        public static final String POWER_SOUNDS_ENABLED = "power_sounds_enabled";
        public static final String PROXIMITY_ON_WAKE = "proximity_on_wake";
        @Deprecated
        public static final String QS_QUICK_PULLDOWN = "qs_quick_pulldown";
        @Deprecated
        public static final String QS_SHOW_BRIGHTNESS_SLIDER = "qs_show_brightness_slider";
        @Deprecated
        public static final String QS_TILES = "sysui_qs_tiles";
        @Deprecated
        public static final String QS_USE_MAIN_TILES = "sysui_qs_main_tiles";
        @Deprecated
        public static final String RADIO_BLUETOOTH = "bluetooth";
        @Deprecated
        public static final String RADIO_CELL = "cell";
        @Deprecated
        public static final String RADIO_NFC = "nfc";
        @Deprecated
        public static final String RADIO_WIFI = "wifi";
        @Deprecated
        public static final String RADIO_WIMAX = "wimax";
        public static final String RECENTS_CLEAR_ALL_IGNORED_FOREGROUND = "recents_clear_all_ignored_foreground";
        public static final String RECENTS_CLEAR_ALL_LOCATION = "recents_clear_all_location";
        public static final String RECENTS_SHOW_SEARCH_BAR = "recents_show_search_bar";
        public static final String REVERSE_LOOKUP_PROVIDER = "reverse_lookup_provider";
        public static final String RINGTONE = "ringtone";
        public static final String RINGTONE_2 = "ringtone_2";
        public static final String RINGTONE_3 = "ringtone_3";
        public static final String SCREEN_AUTO_BRIGHTNESS_ADJ = "screen_auto_brightness_adj";
        public static final String SCREEN_BRIGHTNESS = "screen_brightness";
        public static final String SCREEN_BRIGHTNESS_MODE = "screen_brightness_mode";
        public static final int SCREEN_BRIGHTNESS_MODE_AUTOMATIC = 1;
        public static final int SCREEN_BRIGHTNESS_MODE_MANUAL = 0;
        public static final String SCREEN_OFF_TIMEOUT = "screen_off_timeout";
        @Deprecated
        public static final String SETTINGS_CLASSNAME = "settings_classname";
        public static final String[] SETTINGS_TO_BACKUP = null;
        public static final String SETUP_WIZARD_HAS_RUN = "setup_wizard_has_run";
        public static final String SHOW_ALARM_ICON = "show_alarm_icon";
        public static final String SHOW_CLEAR_ALL_RECENTS = "show_clear_all_recents";
        public static final String SHOW_GTALK_SERVICE_STATUS = "SHOW_GTALK_SERVICE_STATUS";
        public static final String SHOW_HEADSET_ICON = "show_headset_icon";
        @Deprecated
        public static final String SHOW_PROCESSES = "show_processes";
        public static final String SHOW_SU_ICON = "show_su_icon";
        public static final String SHOW_TOUCHES = "show_touches";
        @Deprecated
        public static final String SHOW_WEB_SUGGESTIONS = "show_web_suggestions";
        public static final String SIP_ADDRESS_ONLY = "SIP_ADDRESS_ONLY";
        public static final String SIP_ALWAYS = "SIP_ALWAYS";
        @Deprecated
        public static final String SIP_ASK_ME_EACH_TIME = "SIP_ASK_ME_EACH_TIME";
        public static final String SIP_CALL_OPTIONS = "sip_call_options";
        public static final String SIP_RECEIVE_CALLS = "sip_receive_calls";
        public static final String SOUND_EFFECTS_ENABLED = "sound_effects_enabled";
        public static final String STATUSBAR_COMPONENT = "statusbar_component";
        public static final String STATUS_BAR_AM_PM = "status_bar_am_pm";
        public static final String STATUS_BAR_BATTERY_STYLE = "status_bar_battery_style";
        public static final String STATUS_BAR_BRIGHTNESS_CONTROL = "status_bar_brightness_control";
        public static final String STATUS_BAR_CARRIER = "status_bar_carrier";
        public static final String STATUS_BAR_CLOCK = "status_bar_clock";
        public static final String STATUS_BAR_CLOCK_SHOW_SECOND = "status_bar_clock_show_second";
        public static final String STATUS_BAR_IME_SWITCHER = "status_bar_ime_switcher";
        public static final String STATUS_BAR_NETWORK_TRAFFIC_STYLE = "status_bar_network_traffic_style";
        public static final String STATUS_BAR_NOTIF_COUNT = "status_bar_notif_count";
        @Deprecated
        public static final String STATUS_BAR_QUICK_QS_PULLDOWN = "qs_quick_pulldown";
        public static final String STATUS_BAR_SHOW_BATTERY_PERCENT = "status_bar_show_battery_percent";
        public static final String STATUS_BAR_SHOW_WEATHER = "status_bar_show_weather";
        @Deprecated
        public static final String STAY_ON_WHILE_PLUGGED_IN = "stay_on_while_plugged_in";
        public static final String STYLUS_ICON_ENABLED = "stylus_icon_enabled";
        public static final String SWAP_VOLUME_KEYS_ON_ROTATION = "swap_volume_keys_on_rotation";
        public static final String SYSTEM_PROFILES_ENABLED = "system_profiles_enabled";
        public static final String T9_SEARCH_INPUT_LOCALE = "t9_search_input_locale";
        public static final String TEXT_AUTO_CAPS = "auto_caps";
        public static final String TEXT_AUTO_PUNCTUATE = "auto_punctuate";
        public static final String TEXT_AUTO_REPLACE = "auto_replace";
        public static final String TEXT_SHOW_PASSWORD = "show_password";
        public static final String TIME_12_24 = "time_12_24";
        @Deprecated
        public static final String TRANSITION_ANIMATION_SCALE = "transition_animation_scale";
        public static final String TTY_MODE = "tty_mode";
        @Deprecated
        public static final String UNLOCK_SOUND = "unlock_sound";
        @Deprecated
        public static final String USB_MASS_STORAGE_ENABLED = "usb_mass_storage_enabled";
        public static final String USER_ROTATION = "user_rotation";
        public static final String USE_EDGE_SERVICE_FOR_GESTURES = "edge_service_for_gestures";
        @Deprecated
        public static final String USE_GOOGLE_MAIL = "use_google_mail";
        public static final String VIBRATE_INPUT_DEVICES = "vibrate_input_devices";
        public static final String VIBRATE_IN_SILENT = "vibrate_in_silent";
        public static final String VIBRATE_ON = "vibrate_on";
        public static final String VIBRATE_WHEN_RINGING = "vibrate_when_ringing";
        public static final String VOICE_LAUNCH_INTENT = "voice_launch_intent";
        public static final String VOICE_WAKEUP = "voice_wakeup";
        public static final String VOLBTN_MUSIC_CONTROLS = "volbtn_music_controls";
        public static final String VOLUME_ADJUST_SOUNDS_ENABLED = "volume_adjust_sounds_enabled";
        public static final String VOLUME_ALARM = "volume_alarm";
        public static final String VOLUME_BLUETOOTH_SCO = "volume_bluetooth_sco";
        public static final String VOLUME_KEYS_CONTROL_RING_STREAM = "volume_keys_control_ring_stream";
        public static final String VOLUME_KEY_CURSOR_CONTROL = "volume_key_cursor_control";
        public static final String VOLUME_MASTER = "volume_master";
        public static final String VOLUME_MASTER_MUTE = "volume_master_mute";
        public static final String VOLUME_MUSIC = "volume_music";
        public static final String VOLUME_NOTIFICATION = "volume_notification";
        public static final String VOLUME_RING = "volume_ring";
        public static final String[] VOLUME_SETTINGS = null;
        public static final String VOLUME_SYSTEM = "volume_system";
        public static final String VOLUME_VOICE = "volume_voice";
        public static final String VOLUME_WAKE_SCREEN = "volume_wake_screen";
        @Deprecated
        public static final String WAIT_FOR_DEBUGGER = "wait_for_debugger";
        public static final String WAKELOCK_BLOCKING_ENABLED = "wakelock_blocking_enabled";
        public static final String WAKELOCK_BLOCKING_LIST = "wakelock_blocking_list";
        @Deprecated
        public static final String WALLPAPER_ACTIVITY = "wallpaper_activity";
        public static final String WHEN_TO_MAKE_WIFI_CALLS = "when_to_make_wifi_calls";
        @Deprecated
        public static final String WIFI_MAX_DHCP_RETRY_COUNT = "wifi_max_dhcp_retry_count";
        @Deprecated
        public static final String WIFI_MOBILE_DATA_TRANSITION_WAKELOCK_TIMEOUT_MS = "wifi_mobile_data_transition_wakelock_timeout_ms";
        @Deprecated
        public static final String WIFI_NETWORKS_AVAILABLE_NOTIFICATION_ON = "wifi_networks_available_notification_on";
        @Deprecated
        public static final String WIFI_NETWORKS_AVAILABLE_REPEAT_DELAY = "wifi_networks_available_repeat_delay";
        @Deprecated
        public static final String WIFI_NUM_OPEN_NETWORKS_KEPT = "wifi_num_open_networks_kept";
        @Deprecated
        public static final String WIFI_ON = "wifi_on";
        @Deprecated
        public static final String WIFI_SLEEP_POLICY = "wifi_sleep_policy";
        @Deprecated
        public static final int WIFI_SLEEP_POLICY_DEFAULT = 0;
        @Deprecated
        public static final int WIFI_SLEEP_POLICY_NEVER = 2;
        @Deprecated
        public static final int WIFI_SLEEP_POLICY_NEVER_WHILE_PLUGGED = 1;
        @Deprecated
        public static final String WIFI_STATIC_DNS1 = "wifi_static_dns1";
        @Deprecated
        public static final String WIFI_STATIC_DNS2 = "wifi_static_dns2";
        @Deprecated
        public static final String WIFI_STATIC_GATEWAY = "wifi_static_gateway";
        @Deprecated
        public static final String WIFI_STATIC_IP = "wifi_static_ip";
        @Deprecated
        public static final String WIFI_STATIC_NETMASK = "wifi_static_netmask";
        @Deprecated
        public static final String WIFI_USE_STATIC_IP = "wifi_use_static_ip";
        @Deprecated
        public static final String WIFI_WATCHDOG_ACCEPTABLE_PACKET_LOSS_PERCENTAGE = "wifi_watchdog_acceptable_packet_loss_percentage";
        @Deprecated
        public static final String WIFI_WATCHDOG_AP_COUNT = "wifi_watchdog_ap_count";
        @Deprecated
        public static final String WIFI_WATCHDOG_BACKGROUND_CHECK_DELAY_MS = "wifi_watchdog_background_check_delay_ms";
        @Deprecated
        public static final String WIFI_WATCHDOG_BACKGROUND_CHECK_ENABLED = "wifi_watchdog_background_check_enabled";
        @Deprecated
        public static final String WIFI_WATCHDOG_BACKGROUND_CHECK_TIMEOUT_MS = "wifi_watchdog_background_check_timeout_ms";
        @Deprecated
        public static final String WIFI_WATCHDOG_INITIAL_IGNORED_PING_COUNT = "wifi_watchdog_initial_ignored_ping_count";
        @Deprecated
        public static final String WIFI_WATCHDOG_MAX_AP_CHECKS = "wifi_watchdog_max_ap_checks";
        @Deprecated
        public static final String WIFI_WATCHDOG_ON = "wifi_watchdog_on";
        @Deprecated
        public static final String WIFI_WATCHDOG_PING_COUNT = "wifi_watchdog_ping_count";
        @Deprecated
        public static final String WIFI_WATCHDOG_PING_DELAY_MS = "wifi_watchdog_ping_delay_ms";
        @Deprecated
        public static final String WIFI_WATCHDOG_PING_TIMEOUT_MS = "wifi_watchdog_ping_timeout_ms";
        @Deprecated
        public static final String WINDOW_ANIMATION_SCALE = "window_animation_scale";
        public static final String WINDOW_ORIENTATION_LISTENER_LOG = "window_orientation_listener_log";
        public static final Uri CONTENT_URI = Uri.parse("content://settings/system");
        public static final String SYS_PROP_SETTING_VERSION = "sys.settings_system_version";
        private static final NameValueCache sNameValueCache = new NameValueCache(SYS_PROP_SETTING_VERSION, CONTENT_URI, Settings.CALL_METHOD_GET_SYSTEM, Settings.CALL_METHOD_PUT_SYSTEM);
        private static final HashSet<String> MOVED_TO_SECURE = new HashSet<>(30);

        static {
            HashSet<String> hashSet = MOVED_TO_SECURE;
            throw new VerifyError("bad dex opcode");
        }

        public static void clearConfiguration(Configuration configuration) {
            configuration.fontScale = 0.0f;
        }

        public static void getConfiguration(ContentResolver contentResolver, Configuration configuration) {
            getConfigurationForUser(contentResolver, configuration, UserHandle.myUserId());
        }

        public static void getConfigurationForUser(ContentResolver contentResolver, Configuration configuration, int i) {
            configuration.fontScale = getFloatForUser(contentResolver, FONT_SCALE, configuration.fontScale, i);
            if (configuration.fontScale < 0.0f) {
                configuration.fontScale = 1.0f;
            }
        }

        public static List<String> getDelimitedStringAsList(ContentResolver contentResolver, String str, String str2) {
            String string = getString(contentResolver, str);
            ArrayList arrayList = new ArrayList();
            if (!TextUtils.isEmpty(string)) {
                String[] split = TextUtils.split(string, Pattern.quote(str2));
                int length = split.length;
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= length) {
                        break;
                    }
                    String str3 = split[i2];
                    if (!TextUtils.isEmpty(str3)) {
                        arrayList.add(str3);
                    }
                    i = i2 + 1;
                }
            }
            return arrayList;
        }

        public static float getFloat(ContentResolver contentResolver, String str) throws SettingNotFoundException {
            return getFloatForUser(contentResolver, str, UserHandle.myUserId());
        }

        public static float getFloat(ContentResolver contentResolver, String str, float f) {
            return getFloatForUser(contentResolver, str, f, UserHandle.myUserId());
        }

        public static float getFloatForUser(ContentResolver contentResolver, String str, float f, int i) {
            String stringForUser = getStringForUser(contentResolver, str, i);
            float f2 = f;
            if (stringForUser != null) {
                try {
                    f2 = Float.parseFloat(stringForUser);
                } catch (NumberFormatException e) {
                    return f;
                }
            }
            return f2;
        }

        public static float getFloatForUser(ContentResolver contentResolver, String str, int i) throws SettingNotFoundException {
            String stringForUser = getStringForUser(contentResolver, str, i);
            if (stringForUser == null) {
                throw new SettingNotFoundException(str);
            }
            try {
                return Float.parseFloat(stringForUser);
            } catch (NumberFormatException e) {
                throw new SettingNotFoundException(str);
            }
        }

        public static int getInt(ContentResolver contentResolver, String str) throws SettingNotFoundException {
            return getIntForUser(contentResolver, str, UserHandle.myUserId());
        }

        public static int getInt(ContentResolver contentResolver, String str, int i) {
            return getIntForUser(contentResolver, str, i, UserHandle.myUserId());
        }

        public static int getIntForUser(ContentResolver contentResolver, String str, int i) throws SettingNotFoundException {
            try {
                return Integer.parseInt(getStringForUser(contentResolver, str, i));
            } catch (NumberFormatException e) {
                throw new SettingNotFoundException(str);
            }
        }

        public static int getIntForUser(ContentResolver contentResolver, String str, int i, int i2) {
            String stringForUser = getStringForUser(contentResolver, str, i2);
            int i3 = i;
            if (stringForUser != null) {
                try {
                    i3 = Integer.parseInt(stringForUser);
                } catch (NumberFormatException e) {
                    return i;
                }
            }
            return i3;
        }

        public static long getLong(ContentResolver contentResolver, String str) throws SettingNotFoundException {
            return getLongForUser(contentResolver, str, UserHandle.myUserId());
        }

        public static long getLong(ContentResolver contentResolver, String str, long j) {
            return getLongForUser(contentResolver, str, j, UserHandle.myUserId());
        }

        public static long getLongForUser(ContentResolver contentResolver, String str, int i) throws SettingNotFoundException {
            try {
                return Long.parseLong(getStringForUser(contentResolver, str, i));
            } catch (NumberFormatException e) {
                throw new SettingNotFoundException(str);
            }
        }

        public static long getLongForUser(ContentResolver contentResolver, String str, long j, int i) {
            String stringForUser = getStringForUser(contentResolver, str, i);
            if (stringForUser != null) {
                try {
                    return Long.parseLong(stringForUser);
                } catch (NumberFormatException e) {
                    return j;
                }
            }
            return j;
        }

        public static void getMovedKeys(HashSet<String> hashSet) {
            hashSet.addAll(MOVED_TO_GLOBAL);
            hashSet.addAll(MOVED_TO_SECURE_THEN_GLOBAL);
        }

        public static void getNonLegacyMovedKeys(HashSet<String> hashSet) {
            hashSet.addAll(MOVED_TO_GLOBAL);
        }

        @Deprecated
        public static boolean getShowGTalkServiceStatus(ContentResolver contentResolver) {
            return getShowGTalkServiceStatusForUser(contentResolver, UserHandle.myUserId());
        }

        public static boolean getShowGTalkServiceStatusForUser(ContentResolver contentResolver, int i) {
            boolean z = false;
            if (getIntForUser(contentResolver, SHOW_GTALK_SERVICE_STATUS, 0, i) != 0) {
                z = true;
            }
            return z;
        }

        public static String getString(ContentResolver contentResolver, String str) {
            return getStringForUser(contentResolver, str, UserHandle.myUserId());
        }

        public static String getStringForUser(ContentResolver contentResolver, String str, int i) {
            if (MOVED_TO_SECURE.contains(str)) {
                Log.w(Settings.TAG, "Setting " + str + " has moved from android.provider.Settings.System to android.provider.Settings.Secure, returning read-only value.");
                return Secure.getStringForUser(contentResolver, str, i);
            } else if (MOVED_TO_GLOBAL.contains(str) || MOVED_TO_SECURE_THEN_GLOBAL.contains(str)) {
                Log.w(Settings.TAG, "Setting " + str + " has moved from android.provider.Settings.System to android.provider.Settings.Global, returning read-only value.");
                return Global.getStringForUser(contentResolver, str, i);
            } else {
                return sNameValueCache.getStringForUser(contentResolver, str, i);
            }
        }

        public static Uri getUriFor(String str) {
            if (MOVED_TO_SECURE.contains(str)) {
                Log.w(Settings.TAG, "Setting " + str + " has moved from android.provider.Settings.System to android.provider.Settings.Secure, returning Secure URI.");
                return Secure.getUriFor(Secure.CONTENT_URI, str);
            } else if (MOVED_TO_GLOBAL.contains(str) || MOVED_TO_SECURE_THEN_GLOBAL.contains(str)) {
                Log.w(Settings.TAG, "Setting " + str + " has moved from android.provider.Settings.System to android.provider.Settings.Global, returning read-only global URI.");
                return Global.getUriFor(Global.CONTENT_URI, str);
            } else {
                return getUriFor(CONTENT_URI, str);
            }
        }

        public static boolean hasInterestingConfigurationChanges(int i) {
            return (1073741824 & i) != 0;
        }

        public static boolean putConfiguration(ContentResolver contentResolver, Configuration configuration) {
            return putConfigurationForUser(contentResolver, configuration, UserHandle.myUserId());
        }

        public static boolean putConfigurationForUser(ContentResolver contentResolver, Configuration configuration, int i) {
            return putFloatForUser(contentResolver, FONT_SCALE, configuration.fontScale, i);
        }

        public static boolean putFloat(ContentResolver contentResolver, String str, float f) {
            return putFloatForUser(contentResolver, str, f, UserHandle.myUserId());
        }

        public static boolean putFloatForUser(ContentResolver contentResolver, String str, float f, int i) {
            return putStringForUser(contentResolver, str, Float.toString(f), i);
        }

        public static boolean putInt(ContentResolver contentResolver, String str, int i) {
            return putIntForUser(contentResolver, str, i, UserHandle.myUserId());
        }

        public static boolean putIntForUser(ContentResolver contentResolver, String str, int i, int i2) {
            return putStringForUser(contentResolver, str, Integer.toString(i), i2);
        }

        public static void putListAsDelimitedString(ContentResolver contentResolver, String str, String str2, List<String> list) {
            putString(contentResolver, str, TextUtils.join(str2, list));
        }

        public static boolean putLong(ContentResolver contentResolver, String str, long j) {
            return putLongForUser(contentResolver, str, j, UserHandle.myUserId());
        }

        public static boolean putLongForUser(ContentResolver contentResolver, String str, long j, int i) {
            return putStringForUser(contentResolver, str, Long.toString(j), i);
        }

        public static boolean putString(ContentResolver contentResolver, String str, String str2) {
            return putStringForUser(contentResolver, str, str2, UserHandle.myUserId());
        }

        public static boolean putStringForUser(ContentResolver contentResolver, String str, String str2, int i) {
            if (MOVED_TO_SECURE.contains(str)) {
                Log.w(Settings.TAG, "Setting " + str + " has moved from android.provider.Settings.System to android.provider.Settings.Secure, value is unchanged.");
                return false;
            } else if (MOVED_TO_GLOBAL.contains(str) || MOVED_TO_SECURE_THEN_GLOBAL.contains(str)) {
                Log.w(Settings.TAG, "Setting " + str + " has moved from android.provider.Settings.System to android.provider.Settings.Global, value is unchanged.");
                return false;
            } else {
                return sNameValueCache.putStringForUser(contentResolver, str, str2, i);
            }
        }

        @Deprecated
        public static void setShowGTalkServiceStatus(ContentResolver contentResolver, boolean z) {
            setShowGTalkServiceStatusForUser(contentResolver, z, UserHandle.myUserId());
        }

        @Deprecated
        public static void setShowGTalkServiceStatusForUser(ContentResolver contentResolver, boolean z, int i) {
            putIntForUser(contentResolver, SHOW_GTALK_SERVICE_STATUS, z ? 1 : 0, i);
        }
    }

    public static String getGTalkDeviceId(long j) {
        return "android-" + Long.toHexString(j);
    }
}
