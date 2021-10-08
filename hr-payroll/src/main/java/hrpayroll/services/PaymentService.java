package hrpayroll.services;

import hrpayroll.dto.WorkerDTO;
import hrpayroll.entities.Payment;
import hrpayroll.feignclients.WorkerFeignClient;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PaymentService {

    @Autowired
    private WorkerFeignClient workerFeignClient;

    public Payment getPayment(long workerId, int days) {
        WorkerDTO workerDTO = workerFeignClient.findById(workerId).getBody();
        if (workerDTO == null) {
            log.debug("Não foi encontrado um worker com o id informado!");
            return new Payment();
        }
        return new Payment(workerDTO.getName(), workerDTO.getDailyIncome(), days);
    }
}