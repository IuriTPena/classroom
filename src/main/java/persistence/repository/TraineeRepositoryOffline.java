package persistence.repository;

import persistence.domain.Trainee;
import util.JSONUtil;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@ApplicationScoped
@Alternative
public class TraineeRepositoryOffline implements ITraineeRepository {

    private Map<Long, Trainee> trainees = new HashMap<>();

    @Inject
    private JSONUtil jsonConverter;

    @Override
    public String addTrainee(String tr) {
        Trainee trainee = jsonConverter.getObjectForJSON(tr, Trainee.class);
        trainees.put(trainee.getTraineeId(), trainee);
        return "{\"message\": \"trainee has been successfully added\"}";
    }

    @Override
    public String retrieveTrainee(Long traineeId) {
        return jsonConverter.getJSONForObject(trainees.get(traineeId));
    }

    @Override
    public String updateTrainee(String tr) {
        Trainee account = jsonConverter.getObjectForJSON(tr, Trainee.class);
        trainees.replace(account.getTraineeId(), account);
        return "{\"message\": \"trainee has been sucessfully updated\"}";
    }

    @Override
    public String deleteTrainee(Long traineeId) {
        trainees.remove(traineeId);
        return "{\"message\": \"trainee sucessfully deleted\"}";
    }

    @Override
    public String getTrainees() {
        Collection<Trainee> values = trainees.values();
        return jsonConverter.getJSONForObject(values);
    }
}
