package android.text.method;

import android.text.AutoText;
import android.text.Editable;
import android.text.NoCopySpan;
import android.text.Spannable;
import android.text.TextUtils;
import android.text.method.TextKeyListener;
import android.util.SparseArray;
import android.view.KeyCharacterMap;
import android.view.View;

/* loaded from: source-9557208-dex2jar.jar:android/text/method/QwertyKeyListener.class */
public class QwertyKeyListener extends BaseKeyListener {
    private static QwertyKeyListener sFullKeyboardInstance;
    private TextKeyListener.Capitalize mAutoCap;
    private boolean mAutoText;
    private boolean mFullKeyboard;
    private static QwertyKeyListener[] sInstance = new QwertyKeyListener[TextKeyListener.Capitalize.values().length * 2];
    private static SparseArray<String> PICKER_SETS = new SparseArray<>();

    /* loaded from: source-9557208-dex2jar.jar:android/text/method/QwertyKeyListener$Replaced.class */
    static class Replaced implements NoCopySpan {
        private char[] mText;

        public Replaced(char[] cArr) {
            this.mText = cArr;
        }
    }

    static {
        PICKER_SETS.put(65, "ÀÁÂÄÆÃÅĄĀ");
        PICKER_SETS.put(67, "ÇĆČ");
        PICKER_SETS.put(68, "Ď");
        PICKER_SETS.put(69, "ÈÉÊËĘĚĒ");
        PICKER_SETS.put(71, "Ğ");
        PICKER_SETS.put(76, "Ł");
        PICKER_SETS.put(73, "ÌÍÎÏĪİ");
        PICKER_SETS.put(78, "ÑŃŇ");
        PICKER_SETS.put(79, "ØŒÕÒÓÔÖŌ");
        PICKER_SETS.put(82, "Ř");
        PICKER_SETS.put(83, "ŚŠŞ");
        PICKER_SETS.put(84, "Ť");
        PICKER_SETS.put(85, "ÙÚÛÜŮŪ");
        PICKER_SETS.put(89, "ÝŸ");
        PICKER_SETS.put(90, "ŹŻŽ");
        PICKER_SETS.put(97, "àáâäæãåąā");
        PICKER_SETS.put(99, "çćč");
        PICKER_SETS.put(100, "ď");
        PICKER_SETS.put(101, "èéêëęěē");
        PICKER_SETS.put(103, "ğ");
        PICKER_SETS.put(105, "ìíîïīı");
        PICKER_SETS.put(108, "ł");
        PICKER_SETS.put(110, "ñńň");
        PICKER_SETS.put(111, "øœõòóôöō");
        PICKER_SETS.put(114, "ř");
        PICKER_SETS.put(115, "§ßśšş");
        PICKER_SETS.put(116, "ť");
        PICKER_SETS.put(117, "ùúûüůū");
        PICKER_SETS.put(121, "ýÿ");
        PICKER_SETS.put(122, "źżž");
        PICKER_SETS.put(KeyCharacterMap.PICKER_DIALOG_INPUT, "…¥•®©±[]{}\\|");
        PICKER_SETS.put(47, "\\");
        PICKER_SETS.put(49, "¹½⅓¼⅛");
        PICKER_SETS.put(50, "²⅔");
        PICKER_SETS.put(51, "³¾⅜");
        PICKER_SETS.put(52, "⁴");
        PICKER_SETS.put(53, "⅝");
        PICKER_SETS.put(55, "⅞");
        PICKER_SETS.put(48, "ⁿ∅");
        PICKER_SETS.put(36, "¢£€¥₣₤₱");
        PICKER_SETS.put(37, "‰");
        PICKER_SETS.put(42, "†‡");
        PICKER_SETS.put(45, "–—");
        PICKER_SETS.put(43, "±");
        PICKER_SETS.put(40, "[{<");
        PICKER_SETS.put(41, "]}>");
        PICKER_SETS.put(33, "¡");
        PICKER_SETS.put(34, "“”«»˝");
        PICKER_SETS.put(63, "¿");
        PICKER_SETS.put(44, "‚„");
        PICKER_SETS.put(61, "≠≈∞");
        PICKER_SETS.put(60, "≤«‹");
        PICKER_SETS.put(62, "≥»›");
    }

