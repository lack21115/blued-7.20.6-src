package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.asm.ClassWriter;
import com.alibaba.fastjson.asm.FieldWriter;
import com.alibaba.fastjson.asm.Label;
import com.alibaba.fastjson.asm.MethodVisitor;
import com.alibaba.fastjson.asm.MethodWriter;
import com.alibaba.fastjson.asm.Opcodes;
import com.alibaba.fastjson.asm.Type;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.JSONLexerBase;
import com.alibaba.fastjson.parser.JSONToken;
import com.alibaba.fastjson.parser.ParseContext;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.parser.SymbolTable;
import com.alibaba.fastjson.util.ASMClassLoader;
import com.alibaba.fastjson.util.ASMUtils;
import com.alibaba.fastjson.util.FieldInfo;
import com.alibaba.fastjson.util.JavaBeanInfo;
import com.alibaba.fastjson.util.TypeUtils;
import com.alipay.sdk.util.i;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: source-6737240-dex2jar.jar:com/alibaba/fastjson/parser/deserializer/ASMDeserializerFactory.class */
public class ASMDeserializerFactory implements Opcodes {
    static final String DefaultJSONParser = ASMUtils.type(DefaultJSONParser.class);
    static final String JSONLexerBase = ASMUtils.type(JSONLexerBase.class);
    static final String JSONToken = ASMUtils.type(JSONToken.class);
    public final ASMClassLoader classLoader;
    protected final AtomicLong seed = new AtomicLong();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-6737240-dex2jar.jar:com/alibaba/fastjson/parser/deserializer/ASMDeserializerFactory$Context.class */
    public static class Context {
        private final JavaBeanInfo beanInfo;
        private final String className;
        private final Class<?> clazz;
        private FieldInfo[] fieldInfoList;
        private int variantIndex;
        private final Map<String, Integer> variants = new HashMap();

        public Context(String str, ParserConfig parserConfig, JavaBeanInfo javaBeanInfo, int i) {
            this.variantIndex = 5;
            this.className = str;
            this.clazz = javaBeanInfo.clazz;
            this.variantIndex = i;
            this.beanInfo = javaBeanInfo;
            this.fieldInfoList = javaBeanInfo.fields;
        }

        public Class<?> getInstClass() {
            Class<?> cls = this.beanInfo.builderClass;
            Class<?> cls2 = cls;
            if (cls == null) {
                cls2 = this.clazz;
            }
            return cls2;
        }

        public int var(String str) {
            if (this.variants.get(str) == null) {
                Map<String, Integer> map = this.variants;
                int i = this.variantIndex;
                this.variantIndex = i + 1;
                map.put(str, Integer.valueOf(i));
            }
            return this.variants.get(str).intValue();
        }

        public int var(String str, int i) {
            if (this.variants.get(str) == null) {
                this.variants.put(str, Integer.valueOf(this.variantIndex));
                this.variantIndex += i;
            }
            return this.variants.get(str).intValue();
        }
    }

    public ASMDeserializerFactory(ClassLoader classLoader) {
        this.classLoader = classLoader instanceof ASMClassLoader ? (ASMClassLoader) classLoader : new ASMClassLoader(classLoader);
    }

    private void _batchSet(Context context, MethodVisitor methodVisitor) {
        _batchSet(context, methodVisitor, true);
    }

