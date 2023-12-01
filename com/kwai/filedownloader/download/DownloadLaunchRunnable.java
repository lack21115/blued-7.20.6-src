package com.kwai.filedownloader.download;

import com.kwad.sdk.crash.utils.h;
import com.kwai.filedownloader.download.c;
import com.kwai.filedownloader.download.e;
import com.kwai.filedownloader.exception.FileDownloadGiveUpRetryException;
import com.kwai.filedownloader.exception.FileDownloadHttpException;
import com.kwai.filedownloader.exception.FileDownloadNetworkPolicyException;
import com.kwai.filedownloader.exception.FileDownloadOutOfSpaceException;
import com.kwai.filedownloader.y;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: source-7994992-dex2jar.jar:com/kwai/filedownloader/download/DownloadLaunchRunnable.class */
public final class DownloadLaunchRunnable implements f, Runnable {
    private static final ThreadPoolExecutor aHq = com.kwai.filedownloader.e.b.fy("ConnectionBlock");
    private long aHA;
    private long aHB;
    private final com.kwai.filedownloader.a.a aHa;
    private final d aHd;
    private final int aHe;
    private final com.kwai.filedownloader.c.c aHf;
    private final com.kwai.filedownloader.c.b aHg;
    private final boolean aHh;
    private final boolean aHi;
    private final y aHj;
    private boolean aHk;
    int aHl;
    private final boolean aHm;
    private final ArrayList<c> aHn;
    private e aHo;
    private boolean aHp;
    private boolean aHr;
    private boolean aHs;
    private boolean aHt;
    private final AtomicBoolean aHu;
    private volatile boolean aHv;
    private volatile Exception aHw;
    private String aHx;
    private long aHy;
    private long aHz;
    private volatile boolean lh;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7994992-dex2jar.jar:com/kwai/filedownloader/download/DownloadLaunchRunnable$DiscardSafely.class */
    public class DiscardSafely extends Throwable {
        private static final long serialVersionUID = 4243896780616180062L;

        DiscardSafely() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7994992-dex2jar.jar:com/kwai/filedownloader/download/DownloadLaunchRunnable$RetryDirectly.class */
    public class RetryDirectly extends Throwable {
        private static final long serialVersionUID = -4127585119566978768L;

        RetryDirectly() {
        }
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwai/filedownloader/download/DownloadLaunchRunnable$a.class */
    public static final class a {
        private com.kwai.filedownloader.c.b aGM;
        private Integer aHC;
        private Integer aHD;
        private Boolean aHE;
        private Boolean aHF;
        private Integer aHG;
        private com.kwai.filedownloader.c.c aHf;
        private y aHj;

        public final DownloadLaunchRunnable HU() {
            y yVar;
            Integer num;
            com.kwai.filedownloader.c.c cVar = this.aHf;
            if (cVar == null || (yVar = this.aHj) == null || (num = this.aHC) == null || this.aHD == null || this.aHE == null || this.aHF == null || this.aHG == null) {
                throw new IllegalArgumentException();
            }
            return new DownloadLaunchRunnable(cVar, this.aGM, yVar, num.intValue(), this.aHD.intValue(), this.aHE.booleanValue(), this.aHF.booleanValue(), this.aHG.intValue(), (byte) 0);
        }

        public final a a(y yVar) {
            this.aHj = yVar;
            return this;
        }

        public final a a(Integer num) {
            this.aHC = num;
            return this;
        }

        public final a b(com.kwai.filedownloader.c.b bVar) {
            this.aGM = bVar;
            return this;
        }

        public final a b(Boolean bool) {
            this.aHE = bool;
            return this;
        }

        public final a b(Integer num) {
            this.aHD = num;
            return this;
        }

        public final a c(Boolean bool) {
            this.aHF = bool;
            return this;
        }

        public final a c(Integer num) {
            this.aHG = num;
            return this;
        }

        public final a e(com.kwai.filedownloader.c.c cVar) {
            this.aHf = cVar;
            return this;
        }
    }

