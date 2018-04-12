package com.job.tracker.purchaseOrder;

import com.job.tracker.Employee.Employee;
import com.job.tracker.branch.Branch;
import com.job.tracker.customer.Customer;
import com.job.tracker.job.Job;
import com.job.tracker.project.Project;
import com.job.tracker.task.Task;
import org.springframework.data.rest.core.config.Projection;

import java.time.LocalDate;
import java.util.Collection;

@Projection(name = "purchaseOrder-all", types = PurchaseOrder.class)
public interface PurchaseOrderProjection {

    public String getPurchaseOrderNumber();

    public Job getJob();

    public Customer getCustomer();

    public Project getProject();

    public String getCity();

    public String getState();

    public double getAmount();

    public Employee getAssignedTo();

    public String getSalesRep();

    public Branch getSellingBranch();

    public LocalDate getDate();

    public Employee getProjectManager();

    public String getFolderLocation();

    public Collection<Task> getTaskCollection();

}