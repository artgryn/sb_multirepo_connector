package com.artgr.mongoconnector.controller;

import com.artgr.mongoconnector.repo.core.PersonRepo;
import com.artgr.mongoconnector.repo.history.ShoppingHistoryRepo;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexController {

    @Autowired
    private PersonRepo personRepo;

    @Autowired
    private ShoppingHistoryRepo shoppingHistoryRepo;

    @RequestMapping(value = "")
    public String getIndexPage(@RequestParam(value="name", required=false) final String name,
                               final Model model) {

        val person = personRepo.findByFullName(name); // will go to core_db
        if (person != null) {

            val history = shoppingHistoryRepo.findAllByPersonId(person.getId()); // will go to history_db
            model.addAttribute("name", name);
            model.addAttribute("person", person);
            model.addAttribute("history", history);
        }

        return "index";
    }
}
