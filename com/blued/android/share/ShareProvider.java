package com.blued.android.share;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/share/ShareProvider.class */
public class ShareProvider {
    private static ShareProvider mShareProvider;
    private CallbackListener mCallbackListener;

    public static ShareProvider getInstance() {
        if (mShareProvider == null) {
            mShareProvider = new ShareProvider();
        }
        return mShareProvider;
    }

    public void onCancel(String str) {
        CallbackListener callbackListener = this.mCallbackListener;
        if (callbackListener != null) {
            callbackListener.onCancel(str);
        }
    }

    public void onFailure(String str) {
        CallbackListener callbackListener = this.mCallbackListener;
        if (callbackListener != null) {
            callbackListener.onFailure(str);
        }
    }

    public void onResume(String str) {
        CallbackListener callbackListener = this.mCallbackListener;
        if (callbackListener != null) {
            callbackListener.onResume(str);
        }
    }

    public void onSuccess(String str) {
        CallbackListener callbackListener = this.mCallbackListener;
        if (callbackListener != null) {
            callbackListener.onSuccess(str);
        }
    }

    public void registerCallback(CallbackListener callbackListener) {
        if (this.mCallbackListener != null) {
            this.mCallbackListener = null;
        }
        this.mCallbackListener = callbackListener;
    }

    public void unregisterCallback() {
        this.mCallbackListener = null;
    }
}
