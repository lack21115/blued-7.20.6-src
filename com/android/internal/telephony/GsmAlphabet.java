package com.android.internal.telephony;

import android.content.res.Resources;
import android.telephony.Rlog;
import android.text.TextUtils;
import android.util.SparseIntArray;
import com.android.internal.R;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;

/* loaded from: source-4181928-dex2jar.jar:com/android/internal/telephony/GsmAlphabet.class */
public class GsmAlphabet {
    public static final byte GSM_EXTENDED_ESCAPE = 27;
    private static final String TAG = "GSM";
    public static final int UDH_SEPTET_COST_CONCATENATED_MESSAGE = 6;
    public static final int UDH_SEPTET_COST_LENGTH = 1;
    public static final int UDH_SEPTET_COST_ONE_SHIFT_TABLE = 4;
    public static final int UDH_SEPTET_COST_TWO_SHIFT_TABLES = 7;
    private static final SparseIntArray[] sCharsToGsmTables;
    private static final SparseIntArray[] sCharsToShiftTables;
    private static int[] sEnabledLockingShiftTables;
    private static int[] sEnabledSingleShiftTables;
    private static int sHighestEnabledSingleShiftCode;
    private static boolean sDisableCountryEncodingCheck = false;
    private static final String[] sLanguageTables = {"@£$¥èéùìòÇ\nØø\rÅåΔ_ΦΓΛΩΠΨΣΘΞ\uffffÆæßÉ !\"#¤%&'()*+,-./0123456789:;<=>?¡ABCDEFGHIJKLMNOPQRSTUVWXYZÄÖÑÜ§¿abcdefghijklmnopqrstuvwxyzäöñüà", "@£$¥€éùıòÇ\nĞğ\rÅåΔ_ΦΓΛΩΠΨΣΘΞ\uffffŞşßÉ !\"#¤%&'()*+,-./0123456789:;<=>?İABCDEFGHIJKLMNOPQRSTUVWXYZÄÖÑÜ§çabcdefghijklmnopqrstuvwxyzäöñüà", "", "@£$¥êéúíóç\nÔô\rÁáΔ_ªÇÀ∞^\\€Ó|\uffffÂâÊÉ !\"#º%&'()*+,-./0123456789:;<=>?ÍABCDEFGHIJKLMNOPQRSTUVWXYZÃÕÚÜ§~abcdefghijklmnopqrstuvwxyzãõ`üà", "ঁংঃঅআইঈউঊঋ\nঌ \r এঐ  ওঔকখগঘঙচ\uffffছজঝঞ !টঠডঢণত)(থদ,ধ.ন0123456789:; পফ?বভমযর ল   শষসহ়ঽািীুূৃৄ  েৈ  োৌ্ৎabcdefghijklmnopqrstuvwxyzৗড়ঢ়ৰৱ", "ઁંઃઅઆઇઈઉઊઋ\nઌઍ\r એઐઑ ઓઔકખગઘઙચ\uffffછજઝઞ !ટઠડઢણત)(થદ,ધ.ન0123456789:; પફ?બભમયર લળ વશષસહ઼ઽાિીુૂૃૄૅ ેૈૉ ોૌ્ૐabcdefghijklmnopqrstuvwxyzૠૡૢૣ૱", "ँंःअआइईउऊऋ\nऌऍ\rऎएऐऑऒओऔकखगघङच\uffffछजझञ !टठडढणत)(थद,ध.न0123456789:;ऩपफ?बभमयरऱलळऴवशषसह़ऽािीुूृॄॅॆेैॉॊोौ्ॐabcdefghijklmnopqrstuvwxyzॲॻॼॾॿ", " ಂಃಅಆಇಈಉಊಋ\nಌ \rಎಏಐ ಒಓಔಕಖಗಘಙಚ\uffffಛಜಝಞ !ಟಠಡಢಣತ)(ಥದ,ಧ.ನ0123456789:; ಪಫ?ಬಭಮಯರಱಲಳ ವಶಷಸಹ಼ಽಾಿೀುೂೃೄ ೆೇೈ ೊೋೌ್ೕabcdefghijklmnopqrstuvwxyzೖೠೡೢೣ", " ംഃഅആഇഈഉഊഋ\nഌ \rഎഏഐ ഒഓഔകഖഗഘങച\uffffഛജഝഞ !ടഠഡഢണത)(ഥദ,ധ.ന0123456789:; പഫ?ബഭമയരറലളഴവശഷസഹ ഽാിീുൂൃൄ െേൈ ൊോൌ്ൗabcdefghijklmnopqrstuvwxyzൠൡൢൣ൹", "ଁଂଃଅଆଇଈଉଊଋ\nଌ \r ଏଐ  ଓଔକଖଗଘଙଚ\uffffଛଜଝଞ !ଟଠଡଢଣତ)(ଥଦ,ଧ.ନ0123456789:; ପଫ?ବଭମଯର ଲଳ ଵଶଷସହ଼ଽାିୀୁୂୃୄ  େୈ  ୋୌ୍ୖabcdefghijklmnopqrstuvwxyzୗୠୡୢୣ", "ਁਂਃਅਆਇਈਉਊ \n  \r ਏਐ  ਓਔਕਖਗਘਙਚ\uffffਛਜਝਞ !ਟਠਡਢਣਤ)(ਥਦ,ਧ.ਨ0123456789:; ਪਫ?ਬਭਮਯਰ ਲਲ਼ ਵਸ਼ ਸਹ਼ ਾਿੀੁੂ    ੇੈ  ੋੌ੍ੑabcdefghijklmnopqrstuvwxyzੰੱੲੳੴ", " ஂஃஅஆஇஈஉஊ \n  \rஎஏஐ ஒஓஔக   ஙச\uffff ஜ ஞ !ட   ணத)(  , .ந0123456789:;னப ?  மயரறலளழவஶஷஸஹ  ாிீுூ   ெேை ொோௌ்ௐabcdefghijklmnopqrstuvwxyzௗ௰௱௲௹", "ఁంఃఅఆఇఈఉఊఋ\nఌ \rఎఏఐ ఒఓఔకఖగఘఙచ\uffffఛజఝఞ !టఠడఢణత)(థద,ధ.న0123456789:; పఫ?బభమయరఱలళ వశషసహ ఽాిీుూృౄ ెేై ొోౌ్ౕabcdefghijklmnopqrstuvwxyzౖౠౡౢౣ", "اآبٻڀپڦتۂٿ\nٹٽ\rٺټثجځڄڃڅچڇحخد\uffffڌڈډڊ !ڏڍذرڑړ)(ڙز,ږ.ژ0123456789:;ښسش?صضطظعفقکڪګگڳڱلمنںڻڼوۄەہھءیېےٍُِٗٔabcdefghijklmnopqrstuvwxyzّٰٕٖٓ"};
    private static final String[] sLanguageShiftTables = {"          \f         ^                   {}     \\            [~] |                                    €                          ", "          \f         ^                   {}     \\            [~] |      Ğ İ         Ş               ç € ğ ı         ş            ", "         ç\f         ^                   {}     \\            [~] |Á       Í     Ó     Ú           á   €   í     ó     ú          ", "     ê   ç\fÔô Áá  ΦΓ^ΩΠΨΣΘ     Ê        {}     \\            [~] |À       Í     Ó     Ú     ÃÕ    Â   €   í     ó     ú     ãõ  â", "@£$¥¿\"¤%&'\f*+ -/<=>¡^¡_#*০১ ২৩৪৫৬৭৮৯য়ৠৡৢ{}ৣ৲৳৴৵\\৶৷৸৹৺       [~] |ABCDEFGHIJKLMNOPQRSTUVWXYZ          €                          ", "@£$¥¿\"¤%&'\f*+ -/<=>¡^¡_#*।॥ ૦૧૨૩૪૫૬૭૮૯  {}     \\            [~] |ABCDEFGHIJKLMNOPQRSTUVWXYZ          €                          ", "@£$¥¿\"¤%&'\f*+ -/<=>¡^¡_#*।॥ ०१२३४५६७८९॒॑{}॓॔क़ख़ग़\\ज़ड़ढ़फ़य़ॠॡॢॣ॰ॱ [~] |ABCDEFGHIJKLMNOPQRSTUVWXYZ          €                          ", "@£$¥¿\"¤%&'\f*+ -/<=>¡^¡_#*।॥ ೦೧೨೩೪೫೬೭೮೯ೞೱ{}ೲ    \\            [~] |ABCDEFGHIJKLMNOPQRSTUVWXYZ          €                          ", "@£$¥¿\"¤%&'\f*+ -/<=>¡^¡_#*।॥ ൦൧൨൩൪൫൬൭൮൯൰൱{}൲൳൴൵ൺ\\ൻർൽൾൿ       [~] |ABCDEFGHIJKLMNOPQRSTUVWXYZ          €                          ", "@£$¥¿\"¤%&'\f*+ -/<=>¡^¡_#*।॥ ୦୧୨୩୪୫୬୭୮୯ଡ଼ଢ଼{}ୟ୰ୱ  \\            [~] |ABCDEFGHIJKLMNOPQRSTUVWXYZ          €                          ", "@£$¥¿\"¤%&'\f*+ -/<=>¡^¡_#*।॥ ੦੧੨੩੪੫੬੭੮੯ਖ਼ਗ਼{}ਜ਼ੜਫ਼ੵ \\            [~] |ABCDEFGHIJKLMNOPQRSTUVWXYZ          €                          ", "@£$¥¿\"¤%&'\f*+ -/<=>¡^¡_#*।॥ ௦௧௨௩௪௫௬௭௮௯௳௴{}௵௶௷௸௺\\            [~] |ABCDEFGHIJKLMNOPQRSTUVWXYZ          €                          ", "@£$¥¿\"¤%&'\f*+ -/<=>¡^¡_#*   ౦౧౨౩౪౫౬౭౮౯ౘౙ{}౸౹౺౻౼\\౽౾౿         [~] |ABCDEFGHIJKLMNOPQRSTUVWXYZ          €                          ", "@£$¥¿\"¤%&'\f*+ -/<=>¡^¡_#*\u0600\u0601 ۰۱۲۳۴۵۶۷۸۹،؍{}؎؏ؐؑؒ\\ؓؔ؛؟ـْ٘٫٬ٲٳۍ[~]۔|ABCDEFGHIJKLMNOPQRSTUVWXYZ          €                          "};

