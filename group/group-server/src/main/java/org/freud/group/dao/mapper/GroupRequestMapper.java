package org.freud.group.dao.mapper;

import org.freud.group.common.GroupRequestVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupRequestMapper {

    /***
     * 查询加群申请列表
     * @param groupId
     * @return
     */
    List<GroupRequestVO> queryGroupRequest(Integer groupId);

}
