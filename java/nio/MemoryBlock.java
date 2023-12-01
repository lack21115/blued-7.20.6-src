package java.nio;

import android.system.ErrnoException;
import android.system.OsConstants;
import dalvik.system.VMRuntime;
import java.io.FileDescriptor;
import java.io.IOException;
import java.nio.channels.FileChannel;
import libcore.io.Libcore;
import libcore.io.Memory;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-2895416-dex2jar.jar:java/nio/MemoryBlock.class */
public class MemoryBlock {
    private boolean accessible;
    protected long address;
    private boolean freed;
    protected final long size;

    /* loaded from: source-2895416-dex2jar.jar:java/nio/MemoryBlock$MemoryMappedBlock.class */
    private static class MemoryMappedBlock extends MemoryBlock {
        private MemoryMappedBlock(long j, long j2) {
            super(j, j2);
        }

        protected void finalize() throws Throwable {
            free();
        }

        @Override // java.nio.MemoryBlock
        public void free() {
            if (this.address != 0) {
                try {
                    Libcore.os.munmap(this.address, this.size);
                } catch (ErrnoException e) {
                    throw new AssertionError(e);
                }
            }
            super.free();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-2895416-dex2jar.jar:java/nio/MemoryBlock$NonMovableHeapBlock.class */
    public static class NonMovableHeapBlock extends MemoryBlock {
        private byte[] array;

        private NonMovableHeapBlock(byte[] bArr, long j, long j2) {
            super(j, j2);
            this.array = bArr;
        }

        @Override // java.nio.MemoryBlock
        public byte[] array() {
            return this.array;
        }

        @Override // java.nio.MemoryBlock
        public void free() {
            this.array = null;
            super.free();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-2895416-dex2jar.jar:java/nio/MemoryBlock$UnmanagedBlock.class */
    public static class UnmanagedBlock extends MemoryBlock {
        private UnmanagedBlock(long j, long j2) {
            super(j, j2);
        }
    }

    private MemoryBlock(long j, long j2) {
        this.address = j;
        this.size = j2;
        this.accessible = true;
        this.freed = false;
    }

    public static MemoryBlock allocate(int i) {
        VMRuntime runtime = VMRuntime.getRuntime();
        byte[] bArr = (byte[]) runtime.newNonMovableArray(Byte.TYPE, i);
        return new NonMovableHeapBlock(bArr, runtime.addressOf(bArr), i);
    }

    public static MemoryBlock mmap(FileDescriptor fileDescriptor, long j, long j2, FileChannel.MapMode mapMode) throws IOException {
        int i;
        int i2;
        if (j2 == 0) {
            return new MemoryBlock(0L, 0L);
        }
        if (j < 0 || j2 < 0 || j > 2147483647L || j2 > 2147483647L) {
            throw new IllegalArgumentException("offset=" + j + " size=" + j2);
        }
        if (mapMode == FileChannel.MapMode.PRIVATE) {
            i = OsConstants.PROT_READ | OsConstants.PROT_WRITE;
            i2 = OsConstants.MAP_PRIVATE;
        } else if (mapMode == FileChannel.MapMode.READ_ONLY) {
            i = OsConstants.PROT_READ;
            i2 = OsConstants.MAP_SHARED;
        } else {
            i = OsConstants.PROT_READ | OsConstants.PROT_WRITE;
            i2 = OsConstants.MAP_SHARED;
        }
        try {
            return new MemoryMappedBlock(Libcore.os.mmap(0L, j2, i, i2, fileDescriptor, j), j2);
        } catch (ErrnoException e) {
            throw e.rethrowAsIOException();
        }
    }

    public static MemoryBlock wrapFromJni(long j, long j2) {
        return new UnmanagedBlock(j, j2);
    }

    public byte[] array() {
        return null;
    }

    public void free() {
        this.address = 0L;
        this.freed = true;
    }

    public final long getSize() {
        return this.size;
    }

    public boolean isAccessible() {
        return !isFreed() && this.accessible;
    }

    public boolean isFreed() {
        return this.freed;
    }

    public final byte peekByte(int i) {
        return Memory.peekByte(this.address + i);
    }

    public final void peekByteArray(int i, byte[] bArr, int i2, int i3) {
        Memory.peekByteArray(this.address + i, bArr, i2, i3);
    }

    public final void peekCharArray(int i, char[] cArr, int i2, int i3, boolean z) {
        Memory.peekCharArray(this.address + i, cArr, i2, i3, z);
    }

    public final void peekDoubleArray(int i, double[] dArr, int i2, int i3, boolean z) {
        Memory.peekDoubleArray(this.address + i, dArr, i2, i3, z);
    }

    public final void peekFloatArray(int i, float[] fArr, int i2, int i3, boolean z) {
        Memory.peekFloatArray(this.address + i, fArr, i2, i3, z);
    }

    public final int peekInt(int i, ByteOrder byteOrder) {
        return Memory.peekInt(this.address + i, byteOrder.needsSwap);
    }

    public final void peekIntArray(int i, int[] iArr, int i2, int i3, boolean z) {
        Memory.peekIntArray(this.address + i, iArr, i2, i3, z);
    }

    public final long peekLong(int i, ByteOrder byteOrder) {
        return Memory.peekLong(this.address + i, byteOrder.needsSwap);
    }

    public final void peekLongArray(int i, long[] jArr, int i2, int i3, boolean z) {
        Memory.peekLongArray(this.address + i, jArr, i2, i3, z);
    }

    public final short peekShort(int i, ByteOrder byteOrder) {
        return Memory.peekShort(this.address + i, byteOrder.needsSwap);
    }

    public final void peekShortArray(int i, short[] sArr, int i2, int i3, boolean z) {
        Memory.peekShortArray(this.address + i, sArr, i2, i3, z);
    }

    public final void pokeByte(int i, byte b) {
        Memory.pokeByte(this.address + i, b);
    }

    public final void pokeByteArray(int i, byte[] bArr, int i2, int i3) {
        Memory.pokeByteArray(this.address + i, bArr, i2, i3);
    }

    public final void pokeCharArray(int i, char[] cArr, int i2, int i3, boolean z) {
        Memory.pokeCharArray(this.address + i, cArr, i2, i3, z);
    }

    public final void pokeDoubleArray(int i, double[] dArr, int i2, int i3, boolean z) {
        Memory.pokeDoubleArray(this.address + i, dArr, i2, i3, z);
    }

    public final void pokeFloatArray(int i, float[] fArr, int i2, int i3, boolean z) {
        Memory.pokeFloatArray(this.address + i, fArr, i2, i3, z);
    }

    public final void pokeInt(int i, int i2, ByteOrder byteOrder) {
        Memory.pokeInt(this.address + i, i2, byteOrder.needsSwap);
    }

    public final void pokeIntArray(int i, int[] iArr, int i2, int i3, boolean z) {
        Memory.pokeIntArray(this.address + i, iArr, i2, i3, z);
    }

    public final void pokeLong(int i, long j, ByteOrder byteOrder) {
        Memory.pokeLong(this.address + i, j, byteOrder.needsSwap);
    }

    public final void pokeLongArray(int i, long[] jArr, int i2, int i3, boolean z) {
        Memory.pokeLongArray(this.address + i, jArr, i2, i3, z);
    }

    public final void pokeShort(int i, short s, ByteOrder byteOrder) {
        Memory.pokeShort(this.address + i, s, byteOrder.needsSwap);
    }

    public final void pokeShortArray(int i, short[] sArr, int i2, int i3, boolean z) {
        Memory.pokeShortArray(this.address + i, sArr, i2, i3, z);
    }

    public final void setAccessible(boolean z) {
        this.accessible = z;
    }

    public final long toLong() {
        return this.address;
    }

    public final String toString() {
        return getClass().getName() + "[" + this.address + "]";
    }
}
