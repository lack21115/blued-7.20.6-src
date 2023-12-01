package com.huawei.hms.utils;

import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Base64;
import com.huawei.hms.support.log.HMSLog;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.Signature;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/utils/ReadApkFileUtil.class */
public class ReadApkFileUtil {
    public static final String EMUI10_PK = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAx4nUogUyMCmzHhaEb420yvpw9zBs+ETzE9Qm77bGxl1Iml9JEkBkNTsUWOstLgUBajNhV+BAMVBHKMEdzoQbL5kIHkTgUVM65yewd+5+BhrcB9OQ3LHp+0BN6aLKZh71T4WvsvHFhfhQpShuGWkRkSaVGLFTHxX70kpWLzeZ3RtqiEUNIufPR2SFCH6EmecJ+HdkmBOh603IblCpGxwSWse0fDI98wZBEmV88RFaiYEgyiezLlWvXzqIj6I/xuyd5nGAegjH2y3cmoDE6CubecoB1jf4KdgACXgdiQ4Oc63MfLGTor3l6RCqeUk4APAMtyhK83jc72W1sdXMd/sj2wIDAQAB";
    public static final String EMUI11_PK = "MIIBojANBgkqhkiG9w0BAQEFAAOCAY8AMIIBigKCAYEAqq2eRTMYr2JHLtvuZzfgPrgU8oatD4Rar9fOD7E00es2VhtB3vTyaT2BvYPUPA/nbkHRPak3EZX77CfWj9tzLgSHJE8XLk9C+2ESkdrxCDA6z7I8X+cBDnA05OlCJeZFjnUbjYB8SP8M3BttdrvqtVPxTkEJhchC7UXnMLaJ3kQ3ZPjN7ubjYzO4rv7EtEpqr2bX+qjnSLIZZuUXraxqfdBuhGDIYq62dNsqiyrhX1mfvA3+43N4ZIs3BdfSYII8BNFmFxf+gyf1aoq386R2kAjHcrfOOhjAbZh+R1OAGLWPCqi3E9nB8EsZkeoTW/oIP6pJvgL3bnxq+1viT2dmZyipMgcx/3N6FJqkd67j/sPMtPlHJuq8/s0silzs13jAw1WBV6tWHFkLGpkWGs8jp50wQtndtY8cCPl2XPGmdPN72agH+zsHuKqr/HOB2TuzzaO8rKlGIDQlzZcCSHB28nnvOyBVN9xzLkbYiLnHfd6bTwzNPeqjWrTnPwKyH3BPAgMBAAE=";
    public static final String KEY_SIGNATURE = "Signature:";
    public static final String KEY_SIGNATURE2 = "Signature2:";
    public static final String KEY_SIGNATURE3 = "Signature3:";

    /* renamed from: a  reason: collision with root package name */
    public static final String f9317a = "ReadApkFileUtil";
    public static String b;

    /* renamed from: c  reason: collision with root package name */
    public static String f9318c;
    public static String d;
    public static String e;
    public static String f;

    public static String a(BufferedReader bufferedReader) throws IOException {
        char c2;
        if (bufferedReader == null) {
            return null;
        }
        int read = bufferedReader.read();
        if (read == -1) {
            return null;
        }
        StringBuilder sb = new StringBuilder(10);
        while (read != -1 && (c2 = (char) read) != '\n') {
            if (sb.length() >= 4096) {
                throw new IOException("cert line is too long!");
            }
            sb.append(c2);
            read = bufferedReader.read();
        }
        String sb2 = sb.toString();
        String str = sb2;
        if (!sb2.isEmpty()) {
            str = sb2;
            if (sb2.endsWith("\r")) {
                str = sb2.substring(0, sb2.length() - 1);
            }
        }
        return str;
    }

    public static String a(String str) {
        return str != null ? Pattern.compile("\\s*|\t|\r|\n").matcher(str).replaceAll("") : "";
    }

