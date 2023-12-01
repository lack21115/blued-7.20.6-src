package com.bytedance.sdk.openadsdk;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/sdk/openadsdk/TTAdDislike.class */
public interface TTAdDislike {

    /* loaded from: source-7206380-dex2jar.jar:com/bytedance/sdk/openadsdk/TTAdDislike$DislikeInteractionCallback.class */
    public interface DislikeInteractionCallback {
        void onCancel();

        void onSelected(int i, String str, boolean z);

        void onShow();
    }

    boolean isShow();

    void resetDislikeStatus();

    void setDislikeInteractionCallback(DislikeInteractionCallback dislikeInteractionCallback);

    void setDislikeSource(String str);

    void showDislikeDialog();
}