    /* loaded from: source-4181928-dex2jar.jar:com/android/internal/telephony/GsmAlphabet$LanguagePairCount.class */
    private static class LanguagePairCount {
        final int languageCode;
        final int[] septetCounts;
        final int[] unencodableCounts;

        LanguagePairCount(int i) {
            this.languageCode = i;
            int i2 = GsmAlphabet.sHighestEnabledSingleShiftCode;
            this.septetCounts = new int[i2 + 1];
            this.unencodableCounts = new int[i2 + 1];
            int i3 = 0;
            for (int i4 = 1; i4 <= i2; i4++) {
                if (GsmAlphabet.sEnabledSingleShiftTables[i3] == i4) {
                    i3++;
                } else {
                    this.septetCounts[i4] = -1;
                }
            }
            if (i == 1 && i2 >= 1) {
                this.septetCounts[1] = -1;
            } else if (i == 3 && i2 >= 2) {
                this.septetCounts[2] = -1;
            }
        }
    }

    /* loaded from: source-4181928-dex2jar.jar:com/android/internal/telephony/GsmAlphabet$TextEncodingDetails.class */
    public static class TextEncodingDetails {
        public int codeUnitCount;
        public int codeUnitSize;
        public int codeUnitsRemaining;
        public int languageShiftTable;
        public int languageTable;
        public int msgCount;

