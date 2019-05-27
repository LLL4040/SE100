public class Main {
    public static void main(String []args) {
        Producer producer = new Producer(10, 10);
        Consumer consumer = new Consumer(5, 2, 10);
        Container container = new Container(20, 30);
        int curTime = 0, maxTime = 10000;
        int requestRemain = consumer.getRequestPerConsumer();
        while(curTime < maxTime) {
            producer.respond(container);
            consumer.send(curTime, requestRemain, container);
            producer.receive(container);
            container.remove();
            if(container.getHandled() + container.getMissed() >= consumer.getRequestPerConsumer() * consumer.getConsumers()) {
                System.out.printf("All of the requests are finished. Handled %d, Time out %d.\n", container.getHandled(), container.getMissed());
                break;
            }
            curTime++;
        }
    }

}
