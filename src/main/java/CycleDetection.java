import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Collections;

/**
 * Created by darcio on 8/29/16.
 */
public class CycleDetection {

    private static class Node{
        public Node() {}
        public Node(Node parent) {
            this.parent = parent;
        }

        private Node parent;

        public Node getParent() {
            return parent;
        }

        public void setParent(Node parent) {
            this.parent = parent;
        }
    }

    public static void main(String[] args) throws UnsupportedEncodingException {

        System.out.println(
                Base64.getEncoder().encodeToString("hello".getBytes("ascii"))
        );


    }


    private static boolean isCycle(Node node){

        if(node == null) return false;
        if(node.parent == null) return false;

        Node n1 = node;
        Node n2 = node.parent;

        while(n1!=null && n2!=null){

            if(n1==n2) return true;
            if(n2.parent==null) return false;

            n1 = n1.parent;
            n2 = n2.parent.parent;

        }

        return false;

    }

}
