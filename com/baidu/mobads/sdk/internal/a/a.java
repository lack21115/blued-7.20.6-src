package com.baidu.mobads.sdk.internal.a;

import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.api.IOAdEvent;

/* loaded from: source-8756600-dex2jar.jar:com/baidu/mobads/sdk/internal/a/a.class */
public interface a extends IOAdEvent {
    IAdInterListener getDelegator();

    Object handleEvent(String str, String str2, Object[] objArr);
}
