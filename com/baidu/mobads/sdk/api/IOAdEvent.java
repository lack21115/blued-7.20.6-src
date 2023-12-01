package com.baidu.mobads.sdk.api;

import java.util.Map;

/* loaded from: source-8756600-dex2jar.jar:com/baidu/mobads/sdk/api/IOAdEvent.class */
public interface IOAdEvent {
    int getCode();

    Map<String, Object> getData();

    String getMessage();

    Object getTarget();

    String getType();

    void setTarget(Object obj);
}
