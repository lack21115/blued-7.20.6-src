package com.android.dex;

/* loaded from: source-2895416-dex2jar.jar:com/android/dex/Code.class */
public final class Code {
    private final CatchHandler[] catchHandlers;
    private final int debugInfoOffset;
    private final int insSize;
    private final short[] instructions;
    private final int outsSize;
    private final int registersSize;
    private final Try[] tries;

    /* loaded from: source-2895416-dex2jar.jar:com/android/dex/Code$CatchHandler.class */
    public static class CatchHandler {
        final int[] addresses;
        final int catchAllAddress;
        final int offset;
        final int[] typeIndexes;

        public CatchHandler(int[] iArr, int[] iArr2, int i, int i2) {
            this.typeIndexes = iArr;
            this.addresses = iArr2;
            this.catchAllAddress = i;
            this.offset = i2;
        }

        public int[] getAddresses() {
            return this.addresses;
        }

        public int getCatchAllAddress() {
            return this.catchAllAddress;
        }

        public int getOffset() {
            return this.offset;
        }

        public int[] getTypeIndexes() {
            return this.typeIndexes;
        }
    }

    /* loaded from: source-2895416-dex2jar.jar:com/android/dex/Code$Try.class */
    public static class Try {
        final int catchHandlerIndex;
        final int instructionCount;
        final int startAddress;

        /* JADX INFO: Access modifiers changed from: package-private */
        public Try(int i, int i2, int i3) {
            this.startAddress = i;
            this.instructionCount = i2;
            this.catchHandlerIndex = i3;
        }

        public int getCatchHandlerIndex() {
            return this.catchHandlerIndex;
        }

        public int getInstructionCount() {
            return this.instructionCount;
        }

        public int getStartAddress() {
            return this.startAddress;
        }
    }

    public Code(int i, int i2, int i3, int i4, short[] sArr, Try[] tryArr, CatchHandler[] catchHandlerArr) {
        this.registersSize = i;
        this.insSize = i2;
        this.outsSize = i3;
        this.debugInfoOffset = i4;
        this.instructions = sArr;
        this.tries = tryArr;
        this.catchHandlers = catchHandlerArr;
    }

    public CatchHandler[] getCatchHandlers() {
        return this.catchHandlers;
    }

    public int getDebugInfoOffset() {
        return this.debugInfoOffset;
    }

    public int getInsSize() {
        return this.insSize;
    }

    public short[] getInstructions() {
        return this.instructions;
    }

    public int getOutsSize() {
        return this.outsSize;
    }

    public int getRegistersSize() {
        return this.registersSize;
    }

    public Try[] getTries() {
        return this.tries;
    }
}
