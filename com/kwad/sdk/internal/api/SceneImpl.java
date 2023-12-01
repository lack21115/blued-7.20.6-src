package com.kwad.sdk.internal.api;

import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.model.IKsAdLabel;
import com.kwad.sdk.api.model.NativeAdExtraData;
import com.kwad.sdk.api.model.SplashAdExtraData;
import com.kwad.sdk.core.scene.URLPackage;
import com.kwad.sdk.utils.be;
import com.kwad.sdk.utils.t;
import com.kwad.sdk.utils.u;
import java.io.Serializable;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/internal/api/SceneImpl.class */
public class SceneImpl extends com.kwad.sdk.core.response.kwai.a implements KsScene, Serializable, Cloneable {
    private static final long serialVersionUID = 93865491903408451L;
    public int action;
    public int adStyle;
    public String backUrl;
    public String bidResponse;
    public String bidResponseV2;
    public long entryScene;
    public int height;
    public transient a mKsAdLabel;
    public NativeAdExtraDataImpl nativeAdExtraData;
    public long posId;
    public Map<String, String> rewardCallbackExtraData;
    public b splashExtraData;
    public URLPackage urlPackage;
    public int width;
    public int adNum = 1;
    public int screenOrientation = 0;
    public final EcAttribute mEcAttribute = new EcAttribute();

    public SceneImpl() {
    }

    public SceneImpl(long j) {
        this.posId = j;
        this.entryScene = j;
        if (be.getPosId() != 0) {
            this.posId = be.getPosId();
        }
    }

    public static SceneImpl covert(KsScene ksScene) {
        if (ksScene instanceof SceneImpl) {
            return (SceneImpl) ksScene;
        }
        SceneImpl sceneImpl = new SceneImpl();
        sceneImpl.posId = ksScene.getPosId();
        sceneImpl.entryScene = ksScene.getPosId();
        sceneImpl.adNum = ksScene.getAdNum();
        sceneImpl.action = ksScene.getAction();
        sceneImpl.width = ksScene.getWidth();
        sceneImpl.height = ksScene.getHeight();
        sceneImpl.adStyle = ksScene.getAdStyle();
        sceneImpl.screenOrientation = getScreenOrientation(ksScene);
        sceneImpl.backUrl = getBackUrl(ksScene);
        sceneImpl.mEcAttribute.setPromoteId(getPromoteId(ksScene));
        sceneImpl.mEcAttribute.setComment(getComment(ksScene));
        sceneImpl.mEcAttribute.setUserCommRateBuying(getUserCommRateBuying(ksScene));
        sceneImpl.mEcAttribute.setUserCommRateSharing(getUserCommRateSharing(ksScene));
        if (be.getPosId() != 0) {
            sceneImpl.posId = be.getPosId();
        }
        return sceneImpl;
    }

    public static String getBackUrl(KsScene ksScene) {
        if (ksScene == null) {
            return "";
        }
        try {
            return ksScene.getBackUrl();
        } catch (Throwable th) {
            return "";
        }
    }

    private static String getComment(KsScene ksScene) {
        if (ksScene == null) {
            return "";
        }
        try {
            return ksScene.getComment();
        } catch (Throwable th) {
            return "";
        }
    }

    private static String getPromoteId(KsScene ksScene) {
        if (ksScene == null) {
            return "";
        }
        try {
            return ksScene.getPromoteId();
        } catch (Throwable th) {
            return "";
        }
    }

    private static int getScreenOrientation(KsScene ksScene) {
        try {
            return ksScene.getScreenOrientation();
        } catch (Throwable th) {
            return 0;
        }
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public static long getUserCommRateBuying(KsScene ksScene) {
        if (ksScene == null) {
            return 0L;
        }
        try {
            return ksScene.getUserCommRateBuying();
        } catch (Throwable th) {
            return 0L;
        }
    }

    public static long getUserCommRateSharing(KsScene ksScene) {
        if (ksScene == null) {
            return 0L;
        }
        try {
            return ksScene.getUserCommRateSharing();
        } catch (Throwable th) {
            return 0L;
        }
    }

    public static void register() {
        com.kwad.sdk.service.a.b(KsScene.class, SceneImpl.class);
    }

    @Override // com.kwad.sdk.core.response.kwai.a
    public void afterParseJson(JSONObject jSONObject) {
        super.afterParseJson(jSONObject);
        if (jSONObject == null) {
            return;
        }
        this.rewardCallbackExtraData = u.parseJSON2MapString(jSONObject.optString("extraData"));
    }

    @Override // com.kwad.sdk.core.response.kwai.a
    public void afterToJson(JSONObject jSONObject) {
        super.afterToJson(jSONObject);
        u.putValue(jSONObject, "extraData", u.parseMap2JSON(this.rewardCallbackExtraData));
    }

    /* renamed from: clone */
    public SceneImpl m7847clone() {
        String jSONObject = toJson().toString();
        try {
            SceneImpl sceneImpl = new SceneImpl();
            sceneImpl.parseJson(new JSONObject(jSONObject));
            return sceneImpl;
        } catch (JSONException e) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(e);
            return new SceneImpl();
        }
    }

