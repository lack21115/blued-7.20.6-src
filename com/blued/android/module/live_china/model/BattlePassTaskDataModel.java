package com.blued.android.module.live_china.model;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/BattlePassTaskDataModel.class */
public final class BattlePassTaskDataModel implements Serializable {
    private int current;
    private int exp;
    private int id;
    private int state;
    private int target;
    private int type;
    private String task = "";
    private String icon = "";
    private String unit = "";
    private String action_type = "";

    public final String getAction_type() {
        return this.action_type;
    }

    public final int getCurrent() {
        return this.current;
    }

    public final int getExp() {
        return this.exp;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final int getId() {
        return this.id;
    }

    public final int getState() {
        return this.state;
    }

    public final int getTarget() {
        return this.target;
    }

    public final String getTask() {
        return this.task;
    }

    public final int getType() {
        return this.type;
    }

    public final String getUnit() {
        return this.unit;
    }

    public final void setAction_type(String str) {
        Intrinsics.e(str, "<set-?>");
        this.action_type = str;
    }

    public final void setCurrent(int i) {
        this.current = i;
    }

    public final void setExp(int i) {
        this.exp = i;
    }

    public final void setIcon(String str) {
        Intrinsics.e(str, "<set-?>");
        this.icon = str;
    }

    public final void setId(int i) {
        this.id = i;
    }

    public final void setState(int i) {
        this.state = i;
    }

    public final void setTarget(int i) {
        this.target = i;
    }

    public final void setTask(String str) {
        Intrinsics.e(str, "<set-?>");
        this.task = str;
    }

    public final void setType(int i) {
        this.type = i;
    }

    public final void setUnit(String str) {
        Intrinsics.e(str, "<set-?>");
        this.unit = str;
    }
}
