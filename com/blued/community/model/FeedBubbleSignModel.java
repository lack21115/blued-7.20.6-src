package com.blued.community.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/community/model/FeedBubbleSignModel.class */
public final class FeedBubbleSignModel {
    @SerializedName("base_map")
    private String bgImg;
    @SerializedName("leading_button")
    private String btnText;
    @SerializedName("ttl_time")
    private long exposureTime;
    @SerializedName("clockin_num")
    private int finishNum;
    private String id;
    private String name;
    private String subtitle;
    @SerializedName("time_text")
    private List<FeedBubbleSignTextModel> timeList;
    private String title;
    private int today_complete;

    public final String getBgImg() {
        return this.bgImg;
    }

    public final String getBtnText() {
        return this.btnText;
    }

    public final long getExposureTime() {
        return this.exposureTime;
    }

    public final int getFinishNum() {
        return this.finishNum;
    }

    public final String getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final String getSubtitle() {
        return this.subtitle;
    }

    public final List<FeedBubbleSignTextModel> getTimeList() {
        return this.timeList;
    }

    public final String getTitle() {
        return this.title;
    }

    public final int getToday_complete() {
        return this.today_complete;
    }

    public final void setBgImg(String str) {
        this.bgImg = str;
    }

    public final void setBtnText(String str) {
        this.btnText = str;
    }

    public final void setExposureTime(long j) {
        this.exposureTime = j;
    }

    public final void setFinishNum(int i) {
        this.finishNum = i;
    }

    public final void setId(String str) {
        this.id = str;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final void setSubtitle(String str) {
        this.subtitle = str;
    }

    public final void setTimeList(List<FeedBubbleSignTextModel> list) {
        this.timeList = list;
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    public final void setToday_complete(int i) {
        this.today_complete = i;
    }
}
