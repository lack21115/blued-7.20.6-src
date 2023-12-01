package org.apache.commons.codec.language.bm;

import com.anythink.core.common.g.c;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;
import org.apache.commons.codec.language.bm.Languages;

/* loaded from: source-3503164-dex2jar.jar:org/apache/commons/codec/language/bm/Rule.class */
public class Rule {
    public static final String ALL = "ALL";
    private static final String DOUBLE_QUOTE = "\"";
    private static final String HASH_INCLUDE = "#include";
    private final RPattern lContext;
    private final String pattern;
    private final PhonemeExpr phoneme;
    private final RPattern rContext;
    public static final RPattern ALL_STRINGS_RMATCHER = new RPattern() { // from class: org.apache.commons.codec.language.bm.Rule.1
        @Override // org.apache.commons.codec.language.bm.Rule.RPattern
        public boolean isMatch(CharSequence charSequence) {
            return true;
        }
    };
    private static final Map<NameType, Map<RuleType, Map<String, List<Rule>>>> RULES = new EnumMap(NameType.class);

    /* renamed from: org.apache.commons.codec.language.bm.Rule$10  reason: invalid class name */
    /* loaded from: source-3503164-dex2jar.jar:org/apache/commons/codec/language/bm/Rule$10.class */
    static final class AnonymousClass10 implements RPattern {
        Pattern pattern;
        final /* synthetic */ String val$regex;

        AnonymousClass10(String str) {
            this.val$regex = str;
            this.pattern = Pattern.compile(this.val$regex);
        }

        @Override // org.apache.commons.codec.language.bm.Rule.RPattern
        public boolean isMatch(CharSequence charSequence) {
            return this.pattern.matcher(charSequence).find();
        }
    }

    /* renamed from: org.apache.commons.codec.language.bm.Rule$3  reason: invalid class name */
    /* loaded from: source-3503164-dex2jar.jar:org/apache/commons/codec/language/bm/Rule$3.class */
    static final class AnonymousClass3 implements RPattern {
        AnonymousClass3() {
        }

        @Override // org.apache.commons.codec.language.bm.Rule.RPattern
        public boolean isMatch(CharSequence charSequence) {
            return charSequence.length() == 0;
        }
    }

    /* renamed from: org.apache.commons.codec.language.bm.Rule$4  reason: invalid class name */
    /* loaded from: source-3503164-dex2jar.jar:org/apache/commons/codec/language/bm/Rule$4.class */
    static final class AnonymousClass4 implements RPattern {
        final /* synthetic */ String val$content;

        AnonymousClass4(String str) {
            this.val$content = str;
        }

        @Override // org.apache.commons.codec.language.bm.Rule.RPattern
        public boolean isMatch(CharSequence charSequence) {
            return charSequence.equals(this.val$content);
        }
    }

    /* renamed from: org.apache.commons.codec.language.bm.Rule$5  reason: invalid class name */
    /* loaded from: source-3503164-dex2jar.jar:org/apache/commons/codec/language/bm/Rule$5.class */
    static final class AnonymousClass5 implements RPattern {
        final /* synthetic */ String val$content;

        AnonymousClass5(String str) {
            this.val$content = str;
        }

        @Override // org.apache.commons.codec.language.bm.Rule.RPattern
        public boolean isMatch(CharSequence charSequence) {
            return Rule.startsWith(charSequence, this.val$content);
        }
    }

    /* renamed from: org.apache.commons.codec.language.bm.Rule$6  reason: invalid class name */
    /* loaded from: source-3503164-dex2jar.jar:org/apache/commons/codec/language/bm/Rule$6.class */
    static final class AnonymousClass6 implements RPattern {
        final /* synthetic */ String val$content;

        AnonymousClass6(String str) {
            this.val$content = str;
        }

        @Override // org.apache.commons.codec.language.bm.Rule.RPattern
        public boolean isMatch(CharSequence charSequence) {
            return Rule.endsWith(charSequence, this.val$content);
        }
    }

    /* renamed from: org.apache.commons.codec.language.bm.Rule$7  reason: invalid class name */
    /* loaded from: source-3503164-dex2jar.jar:org/apache/commons/codec/language/bm/Rule$7.class */
    static final class AnonymousClass7 implements RPattern {
        final /* synthetic */ String val$bContent;
        final /* synthetic */ boolean val$shouldMatch;

        AnonymousClass7(String str, boolean z) {
            this.val$bContent = str;
            this.val$shouldMatch = z;
        }

