package com.blued.android.module.live_china.model;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/LiveListCommonModel.class */
public class LiveListCommonModel {
    private boolean hasData;
    private boolean hasFollowData;
    public boolean hasRequestData;
    private boolean isCanReCommend;
    private boolean isFooterShowing;
    private boolean isHeaderShowing;
    private boolean isRecommendShow;
    private boolean isTipShow;
    public String lastUid;
    private int page = 1;
    private int recommendPage = 0;
    public String tabId;
    public String tabName;
    public String tabPoint;
    public int tabType;

    public boolean getHasData() {
        return this.hasData;
    }

    public boolean getHasFollowData() {
        return this.hasFollowData;
    }

    public boolean getIfFooterShowing() {
        return this.isFooterShowing;
    }

    public boolean getIfHeaderShowing() {
        return this.isHeaderShowing;
    }

    public boolean getIfRecommendShow() {
        return this.isRecommendShow;
    }

    public boolean getIfTipShow() {
        return this.isTipShow;
    }

    public int getPage() {
        return this.page;
    }

    public int getRecommendPage() {
        return this.recommendPage;
    }

    public boolean isCanReCommend() {
        return this.isCanReCommend;
    }

    public void setCanReCommend(boolean z) {
        this.isCanReCommend = z;
    }

    public void setFooterShowing(boolean z) {
        this.isFooterShowing = z;
    }

    public void setHasData(boolean z) {
        this.hasData = z;
    }

    public void setHasFollowData(boolean z) {
        this.hasFollowData = z;
    }

    public void setHeaderShowing(boolean z) {
        this.isHeaderShowing = z;
    }

    public void setPage(int i) {
        this.page = i;
    }

    public void setRecommendPage(int i) {
        this.recommendPage = i;
    }

    public void setRecommendShow(boolean z) {
        this.isRecommendShow = z;
    }

    public void setTipShow(boolean z) {
        this.isTipShow = z;
    }
}
