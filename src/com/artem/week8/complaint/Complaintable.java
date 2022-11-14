package com.artem.week8.complaint;

import com.artem.week8.dto.ComplaintRow;

public interface Complaintable {
    String generate(ComplaintRow complaintRow);
}
