package com.anythink.expressad.video.dynview.g;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Shader;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/video/dynview/g/a.class */
public final class a extends ShapeDrawable {

    /* renamed from: a  reason: collision with root package name */
    private int f8362a;
    private float b;

    /* renamed from: c  reason: collision with root package name */
    private float f8363c;
    private int d;
    private int e;
    private Bitmap f;
    private Bitmap g;
    private boolean h;
    private Paint i;

    /* renamed from: com.anythink.expressad.video.dynview.g.a$a  reason: collision with other inner class name */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/video/dynview/g/a$a.class */
    public static final class C0161a implements b {

        /* renamed from: a  reason: collision with root package name */
        private RectShape f8364a;
        private Bitmap b;

        /* renamed from: c  reason: collision with root package name */
        private Bitmap f8365c;
        private boolean d;
        private int e;
        private int f;
        private int g;
        private float h;
        private float i;

        private C0161a() {
            this.f = 100;
            this.g = 10;
            this.f8364a = new RectShape();
        }

        /* synthetic */ C0161a(byte b) {
            this();
        }

        @Override // com.anythink.expressad.video.dynview.g.a.b
        public final b a() {
            this.d = true;
            return this;
        }

        @Override // com.anythink.expressad.video.dynview.g.a.b
        public final b a(float f) {
            this.h = f;
            return this;
        }

        @Override // com.anythink.expressad.video.dynview.g.a.b
        public final b a(int i) {
            this.e = i;
            return this;
        }

        @Override // com.anythink.expressad.video.dynview.g.a.b
        public final b a(Bitmap bitmap) {
            this.b = bitmap;
            return this;
        }

        @Override // com.anythink.expressad.video.dynview.g.a.b
        public final b b(float f) {
            this.i = f;
            return this;
        }

        @Override // com.anythink.expressad.video.dynview.g.a.b
        public final b b(int i) {
            this.f = i;
            return this;
        }

        @Override // com.anythink.expressad.video.dynview.g.a.b
        public final b b(Bitmap bitmap) {
            this.f8365c = bitmap;
            return this;
        }

        @Override // com.anythink.expressad.video.dynview.g.a.b
        public final a b() {
            return new a(this, (byte) 0);
        }

