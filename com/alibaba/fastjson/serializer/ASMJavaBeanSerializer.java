package com.alibaba.fastjson.serializer;

/* loaded from: source-6737240-dex2jar.jar:com/alibaba/fastjson/serializer/ASMJavaBeanSerializer.class */
public abstract class ASMJavaBeanSerializer implements ObjectSerializer {
    protected JavaBeanSerializer nature;

    public ASMJavaBeanSerializer(Class<?> cls) {
        this.nature = new JavaBeanSerializer(cls);
    }

    public JavaBeanSerializer getJavaBeanSerializer() {
        return this.nature;
    }
}
