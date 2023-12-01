package android.security;

import android.os.Environment;
import android.os.FileUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import javax.crypto.KeyGenerator;
import libcore.io.IoUtils;

/* loaded from: source-9557208-dex2jar.jar:android/security/SystemKeyStore.class */
public class SystemKeyStore {
    private static final String KEY_FILE_EXTENSION = ".sks";
    private static final String SYSTEM_KEYSTORE_DIRECTORY = "misc/systemkeys";
    private static SystemKeyStore mInstance = new SystemKeyStore();

    private SystemKeyStore() {
    }

    public static SystemKeyStore getInstance() {
        return mInstance;
    }

    private File getKeyFile(String str) {
        return new File(new File(Environment.getDataDirectory(), SYSTEM_KEYSTORE_DIRECTORY), str + KEY_FILE_EXTENSION);
    }

    public static String toHexString(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        int length = bArr.length;
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= bArr.length) {
                return sb.toString();
            }
            String num = Integer.toString(bArr[i2] & 255, 16);
            String str = num;
            if (num.length() == 1) {
                str = "0" + num;
            }
            sb.append(str);
            i = i2 + 1;
        }
    }

    public void deleteKey(String str) {
        File keyFile = getKeyFile(str);
        if (!keyFile.exists()) {
            throw new IllegalArgumentException();
        }
        keyFile.delete();
    }

    public byte[] generateNewKey(int i, String str, String str2) throws NoSuchAlgorithmException {
        File keyFile = getKeyFile(str2);
        if (keyFile.exists()) {
            throw new IllegalArgumentException();
        }
        KeyGenerator keyGenerator = KeyGenerator.getInstance(str);
        keyGenerator.init(i, SecureRandom.getInstance("SHA1PRNG"));
        byte[] encoded = keyGenerator.generateKey().getEncoded();
        try {
            if (keyFile.createNewFile()) {
                FileOutputStream fileOutputStream = new FileOutputStream(keyFile);
                fileOutputStream.write(encoded);
                fileOutputStream.flush();
                FileUtils.sync(fileOutputStream);
                fileOutputStream.close();
                FileUtils.setPermissions(keyFile.getName(), 384, -1, -1);
                return encoded;
            }
            throw new IllegalArgumentException();
        } catch (IOException e) {
            return null;
        }
    }

    public String generateNewKeyHexString(int i, String str, String str2) throws NoSuchAlgorithmException {
        return toHexString(generateNewKey(i, str, str2));
    }

    public byte[] retrieveKey(String str) throws IOException {
        File keyFile = getKeyFile(str);
        if (keyFile.exists()) {
            return IoUtils.readFileAsByteArray(keyFile.toString());
        }
        return null;
    }

    public String retrieveKeyHexString(String str) throws IOException {
        return toHexString(retrieveKey(str));
    }
}
