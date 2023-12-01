package libcore.io;

import android.system.ErrnoException;
import android.system.OsConstants;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.Socket;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Random;

/* loaded from: source-2895416-dex2jar.jar:libcore/io/IoUtils.class */
public final class IoUtils {
    private static final Random TEMPORARY_DIRECTORY_PRNG = new Random();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-2895416-dex2jar.jar:libcore/io/IoUtils$FileReader.class */
    public static class FileReader {
        private byte[] bytes;
        private int count;
        private FileDescriptor fd;
        private boolean unknownLength;

        public FileReader(String str) throws IOException {
            try {
                this.fd = IoBridge.open(str, OsConstants.O_RDONLY);
                try {
                    int i = (int) Libcore.os.fstat(this.fd).st_size;
                    int i2 = i;
                    if (i == 0) {
                        this.unknownLength = true;
                        i2 = 8192;
                    }
                    this.bytes = new byte[i2];
                } catch (ErrnoException e) {
                    IoUtils.closeQuietly(this.fd);
                    throw e.rethrowAsIOException();
                }
            } catch (FileNotFoundException e2) {
                throw e2;
            }
        }

        public FileReader readFully() throws IOException {
            int length = this.bytes.length;
            while (true) {
                try {
                    try {
                        int read = Libcore.os.read(this.fd, this.bytes, this.count, length - this.count);
                        if (read == 0) {
                            break;
                        }
                        this.count += read;
                        if (this.count == length) {
                            if (!this.unknownLength) {
                                break;
                            }
                            int i = length * 2;
                            byte[] bArr = new byte[i];
                            System.arraycopy(this.bytes, 0, bArr, 0, length);
                            this.bytes = bArr;
                            length = i;
                        }
                    } catch (ErrnoException e) {
                        throw e.rethrowAsIOException();
                    }
                } finally {
                    IoUtils.closeQuietly(this.fd);
                }
            }
            return this;
        }

        @FindBugsSuppressWarnings({"EI_EXPOSE_REP"})
        public byte[] toByteArray() {
            if (this.count == this.bytes.length) {
                return this.bytes;
            }
            byte[] bArr = new byte[this.count];
            System.arraycopy(this.bytes, 0, bArr, 0, this.count);
            return bArr;
        }

        public String toString(Charset charset) {
            return new String(this.bytes, 0, this.count, charset);
        }
    }

    private IoUtils() {
    }

    public static boolean canOpenReadOnly(String str) {
        try {
            Libcore.os.close(Libcore.os.open(str, OsConstants.O_RDONLY, 0));
            return true;
        } catch (ErrnoException e) {
            return false;
        }
    }

    public static void close(FileDescriptor fileDescriptor) throws IOException {
        if (fileDescriptor != null) {
            try {
                if (fileDescriptor.valid()) {
                    Libcore.os.close(fileDescriptor);
                }
            } catch (ErrnoException e) {
                throw e.rethrowAsIOException();
            }
        }
    }

    public static void closeQuietly(FileDescriptor fileDescriptor) {
        try {
            close(fileDescriptor);
        } catch (IOException e) {
        }
    }

    public static void closeQuietly(AutoCloseable autoCloseable) {
        if (autoCloseable != null) {
            try {
                autoCloseable.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception e2) {
            }
        }
    }

    public static void closeQuietly(Socket socket) {
        if (socket != null) {
            try {
                socket.close();
            } catch (Exception e) {
            }
        }
    }

    public static File createTemporaryDirectory(String str) {
        File file;
        do {
            file = new File(System.getProperty("java.io.tmpdir"), str + TEMPORARY_DIRECTORY_PRNG.nextInt());
        } while (!file.mkdir());
        return file;
    }

    public static void deleteContents(File file) throws IOException {
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return;
        }
        int length = listFiles.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            File file2 = listFiles[i2];
            if (file2.isDirectory()) {
                deleteContents(file2);
            }
            file2.delete();
            i = i2 + 1;
        }
    }

    public static byte[] readFileAsByteArray(String str) throws IOException {
        return new FileReader(str).readFully().toByteArray();
    }

    public static String readFileAsString(String str) throws IOException {
        return new FileReader(str).readFully().toString(StandardCharsets.UTF_8);
    }

    public static void setBlocking(FileDescriptor fileDescriptor, boolean z) throws IOException {
        try {
            int fcntlVoid = Libcore.os.fcntlVoid(fileDescriptor, OsConstants.F_GETFL);
            Libcore.os.fcntlLong(fileDescriptor, OsConstants.F_SETFL, !z ? fcntlVoid | OsConstants.O_NONBLOCK : fcntlVoid & (OsConstants.O_NONBLOCK ^ (-1)));
        } catch (ErrnoException e) {
            throw e.rethrowAsIOException();
        }
    }

    public static void throwInterruptedIoException() throws InterruptedIOException {
        Thread.currentThread().interrupt();
        throw new InterruptedIOException();
    }
}
