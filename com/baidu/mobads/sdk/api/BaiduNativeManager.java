package com.baidu.mobads.sdk.api;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.api.RequestParameters;
import com.baidu.mobads.sdk.internal.ac;
import com.baidu.mobads.sdk.internal.ak;
import com.baidu.mobads.sdk.internal.dd;
import com.baidu.mobads.sdk.internal.e;
import java.util.List;

/* loaded from: source-8756600-dex2jar.jar:com/baidu/mobads/sdk/api/BaiduNativeManager.class */
public class BaiduNativeManager {
    private static final int FEED_TIMEOUT = 8000;
    private static final String TAG = BaiduNativeManager.class.getSimpleName();
    private boolean isCacheVideo;
    private boolean isCacheVideoOnlyWifi;
    private final String mAdPlacementId;
    private String mAppSid;
    private int mBidFloor;
    private final Context mContext;
    private RequestParameters mRequestParameters;
    private int mTimeoutMillis;

    /* loaded from: source-8756600-dex2jar.jar:com/baidu/mobads/sdk/api/BaiduNativeManager$EntryAdListener.class */
    public interface EntryAdListener {
        void onLpClosed();

        void onNativeFail(int i, String str);

        void onNativeLoad(List<EntryResponse> list);

        void onNoAd(int i, String str);
    }

    /* loaded from: source-8756600-dex2jar.jar:com/baidu/mobads/sdk/api/BaiduNativeManager$ExpressAdListener.class */
    public interface ExpressAdListener {
        void onLpClosed();

        void onNativeFail(int i, String str);

        void onNativeLoad(List<ExpressResponse> list);

        void onNoAd(int i, String str);

        void onVideoDownloadFailed();

        void onVideoDownloadSuccess();
    }

    /* loaded from: source-8756600-dex2jar.jar:com/baidu/mobads/sdk/api/BaiduNativeManager$FeedAdListener.class */
    public interface FeedAdListener {
        void onLpClosed();

        void onNativeFail(int i, String str);

        void onNativeLoad(List<NativeResponse> list);

        void onNoAd(int i, String str);

        void onVideoDownloadFailed();

        void onVideoDownloadSuccess();
    }

    /* loaded from: source-8756600-dex2jar.jar:com/baidu/mobads/sdk/api/BaiduNativeManager$PortraitVideoAdListener.class */
    public interface PortraitVideoAdListener extends FeedAdListener {
        void onAdClick();
    }

    public BaiduNativeManager(Context context, String str) {
        this(context, str, 8000);
    }

    public BaiduNativeManager(Context context, String str, int i) {
        this(context, str, true, i);
    }

    public BaiduNativeManager(Context context, String str, boolean z) {
        this(context, str, z, 8000);
    }

    public BaiduNativeManager(Context context, String str, boolean z, int i) {
        this.isCacheVideo = true;
        this.mTimeoutMillis = 8000;
        this.isCacheVideoOnlyWifi = false;
        this.mBidFloor = -1;
        this.mContext = context;
        this.mAdPlacementId = str;
        this.isCacheVideo = z;
        this.mTimeoutMillis = i;
    }

    private String getAdPlacemenId(RequestParameters requestParameters) {
        if (requestParameters != null) {
            String adPlacementId = requestParameters.getAdPlacementId();
            if (!TextUtils.isEmpty(adPlacementId)) {
                return adPlacementId;
            }
        }
        return this.mAdPlacementId;
    }

    private int getBidFloor(RequestParameters requestParameters) {
        int bidFloor;
        return (requestParameters == null || (bidFloor = requestParameters.getBidFloor()) <= 0) ? this.mBidFloor : bidFloor;
    }

    private void loadBiddingAd(RequestParameters requestParameters, String str, String str2, FeedAdListener feedAdListener, ExpressAdListener expressAdListener) {
        dd ddVar = new dd(this.mContext, getAdPlacemenId(requestParameters), str, this.isCacheVideo, this.mTimeoutMillis);
        if (!TextUtils.isEmpty(this.mAppSid)) {
            ddVar.g(this.mAppSid);
        }
        ddVar.p = getBidFloor(requestParameters);
        ddVar.c(this.isCacheVideoOnlyWifi);
        if (feedAdListener != null) {
            ddVar.a(new ac(feedAdListener));
        } else if (expressAdListener != null) {
            ddVar.a(expressAdListener);
            ddVar.a(1);
        }
        ddVar.a(new ak());
        RequestParameters requestParameters2 = requestParameters;
        if (requestParameters == null) {
            requestParameters2 = new RequestParameters.Builder().build();
        }
        ddVar.a(requestParameters2);
        ddVar.m();
        ddVar.c(str2);
    }

