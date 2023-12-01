package com.anythink.core.common;

import android.content.Context;
import android.os.CountDownTimer;
import com.anythink.core.common.e.q;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/o.class */
public abstract class o<T extends com.anythink.core.common.e.q> {
    protected CountDownTimer c;
    public Context e;
    final String a = getClass().getSimpleName();
    ArrayList<T> b = new ArrayList<>();
    String d = com.anythink.core.common.b.n.a().p();

    public o(Context context) {
        this.e = context.getApplicationContext();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        synchronized (this) {
            if (z) {
                List<T> arrayList = new ArrayList<>();
                arrayList.addAll(this.b);
                if (arrayList.size() > 0) {
                    a(arrayList);
                }
                this.b.clear();
            } else {
                com.anythink.core.c.a b = com.anythink.core.c.b.a(this.e).b(this.d);
                List<T> arrayList2 = new ArrayList<>();
                if (this.b.size() >= b.Y()) {
                    int Y = b.Y();
                    while (true) {
                        int i = Y - 1;
                        if (i < 0) {
                            break;
                        }
                        arrayList2.add(this.b.get(i));
                        this.b.remove(i);
                        Y = i;
                    }
                    if (arrayList2.size() > 0) {
                        a(arrayList2);
                    }
                }
            }
            com.anythink.core.common.b.n.a().a(new Runnable() { // from class: com.anythink.core.common.o.2
                @Override // java.lang.Runnable
                public final void run() {
                    if (!o.this.b.isEmpty() || o.this.c == null) {
                        return;
                    }
                    o.this.c.cancel();
                }
            });
        }
    }

    public final void a(T t, boolean z) {
        boolean z2;
        synchronized (this) {
            if (z) {
                this.b.add(t);
                a(true);
                return;
            }
            final com.anythink.core.c.a b = com.anythink.core.c.b.a(this.e).b(this.d);
            if (this.b.isEmpty()) {
                z2 = true;
                if (b.aa() > 0) {
                    com.anythink.core.common.b.n.a().a(new Runnable() { // from class: com.anythink.core.common.o.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            o.this.c = new CountDownTimer(b.aa(), b.aa()) { // from class: com.anythink.core.common.o.1.1
                                @Override // android.os.CountDownTimer
                                public final void onFinish() {
                                    o.this.a(true);
                                }

                                @Override // android.os.CountDownTimer
                                public final void onTick(long j) {
                                }
                            };
                            o.this.c.start();
                        }
                    });
                }
                this.b.add(t);
                a(z2);
            }
            z2 = false;
            this.b.add(t);
            a(z2);
        }
    }

    protected abstract void a(List<T> list);
}
