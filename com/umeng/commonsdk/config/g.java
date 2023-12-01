package com.umeng.commonsdk.config;

import com.umeng.commonsdk.debug.UMRTLog;

/* loaded from: source-8829756-dex2jar.jar:com/umeng/commonsdk/config/g.class */
public class g implements e {
    @Override // com.umeng.commonsdk.config.e
    public void a(String str, Object obj, String[] strArr) {
        if (str == null || str.length() <= 0) {
            return;
        }
        try {
            long parseLong = Long.parseLong(str);
            if (parseLong == -1) {
                UMRTLog.e("Config", "--->>> SensitiveFieldHandler: handleConfigItem: invalid config value.");
                return;
            }
            UMRTLog.i("Config", "--->>> CollectFieldJudgment: handleConfigItem: item : " + str);
            if (obj == null || !(obj instanceof b)) {
                return;
            }
            int i = 0;
            while (true) {
                try {
                    int i2 = i;
                    if (i2 >= strArr.length) {
                        return;
                    }
                    String str2 = strArr[i2];
                    if (d.a(str2)) {
                        ((b) obj).a(str2, Boolean.valueOf(a.a(parseLong, i2)));
                    }
                    i = i2 + 1;
                } catch (Throwable th) {
                    return;
                }
            }
        } catch (Throwable th2) {
            UMRTLog.e("Config", "--->>> SensitiveFieldHandler: handleConfigItem: parseLong exception.");
        }
    }
}
