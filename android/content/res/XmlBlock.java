package android.content.res;

import android.util.TypedValue;
import com.android.internal.util.XmlUtils;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-9557208-dex2jar.jar:android/content/res/XmlBlock.class */
public final class XmlBlock {
    private static final boolean DEBUG = false;
    private final AssetManager mAssets;
    private final long mNative;
    private boolean mOpen;
    private int mOpenCount;
    final StringBlock mStrings;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-9557208-dex2jar.jar:android/content/res/XmlBlock$Parser.class */
    public final class Parser implements XmlResourceParser {
        private final XmlBlock mBlock;
        long mParseState;
        private boolean mStarted = false;
        private boolean mDecNextDepth = false;
        private int mDepth = 0;
        private int mEventType = 0;

        Parser(long j, XmlBlock xmlBlock) {
            this.mParseState = j;
            this.mBlock = xmlBlock;
            XmlBlock.access$008(xmlBlock);
        }

        @Override // android.content.res.XmlResourceParser, java.lang.AutoCloseable
        public void close() {
            synchronized (this.mBlock) {
                if (this.mParseState != 0) {
                    XmlBlock.nativeDestroyParseState(this.mParseState);
                    this.mParseState = 0L;
                    this.mBlock.decOpenCountLocked();
                }
            }
        }

        @Override // org.xmlpull.v1.XmlPullParser
        public void defineEntityReplacementText(String str, String str2) throws XmlPullParserException {
            throw new XmlPullParserException("defineEntityReplacementText() not supported");
        }

        protected void finalize() throws Throwable {
            close();
        }

        @Override // android.util.AttributeSet
        public boolean getAttributeBooleanValue(int i, boolean z) {
            int nativeGetAttributeDataType = XmlBlock.nativeGetAttributeDataType(this.mParseState, i);
            return (nativeGetAttributeDataType < 16 || nativeGetAttributeDataType > 31) ? z : XmlBlock.nativeGetAttributeData(this.mParseState, i) != 0;
        }

        @Override // android.util.AttributeSet
        public boolean getAttributeBooleanValue(String str, String str2, boolean z) {
            int nativeGetAttributeIndex = XmlBlock.nativeGetAttributeIndex(this.mParseState, str, str2);
            boolean z2 = z;
            if (nativeGetAttributeIndex >= 0) {
                z2 = getAttributeBooleanValue(nativeGetAttributeIndex, z);
            }
            return z2;
        }

        @Override // org.xmlpull.v1.XmlPullParser, android.util.AttributeSet
        public int getAttributeCount() {
            if (this.mEventType == 2) {
                return XmlBlock.nativeGetAttributeCount(this.mParseState);
            }
            return -1;
        }

        @Override // android.util.AttributeSet
        public float getAttributeFloatValue(int i, float f) {
            if (XmlBlock.nativeGetAttributeDataType(this.mParseState, i) == 4) {
                return Float.intBitsToFloat(XmlBlock.nativeGetAttributeData(this.mParseState, i));
            }
            throw new RuntimeException("not a float!");
        }

        @Override // android.util.AttributeSet
        public float getAttributeFloatValue(String str, String str2, float f) {
            int nativeGetAttributeIndex = XmlBlock.nativeGetAttributeIndex(this.mParseState, str, str2);
            float f2 = f;
            if (nativeGetAttributeIndex >= 0) {
                f2 = getAttributeFloatValue(nativeGetAttributeIndex, f);
            }
            return f2;
        }

        @Override // android.util.AttributeSet
        public int getAttributeIntValue(int i, int i2) {
            int nativeGetAttributeDataType = XmlBlock.nativeGetAttributeDataType(this.mParseState, i);
            int i3 = i2;
            if (nativeGetAttributeDataType >= 16) {
                i3 = i2;
                if (nativeGetAttributeDataType <= 31) {
                    i3 = XmlBlock.nativeGetAttributeData(this.mParseState, i);
                }
            }
            return i3;
        }

        @Override // android.util.AttributeSet
        public int getAttributeIntValue(String str, String str2, int i) {
            int nativeGetAttributeIndex = XmlBlock.nativeGetAttributeIndex(this.mParseState, str, str2);
            int i2 = i;
            if (nativeGetAttributeIndex >= 0) {
                i2 = getAttributeIntValue(nativeGetAttributeIndex, i);
            }
            return i2;
        }

