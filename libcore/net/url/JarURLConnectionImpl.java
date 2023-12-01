package libcore.net.url;

import android.content.ContentResolver;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.JarURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.Permission;
import java.util.HashMap;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import libcore.net.UriCodec;

/* loaded from: source-2895416-dex2jar.jar:libcore/net/url/JarURLConnectionImpl.class */
public class JarURLConnectionImpl extends JarURLConnection {
    private static final HashMap<URL, JarFile> jarCache = new HashMap<>();
    private boolean closed;
    private JarEntry jarEntry;
    private JarFile jarFile;
    private URL jarFileURL;
    private InputStream jarInput;

    /* loaded from: source-2895416-dex2jar.jar:libcore/net/url/JarURLConnectionImpl$JarURLConnectionInputStream.class */
    private class JarURLConnectionInputStream extends FilterInputStream {
        final JarFile jarFile;

        protected JarURLConnectionInputStream(InputStream inputStream, JarFile jarFile) {
            super(inputStream);
            this.jarFile = jarFile;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            super.close();
            if (JarURLConnectionImpl.this.getUseCaches()) {
                return;
            }
            JarURLConnectionImpl.this.closed = true;
            this.jarFile.close();
        }
    }

    public JarURLConnectionImpl(URL url) throws MalformedURLException, IOException {
        super(url);
        this.jarFileURL = getJarFileURL();
        this.jarFileURLConnection = this.jarFileURL.openConnection();
    }

    private void findJarEntry() throws IOException {
        if (getEntryName() == null) {
            return;
        }
        this.jarEntry = this.jarFile.getJarEntry(getEntryName());
        if (this.jarEntry == null) {
            throw new FileNotFoundException(getEntryName());
        }
    }

    private void findJarFile() throws IOException {
        if (getUseCaches()) {
            synchronized (jarCache) {
                this.jarFile = jarCache.get(this.jarFileURL);
            }
            if (this.jarFile == null) {
                JarFile openJarFile = openJarFile();
                synchronized (jarCache) {
                    this.jarFile = jarCache.get(this.jarFileURL);
                    if (this.jarFile == null) {
                        jarCache.put(this.jarFileURL, openJarFile);
                        this.jarFile = openJarFile;
                    } else {
                        openJarFile.close();
                    }
                }
            }
        } else {
            this.jarFile = openJarFile();
        }
        if (this.jarFile == null) {
            throw new IOException();
        }
    }

    private JarFile openJarFile() throws IOException {
        FileOutputStream fileOutputStream;
        JarFile jarFile;
        File createTempFile;
        if (this.jarFileURL.getProtocol().equals(ContentResolver.SCHEME_FILE)) {
            jarFile = new JarFile(new File(UriCodec.decode(this.jarFileURL.getFile())), true, 1);
        } else {
            InputStream inputStream = this.jarFileURL.openConnection().getInputStream();
            try {
                try {
                    createTempFile = File.createTempFile("hyjar_", ".tmp", null);
                    createTempFile.deleteOnExit();
                    fileOutputStream = new FileOutputStream(createTempFile);
                } catch (IOException e) {
                    fileOutputStream = null;
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = null;
                }
                try {
                    byte[] bArr = new byte[4096];
                    while (true) {
                        int read = inputStream.read(bArr);
                        if (read <= -1) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, read);
                    }
                    fileOutputStream.close();
                    JarFile jarFile2 = new JarFile(createTempFile, true, 5);
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e2) {
                            jarFile = null;
                            if (inputStream != null) {
                                inputStream.close();
                                return null;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            throw th;
                        }
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    return jarFile2;
                } catch (IOException e3) {
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e4) {
                            jarFile = null;
                            if (inputStream != null) {
                                inputStream.close();
                                return null;
                            }
                        }
                    }
                    jarFile = null;
                    if (inputStream != null) {
                        inputStream.close();
                        return null;
                    }
                    return jarFile;
                } catch (Throwable th3) {
                    th = th3;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e5) {
                            jarFile = null;
                            if (inputStream != null) {
                                inputStream.close();
                                return null;
                            }
                        }
                    }
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
            }
        }
        return jarFile;
    }

    @Override // java.net.URLConnection
    public void connect() throws IOException {
        if (this.connected) {
            return;
        }
        findJarFile();
        findJarEntry();
        this.connected = true;
    }

    @Override // java.net.URLConnection
    public Object getContent() throws IOException {
        connect();
        return this.jarEntry == null ? this.jarFile : super.getContent();
    }

    @Override // java.net.URLConnection
    public int getContentLength() {
        try {
            connect();
            return this.jarEntry == null ? this.jarFileURLConnection.getContentLength() : (int) getJarEntry().getSize();
        } catch (IOException e) {
            return -1;
        }
    }

    @Override // java.net.URLConnection
    public String getContentType() {
        String str;
        if (this.url.getFile().endsWith("!/")) {
            str = "x-java/jar";
        } else {
            String str2 = null;
            String entryName = getEntryName();
            if (entryName != null) {
                str2 = guessContentTypeFromName(entryName);
            } else {
                try {
                    connect();
                    str2 = this.jarFileURLConnection.getContentType();
                } catch (IOException e) {
                }
            }
            str = str2;
            if (str2 == null) {
                return "content/unknown";
            }
        }
        return str;
    }

    @Override // java.net.URLConnection
    public boolean getDefaultUseCaches() {
        return this.jarFileURLConnection.getDefaultUseCaches();
    }

    @Override // java.net.URLConnection
    public InputStream getInputStream() throws IOException {
        if (this.closed) {
            throw new IllegalStateException("JarURLConnection InputStream has been closed");
        }
        connect();
        if (this.jarInput != null) {
            return this.jarInput;
        }
        if (this.jarEntry == null) {
            throw new IOException("Jar entry not specified");
        }
        JarURLConnectionInputStream jarURLConnectionInputStream = new JarURLConnectionInputStream(this.jarFile.getInputStream(this.jarEntry), this.jarFile);
        this.jarInput = jarURLConnectionInputStream;
        return jarURLConnectionInputStream;
    }

    @Override // java.net.JarURLConnection
    public JarEntry getJarEntry() throws IOException {
        connect();
        return this.jarEntry;
    }

    @Override // java.net.JarURLConnection
    public JarFile getJarFile() throws IOException {
        connect();
        return this.jarFile;
    }

    @Override // java.net.URLConnection
    public Permission getPermission() throws IOException {
        return this.jarFileURLConnection.getPermission();
    }

    @Override // java.net.URLConnection
    public boolean getUseCaches() {
        return this.jarFileURLConnection.getUseCaches();
    }

    @Override // java.net.URLConnection
    public void setDefaultUseCaches(boolean z) {
        this.jarFileURLConnection.setDefaultUseCaches(z);
    }

    @Override // java.net.URLConnection
    public void setUseCaches(boolean z) {
        this.jarFileURLConnection.setUseCaches(z);
    }
}
