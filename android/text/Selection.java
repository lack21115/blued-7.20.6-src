package android.text;

/* loaded from: source-9557208-dex2jar.jar:android/text/Selection.class */
public class Selection {
    public static final Object SELECTION_START = new START();
    public static final Object SELECTION_END = new END();

    /* loaded from: source-9557208-dex2jar.jar:android/text/Selection$END.class */
    private static final class END implements NoCopySpan {
        private END() {
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/text/Selection$PositionIterator.class */
    public interface PositionIterator {
        public static final int DONE = -1;

        int following(int i);

        int preceding(int i);
    }

    /* loaded from: source-9557208-dex2jar.jar:android/text/Selection$START.class */
    private static final class START implements NoCopySpan {
        private START() {
        }
    }

    private Selection() {
    }

    private static int chooseHorizontal(Layout layout, int i, int i2, int i3) {
        if (layout.getLineForOffset(i2) != layout.getLineForOffset(i3)) {
            return layout.getParagraphDirection(layout.getLineForOffset(i2)) == i ? Math.max(i2, i3) : Math.min(i2, i3);
        }
        float primaryHorizontal = layout.getPrimaryHorizontal(i2);
        float primaryHorizontal2 = layout.getPrimaryHorizontal(i3);
        if (i < 0) {
            if (primaryHorizontal >= primaryHorizontal2) {
                return i3;
            }
        } else if (primaryHorizontal <= primaryHorizontal2) {
            return i3;
        }
        return i2;
    }

    public static boolean extendDown(Spannable spannable, Layout layout) {
        int selectionEnd = getSelectionEnd(spannable);
        int lineForOffset = layout.getLineForOffset(selectionEnd);
        if (lineForOffset < layout.getLineCount() - 1) {
            extendSelection(spannable, layout.getParagraphDirection(lineForOffset) == layout.getParagraphDirection(lineForOffset + 1) ? layout.getOffsetForHorizontal(lineForOffset + 1, layout.getPrimaryHorizontal(selectionEnd)) : layout.getLineStart(lineForOffset + 1));
            return true;
        } else if (selectionEnd != spannable.length()) {
            extendSelection(spannable, spannable.length());
            return true;
        } else {
            return true;
        }
    }

    public static boolean extendLeft(Spannable spannable, Layout layout) {
        int selectionEnd = getSelectionEnd(spannable);
        int offsetToLeftOf = layout.getOffsetToLeftOf(selectionEnd);
        if (offsetToLeftOf != selectionEnd) {
            extendSelection(spannable, offsetToLeftOf);
            return true;
        }
        return true;
    }

    public static boolean extendRight(Spannable spannable, Layout layout) {
        int selectionEnd = getSelectionEnd(spannable);
        int offsetToRightOf = layout.getOffsetToRightOf(selectionEnd);
        if (offsetToRightOf != selectionEnd) {
            extendSelection(spannable, offsetToRightOf);
            return true;
        }
        return true;
    }

    public static final void extendSelection(Spannable spannable, int i) {
        if (spannable.getSpanStart(SELECTION_END) != i) {
            spannable.setSpan(SELECTION_END, i, i, 34);
        }
    }

    public static boolean extendToLeftEdge(Spannable spannable, Layout layout) {
        extendSelection(spannable, findEdge(spannable, layout, -1));
        return true;
    }

    public static boolean extendToRightEdge(Spannable spannable, Layout layout) {
        extendSelection(spannable, findEdge(spannable, layout, 1));
        return true;
    }

    public static boolean extendUp(Spannable spannable, Layout layout) {
        int selectionEnd = getSelectionEnd(spannable);
        int lineForOffset = layout.getLineForOffset(selectionEnd);
        if (lineForOffset > 0) {
            extendSelection(spannable, layout.getParagraphDirection(lineForOffset) == layout.getParagraphDirection(lineForOffset - 1) ? layout.getOffsetForHorizontal(lineForOffset - 1, layout.getPrimaryHorizontal(selectionEnd)) : layout.getLineStart(lineForOffset - 1));
            return true;
        } else if (selectionEnd != 0) {
            extendSelection(spannable, 0);
            return true;
        } else {
            return true;
        }
    }

    private static int findEdge(Spannable spannable, Layout layout, int i) {
        int i2;
        int lineForOffset = layout.getLineForOffset(getSelectionEnd(spannable));
        if (i * layout.getParagraphDirection(lineForOffset) < 0) {
            i2 = layout.getLineStart(lineForOffset);
        } else {
            int lineEnd = layout.getLineEnd(lineForOffset);
            i2 = lineEnd;
            if (lineForOffset != layout.getLineCount() - 1) {
                return lineEnd - 1;
            }
        }
        return i2;
    }

    public static final int getSelectionEnd(CharSequence charSequence) {
        if (charSequence instanceof Spanned) {
            return ((Spanned) charSequence).getSpanStart(SELECTION_END);
        }
        return -1;
    }

    public static final int getSelectionStart(CharSequence charSequence) {
        if (charSequence instanceof Spanned) {
            return ((Spanned) charSequence).getSpanStart(SELECTION_START);
        }
        return -1;
    }

    public static boolean moveDown(Spannable spannable, Layout layout) {
        int selectionStart = getSelectionStart(spannable);
        int selectionEnd = getSelectionEnd(spannable);
        if (selectionStart != selectionEnd) {
            int min = Math.min(selectionStart, selectionEnd);
            int max = Math.max(selectionStart, selectionEnd);
            setSelection(spannable, max);
            return (min == 0 && max == spannable.length()) ? false : true;
        }
        int lineForOffset = layout.getLineForOffset(selectionEnd);
        if (lineForOffset < layout.getLineCount() - 1) {
            setSelection(spannable, layout.getParagraphDirection(lineForOffset) == layout.getParagraphDirection(lineForOffset + 1) ? layout.getOffsetForHorizontal(lineForOffset + 1, layout.getPrimaryHorizontal(selectionEnd)) : layout.getLineStart(lineForOffset + 1));
            return true;
        } else if (selectionEnd != spannable.length()) {
            setSelection(spannable, spannable.length());
            return true;
        } else {
            return false;
        }
    }

    public static boolean moveLeft(Spannable spannable, Layout layout) {
        int selectionStart = getSelectionStart(spannable);
        int selectionEnd = getSelectionEnd(spannable);
        if (selectionStart != selectionEnd) {
            setSelection(spannable, chooseHorizontal(layout, -1, selectionStart, selectionEnd));
            return true;
        }
        int offsetToLeftOf = layout.getOffsetToLeftOf(selectionEnd);
        if (offsetToLeftOf != selectionEnd) {
            setSelection(spannable, offsetToLeftOf);
            return true;
        }
        return false;
    }

    public static boolean moveRight(Spannable spannable, Layout layout) {
        int selectionStart = getSelectionStart(spannable);
        int selectionEnd = getSelectionEnd(spannable);
        if (selectionStart != selectionEnd) {
            setSelection(spannable, chooseHorizontal(layout, 1, selectionStart, selectionEnd));
            return true;
        }
        int offsetToRightOf = layout.getOffsetToRightOf(selectionEnd);
        if (offsetToRightOf != selectionEnd) {
            setSelection(spannable, offsetToRightOf);
            return true;
        }
        return false;
    }

    public static boolean moveToFollowing(Spannable spannable, PositionIterator positionIterator, boolean z) {
        int following = positionIterator.following(getSelectionEnd(spannable));
        if (following != -1) {
            if (z) {
                extendSelection(spannable, following);
                return true;
            }
            setSelection(spannable, following);
            return true;
        }
        return true;
    }

    public static boolean moveToLeftEdge(Spannable spannable, Layout layout) {
        setSelection(spannable, findEdge(spannable, layout, -1));
        return true;
    }

    public static boolean moveToPreceding(Spannable spannable, PositionIterator positionIterator, boolean z) {
        int preceding = positionIterator.preceding(getSelectionEnd(spannable));
        if (preceding != -1) {
            if (z) {
                extendSelection(spannable, preceding);
                return true;
            }
            setSelection(spannable, preceding);
            return true;
        }
        return true;
    }

    public static boolean moveToRightEdge(Spannable spannable, Layout layout) {
        setSelection(spannable, findEdge(spannable, layout, 1));
        return true;
    }

    public static boolean moveUp(Spannable spannable, Layout layout) {
        int selectionStart = getSelectionStart(spannable);
        int selectionEnd = getSelectionEnd(spannable);
        if (selectionStart != selectionEnd) {
            int min = Math.min(selectionStart, selectionEnd);
            int max = Math.max(selectionStart, selectionEnd);
            setSelection(spannable, min);
            return (min == 0 && max == spannable.length()) ? false : true;
        }
        int lineForOffset = layout.getLineForOffset(selectionEnd);
        if (lineForOffset > 0) {
            setSelection(spannable, layout.getParagraphDirection(lineForOffset) == layout.getParagraphDirection(lineForOffset - 1) ? layout.getOffsetForHorizontal(lineForOffset - 1, layout.getPrimaryHorizontal(selectionEnd)) : layout.getLineStart(lineForOffset - 1));
            return true;
        } else if (selectionEnd != 0) {
            setSelection(spannable, 0);
            return true;
        } else {
            return false;
        }
    }

    public static final void removeSelection(Spannable spannable) {
        spannable.removeSpan(SELECTION_START);
        spannable.removeSpan(SELECTION_END);
    }

    public static final void selectAll(Spannable spannable) {
        setSelection(spannable, 0, spannable.length());
    }

    public static final void setSelection(Spannable spannable, int i) {
        setSelection(spannable, i, i);
    }

    public static void setSelection(Spannable spannable, int i, int i2) {
        int selectionStart = getSelectionStart(spannable);
        int selectionEnd = getSelectionEnd(spannable);
        if (selectionStart == i && selectionEnd == i2) {
            return;
        }
        spannable.setSpan(SELECTION_START, i, i, 546);
        spannable.setSpan(SELECTION_END, i2, i2, 34);
    }
}
