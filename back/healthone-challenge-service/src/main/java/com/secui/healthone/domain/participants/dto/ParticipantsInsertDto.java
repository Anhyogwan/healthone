package com.secui.healthone.domain.participants.dto;

import com.secui.healthone.domain.challenge.entity.Challenge;
import com.secui.healthone.domain.participants.entity.Participants;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@Schema(description = "챌린지 참가 DTO")
public class ParticipantsInsertDto {
    private Integer userNo; // 유저 식별번호
    private Integer challengeNo; // 챌린지 번호

    public ParticipantsInsertDto(Participants entity){
        this.userNo = entity.getUserNo();
        this.challengeNo = entity.getNo();
    }

    public Participants toEntity(){
        return Participants.builder()
                .userNo(userNo)
                .challengeNo(challengeNo)
                .build();
    }
}
