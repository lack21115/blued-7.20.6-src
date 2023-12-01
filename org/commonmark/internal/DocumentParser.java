package org.commonmark.internal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.commonmark.internal.BlockQuoteParser;
import org.commonmark.internal.FencedCodeBlockParser;
import org.commonmark.internal.HeadingParser;
import org.commonmark.internal.HtmlBlockParser;
import org.commonmark.internal.IndentedCodeBlockParser;
import org.commonmark.internal.ListBlockParser;
import org.commonmark.internal.ThematicBreakParser;
import org.commonmark.internal.util.Parsing;
import org.commonmark.node.Block;
import org.commonmark.node.BlockQuote;
import org.commonmark.node.Document;
import org.commonmark.node.FencedCodeBlock;
import org.commonmark.node.Heading;
import org.commonmark.node.HtmlBlock;
import org.commonmark.node.IndentedCodeBlock;
import org.commonmark.node.LinkReferenceDefinition;
import org.commonmark.node.ListBlock;
import org.commonmark.node.ThematicBreak;
import org.commonmark.parser.InlineParser;
import org.commonmark.parser.InlineParserFactory;
import org.commonmark.parser.block.BlockParser;
import org.commonmark.parser.block.BlockParserFactory;
import org.commonmark.parser.block.BlockStart;
import org.commonmark.parser.block.MatchedBlockParser;
import org.commonmark.parser.block.ParserState;
import org.commonmark.parser.delimiter.DelimiterProcessor;

/* loaded from: source-3503164-dex2jar.jar:org/commonmark/internal/DocumentParser.class */
public class DocumentParser implements ParserState {

    /* renamed from: a  reason: collision with root package name */
    private static final Set<Class<? extends Block>> f44012a = new LinkedHashSet(Arrays.asList(BlockQuote.class, Heading.class, FencedCodeBlock.class, HtmlBlock.class, ThematicBreak.class, ListBlock.class, IndentedCodeBlock.class));
    private static final Map<Class<? extends Block>, BlockParserFactory> b;

    /* renamed from: c  reason: collision with root package name */
    private CharSequence f44013c;
    private boolean f;
    private boolean j;
    private final List<BlockParserFactory> k;
    private final InlineParserFactory l;
    private final List<DelimiterProcessor> m;
    private final DocumentBlockParser n;
    private int d = 0;
    private int e = 0;
    private int g = 0;
    private int h = 0;
    private int i = 0;
    private final Map<String, LinkReferenceDefinition> o = new LinkedHashMap();
    private List<BlockParser> p = new ArrayList();
    private Set<BlockParser> q = new LinkedHashSet();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-3503164-dex2jar.jar:org/commonmark/internal/DocumentParser$MatchedBlockParserImpl.class */
    public static class MatchedBlockParserImpl implements MatchedBlockParser {

        /* renamed from: a  reason: collision with root package name */
        private final BlockParser f44014a;

        public MatchedBlockParserImpl(BlockParser blockParser) {
            this.f44014a = blockParser;
        }

        @Override // org.commonmark.parser.block.MatchedBlockParser
        public BlockParser a() {
            return this.f44014a;
        }

        @Override // org.commonmark.parser.block.MatchedBlockParser
        public CharSequence b() {
            BlockParser blockParser = this.f44014a;
            if (blockParser instanceof ParagraphParser) {
                CharSequence e = ((ParagraphParser) blockParser).e();
                if (e.length() == 0) {
                    return null;
                }
                return e;
            }
            return null;
        }
    }

    static {
        HashMap hashMap = new HashMap();
        hashMap.put(BlockQuote.class, new BlockQuoteParser.Factory());
        hashMap.put(Heading.class, new HeadingParser.Factory());
        hashMap.put(FencedCodeBlock.class, new FencedCodeBlockParser.Factory());
        hashMap.put(HtmlBlock.class, new HtmlBlockParser.Factory());
        hashMap.put(ThematicBreak.class, new ThematicBreakParser.Factory());
        hashMap.put(ListBlock.class, new ListBlockParser.Factory());
        hashMap.put(IndentedCodeBlock.class, new IndentedCodeBlockParser.Factory());
        b = Collections.unmodifiableMap(hashMap);
    }

    public DocumentParser(List<BlockParserFactory> list, InlineParserFactory inlineParserFactory, List<DelimiterProcessor> list2) {
        this.k = list;
        this.l = inlineParserFactory;
        this.m = list2;
        DocumentBlockParser documentBlockParser = new DocumentBlockParser();
        this.n = documentBlockParser;
        d(documentBlockParser);
    }

