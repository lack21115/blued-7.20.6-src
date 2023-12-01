package android.renderscript;

import android.renderscript.Script;

/* loaded from: source-9557208-dex2jar.jar:android/renderscript/ScriptIntrinsicYuvToRGB.class */
public final class ScriptIntrinsicYuvToRGB extends ScriptIntrinsic {
    private Allocation mInput;

    ScriptIntrinsicYuvToRGB(long j, RenderScript renderScript) {
        super(j, renderScript);
    }

    public static ScriptIntrinsicYuvToRGB create(RenderScript renderScript, Element element) {
        return new ScriptIntrinsicYuvToRGB(renderScript.nScriptIntrinsicCreate(6, element.getID(renderScript)), renderScript);
    }

    public void forEach(Allocation allocation) {
        forEach(0, (Allocation) null, allocation, (FieldPacker) null);
    }

    public Script.FieldID getFieldID_Input() {
        return createFieldID(0, null);
    }

    public Script.KernelID getKernelID() {
        return createKernelID(0, 2, null, null);
    }

    public void setInput(Allocation allocation) {
        this.mInput = allocation;
        setVar(0, allocation);
    }
}
