package java.net;

import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import java.io.IOException;
import libcore.net.url.UrlUtils;
import libcore.util.Objects;

/* loaded from: source-2895416-dex2jar.jar:java/net/URLStreamHandler.class */
public abstract class URLStreamHandler {
    private static String relativePath(String str, String str2) {
        String str3;
        if (str2.startsWith(BridgeUtil.SPLIT_MARK)) {
            str3 = UrlUtils.canonicalizePath(str2, true);
        } else {
            str3 = str2;
            if (str != null) {
                return UrlUtils.canonicalizePath(str.substring(0, str.lastIndexOf(47) + 1) + str2, true);
            }
        }
        return str3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean equals(URL url, URL url2) {
        return sameFile(url, url2) && Objects.equal(url.getRef(), url2.getRef()) && Objects.equal(url.getQuery(), url2.getQuery());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getDefaultPort() {
        return -1;
    }

    protected InetAddress getHostAddress(URL url) {
        try {
            String host = url.getHost();
            if (host == null || host.length() == 0) {
                return null;
            }
            return InetAddress.getByName(host);
        } catch (UnknownHostException e) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int hashCode(URL url) {
        return toExternalForm(url).hashCode();
    }

    protected boolean hostsEqual(URL url, URL url2) {
        String host = url.getHost();
        String host2 = url2.getHost();
        if (host != host2) {
            return host != null && host.equalsIgnoreCase(host2);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract URLConnection openConnection(URL url) throws IOException;

    /* JADX INFO: Access modifiers changed from: protected */
    public URLConnection openConnection(URL url, Proxy proxy) throws IOException {
        throw new UnsupportedOperationException();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void parseURL(URL url, String str, int i, int i2) {
        String authority;
        String userInfo;
        int port;
        String query;
        String ref;
        String str2;
        String str3;
        int i3;
        int findFirstOf;
        String str4;
        String str5;
        if (this != url.streamHandler) {
            throw new SecurityException("Only a URL's stream handler is permitted to mutate it");
        }
        if (i2 < i) {
            throw new StringIndexOutOfBoundsException(str, i, i2 - i);
        }
        if (str.regionMatches(i, "//", 0, 2)) {
            int i4 = i + 2;
            int findFirstOf2 = UrlUtils.findFirstOf(str, "/?#", i4, i2);
            authority = str.substring(i4, findFirstOf2);
            int findFirstOf3 = UrlUtils.findFirstOf(str, "@", i4, findFirstOf2);
            if (findFirstOf3 != findFirstOf2) {
                str5 = str.substring(i4, findFirstOf3);
                i4 = findFirstOf3 + 1;
            } else {
                str5 = null;
            }
            int i5 = i4;
            int findFirstOf4 = UrlUtils.findFirstOf(str, "]", i4, findFirstOf2);
            if (findFirstOf4 != findFirstOf2) {
                if (UrlUtils.findFirstOf(str, ":", i4, findFirstOf4) == findFirstOf4) {
                    throw new IllegalArgumentException("Expected an IPv6 address: " + str.substring(i4, findFirstOf4 + 1));
                }
                i5 = findFirstOf4;
            }
            int findFirstOf5 = UrlUtils.findFirstOf(str, ":", i5, findFirstOf2);
            String substring = str.substring(i4, findFirstOf5);
            int i6 = findFirstOf5 + 1;
            int i7 = -1;
            if (i6 < findFirstOf2) {
                char charAt = str.charAt(i6);
                if (charAt < '0' || charAt > '9') {
                    throw new IllegalArgumentException("invalid port: -1");
                }
                i7 = Integer.parseInt(str.substring(i6, findFirstOf2));
            }
            str3 = null;
            query = null;
            ref = null;
            i3 = findFirstOf2;
            userInfo = str5;
            port = i7;
            str2 = substring;
        } else {
            authority = url.getAuthority();
            userInfo = url.getUserInfo();
            String host = url.getHost();
            String str6 = host;
            if (host == null) {
                str6 = "";
            }
            port = url.getPort();
            String path = url.getPath();
            query = url.getQuery();
            ref = url.getRef();
            str2 = str6;
            str3 = path;
            i3 = i;
        }
        int i8 = i3;
        String str7 = ref;
        String str8 = query;
        String str9 = str3;
        while (i8 < i2) {
            switch (str.charAt(i8)) {
                case '#':
                    findFirstOf = i2;
                    str4 = str.substring(i8 + 1, findFirstOf);
                    break;
                case '?':
                    findFirstOf = UrlUtils.findFirstOf(str, "#", i8, i2);
                    str8 = str.substring(i8 + 1, findFirstOf);
                    str4 = null;
                    break;
                default:
                    findFirstOf = UrlUtils.findFirstOf(str, "?#", i8, i2);
                    str9 = relativePath(str9, str.substring(i8, findFirstOf));
                    str8 = null;
                    str4 = null;
                    break;
            }
            i8 = findFirstOf;
            str7 = str4;
        }
        String str10 = str9;
        if (str9 == null) {
            str10 = "";
        }
        setURL(url, url.getProtocol(), str2, port, authority, userInfo, UrlUtils.authoritySafePath(authority, str10), str8, str7);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean sameFile(URL url, URL url2) {
        return Objects.equal(url.getProtocol(), url2.getProtocol()) && hostsEqual(url, url2) && url.getEffectivePort() == url2.getEffectivePort() && Objects.equal(url.getFile(), url2.getFile());
    }

    @Deprecated
    protected void setURL(URL url, String str, String str2, int i, String str3, String str4) {
        if (this != url.streamHandler) {
            throw new SecurityException();
        }
        url.set(str, str2, i, str3, str4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setURL(URL url, String str, String str2, int i, String str3, String str4, String str5, String str6, String str7) {
        if (this != url.streamHandler) {
            throw new SecurityException();
        }
        url.set(str, str2, i, str3, str4, str5, str6, str7);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String toExternalForm(URL url) {
        return toExternalForm(url, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String toExternalForm(URL url, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append(url.getProtocol());
        sb.append(':');
        String authority = url.getAuthority();
        if (authority != null) {
            sb.append("//");
            if (z) {
                URI.AUTHORITY_ENCODER.appendPartiallyEncoded(sb, authority);
            } else {
                sb.append(authority);
            }
        }
        String file = url.getFile();
        if (file != null) {
            if (z) {
                URI.FILE_AND_QUERY_ENCODER.appendPartiallyEncoded(sb, file);
            } else {
                sb.append(file);
            }
        }
        String ref = url.getRef();
        if (ref != null) {
            sb.append('#');
            if (z) {
                URI.ALL_LEGAL_ENCODER.appendPartiallyEncoded(sb, ref);
            } else {
                sb.append(ref);
            }
        }
        return sb.toString();
    }
}
