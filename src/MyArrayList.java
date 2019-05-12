public class MyArrayList<T> {
    class Node<T> {
        T data;
        Node<T> next;

        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }

        public void echoNext() {
            if (next != null) {
                next.echo();
                next.echoNext();
            }
        }
        public void echo() {
            System.out.println(data);
        }
    }

    private Node<T> first;
    private Node<T> last;

    public MyArrayList(T data) {
        Node<T> node = new Node<T>(data, null);
        last = first = node;
    }

    public void add(T item){
        Node<T> node = new Node<T>(item, null);
        if (first.next == null) {
            first.next = node;
        }
        else {
            last.next = node;
            last = node;
        }
    }

    public void get(int index) {
        Node<T> node = first;
        for (int i = 0; i < index; i++) {
            if (node.next != null) {
                node = node.next;
            }
            else {
                System.out.println("Aucun item pour cet index");
                return;
            }
        }
        node.echo();
    }

    public void echo() {
        first.echo();
        first.echoNext();
    }
}
