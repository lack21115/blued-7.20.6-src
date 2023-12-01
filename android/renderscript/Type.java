package android.renderscript;

import android.graphics.ImageFormat;

/* loaded from: source-9557208-dex2jar.jar:android/renderscript/Type.class */
public class Type extends BaseObj {
    boolean mDimFaces;
    boolean mDimMipmaps;
    int mDimX;
    int mDimY;
    int mDimYuv;
    int mDimZ;
    Element mElement;
    int mElementCount;

    /* loaded from: source-9557208-dex2jar.jar:android/renderscript/Type$Builder.class */
    public static class Builder {
        boolean mDimFaces;
        boolean mDimMipmaps;
        int mDimX = 1;
        int mDimY;
        int mDimZ;
        Element mElement;
        RenderScript mRS;
        int mYuv;

        public Builder(RenderScript renderScript, Element element) {
            element.checkValid();
            this.mRS = renderScript;
            this.mElement = element;
        }

        public Type create() {
            if (this.mDimZ > 0) {
                if (this.mDimX < 1 || this.mDimY < 1) {
                    throw new RSInvalidStateException("Both X and Y dimension required when Z is present.");
                }
                if (this.mDimFaces) {
                    throw new RSInvalidStateException("Cube maps not supported with 3D types.");
                }
            }
            if (this.mDimY <= 0 || this.mDimX >= 1) {
                if (!this.mDimFaces || this.mDimY >= 1) {
                    if (this.mYuv == 0 || !(this.mDimZ != 0 || this.mDimFaces || this.mDimMipmaps)) {
                        Type type = new Type(this.mRS.nTypeCreate(this.mElement.getID(this.mRS), this.mDimX, this.mDimY, this.mDimZ, this.mDimMipmaps, this.mDimFaces, this.mYuv), this.mRS);
                        type.mElement = this.mElement;
                        type.mDimX = this.mDimX;
                        type.mDimY = this.mDimY;
                        type.mDimZ = this.mDimZ;
                        type.mDimMipmaps = this.mDimMipmaps;
                        type.mDimFaces = this.mDimFaces;
                        type.mDimYuv = this.mYuv;
                        type.calcElementCount();
                        return type;
                    }
                    throw new RSInvalidStateException("YUV only supports basic 2D.");
                }
                throw new RSInvalidStateException("Cube maps require 2D Types.");
            }
            throw new RSInvalidStateException("X dimension required when Y is present.");
        }

        public Builder setFaces(boolean z) {
            this.mDimFaces = z;
            return this;
        }

        public Builder setMipmaps(boolean z) {
            this.mDimMipmaps = z;
            return this;
        }

        public Builder setX(int i) {
            if (i < 1) {
                throw new RSIllegalArgumentException("Values of less than 1 for Dimension X are not valid.");
            }
            this.mDimX = i;
            return this;
        }

        public Builder setY(int i) {
            if (i < 1) {
                throw new RSIllegalArgumentException("Values of less than 1 for Dimension Y are not valid.");
            }
            this.mDimY = i;
            return this;
        }

        public Builder setYuvFormat(int i) {
            switch (i) {
                case 17:
                case 35:
                case ImageFormat.YV12 /* 842094169 */:
                    this.mYuv = i;
                    return this;
                default:
                    throw new RSIllegalArgumentException("Only ImageFormat.NV21, .YV12, and .YUV_420_888 are supported..");
            }
        }

