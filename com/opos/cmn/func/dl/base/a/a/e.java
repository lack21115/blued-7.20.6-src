package com.opos.cmn.func.dl.base.a.a;

import com.opos.cmn.func.dl.base.exception.DlException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/func/dl/base/a/a/e.class */
public class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    static final String f11199a = e.class.getSimpleName();
    public volatile boolean b;

    /* renamed from: c  reason: collision with root package name */
    public Map<Integer, RandomAccessFile> f11200c = new ConcurrentHashMap();
    BlockingQueue<a> d = new ArrayBlockingQueue(1000);
    private d e;

    public e(d dVar) {
        this.e = dVar;
    }

    private void a(RandomAccessFile randomAccessFile) {
        com.opos.cmn.an.f.a.b(f11199a, "close buffer stream!downloadId:");
        if (randomAccessFile == null) {
            return;
        }
        Iterator<Map.Entry<Integer, RandomAccessFile>> it = this.f11200c.entrySet().iterator();
        while (it.hasNext()) {
            if (randomAccessFile.equals(it.next().getValue())) {
                it.remove();
                com.opos.cmn.func.dl.base.h.a.a(randomAccessFile);
                return;
            }
        }
    }

    public final int a() {
        return this.d.size();
    }

    public final void a(a aVar) {
        int i = aVar.b;
        if (this.f11200c.get(Integer.valueOf(i)) == null) {
            com.opos.cmn.func.dl.base.a.c a2 = this.e.a(i);
            if (a2 == null || a2.b.a() != 3) {
                return;
            }
            try {
                File file = a2.f11205a.j;
                if (!com.opos.cmn.an.d.b.a.a(file)) {
                    com.opos.cmn.func.dl.base.h.a.a(file);
                }
                this.f11200c.put(Integer.valueOf(i), new RandomAccessFile(file, "rw"));
            } catch (Exception e) {
                boolean a3 = com.opos.cmn.func.dl.base.h.a.a(this.e.f11198c);
                com.opos.cmn.an.f.a.d(f11199a, "create tempFile failed!hasStorage=".concat(String.valueOf(a3)), e);
                throw new DlException(a3 ? 1000 : 1008, e);
            }
        }
        try {
            this.d.put(aVar);
        } catch (InterruptedException e2) {
            com.opos.cmn.an.f.a.c(f11199a, "addBuffer interrupt!", e2);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        RandomAccessFile randomAccessFile;
        f fVar;
        a aVar;
        a aVar2;
        RandomAccessFile randomAccessFile2;
        RandomAccessFile randomAccessFile3;
        f fVar2;
        Throwable th;
        DlException dlException;
        com.opos.cmn.an.f.a.b(f11199a, "Write thread start!");
        while (!this.b) {
            try {
                try {
                    aVar = this.d.take();
                } catch (DlException e) {
                    e = e;
                    randomAccessFile3 = null;
                    fVar2 = null;
                    aVar = null;
                } catch (IOException e2) {
                    e = e2;
                    randomAccessFile2 = null;
                    fVar = null;
                    aVar = null;
                } catch (InterruptedException e3) {
                    aVar2 = null;
                } catch (Exception e4) {
                    e = e4;
                    randomAccessFile = null;
                    fVar = null;
                    aVar = null;
                }
                try {
                    try {
                        com.opos.cmn.func.dl.base.a.c a2 = this.e.a(aVar.b);
                        if (a2 != null) {
                            randomAccessFile3 = this.f11200c.get(Integer.valueOf(aVar.b));
                            if (randomAccessFile3 != null) {
                                try {
                                    if (a2.b.a() == 3) {
                                        f fVar3 = a2.f11206c;
                                        com.opos.cmn.func.dl.base.a.b bVar = a2.f11205a;
                                        if (!bVar.j.exists()) {
                                            throw new DlException(1009);
                                            break;
                                        }
                                        if (aVar.f11192c != -1) {
                                            if (a2.b.a() == 3) {
                                                randomAccessFile3.seek(aVar.d);
                                                randomAccessFile3.write(aVar.e, 0, aVar.f11192c);
                                                bVar.s.addAndGet(aVar.f11192c);
                                                fVar3.b(aVar);
                                            }
                                        }
                                        boolean z = bVar.s.get() >= bVar.k && bVar.k != -1;
                                        boolean z2 = false;
                                        if (bVar.k == -1) {
                                            z2 = false;
                                            if (aVar.f11192c == -1) {
                                                z2 = true;
                                            }
                                        }
                                        if (z || z2) {
                                            String str = f11199a;
                                            StringBuilder sb = new StringBuilder("Write finish by isOverLen :");
                                            sb.append(z);
                                            sb.append(",isEndBuffer:");
                                            sb.append(z2);
                                            com.opos.cmn.an.f.a.a(str, sb.toString());
                                            RandomAccessFile remove = this.f11200c.remove(Integer.valueOf(aVar.b));
                                            if (remove != null) {
                                                try {
                                                    remove.close();
                                                } catch (DlException e5) {
                                                    randomAccessFile3 = remove;
                                                    fVar2 = fVar3;
                                                    e = e5;
                                                    e = e;
                                                    com.opos.cmn.an.f.a.c(f11199a, "write block error! ", e);
                                                    a aVar3 = aVar;
                                                    a(randomAccessFile3);
                                                    aVar2 = aVar;
                                                    if (fVar2 != null) {
                                                        fVar2.a(e);
                                                        aVar2 = aVar;
                                                    }
                                                    this.e.f11197a.e.a(aVar2);
                                                } catch (IOException e6) {
                                                    randomAccessFile2 = remove;
                                                    fVar = fVar3;
                                                    e = e6;
                                                    e = e;
                                                    com.opos.cmn.an.f.a.c(f11199a, "write block io error! ", e);
                                                    a aVar4 = aVar;
                                                    a(randomAccessFile2);
                                                    aVar2 = aVar;
                                                    if (fVar != null) {
                                                        dlException = new DlException(1004);
                                                        a aVar5 = aVar;
                                                        fVar.a(dlException);
                                                        aVar2 = aVar;
                                                    }
                                                    this.e.f11197a.e.a(aVar2);
                                                } catch (Exception e7) {
                                                    randomAccessFile = remove;
                                                    fVar = fVar3;
                                                    e = e7;
                                                    e = e;
                                                    com.opos.cmn.an.f.a.c(f11199a, "onError error! ", e);
                                                    a aVar6 = aVar;
                                                    a(randomAccessFile);
                                                    aVar2 = aVar;
                                                    if (fVar != null) {
                                                        dlException = new DlException(1000, e);
                                                        a aVar52 = aVar;
                                                        fVar.a(dlException);
                                                        aVar2 = aVar;
                                                    }
                                                    this.e.f11197a.e.a(aVar2);
                                                }
                                            }
                                            fVar3.a();
                                        }
                                    }
                                } catch (DlException e8) {
                                    e = e8;
                                    fVar2 = null;
                                } catch (IOException e9) {
                                    e = e9;
                                    randomAccessFile2 = randomAccessFile3;
                                    fVar = null;
                                } catch (Exception e10) {
                                    e = e10;
                                    fVar = null;
                                    randomAccessFile = randomAccessFile3;
                                }
                            }
                        }
                        this.e.f11197a.e.a(aVar);
                    } catch (DlException e11) {
                        e = e11;
                        fVar2 = null;
                        randomAccessFile3 = null;
                    } catch (IOException e12) {
                        e = e12;
                        fVar = null;
                        randomAccessFile2 = null;
                    } catch (Exception e13) {
                        e = e13;
                        fVar = null;
                        randomAccessFile = null;
                    }
                } catch (InterruptedException e14) {
                    aVar2 = aVar;
                    try {
                        com.opos.cmn.an.f.a.c(f11199a, "write block inerrupted! ");
                        this.e.f11197a.e.a(aVar2);
                    } catch (Throwable th2) {
                        aVar = aVar2;
                        th = th2;
                        this.e.f11197a.e.a(aVar);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    this.e.f11197a.e.a(aVar);
                    throw th;
                }
            } catch (Throwable th4) {
                aVar = null;
                th = th4;
            }
        }
    }
}
