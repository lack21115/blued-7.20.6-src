package com.tencent.cos.xml.crypto;

import com.tencent.cos.xml.exception.CosXmlClientException;
import com.tencent.cos.xml.model.CosXmlRequest;
import com.tencent.cos.xml.s3.Base64;
import com.tencentcloudapi.kms.v20190118.models.DecryptRequest;
import com.tencentcloudapi.kms.v20190118.models.EncryptRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONException;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/crypto/ContentCryptoMaterial.class */
final class ContentCryptoMaterial {
    private final CipherLite cipherLite;
    private final byte[] encryptedCEK;
    private final Map<String, String> kekMaterialsDescription;
    private final String keyWrappingAlgorithm;

    ContentCryptoMaterial(Map<String, String> map, byte[] bArr, String str, CipherLite cipherLite) {
        this.cipherLite = cipherLite;
        this.keyWrappingAlgorithm = str;
        this.encryptedCEK = (byte[]) bArr.clone();
        this.kekMaterialsDescription = map;
    }

    private static SecretKey cek(byte[] bArr, String str, EncryptionMaterials encryptionMaterials, Provider provider, ContentCryptoScheme contentCryptoScheme, QCLOUDKMS qcloudkms) throws CosXmlClientException {
        PrivateKey symmetricKey;
        if (KMSSecuredCEK.isKMSKeyWrapped(str)) {
            return cekByKMS(bArr, str, encryptionMaterials, contentCryptoScheme, qcloudkms);
        }
        if (encryptionMaterials.getKeyPair() != null) {
            symmetricKey = encryptionMaterials.getKeyPair().getPrivate();
            if (symmetricKey == null) {
                throw CosXmlClientException.internalException("Key encrypting key not available");
            }
        } else {
            symmetricKey = encryptionMaterials.getSymmetricKey();
            if (symmetricKey == null) {
                throw CosXmlClientException.internalException("Key encrypting key not available");
            }
        }
        try {
            if (str != null) {
                Cipher cipher = provider == null ? Cipher.getInstance(str) : Cipher.getInstance(str, provider);
                cipher.init(4, symmetricKey);
                return (SecretKey) cipher.unwrap(bArr, str, 3);
            }
            Cipher cipher2 = provider != null ? Cipher.getInstance(symmetricKey.getAlgorithm(), provider) : Cipher.getInstance(symmetricKey.getAlgorithm());
            cipher2.init(2, symmetricKey);
            return new SecretKeySpec(cipher2.doFinal(bArr), "AES");
        } catch (Exception e) {
            throw CosXmlClientException.internalException("Unable to decrypt symmetric key from object metadata");
        }
    }

    private static SecretKey cekByKMS(byte[] bArr, String str, EncryptionMaterials encryptionMaterials, ContentCryptoScheme contentCryptoScheme, QCLOUDKMS qcloudkms) throws CosXmlClientException {
        DecryptRequest decryptRequest = new DecryptRequest();
        try {
            decryptRequest.setEncryptionContext(JSONUtils.toJsonString(encryptionMaterials.getMaterialsDescription()));
            decryptRequest.setCiphertextBlob(new String(bArr));
            return new SecretKeySpec(Base64.decode(qcloudkms.decrypt(decryptRequest).getPlaintext()), contentCryptoScheme.getKeyGeneratorAlgorithm());
        } catch (JSONException e) {
            throw CosXmlClientException.internalException("decrypt request set encryption context got json processing exception");
        }
    }

