package com.sasuke0508.banksystem.service;

import com.sasuke0508.banksystem.entity.Branch;

import java.util.List;

public interface BranchService {
    /**
     * Add new branch
     * @param newBranch
     * @return new branch if create success
     */
    public Branch addNewBranch(Branch newBranch);

    /**
     * Edit information of branch
     * @param branchEdit
     * @return branch after edit
     */
    public Branch editBranch(Branch branchEdit);

    /**
     * Delete branch by id
     * @param branchId
     * @return true if delete branch success, else return false
     */
    public boolean deleteBranch(String branchId);

    /**
     * Get information of branch by id
     * @param branchId
     * @return information of branch
     */
    public Branch getInfoBranch(String branchId);

    /**
     * Get all branch
     * @return
     */
    public List<Branch> getAllBranch();
}
