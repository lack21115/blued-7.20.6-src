package android.renderscript;

import android.renderscript.Script;

/* loaded from: source-9557208-dex2jar.jar:android/renderscript/ScriptIntrinsic3DLUT.class */
public final class ScriptIntrinsic3DLUT extends ScriptIntrinsic {
    private Element mElement;
    private Allocation mLUT;

    private ScriptIntrinsic3DLUT(long j, RenderScript renderScript, Element element) {
        super(j, renderScript);
        this.mElement = element;
    }

    public static ScriptIntrinsic3DLUT create(RenderScript renderScript, Element element) {
        long nScriptIntrinsicCreate = renderScript.nScriptIntrinsicCreate(8, element.getID(renderScript));
        if (element.isCompatible(Element.U8_4(renderScript))) {
            return new ScriptIntrinsic3DLUT(nScriptIntrinsicCreate, renderScript, element);
        }
        throw new RSIllegalArgumentException("Element must be compatible with uchar4.");
    }

    public void forEach(Allocation allocation, Allocation allocation2) {
        forEach(allocation, allocation2, null);
    }

    public void forEach(Allocation allocation, Allocation allocation2, Script.LaunchOptions launchOptions) {
        forEach(0, allocation, allocation2, (FieldPacker) null, launchOptions);
    }

    public Script.KernelID getKernelID() {
        return createKernelID(0, 3, null, null);
    }

    public void setLUT(Allocation allocation) {
        Type type = allocation.getType();
        if (type.getZ() == 0) {
            throw new RSIllegalArgumentException("LUT must be 3d.");
        }
        if (!type.getElement().isCompatible(this.mElement)) {
            throw new RSIllegalArgumentException("LUT element type must match.");
        }
        this.mLUT = allocation;
        setVar(0, this.mLUT);
    }
}
