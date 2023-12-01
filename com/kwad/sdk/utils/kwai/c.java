package com.kwad.sdk.utils.kwai;

import android.text.TextUtils;
import android.widget.ExpandableListView;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.kwad.sdk.utils.kwai.a;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteOrder;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/utils/kwai/c.class */
public final class c {
    private static final int PAGE_SIZE;
    private static final int[] aBP = {0, 1, 4, 4, 8, 8};
    private static final byte[] aBQ = new byte[0];
    private static final int aBR;
    private static final int aBS;
    private static final int aBT;
    private final String RZ;
    private final Map<String, b> aBU;
    private FileChannel aBW;
    private FileChannel aBX;
    private RandomAccessFile aBY;
    private RandomAccessFile aBZ;
    private MappedByteBuffer aCa;
    private MappedByteBuffer aCb;
    private com.kwad.sdk.utils.kwai.b aCc;
    private int aCd;
    private long aCe;
    private int aCh;
    private int aCi;
    private int aCj;
    private boolean aCk;
    private String aCl;
    private int aCm;
    private int aCo;
    private final String name;
    private final d aBV = com.kwad.sdk.utils.kwai.d.aCz;
    private final Map<String, a.b> aCf = new HashMap();
    private boolean aCg = false;
    private final ArrayList<e> aCn = new ArrayList<>();
    private boolean aCp = true;
    private final Executor aCq = new f();

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/utils/kwai/c$a.class */
    public static class a {
        static int aCs = 11;
        static final C0581c aCt = new C0581c(11);
        private final String RZ;
        private int aCo = 0;
        private b[] aCu;
        private final String name;

        public a(String str, String str2) {
            if (str == null || str.isEmpty()) {
                throw new IllegalArgumentException("path is empty");
            }
            if (str2 == null || str2.isEmpty()) {
                throw new IllegalArgumentException("name is empty");
            }
            if (!str.endsWith(BridgeUtil.SPLIT_MARK)) {
                str = str + '/';
            }
            this.RZ = str;
            this.name = str2;
        }

