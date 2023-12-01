package com.amap.api.maps.model;

import java.util.ArrayList;
import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:com/amap/api/maps/model/GL3DModelOptions.class */
public class GL3DModelOptions extends BaseOptions {
    private BitmapDescriptor bitmapDescriptor;
    private LatLng latLng;
    private String modelData;
    private float rotate;
    private String snippet;
    private String title;
    private List<Float> vertextList = new ArrayList();
    private List<Float> textrueList = new ArrayList();
    private boolean isModeltUpdate = false;
    private int fixedLength = 50;
    private boolean visibile = true;

    public GL3DModelOptions() {
        this.type = "GL3DModelOptions";
    }

    public GL3DModelOptions angle(float f) {
        this.rotate = f;
        return this;
    }

    public float getAngle() {
        return this.rotate;
    }

    public BitmapDescriptor getBitmapDescriptor() {
        return this.bitmapDescriptor;
    }

    public LatLng getLatLng() {
        return this.latLng;
    }

    public int getModelFixedLength() {
        return this.fixedLength;
    }

    public String getSnippet() {
        return this.snippet;
    }

    public List<Float> getTextrue() {
        return this.textrueList;
    }

    public String getTitle() {
        return this.title;
    }

    public List<Float> getVertext() {
        return this.vertextList;
    }

    public boolean isVisible() {
        return this.visibile;
    }

    public GL3DModelOptions position(LatLng latLng) {
        this.latLng = latLng;
        return this;
    }

    public GL3DModelOptions setModelFixedLength(int i) {
        this.fixedLength = i;
        return this;
    }

    public GL3DModelOptions setVisible(boolean z) {
        this.visibile = z;
        return this;
    }

    public GL3DModelOptions snippet(String str) {
        this.snippet = str;
        return this;
    }

    public GL3DModelOptions textureDrawable(BitmapDescriptor bitmapDescriptor) {
        this.bitmapDescriptor = bitmapDescriptor;
        return this;
    }

    public GL3DModelOptions title(String str) {
        this.title = str;
        return this;
    }

    public GL3DModelOptions vertexData(String str) {
        if (str != null && str.length() > 0) {
            this.modelData = str;
            this.isModeltUpdate = true;
        }
        return this;
    }

    public GL3DModelOptions vertexData(List<Float> list, List<Float> list2) {
        this.vertextList = list;
        this.textrueList = list2;
        StringBuilder sb = new StringBuilder();
        if (this.vertextList != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.vertextList.size() - 3) {
                    break;
                }
                sb.append("v ");
                sb.append(this.vertextList.get(i2));
                sb.append(" ");
                sb.append(this.vertextList.get(i2 + 1));
                sb.append(" ");
                sb.append(this.vertextList.get(i2 + 2));
                sb.append("\n");
                i = i2 + 3;
            }
        }
        if (this.textrueList != null) {
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= this.textrueList.size() - 2) {
                    break;
                }
                sb.append("vt ");
                sb.append(this.textrueList.get(i4));
                sb.append(" ");
                sb.append(1.0f - this.textrueList.get(i4 + 1).floatValue());
                sb.append("\n");
                i3 = i4 + 2;
            }
        }
        vertexData(sb.toString());
        return this;
    }
}
