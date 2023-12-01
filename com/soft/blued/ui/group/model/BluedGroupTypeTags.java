package com.soft.blued.ui.group.model;

import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/group/model/BluedGroupTypeTags.class */
public class BluedGroupTypeTags {
    private List<GroupsClassify> classify;
    private GroupsRecommend recommend;

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/group/model/BluedGroupTypeTags$GroupsClassify.class */
    public static class GroupsClassify {
        private List<String> item;
        private String name;
        private int type;

        public List<String> getItem() {
            return this.item;
        }

        public String getName() {
            return this.name;
        }

        public int getType() {
            return this.type;
        }

        public void setItem(List<String> list) {
            this.item = list;
        }

        public void setName(String str) {
            this.name = str;
        }

        public void setType(int i) {
            this.type = i;
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/group/model/BluedGroupTypeTags$GroupsRecommend.class */
    public static class GroupsRecommend extends GroupsClassify {
    }

    public List<GroupsClassify> getClassify() {
        return this.classify;
    }

    public GroupsRecommend getRecommend() {
        return this.recommend;
    }

    public void setClassify(List<GroupsClassify> list) {
        this.classify = list;
    }

    public void setRecommend(GroupsRecommend groupsRecommend) {
        this.recommend = groupsRecommend;
    }
}
