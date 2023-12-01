package java.net;

import android.security.KeyChain;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.cdo.oaps.ad.OapsWrapper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import libcore.net.http.HttpDate;
import libcore.util.Objects;

/* loaded from: source-2895416-dex2jar.jar:java/net/HttpCookie.class */
public final class HttpCookie implements Cloneable {
    private static final Set<String> RESERVED_NAMES = new HashSet();
    private String comment;
    private String commentURL;
    private boolean discard;
    private String domain;
    private boolean httpOnly;
    private final String name;
    private String path;
    private String portList;
    private boolean secure;
    private String value;
    private long maxAge = -1;
    private int version = 1;

    /* loaded from: source-2895416-dex2jar.jar:java/net/HttpCookie$CookieParser.class */
    static class CookieParser {
        private static final String ATTRIBUTE_NAME_TERMINATORS = ",;= \t";
        private static final String WHITESPACE = " \t";
        private final String input;
        private final String inputLowerCase;
        private int pos = 0;
        boolean hasExpires = false;
        boolean hasMaxAge = false;
        boolean hasVersion = false;

        CookieParser(String str) {
            this.input = str;
            this.inputLowerCase = str.toLowerCase(Locale.US);
        }

        private int find(String str) {
            int i = this.pos;
            while (true) {
                int i2 = i;
                if (i2 >= this.input.length()) {
                    return this.input.length();
                }
                if (str.indexOf(this.input.charAt(i2)) != -1) {
                    return i2;
                }
                i = i2 + 1;
            }
        }

        private String readAttributeName(boolean z) {
            skipWhitespace();
            int find = find(ATTRIBUTE_NAME_TERMINATORS);
            String substring = this.pos < find ? (z ? this.inputLowerCase : this.input).substring(this.pos, find) : null;
            this.pos = find;
            return substring;
        }

        private String readAttributeValue(String str) {
            skipWhitespace();
            if (this.pos >= this.input.length() || !(this.input.charAt(this.pos) == '\"' || this.input.charAt(this.pos) == '\'')) {
                int find = find(str);
                String substring = this.input.substring(this.pos, find);
                this.pos = find;
                return substring;
            }
            String str2 = this.input;
            int i = this.pos;
            this.pos = i + 1;
            int indexOf = this.input.indexOf(str2.charAt(i), this.pos);
            if (indexOf == -1) {
                throw new IllegalArgumentException("Unterminated string literal in " + this.input);
            }
            String substring2 = this.input.substring(this.pos, indexOf);
            this.pos = indexOf + 1;
            return substring2;
        }

        private boolean readEqualsSign() {
            skipWhitespace();
            if (this.pos >= this.input.length() || this.input.charAt(this.pos) != '=') {
                return false;
            }
            this.pos++;
            return true;
        }

        private void setAttribute(HttpCookie httpCookie, String str, String str2) {
            if (str.equals("comment") && httpCookie.comment == null) {
                httpCookie.comment = str2;
            } else if (str.equals("commenturl") && httpCookie.commentURL == null) {
                httpCookie.commentURL = str2;
            } else if (str.equals("discard")) {
                httpCookie.discard = true;
            } else if (str.equals("domain") && httpCookie.domain == null) {
                httpCookie.domain = str2;
            } else if (str.equals("expires")) {
                this.hasExpires = true;
                if (httpCookie.maxAge == -1) {
                    Date parse = HttpDate.parse(str2);
                    if (parse != null) {
                        httpCookie.setExpires(parse);
                    } else {
                        httpCookie.maxAge = 0L;
                    }
                }
            } else if (str.equals("max-age") && httpCookie.maxAge == -1) {
                try {
                    long parseLong = Long.parseLong(str2);
                    this.hasMaxAge = true;
                    httpCookie.maxAge = parseLong;
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("Invalid max-age: " + str2);
                }
            } else if (str.equals(OapsWrapper.KEY_PATH) && httpCookie.path == null) {
                httpCookie.path = str2;
            } else if (str.equals(KeyChain.EXTRA_PORT) && httpCookie.portList == null) {
                if (str2 == null) {
                    str2 = "";
                }
                httpCookie.portList = str2;
            } else if (str.equals("secure")) {
                httpCookie.secure = true;
            } else if (str.equals("httponly")) {
                httpCookie.httpOnly = true;
            } else if (!str.equals("version") || this.hasVersion) {
            } else {
                httpCookie.version = Integer.parseInt(str2);
            }
        }

