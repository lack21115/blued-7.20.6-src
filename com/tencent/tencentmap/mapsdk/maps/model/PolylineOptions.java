package com.tencent.tencentmap.mapsdk.maps.model;

import android.graphics.Color;
import android.os.Parcel;
import com.tencent.mapsdk.internal.t5;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tencentmap/mapsdk/maps/model/PolylineOptions.class */
public class PolylineOptions {
    private static final int LINE_DEFAULT_WIDTH = 9;
    private static final int LINE_UNINITIALIZED_WIDTH = -1;
    @Deprecated
    private static String sDefaultArrowTexture;
    private boolean boArraw;
    private float fBorderWidth;
    private Animation initAnimation;
    private boolean mGradientEnable;
    private IndoorInfo mIndoorInfo;
    private Text mText;
    private List<Integer> pattern;
    private static final int COLOR_DEFAULT_POLYLINE = Color.argb(200, 0, 163, 255);
    private static String sDefaultColorTexture = t5.M;
    private boolean boIsAbove = false;
    private int[] iColors = null;
    private int[] iBorderColors = {Color.GREEN};
    private int[] iIndexs = null;
    private int eraseColor = Color.GRAY;
    private int lineType = 0;
    private BitmapDescriptor mCustomeColorTexture = BitmapDescriptorFactory.fromAsset(sDefaultColorTexture);
    private boolean mAboveMaskLayer = false;
    private boolean mIsRoad = true;
    private BitmapDescriptor mArrowTexture = null;
    private boolean mClickable = true;
    private ColorType colorType = ColorType.LINE_COLOR_NONE;
    private int iLevel = 0;
    @Deprecated
    private String strCustomerTextName = sDefaultColorTexture;
    private int mArrowSpacing = 150;
    private float fwidth = -1.0f;
    private int iStrokeColor = COLOR_DEFAULT_POLYLINE;
    private boolean boVisible = true;
    private boolean boIsGeodes = false;
    private final List<LatLng> listLatLngs = new ArrayList();
    private float alpha = 1.0f;
    private boolean lineCap = true;
    private int fIndex = 0;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/tencentmap/mapsdk/maps/model/PolylineOptions$ColorType.class */
    public enum ColorType {
        LINE_COLOR_NONE,
        LINE_COLOR_TEXTURE,
        LINE_COLOR_ARGB
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/tencentmap/mapsdk/maps/model/PolylineOptions$Colors.class */
    public static final class Colors {
        public static final int DARK_BLUE = 6;
        public static final int DASHED = 33;
        public static final int GRAYBLUE = 8;
        public static final int GREEN = 4;
        public static final int GREY = 0;
        public static final int LAST_BLUE = 20;
        public static final int LIGHT_BLUE = 1;
        public static final int LIVER_RED = 9;
        public static final int MID_BLUE = 5;
        public static final int RED = 2;
        public static final int TRANSPARENT = 7;
        public static final int WHITE_BLUE = 19;
        public static final int YELLOW = 3;
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/tencentmap/mapsdk/maps/model/PolylineOptions$LineType.class */
    public static final class LineType {
        public static final int LINE_TYPE_DOTTEDLINE = 2;
        public static final int LINE_TYPE_IMAGEINARYLINE = 1;
        public static final int LINE_TYPE_MULTICOLORLINE = 0;
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/tencentmap/mapsdk/maps/model/PolylineOptions$SegmentText.class */
    public static final class SegmentText {
        private final int endIndex;
        private final int startIndex;
        private final String text;

        public SegmentText(int i, int i2, String str) {
            this.startIndex = i;
            this.endIndex = i2;
            this.text = str;
        }

        public int getEndIndex() {
            return this.endIndex;
        }

        public int getStartIndex() {
            return this.startIndex;
        }

