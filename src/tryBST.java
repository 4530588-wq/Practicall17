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
        return minv;
    }
    boolean isBST(){
        return isBSTRec(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    boolean isBSTRec(tNode node,int min,int max){
        if(node == null) return true;
        if(node.key <= min || node.key >= max) return false;
        return isBSTRec(node.left, min, node.key) &&
                isBSTRec(node.right, node.key, max);
}
void buildBalanced(int start,int end){
        if(start > end) return;
        int mid = (start + end)/2;
        insert(mid);
        buildBalanced(start,mid-1);
        buildBalanced(mid+1,end);
    }
    void removeEvens(int max){
        for (int i = 2; i <= max; i += 2) {
            delete(i);
        }
    }
    static double average(long[] arr){
        long sum = 0;
        for (long v : arr) sum += v;
        return sum / (double) arr.length;
    }
    static double stdDev(long[] arr,double avg){
        double sum = 0;
        for (long v : arr)
            sum += Math.pow(v - avg, 2);
        return Math.sqrt(sum / arr.length);
    }
    public static void main(String[] args){
        int n = 7; // test small first, then try 20
        int max = (int)Math.pow(2, n) - 1;

        int runs = 30;

        long[] populateTimes = new long[runs];
        long[] deleteTimes = new long[runs];
    }
}