        @Override // org.apache.commons.codec.language.bm.Rule.RPattern
        public boolean isMatch(CharSequence charSequence) {
            boolean z = false;
            if (charSequence.length() == 1) {
                z = false;
                if (Rule.contains(this.val$bContent, charSequence.charAt(0)) == this.val$shouldMatch) {
                    z = true;
                }
            }
            return z;
        }
    }

    /* renamed from: org.apache.commons.codec.language.bm.Rule$8  reason: invalid class name */
    /* loaded from: source-3503164-dex2jar.jar:org/apache/commons/codec/language/bm/Rule$8.class */
    static final class AnonymousClass8 implements RPattern {
        final /* synthetic */ String val$bContent;
        final /* synthetic */ boolean val$shouldMatch;

        AnonymousClass8(String str, boolean z) {
            this.val$bContent = str;
            this.val$shouldMatch = z;
        }

        @Override // org.apache.commons.codec.language.bm.Rule.RPattern
        public boolean isMatch(CharSequence charSequence) {
            boolean z = false;
            if (charSequence.length() > 0) {
                z = false;
                if (Rule.contains(this.val$bContent, charSequence.charAt(0)) == this.val$shouldMatch) {
                    z = true;
                }
            }
            return z;
        }
    }

    /* renamed from: org.apache.commons.codec.language.bm.Rule$9  reason: invalid class name */
    /* loaded from: source-3503164-dex2jar.jar:org/apache/commons/codec/language/bm/Rule$9.class */
    static final class AnonymousClass9 implements RPattern {
        final /* synthetic */ String val$bContent;
        final /* synthetic */ boolean val$shouldMatch;

        AnonymousClass9(String str, boolean z) {
            this.val$bContent = str;
            this.val$shouldMatch = z;
        }

        @Override // org.apache.commons.codec.language.bm.Rule.RPattern
        public boolean isMatch(CharSequence charSequence) {
            return charSequence.length() > 0 && Rule.contains(this.val$bContent, charSequence.charAt(charSequence.length() - 1)) == this.val$shouldMatch;
        }
    }

