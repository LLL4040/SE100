import java.util.ArrayList;

public class Producer {
    private int producers;
    private int responseInterval;
    private ArrayList<Integer> producerList;

    public Producer(int producers, int responseInterval) {
        this.producers = producers;
        this.responseInterval = responseInterval;
        this.producerList = new ArrayList<>();
        for(int i = 0; i < producers; i++) {
            this.producerList.add(-1);
        }
    }

    public int getProducers() {
        return producers;
    }

    public int getResponseInterval() {
        return responseInterval;
    }

    public ArrayList<Integer> getProducerList() {
        return producerList;
    }

    public void respond(Container container) {
        for(int i = 0; i < producers; i++) {
            int tmp = producerList.get(i) - 1;
            if(tmp == 0) {
                producerList.set(i, -1);
                System.out.printf("Producer %d respond.\n", i);
                container.setHandled(container.getHandled()+1);
            } else if(tmp > 0) {
                producerList.set(i, tmp);
            }
        }
    }

    public void receive(Container container) {
        for(int i = 0; i < producers; i++) {
            if(container.getRequests().size() > 0 && producerList.get(i) == -1) {
                int id = container.popRequest();
                producerList.set(i, responseInterval);
                System.out.printf("Producer %d receive request %d.\n", i, id);
            }
        }
    }
}
