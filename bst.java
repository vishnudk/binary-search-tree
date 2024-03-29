import java.util.Scanner;

class bst_node
{
    private int data;
    private bst_node right,left;
    bst_node()
    {
        right=null;
        left=null;
        data=-1;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public bst_node getLeft() {
        return left;
    }

    public bst_node getRight() {
        return right;
    }

    public void setLeft(bst_node left) {
        this.left = left;
    }

    public void setRight(bst_node right) {
        this.right = right;
    }
}
class bst_op
{
    public void print_bst(bst_node head)
    {
        // System.out.println("reached here");
        //System.out.println(head);
        if(head!=null)
        {      //System.out.println(head.getLeft().getData());
            //System.out.println("reache here also");
            System.out.println("head data : "+head.getData());
            if(head.getLeft()!=null)
                System.out.println("left data : "+head.getLeft().getData());
            if (head.getRight()!=null)
                System.out.println("right data : "+head.getRight().getData());
            if (head.getRight()!=null)
                print_bst(head.getRight());
            if (head.getLeft()!=null)
                print_bst(head.getLeft());
        }
    }
    public bst_node create_node(int data)
    {
        bst_node new_node=new bst_node();
        new_node.setData(data);
        return new_node;
    }

    public bst_node find_max(bst_node head)
    {
        bst_node h=head;
        //the maximum element will be the right most element
        return h;
    }
    public bst_node insert_node(bst_node node1,bst_node head)
    {
        int head_data,node_data;
        if(head!=null) {
            head_data = head.getData();
            node_data = node1.getData();
            if (head_data == node_data) {

            } else if (head_data < node_data) {
                if (head.getRight() != null)
                    insert_node(node1, head.getRight());
                else
                    head.setRight(node1);
            } else if (head_data > node_data) {
                if (head.getLeft() != null) {
                    insert_node(node1, head.getLeft());
                } else {
                    head.setLeft(node1);
                }
            }
        }
        else
        {
            head=node1;
        }
        return head;
    }

    public bst_node delete_node(bst_node head, int key) {
         int ch=search_node(head,key);
         bst_op op=new bst_op();
         if(ch==1){
           /* if(head.getData()==key){
                if(head.getLeft()!=null)
                {
                    if(head.getRight()!=null){
                        bst_node max=op.find_max(head);
                        max.setRight(head.getRight().getData())=head.getRight();
                        max.setLeft();=head.getLeft();
                    }
                }
            }*/
         }
         else
         {
             System.out.println("element donot exist");
         }
        return head;
    }
    public int search_node(bst_node head, int key)
    {
        int h=0;
        if(head!=null) {
            int head_data = head.getData();
            if(head_data==key)
            {
                return 1;
            }
            else if(head_data<key){
                h=search_node(head.getRight(),key);
            }
            else {
                h=search_node(head.getLeft(),key);
            }
        }
        else
        {
            h=0;
        }
        return h;
    }
}
public class bst {
    static   bst_node head=null;
    static int ch1=-1;
    public static void main(String[]args){
        bst_node h=null;
        //   head.setRight(null);
        // head.setLeft(null);
        bst_op op=new bst_op();
        Scanner sc=new Scanner(System.in);
        int no_of_times=-1,data_to_be_entered=-1;
        System.out.println("enter the number of items to be entered");
        no_of_times=sc.nextInt();
        while(no_of_times>0)
        {
            System.out.println("enter the data for the "+no_of_times+" node");
            no_of_times--;
            data_to_be_entered=sc.nextInt();
            head= op.insert_node(op.create_node(data_to_be_entered),head);
        }
        op.print_bst(head);
        System.out.println("== do u wish to search any of the above given node ==");
        int ch=-1;
        ch=sc.nextInt();
        if(ch==1)
        {
            System.out.println("enter the key to be search");
            int key=sc.nextInt();
             ch1=op.search_node(head,key);
        }
        System.out.println("========================================================");
        System.out.println(ch1);
        System.out.println(op.find_max(head).getData());
    }

}


