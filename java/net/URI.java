package java.net;

import com.alipay.sdk.cons.b;
import com.android.internal.content.NativeLibraryHelper;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import io.grpc.internal.GrpcUtil;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Locale;
import libcore.net.UriCodec;
import libcore.net.url.UrlUtils;

/* loaded from: source-2895416-dex2jar.jar:java/net/URI.class */
public final class URI implements Comparable<URI>, Serializable {
    static final String PUNCTUATION = ",;:$&+=";
    static final String UNRESERVED = "_-!.~'()*";
    private static final long serialVersionUID = -6052424284110960213L;
    private transient boolean absolute;
    private transient String authority;
    private transient String fragment;
    private transient int hash;
    private transient String host;
    private transient boolean opaque;
    private transient String path;
    private transient int port;
    private transient String query;
    private transient String scheme;
    private transient String schemeSpecificPart;
    private transient boolean serverAuthority;
    private String string;
    private transient String userInfo;
    static final UriCodec USER_INFO_ENCODER = new PartEncoder("");
    static final UriCodec PATH_ENCODER = new PartEncoder("/@");
    static final UriCodec AUTHORITY_ENCODER = new PartEncoder("@[]");
    static final UriCodec FILE_AND_QUERY_ENCODER = new PartEncoder("/@?");
    static final UriCodec ALL_LEGAL_ENCODER = new PartEncoder("?/[]@");
    private static final UriCodec ASCII_ONLY = new UriCodec() { // from class: java.net.URI.1
        @Override // libcore.net.UriCodec
        protected boolean isRetained(char c) {
            return c <= 127;
        }
    };

    /* loaded from: source-2895416-dex2jar.jar:java/net/URI$PartEncoder.class */
    private static class PartEncoder extends UriCodec {
        private final String extraLegalCharacters;

        PartEncoder(String str) {
            this.extraLegalCharacters = str;
        }

        @Override // libcore.net.UriCodec
        protected boolean isRetained(char c) {
            if (URI.UNRESERVED.indexOf(c) == -1 && URI.PUNCTUATION.indexOf(c) == -1 && this.extraLegalCharacters.indexOf(c) == -1) {
                return (c <= 127 || Character.isSpaceChar(c) || Character.isISOControl(c)) ? false : true;
            }
            return true;
        }
    }

    private URI() {
        this.port = -1;
        this.serverAuthority = false;
        this.hash = -1;
    }

    public URI(String str) throws URISyntaxException {
        this.port = -1;
        this.serverAuthority = false;
        this.hash = -1;
        parseURI(str, false);
    }

    public URI(String str, String str2, String str3) throws URISyntaxException {
        this.port = -1;
        this.serverAuthority = false;
        this.hash = -1;
        StringBuilder sb = new StringBuilder();
        if (str != null) {
            sb.append(str);
            sb.append(':');
        }
        if (str2 != null) {
            ALL_LEGAL_ENCODER.appendEncoded(sb, str2);
        }
        if (str3 != null) {
            sb.append('#');
            ALL_LEGAL_ENCODER.appendEncoded(sb, str3);
        }
        parseURI(sb.toString(), false);
    }

