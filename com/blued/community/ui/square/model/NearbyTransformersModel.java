package com.blued.community.ui.square.model;

import com.blued.android.module.common.utils.TimeAndDateUtils;
import java.util.List;

/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/square/model/NearbyTransformersModel.class */
public class NearbyTransformersModel {
    public String black_background_img;
    public String button;
    public String describe;
    public String icon;
    public List<Rotation> rotation;
    public String title;
    public String type;
    public String url;
    public String white_background_img;

    /* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/square/model/NearbyTransformersModel$Rotation.class */
    public static class Rotation {
        public String activity_date;
        public String id;
        public String name;
        public String pic;

        public String getDate() {
            return TimeAndDateUtils.c(TimeAndDateUtils.c(this.activity_date), true);
        }

        public boolean showDate() {
            return TimeAndDateUtils.c(this.activity_date) > 0;
        }
    }
}