    public String getExpressFeedBiddingToken(RequestParameters requestParameters) {
        dd ddVar = new dd(this.mContext, getAdPlacemenId(requestParameters), IAdInterListener.AdProdType.PRODUCT_FEEDS, this.isCacheVideo, this.mTimeoutMillis);
        ddVar.a(1);
        RequestParameters build = requestParameters == null ? new RequestParameters.Builder().build() : requestParameters;
        if (!TextUtils.isEmpty(this.mAppSid)) {
            ddVar.g(this.mAppSid);
        }
        ddVar.p = getBidFloor(requestParameters);
        ddVar.a(build);
        this.mRequestParameters = build;
        return ddVar.m();
    }

    public String getFeedBiddingToken(RequestParameters requestParameters) {
        dd ddVar = new dd(this.mContext, getAdPlacemenId(requestParameters), IAdInterListener.AdProdType.PRODUCT_FEEDS, this.isCacheVideo, this.mTimeoutMillis);
        RequestParameters build = requestParameters == null ? new RequestParameters.Builder().build() : requestParameters;
        if (!TextUtils.isEmpty(this.mAppSid)) {
            ddVar.g(this.mAppSid);
        }
        ddVar.p = getBidFloor(requestParameters);
        ddVar.a(build);
        this.mRequestParameters = build;
        return ddVar.m();
    }

    public String getPortraitVideoBiddingToken(RequestParameters requestParameters) {
        dd ddVar = new dd(this.mContext, getAdPlacemenId(requestParameters), IAdInterListener.AdProdType.PRODUCT_PORTRAITVIDEO, this.isCacheVideo, this.mTimeoutMillis);
        RequestParameters build = requestParameters == null ? new RequestParameters.Builder().build() : requestParameters;
        if (!TextUtils.isEmpty(this.mAppSid)) {
            ddVar.g(this.mAppSid);
        }
        ddVar.p = getBidFloor(requestParameters);
        ddVar.a(build);
        this.mRequestParameters = build;
        return ddVar.m();
    }

    public void loadBidAdForExpress(String str, ExpressAdListener expressAdListener) {
        loadBiddingAd(this.mRequestParameters, IAdInterListener.AdProdType.PRODUCT_FEEDS, str, null, expressAdListener);
    }

    public void loadBidAdForFeed(String str, FeedAdListener feedAdListener) {
        loadBiddingAd(this.mRequestParameters, IAdInterListener.AdProdType.PRODUCT_FEEDS, str, feedAdListener, null);
    }

    public void loadBidAdForPortraitVideo(String str, FeedAdListener feedAdListener) {
        loadBiddingAd(this.mRequestParameters, IAdInterListener.AdProdType.PRODUCT_PORTRAITVIDEO, str, feedAdListener, null);
    }

    public void loadBidAdForPortraitVideo(String str, PortraitVideoAdListener portraitVideoAdListener) {
        loadBiddingAd(this.mRequestParameters, IAdInterListener.AdProdType.PRODUCT_PORTRAITVIDEO, str, portraitVideoAdListener, null);
    }

    public void loadContentAd(RequestParameters requestParameters, FeedAdListener feedAdListener) {
        e eVar = new e(this.mContext, new ac(feedAdListener), new dd(this.mContext, getAdPlacemenId(requestParameters), "content", this.isCacheVideo, this.mTimeoutMillis));
        if (!TextUtils.isEmpty(this.mAppSid)) {
            eVar.b(this.mAppSid);
        }
        eVar.a(getBidFloor(requestParameters));
        eVar.a(this.isCacheVideoOnlyWifi);
        eVar.a(new ak());
        eVar.b(requestParameters);
    }

    public void loadExpressAd(RequestParameters requestParameters, ExpressAdListener expressAdListener) {
        e eVar = new e(this.mContext, getAdPlacemenId(requestParameters), expressAdListener, this.isCacheVideo, this.mTimeoutMillis);
        if (!TextUtils.isEmpty(this.mAppSid)) {
            eVar.b(this.mAppSid);
        }
        eVar.a(getBidFloor(requestParameters));
        eVar.a(this.isCacheVideoOnlyWifi);
        eVar.a(new ak());
        eVar.b(requestParameters);
    }

    public void loadFeedAd(RequestParameters requestParameters, FeedAdListener feedAdListener) {
        e eVar = new e(this.mContext, getAdPlacemenId(requestParameters), new ac(feedAdListener), this.isCacheVideo, this.mTimeoutMillis);
        if (!TextUtils.isEmpty(this.mAppSid)) {
            eVar.b(this.mAppSid);
        }
        eVar.a(getBidFloor(requestParameters));
        eVar.a(this.isCacheVideoOnlyWifi);
        eVar.a(new ak());
        eVar.b(requestParameters);
    }

