package managers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import models.Task;

public class InMemoryHistoryManager {
    
        private Map<Integer, Node> taskMap;
        private Node head;
        private Node tail;

        public InMemoryHistoryManager() {
            this.taskMap = new HashMap<>();
            this.head = null;
            this.tail = null;
        }

        public void add(Task task) {
            if (taskMap.containsKey(task.getId())) {

                                            // Удаляю узел с задачей из списка
                Node existingNode = taskMap.get(task.getId());
                removeNode(existingNode);
            }

                                            // Создаю новый узел для задачи
            Node newNode = new Node(task);

            if (head == null) {
                head = newNode;
            } else {
                tail.next = newNode;
                newNode.prev = tail;
            }

            tail = newNode;
            taskMap.put(task.getId(), newNode);
        }

        public List<Task> getHistory() {
            List<Task> history = new ArrayList<>();
            Node current = head;
            while (current != null) {
                history.add(current.task);
                current = current.next;
            }
            return history;
        }

        private void removeNode(Node node) {
            if (node.prev != null) {
                node.prev.next = node.next;
            } else {
                head = node.next;
            }

            if (node.next != null) {
                node.next.prev = node.prev;
            } else {
                tail = node.prev;
            }

            taskMap.remove(node.task.getId());
        }
    }
