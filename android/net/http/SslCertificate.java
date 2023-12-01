package android.net.http;

import android.content.Context;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.android.org.bouncycastle.asn1.x509.X509Name;
import com.youzan.androidsdk.tool.AppSigning;
import java.io.ByteArrayInputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

/* loaded from: source-9557208-dex2jar.jar:android/net/http/SslCertificate.class */
public class SslCertificate {
    private static String ISO_8601_DATE_FORMAT = "yyyy-MM-dd HH:mm:ssZ";
    private static final String ISSUED_BY = "issued-by";
    private static final String ISSUED_TO = "issued-to";
    private static final String VALID_NOT_AFTER = "valid-not-after";
    private static final String VALID_NOT_BEFORE = "valid-not-before";
    private static final String X509_CERTIFICATE = "x509-certificate";
    private final DName mIssuedBy;
    private final DName mIssuedTo;
    private final Date mValidNotAfter;
    private final Date mValidNotBefore;
    private final X509Certificate mX509Certificate;

    /* loaded from: source-9557208-dex2jar.jar:android/net/http/SslCertificate$DName.class */
    public class DName {
        private String mCName;
        private String mDName;
        private String mOName;
        private String mUName;

        public DName(String str) {
            if (str == null) {
                return;
            }
            this.mDName = str;
            try {
                X509Name x509Name = new X509Name(str);
                Vector values = x509Name.getValues();
                Vector oIDs = x509Name.getOIDs();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= oIDs.size()) {
                        return;
                    }
                    if (oIDs.elementAt(i2).equals(X509Name.CN)) {
                        if (this.mCName == null) {
                            this.mCName = (String) values.elementAt(i2);
                        }
                    } else if (oIDs.elementAt(i2).equals(X509Name.O) && this.mOName == null) {
                        this.mOName = (String) values.elementAt(i2);
                    } else if (oIDs.elementAt(i2).equals(X509Name.OU) && this.mUName == null) {
                        this.mUName = (String) values.elementAt(i2);
                    }
                    i = i2 + 1;
                }
            } catch (IllegalArgumentException e) {
            }
        }

        public String getCName() {
            return this.mCName != null ? this.mCName : "";
        }

        public String getDName() {
            return this.mDName != null ? this.mDName : "";
        }

        public String getOName() {
            return this.mOName != null ? this.mOName : "";
        }

        public String getUName() {
            return this.mUName != null ? this.mUName : "";
        }
    }

    @Deprecated
    public SslCertificate(String str, String str2, String str3, String str4) {
        this(str, str2, parseDate(str3), parseDate(str4), null);
    }

    @Deprecated
    public SslCertificate(String str, String str2, Date date, Date date2) {
        this(str, str2, date, date2, null);
    }

    private SslCertificate(String str, String str2, Date date, Date date2, X509Certificate x509Certificate) {
        this.mIssuedTo = new DName(str);
        this.mIssuedBy = new DName(str2);
        this.mValidNotBefore = cloneDate(date);
        this.mValidNotAfter = cloneDate(date2);
        this.mX509Certificate = x509Certificate;
    }

    public SslCertificate(X509Certificate x509Certificate) {
        this(x509Certificate.getSubjectDN().getName(), x509Certificate.getIssuerDN().getName(), x509Certificate.getNotBefore(), x509Certificate.getNotAfter(), x509Certificate);
    }

    private static Date cloneDate(Date date) {
        if (date == null) {
            return null;
        }
        return (Date) date.clone();
    }

    private static final String fingerprint(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= bArr.length) {
                return sb.toString();
            }
            IntegralToString.appendByteAsHex(sb, bArr[i2], true);
            if (i2 + 1 != bArr.length) {
                sb.append(':');
            }
            i = i2 + 1;
        }
    }

    private String formatCertificateDate(Context context, Date date) {
        return date == null ? "" : DateFormat.getDateFormat(context).format(date);
    }

    private static String formatDate(Date date) {
        return date == null ? "" : new SimpleDateFormat(ISO_8601_DATE_FORMAT).format(date);
    }

    private static String getDigest(X509Certificate x509Certificate, String str) {
        if (x509Certificate == null) {
            return "";
        }
        try {
            return fingerprint(MessageDigest.getInstance(str).digest(x509Certificate.getEncoded()));
        } catch (NoSuchAlgorithmException e) {
            return "";
        } catch (CertificateEncodingException e2) {
            return "";
        }
    }

    private static String getSerialNumber(X509Certificate x509Certificate) {
        BigInteger serialNumber;
        return (x509Certificate == null || (serialNumber = x509Certificate.getSerialNumber()) == null) ? "" : fingerprint(serialNumber.toByteArray());
    }

    private static Date parseDate(String str) {
        try {
            return new SimpleDateFormat(ISO_8601_DATE_FORMAT).parse(str);
        } catch (ParseException e) {
            return null;
        }
    }

    public static SslCertificate restoreState(Bundle bundle) {
        X509Certificate x509Certificate;
        if (bundle == null) {
            return null;
        }
        byte[] byteArray = bundle.getByteArray(X509_CERTIFICATE);
        if (byteArray == null) {
            x509Certificate = null;
        } else {
            try {
                x509Certificate = (X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(byteArray));
            } catch (CertificateException e) {
                x509Certificate = null;
            }
        }
        return new SslCertificate(bundle.getString(ISSUED_TO), bundle.getString(ISSUED_BY), parseDate(bundle.getString(VALID_NOT_BEFORE)), parseDate(bundle.getString(VALID_NOT_AFTER)), x509Certificate);
    }

    public static Bundle saveState(SslCertificate sslCertificate) {
        Bundle bundle;
        if (sslCertificate == null) {
            bundle = null;
        } else {
            Bundle bundle2 = new Bundle();
            bundle2.putString(ISSUED_TO, sslCertificate.getIssuedTo().getDName());
            bundle2.putString(ISSUED_BY, sslCertificate.getIssuedBy().getDName());
            bundle2.putString(VALID_NOT_BEFORE, sslCertificate.getValidNotBefore());
            bundle2.putString(VALID_NOT_AFTER, sslCertificate.getValidNotAfter());
            X509Certificate x509Certificate = sslCertificate.mX509Certificate;
            bundle = bundle2;
            if (x509Certificate != null) {
                try {
                    bundle2.putByteArray(X509_CERTIFICATE, x509Certificate.getEncoded());
                    return bundle2;
                } catch (CertificateEncodingException e) {
                    return bundle2;
                }
            }
        }
        return bundle;
    }

    public DName getIssuedBy() {
        return this.mIssuedBy;
    }

    public DName getIssuedTo() {
        return this.mIssuedTo;
    }

    @Deprecated
    public String getValidNotAfter() {
        return formatDate(this.mValidNotAfter);
    }

    public Date getValidNotAfterDate() {
        return cloneDate(this.mValidNotAfter);
    }

    @Deprecated
    public String getValidNotBefore() {
        return formatDate(this.mValidNotBefore);
    }

    public Date getValidNotBeforeDate() {
        return cloneDate(this.mValidNotBefore);
    }

    public View inflateCertificateView(Context context) {
        View inflate = LayoutInflater.from(context).inflate(17367248, (ViewGroup) null);
        DName issuedTo = getIssuedTo();
        if (issuedTo != null) {
            ((TextView) inflate.findViewById(16909214)).setText(issuedTo.getCName());
            ((TextView) inflate.findViewById(16909216)).setText(issuedTo.getOName());
            ((TextView) inflate.findViewById(16909218)).setText(issuedTo.getUName());
        }
        ((TextView) inflate.findViewById(16909220)).setText(getSerialNumber(this.mX509Certificate));
        DName issuedBy = getIssuedBy();
        if (issuedBy != null) {
            ((TextView) inflate.findViewById(16909222)).setText(issuedBy.getCName());
            ((TextView) inflate.findViewById(16909224)).setText(issuedBy.getOName());
            ((TextView) inflate.findViewById(16909226)).setText(issuedBy.getUName());
        }
        ((TextView) inflate.findViewById(16909229)).setText(formatCertificateDate(context, getValidNotBeforeDate()));
        ((TextView) inflate.findViewById(16909231)).setText(formatCertificateDate(context, getValidNotAfterDate()));
        ((TextView) inflate.findViewById(16909234)).setText(getDigest(this.mX509Certificate, AppSigning.SHA256));
        ((TextView) inflate.findViewById(16909236)).setText(getDigest(this.mX509Certificate, AppSigning.SHA1));
        return inflate;
    }

    public String toString() {
        return "Issued to: " + this.mIssuedTo.getDName() + ";\nIssued by: " + this.mIssuedBy.getDName() + ";\n";
    }
}
