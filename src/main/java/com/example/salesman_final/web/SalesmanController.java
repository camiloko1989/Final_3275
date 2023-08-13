package com.example.salesman_final.web;

import com.example.salesman_final.entities.Salesman;
import com.example.salesman_final.repository.SalesmanRepository;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.awt.datatransfer.DataFlavor;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@AllArgsConstructor
public class SalesmanController {

    @Autowired
    private SalesmanRepository salesmanRepository;


    @GetMapping(path="/")
    public String salesSummary(Model model){
        List<Salesman> salesmen;
        salesmen = salesmanRepository.findAll();
        model.addAttribute("salesmen", salesmen);



        model.addAttribute("salesman", new Salesman());
        return "salesSummary";
    }

    @PostMapping(path="/")
    public String save(Model model, Salesman salesman, BindingResult
            bindingResult, ModelMap mm, HttpSession session){


        if (bindingResult.hasErrors()) {
            System.out.println("Error in form submission");
            return "salesSummary";
        } else {
            System.out.println("Saving Salesman object");
            //SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            salesmanRepository.save(salesman);
            model.addAttribute("salesman", new Salesman());
            return "redirect:/";
        }
    }

    @GetMapping("/delete")
    public String delete (Long id){
        salesmanRepository.deleteById(id);
        return "redirect:/";
    }


}
