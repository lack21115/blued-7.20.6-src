package com.sobot.chat.widget.zxing.oned.rss.expanded.decoders;

import com.sobot.chat.widget.zxing.FormatException;
import com.sobot.chat.widget.zxing.NotFoundException;
import com.sobot.chat.widget.zxing.common.BitArray;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/zxing/oned/rss/expanded/decoders/GeneralAppIdDecoder.class */
public final class GeneralAppIdDecoder {
    private final BitArray information;
    private final CurrentParsingState current = new CurrentParsingState();
    private final StringBuilder buffer = new StringBuilder();

    /* JADX INFO: Access modifiers changed from: package-private */
    public GeneralAppIdDecoder(BitArray bitArray) {
        this.information = bitArray;
    }

    private DecodedChar decodeAlphanumeric(int i) {
        char c2;
        int extractNumericValueFromBitArray = extractNumericValueFromBitArray(i, 5);
        if (extractNumericValueFromBitArray == 15) {
            return new DecodedChar(i + 5, '$');
        }
        if (extractNumericValueFromBitArray < 5 || extractNumericValueFromBitArray >= 15) {
            int extractNumericValueFromBitArray2 = extractNumericValueFromBitArray(i, 6);
            if (extractNumericValueFromBitArray2 < 32 || extractNumericValueFromBitArray2 >= 58) {
                switch (extractNumericValueFromBitArray2) {
                    case 58:
                        c2 = '*';
                        break;
                    case 59:
                        c2 = ',';
                        break;
                    case 60:
                        c2 = '-';
                        break;
                    case 61:
                        c2 = '.';
                        break;
                    case 62:
                        c2 = '/';
                        break;
                    default:
                        throw new IllegalStateException("Decoding invalid alphanumeric value: " + extractNumericValueFromBitArray2);
                }
                return new DecodedChar(i + 6, c2);
            }
            return new DecodedChar(i + 6, (char) (extractNumericValueFromBitArray2 + 33));
        }
        return new DecodedChar(i + 5, (char) ((extractNumericValueFromBitArray + 48) - 5));
    }

    private DecodedChar decodeIsoIec646(int i) throws FormatException {
        char c2;
        int extractNumericValueFromBitArray = extractNumericValueFromBitArray(i, 5);
        if (extractNumericValueFromBitArray == 15) {
            return new DecodedChar(i + 5, '$');
        }
        if (extractNumericValueFromBitArray < 5 || extractNumericValueFromBitArray >= 15) {
            int extractNumericValueFromBitArray2 = extractNumericValueFromBitArray(i, 7);
            if (extractNumericValueFromBitArray2 < 64 || extractNumericValueFromBitArray2 >= 90) {
                if (extractNumericValueFromBitArray2 < 90 || extractNumericValueFromBitArray2 >= 116) {
                    switch (extractNumericValueFromBitArray(i, 8)) {
                        case 232:
                            c2 = '!';
                            break;
                        case 233:
                            c2 = '\"';
                            break;
                        case 234:
                            c2 = '%';
                            break;
                        case 235:
                            c2 = '&';
                            break;
                        case 236:
                            c2 = '\'';
                            break;
                        case 237:
                            c2 = '(';
                            break;
                        case 238:
                            c2 = ')';
                            break;
                        case 239:
                            c2 = '*';
                            break;
                        case 240:
                            c2 = '+';
                            break;
                        case 241:
                            c2 = ',';
                            break;
                        case 242:
                            c2 = '-';
                            break;
                        case 243:
                            c2 = '.';
                            break;
                        case 244:
                            c2 = '/';
                            break;
                        case 245:
                            c2 = ':';
                            break;
                        case 246:
                            c2 = ';';
                            break;
                        case 247:
                            c2 = '<';
                            break;
                        case 248:
                            c2 = '=';
                            break;
                        case 249:
                            c2 = '>';
                            break;
                        case 250:
                            c2 = '?';
                            break;
                        case 251:
                            c2 = '_';
                            break;
                        case 252:
                            c2 = ' ';
                            break;
                        default:
                            throw FormatException.getFormatInstance();
                    }
                    return new DecodedChar(i + 8, c2);
                }
                return new DecodedChar(i + 7, (char) (extractNumericValueFromBitArray2 + 7));
            }
            return new DecodedChar(i + 7, (char) (extractNumericValueFromBitArray2 + 1));
        }
        return new DecodedChar(i + 5, (char) ((extractNumericValueFromBitArray + 48) - 5));
    }

