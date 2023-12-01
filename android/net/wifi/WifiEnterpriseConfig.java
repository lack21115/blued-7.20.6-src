package android.net.wifi;

import android.os.Parcel;
import android.os.Parcelable;
import android.security.Credentials;
import android.text.TextUtils;
import java.io.ByteArrayInputStream;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-9557208-dex2jar.jar:android/net/wifi/WifiEnterpriseConfig.class */
public class WifiEnterpriseConfig implements Parcelable {
    public static final String ANON_IDENTITY_KEY = "anonymous_identity";
    public static final String CA_CERT_KEY = "ca_cert";
    public static final String CA_CERT_PREFIX = "keystore://CACERT_";
    public static final String CLIENT_CERT_KEY = "client_cert";
    public static final String CLIENT_CERT_PREFIX = "keystore://USRCERT_";
    public static final Parcelable.Creator<WifiEnterpriseConfig> CREATOR = new Parcelable.Creator<WifiEnterpriseConfig>() { // from class: android.net.wifi.WifiEnterpriseConfig.1
        private X509Certificate readCertificate(Parcel parcel) {
            X509Certificate x509Certificate = null;
            int readInt = parcel.readInt();
            if (readInt > 0) {
                try {
                    byte[] bArr = new byte[readInt];
                    parcel.readByteArray(bArr);
                    x509Certificate = (X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(bArr));
                } catch (CertificateException e) {
                    return null;
                }
            }
            return x509Certificate;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public WifiEnterpriseConfig createFromParcel(Parcel parcel) {
            WifiEnterpriseConfig wifiEnterpriseConfig = new WifiEnterpriseConfig();
            int readInt = parcel.readInt();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= readInt) {
                    break;
                }
                wifiEnterpriseConfig.mFields.put(parcel.readString(), parcel.readString());
                i = i2 + 1;
            }
            wifiEnterpriseConfig.mCaCert = readCertificate(parcel);
            PrivateKey privateKey = null;
            int readInt2 = parcel.readInt();
            if (readInt2 > 0) {
                try {
                    byte[] bArr = new byte[readInt2];
                    parcel.readByteArray(bArr);
                    privateKey = KeyFactory.getInstance(parcel.readString()).generatePrivate(new PKCS8EncodedKeySpec(bArr));
                } catch (NoSuchAlgorithmException e) {
                    privateKey = null;
                } catch (InvalidKeySpecException e2) {
                    privateKey = null;
                }
            }
            wifiEnterpriseConfig.mClientPrivateKey = privateKey;
            wifiEnterpriseConfig.mClientCertificate = readCertificate(parcel);
            return wifiEnterpriseConfig;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public WifiEnterpriseConfig[] newArray(int i) {
            return new WifiEnterpriseConfig[i];
        }
    };
    public static final String EAP_KEY = "eap";
    public static final String EMPTY_VALUE = "NULL";
    public static final String ENGINE_DISABLE = "0";
    public static final String ENGINE_ENABLE = "1";
    public static final String ENGINE_ID_KEY = "engine_id";
    public static final String ENGINE_ID_KEYSTORE = "keystore";
    public static final String ENGINE_KEY = "engine";
    public static final String IDENTITY_KEY = "identity";
    public static final String KEYSTORE_URI = "keystore://";
    public static final String OPP_KEY_CACHING = "proactive_key_caching";
    public static final String PASSWORD_KEY = "password";
    public static final String PHASE2_KEY = "phase2";
    public static final String PRIVATE_KEY_ID_KEY = "key_id";
    public static final String SUBJECT_MATCH_KEY = "subject_match";
    private X509Certificate mCaCert;
    private X509Certificate mClientCertificate;
    private PrivateKey mClientPrivateKey;
    private HashMap<String, String> mFields = new HashMap<>();

    /* loaded from: source-9557208-dex2jar.jar:android/net/wifi/WifiEnterpriseConfig$Eap.class */
    public static final class Eap {
        public static final int AKA = 5;
        public static final int NONE = -1;
        public static final int PEAP = 0;
        public static final int PWD = 3;
        public static final int SIM = 4;
        public static final int TLS = 1;
        public static final int TTLS = 2;
        public static final String[] strings = {"PEAP", "TLS", "TTLS", "PWD", "SIM", "AKA"};

