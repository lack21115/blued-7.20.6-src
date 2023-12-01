package com.tencent.liteav.videobase.utils;

import java.util.LinkedList;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videobase/utils/d.class */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    private final LinkedList<Runnable> f36655a = new LinkedList<>();

    public final void a() {
        LinkedList linkedList;
        synchronized (this.f36655a) {
            if (this.f36655a.isEmpty()) {
                linkedList = null;
            } else {
                linkedList = new LinkedList(this.f36655a);
                this.f36655a.clear();
            }
        }
        while (linkedList != null && !linkedList.isEmpty()) {
            ((Runnable) linkedList.removeFirst()).run();
        }
    }

    public final void a(Runnable runnable) {
        synchronized (this.f36655a) {
            this.f36655a.add(runnable);
        }
    }
}
