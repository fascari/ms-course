package hrpayroll.services;

import hrpayroll.entities.Payment;

import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    /*@Autowired
    private WorkerFeignClient workerFeignClient;*/

    public Payment getPayment(long workerId, int days) {
        //Worker worker = workerFeignClient.findById(workerId).getBody();
        return new Payment("Bob", 200.0, days);
    }
}