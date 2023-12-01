package android.renderscript;

import android.provider.BrowserContract;
import android.renderscript.Element;
import android.renderscript.Type;
import java.util.Vector;

/* loaded from: source-9557208-dex2jar.jar:android/renderscript/Mesh.class */
public class Mesh extends BaseObj {
    Allocation[] mIndexBuffers;
    Primitive[] mPrimitives;
    Allocation[] mVertexBuffers;

    /* loaded from: source-9557208-dex2jar.jar:android/renderscript/Mesh$AllocationBuilder.class */
    public static class AllocationBuilder {
        RenderScript mRS;
        int mVertexTypeCount = 0;
        Entry[] mVertexTypes = new Entry[16];
        Vector mIndexTypes = new Vector();

        /* loaded from: source-9557208-dex2jar.jar:android/renderscript/Mesh$AllocationBuilder$Entry.class */
        class Entry {

            /* renamed from: a  reason: collision with root package name */
            Allocation f1428a;
            Primitive prim;

            Entry() {
            }
        }

        public AllocationBuilder(RenderScript renderScript) {
            this.mRS = renderScript;
        }

        public AllocationBuilder addIndexSetAllocation(Allocation allocation, Primitive primitive) {
            Entry entry = new Entry();
            entry.f1428a = allocation;
            entry.prim = primitive;
            this.mIndexTypes.addElement(entry);
            return this;
        }

        public AllocationBuilder addIndexSetType(Primitive primitive) {
            Entry entry = new Entry();
            entry.f1428a = null;
            entry.prim = primitive;
            this.mIndexTypes.addElement(entry);
            return this;
        }

        public AllocationBuilder addVertexAllocation(Allocation allocation) throws IllegalStateException {
            if (this.mVertexTypeCount >= this.mVertexTypes.length) {
                throw new IllegalStateException("Max vertex types exceeded.");
            }
            this.mVertexTypes[this.mVertexTypeCount] = new Entry();
            this.mVertexTypes[this.mVertexTypeCount].f1428a = allocation;
            this.mVertexTypeCount++;
            return this;
        }

