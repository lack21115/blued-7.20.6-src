package com.sensetime.stmobile;

/* loaded from: source-8303388-dex2jar.jar:com/sensetime/stmobile/STStickerEvent.class */
public class STStickerEvent {
    private static String TAG = "STStickerEvent";
    private static STStickerEvent mInstance;
    private StickerEventListener mStickerEventDefaultListener;

    /* loaded from: source-8303388-dex2jar.jar:com/sensetime/stmobile/STStickerEvent$StickerEventListener.class */
    public interface StickerEventListener {
        void onAnimationEvent(String str, int i, int i2, int i3, int i4, long j);

        void onKeyFrameEvent(String str, int i);

        void onPackageEvent(String str, int i, int i2, int i3);
    }

    public static STStickerEvent createInstance() {
        if (mInstance == null) {
            mInstance = new STStickerEvent();
        }
        return mInstance;
    }

    public static STStickerEvent getInstance() {
        return mInstance;
    }

    private void onAnimationEvent(String str, int i, int i2, int i3, int i4, long j) {
        StickerEventListener stickerEventListener = this.mStickerEventDefaultListener;
        if (stickerEventListener != null) {
            stickerEventListener.onAnimationEvent(str, i, i2, i3, i4, j);
        }
    }

    private void onKeyFrameEvent(String str, int i) {
        StickerEventListener stickerEventListener = this.mStickerEventDefaultListener;
        if (stickerEventListener != null) {
            stickerEventListener.onKeyFrameEvent(str, i);
        }
    }

    private void onPackageEvent(String str, int i, int i2, int i3) {
        StickerEventListener stickerEventListener = this.mStickerEventDefaultListener;
        if (stickerEventListener != null) {
            stickerEventListener.onPackageEvent(str, i, i2, i3);
        }
    }

    public void setStickerEventListener(StickerEventListener stickerEventListener) {
        if (stickerEventListener != null) {
            this.mStickerEventDefaultListener = stickerEventListener;
        }
    }
}
