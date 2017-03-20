package Control;

import Model.BinaryTree;
import View.DrawingPanel;
import View.InteractableObject;
import View.TreeView.TreeNode;
import View.TreeView.TreePath;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

/**
 * Created by Jean-Pierre on 12.01.2017.
 */
public class MainController implements InteractableObject{

    private BinaryTree<String> binaryTree;

    public MainController(){
        binaryTree = new BinaryTree<>(""); // Ein Baum ohne Wurzel-Inhalt ist auf dauer ein leerer Baum - es lassen sich laut Dokumentation nichtmal Bäume anhängen. Also wird die Wurzel gefüllt.
        createMorseTree();
    }

    /**
     * Zur Präsentation des Programms wird der Morsecode im Baum dargestellt.
     */
    private void createMorseTree(){
        //TODO 02: Vervollständige des Morsebaum. Such bei google nach "morsecode as tree" als Vorlage. Das hilft, die Übersicht zu wahren.
        BinaryTree<String> eRoot = new BinaryTree<>("E");
        BinaryTree<String> tRoot = new BinaryTree<>("T");
        binaryTree.setLeftTree(eRoot);
        binaryTree.setRightTree(tRoot);

        BinaryTree<String> iRoot = new BinaryTree<>("I");
        BinaryTree<String> aRoot = new BinaryTree<>("A");
        eRoot.setRightTree(aRoot);
        eRoot.setLeftTree(iRoot);

        BinaryTree<String> sRoot = new BinaryTree<>("S");
        BinaryTree<String> uRoot = new BinaryTree<>("U");
        iRoot.setLeftTree(sRoot);
        iRoot.setRightTree(uRoot);

        BinaryTree<String> hRoot = new BinaryTree<>("H");
        BinaryTree<String> vRoot = new BinaryTree<>("V");
        sRoot.setLeftTree(hRoot);
        sRoot.setRightTree(vRoot);

        BinaryTree<String> fRoot = new BinaryTree<>("F");
        uRoot.setLeftTree(fRoot);

        BinaryTree<String> rRoot = new BinaryTree<>("R");
        BinaryTree<String> wRoot = new BinaryTree<>("W");
        aRoot.setLeftTree(rRoot);
        aRoot.setRightTree(wRoot);

        BinaryTree<String> lRoot = new BinaryTree<>("S");
        rRoot.setLeftTree(lRoot);

        BinaryTree<String> pRoot = new BinaryTree<>("P");
        BinaryTree<String> jRoot = new BinaryTree<>("J");
        wRoot.setLeftTree(pRoot);
        wRoot.setRightTree(jRoot);

        BinaryTree<String> nRoot = new BinaryTree<>("N");
        BinaryTree<String> mRoot = new BinaryTree<>("M");
        tRoot.setLeftTree(nRoot);
        tRoot.setRightTree(mRoot);

        BinaryTree<String> dRoot = new BinaryTree<>("D");
        BinaryTree<String> kRoot = new BinaryTree<>("K");
        nRoot.setLeftTree(dRoot);
        nRoot.setRightTree(kRoot);

        BinaryTree<String> bRoot = new BinaryTree<>("B");
        BinaryTree<String> xRoot = new BinaryTree<>("X");
        dRoot.setLeftTree(bRoot);
        dRoot.setRightTree(xRoot);

        BinaryTree<String> cRoot = new BinaryTree<>("C");
        BinaryTree<String> yRoot = new BinaryTree<>("Y");
        kRoot.setLeftTree(cRoot);
        kRoot.setRightTree(yRoot);

        BinaryTree<String> gRoot = new BinaryTree<>("G");
        BinaryTree<String> oRoot = new BinaryTree<>("O");
        mRoot.setLeftTree(gRoot);
        mRoot.setRightTree(oRoot);

        BinaryTree<String> zRoot = new BinaryTree<>("Z");
        BinaryTree<String> qRoot = new BinaryTree<>("Q");
        gRoot.setLeftTree(zRoot);
        gRoot.setRightTree(qRoot);


    }


