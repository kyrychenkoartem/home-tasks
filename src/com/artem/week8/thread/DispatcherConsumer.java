package com.artem.week8.thread;

import com.artem.week8.complaint.ProcessedComplaintGenerator;
import com.artem.week8.dto.ComplaintRow;
import com.artem.week8.parser.LogFileParser;
import com.artem.week8.util.PathUtils;
import java.io.IOException;
import java.nio.file.Files;
import static java.nio.file.StandardOpenOption.APPEND;
import static java.nio.file.StandardOpenOption.CREATE;
import static java.nio.file.StandardOpenOption.SYNC;
import java.util.concurrent.BlockingQueue;

public class DispatcherConsumer implements Runnable {

    private final BlockingQueue<ComplaintRow> blockingQueue;

    public DispatcherConsumer(BlockingQueue<ComplaintRow> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        while (true) {
            getNewComplaints();
            callWithClient();
            try {
                Thread.sleep(12000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void getNewComplaints() {
        LogFileParser logFileParser = new LogFileParser();
        try {
            logFileParser.buildComplaintRaws(PathUtils.COMPLAINTS_PATH);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void callWithClient() {
        try {
            ComplaintRow complaintRow = this.blockingQueue.take();
            System.out.println(complaintRow.getId() + " complaint has been sent to the dispatcher: " + Thread.currentThread().getName());
            ProcessedComplaintGenerator processedComplaintGenerator = new ProcessedComplaintGenerator();
            Files.writeString(PathUtils.RESULT_PATH, processedComplaintGenerator.generate(complaintRow), CREATE, SYNC, APPEND);
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
    }
}
