package android.net.http;

import com.huawei.hms.ads.fw;
import java.util.Locale;

/* loaded from: source-9557208-dex2jar.jar:android/net/http/HttpAuthHeader.class */
public class HttpAuthHeader {
    private static final String ALGORITHM_TOKEN = "algorithm";
    public static final int BASIC = 1;
    public static final String BASIC_TOKEN = "Basic";
    public static final int DIGEST = 2;
    public static final String DIGEST_TOKEN = "Digest";
    private static final String NONCE_TOKEN = "nonce";
    private static final String OPAQUE_TOKEN = "opaque";
    private static final String QOP_TOKEN = "qop";
    private static final String REALM_TOKEN = "realm";
    private static final String STALE_TOKEN = "stale";
    public static final int UNKNOWN = 0;
    private String mAlgorithm;
    private boolean mIsProxy;
    private String mNonce;
    private String mOpaque;
    private String mPassword;
    private String mQop;
    private String mRealm;
    private int mScheme;
    private boolean mStale;
    private String mUsername;

    public HttpAuthHeader(String str) {
        if (str != null) {
            parseHeader(str);
        }
    }

    private void parseHeader(String str) {
        String parseScheme;
        if (str == null || (parseScheme = parseScheme(str)) == null || this.mScheme == 0) {
            return;
        }
        parseParameters(parseScheme);
    }

    private void parseParameter(String str) {
        int indexOf;
        if (str == null || (indexOf = str.indexOf(61)) < 0) {
            return;
        }
        String trim = str.substring(0, indexOf).trim();
        String trimDoubleQuotesIfAny = trimDoubleQuotesIfAny(str.substring(indexOf + 1).trim());
        if (trim.equalsIgnoreCase(REALM_TOKEN)) {
            this.mRealm = trimDoubleQuotesIfAny;
        } else if (this.mScheme == 2) {
            parseParameter(trim, trimDoubleQuotesIfAny);
        }
    }

    private void parseParameter(String str, String str2) {
        if (str == null || str2 == null) {
            return;
        }
        if (str.equalsIgnoreCase(NONCE_TOKEN)) {
            this.mNonce = str2;
        } else if (str.equalsIgnoreCase(STALE_TOKEN)) {
            parseStale(str2);
        } else if (str.equalsIgnoreCase(OPAQUE_TOKEN)) {
            this.mOpaque = str2;
        } else if (str.equalsIgnoreCase(QOP_TOKEN)) {
            this.mQop = str2.toLowerCase(Locale.ROOT);
        } else if (str.equalsIgnoreCase("algorithm")) {
            this.mAlgorithm = str2.toLowerCase(Locale.ROOT);
        }
    }

    private void parseParameters(String str) {
        int indexOf;
        if (str != null) {
            do {
                indexOf = str.indexOf(44);
                if (indexOf < 0) {
                    parseParameter(str);
                } else {
                    parseParameter(str.substring(0, indexOf));
                    str = str.substring(indexOf + 1);
                }
            } while (indexOf >= 0);
        }
    }

    private String parseScheme(String str) {
        int indexOf;
        if (str == null || (indexOf = str.indexOf(32)) < 0) {
            return null;
        }
        String trim = str.substring(0, indexOf).trim();
        if (trim.equalsIgnoreCase(DIGEST_TOKEN)) {
            this.mScheme = 2;
            this.mAlgorithm = "md5";
        } else if (trim.equalsIgnoreCase(BASIC_TOKEN)) {
            this.mScheme = 1;
        }
        return str.substring(indexOf + 1);
    }

    private void parseStale(String str) {
        if (str == null || !str.equalsIgnoreCase(fw.Code)) {
            return;
        }
        this.mStale = true;
    }

    private static String trimDoubleQuotesIfAny(String str) {
        String str2 = str;
        if (str != null) {
            int length = str.length();
            str2 = str;
            if (length > 2) {
                str2 = str;
                if (str.charAt(0) == '\"') {
                    str2 = str;
                    if (str.charAt(length - 1) == '\"') {
                        str2 = str.substring(1, length - 1);
                    }
                }
            }
        }
        return str2;
    }

    public String getAlgorithm() {
        return this.mAlgorithm;
    }

    public String getNonce() {
        return this.mNonce;
    }

    public String getOpaque() {
        return this.mOpaque;
    }

    public String getPassword() {
        return this.mPassword;
    }

    public String getQop() {
        return this.mQop;
    }

    public String getRealm() {
        return this.mRealm;
    }

    public int getScheme() {
        return this.mScheme;
    }

    public boolean getStale() {
        return this.mStale;
    }

    public String getUsername() {
        return this.mUsername;
    }

    public boolean isBasic() {
        return this.mScheme == 1;
    }

    public boolean isDigest() {
        return this.mScheme == 2;
    }

    public boolean isProxy() {
        return this.mIsProxy;
    }

    public boolean isSupportedScheme() {
        if (this.mRealm != null) {
            if (this.mScheme == 1) {
                return true;
            }
            if (this.mScheme == 2 && this.mAlgorithm.equals("md5")) {
                return this.mQop == null || this.mQop.equals("auth");
            }
            return false;
        }
        return false;
    }

    public void setPassword(String str) {
        this.mPassword = str;
    }

    public void setProxy() {
        this.mIsProxy = true;
    }

    public void setUsername(String str) {
        this.mUsername = str;
    }
}
