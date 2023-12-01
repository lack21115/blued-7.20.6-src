package java.awt.font;

import android.view.View;
import dalvik.bytecode.Opcodes;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import javax.microedition.khronos.opengles.GL10;
import javax.microedition.khronos.opengles.GL11;

/* loaded from: source-2895416-dex2jar.jar:java/awt/font/NumericShaper.class */
public final class NumericShaper implements Serializable {
    public static final int ALL_RANGES = 524287;
    public static final int ARABIC = 2;
    public static final int BENGALI = 16;
    public static final int DEVANAGARI = 8;
    public static final int EASTERN_ARABIC = 4;
    public static final int ETHIOPIC = 65536;
    public static final int EUROPEAN = 1;
    public static final int GUJARATI = 64;
    public static final int GURMUKHI = 32;
    private static final int INDEX_ARABIC = 1;
    private static final int INDEX_BENGALI = 4;
    private static final int INDEX_DEVANAGARI = 3;
    private static final int INDEX_EASTERN_ARABIC = 2;
    private static final int INDEX_ETHIOPIC = 16;
    private static final int INDEX_EUROPEAN = 0;
    private static final int INDEX_GUJARATI = 6;
    private static final int INDEX_GURMUKHI = 5;
    private static final int INDEX_KANNADA = 10;
    private static final int INDEX_KHMER = 17;
    private static final int INDEX_LAO = 13;
    private static final int INDEX_MALAYALAM = 11;
    private static final int INDEX_MONGOLIAN = 18;
    private static final int INDEX_MYANMAR = 15;
    private static final int INDEX_ORIYA = 7;
    private static final int INDEX_TAMIL = 8;
    private static final int INDEX_TELUGU = 9;
    private static final int INDEX_THAI = 12;
    private static final int INDEX_TIBETAN = 14;
    public static final int KANNADA = 1024;
    public static final int KHMER = 131072;
    public static final int LAO = 8192;
    public static final int MALAYALAM = 2048;
    private static final int MAX_INDEX = 19;
    public static final int MONGOLIAN = 262144;
    public static final int MYANMAR = 32768;
    public static final int ORIYA = 128;
    private static final int[] STRONG_TEXT_FLAGS = {0, 0, 134217726, 134217726, 0, 69207040, -8388609, -8388609, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -65533, -1, -1, -100663297, 196611, 16415, 0, 0, 0, 67108864, -10432, -5, -32769, -4194305, -1, -1, -1, -1, -1017, -1, -32769, 67108863, 65535, -131072, -25165825, -2, Opcodes.OP_INSTANCE_OF_JUMBO, 1073741824, -65463, 2033663, -939513841, 134217726, Opcodes.OP_IGET_WIDE_JUMBO, -73728, -1, -1, 541065215, -67059616, -180225, 65535, -8192, View.PUBLIC_STATUS_BAR_VISIBILITY_MASK, -1, 131135, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -8, -469762049, -16703999, 537001971, -417812, -473563649, -1333765759, 133431235, -423960, -1016201729, 1577058305, 1900480, -278552, -470942209, 72193, 65475, -417812, 1676541439, -1333782143, 262083, -700594200, -1006647528, 8396230, 524224, -139282, 66059775, 30, 65475, -139284, -470811137, 1080036831, 65475, -139284, -1006633473, 8396225, 65475, -58720276, 805044223, -16547713, 1835008, -2, 917503, 268402815, 0, -17816170, 537783470, 872349791, 0, -50331649, -1050673153, -257, -2147481601, 3872, -1073741824, 237503, 0, -1, 16914171, 16777215, 0, 0, -1, -65473, 536870911, -1, -1, -2080374785, -1, -1, -249, -1, 67108863, -1, -1, 1031749119, -1, -49665, 2134769663, -8388803, -1, -12713985, -1, 134217727, 536870911, 65535, -1, -1, 2097151, -2, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 8388607, 134217726, -1, -1, 131071, 253951, 6553599, 262143, 122879, -1, -1065353217, 401605055, 1023, 67043328, -1, -1, 16777215, -1, Opcodes.OP_CHECK_CAST_JUMBO, 0, 0, 536870911, 33226872, -64, 2047999, -1, -64513, 67044351, 0, -830472193, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, -1, -1, -1, -1, -1, 0, 0, -1, -1, -1, -1, 268435455, -1, -1, 67108863, 1061158911, -1, -1426112705, 1073741823, -1, 1608515583, 265232348, 534519807, 49152, 27648, 0, -2147352576, 2031616, 0, 0, 0, 1043332228, -201605808, 992, -1, 15, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -4194304, -1, 134217727, 2097152, 0, 0, 0, 0, 0, 0, 0, -268435456, -1, -1, 1023, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4096, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, -1, -1, -1, -1, -1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, -32769, Integer.MAX_VALUE, 0, -1, -1, -1, 31, -1, -65473, -1, 32831, 8388607, 2139062143, 2139062143, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 224, 524157950, -2, -1, -528482305, -2, -1, -134217729, -32, -122881, -1, -1, -32769, 16777215, 0, -65536, 536870911, -1, 15, -1879048193, -1, 131071, -61441, Integer.MAX_VALUE, -1, -1, -1, -125829121, -1, -1, 1073741823, Integer.MAX_VALUE, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2097152, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
    0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 134217728, 0, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, Opcodes.OP_SPUT_BYTE_JUMBO, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2117, 159, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, Integer.MIN_VALUE, 1, 0, 0, Integer.MIN_VALUE, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, Integer.MIN_VALUE, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, Integer.MIN_VALUE, -1, -1, -1, -1, -1, -1, -1, -1, 
    -1, -49153, -1, -63489, -1, -1, 67108863, 0, -1594359681, 1602223615, -37, -1, -1, 262143, -524288, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1073741823, -65536, -1, -196609, -1, 255, 536805376, 0, 0, 0, -2162688, -1, -1, -1, 536870911, 0, 134217726, 134217726, -64, -1, Integer.MAX_VALUE, 486341884, 0};
    public static final int TAMIL = 256;
    public static final int TELUGU = 512;
    public static final int THAI = 4096;
    public static final int TIBETAN = 16384;
    private static final long serialVersionUID = -8022764705923730308L;
    private boolean fContextual;
    private int fDefaultContextIndex;
    private int fRanges;
    private int fSingleRangeIndex;
    private int key;
    private int mask;
    private final int[] scriptsRanges = {0, 591, View.SYSTEM_UI_LAYOUT_FLAGS, Opcodes.OP_IGET_JUMBO, View.SYSTEM_UI_LAYOUT_FLAGS, Opcodes.OP_IGET_JUMBO, GL10.GL_CW, 2431, 2432, Opcodes.OP_IGET_BOOLEAN_JUMBO, 2560, 2687, 2688, Opcodes.OP_IGET_BYTE_JUMBO, GL11.GL_CURRENT_COLOR, 2943, 2944, Opcodes.OP_IGET_CHAR_JUMBO, 3072, 3199, 3200, Opcodes.OP_IGET_SHORT_JUMBO, 3328, 3455, 3584, 3711, 3712, Opcodes.OP_IPUT_WIDE_JUMBO, 3840, 4095, 4096, 4255, GL10.GL_AMBIENT, 4991, 6016, Opcodes.OP_SGET_BOOLEAN_JUMBO, 6144, 6319};
    private final int[] digitsLowRanges = {0, 1584, 1584, 2358, 2486, 2614, 2742, 2870, 2998, 3126, 3254, GL10.GL_MAX_MODELVIEW_STACK_DEPTH, 3616, 3744, 3824, 4112, 4920, 6064, 6112};
    private final String[] contexts = {"EUROPEAN", "ARABIC", "EASTERN_ARABIC", "DEVANAGARI", "BENGALI", "GURMUKHI", "GUJARATI", "ORIYA", "TAMIL", "TELUGU", "KANNADA", "MALAYALAM", "THAI", "LAO", "TIBETAN", "MYANMAR", "ETHIOPIC", "KHMER", "MONGOLIAN"};

