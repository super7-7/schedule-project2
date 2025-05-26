package sparta.scheduleApp2.Service;

import org.springframework.stereotype.Service;
import sparta.scheduleApp2.Controller.ScheduleController;
import sparta.scheduleApp2.Dto.ScheduleRequestDto;
import sparta.scheduleApp2.Dto.ScheduleResponseDto;
import sparta.scheduleApp2.Entity.ScheduleEntity;
import sparta.scheduleApp2.Repository.ScheduleRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ScheduleService {

    //속성
    private final ScheduleRepository scheduleRepository;

    //생성자
    public ScheduleService(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    //기능

    //일정 생성
    public ScheduleResponseDto createSchedule(ScheduleRequestDto requestDto) {
        //Entity 객체 생성
        ScheduleEntity entity = new ScheduleEntity();
        //RequestDto->Entity
        entity.setUsername(requestDto.getUsername());
        entity.setTitle(requestDto.getTitle());
        entity.setContent(requestDto.getContent());

        //DB에 저장
        ScheduleEntity save = scheduleRepository.save(entity);

        //ResponseDto 반환
        ScheduleResponseDto responseDto = new ScheduleResponseDto(save);
        return responseDto;
    }
    //일정 전체 조회
    public List<ScheduleResponseDto> getAllSchedules() {
        List<ScheduleEntity> entityList = scheduleRepository.findAll();
        return entityList.stream()
                .map(ScheduleResponseDto::new)
                .toList();
    }

    //일정 단건 조회
    public ScheduleResponseDto getSchedule(Long id) {
        ScheduleEntity entity = scheduleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 일정이 존재하지 않습니다. ID: " + id));
        return new ScheduleResponseDto(entity);
    }

    //일정 수정
    public ScheduleResponseDto updateSchedule(Long id, ScheduleRequestDto requestDto) {
        ScheduleEntity entity = scheduleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 일정이 존재하지 않습니다. ID: " + id));

        entity.setUsername(requestDto.getUsername());
        entity.setTitle(requestDto.getTitle());
        entity.setContent(requestDto.getContent());
        entity.setUpdateAt(LocalDateTime.now());

        return new ScheduleResponseDto(entity);
    }

    //일정 삭제
        public void deleteSchedule(long id) {
            ScheduleEntity entity = scheduleRepository.findById(id)
                    .orElseThrow(() -> new IllegalArgumentException("해당 일정이 존재하지 않습니다. ID: " + id));
            scheduleRepository.delete(entity);
        }

}
