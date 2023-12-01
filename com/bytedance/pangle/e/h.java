package com.bytedance.pangle.e;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/pangle/e/h.class */
public final class h implements Closeable {

    /* renamed from: a  reason: collision with root package name */
    private final FileInputStream f21387a;
    private a b;

    /* renamed from: c  reason: collision with root package name */
    private b[] f21388c;
    private c[] d;
    private final Map<String, c> e = new HashMap();

    /* loaded from: source-7206380-dex2jar.jar:com/bytedance/pangle/e/h$a.class */
    static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final byte[] f21389a;
        public final short b;

        /* renamed from: c  reason: collision with root package name */
        public final short f21390c;
        public final int d;
        public final long e;
        public final long f;
        public final long g;
        public final int h;
        public final short i;
        public final short j;
        public final short k;
        public final short l;
        public final short m;
        public final short n;

        private a(FileChannel fileChannel) {
            this.f21389a = new byte[16];
            fileChannel.position(0L);
            fileChannel.read(ByteBuffer.wrap(this.f21389a));
            byte[] bArr = this.f21389a;
            if (bArr[0] != Byte.MAX_VALUE || bArr[1] != 69 || bArr[2] != 76 || bArr[3] != 70) {
                throw new IOException(String.format("bad elf magic: %x %x %x %x.", Byte.valueOf(this.f21389a[0]), Byte.valueOf(this.f21389a[1]), Byte.valueOf(this.f21389a[2]), Byte.valueOf(this.f21389a[3])));
            }
            byte b = bArr[4];
            h.a(b, 2, "bad elf class: " + ((int) this.f21389a[4]));
            byte b2 = this.f21389a[5];
            h.a(b2, 2, "bad elf data encoding: " + ((int) this.f21389a[5]));
            ByteBuffer allocate = ByteBuffer.allocate(this.f21389a[4] == 1 ? 36 : 48);
            allocate.order(this.f21389a[5] == 1 ? ByteOrder.LITTLE_ENDIAN : ByteOrder.BIG_ENDIAN);
            h.b(fileChannel, allocate, "failed to read rest part of ehdr.");
            this.b = allocate.getShort();
            this.f21390c = allocate.getShort();
            int i = allocate.getInt();
            this.d = i;
            h.a(i, 1, "bad elf version: " + this.d);
            byte b3 = this.f21389a[4];
            if (b3 == 1) {
                this.e = allocate.getInt();
                this.f = allocate.getInt();
                this.g = allocate.getInt();
            } else if (b3 != 2) {
                throw new IOException("Unexpected elf class: " + ((int) this.f21389a[4]));
            } else {
                this.e = allocate.getLong();
                this.f = allocate.getLong();
                this.g = allocate.getLong();
            }
            this.h = allocate.getInt();
            this.i = allocate.getShort();
            this.j = allocate.getShort();
            this.k = allocate.getShort();
            this.l = allocate.getShort();
            this.m = allocate.getShort();
            this.n = allocate.getShort();
        }

