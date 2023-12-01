package com.xiaomi.clientreport.processor;

import android.content.Context;
import android.text.TextUtils;
import android.text.format.Formatter;
import android.util.Base64;
import com.xiaomi.clientreport.data.EventClientReport;
import com.xiaomi.push.ab;
import com.xiaomi.push.bn;
import com.xiaomi.push.br;
import com.xiaomi.push.h;
import com.xiaomi.push.x;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/clientreport/processor/a.class */
public class a implements IEventProcessor {

    /* renamed from: a  reason: collision with root package name */
    protected Context f27490a;

    /* renamed from: a  reason: collision with other field name */
    private HashMap<String, ArrayList<com.xiaomi.clientreport.data.a>> f58a;

    public a(Context context) {
        a(context);
    }

    public static String a(com.xiaomi.clientreport.data.a aVar) {
        return String.valueOf(aVar.production);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x003b, code lost:
        com.xiaomi.channel.commonutils.logger.b.d("eventData read from cache file failed because magicNumber error");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.util.List<java.lang.String> a(java.lang.String r7) {
        /*
            Method dump skipped, instructions count: 233
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.clientreport.processor.a.a(java.lang.String):java.util.List");
    }

    private void a(RandomAccessFile randomAccessFile, FileLock fileLock) {
        if (fileLock != null && fileLock.isValid()) {
            try {
                fileLock.release();
            } catch (IOException e) {
                com.xiaomi.channel.commonutils.logger.b.a(e);
            }
        }
        x.a(randomAccessFile);
    }

    private void a(String str, String str2) {
        com.xiaomi.clientreport.manager.a a2 = com.xiaomi.clientreport.manager.a.a(this.f27490a);
        EventClientReport a3 = a2.a(5001, "24:" + str + "," + str2);
        ArrayList arrayList = new ArrayList();
        arrayList.add(a3.toJsonString());
        a(arrayList);
    }

    /* JADX WARN: Not initialized variable reg: 19, insn: 0x0245: MOVE  (r0 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r19 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), block:B:74:0x0241 */
    /* JADX WARN: Not initialized variable reg: 20, insn: 0x0241: MOVE  (r0 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r20 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), block:B:74:0x0241 */
    private com.xiaomi.clientreport.data.a[] a(com.xiaomi.clientreport.data.a[] aVarArr) {
        Closeable closeable;
        Closeable closeable2;
        RandomAccessFile randomAccessFile;
        RandomAccessFile randomAccessFile2;
        FileLock fileLock;
        BufferedOutputStream bufferedOutputStream;
        BufferedOutputStream bufferedOutputStream2;
        RandomAccessFile randomAccessFile3;
        FileLock fileLock2;
        BufferedOutputStream bufferedOutputStream3;
        String b = b(aVarArr[0]);
        try {
            if (TextUtils.isEmpty(b)) {
                return null;
            }
            try {
                File file = new File(b + ".lock");
                x.m9172a(file);
                randomAccessFile2 = new RandomAccessFile(file, "rw");
                try {
                    fileLock = randomAccessFile2.getChannel().lock();
                    try {
                        bufferedOutputStream3 = new BufferedOutputStream(new FileOutputStream(new File(b), true));
                    } catch (Exception e) {
                        e = e;
                        bufferedOutputStream = null;
                    } catch (Throwable th) {
                        th = th;
                        closeable2 = null;
                        x.a(closeable2);
                        a(randomAccessFile2, fileLock);
                        throw th;
                    }
                } catch (Exception e2) {
                    e = e2;
                    fileLock = null;
                    bufferedOutputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                    fileLock = null;
                    closeable2 = null;
                }
            } catch (Exception e3) {
                e = e3;
                fileLock = null;
                randomAccessFile2 = null;
                bufferedOutputStream = null;
            } catch (Throwable th3) {
                th = th3;
                fileLock = null;
                randomAccessFile2 = null;
                closeable2 = null;
            }
            try {
                int length = aVarArr.length;
                int i = 0;
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    fileLock2 = fileLock;
                    randomAccessFile3 = randomAccessFile2;
                    bufferedOutputStream2 = bufferedOutputStream3;
                    if (i >= length) {
                        break;
                    }
                    com.xiaomi.clientreport.data.a aVar = aVarArr[i];
                    int i4 = i3;
                    if (aVar != null) {
                        byte[] stringToBytes = stringToBytes(aVar.toJsonString());
                        if (stringToBytes != null && stringToBytes.length > 0 && stringToBytes.length <= 4096) {
                            if (!br.m8502a(this.f27490a, b)) {
                                int length2 = aVarArr.length - i3;
                                com.xiaomi.clientreport.data.a[] aVarArr2 = new com.xiaomi.clientreport.data.a[length2];
                                System.arraycopy(aVarArr, i3, aVarArr2, 0, length2);
                                x.a(bufferedOutputStream3);
                                a(randomAccessFile2, fileLock);
                                return aVarArr2;
                            }
                            bufferedOutputStream3.write(ab.a(-573785174));
                            bufferedOutputStream3.write(ab.a(stringToBytes.length));
                            bufferedOutputStream3.write(stringToBytes);
                            bufferedOutputStream3.flush();
                            i4 = i3 + 1;
                        }
                        com.xiaomi.channel.commonutils.logger.b.d("event data throw a invalid item ");
                        i4 = i3;
                    }
                    i++;
                    i2 = i4;
                }
            } catch (Exception e4) {
                bufferedOutputStream = bufferedOutputStream3;
                e = e4;
                com.xiaomi.channel.commonutils.logger.b.a("event data write to cache file failed cause exception", e);
                bufferedOutputStream2 = bufferedOutputStream;
                randomAccessFile3 = randomAccessFile2;
                fileLock2 = fileLock;
                x.a(bufferedOutputStream2);
                a(randomAccessFile3, fileLock2);
                return null;
            }
            x.a(bufferedOutputStream2);
            a(randomAccessFile3, fileLock2);
            return null;
        } catch (Throwable th4) {
            th = th4;
            closeable2 = closeable;
            randomAccessFile2 = randomAccessFile;
            fileLock = null;
        }
    }

    private String b(com.xiaomi.clientreport.data.a aVar) {
        File externalFilesDir = this.f27490a.getExternalFilesDir("event");
        String a2 = a(aVar);
        if (externalFilesDir == null) {
            return null;
        }
        String str = externalFilesDir.getAbsolutePath() + File.separator + a2;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 100) {
                return null;
            }
            String str2 = str + i2;
            if (br.m8502a(this.f27490a, str2)) {
                return str2;
            }
            i = i2 + 1;
        }
    }

    @Override // com.xiaomi.clientreport.processor.c
    public void a() {
        File file;
        FileLock fileLock;
        RandomAccessFile randomAccessFile;
        File file2;
        RandomAccessFile randomAccessFile2;
        FileLock fileLock2;
        FileLock fileLock3;
        br.a(this.f27490a, "event", "eventUploading");
        File[] m8503a = br.m8503a(this.f27490a, "eventUploading");
        if (m8503a == null || m8503a.length <= 0) {
            return;
        }
        int length = m8503a.length;
        int i = 0;
        FileLock fileLock4 = null;
        RandomAccessFile randomAccessFile3 = null;
        File file3 = null;
        while (true) {
            File file4 = file3;
            if (i >= length) {
                return;
            }
            File file5 = m8503a[i];
            if (file5 == null) {
                if (fileLock4 != null && fileLock4.isValid()) {
                    try {
                        fileLock4.release();
                    } catch (IOException e) {
                        com.xiaomi.channel.commonutils.logger.b.a(e);
                    }
                }
                x.a(randomAccessFile3);
                fileLock = fileLock4;
                randomAccessFile = randomAccessFile3;
                file2 = file4;
                if (file4 == null) {
                    i++;
                    fileLock4 = fileLock;
                    randomAccessFile3 = randomAccessFile;
                    file3 = file2;
                }
                file4.delete();
                fileLock = fileLock4;
                randomAccessFile = randomAccessFile3;
                file2 = file4;
                i++;
                fileLock4 = fileLock;
                randomAccessFile3 = randomAccessFile;
                file3 = file2;
            } else {
                try {
                    try {
                    } catch (Throwable th) {
                        th = th;
                        fileLock4 = fileLock4;
                        randomAccessFile3 = randomAccessFile3;
                        file = file4;
                    }
                } catch (Exception e2) {
                    e = e2;
                }
                if (file5.length() > 5242880) {
                    FileLock fileLock5 = fileLock4;
                    StringBuilder sb = new StringBuilder("eventData read from cache file failed because ");
                    FileLock fileLock6 = fileLock4;
                    sb.append(file5.getName());
                    FileLock fileLock7 = fileLock4;
                    sb.append(" is too big, length ");
                    FileLock fileLock8 = fileLock4;
                    sb.append(file5.length());
                    FileLock fileLock9 = fileLock4;
                    com.xiaomi.channel.commonutils.logger.b.d(sb.toString());
                    FileLock fileLock10 = fileLock4;
                    a(file5.getName(), Formatter.formatFileSize(this.f27490a, file5.length()));
                    FileLock fileLock11 = fileLock4;
                    file5.delete();
                    if (fileLock4 != null && fileLock4.isValid()) {
                        try {
                            fileLock4.release();
                        } catch (IOException e3) {
                            com.xiaomi.channel.commonutils.logger.b.a(e3);
                        }
                    }
                    x.a(randomAccessFile3);
                    fileLock = fileLock4;
                    randomAccessFile = randomAccessFile3;
                    file2 = file4;
                    if (file4 == null) {
                    }
                    file4.delete();
                    fileLock = fileLock4;
                    randomAccessFile = randomAccessFile3;
                    file2 = file4;
                } else {
                    String absolutePath = file5.getAbsolutePath();
                    FileLock fileLock12 = fileLock4;
                    StringBuilder sb2 = new StringBuilder();
                    FileLock fileLock13 = fileLock4;
                    sb2.append(absolutePath);
                    FileLock fileLock14 = fileLock4;
                    sb2.append(".lock");
                    FileLock fileLock15 = fileLock4;
                    file = new File(sb2.toString());
                    try {
                        x.m9172a(file);
                        randomAccessFile2 = new RandomAccessFile(file, "rw");
                        fileLock2 = fileLock4;
                        fileLock3 = fileLock4;
                    } catch (Exception e4) {
                        e = e4;
                    } catch (Throwable th2) {
                        th = th2;
                    }
                    try {
                        FileLock lock = randomAccessFile2.getChannel().lock();
                        a(a(absolutePath));
                        file5.delete();
                        if (lock != null && lock.isValid()) {
                            try {
                                lock.release();
                            } catch (IOException e5) {
                                com.xiaomi.channel.commonutils.logger.b.a(e5);
                            }
                        }
                        x.a(randomAccessFile2);
                        file.delete();
                        file2 = file;
                        fileLock = lock;
                        randomAccessFile = randomAccessFile2;
                    } catch (Exception e6) {
                        randomAccessFile3 = randomAccessFile2;
                        fileLock4 = fileLock3;
                        e = e6;
                        file4 = file;
                        e = e;
                        com.xiaomi.channel.commonutils.logger.b.a(e);
                        if (fileLock4 != null && fileLock4.isValid()) {
                            try {
                                fileLock4.release();
                            } catch (IOException e7) {
                                com.xiaomi.channel.commonutils.logger.b.a(e7);
                            }
                        }
                        x.a(randomAccessFile3);
                        fileLock = fileLock4;
                        randomAccessFile = randomAccessFile3;
                        file2 = file4;
                        if (file4 == null) {
                            i++;
                            fileLock4 = fileLock;
                            randomAccessFile3 = randomAccessFile;
                            file3 = file2;
                        }
                        file4.delete();
                        fileLock = fileLock4;
                        randomAccessFile = randomAccessFile3;
                        file2 = file4;
                        i++;
                        fileLock4 = fileLock;
                        randomAccessFile3 = randomAccessFile;
                        file3 = file2;
                    } catch (Throwable th3) {
                        th = th3;
                        fileLock4 = fileLock2;
                        randomAccessFile3 = randomAccessFile2;
                        if (fileLock4 != null && fileLock4.isValid()) {
                            try {
                                fileLock4.release();
                            } catch (IOException e8) {
                                com.xiaomi.channel.commonutils.logger.b.a(e8);
                            }
                        }
                        x.a(randomAccessFile3);
                        if (file != null) {
                            file.delete();
                        }
                        throw th;
                    }
                }
                i++;
                fileLock4 = fileLock;
                randomAccessFile3 = randomAccessFile;
                file3 = file2;
            }
        }
    }

    public void a(Context context) {
        this.f27490a = context;
    }

    @Override // com.xiaomi.clientreport.processor.d
    /* renamed from: a  reason: collision with other method in class */
    public void mo8353a(com.xiaomi.clientreport.data.a aVar) {
        if ((aVar instanceof EventClientReport) && this.f58a != null) {
            EventClientReport eventClientReport = (EventClientReport) aVar;
            String a2 = a((com.xiaomi.clientreport.data.a) eventClientReport);
            ArrayList<com.xiaomi.clientreport.data.a> arrayList = this.f58a.get(a2);
            ArrayList<com.xiaomi.clientreport.data.a> arrayList2 = arrayList;
            if (arrayList == null) {
                arrayList2 = new ArrayList<>();
            }
            arrayList2.add(eventClientReport);
            this.f58a.put(a2, arrayList2);
        }
    }

    public void a(List<String> list) {
        br.a(this.f27490a, list);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m8354a(com.xiaomi.clientreport.data.a[] aVarArr) {
        com.xiaomi.clientreport.data.a[] a2;
        if (aVarArr != null && aVarArr.length != 0) {
            com.xiaomi.clientreport.data.a[] aVarArr2 = aVarArr;
            if (aVarArr[0] != null) {
                do {
                    a2 = a(aVarArr2);
                    if (a2 == null || a2.length <= 0) {
                        return;
                    }
                    aVarArr2 = a2;
                } while (a2[0] != null);
                return;
            }
        }
        com.xiaomi.channel.commonutils.logger.b.m8344a("event data write to cache file failed because data null");
    }

    @Override // com.xiaomi.clientreport.processor.d
    public void b() {
        HashMap<String, ArrayList<com.xiaomi.clientreport.data.a>> hashMap = this.f58a;
        if (hashMap == null) {
            return;
        }
        if (hashMap.size() > 0) {
            for (String str : this.f58a.keySet()) {
                ArrayList<com.xiaomi.clientreport.data.a> arrayList = this.f58a.get(str);
                if (arrayList != null && arrayList.size() > 0) {
                    com.xiaomi.clientreport.data.a[] aVarArr = new com.xiaomi.clientreport.data.a[arrayList.size()];
                    arrayList.toArray(aVarArr);
                    m8354a(aVarArr);
                }
            }
        }
        this.f58a.clear();
    }

    @Override // com.xiaomi.clientreport.processor.IEventProcessor
    public String bytesToString(byte[] bArr) {
        byte[] a2;
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        if (com.xiaomi.clientreport.manager.a.a(this.f27490a).m8350a().isEventEncrypted()) {
            String a3 = br.a(this.f27490a);
            if (TextUtils.isEmpty(a3) || (a2 = br.a(a3)) == null || a2.length <= 0) {
                return null;
            }
            try {
                return bn.b(Base64.decode(h.a(a2, bArr), 2));
            } catch (InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e) {
                com.xiaomi.channel.commonutils.logger.b.a(e);
                return null;
            }
        }
        return bn.b(bArr);
    }

    @Override // com.xiaomi.clientreport.processor.IEventProcessor
    public void setEventMap(HashMap<String, ArrayList<com.xiaomi.clientreport.data.a>> hashMap) {
        this.f58a = hashMap;
    }

    @Override // com.xiaomi.clientreport.processor.IEventProcessor
    public byte[] stringToBytes(String str) {
        byte[] a2;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (com.xiaomi.clientreport.manager.a.a(this.f27490a).m8350a().isEventEncrypted()) {
            String a3 = br.a(this.f27490a);
            byte[] m8499a = bn.m8499a(str);
            if (TextUtils.isEmpty(a3) || m8499a == null || m8499a.length <= 1 || (a2 = br.a(a3)) == null) {
                return null;
            }
            try {
                if (a2.length > 1) {
                    return h.b(a2, Base64.encode(m8499a, 2));
                }
                return null;
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.a(e);
                return null;
            }
        }
        return bn.m8499a(str);
    }
}
