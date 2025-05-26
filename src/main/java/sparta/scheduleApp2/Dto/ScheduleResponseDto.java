package sparta.scheduleApp2.Dto;

import sparta.scheduleApp2.Entity.ScheduleEntity;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ScheduleResponseDto {

    //속성
    private long scheduleId;
    private String username;
    private String title;
    private String content;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;

    //생성자
    public ScheduleResponseDto(ScheduleEntity scheduleEntity){
        this.scheduleId = scheduleEntity.getScheduleId();
        this.username = scheduleEntity.getUsername();
        this.title = scheduleEntity.getTitle();
        this.content = scheduleEntity.getContent();
        this.createAt = scheduleEntity.getCreateAt();
        this.updateAt = scheduleEntity.getUpdateAt();
    }

    //기능
}
