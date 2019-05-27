import java.util.*;

public class Container {
    private int threshold;
    private int strategy;
    private int timeout;
    private Map<Integer, Integer> requests;
    private int handled;
    private int missed;

    public Container(int threshold, int timeout) {
        this.threshold = threshold;
        this.strategy = 0;
        this.timeout = timeout;
        this.requests = new LinkedHashMap<>();
        this.handled = 0;
        this.missed = 0;
    }

    public Map<Integer, Integer> getRequests() {
        return requests;
    }

    public int getHandled() {
        return handled;
    }

    public int getMissed() {
        return missed;
    }

    public void setHandled(int handled) {
        this.handled = handled;
    }

    public void pushRequest(int id) {
        requests.put(id, 0);
        if(requests.size() < threshold) {
            if(strategy == 1) {
                System.out.println("Switch to queue mode.");
                strategy = 0;
            }
        } else if(strategy == 0) {
            System.out.println("Switch to stack mode.");
            strategy = 1;
        }
    }

    public int popRequest() {
        if(requests.isEmpty()) {
            return -1;
        }

        int id = (Integer)requests.keySet().toArray()[0];
        int time = requests.get(id);
        for(int i : requests.keySet()) {
            int tmpTime = requests.get(i);
            if(strategy == 1) {
                if(tmpTime < time) {
                    id = i;
                    time = tmpTime;
                }
            } else if(tmpTime > time) {
                id = i;
                time = tmpTime;
            }
        }
        requests.remove(id);
        return id;
    }

    public void remove() {
        if (requests.size() > 0) {
            Set<Integer> set = requests.keySet();
            Set<Integer> removeSet = new HashSet<>();
            for (Integer key : set) {
                int temp = requests.get(key) + 1;
                requests.put(key, temp);
                if (temp >= timeout) {
                    removeSet.add(key);
                    missed++;
                    System.out.printf("Request %d timed out\n", key);
                }
            }
            for (int key : removeSet) {
                requests.remove(key);
            }
        }
    }

}
