package com.blued.android.chat.grpc.utils;

import android.text.TextUtils;
import com.blued.android.chat.grpc.PrivateChatManager;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.util.JsonFormat;
import java.io.UnsupportedEncodingException;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/grpc/utils/ProtobufUtils.class */
public class ProtobufUtils {
    private static int digitValue(char c) {
        if ('0' > c || c > '9') {
            return (('a' > c || c > 'z') ? c - 'A' : c - 'a') + 10;
        }
        return c - '0';
    }

    private static boolean isHex(char c) {
        if ('0' > c || c > '9') {
            if ('a' > c || c > 'f') {
                return 'A' <= c && c <= 'F';
            }
            return true;
        }
        return true;
    }

    private static boolean isOctal(char c) {
        return '0' <= c && c <= '7';
    }

    public static <T> T json2pb(String str, Message.Builder builder) throws InvalidProtocolBufferException {
        if (builder == null) {
            return null;
        }
        String str2 = str;
        if (TextUtils.isEmpty(str)) {
            str2 = "{}";
        }
        JsonFormat.parser().ignoringUnknownFields().merge(str2, builder);
        return (T) builder.build();
    }

    public static <T> T object2pb(Object obj, Message.Builder builder) throws InvalidProtocolBufferException {
        if (builder == null || obj == null) {
            return null;
        }
        return (T) json2pb(PrivateChatManager.getInstance().getGson().toJson(obj), builder);
    }

    public static String protoToJson(Message message) throws InvalidProtocolBufferException {
        return JsonFormat.printer().preservingProtoFieldNames().print(message);
    }

    public static String toUTF8String(Message message) throws RuntimeException, UnsupportedEncodingException {
        int i;
        int i2;
        int i3;
        String message2 = message.toString();
        byte[] bArr = new byte[message2.length()];
        int i4 = 0;
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i4 >= message2.length()) {
                return new String(bArr, 0, i6, "UTF-8");
            }
            char charAt = message2.charAt(i4);
            if (charAt == '\\') {
                i2 = i4 + 1;
                if (i2 >= message2.length()) {
                    throw new RuntimeException("Invalid escape sequence: '\\' at end of string.");
                }
                char charAt2 = message2.charAt(i2);
                if (isOctal(charAt2)) {
                    int digitValue = digitValue(charAt2);
                    int i7 = i2 + 1;
                    int i8 = i2;
                    int i9 = digitValue;
                    if (i7 < message2.length()) {
                        i8 = i2;
                        i9 = digitValue;
                        if (isOctal(message2.charAt(i7))) {
                            i9 = (digitValue * 8) + digitValue(message2.charAt(i7));
                            i8 = i7;
                        }
                    }
                    int i10 = i8 + 1;
                    int i11 = i8;
                    int i12 = i9;
                    if (i10 < message2.length()) {
                        i11 = i8;
                        i12 = i9;
                        if (isOctal(message2.charAt(i10))) {
                            i12 = (i9 * 8) + digitValue(message2.charAt(i10));
                            i11 = i10;
                        }
                    }
                    i = i6 + 1;
                    bArr[i6] = (byte) i12;
                    i4 = i11;
                } else {
                    if (charAt2 == '\"') {
                        i3 = i6 + 1;
                        bArr[i6] = 34;
                    } else if (charAt2 == '\'') {
                        i3 = i6 + 1;
                        bArr[i6] = 39;
                    } else if (charAt2 == '\\') {
                        i3 = i6 + 1;
                        bArr[i6] = 92;
                    } else if (charAt2 == 'f') {
                        i3 = i6 + 1;
                        bArr[i6] = 12;
                    } else if (charAt2 == 'n') {
                        i3 = i6 + 1;
                        bArr[i6] = 10;
                    } else if (charAt2 == 'r') {
                        i3 = i6 + 1;
                        bArr[i6] = 13;
                    } else if (charAt2 == 't') {
                        i3 = i6 + 1;
                        bArr[i6] = 9;
                    } else if (charAt2 == 'v') {
                        i3 = i6 + 1;
                        bArr[i6] = 11;
                    } else if (charAt2 == 'x') {
                        int i13 = i2 + 1;
                        if (i13 >= message2.length() || !isHex(message2.charAt(i13))) {
                            break;
                        }
                        int digitValue2 = digitValue(message2.charAt(i13));
                        int i14 = i13 + 1;
                        i4 = i13;
                        int i15 = digitValue2;
                        if (i14 < message2.length()) {
                            i4 = i13;
                            i15 = digitValue2;
                            if (isHex(message2.charAt(i14))) {
                                i15 = (digitValue2 * 16) + digitValue(message2.charAt(i14));
                                i4 = i14;
                            }
                        }
                        bArr[i6] = (byte) i15;
                        i = i6 + 1;
                    } else if (charAt2 == 'a') {
                        i3 = i6 + 1;
                        bArr[i6] = 7;
                    } else if (charAt2 != 'b') {
                        throw new RuntimeException("Invalid escape sequence: '\\" + charAt2 + "'");
                    } else {
                        i3 = i6 + 1;
                        bArr[i6] = 8;
                    }
                    i = i3;
                    i4 = i2 + 1;
                    i5 = i;
                }
            } else {
                i = i6 + 1;
                bArr[i6] = (byte) charAt;
            }
            i2 = i4;
            i4 = i2 + 1;
            i5 = i;
        }
        throw new RuntimeException("Invalid escape sequence: '\\x' with no digits");
    }
}
