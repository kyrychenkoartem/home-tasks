package com.artem.week8;

import com.artem.week8.dto.ComplaintRow;
import com.artem.week8.thread.ComplaintProducer;
import com.artem.week8.thread.DispatcherConsumer;
import com.artem.week8.util.ThreadUtils;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class TaskRunner {
    public static void main(String[] args) throws IOException {
        BlockingQueue<ComplaintRow> complaintRows = new LinkedBlockingDeque<>();
        ComplaintProducer producer = new ComplaintProducer(complaintRows);
        DispatcherConsumer consumer1 = new DispatcherConsumer(complaintRows);
        DispatcherConsumer consumer2 = new DispatcherConsumer(complaintRows);
        DispatcherConsumer consumer3 = new DispatcherConsumer(complaintRows);
        ThreadUtils.execute(producer, consumer1, consumer2, consumer3);
    }
}
