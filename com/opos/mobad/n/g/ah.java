package com.opos.mobad.n.g;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.heytap.msp.mobad.api.R;
import com.opos.mobad.n.a;
import com.opos.mobad.n.g.ad;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/n/g/ah.class */
public class ah extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    private TextView f26785a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private a.InterfaceC0708a f26786c;
    private ad.a d;

    public ah(Context context) {
        super(context);
        this.b = 0;
        a();
    }

    public static ah a(Context context) {
        return new ah(context);
    }

    private void a() {
        this.f26785a = new TextView(getContext());
        com.opos.mobad.n.c.g gVar = new com.opos.mobad.n.c.g() { // from class: com.opos.mobad.n.g.ah.1
            @Override // com.opos.mobad.n.c.g
            public void a(View view, int[] iArr) {
                if (ah.this.f26786c != null) {
                    ah.this.b();
                    a.InterfaceC0708a interfaceC0708a = ah.this.f26786c;
                    boolean z = true;
                    if (ah.this.b != 1) {
                        z = false;
                    }
                    interfaceC0708a.a(view, iArr, z);
                }
            }
        };
        this.f26785a.setOnClickListener(gVar);
        this.f26785a.setOnTouchListener(gVar);
        this.f26785a.setBackground(getContext().getResources().getDrawable(R.drawable.opos_mobad_drawable_block_sound_off));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(getContext(), 16.0f), com.opos.cmn.an.h.f.a.a(getContext(), 16.0f));
        layoutParams.rightMargin = com.opos.cmn.an.h.f.a.a(getContext(), 10.0f);
        addView(this.f26785a, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        int i = this.b;
        int i2 = 1;
        if (i != 0) {
            i2 = i == 1 ? 0 : -1;
        }
        if (i2 == -1) {
            return;
        }
        ad.a aVar = this.d;
        if (aVar != null) {
            aVar.a(i2);
        }
        b(i2);
    }

    private void b(int i) {
        Resources resources;
        int i2;
        TextView textView = this.f26785a;
        if (textView == null || this.b == i) {
            return;
        }
        this.b = i;
        if (i == 0) {
            resources = getContext().getResources();
            i2 = R.drawable.opos_mobad_drawable_block_sound_off;
        } else if (i == 2) {
            textView.setVisibility(8);
            return;
        } else {
            resources = getContext().getResources();
            i2 = R.drawable.opos_mobad_drawable_block_sound_on;
        }
        textView.setBackground(resources.getDrawable(i2));
    }

    public void a(int i) {
        b(i);
    }

    public void a(a.InterfaceC0708a interfaceC0708a) {
        this.f26786c = interfaceC0708a;
    }

    public void a(ad.a aVar) {
        this.d = aVar;
    }
}
