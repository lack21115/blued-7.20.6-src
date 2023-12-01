package org.commonmark.renderer.text;

import java.io.IOException;

/* loaded from: source-3503164-dex2jar.jar:org/commonmark/renderer/text/TextContentWriter.class */
public class TextContentWriter {
    private final Appendable a;
    private char b;

    private void b(char c) {
        try {
            this.a.append(c);
            this.b = c;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void c(String str) {
        try {
            this.a.append(str);
            int length = str.length();
            if (length != 0) {
                this.b = str.charAt(length - 1);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void a() {
        char c = this.b;
        if (c == 0 || c == ' ') {
            return;
        }
        b(' ');
    }

    public void a(char c) {
        b(c);
    }

    public void a(String str) {
        c(str.replaceAll("[\\r\\n\\s]+", " "));
    }

    public void b() {
        char c = this.b;
        if (c == 0 || c == ':') {
            return;
        }
        b(':');
    }

    public void b(String str) {
        c(str);
    }

    public void c() {
        char c = this.b;
        if (c == 0 || c == '\n') {
            return;
        }
        b('\n');
    }
}
