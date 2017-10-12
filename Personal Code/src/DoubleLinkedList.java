public class DoubleLinkedList<E> {

    private static class Node<E>{

        private E data;
        private Node<E> previous;
        private Node<E> next;

        public Node(E data, Node<E> previous, Node<E> next){
            this.data = data;
            this.next = next;
            this.previous = previous;
        }
    }

    private Node<E> head = null;
    private int size = 0;

    private void addFirst(E item){
        head = new Node(item,null,null);
    }

    private Node<E> getNode(int index){

        Node<E> runningNode = head;

        if (index >= size){
            throw new IndexOutOfBoundsException("Size: " + size + ", Index: " + index);
        }

        try{
            for (int x = 0; x < index; x++){
                runningNode = runningNode.next;
            }
        }
        catch (Exception e){
            throw new IndexOutOfBoundsException("Size: " + size + ", Index: " + index);
        }
        return runningNode;
    }

    //Public Methods

    /**
     * Adds data to the LinkedList chain.
     * @param item data to be added.
     */
    public void add(E item){
        if (head == null){
            addFirst(item);
            size++;
        }
        else{
            add(size,item);
        }
    }

    /**
     * Adds data to the LinkedList chain at specified position.
     * @param index position of data to be added.
     * @param item data to be added.
     * @throws IndexOutOfBoundsException if the index is out of range.
     */
    public void add(int index, E item){
        if (index == 0){
            Node<E> oldHead = head;
            head = new Node(item,null,oldHead);
            size++;
        }
        else if (index == size){
            Node<E> before = getNode(index-1);
            before.next = new Node(item,before,null);
            size++;
        }
        else{
            Node<E> before = getNode(index-1);
            Node<E> after = getNode(index);
            before.next = new Node(item,before,after);
            size++;
        }
    }

    /**
     * Sets the data value at index.
     * @param index position of new data.
     * @param item new data.
     * @return the data previously at index
     * @throws IndexOutOfBoundsException if the index is out of range.
     */
    public E set(int index, E item){
        E oldData = get(index);
        getNode(index).data = item;
        return oldData;
    }

    /**
     * Gets the data from index.
     * @param index index of data to return.
     * @return the data at index.
     */
    public E get(int index){
        return getNode(index).data;
    }

    /**
     * Removes data at position in list.
     * @param index position of data to be removed.
     * @return data previously at index.
     */
    public E remove(int index){

        E oldData = get(index);

        if (index == 0){
            getNode(index+1).previous = null;
            head = getNode(index+1);
            size--;
        }
        else{
            getNode(index).previous.next = getNode(index).next;
            size--;
        }

        return oldData;

    }

    /**
     * Size of the LinkedList.
     * @return number of objects in list.
     */
    public int size(){
        return size;
    }

    /**
     * Obtain a string representation of the list.
     * @return A string representation of the list.
     */
    @Override
    public String toString(){

        String finalString = "[";

        for (int x = 0; x < size; x++){
            if (x == size-1){
                finalString += get(x);
            }
            else {
                finalString += get(x) + ", ";
            }
        }

        finalString += "]";

        return finalString;
    }


}
