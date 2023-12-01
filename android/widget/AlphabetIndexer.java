package android.widget;

import android.database.Cursor;
import android.database.DataSetObserver;
import android.util.SparseIntArray;
import java.text.Collator;

/* loaded from: source-4181928-dex2jar.jar:android/widget/AlphabetIndexer.class */
public class AlphabetIndexer extends DataSetObserver implements SectionIndexer {
    private SparseIntArray mAlphaMap;
    protected CharSequence mAlphabet;
    private String[] mAlphabetArray;
    private int mAlphabetLength;
    private Collator mCollator;
    protected int mColumnIndex;
    protected Cursor mDataCursor;

    public AlphabetIndexer(Cursor cursor, int i, CharSequence charSequence) {
        this.mDataCursor = cursor;
        this.mColumnIndex = i;
        this.mAlphabet = charSequence;
        this.mAlphabetLength = charSequence.length();
        this.mAlphabetArray = new String[this.mAlphabetLength];
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.mAlphabetLength) {
                break;
            }
            this.mAlphabetArray[i3] = Character.toString(this.mAlphabet.charAt(i3));
            i2 = i3 + 1;
        }
        this.mAlphaMap = new SparseIntArray(this.mAlphabetLength);
        if (cursor != null) {
            cursor.registerDataSetObserver(this);
        }
        this.mCollator = Collator.getInstance();
        this.mCollator.setStrength(0);
    }

    protected int compare(String str, String str2) {
        return this.mCollator.compare(str.length() == 0 ? " " : str.substring(0, 1), str2);
    }

    @Override // android.widget.SectionIndexer
    public int getPositionForSection(int i) {
        int i2;
        int i3;
        SparseIntArray sparseIntArray = this.mAlphaMap;
        Cursor cursor = this.mDataCursor;
        if (cursor != null && this.mAlphabet != null) {
            if (i <= 0) {
                return 0;
            }
            int i4 = i;
            if (i >= this.mAlphabetLength) {
                i4 = this.mAlphabetLength - 1;
            }
            int position = cursor.getPosition();
            int count = cursor.getCount();
            int i5 = count;
            char charAt = this.mAlphabet.charAt(i4);
            String ch = Character.toString(charAt);
            int i6 = sparseIntArray.get(charAt, Integer.MIN_VALUE);
            if (Integer.MIN_VALUE != i6) {
                i2 = i6;
                if (i6 < 0) {
                    i5 = -i6;
                }
            }
            int i7 = 0;
            if (i4 > 0) {
                int i8 = sparseIntArray.get(this.mAlphabet.charAt(i4 - 1), Integer.MIN_VALUE);
                i7 = 0;
                if (i8 != Integer.MIN_VALUE) {
                    i7 = Math.abs(i8);
                }
            }
            int i9 = i7;
            int i10 = (i5 + i7) / 2;
            while (true) {
                int i11 = i10;
                i3 = i11;
                if (i11 >= i5) {
                    break;
                }
                cursor.moveToPosition(i11);
                String string = cursor.getString(this.mColumnIndex);
                if (string != null) {
                    int compare = compare(string, ch);
                    if (compare != 0) {
                        if (compare < 0) {
                            int i12 = i11 + 1;
                            i11 = i5;
                            i9 = i12;
                            if (i12 >= count) {
                                i3 = count;
                                break;
                            }
                        }
                        i5 = i11;
                        i10 = (i9 + i11) / 2;
                    } else {
                        i3 = i11;
                        if (i9 == i11) {
                            break;
                        }
                        i5 = i11;
                        i10 = (i9 + i11) / 2;
                    }
                } else if (i11 == 0) {
                    i3 = i11;
                    break;
                } else {
                    i10 = i11 - 1;
                }
            }
            sparseIntArray.put(charAt, i3);
            cursor.moveToPosition(position);
            return i3;
        }
        i2 = 0;
        return i2;
    }

    @Override // android.widget.SectionIndexer
    public int getSectionForPosition(int i) {
        int position = this.mDataCursor.getPosition();
        this.mDataCursor.moveToPosition(i);
        String string = this.mDataCursor.getString(this.mColumnIndex);
        this.mDataCursor.moveToPosition(position);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.mAlphabetLength) {
                return 0;
            }
            if (compare(string, Character.toString(this.mAlphabet.charAt(i3))) == 0) {
                return i3;
            }
            i2 = i3 + 1;
        }
    }

    @Override // android.widget.SectionIndexer
    public Object[] getSections() {
        return this.mAlphabetArray;
    }

    @Override // android.database.DataSetObserver
    public void onChanged() {
        super.onChanged();
        this.mAlphaMap.clear();
    }

    @Override // android.database.DataSetObserver
    public void onInvalidated() {
        super.onInvalidated();
        this.mAlphaMap.clear();
    }

    public void setCursor(Cursor cursor) {
        if (this.mDataCursor != null) {
            this.mDataCursor.unregisterDataSetObserver(this);
        }
        this.mDataCursor = cursor;
        if (cursor != null) {
            this.mDataCursor.registerDataSetObserver(this);
        }
        this.mAlphaMap.clear();
    }
}
