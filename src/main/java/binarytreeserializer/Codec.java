package binarytreeserializer;


public class Codec {

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);

        t1.left = t2;
        t1.right = t3;

        t3.left = t4; 
        t3.right = t5;

        Codec codec = new Codec();

        String val = codec.serialize(t1);


        TreeNode deserialized = codec.deserialize(val);

        System.out.println(val);

        System.out.println(deserialized);
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
    	
    	StringBuilder sb = new StringBuilder();
    	
        serialize(sb, root);
        
        return sb.toString();
    }

    private void serialize(StringBuilder sb, TreeNode root) {
		
    	if(root==null) {
    		sb.append("null");
    		return;
    	}

    	
    	sb.append("(");
    	
    	sb.append(root.val);
    	
    	sb.append("L=");
    	serialize(sb, root.left);
    	
    	sb.append("R=");
    	serialize(sb, root.right);
    
    	sb.append(")");

	}

	// Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        return null;
    }
}