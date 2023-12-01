package com.android.internal.util.cm.palette;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.util.SparseIntArray;
import com.android.internal.util.cm.palette.Palette;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-4181928-dex2jar.jar:com/android/internal/util/cm/palette/ColorCutQuantizer.class */
public final class ColorCutQuantizer {
    private static final float BLACK_MAX_LIGHTNESS = 0.05f;
    private static final int COMPONENT_BLUE = -1;
    private static final int COMPONENT_GREEN = -2;
    private static final int COMPONENT_RED = -3;
    private static final String LOG_TAG = ColorCutQuantizer.class.getSimpleName();
    private static final Comparator<Vbox> VBOX_COMPARATOR_VOLUME = new Comparator<Vbox>() { // from class: com.android.internal.util.cm.palette.ColorCutQuantizer.1
        @Override // java.util.Comparator
        public int compare(Vbox vbox, Vbox vbox2) {
            return vbox2.getVolume() - vbox.getVolume();
        }
    };
    private static final float WHITE_MIN_LIGHTNESS = 0.95f;
    private final SparseIntArray mColorPopulations;
    private final int[] mColors;
    private final List<Palette.Swatch> mQuantizedColors;
    private final float[] mTempHsl = new float[3];

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-4181928-dex2jar.jar:com/android/internal/util/cm/palette/ColorCutQuantizer$Vbox.class */
    public class Vbox {
        private int mLowerIndex;
        private int mMaxBlue;
        private int mMaxGreen;
        private int mMaxRed;
        private int mMinBlue;
        private int mMinGreen;
        private int mMinRed;
        private int mUpperIndex;

        Vbox(int i, int i2) {
            this.mLowerIndex = i;
            this.mUpperIndex = i2;
            fitBox();
        }

        boolean canSplit() {
            return getColorCount() > 1;
        }

        int findSplitPoint() {
            int longestColorDimension = getLongestColorDimension();
            ColorCutQuantizer.this.modifySignificantOctet(longestColorDimension, this.mLowerIndex, this.mUpperIndex);
            Arrays.sort(ColorCutQuantizer.this.mColors, this.mLowerIndex, this.mUpperIndex + 1);
            ColorCutQuantizer.this.modifySignificantOctet(longestColorDimension, this.mLowerIndex, this.mUpperIndex);
            int midPoint = midPoint(longestColorDimension);
            int i = this.mLowerIndex;
            while (true) {
                int i2 = i;
                if (i2 > this.mUpperIndex) {
                    return this.mLowerIndex;
                }
                int i3 = ColorCutQuantizer.this.mColors[i2];
                switch (longestColorDimension) {
                    case -3:
                        if (Color.red(i3) < midPoint) {
                            break;
                        } else {
                            return i2;
                        }
                    case -2:
                        if (Color.green(i3) < midPoint) {
                            break;
                        } else {
                            return i2;
                        }
                    case -1:
                        if (Color.blue(i3) <= midPoint) {
                            break;
                        } else {
                            return i2;
                        }
                }
                i = i2 + 1;
            }
        }

        void fitBox() {
            this.mMinBlue = 255;
            this.mMinGreen = 255;
            this.mMinRed = 255;
            this.mMaxBlue = 0;
            this.mMaxGreen = 0;
            this.mMaxRed = 0;
            int i = this.mLowerIndex;
            while (true) {
                int i2 = i;
                if (i2 > this.mUpperIndex) {
                    return;
                }
                int i3 = ColorCutQuantizer.this.mColors[i2];
                int red = Color.red(i3);
                int green = Color.green(i3);
                int blue = Color.blue(i3);
                if (red > this.mMaxRed) {
                    this.mMaxRed = red;
                }
                if (red < this.mMinRed) {
                    this.mMinRed = red;
                }
                if (green > this.mMaxGreen) {
                    this.mMaxGreen = green;
                }
                if (green < this.mMinGreen) {
                    this.mMinGreen = green;
                }
                if (blue > this.mMaxBlue) {
                    this.mMaxBlue = blue;
                }
                if (blue < this.mMinBlue) {
                    this.mMinBlue = blue;
                }
                i = i2 + 1;
            }
        }

        Palette.Swatch getAverageColor() {
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            int i5 = this.mLowerIndex;
            while (true) {
                int i6 = i5;
                if (i6 > this.mUpperIndex) {
                    return new Palette.Swatch(Math.round(i / i4), Math.round(i2 / i4), Math.round(i3 / i4), i4);
                }
                int i7 = ColorCutQuantizer.this.mColors[i6];
                int i8 = ColorCutQuantizer.this.mColorPopulations.get(i7);
                i4 += i8;
                i += Color.red(i7) * i8;
                i2 += Color.green(i7) * i8;
                i3 += Color.blue(i7) * i8;
                i5 = i6 + 1;
            }
        }

        int getColorCount() {
            return (this.mUpperIndex - this.mLowerIndex) + 1;
        }

        int getLongestColorDimension() {
            int i = this.mMaxRed - this.mMinRed;
            int i2 = this.mMaxGreen - this.mMinGreen;
            int i3 = this.mMaxBlue - this.mMinBlue;
            if (i < i2 || i < i3) {
                return (i2 < i || i2 < i3) ? -1 : -2;
            }
            return -3;
        }

