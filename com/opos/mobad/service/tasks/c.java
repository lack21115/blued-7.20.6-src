package com.opos.mobad.service.tasks;

import android.content.Context;
import com.omes.scorpion.OmasStub;
import com.opos.cmn.i.m;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/service/tasks/c.class */
public class c {
    private Context b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f13736c = false;
    private int d = 0;
    private b e = new b();

    /* renamed from: a  reason: collision with root package name */
    private m f13735a = new m(com.opos.mobad.service.c.a(), new Runnable() { // from class: com.opos.mobad.service.tasks.c.1

        /* renamed from: com.opos.mobad.service.tasks.c$1$1  reason: invalid class name and collision with other inner class name */
        /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/service/tasks/c$1$1.class */
        class RunnableC05681 implements Runnable {
            RunnableC05681() {
            }

            @Override // java.lang.Runnable
            public void run() {
                OmasStub.omasVoid(23, new Object[]{this});
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            OmasStub.omasVoid(22, new Object[]{this});
        }
    });

    static /* synthetic */ Context a(c cVar) {
        return (Context) OmasStub.omasObject(29, new Object[]{cVar});
    }

    static /* synthetic */ b d(c cVar) {
        return (b) OmasStub.omasObject(32, new Object[]{cVar});
    }

    static /* synthetic */ m e(c cVar) {
        return (m) OmasStub.omasObject(33, new Object[]{cVar});
    }

    public void a() {
        OmasStub.omasVoid(34, new Object[]{this});
    }

    public void a(Context context, boolean z, int i) {
        OmasStub.omasVoid(35, new Object[]{this, context, Boolean.valueOf(z), Integer.valueOf(i)});
    }
}
