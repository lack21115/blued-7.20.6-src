package com.tencent.tmsqmsp.sdk.f;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsqmsp/sdk/f/i.class */
public class i {
    public static String a(String str) {
        return str.trim().replace(" ", "").replace("\t", "").replace("&", "").replace(":", "").replace("=", "").replace(";", "");
    }
}
