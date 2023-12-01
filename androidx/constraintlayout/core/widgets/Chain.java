package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.LinearSystem;
import java.util.ArrayList;

/* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/core/widgets/Chain.class */
public class Chain {
    public static final boolean USE_CHAIN_OPTIMIZATION = false;

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0087, code lost:
        if (r0.G == 2) goto L362;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00be, code lost:
        if (r0.H == 2) goto L362;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00c1, code lost:
        r24 = true;
        r20 = r18;
        r21 = r19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00cf, code lost:
        r24 = false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static void a(androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r10, androidx.constraintlayout.core.LinearSystem r11, int r12, int r13, androidx.constraintlayout.core.widgets.ChainHead r14) {
        /*
            Method dump skipped, instructions count: 2652
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.Chain.a(androidx.constraintlayout.core.widgets.ConstraintWidgetContainer, androidx.constraintlayout.core.LinearSystem, int, int, androidx.constraintlayout.core.widgets.ChainHead):void");
    }

    public static void applyChainConstraints(ConstraintWidgetContainer constraintWidgetContainer, LinearSystem linearSystem, ArrayList<ConstraintWidget> arrayList, int i) {
        int i2;
        ChainHead[] chainHeadArr;
        int i3;
        if (i == 0) {
            i2 = constraintWidgetContainer.mHorizontalChainsSize;
            chainHeadArr = constraintWidgetContainer.V;
            i3 = 0;
        } else {
            i2 = constraintWidgetContainer.mVerticalChainsSize;
            chainHeadArr = constraintWidgetContainer.U;
            i3 = 2;
        }
        for (int i4 = 0; i4 < i2; i4++) {
            ChainHead chainHead = chainHeadArr[i4];
            chainHead.define();
            if (arrayList == null || (arrayList != null && arrayList.contains(chainHead.f2113a))) {
                a(constraintWidgetContainer, linearSystem, i, i3, chainHead);
            }
        }
    }
}
