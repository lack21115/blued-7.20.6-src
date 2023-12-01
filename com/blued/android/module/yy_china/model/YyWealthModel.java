package com.blued.android.module.yy_china.model;

import com.blued.android.framework.http.parser.BluedEntityBaseExtra;
import java.io.Serializable;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/YyWealthModel.class */
public class YyWealthModel extends BluedEntityBaseExtra implements Serializable {
    private String avatar_frame;
    private String current_consume_beans;
    private String current_wealth_experience;
    private String enter_effects;
    private String enter_effects_forward;
    private String level_consume_beans;
    private String level_wealth_experience;
    private String message_bubble_icon;
    private String message_bubble_img;
    private String mounts_icon;
    private String mounts_img;
    private String wealth_level;

    public String getAvatar_frame() {
        String str = this.avatar_frame;
        String str2 = str;
        if (str == null) {
            str2 = "";
        }
        return str2;
    }

    public String getCurrent_consume_beans() {
        return this.current_consume_beans;
    }

    public String getCurrent_wealth_experience() {
        return this.current_wealth_experience;
    }

    public String getEnter_effects() {
        String str = this.enter_effects;
        String str2 = str;
        if (str == null) {
            str2 = "";
        }
        return str2;
    }

    public String getEnter_effects_forward() {
        return this.enter_effects_forward;
    }

    public String getLevel_consume_beans() {
        return this.level_consume_beans;
    }

    public String getLevel_wealth_experience() {
        return this.level_wealth_experience;
    }

    public String getMessage_bubble_icon() {
        return this.message_bubble_icon;
    }

    public String getMessage_bubble_img() {
        return this.message_bubble_img;
    }

    public String getMounts_icon() {
        return this.mounts_icon;
    }

    public String getMounts_img() {
        return this.mounts_img;
    }

    public String getWealth_level() {
        String str = this.wealth_level;
        String str2 = str;
        if (str == null) {
            str2 = "";
        }
        return str2;
    }

    public void setAvatar_frame(String str) {
        this.avatar_frame = str;
    }

    public void setCurrent_consume_beans(String str) {
        this.current_consume_beans = str;
    }

    public void setCurrent_wealth_experience(String str) {
        this.current_wealth_experience = str;
    }

    public void setEnter_effects(String str) {
        this.enter_effects = str;
    }

    public void setEnter_effects_forward(String str) {
        this.enter_effects_forward = str;
    }

    public void setLevel_consume_beans(String str) {
        this.level_consume_beans = str;
    }

    public void setLevel_wealth_experience(String str) {
        this.level_wealth_experience = str;
    }

    public void setMessage_bubble_icon(String str) {
        this.message_bubble_icon = str;
    }

    public void setMessage_bubble_img(String str) {
        this.message_bubble_img = str;
    }

    public void setMounts_icon(String str) {
        this.mounts_icon = str;
    }

    public void setMounts_img(String str) {
        this.mounts_img = str;
    }

    public void setWealth_level(String str) {
        this.wealth_level = str;
    }
}
