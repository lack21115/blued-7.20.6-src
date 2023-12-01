package com.blued.android.sdk.model;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/sdk/model/UserModel.class */
public class UserModel {
    public int age;
    public String avatar;
    public String city_settled;
    public String height;
    public String name;
    public int relationship = 0;
    public String uid;
    public int weight;

    public String toString() {
        return "[uid:" + this.uid + ", avatar:" + this.avatar + ", name:" + this.name + ", age:" + this.age + ", height:" + this.height + ", weight:" + this.weight + ", city_settled:" + this.city_settled + ", relationship:" + this.relationship + "]";
    }
}
