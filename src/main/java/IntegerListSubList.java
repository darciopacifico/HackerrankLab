import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by darcio on 9/3/16.
 */
public class IntegerListSubList {


    public static class LinkedListNode {
        String val;
        LinkedListNode next;

        LinkedListNode(String node_value) {
            val = node_value;
            next = null;
        }
    }


    public static LinkedListNode _insert_node_into_singlylinkedlist(LinkedListNode head, String val) {
        if (head == null) {
            head = new LinkedListNode(val);
        } else {
            LinkedListNode end = head;
            while (end.next != null) {
                end = end.next;
            }
            LinkedListNode node = new LinkedListNode(val);
            end.next = node;
        }
        return head;
    }


    static int find(LinkedListNode list, LinkedListNode sublist) {

        StringBuffer listStr = new StringBuffer();
        append(listStr,list);

        StringBuffer subListStr = new StringBuffer();
        append(subListStr,sublist);

        String sList = listStr.toString();
        String sSubList = subListStr.toString();

        int f = sList.lastIndexOf(sSubList);

        String sub = sList.substring(0,f);

        int count=0;
        for (int i=0; i<sub.length(); i++){
            if(sub.charAt(i)=='|') count++;
        }

        return count;



    }

    static void append(StringBuffer sb, LinkedListNode list) {

        if (list != null) {
            sb.append(list.val+"|");

            append(sb, list.next);
        }

    }


    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        final String fileName = "/home/darcio/Desktop/test_cases_rskp9oqg/outPutTeste.txt";
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
        int res;

        int _list_size = Integer.parseInt(in.nextLine()), _list_i;
        String _list_item;
        LinkedListNode _list = null;
        for (_list_i = 0; _list_i < _list_size; _list_i++) {
            try {
                _list_item = in.nextLine();
            } catch (Exception e) {
                _list_item = null;
            }
            _list = _insert_node_into_singlylinkedlist(_list, _list_item);
        }


        int _sublist_size = Integer.parseInt(in.nextLine()), _sublist_i;
        String _sublist_item;
        LinkedListNode _sublist = null;
        for (_sublist_i = 0; _sublist_i < _sublist_size; _sublist_i++) {
            try {
                _sublist_item = in.nextLine();
            } catch (Exception e) {
                _sublist_item = null;
            }
            _sublist = _insert_node_into_singlylinkedlist(_sublist, _sublist_item);
        }

        res = find(_list, _sublist);
        bw.write(String.valueOf(res));
        bw.newLine();

        bw.close();
    }
}
