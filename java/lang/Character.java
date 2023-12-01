package java.lang;

import java.io.Serializable;
import java.util.Arrays;
import okio.Utf8;

@FindBugsSuppressWarnings({"DM_NUMBER_CTOR"})
/* loaded from: source-2895416-dex2jar.jar:java/lang/Character.class */
public final class Character implements Serializable, Comparable<Character> {
    public static final byte COMBINING_SPACING_MARK = 8;
    public static final byte CONNECTOR_PUNCTUATION = 23;
    public static final byte CONTROL = 15;
    public static final byte CURRENCY_SYMBOL = 26;
    public static final byte DASH_PUNCTUATION = 20;
    public static final byte DECIMAL_DIGIT_NUMBER = 9;
    private static final byte[] DIRECTIONALITY = null;
    public static final byte DIRECTIONALITY_ARABIC_NUMBER = 6;
    public static final byte DIRECTIONALITY_BOUNDARY_NEUTRAL = 9;
    public static final byte DIRECTIONALITY_COMMON_NUMBER_SEPARATOR = 7;
    public static final byte DIRECTIONALITY_EUROPEAN_NUMBER = 3;
    public static final byte DIRECTIONALITY_EUROPEAN_NUMBER_SEPARATOR = 4;
    public static final byte DIRECTIONALITY_EUROPEAN_NUMBER_TERMINATOR = 5;
    public static final byte DIRECTIONALITY_LEFT_TO_RIGHT = 0;
    public static final byte DIRECTIONALITY_LEFT_TO_RIGHT_EMBEDDING = 14;
    public static final byte DIRECTIONALITY_LEFT_TO_RIGHT_OVERRIDE = 15;
    public static final byte DIRECTIONALITY_NONSPACING_MARK = 8;
    public static final byte DIRECTIONALITY_OTHER_NEUTRALS = 13;
    public static final byte DIRECTIONALITY_PARAGRAPH_SEPARATOR = 10;
    public static final byte DIRECTIONALITY_POP_DIRECTIONAL_FORMAT = 18;
    public static final byte DIRECTIONALITY_RIGHT_TO_LEFT = 1;
    public static final byte DIRECTIONALITY_RIGHT_TO_LEFT_ARABIC = 2;
    public static final byte DIRECTIONALITY_RIGHT_TO_LEFT_EMBEDDING = 16;
    public static final byte DIRECTIONALITY_RIGHT_TO_LEFT_OVERRIDE = 17;
    public static final byte DIRECTIONALITY_SEGMENT_SEPARATOR = 11;
    public static final byte DIRECTIONALITY_UNDEFINED = -1;
    public static final byte DIRECTIONALITY_WHITESPACE = 12;
    public static final byte ENCLOSING_MARK = 7;
    public static final byte END_PUNCTUATION = 22;
    public static final byte FINAL_QUOTE_PUNCTUATION = 30;
    public static final byte FORMAT = 16;
    public static final byte INITIAL_QUOTE_PUNCTUATION = 29;
    public static final byte LETTER_NUMBER = 10;
    public static final byte LINE_SEPARATOR = 13;
    public static final byte LOWERCASE_LETTER = 2;
    public static final byte MATH_SYMBOL = 25;
    public static final int MAX_CODE_POINT = 1114111;
    public static final char MAX_HIGH_SURROGATE = 56319;
    public static final char MAX_LOW_SURROGATE = 57343;
    public static final int MAX_RADIX = 36;
    public static final char MAX_SURROGATE = 57343;
    public static final char MAX_VALUE = 65535;
    public static final int MIN_CODE_POINT = 0;
    public static final char MIN_HIGH_SURROGATE = 55296;
    public static final char MIN_LOW_SURROGATE = 56320;
    public static final int MIN_RADIX = 2;
    public static final int MIN_SUPPLEMENTARY_CODE_POINT = 65536;
    public static final char MIN_SURROGATE = 55296;
    public static final char MIN_VALUE = 0;
    public static final byte MODIFIER_LETTER = 4;
    public static final byte MODIFIER_SYMBOL = 27;
    public static final byte NON_SPACING_MARK = 6;
    public static final byte OTHER_LETTER = 5;
    public static final byte OTHER_NUMBER = 11;
    public static final byte OTHER_PUNCTUATION = 24;
    public static final byte OTHER_SYMBOL = 28;
    public static final byte PARAGRAPH_SEPARATOR = 14;
    public static final byte PRIVATE_USE = 18;
    public static final int SIZE = 16;
    private static final Character[] SMALL_VALUES = null;
    public static final byte SPACE_SEPARATOR = 12;
    public static final byte START_PUNCTUATION = 21;
    public static final byte SURROGATE = 19;
    public static final byte TITLECASE_LETTER = 3;
    public static final Class<Character> TYPE = null;
    public static final byte UNASSIGNED = 0;
    public static final byte UPPERCASE_LETTER = 1;
    private static final long serialVersionUID = 3786198910865385080L;
    private final char value;

    /* loaded from: source-2895416-dex2jar.jar:java/lang/Character$Subset.class */
    public static class Subset {
        private final String name;

        protected Subset(String str) {
            if (str == null) {
                throw new NullPointerException("name == null");
            }
            this.name = str;
        }

        public final boolean equals(Object obj) {
            return obj == this;
        }

        public final int hashCode() {
            return super.hashCode();
        }

        public final String toString() {
            return this.name;
        }
    }

