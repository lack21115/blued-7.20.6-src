package com.xiaomi.push;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.xiaomi.channel.commonutils.logger.LoggerInterface;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/dh.class */
public class dh implements LoggerInterface {

    /* renamed from: a  reason: collision with root package name */
    private static volatile dh f41335a;

    /* renamed from: a  reason: collision with other field name */
    private Context f301a;

    /* renamed from: a  reason: collision with other field name */
    private Handler f302a;
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private String f41336c = "";

    /* renamed from: a  reason: collision with other field name */
    private static final SimpleDateFormat f299a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss aaa");

    /* renamed from: a  reason: collision with other field name */
    public static String f298a = "/MiPushLog";

    /* renamed from: a  reason: collision with other field name */
    private static List<Pair<String, Throwable>> f300a = Collections.synchronizedList(new ArrayList());

    private dh(Context context) {
        this.f301a = context;
        if (context.getApplicationContext() != null) {
            this.f301a = context.getApplicationContext();
        }
        this.b = this.f301a.getPackageName() + "-" + Process.myPid();
        HandlerThread handlerThread = new HandlerThread("Log2FileHandlerThread");
        handlerThread.start();
        this.f302a = new Handler(handlerThread.getLooper());
    }

    public static dh a(Context context) {
        if (f41335a == null) {
            synchronized (dh.class) {
                try {
                    if (f41335a == null) {
                        f41335a = new dh(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f41335a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Not initialized variable reg: 16, insn: 0x02cc: MOVE  (r0 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r16 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), block:B:105:0x02c9 */
    /* JADX WARN: Not initialized variable reg: 17, insn: 0x02c9: MOVE  (r0 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r17 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), block:B:105:0x02c9 */
    /* renamed from: a  reason: collision with other method in class */
    public void m11621a() {
        RandomAccessFile randomAccessFile;
        RandomAccessFile randomAccessFile2;
        FileLock fileLock;
        FileLock fileLock2;
        File externalFilesDir;
        BufferedWriter bufferedWriter = null;
        BufferedWriter bufferedWriter2 = null;
        try {
            try {
                try {
                    if (TextUtils.isEmpty(this.f41336c) && (externalFilesDir = this.f301a.getExternalFilesDir(null)) != null) {
                        this.f41336c = externalFilesDir.getAbsolutePath();
                    }
                    File file = new File(this.f41336c + f298a);
                    if ((!file.exists() || !file.isDirectory()) && !file.mkdirs()) {
                        Log.w(this.b, "Create mipushlog directory fail.");
                        return;
                    }
                    File file2 = new File(file, "log.lock");
                    if (!file2.exists() || file2.isDirectory()) {
                        file2.createNewFile();
                    }
                    randomAccessFile2 = new RandomAccessFile(file2, "rw");
                    try {
                        fileLock2 = randomAccessFile2.getChannel().lock();
                        try {
                            BufferedWriter bufferedWriter3 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(file, "log1.txt"), true)));
                            while (!f300a.isEmpty()) {
                                try {
                                    Pair<String, Throwable> remove = f300a.remove(0);
                                    String str = remove.first;
                                    String str2 = str;
                                    if (remove.second != null) {
                                        str2 = (str + "\n") + Log.getStackTraceString(remove.second);
                                    }
                                    bufferedWriter3.write(str2 + "\n");
                                } catch (Exception e) {
                                    bufferedWriter2 = bufferedWriter3;
                                    e = e;
                                    Log.e(this.b, "", e);
                                    if (bufferedWriter2 != null) {
                                        try {
                                            bufferedWriter2.close();
                                        } catch (IOException e2) {
                                            Log.e(this.b, "", e2);
                                        }
                                    }
                                    if (fileLock2 != null && fileLock2.isValid()) {
                                        try {
                                            fileLock2.release();
                                        } catch (IOException e3) {
                                            Log.e(this.b, "", e3);
                                        }
                                    }
                                    if (randomAccessFile2 != null) {
                                        randomAccessFile2.close();
                                        return;
                                    }
                                    return;
                                } catch (Throwable th) {
                                    bufferedWriter = bufferedWriter3;
                                    th = th;
                                    if (bufferedWriter != null) {
                                        try {
                                            bufferedWriter.close();
                                        } catch (IOException e4) {
                                            Log.e(this.b, "", e4);
                                        }
                                    }
                                    if (fileLock2 != null && fileLock2.isValid()) {
                                        try {
                                            fileLock2.release();
                                        } catch (IOException e5) {
                                            Log.e(this.b, "", e5);
                                        }
                                    }
                                    if (randomAccessFile2 != null) {
                                        try {
                                            randomAccessFile2.close();
                                        } catch (IOException e6) {
                                            Log.e(this.b, "", e6);
                                        }
                                    }
                                    throw th;
                                }
                            }
                            bufferedWriter3.flush();
                            bufferedWriter3.close();
                            File file3 = new File(file, "log1.txt");
                            if (file3.length() >= 1048576) {
                                File file4 = new File(file, "log0.txt");
                                if (file4.exists() && file4.isFile()) {
                                    file4.delete();
                                }
                                file3.renameTo(file4);
                            }
                            if (fileLock2 != null && fileLock2.isValid()) {
                                try {
                                    fileLock2.release();
                                } catch (IOException e7) {
                                    Log.e(this.b, "", e7);
                                }
                            }
                            randomAccessFile2.close();
                        } catch (Exception e8) {
                            e = e8;
                        }
                    } catch (Exception e9) {
                        e = e9;
                        fileLock2 = null;
                    } catch (Throwable th2) {
                        th = th2;
                        fileLock2 = null;
                    }
                } catch (Exception e10) {
                    e = e10;
                    fileLock2 = null;
                    randomAccessFile2 = null;
                } catch (Throwable th3) {
                    th = th3;
                    fileLock2 = null;
                    randomAccessFile2 = null;
                }
            } catch (IOException e11) {
                Log.e(this.b, "", e11);
            }
        } catch (Throwable th4) {
            th = th4;
            randomAccessFile2 = randomAccessFile;
            fileLock2 = fileLock;
        }
    }

    @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
    public final void log(String str) {
        log(str, null);
    }

    @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
    public final void log(String str, Throwable th) {
        this.f302a.post(new di(this, str, th));
    }

    @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
    public final void setTag(String str) {
        this.b = str;
    }
}
