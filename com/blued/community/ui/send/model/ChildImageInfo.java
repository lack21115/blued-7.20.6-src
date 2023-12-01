package com.blued.community.ui.send.model;

/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/send/model/ChildImageInfo.class */
public class ChildImageInfo {
    public long duration;
    public int height;
    public String imgUri;
    public boolean isVideo = false;
    public int itemType = 0;
    public String mImagePath;
    public String mPid;
    public boolean mSelect;
    public boolean mTakePhoto;
    public String mediaType;
    public int width;

    public ChildImageInfo() {
    }

    public ChildImageInfo(ChildImageInfo childImageInfo) {
        copy(childImageInfo);
    }

    public ChildImageInfo(String str) {
        this.mImagePath = str;
    }

    public void copy(ChildImageInfo childImageInfo) {
        this.mImagePath = childImageInfo.mImagePath;
        this.mPid = childImageInfo.mPid;
        this.mSelect = childImageInfo.mSelect;
        this.width = childImageInfo.width;
        this.height = childImageInfo.height;
        this.mTakePhoto = childImageInfo.mTakePhoto;
        this.isVideo = childImageInfo.isVideo;
    }
}
