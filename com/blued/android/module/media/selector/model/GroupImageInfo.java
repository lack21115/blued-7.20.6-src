package com.blued.android.module.media.selector.model;

import com.blued.android.module.player.media.model.MediaInfo;
import java.io.Serializable;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/media/selector/model/GroupImageInfo.class */
public class GroupImageInfo implements Serializable {
    private MediaInfo childImageInfo;
    private String folderName;
    private int imageCounts;
    private int mediaType;
    private String topImagePath;
    public String topImageUri;

    public MediaInfo getChildImageInfo() {
        return this.childImageInfo;
    }

    public String getFolderName() {
        return this.folderName;
    }

    public int getImageCounts() {
        return this.imageCounts;
    }

    public int getMediaType() {
        return this.mediaType;
    }

    public String getTopImagePath() {
        return this.topImagePath;
    }

    public boolean isVideoMediaType() {
        return getMediaType() == 3;
    }

    public void setChildImageInfo(MediaInfo mediaInfo) {
        this.childImageInfo = mediaInfo;
    }

    public void setFolderName(String str) {
        this.folderName = str;
    }

    public void setImageCounts(int i) {
        this.imageCounts = i;
    }

    public void setMediaType(int i) {
        this.mediaType = i;
    }

    public void setTopImagePath(String str) {
        this.topImagePath = str;
    }
}
