package sparta.scheduleApp2.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import org.springframework.stereotype.Repository;
import sparta.scheduleApp2.Entity.ScheduleEntity;
import sparta.scheduleApp2.Service.ScheduleService;

import java.util.List;
import java.util.Optional;

@Repository
public class ScheduleRepository {
    //속성
    private final EntityManagerFactory emf;

    //생성자
    public ScheduleRepository(EntityManagerFactory emf) {
        this.emf = emf;
    }

    //기능
/**
 * 일정 저장 (Low-Level JPA 방식: 수동으로 transaction 관리)
 * JpaRepository<ScheduleEntity, Long>를 상속 X
 */
public ScheduleEntity save(ScheduleEntity scheduleEntity) {
    //EntityManager 준비
    EntityManager entityManager = emf.createEntityManager();
    //Transaction 시작
    EntityTransaction transaction = entityManager.getTransaction();
    transaction.begin();
    //영속화
    entityManager.persist(scheduleEntity); // DB 저장
    //Transaction 커밋
    transaction.commit();
    //entityManager 반환
    entityManager.close();
    return scheduleEntity;
//    return scheduleRepository.save(scheduleEntity);
//    @Repository
//    public interface ScheduleRepository extends JpaRepository<ScheduleEntity, Long> {
//        // save(), findById(), findAll(), deleteById() 등을 자동 제공
//    }
}
    /**
     * 전체 일정 조회
     */
    public List<ScheduleEntity> findAll() {
        EntityManager entityManager = emf.createEntityManager();

        List<ScheduleEntity> scheduleList = entityManager
                .createQuery("SELECT s FROM ScheduleEntity s", ScheduleEntity.class)
                .getResultList();

        entityManager.close();
        return scheduleList;
    }
    /**
     * ID로 단건 조회
     */
    public Optional<ScheduleEntity> findById(Long id) {
        EntityManager entityManager = emf.createEntityManager();
        ScheduleEntity schedule = entityManager.find(ScheduleEntity.class, id);
        entityManager.close();

        return Optional.ofNullable(schedule);
    }
    /**
     * 일정 삭제
     */
    public void delete(ScheduleEntity scheduleEntity) {
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();
        ScheduleEntity managedEntity = entityManager.merge(scheduleEntity);
        entityManager.remove(managedEntity); // 삭제
        transaction.commit();

        entityManager.close();
    }

}
