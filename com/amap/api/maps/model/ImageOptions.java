package com.amap.api.maps.model;

/* loaded from: source-6737240-dex2jar.jar:com/amap/api/maps/model/ImageOptions.class */
public class ImageOptions {
    public int color;
    public float radius;
    public int type;

    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/maps/model/ImageOptions$ShapeType.class */
    public enum ShapeType {
        CIRCLE;
        
        private int index = 0;

        /* JADX WARN: Incorrect types in method signature: (I)V */
        ShapeType(String str) {
        }

        public final int value() {
            return this.index;
        }
    }
}