        private void skipWhitespace() {
            while (this.pos < this.input.length() && WHITESPACE.indexOf(this.input.charAt(this.pos)) != -1) {
                this.pos++;
            }
        }

        public List<HttpCookie> parse() {
            boolean z;
            ArrayList arrayList = new ArrayList(2);
            if (this.inputLowerCase.startsWith("set-cookie2:")) {
                this.pos += "set-cookie2:".length();
                z = false;
                this.hasVersion = true;
            } else {
                z = true;
                if (this.inputLowerCase.startsWith("set-cookie:")) {
                    this.pos += "set-cookie:".length();
                    z = true;
                }
            }
            while (true) {
                String readAttributeName = readAttributeName(false);
                if (readAttributeName == null) {
                    if (arrayList.isEmpty()) {
                        throw new IllegalArgumentException("No cookies in " + this.input);
                    }
                    return arrayList;
                } else if (!readEqualsSign()) {
                    throw new IllegalArgumentException("Expected '=' after " + readAttributeName + " in " + this.input);
                } else {
                    HttpCookie httpCookie = new HttpCookie(readAttributeName, readAttributeValue(z ? ";" : ",;"));
                    httpCookie.version = z ? 0 : 1;
                    arrayList.add(httpCookie);
                    while (true) {
                        skipWhitespace();
                        if (this.pos == this.input.length()) {
                            break;
                        } else if (this.input.charAt(this.pos) == ',') {
                            this.pos++;
                            break;
                        } else {
                            if (this.input.charAt(this.pos) == ';') {
                                this.pos++;
                            }
                            String readAttributeName2 = readAttributeName(true);
                            if (readAttributeName2 != null) {
                                String str = (z || "expires".equals(readAttributeName2) || KeyChain.EXTRA_PORT.equals(readAttributeName2)) ? ";" : ";,";
                                String str2 = null;
                                if (readEqualsSign()) {
                                    str2 = readAttributeValue(str);
                                }
                                setAttribute(httpCookie, readAttributeName2, str2);
                            }
                        }
                    }
                    if (this.hasExpires) {
                        httpCookie.version = 0;
                    } else if (this.hasMaxAge) {
                        httpCookie.version = 1;
                    }
                }
            }
        }
    }

    static {
        RESERVED_NAMES.add("comment");
        RESERVED_NAMES.add("commenturl");
        RESERVED_NAMES.add("discard");
        RESERVED_NAMES.add("domain");
        RESERVED_NAMES.add("expires");
        RESERVED_NAMES.add("httponly");
        RESERVED_NAMES.add("max-age");
        RESERVED_NAMES.add(OapsWrapper.KEY_PATH);
        RESERVED_NAMES.add(KeyChain.EXTRA_PORT);
        RESERVED_NAMES.add("secure");
        RESERVED_NAMES.add("version");
    }

    public HttpCookie(String str, String str2) {
        String trim = str.trim();
        if (!isValidName(trim)) {
            throw new IllegalArgumentException("Invalid name: " + str);
        }
        this.name = trim;
        this.value = str2;
    }

