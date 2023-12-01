package com.tencent.mapsdk.internal;

import android.util.Log;
import com.tencent.map.tools.net.NetManager;
import com.tencent.map.tools.net.NetResponse;
import com.tencent.mapsdk.core.components.protocol.jce.conf.CSFileUpdateReq;
import com.tencent.mapsdk.core.components.protocol.jce.conf.FileUpdateReq;
import com.tencent.mapsdk.core.components.protocol.jce.conf.FileUpdateRsp;
import com.tencent.mapsdk.core.components.protocol.jce.conf.SCFileUpdateRsp;
import com.tencent.mapsdk.internal.s6;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/pf.class */
public class pf {
    private static final String g = "UTF-8";

    /* renamed from: a  reason: collision with root package name */
    private WeakReference<rf> f37693a;
    private List<FileUpdateReq> b;

    /* renamed from: c  reason: collision with root package name */
    private String f37694c;
    private String d;
    private String e;
    private int f;

    private FileUpdateReq a(String str) {
        List<FileUpdateReq> list = this.b;
        if (list == null || list.isEmpty()) {
            return null;
        }
        for (FileUpdateReq fileUpdateReq : this.b) {
            if (f7.c(fileUpdateReq.sName, str)) {
                return fileUpdateReq;
            }
        }
        return null;
    }

    private s6.c a(FileUpdateRsp fileUpdateRsp) {
        if (fileUpdateRsp == null || fileUpdateRsp.iRet != 0) {
            return null;
        }
        String str = fileUpdateRsp.sName;
        str.hashCode();
        boolean z = true;
        switch (str.hashCode()) {
            case -1319508241:
                if (str.equals(k4.n)) {
                    z = false;
                    break;
                }
                break;
            case -1091367180:
                if (str.equals(k4.m)) {
                    z = true;
                    break;
                }
                break;
            case -503063473:
                if (str.equals(k4.p)) {
                    z = true;
                    break;
                }
                break;
            case 178735484:
                if (str.equals(k4.j)) {
                    z = true;
                    break;
                }
                break;
            case 204802075:
                if (str.equals(k4.l)) {
                    z = true;
                    break;
                }
                break;
            case 451944782:
                if (str.equals("poi_icon")) {
                    z = true;
                    break;
                }
                break;
            case 1366209438:
                if (str.equals(k4.i)) {
                    z = true;
                    break;
                }
                break;
            case 1864531656:
                if (str.equals(k4.o)) {
                    z = true;
                    break;
                }
                break;
        }
        switch (z) {
            case false:
            case true:
            case true:
            case true:
            case true:
            case true:
                return a(fileUpdateRsp, this.f37694c, false);
            case true:
                return a(fileUpdateRsp, this.d, true);
            case true:
                return a(fileUpdateRsp, this.f37694c, true);
            default:
                return null;
        }
    }

    private s6.c a(FileUpdateRsp fileUpdateRsp, String str, boolean z) {
        if (fileUpdateRsp.iFileUpdated != 1) {
            return null;
        }
        String b = b(fileUpdateRsp.sName);
        File file = new File(str + b);
        s6.c a2 = a(b, fileUpdateRsp.sUpdateUrl, file);
        na.c("net", "fileUpdateRsp.sName = " + fileUpdateRsp.sName);
        if (a2 != null) {
            a2.b = fileUpdateRsp.sName;
            return a2;
        }
        try {
            String a3 = wa.a(file);
            na.c("net", "fileMd5 = " + a3);
            if (!fileUpdateRsp.sMd5.equals(a3)) {
                s6.c cVar = new s6.c();
                cVar.b = fileUpdateRsp.sName;
                cVar.d = fileUpdateRsp.sMd5;
                cVar.e = a3;
                na.c("net", "error md5 1");
                return cVar;
            }
            if (z) {
                try {
                    ja.a(file, file.getParent());
                    file.delete();
                } catch (Throwable th) {
                    na.b(th.getMessage());
                    s6.c cVar2 = new s6.c();
                    cVar2.b = fileUpdateRsp.sName;
                    na.c("net", "error unzip");
                    return cVar2;
                }
            }
            WeakReference<rf> weakReference = this.f37693a;
            if (weakReference == null || weakReference.get() == null) {
                return null;
            }
            this.f37693a.get().f37751a = true;
            return null;
        } catch (Exception e) {
            na.b(e.getMessage());
            s6.c cVar3 = new s6.c();
            cVar3.b = fileUpdateRsp.sName;
            na.c("net", "error md5 2 " + e.getMessage());
            return cVar3;
        }
    }

