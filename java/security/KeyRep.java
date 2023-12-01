package java.security;

import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: source-2895416-dex2jar.jar:java/security/KeyRep.class */
public class KeyRep implements Serializable {
    private static final long serialVersionUID = -4757683898830641853L;
    private final String algorithm;
    private byte[] encoded;
    private final String format;
    private final Type type;

    /* renamed from: java.security.KeyRep$1  reason: invalid class name */
    /* loaded from: source-2895416-dex2jar.jar:java/security/KeyRep$1.class */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$java$security$KeyRep$Type = new int[Type.values().length];

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x002d -> B:17:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x0031 -> B:15:0x0014). Please submit an issue!!! */
        static {
            try {
                $SwitchMap$java$security$KeyRep$Type[Type.SECRET.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$java$security$KeyRep$Type[Type.PUBLIC.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$java$security$KeyRep$Type[Type.PRIVATE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    /* loaded from: source-2895416-dex2jar.jar:java/security/KeyRep$Type.class */
    public enum Type {
        SECRET,
        PUBLIC,
        PRIVATE
    }

    public KeyRep(Type type, String str, String str2, byte[] bArr) {
        this.type = type;
        this.algorithm = str;
        this.format = str2;
        this.encoded = bArr;
        if (this.type == null) {
            throw new NullPointerException("type == null");
        }
        if (this.algorithm == null) {
            throw new NullPointerException("algorithm == null");
        }
        if (this.format == null) {
            throw new NullPointerException("format == null");
        }
        if (this.encoded == null) {
            throw new NullPointerException("encoded == null");
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        byte[] bArr = new byte[this.encoded.length];
        System.arraycopy(this.encoded, 0, bArr, 0, bArr.length);
        this.encoded = bArr;
    }

    protected Object readResolve() throws ObjectStreamException {
        switch (AnonymousClass1.$SwitchMap$java$security$KeyRep$Type[this.type.ordinal()]) {
            case 1:
                if ("RAW".equals(this.format)) {
                    try {
                        return new SecretKeySpec(this.encoded, this.algorithm);
                    } catch (IllegalArgumentException e) {
                        throw new NotSerializableException("Could not create SecretKeySpec: " + e);
                    }
                }
                throw new NotSerializableException("unrecognized type/format combination: " + this.type + BridgeUtil.SPLIT_MARK + this.format);
            case 2:
                if ("X.509".equals(this.format)) {
                    try {
                        return KeyFactory.getInstance(this.algorithm).generatePublic(new X509EncodedKeySpec(this.encoded));
                    } catch (NoSuchAlgorithmException e2) {
                        throw new NotSerializableException("Could not resolve key: " + e2);
                    } catch (InvalidKeySpecException e3) {
                        throw new NotSerializableException("Could not resolve key: " + e3);
                    }
                }
                throw new NotSerializableException("unrecognized type/format combination: " + this.type + BridgeUtil.SPLIT_MARK + this.format);
            case 3:
                if ("PKCS#8".equals(this.format)) {
                    try {
                        return KeyFactory.getInstance(this.algorithm).generatePrivate(new PKCS8EncodedKeySpec(this.encoded));
                    } catch (NoSuchAlgorithmException e4) {
                        throw new NotSerializableException("Could not resolve key: " + e4);
                    } catch (InvalidKeySpecException e5) {
                        throw new NotSerializableException("Could not resolve key: " + e5);
                    }
                }
                throw new NotSerializableException("unrecognized type/format combination: " + this.type + BridgeUtil.SPLIT_MARK + this.format);
            default:
                throw new NotSerializableException("unrecognized key type: " + this.type);
        }
    }
}
