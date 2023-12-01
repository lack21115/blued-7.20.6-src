package com.meizu.cloud.pushsdk.d.b;

import com.meizu.cloud.pushsdk.c.c.i;
import java.util.LinkedList;

/* loaded from: source-8110460-dex2jar.jar:com/meizu/cloud/pushsdk/d/b/e.class */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f24096a;
    private final i b;

    /* renamed from: c  reason: collision with root package name */
    private final LinkedList<Long> f24097c;

    public e(boolean z, i iVar, LinkedList<Long> linkedList) {
        this.f24096a = z;
        this.b = iVar;
        this.f24097c = linkedList;
    }

    public i a() {
        return this.b;
    }

    public LinkedList<Long> b() {
        return this.f24097c;
    }

    public boolean c() {
        return this.f24096a;
    }
}
