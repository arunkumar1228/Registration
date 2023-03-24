package com.web.Quiz.dto;

import com.web.Quiz.model.Answer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QuestionDto {
    private int qusId;

    private String questionName;

    private List<Answer> answers;
}
