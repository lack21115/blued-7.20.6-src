package org.commonmark.renderer.text;

import java.io.IOException;

/* loaded from: source-3503164-dex2jar.jar:org/commonmark/renderer/text/TextContentWriter.class */
public class TextContentWriter {

    /* renamed from: a  reason: collision with root package name */
    private final Appendable f44089a;
    private char b;

    private void b(char c2) {
        try {
            this.f44089a.append(c2);
            this.b = c2;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void c(String str) {
        try {
            this.f44089a.append(str);
            int length = str.length();
            if (length != 0) {
                this.b = str.charAt(length - 1);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void a() {
        char c2 = this.b;
        if (c2 == 0 || c2 == ' ') {
            return;
        }
        b(' ');
    }

    public void a(char c2) {
        b(c2);
    }

    public void a(String str) {
        c(str.replaceAll("[\\r\\n\\s]+", " "));
    }

    public void b() {
        char c2 = this.b;
        if (c2 == 0 || c2 == ':') {
            return;
        }
        b(':');
    }

    public void b(String str) {
        c(str);
    }

    public void c() {
        char c2 = this.b;
        if (c2 == 0 || c2 == '\n') {
            return;
        }
        b('\n');
    }
}
