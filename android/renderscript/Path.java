package android.renderscript;

/* loaded from: source-9557208-dex2jar.jar:android/renderscript/Path.class */
public class Path extends BaseObj {
    boolean mCoverageToAlpha;
    Allocation mLoopBuffer;
    Primitive mPrimitive;
    float mQuality;
    Allocation mVertexBuffer;

    /* loaded from: source-9557208-dex2jar.jar:android/renderscript/Path$Primitive.class */
    public enum Primitive {
        QUADRATIC_BEZIER(0),
        CUBIC_BEZIER(1);
        
        int mID;

        Primitive(int i) {
            this.mID = i;
        }
    }

    Path(long j, RenderScript renderScript, Primitive primitive, Allocation allocation, Allocation allocation2, float f) {
        super(j, renderScript);
        this.mVertexBuffer = allocation;
        this.mLoopBuffer = allocation2;
        this.mPrimitive = primitive;
        this.mQuality = f;
    }

    public static Path createDynamicPath(RenderScript renderScript, Primitive primitive, float f, Allocation allocation) {
        return null;
    }

    public static Path createDynamicPath(RenderScript renderScript, Primitive primitive, float f, Allocation allocation, Allocation allocation2) {
        return null;
    }

    public static Path createStaticPath(RenderScript renderScript, Primitive primitive, float f, Allocation allocation) {
        return new Path(renderScript.nPathCreate(primitive.mID, false, allocation.getID(renderScript), 0L, f), renderScript, primitive, null, null, f);
    }

    public static Path createStaticPath(RenderScript renderScript, Primitive primitive, float f, Allocation allocation, Allocation allocation2) {
        return null;
    }

    public Allocation getLoopAllocation() {
        return this.mLoopBuffer;
    }

    public Primitive getPrimitive() {
        return this.mPrimitive;
    }

    public Allocation getVertexAllocation() {
        return this.mVertexBuffer;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // android.renderscript.BaseObj
    public void updateFromNative() {
    }
}
