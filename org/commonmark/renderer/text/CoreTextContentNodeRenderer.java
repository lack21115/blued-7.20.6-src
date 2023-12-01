package org.commonmark.renderer.text;

import org.commonmark.internal.renderer.text.BulletListHolder;
import org.commonmark.internal.renderer.text.ListHolder;
import org.commonmark.internal.renderer.text.OrderedListHolder;
import org.commonmark.node.AbstractVisitor;
import org.commonmark.node.BlockQuote;
import org.commonmark.node.BulletList;
import org.commonmark.node.Code;
import org.commonmark.node.Document;
import org.commonmark.node.FencedCodeBlock;
import org.commonmark.node.HardLineBreak;
import org.commonmark.node.Heading;
import org.commonmark.node.HtmlBlock;
import org.commonmark.node.HtmlInline;
import org.commonmark.node.Image;
import org.commonmark.node.IndentedCodeBlock;
import org.commonmark.node.Link;
import org.commonmark.node.ListItem;
import org.commonmark.node.Node;
import org.commonmark.node.OrderedList;
import org.commonmark.node.Paragraph;
import org.commonmark.node.SoftLineBreak;
import org.commonmark.node.Text;
import org.commonmark.node.ThematicBreak;
import org.commonmark.renderer.NodeRenderer;

/* loaded from: source-3503164-dex2jar.jar:org/commonmark/renderer/text/CoreTextContentNodeRenderer.class */
public class CoreTextContentNodeRenderer extends AbstractVisitor implements NodeRenderer {
    protected final TextContentNodeRendererContext a;
    private final TextContentWriter b;
    private ListHolder c;

    private void a() {
        if (this.a.a()) {
            this.b.a();
        } else {
            this.b.c();
        }
    }

    private void a(String str) {
        if (this.a.a()) {
            this.b.a(str);
        } else {
            this.b.b(str);
        }
    }

    private void a(Node node, Character ch) {
        if (!this.a.a()) {
            if (node.h() != null) {
                this.b.c();
                return;
            }
            return;
        }
        if (ch != null) {
            this.b.a(ch.charValue());
        }
        if (node.h() != null) {
            this.b.a();
        }
    }

    private void a(Node node, String str, String str2) {
        boolean z = true;
        boolean z2 = node.j() != null;
        boolean z3 = (str == null || str.equals(str2)) ? false : true;
        if (str2 == null || str2.equals("")) {
            z = false;
        }
        if (z2) {
            this.b.a('\"');
            a(node);
            this.b.a('\"');
            if (z3 || z) {
                this.b.a();
                this.b.a('(');
            }
        }
        if (z3) {
            this.b.b(str);
            if (z) {
                this.b.b();
                this.b.a();
            }
        }
        if (z) {
            this.b.b(str2);
        }
        if (z2) {
            if (z3 || z) {
                this.b.a(')');
            }
        }
    }

    @Override // org.commonmark.node.AbstractVisitor
    public void a(Node node) {
        Node j = node.j();
        while (true) {
            Node node2 = j;
            if (node2 == null) {
                return;
            }
            Node h = node2.h();
            this.a.a(node2);
            j = h;
        }
    }

    @Override // org.commonmark.renderer.NodeRenderer
    public void b(Node node) {
        node.a(this);
    }

    @Override // org.commonmark.node.AbstractVisitor, org.commonmark.node.Visitor
    public void visit(BlockQuote blockQuote) {
        this.b.a((char) 171);
        a(blockQuote);
        this.b.a((char) 187);
        a(blockQuote, null);
    }

    @Override // org.commonmark.node.AbstractVisitor, org.commonmark.node.Visitor
    public void visit(BulletList bulletList) {
        if (this.c != null) {
            a();
        }
        this.c = new BulletListHolder(this.c, bulletList);
        a(bulletList);
        a(bulletList, null);
        if (this.c.b() != null) {
            this.c = this.c.b();
        } else {
            this.c = null;
        }
    }

    @Override // org.commonmark.node.AbstractVisitor, org.commonmark.node.Visitor
    public void visit(Code code) {
        this.b.a('\"');
        this.b.b(code.a());
        this.b.a('\"');
    }

    @Override // org.commonmark.node.AbstractVisitor, org.commonmark.node.Visitor
    public void visit(Document document) {
        a(document);
    }