    private void appendAttribute(StringBuilder sb, String str, String str2) {
        if (str2 == null || sb == null) {
            return;
        }
        sb.append(";$");
        sb.append(str);
        sb.append("=\"");
        sb.append(str2);
        sb.append("\"");
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0036, code lost:
        if (java.net.InetAddress.isNumeric(r0) == false) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x006d, code lost:
        if (isFullyQualifiedDomainName(r0, 1) == false) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0093, code lost:
        if (isFullyQualifiedDomainName(r0, 1) == false) goto L34;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean domainMatches(java.lang.String r4, java.lang.String r5) {
        /*
            r0 = 1
            r7 = r0
            r0 = r4
            if (r0 == 0) goto La
            r0 = r5
            if (r0 != 0) goto Le
        La:
            r0 = 0
            r6 = r0
        Lc:
            r0 = r6
            return r0
        Le:
            r0 = r5
            java.util.Locale r1 = java.util.Locale.US
            java.lang.String r0 = r0.toLowerCase(r1)
            r5 = r0
            r0 = r4
            java.util.Locale r1 = java.util.Locale.US
            java.lang.String r0 = r0.toLowerCase(r1)
            r4 = r0
            r0 = r5
            r1 = r4
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L39
            r0 = r7
            r6 = r0
            r0 = r5
            r1 = 0
            boolean r0 = isFullyQualifiedDomainName(r0, r1)
            if (r0 != 0) goto Lc
            r0 = r7
            r6 = r0
            r0 = r5
            boolean r0 = java.net.InetAddress.isNumeric(r0)
            if (r0 != 0) goto Lc
        L39:
            r0 = r5
            r1 = 0
            boolean r0 = isFullyQualifiedDomainName(r0, r1)
            if (r0 != 0) goto L48
            r0 = r4
            java.lang.String r1 = ".local"
            boolean r0 = r0.equals(r1)
            return r0
        L48:
            r0 = r4
            int r0 = r0.length()
            r1 = r5
            int r1 = r1.length()
            r2 = 1
            int r1 = r1 + r2
            if (r0 != r1) goto L70
            r0 = r4
            java.lang.String r1 = "."
            boolean r0 = r0.startsWith(r1)
            if (r0 == 0) goto L70
            r0 = r4
            r1 = r5
            boolean r0 = r0.endsWith(r1)
            if (r0 == 0) goto L70
            r0 = r7
            r6 = r0
            r0 = r4
            r1 = 1
            boolean r0 = isFullyQualifiedDomainName(r0, r1)
            if (r0 != 0) goto Lc
        L70:
            r0 = r5
            int r0 = r0.length()
            r1 = r4
            int r1 = r1.length()
            if (r0 <= r1) goto La1
            r0 = r5
            r1 = r4
            boolean r0 = r0.endsWith(r1)
            if (r0 == 0) goto La1
            r0 = r4
            java.lang.String r1 = "."
            boolean r0 = r0.startsWith(r1)
            if (r0 == 0) goto L96
            r0 = r7
            r6 = r0
            r0 = r4
            r1 = 1
            boolean r0 = isFullyQualifiedDomainName(r0, r1)
            if (r0 != 0) goto Lc
        L96:
            r0 = r7
            r6 = r0
            r0 = r4
            java.lang.String r1 = ".local"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto Lc
        La1:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: java.net.HttpCookie.domainMatches(java.lang.String, java.lang.String):boolean");
    }

    private static boolean isFullyQualifiedDomainName(String str, int i) {
        int indexOf = str.indexOf(46, i + 1);
        return indexOf != -1 && indexOf < str.length() - 1;
    }

    private boolean isValidName(String str) {
        boolean z = (str.length() == 0 || str.startsWith("$") || RESERVED_NAMES.contains(str.toLowerCase(Locale.US))) ? false : true;
        boolean z2 = z;
        if (z) {
            int i = 0;
            while (true) {
                int i2 = i;
                z2 = z;
                if (i2 >= str.length()) {
                    break;
                }
                char charAt = str.charAt(i2);
                if (charAt < 0 || charAt >= 127 || charAt == ';' || charAt == ',' || (Character.isWhitespace(charAt) && charAt != ' ')) {
                    break;
                }
                i = i2 + 1;
            }
        }
        return z2;
    }

    private static String matchablePath(String str) {
        String str2;
        if (str == null) {
            str2 = BridgeUtil.SPLIT_MARK;
        } else {
            str2 = str;
            if (!str.endsWith(BridgeUtil.SPLIT_MARK)) {
                return str + BridgeUtil.SPLIT_MARK;
            }
        }
        return str2;
    }

    public static List<HttpCookie> parse(String str) {
        return new CookieParser(str).parse();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean pathMatches(HttpCookie httpCookie, URI uri) {
        return matchablePath(uri.getPath()).startsWith(matchablePath(httpCookie.getPath()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean portMatches(HttpCookie httpCookie, URI uri) {
        if (httpCookie.getPortlist() == null) {
            return true;
        }
        return Arrays.asList(httpCookie.getPortlist().split(",")).contains(Integer.toString(uri.getEffectivePort()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean secureMatches(HttpCookie httpCookie, URI uri) {
        return !httpCookie.getSecure() || "https".equalsIgnoreCase(uri.getScheme());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setExpires(Date date) {
        this.maxAge = (date.getTime() - System.currentTimeMillis()) / 1000;
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof HttpCookie) {
            HttpCookie httpCookie = (HttpCookie) obj;
            if (this.name.equalsIgnoreCase(httpCookie.getName())) {
                if (this.domain != null) {
                    if (!this.domain.equalsIgnoreCase(httpCookie.domain)) {
                        return false;
                    }
                } else if (httpCookie.domain != null) {
                    return false;
                }
                return Objects.equal(this.path, httpCookie.path);
            }
            return false;
        }
        return false;
    }

    public String getComment() {
        return this.comment;
    }

    public String getCommentURL() {
        return this.commentURL;
    }

    public boolean getDiscard() {
        return this.discard;
    }

    public String getDomain() {
        return this.domain;
    }

    public long getMaxAge() {
        return this.maxAge;
    }

    public String getName() {
        return this.name;
    }

    public String getPath() {
        return this.path;
    }

    public String getPortlist() {
        return this.portList;
    }

    public boolean getSecure() {
        return this.secure;
    }

    public String getValue() {
        return this.value;
    }

    public int getVersion() {
        return this.version;
    }

    public boolean hasExpired() {
        return this.maxAge != -1 && this.maxAge <= 0;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = this.name.toLowerCase(Locale.US).hashCode();
        int hashCode2 = this.domain == null ? 0 : this.domain.toLowerCase(Locale.US).hashCode();
        if (this.path != null) {
            i = this.path.hashCode();
        }
        return hashCode2 + hashCode + i;
    }

    public void setComment(String str) {
        this.comment = str;
    }

    public void setCommentURL(String str) {
        this.commentURL = str;
    }

    public void setDiscard(boolean z) {
        this.discard = z;
    }

    public void setDomain(String str) {
        this.domain = str == null ? null : str.toLowerCase(Locale.US);
    }

    public void setMaxAge(long j) {
        this.maxAge = j;
    }

    public void setPath(String str) {
        this.path = str;
    }

    public void setPortlist(String str) {
        this.portList = str;
    }

    public void setSecure(boolean z) {
        this.secure = z;
    }

    public void setValue(String str) {
        this.value = str;
    }

    public void setVersion(int i) {
        if (i != 0 && i != 1) {
            throw new IllegalArgumentException("Bad version: " + i);
        }
        this.version = i;
    }

    public String toString() {
        if (this.version == 0) {
            return this.name + "=" + this.value;
        }
        StringBuilder append = new StringBuilder().append(this.name).append("=").append("\"").append(this.value).append("\"");
        appendAttribute(append, "Path", this.path);
        appendAttribute(append, "Domain", this.domain);
        appendAttribute(append, "Port", this.portList);
        return append.toString();
    }
}
