package com.tencent.tinker.android.dx.instruction;

import com.tencent.tinker.android.dex.DexException;
import com.tencent.tinker.android.dx.util.Hex;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tinker/android/dx/instruction/InstructionCodec.class */
public final class InstructionCodec {
    public static final int INDEX_TYPE_FIELD_REF = 5;
    public static final int INDEX_TYPE_METHOD_REF = 4;
    public static final int INDEX_TYPE_NONE = 1;
    public static final int INDEX_TYPE_STRING_REF = 3;
    public static final int INDEX_TYPE_TYPE_REF = 2;
    public static final int INDEX_TYPE_UNKNOWN = 0;
    public static final int INSN_FORMAT_00X = 1;
    public static final int INSN_FORMAT_10T = 2;
    public static final int INSN_FORMAT_10X = 3;
    public static final int INSN_FORMAT_11N = 4;
    public static final int INSN_FORMAT_11X = 5;
    public static final int INSN_FORMAT_12X = 6;
    public static final int INSN_FORMAT_20T = 7;
    public static final int INSN_FORMAT_21C = 8;
    public static final int INSN_FORMAT_21H = 9;
    public static final int INSN_FORMAT_21S = 10;
    public static final int INSN_FORMAT_21T = 11;
    public static final int INSN_FORMAT_22B = 12;
    public static final int INSN_FORMAT_22C = 13;
    public static final int INSN_FORMAT_22S = 14;
    public static final int INSN_FORMAT_22T = 15;
    public static final int INSN_FORMAT_22X = 16;
    public static final int INSN_FORMAT_23X = 17;
    public static final int INSN_FORMAT_30T = 18;
    public static final int INSN_FORMAT_31C = 19;
    public static final int INSN_FORMAT_31I = 20;
    public static final int INSN_FORMAT_31T = 21;
    public static final int INSN_FORMAT_32X = 22;
    public static final int INSN_FORMAT_35C = 23;
    public static final int INSN_FORMAT_3RC = 24;
    public static final int INSN_FORMAT_51L = 25;
    public static final int INSN_FORMAT_FILL_ARRAY_DATA_PAYLOAD = 26;
    public static final int INSN_FORMAT_PACKED_SWITCH_PAYLOAD = 27;
    public static final int INSN_FORMAT_SPARSE_SWITCH_PAYLOAD = 28;
    public static final int INSN_FORMAT_UNKNOWN = 0;

    private InstructionCodec() {
        throw new UnsupportedOperationException();
    }

    public static short asUnsignedUnit(int i) {
        if (((-65536) & i) == 0) {
            return (short) i;
        }
        throw new IllegalArgumentException("bogus unsigned code unit");
    }

    public static int byte0(int i) {
        return i & 255;
    }

    public static int byte1(int i) {
        return (i >> 8) & 255;
    }

    public static short codeUnit(int i, int i2) {
        if ((i & (-256)) == 0) {
            if ((i2 & (-256)) == 0) {
                return (short) (i | (i2 << 8));
            }
            throw new IllegalArgumentException("bogus highByte");
        }
        throw new IllegalArgumentException("bogus lowByte");
    }

    public static short codeUnit(int i, int i2, int i3, int i4) {
        if ((i & (-16)) == 0) {
            if ((i2 & (-16)) == 0) {
                if ((i3 & (-16)) == 0) {
                    if ((i4 & (-16)) == 0) {
                        return (short) (i | (i2 << 4) | (i3 << 8) | (i4 << 12));
                    }
                    throw new IllegalArgumentException("bogus nibble3");
                }
                throw new IllegalArgumentException("bogus nibble2");
            }
            throw new IllegalArgumentException("bogus nibble1");
        }
        throw new IllegalArgumentException("bogus nibble0");
    }

    public static short getAUnit(int i) {
        if (((-65536) & i) == 0) {
            return (short) i;
        }
        throw new DexException("Register A out of range: " + Hex.u8(i));
    }

    public static short getBUnit(int i) {
        if (((-65536) & i) == 0) {
            return (short) i;
        }
        throw new DexException("Register B out of range: " + Hex.u8(i));
    }

