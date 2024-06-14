package co.develhope.serviziLogging.controllers;

import co.develhope.serviziLogging.exceptions.CustomError;
import co.develhope.serviziLogging.services.BasicService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class BasicController {

    @Autowired
    BasicService basicService;

    private static final Logger logger = LoggerFactory.getLogger(BasicController.class);

    @GetMapping
    public String welcomeMessage() {
        String welcomeMessage = "Welcome Message";
        logger.info(welcomeMessage);
        return welcomeMessage;
    }

    @GetMapping("/exp")
    public int calculateExp (){
        logger.info("Exponent of the 2 custom variables");
        int exp = basicService.getExp();
        logger.info("Finish the calculation");
        return exp;
    }

    @GetMapping("/get-errors")
    public void customError(){
        logger.error("Custom error");
        throw new CustomError("This is a custom error");
    }
}
