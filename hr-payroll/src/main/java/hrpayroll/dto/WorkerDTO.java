package hrpayroll.dto;

import lombok.Data;

@Data
public class WorkerDTO {
    private Long id;
    private String name;
    private Double dailyIncome;
}