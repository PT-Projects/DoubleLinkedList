public class Driver {
    public static void main(String[] args) {
        DoubleLinkedList dll = new DoubleLinkedList();

        for (int x = 0; x < 10; x++){
            dll.add(x+1);
        }

        for (int x = 0; x < dll.size(); x++){
            System.out.println(dll.get(x));
        }

        dll.add(0,10);

        System.out.println("CHANGE");

        for (int x = 0; x < dll.size(); x++){
            System.out.println(dll.get(x));
        }

        dll.set(0,-10);

        System.out.println("CHANGE");

        for (int x = 0; x < dll.size(); x++){
            System.out.println(dll.get(x));
        }

        dll.remove(dll.size()-1);

        System.out.println("CHANGE");

        for (int x = 0; x < dll.size(); x++){
            System.out.println(dll.get(x));
        }

    }
}
