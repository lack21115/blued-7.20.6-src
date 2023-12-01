package com.blued.android.module.live_china.model;

import java.io.Serializable;
import kotlin.Metadata;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/LiveUserCardMouleModel.class */
public final class LiveUserCardMouleModel implements Serializable {
    private boolean animing;
    private int buried_point_type;
    private String color_end;
    private String color_image;
    private String color_start;
    private float current_progress;
    private String desc;
    private String flip_desc;
    private String flip_name;
    private String icon;
    private int interaction_type;
    private boolean is_max_progress;
    private String link;
    private int module_type;
    private String name;
    private boolean show_btm;
    private float total_progress;

    public final boolean getAniming() {
        return this.animing;
    }

    public final int getBuried_point_type() {
        return this.buried_point_type;
    }

    public final String getColor_end() {
        return this.color_end;
    }

    public final String getColor_image() {
        return this.color_image;
    }

    public final String getColor_start() {
        return this.color_start;
    }

    public final float getCurrent_progress() {
        return this.current_progress;
    }

    public final String getDesc() {
        return this.desc;
    }

    public final String getFlip_desc() {
        return this.flip_desc;
    }

    public final String getFlip_name() {
        return this.flip_name;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final int getInteraction_type() {
        return this.interaction_type;
    }

    public final String getLink() {
        return this.link;
    }

    public final int getModule_type() {
        return this.module_type;
    }

    public final String getName() {
        return this.name;
    }

    public final boolean getShow_btm() {
        return this.show_btm;
    }

    public final float getTotal_progress() {
        return this.total_progress;
    }

    public final boolean is_max_progress() {
        return this.is_max_progress;
    }

    public final void setAniming(boolean z) {
        this.animing = z;
    }

    public final void setBuried_point_type(int i) {
        this.buried_point_type = i;
    }

    public final void setColor_end(String str) {
        this.color_end = str;
    }

    public final void setColor_image(String str) {
        this.color_image = str;
    }

    public final void setColor_start(String str) {
        this.color_start = str;
    }

    public final void setCurrent_progress(float f) {
        this.current_progress = f;
    }

    public final void setDesc(String str) {
        this.desc = str;
    }

    public final void setFlip_desc(String str) {
        this.flip_desc = str;
    }

    public final void setFlip_name(String str) {
        this.flip_name = str;
    }

    public final void setIcon(String str) {
        this.icon = str;
    }

    public final void setInteraction_type(int i) {
        this.interaction_type = i;
    }

    public final void setLink(String str) {
        this.link = str;
    }

    public final void setModule_type(int i) {
        this.module_type = i;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final void setShow_btm(boolean z) {
        this.show_btm = z;
    }

    public final void setTotal_progress(float f) {
        this.total_progress = f;
    }

    public final void set_max_progress(boolean z) {
        this.is_max_progress = z;
    }
}