        private Eap() {
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/net/wifi/WifiEnterpriseConfig$Phase2.class */
    public static final class Phase2 {
        public static final int GTC = 4;
        public static final int MSCHAP = 2;
        public static final int MSCHAPV2 = 3;
        public static final int NONE = 0;
        public static final int PAP = 1;
        private static final String PREFIX = "auth=";
        public static final String[] strings = {WifiEnterpriseConfig.EMPTY_VALUE, "PAP", "MSCHAP", "MSCHAPV2", "GTC"};

        private Phase2() {
        }
    }

    public WifiEnterpriseConfig() {
    }

    public WifiEnterpriseConfig(WifiEnterpriseConfig wifiEnterpriseConfig) {
        for (String str : wifiEnterpriseConfig.mFields.keySet()) {
            this.mFields.put(str, wifiEnterpriseConfig.mFields.get(str));
        }
    }

    private String convertToQuotedString(String str) {
        return "\"" + str + "\"";
    }

    private int getStringIndex(String[] strArr, String str, int i) {
        if (!TextUtils.isEmpty(str)) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= strArr.length) {
                    break;
                } else if (str.equals(strArr[i3])) {
                    return i3;
                } else {
                    i2 = i3 + 1;
                }
            }
        }
        return i;
    }

    private String removeDoubleQuotes(String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            str2 = "";
        } else {
            int length = str.length();
            str2 = str;
            if (length > 1) {
                str2 = str;
                if (str.charAt(0) == '\"') {
                    str2 = str;
                    if (str.charAt(length - 1) == '\"') {
                        return str.substring(1, length - 1);
                    }
                }
            }
        }
        return str2;
    }

    private void writeCertificate(Parcel parcel, X509Certificate x509Certificate) {
        if (x509Certificate == null) {
            parcel.writeInt(0);
            return;
        }
        try {
            byte[] encoded = x509Certificate.getEncoded();
            parcel.writeInt(encoded.length);
            parcel.writeByteArray(encoded);
        } catch (CertificateEncodingException e) {
            parcel.writeInt(0);
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAnonymousIdentity() {
        return getFieldValue(ANON_IDENTITY_KEY, "");
    }

    public X509Certificate getCaCertificate() {
        return this.mCaCert;
    }

    public String getCaCertificateAlias() {
        return getFieldValue(CA_CERT_KEY, CA_CERT_PREFIX);
    }

    public X509Certificate getClientCertificate() {
        return this.mClientCertificate;
    }

    public String getClientCertificateAlias() {
        return getFieldValue(CLIENT_CERT_KEY, CLIENT_CERT_PREFIX);
    }

    public PrivateKey getClientPrivateKey() {
        return this.mClientPrivateKey;
    }

    public int getEapMethod() {
        return getStringIndex(Eap.strings, this.mFields.get(EAP_KEY), -1);
    }

    public String getFieldValue(String str, String str2) {
        String str3 = this.mFields.get(str);
        if (TextUtils.isEmpty(str3) || EMPTY_VALUE.equals(str3)) {
            return "";
        }
        String removeDoubleQuotes = removeDoubleQuotes(str3);
        return removeDoubleQuotes.startsWith(str2) ? removeDoubleQuotes.substring(str2.length()) : removeDoubleQuotes;
    }

    public HashMap<String, String> getFields() {
        return this.mFields;
    }

    public String getIdentity() {
        return getFieldValue(IDENTITY_KEY, "");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getKeyId(WifiEnterpriseConfig wifiEnterpriseConfig) {
        String str = this.mFields.get(EAP_KEY);
        String str2 = this.mFields.get(PHASE2_KEY);
        String str3 = str;
        if (TextUtils.isEmpty(str)) {
            str3 = wifiEnterpriseConfig.mFields.get(EAP_KEY);
        }
        String str4 = str2;
        if (TextUtils.isEmpty(str2)) {
            str4 = wifiEnterpriseConfig.mFields.get(PHASE2_KEY);
        }
        return str3 + "_" + str4;
    }

    public String getPassword() {
        return getFieldValue("password", "");
    }

    public int getPhase2Method() {
        String removeDoubleQuotes = removeDoubleQuotes(this.mFields.get(PHASE2_KEY));
        String str = removeDoubleQuotes;
        if (removeDoubleQuotes.startsWith("auth=")) {
            str = removeDoubleQuotes.substring("auth=".length());
        }
        return getStringIndex(Phase2.strings, str, 0);
    }

    public String getSubjectMatch() {
        return getFieldValue(SUBJECT_MATCH_KEY, "");
    }

    public void resetCaCertificate() {
        this.mCaCert = null;
    }

    public void resetClientKeyEntry() {
        this.mClientPrivateKey = null;
        this.mClientCertificate = null;
    }

    public void setAnonymousIdentity(String str) {
        setFieldValue(ANON_IDENTITY_KEY, str, "");
    }

    public void setCaCertificate(X509Certificate x509Certificate) {
        if (x509Certificate == null) {
            this.mCaCert = null;
        } else if (x509Certificate.getBasicConstraints() < 0) {
            throw new IllegalArgumentException("Not a CA certificate");
        } else {
            this.mCaCert = x509Certificate;
        }
    }

    public void setCaCertificateAlias(String str) {
        setFieldValue(CA_CERT_KEY, str, CA_CERT_PREFIX);
    }

    public void setClientCertificateAlias(String str) {
        setFieldValue(CLIENT_CERT_KEY, str, CLIENT_CERT_PREFIX);
        setFieldValue(PRIVATE_KEY_ID_KEY, str, Credentials.USER_PRIVATE_KEY);
        if (TextUtils.isEmpty(str)) {
            this.mFields.put("engine", "0");
            this.mFields.put(ENGINE_ID_KEY, EMPTY_VALUE);
            return;
        }
        this.mFields.put("engine", "1");
        this.mFields.put(ENGINE_ID_KEY, convertToQuotedString(ENGINE_ID_KEYSTORE));
    }

    public void setClientKeyEntry(PrivateKey privateKey, X509Certificate x509Certificate) {
        if (x509Certificate != null) {
            if (x509Certificate.getBasicConstraints() != -1) {
                throw new IllegalArgumentException("Cannot be a CA certificate");
            }
            if (privateKey == null) {
                throw new IllegalArgumentException("Client cert without a private key");
            }
            if (privateKey.getEncoded() == null) {
                throw new IllegalArgumentException("Private key cannot be encoded");
            }
        }
        this.mClientPrivateKey = privateKey;
        this.mClientCertificate = x509Certificate;
    }

    public void setEapMethod(int i) {
        switch (i) {
            case 0:
            case 2:
            case 3:
            case 4:
            case 5:
                break;
            default:
                throw new IllegalArgumentException("Unknown EAP method");
            case 1:
                setPhase2Method(0);
                break;
        }
        this.mFields.put(EAP_KEY, Eap.strings[i]);
        this.mFields.put(OPP_KEY_CACHING, "1");
    }

    public void setFieldValue(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            this.mFields.put(str, EMPTY_VALUE);
        } else {
            this.mFields.put(str, convertToQuotedString(str2));
        }
    }

    public void setFieldValue(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str2)) {
            this.mFields.put(str, EMPTY_VALUE);
        } else {
            this.mFields.put(str, convertToQuotedString(str3 + str2));
        }
    }

    public void setIdentity(String str) {
        setFieldValue(IDENTITY_KEY, str, "");
    }

    public void setPassword(String str) {
        setFieldValue("password", str, "");
    }

    public void setPhase2Method(int i) {
        switch (i) {
            case 0:
                this.mFields.put(PHASE2_KEY, EMPTY_VALUE);
                return;
            case 1:
            case 2:
            case 3:
            case 4:
                this.mFields.put(PHASE2_KEY, convertToQuotedString("auth=" + Phase2.strings[i]));
                return;
            default:
                throw new IllegalArgumentException("Unknown Phase 2 method");
        }
    }

    public void setSubjectMatch(String str) {
        setFieldValue(SUBJECT_MATCH_KEY, str, "");
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        for (String str : this.mFields.keySet()) {
            stringBuffer.append(str).append(" ").append(this.mFields.get(str)).append("\n");
        }
        return stringBuffer.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mFields.size());
        for (Map.Entry<String, String> entry : this.mFields.entrySet()) {
            parcel.writeString(entry.getKey());
            parcel.writeString(entry.getValue());
        }
        writeCertificate(parcel, this.mCaCert);
        if (this.mClientPrivateKey != null) {
            String algorithm = this.mClientPrivateKey.getAlgorithm();
            byte[] encoded = this.mClientPrivateKey.getEncoded();
            parcel.writeInt(encoded.length);
            parcel.writeByteArray(encoded);
            parcel.writeString(algorithm);
        } else {
            parcel.writeInt(0);
        }
        writeCertificate(parcel, this.mClientCertificate);
    }
}
