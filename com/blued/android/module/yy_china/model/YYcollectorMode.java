package com.blued.android.module.yy_china.model;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/YYcollectorMode.class */
public class YYcollectorMode {
    private String description;
    private String gap_jewel;
    private long jewel;
    private int level;
    private long next_jewel;

    /* renamed from: skin  reason: collision with root package name */
    private SkinDTO f17633skin;
    private String status;

    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/YYcollectorMode$SkinDTO.class */
    public static class SkinDTO {
        private String background;
        private String badge;
        private String name;
        private String profile;
        private String wall_head;

        public String getBackground() {
            return this.background;
        }

        public String getBadge() {
            return this.badge;
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

        public void setBadge(String str) {
            this.badge = str;
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

    public String getDescription() {
        return this.description;
    }

    public String getGap_jewel() {
        return this.gap_jewel;
    }

    public long getJewel() {
        return this.jewel;
    }

    public int getLevel() {
        return this.level;
    }

    public long getNext_jewel() {
        return this.next_jewel;
    }

    public SkinDTO getSkin() {
        return this.f17633skin;
    }

    public String getStatus() {
        return this.status;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public void setGap_jewel(String str) {
        this.gap_jewel = str;
    }

    public void setJewel(long j) {
        this.jewel = j;
    }

    public void setLevel(int i) {
        this.level = i;
    }

    public void setNext_jewel(long j) {
        this.next_jewel = j;
    }

    public void setSkin(SkinDTO skinDTO) {
        this.f17633skin = skinDTO;
    }

    public void setStatus(String str) {
        this.status = str;
    }
}
