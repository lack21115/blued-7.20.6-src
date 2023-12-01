package com.alipay.sdk.widget;

import java.util.Iterator;
import java.util.Stack;

/* loaded from: source-6737240-dex2jar.jar:com/alipay/sdk/widget/u.class */
public class u {

    /* renamed from: a  reason: collision with root package name */
    private Stack<p> f4701a = new Stack<>();

    public p a() {
        return this.f4701a.pop();
    }

    public void a(p pVar) {
        this.f4701a.push(pVar);
    }

    public boolean b() {
        return this.f4701a.isEmpty();
    }

    public void c() {
        if (b()) {
            return;
        }
        Iterator<p> it = this.f4701a.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
        this.f4701a.clear();
    }
}
