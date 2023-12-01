package com.getui.gtc.base.log.b;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import com.getui.gtc.base.GtcProvider;
import com.getui.gtc.base.crypt.CryptTools;
import com.getui.gtc.base.log.ILogDestination;
import com.igexin.push.f.e;
import com.tencent.cos.xml.crypto.JceEncryptionConstants;
import com.youzan.androidsdk.tool.AppSigning;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

/* loaded from: source-8110460-dex2jar.jar:com/getui/gtc/base/log/b/a.class */
public class a implements ILogDestination {
    private static Map<File, Handler> d = new ConcurrentHashMap();
    private static Map<File, SecretKey> e = new ConcurrentHashMap();
    private static Map<File, IvParameterSpec> f = new ConcurrentHashMap();

    /* renamed from: a  reason: collision with root package name */
    public final Context f21909a = GtcProvider.context();

    /* renamed from: c  reason: collision with root package name */
    public String f21910c = this.f21909a.getPackageName() + "-" + new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date()) + com.anythink.china.common.a.a.f;
    public File b = new File(this.f21909a.getExternalFilesDir(null), this.f21910c);

    private void a(final File file) {
        d.get(file).post(new Runnable() { // from class: com.getui.gtc.base.log.b.a.1
            @Override // java.lang.Runnable
            public final void run() {
                FileLock fileLock;
                DataOutputStream dataOutputStream;
                RandomAccessFile randomAccessFile;
                try {
                    randomAccessFile = new RandomAccessFile(file, "rw");
                    try {
                        fileLock = randomAccessFile.getChannel().lock();
                        DataOutputStream dataOutputStream2 = null;
                        if (fileLock != null) {
                            dataOutputStream2 = null;
                            try {
                                if (fileLock.isValid()) {
                                    dataOutputStream = new DataOutputStream(new FileOutputStream(file, true));
                                    try {
                                        PublicKey parsePublicKey = CryptTools.parsePublicKey("RSA", e.f23642a);
                                        SecretKey secretKey = (SecretKey) a.e.get(file);
                                        IvParameterSpec ivParameterSpec = (IvParameterSpec) a.f.get(file);
                                        byte[] encrypt = CryptTools.encrypt("RSA/ECB/OAEPWithSHA1AndMGF1Padding", parsePublicKey, secretKey.getEncoded());
                                        int length = encrypt.length;
                                        dataOutputStream.write(0);
                                        dataOutputStream.write(ivParameterSpec.getIV());
                                        dataOutputStream.writeInt(length);
                                        dataOutputStream.write(encrypt);
                                        dataOutputStream2 = dataOutputStream;
                                    } catch (Throwable th) {
                                        th = th;
                                        try {
                                            System.out.println("gtc-base fileLog writeKeyBlock failed: " + th.getMessage());
                                            th.printStackTrace();
                                            if (dataOutputStream != null) {
                                                try {
                                                    dataOutputStream.flush();
                                                    dataOutputStream.close();
                                                } catch (IOException e2) {
                                                }
                                            }
                                            if (fileLock != null && fileLock.isValid()) {
                                                try {
                                                    fileLock.release();
                                                } catch (IOException e3) {
                                                }
                                            }
                                            if (randomAccessFile != null) {
                                                try {
                                                    randomAccessFile.close();
                                                    return;
                                                } catch (IOException e4) {
                                                    return;
                                                }
                                            }
                                            return;
                                        } catch (Throwable th2) {
                                            if (dataOutputStream != null) {
                                                try {
                                                    dataOutputStream.flush();
                                                    dataOutputStream.close();
                                                } catch (IOException e5) {
                                                }
                                            }
                                            if (fileLock != null && fileLock.isValid()) {
                                                try {
                                                    fileLock.release();
                                                } catch (IOException e6) {
                                                }
                                            }
                                            if (randomAccessFile != null) {
                                                try {
                                                    randomAccessFile.close();
                                                } catch (IOException e7) {
                                                }
                                            }
                                            throw th2;
                                        }
                                    }
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                dataOutputStream = null;
                            }
                        }
                        if (dataOutputStream2 != null) {
                            try {
                                dataOutputStream2.flush();
                                dataOutputStream2.close();
                            } catch (IOException e8) {
                            }
                        }
                        if (fileLock != null && fileLock.isValid()) {
                            try {
                                fileLock.release();
                            } catch (IOException e9) {
                            }
                        }
                        try {
                            randomAccessFile.close();
                        } catch (IOException e10) {
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        dataOutputStream = null;
                        fileLock = null;
                    }
                } catch (Throwable th5) {
                    th = th5;
                    fileLock = null;
                    dataOutputStream = null;
                    randomAccessFile = null;
                }
            }
        });
    }

    @Override // com.getui.gtc.base.log.ILogDestination
    public void log(int i, String str, final String str2) {
        if (!this.b.exists()) {
            try {
                this.b.getParentFile().mkdirs();
                this.b.createNewFile();
            } catch (Throwable th) {
            }
            if (d.get(this.b) != null) {
                a(this.b);
            }
        }
        if (d.get(this.b) == null || e.get(this.b) == null || f.get(this.b) == null) {
            synchronized (a.class) {
                try {
                    if (d.get(this.b) == null) {
                        HandlerThread handlerThread = new HandlerThread("File-Log-Thread");
                        handlerThread.start();
                        d.put(this.b, new Handler(handlerThread.getLooper()));
                    }
                    if (e.get(this.b) == null) {
                        try {
                            e.put(this.b, CryptTools.generateKey("AES", 128));
                        } catch (NoSuchAlgorithmException e2) {
                            e2.printStackTrace();
                        }
                    }
                    if (f.get(this.b) == null) {
                        f.put(this.b, new IvParameterSpec(new SecureRandom().generateSeed(16)));
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            a(this.b);
        }
        final File file = this.b;
        d.get(file).post(new Runnable() { // from class: com.getui.gtc.base.log.b.a.2
            @Override // java.lang.Runnable
            public final void run() {
                FileLock fileLock;
                DataOutputStream dataOutputStream;
                RandomAccessFile randomAccessFile;
                try {
                    randomAccessFile = new RandomAccessFile(file, "rw");
                    try {
                        fileLock = randomAccessFile.getChannel().lock();
                        DataOutputStream dataOutputStream2 = null;
                        if (fileLock != null) {
                            dataOutputStream2 = null;
                            try {
                                if (fileLock.isValid()) {
                                    dataOutputStream = new DataOutputStream(new FileOutputStream(file, true));
                                    try {
                                        SecretKey secretKey = (SecretKey) a.e.get(file);
                                        IvParameterSpec ivParameterSpec = (IvParameterSpec) a.f.get(file);
                                        byte[] digest = CryptTools.digest(AppSigning.SHA1, secretKey.getEncoded());
                                        byte[] encrypt = CryptTools.encrypt(JceEncryptionConstants.SYMMETRIC_CIPHER_METHOD, secretKey, ivParameterSpec, str2.getBytes());
                                        int length = encrypt.length;
                                        dataOutputStream.write(112);
                                        dataOutputStream.write(digest);
                                        dataOutputStream.writeInt(length);
                                        dataOutputStream.write(encrypt);
                                        dataOutputStream2 = dataOutputStream;
                                    } catch (Throwable th3) {
                                        th = th3;
                                        try {
                                            System.out.println("gtc-base fileLog writeMessageBlock failed: " + str2);
                                            th.printStackTrace();
                                            if (dataOutputStream != null) {
                                                try {
                                                    dataOutputStream.flush();
                                                    dataOutputStream.close();
                                                } catch (IOException e3) {
                                                }
                                            }
                                            if (fileLock != null && fileLock.isValid()) {
                                                try {
                                                    fileLock.release();
                                                } catch (IOException e4) {
                                                }
                                            }
                                            if (randomAccessFile != null) {
                                                try {
                                                    randomAccessFile.close();
                                                    return;
                                                } catch (IOException e5) {
                                                    return;
                                                }
                                            }
                                            return;
                                        } catch (Throwable th4) {
                                            if (dataOutputStream != null) {
                                                try {
                                                    dataOutputStream.flush();
                                                    dataOutputStream.close();
                                                } catch (IOException e6) {
                                                }
                                            }
                                            if (fileLock != null && fileLock.isValid()) {
                                                try {
                                                    fileLock.release();
                                                } catch (IOException e7) {
                                                }
                                            }
                                            if (randomAccessFile != null) {
                                                try {
                                                    randomAccessFile.close();
                                                } catch (IOException e8) {
                                                }
                                            }
                                            throw th4;
                                        }
                                    }
                                }
                            } catch (Throwable th5) {
                                th = th5;
                                dataOutputStream = null;
                            }
                        }
                        if (dataOutputStream2 != null) {
                            try {
                                dataOutputStream2.flush();
                                dataOutputStream2.close();
                            } catch (IOException e9) {
                            }
                        }
                        if (fileLock != null && fileLock.isValid()) {
                            try {
                                fileLock.release();
                            } catch (IOException e10) {
                            }
                        }
                        try {
                            randomAccessFile.close();
                        } catch (IOException e11) {
                        }
                    } catch (Throwable th6) {
                        th = th6;
                        dataOutputStream = null;
                        fileLock = null;
                    }
                } catch (Throwable th7) {
                    th = th7;
                    fileLock = null;
                    dataOutputStream = null;
                    randomAccessFile = null;
                }
            }
        });
    }
}
