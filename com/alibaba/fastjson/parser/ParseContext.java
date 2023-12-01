package com.alibaba.fastjson.parser;

import java.lang.reflect.Type;

/* loaded from: source-6737240-dex2jar.jar:com/alibaba/fastjson/parser/ParseContext.class */
public class ParseContext {
    public final Object fieldName;
    public Object object;
    public final ParseContext parent;
    public Type type;

    public ParseContext(ParseContext parseContext, Object obj, Object obj2) {
        this.parent = parseContext;
        this.object = obj;
        this.fieldName = obj2;
    }

    public String toString() {
        if (this.parent == null) {
            return "$";
        }
        if (!(this.fieldName instanceof Integer)) {
            return this.parent.toString() + "." + this.fieldName;
        }
        return this.parent.toString() + "[" + this.fieldName + "]";
    }
}
