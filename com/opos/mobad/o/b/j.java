package com.opos.mobad.o.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.opos.mobad.model.data.AdItemData;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/o/b/j.class */
public class j extends h {
    private a H;

    /* renamed from: a  reason: collision with root package name */
    private volatile boolean f27068a;

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/o/b/j$a.class */
    interface a {
        void a(ImageView imageView, Bitmap bitmap);
    }

    public j(Context context, d dVar, FrameLayout frameLayout) {
        super(context, dVar, frameLayout, false);
        this.f27068a = false;
        this.H = new a() { // from class: com.opos.mobad.o.b.j.4
            @Override // com.opos.mobad.o.b.j.a
            public void a(final ImageView imageView, final Bitmap bitmap) {
                if (imageView == null || bitmap == null) {
                    return;
                }
                com.opos.mobad.service.c.a(new Runnable() { // from class: com.opos.mobad.o.b.j.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Bitmap bitmap2;
                        ImageView imageView2 = imageView;
                        if (imageView2 == null || (bitmap2 = bitmap) == null) {
                            return;
                        }
                        imageView2.setImageBitmap(bitmap2);
                        com.opos.cmn.an.f.a.b("MediaCreative", "mIImgLoaderResult success");
                    }
                });
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ai() {
        Drawable drawable;
        BitmapDrawable bitmapDrawable;
        if (this.l == null || (drawable = this.l.getDrawable()) == null) {
            return;
        }
        if ((drawable instanceof BitmapDrawable) && (bitmapDrawable = (BitmapDrawable) drawable) != null && bitmapDrawable.getBitmap() != null && !bitmapDrawable.getBitmap().isRecycled()) {
            bitmapDrawable.getBitmap().recycle();
            com.opos.cmn.an.f.a.b("MediaCreative", "recycle bitmap");
        }
        this.l.setImageDrawable(null);
    }

    @Override // com.opos.mobad.o.b.a
    protected void a() {
        if (this.n != null) {
            this.n.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.opos.mobad.o.b.j.1
                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewAttachedToWindow(View view) {
                }

                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewDetachedFromWindow(View view) {
                    if (k.a().a(j.this.A)) {
                        com.opos.cmn.an.f.a.b("MediaCreative", "onViewDetachedFromWindow release video");
                        k.a().c();
                    }
                    j.this.ai();
                }
            });
        }
    }

    @Override // com.opos.mobad.o.b.e
    public void a(View view, int[] iArr) {
        c(view, iArr);
    }

    @Override // com.opos.mobad.o.b.a
    public void a(View view, int[] iArr, int i) {
        c(view, iArr);
    }

    public void a(final AdItemData adItemData, final String str) {
        com.opos.cmn.an.f.a.b("MediaCreative", "playVideo url:" + str);
        if (adItemData != null) {
            this.f27042c = adItemData;
            this.A = str;
            if (adItemData.i().get(0) != null) {
                com.opos.mobad.service.c.c(new Runnable() { // from class: com.opos.mobad.o.b.j.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (j.this.f27068a) {
                            return;
                        }
                        j jVar = j.this;
                        jVar.a(jVar.l, 5);
                        j jVar2 = j.this;
                        jVar2.a(jVar2.n, 4);
                        k.a().a(j.this.b, str, adItemData.P(), j.this.n, j.this, false);
                    }
                });
            }
        }
    }

    @Override // com.opos.mobad.o.b.h
    protected void a(final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.o.b.j.3
            @Override // java.lang.Runnable
            public void run() {
                Bitmap a2 = com.opos.mobad.cmn.a.b.g.a(str, com.opos.cmn.an.h.f.a.b(j.this.b), (com.opos.cmn.an.h.f.a.b(j.this.b) * 9) / 16);
                if (a2 != null) {
                    j.this.H.a(j.this.l, a2);
                }
            }
        });
    }

    public void b() {
        com.opos.cmn.an.f.a.b("MediaCreative", "release video and ad");
        this.f27068a = true;
        W();
        S();
        T();
    }

    @Override // com.opos.mobad.o.b.e
    public void b(View view, int[] iArr) {
        c(view, iArr);
    }

    public void b(AdItemData adItemData) {
        ViewGroup.LayoutParams layoutParams;
        com.opos.cmn.an.f.a.b("MediaCreative", "renderInitCoverUI ");
        if (this.l == null) {
            this.l = new ImageView(this.b);
            this.l.setScaleType(ImageView.ScaleType.FIT_XY);
        }
        if (this.l.getParent() == null || this.l.getParent() == this.d) {
            if (this.l.getParent() == null) {
                layoutParams = new ViewGroup.LayoutParams(-1, -1);
            }
            a(adItemData);
            X();
        }
        ((ViewGroup) this.l.getParent()).removeView(this.l);
        layoutParams = new ViewGroup.LayoutParams(-1, -1);
        this.d.addView(this.l, layoutParams);
        a(this.l, 5);
        a(adItemData);
        X();
    }

    public void b(AdItemData adItemData, String str) {
        com.opos.cmn.an.f.a.b("MediaCreative", "playVideoWithoutCheckPlaying url:" + str);
        if (adItemData != null) {
            this.f27042c = adItemData;
            this.A = str;
            if (adItemData.i().get(0) != null) {
                a(this.l, 5);
                a(this.n, 4);
                X();
                k.a().b(this.b, str, adItemData.P(), this.n, this, false);
            }
        }
    }

    protected void c(View view, int[] iArr) {
        if (this.u != null) {
            this.u.a(view, iArr, k.a().e(this.A), com.opos.mobad.cmn.a.b.a.Video);
        }
    }
}
