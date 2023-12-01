package org.commonmark.renderer.html;

import com.j256.ormlite.stmt.query.SimpleComparison;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;
import org.commonmark.internal.util.Escaping;

/* loaded from: source-3503164-dex2jar.jar:org/commonmark/renderer/html/HtmlWriter.class */
public class HtmlWriter {

    /* renamed from: a  reason: collision with root package name */
    private static final Map<String, String> f44082a = Collections.emptyMap();
    private final Appendable b;

    /* renamed from: c  reason: collision with root package name */
    private char f44083c;

    public void a() {
        char c2 = this.f44083c;
        if (c2 == 0 || c2 == '\n') {
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
        d(SimpleComparison.LESS_THAN_OPERATION);
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
        d(SimpleComparison.GREATER_THAN_OPERATION);
    }

    public void b(String str) {
        d(Escaping.a(str));
    }

    public void c(String str) {
        a(str, f44082a);
    }

    protected void d(String str) {
        try {
            this.b.append(str);
            int length = str.length();
            if (length != 0) {
                this.f44083c = str.charAt(length - 1);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
