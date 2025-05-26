package sparta.scheduleApp2.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sparta.scheduleApp2.Dto.ScheduleRequestDto;
import sparta.scheduleApp2.Dto.ScheduleResponseDto;
import sparta.scheduleApp2.Service.ScheduleService;

@RestController
@RequestMapping("/api/schedules")
public class ScheduleController {
    //속성
    private final ScheduleService scheduleService;

    //생성자
    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    //기능
    @PostMapping
    public ResponseEntity<ScheduleResponseDto> createSchedule(@RequestBody ScheduleRequestDto requestDto){
        ScheduleResponseDto responseDto = scheduleService.createSchedule(requestDto);
        return ResponseEntity.ok(responseDto);
    }
}
