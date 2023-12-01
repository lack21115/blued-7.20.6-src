package android.renderscript;

import android.renderscript.Type;

/* loaded from: source-9557208-dex2jar.jar:android/renderscript/AllocationAdapter.class */
public class AllocationAdapter extends Allocation {
    AllocationAdapter(long j, RenderScript renderScript, Allocation allocation) {
        super(j, renderScript, allocation.mType, allocation.mUsage);
        this.mAdaptedAllocation = allocation;
    }

    public static AllocationAdapter create1D(RenderScript renderScript, Allocation allocation) {
        renderScript.validate();
        AllocationAdapter allocationAdapter = new AllocationAdapter(0L, renderScript, allocation);
        allocationAdapter.mConstrainedLOD = true;
        allocationAdapter.mConstrainedFace = true;
        allocationAdapter.mConstrainedY = true;
        allocationAdapter.mConstrainedZ = true;
        allocationAdapter.initLOD(0);
        return allocationAdapter;
    }

    public static AllocationAdapter create2D(RenderScript renderScript, Allocation allocation) {
        renderScript.validate();
        AllocationAdapter allocationAdapter = new AllocationAdapter(0L, renderScript, allocation);
        allocationAdapter.mConstrainedLOD = true;
        allocationAdapter.mConstrainedFace = true;
        allocationAdapter.mConstrainedY = false;
        allocationAdapter.mConstrainedZ = true;
        allocationAdapter.initLOD(0);
        return allocationAdapter;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // android.renderscript.BaseObj
    public long getID(RenderScript renderScript) {
        throw new RSInvalidStateException("This operation is not supported with adapters at this time.");
    }

    void initLOD(int i) {
        if (i < 0) {
            throw new RSIllegalArgumentException("Attempting to set negative lod (" + i + ").");
        }
        int x = this.mAdaptedAllocation.mType.getX();
        int y = this.mAdaptedAllocation.mType.getY();
        int z = this.mAdaptedAllocation.mType.getZ();
        int i2 = 0;
        while (i2 < i) {
            if (x == 1 && y == 1 && z == 1) {
                throw new RSIllegalArgumentException("Attempting to set lod (" + i + ") out of range.");
            }
            int i3 = x;
            if (x > 1) {
                i3 = x >> 1;
            }
            int i4 = y;
            if (y > 1) {
                i4 = y >> 1;
            }
            int i5 = z;
            if (z > 1) {
                i5 = z >> 1;
            }
            i2++;
            x = i3;
            y = i4;
            z = i5;
        }
        this.mCurrentDimX = x;
        this.mCurrentDimY = y;
        this.mCurrentDimZ = z;
        this.mCurrentCount = this.mCurrentDimX;
        if (this.mCurrentDimY > 1) {
            this.mCurrentCount *= this.mCurrentDimY;
        }
        if (this.mCurrentDimZ > 1) {
            this.mCurrentCount *= this.mCurrentDimZ;
        }
        this.mSelectedY = 0;
        this.mSelectedZ = 0;
    }

    public void readData(float[] fArr) {
        super.copyTo(fArr);
    }

    public void readData(int[] iArr) {
        super.copyTo(iArr);
    }

    @Override // android.renderscript.Allocation
    public void resize(int i) {
        synchronized (this) {
            throw new RSInvalidStateException("Resize not allowed for Adapters.");
        }
    }

    public void setFace(Type.CubemapFace cubemapFace) {
        if (!this.mAdaptedAllocation.getType().hasFaces()) {
            throw new RSInvalidStateException("Cannot set Face when the allocation type does not include faces.");
        }
        if (!this.mConstrainedFace) {
            throw new RSInvalidStateException("Cannot set LOD when the adapter includes mipmaps.");
        }
        if (cubemapFace == null) {
            throw new RSIllegalArgumentException("Cannot set null face.");
        }
        this.mSelectedFace = cubemapFace;
    }

    public void setLOD(int i) {
        if (!this.mAdaptedAllocation.getType().hasMipmaps()) {
            throw new RSInvalidStateException("Cannot set LOD when the allocation type does not include mipmaps.");
        }
        if (!this.mConstrainedLOD) {
            throw new RSInvalidStateException("Cannot set LOD when the adapter includes mipmaps.");
        }
        initLOD(i);
    }

    public void setY(int i) {
        if (this.mAdaptedAllocation.getType().getY() == 0) {
            throw new RSInvalidStateException("Cannot set Y when the allocation type does not include Y dim.");
        }
        if (this.mAdaptedAllocation.getType().getY() <= i) {
            throw new RSInvalidStateException("Cannot set Y greater than dimension of allocation.");
        }
        if (!this.mConstrainedY) {
            throw new RSInvalidStateException("Cannot set Y when the adapter includes Y.");
        }
        this.mSelectedY = i;
    }

    public void setZ(int i) {
        if (this.mAdaptedAllocation.getType().getZ() == 0) {
            throw new RSInvalidStateException("Cannot set Z when the allocation type does not include Z dim.");
        }
        if (this.mAdaptedAllocation.getType().getZ() <= i) {
            throw new RSInvalidStateException("Cannot set Z greater than dimension of allocation.");
        }
        if (!this.mConstrainedZ) {
            throw new RSInvalidStateException("Cannot set Z when the adapter includes Z.");
        }
        this.mSelectedZ = i;
    }

    public void subData(int i, FieldPacker fieldPacker) {
        super.setFromFieldPacker(i, fieldPacker);
    }

    public void subData1D(int i, int i2, byte[] bArr) {
        super.copy1DRangeFrom(i, i2, bArr);
    }

    public void subData1D(int i, int i2, float[] fArr) {
        super.copy1DRangeFrom(i, i2, fArr);
    }

    public void subData1D(int i, int i2, int[] iArr) {
        super.copy1DRangeFrom(i, i2, iArr);
    }

    public void subData1D(int i, int i2, short[] sArr) {
        super.copy1DRangeFrom(i, i2, sArr);
    }

    public void subData2D(int i, int i2, int i3, int i4, float[] fArr) {
        super.copy2DRangeFrom(i, i2, i3, i4, fArr);
    }

    public void subData2D(int i, int i2, int i3, int i4, int[] iArr) {
        super.copy2DRangeFrom(i, i2, i3, i4, iArr);
    }

    public void subElementData(int i, int i2, FieldPacker fieldPacker) {
        super.setFromFieldPacker(i, i2, fieldPacker);
    }
}
