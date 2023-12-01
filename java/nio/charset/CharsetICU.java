package java.nio.charset;

import libcore.icu.NativeConverter;

/* loaded from: source-2895416-dex2jar.jar:java/nio/charset/CharsetICU.class */
final class CharsetICU extends Charset {
    private final String icuCanonicalName;

    protected CharsetICU(String str, String str2, String[] strArr) {
        super(str, strArr);
        this.icuCanonicalName = str2;
    }

    @Override // java.nio.charset.Charset
    public boolean contains(Charset charset) {
        if (charset == null) {
            return false;
        }
        if (equals(charset)) {
            return true;
        }
        return NativeConverter.contains(name(), charset.name());
    }

    @Override // java.nio.charset.Charset
    public CharsetDecoder newDecoder() {
        return CharsetDecoderICU.newInstance(this, this.icuCanonicalName);
    }

    @Override // java.nio.charset.Charset
    public CharsetEncoder newEncoder() {
        return CharsetEncoderICU.newInstance(this, this.icuCanonicalName);
    }
}
