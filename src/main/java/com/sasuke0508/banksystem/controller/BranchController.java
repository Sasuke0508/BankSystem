package com.sasuke0508.banksystem.controller;

import com.sasuke0508.banksystem.entity.Branch;
import com.sasuke0508.banksystem.service.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/branch")
public class BranchController {
    @Autowired
    private BranchService branchService;

    @GetMapping
    public String showListBranch(Model model){

        return "branch-list";
    }

    @GetMapping("/{id}")
    public String showBranchDetails(@PathVariable(value = "id") String branchId){

        return "branch-details";
    }

    @PostMapping("/edit-branch")
    public String editBranch(@ModelAttribute Branch branch){

        return "redirect:/branch";
    }

    @PostMapping("/add-branch")
    public String addBranch(@ModelAttribute Branch branch){

        return "redirect:/branch";
    }

    @GetMapping("/delete")
    public String deleteBranch(@RequestParam(name = "id") Optional<String> id){
        if(id.isPresent()){
            String idDelete = id.get();
        }
        return "redirect:/branch";
    }
}
