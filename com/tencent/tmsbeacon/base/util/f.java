package com.tencent.tmsbeacon.base.util;

import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.huawei.openalliance.ad.constant.t;
import java.nio.charset.Charset;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsbeacon/base/util/f.class */
public class f {
    public static String a(String str) {
        return str.trim().replace(" ", "").replace("\t", "").replace(ContainerUtils.FIELD_DELIMITER, "").replace(":", "").replace("=", "").replace(t.aE, "");
    }

    public static void a(String[] strArr) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= strArr.length) {
                return;
            }
            if (strArr[i2] == null) {
                strArr[i2] = "";
            }
            i = i2 + 1;
        }
    }

    public static boolean b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return Charset.forName("ISO-8859-1").newEncoder().canEncode(str);
        } catch (Exception e) {
            c.a(e);
            return false;
        }
    }
}
