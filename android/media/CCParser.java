package android.media;

import android.text.SpannableStringBuilder;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import android.util.Log;
import android.view.accessibility.CaptioningManager;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Arrays;

/* loaded from: source-9557208-dex2jar.jar:android/media/CCParser.class */
class CCParser {
    private static final int AOF = 34;
    private static final int AON = 35;
    private static final int BS = 33;
    private static final int CR = 45;
    private static final int DER = 36;
    private static final int EDM = 44;
    private static final int ENM = 46;
    private static final int EOC = 47;
    private static final int FON = 40;
    private static final int INVALID = -1;
    public static final int MAX_COLS = 32;
    public static final int MAX_ROWS = 15;
    private static final int MODE_PAINT_ON = 1;
    private static final int MODE_POP_ON = 3;
    private static final int MODE_ROLL_UP = 2;
    private static final int MODE_TEXT = 4;
    private static final int MODE_UNKNOWN = 0;
    private static final int RCL = 32;
    private static final int RDC = 41;
    private static final int RTD = 43;
    private static final int RU2 = 37;
    private static final int RU3 = 38;
    private static final int RU4 = 39;
    private static final int TR = 42;
    private static final char TS = 160;
    private final DisplayListener mListener;
    private static final String TAG = "CCParser";
    private static final boolean DEBUG = Log.isLoggable(TAG, 3);
    private int mMode = 1;
    private int mRollUpSize = 4;
    private CCMemory mDisplay = new CCMemory();
    private CCMemory mNonDisplay = new CCMemory();
    private CCMemory mTextMem = new CCMemory();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/media/CCParser$CCData.class */
    public static class CCData {
        private final byte mData1;
        private final byte mData2;
        private final byte mType;
        private static final String[] mCtrlCodeMap = {"RCL", "BS", "AOF", "AON", "DER", "RU2", "RU3", "RU4", "FON", "RDC", "TR", "RTD", "EDM", "CR", "ENM", "EOC"};
        private static final String[] mSpecialCharMap = {"®", "°", "½", "¿", "™", "¢", "£", "♪", "à", " ", "è", "â", "ê", "î", "ô", "û"};
        private static final String[] mSpanishCharMap = {"Á", "É", "Ó", "Ú", "Ü", "ü", "‘", "¡", "*", "'", "—", "©", "℠", "•", "“", "”", "À", "Â", "Ç", "È", "Ê", "Ë", "ë", "Î", "Ï", "ï", "Ô", "Ù", "ù", "Û", "«", "»"};
        private static final String[] mProtugueseCharMap = {"Ã", "ã", "Í", "Ì", "ì", "Ò", "ò", "Õ", "õ", "{", "}", "\\", "^", "_", "|", Constants.WAVE_SEPARATOR, "Ä", "ä", "Ö", "ö", "ß", "¥", "¤", "│", "Å", "å", "Ø", "ø", "┌", "┐", "└", "┘"};

        CCData(byte b, byte b2, byte b3) {
            this.mType = b;
            this.mData1 = b2;
            this.mData2 = b3;
        }

        private String ctrlCodeToString(int i) {
            return mCtrlCodeMap[i - 32];
        }

