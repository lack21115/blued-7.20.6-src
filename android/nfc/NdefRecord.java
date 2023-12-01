package android.nfc;

import android.content.Intent;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.widget.ExpandableListView;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Locale;

/* loaded from: source-9557208-dex2jar.jar:android/nfc/NdefRecord.class */
public final class NdefRecord implements Parcelable {
    public static final Parcelable.Creator<NdefRecord> CREATOR = null;
    private static final byte[] EMPTY_BYTE_ARRAY = null;
    private static final byte FLAG_CF = 32;
    private static final byte FLAG_IL = 8;
    private static final byte FLAG_MB = Byte.MIN_VALUE;
    private static final byte FLAG_ME = 64;
    private static final byte FLAG_SR = 16;
    private static final int MAX_PAYLOAD_SIZE = 10485760;
    public static final byte[] RTD_ANDROID_APP = null;
    public static final short TNF_ABSOLUTE_URI = 3;
    public static final short TNF_EMPTY = 0;
    public static final short TNF_EXTERNAL_TYPE = 4;
    public static final short TNF_MIME_MEDIA = 2;
    public static final short TNF_RESERVED = 7;
    public static final short TNF_UNCHANGED = 6;
    public static final short TNF_UNKNOWN = 5;
    public static final short TNF_WELL_KNOWN = 1;
    private static final String[] URI_PREFIX_MAP = null;
    private final byte[] mId;
    private final byte[] mPayload;
    private final short mTnf;
    private final byte[] mType;
    public static final byte[] RTD_TEXT = {84};
    public static final byte[] RTD_URI = {85};
    public static final byte[] RTD_SMART_POSTER = {83, 112};
    public static final byte[] RTD_ALTERNATIVE_CARRIER = {97, 99};
    public static final byte[] RTD_HANDOVER_CARRIER = {72, 99};
    public static final byte[] RTD_HANDOVER_REQUEST = {72, 114};
    public static final byte[] RTD_HANDOVER_SELECT = {72, 115};

    /* renamed from: android.nfc.NdefRecord$1  reason: invalid class name */
    /* loaded from: source-9557208-dex2jar.jar:android/nfc/NdefRecord$1.class */
    static final class AnonymousClass1 implements Parcelable.Creator<NdefRecord> {
        AnonymousClass1() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public NdefRecord createFromParcel(Parcel parcel) {
            short readInt = (short) parcel.readInt();
            byte[] bArr = new byte[parcel.readInt()];
            parcel.readByteArray(bArr);
            byte[] bArr2 = new byte[parcel.readInt()];
            parcel.readByteArray(bArr2);
            byte[] bArr3 = new byte[parcel.readInt()];
            parcel.readByteArray(bArr3);
            return new NdefRecord(readInt, bArr, bArr2, bArr3);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public NdefRecord[] newArray(int i) {
            return new NdefRecord[i];
        }
    }

    static {
        throw new VerifyError("bad dex opcode");
    }

    public NdefRecord(short s, byte[] bArr, byte[] bArr2, byte[] bArr3) {
        byte[] bArr4 = bArr == null ? EMPTY_BYTE_ARRAY : bArr;
        byte[] bArr5 = bArr2 == null ? EMPTY_BYTE_ARRAY : bArr2;
        byte[] bArr6 = bArr3 == null ? EMPTY_BYTE_ARRAY : bArr3;
        String validateTnf = validateTnf(s, bArr4, bArr5, bArr6);
        if (validateTnf != null) {
            throw new IllegalArgumentException(validateTnf);
        }
        this.mTnf = s;
        this.mType = bArr4;
        this.mId = bArr5;
        this.mPayload = bArr6;
    }

    @Deprecated
    public NdefRecord(byte[] bArr) throws FormatException {
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        NdefRecord[] parse = parse(wrap, true);
        if (wrap.remaining() > 0) {
            throw new FormatException("data too long");
        }
        this.mTnf = parse[0].mTnf;
        this.mType = parse[0].mType;
        this.mId = parse[0].mId;
        this.mPayload = parse[0].mPayload;
    }

