package ru.javabegin.tasklist.backendspringboot.search;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
// возможные значения, по которым можно искать задачи + значения сортировки
public class TaskSearchValues {

    // поля поиска (все типы - объектные, не примитивные. Чтобы можно было передать null)
    private String title;
    private Integer completed;
    private Long priorityId;
    private Long categoryId;

    // постраничность
    private Integer pageNumber;
    private Integer pageSize;

    // сортировка
    private String sortColumn;
    private String sortDirection;


}
