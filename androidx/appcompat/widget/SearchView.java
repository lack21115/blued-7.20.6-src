package androidx.appcompat.widget;

import android.R;
import android.app.PendingIntent;
import android.app.SearchManager;
import android.app.SearchableInfo;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.speech.RecognizerIntent;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.view.inspector.InspectionCompanion;
import android.view.inspector.PropertyMapper;
import android.view.inspector.PropertyReader;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.view.CollapsibleActionView;
import androidx.core.view.ViewCompat;
import androidx.cursoradapter.widget.CursorAdapter;
import androidx.customview.view.AbsSavedState;
import com.bytedance.applog.tracker.Tracker;
import java.lang.reflect.Method;
import java.util.WeakHashMap;

/* loaded from: source-8756600-dex2jar.jar:androidx/appcompat/widget/SearchView.class */
public class SearchView extends LinearLayoutCompat implements CollapsibleActionView {
    static final PreQAutoCompleteTextViewReflector i;
    private OnQueryTextListener A;
    private OnCloseListener B;
    private OnSuggestionListener C;
    private View.OnClickListener D;
    private boolean E;
    private boolean F;
    private boolean G;
    private CharSequence H;
    private boolean I;
    private boolean J;
    private int K;
    private boolean L;
    private CharSequence M;
    private CharSequence N;
    private boolean O;
    private int P;
    private Bundle Q;
    private final Runnable R;
    private Runnable S;
    private final WeakHashMap<String, Drawable.ConstantState> T;
    private final View.OnClickListener U;
    private final TextView.OnEditorActionListener V;
    private final AdapterView.OnItemClickListener W;

    /* renamed from: a  reason: collision with root package name */
    final SearchAutoComplete f1814a;
    private final AdapterView.OnItemSelectedListener aa;
    private TextWatcher ab;
    final ImageView b;

    /* renamed from: c  reason: collision with root package name */
    final ImageView f1815c;
    final ImageView d;
    final ImageView e;
    View.OnFocusChangeListener f;
    CursorAdapter g;
    SearchableInfo h;
    View.OnKeyListener j;
    private final View k;
    private final View l;
    private final View m;
    private final View n;
    private UpdatableTouchDelegate o;
    private Rect p;
    private Rect q;
    private int[] r;
    private int[] s;
    private final ImageView t;
    private final Drawable u;
    private final int v;
    private final int w;
    private final Intent x;
    private final Intent y;
    private final CharSequence z;

    /* loaded from: source-8756600-dex2jar.jar:androidx/appcompat/widget/SearchView$InspectionCompanion.class */
    public final class InspectionCompanion implements android.view.inspector.InspectionCompanion<SearchView> {

        /* renamed from: a  reason: collision with root package name */
        private boolean f1826a = false;
        private int b;

        /* renamed from: c  reason: collision with root package name */
        private int f1827c;
        private int d;
        private int e;

        @Override // android.view.inspector.InspectionCompanion
        public void mapProperties(PropertyMapper propertyMapper) {
            this.b = propertyMapper.mapInt("imeOptions", R.attr.imeOptions);
            this.f1827c = propertyMapper.mapInt("maxWidth", R.attr.maxWidth);
            this.d = propertyMapper.mapBoolean("iconifiedByDefault", androidx.appcompat.R.attr.iconifiedByDefault);
            this.e = propertyMapper.mapObject("queryHint", androidx.appcompat.R.attr.queryHint);
            this.f1826a = true;
        }

