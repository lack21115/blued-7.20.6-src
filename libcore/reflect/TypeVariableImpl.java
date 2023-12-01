package libcore.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

/* loaded from: source-2895416-dex2jar.jar:libcore/reflect/TypeVariableImpl.class */
public final class TypeVariableImpl<D extends GenericDeclaration> implements TypeVariable<D> {
    private ListOfTypes bounds;
    private final GenericDeclaration declOfVarUser;
    private TypeVariableImpl<D> formalVar;
    private D genericDeclaration;
    private final String name;

    /* JADX INFO: Access modifiers changed from: package-private */
    public TypeVariableImpl(D d, String str) {
        this.name = str;
        this.declOfVarUser = d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public TypeVariableImpl(D d, String str, ListOfTypes listOfTypes) {
        this.genericDeclaration = d;
        this.name = str;
        this.bounds = listOfTypes;
        this.formalVar = this;
        this.declOfVarUser = null;
    }

    static TypeVariable findFormalVar(GenericDeclaration genericDeclaration, String str) {
        TypeVariable<?>[] typeParameters = genericDeclaration.getTypeParameters();
        int length = typeParameters.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return null;
            }
            TypeVariable<?> typeVariable = typeParameters[i2];
            if (str.equals(typeVariable.getName())) {
                return typeVariable;
            }
            i = i2 + 1;
        }
    }

    private static GenericDeclaration nextLayer(GenericDeclaration genericDeclaration) {
        if (genericDeclaration instanceof Class) {
            Class cls = (Class) genericDeclaration;
            GenericDeclaration genericDeclaration2 = (GenericDeclaration) AnnotationAccess.getEnclosingMethodOrConstructor(cls);
            return genericDeclaration2 != null ? genericDeclaration2 : cls.getEnclosingClass();
        } else if (genericDeclaration instanceof Method) {
            return ((Method) genericDeclaration).getDeclaringClass();
        } else {
            if (genericDeclaration instanceof Constructor) {
                return ((Constructor) genericDeclaration).getDeclaringClass();
            }
            throw new AssertionError();
        }
    }

    public boolean equals(Object obj) {
        if (obj instanceof TypeVariable) {
            TypeVariable typeVariable = (TypeVariable) obj;
            return getName().equals(typeVariable.getName()) && getGenericDeclaration().equals(typeVariable.getGenericDeclaration());
        }
        return false;
    }

    @Override // java.lang.reflect.TypeVariable
    public Type[] getBounds() {
        resolve();
        return (Type[]) this.bounds.getResolvedTypes().clone();
    }

    @Override // java.lang.reflect.TypeVariable
    public D getGenericDeclaration() {
        resolve();
        return this.genericDeclaration;
    }

    @Override // java.lang.reflect.TypeVariable
    public String getName() {
        return this.name;
    }

    public int hashCode() {
        return (getName().hashCode() * 31) + getGenericDeclaration().hashCode();
    }

    void resolve() {
        GenericDeclaration nextLayer;
        if (this.formalVar != null) {
            return;
        }
        GenericDeclaration genericDeclaration = this.declOfVarUser;
        do {
            TypeVariable findFormalVar = findFormalVar(genericDeclaration, this.name);
            if (findFormalVar != null) {
                this.formalVar = (TypeVariableImpl) findFormalVar;
                this.genericDeclaration = this.formalVar.genericDeclaration;
                this.bounds = this.formalVar.bounds;
                return;
            }
            nextLayer = nextLayer(genericDeclaration);
            genericDeclaration = nextLayer;
        } while (nextLayer != null);
        throw new AssertionError("illegal type variable reference");
    }

    public String toString() {
        return this.name;
    }
}
