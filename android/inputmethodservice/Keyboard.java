package android.inputmethodservice;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import com.android.internal.R;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: source-9557208-dex2jar.jar:android/inputmethodservice/Keyboard.class */
public class Keyboard {
    public static final int EDGE_BOTTOM = 8;
    public static final int EDGE_LEFT = 1;
    public static final int EDGE_RIGHT = 2;
    public static final int EDGE_TOP = 4;
    private static final int GRID_HEIGHT = 5;
    private static final int GRID_SIZE = 50;
    private static final int GRID_WIDTH = 10;
    public static final int KEYCODE_ALT = -6;
    public static final int KEYCODE_CANCEL = -3;
    public static final int KEYCODE_DELETE = -5;
    public static final int KEYCODE_DONE = -4;
    public static final int KEYCODE_MODE_CHANGE = -2;
    public static final int KEYCODE_SHIFT = -1;
    private static float SEARCH_DISTANCE = 1.8f;
    static final String TAG = "Keyboard";
    private static final String TAG_KEY = "Key";
    private static final String TAG_KEYBOARD = "Keyboard";
    private static final String TAG_ROW = "Row";
    private int mCellHeight;
    private int mCellWidth;
    private int mDefaultHeight;
    private int mDefaultHorizontalGap;
    private int mDefaultVerticalGap;
    private int mDefaultWidth;
    private int mDisplayHeight;
    private int mDisplayWidth;
    private int[][] mGridNeighbors;
    private int mKeyHeight;
    private int mKeyWidth;
    private int mKeyboardMode;
    private List<Key> mKeys;
    private CharSequence mLabel;
    private List<Key> mModifierKeys;
    private int mProximityThreshold;
    private int[] mShiftKeyIndices;
    private Key[] mShiftKeys;
    private boolean mShifted;
    private int mTotalHeight;
    private int mTotalWidth;
    private ArrayList<Row> rows;

    /* loaded from: source-9557208-dex2jar.jar:android/inputmethodservice/Keyboard$Key.class */
    public static class Key {
        public int[] codes;
        public int edgeFlags;
        public int gap;
        public int height;
        public Drawable icon;
        public Drawable iconPreview;
        private Keyboard keyboard;
        public CharSequence label;
        public boolean modifier;
        public boolean on;
        public CharSequence popupCharacters;
        public int popupResId;
        public boolean pressed;
        public boolean repeatable;
        public boolean sticky;
        public CharSequence text;
        public int width;
        public int x;
        public int y;
        private static final int[] KEY_STATE_NORMAL_ON = {16842911, 16842912};
        private static final int[] KEY_STATE_PRESSED_ON = {16842919, 16842911, 16842912};
        private static final int[] KEY_STATE_NORMAL_OFF = {16842911};
        private static final int[] KEY_STATE_PRESSED_OFF = {16842919, 16842911};
        private static final int[] KEY_STATE_NORMAL = new int[0];
        private static final int[] KEY_STATE_PRESSED = {16842919};

