package com.bytedance.android.live.base.api.outer.data;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/android/live/base/api/outer/data/RoomInfo.class */
public class RoomInfo {
    City city;
    String count;
    String cover;
    String openRoomId;
    long orientation;
    AnchorInfo owner;
    String requestId;
    long status;
    String title;

    public RoomInfo(String str, String str2, String str3, String str4, long j, City city, long j2, AnchorInfo anchorInfo, String str5) {
        this.openRoomId = str;
        this.title = str2;
        this.cover = str3;
        this.count = str4;
        this.orientation = j;
        this.city = city;
        this.status = j2;
        this.owner = anchorInfo;
        this.requestId = str5;
    }

    public City getCity() {
        return this.city;
    }

    public String getCount() {
        return this.count;
    }

    public String getCover() {
        return this.cover;
    }

    public String getOpenRoomId() {
        return this.openRoomId;
    }

    public long getOrientation() {
        return this.orientation;
    }

    public AnchorInfo getOwner() {
        return this.owner;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public long getStatus() {
        return this.status;
    }

    public String getTitle() {
        return this.title;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public void setCount(String str) {
        this.count = str;
    }

    public void setCover(String str) {
        this.cover = str;
    }

    public void setOpenRoomId(String str) {
        this.openRoomId = str;
    }

    public void setOrientation(long j) {
        this.orientation = j;
    }

    public void setOwner(AnchorInfo anchorInfo) {
        this.owner = anchorInfo;
    }

    public void setRequestId(String str) {
        this.requestId = str;
    }

    public void setStatus(long j) {
        this.status = j;
    }

    public void setTitle(String str) {
        this.title = str;
    }
}
