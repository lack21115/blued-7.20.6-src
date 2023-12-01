package android.net;

import com.blued.das.live.LiveProtos;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: source-9557208-dex2jar.jar:android/net/WebAddress.class */
public class WebAddress {
    static final int MATCH_GROUP_AUTHORITY = 2;
    static final int MATCH_GROUP_HOST = 3;
    static final int MATCH_GROUP_PATH = 5;
    static final int MATCH_GROUP_PORT = 4;
    static final int MATCH_GROUP_SCHEME = 1;
    static Pattern sAddressPattern = Pattern.compile("(?:(http|https|file)\\:\\/\\/)?(?:([-A-Za-z0-9$_.+!*'(),;?&=]+(?:\\:[-A-Za-z0-9$_.+!*'(),;?&=]+)?)@)?([a-zA-Z0-9 -\ud7ff豈-\ufdcfﷰ-\uffef%_-][a-zA-Z0-9 -\ud7ff豈-\ufdcfﷰ-\uffef%_\\.-]*|\\[[0-9a-fA-F:\\.]+\\])?(?:\\:([0-9]*))?(\\/?[^#]*)?.*", 2);
    private String mAuthInfo;
    private String mHost;
    private String mPath;
    private int mPort;
    private String mScheme;

    public WebAddress(String str) throws ParseException {
        if (str == null) {
            throw new NullPointerException();
        }
        this.mScheme = "";
        this.mHost = "";
        this.mPort = -1;
        this.mPath = "/";
        this.mAuthInfo = "";
        Matcher matcher = sAddressPattern.matcher(str);
        if (!matcher.matches()) {
            throw new ParseException("Bad address");
        }
        String group = matcher.group(1);
        if (group != null) {
            this.mScheme = group.toLowerCase(Locale.ROOT);
        }
        String group2 = matcher.group(2);
        if (group2 != null) {
            this.mAuthInfo = group2;
        }
        String group3 = matcher.group(3);
        if (group3 != null) {
            this.mHost = group3;
        }
        String group4 = matcher.group(4);
        if (group4 != null && group4.length() > 0) {
            try {
                this.mPort = Integer.parseInt(group4);
            } catch (NumberFormatException e) {
                throw new ParseException("Bad port");
            }
        }
        String group5 = matcher.group(5);
        if (group5 != null && group5.length() > 0) {
            if (group5.charAt(0) == '/') {
                this.mPath = group5;
            } else {
                this.mPath = "/" + group5;
            }
        }
        if (this.mPort == 443 && this.mScheme.equals("")) {
            this.mScheme = "https";
        } else if (this.mPort == -1) {
            if (this.mScheme.equals("https")) {
                this.mPort = LiveProtos.Event.LIVE_CHALLENGE_PK_EXPLAIN_CLICK_VALUE;
            } else {
                this.mPort = 80;
            }
        }
        if (this.mScheme.equals("")) {
            this.mScheme = "http";
        }
    }

    public String getAuthInfo() {
        return this.mAuthInfo;
    }

    public String getHost() {
        return this.mHost;
    }

    public String getPath() {
        return this.mPath;
    }

    public int getPort() {
        return this.mPort;
    }

    public String getScheme() {
        return this.mScheme;
    }

    public void setAuthInfo(String str) {
        this.mAuthInfo = str;
    }

    public void setHost(String str) {
        this.mHost = str;
    }

    public void setPath(String str) {
        this.mPath = str;
    }

    public void setPort(int i) {
        this.mPort = i;
    }

    public void setScheme(String str) {
        this.mScheme = str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x002f, code lost:
        if (r3.mScheme.equals("http") != false) goto L5;
     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0059  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String toString() {
        /*
            r3 = this;
            java.lang.String r0 = ""
            r5 = r0
            r0 = r3
            int r0 = r0.mPort
            r1 = 443(0x1bb, float:6.21E-43)
            if (r0 == r1) goto L19
            r0 = r3
            java.lang.String r0 = r0.mScheme
            java.lang.String r1 = "https"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L32
        L19:
            r0 = r5
            r4 = r0
            r0 = r3
            int r0 = r0.mPort
            r1 = 80
            if (r0 == r1) goto L4c
            r0 = r5
            r4 = r0
            r0 = r3
            java.lang.String r0 = r0.mScheme
            java.lang.String r1 = "http"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L4c
        L32:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r0
            r1.<init>()
            java.lang.String r1 = ":"
            java.lang.StringBuilder r0 = r0.append(r1)
            r1 = r3
            int r1 = r1.mPort
            java.lang.String r1 = java.lang.Integer.toString(r1)
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = r0.toString()
            r4 = r0
        L4c:
            java.lang.String r0 = ""
            r5 = r0
            r0 = r3
            java.lang.String r0 = r0.mAuthInfo
            int r0 = r0.length()
            if (r0 <= 0) goto L70
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r0
            r1.<init>()
            r1 = r3
            java.lang.String r1 = r1.mAuthInfo
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r1 = "@"
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = r0.toString()
            r5 = r0
        L70:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r0
            r1.<init>()
            r1 = r3
            java.lang.String r1 = r1.mScheme
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r1 = "://"
            java.lang.StringBuilder r0 = r0.append(r1)
            r1 = r5
            java.lang.StringBuilder r0 = r0.append(r1)
            r1 = r3
            java.lang.String r1 = r1.mHost
            java.lang.StringBuilder r0 = r0.append(r1)
            r1 = r4
            java.lang.StringBuilder r0 = r0.append(r1)
            r1 = r3
            java.lang.String r1 = r1.mPath
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = r0.toString()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: android.net.WebAddress.toString():java.lang.String");
    }
}
