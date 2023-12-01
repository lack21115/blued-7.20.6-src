package libcore.net.url;

import com.alipay.sdk.packet.e;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FilePermission;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.URL;
import java.net.URLConnection;
import java.security.Permission;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import libcore.net.UriCodec;

/* loaded from: source-2895416-dex2jar.jar:libcore/net/url/FileURLConnection.class */
public class FileURLConnection extends URLConnection {
    private static final int CONTENT_LENGTH_VALUE_IDX = 3;
    private static final int CONTENT_TYPE_VALUE_IDX = 1;
    private static final Comparator<String> HEADER_COMPARATOR = new Comparator<String>() { // from class: libcore.net.url.FileURLConnection.1
        @Override // java.util.Comparator
        public int compare(String str, String str2) {
            if (str == str2) {
                return 0;
            }
            if (str == null) {
                return -1;
            }
            if (str2 == null) {
                return 1;
            }
            return String.CASE_INSENSITIVE_ORDER.compare(str, str2);
        }
    };
    private static final int LAST_MODIFIED_VALUE_IDX = 5;
    private String filename;
    private Map<String, List<String>> headerFields;
    private final String[] headerKeysAndValues;
    private InputStream is;
    private boolean isDir;
    private long lastModified;
    private long length;
    private FilePermission permission;

    public FileURLConnection(URL url) {
        super(url);
        this.length = -1L;
        this.lastModified = -1L;
        this.filename = url.getFile();
        if (this.filename == null) {
            this.filename = "";
        }
        this.filename = UriCodec.decode(this.filename);
        this.headerKeysAndValues = new String[]{e.d, null, "content-length", null, "last-modified", null};
    }

    private long getContentLengthLong() {
        try {
            if (!this.connected) {
                connect();
            }
        } catch (IOException e) {
        }
        return this.length;
    }

    private String getContentTypeForPlainFiles() {
        String guessContentTypeFromName = guessContentTypeFromName(this.url.getFile());
        if (guessContentTypeFromName != null) {
            return guessContentTypeFromName;
        }
        try {
            guessContentTypeFromName = guessContentTypeFromStream(this.is);
        } catch (IOException e) {
        }
        return guessContentTypeFromName != null ? guessContentTypeFromName : "content/unknown";
    }

    private InputStream getDirectoryListing(File file) {
        String[] list = file.list();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        printStream.print("<title>Directory Listing</title>\n");
        printStream.print("<base href=\"file:");
        printStream.print(file.getPath().replace('\\', '/') + "/\"><h1>" + file.getPath() + "</h1>\n<hr>\n");
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.length) {
                printStream.close();
                return new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
            }
            printStream.print(list[i2] + "<br>\n");
            i = i2 + 1;
        }
    }

    @Override // java.net.URLConnection
    public void connect() throws IOException {
        File file = new File(this.filename);
        IOException e = null;
        if (file.isDirectory()) {
            this.isDir = true;
            this.is = getDirectoryListing(file);
            this.lastModified = file.lastModified();
            this.headerKeysAndValues[1] = "text/html";
        } else {
            try {
                this.is = new BufferedInputStream(new FileInputStream(file));
                e = null;
            } catch (IOException e2) {
                e = e2;
            }
            if (e == null) {
                this.length = file.length();
                this.lastModified = file.lastModified();
                this.headerKeysAndValues[1] = getContentTypeForPlainFiles();
            } else {
                this.headerKeysAndValues[1] = "content/unknown";
            }
        }
        this.headerKeysAndValues[3] = String.valueOf(this.length);
        this.headerKeysAndValues[5] = String.valueOf(this.lastModified);
        this.connected = true;
        if (e != null) {
            throw e;
        }
    }

    @Override // java.net.URLConnection
    public int getContentLength() {
        long contentLengthLong = getContentLengthLong();
        if (contentLengthLong <= 2147483647L) {
            return (int) contentLengthLong;
        }
        return -1;
    }

    @Override // java.net.URLConnection
    public String getContentType() {
        return getHeaderField(0);
    }

    @Override // java.net.URLConnection
    public String getHeaderField(int i) {
        if (!this.connected) {
            try {
                connect();
            } catch (IOException e) {
                return null;
            }
        }
        if (i < 0 || i > this.headerKeysAndValues.length / 2) {
            return null;
        }
        return this.headerKeysAndValues[(i * 2) + 1];
    }

    @Override // java.net.URLConnection
    public String getHeaderField(String str) {
        String str2;
        if (!this.connected) {
            try {
                connect();
            } catch (IOException e) {
                return null;
            }
        }
        int i = 0;
        while (true) {
            int i2 = i;
            str2 = null;
            if (i2 >= this.headerKeysAndValues.length) {
                break;
            } else if (this.headerKeysAndValues[i2].equalsIgnoreCase(str)) {
                str2 = this.headerKeysAndValues[i2 + 1];
                break;
            } else {
                i = i2 + 2;
            }
        }
        return str2;
    }

    @Override // java.net.URLConnection
    public String getHeaderFieldKey(int i) {
        if (!this.connected) {
            try {
                connect();
            } catch (IOException e) {
                return null;
            }
        }
        if (i < 0 || i > this.headerKeysAndValues.length / 2) {
            return null;
        }
        return this.headerKeysAndValues[i * 2];
    }

    @Override // java.net.URLConnection
    public Map<String, List<String>> getHeaderFields() {
        if (this.headerFields == null) {
            TreeMap treeMap = new TreeMap(HEADER_COMPARATOR);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.headerKeysAndValues.length) {
                    break;
                }
                treeMap.put(this.headerKeysAndValues[i2], Collections.singletonList(this.headerKeysAndValues[i2 + 1]));
                i = i2 + 2;
            }
            this.headerFields = Collections.unmodifiableMap(treeMap);
        }
        return this.headerFields;
    }

    @Override // java.net.URLConnection
    public InputStream getInputStream() throws IOException {
        if (!this.connected) {
            connect();
        }
        return this.is;
    }

    @Override // java.net.URLConnection
    public Permission getPermission() throws IOException {
        if (this.permission == null) {
            String str = this.filename;
            String str2 = str;
            if (File.separatorChar != '/') {
                str2 = str.replace('/', File.separatorChar);
            }
            this.permission = new FilePermission(str2, "read");
        }
        return this.permission;
    }
}
