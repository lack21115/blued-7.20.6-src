package android.widget;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.view.View;

/* loaded from: source-4181928-dex2jar.jar:android/widget/SimpleCursorTreeAdapter.class */
public abstract class SimpleCursorTreeAdapter extends ResourceCursorTreeAdapter {
    private int[] mChildFrom;
    private String[] mChildFromNames;
    private int[] mChildTo;
    private int[] mGroupFrom;
    private String[] mGroupFromNames;
    private int[] mGroupTo;
    private ViewBinder mViewBinder;

    /* loaded from: source-4181928-dex2jar.jar:android/widget/SimpleCursorTreeAdapter$ViewBinder.class */
    public interface ViewBinder {
        boolean setViewValue(View view, Cursor cursor, int i);
    }

    public SimpleCursorTreeAdapter(Context context, Cursor cursor, int i, int i2, String[] strArr, int[] iArr, int i3, int i4, String[] strArr2, int[] iArr2) {
        super(context, cursor, i, i2, i3, i4);
        init(strArr, iArr, strArr2, iArr2);
    }

    public SimpleCursorTreeAdapter(Context context, Cursor cursor, int i, int i2, String[] strArr, int[] iArr, int i3, String[] strArr2, int[] iArr2) {
        super(context, cursor, i, i2, i3);
        init(strArr, iArr, strArr2, iArr2);
    }

    public SimpleCursorTreeAdapter(Context context, Cursor cursor, int i, String[] strArr, int[] iArr, int i2, String[] strArr2, int[] iArr2) {
        super(context, cursor, i, i2);
        init(strArr, iArr, strArr2, iArr2);
    }

    private void bindView(View view, Context context, Cursor cursor, int[] iArr, int[] iArr2) {
        ViewBinder viewBinder = this.mViewBinder;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= iArr2.length) {
                return;
            }
            View findViewById = view.findViewById(iArr2[i2]);
            if (findViewById != null) {
                boolean z = false;
                if (viewBinder != null) {
                    z = viewBinder.setViewValue(findViewById, cursor, iArr[i2]);
                }
                if (z) {
                    continue;
                } else {
                    String string = cursor.getString(iArr[i2]);
                    String str = string;
                    if (string == null) {
                        str = "";
                    }
                    if (findViewById instanceof TextView) {
                        setViewText((TextView) findViewById, str);
                    } else if (!(findViewById instanceof ImageView)) {
                        throw new IllegalStateException("SimpleCursorTreeAdapter can bind values only to TextView and ImageView!");
                    } else {
                        setViewImage((ImageView) findViewById, str);
                    }
                }
            }
            i = i2 + 1;
        }
    }

    private void init(String[] strArr, int[] iArr, String[] strArr2, int[] iArr2) {
        this.mGroupFromNames = strArr;
        this.mGroupTo = iArr;
        this.mChildFromNames = strArr2;
        this.mChildTo = iArr2;
    }

    private void initFromColumns(Cursor cursor, String[] strArr, int[] iArr) {
        int length = strArr.length;
        while (true) {
            int i = length - 1;
            if (i < 0) {
                return;
            }
            iArr[i] = cursor.getColumnIndexOrThrow(strArr[i]);
            length = i;
        }
    }

    @Override // android.widget.CursorTreeAdapter
    protected void bindChildView(View view, Context context, Cursor cursor, boolean z) {
        if (this.mChildFrom == null) {
            this.mChildFrom = new int[this.mChildFromNames.length];
            initFromColumns(cursor, this.mChildFromNames, this.mChildFrom);
        }
        bindView(view, context, cursor, this.mChildFrom, this.mChildTo);
    }

    @Override // android.widget.CursorTreeAdapter
    protected void bindGroupView(View view, Context context, Cursor cursor, boolean z) {
        if (this.mGroupFrom == null) {
            this.mGroupFrom = new int[this.mGroupFromNames.length];
            initFromColumns(cursor, this.mGroupFromNames, this.mGroupFrom);
        }
        bindView(view, context, cursor, this.mGroupFrom, this.mGroupTo);
    }

    public ViewBinder getViewBinder() {
        return this.mViewBinder;
    }

    public void setViewBinder(ViewBinder viewBinder) {
        this.mViewBinder = viewBinder;
    }

    protected void setViewImage(ImageView imageView, String str) {
        try {
            imageView.setImageResource(Integer.parseInt(str));
        } catch (NumberFormatException e) {
            imageView.setImageURI(Uri.parse(str));
        }
    }

    public void setViewText(TextView textView, String str) {
        textView.setText(str);
    }
}
