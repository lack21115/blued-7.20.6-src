package android.renderscript;

import android.renderscript.Element;
import android.renderscript.Program;
import android.renderscript.Type;

/* loaded from: source-9557208-dex2jar.jar:android/renderscript/ProgramFragmentFixedFunction.class */
public class ProgramFragmentFixedFunction extends ProgramFragment {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: android.renderscript.ProgramFragmentFixedFunction$1  reason: invalid class name */
    /* loaded from: source-9557208-dex2jar.jar:android/renderscript/ProgramFragmentFixedFunction$1.class */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$android$renderscript$ProgramFragmentFixedFunction$Builder$EnvMode = new int[Builder.EnvMode.values().length];
        static final /* synthetic */ int[] $SwitchMap$android$renderscript$ProgramFragmentFixedFunction$Builder$Format;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0062 -> B:40:0x0054). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0066 -> B:42:0x0049). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x006a -> B:36:0x003e). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x006e -> B:8:0x002a). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x0072 -> B:32:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x0076 -> B:44:0x0014). Please submit an issue!!! */
        static {
            try {
                $SwitchMap$android$renderscript$ProgramFragmentFixedFunction$Builder$EnvMode[Builder.EnvMode.REPLACE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$android$renderscript$ProgramFragmentFixedFunction$Builder$EnvMode[Builder.EnvMode.MODULATE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$android$renderscript$ProgramFragmentFixedFunction$Builder$EnvMode[Builder.EnvMode.DECAL.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            $SwitchMap$android$renderscript$ProgramFragmentFixedFunction$Builder$Format = new int[Builder.Format.values().length];
            try {
                $SwitchMap$android$renderscript$ProgramFragmentFixedFunction$Builder$Format[Builder.Format.ALPHA.ordinal()] = 1;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$android$renderscript$ProgramFragmentFixedFunction$Builder$Format[Builder.Format.LUMINANCE_ALPHA.ordinal()] = 2;
            } catch (NoSuchFieldError e5) {
            }
            try {
                $SwitchMap$android$renderscript$ProgramFragmentFixedFunction$Builder$Format[Builder.Format.RGB.ordinal()] = 3;
            } catch (NoSuchFieldError e6) {
            }
            try {
                $SwitchMap$android$renderscript$ProgramFragmentFixedFunction$Builder$Format[Builder.Format.RGBA.ordinal()] = 4;
            } catch (NoSuchFieldError e7) {
            }
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/renderscript/ProgramFragmentFixedFunction$Builder.class */
    public static class Builder {
        public static final int MAX_TEXTURE = 2;
        int mNumTextures;
        RenderScript mRS;
        String mShader;
        boolean mVaryingColorEnable;
        Slot[] mSlots = new Slot[2];
        boolean mPointSpriteEnable = false;

        /* loaded from: source-9557208-dex2jar.jar:android/renderscript/ProgramFragmentFixedFunction$Builder$EnvMode.class */
        public enum EnvMode {
            REPLACE(1),
            MODULATE(2),
            DECAL(3);
            
            int mID;

            EnvMode(int i) {
                this.mID = i;
            }
        }

        /* loaded from: source-9557208-dex2jar.jar:android/renderscript/ProgramFragmentFixedFunction$Builder$Format.class */
        public enum Format {
            ALPHA(1),
            LUMINANCE_ALPHA(2),
            RGB(3),
            RGBA(4);
            
            int mID;

            Format(int i) {
                this.mID = i;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: source-9557208-dex2jar.jar:android/renderscript/ProgramFragmentFixedFunction$Builder$Slot.class */
        public class Slot {
            EnvMode env;
            Format format;

            Slot(EnvMode envMode, Format format) {
                this.env = envMode;
                this.format = format;
            }
        }

        public Builder(RenderScript renderScript) {
            this.mRS = renderScript;
        }

        private void buildShaderString() {
            this.mShader = "//rs_shader_internal\n";
            this.mShader += "varying lowp vec4 varColor;\n";
            this.mShader += "varying vec2 varTex0;\n";
            this.mShader += "void main() {\n";
            if (this.mVaryingColorEnable) {
                this.mShader += "  lowp vec4 col = varColor;\n";
            } else {
                this.mShader += "  lowp vec4 col = UNI_Color;\n";
            }
            if (this.mNumTextures != 0) {
                if (this.mPointSpriteEnable) {
                    this.mShader += "  vec2 t0 = gl_PointCoord;\n";
                } else {
                    this.mShader += "  vec2 t0 = varTex0.xy;\n";
                }
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.mNumTextures) {
                    this.mShader += "  gl_FragColor = col;\n";
                    this.mShader += "}\n";
                    return;
                }
                switch (AnonymousClass1.$SwitchMap$android$renderscript$ProgramFragmentFixedFunction$Builder$EnvMode[this.mSlots[i2].env.ordinal()]) {
                    case 1:
                        switch (AnonymousClass1.$SwitchMap$android$renderscript$ProgramFragmentFixedFunction$Builder$Format[this.mSlots[i2].format.ordinal()]) {
                            case 1:
                                this.mShader += "  col.a = texture2D(UNI_Tex0, t0).a;\n";
                                continue;
                            case 2:
                                this.mShader += "  col.rgba = texture2D(UNI_Tex0, t0).rgba;\n";
                                continue;
                            case 3:
                                this.mShader += "  col.rgb = texture2D(UNI_Tex0, t0).rgb;\n";
                                continue;
                            case 4:
                                this.mShader += "  col.rgba = texture2D(UNI_Tex0, t0).rgba;\n";
                                continue;
                        }
                    case 2:
                        switch (AnonymousClass1.$SwitchMap$android$renderscript$ProgramFragmentFixedFunction$Builder$Format[this.mSlots[i2].format.ordinal()]) {
                            case 1:
                                this.mShader += "  col.a *= texture2D(UNI_Tex0, t0).a;\n";
                                continue;
                            case 2:
                                this.mShader += "  col.rgba *= texture2D(UNI_Tex0, t0).rgba;\n";
                                continue;
                            case 3:
                                this.mShader += "  col.rgb *= texture2D(UNI_Tex0, t0).rgb;\n";
                                continue;
                            case 4:
                                this.mShader += "  col.rgba *= texture2D(UNI_Tex0, t0).rgba;\n";
                                continue;
                        }
                    case 3:
                        this.mShader += "  col = texture2D(UNI_Tex0, t0);\n";
                        break;
                }
                i = i2 + 1;
            }
        }

        public ProgramFragmentFixedFunction create() {
            InternalBuilder internalBuilder = new InternalBuilder(this.mRS);
            this.mNumTextures = 0;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= 2) {
                    break;
                }
                if (this.mSlots[i2] != null) {
                    this.mNumTextures++;
                }
                i = i2 + 1;
            }
            buildShaderString();
            internalBuilder.setShader(this.mShader);
            Type type = null;
            if (!this.mVaryingColorEnable) {
                Element.Builder builder = new Element.Builder(this.mRS);
                builder.add(Element.F32_4(this.mRS), "Color");
                Type.Builder builder2 = new Type.Builder(this.mRS, builder.create());
                builder2.setX(1);
                type = builder2.create();
                internalBuilder.addConstant(type);
            }
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= this.mNumTextures) {
                    break;
                }
                internalBuilder.addTexture(Program.TextureType.TEXTURE_2D);
                i3 = i4 + 1;
            }
            ProgramFragmentFixedFunction create = internalBuilder.create();
            create.mTextureCount = 2;
            if (!this.mVaryingColorEnable) {
                Allocation createTyped = Allocation.createTyped(this.mRS, type);
                FieldPacker fieldPacker = new FieldPacker(16);
                fieldPacker.addF32(new Float4(1.0f, 1.0f, 1.0f, 1.0f));
                createTyped.setFromFieldPacker(0, fieldPacker);
                create.bindConstants(createTyped, 0);
            }
            return create;
        }

        public Builder setPointSpriteTexCoordinateReplacement(boolean z) {
            this.mPointSpriteEnable = z;
            return this;
        }

        public Builder setTexture(EnvMode envMode, Format format, int i) throws IllegalArgumentException {
            if (i < 0 || i >= 2) {
                throw new IllegalArgumentException("MAX_TEXTURE exceeded.");
            }
            this.mSlots[i] = new Slot(envMode, format);
            return this;
        }

        public Builder setVaryingColor(boolean z) {
            this.mVaryingColorEnable = z;
            return this;
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/renderscript/ProgramFragmentFixedFunction$InternalBuilder.class */
    static class InternalBuilder extends Program.BaseProgramBuilder {
        public InternalBuilder(RenderScript renderScript) {
            super(renderScript);
        }

        public ProgramFragmentFixedFunction create() {
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
                    ProgramFragmentFixedFunction programFragmentFixedFunction = new ProgramFragmentFixedFunction(this.mRS.nProgramFragmentCreate(this.mShader, strArr, jArr), this.mRS);
                    initProgram(programFragmentFixedFunction);
                    return programFragmentFixedFunction;
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

    ProgramFragmentFixedFunction(long j, RenderScript renderScript) {
        super(j, renderScript);
    }
}