        public String getText() {
            return this.text;
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/tencentmap/mapsdk/maps/model/PolylineOptions$Text.class */
    public static final class Text {
        private Builder mBuilder;
        private final List<SegmentText> mSegmentTexts;

        /* loaded from: source-8829756-dex2jar.jar:com/tencent/tencentmap/mapsdk/maps/model/PolylineOptions$Text$Builder.class */
        public static final class Builder {
            private List<SegmentText> mTexts = new ArrayList();
            private int textColor = -16777216;
            private int strokeColor = -1;
            private int textSize = 14;
            private TextPriority priority = TextPriority.HIGH;

            public Builder(SegmentText segmentText) {
                addSegmentText(segmentText);
            }

            public Builder(List<SegmentText> list) {
                addAllSegmentText(list);
            }

            public Builder addAllSegmentText(List<SegmentText> list) {
                this.mTexts.addAll(list);
                return this;
            }

            public Builder addSegmentText(SegmentText segmentText) {
                this.mTexts.add(segmentText);
                return this;
            }

            public Text build() {
                return new Text(this);
            }

            public Builder color(int i) {
                this.textColor = i;
                return this;
            }

            public Builder priority(TextPriority textPriority) {
                this.priority = textPriority;
                return this;
            }

            public Builder size(int i) {
                this.textSize = i;
                return this;
            }

            public Builder strokeColor(int i) {
                this.strokeColor = i;
                return this;
            }
        }

        private Text(Builder builder) {
            this.mSegmentTexts = Collections.unmodifiableList(builder.mTexts);
            this.mBuilder = builder;
        }

        public TextPriority getPriority() {
            return this.mBuilder.priority;
        }

        public List<SegmentText> getSegmentTexts() {
            return this.mSegmentTexts;
        }

        public int getStrokeColor() {
            return this.mBuilder.strokeColor;
        }

        public int getTextColor() {
            return this.mBuilder.textColor;
        }

        public int getTextSize() {
            return this.mBuilder.textSize;
        }

        public void setPriority(TextPriority textPriority) {
            this.mBuilder.priority = textPriority;
        }

        public void setStrokeColor(int i) {
            this.mBuilder.strokeColor = i;
        }

        public void setTextColor(int i) {
            this.mBuilder.textColor = i;
        }

        public void setTextSize(int i) {
            this.mBuilder.textSize = i;
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/tencentmap/mapsdk/maps/model/PolylineOptions$TextPriority.class */
    public enum TextPriority {
        NORMAL,
        HIGH
    }

    private PolylineOptions geodesic(boolean z) {
        this.boIsGeodes = z;
        return this;
    }

    @Deprecated
    public static String getsDefaultArrowTexture() {
        return sDefaultArrowTexture;
    }

    private boolean isGeodesic() {
        return this.boIsGeodes;
    }

    @Deprecated
    public static void setDefaultArrowTexture(String str) {
        sDefaultArrowTexture = str;
    }

    public PolylineOptions aboveMaskLayer(boolean z) {
        this.mAboveMaskLayer = z;
        return this;
    }

    public PolylineOptions abovePillar(boolean z) {
        this.boIsAbove = z;
        if (this.mIndoorInfo != null) {
            this.boIsAbove = true;
        }
        return this;
    }

    public PolylineOptions add(LatLng latLng, LatLng... latLngArr) {
        this.listLatLngs.add(latLng);
        if (latLngArr != null) {
            add(latLngArr);
        }
        return this;
    }

    public PolylineOptions add(LatLng[] latLngArr) {
        if (latLngArr != null) {
            this.listLatLngs.addAll(Arrays.asList(latLngArr));
        }
        return this;
    }

    public PolylineOptions addAll(Iterable<LatLng> iterable) {
        if (iterable != null) {
            for (LatLng latLng : iterable) {
                add(latLng, new LatLng[0]);
            }
        }
        return this;
    }

    public PolylineOptions alpha(float f) {
        this.alpha = f;
        return this;
    }

    public PolylineOptions animation(Animation animation) {
        this.initAnimation = animation;
        return this;
    }

    public PolylineOptions arrow(boolean z) {
        this.boArraw = z;
        return this;
    }

    public PolylineOptions arrowSpacing(int i) {
        this.mArrowSpacing = i;
        return this;
    }

    public PolylineOptions arrowTexture(BitmapDescriptor bitmapDescriptor) {
        this.mArrowTexture = bitmapDescriptor;
        return this;
    }

    public PolylineOptions borderColor(int i) {
        this.iBorderColors = new int[]{i};
        return this;
    }

    public PolylineOptions borderColors(int[] iArr) {
        this.iBorderColors = iArr;
        return this;
    }

    public PolylineOptions borderWidth(float f) {
        if (f < 0.0f) {
            this.fBorderWidth = 1.0f;
            return this;
        }
        this.fBorderWidth = f;
        return this;
    }

    public PolylineOptions clickable(boolean z) {
        this.mClickable = z;
        return this;
    }

    public PolylineOptions color(int i) {
        this.iStrokeColor = i;
        return this;
    }

    public PolylineOptions colorTexture(BitmapDescriptor bitmapDescriptor) {
        this.mCustomeColorTexture = bitmapDescriptor;
        this.colorType = ColorType.LINE_COLOR_TEXTURE;
        return this;
    }

    public PolylineOptions colorType(ColorType colorType) {
        this.colorType = colorType;
        return this;
    }

    public PolylineOptions colors(int[] iArr, int[] iArr2) {
        this.iColors = iArr;
        this.iIndexs = iArr2;
        return this;
    }

    public PolylineOptions eraseColor(int i) {
        this.eraseColor = i;
        return this;
    }

    public float getAlpha() {
        return this.alpha;
    }

    public Animation getAnimation() {
        return this.initAnimation;
    }

    public int getArrowSpacing() {
        return this.mArrowSpacing;
    }

    public BitmapDescriptor getArrowTexture() {
        return this.mArrowTexture;
    }

    public int[] getBorderColors() {
        return this.iBorderColors;
    }

    public float getBorderWidth() {
        return this.fBorderWidth;
    }

    public int getColor() {
        return this.iStrokeColor;
    }

    public BitmapDescriptor getColorTexture() {
        return this.mCustomeColorTexture;
    }

    public ColorType getColorType() {
        return this.colorType;
    }

    public int[][] getColors() {
        int[] iArr;
        int[] iArr2 = this.iColors;
        if (iArr2 == null || (iArr = this.iIndexs) == null) {
            return null;
        }
        int[][] iArr3 = (int[][]) Array.newInstance(Integer.TYPE, 2, Math.max(iArr2.length, iArr.length));
        iArr3[0] = this.iColors;
        iArr3[1] = this.iIndexs;
        return iArr3;
    }

    public int getEraseColor() {
        return this.eraseColor;
    }

    public IndoorInfo getIndoorInfo() {
        return this.mIndoorInfo;
    }

    public int getLevel() {
        return this.iLevel;
    }

    public boolean getLineCap() {
        return this.lineCap;
    }

    public int getLineType() {
        return this.lineType;
    }

    public List<Integer> getPattern() {
        return this.pattern;
    }

    public List<LatLng> getPoints() {
        return this.listLatLngs;
    }

    public Text getText() {
        return this.mText;
    }

    @Deprecated
    public String getTextureName() {
        return this.strCustomerTextName;
    }

    public float getWidth() {
        return this.fwidth;
    }

    public int getZIndex() {
        return this.fIndex;
    }

    public PolylineOptions gradient(boolean z) {
        this.mGradientEnable = z;
        return this;
    }

    public PolylineOptions indoorInfo(IndoorInfo indoorInfo) {
        if (indoorInfo != null) {
            this.mIndoorInfo = indoorInfo;
            this.boIsAbove = true;
        }
        return this;
    }

    public boolean isAboveMaskLayer() {
        return this.mAboveMaskLayer;
    }

    public boolean isAbovePillar() {
        return this.boIsAbove;
    }

    public boolean isArrow() {
        return this.boArraw;
    }

    public boolean isClickable() {
        return this.mClickable;
    }

    public boolean isGradientEnable() {
        return this.mGradientEnable;
    }

    public boolean isRoad() {
        return this.mIsRoad;
    }

    public boolean isVisible() {
        return this.boVisible;
    }

    public PolylineOptions latLngs(List<LatLng> list) {
        if (list != null) {
            this.listLatLngs.clear();
            this.listLatLngs.addAll(list);
        }
        return this;
    }

    public PolylineOptions level(int i) {
        if (i >= 0) {
            if (i > 2) {
                return this;
            }
            this.iLevel = i;
        }
        return this;
    }

    public PolylineOptions lineCap(boolean z) {
        this.lineCap = z;
        return this;
    }

    public PolylineOptions lineType(int i) {
        this.lineType = i;
        return this;
    }

    public PolylineOptions pattern(List<Integer> list) {
        this.pattern = list;
        return this;
    }

    public PolylineOptions road(boolean z) {
        this.mIsRoad = z;
        return this;
    }

    @Deprecated
    public PolylineOptions setColorTexture(String str) {
        this.strCustomerTextName = str;
        return colorTexture(BitmapDescriptorFactory.fromAsset(str));
    }

    @Deprecated
    public void setColors(int[] iArr, int[] iArr2) {
        this.iColors = iArr;
        this.iIndexs = iArr2;
    }

    @Deprecated
    public void setLatLngs(List<LatLng> list) {
        latLngs(list);
    }

    @Deprecated
    public PolylineOptions setLineType(int i) {
        return lineType(i);
    }

    public PolylineOptions text(Text text) {
        this.mText = text;
        return this;
    }

    public PolylineOptions updatePoints(Iterable<LatLng> iterable) {
        ArrayList arrayList = new ArrayList();
        if (iterable != null) {
            for (LatLng latLng : iterable) {
                arrayList.add(latLng);
            }
        }
        this.listLatLngs.clear();
        addAll(arrayList);
        return this;
    }

    public PolylineOptions visible(boolean z) {
        this.boVisible = z;
        return this;
    }

    public PolylineOptions width(float f) {
        if (f < 0.0f) {
            this.fwidth = 9.0f;
            return this;
        }
        float f2 = f;
        if (f > 128.0f) {
            f2 = 128.0f;
        }
        this.fwidth = f2;
        return this;
    }

    public void writeToParcel(Parcel parcel, int i) {
        if (parcel == null) {
            return;
        }
        parcel.writeFloat(this.fwidth);
    }

    public PolylineOptions zIndex(int i) {
        this.fIndex = Math.max(0, i);
        return this;
    }
}
