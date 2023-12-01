package com.soft.blued.ui.feed.model;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/feed/model/GroupImageInfo.class */
public class GroupImageInfo {
    private String folderName;
    private int imageCounts;
    private String topImagePath;
    public String topImgUri;

    public String getFolderName() {
        return this.folderName;
    }

    public int getImageCounts() {
        return this.imageCounts;
    }

    public String getTopImagePath() {
        return this.topImagePath;
    }

    public void setFolderName(String str) {
        this.folderName = str;
    }

    public void setImageCounts(int i) {
        this.imageCounts = i;
    }

    public void setTopImagePath(String str) {
        this.topImagePath = str;
    }
}
