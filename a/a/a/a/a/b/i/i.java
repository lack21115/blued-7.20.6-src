package a.a.a.a.a.b.i;

import android.opengl.GLES30;

/* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/b/i/i.class */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public n f1325a;
    public n b;

    /* renamed from: c  reason: collision with root package name */
    public n f1326c;

    public void a() {
        this.f1325a.n();
        this.b.n();
        this.f1326c.n();
    }

    public boolean a(int i, int i2) {
        int i3 = i / 2;
        int i4 = i2 / 2;
        this.f1325a = new n();
        this.b = new n();
        this.f1326c = new n();
        a.a.a.a.a.a.h.f.b();
        a.a.a.a.a.a.h.f.b();
        return this.f1325a.a(i, i2, 1, GLES30.GL_R8, GLES30.GL_RED, "precision mediump float;\nuniform sampler2D u_tex;\nvarying vec2 v_tex;\nfloat Y(vec3 c)  {\n  float result = (0.257 * c.r) + (0.504 * c.g) + (0.098 * c.b) + 0.0625;\n  return result;\n}\nvoid main() {\n  float y = Y(texture2D(u_tex, v_tex).rgb);\n  gl_FragColor = vec4(y);\n}\n") && this.b.a(i3, i4, 1, GLES30.GL_R8, GLES30.GL_RED, "precision mediump float;\nuniform sampler2D u_tex;\nvarying vec2 v_tex;\nfloat U(vec3 c) {\n  float result = -(0.148 * c.r) - (0.291 * c.g) + (0.439 * c.b) + 0.5;\n  return result;\n}\nvoid main() {\n  float u = U(texture2D(u_tex, v_tex).rgb);\n  gl_FragColor = vec4(u);\n}\n") && this.f1326c.a(i3, i4, 1, GLES30.GL_R8, GLES30.GL_RED, "precision mediump float;\nuniform sampler2D u_tex;\nvarying vec2 v_tex;\nfloat V(vec3 c) {\n  float result = (0.439 * c.r) - (0.368 * c.g) - (0.071 * c.b) + 0.5;\n  return result;\n}\nvoid main() {\n  float v = V(texture2D(u_tex, v_tex).rgb);\n  gl_FragColor = vec4(v);\n}\n");
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x004c, code lost:
        if (r0[2] == null) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.nio.ByteBuffer[] a(int r5) {
        /*
            r4 = this;
            r0 = r4
            a.a.a.a.a.b.i.n r0 = r0.f1325a
            r1 = r5
            r0.b(r1)
            r0 = r4
            a.a.a.a.a.b.i.n r0 = r0.b
            r1 = r5
            r0.b(r1)
            r0 = r4
            a.a.a.a.a.b.i.n r0 = r0.f1326c
            r1 = r5
            r0.b(r1)
            r0 = 3
            java.nio.ByteBuffer[] r0 = new java.nio.ByteBuffer[r0]
            r7 = r0
            r0 = r7
            r1 = 0
            r2 = r4
            a.a.a.a.a.b.i.n r2 = r2.f1325a
            java.nio.ByteBuffer r2 = r2.m()
            r0[r1] = r2
            r0 = r7
            r1 = 1
            r2 = r4
            a.a.a.a.a.b.i.n r2 = r2.b
            java.nio.ByteBuffer r2 = r2.m()
            r0[r1] = r2
            r0 = r7
            r1 = 2
            r2 = r4
            a.a.a.a.a.b.i.n r2 = r2.f1326c
            java.nio.ByteBuffer r2 = r2.m()
            r0[r1] = r2
            r0 = r7
            r1 = 0
            r0 = r0[r1]
            if (r0 == 0) goto L4f
            r0 = r7
            r1 = 1
            r0 = r0[r1]
            if (r0 == 0) goto L4f
            r0 = r7
            r6 = r0
            r0 = r7
            r1 = 2
            r0 = r0[r1]
            if (r0 != 0) goto L51
        L4f:
            r0 = 0
            r6 = r0
        L51:
            r0 = r6
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: a.a.a.a.a.b.i.i.a(int):java.nio.ByteBuffer[]");
    }

    public void b() {
        n nVar = this.f1325a;
        if (nVar != null) {
            nVar.g();
            this.f1325a = null;
        }
        n nVar2 = this.b;
        if (nVar2 != null) {
            nVar2.g();
            this.b = null;
        }
        n nVar3 = this.f1326c;
        if (nVar3 != null) {
            nVar3.g();
            this.f1326c = null;
        }
    }
}
