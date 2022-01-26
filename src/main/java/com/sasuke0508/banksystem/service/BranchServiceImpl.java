package com.sasuke0508.banksystem.service;

import com.sasuke0508.banksystem.entity.Branch;
import com.sasuke0508.banksystem.repository.BranchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

@Service
public class BranchServiceImpl implements BranchService{

    @Autowired
    private BranchRepository branchRepository;

    private final String pattern = "yyyy-MM-dd";
    private SimpleDateFormat formatter = new SimpleDateFormat(pattern);
    /**
     * Add new branch
     *
     * @param newBranch
     * @return new branch if create success
     */
    @Override
    public Branch addNewBranch(Branch newBranch) {
        return branchRepository.save(newBranch);
    }

    /**
     * Edit information of branch
     *
     * @param branchEdit
     * @return branch after edit
     */
    @Override
    public Branch editBranch(Branch branchEdit) {
        return branchRepository.save(branchEdit);
    }

    /**
     * Delete branch by id
     *
     * @param branchId
     * @return true if delete branch success, else return false
     */
    @Override
    public boolean deleteBranch(String branchId) {
        Optional<Branch> optionalBranch = branchRepository.findById(branchId);
        if(optionalBranch.isPresent()){
            branchRepository.delete(optionalBranch.get());
            Optional<Branch> optionalBranch_check = branchRepository.findById(branchId);
            return !optionalBranch_check.isPresent();
        }
        return false;
    }

    /**
     * Get information of branch by id
     *
     * @param branchId
     * @return information of branch
     */
    @Override
    public Branch getInfoBranch(String branchId) {
        return branchRepository.getById(branchId);
    }

    /**
     * Get all branch
     *
     * @return
     */
    @Override
    public List<Branch> getAllBranch() {
        return branchRepository.findAll();
    }
}
