package com.kwad.components.core.response.model;

import android.text.TextUtils;
import com.blued.android.module.common.web.LoaderConstants;
import com.kwad.sdk.core.b;
import com.kwad.sdk.core.kwai.d;
import com.kwad.sdk.core.network.BaseResultData;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.PageInfo;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.bb;
import com.kwad.sdk.utils.t;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/response/model/AdResultData.class */
public class AdResultData extends BaseResultData implements b {
    private static final String TAG = "AdResultData";
    private static final long serialVersionUID = -818939163644825380L;
    private List<AdTemplate> mAdTemplateList;
    protected String mOriginalJson;
    private Map<Long, SceneImpl> mRequestAdSceneMap;
    public PageInfo pageInfo;
    public String pcursor;

    public AdResultData() {
        this.pageInfo = new PageInfo();
        this.mAdTemplateList = new ArrayList();
    }

    public AdResultData(BaseResultData baseResultData, SceneImpl sceneImpl, List<AdTemplate> list) {
        this(sceneImpl);
        super.parseJson(baseResultData.baseToJson());
        if (list != null) {
            getAdTemplateList().addAll(list);
        }
    }

    public AdResultData(SceneImpl sceneImpl) {
        this.pageInfo = new PageInfo();
        this.mAdTemplateList = new ArrayList();
        if (sceneImpl != null) {
            HashMap hashMap = new HashMap(1);
            this.mRequestAdSceneMap = hashMap;
            hashMap.put(Long.valueOf(sceneImpl.getPosId()), sceneImpl);
        }
    }

    public AdResultData(List<SceneImpl> list) {
        this.pageInfo = new PageInfo();
        this.mAdTemplateList = new ArrayList();
        setRequestAdSceneList(list);
    }

    public static AdResultData createFromResponseJson(String str, SceneImpl sceneImpl) {
        JSONObject jSONObject = new JSONObject(str);
        AdResultData adResultData = new AdResultData(sceneImpl);
        adResultData.parseJson(jSONObject);
        adResultData.mOriginalJson = str;
        return adResultData;
    }

