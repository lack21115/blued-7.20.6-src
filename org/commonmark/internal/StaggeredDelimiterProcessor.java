package org.commonmark.internal;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import org.commonmark.node.Text;
import org.commonmark.parser.delimiter.DelimiterProcessor;
import org.commonmark.parser.delimiter.DelimiterRun;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-3503164-dex2jar.jar:org/commonmark/internal/StaggeredDelimiterProcessor.class */
public class StaggeredDelimiterProcessor implements DelimiterProcessor {
    private final char a;
    private int b = 0;
    private LinkedList<DelimiterProcessor> c = new LinkedList<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    public StaggeredDelimiterProcessor(char c) {
        this.a = c;
    }

    private DelimiterProcessor a(int i) {
        Iterator<DelimiterProcessor> it = this.c.iterator();
        while (it.hasNext()) {
            DelimiterProcessor next = it.next();
            if (next.getMinLength() <= i) {
                return next;
            }
        }
        return this.c.getFirst();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(DelimiterProcessor delimiterProcessor) {
        boolean z;
        int minLength;
        int minLength2 = delimiterProcessor.getMinLength();
        ListIterator<DelimiterProcessor> listIterator = this.c.listIterator();
        do {
            if (listIterator.hasNext()) {
                minLength = listIterator.next().getMinLength();
                if (minLength2 > minLength) {
                    listIterator.previous();
                    listIterator.add(delimiterProcessor);
                    z = true;
                }
            } else {
                z = false;
            }
            if (z) {
                return;
            }
            this.c.add(delimiterProcessor);
            this.b = minLength2;
            return;
        } while (minLength2 != minLength);
        throw new IllegalArgumentException("Cannot add two delimiter processors for char '" + this.a + "' and minimum length " + minLength2);
    }

    @Override // org.commonmark.parser.delimiter.DelimiterProcessor
    public char getClosingCharacter() {
        return this.a;
    }

    @Override // org.commonmark.parser.delimiter.DelimiterProcessor
    public int getDelimiterUse(DelimiterRun delimiterRun, DelimiterRun delimiterRun2) {
        return a(delimiterRun.c()).getDelimiterUse(delimiterRun, delimiterRun2);
    }

    @Override // org.commonmark.parser.delimiter.DelimiterProcessor
    public int getMinLength() {
        return this.b;
    }

    @Override // org.commonmark.parser.delimiter.DelimiterProcessor
    public char getOpeningCharacter() {
        return this.a;
    }

    @Override // org.commonmark.parser.delimiter.DelimiterProcessor
    public void process(Text text, Text text2, int i) {
        a(i).process(text, text2, i);
    }
}
