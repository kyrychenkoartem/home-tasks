package com.artem.week8.complaint;

import com.artem.week8.dto.ComplaintRow;
import com.artem.week8.util.StringUtils;

public  class NewComplaintGenerator implements Complaintable {

    @Override
    public String generate(ComplaintRow complaintRow) {
        return complaintRow.getId() + StringUtils.SEPARATOR +
                complaintRow.getDateTimeComplaint() + StringUtils.SEPARATOR +
                complaintRow.getFullName() + StringUtils.SEPARATOR +
                complaintRow.getPhoneNumber() + StringUtils.SEPARATOR +
                complaintRow.getTextOfComplaint() + System.lineSeparator();
    }
}
