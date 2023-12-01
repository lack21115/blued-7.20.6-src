package com.opos.mobad.n.g;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.opos.mobad.c.a;
import com.opos.mobad.n.a;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/n/g/x.class */
public class x extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    private int f13246a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private com.opos.mobad.n.c.b f13247c;
    private a.InterfaceC0538a d;

    public x(Context context, int i, int i2) {
        super(context);
        this.f13246a = i == 0 ? 256 : i;
        this.b = i2 == 0 ? 168 : i2;
        a();
    }

    public static x a(Context context, int i, int i2) {
        return new x(context, i, i2);
    }

    private void a() {
        int a2 = com.opos.cmn.an.h.f.a.a(getContext(), this.f13246a);
        int a3 = com.opos.cmn.an.h.f.a.a(getContext(), this.b);
        setLayoutParams(new ViewGroup.LayoutParams(a2, a3));
        this.f13247c = new com.opos.mobad.n.c.b(getContext(), 3);
        addView(this.f13247c, new RelativeLayout.LayoutParams(a2, a3));
    }

    private void a(com.opos.mobad.n.d.g gVar, com.opos.mobad.c.a aVar, final boolean z, final List<Bitmap> list) {
        aVar.a(gVar.f12945a, gVar.b, this.f13246a, this.b, new a.InterfaceC0506a() { // from class: com.opos.mobad.n.g.x.1
            @Override // com.opos.mobad.c.a.InterfaceC0506a
            public void a(int i, final Bitmap bitmap) {
                if (z) {
                    return;
                }
                if (i != 0 && i != 1) {
                    if (x.this.d != null) {
                        x.this.d.c(i);
                        return;
                    }
                    return;
                }
                if (i == 1 && x.this.d != null) {
                    x.this.d.c(i);
                }
                com.opos.mobad.c.b.b.a(new Runnable() { // from class: com.opos.mobad.n.g.x.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Bitmap bitmap2;
                        if (z || (bitmap2 = bitmap) == null || bitmap2.isRecycled()) {
                            return;
                        }
                        list.add(bitmap);
                        x.this.f13247c.a(list);
                    }
                });
            }
        });
    }

    public void a(a.InterfaceC0538a interfaceC0538a) {
        com.opos.cmn.an.f.a.b("BlockListImgHorizontalView", "setListener " + interfaceC0538a);
        this.d = interfaceC0538a;
        this.f13247c.a(new com.opos.mobad.n.c.g() { // from class: com.opos.mobad.n.g.x.2
            @Override // com.opos.mobad.n.c.g
            public void a(View view, int[] iArr) {
                if (x.this.d != null) {
                    x.this.d.g(view, iArr);
                }
            }
        });
    }

    public void a(com.opos.mobad.n.d.d dVar, com.opos.mobad.c.a aVar, boolean z) {
        if (dVar == null || dVar.g == null || dVar.g.size() == 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= Math.min(dVar.g.size(), 3)) {
                this.f13247c.a(dVar.z);
                return;
            }
            com.opos.mobad.n.d.g gVar = dVar.g.get(i2);
            if (gVar != null) {
                a(gVar, aVar, z, arrayList);
            }
            i = i2 + 1;
        }
    }
}
