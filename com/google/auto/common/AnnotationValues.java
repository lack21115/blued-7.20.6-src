package com.google.auto.common;

import com.google.common.base.Equivalence;
import java.util.List;
import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.AnnotationValue;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.util.SimpleAnnotationValueVisitor6;

/* loaded from: source-8110460-dex2jar.jar:com/google/auto/common/AnnotationValues.class */
public final class AnnotationValues {
    private static final Equivalence<AnnotationValue> ANNOTATION_VALUE_EQUIVALENCE = new Equivalence<AnnotationValue>() { // from class: com.google.auto.common.AnnotationValues.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.base.Equivalence
        public boolean doEquivalent(AnnotationValue annotationValue, AnnotationValue annotationValue2) {
            return ((Boolean) annotationValue.accept(new SimpleAnnotationValueVisitor6<Boolean, AnnotationValue>() { // from class: com.google.auto.common.AnnotationValues.1.1
                /* JADX INFO: Access modifiers changed from: protected */
                public Boolean defaultAction(Object obj, AnnotationValue annotationValue3) {
                    return Boolean.valueOf(obj.equals(annotationValue3.accept(new SimpleAnnotationValueVisitor6<Object, Void>() { // from class: com.google.auto.common.AnnotationValues.1.1.1
                        /* JADX INFO: Access modifiers changed from: protected */
                        public Object defaultAction(Object obj2, Void r4) {
                            return obj2;
                        }
                    }, (Object) null)));
                }

                public Boolean visitAnnotation(AnnotationMirror annotationMirror, AnnotationValue annotationValue3) {
                    return (Boolean) annotationValue3.accept(new SimpleAnnotationValueVisitor6<Boolean, AnnotationMirror>() { // from class: com.google.auto.common.AnnotationValues.1.1.2
                        /* JADX INFO: Access modifiers changed from: protected */
                        public Boolean defaultAction(Object obj, AnnotationMirror annotationMirror2) {
                            return false;
                        }

                        public Boolean visitAnnotation(AnnotationMirror annotationMirror2, AnnotationMirror annotationMirror3) {
                            return Boolean.valueOf(AnnotationMirrors.equivalence().equivalent(annotationMirror3, annotationMirror2));
                        }
                    }, annotationMirror);
                }

                public Boolean visitArray(List<? extends AnnotationValue> list, AnnotationValue annotationValue3) {
                    return (Boolean) annotationValue3.accept(new SimpleAnnotationValueVisitor6<Boolean, List<? extends AnnotationValue>>() { // from class: com.google.auto.common.AnnotationValues.1.1.3
                        /* JADX INFO: Access modifiers changed from: protected */
                        public Boolean defaultAction(Object obj, List<? extends AnnotationValue> list2) {
                            return false;
                        }

                        public Boolean visitArray(List<? extends AnnotationValue> list2, List<? extends AnnotationValue> list3) {
                            return Boolean.valueOf(AnnotationValues.equivalence().pairwise().equivalent(list3, list2));
                        }

                        public /* bridge */ /* synthetic */ Object visitArray(List list2, Object obj) {
                            return visitArray((List<? extends AnnotationValue>) list2, (List) obj);
                        }
                    }, list);
                }

                public /* bridge */ /* synthetic */ Object visitArray(List list, Object obj) {
                    return visitArray((List<? extends AnnotationValue>) list, (AnnotationValue) obj);
                }

                public Boolean visitType(TypeMirror typeMirror, AnnotationValue annotationValue3) {
                    return (Boolean) annotationValue3.accept(new SimpleAnnotationValueVisitor6<Boolean, TypeMirror>() { // from class: com.google.auto.common.AnnotationValues.1.1.4
                        /* JADX INFO: Access modifiers changed from: protected */
                        public Boolean defaultAction(Object obj, TypeMirror typeMirror2) {
                            return false;
                        }

                        public Boolean visitType(TypeMirror typeMirror2, TypeMirror typeMirror3) {
                            return Boolean.valueOf(MoreTypes.equivalence().equivalent(typeMirror3, typeMirror2));
                        }
                    }, typeMirror);
                }
            }, annotationValue2)).booleanValue();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.base.Equivalence
        public int doHash(AnnotationValue annotationValue) {
            return ((Integer) annotationValue.accept(new SimpleAnnotationValueVisitor6<Integer, Void>() { // from class: com.google.auto.common.AnnotationValues.1.2
                /* JADX INFO: Access modifiers changed from: protected */
                public Integer defaultAction(Object obj, Void r4) {
                    return Integer.valueOf(obj.hashCode());
                }

                public Integer visitAnnotation(AnnotationMirror annotationMirror, Void r5) {
                    return Integer.valueOf(AnnotationMirrors.equivalence().hash(annotationMirror));
                }

                public Integer visitArray(List<? extends AnnotationValue> list, Void r5) {
                    return Integer.valueOf(AnnotationValues.equivalence().pairwise().hash(list));
                }

                public /* bridge */ /* synthetic */ Object visitArray(List list, Object obj) {
                    return visitArray((List<? extends AnnotationValue>) list, (Void) obj);
                }

                public Integer visitType(TypeMirror typeMirror, Void r5) {
                    return Integer.valueOf(MoreTypes.equivalence().hash(typeMirror));
                }
            }, (Object) null)).intValue();
        }
    };

    private AnnotationValues() {
    }

    public static Equivalence<AnnotationValue> equivalence() {
        return ANNOTATION_VALUE_EQUIVALENCE;
    }
}
