package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.util.FieldInfo;
import java.io.IOException;
import java.lang.reflect.Member;
import java.util.Collection;

/* loaded from: source-6737240-dex2jar.jar:com/alibaba/fastjson/serializer/FieldSerializer.class */
public class FieldSerializer implements Comparable<FieldSerializer> {
    private final String double_quoted_fieldPrefix;
    protected int features;
    protected BeanContext fieldContext;
    public final FieldInfo fieldInfo;
    private String format;
    private RuntimeSerializerInfo runtimeInfo;
    private String single_quoted_fieldPrefix;
    private String un_quoted_fieldPrefix;
    protected boolean writeEnumUsingName;
    protected boolean writeEnumUsingToString;
    protected final boolean writeNull;
    protected boolean writeNullBooleanAsFalse;
    protected boolean writeNullListAsEmpty;
    protected boolean writeNullStringAsEmpty;
    protected boolean writeNumberAsZero;

    /* loaded from: source-6737240-dex2jar.jar:com/alibaba/fastjson/serializer/FieldSerializer$RuntimeSerializerInfo.class */
    static class RuntimeSerializerInfo {
        ObjectSerializer fieldSerializer;
        Class<?> runtimeFieldClass;

        public RuntimeSerializerInfo(ObjectSerializer objectSerializer, Class<?> cls) {
            this.fieldSerializer = objectSerializer;
            this.runtimeFieldClass = cls;
        }
    }

    public FieldSerializer(Class<?> cls, FieldInfo fieldInfo) {
        boolean z = false;
        this.writeNumberAsZero = false;
        this.writeNullStringAsEmpty = false;
        this.writeNullBooleanAsFalse = false;
        this.writeNullListAsEmpty = false;
        this.writeEnumUsingToString = false;
        this.writeEnumUsingName = false;
        this.fieldInfo = fieldInfo;
        this.fieldContext = new BeanContext(cls, fieldInfo);
        fieldInfo.setAccessible();
        this.double_quoted_fieldPrefix = '\"' + fieldInfo.name + "\":";
        JSONField annotation = fieldInfo.getAnnotation();
        if (annotation != null) {
            SerializerFeature[] serialzeFeatures = annotation.serialzeFeatures();
            int length = serialzeFeatures.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    z = false;
                    break;
                } else if (serialzeFeatures[i2] == SerializerFeature.WriteMapNullValue) {
                    z = true;
                    break;
                } else {
                    i = i2 + 1;
                }
            }
            String format = annotation.format();
            this.format = format;
            if (format.trim().length() == 0) {
                this.format = null;
            }
            SerializerFeature[] serialzeFeatures2 = annotation.serialzeFeatures();
            int length2 = serialzeFeatures2.length;
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= length2) {
                    break;
                }
                SerializerFeature serializerFeature = serialzeFeatures2[i4];
                if (serializerFeature == SerializerFeature.WriteNullNumberAsZero) {
                    this.writeNumberAsZero = true;
                } else if (serializerFeature == SerializerFeature.WriteNullStringAsEmpty) {
                    this.writeNullStringAsEmpty = true;
                } else if (serializerFeature == SerializerFeature.WriteNullBooleanAsFalse) {
                    this.writeNullBooleanAsFalse = true;
                } else if (serializerFeature == SerializerFeature.WriteNullListAsEmpty) {
                    this.writeNullListAsEmpty = true;
                } else if (serializerFeature == SerializerFeature.WriteEnumUsingToString) {
                    this.writeEnumUsingToString = true;
                } else if (serializerFeature == SerializerFeature.WriteEnumUsingName) {
                    this.writeEnumUsingName = true;
                }
                i3 = i4 + 1;
            }
            this.features = SerializerFeature.of(annotation.serialzeFeatures());
        }
        this.writeNull = z;
    }

    @Override // java.lang.Comparable
    public int compareTo(FieldSerializer fieldSerializer) {
        return this.fieldInfo.compareTo(fieldSerializer.fieldInfo);
    }

    public Object getPropertyValue(Object obj) throws Exception {
        try {
            return this.fieldInfo.get(obj);
        } catch (Exception e) {
            Member member = this.fieldInfo.getMember();
            throw new JSONException("get property error。 " + (member.getDeclaringClass().getName() + "." + member.getName()), e);
        }
    }

    public void writePrefix(JSONSerializer jSONSerializer) throws IOException {
        SerializeWriter serializeWriter = jSONSerializer.out;
        if (!serializeWriter.quoteFieldNames) {
            if (this.un_quoted_fieldPrefix == null) {
                this.un_quoted_fieldPrefix = this.fieldInfo.name + ":";
            }
            serializeWriter.write(this.un_quoted_fieldPrefix);
        } else if (!serializeWriter.useSingleQuotes) {
            serializeWriter.write(this.double_quoted_fieldPrefix);
        } else {
            if (this.single_quoted_fieldPrefix == null) {
                this.single_quoted_fieldPrefix = '\'' + this.fieldInfo.name + "':";
            }
            serializeWriter.write(this.single_quoted_fieldPrefix);
        }
    }

    public void writeValue(JSONSerializer jSONSerializer, Object obj) throws Exception {
        String str = this.format;
        if (str != null) {
            jSONSerializer.writeWithFormat(obj, str);
            return;
        }
        if (this.runtimeInfo == null) {
            Class<?> cls = obj == null ? this.fieldInfo.fieldClass : obj.getClass();
            this.runtimeInfo = new RuntimeSerializerInfo(jSONSerializer.getObjectWriter(cls), cls);
        }
        RuntimeSerializerInfo runtimeSerializerInfo = this.runtimeInfo;
        int i = this.fieldInfo.serialzeFeatures;
        if (obj != null) {
            if (this.fieldInfo.isEnum) {
                if (this.writeEnumUsingName) {
                    jSONSerializer.out.writeString(((Enum) obj).name());
                    return;
                } else if (this.writeEnumUsingToString) {
                    jSONSerializer.out.writeString(((Enum) obj).toString());
                    return;
                }
            }
            Class<?> cls2 = obj.getClass();
            if (cls2 == runtimeSerializerInfo.runtimeFieldClass) {
                runtimeSerializerInfo.fieldSerializer.write(jSONSerializer, obj, this.fieldInfo.name, this.fieldInfo.fieldType, i);
                return;
            } else {
                jSONSerializer.getObjectWriter(cls2).write(jSONSerializer, obj, this.fieldInfo.name, this.fieldInfo.fieldType, i);
                return;
            }
        }
        Class<?> cls3 = runtimeSerializerInfo.runtimeFieldClass;
        SerializeWriter serializeWriter = jSONSerializer.out;
        if ((this.writeNumberAsZero || (serializeWriter.features & SerializerFeature.WriteNullNumberAsZero.mask) != 0) && Number.class.isAssignableFrom(cls3)) {
            serializeWriter.write(48);
        } else if (this.writeNullStringAsEmpty && String.class == cls3) {
            serializeWriter.write("\"\"");
        } else if (this.writeNullBooleanAsFalse && Boolean.class == cls3) {
            serializeWriter.write("false");
        } else if (this.writeNullListAsEmpty && Collection.class.isAssignableFrom(cls3)) {
            serializeWriter.write("[]");
        } else {
            ObjectSerializer objectSerializer = runtimeSerializerInfo.fieldSerializer;
            if (serializeWriter.writeMapNullValue && (objectSerializer instanceof ASMJavaBeanSerializer)) {
                serializeWriter.writeNull();
            } else {
                objectSerializer.write(jSONSerializer, null, this.fieldInfo.name, this.fieldInfo.fieldType, i);
            }
        }
    }
}
