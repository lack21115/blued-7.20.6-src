package ar.com.hjg.pngj;

import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/* loaded from: source-8756600-dex2jar.jar:ar/com/hjg/pngj/DeflatedChunksSet.class */
public class DeflatedChunksSet {

    /* renamed from: a  reason: collision with root package name */
    protected byte[] f3627a;
    State b;

    /* renamed from: c  reason: collision with root package name */
    int f3628c;
    int d;
    public final String e;
    private int f;
    private int g;
    private int h;
    private Inflater i;
    private final boolean j;
    private DeflatedChunkReader k;
    private boolean l;
    private long m;
    private long n;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:ar/com/hjg/pngj/DeflatedChunksSet$State.class */
    public enum State {
        WAITING_FOR_INPUT,
        ROW_READY,
        WORK_DONE,
        TERMINATED;

        public boolean a() {
            return this == WORK_DONE || this == TERMINATED;
        }

        public boolean b() {
            return this == TERMINATED;
        }
    }

    public DeflatedChunksSet(String str, int i, int i2) {
        this(str, i, i2, null, null);
    }

    public DeflatedChunksSet(String str, int i, int i2, Inflater inflater, byte[] bArr) {
        this.b = State.WAITING_FOR_INPUT;
        this.l = true;
        this.m = 0L;
        this.n = 0L;
        this.f3628c = -1;
        this.d = -1;
        this.e = str;
        this.g = i;
        if (i < 1 || i2 < i) {
            throw new PngjException("bad inital row len " + i);
        }
        if (inflater != null) {
            this.i = inflater;
            this.j = false;
        } else {
            this.i = new Inflater();
            this.j = true;
        }
        this.f3627a = (bArr == null || bArr.length < i) ? new byte[i2] : bArr;
        this.h = -1;
        this.b = State.WAITING_FOR_INPUT;
        try {
            a(i);
        } catch (RuntimeException e) {
            g();
            throw e;
        }
    }

    private boolean k() {
        try {
            if (this.b != State.ROW_READY) {
                if (this.b.a()) {
                    return false;
                }
                if (this.f3627a == null || this.f3627a.length < this.g) {
                    this.f3627a = new byte[this.g];
                }
                if (this.f < this.g && !this.i.finished()) {
                    try {
                        int inflate = this.i.inflate(this.f3627a, this.f, this.g - this.f);
                        this.f += inflate;
                        this.n += inflate;
                    } catch (DataFormatException e) {
                        throw new PngjInputException("error decompressing zlib stream ", e);
                    }
                }
                State state = this.f == this.g ? State.ROW_READY : !this.i.finished() ? State.WAITING_FOR_INPUT : this.f > 0 ? State.ROW_READY : State.WORK_DONE;
                this.b = state;
                if (state == State.ROW_READY) {
                    a();
                    return true;
                }
                return false;
            }
            throw new PngjException("invalid state");
        } catch (RuntimeException e2) {
            g();
            throw e2;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a() {
    }

    public void a(int i) {
        this.f = 0;
        this.h++;
        if (i < 1) {
            this.g = 0;
            h();
        } else if (this.i.finished()) {
            this.g = 0;
            h();
        } else {
            this.b = State.WAITING_FOR_INPUT;
            this.g = i;
            if (this.l) {
                return;
            }
            k();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(DeflatedChunkReader deflatedChunkReader) {
        if (!this.e.equals(deflatedChunkReader.a().f3660c)) {
            throw new PngjInputException("Bad chunk inside IdatSet, id:" + deflatedChunkReader.a().f3660c + ", expected:" + this.e);
        }
        this.k = deflatedChunkReader;
        int i = this.f3628c + 1;
        this.f3628c = i;
        int i2 = this.d;
        if (i2 >= 0) {
            deflatedChunkReader.a(i + i2);
        }
    }

    public void a(boolean z) {
        this.l = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(byte[] bArr, int i, int i2) {
        this.m += i2;
        if (i2 < 1 || this.b.a()) {
            return;
        }
        if (this.b == State.ROW_READY) {
            throw new PngjInputException("this should only be called if waitingForMoreInput");
        }
        if (this.i.needsDictionary() || !this.i.needsInput()) {
            throw new RuntimeException("should not happen");
        }
        this.i.setInput(bArr, i, i2);
        if (!j()) {
            k();
            return;
        }
        while (k()) {
            a(b());
            if (d()) {
                c();
            }
        }
    }

    public boolean a(String str) {
        if (this.b.b()) {
            return false;
        }
        if (str.equals(this.e) || b(str)) {
            return true;
        }
        if (this.b.a()) {
            if (e()) {
                return false;
            }
            f();
            return false;
        }
        throw new PngjInputException("Unexpected chunk " + str + " while " + this.e + " set is not done");
    }

    protected int b() {
        throw new PngjInputException("not implemented");
    }

    public boolean b(String str) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c() {
    }

    public boolean d() {
        return this.b.a();
    }

    public boolean e() {
        return this.b.b();
    }

    protected void f() {
        g();
    }

    public void g() {
        try {
            if (!this.b.b()) {
                this.b = State.TERMINATED;
            }
            if (!this.j || this.i == null) {
                return;
            }
            this.i.end();
            this.i = null;
        } catch (Exception e) {
        }
    }

    public void h() {
        if (d()) {
            return;
        }
        this.b = State.WORK_DONE;
    }

    public int i() {
        return this.h;
    }

    public boolean j() {
        return this.l;
    }

    public String toString() {
        return new StringBuilder("idatSet : " + this.k.a().f3660c + " state=" + this.b + " rows=" + this.h + " bytes=" + this.m + BridgeUtil.SPLIT_MARK + this.n).toString();
    }
}