    /* JADX WARN: Not initialized variable reg: 10, insn: 0x0167: MOVE  (r0 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r10 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), block:B:32:0x0167 */
    /* JADX WARN: Not initialized variable reg: 14, insn: 0x016b: MOVE  (r0 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r14 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), block:B:32:0x0167 */
    private s6.c a(String str, String str2, File file) {
        NetResponse netResponse;
        InputStream inputStream;
        NetResponse netResponse2;
        InputStream inputStream2;
        int i;
        Closeable closeable;
        na.c(ma.e, "开始下载[" + str + "]:" + str2);
        ra.c(ma.e, str2);
        FileOutputStream fileOutputStream = null;
        FileOutputStream fileOutputStream2 = null;
        int i2 = 200;
        try {
            try {
                NetResponse doStream = NetManager.getInstance().builder().url(str2).doStream();
                int i3 = 200;
                int i4 = 200;
                try {
                    i2 = doStream.statusCode;
                    i3 = i2;
                    i4 = i2;
                    InputStream inputStream3 = doStream.dataStream;
                    try {
                        if (!file.exists()) {
                            File parentFile = file.getParentFile();
                            if (parentFile != null) {
                                parentFile.mkdirs();
                            }
                            file.createNewFile();
                        }
                        FileOutputStream fileOutputStream3 = new FileOutputStream(file, false);
                        try {
                            ha.a(inputStream3, fileOutputStream3);
                            ha.a((Closeable) inputStream3);
                            ha.a(fileOutputStream3);
                            ha.a((Closeable) doStream.dataStream);
                            ra.a(ma.e, str2, "netError", Integer.valueOf(i2));
                            ra.f(ma.e, str2);
                            na.c(ma.e, "下载[" + str + "]结束");
                            return null;
                        } catch (Exception e) {
                            fileOutputStream = fileOutputStream3;
                            netResponse2 = doStream;
                            inputStream2 = inputStream3;
                            e = e;
                            na.b(Log.getStackTraceString(e));
                            FileOutputStream fileOutputStream4 = fileOutputStream;
                            s6.c cVar = new s6.c();
                            FileOutputStream fileOutputStream5 = fileOutputStream;
                            cVar.g = i2;
                            FileOutputStream fileOutputStream6 = fileOutputStream;
                            ra.a(ma.e, str2, "error", Log.getStackTraceString(e));
                            ha.a((Closeable) inputStream2);
                            ha.a(fileOutputStream);
                            if (netResponse2 != null) {
                                ha.a((Closeable) netResponse2.dataStream);
                            }
                            ra.a(ma.e, str2, "netError", Integer.valueOf(i2));
                            ra.f(ma.e, str2);
                            na.c(ma.e, "下载[" + str + "]结束");
                            return cVar;
                        } catch (Throwable th) {
                            fileOutputStream2 = fileOutputStream3;
                            netResponse = doStream;
                            inputStream = inputStream3;
                            th = th;
                            ha.a((Closeable) inputStream);
                            ha.a(fileOutputStream2);
                            if (netResponse != null) {
                                ha.a((Closeable) netResponse.dataStream);
                            }
                            ra.a(ma.e, str2, "netError", Integer.valueOf(i2));
                            ra.f(ma.e, str2);
                            na.c(ma.e, "下载[" + str + "]结束");
                            throw th;
                        }
                    } catch (Exception e2) {
                        netResponse2 = doStream;
                        inputStream2 = inputStream3;
                        e = e2;
                    }
                } catch (Exception e3) {
                    inputStream2 = null;
                    i2 = i4;
                    netResponse2 = doStream;
                    e = e3;
                } catch (Throwable th2) {
                    inputStream = null;
                    i2 = i3;
                    netResponse = doStream;
                    th = th2;
                }
            } catch (Exception e4) {
                e = e4;
                netResponse2 = null;
                inputStream2 = null;
            } catch (Throwable th3) {
                th = th3;
                netResponse = null;
                inputStream = null;
            }
        } catch (Throwable th4) {
            th = th4;
            i2 = i;
            inputStream = closeable;
        }
    }