        public Key(Resources resources, Row row, int i, int i2, XmlResourceParser xmlResourceParser) {
            this(row);
            this.x = i;
            this.y = i2;
            TypedArray obtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlResourceParser), R.styleable.Keyboard);
            this.width = Keyboard.getDimensionOrFraction(obtainAttributes, 0, this.keyboard.mDisplayWidth, row.defaultWidth);
            this.height = Keyboard.getDimensionOrFraction(obtainAttributes, 1, this.keyboard.mDisplayHeight, row.defaultHeight);
            this.gap = Keyboard.getDimensionOrFraction(obtainAttributes, 2, this.keyboard.mDisplayWidth, row.defaultHorizontalGap);
            obtainAttributes.recycle();
            TypedArray obtainAttributes2 = resources.obtainAttributes(Xml.asAttributeSet(xmlResourceParser), R.styleable.Keyboard_Key);
            this.x += this.gap;
            TypedValue typedValue = new TypedValue();
            obtainAttributes2.getValue(0, typedValue);
            if (typedValue.type == 16 || typedValue.type == 17) {
                this.codes = new int[]{typedValue.data};
            } else if (typedValue.type == 3) {
                this.codes = parseCSV(typedValue.string.toString());
            }
            this.iconPreview = obtainAttributes2.getDrawable(7);
            if (this.iconPreview != null) {
                this.iconPreview.setBounds(0, 0, this.iconPreview.getIntrinsicWidth(), this.iconPreview.getIntrinsicHeight());
            }
            this.popupCharacters = obtainAttributes2.getText(2);
            this.popupResId = obtainAttributes2.getResourceId(1, 0);
            this.repeatable = obtainAttributes2.getBoolean(6, false);
            this.modifier = obtainAttributes2.getBoolean(4, false);
            this.sticky = obtainAttributes2.getBoolean(5, false);
            this.edgeFlags = obtainAttributes2.getInt(3, 0);
            this.edgeFlags |= row.rowEdgeFlags;
            this.icon = obtainAttributes2.getDrawable(10);
            if (this.icon != null) {
                this.icon.setBounds(0, 0, this.icon.getIntrinsicWidth(), this.icon.getIntrinsicHeight());
            }
            this.label = obtainAttributes2.getText(9);
            this.text = obtainAttributes2.getText(8);
            if (this.codes == null && !TextUtils.isEmpty(this.label)) {
                this.codes = new int[]{this.label.charAt(0)};
            }
            obtainAttributes2.recycle();
        }

        public Key(Row row) {
            this.keyboard = row.parent;
            this.height = row.defaultHeight;
            this.width = row.defaultWidth;
            this.gap = row.defaultHorizontalGap;
            this.edgeFlags = row.rowEdgeFlags;
        }

        public int[] getCurrentDrawableState() {
            int[] iArr = KEY_STATE_NORMAL;
            if (this.on) {
                if (!this.pressed) {
                    return KEY_STATE_NORMAL_ON;
                }
                iArr = KEY_STATE_PRESSED_ON;
            } else if (this.sticky) {
                return this.pressed ? KEY_STATE_PRESSED_OFF : KEY_STATE_NORMAL_OFF;
            } else if (this.pressed) {
                return KEY_STATE_PRESSED;
            }
            return iArr;
        }

        public boolean isInside(int i, int i2) {
            boolean z = (this.edgeFlags & 1) > 0;
            boolean z2 = (this.edgeFlags & 2) > 0;
            boolean z3 = (this.edgeFlags & 4) > 0;
            boolean z4 = (this.edgeFlags & 8) > 0;
            if (i >= this.x || (z && i <= this.x + this.width)) {
                if (i < this.x + this.width || (z2 && i >= this.x)) {
                    if (i2 >= this.y || (z3 && i2 <= this.y + this.height)) {
                        if (i2 >= this.y + this.height) {
                            return z4 && i2 >= this.y;
                        }
                        return true;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }

        public void onPressed() {
            this.pressed = !this.pressed;
        }

        public void onReleased(boolean z) {
            this.pressed = !this.pressed;
            if (this.sticky) {
                this.on = !this.on;
            }
        }

        int[] parseCSV(String str) {
            int i = 0;
            if (str.length() > 0) {
                int i2 = 0;
                int i3 = 0 + 1;
                while (true) {
                    int indexOf = str.indexOf(",", i2 + 1);
                    i = i3;
                    if (indexOf <= 0) {
                        break;
                    }
                    i3++;
                    i2 = indexOf;
                }
            }
            int[] iArr = new int[i];
            int i4 = 0;
            StringTokenizer stringTokenizer = new StringTokenizer(str, ",");
            while (stringTokenizer.hasMoreTokens()) {
                int i5 = i4 + 1;
                try {
                    iArr[i4] = Integer.parseInt(stringTokenizer.nextToken());
                    i4 = i5;
                } catch (NumberFormatException e) {
                    Log.e("Keyboard", "Error parsing keycodes " + str);
                    i4 = i5;
                }
            }
            return iArr;
        }

        public int squaredDistanceFrom(int i, int i2) {
            int i3 = (this.x + (this.width / 2)) - i;
            int i4 = (this.y + (this.height / 2)) - i2;
            return (i3 * i3) + (i4 * i4);
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/inputmethodservice/Keyboard$Row.class */
    public static class Row {
        public int defaultHeight;
        public int defaultHorizontalGap;
        public int defaultWidth;
        ArrayList<Key> mKeys = new ArrayList<>();
        public int mode;
        private Keyboard parent;
        public int rowEdgeFlags;
        public int verticalGap;

        public Row(Resources resources, Keyboard keyboard, XmlResourceParser xmlResourceParser) {
            this.parent = keyboard;
            TypedArray obtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlResourceParser), R.styleable.Keyboard);
            this.defaultWidth = Keyboard.getDimensionOrFraction(obtainAttributes, 0, keyboard.mDisplayWidth, keyboard.mDefaultWidth);
            this.defaultHeight = Keyboard.getDimensionOrFraction(obtainAttributes, 1, keyboard.mDisplayHeight, keyboard.mDefaultHeight);
            this.defaultHorizontalGap = Keyboard.getDimensionOrFraction(obtainAttributes, 2, keyboard.mDisplayWidth, keyboard.mDefaultHorizontalGap);
            this.verticalGap = Keyboard.getDimensionOrFraction(obtainAttributes, 3, keyboard.mDisplayHeight, keyboard.mDefaultVerticalGap);
            obtainAttributes.recycle();
            TypedArray obtainAttributes2 = resources.obtainAttributes(Xml.asAttributeSet(xmlResourceParser), R.styleable.Keyboard_Row);
            this.rowEdgeFlags = obtainAttributes2.getInt(0, 0);
            this.mode = obtainAttributes2.getResourceId(1, 0);
        }

        public Row(Keyboard keyboard) {
            this.parent = keyboard;
        }
    }

    public Keyboard(Context context, int i) {
        this(context, i, 0);
    }

    public Keyboard(Context context, int i, int i2) {
        this.mShiftKeys = new Key[]{null, null};
        this.mShiftKeyIndices = new int[]{-1, -1};
        this.rows = new ArrayList<>();
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        this.mDisplayWidth = displayMetrics.widthPixels;
        this.mDisplayHeight = displayMetrics.heightPixels;
        this.mDefaultHorizontalGap = 0;
        this.mDefaultWidth = this.mDisplayWidth / 10;
        this.mDefaultVerticalGap = 0;
        this.mDefaultHeight = this.mDefaultWidth;
        this.mKeys = new ArrayList();
        this.mModifierKeys = new ArrayList();
        this.mKeyboardMode = i2;
        loadKeyboard(context, context.getResources().getXml(i));
    }

    public Keyboard(Context context, int i, int i2, int i3, int i4) {
        this.mShiftKeys = new Key[]{null, null};
        this.mShiftKeyIndices = new int[]{-1, -1};
        this.rows = new ArrayList<>();
        this.mDisplayWidth = i3;
        this.mDisplayHeight = i4;
        this.mDefaultHorizontalGap = 0;
        this.mDefaultWidth = this.mDisplayWidth / 10;
        this.mDefaultVerticalGap = 0;
        this.mDefaultHeight = this.mDefaultWidth;
        this.mKeys = new ArrayList();
        this.mModifierKeys = new ArrayList();
        this.mKeyboardMode = i2;
        loadKeyboard(context, context.getResources().getXml(i));
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0087, code lost:
        if (((r6.mDefaultWidth + r8) + r11) > r6.mDisplayWidth) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public Keyboard(android.content.Context r7, int r8, java.lang.CharSequence r9, int r10, int r11) {
        /*
            Method dump skipped, instructions count: 310
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.inputmethodservice.Keyboard.<init>(android.content.Context, int, java.lang.CharSequence, int, int):void");
    }

    /* JADX WARN: Type inference failed for: r1v11, types: [int[], int[][]] */
    private void computeNearestNeighbors() {
        int i;
        this.mCellWidth = ((getMinWidth() + 10) - 1) / 10;
        this.mCellHeight = ((getHeight() + 5) - 1) / 5;
        this.mGridNeighbors = new int[50];
        int[] iArr = new int[this.mKeys.size()];
        int i2 = this.mCellWidth;
        int i3 = this.mCellHeight;
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i5 >= i2 * 10) {
                return;
            }
            int i6 = 0;
            while (true) {
                int i7 = i6;
                if (i7 < i3 * 5) {
                    int i8 = 0;
                    int i9 = 0;
                    while (i9 < this.mKeys.size()) {
                        Key key = this.mKeys.get(i9);
                        if (key.squaredDistanceFrom(i5, i7) >= this.mProximityThreshold && key.squaredDistanceFrom((this.mCellWidth + i5) - 1, i7) >= this.mProximityThreshold && key.squaredDistanceFrom((this.mCellWidth + i5) - 1, (this.mCellHeight + i7) - 1) >= this.mProximityThreshold) {
                            i = i8;
                            if (key.squaredDistanceFrom(i5, (this.mCellHeight + i7) - 1) >= this.mProximityThreshold) {
                                i9++;
                                i8 = i;
                            }
                        }
                        iArr[i8] = i9;
                        i = i8 + 1;
                        i9++;
                        i8 = i;
                    }
                    int[] iArr2 = new int[i8];
                    System.arraycopy(iArr, 0, iArr2, 0, i8);
                    this.mGridNeighbors[((i7 / this.mCellHeight) * 10) + (i5 / this.mCellWidth)] = iArr2;
                    i6 = i7 + this.mCellHeight;
                }
            }
            i4 = i5 + this.mCellWidth;
        }
    }

    static int getDimensionOrFraction(TypedArray typedArray, int i, int i2, int i3) {
        TypedValue peekValue = typedArray.peekValue(i);
        if (peekValue != null) {
            if (peekValue.type == 5) {
                return typedArray.getDimensionPixelOffset(i, i3);
            }
            if (peekValue.type == 6) {
                return Math.round(typedArray.getFraction(i, i2, i2, i3));
            }
        }
        return i3;
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x0097 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:128:0x001d A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void loadKeyboard(android.content.Context r8, android.content.res.XmlResourceParser r9) {
        /*
            Method dump skipped, instructions count: 561
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.inputmethodservice.Keyboard.loadKeyboard(android.content.Context, android.content.res.XmlResourceParser):void");
    }

    private void parseKeyboardAttributes(Resources resources, XmlResourceParser xmlResourceParser) {
        TypedArray obtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlResourceParser), R.styleable.Keyboard);
        this.mDefaultWidth = getDimensionOrFraction(obtainAttributes, 0, this.mDisplayWidth, this.mDisplayWidth / 10);
        this.mDefaultHeight = getDimensionOrFraction(obtainAttributes, 1, this.mDisplayHeight, 50);
        this.mDefaultHorizontalGap = getDimensionOrFraction(obtainAttributes, 2, this.mDisplayWidth, 0);
        this.mDefaultVerticalGap = getDimensionOrFraction(obtainAttributes, 3, this.mDisplayHeight, 0);
        this.mProximityThreshold = (int) (this.mDefaultWidth * SEARCH_DISTANCE);
        this.mProximityThreshold *= this.mProximityThreshold;
        obtainAttributes.recycle();
    }

    private void skipToEndOfRow(XmlResourceParser xmlResourceParser) throws XmlPullParserException, IOException {
        while (true) {
            int next = xmlResourceParser.next();
            if (next == 1) {
                return;
            }
            if (next == 3 && xmlResourceParser.getName().equals(TAG_ROW)) {
                return;
            }
        }
    }

    protected Key createKeyFromXml(Resources resources, Row row, int i, int i2, XmlResourceParser xmlResourceParser) {
        return new Key(resources, row, i, i2, xmlResourceParser);
    }

    protected Row createRowFromXml(Resources resources, XmlResourceParser xmlResourceParser) {
        return new Row(resources, this, xmlResourceParser);
    }

    public int getHeight() {
        return this.mTotalHeight;
    }

    protected int getHorizontalGap() {
        return this.mDefaultHorizontalGap;
    }

    protected int getKeyHeight() {
        return this.mDefaultHeight;
    }

    protected int getKeyWidth() {
        return this.mDefaultWidth;
    }

    public List<Key> getKeys() {
        return this.mKeys;
    }

    public int getMinWidth() {
        return this.mTotalWidth;
    }

    public List<Key> getModifierKeys() {
        return this.mModifierKeys;
    }

    public int[] getNearestKeys(int i, int i2) {
        int i3;
        if (this.mGridNeighbors == null) {
            computeNearestNeighbors();
        }
        return (i < 0 || i >= getMinWidth() || i2 < 0 || i2 >= getHeight() || (i3 = ((i2 / this.mCellHeight) * 10) + (i / this.mCellWidth)) >= 50) ? new int[0] : this.mGridNeighbors[i3];
    }

    public int getShiftKeyIndex() {
        return this.mShiftKeyIndices[0];
    }

    public int[] getShiftKeyIndices() {
        return this.mShiftKeyIndices;
    }

    protected int getVerticalGap() {
        return this.mDefaultVerticalGap;
    }

    public boolean isShifted() {
        return this.mShifted;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void resize(int i, int i2) {
        int size = this.rows.size();
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= size) {
                this.mTotalWidth = i;
                return;
            }
            Row row = this.rows.get(i4);
            int size2 = row.mKeys.size();
            int i5 = 0;
            int i6 = 0;
            int i7 = 0;
            while (i7 < size2) {
                Key key = row.mKeys.get(i7);
                int i8 = i5;
                if (i7 > 0) {
                    i8 = i5 + key.gap;
                }
                i6 += key.width;
                i7++;
                i5 = i8;
            }
            if (i5 + i6 > i) {
                float f = (i - i5) / i6;
                int i9 = 0;
                for (int i10 = 0; i10 < size2; i10++) {
                    Key key2 = row.mKeys.get(i10);
                    key2.width = (int) (key2.width * f);
                    key2.x = i9;
                    i9 += key2.width + key2.gap;
                }
            }
            i3 = i4 + 1;
        }
    }

    protected void setHorizontalGap(int i) {
        this.mDefaultHorizontalGap = i;
    }

    protected void setKeyHeight(int i) {
        this.mDefaultHeight = i;
    }

    protected void setKeyWidth(int i) {
        this.mDefaultWidth = i;
    }

    public boolean setShifted(boolean z) {
        Key[] keyArr = this.mShiftKeys;
        int length = keyArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                break;
            }
            Key key = keyArr[i2];
            if (key != null) {
                key.on = z;
            }
            i = i2 + 1;
        }
        if (this.mShifted != z) {
            this.mShifted = z;
            return true;
        }
        return false;
    }

    protected void setVerticalGap(int i) {
        this.mDefaultVerticalGap = i;
    }
}
