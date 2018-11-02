package service;

import persistence.repository.ITraineeRepository;

import javax.inject.Inject;

public class TraineeService implements ITraineeService {

    @Inject
    private ITraineeRepository traineeRepo;

    public String addTrainee(String account) {
        return traineeRepo.addTrainee(account);
    }

    public String retrieveTrainee(Long traineeId) {
        return traineeRepo.retrieveTrainee(traineeId);
    }

    public String updateTrainee(String trainee) {
        return traineeRepo.updateTrainee(trainee);
    }

    public String deleteTrainee(Long traineeId) {
        return traineeRepo.deleteTrainee(traineeId);
    }

    public String getTrainees() {
        return traineeRepo.getTrainees();
    }
}