    @Override // org.commonmark.node.AbstractVisitor, org.commonmark.node.Visitor
    public void visit(FencedCodeBlock fencedCodeBlock) {
        if (!this.a.a()) {
            this.b.b(fencedCodeBlock.g());
            return;
        }
        this.b.a(fencedCodeBlock.g());
        a(fencedCodeBlock, null);
    }

    @Override // org.commonmark.node.AbstractVisitor, org.commonmark.node.Visitor
    public void visit(HardLineBreak hardLineBreak) {
        a(hardLineBreak, null);
    }

    @Override // org.commonmark.node.AbstractVisitor, org.commonmark.node.Visitor
    public void visit(Heading heading) {
        a(heading);
        a(heading, ':');
    }

    @Override // org.commonmark.node.AbstractVisitor, org.commonmark.node.Visitor
    public void visit(HtmlBlock htmlBlock) {
        a(htmlBlock.c());
    }

    @Override // org.commonmark.node.AbstractVisitor, org.commonmark.node.Visitor
    public void visit(HtmlInline htmlInline) {
        a(htmlInline.a());
    }

    @Override // org.commonmark.node.AbstractVisitor, org.commonmark.node.Visitor
    public void visit(Image image) {
        a(image, image.c(), image.a());
    }

    @Override // org.commonmark.node.AbstractVisitor, org.commonmark.node.Visitor
    public void visit(IndentedCodeBlock indentedCodeBlock) {
        if (!this.a.a()) {
            this.b.b(indentedCodeBlock.c());
            return;
        }
        this.b.a(indentedCodeBlock.c());
        a(indentedCodeBlock, null);
    }

    @Override // org.commonmark.node.AbstractVisitor, org.commonmark.node.Visitor
    public void visit(Link link) {
        a(link, link.c(), link.a());
    }

    @Override // org.commonmark.node.AbstractVisitor, org.commonmark.node.Visitor
    public void visit(ListItem listItem) {
        ListHolder listHolder = this.c;
        if (listHolder != null && (listHolder instanceof OrderedListHolder)) {
            OrderedListHolder orderedListHolder = (OrderedListHolder) listHolder;
            String c = this.a.a() ? "" : orderedListHolder.c();
            TextContentWriter textContentWriter = this.b;
            textContentWriter.b(c + orderedListHolder.d() + orderedListHolder.a() + " ");
            a(listItem);
            a(listItem, null);
            orderedListHolder.e();
            return;
        }
        ListHolder listHolder2 = this.c;
        if (listHolder2 == null || !(listHolder2 instanceof BulletListHolder)) {
            return;
        }
        BulletListHolder bulletListHolder = (BulletListHolder) listHolder2;
        if (!this.a.a()) {
            TextContentWriter textContentWriter2 = this.b;
            textContentWriter2.b(bulletListHolder.c() + bulletListHolder.a() + " ");
        }
        a(listItem);
        a(listItem, null);
    }

    @Override // org.commonmark.node.AbstractVisitor, org.commonmark.node.Visitor
    public void visit(OrderedList orderedList) {
        if (this.c != null) {
            a();
        }
        this.c = new OrderedListHolder(this.c, orderedList);
        a(orderedList);
        a(orderedList, null);
        if (this.c.b() != null) {
            this.c = this.c.b();
        } else {
            this.c = null;
        }
    }

    @Override // org.commonmark.node.AbstractVisitor, org.commonmark.node.Visitor
    public void visit(Paragraph paragraph) {
        a(paragraph);
        if (paragraph.b() == null || (paragraph.b() instanceof Document)) {
            a(paragraph, null);
        }
    }

    @Override // org.commonmark.node.AbstractVisitor, org.commonmark.node.Visitor
    public void visit(SoftLineBreak softLineBreak) {
        a(softLineBreak, null);
    }

    @Override // org.commonmark.node.AbstractVisitor, org.commonmark.node.Visitor
    public void visit(Text text) {
        a(text.a());
    }

    @Override // org.commonmark.node.AbstractVisitor, org.commonmark.node.Visitor
    public void visit(ThematicBreak thematicBreak) {
        if (!this.a.a()) {
            this.b.b("***");
        }
        a(thematicBreak, null);
    }
}
