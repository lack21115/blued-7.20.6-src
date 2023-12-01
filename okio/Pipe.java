package okio;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:okio/Pipe.class */
public final class Pipe {
    private final Buffer buffer = new Buffer();
    private boolean canceled;
    private Sink foldedSink;
    private final long maxBufferSize;
    private final Sink sink;
    private boolean sinkClosed;
    private final Source source;
    private boolean sourceClosed;

    public Pipe(long j) {
        this.maxBufferSize = j;
        if (!(this.maxBufferSize >= 1)) {
            throw new IllegalArgumentException(Intrinsics.a("maxBufferSize < 1: ", (Object) Long.valueOf(getMaxBufferSize$okio())).toString());
        }
        this.sink = new Sink() { // from class: okio.Pipe$sink$1
            private final Timeout timeout = new Timeout();

            @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                boolean hasDeadline;
                Buffer buffer$okio = Pipe.this.getBuffer$okio();
                Pipe pipe = Pipe.this;
                synchronized (buffer$okio) {
                    if (pipe.getSinkClosed$okio()) {
                        return;
                    }
                    Sink foldedSink$okio = pipe.getFoldedSink$okio();
                    Sink sink = foldedSink$okio;
                    if (foldedSink$okio == null) {
                        if (pipe.getSourceClosed$okio() && pipe.getBuffer$okio().size() > 0) {
                            throw new IOException("source is closed");
                        }
                        pipe.setSinkClosed$okio(true);
                        pipe.getBuffer$okio().notifyAll();
                        sink = null;
                    }
                    Unit unit = Unit.f42314a;
                    if (sink == null) {
                        return;
                    }
                    Pipe pipe2 = Pipe.this;
                    Timeout timeout = sink.timeout();
                    Timeout timeout2 = pipe2.sink().timeout();
                    long timeoutNanos = timeout.timeoutNanos();
                    timeout.timeout(Timeout.Companion.minTimeout(timeout2.timeoutNanos(), timeout.timeoutNanos()), TimeUnit.NANOSECONDS);
                    if (!timeout.hasDeadline()) {
                        if (timeout2.hasDeadline()) {
                            timeout.deadlineNanoTime(timeout2.deadlineNanoTime());
                        }
                        try {
                            sink.close();
                            Unit unit2 = Unit.f42314a;
                            if (hasDeadline) {
                                return;
                            }
                            return;
                        } finally {
                            timeout.timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                            if (timeout2.hasDeadline()) {
                                timeout.clearDeadline();
                            }
                        }
                    }
                    long deadlineNanoTime = timeout.deadlineNanoTime();
                    if (timeout2.hasDeadline()) {
                        timeout.deadlineNanoTime(Math.min(timeout.deadlineNanoTime(), timeout2.deadlineNanoTime()));
                    }
                    try {
                        sink.close();
                        Unit unit3 = Unit.f42314a;
                    } finally {
                        timeout.timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                        if (timeout2.hasDeadline()) {
                            timeout.deadlineNanoTime(deadlineNanoTime);
                        }
                    }
                }
            }

            @Override // okio.Sink, java.io.Flushable
            public void flush() {
                Sink sink;
                boolean hasDeadline;
                Buffer buffer$okio = Pipe.this.getBuffer$okio();
                Pipe pipe = Pipe.this;
                synchronized (buffer$okio) {
                    if (!(!pipe.getSinkClosed$okio())) {
                        throw new IllegalStateException("closed".toString());
                    }
                    if (pipe.getCanceled$okio()) {
                        throw new IOException("canceled");
                    }
                    Sink foldedSink$okio = pipe.getFoldedSink$okio();
                    sink = foldedSink$okio;
                    if (foldedSink$okio == null) {
                        if (pipe.getSourceClosed$okio() && pipe.getBuffer$okio().size() > 0) {
                            throw new IOException("source is closed");
                        }
                        sink = null;
                    }
                    Unit unit = Unit.f42314a;
                }
                if (sink == null) {
                    return;
                }
                Pipe pipe2 = Pipe.this;
                Timeout timeout = sink.timeout();
                Timeout timeout2 = pipe2.sink().timeout();
                long timeoutNanos = timeout.timeoutNanos();
                timeout.timeout(Timeout.Companion.minTimeout(timeout2.timeoutNanos(), timeout.timeoutNanos()), TimeUnit.NANOSECONDS);
                if (!timeout.hasDeadline()) {
                    if (timeout2.hasDeadline()) {
                        timeout.deadlineNanoTime(timeout2.deadlineNanoTime());
                    }
                    try {
                        sink.flush();
                        Unit unit2 = Unit.f42314a;
                        if (hasDeadline) {
                            return;
                        }
                        return;
                    } finally {
                        timeout.timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                        if (timeout2.hasDeadline()) {
                            timeout.clearDeadline();
                        }
                    }
                }
                long deadlineNanoTime = timeout.deadlineNanoTime();
                if (timeout2.hasDeadline()) {
                    timeout.deadlineNanoTime(Math.min(timeout.deadlineNanoTime(), timeout2.deadlineNanoTime()));
                }
                try {
                    sink.flush();
                    Unit unit3 = Unit.f42314a;
                } finally {
                    timeout.timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                    if (timeout2.hasDeadline()) {
                        timeout.deadlineNanoTime(deadlineNanoTime);
                    }
                }
            }

            @Override // okio.Sink
            public Timeout timeout() {
                return this.timeout;
            }

            @Override // okio.Sink
            public void write(Buffer source, long j2) {
                Sink sink;
                boolean hasDeadline;
                Intrinsics.e(source, "source");
                Buffer buffer$okio = Pipe.this.getBuffer$okio();
                Pipe pipe = Pipe.this;
                synchronized (buffer$okio) {
                    if (!(!pipe.getSinkClosed$okio())) {
                        throw new IllegalStateException("closed".toString());
                    }
                    if (pipe.getCanceled$okio()) {
                        throw new IOException("canceled");
                    }
                    while (true) {
                        if (j2 <= 0) {
                            sink = null;
                            break;
                        }
                        Sink foldedSink$okio = pipe.getFoldedSink$okio();
                        sink = foldedSink$okio;
                        if (foldedSink$okio != null) {
                            break;
                        } else if (pipe.getSourceClosed$okio()) {
                            throw new IOException("source is closed");
                        } else {
                            long maxBufferSize$okio = pipe.getMaxBufferSize$okio() - pipe.getBuffer$okio().size();
                            if (maxBufferSize$okio == 0) {
                                this.timeout.waitUntilNotified(pipe.getBuffer$okio());
                                if (pipe.getCanceled$okio()) {
                                    throw new IOException("canceled");
                                }
                            } else {
                                long min = Math.min(maxBufferSize$okio, j2);
                                pipe.getBuffer$okio().write(source, min);
                                j2 -= min;
                                pipe.getBuffer$okio().notifyAll();
                            }
                        }
                    }
                    Unit unit = Unit.f42314a;
                }
                if (sink == null) {
                    return;
                }
                Pipe pipe2 = Pipe.this;
                Timeout timeout = sink.timeout();
                Timeout timeout2 = pipe2.sink().timeout();
                long timeoutNanos = timeout.timeoutNanos();
                timeout.timeout(Timeout.Companion.minTimeout(timeout2.timeoutNanos(), timeout.timeoutNanos()), TimeUnit.NANOSECONDS);
                if (!timeout.hasDeadline()) {
                    if (timeout2.hasDeadline()) {
                        timeout.deadlineNanoTime(timeout2.deadlineNanoTime());
                    }
                    try {
                        sink.write(source, j2);
                        Unit unit2 = Unit.f42314a;
                        if (hasDeadline) {
                            return;
                        }
                        return;
                    } finally {
                        timeout.timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                        if (timeout2.hasDeadline()) {
                            timeout.clearDeadline();
                        }
                    }
                }
                long deadlineNanoTime = timeout.deadlineNanoTime();
                if (timeout2.hasDeadline()) {
                    timeout.deadlineNanoTime(Math.min(timeout.deadlineNanoTime(), timeout2.deadlineNanoTime()));
                }
                try {
                    sink.write(source, j2);
                    Unit unit3 = Unit.f42314a;
                } finally {
                    timeout.timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                    if (timeout2.hasDeadline()) {
                        timeout.deadlineNanoTime(deadlineNanoTime);
                    }
                }
            }
        };
        this.source = new Source() { // from class: okio.Pipe$source$1
            private final Timeout timeout = new Timeout();

            @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                Buffer buffer$okio = Pipe.this.getBuffer$okio();
                Pipe pipe = Pipe.this;
                synchronized (buffer$okio) {
                    pipe.setSourceClosed$okio(true);
                    pipe.getBuffer$okio().notifyAll();
                    Unit unit = Unit.f42314a;
                }
            }

