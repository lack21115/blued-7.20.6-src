package com.google.auto.common;

import java.util.List;
import java.util.Map;
import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.AnnotationValue;
import javax.lang.model.element.AnnotationValueVisitor;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementVisitor;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.PackageElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.TypeParameterElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.type.ArrayType;
import javax.lang.model.type.DeclaredType;
import javax.lang.model.type.ErrorType;
import javax.lang.model.type.ExecutableType;
import javax.lang.model.type.TypeKind;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.type.TypeVisitor;
import javax.lang.model.type.WildcardType;
import javax.lang.model.util.AbstractElementVisitor6;
import javax.lang.model.util.SimpleAnnotationValueVisitor6;
import javax.lang.model.util.SimpleTypeVisitor6;

/* loaded from: source-8110460-dex2jar.jar:com/google/auto/common/SuperficialValidation.class */
public final class SuperficialValidation {
    private static final ElementVisitor<Boolean, Void> ELEMENT_VALIDATING_VISITOR = new AbstractElementVisitor6<Boolean, Void>() { // from class: com.google.auto.common.SuperficialValidation.1
        public Boolean visitExecutable(ExecutableElement executableElement, Void r5) {
            AnnotationValue defaultValue = executableElement.getDefaultValue();
            return Boolean.valueOf(SuperficialValidation.isValidBaseElement(executableElement) && (defaultValue == null || SuperficialValidation.validateAnnotationValue(defaultValue, executableElement.getReturnType())) && SuperficialValidation.validateType(executableElement.getReturnType()) && SuperficialValidation.validateTypes(executableElement.getThrownTypes()) && SuperficialValidation.validateElements(executableElement.getTypeParameters()) && SuperficialValidation.validateElements(executableElement.getParameters()));
        }

        public Boolean visitPackage(PackageElement packageElement, Void r4) {
            return Boolean.valueOf(SuperficialValidation.validateAnnotations(packageElement.getAnnotationMirrors()));
        }

        public Boolean visitType(TypeElement typeElement, Void r4) {
            return Boolean.valueOf(SuperficialValidation.isValidBaseElement(typeElement) && SuperficialValidation.validateElements(typeElement.getTypeParameters()) && SuperficialValidation.validateTypes(typeElement.getInterfaces()) && SuperficialValidation.validateType(typeElement.getSuperclass()));
        }

        public Boolean visitTypeParameter(TypeParameterElement typeParameterElement, Void r4) {
            return Boolean.valueOf(SuperficialValidation.isValidBaseElement(typeParameterElement) && SuperficialValidation.validateTypes(typeParameterElement.getBounds()));
        }

        public Boolean visitUnknown(Element element, Void r4) {
            return true;
        }

        public Boolean visitVariable(VariableElement variableElement, Void r4) {
            return Boolean.valueOf(SuperficialValidation.isValidBaseElement(variableElement));
        }
    };
    private static final TypeVisitor<Boolean, Void> TYPE_VALIDATING_VISITOR = new SimpleTypeVisitor6<Boolean, Void>() { // from class: com.google.auto.common.SuperficialValidation.2
        /* JADX INFO: Access modifiers changed from: protected */
        public Boolean defaultAction(TypeMirror typeMirror, Void r4) {
            return true;
        }

        public Boolean visitArray(ArrayType arrayType, Void r4) {
            return Boolean.valueOf(SuperficialValidation.validateType(arrayType.getComponentType()));
        }

        public Boolean visitDeclared(DeclaredType declaredType, Void r4) {
            return Boolean.valueOf(SuperficialValidation.validateTypes(declaredType.getTypeArguments()));
        }

        public Boolean visitError(ErrorType errorType, Void r4) {
            return false;
        }

        public Boolean visitExecutable(ExecutableType executableType, Void r4) {
            return Boolean.valueOf(SuperficialValidation.validateTypes(executableType.getParameterTypes()) && SuperficialValidation.validateType(executableType.getReturnType()) && SuperficialValidation.validateTypes(executableType.getThrownTypes()) && SuperficialValidation.validateTypes(executableType.getTypeVariables()));
        }

        public Boolean visitUnknown(TypeMirror typeMirror, Void r6) {
            return defaultAction(typeMirror, r6);
        }

        public Boolean visitWildcard(WildcardType wildcardType, Void r4) {
            TypeMirror extendsBound = wildcardType.getExtendsBound();
            TypeMirror superBound = wildcardType.getSuperBound();
            return Boolean.valueOf((extendsBound == null || SuperficialValidation.validateType(extendsBound)) && (superBound == null || SuperficialValidation.validateType(superBound)));
        }
    };
    private static final AnnotationValueVisitor<Boolean, TypeMirror> VALUE_VALIDATING_VISITOR = new SimpleAnnotationValueVisitor6<Boolean, TypeMirror>() { // from class: com.google.auto.common.SuperficialValidation.3
        /* JADX INFO: Access modifiers changed from: protected */
        public Boolean defaultAction(Object obj, TypeMirror typeMirror) {
            return Boolean.valueOf(MoreTypes.isTypeOf(obj.getClass(), typeMirror));
        }

        public Boolean visitAnnotation(AnnotationMirror annotationMirror, TypeMirror typeMirror) {
            return Boolean.valueOf(MoreTypes.equivalence().equivalent(annotationMirror.getAnnotationType(), typeMirror) && SuperficialValidation.validateAnnotation(annotationMirror));
        }

        public Boolean visitArray(List<? extends AnnotationValue> list, TypeMirror typeMirror) {
            if (typeMirror.getKind().equals(TypeKind.ARRAY)) {
                try {
                    TypeMirror componentType = MoreTypes.asArray(typeMirror).getComponentType();
                    for (AnnotationValue annotationValue : list) {
                        if (!((Boolean) annotationValue.accept(this, componentType)).booleanValue()) {
                            return false;
                        }
                    }
                    return true;
                } catch (IllegalArgumentException e) {
                    return false;
                }
            }
            return false;
        }

        public /* bridge */ /* synthetic */ Object visitArray(List list, Object obj) {
            return visitArray((List<? extends AnnotationValue>) list, (TypeMirror) obj);
        }

        public Boolean visitBoolean(boolean z, TypeMirror typeMirror) {
            return Boolean.valueOf(MoreTypes.isTypeOf(Boolean.TYPE, typeMirror));
        }

        public Boolean visitByte(byte b, TypeMirror typeMirror) {
            return Boolean.valueOf(MoreTypes.isTypeOf(Byte.TYPE, typeMirror));
        }

        public Boolean visitChar(char c2, TypeMirror typeMirror) {
            return Boolean.valueOf(MoreTypes.isTypeOf(Character.TYPE, typeMirror));
        }

        public Boolean visitDouble(double d, TypeMirror typeMirror) {
            return Boolean.valueOf(MoreTypes.isTypeOf(Double.TYPE, typeMirror));
        }

        public Boolean visitEnumConstant(VariableElement variableElement, TypeMirror typeMirror) {
            return Boolean.valueOf(MoreTypes.equivalence().equivalent(variableElement.asType(), typeMirror) && SuperficialValidation.validateElement(variableElement));
        }

        public Boolean visitFloat(float f, TypeMirror typeMirror) {
            return Boolean.valueOf(MoreTypes.isTypeOf(Float.TYPE, typeMirror));
        }

        public Boolean visitInt(int i, TypeMirror typeMirror) {
            return Boolean.valueOf(MoreTypes.isTypeOf(Integer.TYPE, typeMirror));
        }

        public Boolean visitLong(long j, TypeMirror typeMirror) {
            return Boolean.valueOf(MoreTypes.isTypeOf(Long.TYPE, typeMirror));
        }

        public Boolean visitShort(short s, TypeMirror typeMirror) {
            return Boolean.valueOf(MoreTypes.isTypeOf(Short.TYPE, typeMirror));
        }

        public Boolean visitType(TypeMirror typeMirror, TypeMirror typeMirror2) {
            return Boolean.valueOf(SuperficialValidation.validateType(typeMirror));
        }

        public Boolean visitUnknown(AnnotationValue annotationValue, TypeMirror typeMirror) {
            return defaultAction((Object) annotationValue, typeMirror);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isValidBaseElement(Element element) {
        return validateType(element.asType()) && validateAnnotations(element.getAnnotationMirrors()) && validateElements(element.getEnclosedElements());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean validateAnnotation(AnnotationMirror annotationMirror) {
        return validateType(annotationMirror.getAnnotationType()) && validateAnnotationValues(annotationMirror.getElementValues());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean validateAnnotationValue(AnnotationValue annotationValue, TypeMirror typeMirror) {
        return ((Boolean) annotationValue.accept(VALUE_VALIDATING_VISITOR, typeMirror)).booleanValue();
    }

    private static boolean validateAnnotationValues(Map<? extends ExecutableElement, ? extends AnnotationValue> map) {
        for (Map.Entry<? extends ExecutableElement, ? extends AnnotationValue> entry : map.entrySet()) {
            if (!validateAnnotationValue(entry.getValue(), entry.getKey().getReturnType())) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean validateAnnotations(Iterable<? extends AnnotationMirror> iterable) {
        for (AnnotationMirror annotationMirror : iterable) {
            if (!validateAnnotation(annotationMirror)) {
                return false;
            }
        }
        return true;
    }

    public static boolean validateElement(Element element) {
        return ((Boolean) element.accept(ELEMENT_VALIDATING_VISITOR, (Object) null)).booleanValue();
    }

    public static boolean validateElements(Iterable<? extends Element> iterable) {
        for (Element element : iterable) {
            if (!validateElement(element)) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean validateType(TypeMirror typeMirror) {
        return ((Boolean) typeMirror.accept(TYPE_VALIDATING_VISITOR, (Object) null)).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean validateTypes(Iterable<? extends TypeMirror> iterable) {
        for (TypeMirror typeMirror : iterable) {
            if (!validateType(typeMirror)) {
                return false;
            }
        }
        return true;
    }
}
