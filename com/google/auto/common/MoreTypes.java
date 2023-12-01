package com.google.auto.common;

import com.google.common.base.Equivalence;
import com.google.common.base.Objects;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Throwables;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;
import com.igexin.push.core.b;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.TypeParameterElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.type.ArrayType;
import javax.lang.model.type.DeclaredType;
import javax.lang.model.type.ErrorType;
import javax.lang.model.type.ExecutableType;
import javax.lang.model.type.NoType;
import javax.lang.model.type.NullType;
import javax.lang.model.type.PrimitiveType;
import javax.lang.model.type.TypeKind;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.type.TypeVariable;
import javax.lang.model.type.WildcardType;
import javax.lang.model.util.Elements;
import javax.lang.model.util.SimpleTypeVisitor6;
import javax.lang.model.util.Types;

/* loaded from: source-8110460-dex2jar.jar:com/google/auto/common/MoreTypes.class */
public final class MoreTypes {
    private static final Method GET_BOUNDS;
    private static final int HASH_MULTIPLIER = 31;
    private static final int HASH_SEED = 17;
    private static final Class<?> INTERSECTION_TYPE;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.google.auto.common.MoreTypes$2  reason: invalid class name */
    /* loaded from: source-8110460-dex2jar.jar:com/google/auto/common/MoreTypes$2.class */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$javax$lang$model$type$TypeKind;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0065 -> B:41:0x0014). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0069 -> B:37:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x006d -> B:49:0x002a). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0071 -> B:43:0x0035). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x0075 -> B:39:0x0040). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x0079 -> B:35:0x004c). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x007d -> B:47:0x0058). Please submit an issue!!! */
        static {
            int[] iArr = new int[TypeKind.values().length];
            $SwitchMap$javax$lang$model$type$TypeKind = iArr;
            try {
                iArr[TypeKind.BOOLEAN.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$javax$lang$model$type$TypeKind[TypeKind.BYTE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$javax$lang$model$type$TypeKind[TypeKind.CHAR.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$javax$lang$model$type$TypeKind[TypeKind.DOUBLE.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$javax$lang$model$type$TypeKind[TypeKind.FLOAT.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                $SwitchMap$javax$lang$model$type$TypeKind[TypeKind.INT.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                $SwitchMap$javax$lang$model$type$TypeKind[TypeKind.LONG.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                $SwitchMap$javax$lang$model$type$TypeKind[TypeKind.SHORT.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
        }
    }

    /* loaded from: source-8110460-dex2jar.jar:com/google/auto/common/MoreTypes$ArrayTypeVisitor.class */
    static final class ArrayTypeVisitor extends CastingTypeVisitor<ArrayType> {
        private static final ArrayTypeVisitor INSTANCE = new ArrayTypeVisitor();

        ArrayTypeVisitor() {
            super("primitive array");
        }

        public ArrayType visitArray(ArrayType arrayType, Void r4) {
            return arrayType;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8110460-dex2jar.jar:com/google/auto/common/MoreTypes$AsElementVisitor.class */
    public static final class AsElementVisitor extends SimpleTypeVisitor6<Element, Void> {
        private static final AsElementVisitor INSTANCE = new AsElementVisitor();

        private AsElementVisitor() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public Element defaultAction(TypeMirror typeMirror, Void r6) {
            throw new IllegalArgumentException(typeMirror + " cannot be converted to an Element");
        }

        public Element visitDeclared(DeclaredType declaredType, Void r4) {
            return declaredType.asElement();
        }

        public Element visitError(ErrorType errorType, Void r4) {
            return errorType.asElement();
        }

        public Element visitTypeVariable(TypeVariable typeVariable, Void r4) {
            return typeVariable.asElement();
        }
    }

    /* loaded from: source-8110460-dex2jar.jar:com/google/auto/common/MoreTypes$CastingTypeVisitor.class */
    static abstract class CastingTypeVisitor<T> extends SimpleTypeVisitor6<T, Void> {
        private final String label;

        CastingTypeVisitor(String str) {
            this.label = str;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public T defaultAction(TypeMirror typeMirror, Void r6) {
            throw new IllegalArgumentException(typeMirror + " does not represent a " + this.label);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8110460-dex2jar.jar:com/google/auto/common/MoreTypes$ComparedElements.class */
    public static class ComparedElements {

        /* renamed from: a  reason: collision with root package name */
        final Element f22214a;
        final ImmutableList<TypeMirror> aArguments;
        final Element b;
        final ImmutableList<TypeMirror> bArguments;

        ComparedElements(Element element, ImmutableList<TypeMirror> immutableList, Element element2, ImmutableList<TypeMirror> immutableList2) {
            this.f22214a = element;
            this.aArguments = immutableList;
            this.b = element2;
            this.bArguments = immutableList2;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof ComparedElements)) {
                return false;
            }
            ComparedElements comparedElements = (ComparedElements) obj;
            int size = this.aArguments.size();
            if (!this.f22214a.equals(comparedElements.f22214a) || !this.b.equals(comparedElements.b) || size != this.bArguments.size()) {
                return false;
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= size) {
                    return true;
                }
                if (this.aArguments.get(i2) != this.bArguments.get(i2)) {
                    return false;
                }
                i = i2 + 1;
            }
        }

        public int hashCode() {
            return (this.f22214a.hashCode() * 31) + this.b.hashCode();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8110460-dex2jar.jar:com/google/auto/common/MoreTypes$DeclaredTypeVisitor.class */
    public static final class DeclaredTypeVisitor extends CastingTypeVisitor<DeclaredType> {
        private static final DeclaredTypeVisitor INSTANCE = new DeclaredTypeVisitor();

        DeclaredTypeVisitor() {
            super("declared type");
        }

        public DeclaredType visitDeclared(DeclaredType declaredType, Void r4) {
            return declaredType;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8110460-dex2jar.jar:com/google/auto/common/MoreTypes$EqualVisitor.class */
    public static final class EqualVisitor extends SimpleTypeVisitor6<Boolean, EqualVisitorParam> {
        private static final EqualVisitor INSTANCE = new EqualVisitor();

        private EqualVisitor() {
        }

        private Set<ComparedElements> visitingSetPlus(Set<ComparedElements> set, Element element, List<? extends TypeMirror> list, Element element2, List<? extends TypeMirror> list2) {
            ComparedElements comparedElements = new ComparedElements(element, ImmutableList.copyOf((Collection) list), element2, ImmutableList.copyOf((Collection) list2));
            HashSet hashSet = new HashSet(set);
            hashSet.add(comparedElements);
            return hashSet;
        }

        private Set<ComparedElements> visitingSetPlus(Set<ComparedElements> set, Element element, Element element2) {
            ImmutableList of = ImmutableList.of();
            return visitingSetPlus(set, element, of, element2, of);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public Boolean defaultAction(TypeMirror typeMirror, EqualVisitorParam equalVisitorParam) {
            return Boolean.valueOf(typeMirror.getKind().equals(equalVisitorParam.type.getKind()));
        }

        public Boolean visitArray(ArrayType arrayType, EqualVisitorParam equalVisitorParam) {
            if (equalVisitorParam.type.getKind().equals(TypeKind.ARRAY)) {
                return Boolean.valueOf(MoreTypes.equal(arrayType.getComponentType(), equalVisitorParam.type.getComponentType(), equalVisitorParam.visiting));
            }
            return false;
        }

        public Boolean visitDeclared(DeclaredType declaredType, EqualVisitorParam equalVisitorParam) {
            if (equalVisitorParam.type.getKind().equals(TypeKind.DECLARED)) {
                DeclaredType declaredType2 = equalVisitorParam.type;
                Element asElement = declaredType.asElement();
                Element asElement2 = declaredType2.asElement();
                Set<ComparedElements> visitingSetPlus = visitingSetPlus(equalVisitorParam.visiting, asElement, declaredType.getTypeArguments(), asElement2, declaredType2.getTypeArguments());
                if (visitingSetPlus.equals(equalVisitorParam.visiting)) {
                    return true;
                }
                boolean z = false;
                if (asElement.equals(asElement2)) {
                    z = false;
                    if (MoreTypes.equal(MoreTypes.enclosingType(declaredType), MoreTypes.enclosingType(declaredType2), visitingSetPlus)) {
                        z = false;
                        if (MoreTypes.equalLists(declaredType.getTypeArguments(), declaredType2.getTypeArguments(), visitingSetPlus)) {
                            z = true;
                        }
                    }
                }
                return Boolean.valueOf(z);
            }
            return false;
        }

        public Boolean visitError(ErrorType errorType, EqualVisitorParam equalVisitorParam) {
            return Boolean.valueOf(errorType.equals(equalVisitorParam.type));
        }

        public Boolean visitExecutable(ExecutableType executableType, EqualVisitorParam equalVisitorParam) {
            if (equalVisitorParam.type.getKind().equals(TypeKind.EXECUTABLE)) {
                ExecutableType executableType2 = equalVisitorParam.type;
                boolean z = false;
                if (MoreTypes.equalLists(executableType.getParameterTypes(), executableType2.getParameterTypes(), equalVisitorParam.visiting)) {
                    z = false;
                    if (MoreTypes.equal(executableType.getReturnType(), executableType2.getReturnType(), equalVisitorParam.visiting)) {
                        z = false;
                        if (MoreTypes.equalLists(executableType.getThrownTypes(), executableType2.getThrownTypes(), equalVisitorParam.visiting)) {
                            z = false;
                            if (MoreTypes.equalLists(executableType.getTypeVariables(), executableType2.getTypeVariables(), equalVisitorParam.visiting)) {
                                z = true;
                            }
                        }
                    }
                }
                return Boolean.valueOf(z);
            }
            return false;
        }

        public Boolean visitTypeVariable(TypeVariable typeVariable, EqualVisitorParam equalVisitorParam) {
            if (equalVisitorParam.type.getKind().equals(TypeKind.TYPEVAR)) {
                TypeVariable typeVariable2 = equalVisitorParam.type;
                TypeParameterElement asElement = typeVariable.asElement();
                TypeParameterElement asElement2 = typeVariable2.asElement();
                Set<ComparedElements> visitingSetPlus = visitingSetPlus(equalVisitorParam.visiting, asElement, asElement2);
                if (visitingSetPlus.equals(equalVisitorParam.visiting)) {
                    return true;
                }
                boolean z = false;
                if (MoreTypes.equalLists(asElement.getBounds(), asElement2.getBounds(), visitingSetPlus)) {
                    z = false;
                    if (MoreTypes.equal(typeVariable.getLowerBound(), typeVariable2.getLowerBound(), visitingSetPlus)) {
                        z = false;
                        if (typeVariable.asElement().getSimpleName().equals(typeVariable2.asElement().getSimpleName())) {
                            z = true;
                        }
                    }
                }
                return Boolean.valueOf(z);
            }
            return false;
        }

        public Boolean visitUnknown(TypeMirror typeMirror, EqualVisitorParam equalVisitorParam) {
            throw new UnsupportedOperationException();
        }

        public Boolean visitWildcard(WildcardType wildcardType, EqualVisitorParam equalVisitorParam) {
            if (equalVisitorParam.type.getKind().equals(TypeKind.WILDCARD)) {
                WildcardType wildcardType2 = equalVisitorParam.type;
                boolean z = false;
                if (MoreTypes.equal(wildcardType.getExtendsBound(), wildcardType2.getExtendsBound(), equalVisitorParam.visiting)) {
                    z = false;
                    if (MoreTypes.equal(wildcardType.getSuperBound(), wildcardType2.getSuperBound(), equalVisitorParam.visiting)) {
                        z = true;
                    }
                }
                return Boolean.valueOf(z);
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8110460-dex2jar.jar:com/google/auto/common/MoreTypes$EqualVisitorParam.class */
    public static final class EqualVisitorParam {
        TypeMirror type;
        Set<ComparedElements> visiting;

        private EqualVisitorParam() {
        }
    }

    /* loaded from: source-8110460-dex2jar.jar:com/google/auto/common/MoreTypes$ErrorTypeVisitor.class */
    static final class ErrorTypeVisitor extends CastingTypeVisitor<ErrorType> {
        private static final ErrorTypeVisitor INSTANCE = new ErrorTypeVisitor();

        ErrorTypeVisitor() {
            super("error type");
        }

        public ErrorType visitError(ErrorType errorType, Void r4) {
            return errorType;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8110460-dex2jar.jar:com/google/auto/common/MoreTypes$ExecutableTypeVisitor.class */
    public static final class ExecutableTypeVisitor extends CastingTypeVisitor<ExecutableType> {
        private static final ExecutableTypeVisitor INSTANCE = new ExecutableTypeVisitor();

        ExecutableTypeVisitor() {
            super("executable type");
        }

        public ExecutableType visitExecutable(ExecutableType executableType, Void r4) {
            return executableType;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8110460-dex2jar.jar:com/google/auto/common/MoreTypes$HashVisitor.class */
    public static final class HashVisitor extends SimpleTypeVisitor6<Integer, Set<Element>> {
        private static final HashVisitor INSTANCE = new HashVisitor();

        private HashVisitor() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public Integer defaultAction(TypeMirror typeMirror, Set<Element> set) {
            return Integer.valueOf(hashKind(17, typeMirror));
        }

        int hashKind(int i, TypeMirror typeMirror) {
            return (i * 31) + typeMirror.getKind().hashCode();
        }

        public Integer visitArray(ArrayType arrayType, Set<Element> set) {
            return Integer.valueOf((hashKind(17, arrayType) * 31) + ((Integer) arrayType.getComponentType().accept(this, set)).intValue());
        }

        public Integer visitDeclared(DeclaredType declaredType, Set<Element> set) {
            Element asElement = declaredType.asElement();
            if (set.contains(asElement)) {
                return 0;
            }
            HashSet hashSet = new HashSet(set);
            hashSet.add(asElement);
            return Integer.valueOf((((((hashKind(17, declaredType) * 31) + declaredType.asElement().hashCode()) * 31) + ((Integer) declaredType.getEnclosingType().accept(this, hashSet)).intValue()) * 31) + MoreTypes.hashList(declaredType.getTypeArguments(), hashSet));
        }

        public Integer visitExecutable(ExecutableType executableType, Set<Element> set) {
            return Integer.valueOf((((((((hashKind(17, executableType) * 31) + MoreTypes.hashList(executableType.getParameterTypes(), set)) * 31) + ((Integer) executableType.getReturnType().accept(this, set)).intValue()) * 31) + MoreTypes.hashList(executableType.getThrownTypes(), set)) * 31) + MoreTypes.hashList(executableType.getTypeVariables(), set));
        }

        public Integer visitTypeVariable(TypeVariable typeVariable, Set<Element> set) {
            int hashKind = (hashKind(17, typeVariable) * 31) + ((Integer) typeVariable.getLowerBound().accept(this, set)).intValue();
            for (TypeMirror typeMirror : typeVariable.asElement().getBounds()) {
                hashKind = (hashKind * 31) + ((Integer) typeMirror.accept(this, set)).intValue();
            }
            return Integer.valueOf(hashKind);
        }

        public Integer visitUnknown(TypeMirror typeMirror, Set<Element> set) {
            throw new UnsupportedOperationException();
        }

        public Integer visitWildcard(WildcardType wildcardType, Set<Element> set) {
            int hashKind = hashKind(17, wildcardType);
            int i = 0;
            int intValue = wildcardType.getExtendsBound() == null ? 0 : ((Integer) wildcardType.getExtendsBound().accept(this, set)).intValue();
            if (wildcardType.getSuperBound() != null) {
                i = ((Integer) wildcardType.getSuperBound().accept(this, set)).intValue();
            }
            return Integer.valueOf((((hashKind * 31) + intValue) * 31) + i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8110460-dex2jar.jar:com/google/auto/common/MoreTypes$IsTypeOf.class */
    public static final class IsTypeOf extends SimpleTypeVisitor6<Boolean, Void> {
        private final Class<?> clazz;

        IsTypeOf(Class<?> cls) {
            this.clazz = cls;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public Boolean defaultAction(TypeMirror typeMirror, Void r6) {
            throw new IllegalArgumentException(typeMirror + " cannot be represented as a Class<?>.");
        }

        public Boolean visitArray(ArrayType arrayType, Void r5) {
            return Boolean.valueOf(this.clazz.isArray() && MoreTypes.isTypeOf(this.clazz.getComponentType(), arrayType.getComponentType()));
        }

        public Boolean visitDeclared(DeclaredType declaredType, Void r6) {
            try {
                return Boolean.valueOf(MoreElements.asType(declaredType.asElement()).getQualifiedName().contentEquals(this.clazz.getCanonicalName()));
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException(declaredType + " does not represent a class or interface.");
            }
        }

        public Boolean visitNoType(NoType noType, Void r6) {
            if (noType.getKind().equals(TypeKind.VOID)) {
                return Boolean.valueOf(this.clazz.equals(Void.TYPE));
            }
            throw new IllegalArgumentException(noType + " cannot be represented as a Class<?>.");
        }

        public Boolean visitPrimitive(PrimitiveType primitiveType, Void r6) {
            switch (AnonymousClass2.$SwitchMap$javax$lang$model$type$TypeKind[primitiveType.getKind().ordinal()]) {
                case 1:
                    return Boolean.valueOf(this.clazz.equals(Boolean.TYPE));
                case 2:
                    return Boolean.valueOf(this.clazz.equals(Byte.TYPE));
                case 3:
                    return Boolean.valueOf(this.clazz.equals(Character.TYPE));
                case 4:
                    return Boolean.valueOf(this.clazz.equals(Double.TYPE));
                case 5:
                    return Boolean.valueOf(this.clazz.equals(Float.TYPE));
                case 6:
                    return Boolean.valueOf(this.clazz.equals(Integer.TYPE));
                case 7:
                    return Boolean.valueOf(this.clazz.equals(Long.TYPE));
                case 8:
                    return Boolean.valueOf(this.clazz.equals(Short.TYPE));
                default:
                    throw new IllegalArgumentException(primitiveType + " cannot be represented as a Class<?>.");
            }
        }
    }

    /* loaded from: source-8110460-dex2jar.jar:com/google/auto/common/MoreTypes$IsTypeVisitor.class */
    static final class IsTypeVisitor extends SimpleTypeVisitor6<Boolean, Void> {
        private static final IsTypeVisitor INSTANCE = new IsTypeVisitor();

        private IsTypeVisitor() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public Boolean defaultAction(TypeMirror typeMirror, Void r4) {
            return false;
        }

        public Boolean visitArray(ArrayType arrayType, Void r4) {
            return true;
        }

        public Boolean visitDeclared(DeclaredType declaredType, Void r4) {
            return Boolean.valueOf(MoreElements.isType(declaredType.asElement()));
        }

        public Boolean visitNoType(NoType noType, Void r5) {
            return Boolean.valueOf(noType.getKind().equals(TypeKind.VOID));
        }

        public Boolean visitPrimitive(PrimitiveType primitiveType, Void r4) {
            return true;
        }
    }

    /* loaded from: source-8110460-dex2jar.jar:com/google/auto/common/MoreTypes$NoTypeVisitor.class */
    static final class NoTypeVisitor extends CastingTypeVisitor<NoType> {
        private static final NoTypeVisitor INSTANCE = new NoTypeVisitor();

        NoTypeVisitor() {
            super("non-type");
        }

        public NoType visitNoType(NoType noType, Void r4) {
            return noType;
        }
    }

    /* loaded from: source-8110460-dex2jar.jar:com/google/auto/common/MoreTypes$NullTypeVisitor.class */
    static final class NullTypeVisitor extends CastingTypeVisitor<NullType> {
        private static final NullTypeVisitor INSTANCE = new NullTypeVisitor();

        NullTypeVisitor() {
            super(b.l);
        }

        public NullType visitNull(NullType nullType, Void r4) {
            return nullType;
        }
    }

    /* loaded from: source-8110460-dex2jar.jar:com/google/auto/common/MoreTypes$PrimitiveTypeVisitor.class */
    static final class PrimitiveTypeVisitor extends CastingTypeVisitor<PrimitiveType> {
        private static final PrimitiveTypeVisitor INSTANCE = new PrimitiveTypeVisitor();

        PrimitiveTypeVisitor() {
            super("primitive type");
        }

        public PrimitiveType visitPrimitive(PrimitiveType primitiveType, Void r4) {
            return primitiveType;
        }
    }

    /* loaded from: source-8110460-dex2jar.jar:com/google/auto/common/MoreTypes$ReferencedTypes.class */
    static final class ReferencedTypes extends SimpleTypeVisitor6<Void, ImmutableSet.Builder<TypeElement>> {
        private static final ReferencedTypes INSTANCE = new ReferencedTypes();

        private ReferencedTypes() {
        }

        public Void visitArray(ArrayType arrayType, ImmutableSet.Builder<TypeElement> builder) {
            arrayType.getComponentType().accept(this, builder);
            return null;
        }

        public Void visitDeclared(DeclaredType declaredType, ImmutableSet.Builder<TypeElement> builder) {
            builder.add((ImmutableSet.Builder<TypeElement>) MoreElements.asType(declaredType.asElement()));
            for (TypeMirror typeMirror : declaredType.getTypeArguments()) {
                typeMirror.accept(this, builder);
            }
            return null;
        }

        public Void visitTypeVariable(TypeVariable typeVariable, ImmutableSet.Builder<TypeElement> builder) {
            typeVariable.getLowerBound().accept(this, builder);
            typeVariable.getUpperBound().accept(this, builder);
            return null;
        }

        public Void visitWildcard(WildcardType wildcardType, ImmutableSet.Builder<TypeElement> builder) {
            TypeMirror extendsBound = wildcardType.getExtendsBound();
            if (extendsBound != null) {
                extendsBound.accept(this, builder);
            }
            TypeMirror superBound = wildcardType.getSuperBound();
            if (superBound != null) {
                superBound.accept(this, builder);
                return null;
            }
            return null;
        }
    }

    /* loaded from: source-8110460-dex2jar.jar:com/google/auto/common/MoreTypes$TypeEquivalence.class */
    static final class TypeEquivalence extends Equivalence<TypeMirror> {
        private static final TypeEquivalence INSTANCE = new TypeEquivalence();

        private TypeEquivalence() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.base.Equivalence
        public boolean doEquivalent(TypeMirror typeMirror, TypeMirror typeMirror2) {
            return MoreTypes.equal(typeMirror, typeMirror2, ImmutableSet.of());
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.base.Equivalence
        public int doHash(TypeMirror typeMirror) {
            return MoreTypes.hash(typeMirror, ImmutableSet.of());
        }
    }

    /* loaded from: source-8110460-dex2jar.jar:com/google/auto/common/MoreTypes$TypeVariableVisitor.class */
    static final class TypeVariableVisitor extends CastingTypeVisitor<TypeVariable> {
        private static final TypeVariableVisitor INSTANCE = new TypeVariableVisitor();

        TypeVariableVisitor() {
            super("type variable");
        }

        public TypeVariable visitTypeVariable(TypeVariable typeVariable, Void r4) {
            return typeVariable;
        }
    }

    /* loaded from: source-8110460-dex2jar.jar:com/google/auto/common/MoreTypes$WildcardTypeVisitor.class */
    static final class WildcardTypeVisitor extends CastingTypeVisitor<WildcardType> {
        private static final WildcardTypeVisitor INSTANCE = new WildcardTypeVisitor();

        WildcardTypeVisitor() {
            super("wildcard type");
        }

        public WildcardType visitWildcard(WildcardType wildcardType, Void r4) {
            return wildcardType;
        }
    }

    static {
        Method method;
        Class<?> cls = null;
        try {
            Class<?> cls2 = Class.forName("javax.lang.model.type.IntersectionType");
            method = cls2.getMethod("getBounds", new Class[0]);
            cls = cls2;
        } catch (Exception e) {
            method = null;
        }
        INTERSECTION_TYPE = cls;
        GET_BOUNDS = method;
    }

    private MoreTypes() {
    }

    public static ArrayType asArray(TypeMirror typeMirror) {
        return (ArrayType) typeMirror.accept(ArrayTypeVisitor.INSTANCE, (Object) null);
    }

    public static DeclaredType asDeclared(TypeMirror typeMirror) {
        return (DeclaredType) typeMirror.accept(DeclaredTypeVisitor.INSTANCE, (Object) null);
    }

    public static Element asElement(TypeMirror typeMirror) {
        return (Element) typeMirror.accept(AsElementVisitor.INSTANCE, (Object) null);
    }

    public static ErrorType asError(TypeMirror typeMirror) {
        return (ErrorType) typeMirror.accept(ErrorTypeVisitor.INSTANCE, (Object) null);
    }

    public static ExecutableType asExecutable(TypeMirror typeMirror) {
        return (ExecutableType) typeMirror.accept(ExecutableTypeVisitor.INSTANCE, (Object) null);
    }

    public static TypeMirror asMemberOf(Types types, DeclaredType declaredType, VariableElement variableElement) {
        if (variableElement.getKind().equals(ElementKind.PARAMETER)) {
            ExecutableElement asExecutable = MoreElements.asExecutable(variableElement.getEnclosingElement());
            ExecutableType asExecutable2 = asExecutable(types.asMemberOf(declaredType, asExecutable));
            List parameters = asExecutable.getParameters();
            List parameterTypes = asExecutable2.getParameterTypes();
            Preconditions.checkState(parameters.size() == parameterTypes.size());
            for (int i = 0; i < parameters.size(); i++) {
                if (((VariableElement) parameters.get(i)).equals(variableElement)) {
                    return (TypeMirror) parameterTypes.get(i);
                }
            }
            throw new IllegalStateException("Could not find variable: " + variableElement);
        }
        return types.asMemberOf(declaredType, variableElement);
    }

    public static NoType asNoType(TypeMirror typeMirror) {
        return (NoType) typeMirror.accept(NoTypeVisitor.INSTANCE, (Object) null);
    }

    public static NullType asNullType(TypeMirror typeMirror) {
        return (NullType) typeMirror.accept(NullTypeVisitor.INSTANCE, (Object) null);
    }

    public static PrimitiveType asPrimitiveType(TypeMirror typeMirror) {
        return (PrimitiveType) typeMirror.accept(PrimitiveTypeVisitor.INSTANCE, (Object) null);
    }

    public static TypeElement asTypeElement(TypeMirror typeMirror) {
        return MoreElements.asType(asElement(typeMirror));
    }

    public static ImmutableSet<TypeElement> asTypeElements(Iterable<? extends TypeMirror> iterable) {
        Preconditions.checkNotNull(iterable);
        ImmutableSet.Builder builder = ImmutableSet.builder();
        for (TypeMirror typeMirror : iterable) {
            builder.add((ImmutableSet.Builder) asTypeElement(typeMirror));
        }
        return builder.build();
    }

    public static TypeVariable asTypeVariable(TypeMirror typeMirror) {
        return (TypeVariable) typeMirror.accept(TypeVariableVisitor.INSTANCE, (Object) null);
    }

    public static WildcardType asWildcard(TypeMirror typeMirror) {
        return (WildcardType) typeMirror.accept(WildcardTypeVisitor.INSTANCE, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static TypeMirror enclosingType(DeclaredType declaredType) {
        TypeMirror enclosingType = declaredType.getEnclosingType();
        if (enclosingType.getKind().equals(TypeKind.NONE) || declaredType.asElement().getModifiers().contains(Modifier.STATIC)) {
            return null;
        }
        return enclosingType;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean equal(TypeMirror typeMirror, TypeMirror typeMirror2, Set<ComparedElements> set) {
        boolean z = true;
        if (!Objects.equal(typeMirror, typeMirror2) || (typeMirror instanceof ExecutableType)) {
            EqualVisitorParam equalVisitorParam = new EqualVisitorParam();
            equalVisitorParam.type = typeMirror2;
            equalVisitorParam.visiting = set;
            if (INTERSECTION_TYPE != null) {
                if (isIntersectionType(typeMirror)) {
                    return equalIntersectionTypes(typeMirror, typeMirror2, set);
                }
                if (isIntersectionType(typeMirror2)) {
                    return false;
                }
            }
            if (typeMirror != typeMirror2) {
                if (typeMirror != null && typeMirror2 != null && ((Boolean) typeMirror.accept(EqualVisitor.INSTANCE, equalVisitorParam)).booleanValue()) {
                    return true;
                }
                z = false;
            }
            return z;
        }
        return true;
    }

    private static boolean equalIntersectionTypes(TypeMirror typeMirror, TypeMirror typeMirror2, Set<ComparedElements> set) {
        if (isIntersectionType(typeMirror2)) {
            try {
                return equalLists((List) GET_BOUNDS.invoke(typeMirror, new Object[0]), (List) GET_BOUNDS.invoke(typeMirror2, new Object[0]), set);
            } catch (Exception e) {
                throw Throwables.propagate(e);
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0028  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean equalLists(java.util.List<? extends javax.lang.model.type.TypeMirror> r4, java.util.List<? extends javax.lang.model.type.TypeMirror> r5, java.util.Set<com.google.auto.common.MoreTypes.ComparedElements> r6) {
        /*
            r0 = r4
            int r0 = r0.size()
            r1 = r5
            int r1 = r1.size()
            if (r0 == r1) goto L11
            r0 = 0
            return r0
        L11:
            r0 = r4
            java.util.Iterator r0 = r0.iterator()
            r4 = r0
            r0 = r5
            java.util.Iterator r0 = r0.iterator()
            r5 = r0
        L1f:
            r0 = r4
            boolean r0 = r0.hasNext()
            if (r0 == 0) goto L4e
            r0 = r5
            boolean r0 = r0.hasNext()
            if (r0 != 0) goto L33
            r0 = 0
            return r0
        L33:
            r0 = r4
            java.lang.Object r0 = r0.next()
            javax.lang.model.type.TypeMirror r0 = (javax.lang.model.type.TypeMirror) r0
            r1 = r5
            java.lang.Object r1 = r1.next()
            javax.lang.model.type.TypeMirror r1 = (javax.lang.model.type.TypeMirror) r1
            r2 = r6
            boolean r0 = equal(r0, r1, r2)
            if (r0 != 0) goto L1f
            r0 = 0
            return r0
        L4e:
            r0 = r4
            boolean r0 = r0.hasNext()
            r1 = 1
            r0 = r0 ^ r1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.auto.common.MoreTypes.equalLists(java.util.List, java.util.List, java.util.Set):boolean");
    }

    public static Equivalence<TypeMirror> equivalence() {
        return TypeEquivalence.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int hash(TypeMirror typeMirror, Set<Element> set) {
        if (typeMirror == null) {
            return 0;
        }
        return ((Integer) typeMirror.accept(HashVisitor.INSTANCE, set)).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int hashList(List<? extends TypeMirror> list, Set<Element> set) {
        Iterator<? extends TypeMirror> it = list.iterator();
        int i = 17;
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return i2;
            }
            i = (i2 * 31) + hash(it.next(), set);
        }
    }

    private static boolean isIntersectionType(TypeMirror typeMirror) {
        return typeMirror != null && typeMirror.getKind().name().equals("INTERSECTION");
    }

    public static boolean isType(TypeMirror typeMirror) {
        return ((Boolean) typeMirror.accept(IsTypeVisitor.INSTANCE, (Object) null)).booleanValue();
    }

    public static boolean isTypeOf(Class<?> cls, TypeMirror typeMirror) {
        Preconditions.checkNotNull(cls);
        return ((Boolean) typeMirror.accept(new IsTypeOf(cls), (Object) null)).booleanValue();
    }

    public static Optional<DeclaredType> nonObjectSuperclass(final Types types, Elements elements, DeclaredType declaredType) {
        Preconditions.checkNotNull(types);
        Preconditions.checkNotNull(elements);
        Preconditions.checkNotNull(declaredType);
        final TypeMirror asType = elements.getTypeElement(Object.class.getCanonicalName()).asType();
        TypeMirror typeMirror = (TypeMirror) Iterables.getOnlyElement(FluentIterable.from(types.directSupertypes(declaredType)).filter(new Predicate<TypeMirror>() { // from class: com.google.auto.common.MoreTypes.1
            @Override // com.google.common.base.Predicate
            public boolean apply(TypeMirror typeMirror2) {
                return typeMirror2.getKind().equals(TypeKind.DECLARED) && MoreElements.asType(MoreTypes.asDeclared(typeMirror2).asElement()).getKind().equals(ElementKind.CLASS) && !types.isSameType(asType, typeMirror2);
            }
        }), null);
        return typeMirror != null ? Optional.of(asDeclared(typeMirror)) : Optional.absent();
    }

    public static ImmutableSet<TypeElement> referencedTypes(TypeMirror typeMirror) {
        Preconditions.checkNotNull(typeMirror);
        ImmutableSet.Builder builder = ImmutableSet.builder();
        typeMirror.accept(ReferencedTypes.INSTANCE, builder);
        return builder.build();
    }
}
