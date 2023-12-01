package com.anythink.expressad.videocommon.b;

import android.text.TextUtils;
import com.anythink.expressad.videocommon.b.i;
import java.util.Iterator;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/videocommon/b/d.class */
public final class d implements i.c {

    /* renamed from: a  reason: collision with root package name */
    private static String f5892a = "DownLoadH5SourceListener";
    private ConcurrentMap<String, d> b;

    /* renamed from: c  reason: collision with root package name */
    private m f5893c;
    private CopyOnWriteArrayList<i.d> d;
    private String e;

    public d(ConcurrentMap<String, d> concurrentMap, m mVar, i.d dVar, String str) {
        CopyOnWriteArrayList<i.d> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        this.d = copyOnWriteArrayList;
        this.b = concurrentMap;
        this.f5893c = mVar;
        copyOnWriteArrayList.add(dVar);
        this.e = str;
    }

    @Override // com.anythink.expressad.videocommon.b.i.c
    public final void a() {
    }

    public final void a(i.d dVar) {
        this.d.add(dVar);
    }

    @Override // com.anythink.expressad.videocommon.b.i.c
    public final void a(String str) {
        String str2;
        try {
        } catch (Exception e) {
            if (com.anythink.expressad.a.f4103a) {
                e.printStackTrace();
            }
            try {
                str2 = e.getMessage();
            } catch (Throwable th) {
                com.anythink.expressad.foundation.h.o.b(f5892a, th.getMessage(), th);
                str2 = str;
            }
        }
        if (this.b == null) {
            Iterator<i.d> it = this.d.iterator();
            while (it.hasNext()) {
                i.d next = it.next();
                if (next != null) {
                    next.a(this.e, "mResDownloadingMap  is null");
                    this.d.remove(next);
                }
            }
            return;
        }
        str2 = str;
        if (this.b.containsKey(this.e)) {
            this.b.remove(this.e);
            str2 = str;
        }
        Iterator<i.d> it2 = this.d.iterator();
        while (it2.hasNext()) {
            i.d next2 = it2.next();
            if (next2 != null) {
                next2.a(this.e, str2);
                this.d.remove(next2);
            }
        }
    }

    @Override // com.anythink.expressad.videocommon.b.i.c
    public final void a(byte[] bArr, String str) {
        String str2;
        try {
        } catch (Exception e) {
            if (com.anythink.expressad.a.f4103a) {
                e.printStackTrace();
            }
            try {
                str2 = e.getMessage();
            } catch (Throwable th) {
                com.anythink.expressad.foundation.h.o.b(f5892a, th.getMessage(), th);
                str2 = "";
            }
        }
        if (this.b == null) {
            Iterator<i.d> it = this.d.iterator();
            while (it.hasNext()) {
                i.d next = it.next();
                if (next != null) {
                    next.a(str, "mResDownloadingMap  is null");
                    this.d.remove(next);
                }
            }
            return;
        }
        if (this.b.containsKey(str)) {
            this.b.remove(str);
        }
        if (bArr == null || bArr.length <= 0) {
            str2 = "response data is error";
        } else {
            String a2 = this.f5893c.a(str, bArr);
            if (TextUtils.isEmpty(a2)) {
                Iterator<i.d> it2 = this.d.iterator();
                while (it2.hasNext()) {
                    i.d next2 = it2.next();
                    if (next2 != null) {
                        next2.a(str);
                        this.d.remove(next2);
                    }
                }
                return;
            }
            str2 = "data save failed:".concat(String.valueOf(a2));
        }
        Iterator<i.d> it3 = this.d.iterator();
        while (it3.hasNext()) {
            i.d next3 = it3.next();
            if (next3 != null) {
                next3.a(str, str2);
            }
        }
    }
}
