package com.soft.blued.ui.find.model;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/model/NearbyModule.class */
public class NearbyModule {
    public String avatar;
    public int cid;
    public String color;
    public String description;
    public int is_fixed;
    public int is_show;
    public String title;

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/model/NearbyModule$MODULE_ID.class */
    public interface MODULE_ID {
        public static final int HOT_MAN = 3;
        public static final int MAP_FIND = 998;
        public static final int NEARBY_FIND = 997;
        public static final int NEARBY_LIVE = 0;
        public static final int NEW_FACES = 1;
        public static final int TAG_USER = 999;
        public static final int YOU_MAY_LIKE = 2;
    }

    public NearbyModule(String str, String str2, int i) {
        this.title = str;
        this.description = str2;
        this.is_show = i;
    }
}