    private static StringBuilder bytesToString(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        int length = bArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return sb;
            }
            sb.append(String.format("%02X", Byte.valueOf(bArr[i2])));
            i = i2 + 1;
        }
    }

    public static NdefRecord createApplicationRecord(String str) {
        if (str == null) {
            throw new NullPointerException("packageName is null");
        }
        if (str.length() == 0) {
            throw new IllegalArgumentException("packageName is empty");
        }
        return new NdefRecord((short) 4, RTD_ANDROID_APP, null, str.getBytes(StandardCharsets.UTF_8));
    }

    public static NdefRecord createExternal(String str, String str2, byte[] bArr) {
        if (str == null) {
            throw new NullPointerException("domain is null");
        }
        if (str2 == null) {
            throw new NullPointerException("type is null");
        }
        String lowerCase = str.trim().toLowerCase(Locale.ROOT);
        String lowerCase2 = str2.trim().toLowerCase(Locale.ROOT);
        if (lowerCase.length() == 0) {
            throw new IllegalArgumentException("domain is empty");
        }
        if (lowerCase2.length() == 0) {
            throw new IllegalArgumentException("type is empty");
        }
        byte[] bytes = lowerCase.getBytes(StandardCharsets.UTF_8);
        byte[] bytes2 = lowerCase2.getBytes(StandardCharsets.UTF_8);
        byte[] bArr2 = new byte[bytes.length + 1 + bytes2.length];
        System.arraycopy(bytes, 0, bArr2, 0, bytes.length);
        bArr2[bytes.length] = 58;
        System.arraycopy(bytes2, 0, bArr2, bytes.length + 1, bytes2.length);
        return new NdefRecord((short) 4, bArr2, null, bArr);
    }

    public static NdefRecord createMime(String str, byte[] bArr) {
        if (str == null) {
            throw new NullPointerException("mimeType is null");
        }
        String normalizeMimeType = Intent.normalizeMimeType(str);
        if (normalizeMimeType.length() == 0) {
            throw new IllegalArgumentException("mimeType is empty");
        }
        int indexOf = normalizeMimeType.indexOf(47);
        if (indexOf == 0) {
            throw new IllegalArgumentException("mimeType must have major type");
        }
        if (indexOf == normalizeMimeType.length() - 1) {
            throw new IllegalArgumentException("mimeType must have minor type");
        }
        return new NdefRecord((short) 2, normalizeMimeType.getBytes(StandardCharsets.US_ASCII), null, bArr);
    }

    public static NdefRecord createTextRecord(String str, String str2) {
        if (str2 == null) {
            throw new NullPointerException("text is null");
        }
        byte[] bytes = str2.getBytes(StandardCharsets.UTF_8);
        byte[] bytes2 = (str == null || str.isEmpty()) ? Locale.getDefault().getLanguage().getBytes(StandardCharsets.US_ASCII) : str.getBytes(StandardCharsets.US_ASCII);
        if (bytes2.length >= 64) {
            throw new IllegalArgumentException("language code is too long, must be <64 bytes.");
        }
        ByteBuffer allocate = ByteBuffer.allocate(bytes2.length + 1 + bytes.length);
        allocate.put((byte) (bytes2.length & 255));
        allocate.put(bytes2);
        allocate.put(bytes);
        return new NdefRecord((short) 1, RTD_TEXT, null, allocate.array());
    }

    public static NdefRecord createUri(Uri uri) {
        byte b;
        String str;
        if (uri == null) {
            throw new NullPointerException("uri is null");
        }
        String uri2 = uri.normalizeScheme().toString();
        if (uri2.length() == 0) {
            throw new IllegalArgumentException("uri is empty");
        }
        int i = 1;
        while (true) {
            int i2 = i;
            b = 0;
            str = uri2;
            if (i2 >= URI_PREFIX_MAP.length) {
                break;
            } else if (uri2.startsWith(URI_PREFIX_MAP[i2])) {
                b = (byte) i2;
                str = uri2.substring(URI_PREFIX_MAP[i2].length());
                break;
            } else {
                i = i2 + 1;
            }
        }
        byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
        byte[] bArr = new byte[bytes.length + 1];
        bArr[0] = b;
        System.arraycopy(bytes, 0, bArr, 1, bytes.length);
        return new NdefRecord((short) 1, RTD_URI, null, bArr);
    }

    public static NdefRecord createUri(String str) {
        return createUri(Uri.parse(str));
    }

    private static void ensureSanePayloadSize(long j) throws FormatException {
        if (j > 10485760) {
            throw new FormatException("payload above max limit: " + j + " > " + MAX_PAYLOAD_SIZE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static NdefRecord[] parse(ByteBuffer byteBuffer, boolean z) throws FormatException {
        Iterator it;
        ArrayList arrayList = new ArrayList();
        byte[] bArr = null;
        byte[] bArr2 = null;
        try {
            ArrayList arrayList2 = new ArrayList();
            boolean z2 = false;
            short s = -1;
            boolean z3 = false;
            while (!z3) {
                byte b = byteBuffer.get();
                boolean z4 = (b & Byte.MIN_VALUE) != 0;
                z3 = (b & 64) != 0;
                boolean z5 = (b & 32) != 0;
                boolean z6 = (b & 16) != 0;
                boolean z7 = (b & 8) != 0;
                short s2 = (short) (b & 7);
                if (!z4 && arrayList.size() == 0 && !z2 && !z) {
                    throw new FormatException("expected MB flag");
                }
                if (z4 && arrayList.size() != 0 && !z) {
                    throw new FormatException("unexpected MB flag");
                }
                if (z2 && z7) {
                    throw new FormatException("unexpected IL flag in non-leading chunk");
                }
                if (z5 && z3) {
                    throw new FormatException("unexpected ME flag in non-trailing chunk");
                }
                if (z2 && s2 != 6) {
                    throw new FormatException("expected TNF_UNCHANGED in non-leading chunk");
                }
                if (!z2 && s2 == 6) {
                    throw new FormatException("unexpected TNF_UNCHANGED in first chunk or unchunked record");
                }
                int i = byteBuffer.get() & 255;
                long j = z6 ? byteBuffer.get() & 255 : byteBuffer.getInt() & ExpandableListView.PACKED_POSITION_VALUE_NULL;
                int i2 = z7 ? byteBuffer.get() & 255 : 0;
                if (z2 && i != 0) {
                    throw new FormatException("expected zero-length type in non-leading chunk");
                }
                if (!z2) {
                    byte[] bArr3 = i > 0 ? new byte[i] : EMPTY_BYTE_ARRAY;
                    bArr2 = i2 > 0 ? new byte[i2] : EMPTY_BYTE_ARRAY;
                    byteBuffer.get(bArr3);
                    byteBuffer.get(bArr2);
                    bArr = bArr3;
                }
                ensureSanePayloadSize(j);
                byte[] bArr4 = j > 0 ? new byte[(int) j] : EMPTY_BYTE_ARRAY;
                byteBuffer.get(bArr4);
                short s3 = s;
                if (z5) {
                    s3 = s;
                    if (!z2) {
                        arrayList2.clear();
                        s3 = s2;
                    }
                }
                if (z5 || z2) {
                    arrayList2.add(bArr4);
                }
                byte[] bArr5 = bArr4;
                short s4 = s2;
                if (!z5) {
                    bArr5 = bArr4;
                    s4 = s2;
                    if (z2) {
                        long j2 = 0;
                        while (arrayList2.iterator().hasNext()) {
                            j2 += ((byte[]) it.next()).length;
                        }
                        ensureSanePayloadSize(j2);
                        bArr5 = new byte[(int) j2];
                        int i3 = 0;
                        Iterator it2 = arrayList2.iterator();
                        while (it2.hasNext()) {
                            byte[] bArr6 = (byte[]) it2.next();
                            System.arraycopy(bArr6, 0, bArr5, i3, bArr6.length);
                            i3 += bArr6.length;
                        }
                        s4 = s3;
                    }
                }
                if (z5) {
                    z2 = true;
                    s = s3;
                } else {
                    z2 = false;
                    String validateTnf = validateTnf(s4, bArr, bArr2, bArr5);
                    if (validateTnf != null) {
                        throw new FormatException(validateTnf);
                    }
                    arrayList.add(new NdefRecord(s4, bArr, bArr2, bArr5));
                    s = s3;
                    if (z) {
                        break;
                    }
                }
            }
            return (NdefRecord[]) arrayList.toArray(new NdefRecord[arrayList.size()]);
        } catch (BufferUnderflowException e) {
            throw new FormatException("expected more data", e);
        }
    }

    private Uri parseWktUri() {
        int i;
        if (this.mPayload.length >= 2 && (i = this.mPayload[0] & (-1)) >= 0 && i < URI_PREFIX_MAP.length) {
            return Uri.parse(URI_PREFIX_MAP[i] + new String(Arrays.copyOfRange(this.mPayload, 1, this.mPayload.length), StandardCharsets.UTF_8));
        }
        return null;
    }

    private Uri toUri(boolean z) {
        Uri parseWktUri;
        switch (this.mTnf) {
            case 1:
                if (!Arrays.equals(this.mType, RTD_SMART_POSTER) || z) {
                    if (!Arrays.equals(this.mType, RTD_URI) || (parseWktUri = parseWktUri()) == null) {
                        return null;
                    }
                    return parseWktUri.normalizeScheme();
                }
                try {
                    NdefRecord[] records = new NdefMessage(this.mPayload).getRecords();
                    int length = records.length;
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= length) {
                            return null;
                        }
                        Uri uri = records[i2].toUri(true);
                        if (uri != null) {
                            return uri;
                        }
                        i = i2 + 1;
                    }
                } catch (FormatException e) {
                    return null;
                }
                break;
            case 2:
            default:
                return null;
            case 3:
                return Uri.parse(new String(this.mType, StandardCharsets.UTF_8)).normalizeScheme();
            case 4:
                if (z) {
                    return null;
                }
                return Uri.parse("vnd.android.nfc://ext/" + new String(this.mType, StandardCharsets.US_ASCII));
        }
    }

    static String validateTnf(short s, byte[] bArr, byte[] bArr2, byte[] bArr3) {
        String str = null;
        switch (s) {
            case 0:
                if (bArr.length != 0 || bArr2.length != 0) {
                    return "unexpected data in TNF_EMPTY record";
                }
                str = null;
                if (bArr3.length != 0) {
                    return "unexpected data in TNF_EMPTY record";
                }
                break;
            case 1:
            case 2:
            case 3:
            case 4:
                break;
            case 5:
            case 7:
                str = null;
                if (bArr.length != 0) {
                    return "unexpected type field in TNF_UNKNOWN or TNF_RESERVEd record";
                }
                break;
            case 6:
                return "unexpected TNF_UNCHANGED in first chunk or logical record";
            default:
                str = String.format("unexpected tnf value: 0x%02x", Short.valueOf(s));
                break;
        }
        return str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        boolean z;
        if (this == obj) {
            z = true;
        } else {
            z = false;
            if (obj != null) {
                z = false;
                if (getClass() == obj.getClass()) {
                    NdefRecord ndefRecord = (NdefRecord) obj;
                    z = false;
                    if (Arrays.equals(this.mId, ndefRecord.mId)) {
                        z = false;
                        if (Arrays.equals(this.mPayload, ndefRecord.mPayload)) {
                            z = false;
                            if (this.mTnf == ndefRecord.mTnf) {
                                return Arrays.equals(this.mType, ndefRecord.mType);
                            }
                        }
                    }
                }
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getByteLength() {
        int length = this.mType.length + 3 + this.mId.length + this.mPayload.length;
        boolean z = this.mPayload.length < 256;
        boolean z2 = this.mId.length > 0;
        int i = length;
        if (!z) {
            i = length + 3;
        }
        int i2 = i;
        if (z2) {
            i2 = i + 1;
        }
        return i2;
    }

    public byte[] getId() {
        return (byte[]) this.mId.clone();
    }

    public byte[] getPayload() {
        return (byte[]) this.mPayload.clone();
    }

    public short getTnf() {
        return this.mTnf;
    }

    public byte[] getType() {
        return (byte[]) this.mType.clone();
    }

    public int hashCode() {
        return ((((((Arrays.hashCode(this.mId) + 31) * 31) + Arrays.hashCode(this.mPayload)) * 31) + this.mTnf) * 31) + Arrays.hashCode(this.mType);
    }

    @Deprecated
    public byte[] toByteArray() {
        ByteBuffer allocate = ByteBuffer.allocate(getByteLength());
        writeToByteBuffer(allocate, true, true);
        return allocate.array();
    }

    public String toMimeType() {
        switch (this.mTnf) {
            case 1:
                if (Arrays.equals(this.mType, RTD_TEXT)) {
                    return "text/plain";
                }
                return null;
            case 2:
                return Intent.normalizeMimeType(new String(this.mType, StandardCharsets.US_ASCII));
            default:
                return null;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(String.format("NdefRecord tnf=%X", Short.valueOf(this.mTnf)));
        if (this.mType.length > 0) {
            sb.append(" type=").append((CharSequence) bytesToString(this.mType));
        }
        if (this.mId.length > 0) {
            sb.append(" id=").append((CharSequence) bytesToString(this.mId));
        }
        if (this.mPayload.length > 0) {
            sb.append(" payload=").append((CharSequence) bytesToString(this.mPayload));
        }
        return sb.toString();
    }

    public Uri toUri() {
        return toUri(false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void writeToByteBuffer(ByteBuffer byteBuffer, boolean z, boolean z2) {
        int i = 0;
        boolean z3 = this.mPayload.length < 256;
        boolean z4 = this.mId.length > 0;
        int i2 = z ? -128 : 0;
        int i3 = z2 ? 64 : 0;
        int i4 = z3 ? 16 : 0;
        if (z4) {
            i = 8;
        }
        byteBuffer.put((byte) (i4 | i2 | i3 | i | this.mTnf));
        byteBuffer.put((byte) this.mType.length);
        if (z3) {
            byteBuffer.put((byte) this.mPayload.length);
        } else {
            byteBuffer.putInt(this.mPayload.length);
        }
        if (z4) {
            byteBuffer.put((byte) this.mId.length);
        }
        byteBuffer.put(this.mType);
        byteBuffer.put(this.mId);
        byteBuffer.put(this.mPayload);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mTnf);
        parcel.writeInt(this.mType.length);
        parcel.writeByteArray(this.mType);
        parcel.writeInt(this.mId.length);
        parcel.writeByteArray(this.mId);
        parcel.writeInt(this.mPayload.length);
        parcel.writeByteArray(this.mPayload);
    }
}