        public Mesh create() {
            this.mRS.validate();
            long[] jArr = new long[this.mVertexTypeCount];
            long[] jArr2 = new long[this.mIndexTypes.size()];
            int[] iArr = new int[this.mIndexTypes.size()];
            Allocation[] allocationArr = new Allocation[this.mIndexTypes.size()];
            Primitive[] primitiveArr = new Primitive[this.mIndexTypes.size()];
            Allocation[] allocationArr2 = new Allocation[this.mVertexTypeCount];
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.mVertexTypeCount) {
                    break;
                }
                Entry entry = this.mVertexTypes[i2];
                allocationArr2[i2] = entry.f1428a;
                jArr[i2] = entry.f1428a.getID(this.mRS);
                i = i2 + 1;
            }
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= this.mIndexTypes.size()) {
                    Mesh mesh = new Mesh(this.mRS.nMeshCreate(jArr, jArr2, iArr), this.mRS);
                    mesh.mVertexBuffers = allocationArr2;
                    mesh.mIndexBuffers = allocationArr;
                    mesh.mPrimitives = primitiveArr;
                    return mesh;
                }
                Entry entry2 = (Entry) this.mIndexTypes.elementAt(i4);
                long id = entry2.f1428a == null ? 0L : entry2.f1428a.getID(this.mRS);
                allocationArr[i4] = entry2.f1428a;
                primitiveArr[i4] = entry2.prim;
                jArr2[i4] = id;
                iArr[i4] = entry2.prim.mID;
                i3 = i4 + 1;
            }
        }

        public int getCurrentIndexSetIndex() {
            return this.mIndexTypes.size() - 1;
        }

        public int getCurrentVertexTypeIndex() {
            return this.mVertexTypeCount - 1;
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/renderscript/Mesh$Builder.class */
    public static class Builder {
        RenderScript mRS;
        int mUsage;
        int mVertexTypeCount = 0;
        Entry[] mVertexTypes = new Entry[16];
        Vector mIndexTypes = new Vector();

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: source-9557208-dex2jar.jar:android/renderscript/Mesh$Builder$Entry.class */
        public class Entry {
            Element e;
            Primitive prim;
            int size;
            Type t;
            int usage;

            Entry() {
            }
        }

        public Builder(RenderScript renderScript, int i) {
            this.mRS = renderScript;
            this.mUsage = i;
        }

        public Builder addIndexSetType(Element element, int i, Primitive primitive) {
            Entry entry = new Entry();
            entry.t = null;
            entry.e = element;
            entry.size = i;
            entry.prim = primitive;
            this.mIndexTypes.addElement(entry);
            return this;
        }

        public Builder addIndexSetType(Primitive primitive) {
            Entry entry = new Entry();
            entry.t = null;
            entry.e = null;
            entry.size = 0;
            entry.prim = primitive;
            this.mIndexTypes.addElement(entry);
            return this;
        }

        public Builder addIndexSetType(Type type, Primitive primitive) {
            Entry entry = new Entry();
            entry.t = type;
            entry.e = null;
            entry.size = 0;
            entry.prim = primitive;
            this.mIndexTypes.addElement(entry);
            return this;
        }

        public Builder addVertexType(Element element, int i) throws IllegalStateException {
            if (this.mVertexTypeCount >= this.mVertexTypes.length) {
                throw new IllegalStateException("Max vertex types exceeded.");
            }
            this.mVertexTypes[this.mVertexTypeCount] = new Entry();
            this.mVertexTypes[this.mVertexTypeCount].t = null;
            this.mVertexTypes[this.mVertexTypeCount].e = element;
            this.mVertexTypes[this.mVertexTypeCount].size = i;
            this.mVertexTypeCount++;
            return this;
        }

        public Builder addVertexType(Type type) throws IllegalStateException {
            if (this.mVertexTypeCount >= this.mVertexTypes.length) {
                throw new IllegalStateException("Max vertex types exceeded.");
            }
            this.mVertexTypes[this.mVertexTypeCount] = new Entry();
            this.mVertexTypes[this.mVertexTypeCount].t = type;
            this.mVertexTypes[this.mVertexTypeCount].e = null;
            this.mVertexTypeCount++;
            return this;
        }

        public Mesh create() {
            this.mRS.validate();
            long[] jArr = new long[this.mVertexTypeCount];
            long[] jArr2 = new long[this.mIndexTypes.size()];
            int[] iArr = new int[this.mIndexTypes.size()];
            Allocation[] allocationArr = new Allocation[this.mVertexTypeCount];
            Allocation[] allocationArr2 = new Allocation[this.mIndexTypes.size()];
            Primitive[] primitiveArr = new Primitive[this.mIndexTypes.size()];
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.mVertexTypeCount) {
                    break;
                }
                Allocation allocation = null;
                Entry entry = this.mVertexTypes[i2];
                if (entry.t != null) {
                    allocation = Allocation.createTyped(this.mRS, entry.t, this.mUsage);
                } else if (entry.e != null) {
                    allocation = Allocation.createSized(this.mRS, entry.e, entry.size, this.mUsage);
                }
                allocationArr[i2] = allocation;
                jArr[i2] = allocation.getID(this.mRS);
                i = i2 + 1;
            }
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= this.mIndexTypes.size()) {
                    Mesh mesh = new Mesh(this.mRS.nMeshCreate(jArr, jArr2, iArr), this.mRS);
                    mesh.mVertexBuffers = allocationArr;
                    mesh.mIndexBuffers = allocationArr2;
                    mesh.mPrimitives = primitiveArr;
                    return mesh;
                }
                Allocation allocation2 = null;
                Entry entry2 = (Entry) this.mIndexTypes.elementAt(i4);
                if (entry2.t != null) {
                    allocation2 = Allocation.createTyped(this.mRS, entry2.t, this.mUsage);
                } else if (entry2.e != null) {
                    allocation2 = Allocation.createSized(this.mRS, entry2.e, entry2.size, this.mUsage);
                }
                long id = allocation2 == null ? 0L : allocation2.getID(this.mRS);
                allocationArr2[i4] = allocation2;
                primitiveArr[i4] = entry2.prim;
                jArr2[i4] = id;
                iArr[i4] = entry2.prim.mID;
                i3 = i4 + 1;
            }
        }

        public int getCurrentIndexSetIndex() {
            return this.mIndexTypes.size() - 1;
        }

        public int getCurrentVertexTypeIndex() {
            return this.mVertexTypeCount - 1;
        }

        Type newType(Element element, int i) {
            Type.Builder builder = new Type.Builder(this.mRS, element);
            builder.setX(i);
            return builder.create();
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/renderscript/Mesh$Primitive.class */
    public enum Primitive {
        POINT(0),
        LINE(1),
        LINE_STRIP(2),
        TRIANGLE(3),
        TRIANGLE_STRIP(4),
        TRIANGLE_FAN(5);
        
        int mID;

        Primitive(int i) {
            this.mID = i;
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/renderscript/Mesh$TriangleMeshBuilder.class */
    public static class TriangleMeshBuilder {
        public static final int COLOR = 1;
        public static final int NORMAL = 2;
        public static final int TEXTURE_0 = 256;
        Element mElement;
        int mFlags;
        RenderScript mRS;
        int mVtxSize;
        float mNX = 0.0f;
        float mNY = 0.0f;
        float mNZ = -1.0f;
        float mS0 = 0.0f;
        float mT0 = 0.0f;
        float mR = 1.0f;
        float mG = 1.0f;
        float mB = 1.0f;
        float mA = 1.0f;
        int mVtxCount = 0;
        int mMaxIndex = 0;
        int mIndexCount = 0;
        float[] mVtxData = new float[128];
        short[] mIndexData = new short[128];

        public TriangleMeshBuilder(RenderScript renderScript, int i, int i2) {
            this.mRS = renderScript;
            this.mVtxSize = i;
            this.mFlags = i2;
            if (i < 2 || i > 3) {
                throw new IllegalArgumentException("Vertex size out of range.");
            }
        }

        private void latch() {
            if ((this.mFlags & 1) != 0) {
                makeSpace(4);
                float[] fArr = this.mVtxData;
                int i = this.mVtxCount;
                this.mVtxCount = i + 1;
                fArr[i] = this.mR;
                float[] fArr2 = this.mVtxData;
                int i2 = this.mVtxCount;
                this.mVtxCount = i2 + 1;
                fArr2[i2] = this.mG;
                float[] fArr3 = this.mVtxData;
                int i3 = this.mVtxCount;
                this.mVtxCount = i3 + 1;
                fArr3[i3] = this.mB;
                float[] fArr4 = this.mVtxData;
                int i4 = this.mVtxCount;
                this.mVtxCount = i4 + 1;
                fArr4[i4] = this.mA;
            }
            if ((this.mFlags & 256) != 0) {
                makeSpace(2);
                float[] fArr5 = this.mVtxData;
                int i5 = this.mVtxCount;
                this.mVtxCount = i5 + 1;
                fArr5[i5] = this.mS0;
                float[] fArr6 = this.mVtxData;
                int i6 = this.mVtxCount;
                this.mVtxCount = i6 + 1;
                fArr6[i6] = this.mT0;
            }
            if ((this.mFlags & 2) != 0) {
                makeSpace(4);
                float[] fArr7 = this.mVtxData;
                int i7 = this.mVtxCount;
                this.mVtxCount = i7 + 1;
                fArr7[i7] = this.mNX;
                float[] fArr8 = this.mVtxData;
                int i8 = this.mVtxCount;
                this.mVtxCount = i8 + 1;
                fArr8[i8] = this.mNY;
                float[] fArr9 = this.mVtxData;
                int i9 = this.mVtxCount;
                this.mVtxCount = i9 + 1;
                fArr9[i9] = this.mNZ;
                float[] fArr10 = this.mVtxData;
                int i10 = this.mVtxCount;
                this.mVtxCount = i10 + 1;
                fArr10[i10] = 0.0f;
            }
            this.mMaxIndex++;
        }

        private void makeSpace(int i) {
            if (this.mVtxCount + i >= this.mVtxData.length) {
                float[] fArr = new float[this.mVtxData.length * 2];
                System.arraycopy(this.mVtxData, 0, fArr, 0, this.mVtxData.length);
                this.mVtxData = fArr;
            }
        }

        public TriangleMeshBuilder addTriangle(int i, int i2, int i3) {
            if (i >= this.mMaxIndex || i < 0 || i2 >= this.mMaxIndex || i2 < 0 || i3 >= this.mMaxIndex || i3 < 0) {
                throw new IllegalStateException("Index provided greater than vertex count.");
            }
            if (this.mIndexCount + 3 >= this.mIndexData.length) {
                short[] sArr = new short[this.mIndexData.length * 2];
                System.arraycopy(this.mIndexData, 0, sArr, 0, this.mIndexData.length);
                this.mIndexData = sArr;
            }
            short[] sArr2 = this.mIndexData;
            int i4 = this.mIndexCount;
            this.mIndexCount = i4 + 1;
            sArr2[i4] = (short) i;
            short[] sArr3 = this.mIndexData;
            int i5 = this.mIndexCount;
            this.mIndexCount = i5 + 1;
            sArr3[i5] = (short) i2;
            short[] sArr4 = this.mIndexData;
            int i6 = this.mIndexCount;
            this.mIndexCount = i6 + 1;
            sArr4[i6] = (short) i3;
            return this;
        }

        public TriangleMeshBuilder addVertex(float f, float f2) {
            if (this.mVtxSize != 2) {
                throw new IllegalStateException("add mistmatch with declared components.");
            }
            makeSpace(2);
            float[] fArr = this.mVtxData;
            int i = this.mVtxCount;
            this.mVtxCount = i + 1;
            fArr[i] = f;
            float[] fArr2 = this.mVtxData;
            int i2 = this.mVtxCount;
            this.mVtxCount = i2 + 1;
            fArr2[i2] = f2;
            latch();
            return this;
        }

        public TriangleMeshBuilder addVertex(float f, float f2, float f3) {
            if (this.mVtxSize != 3) {
                throw new IllegalStateException("add mistmatch with declared components.");
            }
            makeSpace(4);
            float[] fArr = this.mVtxData;
            int i = this.mVtxCount;
            this.mVtxCount = i + 1;
            fArr[i] = f;
            float[] fArr2 = this.mVtxData;
            int i2 = this.mVtxCount;
            this.mVtxCount = i2 + 1;
            fArr2[i2] = f2;
            float[] fArr3 = this.mVtxData;
            int i3 = this.mVtxCount;
            this.mVtxCount = i3 + 1;
            fArr3[i3] = f3;
            float[] fArr4 = this.mVtxData;
            int i4 = this.mVtxCount;
            this.mVtxCount = i4 + 1;
            fArr4[i4] = 1.0f;
            latch();
            return this;
        }

        public Mesh create(boolean z) {
            Element.Builder builder = new Element.Builder(this.mRS);
            builder.add(Element.createVector(this.mRS, Element.DataType.FLOAT_32, this.mVtxSize), BrowserContract.Bookmarks.POSITION);
            if ((this.mFlags & 1) != 0) {
                builder.add(Element.F32_4(this.mRS), "color");
            }
            if ((this.mFlags & 256) != 0) {
                builder.add(Element.F32_2(this.mRS), "texture0");
            }
            if ((this.mFlags & 2) != 0) {
                builder.add(Element.F32_3(this.mRS), "normal");
            }
            this.mElement = builder.create();
            int i = 1;
            if (z) {
                i = 1 | 4;
            }
            Builder builder2 = new Builder(this.mRS, i);
            builder2.addVertexType(this.mElement, this.mMaxIndex);
            builder2.addIndexSetType(Element.U16(this.mRS), this.mIndexCount, Primitive.TRIANGLE);
            Mesh create = builder2.create();
            create.getVertexAllocation(0).copy1DRangeFromUnchecked(0, this.mMaxIndex, this.mVtxData);
            if (z && z) {
                create.getVertexAllocation(0).syncAll(1);
            }
            create.getIndexSetAllocation(0).copy1DRangeFromUnchecked(0, this.mIndexCount, this.mIndexData);
            if (z) {
                create.getIndexSetAllocation(0).syncAll(1);
            }
            return create;
        }

        public TriangleMeshBuilder setColor(float f, float f2, float f3, float f4) {
            if ((this.mFlags & 1) == 0) {
                throw new IllegalStateException("add mistmatch with declared components.");
            }
            this.mR = f;
            this.mG = f2;
            this.mB = f3;
            this.mA = f4;
            return this;
        }

        public TriangleMeshBuilder setNormal(float f, float f2, float f3) {
            if ((this.mFlags & 2) == 0) {
                throw new IllegalStateException("add mistmatch with declared components.");
            }
            this.mNX = f;
            this.mNY = f2;
            this.mNZ = f3;
            return this;
        }

        public TriangleMeshBuilder setTexture(float f, float f2) {
            if ((this.mFlags & 256) == 0) {
                throw new IllegalStateException("add mistmatch with declared components.");
            }
            this.mS0 = f;
            this.mT0 = f2;
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Mesh(long j, RenderScript renderScript) {
        super(j, renderScript);
    }

    public Allocation getIndexSetAllocation(int i) {
        return this.mIndexBuffers[i];
    }

    public Primitive getPrimitive(int i) {
        return this.mPrimitives[i];
    }

    public int getPrimitiveCount() {
        if (this.mIndexBuffers == null) {
            return 0;
        }
        return this.mIndexBuffers.length;
    }

    public Allocation getVertexAllocation(int i) {
        return this.mVertexBuffers[i];
    }

    public int getVertexAllocationCount() {
        if (this.mVertexBuffers == null) {
            return 0;
        }
        return this.mVertexBuffers.length;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // android.renderscript.BaseObj
    public void updateFromNative() {
        super.updateFromNative();
        int nMeshGetVertexBufferCount = this.mRS.nMeshGetVertexBufferCount(getID(this.mRS));
        int nMeshGetIndexCount = this.mRS.nMeshGetIndexCount(getID(this.mRS));
        long[] jArr = new long[nMeshGetVertexBufferCount];
        long[] jArr2 = new long[nMeshGetIndexCount];
        int[] iArr = new int[nMeshGetIndexCount];
        this.mRS.nMeshGetVertices(getID(this.mRS), jArr, nMeshGetVertexBufferCount);
        this.mRS.nMeshGetIndices(getID(this.mRS), jArr2, iArr, nMeshGetIndexCount);
        this.mVertexBuffers = new Allocation[nMeshGetVertexBufferCount];
        this.mIndexBuffers = new Allocation[nMeshGetIndexCount];
        this.mPrimitives = new Primitive[nMeshGetIndexCount];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= nMeshGetVertexBufferCount) {
                break;
            }
            if (jArr[i2] != 0) {
                this.mVertexBuffers[i2] = new Allocation(jArr[i2], this.mRS, null, 1);
                this.mVertexBuffers[i2].updateFromNative();
            }
            i = i2 + 1;
        }
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= nMeshGetIndexCount) {
                return;
            }
            if (jArr2[i4] != 0) {
                this.mIndexBuffers[i4] = new Allocation(jArr2[i4], this.mRS, null, 1);
                this.mIndexBuffers[i4].updateFromNative();
            }
            this.mPrimitives[i4] = Primitive.values()[iArr[i4]];
            i3 = i4 + 1;
        }
    }
}