        public String toString() {
            return "TextEncodingDetails { msgCount=" + this.msgCount + ", codeUnitCount=" + this.codeUnitCount + ", codeUnitsRemaining=" + this.codeUnitsRemaining + ", codeUnitSize=" + this.codeUnitSize + ", languageTable=" + this.languageTable + ", languageShiftTable=" + this.languageShiftTable + " }";
        }
    }

    static {
        enableCountrySpecificEncodings();
        int length = sLanguageTables.length;
        int length2 = sLanguageShiftTables.length;
        if (length != length2) {
            new StringBuilder();
            throw new VerifyError("bad dex opcode");
        }
        sCharsToGsmTables = new SparseIntArray[length];
        if (length < 0) {
            String str = sLanguageTables[0];
            throw new VerifyError("bad dex opcode");
        }
        sCharsToShiftTables = new SparseIntArray[length];
        if (length2 < 0) {
            String str2 = sLanguageShiftTables[0];
            throw new VerifyError("bad dex opcode");
        }
    }

    private GsmAlphabet() {
    }

    public static int charToGsm(char c) {
        try {
            return charToGsm(c, false);
        } catch (EncodeException e) {
            return sCharsToGsmTables[0].get(32, 32);
        }
    }

    public static int charToGsm(char c, boolean z) throws EncodeException {
        int i = sCharsToGsmTables[0].get(c, -1);
        if (i == -1) {
            if (sCharsToShiftTables[0].get(c, -1) == -1) {
                if (z) {
                    throw new EncodeException(c);
                }
                return sCharsToGsmTables[0].get(32, 32);
            }
            return 27;
        }
        return i;
    }

