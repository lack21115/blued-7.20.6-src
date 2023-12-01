package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.util.FieldInfo;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

/* loaded from: source-6737240-dex2jar.jar:com/alibaba/fastjson/serializer/JSONSerializer.class */
public class JSONSerializer {
    protected List<AfterFilter> afterFilters;
    protected List<BeforeFilter> beforeFilters;
    private final SerializeConfig config;
    protected SerialContext context;
    protected List<ContextValueFilter> contextValueFilters;
    private DateFormat dateFormat;
    private String dateFormatPattern;
    private String indent;
    private int indentCount;
    protected List<LabelFilter> labelFilters;
    protected Locale locale;
    protected List<NameFilter> nameFilters;
    public final SerializeWriter out;
    protected List<PropertyFilter> propertyFilters;
    protected List<PropertyPreFilter> propertyPreFilters;
    protected IdentityHashMap<Object, SerialContext> references;
    protected TimeZone timeZone;
    protected List<ValueFilter> valueFilters;

    public JSONSerializer() {
        this(new SerializeWriter(), SerializeConfig.getGlobalInstance());
    }

    public JSONSerializer(SerializeConfig serializeConfig) {
        this(new SerializeWriter(), serializeConfig);
    }

    public JSONSerializer(SerializeWriter serializeWriter) {
        this(serializeWriter, SerializeConfig.getGlobalInstance());
    }

    public JSONSerializer(SerializeWriter serializeWriter, SerializeConfig serializeConfig) {
        this.beforeFilters = null;
        this.afterFilters = null;
        this.propertyFilters = null;
        this.valueFilters = null;
        this.nameFilters = null;
        this.propertyPreFilters = null;
        this.labelFilters = null;
        this.contextValueFilters = null;
        this.indentCount = 0;
        this.indent = "\t";
        this.references = null;
        this.timeZone = JSON.defaultTimeZone;
        this.locale = JSON.defaultLocale;
        this.out = serializeWriter;
        this.config = serializeConfig;
    }

    public static void write(SerializeWriter serializeWriter, Object obj) {
        new JSONSerializer(serializeWriter).write(obj);
    }

    public static void write(Writer writer, Object obj) {
        SerializeWriter serializeWriter = new SerializeWriter();
        try {
            try {
                new JSONSerializer(serializeWriter).write(obj);
                serializeWriter.writeTo(writer);
                serializeWriter.close();
            } catch (IOException e) {
                throw new JSONException(e.getMessage(), e);
            }
        } catch (Throwable th) {
            serializeWriter.close();
            throw th;
        }
    }

    public void addFilter(SerializeFilter serializeFilter) {
        if (serializeFilter == null) {
            return;
        }
        if (serializeFilter instanceof PropertyPreFilter) {
            getPropertyPreFilters().add((PropertyPreFilter) serializeFilter);
        }
        if (serializeFilter instanceof NameFilter) {
            getNameFilters().add((NameFilter) serializeFilter);
        }
        if (serializeFilter instanceof ValueFilter) {
            getValueFilters().add((ValueFilter) serializeFilter);
        }
        if (serializeFilter instanceof ContextValueFilter) {
            getContextValueFilters().add((ContextValueFilter) serializeFilter);
        }
        if (serializeFilter instanceof PropertyFilter) {
            getPropertyFilters().add((PropertyFilter) serializeFilter);
        }
        if (serializeFilter instanceof BeforeFilter) {
            getBeforeFilters().add((BeforeFilter) serializeFilter);
        }
        if (serializeFilter instanceof AfterFilter) {
            getAfterFilters().add((AfterFilter) serializeFilter);
        }
        if (serializeFilter instanceof LabelFilter) {
            getLabelFilters().add((LabelFilter) serializeFilter);
        }
    }

    public boolean apply(Object obj, String str, Object obj2) {
        List<PropertyFilter> list = this.propertyFilters;
        if (list == null) {
            return true;
        }
        for (PropertyFilter propertyFilter : list) {
            if (!propertyFilter.apply(obj, str, obj2)) {
                return false;
            }
        }
        return true;
    }

    public boolean applyLabel(String str) {
        List<LabelFilter> list = this.labelFilters;
        if (list != null) {
            for (LabelFilter labelFilter : list) {
                if (!labelFilter.apply(str)) {
                    return false;
                }
            }
            return true;
        }
        return true;
    }

