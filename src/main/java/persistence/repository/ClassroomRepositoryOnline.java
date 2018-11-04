package persistence.repository;

import persistence.domain.Classroom;
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
public class ClassroomRepositoryOnline implements IClassroomRepository {

    @PersistenceContext(unitName = "primary")
    private EntityManager manager;
    @Inject
    private ITraineeRepository traineeRepo;
    @Inject
    private JSONUtil jsonConverter;

    @Override
    @Transactional(REQUIRED)
    public String addClassroom(String cl) {
        Classroom classroom = jsonConverter.getObjectForJSON(cl, Classroom.class);
        manager.persist(classroom);
        return "{\"message\": \"classroom has been successfully added\"}";
    }

    @Override
    @Transactional(REQUIRED)
    public String updateClassroom(String tr) {
        Classroom classroom = jsonConverter.getObjectForJSON(tr, Classroom.class);
        if (manager.find(Classroom.class, classroom.getClassroomId()) != null)
            manager.merge(classroom);

        return "{\"message\": \"classroom has been successfully updated\"}";
    }

    @Override
    public String retrieveClassroom(Long classroomId) {
        Classroom classroom = findClassroom(classroomId);
        return jsonConverter.getJSONForObject(classroom);
    }

    @Override
    @Transactional(REQUIRED)
    public String deleteClassroom(Long classroomId) {
        Classroom classroom = findClassroom(classroomId);
        if (classroom != null) {
            manager.remove(classroom);
        }
        return "{\"message\": \"classroom successfully deleted\"}";
    }

    @Override
    public String getClassrooms() {
        Query query = manager.createQuery("Select a FROM Classroom a");
        Collection<Classroom> classrooms = (Collection<Classroom>) query.getResultList();
        return jsonConverter.getJSONForObject(classrooms);
    }

    private Classroom findClassroom(Long id) {
        return manager.find(Classroom.class, id);
    }

    public void setManager(EntityManager manager) {
        this.manager = manager;
    }

    public void setJsonConverter(JSONUtil jsonConverter) {
        this.jsonConverter = jsonConverter;
    }

}
