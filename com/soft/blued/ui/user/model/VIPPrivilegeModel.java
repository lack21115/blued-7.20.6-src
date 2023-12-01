package com.soft.blued.ui.user.model;

import java.io.Serializable;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/model/VIPPrivilegeModel.class */
public class VIPPrivilegeModel implements Serializable {
    public String content;
    public String icon;
    public String name;
    public int pid;
    public String url;

    public VIPPrivilegeModel(String str, String str2) {
        this.name = str;
        this.icon = str2;
    }
}
