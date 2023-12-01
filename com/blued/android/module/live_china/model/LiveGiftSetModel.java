package com.blued.android.module.live_china.model;

import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/LiveGiftSetModel.class */
public final class LiveGiftSetModel implements Serializable {
    private ArrayList<LiveGiftSetTabModel> all_name;
    private ArrayList<LiveGiftSetDesModel> description;
    private int expire_time;
    private int id;
    private ArrayList<LiveGiftSetItemModel> progress;
    private ArrayList<LiveGiftSetTaskModel> task_info;
    private String text = "";
    private String link = "";

    public final ArrayList<LiveGiftSetTabModel> getAll_name() {
        return this.all_name;
    }

    public final ArrayList<LiveGiftSetDesModel> getDescription() {
        return this.description;
    }

    public final int getExpire_time() {
        return this.expire_time;
    }

    public final int getId() {
        return this.id;
    }

    public final String getLink() {
        return this.link;
    }

    public final ArrayList<LiveGiftSetItemModel> getProgress() {
        return this.progress;
    }

    public final ArrayList<LiveGiftSetTaskModel> getTask_info() {
        return this.task_info;
    }

    public final String getText() {
        return this.text;
    }

    public final void setAll_name(ArrayList<LiveGiftSetTabModel> arrayList) {
        this.all_name = arrayList;
    }

    public final void setDescription(ArrayList<LiveGiftSetDesModel> arrayList) {
        this.description = arrayList;
    }

    public final void setExpire_time(int i) {
        this.expire_time = i;
    }

    public final void setId(int i) {
        this.id = i;
    }

    public final void setLink(String str) {
        Intrinsics.e(str, "<set-?>");
        this.link = str;
    }

    public final void setProgress(ArrayList<LiveGiftSetItemModel> arrayList) {
        this.progress = arrayList;
    }

    public final void setTask_info(ArrayList<LiveGiftSetTaskModel> arrayList) {
        this.task_info = arrayList;
    }

    public final void setText(String str) {
        Intrinsics.e(str, "<set-?>");
        this.text = str;
    }
}
