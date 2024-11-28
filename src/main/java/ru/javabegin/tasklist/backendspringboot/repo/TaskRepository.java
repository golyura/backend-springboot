package ru.javabegin.tasklist.backendspringboot.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.javabegin.tasklist.backendspringboot.entity.Task;

import java.util.List;

// принцип ООП: абстракция-реализация - здесь описываем все доступные способы доступа к данным
@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    
    // учитываем, что параметр может быть null или пустым
    @Query("SELECT p FROM Task p where " +
            "(:text2 is null or :text2='' or lower(p.title) like lower(concat('%', :text2,'%'))) and" +
            "(:completed is null or p.completed=:completed) and " +
            "(:priorityId is null or p.priority.id=:priorityId) and " +
            "(:categoryId is null or p.category.id=:categoryId)"
    )
    List<Task> findByParams(@Param("text2") String text, @Param("completed") Integer completed, @Param("priorityId") Long priorityId, @Param("categoryId") Long categoryId);

}
