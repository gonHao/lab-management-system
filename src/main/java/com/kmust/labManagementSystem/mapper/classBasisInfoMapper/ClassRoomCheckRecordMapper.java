package com.kmust.labManagementSystem.mapper.classBasisInfoMapper;

import com.kmust.labManagementSystem.dao.classBasisInfo.CheckRecord;
import org.springframework.stereotype.Component;

@Component
public interface ClassRoomCheckRecordMapper {
    /**
     * 新增检查记录
     * @param checkRecord
     * @return
     */
    int insertRecord(CheckRecord checkRecord);
}