        @Override // com.anythink.expressad.video.dynview.g.a.b
        public final b c(int i) {
            this.g = i;
            return this;
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/video/dynview/g/a$b.class */
    public interface b {
        b a();

        b a(float f);

        b a(int i);

        b a(Bitmap bitmap);

        b b(float f);

        b b(int i);

        b b(Bitmap bitmap);

        a b();

        b c(int i);
    }

    private a(C0161a c0161a) {
        super(c0161a.f8364a);
        this.h = false;
        this.f = c0161a.b;
        this.g = c0161a.f8365c;
        this.h = c0161a.d;
        this.f8362a = c0161a.e;
        this.d = c0161a.f;
        this.e = c0161a.g;
        this.b = c0161a.h;
        this.f8363c = c0161a.i;
        Paint paint = new Paint();
        this.i = paint;
        paint.setStyle(Paint.Style.FILL);
        this.i.setAntiAlias(true);
    }

    /* synthetic */ a(C0161a c0161a, byte b2) {
        this(c0161a);
    }

    public static C0161a a() {
        return new C0161a((byte) 0);
    }

    private void a(Canvas canvas) {
        float f = this.f8363c / 2.0f;
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.lineTo(0.0f, (this.d + f) - this.e);
        path.lineTo(this.b, (f - this.d) - this.e);
        path.lineTo(this.b, 0.0f);
        if (this.h) {
            try {
                a(canvas, path);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            Bitmap bitmap = this.f;
            if (bitmap != null && !bitmap.isRecycled()) {
                try {
                    a(canvas, path, this.f);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
        Path path2 = new Path();
        path2.moveTo(0.0f, this.d + f + this.e);
        path2.lineTo(0.0f, this.f8363c);
        path2.lineTo(this.b, this.f8363c);
        path2.lineTo(this.b, (f - this.d) + this.e);
        if (this.h) {
            try {
                a(canvas, path2);
                return;
            } catch (Exception e3) {
                e3.printStackTrace();
                return;
            }
        }
        Bitmap bitmap2 = this.g;
        if (bitmap2 == null || bitmap2.isRecycled()) {
            return;
        }
        try {
            a(canvas, path2, this.g);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    private void a(Canvas canvas, Path path) {
        this.i.setColor(Color.parseColor("#40EAEAEA"));
        canvas.drawPath(path, this.i);
    }

    private void a(Canvas canvas, Path path, Bitmap bitmap) {
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        this.i.setShader(new BitmapShader(bitmap, tileMode, tileMode));
        canvas.drawPath(path, this.i);
    }

    private void b(Canvas canvas) {
        float f = this.b / 2.0f;
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.lineTo(0.0f, this.f8363c);
        path.lineTo((f - this.d) - this.e, this.f8363c);
        path.lineTo((this.d + f) - this.e, 0.0f);
        if (this.h) {
            try {
                a(canvas, path);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            Bitmap bitmap = this.f;
            if (bitmap != null && !bitmap.isRecycled()) {
                try {
                    a(canvas, path, this.f);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
        Path path2 = new Path();
        path2.moveTo(this.d + f + this.e, 0.0f);
        path2.lineTo(this.b, 0.0f);
        path2.lineTo(this.b, this.f8363c);
        path2.lineTo((f - this.d) + this.e, this.f8363c);
        if (this.h) {
            try {
                a(canvas, path2);
                return;
            } catch (Exception e3) {
                e3.printStackTrace();
                return;
            }
        }
        Bitmap bitmap2 = this.g;
        if (bitmap2 == null || bitmap2.isRecycled()) {
            return;
        }
        try {
            a(canvas, path2, this.g);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    @Override // android.graphics.drawable.ShapeDrawable, android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.f8362a == 1) {
            float f = this.f8363c / 2.0f;
            Path path = new Path();
            path.moveTo(0.0f, 0.0f);
            path.lineTo(0.0f, (this.d + f) - this.e);
            path.lineTo(this.b, (f - this.d) - this.e);
            path.lineTo(this.b, 0.0f);
            if (this.h) {
                try {
                    a(canvas, path);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                Bitmap bitmap = this.f;
                if (bitmap != null && !bitmap.isRecycled()) {
                    try {
                        a(canvas, path, this.f);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            }
            Path path2 = new Path();
            path2.moveTo(0.0f, this.d + f + this.e);
            path2.lineTo(0.0f, this.f8363c);
            path2.lineTo(this.b, this.f8363c);
            path2.lineTo(this.b, (f - this.d) + this.e);
            if (this.h) {
                try {
                    a(canvas, path2);
                    return;
                } catch (Exception e3) {
                    e3.printStackTrace();
                    return;
                }
            }
            Bitmap bitmap2 = this.g;
            if (bitmap2 == null || bitmap2.isRecycled()) {
                return;
            }
            try {
                a(canvas, path2, this.g);
                return;
            } catch (Exception e4) {
                e4.printStackTrace();
                return;
            }
        }
        float f2 = this.b / 2.0f;
        Path path3 = new Path();
        path3.moveTo(0.0f, 0.0f);
        path3.lineTo(0.0f, this.f8363c);
        path3.lineTo((f2 - this.d) - this.e, this.f8363c);
        path3.lineTo((this.d + f2) - this.e, 0.0f);
        if (this.h) {
            try {
                a(canvas, path3);
            } catch (Exception e5) {
                e5.printStackTrace();
            }
        } else {
            Bitmap bitmap3 = this.f;
            if (bitmap3 != null && !bitmap3.isRecycled()) {
                try {
                    a(canvas, path3, this.f);
                } catch (Exception e6) {
                    e6.printStackTrace();
                }
            }
        }
        Path path4 = new Path();
        path4.moveTo(this.d + f2 + this.e, 0.0f);
        path4.lineTo(this.b, 0.0f);
        path4.lineTo(this.b, this.f8363c);
        path4.lineTo((f2 - this.d) + this.e, this.f8363c);
        if (this.h) {
            try {
                a(canvas, path4);
                return;
            } catch (Exception e7) {
                e7.printStackTrace();
                return;
            }
        }
        Bitmap bitmap4 = this.g;
        if (bitmap4 == null || bitmap4.isRecycled()) {
            return;
        }
        try {
            a(canvas, path4, this.g);
        } catch (Exception e8) {
            e8.printStackTrace();
        }
    }

    @Override // android.graphics.drawable.ShapeDrawable, android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }
}
