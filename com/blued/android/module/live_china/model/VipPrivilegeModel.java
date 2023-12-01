package com.blued.android.module.live_china.model;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/VipPrivilegeModel.class */
public final class VipPrivilegeModel implements Serializable {
    private int id;
    private int info_btn_type;
    private long info_btn_uid;
    private String icon = "";
    private String icon_select = "";
    private String name = "";
    private String info_decs = "";
    private String info_btn = "";
    private String info_btn_url_online = "";
    private String info_btn_url_test = "";
    private String live_suffix = "";
    private String info_btn_nickname = "";
    private String info_img_url = "";

    public final String getIcon() {
        return this.icon;
    }

    public final String getIcon_select() {
        return this.icon_select;
    }

    public final int getId() {
        return this.id;
    }

    public final String getInfo_btn() {
        return this.info_btn;
    }

    public final String getInfo_btn_nickname() {
        return this.info_btn_nickname;
    }

    public final int getInfo_btn_type() {
        return this.info_btn_type;
    }

    public final long getInfo_btn_uid() {
        return this.info_btn_uid;
    }

    public final String getInfo_btn_url_online() {
        return this.info_btn_url_online;
    }

    public final String getInfo_btn_url_test() {
        return this.info_btn_url_test;
    }

    public final String getInfo_decs() {
        return this.info_decs;
    }

    public final String getInfo_img_url() {
        return this.info_img_url;
    }

    public final String getLive_suffix() {
        return this.live_suffix;
    }

    public final String getName() {
        return this.name;
    }

    public final void setIcon(String str) {
        Intrinsics.e(str, "<set-?>");
        this.icon = str;
    }

    public final void setIcon_select(String str) {
        Intrinsics.e(str, "<set-?>");
        this.icon_select = str;
    }

    public final void setId(int i) {
        this.id = i;
    }

    public final void setInfo_btn(String str) {
        Intrinsics.e(str, "<set-?>");
        this.info_btn = str;
    }

    public final void setInfo_btn_nickname(String str) {
        Intrinsics.e(str, "<set-?>");
        this.info_btn_nickname = str;
    }

    public final void setInfo_btn_type(int i) {
        this.info_btn_type = i;
    }

    public final void setInfo_btn_uid(long j) {
        this.info_btn_uid = j;
    }

    public final void setInfo_btn_url_online(String str) {
        Intrinsics.e(str, "<set-?>");
        this.info_btn_url_online = str;
    }

    public final void setInfo_btn_url_test(String str) {
        Intrinsics.e(str, "<set-?>");
        this.info_btn_url_test = str;
    }

    public final void setInfo_decs(String str) {
        Intrinsics.e(str, "<set-?>");
        this.info_decs = str;
    }

    public final void setInfo_img_url(String str) {
        Intrinsics.e(str, "<set-?>");
        this.info_img_url = str;
    }

    public final void setLive_suffix(String str) {
        Intrinsics.e(str, "<set-?>");
        this.live_suffix = str;
    }

    public final void setName(String str) {
        Intrinsics.e(str, "<set-?>");
        this.name = str;
    }
}
