package com.tencent.turingface.sdk.mfa;

import java.util.LinkedList;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/turingface/sdk/mfa/WOMZP.class */
public final class WOMZP<E> {

    /* renamed from: a  reason: collision with root package name */
    public final int f26235a;
    public final LinkedList<E> b = new LinkedList<>();

    public WOMZP(int i) {
        this.f26235a = i;
    }

    public final void a(E e) {
        if (this.b.size() >= this.f26235a) {
            this.b.poll();
        }
        this.b.offer(e);
    }
}
