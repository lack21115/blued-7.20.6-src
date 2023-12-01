package com.alipay.sdk.widget;

import java.util.Iterator;
import java.util.Stack;

/* loaded from: source-6737240-dex2jar.jar:com/alipay/sdk/widget/u.class */
public class u {
    private Stack<p> a = new Stack<>();

    public p a() {
        return this.a.pop();
    }

    public void a(p pVar) {
        this.a.push(pVar);
    }

    public boolean b() {
        return this.a.isEmpty();
    }

    public void c() {
        if (b()) {
            return;
        }
        Iterator<p> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
        this.a.clear();
    }
}
