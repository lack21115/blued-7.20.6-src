package android.os;

import android.Manifest;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import com.heytap.mcssdk.constant.IntentConstant;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.security.GeneralSecurityException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.apache.harmony.security.asn1.BerInputStream;
import org.apache.harmony.security.pkcs7.ContentInfo;
import org.apache.harmony.security.pkcs7.SignedData;
import org.apache.harmony.security.pkcs7.SignerInfo;
import org.apache.harmony.security.x509.Certificate;

/* loaded from: source-9557208-dex2jar.jar:android/os/RecoverySystem.class */
public class RecoverySystem {
    private static final long PUBLISH_PROGRESS_INTERVAL_MS = 500;
    private static final String TAG = "RecoverySystem";
    private static final File DEFAULT_KEYSTORE = new File("/system/etc/security/otacerts.zip");
    private static File RECOVERY_DIR = new File("/cache/recovery");
    private static File COMMAND_FILE = new File(RECOVERY_DIR, IntentConstant.COMMAND);
    private static File LOG_FILE = new File(RECOVERY_DIR, "log");
    private static String LAST_PREFIX = "last_";
    private static int LOG_FILE_MAX_LENGTH = 65536;

    /* loaded from: source-9557208-dex2jar.jar:android/os/RecoverySystem$ProgressListener.class */
    public interface ProgressListener {
        void onProgress(int i);
    }

    private void RecoverySystem() {
    }

