package com.opos.exoplayer.core.e;

import android.os.Handler;
import com.opos.exoplayer.core.Format;
import java.io.IOException;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/e/f.class */
public interface f {

    /* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/e/f$a.class */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final Handler f25288a;
        private final f b;

        /* renamed from: c  reason: collision with root package name */
        private final long f25289c;

        public a(Handler handler, f fVar) {
            this(handler, fVar, 0L);
        }

        public a(Handler handler, f fVar, long j) {
            this.f25288a = fVar != null ? (Handler) com.opos.exoplayer.core.i.a.a(handler) : null;
            this.b = fVar;
            this.f25289c = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public long a(long j) {
            long a2 = com.opos.exoplayer.core.b.a(j);
            return a2 == com.anythink.expressad.exoplayer.b.b ? com.anythink.expressad.exoplayer.b.b : this.f25289c + a2;
        }

        public void a(final int i, final Format format, final int i2, final Object obj, final long j) {
            Handler handler;
            if (this.b == null || (handler = this.f25288a) == null) {
                return;
            }
            handler.post(new Runnable() { // from class: com.opos.exoplayer.core.e.f.a.5
                @Override // java.lang.Runnable
                public void run() {
                    a.this.b.a(i, format, i2, obj, a.this.a(j));
                }
            });
        }

        public void a(final com.opos.exoplayer.core.h.i iVar, final int i, final int i2, final Format format, final int i3, final Object obj, final long j, final long j2, final long j3) {
            Handler handler;
            if (this.b == null || (handler = this.f25288a) == null) {
                return;
            }
            handler.post(new Runnable() { // from class: com.opos.exoplayer.core.e.f.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.b.a(iVar, i, i2, format, i3, obj, a.this.a(j), a.this.a(j2), j3);
                }
            });
        }

        public void a(final com.opos.exoplayer.core.h.i iVar, final int i, final int i2, final Format format, final int i3, final Object obj, final long j, final long j2, final long j3, final long j4, final long j5) {
            Handler handler;
            if (this.b == null || (handler = this.f25288a) == null) {
                return;
            }
            handler.post(new Runnable() { // from class: com.opos.exoplayer.core.e.f.a.2
                @Override // java.lang.Runnable
                public void run() {
                    a.this.b.a(iVar, i, i2, format, i3, obj, a.this.a(j), a.this.a(j2), j3, j4, j5);
                }
            });
        }

        public void a(final com.opos.exoplayer.core.h.i iVar, final int i, final int i2, final Format format, final int i3, final Object obj, final long j, final long j2, final long j3, final long j4, final long j5, final IOException iOException, final boolean z) {
            Handler handler;
            if (this.b == null || (handler = this.f25288a) == null) {
                return;
            }
            handler.post(new Runnable() { // from class: com.opos.exoplayer.core.e.f.a.4
                @Override // java.lang.Runnable
                public void run() {
                    a.this.b.a(iVar, i, i2, format, i3, obj, a.this.a(j), a.this.a(j2), j3, j4, j5, iOException, z);
                }
            });
        }

        public void b(final com.opos.exoplayer.core.h.i iVar, final int i, final int i2, final Format format, final int i3, final Object obj, final long j, final long j2, final long j3, final long j4, final long j5) {
            Handler handler;
            if (this.b == null || (handler = this.f25288a) == null) {
                return;
            }
            handler.post(new Runnable() { // from class: com.opos.exoplayer.core.e.f.a.3
                @Override // java.lang.Runnable
                public void run() {
                    a.this.b.b(iVar, i, i2, format, i3, obj, a.this.a(j), a.this.a(j2), j3, j4, j5);
                }
            });
        }
    }

    void a(int i, Format format, int i2, Object obj, long j);

    void a(com.opos.exoplayer.core.h.i iVar, int i, int i2, Format format, int i3, Object obj, long j, long j2, long j3);

    void a(com.opos.exoplayer.core.h.i iVar, int i, int i2, Format format, int i3, Object obj, long j, long j2, long j3, long j4, long j5);

    void a(com.opos.exoplayer.core.h.i iVar, int i, int i2, Format format, int i3, Object obj, long j, long j2, long j3, long j4, long j5, IOException iOException, boolean z);

    void b(com.opos.exoplayer.core.h.i iVar, int i, int i2, Format format, int i3, Object obj, long j, long j2, long j3, long j4, long j5);
}
