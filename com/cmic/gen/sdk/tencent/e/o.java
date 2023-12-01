package com.cmic.gen.sdk.tencent.e;

import java.text.SimpleDateFormat;
import java.util.Date;

/* loaded from: source-7206380-dex2jar.jar:com/cmic/gen/sdk/tencent/e/o.class */
public class o {
    public static String a() {
        return new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date(System.currentTimeMillis()));
    }
}
