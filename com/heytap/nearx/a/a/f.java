package com.heytap.nearx.a.a;

import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import okio.BufferedSource;
import okio.ByteString;

/* loaded from: source-7994992-dex2jar.jar:com/heytap/nearx/a/a/f.class */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    private final BufferedSource f22264a;
    private int d;
    private a h;
    private long b = 0;

    /* renamed from: c  reason: collision with root package name */
    private long f22265c = Long.MAX_VALUE;
    private int e = 2;
    private int f = -1;
    private long g = -1;

    public f(BufferedSource bufferedSource) {
        this.f22264a = bufferedSource;
    }

    private void a(int i) throws IOException {
        while (this.b < this.f22265c && !this.f22264a.exhausted()) {
            int j = j();
            if (j == 0) {
                throw new ProtocolException("Unexpected tag 0");
            }
            int i2 = j >> 3;
            int i3 = j & 7;
            if (i3 == 0) {
                this.e = 0;
                g();
            } else if (i3 == 1) {
                this.e = 1;
                i();
            } else if (i3 == 2) {
                long j2 = j();
                this.b += j2;
                this.f22264a.skip(j2);
            } else if (i3 == 3) {
                a(i2);
            } else if (i3 == 4) {
                if (i2 != i) {
                    throw new ProtocolException("Unexpected end group");
                }
                return;
            } else if (i3 != 5) {
                throw new ProtocolException("Unexpected field encoding: " + i3);
            } else {
                this.e = 5;
                h();
            }
        }
        throw new EOFException();
    }

    private void b(int i) throws IOException {
        if (this.e != i) {
            long j = this.b;
            long j2 = this.f22265c;
            if (j > j2) {
                throw new IOException("Expected to end at " + this.f22265c + " but was " + this.b);
            } else if (j != j2) {
                this.e = 7;
                return;
            } else {
                this.f22265c = this.g;
                this.g = -1L;
            }
        }
        this.e = 6;
    }

    private int j() throws IOException {
        int i;
        this.b++;
        byte readByte = this.f22264a.readByte();
        if (readByte >= 0) {
            return readByte;
        }
        int i2 = readByte & Byte.MAX_VALUE;
        this.b++;
        byte readByte2 = this.f22264a.readByte();
        if (readByte2 >= 0) {
            i = readByte2 << 7;
        } else {
            i2 |= (readByte2 & Byte.MAX_VALUE) << 7;
            this.b++;
            byte readByte3 = this.f22264a.readByte();
            if (readByte3 >= 0) {
                i = readByte3 << 14;
            } else {
                int i3 = i2 | ((readByte3 & Byte.MAX_VALUE) << 14);
                this.b++;
                byte readByte4 = this.f22264a.readByte();
                if (readByte4 < 0) {
                    this.b++;
                    byte readByte5 = this.f22264a.readByte();
                    if (readByte5 < 0) {
                        int i4 = 0;
                        while (true) {
                            int i5 = i4;
                            if (i5 >= 5) {
                                throw new ProtocolException("Malformed VARINT");
                            }
                            this.b++;
                            if (this.f22264a.readByte() >= 0) {
                                break;
                            }
                            i4 = i5 + 1;
                        }
                    }
                    return i3 | ((readByte4 & Byte.MAX_VALUE) << 21) | (readByte5 << 28);
                }
                i2 = i3;
                i = readByte4 << 21;
            }
        }
        return i2 | i;
    }

    private long k() throws IOException {
        if (this.e != 2) {
            throw new ProtocolException("Expected LENGTH_DELIMITED but was " + this.e);
        }
        long j = this.f22265c - this.b;
        this.f22264a.require(j);
        this.e = 6;
        this.b = this.f22265c;
        this.f22265c = this.g;
        this.g = -1L;
        return j;
    }

    public long a() throws IOException {
        if (this.e == 2) {
            int i = this.d + 1;
            this.d = i;
            if (i <= 65) {
                long j = this.g;
                this.g = -1L;
                this.e = 6;
                return j;
            }
            throw new IOException("Wire recursion limit exceeded");
        }
        throw new IllegalStateException("Unexpected call to beginMessage()");
    }

    public void a(long j) throws IOException {
        if (this.e != 6) {
            throw new IllegalStateException("Unexpected call to endMessage()");
        }
        int i = this.d - 1;
        this.d = i;
        if (i < 0 || this.g != -1) {
            throw new IllegalStateException("No corresponding call to beginMessage()");
        }
        if (this.b == this.f22265c || i == 0) {
            this.f22265c = j;
            return;
        }
        throw new IOException("Expected to end at " + this.f22265c + " but was " + this.b);
    }

    public int b() throws IOException {
        int i = this.e;
        if (i != 7) {
            if (i == 6) {
                while (this.b < this.f22265c && !this.f22264a.exhausted()) {
                    int j = j();
                    if (j == 0) {
                        throw new ProtocolException("Unexpected tag 0");
                    }
                    int i2 = j >> 3;
                    this.f = i2;
                    int i3 = j & 7;
                    if (i3 == 0) {
                        this.h = a.VARINT;
                        this.e = 0;
                    } else if (i3 == 1) {
                        this.h = a.FIXED64;
                        this.e = 1;
                    } else if (i3 == 2) {
                        this.h = a.LENGTH_DELIMITED;
                        this.e = 2;
                        int j2 = j();
                        if (j2 < 0) {
                            throw new ProtocolException("Negative length: " + j2);
                        } else if (this.g != -1) {
                            throw new IllegalStateException();
                        } else {
                            long j3 = this.f22265c;
                            this.g = j3;
                            long j4 = j2 + this.b;
                            this.f22265c = j4;
                            if (j4 > j3) {
                                throw new EOFException();
                            }
                        }
                    } else if (i3 == 3) {
                        a(i2);
                    } else if (i3 == 4) {
                        throw new ProtocolException("Unexpected end group");
                    } else {
                        if (i3 != 5) {
                            throw new ProtocolException("Unexpected field encoding: " + i3);
                        }
                        this.h = a.FIXED32;
                        this.e = 5;
                    }
                }
                return -1;
            }
            throw new IllegalStateException("Unexpected call to nextTag()");
        }
        this.e = 2;
        return this.f;
    }

    public a c() {
        return this.h;
    }

    public ByteString d() throws IOException {
        return this.f22264a.readByteString(k());
    }

    public String e() throws IOException {
        return this.f22264a.readUtf8(k());
    }

    public int f() throws IOException {
        int i = this.e;
        if (i == 0 || i == 2) {
            int j = j();
            b(0);
            return j;
        }
        throw new ProtocolException("Expected VARINT or LENGTH_DELIMITED but was " + this.e);
    }

    public long g() throws IOException {
        byte readByte;
        int i = this.e;
        if (i != 0 && i != 2) {
            throw new ProtocolException("Expected VARINT or LENGTH_DELIMITED but was " + this.e);
        }
        long j = 0;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= 64) {
                throw new ProtocolException("WireInput encountered a malformed varint");
            }
            this.b++;
            j |= (readByte & Byte.MAX_VALUE) << i3;
            if ((this.f22264a.readByte() & 128) == 0) {
                b(0);
                return j;
            }
            i2 = i3 + 7;
        }
    }

    public int h() throws IOException {
        int i = this.e;
        if (i != 5 && i != 2) {
            throw new ProtocolException("Expected FIXED32 or LENGTH_DELIMITED but was " + this.e);
        }
        this.f22264a.require(4L);
        this.b += 4;
        int readIntLe = this.f22264a.readIntLe();
        b(5);
        return readIntLe;
    }

    public long i() throws IOException {
        int i = this.e;
        if (i != 1 && i != 2) {
            throw new ProtocolException("Expected FIXED64 or LENGTH_DELIMITED but was " + this.e);
        }
        this.f22264a.require(8L);
        this.b += 8;
        long readLongLe = this.f22264a.readLongLe();
        b(1);
        return readLongLe;
    }
}
