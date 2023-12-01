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
    private TextView f13097a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private a.InterfaceC0538a f13098c;
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
        this.f13097a = new TextView(getContext());
        com.opos.mobad.n.c.g gVar = new com.opos.mobad.n.c.g() { // from class: com.opos.mobad.n.g.ah.1
            @Override // com.opos.mobad.n.c.g
            public void a(View view, int[] iArr) {
                if (ah.this.f13098c != null) {
                    ah.this.b();
                    a.InterfaceC0538a interfaceC0538a = ah.this.f13098c;
                    boolean z = true;
                    if (ah.this.b != 1) {
                        z = false;
                    }
                    interfaceC0538a.a(view, iArr, z);
                }
            }
        };
        this.f13097a.setOnClickListener(gVar);
        this.f13097a.setOnTouchListener(gVar);
        this.f13097a.setBackground(getContext().getResources().getDrawable(R.drawable.opos_mobad_drawable_block_sound_off));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(getContext(), 16.0f), com.opos.cmn.an.h.f.a.a(getContext(), 16.0f));
        layoutParams.rightMargin = com.opos.cmn.an.h.f.a.a(getContext(), 10.0f);
        addView(this.f13097a, layoutParams);
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
        TextView textView = this.f13097a;
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

    public void a(a.InterfaceC0538a interfaceC0538a) {
        this.f13098c = interfaceC0538a;
    }

    public void a(ad.a aVar) {
        this.d = aVar;
    }
}
