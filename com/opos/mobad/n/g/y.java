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

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/n/g/y.class */
public class y extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    private int f26940a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private com.opos.mobad.n.c.a f26941c;
    private a.InterfaceC0708a d;

    public y(Context context, int i, int i2, boolean z, boolean z2) {
        super(context);
        this.f26940a = i == 0 ? 256 : i;
        this.b = i2 == 0 ? 168 : i2;
        a(z, z2);
    }

    public static y a(Context context, int i, int i2, boolean z) {
        return new y(context, i, i2, z, false);
    }

    private void a(com.opos.mobad.n.d.g gVar, com.opos.mobad.c.a aVar, final boolean z, final List<Bitmap> list) {
        aVar.a(gVar.f26633a, gVar.b, this.f26940a, this.b, new a.InterfaceC0676a() { // from class: com.opos.mobad.n.g.y.1
            @Override // com.opos.mobad.c.a.InterfaceC0676a
            public void a(int i, final Bitmap bitmap) {
                if (z) {
                    return;
                }
                if (i != 0 && i != 1) {
                    if (y.this.d != null) {
                        y.this.d.c(i);
                        return;
                    }
                    return;
                }
                if (i == 1 && y.this.d != null) {
                    y.this.d.c(i);
                }
                com.opos.mobad.c.b.b.a(new Runnable() { // from class: com.opos.mobad.n.g.y.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Bitmap bitmap2;
                        if (z || (bitmap2 = bitmap) == null || bitmap2.isRecycled()) {
                            return;
                        }
                        list.add(bitmap);
                        y.this.f26941c.a(list);
                    }
                });
            }
        });
    }

    private void a(boolean z, boolean z2) {
        int a2 = com.opos.cmn.an.h.f.a.a(getContext(), this.f26940a);
        int a3 = com.opos.cmn.an.h.f.a.a(getContext(), this.b);
        setLayoutParams(new ViewGroup.LayoutParams(a2, a3));
        this.f26941c = z2 ? com.opos.mobad.n.c.a.b(getContext(), 3, z) : com.opos.mobad.n.c.a.a(getContext(), 3, z);
        addView(this.f26941c, new RelativeLayout.LayoutParams(a2, a3));
    }

    public static y b(Context context, int i, int i2, boolean z) {
        return new y(context, i, i2, z, true);
    }

    public void a(a.InterfaceC0708a interfaceC0708a) {
        com.opos.cmn.an.f.a.b("BlockListImgView", "setListener " + interfaceC0708a);
        this.d = interfaceC0708a;
        this.f26941c.a(new com.opos.mobad.n.c.g() { // from class: com.opos.mobad.n.g.y.2
            @Override // com.opos.mobad.n.c.g
            public void a(View view, int[] iArr) {
                if (y.this.d != null) {
                    y.this.d.g(view, iArr);
                }
            }
        });
    }

    public void a(com.opos.mobad.n.d.d dVar, com.opos.mobad.c.a aVar, boolean z, int i) {
        if (dVar == null || dVar.g == null || dVar.g.size() == 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= Math.min(dVar.g.size(), 3)) {
                this.f26941c.a(i);
                return;
            }
            com.opos.mobad.n.d.g gVar = dVar.g.get(i3);
            if (gVar != null) {
                a(gVar, aVar, z, arrayList);
            }
            i2 = i3 + 1;
        }
    }
}
