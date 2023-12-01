package android.renderscript;

import android.provider.BrowserContract;
import android.renderscript.Element;
import android.renderscript.Program;
import android.renderscript.Type;

/* loaded from: source-9557208-dex2jar.jar:android/renderscript/ProgramVertexFixedFunction.class */
public class ProgramVertexFixedFunction extends ProgramVertex {

    /* loaded from: source-9557208-dex2jar.jar:android/renderscript/ProgramVertexFixedFunction$Builder.class */
    public static class Builder {
        RenderScript mRS;
        String mShader;
        boolean mTextureMatrixEnable;

        public Builder(RenderScript renderScript) {
            this.mRS = renderScript;
        }

        private void buildShaderString() {
            this.mShader = "//rs_shader_internal\n";
            this.mShader += "varying vec4 varColor;\n";
            this.mShader += "varying vec2 varTex0;\n";
            this.mShader += "void main() {\n";
            this.mShader += "  gl_Position = UNI_MVP * ATTRIB_position;\n";
            this.mShader += "  gl_PointSize = 1.0;\n";
            this.mShader += "  varColor = ATTRIB_color;\n";
            if (this.mTextureMatrixEnable) {
                this.mShader += "  varTex0 = (UNI_TexMatrix * vec4(ATTRIB_texture0, 0.0, 1.0)).xy;\n";
            } else {
                this.mShader += "  varTex0 = ATTRIB_texture0;\n";
            }
            this.mShader += "}\n";
        }

        static Type getConstantInputType(RenderScript renderScript) {
            Element.Builder builder = new Element.Builder(renderScript);
            builder.add(Element.MATRIX4X4(renderScript), "MV");
            builder.add(Element.MATRIX4X4(renderScript), "P");
            builder.add(Element.MATRIX4X4(renderScript), "TexMatrix");
            builder.add(Element.MATRIX4X4(renderScript), "MVP");
            Type.Builder builder2 = new Type.Builder(renderScript, builder.create());
            builder2.setX(1);
            return builder2.create();
        }

        public ProgramVertexFixedFunction create() {
            buildShaderString();
            InternalBuilder internalBuilder = new InternalBuilder(this.mRS);
            internalBuilder.setShader(this.mShader);
            internalBuilder.addConstant(getConstantInputType(this.mRS));
            Element.Builder builder = new Element.Builder(this.mRS);
            builder.add(Element.F32_4(this.mRS), BrowserContract.Bookmarks.POSITION);
            builder.add(Element.F32_4(this.mRS), "color");
            builder.add(Element.F32_3(this.mRS), "normal");
            builder.add(Element.F32_2(this.mRS), "texture0");
            internalBuilder.addInput(builder.create());
            return internalBuilder.create();
        }

        public Builder setTextureMatrixEnable(boolean z) {
            this.mTextureMatrixEnable = z;
            return this;
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/renderscript/ProgramVertexFixedFunction$Constants.class */
    public static class Constants {
        static final int MODELVIEW_OFFSET = 0;
        static final int PROJECTION_OFFSET = 16;
        static final int TEXTURE_OFFSET = 32;
        Allocation mAlloc;
        private FieldPacker mIOBuffer;
        Matrix4f mModel;
        Matrix4f mProjection;
        Matrix4f mTexture;

        public Constants(RenderScript renderScript) {
            Type constantInputType = Builder.getConstantInputType(renderScript);
            this.mAlloc = Allocation.createTyped(renderScript, constantInputType);
            this.mIOBuffer = new FieldPacker(constantInputType.getElement().getBytesSize() * constantInputType.getCount());
            this.mModel = new Matrix4f();
            this.mProjection = new Matrix4f();
            this.mTexture = new Matrix4f();
            setModelview(new Matrix4f());
            setProjection(new Matrix4f());
            setTexture(new Matrix4f());
        }

        private void addToBuffer(int i, Matrix4f matrix4f) {
            this.mIOBuffer.reset(i);
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= 16) {
                    this.mIOBuffer.reset(this.mIOBuffer.getData().length);
                    this.mAlloc.setFromFieldPacker(0, this.mIOBuffer);
                    return;
                }
                this.mIOBuffer.addF32(matrix4f.mMat[i3]);
                i2 = i3 + 1;
            }
        }

        public void destroy() {
            this.mAlloc.destroy();
            this.mAlloc = null;
        }

        Allocation getAllocation() {
            return this.mAlloc;
        }

        public void setModelview(Matrix4f matrix4f) {
            this.mModel.load(matrix4f);
            addToBuffer(0, matrix4f);
        }

        public void setProjection(Matrix4f matrix4f) {
            this.mProjection.load(matrix4f);
            addToBuffer(64, matrix4f);
        }

        public void setTexture(Matrix4f matrix4f) {
            this.mTexture.load(matrix4f);
            addToBuffer(128, matrix4f);
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/renderscript/ProgramVertexFixedFunction$InternalBuilder.class */
    static class InternalBuilder extends Program.BaseProgramBuilder {
        public InternalBuilder(RenderScript renderScript) {
            super(renderScript);
        }

        public InternalBuilder addInput(Element element) throws IllegalStateException {
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

        public ProgramVertexFixedFunction create() {
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
                    ProgramVertexFixedFunction programVertexFixedFunction = new ProgramVertexFixedFunction(this.mRS.nProgramVertexCreate(this.mShader, strArr, jArr), this.mRS);
                    initProgram(programVertexFixedFunction);
                    return programVertexFixedFunction;
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

    ProgramVertexFixedFunction(long j, RenderScript renderScript) {
        super(j, renderScript);
    }

    public void bindConstants(Constants constants) {
        this.mRS.validate();
        bindConstants(constants.getAllocation(), 0);
    }
}
