package com.huawei.hms.ads;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/fg.class */
public class fg {
    private static final float[] V;
    private static final FloatBuffer Z;
    private static final float[] I = {0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f};
    private static final FloatBuffer B = Code(I);
    private final FloatBuffer C = Z;
    private final FloatBuffer S = B;
    private final int F = 2;
    private final int D = V.length / 2;

    static {
        float[] fArr = {-0.5f, -0.5f, 0.5f, -0.5f, -0.5f, 0.5f, 0.5f, 0.5f};
        V = fArr;
        Z = Code(fArr);
    }

    private static FloatBuffer Code(float[] fArr) {
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(fArr.length * 4);
        allocateDirect.order(ByteOrder.nativeOrder());
        FloatBuffer asFloatBuffer = allocateDirect.asFloatBuffer();
        asFloatBuffer.put(fArr);
        asFloatBuffer.position(0);
        return asFloatBuffer;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int B() {
        return 8;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int C() {
        return 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FloatBuffer Code() {
        return this.C;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int I() {
        return this.D;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FloatBuffer V() {
        return this.S;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int Z() {
        return 8;
    }
}
