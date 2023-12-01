package com.kwai.filedownloader.message;

import com.kwai.filedownloader.download.d;
import com.kwai.filedownloader.message.MessageSnapshot;
import com.kwai.filedownloader.message.a;
import com.kwai.filedownloader.message.d;
import com.kwai.filedownloader.message.h;
import java.io.File;

/* loaded from: source-7994992-dex2jar.jar:com/kwai/filedownloader/message/f.class */
public class f {
    public static MessageSnapshot a(byte b, com.kwai.filedownloader.c.c cVar, d.a aVar) {
        MessageSnapshot c0421d;
        int id = cVar.getId();
        if (b != -4) {
            if (b == -3) {
                return cVar.Gw() ? new d.b(id, false, cVar.getTotal()) : new h.b(id, false, (int) cVar.getTotal());
            }
            if (b == -1) {
                c0421d = cVar.Gw() ? new d.C0421d(id, cVar.IB(), aVar.getException()) : new h.d(id, (int) cVar.IB(), aVar.getException());
            } else if (b == 1) {
                return cVar.Gw() ? new d.f(id, cVar.IB(), cVar.getTotal()) : new h.f(id, (int) cVar.IB(), (int) cVar.getTotal());
            } else if (b == 2) {
                String filename = cVar.Gm() ? cVar.getFilename() : null;
                return cVar.Gw() ? new d.c(id, aVar.Ig(), cVar.getTotal(), cVar.IC(), filename) : new h.c(id, aVar.Ig(), (int) cVar.getTotal(), cVar.IC(), filename);
            } else if (b == 3) {
                return cVar.Gw() ? new d.g(id, cVar.IB()) : new h.g(id, (int) cVar.IB());
            } else if (b != 5) {
                if (b != 6) {
                    String j = com.kwai.filedownloader.e.f.j("it can't takes a snapshot for the task(%s) when its status is %d,", cVar, Byte.valueOf(b));
                    com.kwai.filedownloader.e.d.h(f.class, "it can't takes a snapshot for the task(%s) when its status is %d,", cVar, Byte.valueOf(b));
                    IllegalStateException illegalStateException = aVar.getException() != null ? new IllegalStateException(j, aVar.getException()) : new IllegalStateException(j);
                    return cVar.Gw() ? new d.C0421d(id, cVar.IB(), illegalStateException) : new h.d(id, (int) cVar.IB(), illegalStateException);
                }
                return new MessageSnapshot.b(id);
            } else {
                c0421d = cVar.Gw() ? new d.h(id, cVar.IB(), aVar.getException(), aVar.Gu()) : new h.C0422h(id, (int) cVar.IB(), aVar.getException(), aVar.Gu());
            }
            return c0421d;
        }
        throw new IllegalStateException(com.kwai.filedownloader.e.f.j("please use #catchWarn instead %d", Integer.valueOf(id)));
    }

    public static MessageSnapshot a(int i, long j, long j2, boolean z) {
        return j2 > 2147483647L ? z ? new d.i(i, j, j2) : new d.j(i, j, j2) : z ? new h.i(i, (int) j, (int) j2) : new h.j(i, (int) j, (int) j2);
    }

    public static MessageSnapshot a(int i, long j, Throwable th) {
        return j > 2147483647L ? new d.C0421d(i, j, th) : new h.d(i, (int) j, th);
    }

    public static MessageSnapshot a(int i, File file, boolean z) {
        long length = file.length();
        return length > 2147483647L ? z ? new d.a(i, true, length) : new d.b(i, true, length) : z ? new h.a(i, true, (int) length) : new h.b(i, true, (int) length);
    }

    public static MessageSnapshot e(com.kwai.filedownloader.a aVar) {
        return aVar.Gw() ? new d.e(aVar.getId(), aVar.Go(), aVar.Gp()) : new h.e(aVar.getId(), aVar.getSmallFileSoFarBytes(), aVar.getSmallFileTotalBytes());
    }

    public static MessageSnapshot t(MessageSnapshot messageSnapshot) {
        if (messageSnapshot.Gq() == -3) {
            return new a.C0420a(messageSnapshot);
        }
        throw new IllegalStateException(com.kwai.filedownloader.e.f.j("take block completed snapshot, must has already be completed. %d %d", Integer.valueOf(messageSnapshot.getId()), Byte.valueOf(messageSnapshot.Gq())));
    }
}