    private DecodedNumeric decodeNumeric(int i) throws FormatException {
        int i2 = i + 7;
        if (i2 > this.information.getSize()) {
            int extractNumericValueFromBitArray = extractNumericValueFromBitArray(i, 4);
            return extractNumericValueFromBitArray == 0 ? new DecodedNumeric(this.information.getSize(), 10, 10) : new DecodedNumeric(this.information.getSize(), extractNumericValueFromBitArray - 1, 10);
        }
        int extractNumericValueFromBitArray2 = extractNumericValueFromBitArray(i, 7) - 8;
        return new DecodedNumeric(i2, extractNumericValueFromBitArray2 / 11, extractNumericValueFromBitArray2 % 11);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int extractNumericValueFromBitArray(BitArray bitArray, int i, int i2) {
        int i3 = 0;
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i3 >= i2) {
                return i5;
            }
            int i6 = i5;
            if (bitArray.get(i + i3)) {
                i6 = i5 | (1 << ((i2 - i3) - 1));
            }
            i3++;
            i4 = i6;
        }
    }

    private boolean isAlphaOr646ToNumericLatch(int i) {
        int i2 = i + 3;
        if (i2 > this.information.getSize()) {
            return false;
        }
        while (i < i2) {
            if (this.information.get(i)) {
                return false;
            }
            i++;
        }
        return true;
    }

    private boolean isAlphaTo646ToAlphaLatch(int i) {
        int i2;
        if (i + 1 > this.information.getSize()) {
            return false;
        }
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= 5 || (i2 = i4 + i) >= this.information.getSize()) {
                return true;
            }
            if (i4 == 2) {
                if (!this.information.get(i + 2)) {
                    return false;
                }
            } else if (this.information.get(i2)) {
                return false;
            }
            i3 = i4 + 1;
        }
    }

    private boolean isNumericToAlphaNumericLatch(int i) {
        int i2;
        if (i + 1 > this.information.getSize()) {
            return false;
        }
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= 4 || (i2 = i4 + i) >= this.information.getSize()) {
                return true;
            }
            if (this.information.get(i2)) {
                return false;
            }
            i3 = i4 + 1;
        }
    }

    private boolean isStillAlpha(int i) {
        if (i + 5 > this.information.getSize()) {
            return false;
        }
        int extractNumericValueFromBitArray = extractNumericValueFromBitArray(i, 5);
        if (extractNumericValueFromBitArray < 5 || extractNumericValueFromBitArray >= 16) {
            if (i + 6 > this.information.getSize()) {
                return false;
            }
            int extractNumericValueFromBitArray2 = extractNumericValueFromBitArray(i, 6);
            boolean z = false;
            if (extractNumericValueFromBitArray2 >= 16) {
                z = false;
                if (extractNumericValueFromBitArray2 < 63) {
                    z = true;
                }
            }
            return z;
        }
        return true;
    }

    private boolean isStillIsoIec646(int i) {
        if (i + 5 > this.information.getSize()) {
            return false;
        }
        int extractNumericValueFromBitArray = extractNumericValueFromBitArray(i, 5);
        if (extractNumericValueFromBitArray < 5 || extractNumericValueFromBitArray >= 16) {
            if (i + 7 > this.information.getSize()) {
                return false;
            }
            int extractNumericValueFromBitArray2 = extractNumericValueFromBitArray(i, 7);
            if (extractNumericValueFromBitArray2 < 64 || extractNumericValueFromBitArray2 >= 116) {
                if (i + 8 > this.information.getSize()) {
                    return false;
                }
                int extractNumericValueFromBitArray3 = extractNumericValueFromBitArray(i, 8);
                boolean z = false;
                if (extractNumericValueFromBitArray3 >= 232) {
                    z = false;
                    if (extractNumericValueFromBitArray3 < 253) {
                        z = true;
                    }
                }
                return z;
            }
            return true;
        }
        return true;
    }

    private boolean isStillNumeric(int i) {
        if (i + 7 > this.information.getSize()) {
            return i + 4 <= this.information.getSize();
        }
        int i2 = i;
        while (true) {
            int i3 = i2;
            int i4 = i + 3;
            if (i3 >= i4) {
                return this.information.get(i4);
            }
            if (this.information.get(i3)) {
                return true;
            }
            i2 = i3 + 1;
        }
    }

    private BlockParsedResult parseAlphaBlock() {
        while (isStillAlpha(this.current.getPosition())) {
            DecodedChar decodeAlphanumeric = decodeAlphanumeric(this.current.getPosition());
            this.current.setPosition(decodeAlphanumeric.getNewPosition());
            if (decodeAlphanumeric.isFNC1()) {
                return new BlockParsedResult(new DecodedInformation(this.current.getPosition(), this.buffer.toString()), true);
            }
            this.buffer.append(decodeAlphanumeric.getValue());
        }
        if (isAlphaOr646ToNumericLatch(this.current.getPosition())) {
            this.current.incrementPosition(3);
            this.current.setNumeric();
        } else if (isAlphaTo646ToAlphaLatch(this.current.getPosition())) {
            if (this.current.getPosition() + 5 < this.information.getSize()) {
                this.current.incrementPosition(5);
            } else {
                this.current.setPosition(this.information.getSize());
            }
            this.current.setIsoIec646();
        }
        return new BlockParsedResult(false);
    }

    private DecodedInformation parseBlocks() throws FormatException {
        BlockParsedResult parseNumericBlock;
        boolean isFinished;
        do {
            int position = this.current.getPosition();
            if (this.current.isAlpha()) {
                parseNumericBlock = parseAlphaBlock();
                isFinished = parseNumericBlock.isFinished();
            } else if (this.current.isIsoIec646()) {
                parseNumericBlock = parseIsoIec646Block();
                isFinished = parseNumericBlock.isFinished();
            } else {
                parseNumericBlock = parseNumericBlock();
                isFinished = parseNumericBlock.isFinished();
            }
            if (!(position != this.current.getPosition()) && !isFinished) {
                break;
            }
        } while (!isFinished);
        return parseNumericBlock.getDecodedInformation();
    }

    private BlockParsedResult parseIsoIec646Block() throws FormatException {
        while (isStillIsoIec646(this.current.getPosition())) {
            DecodedChar decodeIsoIec646 = decodeIsoIec646(this.current.getPosition());
            this.current.setPosition(decodeIsoIec646.getNewPosition());
            if (decodeIsoIec646.isFNC1()) {
                return new BlockParsedResult(new DecodedInformation(this.current.getPosition(), this.buffer.toString()), true);
            }
            this.buffer.append(decodeIsoIec646.getValue());
        }
        if (isAlphaOr646ToNumericLatch(this.current.getPosition())) {
            this.current.incrementPosition(3);
            this.current.setNumeric();
        } else if (isAlphaTo646ToAlphaLatch(this.current.getPosition())) {
            if (this.current.getPosition() + 5 < this.information.getSize()) {
                this.current.incrementPosition(5);
            } else {
                this.current.setPosition(this.information.getSize());
            }
            this.current.setAlpha();
        }
        return new BlockParsedResult(false);
    }

    private BlockParsedResult parseNumericBlock() throws FormatException {
        while (isStillNumeric(this.current.getPosition())) {
            DecodedNumeric decodeNumeric = decodeNumeric(this.current.getPosition());
            this.current.setPosition(decodeNumeric.getNewPosition());
            if (decodeNumeric.isFirstDigitFNC1()) {
                return new BlockParsedResult(decodeNumeric.isSecondDigitFNC1() ? new DecodedInformation(this.current.getPosition(), this.buffer.toString()) : new DecodedInformation(this.current.getPosition(), this.buffer.toString(), decodeNumeric.getSecondDigit()), true);
            }
            this.buffer.append(decodeNumeric.getFirstDigit());
            if (decodeNumeric.isSecondDigitFNC1()) {
                return new BlockParsedResult(new DecodedInformation(this.current.getPosition(), this.buffer.toString()), true);
            }
            this.buffer.append(decodeNumeric.getSecondDigit());
        }
        if (isNumericToAlphaNumericLatch(this.current.getPosition())) {
            this.current.setAlpha();
            this.current.incrementPosition(4);
        }
        return new BlockParsedResult(false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String decodeAllCodes(StringBuilder sb, int i) throws NotFoundException, FormatException {
        String str = null;
        while (true) {
            DecodedInformation decodeGeneralPurposeField = decodeGeneralPurposeField(i, str);
            String parseFieldsInGeneralPurpose = FieldParser.parseFieldsInGeneralPurpose(decodeGeneralPurposeField.getNewString());
            if (parseFieldsInGeneralPurpose != null) {
                sb.append(parseFieldsInGeneralPurpose);
            }
            str = decodeGeneralPurposeField.isRemaining() ? String.valueOf(decodeGeneralPurposeField.getRemainingValue()) : null;
            if (i == decodeGeneralPurposeField.getNewPosition()) {
                return sb.toString();
            }
            i = decodeGeneralPurposeField.getNewPosition();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DecodedInformation decodeGeneralPurposeField(int i, String str) throws FormatException {
        this.buffer.setLength(0);
        if (str != null) {
            this.buffer.append(str);
        }
        this.current.setPosition(i);
        DecodedInformation parseBlocks = parseBlocks();
        return (parseBlocks == null || !parseBlocks.isRemaining()) ? new DecodedInformation(this.current.getPosition(), this.buffer.toString()) : new DecodedInformation(this.current.getPosition(), this.buffer.toString(), parseBlocks.getRemainingValue());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int extractNumericValueFromBitArray(int i, int i2) {
        return extractNumericValueFromBitArray(this.information, i, i2);
    }
}
