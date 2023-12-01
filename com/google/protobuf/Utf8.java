package com.google.protobuf;

import java.nio.ByteBuffer;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8110460-dex2jar.jar:com/google/protobuf/Utf8.class */
public final class Utf8 {
    private static final long ASCII_MASK_LONG = -9187201950435737472L;
    public static final int COMPLETE = 0;
    public static final int MALFORMED = -1;
    static final int MAX_BYTES_PER_CHAR = 3;
    private static final int UNSAFE_COUNT_ASCII_THRESHOLD = 16;
    private static final Processor processor;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8110460-dex2jar.jar:com/google/protobuf/Utf8$DecodeUtil.class */
    public static class DecodeUtil {
        private DecodeUtil() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void handleFourBytes(byte b, byte b2, byte b3, byte b4, char[] cArr, int i) throws InvalidProtocolBufferException {
            if (isNotTrailingByte(b2) || (((b << 28) + (b2 + 112)) >> 30) != 0 || isNotTrailingByte(b3) || isNotTrailingByte(b4)) {
                throw InvalidProtocolBufferException.invalidUtf8();
            }
            int trailingByteValue = ((b & 7) << 18) | (trailingByteValue(b2) << 12) | (trailingByteValue(b3) << 6) | trailingByteValue(b4);
            cArr[i] = highSurrogate(trailingByteValue);
            cArr[i + 1] = lowSurrogate(trailingByteValue);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void handleOneByte(byte b, char[] cArr, int i) {
            cArr[i] = (char) b;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void handleThreeBytes(byte b, byte b2, byte b3, char[] cArr, int i) throws InvalidProtocolBufferException {
            if (isNotTrailingByte(b2) || ((b == -32 && b2 < -96) || ((b == -19 && b2 >= -96) || isNotTrailingByte(b3)))) {
                throw InvalidProtocolBufferException.invalidUtf8();
            }
            cArr[i] = (char) (((b & 15) << 12) | (trailingByteValue(b2) << 6) | trailingByteValue(b3));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void handleTwoBytes(byte b, byte b2, char[] cArr, int i) throws InvalidProtocolBufferException {
            if (b < -62 || isNotTrailingByte(b2)) {
                throw InvalidProtocolBufferException.invalidUtf8();
            }
            cArr[i] = (char) (((b & 31) << 6) | trailingByteValue(b2));
        }

        private static char highSurrogate(int i) {
            return (char) ((i >>> 10) + 55232);
        }

        private static boolean isNotTrailingByte(byte b) {
            return b > -65;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean isOneByte(byte b) {
            return b >= 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean isThreeBytes(byte b) {
            return b < -16;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean isTwoBytes(byte b) {
            return b < -32;
        }

        private static char lowSurrogate(int i) {
            return (char) ((i & 1023) + 56320);
        }

        private static int trailingByteValue(byte b) {
            return b & 63;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8110460-dex2jar.jar:com/google/protobuf/Utf8$Processor.class */
    public static abstract class Processor {
        Processor() {
        }

        private static int partialIsValidUtf8(ByteBuffer byteBuffer, int i, int i2) {
            int estimateConsecutiveAscii = i + Utf8.estimateConsecutiveAscii(byteBuffer, i, i2);
            while (estimateConsecutiveAscii < i2) {
                int i3 = estimateConsecutiveAscii + 1;
                byte b = byteBuffer.get(estimateConsecutiveAscii);
                estimateConsecutiveAscii = i3;
                if (b < 0) {
                    if (b < -32) {
                        if (i3 >= i2) {
                            return b;
                        }
                        if (b < -62 || byteBuffer.get(i3) > -65) {
                            return -1;
                        }
                        estimateConsecutiveAscii = i3 + 1;
                    } else if (b < -16) {
                        if (i3 >= i2 - 1) {
                            return Utf8.incompleteStateFor(byteBuffer, b, i3, i2 - i3);
                        }
                        int i4 = i3 + 1;
                        byte b2 = byteBuffer.get(i3);
                        if (b2 > -65) {
                            return -1;
                        }
                        if (b == -32 && b2 < -96) {
                            return -1;
                        }
                        if ((b == -19 && b2 >= -96) || byteBuffer.get(i4) > -65) {
                            return -1;
                        }
                        estimateConsecutiveAscii = i4 + 1;
                    } else if (i3 >= i2 - 2) {
                        return Utf8.incompleteStateFor(byteBuffer, b, i3, i2 - i3);
                    } else {
                        int i5 = i3 + 1;
                        byte b3 = byteBuffer.get(i3);
                        if (b3 > -65 || (((b << 28) + (b3 + 112)) >> 30) != 0) {
                            return -1;
                        }
                        int i6 = i5 + 1;
                        if (byteBuffer.get(i5) > -65) {
                            return -1;
                        }
                        estimateConsecutiveAscii = i6 + 1;
                        if (byteBuffer.get(i6) > -65) {
                            return -1;
                        }
                    }
                }
            }
            return 0;
        }

        final String decodeUtf8(ByteBuffer byteBuffer, int i, int i2) throws InvalidProtocolBufferException {
            if (byteBuffer.hasArray()) {
                return decodeUtf8(byteBuffer.array(), byteBuffer.arrayOffset() + i, i2);
            }
            return byteBuffer.isDirect() ? decodeUtf8Direct(byteBuffer, i, i2) : decodeUtf8Default(byteBuffer, i, i2);
        }

        abstract String decodeUtf8(byte[] bArr, int i, int i2) throws InvalidProtocolBufferException;

        final String decodeUtf8Default(ByteBuffer byteBuffer, int i, int i2) throws InvalidProtocolBufferException {
            int i3;
            if ((i | i2 | ((byteBuffer.limit() - i) - i2)) >= 0) {
                int i4 = i + i2;
                char[] cArr = new char[i2];
                int i5 = 0;
                while (true) {
                    i3 = i5;
                    if (i >= i4) {
                        break;
                    }
                    byte b = byteBuffer.get(i);
                    if (!DecodeUtil.isOneByte(b)) {
                        break;
                    }
                    i++;
                    DecodeUtil.handleOneByte(b, cArr, i3);
                    i5 = i3 + 1;
                }
                int i6 = i;
                int i7 = i3;
                while (i6 < i4) {
                    int i8 = i6 + 1;
                    byte b2 = byteBuffer.get(i6);
                    if (DecodeUtil.isOneByte(b2)) {
                        DecodeUtil.handleOneByte(b2, cArr, i7);
                        i7++;
                        i6 = i8;
                        while (i6 < i4) {
                            byte b3 = byteBuffer.get(i6);
                            if (!DecodeUtil.isOneByte(b3)) {
                                break;
                            }
                            i6++;
                            DecodeUtil.handleOneByte(b3, cArr, i7);
                            i7++;
                        }
                    } else if (DecodeUtil.isTwoBytes(b2)) {
                        if (i8 >= i4) {
                            throw InvalidProtocolBufferException.invalidUtf8();
                        }
                        DecodeUtil.handleTwoBytes(b2, byteBuffer.get(i8), cArr, i7);
                        i6 = i8 + 1;
                        i7++;
                    } else if (DecodeUtil.isThreeBytes(b2)) {
                        if (i8 >= i4 - 1) {
                            throw InvalidProtocolBufferException.invalidUtf8();
                        }
                        int i9 = i8 + 1;
                        DecodeUtil.handleThreeBytes(b2, byteBuffer.get(i8), byteBuffer.get(i9), cArr, i7);
                        i6 = i9 + 1;
                        i7++;
                    } else if (i8 >= i4 - 2) {
                        throw InvalidProtocolBufferException.invalidUtf8();
                    } else {
                        int i10 = i8 + 1;
                        byte b4 = byteBuffer.get(i8);
                        int i11 = i10 + 1;
                        DecodeUtil.handleFourBytes(b2, b4, byteBuffer.get(i10), byteBuffer.get(i11), cArr, i7);
                        i6 = i11 + 1;
                        i7 = i7 + 1 + 1;
                    }
                }
                return new String(cArr, 0, i7);
            }
            throw new ArrayIndexOutOfBoundsException(String.format("buffer limit=%d, index=%d, limit=%d", Integer.valueOf(byteBuffer.limit()), Integer.valueOf(i), Integer.valueOf(i2)));
        }

        abstract String decodeUtf8Direct(ByteBuffer byteBuffer, int i, int i2) throws InvalidProtocolBufferException;

        abstract int encodeUtf8(CharSequence charSequence, byte[] bArr, int i, int i2);

        final void encodeUtf8(CharSequence charSequence, ByteBuffer byteBuffer) {
            if (byteBuffer.hasArray()) {
                int arrayOffset = byteBuffer.arrayOffset();
                byteBuffer.position(Utf8.encode(charSequence, byteBuffer.array(), byteBuffer.position() + arrayOffset, byteBuffer.remaining()) - arrayOffset);
            } else if (byteBuffer.isDirect()) {
                encodeUtf8Direct(charSequence, byteBuffer);
            } else {
                encodeUtf8Default(charSequence, byteBuffer);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:62:0x01d0, code lost:
            throw new com.google.protobuf.Utf8.UnpairedSurrogateException(r11, r0);
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        final void encodeUtf8Default(java.lang.CharSequence r6, java.nio.ByteBuffer r7) {
            /*
                Method dump skipped, instructions count: 702
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.Utf8.Processor.encodeUtf8Default(java.lang.CharSequence, java.nio.ByteBuffer):void");
        }

        abstract void encodeUtf8Direct(CharSequence charSequence, ByteBuffer byteBuffer);

        final boolean isValidUtf8(ByteBuffer byteBuffer, int i, int i2) {
            boolean z = false;
            if (partialIsValidUtf8(0, byteBuffer, i, i2) == 0) {
                z = true;
            }
            return z;
        }

        final boolean isValidUtf8(byte[] bArr, int i, int i2) {
            boolean z = false;
            if (partialIsValidUtf8(0, bArr, i, i2) == 0) {
                z = true;
            }
            return z;
        }

        final int partialIsValidUtf8(int i, ByteBuffer byteBuffer, int i2, int i3) {
            if (!byteBuffer.hasArray()) {
                return byteBuffer.isDirect() ? partialIsValidUtf8Direct(i, byteBuffer, i2, i3) : partialIsValidUtf8Default(i, byteBuffer, i2, i3);
            }
            int arrayOffset = byteBuffer.arrayOffset();
            return partialIsValidUtf8(i, byteBuffer.array(), i2 + arrayOffset, arrayOffset + i3);
        }

        abstract int partialIsValidUtf8(int i, byte[] bArr, int i2, int i3);

        final int partialIsValidUtf8Default(int i, ByteBuffer byteBuffer, int i2, int i3) {
            byte b;
            int i4;
            int i5 = i2;
            if (i != 0) {
                if (i2 >= i3) {
                    return i;
                }
                byte b2 = (byte) i;
                if (b2 < -32) {
                    if (b2 < -62) {
                        return -1;
                    }
                    i4 = i2 + 1;
                    if (byteBuffer.get(i2) > -65) {
                        return -1;
                    }
                } else if (b2 < -16) {
                    byte b3 = (byte) (i >> 8);
                    byte b4 = b3;
                    int i6 = i2;
                    if (b3 == 0) {
                        i6 = i2 + 1;
                        b4 = byteBuffer.get(i2);
                        if (i6 >= i3) {
                            return Utf8.incompleteStateFor(b2, b4);
                        }
                    }
                    if (b4 > -65) {
                        return -1;
                    }
                    if (b2 == -32 && b4 < -96) {
                        return -1;
                    }
                    if (b2 == -19 && b4 >= -96) {
                        return -1;
                    }
                    i4 = i6 + 1;
                    if (byteBuffer.get(i6) > -65) {
                        return -1;
                    }
                } else {
                    byte b5 = (byte) (i >> 8);
                    if (b5 == 0) {
                        int i7 = i2 + 1;
                        b5 = byteBuffer.get(i2);
                        if (i7 >= i3) {
                            return Utf8.incompleteStateFor(b2, b5);
                        }
                        i2 = i7;
                        b = 0;
                    } else {
                        b = (byte) (i >> 16);
                    }
                    byte b6 = b;
                    int i8 = i2;
                    if (b == 0) {
                        i8 = i2 + 1;
                        b6 = byteBuffer.get(i2);
                        if (i8 >= i3) {
                            return Utf8.incompleteStateFor(b2, b5, b6);
                        }
                    }
                    if (b5 > -65 || (((b2 << 28) + (b5 + 112)) >> 30) != 0 || b6 > -65) {
                        return -1;
                    }
                    i4 = i8 + 1;
                    if (byteBuffer.get(i8) > -65) {
                        return -1;
                    }
                }
                i5 = i4;
            }
            return partialIsValidUtf8(byteBuffer, i5, i3);
        }

        abstract int partialIsValidUtf8Direct(int i, ByteBuffer byteBuffer, int i2, int i3);
    }

    /* loaded from: source-8110460-dex2jar.jar:com/google/protobuf/Utf8$SafeProcessor.class */
    static final class SafeProcessor extends Processor {
        SafeProcessor() {
        }

        private static int partialIsValidUtf8(byte[] bArr, int i, int i2) {
            while (i < i2 && bArr[i] >= 0) {
                i++;
            }
            if (i >= i2) {
                return 0;
            }
            return partialIsValidUtf8NonAscii(bArr, i, i2);
        }

        private static int partialIsValidUtf8NonAscii(byte[] bArr, int i, int i2) {
            while (i < i2) {
                int i3 = i + 1;
                byte b = bArr[i];
                i = i3;
                if (b < 0) {
                    if (b < -32) {
                        if (i3 >= i2) {
                            return b;
                        }
                        if (b < -62) {
                            return -1;
                        }
                        i = i3 + 1;
                        if (bArr[i3] > -65) {
                            return -1;
                        }
                    } else if (b < -16) {
                        if (i3 >= i2 - 1) {
                            return Utf8.incompleteStateFor(bArr, i3, i2);
                        }
                        int i4 = i3 + 1;
                        byte b2 = bArr[i3];
                        if (b2 > -65) {
                            return -1;
                        }
                        if (b == -32 && b2 < -96) {
                            return -1;
                        }
                        if (b == -19 && b2 >= -96) {
                            return -1;
                        }
                        i = i4 + 1;
                        if (bArr[i4] > -65) {
                            return -1;
                        }
                    } else if (i3 >= i2 - 2) {
                        return Utf8.incompleteStateFor(bArr, i3, i2);
                    } else {
                        int i5 = i3 + 1;
                        byte b3 = bArr[i3];
                        if (b3 > -65 || (((b << 28) + (b3 + 112)) >> 30) != 0) {
                            return -1;
                        }
                        int i6 = i5 + 1;
                        if (bArr[i5] > -65) {
                            return -1;
                        }
                        i = i6 + 1;
                        if (bArr[i6] > -65) {
                            return -1;
                        }
                    }
                }
            }
            return 0;
        }

        @Override // com.google.protobuf.Utf8.Processor
        String decodeUtf8(byte[] bArr, int i, int i2) throws InvalidProtocolBufferException {
            int i3;
            if ((i | i2 | ((bArr.length - i) - i2)) >= 0) {
                int i4 = i + i2;
                char[] cArr = new char[i2];
                int i5 = 0;
                while (true) {
                    i3 = i5;
                    if (i >= i4) {
                        break;
                    }
                    byte b = bArr[i];
                    if (!DecodeUtil.isOneByte(b)) {
                        break;
                    }
                    i++;
                    DecodeUtil.handleOneByte(b, cArr, i3);
                    i5 = i3 + 1;
                }
                int i6 = i;
                int i7 = i3;
                while (i6 < i4) {
                    int i8 = i6 + 1;
                    byte b2 = bArr[i6];
                    if (DecodeUtil.isOneByte(b2)) {
                        DecodeUtil.handleOneByte(b2, cArr, i7);
                        i7++;
                        i6 = i8;
                        while (i6 < i4) {
                            byte b3 = bArr[i6];
                            if (!DecodeUtil.isOneByte(b3)) {
                                break;
                            }
                            i6++;
                            DecodeUtil.handleOneByte(b3, cArr, i7);
                            i7++;
                        }
                    } else if (DecodeUtil.isTwoBytes(b2)) {
                        if (i8 >= i4) {
                            throw InvalidProtocolBufferException.invalidUtf8();
                        }
                        DecodeUtil.handleTwoBytes(b2, bArr[i8], cArr, i7);
                        i6 = i8 + 1;
                        i7++;
                    } else if (DecodeUtil.isThreeBytes(b2)) {
                        if (i8 >= i4 - 1) {
                            throw InvalidProtocolBufferException.invalidUtf8();
                        }
                        int i9 = i8 + 1;
                        DecodeUtil.handleThreeBytes(b2, bArr[i8], bArr[i9], cArr, i7);
                        i6 = i9 + 1;
                        i7++;
                    } else if (i8 >= i4 - 2) {
                        throw InvalidProtocolBufferException.invalidUtf8();
                    } else {
                        int i10 = i8 + 1;
                        byte b4 = bArr[i8];
                        int i11 = i10 + 1;
                        DecodeUtil.handleFourBytes(b2, b4, bArr[i10], bArr[i11], cArr, i7);
                        i6 = i11 + 1;
                        i7 = i7 + 1 + 1;
                    }
                }
                return new String(cArr, 0, i7);
            }
            throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i2)));
        }

        @Override // com.google.protobuf.Utf8.Processor
        String decodeUtf8Direct(ByteBuffer byteBuffer, int i, int i2) throws InvalidProtocolBufferException {
            return decodeUtf8Default(byteBuffer, i, i2);
        }

        @Override // com.google.protobuf.Utf8.Processor
        int encodeUtf8(CharSequence charSequence, byte[] bArr, int i, int i2) {
            int i3;
            int i4;
            int i5;
            int i6;
            char charAt;
            int length = charSequence.length();
            int i7 = i2 + i;
            int i8 = 0;
            while (true) {
                i3 = i8;
                if (i3 >= length || (i6 = i3 + i) >= i7 || (charAt = charSequence.charAt(i3)) >= 128) {
                    break;
                }
                bArr[i6] = (byte) charAt;
                i8 = i3 + 1;
            }
            if (i3 == length) {
                return i + length;
            }
            int i9 = i + i3;
            int i10 = i3;
            while (i10 < length) {
                char charAt2 = charSequence.charAt(i10);
                if (charAt2 < 128 && i9 < i7) {
                    i4 = i9 + 1;
                    bArr[i9] = (byte) charAt2;
                } else if (charAt2 < 2048 && i9 <= i7 - 2) {
                    int i11 = i9 + 1;
                    bArr[i9] = (byte) ((charAt2 >>> 6) | 960);
                    i4 = i11 + 1;
                    bArr[i11] = (byte) ((charAt2 & '?') | 128);
                } else if ((charAt2 >= 55296 && 57343 >= charAt2) || i9 > i7 - 3) {
                    if (i9 > i7 - 4) {
                        if (55296 > charAt2 || charAt2 > 57343 || ((i5 = i10 + 1) != charSequence.length() && Character.isSurrogatePair(charAt2, charSequence.charAt(i5)))) {
                            throw new ArrayIndexOutOfBoundsException("Failed writing " + charAt2 + " at index " + i9);
                        }
                        throw new UnpairedSurrogateException(i10, length);
                    }
                    int i12 = i10 + 1;
                    if (i12 != charSequence.length()) {
                        char charAt3 = charSequence.charAt(i12);
                        if (Character.isSurrogatePair(charAt2, charAt3)) {
                            int codePoint = Character.toCodePoint(charAt2, charAt3);
                            int i13 = i9 + 1;
                            bArr[i9] = (byte) ((codePoint >>> 18) | 240);
                            int i14 = i13 + 1;
                            bArr[i13] = (byte) (((codePoint >>> 12) & 63) | 128);
                            int i15 = i14 + 1;
                            bArr[i14] = (byte) (((codePoint >>> 6) & 63) | 128);
                            bArr[i15] = (byte) ((codePoint & 63) | 128);
                            i10 = i12;
                            i4 = i15 + 1;
                        } else {
                            i10 = i12;
                        }
                    }
                    throw new UnpairedSurrogateException(i10 - 1, length);
                } else {
                    int i16 = i9 + 1;
                    bArr[i9] = (byte) ((charAt2 >>> '\f') | 480);
                    int i17 = i16 + 1;
                    bArr[i16] = (byte) (((charAt2 >>> 6) & 63) | 128);
                    i4 = i17 + 1;
                    bArr[i17] = (byte) ((charAt2 & '?') | 128);
                }
                i10++;
                i9 = i4;
            }
            return i9;
        }

        @Override // com.google.protobuf.Utf8.Processor
        void encodeUtf8Direct(CharSequence charSequence, ByteBuffer byteBuffer) {
            encodeUtf8Default(charSequence, byteBuffer);
        }

        @Override // com.google.protobuf.Utf8.Processor
        int partialIsValidUtf8(int i, byte[] bArr, int i2, int i3) {
            byte b;
            int i4;
            int i5 = i2;
            if (i != 0) {
                if (i2 >= i3) {
                    return i;
                }
                byte b2 = (byte) i;
                if (b2 < -32) {
                    if (b2 < -62) {
                        return -1;
                    }
                    i4 = i2 + 1;
                    if (bArr[i2] > -65) {
                        return -1;
                    }
                } else if (b2 < -16) {
                    byte b3 = (byte) (i >> 8);
                    byte b4 = b3;
                    int i6 = i2;
                    if (b3 == 0) {
                        i6 = i2 + 1;
                        b4 = bArr[i2];
                        if (i6 >= i3) {
                            return Utf8.incompleteStateFor(b2, b4);
                        }
                    }
                    if (b4 > -65) {
                        return -1;
                    }
                    if (b2 == -32 && b4 < -96) {
                        return -1;
                    }
                    if (b2 == -19 && b4 >= -96) {
                        return -1;
                    }
                    i4 = i6 + 1;
                    if (bArr[i6] > -65) {
                        return -1;
                    }
                } else {
                    byte b5 = (byte) (i >> 8);
                    if (b5 == 0) {
                        int i7 = i2 + 1;
                        b5 = bArr[i2];
                        if (i7 >= i3) {
                            return Utf8.incompleteStateFor(b2, b5);
                        }
                        i2 = i7;
                        b = 0;
                    } else {
                        b = (byte) (i >> 16);
                    }
                    byte b6 = b;
                    int i8 = i2;
                    if (b == 0) {
                        i8 = i2 + 1;
                        b6 = bArr[i2];
                        if (i8 >= i3) {
                            return Utf8.incompleteStateFor(b2, b5, b6);
                        }
                    }
                    if (b5 > -65 || (((b2 << 28) + (b5 + 112)) >> 30) != 0 || b6 > -65) {
                        return -1;
                    }
                    i4 = i8 + 1;
                    if (bArr[i8] > -65) {
                        return -1;
                    }
                }
                i5 = i4;
            }
            return partialIsValidUtf8(bArr, i5, i3);
        }

        @Override // com.google.protobuf.Utf8.Processor
        int partialIsValidUtf8Direct(int i, ByteBuffer byteBuffer, int i2, int i3) {
            return partialIsValidUtf8Default(i, byteBuffer, i2, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8110460-dex2jar.jar:com/google/protobuf/Utf8$UnpairedSurrogateException.class */
    public static class UnpairedSurrogateException extends IllegalArgumentException {
        /* JADX INFO: Access modifiers changed from: package-private */
        public UnpairedSurrogateException(int i, int i2) {
            super("Unpaired surrogate at index " + i + " of " + i2);
        }
    }

    /* loaded from: source-8110460-dex2jar.jar:com/google/protobuf/Utf8$UnsafeProcessor.class */
    static final class UnsafeProcessor extends Processor {
        UnsafeProcessor() {
        }

        static boolean isAvailable() {
            return UnsafeUtil.hasUnsafeArrayOperations() && UnsafeUtil.hasUnsafeByteBufferOperations();
        }

        private static int partialIsValidUtf8(long j, int i) {
            long j2;
            int unsafeEstimateConsecutiveAscii = unsafeEstimateConsecutiveAscii(j, i);
            long j3 = j + unsafeEstimateConsecutiveAscii;
            int i2 = i - unsafeEstimateConsecutiveAscii;
            while (true) {
                int i3 = i2;
                byte b = 0;
                while (true) {
                    j2 = j3;
                    if (i3 <= 0) {
                        break;
                    }
                    j2 = j3 + 1;
                    b = UnsafeUtil.getByte(j3);
                    if (b < 0) {
                        break;
                    }
                    i3--;
                    j3 = j2;
                }
                if (i3 == 0) {
                    return 0;
                }
                int i4 = i3 - 1;
                if (b < -32) {
                    if (i4 == 0) {
                        return b;
                    }
                    int i5 = i4 - 1;
                    if (b < -62) {
                        return -1;
                    }
                    j3 = 1 + j2;
                    i2 = i5;
                    if (UnsafeUtil.getByte(j2) > -65) {
                        return -1;
                    }
                } else if (b < -16) {
                    if (i4 < 2) {
                        return unsafeIncompleteStateFor(j2, b, i4);
                    }
                    int i6 = i4 - 2;
                    long j4 = j2 + 1;
                    byte b2 = UnsafeUtil.getByte(j2);
                    if (b2 > -65) {
                        return -1;
                    }
                    if (b == -32 && b2 < -96) {
                        return -1;
                    }
                    if (b == -19 && b2 >= -96) {
                        return -1;
                    }
                    j3 = 1 + j4;
                    i2 = i6;
                    if (UnsafeUtil.getByte(j4) > -65) {
                        return -1;
                    }
                } else if (i4 < 3) {
                    return unsafeIncompleteStateFor(j2, b, i4);
                } else {
                    int i7 = i4 - 3;
                    long j5 = j2 + 1;
                    byte b3 = UnsafeUtil.getByte(j2);
                    if (b3 > -65 || (((b << 28) + (b3 + 112)) >> 30) != 0) {
                        return -1;
                    }
                    long j6 = j5 + 1;
                    if (UnsafeUtil.getByte(j5) > -65) {
                        return -1;
                    }
                    j3 = 1 + j6;
                    i2 = i7;
                    if (UnsafeUtil.getByte(j6) > -65) {
                        return -1;
                    }
                }
            }
        }

        private static int partialIsValidUtf8(byte[] bArr, long j, int i) {
            long j2;
            int unsafeEstimateConsecutiveAscii = unsafeEstimateConsecutiveAscii(bArr, j, i);
            int i2 = i - unsafeEstimateConsecutiveAscii;
            long j3 = j + unsafeEstimateConsecutiveAscii;
            while (true) {
                int i3 = i2;
                byte b = 0;
                while (true) {
                    j2 = j3;
                    if (i3 <= 0) {
                        break;
                    }
                    j2 = j3 + 1;
                    b = UnsafeUtil.getByte(bArr, j3);
                    if (b < 0) {
                        break;
                    }
                    i3--;
                    j3 = j2;
                }
                if (i3 == 0) {
                    return 0;
                }
                int i4 = i3 - 1;
                if (b < -32) {
                    if (i4 == 0) {
                        return b;
                    }
                    int i5 = i4 - 1;
                    if (b < -62) {
                        return -1;
                    }
                    j3 = 1 + j2;
                    i2 = i5;
                    if (UnsafeUtil.getByte(bArr, j2) > -65) {
                        return -1;
                    }
                } else if (b < -16) {
                    if (i4 < 2) {
                        return unsafeIncompleteStateFor(bArr, b, j2, i4);
                    }
                    int i6 = i4 - 2;
                    long j4 = j2 + 1;
                    byte b2 = UnsafeUtil.getByte(bArr, j2);
                    if (b2 > -65) {
                        return -1;
                    }
                    if (b == -32 && b2 < -96) {
                        return -1;
                    }
                    if (b == -19 && b2 >= -96) {
                        return -1;
                    }
                    j3 = 1 + j4;
                    i2 = i6;
                    if (UnsafeUtil.getByte(bArr, j4) > -65) {
                        return -1;
                    }
                } else if (i4 < 3) {
                    return unsafeIncompleteStateFor(bArr, b, j2, i4);
                } else {
                    int i7 = i4 - 3;
                    long j5 = j2 + 1;
                    byte b3 = UnsafeUtil.getByte(bArr, j2);
                    if (b3 > -65 || (((b << 28) + (b3 + 112)) >> 30) != 0) {
                        return -1;
                    }
                    long j6 = j5 + 1;
                    if (UnsafeUtil.getByte(bArr, j5) > -65) {
                        return -1;
                    }
                    j3 = 1 + j6;
                    i2 = i7;
                    if (UnsafeUtil.getByte(bArr, j6) > -65) {
                        return -1;
                    }
                }
            }
        }

        private static int unsafeEstimateConsecutiveAscii(long j, int i) {
            int i2;
            if (i < 16) {
                return 0;
            }
            int i3 = 8 - (((int) j) & 7);
            int i4 = i3;
            while (i4 > 0) {
                if (UnsafeUtil.getByte(j) < 0) {
                    return i3 - i4;
                }
                i4--;
                j = 1 + j;
            }
            int i5 = i;
            int i6 = i3;
            while (true) {
                i2 = i5 - i6;
                if (i2 < 8 || (UnsafeUtil.getLong(j) & Utf8.ASCII_MASK_LONG) != 0) {
                    break;
                }
                j += 8;
                i5 = i2;
                i6 = 8;
            }
            return i - i2;
        }

        private static int unsafeEstimateConsecutiveAscii(byte[] bArr, long j, int i) {
            int i2 = 0;
            if (i < 16) {
                return 0;
            }
            while (i2 < i) {
                if (UnsafeUtil.getByte(bArr, j) < 0) {
                    return i2;
                }
                i2++;
                j = 1 + j;
            }
            return i;
        }

        private static int unsafeIncompleteStateFor(long j, int i, int i2) {
            if (i2 != 0) {
                if (i2 != 1) {
                    if (i2 == 2) {
                        return Utf8.incompleteStateFor(i, UnsafeUtil.getByte(j), UnsafeUtil.getByte(j + 1));
                    }
                    throw new AssertionError();
                }
                return Utf8.incompleteStateFor(i, UnsafeUtil.getByte(j));
            }
            return Utf8.incompleteStateFor(i);
        }

        private static int unsafeIncompleteStateFor(byte[] bArr, int i, long j, int i2) {
            if (i2 != 0) {
                if (i2 != 1) {
                    if (i2 == 2) {
                        return Utf8.incompleteStateFor(i, UnsafeUtil.getByte(bArr, j), UnsafeUtil.getByte(bArr, j + 1));
                    }
                    throw new AssertionError();
                }
                return Utf8.incompleteStateFor(i, UnsafeUtil.getByte(bArr, j));
            }
            return Utf8.incompleteStateFor(i);
        }

        @Override // com.google.protobuf.Utf8.Processor
        String decodeUtf8(byte[] bArr, int i, int i2) throws InvalidProtocolBufferException {
            int i3;
            if ((i | i2 | ((bArr.length - i) - i2)) >= 0) {
                int i4 = i + i2;
                char[] cArr = new char[i2];
                int i5 = 0;
                while (true) {
                    i3 = i5;
                    if (i >= i4) {
                        break;
                    }
                    byte b = UnsafeUtil.getByte(bArr, i);
                    if (!DecodeUtil.isOneByte(b)) {
                        break;
                    }
                    i++;
                    DecodeUtil.handleOneByte(b, cArr, i3);
                    i5 = i3 + 1;
                }
                int i6 = i;
                int i7 = i3;
                while (i6 < i4) {
                    int i8 = i6 + 1;
                    byte b2 = UnsafeUtil.getByte(bArr, i6);
                    if (DecodeUtil.isOneByte(b2)) {
                        DecodeUtil.handleOneByte(b2, cArr, i7);
                        i7++;
                        i6 = i8;
                        while (i6 < i4) {
                            byte b3 = UnsafeUtil.getByte(bArr, i6);
                            if (!DecodeUtil.isOneByte(b3)) {
                                break;
                            }
                            i6++;
                            DecodeUtil.handleOneByte(b3, cArr, i7);
                            i7++;
                        }
                    } else if (DecodeUtil.isTwoBytes(b2)) {
                        if (i8 >= i4) {
                            throw InvalidProtocolBufferException.invalidUtf8();
                        }
                        DecodeUtil.handleTwoBytes(b2, UnsafeUtil.getByte(bArr, i8), cArr, i7);
                        i6 = i8 + 1;
                        i7++;
                    } else if (DecodeUtil.isThreeBytes(b2)) {
                        if (i8 >= i4 - 1) {
                            throw InvalidProtocolBufferException.invalidUtf8();
                        }
                        int i9 = i8 + 1;
                        DecodeUtil.handleThreeBytes(b2, UnsafeUtil.getByte(bArr, i8), UnsafeUtil.getByte(bArr, i9), cArr, i7);
                        i6 = i9 + 1;
                        i7++;
                    } else if (i8 >= i4 - 2) {
                        throw InvalidProtocolBufferException.invalidUtf8();
                    } else {
                        int i10 = i8 + 1;
                        int i11 = i10 + 1;
                        DecodeUtil.handleFourBytes(b2, UnsafeUtil.getByte(bArr, i8), UnsafeUtil.getByte(bArr, i10), UnsafeUtil.getByte(bArr, i11), cArr, i7);
                        i6 = i11 + 1;
                        i7 = i7 + 1 + 1;
                    }
                }
                return new String(cArr, 0, i7);
            }
            throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i2)));
        }

        @Override // com.google.protobuf.Utf8.Processor
        String decodeUtf8Direct(ByteBuffer byteBuffer, int i, int i2) throws InvalidProtocolBufferException {
            int i3;
            long j;
            if ((i | i2 | ((byteBuffer.limit() - i) - i2)) >= 0) {
                long addressOffset = UnsafeUtil.addressOffset(byteBuffer) + i;
                long j2 = i2 + addressOffset;
                char[] cArr = new char[i2];
                int i4 = 0;
                while (true) {
                    int i5 = i4;
                    i3 = i5;
                    j = addressOffset;
                    if (addressOffset >= j2) {
                        break;
                    }
                    byte b = UnsafeUtil.getByte(addressOffset);
                    if (!DecodeUtil.isOneByte(b)) {
                        i3 = i5;
                        j = addressOffset;
                        break;
                    }
                    addressOffset++;
                    DecodeUtil.handleOneByte(b, cArr, i5);
                    i4 = i5 + 1;
                }
                while (true) {
                    int i6 = i3;
                    long j3 = j;
                    while (j3 < j2) {
                        long j4 = j3 + 1;
                        byte b2 = UnsafeUtil.getByte(j3);
                        if (DecodeUtil.isOneByte(b2)) {
                            DecodeUtil.handleOneByte(b2, cArr, i6);
                            i6++;
                            j3 = j4;
                            while (j3 < j2) {
                                byte b3 = UnsafeUtil.getByte(j3);
                                if (!DecodeUtil.isOneByte(b3)) {
                                    break;
                                }
                                j3++;
                                DecodeUtil.handleOneByte(b3, cArr, i6);
                                i6++;
                            }
                        } else if (DecodeUtil.isTwoBytes(b2)) {
                            if (j4 >= j2) {
                                throw InvalidProtocolBufferException.invalidUtf8();
                            }
                            j3 = j4 + 1;
                            DecodeUtil.handleTwoBytes(b2, UnsafeUtil.getByte(j4), cArr, i6);
                            i6++;
                        } else if (DecodeUtil.isThreeBytes(b2)) {
                            if (j4 >= j2 - 1) {
                                throw InvalidProtocolBufferException.invalidUtf8();
                            }
                            long j5 = j4 + 1;
                            DecodeUtil.handleThreeBytes(b2, UnsafeUtil.getByte(j4), UnsafeUtil.getByte(j5), cArr, i6);
                            i6++;
                            j3 = j5 + 1;
                        } else if (j4 >= j2 - 2) {
                            throw InvalidProtocolBufferException.invalidUtf8();
                        } else {
                            long j6 = j4 + 1;
                            byte b4 = UnsafeUtil.getByte(j4);
                            long j7 = j6 + 1;
                            j = j7 + 1;
                            DecodeUtil.handleFourBytes(b2, b4, UnsafeUtil.getByte(j6), UnsafeUtil.getByte(j7), cArr, i6);
                            i3 = i6 + 1 + 1;
                        }
                    }
                    return new String(cArr, 0, i6);
                }
            }
            throw new ArrayIndexOutOfBoundsException(String.format("buffer limit=%d, index=%d, limit=%d", Integer.valueOf(byteBuffer.limit()), Integer.valueOf(i), Integer.valueOf(i2)));
        }

        @Override // com.google.protobuf.Utf8.Processor
        int encodeUtf8(CharSequence charSequence, byte[] bArr, int i, int i2) {
            long j;
            long j2;
            int i3;
            char charAt;
            long j3 = i;
            long j4 = i2 + j3;
            int length = charSequence.length();
            if (length > i2 || bArr.length - i2 < i) {
                throw new ArrayIndexOutOfBoundsException("Failed writing " + charSequence.charAt(length - 1) + " at index " + (i + i2));
            }
            int i4 = 0;
            while (true) {
                j = 1;
                if (i4 >= length || (charAt = charSequence.charAt(i4)) >= 128) {
                    break;
                }
                UnsafeUtil.putByte(bArr, j3, (byte) charAt);
                i4++;
                j3 = 1 + j3;
            }
            int i5 = i4;
            long j5 = j3;
            if (i4 == length) {
                return (int) j3;
            }
            while (i5 < length) {
                char charAt2 = charSequence.charAt(i5);
                if (charAt2 < 128 && j5 < j4) {
                    UnsafeUtil.putByte(bArr, j5, (byte) charAt2);
                    j2 = j5 + j;
                    j = j;
                } else if (charAt2 < 2048 && j5 <= j4 - 2) {
                    long j6 = j5 + j;
                    UnsafeUtil.putByte(bArr, j5, (byte) ((charAt2 >>> 6) | 960));
                    UnsafeUtil.putByte(bArr, j6, (byte) ((charAt2 & '?') | 128));
                    j2 = j6 + j;
                } else if ((charAt2 >= 55296 && 57343 >= charAt2) || j5 > j4 - 3) {
                    if (j5 > j4 - 4) {
                        if (55296 > charAt2 || charAt2 > 57343 || ((i3 = i5 + 1) != length && Character.isSurrogatePair(charAt2, charSequence.charAt(i3)))) {
                            throw new ArrayIndexOutOfBoundsException("Failed writing " + charAt2 + " at index " + j5);
                        }
                        throw new UnpairedSurrogateException(i5, length);
                    }
                    int i6 = i5 + 1;
                    if (i6 != length) {
                        char charAt3 = charSequence.charAt(i6);
                        if (Character.isSurrogatePair(charAt2, charAt3)) {
                            int codePoint = Character.toCodePoint(charAt2, charAt3);
                            long j7 = j5 + 1;
                            UnsafeUtil.putByte(bArr, j5, (byte) ((codePoint >>> 18) | 240));
                            long j8 = j7 + 1;
                            UnsafeUtil.putByte(bArr, j7, (byte) (((codePoint >>> 12) & 63) | 128));
                            long j9 = j8 + 1;
                            UnsafeUtil.putByte(bArr, j8, (byte) (((codePoint >>> 6) & 63) | 128));
                            j = 1;
                            j2 = j9 + 1;
                            UnsafeUtil.putByte(bArr, j9, (byte) ((codePoint & 63) | 128));
                            i5 = i6;
                        } else {
                            i5 = i6;
                        }
                    }
                    throw new UnpairedSurrogateException(i5 - 1, length);
                } else {
                    long j10 = j5 + j;
                    UnsafeUtil.putByte(bArr, j5, (byte) ((charAt2 >>> '\f') | 480));
                    long j11 = j10 + j;
                    UnsafeUtil.putByte(bArr, j10, (byte) (((charAt2 >>> 6) & 63) | 128));
                    UnsafeUtil.putByte(bArr, j11, (byte) ((charAt2 & '?') | 128));
                    j2 = j11 + 1;
                    j = 1;
                }
                i5++;
                j5 = j2;
            }
            return (int) j5;
        }

        @Override // com.google.protobuf.Utf8.Processor
        void encodeUtf8Direct(CharSequence charSequence, ByteBuffer byteBuffer) {
            long j;
            int i;
            char charAt;
            long addressOffset = UnsafeUtil.addressOffset(byteBuffer);
            long position = byteBuffer.position() + addressOffset;
            long limit = byteBuffer.limit() + addressOffset;
            int length = charSequence.length();
            if (length > limit - position) {
                throw new ArrayIndexOutOfBoundsException("Failed writing " + charSequence.charAt(length - 1) + " at index " + byteBuffer.limit());
            }
            int i2 = 0;
            while (i2 < length && (charAt = charSequence.charAt(i2)) < 128) {
                UnsafeUtil.putByte(position, (byte) charAt);
                i2++;
                position++;
            }
            long j2 = position;
            int i3 = i2;
            if (i2 == length) {
                byteBuffer.position((int) (position - addressOffset));
                return;
            }
            while (i3 < length) {
                char charAt2 = charSequence.charAt(i3);
                if (charAt2 < 128 && j2 < limit) {
                    UnsafeUtil.putByte(j2, (byte) charAt2);
                    j = j2 + 1;
                } else if (charAt2 < 2048 && j2 <= limit - 2) {
                    long j3 = j2 + 1;
                    UnsafeUtil.putByte(j2, (byte) ((charAt2 >>> 6) | 960));
                    UnsafeUtil.putByte(j3, (byte) ((charAt2 & '?') | 128));
                    j = j3 + 1;
                } else if ((charAt2 >= 55296 && 57343 >= charAt2) || j2 > limit - 3) {
                    if (j2 > limit - 4) {
                        if (55296 <= charAt2 && charAt2 <= 57343 && ((i = i3 + 1) == length || !Character.isSurrogatePair(charAt2, charSequence.charAt(i)))) {
                            throw new UnpairedSurrogateException(i3, length);
                        }
                        throw new ArrayIndexOutOfBoundsException("Failed writing " + charAt2 + " at index " + j2);
                    }
                    int i4 = i3 + 1;
                    if (i4 != length) {
                        char charAt3 = charSequence.charAt(i4);
                        if (Character.isSurrogatePair(charAt2, charAt3)) {
                            int codePoint = Character.toCodePoint(charAt2, charAt3);
                            long j4 = j2 + 1;
                            UnsafeUtil.putByte(j2, (byte) ((codePoint >>> 18) | 240));
                            long j5 = j4 + 1;
                            UnsafeUtil.putByte(j4, (byte) (((codePoint >>> 12) & 63) | 128));
                            long j6 = j5 + 1;
                            UnsafeUtil.putByte(j5, (byte) (((codePoint >>> 6) & 63) | 128));
                            UnsafeUtil.putByte(j6, (byte) ((codePoint & 63) | 128));
                            j = j6 + 1;
                            i3 = i4;
                        } else {
                            i3 = i4;
                        }
                    }
                    throw new UnpairedSurrogateException(i3 - 1, length);
                } else {
                    long j7 = j2 + 1;
                    UnsafeUtil.putByte(j2, (byte) ((charAt2 >>> '\f') | 480));
                    long j8 = j7 + 1;
                    UnsafeUtil.putByte(j7, (byte) (((charAt2 >>> 6) & 63) | 128));
                    UnsafeUtil.putByte(j8, (byte) ((charAt2 & '?') | 128));
                    j = j8 + 1;
                }
                i3++;
                j2 = j;
            }
            byteBuffer.position((int) (j2 - addressOffset));
        }

        @Override // com.google.protobuf.Utf8.Processor
        int partialIsValidUtf8(int i, byte[] bArr, int i2, int i3) {
            byte b;
            long j;
            if ((i2 | i3 | (bArr.length - i3)) >= 0) {
                long j2 = i2;
                long j3 = i3;
                long j4 = j2;
                if (i != 0) {
                    if (j2 >= j3) {
                        return i;
                    }
                    byte b2 = (byte) i;
                    if (b2 >= -32) {
                        if (b2 < -16) {
                            byte b3 = (byte) (i >> 8);
                            long j5 = j2;
                            byte b4 = b3;
                            if (b3 == 0) {
                                j5 = j2 + 1;
                                b4 = UnsafeUtil.getByte(bArr, j2);
                                if (j5 >= j3) {
                                    return Utf8.incompleteStateFor(b2, b4);
                                }
                            }
                            if (b4 > -65) {
                                return -1;
                            }
                            if (b2 == -32 && b4 < -96) {
                                return -1;
                            }
                            if (b2 == -19 && b4 >= -96) {
                                return -1;
                            }
                            j = j5 + 1;
                            if (UnsafeUtil.getByte(bArr, j5) > -65) {
                                return -1;
                            }
                        } else {
                            byte b5 = (byte) (i >> 8);
                            if (b5 == 0) {
                                long j6 = j2 + 1;
                                b5 = UnsafeUtil.getByte(bArr, j2);
                                if (j6 >= j3) {
                                    return Utf8.incompleteStateFor(b2, b5);
                                }
                                j2 = j6;
                                b = 0;
                            } else {
                                b = (byte) (i >> 16);
                            }
                            byte b6 = b;
                            long j7 = j2;
                            if (b == 0) {
                                j7 = j2 + 1;
                                b6 = UnsafeUtil.getByte(bArr, j2);
                                if (j7 >= j3) {
                                    return Utf8.incompleteStateFor(b2, b5, b6);
                                }
                            }
                            if (b5 > -65 || (((b2 << 28) + (b5 + 112)) >> 30) != 0 || b6 > -65) {
                                return -1;
                            }
                            j = j7 + 1;
                            if (UnsafeUtil.getByte(bArr, j7) > -65) {
                                return -1;
                            }
                        }
                        j4 = j;
                    } else if (b2 < -62 || UnsafeUtil.getByte(bArr, j2) > -65) {
                        return -1;
                    } else {
                        j4 = 1 + j2;
                    }
                }
                return partialIsValidUtf8(bArr, j4, (int) (j3 - j4));
            }
            throw new ArrayIndexOutOfBoundsException(String.format("Array length=%d, index=%d, limit=%d", Integer.valueOf(bArr.length), Integer.valueOf(i2), Integer.valueOf(i3)));
        }

        @Override // com.google.protobuf.Utf8.Processor
        int partialIsValidUtf8Direct(int i, ByteBuffer byteBuffer, int i2, int i3) {
            byte b;
            long j;
            if ((i2 | i3 | (byteBuffer.limit() - i3)) >= 0) {
                long addressOffset = UnsafeUtil.addressOffset(byteBuffer) + i2;
                long j2 = (i3 - i2) + addressOffset;
                long j3 = addressOffset;
                if (i != 0) {
                    if (addressOffset >= j2) {
                        return i;
                    }
                    byte b2 = (byte) i;
                    if (b2 >= -32) {
                        if (b2 < -16) {
                            byte b3 = (byte) (i >> 8);
                            long j4 = addressOffset;
                            byte b4 = b3;
                            if (b3 == 0) {
                                j4 = addressOffset + 1;
                                b4 = UnsafeUtil.getByte(addressOffset);
                                if (j4 >= j2) {
                                    return Utf8.incompleteStateFor(b2, b4);
                                }
                            }
                            if (b4 > -65) {
                                return -1;
                            }
                            if (b2 == -32 && b4 < -96) {
                                return -1;
                            }
                            if (b2 == -19 && b4 >= -96) {
                                return -1;
                            }
                            j = j4 + 1;
                            if (UnsafeUtil.getByte(j4) > -65) {
                                return -1;
                            }
                        } else {
                            byte b5 = (byte) (i >> 8);
                            if (b5 == 0) {
                                long j5 = addressOffset + 1;
                                b5 = UnsafeUtil.getByte(addressOffset);
                                if (j5 >= j2) {
                                    return Utf8.incompleteStateFor(b2, b5);
                                }
                                addressOffset = j5;
                                b = 0;
                            } else {
                                b = (byte) (i >> 16);
                            }
                            byte b6 = b;
                            long j6 = addressOffset;
                            if (b == 0) {
                                j6 = addressOffset + 1;
                                b6 = UnsafeUtil.getByte(addressOffset);
                                if (j6 >= j2) {
                                    return Utf8.incompleteStateFor(b2, b5, b6);
                                }
                            }
                            if (b5 > -65 || (((b2 << 28) + (b5 + 112)) >> 30) != 0 || b6 > -65) {
                                return -1;
                            }
                            j = j6 + 1;
                            if (UnsafeUtil.getByte(j6) > -65) {
                                return -1;
                            }
                        }
                        j3 = j;
                    } else if (b2 < -62 || UnsafeUtil.getByte(addressOffset) > -65) {
                        return -1;
                    } else {
                        j3 = 1 + addressOffset;
                    }
                }
                return partialIsValidUtf8(j3, (int) (j2 - j3));
            }
            throw new ArrayIndexOutOfBoundsException(String.format("buffer limit=%d, index=%d, limit=%d", Integer.valueOf(byteBuffer.limit()), Integer.valueOf(i2), Integer.valueOf(i3)));
        }
    }

    static {
        processor = (!UnsafeProcessor.isAvailable() || Android.isOnAndroidDevice()) ? new SafeProcessor() : new UnsafeProcessor();
    }

    private Utf8() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String decodeUtf8(ByteBuffer byteBuffer, int i, int i2) throws InvalidProtocolBufferException {
        return processor.decodeUtf8(byteBuffer, i, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String decodeUtf8(byte[] bArr, int i, int i2) throws InvalidProtocolBufferException {
        return processor.decodeUtf8(bArr, i, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int encode(CharSequence charSequence, byte[] bArr, int i, int i2) {
        return processor.encodeUtf8(charSequence, bArr, i, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void encodeUtf8(CharSequence charSequence, ByteBuffer byteBuffer) {
        processor.encodeUtf8(charSequence, byteBuffer);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int encodedLength(CharSequence charSequence) {
        int i;
        int i2;
        int length = charSequence.length();
        int i3 = 0;
        while (true) {
            i = i3;
            if (i >= length || charSequence.charAt(i) >= 128) {
                break;
            }
            i3 = i + 1;
        }
        int i4 = length;
        while (true) {
            i2 = i4;
            if (i < length) {
                char charAt = charSequence.charAt(i);
                if (charAt >= 2048) {
                    i2 = i4 + encodedLengthGeneral(charSequence, i);
                    break;
                }
                i4 += (127 - charAt) >>> 31;
                i++;
            } else {
                break;
            }
        }
        if (i2 >= length) {
            return i2;
        }
        throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (i2 + 4294967296L));
    }

    private static int encodedLengthGeneral(CharSequence charSequence, int i) {
        int i2;
        int length = charSequence.length();
        int i3 = 0;
        while (i < length) {
            char charAt = charSequence.charAt(i);
            if (charAt < 2048) {
                i3 += (127 - charAt) >>> 31;
                i2 = i;
            } else {
                int i4 = i3 + 2;
                i3 = i4;
                i2 = i;
                if (55296 <= charAt) {
                    i3 = i4;
                    i2 = i;
                    if (charAt > 57343) {
                        continue;
                    } else if (Character.codePointAt(charSequence, i) < 65536) {
                        throw new UnpairedSurrogateException(i, length);
                    } else {
                        i2 = i + 1;
                        i3 = i4;
                    }
                } else {
                    continue;
                }
            }
            i = i2 + 1;
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int estimateConsecutiveAscii(ByteBuffer byteBuffer, int i, int i2) {
        int i3;
        int i4 = i;
        while (true) {
            i3 = i4;
            if (i3 >= i2 - 7 || (byteBuffer.getLong(i3) & ASCII_MASK_LONG) != 0) {
                break;
            }
            i4 = i3 + 8;
        }
        return i3 - i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int incompleteStateFor(int i) {
        int i2 = i;
        if (i > -12) {
            i2 = -1;
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int incompleteStateFor(int i, int i2) {
        if (i > -12 || i2 > -65) {
            return -1;
        }
        return i ^ (i2 << 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int incompleteStateFor(int i, int i2, int i3) {
        if (i > -12 || i2 > -65 || i3 > -65) {
            return -1;
        }
        return (i ^ (i2 << 8)) ^ (i3 << 16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int incompleteStateFor(ByteBuffer byteBuffer, int i, int i2, int i3) {
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    return incompleteStateFor(i, byteBuffer.get(i2), byteBuffer.get(i2 + 1));
                }
                throw new AssertionError();
            }
            return incompleteStateFor(i, byteBuffer.get(i2));
        }
        return incompleteStateFor(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int incompleteStateFor(byte[] bArr, int i, int i2) {
        byte b = bArr[i - 1];
        int i3 = i2 - i;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    return incompleteStateFor(b, bArr[i], bArr[i + 1]);
                }
                throw new AssertionError();
            }
            return incompleteStateFor(b, bArr[i]);
        }
        return incompleteStateFor(b);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isValidUtf8(ByteBuffer byteBuffer) {
        return processor.isValidUtf8(byteBuffer, byteBuffer.position(), byteBuffer.remaining());
    }

    public static boolean isValidUtf8(byte[] bArr) {
        return processor.isValidUtf8(bArr, 0, bArr.length);
    }

    public static boolean isValidUtf8(byte[] bArr, int i, int i2) {
        return processor.isValidUtf8(bArr, i, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int partialIsValidUtf8(int i, ByteBuffer byteBuffer, int i2, int i3) {
        return processor.partialIsValidUtf8(i, byteBuffer, i2, i3);
    }

    public static int partialIsValidUtf8(int i, byte[] bArr, int i2, int i3) {
        return processor.partialIsValidUtf8(i, bArr, i2, i3);
    }
}