    private List<FileUpdateRsp> a(CSFileUpdateReq cSFileUpdateReq) {
        byte[] bArr;
        try {
            NetResponse configFileUpdate = ((y2) ((m3) n2.a(m3.class)).d()).configFileUpdate(c7.F(), c7.A(), c7.N(), c7.G(), this.e, cSFileUpdateReq.toByteArray("UTF-8"));
            if (configFileUpdate == null || (bArr = configFileUpdate.data) == null) {
                StringBuilder sb = new StringBuilder();
                sb.append("rsp = ");
                sb.append(configFileUpdate != null ? Integer.valueOf(configFileUpdate.statusCode) : com.igexin.push.core.b.l);
                na.c("net", sb.toString());
                return null;
            }
            m mVar = new m(bArr);
            mVar.a("UTF-8");
            SCFileUpdateRsp sCFileUpdateRsp = new SCFileUpdateRsp();
            sCFileUpdateRsp.readFrom(mVar);
            na.c("net", "scrsp.iRet = " + sCFileUpdateRsp.iRet);
            if (sCFileUpdateRsp.iRet == 0) {
                return sCFileUpdateRsp.vItems;
            }
            return null;
        } catch (Exception e) {
            na.b(Log.getStackTraceString(e));
            return null;
        }
    }

    private void a(s6.c cVar) {
        rf rfVar;
        WeakReference<h1>[] c2;
        h1 h1Var;
        WeakReference<rf> weakReference = this.f37693a;
        if (weakReference == null || (rfVar = weakReference.get()) == null || (c2 = rfVar.c()) == null) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= c2.length) {
                return;
            }
            if (c2[i2] != null && (h1Var = c2[i2].get()) != null && h1Var.l() != null && h1Var.l().A() != null) {
                w6 w = h1Var.l().A().w();
                if (w == null) {
                    return;
                }
                cVar.f37996c -= w.a();
                w.l().a(cVar);
            }
            i = i2 + 1;
        }
    }

    private String b(String str) {
        if (str.equals(k4.i)) {
            return k4.f37583a;
        }
        if (str.equals(k4.l)) {
            return k4.b;
        }
        if (str.equals(k4.m)) {
            return k4.f37584c;
        }
        if (str.equals(k4.n)) {
            return k4.e;
        }
        if (str.equals(k4.o)) {
            return k4.f;
        }
        String str2 = str;
        if (str.equals(k4.p)) {
            str2 = k4.h;
        }
        return str2;
    }

    public List<FileUpdateRsp> a(String str, String str2, String str3, CSFileUpdateReq cSFileUpdateReq, rf rfVar) {
        if (cSFileUpdateReq == null || rfVar == null) {
            return null;
        }
        this.b = cSFileUpdateReq.vItems;
        this.f37694c = str;
        this.d = str2;
        this.f37693a = new WeakReference<>(rfVar);
        this.e = str3;
        List<FileUpdateRsp> a2 = a(cSFileUpdateReq);
        na.c("net", "rspList = " + a2);
        if (a2 == null || a2.isEmpty()) {
            return null;
        }
        this.f = a2.size();
        for (FileUpdateRsp fileUpdateRsp : a2) {
            s6.c a3 = a(fileUpdateRsp);
            if (a3 != null) {
                FileUpdateReq a4 = a(a3.b);
                if (a4 != null) {
                    a3.f = a4.iVersion;
                } else {
                    a3.f = -1;
                }
                a3.f37996c = System.currentTimeMillis();
                a(a3);
                na.c("net", "fileUpdateRsp = " + fileUpdateRsp);
                na.c("net", "failUpdate = " + a3);
                return null;
            }
            this.f--;
        }
        if (this.f != 0) {
            return null;
        }
        return a2;
    }
}
