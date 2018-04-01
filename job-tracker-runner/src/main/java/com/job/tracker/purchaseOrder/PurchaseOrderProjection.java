package com.job.tracker.purchaseOrder;

import com.job.tracker.job.Job;
import com.job.tracker.project.Project;
import org.springframework.data.rest.core.config.Projection;

import java.util.Collection;

@Projection(name = "purchaseOrder-all", types = PurchaseOrder.class)
public interface PurchaseOrderProjection {

    public String getPurchaseOrder();

    public String getPurchaseOrderNumber();

    public Project getProject();

    public String getFolderLocation();

    public Collection<Job> getJobCollection();
}