    private void _batchSet(Context context, MethodVisitor methodVisitor, boolean z) {
        int length = context.fieldInfoList.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            Label label = new Label();
            if (z) {
                _isFlag(methodVisitor, context, i2, label);
            }
            _loadAndSet(context, methodVisitor, context.fieldInfoList[i2]);
            if (z) {
                methodVisitor.visitLabel(label);
            }
            i = i2 + 1;
        }
    }

    private void _createInstance(ClassWriter classWriter, Context context) {
        MethodWriter methodWriter = new MethodWriter(classWriter, 1, "createInstance", "(L" + DefaultJSONParser + ";Ljava/lang/reflect/Type;)Ljava/lang/Object;", null, null);
        methodWriter.visitTypeInsn(187, ASMUtils.type(context.getInstClass()));
        methodWriter.visitInsn(89);
        methodWriter.visitMethodInsn(183, ASMUtils.type(context.getInstClass()), "<init>", "()V");
        methodWriter.visitInsn(176);
        methodWriter.visitMaxs(3, 3);
        methodWriter.visitEnd();
    }

    private void _createInstance(Context context, MethodVisitor methodVisitor) {
        Constructor<?> constructor = context.beanInfo.defaultConstructor;
        if (Modifier.isPublic(constructor.getModifiers())) {
            methodVisitor.visitTypeInsn(187, ASMUtils.type(context.getInstClass()));
            methodVisitor.visitInsn(89);
            methodVisitor.visitMethodInsn(183, ASMUtils.type(constructor.getDeclaringClass()), "<init>", "()V");
            methodVisitor.visitVarInsn(58, context.var("instance"));
            return;
        }
        methodVisitor.visitVarInsn(25, 0);
        methodVisitor.visitVarInsn(25, 1);
        String type = ASMUtils.type(ASMJavaBeanDeserializer.class);
        methodVisitor.visitMethodInsn(183, type, "createInstance", "(L" + DefaultJSONParser + ";)Ljava/lang/Object;");
        methodVisitor.visitTypeInsn(192, ASMUtils.type(context.getInstClass()));
        methodVisitor.visitVarInsn(58, context.var("instance"));
    }

    private void _deserObject(Context context, MethodVisitor methodVisitor, FieldInfo fieldInfo, Class<?> cls, int i) {
        _getFieldDeser(context, methodVisitor, fieldInfo);
        methodVisitor.visitVarInsn(25, 1);
        if (fieldInfo.fieldType instanceof Class) {
            methodVisitor.visitLdcInsn(Type.getType(ASMUtils.desc(fieldInfo.fieldClass)));
        } else {
            methodVisitor.visitVarInsn(25, 0);
            methodVisitor.visitLdcInsn(Integer.valueOf(i));
            methodVisitor.visitMethodInsn(182, ASMUtils.type(ASMJavaBeanDeserializer.class), "getFieldType", "(I)Ljava/lang/reflect/Type;");
        }
        methodVisitor.visitLdcInsn(fieldInfo.name);
        String type = ASMUtils.type(ObjectDeserializer.class);
        methodVisitor.visitMethodInsn(185, type, "deserialze", "(L" + DefaultJSONParser + ";Ljava/lang/reflect/Type;Ljava/lang/Object;)Ljava/lang/Object;");
        methodVisitor.visitTypeInsn(192, ASMUtils.type(cls));
        methodVisitor.visitVarInsn(58, context.var(fieldInfo.name + "_asm"));
    }

    private void _deserialize_endCheck(Context context, MethodVisitor methodVisitor, Label label) {
        methodVisitor.visitIntInsn(21, context.var("matchedCount"));
        methodVisitor.visitJumpInsn(158, label);
        methodVisitor.visitVarInsn(25, context.var("lexer"));
        methodVisitor.visitMethodInsn(182, JSONLexerBase, "token", "()I");
        methodVisitor.visitFieldInsn(178, JSONToken, "RBRACE", "I");
        methodVisitor.visitJumpInsn(160, label);
        methodVisitor.visitVarInsn(25, context.var("lexer"));
        methodVisitor.visitFieldInsn(178, JSONToken, "COMMA", "I");
        methodVisitor.visitMethodInsn(182, JSONLexerBase, "nextToken", "(I)V");
    }

    private void _deserialze_list_obj(Context context, MethodVisitor methodVisitor, Label label, FieldInfo fieldInfo, Class<?> cls, Class<?> cls2, int i) {
        Label label2 = new Label();
        methodVisitor.visitMethodInsn(182, JSONLexerBase, "matchField", "([C)Z");
        methodVisitor.visitJumpInsn(153, label2);
        _setFlag(methodVisitor, context, i);
        Label label3 = new Label();
        methodVisitor.visitVarInsn(25, context.var("lexer"));
        methodVisitor.visitMethodInsn(182, JSONLexerBase, "token", "()I");
        methodVisitor.visitFieldInsn(178, JSONToken, "NULL", "I");
        methodVisitor.visitJumpInsn(160, label3);
        methodVisitor.visitVarInsn(25, context.var("lexer"));
        methodVisitor.visitFieldInsn(178, JSONToken, "COMMA", "I");
        methodVisitor.visitMethodInsn(182, JSONLexerBase, "nextToken", "(I)V");
        methodVisitor.visitJumpInsn(167, label2);
        methodVisitor.visitLabel(label3);
        Label label4 = new Label();
        Label label5 = new Label();
        methodVisitor.visitVarInsn(25, context.var("lexer"));
        methodVisitor.visitMethodInsn(182, JSONLexerBase, "token", "()I");
        methodVisitor.visitFieldInsn(178, JSONToken, "SET", "I");
        methodVisitor.visitJumpInsn(160, label5);
        methodVisitor.visitVarInsn(25, context.var("lexer"));
        methodVisitor.visitFieldInsn(178, JSONToken, "LBRACKET", "I");
        methodVisitor.visitMethodInsn(182, JSONLexerBase, "nextToken", "(I)V");
        methodVisitor.visitVarInsn(25, context.var("lexer"));
        methodVisitor.visitMethodInsn(182, JSONLexerBase, "token", "()I");
        methodVisitor.visitFieldInsn(178, JSONToken, "LBRACKET", "I");
        methodVisitor.visitJumpInsn(160, label);
        _newCollection(methodVisitor, cls, i, true);
        methodVisitor.visitJumpInsn(167, label4);
        methodVisitor.visitLabel(label5);
        methodVisitor.visitVarInsn(25, context.var("lexer"));
        methodVisitor.visitMethodInsn(182, JSONLexerBase, "token", "()I");
        methodVisitor.visitFieldInsn(178, JSONToken, "LBRACKET", "I");
        methodVisitor.visitJumpInsn(160, label);
        _newCollection(methodVisitor, cls, i, false);
        methodVisitor.visitLabel(label4);
        methodVisitor.visitVarInsn(58, context.var(fieldInfo.name + "_asm"));
        _getCollectionFieldItemDeser(context, methodVisitor, fieldInfo, cls2);
        methodVisitor.visitMethodInsn(185, ASMUtils.type(ObjectDeserializer.class), "getFastMatchToken", "()I");
        methodVisitor.visitVarInsn(54, context.var("fastMatchToken"));
        methodVisitor.visitVarInsn(25, context.var("lexer"));
        methodVisitor.visitVarInsn(21, context.var("fastMatchToken"));
        methodVisitor.visitMethodInsn(182, JSONLexerBase, "nextToken", "(I)V");
        methodVisitor.visitVarInsn(25, 1);
        String str = DefaultJSONParser;
        methodVisitor.visitMethodInsn(182, str, "getContext", "()" + ASMUtils.desc(ParseContext.class));
        methodVisitor.visitVarInsn(58, context.var("listContext"));
        methodVisitor.visitVarInsn(25, 1);
        methodVisitor.visitVarInsn(25, context.var(fieldInfo.name + "_asm"));
        methodVisitor.visitLdcInsn(fieldInfo.name);
        String str2 = DefaultJSONParser;
        methodVisitor.visitMethodInsn(182, str2, "setContext", "(Ljava/lang/Object;Ljava/lang/Object;)" + ASMUtils.desc(ParseContext.class));
        methodVisitor.visitInsn(87);
        Label label6 = new Label();
        Label label7 = new Label();
        methodVisitor.visitInsn(3);
        methodVisitor.visitVarInsn(54, context.var("i"));
        methodVisitor.visitLabel(label6);
        methodVisitor.visitVarInsn(25, context.var("lexer"));
        methodVisitor.visitMethodInsn(182, JSONLexerBase, "token", "()I");
        methodVisitor.visitFieldInsn(178, JSONToken, "RBRACKET", "I");
        methodVisitor.visitJumpInsn(159, label7);
        methodVisitor.visitVarInsn(25, 0);
        String str3 = context.className;
        methodVisitor.visitFieldInsn(180, str3, fieldInfo.name + "_asm_list_item_deser__", ASMUtils.desc(ObjectDeserializer.class));
        methodVisitor.visitVarInsn(25, 1);
        methodVisitor.visitLdcInsn(Type.getType(ASMUtils.desc(cls2)));
        methodVisitor.visitVarInsn(21, context.var("i"));
        methodVisitor.visitMethodInsn(184, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
        String type = ASMUtils.type(ObjectDeserializer.class);
        methodVisitor.visitMethodInsn(185, type, "deserialze", "(L" + DefaultJSONParser + ";Ljava/lang/reflect/Type;Ljava/lang/Object;)Ljava/lang/Object;");
        methodVisitor.visitVarInsn(58, context.var("list_item_value"));
        methodVisitor.visitIincInsn(context.var("i"), 1);
        methodVisitor.visitVarInsn(25, context.var(fieldInfo.name + "_asm"));
        methodVisitor.visitVarInsn(25, context.var("list_item_value"));
        if (cls.isInterface()) {
            methodVisitor.visitMethodInsn(185, ASMUtils.type(cls), "add", "(Ljava/lang/Object;)Z");
        } else {
            methodVisitor.visitMethodInsn(182, ASMUtils.type(cls), "add", "(Ljava/lang/Object;)Z");
        }
        methodVisitor.visitInsn(87);
        methodVisitor.visitVarInsn(25, 1);
        methodVisitor.visitVarInsn(25, context.var(fieldInfo.name + "_asm"));
        methodVisitor.visitMethodInsn(182, DefaultJSONParser, "checkListResolve", "(Ljava/util/Collection;)V");
        methodVisitor.visitVarInsn(25, context.var("lexer"));
        methodVisitor.visitMethodInsn(182, JSONLexerBase, "token", "()I");
        methodVisitor.visitFieldInsn(178, JSONToken, "COMMA", "I");
        methodVisitor.visitJumpInsn(160, label6);
        methodVisitor.visitVarInsn(25, context.var("lexer"));
        methodVisitor.visitVarInsn(21, context.var("fastMatchToken"));
        methodVisitor.visitMethodInsn(182, JSONLexerBase, "nextToken", "(I)V");
        methodVisitor.visitJumpInsn(167, label6);
        methodVisitor.visitLabel(label7);
        methodVisitor.visitVarInsn(25, 1);
        methodVisitor.visitVarInsn(25, context.var("listContext"));
        String str4 = DefaultJSONParser;
        methodVisitor.visitMethodInsn(182, str4, "setContext", "(" + ASMUtils.desc(ParseContext.class) + ")V");
        methodVisitor.visitVarInsn(25, context.var("lexer"));
        methodVisitor.visitMethodInsn(182, JSONLexerBase, "token", "()I");
        methodVisitor.visitFieldInsn(178, JSONToken, "RBRACKET", "I");
        methodVisitor.visitJumpInsn(160, label);
        methodVisitor.visitVarInsn(25, context.var("lexer"));
        methodVisitor.visitFieldInsn(178, JSONToken, "COMMA", "I");
        methodVisitor.visitMethodInsn(182, JSONLexerBase, "nextToken", "(I)V");
        methodVisitor.visitLabel(label2);
    }

    private void _deserialze_obj(Context context, MethodVisitor methodVisitor, Label label, FieldInfo fieldInfo, Class<?> cls, int i) {
        Label label2 = new Label();
        Label label3 = new Label();
        methodVisitor.visitVarInsn(25, context.var("lexer"));
        methodVisitor.visitVarInsn(25, 0);
        String str = context.className;
        methodVisitor.visitFieldInsn(180, str, fieldInfo.name + "_asm_prefix__", "[C");
        methodVisitor.visitMethodInsn(182, JSONLexerBase, "matchField", "([C)Z");
        methodVisitor.visitJumpInsn(154, label2);
        methodVisitor.visitInsn(1);
        methodVisitor.visitVarInsn(58, context.var(fieldInfo.name + "_asm"));
        methodVisitor.visitJumpInsn(167, label3);
        methodVisitor.visitLabel(label2);
        _setFlag(methodVisitor, context, i);
        methodVisitor.visitVarInsn(21, context.var("matchedCount"));
        methodVisitor.visitInsn(4);
        methodVisitor.visitInsn(96);
        methodVisitor.visitVarInsn(54, context.var("matchedCount"));
        _deserObject(context, methodVisitor, fieldInfo, cls, i);
        methodVisitor.visitVarInsn(25, 1);
        methodVisitor.visitMethodInsn(182, DefaultJSONParser, "getResolveStatus", "()I");
        methodVisitor.visitFieldInsn(178, DefaultJSONParser, "NeedToResolve", "I");
        methodVisitor.visitJumpInsn(160, label3);
        methodVisitor.visitVarInsn(25, 1);
        String str2 = DefaultJSONParser;
        methodVisitor.visitMethodInsn(182, str2, "getLastResolveTask", "()" + ASMUtils.desc(DefaultJSONParser.ResolveTask.class));
        methodVisitor.visitVarInsn(58, context.var("resolveTask"));
        methodVisitor.visitVarInsn(25, context.var("resolveTask"));
        methodVisitor.visitVarInsn(25, 1);
        String str3 = DefaultJSONParser;
        methodVisitor.visitMethodInsn(182, str3, "getContext", "()" + ASMUtils.desc(ParseContext.class));
        methodVisitor.visitFieldInsn(181, ASMUtils.type(DefaultJSONParser.ResolveTask.class), "ownerContext", ASMUtils.desc(ParseContext.class));
        methodVisitor.visitVarInsn(25, context.var("resolveTask"));
        methodVisitor.visitVarInsn(25, 0);
        methodVisitor.visitLdcInsn(fieldInfo.name);
        String type = ASMUtils.type(ASMJavaBeanDeserializer.class);
        methodVisitor.visitMethodInsn(182, type, "getFieldDeserializer", "(Ljava/lang/String;)" + ASMUtils.desc(FieldDeserializer.class));
        methodVisitor.visitFieldInsn(181, ASMUtils.type(DefaultJSONParser.ResolveTask.class), "fieldDeserializer", ASMUtils.desc(FieldDeserializer.class));
        methodVisitor.visitVarInsn(25, 1);
        methodVisitor.visitFieldInsn(178, DefaultJSONParser, "NONE", "I");
        methodVisitor.visitMethodInsn(182, DefaultJSONParser, "setResolveStatus", "(I)V");
        methodVisitor.visitLabel(label3);
    }

    private void _getCollectionFieldItemDeser(Context context, MethodVisitor methodVisitor, FieldInfo fieldInfo, Class<?> cls) {
        Label label = new Label();
        methodVisitor.visitVarInsn(25, 0);
        String str = context.className;
        methodVisitor.visitFieldInsn(180, str, fieldInfo.name + "_asm_list_item_deser__", ASMUtils.desc(ObjectDeserializer.class));
        methodVisitor.visitJumpInsn(199, label);
        methodVisitor.visitVarInsn(25, 0);
        methodVisitor.visitVarInsn(25, 1);
        String str2 = DefaultJSONParser;
        methodVisitor.visitMethodInsn(182, str2, "getConfig", "()" + ASMUtils.desc(ParserConfig.class));
        methodVisitor.visitLdcInsn(Type.getType(ASMUtils.desc(cls)));
        String type = ASMUtils.type(ParserConfig.class);
        methodVisitor.visitMethodInsn(182, type, "getDeserializer", "(Ljava/lang/reflect/Type;)" + ASMUtils.desc(ObjectDeserializer.class));
        String str3 = context.className;
        methodVisitor.visitFieldInsn(181, str3, fieldInfo.name + "_asm_list_item_deser__", ASMUtils.desc(ObjectDeserializer.class));
        methodVisitor.visitLabel(label);
        methodVisitor.visitVarInsn(25, 0);
        String str4 = context.className;
        methodVisitor.visitFieldInsn(180, str4, fieldInfo.name + "_asm_list_item_deser__", ASMUtils.desc(ObjectDeserializer.class));
    }

    private void _getFieldDeser(Context context, MethodVisitor methodVisitor, FieldInfo fieldInfo) {
        Label label = new Label();
        methodVisitor.visitVarInsn(25, 0);
        String str = context.className;
        methodVisitor.visitFieldInsn(180, str, fieldInfo.name + "_asm_deser__", ASMUtils.desc(ObjectDeserializer.class));
        methodVisitor.visitJumpInsn(199, label);
        methodVisitor.visitVarInsn(25, 0);
        methodVisitor.visitVarInsn(25, 1);
        String str2 = DefaultJSONParser;
        methodVisitor.visitMethodInsn(182, str2, "getConfig", "()" + ASMUtils.desc(ParserConfig.class));
        methodVisitor.visitLdcInsn(Type.getType(ASMUtils.desc(fieldInfo.fieldClass)));
        String type = ASMUtils.type(ParserConfig.class);
        methodVisitor.visitMethodInsn(182, type, "getDeserializer", "(Ljava/lang/reflect/Type;)" + ASMUtils.desc(ObjectDeserializer.class));
        String str3 = context.className;
        methodVisitor.visitFieldInsn(181, str3, fieldInfo.name + "_asm_deser__", ASMUtils.desc(ObjectDeserializer.class));
        methodVisitor.visitLabel(label);
        methodVisitor.visitVarInsn(25, 0);
        String str4 = context.className;
        methodVisitor.visitFieldInsn(180, str4, fieldInfo.name + "_asm_deser__", ASMUtils.desc(ObjectDeserializer.class));
    }

    private void _init(ClassWriter classWriter, Context context) {
        int length = context.fieldInfoList.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                break;
            }
            FieldInfo fieldInfo = context.fieldInfoList[i2];
            new FieldWriter(classWriter, 1, fieldInfo.name + "_asm_prefix__", "[C").visitEnd();
            i = i2 + 1;
        }
        int length2 = context.fieldInfoList.length;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= length2) {
                break;
            }
            FieldInfo fieldInfo2 = context.fieldInfoList[i4];
            Class<?> cls = fieldInfo2.fieldClass;
            if (!cls.isPrimitive() && !cls.isEnum()) {
                if (Collection.class.isAssignableFrom(cls)) {
                    new FieldWriter(classWriter, 1, fieldInfo2.name + "_asm_list_item_deser__", ASMUtils.desc(ObjectDeserializer.class)).visitEnd();
                } else {
                    new FieldWriter(classWriter, 1, fieldInfo2.name + "_asm_deser__", ASMUtils.desc(ObjectDeserializer.class)).visitEnd();
                }
            }
            i3 = i4 + 1;
        }
        MethodWriter methodWriter = new MethodWriter(classWriter, 1, "<init>", "(" + ASMUtils.desc(ParserConfig.class) + "Ljava/lang/Class;)V", null, null);
        methodWriter.visitVarInsn(25, 0);
        methodWriter.visitVarInsn(25, 1);
        methodWriter.visitVarInsn(25, 2);
        String type = ASMUtils.type(ASMJavaBeanDeserializer.class);
        methodWriter.visitMethodInsn(183, type, "<init>", "(" + ASMUtils.desc(ParserConfig.class) + "Ljava/lang/Class;)V");
        int length3 = context.fieldInfoList.length;
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 >= length3) {
                methodWriter.visitInsn(177);
                methodWriter.visitMaxs(4, 4);
                methodWriter.visitEnd();
                return;
            }
            FieldInfo fieldInfo3 = context.fieldInfoList[i6];
            methodWriter.visitVarInsn(25, 0);
            methodWriter.visitLdcInsn("\"" + fieldInfo3.name + "\":");
            methodWriter.visitMethodInsn(182, "java/lang/String", "toCharArray", "()[C");
            String str = context.className;
            methodWriter.visitFieldInsn(181, str, fieldInfo3.name + "_asm_prefix__", "[C");
            i5 = i6 + 1;
        }
    }

    private void _isEnable(Context context, MethodVisitor methodVisitor, Feature feature) {
        methodVisitor.visitVarInsn(25, context.var("lexer"));
        methodVisitor.visitFieldInsn(178, ASMUtils.type(Feature.class), feature.name(), ASMUtils.desc(Feature.class));
        String str = JSONLexerBase;
        methodVisitor.visitMethodInsn(182, str, "isEnabled", "(" + ASMUtils.desc(Feature.class) + ")Z");
    }

    private void _loadAndSet(Context context, MethodVisitor methodVisitor, FieldInfo fieldInfo) {
        Class<?> cls = fieldInfo.fieldClass;
        java.lang.reflect.Type type = fieldInfo.fieldType;
        if (cls == Boolean.TYPE) {
            methodVisitor.visitVarInsn(25, context.var("instance"));
            methodVisitor.visitVarInsn(21, context.var(fieldInfo.name + "_asm"));
            _set(context, methodVisitor, fieldInfo);
        } else if (cls == Byte.TYPE || cls == Short.TYPE || cls == Integer.TYPE || cls == Character.TYPE) {
            methodVisitor.visitVarInsn(25, context.var("instance"));
            methodVisitor.visitVarInsn(21, context.var(fieldInfo.name + "_asm"));
            _set(context, methodVisitor, fieldInfo);
        } else if (cls == Long.TYPE) {
            methodVisitor.visitVarInsn(25, context.var("instance"));
            methodVisitor.visitVarInsn(22, context.var(fieldInfo.name + "_asm", 2));
            if (fieldInfo.method == null) {
                methodVisitor.visitFieldInsn(181, ASMUtils.type(fieldInfo.declaringClass), fieldInfo.field.getName(), ASMUtils.desc(fieldInfo.fieldClass));
                return;
            }
            methodVisitor.visitMethodInsn(182, ASMUtils.type(context.getInstClass()), fieldInfo.method.getName(), ASMUtils.desc(fieldInfo.method));
            if (fieldInfo.method.getReturnType().equals(Void.TYPE)) {
                return;
            }
            methodVisitor.visitInsn(87);
        } else if (cls == Float.TYPE) {
            methodVisitor.visitVarInsn(25, context.var("instance"));
            methodVisitor.visitVarInsn(23, context.var(fieldInfo.name + "_asm"));
            _set(context, methodVisitor, fieldInfo);
        } else if (cls == Double.TYPE) {
            methodVisitor.visitVarInsn(25, context.var("instance"));
            methodVisitor.visitVarInsn(24, context.var(fieldInfo.name + "_asm", 2));
            _set(context, methodVisitor, fieldInfo);
        } else if (cls == String.class) {
            methodVisitor.visitVarInsn(25, context.var("instance"));
            methodVisitor.visitVarInsn(25, context.var(fieldInfo.name + "_asm"));
            _set(context, methodVisitor, fieldInfo);
        } else if (cls.isEnum()) {
            methodVisitor.visitVarInsn(25, context.var("instance"));
            methodVisitor.visitVarInsn(25, context.var(fieldInfo.name + "_asm"));
            _set(context, methodVisitor, fieldInfo);
        } else if (!Collection.class.isAssignableFrom(cls)) {
            methodVisitor.visitVarInsn(25, context.var("instance"));
            methodVisitor.visitVarInsn(25, context.var(fieldInfo.name + "_asm"));
            _set(context, methodVisitor, fieldInfo);
        } else {
            methodVisitor.visitVarInsn(25, context.var("instance"));
            if (TypeUtils.getCollectionItemClass(type) == String.class) {
                methodVisitor.visitVarInsn(25, context.var(fieldInfo.name + "_asm"));
                methodVisitor.visitTypeInsn(192, ASMUtils.type(cls));
            } else {
                methodVisitor.visitVarInsn(25, context.var(fieldInfo.name + "_asm"));
            }
            _set(context, methodVisitor, fieldInfo);
        }
    }

    private void _newCollection(MethodVisitor methodVisitor, Class<?> cls, int i, boolean z) {
        if (cls.isAssignableFrom(ArrayList.class) && !z) {
            methodVisitor.visitTypeInsn(187, "java/util/ArrayList");
            methodVisitor.visitInsn(89);
            methodVisitor.visitMethodInsn(183, "java/util/ArrayList", "<init>", "()V");
        } else if (cls.isAssignableFrom(LinkedList.class) && !z) {
            methodVisitor.visitTypeInsn(187, ASMUtils.type(LinkedList.class));
            methodVisitor.visitInsn(89);
            methodVisitor.visitMethodInsn(183, ASMUtils.type(LinkedList.class), "<init>", "()V");
        } else if (cls.isAssignableFrom(HashSet.class)) {
            methodVisitor.visitTypeInsn(187, ASMUtils.type(HashSet.class));
            methodVisitor.visitInsn(89);
            methodVisitor.visitMethodInsn(183, ASMUtils.type(HashSet.class), "<init>", "()V");
        } else if (cls.isAssignableFrom(TreeSet.class)) {
            methodVisitor.visitTypeInsn(187, ASMUtils.type(TreeSet.class));
            methodVisitor.visitInsn(89);
            methodVisitor.visitMethodInsn(183, ASMUtils.type(TreeSet.class), "<init>", "()V");
        } else if (cls.isAssignableFrom(LinkedHashSet.class)) {
            methodVisitor.visitTypeInsn(187, ASMUtils.type(LinkedHashSet.class));
            methodVisitor.visitInsn(89);
            methodVisitor.visitMethodInsn(183, ASMUtils.type(LinkedHashSet.class), "<init>", "()V");
        } else if (z) {
            methodVisitor.visitTypeInsn(187, ASMUtils.type(HashSet.class));
            methodVisitor.visitInsn(89);
            methodVisitor.visitMethodInsn(183, ASMUtils.type(HashSet.class), "<init>", "()V");
        } else {
            methodVisitor.visitVarInsn(25, 0);
            methodVisitor.visitLdcInsn(Integer.valueOf(i));
            methodVisitor.visitMethodInsn(182, ASMUtils.type(ASMJavaBeanDeserializer.class), "getFieldType", "(I)Ljava/lang/reflect/Type;");
            methodVisitor.visitMethodInsn(184, ASMUtils.type(TypeUtils.class), "createCollection", "(Ljava/lang/reflect/Type;)Ljava/util/Collection;");
        }
        methodVisitor.visitTypeInsn(192, ASMUtils.type(cls));
    }

    private void _set(Context context, MethodVisitor methodVisitor, FieldInfo fieldInfo) {
        if (fieldInfo.method == null) {
            methodVisitor.visitFieldInsn(181, ASMUtils.type(fieldInfo.declaringClass), fieldInfo.field.getName(), ASMUtils.desc(fieldInfo.fieldClass));
            return;
        }
        methodVisitor.visitMethodInsn(182, ASMUtils.type(fieldInfo.declaringClass), fieldInfo.method.getName(), ASMUtils.desc(fieldInfo.method));
        if (fieldInfo.method.getReturnType().equals(Void.TYPE)) {
            return;
        }
        methodVisitor.visitInsn(87);
    }

    private void _setContext(Context context, MethodVisitor methodVisitor) {
        methodVisitor.visitVarInsn(25, 1);
        methodVisitor.visitVarInsn(25, context.var("context"));
        String str = DefaultJSONParser;
        methodVisitor.visitMethodInsn(182, str, "setContext", "(" + ASMUtils.desc(ParseContext.class) + ")V");
        Label label = new Label();
        methodVisitor.visitVarInsn(25, context.var("childContext"));
        methodVisitor.visitJumpInsn(198, label);
        methodVisitor.visitVarInsn(25, context.var("childContext"));
        methodVisitor.visitVarInsn(25, context.var("instance"));
        methodVisitor.visitFieldInsn(181, ASMUtils.type(ParseContext.class), "object", "Ljava/lang/Object;");
        methodVisitor.visitLabel(label);
    }

    private Class<?> defineClassPublic(String str, byte[] bArr, int i, int i2) {
        return this.classLoader.defineClassPublic(str, bArr, i, i2);
    }

    private void defineVarLexer(Context context, MethodVisitor methodVisitor) {
        methodVisitor.visitVarInsn(25, 1);
        methodVisitor.visitFieldInsn(180, DefaultJSONParser, "lexer", ASMUtils.desc(JSONLexer.class));
        methodVisitor.visitTypeInsn(192, JSONLexerBase);
        methodVisitor.visitVarInsn(58, context.var("lexer"));
    }

    void _deserialze(ClassWriter classWriter, Context context) {
        FieldInfo fieldInfo;
        if (context.fieldInfoList.length == 0) {
            return;
        }
        FieldInfo[] fieldInfoArr = context.fieldInfoList;
        int length = fieldInfoArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                context.fieldInfoList = context.beanInfo.sortedFields;
                MethodWriter methodWriter = new MethodWriter(classWriter, 1, "deserialze", "(L" + DefaultJSONParser + ";Ljava/lang/reflect/Type;Ljava/lang/Object;)Ljava/lang/Object;", null, null);
                Label label = new Label();
                Label label2 = new Label();
                Label label3 = new Label();
                Label label4 = new Label();
                defineVarLexer(context, methodWriter);
                _isEnable(context, methodWriter, Feature.SortFeidFastMatch);
                methodWriter.visitJumpInsn(153, label2);
                Label label5 = new Label();
                methodWriter.visitVarInsn(25, 0);
                methodWriter.visitVarInsn(25, context.var("lexer"));
                methodWriter.visitMethodInsn(183, ASMUtils.type(ASMJavaBeanDeserializer.class), "isSupportArrayToBean", "(" + ASMUtils.desc(JSONLexer.class) + ")Z");
                methodWriter.visitJumpInsn(153, label5);
                methodWriter.visitVarInsn(25, context.var("lexer"));
                methodWriter.visitMethodInsn(182, JSONLexerBase, "token", "()I");
                methodWriter.visitFieldInsn(178, JSONToken, "LBRACKET", "I");
                methodWriter.visitJumpInsn(160, label5);
                methodWriter.visitVarInsn(25, 0);
                methodWriter.visitVarInsn(25, 1);
                methodWriter.visitVarInsn(25, 2);
                methodWriter.visitVarInsn(25, 3);
                methodWriter.visitMethodInsn(183, context.className, "deserialzeArrayMapping", "(L" + DefaultJSONParser + ";Ljava/lang/reflect/Type;Ljava/lang/Object;)Ljava/lang/Object;");
                methodWriter.visitInsn(176);
                methodWriter.visitLabel(label5);
                methodWriter.visitVarInsn(25, context.var("lexer"));
                methodWriter.visitLdcInsn(context.clazz.getName());
                methodWriter.visitMethodInsn(182, JSONLexerBase, "scanType", "(Ljava/lang/String;)I");
                methodWriter.visitFieldInsn(178, JSONLexerBase, "NOT_MATCH", "I");
                methodWriter.visitJumpInsn(159, label2);
                methodWriter.visitVarInsn(25, 1);
                methodWriter.visitMethodInsn(182, DefaultJSONParser, "getContext", "()" + ASMUtils.desc(ParseContext.class));
                methodWriter.visitVarInsn(58, context.var("mark_context"));
                methodWriter.visitInsn(3);
                methodWriter.visitVarInsn(54, context.var("matchedCount"));
                _createInstance(context, methodWriter);
                methodWriter.visitVarInsn(25, 1);
                methodWriter.visitMethodInsn(182, DefaultJSONParser, "getContext", "()" + ASMUtils.desc(ParseContext.class));
                methodWriter.visitVarInsn(58, context.var("context"));
                methodWriter.visitVarInsn(25, 1);
                methodWriter.visitVarInsn(25, context.var("context"));
                methodWriter.visitVarInsn(25, context.var("instance"));
                methodWriter.visitVarInsn(25, 3);
                methodWriter.visitMethodInsn(182, DefaultJSONParser, "setContext", "(" + ASMUtils.desc(ParseContext.class) + "Ljava/lang/Object;Ljava/lang/Object;)" + ASMUtils.desc(ParseContext.class));
                methodWriter.visitVarInsn(58, context.var("childContext"));
                methodWriter.visitVarInsn(25, context.var("lexer"));
                methodWriter.visitFieldInsn(180, JSONLexerBase, "matchStat", "I");
                methodWriter.visitFieldInsn(178, JSONLexerBase, "END", "I");
                methodWriter.visitJumpInsn(159, label3);
                methodWriter.visitInsn(3);
                methodWriter.visitIntInsn(54, context.var("matchStat"));
                int length2 = context.fieldInfoList.length;
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 >= length2) {
                        break;
                    }
                    methodWriter.visitInsn(3);
                    methodWriter.visitVarInsn(54, context.var("_asm_flag_" + (i4 / 32)));
                    i3 = i4 + 32;
                }
                _isEnable(context, methodWriter, Feature.InitStringFieldAsEmpty);
                methodWriter.visitIntInsn(54, context.var("initStringFieldAsEmpty"));
                for (int i5 = 0; i5 < length2; i5++) {
                    Class<?> cls = context.fieldInfoList[i5].fieldClass;
                    if (cls == Boolean.TYPE || cls == Byte.TYPE || cls == Short.TYPE || cls == Integer.TYPE) {
                        methodWriter.visitInsn(3);
                        methodWriter.visitVarInsn(54, context.var(fieldInfo.name + "_asm"));
                    } else if (cls == Long.TYPE) {
                        methodWriter.visitInsn(9);
                        methodWriter.visitVarInsn(55, context.var(fieldInfo.name + "_asm", 2));
                    } else if (cls == Float.TYPE) {
                        methodWriter.visitInsn(11);
                        methodWriter.visitVarInsn(56, context.var(fieldInfo.name + "_asm"));
                    } else if (cls == Double.TYPE) {
                        methodWriter.visitInsn(14);
                        methodWriter.visitVarInsn(57, context.var(fieldInfo.name + "_asm", 2));
                    } else {
                        if (cls == String.class) {
                            Label label6 = new Label();
                            Label label7 = new Label();
                            methodWriter.visitVarInsn(21, context.var("initStringFieldAsEmpty"));
                            methodWriter.visitJumpInsn(153, label7);
                            _setFlag(methodWriter, context, i5);
                            methodWriter.visitVarInsn(25, context.var("lexer"));
                            methodWriter.visitMethodInsn(182, JSONLexerBase, "stringDefaultValue", "()Ljava/lang/String;");
                            methodWriter.visitJumpInsn(167, label6);
                            methodWriter.visitLabel(label7);
                            methodWriter.visitInsn(1);
                            methodWriter.visitLabel(label6);
                        } else {
                            methodWriter.visitInsn(1);
                        }
                        methodWriter.visitTypeInsn(192, ASMUtils.type(cls));
                        methodWriter.visitVarInsn(58, context.var(fieldInfo.name + "_asm"));
                    }
                }
                String str = "()";
                for (int i6 = 0; i6 < length2; i6++) {
                    FieldInfo fieldInfo2 = context.fieldInfoList[i6];
                    Class<?> cls2 = fieldInfo2.fieldClass;
                    java.lang.reflect.Type type = fieldInfo2.fieldType;
                    Label label8 = new Label();
                    if (cls2 == Boolean.TYPE) {
                        methodWriter.visitVarInsn(25, context.var("lexer"));
                        methodWriter.visitVarInsn(25, 0);
                        methodWriter.visitFieldInsn(180, context.className, fieldInfo2.name + "_asm_prefix__", "[C");
                        methodWriter.visitMethodInsn(182, JSONLexerBase, "scanFieldBoolean", "([C)Z");
                        methodWriter.visitVarInsn(54, context.var(fieldInfo2.name + "_asm"));
                    } else if (cls2 == Byte.TYPE) {
                        methodWriter.visitVarInsn(25, context.var("lexer"));
                        methodWriter.visitVarInsn(25, 0);
                        methodWriter.visitFieldInsn(180, context.className, fieldInfo2.name + "_asm_prefix__", "[C");
                        methodWriter.visitMethodInsn(182, JSONLexerBase, "scanFieldInt", "([C)I");
                        methodWriter.visitVarInsn(54, context.var(fieldInfo2.name + "_asm"));
                    } else if (cls2 == Short.TYPE) {
                        methodWriter.visitVarInsn(25, context.var("lexer"));
                        methodWriter.visitVarInsn(25, 0);
                        methodWriter.visitFieldInsn(180, context.className, fieldInfo2.name + "_asm_prefix__", "[C");
                        methodWriter.visitMethodInsn(182, JSONLexerBase, "scanFieldInt", "([C)I");
                        methodWriter.visitVarInsn(54, context.var(fieldInfo2.name + "_asm"));
                    } else if (cls2 == Integer.TYPE) {
                        methodWriter.visitVarInsn(25, context.var("lexer"));
                        methodWriter.visitVarInsn(25, 0);
                        methodWriter.visitFieldInsn(180, context.className, fieldInfo2.name + "_asm_prefix__", "[C");
                        methodWriter.visitMethodInsn(182, JSONLexerBase, "scanFieldInt", "([C)I");
                        methodWriter.visitVarInsn(54, context.var(fieldInfo2.name + "_asm"));
                    } else if (cls2 == Long.TYPE) {
                        methodWriter.visitVarInsn(25, context.var("lexer"));
                        methodWriter.visitVarInsn(25, 0);
                        methodWriter.visitFieldInsn(180, context.className, fieldInfo2.name + "_asm_prefix__", "[C");
                        methodWriter.visitMethodInsn(182, JSONLexerBase, "scanFieldLong", "([C)J");
                        methodWriter.visitVarInsn(55, context.var(fieldInfo2.name + "_asm", 2));
                    } else if (cls2 == Float.TYPE) {
                        methodWriter.visitVarInsn(25, context.var("lexer"));
                        methodWriter.visitVarInsn(25, 0);
                        methodWriter.visitFieldInsn(180, context.className, fieldInfo2.name + "_asm_prefix__", "[C");
                        methodWriter.visitMethodInsn(182, JSONLexerBase, "scanFieldFloat", "([C)F");
                        methodWriter.visitVarInsn(56, context.var(fieldInfo2.name + "_asm"));
                    } else if (cls2 == Double.TYPE) {
                        methodWriter.visitVarInsn(25, context.var("lexer"));
                        methodWriter.visitVarInsn(25, 0);
                        methodWriter.visitFieldInsn(180, context.className, fieldInfo2.name + "_asm_prefix__", "[C");
                        methodWriter.visitMethodInsn(182, JSONLexerBase, "scanFieldDouble", "([C)D");
                        methodWriter.visitVarInsn(57, context.var(fieldInfo2.name + "_asm", 2));
                    } else if (cls2 == String.class) {
                        methodWriter.visitVarInsn(25, context.var("lexer"));
                        methodWriter.visitVarInsn(25, 0);
                        methodWriter.visitFieldInsn(180, context.className, fieldInfo2.name + "_asm_prefix__", "[C");
                        methodWriter.visitMethodInsn(182, JSONLexerBase, "scanFieldString", "([C)Ljava/lang/String;");
                        methodWriter.visitVarInsn(58, context.var(fieldInfo2.name + "_asm"));
                    } else if (cls2.isEnum()) {
                        methodWriter.visitVarInsn(25, context.var("lexer"));
                        methodWriter.visitVarInsn(25, 0);
                        methodWriter.visitFieldInsn(180, context.className, fieldInfo2.name + "_asm_prefix__", "[C");
                        Label label9 = new Label();
                        methodWriter.visitInsn(1);
                        methodWriter.visitTypeInsn(192, ASMUtils.type(cls2));
                        methodWriter.visitVarInsn(58, context.var(fieldInfo2.name + "_asm"));
                        methodWriter.visitVarInsn(25, 1);
                        methodWriter.visitMethodInsn(182, DefaultJSONParser, "getSymbolTable", str + ASMUtils.desc(SymbolTable.class));
                        methodWriter.visitMethodInsn(182, JSONLexerBase, "scanFieldSymbol", "([C" + ASMUtils.desc(SymbolTable.class) + ")Ljava/lang/String;");
                        methodWriter.visitInsn(89);
                        methodWriter.visitVarInsn(58, context.var(fieldInfo2.name + "_asm_enumName"));
                        methodWriter.visitJumpInsn(198, label9);
                        methodWriter.visitVarInsn(25, context.var(fieldInfo2.name + "_asm_enumName"));
                        methodWriter.visitMethodInsn(184, ASMUtils.type(cls2), "valueOf", "(Ljava/lang/String;)" + ASMUtils.desc(cls2));
                        methodWriter.visitVarInsn(58, context.var(fieldInfo2.name + "_asm"));
                        methodWriter.visitLabel(label9);
                    } else {
                        if (Collection.class.isAssignableFrom(cls2)) {
                            methodWriter.visitVarInsn(25, context.var("lexer"));
                            methodWriter.visitVarInsn(25, 0);
                            methodWriter.visitFieldInsn(180, context.className, fieldInfo2.name + "_asm_prefix__", "[C");
                            Class<?> collectionItemClass = TypeUtils.getCollectionItemClass(type);
                            if (collectionItemClass == String.class) {
                                methodWriter.visitLdcInsn(Type.getType(ASMUtils.desc(cls2)));
                                methodWriter.visitMethodInsn(182, JSONLexerBase, "scanFieldStringArray", "([CLjava/lang/Class;)" + ASMUtils.desc(Collection.class));
                                methodWriter.visitVarInsn(58, context.var(fieldInfo2.name + "_asm"));
                            } else {
                                String str2 = str;
                                _deserialze_list_obj(context, methodWriter, label, fieldInfo2, cls2, collectionItemClass, i6);
                                str = str2;
                                if (i6 == length2 - 1) {
                                    _deserialize_endCheck(context, methodWriter, label);
                                    str = str2;
                                }
                            }
                        } else {
                            String str3 = str;
                            _deserialze_obj(context, methodWriter, label, fieldInfo2, cls2, i6);
                            str = str3;
                            if (i6 == length2 - 1) {
                                _deserialize_endCheck(context, methodWriter, label);
                                str = str3;
                            }
                        }
                    }
                    methodWriter.visitVarInsn(25, context.var("lexer"));
                    methodWriter.visitFieldInsn(180, JSONLexerBase, "matchStat", "I");
                    Label label10 = new Label();
                    methodWriter.visitJumpInsn(158, label10);
                    _setFlag(methodWriter, context, i6);
                    methodWriter.visitLabel(label10);
                    methodWriter.visitVarInsn(25, context.var("lexer"));
                    methodWriter.visitFieldInsn(180, JSONLexerBase, "matchStat", "I");
                    methodWriter.visitInsn(89);
                    methodWriter.visitVarInsn(54, context.var("matchStat"));
                    methodWriter.visitFieldInsn(178, JSONLexerBase, "NOT_MATCH", "I");
                    methodWriter.visitJumpInsn(159, label);
                    methodWriter.visitVarInsn(25, context.var("lexer"));
                    methodWriter.visitFieldInsn(180, JSONLexerBase, "matchStat", "I");
                    methodWriter.visitJumpInsn(158, label8);
                    methodWriter.visitVarInsn(21, context.var("matchedCount"));
                    methodWriter.visitInsn(4);
                    methodWriter.visitInsn(96);
                    methodWriter.visitVarInsn(54, context.var("matchedCount"));
                    methodWriter.visitVarInsn(25, context.var("lexer"));
                    methodWriter.visitFieldInsn(180, JSONLexerBase, "matchStat", "I");
                    methodWriter.visitFieldInsn(178, JSONLexerBase, "END", "I");
                    methodWriter.visitJumpInsn(159, label4);
                    methodWriter.visitLabel(label8);
                    if (i6 == length2 - 1) {
                        methodWriter.visitVarInsn(25, context.var("lexer"));
                        methodWriter.visitFieldInsn(180, JSONLexerBase, "matchStat", "I");
                        methodWriter.visitFieldInsn(178, JSONLexerBase, "END", "I");
                        methodWriter.visitJumpInsn(160, label);
                    }
                }
                methodWriter.visitLabel(label4);
                if (!context.clazz.isInterface() && !Modifier.isAbstract(context.clazz.getModifiers())) {
                    _batchSet(context, methodWriter);
                }
                methodWriter.visitLabel(label3);
                _setContext(context, methodWriter);
                methodWriter.visitVarInsn(25, context.var("instance"));
                Method method = context.beanInfo.buildMethod;
                if (method != null) {
                    methodWriter.visitMethodInsn(182, ASMUtils.type(context.getInstClass()), method.getName(), str + ASMUtils.desc(method.getReturnType()));
                }
                methodWriter.visitInsn(176);
                methodWriter.visitLabel(label);
                _batchSet(context, methodWriter);
                methodWriter.visitVarInsn(25, 0);
                methodWriter.visitVarInsn(25, 1);
                methodWriter.visitVarInsn(25, 2);
                methodWriter.visitVarInsn(25, 3);
                methodWriter.visitVarInsn(25, context.var("instance"));
                methodWriter.visitMethodInsn(182, ASMUtils.type(ASMJavaBeanDeserializer.class), "parseRest", "(L" + DefaultJSONParser + ";Ljava/lang/reflect/Type;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;");
                methodWriter.visitTypeInsn(192, ASMUtils.type(context.clazz));
                methodWriter.visitInsn(176);
                methodWriter.visitLabel(label2);
                methodWriter.visitVarInsn(25, 0);
                methodWriter.visitVarInsn(25, 1);
                methodWriter.visitVarInsn(25, 2);
                methodWriter.visitVarInsn(25, 3);
                methodWriter.visitMethodInsn(183, ASMUtils.type(ASMJavaBeanDeserializer.class), "deserialze", "(L" + DefaultJSONParser + ";Ljava/lang/reflect/Type;Ljava/lang/Object;)Ljava/lang/Object;");
                methodWriter.visitInsn(176);
                methodWriter.visitMaxs(5, context.variantIndex);
                methodWriter.visitEnd();
                return;
            }
            FieldInfo fieldInfo3 = fieldInfoArr[i2];
            Class<?> cls3 = fieldInfo3.fieldClass;
            java.lang.reflect.Type type2 = fieldInfo3.fieldType;
            if (cls3 == Character.TYPE) {
                return;
            }
            if (Collection.class.isAssignableFrom(cls3) && (!(type2 instanceof ParameterizedType) || !(((ParameterizedType) type2).getActualTypeArguments()[0] instanceof Class))) {
                return;
            }
            i = i2 + 1;
        }
    }

    void _deserialzeArrayMapping(ClassWriter classWriter, Context context) {
        MethodWriter methodWriter = new MethodWriter(classWriter, 1, "deserialzeArrayMapping", "(L" + DefaultJSONParser + ";Ljava/lang/reflect/Type;Ljava/lang/Object;)Ljava/lang/Object;", null, null);
        defineVarLexer(context, methodWriter);
        _createInstance(context, methodWriter);
        FieldInfo[] fieldInfoArr = context.beanInfo.sortedFields;
        int length = fieldInfoArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                _batchSet(context, methodWriter, false);
                methodWriter.visitVarInsn(25, context.var("lexer"));
                methodWriter.visitFieldInsn(178, JSONToken, "COMMA", "I");
                methodWriter.visitMethodInsn(182, JSONLexerBase, "nextToken", "(I)V");
                methodWriter.visitVarInsn(25, context.var("instance"));
                methodWriter.visitInsn(176);
                methodWriter.visitMaxs(5, context.variantIndex);
                methodWriter.visitEnd();
                return;
            }
            boolean z = i2 == length - 1;
            int i3 = z ? 93 : 44;
            FieldInfo fieldInfo = fieldInfoArr[i2];
            Class<?> cls = fieldInfo.fieldClass;
            java.lang.reflect.Type type = fieldInfo.fieldType;
            if (cls == Byte.TYPE || cls == Short.TYPE || cls == Integer.TYPE) {
                methodWriter.visitVarInsn(25, context.var("lexer"));
                methodWriter.visitVarInsn(16, i3);
                methodWriter.visitMethodInsn(182, JSONLexerBase, "scanInt", "(C)I");
                methodWriter.visitVarInsn(54, context.var(fieldInfo.name + "_asm"));
            } else if (cls == Long.TYPE) {
                methodWriter.visitVarInsn(25, context.var("lexer"));
                methodWriter.visitVarInsn(16, i3);
                methodWriter.visitMethodInsn(182, JSONLexerBase, "scanLong", "(C)J");
                methodWriter.visitVarInsn(55, context.var(fieldInfo.name + "_asm", 2));
            } else if (cls == Boolean.TYPE) {
                methodWriter.visitVarInsn(25, context.var("lexer"));
                methodWriter.visitVarInsn(16, i3);
                methodWriter.visitMethodInsn(182, JSONLexerBase, "scanBoolean", "(C)Z");
                methodWriter.visitVarInsn(54, context.var(fieldInfo.name + "_asm"));
            } else if (cls == Float.TYPE) {
                methodWriter.visitVarInsn(25, context.var("lexer"));
                methodWriter.visitVarInsn(16, i3);
                methodWriter.visitMethodInsn(182, JSONLexerBase, "scanFloat", "(C)F");
                methodWriter.visitVarInsn(56, context.var(fieldInfo.name + "_asm"));
            } else if (cls == Double.TYPE) {
                methodWriter.visitVarInsn(25, context.var("lexer"));
                methodWriter.visitVarInsn(16, i3);
                methodWriter.visitMethodInsn(182, JSONLexerBase, "scanDouble", "(C)D");
                methodWriter.visitVarInsn(57, context.var(fieldInfo.name + "_asm", 2));
            } else if (cls == Character.TYPE) {
                methodWriter.visitVarInsn(25, context.var("lexer"));
                methodWriter.visitVarInsn(16, i3);
                methodWriter.visitMethodInsn(182, JSONLexerBase, "scanString", "(C)Ljava/lang/String;");
                methodWriter.visitInsn(3);
                methodWriter.visitMethodInsn(182, "java/lang/String", "charAt", "(I)C");
                methodWriter.visitVarInsn(54, context.var(fieldInfo.name + "_asm"));
            } else if (cls == String.class) {
                methodWriter.visitVarInsn(25, context.var("lexer"));
                methodWriter.visitVarInsn(16, i3);
                methodWriter.visitMethodInsn(182, JSONLexerBase, "scanString", "(C)Ljava/lang/String;");
                methodWriter.visitVarInsn(58, context.var(fieldInfo.name + "_asm"));
            } else if (cls.isEnum()) {
                methodWriter.visitVarInsn(25, context.var("lexer"));
                methodWriter.visitLdcInsn(Type.getType(ASMUtils.desc(cls)));
                methodWriter.visitVarInsn(25, 1);
                String str = DefaultJSONParser;
                methodWriter.visitMethodInsn(182, str, "getSymbolTable", "()" + ASMUtils.desc(SymbolTable.class));
                methodWriter.visitVarInsn(16, i3);
                String str2 = JSONLexerBase;
                methodWriter.visitMethodInsn(182, str2, "scanEnum", "(Ljava/lang/Class;" + ASMUtils.desc(SymbolTable.class) + "C)Ljava/lang/Enum;");
                methodWriter.visitTypeInsn(192, ASMUtils.type(cls));
                methodWriter.visitVarInsn(58, context.var(fieldInfo.name + "_asm"));
            } else if (Collection.class.isAssignableFrom(cls)) {
                Class<?> collectionItemClass = TypeUtils.getCollectionItemClass(type);
                if (collectionItemClass == String.class) {
                    methodWriter.visitVarInsn(25, context.var("lexer"));
                    methodWriter.visitLdcInsn(Type.getType(ASMUtils.desc(cls)));
                    methodWriter.visitVarInsn(16, i3);
                    methodWriter.visitMethodInsn(182, JSONLexerBase, "scanStringArray", "(Ljava/lang/Class;C)Ljava/util/Collection;");
                    methodWriter.visitVarInsn(58, context.var(fieldInfo.name + "_asm"));
                } else {
                    methodWriter.visitVarInsn(25, 1);
                    if (i2 == 0) {
                        methodWriter.visitFieldInsn(178, JSONToken, "LBRACKET", "I");
                    } else {
                        methodWriter.visitFieldInsn(178, JSONToken, "COMMA", "I");
                    }
                    methodWriter.visitFieldInsn(178, JSONToken, "LBRACKET", "I");
                    methodWriter.visitMethodInsn(182, DefaultJSONParser, "accept", "(II)V");
                    _newCollection(methodWriter, cls, i2, false);
                    methodWriter.visitInsn(89);
                    methodWriter.visitVarInsn(58, context.var(fieldInfo.name + "_asm"));
                    _getCollectionFieldItemDeser(context, methodWriter, fieldInfo, collectionItemClass);
                    methodWriter.visitVarInsn(25, 1);
                    methodWriter.visitLdcInsn(Type.getType(ASMUtils.desc(collectionItemClass)));
                    methodWriter.visitVarInsn(25, 3);
                    String type2 = ASMUtils.type(ASMUtils.class);
                    methodWriter.visitMethodInsn(184, type2, "parseArray", "(Ljava/util/Collection;" + ASMUtils.desc(ObjectDeserializer.class) + "L" + DefaultJSONParser + i.b + "Ljava/lang/reflect/Type;Ljava/lang/Object;)V");
                }
            } else if (cls.isArray()) {
                methodWriter.visitVarInsn(25, context.var("lexer"));
                methodWriter.visitFieldInsn(178, JSONToken, "LBRACKET", "I");
                methodWriter.visitMethodInsn(182, JSONLexerBase, "nextToken", "(I)V");
                methodWriter.visitVarInsn(25, 1);
                methodWriter.visitVarInsn(25, 0);
                methodWriter.visitLdcInsn(Integer.valueOf(i2));
                methodWriter.visitMethodInsn(182, ASMUtils.type(ASMJavaBeanDeserializer.class), "getFieldType", "(I)Ljava/lang/reflect/Type;");
                methodWriter.visitMethodInsn(182, DefaultJSONParser, "parseObject", "(Ljava/lang/reflect/Type;)Ljava/lang/Object;");
                methodWriter.visitTypeInsn(192, ASMUtils.type(cls));
                methodWriter.visitVarInsn(58, context.var(fieldInfo.name + "_asm"));
            } else {
                methodWriter.visitVarInsn(25, 1);
                if (i2 == 0) {
                    methodWriter.visitFieldInsn(178, JSONToken, "LBRACKET", "I");
                } else {
                    methodWriter.visitFieldInsn(178, JSONToken, "COMMA", "I");
                }
                methodWriter.visitFieldInsn(178, JSONToken, "LBRACKET", "I");
                methodWriter.visitMethodInsn(182, DefaultJSONParser, "accept", "(II)V");
                _deserObject(context, methodWriter, fieldInfo, cls, i2);
                methodWriter.visitVarInsn(25, 1);
                if (z) {
                    methodWriter.visitFieldInsn(178, JSONToken, "RBRACKET", "I");
                    methodWriter.visitFieldInsn(178, JSONToken, "EOF", "I");
                } else {
                    methodWriter.visitFieldInsn(178, JSONToken, "COMMA", "I");
                    methodWriter.visitFieldInsn(178, JSONToken, "LBRACKET", "I");
                }
                methodWriter.visitMethodInsn(182, DefaultJSONParser, "accept", "(II)V");
            }
            i = i2 + 1;
        }
    }

    void _isFlag(MethodVisitor methodVisitor, Context context, int i, Label label) {
        methodVisitor.visitVarInsn(21, context.var("_asm_flag_" + (i / 32)));
        methodVisitor.visitLdcInsn(Integer.valueOf(1 << i));
        methodVisitor.visitInsn(126);
        methodVisitor.visitJumpInsn(153, label);
    }

    void _setFlag(MethodVisitor methodVisitor, Context context, int i) {
        String str = "_asm_flag_" + (i / 32);
        methodVisitor.visitVarInsn(21, context.var(str));
        methodVisitor.visitLdcInsn(Integer.valueOf(1 << i));
        methodVisitor.visitInsn(128);
        methodVisitor.visitVarInsn(54, context.var(str));
    }

    public ObjectDeserializer createJavaBeanDeserializer(ParserConfig parserConfig, Class<?> cls, java.lang.reflect.Type type) throws Exception {
        String name;
        if (cls.isPrimitive()) {
            throw new IllegalArgumentException("not support type :" + cls.getName());
        }
        String str = "FastjsonASMDeserializer_" + this.seed.incrementAndGet() + BridgeUtil.UNDERLINE_STR + cls.getSimpleName();
        String str2 = name.replace('.', '/') + BridgeUtil.SPLIT_MARK + str;
        String str3 = ASMDeserializerFactory.class.getPackage().getName() + "." + str;
        ClassWriter classWriter = new ClassWriter();
        classWriter.visit(49, 33, str2, ASMUtils.type(ASMJavaBeanDeserializer.class), null);
        JavaBeanInfo build = JavaBeanInfo.build(cls, type);
        _init(classWriter, new Context(str2, parserConfig, build, 3));
        _createInstance(classWriter, new Context(str2, parserConfig, build, 3));
        _deserialze(classWriter, new Context(str2, parserConfig, build, 4));
        _deserialzeArrayMapping(classWriter, new Context(str2, parserConfig, build, 4));
        byte[] byteArray = classWriter.toByteArray();
        return (ObjectDeserializer) defineClassPublic(str3, byteArray, 0, byteArray.length).getConstructor(ParserConfig.class, Class.class).newInstance(parserConfig, cls);
    }
}
