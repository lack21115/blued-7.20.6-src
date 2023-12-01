package kotlin.jvm.internal;

import java.io.Serializable;

/* loaded from: source-3503164-dex2jar.jar:kotlin/jvm/internal/Ref.class */
public class Ref {

    /* loaded from: source-3503164-dex2jar.jar:kotlin/jvm/internal/Ref$BooleanRef.class */
    public static final class BooleanRef implements Serializable {
        public boolean a;

        public String toString() {
            return String.valueOf(this.a);
        }
    }

    /* loaded from: source-3503164-dex2jar.jar:kotlin/jvm/internal/Ref$ByteRef.class */
    public static final class ByteRef implements Serializable {
        public byte a;

        public String toString() {
            return String.valueOf((int) this.a);
        }
    }

    /* loaded from: source-3503164-dex2jar.jar:kotlin/jvm/internal/Ref$CharRef.class */
    public static final class CharRef implements Serializable {
        public char a;

        public String toString() {
            return String.valueOf(this.a);
        }
    }

    /* loaded from: source-3503164-dex2jar.jar:kotlin/jvm/internal/Ref$DoubleRef.class */
    public static final class DoubleRef implements Serializable {
        public double a;

        public String toString() {
            return String.valueOf(this.a);
        }
    }

    /* loaded from: source-3503164-dex2jar.jar:kotlin/jvm/internal/Ref$FloatRef.class */
    public static final class FloatRef implements Serializable {
        public float a;

        public String toString() {
            return String.valueOf(this.a);
        }
    }

    /* loaded from: source-3503164-dex2jar.jar:kotlin/jvm/internal/Ref$IntRef.class */
    public static final class IntRef implements Serializable {
        public int a;

        public String toString() {
            return String.valueOf(this.a);
        }
    }

    /* loaded from: source-3503164-dex2jar.jar:kotlin/jvm/internal/Ref$LongRef.class */
    public static final class LongRef implements Serializable {
        public long a;

        public String toString() {
            return String.valueOf(this.a);
        }
    }

    /* loaded from: source-3503164-dex2jar.jar:kotlin/jvm/internal/Ref$ObjectRef.class */
    public static final class ObjectRef<T> implements Serializable {
        public T a;

        public String toString() {
            return String.valueOf(this.a);
        }
    }

    /* loaded from: source-3503164-dex2jar.jar:kotlin/jvm/internal/Ref$ShortRef.class */
    public static final class ShortRef implements Serializable {
        public short a;

        public String toString() {
            return String.valueOf((int) this.a);
        }
    }

    private Ref() {
    }
}
