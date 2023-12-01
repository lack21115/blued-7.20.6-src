package libcore.reflect;

import java.lang.reflect.MalformedParameterizedTypeException;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.Arrays;

/* loaded from: source-2895416-dex2jar.jar:libcore/reflect/WildcardTypeImpl.class */
public final class WildcardTypeImpl implements WildcardType {
    private final ListOfTypes extendsBound;
    private final ListOfTypes superBound;

    public WildcardTypeImpl(ListOfTypes listOfTypes, ListOfTypes listOfTypes2) {
        this.extendsBound = listOfTypes;
        this.superBound = listOfTypes2;
    }

    public boolean equals(Object obj) {
        if (obj instanceof WildcardType) {
            WildcardType wildcardType = (WildcardType) obj;
            return Arrays.equals(getLowerBounds(), wildcardType.getLowerBounds()) && Arrays.equals(getUpperBounds(), wildcardType.getUpperBounds());
        }
        return false;
    }

    @Override // java.lang.reflect.WildcardType
    public Type[] getLowerBounds() throws TypeNotPresentException, MalformedParameterizedTypeException {
        return (Type[]) this.superBound.getResolvedTypes().clone();
    }

    @Override // java.lang.reflect.WildcardType
    public Type[] getUpperBounds() throws TypeNotPresentException, MalformedParameterizedTypeException {
        return (Type[]) this.extendsBound.getResolvedTypes().clone();
    }

    public int hashCode() {
        return (Arrays.hashCode(getLowerBounds()) * 31) + Arrays.hashCode(getUpperBounds());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("?");
        if ((this.extendsBound.length() == 1 && this.extendsBound.getResolvedTypes()[0] != Object.class) || this.extendsBound.length() > 1) {
            sb.append(" extends ").append(this.extendsBound);
        } else if (this.superBound.length() > 0) {
            sb.append(" super ").append(this.superBound);
        }
        return sb.toString();
    }
}
