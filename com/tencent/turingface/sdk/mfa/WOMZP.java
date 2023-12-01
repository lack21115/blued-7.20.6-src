package com.tencent.turingface.sdk.mfa;

import java.util.LinkedList;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/turingface/sdk/mfa/WOMZP.class */
public final class WOMZP<E> {

    /* renamed from: a  reason: collision with root package name */
    public final int f39926a;
    public final LinkedList<E> b = new LinkedList<>();

    public WOMZP(int i) {
        this.f39926a = i;
    }

    public final void a(E e) {
        if (this.b.size() >= this.f39926a) {
            this.b.poll();
        }
        this.b.offer(e);
    }
}
