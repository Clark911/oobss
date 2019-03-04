package com.oobss.repository;

import com.oobss.entity.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
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
public interface TaskRepository extends PagingAndSortingRepository<Task, Long> {
    /**
     * 根据日期和任务状态查询任务
     *
     * @param time
     * @param finished
     * @return
     */
    List<Task> findAllByTimeAndFinished(Date time, boolean finished);

    /**
     * 查询历史任务
     *
     * @param time
     * @param finished
     * @return
     */
    @Query("select t from Task t where t.time < :time and t.finished = :finished")
    List<Task> queryLastTask(@Param("time") Date time, @Param("finished") boolean finished);

    /**
     * 根据ID修改更新任务状态
     *
     * @param id
     * @param finished
     * @return
     */
    @Modifying
    @Query("update Task t set t.finished = :finished,t.time = :time where t.id = :id")
    Integer updateFinishById(@Param("id") Long id, @Param("finished") boolean finished, @Param("time") Date time);

    Page<Task> queryTasksByTimeAndFinished(Pageable pageable, Date date, boolean finished);
}
