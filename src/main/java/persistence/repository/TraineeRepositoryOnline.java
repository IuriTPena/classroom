package persistence.repository;

import persistence.domain.Trainee;
import util.JSONUtil;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.Collection;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

@Transactional(SUPPORTS)
@Default
public class TraineeRepositoryOnline implements ITraineeRepository {

    @PersistenceContext(unitName = "primary")
    private EntityManager manager;

    @Inject
    private JSONUtil jsonConverter;

    @Override
    @Transactional(REQUIRED)
    public String addTrainee(String tr) {
        Trainee trainee = jsonConverter.getObjectForJSON(tr, Trainee.class);
        manager.persist(trainee);

        return "{\"message\": \"trainee has been successfully added\"}";
    }

    @Override
    @Transactional(REQUIRED)
    public String updateTrainee(String tr) {
        Trainee trainee = jsonConverter.getObjectForJSON(tr, Trainee.class);
        if (manager.find(Trainee.class, trainee.getTraineeId()) != null)
            manager.merge(trainee);

        return "{\"message\": \"trainee has been successfully updated\"}";
    }

    @Override
    @Transactional(SUPPORTS)
    public String retrieveTrainee(Long traineeId) {
        Trainee trainee = findTrainee(traineeId);
        return jsonConverter.getJSONForObject(trainee);
    }

    @Override
    @Transactional(REQUIRED)
    public String deleteTrainee(Long traineeId) {
        Trainee trainee = findTrainee(traineeId);
        if (trainee != null) {
            manager.remove(trainee);
        }
        return "{\"message\": \"trainee successfully deleted\"}";
    }

    @Override
    public String getTrainees() {
        Query query = manager.createQuery("Select a FROM Trainee a");
        Collection<Trainee> trainees = (Collection<Trainee>) query.getResultList();
        return jsonConverter.getJSONForObject(trainees);
    }

    private Trainee findTrainee(Long id) {
        return manager.find(Trainee.class, id);
    }

    public void setManager(EntityManager manager) {
        this.manager = manager;
    }

    public void setJsonConverter(JSONUtil jsonConverter) {
        this.jsonConverter = jsonConverter;
    }

}
