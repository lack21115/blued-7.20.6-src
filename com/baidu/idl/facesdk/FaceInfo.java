package com.baidu.idl.facesdk;

/* loaded from: source-8756600-dex2jar.jar:com/baidu/idl/facesdk/FaceInfo.class */
public class FaceInfo {
    public int face_id;
    public float[] headPose;
    public int[] is_live;
    public int[] landmarks;
    public int mAngle;
    public int mCenter_x;
    public int mCenter_y;
    public float mConf;
    public int mWidth;

    public FaceInfo(int i, int i2, int i3, int i4, float f) {
        this.mWidth = i;
        this.mAngle = i2;
        this.mCenter_y = i3;
        this.mCenter_x = i4;
        this.mConf = f;
        this.landmarks = null;
        this.face_id = 0;
    }

    public FaceInfo(int i, int i2, int i3, int i4, float f, int i5, int[] iArr) {
        this.mWidth = i;
        this.mAngle = i2;
        this.mCenter_y = i3;
        this.mCenter_x = i4;
        this.mConf = f;
        this.landmarks = iArr;
        this.face_id = i5;
    }

    public FaceInfo(int i, int i2, int i3, int i4, float f, int i5, int[] iArr, float[] fArr, int[] iArr2) {
        this.mWidth = i;
        this.mAngle = i2;
        this.mCenter_y = i3;
        this.mCenter_x = i4;
        this.mConf = f;
        this.landmarks = iArr;
        this.face_id = i5;
        this.headPose = fArr;
        this.is_live = iArr2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x008d, code lost:
        if (r10.length == 0) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void getRectPoints(int[] r10) {
        /*
            Method dump skipped, instructions count: 305
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.idl.facesdk.FaceInfo.getRectPoints(int[]):void");
    }

    public int get_leftEyeState() {
        int[] iArr = this.is_live;
        if (iArr == null || iArr.length != 11) {
            return 0;
        }
        return iArr[1];
    }

    public int get_mouthState() {
        int[] iArr = this.is_live;
        if (iArr == null || iArr.length != 11) {
            return 0;
        }
        return iArr[4];
    }

    public int get_rightEyeState() {
        int[] iArr = this.is_live;
        if (iArr == null || iArr.length != 11) {
            return 0;
        }
        return iArr[2];
    }

    public boolean is_live() {
        int[] iArr = this.is_live;
        boolean z = false;
        if (iArr != null) {
            if (iArr.length != 11) {
                return false;
            }
            z = false;
            if (1 == iArr[0]) {
                z = true;
            }
        }
        return z;
    }

    public boolean is_live_head_down() {
        int[] iArr = this.is_live;
        boolean z = false;
        if (iArr != null) {
            if (iArr.length != 11) {
                return false;
            }
            z = false;
            if (1 == iArr[9]) {
                z = true;
            }
        }
        return z;
    }

    public boolean is_live_head_turn_left() {
        int[] iArr = this.is_live;
        boolean z = false;
        if (iArr != null) {
            if (iArr.length != 11) {
                return false;
            }
            z = false;
            if (1 == iArr[5]) {
                z = true;
            }
        }
        return z;
    }

    public boolean is_live_head_turn_right() {
        int[] iArr = this.is_live;
        boolean z = false;
        if (iArr != null) {
            if (iArr.length != 11) {
                return false;
            }
            z = false;
            if (1 == iArr[6]) {
                z = true;
            }
        }
        return z;
    }

    public boolean is_live_head_up() {
        int[] iArr = this.is_live;
        boolean z = false;
        if (iArr != null) {
            if (iArr.length != 11) {
                return false;
            }
            z = false;
            if (1 == iArr[8]) {
                z = true;
            }
        }
        return z;
    }

    public boolean is_live_mouth() {
        int[] iArr = this.is_live;
        boolean z = false;
        if (iArr != null) {
            if (iArr.length != 11) {
                return false;
            }
            z = false;
            if (1 == iArr[3]) {
                z = true;
            }
        }
        return z;
    }
}
