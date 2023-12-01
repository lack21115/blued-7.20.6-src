package io.noties.markwon.inlineparser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.commonmark.internal.Bracket;
import org.commonmark.internal.Delimiter;
import org.commonmark.internal.inline.AsteriskDelimiterProcessor;
import org.commonmark.internal.inline.UnderscoreDelimiterProcessor;
import org.commonmark.internal.util.Escaping;
import org.commonmark.internal.util.LinkScanner;
import org.commonmark.node.LinkReferenceDefinition;
import org.commonmark.node.Node;
import org.commonmark.node.Text;
import org.commonmark.parser.InlineParser;
import org.commonmark.parser.InlineParserContext;
import org.commonmark.parser.InlineParserFactory;
import org.commonmark.parser.delimiter.DelimiterProcessor;

/* loaded from: source-3503164-dex2jar.jar:io/noties/markwon/inlineparser/MarkwonInlineParser.class */
public class MarkwonInlineParser implements MarkwonInlineParserContext, InlineParser {
    private static final String ASCII_PUNCTUATION = "!\"#\\$%&'\\(\\)\\*\\+,\\-\\./:;<=>\\?@\\[\\\\\\]\\^_`\\{\\|\\}~";
    private Node block;
    private final Map<Character, DelimiterProcessor> delimiterProcessors;
    private int index;
    private final InlineParserContext inlineParserContext;
    private final Map<Character, List<InlineProcessor>> inlineProcessors;
    private String input;
    private Bracket lastBracket;
    private Delimiter lastDelimiter;
    private final boolean referencesEnabled;
    private final BitSet specialCharacters;
    private static final Pattern PUNCTUATION = Pattern.compile("^[!\"#\\$%&'\\(\\)\\*\\+,\\-\\./:;<=>\\?@\\[\\\\\\]\\^_`\\{\\|\\}~\\p{Pc}\\p{Pd}\\p{Pe}\\p{Pf}\\p{Pi}\\p{Po}\\p{Ps}]");
    private static final Pattern SPNL = Pattern.compile("^ *(?:\n *)?");
    private static final Pattern UNICODE_WHITESPACE_CHAR = Pattern.compile("^[\\p{Zs}\t\r\n\f]");
    static final Pattern ESCAPABLE = Pattern.compile("^[!\"#$%&'()*+,./:;<=>?@\\[\\\\\\]^_`{|}~-]");
    static final Pattern WHITESPACE = Pattern.compile("\\s+");

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-3503164-dex2jar.jar:io/noties/markwon/inlineparser/MarkwonInlineParser$DelimiterData.class */
    public static class DelimiterData {
        final boolean canClose;
        final boolean canOpen;
        final int count;

        DelimiterData(int i, boolean z, boolean z2) {
            this.count = i;
            this.canOpen = z;
            this.canClose = z2;
        }
    }

    /* loaded from: source-3503164-dex2jar.jar:io/noties/markwon/inlineparser/MarkwonInlineParser$FactoryBuilder.class */
    public interface FactoryBuilder {
        FactoryBuilder addDelimiterProcessor(DelimiterProcessor delimiterProcessor);

        FactoryBuilder addInlineProcessor(InlineProcessor inlineProcessor);

        InlineParserFactory build();

        FactoryBuilder excludeDelimiterProcessor(Class<? extends DelimiterProcessor> cls);

        FactoryBuilder excludeInlineProcessor(Class<? extends InlineProcessor> cls);

        FactoryBuilder referencesEnabled(boolean z);
    }

    /* loaded from: source-3503164-dex2jar.jar:io/noties/markwon/inlineparser/MarkwonInlineParser$FactoryBuilderImpl.class */
    static class FactoryBuilderImpl implements FactoryBuilder, FactoryBuilderNoDefaults {
        private boolean referencesEnabled;
        private final List<InlineProcessor> inlineProcessors = new ArrayList(3);
        private final List<DelimiterProcessor> delimiterProcessors = new ArrayList(3);

