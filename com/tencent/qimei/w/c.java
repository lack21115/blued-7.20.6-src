package com.tencent.qimei.w;

import com.huawei.hms.push.AttributionReporter;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.tendinsv.a.b;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qimei/w/c.class */
public enum c {
    KEY_CIPHER_KEY("key"),
    KEY_PLATFORM_ID(ConstantsAPI.Token.WX_TOKEN_PLATFORMID_KEY),
    KEY_OS_VERSION(b.a.l),
    KEY_APP_VERSION(AttributionReporter.APP_VERSION),
    KEY_SDK_VERSION("sdkVersion"),
    KEY_AUDIT_VERSION("auditVersion"),
    KEY_APP_KEY("appKey"),
    KEY_CONFIG_VERSION("configVersion"),
    KEY_PACKAGE_NAME("packageName");
    
    public String k;

    c(String str) {
        this.k = str;
    }
}
