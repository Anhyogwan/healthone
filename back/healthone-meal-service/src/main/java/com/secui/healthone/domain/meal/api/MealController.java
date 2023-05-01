package com.secui.healthone.domain.meal.api;

import com.secui.healthone.domain.meal.dto.MealReqDto;
import com.secui.healthone.domain.meal.dto.MealResDto;
import com.secui.healthone.domain.meal.service.MealService;
import com.secui.healthone.global.response.RestApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/api/meal")
@RequiredArgsConstructor
public class MealController {

    private final MealService mealService;

    @GetMapping
    public RestApiResponse<MealResDto> getMeal(@RequestParam("no") Integer no) {
        return new RestApiResponse<>("식사 정보 단일 조회 성공", mealService.getMeal(no));
    }

    @GetMapping("/list")
    public RestApiResponse<List<MealResDto>> getMealList(@RequestParam("date") String date, @RequestParam("userno") Integer userNo) throws ParseException {
        return new RestApiResponse<>(date+ "날짜 식사 리스트 조회 성공", mealService.getMealList(date, userNo));
    }
    
    @PostMapping
    public RestApiResponse<MealResDto> insertMeal(@RequestBody MealReqDto requestDto) {
        return new RestApiResponse<>("식사 등록 성공", mealService.insertMeal(requestDto));
    }

    @PatchMapping
    public RestApiResponse<MealResDto> updateMeal(@RequestBody MealReqDto requestDto) {
        return new RestApiResponse<>("식사 수정 성공", mealService.insertMeal(requestDto));
    }

    @DeleteMapping
    public RestApiResponse<Void> updateMeal(@RequestParam("no") Integer no) {
        mealService.deleteMeal(no);
        return new RestApiResponse<>("식사 삭제 성공", null);
    }
}
