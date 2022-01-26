package com.sasuke0508.banksystem.controller;

import com.sasuke0508.banksystem.entity.Branch;
import com.sasuke0508.banksystem.entity.User;
import com.sasuke0508.banksystem.service.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/branch")
public class BranchController {
    @Autowired
    private BranchService branchService;

    private final String pattern = "yyyy-MM-dd";
    private SimpleDateFormat formatter = new SimpleDateFormat(pattern);

    @GetMapping
    public String showListBranch(Model model){
        List<Branch> branchList = branchService.getAllBranch();
        model.addAttribute("branchList", branchList);
        return "employee/branchs-list";
    }

    @GetMapping("/{id}")
    public String showBranchDetails(@PathVariable(value = "id") String branchId){
        if(branchId == null){
            return "employee/branchs-list";
        }
        return "branch-details";
    }

    @GetMapping("/edit-branch/{id}")
    public String showEditBranch(@PathVariable(value = "id") String branchId, Model model){
        if(branchId!=null){
            Branch branch = branchService.getInfoBranch(branchId);
            model.addAttribute("branchEdit", branch);
        }
        return "employee/edit-branch";
    }

    @PostMapping("/edit-branch")
    public String editBranch(@ModelAttribute Branch branch){
        System.out.println(branch.getId() + " " + branch.getName() + " " + branch.getCreateDate() + " " + branch.getAddress());
        branchService.editBranch(branch);
        return "redirect:/branch";
    }

    @GetMapping("/add-branch")
    public String showAddBranch(@ModelAttribute Branch branch, Model model){
        model.addAttribute("branch", branch);
        return "employee/add-branch";
    }

    @PostMapping("/add-branch")
    public String addBranch(@ModelAttribute Branch branch){
        branch.setId("BR" + new Date().getTime());
        branch.setCreateDate(new Date());
        branchService.addNewBranch(branch);
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