    public static int charToGsmExtended(char c) {
        int i = sCharsToShiftTables[0].get(c, -1);
        int i2 = i;
        if (i == -1) {
            i2 = sCharsToGsmTables[0].get(32, 32);
        }
        return i2;
    }

    public static int countGsmSeptets(char c) {
        try {
            return countGsmSeptets(c, false);
        } catch (EncodeException e) {
            return 0;
        }
    }

    public static int countGsmSeptets(char c, boolean z) throws EncodeException {
        if (sCharsToGsmTables[0].get(c, -1) != -1) {
            return 1;
        }
        if (sCharsToShiftTables[0].get(c, -1) != -1) {
            return 2;
        }
        if (z) {
            throw new EncodeException(c);
        }
        return 1;
    }

    public static TextEncodingDetails countGsmSeptets(CharSequence charSequence, boolean z) {
        TextEncodingDetails textEncodingDetails;
        int i;
        int i2;
        int i3;
        if (!sDisableCountryEncodingCheck) {
            enableCountrySpecificEncodings();
        }
        if (sEnabledSingleShiftTables.length + sEnabledLockingShiftTables.length == 0) {
            TextEncodingDetails textEncodingDetails2 = new TextEncodingDetails();
            int countGsmSeptetsUsingTables = countGsmSeptetsUsingTables(charSequence, z, 0, 0);
            if (countGsmSeptetsUsingTables != -1) {
                textEncodingDetails2.codeUnitSize = 1;
                textEncodingDetails2.codeUnitCount = countGsmSeptetsUsingTables;
                if (countGsmSeptetsUsingTables > 160) {
                    textEncodingDetails2.msgCount = (countGsmSeptetsUsingTables + 152) / 153;
                    textEncodingDetails2.codeUnitsRemaining = (textEncodingDetails2.msgCount * 153) - countGsmSeptetsUsingTables;
                } else {
                    textEncodingDetails2.msgCount = 1;
                    textEncodingDetails2.codeUnitsRemaining = 160 - countGsmSeptetsUsingTables;
                }
                textEncodingDetails2.codeUnitSize = 1;
                return textEncodingDetails2;
            }
            textEncodingDetails = null;
        } else {
            int i4 = sHighestEnabledSingleShiftCode;
            ArrayList<LanguagePairCount> arrayList = new ArrayList(sEnabledLockingShiftTables.length + 1);
            arrayList.add(new LanguagePairCount(0));
            int[] iArr = sEnabledLockingShiftTables;
            int length = iArr.length;
            int i5 = 0;
            while (true) {
                int i6 = i5;
                if (i6 >= length) {
                    break;
                }
                int i7 = iArr[i6];
                if (i7 != 0 && !sLanguageTables[i7].isEmpty()) {
                    arrayList.add(new LanguagePairCount(i7));
                }
                i5 = i6 + 1;
            }
            int length2 = charSequence.length();
            int i8 = 0;
            while (true) {
                int i9 = i8;
                if (i9 >= length2 || arrayList.isEmpty()) {
                    break;
                }
                char charAt = charSequence.charAt(i9);
                if (charAt == 27) {
                    Rlog.w(TAG, "countGsmSeptets() string contains Escape character, ignoring!");
                } else {
                    for (LanguagePairCount languagePairCount : arrayList) {
                        if (sCharsToGsmTables[languagePairCount.languageCode].get(charAt, -1) == -1) {
                            int i10 = 0;
                            while (true) {
                                int i11 = i10;
                                if (i11 <= i4) {
                                    if (languagePairCount.septetCounts[i11] != -1) {
                                        if (sCharsToShiftTables[i11].get(charAt, -1) != -1) {
                                            int[] iArr2 = languagePairCount.septetCounts;
                                            iArr2[i11] = iArr2[i11] + 2;
                                        } else if (z) {
                                            int[] iArr3 = languagePairCount.septetCounts;
                                            iArr3[i11] = iArr3[i11] + 1;
                                            int[] iArr4 = languagePairCount.unencodableCounts;
                                            iArr4[i11] = iArr4[i11] + 1;
                                        } else {
                                            languagePairCount.septetCounts[i11] = -1;
                                        }
                                    }
                                    i10 = i11 + 1;
                                }
                            }
                        } else {
                            int i12 = 0;
                            while (true) {
                                int i13 = i12;
                                if (i13 <= i4) {
                                    if (languagePairCount.septetCounts[i13] != -1) {
                                        int[] iArr5 = languagePairCount.septetCounts;
                                        iArr5[i13] = iArr5[i13] + 1;
                                    }
                                    i12 = i13 + 1;
                                }
                            }
                        }
                    }
                }
                i8 = i9 + 1;
            }
            TextEncodingDetails textEncodingDetails3 = new TextEncodingDetails();
            textEncodingDetails3.msgCount = Integer.MAX_VALUE;
            textEncodingDetails3.codeUnitSize = 1;
            int i14 = Integer.MAX_VALUE;
            for (LanguagePairCount languagePairCount2 : arrayList) {
                int i15 = 0;
                int i16 = i14;
                while (true) {
                    int i17 = i16;
                    i14 = i17;
                    if (i15 <= i4) {
                        int i18 = languagePairCount2.septetCounts[i15];
                        if (i18 == -1) {
                            i3 = i17;
                        } else {
                            int i19 = (languagePairCount2.languageCode == 0 || i15 == 0) ? (languagePairCount2.languageCode == 0 && i15 == 0) ? 0 : 5 : 8;
                            if (i18 + i19 > 160) {
                                int i20 = i19;
                                if (i19 == 0) {
                                    i20 = 1;
                                }
                                int i21 = 160 - (i20 + 6);
                                i = ((i18 + i21) - 1) / i21;
                                i2 = (i * i21) - i18;
                            } else {
                                i = 1;
                                i2 = (160 - i19) - i18;
                            }
                            int i22 = languagePairCount2.unencodableCounts[i15];
                            if (z) {
                                i3 = i17;
                                if (i22 > i17) {
                                }
                            }
                            if ((!z || i22 >= i17) && i >= textEncodingDetails3.msgCount) {
                                i3 = i17;
                                if (i == textEncodingDetails3.msgCount) {
                                    i3 = i17;
                                    if (i2 <= textEncodingDetails3.codeUnitsRemaining) {
                                    }
                                }
                            }
                            i3 = i22;
                            textEncodingDetails3.msgCount = i;
                            textEncodingDetails3.codeUnitCount = i18;
                            textEncodingDetails3.codeUnitsRemaining = i2;
                            textEncodingDetails3.languageTable = languagePairCount2.languageCode;
                            textEncodingDetails3.languageShiftTable = i15;
                        }
                        i15++;
                        i16 = i3;
                    }
                }
            }
            textEncodingDetails = textEncodingDetails3;
            if (textEncodingDetails3.msgCount == Integer.MAX_VALUE) {
                return null;
            }
        }
        return textEncodingDetails;
    }

