package com.tencent.tinker.android.dx.instruction;

import com.tencent.tinker.android.dex.DexException;
import com.tencent.tinker.android.dx.util.Hex;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tinker/android/dx/instruction/InstructionWriter.class */
public final class InstructionWriter extends InstructionVisitor {
    private final ShortArrayCodeOutput codeOut;
    private final boolean hasPromoter;
    private final InstructionPromoter insnPromoter;

    public InstructionWriter(ShortArrayCodeOutput shortArrayCodeOutput, InstructionPromoter instructionPromoter) {
        super(null);
        this.codeOut = shortArrayCodeOutput;
        this.insnPromoter = instructionPromoter;
        this.hasPromoter = instructionPromoter != null;
    }

    @Override // com.tencent.tinker.android.dx.instruction.InstructionVisitor
    public void visitFillArrayDataPayloadInsn(int i, int i2, Object obj, int i3, int i4) {
        this.codeOut.write((short) i2);
        this.codeOut.write((short) i4);
        this.codeOut.writeInt(i3);
        if (i4 == 1) {
            this.codeOut.write((byte[]) obj);
        } else if (i4 == 2) {
            this.codeOut.write((short[]) obj);
        } else if (i4 == 4) {
            this.codeOut.write((int[]) obj);
        } else if (i4 == 8) {
            this.codeOut.write((long[]) obj);
        } else {
            throw new DexException("bogus element_width: " + Hex.u2(i4));
        }
    }

    @Override // com.tencent.tinker.android.dx.instruction.InstructionVisitor
    public void visitFiveRegisterInsn(int i, int i2, int i3, int i4, int i5, long j, int i6, int i7, int i8, int i9, int i10) {
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
        this.codeOut.write(InstructionCodec.codeUnit(i2, InstructionCodec.makeByte(i10, 5)), (short) i3, InstructionCodec.codeUnit(i6, i7, i8, i9));
    }

    @Override // com.tencent.tinker.android.dx.instruction.InstructionVisitor
    public void visitFourRegisterInsn(int i, int i2, int i3, int i4, int i5, long j, int i6, int i7, int i8, int i9) {
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
        this.codeOut.write(InstructionCodec.codeUnit(i2, InstructionCodec.makeByte(0, 4)), (short) i3, InstructionCodec.codeUnit(i6, i7, i8, i9));
    }