        static CCData[] fromByteArray(byte[] bArr) {
            CCData[] cCDataArr = new CCData[bArr.length / 3];
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= cCDataArr.length) {
                    return cCDataArr;
                }
                cCDataArr[i2] = new CCData(bArr[i2 * 3], bArr[(i2 * 3) + 1], bArr[(i2 * 3) + 2]);
                i = i2 + 1;
            }
        }

        private char getBasicChar(byte b) {
            switch (b) {
                case 42:
                    return (char) 225;
                case 92:
                    return (char) 233;
                case 94:
                    return (char) 237;
                case 95:
                    return (char) 243;
                case 96:
                    return (char) 250;
                case 123:
                    return (char) 231;
                case 124:
                    return (char) 247;
                case 125:
                    return (char) 209;
                case 126:
                    return (char) 241;
                case Byte.MAX_VALUE:
                    return (char) 9608;
                default:
                    return (char) b;
            }
        }

        private String getBasicChars() {
            if (this.mData1 < 32 || this.mData1 > Byte.MAX_VALUE) {
                return null;
            }
            StringBuilder sb = new StringBuilder(2);
            sb.append(getBasicChar(this.mData1));
            if (this.mData2 >= 32 && this.mData2 <= Byte.MAX_VALUE) {
                sb.append(getBasicChar(this.mData2));
            }
            return sb.toString();
        }

        private String getExtendedChar() {
            if ((this.mData1 == 18 || this.mData1 == 26) && this.mData2 >= 32 && this.mData2 <= 63) {
                return mSpanishCharMap[this.mData2 - 32];
            }
            if ((this.mData1 == 19 || this.mData1 == 27) && this.mData2 >= 32 && this.mData2 <= 63) {
                return mProtugueseCharMap[this.mData2 - 32];
            }
            return null;
        }

        private String getSpecialChar() {
            if ((this.mData1 == 17 || this.mData1 == 25) && this.mData2 >= 48 && this.mData2 <= 63) {
                return mSpecialCharMap[this.mData2 - 48];
            }
            return null;
        }

        private boolean isBasicChar() {
            return this.mData1 >= 32 && this.mData1 <= Byte.MAX_VALUE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean isExtendedChar() {
            return (this.mData1 == 18 || this.mData1 == 26 || this.mData1 == 19 || this.mData1 == 27) && this.mData2 >= 32 && this.mData2 <= 63;
        }

        private boolean isSpecialChar() {
            return (this.mData1 == 17 || this.mData1 == 25) && this.mData2 >= 48 && this.mData2 <= 63;
        }

        int getCtrlCode() {
            if ((this.mData1 == 20 || this.mData1 == 28) && this.mData2 >= 32 && this.mData2 <= 47) {
                return this.mData2;
            }
            return -1;
        }

        String getDisplayText() {
            String basicChars = getBasicChars();
            String str = basicChars;
            if (basicChars == null) {
                String specialChar = getSpecialChar();
                str = specialChar;
                if (specialChar == null) {
                    str = getExtendedChar();
                }
            }
            return str;
        }

        StyleCode getMidRow() {
            if ((this.mData1 == 17 || this.mData1 == 25) && this.mData2 >= 32 && this.mData2 <= 47) {
                return StyleCode.fromByte(this.mData2);
            }
            return null;
        }

        PAC getPAC() {
            if ((this.mData1 & 112) == 16 && (this.mData2 & 64) == 64) {
                if ((this.mData1 & 7) != 0 || (this.mData2 & 32) == 0) {
                    return PAC.fromBytes(this.mData1, this.mData2);
                }
                return null;
            }
            return null;
        }

        int getTabOffset() {
            if ((this.mData1 == 23 || this.mData1 == 31) && this.mData2 >= 33 && this.mData2 <= 35) {
                return this.mData2 & 3;
            }
            return 0;
        }

        boolean isDisplayableChar() {
            return isBasicChar() || isSpecialChar() || isExtendedChar();
        }

        public String toString() {
            if (this.mData1 >= 16 || this.mData2 >= 16) {
                int ctrlCode = getCtrlCode();
                if (ctrlCode != -1) {
                    return String.format("[%d]%s", Byte.valueOf(this.mType), ctrlCodeToString(ctrlCode));
                }
                int tabOffset = getTabOffset();
                if (tabOffset > 0) {
                    return String.format("[%d]Tab%d", Byte.valueOf(this.mType), Integer.valueOf(tabOffset));
                }
                PAC pac = getPAC();
                if (pac != null) {
                    return String.format("[%d]PAC: %s", Byte.valueOf(this.mType), pac.toString());
                }
                StyleCode midRow = getMidRow();
                return midRow != null ? String.format("[%d]Mid-row: %s", Byte.valueOf(this.mType), midRow.toString()) : isDisplayableChar() ? String.format("[%d]Displayable: %s (%02x %02x)", Byte.valueOf(this.mType), getDisplayText(), Byte.valueOf(this.mData1), Byte.valueOf(this.mData2)) : String.format("[%d]Invalid: %02x %02x", Byte.valueOf(this.mType), Byte.valueOf(this.mData1), Byte.valueOf(this.mData2));
            }
            return String.format("[%d]Null: %02x %02x", Byte.valueOf(this.mType), Byte.valueOf(this.mData1), Byte.valueOf(this.mData2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/media/CCParser$CCLineBuilder.class */
    public static class CCLineBuilder {
        private final StringBuilder mDisplayChars;
        private final StyleCode[] mMidRowStyles;
        private final StyleCode[] mPACStyles;

        CCLineBuilder(String str) {
            this.mDisplayChars = new StringBuilder(str);
            this.mMidRowStyles = new StyleCode[this.mDisplayChars.length()];
            this.mPACStyles = new StyleCode[this.mDisplayChars.length()];
        }

        void applyStyleSpan(SpannableStringBuilder spannableStringBuilder, StyleCode styleCode, int i, int i2) {
            if (styleCode.isItalics()) {
                spannableStringBuilder.setSpan(new StyleSpan(2), i, i2, 33);
            }
            if (styleCode.isUnderline()) {
                spannableStringBuilder.setSpan(new UnderlineSpan(), i, i2, 33);
            }
        }

        char charAt(int i) {
            return this.mDisplayChars.charAt(i);
        }

        /* JADX WARN: Code restructure failed: missing block: B:27:0x0097, code lost:
            if (r9 < 0) goto L44;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        android.text.SpannableStringBuilder getStyledText(android.view.accessibility.CaptioningManager.CaptionStyle r7) {
            /*
                Method dump skipped, instructions count: 265
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: android.media.CCParser.CCLineBuilder.getStyledText(android.view.accessibility.CaptioningManager$CaptionStyle):android.text.SpannableStringBuilder");
        }

        int length() {
            return this.mDisplayChars.length();
        }

        void setCharAt(int i, char c2) {
            this.mDisplayChars.setCharAt(i, c2);
            this.mMidRowStyles[i] = null;
        }

        void setMidRowAt(int i, StyleCode styleCode) {
            this.mDisplayChars.setCharAt(i, ' ');
            this.mMidRowStyles[i] = styleCode;
        }

        void setPACAt(int i, PAC pac) {
            this.mPACStyles[i] = pac;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/media/CCParser$CCMemory.class */
    public static class CCMemory {
        private final String mBlankLine;
        private int mCol;
        private final CCLineBuilder[] mLines = new CCLineBuilder[17];
        private int mRow;

        CCMemory() {
            char[] cArr = new char[34];
            Arrays.fill(cArr, (char) 160);
            this.mBlankLine = new String(cArr);
        }

        private static int clamp(int i, int i2, int i3) {
            return i < i2 ? i2 : i > i3 ? i3 : i;
        }

        private CCLineBuilder getLineBuffer(int i) {
            if (this.mLines[i] == null) {
                this.mLines[i] = new CCLineBuilder(this.mBlankLine);
            }
            return this.mLines[i];
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void moveBaselineTo(int i, int i2) {
            if (this.mRow == i) {
                return;
            }
            int i3 = i2;
            if (i < i2) {
                i3 = i;
            }
            int i4 = i3;
            if (this.mRow < i3) {
                i4 = this.mRow;
            }
            if (i >= this.mRow) {
                int i5 = 0;
                while (true) {
                    int i6 = i5;
                    if (i6 >= i4) {
                        break;
                    }
                    this.mLines[i - i6] = this.mLines[this.mRow - i6];
                    i5 = i6 + 1;
                }
            } else {
                int i7 = i4;
                while (true) {
                    int i8 = i7 - 1;
                    if (i8 < 0) {
                        break;
                    }
                    this.mLines[i - i8] = this.mLines[this.mRow - i8];
                    i7 = i8;
                }
            }
            int i9 = 0;
            while (true) {
                int i10 = i9;
                if (i10 > i - i2) {
                    break;
                }
                this.mLines[i10] = null;
                i9 = i10 + 1;
            }
            while (true) {
                i++;
                if (i >= this.mLines.length) {
                    return;
                }
                this.mLines[i] = null;
            }
        }

        private void moveCursorByCol(int i) {
            this.mCol = clamp(this.mCol + i, 1, 32);
        }

        private void moveCursorTo(int i, int i2) {
            this.mRow = clamp(i, 1, 15);
            this.mCol = clamp(i2, 1, 32);
        }

        private void moveCursorToRow(int i) {
            this.mRow = clamp(i, 1, 15);
        }

        void bs() {
            moveCursorByCol(-1);
            if (this.mLines[this.mRow] != null) {
                this.mLines[this.mRow].setCharAt(this.mCol, (char) 160);
                if (this.mCol == 31) {
                    this.mLines[this.mRow].setCharAt(32, (char) 160);
                }
            }
        }

        void cr() {
            moveCursorTo(this.mRow + 1, 1);
        }

        void der() {
            if (this.mLines[this.mRow] == null) {
                return;
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.mCol) {
                    this.mLines[this.mRow] = null;
                    return;
                } else if (this.mLines[this.mRow].charAt(i2) != 160) {
                    int i3 = this.mCol;
                    while (true) {
                        int i4 = i3;
                        if (i4 >= this.mLines[this.mRow].length()) {
                            return;
                        }
                        this.mLines[i4].setCharAt(i4, (char) 160);
                        i3 = i4 + 1;
                    }
                } else {
                    i = i2 + 1;
                }
            }
        }

        void erase() {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.mLines.length) {
                    this.mRow = 15;
                    this.mCol = 1;
                    return;
                }
                this.mLines[i2] = null;
                i = i2 + 1;
            }
        }

        SpannableStringBuilder[] getStyledText(CaptioningManager.CaptionStyle captionStyle) {
            ArrayList arrayList = new ArrayList(15);
            int i = 1;
            while (true) {
                int i2 = i;
                if (i2 > 15) {
                    return (SpannableStringBuilder[]) arrayList.toArray(new SpannableStringBuilder[15]);
                }
                arrayList.add(this.mLines[i2] != null ? this.mLines[i2].getStyledText(captionStyle) : null);
                i = i2 + 1;
            }
        }

        void rollUp(int i) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 > this.mRow - i) {
                    break;
                }
                this.mLines[i3] = null;
                i2 = i3 + 1;
            }
            int i4 = (this.mRow - i) + 1;
            int i5 = i4;
            if (i4 < 1) {
                i5 = 1;
            }
            while (i5 < this.mRow) {
                this.mLines[i5] = this.mLines[i5 + 1];
                i5++;
            }
            int i6 = this.mRow;
            while (true) {
                int i7 = i6;
                if (i7 >= this.mLines.length) {
                    this.mCol = 1;
                    return;
                } else {
                    this.mLines[i7] = null;
                    i6 = i7 + 1;
                }
            }
        }

        void tab(int i) {
            moveCursorByCol(i);
        }

        void writeMidRowCode(StyleCode styleCode) {
            getLineBuffer(this.mRow).setMidRowAt(this.mCol, styleCode);
            moveCursorByCol(1);
        }

        void writePAC(PAC pac) {
            if (pac.isIndentPAC()) {
                moveCursorTo(pac.getRow(), pac.getCol());
            } else {
                moveCursorTo(pac.getRow(), 1);
            }
            getLineBuffer(this.mRow).setPACAt(this.mCol, pac);
        }

        void writeText(String str) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= str.length()) {
                    return;
                }
                getLineBuffer(this.mRow).setCharAt(this.mCol, str.charAt(i2));
                moveCursorByCol(1);
                i = i2 + 1;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-9557208-dex2jar.jar:android/media/CCParser$DisplayListener.class */
    public interface DisplayListener {
        CaptioningManager.CaptionStyle getCaptionStyle();

        void onDisplayChanged(SpannableStringBuilder[] spannableStringBuilderArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/media/CCParser$PAC.class */
    public static class PAC extends StyleCode {
        final int mCol;
        final int mRow;

        PAC(int i, int i2, int i3, int i4) {
            super(i3, i4);
            this.mRow = i;
            this.mCol = i2;
        }

        static PAC fromBytes(byte b, byte b2) {
            int i = new int[]{11, 1, 3, 12, 14, 5, 7, 9}[b & 7] + ((b2 & 32) >> 5);
            int i2 = 0;
            if ((b2 & 1) != 0) {
                i2 = 0 | 2;
            }
            if ((b2 & 16) != 0) {
                return new PAC(i, ((b2 >> 1) & 7) * 4, i2, 0);
            }
            int i3 = (b2 >> 1) & 7;
            int i4 = i3;
            int i5 = i2;
            if (i3 == 7) {
                i4 = 0;
                i5 = i2 | 1;
            }
            return new PAC(i, -1, i5, i4);
        }

        int getCol() {
            return this.mCol;
        }

        int getRow() {
            return this.mRow;
        }

        boolean isIndentPAC() {
            return this.mCol >= 0;
        }

        @Override // android.media.CCParser.StyleCode
        public String toString() {
            return String.format("{%d, %d}, %s", Integer.valueOf(this.mRow), Integer.valueOf(this.mCol), super.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/media/CCParser$StyleCode.class */
    public static class StyleCode {
        static final int COLOR_BLUE = 2;
        static final int COLOR_CYAN = 3;
        static final int COLOR_GREEN = 1;
        static final int COLOR_INVALID = 7;
        static final int COLOR_MAGENTA = 6;
        static final int COLOR_RED = 4;
        static final int COLOR_WHITE = 0;
        static final int COLOR_YELLOW = 5;
        static final int STYLE_ITALICS = 1;
        static final int STYLE_UNDERLINE = 2;
        static final String[] mColorMap = {"WHITE", "GREEN", "BLUE", "CYAN", "RED", "YELLOW", "MAGENTA", "INVALID"};
        final int mColor;
        final int mStyle;

        StyleCode(int i, int i2) {
            this.mStyle = i;
            this.mColor = i2;
        }

        static StyleCode fromByte(byte b) {
            int i = 0;
            int i2 = (b >> 1) & 7;
            if ((b & 1) != 0) {
                i = 0 | 2;
            }
            int i3 = i2;
            int i4 = i;
            if (i2 == 7) {
                i3 = 0;
                i4 = i | 1;
            }
            return new StyleCode(i4, i3);
        }

        int getColor() {
            return this.mColor;
        }

        boolean isItalics() {
            return (this.mStyle & 1) != 0;
        }

        boolean isUnderline() {
            return (this.mStyle & 2) != 0;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("{");
            sb.append(mColorMap[this.mColor]);
            if ((this.mStyle & 1) != 0) {
                sb.append(", ITALICS");
            }
            if ((this.mStyle & 2) != 0) {
                sb.append(", UNDERLINE");
            }
            sb.append("}");
            return sb.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CCParser(DisplayListener displayListener) {
        this.mListener = displayListener;
    }

    private CCMemory getMemory() {
        switch (this.mMode) {
            case 1:
            case 2:
                return this.mDisplay;
            case 3:
                return this.mNonDisplay;
            case 4:
                return this.mTextMem;
            default:
                Log.w(TAG, "unrecoginized mode: " + this.mMode);
                return this.mDisplay;
        }
    }

    private boolean handleCtrlCode(CCData cCData) {
        boolean z = true;
        int ctrlCode = cCData.getCtrlCode();
        switch (ctrlCode) {
            case 32:
                this.mMode = 3;
                return true;
            case 33:
                getMemory().bs();
                return true;
            case 34:
            case 35:
            default:
                z = false;
                break;
            case 36:
                getMemory().der();
                return true;
            case 37:
            case 38:
            case 39:
                this.mRollUpSize = ctrlCode - 35;
                if (this.mMode != 2) {
                    this.mDisplay.erase();
                    this.mNonDisplay.erase();
                }
                this.mMode = 2;
                return true;
            case 40:
                Log.i(TAG, "Flash On");
                return true;
            case 41:
                this.mMode = 1;
                return true;
            case 42:
                this.mMode = 4;
                this.mTextMem.erase();
                return true;
            case 43:
                this.mMode = 4;
                return true;
            case 44:
                this.mDisplay.erase();
                updateDisplay();
                return true;
            case 45:
                if (this.mMode == 2) {
                    getMemory().rollUp(this.mRollUpSize);
                } else {
                    getMemory().cr();
                }
                if (this.mMode == 2) {
                    updateDisplay();
                    return true;
                }
                break;
            case 46:
                this.mNonDisplay.erase();
                return true;
            case 47:
                swapMemory();
                this.mMode = 3;
                updateDisplay();
                return true;
        }
        return z;
    }

    private boolean handleDisplayableChars(CCData cCData) {
        boolean z = true;
        if (cCData.isDisplayableChar()) {
            if (cCData.isExtendedChar()) {
                getMemory().bs();
            }
            getMemory().writeText(cCData.getDisplayText());
            if (this.mMode == 1 || this.mMode == 2) {
                updateDisplay();
                return true;
            }
        } else {
            z = false;
        }
        return z;
    }

    private boolean handleMidRowCode(CCData cCData) {
        StyleCode midRow = cCData.getMidRow();
        if (midRow != null) {
            getMemory().writeMidRowCode(midRow);
            return true;
        }
        return false;
    }

    private boolean handlePACCode(CCData cCData) {
        PAC pac = cCData.getPAC();
        if (pac != null) {
            if (this.mMode == 2) {
                getMemory().moveBaselineTo(pac.getRow(), this.mRollUpSize);
            }
            getMemory().writePAC(pac);
            return true;
        }
        return false;
    }

    private boolean handleTabOffsets(CCData cCData) {
        int tabOffset = cCData.getTabOffset();
        if (tabOffset > 0) {
            getMemory().tab(tabOffset);
            return true;
        }
        return false;
    }

    private void swapMemory() {
        CCMemory cCMemory = this.mDisplay;
        this.mDisplay = this.mNonDisplay;
        this.mNonDisplay = cCMemory;
    }

    private void updateDisplay() {
        if (this.mListener != null) {
            this.mListener.onDisplayChanged(this.mDisplay.getStyledText(this.mListener.getCaptionStyle()));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void parse(byte[] bArr) {
        CCData[] fromByteArray = CCData.fromByteArray(bArr);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= fromByteArray.length) {
                return;
            }
            if (DEBUG) {
                Log.d(TAG, fromByteArray[i2].toString());
            }
            if (!handleCtrlCode(fromByteArray[i2]) && !handleTabOffsets(fromByteArray[i2]) && !handlePACCode(fromByteArray[i2]) && !handleMidRowCode(fromByteArray[i2])) {
                handleDisplayableChars(fromByteArray[i2]);
            }
            i = i2 + 1;
        }
    }
}
