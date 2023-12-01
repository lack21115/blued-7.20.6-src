package com.bytedance.bdtracker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/h0.class */
public class h0 {

    /* renamed from: a  reason: collision with root package name */
    public final LinkedList<t1> f21225a = new LinkedList<>();
    public final LinkedList<String> b = new LinkedList<>();

    public int a(ArrayList<t1> arrayList) {
        int size;
        synchronized (this.f21225a) {
            size = this.f21225a.size();
            arrayList.addAll(this.f21225a);
            this.f21225a.clear();
        }
        return size;
    }

    public void a(t1 t1Var) {
        synchronized (this.f21225a) {
            if (this.f21225a.size() > 300) {
                this.f21225a.poll();
            }
            this.f21225a.add(t1Var);
        }
    }

    public void a(String[] strArr) {
        synchronized (this.b) {
            if (this.b.size() > 300) {
                this.b.poll();
            }
            this.b.addAll(Arrays.asList(strArr));
        }
    }
}