    public URI(String str, String str2, String str3, int i, String str4, String str5, String str6) throws URISyntaxException {
        this.port = -1;
        this.serverAuthority = false;
        this.hash = -1;
        if (str == null && str2 == null && str3 == null && str4 == null && str5 == null && str6 == null) {
            this.path = "";
        } else if (str != null && str4 != null && !str4.isEmpty() && str4.charAt(0) != '/') {
            throw new URISyntaxException(str4, "Relative path");
        } else {
            StringBuilder sb = new StringBuilder();
            if (str != null) {
                sb.append(str);
                sb.append(':');
            }
            if (str2 != null || str3 != null || i != -1) {
                sb.append("//");
            }
            if (str2 != null) {
                USER_INFO_ENCODER.appendEncoded(sb, str2);
                sb.append('@');
            }
            if (str3 != null) {
                String str7 = str3;
                if (str3.indexOf(58) != -1) {
                    str7 = str3;
                    if (str3.indexOf(93) == -1) {
                        str7 = str3;
                        if (str3.indexOf(91) == -1) {
                            str7 = "[" + str3 + "]";
                        }
                    }
                }
                sb.append(str7);
            }
            if (i != -1) {
                sb.append(':');
                sb.append(i);
            }
            if (str4 != null) {
                PATH_ENCODER.appendEncoded(sb, str4);
            }
            if (str5 != null) {
                sb.append('?');
                ALL_LEGAL_ENCODER.appendEncoded(sb, str5);
            }
            if (str6 != null) {
                sb.append('#');
                ALL_LEGAL_ENCODER.appendEncoded(sb, str6);
            }
            parseURI(sb.toString(), true);
        }
    }

    public URI(String str, String str2, String str3, String str4) throws URISyntaxException {
        this(str, null, str2, -1, str3, null, str4);
    }

    public URI(String str, String str2, String str3, String str4, String str5) throws URISyntaxException {
        this.port = -1;
        this.serverAuthority = false;
        this.hash = -1;
        if (str != null && str3 != null && !str3.isEmpty() && str3.charAt(0) != '/') {
            throw new URISyntaxException(str3, "Relative path");
        }
        StringBuilder sb = new StringBuilder();
        if (str != null) {
            sb.append(str);
            sb.append(':');
        }
        if (str2 != null) {
            sb.append("//");
            AUTHORITY_ENCODER.appendEncoded(sb, str2);
        }
        if (str3 != null) {
            PATH_ENCODER.appendEncoded(sb, str3);
        }
        if (str4 != null) {
            sb.append('?');
            ALL_LEGAL_ENCODER.appendEncoded(sb, str4);
        }
        if (str5 != null) {
            sb.append('#');
            ALL_LEGAL_ENCODER.appendEncoded(sb, str5);
        }
        parseURI(sb.toString(), false);
    }

    private String convertHexToLowerCase(String str) {
        StringBuilder sb = new StringBuilder("");
        if (str.indexOf(37) == -1) {
            return str;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            int indexOf = str.indexOf(37, i2);
            if (indexOf == -1) {
                return sb.toString();
            }
            sb.append(str.substring(i2, indexOf + 1));
            sb.append(str.substring(indexOf + 1, indexOf + 3).toLowerCase(Locale.US));
            i = indexOf + 3;
        }
    }