    @Override // com.kwad.sdk.api.KsScene
    public int getAction() {
        return this.action;
    }

    @Override // com.kwad.sdk.api.KsScene
    public int getAdNum() {
        return this.adNum;
    }

    @Override // com.kwad.sdk.api.KsScene
    public int getAdStyle() {
        return this.adStyle;
    }

    @Override // com.kwad.sdk.api.KsScene
    public String getBackUrl() {
        return this.backUrl;
    }

    @Override // com.kwad.sdk.api.KsScene
    public String getBidResponse() {
        return this.bidResponse;
    }

    @Override // com.kwad.sdk.api.KsScene
    public String getBidResponseV2() {
        return this.bidResponseV2;
    }

    @Override // com.kwad.sdk.api.KsScene
    public String getComment() {
        return this.mEcAttribute.getComment();
    }

    @Override // com.kwad.sdk.api.KsScene
    public int getHeight() {
        return this.height;
    }

    public int getPageScene() {
        URLPackage uRLPackage = this.urlPackage;
        if (uRLPackage == null) {
            return 0;
        }
        return uRLPackage.page;
    }

    @Override // com.kwad.sdk.api.KsScene
    public long getPosId() {
        return this.posId;
    }

    @Override // com.kwad.sdk.api.KsScene
    public String getPromoteId() {
        return this.mEcAttribute.getPromoteId();
    }

    @Override // com.kwad.sdk.api.KsScene
    public Map<String, String> getRewardCallbackExtraData() {
        return this.rewardCallbackExtraData;
    }

    @Override // com.kwad.sdk.api.KsScene
    public int getScreenOrientation() {
        return this.screenOrientation;
    }

    public URLPackage getUrlPackage() {
        return this.urlPackage;
    }

    @Override // com.kwad.sdk.api.KsScene
    public long getUserCommRateBuying() {
        return this.mEcAttribute.getUserCommRateBuying();
    }

    @Override // com.kwad.sdk.api.KsScene
    public long getUserCommRateSharing() {
        return this.mEcAttribute.getUserCommRateSharing();
    }

    @Override // com.kwad.sdk.api.KsScene
    public int getWidth() {
        return this.width;
    }

    public void needShowMiniWindow(boolean z) {
    }

    @Override // com.kwad.sdk.api.KsScene
    public void setAction(int i) {
        this.action = i;
    }

    @Override // com.kwad.sdk.api.KsScene
    public void setAdNum(int i) {
        this.adNum = i;
    }

    @Override // com.kwad.sdk.api.KsScene
    public void setAdStyle(int i) {
        this.adStyle = i;
    }

    @Override // com.kwad.sdk.api.KsScene
    public void setBackUrl(String str) {
        this.backUrl = str;
    }

    @Override // com.kwad.sdk.api.KsScene
    public void setBidResponse(String str) {
        this.bidResponse = str;
    }

    @Override // com.kwad.sdk.api.KsScene
    public void setBidResponseV2(String str) {
        this.bidResponseV2 = str;
    }

    @Override // com.kwad.sdk.api.KsScene
    public void setComment(String str) {
        this.mEcAttribute.setComment(str);
    }

    @Override // com.kwad.sdk.api.KsScene
    public void setHeight(int i) {
        this.height = i;
    }

