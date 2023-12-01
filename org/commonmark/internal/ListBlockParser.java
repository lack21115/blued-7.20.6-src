package org.commonmark.internal;

import org.commonmark.internal.util.Parsing;
import org.commonmark.node.Block;
import org.commonmark.node.BulletList;
import org.commonmark.node.ListBlock;
import org.commonmark.node.ListItem;
import org.commonmark.node.OrderedList;
import org.commonmark.parser.block.AbstractBlockParser;
import org.commonmark.parser.block.AbstractBlockParserFactory;
import org.commonmark.parser.block.BlockContinue;
import org.commonmark.parser.block.BlockParser;
import org.commonmark.parser.block.BlockStart;
import org.commonmark.parser.block.MatchedBlockParser;
import org.commonmark.parser.block.ParserState;

/* loaded from: source-3503164-dex2jar.jar:org/commonmark/internal/ListBlockParser.class */
public class ListBlockParser extends AbstractBlockParser {

    /* renamed from: a  reason: collision with root package name */
    private final ListBlock f44031a;
    private boolean b;

    /* renamed from: c  reason: collision with root package name */
    private int f44032c;

    /* loaded from: source-3503164-dex2jar.jar:org/commonmark/internal/ListBlockParser$Factory.class */
    public static class Factory extends AbstractBlockParserFactory {
        @Override // org.commonmark.parser.block.BlockParserFactory
        public BlockStart a(ParserState parserState, MatchedBlockParser matchedBlockParser) {
            BlockParser a2 = matchedBlockParser.a();
            if (parserState.f() >= Parsing.f44049a) {
                return BlockStart.f();
            }
            ListData b = ListBlockParser.b(parserState.b(), parserState.d(), parserState.e() + parserState.f(), matchedBlockParser.b() != null);
            if (b == null) {
                return BlockStart.f();
            }
            int i = b.b;
            ListItemParser listItemParser = new ListItemParser(i - parserState.e());
            if ((a2 instanceof ListBlockParser) && ListBlockParser.b((ListBlock) a2.c(), b.f44033a)) {
                return BlockStart.a(listItemParser).b(i);
            }
            ListBlockParser listBlockParser = new ListBlockParser(b.f44033a);
            b.f44033a.a(true);
            return BlockStart.a(listBlockParser, listItemParser).b(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-3503164-dex2jar.jar:org/commonmark/internal/ListBlockParser$ListData.class */
    public static class ListData {

        /* renamed from: a  reason: collision with root package name */
        final ListBlock f44033a;
        final int b;

        ListData(ListBlock listBlock, int i) {
            this.f44033a = listBlock;
            this.b = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-3503164-dex2jar.jar:org/commonmark/internal/ListBlockParser$ListMarkerData.class */
    public static class ListMarkerData {

        /* renamed from: a  reason: collision with root package name */
        final ListBlock f44034a;
        final int b;

        ListMarkerData(ListBlock listBlock, int i) {
            this.f44034a = listBlock;
            this.b = i;
        }
    }

    public ListBlockParser(ListBlock listBlock) {
        this.f44031a = listBlock;
    }

    private static ListMarkerData a(CharSequence charSequence, int i) {
        char charAt = charSequence.charAt(i);
        if (charAt == '*' || charAt == '+' || charAt == '-') {
            int i2 = i + 1;
            if (c(charSequence, i2)) {
                BulletList bulletList = new BulletList();
                bulletList.a(charAt);
                return new ListMarkerData(bulletList, i2);
            }
            return null;
        }
        return b(charSequence, i);
    }

    private static boolean a(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x009d, code lost:
        if ((r6 - r0) > org.commonmark.internal.util.Parsing.f44049a) goto L35;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static org.commonmark.internal.ListBlockParser.ListData b(java.lang.CharSequence r5, int r6, int r7, boolean r8) {
        /*
            r0 = r5
            r1 = r6
            org.commonmark.internal.ListBlockParser$ListMarkerData r0 = a(r0, r1)
            r13 = r0
            r0 = r13
            if (r0 != 0) goto Le
            r0 = 0
            return r0
        Le:
            r0 = r13
            org.commonmark.node.ListBlock r0 = r0.f44034a
            r14 = r0
            r0 = r13
            int r0 = r0.b
            r9 = r0
            r0 = r7
            r1 = r9
            r2 = r6
            int r1 = r1 - r2
            int r0 = r0 + r1
            r10 = r0
            r0 = 0
            r11 = r0
            r0 = r5
            int r0 = r0.length()
            r12 = r0
            r0 = r10
            r6 = r0
            r0 = r9
            r7 = r0
        L35:
            r0 = r11
            r9 = r0
            r0 = r7
            r1 = r12
            if (r0 >= r1) goto L6e
            r0 = r5
            r1 = r7
            char r0 = r0.charAt(r1)
            r9 = r0
            r0 = r9
            r1 = 9
            if (r0 != r1) goto L59
            r0 = r6
            r1 = r6
            int r1 = org.commonmark.internal.util.Parsing.a(r1)
            int r0 = r0 + r1
            r6 = r0
            goto L64
        L59:
            r0 = r9
            r1 = 32
            if (r0 != r1) goto L6b
            r0 = r6
            r1 = 1
            int r0 = r0 + r1
            r6 = r0
        L64:
            r0 = r7
            r1 = 1
            int r0 = r0 + r1
            r7 = r0
            goto L35
        L6b:
            r0 = 1
            r9 = r0
        L6e:
            r0 = r8
            if (r0 == 0) goto L8f
            r0 = r14
            boolean r0 = r0 instanceof org.commonmark.node.OrderedList
            if (r0 == 0) goto L88
            r0 = r14
            org.commonmark.node.OrderedList r0 = (org.commonmark.node.OrderedList) r0
            int r0 = r0.c()
            r1 = 1
            if (r0 == r1) goto L88
            r0 = 0
            return r0
        L88:
            r0 = r9
            if (r0 != 0) goto L8f
            r0 = 0
            return r0
        L8f:
            r0 = r9
            if (r0 == 0) goto La0
            r0 = r6
            r7 = r0
            r0 = r6
            r1 = r10
            int r0 = r0 - r1
            int r1 = org.commonmark.internal.util.Parsing.f44049a
            if (r0 <= r1) goto La5
        La0:
            r0 = r10
            r1 = 1
            int r0 = r0 + r1
            r7 = r0
        La5:
            org.commonmark.internal.ListBlockParser$ListData r0 = new org.commonmark.internal.ListBlockParser$ListData
            r1 = r0
            r2 = r14
            r3 = r7
            r1.<init>(r2, r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.commonmark.internal.ListBlockParser.b(java.lang.CharSequence, int, int, boolean):org.commonmark.internal.ListBlockParser$ListData");
    }

    private static ListMarkerData b(CharSequence charSequence, int i) {
        int i2;
        char charAt;
        int length = charSequence.length();
        int i3 = 0;
        int i4 = i;
        while (true) {
            i2 = i4;
            if (i2 >= length) {
                return null;
            }
            charAt = charSequence.charAt(i2);
            if (charAt != ')' && charAt != '.') {
                switch (charAt) {
                    case '0':
                    case '1':
                    case '2':
                    case '3':
                    case '4':
                    case '5':
                    case '6':
                    case '7':
                    case '8':
                    case '9':
                        i3++;
                        if (i3 > 9) {
                            return null;
                        }
                        i4 = i2 + 1;
                    default:
                        return null;
                }
            }
        }
        if (i3 >= 1) {
            int i5 = i2 + 1;
            if (c(charSequence, i5)) {
                String charSequence2 = charSequence.subSequence(i, i2).toString();
                OrderedList orderedList = new OrderedList();
                orderedList.a(Integer.parseInt(charSequence2));
                orderedList.a(charAt);
                return new ListMarkerData(orderedList, i5);
            }
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(ListBlock listBlock, ListBlock listBlock2) {
        if ((listBlock instanceof BulletList) && (listBlock2 instanceof BulletList)) {
            return a(Character.valueOf(((BulletList) listBlock).c()), Character.valueOf(((BulletList) listBlock2).c()));
        }
        if ((listBlock instanceof OrderedList) && (listBlock2 instanceof OrderedList)) {
            return a(Character.valueOf(((OrderedList) listBlock).f()), Character.valueOf(((OrderedList) listBlock2).f()));
        }
        return false;
    }

    private static boolean c(CharSequence charSequence, int i) {
        char charAt;
        return i >= charSequence.length() || (charAt = charSequence.charAt(i)) == '\t' || charAt == ' ';
    }

    @Override // org.commonmark.parser.block.BlockParser
    public BlockContinue a(ParserState parserState) {
        if (parserState.g()) {
            this.b = true;
            this.f44032c = 0;
        } else if (this.b) {
            this.f44032c++;
        }
        return BlockContinue.a(parserState.c());
    }

    @Override // org.commonmark.parser.block.AbstractBlockParser, org.commonmark.parser.block.BlockParser
    public boolean a() {
        return true;
    }

    @Override // org.commonmark.parser.block.AbstractBlockParser, org.commonmark.parser.block.BlockParser
    public boolean a(Block block) {
        if (block instanceof ListItem) {
            if (this.b && this.f44032c == 1) {
                this.f44031a.a(false);
                this.b = false;
                return true;
            }
            return true;
        }
        return false;
    }

    @Override // org.commonmark.parser.block.BlockParser
    public Block c() {
        return this.f44031a;
    }
}
