package org.apache.harmony.security.x501;

import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import javax.security.auth.x500.X500Principal;
import javax.xml.datatype.DatatypeConstants;
import org.apache.harmony.security.asn1.ASN1Sequence;
import org.apache.harmony.security.asn1.ASN1StringType;
import org.apache.harmony.security.asn1.ASN1Type;
import org.apache.harmony.security.asn1.BerInputStream;
import org.apache.harmony.security.asn1.BerOutputStream;
import org.apache.harmony.security.utils.ObjectIdentifier;

/* loaded from: source-2895416-dex2jar.jar:org/apache/harmony/security/x501/AttributeTypeAndValue.class */
public final class AttributeTypeAndValue {
    public static final ASN1Sequence ASN1 = null;
    private static final int CAPACITY = 10;
    private static final int SIZE = 10;
    public static final ASN1Type attributeValue = null;
    private final ObjectIdentifier oid;
    private final AttributeValue value;
    private static final HashMap<String, ObjectIdentifier> RFC1779_NAMES = new HashMap<>(10);
    private static final HashMap<String, ObjectIdentifier> KNOWN_NAMES = new HashMap<>(30);
    private static final HashMap<String, ObjectIdentifier> RFC2253_NAMES = new HashMap<>(10);
    private static final HashMap<String, ObjectIdentifier> RFC2459_NAMES = new HashMap<>(10);
    private static final ObjectIdentifier C = new ObjectIdentifier(new int[]{2, 5, 4, 6}, "C", RFC1779_NAMES);
    private static final ObjectIdentifier CN = new ObjectIdentifier(new int[]{2, 5, 4, 3}, "CN", RFC1779_NAMES);
    public static final ObjectIdentifier DC = new ObjectIdentifier(new int[]{0, 9, 2342, 19200300, 100, 1, 25}, "DC", RFC2253_NAMES);
    private static final ObjectIdentifier DNQ = new ObjectIdentifier(new int[]{2, 5, 4, 46}, "DNQ", RFC2459_NAMES);
    private static final ObjectIdentifier DNQUALIFIER = new ObjectIdentifier(new int[]{2, 5, 4, 46}, "DNQUALIFIER", RFC2459_NAMES);
    public static final ObjectIdentifier EMAILADDRESS = new ObjectIdentifier(new int[]{1, 2, DatatypeConstants.MIN_TIMEZONE_OFFSET, 113549, 1, 9, 1}, "EMAILADDRESS", RFC2459_NAMES);
    private static final ObjectIdentifier GENERATION = new ObjectIdentifier(new int[]{2, 5, 4, 44}, "GENERATION", RFC2459_NAMES);
    private static final ObjectIdentifier GIVENNAME = new ObjectIdentifier(new int[]{2, 5, 4, 42}, "GIVENNAME", RFC2459_NAMES);
    private static final ObjectIdentifier INITIALS = new ObjectIdentifier(new int[]{2, 5, 4, 43}, "INITIALS", RFC2459_NAMES);
    private static final ObjectIdentifier L = new ObjectIdentifier(new int[]{2, 5, 4, 7}, "L", RFC1779_NAMES);
    private static final ObjectIdentifier O = new ObjectIdentifier(new int[]{2, 5, 4, 10}, "O", RFC1779_NAMES);
    private static final ObjectIdentifier OU = new ObjectIdentifier(new int[]{2, 5, 4, 11}, "OU", RFC1779_NAMES);
    private static final ObjectIdentifier SERIALNUMBER = new ObjectIdentifier(new int[]{2, 5, 4, 5}, "SERIALNUMBER", RFC2459_NAMES);
    private static final ObjectIdentifier ST = new ObjectIdentifier(new int[]{2, 5, 4, 8}, "ST", RFC1779_NAMES);
    private static final ObjectIdentifier STREET = new ObjectIdentifier(new int[]{2, 5, 4, 9}, "STREET", RFC1779_NAMES);
    private static final ObjectIdentifier SURNAME = new ObjectIdentifier(new int[]{2, 5, 4, 4}, "SURNAME", RFC2459_NAMES);
    private static final ObjectIdentifier T = new ObjectIdentifier(new int[]{2, 5, 4, 12}, "T", RFC2459_NAMES);
    private static final ObjectIdentifier UID = new ObjectIdentifier(new int[]{0, 9, 2342, 19200300, 100, 1, 1}, "UID", RFC2253_NAMES);
    private static final ObjectIdentifier[][] KNOWN_OIDS = (ObjectIdentifier[][]) Array.newInstance(ObjectIdentifier.class, 10, 10);

