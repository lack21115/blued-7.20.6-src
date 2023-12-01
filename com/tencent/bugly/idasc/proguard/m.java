package com.tencent.bugly.idasc.proguard;

import java.io.Serializable;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/bugly/idasc/proguard/m.class */
public abstract class m implements Serializable {
    public abstract void a(k kVar);

    public abstract void a(l lVar);

    public abstract void a(StringBuilder sb, int i);

    public String toString() {
        StringBuilder sb = new StringBuilder();
        a(sb, 0);
        return sb.toString();
    }
}
