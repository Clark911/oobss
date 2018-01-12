package com.oobss.repository;

import com.oobss.entity.Task;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

/**
 * Created by clarkzhao on 2017/12/30.
 *
 * @author clarkzhao
 * @date 2017/12/30
 */
public interface TaskRepository extends PagingAndSortingRepository<Task,Long> {
    /**
     * 根据日期和任务状态查询任务
     * @param time
     * @param isFinished
     * @return
     */
    List<Task> findAllByTimeAndIsFinished(Date time,boolean isFinished);

    /**
     * 查询历史任务
     * @param time
     * @param isFinished
     * @return
     */
    @Query("select t from Task t where t.time < :time and t.isFinished = :isFinished")
    List<Task> queryLastTask(@Param("time") Date time, @Param("isFinished") boolean isFinished);

}
