package java.text;

import libcore.icu.NativeBreakIterator;

/* loaded from: source-2895416-dex2jar.jar:java/text/RuleBasedBreakIterator.class */
class RuleBasedBreakIterator extends BreakIterator {
    /* JADX INFO: Access modifiers changed from: package-private */
    public RuleBasedBreakIterator(NativeBreakIterator nativeBreakIterator) {
        super(nativeBreakIterator);
    }

    private void checkOffset(int i) {
        if (!this.wrapped.hasText()) {
            throw new IllegalArgumentException("BreakIterator has no text");
        }
        CharacterIterator text = this.wrapped.getText();
        if (i < text.getBeginIndex() || i > text.getEndIndex()) {
            throw new IllegalArgumentException("Valid range is [" + text.getBeginIndex() + " " + text.getEndIndex() + "]");
        }
    }

    @Override // java.text.BreakIterator
    public Object clone() {
        RuleBasedBreakIterator ruleBasedBreakIterator = (RuleBasedBreakIterator) super.clone();
        ruleBasedBreakIterator.wrapped = (NativeBreakIterator) this.wrapped.clone();
        return ruleBasedBreakIterator;
    }

    @Override // java.text.BreakIterator
    public int current() {
        return this.wrapped.current();
    }

    public boolean equals(Object obj) {
        if (obj instanceof RuleBasedBreakIterator) {
            return this.wrapped.equals(((RuleBasedBreakIterator) obj).wrapped);
        }
        return false;
    }

    @Override // java.text.BreakIterator
    public int first() {
        return this.wrapped.first();
    }

    @Override // java.text.BreakIterator
    public int following(int i) {
        checkOffset(i);
        return this.wrapped.following(i);
    }

    @Override // java.text.BreakIterator
    public CharacterIterator getText() {
        return this.wrapped.getText();
    }

    public int hashCode() {
        return this.wrapped.hashCode();
    }

    @Override // java.text.BreakIterator
    public boolean isBoundary(int i) {
        checkOffset(i);
        return this.wrapped.isBoundary(i);
    }

    @Override // java.text.BreakIterator
    public int last() {
        return this.wrapped.last();
    }

    @Override // java.text.BreakIterator
    public int next() {
        return this.wrapped.next();
    }

    @Override // java.text.BreakIterator
    public int next(int i) {
        return this.wrapped.next(i);
    }

    @Override // java.text.BreakIterator
    public int preceding(int i) {
        checkOffset(i);
        return this.wrapped.preceding(i);
    }

    @Override // java.text.BreakIterator
    public int previous() {
        return this.wrapped.previous();
    }

    @Override // java.text.BreakIterator
    public void setText(CharacterIterator characterIterator) {
        if (characterIterator == null) {
            throw new NullPointerException("newText == null");
        }
        characterIterator.current();
        this.wrapped.setText(characterIterator);
    }

    public String toString() {
        return this.wrapped.toString();
    }
}
