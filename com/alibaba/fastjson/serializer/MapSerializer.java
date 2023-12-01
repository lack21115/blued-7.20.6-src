package com.alibaba.fastjson.serializer;

/* loaded from: source-6737240-dex2jar.jar:com/alibaba/fastjson/serializer/MapSerializer.class */
public class MapSerializer implements ObjectSerializer {
    public static MapSerializer instance = new MapSerializer();

    /* JADX WARN: Code restructure failed: missing block: B:102:0x0208, code lost:
        if (r0.size() > 0) goto L88;
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x022b, code lost:
        if ((r10 instanceof java.lang.Number) != false) goto L147;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x01b9, code lost:
        if ((r0 instanceof java.lang.Number) != false) goto L80;
     */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0255 A[Catch: all -> 0x0358, TRY_ENTER, TryCatch #0 {all -> 0x0358, blocks: (B:11:0x0033, B:13:0x0049, B:26:0x0079, B:28:0x0093, B:30:0x00a8, B:32:0x00b2, B:34:0x00d6, B:38:0x00e4, B:41:0x00ef, B:43:0x00fa, B:46:0x0103, B:49:0x0112, B:52:0x0122, B:54:0x012b, B:58:0x0139, B:61:0x0144, B:63:0x014f, B:66:0x0158, B:69:0x0169, B:72:0x017b, B:76:0x018c, B:80:0x019b, B:83:0x01a6, B:87:0x01b4, B:90:0x01bd, B:91:0x01cc, B:93:0x01da, B:95:0x01ea, B:105:0x020f, B:108:0x0219, B:112:0x0227, B:119:0x0255, B:122:0x0263, B:124:0x026a, B:126:0x0275, B:128:0x027e, B:130:0x0287, B:132:0x028d, B:150:0x02e2, B:152:0x02ed, B:155:0x02fb, B:157:0x030e, B:135:0x029b, B:137:0x02a4, B:139:0x02ad, B:141:0x02b8, B:144:0x02c6, B:147:0x02d8, B:145:0x02ce, B:115:0x022f, B:116:0x023f, B:101:0x0201, B:20:0x0061), top: B:173:0x0033 }] */
    /* JADX WARN: Removed duplicated region for block: B:124:0x026a A[Catch: all -> 0x0358, TRY_LEAVE, TryCatch #0 {all -> 0x0358, blocks: (B:11:0x0033, B:13:0x0049, B:26:0x0079, B:28:0x0093, B:30:0x00a8, B:32:0x00b2, B:34:0x00d6, B:38:0x00e4, B:41:0x00ef, B:43:0x00fa, B:46:0x0103, B:49:0x0112, B:52:0x0122, B:54:0x012b, B:58:0x0139, B:61:0x0144, B:63:0x014f, B:66:0x0158, B:69:0x0169, B:72:0x017b, B:76:0x018c, B:80:0x019b, B:83:0x01a6, B:87:0x01b4, B:90:0x01bd, B:91:0x01cc, B:93:0x01da, B:95:0x01ea, B:105:0x020f, B:108:0x0219, B:112:0x0227, B:119:0x0255, B:122:0x0263, B:124:0x026a, B:126:0x0275, B:128:0x027e, B:130:0x0287, B:132:0x028d, B:150:0x02e2, B:152:0x02ed, B:155:0x02fb, B:157:0x030e, B:135:0x029b, B:137:0x02a4, B:139:0x02ad, B:141:0x02b8, B:144:0x02c6, B:147:0x02d8, B:145:0x02ce, B:115:0x022f, B:116:0x023f, B:101:0x0201, B:20:0x0061), top: B:173:0x0033 }] */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0296  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x02e2 A[Catch: all -> 0x0358, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x0358, blocks: (B:11:0x0033, B:13:0x0049, B:26:0x0079, B:28:0x0093, B:30:0x00a8, B:32:0x00b2, B:34:0x00d6, B:38:0x00e4, B:41:0x00ef, B:43:0x00fa, B:46:0x0103, B:49:0x0112, B:52:0x0122, B:54:0x012b, B:58:0x0139, B:61:0x0144, B:63:0x014f, B:66:0x0158, B:69:0x0169, B:72:0x017b, B:76:0x018c, B:80:0x019b, B:83:0x01a6, B:87:0x01b4, B:90:0x01bd, B:91:0x01cc, B:93:0x01da, B:95:0x01ea, B:105:0x020f, B:108:0x0219, B:112:0x0227, B:119:0x0255, B:122:0x0263, B:124:0x026a, B:126:0x0275, B:128:0x027e, B:130:0x0287, B:132:0x028d, B:150:0x02e2, B:152:0x02ed, B:155:0x02fb, B:157:0x030e, B:135:0x029b, B:137:0x02a4, B:139:0x02ad, B:141:0x02b8, B:144:0x02c6, B:147:0x02d8, B:145:0x02ce, B:115:0x022f, B:116:0x023f, B:101:0x0201, B:20:0x0061), top: B:173:0x0033 }] */
    /* JADX WARN: Removed duplicated region for block: B:152:0x02ed A[Catch: all -> 0x0358, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x0358, blocks: (B:11:0x0033, B:13:0x0049, B:26:0x0079, B:28:0x0093, B:30:0x00a8, B:32:0x00b2, B:34:0x00d6, B:38:0x00e4, B:41:0x00ef, B:43:0x00fa, B:46:0x0103, B:49:0x0112, B:52:0x0122, B:54:0x012b, B:58:0x0139, B:61:0x0144, B:63:0x014f, B:66:0x0158, B:69:0x0169, B:72:0x017b, B:76:0x018c, B:80:0x019b, B:83:0x01a6, B:87:0x01b4, B:90:0x01bd, B:91:0x01cc, B:93:0x01da, B:95:0x01ea, B:105:0x020f, B:108:0x0219, B:112:0x0227, B:119:0x0255, B:122:0x0263, B:124:0x026a, B:126:0x0275, B:128:0x027e, B:130:0x0287, B:132:0x028d, B:150:0x02e2, B:152:0x02ed, B:155:0x02fb, B:157:0x030e, B:135:0x029b, B:137:0x02a4, B:139:0x02ad, B:141:0x02b8, B:144:0x02c6, B:147:0x02d8, B:145:0x02ce, B:115:0x022f, B:116:0x023f, B:101:0x0201, B:20:0x0061), top: B:173:0x0033 }] */
    /* JADX WARN: Removed duplicated region for block: B:190:0x0263 A[ADDED_TO_REGION, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00b2 A[Catch: all -> 0x0358, TRY_LEAVE, TryCatch #0 {all -> 0x0358, blocks: (B:11:0x0033, B:13:0x0049, B:26:0x0079, B:28:0x0093, B:30:0x00a8, B:32:0x00b2, B:34:0x00d6, B:38:0x00e4, B:41:0x00ef, B:43:0x00fa, B:46:0x0103, B:49:0x0112, B:52:0x0122, B:54:0x012b, B:58:0x0139, B:61:0x0144, B:63:0x014f, B:66:0x0158, B:69:0x0169, B:72:0x017b, B:76:0x018c, B:80:0x019b, B:83:0x01a6, B:87:0x01b4, B:90:0x01bd, B:91:0x01cc, B:93:0x01da, B:95:0x01ea, B:105:0x020f, B:108:0x0219, B:112:0x0227, B:119:0x0255, B:122:0x0263, B:124:0x026a, B:126:0x0275, B:128:0x027e, B:130:0x0287, B:132:0x028d, B:150:0x02e2, B:152:0x02ed, B:155:0x02fb, B:157:0x030e, B:135:0x029b, B:137:0x02a4, B:139:0x02ad, B:141:0x02b8, B:144:0x02c6, B:147:0x02d8, B:145:0x02ce, B:115:0x022f, B:116:0x023f, B:101:0x0201, B:20:0x0061), top: B:173:0x0033 }] */
    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void write(com.alibaba.fastjson.serializer.JSONSerializer r8, java.lang.Object r9, java.lang.Object r10, java.lang.reflect.Type r11, int r12) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 889
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.serializer.MapSerializer.write(com.alibaba.fastjson.serializer.JSONSerializer, java.lang.Object, java.lang.Object, java.lang.reflect.Type, int):void");
    }
}
