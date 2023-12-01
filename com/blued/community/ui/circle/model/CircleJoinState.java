package com.blued.community.ui.circle.model;

/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/circle/model/CircleJoinState.class */
public class CircleJoinState {
    public int admin_level;
    public int allow_join;
    public String circle_id;
    public String cover;
    public int is_applied;
    public String title;

    public CircleJoinState(String str, String str2, String str3, int i, int i2, int i3) {
        this.circle_id = str;
        this.title = str2;
        this.cover = str3;
        this.admin_level = i;
        this.allow_join = i2;
        this.is_applied = i3;
    }

    public boolean isJoin() {
        return this.admin_level != 3;
    }

    public void setExitJoin() {
        this.admin_level = 3;
    }

    public void setJoin() {
        this.admin_level = 0;
    }
}
