package com.blued.android.module.live_china.model;

import java.io.Serializable;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/LiveGiftSkinItemModel.class */
public class LiveGiftSkinItemModel implements Serializable {
    public int animation;
    public int count;
    public String goods_id;
    public long goods_skin_id;
    public String images_apng;
    public String images_gif;
    public String images_mp4;
    public String images_static;
    public boolean isExposure = false;
    public boolean is_original;
    public int level;
    public int next_level;
    public int process;
    public int status;
    public int wear;

    public String toString() {
        return "LiveGiftSkinItemModel{goods_id='" + this.goods_id + "', goods_skin_id=" + this.goods_skin_id + ", level=" + this.level + ", next_level=" + this.next_level + ", count=" + this.count + ", process=" + this.process + ", status=" + this.status + ", wear=" + this.wear + ", is_original=" + this.is_original + ", animation=" + this.animation + ", images_static='" + this.images_static + "', images_gif='" + this.images_gif + "', images_apng='" + this.images_apng + "', images_mp4='" + this.images_mp4 + "'}";
    }
}
