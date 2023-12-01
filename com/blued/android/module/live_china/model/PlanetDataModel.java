package com.blued.android.module.live_china.model;

import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/PlanetDataModel.class */
public final class PlanetDataModel implements Serializable {
    private int bet_count;
    private ArrayList<Integer> bet_option;
    private int bet_remain_time;
    private int bet_time;
    private ArrayList<PlanetBroadcastModel> draw_rotation;
    private int expedition_goods_beans;
    private int expedition_goods_id;
    private ArrayList<PlanetGiveNumModel> expedition_goods_option;
    private ArrayList<PlanetBallModel> planet;
    private int ship_count;
    private int status;
    private String expedition_goods_image = "";
    private String text_image = "";

    public final int getBet_count() {
        return this.bet_count;
    }

    public final ArrayList<Integer> getBet_option() {
        return this.bet_option;
    }

    public final int getBet_remain_time() {
        return this.bet_remain_time;
    }

    public final int getBet_time() {
        return this.bet_time;
    }

    public final ArrayList<PlanetBroadcastModel> getDraw_rotation() {
        return this.draw_rotation;
    }

    public final int getExpedition_goods_beans() {
        return this.expedition_goods_beans;
    }

    public final int getExpedition_goods_id() {
        return this.expedition_goods_id;
    }

    public final String getExpedition_goods_image() {
        return this.expedition_goods_image;
    }

    public final ArrayList<PlanetGiveNumModel> getExpedition_goods_option() {
        return this.expedition_goods_option;
    }

    public final ArrayList<PlanetBallModel> getPlanet() {
        return this.planet;
    }

    public final int getShip_count() {
        return this.ship_count;
    }

    public final int getStatus() {
        return this.status;
    }

    public final String getText_image() {
        return this.text_image;
    }

    public final void setBet_count(int i) {
        this.bet_count = i;
    }

    public final void setBet_option(ArrayList<Integer> arrayList) {
        this.bet_option = arrayList;
    }

    public final void setBet_remain_time(int i) {
        this.bet_remain_time = i;
    }

    public final void setBet_time(int i) {
        this.bet_time = i;
    }

    public final void setDraw_rotation(ArrayList<PlanetBroadcastModel> arrayList) {
        this.draw_rotation = arrayList;
    }

    public final void setExpedition_goods_beans(int i) {
        this.expedition_goods_beans = i;
    }

    public final void setExpedition_goods_id(int i) {
        this.expedition_goods_id = i;
    }

    public final void setExpedition_goods_image(String str) {
        Intrinsics.e(str, "<set-?>");
        this.expedition_goods_image = str;
    }

    public final void setExpedition_goods_option(ArrayList<PlanetGiveNumModel> arrayList) {
        this.expedition_goods_option = arrayList;
    }

    public final void setPlanet(ArrayList<PlanetBallModel> arrayList) {
        this.planet = arrayList;
    }

    public final void setShip_count(int i) {
        this.ship_count = i;
    }

    public final void setStatus(int i) {
        this.status = i;
    }

    public final void setText_image(String str) {
        Intrinsics.e(str, "<set-?>");
        this.text_image = str;
    }
}
