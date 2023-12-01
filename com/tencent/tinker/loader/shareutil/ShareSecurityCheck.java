package com.tencent.tinker.loader.shareutil;

import android.content.Context;
import com.tencent.tinker.loader.TinkerRuntimeException;
import java.io.File;
import java.io.IOException;
import java.security.cert.Certificate;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tinker/loader/shareutil/ShareSecurityCheck.class */
public class ShareSecurityCheck {
    private static final String TAG = "Tinker.SecurityCheck";
    private static String mPublicKeyMd5;
    private final Context mContext;
    private final HashMap<String, String> metaContentMap = new HashMap<>();
    private final HashMap<String, String> packageProperties = new HashMap<>();

    public ShareSecurityCheck(Context context) {
        this.mContext = context;
        if (mPublicKeyMd5 == null) {
            init(this.mContext);
        }
    }

    private boolean check(File file, Certificate[] certificateArr) {
        if (certificateArr.length <= 0) {
            return false;
        }
        int length = certificateArr.length;
        while (true) {
            int i = length - 1;
            if (i < 0) {
                return false;
            }
            try {
            } catch (Exception e) {
                ShareTinkerLog.e(TAG, file.getAbsolutePath(), e);
            }
            if (mPublicKeyMd5.equals(SharePatchFileUtil.getMD5(certificateArr[i].getEncoded()))) {
                return true;
            }
            length = i;
        }
    }

    private void init(Context context) {
        try {
            try {
                String md5 = SharePatchFileUtil.getMD5(context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures[0].toByteArray());
                mPublicKeyMd5 = md5;
                if (md5 == null) {
                    throw new TinkerRuntimeException("get public key md5 is null");
                }
                SharePatchFileUtil.closeQuietly(null);
            } catch (Exception e) {
                throw new TinkerRuntimeException("ShareSecurityCheck init public key fail", e);
            }
        } catch (Throwable th) {
            SharePatchFileUtil.closeQuietly(null);
            throw th;
        }
    }

    public HashMap<String, String> getMetaContentMap() {
        return this.metaContentMap;
    }

    public HashMap<String, String> getPackagePropertiesIfPresent() {
        String[] split;
        if (!this.packageProperties.isEmpty()) {
            return this.packageProperties;
        }
        String str = this.metaContentMap.get(ShareConstants.PACKAGE_META_FILE);
        if (str == null) {
            return null;
        }
        String[] split2 = str.split("\n");
        int length = split2.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return this.packageProperties;
            }
            String str2 = split2[i2];
            if (str2 != null && str2.length() > 0 && !str2.startsWith("#") && (split = str2.split("=", 2)) != null && split.length >= 2) {
                this.packageProperties.put(split[0].trim(), split[1].trim());
            }
            i = i2 + 1;
        }
    }

    /* JADX WARN: Not initialized variable reg: 12, insn: 0x010c: MOVE  (r0 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r12 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), block:B:55:0x010c */
    public boolean verifyPatchMetaSignature(File file) {
        JarFile jarFile;
        JarFile jarFile2;
        Throwable th;
        JarFile jarFile3;
        try {
            if (SharePatchFileUtil.isLegalFile(file)) {
                try {
                    jarFile3 = new JarFile(file);
                } catch (Exception e) {
                    e = e;
                } catch (Throwable th2) {
                    th = th2;
                    jarFile2 = null;
                    if (jarFile2 != null) {
                        try {
                            jarFile2.close();
                        } catch (IOException e2) {
                            ShareTinkerLog.e(TAG, file.getAbsolutePath(), e2);
                        }
                    }
                    throw th;
                }
                try {
                    Enumeration<JarEntry> entries = jarFile3.entries();
                    while (entries.hasMoreElements()) {
                        JarEntry nextElement = entries.nextElement();
                        if (nextElement != null) {
                            String name = nextElement.getName();
                            if (!name.startsWith("META-INF/") && name.endsWith(ShareConstants.META_SUFFIX)) {
                                this.metaContentMap.put(name, SharePatchFileUtil.loadDigestes(jarFile3, nextElement));
                                Certificate[] certificates = nextElement.getCertificates();
                                if (certificates == null || !check(file, certificates)) {
                                    try {
                                        jarFile3.close();
                                        return false;
                                    } catch (IOException e3) {
                                        ShareTinkerLog.e(TAG, file.getAbsolutePath(), e3);
                                        return false;
                                    }
                                }
                            }
                        }
                    }
                    try {
                        jarFile3.close();
                        return true;
                    } catch (IOException e4) {
                        ShareTinkerLog.e(TAG, file.getAbsolutePath(), e4);
                        return true;
                    }
                } catch (Exception e5) {
                    e = e5;
                    throw new TinkerRuntimeException(String.format("ShareSecurityCheck file %s, size %d verifyPatchMetaSignature fail", file.getAbsolutePath(), Long.valueOf(file.length())), e);
                }
            }
            return false;
        } catch (Throwable th3) {
            jarFile2 = jarFile;
            th = th3;
        }
    }
}