    public static int getInstructionFormat(int i) {
        if (i != 256) {
            if (i != 512) {
                if (i != 768) {
                    switch (i) {
                        case -1:
                            return 1;
                        case 0:
                        case 14:
                            return 3;
                        case 1:
                        case 4:
                        case 7:
                        case 33:
                            return 6;
                        case 2:
                        case 5:
                        case 8:
                            return 16;
                        case 3:
                        case 6:
                        case 9:
                            return 22;
                        case 10:
                        case 11:
                        case 12:
                        case 13:
                        case 15:
                        case 16:
                        case 17:
                        case 29:
                        case 30:
                        case 39:
                            return 5;
                        case 18:
                            return 4;
                        case 19:
                        case 22:
                            return 10;
                        case 20:
                        case 23:
                            return 20;
                        case 21:
                        case 25:
                            return 9;
                        case 24:
                            return 25;
                        case 26:
                        case 28:
                        case 31:
                        case 34:
                            return 8;
                        case 27:
                            return 19;
                        case 32:
                        case 35:
                            return 13;
                        case 36:
                            return 23;
                        case 37:
                            return 24;
                        case 38:
                        case 43:
                        case 44:
                            return 21;
                        case 40:
                            return 2;
                        case 41:
                            return 7;
                        case 42:
                            return 18;
                        case 45:
                        case 46:
                        case 47:
                        case 48:
                        case 49:
                            return 17;
                        case 50:
                        case 51:
                        case 52:
                        case 53:
                        case 54:
                        case 55:
                            return 15;
                        case 56:
                        case 57:
                        case 58:
                        case 59:
                        case 60:
                        case 61:
                            return 11;
                        default:
                            switch (i) {
                                case 68:
                                case 69:
                                case 70:
                                case 71:
                                case 72:
                                case 73:
                                case 74:
                                case 75:
                                case 76:
                                case 77:
                                case 78:
                                case 79:
                                case 80:
                                case 81:
                                    return 17;
                                case 82:
                                case 83:
                                case 84:
                                case 85:
                                case 86:
                                case 87:
                                case 88:
                                case 89:
                                case 90:
                                case 91:
                                case 92:
                                case 93:
                                case 94:
                                case 95:
                                    return 13;
                                case 96:
                                case 97:
                                case 98:
                                case 99:
                                case 100:
                                case 101:
                                case 102:
                                case 103:
                                case 104:
                                case 105:
                                case 106:
                                case 107:
                                case 108:
                                case 109:
                                    return 8;
                                case 110:
                                case 111:
                                case 112:
                                case 113:
                                case 114:
                                    return 23;
                                default:
                                    switch (i) {
                                        case 116:
                                        case 117:
                                        case 118:
                                        case 119:
                                        case 120:
                                            return 24;
                                        default:
                                            switch (i) {
                                                case 123:
                                                case 124:
                                                case 125:
                                                case 126:
                                                case 127:
                                                case 128:
                                                case 129:
                                                case 130:
                                                case 131:
                                                case 132:
                                                case 133:
                                                case 134:
                                                case 135:
                                                case 136:
                                                case 137:
                                                case 138:
                                                case 139:
                                                case 140:
                                                case 141:
                                                case 142:
                                                case 143:
                                                case 176:
                                                case 177:
                                                case 178:
                                                case 179:
                                                case 180:
                                                case 181:
                                                case 182:
                                                case 183:
                                                case 184:
                                                case 185:
                                                case 186:
                                                case 187:
                                                case 188:
                                                case 189:
                                                case 190:
                                                case 191:
                                                case 192:
                                                case 193:
                                                case 194:
                                                case 195:
                                                case 196:
                                                case 197:
                                                case 198:
                                                case 199:
                                                case 200:
                                                case 201:
                                                case 202:
                                                case 203:
                                                case 204:
                                                case 205:
                                                case 206:
                                                case 207:
                                                    return 6;
                                                case 144:
                                                case 145:
                                                case 146:
                                                case 147:
                                                case 148:
                                                case 149:
                                                case 150:
                                                case 151:
                                                case 152:
                                                case 153:
                                                case 154:
                                                case 155:
                                                case 156:
                                                case 157:
                                                case 158:
                                                case 159:
                                                case 160:
                                                case 161:
                                                case 162:
                                                case 163:
                                                case 164:
                                                case 165:
                                                case 166:
                                                case 167:
                                                case 168:
                                                case 169:
                                                case 170:
                                                case 171:
                                                case 172:
                                                case 173:
                                                case 174:
                                                case 175:
                                                    return 17;
                                                case 208:
                                                case 209:
                                                case 210:
                                                case 211:
                                                case 212:
                                                case 213:
                                                case 214:
                                                case 215:
                                                    return 14;
                                                case 216:
                                                case 217:
                                                case 218:
                                                case 219:
                                                case 220:
                                                case 221:
                                                case 222:
                                                case 223:
                                                case 224:
                                                case 225:
                                                case 226:
                                                    return 12;
                                                default:
                                                    return 0;
                                            }
                                    }
                            }
                    }
                }
                return 26;
            }
            return 28;
        }
        return 27;
    }

