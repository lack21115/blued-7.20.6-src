package android.security;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.android.org.bouncycastle.util.io.pem.PemObject;
import com.android.org.bouncycastle.util.io.pem.PemReader;
import com.android.org.bouncycastle.util.io.pem.PemWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.security.KeyPair;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-9557208-dex2jar.jar:android/security/Credentials.class */
public class Credentials {
    public static final String CA_CERTIFICATE = "CACERT_";
    public static final String EXTENSION_CER = ".cer";
    public static final String EXTENSION_CRT = ".crt";
    public static final String EXTENSION_P12 = ".p12";
    public static final String EXTENSION_PFX = ".pfx";
    public static final String EXTRA_CA_CERTIFICATES_DATA = "ca_certificates_data";
    public static final String EXTRA_CA_CERTIFICATES_NAME = "ca_certificates_name";
    public static final String EXTRA_INSTALL_AS_UID = "install_as_uid";
    public static final String EXTRA_PRIVATE_KEY = "PKEY";
    public static final String EXTRA_PUBLIC_KEY = "KEY";
    public static final String EXTRA_USER_CERTIFICATE_DATA = "user_certificate_data";
    public static final String EXTRA_USER_CERTIFICATE_NAME = "user_certificate_name";
    public static final String EXTRA_USER_PRIVATE_KEY_DATA = "user_private_key_data";
    public static final String EXTRA_USER_PRIVATE_KEY_NAME = "user_private_key_name";
    public static final String INSTALL_ACTION = "android.credentials.INSTALL";
    public static final String INSTALL_AS_USER_ACTION = "android.credentials.INSTALL_AS_USER";
    public static final String LOCKDOWN_VPN = "LOCKDOWN_VPN";
    private static final String LOGTAG = "Credentials";
    public static final String UNLOCK_ACTION = "com.android.credentials.UNLOCK";
    public static final String USER_CERTIFICATE = "USRCERT_";
    public static final String USER_PRIVATE_KEY = "USRPKEY_";
    public static final String VPN = "VPN_";
    public static final String WIFI = "WIFI_";
    private static Credentials singleton;

    public static List<X509Certificate> convertFromPem(byte[] bArr) throws IOException, CertificateException {
        PemReader pemReader = new PemReader(new InputStreamReader(new ByteArrayInputStream(bArr), StandardCharsets.US_ASCII));
        CertificateFactory certificateFactory = CertificateFactory.getInstance("X509");
        ArrayList arrayList = new ArrayList();
        while (true) {
            PemObject readPemObject = pemReader.readPemObject();
            if (readPemObject == null) {
                pemReader.close();
                return arrayList;
            } else if (!readPemObject.getType().equals("CERTIFICATE")) {
                throw new IllegalArgumentException("Unknown type " + readPemObject.getType());
            } else {
                arrayList.add((X509Certificate) certificateFactory.generateCertificate(new ByteArrayInputStream(readPemObject.getContent())));
            }
        }
    }

    public static byte[] convertToPem(Certificate... certificateArr) throws IOException, CertificateEncodingException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PemWriter pemWriter = new PemWriter(new OutputStreamWriter(byteArrayOutputStream, StandardCharsets.US_ASCII));
        int length = certificateArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                pemWriter.close();
                return byteArrayOutputStream.toByteArray();
            }
            pemWriter.writeObject(new PemObject("CERTIFICATE", certificateArr[i2].getEncoded()));
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean deleteAllTypesForAlias(KeyStore keyStore, String str) {
        return keyStore.delKey(USER_PRIVATE_KEY + str) | deleteCertificateTypesForAlias(keyStore, str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean deleteCertificateTypesForAlias(KeyStore keyStore, String str) {
        return keyStore.delete(USER_CERTIFICATE + str) | keyStore.delete(CA_CERTIFICATE + str);
    }

    public static Credentials getInstance() {
        if (singleton == null) {
            singleton = new Credentials();
        }
        return singleton;
    }

    public void install(Context context) {
        try {
            context.startActivity(KeyChain.createInstallIntent());
        } catch (ActivityNotFoundException e) {
            Log.w(LOGTAG, e.toString());
        }
    }

    public void install(Context context, String str, byte[] bArr) {
        try {
            Intent createInstallIntent = KeyChain.createInstallIntent();
            createInstallIntent.putExtra(str, bArr);
            context.startActivity(createInstallIntent);
        } catch (ActivityNotFoundException e) {
            Log.w(LOGTAG, e.toString());
        }
    }

    public void install(Context context, KeyPair keyPair) {
        try {
            Intent createInstallIntent = KeyChain.createInstallIntent();
            createInstallIntent.putExtra(EXTRA_PRIVATE_KEY, keyPair.getPrivate().getEncoded());
            createInstallIntent.putExtra(EXTRA_PUBLIC_KEY, keyPair.getPublic().getEncoded());
            context.startActivity(createInstallIntent);
        } catch (ActivityNotFoundException e) {
            Log.w(LOGTAG, e.toString());
        }
    }

    public void unlock(Context context) {
        try {
            context.startActivity(new Intent(UNLOCK_ACTION));
        } catch (ActivityNotFoundException e) {
            Log.w(LOGTAG, e.toString());
        }
    }
}
