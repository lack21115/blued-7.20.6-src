package android.text.style;

/* loaded from: source-9557208-dex2jar.jar:android/text/style/TabStopSpan.class */
public interface TabStopSpan extends ParagraphStyle {

    /* loaded from: source-9557208-dex2jar.jar:android/text/style/TabStopSpan$Standard.class */
    public static class Standard implements TabStopSpan {
        private int mTab;

        public Standard(int i) {
            this.mTab = i;
        }

        @Override // android.text.style.TabStopSpan
        public int getTabStop() {
            return this.mTab;
        }
    }

    int getTabStop();
}
