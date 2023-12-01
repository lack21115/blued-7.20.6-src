package com.huawei.hms.ads;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Xml;
import android.view.InflateException;
import android.view.View;
import android.view.ViewGroup;
import com.huawei.hms.ads.template.view.DynamicTemplateView;
import java.io.Reader;
import java.io.StringReader;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/dl.class */
public abstract class dl {
    final Object[] Code = new Object[2];
    private final Context I;
    private static final Class<?>[] Z = {Context.class, AttributeSet.class};
    private static final HashMap<String, Constructor<? extends View>> B = new HashMap<>();
    private static final ClassLoader C = dl.class.getClassLoader();

    /* JADX INFO: Access modifiers changed from: protected */
    public dl(Context context) {
        this.I = context;
    }

    private Context Code() {
        return this.I;
    }

    private View Code(String str, Context context, AttributeSet attributeSet) {
        String str2 = str;
        if (str.equals(com.anythink.expressad.a.B)) {
            str2 = attributeSet.getAttributeValue(null, "class");
        }
        String V = V(str2);
        if (TextUtils.isEmpty(V)) {
            throw new InflateException("Tag " + V + " is not defined!");
        }
        try {
            Object obj = this.Code[0];
            this.Code[0] = context;
            try {
                View Code = -1 == V.indexOf(46) ? Code(V, attributeSet) : Code(V, (String) null, attributeSet);
                this.Code[0] = obj;
                return Code;
            } catch (Throwable th) {
                this.Code[0] = obj;
                throw th;
            }
        } catch (InflateException e) {
            throw e;
        } catch (Exception e2) {
            throw new InflateException("error processing class " + V, e2);
        }
    }

    private View Code(String str, AttributeSet attributeSet) {
        return Code(str, "android.view.", attributeSet);
    }

    private View Code(XmlPullParser xmlPullParser, ViewGroup viewGroup) {
        int next;
        View Code;
        synchronized (this.Code) {
            ge.V("DynamicTemplateCreator", "create");
            AttributeSet asAttributeSet = Xml.asAttributeSet(xmlPullParser);
            Context context = (Context) this.Code[0];
            this.Code[0] = this.I;
            do {
                try {
                    next = xmlPullParser.next();
                    if (next == 2) {
                        break;
                    }
                } catch (XmlPullParserException e) {
                    throw new InflateException(e.getMessage(), e);
                }
            } while (next != 1);
            if (next != 2) {
                throw new InflateException(xmlPullParser.getPositionDescription() + " no start tag");
            }
            Code = Code(xmlPullParser, viewGroup, this.I, asAttributeSet, viewGroup, xmlPullParser.getName());
            this.Code[0] = context;
            this.Code[1] = null;
        }
        return Code;
    }

    private View Code(XmlPullParser xmlPullParser, ViewGroup viewGroup, Context context, AttributeSet attributeSet, View view, String str) {
        View Code = Code(str, context, attributeSet);
        ViewGroup.LayoutParams generateLayoutParams = viewGroup != null ? viewGroup.generateLayoutParams(attributeSet) : null;
        Code(xmlPullParser, Code, attributeSet);
        if (viewGroup != null) {
            viewGroup.addView(Code, generateLayoutParams);
        }
        if (viewGroup == null) {
            view = Code;
        }
        return view;
    }

    public static dl Code(Context context) {
        return new dm(context);
    }

    private DynamicTemplateView Code(Reader reader) {
        StringBuilder sb;
        String message;
        DynamicTemplateView dynamicTemplateView = new DynamicTemplateView(Code());
        try {
            XmlPullParser newPullParser = XmlPullParserFactory.newInstance().newPullParser();
            newPullParser.setInput(reader);
            Code(newPullParser, dynamicTemplateView);
            return dynamicTemplateView;
        } catch (XmlPullParserException e) {
            ge.I("DynamicTemplateCreator", "create error in create XmlPullParserFactory" + e.getClass().getSimpleName());
            sb = new StringBuilder();
            sb.append("create error in create XmlPullParserFactory");
            message = e.getMessage();
            sb.append(message);
            ge.Code("DynamicTemplateCreator", sb.toString());
            return dynamicTemplateView;
        } catch (Throwable th) {
            ge.I("DynamicTemplateCreator", "create error" + th.getClass().getSimpleName());
            sb = new StringBuilder();
            sb.append("create error");
            message = th.getMessage();
            sb.append(message);
            ge.Code("DynamicTemplateCreator", sb.toString());
            return dynamicTemplateView;
        }
    }

