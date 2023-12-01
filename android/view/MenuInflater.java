package android.view;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.MenuItem;
import com.android.internal.R;
import com.android.internal.view.menu.MenuItemImpl;
import java.io.IOException;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: source-9557208-dex2jar.jar:android/view/MenuInflater.class */
public class MenuInflater {
    private static final String LOG_TAG = "MenuInflater";
    private static final int NO_ID = 0;
    private static final String XML_GROUP = "group";
    private static final String XML_ITEM = "item";
    private static final String XML_MENU = "menu";
    private final Object[] mActionProviderConstructorArguments;
    private final Object[] mActionViewConstructorArguments;
    private Context mContext;
    private Object mRealOwner;
    private static final Class<?>[] ACTION_VIEW_CONSTRUCTOR_SIGNATURE = {Context.class};
    private static final Class<?>[] ACTION_PROVIDER_CONSTRUCTOR_SIGNATURE = ACTION_VIEW_CONSTRUCTOR_SIGNATURE;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/view/MenuInflater$InflatedOnMenuItemClickListener.class */
    public static class InflatedOnMenuItemClickListener implements MenuItem.OnMenuItemClickListener {
        private static final Class<?>[] PARAM_TYPES = {MenuItem.class};
        private Method mMethod;
        private Object mRealOwner;