    public boolean applyName(Object obj, String str) {
        List<PropertyPreFilter> list = this.propertyPreFilters;
        if (list == null) {
            return true;
        }
        for (PropertyPreFilter propertyPreFilter : list) {
            if (!propertyPreFilter.apply(this, obj, str)) {
                return false;
            }
        }
        return true;
    }

    public boolean checkValue() {
        List<ValueFilter> list = this.valueFilters;
        if (list == null || list.size() <= 0) {
            List<ContextValueFilter> list2 = this.contextValueFilters;
            return (list2 != null && list2.size() > 0) || this.out.writeNonStringValueAsString;
        }
        return true;
    }

    public void close() {
        this.out.close();
    }

    public void config(SerializerFeature serializerFeature, boolean z) {
        this.out.config(serializerFeature, z);
    }

    public boolean containsReference(Object obj) {
        IdentityHashMap<Object, SerialContext> identityHashMap = this.references;
        return identityHashMap != null && identityHashMap.containsKey(obj);
    }

    public void decrementIdent() {
        this.indentCount--;
    }

    public List<AfterFilter> getAfterFilters() {
        if (this.afterFilters == null) {
            this.afterFilters = new ArrayList();
        }
        return this.afterFilters;
    }

    public List<BeforeFilter> getBeforeFilters() {
        if (this.beforeFilters == null) {
            this.beforeFilters = new ArrayList();
        }
        return this.beforeFilters;
    }

    public SerialContext getContext() {
        return this.context;
    }

    public List<ContextValueFilter> getContextValueFilters() {
        if (this.contextValueFilters == null) {
            this.contextValueFilters = new ArrayList();
        }
        return this.contextValueFilters;
    }

