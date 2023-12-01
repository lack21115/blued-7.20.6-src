package com.alibaba.fastjson.serializer;

/* loaded from: source-6737240-dex2jar.jar:com/alibaba/fastjson/serializer/PascalNameFilter.class */
public class PascalNameFilter implements NameFilter {
    @Override // com.alibaba.fastjson.serializer.NameFilter
    public String process(Object obj, String str, Object obj2) {
        String str2 = str;
        if (str != null) {
            if (str.length() == 0) {
                return str;
            }
            char[] charArray = str.toCharArray();
            charArray[0] = Character.toUpperCase(charArray[0]);
            str2 = new String(charArray);
        }
        return str2;
    }
}