        @Override // android.view.inspector.InspectionCompanion
        public void readProperties(SearchView searchView, PropertyReader propertyReader) {
            if (!this.f1826a) {
                throw new InspectionCompanion.UninitializedPropertyMapException();
            }
            propertyReader.readInt(this.b, searchView.getImeOptions());
            propertyReader.readInt(this.f1827c, searchView.getMaxWidth());
            propertyReader.readBoolean(this.d, searchView.isIconfiedByDefault());
            propertyReader.readObject(this.e, searchView.getQueryHint());
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/appcompat/widget/SearchView$OnCloseListener.class */
    public interface OnCloseListener {
        boolean onClose();
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/appcompat/widget/SearchView$OnQueryTextListener.class */
    public interface OnQueryTextListener {
        boolean onQueryTextChange(String str);

        boolean onQueryTextSubmit(String str);
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/appcompat/widget/SearchView$OnSuggestionListener.class */
    public interface OnSuggestionListener {
        boolean onSuggestionClick(int i);

        boolean onSuggestionSelect(int i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/appcompat/widget/SearchView$PreQAutoCompleteTextViewReflector.class */
    public static class PreQAutoCompleteTextViewReflector {

        /* renamed from: a  reason: collision with root package name */
        private Method f1828a;
        private Method b;

        /* renamed from: c  reason: collision with root package name */
        private Method f1829c;

        PreQAutoCompleteTextViewReflector() {
            this.f1828a = null;
            this.b = null;
            this.f1829c = null;
            a();
            try {
                Method declaredMethod = AutoCompleteTextView.class.getDeclaredMethod("doBeforeTextChanged", new Class[0]);
                this.f1828a = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException e) {
            }
            try {
                Method declaredMethod2 = AutoCompleteTextView.class.getDeclaredMethod("doAfterTextChanged", new Class[0]);
                this.b = declaredMethod2;
                declaredMethod2.setAccessible(true);
            } catch (NoSuchMethodException e2) {
            }
            try {
                Method method = AutoCompleteTextView.class.getMethod("ensureImeVisible", Boolean.TYPE);
                this.f1829c = method;
                method.setAccessible(true);
            } catch (NoSuchMethodException e3) {
            }
        }

        private static void a() {
            if (Build.VERSION.SDK_INT >= 29) {
                throw new UnsupportedClassVersionError("This function can only be used for API Level < 29.");
            }
        }

        void a(AutoCompleteTextView autoCompleteTextView) {
            a();
            Method method = this.f1828a;
            if (method != null) {
                try {
                    method.invoke(autoCompleteTextView, new Object[0]);
                } catch (Exception e) {
                }
            }
        }

        void b(AutoCompleteTextView autoCompleteTextView) {
            a();
            Method method = this.b;
            if (method != null) {
                try {
                    method.invoke(autoCompleteTextView, new Object[0]);
                } catch (Exception e) {
                }
            }
        }

        void c(AutoCompleteTextView autoCompleteTextView) {
            a();
            Method method = this.f1829c;
            if (method != null) {
                try {
                    method.invoke(autoCompleteTextView, true);
                } catch (Exception e) {
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/appcompat/widget/SearchView$SavedState.class */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: androidx.appcompat.widget.SearchView.SavedState.1
            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.ClassLoaderCreator
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };

        /* renamed from: a  reason: collision with root package name */
        boolean f1830a;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f1830a = ((Boolean) parcel.readValue(null)).booleanValue();
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "SearchView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " isIconified=" + this.f1830a + "}";
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeValue(Boolean.valueOf(this.f1830a));
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/appcompat/widget/SearchView$SearchAutoComplete.class */
    public static class SearchAutoComplete extends AppCompatAutoCompleteTextView {

        /* renamed from: a  reason: collision with root package name */
        final Runnable f1831a;
        private int b;

        /* renamed from: c  reason: collision with root package name */
        private SearchView f1832c;
        private boolean d;

        public SearchAutoComplete(Context context) {
            this(context, null);
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet) {
            this(context, attributeSet, androidx.appcompat.R.attr.autoCompleteTextViewStyle);
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
            this.f1831a = new Runnable() { // from class: androidx.appcompat.widget.SearchView.SearchAutoComplete.1
                @Override // java.lang.Runnable
                public void run() {
                    SearchAutoComplete.this.b();
                }
            };
            this.b = getThreshold();
        }

        private int getSearchViewTextMinWidthDp() {
            Configuration configuration = getResources().getConfiguration();
            int i = configuration.screenWidthDp;
            int i2 = configuration.screenHeightDp;
            if (i < 960 || i2 < 720 || configuration.orientation != 2) {
                if (i < 600) {
                    return (i < 640 || i2 < 480) ? 160 : 192;
                }
                return 192;
            }
            return 256;
        }

        boolean a() {
            return TextUtils.getTrimmedLength(getText()) == 0;
        }

        void b() {
            if (this.d) {
                ((InputMethodManager) getContext().getSystemService(Context.INPUT_METHOD_SERVICE)).showSoftInput(this, 0);
                this.d = false;
            }
        }

        void c() {
            if (Build.VERSION.SDK_INT < 29) {
                SearchView.i.c(this);
                return;
            }
            setInputMethodMode(1);
            if (enoughToFilter()) {
                showDropDown();
            }
        }

        @Override // android.widget.AutoCompleteTextView
        public boolean enoughToFilter() {
            return this.b <= 0 || super.enoughToFilter();
        }

        @Override // androidx.appcompat.widget.AppCompatAutoCompleteTextView, android.widget.TextView, android.view.View
        public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
            InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
            if (this.d) {
                removeCallbacks(this.f1831a);
                post(this.f1831a);
            }
            return onCreateInputConnection;
        }

        @Override // android.view.View
        protected void onFinishInflate() {
            super.onFinishInflate();
            setMinWidth((int) TypedValue.applyDimension(1, getSearchViewTextMinWidthDp(), getResources().getDisplayMetrics()));
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        protected void onFocusChanged(boolean z, int i, Rect rect) {
            super.onFocusChanged(z, i, rect);
            this.f1832c.f();
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public boolean onKeyPreIme(int i, KeyEvent keyEvent) {
            if (i == 4) {
                if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                    KeyEvent.DispatcherState keyDispatcherState = getKeyDispatcherState();
                    if (keyDispatcherState != null) {
                        keyDispatcherState.startTracking(keyEvent, this);
                        return true;
                    }
                    return true;
                } else if (keyEvent.getAction() == 1) {
                    KeyEvent.DispatcherState keyDispatcherState2 = getKeyDispatcherState();
                    if (keyDispatcherState2 != null) {
                        keyDispatcherState2.handleUpEvent(keyEvent);
                    }
                    if (keyEvent.isTracking() && !keyEvent.isCanceled()) {
                        this.f1832c.clearFocus();
                        setImeVisibility(false);
                        return true;
                    }
                }
            }
            return super.onKeyPreIme(i, keyEvent);
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public void onWindowFocusChanged(boolean z) {
            super.onWindowFocusChanged(z);
            if (z && this.f1832c.hasFocus() && getVisibility() == 0) {
                this.d = true;
                if (SearchView.a(getContext())) {
                    c();
                }
            }
        }

        @Override // android.widget.AutoCompleteTextView
        public void performCompletion() {
        }

        @Override // android.widget.AutoCompleteTextView
        protected void replaceText(CharSequence charSequence) {
        }

        void setImeVisibility(boolean z) {
            InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
            if (!z) {
                this.d = false;
                removeCallbacks(this.f1831a);
                inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
            } else if (!inputMethodManager.isActive(this)) {
                this.d = true;
            } else {
                this.d = false;
                removeCallbacks(this.f1831a);
                inputMethodManager.showSoftInput(this, 0);
            }
        }

        void setSearchView(SearchView searchView) {
            this.f1832c = searchView;
        }

        @Override // android.widget.AutoCompleteTextView
        public void setThreshold(int i) {
            super.setThreshold(i);
            this.b = i;
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/appcompat/widget/SearchView$UpdatableTouchDelegate.class */
    static class UpdatableTouchDelegate extends TouchDelegate {

        /* renamed from: a  reason: collision with root package name */
        private final View f1834a;
        private final Rect b;

        /* renamed from: c  reason: collision with root package name */
        private final Rect f1835c;
        private final Rect d;
        private final int e;
        private boolean f;

        public UpdatableTouchDelegate(Rect rect, Rect rect2, View view) {
            super(rect, view);
            this.e = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
            this.b = new Rect();
            this.d = new Rect();
            this.f1835c = new Rect();
            setBounds(rect, rect2);
            this.f1834a = view;
        }

        @Override // android.view.TouchDelegate
        public boolean onTouchEvent(MotionEvent motionEvent) {
            boolean z;
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            int action = motionEvent.getAction();
            boolean z2 = true;
            if (action != 0) {
                if (action == 1 || action == 2) {
                    boolean z3 = this.f;
                    z2 = z3;
                    if (z3) {
                        z2 = z3;
                        if (!this.d.contains(x, y)) {
                            z2 = z3;
                            z = false;
                        }
                    }
                } else {
                    if (action == 3) {
                        z2 = this.f;
                        this.f = false;
                    }
                    z = true;
                    z2 = false;
                }
                z = true;
            } else {
                if (this.b.contains(x, y)) {
                    this.f = true;
                    z = true;
                }
                z = true;
                z2 = false;
            }
            boolean z4 = false;
            if (z2) {
                if (!z || this.f1835c.contains(x, y)) {
                    motionEvent.setLocation(x - this.f1835c.left, y - this.f1835c.top);
                } else {
                    motionEvent.setLocation(this.f1834a.getWidth() / 2, this.f1834a.getHeight() / 2);
                }
                z4 = this.f1834a.dispatchTouchEvent(motionEvent);
            }
            return z4;
        }

        public void setBounds(Rect rect, Rect rect2) {
            this.b.set(rect);
            this.d.set(rect);
            Rect rect3 = this.d;
            int i = this.e;
            rect3.inset(-i, -i);
            this.f1835c.set(rect2);
        }
    }

    static {
        i = Build.VERSION.SDK_INT < 29 ? new PreQAutoCompleteTextViewReflector() : null;
    }

    public SearchView(Context context) {
        this(context, null);
    }

    public SearchView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, androidx.appcompat.R.attr.searchViewStyle);
    }

    public SearchView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.p = new Rect();
        this.q = new Rect();
        this.r = new int[2];
        this.s = new int[2];
        this.R = new Runnable() { // from class: androidx.appcompat.widget.SearchView.1
            @Override // java.lang.Runnable
            public void run() {
                SearchView.this.a();
            }
        };
        this.S = new Runnable() { // from class: androidx.appcompat.widget.SearchView.2
            @Override // java.lang.Runnable
            public void run() {
                if (SearchView.this.g instanceof SuggestionsAdapter) {
                    SearchView.this.g.changeCursor(null);
                }
            }
        };
        this.T = new WeakHashMap<>();
        this.U = new View.OnClickListener() { // from class: androidx.appcompat.widget.SearchView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                if (view == SearchView.this.b) {
                    SearchView.this.d();
                } else if (view == SearchView.this.d) {
                    SearchView.this.c();
                } else if (view == SearchView.this.f1815c) {
                    SearchView.this.b();
                } else if (view == SearchView.this.e) {
                    SearchView.this.e();
                } else if (view == SearchView.this.f1814a) {
                    SearchView.this.h();
                }
            }
        };
        this.j = new View.OnKeyListener() { // from class: androidx.appcompat.widget.SearchView.6
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i3, KeyEvent keyEvent) {
                if (SearchView.this.h == null) {
                    return false;
                }
                if (!SearchView.this.f1814a.isPopupShowing() || SearchView.this.f1814a.getListSelection() == -1) {
                    if (!SearchView.this.f1814a.a() && keyEvent.hasNoModifiers() && keyEvent.getAction() == 1 && i3 == 66) {
                        view.cancelLongPress();
                        SearchView searchView = SearchView.this;
                        searchView.a(0, (String) null, searchView.f1814a.getText().toString());
                        return true;
                    }
                    return false;
                }
                return SearchView.this.a(view, i3, keyEvent);
            }
        };
        this.V = new TextView.OnEditorActionListener() { // from class: androidx.appcompat.widget.SearchView.7
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i3, KeyEvent keyEvent) {
                SearchView.this.b();
                return true;
            }
        };
        this.W = new AdapterView.OnItemClickListener() { // from class: androidx.appcompat.widget.SearchView.8
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j) {
                Tracker.onItemClick(adapterView, view, i3, j);
                SearchView.this.a(i3, 0, (String) null);
            }
        };
        this.aa = new AdapterView.OnItemSelectedListener() { // from class: androidx.appcompat.widget.SearchView.9
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> adapterView, View view, int i3, long j) {
                Tracker.onItemSelected(adapterView, view, i3, j);
                SearchView.this.a(i3);
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        };
        this.ab = new TextWatcher() { // from class: androidx.appcompat.widget.SearchView.10
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i3, int i4, int i5) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i3, int i4, int i5) {
                SearchView.this.b(charSequence);
            }
        };
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, attributeSet, androidx.appcompat.R.styleable.SearchView, i2, 0);
        ViewCompat.saveAttributeDataForStyleable(this, context, androidx.appcompat.R.styleable.SearchView, attributeSet, obtainStyledAttributes.getWrappedTypeArray(), i2, 0);
        LayoutInflater.from(context).inflate(obtainStyledAttributes.getResourceId(androidx.appcompat.R.styleable.SearchView_layout, androidx.appcompat.R.layout.abc_search_view), (ViewGroup) this, true);
        SearchAutoComplete searchAutoComplete = (SearchAutoComplete) findViewById(androidx.appcompat.R.id.search_src_text);
        this.f1814a = searchAutoComplete;
        searchAutoComplete.setSearchView(this);
        this.k = findViewById(androidx.appcompat.R.id.search_edit_frame);
        this.l = findViewById(androidx.appcompat.R.id.search_plate);
        this.m = findViewById(androidx.appcompat.R.id.submit_area);
        this.b = (ImageView) findViewById(androidx.appcompat.R.id.search_button);
        this.f1815c = (ImageView) findViewById(androidx.appcompat.R.id.search_go_btn);
        this.d = (ImageView) findViewById(androidx.appcompat.R.id.search_close_btn);
        this.e = (ImageView) findViewById(androidx.appcompat.R.id.search_voice_btn);
        this.t = (ImageView) findViewById(androidx.appcompat.R.id.search_mag_icon);
        ViewCompat.setBackground(this.l, obtainStyledAttributes.getDrawable(androidx.appcompat.R.styleable.SearchView_queryBackground));
        ViewCompat.setBackground(this.m, obtainStyledAttributes.getDrawable(androidx.appcompat.R.styleable.SearchView_submitBackground));
        this.b.setImageDrawable(obtainStyledAttributes.getDrawable(androidx.appcompat.R.styleable.SearchView_searchIcon));
        this.f1815c.setImageDrawable(obtainStyledAttributes.getDrawable(androidx.appcompat.R.styleable.SearchView_goIcon));
        this.d.setImageDrawable(obtainStyledAttributes.getDrawable(androidx.appcompat.R.styleable.SearchView_closeIcon));
        this.e.setImageDrawable(obtainStyledAttributes.getDrawable(androidx.appcompat.R.styleable.SearchView_voiceIcon));
        this.t.setImageDrawable(obtainStyledAttributes.getDrawable(androidx.appcompat.R.styleable.SearchView_searchIcon));
        this.u = obtainStyledAttributes.getDrawable(androidx.appcompat.R.styleable.SearchView_searchHintIcon);
        TooltipCompat.setTooltipText(this.b, getResources().getString(androidx.appcompat.R.string.abc_searchview_description_search));
        this.v = obtainStyledAttributes.getResourceId(androidx.appcompat.R.styleable.SearchView_suggestionRowLayout, androidx.appcompat.R.layout.abc_search_dropdown_item_icons_2line);
        this.w = obtainStyledAttributes.getResourceId(androidx.appcompat.R.styleable.SearchView_commitIcon, 0);
        this.b.setOnClickListener(this.U);
        this.d.setOnClickListener(this.U);
        this.f1815c.setOnClickListener(this.U);
        this.e.setOnClickListener(this.U);
        this.f1814a.setOnClickListener(this.U);
        this.f1814a.addTextChangedListener(this.ab);
        this.f1814a.setOnEditorActionListener(this.V);
        this.f1814a.setOnItemClickListener(this.W);
        this.f1814a.setOnItemSelectedListener(this.aa);
        this.f1814a.setOnKeyListener(this.j);
        this.f1814a.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: androidx.appcompat.widget.SearchView.3
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                Tracker.onFocusChange(view, z);
                if (SearchView.this.f != null) {
                    SearchView.this.f.onFocusChange(SearchView.this, z);
                }
            }
        });
        setIconifiedByDefault(obtainStyledAttributes.getBoolean(androidx.appcompat.R.styleable.SearchView_iconifiedByDefault, true));
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(androidx.appcompat.R.styleable.SearchView_android_maxWidth, -1);
        if (dimensionPixelSize != -1) {
            setMaxWidth(dimensionPixelSize);
        }
        this.z = obtainStyledAttributes.getText(androidx.appcompat.R.styleable.SearchView_defaultQueryHint);
        this.H = obtainStyledAttributes.getText(androidx.appcompat.R.styleable.SearchView_queryHint);
        int i3 = obtainStyledAttributes.getInt(androidx.appcompat.R.styleable.SearchView_android_imeOptions, -1);
        if (i3 != -1) {
            setImeOptions(i3);
        }
        int i4 = obtainStyledAttributes.getInt(androidx.appcompat.R.styleable.SearchView_android_inputType, -1);
        if (i4 != -1) {
            setInputType(i4);
        }
        setFocusable(obtainStyledAttributes.getBoolean(androidx.appcompat.R.styleable.SearchView_android_focusable, true));
        obtainStyledAttributes.recycle();
        Intent intent = new Intent(RecognizerIntent.ACTION_WEB_SEARCH);
        this.x = intent;
        intent.addFlags(268435456);
        this.x.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_WEB_SEARCH);
        Intent intent2 = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        this.y = intent2;
        intent2.addFlags(268435456);
        View findViewById = findViewById(this.f1814a.getDropDownAnchor());
        this.n = findViewById;
        if (findViewById != null) {
            findViewById.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: androidx.appcompat.widget.SearchView.4
                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(View view, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12) {
                    SearchView.this.g();
                }
            });
        }
        a(this.E);
        n();
    }

    private Intent a(Intent intent, SearchableInfo searchableInfo) {
        Intent intent2 = new Intent(intent);
        ComponentName searchActivity = searchableInfo.getSearchActivity();
        intent2.putExtra(RecognizerIntent.EXTRA_CALLING_PACKAGE, searchActivity == null ? null : searchActivity.flattenToShortString());
        return intent2;
    }

    private Intent a(Cursor cursor, int i2, String str) {
        int i3;
        String columnString;
        try {
            String columnString2 = SuggestionsAdapter.getColumnString(cursor, SearchManager.SUGGEST_COLUMN_INTENT_ACTION);
            String str2 = columnString2;
            if (columnString2 == null) {
                str2 = this.h.getSuggestIntentAction();
            }
            String str3 = str2;
            if (str2 == null) {
                str3 = Intent.ACTION_SEARCH;
            }
            String columnString3 = SuggestionsAdapter.getColumnString(cursor, SearchManager.SUGGEST_COLUMN_INTENT_DATA);
            String str4 = columnString3;
            if (columnString3 == null) {
                str4 = this.h.getSuggestIntentData();
            }
            String str5 = str4;
            if (str4 != null) {
                str5 = str4;
                if (SuggestionsAdapter.getColumnString(cursor, SearchManager.SUGGEST_COLUMN_INTENT_DATA_ID) != null) {
                    str5 = str4 + "/" + Uri.encode(columnString);
                }
            }
            return a(str3, str5 == null ? null : Uri.parse(str5), SuggestionsAdapter.getColumnString(cursor, SearchManager.SUGGEST_COLUMN_INTENT_EXTRA_DATA), SuggestionsAdapter.getColumnString(cursor, SearchManager.SUGGEST_COLUMN_QUERY), i2, str);
        } catch (RuntimeException e) {
            try {
                i3 = cursor.getPosition();
            } catch (RuntimeException e2) {
                i3 = -1;
            }
            Log.w("SearchView", "Search suggestions cursor at row " + i3 + " returned exception.", e);
            return null;
        }
    }

    private Intent a(String str, Uri uri, String str2, String str3, int i2, String str4) {
        Intent intent = new Intent(str);
        intent.addFlags(268435456);
        if (uri != null) {
            intent.setData(uri);
        }
        intent.putExtra(SearchManager.USER_QUERY, this.N);
        if (str3 != null) {
            intent.putExtra("query", str3);
        }
        if (str2 != null) {
            intent.putExtra(SearchManager.EXTRA_DATA_KEY, str2);
        }
        Bundle bundle = this.Q;
        if (bundle != null) {
            intent.putExtra(SearchManager.APP_DATA, bundle);
        }
        if (i2 != 0) {
            intent.putExtra(SearchManager.ACTION_KEY, i2);
            intent.putExtra(SearchManager.ACTION_MSG, str4);
        }
        intent.setComponent(this.h.getSearchActivity());
        return intent;
    }

    private void a(Intent intent) {
        if (intent == null) {
            return;
        }
        try {
            getContext().startActivity(intent);
        } catch (RuntimeException e) {
            Log.e("SearchView", "Failed launch activity: " + intent, e);
        }
    }

    private void a(View view, Rect rect) {
        view.getLocationInWindow(this.r);
        getLocationInWindow(this.s);
        int[] iArr = this.r;
        int i2 = iArr[1];
        int[] iArr2 = this.s;
        int i3 = i2 - iArr2[1];
        int i4 = iArr[0] - iArr2[0];
        rect.set(i4, i3, view.getWidth() + i4, view.getHeight() + i3);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0057, code lost:
        if (r4.E != false) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(boolean r5) {
        /*
            r4 = this;
            r0 = r4
            r1 = r5
            r0.F = r1
            r0 = 0
            r7 = r0
            r0 = r5
            if (r0 == 0) goto L10
            r0 = 0
            r6 = r0
            goto L13
        L10:
            r0 = 8
            r6 = r0
        L13:
            r0 = r4
            androidx.appcompat.widget.SearchView$SearchAutoComplete r0 = r0.f1814a
            android.text.Editable r0 = r0.getText()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            r1 = 1
            r0 = r0 ^ r1
            r8 = r0
            r0 = r4
            android.widget.ImageView r0 = r0.b
            r1 = r6
            r0.setVisibility(r1)
            r0 = r4
            r1 = r8
            r0.b(r1)
            r0 = r4
            android.view.View r0 = r0.k
            r9 = r0
            r0 = r5
            if (r0 == 0) goto L3f
            r0 = 8
            r6 = r0
            goto L41
        L3f:
            r0 = 0
            r6 = r0
        L41:
            r0 = r9
            r1 = r6
            r0.setVisibility(r1)
            r0 = r4
            android.widget.ImageView r0 = r0.t
            android.graphics.drawable.Drawable r0 = r0.getDrawable()
            if (r0 == 0) goto L5a
            r0 = r7
            r6 = r0
            r0 = r4
            boolean r0 = r0.E
            if (r0 == 0) goto L5d
        L5a:
            r0 = 8
            r6 = r0
        L5d:
            r0 = r4
            android.widget.ImageView r0 = r0.t
            r1 = r6
            r0.setVisibility(r1)
            r0 = r4
            r0.l()
            r0 = r4
            r1 = r8
            r2 = 1
            r1 = r1 ^ r2
            r0.c(r1)
            r0 = r4
            r0.k()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.SearchView.a(boolean):void");
    }

    static boolean a(Context context) {
        return context.getResources().getConfiguration().orientation == 2;
    }

    private Intent b(Intent intent, SearchableInfo searchableInfo) {
        ComponentName searchActivity = searchableInfo.getSearchActivity();
        Intent intent2 = new Intent(Intent.ACTION_SEARCH);
        intent2.setComponent(searchActivity);
        PendingIntent activity = PendingIntent.getActivity(getContext(), 0, intent2, 1107296256);
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.Q;
        if (bundle2 != null) {
            bundle.putParcelable(SearchManager.APP_DATA, bundle2);
        }
        Intent intent3 = new Intent(intent);
        int i2 = 1;
        Resources resources = getResources();
        String string = searchableInfo.getVoiceLanguageModeId() != 0 ? resources.getString(searchableInfo.getVoiceLanguageModeId()) : RecognizerIntent.LANGUAGE_MODEL_FREE_FORM;
        String string2 = searchableInfo.getVoicePromptTextId() != 0 ? resources.getString(searchableInfo.getVoicePromptTextId()) : null;
        String string3 = searchableInfo.getVoiceLanguageId() != 0 ? resources.getString(searchableInfo.getVoiceLanguageId()) : null;
        if (searchableInfo.getVoiceMaxResults() != 0) {
            i2 = searchableInfo.getVoiceMaxResults();
        }
        intent3.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, string);
        intent3.putExtra(RecognizerIntent.EXTRA_PROMPT, string2);
        intent3.putExtra(RecognizerIntent.EXTRA_LANGUAGE, string3);
        intent3.putExtra(RecognizerIntent.EXTRA_MAX_RESULTS, i2);
        intent3.putExtra(RecognizerIntent.EXTRA_CALLING_PACKAGE, searchActivity == null ? null : searchActivity.flattenToShortString());
        intent3.putExtra(RecognizerIntent.EXTRA_RESULTS_PENDINGINTENT, activity);
        intent3.putExtra(RecognizerIntent.EXTRA_RESULTS_PENDINGINTENT_BUNDLE, bundle);
        return intent3;
    }

    private void b(int i2) {
        Editable text = this.f1814a.getText();
        Cursor cursor = this.g.getCursor();
        if (cursor == null) {
            return;
        }
        if (!cursor.moveToPosition(i2)) {
            setQuery(text);
            return;
        }
        CharSequence convertToString = this.g.convertToString(cursor);
        if (convertToString != null) {
            setQuery(convertToString);
        } else {
            setQuery(text);
        }
    }

    private void b(boolean z) {
        this.f1815c.setVisibility((this.G && j() && hasFocus() && (z || !this.L)) ? 0 : 8);
    }

    private boolean b(int i2, int i3, String str) {
        Cursor cursor = this.g.getCursor();
        if (cursor == null || !cursor.moveToPosition(i2)) {
            return false;
        }
        a(a(cursor, i3, str));
        return true;
    }

    private CharSequence c(CharSequence charSequence) {
        if (this.E && this.u != null) {
            int textSize = (int) (this.f1814a.getTextSize() * 1.25d);
            this.u.setBounds(0, 0, textSize, textSize);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("   ");
            spannableStringBuilder.setSpan(new ImageSpan(this.u), 1, 2, 33);
            spannableStringBuilder.append(charSequence);
            return spannableStringBuilder;
        }
        return charSequence;
    }

    private void c(boolean z) {
        int i2 = 8;
        if (this.L) {
            i2 = 8;
            if (!isIconified()) {
                i2 = 8;
                if (z) {
                    this.f1815c.setVisibility(8);
                    i2 = 0;
                }
            }
        }
        this.e.setVisibility(i2);
    }

    private int getPreferredHeight() {
        return getContext().getResources().getDimensionPixelSize(androidx.appcompat.R.dimen.abc_search_view_preferred_height);
    }

    private int getPreferredWidth() {
        return getContext().getResources().getDimensionPixelSize(androidx.appcompat.R.dimen.abc_search_view_preferred_width);
    }

    private boolean i() {
        SearchableInfo searchableInfo = this.h;
        boolean z = false;
        if (searchableInfo != null) {
            z = false;
            if (searchableInfo.getVoiceSearchEnabled()) {
                Intent intent = null;
                if (this.h.getVoiceSearchLaunchWebSearch()) {
                    intent = this.x;
                } else if (this.h.getVoiceSearchLaunchRecognizer()) {
                    intent = this.y;
                }
                z = false;
                if (intent != null) {
                    z = false;
                    if (getContext().getPackageManager().resolveActivity(intent, 65536) != null) {
                        z = true;
                    }
                }
            }
        }
        return z;
    }

    private boolean j() {
        return (this.G || this.L) && !isIconified();
    }

    private void k() {
        this.m.setVisibility((j() && (this.f1815c.getVisibility() == 0 || this.e.getVisibility() == 0)) ? 0 : 8);
    }

    private void l() {
        boolean z = !TextUtils.isEmpty(this.f1814a.getText());
        boolean z2 = true;
        if (!z) {
            z2 = this.E && !this.O;
        }
        this.d.setVisibility(z2 ? 0 : 8);
        Drawable drawable = this.d.getDrawable();
        if (drawable != null) {
            drawable.setState(z ? ENABLED_STATE_SET : EMPTY_STATE_SET);
        }
    }

    private void m() {
        post(this.R);
    }

    private void n() {
        CharSequence queryHint = getQueryHint();
        SearchAutoComplete searchAutoComplete = this.f1814a;
        CharSequence charSequence = queryHint;
        if (queryHint == null) {
            charSequence = "";
        }
        searchAutoComplete.setHint(c(charSequence));
    }

    private void o() {
        this.f1814a.setThreshold(this.h.getSuggestThreshold());
        this.f1814a.setImeOptions(this.h.getImeOptions());
        int inputType = this.h.getInputType();
        int i2 = inputType;
        if ((inputType & 15) == 1) {
            int i3 = inputType & (-65537);
            i2 = i3;
            if (this.h.getSuggestAuthority() != null) {
                i2 = i3 | 65536 | 524288;
            }
        }
        this.f1814a.setInputType(i2);
        CursorAdapter cursorAdapter = this.g;
        if (cursorAdapter != null) {
            cursorAdapter.changeCursor(null);
        }
        if (this.h.getSuggestAuthority() != null) {
            SuggestionsAdapter suggestionsAdapter = new SuggestionsAdapter(getContext(), this, this.h, this.T);
            this.g = suggestionsAdapter;
            this.f1814a.setAdapter(suggestionsAdapter);
            SuggestionsAdapter suggestionsAdapter2 = (SuggestionsAdapter) this.g;
            int i4 = 1;
            if (this.I) {
                i4 = 2;
            }
            suggestionsAdapter2.setQueryRefinement(i4);
        }
    }

    private void p() {
        this.f1814a.dismissDropDown();
    }

    private void setQuery(CharSequence charSequence) {
        this.f1814a.setText(charSequence);
        this.f1814a.setSelection(TextUtils.isEmpty(charSequence) ? 0 : charSequence.length());
    }

    void a() {
        int[] iArr = this.f1814a.hasFocus() ? FOCUSED_STATE_SET : EMPTY_STATE_SET;
        Drawable background = this.l.getBackground();
        if (background != null) {
            background.setState(iArr);
        }
        Drawable background2 = this.m.getBackground();
        if (background2 != null) {
            background2.setState(iArr);
        }
        invalidate();
    }

    void a(int i2, String str, String str2) {
        getContext().startActivity(a(Intent.ACTION_SEARCH, null, null, str2, i2, str));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(CharSequence charSequence) {
        setQuery(charSequence);
    }

    boolean a(int i2) {
        OnSuggestionListener onSuggestionListener = this.C;
        if (onSuggestionListener == null || !onSuggestionListener.onSuggestionSelect(i2)) {
            b(i2);
            return true;
        }
        return false;
    }

    boolean a(int i2, int i3, String str) {
        OnSuggestionListener onSuggestionListener = this.C;
        if (onSuggestionListener == null || !onSuggestionListener.onSuggestionClick(i2)) {
            b(i2, 0, null);
            this.f1814a.setImeVisibility(false);
            p();
            return true;
        }
        return false;
    }

    boolean a(View view, int i2, KeyEvent keyEvent) {
        if (this.h != null && this.g != null && keyEvent.getAction() == 0 && keyEvent.hasNoModifiers()) {
            if (i2 == 66 || i2 == 84 || i2 == 61) {
                return a(this.f1814a.getListSelection(), 0, (String) null);
            }
            if (i2 != 21 && i2 != 22) {
                return (i2 == 19 && this.f1814a.getListSelection() == 0) ? false : false;
            }
            this.f1814a.setSelection(i2 == 21 ? 0 : this.f1814a.length());
            this.f1814a.setListSelection(0);
            this.f1814a.clearListSelection();
            this.f1814a.c();
            return true;
        }
        return false;
    }

    void b() {
        Editable text = this.f1814a.getText();
        if (text == null || TextUtils.getTrimmedLength(text) <= 0) {
            return;
        }
        OnQueryTextListener onQueryTextListener = this.A;
        if (onQueryTextListener == null || !onQueryTextListener.onQueryTextSubmit(text.toString())) {
            if (this.h != null) {
                a(0, (String) null, text.toString());
            }
            this.f1814a.setImeVisibility(false);
            p();
        }
    }

    void b(CharSequence charSequence) {
        Editable text = this.f1814a.getText();
        this.N = text;
        boolean z = !TextUtils.isEmpty(text);
        b(z);
        c(!z);
        l();
        k();
        if (this.A != null && !TextUtils.equals(charSequence, this.M)) {
            this.A.onQueryTextChange(charSequence.toString());
        }
        this.M = charSequence.toString();
    }

    void c() {
        if (!TextUtils.isEmpty(this.f1814a.getText())) {
            this.f1814a.setText("");
            this.f1814a.requestFocus();
            this.f1814a.setImeVisibility(true);
        } else if (this.E) {
            OnCloseListener onCloseListener = this.B;
            if (onCloseListener == null || !onCloseListener.onClose()) {
                clearFocus();
                a(true);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void clearFocus() {
        this.J = true;
        super.clearFocus();
        this.f1814a.clearFocus();
        this.f1814a.setImeVisibility(false);
        this.J = false;
    }

    void d() {
        a(false);
        this.f1814a.requestFocus();
        this.f1814a.setImeVisibility(true);
        View.OnClickListener onClickListener = this.D;
        if (onClickListener != null) {
            onClickListener.onClick(this);
        }
    }

    void e() {
        SearchableInfo searchableInfo = this.h;
        if (searchableInfo == null) {
            return;
        }
        try {
            if (searchableInfo.getVoiceSearchLaunchWebSearch()) {
                getContext().startActivity(a(this.x, searchableInfo));
            } else if (searchableInfo.getVoiceSearchLaunchRecognizer()) {
                getContext().startActivity(b(this.y, searchableInfo));
            }
        } catch (ActivityNotFoundException e) {
            Log.w("SearchView", "Could not find voice search activity");
        }
    }

    void f() {
        a(isIconified());
        m();
        if (this.f1814a.hasFocus()) {
            h();
        }
    }

    void g() {
        if (this.n.getWidth() > 1) {
            Resources resources = getContext().getResources();
            int paddingLeft = this.l.getPaddingLeft();
            Rect rect = new Rect();
            boolean isLayoutRtl = ViewUtils.isLayoutRtl(this);
            int dimensionPixelSize = this.E ? resources.getDimensionPixelSize(androidx.appcompat.R.dimen.abc_dropdownitem_icon_width) + resources.getDimensionPixelSize(androidx.appcompat.R.dimen.abc_dropdownitem_text_padding_left) : 0;
            this.f1814a.getDropDownBackground().getPadding(rect);
            this.f1814a.setDropDownHorizontalOffset(isLayoutRtl ? -rect.left : paddingLeft - (rect.left + dimensionPixelSize));
            this.f1814a.setDropDownWidth((((this.n.getWidth() + rect.left) + rect.right) + dimensionPixelSize) - paddingLeft);
        }
    }

    public int getImeOptions() {
        return this.f1814a.getImeOptions();
    }

    public int getInputType() {
        return this.f1814a.getInputType();
    }

    public int getMaxWidth() {
        return this.K;
    }

    public CharSequence getQuery() {
        return this.f1814a.getText();
    }

    public CharSequence getQueryHint() {
        CharSequence charSequence = this.H;
        if (charSequence != null) {
            return charSequence;
        }
        SearchableInfo searchableInfo = this.h;
        return (searchableInfo == null || searchableInfo.getHintId() == 0) ? this.z : getContext().getText(this.h.getHintId());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getSuggestionCommitIconResId() {
        return this.w;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getSuggestionRowLayout() {
        return this.v;
    }

    public CursorAdapter getSuggestionsAdapter() {
        return this.g;
    }

    void h() {
        if (Build.VERSION.SDK_INT >= 29) {
            this.f1814a.refreshAutoCompleteResults();
            return;
        }
        i.a(this.f1814a);
        i.b(this.f1814a);
    }

    public boolean isIconfiedByDefault() {
        return this.E;
    }

    public boolean isIconified() {
        return this.F;
    }

    public boolean isQueryRefinementEnabled() {
        return this.I;
    }

    public boolean isSubmitButtonEnabled() {
        return this.G;
    }

    @Override // androidx.appcompat.view.CollapsibleActionView
    public void onActionViewCollapsed() {
        setQuery("", false);
        clearFocus();
        a(true);
        this.f1814a.setImeOptions(this.P);
        this.O = false;
    }

    @Override // androidx.appcompat.view.CollapsibleActionView
    public void onActionViewExpanded() {
        if (this.O) {
            return;
        }
        this.O = true;
        int imeOptions = this.f1814a.getImeOptions();
        this.P = imeOptions;
        this.f1814a.setImeOptions(imeOptions | 33554432);
        this.f1814a.setText("");
        setIconified(false);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        removeCallbacks(this.R);
        post(this.S);
        super.onDetachedFromWindow();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        if (z) {
            a(this.f1814a, this.p);
            this.q.set(this.p.left, 0, this.p.right, i5 - i3);
            UpdatableTouchDelegate updatableTouchDelegate = this.o;
            if (updatableTouchDelegate != null) {
                updatableTouchDelegate.setBounds(this.q, this.p);
                return;
            }
            UpdatableTouchDelegate updatableTouchDelegate2 = new UpdatableTouchDelegate(this.q, this.p, this.f1814a);
            this.o = updatableTouchDelegate2;
            setTouchDelegate(updatableTouchDelegate2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.View
    public void onMeasure(int i2, int i3) {
        int min;
        if (isIconified()) {
            super.onMeasure(i2, i3);
            return;
        }
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        if (mode == Integer.MIN_VALUE) {
            int i4 = this.K;
            min = i4 > 0 ? Math.min(i4, size) : Math.min(getPreferredWidth(), size);
        } else if (mode == 0) {
            min = this.K;
            if (min <= 0) {
                min = getPreferredWidth();
            }
        } else if (mode != 1073741824) {
            min = size;
        } else {
            int i5 = this.K;
            min = size;
            if (i5 > 0) {
                min = Math.min(i5, size);
            }
        }
        int mode2 = View.MeasureSpec.getMode(i3);
        int size2 = View.MeasureSpec.getSize(i3);
        if (mode2 == Integer.MIN_VALUE) {
            size2 = Math.min(getPreferredHeight(), size2);
        } else if (mode2 == 0) {
            size2 = getPreferredHeight();
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(min, 1073741824), View.MeasureSpec.makeMeasureSpec(size2, 1073741824));
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        a(savedState.f1830a);
        requestLayout();
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f1830a = isIconified();
        return savedState;
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        m();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean requestFocus(int i2, Rect rect) {
        if (!this.J && isFocusable()) {
            if (isIconified()) {
                return super.requestFocus(i2, rect);
            }
            boolean requestFocus = this.f1814a.requestFocus(i2, rect);
            if (requestFocus) {
                a(false);
            }
            return requestFocus;
        }
        return false;
    }

    public void setAppSearchData(Bundle bundle) {
        this.Q = bundle;
    }

    public void setIconified(boolean z) {
        if (z) {
            c();
        } else {
            d();
        }
    }

    public void setIconifiedByDefault(boolean z) {
        if (this.E == z) {
            return;
        }
        this.E = z;
        a(z);
        n();
    }

    public void setImeOptions(int i2) {
        this.f1814a.setImeOptions(i2);
    }

    public void setInputType(int i2) {
        this.f1814a.setInputType(i2);
    }

    public void setMaxWidth(int i2) {
        this.K = i2;
        requestLayout();
    }

    public void setOnCloseListener(OnCloseListener onCloseListener) {
        this.B = onCloseListener;
    }

    public void setOnQueryTextFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        this.f = onFocusChangeListener;
    }

    public void setOnQueryTextListener(OnQueryTextListener onQueryTextListener) {
        this.A = onQueryTextListener;
    }

    public void setOnSearchClickListener(View.OnClickListener onClickListener) {
        this.D = onClickListener;
    }

    public void setOnSuggestionListener(OnSuggestionListener onSuggestionListener) {
        this.C = onSuggestionListener;
    }

    public void setQuery(CharSequence charSequence, boolean z) {
        this.f1814a.setText(charSequence);
        if (charSequence != null) {
            SearchAutoComplete searchAutoComplete = this.f1814a;
            searchAutoComplete.setSelection(searchAutoComplete.length());
            this.N = charSequence;
        }
        if (!z || TextUtils.isEmpty(charSequence)) {
            return;
        }
        b();
    }

    public void setQueryHint(CharSequence charSequence) {
        this.H = charSequence;
        n();
    }

    public void setQueryRefinementEnabled(boolean z) {
        this.I = z;
        CursorAdapter cursorAdapter = this.g;
        if (cursorAdapter instanceof SuggestionsAdapter) {
            ((SuggestionsAdapter) cursorAdapter).setQueryRefinement(z ? 2 : 1);
        }
    }

    public void setSearchableInfo(SearchableInfo searchableInfo) {
        this.h = searchableInfo;
        if (searchableInfo != null) {
            o();
            n();
        }
        boolean i2 = i();
        this.L = i2;
        if (i2) {
            this.f1814a.setPrivateImeOptions("nm");
        }
        a(isIconified());
    }

    public void setSubmitButtonEnabled(boolean z) {
        this.G = z;
        a(isIconified());
    }

    public void setSuggestionsAdapter(CursorAdapter cursorAdapter) {
        this.g = cursorAdapter;
        this.f1814a.setAdapter(cursorAdapter);
    }
}
