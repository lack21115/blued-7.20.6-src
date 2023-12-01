package com.bytedance.sdk.openadsdk;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/sdk/openadsdk/TTCodeGroupRit.class */
public interface TTCodeGroupRit {

    /* loaded from: source-7206380-dex2jar.jar:com/bytedance/sdk/openadsdk/TTCodeGroupRit$TTCodeGroupRitListener.class */
    public interface TTCodeGroupRitListener {
        void onFail(int i, String str);

        void onSuccess(TTCodeGroupRit tTCodeGroupRit);
    }

    String getRit();

    int getSlotType();
}