    private static String convertStreamToString(InputStream inputStream) throws IOException {
        if (inputStream == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, Charset.forName("UTF-8")));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    inputStream.close();
                    return sb.toString();
                }
                sb.append(readLine);
            }
        } catch (Throwable th) {
            inputStream.close();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ContentCryptoMaterial create(SecretKey secretKey, byte[] bArr, EncryptionMaterials encryptionMaterials, COSCryptoScheme cOSCryptoScheme, Provider provider, QCLOUDKMS qcloudkms, CosXmlRequest cosXmlRequest) throws CosXmlClientException {
        return doCreate(secretKey, bArr, encryptionMaterials, cOSCryptoScheme.getContentCryptoScheme(), cOSCryptoScheme, provider, qcloudkms, cosXmlRequest);
    }

    static ContentCryptoMaterial create(SecretKey secretKey, byte[] bArr, EncryptionMaterials encryptionMaterials, ContentCryptoScheme contentCryptoScheme, COSCryptoScheme cOSCryptoScheme, Provider provider, QCLOUDKMS qcloudkms, CosXmlRequest cosXmlRequest) throws CosXmlClientException {
        return doCreate(secretKey, bArr, encryptionMaterials, contentCryptoScheme, cOSCryptoScheme, provider, qcloudkms, cosXmlRequest);
    }

    private static ContentCryptoMaterial doCreate(SecretKey secretKey, byte[] bArr, EncryptionMaterials encryptionMaterials, ContentCryptoScheme contentCryptoScheme, COSCryptoScheme cOSCryptoScheme, Provider provider, QCLOUDKMS qcloudkms, CosXmlRequest cosXmlRequest) throws CosXmlClientException {
        return wrap(secretKey, bArr, contentCryptoScheme, provider, secureCEK(secretKey, encryptionMaterials, cOSCryptoScheme.getKeyWrapScheme(), cOSCryptoScheme.getSecureRandom(), provider, qcloudkms, cosXmlRequest));
    }

    static ContentCryptoMaterial fromObjectMetadata(ObjectMetadata objectMetadata, EncryptionMaterialsAccessor encryptionMaterialsAccessor, Provider provider, boolean z, QCLOUDKMS qcloudkms) throws CosXmlClientException, JSONException {
        return fromObjectMetadata0(objectMetadata, encryptionMaterialsAccessor, provider, null, z, qcloudkms);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ContentCryptoMaterial fromObjectMetadata(ObjectMetadata objectMetadata, EncryptionMaterialsAccessor encryptionMaterialsAccessor, Provider provider, long[] jArr, boolean z, QCLOUDKMS qcloudkms) throws CosXmlClientException, JSONException {
        return fromObjectMetadata0(objectMetadata, encryptionMaterialsAccessor, provider, jArr, z, qcloudkms);
    }

    private static ContentCryptoMaterial fromObjectMetadata0(ObjectMetadata objectMetadata, EncryptionMaterialsAccessor encryptionMaterialsAccessor, Provider provider, long[] jArr, boolean z, QCLOUDKMS qcloudkms) throws CosXmlClientException, JSONException {
        KMSEncryptionMaterials encryptionMaterials;
        byte[] bArr;
        Map<String, String> userMetadata = objectMetadata.getUserMetadata();
        String str = userMetadata.get("x-cos-meta-client-side-encryption-key");
        String str2 = str;
        if (str == null) {
            str2 = userMetadata.get("x-cos-meta-client-side-encryption-key");
            if (str2 == null) {
                throw CosXmlClientException.internalException("Content encrypting key not found.");
            }
        }
        byte[] decode = Base64.decode(str2);
        byte[] decode2 = Base64.decode(userMetadata.get(Headers.CRYPTO_IV));
        if (decode == null || decode2 == null) {
            throw CosXmlClientException.internalException("Content encrypting key or IV not found.");
        }
        String str3 = userMetadata.get(Headers.MATERIALS_DESCRIPTION);
        String str4 = userMetadata.get(Headers.CRYPTO_KEYWRAP_ALGORITHM);
        boolean isKMSKeyWrapped = KMSSecuredCEK.isKMSKeyWrapped(str4);
        Map<String, String> matdescFromJson = matdescFromJson(str3);
        if (isKMSKeyWrapped) {
            encryptionMaterials = new KMSEncryptionMaterials(matdescFromJson.get(KMSEncryptionMaterials.CUSTOMER_MASTER_KEY_ID));
            encryptionMaterials.addDescriptions(matdescFromJson);
        } else {
            encryptionMaterials = encryptionMaterialsAccessor == null ? null : encryptionMaterialsAccessor.getEncryptionMaterials(matdescFromJson);
            if (encryptionMaterials == null) {
                throw CosXmlClientException.internalException("Unable to retrieve the client encryption materials");
            }
        }
        String str5 = userMetadata.get(Headers.CRYPTO_CEK_ALGORITHM);
        boolean z2 = jArr != null;
        ContentCryptoScheme fromCEKAlgo = ContentCryptoScheme.fromCEKAlgo(str5);
        if (z2) {
            bArr = fromCEKAlgo.adjustIV(decode2, jArr[0]);
        } else {
            int tagLengthInBits = fromCEKAlgo.getTagLengthInBits();
            bArr = decode2;
            if (tagLengthInBits > 0) {
                int parseInt = Integer.parseInt(userMetadata.get(Headers.CRYPTO_TAG_LENGTH));
                if (tagLengthInBits != parseInt) {
                    throw CosXmlClientException.internalException("Unsupported tag length: " + parseInt + ", expected: " + tagLengthInBits);
                }
                bArr = decode2;
            }
        }
        if (z && str4 == null) {
            throw newKeyWrapException();
        }
        return new ContentCryptoMaterial(matdescFromJson, decode, str4, fromCEKAlgo.createCipherLite(cek(decode, str4, encryptionMaterials, provider, fromCEKAlgo, qcloudkms), bArr, 2, provider));
    }

    private String kekMaterialDescAsJson() throws JSONException {
        Map<String, String> kEKMaterialsDescription = getKEKMaterialsDescription();
        Map<String, String> map = kEKMaterialsDescription;
        if (kEKMaterialsDescription == null) {
            map = Collections.emptyMap();
        }
        return JSONUtils.toJsonString(map);
    }

    private static Map<String, String> matdescFromJson(String str) throws JSONException {
        Map<String, String> map = JSONUtils.toMap(str);
        if (map == null) {
            return null;
        }
        return Collections.unmodifiableMap(map);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Map<String, String> mergeMaterialDescriptions(EncryptionMaterials encryptionMaterials, CosXmlRequest cosXmlRequest) {
        Map<String, String> materialsDescription = encryptionMaterials.getMaterialsDescription();
        TreeMap treeMap = materialsDescription;
        if (cosXmlRequest instanceof MaterialsDescriptionProvider) {
            Map<String, String> materialsDescription2 = ((MaterialsDescriptionProvider) cosXmlRequest).getMaterialsDescription();
            treeMap = materialsDescription;
            if (materialsDescription2 != null) {
                treeMap = new TreeMap(materialsDescription);
                treeMap.putAll(materialsDescription2);
            }
        }
        return treeMap;
    }

    private static CosXmlClientException newKeyWrapException() throws CosXmlClientException {
        return CosXmlClientException.internalException("Missing key-wrap for the content-encrypting-key");
    }

    private static SecuredCEK secureCEK(SecretKey secretKey, EncryptionMaterials encryptionMaterials, COSKeyWrapScheme cOSKeyWrapScheme, SecureRandom secureRandom, Provider provider, QCLOUDKMS qcloudkms, CosXmlRequest cosXmlRequest) throws CosXmlClientException {
        if (encryptionMaterials.isKMSEnabled()) {
            Map<String, String> mergeMaterialDescriptions = mergeMaterialDescriptions(encryptionMaterials, cosXmlRequest);
            EncryptRequest encryptRequest = new EncryptRequest();
            try {
                encryptRequest.setEncryptionContext(JSONUtils.toJsonString(mergeMaterialDescriptions));
                encryptRequest.setKeyId(encryptionMaterials.getCustomerMasterKeyId());
                encryptRequest.setPlaintext(secretKey.getEncoded().toString());
                return new KMSSecuredCEK(qcloudkms.encrypt(encryptRequest).getCiphertextBlob().getBytes(), mergeMaterialDescriptions);
            } catch (JSONException e) {
                throw CosXmlClientException.internalException("encrypt request set encryption context got json processing exception");
            }
        }
        Map<String, String> materialsDescription = encryptionMaterials.getMaterialsDescription();
        SecretKey secretKey2 = encryptionMaterials.getKeyPair() != null ? encryptionMaterials.getKeyPair().getPublic() : encryptionMaterials.getSymmetricKey();
        String keyWrapAlgorithm = cOSKeyWrapScheme.getKeyWrapAlgorithm(secretKey2);
        try {
            Cipher cipher = provider == null ? Cipher.getInstance(keyWrapAlgorithm) : Cipher.getInstance(keyWrapAlgorithm, provider);
            cipher.init(3, secretKey2, secureRandom);
            return new SecuredCEK(cipher.wrap(secretKey), keyWrapAlgorithm, materialsDescription);
        } catch (Exception e2) {
            throw CosXmlClientException.internalException("Unable to encrypt symmetric key");
        }
    }

    private boolean usesKMSKey() {
        return KMSSecuredCEK.isKMSKeyWrapped(this.keyWrappingAlgorithm);
    }

    public static ContentCryptoMaterial wrap(SecretKey secretKey, byte[] bArr, ContentCryptoScheme contentCryptoScheme, Provider provider, SecuredCEK securedCEK) throws CosXmlClientException {
        return new ContentCryptoMaterial(securedCEK.getMaterialDescription(), securedCEK.getEncrypted(), securedCEK.getKeyWrapAlgorithm(), contentCryptoScheme.createCipherLite(secretKey, bArr, 1, provider));
    }

    public CipherLite getCipherLite() {
        return this.cipherLite;
    }

    ContentCryptoScheme getContentCryptoScheme() {
        return this.cipherLite.getContentCryptoScheme();
    }

    byte[] getEncryptedCEK() {
        return (byte[]) this.encryptedCEK.clone();
    }

    Map<String, String> getKEKMaterialsDescription() {
        return this.kekMaterialsDescription;
    }

    String getKeyWrappingAlgorithm() {
        return this.keyWrappingAlgorithm;
    }

    ContentCryptoMaterial recreate(EncryptionMaterials encryptionMaterials, EncryptionMaterialsAccessor encryptionMaterialsAccessor, COSCryptoScheme cOSCryptoScheme, Provider provider, QCLOUDKMS qcloudkms, CosXmlRequest cosXmlRequest) throws CosXmlClientException {
        KMSEncryptionMaterials encryptionMaterials2;
        if (usesKMSKey() || !encryptionMaterials.getMaterialsDescription().equals(this.kekMaterialsDescription)) {
            if (usesKMSKey()) {
                encryptionMaterials2 = new KMSEncryptionMaterials(this.kekMaterialsDescription.get(KMSEncryptionMaterials.CUSTOMER_MASTER_KEY_ID));
            } else {
                encryptionMaterials2 = encryptionMaterialsAccessor.getEncryptionMaterials(this.kekMaterialsDescription);
                if (encryptionMaterials2 == null) {
                    throw CosXmlClientException.internalException("Unable to retrieve the origin encryption materials");
                }
            }
            ContentCryptoMaterial create = create(cek(this.encryptedCEK, this.keyWrappingAlgorithm, encryptionMaterials2, provider, getContentCryptoScheme(), qcloudkms), this.cipherLite.getIV(), encryptionMaterials, getContentCryptoScheme(), cOSCryptoScheme, provider, qcloudkms, cosXmlRequest);
            if (Arrays.equals(create.encryptedCEK, this.encryptedCEK)) {
                throw new SecurityException("The new KEK must differ from the original");
            }
            return create;
        }
        throw new SecurityException("Material description of the new KEK must differ from the current one");
    }

    ContentCryptoMaterial recreate(Map<String, String> map, EncryptionMaterialsAccessor encryptionMaterialsAccessor, COSCryptoScheme cOSCryptoScheme, Provider provider, QCLOUDKMS qcloudkms, CosXmlRequest cosXmlRequest) throws CosXmlClientException {
        KMSEncryptionMaterials encryptionMaterials;
        if (usesKMSKey() || !map.equals(this.kekMaterialsDescription)) {
            if (usesKMSKey()) {
                encryptionMaterials = new KMSEncryptionMaterials(this.kekMaterialsDescription.get(KMSEncryptionMaterials.CUSTOMER_MASTER_KEY_ID));
            } else {
                encryptionMaterials = encryptionMaterialsAccessor.getEncryptionMaterials(this.kekMaterialsDescription);
                if (encryptionMaterials == null) {
                    throw CosXmlClientException.internalException("Unable to retrieve the origin encryption materials");
                }
            }
            EncryptionMaterials encryptionMaterials2 = encryptionMaterialsAccessor.getEncryptionMaterials(map);
            if (encryptionMaterials2 != null) {
                ContentCryptoMaterial create = create(cek(this.encryptedCEK, this.keyWrappingAlgorithm, encryptionMaterials, provider, getContentCryptoScheme(), qcloudkms), this.cipherLite.getIV(), encryptionMaterials2, getContentCryptoScheme(), cOSCryptoScheme, provider, qcloudkms, cosXmlRequest);
                if (Arrays.equals(create.encryptedCEK, this.encryptedCEK)) {
                    throw new SecurityException("The new KEK must differ from the original");
                }
                return create;
            }
            throw CosXmlClientException.internalException("No material available with the description " + map + " from the encryption material provider");
        }
        throw new SecurityException("Material description of the new KEK must differ from the current one");
    }

    String toJsonString() throws JSONException {
        HashMap hashMap = new HashMap();
        hashMap.put("x-cos-meta-client-side-encryption-key", Base64.encodeAsString(getEncryptedCEK()));
        hashMap.put(Headers.CRYPTO_IV, Base64.encodeAsString(this.cipherLite.getIV()));
        hashMap.put(Headers.MATERIALS_DESCRIPTION, kekMaterialDescAsJson());
        ContentCryptoScheme contentCryptoScheme = getContentCryptoScheme();
        hashMap.put(Headers.CRYPTO_CEK_ALGORITHM, contentCryptoScheme.getCipherAlgorithm());
        int tagLengthInBits = contentCryptoScheme.getTagLengthInBits();
        if (tagLengthInBits > 0) {
            hashMap.put(Headers.CRYPTO_TAG_LENGTH, String.valueOf(tagLengthInBits));
        }
        String keyWrappingAlgorithm = getKeyWrappingAlgorithm();
        if (keyWrappingAlgorithm != null) {
            hashMap.put(Headers.CRYPTO_KEYWRAP_ALGORITHM, keyWrappingAlgorithm);
        }
        return JSONUtils.toJsonString(hashMap);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ObjectMetadata toObjectMetadata(ObjectMetadata objectMetadata) throws JSONException {
        objectMetadata.addUserMetadata("x-cos-meta-client-side-encryption-key", Base64.encodeAsString(getEncryptedCEK()));
        objectMetadata.addUserMetadata(Headers.CRYPTO_IV, Base64.encodeAsString(this.cipherLite.getIV()));
        objectMetadata.addUserMetadata(Headers.MATERIALS_DESCRIPTION, kekMaterialDescAsJson());
        ContentCryptoScheme contentCryptoScheme = getContentCryptoScheme();
        objectMetadata.addUserMetadata(Headers.CRYPTO_CEK_ALGORITHM, contentCryptoScheme.getCipherAlgorithm());
        int tagLengthInBits = contentCryptoScheme.getTagLengthInBits();
        if (tagLengthInBits > 0) {
            objectMetadata.addUserMetadata(Headers.CRYPTO_TAG_LENGTH, String.valueOf(tagLengthInBits));
        }
        String keyWrappingAlgorithm = getKeyWrappingAlgorithm();
        if (keyWrappingAlgorithm != null) {
            objectMetadata.addUserMetadata(Headers.CRYPTO_KEYWRAP_ALGORITHM, keyWrappingAlgorithm);
        }
        return objectMetadata;
    }
}
