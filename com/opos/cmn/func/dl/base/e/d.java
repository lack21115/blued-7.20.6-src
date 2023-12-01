package com.opos.cmn.func.dl.base.e;

import com.opos.cmn.func.dl.base.exception.DlException;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/func/dl/base/e/d.class */
public class d implements a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f11231a = d.class.getSimpleName();
    private File b;

    /* renamed from: c  reason: collision with root package name */
    private File f11232c;

    public d(File file, File file2) {
        this.b = file;
        this.f11232c = file2;
    }

    @Override // com.opos.cmn.func.dl.base.e.a
    public final List<c> a() {
        ArrayList arrayList;
        FileInputStream fileInputStream;
        DataInputStream dataInputStream;
        synchronized (this) {
            arrayList = null;
            if (com.opos.cmn.an.d.b.a.a(this.b)) {
                arrayList = null;
                if (com.opos.cmn.an.d.b.a.a(this.f11232c)) {
                    com.opos.cmn.an.f.a.b(f11231a, "tmpFile and posFile all exists.");
                    try {
                        fileInputStream = new FileInputStream(this.b);
                        try {
                            dataInputStream = new DataInputStream(fileInputStream);
                        } catch (Exception e) {
                            dataInputStream = null;
                            arrayList = null;
                        } catch (Throwable th) {
                            th = th;
                            dataInputStream = null;
                        }
                    } catch (Exception e2) {
                        dataInputStream = null;
                        arrayList = null;
                        fileInputStream = null;
                    } catch (Throwable th2) {
                        th = th2;
                        fileInputStream = null;
                        dataInputStream = null;
                    }
                    try {
                        try {
                            int readInt = dataInputStream.readInt();
                            com.opos.cmn.an.f.a.b(f11231a, "blockNum=".concat(String.valueOf(readInt)));
                            arrayList = new ArrayList(readInt);
                            int i = 0;
                            while (true) {
                                int i2 = i;
                                if (i2 >= readInt) {
                                    break;
                                }
                                try {
                                    arrayList.add(new c(i2, dataInputStream.readLong(), dataInputStream.readLong(), dataInputStream.readLong()));
                                    i = i2 + 1;
                                } catch (Exception e3) {
                                    try {
                                        com.opos.cmn.an.f.a.c(f11231a, "read pos file error,delete pos file!");
                                        com.opos.cmn.an.d.b.a.e(this.f11232c);
                                        com.opos.cmn.func.dl.base.h.a.a(dataInputStream, fileInputStream);
                                        com.opos.cmn.an.f.a.b(f11231a, "getFileSavedInfos, path:" + this.b.getName());
                                        return arrayList;
                                    } catch (Throwable th3) {
                                        th = th3;
                                        com.opos.cmn.func.dl.base.h.a.a(dataInputStream, fileInputStream);
                                        throw th;
                                    }
                                }
                            }
                            com.opos.cmn.func.dl.base.h.a.a(dataInputStream, fileInputStream);
                        } catch (Exception e4) {
                            arrayList = null;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        com.opos.cmn.func.dl.base.h.a.a(dataInputStream, fileInputStream);
                        throw th;
                    }
                }
            }
            com.opos.cmn.an.f.a.b(f11231a, "getFileSavedInfos, path:" + this.b.getName());
        }
        return arrayList;
    }

    @Override // com.opos.cmn.func.dl.base.e.a
    public final void a(List<c> list) {
        FileOutputStream fileOutputStream;
        DataOutputStream dataOutputStream;
        DataOutputStream dataOutputStream2;
        synchronized (this) {
            if (list != null) {
                if (list.size() > 0) {
                    try {
                        int size = list.size();
                        com.opos.cmn.func.dl.base.h.a.a(this.b);
                        fileOutputStream = new FileOutputStream(this.b);
                        try {
                            dataOutputStream = new DataOutputStream(fileOutputStream);
                            try {
                                dataOutputStream.writeInt(size);
                                int i = 0;
                                while (true) {
                                    int i2 = i;
                                    if (i2 >= size) {
                                        break;
                                    }
                                    c cVar = list.get(i2);
                                    dataOutputStream.writeLong(cVar.b);
                                    dataOutputStream.writeLong(cVar.d);
                                    dataOutputStream.writeLong(cVar.f11230c);
                                    i = i2 + 1;
                                }
                                com.opos.cmn.func.dl.base.h.a.a(dataOutputStream, fileOutputStream);
                            } catch (Exception e) {
                                dataOutputStream2 = dataOutputStream;
                                e = e;
                                try {
                                    com.opos.cmn.an.f.a.c(f11231a, "saveThreadInfos ", e);
                                    throw new DlException(1004, e);
                                } catch (Throwable th) {
                                    dataOutputStream = dataOutputStream2;
                                    th = th;
                                    com.opos.cmn.func.dl.base.h.a.a(dataOutputStream, fileOutputStream);
                                    throw th;
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                com.opos.cmn.func.dl.base.h.a.a(dataOutputStream, fileOutputStream);
                                throw th;
                            }
                        } catch (Exception e2) {
                            e = e2;
                            dataOutputStream2 = null;
                        } catch (Throwable th3) {
                            th = th3;
                            dataOutputStream = null;
                        }
                    } catch (Exception e3) {
                        e = e3;
                        fileOutputStream = null;
                        dataOutputStream2 = null;
                    } catch (Throwable th4) {
                        th = th4;
                        fileOutputStream = null;
                        dataOutputStream = null;
                    }
                }
            }
        }
    }
}
