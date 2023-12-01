package okio;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.file.OpenOption;
import java.util.Arrays;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Deprecated
@Metadata
/* renamed from: okio.-DeprecatedOkio  reason: invalid class name */
/* loaded from: source-3503164-dex2jar.jar:okio/-DeprecatedOkio.class */
public final class DeprecatedOkio {
    public static final DeprecatedOkio INSTANCE = new DeprecatedOkio();

    private DeprecatedOkio() {
    }

    @Deprecated
    public final Sink appendingSink(File file) {
        Intrinsics.e(file, "file");
        return Okio.appendingSink(file);
    }

    @Deprecated
    public final Sink blackhole() {
        return Okio.blackhole();
    }

    @Deprecated
    public final BufferedSink buffer(Sink sink) {
        Intrinsics.e(sink, "sink");
        return Okio.buffer(sink);
    }

    @Deprecated
    public final BufferedSource buffer(Source source) {
        Intrinsics.e(source, "source");
        return Okio.buffer(source);
    }

    @Deprecated
    public final Sink sink(File file) {
        Sink sink$default;
        Intrinsics.e(file, "file");
        sink$default = Okio__JvmOkioKt.sink$default(file, false, 1, null);
        return sink$default;
    }

    @Deprecated
    public final Sink sink(OutputStream outputStream) {
        Intrinsics.e(outputStream, "outputStream");
        return Okio.sink(outputStream);
    }

    @Deprecated
    public final Sink sink(Socket socket) {
        Intrinsics.e(socket, "socket");
        return Okio.sink(socket);
    }

    @Deprecated
    public final Sink sink(java.nio.file.Path path, OpenOption... options) {
        Intrinsics.e(path, "path");
        Intrinsics.e(options, "options");
        return Okio.sink(path, (OpenOption[]) Arrays.copyOf(options, options.length));
    }

    @Deprecated
    public final Source source(File file) {
        Intrinsics.e(file, "file");
        return Okio.source(file);
    }

    @Deprecated
    public final Source source(InputStream inputStream) {
        Intrinsics.e(inputStream, "inputStream");
        return Okio.source(inputStream);
    }

    @Deprecated
    public final Source source(Socket socket) {
        Intrinsics.e(socket, "socket");
        return Okio.source(socket);
    }

    @Deprecated
    public final Source source(java.nio.file.Path path, OpenOption... options) {
        Intrinsics.e(path, "path");
        Intrinsics.e(options, "options");
        return Okio.source(path, (OpenOption[]) Arrays.copyOf(options, options.length));
    }
}