    private NumericShaper(int i, int i2, boolean z) {
        this.fRanges = i;
        this.fDefaultContextIndex = getIndexFromRange(i2);
        this.fContextual = z;
        if (this.fContextual) {
            return;
        }
        this.fSingleRangeIndex = getIndexFromRange(i);
    }

    private void contextualShape(char[] cArr, int i, int i2, int i3) {
        if (((1 << i3) & this.fRanges) == 0) {
            i3 = 0;
        }
        int i4 = i;
        while (true) {
            int i5 = i4;
            int i6 = i3;
            if (i5 >= i + i2) {
                return;
            }
            if ('0' > cArr[i5] || cArr[i5] > '9') {
                i3 = i6;
                if (isCharStrong(cArr[i5])) {
                    int charIndex = getCharIndex(cArr[i5]);
                    i3 = i6;
                    if (i6 != charIndex) {
                        i3 = ((1 << charIndex) & this.fRanges) != 0 ? charIndex : 0;
                    }
                }
            } else {
                if (i6 == 16) {
                    i3 = i6;
                    if (cArr[i5] == '0') {
                    }
                }
                cArr[i5] = (char) (this.digitsLowRanges[i6] + cArr[i5]);
                i3 = i6;
            }
            i4 = i5 + 1;
        }
    }