        @Override // android.util.AttributeSet
        public int getAttributeListValue(int i, String[] strArr, int i2) {
            int nativeGetAttributeDataType = XmlBlock.nativeGetAttributeDataType(this.mParseState, i);
            int nativeGetAttributeData = XmlBlock.nativeGetAttributeData(this.mParseState, i);
            int i3 = nativeGetAttributeData;
            if (nativeGetAttributeDataType == 3) {
                i3 = XmlUtils.convertValueToList(XmlBlock.this.mStrings.get(nativeGetAttributeData), strArr, i2);
            }
            return i3;
        }

        @Override // android.util.AttributeSet
        public int getAttributeListValue(String str, String str2, String[] strArr, int i) {
            int nativeGetAttributeIndex = XmlBlock.nativeGetAttributeIndex(this.mParseState, str, str2);
            int i2 = i;
            if (nativeGetAttributeIndex >= 0) {
                i2 = getAttributeListValue(nativeGetAttributeIndex, strArr, i);
            }
            return i2;
        }

        @Override // org.xmlpull.v1.XmlPullParser, android.util.AttributeSet
        public String getAttributeName(int i) {
            int nativeGetAttributeName = XmlBlock.nativeGetAttributeName(this.mParseState, i);
            if (nativeGetAttributeName >= 0) {
                return XmlBlock.this.mStrings.get(nativeGetAttributeName).toString();
            }
            throw new IndexOutOfBoundsException(String.valueOf(i));
        }

        @Override // android.util.AttributeSet
        public int getAttributeNameResource(int i) {
            return XmlBlock.nativeGetAttributeResource(this.mParseState, i);
        }

        @Override // org.xmlpull.v1.XmlPullParser
        public String getAttributeNamespace(int i) {
            int nativeGetAttributeNamespace = XmlBlock.nativeGetAttributeNamespace(this.mParseState, i);
            if (nativeGetAttributeNamespace >= 0) {
                return XmlBlock.this.mStrings.get(nativeGetAttributeNamespace).toString();
            }
            if (nativeGetAttributeNamespace == -1) {
                return "";
            }
            throw new IndexOutOfBoundsException(String.valueOf(i));
        }

        @Override // org.xmlpull.v1.XmlPullParser
        public String getAttributePrefix(int i) {
            throw new RuntimeException("getAttributePrefix not supported");
        }

        @Override // android.util.AttributeSet
        public int getAttributeResourceValue(int i, int i2) {
            if (XmlBlock.nativeGetAttributeDataType(this.mParseState, i) == 1) {
                i2 = XmlBlock.nativeGetAttributeData(this.mParseState, i);
            }
            return i2;
        }

        @Override // android.util.AttributeSet
        public int getAttributeResourceValue(String str, String str2, int i) {
            int nativeGetAttributeIndex = XmlBlock.nativeGetAttributeIndex(this.mParseState, str, str2);
            int i2 = i;
            if (nativeGetAttributeIndex >= 0) {
                i2 = getAttributeResourceValue(nativeGetAttributeIndex, i);
            }
            return i2;
        }

        @Override // org.xmlpull.v1.XmlPullParser
        public String getAttributeType(int i) {
            return "CDATA";
        }

        @Override // android.util.AttributeSet
        public int getAttributeUnsignedIntValue(int i, int i2) {
            int nativeGetAttributeDataType = XmlBlock.nativeGetAttributeDataType(this.mParseState, i);
            int i3 = i2;
            if (nativeGetAttributeDataType >= 16) {
                i3 = i2;
                if (nativeGetAttributeDataType <= 31) {
                    i3 = XmlBlock.nativeGetAttributeData(this.mParseState, i);
                }
            }
            return i3;
        }

        @Override // android.util.AttributeSet
        public int getAttributeUnsignedIntValue(String str, String str2, int i) {
            int nativeGetAttributeIndex = XmlBlock.nativeGetAttributeIndex(this.mParseState, str, str2);
            int i2 = i;
            if (nativeGetAttributeIndex >= 0) {
                i2 = getAttributeUnsignedIntValue(nativeGetAttributeIndex, i);
            }
            return i2;
        }

