package com.baidu.mobads.sdk.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.mobads.sdk.internal.a;
import com.baidu.mobads.sdk.internal.ax;
import com.baidu.mobads.sdk.internal.bm;
import com.baidu.mobads.sdk.internal.bq;
import com.baidu.mobads.sdk.internal.co;
import com.baidu.mobads.sdk.internal.da;
import com.baidu.mobads.sdk.internal.dn;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8756600-dex2jar.jar:com/baidu/mobads/sdk/api/SplashAd.class */
public class SplashAd {
    private static final int BOTTOM_VIEW_ID = 4097;
    public static final String KEY_BIDFAIL_ADN = "adn";
    public static final String KEY_BIDFAIL_ECPM = "ecpm";
    public static final String KEY_DISPLAY_DOWNLOADINFO = "displayDownloadInfo";
    public static final String KEY_FETCHAD = "fetchAd";
    public static final String KEY_LOAD_AFTER_CACHE_END = "loadAfterCacheEnd";
    public static final String KEY_POPDIALOG_DOWNLOAD = "use_dialog_frame";
    public static final String KEY_PREFER_FULLSCREEN = "prefer_fullscreen";
    public static final String KEY_SHAKE_LOGO_SIZE = "shake_logo_size";
    public static final String KEY_TIMEOUT = "timeout";
    public static final String KEY_USE_ADAPTIVE_AD = "adaptive_ad";
    private static final int RT_SPLASH_LOAD_AD_TIMEOUT = 4200;
    private String mAdPlaceId;
    private dn mAdProd;
    private String mAppSid;
    private int mBidFloor;
    private Context mContext;
    private Boolean mDisplayClickRegion;
    private boolean mDisplayDownInfo;
    private SplashAdDownloadDialogListener mDownloadDialogListener;
    private boolean mFetchAd;
    private boolean mFetchNotShow;
    private boolean mIsAdaptiveSplashAd;
    private Boolean mLimitRegionClick;
    private SplashAdListener mListener;
    private RequestParameters mParameter;
    private Boolean mPopDialogIfDL;
    private int mShakeLogoSize;
    private int mTimeout;
    private int mTipStyle;
    private ViewGroup mViewParent;

    /* loaded from: source-8756600-dex2jar.jar:com/baidu/mobads/sdk/api/SplashAd$OnFinishListener.class */
    public interface OnFinishListener {
        void onFinishActivity();
    }

    /* loaded from: source-8756600-dex2jar.jar:com/baidu/mobads/sdk/api/SplashAd$SplashAdDownloadDialogListener.class */
    public interface SplashAdDownloadDialogListener {
        void adDownloadWindowClose();

        void adDownloadWindowShow();

        void onADPermissionClose();

        void onADPermissionShow();

        void onADPrivacyLpClose();

        void onADPrivacyLpShow();
    }

    /* loaded from: source-8756600-dex2jar.jar:com/baidu/mobads/sdk/api/SplashAd$SplashFocusAdListener.class */
    public interface SplashFocusAdListener {
        void onAdClick();

        void onAdClose();

        void onAdIconShow();

        void onLpClosed();
    }

