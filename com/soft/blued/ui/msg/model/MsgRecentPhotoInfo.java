package com.soft.blued.ui.msg.model;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/model/MsgRecentPhotoInfo.class */
public class MsgRecentPhotoInfo {
    public int height;
    public long id;
    public String imgPath;
    public int isNormalImg = 0;
    public boolean isPin;
    public boolean isSelected;
    public boolean isYellow;
    public int width;

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/model/MsgRecentPhotoInfo$NormalImgType.class */
    public interface NormalImgType {
        public static final int LONGIMG = 1;
        public static final int NOMALIMG = 0;
        public static final int WIDEIMG = 2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.imgPath.equals(((MsgRecentPhotoInfo) obj).imgPath);
    }

    public int hashCode() {
        return this.imgPath.hashCode();
    }

    public String toString() {
        return "MsgRecentPhotoInfo{id=" + this.id + ", imgPath='" + this.imgPath + "', isSelected=" + this.isSelected + ", width=" + this.width + ", height=" + this.height + ", isNormalImg=" + this.isNormalImg + ", isPin=" + this.isPin + ", isYellow=" + this.isYellow + '}';
    }
}
