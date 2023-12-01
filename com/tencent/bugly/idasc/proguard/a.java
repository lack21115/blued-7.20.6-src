package com.tencent.bugly.idasc.proguard;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.j256.ormlite.stmt.query.SimpleComparison;
import com.tencent.lbssearch.object.param.Geo2AddressParam;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/bugly/idasc/proguard/a.class */
public final class a {
    public static String a(ArrayList<String> arrayList) {
        StringBuilder sb;
        StringBuffer stringBuffer = new StringBuffer();
        int i = 0;
        while (true) {
            int i2 = i;
            String str = "map";
            if (i2 >= arrayList.size()) {
                Collections.reverse(arrayList);
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 >= arrayList.size()) {
                        break;
                    }
                    String str2 = arrayList.get(i4);
                    if (str2.equals("list")) {
                        int i5 = i4 - 1;
                        arrayList.set(i5, SimpleComparison.LESS_THAN_OPERATION + arrayList.get(i5));
                        sb = new StringBuilder();
                    } else if (str2.equals("map")) {
                        int i6 = i4 - 1;
                        arrayList.set(i6, SimpleComparison.LESS_THAN_OPERATION + arrayList.get(i6) + ",");
                        sb = new StringBuilder();
                    } else if (str2.equals("Array")) {
                        int i7 = i4 - 1;
                        arrayList.set(i7, SimpleComparison.LESS_THAN_OPERATION + arrayList.get(i7));
                        sb = new StringBuilder();
                    } else {
                        i3 = i4 + 1;
                    }
                    sb.append(arrayList.get(0));
                    sb.append(SimpleComparison.GREATER_THAN_OPERATION);
                    arrayList.set(0, sb.toString());
                    i3 = i4 + 1;
                }
                Collections.reverse(arrayList);
                Iterator<String> it = arrayList.iterator();
                while (it.hasNext()) {
                    stringBuffer.append(it.next());
                }
                return stringBuffer.toString();
            }
            String str3 = arrayList.get(i2);
            if (str3.equals("java.lang.Integer") || str3.equals(IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL)) {
                str = "int32";
            } else if (str3.equals("java.lang.Boolean") || str3.equals(TypedValues.Custom.S_BOOLEAN)) {
                str = "bool";
            } else if (str3.equals("java.lang.Byte") || str3.equals("byte")) {
                str = "char";
            } else if (str3.equals("java.lang.Double") || str3.equals("double")) {
                str = "double";
            } else if (str3.equals("java.lang.Float") || str3.equals(TypedValues.Custom.S_FLOAT)) {
                str = TypedValues.Custom.S_FLOAT;
            } else if (str3.equals("java.lang.Long") || str3.equals("long")) {
                str = "int64";
            } else if (str3.equals("java.lang.Short") || str3.equals(Geo2AddressParam.PoiOptions.ADDRESS_FORMAT_SHORT)) {
                str = Geo2AddressParam.PoiOptions.ADDRESS_FORMAT_SHORT;
            } else if (str3.equals("java.lang.Character")) {
                throw new IllegalArgumentException("can not support java.lang.Character");
            } else {
                if (str3.equals("java.lang.String")) {
                    str = "string";
                } else if (str3.equals("java.util.List")) {
                    str = "list";
                } else if (!str3.equals("java.util.Map")) {
                    str = str3;
                }
            }
            arrayList.set(i2, str);
            i = i2 + 1;
        }
    }
}
