package java.lang.reflect;

import com.android.dex.Dex;
import java.lang.annotation.Annotation;
import libcore.reflect.AnnotationAccess;
import libcore.util.EmptyArray;

/* loaded from: source-2895416-dex2jar.jar:java/lang/reflect/ArtMethod.class */
public final class ArtMethod {
    private int accessFlags;
    private Class<?> declaringClass;
    private ArtMethod[] dexCacheResolvedMethods;
    Class<?>[] dexCacheResolvedTypes;
    private int dexCodeItemOffset;
    private int dexMethodIndex;
    private int methodIndex;

    private ArtMethod() {
    }

    public static boolean equalConstructorParameters(ArtMethod artMethod, Class<?>[] clsArr) {
        Dex dex = artMethod.getDeclaringClass().getDex();
        short[] parameterTypeIndicesFromMethodIndex = dex.parameterTypeIndicesFromMethodIndex(artMethod.getDexMethodIndex());
        if (parameterTypeIndicesFromMethodIndex.length != clsArr.length) {
            return false;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= parameterTypeIndicesFromMethodIndex.length) {
                return true;
            }
            if (artMethod.getDexCacheType(dex, parameterTypeIndicesFromMethodIndex[i2]) != clsArr[i2]) {
                return false;
            }
            i = i2 + 1;
        }
    }

    public static boolean equalMethodParameters(ArtMethod artMethod, Class<?>[] clsArr) {
        return equalConstructorParameters(artMethod.findOverriddenMethodIfProxy(), clsArr);
    }

    private String getDexCacheString(Dex dex, int i) {
        return this.declaringClass.getDexCacheString(dex, i);
    }

    private Class<?> getDexCacheType(Dex dex, int i) {
        Class<?> cls = this.dexCacheResolvedTypes[i];
        Class<?> cls2 = cls;
        if (cls == null) {
            cls2 = this.declaringClass.getDexCacheType(dex, i);
        }
        return cls2;
    }

    public static String getMethodName(ArtMethod artMethod) {
        ArtMethod findOverriddenMethodIfProxy = artMethod.findOverriddenMethodIfProxy();
        Dex dex = findOverriddenMethodIfProxy.getDeclaringClass().getDex();
        return findOverriddenMethodIfProxy.getDexCacheString(dex, dex.nameIndexFromMethodIndex(findOverriddenMethodIfProxy.getDexMethodIndex()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int compareParameters(Class<?>[] clsArr) {
        int compareTo;
        Dex dex = getDeclaringClass().getDex();
        short[] parameterTypeIndicesFromMethodIndex = dex.parameterTypeIndicesFromMethodIndex(this.dexMethodIndex);
        int min = Math.min(parameterTypeIndicesFromMethodIndex.length, clsArr.length);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= min) {
                return parameterTypeIndicesFromMethodIndex.length - clsArr.length;
            }
            Class<?> dexCacheType = getDexCacheType(dex, parameterTypeIndicesFromMethodIndex[i2]);
            Class<?> cls = clsArr[i2];
            if (dexCacheType != cls && (compareTo = dexCacheType.getName().compareTo(cls.getName())) != 0) {
                return compareTo;
            }
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArtMethod findOverriddenMethodIfProxy() {
        ArtMethod artMethod = this;
        if (this.declaringClass.isProxy()) {
            artMethod = this.dexCacheResolvedMethods[this.dexMethodIndex];
        }
        return artMethod;
    }

    public int getAccessFlags() {
        return this.accessFlags;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Class getDeclaringClass() {
        return this.declaringClass;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getDexMethodIndex() {
        return this.dexMethodIndex;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Annotation[][] getParameterAnnotations() {
        return AnnotationAccess.getParameterAnnotations(this.declaringClass, this.dexMethodIndex);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Class<?>[] getParameterTypes() {
        Class<?>[] clsArr;
        Dex dex = getDeclaringClass().getDex();
        short[] parameterTypeIndicesFromMethodIndex = dex.parameterTypeIndicesFromMethodIndex(this.dexMethodIndex);
        if (parameterTypeIndicesFromMethodIndex.length != 0) {
            Class<?>[] clsArr2 = new Class[parameterTypeIndicesFromMethodIndex.length];
            int i = 0;
            while (true) {
                int i2 = i;
                clsArr = clsArr2;
                if (i2 >= parameterTypeIndicesFromMethodIndex.length) {
                    break;
                }
                clsArr2[i2] = getDexCacheType(dex, parameterTypeIndicesFromMethodIndex[i2]);
                i = i2 + 1;
            }
        } else {
            clsArr = EmptyArray.CLASS;
        }
        return clsArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Class<?> getReturnType() {
        Dex dex = this.declaringClass.getDex();
        return getDexCacheType(dex, dex.returnTypeIndexFromMethodIndex(this.dexMethodIndex));
    }
}