    public QwertyKeyListener(TextKeyListener.Capitalize capitalize, boolean z) {
        this(capitalize, z, false);
    }

    private QwertyKeyListener(TextKeyListener.Capitalize capitalize, boolean z, boolean z2) {
        this.mAutoCap = capitalize;
        this.mAutoText = z;
        this.mFullKeyboard = z2;
    }

    public static QwertyKeyListener getInstance(boolean z, TextKeyListener.Capitalize capitalize) {
        int ordinal = (capitalize.ordinal() * 2) + (z ? 1 : 0);
        if (sInstance[ordinal] == null) {
            sInstance[ordinal] = new QwertyKeyListener(capitalize, z);
        }
        return sInstance[ordinal];
    }

    public static QwertyKeyListener getInstanceForFullKeyboard() {
        if (sFullKeyboardInstance == null) {
            sFullKeyboardInstance = new QwertyKeyListener(TextKeyListener.Capitalize.NONE, false, true);
        }
        return sFullKeyboardInstance;
    }

    private String getReplacement(CharSequence charSequence, int i, int i2, View view) {
        String str;
        int i3 = i2 - i;
        boolean z = false;
        String str2 = AutoText.get(charSequence, i, i2, view);
        String str3 = str2;
        if (str2 == null) {
            String str4 = AutoText.get(TextUtils.substring(charSequence, i, i2).toLowerCase(), 0, i2 - i, view);
            z = true;
            str3 = str4;
            if (str4 == null) {
                str = null;
                return str;
            }
        }
        int i4 = 0;
        if (z) {
            int i5 = i;
            int i6 = 0;
            while (true) {
                int i7 = i6;
                i4 = i7;
                if (i5 >= i2) {
                    break;
                }
                int i8 = i7;
                if (Character.isUpperCase(charSequence.charAt(i5))) {
                    i8 = i7 + 1;
                }
                i5++;
                i6 = i8;
            }
        }
        String titleCase = i4 == 0 ? str3 : i4 == 1 ? toTitleCase(str3) : i4 == i3 ? str3.toUpperCase() : toTitleCase(str3);
        str = titleCase;
        if (titleCase.length() == i3) {
            str = titleCase;
            if (TextUtils.regionMatches(charSequence, i, titleCase, 0, i3)) {
                return null;
            }
        }
        return str;
    }

    public static void markAsReplaced(Spannable spannable, int i, int i2, String str) {
        Replaced[] replacedArr = (Replaced[]) spannable.getSpans(0, spannable.length(), Replaced.class);
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= replacedArr.length) {
                int length = str.length();
                char[] cArr = new char[length];
                str.getChars(0, length, cArr, 0);
                spannable.setSpan(new Replaced(cArr), i, i2, 33);
                return;
            }
            spannable.removeSpan(replacedArr[i4]);
            i3 = i4 + 1;
        }
    }

    private boolean showCharacterPicker(View view, Editable editable, char c2, boolean z, int i) {
        String str = PICKER_SETS.get(c2);
        if (str == null) {
            return false;
        }
        if (i == 1) {
            new CharacterPickerDialog(view.getContext(), view, editable, str, z).show();
            return true;
        }
        return true;
    }

    private static String toTitleCase(String str) {
        return Character.toUpperCase(str.charAt(0)) + str.substring(1);
    }

    @Override // android.text.method.KeyListener
    public int getInputType() {
        return makeTextContentType(this.mAutoCap, this.mAutoText);
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x003c, code lost:
        if (r0 < 0) goto L205;
     */
    @Override // android.text.method.BaseKeyListener, android.text.method.MetaKeyKeyListener, android.text.method.KeyListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onKeyDown(android.view.View r8, android.text.Editable r9, int r10, android.view.KeyEvent r11) {
        /*
            Method dump skipped, instructions count: 1452
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.text.method.QwertyKeyListener.onKeyDown(android.view.View, android.text.Editable, int, android.view.KeyEvent):boolean");
    }
}
