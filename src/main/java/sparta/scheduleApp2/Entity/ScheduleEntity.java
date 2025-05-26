package sparta.scheduleApp2.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class ScheduleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    //속성
    private Long scheduleId;
    private String username;
    private String title;
    private String content;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;

    //생성자

    //기능

}
