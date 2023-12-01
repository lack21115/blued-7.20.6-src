package java.security;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/* loaded from: source-2895416-dex2jar.jar:java/security/SignedObject.class */
public final class SignedObject implements Serializable {
    private static final long serialVersionUID = 720502720485447167L;
    private byte[] content;
    private byte[] signature;
    private String thealgorithm;

    public SignedObject(Serializable serializable, PrivateKey privateKey, Signature signature) throws IOException, InvalidKeyException, SignatureException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        try {
            objectOutputStream.writeObject(serializable);
            objectOutputStream.flush();
            objectOutputStream.close();
            this.content = byteArrayOutputStream.toByteArray();
            signature.initSign(privateKey);
            this.thealgorithm = signature.getAlgorithm();
            signature.update(this.content);
            this.signature = signature.sign();
        } catch (Throwable th) {
            objectOutputStream.close();
            throw th;
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        byte[] bArr = new byte[this.content.length];
        System.arraycopy(this.content, 0, bArr, 0, this.content.length);
        this.content = bArr;
        byte[] bArr2 = new byte[this.signature.length];
        System.arraycopy(this.signature, 0, bArr2, 0, this.signature.length);
        this.signature = bArr2;
    }

    public String getAlgorithm() {
        return this.thealgorithm;
    }

    public Object getObject() throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(this.content));
        try {
            return objectInputStream.readObject();
        } finally {
            objectInputStream.close();
        }
    }

    public byte[] getSignature() {
        byte[] bArr = new byte[this.signature.length];
        System.arraycopy(this.signature, 0, bArr, 0, this.signature.length);
        return bArr;
    }

    public boolean verify(PublicKey publicKey, Signature signature) throws InvalidKeyException, SignatureException {
        signature.initVerify(publicKey);
        signature.update(this.content);
        return signature.verify(this.signature);
    }
}
