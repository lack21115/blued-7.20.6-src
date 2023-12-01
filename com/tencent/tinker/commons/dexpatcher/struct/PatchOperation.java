package com.tencent.tinker.commons.dexpatcher.struct;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tinker/commons/dexpatcher/struct/PatchOperation.class */
public final class PatchOperation<T> {
    public static final int OP_ADD = 1;
    public static final int OP_DEL = 0;
    public static final int OP_REPLACE = 2;
    public int index;
    public T newItem;
    public int op;

    public PatchOperation(int i, int i2) {
        this(i, i2, null);
    }

    public PatchOperation(int i, int i2, T t) {
        this.op = i;
        this.index = i2;
        this.newItem = t;
    }

    public static String translateOpToString(int i) {
        return i != 0 ? i != 1 ? i != 2 ? "OP_UNKNOWN" : "OP_REPLACE" : "OP_ADD" : "OP_DEL";
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        String translateOpToString = translateOpToString(this.op);
        sb.append('{');
        sb.append("op: ");
        sb.append(translateOpToString);
        sb.append(", index: ");
        sb.append(this.index);
        sb.append(", newItem: ");
        sb.append(this.newItem);
        sb.append('}');
        return sb.toString();
    }
}
