package libcore.net.url;

import java.io.BufferedInputStream;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketPermission;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.security.Permission;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: source-2895416-dex2jar.jar:libcore/net/url/FtpURLConnection.class */
public class FtpURLConnection extends URLConnection {
    private static final int FTP_DATAOPEN = 125;
    private static final int FTP_FILEOK = 250;
    private static final int FTP_LOGGEDIN = 230;
    private static final int FTP_NOTFOUND = 550;
    private static final int FTP_OK = 200;
    private static final int FTP_OPENDATA = 150;
    private static final int FTP_PASWD = 331;
    private static final int FTP_PORT = 21;
    private static final int FTP_TRANSFEROK = 226;
    private static final int FTP_USERREADY = 220;
    private ServerSocket acceptSocket;
    private Socket controlSocket;
    private InputStream ctrlInput;
    private OutputStream ctrlOutput;
    private Proxy currentProxy;
    private int dataPort;
    private Socket dataSocket;
    private String hostName;
    private InputStream inputStream;
    private String password;
    private Proxy proxy;
    private String replyCode;
    private URI uri;
    private String username;

    /* JADX INFO: Access modifiers changed from: protected */
    public FtpURLConnection(URL url) {
        super(url);
        this.username = "anonymous";
        this.password = "";
        this.hostName = url.getHost();
        String userInfo = url.getUserInfo();
        if (userInfo != null) {
            int indexOf = userInfo.indexOf(58);
            if (indexOf >= 0) {
                this.username = userInfo.substring(0, indexOf);
                this.password = userInfo.substring(indexOf + 1);
            } else {
                this.username = userInfo;
            }
        }
        this.uri = null;
        try {
            this.uri = url.toURI();
        } catch (URISyntaxException e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public FtpURLConnection(URL url, Proxy proxy) {
        this(url);
        this.proxy = proxy;
    }

    private void cd() throws IOException {
        int lastIndexOf = this.url.getFile().lastIndexOf(47);
        if (lastIndexOf > 0) {
            String substring = this.url.getFile().substring(0, lastIndexOf);
            write("CWD " + substring + "\r\n");
            int reply = getReply();
            int i = reply;
            if (reply != 250) {
                i = reply;
                if (substring.length() > 0) {
                    i = reply;
                    if (substring.charAt(0) == '/') {
                        write("CWD " + substring.substring(1) + "\r\n");
                        i = getReply();
                    }
                }
            }
            if (i != 250) {
                throw new IOException("Unable to change directories");
            }
        }
    }

    private void connectInternal() throws IOException {
        int port = this.url.getPort();
        int connectTimeout = getConnectTimeout();
        int i = port;
        if (port <= 0) {
            i = 21;
        }
        if (this.currentProxy == null || Proxy.Type.HTTP == this.currentProxy.type()) {
            this.controlSocket = new Socket();
        } else {
            this.controlSocket = new Socket(this.currentProxy);
        }
        this.controlSocket.connect(new InetSocketAddress(this.hostName, i), connectTimeout);
        this.connected = true;
        this.ctrlOutput = this.controlSocket.getOutputStream();
        this.ctrlInput = this.controlSocket.getInputStream();
        login();
        setType();
        if (!getDoInput()) {
            cd();
        }
        try {
            this.acceptSocket = new ServerSocket(0);
            this.dataPort = this.acceptSocket.getLocalPort();
            port();
            if (connectTimeout == 0) {
            }
            this.acceptSocket.setSoTimeout(getConnectTimeout());
            if (getDoInput()) {
                getFile();
            } else {
                sendFile();
            }
            this.dataSocket = this.acceptSocket.accept();
            this.dataSocket.setSoTimeout(getReadTimeout());
            this.acceptSocket.close();
            if (getDoInput()) {
                this.inputStream = new FtpURLInputStream(new BufferedInputStream(this.dataSocket.getInputStream()), this.controlSocket);
            }
        } catch (InterruptedIOException e) {
            throw new IOException("Could not establish data connection");
        }
    }

    private void getFile() throws IOException {
        String file = this.url.getFile();
        write("RETR " + file + "\r\n");
        int reply = getReply();
        int i = reply;
        if (reply == FTP_NOTFOUND) {
            i = reply;
            if (file.length() > 0) {
                i = reply;
                if (file.charAt(0) == '/') {
                    write("RETR " + file.substring(1) + "\r\n");
                    i = getReply();
                }
            }
        }
        if (i != 150 && i != 226) {
            throw new FileNotFoundException("Unable to retrieve file: " + i);
        }
    }

    private int getReply() throws IOException {
        byte[] bArr = new byte[3];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= bArr.length) {
                this.replyCode = new String(bArr, 0, bArr.length, StandardCharsets.ISO_8859_1);
                boolean z = false;
                if (this.ctrlInput.read() == 45) {
                    z = true;
                }
                readLine();
                if (z) {
                    do {
                    } while (readMultiLine());
                    try {
                        return Integer.parseInt(this.replyCode);
                    } catch (NumberFormatException e) {
                        throw ((IOException) new IOException("reply code is invalid").initCause(e));
                    }
                }
                return Integer.parseInt(this.replyCode);
            }
            int read = this.ctrlInput.read();
            if (read == -1) {
                throw new EOFException();
            }
            bArr[i2] = (byte) read;
            i = i2 + 1;
        }
    }