    @Override // com.tencent.tinker.android.dx.instruction.InstructionVisitor
    public void visitOneRegisterInsn(int i, int i2, int i3, int i4, int i5, long j, int i6) {
        int i7 = i5;
        if (this.hasPromoter) {
            i7 = this.insnPromoter.getPromotedAddress(i5);
        }
        if (i2 != 34) {
            if (i2 != 36) {
                if (i2 != 38) {
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
                                        case 29:
                                        case 30:
                                            break;
                                        case 18:
                                            this.codeOut.write(InstructionCodec.codeUnit((short) i2, InstructionCodec.makeByte(i6, InstructionCodec.getLiteralNibble(j))));
                                            return;
                                        case 19:
                                        case 22:
                                            this.codeOut.write(InstructionCodec.codeUnit(i2, i6), InstructionCodec.getLiteralUnit(j));
                                            return;
                                        case 20:
                                        case 23:
                                            int literalInt = InstructionCodec.getLiteralInt(j);
                                            this.codeOut.write(InstructionCodec.codeUnit(i2, i6), InstructionCodec.unit0(literalInt), InstructionCodec.unit1(literalInt));
                                            return;
                                        case 21:
                                        case 25:
                                            this.codeOut.write(InstructionCodec.codeUnit(i2, i6), (short) (j >> ((i2 == 21 ? (byte) 16 : (byte) 48) == 1 ? 1L : 0L)));
                                            return;
                                        case 24:
                                            this.codeOut.write(InstructionCodec.codeUnit(i2, i6), InstructionCodec.unit0(j), InstructionCodec.unit1(j), InstructionCodec.unit2(j), InstructionCodec.unit3(j));
                                            return;
                                        case 26:
                                            if (this.hasPromoter) {
                                                if (i3 > 65535) {
                                                    this.codeOut.write(InstructionCodec.codeUnit(27, i6), InstructionCodec.unit0(i3), InstructionCodec.unit1(i3));
                                                    return;
                                                } else {
                                                    this.codeOut.write(InstructionCodec.codeUnit(i2, i6), (short) i3);
                                                    return;
                                                }
                                            } else if (i3 <= 65535) {
                                                this.codeOut.write(InstructionCodec.codeUnit(i2, i6), (short) i3);
                                                return;
                                            } else {
                                                throw new DexException("string index out of bound: " + Hex.u4(i3) + ", perhaps you need to enable force jumbo mode.");
                                            }
                                        case 27:
                                            this.codeOut.write(InstructionCodec.codeUnit(i2, i6), InstructionCodec.unit0(i3), InstructionCodec.unit1(i3));
                                            return;
                                        case 28:
                                        case 31:
                                            break;
                                        default:
                                            switch (i2) {
                                                case 56:
                                                case 57:
                                                case 58:
                                                case 59:
                                                case 60:
                                                case 61:
                                                    this.codeOut.write(InstructionCodec.codeUnit(i2, i6), InstructionCodec.getTargetUnit(i7, this.codeOut.cursor()));
                                                    return;
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
                    this.codeOut.write(InstructionCodec.codeUnit(i2, i6));
                    return;
                }
                if (i2 == 43 || i2 == 44) {
                    ShortArrayCodeOutput shortArrayCodeOutput = this.codeOut;
                    shortArrayCodeOutput.setBaseAddress(i7, shortArrayCodeOutput.cursor());
                }
                int target = InstructionCodec.getTarget(i7, this.codeOut.cursor());
                this.codeOut.write(InstructionCodec.codeUnit(i2, i6), InstructionCodec.unit0(target), InstructionCodec.unit1(target));
                return;
            }
            this.codeOut.write(InstructionCodec.codeUnit(i2, InstructionCodec.makeByte(0, 1)), (short) i3, InstructionCodec.codeUnit(i6, 0, 0, 0));
            return;
        }
        this.codeOut.write(InstructionCodec.codeUnit(i2, i6), (short) i3);
    }

    @Override // com.tencent.tinker.android.dx.instruction.InstructionVisitor
    public void visitPackedSwitchPayloadInsn(int i, int i2, int i3, int[] iArr) {
        int baseAddressForCursor = this.codeOut.baseAddressForCursor();
        this.codeOut.write((short) i2);
        this.codeOut.write(InstructionCodec.asUnsignedUnit(iArr.length));
        this.codeOut.writeInt(i3);
        if (this.hasPromoter) {
            for (int i4 : iArr) {
                this.codeOut.writeInt(this.insnPromoter.getPromotedAddress(i4) - baseAddressForCursor);
            }
            return;
        }
        int length = iArr.length;
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 >= length) {
                return;
            }
            this.codeOut.writeInt(iArr[i6] - baseAddressForCursor);
            i5 = i6 + 1;
        }
    }

    @Override // com.tencent.tinker.android.dx.instruction.InstructionVisitor
    public void visitRegisterRangeInsn(int i, int i2, int i3, int i4, int i5, long j, int i6, int i7) {
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
        this.codeOut.write(InstructionCodec.codeUnit(i2, i7), (short) i3, InstructionCodec.getAUnit(i6));
    }

    @Override // com.tencent.tinker.android.dx.instruction.InstructionVisitor
    public void visitSparseSwitchPayloadInsn(int i, int i2, int[] iArr, int[] iArr2) {
        int baseAddressForCursor = this.codeOut.baseAddressForCursor();
        this.codeOut.write((short) i2);
        this.codeOut.write(InstructionCodec.asUnsignedUnit(iArr2.length));
        int length = iArr.length;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= length) {
                break;
            }
            this.codeOut.writeInt(iArr[i4]);
            i3 = i4 + 1;
        }
        if (this.hasPromoter) {
            int length2 = iArr2.length;
            int i5 = 0;
            while (true) {
                int i6 = i5;
                if (i6 >= length2) {
                    return;
                }
                this.codeOut.writeInt(this.insnPromoter.getPromotedAddress(iArr2[i6]) - baseAddressForCursor);
                i5 = i6 + 1;
            }
        } else {
            int length3 = iArr2.length;
            int i7 = 0;
            while (true) {
                int i8 = i7;
                if (i8 >= length3) {
                    return;
                }
                this.codeOut.writeInt(iArr2[i8] - baseAddressForCursor);
                i7 = i8 + 1;
            }
        }
    }

    @Override // com.tencent.tinker.android.dx.instruction.InstructionVisitor
    public void visitThreeRegisterInsn(int i, int i2, int i3, int i4, int i5, long j, int i6, int i7, int i8) {
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
            this.codeOut.write(InstructionCodec.codeUnit(i2, i6), InstructionCodec.codeUnit(i7, i8));
            return;
        }
        this.codeOut.write(InstructionCodec.codeUnit(i2, InstructionCodec.makeByte(0, 3)), (short) i3, InstructionCodec.codeUnit(i6, i7, i8, 0));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.tinker.android.dx.instruction.InstructionVisitor
    public void visitTwoRegisterInsn(int i, int i2, int i3, int i4, int i5, long j, int i6, int i7) {
        int i8 = i5;
        if (this.hasPromoter) {
            i8 = this.insnPromoter.getPromotedAddress(i5);
        }
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
                                this.codeOut.write(InstructionCodec.codeUnit(i2, i6), InstructionCodec.getBUnit(i7));
                                return;
                            case 3:
                            case 6:
                            case 9:
                                this.codeOut.write((short) i2, InstructionCodec.getAUnit(i6), InstructionCodec.getBUnit(i7));
                                return;
                            default:
                                switch (i2) {
                                    case 50:
                                    case 51:
                                    case 52:
                                    case 53:
                                    case 54:
                                    case 55:
                                        this.codeOut.write(InstructionCodec.codeUnit(i2, InstructionCodec.makeByte(i6, i7)), InstructionCodec.getTargetUnit(i8, this.codeOut.cursor()));
                                        return;
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
                                                                        this.codeOut.write(InstructionCodec.codeUnit(i2, InstructionCodec.makeByte(i6, i7)), InstructionCodec.getLiteralUnit(j));
                                                                        return;
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
                                                                        this.codeOut.write(InstructionCodec.codeUnit(i2, i6), InstructionCodec.codeUnit(i7, InstructionCodec.getLiteralByte(j)));
                                                                        return;
                                                                    default:
                                                                        throw new IllegalStateException("unexpected opcode: " + Hex.u2or4(i2));
                                                                }
                                                        }
                                                }
                                        }
                                }
                        }
                    }
                    this.codeOut.write(InstructionCodec.codeUnit(i2, InstructionCodec.makeByte(0, 2)), (short) i3, InstructionCodec.codeUnit(i6, i7, 0, 0));
                    return;
                }
            }
            this.codeOut.write(InstructionCodec.codeUnit((short) i2, InstructionCodec.makeByte(i6, i7)));
            return;
        }
        this.codeOut.write(InstructionCodec.codeUnit(i2, InstructionCodec.makeByte(i6, i7)), (short) i3);
    }

    @Override // com.tencent.tinker.android.dx.instruction.InstructionVisitor
    public void visitZeroRegisterInsn(int i, int i2, int i3, int i4, int i5, long j) {
        int i6 = i5;
        if (this.hasPromoter) {
            i6 = this.insnPromoter.getPromotedAddress(i5);
        }
        if (i2 == -1 || i2 == 0 || i2 == 14) {
            this.codeOut.write((short) i2);
            return;
        }
        if (i2 != 36) {
            switch (i2) {
                case 40:
                    if (!this.hasPromoter) {
                        this.codeOut.write(InstructionCodec.codeUnit(i2, InstructionCodec.getTargetByte(i6, this.codeOut.cursor())));
                        return;
                    }
                    int target = InstructionCodec.getTarget(i6, this.codeOut.cursor());
                    if (target == ((byte) target)) {
                        this.codeOut.write(InstructionCodec.codeUnit(i2, target & 255));
                        return;
                    }
                    short s = (short) target;
                    if (target != s) {
                        this.codeOut.write((short) 42, InstructionCodec.unit0(target), InstructionCodec.unit1(target));
                        return;
                    } else {
                        this.codeOut.write((short) 41, s);
                        return;
                    }
                case 41:
                    if (!this.hasPromoter) {
                        short targetUnit = InstructionCodec.getTargetUnit(i6, this.codeOut.cursor());
                        this.codeOut.write((short) i2, targetUnit);
                        return;
                    }
                    int target2 = InstructionCodec.getTarget(i6, this.codeOut.cursor());
                    short s2 = (short) target2;
                    if (target2 != s2) {
                        this.codeOut.write((short) 42, InstructionCodec.unit0(target2), InstructionCodec.unit1(target2));
                        return;
                    }
                    this.codeOut.write((short) i2, s2);
                    return;
                case 42:
                    int target3 = InstructionCodec.getTarget(i6, this.codeOut.cursor());
                    this.codeOut.write((short) i2, InstructionCodec.unit0(target3), InstructionCodec.unit1(target3));
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
        this.codeOut.write(InstructionCodec.codeUnit(i2, InstructionCodec.makeByte(0, 0)), (short) i3, InstructionCodec.codeUnit(0, 0, 0, 0));
    }
}
