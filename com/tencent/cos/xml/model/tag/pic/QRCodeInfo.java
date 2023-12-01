package com.tencent.cos.xml.model.tag.pic;

import android.graphics.Point;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/pic/QRCodeInfo.class */
public class QRCodeInfo {
    public List<QRCodePoint> codeLocation;
    public String codeUrl;

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/pic/QRCodeInfo$QRCodePoint.class */
    public static class QRCodePoint {
        public String point;

        public Point point() {
            String[] split = this.point.split(",");
            if (split.length == 2) {
                return new Point(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
            }
            return null;
        }
    }
}
