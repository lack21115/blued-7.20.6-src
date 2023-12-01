package com.tencent.mapsdk.internal;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.util.Hashtable;
import javax.microedition.khronos.opengles.GL10;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/cc.class */
public class cc {
    public static final int e = 0;

    /* renamed from: a  reason: collision with root package name */
    private int f37366a;
    private a<String> b;

    /* renamed from: c  reason: collision with root package name */
    private Hashtable<String, Integer> f37367c = new Hashtable<>();
    private IntBuffer d;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/cc$a.class */
    public static class a<E> {

        /* renamed from: a  reason: collision with root package name */
        private int f37368a;
        private Object[] b;
        private int d = 0;

        /* renamed from: c  reason: collision with root package name */
        private int f37369c = 0;

        public a(int i) {
            this.f37368a = i;
            this.b = new Object[i];
        }

        private void e() {
            this.d = 0;
            this.f37369c = 0;
        }

        public void a() {
            e();
            int i = 0;
            while (true) {
                int i2 = i;
                Object[] objArr = this.b;
                if (i2 >= objArr.length) {
                    return;
                }
                objArr[i2] = null;
                i = i2 + 1;
            }
        }

        public boolean a(E e) {
            if (c()) {
                return false;
            }
            int i = this.d % this.f37368a;
            this.d = i;
            Object[] objArr = this.b;
            this.d = i + 1;
            objArr[i] = e;
            return true;
        }

        public boolean b() {
            return this.d == this.f37369c;
        }

        public boolean c() {
            return (this.d + 1) % this.f37368a == this.f37369c;
        }

        public E d() {
            if (b()) {
                return null;
            }
            int i = this.f37369c % this.f37368a;
            this.f37369c = i;
            Object[] objArr = this.b;
            E e = (E) objArr[i];
            objArr[i] = null;
            this.f37369c = i + 1;
            return e;
        }
    }

    public cc(int i) {
        this.f37366a = i;
        this.b = new a<>(i);
        a();
    }

    private void a() {
        synchronized (this) {
            if (this.d == null) {
                ByteBuffer allocateDirect = ByteBuffer.allocateDirect(this.f37366a * 4);
                allocateDirect.order(ByteOrder.nativeOrder());
                this.d = allocateDirect.asIntBuffer();
            }
        }
    }

    public int a(String str) {
        synchronized (this) {
            Integer num = this.f37367c.get(str);
            if (num != null) {
                return num.intValue();
            }
            return 0;
        }
    }

    public void a(String str, int i) {
        synchronized (this) {
            if (this.f37367c.size() == this.f37366a) {
                a();
                if (this.d == null) {
                    return;
                }
                Integer remove = this.f37367c.remove(this.b.d());
                if (this.d.position() < this.f37366a) {
                    this.d.put(remove.intValue());
                }
            }
            this.b.a(str);
            this.f37367c.put(str, Integer.valueOf(i));
        }
    }

    public void a(GL10 gl10) {
        synchronized (this) {
            IntBuffer intBuffer = this.d;
            if (intBuffer == null) {
                return;
            }
            int position = intBuffer.position();
            if (position > 0) {
                this.d.rewind();
                gl10.glDeleteTextures(position, this.d);
                this.d.clear();
            }
        }
    }

    public void b() {
        synchronized (this) {
            this.f37367c.clear();
            this.b.a();
            IntBuffer intBuffer = this.d;
            if (intBuffer != null) {
                intBuffer.clear();
            }
        }
    }

    public void b(GL10 gl10) {
        synchronized (this) {
            if (this.d != null) {
                for (String str : this.f37367c.keySet()) {
                    this.d.put(this.f37367c.get(str).intValue());
                }
                a(gl10);
            }
            this.f37367c.clear();
            this.b.a();
        }
    }
}
