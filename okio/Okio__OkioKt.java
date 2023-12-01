package okio;

import java.io.Closeable;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata
/* loaded from: source-3503164-dex2jar.jar:okio/Okio__OkioKt.class */
public final /* synthetic */ class Okio__OkioKt {
    public static final Sink blackhole() {
        return new BlackholeSink();
    }

    public static final BufferedSink buffer(Sink sink) {
        Intrinsics.e(sink, "<this>");
        return new RealBufferedSink(sink);
    }

    public static final BufferedSource buffer(Source source) {
        Intrinsics.e(source, "<this>");
        return new RealBufferedSource(source);
    }

    public static final <T extends Closeable, R> R use(T t, Function1<? super T, ? extends R> block) {
        R r;
        Intrinsics.e(block, "block");
        try {
            R invoke = block.invoke(t);
            th = null;
            r = invoke;
        } catch (Throwable th) {
            th = th;
            r = null;
        }
        if (t == null) {
            th = th;
        } else {
            try {
                t.close();
                th = th;
            } catch (Throwable th2) {
                th = th2;
                if (th != null) {
                    ExceptionsKt.a(th, th);
                    th = th;
                }
            }
        }
        if (th == null) {
            Intrinsics.a(r);
            return r;
        }
        throw th;
    }
}
