package org.apache.harmony.security.x501;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import javax.security.auth.x500.X500Principal;
import org.apache.harmony.security.asn1.ASN1SequenceOf;
import org.apache.harmony.security.asn1.ASN1SetOf;
import org.apache.harmony.security.asn1.BerInputStream;
import org.apache.harmony.security.asn1.DerInputStream;
import org.apache.harmony.security.x509.DNParser;

/* loaded from: source-2895416-dex2jar.jar:org/apache/harmony/security/x501/Name.class */
public final class Name {
    private String canonicalString;
    private volatile byte[] encoded;
    private List<List<AttributeTypeAndValue>> rdn;
    private String rfc1779String;
    private String rfc2253String;
    public static final ASN1SetOf ASN1_RDN = new ASN1SetOf(AttributeTypeAndValue.ASN1);
    public static final ASN1SequenceOf ASN1 = new ASN1SequenceOf(ASN1_RDN) { // from class: org.apache.harmony.security.x501.Name.1
        @Override // org.apache.harmony.security.asn1.ASN1Type
        public Object getDecodedObject(BerInputStream berInputStream) {
            return new Name((List) berInputStream.content);
        }

        @Override // org.apache.harmony.security.asn1.ASN1ValueCollection
        public Collection getValues(Object obj) {
            return ((Name) obj).rdn;
        }
    };

    public Name(String str) throws IOException {
        this.rdn = new DNParser(str).parse();
    }

    private Name(List<List<AttributeTypeAndValue>> list) {
        this.rdn = list;
    }

    public Name(byte[] bArr) throws IOException {
        DerInputStream derInputStream = new DerInputStream(bArr);
        if (derInputStream.getEndOffset() != bArr.length) {
            throw new IOException("Wrong content length");
        }
        ASN1.decode(derInputStream);
        this.rdn = (List) derInputStream.content;
    }

    private String getName0(String str) {
        StringBuilder sb = new StringBuilder();
        int size = this.rdn.size();
        while (true) {
            int i = size - 1;
            if (i < 0) {
                break;
            }
            List<AttributeTypeAndValue> list = this.rdn.get(i);
            ArrayList arrayList = list;
            if (X500Principal.CANONICAL == str) {
                arrayList = new ArrayList(list);
                Collections.sort(arrayList, new AttributeTypeAndValueComparator());
            }
            Iterator<AttributeTypeAndValue> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().appendName(str, sb);
                if (it.hasNext()) {
                    if (X500Principal.RFC1779 == str) {
                        sb.append(" + ");
                    } else {
                        sb.append('+');
                    }
                }
            }
            if (i != 0) {
                sb.append(',');
                if (str == X500Principal.RFC1779) {
                    sb.append(' ');
                }
            }
            size = i;
        }
        String sb2 = sb.toString();
        String str2 = sb2;
        if (X500Principal.CANONICAL.equals(str)) {
            str2 = sb2.toLowerCase(Locale.US);
        }
        return str2;
    }

    public byte[] getEncoded() {
        if (this.encoded == null) {
            this.encoded = ASN1.encode(this);
        }
        return this.encoded;
    }

    public String getName(String str) {
        if (X500Principal.RFC1779.equals(str)) {
            if (this.rfc1779String == null) {
                this.rfc1779String = getName0(str);
            }
            return this.rfc1779String;
        } else if (X500Principal.RFC2253.equals(str)) {
            if (this.rfc2253String == null) {
                this.rfc2253String = getName0(str);
            }
            return this.rfc2253String;
        } else if (X500Principal.CANONICAL.equals(str)) {
            if (this.canonicalString == null) {
                this.canonicalString = getName0(str);
            }
            return this.canonicalString;
        } else if (X500Principal.RFC1779.equalsIgnoreCase(str)) {
            if (this.rfc1779String == null) {
                this.rfc1779String = getName0(X500Principal.RFC1779);
            }
            return this.rfc1779String;
        } else if (X500Principal.RFC2253.equalsIgnoreCase(str)) {
            if (this.rfc2253String == null) {
                this.rfc2253String = getName0(X500Principal.RFC2253);
            }
            return this.rfc2253String;
        } else if (X500Principal.CANONICAL.equalsIgnoreCase(str)) {
            if (this.canonicalString == null) {
                this.canonicalString = getName0(X500Principal.CANONICAL);
            }
            return this.canonicalString;
        } else {
            throw new IllegalArgumentException("Illegal format: " + str);
        }
    }

    public X500Principal getX500Principal() {
        return new X500Principal(getEncoded());
    }
}
