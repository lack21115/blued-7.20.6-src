package com.tencent.tinker.android.dx.instruction;

import com.tencent.tinker.android.dex.DexException;
import com.tencent.tinker.android.dx.util.Hex;
import com.tencent.tinker.android.utils.SparseIntArray;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tinker/android/dx/instruction/InstructionPromoter.class */
public final class InstructionPromoter extends InstructionVisitor {
    private final SparseIntArray addressMap;
    private int currentPromotedAddress;

    public InstructionPromoter() {
        super(null);
        this.addressMap = new SparseIntArray();
        this.currentPromotedAddress = 0;
    }

    private void mapAddressIfNeeded(int i) {
        int i2 = this.currentPromotedAddress;
        if (i != i2) {
            this.addressMap.append(i, i2);
        }
    }

    public int getPromotedAddress(int i) {
        int indexOfKey = this.addressMap.indexOfKey(i);
        return indexOfKey < 0 ? i : this.addressMap.valueAt(indexOfKey);
    }

    public int getPromotedAddressCount() {
        return this.addressMap.size();
    }

    @Override // com.tencent.tinker.android.dx.instruction.InstructionVisitor
    public void visitFillArrayDataPayloadInsn(int i, int i2, Object obj, int i3, int i4) {
        mapAddressIfNeeded(i);
        int i5 = this.currentPromotedAddress + 4;
        this.currentPromotedAddress = i5;
        if (i4 == 1) {
            int length = ((byte[]) obj).length;
            this.currentPromotedAddress = i5 + (length >> 1) + (length & 1);
        } else if (i4 == 2) {
            this.currentPromotedAddress = i5 + (((short[]) obj).length * 1);
        } else if (i4 == 4) {
            this.currentPromotedAddress = i5 + (((int[]) obj).length * 2);
        } else if (i4 == 8) {
            this.currentPromotedAddress = i5 + (((long[]) obj).length * 4);
        } else {
            throw new DexException("bogus element_width: " + Hex.u2(i4));
        }
    }

    @Override // com.tencent.tinker.android.dx.instruction.InstructionVisitor
    public void visitFiveRegisterInsn(int i, int i2, int i3, int i4, int i5, long j, int i6, int i7, int i8, int i9, int i10) {
        mapAddressIfNeeded(i);
        if (i2 != 36) {
            switch (i2) {
                case 110:
                case 111:
                case 112:
                case 113:
                case 114:
                    break;
                default:
                    throw new IllegalStateException("unexpected opcode: " + Hex.u2or4(i2));
            }
        }
        this.currentPromotedAddress += 3;
    }

    @Override // com.tencent.tinker.android.dx.instruction.InstructionVisitor
    public void visitFourRegisterInsn(int i, int i2, int i3, int i4, int i5, long j, int i6, int i7, int i8, int i9) {
        mapAddressIfNeeded(i);
        if (i2 != 36) {
            switch (i2) {
                case 110:
                case 111:
                case 112:
                case 113:
                case 114:
                    break;
                default:
                    throw new IllegalStateException("unexpected opcode: " + Hex.u2or4(i2));
            }
        }
        this.currentPromotedAddress += 3;
    }

    @Override // com.tencent.tinker.android.dx.instruction.InstructionVisitor
    public void visitOneRegisterInsn(int i, int i2, int i3, int i4, int i5, long j, int i6) {
        mapAddressIfNeeded(i);
        if (i2 != 34) {
            if (i2 != 36 && i2 != 38) {
                if (i2 != 39) {
                    if (i2 != 43 && i2 != 44) {
                        switch (i2) {
                            case 10:
                            case 11:
                            case 12:
                            case 13:
                                break;
                            default:
                                switch (i2) {
                                    case 15:
                                    case 16:
                                    case 17:
                                    case 18:
                                    case 29:
                                    case 30:
                                        break;
                                    case 19:
                                    case 21:
                                    case 22:
                                    case 25:
                                    case 28:
                                    case 31:
                                        break;
                                    case 20:
                                    case 23:
                                        break;
                                    case 24:
                                        this.currentPromotedAddress += 5;
                                        return;
                                    case 26:
                                        if (i3 > 65535) {
                                            this.currentPromotedAddress += 3;
                                            return;
                                        } else {
                                            this.currentPromotedAddress += 2;
                                            return;
                                        }
                                    case 27:
                                        this.currentPromotedAddress += 3;
                                        return;
                                    default:
                                        switch (i2) {
                                            case 56:
                                            case 57:
                                            case 58:
                                            case 59:
                                            case 60:
                                            case 61:
                                                break;
                                            default:
                                                switch (i2) {
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
                                                        break;
                                                    case 110:
                                                    case 111:
                                                    case 112:
                                                    case 113:
                                                    case 114:
                                                        break;
                                                    default:
                                                        throw new IllegalStateException("unexpected opcode: " + Hex.u2or4(i2));
                                                }
                                        }
                                }
                        }
                    }
                }
                this.currentPromotedAddress++;
                return;
            }
            this.currentPromotedAddress += 3;
            return;
        }
        this.currentPromotedAddress += 2;
    }

