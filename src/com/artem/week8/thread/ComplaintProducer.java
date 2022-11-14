package com.artem.week8.thread;

import com.artem.week8.complaint.NewComplaintGenerator;
import com.artem.week8.dto.ComplaintRow;
import com.artem.week8.util.ComplaintGenerator;
import com.artem.week8.util.PathUtils;
import java.io.IOException;
import java.nio.file.Files;
import static java.nio.file.StandardOpenOption.APPEND;
import static java.nio.file.StandardOpenOption.CREATE;
import static java.nio.file.StandardOpenOption.SYNC;
import java.util.concurrent.BlockingQueue;

public class ComplaintProducer implements Runnable {

    private final BlockingQueue<ComplaintRow> blockingQueue;

    public ComplaintProducer(BlockingQueue<ComplaintRow> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        while (true) {
            addNewComplaint();
            try {
                Thread.sleep(3000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void addNewComplaint() {
        ComplaintRow complaintRow = ComplaintGenerator.generateNewComplaint();
        try {
            NewComplaintGenerator complaintGenerator = new NewComplaintGenerator();
            Files.writeString(PathUtils.COMPLAINTS_PATH, complaintGenerator.generate(complaintRow), CREATE, SYNC, APPEND);
            this.blockingQueue.put(complaintRow);
            System.out.println("New complaint has been added to the list: " + complaintRow.getId());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
