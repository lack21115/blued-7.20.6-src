package com.tencent.youtu.ytagreflectlivecheck.jni.model;

import android.util.Base64;
import com.tencent.cloud.huiyansdkface.facelight.b.a.a;
import java.util.ArrayList;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/youtu/ytagreflectlivecheck/jni/model/YTImageInfo.class */
public class YTImageInfo {
    public String checksum;
    public ArrayList<Float> five_points = new ArrayList<>();
    public String image;

    public YTImageInfo(a aVar) {
        this.image = new String(Base64.encode(aVar.f21842a, 2));
        this.checksum = aVar.f21843c;
        if (aVar.b != null) {
            this.five_points.add(Float.valueOf(aVar.b[176]));
            this.five_points.add(Float.valueOf(aVar.b[177]));
            this.five_points.add(Float.valueOf(aVar.b[178]));
            this.five_points.add(Float.valueOf(aVar.b[179]));
            this.five_points.add(Float.valueOf(aVar.b[64]));
            this.five_points.add(Float.valueOf(aVar.b[65]));
            this.five_points.add(Float.valueOf(aVar.b[90]));
            this.five_points.add(Float.valueOf(aVar.b[91]));
            this.five_points.add(Float.valueOf(aVar.b[102]));
            this.five_points.add(Float.valueOf(aVar.b[103]));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:57:0x00a9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0099 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void createFileWithByte(java.lang.String r5, byte[] r6) {
        /*
            Method dump skipped, instructions count: 183
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.youtu.ytagreflectlivecheck.jni.model.YTImageInfo.createFileWithByte(java.lang.String, byte[]):void");
    }

    public String toString() {
        return "YTImageInfo{image='" + this.image + "', five_points=" + this.five_points + ", checksum='" + this.checksum + "'}";
    }
}
