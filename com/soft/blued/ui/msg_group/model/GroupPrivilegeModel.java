package com.soft.blued.ui.msg_group.model;

import com.blued.android.module.common.group.GroupInfoModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg_group/model/GroupPrivilegeModel.class */
public final class GroupPrivilegeModel {
    private List<GroupInfoModel> groupList;
    private int normal_group;
    private int normal_group_max_admin;
    private int normal_max_group;
    private int normal_max_population;
    private int super_group;
    private int super_max_admin;
    private int super_max_group;
    private int super_max_population;
    private int privilege = 2;
    private String lock_time = "";

    public final List<GroupInfoModel> getGroupList() {
        return this.groupList;
    }

    public final String getLock_time() {
        return this.lock_time;
    }

    public final int getNormal_group() {
        return this.normal_group;
    }

    public final int getNormal_group_max_admin() {
        return this.normal_group_max_admin;
    }

    public final int getNormal_max_group() {
        return this.normal_max_group;
    }

    public final int getNormal_max_population() {
        return this.normal_max_population;
    }

    public final int getPrivilege() {
        return this.privilege;
    }

    public final int getSuper_group() {
        return this.super_group;
    }

    public final int getSuper_max_admin() {
        return this.super_max_admin;
    }

    public final int getSuper_max_group() {
        return this.super_max_group;
    }

    public final int getSuper_max_population() {
        return this.super_max_population;
    }

    public final void setGroupList(List<GroupInfoModel> list) {
        this.groupList = list;
    }

    public final void setLock_time(String str) {
        Intrinsics.e(str, "<set-?>");
        this.lock_time = str;
    }

    public final void setNormal_group(int i) {
        this.normal_group = i;
    }

    public final void setNormal_group_max_admin(int i) {
        this.normal_group_max_admin = i;
    }

    public final void setNormal_max_group(int i) {
        this.normal_max_group = i;
    }

    public final void setNormal_max_population(int i) {
        this.normal_max_population = i;
    }

    public final void setPrivilege(int i) {
        this.privilege = i;
    }

    public final void setSuper_group(int i) {
        this.super_group = i;
    }

    public final void setSuper_max_admin(int i) {
        this.super_max_admin = i;
    }

    public final void setSuper_max_group(int i) {
        this.super_max_group = i;
    }

    public final void setSuper_max_population(int i) {
        this.super_max_population = i;
    }
}
