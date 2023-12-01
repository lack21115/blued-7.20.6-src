package com.anythink.core.common.res;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import com.anythink.core.common.b.n;
import com.anythink.core.common.k.f;
import com.anythink.core.common.res.image.a;
import java.io.FileInputStream;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/res/b.class */
public class b {
    private static final String b = "ImageLoader";
    private static volatile b c;
    Context a;
    private Map<String, Integer> d;
    private c<String, SoftReference<Bitmap>> e;
    private final Object f = new Object();
    private LinkedHashMap<String, List<a>> g = new LinkedHashMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.anythink.core.common.res.b$1  reason: invalid class name */
    /* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/res/b$1.class */
    public final class AnonymousClass1 implements Runnable {
        final /* synthetic */ Bitmap a;
        final /* synthetic */ a b;
        final /* synthetic */ String c;

        AnonymousClass1(Bitmap bitmap, a aVar, String str) {
            this.a = bitmap;
            this.b = aVar;
            this.c = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Bitmap bitmap = this.a;
            if (bitmap != null) {
                this.b.onSuccess(this.c, bitmap);
            } else {
                this.b.onFail(this.c, "Bitmap load fail");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.anythink.core.common.res.b$2  reason: invalid class name */
    /* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/res/b$2.class */
    public final class AnonymousClass2 implements Runnable {
        final /* synthetic */ a a;
        final /* synthetic */ String b;
        final /* synthetic */ String c;

        AnonymousClass2(a aVar, String str, String str2) {
            this.a = aVar;
            this.b = str;
            this.c = str2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.onFail(this.b, this.c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.anythink.core.common.res.b$5  reason: invalid class name */
    /* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/res/b$5.class */
    public final class AnonymousClass5 implements a.InterfaceC0069a {
        final /* synthetic */ int a;
        final /* synthetic */ int b;
        final /* synthetic */ e c;

        AnonymousClass5(int i, int i2, e eVar) {
            this.a = i;
            this.b = i2;
            this.c = eVar;
        }

        @Override // com.anythink.core.common.res.image.a.InterfaceC0069a
        public final void a(e eVar) {
            new StringBuilder("Load Success:").append(eVar.f);
            Bitmap a = b.this.a(eVar, this.a, this.b);
            if (a != null) {
                b.this.a(eVar.f, a);
            }
            b.a(b.this, this.c.f, a);
        }

        @Override // com.anythink.core.common.res.image.a.InterfaceC0069a
        public final void a(e eVar, String str) {
            b.a(b.this, eVar.f, str);
        }
    }

    /* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/res/b$a.class */
    public interface a {
        void onFail(String str, String str2);

        void onSuccess(String str, Bitmap bitmap);
    }

    private b(Context context) {
        this.a = context.getApplicationContext();
        int maxMemory = ((int) Runtime.getRuntime().maxMemory()) / 5;
        StringBuilder sb = new StringBuilder("ImageLoad init cache size: ");
        sb.append(maxMemory);
        sb.append("B");
        this.e = new c<String, SoftReference<Bitmap>>(maxMemory) { // from class: com.anythink.core.common.res.b.3
            /* renamed from: a  reason: avoid collision after fix types in other method */
            private int a2(String str, SoftReference<Bitmap> softReference) {
                Bitmap bitmap = softReference != null ? softReference.get() : null;
                if (b.this.d == null) {
                    b.this.d = new HashMap(8);
                }
                if (bitmap != null) {
                    int rowBytes = bitmap.getRowBytes() * bitmap.getHeight();
                    b.this.d.put(str, Integer.valueOf(rowBytes));
                    return rowBytes;
                }
                Integer num = (Integer) b.this.d.get(str);
                if (num != null) {
                    return num.intValue();
                }
                return 0;
            }

            /* renamed from: a  reason: avoid collision after fix types in other method */
            private void a2(boolean z, String str, SoftReference<Bitmap> softReference, SoftReference<Bitmap> softReference2) {
                Bitmap bitmap;
                super.a(z, (boolean) str, softReference, softReference2);
                if (softReference != null) {
                    try {
                        bitmap = softReference.get();
                    } catch (Exception e) {
                        return;
                    }
                } else {
                    bitmap = null;
                }
                if (b.this.d != null) {
                    b.this.d.remove(str);
                }
                if (softReference == null || softReference.equals(softReference2) || bitmap == null || bitmap.isRecycled()) {
                    return;
                }
                bitmap.recycle();
            }

            @Override // com.anythink.core.common.res.c
            protected final /* synthetic */ int a(String str, SoftReference<Bitmap> softReference) {
                String str2 = str;
                SoftReference<Bitmap> softReference2 = softReference;
                Bitmap bitmap = softReference2 != null ? softReference2.get() : null;
                if (b.this.d == null) {
                    b.this.d = new HashMap(8);
                }
                if (bitmap != null) {
                    int rowBytes = bitmap.getRowBytes() * bitmap.getHeight();
                    b.this.d.put(str2, Integer.valueOf(rowBytes));
                    return rowBytes;
                }
                Integer num = (Integer) b.this.d.get(str2);
                if (num != null) {
                    return num.intValue();
                }
                return 0;
            }

            @Override // com.anythink.core.common.res.c
            protected final /* synthetic */ void a(boolean z, String str, SoftReference<Bitmap> softReference, SoftReference<Bitmap> softReference2) {
                Bitmap bitmap;
                String str2 = str;
                SoftReference<Bitmap> softReference3 = softReference;
                SoftReference<Bitmap> softReference4 = softReference2;
                super.a(z, (boolean) str2, softReference3, softReference4);
                if (softReference3 != null) {
                    try {
                        bitmap = softReference3.get();
                    } catch (Exception e) {
                        return;
                    }
                } else {
                    bitmap = null;
                }
                if (b.this.d != null) {
                    b.this.d.remove(str2);
                }
                if (softReference3 == null || softReference3.equals(softReference4) || bitmap == null || bitmap.isRecycled()) {
                    return;
                }
                bitmap.recycle();
            }
        };
    }

    private Bitmap a(String str) {
        SoftReference<Bitmap> a2 = this.e.a((c<String, SoftReference<Bitmap>>) str);
        if (a2 != null) {
            return a2.get();
        }
        return null;
    }

    public static b a(Context context) {
        if (c == null) {
            synchronized (b.class) {
                try {
                    if (c == null) {
                        c = new b(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return c;
    }

    private void a() {
        try {
            if (this.e != null) {
                this.e.a();
            }
            if (this.g != null) {
                this.g.clear();
            }
        } catch (Exception e) {
        }
    }

    static /* synthetic */ void a(b bVar, e eVar, int i, int i2, a aVar) {
        synchronized (bVar.g) {
            if (bVar.g.containsKey(eVar.f)) {
                LinkedList linkedList = (LinkedList) bVar.g.get(eVar.f);
                if (linkedList != null && !linkedList.contains(aVar)) {
                    linkedList.add(aVar);
                }
            } else {
                LinkedList linkedList2 = new LinkedList();
                linkedList2.add(aVar);
                bVar.g.put(eVar.f, linkedList2);
                com.anythink.core.common.res.image.a aVar2 = new com.anythink.core.common.res.image.a(eVar);
                aVar2.a(new AnonymousClass5(i, i2, eVar));
                aVar2.d();
            }
        }
    }

    static /* synthetic */ void a(b bVar, String str, Bitmap bitmap) {
        synchronized (bVar.g) {
            LinkedList linkedList = (LinkedList) bVar.g.remove(str);
            if (linkedList != null) {
                Iterator<E> it = linkedList.iterator();
                while (it.hasNext()) {
                    a aVar = (a) it.next();
                    if (aVar != null) {
                        n.a().a(new AnonymousClass1(bitmap, aVar, str));
                    }
                }
            }
        }
    }

    static /* synthetic */ void a(b bVar, String str, String str2) {
        synchronized (bVar.g) {
            LinkedList linkedList = (LinkedList) bVar.g.remove(str);
            if (linkedList != null) {
                Iterator<E> it = linkedList.iterator();
                while (it.hasNext()) {
                    a aVar = (a) it.next();
                    if (aVar != null) {
                        n.a().a(new AnonymousClass2(aVar, str, str2));
                    }
                }
            }
        }
    }

    private void a(String str, String str2) {
        synchronized (this.g) {
            LinkedList linkedList = (LinkedList) this.g.remove(str);
            if (linkedList != null) {
                Iterator<E> it = linkedList.iterator();
                while (it.hasNext()) {
                    a aVar = (a) it.next();
                    if (aVar != null) {
                        n.a().a(new AnonymousClass2(aVar, str, str2));
                    }
                }
            }
        }
    }

    private void b(e eVar, int i, int i2, a aVar) {
        synchronized (this.g) {
            if (this.g.containsKey(eVar.f)) {
                LinkedList linkedList = (LinkedList) this.g.get(eVar.f);
                if (linkedList != null && !linkedList.contains(aVar)) {
                    linkedList.add(aVar);
                }
            } else {
                LinkedList linkedList2 = new LinkedList();
                linkedList2.add(aVar);
                this.g.put(eVar.f, linkedList2);
                com.anythink.core.common.res.image.a aVar2 = new com.anythink.core.common.res.image.a(eVar);
                aVar2.a(new AnonymousClass5(i, i2, eVar));
                aVar2.d();
            }
        }
    }

    private void b(String str, Bitmap bitmap) {
        synchronized (this.g) {
            LinkedList linkedList = (LinkedList) this.g.remove(str);
            if (linkedList != null) {
                Iterator<E> it = linkedList.iterator();
                while (it.hasNext()) {
                    a aVar = (a) it.next();
                    if (aVar != null) {
                        n.a().a(new AnonymousClass1(bitmap, aVar, str));
                    }
                }
            }
        }
    }

    public final Bitmap a(e eVar, int i, int i2) {
        int i3;
        Bitmap bitmap;
        Bitmap a2;
        if (eVar == null || TextUtils.isEmpty(eVar.f)) {
            return null;
        }
        String a3 = f.a(eVar.f);
        int i4 = i;
        if (i <= 0) {
            try {
                i4 = this.a.getResources().getDisplayMetrics().widthPixels;
            } catch (Throwable th) {
                i3 = i2;
            }
        }
        i = i4;
        i3 = i2;
        if (i2 <= 0) {
            i = i4;
            i3 = this.a.getResources().getDisplayMetrics().heightPixels;
            i = i4;
        }
        synchronized (this.f) {
            FileInputStream a4 = d.a(this.a).a(eVar.e, a3);
            if (a4 == null) {
                return null;
            }
            try {
                a2 = com.anythink.core.common.k.b.a(a4.getFD(), i, i3);
                bitmap = a2;
            } catch (Throwable th2) {
                bitmap = null;
                if (a4 != null) {
                    bitmap = null;
                }
            }
            if (a4 != null) {
                bitmap = a2;
                try {
                    a4.close();
                } catch (Exception e) {
                }
            }
            return bitmap;
        }
    }

    public final void a(final e eVar, final int i, final int i2, final a aVar) {
        if (eVar == null || TextUtils.isEmpty(eVar.f)) {
            if (aVar != null) {
                aVar.onFail("", "No url info.");
                return;
            }
            return;
        }
        Bitmap a2 = a(eVar.f);
        if (a2 == null || a2.isRecycled()) {
            com.anythink.core.common.k.b.a.a().a(new Runnable() { // from class: com.anythink.core.common.res.b.4
                @Override // java.lang.Runnable
                public final void run() {
                    Bitmap a3 = b.this.a(eVar, i, i2);
                    if (a3 == null || a3.isRecycled()) {
                        b.a(b.this, eVar, i, i2, aVar);
                        return;
                    }
                    StringBuilder sb = new StringBuilder("url image [");
                    sb.append(eVar.f);
                    sb.append("] is downloaded");
                    b.this.a(eVar.f, a3);
                    LinkedList linkedList = new LinkedList();
                    linkedList.add(aVar);
                    b.this.g.put(eVar.f, linkedList);
                    b.a(b.this, eVar.f, a3);
                }
            });
        } else {
            aVar.onSuccess(eVar.f, a2);
        }
    }

    public final void a(e eVar, a aVar) {
        a(eVar, -1, -1, aVar);
    }

    public final void a(String str, Bitmap bitmap) {
        if (a(str) != null || bitmap == null) {
            return;
        }
        this.e.b(str, new SoftReference<>(bitmap));
    }
}