    public static URI create(String str) {
        try {
            return new URI(str);
        } catch (URISyntaxException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    private String decode(String str) {
        if (str != null) {
            return UriCodec.decode(str);
        }
        return null;
    }

    private URI duplicate() {
        URI uri = new URI();
        uri.absolute = this.absolute;
        uri.authority = this.authority;
        uri.fragment = this.fragment;
        uri.host = this.host;
        uri.opaque = this.opaque;
        uri.path = this.path;
        uri.port = this.port;
        uri.query = this.query;
        uri.scheme = this.scheme;
        uri.schemeSpecificPart = this.schemeSpecificPart;
        uri.userInfo = this.userInfo;
        uri.serverAuthority = this.serverAuthority;
        return uri;
    }

    private boolean escapedEquals(String str, String str2) {
        if (str.length() != str2.length()) {
            return false;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            int indexOf = str.indexOf(37, i2);
            if (indexOf != str2.indexOf(37, i2)) {
                return false;
            }
            if (indexOf == -1) {
                return str.regionMatches(i2, str2, i2, str2.length() - i2);
            }
            if (!str.regionMatches(i2, str2, i2, indexOf - i2) || !str.regionMatches(true, indexOf + 1, str2, indexOf + 1, 2)) {
                return false;
            }
            i = indexOf + 3;
        }
    }

    public static int getEffectivePort(String str, int i) {
        if (i != -1) {
            return i;
        }
        if ("http".equalsIgnoreCase(str)) {
            return 80;
        }
        if (b.a.equalsIgnoreCase(str)) {
            return GrpcUtil.DEFAULT_PORT_SSL;
        }
        return -1;
    }

    private String getHashString() {
        StringBuilder sb = new StringBuilder();
        if (this.scheme != null) {
            sb.append(this.scheme.toLowerCase(Locale.US));
            sb.append(':');
        }
        if (this.opaque) {
            sb.append(this.schemeSpecificPart);
        } else {
            if (this.authority != null) {
                sb.append("//");
                if (this.host == null) {
                    sb.append(this.authority);
                } else {
                    if (this.userInfo != null) {
                        sb.append(this.userInfo + "@");
                    }
                    sb.append(this.host.toLowerCase(Locale.US));
                    if (this.port != -1) {
                        sb.append(":" + this.port);
                    }
                }
            }
            if (this.path != null) {
                sb.append(this.path);
            }
            if (this.query != null) {
                sb.append('?');
                sb.append(this.query);
            }
        }
        if (this.fragment != null) {
            sb.append('#');
            sb.append(this.fragment);
        }
        return convertHexToLowerCase(sb.toString());
    }

    private boolean isValidDomainName(String str) {
        char charAt;
        try {
            UriCodec.validateSimple(str, "_-.");
            String str2 = null;
            String[] split = str.split("\\.");
            int length = split.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    if (str2 != null) {
                        return str2.equals(str) || (charAt = str2.charAt(0)) < '0' || charAt > '9';
                    }
                    return false;
                }
                str2 = split[i2];
                if (str2.startsWith(NativeLibraryHelper.CLEAR_ABI_OVERRIDE) || str2.endsWith(NativeLibraryHelper.CLEAR_ABI_OVERRIDE)) {
                    return false;
                }
                i = i2 + 1;
            }
        } catch (URISyntaxException e) {
            return false;
        }
    }

