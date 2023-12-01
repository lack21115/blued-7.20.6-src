package com.tencent.tencentmap.mapsdk.maps.model;

import org.apache.commons.codec.CharEncoding;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tencentmap/mapsdk/maps/model/MapRouteSection.class */
public class MapRouteSection {
    public static final int kMaxRoadNameLength = 32;
    public int color;
    public int endNum;
    public String roadName;
    public int startNum;

    public static int byteLength() {
        return 140;
    }

    private byte[] intToBytes(int i) {
        return new byte[]{(byte) i, (byte) (i >> 8), (byte) (i >> 16), (byte) (i >> 24)};
    }

    private byte[] stringToBytes(String str) {
        if (str != null) {
            try {
                return str.getBytes(CharEncoding.UTF_16LE);
            } catch (Exception e) {
            }
        }
        return new byte[0];
    }

    public byte[] toBytes() {
        byte[] bArr = new byte[byteLength()];
        System.arraycopy((Object) intToBytes(this.startNum), 0, (Object) bArr, 0, 4);
        System.arraycopy((Object) intToBytes(this.endNum), 0, (Object) bArr, 4, 4);
        System.arraycopy((Object) intToBytes(this.color), 0, (Object) bArr, 8, 4);
        byte[] stringToBytes = stringToBytes(this.roadName);
        if (stringToBytes.length < 32) {
            System.arraycopy((Object) stringToBytes, 0, (Object) bArr, 12, stringToBytes.length);
            return bArr;
        }
        System.arraycopy((Object) stringToBytes, 0, (Object) bArr, 12, 32);
        return bArr;
    }
}
