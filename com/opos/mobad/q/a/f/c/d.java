package com.opos.mobad.q.a.f.c;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import com.bytedance.applog.tracker.Tracker;
import com.opos.mobad.cmn.a.b.g;
import com.opos.mobad.model.data.AdItemData;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/q/a/f/c/d.class */
public class d {
    protected c b;

    /* renamed from: c  reason: collision with root package name */
    protected b f13525c;
    protected com.opos.cmn.e.a.a.a d;
    private Context g;
    private com.opos.mobad.q.a.c.a h;
    private AdItemData i;
    private final String f = "TipBarTemplate";

    /* renamed from: a  reason: collision with root package name */
    protected int f13524a = 0;
    protected int[] e = new int[4];

    public d(Context context, com.opos.mobad.q.a.c.a aVar) {
        this.g = context.getApplicationContext();
        this.h = aVar;
        b();
    }

    private void a(View view, final AdItemData adItemData, final com.opos.mobad.cmn.a.b.a aVar) {
        if (view != null) {
            view.setOnTouchListener(new com.opos.cmn.e.a.a.b(this.e));
            view.setOnClickListener(new View.OnClickListener() { // from class: com.opos.mobad.q.a.f.c.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    Tracker.onClick(view2);
                    if (g.a(adItemData, aVar)) {
                        d.this.h.a(view2, d.this.e, aVar);
                    }
                }
            });
        }
    }

    private View b(AdItemData adItemData) {
        try {
            if (!c(adItemData)) {
                this.f13524a = 0;
                this.d.setText(g.a(this.g, this.i, false));
                a(this.d, adItemData, com.opos.mobad.cmn.a.b.a.ClickBt);
                return this.d;
            } else if (adItemData != null) {
                int G = adItemData.i().get(0).G();
                if (G == 0) {
                    this.f13524a = 2;
                    this.b.d(adItemData);
                    return this.b.a();
                } else if (G != 1) {
                    return null;
                } else {
                    this.f13524a = 1;
                    this.f13525c.d(adItemData);
                    return this.f13525c.a();
                }
            } else {
                return null;
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("TipBarTemplate", "", (Throwable) e);
            return null;
        }
    }

    private void b() {
        this.b = new c(this.g, this.h);
        this.f13525c = new b(this.g, this.h);
        com.opos.cmn.e.a.a.a aVar = new com.opos.cmn.e.a.a.a(this.g, "opos_module_biz_ui_reward_video_click_bn_normal_img.png", "opos_module_biz_ui_reward_video_click_bn_pressed_img.png");
        this.d = aVar;
        aVar.setGravity(17);
        this.d.setTextColor(Color.parseColor("#ffffff"));
        this.d.setTextSize(1, 15.0f);
        this.d.setSingleLine();
        this.d.setVisibility(8);
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x009d, code lost:
        if (com.opos.cmn.an.c.a.a(r0.get(0).a()) == false) goto L4;
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x00a4 -> B:29:0x00ac). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean c(com.opos.mobad.model.data.AdItemData r5) {
        /*
            r4 = this;
            r0 = 1
            r7 = r0
            r0 = r5
            if (r0 == 0) goto Lac
            r0 = r5
            java.util.List r0 = r0.i()     // Catch: java.lang.Exception -> La3
            r1 = 0
            java.lang.Object r0 = r0.get(r1)     // Catch: java.lang.Exception -> La3
            com.opos.mobad.model.data.MaterialData r0 = (com.opos.mobad.model.data.MaterialData) r0     // Catch: java.lang.Exception -> La3
            int r0 = r0.G()     // Catch: java.lang.Exception -> La3
            r6 = r0
            r0 = r6
            if (r0 == 0) goto L61
            r0 = r6
            r1 = 1
            if (r0 == r1) goto L23
            goto Lac
        L23:
            r0 = r5
            java.util.List r0 = r0.i()     // Catch: java.lang.Exception -> La3
            r1 = 0
            java.lang.Object r0 = r0.get(r1)     // Catch: java.lang.Exception -> La3
            com.opos.mobad.model.data.MaterialData r0 = (com.opos.mobad.model.data.MaterialData) r0     // Catch: java.lang.Exception -> La3
            java.util.List r0 = r0.j()     // Catch: java.lang.Exception -> La3
            r5 = r0
            r0 = r5
            if (r0 == 0) goto Lac
            r0 = r5
            int r0 = r0.size()     // Catch: java.lang.Exception -> La3
            if (r0 <= 0) goto Lac
            r0 = r5
            r1 = 0
            java.lang.Object r0 = r0.get(r1)     // Catch: java.lang.Exception -> La3
            if (r0 == 0) goto Lac
            r0 = r5
            r1 = 0
            java.lang.Object r0 = r0.get(r1)     // Catch: java.lang.Exception -> La3
            com.opos.mobad.model.data.MaterialFileData r0 = (com.opos.mobad.model.data.MaterialFileData) r0     // Catch: java.lang.Exception -> La3
            java.lang.String r0 = r0.a()     // Catch: java.lang.Exception -> La3
            boolean r0 = com.opos.cmn.an.c.a.a(r0)     // Catch: java.lang.Exception -> La3
            if (r0 != 0) goto Lac
            goto Lae
        L61:
            r0 = r5
            java.util.List r0 = r0.i()     // Catch: java.lang.Exception -> La3
            r1 = 0
            java.lang.Object r0 = r0.get(r1)     // Catch: java.lang.Exception -> La3
            com.opos.mobad.model.data.MaterialData r0 = (com.opos.mobad.model.data.MaterialData) r0     // Catch: java.lang.Exception -> La3
            java.util.List r0 = r0.f()     // Catch: java.lang.Exception -> La3
            r5 = r0
            r0 = r5
            if (r0 == 0) goto Lac
            r0 = r5
            int r0 = r0.size()     // Catch: java.lang.Exception -> La3
            if (r0 <= 0) goto Lac
            r0 = r5
            r1 = 0
            java.lang.Object r0 = r0.get(r1)     // Catch: java.lang.Exception -> La3
            if (r0 == 0) goto Lac
            r0 = r5
            r1 = 0
            java.lang.Object r0 = r0.get(r1)     // Catch: java.lang.Exception -> La3
            com.opos.mobad.model.data.MaterialFileData r0 = (com.opos.mobad.model.data.MaterialFileData) r0     // Catch: java.lang.Exception -> La3
            java.lang.String r0 = r0.a()     // Catch: java.lang.Exception -> La3
            boolean r0 = com.opos.cmn.an.c.a.a(r0)     // Catch: java.lang.Exception -> La3
            r8 = r0
            r0 = r8
            if (r0 != 0) goto Lac
            goto Lae
        La3:
            r5 = move-exception
            java.lang.String r0 = "TipBarTemplate"
            java.lang.String r1 = ""
            r2 = r5
            com.opos.cmn.an.f.a.a(r0, r1, r2)
        Lac:
            r0 = 0
            r7 = r0
        Lae:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r0
            r1.<init>()
            r5 = r0
            r0 = r5
            java.lang.String r1 = "hasTipBarMaterial="
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r5
            r1 = r7
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = "TipBarTemplate"
            r1 = r5
            java.lang.String r1 = r1.toString()
            com.opos.cmn.an.f.a.b(r0, r1)
            r0 = r7
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.mobad.q.a.f.c.d.c(com.opos.mobad.model.data.AdItemData):boolean");
    }

    public View a() {
        return b(this.i);
    }

    public void a(AdItemData adItemData) {
        this.i = adItemData;
    }

    public void a(String str) {
        com.opos.cmn.e.a.a.a aVar;
        b bVar;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        int i = this.f13524a;
        if (i == 0) {
            aVar = this.d;
        } else if (i != 1 || (bVar = this.f13525c) == null || bVar.b() == null) {
            return;
        } else {
            aVar = this.f13525c.b();
        }
        aVar.setText(str);
    }
}