        FactoryBuilderImpl() {
        }

        @Override // io.noties.markwon.inlineparser.MarkwonInlineParser.FactoryBuilder
        public FactoryBuilder addDelimiterProcessor(DelimiterProcessor delimiterProcessor) {
            this.delimiterProcessors.add(delimiterProcessor);
            return this;
        }

        @Override // io.noties.markwon.inlineparser.MarkwonInlineParser.FactoryBuilder
        public FactoryBuilder addInlineProcessor(InlineProcessor inlineProcessor) {
            this.inlineProcessors.add(inlineProcessor);
            return this;
        }

        @Override // io.noties.markwon.inlineparser.MarkwonInlineParser.FactoryBuilder
        public InlineParserFactory build() {
            return new InlineParserFactoryImpl(this.referencesEnabled, this.inlineProcessors, this.delimiterProcessors);
        }

        @Override // io.noties.markwon.inlineparser.MarkwonInlineParser.FactoryBuilder
        public FactoryBuilder excludeDelimiterProcessor(Class<? extends DelimiterProcessor> cls) {
            int size = this.delimiterProcessors.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= size) {
                    return this;
                }
                if (cls.equals(this.delimiterProcessors.get(i2).getClass())) {
                    this.delimiterProcessors.remove(i2);
                    return this;
                }
                i = i2 + 1;
            }
        }

        @Override // io.noties.markwon.inlineparser.MarkwonInlineParser.FactoryBuilder
        public FactoryBuilder excludeInlineProcessor(Class<? extends InlineProcessor> cls) {
            int size = this.inlineProcessors.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= size) {
                    return this;
                }
                if (cls.equals(this.inlineProcessors.get(i2).getClass())) {
                    this.inlineProcessors.remove(i2);
                    return this;
                }
                i = i2 + 1;
            }
        }

        @Override // io.noties.markwon.inlineparser.MarkwonInlineParser.FactoryBuilderNoDefaults
        public FactoryBuilder includeDefaults() {
            this.referencesEnabled = true;
            this.inlineProcessors.addAll(Arrays.asList(new AutolinkInlineProcessor(), new BackslashInlineProcessor(), new BackticksInlineProcessor(), new BangInlineProcessor(), new CloseBracketInlineProcessor(), new EntityInlineProcessor(), new HtmlInlineProcessor(), new NewLineInlineProcessor(), new OpenBracketInlineProcessor()));
            this.delimiterProcessors.addAll(Arrays.asList(new AsteriskDelimiterProcessor(), new UnderscoreDelimiterProcessor()));
            return this;
        }

        @Override // io.noties.markwon.inlineparser.MarkwonInlineParser.FactoryBuilder
        public FactoryBuilder referencesEnabled(boolean z) {
            this.referencesEnabled = z;
            return this;
        }
    }

    /* loaded from: source-3503164-dex2jar.jar:io/noties/markwon/inlineparser/MarkwonInlineParser$FactoryBuilderNoDefaults.class */
    public interface FactoryBuilderNoDefaults extends FactoryBuilder {
        FactoryBuilder includeDefaults();
    }

    /* loaded from: source-3503164-dex2jar.jar:io/noties/markwon/inlineparser/MarkwonInlineParser$InlineParserFactoryImpl.class */
    static class InlineParserFactoryImpl implements InlineParserFactory {
        private final List<DelimiterProcessor> delimiterProcessors;
        private final List<InlineProcessor> inlineProcessors;
        private final boolean referencesEnabled;

        InlineParserFactoryImpl(boolean z, List<InlineProcessor> list, List<DelimiterProcessor> list2) {
            this.referencesEnabled = z;
            this.inlineProcessors = list;
            this.delimiterProcessors = list2;
        }

        @Override // org.commonmark.parser.InlineParserFactory
        public InlineParser create(InlineParserContext inlineParserContext) {
            ArrayList arrayList;
            List<DelimiterProcessor> a2 = inlineParserContext.a();
            int size = a2 != null ? a2.size() : 0;
            if (size > 0) {
                arrayList = new ArrayList(size + this.delimiterProcessors.size());
                arrayList.addAll(this.delimiterProcessors);
                arrayList.addAll(a2);
            } else {
                arrayList = this.delimiterProcessors;
            }
            return new MarkwonInlineParser(inlineParserContext, this.referencesEnabled, this.inlineProcessors, arrayList);
        }
    }

    public MarkwonInlineParser(InlineParserContext inlineParserContext, boolean z, List<InlineProcessor> list, List<DelimiterProcessor> list2) {
        this.inlineParserContext = inlineParserContext;
        this.referencesEnabled = z;
        this.inlineProcessors = calculateInlines(list);
        this.delimiterProcessors = calculateDelimiterProcessors(list2);
        this.specialCharacters = calculateSpecialCharacters(this.inlineProcessors.keySet(), this.delimiterProcessors.keySet());
    }

    private static void addDelimiterProcessorForChar(char c2, DelimiterProcessor delimiterProcessor, Map<Character, DelimiterProcessor> map) {
        if (map.put(Character.valueOf(c2), delimiterProcessor) == null) {
            return;
        }
        throw new IllegalArgumentException("Delimiter processor conflict with delimiter char '" + c2 + "'");
    }

    private static void addDelimiterProcessors(Iterable<DelimiterProcessor> iterable, Map<Character, DelimiterProcessor> map) {
        StaggeredDelimiterProcessor staggeredDelimiterProcessor;
        for (DelimiterProcessor delimiterProcessor : iterable) {
            char openingCharacter = delimiterProcessor.getOpeningCharacter();
            char closingCharacter = delimiterProcessor.getClosingCharacter();
            if (openingCharacter == closingCharacter) {
                DelimiterProcessor delimiterProcessor2 = map.get(Character.valueOf(openingCharacter));
                if (delimiterProcessor2 == null || delimiterProcessor2.getOpeningCharacter() != delimiterProcessor2.getClosingCharacter()) {
                    addDelimiterProcessorForChar(openingCharacter, delimiterProcessor, map);
                } else {
                    if (delimiterProcessor2 instanceof StaggeredDelimiterProcessor) {
                        staggeredDelimiterProcessor = (StaggeredDelimiterProcessor) delimiterProcessor2;
                    } else {
                        staggeredDelimiterProcessor = new StaggeredDelimiterProcessor(openingCharacter);
                        staggeredDelimiterProcessor.add(delimiterProcessor2);
                    }
                    staggeredDelimiterProcessor.add(delimiterProcessor);
                    map.put(Character.valueOf(openingCharacter), staggeredDelimiterProcessor);
                }
            } else {
                addDelimiterProcessorForChar(openingCharacter, delimiterProcessor, map);
                addDelimiterProcessorForChar(closingCharacter, delimiterProcessor, map);
            }
        }
    }

    private static Map<Character, DelimiterProcessor> calculateDelimiterProcessors(List<DelimiterProcessor> list) {
        HashMap hashMap = new HashMap();
        addDelimiterProcessors(list, hashMap);
        return hashMap;
    }

    private static Map<Character, List<InlineProcessor>> calculateInlines(List<InlineProcessor> list) {
        HashMap hashMap = new HashMap(list.size());
        for (InlineProcessor inlineProcessor : list) {
            char specialCharacter = inlineProcessor.specialCharacter();
            List list2 = (List) hashMap.get(Character.valueOf(specialCharacter));
            ArrayList arrayList = list2;
            if (list2 == null) {
                arrayList = new ArrayList(1);
                hashMap.put(Character.valueOf(specialCharacter), arrayList);
            }
            arrayList.add(inlineProcessor);
        }
        return hashMap;
    }

    private static BitSet calculateSpecialCharacters(Set<Character> set, Set<Character> set2) {
        BitSet bitSet = new BitSet();
        for (Character ch : set) {
            bitSet.set(ch.charValue());
        }
        for (Character ch2 : set2) {
            bitSet.set(ch2.charValue());
        }
        return bitSet;
    }

    public static FactoryBuilder factoryBuilder() {
        return new FactoryBuilderImpl().includeDefaults();
    }

    public static FactoryBuilderNoDefaults factoryBuilderNoDefaults() {
        return new FactoryBuilderImpl();
    }

    private Node parseDelimiters(DelimiterProcessor delimiterProcessor, char c2) {
        DelimiterData scanDelimiters = scanDelimiters(delimiterProcessor, c2);
        if (scanDelimiters == null) {
            return null;
        }
        int i = scanDelimiters.count;
        int i2 = this.index;
        int i3 = i2 + i;
        this.index = i3;
        Text text = text(this.input, i2, i3);
        Delimiter delimiter = new Delimiter(text, c2, scanDelimiters.canOpen, scanDelimiters.canClose, this.lastDelimiter);
        this.lastDelimiter = delimiter;
        delimiter.g = i;
        this.lastDelimiter.h = i;
        if (this.lastDelimiter.e != null) {
            this.lastDelimiter.e.f = this.lastDelimiter;
        }
        return text;
    }

    private Node parseInline() {
        char peek = peek();
        Node node = null;
        if (peek == 0) {
            return null;
        }
        List<InlineProcessor> list = this.inlineProcessors.get(Character.valueOf(peek));
        if (list != null) {
            Iterator<InlineProcessor> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Node parse = it.next().parse(this);
                node = parse;
                if (parse != null) {
                    node = parse;
                    break;
                }
            }
        } else {
            DelimiterProcessor delimiterProcessor = this.delimiterProcessors.get(Character.valueOf(peek));
            node = delimiterProcessor != null ? parseDelimiters(delimiterProcessor, peek) : parseString();
        }
        if (node != null) {
            return node;
        }
        this.index++;
        return text(String.valueOf(peek));
    }

    private Node parseString() {
        int i = this.index;
        int length = this.input.length();
        while (true) {
            int i2 = this.index;
            if (i2 == length || this.specialCharacters.get(this.input.charAt(i2))) {
                break;
            }
            this.index++;
        }
        int i3 = this.index;
        if (i != i3) {
            return text(this.input, i, i3);
        }
        return null;
    }

    private void removeDelimiter(Delimiter delimiter) {
        if (delimiter.e != null) {
            delimiter.e.f = delimiter.f;
        }
        if (delimiter.f == null) {
            this.lastDelimiter = delimiter.e;
            return;
        }
        delimiter.f.e = delimiter.e;
    }

    private void removeDelimiterAndNode(Delimiter delimiter) {
        delimiter.f44009a.l();
        removeDelimiter(delimiter);
    }

    private void removeDelimiterKeepNode(Delimiter delimiter) {
        removeDelimiter(delimiter);
    }

    private void removeDelimitersBetween(Delimiter delimiter, Delimiter delimiter2) {
        Delimiter delimiter3 = delimiter2.e;
        while (true) {
            Delimiter delimiter4 = delimiter3;
            if (delimiter4 == null || delimiter4 == delimiter) {
                return;
            }
            Delimiter delimiter5 = delimiter4.e;
            removeDelimiterKeepNode(delimiter4);
            delimiter3 = delimiter5;
        }
    }

    private void reset(String str) {
        this.input = str;
        this.index = 0;
        this.lastDelimiter = null;
        this.lastBracket = null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:53:0x0118, code lost:
        if (r0 != false) goto L50;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private io.noties.markwon.inlineparser.MarkwonInlineParser.DelimiterData scanDelimiters(org.commonmark.parser.delimiter.DelimiterProcessor r7, char r8) {
        /*
            Method dump skipped, instructions count: 371
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.noties.markwon.inlineparser.MarkwonInlineParser.scanDelimiters(org.commonmark.parser.delimiter.DelimiterProcessor, char):io.noties.markwon.inlineparser.MarkwonInlineParser$DelimiterData");
    }

    @Override // io.noties.markwon.inlineparser.MarkwonInlineParserContext
    public void addBracket(Bracket bracket) {
        Bracket bracket2 = this.lastBracket;
        if (bracket2 != null) {
            bracket2.g = true;
        }
        this.lastBracket = bracket;
    }

    @Override // io.noties.markwon.inlineparser.MarkwonInlineParserContext
    public Node block() {
        return this.block;
    }

    @Override // io.noties.markwon.inlineparser.MarkwonInlineParserContext
    public LinkReferenceDefinition getLinkReferenceDefinition(String str) {
        if (this.referencesEnabled) {
            return this.inlineParserContext.a(str);
        }
        return null;
    }

    @Override // io.noties.markwon.inlineparser.MarkwonInlineParserContext
    public int index() {
        return this.index;
    }

    @Override // io.noties.markwon.inlineparser.MarkwonInlineParserContext
    public String input() {
        return this.input;
    }

    @Override // io.noties.markwon.inlineparser.MarkwonInlineParserContext
    public Bracket lastBracket() {
        return this.lastBracket;
    }

    @Override // io.noties.markwon.inlineparser.MarkwonInlineParserContext
    public Delimiter lastDelimiter() {
        return this.lastDelimiter;
    }

    @Override // io.noties.markwon.inlineparser.MarkwonInlineParserContext
    public String match(Pattern pattern) {
        if (this.index >= this.input.length()) {
            return null;
        }
        Matcher matcher = pattern.matcher(this.input);
        matcher.region(this.index, this.input.length());
        if (matcher.find()) {
            this.index = matcher.end();
            return matcher.group();
        }
        return null;
    }

    @Override // org.commonmark.parser.InlineParser
    public void parse(String str, Node node) {
        reset(str.trim());
        this.block = node;
        while (true) {
            Node parseInline = parseInline();
            if (parseInline == null) {
                processDelimiters(null);
                InlineParserUtils.mergeChildTextNodes(node);
                return;
            }
            node.b(parseInline);
        }
    }

    @Override // io.noties.markwon.inlineparser.MarkwonInlineParserContext
    public String parseLinkDestination() {
        int b = LinkScanner.b(this.input, this.index);
        if (b == -1) {
            return null;
        }
        String substring = peek() == '<' ? this.input.substring(this.index + 1, b - 1) : this.input.substring(this.index, b);
        this.index = b;
        return Escaping.b(substring);
    }

    @Override // io.noties.markwon.inlineparser.MarkwonInlineParserContext
    public int parseLinkLabel() {
        if (this.index >= this.input.length() || this.input.charAt(this.index) != '[') {
            return 0;
        }
        int i = this.index + 1;
        int a2 = LinkScanner.a(this.input, i);
        int i2 = a2 - i;
        if (a2 == -1 || i2 > 999 || a2 >= this.input.length() || this.input.charAt(a2) != ']') {
            return 0;
        }
        this.index = a2 + 1;
        return i2 + 2;
    }

    @Override // io.noties.markwon.inlineparser.MarkwonInlineParserContext
    public String parseLinkTitle() {
        int c2 = LinkScanner.c(this.input, this.index);
        if (c2 == -1) {
            return null;
        }
        String substring = this.input.substring(this.index + 1, c2 - 1);
        this.index = c2;
        return Escaping.b(substring);
    }

    @Override // io.noties.markwon.inlineparser.MarkwonInlineParserContext
    public char peek() {
        if (this.index < this.input.length()) {
            return this.input.charAt(this.index);
        }
        return (char) 0;
    }

    @Override // io.noties.markwon.inlineparser.MarkwonInlineParserContext
    public void processDelimiters(Delimiter delimiter) {
        Delimiter delimiter2;
        boolean z;
        boolean z2;
        HashMap hashMap = new HashMap();
        Delimiter delimiter3 = this.lastDelimiter;
        while (true) {
            Delimiter delimiter4 = delimiter3;
            delimiter2 = delimiter4;
            if (delimiter4 == null) {
                break;
            }
            delimiter2 = delimiter4;
            if (delimiter4.e == delimiter) {
                break;
            }
            delimiter3 = delimiter4.e;
        }
        while (delimiter2 != null) {
            char c2 = delimiter2.b;
            DelimiterProcessor delimiterProcessor = this.delimiterProcessors.get(Character.valueOf(c2));
            if (!delimiter2.d || delimiterProcessor == null) {
                delimiter2 = delimiter2.f;
            } else {
                char openingCharacter = delimiterProcessor.getOpeningCharacter();
                Delimiter delimiter5 = delimiter2.e;
                int i = 0;
                boolean z3 = false;
                while (true) {
                    z = z3;
                    if (delimiter5 == null || delimiter5 == delimiter || delimiter5 == hashMap.get(Character.valueOf(c2))) {
                        break;
                    }
                    int i2 = i;
                    boolean z4 = z;
                    if (delimiter5.f44010c) {
                        i2 = i;
                        z4 = z;
                        if (delimiter5.b == openingCharacter) {
                            i = delimiterProcessor.getDelimiterUse(delimiter5, delimiter2);
                            z = true;
                            z4 = true;
                            i2 = i;
                            if (i > 0) {
                                z2 = true;
                                break;
                            }
                        } else {
                            continue;
                        }
                    }
                    delimiter5 = delimiter5.e;
                    i = i2;
                    z3 = z4;
                }
                z2 = false;
                if (z2) {
                    Text text = delimiter5.f44009a;
                    Text text2 = delimiter2.f44009a;
                    delimiter5.g -= i;
                    delimiter2.g -= i;
                    text.a(text.a().substring(0, text.a().length() - i));
                    text2.a(text2.a().substring(0, text2.a().length() - i));
                    removeDelimitersBetween(delimiter5, delimiter2);
                    InlineParserUtils.mergeTextNodesBetweenExclusive(text, text2);
                    delimiterProcessor.process(text, text2, i);
                    if (delimiter5.g == 0) {
                        removeDelimiterAndNode(delimiter5);
                    }
                    if (delimiter2.g == 0) {
                        Delimiter delimiter6 = delimiter2.f;
                        removeDelimiterAndNode(delimiter2);
                        delimiter2 = delimiter6;
                    }
                } else {
                    if (!z) {
                        hashMap.put(Character.valueOf(c2), delimiter2.e);
                        if (!delimiter2.f44010c) {
                            removeDelimiterKeepNode(delimiter2);
                        }
                    }
                    delimiter2 = delimiter2.f;
                }
            }
        }
        while (true) {
            Delimiter delimiter7 = this.lastDelimiter;
            if (delimiter7 == null || delimiter7 == delimiter) {
                return;
            }
            removeDelimiterKeepNode(delimiter7);
        }
    }

    @Override // io.noties.markwon.inlineparser.MarkwonInlineParserContext
    public void removeLastBracket() {
        this.lastBracket = this.lastBracket.d;
    }

    @Override // io.noties.markwon.inlineparser.MarkwonInlineParserContext
    public void setIndex(int i) {
        this.index = i;
    }

    @Override // io.noties.markwon.inlineparser.MarkwonInlineParserContext
    public void spnl() {
        match(SPNL);
    }

    @Override // io.noties.markwon.inlineparser.MarkwonInlineParserContext
    public Text text(String str) {
        return new Text(str);
    }

    @Override // io.noties.markwon.inlineparser.MarkwonInlineParserContext
    public Text text(String str, int i, int i2) {
        return new Text(str.substring(i, i2));
    }
}