    /* renamed from: org.apache.harmony.security.x501.AttributeTypeAndValue$1  reason: invalid class name */
    /* loaded from: source-2895416-dex2jar.jar:org/apache/harmony/security/x501/AttributeTypeAndValue$1.class */
    static final class AnonymousClass1 extends ASN1Type {
        AnonymousClass1(int i) {
            super(i);
        }

        @Override // org.apache.harmony.security.asn1.ASN1Type
        public boolean checkTag(int i) {
            return true;
        }

        @Override // org.apache.harmony.security.asn1.ASN1Type
        public Object decode(BerInputStream berInputStream) throws IOException {
            String str = null;
            if (DirectoryString.ASN1.checkTag(berInputStream.tag)) {
                str = (String) DirectoryString.ASN1.decode(berInputStream);
            } else {
                berInputStream.readContent();
            }
            byte[] bArr = new byte[berInputStream.getOffset() - berInputStream.getTagOffset()];
            System.arraycopy(berInputStream.getBuffer(), berInputStream.getTagOffset(), bArr, 0, bArr.length);
            return new AttributeValue(str, bArr, berInputStream.tag);
        }

        @Override // org.apache.harmony.security.asn1.ASN1Type
        public void encodeASN(BerOutputStream berOutputStream) {
            AttributeValue attributeValue = (AttributeValue) berOutputStream.content;
            if (attributeValue.encoded != null) {
                berOutputStream.content = attributeValue.encoded;
                berOutputStream.encodeANY();
                return;
            }
            berOutputStream.encodeTag(attributeValue.getTag());
            berOutputStream.content = attributeValue.bytes;
            berOutputStream.encodeString();
        }

        @Override // org.apache.harmony.security.asn1.ASN1Type
        public void encodeContent(BerOutputStream berOutputStream) {
            throw new RuntimeException("AttributeValue encodeContent MUST NOT be invoked");
        }

        @Override // org.apache.harmony.security.asn1.ASN1Type
        public Object getDecodedObject(BerInputStream berInputStream) throws IOException {
            throw new RuntimeException("AttributeValue getDecodedObject MUST NOT be invoked");
        }

        @Override // org.apache.harmony.security.asn1.ASN1Type
        public int getEncodedLength(BerOutputStream berOutputStream) {
            return ((AttributeValue) berOutputStream.content).encoded != null ? berOutputStream.length : super.getEncodedLength(berOutputStream);
        }

        @Override // org.apache.harmony.security.asn1.ASN1Type
        public void setEncodingContent(BerOutputStream berOutputStream) {
            AttributeValue attributeValue = (AttributeValue) berOutputStream.content;
            if (attributeValue.encoded != null) {
                berOutputStream.length = attributeValue.encoded.length;
            } else if (attributeValue.getTag() != 12) {
                attributeValue.bytes = attributeValue.rawString.getBytes(StandardCharsets.UTF_8);
                berOutputStream.length = attributeValue.bytes.length;
            } else {
                berOutputStream.content = attributeValue.rawString;
                ASN1StringType.UTF8STRING.setEncodingContent(berOutputStream);
                attributeValue.bytes = (byte[]) berOutputStream.content;
                berOutputStream.content = attributeValue;
            }
        }
    }

