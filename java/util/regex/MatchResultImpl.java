package java.util.regex;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-2895416-dex2jar.jar:java/util/regex/MatchResultImpl.class */
public class MatchResultImpl implements MatchResult {
    private int[] offsets;
    private String text;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MatchResultImpl(String str, int[] iArr) {
        this.text = str;
        this.offsets = (int[]) iArr.clone();
    }

    @Override // java.util.regex.MatchResult
    public int end() {
        return end(0);
    }

    @Override // java.util.regex.MatchResult
    public int end(int i) {
        return this.offsets[(i * 2) + 1];
    }

    @Override // java.util.regex.MatchResult
    public String group() {
        return this.text.substring(start(), end());
    }

    @Override // java.util.regex.MatchResult
    public String group(int i) {
        int i2 = this.offsets[i * 2];
        int i3 = this.offsets[(i * 2) + 1];
        if (i2 == -1 || i3 == -1) {
            return null;
        }
        return this.text.substring(i2, i3);
    }

    @Override // java.util.regex.MatchResult
    public int groupCount() {
        return (this.offsets.length / 2) - 1;
    }

    @Override // java.util.regex.MatchResult
    public int start() {
        return start(0);
    }

    @Override // java.util.regex.MatchResult
    public int start(int i) {
        return this.offsets[i * 2];
    }
}
