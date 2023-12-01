package org.commonmark.internal;

import android.webkit.WebView;
import java.util.Arrays;
import java.util.BitSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.commonmark.internal.inline.AsteriskDelimiterProcessor;
import org.commonmark.internal.inline.UnderscoreDelimiterProcessor;
import org.commonmark.internal.util.Escaping;
import org.commonmark.internal.util.Html5Entities;
import org.commonmark.internal.util.LinkScanner;
import org.commonmark.internal.util.Parsing;
import org.commonmark.node.Code;
import org.commonmark.node.HardLineBreak;
import org.commonmark.node.HtmlInline;
import org.commonmark.node.Link;
import org.commonmark.node.Node;
import org.commonmark.node.SoftLineBreak;
import org.commonmark.node.Text;
import org.commonmark.parser.InlineParser;
import org.commonmark.parser.InlineParserContext;
import org.commonmark.parser.delimiter.DelimiterProcessor;

/* loaded from: source-3503164-dex2jar.jar:org/commonmark/internal/InlineParserImpl.class */
public class InlineParserImpl implements InlineParser {
    private static final Pattern a = Pattern.compile("^[!\"#\\$%&'\\(\\)\\*\\+,\\-\\./:;<=>\\?@\\[\\\\\\]\\^_`\\{\\|\\}~\\p{Pc}\\p{Pd}\\p{Pe}\\p{Pf}\\p{Pi}\\p{Po}\\p{Ps}]");
    private static final Pattern b = Pattern.compile("^(?:<[A-Za-z][A-Za-z0-9-]*(?:\\s+[a-zA-Z_:][a-zA-Z0-9:._-]*(?:\\s*=\\s*(?:[^\"'=<>`\\x00-\\x20]+|'[^']*'|\"[^\"]*\"))?)*\\s*/?>|</[A-Za-z][A-Za-z0-9-]*\\s*[>]|<!---->|<!--(?:-?[^>-])(?:-?[^-])*-->|[<][?].*?[?][>]|<![A-Z]+\\s+[^>]*>|<!\\[CDATA\\[[\\s\\S]*?\\]\\]>)", 2);
    private static final Pattern c = Pattern.compile("^[!\"#$%&'()*+,./:;<=>?@\\[\\\\\\]^_`{|}~-]");
    private static final Pattern d = Pattern.compile("^&(?:#x[a-f0-9]{1,6}|#[0-9]{1,7}|[a-z][a-z0-9]{1,31});", 2);
    private static final Pattern e = Pattern.compile("`+");
    private static final Pattern f = Pattern.compile("^`+");
    private static final Pattern g = Pattern.compile("^<([a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*)>");
    private static final Pattern h = Pattern.compile("^<[a-zA-Z][a-zA-Z0-9.+-]{1,31}:[^<>��- ]*>");
    private static final Pattern i = Pattern.compile("^ *(?:\n *)?");
    private static final Pattern j = Pattern.compile("^[\\p{Zs}\t\r\n\f]");
    private static final Pattern k = Pattern.compile("\\s+");
    private static final Pattern l = Pattern.compile(" *$");
    private final BitSet m;
    private final BitSet n;
    private final Map<Character, DelimiterProcessor> o;
    private final InlineParserContext p;
    private String q;
    private int r;
    private Delimiter s;
    private Bracket t;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-3503164-dex2jar.jar:org/commonmark/internal/InlineParserImpl$DelimiterData.class */
    public static class DelimiterData {
        final int a;
        final boolean b;
        final boolean c;

        DelimiterData(int i, boolean z, boolean z2) {
            this.a = i;
            this.c = z;
            this.b = z2;
        }
    }

    public InlineParserImpl(InlineParserContext inlineParserContext) {
        Map<Character, DelimiterProcessor> a2 = a(inlineParserContext.a());
        this.o = a2;
        BitSet a3 = a(a2.keySet());
        this.n = a3;
        this.m = a(a3);
        this.p = inlineParserContext;
    }