    private int getCharIndex(char c) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 19) {
                return 0;
            }
            int i3 = i2 * 2;
            if (this.scriptsRanges[i3] <= c && c <= this.scriptsRanges[i3 + 1]) {
                return i2;
            }
            i = i2 + 1;
        }
    }

    public static NumericShaper getContextualShaper(int i) {
        return new NumericShaper(i & ALL_RANGES, 1, true);
    }

    public static NumericShaper getContextualShaper(int i, int i2) {
        return new NumericShaper(i & ALL_RANGES, i2 & ALL_RANGES, true);
    }

    private int getIndexFromRange(int i) {
        if (i == 0) {
            throw rangeException(i);
        }
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= 19) {
                throw rangeException(i);
            }
            if (i == (1 << i3)) {
                return i3;
            }
            i2 = i3 + 1;
        }
    }

    private int getRangeFromIndex(int i) {
        if (i < 0 || i >= 19) {
            throw rangeException(i);
        }
        return 1 << i;
    }

    public static NumericShaper getShaper(int i) {
        return new NumericShaper(i & ALL_RANGES, 1, false);
    }

    private boolean isCharStrong(int i) {
        return (STRONG_TEXT_FLAGS[i >> 5] & (1 << (i % 32))) != 0;
    }

    private void nonContextualShape(char[] cArr, int i, int i2) {
        char c = (char) (this.fRanges == 65536 ? 49 : 48);
        int i3 = i;
        while (true) {
            int i4 = i3;
            if (i4 >= i + i2) {
                return;
            }
            if (c <= cArr[i4] && cArr[i4] <= '9') {
                cArr[i4] = (char) (this.digitsLowRanges[this.fSingleRangeIndex] + cArr[i4]);
            }
            i3 = i4 + 1;
        }
    }

    private static IllegalArgumentException rangeException(int i) {
        throw new IllegalArgumentException("Illegal range argument value: " + i);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        updateRangesFields();
    }

    private void updateKeyMaskFields() {
        this.mask = this.fRanges;
        if (!this.fContextual) {
            this.key = this.fSingleRangeIndex;
            return;
        }
        this.mask |= Integer.MIN_VALUE;
        this.key = this.fDefaultContextIndex;
    }

    private void updateRangesFields() {
        this.fRanges = this.mask & Integer.MAX_VALUE;
        this.fContextual = (this.mask & Integer.MIN_VALUE) != 0;
        if (this.fContextual) {
            this.fRanges = this.mask & Integer.MAX_VALUE;
            this.fDefaultContextIndex = this.key;
            return;
        }
        this.fRanges = this.mask;
        this.fSingleRangeIndex = this.key;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        updateKeyMaskFields();
        objectOutputStream.defaultWriteObject();
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0038, code lost:
        if (r3.fContextual == r0.fContextual) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean equals(java.lang.Object r4) {
        /*
            r3 = this;
            r0 = 1
            r5 = r0
            r0 = r4
            if (r0 != 0) goto L8
            r0 = 0
            return r0
        L8:
            r0 = r4
            r1 = r3
            if (r0 != r1) goto Lf
            r0 = 1
            return r0
        Lf:
            r0 = r4
            java.awt.font.NumericShaper r0 = (java.awt.font.NumericShaper) r0     // Catch: java.lang.ClassCastException -> L42
            r4 = r0
            r0 = r3
            int r0 = r0.fRanges     // Catch: java.lang.ClassCastException -> L42
            r1 = r4
            int r1 = r1.fRanges     // Catch: java.lang.ClassCastException -> L42
            if (r0 != r1) goto L3d
            r0 = r3
            int r0 = r0.fDefaultContextIndex     // Catch: java.lang.ClassCastException -> L42
            r1 = r4
            int r1 = r1.fDefaultContextIndex     // Catch: java.lang.ClassCastException -> L42
            if (r0 != r1) goto L3d
            r0 = r3
            boolean r0 = r0.fContextual     // Catch: java.lang.ClassCastException -> L42
            r6 = r0
            r0 = r4
            boolean r0 = r0.fContextual     // Catch: java.lang.ClassCastException -> L42
            r7 = r0
            r0 = r6
            r1 = r7
            if (r0 != r1) goto L3d
        L3b:
            r0 = r5
            return r0
        L3d:
            r0 = 0
            r5 = r0
            goto L3b
        L42:
            r4 = move-exception
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: java.awt.font.NumericShaper.equals(java.lang.Object):boolean");
    }

    public int getRanges() {
        return this.fRanges;
    }

    public int hashCode() {
        int i = this.fRanges;
        return ((((i + 527) * 31) + this.fDefaultContextIndex) * 31) + (this.fContextual ? 1 : 0);
    }

    public boolean isContextual() {
        return this.fContextual;
    }

    public void shape(char[] cArr, int i, int i2) {
        if (isContextual()) {
            contextualShape(cArr, i, i2, this.fDefaultContextIndex);
        } else {
            nonContextualShape(cArr, i, i2);
        }
    }

    public void shape(char[] cArr, int i, int i2, int i3) {
        if (isContextual()) {
            contextualShape(cArr, i, i2, getIndexFromRange(i3));
        } else {
            nonContextualShape(cArr, i, i2);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append("[contextual:");
        sb.append(this.fContextual);
        if (this.fContextual) {
            sb.append(", context:");
            sb.append(this.contexts[this.fDefaultContextIndex]);
        }
        sb.append(", range(s): ");
        if (this.fContextual) {
            int i = 0;
            boolean z = true;
            while (true) {
                boolean z2 = z;
                if (i >= 19) {
                    break;
                }
                boolean z3 = z2;
                if ((this.fRanges & (1 << i)) != 0) {
                    if (z2) {
                        z2 = false;
                    } else {
                        sb.append(", ");
                    }
                    sb.append(this.contexts[i]);
                    z3 = z2;
                }
                i++;
                z = z3;
            }
        } else {
            sb.append(this.contexts[this.fSingleRangeIndex]);
        }
        sb.append("]");
        return sb.toString();
    }
}
