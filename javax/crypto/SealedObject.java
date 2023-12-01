package javax.crypto;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import libcore.io.IoUtils;

/* loaded from: source-2895416-dex2jar.jar:javax/crypto/SealedObject.class */
public class SealedObject implements Serializable {
    private static final long serialVersionUID = 4482838265551344752L;
    protected byte[] encodedParams;
    private byte[] encryptedContent;
    private String paramsAlg;
    private String sealAlg;

    public SealedObject(Serializable serializable, Cipher cipher) throws IOException, IllegalBlockSizeException {
        if (cipher == null) {
            throw new NullPointerException("c == null");
        }
        ObjectOutputStream objectOutputStream = null;
        try {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(byteArrayOutputStream);
                try {
                    objectOutputStream2.writeObject(serializable);
                    objectOutputStream2.flush();
                    AlgorithmParameters parameters = cipher.getParameters();
                    this.encodedParams = parameters == null ? null : parameters.getEncoded();
                    this.paramsAlg = parameters == null ? null : parameters.getAlgorithm();
                    this.sealAlg = cipher.getAlgorithm();
                    this.encryptedContent = cipher.doFinal(byteArrayOutputStream.toByteArray());
                    IoUtils.closeQuietly(objectOutputStream2);
                } catch (BadPaddingException e) {
                    e = e;
                    throw new IOException(e.toString());
                } catch (Throwable th) {
                    th = th;
                    objectOutputStream = objectOutputStream2;
                    IoUtils.closeQuietly(objectOutputStream);
                    throw th;
                }
            } catch (BadPaddingException e2) {
                e = e2;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    protected SealedObject(SealedObject sealedObject) {
        if (sealedObject == null) {
            throw new NullPointerException("so == null");
        }
        this.encryptedContent = sealedObject.encryptedContent != null ? (byte[]) sealedObject.encryptedContent.clone() : null;
        this.encodedParams = sealedObject.encodedParams != null ? (byte[]) sealedObject.encodedParams.clone() : null;
        this.sealAlg = sealedObject.sealAlg;
        this.paramsAlg = sealedObject.paramsAlg;
    }

    private static byte[] getSafeCopy(ObjectInputStream.GetField getField, String str) throws IOException {
        byte[] bArr = (byte[]) getField.get(str, (Object) null);
        if (bArr != null) {
            return (byte[]) bArr.clone();
        }
        return null;
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        ObjectInputStream.GetField readFields = objectInputStream.readFields();
        this.encodedParams = getSafeCopy(readFields, "encodedParams");
        this.encryptedContent = getSafeCopy(readFields, "encryptedContent");
        this.paramsAlg = (String) readFields.get("paramsAlg", (Object) null);
        this.sealAlg = (String) readFields.get("sealAlg", (Object) null);
    }

    private static Object readSerialized(byte[] bArr) throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream;
        try {
            objectInputStream = new ObjectInputStream(new ByteArrayInputStream(bArr));
        } catch (Throwable th) {
            th = th;
            objectInputStream = null;
        }
        try {
            Object readObject = objectInputStream.readObject();
            IoUtils.closeQuietly(objectInputStream);
            return readObject;
        } catch (Throwable th2) {
            th = th2;
            IoUtils.closeQuietly(objectInputStream);
            throw th;
        }
    }

    public final String getAlgorithm() {
        return this.sealAlg;
    }

    public final Object getObject(Key key) throws IOException, ClassNotFoundException, NoSuchAlgorithmException, InvalidKeyException {
        if (key == null) {
            throw new InvalidKeyException("key == null");
        }
        try {
            Cipher cipher = Cipher.getInstance(this.sealAlg);
            if (this.paramsAlg == null || this.paramsAlg.length() == 0) {
                cipher.init(2, key);
            } else {
                AlgorithmParameters algorithmParameters = AlgorithmParameters.getInstance(this.paramsAlg);
                algorithmParameters.init(this.encodedParams);
                cipher.init(2, key, algorithmParameters);
            }
            return readSerialized(cipher.doFinal(this.encryptedContent));
        } catch (IllegalStateException e) {
            throw new NoSuchAlgorithmException(e.toString());
        } catch (InvalidAlgorithmParameterException e2) {
            throw new NoSuchAlgorithmException(e2.toString());
        } catch (BadPaddingException e3) {
            throw new NoSuchAlgorithmException(e3.toString());
        } catch (IllegalBlockSizeException e4) {
            throw new NoSuchAlgorithmException(e4.toString());
        } catch (NoSuchPaddingException e5) {
            throw new NoSuchAlgorithmException(e5.toString());
        }
    }

    public final Object getObject(Key key, String str) throws IOException, ClassNotFoundException, NoSuchAlgorithmException, NoSuchProviderException, InvalidKeyException {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("provider name empty or null");
        }
        try {
            Cipher cipher = Cipher.getInstance(this.sealAlg, str);
            if (this.paramsAlg == null || this.paramsAlg.length() == 0) {
                cipher.init(2, key);
            } else {
                AlgorithmParameters algorithmParameters = AlgorithmParameters.getInstance(this.paramsAlg);
                algorithmParameters.init(this.encodedParams);
                cipher.init(2, key, algorithmParameters);
            }
            return readSerialized(cipher.doFinal(this.encryptedContent));
        } catch (IllegalStateException e) {
            throw new NoSuchAlgorithmException(e.toString());
        } catch (InvalidAlgorithmParameterException e2) {
            throw new NoSuchAlgorithmException(e2.toString());
        } catch (BadPaddingException e3) {
            throw new NoSuchAlgorithmException(e3.toString());
        } catch (IllegalBlockSizeException e4) {
            throw new NoSuchAlgorithmException(e4.toString());
        } catch (NoSuchPaddingException e5) {
            throw new NoSuchAlgorithmException(e5.toString());
        }
    }

    public final Object getObject(Cipher cipher) throws IOException, ClassNotFoundException, IllegalBlockSizeException, BadPaddingException {
        if (cipher == null) {
            throw new NullPointerException("c == null");
        }
        return readSerialized(cipher.doFinal(this.encryptedContent));
    }
}
