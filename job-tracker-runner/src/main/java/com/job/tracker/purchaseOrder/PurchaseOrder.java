package com.job.tracker.purchaseOrder;

import com.job.tracker.job.Job;
import com.job.tracker.project.Project;
import com.job.tracker.task.Task;
import com.system.db.entity.named.NamedEntity;
import org.hibernate.LazyInitializationException;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.Collection;

import static com.system.logging.exception.util.ExceptionUtils.throwSystemException;
import static javax.persistence.FetchType.EAGER;

@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"name", "job_id"})})
public class PurchaseOrder extends NamedEntity<Integer> {

    private String purchaseOrderNumber;

    @ManyToOne(fetch = EAGER)
    @JoinColumn(name = "job_id", referencedColumnName = "id")
    private Job job;


    /**
     * The absolute path of the folder structure created for
     * all files used by this entity within the filesystem
     */

    private String folderLocation;

    @LazyCollection(LazyCollectionOption.TRUE)
    @OneToMany(mappedBy = "purchaseOrder")
    private Collection<Task> taskCollection;

    ///////////////////////////////////////////////////////////////////////
    ////////                                              Default Constructor                                           //////////
    //////////////////////////////////////////////////////////////////////

    public PurchaseOrder() {
    }

    public static PurchaseOrder newInstance(String name) {
        PurchaseOrder purchaseOrder = new PurchaseOrder();
        purchaseOrder.setName(name);
        purchaseOrder.setPurchaseOrderNumber(name);
        return purchaseOrder;
    }

    public void validate() {
        if (getJob() == null) {
            throwSystemException("Related PO #, Number [" + getPurchaseOrderNumber() + "] is missing a Job. Please ensure the PO # has a Job selected.");
        }
        getJob().validate();
    }

    ///////////////////////////////////////////////////////////////////////
    ////////                                             Basic   Getter/Setters                                          //////////
    //////////////////////////////////////////////////////////////////////

    public String getPurchaseOrderNumber() {
        return purchaseOrderNumber;
    }

    public void setPurchaseOrderNumber(String purchaseOrderNumber) {
        this.purchaseOrderNumber = purchaseOrderNumber;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public String getFolderLocation() {
        return folderLocation;
    }

    public void setFolderLocation(String folderLocation) {
        this.folderLocation = folderLocation;
    }

    public Collection<Task> getTaskCollection() {
        return taskCollection;
    }

    public void setTaskCollection(Collection<Task> taskCollection) {
        this.taskCollection = this.taskCollection;
    }

}
