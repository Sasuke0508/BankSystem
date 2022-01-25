package com.sasuke0508.banksystem.controller;

import com.sasuke0508.banksystem.entity.BankAccount;
import com.sasuke0508.banksystem.entity.Customer;
import com.sasuke0508.banksystem.service.BankAccountService;
import com.sasuke0508.banksystem.service.CustomerService;
import com.sasuke0508.banksystem.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private BankAccountService bankAccountService;

    @Autowired
    private CustomerService customerService;

    @GetMapping("")
    public String showDashBoard(Model model, HttpSession session){

        return "home";
    }

    @GetMapping("/bank-accounts")
    public String showListBankAccounts(Model model, HttpSession session){

        return "bank-account-list";
    }

    @PostMapping("/create-bank-account")
    public String createBankAccount(@ModelAttribute BankAccount bankAccount, RedirectAttributes redirectAttributes){

        return "redirect:/employee";
    }

    @GetMapping("/customer-list")
    public String showListCustomer(Model model){

        return "customer-list";
    }

    @PostMapping("/add-customer")
    public String createNewCustomer(@ModelAttribute Customer customer){

        return "redirect:/customer-list";
    }

    @PostMapping("/edit-customer")
    public String editCustomer(@ModelAttribute Customer customer){

        return "redirect:/customer-list";
    }

    @GetMapping("/delete-customer")
    public String createNewCustomer(@RequestParam(name = "id") Optional<String> id){
        if(id.isPresent()){
            String idDelete = id.get();
        }
        return "redirect:/customer-list";
    }

    @GetMapping("/view-customer")
    public String viewInfoCustomer(@RequestParam(name = "id") Optional<String> id){
        if(id.isPresent()){

        }
        return "customer-details";
    }

    @GetMapping("/transaction-list")
    public String showTransactions(Model model, HttpSession session){

        return "transaction-list";
    }

    @GetMapping("/deposit")
    public String showFormDeposit(){

        return "deposit";
    }

    @PostMapping("/deposit")
    public String deposit(@RequestParam(name = "accountNumber") String accountNumber,
                          @RequestParam(name = "amount") double amount,
                          @RequestParam(name = "desciption") String description,
                          @RequestParam(name = "fee") double fee){

        return "redirect:/transaction-list";
    }

    @GetMapping("/withdraw")
    public String showFormWithdraw(){

        return "withdraw";
    }

    @PostMapping("/withdraw")
    public String withdraw(@RequestParam(name = "accountNumber") String accountNumber,
                          @RequestParam(name = "amount") double amount,
                          @RequestParam(name = "desciption") String description,
                          @RequestParam(name = "fee") double fee){

        return "redirect:/transaction-list";
    }
}
