package libcore.reflect;

import com.j256.ormlite.stmt.query.SimpleComparison;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Objects;

/* loaded from: source-2895416-dex2jar.jar:libcore/reflect/ParameterizedTypeImpl.class */
public final class ParameterizedTypeImpl implements ParameterizedType {
    private final ListOfTypes args;
    private final ClassLoader loader;
    private final ParameterizedTypeImpl ownerType0;
    private Type ownerTypeRes;
    private Class rawType;
    private final String rawTypeName;

    public ParameterizedTypeImpl(ParameterizedTypeImpl parameterizedTypeImpl, String str, ListOfTypes listOfTypes, ClassLoader classLoader) {
        if (listOfTypes == null) {
            throw new NullPointerException();
        }
        this.ownerType0 = parameterizedTypeImpl;
        this.rawTypeName = str;
        this.args = listOfTypes;
        this.loader = classLoader;
    }

    public boolean equals(Object obj) {
        if (obj instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) obj;
            return Objects.equals(getRawType(), parameterizedType.getRawType()) && Objects.equals(getOwnerType(), parameterizedType.getOwnerType()) && Arrays.equals(this.args.getResolvedTypes(), parameterizedType.getActualTypeArguments());
        }
        return false;
    }

    @Override // java.lang.reflect.ParameterizedType
    public Type[] getActualTypeArguments() {
        return (Type[]) this.args.getResolvedTypes().clone();
    }

    @Override // java.lang.reflect.ParameterizedType
    public Type getOwnerType() {
        if (this.ownerTypeRes == null) {
            if (this.ownerType0 != null) {
                this.ownerTypeRes = this.ownerType0.getResolvedType();
            } else {
                this.ownerTypeRes = getRawType().getDeclaringClass();
            }
        }
        return this.ownerTypeRes;
    }

    @Override // java.lang.reflect.ParameterizedType
    public Class getRawType() {
        if (this.rawType == null) {
            try {
                this.rawType = Class.forName(this.rawTypeName, false, this.loader);
            } catch (ClassNotFoundException e) {
                throw new TypeNotPresentException(this.rawTypeName, e);
            }
        }
        return this.rawType;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Type getResolvedType() {
        Class cls = this;
        if (this.args.getResolvedTypes().length == 0) {
            cls = getRawType();
        }
        return cls;
    }

    public int hashCode() {
        return (((Objects.hashCode(getRawType()) * 31) + Objects.hashCode(getOwnerType())) * 31) + Arrays.hashCode(this.args.getResolvedTypes());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.rawTypeName);
        if (this.args.length() > 0) {
            sb.append(SimpleComparison.LESS_THAN_OPERATION).append(this.args).append(SimpleComparison.GREATER_THAN_OPERATION);
        }
        return sb.toString();
    }
}