    @Override // com.kwad.sdk.api.KsScene
    public void setKsAdLabel(IKsAdLabel iKsAdLabel) {
        if (iKsAdLabel == null) {
            return;
        }
        a aVar = new a();
        this.mKsAdLabel = aVar;
        aVar.aaM = iKsAdLabel.getThirdAge();
        this.mKsAdLabel.aaN = iKsAdLabel.getThirdGender();
        this.mKsAdLabel.aaO = iKsAdLabel.getThirdInterest();
        this.mKsAdLabel.aaP = iKsAdLabel.getPrevTitle();
        this.mKsAdLabel.aaQ = iKsAdLabel.getPostTitle();
        this.mKsAdLabel.aaR = iKsAdLabel.getHistoryTitle();
        this.mKsAdLabel.aaS = iKsAdLabel.getChannel();
        this.mKsAdLabel.aaT = iKsAdLabel.getCpmBidFloor();
    }

    @Override // com.kwad.sdk.api.KsScene
    public void setNativeAdExtraData(NativeAdExtraData nativeAdExtraData) {
        if (nativeAdExtraData == null) {
            return;
        }
        NativeAdExtraDataImpl nativeAdExtraDataImpl = new NativeAdExtraDataImpl();
        this.nativeAdExtraData = nativeAdExtraDataImpl;
        try {
            nativeAdExtraDataImpl.enableShake = nativeAdExtraData.isEnableShake();
            this.nativeAdExtraData.showLiveStyle = nativeAdExtraData.getShowLiveStyle();
            this.nativeAdExtraData.showLiveStatus = nativeAdExtraData.getShowLiveStatus();
        } catch (Throwable th) {
        }
    }

    @Override // com.kwad.sdk.api.KsScene
    public void setPosId(long j) {
        this.posId = j;
        this.entryScene = j;
    }

    @Override // com.kwad.sdk.api.KsScene
    public void setPromoteId(String str) {
        this.mEcAttribute.setPromoteId(str);
    }

    @Override // com.kwad.sdk.api.KsScene
    public void setRewardCallbackExtraData(Map<String, String> map) {
        this.rewardCallbackExtraData = map;
    }

    @Override // com.kwad.sdk.api.KsScene
    public void setScreenOrientation(int i) {
        this.screenOrientation = i;
    }

    @Override // com.kwad.sdk.api.KsScene
    public void setSplashExtraData(SplashAdExtraData splashAdExtraData) {
        if (splashAdExtraData == null) {
            return;
        }
        b bVar = new b();
        this.splashExtraData = bVar;
        bVar.disableShake = splashAdExtraData.getDisableShakeStatus();
        this.splashExtraData.disableSlide = splashAdExtraData.getDisableSlideStatus();
        this.splashExtraData.disableRotate = splashAdExtraData.getDisableRotateStatus();
    }

    public void setUrlPackage(URLPackage uRLPackage) {
        this.urlPackage = uRLPackage;
    }

    @Override // com.kwad.sdk.api.KsScene
    public void setUserCommRateBuying(int i) {
        this.mEcAttribute.setUserCommRateBuying(i);
    }

    @Override // com.kwad.sdk.api.KsScene
    public void setUserCommRateSharing(int i) {
        this.mEcAttribute.setUserCommRateSharing(i);
    }

    @Override // com.kwad.sdk.api.KsScene
    public void setWidth(int i) {
        this.width = i;
    }

    @Override // com.kwad.sdk.core.response.kwai.a, com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        u.putValue(jSONObject, "posId", this.posId);
        u.putValue(jSONObject, "entryScene", this.entryScene);
        u.putValue(jSONObject, "adNum", this.adNum);
        u.putValue(jSONObject, "action", this.action);
        u.putValue(jSONObject, "width", this.width);
        u.putValue(jSONObject, "height", this.height);
        a aVar = this.mKsAdLabel;
        if (aVar != null && aVar.aaT != 0) {
            t.putValue(jSONObject, "cpmBidFloor", this.mKsAdLabel.aaT);
        }
        u.putValue(jSONObject, "adStyle", this.adStyle);
        URLPackage uRLPackage = this.urlPackage;
        if (uRLPackage != null) {
            u.putValue(jSONObject, "urlPackage", uRLPackage.toJson());
        }
        u.putValue(jSONObject, "promoteId", this.mEcAttribute.getPromoteId());
        u.putValue(jSONObject, "comment", this.mEcAttribute.getComment());
        u.putValue(jSONObject, "backUrl", this.backUrl);
        u.putValue(jSONObject, "userCommRateBuying", this.mEcAttribute.getUserCommRateBuying());
        u.putValue(jSONObject, "userCommRateSharing", this.mEcAttribute.getUserCommRateSharing());
        u.putValue(jSONObject, "screenOrientation", this.screenOrientation);
        return jSONObject;
    }
}
