package com.google.auto.common;

import com.google.common.base.Preconditions;
import com.google.common.base.Verify;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.UnmodifiableIterator;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.TypeParameterElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.type.ArrayType;
import javax.lang.model.type.DeclaredType;
import javax.lang.model.type.TypeKind;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.type.TypeVariable;
import javax.lang.model.util.ElementFilter;
import javax.lang.model.util.Elements;
import javax.lang.model.util.SimpleTypeVisitor6;
import javax.lang.model.util.Types;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8110460-dex2jar.jar:com/google/auto/common/Overrides.class */
public abstract class Overrides {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8110460-dex2jar.jar:com/google/auto/common/Overrides$ExplicitOverrides.class */
    public static class ExplicitOverrides extends Overrides {
        private final Types typeUtils;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: source-8110460-dex2jar.jar:com/google/auto/common/Overrides$ExplicitOverrides$TypeSubstVisitor.class */
        public class TypeSubstVisitor extends SimpleTypeVisitor6<TypeMirror, Void> {
            private final Map<TypeParameterElement, TypeMirror> typeBindings;

            private TypeSubstVisitor() {
                this.typeBindings = Maps.newLinkedHashMap();
            }

            /* JADX INFO: Access modifiers changed from: protected */
            public TypeMirror defaultAction(TypeMirror typeMirror, Void r4) {
                return typeMirror;
            }

            /* JADX WARN: Multi-variable type inference failed */
            ImmutableList<TypeMirror> erasedParameterTypes(ExecutableElement executableElement, TypeElement typeElement) {
                if (executableElement.getEnclosingElement().equals(typeElement)) {
                    ImmutableList.Builder builder = ImmutableList.builder();
                    for (VariableElement variableElement : executableElement.getParameters()) {
                        builder.add((ImmutableList.Builder) ExplicitOverrides.this.typeUtils.erasure((TypeMirror) visit(variableElement.asType())));
                    }
                    return builder.build();
                }
                ArrayList<TypeMirror> newArrayList = Lists.newArrayList();
                if (typeElement.getSuperclass().getKind() == TypeKind.DECLARED) {
                    newArrayList.add(typeElement.getSuperclass());
                }
                newArrayList.addAll(typeElement.getInterfaces());
                for (TypeMirror typeMirror : newArrayList) {
                    DeclaredType asDeclared = MoreTypes.asDeclared(typeMirror);
                    TypeElement asType = MoreElements.asType(asDeclared.asElement());
                    List typeArguments = asDeclared.getTypeArguments();
                    List typeParameters = asType.getTypeParameters();
                    Verify.verify(typeArguments.size() == typeParameters.size());
                    for (int i = 0; i < typeArguments.size(); i++) {
                        this.typeBindings.put(typeParameters.get(i), typeArguments.get(i));
                    }
                    ImmutableList<TypeMirror> erasedParameterTypes = erasedParameterTypes(executableElement, asType);
                    if (erasedParameterTypes != null) {
                        return erasedParameterTypes;
                    }
                }
                return null;
            }

            public TypeMirror visitArray(ArrayType arrayType, Void r6) {
                return ExplicitOverrides.this.typeUtils.getArrayType((TypeMirror) visit(arrayType.getComponentType()));
            }

            public TypeMirror visitDeclared(DeclaredType declaredType, Void r7) {
                if (declaredType.getTypeArguments().isEmpty()) {
                    return declaredType;
                }
                ArrayList newArrayList = Lists.newArrayList();
                for (TypeMirror typeMirror : declaredType.getTypeArguments()) {
                    newArrayList.add(visit(typeMirror));
                }
                return ExplicitOverrides.this.typeUtils.getDeclaredType(ExplicitOverrides.this.asTypeElement(declaredType), (TypeMirror[]) newArrayList.toArray(new TypeMirror[0]));
            }

