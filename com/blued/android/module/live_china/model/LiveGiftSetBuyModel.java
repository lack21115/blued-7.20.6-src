package com.blued.android.module.live_china.model;

import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/LiveGiftSetBuyModel.class */
public final class LiveGiftSetBuyModel implements Serializable {
    private long beans;
    private long beans_count;
    private long beans_current;
    private long bonus;
    private ArrayList<LiveGiftSetErrorModel> err_goods;
    private int expire_time;
    private ArrayList<LiveGiftSetItemModel> goods_animation;
    private int id;
    private int is_finish;
    private ArrayList<LiveGiftSetItemModel> progress;
    private ArrayList<LiveGiftSetTaskModel> task_info;
    private String goods_set_animation = "";
    private String name = "";

    public final long getBeans() {
        return this.beans;
    }

    public final long getBeans_count() {
        return this.beans_count;
    }

    public final long getBeans_current() {
        return this.beans_current;
    }

    public final long getBonus() {
        return this.bonus;
    }

    public final ArrayList<LiveGiftSetErrorModel> getErr_goods() {
        return this.err_goods;
    }

    public final int getExpire_time() {
        return this.expire_time;
    }

    public final ArrayList<LiveGiftSetItemModel> getGoods_animation() {
        return this.goods_animation;
    }

    public final String getGoods_set_animation() {
        return this.goods_set_animation;
    }

    public final int getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final ArrayList<LiveGiftSetItemModel> getProgress() {
        return this.progress;
    }

    public final ArrayList<LiveGiftSetTaskModel> getTask_info() {
        return this.task_info;
    }

    public final int is_finish() {
        return this.is_finish;
    }

    public final void setBeans(long j) {
        this.beans = j;
    }

    public final void setBeans_count(long j) {
        this.beans_count = j;
    }

    public final void setBeans_current(long j) {
        this.beans_current = j;
    }

    public final void setBonus(long j) {
        this.bonus = j;
    }

    public final void setErr_goods(ArrayList<LiveGiftSetErrorModel> arrayList) {
        this.err_goods = arrayList;
    }

    public final void setExpire_time(int i) {
        this.expire_time = i;
    }

    public final void setGoods_animation(ArrayList<LiveGiftSetItemModel> arrayList) {
        this.goods_animation = arrayList;
    }

    public final void setGoods_set_animation(String str) {
        Intrinsics.e(str, "<set-?>");
        this.goods_set_animation = str;
    }

    public final void setId(int i) {
        this.id = i;
    }

    public final void setName(String str) {
        Intrinsics.e(str, "<set-?>");
        this.name = str;
    }

    public final void setProgress(ArrayList<LiveGiftSetItemModel> arrayList) {
        this.progress = arrayList;
    }

    public final void setTask_info(ArrayList<LiveGiftSetTaskModel> arrayList) {
        this.task_info = arrayList;
    }

    public final void set_finish(int i) {
        this.is_finish = i;
    }
}
