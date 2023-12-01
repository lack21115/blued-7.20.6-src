package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.annotation.JSONType;
import com.alibaba.fastjson.util.FieldInfo;
import com.alibaba.fastjson.util.TypeUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: source-6737240-dex2jar.jar:com/alibaba/fastjson/serializer/JavaBeanSerializer.class */
public class JavaBeanSerializer implements ObjectSerializer {
    protected final Class<?> beanType;
    protected int features;
    private final FieldSerializer[] getters;
    protected final FieldSerializer[] sortedGetters;
    private static final char[] true_chars = {'t', 'r', 'u', 'e'};
    private static final char[] false_chars = {'f', 'a', 'l', 's', 'e'};

    public JavaBeanSerializer(Class<?> cls) {
        this(cls, (Map<String, String>) null);
    }

    public JavaBeanSerializer(Class<?> cls, Map<String, String> map) {
        this(cls, map, TypeUtils.getSerializeFeatures(cls));
    }

    public JavaBeanSerializer(Class<?> cls, Map<String, String> map, int i) {
        this.features = 0;
        this.features = i;
        this.beanType = cls;
        JSONType jSONType = (JSONType) cls.getAnnotation(JSONType.class);
        if (jSONType != null) {
            SerializerFeature.of(jSONType.serialzeFeatures());
        }
        ArrayList arrayList = new ArrayList();
        for (FieldInfo fieldInfo : TypeUtils.computeGetters(cls, jSONType, map, false)) {
            arrayList.add(new FieldSerializer(cls, fieldInfo));
        }
        this.getters = (FieldSerializer[]) arrayList.toArray(new FieldSerializer[arrayList.size()]);
        String[] orders = jSONType != null ? jSONType.orders() : null;
        if (orders != null && orders.length != 0) {
            List<FieldInfo> computeGetters = TypeUtils.computeGetters(cls, jSONType, map, true);
            ArrayList arrayList2 = new ArrayList();
            for (FieldInfo fieldInfo2 : computeGetters) {
                arrayList2.add(new FieldSerializer(cls, fieldInfo2));
            }
            this.sortedGetters = (FieldSerializer[]) arrayList2.toArray(new FieldSerializer[arrayList2.size()]);
            return;
        }
        FieldSerializer[] fieldSerializerArr = this.getters;
        FieldSerializer[] fieldSerializerArr2 = new FieldSerializer[fieldSerializerArr.length];
        System.arraycopy(fieldSerializerArr, 0, fieldSerializerArr2, 0, fieldSerializerArr.length);
        Arrays.sort(fieldSerializerArr2);
        if (Arrays.equals(fieldSerializerArr2, this.getters)) {
            this.sortedGetters = this.getters;
        } else {
            this.sortedGetters = fieldSerializerArr2;
        }
    }

    public JavaBeanSerializer(Class<?> cls, String... strArr) {
        this(cls, createAliasMap(strArr));
    }

