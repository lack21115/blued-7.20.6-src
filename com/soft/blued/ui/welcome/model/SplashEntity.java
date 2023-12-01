package com.soft.blued.ui.welcome.model;

import com.blued.android.module.common.login.model.BluedADExtra;
import java.io.Serializable;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/welcome/model/SplashEntity.class */
public class SplashEntity implements Serializable, Comparable {
    public int download_type;
    public ExtraJson extra_json;
    public long id;
    public int material_type;
    public String position_code;
    public int ranking;
    public String third_id;
    public ShowEntity today;
    public ShowEntity tomorrow;

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/welcome/model/SplashEntity$ExtraJson.class */
    public static class ExtraJson implements Serializable {
        public Sensitive sensitive;
        public Splash splash;
    }

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/welcome/model/SplashEntity$Sensitive.class */
    public static class Sensitive implements Serializable {
        public double operating_time;
        public int speed;
        public boolean triggered;
        public int turn_angle;
    }

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/welcome/model/SplashEntity$ShowEntity.class */
    public static class ShowEntity extends BluedADExtra implements Serializable {
        public String image;
        public List<SplashEntity> splashResultList;
        public String splash_time;
    }

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/welcome/model/SplashEntity$Splash.class */
    public static class Splash implements Serializable {
        public int hot_area_limit_type;
        public int hot_dynamic;
        public int is_accurate;
        public int request_time_out;
        public int show_time_limit;
        public String text_click_button;
        public String text_shake_it;
        public String text_wipe_up;
        public int transparency;
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        SplashEntity splashEntity = (SplashEntity) obj;
        int i = this.ranking;
        int i2 = splashEntity.ranking;
        if (i > i2) {
            return -1;
        }
        if (i < i2) {
            return 1;
        }
        if (getHash() > splashEntity.getHash()) {
            return -1;
        }
        return getHash() < splashEntity.getHash() ? 1 : 0;
    }

    public int getHash() {
        return (hashCode() >>> 8) ^ hashCode();
    }
}
