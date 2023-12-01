package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.smtt.sdk.TbsLogReport;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/smtt/sdk/TbsDownloadConfig.class */
public class TbsDownloadConfig {
    public static final int CMD_ID_DOWNLOAD_FILE = 101;
    public static final int CMD_ID_FILE_UPLOAD = 100;
    public static final long DEFAULT_RETRY_INTERVAL_SEC = 86400;
    public static final int ERROR_DOWNLOAD = 2;
    public static final int ERROR_INSTALL = 5;
    public static final int ERROR_LOAD = 6;
    public static final int ERROR_NONE = 1;
    public static final int ERROR_REPORTED = 0;
    public static final int ERROR_UNZIP = 4;
    public static final int ERROR_VERIFY = 3;

    /* renamed from: a  reason: collision with root package name */
    private static TbsDownloadConfig f38761a;
    private Context b;
    public SharedPreferences mPreferences;
    public Map<String, Object> mSyncMap = new HashMap();

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/smtt/sdk/TbsDownloadConfig$TbsConfigKey.class */
    public interface TbsConfigKey {
        public static final String KEY_APP_METADATA = "app_metadata";
        public static final String KEY_APP_VERSIONCODE = "app_versioncode";
        public static final String KEY_APP_VERSIONCODE_FOR_SWITCH = "app_versioncode_for_switch";
        public static final String KEY_APP_VERSIONNAME = "app_versionname";
        public static final String KEY_BACKUPCORE_DELFILELIST = "backupcore_delfilelist";
        public static final String KEY_COUNT_REQUEST_FAIL_IN_24HOURS = "count_request_fail_in_24hours";
        public static final String KEY_DECOUPLECOREVERSION = "tbs_decouplecoreversion";
        public static final String KEY_DESkEY_TOKEN = "tbs_deskey_token";
        public static final String KEY_DEVICE_CPUABI = "device_cpuabi";
        public static final String KEY_DOWNLOADDECOUPLECORE = "tbs_downloaddecouplecore";
        public static final String KEY_DOWNLOADURL_LIST = "tbs_downloadurl_list";
        public static final String KEY_DOWNLOAD_FAILED_MAX_RETRYTIMES = "tbs_download_failed_max_retrytimes";
        public static final String KEY_DOWNLOAD_FAILED_RETRYTIMES = "tbs_download_failed_retrytimes";
        public static final String KEY_DOWNLOAD_INTERRUPT_CODE = "tbs_download_interrupt_code";
        public static final String KEY_DOWNLOAD_INTERRUPT_CODE_REASON = "tbs_download_interrupt_code_reason";
        public static final String KEY_DOWNLOAD_INTERRUPT_TIME = "tbs_download_interrupt_time";
        public static final String KEY_DOWNLOAD_MAXFLOW = "tbs_download_maxflow";
        public static final String KEY_DOWNLOAD_MIN_FREE_SPACE = "tbs_download_min_free_space";
        public static final String KEY_DOWNLOAD_SINGLE_TIMEOUT = "tbs_single_timeout";
        public static final String KEY_DOWNLOAD_SUCCESS_MAX_RETRYTIMES = "tbs_download_success_max_retrytimes";
        public static final String KEY_DOWNLOAD_SUCCESS_RETRYTIMES = "tbs_download_success_retrytimes";
        public static final String KEY_FULL_PACKAGE = "request_full_package";
        public static final String KEY_GUID = "tbs_guid";
        public static final String KEY_INSTALL_INTERRUPT_CODE = "tbs_install_interrupt_code";
        public static final String KEY_IS_OVERSEA = "is_oversea";
        public static final String KEY_LAST_CHECK = "last_check";
        public static final String KEY_LAST_DOWNLOAD_DECOUPLE_CORE = "last_download_decouple_core";
        public static final String KEY_LAST_REQUEST_SUCCESS = "last_request_success";
        public static final String KEY_LAST_THIRDAPP_SENDREQUEST_COREVERSION = "last_thirdapp_sendrequest_coreversion";
        public static final String KEY_NEEDDOWNLOAD = "tbs_needdownload";
        public static final String KEY_REQUEST_FAIL = "request_fail";
        public static final String KEY_RESPONSECODE = "tbs_responsecode";
        public static final String KEY_RETRY_INTERVAL = "retry_interval";
        public static final String KEY_STOP_PRE_OAT = "tbs_stop_preoat";
        public static final String KEY_SWITCH_BACKUPCORE_ENABLE = "switch_backupcore_enable";
        public static final String KEY_TBSAPKFILESIZE = "tbs_apkfilesize";
        public static final String KEY_TBSAPK_MD5 = "tbs_apk_md5";
        public static final String KEY_TBSDOWNLOADURL = "tbs_downloadurl";
        public static final String KEY_TBSDOWNLOAD_FLOW = "tbs_downloadflow";
        public static final String KEY_TBSDOWNLOAD_STARTTIME = "tbs_downloadstarttime";
        public static final String KEY_TBS_CORE_LOAD_RENAME_FILE_LOCK_ENABLE = "tbs_core_load_rename_file_lock_enable";
        public static final String KEY_TBS_CORE_LOAD_RENAME_FILE_LOCK_WAIT_ENABLE = "tbs_core_load_rename_file_lock_wait_enable";
        public static final String KEY_TBS_DOWNLOAD_V = "tbs_download_version";
        public static final String KEY_TBS_DOWNLOAD_V_TYPE = "tbs_download_version_type";
        public static final String KEY_USE_BACKUP_VERSION = "use_backup_version";
        public static final String KEY_USE_BUGLY = "tbs_use_bugly";
    }

