package org.apache.commons.codec.language;

import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.StringEncoder;

/* loaded from: source-3503164-dex2jar.jar:org/apache/commons/codec/language/RefinedSoundex.class */
public class RefinedSoundex implements StringEncoder {
    private final char[] soundexMapping;
    public static final String US_ENGLISH_MAPPING_STRING = "01360240043788015936020505";
    private static final char[] US_ENGLISH_MAPPING = US_ENGLISH_MAPPING_STRING.toCharArray();
    public static final RefinedSoundex US_ENGLISH = new RefinedSoundex();

    public RefinedSoundex() {
        this.soundexMapping = US_ENGLISH_MAPPING;
    }

    public RefinedSoundex(String str) {
        this.soundexMapping = str.toCharArray();
    }

    public RefinedSoundex(char[] cArr) {
        char[] cArr2 = new char[cArr.length];
        this.soundexMapping = cArr2;
        System.arraycopy((Object) cArr, 0, (Object) cArr2, 0, cArr.length);
    }

    public int difference(String str, String str2) throws EncoderException {
        return SoundexUtils.difference(this, str, str2);
    }

    @Override // org.apache.commons.codec.Encoder
    public Object encode(Object obj) throws EncoderException {
        if (obj instanceof String) {
            return soundex((String) obj);
        }
        throw new EncoderException("Parameter supplied to RefinedSoundex encode is not of type java.lang.String");
    }

    @Override // org.apache.commons.codec.StringEncoder
    public String encode(String str) {
        return soundex(str);
    }

    char getMappingCode(char c2) {
        if (Character.isLetter(c2)) {
            return this.soundexMapping[Character.toUpperCase(c2) - 'A'];
        }
        return (char) 0;
    }

    public String soundex(String str) {
        if (str == null) {
            return null;
        }
        String clean = SoundexUtils.clean(str);
        if (clean.length() == 0) {
            return clean;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(clean.charAt(0));
        char c2 = '*';
        for (int i = 0; i < clean.length(); i++) {
            char mappingCode = getMappingCode(clean.charAt(i));
            if (mappingCode != c2) {
                if (mappingCode != 0) {
                    stringBuffer.append(mappingCode);
                }
                c2 = mappingCode;
            }
        }
        return stringBuffer.toString();
    }
}
