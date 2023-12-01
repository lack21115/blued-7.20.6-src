package com.tencent.tmsqmsp.sdk.f;

import com.huawei.hms.framework.common.ContainerUtils;
import com.huawei.openalliance.ad.constant.t;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsqmsp/sdk/f/i.class */
public class i {
    public static String a(String str) {
        return str.trim().replace(" ", "").replace("\t", "").replace(ContainerUtils.FIELD_DELIMITER, "").replace(":", "").replace("=", "").replace(t.aE, "");
    }
}