    private TbsDownloadConfig(Context context) {
        this.mPreferences = context.getSharedPreferences("tbs_download_config", 4);
        Context applicationContext = context.getApplicationContext();
        this.b = applicationContext;
        if (applicationContext == null) {
            this.b = context;
        }
    }

    public static TbsDownloadConfig getInstance() {
        TbsDownloadConfig tbsDownloadConfig;
        synchronized (TbsDownloadConfig.class) {
            try {
                tbsDownloadConfig = f38761a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return tbsDownloadConfig;
    }

    public static TbsDownloadConfig getInstance(Context context) {
        TbsDownloadConfig tbsDownloadConfig;
        synchronized (TbsDownloadConfig.class) {
            try {
                if (f38761a == null) {
                    f38761a = new TbsDownloadConfig(context);
                }
                tbsDownloadConfig = f38761a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return tbsDownloadConfig;
    }

    public void clear() {
        try {
            this.mSyncMap.clear();
            SharedPreferences.Editor edit = this.mPreferences.edit();
            edit.clear();
            edit.commit();
        } catch (Exception e) {
        }
    }

    public void commit() {
        synchronized (this) {
            try {
                SharedPreferences.Editor edit = this.mPreferences.edit();
                for (String str : this.mSyncMap.keySet()) {
                    Object obj = this.mSyncMap.get(str);
                    if (obj instanceof String) {
                        edit.putString(str, (String) obj);
                    } else if (obj instanceof Boolean) {
                        edit.putBoolean(str, ((Boolean) obj).booleanValue());
                    } else if (obj instanceof Long) {
                        edit.putLong(str, ((Long) obj).longValue());
                    } else if (obj instanceof Integer) {
                        edit.putInt(str, ((Integer) obj).intValue());
                    } else if (obj instanceof Float) {
                        edit.putFloat(str, ((Float) obj).floatValue());
                    }
                }
                edit.commit();
                this.mSyncMap.clear();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public int getDownloadFailedMaxRetrytimes() {
        int i;
        synchronized (this) {
            int i2 = this.mPreferences.getInt(TbsConfigKey.KEY_DOWNLOAD_FAILED_MAX_RETRYTIMES, 0);
            i = i2;
            if (i2 == 0) {
                i = 100;
            }
        }
        return i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0072, code lost:
        if (r0 == (-121)) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int getDownloadInterruptCode() {
        /*
            Method dump skipped, instructions count: 246
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.TbsDownloadConfig.getDownloadInterruptCode():int");
    }

    public long getDownloadMaxflow() {
        long j;
        synchronized (this) {
            int i = this.mPreferences.getInt(TbsConfigKey.KEY_DOWNLOAD_MAXFLOW, 0);
            int i2 = i;
            if (i == 0) {
                i2 = 20;
            }
            j = i2 * 1024;
        }
        return j * 1024;
    }

    public long getDownloadMinFreeSpace() {
        long j;
        synchronized (this) {
            int i = 0;
            int i2 = this.mPreferences.getInt(TbsConfigKey.KEY_DOWNLOAD_MIN_FREE_SPACE, 0);
            if (i2 != 0) {
                i = i2;
            }
            j = i * 1024;
        }
        return j * 1024;
    }

    public long getDownloadSingleTimeout() {
        long j;
        synchronized (this) {
            long j2 = this.mPreferences.getLong(TbsConfigKey.KEY_DOWNLOAD_SINGLE_TIMEOUT, 0L);
            j = j2;
            if (j2 == 0) {
                j = 1200000;
            }
        }
        return j;
    }

    public int getDownloadSuccessMaxRetrytimes() {
        int i;
        synchronized (this) {
            int i2 = this.mPreferences.getInt(TbsConfigKey.KEY_DOWNLOAD_SUCCESS_MAX_RETRYTIMES, 0);
            i = i2;
            if (i2 == 0) {
                i = 3;
            }
        }
        return i;
    }

    public long getRetryInterval() {
        synchronized (this) {
            if (TbsDownloader.getRetryIntervalInSeconds() >= 0) {
                return TbsDownloader.getRetryIntervalInSeconds();
            }
            return this.mPreferences.getLong(TbsConfigKey.KEY_RETRY_INTERVAL, 86400L);
        }
    }

    public boolean getTbsCoreLoadRenameFileLockEnable() {
        boolean z;
        synchronized (this) {
            z = true;
            try {
                z = this.mPreferences.getBoolean(TbsConfigKey.KEY_TBS_CORE_LOAD_RENAME_FILE_LOCK_ENABLE, true);
            } catch (Exception e) {
            }
        }
        return z;
    }

    public boolean getTbsCoreLoadRenameFileLockWaitEnable() {
        boolean z;
        synchronized (this) {
            z = true;
            try {
                z = this.mPreferences.getBoolean(TbsConfigKey.KEY_TBS_CORE_LOAD_RENAME_FILE_LOCK_WAIT_ENABLE, true);
            } catch (Exception e) {
            }
        }
        return z;
    }

    public boolean isOverSea() {
        boolean z;
        synchronized (this) {
            z = this.mPreferences.getBoolean(TbsConfigKey.KEY_IS_OVERSEA, false);
        }
        return z;
    }

    public void setDownloadInterruptCode(int i) {
        synchronized (this) {
            try {
                SharedPreferences.Editor edit = this.mPreferences.edit();
                edit.putInt(TbsConfigKey.KEY_DOWNLOAD_INTERRUPT_CODE, i);
                edit.putLong(TbsConfigKey.KEY_DOWNLOAD_INTERRUPT_TIME, System.currentTimeMillis());
                edit.commit();
            } catch (Exception e) {
            }
        }
    }

    public void setInstallInterruptCode(int i) {
        synchronized (this) {
            SharedPreferences.Editor edit = this.mPreferences.edit();
            edit.putInt(TbsConfigKey.KEY_INSTALL_INTERRUPT_CODE, i);
            edit.commit();
        }
    }

    public void setTbsCoreLoadRenameFileLockEnable(boolean z) {
        synchronized (this) {
            try {
                SharedPreferences.Editor edit = this.mPreferences.edit();
                edit.putBoolean(TbsConfigKey.KEY_TBS_CORE_LOAD_RENAME_FILE_LOCK_ENABLE, z);
                edit.commit();
            } catch (Exception e) {
            }
        }
    }

    public void setTbsCoreLoadRenameFileLockWaitEnable(boolean z) {
        synchronized (this) {
            try {
                SharedPreferences.Editor edit = this.mPreferences.edit();
                edit.putBoolean(TbsConfigKey.KEY_TBS_CORE_LOAD_RENAME_FILE_LOCK_WAIT_ENABLE, z);
                edit.commit();
            } catch (Exception e) {
            }
        }
    }

    public void uploadDownloadInterruptCodeIfNeeded(Context context) {
        int i;
        synchronized (this) {
            if (context != null) {
                try {
                    if ("com.tencent.mm".equals(context.getApplicationContext().getApplicationInfo().packageName)) {
                        boolean z = true;
                        if (this.mPreferences.contains(TbsConfigKey.KEY_DOWNLOAD_INTERRUPT_CODE)) {
                            i = this.mPreferences.getInt(TbsConfigKey.KEY_DOWNLOAD_INTERRUPT_CODE, -99);
                            if ((i > -206 || i < -219) && ((i > -302 || i < -316) && (i > -318 || i < -322))) {
                                z = false;
                            }
                        } else {
                            try {
                                i = !new File(new File(this.b.getFilesDir(), "shared_prefs"), "tbs_download_config").exists() ? -97 : !this.mPreferences.contains(TbsConfigKey.KEY_NEEDDOWNLOAD) ? -96 : -101;
                            } catch (Throwable th) {
                                i = -95;
                            }
                        }
                        if (z) {
                            TbsLogReport.TbsLogInfo tbsLogInfo = TbsLogReport.getInstance(context).tbsLogInfo();
                            tbsLogInfo.setErrorCode(128);
                            tbsLogInfo.setFailDetail(" " + i);
                            TbsLogReport.getInstance(context).eventReport(TbsLogReport.EventType.TYPE_DOWNLOAD, tbsLogInfo);
                        }
                    }
                } catch (Throwable th2) {
                }
            }
        }
    }
}
