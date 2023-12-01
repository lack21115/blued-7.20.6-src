package com.mokee.security;

/* loaded from: source-4181928-dex2jar.jar:com/mokee/security/Encryption.class */
public class Encryption {
    private static final String[] a = null;
    public static int b;

    static {
        String[] strArr = new String[8];
        throw new VerifyError("bad dex opcode");
    }

    public static void appendHex(StringBuffer stringBuffer, byte b2) {
        stringBuffer.append(a[0].charAt((b2 >> 4) & 15)).append(a[1].charAt(b2 & 15));
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:56)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:30)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:18)
        */
    /* JADX WARN: Removed duplicated region for block: B:10:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00a7  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x008b -> B:14:0x00a0). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static byte[] decryptByPrivateKey(byte[] r6) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 202
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mokee.security.Encryption.decryptByPrivateKey(byte[]):byte[]");
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:56)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:30)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:18)
        */
    /* JADX WARN: Removed duplicated region for block: B:13:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0055  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x0088 -> B:5:0x004b). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static byte[] decryptByPublicKey(byte[] r6, java.lang.String r7) throws java.lang.Exception {
        /*
            int r0 = com.mokee.security.Encryption.b
            r10 = r0
            java.security.spec.X509EncodedKeySpec r0 = new java.security.spec.X509EncodedKeySpec
            r1 = r0
            r2 = r7
            r3 = 0
            byte[] r2 = android.util.Base64.decode(r2, r3)
            r1.<init>(r2)
            r12 = r0
            java.lang.String[] r0 = com.mokee.security.Encryption.a
            r1 = 5
            r0 = r0[r1]
            java.security.KeyFactory r0 = java.security.KeyFactory.getInstance(r0)
            r7 = r0
            r0 = r7
            r1 = r12
            java.security.PublicKey r0 = r0.generatePublic(r1)
            r13 = r0
            r0 = r7
            java.lang.String r0 = r0.getAlgorithm()
            javax.crypto.Cipher r0 = javax.crypto.Cipher.getInstance(r0)
            r12 = r0
            r0 = r12
            r1 = 2
            r2 = r13
            r0.init(r1, r2)
            r0 = r6
            int r0 = r0.length
            r11 = r0
            java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream
            r1 = r0
            r1.<init>()
            r13 = r0
            r0 = r10
            if (r0 == 0) goto L9b
            r0 = 0
            r8 = r0
            r0 = 0
            r9 = r0
        L4b:
            r0 = r11
            r1 = r9
            int r0 = r0 - r1
            r1 = 128(0x80, float:1.794E-43)
            if (r0 <= r1) goto L65
            r0 = r12
            r1 = r6
            r2 = r9
            r3 = 128(0x80, float:1.794E-43)
            byte[] r0 = r0.doFinal(r1, r2, r3)
            r7 = r0
            r0 = r10
            if (r0 == 0) goto L71
        L65:
            r0 = r12
            r1 = r6
            r2 = r9
            r3 = r11
            r4 = r9
            int r3 = r3 - r4
            byte[] r0 = r0.doFinal(r1, r2, r3)
            r7 = r0
        L71:
            r0 = r13
            r1 = r7
            r2 = 0
            r3 = r7
            int r3 = r3.length
            r0.write(r1, r2, r3)
            r0 = r8
            r1 = 1
            int r0 = r0 + r1
            r8 = r0
            r0 = r8
            r1 = 128(0x80, float:1.794E-43)
            int r0 = r0 * r1
            r9 = r0
        L84:
            r0 = r11
            r1 = r9
            int r0 = r0 - r1
            if (r0 > 0) goto L98
            r0 = r13
            byte[] r0 = r0.toByteArray()
            r6 = r0
            r0 = r13
            r0.close()
            r0 = r6
            return r0
        L98:
            goto L4b
        L9b:
            r0 = 0
            r8 = r0
            r0 = 0
            r9 = r0
            goto L84
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mokee.security.Encryption.decryptByPublicKey(byte[], java.lang.String):byte[]");
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:56)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:30)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:18)
        */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0059  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x008d -> B:5:0x0050). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static byte[] encryptByPrivateKey(byte[] r6) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 182
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mokee.security.Encryption.encryptByPrivateKey(byte[]):byte[]");
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:56)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:30)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:18)
        */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0054  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x0085 -> B:5:0x004b). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static byte[] encryptByPublicKey(byte[] r6, java.lang.String r7) throws java.lang.Exception {
        /*
            int r0 = com.mokee.security.Encryption.b
            r10 = r0
            java.security.spec.X509EncodedKeySpec r0 = new java.security.spec.X509EncodedKeySpec
            r1 = r0
            r2 = r7
            r3 = 0
            byte[] r2 = android.util.Base64.decode(r2, r3)
            r1.<init>(r2)
            r12 = r0
            java.lang.String[] r0 = com.mokee.security.Encryption.a
            r1 = 4
            r0 = r0[r1]
            java.security.KeyFactory r0 = java.security.KeyFactory.getInstance(r0)
            r7 = r0
            r0 = r7
            r1 = r12
            java.security.PublicKey r0 = r0.generatePublic(r1)
            r13 = r0
            r0 = r7
            java.lang.String r0 = r0.getAlgorithm()
            javax.crypto.Cipher r0 = javax.crypto.Cipher.getInstance(r0)
            r12 = r0
            r0 = r12
            r1 = 1
            r2 = r13
            r0.init(r1, r2)
            r0 = r6
            int r0 = r0.length
            r11 = r0
            java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream
            r1 = r0
            r1.<init>()
            r13 = r0
            r0 = r10
            if (r0 == 0) goto L98
            r0 = 0
            r8 = r0
            r0 = 0
            r9 = r0
        L4b:
            r0 = r11
            r1 = r9
            int r0 = r0 - r1
            r1 = 117(0x75, float:1.64E-43)
            if (r0 <= r1) goto L63
            r0 = r12
            r1 = r6
            r2 = r9
            r3 = 117(0x75, float:1.64E-43)
            byte[] r0 = r0.doFinal(r1, r2, r3)
            r7 = r0
            r0 = r10
            if (r0 == 0) goto L6f
        L63:
            r0 = r12
            r1 = r6
            r2 = r9
            r3 = r11
            r4 = r9
            int r3 = r3 - r4
            byte[] r0 = r0.doFinal(r1, r2, r3)
            r7 = r0
        L6f:
            r0 = r13
            r1 = r7
            r2 = 0
            r3 = r7
            int r3 = r3.length
            r0.write(r1, r2, r3)
            r0 = r8
            r1 = 1
            int r0 = r0 + r1
            r8 = r0
            r0 = r8
            r1 = 117(0x75, float:1.64E-43)
            int r0 = r0 * r1
            r9 = r0
        L81:
            r0 = r11
            r1 = r9
            int r0 = r0 - r1
            if (r0 > 0) goto L95
            r0 = r13
            byte[] r0 = r0.toByteArray()
            r6 = r0
            r0 = r13
            r0.close()
            r0 = r6
            return r0
        L95:
            goto L4b
        L98:
            r0 = 0
            r8 = r0
            r0 = 0
            r9 = r0
            goto L81
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mokee.security.Encryption.encryptByPublicKey(byte[], java.lang.String):byte[]");
    }

    public static byte[] toByte(String str) {
        int i = b;
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        int i2 = 0;
        if (i != 0) {
            bArr[0] = Integer.valueOf(str.substring(0 * 2, (0 * 2) + 2), 16).byteValue();
            i2 = 0 + 1;
        }
        while (true) {
            int i3 = i2;
            if (i2 >= length) {
                return bArr;
            }
            bArr[i3] = Integer.valueOf(str.substring(i3 * 2, (i3 * 2) + 2), 16).byteValue();
            i2 = i3 + 1;
        }
    }

    public static String toHex(byte[] bArr) {
        int i = b;
        if (bArr == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer(bArr.length * 2);
        int i2 = 0;
        if (i != 0) {
            appendHex(stringBuffer, bArr[0]);
            i2 = 0 + 1;
        }
        while (true) {
            int i3 = i2;
            if (i2 >= bArr.length) {
                return stringBuffer.toString();
            }
            appendHex(stringBuffer, bArr[i3]);
            i2 = i3 + 1;
        }
    }
}
