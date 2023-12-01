package com.blued.track.utils;

import com.google.protobuf.Descriptors;
import java.io.IOException;
import java.util.regex.Pattern;

/* loaded from: source-7206380-dex2jar.jar:com/blued/track/utils/Proto2JsonUtils.class */
public class Proto2JsonUtils {

    /* renamed from: a  reason: collision with root package name */
    private static final Pattern f20627a = Pattern.compile("[0-9]", 2);

    /* renamed from: com.blued.track.utils.Proto2JsonUtils$1  reason: invalid class name */
    /* loaded from: source-7206380-dex2jar.jar:com/blued/track/utils/Proto2JsonUtils$1.class */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f20628a;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:39:0x00dd -> B:109:0x0014). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:41:0x00e1 -> B:103:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:43:0x00e5 -> B:81:0x002a). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:45:0x00e9 -> B:77:0x0035). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:47:0x00ed -> B:89:0x0040). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:49:0x00f1 -> B:85:0x004c). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:51:0x00f5 -> B:99:0x0058). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:53:0x00f9 -> B:93:0x0064). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:55:0x00fd -> B:107:0x0070). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:57:0x0101 -> B:101:0x007c). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:59:0x0105 -> B:79:0x0088). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:61:0x0109 -> B:75:0x0094). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:63:0x010d -> B:87:0x00a0). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:65:0x0111 -> B:83:0x00ac). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:67:0x0115 -> B:97:0x00b8). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:69:0x0119 -> B:91:0x00c4). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:71:0x011d -> B:105:0x00d0). Please submit an issue!!! */
        static {
            int[] iArr = new int[Descriptors.FieldDescriptor.Type.values().length];
            f20628a = iArr;
            try {
                iArr[Descriptors.FieldDescriptor.Type.INT32.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f20628a[Descriptors.FieldDescriptor.Type.INT64.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f20628a[Descriptors.FieldDescriptor.Type.SINT32.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f20628a[Descriptors.FieldDescriptor.Type.SINT64.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f20628a[Descriptors.FieldDescriptor.Type.SFIXED32.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f20628a[Descriptors.FieldDescriptor.Type.SFIXED64.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f20628a[Descriptors.FieldDescriptor.Type.FLOAT.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                f20628a[Descriptors.FieldDescriptor.Type.DOUBLE.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                f20628a[Descriptors.FieldDescriptor.Type.BOOL.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
            try {
                f20628a[Descriptors.FieldDescriptor.Type.UINT32.ordinal()] = 10;
            } catch (NoSuchFieldError e10) {
            }
            try {
                f20628a[Descriptors.FieldDescriptor.Type.FIXED32.ordinal()] = 11;
            } catch (NoSuchFieldError e11) {
            }
            try {
                f20628a[Descriptors.FieldDescriptor.Type.UINT64.ordinal()] = 12;
            } catch (NoSuchFieldError e12) {
            }
            try {
                f20628a[Descriptors.FieldDescriptor.Type.FIXED64.ordinal()] = 13;
            } catch (NoSuchFieldError e13) {
            }
            try {
                f20628a[Descriptors.FieldDescriptor.Type.STRING.ordinal()] = 14;
            } catch (NoSuchFieldError e14) {
            }
            try {
                f20628a[Descriptors.FieldDescriptor.Type.BYTES.ordinal()] = 15;
            } catch (NoSuchFieldError e15) {
            }
            try {
                f20628a[Descriptors.FieldDescriptor.Type.ENUM.ordinal()] = 16;
            } catch (NoSuchFieldError e16) {
            }
            try {
                f20628a[Descriptors.FieldDescriptor.Type.MESSAGE.ordinal()] = 17;
            } catch (NoSuchFieldError e17) {
            }
            try {
                f20628a[Descriptors.FieldDescriptor.Type.GROUP.ordinal()] = 18;
            } catch (NoSuchFieldError e18) {
            }
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/track/utils/Proto2JsonUtils$InvalidEscapeSequence.class */
    static class InvalidEscapeSequence extends IOException {
        private static final long serialVersionUID = 1;
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/track/utils/Proto2JsonUtils$JsonGenerator.class */
    public static class JsonGenerator {
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/track/utils/Proto2JsonUtils$ParseException.class */
    public static class ParseException extends IOException {
        private static final long serialVersionUID = 1;
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/track/utils/Proto2JsonUtils$Tokenizer.class */
    public static class Tokenizer {

        /* renamed from: a  reason: collision with root package name */
        private static final Pattern f20629a = Pattern.compile("(\\s|(#.*$))++", 8);
        private static final Pattern b = Pattern.compile("[a-zA-Z_][0-9a-zA-Z_+-]*+|[.]?[0-9+-][0-9a-zA-Z_.+-]*+|\"([^\"\n\\\\]|\\\\.)*+(\"|\\\\?$)|'([^'\n\\\\]|\\\\.)*+('|\\\\?$)", 8);

        /* renamed from: c  reason: collision with root package name */
        private static final Pattern f20630c = Pattern.compile("-?inf(inity)?", 2);
        private static final Pattern d = Pattern.compile("-?inf(inity)?f?", 2);
        private static final Pattern e = Pattern.compile("nanf?", 2);
    }
}