    /* renamed from: clone */
    public AdResultData m7685clone() {
        AdResultData adResultData = new AdResultData();
        try {
            adResultData.parseJson(new JSONObject(toJson().toString()));
            return adResultData;
        } catch (JSONException e) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(e);
            return adResultData;
        }
    }

    public SceneImpl getAdScene(long j) {
        Map<Long, SceneImpl> map = this.mRequestAdSceneMap;
        SceneImpl sceneImpl = map != null ? map.get(Long.valueOf(j)) : null;
        SceneImpl sceneImpl2 = sceneImpl;
        if (sceneImpl == null) {
            sceneImpl2 = new SceneImpl(j);
        }
        return sceneImpl2;
    }

    public List<AdTemplate> getAdTemplateList() {
        return this.mAdTemplateList;
    }

    public SceneImpl getDefaultAdScene() {
        return getAdScene(getPosId());
    }

    public AdTemplate getFirstAdTemplate() {
        List<AdTemplate> adTemplateList = getAdTemplateList();
        if (adTemplateList == null || adTemplateList.size() == 0) {
            return null;
        }
        return adTemplateList.get(0);
    }

    public long getPosId() {
        List<AdTemplate> proceedTemplateList = getProceedTemplateList();
        if (proceedTemplateList.size() == 0) {
            return 0L;
        }
        return proceedTemplateList.get(0).posId;
    }

    public List<AdTemplate> getProceedTemplateList() {
        ArrayList arrayList = new ArrayList();
        List<AdTemplate> adTemplateList = getAdTemplateList();
        if (adTemplateList == null) {
            return arrayList;
        }
        int size = adTemplateList.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return arrayList;
            }
            AdTemplate adTemplate = adTemplateList.get(i2);
            int i3 = i2;
            if (com.kwad.sdk.core.response.a.b.bF(adTemplate)) {
                int i4 = i2 + 1;
                i3 = i2;
                if (i4 < size) {
                    adTemplate.mPlayAgain = adTemplateList.get(i4);
                    adTemplate.mPlayAgain.isPlayAgainData = true;
                    i3 = i4;
                }
            }
            arrayList.add(adTemplate);
            i = i3 + 1;
        }
    }

    public String getResponseJson() {
        String str = this.mOriginalJson;
        if (str != null) {
            return str;
        }
        JSONObject json = super.toJson();
        t.putValue(json, "pcursor", this.pcursor);
        t.a(json, LoaderConstants.PAGE_INFO, this.pageInfo);
        t.putValue(json, "impAdInfo", d.bV(t.C(getAdTemplateList()).toString()));
        return json.toString();
    }

    public boolean isAdResultDataEmpty() {
        String str;
        List<AdTemplate> adTemplateList = getAdTemplateList();
        if (adTemplateList.isEmpty()) {
            str = "adTemplateList is empty";
        } else {
            com.kwad.sdk.core.d.b.d(TAG, "adTemplateList size = " + adTemplateList.size());
            List<AdInfo> list = adTemplateList.get(0).adInfoList;
            if (list.isEmpty()) {
                str = "adInfoList is empty";
            } else if (list.get(0) != null) {
                return false;
            } else {
                str = "adInfo is null";
            }
        }
        com.kwad.sdk.core.d.b.w(TAG, str);
        return true;
    }

    public boolean isBidding() {
        List<AdTemplate> proceedTemplateList = getProceedTemplateList();
        return proceedTemplateList.size() != 0 && com.kwad.sdk.core.response.a.d.cq(proceedTemplateList.get(0)) > 0;
    }

    @Override // com.kwad.sdk.core.network.BaseResultData
    public boolean isDataEmpty() {
        return false;
    }

    @Override // com.kwad.sdk.core.network.BaseResultData, com.kwad.sdk.core.b
    public void parseJson(JSONObject jSONObject) {
        super.parseJson(jSONObject);
        if (jSONObject == null) {
            return;
        }
        try {
            this.pcursor = jSONObject.optString("pcursor");
            try {
                String optString = jSONObject.optString(LoaderConstants.PAGE_INFO);
                if (!bb.isNullString(optString)) {
                    this.pageInfo.parseJson(new JSONObject(d.getResponseData(optString)));
                }
            } catch (Exception e) {
                com.kwad.sdk.core.d.b.d("json bug", e.toString());
                com.kwad.sdk.core.d.b.printStackTrace(e);
            }
            String optString2 = jSONObject.optString("impAdInfo");
            if (TextUtils.isEmpty(optString2)) {
                return;
            }
            String responseData = d.getResponseData(optString2);
            if (bb.isNullString(responseData)) {
                return;
            }
            try {
                JSONArray jSONArray = new JSONArray(responseData);
                if (jSONArray.length() <= 0) {
                    return;
                }
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= jSONArray.length()) {
                        return;
                    }
                    JSONObject optJSONObject = jSONArray.optJSONObject(i2);
                    if (optJSONObject != null) {
                        AdTemplate adTemplate = new AdTemplate();
                        adTemplate.parseJson(optJSONObject);
                        adTemplate.llsid = this.llsid;
                        adTemplate.extra = this.extra;
                        adTemplate.mAdScene = getAdScene(adTemplate.posId);
                        adTemplate.mPageInfo = this.pageInfo;
                        this.mAdTemplateList.add(adTemplate);
                    }
                    i = i2 + 1;
                }
            } catch (JSONException e2) {
                com.kwad.sdk.core.d.b.printStackTraceOnly(e2);
            }
        } catch (Exception e3) {
            com.kwad.sdk.core.d.b.printStackTrace(e3);
            com.kwad.sdk.core.d.b.d("json bug", e3.toString());
        }
    }

    public void setAdTemplateList(List<AdTemplate> list) {
        this.mAdTemplateList = list;
    }

    public void setRequestAdSceneList(List<SceneImpl> list) {
        if (list != null) {
            this.mRequestAdSceneMap = new HashMap(list.size());
            for (SceneImpl sceneImpl : list) {
                this.mRequestAdSceneMap.put(Long.valueOf(sceneImpl.getPosId()), sceneImpl);
            }
        }
    }

    @Override // com.kwad.sdk.core.network.BaseResultData, com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject json = super.toJson();
        t.putValue(json, "pcursor", this.pcursor);
        t.a(json, LoaderConstants.PAGE_INFO, this.pageInfo);
        t.putValue(json, "impAdInfo", getAdTemplateList());
        return json;
    }
}
