
package school.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import school.entity.Trainer;
import school.repository.TrainerRepo;

@Transactional
@Service
public class TrainerService {
    
    @Autowired
    TrainerRepo trainerRepo;
    
    public List<Trainer> getTrainers(){
        List<Trainer> trainers = trainerRepo.findAll();
        return trainers;
    }
    
    public void addTrainer(Trainer trainer){
        trainerRepo.save(trainer);
    }
    
    public void deleteTrainer(int id){
        trainerRepo.delete(Trainer.class, id);
    }
    
    public Trainer getTrainerById(int trainerID){
        return trainerRepo.find(trainerID);
    }
    
    public Trainer updateTrainer(Trainer trainer){
        return trainerRepo.save(trainer);
    }
}
