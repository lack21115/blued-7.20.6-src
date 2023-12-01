package com.bytedance.bdtracker;

import java.util.HashMap;
import java.util.HashSet;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/c0.class */
public class c0 extends a0 {
    public c0(HashSet<String> hashSet, HashMap<String, HashSet<String>> hashMap) {
        super(hashSet, hashMap);
    }

    @Override // com.bytedance.bdtracker.a0
    public boolean a(String str) {
        return this.f7582a.contains(str);
    }

    @Override // com.bytedance.bdtracker.a0
    public boolean a(HashSet<String> hashSet, String str) {
        return hashSet.contains(str);
    }
}
