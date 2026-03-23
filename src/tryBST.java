class tNode {
    int key;
    tNode left, right;

    public tNode(int item) {
        key = item;
        left = right = null;
    }
}
public class tryBST {

    tNode root;

    // Insert into BST
    tNode insertRec(tNode root, int key) {
        if (root == null) {
            root = new tNode(key);
            return root;
        }

        if (key < root.key)
            root.left = insertRec(root.left, key);
        else if (key > root.key)
            root.right = insertRec(root.right, key);

        return root;
    }
    void insert(int key){
        root = insertRec(root, key);
    }
    tNode deleteRec(tNode root,int key){
        if(root == null) return root;
        if (key < root.key)
            root.left = deleteRec(root.left, key);
        else if (key > root.key)
            root.right = deleteRec(root.right, key);
        else{
            if(root.left == null) return root.right;
            else if(root.right == null) return root.left;
            root.key = minValue(root.right);
            root.right = deleteRec(root.right, root.key);
        }
        return root;
    }
    void delete(int key){
        root = deleteRec(root,key);
    }
    int minValue(tNode root){
        int minv = root.key;
        while (root.left != null) {
            root = root.left;
            minv = root.key;
        }
    }
}
