package com.ss.android.downloadlib.constants;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/downloadlib/constants/EventConstants.class */
public class EventConstants {

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: source-8457232-dex2jar.jar:com/ss/android/downloadlib/constants/EventConstants$AppLinkSource.class */
    public @interface AppLinkSource {
        public static final String AUTO_BY_PACKAGE = "auto_by_package";
        public static final String AUTO_BY_URL = "auto_by_url";
        public static final String AUTO_CLICK = "auto_click";
        public static final String BY_PACKAGE = "by_package";
        public static final String BY_URL = "by_url";
        public static final String CLICK_BY_SDK = "click_by_sdk";
        public static final String DIALOG_BY_PACKAGE = "dialog_by_package";
        public static final String DIALOG_BY_URL = "dialog_by_url";
        public static final String DIALOG_CLICK = "dialog_click_by_sdk";
        public static final String NOTIFY_BY_PACKAGE = "notify_by_package";
        public static final String NOTIFY_BY_URL = "notify_by_url";
        public static final String NOTIFY_CLICK = "notify_click_by_sdk";
        public static final String OPEN_MARKET = "open_market";
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: source-8457232-dex2jar.jar:com/ss/android/downloadlib/constants/EventConstants$ExtraJson.class */
    public @interface ExtraJson {
        public static final String ANDROID_INT = "android_int";
        public static final String APK_DOWNLOAD_NEED_SIZE = "apk_download_need_size";
        public static final String APK_FILE_SIZE = "apk_file_size";
        public static final String APK_SIZE = "apk_size";
        public static final String APPLINK_SOURCE = "applink_source";
        public static final String AVAILABLE_SPACE = "available_space";
        public static final String CACHE_FILE_SIZE = "cache_file_size";
        public static final String CHECK_APPLINK_RESULT_BY_SDK = "check_applink_result_by_sdk";
        public static final String CLEAN_SHOW_DIALOG_ERROR_DETAIL = "show_dialog_error_detail";
        public static final String CLEAN_SHOW_DIALOG_IS_DOWNLOAD = "show_dialog_is_download";
        public static final String CLEAN_SHOW_DIALOG_RESULT = "show_dialog_result";
        public static final String CLEAN_SPACE_INSTALL_PARAMS = "clean_space_install_params";
        public static final String CLEAN_SPACE_LISTEN_IS_NULL = "clean_space_listener_is_null";
        public static final String CLEAN_TIME = "clean_time";
        public static final String CLICK_DOWNLOAD_SIZE = "click_download_size";
        public static final String CLICK_DOWNLOAD_TIME = "click_download_time";
        public static final String CLICK_TYPE = "download_click_type";
        public static final String DOWNLOAD_APK_SIZE = "download_apk_size";
        public static final String DOWNLOAD_FINISH_REASON = "finish_reason";
        public static final String DOWNLOAD_LENGTH = "download_length";
        public static final String DOWNLOAD_PERCENT = "download_percent";
        public static final String DOWNLOAD_SCENE = "download_scene";
        public static final String DOWNLOAD_TIME = "download_time";
        public static final String DOWNLOAD_URL = "download_url";
        public static final String EXPECT_FILE_LENGTH = "expect_file_length";
        public static final String FAIL_MSG = "fail_msg";
        public static final String FAIL_STATUS = "fail_status";
        public static final String FILE_NAME = "file_name";
        public static final String FINISH_FROM_RESERVE_WIFI = "finish_from_reserve_wifi";
        public static final String FUNNEL_TYPE = "funnel_type";
        public static final String INPUT_PACKAGE_NAME = "input_package_name";
        public static final String KEY_ALL_CONNECT_TIME = "all_connect_time";
        public static final String KEY_APP_NAME = "app_name";
        public static final String KEY_AVAILABLE_SPACE = "available_space";
        public static final String KEY_AVAILABLE_SPACE_RATIO = "available_space_ratio";
        public static final String KEY_BYTE_REQUIRED = "byte_required";
        public static final String KEY_BYTE_REQUIRED_AFTER = "byte_required_after";
        public static final String KEY_CAN_SHOW_NOTIFICATION = "can_show_notification";
        public static final String KEY_CHUNK_COUNT = "chunk_count";
        public static final String KEY_CLEAN_UP_TIME_COST = "clean_up_time_cost";
        public static final String KEY_CLEAR_SLEEP_TIME = "clear_sleep_time";
        public static final String KEY_CLEAR_SPACE_RESTART_TIMES = "clear_space_restart_times";
        public static final String KEY_CLICK_PAUSE_TIMES = "click_pause_times";
        public static final String KEY_CODE = "ttdownloader_code";
        public static final String KEY_CUR_BYTES = "cur_bytes";
        public static final String KEY_DEEPLINK_SOURCE = "deeplink_source";
        public static final String KEY_DOWNLOAD_FAILED_TIMES = "download_failed_times";
        public static final String KEY_DOWNLOAD_PERCENT = "download_percent";
        public static final String KEY_DOWNLOAD_PREPARE_TIME = "download_prepare_time";
        public static final String KEY_DOWNLOAD_SPEED = "download_speed";
        public static final String KEY_DOWNLOAD_STATUS = "download_status";
        public static final String KEY_DOWNLOAD_TIME = "download_time";
        public static final String KEY_ERROR_CODE = "error_code";
        public static final String KEY_FILE_LENGTH_GAP = "file_length_gap";
        public static final String KEY_FIRST_SPEED_TIME = "first_speed_time";
        public static final String KEY_HAS_SEND_DOWNLOAD_FAILED_FINALLY = "has_send_download_failed_finally";
        public static final String KEY_HIJACK_TYPE = "hijack_type";
        public static final String KEY_INSTALLED_APP_NAME = "installed_app_name";
        public static final String KEY_INSTALLED_PKG_NAME = "installed_pkg_name";
        public static final String KEY_INSTALLED_VERSION_CODE = "installed_version_code";
        public static final String KEY_INSTALL_AFTER_BACK_APP = "install_after_back_app";
        public static final String KEY_INSTALL_AGAIN = "install_again";
        public static final String KEY_INSTALL_TIME = "install_time";
        public static final String KEY_IS_DOWNLOAD_RESTARTED = "is_download_restarted";
        public static final String KEY_IS_DOWNLOAD_SERVICE_FOREGROUND = "is_download_service_foreground";
        public static final String KEY_IS_PATCH_APPLY_HANDLED = "is_patch_apply_handled";
        public static final String KEY_IS_UNKNOWN_SOURCE_ENABLED = "is_unknown_source_enabled";
        public static final String KEY_IS_UPDATE_DOWNLOAD = "is_update_download";
        public static final String KEY_LAUNCH_RESUMED = "launch_resumed";
        public static final String KEY_MESSAGE = "ttdownloader_message";
        public static final String KEY_NETWORK_QUALITY = "network_quality";
        public static final String KEY_ORDER_STATUS = "order_status";
        public static final String KEY_ORIGIN_MIME_TYPE = "origin_mime_type";
        public static final String KEY_REAL_MARKET_URL = "rmu";
        public static final String KEY_SPACE_BEFORE = "space_before";
        public static final String KEY_SPACE_CLEANED = "space_cleaned";
        public static final String KEY_STATUS_CODE = "status_code";
        public static final String KEY_TIME_FROM_DOWNLOAD_RESUME = "time_from_download_resume";
        public static final String KEY_TIME_FROM_START_DOWNLOAD = "time_from_start_download";
        public static final String KEY_TOTAL_BYTES = "total_bytes";
        public static final String KEY_TYPE = "ttdownloader_type";
        public static final String KEY_UNINSTALL_RESUME_COUNT = "uninstall_resume_count";
        public static final String KEY_VERSION_CODE_DIFF = "version_code_diff";
        public static final String MARKET_URL = "market_url";
        public static final String MD5 = "md5";
        public static final String MIME_TYPE = "mime_type";
        public static final String MODEL_ID = "model_id";
        public static final String NETWORK_AVAILABLE = "network_available";
        public static final String NETWORK_IS_WIFI = "network_is_wifi";
        public static final String OPEN_URL = "open_url";
        public static final String OTHER_FILE_SIZE = "other_file_size";
        public static final String PACKAGE_NAME = "package_name";
        public static final String PACKAGE_SIZE = "package_size";
        public static final String PAUSE_OPTIMISE_ACTION = "pause_optimise_action";
        public static final String PAUSE_OPTIMISE_TYPE = "pause_optimise_type";
        public static final String PERMISSION_NOTIFICATION = "permission_notification";
        public static final String PERMISSION_UNKNOWN_SOURCE_INSTALL = "permission_unknown_source_install";
        public static final String QUITE_CLEAN_SIZE = "quite_clean_size";
        public static final String REAL_PACKAGE_NAME = "real_package_name";
        public static final String REMAIN_FILE_SIZE = "remain_file_size";
        public static final String RESERVE_WIFI_SOURCE = "reserve_wifi_source";
        public static final String RESERVE_WIFI_STATUS = "reserve_wifi_status";
        public static final String ROM_NAME = "rom_name";
        public static final String ROM_VERSION = "rom_version";
        public static final String SAVE_PATH = "save_path";
        public static final String SCAN_FILE_LESS_THEN_NEED_SIZE = "scan_file_less_then_need_size";
        public static final String SCAN_SPACE = "scan_space";
        public static final String SCAN_TIME = "scan_time";
        public static final String SPACE_AFTER_CLEAN = "space_after_clean";
        public static final String SPACE_BEFORE_CLEAN = "space_before_clean";
        public static final String SPACE_CLEAN_SIZE = "space_clean_size";
        public static final String SPACE_ENOUGH = "space_enough";
        public static final String SWITCH_STATUS = "switch_status";
        public static final String TEMP_FILE_SIZE = "temp_file_size";
        public static final String TIME_AFTER_CLICK = "time_after_click";
        public static final String TOTAL_SPACE = "total_space";
        public static final String TTDOWNLOADER = "ttdownloader";
        public static final String TTMD5_STATUS = "ttmd5_status";
        public static final String UNITY_LABEL = "unity_label";
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: source-8457232-dex2jar.jar:com/ss/android/downloadlib/constants/EventConstants$Label.class */
    public @interface Label {
        public static final String ADD_ORDER_DOWNLOAD = "add_order_download";
        public static final String ANTI_HIJACK_RESULT = "ah_result";
        public static final String ANTI_MARKET_RESULT = "am_result";
        public static final String API_HIJACK = "api_hijack";
        public static final String APPLINK_CLICK = "applink_click";
        public static final String BACK_DIALOG_EXIT = "backdialog_exit";
        public static final String BACK_DIALOG_INSTALL = "backdialog_install";
        public static final String BACK_DIALOG_SHOW = "backdialog_show";
        public static final String CLICK = "click";
        public static final String CLICK_CONTINUE = "click_continue";
        public static final String CLICK_INSTALL = "click_install";
        public static final String CLICK_PAUSE = "click_pause";
        public static final String CLICK_START = "click_start";
        public static final String DEEPLINK_APP_OPEN = "deeplink_app_open";
        public static final String DEEPLINK_APP_OPEN_FAIL = "deeplink_app_open_fail";
        public static final String DEEPLINK_FAILED = "deeplink_failed";
        public static final String DEEPLINK_QUICKAPP_FAILED = "deeplink_quickapp_failed";
        public static final String DEEPLINK_QUICKAPP_SUCCESS = "deeplink_quickapp_success";
        public static final String DEEPLINK_SUCCESS = "deeplink_success";
        public static final String DEEPLINK_URL_OPEN = "deeplink_url_open";
        public static final String DEEPLINK_URL_OPEN_FAIL = "deeplink_url_open_fail";
        public static final String DELAY_INSTALLED = "delayinstall_installed";
        public static final String DELAY_INSTALL_CONFLICT = "delayinstall_conflict_with_back_dialog";
        public static final String DELAY_INSTALL_LOST = "delayinstall_file_lost";
        public static final String DELAY_INSTALL_START = "delayinstall_install_start";
        public static final String DOWNLOAD_CANCEL = "download_cancel";
        public static final String DOWNLOAD_FAILED = "download_failed";
        public static final String DOWNLOAD_FAILED_FINALLY = "download_failed_finally";
        public static final String DOWNLOAD_FINISH = "download_finish";
        public static final String DOWNLOAD_RESUME = "download_resume";
        public static final String DOWNLOAD_UNCOMPLETED = "download_uncompleted";
        public static final String FILE_STATUS = "file_status";
        public static final String INSTALL_FAILED = "install_failed";
        public static final String INSTALL_FINISH = "install_finish";
        public static final String INSTALL_FINISH_HIJACK = "install_finish_hijack";
        public static final String INSTALL_FINISH_MAY_HIJACK = "install_finish_may_hijack";
        public static final String INSTALL_GUIDE_SHOW = "install_guide_show";
        public static final String INSTALL_WINDOW_SHOW = "install_window_show";
        public static final String LP_APP_DIALOG_CLICK = "lp_app_dialog_click";
        public static final String LP_APP_DIALOG_SHOW = "lp_app_dialog_show";
        public static final String LP_APP_DIALOG_TRY_SHOW = "lp_app_dialog_try_show";
        public static final String LP_COMPLIANCE_ERROR = "lp_compliance_error";
        public static final String LP_DOWNLOAD_DIALOG_CANCEL = "landing_download_dialog_cancel";
        public static final String LP_DOWNLOAD_DIALOG_CONFIRM = "landing_download_dialog_confirm";
        public static final String LP_DOWNLOAD_DIALOG_SHOW = "landing_download_dialog_show";
        public static final String MARKET_CLICK_OPEN = "market_click_open";
        public static final String MARKET_OPEN_FAILED = "market_open_failed";
        public static final String MARKET_OPEN_SUCCESS = "market_open_success";
        public static final String NOTIFICATION_CLICK = "download_notification_click";
        public static final String NOTIFICATION_CONTINUE = "download_notification_continue";
        public static final String NOTIFICATION_INSTALL = "download_notification_install";
        public static final String NOTIFICATION_PAUSE = "download_notification_pause";
        public static final String NOTIFICATION_SHOW = "download_notification_show";
        public static final String NOTIFICATION_TRY_SHOW = "download_notification_try_show";
        public static final String OPEN_APP_DIALOG_CANCEL = "market_openapp_cancel";
        public static final String OPEN_APP_DIALOG_SHOW = "market_openapp_window_show";
        public static final String ORDER_DOWNLOAD_CHECK = "order_download_check";
        public static final String ORDER_DOWNLOAD_QUERY = "order_download_query";
        public static final String ORDER_DOWNLOAD_QUERY_RESULT = "order_download_query_result";
        public static final String PACKAGE_NAME_ERROR = "package_name_error";
        public static final String PAUSE_RESERVE_WIFI_CANCEL = "pause_reserve_wifi_cancel";
        public static final String PAUSE_RESERVE_WIFI_CANCEL_ON_WIFI = "pause_reserve_wifi_cancel_on_wifi";
        public static final String PAUSE_RESERVE_WIFI_CONFIRM = "pause_reserve_wifi_confirm";
        public static final String PAUSE_RESERVE_WIFI_CONTINUE = "pause_reserve_wifi_continue";
        public static final String PAUSE_RESERVE_WIFI_DIALOG_SHOW = "pause_reserve_wifi_dialog_show";
        public static final String STORAGE_DENY = "storage_deny";
        public static final String UNITY = "ttdownloader_unity";
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: source-8457232-dex2jar.jar:com/ss/android/downloadlib/constants/EventConstants$Refer.class */
    public @interface Refer {
        public static final String LP_APP_DETAIL_CLICK_CLOSE = "lp_app_detail_click_close";
        public static final String LP_APP_DETAIL_CLICK_DOWNLOAD = "lp_app_detail_click_download";
        public static final String LP_APP_DIALOG_CANCEL = "lp_app_dialog_cancel";
        public static final String LP_APP_DIALOG_CLICK_DETAIL = "lp_app_dialog_click_detail";
        public static final String LP_APP_DIALOG_CLICK_DOWNLOAD = "lp_app_dialog_click_download";
        public static final String LP_APP_DIALOG_CLICK_GIVE_UP = "lp_app_dialog_click_giveup";
        public static final String LP_APP_DIALOG_CLICK_PRIVACY = "lp_app_dialog_click_privacy";
        public static final String LP_APP_PRIVACY_CLICK_CLOSE = "lp_app_privacy_click_close";
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: source-8457232-dex2jar.jar:com/ss/android/downloadlib/constants/EventConstants$Tag.class */
    public @interface Tag {
        public static final String EMBEDED_AD = "embeded_ad";
        public static final String LANDING_H5_DOWNLOAD_AD_BUTTON = "landing_h5_download_ad_button";
        public static final String NOTIFICATION = "download_notification";
        public static final String ORDER_DOWNLOAD = "order_download";
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: source-8457232-dex2jar.jar:com/ss/android/downloadlib/constants/EventConstants$UnityLabel.class */
    public @interface UnityLabel {
        public static final String CLEAN_DIALOG_CLOSE = "cleanspace_window_exit";
        public static final String CLEAN_DIALOG_CONFIRM = "cleanspace_clean_confirm";
        public static final String CLEAN_DIALOG_LAST_SCAN_RESULT_NULL = "cleanspace_last_scan_results_error";
        public static final String CLEAN_EXCEPTION = "cleanspace_clean_exception";
        public static final String CLEAN_FINISH = "cleanspace_clean_finish";
        public static final String CLEAN_QUITE_FINISH = "clean_quite_finish";
        public static final String CLEAN_RESUME_START = "cleanspace_resume_start";
        public static final String CLEAN_SHOW_DIALOG = "cleanspace_window_show";
        public static final String CLEAN_SPACE_INSTALL = "clean_space_install";
        public static final String CLEAN_SPACE_NO_ENOUGH = "clean_space_no_enough_for_download";
        public static final String CLEAN_SPACE_TASK = "cleanspace_task";
        public static final String CLEAN_START = "cleanspace_clean_start";
        public static final String DEEPLINK_DELAY_INVOKE = "deeplink_delay_invoke";
        public static final String DEEPLINK_DELAY_TIMEOUT = "deeplink_delay_timeout";
        public static final String DEEPLINK_SUCCESS_2 = "deeplink_success_2";
        public static final String DOWNLOAD_AFTER_QUITE_CLEAN = "cleanspace_download_after_quite_clean";
        public static final String DOWNLOAD_CAN_RESTART = "download_can_restart";
        public static final String DOWNLOAD_FAILED_FOR_SPACE = "download_failed_for_space";
        public static final String DOWNLOAD_SDK_ERROR = "download_sdk_error";
        public static final String INSTALLER_DELAY_FAILED = "installer_delay_failed";
        public static final String INSTALLER_DELAY_SUCCESS = "installer_delay_success";
        public static final String INSTALL_DELAY_INVOKE = "install_delay_invoke";
        public static final String LABEL_EXTERNAL_PERMISSION = "label_external_permission";
        public static final String MARKET_DELAY_FAILED = "market_delay_failed";
        public static final String MARKET_DELAY_SUCCESS = "market_delay_success";
        public static final String NEED_USER_CLEAN_SPACE = "cleanspace_need_user_clean";
        public static final String OPTIMIZATION_CLEAN = "cleanup";
        public static final String PAUSE_OPTIMISE = "pause_optimise";
        public static final String PAUSE_RESERVE_WIFI = "pause_reserve_wifi";
        public static final String PAUSE_RESERVE_WIFI_SWITCH_STATUS = "pause_reserve_wifi_switch_status";
        public static final String SCAN_EXCEPTION = "cleanspace_scan_exception";
        public static final String SCAN_FINISH = "cleanspace_scan_finish";
        public static final String SCAN_START = "cleanspace_scan_start";
        public static final String TTD_PREF_MONITOR = "ttd_pref_monitor";
    }
}
