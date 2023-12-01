package com.opos.mobad.q.a.f.c;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.opos.mobad.cmn.a.b.g;
import com.opos.mobad.model.data.AdItemData;
import com.opos.mobad.model.data.MaterialData;
import com.opos.mobad.model.data.MaterialFileData;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/q/a/f/c/c.class */
public class c extends a {
    private ImageView j;
    private Bitmap k;

    public c(Context context, com.opos.mobad.q.a.c.a aVar) {
        super(context, aVar);
        this.k = null;
    }

    private void b() {
        ImageView imageView = new ImageView(this.f25896a);
        this.j = imageView;
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.i.addView(this.j, new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f25896a, 360.0f), com.opos.cmn.an.h.f.a.a(this.f25896a, 85.0f)));
    }

    public void a(AdItemData adItemData, boolean z) {
        MaterialData materialData;
        if (adItemData == null || (materialData = adItemData.i().get(0)) == null) {
            return;
        }
        a(this.j, adItemData, com.opos.mobad.cmn.a.b.a.NonClickBt);
        List<MaterialFileData> f = materialData.f();
        if (f == null || f.size() <= 0 || f.get(0) == null) {
            return;
        }
        Bitmap a2 = g.a(f.get(0).a(), com.opos.cmn.an.h.f.a.a(this.f25896a, 360.0f), com.opos.cmn.an.h.f.a.a(this.f25896a, 85.0f));
        this.k = a2;
        if (a2 != null) {
            this.j.setImageBitmap(a2);
        }
    }

    public void d(AdItemData adItemData) {
        a(adItemData, false);
    }

    @Override // com.opos.mobad.cmn.a.c
    public void g() {
        b();
    }

    @Override // com.opos.mobad.cmn.a.c
    public void h() {
        try {
            if (this.b != null) {
                this.i.removeView(this.b);
            }
            if (this.k != null && !this.k.isRecycled()) {
                this.k.recycle();
                this.k = null;
                com.opos.cmn.an.f.a.b("ImgTipBar", "mImgBitmap.recycle()");
            }
            a(this.j);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.b("ImgTipBar", "");
        }
    }

    @Override // com.opos.mobad.cmn.a.c
    public void i() {
    }
}
