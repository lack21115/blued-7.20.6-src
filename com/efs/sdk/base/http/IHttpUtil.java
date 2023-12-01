package com.efs.sdk.base.http;

import java.io.File;
import java.util.Map;

/* loaded from: source-7206380-dex2jar.jar:com/efs/sdk/base/http/IHttpUtil.class */
public interface IHttpUtil {
    HttpResponse get(String str, Map<String, String> map);

    HttpResponse post(String str, Map<String, String> map, File file);

    HttpResponse post(String str, Map<String, String> map, byte[] bArr);

    HttpResponse postAsFile(String str, Map<String, String> map, byte[] bArr);
}
