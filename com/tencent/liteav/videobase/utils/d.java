package com.tencent.liteav.videobase.utils;

import java.util.LinkedList;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videobase/utils/d.class */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    private final LinkedList<Runnable> f22964a = new LinkedList<>();

    public final void a() {
        LinkedList linkedList;
        synchronized (this.f22964a) {
            if (this.f22964a.isEmpty()) {
                linkedList = null;
            } else {
                linkedList = new LinkedList(this.f22964a);
                this.f22964a.clear();
            }
        }
        while (linkedList != null && !linkedList.isEmpty()) {
            ((Runnable) linkedList.removeFirst()).run();
        }
    }

    public final void a(Runnable runnable) {
        synchronized (this.f22964a) {
            this.f22964a.add(runnable);
        }
    }
}
