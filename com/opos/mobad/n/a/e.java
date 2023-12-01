package com.opos.mobad.n.a;

import android.view.View;
import com.opos.mobad.n.d;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/n/a/e.class */
public abstract class e implements com.opos.mobad.n.d {

    /* renamed from: a  reason: collision with root package name */
    private d.a f26500a;

    public e(List<View> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        for (View view : list) {
            com.opos.mobad.n.c.g gVar = new com.opos.mobad.n.c.g() { // from class: com.opos.mobad.n.a.e.1
                @Override // com.opos.mobad.n.c.g
                public void a(View view2, int[] iArr) {
                    if (e.this.f26500a != null) {
                        e.this.f26500a.a(view2, iArr);
                    }
                }
            };
            view.setOnClickListener(gVar);
            view.setOnTouchListener(gVar);
        }
    }

    @Override // com.opos.mobad.n.d
    public void a(d.a aVar) {
        this.f26500a = aVar;
    }
}