    public static int countGsmSeptetsUsingTables(CharSequence charSequence, boolean z, int i, int i2) {
        int i3;
        int length = charSequence.length();
        SparseIntArray sparseIntArray = sCharsToGsmTables[i];
        SparseIntArray sparseIntArray2 = sCharsToShiftTables[i2];
        int i4 = 0;
        int i5 = 0;
        while (true) {
            i3 = i5;
            if (i4 >= length) {
                break;
            }
            char charAt = charSequence.charAt(i4);
            if (charAt != 27) {
                if (sparseIntArray.get(charAt, -1) == -1) {
                    if (sparseIntArray2.get(charAt, -1) == -1) {
                        if (!z) {
                            i3 = -1;
                            break;
                        }
                        i5++;
                    } else {
                        i5 += 2;
                    }
                } else {
                    i5++;
                }
            } else {
                Rlog.w(TAG, "countGsmSeptets() string contains Escape character, skipping.");
            }
            i4++;
        }
        return i3;
    }

    private static void enableCountrySpecificEncodings() {
        Resources system = Resources.getSystem();
        sEnabledSingleShiftTables = system.getIntArray(R.array.config_sms_enabled_single_shift_tables);
        sEnabledLockingShiftTables = system.getIntArray(R.array.config_sms_enabled_locking_shift_tables);
        if (sEnabledSingleShiftTables.length > 0) {
            sHighestEnabledSingleShiftCode = sEnabledSingleShiftTables[sEnabledSingleShiftTables.length - 1];
        } else {
            sHighestEnabledSingleShiftCode = 0;
        }
    }

