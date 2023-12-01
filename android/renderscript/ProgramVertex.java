package android.renderscript;

import android.renderscript.Program;

/* loaded from: source-9557208-dex2jar.jar:android/renderscript/ProgramVertex.class */
public class ProgramVertex extends Program {

    /* loaded from: source-9557208-dex2jar.jar:android/renderscript/ProgramVertex$Builder.class */
    public static class Builder extends Program.BaseProgramBuilder {
        public Builder(RenderScript renderScript) {
            super(renderScript);
        }

        public Builder addInput(Element element) throws IllegalStateException {
            if (this.mInputCount >= 8) {
                throw new RSIllegalArgumentException("Max input count exceeded.");
            }
            if (element.isComplex()) {
                throw new RSIllegalArgumentException("Complex elements not allowed.");
            }
            Element[] elementArr = this.mInputs;
            int i = this.mInputCount;
            this.mInputCount = i + 1;
            elementArr[i] = element;
            return this;
        }

        public ProgramVertex create() {
            this.mRS.validate();
            long[] jArr = new long[(this.mInputCount + this.mOutputCount + this.mConstantCount + this.mTextureCount) * 2];
            String[] strArr = new String[this.mTextureCount];
            int i = 0;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= this.mInputCount) {
                    break;
                }
                int i4 = i + 1;
                jArr[i] = Program.ProgramParam.INPUT.mID;
                i = i4 + 1;
                jArr[i4] = this.mInputs[i3].getID(this.mRS);
                i2 = i3 + 1;
            }
            int i5 = 0;
            while (true) {
                int i6 = i5;
                if (i6 >= this.mOutputCount) {
                    break;
                }
                int i7 = i + 1;
                jArr[i] = Program.ProgramParam.OUTPUT.mID;
                i = i7 + 1;
                jArr[i7] = this.mOutputs[i6].getID(this.mRS);
                i5 = i6 + 1;
            }
            int i8 = 0;
            while (true) {
                int i9 = i8;
                if (i9 >= this.mConstantCount) {
                    break;
                }
                int i10 = i + 1;
                jArr[i] = Program.ProgramParam.CONSTANT.mID;
                i = i10 + 1;
                jArr[i10] = this.mConstants[i9].getID(this.mRS);
                i8 = i9 + 1;
            }
            int i11 = i;
            int i12 = 0;
            while (true) {
                int i13 = i12;
                if (i13 >= this.mTextureCount) {
                    ProgramVertex programVertex = new ProgramVertex(this.mRS.nProgramVertexCreate(this.mShader, strArr, jArr), this.mRS);
                    initProgram(programVertex);
                    return programVertex;
                }
                int i14 = i11 + 1;
                jArr[i11] = Program.ProgramParam.TEXTURE_TYPE.mID;
                i11 = i14 + 1;
                jArr[i14] = this.mTextureTypes[i13].mID;
                strArr[i13] = this.mTextureNames[i13];
                i12 = i13 + 1;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ProgramVertex(long j, RenderScript renderScript) {
        super(j, renderScript);
    }

    public Element getInput(int i) {
        if (i < 0 || i >= this.mInputs.length) {
            throw new IllegalArgumentException("Slot ID out of range.");
        }
        return this.mInputs[i];
    }

    public int getInputCount() {
        if (this.mInputs != null) {
            return this.mInputs.length;
        }
        return 0;
    }
}