    public SplashAd(Context context, String str, RequestParameters requestParameters, SplashAdListener splashAdListener) {
        this.mTipStyle = 4;
        this.mFetchAd = true;
        this.mFetchNotShow = false;
        this.mDisplayDownInfo = true;
        this.mPopDialogIfDL = false;
        this.mLimitRegionClick = true;
        this.mDisplayClickRegion = true;
        this.mTimeout = RT_SPLASH_LOAD_AD_TIMEOUT;
        this.mShakeLogoSize = 60;
        this.mIsAdaptiveSplashAd = false;
        this.mBidFloor = -1;
        this.mListener = new SplashInteractionListener() { // from class: com.baidu.mobads.sdk.api.SplashAd.1
            @Override // com.baidu.mobads.sdk.api.SplashAdListener
            public void onADLoaded() {
            }

            @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
            public void onAdCacheFailed() {
            }

            @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
            public void onAdCacheSuccess() {
            }

            @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
            public void onAdClick() {
            }

            @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
            public void onAdDismissed() {
            }

            @Override // com.baidu.mobads.sdk.api.SplashAdListener
            public void onAdFailed(String str2) {
            }

            @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
            public void onAdPresent() {
            }

            @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
            public void onLpClosed() {
            }
        };
        this.mContext = context;
        this.mAdPlaceId = str;
        if (splashAdListener != null) {
            this.mListener = splashAdListener;
        }
        if (TextUtils.isEmpty(str)) {
            sendSplashFailedLog("请您输入正确的广告位ID");
            this.mListener.onAdFailed("请您输入正确的广告位ID");
            return;
        }
        this.mParameter = requestParameters;
        if (requestParameters == null || requestParameters.getExtras() == null) {
            return;
        }
        String str2 = this.mParameter.getExtras().get(KEY_FETCHAD);
        if (!TextUtils.isEmpty(str2)) {
            this.mFetchAd = Boolean.parseBoolean(str2);
        }
        String str3 = this.mParameter.getExtras().get(KEY_DISPLAY_DOWNLOADINFO);
        if (!TextUtils.isEmpty(str3)) {
            this.mDisplayDownInfo = Boolean.parseBoolean(str3);
        }
        String str4 = this.mParameter.getExtras().get(KEY_POPDIALOG_DOWNLOAD);
        if (!TextUtils.isEmpty(str4)) {
            this.mPopDialogIfDL = Boolean.valueOf(str4);
        }
        String str5 = this.mParameter.getExtras().get(KEY_SHAKE_LOGO_SIZE);
        if (!TextUtils.isEmpty(str5)) {
            this.mShakeLogoSize = Integer.parseInt(str5);
        }
        String str6 = this.mParameter.getExtras().get("timeout");
        if (!TextUtils.isEmpty(str6)) {
            this.mTimeout = Integer.parseInt(str6);
        }
        String str7 = this.mParameter.getExtras().get(KEY_USE_ADAPTIVE_AD);
        if (TextUtils.isEmpty(str7)) {
            return;
        }
        this.mIsAdaptiveSplashAd = Boolean.parseBoolean(str7);
    }

    public SplashAd(Context context, String str, SplashAdListener splashAdListener) {
        this(context, str, null, splashAdListener);
    }

