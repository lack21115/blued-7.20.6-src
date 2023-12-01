package com.bytedance.sdk.openadsdk.live.core;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/sdk/openadsdk/live/core/ITTLiveConfig.class */
public interface ITTLiveConfig {
    String getAppName();

    String getChannel();

    String getECHostAppId();

    String getGeneralAppId();

    TTHostPermissionInner getHostPermission();

    ITTLiveHostAction getLiveHostAction();

    String getPartner();

    String getPartnerSecret();

    String getVersion();

    int getVersionCode();

    boolean isDebug();

    boolean isValid();
}