    public DateFormat getDateFormat() {
        if (this.dateFormat == null && this.dateFormatPattern != null) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(this.dateFormatPattern, this.locale);
            this.dateFormat = simpleDateFormat;
            simpleDateFormat.setTimeZone(this.timeZone);
        }
        return this.dateFormat;
    }

    public String getDateFormatPattern() {
        DateFormat dateFormat = this.dateFormat;
        return dateFormat instanceof SimpleDateFormat ? ((SimpleDateFormat) dateFormat).toPattern() : this.dateFormatPattern;
    }

    public FieldInfo getFieldInfo() {
        return null;
    }

    public int getIndentCount() {
        return this.indentCount;
    }

    public List<LabelFilter> getLabelFilters() {
        if (this.labelFilters == null) {
            this.labelFilters = new ArrayList();
        }
        return this.labelFilters;
    }

    public SerializeConfig getMapping() {
        return this.config;
    }

    public List<NameFilter> getNameFilters() {
        if (this.nameFilters == null) {
            this.nameFilters = new ArrayList();
        }
        return this.nameFilters;
    }

    public ObjectSerializer getObjectWriter(Class<?> cls) {
        return this.config.getObjectWriter(cls);
    }

    public List<PropertyFilter> getPropertyFilters() {
        if (this.propertyFilters == null) {
            this.propertyFilters = new ArrayList();
        }
        return this.propertyFilters;
    }

    public List<PropertyPreFilter> getPropertyPreFilters() {
        if (this.propertyPreFilters == null) {
            this.propertyPreFilters = new ArrayList();
        }
        return this.propertyPreFilters;
    }

    public List<ValueFilter> getValueFilters() {
        if (this.valueFilters == null) {
            this.valueFilters = new ArrayList();
        }
        return this.valueFilters;
    }

    public SerializeWriter getWriter() {
        return this.out;
    }

    public boolean hasNameFilters() {
        List<NameFilter> list = this.nameFilters;
        return list != null && list.size() > 0;
    }

    public void incrementIndent() {
        this.indentCount++;
    }

    public boolean isEnabled(SerializerFeature serializerFeature) {
        return this.out.isEnabled(serializerFeature);
    }

    public final boolean isWriteClassName(Type type, Object obj) {
        if (this.out.isEnabled(SerializerFeature.WriteClassName)) {
            return (type == null && this.out.isEnabled(SerializerFeature.NotWriteRootClassName) && this.context.parent == null) ? false : true;
        }
        return false;
    }

    public void popContext() {
        SerialContext serialContext = this.context;
        if (serialContext != null) {
            this.context = serialContext.parent;
        }
    }

    public void println() {
        this.out.write(10);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.indentCount) {
                return;
            }
            this.out.write(this.indent);
            i = i2 + 1;
        }
    }

    public String processKey(Object obj, String str, Object obj2) {
        List<NameFilter> list = this.nameFilters;
        String str2 = str;
        if (list != null) {
            Iterator<NameFilter> it = list.iterator();
            while (true) {
                str2 = str;
                if (!it.hasNext()) {
                    break;
                }
                str = it.next().process(obj, str, obj2);
            }
        }
        return str2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0028, code lost:
        if ((r10 instanceof java.lang.Boolean) != false) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object processValue(com.alibaba.fastjson.serializer.JavaBeanSerializer r7, java.lang.Object r8, java.lang.String r9, java.lang.Object r10) {
        /*
            r6 = this;
            r0 = r10
            r11 = r0
            r0 = r10
            if (r0 == 0) goto L32
            r0 = r10
            r11 = r0
            r0 = r6
            com.alibaba.fastjson.serializer.SerializeWriter r0 = r0.out
            boolean r0 = r0.writeNonStringValueAsString
            if (r0 == 0) goto L32
            r0 = r10
            boolean r0 = r0 instanceof java.lang.Number
            if (r0 != 0) goto L2b
            r0 = r10
            r11 = r0
            r0 = r10
            boolean r0 = r0 instanceof java.lang.Boolean
            if (r0 == 0) goto L32
        L2b:
            r0 = r10
            java.lang.String r0 = r0.toString()
            r11 = r0
        L32:
            r0 = r6
            java.util.List<com.alibaba.fastjson.serializer.ValueFilter> r0 = r0.valueFilters
            r12 = r0
            r0 = r11
            r10 = r0
            r0 = r12
            if (r0 == 0) goto L70
            r0 = r12
            java.util.Iterator r0 = r0.iterator()
            r12 = r0
        L4a:
            r0 = r11
            r10 = r0
            r0 = r12
            boolean r0 = r0.hasNext()
            if (r0 == 0) goto L70
            r0 = r12
            java.lang.Object r0 = r0.next()
            com.alibaba.fastjson.serializer.ValueFilter r0 = (com.alibaba.fastjson.serializer.ValueFilter) r0
            r1 = r8
            r2 = r9
            r3 = r11
            java.lang.Object r0 = r0.process(r1, r2, r3)
            r11 = r0
            goto L4a
        L70:
            r0 = r6
            java.util.List<com.alibaba.fastjson.serializer.ContextValueFilter> r0 = r0.contextValueFilters
            r12 = r0
            r0 = r10
            r11 = r0
            r0 = r12
            if (r0 == 0) goto Lb8
            r0 = r7
            r1 = r9
            com.alibaba.fastjson.serializer.FieldSerializer r0 = r0.getFieldSerializer(r1)
            com.alibaba.fastjson.serializer.BeanContext r0 = r0.fieldContext
            r7 = r0
            r0 = r12
            java.util.Iterator r0 = r0.iterator()
            r12 = r0
        L91:
            r0 = r10
            r11 = r0
            r0 = r12
            boolean r0 = r0.hasNext()
            if (r0 == 0) goto Lb8
            r0 = r12
            java.lang.Object r0 = r0.next()
            com.alibaba.fastjson.serializer.ContextValueFilter r0 = (com.alibaba.fastjson.serializer.ContextValueFilter) r0
            r1 = r7
            r2 = r8
            r3 = r9
            r4 = r10
            java.lang.Object r0 = r0.process(r1, r2, r3, r4)
            r10 = r0
            goto L91
        Lb8:
            r0 = r11
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.serializer.JSONSerializer.processValue(com.alibaba.fastjson.serializer.JavaBeanSerializer, java.lang.Object, java.lang.String, java.lang.Object):java.lang.Object");
    }

    public void setContext(SerialContext serialContext) {
        this.context = serialContext;
    }

    public void setContext(SerialContext serialContext, Object obj, Object obj2, int i) {
        setContext(serialContext, obj, obj2, i, 0);
    }

    public void setContext(SerialContext serialContext, Object obj, Object obj2, int i, int i2) {
        if (this.out.disableCircularReferenceDetect) {
            return;
        }
        this.context = new SerialContext(serialContext, obj, obj2, i, i2);
        if (this.references == null) {
            this.references = new IdentityHashMap<>();
        }
        this.references.put(obj, this.context);
    }

    public void setContext(Object obj, Object obj2) {
        setContext(this.context, obj, obj2, 0);
    }

    public void setDateFormat(String str) {
        this.dateFormatPattern = str;
        if (this.dateFormat != null) {
            this.dateFormat = null;
        }
    }

    public void setDateFormat(DateFormat dateFormat) {
        this.dateFormat = dateFormat;
        if (this.dateFormatPattern != null) {
            this.dateFormatPattern = null;
        }
    }

    public String toString() {
        return this.out.toString();
    }

    public final void write(Object obj) {
        if (obj == null) {
            this.out.writeNull();
            return;
        }
        try {
            getObjectWriter(obj.getClass()).write(this, obj, null, null, 0);
        } catch (IOException e) {
            throw new JSONException(e.getMessage(), e);
        }
    }

    public final void write(String str) {
        StringCodec.instance.write(this, str);
    }

    public char writeAfter(Object obj, char c) {
        List<AfterFilter> list = this.afterFilters;
        char c2 = c;
        if (list != null) {
            Iterator<AfterFilter> it = list.iterator();
            while (true) {
                c2 = c;
                if (!it.hasNext()) {
                    break;
                }
                c = it.next().writeAfter(this, obj, c);
            }
        }
        return c2;
    }

    public char writeBefore(Object obj, char c) {
        List<BeforeFilter> list = this.beforeFilters;
        char c2 = c;
        if (list != null) {
            Iterator<BeforeFilter> it = list.iterator();
            while (true) {
                c2 = c;
                if (!it.hasNext()) {
                    break;
                }
                c = it.next().writeBefore(this, obj, c);
            }
        }
        return c2;
    }

    public boolean writeDirect() {
        return this.out.writeDirect && this.beforeFilters == null && this.afterFilters == null && this.valueFilters == null && this.contextValueFilters == null && this.propertyFilters == null && this.nameFilters == null && this.propertyPreFilters == null && this.labelFilters == null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void writeKeyValue(char c, String str, Object obj) {
        if (c != 0) {
            this.out.write(c);
        }
        this.out.writeFieldName(str);
        write(obj);
    }

    public void writeNull() {
        this.out.writeNull();
    }

    public void writeReference(Object obj) {
        SerialContext serialContext = this.context;
        if (obj == serialContext.object) {
            this.out.write("{\"$ref\":\"@\"}");
            return;
        }
        SerialContext serialContext2 = serialContext.parent;
        SerialContext serialContext3 = serialContext;
        if (serialContext2 != null) {
            serialContext3 = serialContext;
            if (obj == serialContext2.object) {
                this.out.write("{\"$ref\":\"..\"}");
                return;
            }
        }
        while (serialContext3.parent != null) {
            serialContext3 = serialContext3.parent;
        }
        if (obj == serialContext3.object) {
            this.out.write("{\"$ref\":\"$\"}");
            return;
        }
        this.out.write("{\"$ref\":\"");
        this.out.write(this.references.get(obj).toString());
        this.out.write("\"}");
    }

    public final void writeWithFieldName(Object obj, Object obj2) {
        writeWithFieldName(obj, obj2, null, 0);
    }

    public final void writeWithFieldName(Object obj, Object obj2, Type type, int i) {
        try {
            if (obj == null) {
                this.out.writeNull();
            } else {
                getObjectWriter(obj.getClass()).write(this, obj, obj2, type, i);
            }
        } catch (IOException e) {
            throw new JSONException(e.getMessage(), e);
        }
    }

    public final void writeWithFormat(Object obj, String str) {
        if (!(obj instanceof Date)) {
            write(obj);
            return;
        }
        DateFormat dateFormat = getDateFormat();
        SimpleDateFormat simpleDateFormat = dateFormat;
        if (dateFormat == null) {
            simpleDateFormat = new SimpleDateFormat(str, this.locale);
            simpleDateFormat.setTimeZone(this.timeZone);
        }
        this.out.writeString(simpleDateFormat.format((Date) obj));
    }
}
