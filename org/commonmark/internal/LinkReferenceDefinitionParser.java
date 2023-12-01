package org.commonmark.internal;

import java.util.ArrayList;
import java.util.List;
import org.commonmark.internal.util.Escaping;
import org.commonmark.internal.util.LinkScanner;
import org.commonmark.internal.util.Parsing;
import org.commonmark.node.LinkReferenceDefinition;

/* loaded from: source-3503164-dex2jar.jar:org/commonmark/internal/LinkReferenceDefinitionParser.class */
public class LinkReferenceDefinitionParser {
    private StringBuilder d;
    private String e;
    private String f;
    private char g;
    private StringBuilder h;
    private State a = State.START_DEFINITION;
    private final StringBuilder b = new StringBuilder();
    private final List<LinkReferenceDefinition> c = new ArrayList();
    private boolean i = false;

    /* renamed from: org.commonmark.internal.LinkReferenceDefinitionParser$1  reason: invalid class name */
    /* loaded from: source-3503164-dex2jar.jar:org/commonmark/internal/LinkReferenceDefinitionParser$1.class */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x004d -> B:37:0x0014). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0051 -> B:33:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0055 -> B:31:0x002a). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0059 -> B:27:0x0035). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x005d -> B:35:0x0040). Please submit an issue!!! */
        static {
            int[] iArr = new int[State.values().length];
            a = iArr;
            try {
                iArr[State.PARAGRAPH.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                a[State.START_DEFINITION.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                a[State.LABEL.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                a[State.DESTINATION.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                a[State.START_TITLE.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                a[State.TITLE.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-3503164-dex2jar.jar:org/commonmark/internal/LinkReferenceDefinitionParser$State.class */
    public enum State {
        START_DEFINITION,
        LABEL,
        DESTINATION,
        START_TITLE,
        TITLE,
        PARAGRAPH
    }

    private int a(CharSequence charSequence, int i) {
        int a = Parsing.a(charSequence, i, charSequence.length());
        if (a >= charSequence.length() || charSequence.charAt(a) != '[') {
            return -1;
        }
        this.a = State.LABEL;
        this.d = new StringBuilder();
        int i2 = a + 1;
        if (i2 >= charSequence.length()) {
            this.d.append('\n');
        }
        return i2;
    }

    private int b(CharSequence charSequence, int i) {
        int i2;
        int a = LinkScanner.a(charSequence, i);
        if (a == -1) {
            return -1;
        }
        this.d.append(charSequence, i, a);
        if (a >= charSequence.length()) {
            this.d.append('\n');
            return a;
        } else if (charSequence.charAt(a) != ']' || (i2 = a + 1) >= charSequence.length() || charSequence.charAt(i2) != ':' || this.d.length() > 999) {
            return -1;
        } else {
            String e = Escaping.e(this.d.toString());
            if (e.isEmpty()) {
                return -1;
            }
            this.e = e;
            this.a = State.DESTINATION;
            return Parsing.a(charSequence, i2 + 1, charSequence.length());
        }
    }

    private int c(CharSequence charSequence, int i) {
        int a = Parsing.a(charSequence, i, charSequence.length());
        int b = LinkScanner.b(charSequence, a);
        if (b == -1) {
            return -1;
        }
        this.f = charSequence.charAt(a) == '<' ? charSequence.subSequence(a + 1, b - 1).toString() : charSequence.subSequence(a, b).toString();
        int a2 = Parsing.a(charSequence, b, charSequence.length());
        if (a2 >= charSequence.length()) {
            this.i = true;
            this.b.setLength(0);
        } else if (a2 == b) {
            return -1;
        }
        this.a = State.START_TITLE;
        return a2;
    }

    private void c() {
        if (this.i) {
            String b = Escaping.b(this.f);
            StringBuilder sb = this.h;
            this.c.add(new LinkReferenceDefinition(this.e, b, sb != null ? Escaping.b(sb.toString()) : null));
            this.d = null;
            this.i = false;
            this.e = null;
            this.f = null;
            this.h = null;
        }
    }

    private int d(CharSequence charSequence, int i) {
        int a = Parsing.a(charSequence, i, charSequence.length());
        if (a >= charSequence.length()) {
            this.a = State.START_DEFINITION;
            return a;
        }
        this.g = (char) 0;
        char charAt = charSequence.charAt(a);
        if (charAt == '\"' || charAt == '\'') {
            this.g = charAt;
        } else if (charAt == '(') {
            this.g = ')';
        }
        if (this.g != 0) {
            this.a = State.TITLE;
            this.h = new StringBuilder();
            int i2 = a + 1;
            a = i2;
            if (i2 == charSequence.length()) {
                this.h.append('\n');
                return i2;
            }
        } else {
            c();
            this.a = State.START_DEFINITION;
        }
        return a;
    }

    private int e(CharSequence charSequence, int i) {
        int a = LinkScanner.a(charSequence, i, this.g);
        if (a == -1) {
            return -1;
        }
        this.h.append(charSequence.subSequence(i, a));
        if (a >= charSequence.length()) {
            this.h.append('\n');
            return a;
        }
        int a2 = Parsing.a(charSequence, a + 1, charSequence.length());
        if (a2 != charSequence.length()) {
            return -1;
        }
        this.i = true;
        c();
        this.b.setLength(0);
        this.a = State.START_DEFINITION;
        return a2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CharSequence a() {
        return this.b;
    }

    public void a(CharSequence charSequence) {
        int a;
        if (this.b.length() != 0) {
            this.b.append('\n');
        }
        this.b.append(charSequence);
        int i = 0;
        while (i < charSequence.length()) {
            switch (AnonymousClass1.a[this.a.ordinal()]) {
                case 1:
                    return;
                case 2:
                    a = a(charSequence, i);
                    break;
                case 3:
                    a = b(charSequence, i);
                    break;
                case 4:
                    a = c(charSequence, i);
                    break;
                case 5:
                    a = d(charSequence, i);
                    break;
                case 6:
                    a = e(charSequence, i);
                    break;
                default:
                    a = i;
                    break;
            }
            i = a;
            if (a == -1) {
                this.a = State.PARAGRAPH;
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<LinkReferenceDefinition> b() {
        c();
        return this.c;
    }
}