    private void addZeroPxSurfaceViewAvoidBlink(ViewGroup viewGroup, Context context) {
        try {
            viewGroup.addView(new SurfaceView(context), new RelativeLayout.LayoutParams(0, 0));
        } catch (Exception e) {
            bq.a().a(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callAdFailed(String str) {
        if (this.mListener != null) {
            sendSplashFailedLog(str);
            this.mListener.onAdFailed(str);
        }
    }

    @Deprecated
    public static void registerEnterTransition(Activity activity, int i, int i2, int i3, SplashFocusAdListener splashFocusAdListener) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("right_margin", i);
            jSONObject.put("bottom_margin", i2);
            jSONObject.put("anim_offset_y", i3);
        } catch (JSONException e) {
            bq.a().a(e);
        }
        dn.a(activity, jSONObject, splashFocusAdListener);
    }

    public static void registerEnterTransition(Activity activity, int i, int i2, SplashFocusAdListener splashFocusAdListener) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("right_margin", i);
            jSONObject.put("bottom_margin", i2);
        } catch (JSONException e) {
            bq.a().a(e);
        }
        dn.a(activity, jSONObject, splashFocusAdListener);
    }

    public static void registerEnterTransition(Activity activity, SplashFocusAdListener splashFocusAdListener) {
        dn.a(activity, (JSONObject) null, splashFocusAdListener);
    }

    public static void registerEnterTransition(Activity activity, SplashFocusParams splashFocusParams, SplashFocusAdListener splashFocusAdListener) {
        dn.a(activity, splashFocusParams != null ? splashFocusParams.getFocusParams() : null, splashFocusAdListener);
    }

    private void sendSplashFailedLog(String str) {
        try {
            if (this.mAdProd != null) {
                this.mAdProd.a(str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void sendSplashLog(ViewGroup viewGroup, View view) {
        try {
            HashMap hashMap = new HashMap();
            StringBuilder sb = new StringBuilder();
            sb.append(viewGroup == null);
            sb.append("");
            hashMap.put("adContainer", sb.toString());
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.mIsAdaptiveSplashAd && view == null);
            sb2.append("");
            hashMap.put("isAdaptive", sb2.toString());
            hashMap.put("mFetchNotShow", this.mFetchNotShow + "");
            if (this.mAdProd != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("msg", "sendSplashLog");
                } catch (JSONException e) {
                    bq.a().a(e);
                }
                this.mAdProd.a(jSONObject, hashMap);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void setAppLogo(Object obj) {
        if (this.mAdProd != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("event_type", "splash_logo");
                HashMap hashMap = new HashMap();
                hashMap.put("appLogo", obj);
                this.mAdProd.a(jSONObject, hashMap);
            } catch (Throwable th) {
                bq.a().d(th);
            }
        }
    }

    private final void setAppLogoData(byte[] bArr) {
        setAppLogo(bArr);
    }

    private final void setAppLogoId(int i) {
        setAppLogo(Integer.valueOf(i));
    }

    private final void showWithBottomView(ViewGroup viewGroup, View view) {
        sendSplashLog(viewGroup, view);
        this.mViewParent = viewGroup;
        if (viewGroup == null) {
            if (this.mListener != null) {
                sendSplashFailedLog("传入容器不可以为空");
                this.mListener.onAdFailed("传入容器不可以为空");
            }
        } else if (this.mIsAdaptiveSplashAd && view == null) {
            if (this.mListener != null) {
                sendSplashFailedLog("使用自适应开屏广告能力, 需要使用showWithBottomView方法并传入合适尺寸的底部logo");
                this.mListener.onAdFailed("使用自适应开屏广告能力, 需要使用showWithBottomView方法并传入合适尺寸的底部logo");
            }
        } else {
            dn dnVar = this.mAdProd;
            if (dnVar == null) {
                if (dnVar != null) {
                    dnVar.r();
                }
                callAdFailed("展现失败，请检查splashAd参数是否正确");
                return;
            }
            final co coVar = new co(this.mContext);
            coVar.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            if (view != null) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams.addRule(12);
                view.setId(4097);
                coVar.addView(view, layoutParams);
            }
            coVar.a(new co.a() { // from class: com.baidu.mobads.sdk.api.SplashAd.2
                @Override // com.baidu.mobads.sdk.internal.co.a
                public void onAttachedToWindow() {
                    if (SplashAd.this.mAdProd != null) {
                        SplashAd.this.mAdProd.o();
                    }
                }

                @Override // com.baidu.mobads.sdk.internal.co.a
                public void onDetachedFromWindow() {
                    if (SplashAd.this.mAdProd != null) {
                        SplashAd.this.mAdProd.p();
                    }
                }

                @Override // com.baidu.mobads.sdk.internal.co.a
                public boolean onKeyDown(int i, KeyEvent keyEvent) {
                    return false;
                }

                @Override // com.baidu.mobads.sdk.internal.co.a
                public void onLayoutComplete(int i, int i2) {
                    if (!SplashAd.this.mFetchNotShow) {
                        if (SplashAd.this.mAdProd != null) {
                            SplashAd.this.mAdProd.r();
                        }
                        SplashAd.this.callAdFailed("展现失败，请重新load");
                    } else if (SplashAd.this.mAdProd == null) {
                        SplashAd.this.callAdFailed("展现失败，请检查splashAd参数是否正确");
                    } else {
                        SplashAd.this.mAdProd.f6585a = false;
                        SplashAd.this.mFetchNotShow = false;
                        SplashAd.this.mAdProd.a(coVar);
                        SplashAd.this.mAdProd.f();
                    }
                }

                @Override // com.baidu.mobads.sdk.internal.co.a
                public void onWindowFocusChanged(boolean z) {
                    if (SplashAd.this.mAdProd != null) {
                        SplashAd.this.mAdProd.a(z);
                    }
                }

                @Override // com.baidu.mobads.sdk.internal.co.a
                public void onWindowVisibilityChanged(int i) {
                    if (SplashAd.this.mAdProd != null) {
                        SplashAd.this.mAdProd.b(i);
                    }
                }
            });
            this.mViewParent.addView(coVar);
        }
    }

    public void biddingFail(String str) {
        biddingFail(str, null);
    }

    public void biddingFail(String str, HashMap<String, Object> hashMap) {
        dn dnVar = this.mAdProd;
        if (dnVar != null) {
            dnVar.a(false, str, hashMap);
        }
    }

    public void biddingSuccess(String str) {
        dn dnVar = this.mAdProd;
        if (dnVar != null) {
            dnVar.a(true, str);
        }
    }

    public void destroy() {
        dn dnVar = this.mAdProd;
        if (dnVar != null) {
            dnVar.e();
        }
        this.mListener = null;
    }

    public void finishAndJump(Intent intent) {
        finishAndJump(intent, null);
    }

    public void finishAndJump(Intent intent, OnFinishListener onFinishListener) {
        dn dnVar = this.mAdProd;
        if (dnVar != null) {
            dnVar.a(intent, onFinishListener);
        }
    }

    public String getBiddingToken() {
        dn dnVar = this.mAdProd;
        if (dnVar != null) {
            dnVar.r();
            this.mAdProd = null;
        }
        float e = ax.e(this.mContext);
        Rect a2 = ax.a(this.mContext);
        int width = a2.width();
        int height = a2.height();
        RequestParameters requestParameters = this.mParameter;
        int i = height;
        int i2 = width;
        if (requestParameters != null) {
            i = height;
            i2 = width;
            if (requestParameters.isCustomSize()) {
                if (this.mParameter.getWidth() > 0) {
                    width = (int) (this.mParameter.getWidth() * e);
                }
                i = height;
                i2 = width;
                if (this.mParameter.getHeight() > 0) {
                    i = (int) (this.mParameter.getHeight() * e);
                    i2 = width;
                }
            }
        }
        if (i2 < 200.0f * e || i < e * 150.0f) {
            bq.a().c(da.a().a(bm.SHOW_STANDARD_UNFIT, "开屏显示区域太小,宽度至少200dp,高度至少150dp"));
            SplashAdListener splashAdListener = this.mListener;
            if (splashAdListener == null || !(splashAdListener instanceof SplashInteractionListener)) {
                return null;
            }
            ((SplashInteractionListener) splashAdListener).onAdDismissed();
            return null;
        }
        dn dnVar2 = new dn(this.mContext, this.mAdPlaceId, i2, i, this.mTipStyle, this.mTimeout, this.mDisplayDownInfo, this.mPopDialogIfDL.booleanValue(), this.mDisplayClickRegion.booleanValue(), this.mLimitRegionClick.booleanValue());
        this.mAdProd = dnVar2;
        dnVar2.a(this.mShakeLogoSize);
        this.mAdProd.g(this.mAppSid);
        this.mAdProd.p = this.mBidFloor;
        this.mAdProd.f6585a = true;
        RequestParameters requestParameters2 = this.mParameter;
        if (requestParameters2 != null) {
            this.mAdProd.a(requestParameters2);
        }
        this.mAdProd.a(this.mListener);
        this.mFetchNotShow = true;
        this.mAdProd.a(this.mDownloadDialogListener);
        return this.mAdProd.m();
    }

    public String getECPMLevel() {
        a g;
        dn dnVar = this.mAdProd;
        return (dnVar == null || (g = dnVar.g()) == null) ? "" : g.z();
    }

    public boolean isReady() {
        dn dnVar = this.mAdProd;
        if (dnVar == null || dnVar.k == null) {
            return false;
        }
        return this.mAdProd.k.isAdReady();
    }

    public final void load() {
        dn dnVar = this.mAdProd;
        if (dnVar != null) {
            dnVar.r();
            this.mAdProd = null;
        }
        float e = ax.e(this.mContext);
        Rect a2 = ax.a(this.mContext);
        int width = a2.width();
        int height = a2.height();
        RequestParameters requestParameters = this.mParameter;
        int i = height;
        int i2 = width;
        if (requestParameters != null) {
            i = height;
            i2 = width;
            if (requestParameters.isCustomSize()) {
                if (this.mParameter.getWidth() > 0) {
                    width = (int) (this.mParameter.getWidth() * e);
                }
                i = height;
                i2 = width;
                if (this.mParameter.getHeight() > 0) {
                    i = (int) (this.mParameter.getHeight() * e);
                    i2 = width;
                }
            }
        }
        if (i2 < 200.0f * e || i < e * 150.0f) {
            bq.a().c(da.a().a(bm.SHOW_STANDARD_UNFIT, "开屏显示区域太小,宽度至少200dp,高度至少150dp"));
            SplashAdListener splashAdListener = this.mListener;
            if (splashAdListener == null || !(splashAdListener instanceof SplashInteractionListener)) {
                return;
            }
            ((SplashInteractionListener) splashAdListener).onAdDismissed();
            return;
        }
        dn dnVar2 = new dn(this.mContext, this.mAdPlaceId, i2, i, this.mTipStyle, this.mTimeout, this.mDisplayDownInfo, this.mPopDialogIfDL.booleanValue(), this.mDisplayClickRegion.booleanValue(), this.mLimitRegionClick.booleanValue());
        this.mAdProd = dnVar2;
        dnVar2.a(this.mShakeLogoSize);
        this.mAdProd.g(this.mAppSid);
        this.mAdProd.p = this.mBidFloor;
        this.mAdProd.f6585a = true;
        RequestParameters requestParameters2 = this.mParameter;
        if (requestParameters2 != null) {
            this.mAdProd.a(requestParameters2);
        }
        this.mAdProd.a(this.mListener);
        this.mFetchNotShow = true;
        this.mAdProd.a(this.mDownloadDialogListener);
        this.mAdProd.a();
    }

    public void loadAndShow(ViewGroup viewGroup) {
        if (viewGroup == null) {
            if (this.mListener != null) {
                sendSplashFailedLog("传入容器不可以为空");
                this.mListener.onAdFailed("传入容器不可以为空");
            }
        } else if (this.mIsAdaptiveSplashAd) {
            if (this.mListener != null) {
                sendSplashFailedLog("使用自适应开屏广告能力, 需要使用showWithBottomView方法并传入合适尺寸的底部logo");
                this.mListener.onAdFailed("使用自适应开屏广告能力, 需要使用showWithBottomView方法并传入合适尺寸的底部logo");
            }
        } else {
            addZeroPxSurfaceViewAvoidBlink(viewGroup, this.mContext);
            final co coVar = new co(this.mContext);
            coVar.a(new co.a() { // from class: com.baidu.mobads.sdk.api.SplashAd.3
                @Override // com.baidu.mobads.sdk.internal.co.a
                public void onAttachedToWindow() {
                    if (SplashAd.this.mAdProd != null) {
                        SplashAd.this.mAdProd.o();
                    }
                }

                @Override // com.baidu.mobads.sdk.internal.co.a
                public void onDetachedFromWindow() {
                    if (SplashAd.this.mAdProd != null) {
                        SplashAd.this.mAdProd.p();
                    }
                }

                @Override // com.baidu.mobads.sdk.internal.co.a
                public boolean onKeyDown(int i, KeyEvent keyEvent) {
                    return false;
                }

                @Override // com.baidu.mobads.sdk.internal.co.a
                public void onLayoutComplete(int i, int i2) {
                    if (SplashAd.this.mAdProd != null) {
                        return;
                    }
                    float e = ax.e(SplashAd.this.mContext);
                    int i3 = i;
                    int i4 = i2;
                    if (SplashAd.this.mParameter != null) {
                        i3 = i;
                        i4 = i2;
                        if (SplashAd.this.mParameter.isCustomSize()) {
                            if (SplashAd.this.mParameter.getWidth() > 0) {
                                i = (int) (SplashAd.this.mParameter.getWidth() * e);
                            }
                            i3 = i;
                            i4 = i2;
                            if (SplashAd.this.mParameter.getHeight() > 0) {
                                i4 = (int) (SplashAd.this.mParameter.getHeight() * e);
                                i3 = i;
                            }
                        }
                    }
                    if (i3 < 200.0f * e || i4 < e * 150.0f) {
                        bq.a().c(da.a().a(bm.SHOW_STANDARD_UNFIT, "开屏显示区域太小,宽度至少200dp,高度至少150dp"));
                        if (SplashAd.this.mListener == null || !(SplashAd.this.mListener instanceof SplashInteractionListener)) {
                            return;
                        }
                        ((SplashInteractionListener) SplashAd.this.mListener).onAdDismissed();
                        return;
                    }
                    SplashAd.this.mAdProd = new dn(SplashAd.this.mContext, SplashAd.this.mAdPlaceId, i3, i4, SplashAd.this.mTipStyle, SplashAd.this.mTimeout, SplashAd.this.mDisplayDownInfo, SplashAd.this.mPopDialogIfDL.booleanValue(), SplashAd.this.mDisplayClickRegion.booleanValue(), SplashAd.this.mLimitRegionClick.booleanValue());
                    SplashAd.this.mAdProd.a(coVar);
                    SplashAd.this.mAdProd.a(SplashAd.this.mShakeLogoSize);
                    SplashAd.this.mAdProd.g(SplashAd.this.mAppSid);
                    SplashAd.this.mAdProd.p = SplashAd.this.mBidFloor;
                    SplashAd.this.mAdProd.a(SplashAd.this.mListener);
                    if (SplashAd.this.mParameter != null) {
                        SplashAd.this.mAdProd.a(SplashAd.this.mParameter);
                    }
                    SplashAd.this.mAdProd.f6585a = false;
                    SplashAd.this.mAdProd.a(SplashAd.this.mDownloadDialogListener);
                    SplashAd.this.mAdProd.a();
                }

                @Override // com.baidu.mobads.sdk.internal.co.a
                public void onWindowFocusChanged(boolean z) {
                    if (SplashAd.this.mAdProd != null) {
                        SplashAd.this.mAdProd.a(z);
                    }
                }

                @Override // com.baidu.mobads.sdk.internal.co.a
                public void onWindowVisibilityChanged(int i) {
                    if (SplashAd.this.mAdProd != null) {
                        SplashAd.this.mAdProd.b(i);
                    }
                }
            });
            coVar.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            viewGroup.addView(coVar);
        }
    }

    public void loadBiddingAd(String str) {
        dn dnVar = this.mAdProd;
        if (dnVar != null) {
            dnVar.c(str);
        }
    }

    public void setAppSid(String str) {
        this.mAppSid = str;
    }

    public void setBidFloor(int i) {
        this.mBidFloor = i;
    }

    @Deprecated
    public void setBiddingData(String str) {
        dn dnVar = this.mAdProd;
        if (dnVar != null) {
            dnVar.b(str);
        }
    }

    public void setDownloadDialogListener(SplashAdDownloadDialogListener splashAdDownloadDialogListener) {
        this.mDownloadDialogListener = splashAdDownloadDialogListener;
        dn dnVar = this.mAdProd;
        if (dnVar != null) {
            dnVar.a(splashAdDownloadDialogListener);
        }
    }

    public void setListener(SplashAdListener splashAdListener) {
        this.mListener = splashAdListener;
        dn dnVar = this.mAdProd;
        if (dnVar != null) {
            dnVar.a(splashAdListener);
        }
    }

    public final void show(ViewGroup viewGroup) {
        showWithBottomView(viewGroup, null);
    }
}