        @Override // org.xmlpull.v1.XmlPullParser, android.util.AttributeSet
        public String getAttributeValue(int i) {
            int nativeGetAttributeStringValue = XmlBlock.nativeGetAttributeStringValue(this.mParseState, i);
            if (nativeGetAttributeStringValue >= 0) {
                return XmlBlock.this.mStrings.get(nativeGetAttributeStringValue).toString();
            }
            int nativeGetAttributeDataType = XmlBlock.nativeGetAttributeDataType(this.mParseState, i);
            if (nativeGetAttributeDataType == 0) {
                throw new IndexOutOfBoundsException(String.valueOf(i));
            }
            return TypedValue.coerceToString(nativeGetAttributeDataType, XmlBlock.nativeGetAttributeData(this.mParseState, i));
        }

        @Override // org.xmlpull.v1.XmlPullParser, android.util.AttributeSet
        public String getAttributeValue(String str, String str2) {
            int nativeGetAttributeIndex = XmlBlock.nativeGetAttributeIndex(this.mParseState, str, str2);
            if (nativeGetAttributeIndex >= 0) {
                return getAttributeValue(nativeGetAttributeIndex);
            }
            return null;
        }

        @Override // android.util.AttributeSet
        public String getClassAttribute() {
            int nativeGetClassAttribute = XmlBlock.nativeGetClassAttribute(this.mParseState);
            if (nativeGetClassAttribute >= 0) {
                return XmlBlock.this.mStrings.get(nativeGetClassAttribute).toString();
            }
            return null;
        }

        @Override // org.xmlpull.v1.XmlPullParser
        public int getColumnNumber() {
            return -1;
        }

        @Override // org.xmlpull.v1.XmlPullParser
        public int getDepth() {
            return this.mDepth;
        }

        @Override // org.xmlpull.v1.XmlPullParser
        public int getEventType() throws XmlPullParserException {
            return this.mEventType;
        }

        @Override // org.xmlpull.v1.XmlPullParser
        public boolean getFeature(String str) {
            return "http://xmlpull.org/v1/doc/features.html#process-namespaces".equals(str) || "http://xmlpull.org/v1/doc/features.html#report-namespace-prefixes".equals(str);
        }

        @Override // android.util.AttributeSet
        public String getIdAttribute() {
            int nativeGetIdAttribute = XmlBlock.nativeGetIdAttribute(this.mParseState);
            if (nativeGetIdAttribute >= 0) {
                return XmlBlock.this.mStrings.get(nativeGetIdAttribute).toString();
            }
            return null;
        }

        @Override // android.util.AttributeSet
        public int getIdAttributeResourceValue(int i) {
            return getAttributeResourceValue(null, "id", i);
        }

        @Override // org.xmlpull.v1.XmlPullParser
        public String getInputEncoding() {
            return null;
        }

        @Override // org.xmlpull.v1.XmlPullParser
        public int getLineNumber() {
            return XmlBlock.nativeGetLineNumber(this.mParseState);
        }

        @Override // org.xmlpull.v1.XmlPullParser
        public String getName() {
            int nativeGetName = XmlBlock.nativeGetName(this.mParseState);
            if (nativeGetName >= 0) {
                return XmlBlock.this.mStrings.get(nativeGetName).toString();
            }
            return null;
        }

        @Override // org.xmlpull.v1.XmlPullParser
        public String getNamespace() {
            int nativeGetNamespace = XmlBlock.nativeGetNamespace(this.mParseState);
            return nativeGetNamespace >= 0 ? XmlBlock.this.mStrings.get(nativeGetNamespace).toString() : "";
        }

        @Override // org.xmlpull.v1.XmlPullParser
        public String getNamespace(String str) {
            throw new RuntimeException("getNamespace() not supported");
        }

        @Override // org.xmlpull.v1.XmlPullParser
        public int getNamespaceCount(int i) throws XmlPullParserException {
            throw new XmlPullParserException("getNamespaceCount() not supported");
        }

        @Override // org.xmlpull.v1.XmlPullParser
        public String getNamespacePrefix(int i) throws XmlPullParserException {
            throw new XmlPullParserException("getNamespacePrefix() not supported");
        }

