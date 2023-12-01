package android.media;

import android.util.Log;
import com.huawei.hms.framework.common.ContainerUtils;
import com.j256.ormlite.stmt.query.SimpleComparison;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-9557208-dex2jar.jar:android/media/Tokenizer.class */
public class Tokenizer {
    private static final String TAG = "Tokenizer";
    private int mHandledLen;
    private String mLine;
    private OnTokenListener mListener;
    private TokenizerPhase mPhase;
    private TokenizerPhase mDataTokenizer = new DataTokenizer();
    private TokenizerPhase mTagTokenizer = new TagTokenizer();

    /* loaded from: source-9557208-dex2jar.jar:android/media/Tokenizer$DataTokenizer.class */
    class DataTokenizer implements TokenizerPhase {
        private StringBuilder mData;

        DataTokenizer() {
        }

        private boolean replaceEscape(String str, String str2, int i) {
            if (Tokenizer.this.mLine.startsWith(str, i)) {
                this.mData.append(Tokenizer.this.mLine.substring(Tokenizer.this.mHandledLen, i));
                this.mData.append(str2);
                Tokenizer.this.mHandledLen = str.length() + i;
                int unused = Tokenizer.this.mHandledLen;
                return true;
            }
            return false;
        }

        @Override // android.media.Tokenizer.TokenizerPhase
        public TokenizerPhase start() {
            this.mData = new StringBuilder();
            return this;
        }

        @Override // android.media.Tokenizer.TokenizerPhase
        public void tokenize() {
            int i;
            int length = Tokenizer.this.mLine.length();
            int i2 = Tokenizer.this.mHandledLen;
            while (true) {
                int i3 = i2;
                i = length;
                if (i3 >= Tokenizer.this.mLine.length()) {
                    break;
                }
                if (Tokenizer.this.mLine.charAt(i3) == '&') {
                    if (!replaceEscape("&amp;", ContainerUtils.FIELD_DELIMITER, i3) && !replaceEscape("&lt;", SimpleComparison.LESS_THAN_OPERATION, i3) && !replaceEscape("&gt;", SimpleComparison.GREATER_THAN_OPERATION, i3) && !replaceEscape("&lrm;", "\u200e", i3) && !replaceEscape("&rlm;", "\u200f", i3) && !replaceEscape("&nbsp;", " ", i3)) {
                    }
                } else if (Tokenizer.this.mLine.charAt(i3) == '<') {
                    Tokenizer.this.mPhase = Tokenizer.this.mTagTokenizer.start();
                    i = i3;
                    break;
                }
                i2 = i3 + 1;
            }
            this.mData.append(Tokenizer.this.mLine.substring(Tokenizer.this.mHandledLen, i));
            Tokenizer.this.mListener.onData(this.mData.toString());
            this.mData.delete(0, this.mData.length());
            Tokenizer.this.mHandledLen = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-9557208-dex2jar.jar:android/media/Tokenizer$OnTokenListener.class */
    public interface OnTokenListener {
        void onData(String str);

        void onEnd(String str);

        void onLineEnd();

        void onStart(String str, String[] strArr, String str2);

        void onTimeStamp(long j);
    }

    /* loaded from: source-9557208-dex2jar.jar:android/media/Tokenizer$TagTokenizer.class */
    class TagTokenizer implements TokenizerPhase {
        private String mAnnotation;
        private boolean mAtAnnotation;
        private String mName;

        TagTokenizer() {
        }

        private void yield_tag() {
            if (this.mName.startsWith("/")) {
                Tokenizer.this.mListener.onEnd(this.mName.substring(1));
            } else if (this.mName.length() > 0 && Character.isDigit(this.mName.charAt(0))) {
                try {
                    Tokenizer.this.mListener.onTimeStamp(WebVttParser.parseTimestampMs(this.mName));
                } catch (NumberFormatException e) {
                    Log.d(Tokenizer.TAG, "invalid timestamp tag: <" + this.mName + SimpleComparison.GREATER_THAN_OPERATION);
                }
            } else {
                this.mAnnotation = this.mAnnotation.replaceAll("\\s+", " ");
                if (this.mAnnotation.startsWith(" ")) {
                    this.mAnnotation = this.mAnnotation.substring(1);
                }
                if (this.mAnnotation.endsWith(" ")) {
                    this.mAnnotation = this.mAnnotation.substring(0, this.mAnnotation.length() - 1);
                }
                String[] strArr = null;
                int indexOf = this.mName.indexOf(46);
                if (indexOf >= 0) {
                    strArr = this.mName.substring(indexOf + 1).split("\\.");
                    this.mName = this.mName.substring(0, indexOf);
                }
                Tokenizer.this.mListener.onStart(this.mName, strArr, this.mAnnotation);
            }
        }

        @Override // android.media.Tokenizer.TokenizerPhase
        public TokenizerPhase start() {
            this.mAnnotation = "";
            this.mName = "";
            this.mAtAnnotation = false;
            return this;
        }

        @Override // android.media.Tokenizer.TokenizerPhase
        public void tokenize() {
            if (!this.mAtAnnotation) {
                Tokenizer.access$108(Tokenizer.this);
            }
            if (Tokenizer.this.mHandledLen < Tokenizer.this.mLine.length()) {
                String[] split = (this.mAtAnnotation || Tokenizer.this.mLine.charAt(Tokenizer.this.mHandledLen) == '/') ? Tokenizer.this.mLine.substring(Tokenizer.this.mHandledLen).split(SimpleComparison.GREATER_THAN_OPERATION) : Tokenizer.this.mLine.substring(Tokenizer.this.mHandledLen).split("[\t\f >]");
                String substring = Tokenizer.this.mLine.substring(Tokenizer.this.mHandledLen, Tokenizer.this.mHandledLen + split[0].length());
                Tokenizer.access$112(Tokenizer.this, split[0].length());
                if (this.mAtAnnotation) {
                    this.mAnnotation += " " + substring;
                } else {
                    this.mName = substring;
                }
            }
            this.mAtAnnotation = true;
            if (Tokenizer.this.mHandledLen >= Tokenizer.this.mLine.length() || Tokenizer.this.mLine.charAt(Tokenizer.this.mHandledLen) != '>') {
                return;
            }
            yield_tag();
            Tokenizer.this.mPhase = Tokenizer.this.mDataTokenizer.start();
            Tokenizer.access$108(Tokenizer.this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-9557208-dex2jar.jar:android/media/Tokenizer$TokenizerPhase.class */
    public interface TokenizerPhase {
        TokenizerPhase start();

        void tokenize();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Tokenizer(OnTokenListener onTokenListener) {
        reset();
        this.mListener = onTokenListener;
    }

    static /* synthetic */ int access$108(Tokenizer tokenizer) {
        int i = tokenizer.mHandledLen;
        tokenizer.mHandledLen = i + 1;
        return i;
    }

    static /* synthetic */ int access$112(Tokenizer tokenizer, int i) {
        int i2 = tokenizer.mHandledLen + i;
        tokenizer.mHandledLen = i2;
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void reset() {
        this.mPhase = this.mDataTokenizer.start();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void tokenize(String str) {
        this.mHandledLen = 0;
        this.mLine = str;
        while (this.mHandledLen < this.mLine.length()) {
            this.mPhase.tokenize();
        }
        if (this.mPhase instanceof TagTokenizer) {
            return;
        }
        this.mListener.onLineEnd();
    }
}