            public TypeMirror visitTypeVariable(TypeVariable typeVariable, Void r6) {
                TypeParameterElement asElement = ExplicitOverrides.this.typeUtils.asElement(typeVariable);
                if (asElement instanceof TypeParameterElement) {
                    TypeParameterElement typeParameterElement = asElement;
                    if (this.typeBindings.containsKey(typeParameterElement)) {
                        return (TypeMirror) visit(this.typeBindings.get(typeParameterElement));
                    }
                }
                return (TypeMirror) visit(ExplicitOverrides.this.typeUtils.erasure(typeVariable.getUpperBound()));
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public ExplicitOverrides(Types types) {
            this.typeUtils = types;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public TypeElement asTypeElement(TypeMirror typeMirror) {
            return MoreElements.asType(MoreTypes.asDeclared(typeMirror).asElement());
        }

        private boolean isSubsignature(ExecutableElement executableElement, ExecutableElement executableElement2, TypeElement typeElement) {
            DeclaredType asDeclared = MoreTypes.asDeclared(typeElement.asType());
            try {
                return this.typeUtils.isSubsignature(MoreTypes.asExecutable(this.typeUtils.asMemberOf(asDeclared, executableElement)), MoreTypes.asExecutable(this.typeUtils.asMemberOf(asDeclared, executableElement2)));
            } catch (IllegalArgumentException e) {
                int size = executableElement.getParameters().size();
                if (executableElement2.getParameters().size() != size) {
                    return false;
                }
                ImmutableList<TypeMirror> erasedParameterTypes = erasedParameterTypes(executableElement, typeElement);
                ImmutableList<TypeMirror> erasedParameterTypes2 = erasedParameterTypes(executableElement2, typeElement);
                if (erasedParameterTypes == null || erasedParameterTypes2 == null) {
                    return false;
                }
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= size) {
                        return true;
                    }
                    if (!this.typeUtils.isSameType(erasedParameterTypes.get(i2), erasedParameterTypes2.get(i2))) {
                        return false;
                    }
                    i = i2 + 1;
                }
            }
        }