    private boolean isValidHost(boolean z, String str) throws URISyntaxException {
        if (str.startsWith("[")) {
            if (str.endsWith("]")) {
                if (InetAddress.isNumeric(str)) {
                    return true;
                }
                throw new URISyntaxException(str, "Malformed IPv6 address");
            }
            throw new URISyntaxException(str, "Expected a closing square bracket for IPv6 address", 0);
        } else if (str.indexOf(91) == -1 && str.indexOf(93) == -1) {
            int lastIndexOf = str.lastIndexOf(46);
            if (lastIndexOf < 0 || lastIndexOf == str.length() - 1 || !Character.isDigit(str.charAt(lastIndexOf + 1))) {
                if (isValidDomainName(str)) {
                    return true;
                }
                if (z) {
                    throw new URISyntaxException(str, "Illegal character in host name", 0);
                }
                return false;
            }
            try {
                if (InetAddress.parseNumericAddress(str) instanceof Inet4Address) {
                    return true;
                }
            } catch (IllegalArgumentException e) {
            }
            if (z) {
                throw new URISyntaxException(str, "Malformed IPv4 address", 0);
            }
            return false;
        } else {
            throw new URISyntaxException(str, "Illegal character in host name", 0);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x002c, code lost:
        if (r0 < r0) goto L7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String normalize(java.lang.String r4, boolean r5) {
        /*
            r3 = this;
            r0 = r4
            r1 = r5
            java.lang.String r0 = libcore.net.url.UrlUtils.canonicalizePath(r0, r1)
            r8 = r0
            r0 = r8
            r1 = 58
            int r0 = r0.indexOf(r1)
            r6 = r0
            r0 = r8
            r4 = r0
            r0 = r6
            r1 = -1
            if (r0 == r1) goto L45
            r0 = r8
            r1 = 47
            int r0 = r0.indexOf(r1)
            r7 = r0
            r0 = r7
            r1 = -1
            if (r0 == r1) goto L2f
            r0 = r8
            r4 = r0
            r0 = r6
            r1 = r7
            if (r0 >= r1) goto L45
        L2f:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r0
            r1.<init>()
            java.lang.String r1 = "./"
            java.lang.StringBuilder r0 = r0.append(r1)
            r1 = r8
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = r0.toString()
            r4 = r0
        L45:
            r0 = r4
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: java.net.URI.normalize(java.lang.String, boolean):java.lang.String");
    }

    private void parseAuthority(boolean z) throws URISyntaxException {
        String str;
        if (this.authority == null) {
            return;
        }
        String str2 = null;
        String str3 = this.authority;
        int indexOf = str3.indexOf(64);
        int i = 0;
        String str4 = str3;
        if (indexOf != -1) {
            str2 = str3.substring(0, indexOf);
            validateUserInfo(this.authority, str2, 0);
            str4 = str3.substring(indexOf + 1);
            i = indexOf + 1;
        }
        int lastIndexOf = str4.lastIndexOf(58);
        int indexOf2 = str4.indexOf(93);
        int i2 = -1;
        if (lastIndexOf == -1 || indexOf2 >= lastIndexOf) {
            str = str4;
        } else {
            String substring = str4.substring(0, lastIndexOf);
            str = substring;
            if (lastIndexOf < str4.length() - 1) {
                try {
                    char charAt = str4.charAt(lastIndexOf + 1);
                    if (charAt < '0' || charAt > '9') {
                        if (z) {
                            throw new URISyntaxException(this.authority, "Invalid port number", i + lastIndexOf + 1);
                        }
                        return;
                    }
                    i2 = Integer.parseInt(str4.substring(lastIndexOf + 1));
                    str = substring;
                } catch (NumberFormatException e) {
                    if (z) {
                        throw new URISyntaxException(this.authority, "Invalid port number", i + lastIndexOf + 1);
                    }
                    return;
                }
            }
        }
        if (str.isEmpty()) {
            if (z) {
                throw new URISyntaxException(this.authority, "Expected host", i);
            }
        } else if (isValidHost(z, str)) {
            this.userInfo = str2;
            this.host = str;
            this.port = i2;
            this.serverAuthority = true;
        }
    }

    private void parseURI(String str, boolean z) throws URISyntaxException {
        int i;
        this.string = str;
        int findFirstOf = UrlUtils.findFirstOf(str, "#", 0, str.length());
        if (findFirstOf < str.length()) {
            this.fragment = ALL_LEGAL_ENCODER.validate(str, findFirstOf + 1, str.length(), "fragment");
        }
        int findFirstOf2 = UrlUtils.findFirstOf(str, ":", 0, findFirstOf);
        if (findFirstOf2 < UrlUtils.findFirstOf(str, "/?#", 0, findFirstOf)) {
            this.absolute = true;
            this.scheme = validateScheme(str, findFirstOf2);
            int i2 = findFirstOf2 + 1;
            if (i2 == findFirstOf) {
                throw new URISyntaxException(str, "Scheme-specific part expected", i2);
            }
            i = i2;
            if (!str.regionMatches(i2, BridgeUtil.SPLIT_MARK, 0, 1)) {
                this.opaque = true;
                this.schemeSpecificPart = ALL_LEGAL_ENCODER.validate(str, i2, findFirstOf, "scheme specific part");
                return;
            }
        } else {
            this.absolute = false;
            i = 0;
        }
        this.opaque = false;
        this.schemeSpecificPart = str.substring(i, findFirstOf);
        if (str.regionMatches(i, "//", 0, 2)) {
            int i3 = i + 2;
            int findFirstOf3 = UrlUtils.findFirstOf(str, "/?", i3, findFirstOf);
            if (i3 == str.length()) {
                throw new URISyntaxException(str, "Authority expected", str.length());
            }
            i = findFirstOf3;
            if (i3 < findFirstOf3) {
                this.authority = AUTHORITY_ENCODER.validate(str, i3, findFirstOf3, "authority");
                i = findFirstOf3;
            }
        }
        int findFirstOf4 = UrlUtils.findFirstOf(str, "?", i, findFirstOf);
        this.path = PATH_ENCODER.validate(str, i, findFirstOf4, "path");
        if (findFirstOf4 < findFirstOf) {
            this.query = ALL_LEGAL_ENCODER.validate(str, findFirstOf4 + 1, findFirstOf, "query");
        }
        parseAuthority(z);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        try {
            parseURI(this.string, false);
        } catch (URISyntaxException e) {
            throw new IOException(e.toString());
        }
    }

    private void setSchemeSpecificPart() {
        StringBuilder sb = new StringBuilder();
        if (this.authority != null) {
            sb.append("//" + this.authority);
        }
        if (this.path != null) {
            sb.append(this.path);
        }
        if (this.query != null) {
            sb.append("?" + this.query);
        }
        this.schemeSpecificPart = sb.toString();
        this.string = null;
    }

    private String validateScheme(String str, int i) throws URISyntaxException {
        if (i == 0) {
            throw new URISyntaxException(str, "Scheme expected", 0);
        }
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= i) {
                return str.substring(0, i);
            }
            if (!UrlUtils.isValidSchemeChar(i3, str.charAt(i3))) {
                throw new URISyntaxException(str, "Illegal character in scheme", 0);
            }
            i2 = i3 + 1;
        }
    }

    private void validateUserInfo(String str, String str2, int i) throws URISyntaxException {
        int i2;
        int i3 = 0;
        while (true) {
            i2 = i3;
            if (i2 >= str2.length()) {
                return;
            }
            char charAt = str2.charAt(i2);
            if (charAt == ']' || charAt == '[') {
                break;
            }
            i3 = i2 + 1;
        }
        throw new URISyntaxException(str, "Illegal character in userInfo", i + i2);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException, ClassNotFoundException {
        toString();
        objectOutputStream.defaultWriteObject();
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x003f, code lost:
        if (r0 == 0) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x007f, code lost:
        if (r0 == 0) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x010b, code lost:
        if (r0 == 0) goto L89;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x0144, code lost:
        if (r0 == 0) goto L97;
     */
    @Override // java.lang.Comparable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int compareTo(java.net.URI r4) {
        /*
            Method dump skipped, instructions count: 459
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: java.net.URI.compareTo(java.net.URI):int");
    }

    public boolean equals(Object obj) {
        if (obj instanceof URI) {
            URI uri = (URI) obj;
            if (uri.fragment != null || this.fragment == null) {
                if (uri.fragment == null || this.fragment != null) {
                    if (uri.fragment == null || this.fragment == null || escapedEquals(uri.fragment, this.fragment)) {
                        if (uri.scheme != null || this.scheme == null) {
                            if (uri.scheme == null || this.scheme != null) {
                                if (uri.scheme == null || this.scheme == null || uri.scheme.equalsIgnoreCase(this.scheme)) {
                                    if (uri.opaque && this.opaque) {
                                        return escapedEquals(uri.schemeSpecificPart, this.schemeSpecificPart);
                                    }
                                    if (uri.opaque || this.opaque || !escapedEquals(this.path, uri.path)) {
                                        return false;
                                    }
                                    if (uri.query == null || this.query != null) {
                                        if (uri.query != null || this.query == null) {
                                            if (uri.query == null || this.query == null || escapedEquals(uri.query, this.query)) {
                                                if (uri.authority == null || this.authority != null) {
                                                    if (uri.authority != null || this.authority == null) {
                                                        if (uri.authority == null || this.authority == null) {
                                                            return true;
                                                        }
                                                        if (uri.host == null || this.host != null) {
                                                            if (uri.host != null || this.host == null) {
                                                                if (uri.host == null && this.host == null) {
                                                                    return escapedEquals(uri.authority, this.authority);
                                                                }
                                                                if (this.host.equalsIgnoreCase(uri.host) && this.port == uri.port) {
                                                                    if (uri.userInfo == null || this.userInfo != null) {
                                                                        if (uri.userInfo != null || this.userInfo == null) {
                                                                            if (uri.userInfo == null || this.userInfo == null) {
                                                                                return true;
                                                                            }
                                                                            return escapedEquals(this.userInfo, uri.userInfo);
                                                                        }
                                                                        return false;
                                                                    }
                                                                    return false;
                                                                }
                                                                return false;
                                                            }
                                                            return false;
                                                        }
                                                        return false;
                                                    }
                                                    return false;
                                                }
                                                return false;
                                            }
                                            return false;
                                        }
                                        return false;
                                    }
                                    return false;
                                }
                                return false;
                            }
                            return false;
                        }
                        return false;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    public String getAuthority() {
        return decode(this.authority);
    }

    public int getEffectivePort() {
        return getEffectivePort(this.scheme, this.port);
    }

    public String getFragment() {
        return decode(this.fragment);
    }

    public String getHost() {
        return this.host;
    }

    public String getPath() {
        return decode(this.path);
    }

    public int getPort() {
        return this.port;
    }

    public String getQuery() {
        return decode(this.query);
    }

    public String getRawAuthority() {
        return this.authority;
    }

    public String getRawFragment() {
        return this.fragment;
    }

    public String getRawPath() {
        return this.path;
    }

    public String getRawQuery() {
        return this.query;
    }

    public String getRawSchemeSpecificPart() {
        return this.schemeSpecificPart;
    }

    public String getRawUserInfo() {
        return this.userInfo;
    }

    public String getScheme() {
        return this.scheme;
    }

    public String getSchemeSpecificPart() {
        return decode(this.schemeSpecificPart);
    }

    public String getUserInfo() {
        return decode(this.userInfo);
    }

    public int hashCode() {
        if (this.hash == -1) {
            this.hash = getHashString().hashCode();
        }
        return this.hash;
    }

    public boolean isAbsolute() {
        return this.absolute;
    }

    public boolean isOpaque() {
        return this.opaque;
    }

    public URI normalize() {
        if (!this.opaque) {
            String normalize = normalize(this.path, false);
            if (!this.path.equals(normalize)) {
                URI duplicate = duplicate();
                duplicate.path = normalize;
                duplicate.setSchemeSpecificPart();
                return duplicate;
            }
        }
        return this;
    }

    public URI parseServerAuthority() throws URISyntaxException {
        if (!this.serverAuthority) {
            parseAuthority(true);
        }
        return this;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x001b, code lost:
        if (r6.scheme == null) goto L9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0029, code lost:
        if (r6.authority == null) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0060, code lost:
        if (r0.startsWith(r7) != false) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.net.URI relativize(java.net.URI r6) {
        /*
            r5 = this;
            r0 = r6
            boolean r0 = r0.opaque
            if (r0 != 0) goto Le
            r0 = r5
            boolean r0 = r0.opaque
            if (r0 == 0) goto L10
        Le:
            r0 = r6
            return r0
        L10:
            r0 = r5
            java.lang.String r0 = r0.scheme
            if (r0 != 0) goto L8e
            r0 = r6
            java.lang.String r0 = r0.scheme
            if (r0 != 0) goto Le
        L1e:
            r0 = r5
            java.lang.String r0 = r0.authority
            if (r0 != 0) goto L9e
            r0 = r6
            java.lang.String r0 = r0.authority
            if (r0 != 0) goto Le
        L2c:
            r0 = r5
            r1 = r5
            java.lang.String r1 = r1.path
            r2 = 0
            java.lang.String r0 = r0.normalize(r1, r2)
            r8 = r0
            r0 = r5
            r1 = r6
            java.lang.String r1 = r1.path
            r2 = 0
            java.lang.String r0 = r0.normalize(r1, r2)
            r9 = r0
            r0 = r8
            r7 = r0
            r0 = r8
            r1 = r9
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L63
            r0 = r8
            r1 = 0
            r2 = r8
            r3 = 47
            int r2 = r2.lastIndexOf(r3)
            r3 = 1
            int r2 = r2 + r3
            java.lang.String r0 = r0.substring(r1, r2)
            r7 = r0
            r0 = r9
            r1 = r7
            boolean r0 = r0.startsWith(r1)
            if (r0 == 0) goto Le
        L63:
            java.net.URI r0 = new java.net.URI
            r1 = r0
            r1.<init>()
            r8 = r0
            r0 = r8
            r1 = r6
            java.lang.String r1 = r1.fragment
            r0.fragment = r1
            r0 = r8
            r1 = r6
            java.lang.String r1 = r1.query
            r0.query = r1
            r0 = r8
            r1 = r9
            r2 = r7
            int r2 = r2.length()
            java.lang.String r1 = r1.substring(r2)
            r0.path = r1
            r0 = r8
            r0.setSchemeSpecificPart()
            r0 = r8
            return r0
        L8e:
            r0 = r5
            java.lang.String r0 = r0.scheme
            r1 = r6
            java.lang.String r1 = r1.scheme
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L1e
            r0 = r6
            return r0
        L9e:
            r0 = r5
            java.lang.String r0 = r0.authority
            r1 = r6
            java.lang.String r1 = r1.authority
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L2c
            r0 = r6
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: java.net.URI.relativize(java.net.URI):java.net.URI");
    }

    public URI resolve(String str) {
        return resolve(create(str));
    }

    public URI resolve(URI uri) {
        String str;
        if (uri.absolute || this.opaque) {
            return uri;
        }
        if (uri.authority != null) {
            URI duplicate = uri.duplicate();
            duplicate.scheme = this.scheme;
            duplicate.absolute = this.absolute;
            return duplicate;
        } else if (uri.path.isEmpty() && uri.scheme == null && uri.query == null) {
            URI duplicate2 = duplicate();
            duplicate2.fragment = uri.fragment;
            return duplicate2;
        } else {
            URI duplicate3 = duplicate();
            duplicate3.fragment = uri.fragment;
            duplicate3.query = uri.query;
            if (uri.path.startsWith(BridgeUtil.SPLIT_MARK)) {
                str = uri.path;
            } else if (uri.path.isEmpty()) {
                str = this.path;
            } else {
                str = this.path.substring(0, this.path.lastIndexOf(47) + 1) + uri.path;
            }
            duplicate3.path = UrlUtils.authoritySafePath(duplicate3.authority, normalize(str, true));
            duplicate3.setSchemeSpecificPart();
            return duplicate3;
        }
    }

    public String toASCIIString() {
        StringBuilder sb = new StringBuilder();
        ASCII_ONLY.appendEncoded(sb, toString());
        return sb.toString();
    }

    public String toString() {
        if (this.string != null) {
            return this.string;
        }
        StringBuilder sb = new StringBuilder();
        if (this.scheme != null) {
            sb.append(this.scheme);
            sb.append(':');
        }
        if (this.opaque) {
            sb.append(this.schemeSpecificPart);
        } else {
            if (this.authority != null) {
                sb.append("//");
                sb.append(this.authority);
            }
            if (this.path != null) {
                sb.append(this.path);
            }
            if (this.query != null) {
                sb.append('?');
                sb.append(this.query);
            }
        }
        if (this.fragment != null) {
            sb.append('#');
            sb.append(this.fragment);
        }
        this.string = sb.toString();
        return this.string;
    }

    public URL toURL() throws MalformedURLException {
        if (this.absolute) {
            return new URL(toString());
        }
        throw new IllegalArgumentException("URI is not absolute: " + toString());
    }
}
