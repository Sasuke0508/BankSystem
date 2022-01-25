package com.sasuke0508.banksystem.controller;

import com.sasuke0508.banksystem.entity.BankAccount;
import com.sasuke0508.banksystem.entity.Customer;
import com.sasuke0508.banksystem.entity.Transaction;
import com.sasuke0508.banksystem.entity.User;
import com.sasuke0508.banksystem.service.BankAccountService;
import com.sasuke0508.banksystem.service.CustomerService;
import com.sasuke0508.banksystem.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @Autowired
    TransactionService transactionService;

    @Autowired
    BankAccountService bankAccountService;

    @GetMapping("")
    public String loadHome(Model model, HttpSession session){
        User user = (User) session.getAttribute("userLogin");
        List<Transaction> transactionList = transactionService.getAllTransactionByCustomerId(user.getId());
        model.addAttribute("listTransaction", transactionList);
        List<BankAccount> bankAccountList = bankAccountService.getListBankAccountByCustomerId(user.getId());
        for (BankAccount bankAccount: bankAccountList) {
            if(bankAccount.getTypeOfAccount().equals("Credit card")){
                model.addAttribute("creditCard", bankAccount);
                return "dashboard";
            }
        }
        return "dashboard";
    }

    @GetMapping("/profile")
    public String getInfoUser(Model model, HttpSession session){
        User user = (User) session.getAttribute("userLogin");
        Customer customer = customerService.getInfoCustomer(user.getId());
        model.addAttribute("customer", customer);
        return "profile";
    }

    @PostMapping("/edit-info")
    public String editAccount(@ModelAttribute Customer customer){

        return "profile";
    }

    @PostMapping("/edit-email")
    public String editEmail(@ModelAttribute Customer customer){

        return "profile";
    }

    @PostMapping("/edit-phone")
    public String editPhoneNumber(@ModelAttribute Customer customer){

        return "profile";
    }

    @PostMapping("/change-password")
    public String changePassword(@ModelAttribute Customer customer, @RequestParam("confirmPassword") String confirmPassword){

        return "profile";
    }

    @GetMapping("/bank-account")
    public String getBankAccounts(HttpSession session, Model model){

        return "bank-account";
    }

    @GetMapping("/transactions")
    public String getTransactions(HttpSession session, Model model){

        return "transactions";
    }

    @GetMapping("/send-money")
    public String showSendMoneyPage(){
        return "send-money";
    }

    @PostMapping("/send-money/confirm")
    public String confirmSendMoney(@ModelAttribute Transaction transaction, Model model){

        return "send-money-confirm";
    }

    @PostMapping("/send-money/success")
    public String sendMoney(@ModelAttribute Transaction transaction, Model model){

        return "send-money-success";
    }

    @GetMapping("/contact")
    public String showContactPage(){
        return "contact";
    }
}