        private ExecutableElement methodInType(TypeElement typeElement, ExecutableElement executableElement) {
            int size = executableElement.getParameters().size();
            ImmutableList<TypeMirror> erasedParameterTypes = erasedParameterTypes(executableElement, typeElement);
            if (erasedParameterTypes == null) {
                return null;
            }
            for (ExecutableElement executableElement2 : ElementFilter.methodsIn(typeElement.getEnclosedElements())) {
                if (executableElement2.getSimpleName().equals(executableElement.getSimpleName()) && executableElement2.getParameters().size() == size) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= size) {
                            return executableElement2;
                        }
                        if (!this.typeUtils.isSameType(erasedParameterTypes.get(i2), this.typeUtils.erasure(((VariableElement) executableElement2.getParameters().get(i2)).asType()))) {
                            break;
                        }
                        i = i2 + 1;
                    }
                }
            }
            return null;
        }

        private TypeElement superclass(TypeElement typeElement) {
            TypeMirror superclass = typeElement.getSuperclass();
            if (superclass.getKind() == TypeKind.DECLARED) {
                return MoreElements.asType(this.typeUtils.asElement(superclass));
            }
            return null;
        }

        private ImmutableList<TypeElement> superinterfaces(TypeElement typeElement) {
            ImmutableList.Builder builder = ImmutableList.builder();
            for (TypeMirror typeMirror : typeElement.getInterfaces()) {
                builder.add((ImmutableList.Builder) MoreElements.asType(this.typeUtils.asElement(typeMirror)));
            }
            return builder.build();
        }

        ImmutableList<TypeMirror> erasedParameterTypes(ExecutableElement executableElement, TypeElement typeElement) {
            return executableElement.getParameters().isEmpty() ? ImmutableList.of() : new TypeSubstVisitor().erasedParameterTypes(executableElement, typeElement);
        }

        ExecutableElement methodFromSuperclasses(TypeElement typeElement, ExecutableElement executableElement) {
            while (typeElement != null) {
                ExecutableElement methodInType = methodInType(typeElement, executableElement);
                if (methodInType != null) {
                    return methodInType;
                }
                typeElement = superclass(typeElement);
            }
            return null;
        }

        ExecutableElement methodFromSuperinterfaces(TypeElement typeElement, ExecutableElement executableElement) {
            TypeElement superclass;
            TypeElement asType = MoreElements.asType(executableElement.getEnclosingElement());
            Preconditions.checkArgument(asType.getKind().isInterface());
            TypeMirror erasure = this.typeUtils.erasure(asType.asType());
            ImmutableList of = ImmutableList.of(typeElement);
            while (true) {
                ImmutableList immutableList = of;
                if (immutableList.isEmpty()) {
                    return null;
                }
                ImmutableList.Builder builder = ImmutableList.builder();
                UnmodifiableIterator it = immutableList.iterator();
                while (it.hasNext()) {
                    TypeElement typeElement2 = (TypeElement) it.next();
                    if (this.typeUtils.isAssignable(this.typeUtils.erasure(typeElement2.asType()), erasure)) {
                        ExecutableElement methodInType = methodInType(typeElement2, executableElement);
                        if (methodInType != null) {
                            return methodInType;
                        }
                        builder.addAll((Iterable) superinterfaces(typeElement2));
                    }
                    if (typeElement2.getKind().isClass() && (superclass = superclass(typeElement2)) != null) {
                        builder.add((ImmutableList.Builder) superclass);
                    }
                }
                of = builder.build();
            }
        }

        @Override // com.google.auto.common.Overrides
        public boolean overrides(ExecutableElement executableElement, ExecutableElement executableElement2, TypeElement typeElement) {
            if (!executableElement.getSimpleName().equals(executableElement2.getSimpleName()) || executableElement.getEnclosingElement().equals(executableElement2.getEnclosingElement()) || executableElement2.getModifiers().contains(Modifier.STATIC)) {
                return false;
            }
            Visibility ofElement = Visibility.ofElement(executableElement2);
            Visibility ofElement2 = Visibility.ofElement(executableElement);
            if (!ofElement.equals(Visibility.PRIVATE) && ofElement2.compareTo(ofElement) >= 0 && isSubsignature(executableElement, executableElement2, typeElement) && MoreElements.methodVisibleFromPackage(executableElement2, MoreElements.getPackage(executableElement)) && (executableElement2.getEnclosingElement() instanceof TypeElement)) {
                TypeElement asType = MoreElements.asType(executableElement2.getEnclosingElement());
                Types types = this.typeUtils;
                if (types.isSubtype(types.erasure(typeElement.asType()), this.typeUtils.erasure(asType.asType()))) {
                    if (typeElement.getKind().isClass()) {
                        if (asType.getKind().isClass()) {
                            return !executableElement2.getEnclosingElement().equals(methodFromSuperclasses(typeElement, executableElement2).getEnclosingElement());
                        } else if (asType.getKind().isInterface()) {
                            if (executableElement.getModifiers().contains(Modifier.ABSTRACT)) {
                                return !executableElement2.getEnclosingElement().equals(methodFromSuperinterfaces(typeElement, executableElement2).getEnclosingElement());
                            }
                            return true;
                        } else {
                            return false;
                        }
                    }
                    return typeElement.getKind().isInterface();
                }
                return false;
            }
            return false;
        }
    }

    /* loaded from: source-8110460-dex2jar.jar:com/google/auto/common/Overrides$NativeOverrides.class */
    static class NativeOverrides extends Overrides {
        private final Elements elementUtils;

        /* JADX INFO: Access modifiers changed from: package-private */
        public NativeOverrides(Elements elements) {
            this.elementUtils = elements;
        }

        @Override // com.google.auto.common.Overrides
        boolean overrides(ExecutableElement executableElement, ExecutableElement executableElement2, TypeElement typeElement) {
            return this.elementUtils.overrides(executableElement, executableElement2, typeElement);
        }
    }

    Overrides() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract boolean overrides(ExecutableElement executableElement, ExecutableElement executableElement2, TypeElement typeElement);
}
