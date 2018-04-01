package com.job.tracker.purchaseOrder.tree;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.job.tracker.job.tree.TreeJobDTO;
import com.job.tracker.job.tree.TreeTaskDTO;
import com.job.tracker.purchaseOrder.PurchaseOrder;
import com.job.tracker.task.Task;
import com.system.util.collection.CollectionUtils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.apache.commons.lang3.StringUtils.isEmpty;

public class TreePurchaseOrderDTO {

    ///////////////////////////////////////////////////////////////////////
    ////////                                                     Properties                                                       //////////
    //////////////////////////////////////////////////////////////////////

    private String iconCls = "tree-grid-purchase-order";

    private Boolean expanded = false;
    private Boolean leaf = true;

    private String purchaseOrderNumber;

    private String projectNumber;

    private String branchName;

    private Integer entityId;

    @JsonFormat(pattern = "MM-dd-yyyy")
    private LocalDate date;

    private String businessClientName;

    private String fileFolderPath = "unknown";

    private String jobNumber;

    private String projectName;

    private List<TreeTaskDTO> children;

///////////////////////////////////////////////////////////////////////
    ////////                                              Default Constructor                                           //////////
    //////////////////////////////////////////////////////////////////////

    private TreePurchaseOrderDTO() {
    }

    public static TreePurchaseOrderDTO newInstance(PurchaseOrder purchaseOrder) {
        purchaseOrder.validate();

        TreePurchaseOrderDTO treePurchaseOrderDTO = new TreePurchaseOrderDTO();
        treePurchaseOrderDTO.setEntityId(purchaseOrder.getId());

        Integer purchaseOrderNumberValue = null;
        if (!isEmpty(purchaseOrder.getPurchaseOrderNumber())) {
            purchaseOrderNumberValue = Integer.valueOf(purchaseOrder.getPurchaseOrderNumber());
            treePurchaseOrderDTO.setProjectNumber(String.valueOf((purchaseOrderNumberValue >= 0) ? purchaseOrderNumberValue : null));
        } else {
            purchaseOrder.setPurchaseOrderNumber(null);
        }

//        treePurchaseOrderDTO.setRevisionNumber(CollectionUtils.empty(purchaseOrder.getTaskRevisionCollection()) ? null : purchaseOrder.getTaskRevisionCollection().size() - 1);
//
//        treePurchaseOrderDTO.setTaskTypeName(purchaseOrder.getTaskType() != null ? purchaseOrder.getTaskType().getName() : null);
//        treePurchaseOrderDTO.setAssignedTo(purchaseOrder.getAssignedTo() != null ? purchaseOrder.getAssignedTo().getName() : null);

        treePurchaseOrderDTO.setBranchName(purchaseOrder.getJob().getProject().getBranch().getName());
        treePurchaseOrderDTO.setPurchaseOrderNumber(purchaseOrder.getName());
        treePurchaseOrderDTO.setEntityId(purchaseOrder.getJob().getId());
        treePurchaseOrderDTO.setDate(purchaseOrder.getJob().getDate());
        treePurchaseOrderDTO.setBusinessClientName(purchaseOrder.getJob().getCustomer().getName());
        treePurchaseOrderDTO.setProjectName(purchaseOrder.getJob().getProject().getName());
//        treePurchaseOrderDTO.setDescription(purchaseOrder.getName());
//        treePurchaseOrderDTO.setStatus(purchaseOrder.getTaskStatus().getName());
        treePurchaseOrderDTO.setFileFolderPath(purchaseOrder.getFolderLocation());
        treePurchaseOrderDTO.setJobNumber(purchaseOrder.getJob().getJobNumber());

        return treePurchaseOrderDTO;
    }

    public String getIconCls() {
        return iconCls;
    }

    public void setIconCls(String iconCls) {
        this.iconCls = iconCls;
    }

    public Boolean getExpanded() {
        return expanded;
    }

    public void setExpanded(Boolean expanded) {
        this.expanded = expanded;
    }

    public Boolean getLeaf() {
        return leaf;
    }

    public void setLeaf(Boolean leaf) {
        this.leaf = leaf;
    }

    public String getPurchaseOrderNumber() {
        return purchaseOrderNumber;
    }

    public void setPurchaseOrderNumber(String purchaseOrderNumber) {
        this.purchaseOrderNumber = purchaseOrderNumber;
    }

    public String getProjectNumber() {
        return projectNumber;
    }

    public void setProjectNumber(String projectNumber) {
        this.projectNumber = projectNumber;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public Integer getEntityId() {
        return entityId;
    }

    public void setEntityId(Integer entityId) {
        this.entityId = entityId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getBusinessClientName() {
        return businessClientName;
    }

    public void setBusinessClientName(String businessClientName) {
        this.businessClientName = businessClientName;
    }

    public String getFileFolderPath() {
        return fileFolderPath;
    }

    public void setFileFolderPath(String fileFolderPath) {
        this.fileFolderPath = fileFolderPath;
    }

    public String getJobNumber() {
        return jobNumber;
    }

    public void setJobNumber(String jobNumber) {
        this.jobNumber = jobNumber;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public List<TreeTaskDTO> getChildren() {
        return children;
    }

    public void setChildren(List<TreeTaskDTO> children) {
        this.children = children;
    }

    public synchronized void addChild(TreeTaskDTO treeTaskDTO) {
        List<TreeTaskDTO> childrenList = getChildren();

        //We have children therefore we aren't the leaf
        setLeaf(false);

        if (childrenList == null) {
            childrenList = new ArrayList<>();
            setChildren(childrenList);
        }

        childrenList.add(treeTaskDTO);
    }

}