    public void loadFeedEntryAd(RequestParameters requestParameters, EntryAdListener entryAdListener) {
        e eVar = new e(this.mContext, getAdPlacemenId(requestParameters), entryAdListener, this.isCacheVideo, this.mTimeoutMillis);
        if (!TextUtils.isEmpty(this.mAppSid)) {
            eVar.b(this.mAppSid);
        }
        eVar.b(requestParameters);
    }

    public void loadInsiteAd(RequestParameters requestParameters, FeedAdListener feedAdListener) {
        e eVar = new e(this.mContext, new ac(feedAdListener), new dd(this.mContext, getAdPlacemenId(requestParameters), IAdInterListener.AdProdType.PRODUCT_INSITE, this.isCacheVideo, this.mTimeoutMillis));
        if (!TextUtils.isEmpty(this.mAppSid)) {
            eVar.b(this.mAppSid);
        }
        eVar.a(getBidFloor(requestParameters));
        eVar.a(this.isCacheVideoOnlyWifi);
        eVar.a(new ak());
        eVar.b(requestParameters);
    }

    public void loadPortraitVideoAd(RequestParameters requestParameters, FeedAdListener feedAdListener) {
        e eVar = new e(this.mContext, new ac(feedAdListener), new dd(this.mContext, getAdPlacemenId(requestParameters), IAdInterListener.AdProdType.PRODUCT_PORTRAITVIDEO, this.isCacheVideo, this.mTimeoutMillis));
        if (!TextUtils.isEmpty(this.mAppSid)) {
            eVar.b(this.mAppSid);
        }
        eVar.a(getBidFloor(requestParameters));
        eVar.a(this.isCacheVideoOnlyWifi);
        eVar.a(new ak());
        eVar.b(requestParameters);
    }

    public void loadPortraitVideoAd(RequestParameters requestParameters, PortraitVideoAdListener portraitVideoAdListener) {
        loadPortraitVideoAd(requestParameters, (FeedAdListener) portraitVideoAdListener);
    }

    public void loadPrerollVideo(RequestParameters requestParameters, FeedAdListener feedAdListener) {
        e eVar = new e(this.mContext, getAdPlacemenId(requestParameters), new ac(feedAdListener), this.isCacheVideo, 8000, IAdInterListener.AdProdType.PRODUCT_PREROLL);
        if (!TextUtils.isEmpty(this.mAppSid)) {
            eVar.b(this.mAppSid);
        }
        eVar.a(getBidFloor(requestParameters));
        eVar.b(requestParameters);
    }

    public void setAppSid(String str) {
        this.mAppSid = str;
    }

    public void setBidFloor(int i) {
        this.mBidFloor = i;
    }

    public void setCacheVideoOnlyWifi(boolean z) {
        this.isCacheVideoOnlyWifi = z;
    }

    @Deprecated
    public void setExpressFeedBiddingData(RequestParameters requestParameters, String str, ExpressAdListener expressAdListener) {
        e eVar = new e(this.mContext, getAdPlacemenId(requestParameters), expressAdListener, this.isCacheVideo, this.mTimeoutMillis);
        if (!TextUtils.isEmpty(this.mAppSid)) {
            eVar.b(this.mAppSid);
        }
        eVar.a(getBidFloor(requestParameters));
        eVar.a(this.isCacheVideoOnlyWifi);
        eVar.a(new ak());
        eVar.a(requestParameters);
        eVar.a(str);
    }

    @Deprecated
    public void setFeedBiddingData(RequestParameters requestParameters, String str, FeedAdListener feedAdListener) {
        e eVar = new e(this.mContext, getAdPlacemenId(requestParameters), new ac(feedAdListener), this.isCacheVideo, this.mTimeoutMillis);
        if (!TextUtils.isEmpty(this.mAppSid)) {
            eVar.b(this.mAppSid);
        }
        eVar.a(getBidFloor(requestParameters));
        eVar.a(this.isCacheVideoOnlyWifi);
        eVar.a(new ak());
        eVar.a(requestParameters);
        eVar.a(str);
    }

    @Deprecated
    public void setPortraitVideoBiddingData(RequestParameters requestParameters, String str, PortraitVideoAdListener portraitVideoAdListener) {
        e eVar = new e(this.mContext, new ac(portraitVideoAdListener), new dd(this.mContext, getAdPlacemenId(requestParameters), IAdInterListener.AdProdType.PRODUCT_PORTRAITVIDEO, this.isCacheVideo, this.mTimeoutMillis));
        if (!TextUtils.isEmpty(this.mAppSid)) {
            eVar.b(this.mAppSid);
        }
        eVar.a(getBidFloor(requestParameters));
        eVar.a(this.isCacheVideoOnlyWifi);
        eVar.a(new ak());
        eVar.a(requestParameters);
        eVar.a(str);
    }
}
