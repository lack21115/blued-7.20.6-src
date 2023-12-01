package com.opos.mobad.d.a;

import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/d/a/d.class */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private static int f12267a = 800;
    private long b = 0;

    /* renamed from: c  reason: collision with root package name */
    private ArrayList<h> f12268c;

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/d/a/d$a.class */
    public enum a {
        INIT_STATUS(0),
        PROGRESS_STATUS(1),
        PAUSED_STATUS(2),
        FAILED_STATUS(3),
        END_STATUS(4);
        
        private int f;

        a(int i) {
            this.f = i;
        }

        public int a() {
            return this.f;
        }
    }

    public d() {
        ArrayList<h> arrayList = new ArrayList<>(5);
        this.f12268c = arrayList;
        arrayList.add(new h(a.INIT_STATUS));
        this.f12268c.add(new h(a.PROGRESS_STATUS));
        this.f12268c.add(new h(a.PAUSED_STATUS));
        this.f12268c.add(new h(a.FAILED_STATUS));
        this.f12268c.add(new h(a.END_STATUS));
    }

    public void a(Runnable runnable, a aVar) {
        String str;
        h hVar = this.f12268c.get(aVar.a());
        if (System.currentTimeMillis() <= this.b + f12267a) {
            if (aVar.a() != a.PROGRESS_STATUS.a()) {
                Iterator<h> it = this.f12268c.iterator();
                while (it.hasNext()) {
                    h next = it.next();
                    if (next.b() >= aVar.a() && next.a()) {
                        str = "is high level running";
                    } else if (next.b() < aVar.a() && next.a()) {
                        com.opos.cmn.an.f.a.b("LevelController", "level cancel = " + aVar.a());
                        next.c();
                        next.d();
                    }
                }
                com.opos.cmn.an.f.a.b("LevelController", "needToPost level = " + aVar.a());
                hVar.a(runnable, (long) f12267a);
                this.b = System.currentTimeMillis() + ((long) f12267a);
                return;
            }
            return;
        }
        hVar.a(runnable);
        this.b = System.currentTimeMillis();
        str = "meet interval and start";
        com.opos.cmn.an.f.a.b("LevelController", str);
    }
}
