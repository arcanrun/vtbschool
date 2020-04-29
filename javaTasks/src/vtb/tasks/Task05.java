package vtb.tasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task05 {
    private static class Node<T> {
        private T data;
        private List<Node<T>> children;

        Node(T data) {
            this.children = new ArrayList<>();
            this.data = data;
        }

        Node(T data, Node<T>... childs) {
            this.children = new ArrayList<>();
            this.data = data;
            children.addAll(Arrays.asList(childs));
        }

        public void addChild(Node<T> child) {
            this.children.add(child);
        }

        public boolean isLeaf() {
            return children.size() == 0;
        }

        public List<Node<T>> getChildren(){
            return children;
        }
    }


    public static void main(String[] args) {
        Node<String> root = new Node<>("root");
        root.addChild(new Node<>("child1", new Node<>("grandchild1"), new Node<>("grandcild1.1"), new Node<>("grandchild1.3", new Node<>("grand-grandchild1"))));
        root.addChild(new Node<>("chidl2", new Node<>("grandchiild2"), new Node<>("granchild2.1")));

        System.out.println(countLeaf(root));
    }

    public static <T> int countLeaf(Node<T> node) {
        int counter = 0;

        for (Node<T> n: node.getChildren()) {
                if(n.isLeaf()) {
                    counter ++;
                }
                else{
                    counter += countLeaf(n);
            }
        }

        return counter;
    }
}
