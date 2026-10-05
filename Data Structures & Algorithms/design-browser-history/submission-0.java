class BrowserHistory {
    private class Node {
        String url;
        Node prev;
        Node next;

        Node(String url) {
            this.url = url;
        }
    }

    private Node current;

    public BrowserHistory(String homepage) {
        current = new Node(homepage);
    }

    public void visit(String url) {
        Node node = new Node(url);

        current.next = node;
        node.prev = current;

        current = node;
    }

    public String back(int steps) {
        while (steps > 0 && current.prev != null) {
            current = current.prev;
            steps--;
        }

        return current.url;
    }

    public String forward(int steps) {
        while (steps > 0 && current.next != null) {
            current = current.next;
            steps--;
        }

        return current.url;
    }
}