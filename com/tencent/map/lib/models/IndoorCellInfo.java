package com.tencent.map.lib.models;

import android.text.TextUtils;
import com.igexin.push.core.b;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/map/lib/models/IndoorCellInfo.class */
public final class IndoorCellInfo {
    private List<String> areaIds = new ArrayList();
    private Style style;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/map/lib/models/IndoorCellInfo$Style.class */
    public static class Style {
        private int color;

        public Style(int i) {
            this.color = i;
        }

        public int getColor() {
            return this.color;
        }

        public void setColor(int i) {
            this.color = i;
        }

        public String toString() {
            return "Style{color=" + Integer.toHexString(this.color) + '}';
        }
    }

    public IndoorCellInfo(Style style) {
        this.style = style;
    }

    public void addAreaId(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.areaIds.add(str);
    }

    public List<String> getAreaIds() {
        return this.areaIds;
    }

    public Style getStyle() {
        return this.style;
    }

    public void setStyle(Style style) {
        this.style = style;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("IndoorCellInfo{areaIds=");
        sb.append(this.areaIds);
        sb.append(", style=");
        Style style = this.style;
        sb.append(style != null ? style.toString() : b.l);
        sb.append('}');
        return sb.toString();
    }
}
