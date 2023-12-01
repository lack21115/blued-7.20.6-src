package com.opos.cmn.an.j.b;

import java.util.concurrent.Executor;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/an/j/b/b.class */
public final class b implements Executor {
    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        runnable.run();
    }
}
