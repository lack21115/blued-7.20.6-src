package com.soft.blued.ui.find.model;

import java.util.List;
import kotlin.Metadata;

@Metadata
/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/model/RecommendPopModel.class */
public final class RecommendPopModel {
    private int age;
    private String description;
    private List<String> feed_pics;
    private int height;
    private float match;
    private long uid;
    private int weight;
    private String name = "";
    private String avatar = "";
    private String role = "";
    private boolean sayHelloEnable = true;

    public final int getAge() {
        return this.age;
    }

    public final String getAvatar() {
        return this.avatar;
    }

    public final String getDescription() {
        return this.description;
    }

    public final List<String> getFeed_pics() {
        return this.feed_pics;
    }

    public final int getHeight() {
        return this.height;
    }

    public final float getMatch() {
        return this.match;
    }

    public final String getName() {
        return this.name;
    }

    public final String getRole() {
        return this.role;
    }

    public final boolean getSayHelloEnable() {
        return this.sayHelloEnable;
    }

    public final long getUid() {
        return this.uid;
    }

    public final int getWeight() {
        return this.weight;
    }

    public final void setAge(int i) {
        this.age = i;
    }

    public final void setAvatar(String str) {
        this.avatar = str;
    }

    public final void setDescription(String str) {
        this.description = str;
    }

    public final void setFeed_pics(List<String> list) {
        this.feed_pics = list;
    }

    public final void setHeight(int i) {
        this.height = i;
    }

    public final void setMatch(float f) {
        this.match = f;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final void setRole(String str) {
        this.role = str;
    }

    public final void setSayHelloEnable(boolean z) {
        this.sayHelloEnable = z;
    }

    public final void setUid(long j) {
        this.uid = j;
    }

    public final void setWeight(int i) {
        this.weight = i;
    }
}
