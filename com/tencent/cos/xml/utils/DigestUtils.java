package com.tencent.cos.xml.utils;

import android.text.TextUtils;
import android.util.Base64;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.google.common.primitives.Longs;
import com.tencent.cos.xml.common.ClientErrorCode;
import com.tencent.cos.xml.exception.CosXmlClientException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/utils/DigestUtils.class */
public class DigestUtils {
    public static String getBase64(String str) throws CosXmlClientException {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            return Base64.encodeToString(str.getBytes("utf-8"), 2);
        } catch (UnsupportedEncodingException e) {
            throw new CosXmlClientException(ClientErrorCode.INTERNAL_ERROR.getCode(), e);
        }
    }

    public static long getBigIntFromString(String str) {
        return new BigInteger(str).longValue();
    }

    public static String getBigIntToString(long j) {
        BigInteger valueOf = BigInteger.valueOf((j >> 1) & Longs.MAX_POWER_OF_TWO);
        return valueOf.add(valueOf).add(BigInteger.valueOf(j & Long.MAX_VALUE)).toString();
    }

    public static String getCOSMd5(InputStream inputStream, long j, long j2) throws IOException {
        try {
            if (inputStream.skip(j) != j) {
                return "";
            }
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            byte[] bArr = new byte[8192];
            if (j2 < 0) {
                j2 = Long.MAX_VALUE;
            }
            int min = (int) Math.min(j2, 8192);
            while (j2 > 0) {
                int read = inputStream.read(bArr, 0, min);
                if (read == -1) {
                    break;
                } else if (read < min) {
                    return "";
                } else {
                    messageDigest.update(bArr, 0, read);
                    j2 -= read;
                }
            }
            return "\"" + StringUtils.toHexString(messageDigest.digest()) + "\"";
        } catch (IOException e) {
            throw e;
        } catch (NoSuchAlgorithmException e2) {
            throw new IOException("unSupport Md5 algorithm", e2);
        }
    }

    public static long getCRC64(InputStream inputStream) {
        try {
            CRC64 crc64 = new CRC64();
            byte[] bArr = new byte[8192];
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    return crc64.getValue();
                }
                crc64.update(bArr, read);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return -1L;
        }
    }

    public static long getCRC64(InputStream inputStream, long j, long j2) {
        try {
            if (inputStream.skip(j) != j) {
                return -1L;
            }
            CRC64 crc64 = new CRC64();
            byte[] bArr = new byte[8192];
            if (j2 < 0) {
                j2 = Long.MAX_VALUE;
            }
            int min = (int) Math.min(j2, 8192);
            while (j2 > 0) {
                int read = inputStream.read(bArr, 0, min);
                if (read == -1) {
                    break;
                }
                crc64.update(bArr, read);
                j2 -= read;
            }
            return crc64.getValue();
        } catch (IOException e) {
            e.printStackTrace();
            return -1L;
        }
    }

    public static String getCRC64String(File file) {
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(file);
        } catch (Exception e) {
            fileInputStream = null;
        } catch (Throwable th) {
            th = th;
            fileInputStream = null;
        }
        try {
            String cRC64String = getCRC64String(fileInputStream);
            try {
                fileInputStream.close();
                return cRC64String;
            } catch (IOException e2) {
                e2.printStackTrace();
                return cRC64String;
            }
        } catch (Exception e3) {
            try {
                fileInputStream.close();
                return "";
            } catch (IOException e4) {
                e4.printStackTrace();
                return "";
            }
        } catch (Throwable th2) {
            th = th2;
            try {
                fileInputStream.close();
            } catch (IOException e5) {
                e5.printStackTrace();
            }
            throw th;
        }
    }

    public static String getCRC64String(InputStream inputStream) {
        return getBigIntToString(getCRC64(inputStream));
    }

    public static String getHmacSha1(String str, String str2) throws CosXmlClientException {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(Charset.forName("UTF-8")), "HmacSHA1");
            Mac mac = Mac.getInstance("HmacSHA1");
            mac.init(secretKeySpec);
            return StringUtils.toHexString(mac.doFinal(str.getBytes(Charset.forName("UTF-8"))));
        } catch (InvalidKeyException e) {
            throw new CosXmlClientException(ClientErrorCode.INTERNAL_ERROR.getCode(), e);
        } catch (NoSuchAlgorithmException e2) {
            throw new CosXmlClientException(ClientErrorCode.INTERNAL_ERROR.getCode(), e2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [java.io.Closeable] */
    public static String getMD5(String str) throws CosXmlClientException {
        File file;
        MessageDigest messageDigest;
        FileInputStream fileInputStream;
        if (str == null) {
            throw new CosXmlClientException(ClientErrorCode.INVALID_ARGUMENT.getCode(), "file Path is null");
        }
        File file2 = new File(str);
        try {
            if (!file2.exists()) {
                throw new CosXmlClientException(ClientErrorCode.INVALID_ARGUMENT.getCode(), "file Path is not exist");
            }
            try {
                messageDigest = MessageDigest.getInstance("MD5");
                fileInputStream = new FileInputStream(file2);
            } catch (FileNotFoundException e) {
                e = e;
            } catch (IOException e2) {
                e = e2;
            } catch (NoSuchAlgorithmException e3) {
                e = e3;
            } catch (Throwable th) {
                file = null;
                th = th;
                CloseUtil.closeQuietly(file);
                throw th;
            }
            try {
                byte[] bArr = new byte[32768];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read == -1) {
                        String hexString = StringUtils.toHexString(messageDigest.digest());
                        CloseUtil.closeQuietly(fileInputStream);
                        return hexString;
                    }
                    messageDigest.update(bArr, 0, read);
                }
            } catch (FileNotFoundException e4) {
                e = e4;
                throw new CosXmlClientException(ClientErrorCode.INVALID_ARGUMENT.getCode(), e);
            } catch (IOException e5) {
                e = e5;
                throw new CosXmlClientException(ClientErrorCode.IO_ERROR.getCode(), e);
            } catch (NoSuchAlgorithmException e6) {
                e = e6;
                throw new CosXmlClientException(ClientErrorCode.INTERNAL_ERROR.getCode(), e);
            }
        } catch (Throwable th2) {
            th = th2;
            file = file2;
        }
    }

    public static String getSHA1FromBytes(byte[] bArr, int i, int i2) throws CosXmlClientException {
        if (bArr == null || i2 <= 0 || i < 0) {
            throw new CosXmlClientException(ClientErrorCode.INVALID_ARGUMENT.getCode(), "data == null | len <= 0 |offset < 0 |offset >= len");
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
            messageDigest.update(bArr, i, i2);
            return StringUtils.toHexString(messageDigest.digest());
        } catch (OutOfMemoryError e) {
            throw new CosXmlClientException(ClientErrorCode.INTERNAL_ERROR.getCode(), e);
        } catch (NoSuchAlgorithmException e2) {
            throw new CosXmlClientException(ClientErrorCode.INTERNAL_ERROR.getCode(), e2);
        }
    }

    public static String getSHA1FromPath(String str) throws CosXmlClientException {
        FileInputStream fileInputStream = null;
        try {
            try {
                FileInputStream fileInputStream2 = new FileInputStream(str);
                try {
                    MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
                    byte[] bArr = new byte[65536];
                    while (true) {
                        int read = fileInputStream2.read(bArr, 0, 65536);
                        if (read == -1) {
                            String hexString = StringUtils.toHexString(messageDigest.digest());
                            CloseUtil.closeQuietly(fileInputStream2);
                            return hexString;
                        }
                        messageDigest.update(bArr, 0, read);
                    }
                } catch (FileNotFoundException e) {
                    e = e;
                    throw new CosXmlClientException(ClientErrorCode.INVALID_ARGUMENT.getCode(), e);
                } catch (IOException e2) {
                    e = e2;
                    throw new CosXmlClientException(ClientErrorCode.IO_ERROR.getCode(), e);
                } catch (NoSuchAlgorithmException e3) {
                    e = e3;
                    throw new CosXmlClientException(ClientErrorCode.INTERNAL_ERROR.getCode(), e);
                } catch (Throwable th) {
                    fileInputStream = fileInputStream2;
                    th = th;
                    CloseUtil.closeQuietly(fileInputStream);
                    throw th;
                }
            } catch (FileNotFoundException e4) {
                e = e4;
            } catch (IOException e5) {
                e = e5;
            } catch (NoSuchAlgorithmException e6) {
                e = e6;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static String getSecurityBase64(String str) throws CosXmlClientException {
        String base64 = getBase64(str);
        return TextUtils.isEmpty(base64) ? base64 : base64.replace("+", "-").replace(BridgeUtil.SPLIT_MARK, BridgeUtil.UNDERLINE_STR);
    }

    public static String getSha1(String str) throws CosXmlClientException {
        try {
            return StringUtils.toHexString(MessageDigest.getInstance("SHA-1").digest(str.getBytes(Charset.forName("UTF-8"))));
        } catch (NoSuchAlgorithmException e) {
            throw new CosXmlClientException(ClientErrorCode.INTERNAL_ERROR.getCode(), e);
        }
    }
}
