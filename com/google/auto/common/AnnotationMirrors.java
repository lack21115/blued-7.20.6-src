package com.google.auto.common;

import com.google.common.base.Equivalence;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.UnmodifiableIterator;
import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.Map;
import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.AnnotationValue;
import javax.lang.model.element.Element;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.util.ElementFilter;

/* loaded from: source-8110460-dex2jar.jar:com/google/auto/common/AnnotationMirrors.class */
public final class AnnotationMirrors {
    private static final Equivalence<AnnotationMirror> ANNOTATION_MIRROR_EQUIVALENCE = new Equivalence<AnnotationMirror>() { // from class: com.google.auto.common.AnnotationMirrors.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.base.Equivalence
        public boolean doEquivalent(AnnotationMirror annotationMirror, AnnotationMirror annotationMirror2) {
            return MoreTypes.equivalence().equivalent(annotationMirror.getAnnotationType(), annotationMirror2.getAnnotationType()) && AnnotationValues.equivalence().pairwise().equivalent(AnnotationMirrors.getAnnotationValuesWithDefaults(annotationMirror).values(), AnnotationMirrors.getAnnotationValuesWithDefaults(annotationMirror2).values());
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.base.Equivalence
        public int doHash(AnnotationMirror annotationMirror) {
            return Arrays.hashCode(new int[]{MoreTypes.equivalence().hash(annotationMirror.getAnnotationType()), AnnotationValues.equivalence().pairwise().hash(AnnotationMirrors.getAnnotationValuesWithDefaults(annotationMirror).values())});
        }
    };

    private AnnotationMirrors() {
    }

    public static Equivalence<AnnotationMirror> equivalence() {
        return ANNOTATION_MIRROR_EQUIVALENCE;
    }

    public static ImmutableSet<? extends AnnotationMirror> getAnnotatedAnnotations(Element element, final Class<? extends Annotation> cls) {
        return FluentIterable.from(element.getAnnotationMirrors()).filter(new Predicate<AnnotationMirror>() { // from class: com.google.auto.common.AnnotationMirrors.2
            @Override // com.google.common.base.Predicate
            public boolean apply(AnnotationMirror annotationMirror) {
                return MoreElements.isAnnotationPresent(annotationMirror.getAnnotationType().asElement(), cls);
            }
        }).toSet();
    }

    public static Map.Entry<ExecutableElement, AnnotationValue> getAnnotationElementAndValue(AnnotationMirror annotationMirror, String str) {
        Preconditions.checkNotNull(annotationMirror);
        Preconditions.checkNotNull(str);
        UnmodifiableIterator<Map.Entry<ExecutableElement, AnnotationValue>> it = getAnnotationValuesWithDefaults(annotationMirror).entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<ExecutableElement, AnnotationValue> next = it.next();
            if (next.getKey().getSimpleName().contentEquals(str)) {
                return next;
            }
        }
        throw new IllegalArgumentException(String.format("@%s does not define an element %s()", MoreElements.asType(annotationMirror.getAnnotationType().asElement()).getQualifiedName(), str));
    }

    public static AnnotationValue getAnnotationValue(AnnotationMirror annotationMirror, String str) {
        return getAnnotationElementAndValue(annotationMirror, str).getValue();
    }

    public static ImmutableMap<ExecutableElement, AnnotationValue> getAnnotationValuesWithDefaults(AnnotationMirror annotationMirror) {
        ImmutableMap.Builder builder = ImmutableMap.builder();
        Map elementValues = annotationMirror.getElementValues();
        for (ExecutableElement executableElement : ElementFilter.methodsIn(annotationMirror.getAnnotationType().asElement().getEnclosedElements())) {
            if (elementValues.containsKey(executableElement)) {
                builder.put(executableElement, elementValues.get(executableElement));
            } else if (executableElement.getDefaultValue() == null) {
                throw new IllegalStateException("Unset annotation value without default should never happen: " + MoreElements.asType(executableElement.getEnclosingElement()).getQualifiedName() + '.' + executableElement.getSimpleName() + "()");
            } else {
                builder.put(executableElement, executableElement.getDefaultValue());
            }
        }
        return builder.build();
    }
}
