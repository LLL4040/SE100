public class Consumer {
    private int consumers;
    private int requestInterval;
    private int requestPerConsumer;
    private int requestId;

    public Consumer(int consumers, int requestInterval, int requestPerConsumer) {
        this.consumers = consumers;
        this.requestInterval = requestInterval;
        this.requestPerConsumer = requestPerConsumer;
        this.requestId = 1;
    }

    public int getConsumers() {
        return consumers;
    }

    public int getRequestPerConsumer() {
        return requestPerConsumer;
    }

    public int send(int time, int remain, Container container) {
        if(time % requestInterval == 0 && remain > 0) {
            for(int i = 0; i < consumers; i++) {
                System.out.printf("Consumer %d sends request %d.\n", i, requestId);
                container.pushRequest(requestId);
                requestId++;
            }
            remain--;
        }
        return remain;
    }

}
