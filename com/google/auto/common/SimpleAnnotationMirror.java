package com.google.auto.common;

import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.AnnotationValue;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.DeclaredType;
import javax.lang.model.util.ElementFilter;

/* loaded from: source-8110460-dex2jar.jar:com/google/auto/common/SimpleAnnotationMirror.class */
public final class SimpleAnnotationMirror implements AnnotationMirror {
    private final TypeElement annotationType;
    private final ImmutableMap<ExecutableElement, ? extends AnnotationValue> elementValues;
    private final ImmutableMap<String, ? extends AnnotationValue> namedValues;

    private SimpleAnnotationMirror(TypeElement typeElement, Map<String, ? extends AnnotationValue> map) {
        Preconditions.checkArgument(typeElement.getKind().equals(ElementKind.ANNOTATION_TYPE), "annotationType must be an annotation: %s", typeElement);
        final LinkedHashMap linkedHashMap = new LinkedHashMap();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(map);
        ArrayList arrayList = new ArrayList();
        for (ExecutableElement executableElement : ElementFilter.methodsIn(typeElement.getEnclosedElements())) {
            String obj = executableElement.getSimpleName().toString();
            if (linkedHashMap2.containsKey(obj)) {
                linkedHashMap.put(obj, linkedHashMap2.remove(obj));
            } else if (executableElement.getDefaultValue() != null) {
                linkedHashMap.put(obj, executableElement.getDefaultValue());
            } else {
                arrayList.add(obj);
            }
        }
        Preconditions.checkArgument(linkedHashMap2.isEmpty(), "namedValues has entries for members that are not in %s: %s", typeElement, linkedHashMap2);
        Preconditions.checkArgument(arrayList.isEmpty(), "namedValues is missing entries for: %s", arrayList);
        this.annotationType = typeElement;
        this.namedValues = ImmutableMap.copyOf((Map) map);
        this.elementValues = (ImmutableMap) ElementFilter.methodsIn(typeElement.getEnclosedElements()).stream().collect(ImmutableMap.toImmutableMap(new Function() { // from class: com.google.auto.common.-$$Lambda$SimpleAnnotationMirror$w__eFBjV9m1l-pGPBFxprZMqwJ8
            @Override // java.util.function.Function
            public final Object apply(Object obj2) {
                return SimpleAnnotationMirror.lambda$new$0((ExecutableElement) obj2);
            }
        }, new Function() { // from class: com.google.auto.common.-$$Lambda$SimpleAnnotationMirror$UB0XDZaEec7eqFlNYR8OgycSdzg
            @Override // java.util.function.Function
            public final Object apply(Object obj2) {
                return SimpleAnnotationMirror.lambda$new$1(linkedHashMap, (ExecutableElement) obj2);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ ExecutableElement lambda$new$0(ExecutableElement executableElement) {
        return executableElement;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ AnnotationValue lambda$new$1(Map map, ExecutableElement executableElement) {
        return (AnnotationValue) map.get(executableElement.getSimpleName().toString());
    }

    public static AnnotationMirror of(TypeElement typeElement) {
        return of(typeElement, ImmutableMap.of());
    }

    public static AnnotationMirror of(TypeElement typeElement, Map<String, ? extends AnnotationValue> map) {
        return new SimpleAnnotationMirror(typeElement, map);
    }

    public boolean equals(Object obj) {
        return (obj instanceof AnnotationMirror) && AnnotationMirrors.equivalence().equivalent(this, (AnnotationMirror) obj);
    }

    public DeclaredType getAnnotationType() {
        return MoreTypes.asDeclared(this.annotationType.asType());
    }

    public Map<ExecutableElement, ? extends AnnotationValue> getElementValues() {
        return this.elementValues;
    }

    public int hashCode() {
        return AnnotationMirrors.equivalence().hash(this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("@");
        sb.append((CharSequence) this.annotationType.getQualifiedName());
        if (!this.namedValues.isEmpty()) {
            sb.append('(');
            sb.append(Joiner.on(", ").withKeyValueSeparator(" = ").join(this.namedValues));
            sb.append(')');
        }
        return sb.toString();
    }
}
