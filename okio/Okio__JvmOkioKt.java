package okio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.Mac;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okio.internal.ResourceFileSystem;
import okio.internal.ZipKt;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:okio/Okio__JvmOkioKt.class */
public final /* synthetic */ class Okio__JvmOkioKt {
    private static final Logger logger = Logger.getLogger("okio.Okio");

    public static final Sink appendingSink(File file) throws FileNotFoundException {
        Intrinsics.e(file, "<this>");
        return Okio.sink(new FileOutputStream(file, true));
    }

    public static final FileSystem asResourceFileSystem(ClassLoader classLoader) {
        Intrinsics.e(classLoader, "<this>");
        return new ResourceFileSystem(classLoader, true);
    }

    public static final CipherSink cipherSink(Sink sink, Cipher cipher) {
        Intrinsics.e(sink, "<this>");
        Intrinsics.e(cipher, "cipher");
        return new CipherSink(Okio.buffer(sink), cipher);
    }

    public static final CipherSource cipherSource(Source source, Cipher cipher) {
        Intrinsics.e(source, "<this>");
        Intrinsics.e(cipher, "cipher");
        return new CipherSource(Okio.buffer(source), cipher);
    }

    public static final HashingSink hashingSink(Sink sink, MessageDigest digest) {
        Intrinsics.e(sink, "<this>");
        Intrinsics.e(digest, "digest");
        return new HashingSink(sink, digest);
    }

    public static final HashingSink hashingSink(Sink sink, Mac mac) {
        Intrinsics.e(sink, "<this>");
        Intrinsics.e(mac, "mac");
        return new HashingSink(sink, mac);
    }

    public static final HashingSource hashingSource(Source source, MessageDigest digest) {
        Intrinsics.e(source, "<this>");
        Intrinsics.e(digest, "digest");
        return new HashingSource(source, digest);
    }

    public static final HashingSource hashingSource(Source source, Mac mac) {
        Intrinsics.e(source, "<this>");
        Intrinsics.e(mac, "mac");
        return new HashingSource(source, mac);
    }

    public static final boolean isAndroidGetsocknameError(AssertionError assertionError) {
        Intrinsics.e(assertionError, "<this>");
        boolean z = false;
        if (assertionError.getCause() != null) {
            String message = assertionError.getMessage();
            z = false;
            if (message == null ? false : StringsKt.c((CharSequence) message, (CharSequence) "getsockname failed", false, 2, (Object) null)) {
                z = true;
            }
        }
        return z;
    }

    public static final FileSystem openZip(FileSystem fileSystem, Path zipPath) throws IOException {
        Intrinsics.e(fileSystem, "<this>");
        Intrinsics.e(zipPath, "zipPath");
        return ZipKt.openZip$default(zipPath, fileSystem, null, 4, null);
    }

    public static final Sink sink(File file) throws FileNotFoundException {
        Sink sink$default;
        Intrinsics.e(file, "<this>");
        sink$default = sink$default(file, false, 1, null);
        return sink$default;
    }

    public static final Sink sink(File file, boolean z) throws FileNotFoundException {
        Intrinsics.e(file, "<this>");
        return Okio.sink(new FileOutputStream(file, z));
    }

    public static final Sink sink(OutputStream outputStream) {
        Intrinsics.e(outputStream, "<this>");
        return new OutputStreamSink(outputStream, new Timeout());
    }

    public static final Sink sink(Socket socket) throws IOException {
        Intrinsics.e(socket, "<this>");
        SocketAsyncTimeout socketAsyncTimeout = new SocketAsyncTimeout(socket);
        OutputStream outputStream = socket.getOutputStream();
        Intrinsics.c(outputStream, "getOutputStream()");
        return socketAsyncTimeout.sink(new OutputStreamSink(outputStream, socketAsyncTimeout));
    }

    public static final Sink sink(java.nio.file.Path path, OpenOption... options) throws IOException {
        Intrinsics.e(path, "<this>");
        Intrinsics.e(options, "options");
        OutputStream newOutputStream = Files.newOutputStream(path, (OpenOption[]) Arrays.copyOf(options, options.length));
        Intrinsics.c(newOutputStream, "newOutputStream(this, *options)");
        return Okio.sink(newOutputStream);
    }

    public static /* synthetic */ Sink sink$default(File file, boolean z, int i, Object obj) throws FileNotFoundException {
        if ((i & 1) != 0) {
            z = false;
        }
        return Okio.sink(file, z);
    }

    public static final Source source(File file) throws FileNotFoundException {
        Intrinsics.e(file, "<this>");
        return new InputStreamSource(new FileInputStream(file), Timeout.NONE);
    }

    public static final Source source(InputStream inputStream) {
        Intrinsics.e(inputStream, "<this>");
        return new InputStreamSource(inputStream, new Timeout());
    }

    public static final Source source(Socket socket) throws IOException {
        Intrinsics.e(socket, "<this>");
        SocketAsyncTimeout socketAsyncTimeout = new SocketAsyncTimeout(socket);
        InputStream inputStream = socket.getInputStream();
        Intrinsics.c(inputStream, "getInputStream()");
        return socketAsyncTimeout.source(new InputStreamSource(inputStream, socketAsyncTimeout));
    }

    public static final Source source(java.nio.file.Path path, OpenOption... options) throws IOException {
        Intrinsics.e(path, "<this>");
        Intrinsics.e(options, "options");
        InputStream newInputStream = Files.newInputStream(path, (OpenOption[]) Arrays.copyOf(options, options.length));
        Intrinsics.c(newInputStream, "newInputStream(this, *options)");
        return Okio.source(newInputStream);
    }
}
