package com.blued.android.module.live_china.model;

import com.blued.android.framework.http.parser.BluedEntityBaseExtra;
import java.io.Serializable;
import java.util.List;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/LiveZanExtraModel.class */
public class LiveZanExtraModel extends BluedEntityBaseExtra implements Serializable {
    public String avatar_frame_url;
    public boolean behalf_bind_status;
    public int bet_count;
    public String bet_err_msg;
    public List<String> bg_color;
    public String bg_img;
    public List<LiveGiftModel> box;
    public int break_even_current;
    public int break_even_max;
    public long danmu_count;
    public String desc_url;
    public List<EmojiModel> emoji;
    public String expire_info;
    public List<LiveLuckyBagGiftModel> goods;
    public LiveGiftSetInfoModel goods_set_info;
    public List<HotWords> hot_words;
    public int join_club;
    public List<LiveImgModel> lantern_image;
    public int lantern_play_times;
    public LiveZanModel like_style;
    public int privilege_emoji;
    public LiveGiftRandomBarModel random;
    public String random_mp4;
    public String random_name;
    public String random_static;
    public int ship_count;
    public LiveGiftSkinItemModel skin_on_process;
    public LiveGiftSkinItemModel skin_on_use;
    public int user_store_count;

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/LiveZanExtraModel$EmojiModel.class */
    public static class EmojiModel implements Serializable {
        public int h;
        public String id;
        public boolean local;
        public String text;
        public String url;
        public int w;
    }

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/LiveZanExtraModel$HotWords.class */
    public static class HotWords implements Serializable {
        public String id;
        public String text;
    }

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/LiveZanExtraModel$LiveZanModel.class */
    public class LiveZanModel implements Serializable {

        /* renamed from: me  reason: collision with root package name */
        public String f13931me;
        public String other;
        public String[] random;

        public LiveZanModel() {
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("LiveZanExtraModel{danmu_count=");
        sb.append(this.danmu_count);
        sb.append(", user_store_count=");
        sb.append(this.user_store_count);
        sb.append(", join_club=");
        sb.append(this.join_club);
        sb.append(", expire_info=");
        sb.append(this.expire_info);
        sb.append(", skin_on_process=");
        LiveGiftSkinItemModel liveGiftSkinItemModel = this.skin_on_process;
        sb.append(liveGiftSkinItemModel != null ? liveGiftSkinItemModel.toString() : "");
        sb.append(", skin_on_use=");
        LiveGiftSkinItemModel liveGiftSkinItemModel2 = this.skin_on_use;
        sb.append(liveGiftSkinItemModel2 != null ? liveGiftSkinItemModel2.toString() : "");
        sb.append('}');
        return sb.toString();
    }
}
