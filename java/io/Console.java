package java.io;

import java.util.Formatter;
import libcore.io.Libcore;

/* loaded from: source-2895416-dex2jar.jar:java/io/Console.class */
public final class Console implements Flushable {
    private static final Object CONSOLE_LOCK = new Object();
    private static final Console console = makeConsole();
    private final ConsoleReader reader;
    private final PrintWriter writer;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-2895416-dex2jar.jar:java/io/Console$ConsoleReader.class */
    public static class ConsoleReader extends BufferedReader {
        public ConsoleReader(InputStream inputStream) throws UnsupportedEncodingException {
            super(new InputStreamReader(inputStream, System.getProperty("file.encoding")), 256);
            this.lock = Console.CONSOLE_LOCK;
        }

        @Override // java.io.BufferedReader, java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }
    }

    /* loaded from: source-2895416-dex2jar.jar:java/io/Console$ConsoleWriter.class */
    private static class ConsoleWriter extends PrintWriter {
        public ConsoleWriter(OutputStream outputStream) {
            super(outputStream, true);
            this.lock = Console.CONSOLE_LOCK;
        }

        @Override // java.io.PrintWriter, java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            flush();
        }
    }

    private Console(InputStream inputStream, OutputStream outputStream) throws UnsupportedEncodingException {
        this.reader = new ConsoleReader(inputStream);
        this.writer = new ConsoleWriter(outputStream);
    }

    public static Console getConsole() {
        return console;
    }

    private static Console makeConsole() {
        if (Libcore.os.isatty(FileDescriptor.f42253in) && Libcore.os.isatty(FileDescriptor.out)) {
            try {
                return new Console(System.f42260in, System.out);
            } catch (UnsupportedEncodingException e) {
                throw new AssertionError(e);
            }
        }
        return null;
    }

    @Override // java.io.Flushable
    public void flush() {
        this.writer.flush();
    }

    public Console format(String str, Object... objArr) {
        Formatter formatter = new Formatter(this.writer);
        formatter.format(str, objArr);
        formatter.flush();
        return this;
    }

    public Console printf(String str, Object... objArr) {
        return format(str, objArr);
    }

    public String readLine() {
        try {
            return this.reader.readLine();
        } catch (IOException e) {
            throw new IOError(e);
        }
    }

    public String readLine(String str, Object... objArr) {
        String readLine;
        synchronized (CONSOLE_LOCK) {
            format(str, objArr);
            readLine = readLine();
        }
        return readLine;
    }

    public char[] readPassword() {
        throw new UnsupportedOperationException();
    }

    public char[] readPassword(String str, Object... objArr) {
        throw new UnsupportedOperationException();
    }

    public Reader reader() {
        return this.reader;
    }

    public PrintWriter writer() {
        return this.writer;
    }
}