            @Override // okio.Source
            public long read(Buffer sink, long j2) {
                Intrinsics.e(sink, "sink");
                Buffer buffer$okio = Pipe.this.getBuffer$okio();
                Pipe pipe = Pipe.this;
                synchronized (buffer$okio) {
                    if (!pipe.getSourceClosed$okio()) {
                        if (pipe.getCanceled$okio()) {
                            throw new IOException("canceled");
                        }
                        while (pipe.getBuffer$okio().size() == 0) {
                            if (pipe.getSinkClosed$okio()) {
                                return -1L;
                            }
                            this.timeout.waitUntilNotified(pipe.getBuffer$okio());
                            if (pipe.getCanceled$okio()) {
                                throw new IOException("canceled");
                            }
                        }
                        long read = pipe.getBuffer$okio().read(sink, j2);
                        pipe.getBuffer$okio().notifyAll();
                        return read;
                    }
                    throw new IllegalStateException("closed".toString());
                }
            }

            @Override // okio.Source
            public Timeout timeout() {
                return this.timeout;
            }
        };
    }

    private final void forward(Sink sink, Function1<? super Sink, Unit> function1) {
        Timeout timeout = sink.timeout();
        Timeout timeout2 = sink().timeout();
        long timeoutNanos = timeout.timeoutNanos();
        timeout.timeout(Timeout.Companion.minTimeout(timeout2.timeoutNanos(), timeout.timeoutNanos()), TimeUnit.NANOSECONDS);
        if (!timeout.hasDeadline()) {
            if (timeout2.hasDeadline()) {
                timeout.deadlineNanoTime(timeout2.deadlineNanoTime());
            }
            try {
                function1.invoke(sink);
                Unit unit = Unit.f42314a;
                InlineMarker.b(1);
                timeout.timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                if (timeout2.hasDeadline()) {
                    timeout.clearDeadline();
                }
                InlineMarker.c(1);
                return;
            } catch (Throwable th) {
                InlineMarker.b(1);
                timeout.timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                if (timeout2.hasDeadline()) {
                    timeout.clearDeadline();
                }
                InlineMarker.c(1);
                throw th;
            }
        }
        long deadlineNanoTime = timeout.deadlineNanoTime();
        if (timeout2.hasDeadline()) {
            timeout.deadlineNanoTime(Math.min(timeout.deadlineNanoTime(), timeout2.deadlineNanoTime()));
        }
        try {
            function1.invoke(sink);
            Unit unit2 = Unit.f42314a;
            InlineMarker.b(1);
            timeout.timeout(timeoutNanos, TimeUnit.NANOSECONDS);
            if (timeout2.hasDeadline()) {
                timeout.deadlineNanoTime(deadlineNanoTime);
            }
            InlineMarker.c(1);
        } catch (Throwable th2) {
            InlineMarker.b(1);
            timeout.timeout(timeoutNanos, TimeUnit.NANOSECONDS);
            if (timeout2.hasDeadline()) {
                timeout.deadlineNanoTime(deadlineNanoTime);
            }
            InlineMarker.c(1);
            throw th2;
        }
    }

    @Deprecated
    /* renamed from: -deprecated_sink  reason: not valid java name */
    public final Sink m13302deprecated_sink() {
        return this.sink;
    }

    @Deprecated
    /* renamed from: -deprecated_source  reason: not valid java name */
    public final Source m13303deprecated_source() {
        return this.source;
    }

    public final void cancel() {
        synchronized (this.buffer) {
            setCanceled$okio(true);
            getBuffer$okio().clear();
            getBuffer$okio().notifyAll();
            Unit unit = Unit.f42314a;
        }
    }

    public final void fold(Sink sink) throws IOException {
        boolean sinkClosed$okio;
        Buffer buffer;
        Intrinsics.e(sink, "sink");
        while (true) {
            synchronized (this.buffer) {
                if (!(getFoldedSink$okio() == null)) {
                    throw new IllegalStateException("sink already folded".toString());
                }
                if (getCanceled$okio()) {
                    setFoldedSink$okio(sink);
                    throw new IOException("canceled");
                } else if (getBuffer$okio().exhausted()) {
                    setSourceClosed$okio(true);
                    setFoldedSink$okio(sink);
                    return;
                } else {
                    sinkClosed$okio = getSinkClosed$okio();
                    buffer = new Buffer();
                    buffer.write(getBuffer$okio(), getBuffer$okio().size());
                    getBuffer$okio().notifyAll();
                    Unit unit = Unit.f42314a;
                }
            }
            try {
                sink.write(buffer, buffer.size());
                if (sinkClosed$okio) {
                    sink.close();
                } else {
                    sink.flush();
                }
            } catch (Throwable th) {
                synchronized (this.buffer) {
                    setSourceClosed$okio(true);
                    getBuffer$okio().notifyAll();
                    Unit unit2 = Unit.f42314a;
                    throw th;
                }
            }
        }
    }

    public final Buffer getBuffer$okio() {
        return this.buffer;
    }

    public final boolean getCanceled$okio() {
        return this.canceled;
    }

    public final Sink getFoldedSink$okio() {
        return this.foldedSink;
    }

    public final long getMaxBufferSize$okio() {
        return this.maxBufferSize;
    }

    public final boolean getSinkClosed$okio() {
        return this.sinkClosed;
    }

    public final boolean getSourceClosed$okio() {
        return this.sourceClosed;
    }

    public final void setCanceled$okio(boolean z) {
        this.canceled = z;
    }

    public final void setFoldedSink$okio(Sink sink) {
        this.foldedSink = sink;
    }

    public final void setSinkClosed$okio(boolean z) {
        this.sinkClosed = z;
    }

    public final void setSourceClosed$okio(boolean z) {
        this.sourceClosed = z;
    }

    public final Sink sink() {
        return this.sink;
    }

    public final Source source() {
        return this.source;
    }
}
