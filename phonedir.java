public class phonedir<E> {

// nested class Node

    public static class Node<E> {

        public E data; // data reference to other java class

        public Node<E> next; // reference to the next node

        public Node(E data) {

            this.data = data;

            next = null;

        }

    }

    private Node<E> head = null; // the reference to the first node in the list

    private Node<E> current = null;

    private int size = 0; // the number of nodes in the list

// added item becomes first item in the list now

    public void add(E item) {

        Node<E> temp = new Node<E>(item);

        Node<E> prev = null;

        Node<E> curr = this.head;

        boolean foundPos = false;

        while (!(curr == null || foundPos)) {

            if (((Comparable<Object>) curr.data).compareTo(temp.data ) > 0) {

                foundPos = true;

            } else {

                prev = curr;
                curr = curr.next;

            }

        }

        if (prev == null) {

            this.current = temp;

            temp.next = this.head;

            this.head = temp;

        } else {

            prev.next = temp;
            temp.next = curr;

            this.current = temp;

        }

        size++;

    }
    //will set the node to null to rid of it if user desires
    public Node<E> delete() {

        if (this.current != null) {

            Node<E> prev = null;

            Node<E> curr = this.head;

            while (curr != null) {

                if (((Comparable<Object>) curr.data).compareTo(this.current.data) == 0) {

                    break;
                } else {

                    prev = curr;

                    curr = curr.next;

                }

            }

            prev.next = curr.next;

            size--;

            return curr;

        }

        return null;

    }
    //checks for instance of the node 
    public Node<E> search(E item){

        if (this.head != null) {
        	Node<E> curr = this.head;

            while (curr != null) {

                if (curr.data.equals(item)) {

                    break;

                } else {

                    curr = curr.next;

                }

            }

            return curr;

        }

        return null;

    }
    //will print string node
    public void display() {

        Node<E> temp = this.head;

        while(temp!=null) {

            System.out.println(temp.data. toString());

            temp = temp.next;

        }

    }
    
    public Node<E> getHead() {

        return head;

    }
    public void setHead(Node<E> head) {

        this.head = head;

    }

    public Node<E> getCurrent() {

        return current;

    }

    public void setCurrent(Node<E> current) {

        this.current = current;

    }

    public int getSize() {

        return size;

    }

    public void setSize(int size) {

        this.size = size;

    }
        }