    private String a(Pattern pattern) {
        if (this.r >= this.q.length()) {
            return null;
        }
        Matcher matcher = pattern.matcher(this.q);
        matcher.region(this.r, this.q.length());
        if (matcher.find()) {
            this.r = matcher.end();
            return matcher.group();
        }
        return null;
    }

    public static BitSet a(BitSet bitSet) {
        BitSet bitSet2 = new BitSet();
        bitSet2.or(bitSet);
        bitSet2.set(10);
        bitSet2.set(96);
        bitSet2.set(91);
        bitSet2.set(93);
        bitSet2.set(92);
        bitSet2.set(33);
        bitSet2.set(60);
        bitSet2.set(38);
        return bitSet2;
    }

    public static BitSet a(Set<Character> set) {
        BitSet bitSet = new BitSet();
        for (Character ch : set) {
            bitSet.set(ch.charValue());
        }
        return bitSet;
    }

    public static Map<Character, DelimiterProcessor> a(List<DelimiterProcessor> list) {
        HashMap hashMap = new HashMap();
        a(Arrays.asList(new AsteriskDelimiterProcessor(), new UnderscoreDelimiterProcessor()), hashMap);
        a(list, hashMap);
        return hashMap;
    }

    private Node a(Node node) {
        Node b2;
        char b3 = b();
        if (b3 == 0) {
            return null;
        }
        if (b3 == '\n') {
            b2 = b(node);
        } else if (b3 == '!') {
            b2 = g();
        } else if (b3 == '&') {
            b2 = n();
        } else if (b3 == '<') {
            Node l2 = l();
            b2 = l2;
            if (l2 == null) {
                b2 = m();
            }
        } else if (b3 != '`') {
            switch (b3) {
                case '[':
                    b2 = f();
                    break;
                case '\\':
                    b2 = d();
                    break;
                case ']':
                    b2 = h();
                    break;
                default:
                    if (!this.n.get(b3)) {
                        b2 = o();
                        break;
                    } else {
                        b2 = a(this.o.get(Character.valueOf(b3)), b3);
                        break;
                    }
            }
        } else {
            b2 = e();
        }
        if (b2 != null) {
            return b2;
        }
        this.r++;
        return b(String.valueOf(b3));
    }

    private Node a(DelimiterProcessor delimiterProcessor, char c2) {
        DelimiterData b2 = b(delimiterProcessor, c2);
        if (b2 == null) {
            return null;
        }
        int i2 = b2.a;
        int i3 = this.r;
        int i4 = i3 + i2;
        this.r = i4;
        Text a2 = a(this.q, i3, i4);
        Delimiter delimiter = new Delimiter(a2, c2, b2.c, b2.b, this.s);
        this.s = delimiter;
        delimiter.g = i2;
        this.s.h = i2;
        if (this.s.e != null) {
            this.s.e.f = this.s;
        }
        return a2;
    }

    private Text a(String str, int i2, int i3) {
        return new Text(str.substring(i2, i3));
    }

    private static void a(char c2, DelimiterProcessor delimiterProcessor, Map<Character, DelimiterProcessor> map) {
        if (map.put(Character.valueOf(c2), delimiterProcessor) == null) {
            return;
        }
        throw new IllegalArgumentException("Delimiter processor conflict with delimiter char '" + c2 + "'");
    }

