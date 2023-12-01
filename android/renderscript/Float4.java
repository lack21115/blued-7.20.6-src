package android.renderscript;

/* loaded from: source-9557208-dex2jar.jar:android/renderscript/Float4.class */
public class Float4 {
    public float w;
    public float x;
    public float y;
    public float z;

    public Float4() {
    }

    public Float4(float f, float f2, float f3, float f4) {
        this.x = f;
        this.y = f2;
        this.z = f3;
        this.w = f4;
    }

    public Float4(Float4 float4) {
        this.x = float4.x;
        this.y = float4.y;
        this.z = float4.z;
        this.w = float4.w;
    }

    public static Float4 add(Float4 float4, float f) {
        Float4 float42 = new Float4();
        float42.x = float4.x + f;
        float42.y = float4.y + f;
        float42.z = float4.z + f;
        float42.w = float4.w + f;
        return float42;
    }

    public static Float4 add(Float4 float4, Float4 float42) {
        Float4 float43 = new Float4();
        float43.x = float4.x + float42.x;
        float43.y = float4.y + float42.y;
        float43.z = float4.z + float42.z;
        float43.w = float4.w + float42.w;
        return float43;
    }

    public static Float4 div(Float4 float4, float f) {
        Float4 float42 = new Float4();
        float42.x = float4.x / f;
        float42.y = float4.y / f;
        float42.z = float4.z / f;
        float42.w = float4.w / f;
        return float42;
    }

    public static Float4 div(Float4 float4, Float4 float42) {
        Float4 float43 = new Float4();
        float43.x = float4.x / float42.x;
        float43.y = float4.y / float42.y;
        float43.z = float4.z / float42.z;
        float43.w = float4.w / float42.w;
        return float43;
    }

    public static float dotProduct(Float4 float4, Float4 float42) {
        return (float42.x * float4.x) + (float42.y * float4.y) + (float42.z * float4.z) + (float42.w * float4.w);
    }

    public static Float4 mul(Float4 float4, float f) {
        Float4 float42 = new Float4();
        float42.x = float4.x * f;
        float42.y = float4.y * f;
        float42.z = float4.z * f;
        float42.w = float4.w * f;
        return float42;
    }

    public static Float4 mul(Float4 float4, Float4 float42) {
        Float4 float43 = new Float4();
        float43.x = float4.x * float42.x;
        float43.y = float4.y * float42.y;
        float43.z = float4.z * float42.z;
        float43.w = float4.w * float42.w;
        return float43;
    }

    public static Float4 sub(Float4 float4, float f) {
        Float4 float42 = new Float4();
        float42.x = float4.x - f;
        float42.y = float4.y - f;
        float42.z = float4.z - f;
        float42.w = float4.w - f;
        return float42;
    }

    public static Float4 sub(Float4 float4, Float4 float42) {
        Float4 float43 = new Float4();
        float43.x = float4.x - float42.x;
        float43.y = float4.y - float42.y;
        float43.z = float4.z - float42.z;
        float43.w = float4.w - float42.w;
        return float43;
    }

    public void add(float f) {
        this.x += f;
        this.y += f;
        this.z += f;
        this.w += f;
    }

    public void add(Float4 float4) {
        this.x += float4.x;
        this.y += float4.y;
        this.z += float4.z;
        this.w += float4.w;
    }

    public void addAt(int i, float f) {
        switch (i) {
            case 0:
                this.x += f;
                return;
            case 1:
                this.y += f;
                return;
            case 2:
                this.z += f;
                return;
            case 3:
                this.w += f;
                return;
            default:
                throw new IndexOutOfBoundsException("Index: i");
        }
    }

    public void addMultiple(Float4 float4, float f) {
        this.x += float4.x * f;
        this.y += float4.y * f;
        this.z += float4.z * f;
        this.w += float4.w * f;
    }

    public void copyTo(float[] fArr, int i) {
        fArr[i] = this.x;
        fArr[i + 1] = this.y;
        fArr[i + 2] = this.z;
        fArr[i + 3] = this.w;
    }

    public void div(float f) {
        this.x /= f;
        this.y /= f;
        this.z /= f;
        this.w /= f;
    }

    public void div(Float4 float4) {
        this.x /= float4.x;
        this.y /= float4.y;
        this.z /= float4.z;
        this.w /= float4.w;
    }

    public float dotProduct(Float4 float4) {
        return (this.x * float4.x) + (this.y * float4.y) + (this.z * float4.z) + (this.w * float4.w);
    }

    public float elementSum() {
        return this.x + this.y + this.z + this.w;
    }

    public float get(int i) {
        switch (i) {
            case 0:
                return this.x;
            case 1:
                return this.y;
            case 2:
                return this.z;
            case 3:
                return this.w;
            default:
                throw new IndexOutOfBoundsException("Index: i");
        }
    }

    public int length() {
        return 4;
    }

    public void mul(float f) {
        this.x *= f;
        this.y *= f;
        this.z *= f;
        this.w *= f;
    }

    public void mul(Float4 float4) {
        this.x *= float4.x;
        this.y *= float4.y;
        this.z *= float4.z;
        this.w *= float4.w;
    }

    public void negate() {
        this.x = -this.x;
        this.y = -this.y;
        this.z = -this.z;
        this.w = -this.w;
    }

    public void set(Float4 float4) {
        this.x = float4.x;
        this.y = float4.y;
        this.z = float4.z;
        this.w = float4.w;
    }

    public void setAt(int i, float f) {
        switch (i) {
            case 0:
                this.x = f;
                return;
            case 1:
                this.y = f;
                return;
            case 2:
                this.z = f;
                return;
            case 3:
                this.w = f;
                return;
            default:
                throw new IndexOutOfBoundsException("Index: i");
        }
    }

    public void setValues(float f, float f2, float f3, float f4) {
        this.x = f;
        this.y = f2;
        this.z = f3;
        this.w = f4;
    }

    public void sub(float f) {
        this.x -= f;
        this.y -= f;
        this.z -= f;
        this.w -= f;
    }

    public void sub(Float4 float4) {
        this.x -= float4.x;
        this.y -= float4.y;
        this.z -= float4.z;
        this.w -= float4.w;
    }
}
