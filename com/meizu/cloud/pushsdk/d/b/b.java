package com.meizu.cloud.pushsdk.d.b;

/* loaded from: source-8110460-dex2jar.jar:com/meizu/cloud/pushsdk/d/b/b.class */
public enum b {
    Single(1),
    DefaultGroup(3),
    HeavyGroup(25);
    
    private final int d;

    b(int i) {
        this.d = i;
    }

    public int a() {
        return this.d;
    }
}