    static Map<String, String> createAliasMap(String... strArr) {
        HashMap hashMap = new HashMap();
        int length = strArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return hashMap;
            }
            String str = strArr[i2];
            hashMap.put(str, str);
            i = i2 + 1;
        }
    }

    public FieldSerializer getFieldSerializer(String str) {
        if (str == null) {
            return null;
        }
        int i = 0;
        int length = this.sortedGetters.length - 1;
        while (i <= length) {
            int i2 = (i + length) >>> 1;
            int compareTo = this.sortedGetters[i2].fieldInfo.name.compareTo(str);
            if (compareTo < 0) {
                i = i2 + 1;
            } else if (compareTo <= 0) {
                return this.sortedGetters[i2];
            } else {
                length = i2 - 1;
            }
        }
        return null;
    }

    public List<Object> getFieldValues(Object obj) throws Exception {
        ArrayList arrayList = new ArrayList(this.sortedGetters.length);
        FieldSerializer[] fieldSerializerArr = this.sortedGetters;
        int length = fieldSerializerArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return arrayList;
            }
            arrayList.add(fieldSerializerArr[i2].getPropertyValue(obj));
            i = i2 + 1;
        }
    }

    public boolean isWriteAsArray(JSONSerializer jSONSerializer) {
        return (this.features & SerializerFeature.BeanToArray.mask) != 0 || jSONSerializer.out.beanToArray;
    }

    /* JADX WARN: Code restructure failed: missing block: B:161:0x03c4, code lost:
        if ((r31 instanceof java.lang.Boolean) != false) goto L172;
     */
    /* JADX WARN: Removed duplicated region for block: B:102:0x026d  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x02e8  */
    /* JADX WARN: Removed duplicated region for block: B:392:0x08ea  */
    /* JADX WARN: Removed duplicated region for block: B:436:0x0962 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01bb  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x01f0 A[Catch: all -> 0x07a8, Exception -> 0x07ac, TRY_ENTER, TryCatch #4 {Exception -> 0x07ac, all -> 0x07a8, blocks: (B:50:0x0131, B:54:0x0140, B:58:0x0169, B:63:0x017d, B:66:0x018a, B:68:0x0194, B:70:0x01a2, B:76:0x01c0, B:78:0x01cb, B:80:0x01d3, B:84:0x01f0, B:86:0x01f8, B:88:0x0200, B:104:0x0272, B:106:0x027a, B:107:0x0284, B:109:0x028c, B:110:0x0296, B:112:0x029e, B:113:0x02a8, B:115:0x02b3, B:117:0x02bb, B:119:0x02c8, B:129:0x02f7, B:131:0x02ff, B:132:0x0309, B:134:0x0311, B:135:0x031b, B:137:0x0323, B:138:0x032d, B:141:0x0346, B:143:0x0350, B:145:0x0371, B:147:0x0379, B:149:0x0381, B:150:0x038b, B:152:0x0393, B:153:0x039d, B:155:0x03a5, B:156:0x03af, B:160:0x03bf, B:163:0x03c9, B:171:0x03f1, B:173:0x03f9, B:174:0x0403, B:176:0x040b, B:178:0x041d, B:180:0x0425, B:181:0x042f, B:183:0x043c, B:185:0x0446, B:192:0x0492, B:194:0x049a, B:195:0x04a4, B:197:0x04ac, B:199:0x04c2, B:201:0x04ca, B:202:0x04d4, B:205:0x04e9, B:207:0x04f3, B:214:0x0520, B:216:0x0528, B:221:0x0538, B:223:0x0540, B:225:0x054f, B:227:0x0557, B:230:0x0565, B:232:0x056d, B:234:0x0575, B:237:0x0583, B:239:0x058b, B:241:0x0593, B:244:0x05a1, B:246:0x05a9, B:248:0x05b1, B:251:0x05c1, B:253:0x05c9, B:255:0x05d1, B:258:0x05e1, B:260:0x05e9, B:262:0x05f1, B:265:0x0601, B:267:0x0609, B:269:0x0611, B:274:0x0624, B:276:0x0633, B:281:0x0646, B:282:0x0651, B:287:0x0666, B:289:0x066d, B:294:0x067f, B:295:0x0693, B:300:0x06a3, B:302:0x06ab, B:303:0x06b7, B:305:0x06bf, B:306:0x06cb, B:310:0x06d8, B:311:0x06ea, B:318:0x070d, B:320:0x071c, B:323:0x072e, B:324:0x0736, B:325:0x0741, B:327:0x0750, B:328:0x075a, B:329:0x0765, B:330:0x0770, B:90:0x0211, B:92:0x0219, B:94:0x0236, B:96:0x023e, B:98:0x024f, B:99:0x025d, B:331:0x077b, B:333:0x0789, B:335:0x0791, B:337:0x079b), top: B:422:0x0131 }] */
    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void write(com.alibaba.fastjson.serializer.JSONSerializer r8, java.lang.Object r9, java.lang.Object r10, java.lang.reflect.Type r11, int r12) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 2437
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.serializer.JavaBeanSerializer.write(com.alibaba.fastjson.serializer.JSONSerializer, java.lang.Object, java.lang.Object, java.lang.reflect.Type, int):void");
    }

    public boolean writeReference(JSONSerializer jSONSerializer, Object obj, int i) {
        SerialContext serialContext = jSONSerializer.context;
        int i2 = SerializerFeature.DisableCircularReferenceDetect.mask;
        if ((serialContext == null || ((serialContext.features & i2) == 0 && (i & i2) == 0)) && jSONSerializer.references != null && jSONSerializer.references.containsKey(obj)) {
            jSONSerializer.writeReference(obj);
            return true;
        }
        return false;
    }
}
