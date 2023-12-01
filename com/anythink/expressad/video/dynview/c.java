package com.anythink.expressad.video.dynview;

import android.content.Context;
import android.view.View;
import java.util.List;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/video/dynview/c.class */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    private Context f5514a;
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private int f5515c;
    private float d;
    private float e;
    private int f;
    private int g;
    private View h;
    private List<com.anythink.expressad.foundation.d.c> i;
    private int j;
    private boolean k;
    private String l;
    private int m;

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/video/dynview/c$a.class */
    public static final class a implements b {

        /* renamed from: a  reason: collision with root package name */
        private Context f5516a;
        private String b;

        /* renamed from: c  reason: collision with root package name */
        private int f5517c;
        private float d;
        private float e;
        private int f;
        private int g;
        private View h;
        private List<com.anythink.expressad.foundation.d.c> i;
        private int j;
        private boolean k;
        private String l;
        private int m;

        @Override // com.anythink.expressad.video.dynview.c.b
        public final b a(float f) {
            this.d = f;
            return this;
        }

        @Override // com.anythink.expressad.video.dynview.c.b
        public final b a(int i) {
            this.f5517c = i;
            return this;
        }

        @Override // com.anythink.expressad.video.dynview.c.b
        public final b a(Context context) {
            this.f5516a = context.getApplicationContext();
            return this;
        }

        @Override // com.anythink.expressad.video.dynview.c.b
        public final b a(View view) {
            this.h = view;
            return this;
        }

        @Override // com.anythink.expressad.video.dynview.c.b
        public final b a(String str) {
            this.b = str;
            return this;
        }

        @Override // com.anythink.expressad.video.dynview.c.b
        public final b a(List<com.anythink.expressad.foundation.d.c> list) {
            this.i = list;
            return this;
        }

        @Override // com.anythink.expressad.video.dynview.c.b
        public final b a(boolean z) {
            this.k = z;
            return this;
        }

        @Override // com.anythink.expressad.video.dynview.c.b
        public final c a() {
            return new c(this, (byte) 0);
        }

        @Override // com.anythink.expressad.video.dynview.c.b
        public final b b(float f) {
            this.e = f;
            return this;
        }

        @Override // com.anythink.expressad.video.dynview.c.b
        public final b b(int i) {
            this.f = i;
            return this;
        }

        @Override // com.anythink.expressad.video.dynview.c.b
        public final b b(String str) {
            this.l = str;
            return this;
        }

        @Override // com.anythink.expressad.video.dynview.c.b
        public final b c(int i) {
            this.g = i;
            return this;
        }

        @Override // com.anythink.expressad.video.dynview.c.b
        public final b d(int i) {
            this.j = i;
            return this;
        }

        @Override // com.anythink.expressad.video.dynview.c.b
        public final b e(int i) {
            this.m = i;
            return this;
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/video/dynview/c$b.class */
    public interface b {
        b a(float f);

        b a(int i);

        b a(Context context);

        b a(View view);

        b a(String str);

        b a(List<com.anythink.expressad.foundation.d.c> list);

        b a(boolean z);

        c a();

        b b(float f);

        b b(int i);

        b b(String str);

        b c(int i);

        b d(int i);

        b e(int i);
    }

    private c(a aVar) {
        this.e = aVar.e;
        this.d = aVar.d;
        this.f = aVar.f;
        this.g = aVar.g;
        this.f5514a = aVar.f5516a;
        this.b = aVar.b;
        this.f5515c = aVar.f5517c;
        this.h = aVar.h;
        this.i = aVar.i;
        this.j = aVar.j;
        this.k = aVar.k;
    }

    /* synthetic */ c(a aVar, byte b2) {
        this(aVar);
    }

    private static a l() {
        return new a();
    }

    public final Context a() {
        return this.f5514a;
    }

    public final String b() {
        return this.b;
    }

    public final float c() {
        return this.d;
    }

    public final float d() {
        return this.e;
    }

    public final int e() {
        return this.f;
    }

    public final View f() {
        return this.h;
    }

    public final List<com.anythink.expressad.foundation.d.c> g() {
        return this.i;
    }

    public final int h() {
        return this.f5515c;
    }

    public final int i() {
        return this.j;
    }

    public final int j() {
        return this.g;
    }

    public final boolean k() {
        return this.k;
    }
}
