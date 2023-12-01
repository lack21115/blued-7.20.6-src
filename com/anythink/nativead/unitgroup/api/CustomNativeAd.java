package com.anythink.nativead.unitgroup.api;

import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.anythink.core.api.ATAdAppInfo;
import com.anythink.core.api.ATCustomVideo;
import com.anythink.nativead.api.ATNativePrepareInfo;
import com.anythink.nativead.unitgroup.a;
import java.util.List;
import java.util.Map;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/nativead/unitgroup/api/CustomNativeAd.class */
public class CustomNativeAd extends a {
    public static String IS_AUTO_PLAY_KEY = "is_auto_play";
    static final double MAX_STAR_RATING = 5.0d;
    static final double MIN_STAR_RATING = 0.0d;
    private ATAdAppInfo adAppInfo;
    private View adLogoView;
    private String mAdChoiceIconUrl;
    private String mAdFrom;
    private String mAdvertiserName;
    private int mAppCommentNum;
    private View mAppDownloadButton;
    private double mAppPrice;
    private String mCallToAction;
    private String mClickDestinationUrl;
    private View.OnClickListener mCloseViewListener;
    private String mDomain;
    private String mIconImageUrl;
    private List<String> mImageUrlList;
    private int mMainImageHeight;
    private String mMainImageUrl;
    private int mMainImageWidth;
    private int mNativeExpressHeight;
    private int mNativeExpressWidth;
    private Map<String, Object> mNetworkInfoMap;
    private String mText;
    private String mTitle;
    private int mVideoHeight;
    private String mVideoUrl;
    private int mVideoWidth;
    private String mWarning;
    private String showId;
    private double videoDuration;
    private Double mStarRating = Double.valueOf((double) MIN_STAR_RATING);
    private int nInteractionType = 0;

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/nativead/unitgroup/api/CustomNativeAd$NativeAdConst.class */
    public class NativeAdConst {
        public static final String IMAGE_TYPE = "2";
        public static final String UNKNOWN_TYPE = "0";
        public static final String VIDEO_TYPE = "1";

