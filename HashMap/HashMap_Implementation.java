import java.util.*;

public class HashMap_Implementation<K, V> {
    static class Node<K, V> {
        K key;
        V value;

        public Node(K key, V value) {
             this.key = key;
            this.value = value;
        }
    }

    private int n; // number of elements
    private int N; // number of buckets
    private LinkedList<Node<K, V>>[] buckets;

    @SuppressWarnings("unchecked")
    public HashMapImplementation() {
        this.N = 4;
        this.buckets = new LinkedList[4];
        for (int i = 0; i < 4; i++) {
            this.buckets[i] = new LinkedList<>();
        }
    }

    private int hashFunction(K key) {
        int hc = key.hashCode();
        return Math.abs(hc) % N;
    }

    private int searchInLL(K key, int bi) {
        LinkedList<Node<K, V>> ll = buckets[bi];
        for (int i = 0; i < ll.size(); i++) {
            Node<K, V> node = ll.get(i);
            if (node.key.equals(key)) {
                return i;
            }
        }
        return -1;
    }

    @SuppressWarnings("unchecked")
    private void rehash() {
        LinkedList<Node<K, V>>[] oldBuckets = buckets;
        this.N = 2 * N;
        this.buckets = new LinkedList[N];
        for (int i = 0; i < N; i++) {
            this.buckets[i] = new LinkedList<>();
        }
        this.n = 0;

        for (LinkedList<Node<K, V>> ll : oldBuckets) {
            for (Node<K, V> node : ll) {
                put(node.key, node.value);
            }
        }
    }

    public void put(K key, V value) {
        int bi = hashFunction(key);
        int di = searchInLL(key, bi);

        if (di != -1) {
            Node<K, V> node = buckets[bi].get(di);
            node.value = value;
        } else {
            buckets[bi].add(new Node<>(key, value));
            n++;
        }

        double lambda = (double) n / N;
        if (lambda > 2.0) {
            rehash();
        }
    }

    public boolean containsKey(K key) {
        int bi = hashFunction(key);
        int di = searchInLL(key, bi);
        return di != -1;
    }

    public V remove(K key) {
        int bi = hashFunction(key);
        int di = searchInLL(key, bi);

        if (di != -1) {
            Node<K, V> node = buckets[bi].remove(di);
            n--;
            return node.value;
        } else {
            return null;
        }
    }

    public V get(K key) {
        int bi = hashFunction(key);
        int di = searchInLL(key, bi);

        if (di != -1) {
            return buckets[bi].get(di).value;
        } else {
            return null;
        }
    }

    public ArrayList<K> keySet() {
        ArrayList<K> keys = new ArrayList<>();
        for (LinkedList<Node<K, V>> ll : buckets) {
            for (Node<K, V> node : ll) {
                keys.add(node.key);
            }
        }
        return keys;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public static void main(String[] args) {
        HashMapImplementation<String, Integer> hm = new HashMapImplementation<>();
        hm.put("India", 68);
        hm.put("China", 93);
        hm.put("Nepal", 29);
        hm.put("North America", 89);

        ArrayList<String> keys = hm.keySet();
        for (String key : keys) {
            System.out.println(key + " -> " + hm.get(key));
        }
    }
}
