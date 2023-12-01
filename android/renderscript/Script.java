package android.renderscript;

import android.util.SparseArray;
import java.io.UnsupportedEncodingException;

/* loaded from: source-9557208-dex2jar.jar:android/renderscript/Script.class */
public class Script extends BaseObj {
    private final SparseArray<FieldID> mFIDs;
    private final SparseArray<KernelID> mKIDs;

    /* loaded from: source-9557208-dex2jar.jar:android/renderscript/Script$Builder.class */
    public static class Builder {
        RenderScript mRS;

        Builder(RenderScript renderScript) {
            this.mRS = renderScript;
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/renderscript/Script$FieldBase.class */
    public static class FieldBase {
        protected Allocation mAllocation;
        protected Element mElement;

        protected FieldBase() {
        }

        public Allocation getAllocation() {
            return this.mAllocation;
        }

        public Element getElement() {
            return this.mElement;
        }

        public Type getType() {
            return this.mAllocation.getType();
        }

        protected void init(RenderScript renderScript, int i) {
            this.mAllocation = Allocation.createSized(renderScript, this.mElement, i, 1);
        }

        protected void init(RenderScript renderScript, int i, int i2) {
            this.mAllocation = Allocation.createSized(renderScript, this.mElement, i, i2 | 1);
        }

        public void updateAllocation() {
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/renderscript/Script$FieldID.class */
    public static final class FieldID extends BaseObj {
        Script mScript;
        int mSlot;

        FieldID(long j, RenderScript renderScript, Script script, int i) {
            super(j, renderScript);
            this.mScript = script;
            this.mSlot = i;
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/renderscript/Script$KernelID.class */
    public static final class KernelID extends BaseObj {
        Script mScript;
        int mSig;
        int mSlot;

        KernelID(long j, RenderScript renderScript, Script script, int i, int i2) {
            super(j, renderScript);
            this.mScript = script;
            this.mSlot = i;
            this.mSig = i2;
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/renderscript/Script$LaunchOptions.class */
    public static final class LaunchOptions {
        private int strategy;
        private int xstart = 0;
        private int ystart = 0;
        private int xend = 0;
        private int yend = 0;
        private int zstart = 0;
        private int zend = 0;

        public int getXEnd() {
            return this.xend;
        }

        public int getXStart() {
            return this.xstart;
        }

        public int getYEnd() {
            return this.yend;
        }

        public int getYStart() {
            return this.ystart;
        }

        public int getZEnd() {
            return this.zend;
        }

        public int getZStart() {
            return this.zstart;
        }

        public LaunchOptions setX(int i, int i2) {
            if (i < 0 || i2 <= i) {
                throw new RSIllegalArgumentException("Invalid dimensions");
            }
            this.xstart = i;
            this.xend = i2;
            return this;
        }

        public LaunchOptions setY(int i, int i2) {
            if (i < 0 || i2 <= i) {
                throw new RSIllegalArgumentException("Invalid dimensions");
            }
            this.ystart = i;
            this.yend = i2;
            return this;
        }

        public LaunchOptions setZ(int i, int i2) {
            if (i < 0 || i2 <= i) {
                throw new RSIllegalArgumentException("Invalid dimensions");
            }
            this.zstart = i;
            this.zend = i2;
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Script(long j, RenderScript renderScript) {
        super(j, renderScript);
        this.mKIDs = new SparseArray<>();
        this.mFIDs = new SparseArray<>();
    }

    public void bindAllocation(Allocation allocation, int i) {
        this.mRS.validate();
        this.mRS.validateObject(allocation);
        if (allocation == null) {
            this.mRS.nScriptBindAllocation(getID(this.mRS), 0L, i);
            return;
        }
        if (this.mRS.getApplicationContext().getApplicationInfo().targetSdkVersion >= 20) {
            Type type = allocation.mType;
            if (type.hasMipmaps() || type.hasFaces() || type.getY() != 0 || type.getZ() != 0) {
                throw new RSIllegalArgumentException("API 20+ only allows simple 1D allocations to be used with bind.");
            }
        }
        this.mRS.nScriptBindAllocation(getID(this.mRS), allocation.getID(this.mRS), i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public FieldID createFieldID(int i, Element element) {
        FieldID fieldID = this.mFIDs.get(i);
        if (fieldID != null) {
            return fieldID;
        }
        long nScriptFieldIDCreate = this.mRS.nScriptFieldIDCreate(getID(this.mRS), i);
        if (nScriptFieldIDCreate == 0) {
            throw new RSDriverException("Failed to create FieldID");
        }
        FieldID fieldID2 = new FieldID(nScriptFieldIDCreate, this.mRS, this, i);
        this.mFIDs.put(i, fieldID2);
        return fieldID2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public KernelID createKernelID(int i, int i2, Element element, Element element2) {
        KernelID kernelID = this.mKIDs.get(i);
        if (kernelID != null) {
            return kernelID;
        }
        long nScriptKernelIDCreate = this.mRS.nScriptKernelIDCreate(getID(this.mRS), i, i2);
        if (nScriptKernelIDCreate == 0) {
            throw new RSDriverException("Failed to create KernelID");
        }
        KernelID kernelID2 = new KernelID(nScriptKernelIDCreate, this.mRS, this, i, i2);
        this.mKIDs.put(i, kernelID2);
        return kernelID2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void forEach(int i, Allocation allocation, Allocation allocation2, FieldPacker fieldPacker) {
        this.mRS.validate();
        this.mRS.validateObject(allocation);
        this.mRS.validateObject(allocation2);
        if (allocation == null && allocation2 == null) {
            throw new RSIllegalArgumentException("At least one of ain or aout is required to be non-null.");
        }
        long j = 0;
        if (allocation != null) {
            j = allocation.getID(this.mRS);
        }
        long j2 = 0;
        if (allocation2 != null) {
            j2 = allocation2.getID(this.mRS);
        }
        byte[] bArr = null;
        if (fieldPacker != null) {
            bArr = fieldPacker.getData();
        }
        this.mRS.nScriptForEach(getID(this.mRS), i, j, j2, bArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void forEach(int i, Allocation allocation, Allocation allocation2, FieldPacker fieldPacker, LaunchOptions launchOptions) {
        this.mRS.validate();
        this.mRS.validateObject(allocation);
        this.mRS.validateObject(allocation2);
        if (allocation == null && allocation2 == null) {
            throw new RSIllegalArgumentException("At least one of ain or aout is required to be non-null.");
        }
        if (launchOptions == null) {
            forEach(i, allocation, allocation2, fieldPacker);
            return;
        }
        long j = 0;
        if (allocation != null) {
            j = allocation.getID(this.mRS);
        }
        long j2 = 0;
        if (allocation2 != null) {
            j2 = allocation2.getID(this.mRS);
        }
        byte[] bArr = null;
        if (fieldPacker != null) {
            bArr = fieldPacker.getData();
        }
        this.mRS.nScriptForEachClipped(getID(this.mRS), i, j, j2, bArr, launchOptions.xstart, launchOptions.xend, launchOptions.ystart, launchOptions.yend, launchOptions.zstart, launchOptions.zend);
    }

    protected void forEach(int i, Allocation[] allocationArr, Allocation allocation, FieldPacker fieldPacker) {
        forEach(i, allocationArr, allocation, fieldPacker, new LaunchOptions());
    }

    protected void forEach(int i, Allocation[] allocationArr, Allocation allocation, FieldPacker fieldPacker, LaunchOptions launchOptions) {
        this.mRS.validate();
        int length = allocationArr.length;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= length) {
                break;
            }
            this.mRS.validateObject(allocationArr[i3]);
            i2 = i3 + 1;
        }
        this.mRS.validateObject(allocation);
        if (allocationArr == null && allocation == null) {
            throw new RSIllegalArgumentException("At least one of ain or aout is required to be non-null.");
        }
        if (launchOptions == null) {
            forEach(i, allocationArr, allocation, fieldPacker);
            return;
        }
        long[] jArr = new long[allocationArr.length];
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i5 >= allocationArr.length) {
                break;
            }
            jArr[i5] = allocationArr[i5].getID(this.mRS);
            i4 = i5 + 1;
        }
        long j = 0;
        if (allocation != null) {
            j = allocation.getID(this.mRS);
        }
        byte[] bArr = null;
        if (fieldPacker != null) {
            bArr = fieldPacker.getData();
        }
        this.mRS.nScriptForEachMultiClipped(getID(this.mRS), i, jArr, j, bArr, launchOptions.xstart, launchOptions.xend, launchOptions.ystart, launchOptions.yend, launchOptions.zstart, launchOptions.zend);
    }

    public boolean getVarB(int i) {
        return this.mRS.nScriptGetVarI(getID(this.mRS), i) > 0;
    }

    public double getVarD(int i) {
        return this.mRS.nScriptGetVarD(getID(this.mRS), i);
    }

    public float getVarF(int i) {
        return this.mRS.nScriptGetVarF(getID(this.mRS), i);
    }

    public int getVarI(int i) {
        return this.mRS.nScriptGetVarI(getID(this.mRS), i);
    }

    public long getVarJ(int i) {
        return this.mRS.nScriptGetVarJ(getID(this.mRS), i);
    }

    public void getVarV(int i, FieldPacker fieldPacker) {
        this.mRS.nScriptGetVarV(getID(this.mRS), i, fieldPacker.getData());
    }

    protected void invoke(int i) {
        this.mRS.nScriptInvoke(getID(this.mRS), i);
    }

    protected void invoke(int i, FieldPacker fieldPacker) {
        if (fieldPacker != null) {
            this.mRS.nScriptInvokeV(getID(this.mRS), i, fieldPacker.getData());
        } else {
            this.mRS.nScriptInvoke(getID(this.mRS), i);
        }
    }

    public void setTimeZone(String str) {
        this.mRS.validate();
        try {
            this.mRS.nScriptSetTimeZone(getID(this.mRS), str.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public void setVar(int i, double d) {
        this.mRS.nScriptSetVarD(getID(this.mRS), i, d);
    }

    public void setVar(int i, float f) {
        this.mRS.nScriptSetVarF(getID(this.mRS), i, f);
    }

    public void setVar(int i, int i2) {
        this.mRS.nScriptSetVarI(getID(this.mRS), i, i2);
    }

    public void setVar(int i, long j) {
        this.mRS.nScriptSetVarJ(getID(this.mRS), i, j);
    }

    public void setVar(int i, BaseObj baseObj) {
        this.mRS.validate();
        this.mRS.validateObject(baseObj);
        this.mRS.nScriptSetVarObj(getID(this.mRS), i, baseObj == null ? 0L : baseObj.getID(this.mRS));
    }

    public void setVar(int i, FieldPacker fieldPacker) {
        this.mRS.nScriptSetVarV(getID(this.mRS), i, fieldPacker.getData());
    }

    public void setVar(int i, FieldPacker fieldPacker, Element element, int[] iArr) {
        this.mRS.nScriptSetVarVE(getID(this.mRS), i, fieldPacker.getData(), element.getID(this.mRS), iArr);
    }

    public void setVar(int i, boolean z) {
        this.mRS.nScriptSetVarI(getID(this.mRS), i, z ? 1 : 0);
    }
}
