package com.gunes.mvc.controller;


import com.gunes.mvc.model.Customer;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CustomerController {

    @Value("${systems}")
    private List<String> systems;

    @Value("${languages}")
    private List<String> languages;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        StringTrimmerEditor editor = new StringTrimmerEditor(true);
        binder.registerCustomEditor(String.class, editor);
    }


    @GetMapping("/showCustomerForm")
    public String showCustomerForm(Model theModel) {

        theModel.addAttribute("customer", new Customer());
        theModel.addAttribute("languages", languages);
        theModel.addAttribute("systems", systems);
        return "customer-form";
    }

    @PostMapping("/processCustomer")
    public String processCustomer(@Valid @ModelAttribute("customer") Customer theCustomer, BindingResult bindingResult, Model theModel) {
        if (bindingResult.hasErrors()) {
            theModel.addAttribute("customer", theCustomer);
            theModel.addAttribute("languages", languages);
            theModel.addAttribute("systems", systems);
            return "customer-form";
        } else {
            System.out.println("posta kodu: " + theCustomer.getPostCode());
            return "process-customer";
        }
    }
}
