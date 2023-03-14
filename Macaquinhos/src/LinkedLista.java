import java.util.NoSuchElementException;

public class LinkedLista {
    private Node head;
    private Node tail; // nova referência ao final da lista
    private int size;
    
    private class Node {
        private Coco data;
        private Node next;
        private Node previous; // nova referência ao nó anterior
        
        public Node(Coco data) {
            this.data = data;
            this.next = null;
            this.previous = null; // inicializado com null
        }
    }
    
    public LinkedLista() {
        this.head = null;
        this.tail = null; // inicializado com null
        this.size = 0;
    }
    
    public void add(Coco data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode; // atualiza a referência ao final da lista
        } else {
            newNode.previous = tail; // atualiza a referência ao nó anterior
            tail.next = newNode;
            tail = newNode; // atualiza a referência ao final da lista
        }
        size++;
    }
    
    public void remove(Coco data) {
        if (head == null) {
            return;
        }
        if (head.data == data) {
            head = head.next;
            head.previous = null; // atualiza a referência ao nó anterior
            size--;
            return;
        }
        Node currentNode = head;
        while (currentNode.next != null) {
            if (currentNode.next.data == data) {
                currentNode.next = currentNode.next.next;
                if (currentNode.next != null) {
                    currentNode.next.previous = currentNode; // atualiza a referência ao nó anterior
                } else {
                    tail = currentNode; // atualiza a referência ao final da lista
                }
                size--;
                return;
            }
            currentNode = currentNode.next;
        }
    }

    public Coco removeFirst() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        Coco data = head.data;
        head = head.next;
        if (head != null) {
            head.previous = null; // atualiza a referência ao nó anterior
        } else {
            tail = null; // atualiza a referência ao final da lista
        }
        size--;
        return data;
    }

    public void addAll(LinkedLista list) {
        if (list == null || list.head == null) {
            return;
        }
        if (head == null) {
            head = list.head;
            tail = list.tail;
        } else {
            tail.next = list.head;
            tail = list.tail;
        }
        size += list.getSize();
    }
    
    
    
    
    public Coco get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node currentNode;
        if (index < size / 2) {
            currentNode = head;
            for (int i = 0; i < index; i++) {
                currentNode = currentNode.next;
            }
        } else {
            currentNode = tail;
            for (int i = size - 1; i > index; i--) {
                currentNode = currentNode.previous;
            }
        }
        return currentNode.data;
    }
    
    
    public int getSize() {
        return size;
    }
}
