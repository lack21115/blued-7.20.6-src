package com.baidu.mobads.sdk.api;

import android.content.Context;
import android.view.View;
import android.webkit.WebView;
import com.baidu.mobads.sdk.internal.a;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: source-8756600-dex2jar.jar:com/baidu/mobads/sdk/api/NativeResponse.class */
public interface NativeResponse extends AbstractData {
    public static final int ACTION_TYPE_APP_DOWNLOAD = 2;
    public static final int ACTION_TYPE_DEEP_LINK = 3;
    public static final int ACTION_TYPE_LANDING_PAGE = 1;
    public static final int INFO_FLOW_GROUP_PIC = 35;
    public static final int INFO_FLOW_GROUP_PIC_LOGO = 36;
    public static final int INFO_FLOW_LEFT_PIC = 33;
    public static final int INFO_FLOW_PIC_BOTTOM_TITLE = 28;
    public static final int INFO_FLOW_PIC_LOGO = 30;
    public static final int INFO_FLOW_PIC_TOP_TITLE = 29;
    public static final int INFO_FLOW_RIGHT_PIC = 34;
    public static final int INFO_FLOW_VIDEO_TOP_TITLE = 37;

    /* loaded from: source-8756600-dex2jar.jar:com/baidu/mobads/sdk/api/NativeResponse$AdDislikeListener.class */
    public interface AdDislikeListener {
        void onDislikeClick();
    }

    /* loaded from: source-8756600-dex2jar.jar:com/baidu/mobads/sdk/api/NativeResponse$AdDownloadWindowListener.class */
    public interface AdDownloadWindowListener extends AdPrivacyListener {
        void adDownloadWindowClose();

        void adDownloadWindowShow();
    }

    /* loaded from: source-8756600-dex2jar.jar:com/baidu/mobads/sdk/api/NativeResponse$AdInteractionListener.class */
    public interface AdInteractionListener {
        void onADExposed();

        void onADExposureFailed(int i);

        void onADStatusChanged();

        void onAdClick();

        void onAdUnionClick();
    }

    /* loaded from: source-8756600-dex2jar.jar:com/baidu/mobads/sdk/api/NativeResponse$AdPrivacyListener.class */
    public interface AdPrivacyListener {
        void onADPermissionClose();

        void onADPermissionShow();

        void onADPrivacyClick();
    }

    /* loaded from: source-8756600-dex2jar.jar:com/baidu/mobads/sdk/api/NativeResponse$AdShakeViewListener.class */
    public interface AdShakeViewListener {
        void onDismiss();
    }

    /* loaded from: source-8756600-dex2jar.jar:com/baidu/mobads/sdk/api/NativeResponse$CustomizeMediaPlayer.class */
    public interface CustomizeMediaPlayer {
        String getVideoUrl();

        void reportPlayError(int i);

        void reportPlayFrozen(int i);

        void reportPlayerReady();

        void reportVideoMuteChange(int i, boolean z);

        void reportVideoPause(int i, VideoReason videoReason);

        void reportVideoReplay();

        void reportVideoResume(int i);

        void reportVideoShow();

        void reportVideoStart(boolean z);

        void reportVideoStop(int i, VideoReason videoReason);
    }

    /* loaded from: source-8756600-dex2jar.jar:com/baidu/mobads/sdk/api/NativeResponse$MaterialType.class */
    public enum MaterialType {
        NORMAL("normal"),
        VIDEO("video"),
        HTML(a.f);
        
        private final String value;

        MaterialType(String str) {
            this.value = str;
        }

        public static MaterialType parse(String str) {
            MaterialType[] values = values();
            int length = values.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    return null;
                }
                MaterialType materialType = values[i2];
                if (materialType.value.equalsIgnoreCase(str)) {
                    return materialType;
                }
                i = i2 + 1;
            }
        }

        public String getValue() {
            return this.value;
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:com/baidu/mobads/sdk/api/NativeResponse$VideoReason.class */
    public enum VideoReason {
        JUMP_LANDING_PAGE(1),
        BACKGROUND(2),
        USER_CLICK(3),
        JUMP_OTHER_APP(4),
        PLAY_COMPLETE(5),
        AD_CLOSE(6),
        OTHER_REASON(7);
        
        int code;

        VideoReason(int i) {
            this.code = i;
        }

        public int getCode() {
            return this.code;
        }
    }

    void biddingFail(String str);

    void biddingFail(String str, HashMap<String, Object> hashMap);

    void biddingSuccess(String str);

    void clearImpressionTaskWhenBack();

    void dislikeClick(DislikeEvent dislikeEvent);

    String getActButtonString();

    int getAdActionType();

    String getAdLogoUrl();

    String getAdMaterialType();

    String getAppPackage();

    String getAppPermissionLink();

    String getAppPrivacyLink();

    long getAppSize();

    String getAppVersion();

    String getBaiduLogoUrl();

    String getBrandName();

    int getContainerHeight();

    int getContainerSizeType();

    int getContainerWidth();

    CustomizeMediaPlayer getCustomizeMediaPlayer();

    String getDesc();

    List<DislikeEvent> getDislikeList();

    int getDownloadStatus();

    int getDuration();

    String getECPMLevel();

    Map<String, String> getExtras();

    String getHtmlSnippet();

    String getIconUrl();

    String getImageUrl();

    int getMainPicHeight();

    int getMainPicWidth();

    String getMarketingPendant();

    MaterialType getMaterialType();

    List<String> getMultiPicUrls();

    String getPublisher();

    int getStyleType();

    String getTitle();

    String getVideoUrl();

    WebView getWebView();

    boolean isAdAvailable(Context context);

    boolean isAutoPlay();

    @Deprecated
    boolean isNeedDownloadApp();

    boolean isNonWifiAutoPlay();

    void pauseAppDownload();

    void permissionClick();

    void privacyClick();

    void recordImpression(View view);

    void registerViewForInteraction(View view, List<View> list, List<View> list2, AdInteractionListener adInteractionListener);

    View renderShakeView(int i, int i2, AdShakeViewListener adShakeViewListener);

    void resumeAppDownload();

    void setAdPrivacyListener(AdPrivacyListener adPrivacyListener);

    void unionLogoClick();
}
