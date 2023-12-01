package com.soft.blued.ui.group.model;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/group/model/BluedGroupTypeGridItem.class */
public class BluedGroupTypeGridItem extends BluedGroupTypeTags {
    private String name;
    private String tags;
    private int type;

    public BluedGroupTypeGridItem(int i, String str, String str2) {
        this.type = i;
        this.tags = str;
        this.name = str2;
    }

    public String getName() {
        return this.name;
    }

    public String getTags() {
        return this.tags;
    }

    public int getType() {
        return this.type;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setTags(String str) {
        this.tags = str;
    }

    public void setType(int i) {
        this.type = i;
    }
}
