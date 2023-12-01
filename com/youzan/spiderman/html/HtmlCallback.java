package com.youzan.spiderman.html;

import java.io.ByteArrayInputStream;
import java.util.List;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/youzan/spiderman/html/HtmlCallback.class */
public interface HtmlCallback {
    void onFailed();

    void onSuccess(String str, Map<String, List<String>> map, ByteArrayInputStream byteArrayInputStream, String str2);
}
