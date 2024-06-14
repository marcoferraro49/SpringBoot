package co.develhope.serviziLogging.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class BasicService {

    private static final Logger logger = LoggerFactory.getLogger(BasicService.class);

    @Value("${customVar1}")
    private int var1;

    @Value("${customVar2}")
    private int var2;

    public int getExp(){
        logger.debug("Calculation start");
        int result = (int) Math.pow(var1, var2);
        logger.debug("Calculation finish");
        return result;
    }


}
