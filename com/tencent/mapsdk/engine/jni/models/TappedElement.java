package com.tencent.mapsdk.engine.jni.models;

import com.tencent.mapsdk.internal.gc;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/engine/jni/models/TappedElement.class */
public class TappedElement {
    private static final int BUILDING_ID_LENGTH = 128;
    private static final int BUILDING_NAME_LENGTH = 68;
    private static final int FLOOR_NAME_LENGTH = 32;
    private static final int POI_ID_LENGTH = 64;
    public static final int TYPE_ANNO = 1;
    public static final int TYPE_ANNO_INDOOR_MAP = 1;
    public static final int TYPE_BLOCKROUTE_ANNO = 7;
    public static final int TYPE_COMPASS = 3;
    public static final int TYPE_INDOORMAP_AREA = 8;
    public static final int TYPE_LINE = 5;
    public static final int TYPE_LOCATION_MARKER = 6;
    public static final int TYPE_NONE = 0;
    public static final int TYPE_OVERLAY_ITEM = 4;
    public String buildingId;
    public String buildingName;
    public String floorName;
    public long itemId;
    public int itemType;
    public String name;
    public int nameLen;
    public int pixelX;
    public int pixelY;
    public String poiId;
    public int type;

    private TappedElement() {
    }

    public static TappedElement fromBytes(byte[] bArr) {
        TappedElement tappedElement = new TappedElement();
        byte[] bArr2 = new byte[4];
        System.arraycopy(bArr, 0, bArr2, 0, 4);
        tappedElement.type = gc.e(bArr2);
        System.arraycopy(bArr, 4, bArr2, 0, 4);
        tappedElement.pixelX = gc.e(bArr2);
        System.arraycopy(bArr, 8, bArr2, 0, 4);
        tappedElement.pixelY = gc.e(bArr2);
        System.arraycopy(bArr, 12, bArr2, 0, 4);
        tappedElement.itemType = gc.e(bArr2);
        System.arraycopy(bArr, 16, bArr2, 0, 4);
        tappedElement.nameLen = gc.e(bArr2);
        int i = 20;
        if (tappedElement.type != 7) {
            byte[] bArr3 = new byte[64];
            System.arraycopy(bArr, 20, bArr3, 0, 64);
            i = 84;
            if (tappedElement.type != 8) {
                tappedElement.name = gc.g(bArr3);
            } else {
                tappedElement.name = gc.a(bArr3, "UTF-8");
            }
        }
        System.arraycopy(bArr, i, bArr2, 0, 4);
        int e = gc.e(bArr2);
        int i2 = i + 4;
        System.arraycopy(bArr, i2, bArr2, 0, 4);
        tappedElement.itemId = (e << 32) + gc.e(bArr2);
        int i3 = i2 + 4;
        byte[] bArr4 = new byte[64];
        System.arraycopy(bArr, i3, bArr4, 0, 64);
        tappedElement.poiId = String.valueOf(gc.a(bArr4, "UTF-8"));
        int i4 = i3 + 64;
        if (tappedElement.itemType == 1) {
            byte[] bArr5 = new byte[128];
            System.arraycopy(bArr, i4, bArr5, 0, 128);
            int i5 = i4 + 128;
            tappedElement.buildingId = gc.a(bArr5, "UTF-8");
            byte[] bArr6 = new byte[68];
            System.arraycopy(bArr, i5, bArr6, 0, 68);
            tappedElement.buildingName = gc.g(bArr6);
            byte[] bArr7 = new byte[32];
            System.arraycopy(bArr, i5 + 68, bArr7, 0, 32);
            tappedElement.floorName = gc.a(bArr7, "UTF-8");
        }
        return tappedElement;
    }
}