        public Builder setZ(int i) {
            if (i < 1) {
                throw new RSIllegalArgumentException("Values of less than 1 for Dimension Z are not valid.");
            }
            this.mDimZ = i;
            return this;
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/renderscript/Type$CubemapFace.class */
    public enum CubemapFace {
        POSITIVE_X(0),
        NEGATIVE_X(1),
        POSITIVE_Y(2),
        NEGATIVE_Y(3),
        POSITIVE_Z(4),
        NEGATIVE_Z(5),
        POSITVE_X(0),
        POSITVE_Y(2),
        POSITVE_Z(4);
        
        int mID;

        CubemapFace(int i) {
            this.mID = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Type(long j, RenderScript renderScript) {
        super(j, renderScript);
    }

    public static Type createX(RenderScript renderScript, Element element, int i) {
        if (i < 1) {
            throw new RSInvalidStateException("Dimension must be >= 1.");
        }
        Type type = new Type(renderScript.nTypeCreate(element.getID(renderScript), i, 0, 0, false, false, 0), renderScript);
        type.mElement = element;
        type.mDimX = i;
        type.calcElementCount();
        return type;
    }

    public static Type createXY(RenderScript renderScript, Element element, int i, int i2) {
        if (i < 1 || i2 < 1) {
            throw new RSInvalidStateException("Dimension must be >= 1.");
        }
        Type type = new Type(renderScript.nTypeCreate(element.getID(renderScript), i, i2, 0, false, false, 0), renderScript);
        type.mElement = element;
        type.mDimX = i;
        type.mDimY = i2;
        type.calcElementCount();
        return type;
    }

    public static Type createXYZ(RenderScript renderScript, Element element, int i, int i2, int i3) {
        if (i < 1 || i2 < 1 || i3 < 1) {
            throw new RSInvalidStateException("Dimension must be >= 1.");
        }
        Type type = new Type(renderScript.nTypeCreate(element.getID(renderScript), i, i2, i3, false, false, 0), renderScript);
        type.mElement = element;
        type.mDimX = i;
        type.mDimY = i2;
        type.mDimZ = i3;
        type.calcElementCount();
        return type;
    }

    void calcElementCount() {
        boolean hasMipmaps = hasMipmaps();
        int x = getX();
        int y = getY();
        int z = getZ();
        int i = 1;
        if (hasFaces()) {
            i = 6;
        }
        int i2 = x;
        if (x == 0) {
            i2 = 1;
        }
        int i3 = y;
        if (y == 0) {
            i3 = 1;
        }
        int i4 = z;
        if (z == 0) {
            i4 = 1;
        }
        int i5 = i2;
        int i6 = i2 * i3 * i4 * i;
        while (hasMipmaps && (i5 > 1 || i3 > 1 || i4 > 1)) {
            int i7 = i5;
            if (i5 > 1) {
                i7 = i5 >> 1;
            }
            int i8 = i3;
            if (i3 > 1) {
                i8 = i3 >> 1;
            }
            int i9 = i4;
            if (i4 > 1) {
                i9 = i4 >> 1;
            }
            i6 += i7 * i8 * i9 * i;
            i5 = i7;
            i3 = i8;
            i4 = i9;
        }
        this.mElementCount = i6;
    }

    public int getCount() {
        return this.mElementCount;
    }

    public Element getElement() {
        return this.mElement;
    }

    public int getX() {
        return this.mDimX;
    }

    public int getY() {
        return this.mDimY;
    }

    public int getYuv() {
        return this.mDimYuv;
    }

    public int getZ() {
        return this.mDimZ;
    }

    public boolean hasFaces() {
        return this.mDimFaces;
    }

    public boolean hasMipmaps() {
        return this.mDimMipmaps;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // android.renderscript.BaseObj
    public void updateFromNative() {
        long[] jArr = new long[6];
        this.mRS.nTypeGetNativeData(getID(this.mRS), jArr);
        this.mDimX = (int) jArr[0];
        this.mDimY = (int) jArr[1];
        this.mDimZ = (int) jArr[2];
        this.mDimMipmaps = jArr[3] == 1;
        this.mDimFaces = jArr[4] == 1;
        long j = jArr[5];
        if (j != 0) {
            this.mElement = new Element(j, this.mRS);
            this.mElement.updateFromNative();
        }
        calcElementCount();
    }
}
