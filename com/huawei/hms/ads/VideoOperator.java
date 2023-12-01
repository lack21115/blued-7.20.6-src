package com.huawei.hms.ads;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/VideoOperator.class */
public interface VideoOperator {

    /* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/VideoOperator$VideoLifecycleListener.class */
    public static abstract class VideoLifecycleListener {
        public void onVideoEnd() {
        }

        public void onVideoMute(boolean z) {
        }

        public void onVideoPause() {
        }

        public void onVideoPlay() {
        }

        public void onVideoStart() {
        }
    }

    float getAspectRatio();

    VideoLifecycleListener getVideoLifecycleListener();

    boolean hasVideo();

    boolean isClickToFullScreenEnabled();

    boolean isCustomizeOperateEnabled();

    boolean isMuted();

    void mute(boolean z);

    void pause();

    void play();

    void setVideoLifecycleListener(VideoLifecycleListener videoLifecycleListener);

    void stop();
}