    /* loaded from: source-2895416-dex2jar.jar:java/lang/Character$UnicodeBlock.class */
    public static final class UnicodeBlock extends Subset {
        @Deprecated
        public static final UnicodeBlock SURROGATES_AREA = new UnicodeBlock("SURROGATES_AREA");
        public static final UnicodeBlock BASIC_LATIN = new UnicodeBlock("BASIC_LATIN");
        public static final UnicodeBlock LATIN_1_SUPPLEMENT = new UnicodeBlock("LATIN_1_SUPPLEMENT");
        public static final UnicodeBlock LATIN_EXTENDED_A = new UnicodeBlock("LATIN_EXTENDED_A");
        public static final UnicodeBlock LATIN_EXTENDED_B = new UnicodeBlock("LATIN_EXTENDED_B");
        public static final UnicodeBlock IPA_EXTENSIONS = new UnicodeBlock("IPA_EXTENSIONS");
        public static final UnicodeBlock SPACING_MODIFIER_LETTERS = new UnicodeBlock("SPACING_MODIFIER_LETTERS");
        public static final UnicodeBlock COMBINING_DIACRITICAL_MARKS = new UnicodeBlock("COMBINING_DIACRITICAL_MARKS");
        public static final UnicodeBlock GREEK = new UnicodeBlock("GREEK");
        public static final UnicodeBlock CYRILLIC = new UnicodeBlock("CYRILLIC");
        public static final UnicodeBlock CYRILLIC_SUPPLEMENTARY = new UnicodeBlock("CYRILLIC_SUPPLEMENTARY");
        public static final UnicodeBlock ARMENIAN = new UnicodeBlock("ARMENIAN");
        public static final UnicodeBlock HEBREW = new UnicodeBlock("HEBREW");
        public static final UnicodeBlock ARABIC = new UnicodeBlock("ARABIC");
        public static final UnicodeBlock SYRIAC = new UnicodeBlock("SYRIAC");
        public static final UnicodeBlock THAANA = new UnicodeBlock("THAANA");
        public static final UnicodeBlock DEVANAGARI = new UnicodeBlock("DEVANAGARI");
        public static final UnicodeBlock BENGALI = new UnicodeBlock("BENGALI");
        public static final UnicodeBlock GURMUKHI = new UnicodeBlock("GURMUKHI");
        public static final UnicodeBlock GUJARATI = new UnicodeBlock("GUJARATI");
        public static final UnicodeBlock ORIYA = new UnicodeBlock("ORIYA");
        public static final UnicodeBlock TAMIL = new UnicodeBlock("TAMIL");
        public static final UnicodeBlock TELUGU = new UnicodeBlock("TELUGU");
        public static final UnicodeBlock KANNADA = new UnicodeBlock("KANNADA");
        public static final UnicodeBlock MALAYALAM = new UnicodeBlock("MALAYALAM");
        public static final UnicodeBlock SINHALA = new UnicodeBlock("SINHALA");
        public static final UnicodeBlock THAI = new UnicodeBlock("THAI");
        public static final UnicodeBlock LAO = new UnicodeBlock("LAO");
        public static final UnicodeBlock TIBETAN = new UnicodeBlock("TIBETAN");
        public static final UnicodeBlock MYANMAR = new UnicodeBlock("MYANMAR");
        public static final UnicodeBlock GEORGIAN = new UnicodeBlock("GEORGIAN");
        public static final UnicodeBlock HANGUL_JAMO = new UnicodeBlock("HANGUL_JAMO");
        public static final UnicodeBlock ETHIOPIC = new UnicodeBlock("ETHIOPIC");
        public static final UnicodeBlock CHEROKEE = new UnicodeBlock("CHEROKEE");
        public static final UnicodeBlock UNIFIED_CANADIAN_ABORIGINAL_SYLLABICS = new UnicodeBlock("UNIFIED_CANADIAN_ABORIGINAL_SYLLABICS");
        public static final UnicodeBlock OGHAM = new UnicodeBlock("OGHAM");
        public static final UnicodeBlock RUNIC = new UnicodeBlock("RUNIC");
        public static final UnicodeBlock TAGALOG = new UnicodeBlock("TAGALOG");
        public static final UnicodeBlock HANUNOO = new UnicodeBlock("HANUNOO");
        public static final UnicodeBlock BUHID = new UnicodeBlock("BUHID");
        public static final UnicodeBlock TAGBANWA = new UnicodeBlock("TAGBANWA");
        public static final UnicodeBlock KHMER = new UnicodeBlock("KHMER");
        public static final UnicodeBlock MONGOLIAN = new UnicodeBlock("MONGOLIAN");
        public static final UnicodeBlock LIMBU = new UnicodeBlock("LIMBU");
        public static final UnicodeBlock TAI_LE = new UnicodeBlock("TAI_LE");
        public static final UnicodeBlock KHMER_SYMBOLS = new UnicodeBlock("KHMER_SYMBOLS");
        public static final UnicodeBlock PHONETIC_EXTENSIONS = new UnicodeBlock("PHONETIC_EXTENSIONS");
        public static final UnicodeBlock LATIN_EXTENDED_ADDITIONAL = new UnicodeBlock("LATIN_EXTENDED_ADDITIONAL");
        public static final UnicodeBlock GREEK_EXTENDED = new UnicodeBlock("GREEK_EXTENDED");
        public static final UnicodeBlock GENERAL_PUNCTUATION = new UnicodeBlock("GENERAL_PUNCTUATION");
        public static final UnicodeBlock SUPERSCRIPTS_AND_SUBSCRIPTS = new UnicodeBlock("SUPERSCRIPTS_AND_SUBSCRIPTS");
        public static final UnicodeBlock CURRENCY_SYMBOLS = new UnicodeBlock("CURRENCY_SYMBOLS");
        public static final UnicodeBlock COMBINING_MARKS_FOR_SYMBOLS = new UnicodeBlock("COMBINING_MARKS_FOR_SYMBOLS");
        public static final UnicodeBlock LETTERLIKE_SYMBOLS = new UnicodeBlock("LETTERLIKE_SYMBOLS");
        public static final UnicodeBlock NUMBER_FORMS = new UnicodeBlock("NUMBER_FORMS");
        public static final UnicodeBlock ARROWS = new UnicodeBlock("ARROWS");
        public static final UnicodeBlock MATHEMATICAL_OPERATORS = new UnicodeBlock("MATHEMATICAL_OPERATORS");
        public static final UnicodeBlock MISCELLANEOUS_TECHNICAL = new UnicodeBlock("MISCELLANEOUS_TECHNICAL");
        public static final UnicodeBlock CONTROL_PICTURES = new UnicodeBlock("CONTROL_PICTURES");
        public static final UnicodeBlock OPTICAL_CHARACTER_RECOGNITION = new UnicodeBlock("OPTICAL_CHARACTER_RECOGNITION");
        public static final UnicodeBlock ENCLOSED_ALPHANUMERICS = new UnicodeBlock("ENCLOSED_ALPHANUMERICS");
        public static final UnicodeBlock BOX_DRAWING = new UnicodeBlock("BOX_DRAWING");
        public static final UnicodeBlock BLOCK_ELEMENTS = new UnicodeBlock("BLOCK_ELEMENTS");
        public static final UnicodeBlock GEOMETRIC_SHAPES = new UnicodeBlock("GEOMETRIC_SHAPES");
        public static final UnicodeBlock MISCELLANEOUS_SYMBOLS = new UnicodeBlock("MISCELLANEOUS_SYMBOLS");
        public static final UnicodeBlock DINGBATS = new UnicodeBlock("DINGBATS");
        public static final UnicodeBlock MISCELLANEOUS_MATHEMATICAL_SYMBOLS_A = new UnicodeBlock("MISCELLANEOUS_MATHEMATICAL_SYMBOLS_A");
        public static final UnicodeBlock SUPPLEMENTAL_ARROWS_A = new UnicodeBlock("SUPPLEMENTAL_ARROWS_A");
        public static final UnicodeBlock BRAILLE_PATTERNS = new UnicodeBlock("BRAILLE_PATTERNS");
        public static final UnicodeBlock SUPPLEMENTAL_ARROWS_B = new UnicodeBlock("SUPPLEMENTAL_ARROWS_B");
        public static final UnicodeBlock MISCELLANEOUS_MATHEMATICAL_SYMBOLS_B = new UnicodeBlock("MISCELLANEOUS_MATHEMATICAL_SYMBOLS_B");
        public static final UnicodeBlock SUPPLEMENTAL_MATHEMATICAL_OPERATORS = new UnicodeBlock("SUPPLEMENTAL_MATHEMATICAL_OPERATORS");
        public static final UnicodeBlock MISCELLANEOUS_SYMBOLS_AND_ARROWS = new UnicodeBlock("MISCELLANEOUS_SYMBOLS_AND_ARROWS");
        public static final UnicodeBlock CJK_RADICALS_SUPPLEMENT = new UnicodeBlock("CJK_RADICALS_SUPPLEMENT");
        public static final UnicodeBlock KANGXI_RADICALS = new UnicodeBlock("KANGXI_RADICALS");
        public static final UnicodeBlock IDEOGRAPHIC_DESCRIPTION_CHARACTERS = new UnicodeBlock("IDEOGRAPHIC_DESCRIPTION_CHARACTERS");
        public static final UnicodeBlock CJK_SYMBOLS_AND_PUNCTUATION = new UnicodeBlock("CJK_SYMBOLS_AND_PUNCTUATION");
        public static final UnicodeBlock HIRAGANA = new UnicodeBlock("HIRAGANA");
        public static final UnicodeBlock KATAKANA = new UnicodeBlock("KATAKANA");
        public static final UnicodeBlock BOPOMOFO = new UnicodeBlock("BOPOMOFO");
        public static final UnicodeBlock HANGUL_COMPATIBILITY_JAMO = new UnicodeBlock("HANGUL_COMPATIBILITY_JAMO");
        public static final UnicodeBlock KANBUN = new UnicodeBlock("KANBUN");
        public static final UnicodeBlock BOPOMOFO_EXTENDED = new UnicodeBlock("BOPOMOFO_EXTENDED");
        public static final UnicodeBlock KATAKANA_PHONETIC_EXTENSIONS = new UnicodeBlock("KATAKANA_PHONETIC_EXTENSIONS");
        public static final UnicodeBlock ENCLOSED_CJK_LETTERS_AND_MONTHS = new UnicodeBlock("ENCLOSED_CJK_LETTERS_AND_MONTHS");
        public static final UnicodeBlock CJK_COMPATIBILITY = new UnicodeBlock("CJK_COMPATIBILITY");
        public static final UnicodeBlock CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A = new UnicodeBlock("CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A");
        public static final UnicodeBlock YIJING_HEXAGRAM_SYMBOLS = new UnicodeBlock("YIJING_HEXAGRAM_SYMBOLS");
        public static final UnicodeBlock CJK_UNIFIED_IDEOGRAPHS = new UnicodeBlock("CJK_UNIFIED_IDEOGRAPHS");
        public static final UnicodeBlock YI_SYLLABLES = new UnicodeBlock("YI_SYLLABLES");
        public static final UnicodeBlock YI_RADICALS = new UnicodeBlock("YI_RADICALS");
        public static final UnicodeBlock HANGUL_SYLLABLES = new UnicodeBlock("HANGUL_SYLLABLES");
        public static final UnicodeBlock HIGH_SURROGATES = new UnicodeBlock("HIGH_SURROGATES");
        public static final UnicodeBlock HIGH_PRIVATE_USE_SURROGATES = new UnicodeBlock("HIGH_PRIVATE_USE_SURROGATES");
        public static final UnicodeBlock LOW_SURROGATES = new UnicodeBlock("LOW_SURROGATES");
        public static final UnicodeBlock PRIVATE_USE_AREA = new UnicodeBlock("PRIVATE_USE_AREA");
        public static final UnicodeBlock CJK_COMPATIBILITY_IDEOGRAPHS = new UnicodeBlock("CJK_COMPATIBILITY_IDEOGRAPHS");
        public static final UnicodeBlock ALPHABETIC_PRESENTATION_FORMS = new UnicodeBlock("ALPHABETIC_PRESENTATION_FORMS");
        public static final UnicodeBlock ARABIC_PRESENTATION_FORMS_A = new UnicodeBlock("ARABIC_PRESENTATION_FORMS_A");
        public static final UnicodeBlock VARIATION_SELECTORS = new UnicodeBlock("VARIATION_SELECTORS");
        public static final UnicodeBlock COMBINING_HALF_MARKS = new UnicodeBlock("COMBINING_HALF_MARKS");
        public static final UnicodeBlock CJK_COMPATIBILITY_FORMS = new UnicodeBlock("CJK_COMPATIBILITY_FORMS");
        public static final UnicodeBlock SMALL_FORM_VARIANTS = new UnicodeBlock("SMALL_FORM_VARIANTS");
        public static final UnicodeBlock ARABIC_PRESENTATION_FORMS_B = new UnicodeBlock("ARABIC_PRESENTATION_FORMS_B");
        public static final UnicodeBlock HALFWIDTH_AND_FULLWIDTH_FORMS = new UnicodeBlock("HALFWIDTH_AND_FULLWIDTH_FORMS");
        public static final UnicodeBlock SPECIALS = new UnicodeBlock("SPECIALS");
        public static final UnicodeBlock LINEAR_B_SYLLABARY = new UnicodeBlock("LINEAR_B_SYLLABARY");
        public static final UnicodeBlock LINEAR_B_IDEOGRAMS = new UnicodeBlock("LINEAR_B_IDEOGRAMS");
        public static final UnicodeBlock AEGEAN_NUMBERS = new UnicodeBlock("AEGEAN_NUMBERS");
        public static final UnicodeBlock OLD_ITALIC = new UnicodeBlock("OLD_ITALIC");
        public static final UnicodeBlock GOTHIC = new UnicodeBlock("GOTHIC");
        public static final UnicodeBlock UGARITIC = new UnicodeBlock("UGARITIC");
        public static final UnicodeBlock DESERET = new UnicodeBlock("DESERET");
        public static final UnicodeBlock SHAVIAN = new UnicodeBlock("SHAVIAN");
        public static final UnicodeBlock OSMANYA = new UnicodeBlock("OSMANYA");
        public static final UnicodeBlock CYPRIOT_SYLLABARY = new UnicodeBlock("CYPRIOT_SYLLABARY");
        public static final UnicodeBlock BYZANTINE_MUSICAL_SYMBOLS = new UnicodeBlock("BYZANTINE_MUSICAL_SYMBOLS");
        public static final UnicodeBlock MUSICAL_SYMBOLS = new UnicodeBlock("MUSICAL_SYMBOLS");
        public static final UnicodeBlock TAI_XUAN_JING_SYMBOLS = new UnicodeBlock("TAI_XUAN_JING_SYMBOLS");
        public static final UnicodeBlock MATHEMATICAL_ALPHANUMERIC_SYMBOLS = new UnicodeBlock("MATHEMATICAL_ALPHANUMERIC_SYMBOLS");
        public static final UnicodeBlock CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B = new UnicodeBlock("CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B");
        public static final UnicodeBlock CJK_COMPATIBILITY_IDEOGRAPHS_SUPPLEMENT = new UnicodeBlock("CJK_COMPATIBILITY_IDEOGRAPHS_SUPPLEMENT");
        public static final UnicodeBlock TAGS = new UnicodeBlock("TAGS");
        public static final UnicodeBlock VARIATION_SELECTORS_SUPPLEMENT = new UnicodeBlock("VARIATION_SELECTORS_SUPPLEMENT");
        public static final UnicodeBlock SUPPLEMENTARY_PRIVATE_USE_AREA_A = new UnicodeBlock("SUPPLEMENTARY_PRIVATE_USE_AREA_A");
        public static final UnicodeBlock SUPPLEMENTARY_PRIVATE_USE_AREA_B = new UnicodeBlock("SUPPLEMENTARY_PRIVATE_USE_AREA_B");
        public static final UnicodeBlock ANCIENT_GREEK_MUSICAL_NOTATION = new UnicodeBlock("ANCIENT_GREEK_MUSICAL_NOTATION");
        public static final UnicodeBlock ANCIENT_GREEK_NUMBERS = new UnicodeBlock("ANCIENT_GREEK_NUMBERS");
        public static final UnicodeBlock ARABIC_SUPPLEMENT = new UnicodeBlock("ARABIC_SUPPLEMENT");
        public static final UnicodeBlock BUGINESE = new UnicodeBlock("BUGINESE");
        public static final UnicodeBlock CJK_STROKES = new UnicodeBlock("CJK_STROKES");
        public static final UnicodeBlock COMBINING_DIACRITICAL_MARKS_SUPPLEMENT = new UnicodeBlock("COMBINING_DIACRITICAL_MARKS_SUPPLEMENT");
        public static final UnicodeBlock COPTIC = new UnicodeBlock("COPTIC");
        public static final UnicodeBlock ETHIOPIC_EXTENDED = new UnicodeBlock("ETHIOPIC_EXTENDED");
        public static final UnicodeBlock ETHIOPIC_SUPPLEMENT = new UnicodeBlock("ETHIOPIC_SUPPLEMENT");
        public static final UnicodeBlock GEORGIAN_SUPPLEMENT = new UnicodeBlock("GEORGIAN_SUPPLEMENT");
        public static final UnicodeBlock GLAGOLITIC = new UnicodeBlock("GLAGOLITIC");
        public static final UnicodeBlock KHAROSHTHI = new UnicodeBlock("KHAROSHTHI");
        public static final UnicodeBlock MODIFIER_TONE_LETTERS = new UnicodeBlock("MODIFIER_TONE_LETTERS");
        public static final UnicodeBlock NEW_TAI_LUE = new UnicodeBlock("NEW_TAI_LUE");
        public static final UnicodeBlock OLD_PERSIAN = new UnicodeBlock("OLD_PERSIAN");
        public static final UnicodeBlock PHONETIC_EXTENSIONS_SUPPLEMENT = new UnicodeBlock("PHONETIC_EXTENSIONS_SUPPLEMENT");
        public static final UnicodeBlock SUPPLEMENTAL_PUNCTUATION = new UnicodeBlock("SUPPLEMENTAL_PUNCTUATION");
        public static final UnicodeBlock SYLOTI_NAGRI = new UnicodeBlock("SYLOTI_NAGRI");
        public static final UnicodeBlock TIFINAGH = new UnicodeBlock("TIFINAGH");
        public static final UnicodeBlock VERTICAL_FORMS = new UnicodeBlock("VERTICAL_FORMS");
        public static final UnicodeBlock NKO = new UnicodeBlock("NKO");
        public static final UnicodeBlock BALINESE = new UnicodeBlock("BALINESE");
        public static final UnicodeBlock LATIN_EXTENDED_C = new UnicodeBlock("LATIN_EXTENDED_C");
        public static final UnicodeBlock LATIN_EXTENDED_D = new UnicodeBlock("LATIN_EXTENDED_D");
        public static final UnicodeBlock PHAGS_PA = new UnicodeBlock("PHAGS_PA");
        public static final UnicodeBlock PHOENICIAN = new UnicodeBlock("PHOENICIAN");
        public static final UnicodeBlock CUNEIFORM = new UnicodeBlock("CUNEIFORM");
        public static final UnicodeBlock CUNEIFORM_NUMBERS_AND_PUNCTUATION = new UnicodeBlock("CUNEIFORM_NUMBERS_AND_PUNCTUATION");
        public static final UnicodeBlock COUNTING_ROD_NUMERALS = new UnicodeBlock("COUNTING_ROD_NUMERALS");
        public static final UnicodeBlock SUNDANESE = new UnicodeBlock("SUNDANESE");
        public static final UnicodeBlock LEPCHA = new UnicodeBlock("LEPCHA");
        public static final UnicodeBlock OL_CHIKI = new UnicodeBlock("OL_CHIKI");
        public static final UnicodeBlock CYRILLIC_EXTENDED_A = new UnicodeBlock("CYRILLIC_EXTENDED_A");
        public static final UnicodeBlock VAI = new UnicodeBlock("VAI");
        public static final UnicodeBlock CYRILLIC_EXTENDED_B = new UnicodeBlock("CYRILLIC_EXTENDED_B");
        public static final UnicodeBlock SAURASHTRA = new UnicodeBlock("SAURASHTRA");
        public static final UnicodeBlock KAYAH_LI = new UnicodeBlock("KAYAH_LI");
        public static final UnicodeBlock REJANG = new UnicodeBlock("REJANG");
        public static final UnicodeBlock CHAM = new UnicodeBlock("CHAM");
        public static final UnicodeBlock ANCIENT_SYMBOLS = new UnicodeBlock("ANCIENT_SYMBOLS");
        public static final UnicodeBlock PHAISTOS_DISC = new UnicodeBlock("PHAISTOS_DISC");
        public static final UnicodeBlock LYCIAN = new UnicodeBlock("LYCIAN");
        public static final UnicodeBlock CARIAN = new UnicodeBlock("CARIAN");
        public static final UnicodeBlock LYDIAN = new UnicodeBlock("LYDIAN");
        public static final UnicodeBlock MAHJONG_TILES = new UnicodeBlock("MAHJONG_TILES");
        public static final UnicodeBlock DOMINO_TILES = new UnicodeBlock("DOMINO_TILES");
        public static final UnicodeBlock SAMARITAN = new UnicodeBlock("SAMARITAN");
        public static final UnicodeBlock UNIFIED_CANADIAN_ABORIGINAL_SYLLABICS_EXTENDED = new UnicodeBlock("UNIFIED_CANADIAN_ABORIGINAL_SYLLABICS_EXTENDED");
        public static final UnicodeBlock TAI_THAM = new UnicodeBlock("TAI_THAM");
        public static final UnicodeBlock VEDIC_EXTENSIONS = new UnicodeBlock("VEDIC_EXTENSIONS");
        public static final UnicodeBlock LISU = new UnicodeBlock("LISU");
        public static final UnicodeBlock BAMUM = new UnicodeBlock("BAMUM");
        public static final UnicodeBlock COMMON_INDIC_NUMBER_FORMS = new UnicodeBlock("COMMON_INDIC_NUMBER_FORMS");
        public static final UnicodeBlock DEVANAGARI_EXTENDED = new UnicodeBlock("DEVANAGARI_EXTENDED");
        public static final UnicodeBlock HANGUL_JAMO_EXTENDED_A = new UnicodeBlock("HANGUL_JAMO_EXTENDED_A");
        public static final UnicodeBlock JAVANESE = new UnicodeBlock("JAVANESE");
        public static final UnicodeBlock MYANMAR_EXTENDED_A = new UnicodeBlock("MYANMAR_EXTENDED_A");
        public static final UnicodeBlock TAI_VIET = new UnicodeBlock("TAI_VIET");
        public static final UnicodeBlock MEETEI_MAYEK = new UnicodeBlock("MEETEI_MAYEK");
        public static final UnicodeBlock HANGUL_JAMO_EXTENDED_B = new UnicodeBlock("HANGUL_JAMO_EXTENDED_B");
        public static final UnicodeBlock IMPERIAL_ARAMAIC = new UnicodeBlock("IMPERIAL_ARAMAIC");
        public static final UnicodeBlock OLD_SOUTH_ARABIAN = new UnicodeBlock("OLD_SOUTH_ARABIAN");
        public static final UnicodeBlock AVESTAN = new UnicodeBlock("AVESTAN");
        public static final UnicodeBlock INSCRIPTIONAL_PARTHIAN = new UnicodeBlock("INSCRIPTIONAL_PARTHIAN");
        public static final UnicodeBlock INSCRIPTIONAL_PAHLAVI = new UnicodeBlock("INSCRIPTIONAL_PAHLAVI");
        public static final UnicodeBlock OLD_TURKIC = new UnicodeBlock("OLD_TURKIC");
        public static final UnicodeBlock RUMI_NUMERAL_SYMBOLS = new UnicodeBlock("RUMI_NUMERAL_SYMBOLS");
        public static final UnicodeBlock KAITHI = new UnicodeBlock("KAITHI");
        public static final UnicodeBlock EGYPTIAN_HIEROGLYPHS = new UnicodeBlock("EGYPTIAN_HIEROGLYPHS");
        public static final UnicodeBlock ENCLOSED_ALPHANUMERIC_SUPPLEMENT = new UnicodeBlock("ENCLOSED_ALPHANUMERIC_SUPPLEMENT");
        public static final UnicodeBlock ENCLOSED_IDEOGRAPHIC_SUPPLEMENT = new UnicodeBlock("ENCLOSED_IDEOGRAPHIC_SUPPLEMENT");
        public static final UnicodeBlock CJK_UNIFIED_IDEOGRAPHS_EXTENSION_C = new UnicodeBlock("CJK_UNIFIED_IDEOGRAPHS_EXTENSION_C");
        public static final UnicodeBlock MANDAIC = new UnicodeBlock("MANDAIC");
        public static final UnicodeBlock BATAK = new UnicodeBlock("BATAK");
        public static final UnicodeBlock ETHIOPIC_EXTENDED_A = new UnicodeBlock("ETHIOPIC_EXTENDED_A");
        public static final UnicodeBlock BRAHMI = new UnicodeBlock("BRAHMI");
        public static final UnicodeBlock BAMUM_SUPPLEMENT = new UnicodeBlock("BAMUM_SUPPLEMENT");
        public static final UnicodeBlock KANA_SUPPLEMENT = new UnicodeBlock("KANA_SUPPLEMENT");
        public static final UnicodeBlock PLAYING_CARDS = new UnicodeBlock("PLAYING_CARDS");
        public static final UnicodeBlock MISCELLANEOUS_SYMBOLS_AND_PICTOGRAPHS = new UnicodeBlock("MISCELLANEOUS_SYMBOLS_AND_PICTOGRAPHS");
        public static final UnicodeBlock EMOTICONS = new UnicodeBlock("EMOTICONS");
        public static final UnicodeBlock TRANSPORT_AND_MAP_SYMBOLS = new UnicodeBlock("TRANSPORT_AND_MAP_SYMBOLS");
        public static final UnicodeBlock ALCHEMICAL_SYMBOLS = new UnicodeBlock("ALCHEMICAL_SYMBOLS");
        public static final UnicodeBlock CJK_UNIFIED_IDEOGRAPHS_EXTENSION_D = new UnicodeBlock("CJK_UNIFIED_IDEOGRAPHS_EXTENSION_D");
        private static UnicodeBlock[] BLOCKS = {null, BASIC_LATIN, LATIN_1_SUPPLEMENT, LATIN_EXTENDED_A, LATIN_EXTENDED_B, IPA_EXTENSIONS, SPACING_MODIFIER_LETTERS, COMBINING_DIACRITICAL_MARKS, GREEK, CYRILLIC, ARMENIAN, HEBREW, ARABIC, SYRIAC, THAANA, DEVANAGARI, BENGALI, GURMUKHI, GUJARATI, ORIYA, TAMIL, TELUGU, KANNADA, MALAYALAM, SINHALA, THAI, LAO, TIBETAN, MYANMAR, GEORGIAN, HANGUL_JAMO, ETHIOPIC, CHEROKEE, UNIFIED_CANADIAN_ABORIGINAL_SYLLABICS, OGHAM, RUNIC, KHMER, MONGOLIAN, LATIN_EXTENDED_ADDITIONAL, GREEK_EXTENDED, GENERAL_PUNCTUATION, SUPERSCRIPTS_AND_SUBSCRIPTS, CURRENCY_SYMBOLS, COMBINING_MARKS_FOR_SYMBOLS, LETTERLIKE_SYMBOLS, NUMBER_FORMS, ARROWS, MATHEMATICAL_OPERATORS, MISCELLANEOUS_TECHNICAL, CONTROL_PICTURES, OPTICAL_CHARACTER_RECOGNITION, ENCLOSED_ALPHANUMERICS, BOX_DRAWING, BLOCK_ELEMENTS, GEOMETRIC_SHAPES, MISCELLANEOUS_SYMBOLS, DINGBATS, BRAILLE_PATTERNS, CJK_RADICALS_SUPPLEMENT, KANGXI_RADICALS, IDEOGRAPHIC_DESCRIPTION_CHARACTERS, CJK_SYMBOLS_AND_PUNCTUATION, HIRAGANA, KATAKANA, BOPOMOFO, HANGUL_COMPATIBILITY_JAMO, KANBUN, BOPOMOFO_EXTENDED, ENCLOSED_CJK_LETTERS_AND_MONTHS, CJK_COMPATIBILITY, CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A, CJK_UNIFIED_IDEOGRAPHS, YI_SYLLABLES, YI_RADICALS, HANGUL_SYLLABLES, HIGH_SURROGATES, HIGH_PRIVATE_USE_SURROGATES, LOW_SURROGATES, PRIVATE_USE_AREA, CJK_COMPATIBILITY_IDEOGRAPHS, ALPHABETIC_PRESENTATION_FORMS, ARABIC_PRESENTATION_FORMS_A, COMBINING_HALF_MARKS, CJK_COMPATIBILITY_FORMS, SMALL_FORM_VARIANTS, ARABIC_PRESENTATION_FORMS_B, SPECIALS, HALFWIDTH_AND_FULLWIDTH_FORMS, OLD_ITALIC, GOTHIC, DESERET, BYZANTINE_MUSICAL_SYMBOLS, MUSICAL_SYMBOLS, MATHEMATICAL_ALPHANUMERIC_SYMBOLS, CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B, CJK_COMPATIBILITY_IDEOGRAPHS_SUPPLEMENT, TAGS, CYRILLIC_SUPPLEMENTARY, TAGALOG, HANUNOO, BUHID, TAGBANWA, MISCELLANEOUS_MATHEMATICAL_SYMBOLS_A, SUPPLEMENTAL_ARROWS_A, SUPPLEMENTAL_ARROWS_B, MISCELLANEOUS_MATHEMATICAL_SYMBOLS_B, SUPPLEMENTAL_MATHEMATICAL_OPERATORS, KATAKANA_PHONETIC_EXTENSIONS, VARIATION_SELECTORS, SUPPLEMENTARY_PRIVATE_USE_AREA_A, SUPPLEMENTARY_PRIVATE_USE_AREA_B, LIMBU, TAI_LE, KHMER_SYMBOLS, PHONETIC_EXTENSIONS, MISCELLANEOUS_SYMBOLS_AND_ARROWS, YIJING_HEXAGRAM_SYMBOLS, LINEAR_B_SYLLABARY, LINEAR_B_IDEOGRAMS, AEGEAN_NUMBERS, UGARITIC, SHAVIAN, OSMANYA, CYPRIOT_SYLLABARY, TAI_XUAN_JING_SYMBOLS, VARIATION_SELECTORS_SUPPLEMENT, ANCIENT_GREEK_MUSICAL_NOTATION, ANCIENT_GREEK_NUMBERS, ARABIC_SUPPLEMENT, BUGINESE, CJK_STROKES, COMBINING_DIACRITICAL_MARKS_SUPPLEMENT, COPTIC, ETHIOPIC_EXTENDED, ETHIOPIC_SUPPLEMENT, GEORGIAN_SUPPLEMENT, GLAGOLITIC, KHAROSHTHI, MODIFIER_TONE_LETTERS, NEW_TAI_LUE, OLD_PERSIAN, PHONETIC_EXTENSIONS_SUPPLEMENT, SUPPLEMENTAL_PUNCTUATION, SYLOTI_NAGRI, TIFINAGH, VERTICAL_FORMS, NKO, BALINESE, LATIN_EXTENDED_C, LATIN_EXTENDED_D, PHAGS_PA, PHOENICIAN, CUNEIFORM, CUNEIFORM_NUMBERS_AND_PUNCTUATION, COUNTING_ROD_NUMERALS, SUNDANESE, LEPCHA, OL_CHIKI, CYRILLIC_EXTENDED_A, VAI, CYRILLIC_EXTENDED_B, SAURASHTRA, KAYAH_LI, REJANG, CHAM, ANCIENT_SYMBOLS, PHAISTOS_DISC, LYCIAN, CARIAN, LYDIAN, MAHJONG_TILES, DOMINO_TILES, SAMARITAN, UNIFIED_CANADIAN_ABORIGINAL_SYLLABICS_EXTENDED, TAI_THAM, VEDIC_EXTENSIONS, LISU, BAMUM, COMMON_INDIC_NUMBER_FORMS, DEVANAGARI_EXTENDED, HANGUL_JAMO_EXTENDED_A, JAVANESE, MYANMAR_EXTENDED_A, TAI_VIET, MEETEI_MAYEK, HANGUL_JAMO_EXTENDED_B, IMPERIAL_ARAMAIC, OLD_SOUTH_ARABIAN, AVESTAN, INSCRIPTIONAL_PARTHIAN, INSCRIPTIONAL_PAHLAVI, OLD_TURKIC, RUMI_NUMERAL_SYMBOLS, KAITHI, EGYPTIAN_HIEROGLYPHS, ENCLOSED_ALPHANUMERIC_SUPPLEMENT, ENCLOSED_IDEOGRAPHIC_SUPPLEMENT, CJK_UNIFIED_IDEOGRAPHS_EXTENSION_C, MANDAIC, BATAK, ETHIOPIC_EXTENDED_A, BRAHMI, BAMUM_SUPPLEMENT, KANA_SUPPLEMENT, PLAYING_CARDS, MISCELLANEOUS_SYMBOLS_AND_PICTOGRAPHS, EMOTICONS, TRANSPORT_AND_MAP_SYMBOLS, ALCHEMICAL_SYMBOLS, CJK_UNIFIED_IDEOGRAPHS_EXTENSION_D};

