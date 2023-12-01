package java.security.cert;

import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import javax.security.auth.x500.X500Principal;
import org.apache.harmony.security.asn1.ASN1Integer;
import org.apache.harmony.security.asn1.ASN1OctetString;
import org.apache.harmony.security.x501.Name;

/* loaded from: source-2895416-dex2jar.jar:java/security/cert/X509CRLSelector.class */
public class X509CRLSelector implements CRLSelector {
    private X509Certificate certificateChecking;
    private long dateAndTime = -1;
    private ArrayList<String> issuerNames;
    private ArrayList<X500Principal> issuerPrincipals;
    private BigInteger maxCRL;
    private BigInteger minCRL;

    public void addIssuer(X500Principal x500Principal) {
        if (x500Principal == null) {
            throw new NullPointerException("issuer == null");
        }
        if (this.issuerNames == null) {
            this.issuerNames = new ArrayList<>();
        }
        String name = x500Principal.getName(X500Principal.CANONICAL);
        if (!this.issuerNames.contains(name)) {
            this.issuerNames.add(name);
        }
        if (this.issuerPrincipals == null) {
            this.issuerPrincipals = new ArrayList<>(this.issuerNames.size());
        }
        int size = this.issuerNames.size();
        int size2 = this.issuerPrincipals.size();
        while (true) {
            int i = size2;
            if (i >= size - 1) {
                this.issuerPrincipals.add(x500Principal);
                return;
            } else {
                this.issuerPrincipals.add(new X500Principal(this.issuerNames.get(i)));
                size2 = i + 1;
            }
        }
    }

    public void addIssuerName(String str) throws IOException {
        if (this.issuerNames == null) {
            this.issuerNames = new ArrayList<>();
        }
        String str2 = str;
        if (str == null) {
            str2 = "";
        }
        String name = new Name(str2).getName(X500Principal.CANONICAL);
        if (this.issuerNames.contains(name)) {
            return;
        }
        this.issuerNames.add(name);
    }

    public void addIssuerName(byte[] bArr) throws IOException {
        if (bArr == null) {
            throw new NullPointerException("iss_name == null");
        }
        if (this.issuerNames == null) {
            this.issuerNames = new ArrayList<>();
        }
        String name = new Name(bArr).getName(X500Principal.CANONICAL);
        if (this.issuerNames.contains(name)) {
            return;
        }
        this.issuerNames.add(name);
    }

    @Override // java.security.cert.CRLSelector
    public Object clone() {
        try {
            X509CRLSelector x509CRLSelector = (X509CRLSelector) super.clone();
            if (this.issuerNames != null) {
                x509CRLSelector.issuerNames = new ArrayList<>(this.issuerNames);
            }
            return x509CRLSelector;
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    public X509Certificate getCertificateChecking() {
        return this.certificateChecking;
    }

    public Date getDateAndTime() {
        if (this.dateAndTime == -1) {
            return null;
        }
        return new Date(this.dateAndTime);
    }

    public Collection<Object> getIssuerNames() {
        if (this.issuerNames == null) {
            return null;
        }
        return (Collection) this.issuerNames.clone();
    }

    public Collection<X500Principal> getIssuers() {
        if (this.issuerNames == null) {
            return null;
        }
        if (this.issuerPrincipals == null) {
            this.issuerPrincipals = new ArrayList<>(this.issuerNames.size());
        }
        int size = this.issuerNames.size();
        int size2 = this.issuerPrincipals.size();
        while (true) {
            int i = size2;
            if (i >= size) {
                return Collections.unmodifiableCollection(this.issuerPrincipals);
            }
            this.issuerPrincipals.add(new X500Principal(this.issuerNames.get(i)));
            size2 = i + 1;
        }
    }

    public BigInteger getMaxCRL() {
        return this.maxCRL;
    }

    public BigInteger getMinCRL() {
        return this.minCRL;
    }

    @Override // java.security.cert.CRLSelector
    public boolean match(CRL crl) {
        if (crl instanceof X509CRL) {
            X509CRL x509crl = (X509CRL) crl;
            if (this.issuerNames == null || this.issuerNames.contains(x509crl.getIssuerX500Principal().getName(X500Principal.CANONICAL))) {
                if (this.minCRL != null || this.maxCRL != null) {
                    try {
                        BigInteger bigInteger = new BigInteger((byte[]) ASN1Integer.getInstance().decode((byte[]) ASN1OctetString.getInstance().decode(x509crl.getExtensionValue("2.5.29.20"))));
                        if (this.minCRL != null && bigInteger.compareTo(this.minCRL) < 0) {
                            return false;
                        }
                        if (this.maxCRL != null) {
                            if (bigInteger.compareTo(this.maxCRL) > 0) {
                                return false;
                            }
                        }
                    } catch (IOException e) {
                        return false;
                    }
                }
                if (this.dateAndTime != -1) {
                    Date thisUpdate = x509crl.getThisUpdate();
                    Date nextUpdate = x509crl.getNextUpdate();
                    return thisUpdate != null && nextUpdate != null && this.dateAndTime >= thisUpdate.getTime() && this.dateAndTime <= nextUpdate.getTime();
                }
                return true;
            }
            return false;
        }
        return false;
    }

    public void setCertificateChecking(X509Certificate x509Certificate) {
        this.certificateChecking = x509Certificate;
    }

    public void setDateAndTime(Date date) {
        if (date == null) {
            this.dateAndTime = -1L;
        } else {
            this.dateAndTime = date.getTime();
        }
    }

    public void setIssuerNames(Collection<?> collection) throws IOException {
        if (collection == null) {
            this.issuerNames = null;
            this.issuerPrincipals = null;
        } else if (collection.size() != 0) {
            this.issuerNames = new ArrayList<>(collection.size());
            for (Object obj : collection) {
                if (obj instanceof String) {
                    this.issuerNames.add(new Name((String) obj).getName(X500Principal.CANONICAL));
                } else if (!(obj instanceof byte[])) {
                    throw new IOException("name neither a String nor a byte[]");
                } else {
                    this.issuerNames.add(new Name((byte[]) obj).getName(X500Principal.CANONICAL));
                }
            }
        }
    }

    public void setIssuers(Collection<X500Principal> collection) {
        if (collection == null) {
            this.issuerNames = null;
            this.issuerPrincipals = null;
            return;
        }
        this.issuerNames = new ArrayList<>(collection.size());
        this.issuerPrincipals = new ArrayList<>(collection);
        for (X500Principal x500Principal : collection) {
            this.issuerNames.add(x500Principal.getName(X500Principal.CANONICAL));
        }
    }

    public void setMaxCRLNumber(BigInteger bigInteger) {
        this.maxCRL = bigInteger;
    }

    public void setMinCRLNumber(BigInteger bigInteger) {
        this.minCRL = bigInteger;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("X509CRLSelector:\n[");
        if (this.issuerNames != null) {
            sb.append("\n  IssuerNames:\n  [");
            int size = this.issuerNames.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= size) {
                    break;
                }
                sb.append("\n    " + this.issuerNames.get(i2));
                i = i2 + 1;
            }
            sb.append("\n  ]");
        }
        if (this.minCRL != null) {
            sb.append("\n  minCRL: " + this.minCRL);
        }
        if (this.maxCRL != null) {
            sb.append("\n  maxCRL: " + this.maxCRL);
        }
        if (this.dateAndTime != -1) {
            sb.append("\n  dateAndTime: " + new Date(this.dateAndTime));
        }
        if (this.certificateChecking != null) {
            sb.append("\n  certificateChecking: " + this.certificateChecking);
        }
        sb.append("\n]");
        return sb.toString();
    }
}
