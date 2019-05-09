package hu.flowacademy.todolist.repository;

import hu.flowacademy.todolist.domain.SubtaskItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubtaskItemRepository extends JpaRepository<SubtaskItem, Long> {

    List<SubtaskItem> findByTodoItem_Id(String id);

}
