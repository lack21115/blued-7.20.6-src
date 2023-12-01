package com.tencent.tinker.commons.dexpatcher.struct;

import com.tencent.tinker.android.dex.io.DexDataBuffer;
import com.tencent.tinker.android.dex.util.CompareUtils;
import com.tencent.tinker.android.dex.util.FileUtils;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tinker/commons/dexpatcher/struct/DexPatchFile.class */
public final class DexPatchFile {
    public static final short CURRENT_VERSION = 2;
    public static final byte[] MAGIC = {68, 88, 68, 73, 70, 70};
    private final DexDataBuffer buffer;
    private int firstChunkOffset;
    private byte[] oldDexSignature;
    private int patchedAnnotationSectionOffset;
    private int patchedAnnotationSetRefListSectionOffset;
    private int patchedAnnotationSetSectionOffset;
    private int patchedAnnotationsDirectorySectionOffset;
    private int patchedClassDataSectionOffset;
    private int patchedClassDefSectionOffset;
    private int patchedCodeSectionOffset;
    private int patchedDebugInfoSectionOffset;
    private int patchedDexSize;
    private int patchedEncodedArraySectionOffset;
    private int patchedFieldIdSectionOffset;
    private int patchedMapListSectionOffset;
    private int patchedMethodIdSectionOffset;
    private int patchedProtoIdSectionOffset;
    private int patchedStringDataSectionOffset;
    private int patchedStringIdSectionOffset;
    private int patchedTypeIdSectionOffset;
    private int patchedTypeListSectionOffset;
    private short version;

    public DexPatchFile(File file) throws IOException {
        this.buffer = new DexDataBuffer(ByteBuffer.wrap(FileUtils.readFile(file)));
        init();
    }

    public DexPatchFile(InputStream inputStream) throws IOException {
        this.buffer = new DexDataBuffer(ByteBuffer.wrap(FileUtils.readStream(inputStream)));
        init();
    }

    private void init() {
        byte[] readByteArray = this.buffer.readByteArray(MAGIC.length);
        if (CompareUtils.uArrCompare(readByteArray, MAGIC) != 0) {
            throw new IllegalStateException("bad dex patch file magic: " + Arrays.toString(readByteArray));
        }
        short readShort = this.buffer.readShort();
        this.version = readShort;
        if (CompareUtils.uCompare(readShort, (short) 2) != 0) {
            throw new IllegalStateException("bad dex patch file version: " + ((int) this.version) + ", expected: 2");
        }
        this.patchedDexSize = this.buffer.readInt();
        this.firstChunkOffset = this.buffer.readInt();
        this.patchedStringIdSectionOffset = this.buffer.readInt();
        this.patchedTypeIdSectionOffset = this.buffer.readInt();
        this.patchedProtoIdSectionOffset = this.buffer.readInt();
        this.patchedFieldIdSectionOffset = this.buffer.readInt();
        this.patchedMethodIdSectionOffset = this.buffer.readInt();
        this.patchedClassDefSectionOffset = this.buffer.readInt();
        this.patchedMapListSectionOffset = this.buffer.readInt();
        this.patchedTypeListSectionOffset = this.buffer.readInt();
        this.patchedAnnotationSetRefListSectionOffset = this.buffer.readInt();
        this.patchedAnnotationSetSectionOffset = this.buffer.readInt();
        this.patchedClassDataSectionOffset = this.buffer.readInt();
        this.patchedCodeSectionOffset = this.buffer.readInt();
        this.patchedStringDataSectionOffset = this.buffer.readInt();
        this.patchedDebugInfoSectionOffset = this.buffer.readInt();
        this.patchedAnnotationSectionOffset = this.buffer.readInt();
        this.patchedEncodedArraySectionOffset = this.buffer.readInt();
        this.patchedAnnotationsDirectorySectionOffset = this.buffer.readInt();
        this.oldDexSignature = this.buffer.readByteArray(20);
        this.buffer.position(this.firstChunkOffset);
    }

    public DexDataBuffer getBuffer() {
        return this.buffer;
    }

    public byte[] getOldDexSignature() {
        return this.oldDexSignature;
    }

    public int getPatchedAnnotationSectionOffset() {
        return this.patchedAnnotationSectionOffset;
    }

    public int getPatchedAnnotationSetRefListSectionOffset() {
        return this.patchedAnnotationSetRefListSectionOffset;
    }

    public int getPatchedAnnotationSetSectionOffset() {
        return this.patchedAnnotationSetSectionOffset;
    }

    public int getPatchedAnnotationsDirectorySectionOffset() {
        return this.patchedAnnotationsDirectorySectionOffset;
    }

    public int getPatchedClassDataSectionOffset() {
        return this.patchedClassDataSectionOffset;
    }

    public int getPatchedClassDefSectionOffset() {
        return this.patchedClassDefSectionOffset;
    }

    public int getPatchedCodeSectionOffset() {
        return this.patchedCodeSectionOffset;
    }

    public int getPatchedDebugInfoSectionOffset() {
        return this.patchedDebugInfoSectionOffset;
    }

    public int getPatchedDexSize() {
        return this.patchedDexSize;
    }

    public int getPatchedEncodedArraySectionOffset() {
        return this.patchedEncodedArraySectionOffset;
    }

    public int getPatchedFieldIdSectionOffset() {
        return this.patchedFieldIdSectionOffset;
    }

    public int getPatchedMapListSectionOffset() {
        return this.patchedMapListSectionOffset;
    }

    public int getPatchedMethodIdSectionOffset() {
        return this.patchedMethodIdSectionOffset;
    }

    public int getPatchedProtoIdSectionOffset() {
        return this.patchedProtoIdSectionOffset;
    }

    public int getPatchedStringDataSectionOffset() {
        return this.patchedStringDataSectionOffset;
    }

    public int getPatchedStringIdSectionOffset() {
        return this.patchedStringIdSectionOffset;
    }

    public int getPatchedTypeIdSectionOffset() {
        return this.patchedTypeIdSectionOffset;
    }

    public int getPatchedTypeListSectionOffset() {
        return this.patchedTypeListSectionOffset;
    }

    public short getVersion() {
        return this.version;
    }
}
