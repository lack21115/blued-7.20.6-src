package com.zx.a.I8b7;

import java.util.Comparator;

/* loaded from: source-8829756-dex2jar.jar:com/zx/a/I8b7/m1.class */
public class m1 implements Comparator<String> {
    @Override // java.util.Comparator
    public int compare(String str, String str2) {
        return str.compareTo(str2) > 0 ? 1 : -1;
    }
}