        public NativeAdConst() {
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/nativead/unitgroup/api/CustomNativeAd$NativeType.class */
    public class NativeType {
        public static final int FEED = 1;
        public static final int PATCH = 2;

        public NativeType() {
        }
    }

    @Override // com.anythink.nativead.unitgroup.a
    public final void bindDislikeListener(View.OnClickListener onClickListener) {
        View closeView;
        this.mCloseViewListener = onClickListener;
        ATNativePrepareInfo nativePrepareInfo = getNativePrepareInfo();
        if (nativePrepareInfo == null || (closeView = nativePrepareInfo.getCloseView()) == null) {
            return;
        }
        closeView.setOnClickListener(this.mCloseViewListener);
    }

    public final boolean checkHasCloseViewListener() {
        return this.mCloseViewListener != null;
    }

    @Override // com.anythink.nativead.unitgroup.a
    public void clear(View view) {
    }

    public void destroy() {
        this.mCloseViewListener = null;
    }

    public ATAdAppInfo getAdAppInfo() {
        return this.adAppInfo;
    }

    public final String getAdChoiceIconUrl() {
        return this.mAdChoiceIconUrl;
    }

    public String getAdFrom() {
        return this.mAdFrom;
    }

    @Override // com.anythink.nativead.unitgroup.a
    public View getAdIconView() {
        return null;
    }

    public Bitmap getAdLogo() {
        return null;
    }

    public final View getAdLogoView() {
        return this.adLogoView;
    }

    @Override // com.anythink.nativead.unitgroup.a
    public View getAdMediaView(Object... objArr) {
        return null;
    }

    public String getAdvertiserName() {
        return this.mAdvertiserName;
    }

    public int getAppCommentNum() {
        return this.mAppCommentNum;
    }

    public View getAppDownloadButton() {
        return this.mAppDownloadButton;
    }

    public double getAppPrice() {
        return this.mAppPrice;
    }

    public String getCallToActionText() {
        return this.mCallToAction;
    }

    public ViewGroup getCustomAdContainer() {
        return null;
    }

    public String getDescriptionText() {
        return this.mText;
    }

    public String getDomain() {
        return this.mDomain;
    }

    public String getIconImageUrl() {
        return this.mIconImageUrl;
    }

    public final List<String> getImageUrlList() {
        return this.mImageUrlList;
    }

    public int getMainImageHeight() {
        int i = this.mMainImageHeight;
        if (i > 0) {
            return i;
        }
        return -1;
    }

    public String getMainImageUrl() {
        return this.mMainImageUrl;
    }

    public int getMainImageWidth() {
        int i = this.mMainImageWidth;
        if (i > 0) {
            return i;
        }
        return -1;
    }

    public int getNativeAdInteractionType() {
        return this.nInteractionType;
    }

    public ATCustomVideo getNativeCustomVideo() {
        return null;
    }

    public int getNativeExpressHeight() {
        int i = this.mNativeExpressHeight;
        if (i > 0) {
            return i;
        }
        return -1;
    }

    public int getNativeExpressWidth() {
        int i = this.mNativeExpressWidth;
        if (i > 0) {
            return i;
        }
        return -1;
    }

    public int getNativeType() {
        return 1;
    }

    public final Map<String, Object> getNetworkInfoMap() {
        return this.mNetworkInfoMap;
    }

    public final String getShowId() {
        return this.showId;
    }

    public final Double getStarRating() {
        return this.mStarRating;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public double getVideoDuration() {
        return this.videoDuration;
    }

    public int getVideoHeight() {
        int i = this.mVideoHeight;
        if (i > 0) {
            return i;
        }
        return -1;
    }

    public double getVideoProgress() {
        return MIN_STAR_RATING;
    }

    public final String getVideoUrl() {
        return this.mVideoUrl;
    }

    public int getVideoWidth() {
        int i = this.mVideoWidth;
        if (i > 0) {
            return i;
        }
        return -1;
    }

    public String getWarning() {
        return this.mWarning;
    }

    public void impressionTrack(View view) {
    }

    @Override // com.anythink.nativead.unitgroup.a
    public boolean isNativeExpress() {
        return false;
    }

    @Override // com.anythink.nativead.unitgroup.a
    public void onPause() {
    }

    @Override // com.anythink.nativead.unitgroup.a
    public void onResume() {
    }

    @Override // com.anythink.nativead.unitgroup.a
    public void pauseVideo() {
    }

    @Override // com.anythink.nativead.unitgroup.a
    public void prepare(View view, ATNativePrepareInfo aTNativePrepareInfo) {
    }

    public void registerDownloadConfirmListener() {
    }

    public void registerListener(View view, List<View> list, FrameLayout.LayoutParams layoutParams) {
        ATNativePrepareInfo aTNativePrepareInfo = new ATNativePrepareInfo();
        aTNativePrepareInfo.setClickViewList(list);
        aTNativePrepareInfo.setChoiceViewLayoutParams(layoutParams);
        prepare(view, aTNativePrepareInfo);
    }

    @Override // com.anythink.nativead.unitgroup.a
    public void resumeVideo() {
    }

    public final void setAdAppInfo(ATAdAppInfo aTAdAppInfo) {
        this.adAppInfo = aTAdAppInfo;
    }

    public final void setAdChoiceIconUrl(String str) {
        this.mAdChoiceIconUrl = str;
    }

    public final void setAdFrom(String str) {
        this.mAdFrom = str;
    }

    public final void setAdLogoView(View view) {
        this.adLogoView = view;
    }

    public void setAdvertiserName(String str) {
        this.mAdvertiserName = str;
    }

    public void setAppCommentNum(int i) {
        this.mAppCommentNum = i;
    }

    public void setAppDownloadButton(View view) {
        this.mAppDownloadButton = view;
    }

    public void setAppPrice(double d) {
        this.mAppPrice = d;
    }

    public final void setCallToActionText(String str) {
        this.mCallToAction = str;
    }

    public final void setDescriptionText(String str) {
        this.mText = str;
    }

    public final void setDomain(String str) {
        this.mDomain = str;
    }

    public final void setIconImageUrl(String str) {
        this.mIconImageUrl = str;
    }

    public final void setImageUrlList(List<String> list) {
        this.mImageUrlList = list;
    }

    public void setMainImageHeight(int i) {
        this.mMainImageHeight = i;
    }

    public final void setMainImageUrl(String str) {
        this.mMainImageUrl = str;
    }

    public void setMainImageWidth(int i) {
        this.mMainImageWidth = i;
    }

    public void setNativeExpressHeight(int i) {
        this.mNativeExpressHeight = i;
    }

    public void setNativeExpressWidth(int i) {
        this.mNativeExpressWidth = i;
    }

    public final void setNativeInteractionType(int i) {
        this.nInteractionType = i;
    }

    public final void setNetworkInfoMap(Map<String, Object> map) {
        this.mNetworkInfoMap = map;
    }

    public final void setShowId(String str) {
        this.showId = str;
    }

    public final void setStarRating(Double d) {
        if (d == null) {
            this.mStarRating = null;
        } else if (d.doubleValue() < MIN_STAR_RATING || d.doubleValue() > MAX_STAR_RATING) {
        } else {
            this.mStarRating = d;
        }
    }

    public final void setTitle(String str) {
        this.mTitle = str;
    }

    public final void setVideoDuration(double d) {
        this.videoDuration = d;
    }

    public void setVideoHeight(int i) {
        this.mVideoHeight = i;
    }

    public void setVideoMute(boolean z) {
    }

    public final void setVideoUrl(String str) {
        this.mVideoUrl = str;
    }

    public void setVideoWidth(int i) {
        this.mVideoWidth = i;
    }

    public final void setWarning(String str) {
        this.mWarning = str;
    }

    public void unregeisterDownloadConfirmListener() {
    }
}
