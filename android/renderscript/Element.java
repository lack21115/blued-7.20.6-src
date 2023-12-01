package android.renderscript;

/* loaded from: source-9557208-dex2jar.jar:android/renderscript/Element.class */
public class Element extends BaseObj {
    int[] mArraySizes;
    String[] mElementNames;
    Element[] mElements;
    DataKind mKind;
    boolean mNormalized;
    int[] mOffsetInBytes;
    int mSize;
    DataType mType;
    int mVectorSize;
    int[] mVisibleElementMap;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: android.renderscript.Element$1  reason: invalid class name */
    /* loaded from: source-9557208-dex2jar.jar:android/renderscript/Element$1.class */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$android$renderscript$Element$DataKind = new int[DataKind.values().length];
        static final /* synthetic */ int[] $SwitchMap$android$renderscript$Element$DataType;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:36:0x00c0 -> B:82:0x00b1). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x00c4 -> B:90:0x00a5). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:40:0x00c8 -> B:86:0x0099). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:42:0x00cc -> B:68:0x008d). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:44:0x00d0 -> B:64:0x0081). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:46:0x00d4 -> B:76:0x0075). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:48:0x00d8 -> B:72:0x006a). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:50:0x00dc -> B:84:0x005f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:52:0x00e0 -> B:80:0x0054). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:54:0x00e4 -> B:92:0x0049). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:56:0x00e8 -> B:10:0x0035). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:58:0x00ec -> B:70:0x002a). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:60:0x00f0 -> B:66:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:62:0x00f4 -> B:78:0x0014). Please submit an issue!!! */
        static {
            try {
                $SwitchMap$android$renderscript$Element$DataKind[DataKind.PIXEL_LA.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$android$renderscript$Element$DataKind[DataKind.PIXEL_RGB.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$android$renderscript$Element$DataKind[DataKind.PIXEL_RGBA.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$android$renderscript$Element$DataKind[DataKind.PIXEL_DEPTH.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            $SwitchMap$android$renderscript$Element$DataType = new int[DataType.values().length];
            try {
                $SwitchMap$android$renderscript$Element$DataType[DataType.FLOAT_32.ordinal()] = 1;
            } catch (NoSuchFieldError e5) {
            }
            try {
                $SwitchMap$android$renderscript$Element$DataType[DataType.FLOAT_64.ordinal()] = 2;
            } catch (NoSuchFieldError e6) {
            }
            try {
                $SwitchMap$android$renderscript$Element$DataType[DataType.SIGNED_8.ordinal()] = 3;
            } catch (NoSuchFieldError e7) {
            }
            try {
                $SwitchMap$android$renderscript$Element$DataType[DataType.SIGNED_16.ordinal()] = 4;
            } catch (NoSuchFieldError e8) {
            }
            try {
                $SwitchMap$android$renderscript$Element$DataType[DataType.SIGNED_32.ordinal()] = 5;
            } catch (NoSuchFieldError e9) {
            }
            try {
                $SwitchMap$android$renderscript$Element$DataType[DataType.SIGNED_64.ordinal()] = 6;
            } catch (NoSuchFieldError e10) {
            }
            try {
                $SwitchMap$android$renderscript$Element$DataType[DataType.UNSIGNED_8.ordinal()] = 7;
            } catch (NoSuchFieldError e11) {
            }
            try {
                $SwitchMap$android$renderscript$Element$DataType[DataType.UNSIGNED_16.ordinal()] = 8;
            } catch (NoSuchFieldError e12) {
            }
            try {
                $SwitchMap$android$renderscript$Element$DataType[DataType.UNSIGNED_32.ordinal()] = 9;
            } catch (NoSuchFieldError e13) {
            }
            try {
                $SwitchMap$android$renderscript$Element$DataType[DataType.UNSIGNED_64.ordinal()] = 10;
            } catch (NoSuchFieldError e14) {
            }
            try {
                $SwitchMap$android$renderscript$Element$DataType[DataType.BOOLEAN.ordinal()] = 11;
            } catch (NoSuchFieldError e15) {
            }
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/renderscript/Element$Builder.class */
    public static class Builder {
        RenderScript mRS;
        int mSkipPadding;
        int mCount = 0;
        Element[] mElements = new Element[8];
        String[] mElementNames = new String[8];
        int[] mArraySizes = new int[8];

        public Builder(RenderScript renderScript) {
            this.mRS = renderScript;
        }

        public Builder add(Element element, String str) {
            return add(element, str, 1);
        }

        public Builder add(Element element, String str, int i) {
            if (i < 1) {
                throw new RSIllegalArgumentException("Array size cannot be less than 1.");
            }
            if (this.mSkipPadding != 0 && str.startsWith("#padding_")) {
                this.mSkipPadding = 0;
                return this;
            }
            if (element.mVectorSize == 3) {
                this.mSkipPadding = 1;
            } else {
                this.mSkipPadding = 0;
            }
            if (this.mCount == this.mElements.length) {
                Element[] elementArr = new Element[this.mCount + 8];
                String[] strArr = new String[this.mCount + 8];
                int[] iArr = new int[this.mCount + 8];
                System.arraycopy(this.mElements, 0, elementArr, 0, this.mCount);
                System.arraycopy(this.mElementNames, 0, strArr, 0, this.mCount);
                System.arraycopy(this.mArraySizes, 0, iArr, 0, this.mCount);
                this.mElements = elementArr;
                this.mElementNames = strArr;
                this.mArraySizes = iArr;
            }
            this.mElements[this.mCount] = element;
            this.mElementNames[this.mCount] = str;
            this.mArraySizes[this.mCount] = i;
            this.mCount++;
            return this;
        }

        public Element create() {
            this.mRS.validate();
            Element[] elementArr = new Element[this.mCount];
            String[] strArr = new String[this.mCount];
            int[] iArr = new int[this.mCount];
            System.arraycopy(this.mElements, 0, elementArr, 0, this.mCount);
            System.arraycopy(this.mElementNames, 0, strArr, 0, this.mCount);
            System.arraycopy(this.mArraySizes, 0, iArr, 0, this.mCount);
            long[] jArr = new long[elementArr.length];
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= elementArr.length) {
                    return new Element(this.mRS.nElementCreate2(jArr, strArr, iArr), this.mRS, elementArr, strArr, iArr);
                }
                jArr[i2] = elementArr[i2].getID(this.mRS);
                i = i2 + 1;
            }
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/renderscript/Element$DataKind.class */
    public enum DataKind {
        USER(0),
        PIXEL_L(7),
        PIXEL_A(8),
        PIXEL_LA(9),
        PIXEL_RGB(10),
        PIXEL_RGBA(11),
        PIXEL_DEPTH(12),
        PIXEL_YUV(13);
        
        int mID;

        DataKind(int i) {
            this.mID = i;
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/renderscript/Element$DataType.class */
    public enum DataType {
        NONE(0, 0),
        FLOAT_32(2, 4),
        FLOAT_64(3, 8),
        SIGNED_8(4, 1),
        SIGNED_16(5, 2),
        SIGNED_32(6, 4),
        SIGNED_64(7, 8),
        UNSIGNED_8(8, 1),
        UNSIGNED_16(9, 2),
        UNSIGNED_32(10, 4),
        UNSIGNED_64(11, 8),
        BOOLEAN(12, 1),
        UNSIGNED_5_6_5(13, 2),
        UNSIGNED_5_5_5_1(14, 2),
        UNSIGNED_4_4_4_4(15, 2),
        MATRIX_4X4(16, 64),
        MATRIX_3X3(17, 36),
        MATRIX_2X2(18, 16),
        RS_ELEMENT(1000),
        RS_TYPE(1001),
        RS_ALLOCATION(1002),
        RS_SAMPLER(1003),
        RS_SCRIPT(1004),
        RS_MESH(1005),
        RS_PROGRAM_FRAGMENT(1006),
        RS_PROGRAM_VERTEX(1007),
        RS_PROGRAM_RASTER(1008),
        RS_PROGRAM_STORE(1009),
        RS_FONT(1010);
        
        int mID;
        int mSize;

        DataType(int i) {
            this.mID = i;
            this.mSize = 4;
            if (RenderScript.sPointerSize == 8) {
                this.mSize = 32;
            }
        }

        DataType(int i, int i2) {
            this.mID = i;
            this.mSize = i2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Element(long j, RenderScript renderScript) {
        super(j, renderScript);
    }

    Element(long j, RenderScript renderScript, DataType dataType, DataKind dataKind, boolean z, int i) {
        super(j, renderScript);
        if (dataType == DataType.UNSIGNED_5_6_5 || dataType == DataType.UNSIGNED_4_4_4_4 || dataType == DataType.UNSIGNED_5_5_5_1) {
            this.mSize = dataType.mSize;
        } else if (i == 3) {
            this.mSize = dataType.mSize * 4;
        } else {
            this.mSize = dataType.mSize * i;
        }
        this.mType = dataType;
        this.mKind = dataKind;
        this.mNormalized = z;
        this.mVectorSize = i;
    }

    Element(long j, RenderScript renderScript, Element[] elementArr, String[] strArr, int[] iArr) {
        super(j, renderScript);
        this.mSize = 0;
        this.mVectorSize = 1;
        this.mElements = elementArr;
        this.mElementNames = strArr;
        this.mArraySizes = iArr;
        this.mType = DataType.NONE;
        this.mKind = DataKind.USER;
        this.mOffsetInBytes = new int[this.mElements.length];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.mElements.length) {
                updateVisibleSubElements();
                return;
            }
            this.mOffsetInBytes[i2] = this.mSize;
            this.mSize += this.mElements[i2].mSize * this.mArraySizes[i2];
            i = i2 + 1;
        }
    }

    public static Element ALLOCATION(RenderScript renderScript) {
        if (renderScript.mElement_ALLOCATION == null) {
            renderScript.mElement_ALLOCATION = createUser(renderScript, DataType.RS_ALLOCATION);
        }
        return renderScript.mElement_ALLOCATION;
    }

    public static Element A_8(RenderScript renderScript) {
        if (renderScript.mElement_A_8 == null) {
            renderScript.mElement_A_8 = createPixel(renderScript, DataType.UNSIGNED_8, DataKind.PIXEL_A);
        }
        return renderScript.mElement_A_8;
    }

    public static Element BOOLEAN(RenderScript renderScript) {
        if (renderScript.mElement_BOOLEAN == null) {
            renderScript.mElement_BOOLEAN = createUser(renderScript, DataType.BOOLEAN);
        }
        return renderScript.mElement_BOOLEAN;
    }

    public static Element ELEMENT(RenderScript renderScript) {
        if (renderScript.mElement_ELEMENT == null) {
            renderScript.mElement_ELEMENT = createUser(renderScript, DataType.RS_ELEMENT);
        }
        return renderScript.mElement_ELEMENT;
    }

    public static Element F32(RenderScript renderScript) {
        if (renderScript.mElement_F32 == null) {
            renderScript.mElement_F32 = createUser(renderScript, DataType.FLOAT_32);
        }
        return renderScript.mElement_F32;
    }

    public static Element F32_2(RenderScript renderScript) {
        if (renderScript.mElement_FLOAT_2 == null) {
            renderScript.mElement_FLOAT_2 = createVector(renderScript, DataType.FLOAT_32, 2);
        }
        return renderScript.mElement_FLOAT_2;
    }

    public static Element F32_3(RenderScript renderScript) {
        if (renderScript.mElement_FLOAT_3 == null) {
            renderScript.mElement_FLOAT_3 = createVector(renderScript, DataType.FLOAT_32, 3);
        }
        return renderScript.mElement_FLOAT_3;
    }

    public static Element F32_4(RenderScript renderScript) {
        if (renderScript.mElement_FLOAT_4 == null) {
            renderScript.mElement_FLOAT_4 = createVector(renderScript, DataType.FLOAT_32, 4);
        }
        return renderScript.mElement_FLOAT_4;
    }

    public static Element F64(RenderScript renderScript) {
        if (renderScript.mElement_F64 == null) {
            renderScript.mElement_F64 = createUser(renderScript, DataType.FLOAT_64);
        }
        return renderScript.mElement_F64;
    }

    public static Element F64_2(RenderScript renderScript) {
        if (renderScript.mElement_DOUBLE_2 == null) {
            renderScript.mElement_DOUBLE_2 = createVector(renderScript, DataType.FLOAT_64, 2);
        }
        return renderScript.mElement_DOUBLE_2;
    }

    public static Element F64_3(RenderScript renderScript) {
        if (renderScript.mElement_DOUBLE_3 == null) {
            renderScript.mElement_DOUBLE_3 = createVector(renderScript, DataType.FLOAT_64, 3);
        }
        return renderScript.mElement_DOUBLE_3;
    }

    public static Element F64_4(RenderScript renderScript) {
        if (renderScript.mElement_DOUBLE_4 == null) {
            renderScript.mElement_DOUBLE_4 = createVector(renderScript, DataType.FLOAT_64, 4);
        }
        return renderScript.mElement_DOUBLE_4;
    }

    public static Element FONT(RenderScript renderScript) {
        if (renderScript.mElement_FONT == null) {
            renderScript.mElement_FONT = createUser(renderScript, DataType.RS_FONT);
        }
        return renderScript.mElement_FONT;
    }

    public static Element I16(RenderScript renderScript) {
        if (renderScript.mElement_I16 == null) {
            renderScript.mElement_I16 = createUser(renderScript, DataType.SIGNED_16);
        }
        return renderScript.mElement_I16;
    }

    public static Element I16_2(RenderScript renderScript) {
        if (renderScript.mElement_SHORT_2 == null) {
            renderScript.mElement_SHORT_2 = createVector(renderScript, DataType.SIGNED_16, 2);
        }
        return renderScript.mElement_SHORT_2;
    }

    public static Element I16_3(RenderScript renderScript) {
        if (renderScript.mElement_SHORT_3 == null) {
            renderScript.mElement_SHORT_3 = createVector(renderScript, DataType.SIGNED_16, 3);
        }
        return renderScript.mElement_SHORT_3;
    }

    public static Element I16_4(RenderScript renderScript) {
        if (renderScript.mElement_SHORT_4 == null) {
            renderScript.mElement_SHORT_4 = createVector(renderScript, DataType.SIGNED_16, 4);
        }
        return renderScript.mElement_SHORT_4;
    }

    public static Element I32(RenderScript renderScript) {
        if (renderScript.mElement_I32 == null) {
            renderScript.mElement_I32 = createUser(renderScript, DataType.SIGNED_32);
        }
        return renderScript.mElement_I32;
    }

    public static Element I32_2(RenderScript renderScript) {
        if (renderScript.mElement_INT_2 == null) {
            renderScript.mElement_INT_2 = createVector(renderScript, DataType.SIGNED_32, 2);
        }
        return renderScript.mElement_INT_2;
    }

    public static Element I32_3(RenderScript renderScript) {
        if (renderScript.mElement_INT_3 == null) {
            renderScript.mElement_INT_3 = createVector(renderScript, DataType.SIGNED_32, 3);
        }
        return renderScript.mElement_INT_3;
    }

    public static Element I32_4(RenderScript renderScript) {
        if (renderScript.mElement_INT_4 == null) {
            renderScript.mElement_INT_4 = createVector(renderScript, DataType.SIGNED_32, 4);
        }
        return renderScript.mElement_INT_4;
    }

    public static Element I64(RenderScript renderScript) {
        if (renderScript.mElement_I64 == null) {
            renderScript.mElement_I64 = createUser(renderScript, DataType.SIGNED_64);
        }
        return renderScript.mElement_I64;
    }

    public static Element I64_2(RenderScript renderScript) {
        if (renderScript.mElement_LONG_2 == null) {
            renderScript.mElement_LONG_2 = createVector(renderScript, DataType.SIGNED_64, 2);
        }
        return renderScript.mElement_LONG_2;
    }

    public static Element I64_3(RenderScript renderScript) {
        if (renderScript.mElement_LONG_3 == null) {
            renderScript.mElement_LONG_3 = createVector(renderScript, DataType.SIGNED_64, 3);
        }
        return renderScript.mElement_LONG_3;
    }

    public static Element I64_4(RenderScript renderScript) {
        if (renderScript.mElement_LONG_4 == null) {
            renderScript.mElement_LONG_4 = createVector(renderScript, DataType.SIGNED_64, 4);
        }
        return renderScript.mElement_LONG_4;
    }

    public static Element I8(RenderScript renderScript) {
        if (renderScript.mElement_I8 == null) {
            renderScript.mElement_I8 = createUser(renderScript, DataType.SIGNED_8);
        }
        return renderScript.mElement_I8;
    }

    public static Element I8_2(RenderScript renderScript) {
        if (renderScript.mElement_CHAR_2 == null) {
            renderScript.mElement_CHAR_2 = createVector(renderScript, DataType.SIGNED_8, 2);
        }
        return renderScript.mElement_CHAR_2;
    }

    public static Element I8_3(RenderScript renderScript) {
        if (renderScript.mElement_CHAR_3 == null) {
            renderScript.mElement_CHAR_3 = createVector(renderScript, DataType.SIGNED_8, 3);
        }
        return renderScript.mElement_CHAR_3;
    }

    public static Element I8_4(RenderScript renderScript) {
        if (renderScript.mElement_CHAR_4 == null) {
            renderScript.mElement_CHAR_4 = createVector(renderScript, DataType.SIGNED_8, 4);
        }
        return renderScript.mElement_CHAR_4;
    }

    public static Element MATRIX4X4(RenderScript renderScript) {
        return MATRIX_4X4(renderScript);
    }

    public static Element MATRIX_2X2(RenderScript renderScript) {
        if (renderScript.mElement_MATRIX_2X2 == null) {
            renderScript.mElement_MATRIX_2X2 = createUser(renderScript, DataType.MATRIX_2X2);
        }
        return renderScript.mElement_MATRIX_2X2;
    }

    public static Element MATRIX_3X3(RenderScript renderScript) {
        if (renderScript.mElement_MATRIX_3X3 == null) {
            renderScript.mElement_MATRIX_3X3 = createUser(renderScript, DataType.MATRIX_3X3);
        }
        return renderScript.mElement_MATRIX_3X3;
    }

    public static Element MATRIX_4X4(RenderScript renderScript) {
        if (renderScript.mElement_MATRIX_4X4 == null) {
            renderScript.mElement_MATRIX_4X4 = createUser(renderScript, DataType.MATRIX_4X4);
        }
        return renderScript.mElement_MATRIX_4X4;
    }

    public static Element MESH(RenderScript renderScript) {
        if (renderScript.mElement_MESH == null) {
            renderScript.mElement_MESH = createUser(renderScript, DataType.RS_MESH);
        }
        return renderScript.mElement_MESH;
    }

    public static Element PROGRAM_FRAGMENT(RenderScript renderScript) {
        if (renderScript.mElement_PROGRAM_FRAGMENT == null) {
            renderScript.mElement_PROGRAM_FRAGMENT = createUser(renderScript, DataType.RS_PROGRAM_FRAGMENT);
        }
        return renderScript.mElement_PROGRAM_FRAGMENT;
    }

    public static Element PROGRAM_RASTER(RenderScript renderScript) {
        if (renderScript.mElement_PROGRAM_RASTER == null) {
            renderScript.mElement_PROGRAM_RASTER = createUser(renderScript, DataType.RS_PROGRAM_RASTER);
        }
        return renderScript.mElement_PROGRAM_RASTER;
    }

    public static Element PROGRAM_STORE(RenderScript renderScript) {
        if (renderScript.mElement_PROGRAM_STORE == null) {
            renderScript.mElement_PROGRAM_STORE = createUser(renderScript, DataType.RS_PROGRAM_STORE);
        }
        return renderScript.mElement_PROGRAM_STORE;
    }

    public static Element PROGRAM_VERTEX(RenderScript renderScript) {
        if (renderScript.mElement_PROGRAM_VERTEX == null) {
            renderScript.mElement_PROGRAM_VERTEX = createUser(renderScript, DataType.RS_PROGRAM_VERTEX);
        }
        return renderScript.mElement_PROGRAM_VERTEX;
    }

    public static Element RGBA_4444(RenderScript renderScript) {
        if (renderScript.mElement_RGBA_4444 == null) {
            renderScript.mElement_RGBA_4444 = createPixel(renderScript, DataType.UNSIGNED_4_4_4_4, DataKind.PIXEL_RGBA);
        }
        return renderScript.mElement_RGBA_4444;
    }

    public static Element RGBA_5551(RenderScript renderScript) {
        if (renderScript.mElement_RGBA_5551 == null) {
            renderScript.mElement_RGBA_5551 = createPixel(renderScript, DataType.UNSIGNED_5_5_5_1, DataKind.PIXEL_RGBA);
        }
        return renderScript.mElement_RGBA_5551;
    }

    public static Element RGBA_8888(RenderScript renderScript) {
        if (renderScript.mElement_RGBA_8888 == null) {
            renderScript.mElement_RGBA_8888 = createPixel(renderScript, DataType.UNSIGNED_8, DataKind.PIXEL_RGBA);
        }
        return renderScript.mElement_RGBA_8888;
    }

    public static Element RGB_565(RenderScript renderScript) {
        if (renderScript.mElement_RGB_565 == null) {
            renderScript.mElement_RGB_565 = createPixel(renderScript, DataType.UNSIGNED_5_6_5, DataKind.PIXEL_RGB);
        }
        return renderScript.mElement_RGB_565;
    }

    public static Element RGB_888(RenderScript renderScript) {
        if (renderScript.mElement_RGB_888 == null) {
            renderScript.mElement_RGB_888 = createPixel(renderScript, DataType.UNSIGNED_8, DataKind.PIXEL_RGB);
        }
        return renderScript.mElement_RGB_888;
    }

    public static Element SAMPLER(RenderScript renderScript) {
        if (renderScript.mElement_SAMPLER == null) {
            renderScript.mElement_SAMPLER = createUser(renderScript, DataType.RS_SAMPLER);
        }
        return renderScript.mElement_SAMPLER;
    }

    public static Element SCRIPT(RenderScript renderScript) {
        if (renderScript.mElement_SCRIPT == null) {
            renderScript.mElement_SCRIPT = createUser(renderScript, DataType.RS_SCRIPT);
        }
        return renderScript.mElement_SCRIPT;
    }

    public static Element TYPE(RenderScript renderScript) {
        if (renderScript.mElement_TYPE == null) {
            renderScript.mElement_TYPE = createUser(renderScript, DataType.RS_TYPE);
        }
        return renderScript.mElement_TYPE;
    }

    public static Element U16(RenderScript renderScript) {
        if (renderScript.mElement_U16 == null) {
            renderScript.mElement_U16 = createUser(renderScript, DataType.UNSIGNED_16);
        }
        return renderScript.mElement_U16;
    }

    public static Element U16_2(RenderScript renderScript) {
        if (renderScript.mElement_USHORT_2 == null) {
            renderScript.mElement_USHORT_2 = createVector(renderScript, DataType.UNSIGNED_16, 2);
        }
        return renderScript.mElement_USHORT_2;
    }

    public static Element U16_3(RenderScript renderScript) {
        if (renderScript.mElement_USHORT_3 == null) {
            renderScript.mElement_USHORT_3 = createVector(renderScript, DataType.UNSIGNED_16, 3);
        }
        return renderScript.mElement_USHORT_3;
    }

    public static Element U16_4(RenderScript renderScript) {
        if (renderScript.mElement_USHORT_4 == null) {
            renderScript.mElement_USHORT_4 = createVector(renderScript, DataType.UNSIGNED_16, 4);
        }
        return renderScript.mElement_USHORT_4;
    }

    public static Element U32(RenderScript renderScript) {
        if (renderScript.mElement_U32 == null) {
            renderScript.mElement_U32 = createUser(renderScript, DataType.UNSIGNED_32);
        }
        return renderScript.mElement_U32;
    }

    public static Element U32_2(RenderScript renderScript) {
        if (renderScript.mElement_UINT_2 == null) {
            renderScript.mElement_UINT_2 = createVector(renderScript, DataType.UNSIGNED_32, 2);
        }
        return renderScript.mElement_UINT_2;
    }

    public static Element U32_3(RenderScript renderScript) {
        if (renderScript.mElement_UINT_3 == null) {
            renderScript.mElement_UINT_3 = createVector(renderScript, DataType.UNSIGNED_32, 3);
        }
        return renderScript.mElement_UINT_3;
    }

    public static Element U32_4(RenderScript renderScript) {
        if (renderScript.mElement_UINT_4 == null) {
            renderScript.mElement_UINT_4 = createVector(renderScript, DataType.UNSIGNED_32, 4);
        }
        return renderScript.mElement_UINT_4;
    }

    public static Element U64(RenderScript renderScript) {
        if (renderScript.mElement_U64 == null) {
            renderScript.mElement_U64 = createUser(renderScript, DataType.UNSIGNED_64);
        }
        return renderScript.mElement_U64;
    }

    public static Element U64_2(RenderScript renderScript) {
        if (renderScript.mElement_ULONG_2 == null) {
            renderScript.mElement_ULONG_2 = createVector(renderScript, DataType.UNSIGNED_64, 2);
        }
        return renderScript.mElement_ULONG_2;
    }

    public static Element U64_3(RenderScript renderScript) {
        if (renderScript.mElement_ULONG_3 == null) {
            renderScript.mElement_ULONG_3 = createVector(renderScript, DataType.UNSIGNED_64, 3);
        }
        return renderScript.mElement_ULONG_3;
    }

    public static Element U64_4(RenderScript renderScript) {
        if (renderScript.mElement_ULONG_4 == null) {
            renderScript.mElement_ULONG_4 = createVector(renderScript, DataType.UNSIGNED_64, 4);
        }
        return renderScript.mElement_ULONG_4;
    }

    public static Element U8(RenderScript renderScript) {
        if (renderScript.mElement_U8 == null) {
            renderScript.mElement_U8 = createUser(renderScript, DataType.UNSIGNED_8);
        }
        return renderScript.mElement_U8;
    }

    public static Element U8_2(RenderScript renderScript) {
        if (renderScript.mElement_UCHAR_2 == null) {
            renderScript.mElement_UCHAR_2 = createVector(renderScript, DataType.UNSIGNED_8, 2);
        }
        return renderScript.mElement_UCHAR_2;
    }

    public static Element U8_3(RenderScript renderScript) {
        if (renderScript.mElement_UCHAR_3 == null) {
            renderScript.mElement_UCHAR_3 = createVector(renderScript, DataType.UNSIGNED_8, 3);
        }
        return renderScript.mElement_UCHAR_3;
    }

    public static Element U8_4(RenderScript renderScript) {
        if (renderScript.mElement_UCHAR_4 == null) {
            renderScript.mElement_UCHAR_4 = createVector(renderScript, DataType.UNSIGNED_8, 4);
        }
        return renderScript.mElement_UCHAR_4;
    }

    public static Element YUV(RenderScript renderScript) {
        if (renderScript.mElement_YUV == null) {
            renderScript.mElement_YUV = createPixel(renderScript, DataType.UNSIGNED_8, DataKind.PIXEL_YUV);
        }
        return renderScript.mElement_YUV;
    }

    public static Element createPixel(RenderScript renderScript, DataType dataType, DataKind dataKind) {
        if (dataKind == DataKind.PIXEL_L || dataKind == DataKind.PIXEL_A || dataKind == DataKind.PIXEL_LA || dataKind == DataKind.PIXEL_RGB || dataKind == DataKind.PIXEL_RGBA || dataKind == DataKind.PIXEL_DEPTH || dataKind == DataKind.PIXEL_YUV) {
            if (dataType == DataType.UNSIGNED_8 || dataType == DataType.UNSIGNED_16 || dataType == DataType.UNSIGNED_5_6_5 || dataType == DataType.UNSIGNED_4_4_4_4 || dataType == DataType.UNSIGNED_5_5_5_1) {
                if (dataType != DataType.UNSIGNED_5_6_5 || dataKind == DataKind.PIXEL_RGB) {
                    if (dataType != DataType.UNSIGNED_5_5_5_1 || dataKind == DataKind.PIXEL_RGBA) {
                        if (dataType != DataType.UNSIGNED_4_4_4_4 || dataKind == DataKind.PIXEL_RGBA) {
                            if (dataType != DataType.UNSIGNED_16 || dataKind == DataKind.PIXEL_DEPTH) {
                                int i = 1;
                                switch (AnonymousClass1.$SwitchMap$android$renderscript$Element$DataKind[dataKind.ordinal()]) {
                                    case 1:
                                        i = 2;
                                        break;
                                    case 2:
                                        i = 3;
                                        break;
                                    case 3:
                                        i = 4;
                                        break;
                                    case 4:
                                        i = 2;
                                        break;
                                }
                                return new Element(renderScript.nElementCreate(dataType.mID, dataKind.mID, true, i), renderScript, dataType, dataKind, true, i);
                            }
                            throw new RSIllegalArgumentException("Bad kind and type combo");
                        }
                        throw new RSIllegalArgumentException("Bad kind and type combo");
                    }
                    throw new RSIllegalArgumentException("Bad kind and type combo");
                }
                throw new RSIllegalArgumentException("Bad kind and type combo");
            }
            throw new RSIllegalArgumentException("Unsupported DataType");
        }
        throw new RSIllegalArgumentException("Unsupported DataKind");
    }

    static Element createUser(RenderScript renderScript, DataType dataType) {
        DataKind dataKind = DataKind.USER;
        return new Element(renderScript.nElementCreate(dataType.mID, dataKind.mID, false, 1), renderScript, dataType, dataKind, false, 1);
    }

    public static Element createVector(RenderScript renderScript, DataType dataType, int i) {
        if (i < 2 || i > 4) {
            throw new RSIllegalArgumentException("Vector size out of range 2-4.");
        }
        switch (AnonymousClass1.$SwitchMap$android$renderscript$Element$DataType[dataType.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
                DataKind dataKind = DataKind.USER;
                return new Element(renderScript.nElementCreate(dataType.mID, dataKind.mID, false, i), renderScript, dataType, dataKind, false, i);
            default:
                throw new RSIllegalArgumentException("Cannot create vector of non-primitive type.");
        }
    }

    private void updateVisibleSubElements() {
        if (this.mElements == null) {
            return;
        }
        int i = 0;
        int length = this.mElementNames.length;
        int i2 = 0;
        while (i2 < length) {
            int i3 = i;
            if (this.mElementNames[i2].charAt(0) != '#') {
                i3 = i + 1;
            }
            i2++;
            i = i3;
        }
        this.mVisibleElementMap = new int[i];
        int i4 = 0;
        for (int i5 = 0; i5 < length; i5++) {
            if (this.mElementNames[i5].charAt(0) != '#') {
                this.mVisibleElementMap[i4] = i5;
                i4++;
            }
        }
    }

    public int getBytesSize() {
        return this.mSize;
    }

    public DataKind getDataKind() {
        return this.mKind;
    }

    public DataType getDataType() {
        return this.mType;
    }

    public Element getSubElement(int i) {
        if (this.mVisibleElementMap == null) {
            throw new RSIllegalArgumentException("Element contains no sub-elements");
        }
        if (i < 0 || i >= this.mVisibleElementMap.length) {
            throw new RSIllegalArgumentException("Illegal sub-element index");
        }
        return this.mElements[this.mVisibleElementMap[i]];
    }

    public int getSubElementArraySize(int i) {
        if (this.mVisibleElementMap == null) {
            throw new RSIllegalArgumentException("Element contains no sub-elements");
        }
        if (i < 0 || i >= this.mVisibleElementMap.length) {
            throw new RSIllegalArgumentException("Illegal sub-element index");
        }
        return this.mArraySizes[this.mVisibleElementMap[i]];
    }

    public int getSubElementCount() {
        if (this.mVisibleElementMap == null) {
            return 0;
        }
        return this.mVisibleElementMap.length;
    }

    public String getSubElementName(int i) {
        if (this.mVisibleElementMap == null) {
            throw new RSIllegalArgumentException("Element contains no sub-elements");
        }
        if (i < 0 || i >= this.mVisibleElementMap.length) {
            throw new RSIllegalArgumentException("Illegal sub-element index");
        }
        return this.mElementNames[this.mVisibleElementMap[i]];
    }

    public int getSubElementOffsetBytes(int i) {
        if (this.mVisibleElementMap == null) {
            throw new RSIllegalArgumentException("Element contains no sub-elements");
        }
        if (i < 0 || i >= this.mVisibleElementMap.length) {
            throw new RSIllegalArgumentException("Illegal sub-element index");
        }
        return this.mOffsetInBytes[this.mVisibleElementMap[i]];
    }

    public int getVectorSize() {
        return this.mVectorSize;
    }

    public boolean isCompatible(Element element) {
        if (equals(element)) {
            return true;
        }
        return this.mSize == element.mSize && this.mType != DataType.NONE && this.mType == element.mType && this.mVectorSize == element.mVectorSize;
    }

    public boolean isComplex() {
        if (this.mElements == null) {
            return false;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.mElements.length) {
                return false;
            }
            if (this.mElements[i2].mElements != null) {
                return true;
            }
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // android.renderscript.BaseObj
    public void updateFromNative() {
        super.updateFromNative();
        int[] iArr = new int[5];
        this.mRS.nElementGetNativeData(getID(this.mRS), iArr);
        this.mNormalized = iArr[2] == 1;
        this.mVectorSize = iArr[3];
        this.mSize = 0;
        DataType[] values = DataType.values();
        int length = values.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                break;
            }
            DataType dataType = values[i2];
            if (dataType.mID == iArr[0]) {
                this.mType = dataType;
                this.mSize = this.mType.mSize * this.mVectorSize;
            }
            i = i2 + 1;
        }
        DataKind[] values2 = DataKind.values();
        int length2 = values2.length;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= length2) {
                break;
            }
            DataKind dataKind = values2[i4];
            if (dataKind.mID == iArr[1]) {
                this.mKind = dataKind;
            }
            i3 = i4 + 1;
        }
        int i5 = iArr[4];
        if (i5 > 0) {
            this.mElements = new Element[i5];
            this.mElementNames = new String[i5];
            this.mArraySizes = new int[i5];
            this.mOffsetInBytes = new int[i5];
            long[] jArr = new long[i5];
            this.mRS.nElementGetSubElements(getID(this.mRS), jArr, this.mElementNames, this.mArraySizes);
            int i6 = 0;
            while (true) {
                int i7 = i6;
                if (i7 >= i5) {
                    break;
                }
                this.mElements[i7] = new Element(jArr[i7], this.mRS);
                this.mElements[i7].updateFromNative();
                this.mOffsetInBytes[i7] = this.mSize;
                this.mSize += this.mElements[i7].mSize * this.mArraySizes[i7];
                i6 = i7 + 1;
            }
        }
        updateVisibleSubElements();
    }
}
