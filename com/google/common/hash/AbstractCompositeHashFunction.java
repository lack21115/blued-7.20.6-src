package com.google.common.hash;

import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.Immutable;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

@Immutable
/* loaded from: source-8110460-dex2jar.jar:com/google/common/hash/AbstractCompositeHashFunction.class */
abstract class AbstractCompositeHashFunction extends AbstractHashFunction {
    private static final long serialVersionUID = 0;
    final HashFunction[] functions;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractCompositeHashFunction(HashFunction... hashFunctionArr) {
        int length = hashFunctionArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                this.functions = hashFunctionArr;
                return;
            } else {
                Preconditions.checkNotNull(hashFunctionArr[i2]);
                i = i2 + 1;
            }
        }
    }

    private Hasher fromHashers(final Hasher[] hasherArr) {
        return new Hasher() { // from class: com.google.common.hash.AbstractCompositeHashFunction.1
            @Override // com.google.common.hash.Hasher
            public HashCode hash() {
                return AbstractCompositeHashFunction.this.makeHash(hasherArr);
            }

            @Override // com.google.common.hash.PrimitiveSink
            public Hasher putBoolean(boolean z) {
                Hasher[] hasherArr2 = hasherArr;
                int length = hasherArr2.length;
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= length) {
                        return this;
                    }
                    hasherArr2[i2].putBoolean(z);
                    i = i2 + 1;
                }
            }

            @Override // com.google.common.hash.PrimitiveSink
            public Hasher putByte(byte b) {
                Hasher[] hasherArr2 = hasherArr;
                int length = hasherArr2.length;
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= length) {
                        return this;
                    }
                    hasherArr2[i2].putByte(b);
                    i = i2 + 1;
                }
            }

            @Override // com.google.common.hash.PrimitiveSink
            public Hasher putBytes(ByteBuffer byteBuffer) {
                int position = byteBuffer.position();
                Hasher[] hasherArr2 = hasherArr;
                int length = hasherArr2.length;
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= length) {
                        return this;
                    }
                    Hasher hasher = hasherArr2[i2];
                    byteBuffer.position(position);
                    hasher.putBytes(byteBuffer);
                    i = i2 + 1;
                }
            }

            @Override // com.google.common.hash.PrimitiveSink
            public Hasher putBytes(byte[] bArr) {
                Hasher[] hasherArr2 = hasherArr;
                int length = hasherArr2.length;
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= length) {
                        return this;
                    }
                    hasherArr2[i2].putBytes(bArr);
                    i = i2 + 1;
                }
            }

            @Override // com.google.common.hash.PrimitiveSink
            public Hasher putBytes(byte[] bArr, int i, int i2) {
                Hasher[] hasherArr2 = hasherArr;
                int length = hasherArr2.length;
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 >= length) {
                        return this;
                    }
                    hasherArr2[i4].putBytes(bArr, i, i2);
                    i3 = i4 + 1;
                }
            }

            @Override // com.google.common.hash.PrimitiveSink
            public Hasher putChar(char c2) {
                Hasher[] hasherArr2 = hasherArr;
                int length = hasherArr2.length;
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= length) {
                        return this;
                    }
                    hasherArr2[i2].putChar(c2);
                    i = i2 + 1;
                }
            }

            @Override // com.google.common.hash.PrimitiveSink
            public Hasher putDouble(double d) {
                Hasher[] hasherArr2 = hasherArr;
                int length = hasherArr2.length;
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= length) {
                        return this;
                    }
                    hasherArr2[i2].putDouble(d);
                    i = i2 + 1;
                }
            }

            @Override // com.google.common.hash.PrimitiveSink
            public Hasher putFloat(float f) {
                Hasher[] hasherArr2 = hasherArr;
                int length = hasherArr2.length;
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= length) {
                        return this;
                    }
                    hasherArr2[i2].putFloat(f);
                    i = i2 + 1;
                }
            }

            @Override // com.google.common.hash.PrimitiveSink
            public Hasher putInt(int i) {
                Hasher[] hasherArr2 = hasherArr;
                int length = hasherArr2.length;
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 >= length) {
                        return this;
                    }
                    hasherArr2[i3].putInt(i);
                    i2 = i3 + 1;
                }
            }

            @Override // com.google.common.hash.PrimitiveSink
            public Hasher putLong(long j) {
                Hasher[] hasherArr2 = hasherArr;
                int length = hasherArr2.length;
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= length) {
                        return this;
                    }
                    hasherArr2[i2].putLong(j);
                    i = i2 + 1;
                }
            }

            @Override // com.google.common.hash.Hasher
            public <T> Hasher putObject(T t, Funnel<? super T> funnel) {
                Hasher[] hasherArr2 = hasherArr;
                int length = hasherArr2.length;
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= length) {
                        return this;
                    }
                    hasherArr2[i2].putObject(t, funnel);
                    i = i2 + 1;
                }
            }

            @Override // com.google.common.hash.PrimitiveSink
            public Hasher putShort(short s) {
                Hasher[] hasherArr2 = hasherArr;
                int length = hasherArr2.length;
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= length) {
                        return this;
                    }
                    hasherArr2[i2].putShort(s);
                    i = i2 + 1;
                }
            }

            @Override // com.google.common.hash.PrimitiveSink
            public Hasher putString(CharSequence charSequence, Charset charset) {
                Hasher[] hasherArr2 = hasherArr;
                int length = hasherArr2.length;
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= length) {
                        return this;
                    }
                    hasherArr2[i2].putString(charSequence, charset);
                    i = i2 + 1;
                }
            }

            @Override // com.google.common.hash.PrimitiveSink
            public Hasher putUnencodedChars(CharSequence charSequence) {
                Hasher[] hasherArr2 = hasherArr;
                int length = hasherArr2.length;
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= length) {
                        return this;
                    }
                    hasherArr2[i2].putUnencodedChars(charSequence);
                    i = i2 + 1;
                }
            }
        };
    }

    abstract HashCode makeHash(Hasher[] hasherArr);

    @Override // com.google.common.hash.HashFunction
    public Hasher newHasher() {
        int length = this.functions.length;
        Hasher[] hasherArr = new Hasher[length];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return fromHashers(hasherArr);
            }
            hasherArr[i2] = this.functions[i2].newHasher();
            i = i2 + 1;
        }
    }

    @Override // com.google.common.hash.AbstractHashFunction, com.google.common.hash.HashFunction
    public Hasher newHasher(int i) {
        Preconditions.checkArgument(i >= 0);
        int length = this.functions.length;
        Hasher[] hasherArr = new Hasher[length];
        for (int i2 = 0; i2 < length; i2++) {
            hasherArr[i2] = this.functions[i2].newHasher(i);
        }
        return fromHashers(hasherArr);
    }
}