    public static ArrayList<String> a(byte[] bArr) {
        if (bArr == null) {
            HMSLog.e(f9317a, "manifest is null！");
            return null;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(byteArrayInputStream, StandardCharsets.UTF_8));
            if (a(bufferedReader, arrayList)) {
                bufferedReader.close();
                byteArrayInputStream.close();
                return arrayList;
            }
            bufferedReader.close();
            byteArrayInputStream.close();
            return null;
        } catch (IOException e2) {
            HMSLog.e(f9317a, "getManifestLinesArrary IOException!");
            return null;
        }
    }

    public static boolean a() {
        try {
            if (a(b("30820122300d06092a864886f70d01010105000382010f003082010a0282010100a3d269348ac59923f65e8111c337605e29a1d1bc54fa96c1445050dd14d8d63b10f9f0230bb87ef348183660bedcabfdec045e235ed96935799fcdb4af5c97717ff3b0954eaf1b723225b3a00f81cbd67ce6dc5a4c07f7741ad3bf1913a480c6e267ab1740f409edd2dc33c8b718a8e30e56d9a93f321723c1d0c9ea62115f996812ceef186954595e39a19b74245542c407f7dddb1d12e6eedcfc0bd7cd945ef7255ad0fc9e796258e0fb5e52a23013d15033a32b4071b65f3f924ae5c5761e22327b4d2ae60f4158a5eb15565ba079de29b81540f5fbb3be101a95357f367fc661d797074ff3826950029c52223e4594673a24a334cae62d63b838ba3df9770203010001"), a(f, "SHA-256"), b(b), "SHA256withRSA")) {
                HMSLog.i(f9317a, "verifyMDMSignatureV1 verify successful!");
                return true;
            }
            HMSLog.i(f9317a, "verifyMDMSignatureV1 verify failure!");
            return false;
        } catch (Exception e2) {
            String str = f9317a;
            HMSLog.i(str, "verifyMDMSignatureV1 MDM verify Exception!:" + e2.getMessage());
            return false;
        }
    }

    public static boolean a(BufferedReader bufferedReader, ArrayList<String> arrayList) throws IOException {
        String a2 = a(bufferedReader);
        boolean z = false;
        while (a2 != null) {
            String str = a2;
            if (a2.equals("Name: META-INF/HUAWEI.CER")) {
                String a3 = a(bufferedReader);
                while (true) {
                    String str2 = a3;
                    str = a2;
                    z = true;
                    if (str2 == null) {
                        break;
                    } else if (str2.startsWith("Name:")) {
                        str = str2;
                        z = true;
                        break;
                    } else {
                        a3 = a(bufferedReader);
                    }
                }
            }
            if (str.length() != 0) {
                arrayList.add(str);
            }
            a2 = a(bufferedReader);
        }
        return z;
    }

    public static boolean a(byte[] bArr, byte[] bArr2, byte[] bArr3, String str) throws Exception {
        Signature signature = Signature.getInstance(str);
        signature.initVerify(KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(bArr)));
        signature.update(bArr2);
        return signature.verify(bArr3);
    }

    public static byte[] a(String str, String str2) throws Exception {
        MessageDigest messageDigest = MessageDigest.getInstance(str2);
        messageDigest.update(str.getBytes(StandardCharsets.UTF_8.name()));
        return messageDigest.digest();
    }

    public static byte[] a(ArrayList<String> arrayList) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(byteArrayOutputStream, StandardCharsets.UTF_8));
        try {
            try {
                Collections.sort(arrayList);
                int size = arrayList.size();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= size) {
                        break;
                    }
                    String str = arrayList.get(i2);
                    bufferedWriter.write(str, 0, str.length());
                    bufferedWriter.write(com.tencent.qcloud.core.util.IOUtils.LINE_SEPARATOR_WINDOWS, 0, 2);
                    i = i2 + 1;
                }
                bufferedWriter.flush();
            } catch (Exception e2) {
                String str2 = f9317a;
                HMSLog.i(str2, "getManifestBytesbySorted Exception!" + e2.getMessage());
            }
            IOUtils.closeQuietly((OutputStream) byteArrayOutputStream);
            IOUtils.closeQuietly((Writer) bufferedWriter);
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable th) {
            IOUtils.closeQuietly((OutputStream) byteArrayOutputStream);
            IOUtils.closeQuietly((Writer) bufferedWriter);
            throw th;
        }
    }

    public static byte[] a(ZipFile zipFile) {
        return a(zipFile, "META-INF/MANIFEST.MF");
    }

    /* JADX WARN: Not initialized variable reg: 11, insn: 0x0195: MOVE  (r0 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r11 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), block:B:63:0x0195 */
    /* JADX WARN: Not initialized variable reg: 12, insn: 0x019b: MOVE  (r0 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r12 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), block:B:63:0x0195 */
    public static byte[] a(ZipFile zipFile, String str) {
        BufferedInputStream bufferedInputStream;
        BufferedInputStream bufferedInputStream2;
        InputStream inputStream;
        OutputStream outputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2;
        BufferedOutputStream bufferedOutputStream;
        byte[] bArr;
        ZipEntry entry = zipFile.getEntry(str);
        OutputStream outputStream2 = null;
        try {
            if (entry == null) {
                return null;
            }
            try {
                inputStream = zipFile.getInputStream(entry);
                if (inputStream == null) {
                    IOUtils.closeQuietly(inputStream);
                    IOUtils.closeQuietly((InputStream) null);
                    IOUtils.closeQuietly((OutputStream) null);
                    IOUtils.closeQuietly((OutputStream) null);
                    return null;
                }
                try {
                    bufferedInputStream2 = new BufferedInputStream(inputStream);
                } catch (Exception e2) {
                    e = e2;
                    bufferedInputStream2 = null;
                    byteArrayOutputStream2 = null;
                    bufferedOutputStream = null;
                    String str2 = f9317a;
                    ByteArrayOutputStream byteArrayOutputStream3 = byteArrayOutputStream2;
                    StringBuilder sb = new StringBuilder();
                    ByteArrayOutputStream byteArrayOutputStream4 = byteArrayOutputStream2;
                    sb.append("getManifestBytes Exception!");
                    ByteArrayOutputStream byteArrayOutputStream5 = byteArrayOutputStream2;
                    sb.append(e.getMessage());
                    ByteArrayOutputStream byteArrayOutputStream6 = byteArrayOutputStream2;
                    HMSLog.i(str2, sb.toString());
                    IOUtils.closeQuietly(inputStream);
                    IOUtils.closeQuietly((InputStream) bufferedInputStream2);
                    IOUtils.closeQuietly((OutputStream) byteArrayOutputStream2);
                    IOUtils.closeQuietly((OutputStream) bufferedOutputStream);
                    return null;
                } catch (Throwable th) {
                    th = th;
                    th = th;
                    bufferedInputStream2 = null;
                    byteArrayOutputStream = null;
                    IOUtils.closeQuietly(inputStream);
                    IOUtils.closeQuietly((InputStream) bufferedInputStream2);
                    IOUtils.closeQuietly((OutputStream) byteArrayOutputStream);
                    IOUtils.closeQuietly(outputStream2);
                    throw th;
                }
                try {
                    bArr = new byte[4096];
                    byteArrayOutputStream2 = new ByteArrayOutputStream();
                } catch (Exception e3) {
                    e = e3;
                    byteArrayOutputStream2 = null;
                    bufferedOutputStream = null;
                    String str22 = f9317a;
                    ByteArrayOutputStream byteArrayOutputStream32 = byteArrayOutputStream2;
                    StringBuilder sb2 = new StringBuilder();
                    ByteArrayOutputStream byteArrayOutputStream42 = byteArrayOutputStream2;
                    sb2.append("getManifestBytes Exception!");
                    ByteArrayOutputStream byteArrayOutputStream52 = byteArrayOutputStream2;
                    sb2.append(e.getMessage());
                    ByteArrayOutputStream byteArrayOutputStream62 = byteArrayOutputStream2;
                    HMSLog.i(str22, sb2.toString());
                    IOUtils.closeQuietly(inputStream);
                    IOUtils.closeQuietly((InputStream) bufferedInputStream2);
                    IOUtils.closeQuietly((OutputStream) byteArrayOutputStream2);
                    IOUtils.closeQuietly((OutputStream) bufferedOutputStream);
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    byteArrayOutputStream = null;
                }
                try {
                    bufferedOutputStream = new BufferedOutputStream(byteArrayOutputStream2);
                } catch (Exception e4) {
                    e = e4;
                    bufferedOutputStream = null;
                } catch (Throwable th3) {
                    th = th3;
                    byteArrayOutputStream = byteArrayOutputStream2;
                    IOUtils.closeQuietly(inputStream);
                    IOUtils.closeQuietly((InputStream) bufferedInputStream2);
                    IOUtils.closeQuietly((OutputStream) byteArrayOutputStream);
                    IOUtils.closeQuietly(outputStream2);
                    throw th;
                }
                try {
                    for (int read = bufferedInputStream2.read(bArr, 0, 4096); read > 0; read = bufferedInputStream2.read(bArr, 0, 4096)) {
                        bufferedOutputStream.write(bArr, 0, read);
                    }
                    bufferedOutputStream.flush();
                    byte[] byteArray = byteArrayOutputStream2.toByteArray();
                    IOUtils.closeQuietly(inputStream);
                    IOUtils.closeQuietly((InputStream) bufferedInputStream2);
                    IOUtils.closeQuietly((OutputStream) byteArrayOutputStream2);
                    IOUtils.closeQuietly((OutputStream) bufferedOutputStream);
                    return byteArray;
                } catch (Exception e5) {
                    e = e5;
                    String str222 = f9317a;
                    ByteArrayOutputStream byteArrayOutputStream322 = byteArrayOutputStream2;
                    StringBuilder sb22 = new StringBuilder();
                    ByteArrayOutputStream byteArrayOutputStream422 = byteArrayOutputStream2;
                    sb22.append("getManifestBytes Exception!");
                    ByteArrayOutputStream byteArrayOutputStream522 = byteArrayOutputStream2;
                    sb22.append(e.getMessage());
                    ByteArrayOutputStream byteArrayOutputStream622 = byteArrayOutputStream2;
                    HMSLog.i(str222, sb22.toString());
                    IOUtils.closeQuietly(inputStream);
                    IOUtils.closeQuietly((InputStream) bufferedInputStream2);
                    IOUtils.closeQuietly((OutputStream) byteArrayOutputStream2);
                    IOUtils.closeQuietly((OutputStream) bufferedOutputStream);
                    return null;
                }
            } catch (Exception e6) {
                e = e6;
                inputStream = null;
            } catch (Throwable th4) {
                th = th4;
                inputStream = null;
            }
        } catch (Throwable th5) {
            th = th5;
            bufferedInputStream2 = bufferedInputStream;
            inputStream = null;
            outputStream2 = outputStream;
        }
    }

    public static void b(byte[] bArr) {
        ByteArrayInputStream byteArrayInputStream;
        BufferedReader bufferedReader;
        InputStream inputStream;
        if (bArr == null) {
            HMSLog.e(f9317a, "manifest is null！");
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        b = null;
        f9318c = null;
        d = null;
        try {
            byteArrayInputStream = new ByteArrayInputStream(bArr);
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(byteArrayInputStream, StandardCharsets.UTF_8));
            } catch (Exception e2) {
                bufferedReader = null;
                inputStream = byteArrayInputStream;
            } catch (Throwable th) {
                th = th;
                bufferedReader = null;
            }
        } catch (Exception e3) {
            inputStream = null;
            bufferedReader = null;
        } catch (Throwable th2) {
            th = th2;
            byteArrayInputStream = null;
            bufferedReader = null;
        }
        try {
            String a2 = a(bufferedReader);
            while (a2 != null) {
                if (a2.length() != 0) {
                    if (a2.startsWith("ApkHash:")) {
                        e = a(a2.substring(a2.indexOf(":") + 1));
                    }
                    if (a2.startsWith(KEY_SIGNATURE)) {
                        b = a(a2.substring(a2.indexOf(":") + 1));
                        a2 = a(bufferedReader);
                    } else if (a2.startsWith(KEY_SIGNATURE2)) {
                        f9318c = a(a2.substring(a2.indexOf(":") + 1));
                        a2 = a(bufferedReader);
                    } else if (a2.startsWith(KEY_SIGNATURE3)) {
                        d = a(a2.substring(a2.indexOf(":") + 1));
                        a2 = a(bufferedReader);
                    } else {
                        stringBuffer.append(a2);
                        stringBuffer.append(com.tencent.qcloud.core.util.IOUtils.LINE_SEPARATOR_WINDOWS);
                    }
                }
                a2 = a(bufferedReader);
            }
            f = stringBuffer.toString();
            inputStream = byteArrayInputStream;
        } catch (Exception e4) {
            inputStream = byteArrayInputStream;
            try {
                HMSLog.e(f9317a, "loadApkCert Exception!");
                IOUtils.closeQuietly(inputStream);
                IOUtils.closeQuietly((Reader) bufferedReader);
            } catch (Throwable th3) {
                byteArrayInputStream = inputStream;
                th = th3;
                IOUtils.closeQuietly((InputStream) byteArrayInputStream);
                IOUtils.closeQuietly((Reader) bufferedReader);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            IOUtils.closeQuietly((InputStream) byteArrayInputStream);
            IOUtils.closeQuietly((Reader) bufferedReader);
            throw th;
        }
        IOUtils.closeQuietly(inputStream);
        IOUtils.closeQuietly((Reader) bufferedReader);
    }

    public static boolean b() {
        try {
            if (a(Base64.decode(EMUI10_PK, 0), a(f, "SHA-256"), b(f9318c), "SHA256withRSA")) {
                HMSLog.i(f9317a, "verifyMDMSignatureV2 verify successful!");
                return true;
            }
            HMSLog.i(f9317a, "verifyMDMSignatureV2 verify failure!");
            return false;
        } catch (Exception e2) {
            String str = f9317a;
            HMSLog.i(str, "verifyMDMSignatureV2 MDM verify Exception!:" + e2.getMessage());
            return false;
        }
    }

    public static byte[] b(String str) {
        if (TextUtils.isEmpty(str)) {
            return new byte[0];
        }
        int length = str.length();
        byte[] bArr = new byte[length % 2 == 0 ? length / 2 : (length / 2) + 1];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return bArr;
            }
            int i3 = i2 + 1;
            if (i3 < length) {
                bArr[i2 / 2] = (byte) ((Character.digit(str.charAt(i2), 16) << 4) + Character.digit(str.charAt(i3), 16));
            } else {
                bArr[i2 / 2] = (byte) (Character.digit(str.charAt(i2), 16) << 4);
            }
            i = i2 + 2;
        }
    }

    public static String bytesToString(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        char[] cArr2 = new char[bArr.length * 2];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= bArr.length) {
                return String.valueOf(cArr2);
            }
            int i3 = bArr[i2] & 255;
            int i4 = i2 * 2;
            cArr2[i4] = cArr[i3 >>> 4];
            cArr2[i4 + 1] = cArr[i3 & 15];
            i = i2 + 1;
        }
    }

    public static boolean c() {
        try {
            if (a(Base64.decode(EMUI11_PK, 0), a(f, "SHA-384"), b(d), "SHA384withRSA")) {
                HMSLog.i(f9317a, "verifyMDMSignatureV3 verify successful!");
                return true;
            }
            HMSLog.i(f9317a, "verifyMDMSignatureV3 verify failure!");
            return false;
        } catch (Exception e2) {
            String str = f9317a;
            HMSLog.i(str, "verifyMDMSignatureV3 MDM verify Exception!:" + e2.getMessage());
            return false;
        }
    }

    public static boolean checkSignature() {
        if (d != null) {
            return c();
        }
        if (f9318c != null) {
            return b();
        }
        if (b != null) {
            return a();
        }
        return false;
    }

    public static String getHmsPath(Context context) {
        try {
            return context.getPackageManager().getApplicationInfo("com.huawei.hwid", 128).sourceDir;
        } catch (PackageManager.NameNotFoundException e2) {
            HMSLog.e(f9317a, "HMS is not found!");
            return null;
        }
    }

    public static boolean isCertFound(String str) {
        ZipFile zipFile;
        ZipFile zipFile2 = null;
        try {
            try {
                zipFile = new ZipFile(str);
                try {
                    boolean z = zipFile.getEntry("META-INF/HUAWEI.CER") != null;
                    if (z) {
                        b(a(zipFile, "META-INF/HUAWEI.CER"));
                    }
                    try {
                        zipFile.close();
                    } catch (IOException e2) {
                        HMSLog.e(f9317a, "zipFile.close Exception!" + e2.getMessage());
                    }
                    return z;
                } catch (Exception e3) {
                    e = e3;
                    String str2 = f9317a;
                    ZipFile zipFile3 = zipFile;
                    StringBuilder sb = new StringBuilder();
                    ZipFile zipFile4 = zipFile;
                    sb.append("isCertFound Exception!");
                    ZipFile zipFile5 = zipFile;
                    sb.append(e.getMessage());
                    zipFile2 = zipFile;
                    HMSLog.e(str2, sb.toString());
                    if (zipFile != null) {
                        try {
                            zipFile.close();
                            return false;
                        } catch (IOException e4) {
                            HMSLog.e(f9317a, "zipFile.close Exception!" + e4.getMessage());
                            return false;
                        }
                    }
                    return false;
                } catch (Throwable th) {
                    zipFile2 = zipFile;
                    th = th;
                    if (zipFile2 != null) {
                        try {
                            zipFile2.close();
                        } catch (IOException e5) {
                            HMSLog.e(f9317a, "zipFile.close Exception!" + e5.getMessage());
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e6) {
            e = e6;
            zipFile = null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11, types: [java.util.zip.ZipFile] */
    public static boolean verifyApkHash(String str) {
        ZipFile zipFile;
        ZipFile zipFile2 = null;
        try {
            try {
                zipFile = new ZipFile(str);
                try {
                    byte[] a2 = a(zipFile);
                    ArrayList<String> a3 = a(a2);
                    if (a3 != null) {
                        a2 = a(a3);
                    }
                    MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
                    messageDigest.update(a2);
                    String bytesToString = bytesToString(messageDigest.digest());
                    if (e != null) {
                        if (e.equals(bytesToString)) {
                            try {
                                zipFile.close();
                                return true;
                            } catch (Exception e2) {
                                HMSLog.i(f9317a, "close stream Exception!" + e2.getMessage());
                                return true;
                            }
                        }
                    }
                    try {
                        zipFile.close();
                        return false;
                    } catch (Exception e3) {
                        HMSLog.i(f9317a, "close stream Exception!" + e3.getMessage());
                        return false;
                    }
                } catch (Exception e4) {
                    e = e4;
                    String str2 = f9317a;
                    ZipFile zipFile3 = zipFile;
                    StringBuilder sb = new StringBuilder();
                    ZipFile zipFile4 = zipFile;
                    sb.append("verifyApkHash Exception!");
                    ZipFile zipFile5 = zipFile;
                    sb.append(e.getMessage());
                    ZipFile zipFile6 = zipFile;
                    HMSLog.i(str2, sb.toString());
                    if (zipFile != null) {
                        try {
                            zipFile.close();
                            return false;
                        } catch (Exception e5) {
                            zipFile2 = f9317a;
                            HMSLog.i(zipFile2, "close stream Exception!" + e5.getMessage());
                            return false;
                        }
                    }
                    return false;
                } catch (Throwable th) {
                    zipFile2 = zipFile;
                    th = th;
                    if (zipFile2 != null) {
                        try {
                            zipFile2.close();
                        } catch (Exception e6) {
                            HMSLog.i(f9317a, "close stream Exception!" + e6.getMessage());
                        }
                    }
                    throw th;
                }
            } catch (Exception e7) {
                e = e7;
                zipFile = null;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
