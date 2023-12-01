package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/smtt/sdk/TbsPVConfig.class */
public class TbsPVConfig extends TbsBaseConfig {
    private static TbsPVConfig b;
    public SharedPreferences mPreferences;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/smtt/sdk/TbsPVConfig$TbsPVConfigKey.class */
    public interface TbsPVConfigKey {
        public static final String KEY_DISABLED_CORE_VERSION = "disabled_core_version";
        public static final String KEY_EMERGENT_CORE_VERSION = "emergent_core_version";
        public static final String KEY_ENABLE_NO_SHARE_GRAY = "enable_no_share_gray";
        public static final String KEY_GET_LOCALCOREVERSION_MORETIMES = "get_localcoreversion_moretimes";
        public static final String KEY_IS_DISABLE_HOST_BACKUP_CORE = "disable_host_backup";
        public static final String KEY_READ_APK = "read_apk";
        public static final String KEY_TBS_CORE_SANDBOX_MODE_ENABLE = "tbs_core_sandbox_mode_enable";
    }

    private TbsPVConfig() {
    }

    public static TbsPVConfig getInstance(Context context) {
        TbsPVConfig tbsPVConfig;
        synchronized (TbsPVConfig.class) {
            try {
                if (b == null) {
                    TbsPVConfig tbsPVConfig2 = new TbsPVConfig();
                    b = tbsPVConfig2;
                    tbsPVConfig2.init(context);
                }
                tbsPVConfig = b;
            } catch (Throwable th) {
                throw th;
            }
        }
        return tbsPVConfig;
    }

    public static void releaseInstance() {
        synchronized (TbsPVConfig.class) {
            try {
                b = null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.tencent.smtt.sdk.TbsBaseConfig
    public String getConfigFileName() {
        return "tbs_pv_config";
    }

    public int getDisabledCoreVersion() {
        int i;
        synchronized (this) {
            try {
                String str = this.f38756a.get(TbsPVConfigKey.KEY_DISABLED_CORE_VERSION);
                i = 0;
                if (!TextUtils.isEmpty(str)) {
                    i = Integer.parseInt(str);
                }
            } catch (Exception e) {
                e.printStackTrace();
                i = 0;
            }
        }
        return i;
    }

    public int getEmergentCoreVersion() {
        int i;
        synchronized (this) {
            try {
                String str = this.f38756a.get(TbsPVConfigKey.KEY_EMERGENT_CORE_VERSION);
                i = 0;
                if (!TextUtils.isEmpty(str)) {
                    i = Integer.parseInt(str);
                }
            } catch (Exception e) {
                e.printStackTrace();
                i = 0;
            }
        }
        return i;
    }

    public int getLocalCoreVersionMoreTimes() {
        int i;
        synchronized (this) {
            try {
                String str = this.f38756a.get(TbsPVConfigKey.KEY_GET_LOCALCOREVERSION_MORETIMES);
                i = 0;
                if (!TextUtils.isEmpty(str)) {
                    i = Integer.parseInt(str);
                }
            } catch (Exception e) {
                e.printStackTrace();
                i = 0;
            }
        }
        return i;
    }

    public int getReadApk() {
        int i;
        synchronized (this) {
            try {
                String str = this.f38756a.get(TbsPVConfigKey.KEY_READ_APK);
                i = 0;
                if (!TextUtils.isEmpty(str)) {
                    i = Integer.parseInt(str);
                }
            } catch (Exception e) {
                e.printStackTrace();
                i = 0;
            }
        }
        return i;
    }

    public String getSyncMapValue(String str) {
        String str2;
        synchronized (this) {
            str2 = this.f38756a.get(str);
        }
        return str2;
    }

    public boolean getTbsCoreSandboxModeEnable() {
        synchronized (this) {
            try {
                if ("true".equals(this.f38756a.get(TbsPVConfigKey.KEY_TBS_CORE_SANDBOX_MODE_ENABLE))) {
                    return true;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return false;
        }
    }

    public boolean isDisableHostBackupCore() {
        synchronized (this) {
            try {
                String str = this.f38756a.get(TbsPVConfigKey.KEY_IS_DISABLE_HOST_BACKUP_CORE);
                if (!TextUtils.isEmpty(str)) {
                    if (str.equals("true")) {
                        return true;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return false;
        }
    }

    public boolean isEnableNoCoreGray() {
        synchronized (this) {
            try {
                String str = this.f38756a.get(TbsPVConfigKey.KEY_ENABLE_NO_SHARE_GRAY);
                if (!TextUtils.isEmpty(str)) {
                    if (str.equals("true")) {
                        return true;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return false;
        }
    }

    public void putData(String str, String str2) {
        synchronized (this) {
            this.f38756a.put(str, str2);
        }
    }
}
