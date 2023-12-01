package com.blued.android.module.yy_china.model;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/YYCollectorConfigMode.class */
public class YYCollectorConfigMode {
    private BadgeDTO badge;
    private GoodsDTO goods;
    private Integer id;
    private int is_achieve;
    private Integer jewel;
    private String name;

    /* renamed from: skin  reason: collision with root package name */
    private SkinDTO f17615skin;

    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/YYCollectorConfigMode$BadgeDTO.class */
    public static class BadgeDTO {
        private Integer badge_id;
        private String image;
        private String name;

        public Integer getBadge_id() {
            return this.badge_id;
        }

        public String getImage() {
            return this.image;
        }

        public String getName() {
            return this.name;
        }

        public void setBadge_id(Integer num) {
            this.badge_id = num;
        }

        public void setImage(String str) {
            this.image = str;
        }

        public void setName(String str) {
            this.name = str;
        }
    }

    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/YYCollectorConfigMode$GoodsDTO.class */
    public static class GoodsDTO {
        private String image;
        private String image_static;
        private String name;

        public String getImage() {
            return this.image;
        }

        public String getImage_static() {
            return this.image_static;
        }

        public String getName() {
            return this.name;
        }

        public void setImage(String str) {
            this.image = str;
        }

        public void setImage_static(String str) {
            this.image_static = str;
        }

        public void setName(String str) {
            this.name = str;
        }
    }

    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/YYCollectorConfigMode$SkinDTO.class */
    public static class SkinDTO {
        private String background;
        private String image;
        private String introduce;
        private String name;
        private String profile;
        private String wall_head;

        public String getBackground() {
            return this.background;
        }

        public String getImage() {
            return this.image;
        }

        public String getIntroduce() {
            return this.introduce;
        }

        public String getName() {
            return this.name;
        }

        public String getProfile() {
            return this.profile;
        }

        public String getWall_head() {
            return this.wall_head;
        }

        public void setBackground(String str) {
            this.background = str;
        }

        public void setImage(String str) {
            this.image = str;
        }

        public void setIntroduce(String str) {
            this.introduce = str;
        }

        public void setName(String str) {
            this.name = str;
        }

        public void setProfile(String str) {
            this.profile = str;
        }

        public void setWall_head(String str) {
            this.wall_head = str;
        }
    }

    public BadgeDTO getBadge() {
        return this.badge;
    }

    public GoodsDTO getGoods() {
        return this.goods;
    }

    public Integer getId() {
        return this.id;
    }

    public int getIs_achieve() {
        return this.is_achieve;
    }

    public Integer getJewel() {
        return this.jewel;
    }

    public String getName() {
        return this.name;
    }

    public SkinDTO getSkin() {
        return this.f17615skin;
    }

    public void setBadge(BadgeDTO badgeDTO) {
        this.badge = badgeDTO;
    }

    public void setGoods(GoodsDTO goodsDTO) {
        this.goods = goodsDTO;
    }

    public void setId(Integer num) {
        this.id = num;
    }

    public void setIs_achieve(int i) {
        this.is_achieve = i;
    }

    public void setJewel(Integer num) {
        this.jewel = num;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setSkin(SkinDTO skinDTO) {
        this.f17615skin = skinDTO;
    }
}
