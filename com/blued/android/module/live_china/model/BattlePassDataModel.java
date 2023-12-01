package com.blued.android.module.live_china.model;

import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/BattlePassDataModel.class */
public final class BattlePassDataModel implements Serializable {
    private ArrayList<BattlePassBonusHistoryDataModel> bonus_history;
    private int claim;
    private ArrayList<BattlePassTaskDataModel> daily_task;
    private int exp;
    private int level;
    private ArrayList<BattlePassLevelDataModel> levels;
    private int max_exp;
    private int top_price;
    private int top_unlocked;
    private int unlock_all_price;
    private int unlock_price;
    private ArrayList<BattlePassTaskDataModel> week_task;
    private String duration_desc = "";
    private String alert_desc = "";
    private String desc_pic_url = "";
    private String daily_task_next_update = "";
    private String week_task_next_update = "";

    public final String getAlert_desc() {
        return this.alert_desc;
    }

    public final ArrayList<BattlePassBonusHistoryDataModel> getBonus_history() {
        return this.bonus_history;
    }

    public final int getClaim() {
        return this.claim;
    }

    public final ArrayList<BattlePassTaskDataModel> getDaily_task() {
        return this.daily_task;
    }

    public final String getDaily_task_next_update() {
        return this.daily_task_next_update;
    }

    public final String getDesc_pic_url() {
        return this.desc_pic_url;
    }

    public final String getDuration_desc() {
        return this.duration_desc;
    }

    public final int getExp() {
        return this.exp;
    }

    public final int getLevel() {
        return this.level;
    }

    public final ArrayList<BattlePassLevelDataModel> getLevels() {
        return this.levels;
    }

    public final int getMax_exp() {
        return this.max_exp;
    }

    public final int getTop_price() {
        return this.top_price;
    }

    public final int getTop_unlocked() {
        return this.top_unlocked;
    }

    public final int getUnlock_all_price() {
        return this.unlock_all_price;
    }

    public final int getUnlock_price() {
        return this.unlock_price;
    }

    public final ArrayList<BattlePassTaskDataModel> getWeek_task() {
        return this.week_task;
    }

    public final String getWeek_task_next_update() {
        return this.week_task_next_update;
    }

    public final void setAlert_desc(String str) {
        Intrinsics.e(str, "<set-?>");
        this.alert_desc = str;
    }

    public final void setBonus_history(ArrayList<BattlePassBonusHistoryDataModel> arrayList) {
        this.bonus_history = arrayList;
    }

    public final void setClaim(int i) {
        this.claim = i;
    }

    public final void setDaily_task(ArrayList<BattlePassTaskDataModel> arrayList) {
        this.daily_task = arrayList;
    }

    public final void setDaily_task_next_update(String str) {
        Intrinsics.e(str, "<set-?>");
        this.daily_task_next_update = str;
    }

    public final void setDesc_pic_url(String str) {
        Intrinsics.e(str, "<set-?>");
        this.desc_pic_url = str;
    }

    public final void setDuration_desc(String str) {
        Intrinsics.e(str, "<set-?>");
        this.duration_desc = str;
    }

    public final void setExp(int i) {
        this.exp = i;
    }

    public final void setLevel(int i) {
        this.level = i;
    }

    public final void setLevels(ArrayList<BattlePassLevelDataModel> arrayList) {
        this.levels = arrayList;
    }

    public final void setMax_exp(int i) {
        this.max_exp = i;
    }

    public final void setTop_price(int i) {
        this.top_price = i;
    }

    public final void setTop_unlocked(int i) {
        this.top_unlocked = i;
    }

    public final void setUnlock_all_price(int i) {
        this.unlock_all_price = i;
    }

    public final void setUnlock_price(int i) {
        this.unlock_price = i;
    }

    public final void setWeek_task(ArrayList<BattlePassTaskDataModel> arrayList) {
        this.week_task = arrayList;
    }

    public final void setWeek_task_next_update(String str) {
        Intrinsics.e(str, "<set-?>");
        this.week_task_next_update = str;
    }
}