        /* synthetic */ a(FileChannel fileChannel, byte b) {
            this(fileChannel);
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/bytedance/pangle/e/h$b.class */
    static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final int f21391a;
        public final int b;

        /* renamed from: c  reason: collision with root package name */
        public final long f21392c;
        public final long d;
        public final long e;
        public final long f;
        public final long g;
        public final long h;

        private b(ByteBuffer byteBuffer, int i) {
            if (i == 1) {
                this.f21391a = byteBuffer.getInt();
                this.f21392c = byteBuffer.getInt();
                this.d = byteBuffer.getInt();
                this.e = byteBuffer.getInt();
                this.f = byteBuffer.getInt();
                this.g = byteBuffer.getInt();
                this.b = byteBuffer.getInt();
                this.h = byteBuffer.getInt();
            } else if (i != 2) {
                throw new IOException("Unexpected elf class: ".concat(String.valueOf(i)));
            } else {
                this.f21391a = byteBuffer.getInt();
                this.b = byteBuffer.getInt();
                this.f21392c = byteBuffer.getLong();
                this.d = byteBuffer.getLong();
                this.e = byteBuffer.getLong();
                this.f = byteBuffer.getLong();
                this.g = byteBuffer.getLong();
                this.h = byteBuffer.getLong();
            }
        }

        /* synthetic */ b(ByteBuffer byteBuffer, int i, byte b) {
            this(byteBuffer, i);
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/bytedance/pangle/e/h$c.class */
    static final class c {

        /* renamed from: a  reason: collision with root package name */
        public final int f21393a;
        public final int b;

        /* renamed from: c  reason: collision with root package name */
        public final long f21394c;
        public final long d;
        public final long e;
        public final long f;
        public final int g;
        public final int h;
        public final long i;
        public final long j;
        public String k;

        private c(ByteBuffer byteBuffer, int i) {
            if (i == 1) {
                this.f21393a = byteBuffer.getInt();
                this.b = byteBuffer.getInt();
                this.f21394c = byteBuffer.getInt();
                this.d = byteBuffer.getInt();
                this.e = byteBuffer.getInt();
                this.f = byteBuffer.getInt();
                this.g = byteBuffer.getInt();
                this.h = byteBuffer.getInt();
                this.i = byteBuffer.getInt();
                this.j = byteBuffer.getInt();
            } else if (i != 2) {
                throw new IOException("Unexpected elf class: ".concat(String.valueOf(i)));
            } else {
                this.f21393a = byteBuffer.getInt();
                this.b = byteBuffer.getInt();
                this.f21394c = byteBuffer.getLong();
                this.d = byteBuffer.getLong();
                this.e = byteBuffer.getLong();
                this.f = byteBuffer.getLong();
                this.g = byteBuffer.getInt();
                this.h = byteBuffer.getInt();
                this.i = byteBuffer.getLong();
                this.j = byteBuffer.getLong();
            }
            this.k = null;
        }

        /* synthetic */ c(ByteBuffer byteBuffer, int i, byte b) {
            this(byteBuffer, i);
        }
    }

    private h(File file) {
        this.b = null;
        this.f21388c = null;
        this.d = null;
        FileInputStream fileInputStream = new FileInputStream(file);
        this.f21387a = fileInputStream;
        FileChannel channel = fileInputStream.getChannel();
        this.b = new a(channel, (byte) 0);
        ByteBuffer allocate = ByteBuffer.allocate(128);
        allocate.limit(this.b.j);
        allocate.order(this.b.f21389a[5] == 1 ? ByteOrder.LITTLE_ENDIAN : ByteOrder.BIG_ENDIAN);
        channel.position(this.b.f);
        this.f21388c = new b[this.b.k];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.f21388c.length) {
                break;
            }
            b(channel, allocate, "failed to read phdr.");
            this.f21388c[i2] = new b(allocate, this.b.f21389a[4], (byte) 0);
            i = i2 + 1;
        }
        channel.position(this.b.g);
        allocate.limit(this.b.l);
        this.d = new c[this.b.m];
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= this.d.length) {
                break;
            }
            b(channel, allocate, "failed to read shdr.");
            this.d[i4] = new c(allocate, this.b.f21389a[4], (byte) 0);
            i3 = i4 + 1;
        }
        if (this.b.n <= 0) {
            return;
        }
        c cVar = this.d[this.b.n];
        ByteBuffer allocate2 = ByteBuffer.allocate((int) cVar.f);
        this.f21387a.getChannel().position(cVar.e);
        b(this.f21387a.getChannel(), allocate2, "failed to read section: " + cVar.k);
        c[] cVarArr = this.d;
        int length = cVarArr.length;
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 >= length) {
                return;
            }
            c cVar2 = cVarArr[i6];
            allocate2.position(cVar2.f21393a);
            cVar2.k = a(allocate2);
            this.e.put(cVar2.k, cVar2);
            i5 = i6 + 1;
        }
    }

    private static String a(ByteBuffer byteBuffer) {
        byte[] array = byteBuffer.array();
        int position = byteBuffer.position();
        while (byteBuffer.hasRemaining() && array[byteBuffer.position()] != 0) {
            byteBuffer.position(byteBuffer.position() + 1);
        }
        byteBuffer.position(byteBuffer.position() + 1);
        return new String(array, position, (byteBuffer.position() - position) - 1, Charset.forName("ASCII"));
    }

    static /* synthetic */ void a(int i, int i2, String str) {
        if (i <= 0 || i > i2) {
            throw new IOException(str);
        }
    }

    public static boolean a(File file) {
        try {
            com.bytedance.pangle.util.g.a(new h(file));
            return true;
        } catch (IOException e) {
            com.bytedance.pangle.util.g.a((Closeable) null);
            return false;
        } catch (Throwable th) {
            com.bytedance.pangle.util.g.a((Closeable) null);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(FileChannel fileChannel, ByteBuffer byteBuffer, String str) {
        byteBuffer.rewind();
        int read = fileChannel.read(byteBuffer);
        if (read == byteBuffer.limit()) {
            byteBuffer.flip();
            return;
        }
        throw new IOException(str + " Rest bytes insufficient, expect to read " + byteBuffer.limit() + " bytes but only " + read + " bytes were read.");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f21387a.close();
        this.e.clear();
        this.f21388c = null;
        this.d = null;
    }
}
