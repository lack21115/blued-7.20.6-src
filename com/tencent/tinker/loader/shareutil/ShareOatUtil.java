package com.tencent.tinker.loader.shareutil;

import com.bun.miitmdid.core.Utils;
import com.tencent.tinker.loader.shareutil.ShareElfFile;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tinker/loader/shareutil/ShareOatUtil.class */
public final class ShareOatUtil {
    private static final String TAG = "Tinker.OatUtil";

    /* renamed from: com.tencent.tinker.loader.shareutil.ShareOatUtil$1  reason: invalid class name */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/tinker/loader/shareutil/ShareOatUtil$1.class */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$tencent$tinker$loader$shareutil$ShareOatUtil$InstructionSet;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0065 -> B:41:0x0014). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0069 -> B:37:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x006d -> B:49:0x002a). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0071 -> B:43:0x0035). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x0075 -> B:39:0x0040). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x0079 -> B:35:0x004c). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x007d -> B:47:0x0058). Please submit an issue!!! */
        static {
            int[] iArr = new int[InstructionSet.values().length];
            $SwitchMap$com$tencent$tinker$loader$shareutil$ShareOatUtil$InstructionSet = iArr;
            try {
                iArr[InstructionSet.kArm.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$com$tencent$tinker$loader$shareutil$ShareOatUtil$InstructionSet[InstructionSet.kThumb2.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$com$tencent$tinker$loader$shareutil$ShareOatUtil$InstructionSet[InstructionSet.kArm64.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$com$tencent$tinker$loader$shareutil$ShareOatUtil$InstructionSet[InstructionSet.kX86.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$com$tencent$tinker$loader$shareutil$ShareOatUtil$InstructionSet[InstructionSet.kX86_64.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                $SwitchMap$com$tencent$tinker$loader$shareutil$ShareOatUtil$InstructionSet[InstructionSet.kMips.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                $SwitchMap$com$tencent$tinker$loader$shareutil$ShareOatUtil$InstructionSet[InstructionSet.kMips64.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                $SwitchMap$com$tencent$tinker$loader$shareutil$ShareOatUtil$InstructionSet[InstructionSet.kNone.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/tinker/loader/shareutil/ShareOatUtil$InstructionSet.class */
    enum InstructionSet {
        kNone,
        kArm,
        kArm64,
        kThumb2,
        kX86,
        kX86_64,
        kMips,
        kMips64
    }

    private ShareOatUtil() {
        throw new UnsupportedOperationException();
    }

    public static String getOatFileInstructionSet(File file) throws Throwable {
        ShareElfFile shareElfFile;
        String str;
        try {
            shareElfFile = new ShareElfFile(file);
        } catch (Throwable th) {
            th = th;
            shareElfFile = null;
        }
        try {
            ShareElfFile.SectionHeader sectionHeaderByName = shareElfFile.getSectionHeaderByName(".rodata");
            if (sectionHeaderByName != null) {
                FileChannel channel = shareElfFile.getChannel();
                channel.position(sectionHeaderByName.shOffset);
                byte[] bArr = new byte[8];
                ShareElfFile.readUntilLimit(channel, ByteBuffer.wrap(bArr), "Failed to read oat magic and version.");
                if (bArr[0] == 111 && bArr[1] == 97 && bArr[2] == 116 && bArr[3] == 10) {
                    String str2 = new String(bArr, 4, 3, Charset.forName("ASCII"));
                    try {
                        Integer.parseInt(str2);
                        ByteBuffer allocate = ByteBuffer.allocate(128);
                        allocate.order(shareElfFile.getDataOrder());
                        channel.position(sectionHeaderByName.shOffset + 12);
                        allocate.limit(4);
                        ShareElfFile.readUntilLimit(channel, allocate, "Failed to read isa num.");
                        int i = allocate.getInt();
                        if (i < 0 || i >= InstructionSet.values().length) {
                            throw new IOException("Bad isa num: " + i);
                        }
                        switch (AnonymousClass1.$SwitchMap$com$tencent$tinker$loader$shareutil$ShareOatUtil$InstructionSet[InstructionSet.values()[i].ordinal()]) {
                            case 1:
                            case 2:
                                str = "arm";
                                break;
                            case 3:
                                str = "arm64";
                                break;
                            case 4:
                                str = Utils.CPU_ABI_X86;
                                break;
                            case 5:
                                str = "x86_64";
                                break;
                            case 6:
                                str = "mips";
                                break;
                            case 7:
                                str = "mips64";
                                break;
                            case 8:
                                str = "none";
                                break;
                            default:
                                throw new IOException("Should not reach here.");
                        }
                        try {
                            shareElfFile.close();
                            return str;
                        } catch (Exception e) {
                            return str;
                        }
                    } catch (NumberFormatException e2) {
                        throw new IOException("Bad oat version: " + str2);
                    }
                }
                throw new IOException(String.format("Bad oat magic: %x %x %x %x", Byte.valueOf(bArr[0]), Byte.valueOf(bArr[1]), Byte.valueOf(bArr[2]), Byte.valueOf(bArr[3])));
            }
            throw new IOException("Unable to find .rodata section.");
        } catch (Throwable th2) {
            th = th2;
            if (shareElfFile != null) {
                try {
                    shareElfFile.close();
                } catch (Exception e3) {
                }
            }
            throw th;
        }
    }
}