    public static int findGsmSeptetLimitIndex(String str, int i, int i2, int i3, int i4) {
        int length = str.length();
        SparseIntArray sparseIntArray = sCharsToGsmTables[i3];
        SparseIntArray sparseIntArray2 = sCharsToShiftTables[i4];
        int i5 = 0;
        for (int i6 = i; i6 < length; i6++) {
            i5 = sparseIntArray.get(str.charAt(i6), -1) == -1 ? sparseIntArray2.get(str.charAt(i6), -1) == -1 ? i5 + 1 : i5 + 2 : i5 + 1;
            if (i5 > i2) {
                return i6;
            }
        }
        return length;
    }

    public static int[] getEnabledLockingShiftTables() {
        int[] iArr;
        synchronized (GsmAlphabet.class) {
            try {
                iArr = sEnabledLockingShiftTables;
            } catch (Throwable th) {
                throw th;
            }
        }
        return iArr;
    }

    public static int[] getEnabledSingleShiftTables() {
        int[] iArr;
        synchronized (GsmAlphabet.class) {
            try {
                iArr = sEnabledSingleShiftTables;
            } catch (Throwable th) {
                throw th;
            }
        }
        return iArr;
    }

    public static String gsm7BitPackedToString(byte[] bArr, int i, int i2) {
        return gsm7BitPackedToString(bArr, i, i2, 0, 0, 0);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x004f, code lost:
        if (r10 > com.android.internal.telephony.GsmAlphabet.sLanguageShiftTables.length) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x0019, code lost:
        if (r9 > com.android.internal.telephony.GsmAlphabet.sLanguageTables.length) goto L57;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String gsm7BitPackedToString(byte[] r5, int r6, int r7, int r8, int r9, int r10) {
        /*
            Method dump skipped, instructions count: 463
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.internal.telephony.GsmAlphabet.gsm7BitPackedToString(byte[], int, int, int, int, int):java.lang.String");
    }

    public static String gsm8BitUnpackedToString(byte[] bArr, int i, int i2) {
        return gsm8BitUnpackedToString(bArr, i, i2, "");
    }

    public static String gsm8BitUnpackedToString(byte[] bArr, int i, int i2, String str) {
        int i3;
        boolean z;
        Charset charset = null;
        boolean z2 = false;
        ByteBuffer byteBuffer = null;
        if (!TextUtils.isEmpty(str)) {
            charset = null;
            z2 = false;
            byteBuffer = null;
            if (!str.equalsIgnoreCase("us-ascii")) {
                charset = null;
                z2 = false;
                byteBuffer = null;
                if (Charset.isSupported(str)) {
                    z2 = true;
                    charset = Charset.forName(str);
                    byteBuffer = ByteBuffer.allocate(2);
                }
            }
        }
        String str2 = sLanguageTables[0];
        String str3 = sLanguageShiftTables[0];
        StringBuilder sb = new StringBuilder(i2);
        boolean z3 = false;
        int i4 = i;
        while (true) {
            int i5 = i4;
            if (i5 >= i + i2 || (i3 = bArr[i5] & 255) == 255) {
                break;
            }
            if (i3 != 27) {
                if (z3) {
                    char charAt = i3 < str3.length() ? str3.charAt(i3) : ' ';
                    if (charAt != ' ') {
                        sb.append(charAt);
                    } else if (i3 < str2.length()) {
                        sb.append(str2.charAt(i3));
                    } else {
                        sb.append(' ');
                    }
                } else if (z2 && i3 >= 128 && i5 + 1 < i + i2) {
                    byteBuffer.clear();
                    byteBuffer.put(bArr, i5, 2);
                    byteBuffer.flip();
                    sb.append(charset.decode(byteBuffer).toString());
                    i5++;
                } else if (i3 < str2.length()) {
                    sb.append(str2.charAt(i3));
                } else {
                    sb.append(' ');
                }
                z = false;
            } else if (z3) {
                sb.append(' ');
                z = false;
            } else {
                z = true;
            }
            z3 = z;
            i4 = i5 + 1;
        }
        return sb.toString();
    }

    public static char gsmExtendedToChar(int i) {
        char c;
        if (i == 27) {
            c = ' ';
        } else if (i < 0 || i >= 128) {
            return ' ';
        } else {
            char charAt = sLanguageShiftTables[0].charAt(i);
            c = charAt;
            if (charAt == ' ') {
                return sLanguageTables[0].charAt(i);
            }
        }
        return c;
    }

    public static char gsmToChar(int i) {
        if (i < 0 || i >= 128) {
            return ' ';
        }
        return sLanguageTables[0].charAt(i);
    }

    public static boolean isGsmSeptets(char c) {
        return (sCharsToGsmTables[0].get(c, -1) == -1 && sCharsToShiftTables[0].get(c, -1) == -1) ? false : true;
    }

    private static void packSmsChar(byte[] bArr, int i, int i2) {
        int i3 = i % 8;
        int i4 = (i / 8) + 1;
        bArr[i4] = (byte) (bArr[i4] | (i2 << i3));
        if (i3 > 1) {
            bArr[i4 + 1] = (byte) (i2 >> (8 - i3));
        }
    }

    public static void setEnabledLockingShiftTables(int[] iArr) {
        synchronized (GsmAlphabet.class) {
            try {
                sEnabledLockingShiftTables = iArr;
                sDisableCountryEncodingCheck = true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void setEnabledSingleShiftTables(int[] iArr) {
        synchronized (GsmAlphabet.class) {
            try {
                sEnabledSingleShiftTables = iArr;
                sDisableCountryEncodingCheck = true;
                if (iArr.length > 0) {
                    sHighestEnabledSingleShiftCode = iArr[iArr.length - 1];
                } else {
                    sHighestEnabledSingleShiftCode = 0;
                }
            } finally {
            }
        }
    }

    public static byte[] stringToGsm7BitPacked(String str) throws EncodeException {
        return stringToGsm7BitPacked(str, 0, true, 0, 0);
    }

    public static byte[] stringToGsm7BitPacked(String str, int i, int i2) throws EncodeException {
        return stringToGsm7BitPacked(str, 0, true, i, i2);
    }

    public static byte[] stringToGsm7BitPacked(String str, int i, boolean z, int i2, int i3) throws EncodeException {
        int length = str.length();
        int countGsmSeptetsUsingTables = countGsmSeptetsUsingTables(str, !z, i2, i3);
        if (countGsmSeptetsUsingTables == -1) {
            throw new EncodeException("countGsmSeptetsUsingTables(): unencodable char");
        }
        int i4 = countGsmSeptetsUsingTables + i;
        if (i4 > 255) {
            throw new EncodeException("Payload cannot exceed 255 septets");
        }
        byte[] bArr = new byte[(((i4 * 7) + 7) / 8) + 1];
        SparseIntArray sparseIntArray = sCharsToGsmTables[i2];
        SparseIntArray sparseIntArray2 = sCharsToShiftTables[i3];
        int i5 = 0;
        int i6 = i * 7;
        int i7 = i;
        int i8 = i6;
        while (true) {
            int i9 = i8;
            if (i5 >= length || i7 >= i4) {
                break;
            }
            char charAt = str.charAt(i5);
            int i10 = sparseIntArray.get(charAt, -1);
            int i11 = i9;
            int i12 = i7;
            int i13 = i10;
            if (i10 == -1) {
                i13 = sparseIntArray2.get(charAt, -1);
                if (i13 != -1) {
                    packSmsChar(bArr, i9, 27);
                    i11 = i9 + 7;
                    i12 = i7 + 1;
                } else if (z) {
                    throw new EncodeException("stringToGsm7BitPacked(): unencodable char");
                } else {
                    i13 = sparseIntArray.get(32, 32);
                    i12 = i7;
                    i11 = i9;
                }
            }
            packSmsChar(bArr, i11, i13);
            i7 = i12 + 1;
            i5++;
            i8 = i11 + 7;
        }
        bArr[0] = (byte) i4;
        return bArr;
    }

    public static byte[] stringToGsm7BitPackedWithHeader(String str, byte[] bArr) throws EncodeException {
        return stringToGsm7BitPackedWithHeader(str, bArr, 0, 0);
    }

    public static byte[] stringToGsm7BitPackedWithHeader(String str, byte[] bArr, int i, int i2) throws EncodeException {
        if (bArr == null || bArr.length == 0) {
            return stringToGsm7BitPacked(str, i, i2);
        }
        byte[] stringToGsm7BitPacked = stringToGsm7BitPacked(str, (((bArr.length + 1) * 8) + 6) / 7, true, i, i2);
        stringToGsm7BitPacked[1] = (byte) bArr.length;
        System.arraycopy(bArr, 0, stringToGsm7BitPacked, 2, bArr.length);
        return stringToGsm7BitPacked;
    }

    public static byte[] stringToGsm8BitPacked(String str) {
        byte[] bArr = new byte[countGsmSeptetsUsingTables(str, true, 0, 0)];
        stringToGsm8BitUnpackedField(str, bArr, 0, bArr.length);
        return bArr;
    }

    public static void stringToGsm8BitUnpackedField(String str, byte[] bArr, int i, int i2) {
        int i3;
        SparseIntArray sparseIntArray = sCharsToGsmTables[0];
        SparseIntArray sparseIntArray2 = sCharsToShiftTables[0];
        int i4 = 0;
        int length = str.length();
        int i5 = i;
        while (true) {
            int i6 = i5;
            i3 = i6;
            if (i4 >= length) {
                break;
            }
            i3 = i6;
            if (i6 - i >= i2) {
                break;
            }
            char charAt = str.charAt(i4);
            int i7 = sparseIntArray.get(charAt, -1);
            if (i7 == -1) {
                i7 = sparseIntArray2.get(charAt, -1);
                if (i7 == -1) {
                    i7 = sparseIntArray.get(32, 32);
                } else if ((i6 + 1) - i >= i2) {
                    i3 = i6;
                    break;
                } else {
                    bArr[i6] = 27;
                    i6++;
                }
            }
            bArr[i6] = (byte) i7;
            i4++;
            i5 = i6 + 1;
        }
        while (i3 - i < i2) {
            bArr[i3] = -1;
            i3++;
        }
    }
}
