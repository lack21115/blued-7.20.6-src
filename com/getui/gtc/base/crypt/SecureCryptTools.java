package com.getui.gtc.base.crypt;

import android.content.Context;
import com.anythink.expressad.video.module.a.a.m;
import com.getui.gtc.base.GtcProvider;
import com.getui.gtc.base.util.io.IOUtils;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: source-8110460-dex2jar.jar:com/getui/gtc/base/crypt/SecureCryptTools.class */
public class SecureCryptTools {
    private static final String CIPHER_FLAG_FIRST = "First";
    private static final String CIPHER_FLAG_SECOND = "Second";
    private static final String CIPHER_FLAG_SEPARATOR = "-";
    private static final String CIPHER_FLAG_STARTER = ":::";
    private volatile boolean initInvoked;
    private ReentrantLock lock;
    private d secureKeyStore;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8110460-dex2jar.jar:com/getui/gtc/base/crypt/SecureCryptTools$a.class */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private static SecureCryptTools f21899a = new SecureCryptTools();
    }

    private SecureCryptTools() {
        this.lock = new ReentrantLock();
        try {
            init(GtcProvider.context());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private byte[] doDecrypt(byte[] bArr) throws CryptException {
        ByteArrayInputStream byteArrayInputStream;
        Throwable th;
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayInputStream byteArrayInputStream2;
        Throwable th2;
        ByteArrayOutputStream byteArrayOutputStream2;
        InputStream inputStream;
        synchronized (this) {
            String cipherFlag = getCipherFlag(bArr);
            if (cipherFlag == null) {
                throw new CryptException("Cipher flag not found in cipher text!");
            }
            String[] split = cipherFlag.split("-");
            if (split.length < 2) {
                throw new CryptException("Cipher flag is wrong in cipher text!");
            }
            String str = split[0];
            byte[] copyOfRange = Arrays.copyOfRange(bArr, 0, (bArr.length - cipherFlag.length()) - 3);
            InputStream inputStream2 = null;
            if (cipherFlag.endsWith(CIPHER_FLAG_FIRST)) {
                try {
                    byteArrayInputStream = new ByteArrayInputStream(copyOfRange);
                    try {
                        byteArrayOutputStream = new ByteArrayOutputStream();
                    } catch (Throwable th3) {
                        th = th3;
                        th = th;
                        throw new CryptException("decrypt failed!", th);
                    }
                    try {
                        InputStream decrypt = CryptTools.decrypt("AES/CBC/PKCS7Padding", this.secureKeyStore.a(str), this.secureKeyStore.c(str), byteArrayInputStream);
                        byte[] bArr2 = new byte[256];
                        while (true) {
                            int read = decrypt.read(bArr2);
                            if (read == -1) {
                                byteArrayOutputStream.flush();
                                inputStream2 = decrypt;
                                byte[] byteArray = byteArrayOutputStream.toByteArray();
                                IOUtils.safeClose(decrypt);
                                IOUtils.safeClose(byteArrayInputStream);
                                IOUtils.safeClose(byteArrayOutputStream);
                                return byteArray;
                            }
                            byteArrayOutputStream.write(bArr2, 0, read);
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        throw new CryptException("decrypt failed!", th);
                    }
                } catch (Throwable th5) {
                    th = th5;
                    byteArrayInputStream = null;
                }
            } else if (!cipherFlag.endsWith(CIPHER_FLAG_SECOND)) {
                throw new CryptException("Cipher flag not found in cipher text!");
            } else {
                try {
                    byteArrayInputStream2 = new ByteArrayInputStream(copyOfRange);
                } catch (Throwable th6) {
                    th = th6;
                    byteArrayInputStream2 = null;
                }
                try {
                    byteArrayOutputStream2 = new ByteArrayOutputStream();
                    inputStream = null;
                } catch (Throwable th7) {
                    th = th7;
                    th2 = th;
                    throw new CryptException("decrypt failed!", th2);
                }
                try {
                    InputStream decrypt2 = CryptTools.decrypt("AES/CBC/PKCS7Padding", this.secureKeyStore.b(str), this.secureKeyStore.c(str), byteArrayInputStream2);
                    byte[] bArr3 = new byte[256];
                    while (true) {
                        int read2 = decrypt2.read(bArr3);
                        if (read2 == -1) {
                            byteArrayOutputStream2.flush();
                            inputStream = decrypt2;
                            byte[] byteArray2 = byteArrayOutputStream2.toByteArray();
                            IOUtils.safeClose(decrypt2);
                            IOUtils.safeClose(byteArrayInputStream2);
                            IOUtils.safeClose(byteArrayOutputStream2);
                            return byteArray2;
                        }
                        byteArrayOutputStream2.write(bArr3, 0, read2);
                    }
                } catch (Throwable th8) {
                    th2 = th8;
                    throw new CryptException("decrypt failed!", th2);
                }
            }
        }
    }

    private byte[] doEncrypt(byte[] bArr) throws CryptException {
        InputStream inputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        InputStream inputStream2;
        ByteArrayInputStream byteArrayInputStream;
        ByteArrayInputStream byteArrayInputStream2 = null;
        if (this.secureKeyStore.f21905c != null) {
            try {
                ByteArrayInputStream byteArrayInputStream3 = new ByteArrayInputStream(bArr);
                try {
                    ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                    inputStream = null;
                    try {
                        d dVar = this.secureKeyStore;
                        InputStream encrypt = CryptTools.encrypt("AES/CBC/PKCS7Padding", dVar.a(dVar.g), this.secureKeyStore.b(), byteArrayInputStream3);
                        byte[] bArr2 = new byte[256];
                        while (true) {
                            int read = encrypt.read(bArr2);
                            if (read == -1) {
                                byteArrayOutputStream2.flush();
                                byte[] byteArray = byteArrayOutputStream2.toByteArray();
                                StringBuilder sb = new StringBuilder(CIPHER_FLAG_STARTER);
                                sb.append(this.secureKeyStore.g);
                                sb.append("-First");
                                byte[] bytes = sb.toString().getBytes();
                                int length = bytes.length;
                                byte[] bArr3 = new byte[byteArray.length + length];
                                System.arraycopy((Object) byteArray, 0, (Object) bArr3, 0, byteArray.length);
                                inputStream = encrypt;
                                System.arraycopy((Object) bytes, 0, (Object) bArr3, byteArray.length, length);
                                IOUtils.safeClose(encrypt);
                                IOUtils.safeClose(byteArrayInputStream3);
                                IOUtils.safeClose(byteArrayOutputStream2);
                                return bArr3;
                            }
                            byteArrayOutputStream2.write(bArr2, 0, read);
                        }
                    } catch (Throwable th) {
                        byteArrayInputStream2 = byteArrayInputStream3;
                        byteArrayOutputStream = byteArrayOutputStream2;
                        try {
                            ByteArrayInputStream byteArrayInputStream4 = new ByteArrayInputStream(bArr);
                            try {
                                ByteArrayOutputStream byteArrayOutputStream3 = new ByteArrayOutputStream();
                                try {
                                    InputStream encrypt2 = CryptTools.encrypt("AES/CBC/PKCS7Padding", this.secureKeyStore.a(), this.secureKeyStore.b(), byteArrayInputStream4);
                                    byte[] bArr4 = new byte[256];
                                    while (true) {
                                        int read2 = encrypt2.read(bArr4);
                                        if (read2 == -1) {
                                            byteArrayOutputStream3.flush();
                                            byte[] byteArray2 = byteArrayOutputStream3.toByteArray();
                                            StringBuilder sb2 = new StringBuilder(CIPHER_FLAG_STARTER);
                                            sb2.append(this.secureKeyStore.g);
                                            sb2.append("-Second");
                                            byte[] bytes2 = sb2.toString().getBytes();
                                            int length2 = bytes2.length;
                                            byte[] bArr5 = new byte[byteArray2.length + length2];
                                            System.arraycopy((Object) byteArray2, 0, (Object) bArr5, 0, byteArray2.length);
                                            inputStream = encrypt2;
                                            System.arraycopy((Object) bytes2, 0, (Object) bArr5, byteArray2.length, length2);
                                            IOUtils.safeClose(encrypt2);
                                            IOUtils.safeClose(byteArrayInputStream4);
                                            IOUtils.safeClose(byteArrayOutputStream3);
                                            return bArr5;
                                        }
                                        byteArrayOutputStream3.write(bArr4, 0, read2);
                                    }
                                } catch (Throwable th2) {
                                    byteArrayOutputStream = byteArrayOutputStream3;
                                    th = th2;
                                    byteArrayInputStream2 = byteArrayInputStream4;
                                    try {
                                        throw new CryptException("encrypt failed", th);
                                    } catch (Throwable th3) {
                                        IOUtils.safeClose(inputStream);
                                        throw th3;
                                    }
                                }
                            } catch (Throwable th4) {
                                th = th4;
                            }
                        } catch (Throwable th5) {
                            th = th5;
                        }
                    }
                } catch (Throwable th6) {
                    inputStream = null;
                    byteArrayInputStream2 = byteArrayInputStream3;
                    byteArrayOutputStream = null;
                }
            } catch (Throwable th7) {
                inputStream = null;
                byteArrayOutputStream = null;
            }
        } else {
            try {
                byteArrayInputStream = new ByteArrayInputStream(bArr);
                inputStream2 = null;
                try {
                    ByteArrayOutputStream byteArrayOutputStream4 = new ByteArrayOutputStream();
                    InputStream encrypt3 = CryptTools.encrypt("AES/CBC/PKCS7Padding", this.secureKeyStore.a(), this.secureKeyStore.b(), byteArrayInputStream);
                    byte[] bArr6 = new byte[256];
                    while (true) {
                        int read3 = encrypt3.read(bArr6);
                        if (read3 == -1) {
                            byteArrayOutputStream4.flush();
                            byte[] byteArray3 = byteArrayOutputStream4.toByteArray();
                            StringBuilder sb3 = new StringBuilder(CIPHER_FLAG_STARTER);
                            sb3.append(this.secureKeyStore.g);
                            sb3.append("-Second");
                            byte[] bytes3 = sb3.toString().getBytes();
                            int length3 = bytes3.length;
                            byte[] bArr7 = new byte[byteArray3.length + length3];
                            System.arraycopy((Object) byteArray3, 0, (Object) bArr7, 0, byteArray3.length);
                            inputStream2 = encrypt3;
                            System.arraycopy((Object) bytes3, 0, (Object) bArr7, byteArray3.length, length3);
                            IOUtils.safeClose(encrypt3);
                            IOUtils.safeClose(byteArrayInputStream);
                            return bArr7;
                        }
                        byteArrayOutputStream4.write(bArr6, 0, read3);
                    }
                } catch (Throwable th8) {
                    th = th8;
                    try {
                        throw new CryptException("encrypt failed", th);
                    } finally {
                        IOUtils.safeClose(inputStream2);
                        IOUtils.safeClose(byteArrayInputStream);
                    }
                }
            } catch (Throwable th9) {
                th = th9;
                inputStream2 = null;
                byteArrayInputStream = null;
            }
        }
    }

    private String getCipherFlag(byte[] bArr) {
        String str = new String(bArr);
        int lastIndexOf = str.lastIndexOf(CIPHER_FLAG_STARTER);
        if (lastIndexOf < 0) {
            return null;
        }
        return str.substring(lastIndexOf + 3);
    }

    public static SecureCryptTools getInstance() {
        return a.f21899a;
    }

    private List<CryptException> init(Context context) throws CryptException {
        List<CryptException> a2;
        try {
            this.lock.lock();
            if (this.initInvoked) {
                a2 = Collections.emptyList();
            } else {
                this.initInvoked = true;
                d dVar = new d();
                this.secureKeyStore = dVar;
                a2 = dVar.a(context);
            }
            this.lock.unlock();
            return a2;
        } catch (Throwable th) {
            this.lock.unlock();
            throw th;
        }
    }

    public byte[] decrypt(byte[] bArr) throws CryptException {
        try {
            if (this.initInvoked) {
                try {
                    this.lock.tryLock(m.ag, TimeUnit.MILLISECONDS);
                    if (this.lock.isLocked()) {
                        this.lock.unlock();
                    }
                    return doDecrypt(bArr);
                } catch (InterruptedException e) {
                    throw new CryptException("SecureCryptTools: wait init time out!");
                }
            }
            throw new CryptException("SecureCryptTools: please init firstly!");
        } catch (Throwable th) {
            if (this.lock.isLocked()) {
                this.lock.unlock();
            }
            throw th;
        }
    }

    public byte[] encrypt(byte[] bArr) throws CryptException {
        try {
            if (this.initInvoked) {
                try {
                    this.lock.tryLock(m.ag, TimeUnit.MILLISECONDS);
                    if (this.lock.isLocked()) {
                        this.lock.unlock();
                    }
                    return doEncrypt(bArr);
                } catch (InterruptedException e) {
                    throw new CryptException("SecureCryptTools: wait init time out!");
                }
            }
            throw new CryptException("SecureCryptTools: please init firstly!");
        } catch (Throwable th) {
            if (this.lock.isLocked()) {
                this.lock.unlock();
            }
            throw th;
        }
    }
}
