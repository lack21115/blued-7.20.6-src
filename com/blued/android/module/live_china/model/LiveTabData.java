package com.blued.android.module.live_china.model;

import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/LiveTabData.class */
public final class LiveTabData implements Serializable {
    private List<BluedLiveListData> adapterData;
    private LiveListCommonModel commonModel;
    private List<BluedLiveListData> datas;
    private List<BannerModel> extraDatas;

    public final List<BluedLiveListData> getAdapterData() {
        return this.adapterData;
    }

    public final LiveListCommonModel getCommonModel() {
        return this.commonModel;
    }

    public final List<BluedLiveListData> getDatas() {
        return this.datas;
    }

    public final List<BannerModel> getExtraDatas() {
        return this.extraDatas;
    }

    public final void setAdapterData(List<BluedLiveListData> list) {
        this.adapterData = list;
    }

    public final void setCommonModel(LiveListCommonModel liveListCommonModel) {
        this.commonModel = liveListCommonModel;
    }

    public final void setDatas(List<BluedLiveListData> list) {
        this.datas = list;
    }

    public final void setExtraDatas(List<BannerModel> list) {
        this.extraDatas = list;
    }
}
