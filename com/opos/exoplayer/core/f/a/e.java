package com.opos.exoplayer.core.f.a;

import com.opos.exoplayer.core.f.h;
import com.opos.exoplayer.core.f.i;
import java.util.LinkedList;
import java.util.PriorityQueue;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/f/a/e.class */
public abstract class e implements com.opos.exoplayer.core.f.e {

    /* renamed from: a  reason: collision with root package name */
    private final LinkedList<a> f25340a = new LinkedList<>();
    private final LinkedList<i> b;

    /* renamed from: c  reason: collision with root package name */
    private final PriorityQueue<a> f25341c;
    private a d;
    private long e;
    private long f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/f/a/e$a.class */
    public static final class a extends h implements Comparable<a> {
        private long e;

        private a() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:5:0x0017, code lost:
            if (c() != false) goto L8;
         */
        @Override // java.lang.Comparable
        /* renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public int compareTo(com.opos.exoplayer.core.f.a.e.a r6) {
            /*
                r5 = this;
                r0 = r5
                boolean r0 = r0.c()
                r8 = r0
                r0 = r6
                boolean r0 = r0.c()
                r9 = r0
                r0 = -1
                r7 = r0
                r0 = r8
                r1 = r9
                if (r0 == r1) goto L1d
                r0 = r5
                boolean r0 = r0.c()
                if (r0 == 0) goto L56
                goto L54
            L1d:
                r0 = r5
                long r0 = r0.f25074c
                r1 = r6
                long r1 = r1.f25074c
                long r0 = r0 - r1
                r12 = r0
                r0 = r12
                r10 = r0
                r0 = r12
                r1 = 0
                int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
                if (r0 != 0) goto L4b
                r0 = r5
                long r0 = r0.e
                r1 = r6
                long r1 = r1.e
                long r0 = r0 - r1
                r12 = r0
                r0 = r12
                r10 = r0
                r0 = r12
                r1 = 0
                int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
                if (r0 != 0) goto L4b
                r0 = 0
                return r0
            L4b:
                r0 = r10
                r1 = 0
                int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
                if (r0 > 0) goto L54
                r0 = -1
                return r0
            L54:
                r0 = 1
                r7 = r0
            L56:
                r0 = r7
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.opos.exoplayer.core.f.a.e.a.compareTo(com.opos.exoplayer.core.f.a.e$a):int");
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/f/a/e$b.class */
    final class b extends i {
        private b() {
        }

        @Override // com.opos.exoplayer.core.f.i
        public final void e() {
            e.this.a((i) this);
        }
    }

    public e() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 10) {
                break;
            }
            this.f25340a.add(new a());
            i = i2 + 1;
        }
        this.b = new LinkedList<>();
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= 2) {
                this.f25341c = new PriorityQueue<>();
                return;
            } else {
                this.b.add(new b());
                i3 = i4 + 1;
            }
        }
    }

    private void a(a aVar) {
        aVar.a();
        this.f25340a.add(aVar);
    }

    @Override // com.opos.exoplayer.core.f.e
    public void a(long j) {
        this.e = j;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    protected abstract void a(h hVar);

    protected void a(i iVar) {
        iVar.a();
        this.b.add(iVar);
    }

    @Override // com.opos.exoplayer.core.b.c
    /* renamed from: b */
    public void a(h hVar) {
        com.opos.exoplayer.core.i.a.a(hVar == this.d);
        if (hVar.d_()) {
            a(this.d);
        } else {
            a aVar = this.d;
            long j = this.f;
            this.f = 1 + j;
            aVar.e = j;
            this.f25341c.add(this.d);
        }
        this.d = null;
    }

    @Override // com.opos.exoplayer.core.b.c
    public void c() {
        this.f = 0L;
        this.e = 0L;
        while (!this.f25341c.isEmpty()) {
            a(this.f25341c.poll());
        }
        a aVar = this.d;
        if (aVar != null) {
            a(aVar);
            this.d = null;
        }
    }

    @Override // com.opos.exoplayer.core.b.c
    public void d() {
    }

    protected abstract boolean e();

    protected abstract com.opos.exoplayer.core.f.d f();

    @Override // com.opos.exoplayer.core.b.c
    /* renamed from: g */
    public i b() {
        i pollFirst;
        if (this.b.isEmpty()) {
            return null;
        }
        while (!this.f25341c.isEmpty() && this.f25341c.peek().f25074c <= this.e) {
            a poll = this.f25341c.poll();
            if (poll.c()) {
                pollFirst = this.b.pollFirst();
                pollFirst.b(4);
            } else {
                a((h) poll);
                if (e()) {
                    com.opos.exoplayer.core.f.d f = f();
                    if (!poll.d_()) {
                        pollFirst = this.b.pollFirst();
                        pollFirst.a(poll.f25074c, f, Long.MAX_VALUE);
                    }
                }
                a(poll);
            }
            a(poll);
            return pollFirst;
        }
        return null;
    }

    @Override // com.opos.exoplayer.core.b.c
    /* renamed from: h */
    public h a() {
        com.opos.exoplayer.core.i.a.b(this.d == null);
        if (this.f25340a.isEmpty()) {
            return null;
        }
        a pollFirst = this.f25340a.pollFirst();
        this.d = pollFirst;
        return pollFirst;
    }
}