        int getVolume() {
            return ((this.mMaxRed - this.mMinRed) + 1) * ((this.mMaxGreen - this.mMinGreen) + 1) * ((this.mMaxBlue - this.mMinBlue) + 1);
        }

        int midPoint(int i) {
            switch (i) {
                case -2:
                    return (this.mMinGreen + this.mMaxGreen) / 2;
                case -1:
                    return (this.mMinBlue + this.mMaxBlue) / 2;
                default:
                    return (this.mMinRed + this.mMaxRed) / 2;
            }
        }

        Vbox splitBox() {
            if (canSplit()) {
                int findSplitPoint = findSplitPoint();
                Vbox vbox = new Vbox(findSplitPoint + 1, this.mUpperIndex);
                this.mUpperIndex = findSplitPoint;
                fitBox();
                return vbox;
            }
            throw new IllegalStateException("Can not split a box with only 1 color");
        }
    }

    private ColorCutQuantizer(ColorHistogram colorHistogram, int i) {
        int numberOfColors = colorHistogram.getNumberOfColors();
        int[] colors = colorHistogram.getColors();
        int[] colorCounts = colorHistogram.getColorCounts();
        this.mColorPopulations = new SparseIntArray(numberOfColors);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= colors.length) {
                break;
            }
            this.mColorPopulations.append(colors[i3], colorCounts[i3]);
            i2 = i3 + 1;
        }
        this.mColors = new int[numberOfColors];
        int i4 = 0;
        for (int i5 : colors) {
            if (!shouldIgnoreColor(i5)) {
                this.mColors[i4] = i5;
                i4++;
            }
        }
        if (i4 > i) {
            this.mQuantizedColors = quantizePixels(i4 - 1, i);
            return;
        }
        this.mQuantizedColors = new ArrayList();
        int[] iArr = this.mColors;
        int length = iArr.length;
        int i6 = 0;
        while (true) {
            int i7 = i6;
            if (i7 >= length) {
                return;
            }
            int i8 = iArr[i7];
            this.mQuantizedColors.add(new Palette.Swatch(i8, this.mColorPopulations.get(i8)));
            i6 = i7 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ColorCutQuantizer fromBitmap(Bitmap bitmap, int i) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] iArr = new int[width * height];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        return new ColorCutQuantizer(new ColorHistogram(iArr), i);
    }

    private List<Palette.Swatch> generateAverageColors(Collection<Vbox> collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        for (Vbox vbox : collection) {
            Palette.Swatch averageColor = vbox.getAverageColor();
            if (!shouldIgnoreColor(averageColor)) {
                arrayList.add(averageColor);
            }
        }
        return arrayList;
    }

    private static boolean isBlack(float[] fArr) {
        return fArr[2] <= 0.05f;
    }

    private static boolean isNearRedILine(float[] fArr) {
        return fArr[0] >= 10.0f && fArr[0] <= 37.0f && fArr[1] <= 0.82f;
    }

    private static boolean isWhite(float[] fArr) {
        return fArr[2] >= 0.95f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void modifySignificantOctet(int i, int i2, int i3) {
        switch (i) {
            case -3:
            default:
                return;
            case -2:
                int i4 = i2;
                while (true) {
                    int i5 = i4;
                    if (i5 > i3) {
                        return;
                    }
                    int i6 = this.mColors[i5];
                    this.mColors[i5] = Color.rgb((i6 >> 8) & 255, (i6 >> 16) & 255, i6 & 255);
                    i4 = i5 + 1;
                }
            case -1:
                int i7 = i2;
                while (true) {
                    int i8 = i7;
                    if (i8 > i3) {
                        return;
                    }
                    int i9 = this.mColors[i8];
                    this.mColors[i8] = Color.rgb(i9 & 255, (i9 >> 8) & 255, (i9 >> 16) & 255);
                    i7 = i8 + 1;
                }
        }
    }

    private List<Palette.Swatch> quantizePixels(int i, int i2) {
        PriorityQueue<Vbox> priorityQueue = new PriorityQueue<>(i2, VBOX_COMPARATOR_VOLUME);
        priorityQueue.offer(new Vbox(0, i));
        splitBoxes(priorityQueue, i2);
        return generateAverageColors(priorityQueue);
    }

    private boolean shouldIgnoreColor(int i) {
        ColorUtils.RGBtoHSL(Color.red(i), Color.green(i), Color.blue(i), this.mTempHsl);
        return shouldIgnoreColor(this.mTempHsl);
    }

    private static boolean shouldIgnoreColor(Palette.Swatch swatch) {
        return shouldIgnoreColor(swatch.getHsl());
    }

    private static boolean shouldIgnoreColor(float[] fArr) {
        return isWhite(fArr) || isBlack(fArr) || isNearRedILine(fArr);
    }

    private void splitBoxes(PriorityQueue<Vbox> priorityQueue, int i) {
        Vbox poll;
        while (priorityQueue.size() < i && (poll = priorityQueue.poll()) != null && poll.canSplit()) {
            priorityQueue.offer(poll.splitBox());
            priorityQueue.offer(poll);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<Palette.Swatch> getQuantizedColors() {
        return this.mQuantizedColors;
    }
}