    private static void a(Iterable<DelimiterProcessor> iterable, Map<Character, DelimiterProcessor> map) {
        StaggeredDelimiterProcessor staggeredDelimiterProcessor;
        for (DelimiterProcessor delimiterProcessor : iterable) {
            char openingCharacter = delimiterProcessor.getOpeningCharacter();
            char closingCharacter = delimiterProcessor.getClosingCharacter();
            if (openingCharacter == closingCharacter) {
                DelimiterProcessor delimiterProcessor2 = map.get(Character.valueOf(openingCharacter));
                if (delimiterProcessor2 == null || delimiterProcessor2.getOpeningCharacter() != delimiterProcessor2.getClosingCharacter()) {
                    a(openingCharacter, delimiterProcessor, map);
                } else {
                    if (delimiterProcessor2 instanceof StaggeredDelimiterProcessor) {
                        staggeredDelimiterProcessor = (StaggeredDelimiterProcessor) delimiterProcessor2;
                    } else {
                        staggeredDelimiterProcessor = new StaggeredDelimiterProcessor(openingCharacter);
                        staggeredDelimiterProcessor.a(delimiterProcessor2);
                    }
                    staggeredDelimiterProcessor.a(delimiterProcessor);
                    map.put(Character.valueOf(openingCharacter), staggeredDelimiterProcessor);
                }
            } else {
                a(openingCharacter, delimiterProcessor, map);
                a(closingCharacter, delimiterProcessor, map);
            }
        }
    }

    private void a(Bracket bracket) {
        Bracket bracket2 = this.t;
        if (bracket2 != null) {
            bracket2.g = true;
        }
        this.t = bracket;
    }

