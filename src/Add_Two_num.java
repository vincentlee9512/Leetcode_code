class Add_Two_num {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //return list
        ListNode result = new ListNode(0);

        // pointer/iterator to each list
        ListNode l1ptr = l1;
        ListNode l2ptr = l2;
        ListNode rptr = result;

        //size of the return list
        int size = 0;

        //carry one
        int addOne = 0;

        //loop through two input lists, until one list reach to the end
        while(l1ptr != null && l2ptr != null){
            //add up same position on both number
            rptr.val = l1ptr.val + l2ptr.val + addOne;
            addOne = 0;

            //calculate carry-one
            if(rptr.val >= 10){
                rptr.val -= 10;
                addOne = 1;
            }

            size++;

            //move to next digit
            l1ptr = l1ptr.next;
            l2ptr = l2ptr.next;

            rptr.next = new ListNode(0);
            rptr = rptr.next;
        }

        //add the rest of list 1, if list 2 does not have any now
        while(l1ptr != null){
            rptr.val = l1ptr.val + addOne;
            addOne = 0;

            if(rptr.val >= 10){
                rptr.val -= 10;
                addOne = 1;
            }

            size++;
            l1ptr = l1ptr.next;

            rptr.next = new ListNode(0);
            rptr = rptr.next;
        }

        //add the rest of list 2, if list 1 does not have any now
        while(l2ptr != null){
            rptr.val = l2ptr.val + addOne;
            addOne = 0;

            if(rptr.val >= 10){
                rptr.val -= 10;
                addOne = 1;
            }

            size++;
            l2ptr = l2ptr.next;

            rptr.next = new ListNode(0);
            rptr = rptr.next;
        }

        //add the last carry-one to the most right digit
        if(addOne == 1){
            rptr.val += 1;
            addOne = 0;
        }


        //remove the last digit if it is zero.
        rptr = result;
        for(int i=0; i<size-1; i++){
            rptr = rptr.next;
        }

        if(rptr.next.val == 0) {
            rptr.next = null;
        }

        return result;
    }


    // Definition for singly-linked list.
    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        private void print_list(ListNode ls){
            ListNode pointer = ls;

            while(pointer!=null){
                System.out.print(pointer.val + "->");
                pointer = pointer.next;
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {

        System.out.println("Hello World!");

        ListNode l1 = new Add_Two_num(). new ListNode(2);
        l1.next = new Add_Two_num(). new ListNode(4);
        l1.next.next = new Add_Two_num(). new ListNode(3);

        ListNode l2 = new Add_Two_num(). new ListNode(5);
        l2.next = new Add_Two_num(). new ListNode(6);
        l2.next.next = new Add_Two_num(). new ListNode(4);

        l1.print_list(l1);
        l2.print_list(l2);

        Add_Two_num atn = new Add_Two_num();

        ListNode r = atn.addTwoNumbers(l1, l2);

        r.print_list(r);
    }


}
