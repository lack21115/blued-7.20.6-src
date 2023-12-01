package com.alibaba.fastjson.asm;

/* loaded from: source-6737240-dex2jar.jar:com/alibaba/fastjson/asm/ClassWriter.class */
public class ClassWriter {
    private int access;
    FieldWriter firstField;
    MethodWriter firstMethod;
    int index;
    private int interfaceCount;
    private int[] interfaces;
    Item[] items;
    final Item key;
    final Item key2;
    final Item key3;
    FieldWriter lastField;
    MethodWriter lastMethod;
    private int name;
    final ByteVector pool;
    private int superName;
    String thisName;
    int threshold;
    Item[] typeTable;
    int version;

    public ClassWriter() {
        this(0);
    }

    private ClassWriter(int i) {
        this.index = 1;
        this.pool = new ByteVector();
        Item[] itemArr = new Item[256];
        this.items = itemArr;
        this.threshold = (int) (itemArr.length * 0.75d);
        this.key = new Item();
        this.key2 = new Item();
        this.key3 = new Item();
    }

    private Item get(Item item) {
        Item item2;
        Item item3 = this.items[item.hashCode % this.items.length];
        while (true) {
            item2 = item3;
            if (item2 == null || (item2.type == item.type && item.isEqualTo(item2))) {
                break;
            }
            item3 = item2.next;
        }
        return item2;
    }

    private Item newString(String str) {
        this.key2.set(8, str, null, null);
        Item item = get(this.key2);
        Item item2 = item;
        if (item == null) {
            this.pool.put12(8, newUTF8(str));
            int i = this.index;
            this.index = i + 1;
            item2 = new Item(i, this.key2);
            put(item2);
        }
        return item2;
    }

    private void put(Item item) {
        if (this.index > this.threshold) {
            int length = this.items.length;
            int i = (length * 2) + 1;
            Item[] itemArr = new Item[i];
            while (true) {
                length--;
                if (length < 0) {
                    break;
                }
                Item item2 = this.items[length];
                while (true) {
                    Item item3 = item2;
                    if (item3 != null) {
                        int i2 = item3.hashCode % i;
                        Item item4 = item3.next;
                        item3.next = itemArr[i2];
                        itemArr[i2] = item3;
                        item2 = item4;
                    }
                }
            }
            this.items = itemArr;
            this.threshold = (int) (i * 0.75d);
        }
        int i3 = item.hashCode;
        Item[] itemArr2 = this.items;
        int length2 = i3 % itemArr2.length;
        item.next = itemArr2[length2];
        this.items[length2] = item;
    }

    public Item newClassItem(String str) {
        this.key2.set(7, str, null, null);
        Item item = get(this.key2);
        Item item2 = item;
        if (item == null) {
            this.pool.put12(7, newUTF8(str));
            int i = this.index;
            this.index = i + 1;
            item2 = new Item(i, this.key2);
            put(item2);
        }
        return item2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Item newConstItem(Object obj) {
        if (!(obj instanceof Integer)) {
            if (obj instanceof String) {
                return newString((String) obj);
            }
            if (obj instanceof Type) {
                Type type = (Type) obj;
                return newClassItem(type.sort == 10 ? type.getInternalName() : type.getDescriptor());
            }
            throw new IllegalArgumentException("value " + obj);
        }
        int intValue = ((Integer) obj).intValue();
        this.key.set(intValue);
        Item item = get(this.key);
        Item item2 = item;
        if (item == null) {
            this.pool.putByte(3).putInt(intValue);
            int i = this.index;
            this.index = i + 1;
            item2 = new Item(i, this.key);
            put(item2);
        }
        return item2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Item newFieldItem(String str, String str2, String str3) {
        this.key3.set(9, str, str2, str3);
        Item item = get(this.key3);
        Item item2 = item;
        if (item == null) {
            int i = newClassItem(str).index;
            this.pool.put12(9, i).putShort(newNameTypeItem(str2, str3).index);
            int i2 = this.index;
            this.index = i2 + 1;
            item2 = new Item(i2, this.key3);
            put(item2);
        }
        return item2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Item newMethodItem(String str, String str2, String str3, boolean z) {
        int i = z ? 11 : 10;
        this.key3.set(i, str, str2, str3);
        Item item = get(this.key3);
        Item item2 = item;
        if (item == null) {
            this.pool.put12(i, newClassItem(str).index).putShort(newNameTypeItem(str2, str3).index);
            int i2 = this.index;
            this.index = i2 + 1;
            item2 = new Item(i2, this.key3);
            put(item2);
        }
        return item2;
    }

    public Item newNameTypeItem(String str, String str2) {
        this.key2.set(12, str, str2, null);
        Item item = get(this.key2);
        Item item2 = item;
        if (item == null) {
            int newUTF8 = newUTF8(str);
            this.pool.put12(12, newUTF8).putShort(newUTF8(str2));
            int i = this.index;
            this.index = i + 1;
            item2 = new Item(i, this.key2);
            put(item2);
        }
        return item2;
    }

    public int newUTF8(String str) {
        this.key.set(1, str, null, null);
        Item item = get(this.key);
        Item item2 = item;
        if (item == null) {
            this.pool.putByte(1).putUTF8(str);
            int i = this.index;
            this.index = i + 1;
            item2 = new Item(i, this.key);
            put(item2);
        }
        return item2.index;
    }

    public byte[] toByteArray() {
        int i = (this.interfaceCount * 2) + 24;
        int i2 = 0;
        for (FieldWriter fieldWriter = this.firstField; fieldWriter != null; fieldWriter = fieldWriter.next) {
            i2++;
            i += fieldWriter.getSize();
        }
        int i3 = 0;
        for (MethodWriter methodWriter = this.firstMethod; methodWriter != null; methodWriter = methodWriter.next) {
            i3++;
            i += methodWriter.getSize();
        }
        ByteVector byteVector = new ByteVector(i + this.pool.length);
        byteVector.putInt(-889275714).putInt(this.version);
        byteVector.putShort(this.index).putByteArray(this.pool.data, 0, this.pool.length);
        byteVector.putShort(this.access & (-393217)).putShort(this.name).putShort(this.superName);
        byteVector.putShort(this.interfaceCount);
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i5 >= this.interfaceCount) {
                break;
            }
            byteVector.putShort(this.interfaces[i5]);
            i4 = i5 + 1;
        }
        byteVector.putShort(i2);
        FieldWriter fieldWriter2 = this.firstField;
        while (true) {
            FieldWriter fieldWriter3 = fieldWriter2;
            if (fieldWriter3 == null) {
                break;
            }
            fieldWriter3.put(byteVector);
            fieldWriter2 = fieldWriter3.next;
        }
        byteVector.putShort(i3);
        MethodWriter methodWriter2 = this.firstMethod;
        while (true) {
            MethodWriter methodWriter3 = methodWriter2;
            if (methodWriter3 == null) {
                byteVector.putShort(0);
                return byteVector.data;
            }
            methodWriter3.put(byteVector);
            methodWriter2 = methodWriter3.next;
        }
    }

    public void visit(int i, int i2, String str, String str2, String[] strArr) {
        this.version = i;
        this.access = i2;
        this.name = newClassItem(str).index;
        this.thisName = str;
        this.superName = str2 == null ? 0 : newClassItem(str2).index;
        if (strArr == null || strArr.length <= 0) {
            return;
        }
        int length = strArr.length;
        this.interfaceCount = length;
        this.interfaces = new int[length];
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= this.interfaceCount) {
                return;
            }
            this.interfaces[i4] = newClassItem(strArr[i4]).index;
            i3 = i4 + 1;
        }
    }
}
