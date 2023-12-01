package com.tencent.ugc.videoprocessor.videoeffect.filter;

import android.opengl.GLES20;
import com.tencent.liteav.videobase.frame.d;
import com.tencent.ugc.videoprocessor.videoeffect.TXCGPUEffectFilterBase;
import java.nio.FloatBuffer;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/videoprocessor/videoeffect/filter/TXCGPUSplitScreenFilter.class */
public class TXCGPUSplitScreenFilter extends TXCGPUEffectFilterBase {
    private static final int DURATION_SPLIT_SCREEN = 1000;
    private SplitSceenParam mSplitScreenParam;
    private int mSpliteNumber = 0;
    private final int[] mSupportSplitNumber = {1, 4, 9};
    private a[] mSubWindowPosition = null;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/videoprocessor/videoeffect/filter/TXCGPUSplitScreenFilter$SplitSceenParam.class */
    public static class SplitSceenParam extends TXCGPUEffectFilterBase.VideoEffectParams {
        public int splitScreenNumber;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/videoprocessor/videoeffect/filter/TXCGPUSplitScreenFilter$a.class */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        int f26769a;
        public int b;

        /* renamed from: c  reason: collision with root package name */
        public int f26770c;
        public int d;

        private a() {
            this.f26769a = 0;
            this.b = 0;
            this.f26770c = 0;
            this.d = 0;
        }

        /* synthetic */ a(byte b) {
            this();
        }
    }

    private void updateParams(SplitSceenParam splitSceenParam) {
        if (splitSceenParam.splitScreenNumber == this.mSpliteNumber) {
            return;
        }
        if (splitSceenParam.splitScreenNumber != this.mSupportSplitNumber[0] && splitSceenParam.splitScreenNumber != this.mSupportSplitNumber[1] && splitSceenParam.splitScreenNumber != this.mSupportSplitNumber[2]) {
            return;
        }
        int i = splitSceenParam.splitScreenNumber;
        this.mSpliteNumber = i;
        this.mSubWindowPosition = new a[i];
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.mSpliteNumber) {
                break;
            }
            this.mSubWindowPosition[i3] = new a((byte) 0);
            i2 = i3 + 1;
        }
        int i4 = getOutputSize().f22649a;
        int i5 = getOutputSize().b;
        if (splitSceenParam.splitScreenNumber == this.mSupportSplitNumber[0]) {
            this.mSubWindowPosition[0].f26769a = 0;
            this.mSubWindowPosition[0].b = 0;
            this.mSubWindowPosition[0].f26770c = i4;
            this.mSubWindowPosition[0].d = i5;
        } else if (splitSceenParam.splitScreenNumber == this.mSupportSplitNumber[1]) {
            int i6 = 0;
            while (true) {
                int i7 = i6;
                if (i7 >= this.mSupportSplitNumber[1]) {
                    return;
                }
                this.mSubWindowPosition[i7].f26769a = ((i7 % 2) * i4) / 2;
                this.mSubWindowPosition[i7].b = ((i7 / 2) * i5) / 2;
                this.mSubWindowPosition[i7].f26770c = i4 / 2;
                this.mSubWindowPosition[i7].d = i5 / 2;
                i6 = i7 + 1;
            }
        } else if (splitSceenParam.splitScreenNumber != this.mSupportSplitNumber[2]) {
        } else {
            int i8 = 0;
            while (true) {
                int i9 = i8;
                if (i9 >= this.mSupportSplitNumber[2]) {
                    return;
                }
                this.mSubWindowPosition[i9].f26769a = ((i9 % 3) * i4) / 3;
                this.mSubWindowPosition[i9].b = ((i9 / 3) * i5) / 3;
                this.mSubWindowPosition[i9].f26770c = i4 / 3;
                this.mSubWindowPosition[i9].d = i5 / 3;
                i8 = i9 + 1;
            }
        }
    }

    @Override // com.tencent.liteav.videobase.a.b
    public void onDraw(int i, d dVar, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        if (this.mSubWindowPosition == null) {
            super.onDraw(i, dVar, floatBuffer, floatBuffer2);
        }
        a[] aVarArr = this.mSubWindowPosition;
        int length = aVarArr.length;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= length) {
                GLES20.glViewport(0, 0, getOutputSize().f22649a, getOutputSize().b);
                return;
            }
            a aVar = aVarArr[i3];
            if (aVar != null) {
                GLES20.glViewport(aVar.f26769a, aVar.b, aVar.f26770c, aVar.d);
            }
            super.onDraw(i, dVar, floatBuffer, floatBuffer2);
            i2 = i3 + 1;
        }
    }

    @Override // com.tencent.ugc.videoprocessor.videoeffect.TXCGPUEffectFilterBase
    public void setNextFrameTimestamp(long j) {
        super.setNextFrameTimestamp(j);
        if (this.mSplitScreenParam == null) {
            this.mSplitScreenParam = new SplitSceenParam();
        }
        long abs = Math.abs(j - this.mEffectStartTime);
        if (abs <= 1000) {
            this.mSplitScreenParam.splitScreenNumber = 4;
        } else if (abs <= 2000) {
            this.mSplitScreenParam.splitScreenNumber = 9;
        } else {
            this.mEffectStartTime = -1L;
        }
        updateParams(this.mSplitScreenParam);
    }
}