        public InflatedOnMenuItemClickListener(Object obj, String str) {
            this.mRealOwner = obj;
            Class<?> cls = obj.getClass();
            try {
                this.mMethod = cls.getMethod(str, PARAM_TYPES);
            } catch (Exception e) {
                InflateException inflateException = new InflateException("Couldn't resolve menu item onClick handler " + str + " in class " + cls.getName());
                inflateException.initCause(e);
                throw inflateException;
            }
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            try {
                if (this.mMethod.getReturnType() == Boolean.TYPE) {
                    return ((Boolean) this.mMethod.invoke(this.mRealOwner, menuItem)).booleanValue();
                }
                this.mMethod.invoke(this.mRealOwner, menuItem);
                return true;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/view/MenuInflater$MenuState.class */
    public class MenuState {
        private static final int defaultGroupId = 0;
        private static final int defaultItemCategory = 0;
        private static final int defaultItemCheckable = 0;
        private static final boolean defaultItemChecked = false;
        private static final boolean defaultItemEnabled = true;
        private static final int defaultItemId = 0;
        private static final int defaultItemOrder = 0;
        private static final boolean defaultItemVisible = true;
        private int groupCategory;
        private int groupCheckable;
        private boolean groupEnabled;
        private int groupId;
        private int groupOrder;
        private boolean groupVisible;
        private ActionProvider itemActionProvider;
        private String itemActionProviderClassName;
        private String itemActionViewClassName;
        private int itemActionViewLayout;
        private boolean itemAdded;
        private char itemAlphabeticShortcut;
        private int itemCategoryOrder;
        private int itemCheckable;
        private boolean itemChecked;
        private boolean itemEnabled;
        private int itemIconResId;
        private int itemId;
        private String itemListenerMethodName;
        private char itemNumericShortcut;
        private int itemShowAsAction;
        private CharSequence itemTitle;
        private CharSequence itemTitleCondensed;
        private boolean itemVisible;
        private Menu menu;

        public MenuState(Menu menu) {
            this.menu = menu;
            resetGroup();
        }

        private char getShortcut(String str) {
            if (str == null) {
                return (char) 0;
            }
            return str.charAt(0);
        }

        private <T> T newInstance(String str, Class<?>[] clsArr, Object[] objArr) {
            try {
                return (T) MenuInflater.this.mContext.getClassLoader().loadClass(str).getConstructor(clsArr).newInstance(objArr);
            } catch (Exception e) {
                Log.w(MenuInflater.LOG_TAG, "Cannot instantiate class: " + str, e);
                return null;
            }
        }

        private void setItem(MenuItem menuItem) {
            menuItem.setChecked(this.itemChecked).setVisible(this.itemVisible).setEnabled(this.itemEnabled).setCheckable(this.itemCheckable >= 1).setTitleCondensed(this.itemTitleCondensed).setIcon(this.itemIconResId).setAlphabeticShortcut(this.itemAlphabeticShortcut).setNumericShortcut(this.itemNumericShortcut);
            if (this.itemShowAsAction >= 0) {
                menuItem.setShowAsAction(this.itemShowAsAction);
            }
            if (this.itemListenerMethodName != null) {
                if (MenuInflater.this.mContext.isRestricted()) {
                    throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
                }
                menuItem.setOnMenuItemClickListener(new InflatedOnMenuItemClickListener(MenuInflater.this.getRealOwner(), this.itemListenerMethodName));
            }
            if (menuItem instanceof MenuItemImpl) {
                MenuItemImpl menuItemImpl = (MenuItemImpl) menuItem;
                if (this.itemCheckable >= 2) {
                    menuItemImpl.setExclusiveCheckable(true);
                }
            }
            boolean z = false;
            if (this.itemActionViewClassName != null) {
                menuItem.setActionView((View) newInstance(this.itemActionViewClassName, MenuInflater.ACTION_VIEW_CONSTRUCTOR_SIGNATURE, MenuInflater.this.mActionViewConstructorArguments));
                z = true;
            }
            if (this.itemActionViewLayout > 0) {
                if (z) {
                    Log.w(MenuInflater.LOG_TAG, "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
                } else {
                    menuItem.setActionView(this.itemActionViewLayout);
                }
            }
            if (this.itemActionProvider != null) {
                menuItem.setActionProvider(this.itemActionProvider);
            }
        }

        public MenuItem addItem() {
            this.itemAdded = true;
            MenuItem add = this.menu.add(this.groupId, this.itemId, this.itemCategoryOrder, this.itemTitle);
            setItem(add);
            return add;
        }

        public SubMenu addSubMenuItem() {
            this.itemAdded = true;
            SubMenu addSubMenu = this.menu.addSubMenu(this.groupId, this.itemId, this.itemCategoryOrder, this.itemTitle);
            setItem(addSubMenu.getItem());
            return addSubMenu;
        }

        public boolean hasAddedItem() {
            return this.itemAdded;
        }

        public void readGroup(AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = MenuInflater.this.mContext.obtainStyledAttributes(attributeSet, R.styleable.MenuGroup);
            this.groupId = obtainStyledAttributes.getResourceId(1, 0);
            this.groupCategory = obtainStyledAttributes.getInt(3, 0);
            this.groupOrder = obtainStyledAttributes.getInt(4, 0);
            this.groupCheckable = obtainStyledAttributes.getInt(5, 0);
            this.groupVisible = obtainStyledAttributes.getBoolean(2, true);
            this.groupEnabled = obtainStyledAttributes.getBoolean(0, true);
            obtainStyledAttributes.recycle();
        }

        public void readItem(AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = MenuInflater.this.mContext.obtainStyledAttributes(attributeSet, R.styleable.MenuItem);
            this.itemId = obtainStyledAttributes.getResourceId(2, 0);
            this.itemCategoryOrder = ((-65536) & obtainStyledAttributes.getInt(5, this.groupCategory)) | (65535 & obtainStyledAttributes.getInt(6, this.groupOrder));
            this.itemTitle = obtainStyledAttributes.getText(7);
            this.itemTitleCondensed = obtainStyledAttributes.getText(8);
            this.itemIconResId = obtainStyledAttributes.getResourceId(0, 0);
            this.itemAlphabeticShortcut = getShortcut(obtainStyledAttributes.getString(9));
            this.itemNumericShortcut = getShortcut(obtainStyledAttributes.getString(10));
            if (obtainStyledAttributes.hasValue(11)) {
                this.itemCheckable = obtainStyledAttributes.getBoolean(11, false) ? 1 : 0;
            } else {
                this.itemCheckable = this.groupCheckable;
            }
            this.itemChecked = obtainStyledAttributes.getBoolean(3, false);
            this.itemVisible = obtainStyledAttributes.getBoolean(4, this.groupVisible);
            this.itemEnabled = obtainStyledAttributes.getBoolean(1, this.groupEnabled);
            this.itemShowAsAction = obtainStyledAttributes.getInt(13, -1);
            this.itemListenerMethodName = obtainStyledAttributes.getString(12);
            this.itemActionViewLayout = obtainStyledAttributes.getResourceId(14, 0);
            this.itemActionViewClassName = obtainStyledAttributes.getString(15);
            this.itemActionProviderClassName = obtainStyledAttributes.getString(16);
            boolean z = this.itemActionProviderClassName != null;
            if (z && this.itemActionViewLayout == 0 && this.itemActionViewClassName == null) {
                this.itemActionProvider = (ActionProvider) newInstance(this.itemActionProviderClassName, MenuInflater.ACTION_PROVIDER_CONSTRUCTOR_SIGNATURE, MenuInflater.this.mActionProviderConstructorArguments);
            } else {
                if (z) {
                    Log.w(MenuInflater.LOG_TAG, "Ignoring attribute 'actionProviderClass'. Action view already specified.");
                }
                this.itemActionProvider = null;
            }
            obtainStyledAttributes.recycle();
            this.itemAdded = false;
        }

        public void resetGroup() {
            this.groupId = 0;
            this.groupCategory = 0;
            this.groupOrder = 0;
            this.groupCheckable = 0;
            this.groupVisible = true;
            this.groupEnabled = true;
        }
    }

    public MenuInflater(Context context) {
        this.mContext = context;
        this.mActionViewConstructorArguments = new Object[]{context};
        this.mActionProviderConstructorArguments = this.mActionViewConstructorArguments;
    }

    public MenuInflater(Context context, Object obj) {
        this.mContext = context;
        this.mRealOwner = obj;
        this.mActionViewConstructorArguments = new Object[]{context};
        this.mActionProviderConstructorArguments = this.mActionViewConstructorArguments;
    }

    private Object findRealOwner(Object obj) {
        return (!(obj instanceof Activity) && (obj instanceof ContextWrapper)) ? findRealOwner(((ContextWrapper) obj).getBaseContext()) : obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object getRealOwner() {
        if (this.mRealOwner == null) {
            this.mRealOwner = findRealOwner(this.mContext);
        }
        return this.mRealOwner;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0040, code lost:
        if (r10 != false) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0045, code lost:
        switch(r13) {
            case 1: goto L61;
            case 2: goto L16;
            case 3: goto L33;
            default: goto L13;
        };
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0060, code lost:
        r8 = r14;
        r12 = r10;
        r9 = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x006b, code lost:
        r13 = r6.next();
        r11 = r9;
        r10 = r12;
        r14 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x00b5, code lost:
        r9 = r11;
        r12 = r10;
        r8 = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x00c2, code lost:
        if (r11 != false) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x00c5, code lost:
        r8 = r6.getName();
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x00d2, code lost:
        if (r8.equals("group") == false) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x00d5, code lost:
        r0.readGroup(r7);
        r9 = r11;
        r12 = r10;
        r8 = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00ef, code lost:
        if (r8.equals(android.view.MenuInflater.XML_ITEM) == false) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00f2, code lost:
        r0.readItem(r7);
        r9 = r11;
        r12 = r10;
        r8 = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x010c, code lost:
        if (r8.equals(android.view.MenuInflater.XML_MENU) == false) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x010f, code lost:
        r0 = r0.addSubMenuItem();
        registerMenu(r0, r7);
        parseMenu(r6, r7, r0);
        r9 = r11;
        r12 = r10;
        r8 = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0130, code lost:
        r9 = true;
        r12 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x013a, code lost:
        r0 = r6.getName();
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0144, code lost:
        if (r11 == false) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x014e, code lost:
        if (r0.equals(r14) == false) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0151, code lost:
        r9 = false;
        r8 = null;
        r12 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0164, code lost:
        if (r0.equals("group") == false) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0167, code lost:
        r0.resetGroup();
        r9 = r11;
        r12 = r10;
        r8 = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0181, code lost:
        if (r0.equals(android.view.MenuInflater.XML_ITEM) == false) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0184, code lost:
        r9 = r11;
        r12 = r10;
        r8 = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0194, code lost:
        if (r0.hasAddedItem() != false) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x019c, code lost:
        if (r0.itemActionProvider == null) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x01a7, code lost:
        if (r0.itemActionProvider.hasSubMenu() == false) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x01aa, code lost:
        registerMenu(r0.addSubMenuItem(), r7);
        r9 = r11;
        r12 = r10;
        r8 = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x01c2, code lost:
        registerMenu(r0.addItem(), r7);
        r9 = r11;
        r12 = r10;
        r8 = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x01da, code lost:
        r9 = r11;
        r12 = r10;
        r8 = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x01ec, code lost:
        if (r0.equals(android.view.MenuInflater.XML_MENU) == false) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x01ef, code lost:
        r12 = true;
        r9 = r11;
        r8 = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0205, code lost:
        throw new java.lang.RuntimeException("Unexpected end of document");
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0206, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0037, code lost:
        r10 = false;
        r13 = r9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void parseMenu(org.xmlpull.v1.XmlPullParser r6, android.util.AttributeSet r7, android.view.Menu r8) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 519
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.view.MenuInflater.parseMenu(org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.view.Menu):void");
    }

    private void registerMenu(MenuItem menuItem, AttributeSet attributeSet) {
    }

    private void registerMenu(SubMenu subMenu, AttributeSet attributeSet) {
    }

    Context getContext() {
        return this.mContext;
    }

    public void inflate(int i, Menu menu) {
        XmlResourceParser xmlResourceParser = null;
        XmlResourceParser xmlResourceParser2 = null;
        XmlResourceParser xmlResourceParser3 = null;
        try {
            try {
                XmlResourceParser layout = this.mContext.getResources().getLayout(i);
                xmlResourceParser3 = layout;
                xmlResourceParser = layout;
                xmlResourceParser2 = layout;
                parseMenu(layout, Xml.asAttributeSet(layout), menu);
                if (layout != null) {
                    layout.close();
                }
            } catch (IOException e) {
                throw new InflateException("Error inflating menu XML", e);
            } catch (XmlPullParserException e2) {
                throw new InflateException("Error inflating menu XML", e2);
            }
        } catch (Throwable th) {
            if (xmlResourceParser != null) {
                xmlResourceParser.close();
            }
            throw th;
        }
    }
}