    public static List<BlockParserFactory> a(List<BlockParserFactory> list, Set<Class<? extends Block>> set) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(list);
        for (Class<? extends Block> cls : set) {
            arrayList.add(b.get(cls));
        }
        return arrayList;
    }

    public static Set<Class<? extends Block>> a() {
        return f44012a;
    }

    private BlockStartImpl a(BlockParser blockParser) {
        MatchedBlockParserImpl matchedBlockParserImpl = new MatchedBlockParserImpl(blockParser);
        for (BlockParserFactory blockParserFactory : this.k) {
            BlockStart a2 = blockParserFactory.a(this, matchedBlockParserImpl);
            if (a2 instanceof BlockStartImpl) {
                return (BlockStartImpl) a2;
            }
        }
        return null;
    }

    private void a(int i) {
        int i2 = this.g;
        if (i >= i2) {
            this.d = i2;
            this.e = this.h;
        }
        int length = this.f44013c.length();
        while (true) {
            int i3 = this.d;
            if (i3 >= i || i3 == length) {
                break;
            }
            j();
        }
        this.f = false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:53:0x01ae, code lost:
        a(r6.g);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(java.lang.CharSequence r7) {
        /*
            Method dump skipped, instructions count: 516
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.commonmark.internal.DocumentParser.a(java.lang.CharSequence):void");
    }

    private void a(List<BlockParser> list) {
        int size = list.size();
        while (true) {
            int i = size - 1;
            if (i < 0) {
                return;
            }
            b(list.get(i));
            size = i;
        }
    }

    private void a(ParagraphParser paragraphParser) {
        for (LinkReferenceDefinition linkReferenceDefinition : paragraphParser.f()) {
            paragraphParser.c().d(linkReferenceDefinition);
            String a2 = linkReferenceDefinition.a();
            if (!this.o.containsKey(a2)) {
                this.o.put(a2, linkReferenceDefinition);
            }
        }
    }

    private void b(int i) {
        int i2 = this.h;
        if (i >= i2) {
            this.d = this.g;
            this.e = i2;
        }
        int length = this.f44013c.length();
        while (this.e < i && this.d != length) {
            j();
        }
        if (this.e <= i) {
            this.f = false;
            return;
        }
        this.d--;
        this.e = i;
        this.f = true;
    }

    private void b(BlockParser blockParser) {
        if (h() == blockParser) {
            m();
        }
        if (blockParser instanceof ParagraphParser) {
            a((ParagraphParser) blockParser);
        }
        blockParser.b();
    }

    private <T extends BlockParser> T c(T t) {
        while (!h().a(t.c())) {
            b(h());
        }
        h().c().b(t.c());
        d(t);
        return t;
    }

    private void d(BlockParser blockParser) {
        this.p.add(blockParser);
        this.q.add(blockParser);
    }

    private void i() {
        int i = this.d;
        int i2 = this.e;
        this.j = true;
        int length = this.f44013c.length();
        while (true) {
            if (i >= length) {
                break;
            }
            char charAt = this.f44013c.charAt(i);
            if (charAt == '\t') {
                i++;
                i2 += 4 - (i2 % 4);
            } else if (charAt != ' ') {
                this.j = false;
                break;
            } else {
                i++;
                i2++;
            }
        }
        this.g = i;
        this.h = i2;
        this.i = i2 - this.e;
    }

    private void j() {
        if (this.f44013c.charAt(this.d) != '\t') {
            this.d++;
            this.e++;
            return;
        }
        this.d++;
        int i = this.e;
        this.e = i + Parsing.a(i);
    }

    private void k() {
        String subSequence;
        if (this.f) {
            int i = this.d;
            CharSequence charSequence = this.f44013c;
            CharSequence subSequence2 = charSequence.subSequence(i + 1, charSequence.length());
            int a2 = Parsing.a(this.e);
            StringBuilder sb = new StringBuilder(subSequence2.length() + a2);
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= a2) {
                    break;
                }
                sb.append(' ');
                i2 = i3 + 1;
            }
            sb.append(subSequence2);
            subSequence = sb.toString();
        } else {
            CharSequence charSequence2 = this.f44013c;
            subSequence = charSequence2.subSequence(this.d, charSequence2.length());
        }
        h().a(subSequence);
    }

    private void l() {
        InlineParser create = this.l.create(new InlineParserContextImpl(this.m, this.o));
        for (BlockParser blockParser : this.q) {
            blockParser.a(create);
        }
    }

    private void m() {
        List<BlockParser> list = this.p;
        list.remove(list.size() - 1);
    }

    private void n() {
        BlockParser h = h();
        m();
        this.q.remove(h);
        if (h instanceof ParagraphParser) {
            a((ParagraphParser) h);
        }
        h.c().l();
    }

    private Document o() {
        a(this.p);
        l();
        return this.n.c();
    }

    public Document a(String str) {
        int i = 0;
        while (true) {
            int a2 = Parsing.a(str, i);
            if (a2 == -1) {
                break;
            }
            a((CharSequence) str.substring(i, a2));
            int i2 = a2 + 1;
            i = i2;
            if (i2 < str.length()) {
                i = i2;
                if (str.charAt(a2) == '\r') {
                    i = i2;
                    if (str.charAt(i2) == '\n') {
                        i = a2 + 2;
                    }
                }
            }
        }
        if (str.length() > 0 && (i == 0 || i < str.length())) {
            a((CharSequence) str.substring(i));
        }
        return o();
    }

    @Override // org.commonmark.parser.block.ParserState
    public CharSequence b() {
        return this.f44013c;
    }

    @Override // org.commonmark.parser.block.ParserState
    public int c() {
        return this.d;
    }

    @Override // org.commonmark.parser.block.ParserState
    public int d() {
        return this.g;
    }

    @Override // org.commonmark.parser.block.ParserState
    public int e() {
        return this.e;
    }

    @Override // org.commonmark.parser.block.ParserState
    public int f() {
        return this.i;
    }

    @Override // org.commonmark.parser.block.ParserState
    public boolean g() {
        return this.j;
    }

    @Override // org.commonmark.parser.block.ParserState
    public BlockParser h() {
        List<BlockParser> list = this.p;
        return list.get(list.size() - 1);
    }
}
