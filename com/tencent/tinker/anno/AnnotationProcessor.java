package com.tencent.tinker.anno;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;
import javax.tools.JavaFileObject;

@SupportedSourceVersion(SourceVersion.RELEASE_7)
/* loaded from: source-8829756-dex2jar.jar:com/tencent/tinker/anno/AnnotationProcessor.class */
public class AnnotationProcessor extends AbstractProcessor {
    private static final String APPLICATION_TEMPLATE_PATH = "/TinkerAnnoApplication.tmpl";
    private static final String SUFFIX = "$$DefaultLifeCycle";

    private void processDefaultLifeCycle(Set<? extends Element> set) {
        Iterator<? extends Element> it = set.iterator();
        while (it.hasNext()) {
            TypeElement typeElement = (Element) it.next();
            DefaultLifeCycle defaultLifeCycle = (DefaultLifeCycle) typeElement.getAnnotation(DefaultLifeCycle.class);
            String obj = typeElement.getQualifiedName().toString();
            String substring = obj.substring(0, obj.lastIndexOf(46));
            String substring2 = obj.substring(obj.lastIndexOf(46) + 1);
            String application = defaultLifeCycle.application();
            String str = application;
            if (application.startsWith(".")) {
                str = substring + application;
            }
            String substring3 = str.substring(0, str.lastIndexOf(46));
            String substring4 = str.substring(str.lastIndexOf(46) + 1);
            String loaderClass = defaultLifeCycle.loaderClass();
            String str2 = loaderClass;
            if (loaderClass.startsWith(".")) {
                str2 = substring + loaderClass;
            }
            String replaceAll = new Scanner(AnnotationProcessor.class.getResourceAsStream(APPLICATION_TEMPLATE_PATH)).useDelimiter("\\A").next().replaceAll("%PACKAGE%", substring3).replaceAll("%APPLICATION%", substring4).replaceAll("%APPLICATION_LIFE_CYCLE%", substring + "." + substring2);
            StringBuilder sb = new StringBuilder();
            sb.append("");
            sb.append(defaultLifeCycle.flags());
            String replaceAll2 = replaceAll.replaceAll("%TINKER_FLAGS%", sb.toString()).replaceAll("%TINKER_LOADER_CLASS%", "" + str2).replaceAll("%TINKER_LOAD_VERIFY_FLAG%", "" + defaultLifeCycle.loadVerifyFlag()).replaceAll("%TINKER_USE_DLC%", "" + defaultLifeCycle.useDelegateLastClassLoader());
            try {
                JavaFileObject createSourceFile = this.processingEnv.getFiler().createSourceFile(substring3 + "." + substring4, new Element[0]);
                this.processingEnv.getMessager().printMessage(Diagnostic.Kind.NOTE, "Creating " + createSourceFile.toUri());
                Writer openWriter = createSourceFile.openWriter();
                PrintWriter printWriter = new PrintWriter(openWriter);
                printWriter.print(replaceAll2);
                printWriter.flush();
                openWriter.close();
            } catch (IOException e) {
                this.processingEnv.getMessager().printMessage(Diagnostic.Kind.ERROR, e.toString());
            }
        }
    }

    public Set<String> getSupportedAnnotationTypes() {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.add(DefaultLifeCycle.class.getName());
        return linkedHashSet;
    }

    public boolean process(Set<? extends TypeElement> set, RoundEnvironment roundEnvironment) {
        processDefaultLifeCycle(roundEnvironment.getElementsAnnotatedWith(DefaultLifeCycle.class));
        return true;
    }
}
