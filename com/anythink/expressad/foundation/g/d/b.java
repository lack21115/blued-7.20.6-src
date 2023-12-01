package com.anythink.expressad.foundation.g.d;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.anythink.expressad.foundation.g.d.d;
import com.anythink.expressad.foundation.h.o;
import com.anythink.expressad.foundation.h.s;
import com.anythink.expressad.foundation.h.t;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/foundation/g/d/b.class */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static final String f7848a = "ImageLoader";
    private static final int b = 1;

    /* renamed from: c  reason: collision with root package name */
    private static final int f7849c = 2;
    private static final String d = "message_key";
    private static final String e = "message_bitmap";
    private static final String f = "message_message";
    private static b g;
    private com.anythink.expressad.foundation.g.g.c h;
    private LinkedHashMap<String, List<c>> j = new LinkedHashMap<>();
    private Handler k = new Handler(Looper.getMainLooper()) { // from class: com.anythink.expressad.foundation.g.d.b.1
        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            try {
                if (message.what == 1) {
                    String string = message.getData().getString(b.d);
                    Bitmap a2 = a.a(message.getData().getString(b.e));
                    b.this.a(string, a2);
                    LinkedList linkedList = (LinkedList) b.this.j.get(string);
                    if (linkedList != null) {
                        Iterator<E> it = linkedList.iterator();
                        while (it.hasNext()) {
                            c cVar = (c) it.next();
                            if (cVar != null) {
                                cVar.a(a2, string);
                            }
                        }
                    }
                    b.this.j.remove(string);
                } else if (message.what == 2) {
                    String string2 = message.getData().getString(b.d);
                    String string3 = message.getData().getString(b.f);
                    LinkedList linkedList2 = (LinkedList) b.this.j.get(string2);
                    if (linkedList2 != null) {
                        Iterator<E> it2 = linkedList2.iterator();
                        while (it2.hasNext()) {
                            c cVar2 = (c) it2.next();
                            if (cVar2 != null) {
                                cVar2.a(string3, string2);
                            }
                        }
                    }
                    b.this.j.remove(string2);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    };
    private com.anythink.expressad.foundation.g.a.e<String, Bitmap> i = new com.anythink.expressad.foundation.g.a.c(((int) Runtime.getRuntime().maxMemory()) / 5);

    private b(Context context) {
        this.h = new com.anythink.expressad.foundation.g.g.c(context);
    }

    public static b a(Context context) {
        if (g == null) {
            g = new b(context);
        }
        return g;
    }

    private d a(String str, String str2, String str3, boolean z) {
        d.a aVar = new d.a() { // from class: com.anythink.expressad.foundation.g.d.b.2
            @Override // com.anythink.expressad.foundation.g.d.d.a
            public final void a(String str4, String str5) {
                Message obtainMessage = b.this.k.obtainMessage();
                obtainMessage.what = 1;
                Bundle bundle = new Bundle();
                bundle.putString(b.d, str4);
                bundle.putString(b.e, str5);
                obtainMessage.setData(bundle);
                b.this.k.sendMessage(obtainMessage);
            }

            @Override // com.anythink.expressad.foundation.g.d.d.a
            public final void b(String str4, String str5) {
                Message obtainMessage = b.this.k.obtainMessage();
                obtainMessage.what = 2;
                Bundle bundle = new Bundle();
                bundle.putString(b.d, str4);
                bundle.putString(b.f, str5);
                obtainMessage.setData(bundle);
                b.this.k.sendMessage(obtainMessage);
            }
        };
        d dVar = new d(str, str2, str3);
        dVar.a(z);
        dVar.a(aVar);
        return dVar;
    }

    public static void a() {
        com.anythink.expressad.foundation.g.a.e<String, Bitmap> eVar = g.i;
        if (eVar != null) {
            eVar.b();
        }
    }

    private void a(String str, String str2, String str3, c cVar) {
        b(str, str2, str3, cVar);
    }

    private void a(String str, String str2, String str3, boolean z, c cVar) {
        if (this.j.containsKey(str2)) {
            LinkedList linkedList = (LinkedList) this.j.get(str2);
            if (linkedList == null || linkedList.contains(cVar)) {
                return;
            }
            linkedList.add(cVar);
            return;
        }
        LinkedList linkedList2 = new LinkedList();
        linkedList2.add(cVar);
        this.j.put(str2, linkedList2);
        this.h.a(a(str, str2, str3, z));
    }

    private void b() {
        this.i.b();
        LinkedHashMap<String, List<c>> linkedHashMap = this.j;
        if (linkedHashMap != null) {
            linkedHashMap.clear();
        }
    }

    private void b(String str, String str2, String str3, c cVar) {
        if (t.a(str) || t.a(str2) || t.a(str3)) {
            return;
        }
        File file = new File(str3);
        Bitmap a2 = a(str2);
        if (a2 != null && !a2.isRecycled()) {
            cVar.a(a2, str);
        } else if (!file.exists()) {
            a(str, str2, str3, false, cVar);
        } else {
            Bitmap a3 = a.a(str3);
            if (a3 == null || a3.isRecycled()) {
                a(str, str2, str3, true, cVar);
                return;
            }
            a(str2, a3);
            cVar.a(a3, str);
        }
    }

    private void c() {
        com.anythink.expressad.foundation.g.a.e<String, Bitmap> eVar = this.i;
        if (eVar != null) {
            eVar.b();
        }
    }

    private Bitmap d(String str) {
        Bitmap a2;
        if (t.a(str)) {
            return null;
        }
        String a3 = s.a(str);
        File file = new File(a3);
        if (a(str) != null) {
            return a(str);
        }
        if (!file.exists() || (a2 = a.a(a3)) == null) {
            return null;
        }
        a(str, a2);
        return a2;
    }

    public final Bitmap a(String str) {
        return this.i.b(str);
    }

    public final void a(String str, Bitmap bitmap) {
        if (a(str) != null || bitmap == null) {
            return;
        }
        this.i.a(str, bitmap);
    }

    public final void a(String str, c cVar) {
        b(str, str, s.a(str), cVar);
    }

    public final boolean b(String str) {
        if (t.a(str)) {
            return false;
        }
        return a(str) != null || new File(s.a(str)).exists();
    }

    public final void c(String str) {
        try {
            if (this.i == null || !this.i.a().contains(str)) {
                return;
            }
            this.i.a(str);
        } catch (Throwable th) {
            o.d(f7848a, th.getMessage());
        }
    }
}