        public final c Fv() {
            String str = this.RZ + this.name;
            c fd = C0581c.fd(str);
            c cVar = fd;
            if (fd == null) {
                synchronized (a.class) {
                    try {
                        c fd2 = C0581c.fd(str);
                        cVar = fd2;
                        if (fd2 == null) {
                            cVar = new c(this.RZ, this.name, this.aCu, this.aCo);
                            C0581c.b(str, cVar);
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            Integer num = C0581c.aCy.get(str);
            if (num != null) {
                C0581c.aCy.put(str, Integer.valueOf(num.intValue() + 1));
                return cVar;
            }
            C0581c.aCy.put(str, 1);
            return cVar;
        }
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/utils/kwai/c$b.class */
    public interface b<T> {
        String Fw();

        T g(byte[] bArr, int i, int i2);

        byte[] j(T t);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.kwad.sdk.utils.kwai.c$c  reason: collision with other inner class name */
    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/utils/kwai/c$c.class */
    public static final class C0581c {
        private static Map<String, c> aCv;
        private static List<String> aCw;
        private static int aCx;
        public static Map<String, Integer> aCy;

        public C0581c(int i) {
            int size = getSize(i);
            aCv = new ConcurrentHashMap(size);
            aCy = new HashMap(size);
            aCw = new CopyOnWriteArrayList();
            aCx = i;
        }

        public static void b(String str, c cVar) {
            if (aCv == null) {
                aCv = new ConcurrentHashMap(getSize(aCx));
            }
            if (aCw == null) {
                aCw = new CopyOnWriteArrayList();
            }
            if (aCv.containsKey(str)) {
                aCw.remove(str);
            }
            aCw.add(str);
            aCv.put(str, cVar);
            if (aCv.size() > aCx) {
                Integer num = aCy.get(aCw.get(0));
                if (num != null && num.intValue() != 2) {
                    ct(aCx + 1);
                    return;
                }
                c cVar2 = aCv.get(aCw.get(0));
                if (cVar2 != null) {
                    cVar2.release();
                }
                aCv.remove(aCw.get(0));
                aCw.remove(0);
            }
        }

        private static void ct(int i) {
            d dVar = com.kwad.sdk.utils.kwai.d.aCz;
            dVar.i("Ks_UnionKv", "reSize:" + i);
            aCx = i;
        }

        public static c fd(String str) {
            if (aCv == null) {
                aCv = new ConcurrentHashMap(getSize(aCx));
            }
            if (aCw == null) {
                aCw = new CopyOnWriteArrayList();
            }
            c cVar = aCv.get(str);
            if (cVar != null) {
                aCw.remove(str);
                aCw.add(str);
                return cVar;
            }
            return null;
        }

        private static int getSize(int i) {
            return (int) ((i / 0.75f) + 1.0f);
        }

        public static void remove(String str) {
            List<String> list = aCw;
            if (list != null) {
                list.remove(str);
            }
            Map<String, c> map = aCv;
            if (map != null) {
                map.remove(str);
            }
        }
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/utils/kwai/c$d.class */
    public interface d {
        void a(String str, Exception exc);

        void e(String str, Throwable th);

        void i(String str, String str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/utils/kwai/c$e.class */
    public static final class e implements Comparable<e> {
        int end;
        int start;

        e(int i, int i2) {
            this.start = i;
            this.end = i2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(e eVar) {
            return this.start - eVar.start;
        }
    }

    static {
        int Fz = h.Fz();
        PAGE_SIZE = Fz;
        aBR = Fz - 192;
        int max = Math.max(Fz << 1, 16384);
        aBS = max;
        aBT = max << 1;
    }

    c(String str, String str2, b[] bVarArr, int i) {
        this.RZ = str;
        this.name = str2;
        this.aCo = i;
        HashMap hashMap = new HashMap();
        g gVar = g.aCH;
        hashMap.put(gVar.Fw(), gVar);
        if (bVarArr != null && bVarArr.length > 0) {
            int length = bVarArr.length;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= length) {
                    break;
                }
                b bVar = bVarArr[i3];
                String Fw = bVar.Fw();
                if (hashMap.containsKey(Fw)) {
                    fc("duplicate encoder tag:" + Fw);
                } else {
                    hashMap.put(Fw, bVar);
                }
                i2 = i3 + 1;
            }
        }
        this.aBU = hashMap;
        synchronized (this.aCf) {
            com.kwad.sdk.utils.kwai.d.getExecutor().execute(new Runnable() { // from class: com.kwad.sdk.utils.kwai.c.1
                @Override // java.lang.Runnable
                public final void run() {
                    c.this.Fd();
                }
            });
            while (!this.aCg) {
                try {
                    this.aCf.wait();
                } catch (InterruptedException e2) {
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fd() {
        synchronized (this) {
            synchronized (this.aCf) {
                this.aCg = true;
                this.aCf.notify();
            }
            long nanoTime = System.nanoTime();
            if (!Fg() && this.aCo == 0) {
                Fe();
            }
            if (this.aCc == null) {
                this.aCc = new com.kwad.sdk.utils.kwai.b(PAGE_SIZE);
            }
            if (this.aBV != null) {
                long nanoTime2 = (System.nanoTime() - nanoTime) / 1000000;
                info("loading finish, data len:" + this.aCd + ", get keys:" + this.aCf.size() + ", use time:" + nanoTime2 + " ms");
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x01f7  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x02a0 A[Catch: all -> 0x02d4, TRY_ENTER, TryCatch #0 {all -> 0x02d4, blocks: (B:3:0x0062, B:5:0x006a, B:8:0x0075, B:10:0x00be, B:16:0x00de, B:22:0x0117, B:24:0x0130, B:28:0x0149, B:30:0x0150, B:34:0x0181, B:36:0x01b4, B:38:0x01bb, B:44:0x01d1, B:47:0x01d9, B:53:0x0207, B:55:0x022e, B:57:0x0241, B:59:0x026c, B:61:0x0273, B:65:0x02a0, B:20:0x0110, B:14:0x00d7, B:68:0x02ae, B:70:0x02c1), top: B:78:0x0062, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:81:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void Fe() {
        /*
            Method dump skipped, instructions count: 752
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.utils.kwai.c.Fe():void");
    }

    private boolean Ff() {
        com.kwad.sdk.utils.kwai.b bVar = new com.kwad.sdk.utils.kwai.b(this.aCd);
        MappedByteBuffer mappedByteBuffer = this.aCb;
        if (mappedByteBuffer != null) {
            mappedByteBuffer.rewind();
            this.aCb.get(bVar.aBO, 0, this.aCd);
        }
        com.kwad.sdk.utils.kwai.b bVar2 = this.aCc;
        if (bVar2 == null) {
            return true;
        }
        byte[] bArr = bVar2.aBO;
        byte[] bArr2 = bVar.aBO;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.aCd) {
                return true;
            }
            if (bArr[i2] != bArr2[i2]) {
                return false;
            }
            i = i2 + 1;
        }
    }

    private boolean Fg() {
        File file = new File(this.RZ, this.name + ".kvc");
        File file2 = new File(this.RZ, this.name + ".tmp");
        boolean z = true;
        try {
            if (!file.exists()) {
                file = file2.exists() ? file2 : null;
            }
            if (file != null) {
                if (!X(file)) {
                    Fo();
                    Fl();
                    return false;
                } else if (this.aCo == 0) {
                    if (!a(this.aCc)) {
                        this.aCo = 1;
                        return false;
                    }
                    info("recover from c file");
                    try {
                        Fl();
                        return true;
                    } catch (Exception e2) {
                        e = e2;
                        m(e);
                        return z;
                    }
                } else {
                    return false;
                }
            } else if (this.aCo != 0) {
                File file3 = new File(this.RZ, this.name + ".kva");
                File file4 = new File(this.RZ, this.name + ".kvb");
                if (file3.exists() && file4.exists()) {
                    f(file3, file4);
                    return false;
                }
                return false;
            } else {
                return false;
            }
        } catch (Exception e3) {
            e = e3;
            z = false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:86:0x02e1, code lost:
        throw new java.lang.Exception("parse dara failed");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int Fh() {
        /*
            Method dump skipped, instructions count: 778
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.utils.kwai.c.Fh():int");
    }

    private void Fi() {
        if (this.aCo == 0 || !this.aCp) {
            return;
        }
        Fj();
    }

    private boolean Fj() {
        int i = this.aCo;
        if (i != 1) {
            if (i == 2) {
                return Fk();
            }
            return true;
        }
        Executor executor = this.aCq;
        if (executor != null) {
            executor.execute(new Runnable() { // from class: com.kwad.sdk.utils.kwai.c.2
                @Override // java.lang.Runnable
                public final void run() {
                    c.this.Fk();
                }
            });
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Fk() {
        synchronized (this) {
            try {
                String str = this.RZ;
                File file = new File(str, this.name + ".tmp");
                if (h.Y(file)) {
                    RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                    randomAccessFile.setLength(this.aCd);
                    randomAccessFile.write(this.aCc.aBO, 0, this.aCd);
                    randomAccessFile.close();
                    String str2 = this.RZ;
                    File file2 = new File(str2, this.name + ".kvc");
                    if (!file2.exists() || file2.delete()) {
                        if (file.renameTo(file2)) {
                            return true;
                        }
                        a(new Exception("rename failed"));
                    }
                }
            } catch (Exception e2) {
                m(e2);
            }
            return false;
        }
    }

    private void Fl() {
        try {
            String str = this.RZ;
            h.c(new File(str, this.name + ".kvc"));
            String str2 = this.RZ;
            h.c(new File(str2, this.name + ".tmp"));
        } catch (Exception e2) {
            m(e2);
        }
    }

    private void Fm() {
        this.aCo = 1;
        h.closeQuietly(this.aBW);
        h.closeQuietly(this.aBX);
        this.aBW = null;
        this.aBX = null;
        this.aCa = null;
        this.aCb = null;
    }

    private void Fn() {
        if (this.aCo == 0) {
            try {
                a(this.aCa);
                a(this.aCb);
            } catch (Throwable th) {
                Fm();
            }
        }
        Fo();
        h.c(new File(this.RZ + this.name));
    }

    private void Fo() {
        this.aCd = 12;
        this.aCe = 0L;
        Fu();
        this.aCf.clear();
        com.kwad.sdk.utils.kwai.b bVar = this.aCc;
        if (bVar == null || bVar.aBO.length != PAGE_SIZE) {
            this.aCc = new com.kwad.sdk.utils.kwai.b(PAGE_SIZE);
            return;
        }
        this.aCc.v(0, 0);
        this.aCc.d(4, 0L);
    }

    private void Fp() {
        com.kwad.sdk.utils.kwai.b bVar;
        com.kwad.sdk.utils.kwai.b bVar2 = this.aCc;
        if (bVar2 != null) {
            this.aCe ^= bVar2.x(this.aCh, this.aCi);
        }
        if (this.aCo == 0) {
            MappedByteBuffer mappedByteBuffer = this.aCa;
            if (mappedByteBuffer != null) {
                mappedByteBuffer.putInt(0, -1);
                b(this.aCa);
                this.aCa.putInt(0, this.aCd - 12);
            }
            MappedByteBuffer mappedByteBuffer2 = this.aCb;
            if (mappedByteBuffer2 != null) {
                b(mappedByteBuffer2);
            }
        } else {
            if (this.aCk && (bVar = this.aCc) != null) {
                bVar.v(0, this.aCd - 12);
            }
            com.kwad.sdk.utils.kwai.b bVar3 = this.aCc;
            if (bVar3 != null) {
                bVar3.d(4, this.aCe);
            }
        }
        this.aCk = false;
        this.aCj = 0;
        this.aCi = 0;
    }

    private int Fq() {
        int i = this.aCd;
        if (i <= 16384) {
            return 4096;
        }
        return i <= 65536 ? 8192 : 16384;
    }

    private void Fr() {
        cq(this.aCi);
        int i = this.aCd;
        this.aCh = i;
        this.aCd = this.aCi + i;
        com.kwad.sdk.utils.kwai.b bVar = this.aCc;
        if (bVar != null) {
            bVar.position = i;
        }
        this.aCk = true;
    }

    private void Fs() {
        if (this.aCm < (Fq() << 1)) {
            if (this.aCn.size() < (this.aCd < 16384 ? 80 : 160)) {
                return;
            }
        }
        cr(0);
    }

    private void Ft() {
        ArrayList<e> arrayList = this.aCn;
        if (arrayList == null) {
            return;
        }
        int size = arrayList.size() - 1;
        e eVar = this.aCn.get(size);
        while (true) {
            e eVar2 = eVar;
            if (size <= 0) {
                return;
            }
            size--;
            e eVar3 = this.aCn.get(size);
            if (eVar2.start == eVar3.end) {
                eVar3.end = eVar2.end;
                this.aCn.remove(size + 1);
            }
            eVar = eVar3;
        }
    }

    private void Fu() {
        this.aCm = 0;
        ArrayList<e> arrayList = this.aCn;
        if (arrayList != null) {
            arrayList.clear();
        }
    }

    private boolean X(File file) {
        com.kwad.sdk.utils.kwai.b bVar;
        long length = file.length();
        if (length == 0 || length > 536870912) {
            return false;
        }
        int i = (int) length;
        int y = y(PAGE_SIZE, i);
        com.kwad.sdk.utils.kwai.b bVar2 = this.aCc;
        if (bVar2 == null || bVar2.aBO.length != y) {
            bVar = new com.kwad.sdk.utils.kwai.b(new byte[y]);
            this.aCc = bVar;
        } else {
            bVar = this.aCc;
            bVar.position = 0;
        }
        h.a(file, bVar.aBO, i);
        int i2 = bVar.getInt();
        long j = bVar.getLong();
        this.aCd = i2 + 12;
        if (i2 < 0 || i2 > i - 12 || j != bVar.x(12, i2) || Fh() != 0) {
            return false;
        }
        this.aCe = j;
        return true;
    }

    private int a(String str, byte[] bArr, byte b2) {
        this.aCl = null;
        if (bArr.length < 2048) {
            return b(str, bArr, b2);
        }
        info("large value, key: " + str + ", size: " + bArr.length);
        String Fy = h.Fy();
        if (!h.a(new File(this.RZ + this.name, Fy), bArr)) {
            fc("save large value failed");
            return 0;
        }
        this.aCl = Fy;
        byte[] bArr2 = new byte[32];
        Fy.getBytes(0, 32, bArr2, 0);
        return b(str, bArr2, (byte) (b2 | 64));
    }

    private Object a(a.h hVar) {
        Exception exc;
        try {
            byte[] Z = h.Z(new File(this.RZ + this.name, (String) hVar.value));
            if (Z != null) {
                int i = Z[0] & 255;
                String str = new String(Z, 1, i, com.kwad.sdk.utils.kwai.b.UTF_8);
                b bVar = this.aBU.get(str);
                if (bVar != null) {
                    int i2 = i + 1;
                    return bVar.g(Z, i2, Z.length - i2);
                }
                exc = new Exception("No encoder for tag:" + str);
            } else {
                exc = new Exception("Read object data failed");
            }
            a(exc);
            return null;
        } catch (Exception e2) {
            m(e2);
            return null;
        }
    }

    private String a(a.i iVar) {
        byte[] bytes;
        String str = (String) iVar.value;
        try {
            byte[] Z = h.Z(new File(this.RZ + this.name, str));
            String str2 = new String(Z);
            return (Z == null || TextUtils.isEmpty(str2) || (bytes = com.kwad.sdk.utils.kwai.b.j(Z, com.kwad.sdk.utils.kwai.b.eY(str2)).getBytes()) == null || bytes.length == 0) ? "" : new String(bytes, com.kwad.sdk.utils.kwai.b.UTF_8);
        } catch (Exception e2) {
            m(e2);
            return "";
        }
    }

    private void a(byte b2, int i) {
        long d2 = this.aCe ^ d(1L, i);
        this.aCe = d2;
        if (this.aCo == 0) {
            MappedByteBuffer mappedByteBuffer = this.aCa;
            if (mappedByteBuffer != null) {
                mappedByteBuffer.putLong(4, d2);
                this.aCa.put(i, b2);
            }
            MappedByteBuffer mappedByteBuffer2 = this.aCb;
            if (mappedByteBuffer2 != null) {
                mappedByteBuffer2.putLong(4, this.aCe);
                this.aCb.put(i, b2);
            }
        } else {
            com.kwad.sdk.utils.kwai.b bVar = this.aCc;
            if (bVar != null) {
                bVar.d(4, d2);
            }
        }
        com.kwad.sdk.utils.kwai.b bVar2 = this.aCc;
        if (bVar2 != null) {
            bVar2.aBO[i] = b2;
        }
    }

    private void a(byte b2, int i, int i2) {
        z(i, i2);
        byte b3 = (byte) (b2 | Byte.MIN_VALUE);
        com.kwad.sdk.utils.kwai.b bVar = this.aCc;
        if (bVar != null && bVar.aBO != null) {
            this.aCe ^= ((this.aCc.aBO[i] ^ b3) & 255) << ((i & 7) << 3);
            this.aCc.aBO[i] = b3;
        }
        this.aCj = i;
    }

    private void a(int i, long j, int i2) {
        long d2 = d(j, i2) ^ this.aCe;
        this.aCe = d2;
        if (this.aCo == 0) {
            MappedByteBuffer mappedByteBuffer = this.aCa;
            if (mappedByteBuffer != null) {
                mappedByteBuffer.putLong(4, d2);
                this.aCa.putInt(i2, i);
            }
            MappedByteBuffer mappedByteBuffer2 = this.aCb;
            if (mappedByteBuffer2 != null) {
                mappedByteBuffer2.putLong(4, this.aCe);
                this.aCb.putInt(i2, i);
            }
        } else {
            com.kwad.sdk.utils.kwai.b bVar = this.aCc;
            if (bVar != null) {
                bVar.d(4, d2);
            }
        }
        com.kwad.sdk.utils.kwai.b bVar2 = this.aCc;
        if (bVar2 != null) {
            bVar2.v(i2, i);
        }
    }

    private void a(int i, int[] iArr) {
        Map<String, a.b> map = this.aCf;
        if (map == null) {
            return;
        }
        for (a.b bVar : map.values()) {
            if (bVar.offset > i) {
                int i2 = iArr[(h.binarySearch(iArr, bVar.offset) << 1) + 1];
                bVar.offset -= i2;
                if (bVar.Fb() >= 6) {
                    ((a.j) bVar).start -= i2;
                }
            }
        }
    }

    private void a(Exception exc) {
        d dVar = this.aBV;
        if (dVar != null) {
            dVar.a(this.name, exc);
        }
    }

    private void a(String str, byte b2) {
        a(str, b2, aBP[b2]);
    }

    private void a(String str, byte b2, int i) {
        int eY = com.kwad.sdk.utils.kwai.b.eY(str);
        cp(eY);
        this.aCi = eY + 2 + i;
        Fr();
        com.kwad.sdk.utils.kwai.b bVar = this.aCc;
        if (bVar != null) {
            bVar.b(b2);
        }
        p(str, eY);
    }

    private static void a(String str, int i, int i2, byte[] bArr, int i3) {
        int i4;
        if (i2 > str.length() || i2 < 0) {
            return;
        }
        int i5 = i3;
        int i6 = 0;
        while (true) {
            int i7 = i6;
            if (i7 >= i2) {
                return;
            }
            char charAt = str.charAt(i7);
            if (charAt < 128) {
                i4 = i5 + 1;
                bArr[i5] = (byte) (((byte) charAt) ^ 1);
            } else {
                i4 = i5 + 1;
                bArr[i5] = (byte) charAt;
            }
            i5 = i4;
            i6 = i7 + 1;
        }
    }

    private <T> void a(String str, T t, b<T> bVar) {
        byte[] bArr;
        synchronized (this) {
            fb(str);
            if (bVar == null) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Encoder is null");
                if (com.kwad.a.a.bI.booleanValue()) {
                    throw illegalArgumentException;
                }
                m(illegalArgumentException);
                return;
            }
            String Fw = bVar.Fw();
            if (!Fw.isEmpty() && Fw.length() <= 50) {
                if (!this.aBU.containsKey(Fw)) {
                    IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException("Encoder hasn't been registered");
                    if (com.kwad.a.a.bI.booleanValue()) {
                        throw illegalArgumentException2;
                    }
                    m(illegalArgumentException2);
                    return;
                } else if (t == null) {
                    remove(str);
                    return;
                } else {
                    try {
                        bArr = bVar.j(t);
                    } catch (Exception e2) {
                        m(e2);
                        bArr = null;
                    }
                    if (bArr == null) {
                        remove(str);
                        return;
                    }
                    int eY = com.kwad.sdk.utils.kwai.b.eY(Fw);
                    com.kwad.sdk.utils.kwai.b bVar2 = new com.kwad.sdk.utils.kwai.b(eY + 1 + bArr.length);
                    bVar2.b((byte) eY);
                    bVar2.eX(Fw);
                    bVar2.n(bArr);
                    a(str, t, bVar2.aBO, (a.h) this.aCf.get(str), (byte) 8);
                    return;
                }
            }
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("Invalid encoder tag:" + Fw);
            if (com.kwad.a.a.bI.booleanValue()) {
                throw illegalArgumentException3;
            }
            m(illegalArgumentException3);
        }
    }

    private void a(String str, Object obj, byte[] bArr, byte b2) {
        int length;
        int a2 = a(str, bArr, b2);
        if (a2 != 0) {
            boolean z = this.aCl != null;
            if (z) {
                obj = this.aCl;
                this.aCl = null;
                length = 32;
            } else {
                length = bArr.length;
            }
            this.aCf.put(str, b2 == 6 ? new a.i(this.aCh, a2, (String) obj, length, z) : b2 == 7 ? new a.C0580a(this.aCh, a2, obj, length, z) : new a.h(this.aCh, a2, obj, length, z));
            Fp();
        }
    }

    private void a(String str, Object obj, byte[] bArr, a.j jVar) {
        int a2 = a(str, bArr, jVar.Fb());
        if (a2 != 0) {
            String str2 = jVar.aBM ? (String) jVar.value : null;
            a(jVar.Fb(), jVar.start, jVar.offset + jVar.aBL);
            boolean z = this.aCl != null;
            jVar.start = this.aCh;
            jVar.offset = a2;
            jVar.aBM = z;
            if (z) {
                jVar.value = this.aCl;
                jVar.aBL = 32;
                this.aCl = null;
            } else {
                jVar.value = obj;
                jVar.aBL = bArr.length;
            }
            Fp();
            Fs();
            if (str2 != null) {
                h.c(new File(this.RZ + this.name, str2));
            }
        }
    }

    private void a(String str, Object obj, byte[] bArr, a.j jVar, byte b2) {
        if (jVar == null) {
            a(str, obj, bArr, b2);
        } else if (jVar.aBM || jVar.aBL != bArr.length) {
            a(str, obj, bArr, jVar);
        } else {
            updateBytes(jVar.offset, bArr);
            jVar.value = obj;
        }
        Fi();
    }

    private void a(String str, String str2, a.i iVar) {
        int eY = com.kwad.sdk.utils.kwai.b.eY(str2);
        if (iVar == null) {
            int eY2 = com.kwad.sdk.utils.kwai.b.eY(str);
            cp(eY2);
            int i = eY2 + 4;
            this.aCi = i + eY;
            Fr();
            com.kwad.sdk.utils.kwai.b bVar = this.aCc;
            if (bVar != null) {
                bVar.b((byte) 6);
            }
            p(str, eY2);
            q(str2, eY);
            Map<String, a.b> map = this.aCf;
            int i2 = this.aCh;
            map.put(str, new a.i(i2, i2 + i, str2, eY, false));
            Fp();
        } else {
            String str3 = null;
            int i3 = iVar.offset - iVar.start;
            boolean z = true;
            if (iVar.aBL == eY) {
                this.aCe ^= this.aCc.x(iVar.offset, iVar.aBL);
                if (eY == str2.length()) {
                    a(str2, 0, eY, this.aCc.aBO, iVar.offset);
                } else {
                    com.kwad.sdk.utils.kwai.b bVar2 = this.aCc;
                    if (bVar2 != null) {
                        bVar2.position = iVar.offset;
                        this.aCc.eX(str2);
                    }
                }
                this.aCh = iVar.offset;
                this.aCi = eY;
                z = false;
                str3 = null;
            } else {
                this.aCi = i3 + eY;
                Fr();
                com.kwad.sdk.utils.kwai.b bVar3 = this.aCc;
                if (bVar3 != null) {
                    bVar3.b((byte) 6);
                }
                int i4 = i3 - 3;
                com.kwad.sdk.utils.kwai.b bVar4 = this.aCc;
                if (bVar4 != null) {
                    System.arraycopy((Object) bVar4.aBO, iVar.start + 1, (Object) this.aCc.aBO, this.aCc.position, i4);
                }
                com.kwad.sdk.utils.kwai.b bVar5 = this.aCc;
                if (bVar5 != null) {
                    bVar5.position += i4;
                }
                q(str2, eY);
                a((byte) 6, iVar.start, iVar.offset + iVar.aBL);
                if (iVar.aBM) {
                    str3 = (String) iVar.value;
                }
                iVar.aBM = false;
                iVar.start = this.aCh;
                iVar.offset = this.aCh + i3;
                iVar.aBL = eY;
            }
            iVar.value = str2;
            Fp();
            if (z) {
                Fs();
            }
            if (str3 != null) {
                h.c(new File(this.RZ + this.name, str3));
            }
        }
        Fi();
    }

    private void a(MappedByteBuffer mappedByteBuffer) {
        if (mappedByteBuffer == null) {
            return;
        }
        MappedByteBuffer mappedByteBuffer2 = mappedByteBuffer;
        if (mappedByteBuffer.capacity() != PAGE_SIZE) {
            FileChannel fileChannel = mappedByteBuffer == this.aCa ? this.aBW : this.aBX;
            if (fileChannel == null) {
                return;
            }
            fileChannel.truncate(PAGE_SIZE);
            mappedByteBuffer2 = fileChannel.map(FileChannel.MapMode.READ_WRITE, 0L, PAGE_SIZE);
            mappedByteBuffer2.order(ByteOrder.LITTLE_ENDIAN);
            if (mappedByteBuffer == this.aCa) {
                this.aCa = mappedByteBuffer2;
            } else {
                this.aCb = mappedByteBuffer2;
            }
        }
        mappedByteBuffer2.putInt(0, 0);
        mappedByteBuffer2.putLong(4, 0L);
    }

    private void a(MappedByteBuffer mappedByteBuffer, MappedByteBuffer mappedByteBuffer2, int i) {
        MappedByteBuffer mappedByteBuffer3 = mappedByteBuffer2;
        if (mappedByteBuffer.capacity() != mappedByteBuffer2.capacity()) {
            try {
                mappedByteBuffer3 = (mappedByteBuffer2 == this.aCb ? this.aBX : this.aBW).map(FileChannel.MapMode.READ_WRITE, 0L, mappedByteBuffer.capacity());
                mappedByteBuffer3.order(ByteOrder.LITTLE_ENDIAN);
                if (mappedByteBuffer2 == this.aCb) {
                    this.aCb = mappedByteBuffer3;
                } else {
                    this.aCa = mappedByteBuffer3;
                }
            } catch (Exception e2) {
                m(e2);
                Fm();
                return;
            }
        }
        mappedByteBuffer.rewind();
        mappedByteBuffer3.rewind();
        mappedByteBuffer.limit(i);
        mappedByteBuffer3.put(mappedByteBuffer);
        mappedByteBuffer.limit(mappedByteBuffer.capacity());
    }

    private void a(Map<String, Object> map, Map<Class, b> map2) {
        synchronized (this) {
            if (map == null) {
                return;
            }
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                if (key != null && !key.isEmpty()) {
                    if (value instanceof String) {
                        putString(key, (String) value);
                    } else if (value instanceof Boolean) {
                        putBoolean(key, ((Boolean) value).booleanValue());
                    } else if (value instanceof Integer) {
                        putInt(key, ((Integer) value).intValue());
                    } else if (value instanceof Long) {
                        putLong(key, ((Long) value).longValue());
                    } else if (value instanceof Float) {
                        putFloat(key, ((Float) value).floatValue());
                    } else if (value instanceof Double) {
                        putDouble(key, ((Double) value).doubleValue());
                    } else if (value instanceof Set) {
                        Set set = (Set) value;
                        if (!set.isEmpty() && (set.iterator().next() instanceof String)) {
                            putStringSet(key, (Set) value);
                        }
                    } else if (value instanceof byte[]) {
                        b(key, (byte[]) value);
                    } else {
                        a(new Exception("missing encoders"));
                    }
                }
            }
        }
    }

    private boolean a(com.kwad.sdk.utils.kwai.b bVar) {
        int length = bVar.aBO.length;
        File file = new File(this.RZ, this.name + ".kva");
        File file2 = new File(this.RZ, this.name + ".kvb");
        try {
            if (h.Y(file) && h.Y(file2)) {
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                RandomAccessFile randomAccessFile2 = new RandomAccessFile(file2, "rw");
                long j = length;
                randomAccessFile.setLength(j);
                randomAccessFile2.setLength(j);
                this.aBW = randomAccessFile.getChannel();
                this.aBX = randomAccessFile2.getChannel();
                MappedByteBuffer map = this.aBW.map(FileChannel.MapMode.READ_WRITE, 0L, j);
                this.aCa = map;
                map.order(ByteOrder.LITTLE_ENDIAN);
                MappedByteBuffer map2 = this.aBX.map(FileChannel.MapMode.READ_WRITE, 0L, j);
                this.aCb = map2;
                map2.order(ByteOrder.LITTLE_ENDIAN);
                this.aCa.put(bVar.aBO, 0, this.aCd);
                this.aCb.put(bVar.aBO, 0, this.aCd);
                return true;
            }
            throw new Exception("open file failed");
        } catch (Exception e2) {
            m(e2);
            return false;
        }
    }

    private byte[] a(a.C0580a c0580a) {
        try {
            byte[] Z = h.Z(new File(this.RZ + this.name, (String) c0580a.value));
            return Z != null ? Z : aBQ;
        } catch (Exception e2) {
            m(e2);
            return aBQ;
        }
    }

    private int b(String str, byte[] bArr, byte b2) {
        a(str, b2, bArr.length + 2);
        com.kwad.sdk.utils.kwai.b bVar = this.aCc;
        if (bVar != null) {
            bVar.a((short) bArr.length);
            int i = this.aCc.position;
            this.aCc.n(bArr);
            return i;
        }
        return 0;
    }

    private void b(long j, long j2, int i) {
        long d2 = d(j2, i) ^ this.aCe;
        this.aCe = d2;
        if (this.aCo == 0) {
            MappedByteBuffer mappedByteBuffer = this.aCa;
            if (mappedByteBuffer != null) {
                mappedByteBuffer.putLong(4, d2);
                this.aCa.putLong(i, j);
            }
            MappedByteBuffer mappedByteBuffer2 = this.aCb;
            if (mappedByteBuffer2 != null) {
                mappedByteBuffer2.putLong(4, this.aCe);
                this.aCb.putLong(i, j);
            }
        } else {
            com.kwad.sdk.utils.kwai.b bVar = this.aCc;
            if (bVar != null) {
                bVar.d(4, d2);
            }
        }
        com.kwad.sdk.utils.kwai.b bVar2 = this.aCc;
        if (bVar2 != null) {
            bVar2.d(i, j);
        }
    }

    private void b(String str, byte[] bArr) {
        synchronized (this) {
            fb(str);
            if (bArr == null) {
                remove(str);
            } else {
                a(str, bArr, bArr, (a.C0580a) this.aCf.get(str), (byte) 7);
            }
        }
    }

    private void b(MappedByteBuffer mappedByteBuffer) {
        if (mappedByteBuffer == null) {
            return;
        }
        if (this.aCk && mappedByteBuffer != this.aCa) {
            mappedByteBuffer.putInt(0, this.aCd - 12);
        }
        mappedByteBuffer.putLong(4, this.aCe);
        int i = this.aCj;
        if (i != 0) {
            mappedByteBuffer.put(i, this.aCc.aBO[this.aCj]);
        }
        if (this.aCi != 0) {
            mappedByteBuffer.position(this.aCh);
            mappedByteBuffer.put(this.aCc.aBO, this.aCh, this.aCi);
        }
    }

    private static void cp(int i) {
        if (i > 255) {
            throw new IllegalArgumentException("key's length must less than 256");
        }
    }

    private void cq(int i) {
        if (this.aCc == null) {
            this.aCc = new com.kwad.sdk.utils.kwai.b(PAGE_SIZE);
        }
        int length = this.aCc.aBO.length;
        int i2 = this.aCd + i;
        if (i2 >= length) {
            int i3 = this.aCm;
            if (i3 > i && i3 > Fq()) {
                cr(i);
                return;
            }
            int y = y(length, i2);
            byte[] bArr = new byte[y];
            System.arraycopy((Object) this.aCc.aBO, 0, (Object) bArr, 0, this.aCd);
            this.aCc.aBO = bArr;
            if (this.aCo == 0) {
                try {
                    long j = y;
                    MappedByteBuffer map = this.aBW.map(FileChannel.MapMode.READ_WRITE, 0L, j);
                    this.aCa = map;
                    map.order(ByteOrder.LITTLE_ENDIAN);
                    MappedByteBuffer map2 = this.aBX.map(FileChannel.MapMode.READ_WRITE, 0L, j);
                    this.aCb = map2;
                    map2.order(ByteOrder.LITTLE_ENDIAN);
                } catch (Throwable th) {
                    m(new Exception("map failed", th));
                    this.aCc.v(0, this.aCd - 12);
                    this.aCc.d(4, this.aCe);
                    Fm();
                }
            }
        }
    }

    private void cr(int i) {
        ArrayList<e> arrayList = this.aCn;
        if (arrayList == null || this.aCc == null) {
            return;
        }
        Collections.sort(arrayList);
        Ft();
        e eVar = this.aCn.get(0);
        int i2 = eVar.start;
        int i3 = this.aCd;
        int i4 = i3 - this.aCm;
        int i5 = i4 - 12;
        int i6 = i4 - i2;
        int i7 = i3 - i2;
        boolean z = i5 < i7 + i6;
        if (!z) {
            this.aCe ^= this.aCc.x(i2, i7);
        }
        int size = this.aCn.size();
        int i8 = size - 1;
        int i9 = this.aCd - this.aCn.get(i8).end;
        int[] iArr = new int[(i9 > 0 ? size : i8) << 1];
        int i10 = eVar.start;
        int i11 = eVar.end;
        for (int i12 = 1; i12 < size; i12++) {
            e eVar2 = this.aCn.get(i12);
            int i13 = eVar2.start - i11;
            System.arraycopy((Object) this.aCc.aBO, i11, (Object) this.aCc.aBO, i10, i13);
            int i14 = (i12 - 1) << 1;
            iArr[i14] = i11;
            iArr[i14 + 1] = i11 - i10;
            i10 += i13;
            i11 = eVar2.end;
        }
        if (i9 > 0) {
            System.arraycopy((Object) this.aCc.aBO, i11, (Object) this.aCc.aBO, i10, i9);
            int i15 = i8 << 1;
            iArr[i15] = i11;
            iArr[i15 + 1] = i11 - i10;
        }
        Fu();
        this.aCe = z ? this.aCc.x(12, i5) : this.aCe ^ this.aCc.x(i2, i6);
        this.aCd = i4;
        if (this.aCo == 0) {
            MappedByteBuffer mappedByteBuffer = this.aCa;
            if (mappedByteBuffer != null) {
                mappedByteBuffer.putInt(0, -1);
                this.aCa.putLong(4, this.aCe);
                this.aCa.position(i2);
                this.aCa.put(this.aCc.aBO, i2, i6);
                this.aCa.putInt(0, i5);
            }
            MappedByteBuffer mappedByteBuffer2 = this.aCb;
            if (mappedByteBuffer2 != null) {
                mappedByteBuffer2.putInt(0, i5);
                this.aCb.putLong(4, this.aCe);
                this.aCb.position(i2);
                this.aCb.put(this.aCc.aBO, i2, i6);
            }
        } else {
            this.aCc.v(0, i5);
            this.aCc.d(4, this.aCe);
        }
        a(i2, iArr);
        int i16 = i4 + i;
        if (this.aCc.aBO.length - i16 > aBT) {
            cs(i16);
        }
        info("gc finish");
    }

    private void cs(int i) {
        int i2 = PAGE_SIZE;
        int y = y(i2, i + i2);
        com.kwad.sdk.utils.kwai.b bVar = this.aCc;
        if (bVar != null) {
            if (y >= bVar.aBO.length) {
                return;
            }
            byte[] bArr = new byte[y];
            System.arraycopy((Object) this.aCc.aBO, 0, (Object) bArr, 0, this.aCd);
            this.aCc.aBO = bArr;
        }
        if (this.aCo == 0) {
            try {
                long j = y;
                this.aBW.truncate(j);
                MappedByteBuffer map = this.aBW.map(FileChannel.MapMode.READ_WRITE, 0L, j);
                this.aCa = map;
                map.order(ByteOrder.LITTLE_ENDIAN);
                this.aBX.truncate(j);
                MappedByteBuffer map2 = this.aBX.map(FileChannel.MapMode.READ_WRITE, 0L, j);
                this.aCb = map2;
                map2.order(ByteOrder.LITTLE_ENDIAN);
            } catch (Throwable th) {
                m(new Exception("map failed", th));
                Fm();
            }
        }
        info("truncate finish");
    }

    private static long d(long j, int i) {
        int i2 = (i & 7) << 3;
        return (j >>> (64 - i2)) | (j << i2);
    }

    private static void d(int i, boolean z) {
        if (z) {
            if (i != 32) {
                throw new IllegalStateException("name size not match");
            }
        } else if (i < 0 || i >= 2048) {
            throw new IllegalStateException("value size out of bound");
        }
    }

    private void f(File file, File file2) {
        try {
            if (X(file)) {
                return;
            }
        } catch (IOException e2) {
            a(e2);
        }
        Fo();
        try {
            if (X(file2)) {
                return;
            }
        } catch (Exception e3) {
            a(e3);
        }
        Fo();
    }

    private static void fb(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("key is empty");
        }
    }

    private void fc(String str) {
        d dVar = this.aBV;
        if (dVar != null) {
            dVar.e(this.name, new Exception(str));
        }
    }

    private void info(String str) {
        d dVar = this.aBV;
        if (dVar != null) {
            dVar.i(this.name, str);
        }
    }

    private void m(Throwable th) {
        d dVar = this.aBV;
        if (dVar != null) {
            dVar.e(this.name, th);
        }
    }

    private void p(String str, int i) {
        com.kwad.sdk.utils.kwai.b bVar = this.aCc;
        if (bVar == null) {
            return;
        }
        bVar.b((byte) i);
        if (i != str.length()) {
            this.aCc.eX(str);
            return;
        }
        a(str, 0, i, this.aCc.aBO, this.aCc.position);
        this.aCc.position += i;
    }

    private void putDouble(String str, double d2) {
        synchronized (this) {
            fb(str);
            a.d dVar = (a.d) this.aCf.get(str);
            if (dVar != null) {
                if (dVar.value != d2) {
                    long doubleToRawLongBits = Double.doubleToRawLongBits(d2);
                    long doubleToRawLongBits2 = Double.doubleToRawLongBits(dVar.value);
                    dVar.value = d2;
                    b(doubleToRawLongBits, doubleToRawLongBits2 ^ doubleToRawLongBits, dVar.offset);
                    Fi();
                }
                return;
            }
            a(str, (byte) 5);
            if (this.aCc != null) {
                int i = this.aCc.position;
                this.aCc.ai(Double.doubleToRawLongBits(d2));
                Fp();
                if (this.aCf != null) {
                    this.aCf.put(str, new a.d(i, d2));
                }
            }
            Fi();
        }
    }

    private void putFloat(String str, float f) {
        synchronized (this) {
            fb(str);
            a.e eVar = (a.e) this.aCf.get(str);
            if (eVar != null) {
                if (eVar.value != f) {
                    int floatToRawIntBits = Float.floatToRawIntBits(f);
                    eVar.value = f;
                    a(floatToRawIntBits, (Float.floatToRawIntBits(eVar.value) ^ floatToRawIntBits) & ExpandableListView.PACKED_POSITION_VALUE_NULL, eVar.offset);
                    Fi();
                }
                return;
            }
            a(str, (byte) 3);
            if (this.aCc != null) {
                int i = this.aCc.position;
                this.aCc.ci(Float.floatToRawIntBits(f));
                Fp();
                if (this.aCf != null) {
                    this.aCf.put(str, new a.e(i, f));
                }
            }
            Fi();
        }
    }

    private void putStringSet(String str, Set<String> set) {
        synchronized (this) {
            if (set == null) {
                remove(str);
            } else {
                a(str, (String) set, (b<String>) g.aCH);
            }
        }
    }

    private void q(String str, int i) {
        com.kwad.sdk.utils.kwai.b bVar = this.aCc;
        if (bVar == null) {
            return;
        }
        bVar.a((short) i);
        if (i == str.length()) {
            a(str, 0, i, this.aCc.aBO, this.aCc.position);
        } else {
            this.aCc.eX(str);
        }
    }

    private void updateBytes(int i, byte[] bArr) {
        int length = bArr.length;
        com.kwad.sdk.utils.kwai.b bVar = this.aCc;
        if (bVar != null) {
            this.aCe ^= bVar.x(i, length);
            this.aCc.position = i;
            this.aCc.n(bArr);
            this.aCe ^= this.aCc.x(i, length);
        }
        if (this.aCo != 0) {
            com.kwad.sdk.utils.kwai.b bVar2 = this.aCc;
            if (bVar2 != null) {
                bVar2.d(4, this.aCe);
                return;
            }
            return;
        }
        MappedByteBuffer mappedByteBuffer = this.aCa;
        if (mappedByteBuffer != null) {
            mappedByteBuffer.putInt(0, -1);
            this.aCa.putLong(4, this.aCe);
            this.aCa.position(i);
            this.aCa.put(bArr);
            this.aCa.putInt(0, this.aCd - 12);
        }
        MappedByteBuffer mappedByteBuffer2 = this.aCb;
        if (mappedByteBuffer2 != null) {
            mappedByteBuffer2.putLong(4, this.aCe);
            this.aCb.position(i);
            this.aCb.put(bArr);
        }
    }

    private int y(int i, int i2) {
        if (i2 > 536870912) {
            IllegalStateException illegalStateException = new IllegalStateException("data size out of limit");
            if (com.kwad.a.a.bI.booleanValue()) {
                throw illegalStateException;
            }
            m(illegalStateException);
        }
        int i3 = PAGE_SIZE;
        if (i2 <= i3) {
            return i3;
        }
        while (i < i2) {
            int i4 = aBS;
            i = i <= i4 ? i << 1 : i + i4;
        }
        return i;
    }

    private void z(int i, int i2) {
        this.aCm += i2 - i;
        ArrayList<e> arrayList = this.aCn;
        if (arrayList != null) {
            arrayList.add(new e(i, i2));
        }
    }

    public final boolean contains(String str) {
        boolean containsKey;
        synchronized (this) {
            containsKey = this.aCf.containsKey(str);
        }
        return containsKey;
    }

    public final Map<String, Object> getAll() {
        synchronized (this) {
            int size = this.aCf.size();
            if (size == 0) {
                return new HashMap();
            }
            HashMap hashMap = new HashMap(((size * 4) / 3) + 1);
            for (Map.Entry<String, a.b> entry : this.aCf.entrySet()) {
                String key = entry.getKey();
                a.b value = entry.getValue();
                byte[] bArr = null;
                switch (value.Fb()) {
                    case 1:
                        bArr = Boolean.valueOf(((a.c) value).value);
                        break;
                    case 2:
                        bArr = Integer.valueOf(((a.f) value).value);
                        break;
                    case 3:
                        bArr = Float.valueOf(((a.e) value).value);
                        break;
                    case 4:
                        bArr = Long.valueOf(((a.g) value).value);
                        break;
                    case 5:
                        bArr = Double.valueOf(((a.d) value).value);
                        break;
                    case 6:
                        a.i iVar = (a.i) value;
                        if (iVar.aBM) {
                            bArr = a(iVar);
                            break;
                        } else {
                            bArr = iVar.value;
                            break;
                        }
                    case 7:
                        a.C0580a c0580a = (a.C0580a) value;
                        if (c0580a.aBM) {
                            bArr = a(c0580a);
                            break;
                        } else {
                            bArr = c0580a.value;
                            break;
                        }
                    case 8:
                        a.h hVar = (a.h) value;
                        if (hVar.aBM) {
                            bArr = a(hVar);
                            break;
                        } else {
                            bArr = ((a.h) value).value;
                            break;
                        }
                }
                hashMap.put(key, bArr);
            }
            return hashMap;
        }
    }

    public final boolean getBoolean(String str, boolean z) {
        synchronized (this) {
            a.c cVar = (a.c) this.aCf.get(str);
            if (cVar == null) {
                return z;
            }
            return cVar.value;
        }
    }

    public final int getInt(String str, int i) {
        synchronized (this) {
            a.f fVar = (a.f) this.aCf.get(str);
            if (fVar == null) {
                return i;
            }
            return fVar.value;
        }
    }

    public final long getLong(String str, long j) {
        synchronized (this) {
            a.g gVar = (a.g) this.aCf.get(str);
            if (gVar == null) {
                return j;
            }
            return gVar.value;
        }
    }

    public final String getString(String str, String str2) {
        synchronized (this) {
            a.i iVar = (a.i) this.aCf.get(str);
            if (iVar != null) {
                if (iVar.aBM) {
                    return a(iVar);
                }
                return (String) iVar.value;
            }
            return str2;
        }
    }

    public final void putAll(Map<String, Object> map) {
        a(map, (Map<Class, b>) null);
    }

    public final void putBoolean(String str, boolean z) {
        synchronized (this) {
            fb(str);
            a.c cVar = (a.c) this.aCf.get(str);
            int i = 0;
            if (cVar != null) {
                if (cVar.value != z) {
                    cVar.value = z;
                    int i2 = 0;
                    if (z) {
                        i2 = 1;
                    }
                    a((byte) i2, cVar.offset);
                    Fi();
                }
                return;
            }
            a(str, (byte) 1);
            if (this.aCc != null) {
                int i3 = this.aCc.position;
                com.kwad.sdk.utils.kwai.b bVar = this.aCc;
                if (z) {
                    i = 1;
                }
                bVar.b((byte) i);
                Fp();
                if (this.aCf != null) {
                    this.aCf.put(str, new a.c(i3, z));
                }
            }
            Fi();
        }
    }

    public final void putInt(String str, int i) {
        synchronized (this) {
            fb(str);
            a.f fVar = (a.f) this.aCf.get(str);
            if (fVar != null) {
                if (fVar.value != i) {
                    fVar.value = i;
                    a(i, (fVar.value ^ i) & ExpandableListView.PACKED_POSITION_VALUE_NULL, fVar.offset);
                    Fi();
                }
                return;
            }
            a(str, (byte) 2);
            if (this.aCc != null) {
                int i2 = this.aCc.position;
                this.aCc.ci(i);
                Fp();
                if (this.aCf != null) {
                    this.aCf.put(str, new a.f(i2, i));
                }
            }
            Fi();
        }
    }

    public final void putLong(String str, long j) {
        synchronized (this) {
            fb(str);
            a.g gVar = (a.g) this.aCf.get(str);
            if (gVar != null) {
                if (gVar.value != j) {
                    long j2 = gVar.value;
                    gVar.value = j;
                    b(j, j ^ j2, gVar.offset);
                    Fi();
                }
                return;
            }
            a(str, (byte) 4);
            if (this.aCc != null) {
                int i = this.aCc.position;
                this.aCc.ai(j);
                Fp();
                if (this.aCf != null) {
                    this.aCf.put(str, new a.g(i, j));
                }
            }
            Fi();
        }
    }

    public final void putString(String str, String str2) {
        byte[] bArr;
        synchronized (this) {
            fb(str);
            if (str2 == null) {
                remove(str);
                return;
            }
            a.i iVar = (a.i) this.aCf.get(str);
            if (str2.length() * 3 < 2048) {
                a(str, str2, iVar);
                return;
            }
            if (str2.isEmpty()) {
                bArr = aBQ;
            } else if (iVar != null || str2.length() >= 2048) {
                if (iVar != null && !iVar.aBM) {
                    int eY = com.kwad.sdk.utils.kwai.b.eY(str2);
                    bArr = new byte[eY];
                    if (eY == str2.length()) {
                        a(str2, 0, eY, bArr, 0);
                    }
                }
                bArr = com.kwad.sdk.utils.kwai.b.fa(str2);
            } else {
                int eY2 = com.kwad.sdk.utils.kwai.b.eY(str2);
                bArr = new byte[eY2];
                if (eY2 == str2.length()) {
                    a(str2, 0, eY2, bArr, 0);
                }
                bArr = com.kwad.sdk.utils.kwai.b.fa(str2);
            }
            a(str, str2, bArr, iVar, (byte) 6);
        }
    }

    public final void release() {
        h.closeQuietly(this.aBY);
        h.closeQuietly(this.aBZ);
        h.closeQuietly(this.aBW);
        h.closeQuietly(this.aBX);
        this.aBW = null;
        this.aBX = null;
        this.aCa = null;
        this.aCb = null;
        C0581c c0581c = a.aCt;
        C0581c.remove(this.RZ + this.name);
    }

    public final void remove(String str) {
        String str2;
        synchronized (this) {
            a.b bVar = this.aCf.get(str);
            if (bVar != null) {
                this.aCf.remove(str);
                byte Fb = bVar.Fb();
                if (Fb <= 5) {
                    a(Fb, bVar.offset - (com.kwad.sdk.utils.kwai.b.eY(str) + 2), bVar.offset + aBP[Fb]);
                    str2 = null;
                } else {
                    a.j jVar = (a.j) bVar;
                    a(Fb, jVar.start, jVar.offset + jVar.aBL);
                    str2 = null;
                    if (jVar.aBM) {
                        str2 = (String) jVar.value;
                    }
                }
                byte b2 = (byte) (Fb | Byte.MIN_VALUE);
                if (this.aCo == 0) {
                    if (this.aCa != null) {
                        this.aCa.putLong(4, this.aCe);
                        this.aCa.put(this.aCj, b2);
                    }
                    if (this.aCb != null) {
                        this.aCb.putLong(4, this.aCe);
                        this.aCb.put(this.aCj, b2);
                    }
                } else if (this.aCc != null) {
                    this.aCc.d(4, this.aCe);
                }
                this.aCj = 0;
                if (str2 != null) {
                    h.c(new File(this.RZ + this.name, str2));
                }
                Fs();
                Fi();
            }
        }
    }

    public final String toString() {
        String str;
        synchronized (this) {
            str = "FastKV: path:" + this.RZ + " name:" + this.name;
        }
        return str;
    }
}
