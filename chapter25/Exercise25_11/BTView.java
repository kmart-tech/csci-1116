/*
Kevin Martinsen
CSCI 1116 - Algorithms and Data Structures
01/10/2022

Exercise 25_11 - Modify to display the tree horizontally
 */
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;



public class BTView extends Pane {

    private BST<Integer> tree = new BST<>();
    private double radius = 15; // Tree node radius
    private double hGap = 70; // Gap between two levels in a tree

    BTView(BST<Integer> tree) {
        this.tree = tree;
        setStatus("Tree is empty");
    }

    public void setStatus(String msg) {
        getChildren().add(new Text(20, 20, msg));
    }

    public void displayTree() {
        this.getChildren().clear(); // Clear the pane
        if (tree.getRoot() != null) {
            // Display tree recursively
            displayTree(tree.getRoot(), hGap, getHeight() / 2, getHeight() / 4);
        }
    }

    /**
     * Display a subtree rooted at position (x, y)
     */
    private void displayTree(BST.TreeNode<Integer> node, double x, double y, double vGap) {
        if (node.left != null) {
            // Draw a line to the left node
            getChildren().add(new Line(x + hGap, y + vGap, x, y));
            // Draw the left subtree recursively
            displayTree(node.left, x + hGap, y + vGap, vGap / 2);
        }

        if (node.right != null) {
            // Draw a line to the right node
            getChildren().add(new Line(x + hGap, y - vGap, x, y));
            // Draw the right subtree recursively
            displayTree(node.right, x + hGap, y - vGap, vGap / 2);
        }

        // Display a node
        Circle circle = new Circle(x, y, radius);
        circle.setFill(Color.WHITE);
        circle.setStroke(Color.BLACK);
        getChildren().addAll(circle,
                new Text(x - 4, y + 4, node.element + ""));
    }
}
