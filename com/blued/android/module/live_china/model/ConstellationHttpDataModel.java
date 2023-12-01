package com.blued.android.module.live_china.model;

import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/ConstellationHttpDataModel.class */
public final class ConstellationHttpDataModel implements Serializable {
    private ArrayList<ConstellationTabDataModel> all_constellations;
    private int constellation_id;
    private ConstellationItemDataModel cur_anchor;
    private ArrayList<ConstellationItemDataModel> list;
    private int season;
    private ConstellationAnchorUserDataModel top_anchor;
    private int top_goods_count;
    private ConstellationAnchorUserDataModel top_user;
    private String background = "";
    private String header = "";
    private String title = "";
    private String link = "";
    private int status = -1;
    private String constellation_image = "";
    private String constellation_name = "";
    private String top_name = "";
    private String anchor_name = "";
    private String anchor_avatar = "";
    private String spokesman_title = "";
    private String spokesman_time = "";

    public final ArrayList<ConstellationTabDataModel> getAll_constellations() {
        return this.all_constellations;
    }

    public final String getAnchor_avatar() {
        return this.anchor_avatar;
    }

    public final String getAnchor_name() {
        return this.anchor_name;
    }

    public final String getBackground() {
        return this.background;
    }

    public final int getConstellation_id() {
        return this.constellation_id;
    }

    public final String getConstellation_image() {
        return this.constellation_image;
    }

    public final String getConstellation_name() {
        return this.constellation_name;
    }

    public final ConstellationItemDataModel getCur_anchor() {
        return this.cur_anchor;
    }

    public final String getHeader() {
        return this.header;
    }

    public final String getLink() {
        return this.link;
    }

    public final ArrayList<ConstellationItemDataModel> getList() {
        return this.list;
    }

    public final int getSeason() {
        return this.season;
    }

    public final String getSpokesman_time() {
        return this.spokesman_time;
    }

    public final String getSpokesman_title() {
        return this.spokesman_title;
    }

    public final int getStatus() {
        return this.status;
    }

    public final String getTitle() {
        return this.title;
    }

    public final ConstellationAnchorUserDataModel getTop_anchor() {
        return this.top_anchor;
    }

    public final int getTop_goods_count() {
        return this.top_goods_count;
    }

    public final String getTop_name() {
        return this.top_name;
    }

    public final ConstellationAnchorUserDataModel getTop_user() {
        return this.top_user;
    }

    public final void setAll_constellations(ArrayList<ConstellationTabDataModel> arrayList) {
        this.all_constellations = arrayList;
    }

    public final void setAnchor_avatar(String str) {
        Intrinsics.e(str, "<set-?>");
        this.anchor_avatar = str;
    }

    public final void setAnchor_name(String str) {
        Intrinsics.e(str, "<set-?>");
        this.anchor_name = str;
    }

    public final void setBackground(String str) {
        Intrinsics.e(str, "<set-?>");
        this.background = str;
    }

    public final void setConstellation_id(int i) {
        this.constellation_id = i;
    }

    public final void setConstellation_image(String str) {
        Intrinsics.e(str, "<set-?>");
        this.constellation_image = str;
    }

    public final void setConstellation_name(String str) {
        Intrinsics.e(str, "<set-?>");
        this.constellation_name = str;
    }

    public final void setCur_anchor(ConstellationItemDataModel constellationItemDataModel) {
        this.cur_anchor = constellationItemDataModel;
    }

    public final void setHeader(String str) {
        Intrinsics.e(str, "<set-?>");
        this.header = str;
    }

    public final void setLink(String str) {
        Intrinsics.e(str, "<set-?>");
        this.link = str;
    }

    public final void setList(ArrayList<ConstellationItemDataModel> arrayList) {
        this.list = arrayList;
    }

    public final void setSeason(int i) {
        this.season = i;
    }

    public final void setSpokesman_time(String str) {
        Intrinsics.e(str, "<set-?>");
        this.spokesman_time = str;
    }

    public final void setSpokesman_title(String str) {
        Intrinsics.e(str, "<set-?>");
        this.spokesman_title = str;
    }

    public final void setStatus(int i) {
        this.status = i;
    }

    public final void setTitle(String str) {
        Intrinsics.e(str, "<set-?>");
        this.title = str;
    }

    public final void setTop_anchor(ConstellationAnchorUserDataModel constellationAnchorUserDataModel) {
        this.top_anchor = constellationAnchorUserDataModel;
    }

    public final void setTop_goods_count(int i) {
        this.top_goods_count = i;
    }

    public final void setTop_name(String str) {
        Intrinsics.e(str, "<set-?>");
        this.top_name = str;
    }

    public final void setTop_user(ConstellationAnchorUserDataModel constellationAnchorUserDataModel) {
        this.top_user = constellationAnchorUserDataModel;
    }
}
