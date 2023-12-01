package androidx.appcompat.view;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuItemWrapperICS;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.ActionProvider;
import androidx.core.view.MenuItemCompat;
import com.bytedance.applog.tracker.Tracker;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: source-8756600-dex2jar.jar:androidx/appcompat/view/SupportMenuInflater.class */
public class SupportMenuInflater extends MenuInflater {

    /* renamed from: a  reason: collision with root package name */
    static final Class<?>[] f1642a;
    static final Class<?>[] b;

    /* renamed from: c  reason: collision with root package name */
    final Object[] f1643c;
    final Object[] d;
    Context e;
    private Object f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/appcompat/view/SupportMenuInflater$InflatedOnMenuItemClickListener.class */
    public static class InflatedOnMenuItemClickListener implements MenuItem.OnMenuItemClickListener {

        /* renamed from: a  reason: collision with root package name */
        private static final Class<?>[] f1644a = {MenuItem.class};
        private Object b;

        /* renamed from: c  reason: collision with root package name */
        private Method f1645c;

        public InflatedOnMenuItemClickListener(Object obj, String str) {
            this.b = obj;
            Class<?> cls = obj.getClass();
            try {
                this.f1645c = cls.getMethod(str, f1644a);
            } catch (Exception e) {
                InflateException inflateException = new InflateException("Couldn't resolve menu item onClick handler " + str + " in class " + cls.getName());
                inflateException.initCause(e);
                throw inflateException;
            }
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            Tracker.onMenuItemClick(menuItem);
            try {
                if (this.f1645c.getReturnType() == Boolean.TYPE) {
                    return ((Boolean) this.f1645c.invoke(this.b, menuItem)).booleanValue();
                }
                this.f1645c.invoke(this.b, menuItem);
                return true;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/appcompat/view/SupportMenuInflater$MenuState.class */
    public class MenuState {
        private String A;
        private String B;
        private CharSequence C;
        private CharSequence D;
        private ColorStateList E = null;
        private PorterDuff.Mode F = null;

        /* renamed from: a  reason: collision with root package name */
        ActionProvider f1646a;

        /* renamed from: c  reason: collision with root package name */
        private Menu f1647c;
        private int d;
        private int e;
        private int f;
        private int g;
        private boolean h;
        private boolean i;
        private boolean j;
        private int k;
        private int l;
        private CharSequence m;
        private CharSequence n;
        private int o;
        private char p;
        private int q;
        private char r;
        private int s;
        private int t;
        private boolean u;
        private boolean v;
        private boolean w;
        private int x;
        private int y;
        private String z;

        public MenuState(Menu menu) {
            this.f1647c = menu;
            resetGroup();
        }

        private char a(String str) {
            if (str == null) {
                return (char) 0;
            }
            return str.charAt(0);
        }

        private <T> T a(String str, Class<?>[] clsArr, Object[] objArr) {
            try {
                Constructor<?> constructor = Class.forName(str, false, SupportMenuInflater.this.e.getClassLoader()).getConstructor(clsArr);
                constructor.setAccessible(true);
                return (T) constructor.newInstance(objArr);
            } catch (Exception e) {
                Log.w("SupportMenuInflater", "Cannot instantiate class: " + str, e);
                return null;
            }
        }

        private void a(MenuItem menuItem) {
            boolean z = false;
            menuItem.setChecked(this.u).setVisible(this.v).setEnabled(this.w).setCheckable(this.t >= 1).setTitleCondensed(this.n).setIcon(this.o);
            int i = this.x;
            if (i >= 0) {
                menuItem.setShowAsAction(i);
            }
            if (this.B != null) {
                if (SupportMenuInflater.this.e.isRestricted()) {
                    throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
                }
                menuItem.setOnMenuItemClickListener(new InflatedOnMenuItemClickListener(SupportMenuInflater.this.a(), this.B));
            }
            if (this.t >= 2) {
                if (menuItem instanceof MenuItemImpl) {
                    ((MenuItemImpl) menuItem).setExclusiveCheckable(true);
                } else if (menuItem instanceof MenuItemWrapperICS) {
                    ((MenuItemWrapperICS) menuItem).setExclusiveCheckable(true);
                }
            }
            String str = this.z;
            if (str != null) {
                menuItem.setActionView((View) a(str, SupportMenuInflater.f1642a, SupportMenuInflater.this.f1643c));
                z = true;
            }
            int i2 = this.y;
            if (i2 > 0) {
                if (z) {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
                } else {
                    menuItem.setActionView(i2);
                }
            }
            ActionProvider actionProvider = this.f1646a;
            if (actionProvider != null) {
                MenuItemCompat.setActionProvider(menuItem, actionProvider);
            }
            MenuItemCompat.setContentDescription(menuItem, this.C);
            MenuItemCompat.setTooltipText(menuItem, this.D);
            MenuItemCompat.setAlphabeticShortcut(menuItem, this.p, this.q);
            MenuItemCompat.setNumericShortcut(menuItem, this.r, this.s);
            PorterDuff.Mode mode = this.F;
            if (mode != null) {
                MenuItemCompat.setIconTintMode(menuItem, mode);
            }
            ColorStateList colorStateList = this.E;
            if (colorStateList != null) {
                MenuItemCompat.setIconTintList(menuItem, colorStateList);
            }
        }

        public void addItem() {
            this.j = true;
            a(this.f1647c.add(this.d, this.k, this.l, this.m));
        }

        public SubMenu addSubMenuItem() {
            this.j = true;
            SubMenu addSubMenu = this.f1647c.addSubMenu(this.d, this.k, this.l, this.m);
            a(addSubMenu.getItem());
            return addSubMenu;
        }

        public boolean hasAddedItem() {
            return this.j;
        }

        public void readGroup(AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = SupportMenuInflater.this.e.obtainStyledAttributes(attributeSet, R.styleable.MenuGroup);
            this.d = obtainStyledAttributes.getResourceId(R.styleable.MenuGroup_android_id, 0);
            this.e = obtainStyledAttributes.getInt(R.styleable.MenuGroup_android_menuCategory, 0);
            this.f = obtainStyledAttributes.getInt(R.styleable.MenuGroup_android_orderInCategory, 0);
            this.g = obtainStyledAttributes.getInt(R.styleable.MenuGroup_android_checkableBehavior, 0);
            this.h = obtainStyledAttributes.getBoolean(R.styleable.MenuGroup_android_visible, true);
            this.i = obtainStyledAttributes.getBoolean(R.styleable.MenuGroup_android_enabled, true);
            obtainStyledAttributes.recycle();
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
        public void readItem(AttributeSet attributeSet) {
            throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
        }

        public void resetGroup() {
            this.d = 0;
            this.e = 0;
            this.f = 0;
            this.g = 0;
            this.h = true;
            this.i = true;
        }
    }

    static {
        Class<?>[] clsArr = {Context.class};
        f1642a = clsArr;
        b = clsArr;
    }

    public SupportMenuInflater(Context context) {
        super(context);
        this.e = context;
        Object[] objArr = {context};
        this.f1643c = objArr;
        this.d = objArr;
    }

    private Object a(Object obj) {
        if (obj instanceof Activity) {
            return obj;
        }
        Object obj2 = obj;
        if (obj instanceof ContextWrapper) {
            obj2 = a(((ContextWrapper) obj).getBaseContext());
        }
        return obj2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x006b, code lost:
        r14 = null;
        r10 = false;
        r11 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0076, code lost:
        if (r10 != false) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x007c, code lost:
        if (r9 == 1) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0082, code lost:
        if (r9 == 2) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0088, code lost:
        if (r9 == 3) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x008b, code lost:
        r12 = r10;
        r9 = r11;
        r8 = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0099, code lost:
        r0 = r6.getName();
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x00a3, code lost:
        if (r11 == false) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00ad, code lost:
        if (r0.equals(r14) == false) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00b0, code lost:
        r8 = null;
        r9 = false;
        r12 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00c3, code lost:
        if (r0.equals("group") == false) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00c6, code lost:
        r0.resetGroup();
        r12 = r10;
        r9 = r11;
        r8 = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00e0, code lost:
        if (r0.equals("item") == false) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00e3, code lost:
        r12 = r10;
        r9 = r11;
        r8 = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00f3, code lost:
        if (r0.hasAddedItem() != false) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00fb, code lost:
        if (r0.f1646a == null) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0106, code lost:
        if (r0.f1646a.hasSubMenu() == false) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0109, code lost:
        r0.addSubMenuItem();
        r12 = r10;
        r9 = r11;
        r8 = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x011d, code lost:
        r0.addItem();
        r12 = r10;
        r9 = r11;
        r8 = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0130, code lost:
        r12 = r10;
        r9 = r11;
        r8 = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0142, code lost:
        if (r0.equals(com.android.internal.util.cm.NavigationRingConstants.ACTION_MENU) == false) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0145, code lost:
        r12 = true;
        r9 = r11;
        r8 = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0154, code lost:
        if (r11 == false) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0157, code lost:
        r12 = r10;
        r9 = r11;
        r8 = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0165, code lost:
        r8 = r6.getName();
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0172, code lost:
        if (r8.equals("group") == false) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0175, code lost:
        r0.readGroup(r7);
        r12 = r10;
        r9 = r11;
        r8 = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x018f, code lost:
        if (r8.equals("item") == false) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0192, code lost:
        r0.readItem(r7);
        r12 = r10;
        r9 = r11;
        r8 = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x01ac, code lost:
        if (r8.equals(com.android.internal.util.cm.NavigationRingConstants.ACTION_MENU) == false) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x01af, code lost:
        a(r6, r7, r0.addSubMenuItem());
        r12 = r10;
        r9 = r11;
        r8 = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x01c8, code lost:
        r9 = true;
        r12 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x01cf, code lost:
        r10 = r12;
        r11 = r9;
        r14 = r8;
        r9 = r6.next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x01f2, code lost:
        throw new java.lang.RuntimeException("Unexpected end of document");
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x01f3, code lost:
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(org.xmlpull.v1.XmlPullParser r6, android.util.AttributeSet r7, android.view.Menu r8) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 500
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.view.SupportMenuInflater.a(org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.view.Menu):void");
    }

    Object a() {
        if (this.f == null) {
            this.f = a(this.e);
        }
        return this.f;
    }

    @Override // android.view.MenuInflater
    public void inflate(int i, Menu menu) {
        if (!(menu instanceof SupportMenu)) {
            super.inflate(i, menu);
            return;
        }
        XmlResourceParser xmlResourceParser = null;
        XmlResourceParser xmlResourceParser2 = null;
        XmlResourceParser xmlResourceParser3 = null;
        try {
            try {
                XmlResourceParser layout = this.e.getResources().getLayout(i);
                xmlResourceParser3 = layout;
                xmlResourceParser = layout;
                xmlResourceParser2 = layout;
                a(layout, Xml.asAttributeSet(layout), menu);
                if (layout != null) {
                    layout.close();
                }
            } catch (IOException e) {
                throw new InflateException("Error inflating menu XML", e);
            } catch (XmlPullParserException e2) {
                throw new InflateException("Error inflating menu XML", e2);
            }
        } catch (Throwable th) {
            if (xmlResourceParser3 != null) {
                xmlResourceParser3.close();
            }
            throw th;
        }
    }
}
