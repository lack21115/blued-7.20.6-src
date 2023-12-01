package android.media;

import android.graphics.Rect;
import android.os.Parcel;
import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/* loaded from: source-9557208-dex2jar.jar:android/media/TimedText.class */
public final class TimedText {
    private static final int FIRST_PRIVATE_KEY = 101;
    private static final int FIRST_PUBLIC_KEY = 1;
    private static final int KEY_BACKGROUND_COLOR_RGBA = 3;
    private static final int KEY_DISPLAY_FLAGS = 1;
    private static final int KEY_END_CHAR = 104;
    private static final int KEY_FONT_ID = 105;
    private static final int KEY_FONT_SIZE = 106;
    private static final int KEY_GLOBAL_SETTING = 101;
    private static final int KEY_HIGHLIGHT_COLOR_RGBA = 4;
    private static final int KEY_LOCAL_SETTING = 102;
    private static final int KEY_SCROLL_DELAY = 5;
    private static final int KEY_START_CHAR = 103;
    private static final int KEY_START_TIME = 7;
    private static final int KEY_STRUCT_BLINKING_TEXT_LIST = 8;
    private static final int KEY_STRUCT_FONT_LIST = 9;
    private static final int KEY_STRUCT_HIGHLIGHT_LIST = 10;
    private static final int KEY_STRUCT_HYPER_TEXT_LIST = 11;
    private static final int KEY_STRUCT_JUSTIFICATION = 15;
    private static final int KEY_STRUCT_KARAOKE_LIST = 12;
    private static final int KEY_STRUCT_STYLE_LIST = 13;
    private static final int KEY_STRUCT_TEXT = 16;
    private static final int KEY_STRUCT_TEXT_POS = 14;
    private static final int KEY_STYLE_FLAGS = 2;
    private static final int KEY_TEXT_COLOR_RGBA = 107;
    private static final int KEY_WRAP_TEXT = 6;
    private static final int LAST_PRIVATE_KEY = 107;
    private static final int LAST_PUBLIC_KEY = 16;
    private static final String TAG = "TimedText";
    private Justification mJustification;
    private final HashMap<Integer, Object> mKeyObjectMap = new HashMap<>();
    private int mDisplayFlags = -1;
    private int mBackgroundColorRGBA = -1;
    private int mHighlightColorRGBA = -1;
    private int mScrollDelay = -1;
    private int mWrapText = -1;
    private List<CharPos> mBlinkingPosList = null;
    private List<CharPos> mHighlightPosList = null;
    private List<Karaoke> mKaraokeList = null;
    private List<Font> mFontList = null;
    private List<Style> mStyleList = null;
    private List<HyperText> mHyperTextList = null;
    private Rect mTextBounds = null;
    private String mTextChars = null;

    /* loaded from: source-9557208-dex2jar.jar:android/media/TimedText$CharPos.class */
    public static final class CharPos {
        public final int endChar;
        public final int startChar;