    private DownloadLaunchRunnable(com.kwai.filedownloader.c.c cVar, com.kwai.filedownloader.c.b bVar, y yVar, int i, int i2, boolean z, boolean z2, int i3) {
        this.aHe = 5;
        this.aHn = new ArrayList<>(5);
        this.aHy = 0L;
        this.aHz = 0L;
        this.aHA = 0L;
        this.aHB = 0L;
        this.aHu = new AtomicBoolean(true);
        this.lh = false;
        this.aHk = false;
        this.aHf = cVar;
        this.aHg = bVar;
        this.aHh = z;
        this.aHi = z2;
        this.aHa = b.HF().HH();
        this.aHm = b.HF().HJ();
        this.aHj = yVar;
        this.aHl = i3;
        this.aHd = new d(cVar, i3, i, i2);
    }

    /* synthetic */ DownloadLaunchRunnable(com.kwai.filedownloader.c.c cVar, com.kwai.filedownloader.c.b bVar, y yVar, int i, int i2, boolean z, boolean z2, int i3, byte b) {
        this(cVar, bVar, yVar, i, i2, z, z2, i3);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00a1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.kwai.filedownloader.download.a G(java.util.List<com.kwai.filedownloader.c.a> r14) {
        /*
            r13 = this;
            r0 = r13
            com.kwai.filedownloader.c.c r0 = r0.aHf
            int r0 = r0.ID()
            r16 = r0
            r0 = r13
            com.kwai.filedownloader.c.c r0 = r0.aHf
            java.lang.String r0 = r0.HT()
            r20 = r0
            r0 = r13
            com.kwai.filedownloader.c.c r0 = r0.aHf
            java.lang.String r0 = r0.getTargetFilePath()
            r21 = r0
            r0 = 0
            r17 = r0
            r0 = r16
            r1 = 1
            if (r0 <= r1) goto L27
            r0 = 1
            r15 = r0
            goto L29
        L27:
            r0 = 0
            r15 = r0
        L29:
            r0 = r15
            if (r0 == 0) goto L34
            r0 = r13
            boolean r0 = r0.aHm
            if (r0 == 0) goto L80
        L34:
            r0 = r13
            com.kwai.filedownloader.c.c r0 = r0.aHf
            int r0 = r0.getId()
            r1 = r13
            com.kwai.filedownloader.c.c r1 = r1.aHf
            boolean r0 = com.kwai.filedownloader.e.f.b(r0, r1)
            if (r0 == 0) goto L80
            r0 = r13
            boolean r0 = r0.aHm
            if (r0 != 0) goto L5d
            java.io.File r0 = new java.io.File
            r1 = r0
            r2 = r20
            r1.<init>(r2)
            long r0 = r0.length()
            r18 = r0
        L5a:
            goto L83
        L5d:
            r0 = r15
            if (r0 == 0) goto L74
            r0 = r16
            r1 = r14
            int r1 = r1.size()
            if (r0 != r1) goto L80
            r0 = r14
            long r0 = com.kwai.filedownloader.c.a.H(r0)
            r18 = r0
            goto L5a
        L74:
            r0 = r13
            com.kwai.filedownloader.c.c r0 = r0.aHf
            long r0 = r0.IB()
            r18 = r0
            goto L5a
        L80:
            r0 = 0
            r18 = r0
        L83:
            r0 = r13
            com.kwai.filedownloader.c.c r0 = r0.aHf
            r1 = r18
            r0.ao(r1)
            r0 = r18
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 <= 0) goto L96
            r0 = 1
            r17 = r0
        L96:
            r0 = r13
            r1 = r17
            r0.aHr = r1
            r0 = r17
            if (r0 != 0) goto Lb8
            r0 = r13
            com.kwai.filedownloader.a.a r0 = r0.aHa
            r1 = r13
            com.kwai.filedownloader.c.c r1 = r1.aHf
            int r1 = r1.getId()
            r0.cK(r1)
            r0 = r21
            r1 = r20
            com.kwai.filedownloader.e.f.ar(r0, r1)
        Lb8:
            com.kwai.filedownloader.download.a r0 = new com.kwai.filedownloader.download.a
            r1 = r0
            r2 = 0
            r3 = r18
            r4 = 0
            r5 = r13
            com.kwai.filedownloader.c.c r5 = r5.aHf
            long r5 = r5.getTotal()
            r6 = r18
            long r5 = r5 - r6
            r1.<init>(r2, r3, r4, r5)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwai.filedownloader.download.DownloadLaunchRunnable.G(java.util.List):com.kwai.filedownloader.download.a");
    }

    private boolean HP() {
        return (!this.aHr || this.aHf.ID() > 1) && this.aHs && this.aHm && !this.aHt;
    }

    private void HR() {
        if (this.aHi && !com.kwai.filedownloader.e.f.fF("android.permission.ACCESS_NETWORK_STATE")) {
            throw new FileDownloadGiveUpRetryException(com.kwai.filedownloader.e.f.j("Task[%d] can't start the download runnable, because this task require wifi, but user application nor current process has %s, so we can't check whether the network type connection.", Integer.valueOf(this.aHf.getId()), "android.permission.ACCESS_NETWORK_STATE"));
        }
        if (this.aHi && com.kwai.filedownloader.e.f.Jg()) {
            throw new FileDownloadNetworkPolicyException();
        }
    }

    private void HS() {
        int id = this.aHf.getId();
        if (this.aHf.Gm()) {
            String targetFilePath = this.aHf.getTargetFilePath();
            int aq = com.kwai.filedownloader.e.f.aq(this.aHf.getUrl(), targetFilePath);
            if (com.kwai.filedownloader.e.c.a(id, targetFilePath, this.aHh, false)) {
                this.aHa.cL(id);
                this.aHa.cK(id);
                throw new DiscardSafely();
            }
            com.kwai.filedownloader.c.c cI = this.aHa.cI(aq);
            if (cI != null) {
                if (com.kwai.filedownloader.e.c.a(id, cI, this.aHj, false)) {
                    this.aHa.cL(id);
                    this.aHa.cK(id);
                    throw new DiscardSafely();
                }
                List<com.kwai.filedownloader.c.a> cJ = this.aHa.cJ(aq);
                this.aHa.cL(aq);
                this.aHa.cK(aq);
                com.kwai.filedownloader.e.f.fJ(this.aHf.getTargetFilePath());
                if (com.kwai.filedownloader.e.f.b(aq, cI)) {
                    this.aHf.ao(cI.IB());
                    this.aHf.aq(cI.getTotal());
                    this.aHf.fv(cI.IC());
                    this.aHf.db(cI.ID());
                    this.aHa.b(this.aHf);
                    if (cJ != null) {
                        for (com.kwai.filedownloader.c.a aVar : cJ) {
                            aVar.setId(id);
                            this.aHa.a(aVar);
                        }
                    }
                    throw new RetryDirectly();
                }
            }
            if (com.kwai.filedownloader.e.c.a(id, this.aHf.IB(), this.aHf.HT(), targetFilePath, this.aHj)) {
                this.aHa.cL(id);
                this.aHa.cK(id);
                throw new DiscardSafely();
            }
        }
    }

    private void a(int i, List<com.kwai.filedownloader.c.a> list) {
        if (i <= 1 || list.size() != i) {
            throw new IllegalArgumentException();
        }
        b(list, this.aHf.getTotal());
    }

    private void a(long j, String str) {
        com.kwai.filedownloader.d.a aVar = null;
        AutoCloseable autoCloseable = null;
        if (j != -1) {
            try {
                com.kwai.filedownloader.d.a fH = com.kwai.filedownloader.e.f.fH(this.aHf.HT());
                long length = new File(str).length();
                long j2 = j - length;
                long availableBytes = h.getAvailableBytes(str);
                if (availableBytes < j2) {
                    throw new FileDownloadOutOfSpaceException(availableBytes, j2, length);
                }
                aVar = fH;
                if (!com.kwai.filedownloader.e.e.Jb().aJw) {
                    fH.setLength(j);
                    aVar = fH;
                }
            } catch (Throwable th) {
                if (0 != 0) {
                    autoCloseable.close();
                }
                throw th;
            }
        }
        if (aVar != null) {
            aVar.close();
        }
    }

    private void a(com.kwai.filedownloader.download.a aVar, com.kwai.filedownloader.kwai.b bVar) {
        com.kwai.filedownloader.download.a aVar2 = aVar;
        if (!this.aHs) {
            this.aHf.ao(0L);
            aVar2 = new com.kwai.filedownloader.download.a(0L, 0L, aVar.aGV, aVar.contentLength);
        }
        e.a aVar3 = new e.a();
        aVar3.b(this).cU(this.aHf.getId()).cT(-1).bU(this.aHi).d(bVar).c(aVar2).ft(this.aHf.HT());
        this.aHf.db(1);
        this.aHa.A(this.aHf.getId(), 1);
        this.aHo = aVar3.Ii();
        if (!this.lh) {
            this.aHo.run();
            return;
        }
        this.aHf.e((byte) -2);
        this.aHo.pause();
    }

    private void a(Map<String, List<String>> map, ConnectTask connectTask, com.kwai.filedownloader.kwai.b bVar) {
        int id = this.aHf.getId();
        int responseCode = bVar.getResponseCode();
        this.aHs = responseCode == 206 || responseCode == 1;
        boolean z = responseCode == 200 || responseCode == 201 || responseCode == 0;
        String IC = this.aHf.IC();
        String a2 = com.kwai.filedownloader.e.f.a(id, bVar);
        if (!(responseCode == 412 || !(IC == 0 || IC.equals(a2) || (!z && !this.aHs)) || ((responseCode == 201 && connectTask.HB()) || (responseCode == 416 && this.aHf.IB() > 0)))) {
            this.aHx = connectTask.HC();
            if (!this.aHs && !z) {
                throw new FileDownloadHttpException(responseCode, map, bVar.W());
            }
            long b = com.kwai.filedownloader.e.f.b(id, bVar);
            String a3 = this.aHf.Gm() ? com.kwai.filedownloader.e.f.a(bVar, this.aHf.getUrl()) : null;
            boolean z2 = b == -1;
            this.aHt = z2;
            if (!z2) {
                b = this.aHf.IB() + b;
            }
            this.aHd.a(this.aHr && this.aHs, b, a2, a3);
            return;
        }
        if (this.aHr) {
            com.kwai.filedownloader.e.d.h(this, "there is precondition failed on this request[%d] with old etag[%s]、new etag[%s]、response requestHttpCode is %d", Integer.valueOf(id), IC, a2, Integer.valueOf(responseCode));
        }
        this.aHa.cK(this.aHf.getId());
        com.kwai.filedownloader.e.f.ar(this.aHf.getTargetFilePath(), this.aHf.HT());
        this.aHr = false;
        String str = a2;
        if (IC != null) {
            str = a2;
            if (IC.equals(a2)) {
                com.kwai.filedownloader.e.d.h(this, "the old etag[%s] is the same to the new etag[%s], but the response status requestHttpCode is %d not Partial(206), so wo have to start this task from very beginning for task[%d]!", IC, a2, Integer.valueOf(responseCode), Integer.valueOf(id));
                str = null;
            }
        }
        this.aHf.ao(0L);
        this.aHf.aq(0L);
        this.aHf.fv(str);
        this.aHf.IE();
        this.aHa.a(id, this.aHf.IC(), this.aHf.IB(), this.aHf.getTotal(), this.aHf.ID());
        throw new RetryDirectly();
    }

    private void b(List<com.kwai.filedownloader.c.a> list, long j) {
        int id = this.aHf.getId();
        String IC = this.aHf.IC();
        String str = this.aHx;
        if (str == null) {
            str = this.aHf.getUrl();
        }
        String HT = this.aHf.HT();
        if (com.kwai.filedownloader.e.d.aJq) {
            com.kwai.filedownloader.e.d.g(this, "fetch data with multiple connection(count: [%d]) for task[%d] totalLength[%d]", Integer.valueOf(list.size()), Integer.valueOf(id), Long.valueOf(j));
        }
        boolean z = this.aHr;
        long j2 = 0;
        for (com.kwai.filedownloader.c.a aVar : list) {
            long Ix = aVar.Iy() == 0 ? j - aVar.Ix() : (aVar.Iy() - aVar.Ix()) + 1;
            j2 += aVar.Ix() - aVar.getStartOffset();
            if (Ix != 0) {
                c HV = new c.a().cR(id).d(Integer.valueOf(aVar.getIndex())).a(this).fq(str).fr(z ? IC : null).c(this.aHg).bS(this.aHi).b(new com.kwai.filedownloader.download.a(aVar.getStartOffset(), aVar.Ix(), aVar.Iy(), Ix)).fs(HT).HV();
                if (com.kwai.filedownloader.e.d.aJq) {
                    com.kwai.filedownloader.e.d.g(this, "enable multiple connection: %s", aVar);
                }
                this.aHn.add(HV);
            } else if (com.kwai.filedownloader.e.d.aJq) {
                com.kwai.filedownloader.e.d.g(this, "pass connection[%d-%d], because it has been completed", Integer.valueOf(aVar.getId()), Integer.valueOf(aVar.getIndex()));
            }
        }
        if (j2 != this.aHf.IB()) {
            com.kwai.filedownloader.e.d.h(this, "correct the sofar[%d] from connection table[%d]", Long.valueOf(this.aHf.IB()), Long.valueOf(j2));
            this.aHf.ao(j2);
        }
        ArrayList arrayList = new ArrayList(this.aHn.size());
        Iterator<c> it = this.aHn.iterator();
        while (it.hasNext()) {
            c next = it.next();
            if (this.lh) {
                next.pause();
            } else {
                arrayList.add(Executors.callable(next));
            }
        }
        if (this.lh) {
            this.aHf.e((byte) -2);
            return;
        }
        List<Future> invokeAll = aHq.invokeAll(arrayList);
        if (com.kwai.filedownloader.e.d.aJq) {
            for (Future future : invokeAll) {
                com.kwai.filedownloader.e.d.g(this, "finish sub-task for [%d] %B %B", Integer.valueOf(id), Boolean.valueOf(future.isDone()), Boolean.valueOf(future.isCancelled()));
            }
        }
    }

    private void e(long j, int i) {
        long j2 = j / i;
        int id = this.aHf.getId();
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        long j3 = 0;
        while (i2 < i) {
            long j4 = i2 == i - 1 ? 0L : (j3 + j2) - 1;
            com.kwai.filedownloader.c.a aVar = new com.kwai.filedownloader.c.a();
            aVar.setId(id);
            aVar.setIndex(i2);
            aVar.setStartOffset(j3);
            aVar.am(j3);
            aVar.an(j4);
            arrayList.add(aVar);
            this.aHa.a(aVar);
            j3 += j2;
            i2++;
        }
        this.aHf.db(i);
        this.aHa.A(id, i);
        b(arrayList, j);
    }

    public final void HO() {
        if (this.aHf.ID() > 1) {
            List<com.kwai.filedownloader.c.a> cJ = this.aHa.cJ(this.aHf.getId());
            if (this.aHf.ID() == cJ.size()) {
                this.aHf.ao(com.kwai.filedownloader.c.a.H(cJ));
            } else {
                this.aHf.ao(0L);
                this.aHa.cK(this.aHf.getId());
            }
        }
        this.aHd.HX();
    }

    @Override // com.kwai.filedownloader.download.f
    public final void HQ() {
        this.aHa.e(this.aHf.getId(), this.aHf.IB());
    }

    public final String HT() {
        return this.aHf.HT();
    }

    @Override // com.kwai.filedownloader.download.f
    public final void a(c cVar, long j, long j2) {
        if (this.lh) {
            if (com.kwai.filedownloader.e.d.aJq) {
                com.kwai.filedownloader.e.d.g(this, "the task[%d] has already been paused, so pass the completed callback", Integer.valueOf(this.aHf.getId()));
                return;
            }
            return;
        }
        int i = cVar == null ? -1 : cVar.aHK;
        if (com.kwai.filedownloader.e.d.aJq) {
            com.kwai.filedownloader.e.d.g(this, "the connection has been completed(%d): [%d, %d)  %d", Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2), Long.valueOf(this.aHf.getTotal()));
        }
        if (!this.aHp) {
            synchronized (this.aHn) {
                this.aHn.remove(cVar);
            }
        } else if (j == 0 || j2 == this.aHf.getTotal()) {
        } else {
            com.kwai.filedownloader.e.d.e(this, "the single task not completed corrected(%d, %d != %d) for task(%d)", Long.valueOf(j), Long.valueOf(j2), Long.valueOf(this.aHf.getTotal()), Integer.valueOf(this.aHf.getId()));
        }
    }

    @Override // com.kwai.filedownloader.download.f
    public final void a(Exception exc, long j) {
        if (this.lh) {
            if (com.kwai.filedownloader.e.d.aJq) {
                com.kwai.filedownloader.e.d.g(this, "the task[%d] has already been paused, so pass the retry callback", Integer.valueOf(this.aHf.getId()));
                return;
            }
            return;
        }
        int i = this.aHl;
        int i2 = i - 1;
        this.aHl = i2;
        if (i < 0) {
            com.kwai.filedownloader.e.d.e(this, "valid retry times is less than 0(%d) for download task(%d)", Integer.valueOf(i2), Integer.valueOf(this.aHf.getId()));
        }
        this.aHd.a(exc, this.aHl, j);
    }

    @Override // com.kwai.filedownloader.download.f
    public final boolean b(Exception exc) {
        if (exc instanceof FileDownloadHttpException) {
            int code = ((FileDownloadHttpException) exc).getCode();
            if (this.aHp && code == 416 && !this.aHk) {
                com.kwai.filedownloader.e.f.ar(this.aHf.getTargetFilePath(), this.aHf.HT());
                this.aHk = true;
                return true;
            }
        }
        return this.aHl > 0 && !(exc instanceof FileDownloadGiveUpRetryException);
    }

    @Override // com.kwai.filedownloader.download.f
    public final void c(Exception exc) {
        this.aHv = true;
        this.aHw = exc;
        if (this.lh) {
            if (com.kwai.filedownloader.e.d.aJq) {
                com.kwai.filedownloader.e.d.g(this, "the task[%d] has already been paused, so pass the error callback", Integer.valueOf(this.aHf.getId()));
                return;
            }
            return;
        }
        Iterator it = ((ArrayList) this.aHn.clone()).iterator();
        while (it.hasNext()) {
            c cVar = (c) it.next();
            if (cVar != null) {
                cVar.Hf();
            }
        }
    }

    public final int getId() {
        return this.aHf.getId();
    }

    public final boolean isAlive() {
        return this.aHu.get() || this.aHd.isAlive();
    }

    @Override // com.kwai.filedownloader.download.f
    public final void onProgress(long j) {
        if (this.lh) {
            return;
        }
        this.aHd.onProgress(j);
    }

    public final void pause() {
        this.lh = true;
        e eVar = this.aHo;
        if (eVar != null) {
            eVar.pause();
        }
        Iterator it = ((ArrayList) this.aHn.clone()).iterator();
        while (it.hasNext()) {
            c cVar = (c) it.next();
            if (cVar != null) {
                cVar.pause();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x0380, code lost:
        r14 = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x0387, code lost:
        if (r15 == null) goto L115;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x038a, code lost:
        r15.X();
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x0394, code lost:
        r14 = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x03c0, code lost:
        r9.aHd.HZ();
        r0 = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x03f3, code lost:
        if (r9.aHr == false) goto L113;
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x03f6, code lost:
        r0 = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x041e, code lost:
        a(r10, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x0450, code lost:
        e(r0, r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x0458, code lost:
        if (r14 == null) goto L93;
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x045b, code lost:
        r14.X();
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x0482, code lost:
        throw new java.lang.IllegalAccessException(com.kwai.filedownloader.e.f.j("invalid connection count %d, the connection count must be larger than 0", r15));
     */
    /* JADX WARN: Code restructure failed: missing block: B:219:0x0628, code lost:
        r10 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00d8, code lost:
        if (com.kwai.filedownloader.e.d.aJq == false) goto L198;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00db, code lost:
        com.kwai.filedownloader.e.d.g(r9, "High concurrent cause, start runnable but already paused %d", java.lang.Integer.valueOf(r9.aHf.getId()));
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00f4, code lost:
        r9.aHd.HW();
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00fe, code lost:
        if (r9.lh == false) goto L201;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0108, code lost:
        if (r9.aHv == false) goto L203;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x010e, code lost:
        r9.aHd.Ib();
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0118, code lost:
        r14 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x027d, code lost:
        if (r9.lh == false) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0280, code lost:
        r9.aHf.e((byte) -2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x028b, code lost:
        if (r15 == null) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x028e, code lost:
        r15.X();
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0296, code lost:
        r9.aHd.HW();
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x02a0, code lost:
        if (r9.lh == false) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x02aa, code lost:
        if (r9.aHv == false) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x02b0, code lost:
        r9.aHd.Ib();
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x02ba, code lost:
        r14 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x02bf, code lost:
        HS();
        r0 = r9.aHf.getTotal();
        a(r0, r9.aHf.HT());
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x02db, code lost:
        if (HP() == false) goto L120;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x02e2, code lost:
        if (r9.aHr == false) goto L119;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x02e5, code lost:
        r10 = r9.aHf.ID();
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x02f0, code lost:
        r10 = com.kwai.filedownloader.download.b.HF().a(r9.aHf.getId(), r9.aHf.getUrl(), r9.aHf.getPath(), r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0311, code lost:
        if (r10 <= 0) goto L117;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0318, code lost:
        if (r9.lh == false) goto L83;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x031b, code lost:
        r9.aHf.e((byte) -2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0326, code lost:
        if (r15 == null) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0329, code lost:
        r15.X();
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x0331, code lost:
        r9.aHd.HW();
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x033b, code lost:
        if (r9.lh == false) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x0345, code lost:
        if (r9.aHv == false) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x034b, code lost:
        r9.aHd.Ib();
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x0355, code lost:
        r14 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x035c, code lost:
        if (r10 != 1) goto L116;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x035f, code lost:
        r13 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x0365, code lost:
        r13 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x0368, code lost:
        r9.aHp = r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x0370, code lost:
        if (r13 == false) goto L102;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x0373, code lost:
        a(r0.HD(), r15);
     */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0558  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x058d A[Catch: all -> 0x05c1, TRY_ENTER, TryCatch #16 {all -> 0x05c1, blocks: (B:2:0x0000, B:5:0x0012, B:7:0x001e, B:9:0x0024, B:10:0x003f, B:23:0x00c0, B:25:0x00c7, B:27:0x00cf, B:29:0x00d5, B:31:0x00db, B:42:0x011d, B:59:0x028e, B:82:0x0329, B:117:0x045b, B:186:0x058d, B:188:0x0596, B:144:0x04cf, B:183:0x057e, B:147:0x04de), top: B:231:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:193:0x05a8  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x056f A[SYNTHETIC] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void run() {
        /*
            Method dump skipped, instructions count: 1581
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwai.filedownloader.download.DownloadLaunchRunnable.run():void");
    }
}