        @Override // org.xmlpull.v1.XmlPullParser
        public String getNamespaceUri(int i) throws XmlPullParserException {
            throw new XmlPullParserException("getNamespaceUri() not supported");
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final CharSequence getPooledString(int i) {
            return XmlBlock.this.mStrings.get(i);
        }

        @Override // org.xmlpull.v1.XmlPullParser, android.util.AttributeSet
        public String getPositionDescription() {
            return "Binary XML file line #" + getLineNumber();
        }

        @Override // org.xmlpull.v1.XmlPullParser
        public String getPrefix() {
            throw new RuntimeException("getPrefix not supported");
        }

        @Override // org.xmlpull.v1.XmlPullParser
        public Object getProperty(String str) {
            return null;
        }

        @Override // android.util.AttributeSet
        public int getStyleAttribute() {
            return XmlBlock.nativeGetStyleAttribute(this.mParseState);
        }

        @Override // org.xmlpull.v1.XmlPullParser
        public String getText() {
            int nativeGetText = XmlBlock.nativeGetText(this.mParseState);
            if (nativeGetText >= 0) {
                return XmlBlock.this.mStrings.get(nativeGetText).toString();
            }
            return null;
        }

        @Override // org.xmlpull.v1.XmlPullParser
        public char[] getTextCharacters(int[] iArr) {
            String text = getText();
            char[] cArr = null;
            if (text != null) {
                iArr[0] = 0;
                iArr[1] = text.length();
                cArr = new char[text.length()];
                text.getChars(0, text.length(), cArr, 0);
            }
            return cArr;
        }

        @Override // org.xmlpull.v1.XmlPullParser
        public boolean isAttributeDefault(int i) {
            return false;
        }

        @Override // org.xmlpull.v1.XmlPullParser
        public boolean isEmptyElementTag() throws XmlPullParserException {
            return false;
        }

        @Override // org.xmlpull.v1.XmlPullParser
        public boolean isWhitespace() throws XmlPullParserException {
            return false;
        }

        @Override // org.xmlpull.v1.XmlPullParser
        public int next() throws XmlPullParserException, IOException {
            int i;
            if (!this.mStarted) {
                this.mStarted = true;
                i = 0;
            } else if (this.mParseState == 0) {
                return 1;
            } else {
                int nativeNext = XmlBlock.nativeNext(this.mParseState);
                if (this.mDecNextDepth) {
                    this.mDepth--;
                    this.mDecNextDepth = false;
                }
                switch (nativeNext) {
                    case 2:
                        this.mDepth++;
                        break;
                    case 3:
                        this.mDecNextDepth = true;
                        break;
                }
                this.mEventType = nativeNext;
                i = nativeNext;
                if (nativeNext == 1) {
                    close();
                    return nativeNext;
                }
            }
            return i;
        }

        @Override // org.xmlpull.v1.XmlPullParser
        public int nextTag() throws XmlPullParserException, IOException {
            int next = next();
            int i = next;
            if (next == 4) {
                i = next;
                if (isWhitespace()) {
                    i = next();
                }
            }
            if (i == 2 || i == 3) {
                return i;
            }
            throw new XmlPullParserException(getPositionDescription() + ": expected start or end tag", this, null);
        }

        @Override // org.xmlpull.v1.XmlPullParser
        public String nextText() throws XmlPullParserException, IOException {
            String str;
            if (getEventType() != 2) {
                throw new XmlPullParserException(getPositionDescription() + ": parser must be on START_TAG to read next text", this, null);
            }
            int next = next();
            if (next == 4) {
                str = getText();
                if (next() != 3) {
                    throw new XmlPullParserException(getPositionDescription() + ": event TEXT it must be immediately followed by END_TAG", this, null);
                }
            } else if (next != 3) {
                throw new XmlPullParserException(getPositionDescription() + ": parser must be on START_TAG or TEXT to read text", this, null);
            } else {
                str = "";
            }
            return str;
        }

        @Override // org.xmlpull.v1.XmlPullParser
        public int nextToken() throws XmlPullParserException, IOException {
            return next();
        }

        @Override // org.xmlpull.v1.XmlPullParser
        public void require(int i, String str, String str2) throws XmlPullParserException, IOException {
            if (i != getEventType() || ((str != null && !str.equals(getNamespace())) || (str2 != null && !str2.equals(getName())))) {
                throw new XmlPullParserException("expected " + TYPES[i] + getPositionDescription());
            }
        }

        @Override // org.xmlpull.v1.XmlPullParser
        public void setFeature(String str, boolean z) throws XmlPullParserException {
            if ("http://xmlpull.org/v1/doc/features.html#process-namespaces".equals(str) && z) {
                return;
            }
            if (!"http://xmlpull.org/v1/doc/features.html#report-namespace-prefixes".equals(str) || !z) {
                throw new XmlPullParserException("Unsupported feature: " + str);
            }
        }

        @Override // org.xmlpull.v1.XmlPullParser
        public void setInput(InputStream inputStream, String str) throws XmlPullParserException {
            throw new XmlPullParserException("setInput() not supported");
        }

        @Override // org.xmlpull.v1.XmlPullParser
        public void setInput(Reader reader) throws XmlPullParserException {
            throw new XmlPullParserException("setInput() not supported");
        }

        @Override // org.xmlpull.v1.XmlPullParser
        public void setProperty(String str, Object obj) throws XmlPullParserException {
            throw new XmlPullParserException("setProperty() not supported");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public XmlBlock(AssetManager assetManager, long j) {
        this.mOpen = true;
        this.mOpenCount = 1;
        this.mAssets = assetManager;
        this.mNative = j;
        this.mStrings = new StringBlock(nativeGetStringBlock(j), false);
    }

    public XmlBlock(byte[] bArr) {
        this.mOpen = true;
        this.mOpenCount = 1;
        this.mAssets = null;
        this.mNative = nativeCreate(bArr, 0, bArr.length);
        this.mStrings = new StringBlock(nativeGetStringBlock(this.mNative), false);
    }

    public XmlBlock(byte[] bArr, int i, int i2) {
        this.mOpen = true;
        this.mOpenCount = 1;
        this.mAssets = null;
        this.mNative = nativeCreate(bArr, i, i2);
        this.mStrings = new StringBlock(nativeGetStringBlock(this.mNative), false);
    }

    static /* synthetic */ int access$008(XmlBlock xmlBlock) {
        int i = xmlBlock.mOpenCount;
        xmlBlock.mOpenCount = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void decOpenCountLocked() {
        this.mOpenCount--;
        if (this.mOpenCount == 0) {
            nativeDestroy(this.mNative);
            if (this.mAssets != null) {
                this.mAssets.xmlBlockGone(hashCode());
            }
        }
    }

    private static final native long nativeCreate(byte[] bArr, int i, int i2);

    private static final native long nativeCreateParseState(long j);

    private static final native void nativeDestroy(long j);

    /* JADX INFO: Access modifiers changed from: private */
    public static final native void nativeDestroyParseState(long j);

    /* JADX INFO: Access modifiers changed from: private */
    public static final native int nativeGetAttributeCount(long j);

    /* JADX INFO: Access modifiers changed from: private */
    public static final native int nativeGetAttributeData(long j, int i);

    /* JADX INFO: Access modifiers changed from: private */
    public static final native int nativeGetAttributeDataType(long j, int i);

    /* JADX INFO: Access modifiers changed from: private */
    public static final native int nativeGetAttributeIndex(long j, String str, String str2);

    /* JADX INFO: Access modifiers changed from: private */
    public static final native int nativeGetAttributeName(long j, int i);

    /* JADX INFO: Access modifiers changed from: private */
    public static final native int nativeGetAttributeNamespace(long j, int i);

    /* JADX INFO: Access modifiers changed from: private */
    public static final native int nativeGetAttributeResource(long j, int i);

    /* JADX INFO: Access modifiers changed from: private */
    public static final native int nativeGetAttributeStringValue(long j, int i);

    /* JADX INFO: Access modifiers changed from: private */
    public static final native int nativeGetClassAttribute(long j);

    /* JADX INFO: Access modifiers changed from: private */
    public static final native int nativeGetIdAttribute(long j);

    /* JADX INFO: Access modifiers changed from: private */
    public static final native int nativeGetLineNumber(long j);

    static final native int nativeGetName(long j);

    /* JADX INFO: Access modifiers changed from: private */
    public static final native int nativeGetNamespace(long j);

    private static final native long nativeGetStringBlock(long j);

    /* JADX INFO: Access modifiers changed from: private */
    public static final native int nativeGetStyleAttribute(long j);

    /* JADX INFO: Access modifiers changed from: private */
    public static final native int nativeGetText(long j);

    static final native int nativeNext(long j);

    public void close() {
        synchronized (this) {
            if (this.mOpen) {
                this.mOpen = false;
                decOpenCountLocked();
            }
        }
    }

    protected void finalize() throws Throwable {
        close();
    }

    public XmlResourceParser newParser() {
        synchronized (this) {
            if (this.mNative != 0) {
                return new Parser(nativeCreateParseState(this.mNative), this);
            }
            return null;
        }
    }
}
