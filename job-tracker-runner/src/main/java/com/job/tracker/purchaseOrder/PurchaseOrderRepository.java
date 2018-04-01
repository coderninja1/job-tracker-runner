package com.job.tracker.purchaseOrder;

import com.system.db.repository.base.named.NamedEntityRepository;

import java.util.List;

public interface PurchaseOrderRepository extends NamedEntityRepository<PurchaseOrder> {

    /**
     * Return all tasks for a given job id
     *
     * @param purchaseOrderId
     * @return - list of tasks filtered by job id
     */
    public List<PurchaseOrder> findByJobId(Integer jobId);
}