        public CharPos(int i, int i2) {
            this.startChar = i;
            this.endChar = i2;
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/media/TimedText$Font.class */
    public static final class Font {
        public final int ID;
        public final String name;

        public Font(int i, String str) {
            this.ID = i;
            this.name = str;
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/media/TimedText$HyperText.class */
    public static final class HyperText {
        public final String URL;
        public final String altString;
        public final int endChar;
        public final int startChar;

        public HyperText(int i, int i2, String str, String str2) {
            this.startChar = i;
            this.endChar = i2;
            this.URL = str;
            this.altString = str2;
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/media/TimedText$Justification.class */
    public static final class Justification {
        public final int horizontalJustification;
        public final int verticalJustification;

        public Justification(int i, int i2) {
            this.horizontalJustification = i;
            this.verticalJustification = i2;
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/media/TimedText$Karaoke.class */
    public static final class Karaoke {
        public final int endChar;
        public final int endTimeMs;
        public final int startChar;
        public final int startTimeMs;

        public Karaoke(int i, int i2, int i3, int i4) {
            this.startTimeMs = i;
            this.endTimeMs = i2;
            this.startChar = i3;
            this.endChar = i4;
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/media/TimedText$Style.class */
    public static final class Style {
        public final int colorRGBA;
        public final int endChar;
        public final int fontID;
        public final int fontSize;
        public final boolean isBold;
        public final boolean isItalic;
        public final boolean isUnderlined;
        public final int startChar;

        public Style(int i, int i2, int i3, boolean z, boolean z2, boolean z3, int i4, int i5) {
            this.startChar = i;
            this.endChar = i2;
            this.fontID = i3;
            this.isBold = z;
            this.isItalic = z2;
            this.isUnderlined = z3;
            this.fontSize = i4;
            this.colorRGBA = i5;
        }
    }

    public TimedText(Parcel parcel) {
        if (parseParcel(parcel)) {
            return;
        }
        this.mKeyObjectMap.clear();
        throw new IllegalArgumentException("parseParcel() fails");
    }

    private boolean containsKey(int i) {
        return isValidKey(i) && this.mKeyObjectMap.containsKey(Integer.valueOf(i));
    }

    private Object getObject(int i) {
        if (containsKey(i)) {
            return this.mKeyObjectMap.get(Integer.valueOf(i));
        }
        throw new IllegalArgumentException("Invalid key: " + i);
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x000c, code lost:
        if (r4 > 16) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x001a, code lost:
        if (r4 > 107) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean isValidKey(int r4) {
        /*
            r3 = this;
            r0 = 1
            r6 = r0
            r0 = r4
            r1 = 1
            if (r0 < r1) goto Lf
            r0 = r6
            r5 = r0
            r0 = r4
            r1 = 16
            if (r0 <= r1) goto L1f
        Lf:
            r0 = r4
            r1 = 101(0x65, float:1.42E-43)
            if (r0 < r1) goto L1d
            r0 = r6
            r5 = r0
            r0 = r4
            r1 = 107(0x6b, float:1.5E-43)
            if (r0 <= r1) goto L1f
        L1d:
            r0 = 0
            r5 = r0
        L1f:
            r0 = r5
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: android.media.TimedText.isValidKey(int):boolean");
    }

    private Set keySet() {
        return this.mKeyObjectMap.keySet();
    }

    private boolean parseParcel(Parcel parcel) {
        parcel.setDataPosition(0);
        if (parcel.dataAvail() == 0) {
            return false;
        }
        int readInt = parcel.readInt();
        if (readInt == 102) {
            int readInt2 = parcel.readInt();
            if (readInt2 != 7) {
                return false;
            }
            this.mKeyObjectMap.put(Integer.valueOf(readInt2), Integer.valueOf(parcel.readInt()));
            if (parcel.readInt() != 16) {
                return false;
            }
            parcel.readInt();
            byte[] createByteArray = parcel.createByteArray();
            if (createByteArray == null || createByteArray.length == 0) {
                this.mTextChars = null;
            } else {
                this.mTextChars = new String(createByteArray);
            }
        } else if (readInt != 101) {
            Log.w(TAG, "Invalid timed text key found: " + readInt);
            return false;
        }
        while (parcel.dataAvail() > 0) {
            int readInt3 = parcel.readInt();
            if (!isValidKey(readInt3)) {
                Log.w(TAG, "Invalid timed text key found: " + readInt3);
                return false;
            }
            Object obj = null;
            switch (readInt3) {
                case 1:
                    this.mDisplayFlags = parcel.readInt();
                    obj = Integer.valueOf(this.mDisplayFlags);
                    break;
                case 2:
                case 7:
                    break;
                case 3:
                    this.mBackgroundColorRGBA = parcel.readInt();
                    obj = Integer.valueOf(this.mBackgroundColorRGBA);
                    break;
                case 4:
                    this.mHighlightColorRGBA = parcel.readInt();
                    obj = Integer.valueOf(this.mHighlightColorRGBA);
                    break;
                case 5:
                    this.mScrollDelay = parcel.readInt();
                    obj = Integer.valueOf(this.mScrollDelay);
                    break;
                case 6:
                    this.mWrapText = parcel.readInt();
                    obj = Integer.valueOf(this.mWrapText);
                    break;
                case 8:
                    readBlinkingText(parcel);
                    obj = this.mBlinkingPosList;
                    break;
                case 9:
                    readFont(parcel);
                    obj = this.mFontList;
                    break;
                case 10:
                    readHighlight(parcel);
                    obj = this.mHighlightPosList;
                    break;
                case 11:
                    readHyperText(parcel);
                    obj = this.mHyperTextList;
                    break;
                case 12:
                    readKaraoke(parcel);
                    obj = this.mKaraokeList;
                    break;
                case 13:
                    readStyle(parcel);
                    obj = this.mStyleList;
                    break;
                case 14:
                    this.mTextBounds = new Rect(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt());
                    obj = null;
                    break;
                case 15:
                    this.mJustification = new Justification(parcel.readInt(), parcel.readInt());
                    obj = this.mJustification;
                    break;
                default:
                    obj = null;
                    break;
            }
            if (obj != null) {
                if (this.mKeyObjectMap.containsKey(Integer.valueOf(readInt3))) {
                    this.mKeyObjectMap.remove(Integer.valueOf(readInt3));
                }
                this.mKeyObjectMap.put(Integer.valueOf(readInt3), obj);
            }
        }
        return true;
    }

    private void readBlinkingText(Parcel parcel) {
        CharPos charPos = new CharPos(parcel.readInt(), parcel.readInt());
        if (this.mBlinkingPosList == null) {
            this.mBlinkingPosList = new ArrayList();
        }
        this.mBlinkingPosList.add(charPos);
    }

    private void readFont(Parcel parcel) {
        int readInt = parcel.readInt();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= readInt) {
                return;
            }
            Font font = new Font(parcel.readInt(), new String(parcel.createByteArray(), 0, parcel.readInt()));
            if (this.mFontList == null) {
                this.mFontList = new ArrayList();
            }
            this.mFontList.add(font);
            i = i2 + 1;
        }
    }

    private void readHighlight(Parcel parcel) {
        CharPos charPos = new CharPos(parcel.readInt(), parcel.readInt());
        if (this.mHighlightPosList == null) {
            this.mHighlightPosList = new ArrayList();
        }
        this.mHighlightPosList.add(charPos);
    }

    private void readHyperText(Parcel parcel) {
        HyperText hyperText = new HyperText(parcel.readInt(), parcel.readInt(), new String(parcel.createByteArray(), 0, parcel.readInt()), new String(parcel.createByteArray(), 0, parcel.readInt()));
        if (this.mHyperTextList == null) {
            this.mHyperTextList = new ArrayList();
        }
        this.mHyperTextList.add(hyperText);
    }

    private void readKaraoke(Parcel parcel) {
        int readInt = parcel.readInt();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= readInt) {
                return;
            }
            Karaoke karaoke = new Karaoke(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt());
            if (this.mKaraokeList == null) {
                this.mKaraokeList = new ArrayList();
            }
            this.mKaraokeList.add(karaoke);
            i = i2 + 1;
        }
    }

    private void readStyle(Parcel parcel) {
        boolean z = false;
        int i = -1;
        int i2 = -1;
        int i3 = -1;
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        int i4 = -1;
        int i5 = -1;
        while (!z && parcel.dataAvail() > 0) {
            switch (parcel.readInt()) {
                case 2:
                    int readInt = parcel.readInt();
                    z2 = readInt % 2 == 1;
                    z3 = readInt % 4 >= 2;
                    if (readInt / 4 != 1) {
                        z4 = false;
                        break;
                    } else {
                        z4 = true;
                        break;
                    }
                case 103:
                    i = parcel.readInt();
                    break;
                case 104:
                    i2 = parcel.readInt();
                    break;
                case 105:
                    i3 = parcel.readInt();
                    break;
                case 106:
                    i4 = parcel.readInt();
                    break;
                case 107:
                    i5 = parcel.readInt();
                    break;
                default:
                    parcel.setDataPosition(parcel.dataPosition() - 4);
                    z = true;
                    break;
            }
        }
        Style style = new Style(i, i2, i3, z2, z3, z4, i4, i5);
        if (this.mStyleList == null) {
            this.mStyleList = new ArrayList();
        }
        this.mStyleList.add(style);
    }

    public Rect getBounds() {
        return this.mTextBounds;
    }

    public String getText() {
        return this.mTextChars;
    }
}
