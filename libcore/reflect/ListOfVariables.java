package libcore.reflect;

import java.lang.reflect.TypeVariable;
import java.util.ArrayList;

/* loaded from: source-2895416-dex2jar.jar:libcore/reflect/ListOfVariables.class */
final class ListOfVariables {
    final ArrayList<TypeVariable<?>> array = new ArrayList<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    public void add(TypeVariable<?> typeVariable) {
        this.array.add(typeVariable);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public TypeVariable<?>[] getArray() {
        return (TypeVariable[]) this.array.toArray(new TypeVariable[this.array.size()]);
    }
}