    /**
     * Der Baum wird im übergebenem Panel dargestellt.
     * Dazu wird zunächst die alte Zeichnung entfernt.
     * Im Anschluss wird eine eine internete Hilfsmethode aufgerufen.
     * @param panel Das DrawingPanel-Objekt, auf dem gezeichnet wird.
     */
    public void showTree(DrawingPanel panel){
        panel.removeAllObjects();
        showTree(binaryTree, panel, panel.getWidth()/2, 20, panel.getWidth()/4);
    }

    /**
     * Hilfsmethode zum Zeichnen des Baums.
     * Für jeden Knoten wird ein neues TreeNode-Objekt dem panel hinzugefügt.
     * Für jede Kante wird ein neues TreePath-Pbjekt dem panel hinzugefügt.
     * @param tree Der zu zeichnende (Teil)Binärbaum.
     * @param panel Das DrawingPanel-Objekt, auf dem gezeichnet wird.
     * @param startX x-Koordinate seiner Wurzel
     * @param startY y-Koordinate seiner Wurzel
     * @param spaceToTheSide Gibt an, wie weit horizontal entfernt die folgenden Bäume gezeichnet werden soll.
     */
    private void showTree(BinaryTree tree, DrawingPanel panel, double startX, double startY, double spaceToTheSide) {
        if (!tree.isEmpty()) {
            int rad = 10;
            TreeNode node = new TreeNode(startX, startY, rad, tree.getContent().toString(), false);
            panel.addObject(node);

            if(!tree.getLeftTree().isEmpty()) {
                int lX = (int) (startX - spaceToTheSide);
                int lY = (int) (startY + panel.getHeight() / 6);

                panel.addObject(new TreePath(startX,startY, lX, lY,rad,false));
                showTree(tree.getLeftTree(), panel, lX, lY, spaceToTheSide / 2);
            }

            if(!tree.getRightTree().isEmpty()) {
                int rX = (int) (startX + spaceToTheSide);
                int rY = (int) (startY + panel.getHeight() / 6);

                panel.addObject(new TreePath(startX,startY, rX, rY,rad,false));
                showTree(tree.getRightTree(),panel,rX,rY,spaceToTheSide/2);
            }

        }
    }

    /**
     * Es wird das Ergebnis einer Traversierung bestimmt.
     * Ruft dazu eine interne Hilfsmethode auf.
     * @return Das Ergebnis der Traversierung als Zeichenkette.
     */
    public String traverse(){
        return traverse(binaryTree);
    }

    /**
     * Interne hilfsmethode zur Traversierung.
     * @param tree Der zu traversierende Binärbaum.
     * @return Das Ergebnis der Traversierung als Zeichenkette.
     */
    private String traverse(BinaryTree tree){
        //TODO 04: Nachdem wir geklärt haben, was eine Traversierung ist, muss diese Methode noch vervollständigt werden. Sollte ein Kinderspiel sein.
        //Preorder ist verboten #noMansSky
        if (!tree.isEmpty()) {
            return tree.getContent().toString() + traverse(tree.getLeftTree()) + traverse(tree.getRightTree());
        }
        return "";
    }


    @Override
    public void keyPressed(int key) {

    }

    @Override
    public void keyReleased(int key) {
        if(KeyEvent.VK_SPACE == key){
            translateMorseCode();
        }
    }

    private void translateMorseCode() {
        String morse = JOptionPane.showInputDialog("Type morsecode");
        String[]codes = morse.split(" ");
        String translation = "";

        for (int i = 0; i < codes.length; i++) {
            translation += interpretCode(codes[i]);
        }

    }

    private String interpretCode(String code) {
        return code;
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void draw(DrawingPanel dp, Graphics2D g2d) {

    }

    @Override
    public void update(double dt) {

    }
}
