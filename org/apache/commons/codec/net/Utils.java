package org.apache.commons.codec.net;

import org.apache.commons.codec.DecoderException;

/* loaded from: source-3503164-dex2jar.jar:org/apache/commons/codec/net/Utils.class */
class Utils {
    Utils() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int digit16(byte b) throws DecoderException {
        int digit = Character.digit((char) b, 16);
        if (digit != -1) {
            return digit;
        }
        throw new DecoderException("Invalid URL encoding: not a valid digit (radix 16): " + ((int) b));
    }
}
