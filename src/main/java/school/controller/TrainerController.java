
package school.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import school.entity.Trainer;
import school.service.TrainerService;

@Controller
@RequestMapping("/trainer")
public class TrainerController {
    
    @Autowired //kanei injection
    private TrainerService service;
    
    @RequestMapping
    public ModelAndView showTrainers(ModelAndView modelAndView){
        List<Trainer> trainers = service.getTrainers();
        modelAndView.addObject("listOfTrainers", trainers);
        modelAndView.setViewName("trainerList");
        return modelAndView;
    }
    
     /**
     * URLs
     * /trainer/create : GET  (trainerList.jsp - link)
     * /trainer/create : POST (trainerForm.jsp - form)
     */
    
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String showForm(){
        return "trainerForm";
    }
    
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(Trainer trainer, RedirectAttributes attributes){
        service.addTrainer(trainer);
        String minima = "Trainer "+ trainer.getLastName() + " successfully created!!";
        attributes.addFlashAttribute("message", minima);
        return "redirect:/trainer";//Redirect instructs client to sent a new GET request to /trainer
    }
    
    @GetMapping("/delete")
    public String delete(@RequestParam("id") int id, RedirectAttributes attributes){
        service.deleteTrainer(id);
        String minima = "Trainer successfully deleted!!";
        attributes.addFlashAttribute("message", minima);
        return "redirect:/trainer";
    }
    
    @GetMapping("/update/{trainerID}")
    public String showFormUpdate(@PathVariable("trainerID") int trainerID, Model model){
        Trainer trainer = service.getTrainerById(trainerID);
        model.addAttribute("trainerToEdit", trainer);
        return "trainerForm";
    }
    
    @PostMapping("/update")
    public String update(Trainer trainer, RedirectAttributes attributes){
        service.updateTrainer(trainer);
        String minima = "Trainer updated successfully!!";
        attributes.addFlashAttribute("message", minima);
        return "redirect:/trainer";
    }
    
}