    private Constructor<? extends View> Code(String str, Class<? extends View> cls) {
        Constructor<? extends View> constructor = cls.getConstructor(Z);
        constructor.setAccessible(true);
        B.put(str, constructor);
        return constructor;
    }

    private final boolean Code(Constructor<? extends View> constructor) {
        ClassLoader parent;
        ClassLoader classLoader = constructor.getDeclaringClass().getClassLoader();
        if (classLoader == C) {
            return true;
        }
        ClassLoader classLoader2 = this.I.getClassLoader();
        ClassLoader classLoader3 = classLoader2;
        if (classLoader == classLoader2) {
            return true;
        }
        do {
            parent = classLoader3.getParent();
            if (parent == null) {
                return false;
            }
            classLoader3 = parent;
        } while (classLoader != parent);
        return true;
    }

    public final View Code(String str, String str2, AttributeSet attributeSet) {
        Class<? extends View> cls;
        String str3;
        Constructor<? extends View> constructor = B.get(str);
        Class<? extends View> cls2 = null;
        Constructor<? extends View> constructor2 = constructor;
        if (constructor != null) {
            constructor2 = constructor;
            if (!Code(constructor)) {
                B.remove(str);
                constructor2 = null;
            }
        }
        Constructor<? extends View> constructor3 = constructor2;
        if (constructor2 == null) {
            cls = null;
            try {
                ClassLoader classLoader = this.I.getClassLoader();
                if (str2 != null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(str2);
                    sb.append(str);
                    str3 = sb.toString();
                } else {
                    str3 = str;
                }
                cls2 = classLoader.loadClass(str3).asSubclass(View.class);
                constructor3 = Code(str, cls2);
            } catch (NoSuchMethodException e) {
                throw new InflateException("error processing " + str, e);
            } catch (RuntimeException e2) {
                throw e2;
            } catch (Exception e3) {
                throw new InflateException("error processing " + cls, e3);
            }
        }
        Class<? extends View> cls3 = cls2;
        Object obj = this.Code[0];
        Class<? extends View> cls4 = cls2;
        if (this.Code[0] == null) {
            Class<? extends View> cls5 = cls2;
            this.Code[0] = this.I;
        }
        Class<? extends View> cls6 = cls2;
        Object[] objArr = this.Code;
        objArr[1] = attributeSet;
        View newInstance = constructor3.newInstance(objArr);
        cls = cls2;
        this.Code[0] = obj;
        return newInstance;
    }

    public DynamicTemplateView Code(String str) {
        if (TextUtils.isEmpty(str)) {
            ge.I("DynamicTemplateCreator", "create - input xml layout is empty");
            return new DynamicTemplateView(Code());
        }
        return Code(new StringReader(str));
    }

    void Code(XmlPullParser xmlPullParser, View view, Context context, AttributeSet attributeSet) {
        int depth = xmlPullParser.getDepth();
        while (true) {
            int next = xmlPullParser.next();
            if ((next == 3 && xmlPullParser.getDepth() <= depth) || next == 1) {
                return;
            }
            if (next == 2) {
                View Code = Code(xmlPullParser.getName(), context, attributeSet);
                ViewGroup viewGroup = (ViewGroup) view;
                ViewGroup.LayoutParams generateLayoutParams = viewGroup.generateLayoutParams(attributeSet);
                Code(xmlPullParser, Code, attributeSet);
                viewGroup.addView(Code, generateLayoutParams);
            }
        }
    }

    final void Code(XmlPullParser xmlPullParser, View view, AttributeSet attributeSet) {
        Code(xmlPullParser, view, view.getContext(), attributeSet);
    }

    protected String V(String str) {
        return str;
    }
}