    public static int getInstructionIndexType(int i) {
        if (i == 256 || i == 512 || i == 768) {
            return 1;
        }
        switch (i) {
            case -1:
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 29:
            case 30:
            case 33:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
            case 47:
            case 48:
            case 49:
            case 50:
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
                return 1;
            case 26:
            case 27:
                return 3;
            case 28:
            case 31:
            case 32:
            case 34:
            case 35:
            case 36:
            case 37:
                return 2;
            default:
                switch (i) {
                    case 68:
                    case 69:
                    case 70:
                    case 71:
                    case 72:
                    case 73:
                    case 74:
                    case 75:
                    case 76:
                    case 77:
                    case 78:
                    case 79:
                    case 80:
                    case 81:
                        return 1;
                    case 82:
                    case 83:
                    case 84:
                    case 85:
                    case 86:
                    case 87:
                    case 88:
                    case 89:
                    case 90:
                    case 91:
                    case 92:
                    case 93:
                    case 94:
                    case 95:
                    case 96:
                    case 97:
                    case 98:
                    case 99:
                    case 100:
                    case 101:
                    case 102:
                    case 103:
                    case 104:
                    case 105:
                    case 106:
                    case 107:
                    case 108:
                    case 109:
                        return 5;
                    case 110:
                    case 111:
                    case 112:
                    case 113:
                    case 114:
                        return 4;
                    default:
                        switch (i) {
                            case 116:
                            case 117:
                            case 118:
                            case 119:
                            case 120:
                                return 4;
                            default:
                                switch (i) {
                                    case 123:
                                    case 124:
                                    case 125:
                                    case 126:
                                    case 127:
                                    case 128:
                                    case 129:
                                    case 130:
                                    case 131:
                                    case 132:
                                    case 133:
                                    case 134:
                                    case 135:
                                    case 136:
                                    case 137:
                                    case 138:
                                    case 139:
                                    case 140:
                                    case 141:
                                    case 142:
                                    case 143:
                                    case 144:
                                    case 145:
                                    case 146:
                                    case 147:
                                    case 148:
                                    case 149:
                                    case 150:
                                    case 151:
                                    case 152:
                                    case 153:
                                    case 154:
                                    case 155:
                                    case 156:
                                    case 157:
                                    case 158:
                                    case 159:
                                    case 160:
                                    case 161:
                                    case 162:
                                    case 163:
                                    case 164:
                                    case 165:
                                    case 166:
                                    case 167:
                                    case 168:
                                    case 169:
                                    case 170:
                                    case 171:
                                    case 172:
                                    case 173:
                                    case 174:
                                    case 175:
                                    case 176:
                                    case 177:
                                    case 178:
                                    case 179:
                                    case 180:
                                    case 181:
                                    case 182:
                                    case 183:
                                    case 184:
                                    case 185:
                                    case 186:
                                    case 187:
                                    case 188:
                                    case 189:
                                    case 190:
                                    case 191:
                                    case 192:
                                    case 193:
                                    case 194:
                                    case 195:
                                    case 196:
                                    case 197:
                                    case 198:
                                    case 199:
                                    case 200:
                                    case 201:
                                    case 202:
                                    case 203:
                                    case 204:
                                    case 205:
                                    case 206:
                                    case 207:
                                    case 208:
                                    case 209:
                                    case 210:
                                    case 211:
                                    case 212:
                                    case 213:
                                    case 214:
                                    case 215:
                                    case 216:
                                    case 217:
                                    case 218:
                                    case 219:
                                    case 220:
                                    case 221:
                                    case 222:
                                    case 223:
                                    case 224:
                                    case 225:
                                    case 226:
                                        return 1;
                                    default:
                                        return 0;
                                }
                        }
                }
        }
    }

    public static int getLiteralByte(long j) {
        int i = (int) j;
        if (j == ((byte) i)) {
            return i & 255;
        }
        throw new DexException("Literal out of range: " + Hex.u8(j));
    }

    public static int getLiteralInt(long j) {
        int i = (int) j;
        if (j == i) {
            return i;
        }
        throw new DexException("Literal out of range: " + Hex.u8(j));
    }

    public static int getLiteralNibble(long j) {
        if (j < -8 || j > 7) {
            throw new DexException("Literal out of range: " + Hex.u8(j));
        }
        return ((int) j) & 15;
    }

    public static short getLiteralUnit(long j) {
        short s = (short) j;
        if (j == s) {
            return s;
        }
        throw new DexException("Literal out of range: " + Hex.u8(j));
    }

    public static int getTarget(int i, int i2) {
        return i - i2;
    }

    public static int getTargetByte(int i, int i2) {
        int target = getTarget(i, i2);
        if (target == ((byte) target)) {
            return target & 255;
        }
        throw new DexException("Target out of range: " + Hex.s4(target) + ", perhaps you need to enable force jumbo mode.");
    }

    public static short getTargetUnit(int i, int i2) {
        int target = getTarget(i, i2);
        short s = (short) target;
        if (target == s) {
            return s;
        }
        throw new DexException("Target out of range: " + Hex.s4(target) + ", perhaps you need to enable force jumbo mode.");
    }

    public static int makeByte(int i, int i2) {
        if ((i & (-16)) == 0) {
            if ((i2 & (-16)) == 0) {
                return i | (i2 << 4);
            }
            throw new IllegalArgumentException("bogus highNibble");
        }
        throw new IllegalArgumentException("bogus lowNibble");
    }

    public static int nibble0(int i) {
        return i & 15;
    }

    public static int nibble1(int i) {
        return (i >> 4) & 15;
    }

    public static int nibble2(int i) {
        return (i >> 8) & 15;
    }

    public static int nibble3(int i) {
        return (i >> 12) & 15;
    }

    public static short unit0(int i) {
        return (short) i;
    }

    public static short unit0(long j) {
        return (short) j;
    }

    public static short unit1(int i) {
        return (short) (i >> 16);
    }

    public static short unit1(long j) {
        return (short) (j >> 16);
    }

    public static short unit2(long j) {
        return (short) (j >> 32);
    }

    public static short unit3(long j) {
        return (short) (j >> 48);
    }
}
