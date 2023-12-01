package com.bytedance.android.live.base.api;

import com.bytedance.android.live.base.IService;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/android/live/base/api/MethodChannelService.class */
public interface MethodChannelService extends IService {
    String identity();

    Object invokeMethod(String str, Object... objArr);
}
