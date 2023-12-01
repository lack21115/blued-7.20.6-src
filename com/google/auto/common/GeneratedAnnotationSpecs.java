package com.google.auto.common;

import android.provider.ContactsContract;
import com.squareup.javapoet.AnnotationSpec;
import com.squareup.javapoet.ClassName;
import java.util.Optional;
import java.util.function.Function;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.Elements;

/* loaded from: source-8110460-dex2jar.jar:com/google/auto/common/GeneratedAnnotationSpecs.class */
public final class GeneratedAnnotationSpecs {
    private GeneratedAnnotationSpecs() {
    }

    @Deprecated
    public static Optional<AnnotationSpec> generatedAnnotationSpec(Elements elements, Class<?> cls) {
        return generatedAnnotationSpecBuilder(elements, cls).map($$Lambda$GeneratedAnnotationSpecs$M6opZya8CNYuC2PK3RfVwXq0r2I.INSTANCE);
    }

    @Deprecated
    public static Optional<AnnotationSpec> generatedAnnotationSpec(Elements elements, Class<?> cls, final String str) {
        return generatedAnnotationSpecBuilder(elements, cls).map(new Function() { // from class: com.google.auto.common.-$$Lambda$GeneratedAnnotationSpecs$ozDHBZ-RnCt1UM6WEUcc6ChBrFI
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                AnnotationSpec build;
                build = ((AnnotationSpec.Builder) obj).addMember(ContactsContract.StreamItemsColumns.COMMENTS, "$S", new Object[]{str}).build();
                return build;
            }
        });
    }

    public static Optional<AnnotationSpec> generatedAnnotationSpec(Elements elements, SourceVersion sourceVersion, Class<?> cls) {
        return generatedAnnotationSpecBuilder(elements, sourceVersion, cls).map($$Lambda$GeneratedAnnotationSpecs$M6opZya8CNYuC2PK3RfVwXq0r2I.INSTANCE);
    }

    public static Optional<AnnotationSpec> generatedAnnotationSpec(Elements elements, SourceVersion sourceVersion, Class<?> cls, final String str) {
        return generatedAnnotationSpecBuilder(elements, sourceVersion, cls).map(new Function() { // from class: com.google.auto.common.-$$Lambda$GeneratedAnnotationSpecs$DFhvX9UWY6WZPg1KAAtRkSOn-w8
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                AnnotationSpec build;
                build = ((AnnotationSpec.Builder) obj).addMember(ContactsContract.StreamItemsColumns.COMMENTS, "$S", new Object[]{str}).build();
                return build;
            }
        });
    }

    private static Optional<AnnotationSpec.Builder> generatedAnnotationSpecBuilder(Elements elements, final Class<?> cls) {
        return GeneratedAnnotations.generatedAnnotation(elements).map(new Function() { // from class: com.google.auto.common.-$$Lambda$GeneratedAnnotationSpecs$xYb19lJcpHzJMLzL6q1dh9wwsY4
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                AnnotationSpec.Builder addMember;
                addMember = AnnotationSpec.builder(ClassName.get((TypeElement) obj)).addMember("value", "$S", new Object[]{cls.getCanonicalName()});
                return addMember;
            }
        });
    }

    private static Optional<AnnotationSpec.Builder> generatedAnnotationSpecBuilder(Elements elements, SourceVersion sourceVersion, final Class<?> cls) {
        return GeneratedAnnotations.generatedAnnotation(elements, sourceVersion).map(new Function() { // from class: com.google.auto.common.-$$Lambda$GeneratedAnnotationSpecs$PqbkjZnROsGkGnp3KvI3PUAobKc
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                AnnotationSpec.Builder addMember;
                addMember = AnnotationSpec.builder(ClassName.get((TypeElement) obj)).addMember("value", "$S", new Object[]{cls.getCanonicalName()});
                return addMember;
            }
        });
    }
}
