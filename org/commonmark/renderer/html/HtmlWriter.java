package org.commonmark.renderer.html;

import java.io.IOException;
import java.util.Collections;
import java.util.Map;
import org.commonmark.internal.util.Escaping;

/* loaded from: source-3503164-dex2jar.jar:org/commonmark/renderer/html/HtmlWriter.class */
public class HtmlWriter {
    private static final Map<String, String> a = Collections.emptyMap();
    private final Appendable b;
    private char c;

    public void a() {
        char c = this.c;
        if (c == 0 || c == '\n') {
            return;
        }
        d("\n");
    }

    public void a(String str) {
        d(str);
    }

    public void a(String str, Map<String, String> map) {
        a(str, map, false);
    }

    public void a(String str, Map<String, String> map, boolean z) {
        d("<");
        d(str);
        if (map != null && !map.isEmpty()) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                d(" ");
                d(Escaping.a(entry.getKey()));
                d("=\"");
                d(Escaping.a(entry.getValue()));
                d("\"");
            }
        }
        if (z) {
            d(" /");
        }
        d(">");
    }

    public void b(String str) {
        d(Escaping.a(str));
    }

    public void c(String str) {
        a(str, a);
    }

    protected void d(String str) {
        try {
            this.b.append(str);
            int length = str.length();
            if (length != 0) {
                this.c = str.charAt(length - 1);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