    private static void bootCommand(Context context, String... strArr) throws IOException {
        RECOVERY_DIR.mkdirs();
        COMMAND_FILE.delete();
        LOG_FILE.delete();
        FileWriter fileWriter = new FileWriter(COMMAND_FILE);
        try {
            int length = strArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    break;
                }
                String str = strArr[i2];
                if (!TextUtils.isEmpty(str)) {
                    fileWriter.write(str);
                    fileWriter.write("\n");
                }
                i = i2 + 1;
            }
            fileWriter.close();
            ((PowerManager) context.getSystemService(Context.POWER_SERVICE)).reboot(PowerManager.REBOOT_RECOVERY);
            throw new IOException("Reboot failed (no permissions?)");
        } catch (Throwable th) {
            fileWriter.close();
            throw th;
        }
    }

    private static HashSet<X509Certificate> getTrustedCerts(File file) throws IOException, GeneralSecurityException {
        HashSet<X509Certificate> hashSet = new HashSet<>();
        File file2 = file;
        if (file == null) {
            file2 = DEFAULT_KEYSTORE;
        }
        ZipFile zipFile = new ZipFile(file2);
        try {
            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
            Enumeration<? extends ZipEntry> entries = zipFile.entries();
            while (entries.hasMoreElements()) {
                InputStream inputStream = zipFile.getInputStream(entries.nextElement());
                hashSet.add((X509Certificate) certificateFactory.generateCertificate(inputStream));
                inputStream.close();
            }
            return hashSet;
        } finally {
            zipFile.close();
        }
    }

    public static String handleAftermath() {
        String str = null;
        try {
            str = FileUtils.readTextFile(LOG_FILE, -LOG_FILE_MAX_LENGTH, "...\n");
        } catch (FileNotFoundException e) {
            Log.i(TAG, "No recovery log file");
        } catch (IOException e2) {
            Log.e(TAG, "Error reading recovery log", e2);
        }
        String[] list = RECOVERY_DIR.list();
        int i = 0;
        while (true) {
            int i2 = i;
            if (list == null || i2 >= list.length) {
                break;
            }
            if (!list[i2].startsWith(LAST_PREFIX)) {
                File file = new File(RECOVERY_DIR, list[i2]);
                if (file.delete()) {
                    Log.i(TAG, "Deleted: " + file);
                } else {
                    Log.e(TAG, "Can't delete: " + file);
                }
            }
            i = i2 + 1;
        }
        return str;
    }

    public static void installPackage(Context context, File file) throws IOException {
        String canonicalPath = file.getCanonicalPath();
        Log.w(TAG, "!!! REBOOTING TO INSTALL " + canonicalPath + " !!!");
        bootCommand(context, "--update_package=" + canonicalPath, "--locale=" + Locale.getDefault().toString());
    }

    public static void rebootWipeCache(Context context) throws IOException {
        rebootWipeCache(context, context.getPackageName());
    }

    public static void rebootWipeCache(Context context, String str) throws IOException {
        String str2 = null;
        if (!TextUtils.isEmpty(str)) {
            str2 = "--reason=" + sanitizeArg(str);
        }
        bootCommand(context, "--wipe_cache", str2, "--locale=" + Locale.getDefault().toString());
    }

    public static void rebootWipeUserData(Context context) throws IOException {
        rebootWipeUserData(context, false, context.getPackageName(), false);
    }

    public static void rebootWipeUserData(Context context, String str) throws IOException {
        rebootWipeUserData(context, false, str, false);
    }

    public static void rebootWipeUserData(Context context, boolean z) throws IOException {
        rebootWipeUserData(context, z, context.getPackageName(), false);
    }

    public static void rebootWipeUserData(Context context, boolean z, String str, boolean z2) throws IOException {
        if (((UserManager) context.getSystemService("user")).hasUserRestriction(UserManager.DISALLOW_FACTORY_RESET)) {
            throw new SecurityException("Wiping data is not allowed for this user.");
        }
        final ConditionVariable conditionVariable = new ConditionVariable();
        Intent intent = new Intent("android.intent.action.MASTER_CLEAR_NOTIFICATION");
        intent.addFlags(268435456);
        context.sendOrderedBroadcastAsUser(intent, UserHandle.OWNER, Manifest.permission.MASTER_CLEAR, new BroadcastReceiver() { // from class: android.os.RecoverySystem.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, Intent intent2) {
                ConditionVariable.this.open();
            }
        }, null, 0, null, null);
        conditionVariable.block();
        String str2 = null;
        if (z) {
            str2 = "--shutdown_after";
        }
        String str3 = null;
        if (!TextUtils.isEmpty(str)) {
            str3 = "--reason=" + sanitizeArg(str);
        }
        bootCommand(context, str2, z2 ? "--wipe_data\n--wipe_media\n" : "--wipe_data\n", str3, "--locale=" + Locale.getDefault().toString());
    }

    private static String sanitizeArg(String str) {
        return str.replace((char) 0, '?').replace('\n', '?');
    }

    public static void verifyPackage(File file, ProgressListener progressListener, File file2) throws IOException, GeneralSecurityException {
        boolean z;
        long length = file.length();
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
        try {
            long currentTimeMillis = System.currentTimeMillis();
            if (progressListener != null) {
                progressListener.onProgress(0);
            }
            randomAccessFile.seek(length - 6);
            byte[] bArr = new byte[6];
            randomAccessFile.readFully(bArr);
            if (bArr[2] != -1 || bArr[3] != -1) {
                throw new SignatureException("no signature in file (no footer)");
            }
            int i = (bArr[4] & 255) | ((bArr[5] & 255) << 8);
            int i2 = (bArr[0] & 255) | ((bArr[1] & 255) << 8);
            byte[] bArr2 = new byte[i + 22];
            randomAccessFile.seek(length - (i + 22));
            randomAccessFile.readFully(bArr2);
            if (bArr2[0] != 80 || bArr2[1] != 75 || bArr2[2] != 5 || bArr2[3] != 6) {
                throw new SignatureException("no signature in file (bad footer)");
            }
            int i3 = 4;
            while (true) {
                int i4 = i3;
                if (i4 >= bArr2.length - 3) {
                    SignedData signedData = ((ContentInfo) ContentInfo.ASN1.decode(new BerInputStream(new ByteArrayInputStream(bArr2, (i + 22) - i2, i2)))).getSignedData();
                    if (signedData == null) {
                        throw new IOException("signedData is null");
                    }
                    List certificates = signedData.getCertificates();
                    if (certificates.isEmpty()) {
                        throw new IOException("encCerts is empty");
                    }
                    Iterator it = certificates.iterator();
                    if (!it.hasNext()) {
                        throw new SignatureException("signature contains no certificates");
                    }
                    X509Certificate x509Certificate = (X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(((Certificate) it.next()).getEncoded()));
                    List signerInfos = signedData.getSignerInfos();
                    if (signerInfos.isEmpty()) {
                        throw new IOException("no signer infos!");
                    }
                    SignerInfo signerInfo = (SignerInfo) signerInfos.get(0);
                    File file3 = file2;
                    if (file2 == null) {
                        file3 = DEFAULT_KEYSTORE;
                    }
                    HashSet<X509Certificate> trustedCerts = getTrustedCerts(file3);
                    PublicKey publicKey = x509Certificate.getPublicKey();
                    Iterator<X509Certificate> it2 = trustedCerts.iterator();
                    while (true) {
                        z = false;
                        if (!it2.hasNext()) {
                            break;
                        } else if (it2.next().getPublicKey().equals(publicKey)) {
                            z = true;
                            break;
                        }
                    }
                    if (!z) {
                        throw new SignatureException("signature doesn't match any trusted key");
                    }
                    String digestAlgorithm = signerInfo.getDigestAlgorithm();
                    String digestEncryptionAlgorithm = signerInfo.getDigestEncryptionAlgorithm();
                    Signature signature = Signature.getInstance((digestAlgorithm == null || digestEncryptionAlgorithm == null) ? x509Certificate.getSigAlgName() : digestAlgorithm + "with" + digestEncryptionAlgorithm);
                    signature.initVerify(x509Certificate);
                    long j = (length - i) - 2;
                    long j2 = 0;
                    randomAccessFile.seek(0L);
                    byte[] bArr3 = new byte[4096];
                    boolean z2 = false;
                    int i5 = 0;
                    while (true) {
                        if (j2 >= j) {
                            break;
                        }
                        boolean interrupted = Thread.interrupted();
                        if (interrupted) {
                            z2 = interrupted;
                            break;
                        }
                        int length2 = bArr3.length;
                        int i6 = length2;
                        if (length2 + j2 > j) {
                            i6 = (int) (j - j2);
                        }
                        int read = randomAccessFile.read(bArr3, 0, i6);
                        signature.update(bArr3, 0, read);
                        long j3 = j2 + read;
                        z2 = interrupted;
                        j2 = j3;
                        if (progressListener != null) {
                            long currentTimeMillis2 = System.currentTimeMillis();
                            int i7 = (int) ((100 * j3) / j);
                            z2 = interrupted;
                            j2 = j3;
                            if (i7 > i5) {
                                z2 = interrupted;
                                j2 = j3;
                                if (currentTimeMillis2 - currentTimeMillis > 500) {
                                    i5 = i7;
                                    currentTimeMillis = currentTimeMillis2;
                                    progressListener.onProgress(i5);
                                    z2 = interrupted;
                                    j2 = j3;
                                }
                            }
                        }
                    }
                    if (progressListener != null) {
                        progressListener.onProgress(100);
                    }
                    if (z2) {
                        throw new SignatureException("verification was interrupted");
                    }
                    if (!signature.verify(signerInfo.getEncryptedDigest())) {
                        throw new SignatureException("signature digest verification failed");
                    }
                    return;
                } else if (bArr2[i4] == 80 && bArr2[i4 + 1] == 75 && bArr2[i4 + 2] == 5 && bArr2[i4 + 3] == 6) {
                    throw new SignatureException("EOCD marker found after start of EOCD");
                } else {
                    i3 = i4 + 1;
                }
            }
        } finally {
            randomAccessFile.close();
        }
    }
}
