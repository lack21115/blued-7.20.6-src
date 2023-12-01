package libcore.reflect;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import libcore.util.EmptyArray;

/* loaded from: source-2895416-dex2jar.jar:libcore/reflect/ListOfTypes.class */
public final class ListOfTypes {
    public static final ListOfTypes EMPTY = new ListOfTypes(0);
    private Type[] resolvedTypes;
    private final ArrayList<Type> types;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ListOfTypes(int i) {
        this.types = new ArrayList<>(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ListOfTypes(Type[] typeArr) {
        this.types = new ArrayList<>(typeArr.length);
        int length = typeArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            this.types.add(typeArr[i2]);
            i = i2 + 1;
        }
    }

    private Type[] resolveTypes(List<Type> list) {
        Type[] typeArr;
        int size = list.size();
        if (size != 0) {
            Type[] typeArr2 = new Type[size];
            int i = 0;
            while (true) {
                int i2 = i;
                typeArr = typeArr2;
                if (i2 >= size) {
                    break;
                }
                Type type = list.get(i2);
                try {
                    typeArr2[i2] = ((ParameterizedTypeImpl) type).getResolvedType();
                } catch (ClassCastException e) {
                    typeArr2[i2] = type;
                }
                i = i2 + 1;
            }
        } else {
            typeArr = EmptyArray.TYPE;
        }
        return typeArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void add(Type type) {
        if (type == null) {
            throw new NullPointerException("type == null");
        }
        this.types.add(type);
    }

    public Type[] getResolvedTypes() {
        Type[] typeArr = this.resolvedTypes;
        Type[] typeArr2 = typeArr;
        if (typeArr == null) {
            typeArr2 = resolveTypes(this.types);
            this.resolvedTypes = typeArr2;
        }
        return typeArr2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int length() {
        return this.types.size();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.types.size()) {
                return sb.toString();
            }
            if (i2 > 0) {
                sb.append(", ");
            }
            sb.append(this.types.get(i2));
            i = i2 + 1;
        }
    }
}