    @Override // com.tencent.tinker.android.dx.instruction.InstructionVisitor
    public void visitPackedSwitchPayloadInsn(int i, int i2, int i3, int[] iArr) {
        mapAddressIfNeeded(i);
        int i4 = this.currentPromotedAddress + 4;
        this.currentPromotedAddress = i4;
        this.currentPromotedAddress = i4 + (iArr.length * 2);
    }

    @Override // com.tencent.tinker.android.dx.instruction.InstructionVisitor
    public void visitRegisterRangeInsn(int i, int i2, int i3, int i4, int i5, long j, int i6, int i7) {
        mapAddressIfNeeded(i);
        if (i2 != 37) {
            switch (i2) {
                case 116:
                case 117:
                case 118:
                case 119:
                case 120:
                    break;
                default:
                    throw new IllegalStateException("unexpected opcode: " + Hex.u2or4(i2));
            }
        }
        this.currentPromotedAddress += 3;
    }

    @Override // com.tencent.tinker.android.dx.instruction.InstructionVisitor
    public void visitSparseSwitchPayloadInsn(int i, int i2, int[] iArr, int[] iArr2) {
        mapAddressIfNeeded(i);
        int i3 = this.currentPromotedAddress + 2;
        this.currentPromotedAddress = i3;
        int length = i3 + (iArr.length * 2);
        this.currentPromotedAddress = length;
        this.currentPromotedAddress = length + (iArr2.length * 2);
    }

    @Override // com.tencent.tinker.android.dx.instruction.InstructionVisitor
    public void visitThreeRegisterInsn(int i, int i2, int i3, int i4, int i5, long j, int i6, int i7, int i8) {
        mapAddressIfNeeded(i);
        if (i2 != 36) {
            switch (i2) {
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    break;
                default:
                    switch (i2) {
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
                            break;
                        default:
                            switch (i2) {
                                case 110:
                                case 111:
                                case 112:
                                case 113:
                                case 114:
                                    break;
                                default:
                                    switch (i2) {
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
                                            break;
                                        default:
                                            throw new IllegalStateException("unexpected opcode: " + Hex.u2or4(i2));
                                    }
                            }
                    }
            }
            this.currentPromotedAddress += 2;
            return;
        }
        this.currentPromotedAddress += 3;
    }

    @Override // com.tencent.tinker.android.dx.instruction.InstructionVisitor
    public void visitTwoRegisterInsn(int i, int i2, int i3, int i4, int i5, long j, int i6, int i7) {
        mapAddressIfNeeded(i);
        if (i2 != 32) {
            if (i2 != 33) {
                if (i2 != 35) {
                    if (i2 != 36) {
                        switch (i2) {
                            case 1:
                            case 4:
                            case 7:
                                break;
                            case 2:
                            case 5:
                            case 8:
                                this.currentPromotedAddress += 2;
                                return;
                            case 3:
                            case 6:
                            case 9:
                                break;
                            default:
                                switch (i2) {
                                    case 50:
                                    case 51:
                                    case 52:
                                    case 53:
                                    case 54:
                                    case 55:
                                        break;
                                    default:
                                        switch (i2) {
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
                                                break;
                                            default:
                                                switch (i2) {
                                                    case 110:
                                                    case 111:
                                                    case 112:
                                                    case 113:
                                                    case 114:
                                                        break;
                                                    default:
                                                        switch (i2) {
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
                                                                break;
                                                            default:
                                                                switch (i2) {
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
                                                                        break;
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
                                                                        break;
                                                                    default:
                                                                        throw new IllegalStateException("unexpected opcode: " + Hex.u2or4(i2));
                                                                }
                                                        }
                                                }
                                        }
                                }
                        }
                    }
                    this.currentPromotedAddress += 3;
                    return;
                }
            }
            this.currentPromotedAddress++;
            return;
        }
        this.currentPromotedAddress += 2;
    }

    @Override // com.tencent.tinker.android.dx.instruction.InstructionVisitor
    public void visitZeroRegisterInsn(int i, int i2, int i3, int i4, int i5, long j) {
        mapAddressIfNeeded(i);
        if (i2 == -1 || i2 == 0 || i2 == 14) {
            this.currentPromotedAddress++;
            return;
        }
        if (i2 != 36) {
            switch (i2) {
                case 40:
                    int target = InstructionCodec.getTarget(i5, this.currentPromotedAddress);
                    if (target == ((byte) target)) {
                        this.currentPromotedAddress++;
                        return;
                    } else if (target != ((short) target)) {
                        this.currentPromotedAddress += 3;
                        return;
                    } else {
                        this.currentPromotedAddress += 2;
                        return;
                    }
                case 41:
                    int target2 = InstructionCodec.getTarget(i5, this.currentPromotedAddress);
                    if (target2 != ((short) target2)) {
                        this.currentPromotedAddress += 3;
                        return;
                    } else {
                        this.currentPromotedAddress += 2;
                        return;
                    }
                case 42:
                    this.currentPromotedAddress += 3;
                    return;
                default:
                    switch (i2) {
                        case 110:
                        case 111:
                        case 112:
                        case 113:
                        case 114:
                            break;
                        default:
                            throw new IllegalStateException("unexpected opcode: " + Hex.u2or4(i2));
                    }
            }
        }
        this.currentPromotedAddress += 3;
    }
}
