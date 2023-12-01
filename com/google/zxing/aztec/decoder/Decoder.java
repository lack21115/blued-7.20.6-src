package com.google.zxing.aztec.decoder;

import androidx.exifinterface.media.ExifInterface;
import com.alipay.sdk.util.i;
import com.amap.api.col.p0003sl.iu;
import com.android.internal.telephony.PhoneConstants;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.google.zxing.FormatException;
import com.google.zxing.aztec.AztecDetectorResult;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.DecoderResult;
import com.google.zxing.common.reedsolomon.GenericGF;
import com.google.zxing.common.reedsolomon.ReedSolomonDecoder;
import com.google.zxing.common.reedsolomon.ReedSolomonException;
import com.huawei.hms.ads.ContentClassification;
import com.j256.ormlite.stmt.query.SimpleComparison;
import com.tencent.qcloud.core.util.IOUtils;
import com.umeng.analytics.pro.bh;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Arrays;

/* loaded from: source-7994992-dex2jar.jar:com/google/zxing/aztec/decoder/Decoder.class */
public final class Decoder {
    private AztecDetectorResult ddata;
    private static final String[] UPPER_TABLE = {"CTRL_PS", " ", "A", "B", "C", "D", ExifInterface.LONGITUDE_EAST, "F", "G", "H", "I", ContentClassification.AD_CONTENT_CLASSIFICATION_J, "K", "L", "M", "N", "O", "P", "Q", "R", ExifInterface.LATITUDE_SOUTH, ExifInterface.GPS_DIRECTION_TRUE, "U", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "W", "X", "Y", "Z", "CTRL_LL", "CTRL_ML", "CTRL_DL", "CTRL_BS"};
    private static final String[] LOWER_TABLE = {"CTRL_PS", " ", "a", "b", "c", "d", iu.h, "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", IAdInterListener.AdReqParam.WIDTH, "x", "y", bh.aG, "CTRL_US", "CTRL_ML", "CTRL_DL", "CTRL_BS"};
    private static final String[] MIXED_TABLE = {"CTRL_PS", " ", "\u0001", "\u0002", "\u0003", "\u0004", "\u0005", "\u0006", "\u0007", "\b", "\t", "\n", "\u000b", "\f", "\r", "\u001b", "\u001c", "\u001d", "\u001e", "\u001f", "@", "\\", "^", BridgeUtil.UNDERLINE_STR, "`", "|", Constants.WAVE_SEPARATOR, "\u007f", "CTRL_LL", "CTRL_UL", "CTRL_PL", "CTRL_BS"};
    private static final String[] PUNCT_TABLE = {"", "\r", IOUtils.LINE_SEPARATOR_WINDOWS, ". ", ", ", ": ", "!", "\"", "#", "$", "%", "&", "'", "(", ")", PhoneConstants.APN_TYPE_ALL, "+", ",", "-", ".", BridgeUtil.SPLIT_MARK, ":", ";", SimpleComparison.LESS_THAN_OPERATION, "=", SimpleComparison.GREATER_THAN_OPERATION, "?", "[", "]", "{", i.d, "CTRL_UL"};
    private static final String[] DIGIT_TABLE = {"CTRL_PS", " ", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", ",", ".", "CTRL_UL", "CTRL_US"};

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.google.zxing.aztec.decoder.Decoder$1  reason: invalid class name */
    /* loaded from: source-7994992-dex2jar.jar:com/google/zxing/aztec/decoder/Decoder$1.class */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$zxing$aztec$decoder$Decoder$Table;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x0041 -> B:27:0x0014). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x0045 -> B:25:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0049 -> B:23:0x002a). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x004d -> B:29:0x0035). Please submit an issue!!! */
        static {
            int[] iArr = new int[Table.values().length];
            $SwitchMap$com$google$zxing$aztec$decoder$Decoder$Table = iArr;
            try {
                iArr[Table.UPPER.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$com$google$zxing$aztec$decoder$Decoder$Table[Table.LOWER.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$com$google$zxing$aztec$decoder$Decoder$Table[Table.MIXED.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$com$google$zxing$aztec$decoder$Decoder$Table[Table.PUNCT.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$com$google$zxing$aztec$decoder$Decoder$Table[Table.DIGIT.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7994992-dex2jar.jar:com/google/zxing/aztec/decoder/Decoder$Table.class */
    public enum Table {
        UPPER,
        LOWER,
        MIXED,
        DIGIT,
        PUNCT,
        BINARY
    }

    static byte[] convertBoolArrayToByteArray(boolean[] zArr) {
        int length = (zArr.length + 7) / 8;
        byte[] bArr = new byte[length];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return bArr;
            }
            bArr[i2] = readByte(zArr, i2 << 3);
            i = i2 + 1;
        }
    }

    private boolean[] correctBits(boolean[] zArr) throws FormatException {
        GenericGF genericGF;
        int i;
        int i2;
        int i3 = 8;
        if (this.ddata.getNbLayers() <= 2) {
            i3 = 6;
            genericGF = GenericGF.AZTEC_DATA_6;
        } else if (this.ddata.getNbLayers() <= 8) {
            genericGF = GenericGF.AZTEC_DATA_8;
        } else if (this.ddata.getNbLayers() <= 22) {
            i3 = 10;
            genericGF = GenericGF.AZTEC_DATA_10;
        } else {
            i3 = 12;
            genericGF = GenericGF.AZTEC_DATA_12;
        }
        int nbDatablocks = this.ddata.getNbDatablocks();
        int length = zArr.length / i3;
        if (length >= nbDatablocks) {
            int length2 = zArr.length % i3;
            int[] iArr = new int[length];
            int i4 = 0;
            while (i4 < length) {
                iArr[i4] = readCode(zArr, length2, i3);
                i4++;
                length2 += i3;
            }
            try {
                new ReedSolomonDecoder(genericGF).decode(iArr, length - nbDatablocks);
                int i5 = (1 << i3) - 1;
                int i6 = 0;
                int i7 = 0;
                while (true) {
                    int i8 = i7;
                    if (i6 < nbDatablocks) {
                        int i9 = iArr[i6];
                        if (i9 == 0 || i9 == i5) {
                            break;
                        }
                        if (i9 != 1) {
                            i2 = i8;
                            if (i9 != i5 - 1) {
                                i6++;
                                i7 = i2;
                            }
                        }
                        i2 = i8 + 1;
                        i6++;
                        i7 = i2;
                    } else {
                        boolean[] zArr2 = new boolean[(nbDatablocks * i3) - i8];
                        int i10 = 0;
                        int i11 = 0;
                        while (true) {
                            int i12 = i11;
                            if (i10 >= nbDatablocks) {
                                return zArr2;
                            }
                            int i13 = iArr[i10];
                            if (i13 == 1 || i13 == i5 - 1) {
                                Arrays.fill(zArr2, i12, (i12 + i3) - 1, i13 > 1);
                                i = i12 + (i3 - 1);
                            } else {
                                int i14 = i3 - 1;
                                while (true) {
                                    i = i12;
                                    if (i14 >= 0) {
                                        zArr2[i12] = ((1 << i14) & i13) != 0;
                                        i14--;
                                        i12++;
                                    }
                                }
                            }
                            i10++;
                            i11 = i;
                        }
                    }
                }
                throw FormatException.getFormatInstance();
            } catch (ReedSolomonException e) {
                throw FormatException.getFormatInstance(e);
            }
        }
        throw FormatException.getFormatInstance();
    }

    private boolean[] extractBits(BitMatrix bitMatrix) {
        boolean isCompact = this.ddata.isCompact();
        int nbLayers = this.ddata.getNbLayers();
        int i = (isCompact ? 11 : 14) + (nbLayers << 2);
        int[] iArr = new int[i];
        boolean[] zArr = new boolean[totalBitsInLayer(nbLayers, isCompact)];
        if (!isCompact) {
            int i2 = i / 2;
            int i3 = ((i + 1) + (((i2 - 1) / 15) * 2)) / 2;
            int i4 = 0;
            while (true) {
                int i5 = i4;
                if (i5 >= i2) {
                    break;
                }
                int i6 = (i5 / 15) + i5;
                iArr[(i2 - i5) - 1] = (i3 - i6) - 1;
                iArr[i2 + i5] = i6 + i3 + 1;
                i4 = i5 + 1;
            }
        } else {
            int i7 = 0;
            while (true) {
                int i8 = i7;
                if (i8 >= i) {
                    break;
                }
                iArr[i8] = i8;
                i7 = i8 + 1;
            }
        }
        int i9 = 0;
        for (int i10 = 0; i10 < nbLayers; i10++) {
            int i11 = ((nbLayers - i10) << 2) + (isCompact ? 9 : 12);
            int i12 = i10 << 1;
            int i13 = (i - 1) - i12;
            int i14 = 0;
            while (true) {
                int i15 = i14;
                if (i15 < i11) {
                    int i16 = i15 << 1;
                    int i17 = 0;
                    while (true) {
                        int i18 = i17;
                        if (i18 < 2) {
                            int i19 = i12 + i18;
                            int i20 = iArr[i19];
                            int i21 = i12 + i15;
                            zArr[i9 + i16 + i18] = bitMatrix.get(i20, iArr[i21]);
                            int i22 = iArr[i21];
                            int i23 = i13 - i18;
                            zArr[(i11 * 2) + i9 + i16 + i18] = bitMatrix.get(i22, iArr[i23]);
                            int i24 = iArr[i23];
                            int i25 = i13 - i15;
                            zArr[(i11 * 4) + i9 + i16 + i18] = bitMatrix.get(i24, iArr[i25]);
                            zArr[(i11 * 6) + i9 + i16 + i18] = bitMatrix.get(iArr[i25], iArr[i19]);
                            i17 = i18 + 1;
                        }
                    }
                    i14 = i15 + 1;
                }
            }
            i9 += i11 << 3;
        }
        return zArr;
    }

    private static String getCharacter(Table table, int i) {
        int i2 = AnonymousClass1.$SwitchMap$com$google$zxing$aztec$decoder$Decoder$Table[table.ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    if (i2 != 4) {
                        if (i2 == 5) {
                            return DIGIT_TABLE[i];
                        }
                        throw new IllegalStateException("Bad table");
                    }
                    return PUNCT_TABLE[i];
                }
                return MIXED_TABLE[i];
            }
            return LOWER_TABLE[i];
        }
        return UPPER_TABLE[i];
    }

    private static String getEncodedData(boolean[] zArr) {
        Table table;
        int length = zArr.length;
        Table table2 = Table.UPPER;
        Table table3 = Table.UPPER;
        StringBuilder sb = new StringBuilder(20);
        int i = 0;
        while (i < length) {
            if (table3 != Table.BINARY) {
                int i2 = table3 == Table.DIGIT ? 4 : 5;
                if (length - i < i2) {
                    break;
                }
                int readCode = readCode(zArr, i, i2);
                i += i2;
                String character = getCharacter(table3, readCode);
                if (character.startsWith("CTRL_")) {
                    Table table4 = getTable(character.charAt(5));
                    if (character.charAt(6) == 'L') {
                        table = table4;
                    } else {
                        table2 = table3;
                        table3 = table4;
                    }
                } else {
                    sb.append(character);
                    table = table2;
                }
                table2 = table;
                table3 = table;
            } else if (length - i < 5) {
                break;
            } else {
                int readCode2 = readCode(zArr, i, 5);
                int i3 = i + 5;
                int i4 = readCode2;
                int i5 = i3;
                if (readCode2 == 0) {
                    if (length - i3 < 11) {
                        break;
                    }
                    i4 = readCode(zArr, i3, 11) + 31;
                    i5 = i3 + 11;
                }
                int i6 = 0;
                int i7 = i5;
                while (true) {
                    table = table2;
                    i = i7;
                    if (i6 >= i4) {
                        break;
                    } else if (length - i7 < 8) {
                        i = length;
                        table = table2;
                        break;
                    } else {
                        sb.append((char) readCode(zArr, i7, 8));
                        i7 += 8;
                        i6++;
                    }
                }
                table2 = table;
                table3 = table;
            }
        }
        return sb.toString();
    }

    private static Table getTable(char c2) {
        return c2 != 'B' ? c2 != 'D' ? c2 != 'P' ? c2 != 'L' ? c2 != 'M' ? Table.UPPER : Table.MIXED : Table.LOWER : Table.PUNCT : Table.DIGIT : Table.BINARY;
    }

    public static String highLevelDecode(boolean[] zArr) {
        return getEncodedData(zArr);
    }

    private static byte readByte(boolean[] zArr, int i) {
        int length = zArr.length - i;
        return (byte) (length >= 8 ? readCode(zArr, i, 8) : readCode(zArr, i, length) << (8 - length));
    }

    private static int readCode(boolean[] zArr, int i, int i2) {
        int i3 = 0;
        int i4 = i;
        while (true) {
            int i5 = i4;
            if (i5 >= i + i2) {
                return i3;
            }
            int i6 = i3 << 1;
            i3 = i6;
            if (zArr[i5]) {
                i3 = i6 | 1;
            }
            i4 = i5 + 1;
        }
    }

    private static int totalBitsInLayer(int i, boolean z) {
        return ((z ? 88 : 112) + (i << 4)) * i;
    }

    public DecoderResult decode(AztecDetectorResult aztecDetectorResult) throws FormatException {
        this.ddata = aztecDetectorResult;
        boolean[] correctBits = correctBits(extractBits(aztecDetectorResult.getBits()));
        DecoderResult decoderResult = new DecoderResult(convertBoolArrayToByteArray(correctBits), getEncodedData(correctBits), null, null);
        decoderResult.setNumBits(correctBits.length);
        return decoderResult;
    }
}