    private void a(Delimiter delimiter) {
        Delimiter delimiter2;
        boolean z;
        boolean z2;
        HashMap hashMap = new HashMap();
        Delimiter delimiter3 = this.s;
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
            DelimiterProcessor delimiterProcessor = this.o.get(Character.valueOf(c2));
            if (!delimiter2.d || delimiterProcessor == null) {
                delimiter2 = delimiter2.f;
            } else {
                char openingCharacter = delimiterProcessor.getOpeningCharacter();
                Delimiter delimiter5 = delimiter2.e;
                int i2 = 0;
                boolean z3 = false;
                while (true) {
                    z = z3;
                    if (delimiter5 == null || delimiter5 == delimiter || delimiter5 == hashMap.get(Character.valueOf(c2))) {
                        break;
                    }
                    int i3 = i2;
                    boolean z4 = z;
                    if (delimiter5.c) {
                        i3 = i2;
                        z4 = z;
                        if (delimiter5.b == openingCharacter) {
                            i2 = delimiterProcessor.getDelimiterUse(delimiter5, delimiter2);
                            z = true;
                            z4 = true;
                            i3 = i2;
                            if (i2 > 0) {
                                z2 = true;
                                break;
                            }
                        } else {
                            continue;
                        }
                    }
                    delimiter5 = delimiter5.e;
                    i2 = i3;
                    z3 = z4;
                }
                z2 = false;
                if (z2) {
                    Text text = delimiter5.a;
                    Text text2 = delimiter2.a;
                    delimiter5.g -= i2;
                    delimiter2.g -= i2;
                    text.a(text.a().substring(0, text.a().length() - i2));
                    text2.a(text2.a().substring(0, text2.a().length() - i2));
                    a(delimiter5, delimiter2);
                    a(text, text2);
                    delimiterProcessor.process(text, text2, i2);
                    if (delimiter5.g == 0) {
                        b(delimiter5);
                    }
                    if (delimiter2.g == 0) {
                        Delimiter delimiter6 = delimiter2.f;
                        b(delimiter2);
                        delimiter2 = delimiter6;
                    }
                } else {
                    if (!z) {
                        hashMap.put(Character.valueOf(c2), delimiter2.e);
                        if (!delimiter2.c) {
                            c(delimiter2);
                        }
                    }
                    delimiter2 = delimiter2.f;
                }
            }
        }
        while (true) {
            Delimiter delimiter7 = this.s;
            if (delimiter7 == null || delimiter7 == delimiter) {
                return;
            }
            c(delimiter7);
        }
    }

    private void a(Delimiter delimiter, Delimiter delimiter2) {
        Delimiter delimiter3 = delimiter2.e;
        while (true) {
            Delimiter delimiter4 = delimiter3;
            if (delimiter4 == null || delimiter4 == delimiter) {
                return;
            }
            Delimiter delimiter5 = delimiter4.e;
            c(delimiter4);
            delimiter3 = delimiter5;
        }
    }

    private void a(Node node, Node node2) {
        if (node == node2 || node.h() == node2) {
            return;
        }
        b(node.h(), node2.i());
    }

    private void a(Text text, Text text2, int i2) {
        if (text == null || text2 == null || text == text2) {
            return;
        }
        StringBuilder sb = new StringBuilder(i2);
        sb.append(text.a());
        Node h2 = text.h();
        Node h3 = text2.h();
        while (true) {
            Node node = h2;
            if (node == h3) {
                text.a(sb.toString());
                return;
            }
            sb.append(((Text) node).a());
            h2 = node.h();
            node.l();
        }
    }

    private char b() {
        if (this.r < this.q.length()) {
            return this.q.charAt(this.r);
        }
        return (char) 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:53:0x0118, code lost:
        if (r0 != false) goto L50;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private org.commonmark.internal.InlineParserImpl.DelimiterData b(org.commonmark.parser.delimiter.DelimiterProcessor r7, char r8) {
        /*
            Method dump skipped, instructions count: 371
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.commonmark.internal.InlineParserImpl.b(org.commonmark.parser.delimiter.DelimiterProcessor, char):org.commonmark.internal.InlineParserImpl$DelimiterData");
    }

    private Node b(Node node) {
        this.r++;
        if (node instanceof Text) {
            Text text = (Text) node;
            if (text.a().endsWith(" ")) {
                String a2 = text.a();
                Matcher matcher = l.matcher(a2);
                int end = matcher.find() ? matcher.end() - matcher.start() : 0;
                if (end > 0) {
                    text.a(a2.substring(0, a2.length() - end));
                }
                return end >= 2 ? new HardLineBreak() : new SoftLineBreak();
            }
        }
        return new SoftLineBreak();
    }

    private Text b(String str) {
        return new Text(str);
    }

    private void b(Delimiter delimiter) {
        delimiter.a.l();
        d(delimiter);
    }

    private void b(Node node, Node node2) {
        Text text;
        Text text2;
        int i2;
        Text text3 = null;
        int i3 = 0;
        Node node3 = node;
        Text text4 = null;
        while (true) {
            text = text4;
            text2 = text3;
            i2 = i3;
            if (node3 == null) {
                break;
            }
            if (node3 instanceof Text) {
                Text text5 = (Text) node3;
                Text text6 = text4;
                if (text4 == null) {
                    text6 = text5;
                }
                i3 += text5.a().length();
                text4 = text6;
                text3 = text5;
            } else {
                a(text4, text3, i3);
                text4 = null;
                text3 = null;
                i3 = 0;
            }
            if (node3 == node2) {
                text = text4;
                text2 = text3;
                i2 = i3;
                break;
            }
            node3 = node3.h();
        }
        a(text, text2, i2);
    }

    private void c() {
        a(i);
    }

    private void c(Delimiter delimiter) {
        d(delimiter);
    }

    private void c(Node node) {
        if (node.j() == node.k()) {
            return;
        }
        b(node.j(), node.k());
    }

    private Node d() {
        this.r++;
        if (b() == '\n') {
            HardLineBreak hardLineBreak = new HardLineBreak();
            this.r++;
            return hardLineBreak;
        }
        if (this.r < this.q.length()) {
            Pattern pattern = c;
            String str = this.q;
            int i2 = this.r;
            if (pattern.matcher(str.substring(i2, i2 + 1)).matches()) {
                String str2 = this.q;
                int i3 = this.r;
                Text a2 = a(str2, i3, i3 + 1);
                this.r++;
                return a2;
            }
        }
        return b("\\");
    }

    private void d(Delimiter delimiter) {
        if (delimiter.e != null) {
            delimiter.e.f = delimiter.f;
        }
        if (delimiter.f == null) {
            this.s = delimiter.e;
            return;
        }
        delimiter.f.e = delimiter.e;
    }

    private Node e() {
        String a2;
        String a3 = a(f);
        if (a3 == null) {
            return null;
        }
        int i2 = this.r;
        do {
            a2 = a(e);
            if (a2 == null) {
                this.r = i2;
                return b(a3);
            }
        } while (!a2.equals(a3));
        Code code = new Code();
        String replace = this.q.substring(i2, this.r - a3.length()).replace('\n', ' ');
        String str = replace;
        if (replace.length() >= 3) {
            str = replace;
            if (replace.charAt(0) == ' ') {
                str = replace;
                if (replace.charAt(replace.length() - 1) == ' ') {
                    str = replace;
                    if (Parsing.b(replace)) {
                        str = replace.substring(1, replace.length() - 1);
                    }
                }
            }
        }
        code.a(str);
        return code;
    }

    private Node f() {
        int i2 = this.r;
        this.r = i2 + 1;
        Text b2 = b("[");
        a(Bracket.a(b2, i2, this.t, this.s));
        return b2;
    }

    private Node g() {
        int i2 = this.r;
        this.r = i2 + 1;
        if (b() == '[') {
            this.r++;
            Text b2 = b("![");
            a(Bracket.b(b2, i2 + 1, this.t, this.s));
            return b2;
        }
        return b("!");
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01d4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private org.commonmark.node.Node h() {
        /*
            Method dump skipped, instructions count: 485
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.commonmark.internal.InlineParserImpl.h():org.commonmark.node.Node");
    }

    private void i() {
        this.t = this.t.d;
    }

    private String j() {
        int b2 = LinkScanner.b(this.q, this.r);
        if (b2 == -1) {
            return null;
        }
        String substring = b() == '<' ? this.q.substring(this.r + 1, b2 - 1) : this.q.substring(this.r, b2);
        this.r = b2;
        return Escaping.b(substring);
    }

    private String k() {
        int c2 = LinkScanner.c(this.q, this.r);
        if (c2 == -1) {
            return null;
        }
        String substring = this.q.substring(this.r + 1, c2 - 1);
        this.r = c2;
        return Escaping.b(substring);
    }

    private Node l() {
        String a2 = a(g);
        if (a2 != null) {
            String substring = a2.substring(1, a2.length() - 1);
            Link link = new Link(WebView.SCHEME_MAILTO + substring, null);
            link.b(new Text(substring));
            return link;
        }
        String a3 = a(h);
        if (a3 != null) {
            String substring2 = a3.substring(1, a3.length() - 1);
            Link link2 = new Link(substring2, null);
            link2.b(new Text(substring2));
            return link2;
        }
        return null;
    }

    private Node m() {
        String a2 = a(b);
        if (a2 != null) {
            HtmlInline htmlInline = new HtmlInline();
            htmlInline.a(a2);
            return htmlInline;
        }
        return null;
    }

    private Node n() {
        String a2 = a(d);
        if (a2 != null) {
            return b(Html5Entities.a(a2));
        }
        return null;
    }

    private Node o() {
        int i2 = this.r;
        int length = this.q.length();
        while (true) {
            int i3 = this.r;
            if (i3 == length || this.m.get(this.q.charAt(i3))) {
                break;
            }
            this.r++;
        }
        int i4 = this.r;
        if (i2 != i4) {
            return a(this.q, i2, i4);
        }
        return null;
    }

    int a() {
        if (this.r >= this.q.length() || this.q.charAt(this.r) != '[') {
            return 0;
        }
        int i2 = this.r + 1;
        int a2 = LinkScanner.a(this.q, i2);
        int i3 = a2 - i2;
        if (a2 == -1 || i3 > 999 || a2 >= this.q.length() || this.q.charAt(a2) != ']') {
            return 0;
        }
        this.r = a2 + 1;
        return i3 + 2;
    }

    void a(String str) {
        this.q = str;
        this.r = 0;
        this.s = null;
        this.t = null;
    }

    @Override // org.commonmark.parser.InlineParser
    public void parse(String str, Node node) {
        a(str.trim());
        Node node2 = null;
        while (true) {
            node2 = a(node2);
            if (node2 == null) {
                a((Delimiter) null);
                c(node);
                return;
            }
            node.b(node2);
        }
    }
}
