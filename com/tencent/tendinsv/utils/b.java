package com.tencent.tendinsv.utils;

import com.xiaomi.mipush.sdk.Constants;
import java.util.UUID;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tendinsv/utils/b.class */
public class b {
    public static String a() {
        return UUID.randomUUID().toString().replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, "");
    }
}
