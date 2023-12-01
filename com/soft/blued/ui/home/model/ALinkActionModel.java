package com.soft.blued.ui.home.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/home/model/ALinkActionModel.class */
public final class ALinkActionModel {
    private int home_page_popup;
    private int live_tab_red_dot;
    private int local_dialog_show_times;
    private String popup_image = "";
    private String popup_image_min = "";
    private String popup_image_max = "";
    private String jump_link = "";
    private int live_tab_red_dot_cycle = 1;
    private int live_tab_red_dot_time = 1;
    private int home_page_popup_cycle = 1;
    private int home_page_popup_time = 1;

    public final int getHome_page_popup() {
        return this.home_page_popup;
    }

    public final int getHome_page_popup_cycle() {
        return this.home_page_popup_cycle;
    }

    public final int getHome_page_popup_time() {
        return this.home_page_popup_time;
    }

    public final String getJump_link() {
        return this.jump_link;
    }

    public final int getLive_tab_red_dot() {
        return this.live_tab_red_dot;
    }

    public final int getLive_tab_red_dot_cycle() {
        return this.live_tab_red_dot_cycle;
    }

    public final int getLive_tab_red_dot_time() {
        return this.live_tab_red_dot_time;
    }

    public final int getLocal_dialog_show_times() {
        return this.local_dialog_show_times;
    }

    public final String getPopup_image() {
        return this.popup_image;
    }

    public final String getPopup_image_max() {
        return this.popup_image_max;
    }

    public final String getPopup_image_min() {
        return this.popup_image_min;
    }

    public final void setHome_page_popup(int i) {
        this.home_page_popup = i;
    }

    public final void setHome_page_popup_cycle(int i) {
        this.home_page_popup_cycle = i;
    }

    public final void setHome_page_popup_time(int i) {
        this.home_page_popup_time = i;
    }

    public final void setJump_link(String str) {
        Intrinsics.e(str, "<set-?>");
        this.jump_link = str;
    }

    public final void setLive_tab_red_dot(int i) {
        this.live_tab_red_dot = i;
    }

    public final void setLive_tab_red_dot_cycle(int i) {
        this.live_tab_red_dot_cycle = i;
    }

    public final void setLive_tab_red_dot_time(int i) {
        this.live_tab_red_dot_time = i;
    }

    public final void setLocal_dialog_show_times(int i) {
        this.local_dialog_show_times = i;
    }

    public final void setPopup_image(String str) {
        Intrinsics.e(str, "<set-?>");
        this.popup_image = str;
    }

    public final void setPopup_image_max(String str) {
        Intrinsics.e(str, "<set-?>");
        this.popup_image_max = str;
    }

    public final void setPopup_image_min(String str) {
        Intrinsics.e(str, "<set-?>");
        this.popup_image_min = str;
    }
}