        private UnicodeBlock(String str) {
            super(str);
        }

        public static UnicodeBlock forName(String str) {
            if (str == null) {
                throw new NullPointerException("blockName == null");
            }
            int unicodeBlockForName = Character.unicodeBlockForName(str);
            if (unicodeBlockForName == -1) {
                throw new IllegalArgumentException("Unknown block: " + str);
            }
            return BLOCKS[unicodeBlockForName];
        }

        public static UnicodeBlock of(char c2) {
            return of((int) c2);
        }

        public static UnicodeBlock of(int i) {
            Character.checkValidCodePoint(i);
            int unicodeBlockForCodePoint = Character.unicodeBlockForCodePoint(i);
            if (unicodeBlockForCodePoint == -1 || unicodeBlockForCodePoint >= BLOCKS.length) {
                return null;
            }
            return BLOCKS[unicodeBlockForCodePoint];
        }
    }

    static {
        throw new VerifyError("bad dex opcode");
    }

    public Character(char c2) {
        this.value = c2;
    }

    public static int charCount(int i) {
        return i >= 65536 ? 2 : 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void checkValidCodePoint(int i) {
        if (!isValidCodePoint(i)) {
            throw new IllegalArgumentException("Invalid code point: " + i);
        }
    }

    public static int codePointAt(CharSequence charSequence, int i) {
        if (charSequence == null) {
            throw new NullPointerException("seq == null");
        }
        int length = charSequence.length();
        if (i < 0 || i >= length) {
            throw new IndexOutOfBoundsException();
        }
        int i2 = i + 1;
        char charAt = charSequence.charAt(i);
        if (i2 < length) {
            char charAt2 = charSequence.charAt(i2);
            if (isSurrogatePair(charAt, charAt2)) {
                return toCodePoint(charAt, charAt2);
            }
        }
        return charAt;
    }

    public static int codePointAt(char[] cArr, int i) {
        if (cArr == null) {
            throw new NullPointerException("seq == null");
        }
        int length = cArr.length;
        if (i < 0 || i >= length) {
            throw new IndexOutOfBoundsException();
        }
        int i2 = i + 1;
        char c2 = cArr[i];
        if (i2 < length) {
            char c3 = cArr[i2];
            if (isSurrogatePair(c2, c3)) {
                return toCodePoint(c2, c3);
            }
        }
        return c2;
    }

    public static int codePointAt(char[] cArr, int i, int i2) {
        if (i < 0 || i >= i2 || i2 < 0 || i2 > cArr.length) {
            throw new IndexOutOfBoundsException();
        }
        int i3 = i + 1;
        char c2 = cArr[i];
        if (i3 < i2) {
            char c3 = cArr[i3];
            if (isSurrogatePair(c2, c3)) {
                return toCodePoint(c2, c3);
            }
        }
        return c2;
    }

    public static int codePointBefore(CharSequence charSequence, int i) {
        if (charSequence == null) {
            throw new NullPointerException("seq == null");
        }
        int length = charSequence.length();
        if (i < 1 || i > length) {
            throw new IndexOutOfBoundsException();
        }
        int i2 = i - 1;
        char charAt = charSequence.charAt(i2);
        int i3 = i2 - 1;
        if (i3 >= 0) {
            char charAt2 = charSequence.charAt(i3);
            if (isSurrogatePair(charAt2, charAt)) {
                return toCodePoint(charAt2, charAt);
            }
        }
        return charAt;
    }

    public static int codePointBefore(char[] cArr, int i) {
        if (cArr == null) {
            throw new NullPointerException("seq == null");
        }
        int length = cArr.length;
        if (i < 1 || i > length) {
            throw new IndexOutOfBoundsException();
        }
        int i2 = i - 1;
        char c2 = cArr[i2];
        int i3 = i2 - 1;
        if (i3 >= 0) {
            char c3 = cArr[i3];
            if (isSurrogatePair(c3, c2)) {
                return toCodePoint(c3, c2);
            }
        }
        return c2;
    }

    public static int codePointBefore(char[] cArr, int i, int i2) {
        if (cArr == null) {
            throw new NullPointerException("seq == null");
        }
        int length = cArr.length;
        if (i <= i2 || i > length || i2 < 0 || i2 >= length) {
            throw new IndexOutOfBoundsException();
        }
        int i3 = i - 1;
        char c2 = cArr[i3];
        int i4 = i3 - 1;
        if (i4 >= i2) {
            char c3 = cArr[i4];
            if (isSurrogatePair(c3, c2)) {
                return toCodePoint(c3, c2);
            }
        }
        return c2;
    }

    public static int codePointCount(CharSequence charSequence, int i, int i2) {
        if (charSequence == null) {
            throw new NullPointerException("seq == null");
        }
        int length = charSequence.length();
        if (i < 0 || i2 > length || i > i2) {
            throw new IndexOutOfBoundsException();
        }
        int i3 = i;
        int i4 = 0;
        while (i3 < i2) {
            int i5 = i3;
            int i6 = i4;
            if (isHighSurrogate(charSequence.charAt(i3))) {
                int i7 = i3 + 1;
                i5 = i7;
                i6 = i4;
                if (i7 < i2) {
                    i5 = i7;
                    i6 = i4;
                    if (!isLowSurrogate(charSequence.charAt(i7))) {
                        i6 = i4 + 1;
                        i5 = i7;
                    }
                }
            }
            i4 = i6 + 1;
            i3 = i5 + 1;
        }
        return i4;
    }

    public static int codePointCount(char[] cArr, int i, int i2) {
        Arrays.checkOffsetAndCount(cArr.length, i, i2);
        int i3 = i + i2;
        int i4 = i;
        int i5 = 0;
        while (i4 < i3) {
            int i6 = i4;
            int i7 = i5;
            if (isHighSurrogate(cArr[i4])) {
                int i8 = i4 + 1;
                i6 = i8;
                i7 = i5;
                if (i8 < i3) {
                    i6 = i8;
                    i7 = i5;
                    if (!isLowSurrogate(cArr[i8])) {
                        i7 = i5 + 1;
                        i6 = i8;
                    }
                }
            }
            i5 = i7 + 1;
            i4 = i6 + 1;
        }
        return i5;
    }

    public static int compare(char c2, char c3) {
        return c2 - c3;
    }

    public static int digit(char c2, int i) {
        return digit((int) c2, i);
    }

    public static int digit(int i, int i2) {
        int i3;
        int i4;
        if (i2 < 2 || i2 > 36) {
            i3 = -1;
        } else if (i >= 128) {
            return digitImpl(i, i2);
        } else {
            if (48 <= i && i <= 57) {
                i4 = i - 48;
            } else if (97 > i || i > 122) {
                i4 = -1;
                if (65 <= i) {
                    i4 = -1;
                    if (i <= 90) {
                        i4 = (i - 65) + 10;
                    }
                }
            } else {
                i4 = (i - 97) + 10;
            }
            i3 = i4;
            if (i4 >= i2) {
                return -1;
            }
        }
        return i3;
    }

    private static native int digitImpl(int i, int i2);

    public static char forDigit(int i, int i2) {
        if (2 > i2 || i2 > 36 || i < 0 || i >= i2) {
            return (char) 0;
        }
        return (char) (i < 10 ? i + 48 : (i + 97) - 10);
    }

    public static byte getDirectionality(char c2) {
        return getDirectionality((int) c2);
    }

    public static byte getDirectionality(int i) {
        byte icuDirectionality;
        if (getType(i) != 0 && (icuDirectionality = getIcuDirectionality(i)) >= 0 && icuDirectionality < DIRECTIONALITY.length) {
            return DIRECTIONALITY[icuDirectionality];
        }
        return (byte) -1;
    }

    public static native byte getIcuDirectionality(int i);

    public static String getName(int i) {
        String str;
        checkValidCodePoint(i);
        if (getType(i) == 0) {
            str = null;
        } else {
            String nameImpl = getNameImpl(i);
            str = nameImpl;
            if (nameImpl == null) {
                return UnicodeBlock.of(i).toString().replace('_', ' ') + " " + IntegralToString.intToHexString(i, true, 0);
            }
        }
        return str;
    }

    private static native String getNameImpl(int i);

    public static int getNumericValue(char c2) {
        return getNumericValue((int) c2);
    }

    public static int getNumericValue(int i) {
        if (i >= 128) {
            return (i < 65313 || i > 65338) ? (i < 65345 || i > 65370) ? getNumericValueImpl(i) : i - 65335 : i - 65303;
        } else if (i < 48 || i > 57) {
            if (i < 97 || i > 122) {
                if (i < 65 || i > 90) {
                    return -1;
                }
                return i - 55;
            }
            return i - 87;
        } else {
            return i - 48;
        }
    }

    private static native int getNumericValueImpl(int i);

    public static int getType(char c2) {
        return getType((int) c2);
    }

    public static int getType(int i) {
        int typeImpl = getTypeImpl(i);
        return typeImpl <= 16 ? typeImpl : typeImpl + 1;
    }

    private static native int getTypeImpl(int i);

    public static char highSurrogate(int i) {
        return (char) ((i >> 10) + Utf8.HIGH_SURROGATE_HEADER);
    }

    public static native boolean isAlphabetic(int i);

    public static boolean isBmpCodePoint(int i) {
        return i >= 0 && i <= 65535;
    }

    public static boolean isDefined(char c2) {
        return isDefinedImpl(c2);
    }

    public static boolean isDefined(int i) {
        return isDefinedImpl(i);
    }

    private static native boolean isDefinedImpl(int i);

    public static boolean isDigit(char c2) {
        return isDigit((int) c2);
    }

    public static boolean isDigit(int i) {
        if (48 > i || i > 57) {
            if (i < 1632) {
                return false;
            }
            return isDigitImpl(i);
        }
        return true;
    }

    private static native boolean isDigitImpl(int i);

    public static boolean isHighSurrogate(char c2) {
        return 55296 <= c2 && 56319 >= c2;
    }

    public static boolean isISOControl(char c2) {
        return isISOControl((int) c2);
    }

    public static boolean isISOControl(int i) {
        if (i < 0 || i > 31) {
            return i >= 127 && i <= 159;
        }
        return true;
    }

    public static boolean isIdentifierIgnorable(char c2) {
        return isIdentifierIgnorable((int) c2);
    }

    public static boolean isIdentifierIgnorable(int i) {
        if (i < 1536) {
            if (i < 0 || i > 8) {
                if (i < 14 || i > 27) {
                    return (i >= 127 && i <= 159) || i == 173;
                }
                return true;
            }
            return true;
        }
        return isIdentifierIgnorableImpl(i);
    }

    private static native boolean isIdentifierIgnorableImpl(int i);

    public static native boolean isIdeographic(int i);

    public static boolean isJavaIdentifierPart(char c2) {
        return isJavaIdentifierPart((int) c2);
    }

    public static boolean isJavaIdentifierPart(int i) {
        if (i < 64) {
            return (287948970162897407L & (1 << i)) != 0;
        } else if (i < 128) {
            return ((-8646911290859585538L) & (1 << (i - 64))) != 0;
        } else {
            int type = getType(i);
            if ((type >= 1 && type <= 5) || type == 26 || type == 23) {
                return true;
            }
            if ((type >= 9 && type <= 10) || type == 8 || type == 6) {
                return true;
            }
            if (i < 0 || i > 8) {
                if (i < 14 || i > 27) {
                    return (i >= 127 && i <= 159) || type == 16;
                }
                return true;
            }
            return true;
        }
    }

    public static boolean isJavaIdentifierStart(char c2) {
        return isJavaIdentifierStart((int) c2);
    }

    public static boolean isJavaIdentifierStart(int i) {
        if (i < 64) {
            return i == 36;
        } else if (i < 128) {
            return (576460745995190270L & (1 << (i - 64))) != 0;
        } else {
            int type = getType(i);
            return (type >= 1 && type <= 5) || type == 26 || type == 23 || type == 10;
        }
    }

    @Deprecated
    public static boolean isJavaLetter(char c2) {
        return isJavaIdentifierStart(c2);
    }

    @Deprecated
    public static boolean isJavaLetterOrDigit(char c2) {
        return isJavaIdentifierPart(c2);
    }

    public static boolean isLetter(char c2) {
        return isLetter((int) c2);
    }

    public static boolean isLetter(int i) {
        if (65 > i || i > 90) {
            if (97 > i || i > 122) {
                if (i < 128) {
                    return false;
                }
                return isLetterImpl(i);
            }
            return true;
        }
        return true;
    }

    private static native boolean isLetterImpl(int i);

    public static boolean isLetterOrDigit(char c2) {
        return isLetterOrDigit((int) c2);
    }

    public static boolean isLetterOrDigit(int i) {
        if (65 > i || i > 90) {
            if (97 > i || i > 122) {
                if (48 > i || i > 57) {
                    if (i < 128) {
                        return false;
                    }
                    return isLetterOrDigitImpl(i);
                }
                return true;
            }
            return true;
        }
        return true;
    }

    private static native boolean isLetterOrDigitImpl(int i);

    public static boolean isLowSurrogate(char c2) {
        return 56320 <= c2 && 57343 >= c2;
    }

    public static boolean isLowerCase(char c2) {
        return isLowerCase((int) c2);
    }

    public static boolean isLowerCase(int i) {
        if (97 > i || i > 122) {
            if (i < 128) {
                return false;
            }
            return isLowerCaseImpl(i);
        }
        return true;
    }

    private static native boolean isLowerCaseImpl(int i);

    public static boolean isMirrored(char c2) {
        return isMirrored((int) c2);
    }

    public static boolean isMirrored(int i) {
        return isMirroredImpl(i);
    }

    private static native boolean isMirroredImpl(int i);

    @Deprecated
    public static boolean isSpace(char c2) {
        return c2 == '\n' || c2 == '\t' || c2 == '\f' || c2 == '\r' || c2 == ' ';
    }

    public static boolean isSpaceChar(char c2) {
        return isSpaceChar((int) c2);
    }

    public static boolean isSpaceChar(int i) {
        boolean z;
        if (i == 32 || i == 160) {
            z = true;
        } else {
            z = false;
            if (i >= 4096) {
                if (i == 5760 || i == 6158) {
                    return true;
                }
                z = false;
                if (i >= 8192) {
                    if (i > 65535) {
                        return isSpaceCharImpl(i);
                    }
                    if (i <= 8202 || i == 8232 || i == 8233 || i == 8239 || i == 8287) {
                        return true;
                    }
                    z = false;
                    if (i == 12288) {
                        return true;
                    }
                }
            }
        }
        return z;
    }

    private static native boolean isSpaceCharImpl(int i);

    public static boolean isSupplementaryCodePoint(int i) {
        return 65536 <= i && 1114111 >= i;
    }

    public static boolean isSurrogate(char c2) {
        return c2 >= 55296 && c2 <= 57343;
    }

    public static boolean isSurrogatePair(char c2, char c3) {
        return isHighSurrogate(c2) && isLowSurrogate(c3);
    }

    public static boolean isTitleCase(char c2) {
        return isTitleCaseImpl(c2);
    }

    public static boolean isTitleCase(int i) {
        return isTitleCaseImpl(i);
    }

    private static native boolean isTitleCaseImpl(int i);

    public static boolean isUnicodeIdentifierPart(char c2) {
        return isUnicodeIdentifierPartImpl(c2);
    }

    public static boolean isUnicodeIdentifierPart(int i) {
        return isUnicodeIdentifierPartImpl(i);
    }

    private static native boolean isUnicodeIdentifierPartImpl(int i);

    public static boolean isUnicodeIdentifierStart(char c2) {
        return isUnicodeIdentifierStartImpl(c2);
    }

    public static boolean isUnicodeIdentifierStart(int i) {
        return isUnicodeIdentifierStartImpl(i);
    }

    private static native boolean isUnicodeIdentifierStartImpl(int i);

    public static boolean isUpperCase(char c2) {
        return isUpperCase((int) c2);
    }

    public static boolean isUpperCase(int i) {
        if (65 > i || i > 90) {
            if (i < 128) {
                return false;
            }
            return isUpperCaseImpl(i);
        }
        return true;
    }

    private static native boolean isUpperCaseImpl(int i);

    public static boolean isValidCodePoint(int i) {
        return i >= 0 && 1114111 >= i;
    }

    public static boolean isWhitespace(char c2) {
        return isWhitespace((int) c2);
    }

    public static boolean isWhitespace(int i) {
        boolean z;
        if ((i < 28 || i > 32) && (i < 9 || i > 13)) {
            z = false;
            if (i >= 4096) {
                if (i == 5760 || i == 6158) {
                    return true;
                }
                z = false;
                if (i >= 8192) {
                    z = false;
                    if (i != 8199) {
                        z = false;
                        if (i != 8239) {
                            if (i > 65535) {
                                return isWhitespaceImpl(i);
                            }
                            if (i <= 8202 || i == 8232 || i == 8233 || i == 8287) {
                                return true;
                            }
                            z = false;
                            if (i == 12288) {
                                return true;
                            }
                        }
                    }
                }
            }
        } else {
            z = true;
        }
        return z;
    }

    private static native boolean isWhitespaceImpl(int i);

    public static char lowSurrogate(int i) {
        return (char) ((i & 1023) | 56320);
    }

    public static int offsetByCodePoints(CharSequence charSequence, int i, int i2) {
        int i3;
        if (charSequence == null) {
            throw new NullPointerException("seq == null");
        }
        int length = charSequence.length();
        if (i < 0 || i > length) {
            throw new IndexOutOfBoundsException();
        }
        if (i2 != 0) {
            if (i2 <= 0) {
                int i4 = -i2;
                while (true) {
                    i3 = i;
                    if (i4 <= 0) {
                        break;
                    }
                    int i5 = i4 - 1;
                    int i6 = i - 1;
                    if (i6 < 0) {
                        throw new IndexOutOfBoundsException();
                    }
                    i4 = i5;
                    i = i6;
                    if (isLowSurrogate(charSequence.charAt(i6))) {
                        int i7 = i6 - 1;
                        i4 = i5;
                        i = i6;
                        if (i7 >= 0) {
                            i4 = i5;
                            i = i6;
                            if (isHighSurrogate(charSequence.charAt(i7))) {
                                i = i6 - 1;
                                i4 = i5;
                            }
                        }
                    }
                }
            } else {
                int i8 = i2;
                while (true) {
                    i3 = i;
                    if (i8 <= 0) {
                        break;
                    }
                    i8--;
                    if (i >= length) {
                        throw new IndexOutOfBoundsException();
                    }
                    int i9 = i;
                    if (isHighSurrogate(charSequence.charAt(i))) {
                        int i10 = i + 1;
                        i9 = i;
                        if (i10 < length) {
                            i9 = i;
                            if (isLowSurrogate(charSequence.charAt(i10))) {
                                i9 = i + 1;
                            }
                        }
                    }
                    i = i9 + 1;
                }
            }
        } else {
            i3 = i;
        }
        return i3;
    }

    public static int offsetByCodePoints(char[] cArr, int i, int i2, int i3, int i4) {
        Arrays.checkOffsetAndCount(cArr.length, i, i2);
        int i5 = i + i2;
        if (i3 < i || i3 > i5) {
            throw new IndexOutOfBoundsException();
        }
        if (i4 != 0) {
            if (i4 <= 0) {
                int i6 = -i4;
                int i7 = i3;
                while (true) {
                    i3 = i7;
                    if (i6 <= 0) {
                        break;
                    }
                    int i8 = i6 - 1;
                    int i9 = i7 - 1;
                    if (i9 < i) {
                        throw new IndexOutOfBoundsException();
                    }
                    i6 = i8;
                    i7 = i9;
                    if (isLowSurrogate(cArr[i9])) {
                        int i10 = i9 - 1;
                        i6 = i8;
                        i7 = i9;
                        if (i10 >= i) {
                            i6 = i8;
                            i7 = i9;
                            if (isHighSurrogate(cArr[i10])) {
                                i7 = i9 - 1;
                                i6 = i8;
                            }
                        }
                    }
                }
            } else {
                int i11 = i3;
                while (true) {
                    int i12 = i11;
                    i3 = i12;
                    if (i4 <= 0) {
                        break;
                    }
                    i4--;
                    if (i12 >= i5) {
                        throw new IndexOutOfBoundsException();
                    }
                    int i13 = i12;
                    if (isHighSurrogate(cArr[i12])) {
                        int i14 = i12 + 1;
                        i13 = i12;
                        if (i14 < i5) {
                            i13 = i12;
                            if (isLowSurrogate(cArr[i14])) {
                                i13 = i12 + 1;
                            }
                        }
                    }
                    i11 = i13 + 1;
                }
            }
        }
        return i3;
    }

    public static char reverseBytes(char c2) {
        return (char) ((c2 << '\b') | (c2 >> '\b'));
    }

    public static int toChars(int i, char[] cArr, int i2) {
        checkValidCodePoint(i);
        if (cArr == null) {
            throw new NullPointerException("dst == null");
        }
        if (i2 < 0 || i2 >= cArr.length) {
            throw new IndexOutOfBoundsException();
        }
        if (!isSupplementaryCodePoint(i)) {
            cArr[i2] = (char) i;
            return 1;
        } else if (i2 == cArr.length - 1) {
            throw new IndexOutOfBoundsException();
        } else {
            int i3 = i - 65536;
            cArr[i2] = (char) (55296 | ((i3 >> 10) & 1023));
            cArr[i2 + 1] = (char) (56320 | (i3 & 1023));
            return 2;
        }
    }

    public static char[] toChars(int i) {
        checkValidCodePoint(i);
        if (isSupplementaryCodePoint(i)) {
            int i2 = i - 65536;
            return new char[]{(char) (55296 | ((i2 >> 10) & 1023)), (char) (56320 | (i2 & 1023))};
        }
        return new char[]{(char) i};
    }

    public static int toCodePoint(char c2, char c3) {
        return (((c2 & 1023) << 10) | (c3 & 1023)) + 65536;
    }

    public static char toLowerCase(char c2) {
        return (char) toLowerCase((int) c2);
    }

    public static int toLowerCase(int i) {
        char c2;
        if (65 > i || i > 90) {
            c2 = i;
            if (i >= 192) {
                return toLowerCaseImpl(i);
            }
        } else {
            c2 = (char) (i + 32);
        }
        return c2;
    }

    private static native int toLowerCaseImpl(int i);

    public static String toString(char c2) {
        return String.valueOf(c2);
    }

    public static char toTitleCase(char c2) {
        return (char) toTitleCaseImpl(c2);
    }

    public static int toTitleCase(int i) {
        return toTitleCaseImpl(i);
    }

    private static native int toTitleCaseImpl(int i);

    public static char toUpperCase(char c2) {
        return (char) toUpperCase((int) c2);
    }

    public static int toUpperCase(int i) {
        char c2;
        if (97 > i || i > 122) {
            c2 = i;
            if (i >= 181) {
                return toUpperCaseImpl(i);
            }
        } else {
            c2 = (char) (i - 32);
        }
        return c2;
    }

    private static native int toUpperCaseImpl(int i);

    /* JADX INFO: Access modifiers changed from: private */
    public static native int unicodeBlockForCodePoint(int i);

    /* JADX INFO: Access modifiers changed from: private */
    public static native int unicodeBlockForName(String str);

    private static native int unicodeScriptForCodePoint(int i);

    private static native int unicodeScriptForName(String str);

    public static Character valueOf(char c2) {
        return c2 < 128 ? SMALL_VALUES[c2] : new Character(c2);
    }

    public char charValue() {
        return this.value;
    }

    @Override // java.lang.Comparable
    public int compareTo(Character ch) {
        return compare(this.value, ch.value);
    }

    public boolean equals(Object obj) {
        return (obj instanceof Character) && ((Character) obj).value == this.value;
    }

    public int hashCode() {
        return this.value;
    }

    public String toString() {
        return String.valueOf(this.value);
    }
}
