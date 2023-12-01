package com.zx.a.I8b7;

import com.zx.module.base.Listener;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* loaded from: source-8829756-dex2jar.jar:com/zx/a/I8b7/o0.class */
public class o0 implements Listener {

    /* renamed from: a  reason: collision with root package name */
    public final Map<String, Set<p0>> f42154a = new HashMap();

    public void a(String str, p0 p0Var) {
        synchronized (this) {
            if (!this.f42154a.containsKey(str)) {
                this.f42154a.put(str, new HashSet());
            }
            this.f42154a.get(str).add(p0Var);
        }
    }

    @Override // com.zx.module.base.Listener
    public void onMessage(String str, String str2) {
        Set<p0> set = this.f42154a.get(str);
        if (set != null) {
            for (p0 p0Var : set) {
                p0Var.a(str2);
            }
        }
    }
}
