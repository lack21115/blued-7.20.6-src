package com.huawei.hms.common;

import android.content.Context;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/common/HuaweiApiInterface.class */
public interface HuaweiApiInterface {
    void setHostContext(Context context);

    void setInnerHms();

    void setSubAppId(String str) throws ApiException;
}
