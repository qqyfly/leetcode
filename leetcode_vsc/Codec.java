import java.util.LinkedList;
import java.util.Queue;

public class Codec {

    //BFS
    // Encodes a tree to a single string.
    public static String btree_serialize(TreeNode root) {
        if (root == null) return "";
        StringBuffer sb = new StringBuffer();

        //define null as n, the final string will be seperated with [,]
        //using bfs
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while(!queue.isEmpty()){
            int size = queue.size();                         
            for(int i = 0;i < size;i++){
                TreeNode node = queue.poll();
                if (node != null){
                    
                    sb.append(node.val);
                    sb.append(',');

                    queue.offer(node.left);
                    queue.offer(node.right);
                }else{
                    sb.append("null");
                    sb.append(',');
                }
            }
        }
        String ans = sb.toString();
        return ans.substring(0, ans.length() - 1);        
    }

    // Decodes your encoded data to tree.
    public static TreeNode btree_deserialize(String data) {
        data = data.replace("[", "");
        data = data.replace("]", "");
        data = data.trim();
        if (data.length() == 0) return null;

        String[] node_val = data.split(",");
        Queue<TreeNode> queue = new LinkedList<>();

        int len = node_val.length;

        int index = 1;

        int nodeVal = Integer.parseInt(node_val[0]);
        TreeNode root = new TreeNode(nodeVal);
        queue.offer(root);

        while(index < len){

            int size = queue.size();

            for(int i = 0;i < size;i ++){
                TreeNode parentNode = queue.poll();
                if (parentNode != null){                    
                    //handle left node
                    if (node_val[index].trim().equals("null")){
                        parentNode.left = null;
                    }else{
                        parentNode.left = new TreeNode(Integer.parseInt(node_val[index].trim()));
                    }
                    queue.offer(parentNode.left);

                    index++;

                    //handle right node
                    if (node_val[index].trim().equals("null")){
                        parentNode.right = null;
                    }else{
                        parentNode.right = new TreeNode(Integer.parseInt(node_val[index].trim()));
                    }
                    queue.offer(parentNode.right);

                    index++;
                }
            }            
        }
        return root;
    }

     // Decodes your encoded data to listnode. 
     // "[1,4,3,2,5,2]"
     public static ListNode listnode_deserialize(String data) {
        data = data.replace("[", "");
        data = data.replace("]", "");
        data = data.trim();
        if (data.length() == 0) return null;
        String[] nodeVals = data.split(",");
        int len = nodeVals.length;
        int nodeVal = Integer.parseInt(nodeVals[0]);
        ListNode head = new ListNode(nodeVal);
        ListNode prev = head;
        int index = 1;
        while(index < len){
            nodeVal = Integer.parseInt(nodeVals[index]);
            prev.next = new ListNode(nodeVal);
            prev = prev.next;  
            index++;          
        }
        return head;
     }
}