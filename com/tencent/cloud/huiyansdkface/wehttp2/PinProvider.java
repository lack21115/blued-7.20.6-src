package com.tencent.cloud.huiyansdkface.wehttp2;

import java.util.List;
import java.util.Set;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/wehttp2/PinProvider.class */
public interface PinProvider {
    Set<String> getPinSet(String str);

    void onPinVerifyFailed(String str, List<String> list);
}
