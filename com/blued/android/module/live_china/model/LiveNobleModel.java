package com.blued.android.module.live_china.model;

import com.blued.android.module.common.utils.ReflectionUtils;
import java.io.Serializable;
import kotlin.Metadata;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/LiveNobleModel.class */
public final class LiveNobleModel implements Serializable {
    private int can_emoji;
    private int can_kick;
    private int can_mute;
    private String nameplate_img;
    private String noble_join_text;
    private int noble_level;
    private String noble_name;
    private Integer nameplate_img_width = 0;
    private Integer nameplate_img_height = 0;

    public final void copyModel(LiveNobleModel liveNobleModel) {
        ReflectionUtils.a(liveNobleModel, this);
    }

    public final int getCan_emoji() {
        return this.can_emoji;
    }

    public final int getCan_kick() {
        return this.can_kick;
    }

    public final int getCan_mute() {
        return this.can_mute;
    }

    public final String getNameplate_img() {
        return this.nameplate_img;
    }

    public final Integer getNameplate_img_height() {
        return this.nameplate_img_height;
    }

    public final Integer getNameplate_img_width() {
        return this.nameplate_img_width;
    }

    public final String getNoble_join_text() {
        return this.noble_join_text;
    }

    public final int getNoble_level() {
        return this.noble_level;
    }

    public final String getNoble_name() {
        return this.noble_name;
    }

    public final void setCan_emoji(int i) {
        this.can_emoji = i;
    }

    public final void setCan_kick(int i) {
        this.can_kick = i;
    }

    public final void setCan_mute(int i) {
        this.can_mute = i;
    }

    public final void setNameplate_img(String str) {
        this.nameplate_img = str;
    }

    public final void setNameplate_img_height(Integer num) {
        this.nameplate_img_height = num;
    }

    public final void setNameplate_img_width(Integer num) {
        this.nameplate_img_width = num;
    }

    public final void setNoble_join_text(String str) {
        this.noble_join_text = str;
    }

    public final void setNoble_level(int i) {
        this.noble_level = i;
    }

    public final void setNoble_name(String str) {
        this.noble_name = str;
    }

    public String toString() {
        return "LiveNobleModel(can_mute=" + this.can_mute + ", can_kick=" + this.can_kick + ", can_emoji=" + this.can_emoji + ", noble_level=" + this.noble_level + ", noble_name=" + ((Object) this.noble_name) + ", nameplate_img=" + ((Object) this.nameplate_img) + ", nameplate_img_width=" + this.nameplate_img_width + ", nameplate_img_height=" + this.nameplate_img_height + ", noble_join_text=" + ((Object) this.noble_join_text) + ')';
    }
}