    /* renamed from: org.apache.harmony.security.x501.AttributeTypeAndValue$2  reason: invalid class name */
    /* loaded from: source-2895416-dex2jar.jar:org/apache/harmony/security/x501/AttributeTypeAndValue$2.class */
    static final class AnonymousClass2 extends ASN1Sequence {
        AnonymousClass2(ASN1Type[] aSN1TypeArr) {
            super(aSN1TypeArr);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.apache.harmony.security.asn1.ASN1Type
        public Object getDecodedObject(BerInputStream berInputStream) throws IOException {
            Object[] objArr = (Object[]) berInputStream.content;
            return new AttributeTypeAndValue((int[]) objArr[0], (AttributeValue) objArr[1], null);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.apache.harmony.security.asn1.ASN1TypeCollection
        public void getValues(Object obj, Object[] objArr) {
            AttributeTypeAndValue attributeTypeAndValue = (AttributeTypeAndValue) obj;
            objArr[0] = attributeTypeAndValue.oid.getOid();
            objArr[1] = attributeTypeAndValue.value;
        }
    }

    static {
        HashMap<String, ObjectIdentifier> hashMap = RFC1779_NAMES;
        ObjectIdentifier objectIdentifier = CN;
        throw new VerifyError("bad dex opcode");
    }

    public AttributeTypeAndValue(ObjectIdentifier objectIdentifier, AttributeValue attributeValue2) throws IOException {
        this.oid = objectIdentifier;
        this.value = attributeValue2;
    }

    private AttributeTypeAndValue(int[] iArr, AttributeValue attributeValue2) throws IOException {
        ObjectIdentifier oid = getOID(iArr);
        this.oid = oid == null ? new ObjectIdentifier(iArr) : oid;
        this.value = attributeValue2;
    }

    /* synthetic */ AttributeTypeAndValue(int[] iArr, AttributeValue attributeValue2, AnonymousClass1 anonymousClass1) throws IOException {
        this(iArr, attributeValue2);
    }

    private static void addOID(ObjectIdentifier objectIdentifier) {
        int[] oid = objectIdentifier.getOid();
        ObjectIdentifier[] objectIdentifierArr = KNOWN_OIDS[hashIntArray(oid) % 10];
        int i = 0;
        while (true) {
            int i2 = i;
            if (objectIdentifierArr[i2] == null) {
                if (i2 == 9) {
                    throw new Error("ObjectIdentifier: invalid static initialization; small OID pool capacity");
                }
                objectIdentifierArr[i2] = objectIdentifier;
                return;
            } else if (Arrays.equals(oid, objectIdentifierArr[i2].getOid())) {
                throw new Error("ObjectIdentifier: invalid static initialization; duplicate OIDs: " + objectIdentifier.getName() + " " + objectIdentifierArr[i2].getName());
            } else {
                i = i2 + 1;
            }
        }
    }

    private static ObjectIdentifier getOID(int[] iArr) {
        ObjectIdentifier[] objectIdentifierArr = KNOWN_OIDS[hashIntArray(iArr) % 10];
        int i = 0;
        while (true) {
            int i2 = i;
            if (objectIdentifierArr[i2] == null) {
                return null;
            }
            if (Arrays.equals(iArr, objectIdentifierArr[i2].getOid())) {
                return objectIdentifierArr[i2];
            }
            i = i2 + 1;
        }
    }

    public static ObjectIdentifier getObjectIdentifier(String str) throws IOException {
        ObjectIdentifier objectIdentifier;
        if (str.charAt(0) < '0' || str.charAt(0) > '9') {
            ObjectIdentifier objectIdentifier2 = KNOWN_NAMES.get(str.toUpperCase(Locale.US));
            objectIdentifier = objectIdentifier2;
            if (objectIdentifier2 == null) {
                throw new IOException("Unrecognizable attribute name: " + str);
            }
        } else {
            int[] intArray = org.apache.harmony.security.asn1.ObjectIdentifier.toIntArray(str);
            ObjectIdentifier oid = getOID(intArray);
            objectIdentifier = oid;
            if (oid == null) {
                objectIdentifier = new ObjectIdentifier(intArray);
            }
        }
        return objectIdentifier;
    }

    private static int hashIntArray(int[] iArr) {
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= iArr.length || i3 >= 4) {
                break;
            }
            i += iArr[i3] << (i3 * 8);
            i2 = i3 + 1;
        }
        return Integer.MAX_VALUE & i;
    }

    public void appendName(String str, StringBuilder sb) {
        boolean z;
        if (X500Principal.RFC1779.equals(str)) {
            if (RFC1779_NAMES == this.oid.getGroup()) {
                sb.append(this.oid.getName());
            } else {
                sb.append(this.oid.toOIDString());
            }
            sb.append('=');
            if (this.value.escapedString == this.value.getHexString()) {
                sb.append(this.value.getHexString().toUpperCase(Locale.US));
                return;
            } else if (this.value.escapedString.length() != this.value.rawString.length()) {
                this.value.appendQEString(sb);
                return;
            } else {
                sb.append(this.value.escapedString);
                return;
            }
        }
        Object group = this.oid.getGroup();
        if (RFC1779_NAMES == group || RFC2253_NAMES == group) {
            sb.append(this.oid.getName());
            z = false;
            if (X500Principal.CANONICAL.equals(str)) {
                int tag = this.value.getTag();
                z = false;
                if (!ASN1StringType.UTF8STRING.checkTag(tag)) {
                    z = false;
                    if (!ASN1StringType.PRINTABLESTRING.checkTag(tag)) {
                        z = false;
                        if (!ASN1StringType.TELETEXSTRING.checkTag(tag)) {
                            z = true;
                        }
                    }
                }
            }
        } else {
            sb.append(this.oid.toString());
            z = true;
        }
        sb.append('=');
        if (z) {
            sb.append(this.value.getHexString());
        } else if (X500Principal.CANONICAL.equals(str)) {
            sb.append(this.value.makeCanonical());
        } else if (X500Principal.RFC2253.equals(str)) {
            sb.append(this.value.getRFC2253String());
        } else {
            sb.append(this.value.escapedString);
        }
    }

    public ObjectIdentifier getType() {
        return this.oid;
    }

    public AttributeValue getValue() {
        return this.value;
    }
}