    /* loaded from: source-3503164-dex2jar.jar:org/apache/commons/codec/language/bm/Rule$Phoneme.class */
    public static final class Phoneme implements PhonemeExpr {
        public static final Comparator<Phoneme> COMPARATOR = new Comparator<Phoneme>() { // from class: org.apache.commons.codec.language.bm.Rule.Phoneme.1
            @Override // java.util.Comparator
            public int compare(Phoneme phoneme, Phoneme phoneme2) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= phoneme.phonemeText.length()) {
                        return phoneme.phonemeText.length() < phoneme2.phonemeText.length() ? -1 : 0;
                    } else if (i2 >= phoneme2.phonemeText.length()) {
                        return 1;
                    } else {
                        int charAt = phoneme.phonemeText.charAt(i2) - phoneme2.phonemeText.charAt(i2);
                        if (charAt != 0) {
                            return charAt;
                        }
                        i = i2 + 1;
                    }
                }
            }
        };
        private final Languages.LanguageSet languages;
        private final CharSequence phonemeText;

        public Phoneme(CharSequence charSequence, Languages.LanguageSet languageSet) {
            this.phonemeText = charSequence;
            this.languages = languageSet;
        }

        public Phoneme append(CharSequence charSequence) {
            return new Phoneme(this.phonemeText.toString() + charSequence.toString(), this.languages);
        }

        public Languages.LanguageSet getLanguages() {
            return this.languages;
        }

        public CharSequence getPhonemeText() {
            return this.phonemeText;
        }

        @Override // org.apache.commons.codec.language.bm.Rule.PhonemeExpr
        public Iterable<Phoneme> getPhonemes() {
            return Collections.singleton(this);
        }

        public Phoneme join(Phoneme phoneme) {
            return new Phoneme(this.phonemeText.toString() + phoneme.phonemeText.toString(), this.languages.restrictTo(phoneme.languages));
        }
    }

    /* loaded from: source-3503164-dex2jar.jar:org/apache/commons/codec/language/bm/Rule$PhonemeExpr.class */
    public interface PhonemeExpr {
        Iterable<Phoneme> getPhonemes();
    }

    /* loaded from: source-3503164-dex2jar.jar:org/apache/commons/codec/language/bm/Rule$PhonemeList.class */
    public static final class PhonemeList implements PhonemeExpr {
        private final List<Phoneme> phonemes;

        public PhonemeList(List<Phoneme> list) {
            this.phonemes = list;
        }

        @Override // org.apache.commons.codec.language.bm.Rule.PhonemeExpr
        public List<Phoneme> getPhonemes() {
            return this.phonemes;
        }
    }

    /* loaded from: source-3503164-dex2jar.jar:org/apache/commons/codec/language/bm/Rule$RPattern.class */
    public interface RPattern {
        boolean isMatch(CharSequence charSequence);
    }

    static {
        NameType[] values = NameType.values();
        int length = values.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            NameType nameType = values[i2];
            EnumMap enumMap = new EnumMap(RuleType.class);
            RuleType[] values2 = RuleType.values();
            int length2 = values2.length;
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 < length2) {
                    RuleType ruleType = values2[i4];
                    HashMap hashMap = new HashMap();
                    for (String str : Languages.getInstance(nameType).getLanguages()) {
                        try {
                            hashMap.put(str, parseRules(createScanner(nameType, ruleType, str), createResourceName(nameType, ruleType, str)));
                        } catch (IllegalStateException e) {
                            throw new IllegalStateException("Problem processing " + createResourceName(nameType, ruleType, str), e);
                        }
                    }
                    if (!ruleType.equals(RuleType.RULES)) {
                        hashMap.put(c.Z, parseRules(createScanner(nameType, ruleType, c.Z), createResourceName(nameType, ruleType, c.Z)));
                    }
                    enumMap.put((EnumMap) ruleType, (RuleType) Collections.unmodifiableMap(hashMap));
                    i3 = i4 + 1;
                }
            }
            RULES.put(nameType, Collections.unmodifiableMap(enumMap));
            i = i2 + 1;
        }
    }

    public Rule(String str, String str2, String str3, PhonemeExpr phonemeExpr) {
        this.pattern = str;
        this.lContext = pattern(str2 + "$");
        this.rContext = pattern("^" + str3);
        this.phoneme = phonemeExpr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean contains(CharSequence charSequence, char c) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= charSequence.length()) {
                return false;
            }
            if (charSequence.charAt(i2) == c) {
                return true;
            }
            i = i2 + 1;
        }
    }

    private static String createResourceName(NameType nameType, RuleType ruleType, String str) {
        return String.format("org/apache/commons/codec/language/bm/%s_%s_%s.txt", nameType.getName(), ruleType.getName(), str);
    }

    private static Scanner createScanner(String str) {
        String format = String.format("org/apache/commons/codec/language/bm/%s.txt", str);
        InputStream resourceAsStream = Languages.class.getClassLoader().getResourceAsStream(format);
        if (resourceAsStream != null) {
            return new Scanner(resourceAsStream, "UTF-8");
        }
        throw new IllegalArgumentException("Unable to load resource: " + format);
    }

    private static Scanner createScanner(NameType nameType, RuleType ruleType, String str) {
        String createResourceName = createResourceName(nameType, ruleType, str);
        InputStream resourceAsStream = Languages.class.getClassLoader().getResourceAsStream(createResourceName);
        if (resourceAsStream != null) {
            return new Scanner(resourceAsStream, "UTF-8");
        }
        throw new IllegalArgumentException("Unable to load resource: " + createResourceName);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean endsWith(CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence2.length() > charSequence.length()) {
            return false;
        }
        int length = charSequence.length() - 1;
        int length2 = charSequence2.length();
        while (true) {
            int i = length2 - 1;
            if (i < 0) {
                return true;
            }
            if (charSequence.charAt(length) != charSequence2.charAt(i)) {
                return false;
            }
            length--;
            length2 = i;
        }
    }

    public static List<Rule> getInstance(NameType nameType, RuleType ruleType, String str) {
        List<Rule> list = RULES.get(nameType).get(ruleType).get(str);
        if (list != null) {
            return list;
        }
        throw new IllegalArgumentException(String.format("No rules found for %s, %s, %s.", nameType.getName(), ruleType.getName(), str));
    }

    public static List<Rule> getInstance(NameType nameType, RuleType ruleType, Languages.LanguageSet languageSet) {
        return getInstance(nameType, ruleType, languageSet.isSingleton() ? languageSet.getAny() : Languages.ANY);
    }

    private static Phoneme parsePhoneme(String str) {
        int indexOf = str.indexOf("[");
        if (indexOf >= 0) {
            if (str.endsWith("]")) {
                return new Phoneme(str.substring(0, indexOf), Languages.LanguageSet.from(new HashSet(Arrays.asList(str.substring(indexOf + 1, str.length() - 1).split("[+]")))));
            }
            throw new IllegalArgumentException("Phoneme expression contains a '[' but does not end in ']'");
        }
        return new Phoneme(str, Languages.ANY_LANGUAGE);
    }

    private static PhonemeExpr parsePhonemeExpr(String str) {
        if (str.startsWith("(")) {
            if (str.endsWith(")")) {
                ArrayList arrayList = new ArrayList();
                String substring = str.substring(1, str.length() - 1);
                String[] split = substring.split("[|]");
                int length = split.length;
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= length) {
                        break;
                    }
                    arrayList.add(parsePhoneme(split[i2]));
                    i = i2 + 1;
                }
                if (substring.startsWith("|") || substring.endsWith("|")) {
                    arrayList.add(new Phoneme("", Languages.ANY_LANGUAGE));
                }
                return new PhonemeList(arrayList);
            }
            throw new IllegalArgumentException("Phoneme starts with '(' so must end with ')'");
        }
        return parsePhoneme(str);
    }

    private static List<Rule> parseRules(Scanner scanner, final String str) {
        ArrayList arrayList = new ArrayList();
        final int i = 0;
        while (true) {
            boolean z = false;
            int i2 = i;
            while (scanner.hasNextLine()) {
                i = i2 + 1;
                String nextLine = scanner.nextLine();
                if (z) {
                    i2 = i;
                    if (nextLine.endsWith("*/")) {
                        break;
                    }
                } else if (nextLine.startsWith("/*")) {
                    z = true;
                    i2 = i;
                } else {
                    int indexOf = nextLine.indexOf("//");
                    String trim = (indexOf >= 0 ? nextLine.substring(0, indexOf) : nextLine).trim();
                    if (trim.length() == 0) {
                        i2 = i;
                    } else if (trim.startsWith(HASH_INCLUDE)) {
                        String trim2 = trim.substring(8).trim();
                        if (trim2.contains(" ")) {
                            System.err.println("Warining: malformed import statement: " + nextLine);
                            i2 = i;
                        } else {
                            arrayList.addAll(parseRules(createScanner(trim2), str + "->" + trim2));
                            i2 = i;
                        }
                    } else {
                        String[] split = trim.split("\\s+");
                        if (split.length != 4) {
                            System.err.println("Warning: malformed rule statement split into " + split.length + " parts: " + nextLine);
                            i2 = i;
                        } else {
                            try {
                                arrayList.add(new Rule(stripQuotes(split[0]), stripQuotes(split[1]), stripQuotes(split[2]), parsePhonemeExpr(stripQuotes(split[3]))) { // from class: org.apache.commons.codec.language.bm.Rule.2
                                    private final String loc;
                                    private final int myLine;

                                    {
                                        this.myLine = i;
                                        this.loc = str;
                                    }

                                    public String toString() {
                                        return "Rule{line=" + this.myLine + ", loc='" + this.loc + "'}";
                                    }
                                });
                                i2 = i;
                            } catch (IllegalArgumentException e) {
                                throw new IllegalStateException("Problem parsing line " + i, e);
                            }
                        }
                    }
                }
            }
            return arrayList;
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    private static RPattern pattern(String str) {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean startsWith(CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence2.length() > charSequence.length()) {
            return false;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= charSequence2.length()) {
                return true;
            }
            if (charSequence.charAt(i2) != charSequence2.charAt(i2)) {
                return false;
            }
            i = i2 + 1;
        }
    }

    private static String stripQuotes(String str) {
        String str2 = str;
        if (str.startsWith("\"")) {
            str2 = str.substring(1);
        }
        String str3 = str2;
        if (str2.endsWith("\"")) {
            str3 = str2.substring(0, str2.length() - 1);
        }
        return str3;
    }

    public RPattern getLContext() {
        return this.lContext;
    }

    public String getPattern() {
        return this.pattern;
    }

    public PhonemeExpr getPhoneme() {
        return this.phoneme;
    }

    public RPattern getRContext() {
        return this.rContext;
    }

    public boolean patternAndContextMatches(CharSequence charSequence, int i) {
        if (i >= 0) {
            int length = this.pattern.length() + i;
            if (length > charSequence.length()) {
                return false;
            }
            boolean equals = charSequence.subSequence(i, length).equals(this.pattern);
            boolean isMatch = this.rContext.isMatch(charSequence.subSequence(length, charSequence.length()));
            boolean isMatch2 = this.lContext.isMatch(charSequence.subSequence(0, i));
            boolean z = false;
            if (equals) {
                z = false;
                if (isMatch) {
                    z = false;
                    if (isMatch2) {
                        z = true;
                    }
                }
            }
            return z;
        }
        throw new IndexOutOfBoundsException("Can not match pattern at negative indexes");
    }
}
