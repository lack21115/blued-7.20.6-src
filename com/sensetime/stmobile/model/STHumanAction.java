package com.sensetime.stmobile.model;

import com.sensetime.stmobile.STMobileHumanActionNative;

/* loaded from: source-8303388-dex2jar.jar:com/sensetime/stmobile/model/STHumanAction.class */
public class STHumanAction {
    int bodyCount;
    STMobileBodyInfo[] bodys;
    int bufIndex;
    int faceCount;
    STMobileFaceInfo[] faces;
    int handCount;
    STMobileHandInfo[] hands;
    public int headCount;
    public STMobileHeadInfo[] heads;
    STHumanActionSegments humanActionSegments;

    public static native STHumanAction humanActionMirror(int i, STHumanAction sTHumanAction);

    public static native STHumanAction humanActionResize(float f, STHumanAction sTHumanAction);

    public static native STHumanAction humanActionRotate(int i, int i2, int i3, boolean z, STHumanAction sTHumanAction);

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0024, code lost:
        if (r11 == 2) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x008e, code lost:
        if (r11 == 3) goto L37;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.sensetime.stmobile.model.STHumanAction humanActionRotateAndMirror(com.sensetime.stmobile.model.STHumanAction r6, int r7, int r8, int r9, int r10, int r11) {
        /*
            r0 = r6
            if (r0 != 0) goto L6
            r0 = 0
            return r0
        L6:
            r0 = r9
            r1 = 1
            if (r0 == r1) goto L11
            r0 = r9
            if (r0 == 0) goto L11
            r0 = r6
            return r0
        L11:
            r0 = r6
            r12 = r0
            r0 = r9
            r1 = 1
            if (r0 != r1) goto L36
            r0 = r11
            if (r0 == 0) goto L27
            r0 = r6
            r12 = r0
            r0 = r11
            r1 = 2
            if (r0 != r1) goto L36
        L27:
            r0 = r6
            r12 = r0
            r0 = r9
            r1 = 1
            if (r0 != r1) goto L36
            r0 = r8
            r1 = r6
            com.sensetime.stmobile.model.STHumanAction r0 = humanActionMirror(r0, r1)
            r12 = r0
        L36:
            r0 = r10
            r1 = 90
            if (r0 == r1) goto L70
            r0 = r10
            r1 = 270(0x10e, float:3.78E-43)
            if (r0 == r1) goto L48
            r0 = r12
            return r0
        L48:
            r0 = r11
            if (r0 == 0) goto L63
            r0 = r11
            r1 = 2
            if (r0 != r1) goto L56
            goto L63
        L56:
            r0 = r8
            r1 = r7
            r2 = 3
            r3 = 0
            r4 = r12
            com.sensetime.stmobile.model.STHumanAction r0 = humanActionRotate(r0, r1, r2, r3, r4)
            r6 = r0
            goto L7a
        L63:
            r0 = r8
            r1 = r7
            r2 = 1
            r3 = 0
            r4 = r12
            com.sensetime.stmobile.model.STHumanAction r0 = humanActionRotate(r0, r1, r2, r3, r4)
            r6 = r0
            goto L7a
        L70:
            r0 = r8
            r1 = r7
            r2 = 1
            r3 = 0
            r4 = r12
            com.sensetime.stmobile.model.STHumanAction r0 = humanActionRotate(r0, r1, r2, r3, r4)
            r6 = r0
        L7a:
            r0 = r6
            r12 = r0
            r0 = r9
            r1 = 1
            if (r0 != r1) goto L98
            r0 = r11
            r1 = 1
            if (r0 == r1) goto L91
            r0 = r6
            r12 = r0
            r0 = r11
            r1 = 3
            if (r0 != r1) goto L98
        L91:
            r0 = r7
            r1 = r6
            com.sensetime.stmobile.model.STHumanAction r0 = humanActionMirror(r0, r1)
            r12 = r0
        L98:
            r0 = r12
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sensetime.stmobile.model.STHumanAction.humanActionRotateAndMirror(com.sensetime.stmobile.model.STHumanAction, int, int, int, int, int):com.sensetime.stmobile.model.STHumanAction");
    }

    public static void nativeHumanActionRotateAndMirror(STMobileHumanActionNative sTMobileHumanActionNative, long j, int i, int i2, int i3, int i4, int i5) {
        if (i3 == 1 || i3 == 0) {
            if (i3 == 1 && ((i5 == 0 || i5 == 2) && i3 == 1)) {
                sTMobileHumanActionNative.nativeHumanActionMirrorPtr(i2);
            }
            if (i4 == 90) {
                sTMobileHumanActionNative.nativeHumanActionRotatePtr(i2, i, 1, false);
            } else if (i4 != 270) {
                return;
            } else {
                if (i5 == 0 || i5 == 2) {
                    sTMobileHumanActionNative.nativeHumanActionRotatePtr(i2, i, 1, false);
                } else {
                    sTMobileHumanActionNative.nativeHumanActionRotatePtr(i2, i, 3, false);
                }
            }
            if (i3 == 1) {
                if (i5 == 1 || i5 == 3) {
                    sTMobileHumanActionNative.nativeHumanActionMirrorPtr(i);
                }
            }
        }
    }

    public int getBodyCount() {
        return this.bodyCount;
    }

    public STMobileBodyInfo[] getBodys() {
        return this.bodys;
    }

    public int getBufIndex() {
        return this.bufIndex;
    }

    public int getFaceCount() {
        return this.faceCount;
    }

    public STMobileFaceInfo[] getFaceInfos() {
        if (this.faceCount == 0) {
            return null;
        }
        return this.faces;
    }

    public STMobileFaceInfo[] getFaces() {
        return this.faces;
    }

    public int getHandCount() {
        return this.handCount;
    }

    public STMobileHandInfo[] getHandInfos() {
        if (this.handCount == 0) {
            return null;
        }
        return this.hands;
    }

    public STMobileHandInfo[] getHands() {
        return this.hands;
    }

    public int getHeadCount() {
        return this.headCount;
    }

    public STMobileHeadInfo[] getHeads() {
        return this.heads;
    }

    public STHumanActionSegments getHumanActionSegments() {
        return this.humanActionSegments;
    }

    public STMobile106[] getMobileFaces() {
        int i = this.faceCount;
        if (i == 0) {
            return null;
        }
        STMobile106[] sTMobile106Arr = new STMobile106[i];
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.faceCount) {
                return sTMobile106Arr;
            }
            sTMobile106Arr[i3] = this.faces[i3].face106;
            i2 = i3 + 1;
        }
    }

    public boolean replaceMobile106(STMobile106[] sTMobile106Arr) {
        if (sTMobile106Arr == null || sTMobile106Arr.length == 0 || this.faces == null || this.faceCount != sTMobile106Arr.length) {
            return false;
        }
        for (int i = 0; i < sTMobile106Arr.length; i++) {
            this.faces[i].face106 = sTMobile106Arr[i];
        }
        return true;
    }

    public void setBodyCount(int i) {
        this.bodyCount = i;
    }

    public void setBodys(STMobileBodyInfo[] sTMobileBodyInfoArr) {
        this.bodys = sTMobileBodyInfoArr;
    }

    public void setBufIndex(int i) {
        this.bufIndex = i;
    }

    public void setFaceCount(int i) {
        this.faceCount = i;
    }

    public void setFaces(STMobileFaceInfo[] sTMobileFaceInfoArr) {
        this.faces = sTMobileFaceInfoArr;
    }

    public void setHandCount(int i) {
        this.handCount = i;
    }

    public void setHands(STMobileHandInfo[] sTMobileHandInfoArr) {
        this.hands = sTMobileHandInfoArr;
    }

    public void setHeadCount(int i) {
        this.headCount = i;
    }

    public void setHeads(STMobileHeadInfo[] sTMobileHeadInfoArr) {
        this.heads = sTMobileHeadInfoArr;
    }

    public void setHumanActionSegments(STHumanActionSegments sTHumanActionSegments) {
        this.humanActionSegments = sTHumanActionSegments;
    }
}
