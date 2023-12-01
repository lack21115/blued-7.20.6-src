package com.alibaba.mtl.appmonitor.model;

import com.alibaba.mtl.appmonitor.c.a;
import com.alibaba.mtl.log.model.LogField;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* loaded from: source-6737240-dex2jar.jar:com/alibaba/mtl/appmonitor/model/UTDimensionValueSet.class */
public class UTDimensionValueSet extends DimensionValueSet {

    /* renamed from: a  reason: collision with root package name */
    private static final Set<LogField> f4475a = new HashSet<LogField>() { // from class: com.alibaba.mtl.appmonitor.model.UTDimensionValueSet.1
        {
            add(LogField.PAGE);
            add(LogField.ARG1);
            add(LogField.ARG2);
            add(LogField.ARG3);
            add(LogField.ARGS);
        }
    };

    public static UTDimensionValueSet create(Map<String, String> map) {
        return (UTDimensionValueSet) a.a().a(UTDimensionValueSet.class, map);
    }

    @Override // com.alibaba.mtl.appmonitor.model.DimensionValueSet, com.alibaba.mtl.appmonitor.c.b
    public void clean() {
        super.clean();
    }

    @Override // com.alibaba.mtl.appmonitor.model.DimensionValueSet, com.alibaba.mtl.appmonitor.c.b
    public void fill(Object... objArr) {
        super.fill(objArr);
    }

    public Integer getEventId() {
        int i;
        String str;
        if (this.map != null && (str = this.map.get(LogField.EVENTID.toString())) != null) {
            try {
                i = com.alibaba.mtl.appmonitor.f.a.a(str);
            } catch (NumberFormatException e) {
            }
            return Integer.valueOf(i);
        }
        i = 0;
        return Integer.valueOf(i);
    }
}
