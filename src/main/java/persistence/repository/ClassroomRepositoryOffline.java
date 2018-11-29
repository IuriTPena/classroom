package persistence.repository;

import persistence.domain.Classroom;
import util.JSONUtil;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@ApplicationScoped
@Alternative
public class ClassroomRepositoryOffline implements IClassroomRepository {

    private Map<Long, Classroom> classrooms = new HashMap<>();

    @Inject
    private JSONUtil jsonConverter;

    @Override
    public String addClassroom(String cl) {
        Classroom classroom = jsonConverter.getObjectForJSON(cl, Classroom.class);
        classrooms.put(classroom.getClassroomId(), classroom);
        return "{\"message\": \"classroom has been successfully added\"}";
    }

    @Override
    public String retrieveClassroom(Long classroomId) {
        return jsonConverter.getJSONForObject(classrooms.get(classroomId));
    }

    @Override
    public String updateClassroom(String cl) {
        Classroom account = jsonConverter.getObjectForJSON(cl, Classroom.class);
        classrooms.replace(account.getClassroomId(), account);
        return "{\"message\": \"classroom has been sucessfully updated\"}";
    }

    @Override
    public String deleteClassroom(Long classroomId) {
        classrooms.remove(classroomId);
        return "{\"message\": \"classroom sucessfully deleted\"}";
    }

    @Override
    public String getClassrooms() {
        Collection<Classroom> values = classrooms.values();
        return jsonConverter.getJSONForObject(values);
    }
}