    private void login() throws IOException {
        if (getReply() != 220) {
            throw new IOException("Unable to connect to server: " + this.url.getHost());
        }
        write("USER " + this.username + "\r\n");
        int reply = getReply();
        if (reply != 331 && reply != 230) {
            throw new IOException("Unable to log in to server (USER): " + this.url.getHost());
        }
        if (reply == 331) {
            write("PASS " + this.password + "\r\n");
            int reply2 = getReply();
            if (reply2 != 200 && reply2 != 220 && reply2 != 230) {
                throw new IOException("Unable to log in to server (PASS): " + this.url.getHost());
            }
        }
    }

    private void port() throws IOException {
        write("PORT " + this.controlSocket.getLocalAddress().getHostAddress().replace('.', ',') + ',' + (this.dataPort >> 8) + ',' + (this.dataPort & 255) + "\r\n");
        if (getReply() != 200) {
            throw new IOException("Unable to configure data port");
        }
    }

    private String readLine() throws IOException {
        StringBuilder sb = new StringBuilder();
        while (true) {
            int read = this.ctrlInput.read();
            if (read == 10) {
                return sb.toString();
            }
            sb.append((char) read);
        }
    }

    private boolean readMultiLine() throws IOException {
        String readLine = readLine();
        return (readLine.length() >= 4 && readLine.substring(0, 3).equals(this.replyCode) && readLine.charAt(3) == ' ') ? false : true;
    }

    private void sendFile() throws IOException {
        write("STOR " + this.url.getFile().substring(this.url.getFile().lastIndexOf(47) + 1, this.url.getFile().length()) + "\r\n");
        int reply = getReply();
        if (reply != 150 && reply != 200 && reply != 125) {
            throw new IOException("Unable to store file");
        }
    }

    private void setType() throws IOException {
        write("TYPE I\r\n");
        if (getReply() != 200) {
            throw new IOException("Unable to set transfer type");
        }
    }

    private void write(String str) throws IOException {
        this.ctrlOutput.write(str.getBytes(StandardCharsets.ISO_8859_1));
    }

    @Override // java.net.URLConnection
    public void connect() throws IOException {
        ArrayList arrayList = null;
        if (this.proxy != null) {
            arrayList = new ArrayList(1);
            arrayList.add(this.proxy);
        } else {
            ProxySelector proxySelector = ProxySelector.getDefault();
            if (proxySelector != null) {
                arrayList = proxySelector.select(this.uri);
            }
        }
        if (arrayList == null) {
            this.currentProxy = null;
            connectInternal();
            return;
        }
        ProxySelector proxySelector2 = ProxySelector.getDefault();
        Iterator<Proxy> it = arrayList.iterator();
        boolean z = false;
        String str = "";
        while (it.hasNext() && !z) {
            this.currentProxy = it.next();
            try {
                connectInternal();
                z = true;
            } catch (IOException e) {
                String localizedMessage = e.getLocalizedMessage();
                str = localizedMessage;
                if (proxySelector2 != null) {
                    str = localizedMessage;
                    if (Proxy.NO_PROXY != this.currentProxy) {
                        proxySelector2.connectFailed(this.uri, this.currentProxy.address(), e);
                        str = localizedMessage;
                    }
                }
            }
        }
        if (!z) {
            throw new IOException("Unable to connect to server: " + str);
        }
    }

    @Override // java.net.URLConnection
    public String getContentType() {
        String guessContentTypeFromName = guessContentTypeFromName(this.url.getFile());
        String str = guessContentTypeFromName;
        if (guessContentTypeFromName == null) {
            str = "content/unknown";
        }
        return str;
    }

    @Override // java.net.URLConnection
    public InputStream getInputStream() throws IOException {
        if (!this.connected) {
            connect();
        }
        return this.inputStream;
    }

    @Override // java.net.URLConnection
    public OutputStream getOutputStream() throws IOException {
        if (!this.connected) {
            connect();
        }
        return this.dataSocket.getOutputStream();
    }

    @Override // java.net.URLConnection
    public Permission getPermission() throws IOException {
        int port = this.url.getPort();
        int i = port;
        if (port <= 0) {
            i = 21;
        }
        return new SocketPermission(this.hostName + ":" + i, "connect, resolve");
    }

    @Override // java.net.URLConnection
    public void setDoInput(boolean z) {
        if (this.connected) {
            throw new IllegalAccessError();
        }
        this.doInput = z;
        this.doOutput = !z;
    }

    @Override // java.net.URLConnection
    public void setDoOutput(boolean z) {
        if (this.connected) {
            throw new IllegalAccessError();
        }
        this.doOutput = z;
        this.doInput = !z;
    }
}
