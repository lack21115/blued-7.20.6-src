package a.a.a.a.a.k.e;

import a.a.a.a.a.k.e.c;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.UnknownHostException;
import java.util.Locale;

/* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/k/e/a.class */
public final class a implements b {
    public static int a(InputStream inputStream, byte[] bArr, int i, int i2) throws IOException {
        int i3;
        int read;
        while (true) {
            int i4 = i3;
            i3 = (i4 < i2 && (read = inputStream.read(bArr, i + i4, i2 - i4)) >= 0) ? i4 + read : 0;
            return i4;
        }
    }

    public static Socket a(InetSocketAddress inetSocketAddress, int i) throws IOException {
        Socket socket = new Socket();
        socket.setTcpNoDelay(true);
        socket.setSoTimeout(30000);
        try {
            socket.connect(inetSocketAddress, i);
            return socket;
        } catch (Exception e) {
            socket.close();
            throw e;
        }
    }

    public static void a(OutputStream outputStream, InputStream inputStream, int i, int i2) throws IOException {
        byte[] bArr = new byte[i];
        outputStream.write(String.format(Locale.getDefault(), "POST /ping HTTP/1.1\r\nHost: pilitest.qiniucdn.com:%d\r\nContent-Length: %d\r\n\r\n", Integer.valueOf(i2), Integer.valueOf(i)).getBytes());
        a(outputStream, bArr, 0, i);
        a(inputStream, bArr, 0, 32);
    }

    public static void a(OutputStream outputStream, byte[] bArr, int i, int i2) throws IOException {
        outputStream.write(bArr, i, i2);
        outputStream.flush();
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:40:0x00e0 -> B:24:0x0098). Please submit an issue!!! */
    @Override // a.a.a.a.a.k.e.b
    public c.e a(String str, int i) {
        String str2;
        Socket socket;
        try {
            URI uri = new URI(str);
            try {
                String hostAddress = InetAddress.getAllByName(uri.getHost())[0].getHostAddress();
                int port = uri.getPort() == -1 ? 1230 : uri.getPort();
                InetSocketAddress inetSocketAddress = new InetSocketAddress(hostAddress, port);
                long currentTimeMillis = System.currentTimeMillis();
                try {
                    socket = a(inetSocketAddress, 30000);
                    str2 = null;
                } catch (IOException e) {
                    str2 = "connect failed";
                    socket = null;
                }
                long currentTimeMillis2 = System.currentTimeMillis();
                if (socket == null) {
                    return new c.e(uri.getHost(), hostAddress, (int) (currentTimeMillis2 - currentTimeMillis), 0, str2);
                }
                try {
                    a(socket.getOutputStream(), socket.getInputStream(), i, port);
                } catch (IOException e2) {
                    str2 = "send failed";
                } catch (Throwable th) {
                    try {
                        socket.close();
                    } catch (IOException e3) {
                    }
                    throw th;
                }
                try {
                    socket.close();
                } catch (IOException e4) {
                }
                return new c.e(uri.getHost(), hostAddress, (int) (currentTimeMillis2 - currentTimeMillis), (int) (System.currentTimeMillis() - currentTimeMillis2), str2);
            } catch (UnknownHostException e5) {
                return new c.e(uri.getHost(), "", 0, 0, "unknownhost");
            }
        } catch (URISyntaxException e6) {
            return null;
        }
    }
}
