class Node:
    def __init__(self, key, value):
        self.key = key
        self.value = value
        self.prev = None
        self.next = None


class LRUCache:

    def __init__(self, capacity):
        self.capacity = capacity
        self.cache = {}

        # Dummy nodes
        self.head = Node(0, 0)
        self.tail = Node(0, 0)

        self.head.next = self.tail
        self.tail.prev = self.head

    # Remove a node from the linked list
    def remove(self, node):
        prev_node = node.prev
        next_node = node.next

        prev_node.next = next_node
        next_node.prev = prev_node

    # Insert node at the MRU position
    def insert(self, node):
        last = self.tail.prev

        last.next = node
        node.prev = last

        node.next = self.tail
        self.tail.prev = node

    def get(self, key):
        if key not in self.cache:
            return -1

        node = self.cache[key]

        # Mark as recently used
        self.remove(node)
        self.insert(node)

        return node.value

    def put(self, key, value):
        if key in self.cache:
            # Remove old node
            self.remove(self.cache[key])

        # Create new node
        node = Node(key, value)

        # Store in HashMap
        self.cache[key] = node

        # Add as most recently used
        self.insert(node)

        # Evict LRU if necessary
        if len(self.cache) > self.capacity:
            lru = self.head.next

            self.remove(lru)
            del self.cache[lru.key]