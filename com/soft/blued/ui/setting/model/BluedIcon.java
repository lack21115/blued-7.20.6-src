package com.soft.blued.ui.setting.model;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/setting/model/BluedIcon.class */
public class BluedIcon {
    private int iconResourceId;
    private boolean isChecked;
    private String launcherName;

    public BluedIcon(int i, boolean z, String str) {
        this.iconResourceId = i;
        this.isChecked = z;
        this.launcherName = str;
    }

    public int getIconResourceId() {
        return this.iconResourceId;
    }

    public String getLauncherName() {
        return this.launcherName;
    }

    public boolean isChecked() {
        return this.isChecked;
    }

    public void setChecked(boolean z) {
        this.isChecked = z;
    }
}
